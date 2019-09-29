package com.j256.ormlite.table;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.p127db.DatabaseType;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;

public class TableUtils {
    private static Logger logger = LoggerFactory.getLogger(TableUtils.class);
    private static final FieldType[] noFieldTypes = new FieldType[0];

    private TableUtils() {
    }

    public static <T> int createTable(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        return createTable(connectionSource, cls, false);
    }

    public static <T> int createTableIfNotExists(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        return createTable(connectionSource, cls, true);
    }

    public static <T> int createTable(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        return createTable(connectionSource, databaseTableConfig, false);
    }

    public static <T> int createTableIfNotExists(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        return createTable(connectionSource, databaseTableConfig, true);
    }

    public static <T, ID> List<String> getCreateTableStatements(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        Dao createDao = DaoManager.createDao(connectionSource, cls);
        if (createDao instanceof BaseDaoImpl) {
            return addCreateTableStatements(connectionSource, ((BaseDaoImpl) createDao).getTableInfo(), false);
        }
        return addCreateTableStatements(connectionSource, new TableInfo(connectionSource, null, cls), false);
    }

    public static <T, ID> List<String> getCreateTableStatements(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        Dao createDao = DaoManager.createDao(connectionSource, databaseTableConfig);
        if (createDao instanceof BaseDaoImpl) {
            return addCreateTableStatements(connectionSource, ((BaseDaoImpl) createDao).getTableInfo(), false);
        }
        databaseTableConfig.extractFieldTypes(connectionSource);
        return addCreateTableStatements(connectionSource, new TableInfo(connectionSource.getDatabaseType(), null, databaseTableConfig), false);
    }

    public static <T, ID> int dropTable(ConnectionSource connectionSource, Class<T> cls, boolean z) throws SQLException {
        DatabaseType databaseType = connectionSource.getDatabaseType();
        Dao createDao = DaoManager.createDao(connectionSource, cls);
        if (createDao instanceof BaseDaoImpl) {
            return doDropTable(databaseType, connectionSource, ((BaseDaoImpl) createDao).getTableInfo(), z);
        }
        return doDropTable(databaseType, connectionSource, new TableInfo(connectionSource, null, cls), z);
    }

    public static <T, ID> int dropTable(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig, boolean z) throws SQLException {
        DatabaseType databaseType = connectionSource.getDatabaseType();
        Dao createDao = DaoManager.createDao(connectionSource, databaseTableConfig);
        if (createDao instanceof BaseDaoImpl) {
            return doDropTable(databaseType, connectionSource, ((BaseDaoImpl) createDao).getTableInfo(), z);
        }
        databaseTableConfig.extractFieldTypes(connectionSource);
        return doDropTable(databaseType, connectionSource, new TableInfo(databaseType, null, databaseTableConfig), z);
    }

    public static <T> int clearTable(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        String extractTableName = DatabaseTableConfig.extractTableName(cls);
        if (connectionSource.getDatabaseType().isEntityNamesMustBeUpCase()) {
            extractTableName = extractTableName.toUpperCase();
        }
        return clearTable(connectionSource, extractTableName);
    }

    public static <T> int clearTable(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        return clearTable(connectionSource, databaseTableConfig.getTableName());
    }

    private static <T, ID> int createTable(ConnectionSource connectionSource, Class<T> cls, boolean z) throws SQLException {
        Dao createDao = DaoManager.createDao(connectionSource, cls);
        if (createDao instanceof BaseDaoImpl) {
            return doCreateTable(connectionSource, ((BaseDaoImpl) createDao).getTableInfo(), z);
        }
        return doCreateTable(connectionSource, new TableInfo(connectionSource, null, cls), z);
    }

