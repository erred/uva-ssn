package com.j256.ormlite.android;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.misc.VersionUtils;
import com.j256.ormlite.stmt.StatementBuilder.StatementType;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.DatabaseConnection;
import java.sql.SQLException;
import java.sql.Savepoint;
import net.sqlcipher.Cursor;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteStatement;

public class AndroidDatabaseConnection implements DatabaseConnection {
    private static final String ANDROID_VERSION = "VERSION__4.46__";
    private static final String[] NO_STRING_ARGS = new String[0];
    private static Logger logger = LoggerFactory.getLogger(AndroidDatabaseConnection.class);

    /* renamed from: db */
    private final SQLiteDatabase f6803db;
    private final boolean readWrite;

    private static class OurSavePoint implements Savepoint {
        private String name;

        public int getSavepointId() {
            return 0;
        }

        public OurSavePoint(String str) {
            this.name = str;
        }

        public String getSavepointName() {
            return this.name;
        }
    }

    public boolean isAutoCommitSupported() {
        return true;
    }

    static {
        VersionUtils.checkCoreVersusAndroidVersions(ANDROID_VERSION);
    }

    public AndroidDatabaseConnection(SQLiteDatabase sQLiteDatabase, boolean z) {
        this.f6803db = sQLiteDatabase;
        this.readWrite = z;
        logger.trace("{}: db {} opened, read-write = {}", (Object) this, (Object) sQLiteDatabase, (Object) Boolean.valueOf(z));
    }

    public boolean isAutoCommit() throws SQLException {
        try {
            boolean inTransaction = this.f6803db.inTransaction();
            logger.trace("{}: in transaction is {}", (Object) this, (Object) Boolean.valueOf(inTransaction));
            return !inTransaction;
        } catch (android.database.SQLException e) {
            throw SqlExceptionUtil.create("problems getting auto-commit from database", e);
        }
    }

    public void setAutoCommit(boolean z) {
        if (z) {
            if (this.f6803db.inTransaction()) {
                this.f6803db.setTransactionSuccessful();
                this.f6803db.endTransaction();
            }
        } else if (!this.f6803db.inTransaction()) {
            this.f6803db.beginTransaction();
        }
    }

    public Savepoint setSavePoint(String str) throws SQLException {
        try {
            this.f6803db.beginTransaction();
            logger.trace("{}: save-point set with name {}", (Object) this, (Object) str);
            return new OurSavePoint(str);
        } catch (android.database.SQLException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("problems beginning transaction ");
            sb.append(str);
            throw SqlExceptionUtil.create(sb.toString(), e);
        }
    }

    public boolean isReadWrite() {
        return this.readWrite;
    }

    public void commit(Savepoint savepoint) throws SQLException {
        try {
            this.f6803db.setTransactionSuccessful();
            this.f6803db.endTransaction();
            if (savepoint == null) {
                logger.trace("{}: transaction is successfuly ended", (Object) this);
            } else {
                logger.trace("{}: transaction {} is successfuly ended", (Object) this, (Object) savepoint.getSavepointName());
            }
        } catch (android.database.SQLException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("problems commiting transaction ");
            sb.append(savepoint.getSavepointName());
            throw SqlExceptionUtil.create(sb.toString(), e);
        }
    }

    public void rollback(Savepoint savepoint) throws SQLException {
        try {
            this.f6803db.endTransaction();
            if (savepoint == null) {
                logger.trace("{}: transaction is ended, unsuccessfuly", (Object) this);
            } else {
                logger.trace("{}: transaction {} is ended, unsuccessfuly", (Object) this, (Object) savepoint.getSavepointName());
            }
        } catch (android.database.SQLException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("problems rolling back transaction ");
            sb.append(savepoint.getSavepointName());
            throw SqlExceptionUtil.create(sb.toString(), e);
        }
    }

    public int executeStatement(String str, int i) throws SQLException {
        return AndroidCompiledStatement.execSql(this.f6803db, str, str, NO_STRING_ARGS);
    }

    public CompiledStatement compileStatement(String str, StatementType statementType, FieldType[] fieldTypeArr) {
        AndroidCompiledStatement androidCompiledStatement = new AndroidCompiledStatement(str, this.f6803db, statementType);
        logger.trace("{}: compiled statement got {}: {}", (Object) this, (Object) androidCompiledStatement, (Object) str);
        return androidCompiledStatement;
    }

