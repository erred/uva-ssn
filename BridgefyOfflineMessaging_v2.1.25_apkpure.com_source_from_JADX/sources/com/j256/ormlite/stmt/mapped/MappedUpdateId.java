package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.p127db.DatabaseType;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;

public class MappedUpdateId<T, ID> extends BaseMappedStatement<T, ID> {
    private MappedUpdateId(TableInfo<T, ID> tableInfo, String str, FieldType[] fieldTypeArr) {
        super(tableInfo, str, fieldTypeArr);
    }

    public int execute(DatabaseConnection databaseConnection, T t, ID id, ObjectCache objectCache) throws SQLException {
        try {
            Object[] objArr = {convertIdToFieldObject(id), extractIdToFieldObject(t)};
            int update = databaseConnection.update(this.statement, objArr, this.argFieldTypes);
            if (update > 0) {
                if (objectCache != null) {
                    T updateId = objectCache.updateId(this.clazz, this.idField.extractJavaFieldValue(t), id);
                    if (!(updateId == null || updateId == t)) {
                        this.idField.assignField(updateId, id, false, objectCache);
                    }
                }
                this.idField.assignField(t, id, false, objectCache);
            }
            logger.debug("updating-id with statement '{}' and {} args, changed {} rows", (Object) this.statement, (Object) Integer.valueOf(objArr.length), (Object) Integer.valueOf(update));
            if (objArr.length > 0) {
                logger.trace("updating-id arguments: {}", (Object) objArr);
            }
            return update;
        } catch (SQLException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to run update-id stmt on object ");
            sb.append(t);
            sb.append(": ");
            sb.append(this.statement);
            throw SqlExceptionUtil.create(sb.toString(), e);
        }
    }

    public static <T, ID> MappedUpdateId<T, ID> build(DatabaseType databaseType, TableInfo<T, ID> tableInfo) throws SQLException {
        FieldType idField = tableInfo.getIdField();
        if (idField != null) {
            StringBuilder sb = new StringBuilder(64);
            appendTableName(databaseType, sb, "UPDATE ", tableInfo.getTableName());
            sb.append("SET ");
            appendFieldColumnName(databaseType, sb, idField, null);
            sb.append("= ? ");
            appendWhereFieldEq(databaseType, idField, sb, null);
            return new MappedUpdateId<>(tableInfo, sb.toString(), new FieldType[]{idField, idField});
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Cannot update-id in ");
        sb2.append(tableInfo.getDataClass());
        sb2.append(" because it doesn't have an id field");
        throw new SQLException(sb2.toString());
    }

    private Object extractIdToFieldObject(T t) throws SQLException {
        return this.idField.extractJavaFieldToSqlArgValue(t);
    }
}
