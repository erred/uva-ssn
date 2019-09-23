package com.j256.ormlite.android;

import android.database.Cursor;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.stmt.StatementBuilder.StatementType;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import net.sqlcipher.database.SQLiteDatabase;

public class AndroidCompiledStatement implements CompiledStatement {
    private static final String[] NO_STRING_ARGS = new String[0];
    private static Logger logger = LoggerFactory.getLogger(AndroidCompiledStatement.class);
    private List<Object> args;
    private Cursor cursor;

    /* renamed from: db */
    private final SQLiteDatabase f6802db;
    private Integer max;
    private final String sql;
    private final StatementType type;

    public void setQueryTimeout(long j) {
    }

    public AndroidCompiledStatement(String str, SQLiteDatabase sQLiteDatabase, StatementType statementType) {
        this.sql = str;
        this.f6802db = sQLiteDatabase;
        this.type = statementType;
    }

    public int getColumnCount() throws SQLException {
        return getCursor().getColumnCount();
    }

    public String getColumnName(int i) throws SQLException {
        return getCursor().getColumnName(i);
    }

    public DatabaseResults runQuery(ObjectCache objectCache) throws SQLException {
        if (this.type.isOkForQuery()) {
            return new AndroidDatabaseResults(getCursor(), objectCache);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot call query on a ");
        sb.append(this.type);
        sb.append(" statement");
        throw new IllegalArgumentException(sb.toString());
    }

    public int runUpdate() throws SQLException {
        String str;
        if (this.type.isOkForUpdate()) {
            if (this.max == null) {
                str = this.sql;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(this.sql);
                sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                sb.append(this.max);
                str = sb.toString();
            }
            return execSql(this.f6802db, "runUpdate", str, getArgArray());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Cannot call update on a ");
        sb2.append(this.type);
        sb2.append(" statement");
        throw new IllegalArgumentException(sb2.toString());
    }

    public int runExecute() throws SQLException {
        if (this.type.isOkForExecute()) {
            return execSql(this.f6802db, "runExecute", this.sql, getArgArray());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot call execute on a ");
        sb.append(this.type);
        sb.append(" statement");
        throw new IllegalArgumentException(sb.toString());
    }

    public void close() throws SQLException {
        if (this.cursor != null) {
            try {
                this.cursor.close();
            } catch (android.database.SQLException e) {
                throw SqlExceptionUtil.create("Problems closing Android cursor", e);
            }
        }
    }

    public void closeQuietly() {
        try {
            close();
        } catch (SQLException unused) {
        }
    }

    public void setObject(int i, Object obj, SqlType sqlType) throws SQLException {
        isInPrep();
        if (this.args == null) {
            this.args = new ArrayList();
        }
        if (obj == null) {
            this.args.add(i, null);
            return;
        }
        switch (sqlType) {
            case STRING:
            case LONG_STRING:
            case DATE:
            case BOOLEAN:
            case CHAR:
            case BYTE:
            case SHORT:
            case INTEGER:
            case LONG:
            case FLOAT:
            case DOUBLE:
                this.args.add(i, obj.toString());
                break;
            case BYTE_ARRAY:
            case SERIALIZABLE:
                this.args.add(i, obj);
                break;
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

    public void setMaxRows(int i) throws SQLException {
        isInPrep();
        this.max = Integer.valueOf(i);
    }

    public Cursor getCursor() throws SQLException {
        String sb;
        if (this.cursor == null) {
            try {
                if (this.max == null) {
                    sb = this.sql;
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(this.sql);
                    sb2.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                    sb2.append(this.max);
                    sb = sb2.toString();
                }
                String str = sb;
                this.cursor = this.f6802db.rawQuery(str, getStringArray());
                this.cursor.moveToFirst();
                logger.trace("{}: started rawQuery cursor for: {}", (Object) this, (Object) str);
            } catch (android.database.SQLException e) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Problems executing Android query: ");
                sb3.append(null);
                throw SqlExceptionUtil.create(sb3.toString(), e);
            }
        }
        return this.cursor;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("@");
        sb.append(Integer.toHexString(super.hashCode()));
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x001e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int execSql(net.sqlcipher.database.SQLiteDatabase r2, java.lang.String r3, java.lang.String r4, java.lang.Object[] r5) throws java.sql.SQLException {
        /*
            r2.execSQL(r4, r5)     // Catch:{ SQLException -> 0x0035 }
            r5 = 0
            java.lang.String r0 = "SELECT CHANGES()"
            net.sqlcipher.database.SQLiteStatement r2 = r2.compileStatement(r0)     // Catch:{ SQLException -> 0x0022, all -> 0x001b }
            long r0 = r2.simpleQueryForLong()     // Catch:{ SQLException -> 0x0019, all -> 0x0016 }
            int r5 = (int) r0
            if (r2 == 0) goto L_0x0014
            r2.close()
        L_0x0014:
            r2 = r5
            goto L_0x0029
        L_0x0016:
            r3 = move-exception
            r5 = r2
            goto L_0x001c
        L_0x0019:
            r5 = r2
            goto L_0x0023
        L_0x001b:
            r3 = move-exception
        L_0x001c:
            if (r5 == 0) goto L_0x0021
            r5.close()
        L_0x0021:
            throw r3
        L_0x0022:
        L_0x0023:
            r2 = 1
            if (r5 == 0) goto L_0x0029
            r5.close()
        L_0x0029:
            com.j256.ormlite.logger.Logger r5 = logger
            java.lang.String r0 = "executing statement {} changed {} rows: {}"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            r5.trace(r0, r3, r1, r4)
            return r2
        L_0x0035:
            r2 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = "Problems executing "
            r5.append(r0)
            r5.append(r3)
            java.lang.String r3 = " Android statement: "
            r5.append(r3)
            r5.append(r4)
            java.lang.String r3 = r5.toString()
            java.sql.SQLException r2 = com.j256.ormlite.misc.SqlExceptionUtil.create(r3, r2)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.android.AndroidCompiledStatement.execSql(net.sqlcipher.database.SQLiteDatabase, java.lang.String, java.lang.String, java.lang.Object[]):int");
    }

    private void isInPrep() throws SQLException {
        if (this.cursor != null) {
            throw new SQLException("Query already run. Cannot add argument values.");
        }
    }

    private Object[] getArgArray() {
        if (this.args == null) {
            return NO_STRING_ARGS;
        }
        return this.args.toArray(new Object[this.args.size()]);
    }

    private String[] getStringArray() {
        if (this.args == null) {
            return NO_STRING_ARGS;
        }
        return (String[]) this.args.toArray(new String[this.args.size()]);
    }
}
