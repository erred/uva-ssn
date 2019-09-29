package com.j256.ormlite.field;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.BaseForeignCollection;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.EagerForeignCollection;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.dao.LazyForeignCollection;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.field.types.VoidType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.p127db.DatabaseType;
import com.j256.ormlite.stmt.mapped.MappedQueryForId;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.DatabaseResults;
import com.j256.ormlite.table.DatabaseTableConfig;
import com.j256.ormlite.table.TableInfo;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

public class FieldType {
    private static boolean DEFAULT_VALUE_BOOLEAN = false;
    private static byte DEFAULT_VALUE_BYTE = 0;
    private static char DEFAULT_VALUE_CHAR = '\u0000';
    private static double DEFAULT_VALUE_DOUBLE = 0.0d;
    private static float DEFAULT_VALUE_FLOAT = 0.0f;
    private static int DEFAULT_VALUE_INT = 0;
    private static long DEFAULT_VALUE_LONG = 0;
    private static short DEFAULT_VALUE_SHORT = 0;
    public static final String FOREIGN_ID_FIELD_SUFFIX = "_id";
    private static final ThreadLocal<LevelCounters> threadLevelCounters = new ThreadLocal<LevelCounters>() {
        /* access modifiers changed from: protected */
        public LevelCounters initialValue() {
            return new LevelCounters();
        }
    };
    private final String columnName;
    private final ConnectionSource connectionSource;
    private DataPersister dataPersister;
    private Object dataTypeConfigObj;
    private Object defaultValue;
    private final Field field;
    private final DatabaseFieldConfig fieldConfig;
    private FieldConverter fieldConverter;
    private final Method fieldGetMethod;
    private final Method fieldSetMethod;
    private BaseDaoImpl<?, ?> foreignDao;
    private FieldType foreignFieldType;
    private FieldType foreignIdField;
    private TableInfo<?, ?> foreignTableInfo;
    private final String generatedIdSequence;
    private final boolean isGeneratedId;
    private final boolean isId;
    private MappedQueryForId<Object, Object> mappedQueryForId;
    private final String tableName;

    private static class LevelCounters {
        int autoRefreshLevel;
        int autoRefreshLevelMax;
        int foreignCollectionLevel;
        int foreignCollectionLevelMax;

        private LevelCounters() {
        }
    }

