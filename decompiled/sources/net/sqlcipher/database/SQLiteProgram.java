package net.sqlcipher.database;

import android.util.Log;
import com.google.api.client.http.HttpMethods;

public abstract class SQLiteProgram extends SQLiteClosable {
    private static final String TAG = "SQLiteProgram";
    private SQLiteCompiledSql mCompiledSql;
    @Deprecated
    protected SQLiteDatabase mDatabase;
    final String mSql;
    @Deprecated
    protected int nHandle = 0;
    @Deprecated
    protected int nStatement = 0;

    private final native void native_clear_bindings();

    /* access modifiers changed from: protected */
    @Deprecated
    public void compile(String str, boolean z) {
    }

    /* access modifiers changed from: protected */
    public final native void native_bind_blob(int i, byte[] bArr);

    /* access modifiers changed from: protected */
    public final native void native_bind_double(int i, double d);

    /* access modifiers changed from: protected */
    public final native void native_bind_long(int i, long j);

    /* access modifiers changed from: protected */
    public final native void native_bind_null(int i);

    /* access modifiers changed from: protected */
    public final native void native_bind_string(int i, String str);

    /* access modifiers changed from: protected */
    @Deprecated
    public final native void native_compile(String str);

    /* access modifiers changed from: protected */
    @Deprecated
    public final native void native_finalize();

    SQLiteProgram(SQLiteDatabase sQLiteDatabase, String str) {
        this.mDatabase = sQLiteDatabase;
        this.mSql = str.trim();
        sQLiteDatabase.acquireReference();
        sQLiteDatabase.addSQLiteClosable(this);
        this.nHandle = sQLiteDatabase.mNativeHandle;
        String substring = this.mSql.substring(0, 6);
        if (substring.equalsIgnoreCase("INSERT") || substring.equalsIgnoreCase("UPDATE") || substring.equalsIgnoreCase("REPLAC") || substring.equalsIgnoreCase(HttpMethods.DELETE) || substring.equalsIgnoreCase("SELECT")) {
            this.mCompiledSql = sQLiteDatabase.getCompiledStatementForSql(str);
            if (this.mCompiledSql == null) {
                this.mCompiledSql = new SQLiteCompiledSql(sQLiteDatabase, str);
                this.mCompiledSql.acquire();
                sQLiteDatabase.addToCompiledQueries(str, this.mCompiledSql);
                if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION) {
                    String str2 = TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Created DbObj (id#");
                    sb.append(this.mCompiledSql.nStatement);
                    sb.append(") for sql: ");
                    sb.append(str);
                    Log.v(str2, sb.toString());
                }
            } else if (!this.mCompiledSql.acquire()) {
                int i = this.mCompiledSql.nStatement;
                this.mCompiledSql = new SQLiteCompiledSql(sQLiteDatabase, str);
                if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION) {
                    String str3 = TAG;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("** possible bug ** Created NEW DbObj (id#");
                    sb2.append(this.mCompiledSql.nStatement);
                    sb2.append(") because the previously created DbObj (id#");
                    sb2.append(i);
                    sb2.append(") was not released for sql:");
                    sb2.append(str);
                    Log.v(str3, sb2.toString());
                }
            }
            this.nStatement = this.mCompiledSql.nStatement;
            return;
        }
        this.mCompiledSql = new SQLiteCompiledSql(sQLiteDatabase, str);
        this.nStatement = this.mCompiledSql.nStatement;
    }

    /* access modifiers changed from: protected */
    public void onAllReferencesReleased() {
        releaseCompiledSqlIfNotInCache();
        this.mDatabase.releaseReference();
        this.mDatabase.removeSQLiteClosable(this);
    }

    /* access modifiers changed from: protected */
    public void onAllReferencesReleasedFromContainer() {
        releaseCompiledSqlIfNotInCache();
        this.mDatabase.releaseReference();
    }

    private void releaseCompiledSqlIfNotInCache() {
        if (this.mCompiledSql != null) {
            synchronized (this.mDatabase.mCompiledQueries) {
                if (!this.mDatabase.mCompiledQueries.containsValue(this.mCompiledSql)) {
                    this.mCompiledSql.releaseSqlStatement();
                    this.mCompiledSql = null;
                    this.nStatement = 0;
                } else {
                    this.mCompiledSql.release();
                }
            }
        }
    }

    public final int getUniqueId() {
        return this.nStatement;
    }

    /* access modifiers changed from: 0000 */
    public String getSqlString() {
        return this.mSql;
    }

    public void bindNull(int i) {
        if (this.mDatabase.isOpen()) {
            acquireReference();
            try {
                native_bind_null(i);
            } finally {
                releaseReference();
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("database ");
            sb.append(this.mDatabase.getPath());
            sb.append(" already closed");
            throw new IllegalStateException(sb.toString());
        }
    }

    public void bindLong(int i, long j) {
        if (this.mDatabase.isOpen()) {
            acquireReference();
            try {
                native_bind_long(i, j);
            } finally {
                releaseReference();
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("database ");
            sb.append(this.mDatabase.getPath());
            sb.append(" already closed");
            throw new IllegalStateException(sb.toString());
        }
    }

    public void bindDouble(int i, double d) {
        if (this.mDatabase.isOpen()) {
            acquireReference();
            try {
                native_bind_double(i, d);
            } finally {
                releaseReference();
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("database ");
            sb.append(this.mDatabase.getPath());
            sb.append(" already closed");
            throw new IllegalStateException(sb.toString());
        }
    }

    public void bindString(int i, String str) {
        if (str == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("the bind value at index ");
            sb.append(i);
            sb.append(" is null");
            throw new IllegalArgumentException(sb.toString());
        } else if (this.mDatabase.isOpen()) {
            acquireReference();
            try {
                native_bind_string(i, str);
            } finally {
                releaseReference();
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("database ");
            sb2.append(this.mDatabase.getPath());
            sb2.append(" already closed");
            throw new IllegalStateException(sb2.toString());
        }
    }

    public void bindBlob(int i, byte[] bArr) {
        if (bArr == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("the bind value at index ");
            sb.append(i);
            sb.append(" is null");
            throw new IllegalArgumentException(sb.toString());
        } else if (this.mDatabase.isOpen()) {
            acquireReference();
            try {
                native_bind_blob(i, bArr);
            } finally {
                releaseReference();
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("database ");
            sb2.append(this.mDatabase.getPath());
            sb2.append(" already closed");
            throw new IllegalStateException(sb2.toString());
        }
    }

    public void clearBindings() {
        if (this.mDatabase.isOpen()) {
            acquireReference();
            try {
                native_clear_bindings();
            } finally {
                releaseReference();
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("database ");
            sb.append(this.mDatabase.getPath());
            sb.append(" already closed");
            throw new IllegalStateException(sb.toString());
        }
    }

    public void close() {
        if (this.mDatabase.isOpen()) {
            this.mDatabase.lock();
            try {
                releaseReference();
            } finally {
                this.mDatabase.unlock();
            }
        }
    }
}