    private static <T, ID> int createTable(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig, boolean z) throws SQLException {
        Dao createDao = DaoManager.createDao(connectionSource, databaseTableConfig);
        if (createDao instanceof BaseDaoImpl) {
            return doCreateTable(connectionSource, ((BaseDaoImpl) createDao).getTableInfo(), z);
        }
        databaseTableConfig.extractFieldTypes(connectionSource);
        return doCreateTable(connectionSource, new TableInfo(connectionSource.getDatabaseType(), null, databaseTableConfig), z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <T> int clearTable(com.j256.ormlite.support.ConnectionSource r5, java.lang.String r6) throws java.sql.SQLException {
        /*
            com.j256.ormlite.db.DatabaseType r0 = r5.getDatabaseType()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r2 = 48
            r1.<init>(r2)
            boolean r2 = r0.isTruncateSupported()
            if (r2 == 0) goto L_0x0017
            java.lang.String r2 = "TRUNCATE TABLE "
            r1.append(r2)
            goto L_0x001c
        L_0x0017:
            java.lang.String r2 = "DELETE FROM "
            r1.append(r2)
        L_0x001c:
            r0.appendEscapedEntityName(r1, r6)
            java.lang.String r0 = r1.toString()
            com.j256.ormlite.logger.Logger r1 = logger
            java.lang.String r2 = "clearing table '{}' with '{}"
            r1.info(r2, r6, r0)
            r6 = 0
            com.j256.ormlite.support.DatabaseConnection r1 = r5.getReadWriteConnection()
            com.j256.ormlite.stmt.StatementBuilder$StatementType r2 = com.j256.ormlite.stmt.StatementBuilder.StatementType.EXECUTE     // Catch:{ all -> 0x0049 }
            com.j256.ormlite.field.FieldType[] r3 = noFieldTypes     // Catch:{ all -> 0x0049 }
            com.j256.ormlite.support.CompiledStatement r0 = r1.compileStatement(r0, r2, r3)     // Catch:{ all -> 0x0049 }
            int r6 = r0.runExecute()     // Catch:{ all -> 0x0044 }
            if (r0 == 0) goto L_0x0040
            r0.close()
        L_0x0040:
            r5.releaseConnection(r1)
            return r6
        L_0x0044:
            r6 = move-exception
            r4 = r0
            r0 = r6
            r6 = r4
            goto L_0x004a
        L_0x0049:
            r0 = move-exception
        L_0x004a:
            if (r6 == 0) goto L_0x004f
            r6.close()
        L_0x004f:
            r5.releaseConnection(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.table.TableUtils.clearTable(com.j256.ormlite.support.ConnectionSource, java.lang.String):int");
    }

    private static <T, ID> int doDropTable(DatabaseType databaseType, ConnectionSource connectionSource, TableInfo<T, ID> tableInfo, boolean z) throws SQLException {
        logger.info("dropping table '{}'", (Object) tableInfo.getTableName());
        ArrayList arrayList = new ArrayList();
        addDropIndexStatements(databaseType, tableInfo, arrayList);
        addDropTableStatements(databaseType, tableInfo, arrayList);
        DatabaseConnection readWriteConnection = connectionSource.getReadWriteConnection();
        try {
            return doStatements(readWriteConnection, "drop", arrayList, z, databaseType.isCreateTableReturnsNegative(), false);
        } finally {
            connectionSource.releaseConnection(readWriteConnection);
        }
    }

    private static <T, ID> void addDropIndexStatements(DatabaseType databaseType, TableInfo<T, ID> tableInfo, List<String> list) {
        FieldType[] fieldTypes;
        HashSet<String> hashSet = new HashSet<>();
        for (FieldType fieldType : tableInfo.getFieldTypes()) {
            String indexName = fieldType.getIndexName();
            if (indexName != null) {
                hashSet.add(indexName);
            }
            String uniqueIndexName = fieldType.getUniqueIndexName();
            if (uniqueIndexName != null) {
                hashSet.add(uniqueIndexName);
            }
        }
        StringBuilder sb = new StringBuilder(48);
        for (String str : hashSet) {
            logger.info("dropping index '{}' for table '{}", (Object) str, (Object) tableInfo.getTableName());
            sb.append("DROP INDEX ");
            databaseType.appendEscapedEntityName(sb, str);
            list.add(sb.toString());
            sb.setLength(0);
        }
    }

    private static <T, ID> void addCreateTableStatements(DatabaseType databaseType, TableInfo<T, ID> tableInfo, List<String> list, List<String> list2, boolean z) throws SQLException {
        FieldType[] fieldTypeArr;
        int i;
        int i2;
        boolean z2;
        DatabaseType databaseType2 = databaseType;
        TableInfo<T, ID> tableInfo2 = tableInfo;
        List<String> list3 = list;
        boolean z3 = z;
        StringBuilder sb = new StringBuilder(256);
        sb.append("CREATE TABLE ");
        if (z3 && databaseType.isCreateIfNotExistsSupported()) {
            sb.append("IF NOT EXISTS ");
        }
        databaseType2.appendEscapedEntityName(sb, tableInfo.getTableName());
        sb.append(" (");
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        FieldType[] fieldTypes = tableInfo.getFieldTypes();
        int length = fieldTypes.length;
        boolean z4 = true;
        int i3 = 0;
        while (i3 < length) {
            FieldType fieldType = fieldTypes[i3];
            if (fieldType.isForeignCollection()) {
                i2 = i3;
                i = length;
                fieldTypeArr = fieldTypes;
            } else {
                if (z4) {
                    z2 = false;
                } else {
                    sb.append(", ");
                    z2 = z4;
                }
                String columnDefinition = fieldType.getColumnDefinition();
                if (columnDefinition == null) {
                    i2 = i3;
                    i = length;
                    fieldTypeArr = fieldTypes;
                    databaseType.appendColumnArg(tableInfo.getTableName(), sb, fieldType, arrayList, arrayList2, arrayList3, list2);
                } else {
                    i2 = i3;
                    i = length;
                    fieldTypeArr = fieldTypes;
                    databaseType2.appendEscapedEntityName(sb, fieldType.getColumnName());
                    sb.append(' ');
                    sb.append(columnDefinition);
                    sb.append(' ');
                }
                z4 = z2;
            }
            i3 = i2 + 1;
            length = i;
            fieldTypes = fieldTypeArr;
            TableInfo<T, ID> tableInfo3 = tableInfo;
        }
        DatabaseType databaseType3 = databaseType;
        ArrayList arrayList4 = arrayList;
        ArrayList arrayList5 = arrayList2;
        ArrayList arrayList6 = arrayList3;
        List<String> list4 = list2;
        databaseType3.addPrimaryKeySql(tableInfo.getFieldTypes(), arrayList4, arrayList5, arrayList6, list4);
        databaseType3.addUniqueComboSql(tableInfo.getFieldTypes(), arrayList4, arrayList5, arrayList6, list4);
        for (String str : arrayList) {
            sb.append(", ");
            sb.append(str);
        }
        sb.append(") ");
        databaseType2.appendCreateTableSuffix(sb);
        list3.addAll(arrayList2);
        list3.add(sb.toString());
        list3.addAll(arrayList3);
        TableInfo<T, ID> tableInfo4 = tableInfo;
        addCreateIndexStatements(databaseType2, tableInfo4, list3, z3, false);
        addCreateIndexStatements(databaseType2, tableInfo4, list3, z3, true);
    }

    private static <T, ID> void addCreateIndexStatements(DatabaseType databaseType, TableInfo<T, ID> tableInfo, List<String> list, boolean z, boolean z2) {
        FieldType[] fieldTypes;
        String str;
        HashMap hashMap = new HashMap();
        for (FieldType fieldType : tableInfo.getFieldTypes()) {
            if (z2) {
                str = fieldType.getUniqueIndexName();
            } else {
                str = fieldType.getIndexName();
            }
            if (str != null) {
                List list2 = (List) hashMap.get(str);
                if (list2 == null) {
                    list2 = new ArrayList();
                    hashMap.put(str, list2);
                }
                list2.add(fieldType.getColumnName());
            }
        }
        StringBuilder sb = new StringBuilder(128);
        for (Entry entry : hashMap.entrySet()) {
            logger.info("creating index '{}' for table '{}", entry.getKey(), (Object) tableInfo.getTableName());
            sb.append("CREATE ");
            if (z2) {
                sb.append("UNIQUE ");
            }
            sb.append("INDEX ");
            if (z && databaseType.isCreateIndexIfNotExistsSupported()) {
                sb.append("IF NOT EXISTS ");
            }
            databaseType.appendEscapedEntityName(sb, (String) entry.getKey());
            sb.append(" ON ");
            databaseType.appendEscapedEntityName(sb, tableInfo.getTableName());
            sb.append(" ( ");
            boolean z3 = true;
            for (String str2 : (List) entry.getValue()) {
                if (z3) {
                    z3 = false;
                } else {
                    sb.append(", ");
                }
                databaseType.appendEscapedEntityName(sb, str2);
            }
            sb.append(" )");
            list.add(sb.toString());
            sb.setLength(0);
        }
    }

    private static <T, ID> void addDropTableStatements(DatabaseType databaseType, TableInfo<T, ID> tableInfo, List<String> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (FieldType dropColumnArg : tableInfo.getFieldTypes()) {
            databaseType.dropColumnArg(dropColumnArg, arrayList, arrayList2);
        }
        StringBuilder sb = new StringBuilder(64);
        sb.append("DROP TABLE ");
        databaseType.appendEscapedEntityName(sb, tableInfo.getTableName());
        sb.append(' ');
        list.addAll(arrayList);
        list.add(sb.toString());
        list.addAll(arrayList2);
    }

    private static <T, ID> int doCreateTable(ConnectionSource connectionSource, TableInfo<T, ID> tableInfo, boolean z) throws SQLException {
        DatabaseType databaseType = connectionSource.getDatabaseType();
        logger.info("creating table '{}'", (Object) tableInfo.getTableName());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        addCreateTableStatements(databaseType, tableInfo, arrayList, arrayList2, z);
        DatabaseConnection readWriteConnection = connectionSource.getReadWriteConnection();
        try {
            return doStatements(readWriteConnection, "create", arrayList, false, databaseType.isCreateTableReturnsNegative(), databaseType.isCreateTableReturnsZero()) + doCreateTestQueries(readWriteConnection, databaseType, arrayList2);
        } finally {
            connectionSource.releaseConnection(readWriteConnection);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0030, code lost:
        r5 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
        r8 = r4;
        r4 = r3;
        r3 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0035, code lost:
        r9 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0036, code lost:
        r3 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003c, code lost:
        r9 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        logger.info("ignoring {} error '{}' for statement: {}", (java.lang.Object) r10, (java.lang.Object) r5, (java.lang.Object) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004a, code lost:
        if (r3 != null) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004c, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004f, code lost:
        r3 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        r9 = new java.lang.StringBuilder();
        r9.append("SQL statement failed: ");
        r9.append(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00b6, code lost:
        throw com.j256.ormlite.misc.SqlExceptionUtil.create(r9.toString(), r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b7, code lost:
        if (r3 != null) goto L_0x00b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b9, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00bc, code lost:
        throw r9;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0035 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:6:0x001b] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0043 A[SYNTHETIC, Splitter:B:22:0x0043] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0079 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a1 A[SYNTHETIC, Splitter:B:36:0x00a1] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int doStatements(com.j256.ormlite.support.DatabaseConnection r9, java.lang.String r10, java.util.Collection<java.lang.String> r11, boolean r12, boolean r13, boolean r14) throws java.sql.SQLException {
        /*
            java.util.Iterator r11 = r11.iterator()
            r0 = 0
            r1 = 0
        L_0x0006:
            boolean r2 = r11.hasNext()
            if (r2 == 0) goto L_0x00bd
            java.lang.Object r2 = r11.next()
            java.lang.String r2 = (java.lang.String) r2
            r3 = 0
            com.j256.ormlite.stmt.StatementBuilder$StatementType r4 = com.j256.ormlite.stmt.StatementBuilder.StatementType.EXECUTE     // Catch:{ SQLException -> 0x003f }
            com.j256.ormlite.field.FieldType[] r5 = noFieldTypes     // Catch:{ SQLException -> 0x003f }
            com.j256.ormlite.support.CompiledStatement r4 = r9.compileStatement(r2, r4, r5)     // Catch:{ SQLException -> 0x003f }
            int r3 = r4.runExecute()     // Catch:{ SQLException -> 0x0039, all -> 0x0035 }
            com.j256.ormlite.logger.Logger r5 = logger     // Catch:{ SQLException -> 0x0030, all -> 0x0035 }
            java.lang.String r6 = "executed {} table statement changed {} rows: {}"
            java.lang.Integer r7 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLException -> 0x0030, all -> 0x0035 }
            r5.info(r6, r10, r7, r2)     // Catch:{ SQLException -> 0x0030, all -> 0x0035 }
            if (r4 == 0) goto L_0x0050
            r4.close()
            goto L_0x0050
        L_0x0030:
            r5 = move-exception
            r8 = r4
            r4 = r3
            r3 = r8
            goto L_0x0041
        L_0x0035:
            r9 = move-exception
            r3 = r4
            goto L_0x00b7
        L_0x0039:
            r5 = move-exception
            r3 = r4
            goto L_0x0040
        L_0x003c:
            r9 = move-exception
            goto L_0x00b7
        L_0x003f:
            r5 = move-exception
        L_0x0040:
            r4 = 0
        L_0x0041:
            if (r12 == 0) goto L_0x00a1
            com.j256.ormlite.logger.Logger r6 = logger     // Catch:{ all -> 0x003c }
            java.lang.String r7 = "ignoring {} error '{}' for statement: {}"
            r6.info(r7, r10, r5, r2)     // Catch:{ all -> 0x003c }
            if (r3 == 0) goto L_0x004f
            r3.close()
        L_0x004f:
            r3 = r4
        L_0x0050:
            if (r3 >= 0) goto L_0x0079
            if (r13 == 0) goto L_0x0055
            goto L_0x009d
        L_0x0055:
            java.sql.SQLException r9 = new java.sql.SQLException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "SQL statement "
            r10.append(r11)
            r10.append(r2)
            java.lang.String r11 = " updated "
            r10.append(r11)
            r10.append(r3)
            java.lang.String r11 = " rows, we were expecting >= 0"
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L_0x0079:
            if (r3 <= 0) goto L_0x009d
            if (r14 != 0) goto L_0x007e
            goto L_0x009d
        L_0x007e:
            java.sql.SQLException r9 = new java.sql.SQLException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "SQL statement updated "
            r10.append(r11)
            r10.append(r3)
            java.lang.String r11 = " rows, we were expecting == 0: "
            r10.append(r11)
            r10.append(r2)
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L_0x009d:
            int r1 = r1 + 1
            goto L_0x0006
        L_0x00a1:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x003c }
            r9.<init>()     // Catch:{ all -> 0x003c }
            java.lang.String r10 = "SQL statement failed: "
            r9.append(r10)     // Catch:{ all -> 0x003c }
            r9.append(r2)     // Catch:{ all -> 0x003c }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x003c }
            java.sql.SQLException r9 = com.j256.ormlite.misc.SqlExceptionUtil.create(r9, r5)     // Catch:{ all -> 0x003c }
            throw r9     // Catch:{ all -> 0x003c }
        L_0x00b7:
            if (r3 == 0) goto L_0x00bc
            r3.close()
        L_0x00bc:
            throw r9
        L_0x00bd:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.table.TableUtils.doStatements(com.j256.ormlite.support.DatabaseConnection, java.lang.String, java.util.Collection, boolean, boolean, boolean):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0061  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int doCreateTestQueries(com.j256.ormlite.support.DatabaseConnection r6, com.j256.ormlite.p127db.DatabaseType r7, java.util.List<java.lang.String> r8) throws java.sql.SQLException {
        /*
            java.util.Iterator r7 = r8.iterator()
            r8 = 0
            r0 = 0
        L_0x0006:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x0065
            java.lang.Object r1 = r7.next()
            java.lang.String r1 = (java.lang.String) r1
            r2 = 0
            com.j256.ormlite.stmt.StatementBuilder$StatementType r3 = com.j256.ormlite.stmt.StatementBuilder.StatementType.SELECT     // Catch:{ SQLException -> 0x0048 }
            com.j256.ormlite.field.FieldType[] r4 = noFieldTypes     // Catch:{ SQLException -> 0x0048 }
            com.j256.ormlite.support.CompiledStatement r3 = r6.compileStatement(r1, r3, r4)     // Catch:{ SQLException -> 0x0048 }
            com.j256.ormlite.support.DatabaseResults r2 = r3.runQuery(r2)     // Catch:{ SQLException -> 0x0043, all -> 0x0040 }
            boolean r4 = r2.first()     // Catch:{ SQLException -> 0x0043, all -> 0x0040 }
            r5 = 0
        L_0x0024:
            if (r4 == 0) goto L_0x002d
            int r5 = r5 + 1
            boolean r4 = r2.next()     // Catch:{ SQLException -> 0x0043, all -> 0x0040 }
            goto L_0x0024
        L_0x002d:
            com.j256.ormlite.logger.Logger r2 = logger     // Catch:{ SQLException -> 0x0043, all -> 0x0040 }
            java.lang.String r4 = "executing create table after-query got {} results: {}"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ SQLException -> 0x0043, all -> 0x0040 }
            r2.info(r4, r5, r1)     // Catch:{ SQLException -> 0x0043, all -> 0x0040 }
            if (r3 == 0) goto L_0x003d
            r3.close()
        L_0x003d:
            int r0 = r0 + 1
            goto L_0x0006
        L_0x0040:
            r6 = move-exception
            r2 = r3
            goto L_0x005f
        L_0x0043:
            r6 = move-exception
            r2 = r3
            goto L_0x0049
        L_0x0046:
            r6 = move-exception
            goto L_0x005f
        L_0x0048:
            r6 = move-exception
        L_0x0049:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0046 }
            r7.<init>()     // Catch:{ all -> 0x0046 }
            java.lang.String r8 = "executing create table after-query failed: "
            r7.append(r8)     // Catch:{ all -> 0x0046 }
            r7.append(r1)     // Catch:{ all -> 0x0046 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0046 }
            java.sql.SQLException r6 = com.j256.ormlite.misc.SqlExceptionUtil.create(r7, r6)     // Catch:{ all -> 0x0046 }
            throw r6     // Catch:{ all -> 0x0046 }
        L_0x005f:
            if (r2 == 0) goto L_0x0064
            r2.close()
        L_0x0064:
            throw r6
        L_0x0065:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.table.TableUtils.doCreateTestQueries(com.j256.ormlite.support.DatabaseConnection, com.j256.ormlite.db.DatabaseType, java.util.List):int");
    }

    private static <T, ID> List<String> addCreateTableStatements(ConnectionSource connectionSource, TableInfo<T, ID> tableInfo, boolean z) throws SQLException {
        ArrayList arrayList = new ArrayList();
        addCreateTableStatements(connectionSource.getDatabaseType(), tableInfo, arrayList, new ArrayList(), z);
        return arrayList;
    }
}
