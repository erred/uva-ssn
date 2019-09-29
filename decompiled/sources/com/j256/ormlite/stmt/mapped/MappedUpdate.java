package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.p127db.DatabaseType;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;

public class MappedUpdate<T, ID> extends BaseMappedStatement<T, ID> {
    private final FieldType versionFieldType;
    private final int versionFieldTypeIndex;

    private MappedUpdate(TableInfo<T, ID> tableInfo, String str, FieldType[] fieldTypeArr, FieldType fieldType, int i) {
        super(tableInfo, str, fieldTypeArr);
        this.versionFieldType = fieldType;
        this.versionFieldTypeIndex = i;
    }

    public static <T, ID> MappedUpdate<T, ID> build(DatabaseType databaseType, TableInfo<T, ID> tableInfo) throws SQLException {
        FieldType[] fieldTypes;
        FieldType[] fieldTypes2;
        FieldType idField = tableInfo.getIdField();
        if (idField != null) {
            StringBuilder sb = new StringBuilder(64);
            appendTableName(databaseType, sb, "UPDATE ", tableInfo.getTableName());
            FieldType fieldType = null;
            int i = 0;
            int i2 = -1;
            for (FieldType fieldType2 : tableInfo.getFieldTypes()) {
                if (isFieldUpdatable(fieldType2, idField)) {
                    if (fieldType2.isVersion()) {
                        i2 = i;
                    } else {
                        fieldType2 = fieldType;
                    }
                    i++;
                    fieldType = fieldType2;
                }
            }
            int i3 = i + 1;
            if (fieldType != null) {
                i3++;
            }
            FieldType[] fieldTypeArr = new FieldType[i3];
            int i4 = 0;
            boolean z = true;
            for (FieldType fieldType3 : tableInfo.getFieldTypes()) {
                if (isFieldUpdatable(fieldType3, idField)) {
                    if (z) {
                        sb.append("SET ");
                        z = false;
                    } else {
                        sb.append(", ");
                    }
                    appendFieldColumnName(databaseType, sb, fieldType3, null);
                    int i5 = i4 + 1;
                    fieldTypeArr[i4] = fieldType3;
                    sb.append("= ?");
                    i4 = i5;
                }
            }
            sb.append(' ');
            appendWhereFieldEq(databaseType, idField, sb, null);
            int i6 = i4 + 1;
            fieldTypeArr[i4] = idField;
            if (fieldType != null) {
                sb.append(" AND ");
                appendFieldColumnName(databaseType, sb, fieldType, null);
                sb.append("= ?");
                fieldTypeArr[i6] = fieldType;
            }
            MappedUpdate mappedUpdate = new MappedUpdate(tableInfo, sb.toString(), fieldTypeArr, fieldType, i2);
            return mappedUpdate;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Cannot update ");
        sb2.append(tableInfo.getDataClass());
        sb2.append(" because it doesn't have an id field");
        throw new SQLException(sb2.toString());
    }

    public int update(DatabaseConnection databaseConnection, T t, ObjectCache objectCache) throws SQLException {
        Object obj;
        FieldType[] fieldTypes;
        try {
            if (this.argFieldTypes.length <= 1) {
                return 0;
            }
            Object[] fieldObjects = getFieldObjects(t);
            if (this.versionFieldType != null) {
                obj = this.versionFieldType.moveToNextValue(this.versionFieldType.extractJavaFieldValue(t));
                fieldObjects[this.versionFieldTypeIndex] = this.versionFieldType.convertJavaFieldToSqlArgValue(obj);
            } else {
                obj = null;
            }
            int update = databaseConnection.update(this.statement, fieldObjects, this.argFieldTypes);
            if (update > 0) {
                if (obj != null) {
                    this.versionFieldType.assignField(t, obj, false, null);
                }
                if (objectCache != null) {
                    T t2 = objectCache.get(this.clazz, this.idField.extractJavaFieldValue(t));
                    if (!(t2 == null || t2 == t)) {
                        for (FieldType fieldType : this.tableInfo.getFieldTypes()) {
                            if (fieldType != this.idField) {
                                fieldType.assignField(t2, fieldType.extractJavaFieldValue(t), false, objectCache);
                            }
                        }
                    }
                }
            }
            logger.debug("update data with statement '{}' and {} args, changed {} rows", (Object) this.statement, (Object) Integer.valueOf(fieldObjects.length), (Object) Integer.valueOf(update));
            if (fieldObjects.length > 0) {
                logger.trace("update arguments: {}", (Object) fieldObjects);
            }
            return update;
        } catch (SQLException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to run update stmt on object ");
            sb.append(t);
            sb.append(": ");
            sb.append(this.statement);
            throw SqlExceptionUtil.create(sb.toString(), e);
        }
    }

    private static boolean isFieldUpdatable(FieldType fieldType, FieldType fieldType2) {
        boolean isForeignCollection;
        if (fieldType != fieldType2) {
            if (!fieldType.isReadOnly() && !fieldType.isForeignCollection()) {
                return true;
            }
        }
        return false;
    }
}
