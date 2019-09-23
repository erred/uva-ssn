package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.logger.Log.Level;
import com.j256.ormlite.p127db.DatabaseType;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.GeneratedKeyHolder;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;

public class MappedCreate<T, ID> extends BaseMappedStatement<T, ID> {
    private String dataClassName;
    private final String queryNextSequenceStmt;
    private int versionFieldTypeIndex;

    private static class KeyHolder implements GeneratedKeyHolder {
        Number key;

        private KeyHolder() {
        }

        public Number getKey() {
            return this.key;
        }

        public void addKey(Number number) throws SQLException {
            if (this.key == null) {
                this.key = number;
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("generated key has already been set to ");
            sb.append(this.key);
            sb.append(", now set to ");
            sb.append(number);
            throw new SQLException(sb.toString());
        }
    }

    private MappedCreate(TableInfo<T, ID> tableInfo, String str, FieldType[] fieldTypeArr, String str2, int i) {
        super(tableInfo, str, fieldTypeArr);
        this.dataClassName = tableInfo.getDataClass().getSimpleName();
        this.queryNextSequenceStmt = str2;
        this.versionFieldTypeIndex = i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0064 A[Catch:{ SQLException -> 0x0122, SQLException -> 0x013c }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00cc A[Catch:{ SQLException -> 0x0122, SQLException -> 0x013c }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00d5 A[Catch:{ SQLException -> 0x0122, SQLException -> 0x013c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int insert(com.j256.ormlite.p127db.DatabaseType r10, com.j256.ormlite.support.DatabaseConnection r11, T r12, com.j256.ormlite.dao.ObjectCache r13) throws java.sql.SQLException {
        /*
            r9 = this;
            com.j256.ormlite.field.FieldType r0 = r9.idField
            r1 = 0
            r2 = 0
            if (r0 == 0) goto L_0x005b
            com.j256.ormlite.field.FieldType r0 = r9.idField
            boolean r0 = r0.isAllowGeneratedIdInsert()
            if (r0 == 0) goto L_0x0018
            com.j256.ormlite.field.FieldType r0 = r9.idField
            boolean r0 = r0.isObjectsFieldValueDefault(r12)
            if (r0 != 0) goto L_0x0018
            r0 = 0
            goto L_0x0019
        L_0x0018:
            r0 = 1
        L_0x0019:
            com.j256.ormlite.field.FieldType r3 = r9.idField
            boolean r3 = r3.isSelfGeneratedId()
            if (r3 == 0) goto L_0x0037
            com.j256.ormlite.field.FieldType r3 = r9.idField
            boolean r3 = r3.isGeneratedId()
            if (r3 == 0) goto L_0x0037
            if (r0 == 0) goto L_0x005b
            com.j256.ormlite.field.FieldType r10 = r9.idField
            com.j256.ormlite.field.FieldType r0 = r9.idField
            java.lang.Object r0 = r0.generateId()
            r10.assignField(r12, r0, r1, r13)
            goto L_0x005b
        L_0x0037:
            com.j256.ormlite.field.FieldType r3 = r9.idField
            boolean r3 = r3.isGeneratedIdSequence()
            if (r3 == 0) goto L_0x004b
            boolean r10 = r10.isSelectSequenceBeforeInsert()
            if (r10 == 0) goto L_0x004b
            if (r0 == 0) goto L_0x005b
            r9.assignSequenceId(r11, r12, r13)
            goto L_0x005b
        L_0x004b:
            com.j256.ormlite.field.FieldType r10 = r9.idField
            boolean r10 = r10.isGeneratedId()
            if (r10 == 0) goto L_0x005b
            if (r0 == 0) goto L_0x005b
            com.j256.ormlite.stmt.mapped.MappedCreate$KeyHolder r10 = new com.j256.ormlite.stmt.mapped.MappedCreate$KeyHolder
            r10.<init>()
            goto L_0x005c
        L_0x005b:
            r10 = r2
        L_0x005c:
            com.j256.ormlite.table.TableInfo r0 = r9.tableInfo     // Catch:{ SQLException -> 0x013c }
            boolean r0 = r0.isForeignAutoCreate()     // Catch:{ SQLException -> 0x013c }
            if (r0 == 0) goto L_0x008d
            com.j256.ormlite.table.TableInfo r0 = r9.tableInfo     // Catch:{ SQLException -> 0x013c }
            com.j256.ormlite.field.FieldType[] r0 = r0.getFieldTypes()     // Catch:{ SQLException -> 0x013c }
            int r3 = r0.length     // Catch:{ SQLException -> 0x013c }
            r4 = 0
        L_0x006c:
            if (r4 >= r3) goto L_0x008d
            r5 = r0[r4]     // Catch:{ SQLException -> 0x013c }
            boolean r6 = r5.isForeignAutoCreate()     // Catch:{ SQLException -> 0x013c }
            if (r6 != 0) goto L_0x0077
            goto L_0x008a
        L_0x0077:
            java.lang.Object r6 = r5.extractRawJavaFieldValue(r12)     // Catch:{ SQLException -> 0x013c }
            if (r6 == 0) goto L_0x008a
            com.j256.ormlite.field.FieldType r7 = r5.getForeignIdField()     // Catch:{ SQLException -> 0x013c }
            boolean r7 = r7.isObjectsFieldValueDefault(r6)     // Catch:{ SQLException -> 0x013c }
            if (r7 == 0) goto L_0x008a
            r5.createWithForeignDao(r6)     // Catch:{ SQLException -> 0x013c }
        L_0x008a:
            int r4 = r4 + 1
            goto L_0x006c
        L_0x008d:
            java.lang.Object[] r0 = r9.getFieldObjects(r12)     // Catch:{ SQLException -> 0x013c }
            int r3 = r9.versionFieldTypeIndex     // Catch:{ SQLException -> 0x013c }
            if (r3 < 0) goto L_0x00ae
            int r3 = r9.versionFieldTypeIndex     // Catch:{ SQLException -> 0x013c }
            r3 = r0[r3]     // Catch:{ SQLException -> 0x013c }
            if (r3 != 0) goto L_0x00ae
            com.j256.ormlite.field.FieldType[] r3 = r9.argFieldTypes     // Catch:{ SQLException -> 0x013c }
            int r4 = r9.versionFieldTypeIndex     // Catch:{ SQLException -> 0x013c }
            r3 = r3[r4]     // Catch:{ SQLException -> 0x013c }
            java.lang.Object r4 = r3.moveToNextValue(r2)     // Catch:{ SQLException -> 0x013c }
            int r5 = r9.versionFieldTypeIndex     // Catch:{ SQLException -> 0x013c }
            java.lang.Object r3 = r3.convertJavaFieldToSqlArgValue(r4)     // Catch:{ SQLException -> 0x013c }
            r0[r5] = r3     // Catch:{ SQLException -> 0x013c }
            goto L_0x00af
        L_0x00ae:
            r4 = r2
        L_0x00af:
            java.lang.String r3 = r9.statement     // Catch:{ SQLException -> 0x0122 }
            com.j256.ormlite.field.FieldType[] r5 = r9.argFieldTypes     // Catch:{ SQLException -> 0x0122 }
            int r11 = r11.insert(r3, r0, r5, r10)     // Catch:{ SQLException -> 0x0122 }
            com.j256.ormlite.logger.Logger r3 = logger     // Catch:{ SQLException -> 0x013c }
            java.lang.String r5 = "insert data with statement '{}' and {} args, changed {} rows"
            java.lang.String r6 = r9.statement     // Catch:{ SQLException -> 0x013c }
            int r7 = r0.length     // Catch:{ SQLException -> 0x013c }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ SQLException -> 0x013c }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r11)     // Catch:{ SQLException -> 0x013c }
            r3.debug(r5, r6, r7, r8)     // Catch:{ SQLException -> 0x013c }
            int r3 = r0.length     // Catch:{ SQLException -> 0x013c }
            if (r3 <= 0) goto L_0x00d3
            com.j256.ormlite.logger.Logger r3 = logger     // Catch:{ SQLException -> 0x013c }
            java.lang.String r5 = "insert arguments: {}"
            r3.trace(r5, r0)     // Catch:{ SQLException -> 0x013c }
        L_0x00d3:
            if (r11 <= 0) goto L_0x0121
            if (r4 == 0) goto L_0x00e0
            com.j256.ormlite.field.FieldType[] r0 = r9.argFieldTypes     // Catch:{ SQLException -> 0x013c }
            int r3 = r9.versionFieldTypeIndex     // Catch:{ SQLException -> 0x013c }
            r0 = r0[r3]     // Catch:{ SQLException -> 0x013c }
            r0.assignField(r12, r4, r1, r2)     // Catch:{ SQLException -> 0x013c }
        L_0x00e0:
            if (r10 == 0) goto L_0x0108
            java.lang.Number r10 = r10.getKey()     // Catch:{ SQLException -> 0x013c }
            if (r10 == 0) goto L_0x0100
            long r0 = r10.longValue()     // Catch:{ SQLException -> 0x013c }
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x00f8
            java.lang.String r0 = "keyholder"
            r9.assignIdValue(r12, r10, r0, r13)     // Catch:{ SQLException -> 0x013c }
            goto L_0x0108
        L_0x00f8:
            java.sql.SQLException r10 = new java.sql.SQLException     // Catch:{ SQLException -> 0x013c }
            java.lang.String r11 = "generated-id key must not be 0 value"
            r10.<init>(r11)     // Catch:{ SQLException -> 0x013c }
            throw r10     // Catch:{ SQLException -> 0x013c }
        L_0x0100:
            java.sql.SQLException r10 = new java.sql.SQLException     // Catch:{ SQLException -> 0x013c }
            java.lang.String r11 = "generated-id key was not set by the update call"
            r10.<init>(r11)     // Catch:{ SQLException -> 0x013c }
            throw r10     // Catch:{ SQLException -> 0x013c }
        L_0x0108:
            if (r13 == 0) goto L_0x0121
            com.j256.ormlite.table.TableInfo r10 = r9.tableInfo     // Catch:{ SQLException -> 0x013c }
            com.j256.ormlite.field.FieldType[] r10 = r10.getForeignCollections()     // Catch:{ SQLException -> 0x013c }
            boolean r10 = r9.foreignCollectionsAreAssigned(r10, r12)     // Catch:{ SQLException -> 0x013c }
            if (r10 == 0) goto L_0x0121
            com.j256.ormlite.field.FieldType r10 = r9.idField     // Catch:{ SQLException -> 0x013c }
            java.lang.Object r10 = r10.extractJavaFieldValue(r12)     // Catch:{ SQLException -> 0x013c }
            java.lang.Class r0 = r9.clazz     // Catch:{ SQLException -> 0x013c }
            r13.put(r0, r10, r12)     // Catch:{ SQLException -> 0x013c }
        L_0x0121:
            return r11
        L_0x0122:
            r10 = move-exception
            com.j256.ormlite.logger.Logger r11 = logger     // Catch:{ SQLException -> 0x013c }
            java.lang.String r13 = "insert data with statement '{}' and {} args, threw exception: {}"
            java.lang.String r1 = r9.statement     // Catch:{ SQLException -> 0x013c }
            int r2 = r0.length     // Catch:{ SQLException -> 0x013c }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLException -> 0x013c }
            r11.debug(r13, r1, r2, r10)     // Catch:{ SQLException -> 0x013c }
            int r11 = r0.length     // Catch:{ SQLException -> 0x013c }
            if (r11 <= 0) goto L_0x013b
            com.j256.ormlite.logger.Logger r11 = logger     // Catch:{ SQLException -> 0x013c }
            java.lang.String r13 = "insert arguments: {}"
            r11.trace(r13, r0)     // Catch:{ SQLException -> 0x013c }
        L_0x013b:
            throw r10     // Catch:{ SQLException -> 0x013c }
        L_0x013c:
            r10 = move-exception
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r13 = "Unable to run insert stmt on object "
            r11.append(r13)
            r11.append(r12)
            java.lang.String r12 = ": "
            r11.append(r12)
            java.lang.String r12 = r9.statement
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            java.sql.SQLException r10 = com.j256.ormlite.misc.SqlExceptionUtil.create(r11, r10)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.stmt.mapped.MappedCreate.insert(com.j256.ormlite.db.DatabaseType, com.j256.ormlite.support.DatabaseConnection, java.lang.Object, com.j256.ormlite.dao.ObjectCache):int");
    }

    public static <T, ID> MappedCreate<T, ID> build(DatabaseType databaseType, TableInfo<T, ID> tableInfo) {
        FieldType[] fieldTypes;
        FieldType[] fieldTypes2;
        StringBuilder sb = new StringBuilder(128);
        appendTableName(databaseType, sb, "INSERT INTO ", tableInfo.getTableName());
        sb.append('(');
        int i = 0;
        int i2 = -1;
        for (FieldType fieldType : tableInfo.getFieldTypes()) {
            if (isFieldCreatable(databaseType, fieldType)) {
                if (fieldType.isVersion()) {
                    i2 = i;
                }
                i++;
            }
        }
        FieldType[] fieldTypeArr = new FieldType[i];
        boolean z = true;
        int i3 = 0;
        for (FieldType fieldType2 : tableInfo.getFieldTypes()) {
            if (isFieldCreatable(databaseType, fieldType2)) {
                if (z) {
                    z = false;
                } else {
                    sb.append(",");
                }
                appendFieldColumnName(databaseType, sb, fieldType2, null);
                int i4 = i3 + 1;
                fieldTypeArr[i3] = fieldType2;
                i3 = i4;
            }
        }
        sb.append(") VALUES (");
        boolean z2 = true;
        for (FieldType isFieldCreatable : tableInfo.getFieldTypes()) {
            if (isFieldCreatable(databaseType, isFieldCreatable)) {
                if (z2) {
                    z2 = false;
                } else {
                    sb.append(",");
                }
                sb.append("?");
            }
        }
        sb.append(")");
        MappedCreate mappedCreate = new MappedCreate(tableInfo, sb.toString(), fieldTypeArr, buildQueryNextSequence(databaseType, tableInfo.getIdField()), i2);
        return mappedCreate;
    }

    private boolean foreignCollectionsAreAssigned(FieldType[] fieldTypeArr, Object obj) throws SQLException {
        for (FieldType extractJavaFieldValue : fieldTypeArr) {
            if (extractJavaFieldValue.extractJavaFieldValue(obj) == null) {
                return false;
            }
        }
        return true;
    }

    private static boolean isFieldCreatable(DatabaseType databaseType, FieldType fieldType) {
        if (fieldType.isForeignCollection() || fieldType.isReadOnly()) {
            return false;
        }
        if ((!databaseType.isIdSequenceNeeded() || !databaseType.isSelectSequenceBeforeInsert()) && fieldType.isGeneratedId() && !fieldType.isSelfGeneratedId() && !fieldType.isAllowGeneratedIdInsert()) {
            return false;
        }
        return true;
    }

    private static String buildQueryNextSequence(DatabaseType databaseType, FieldType fieldType) {
        if (fieldType == null) {
            return null;
        }
        String generatedIdSequence = fieldType.getGeneratedIdSequence();
        if (generatedIdSequence == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(64);
        databaseType.appendSelectNextValFromSequence(sb, generatedIdSequence);
        return sb.toString();
    }

    private void assignSequenceId(DatabaseConnection databaseConnection, T t, ObjectCache objectCache) throws SQLException {
        long queryForLong = databaseConnection.queryForLong(this.queryNextSequenceStmt);
        logger.debug("queried for sequence {} using stmt: {}", (Object) Long.valueOf(queryForLong), (Object) this.queryNextSequenceStmt);
        if (queryForLong != 0) {
            assignIdValue(t, Long.valueOf(queryForLong), "sequence", objectCache);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Should not have returned 0 for stmt: ");
        sb.append(this.queryNextSequenceStmt);
        throw new SQLException(sb.toString());
    }

    private void assignIdValue(T t, Number number, String str, ObjectCache objectCache) throws SQLException {
        this.idField.assignIdValue(t, number, objectCache);
        if (logger.isLevelEnabled(Level.DEBUG)) {
            logger.debug("assigned id '{}' from {} to '{}' in {} object", new Object[]{number, str, this.idField.getFieldName(), this.dataClassName});
        }
    }
}
