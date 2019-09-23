package net.sqlcipher.database;

import android.content.Context;
import android.util.Log;
import java.io.File;
import net.sqlcipher.DatabaseErrorHandler;
import net.sqlcipher.DefaultDatabaseErrorHandler;
import net.sqlcipher.database.SQLiteDatabase.CursorFactory;

public abstract class SQLiteOpenHelper {
    private static final String TAG = "SQLiteOpenHelper";
    private final Context mContext;
    private SQLiteDatabase mDatabase;
    private final DatabaseErrorHandler mErrorHandler;
    private final CursorFactory mFactory;
    private final SQLiteDatabaseHook mHook;
    private boolean mIsInitializing;
    private final String mName;
    private final int mNewVersion;

    public abstract void onCreate(SQLiteDatabase sQLiteDatabase);

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
    }

    public abstract void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2);

    public SQLiteOpenHelper(Context context, String str, CursorFactory cursorFactory, int i) {
        this(context, str, cursorFactory, i, null, new DefaultDatabaseErrorHandler());
    }

    public SQLiteOpenHelper(Context context, String str, CursorFactory cursorFactory, int i, SQLiteDatabaseHook sQLiteDatabaseHook) {
        this(context, str, cursorFactory, i, sQLiteDatabaseHook, new DefaultDatabaseErrorHandler());
    }

    public SQLiteOpenHelper(Context context, String str, CursorFactory cursorFactory, int i, SQLiteDatabaseHook sQLiteDatabaseHook, DatabaseErrorHandler databaseErrorHandler) {
        this.mDatabase = null;
        this.mIsInitializing = false;
        if (i < 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("Version must be >= 1, was ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        } else if (databaseErrorHandler != null) {
            this.mContext = context;
            this.mName = str;
            this.mFactory = cursorFactory;
            this.mNewVersion = i;
            this.mHook = sQLiteDatabaseHook;
            this.mErrorHandler = databaseErrorHandler;
        } else {
            throw new IllegalArgumentException("DatabaseErrorHandler param value can't be null.");
        }
    }

    public synchronized SQLiteDatabase getWritableDatabase(String str) {
        return getWritableDatabase(str == null ? null : str.toCharArray());
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x0094 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized net.sqlcipher.database.SQLiteDatabase getWritableDatabase(char[] r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            net.sqlcipher.database.SQLiteDatabase r0 = r6.mDatabase     // Catch:{ all -> 0x00b7 }
            if (r0 == 0) goto L_0x0019
            net.sqlcipher.database.SQLiteDatabase r0 = r6.mDatabase     // Catch:{ all -> 0x00b7 }
            boolean r0 = r0.isOpen()     // Catch:{ all -> 0x00b7 }
            if (r0 == 0) goto L_0x0019
            net.sqlcipher.database.SQLiteDatabase r0 = r6.mDatabase     // Catch:{ all -> 0x00b7 }
            boolean r0 = r0.isReadOnly()     // Catch:{ all -> 0x00b7 }
            if (r0 != 0) goto L_0x0019
            net.sqlcipher.database.SQLiteDatabase r7 = r6.mDatabase     // Catch:{ all -> 0x00b7 }
            monitor-exit(r6)
            return r7
        L_0x0019:
            boolean r0 = r6.mIsInitializing     // Catch:{ all -> 0x00b7 }
            if (r0 != 0) goto L_0x00af
            net.sqlcipher.database.SQLiteDatabase r0 = r6.mDatabase     // Catch:{ all -> 0x00b7 }
            if (r0 == 0) goto L_0x0026
            net.sqlcipher.database.SQLiteDatabase r0 = r6.mDatabase     // Catch:{ all -> 0x00b7 }
            r0.lock()     // Catch:{ all -> 0x00b7 }
        L_0x0026:
            r0 = 1
            r1 = 0
            r2 = 0
            r6.mIsInitializing = r0     // Catch:{ all -> 0x009d }
            java.lang.String r0 = r6.mName     // Catch:{ all -> 0x009d }
            if (r0 != 0) goto L_0x0035
            net.sqlcipher.database.SQLiteDatabase r7 = net.sqlcipher.database.SQLiteDatabase.create(r2, r7)     // Catch:{ all -> 0x009d }
        L_0x0033:
            r2 = r7
            goto L_0x005e
        L_0x0035:
            android.content.Context r0 = r6.mContext     // Catch:{ all -> 0x009d }
            java.lang.String r3 = r6.mName     // Catch:{ all -> 0x009d }
            java.io.File r0 = r0.getDatabasePath(r3)     // Catch:{ all -> 0x009d }
            java.lang.String r0 = r0.getPath()     // Catch:{ all -> 0x009d }
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x009d }
            r3.<init>(r0)     // Catch:{ all -> 0x009d }
            boolean r4 = r3.exists()     // Catch:{ all -> 0x009d }
            if (r4 != 0) goto L_0x0053
            java.io.File r3 = r3.getParentFile()     // Catch:{ all -> 0x009d }
            r3.mkdirs()     // Catch:{ all -> 0x009d }
        L_0x0053:
            net.sqlcipher.database.SQLiteDatabase$CursorFactory r3 = r6.mFactory     // Catch:{ all -> 0x009d }
            net.sqlcipher.database.SQLiteDatabaseHook r4 = r6.mHook     // Catch:{ all -> 0x009d }
            net.sqlcipher.DatabaseErrorHandler r5 = r6.mErrorHandler     // Catch:{ all -> 0x009d }
            net.sqlcipher.database.SQLiteDatabase r7 = net.sqlcipher.database.SQLiteDatabase.openOrCreateDatabase(r0, r7, r3, r4, r5)     // Catch:{ all -> 0x009d }
            goto L_0x0033
        L_0x005e:
            int r7 = r2.getVersion()     // Catch:{ all -> 0x009d }
            int r0 = r6.mNewVersion     // Catch:{ all -> 0x009d }
            if (r7 == r0) goto L_0x0086
            r2.beginTransaction()     // Catch:{ all -> 0x009d }
            if (r7 != 0) goto L_0x0071
            r6.onCreate(r2)     // Catch:{ all -> 0x006f }
            goto L_0x0076
        L_0x006f:
            r7 = move-exception
            goto L_0x0082
        L_0x0071:
            int r0 = r6.mNewVersion     // Catch:{ all -> 0x006f }
            r6.onUpgrade(r2, r7, r0)     // Catch:{ all -> 0x006f }
        L_0x0076:
            int r7 = r6.mNewVersion     // Catch:{ all -> 0x006f }
            r2.setVersion(r7)     // Catch:{ all -> 0x006f }
            r2.setTransactionSuccessful()     // Catch:{ all -> 0x006f }
            r2.endTransaction()     // Catch:{ all -> 0x009d }
            goto L_0x0086
        L_0x0082:
            r2.endTransaction()     // Catch:{ all -> 0x009d }
            throw r7     // Catch:{ all -> 0x009d }
        L_0x0086:
            r6.onOpen(r2)     // Catch:{ all -> 0x009d }
            r6.mIsInitializing = r1     // Catch:{ all -> 0x00b7 }
            net.sqlcipher.database.SQLiteDatabase r7 = r6.mDatabase     // Catch:{ all -> 0x00b7 }
            if (r7 == 0) goto L_0x0099
            net.sqlcipher.database.SQLiteDatabase r7 = r6.mDatabase     // Catch:{ Exception -> 0x0094 }
            r7.close()     // Catch:{ Exception -> 0x0094 }
        L_0x0094:
            net.sqlcipher.database.SQLiteDatabase r7 = r6.mDatabase     // Catch:{ all -> 0x00b7 }
            r7.unlock()     // Catch:{ all -> 0x00b7 }
        L_0x0099:
            r6.mDatabase = r2     // Catch:{ all -> 0x00b7 }
            monitor-exit(r6)
            return r2
        L_0x009d:
            r7 = move-exception
            r6.mIsInitializing = r1     // Catch:{ all -> 0x00b7 }
            net.sqlcipher.database.SQLiteDatabase r0 = r6.mDatabase     // Catch:{ all -> 0x00b7 }
            if (r0 == 0) goto L_0x00a9
            net.sqlcipher.database.SQLiteDatabase r0 = r6.mDatabase     // Catch:{ all -> 0x00b7 }
            r0.unlock()     // Catch:{ all -> 0x00b7 }
        L_0x00a9:
            if (r2 == 0) goto L_0x00ae
            r2.close()     // Catch:{ all -> 0x00b7 }
        L_0x00ae:
            throw r7     // Catch:{ all -> 0x00b7 }
        L_0x00af:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00b7 }
            java.lang.String r0 = "getWritableDatabase called recursively"
            r7.<init>(r0)     // Catch:{ all -> 0x00b7 }
            throw r7     // Catch:{ all -> 0x00b7 }
        L_0x00b7:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteOpenHelper.getWritableDatabase(char[]):net.sqlcipher.database.SQLiteDatabase");
    }

    public synchronized SQLiteDatabase getReadableDatabase(String str) {
        return getReadableDatabase(str == null ? null : str.toCharArray());
    }

    public synchronized SQLiteDatabase getReadableDatabase(char[] cArr) {
        SQLiteDatabase sQLiteDatabase;
        SQLiteDatabase sQLiteDatabase2;
        Throwable th;
        SQLiteDatabase writableDatabase;
        if (this.mDatabase != null && this.mDatabase.isOpen()) {
            return this.mDatabase;
        } else if (!this.mIsInitializing) {
            try {
                return getWritableDatabase(cArr);
            } catch (SQLiteException e) {
                if (this.mName != null) {
                    String str = TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Couldn't open ");
                    sb.append(this.mName);
                    sb.append(" for writing (will try read-only):");
                    Log.e(str, sb.toString(), e);
                    sQLiteDatabase = null;
                    this.mIsInitializing = true;
                    String path = this.mContext.getDatabasePath(this.mName).getPath();
                    File file = new File(path);
                    File file2 = new File(this.mContext.getDatabasePath(this.mName).getParent());
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    if (!file.exists()) {
                        this.mIsInitializing = false;
                        writableDatabase = getWritableDatabase(cArr);
                        this.mIsInitializing = true;
                        writableDatabase.close();
                        sQLiteDatabase = writableDatabase;
                    }
                    sQLiteDatabase2 = SQLiteDatabase.openDatabase(path, cArr, this.mFactory, 1);
                    if (sQLiteDatabase2.getVersion() == this.mNewVersion) {
                        onOpen(sQLiteDatabase2);
                        String str2 = TAG;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Opened ");
                        sb2.append(this.mName);
                        sb2.append(" in read-only mode");
                        Log.w(str2, sb2.toString());
                        this.mDatabase = sQLiteDatabase2;
                        SQLiteDatabase sQLiteDatabase3 = this.mDatabase;
                        this.mIsInitializing = false;
                        if (!(sQLiteDatabase2 == null || sQLiteDatabase2 == this.mDatabase)) {
                            sQLiteDatabase2.close();
                        }
                        return sQLiteDatabase3;
                    }
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Can't upgrade read-only database from version ");
                    sb3.append(sQLiteDatabase2.getVersion());
                    sb3.append(" to ");
                    sb3.append(this.mNewVersion);
                    sb3.append(": ");
                    sb3.append(path);
                    throw new SQLiteException(sb3.toString());
                }
                throw e;
            } catch (Throwable th2) {
                th = th2;
                this.mIsInitializing = false;
                sQLiteDatabase2.close();
                throw th;
            }
        } else {
            throw new IllegalStateException("getReadableDatabase called recursively");
        }
    }

    public synchronized void close() {
        if (this.mIsInitializing) {
            throw new IllegalStateException("Closed during initialization");
        } else if (this.mDatabase != null && this.mDatabase.isOpen()) {
            this.mDatabase.close();
            this.mDatabase = null;
        }
    }
}
