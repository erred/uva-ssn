package net.sqlcipher.database;

import android.os.SystemClock;
import android.util.Log;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import net.sqlcipher.CursorWindow;

public class SQLiteQuery extends SQLiteProgram {
    private static final String TAG = "Cursor";
    private String[] mBindArgs;
    private boolean mClosed = false;
    private int mOffsetIndex;

    private final native int native_column_count();

    private final native String native_column_name(int i);

    private final native int native_fill_window(CursorWindow cursorWindow, int i, int i2, int i3, int i4);

    SQLiteQuery(SQLiteDatabase sQLiteDatabase, String str, int i, String[] strArr) {
        super(sQLiteDatabase, str);
        this.mOffsetIndex = i;
        this.mBindArgs = strArr;
    }

    /* access modifiers changed from: 0000 */
    public int fillWindow(CursorWindow cursorWindow, int i, int i2) {
        int i3;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.mDatabase.lock();
        this.mDatabase.logTimeStat(this.mSql, uptimeMillis, "GETLOCK:");
        try {
            acquireReference();
            cursorWindow.acquireReference();
            i3 = native_fill_window(cursorWindow, cursorWindow.getStartPosition(), this.mOffsetIndex, i, i2);
            if (SQLiteDebug.DEBUG_SQL_STATEMENTS) {
                String str = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("fillWindow(): ");
                sb.append(this.mSql);
                Log.d(str, sb.toString());
            }
            this.mDatabase.logTimeStat(this.mSql, uptimeMillis);
            cursorWindow.releaseReference();
        } catch (IllegalStateException unused) {
            i3 = 0;
            cursorWindow.releaseReference();
        } catch (SQLiteDatabaseCorruptException e) {
            this.mDatabase.onCorruption();
            throw e;
        } catch (Throwable th) {
            releaseReference();
            this.mDatabase.unlock();
            throw th;
        }
        releaseReference();
        this.mDatabase.unlock();
        return i3;
    }

    /* access modifiers changed from: 0000 */
    public int columnCountLocked() {
        acquireReference();
        try {
            return native_column_count();
        } finally {
            releaseReference();
        }
    }

    /* access modifiers changed from: 0000 */
    public String columnNameLocked(int i) {
        acquireReference();
        try {
            return native_column_name(i);
        } finally {
            releaseReference();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SQLiteQuery: ");
        sb.append(this.mSql);
        return sb.toString();
    }

    public void close() {
        super.close();
        this.mClosed = true;
    }

    /* access modifiers changed from: 0000 */
    public void requery() {
        if (this.mBindArgs != null) {
            int i = 0;
            while (i < r0) {
                int i2 = i + 1;
                try {
                    super.bindString(i2, this.mBindArgs[i]);
                    i = i2;
                } catch (SQLiteMisuseException e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("mSql ");
                    sb.append(this.mSql);
                    StringBuilder sb2 = new StringBuilder(sb.toString());
                    for (String append : this.mBindArgs) {
                        sb2.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                        sb2.append(append);
                    }
                    sb2.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                    throw new IllegalStateException(sb2.toString(), e);
                }
            }
        }
    }

    public void bindNull(int i) {
        this.mBindArgs[i - 1] = null;
        if (!this.mClosed) {
            super.bindNull(i);
        }
    }

    public void bindLong(int i, long j) {
        this.mBindArgs[i - 1] = Long.toString(j);
        if (!this.mClosed) {
            super.bindLong(i, j);
        }
    }

    public void bindDouble(int i, double d) {
        this.mBindArgs[i - 1] = Double.toString(d);
        if (!this.mClosed) {
            super.bindDouble(i, d);
        }
    }

    public void bindString(int i, String str) {
        this.mBindArgs[i - 1] = str;
        if (!this.mClosed) {
            super.bindString(i, str);
        }
    }
}
