package com.j256.ormlite.table;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.DatabaseFieldConfig;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.misc.JavaxPersistence;
import com.j256.ormlite.p127db.DatabaseType;
import com.j256.ormlite.support.ConnectionSource;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseTableConfig<T> {
    private Constructor<T> constructor;
    private Class<T> dataClass;
    private List<DatabaseFieldConfig> fieldConfigs;
    private FieldType[] fieldTypes;
    private String tableName;

    public DatabaseTableConfig() {
    }

    public DatabaseTableConfig(Class<T> cls, List<DatabaseFieldConfig> list) {
        this(cls, extractTableName(cls), list);
    }

    public DatabaseTableConfig(Class<T> cls, String str, List<DatabaseFieldConfig> list) {
        this.dataClass = cls;
        this.tableName = str;
        this.fieldConfigs = list;
    }

    private DatabaseTableConfig(Class<T> cls, String str, FieldType[] fieldTypeArr) {
        this.dataClass = cls;
        this.tableName = str;
        this.fieldTypes = fieldTypeArr;
    }

    public void initialize() {
        if (this.dataClass == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("dataClass was never set on ");
            sb.append(getClass().getSimpleName());
            throw new IllegalStateException(sb.toString());
        } else if (this.tableName == null) {
            this.tableName = extractTableName(this.dataClass);
        }
    }

    public Class<T> getDataClass() {
        return this.dataClass;
    }

    public void setDataClass(Class<T> cls) {
        this.dataClass = cls;
    }

    public String getTableName() {
        return this.tableName;
    }

    public void setTableName(String str) {
        this.tableName = str;
    }

    public void setFieldConfigs(List<DatabaseFieldConfig> list) {
        this.fieldConfigs = list;
    }

    public void extractFieldTypes(ConnectionSource connectionSource) throws SQLException {
        if (this.fieldTypes != null) {
            return;
        }
        if (this.fieldConfigs == null) {
            this.fieldTypes = extractFieldTypes(connectionSource, this.dataClass, this.tableName);
        } else {
            this.fieldTypes = convertFieldConfigs(connectionSource, this.tableName, this.fieldConfigs);
        }
    }

    public FieldType[] getFieldTypes(DatabaseType databaseType) throws SQLException {
        if (this.fieldTypes != null) {
            return this.fieldTypes;
        }
        throw new SQLException("Field types have not been extracted in table config");
    }

    public List<DatabaseFieldConfig> getFieldConfigs() {
        return this.fieldConfigs;
    }

    public Constructor<T> getConstructor() {
        if (this.constructor == null) {
            this.constructor = findNoArgConstructor(this.dataClass);
        }
        return this.constructor;
    }

    public void setConstructor(Constructor<T> constructor2) {
        this.constructor = constructor2;
    }

    public static <T> DatabaseTableConfig<T> fromClass(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        String extractTableName = extractTableName(cls);
        if (connectionSource.getDatabaseType().isEntityNamesMustBeUpCase()) {
            extractTableName = extractTableName.toUpperCase();
        }
        return new DatabaseTableConfig<>(cls, extractTableName, extractFieldTypes(connectionSource, cls, extractTableName));
    }

    public static <T> String extractTableName(Class<T> cls) {
        DatabaseTable databaseTable = (DatabaseTable) cls.getAnnotation(DatabaseTable.class);
        if (databaseTable != null && databaseTable.tableName() != null && databaseTable.tableName().length() > 0) {
            return databaseTable.tableName();
        }
        String entityName = JavaxPersistence.getEntityName(cls);
        return entityName == null ? cls.getSimpleName().toLowerCase() : entityName;
    }

    public static <T> Constructor<T> findNoArgConstructor(Class<T> cls) {
        Constructor<T>[] declaredConstructors;
        try {
            for (Constructor<T> constructor2 : cls.getDeclaredConstructors()) {
                if (constructor2.getParameterTypes().length == 0) {
                    if (!constructor2.isAccessible()) {
                        try {
                            constructor2.setAccessible(true);
                        } catch (SecurityException unused) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Could not open access to constructor for ");
                            sb.append(cls);
                            throw new IllegalArgumentException(sb.toString());
                        }
                    }
                    return constructor2;
                }
            }
            if (cls.getEnclosingClass() == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Can't find a no-arg constructor for ");
                sb2.append(cls);
                throw new IllegalArgumentException(sb2.toString());
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Can't find a no-arg constructor for ");
            sb3.append(cls);
            sb3.append(".  Missing static on inner class?");
            throw new IllegalArgumentException(sb3.toString());
        } catch (Exception e) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Can't lookup declared constructors for ");
            sb4.append(cls);
            throw new IllegalArgumentException(sb4.toString(), e);
        }
    }

    private static <T> FieldType[] extractFieldTypes(ConnectionSource connectionSource, Class<T> cls, String str) throws SQLException {
        ArrayList arrayList = new ArrayList();
        for (Class<T> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            for (Field createFieldType : cls2.getDeclaredFields()) {
                FieldType createFieldType2 = FieldType.createFieldType(connectionSource, str, createFieldType, cls);
                if (createFieldType2 != null) {
                    arrayList.add(createFieldType2);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            return (FieldType[]) arrayList.toArray(new FieldType[arrayList.size()]);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("No fields have a ");
        sb.append(DatabaseField.class.getSimpleName());
        sb.append(" annotation in ");
        sb.append(cls);
        throw new IllegalArgumentException(sb.toString());
    }

    private FieldType[] convertFieldConfigs(ConnectionSource connectionSource, String str, List<DatabaseFieldConfig> list) throws SQLException {
        ArrayList arrayList = new ArrayList();
        for (DatabaseFieldConfig databaseFieldConfig : list) {
            FieldType fieldType = null;
            Class<T> cls = this.dataClass;
            while (true) {
                if (cls == null) {
                    break;
                }
                try {
                    Field declaredField = cls.getDeclaredField(databaseFieldConfig.getFieldName());
                    if (declaredField != null) {
                        fieldType = new FieldType(connectionSource, str, declaredField, databaseFieldConfig, this.dataClass);
                        break;
                    }
                    cls = cls.getSuperclass();
                } catch (NoSuchFieldException unused) {
                }
            }
            if (fieldType != null) {
                arrayList.add(fieldType);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Could not find declared field with name '");
                sb.append(databaseFieldConfig.getFieldName());
                sb.append("' for ");
                sb.append(this.dataClass);
                throw new SQLException(sb.toString());
            }
        }
        if (!arrayList.isEmpty()) {
            return (FieldType[]) arrayList.toArray(new FieldType[arrayList.size()]);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("No fields were configured for class ");
        sb2.append(this.dataClass);
        throw new SQLException(sb2.toString());
    }
}