    public FieldType(ConnectionSource connectionSource2, String str, Field field2, DatabaseFieldConfig databaseFieldConfig, Class<?> cls) throws SQLException {
        DataPersister dataPersister2;
        String sb;
        this.connectionSource = connectionSource2;
        this.tableName = str;
        DatabaseType databaseType = connectionSource2.getDatabaseType();
        this.field = field2;
        databaseFieldConfig.postProcess();
        Class<Collection> type = field2.getType();
        if (databaseFieldConfig.getDataPersister() == null) {
            Class<VoidType> persisterClass = databaseFieldConfig.getPersisterClass();
            if (persisterClass == null || persisterClass == VoidType.class) {
                dataPersister2 = DataPersisterManager.lookupForField(field2);
            } else {
                try {
                    try {
                        Object invoke = persisterClass.getDeclaredMethod("getSingleton", new Class[0]).invoke(null, new Object[0]);
                        if (invoke != null) {
                            try {
                                dataPersister2 = (DataPersister) invoke;
                            } catch (Exception e) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("Could not cast result of static getSingleton method to DataPersister from class ");
                                sb2.append(persisterClass);
                                throw SqlExceptionUtil.create(sb2.toString(), e);
                            }
                        } else {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("Static getSingleton method should not return null on class ");
                            sb3.append(persisterClass);
                            throw new SQLException(sb3.toString());
                        }
                    } catch (InvocationTargetException e2) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("Could not run getSingleton method on class ");
                        sb4.append(persisterClass);
                        throw SqlExceptionUtil.create(sb4.toString(), e2.getTargetException());
                    } catch (Exception e3) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("Could not run getSingleton method on class ");
                        sb5.append(persisterClass);
                        throw SqlExceptionUtil.create(sb5.toString(), e3);
                    }
                } catch (Exception e4) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("Could not find getSingleton static method on class ");
                    sb6.append(persisterClass);
                    throw SqlExceptionUtil.create(sb6.toString(), e4);
                }
            }
        } else {
            dataPersister2 = databaseFieldConfig.getDataPersister();
            if (!dataPersister2.isValidForField(field2)) {
                StringBuilder sb7 = new StringBuilder();
                sb7.append("Field class ");
                sb7.append(type.getName());
                sb7.append(" for field ");
                sb7.append(this);
                sb7.append(" is not valid for type ");
                sb7.append(dataPersister2);
                Class primaryClass = dataPersister2.getPrimaryClass();
                if (primaryClass != null) {
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append(", maybe should be ");
                    sb8.append(primaryClass);
                    sb7.append(sb8.toString());
                }
                throw new IllegalArgumentException(sb7.toString());
            }
        }
        String foreignColumnName = databaseFieldConfig.getForeignColumnName();
        String name = field2.getName();
        if (databaseFieldConfig.isForeign() || databaseFieldConfig.isForeignAutoRefresh() || foreignColumnName != null) {
            if (dataPersister2 == null || !dataPersister2.isPrimitive()) {
                if (foreignColumnName == null) {
                    StringBuilder sb9 = new StringBuilder();
                    sb9.append(name);
                    sb9.append(FOREIGN_ID_FIELD_SUFFIX);
                    sb = sb9.toString();
                } else {
                    StringBuilder sb10 = new StringBuilder();
                    sb10.append(name);
                    sb10.append("_");
                    sb10.append(foreignColumnName);
                    sb = sb10.toString();
                }
                name = sb;
                if (ForeignCollection.class.isAssignableFrom(type)) {
                    StringBuilder sb11 = new StringBuilder();
                    sb11.append("Field '");
                    sb11.append(field2.getName());
                    sb11.append("' in class ");
                    sb11.append(type);
                    sb11.append("' should use the @");
                    sb11.append(ForeignCollectionField.class.getSimpleName());
                    sb11.append(" annotation not foreign=true");
                    throw new SQLException(sb11.toString());
                }
            } else {
                StringBuilder sb12 = new StringBuilder();
                sb12.append("Field ");
                sb12.append(this);
                sb12.append(" is a primitive class ");
                sb12.append(type);
                sb12.append(" but marked as foreign");
                throw new IllegalArgumentException(sb12.toString());
            }
        } else if (databaseFieldConfig.isForeignCollection()) {
            if (type == Collection.class || ForeignCollection.class.isAssignableFrom(type)) {
                Type genericType = field2.getGenericType();
                if (!(genericType instanceof ParameterizedType)) {
                    StringBuilder sb13 = new StringBuilder();
                    sb13.append("Field class for '");
                    sb13.append(field2.getName());
                    sb13.append("' must be a parameterized Collection.");
                    throw new SQLException(sb13.toString());
                } else if (((ParameterizedType) genericType).getActualTypeArguments().length == 0) {
                    StringBuilder sb14 = new StringBuilder();
                    sb14.append("Field class for '");
                    sb14.append(field2.getName());
                    sb14.append("' must be a parameterized Collection with at least 1 type.");
                    throw new SQLException(sb14.toString());
                }
            } else {
                StringBuilder sb15 = new StringBuilder();
                sb15.append("Field class for '");
                sb15.append(field2.getName());
                sb15.append("' must be of class ");
                sb15.append(ForeignCollection.class.getSimpleName());
                sb15.append(" or Collection.");
                throw new SQLException(sb15.toString());
            }
        } else if (dataPersister2 == null && !databaseFieldConfig.isForeignCollection()) {
            if (byte[].class.isAssignableFrom(type)) {
                StringBuilder sb16 = new StringBuilder();
                sb16.append("ORMLite does not know how to store ");
                sb16.append(type);
                sb16.append(" for field '");
                sb16.append(field2.getName());
                sb16.append("'. byte[] fields must specify dataType=DataType.BYTE_ARRAY or SERIALIZABLE");
                throw new SQLException(sb16.toString());
            } else if (Serializable.class.isAssignableFrom(type)) {
                StringBuilder sb17 = new StringBuilder();
                sb17.append("ORMLite does not know how to store ");
                sb17.append(type);
                sb17.append(" for field '");
                sb17.append(field2.getName());
                sb17.append("'.  Use another class, custom persister, or to serialize it use ");
                sb17.append("dataType=DataType.SERIALIZABLE");
                throw new SQLException(sb17.toString());
            } else {
                StringBuilder sb18 = new StringBuilder();
                sb18.append("ORMLite does not know how to store ");
                sb18.append(type);
                sb18.append(" for field ");
                sb18.append(field2.getName());
                sb18.append(". Use another class or a custom persister.");
                throw new IllegalArgumentException(sb18.toString());
            }
        }
        if (databaseFieldConfig.getColumnName() == null) {
            this.columnName = name;
        } else {
            this.columnName = databaseFieldConfig.getColumnName();
        }
        this.fieldConfig = databaseFieldConfig;
        if (databaseFieldConfig.isId()) {
            if (databaseFieldConfig.isGeneratedId() || databaseFieldConfig.getGeneratedIdSequence() != null) {
                StringBuilder sb19 = new StringBuilder();
                sb19.append("Must specify one of id, generatedId, and generatedIdSequence with ");
                sb19.append(field2.getName());
                throw new IllegalArgumentException(sb19.toString());
            }
            this.isId = true;
            this.isGeneratedId = false;
            this.generatedIdSequence = null;
        } else if (databaseFieldConfig.isGeneratedId()) {
            if (databaseFieldConfig.getGeneratedIdSequence() == null) {
                this.isId = true;
                this.isGeneratedId = true;
                if (databaseType.isIdSequenceNeeded()) {
                    this.generatedIdSequence = databaseType.generateIdSequenceName(str, this);
                } else {
                    this.generatedIdSequence = null;
                }
            } else {
                StringBuilder sb20 = new StringBuilder();
                sb20.append("Must specify one of id, generatedId, and generatedIdSequence with ");
                sb20.append(field2.getName());
                throw new IllegalArgumentException(sb20.toString());
            }
        } else if (databaseFieldConfig.getGeneratedIdSequence() != null) {
            this.isId = true;
            this.isGeneratedId = true;
            String generatedIdSequence2 = databaseFieldConfig.getGeneratedIdSequence();
            if (databaseType.isEntityNamesMustBeUpCase()) {
                generatedIdSequence2 = generatedIdSequence2.toUpperCase();
            }
            this.generatedIdSequence = generatedIdSequence2;
        } else {
            this.isId = false;
            this.isGeneratedId = false;
            this.generatedIdSequence = null;
        }
        if (!this.isId || (!databaseFieldConfig.isForeign() && !databaseFieldConfig.isForeignAutoRefresh())) {
            if (databaseFieldConfig.isUseGetSet()) {
                this.fieldGetMethod = DatabaseFieldConfig.findGetMethod(field2, true);
                this.fieldSetMethod = DatabaseFieldConfig.findSetMethod(field2, true);
            } else {
                if (!field2.isAccessible()) {
                    try {
                        this.field.setAccessible(true);
                    } catch (SecurityException unused) {
                        StringBuilder sb21 = new StringBuilder();
                        sb21.append("Could not open access to field ");
                        sb21.append(field2.getName());
                        sb21.append(".  You may have to set useGetSet=true to fix.");
                        throw new IllegalArgumentException(sb21.toString());
                    }
                }
                this.fieldGetMethod = null;
                this.fieldSetMethod = null;
            }
            if (databaseFieldConfig.isAllowGeneratedIdInsert() && !databaseFieldConfig.isGeneratedId()) {
                StringBuilder sb22 = new StringBuilder();
                sb22.append("Field ");
                sb22.append(field2.getName());
                sb22.append(" must be a generated-id if allowGeneratedIdInsert = true");
                throw new IllegalArgumentException(sb22.toString());
            } else if (databaseFieldConfig.isForeignAutoRefresh() && !databaseFieldConfig.isForeign()) {
                StringBuilder sb23 = new StringBuilder();
                sb23.append("Field ");
                sb23.append(field2.getName());
                sb23.append(" must have foreign = true if foreignAutoRefresh = true");
                throw new IllegalArgumentException(sb23.toString());
            } else if (databaseFieldConfig.isForeignAutoCreate() && !databaseFieldConfig.isForeign()) {
                StringBuilder sb24 = new StringBuilder();
                sb24.append("Field ");
                sb24.append(field2.getName());
                sb24.append(" must have foreign = true if foreignAutoCreate = true");
                throw new IllegalArgumentException(sb24.toString());
            } else if (databaseFieldConfig.getForeignColumnName() != null && !databaseFieldConfig.isForeign()) {
                StringBuilder sb25 = new StringBuilder();
                sb25.append("Field ");
                sb25.append(field2.getName());
                sb25.append(" must have foreign = true if foreignColumnName is set");
                throw new IllegalArgumentException(sb25.toString());
            } else if (databaseFieldConfig.isVersion() && (dataPersister2 == null || !dataPersister2.isValidForVersion())) {
                StringBuilder sb26 = new StringBuilder();
                sb26.append("Field ");
                sb26.append(field2.getName());
                sb26.append(" is not a valid type to be a version field");
                throw new IllegalArgumentException(sb26.toString());
            } else if (databaseFieldConfig.getMaxForeignAutoRefreshLevel() <= 0 || databaseFieldConfig.isForeignAutoRefresh()) {
                assignDataType(databaseType, dataPersister2);
            } else {
                StringBuilder sb27 = new StringBuilder();
                sb27.append("Field ");
                sb27.append(field2.getName());
                sb27.append(" has maxForeignAutoRefreshLevel set but not foreignAutoRefresh is false");
                throw new IllegalArgumentException(sb27.toString());
            }
        } else {
            StringBuilder sb28 = new StringBuilder();
            sb28.append("Id field ");
            sb28.append(field2.getName());
            sb28.append(" cannot also be a foreign object");
            throw new IllegalArgumentException(sb28.toString());
        }
    }

    public void configDaoInformation(ConnectionSource connectionSource2, Class<?> cls) throws SQLException {
        TableInfo<?, ?> tableInfo;
        FieldType fieldType;
        FieldType fieldType2;
        BaseDaoImpl<?, ?> baseDaoImpl;
        BaseDaoImpl<?, ?> baseDaoImpl2;
        BaseDaoImpl<?, ?> baseDaoImpl3;
        BaseDaoImpl<?, ?> baseDaoImpl4;
        Class<Collection> type = this.field.getType();
        DatabaseType databaseType = connectionSource2.getDatabaseType();
        String foreignColumnName = this.fieldConfig.getForeignColumnName();
        MappedQueryForId<Object, Object> mappedQueryForId2 = null;
        if (this.fieldConfig.isForeignAutoRefresh() || foreignColumnName != null) {
            DatabaseTableConfig foreignTableConfig = this.fieldConfig.getForeignTableConfig();
            if (foreignTableConfig == null) {
                baseDaoImpl2 = (BaseDaoImpl) DaoManager.createDao(connectionSource2, type);
                tableInfo = baseDaoImpl2.getTableInfo();
            } else {
                foreignTableConfig.extractFieldTypes(connectionSource2);
                baseDaoImpl2 = (BaseDaoImpl) DaoManager.createDao(connectionSource2, foreignTableConfig);
                tableInfo = baseDaoImpl2.getTableInfo();
            }
            if (foreignColumnName == null) {
                fieldType2 = tableInfo.getIdField();
                if (fieldType2 == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Foreign field ");
                    sb.append(type);
                    sb.append(" does not have id field");
                    throw new IllegalArgumentException(sb.toString());
                }
            } else {
                FieldType fieldTypeByColumnName = tableInfo.getFieldTypeByColumnName(foreignColumnName);
                if (fieldTypeByColumnName != null) {
                    fieldType2 = fieldTypeByColumnName;
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Foreign field ");
                    sb2.append(type);
                    sb2.append(" does not have field named '");
                    sb2.append(foreignColumnName);
                    sb2.append("'");
                    throw new IllegalArgumentException(sb2.toString());
                }
            }
            baseDaoImpl = baseDaoImpl2;
            fieldType = null;
            mappedQueryForId2 = MappedQueryForId.build(databaseType, tableInfo, fieldType2);
        } else if (this.fieldConfig.isForeign()) {
            if (this.dataPersister == null || !this.dataPersister.isPrimitive()) {
                DatabaseTableConfig foreignTableConfig2 = this.fieldConfig.getForeignTableConfig();
                if (foreignTableConfig2 != null) {
                    foreignTableConfig2.extractFieldTypes(connectionSource2);
                    baseDaoImpl4 = (BaseDaoImpl) DaoManager.createDao(connectionSource2, foreignTableConfig2);
                } else {
                    baseDaoImpl4 = (BaseDaoImpl) DaoManager.createDao(connectionSource2, type);
                }
                tableInfo = baseDaoImpl4.getTableInfo();
                fieldType2 = tableInfo.getIdField();
                if (fieldType2 == null) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Foreign field ");
                    sb3.append(type);
                    sb3.append(" does not have id field");
                    throw new IllegalArgumentException(sb3.toString());
                } else if (!isForeignAutoCreate() || fieldType2.isGeneratedId()) {
                    baseDaoImpl = baseDaoImpl4;
                    fieldType = null;
                } else {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Field ");
                    sb4.append(this.field.getName());
                    sb4.append(", if foreignAutoCreate = true then class ");
                    sb4.append(type.getSimpleName());
                    sb4.append(" must have id field with generatedId = true");
                    throw new IllegalArgumentException(sb4.toString());
                }
            } else {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Field ");
                sb5.append(this);
                sb5.append(" is a primitive class ");
                sb5.append(type);
                sb5.append(" but marked as foreign");
                throw new IllegalArgumentException(sb5.toString());
            }
        } else if (!this.fieldConfig.isForeignCollection()) {
            fieldType = null;
            tableInfo = null;
            baseDaoImpl = null;
            fieldType2 = null;
        } else if (type == Collection.class || ForeignCollection.class.isAssignableFrom(type)) {
            Type genericType = this.field.getGenericType();
            if (genericType instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType) genericType).getActualTypeArguments();
                if (actualTypeArguments.length != 0) {
                    Class cls2 = (Class) actualTypeArguments[0];
                    DatabaseTableConfig foreignTableConfig3 = this.fieldConfig.getForeignTableConfig();
                    if (foreignTableConfig3 == null) {
                        baseDaoImpl3 = (BaseDaoImpl) DaoManager.createDao(connectionSource2, cls2);
                    } else {
                        baseDaoImpl3 = (BaseDaoImpl) DaoManager.createDao(connectionSource2, foreignTableConfig3);
                    }
                    FieldType findForeignFieldType = findForeignFieldType(cls2, cls, baseDaoImpl3);
                    baseDaoImpl = baseDaoImpl3;
                    fieldType = findForeignFieldType;
                    tableInfo = null;
                    fieldType2 = null;
                } else {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("Field class for '");
                    sb6.append(this.field.getName());
                    sb6.append("' must be a parameterized Collection with at least 1 type.");
                    throw new SQLException(sb6.toString());
                }
            } else {
                StringBuilder sb7 = new StringBuilder();
                sb7.append("Field class for '");
                sb7.append(this.field.getName());
                sb7.append("' must be a parameterized Collection.");
                throw new SQLException(sb7.toString());
            }
        } else {
            StringBuilder sb8 = new StringBuilder();
            sb8.append("Field class for '");
            sb8.append(this.field.getName());
            sb8.append("' must be of class ");
            sb8.append(ForeignCollection.class.getSimpleName());
            sb8.append(" or Collection.");
            throw new SQLException(sb8.toString());
        }
        this.mappedQueryForId = mappedQueryForId2;
        this.foreignTableInfo = tableInfo;
        this.foreignFieldType = fieldType;
        this.foreignDao = baseDaoImpl;
        this.foreignIdField = fieldType2;
        if (this.foreignIdField != null) {
            assignDataType(databaseType, this.foreignIdField.getDataPersister());
        }
    }

    public Field getField() {
        return this.field;
    }

    public String getTableName() {
        return this.tableName;
    }

    public String getFieldName() {
        return this.field.getName();
    }

    public Class<?> getType() {
        return this.field.getType();
    }

    public String getColumnName() {
        return this.columnName;
    }

    public DataPersister getDataPersister() {
        return this.dataPersister;
    }

    public Object getDataTypeConfigObj() {
        return this.dataTypeConfigObj;
    }

    public SqlType getSqlType() {
        return this.fieldConverter.getSqlType();
    }

    public Object getDefaultValue() {
        return this.defaultValue;
    }

    public int getWidth() {
        return this.fieldConfig.getWidth();
    }

    public boolean isCanBeNull() {
        return this.fieldConfig.isCanBeNull();
    }

    public boolean isId() {
        return this.isId;
    }

    public boolean isGeneratedId() {
        return this.isGeneratedId;
    }

    public boolean isGeneratedIdSequence() {
        return this.generatedIdSequence != null;
    }

    public String getGeneratedIdSequence() {
        return this.generatedIdSequence;
    }

    public boolean isForeign() {
        return this.fieldConfig.isForeign();
    }

    public void assignField(Object obj, Object obj2, boolean z, ObjectCache objectCache) throws SQLException {
        DatabaseConnection readOnlyConnection;
        if (!(this.foreignIdField == null || obj2 == null)) {
            Object extractJavaFieldValue = extractJavaFieldValue(obj);
            if (extractJavaFieldValue != null && extractJavaFieldValue.equals(obj2)) {
                return;
            }
            if (!z) {
                LevelCounters levelCounters = (LevelCounters) threadLevelCounters.get();
                if (levelCounters.autoRefreshLevel == 0) {
                    levelCounters.autoRefreshLevelMax = this.fieldConfig.getMaxForeignAutoRefreshLevel();
                }
                if (levelCounters.autoRefreshLevel >= levelCounters.autoRefreshLevelMax) {
                    Object createObject = this.foreignTableInfo.createObject();
                    this.foreignIdField.assignField(createObject, obj2, false, objectCache);
                    obj2 = createObject;
                } else {
                    if (this.mappedQueryForId == null) {
                        this.mappedQueryForId = MappedQueryForId.build(this.connectionSource.getDatabaseType(), this.foreignDao.getTableInfo(), this.foreignIdField);
                    }
                    levelCounters.autoRefreshLevel++;
                    try {
                        readOnlyConnection = this.connectionSource.getReadOnlyConnection();
                        obj2 = this.mappedQueryForId.execute(readOnlyConnection, obj2, objectCache);
                        this.connectionSource.releaseConnection(readOnlyConnection);
                        levelCounters.autoRefreshLevel--;
                    } catch (Throwable th) {
                        levelCounters.autoRefreshLevel--;
                        throw th;
                    }
                }
            }
        }
        if (this.fieldSetMethod == null) {
            try {
                this.field.set(obj, obj2);
            } catch (IllegalArgumentException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Could not assign object '");
                sb.append(obj2);
                sb.append("' to field ");
                sb.append(this);
                throw SqlExceptionUtil.create(sb.toString(), e);
            } catch (IllegalAccessException e2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Could not assign object '");
                sb2.append(obj2);
                sb2.append("' to field ");
                sb2.append(this);
                throw SqlExceptionUtil.create(sb2.toString(), e2);
            }
        } else {
            try {
                this.fieldSetMethod.invoke(obj, new Object[]{obj2});
            } catch (Exception e3) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Could not call ");
                sb3.append(this.fieldSetMethod);
                sb3.append(" on object with '");
                sb3.append(obj2);
                sb3.append("' for ");
                sb3.append(this);
                throw SqlExceptionUtil.create(sb3.toString(), e3);
            }
        }
    }

    public Object assignIdValue(Object obj, Number number, ObjectCache objectCache) throws SQLException {
        Object convertIdNumber = this.dataPersister.convertIdNumber(number);
        if (convertIdNumber != null) {
            assignField(obj, convertIdNumber, false, objectCache);
            return convertIdNumber;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid class ");
        sb.append(this.dataPersister);
        sb.append(" for sequence-id ");
        sb.append(this);
        throw new SQLException(sb.toString());
    }

    public <FV> FV extractRawJavaFieldValue(Object obj) throws SQLException {
        if (this.fieldGetMethod == null) {
            try {
                return this.field.get(obj);
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Could not get field value for ");
                sb.append(this);
                throw SqlExceptionUtil.create(sb.toString(), e);
            }
        } else {
            try {
                return this.fieldGetMethod.invoke(obj, new Object[0]);
            } catch (Exception e2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Could not call ");
                sb2.append(this.fieldGetMethod);
                sb2.append(" for ");
                sb2.append(this);
                throw SqlExceptionUtil.create(sb2.toString(), e2);
            }
        }
    }

    public Object extractJavaFieldValue(Object obj) throws SQLException {
        Object extractRawJavaFieldValue = extractRawJavaFieldValue(obj);
        return (this.foreignIdField == null || extractRawJavaFieldValue == null) ? extractRawJavaFieldValue : this.foreignIdField.extractRawJavaFieldValue(extractRawJavaFieldValue);
    }

    public Object extractJavaFieldToSqlArgValue(Object obj) throws SQLException {
        return convertJavaFieldToSqlArgValue(extractJavaFieldValue(obj));
    }

    public Object convertJavaFieldToSqlArgValue(Object obj) throws SQLException {
        if (obj == null) {
            return null;
        }
        return this.fieldConverter.javaToSqlArg(this, obj);
    }

    public Object convertStringToJavaField(String str, int i) throws SQLException {
        if (str == null) {
            return null;
        }
        return this.fieldConverter.resultStringToJava(this, str, i);
    }

    public Object moveToNextValue(Object obj) {
        if (this.dataPersister == null) {
            return null;
        }
        return this.dataPersister.moveToNextValue(obj);
    }

    public FieldType getForeignIdField() {
        return this.foreignIdField;
    }

    public boolean isEscapedValue() {
        return this.dataPersister.isEscapedValue();
    }

    public Enum<?> getUnknownEnumVal() {
        return this.fieldConfig.getUnknownEnumValue();
    }

    public String getFormat() {
        return this.fieldConfig.getFormat();
    }

    public boolean isUnique() {
        return this.fieldConfig.isUnique();
    }

    public boolean isUniqueCombo() {
        return this.fieldConfig.isUniqueCombo();
    }

    public String getIndexName() {
        return this.fieldConfig.getIndexName(this.tableName);
    }

    public String getUniqueIndexName() {
        return this.fieldConfig.getUniqueIndexName(this.tableName);
    }

    public boolean isEscapedDefaultValue() {
        return this.dataPersister.isEscapedDefaultValue();
    }

    public boolean isComparable() throws SQLException {
        if (this.fieldConfig.isForeignCollection()) {
            return false;
        }
        if (this.dataPersister != null) {
            return this.dataPersister.isComparable();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Internal error.  Data-persister is not configured for field.  Please post _full_ exception with associated data objects to mailing list: ");
        sb.append(this);
        throw new SQLException(sb.toString());
    }

    public boolean isArgumentHolderRequired() {
        return this.dataPersister.isArgumentHolderRequired();
    }

    public boolean isForeignCollection() {
        return this.fieldConfig.isForeignCollection();
    }

    public <FT, FID> BaseForeignCollection<FT, FID> buildForeignCollection(Object obj, FID fid) throws SQLException {
        if (this.foreignFieldType == null) {
            return null;
        }
        BaseDaoImpl<?, ?> baseDaoImpl = this.foreignDao;
        if (!this.fieldConfig.isForeignCollectionEager()) {
            LazyForeignCollection lazyForeignCollection = new LazyForeignCollection(baseDaoImpl, obj, fid, this.foreignFieldType, this.fieldConfig.getForeignCollectionOrderColumnName(), this.fieldConfig.isForeignCollectionOrderAscending());
            return lazyForeignCollection;
        }
        LevelCounters levelCounters = (LevelCounters) threadLevelCounters.get();
        if (levelCounters.foreignCollectionLevel == 0) {
            levelCounters.foreignCollectionLevelMax = this.fieldConfig.getForeignCollectionMaxEagerLevel();
        }
        if (levelCounters.foreignCollectionLevel >= levelCounters.foreignCollectionLevelMax) {
            LazyForeignCollection lazyForeignCollection2 = new LazyForeignCollection(baseDaoImpl, obj, fid, this.foreignFieldType, this.fieldConfig.getForeignCollectionOrderColumnName(), this.fieldConfig.isForeignCollectionOrderAscending());
            return lazyForeignCollection2;
        }
        levelCounters.foreignCollectionLevel++;
        try {
            EagerForeignCollection eagerForeignCollection = new EagerForeignCollection(baseDaoImpl, obj, fid, this.foreignFieldType, this.fieldConfig.getForeignCollectionOrderColumnName(), this.fieldConfig.isForeignCollectionOrderAscending());
            return eagerForeignCollection;
        } finally {
            levelCounters.foreignCollectionLevel--;
        }
    }

    public <T> T resultToJava(DatabaseResults databaseResults, Map<String, Integer> map) throws SQLException {
        Integer num = (Integer) map.get(this.columnName);
        if (num == null) {
            num = Integer.valueOf(databaseResults.findColumn(this.columnName));
            map.put(this.columnName, num);
        }
        T resultToJava = this.fieldConverter.resultToJava(this, databaseResults, num.intValue());
        if (this.fieldConfig.isForeign()) {
            if (databaseResults.wasNull(num.intValue())) {
                return null;
            }
        } else if (this.dataPersister.isPrimitive()) {
            if (this.fieldConfig.isThrowIfNull() && databaseResults.wasNull(num.intValue())) {
                StringBuilder sb = new StringBuilder();
                sb.append("Results value for primitive field '");
                sb.append(this.field.getName());
                sb.append("' was an invalid null value");
                throw new SQLException(sb.toString());
            }
        } else if (this.fieldConverter.isStreamType() || !databaseResults.wasNull(num.intValue())) {
            return resultToJava;
        } else {
            return null;
        }
        return resultToJava;
    }

    public boolean isSelfGeneratedId() {
        return this.dataPersister.isSelfGeneratedId();
    }

    public boolean isAllowGeneratedIdInsert() {
        return this.fieldConfig.isAllowGeneratedIdInsert();
    }

    public String getColumnDefinition() {
        return this.fieldConfig.getColumnDefinition();
    }

    public boolean isForeignAutoCreate() {
        return this.fieldConfig.isForeignAutoCreate();
    }

    public boolean isVersion() {
        return this.fieldConfig.isVersion();
    }

    public Object generateId() {
        return this.dataPersister.generateId();
    }

    public boolean isReadOnly() {
        return this.fieldConfig.isReadOnly();
    }

    public <FV> FV getFieldValueIfNotDefault(Object obj) throws SQLException {
        FV extractJavaFieldValue = extractJavaFieldValue(obj);
        if (isFieldValueDefault(extractJavaFieldValue)) {
            return null;
        }
        return extractJavaFieldValue;
    }

    public boolean isObjectsFieldValueDefault(Object obj) throws SQLException {
        return isFieldValueDefault(extractJavaFieldValue(obj));
    }

    public Object getJavaDefaultValueDefault() {
        if (this.field.getType() == Boolean.TYPE) {
            return Boolean.valueOf(DEFAULT_VALUE_BOOLEAN);
        }
        if (this.field.getType() == Byte.TYPE || this.field.getType() == Byte.class) {
            return Byte.valueOf(DEFAULT_VALUE_BYTE);
        }
        if (this.field.getType() == Character.TYPE || this.field.getType() == Character.class) {
            return Character.valueOf(DEFAULT_VALUE_CHAR);
        }
        if (this.field.getType() == Short.TYPE || this.field.getType() == Short.class) {
            return Short.valueOf(DEFAULT_VALUE_SHORT);
        }
        if (this.field.getType() == Integer.TYPE || this.field.getType() == Integer.class) {
            return Integer.valueOf(DEFAULT_VALUE_INT);
        }
        if (this.field.getType() == Long.TYPE || this.field.getType() == Long.class) {
            return Long.valueOf(DEFAULT_VALUE_LONG);
        }
        if (this.field.getType() == Float.TYPE || this.field.getType() == Float.class) {
            return Float.valueOf(DEFAULT_VALUE_FLOAT);
        }
        if (this.field.getType() == Double.TYPE || this.field.getType() == Double.class) {
            return Double.valueOf(DEFAULT_VALUE_DOUBLE);
        }
        return null;
    }

    public <T> int createWithForeignDao(T t) throws SQLException {
        return this.foreignDao.create(t);
    }

    public static FieldType createFieldType(ConnectionSource connectionSource2, String str, Field field2, Class<?> cls) throws SQLException {
        DatabaseFieldConfig fromField = DatabaseFieldConfig.fromField(connectionSource2.getDatabaseType(), str, field2);
        if (fromField == null) {
            return null;
        }
        FieldType fieldType = new FieldType(connectionSource2, str, field2, fromField, cls);
        return fieldType;
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        return this.field.equals(((FieldType) obj).field);
    }

    public int hashCode() {
        return this.field.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(":name=");
        sb.append(this.field.getName());
        sb.append(",class=");
        sb.append(this.field.getDeclaringClass().getSimpleName());
        return sb.toString();
    }

    private boolean isFieldValueDefault(Object obj) {
        if (obj == null) {
            return true;
        }
        return obj.equals(getJavaDefaultValueDefault());
    }

    private FieldType findForeignFieldType(Class<?> cls, Class<?> cls2, BaseDaoImpl<?, ?> baseDaoImpl) throws SQLException {
        String foreignCollectionForeignFieldName = this.fieldConfig.getForeignCollectionForeignFieldName();
        FieldType[] fieldTypes = baseDaoImpl.getTableInfo().getFieldTypes();
        int length = fieldTypes.length;
        int i = 0;
        while (i < length) {
            FieldType fieldType = fieldTypes[i];
            if (fieldType.getType() != cls2 || (foreignCollectionForeignFieldName != null && !fieldType.getField().getName().equals(foreignCollectionForeignFieldName))) {
                i++;
            } else if (fieldType.fieldConfig.isForeign() || fieldType.fieldConfig.isForeignAutoRefresh()) {
                return fieldType;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Foreign collection object ");
                sb.append(cls);
                sb.append(" for field '");
                sb.append(this.field.getName());
                sb.append("' contains a field of class ");
                sb.append(cls2);
                sb.append(" but it's not foreign");
                throw new SQLException(sb.toString());
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Foreign collection class ");
        sb2.append(cls.getName());
        sb2.append(" for field '");
        sb2.append(this.field.getName());
        sb2.append("' column-name does not contain a foreign field");
        if (foreignCollectionForeignFieldName != null) {
            sb2.append(" named '");
            sb2.append(foreignCollectionForeignFieldName);
            sb2.append('\'');
        }
        sb2.append(" of class ");
        sb2.append(cls2.getName());
        throw new SQLException(sb2.toString());
    }

    private void assignDataType(DatabaseType databaseType, DataPersister dataPersister2) throws SQLException {
        DataType[] values;
        this.dataPersister = dataPersister2;
        if (dataPersister2 != null) {
            this.fieldConverter = databaseType.getFieldConverter(dataPersister2);
            if (this.isGeneratedId && !dataPersister2.isValidGeneratedType()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Generated-id field '");
                sb.append(this.field.getName());
                sb.append("' in ");
                sb.append(this.field.getDeclaringClass().getSimpleName());
                sb.append(" can't be type ");
                sb.append(this.dataPersister.getSqlType());
                sb.append(".  Must be one of: ");
                for (DataType dataType : DataType.values()) {
                    DataPersister dataPersister3 = dataType.getDataPersister();
                    if (dataPersister3 != null && dataPersister3.isValidGeneratedType()) {
                        sb.append(dataType);
                        sb.append(' ');
                    }
                }
                throw new IllegalArgumentException(sb.toString());
            } else if (this.fieldConfig.isThrowIfNull() && !dataPersister2.isPrimitive()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Field ");
                sb2.append(this.field.getName());
                sb2.append(" must be a primitive if set with throwIfNull");
                throw new SQLException(sb2.toString());
            } else if (!this.isId || dataPersister2.isAppropriateId()) {
                this.dataTypeConfigObj = dataPersister2.makeConfigObject(this);
                String defaultValue2 = this.fieldConfig.getDefaultValue();
                if (defaultValue2 == null || defaultValue2.equals("")) {
                    this.defaultValue = null;
                } else if (!this.isGeneratedId) {
                    this.defaultValue = this.fieldConverter.parseDefaultString(this, defaultValue2);
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Field '");
                    sb3.append(this.field.getName());
                    sb3.append("' cannot be a generatedId and have a default value '");
                    sb3.append(defaultValue2);
                    sb3.append("'");
                    throw new SQLException(sb3.toString());
                }
            } else {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Field '");
                sb4.append(this.field.getName());
                sb4.append("' is of data type ");
                sb4.append(dataPersister2);
                sb4.append(" which cannot be the ID field");
                throw new SQLException(sb4.toString());
            }
        } else if (!this.fieldConfig.isForeign() && !this.fieldConfig.isForeignCollection()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Data persister for field ");
            sb5.append(this);
            sb5.append(" is null but the field is not a foreign or foreignCollection");
            throw new SQLException(sb5.toString());
        }
    }
}