    public CompiledStatement compileStatement(String str, StatementType statementType, FieldType[] fieldTypeArr, int i) {
        return compileStatement(str, statementType, fieldTypeArr);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x004a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int insert(java.lang.String r3, java.lang.Object[] r4, com.j256.ormlite.field.FieldType[] r5, com.j256.ormlite.support.GeneratedKeyHolder r6) throws java.sql.SQLException {
        /*
            r2 = this;
            r0 = 0
            net.sqlcipher.database.SQLiteDatabase r1 = r2.f6803db     // Catch:{ SQLException -> 0x0031 }
            net.sqlcipher.database.SQLiteStatement r1 = r1.compileStatement(r3)     // Catch:{ SQLException -> 0x0031 }
            r2.bindArgs(r1, r4, r5)     // Catch:{ SQLException -> 0x002c, all -> 0x0029 }
            long r4 = r1.executeInsert()     // Catch:{ SQLException -> 0x002c, all -> 0x0029 }
            if (r6 == 0) goto L_0x0017
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ SQLException -> 0x002c, all -> 0x0029 }
            r6.addKey(r4)     // Catch:{ SQLException -> 0x002c, all -> 0x0029 }
        L_0x0017:
            r4 = 1
            com.j256.ormlite.logger.Logger r5 = logger     // Catch:{ SQLException -> 0x002c, all -> 0x0029 }
            java.lang.String r6 = "{}: insert statement is compiled and executed, changed {}: {}"
            java.lang.Integer r0 = java.lang.Integer.valueOf(r4)     // Catch:{ SQLException -> 0x002c, all -> 0x0029 }
            r5.trace(r6, r2, r0, r3)     // Catch:{ SQLException -> 0x002c, all -> 0x0029 }
            if (r1 == 0) goto L_0x0028
            r1.close()
        L_0x0028:
            return r4
        L_0x0029:
            r3 = move-exception
            r0 = r1
            goto L_0x0048
        L_0x002c:
            r4 = move-exception
            r0 = r1
            goto L_0x0032
        L_0x002f:
            r3 = move-exception
            goto L_0x0048
        L_0x0031:
            r4 = move-exception
        L_0x0032:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x002f }
            r5.<init>()     // Catch:{ all -> 0x002f }
            java.lang.String r6 = "inserting to database failed: "
            r5.append(r6)     // Catch:{ all -> 0x002f }
            r5.append(r3)     // Catch:{ all -> 0x002f }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x002f }
            java.sql.SQLException r3 = com.j256.ormlite.misc.SqlExceptionUtil.create(r3, r4)     // Catch:{ all -> 0x002f }
            throw r3     // Catch:{ all -> 0x002f }
        L_0x0048:
            if (r0 == 0) goto L_0x004d
            r0.close()
        L_0x004d:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.android.AndroidDatabaseConnection.insert(java.lang.String, java.lang.Object[], com.j256.ormlite.field.FieldType[], com.j256.ormlite.support.GeneratedKeyHolder):int");
    }

    public int update(String str, Object[] objArr, FieldType[] fieldTypeArr) throws SQLException {
        return update(str, objArr, fieldTypeArr, "updated");
    }

    public int delete(String str, Object[] objArr, FieldType[] fieldTypeArr) throws SQLException {
        return update(str, objArr, fieldTypeArr, "deleted");
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x005d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> java.lang.Object queryForOne(java.lang.String r4, java.lang.Object[] r5, com.j256.ormlite.field.FieldType[] r6, com.j256.ormlite.stmt.GenericRowMapper<T> r7, com.j256.ormlite.dao.ObjectCache r8) throws java.sql.SQLException {
        /*
            r3 = this;
            r6 = 0
            net.sqlcipher.database.SQLiteDatabase r0 = r3.f6803db     // Catch:{ SQLException -> 0x0040, all -> 0x003d }
            java.lang.String[] r5 = r3.toStrings(r5)     // Catch:{ SQLException -> 0x0040, all -> 0x003d }
            net.sqlcipher.Cursor r5 = r0.rawQuery(r4, r5)     // Catch:{ SQLException -> 0x0040, all -> 0x003d }
            com.j256.ormlite.android.AndroidDatabaseResults r0 = new com.j256.ormlite.android.AndroidDatabaseResults     // Catch:{ SQLException -> 0x003b }
            r0.<init>(r5, r8)     // Catch:{ SQLException -> 0x003b }
            com.j256.ormlite.logger.Logger r8 = logger     // Catch:{ SQLException -> 0x003b }
            java.lang.String r1 = "{}: queried for one result: {}"
            r8.trace(r1, r3, r4)     // Catch:{ SQLException -> 0x003b }
            boolean r8 = r0.first()     // Catch:{ SQLException -> 0x003b }
            if (r8 != 0) goto L_0x0023
            if (r5 == 0) goto L_0x0022
            r5.close()
        L_0x0022:
            return r6
        L_0x0023:
            java.lang.Object r6 = r7.mapRow(r0)     // Catch:{ SQLException -> 0x003b }
            boolean r7 = r0.next()     // Catch:{ SQLException -> 0x003b }
            if (r7 == 0) goto L_0x0035
            java.lang.Object r6 = MORE_THAN_ONE     // Catch:{ SQLException -> 0x003b }
            if (r5 == 0) goto L_0x0034
            r5.close()
        L_0x0034:
            return r6
        L_0x0035:
            if (r5 == 0) goto L_0x003a
            r5.close()
        L_0x003a:
            return r6
        L_0x003b:
            r6 = move-exception
            goto L_0x0044
        L_0x003d:
            r4 = move-exception
            r5 = r6
            goto L_0x005b
        L_0x0040:
            r5 = move-exception
            r2 = r6
            r6 = r5
            r5 = r2
        L_0x0044:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x005a }
            r7.<init>()     // Catch:{ all -> 0x005a }
            java.lang.String r8 = "queryForOne from database failed: "
            r7.append(r8)     // Catch:{ all -> 0x005a }
            r7.append(r4)     // Catch:{ all -> 0x005a }
            java.lang.String r4 = r7.toString()     // Catch:{ all -> 0x005a }
            java.sql.SQLException r4 = com.j256.ormlite.misc.SqlExceptionUtil.create(r4, r6)     // Catch:{ all -> 0x005a }
            throw r4     // Catch:{ all -> 0x005a }
        L_0x005a:
            r4 = move-exception
        L_0x005b:
            if (r5 == 0) goto L_0x0060
            r5.close()
        L_0x0060:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.android.AndroidDatabaseConnection.queryForOne(java.lang.String, java.lang.Object[], com.j256.ormlite.field.FieldType[], com.j256.ormlite.stmt.GenericRowMapper, com.j256.ormlite.dao.ObjectCache):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long queryForLong(java.lang.String r8) throws java.sql.SQLException {
        /*
            r7 = this;
            r0 = 0
            net.sqlcipher.database.SQLiteDatabase r1 = r7.f6803db     // Catch:{ SQLException -> 0x0021, all -> 0x001e }
            net.sqlcipher.database.SQLiteStatement r1 = r1.compileStatement(r8)     // Catch:{ SQLException -> 0x0021, all -> 0x001e }
            long r2 = r1.simpleQueryForLong()     // Catch:{ SQLException -> 0x001c }
            com.j256.ormlite.logger.Logger r0 = logger     // Catch:{ SQLException -> 0x001c }
            java.lang.String r4 = "{}: query for long simple query returned {}: {}"
            java.lang.Long r5 = java.lang.Long.valueOf(r2)     // Catch:{ SQLException -> 0x001c }
            r0.trace(r4, r7, r5, r8)     // Catch:{ SQLException -> 0x001c }
            if (r1 == 0) goto L_0x001b
            r1.close()
        L_0x001b:
            return r2
        L_0x001c:
            r0 = move-exception
            goto L_0x0025
        L_0x001e:
            r8 = move-exception
            r1 = r0
            goto L_0x003c
        L_0x0021:
            r1 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
        L_0x0025:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x003b }
            r2.<init>()     // Catch:{ all -> 0x003b }
            java.lang.String r3 = "queryForLong from database failed: "
            r2.append(r3)     // Catch:{ all -> 0x003b }
            r2.append(r8)     // Catch:{ all -> 0x003b }
            java.lang.String r8 = r2.toString()     // Catch:{ all -> 0x003b }
            java.sql.SQLException r8 = com.j256.ormlite.misc.SqlExceptionUtil.create(r8, r0)     // Catch:{ all -> 0x003b }
            throw r8     // Catch:{ all -> 0x003b }
        L_0x003b:
            r8 = move-exception
        L_0x003c:
            if (r1 == 0) goto L_0x0041
            r1.close()
        L_0x0041:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.android.AndroidDatabaseConnection.queryForLong(java.lang.String):long");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0051  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long queryForLong(java.lang.String r6, java.lang.Object[] r7, com.j256.ormlite.field.FieldType[] r8) throws java.sql.SQLException {
        /*
            r5 = this;
            r8 = 0
            net.sqlcipher.database.SQLiteDatabase r0 = r5.f6803db     // Catch:{ SQLException -> 0x0034, all -> 0x0031 }
            java.lang.String[] r7 = r5.toStrings(r7)     // Catch:{ SQLException -> 0x0034, all -> 0x0031 }
            net.sqlcipher.Cursor r7 = r0.rawQuery(r6, r7)     // Catch:{ SQLException -> 0x0034, all -> 0x0031 }
            com.j256.ormlite.android.AndroidDatabaseResults r0 = new com.j256.ormlite.android.AndroidDatabaseResults     // Catch:{ SQLException -> 0x002f }
            r0.<init>(r7, r8)     // Catch:{ SQLException -> 0x002f }
            boolean r8 = r0.first()     // Catch:{ SQLException -> 0x002f }
            if (r8 == 0) goto L_0x001c
            r8 = 0
            long r0 = r0.getLong(r8)     // Catch:{ SQLException -> 0x002f }
            goto L_0x001e
        L_0x001c:
            r0 = 0
        L_0x001e:
            com.j256.ormlite.logger.Logger r8 = logger     // Catch:{ SQLException -> 0x002f }
            java.lang.String r2 = "{}: query for long raw query returned {}: {}"
            java.lang.Long r3 = java.lang.Long.valueOf(r0)     // Catch:{ SQLException -> 0x002f }
            r8.trace(r2, r5, r3, r6)     // Catch:{ SQLException -> 0x002f }
            if (r7 == 0) goto L_0x002e
            r7.close()
        L_0x002e:
            return r0
        L_0x002f:
            r8 = move-exception
            goto L_0x0038
        L_0x0031:
            r6 = move-exception
            r7 = r8
            goto L_0x004f
        L_0x0034:
            r7 = move-exception
            r4 = r8
            r8 = r7
            r7 = r4
        L_0x0038:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x004e }
            r0.<init>()     // Catch:{ all -> 0x004e }
            java.lang.String r1 = "queryForLong from database failed: "
            r0.append(r1)     // Catch:{ all -> 0x004e }
            r0.append(r6)     // Catch:{ all -> 0x004e }
            java.lang.String r6 = r0.toString()     // Catch:{ all -> 0x004e }
            java.sql.SQLException r6 = com.j256.ormlite.misc.SqlExceptionUtil.create(r6, r8)     // Catch:{ all -> 0x004e }
            throw r6     // Catch:{ all -> 0x004e }
        L_0x004e:
            r6 = move-exception
        L_0x004f:
            if (r7 == 0) goto L_0x0054
            r7.close()
        L_0x0054:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.android.AndroidDatabaseConnection.queryForLong(java.lang.String, java.lang.Object[], com.j256.ormlite.field.FieldType[]):long");
    }

    public void close() throws SQLException {
        try {
            this.f6803db.close();
            logger.trace("{}: db {} closed", (Object) this, (Object) this.f6803db);
        } catch (android.database.SQLException e) {
            throw SqlExceptionUtil.create("problems closing the database connection", e);
        }
    }

    public void closeQuietly() {
        try {
            close();
        } catch (SQLException unused) {
        }
    }

    public boolean isClosed() throws SQLException {
        try {
            boolean isOpen = this.f6803db.isOpen();
            logger.trace("{}: db {} isOpen returned {}", (Object) this, (Object) this.f6803db, (Object) Boolean.valueOf(isOpen));
            return !isOpen;
        } catch (android.database.SQLException e) {
            throw SqlExceptionUtil.create("problems detecting if the database is closed", e);
        }
    }

    public boolean isTableExists(String str) {
        boolean z;
        SQLiteDatabase sQLiteDatabase = this.f6803db;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT DISTINCT tbl_name FROM sqlite_master WHERE tbl_name = '");
        sb.append(str);
        sb.append("'");
        Cursor rawQuery = sQLiteDatabase.rawQuery(sb.toString(), null);
        if (rawQuery != null) {
            try {
                if (rawQuery.getCount() > 0) {
                    z = true;
                    logger.trace("{}: isTableExists '{}' returned {}", (Object) this, (Object) str, (Object) Boolean.valueOf(z));
                    rawQuery.close();
                    return z;
                }
            } catch (Throwable th) {
                rawQuery.close();
                throw th;
            }
        }
        z = false;
        logger.trace("{}: isTableExists '{}' returned {}", (Object) this, (Object) str, (Object) Boolean.valueOf(z));
        rawQuery.close();
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0067  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int update(java.lang.String r3, java.lang.Object[] r4, com.j256.ormlite.field.FieldType[] r5, java.lang.String r6) throws java.sql.SQLException {
        /*
            r2 = this;
            r0 = 0
            net.sqlcipher.database.SQLiteDatabase r1 = r2.f6803db     // Catch:{ SQLException -> 0x004e }
            net.sqlcipher.database.SQLiteStatement r1 = r1.compileStatement(r3)     // Catch:{ SQLException -> 0x004e }
            r2.bindArgs(r1, r4, r5)     // Catch:{ SQLException -> 0x0049, all -> 0x0046 }
            r1.execute()     // Catch:{ SQLException -> 0x0049, all -> 0x0046 }
            if (r1 == 0) goto L_0x0013
            r1.close()
            goto L_0x0014
        L_0x0013:
            r0 = r1
        L_0x0014:
            net.sqlcipher.database.SQLiteDatabase r4 = r2.f6803db     // Catch:{ SQLException -> 0x0033, all -> 0x002c }
            java.lang.String r5 = "SELECT CHANGES()"
            net.sqlcipher.database.SQLiteStatement r4 = r4.compileStatement(r5)     // Catch:{ SQLException -> 0x0033, all -> 0x002c }
            long r0 = r4.simpleQueryForLong()     // Catch:{ SQLException -> 0x002a, all -> 0x0027 }
            int r5 = (int) r0
            if (r4 == 0) goto L_0x003a
            r4.close()
            goto L_0x003a
        L_0x0027:
            r3 = move-exception
            r0 = r4
            goto L_0x002d
        L_0x002a:
            r0 = r4
            goto L_0x0034
        L_0x002c:
            r3 = move-exception
        L_0x002d:
            if (r0 == 0) goto L_0x0032
            r0.close()
        L_0x0032:
            throw r3
        L_0x0033:
        L_0x0034:
            r5 = 1
            if (r0 == 0) goto L_0x003a
            r0.close()
        L_0x003a:
            com.j256.ormlite.logger.Logger r4 = logger
            java.lang.String r0 = "{} statement is compiled and executed, changed {}: {}"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
            r4.trace(r0, r6, r1, r3)
            return r5
        L_0x0046:
            r3 = move-exception
            r0 = r1
            goto L_0x0065
        L_0x0049:
            r4 = move-exception
            r0 = r1
            goto L_0x004f
        L_0x004c:
            r3 = move-exception
            goto L_0x0065
        L_0x004e:
            r4 = move-exception
        L_0x004f:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x004c }
            r5.<init>()     // Catch:{ all -> 0x004c }
            java.lang.String r6 = "updating database failed: "
            r5.append(r6)     // Catch:{ all -> 0x004c }
            r5.append(r3)     // Catch:{ all -> 0x004c }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x004c }
            java.sql.SQLException r3 = com.j256.ormlite.misc.SqlExceptionUtil.create(r3, r4)     // Catch:{ all -> 0x004c }
            throw r3     // Catch:{ all -> 0x004c }
        L_0x0065:
            if (r0 == 0) goto L_0x006a
            r0.close()
        L_0x006a:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.android.AndroidDatabaseConnection.update(java.lang.String, java.lang.Object[], com.j256.ormlite.field.FieldType[], java.lang.String):int");
    }

    private void bindArgs(SQLiteStatement sQLiteStatement, Object[] objArr, FieldType[] fieldTypeArr) throws SQLException {
        if (objArr != null) {
            for (int i = 0; i < objArr.length; i++) {
                byte[] bArr = objArr[i];
                if (bArr == null) {
                    sQLiteStatement.bindNull(i + 1);
                } else {
                    SqlType sqlType = fieldTypeArr[i].getSqlType();
                    switch (sqlType) {
                        case STRING:
                        case LONG_STRING:
                        case CHAR:
                            sQLiteStatement.bindString(i + 1, bArr.toString());
                            break;
                        case BOOLEAN:
                        case BYTE:
                        case SHORT:
                        case INTEGER:
                        case LONG:
                            sQLiteStatement.bindLong(i + 1, ((Number) bArr).longValue());
                            break;
                        case FLOAT:
                        case DOUBLE:
                            sQLiteStatement.bindDouble(i + 1, ((Number) bArr).doubleValue());
                            break;
                        case BYTE_ARRAY:
                        case SERIALIZABLE:
                            sQLiteStatement.bindBlob(i + 1, bArr);
                            break;
                        case DATE:
                        case BLOB:
                        case BIG_DECIMAL:
                            StringBuilder sb = new StringBuilder();
                            sb.append("Invalid Android type: ");
                            sb.append(sqlType);
                            throw new SQLException(sb.toString());
                        default:
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Unknown sql argument type: ");
                            sb2.append(sqlType);
                            throw new SQLException(sb2.toString());
                    }
                }
            }
        }
    }

    private String[] toStrings(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return null;
        }
        String[] strArr = new String[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj == null) {
                strArr[i] = null;
            } else {
                strArr[i] = obj.toString();
            }
        }
        return strArr;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("@");
        sb.append(Integer.toHexString(super.hashCode()));
        return sb.toString();
    }
}
