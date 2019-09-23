package net.sqlcipher.database;

import android.content.ContentValues;
import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.bridgefy.sdk.framework.controller.Constants;
import com.j256.ormlite.field.FieldType;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;
import net.sqlcipher.CrossProcessCursorWrapper;
import net.sqlcipher.Cursor;
import net.sqlcipher.CursorWrapper;
import net.sqlcipher.DatabaseErrorHandler;
import net.sqlcipher.SQLException;
import net.sqlcipher.database.SQLiteDebug.DbStats;

public class SQLiteDatabase extends SQLiteClosable {
    private static final String COMMIT_SQL = "COMMIT;";
    public static final int CONFLICT_ABORT = 2;
    public static final int CONFLICT_FAIL = 3;
    public static final int CONFLICT_IGNORE = 4;
    public static final int CONFLICT_NONE = 0;
    public static final int CONFLICT_REPLACE = 5;
    public static final int CONFLICT_ROLLBACK = 1;
    private static final String[] CONFLICT_VALUES = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
    public static final int CREATE_IF_NECESSARY = 268435456;
    private static final Pattern EMAIL_IN_DB_PATTERN = Pattern.compile("[\\w\\.\\-]+@[\\w\\.\\-]+");
    private static final int EVENT_DB_CORRUPT = 75004;
    private static final int EVENT_DB_OPERATION = 52000;
    static final String GET_LOCK_LOG_PREFIX = "GETLOCK:";
    private static final int LOCK_ACQUIRED_WARNING_THREAD_TIME_IN_MS = 100;
    private static final int LOCK_ACQUIRED_WARNING_TIME_IN_MS = 300;
    private static final int LOCK_ACQUIRED_WARNING_TIME_IN_MS_ALWAYS_PRINT = 2000;
    private static final int LOCK_WARNING_WINDOW_IN_MS = 20000;
    private static final String LOG_SLOW_QUERIES_PROPERTY = "db.log.slow_query_threshold";
    public static final int MAX_SQL_CACHE_SIZE = 250;
    private static final int MAX_WARNINGS_ON_CACHESIZE_CONDITION = 1;
    public static final String MEMORY = ":memory:";
    public static final int NO_LOCALIZED_COLLATORS = 16;
    public static final int OPEN_READONLY = 1;
    public static final int OPEN_READWRITE = 0;
    private static final int OPEN_READ_MASK = 1;
    private static final int QUERY_LOG_SQL_LENGTH = 64;
    private static final int SLEEP_AFTER_YIELD_QUANTUM = 1000;
    public static final String SQLCIPHER_ANDROID_VERSION = "3.5.3";
    public static final int SQLITE_MAX_LIKE_PATTERN_LENGTH = 50000;
    private static final String TAG = "Database";
    private static WeakHashMap<SQLiteDatabase, Object> sActiveDatabases = new WeakHashMap<>();
    private static int sQueryLogTimeInMillis = 0;
    private int mCacheFullWarnings;
    Map<String, SQLiteCompiledSql> mCompiledQueries;
    private final DatabaseErrorHandler mErrorHandler;
    private CursorFactory mFactory;
    private int mFlags;
    private boolean mInnerTransactionIsSuccessful;
    private long mLastLockMessageTime;
    private String mLastSqlStatement;
    private final ReentrantLock mLock;
    private long mLockAcquiredThreadTime;
    private long mLockAcquiredWallTime;
    private boolean mLockingEnabled;
    private int mMaxSqlCacheSize;
    int mNativeHandle;
    private int mNumCacheHits;
    private int mNumCacheMisses;
    private String mPath;
    private String mPathForLogs;
    private WeakHashMap<SQLiteClosable, Object> mPrograms;
    private final Random mRandom;
    private final int mSlowQueryThreshold;
    private Throwable mStackTrace;
    private final Map<String, SyncUpdateInfo> mSyncUpdateInfo;
    int mTempTableSequence;
    private String mTimeClosed;
    private String mTimeOpened;
    private boolean mTransactionIsSuccessful;
    private SQLiteTransactionListener mTransactionListener;

    public interface CursorFactory {
        Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery);
    }

    private static class SyncUpdateInfo {
        String deletedTable;
        String foreignKey;
        String masterTable;

        SyncUpdateInfo(String str, String str2, String str3) {
            this.masterTable = str;
            this.deletedTable = str2;
            this.foreignKey = str3;
        }
    }

    private native void dbclose();

    private native void dbopen(String str, int i);

    private native void enableSqlProfiling(String str);

    private native void enableSqlTracing(String str);

    private native int native_getDbLookaside();

    private native void native_key(char[] cArr) throws SQLException;

    private native void native_rawExecSQL(String str);

    private native void native_rekey(String str) throws SQLException;

    private native int native_status(int i, boolean z);

    public static native int releaseMemory();

    public static native void setICURoot(String str);

    /* access modifiers changed from: 0000 */
    public native int lastChangeCount();

    /* access modifiers changed from: 0000 */
    public native long lastInsertRow();

    /* access modifiers changed from: 0000 */
    public native void native_execSQL(String str) throws SQLException;

    /* access modifiers changed from: 0000 */
    public native void native_setLocale(String str, int i);

    public int status(int i, boolean z) {
        return native_status(i, z);
    }

    public void changePassword(String str) throws SQLiteException {
        if (!isOpen()) {
            throw new SQLiteException("database not open");
        } else if (str != null) {
            native_rekey(str);
        }
    }

    public void changePassword(char[] cArr) throws SQLiteException {
        if (!isOpen()) {
            throw new SQLiteException("database not open");
        } else if (cArr != null) {
            native_rekey(String.valueOf(cArr));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0082 A[Catch:{ all -> 0x008b }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x008e A[SYNTHETIC, Splitter:B:44:0x008e] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0096 A[Catch:{ IOException -> 0x0092 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void loadICUData(android.content.Context r5, java.io.File r6) {
        /*
            java.io.File r0 = new java.io.File
            java.lang.String r1 = "icu"
            r0.<init>(r6, r1)
            java.io.File r6 = new java.io.File
            java.lang.String r1 = "icudt46l.dat"
            r6.<init>(r0, r1)
            r1 = 0
            boolean r2 = r0.exists()     // Catch:{ Exception -> 0x0073, all -> 0x0070 }
            if (r2 != 0) goto L_0x0018
            r0.mkdirs()     // Catch:{ Exception -> 0x0073, all -> 0x0070 }
        L_0x0018:
            boolean r0 = r6.exists()     // Catch:{ Exception -> 0x0073, all -> 0x0070 }
            if (r0 != 0) goto L_0x004f
            java.util.zip.ZipInputStream r0 = new java.util.zip.ZipInputStream     // Catch:{ Exception -> 0x0073, all -> 0x0070 }
            android.content.res.AssetManager r5 = r5.getAssets()     // Catch:{ Exception -> 0x0073, all -> 0x0070 }
            java.lang.String r2 = "icudt46l.zip"
            java.io.InputStream r5 = r5.open(r2)     // Catch:{ Exception -> 0x0073, all -> 0x0070 }
            r0.<init>(r5)     // Catch:{ Exception -> 0x0073, all -> 0x0070 }
            r0.getNextEntry()     // Catch:{ Exception -> 0x004d }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x004d }
            r5.<init>(r6)     // Catch:{ Exception -> 0x004d }
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r1]     // Catch:{ Exception -> 0x0048, all -> 0x0044 }
        L_0x0039:
            int r2 = r0.read(r1)     // Catch:{ Exception -> 0x0048, all -> 0x0044 }
            if (r2 <= 0) goto L_0x0051
            r3 = 0
            r5.write(r1, r3, r2)     // Catch:{ Exception -> 0x0048, all -> 0x0044 }
            goto L_0x0039
        L_0x0044:
            r6 = move-exception
            r1 = r5
            r5 = r6
            goto L_0x008c
        L_0x0048:
            r1 = move-exception
            r4 = r1
            r1 = r5
            r5 = r4
            goto L_0x0075
        L_0x004d:
            r5 = move-exception
            goto L_0x0075
        L_0x004f:
            r5 = r1
            r0 = r5
        L_0x0051:
            if (r0 == 0) goto L_0x0059
            r0.close()     // Catch:{ IOException -> 0x0057 }
            goto L_0x0059
        L_0x0057:
            r5 = move-exception
            goto L_0x0062
        L_0x0059:
            if (r5 == 0) goto L_0x006f
            r5.flush()     // Catch:{ IOException -> 0x0057 }
            r5.close()     // Catch:{ IOException -> 0x0057 }
            goto L_0x006f
        L_0x0062:
            java.lang.String r6 = "Database"
            java.lang.String r0 = "Error in closing streams IO streams after expanding ICU dat file"
            android.util.Log.e(r6, r0, r5)
            java.lang.RuntimeException r6 = new java.lang.RuntimeException
            r6.<init>(r5)
            throw r6
        L_0x006f:
            return
        L_0x0070:
            r5 = move-exception
            r0 = r1
            goto L_0x008c
        L_0x0073:
            r5 = move-exception
            r0 = r1
        L_0x0075:
            java.lang.String r2 = "Database"
            java.lang.String r3 = "Error copying icu dat file"
            android.util.Log.e(r2, r3, r5)     // Catch:{ all -> 0x008b }
            boolean r2 = r6.exists()     // Catch:{ all -> 0x008b }
            if (r2 == 0) goto L_0x0085
            r6.delete()     // Catch:{ all -> 0x008b }
        L_0x0085:
            java.lang.RuntimeException r6 = new java.lang.RuntimeException     // Catch:{ all -> 0x008b }
            r6.<init>(r5)     // Catch:{ all -> 0x008b }
            throw r6     // Catch:{ all -> 0x008b }
        L_0x008b:
            r5 = move-exception
        L_0x008c:
            if (r0 == 0) goto L_0x0094
            r0.close()     // Catch:{ IOException -> 0x0092 }
            goto L_0x0094
        L_0x0092:
            r5 = move-exception
            goto L_0x009d
        L_0x0094:
            if (r1 == 0) goto L_0x00aa
            r1.flush()     // Catch:{ IOException -> 0x0092 }
            r1.close()     // Catch:{ IOException -> 0x0092 }
            goto L_0x00aa
        L_0x009d:
            java.lang.String r6 = "Database"
            java.lang.String r0 = "Error in closing streams IO streams after expanding ICU dat file"
            android.util.Log.e(r6, r0, r5)
            java.lang.RuntimeException r6 = new java.lang.RuntimeException
            r6.<init>(r5)
            throw r6
        L_0x00aa:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.loadICUData(android.content.Context, java.io.File):void");
    }

    public static synchronized void loadLibs(Context context) {
        synchronized (SQLiteDatabase.class) {
            loadLibs(context, context.getFilesDir());
        }
    }

    public static synchronized void loadLibs(Context context, File file) {
        synchronized (SQLiteDatabase.class) {
            System.loadLibrary("sqlcipher");
        }
    }

    /* access modifiers changed from: 0000 */
    public void addSQLiteClosable(SQLiteClosable sQLiteClosable) {
        lock();
        try {
            this.mPrograms.put(sQLiteClosable, null);
        } finally {
            unlock();
        }
    }

    /* access modifiers changed from: 0000 */
    public void removeSQLiteClosable(SQLiteClosable sQLiteClosable) {
        lock();
        try {
            this.mPrograms.remove(sQLiteClosable);
        } finally {
            unlock();
        }
    }

    /* access modifiers changed from: protected */
    public void onAllReferencesReleased() {
        if (isOpen()) {
            if (SQLiteDebug.DEBUG_SQL_CACHE) {
                this.mTimeClosed = getTime();
            }
            dbclose();
            synchronized (sActiveDatabases) {
                sActiveDatabases.remove(this);
            }
        }
    }

    public void setLockingEnabled(boolean z) {
        this.mLockingEnabled = z;
    }

    /* access modifiers changed from: 0000 */
    public void onCorruption() {
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("Calling error handler for corrupt database (detected) ");
        sb.append(this.mPath);
        Log.e(str, sb.toString());
        this.mErrorHandler.onCorruption(this);
    }

    /* access modifiers changed from: 0000 */
    public void lock() {
        if (this.mLockingEnabled) {
            this.mLock.lock();
            if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING && this.mLock.getHoldCount() == 1) {
                this.mLockAcquiredWallTime = SystemClock.elapsedRealtime();
                this.mLockAcquiredThreadTime = Debug.threadCpuTimeNanos();
            }
        }
    }

    private void lockForced() {
        this.mLock.lock();
        if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING && this.mLock.getHoldCount() == 1) {
            this.mLockAcquiredWallTime = SystemClock.elapsedRealtime();
            this.mLockAcquiredThreadTime = Debug.threadCpuTimeNanos();
        }
    }

    /* access modifiers changed from: 0000 */
    public void unlock() {
        if (this.mLockingEnabled) {
            if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING && this.mLock.getHoldCount() == 1) {
                checkLockHoldTime();
            }
            this.mLock.unlock();
        }
    }

    private void unlockForced() {
        if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING && this.mLock.getHoldCount() == 1) {
            checkLockHoldTime();
        }
        this.mLock.unlock();
    }

    private void checkLockHoldTime() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = elapsedRealtime - this.mLockAcquiredWallTime;
        int i = (j > 2000 ? 1 : (j == 2000 ? 0 : -1));
        if ((i >= 0 || Log.isLoggable(TAG, 2) || elapsedRealtime - this.mLastLockMessageTime >= Constants.KEEP_ALIVE_INTERVAL) && j > 300) {
            int threadCpuTimeNanos = (int) ((Debug.threadCpuTimeNanos() - this.mLockAcquiredThreadTime) / 1000000);
            if (threadCpuTimeNanos > 100 || i > 0) {
                this.mLastLockMessageTime = elapsedRealtime;
                StringBuilder sb = new StringBuilder();
                sb.append("lock held on ");
                sb.append(this.mPath);
                sb.append(" for ");
                sb.append(j);
                sb.append("ms. Thread time was ");
                sb.append(threadCpuTimeNanos);
                sb.append("ms");
                String sb2 = sb.toString();
                if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING_STACK_TRACE) {
                    Log.d(TAG, sb2, new Exception());
                } else {
                    Log.d(TAG, sb2);
                }
            }
        }
    }

    public void beginTransaction() {
        beginTransactionWithListener(null);
    }

    public void beginTransactionWithListener(SQLiteTransactionListener sQLiteTransactionListener) {
        lockForced();
        if (isOpen()) {
            try {
                if (this.mLock.getHoldCount() <= 1) {
                    execSQL("BEGIN EXCLUSIVE;");
                    this.mTransactionListener = sQLiteTransactionListener;
                    this.mTransactionIsSuccessful = true;
                    this.mInnerTransactionIsSuccessful = false;
                    if (sQLiteTransactionListener != null) {
                        sQLiteTransactionListener.onBegin();
                    }
                } else if (this.mInnerTransactionIsSuccessful) {
                    IllegalStateException illegalStateException = new IllegalStateException("Cannot call beginTransaction between calling setTransactionSuccessful and endTransaction");
                    Log.e(TAG, "beginTransaction() failed", illegalStateException);
                    throw illegalStateException;
                }
            } catch (RuntimeException e) {
                execSQL("ROLLBACK;");
                throw e;
            } catch (Throwable th) {
                unlockForced();
                throw th;
            }
        } else {
            throw new IllegalStateException("database not open");
        }
    }

    public void endTransaction() {
        Throwable e;
        if (!isOpen()) {
            throw new IllegalStateException("database not open");
        } else if (this.mLock.isHeldByCurrentThread()) {
            try {
                if (this.mInnerTransactionIsSuccessful) {
                    this.mInnerTransactionIsSuccessful = false;
                } else {
                    this.mTransactionIsSuccessful = false;
                }
                if (this.mLock.getHoldCount() != 1) {
                    this.mTransactionListener = null;
                    unlockForced();
                    return;
                }
                if (this.mTransactionListener != null) {
                    if (this.mTransactionIsSuccessful) {
                        this.mTransactionListener.onCommit();
                    } else {
                        this.mTransactionListener.onRollback();
                    }
                }
                e = null;
                if (this.mTransactionIsSuccessful) {
                    execSQL(COMMIT_SQL);
                } else {
                    try {
                        execSQL("ROLLBACK;");
                        if (e != null) {
                            throw e;
                        }
                    } catch (SQLException unused) {
                        Log.d(TAG, "exception during rollback, maybe the DB previously performed an auto-rollback");
                    }
                }
                this.mTransactionListener = null;
                unlockForced();
            } catch (RuntimeException e2) {
                e = e2;
                this.mTransactionIsSuccessful = false;
            } catch (Throwable th) {
                this.mTransactionListener = null;
                unlockForced();
                throw th;
            }
        } else {
            throw new IllegalStateException("no transaction pending");
        }
    }

    public void setTransactionSuccessful() {
        if (!isOpen()) {
            throw new IllegalStateException("database not open");
        } else if (!this.mLock.isHeldByCurrentThread()) {
            throw new IllegalStateException("no transaction pending");
        } else if (!this.mInnerTransactionIsSuccessful) {
            this.mInnerTransactionIsSuccessful = true;
        } else {
            throw new IllegalStateException("setTransactionSuccessful may only be called once per call to beginTransaction");
        }
    }

    public boolean inTransaction() {
        return this.mLock.getHoldCount() > 0;
    }

    public boolean isDbLockedByCurrentThread() {
        return this.mLock.isHeldByCurrentThread();
    }

    public boolean isDbLockedByOtherThreads() {
        return !this.mLock.isHeldByCurrentThread() && this.mLock.isLocked();
    }

    @Deprecated
    public boolean yieldIfContended() {
        if (!isOpen()) {
            return false;
        }
        return yieldIfContendedHelper(false, -1);
    }

    public boolean yieldIfContendedSafely() {
        if (!isOpen()) {
            return false;
        }
        return yieldIfContendedHelper(true, -1);
    }

    public boolean yieldIfContendedSafely(long j) {
        if (!isOpen()) {
            return false;
        }
        return yieldIfContendedHelper(true, j);
    }

    private boolean yieldIfContendedHelper(boolean z, long j) {
        if (this.mLock.getQueueLength() == 0) {
            this.mLockAcquiredWallTime = SystemClock.elapsedRealtime();
            this.mLockAcquiredThreadTime = Debug.threadCpuTimeNanos();
            return false;
        }
        setTransactionSuccessful();
        SQLiteTransactionListener sQLiteTransactionListener = this.mTransactionListener;
        endTransaction();
        if (!z || !isDbLockedByCurrentThread()) {
            if (j > 0) {
                while (j > 0) {
                    try {
                        Thread.sleep(j < 1000 ? j : 1000);
                    } catch (InterruptedException unused) {
                        Thread.interrupted();
                    }
                    j -= 1000;
                    if (this.mLock.getQueueLength() == 0) {
                        break;
                    }
                }
            }
            beginTransactionWithListener(sQLiteTransactionListener);
            return true;
        }
        throw new IllegalStateException("Db locked more than once. yielfIfContended cannot yield");
    }

    public Map<String, String> getSyncedTables() {
        HashMap hashMap;
        synchronized (this.mSyncUpdateInfo) {
            hashMap = new HashMap();
            for (String str : this.mSyncUpdateInfo.keySet()) {
                SyncUpdateInfo syncUpdateInfo = (SyncUpdateInfo) this.mSyncUpdateInfo.get(str);
                if (syncUpdateInfo.deletedTable != null) {
                    hashMap.put(str, syncUpdateInfo.deletedTable);
                }
            }
        }
        return hashMap;
    }

    public static SQLiteDatabase openDatabase(String str, String str2, CursorFactory cursorFactory, int i) {
        return openDatabase(str, str2, cursorFactory, i, (SQLiteDatabaseHook) null);
    }

    public static SQLiteDatabase openDatabase(String str, char[] cArr, CursorFactory cursorFactory, int i) {
        return openDatabase(str, cArr, cursorFactory, i, (SQLiteDatabaseHook) null, (DatabaseErrorHandler) null);
    }

    public static SQLiteDatabase openDatabase(String str, String str2, CursorFactory cursorFactory, int i, SQLiteDatabaseHook sQLiteDatabaseHook) {
        return openDatabase(str, str2, cursorFactory, i, sQLiteDatabaseHook, (DatabaseErrorHandler) null);
    }

    public static SQLiteDatabase openDatabase(String str, char[] cArr, CursorFactory cursorFactory, int i, SQLiteDatabaseHook sQLiteDatabaseHook) {
        return openDatabase(str, cArr, cursorFactory, i, sQLiteDatabaseHook, (DatabaseErrorHandler) null);
    }

    public static SQLiteDatabase openDatabase(String str, String str2, CursorFactory cursorFactory, int i, SQLiteDatabaseHook sQLiteDatabaseHook, DatabaseErrorHandler databaseErrorHandler) {
        return openDatabase(str, str2 == null ? null : str2.toCharArray(), cursorFactory, i, sQLiteDatabaseHook, databaseErrorHandler);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0048 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static net.sqlcipher.database.SQLiteDatabase openDatabase(java.lang.String r6, char[] r7, net.sqlcipher.database.SQLiteDatabase.CursorFactory r8, int r9, net.sqlcipher.database.SQLiteDatabaseHook r10, net.sqlcipher.DatabaseErrorHandler r11) {
        /*
            if (r11 == 0) goto L_0x0003
            goto L_0x0008
        L_0x0003:
            net.sqlcipher.DefaultDatabaseErrorHandler r11 = new net.sqlcipher.DefaultDatabaseErrorHandler
            r11.<init>()
        L_0x0008:
            r0 = 0
            net.sqlcipher.database.SQLiteDatabase r1 = new net.sqlcipher.database.SQLiteDatabase     // Catch:{ SQLiteDatabaseCorruptException -> 0x0014 }
            r1.<init>(r6, r8, r9, r11)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0014 }
            r1.openDatabaseInternal(r7, r10)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0012 }
            goto L_0x0037
        L_0x0012:
            r2 = move-exception
            goto L_0x0016
        L_0x0014:
            r2 = move-exception
            r1 = r0
        L_0x0016:
            java.lang.String r3 = "Database"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Calling error handler for corrupt database "
            r4.append(r5)
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            android.util.Log.e(r3, r4, r2)
            r11.onCorruption(r1)
            net.sqlcipher.database.SQLiteDatabase r1 = new net.sqlcipher.database.SQLiteDatabase
            r1.<init>(r6, r8, r9, r11)
            r1.openDatabaseInternal(r7, r10)
        L_0x0037:
            boolean r7 = net.sqlcipher.database.SQLiteDebug.DEBUG_SQL_STATEMENTS
            if (r7 == 0) goto L_0x003e
            r1.enableSqlTracing(r6)
        L_0x003e:
            boolean r7 = net.sqlcipher.database.SQLiteDebug.DEBUG_SQL_TIME
            if (r7 == 0) goto L_0x0045
            r1.enableSqlProfiling(r6)
        L_0x0045:
            java.util.WeakHashMap<net.sqlcipher.database.SQLiteDatabase, java.lang.Object> r6 = sActiveDatabases
            monitor-enter(r6)
            java.util.WeakHashMap<net.sqlcipher.database.SQLiteDatabase, java.lang.Object> r7 = sActiveDatabases     // Catch:{ all -> 0x004f }
            r7.put(r1, r0)     // Catch:{ all -> 0x004f }
            monitor-exit(r6)     // Catch:{ all -> 0x004f }
            return r1
        L_0x004f:
            r7 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x004f }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.openDatabase(java.lang.String, char[], net.sqlcipher.database.SQLiteDatabase$CursorFactory, int, net.sqlcipher.database.SQLiteDatabaseHook, net.sqlcipher.DatabaseErrorHandler):net.sqlcipher.database.SQLiteDatabase");
    }

    public static SQLiteDatabase openOrCreateDatabase(File file, String str, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook) {
        return openOrCreateDatabase(file, str, cursorFactory, sQLiteDatabaseHook, (DatabaseErrorHandler) null);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, String str2, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook) {
        return openDatabase(str, str2, cursorFactory, (int) CREATE_IF_NECESSARY, sQLiteDatabaseHook);
    }

    public static SQLiteDatabase openOrCreateDatabase(File file, String str, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook, DatabaseErrorHandler databaseErrorHandler) {
        return openOrCreateDatabase(file == null ? null : file.getPath(), str, cursorFactory, sQLiteDatabaseHook, databaseErrorHandler);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, String str2, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook, DatabaseErrorHandler databaseErrorHandler) {
        return openDatabase(str, str2 == null ? null : str2.toCharArray(), cursorFactory, (int) CREATE_IF_NECESSARY, sQLiteDatabaseHook, databaseErrorHandler);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, char[] cArr, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook) {
        return openDatabase(str, cArr, cursorFactory, (int) CREATE_IF_NECESSARY, sQLiteDatabaseHook);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, char[] cArr, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook, DatabaseErrorHandler databaseErrorHandler) {
        return openDatabase(str, cArr, cursorFactory, (int) CREATE_IF_NECESSARY, sQLiteDatabaseHook, databaseErrorHandler);
    }

    public static SQLiteDatabase openOrCreateDatabase(File file, String str, CursorFactory cursorFactory) {
        return openOrCreateDatabase(file, str, cursorFactory, (SQLiteDatabaseHook) null);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, String str2, CursorFactory cursorFactory) {
        return openDatabase(str, str2, cursorFactory, (int) CREATE_IF_NECESSARY, (SQLiteDatabaseHook) null);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, char[] cArr, CursorFactory cursorFactory) {
        return openDatabase(str, cArr, cursorFactory, (int) CREATE_IF_NECESSARY, (SQLiteDatabaseHook) null);
    }

    public static SQLiteDatabase create(CursorFactory cursorFactory, String str) {
        return openDatabase(MEMORY, str == null ? null : str.toCharArray(), cursorFactory, (int) CREATE_IF_NECESSARY);
    }

    public static SQLiteDatabase create(CursorFactory cursorFactory, char[] cArr) {
        return openDatabase(MEMORY, cArr, cursorFactory, (int) CREATE_IF_NECESSARY);
    }

    public void close() {
        if (isOpen()) {
            lock();
            try {
                closeClosable();
                onAllReferencesReleased();
            } finally {
                unlock();
            }
        }
    }

    private void closeClosable() {
        deallocCachedSqlStatements();
        for (Entry key : this.mPrograms.entrySet()) {
            SQLiteClosable sQLiteClosable = (SQLiteClosable) key.getKey();
            if (sQLiteClosable != null) {
                sQLiteClosable.onAllReferencesReleasedFromContainer();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getVersion() {
        /*
            r5 = this;
            r5.lock()
            boolean r0 = r5.isOpen()
            if (r0 == 0) goto L_0x002c
            r0 = 0
            net.sqlcipher.database.SQLiteStatement r1 = new net.sqlcipher.database.SQLiteStatement     // Catch:{ all -> 0x0022 }
            java.lang.String r2 = "PRAGMA user_version;"
            r1.<init>(r5, r2)     // Catch:{ all -> 0x0022 }
            long r2 = r1.simpleQueryForLong()     // Catch:{ all -> 0x001d }
            int r0 = (int) r2
            r1.close()
            r5.unlock()
            return r0
        L_0x001d:
            r0 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L_0x0023
        L_0x0022:
            r1 = move-exception
        L_0x0023:
            if (r0 == 0) goto L_0x0028
            r0.close()
        L_0x0028:
            r5.unlock()
            throw r1
        L_0x002c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "database not open"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.getVersion():int");
    }

    public void setVersion(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("PRAGMA user_version = ");
        sb.append(i);
        execSQL(sb.toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long getMaximumSize() {
        /*
            r7 = this;
            r7.lock()
            boolean r0 = r7.isOpen()
            if (r0 == 0) goto L_0x0031
            r0 = 0
            net.sqlcipher.database.SQLiteStatement r1 = new net.sqlcipher.database.SQLiteStatement     // Catch:{ all -> 0x0027 }
            java.lang.String r2 = "PRAGMA max_page_count;"
            r1.<init>(r7, r2)     // Catch:{ all -> 0x0027 }
            long r2 = r1.simpleQueryForLong()     // Catch:{ all -> 0x0022 }
            long r4 = r7.getPageSize()     // Catch:{ all -> 0x0022 }
            long r2 = r2 * r4
            r1.close()
            r7.unlock()
            return r2
        L_0x0022:
            r0 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
            goto L_0x0028
        L_0x0027:
            r1 = move-exception
        L_0x0028:
            if (r0 == 0) goto L_0x002d
            r0.close()
        L_0x002d:
            r7.unlock()
            throw r1
        L_0x0031:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "database not open"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.getMaximumSize():long");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0043  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long setMaximumSize(long r8) {
        /*
            r7 = this;
            r7.lock()
            boolean r0 = r7.isOpen()
            if (r0 == 0) goto L_0x004a
            r0 = 0
            long r1 = r7.getPageSize()     // Catch:{ all -> 0x0040 }
            long r3 = r8 / r1
            long r8 = r8 % r1
            r5 = 0
            int r8 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r8 == 0) goto L_0x001a
            r8 = 1
            long r3 = r3 + r8
        L_0x001a:
            net.sqlcipher.database.SQLiteStatement r8 = new net.sqlcipher.database.SQLiteStatement     // Catch:{ all -> 0x0040 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0040 }
            r9.<init>()     // Catch:{ all -> 0x0040 }
            java.lang.String r5 = "PRAGMA max_page_count = "
            r9.append(r5)     // Catch:{ all -> 0x0040 }
            r9.append(r3)     // Catch:{ all -> 0x0040 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0040 }
            r8.<init>(r7, r9)     // Catch:{ all -> 0x0040 }
            long r3 = r8.simpleQueryForLong()     // Catch:{ all -> 0x003d }
            long r3 = r3 * r1
            r8.close()
            r7.unlock()
            return r3
        L_0x003d:
            r9 = move-exception
            r0 = r8
            goto L_0x0041
        L_0x0040:
            r9 = move-exception
        L_0x0041:
            if (r0 == 0) goto L_0x0046
            r0.close()
        L_0x0046:
            r7.unlock()
            throw r9
        L_0x004a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "database not open"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.setMaximumSize(long):long");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long getPageSize() {
        /*
            r5 = this;
            r5.lock()
            boolean r0 = r5.isOpen()
            if (r0 == 0) goto L_0x002b
            r0 = 0
            net.sqlcipher.database.SQLiteStatement r1 = new net.sqlcipher.database.SQLiteStatement     // Catch:{ all -> 0x0021 }
            java.lang.String r2 = "PRAGMA page_size;"
            r1.<init>(r5, r2)     // Catch:{ all -> 0x0021 }
            long r2 = r1.simpleQueryForLong()     // Catch:{ all -> 0x001c }
            r1.close()
            r5.unlock()
            return r2
        L_0x001c:
            r0 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L_0x0022
        L_0x0021:
            r1 = move-exception
        L_0x0022:
            if (r0 == 0) goto L_0x0027
            r0.close()
        L_0x0027:
            r5.unlock()
            throw r1
        L_0x002b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "database not open"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.getPageSize():long");
    }

    public void setPageSize(long j) {
        StringBuilder sb = new StringBuilder();
        sb.append("PRAGMA page_size = ");
        sb.append(j);
        execSQL(sb.toString());
    }

    public void markTableSyncable(String str, String str2) {
        if (isOpen()) {
            markTableSyncable(str, FieldType.FOREIGN_ID_FIELD_SUFFIX, str, str2);
            return;
        }
        throw new SQLiteException("database not open");
    }

    public void markTableSyncable(String str, String str2, String str3) {
        if (isOpen()) {
            markTableSyncable(str, str2, str3, null);
            return;
        }
        throw new SQLiteException("database not open");
    }

    /* JADX INFO: finally extract failed */
    private void markTableSyncable(String str, String str2, String str3, String str4) {
        lock();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT _sync_dirty FROM ");
            sb.append(str3);
            sb.append(" LIMIT 0");
            native_execSQL(sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("SELECT ");
            sb2.append(str2);
            sb2.append(" FROM ");
            sb2.append(str);
            sb2.append(" LIMIT 0");
            native_execSQL(sb2.toString());
            unlock();
            SyncUpdateInfo syncUpdateInfo = new SyncUpdateInfo(str3, str4, str2);
            synchronized (this.mSyncUpdateInfo) {
                this.mSyncUpdateInfo.put(str, syncUpdateInfo);
            }
        } catch (Throwable th) {
            unlock();
            throw th;
        }
    }

    /* access modifiers changed from: 0000 */
    public void rowUpdated(String str, long j) {
        SyncUpdateInfo syncUpdateInfo;
        synchronized (this.mSyncUpdateInfo) {
            syncUpdateInfo = (SyncUpdateInfo) this.mSyncUpdateInfo.get(str);
        }
        if (syncUpdateInfo != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE ");
            sb.append(syncUpdateInfo.masterTable);
            sb.append(" SET _sync_dirty=1 WHERE _id=(SELECT ");
            sb.append(syncUpdateInfo.foreignKey);
            sb.append(" FROM ");
            sb.append(str);
            sb.append(" WHERE _id=");
            sb.append(j);
            sb.append(")");
            execSQL(sb.toString());
        }
    }

    public static String findEditTable(String str) {
        if (!TextUtils.isEmpty(str)) {
            int indexOf = str.indexOf(32);
            int indexOf2 = str.indexOf(44);
            if (indexOf <= 0 || (indexOf >= indexOf2 && indexOf2 >= 0)) {
                return (indexOf2 <= 0 || (indexOf2 >= indexOf && indexOf >= 0)) ? str : str.substring(0, indexOf2);
            }
            return str.substring(0, indexOf);
        }
        throw new IllegalStateException("Invalid tables");
    }

    public SQLiteStatement compileStatement(String str) throws SQLException {
        lock();
        if (isOpen()) {
            try {
                return new SQLiteStatement(this, str);
            } finally {
                unlock();
            }
        } else {
            throw new IllegalStateException("database not open");
        }
    }

    public Cursor query(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        return queryWithFactory(null, z, str, strArr, str2, strArr2, str3, str4, str5, str6);
    }

    public Cursor queryWithFactory(CursorFactory cursorFactory, boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        if (isOpen()) {
            CursorFactory cursorFactory2 = cursorFactory;
            String[] strArr3 = strArr2;
            return rawQueryWithFactory(cursorFactory, SQLiteQueryBuilder.buildQueryString(z, str, strArr, str2, str3, str4, str5, str6), strArr2, findEditTable(str));
        }
        throw new IllegalStateException("database not open");
    }

    public Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        return query(false, str, strArr, str2, strArr2, str3, str4, str5, null);
    }

    public Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        return query(false, str, strArr, str2, strArr2, str3, str4, str5, str6);
    }

    public Cursor rawQuery(String str, String[] strArr) {
        return rawQueryWithFactory(null, str, strArr, null);
    }

    public Cursor rawQueryWithFactory(CursorFactory cursorFactory, String str, String[] strArr, String str2) {
        if (isOpen()) {
            long j = 0;
            int i = -1;
            if (this.mSlowQueryThreshold != -1) {
                j = System.currentTimeMillis();
            }
            SQLiteDirectCursorDriver sQLiteDirectCursorDriver = new SQLiteDirectCursorDriver(this, str, str2);
            if (cursorFactory == null) {
                try {
                    cursorFactory = this.mFactory;
                } catch (Throwable th) {
                    if (this.mSlowQueryThreshold != -1) {
                        long currentTimeMillis = System.currentTimeMillis() - j;
                        if (currentTimeMillis >= ((long) this.mSlowQueryThreshold)) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("query (");
                            sb.append(currentTimeMillis);
                            sb.append(" ms): ");
                            sb.append(sQLiteDirectCursorDriver.toString());
                            sb.append(", args are <redacted>, count is ");
                            sb.append(-1);
                            Log.v(TAG, sb.toString());
                        }
                    }
                    throw th;
                }
            }
            Cursor query = sQLiteDirectCursorDriver.query(cursorFactory, strArr);
            if (this.mSlowQueryThreshold != -1) {
                if (query != null) {
                    i = query.getCount();
                }
                long currentTimeMillis2 = System.currentTimeMillis() - j;
                if (currentTimeMillis2 >= ((long) this.mSlowQueryThreshold)) {
                    String str3 = TAG;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("query (");
                    sb2.append(currentTimeMillis2);
                    sb2.append(" ms): ");
                    sb2.append(sQLiteDirectCursorDriver.toString());
                    sb2.append(", args are <redacted>, count is ");
                    sb2.append(i);
                    Log.v(str3, sb2.toString());
                }
            }
            return new CrossProcessCursorWrapper(query);
        }
        throw new IllegalStateException("database not open");
    }

    public Cursor rawQuery(String str, String[] strArr, int i, int i2) {
        CursorWrapper cursorWrapper = (CursorWrapper) rawQueryWithFactory(null, str, strArr, null);
        ((SQLiteCursor) cursorWrapper.getWrappedCursor()).setLoadStyle(i, i2);
        return cursorWrapper;
    }

    public long insert(String str, String str2, ContentValues contentValues) {
        try {
            return insertWithOnConflict(str, str2, contentValues, 0);
        } catch (SQLException e) {
            String str3 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("Error inserting <redacted values> into ");
            sb.append(str);
            Log.e(str3, sb.toString(), e);
            return -1;
        }
    }

    public long insertOrThrow(String str, String str2, ContentValues contentValues) throws SQLException {
        return insertWithOnConflict(str, str2, contentValues, 0);
    }

    public long replace(String str, String str2, ContentValues contentValues) {
        try {
            return insertWithOnConflict(str, str2, contentValues, 5);
        } catch (SQLException e) {
            String str3 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("Error inserting <redacted values> into ");
            sb.append(str);
            Log.e(str3, sb.toString(), e);
            return -1;
        }
    }

    public long replaceOrThrow(String str, String str2, ContentValues contentValues) throws SQLException {
        return insertWithOnConflict(str, str2, contentValues, 5);
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0122  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long insertWithOnConflict(java.lang.String r6, java.lang.String r7, android.content.ContentValues r8, int r9) {
        /*
            r5 = this;
            boolean r0 = r5.isOpen()
            if (r0 == 0) goto L_0x0129
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = 152(0x98, float:2.13E-43)
            r0.<init>(r1)
            java.lang.String r1 = "INSERT"
            r0.append(r1)
            java.lang.String[] r1 = CONFLICT_VALUES
            r9 = r1[r9]
            r0.append(r9)
            java.lang.String r9 = " INTO "
            r0.append(r9)
            r0.append(r6)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r1 = 40
            r9.<init>(r1)
            r2 = 0
            r3 = 0
            if (r8 == 0) goto L_0x006c
            int r4 = r8.size()
            if (r4 <= 0) goto L_0x006c
            java.util.Set r7 = r8.valueSet()
            java.util.Iterator r8 = r7.iterator()
            r0.append(r1)
            r1 = 0
        L_0x003e:
            boolean r4 = r8.hasNext()
            if (r4 == 0) goto L_0x0066
            if (r1 == 0) goto L_0x0050
            java.lang.String r1 = ", "
            r0.append(r1)
            java.lang.String r1 = ", "
            r9.append(r1)
        L_0x0050:
            java.lang.Object r1 = r8.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r1 = r1.getKey()
            java.lang.String r1 = (java.lang.String) r1
            r0.append(r1)
            r1 = 63
            r9.append(r1)
            r1 = 1
            goto L_0x003e
        L_0x0066:
            r8 = 41
            r0.append(r8)
            goto L_0x008b
        L_0x006c:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r1 = "("
            r8.append(r1)
            r8.append(r7)
            java.lang.String r7 = ") "
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            r0.append(r7)
            java.lang.String r7 = "NULL"
            r9.append(r7)
            r7 = r3
        L_0x008b:
            java.lang.String r8 = " VALUES("
            r0.append(r8)
            r0.append(r9)
            java.lang.String r8 = ");"
            r0.append(r8)
            r5.lock()
            java.lang.String r8 = r0.toString()     // Catch:{ SQLiteDatabaseCorruptException -> 0x011b }
            net.sqlcipher.database.SQLiteStatement r8 = r5.compileStatement(r8)     // Catch:{ SQLiteDatabaseCorruptException -> 0x011b }
            if (r7 == 0) goto L_0x00c4
            int r9 = r7.size()     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c1, all -> 0x00bf }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c1, all -> 0x00bf }
        L_0x00ad:
            if (r2 >= r9) goto L_0x00c4
            java.lang.Object r0 = r7.next()     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c1, all -> 0x00bf }
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c1, all -> 0x00bf }
            int r2 = r2 + 1
            java.lang.Object r0 = r0.getValue()     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c1, all -> 0x00bf }
            net.sqlcipher.DatabaseUtils.bindObjectToProgram(r8, r2, r0)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c1, all -> 0x00bf }
            goto L_0x00ad
        L_0x00bf:
            r6 = move-exception
            goto L_0x0120
        L_0x00c1:
            r6 = move-exception
            r3 = r8
            goto L_0x011c
        L_0x00c4:
            r8.execute()     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c1, all -> 0x00bf }
            long r0 = r5.lastInsertRow()     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c1, all -> 0x00bf }
            r2 = -1
            int r7 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r7 != 0) goto L_0x00e8
            java.lang.String r7 = "Database"
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c1, all -> 0x00bf }
            r9.<init>()     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c1, all -> 0x00bf }
            java.lang.String r2 = "Error inserting <redacted values> using <redacted sql> into "
            r9.append(r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c1, all -> 0x00bf }
            r9.append(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c1, all -> 0x00bf }
            java.lang.String r6 = r9.toString()     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c1, all -> 0x00bf }
            android.util.Log.e(r7, r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c1, all -> 0x00bf }
            goto L_0x010f
        L_0x00e8:
            java.lang.String r7 = "Database"
            r9 = 2
            boolean r7 = android.util.Log.isLoggable(r7, r9)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c1, all -> 0x00bf }
            if (r7 == 0) goto L_0x010f
            java.lang.String r7 = "Database"
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c1, all -> 0x00bf }
            r9.<init>()     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c1, all -> 0x00bf }
            java.lang.String r2 = "Inserting row "
            r9.append(r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c1, all -> 0x00bf }
            r9.append(r0)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c1, all -> 0x00bf }
            java.lang.String r2 = " from <redacted values> using <redacted sql> into "
            r9.append(r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c1, all -> 0x00bf }
            r9.append(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c1, all -> 0x00bf }
            java.lang.String r6 = r9.toString()     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c1, all -> 0x00bf }
            android.util.Log.v(r7, r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00c1, all -> 0x00bf }
        L_0x010f:
            if (r8 == 0) goto L_0x0114
            r8.close()
        L_0x0114:
            r5.unlock()
            return r0
        L_0x0118:
            r6 = move-exception
            r8 = r3
            goto L_0x0120
        L_0x011b:
            r6 = move-exception
        L_0x011c:
            r5.onCorruption()     // Catch:{ all -> 0x0118 }
            throw r6     // Catch:{ all -> 0x0118 }
        L_0x0120:
            if (r8 == 0) goto L_0x0125
            r8.close()
        L_0x0125:
            r5.unlock()
            throw r6
        L_0x0129:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "database not open"
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.insertWithOnConflict(java.lang.String, java.lang.String, android.content.ContentValues, int):long");
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x006c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int delete(java.lang.String r4, java.lang.String r5, java.lang.String[] r6) {
        /*
            r3 = this;
            r3.lock()
            boolean r0 = r3.isOpen()
            if (r0 == 0) goto L_0x0073
            r0 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ SQLiteDatabaseCorruptException -> 0x0065 }
            r1.<init>()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0065 }
            java.lang.String r2 = "DELETE FROM "
            r1.append(r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0065 }
            r1.append(r4)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0065 }
            boolean r4 = android.text.TextUtils.isEmpty(r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0065 }
            if (r4 != 0) goto L_0x002f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ SQLiteDatabaseCorruptException -> 0x0065 }
            r4.<init>()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0065 }
            java.lang.String r2 = " WHERE "
            r4.append(r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0065 }
            r4.append(r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0065 }
            java.lang.String r4 = r4.toString()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0065 }
            goto L_0x0031
        L_0x002f:
            java.lang.String r4 = ""
        L_0x0031:
            r1.append(r4)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0065 }
            java.lang.String r4 = r1.toString()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0065 }
            net.sqlcipher.database.SQLiteStatement r4 = r3.compileStatement(r4)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0065 }
            if (r6 == 0) goto L_0x0053
            int r5 = r6.length     // Catch:{ SQLiteDatabaseCorruptException -> 0x004f, all -> 0x004b }
            r0 = 0
        L_0x0040:
            if (r0 >= r5) goto L_0x0053
            int r1 = r0 + 1
            r0 = r6[r0]     // Catch:{ SQLiteDatabaseCorruptException -> 0x004f, all -> 0x004b }
            net.sqlcipher.DatabaseUtils.bindObjectToProgram(r4, r1, r0)     // Catch:{ SQLiteDatabaseCorruptException -> 0x004f, all -> 0x004b }
            r0 = r1
            goto L_0x0040
        L_0x004b:
            r5 = move-exception
            r0 = r4
            r4 = r5
            goto L_0x006a
        L_0x004f:
            r5 = move-exception
            r0 = r4
            r4 = r5
            goto L_0x0066
        L_0x0053:
            r4.execute()     // Catch:{ SQLiteDatabaseCorruptException -> 0x004f, all -> 0x004b }
            int r5 = r3.lastChangeCount()     // Catch:{ SQLiteDatabaseCorruptException -> 0x004f, all -> 0x004b }
            if (r4 == 0) goto L_0x005f
            r4.close()
        L_0x005f:
            r3.unlock()
            return r5
        L_0x0063:
            r4 = move-exception
            goto L_0x006a
        L_0x0065:
            r4 = move-exception
        L_0x0066:
            r3.onCorruption()     // Catch:{ all -> 0x0063 }
            throw r4     // Catch:{ all -> 0x0063 }
        L_0x006a:
            if (r0 == 0) goto L_0x006f
            r0.close()
        L_0x006f:
            r3.unlock()
            throw r4
        L_0x0073:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "database not open"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.delete(java.lang.String, java.lang.String, java.lang.String[]):int");
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        return updateWithOnConflict(str, contentValues, str2, strArr, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x0101  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int updateWithOnConflict(java.lang.String r5, android.content.ContentValues r6, java.lang.String r7, java.lang.String[] r8, int r9) {
        /*
            r4 = this;
            if (r6 == 0) goto L_0x0110
            int r0 = r6.size()
            if (r0 == 0) goto L_0x0110
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = 120(0x78, float:1.68E-43)
            r0.<init>(r1)
            java.lang.String r1 = "UPDATE "
            r0.append(r1)
            java.lang.String[] r1 = CONFLICT_VALUES
            r9 = r1[r9]
            r0.append(r9)
            r0.append(r5)
            java.lang.String r9 = " SET "
            r0.append(r9)
            java.util.Set r6 = r6.valueSet()
            java.util.Iterator r9 = r6.iterator()
        L_0x002b:
            boolean r1 = r9.hasNext()
            if (r1 == 0) goto L_0x0051
            java.lang.Object r1 = r9.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r1 = r1.getKey()
            java.lang.String r1 = (java.lang.String) r1
            r0.append(r1)
            java.lang.String r1 = "=?"
            r0.append(r1)
            boolean r1 = r9.hasNext()
            if (r1 == 0) goto L_0x002b
            java.lang.String r1 = ", "
            r0.append(r1)
            goto L_0x002b
        L_0x0051:
            boolean r9 = android.text.TextUtils.isEmpty(r7)
            if (r9 != 0) goto L_0x005f
            java.lang.String r9 = " WHERE "
            r0.append(r9)
            r0.append(r7)
        L_0x005f:
            r4.lock()
            boolean r7 = r4.isOpen()
            if (r7 == 0) goto L_0x0108
            r7 = 0
            java.lang.String r9 = r0.toString()     // Catch:{ SQLiteDatabaseCorruptException -> 0x00fa, SQLException -> 0x00e2 }
            net.sqlcipher.database.SQLiteStatement r9 = r4.compileStatement(r9)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00fa, SQLException -> 0x00e2 }
            int r7 = r6.size()     // Catch:{ SQLiteDatabaseCorruptException -> 0x00dc, SQLException -> 0x00d9, all -> 0x00d7 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ SQLiteDatabaseCorruptException -> 0x00dc, SQLException -> 0x00d9, all -> 0x00d7 }
            r0 = 0
            r1 = 1
            r1 = 0
            r2 = 1
        L_0x007d:
            if (r1 >= r7) goto L_0x0091
            java.lang.Object r3 = r6.next()     // Catch:{ SQLiteDatabaseCorruptException -> 0x00dc, SQLException -> 0x00d9, all -> 0x00d7 }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ SQLiteDatabaseCorruptException -> 0x00dc, SQLException -> 0x00d9, all -> 0x00d7 }
            java.lang.Object r3 = r3.getValue()     // Catch:{ SQLiteDatabaseCorruptException -> 0x00dc, SQLException -> 0x00d9, all -> 0x00d7 }
            net.sqlcipher.DatabaseUtils.bindObjectToProgram(r9, r2, r3)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00dc, SQLException -> 0x00d9, all -> 0x00d7 }
            int r2 = r2 + 1
            int r1 = r1 + 1
            goto L_0x007d
        L_0x0091:
            if (r8 == 0) goto L_0x00a0
            int r6 = r8.length     // Catch:{ SQLiteDatabaseCorruptException -> 0x00dc, SQLException -> 0x00d9, all -> 0x00d7 }
        L_0x0094:
            if (r0 >= r6) goto L_0x00a0
            r7 = r8[r0]     // Catch:{ SQLiteDatabaseCorruptException -> 0x00dc, SQLException -> 0x00d9, all -> 0x00d7 }
            r9.bindString(r2, r7)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00dc, SQLException -> 0x00d9, all -> 0x00d7 }
            int r2 = r2 + 1
            int r0 = r0 + 1
            goto L_0x0094
        L_0x00a0:
            r9.execute()     // Catch:{ SQLiteDatabaseCorruptException -> 0x00dc, SQLException -> 0x00d9, all -> 0x00d7 }
            int r6 = r4.lastChangeCount()     // Catch:{ SQLiteDatabaseCorruptException -> 0x00dc, SQLException -> 0x00d9, all -> 0x00d7 }
            java.lang.String r7 = "Database"
            r8 = 2
            boolean r7 = android.util.Log.isLoggable(r7, r8)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00dc, SQLException -> 0x00d9, all -> 0x00d7 }
            if (r7 == 0) goto L_0x00ce
            java.lang.String r7 = "Database"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ SQLiteDatabaseCorruptException -> 0x00dc, SQLException -> 0x00d9, all -> 0x00d7 }
            r8.<init>()     // Catch:{ SQLiteDatabaseCorruptException -> 0x00dc, SQLException -> 0x00d9, all -> 0x00d7 }
            java.lang.String r0 = "Updated "
            r8.append(r0)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00dc, SQLException -> 0x00d9, all -> 0x00d7 }
            r8.append(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00dc, SQLException -> 0x00d9, all -> 0x00d7 }
            java.lang.String r0 = " rows using <redacted values> and <redacted sql> for "
            r8.append(r0)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00dc, SQLException -> 0x00d9, all -> 0x00d7 }
            r8.append(r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00dc, SQLException -> 0x00d9, all -> 0x00d7 }
            java.lang.String r8 = r8.toString()     // Catch:{ SQLiteDatabaseCorruptException -> 0x00dc, SQLException -> 0x00d9, all -> 0x00d7 }
            android.util.Log.v(r7, r8)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00dc, SQLException -> 0x00d9, all -> 0x00d7 }
        L_0x00ce:
            if (r9 == 0) goto L_0x00d3
            r9.close()
        L_0x00d3:
            r4.unlock()
            return r6
        L_0x00d7:
            r5 = move-exception
            goto L_0x00ff
        L_0x00d9:
            r6 = move-exception
            r7 = r9
            goto L_0x00e3
        L_0x00dc:
            r5 = move-exception
            r7 = r9
            goto L_0x00fb
        L_0x00df:
            r5 = move-exception
            r9 = r7
            goto L_0x00ff
        L_0x00e2:
            r6 = move-exception
        L_0x00e3:
            java.lang.String r8 = "Database"
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x00df }
            r9.<init>()     // Catch:{ all -> 0x00df }
            java.lang.String r0 = "Error updating <redacted values> using <redacted sql> for "
            r9.append(r0)     // Catch:{ all -> 0x00df }
            r9.append(r5)     // Catch:{ all -> 0x00df }
            java.lang.String r5 = r9.toString()     // Catch:{ all -> 0x00df }
            android.util.Log.e(r8, r5)     // Catch:{ all -> 0x00df }
            throw r6     // Catch:{ all -> 0x00df }
        L_0x00fa:
            r5 = move-exception
        L_0x00fb:
            r4.onCorruption()     // Catch:{ all -> 0x00df }
            throw r5     // Catch:{ all -> 0x00df }
        L_0x00ff:
            if (r9 == 0) goto L_0x0104
            r9.close()
        L_0x0104:
            r4.unlock()
            throw r5
        L_0x0108:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "database not open"
            r5.<init>(r6)
            throw r5
        L_0x0110:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "Empty values"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.updateWithOnConflict(java.lang.String, android.content.ContentValues, java.lang.String, java.lang.String[], int):int");
    }

    public void execSQL(String str) throws SQLException {
        long uptimeMillis = SystemClock.uptimeMillis();
        lock();
        if (isOpen()) {
            logTimeStat(this.mLastSqlStatement, uptimeMillis, GET_LOCK_LOG_PREFIX);
            try {
                native_execSQL(str);
                unlock();
                if (str == COMMIT_SQL) {
                    logTimeStat(this.mLastSqlStatement, uptimeMillis, COMMIT_SQL);
                } else {
                    logTimeStat(str, uptimeMillis, null);
                }
            } catch (SQLiteDatabaseCorruptException e) {
                onCorruption();
                throw e;
            } catch (Throwable th) {
                unlock();
                throw th;
            }
        } else {
            throw new IllegalStateException("database not open");
        }
    }

    public void rawExecSQL(String str) {
        long uptimeMillis = SystemClock.uptimeMillis();
        lock();
        if (isOpen()) {
            logTimeStat(this.mLastSqlStatement, uptimeMillis, GET_LOCK_LOG_PREFIX);
            try {
                native_rawExecSQL(str);
                unlock();
                if (str == COMMIT_SQL) {
                    logTimeStat(this.mLastSqlStatement, uptimeMillis, COMMIT_SQL);
                } else {
                    logTimeStat(str, uptimeMillis, null);
                }
            } catch (SQLiteDatabaseCorruptException e) {
                onCorruption();
                throw e;
            } catch (Throwable th) {
                unlock();
                throw th;
            }
        } else {
            throw new IllegalStateException("database not open");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0041  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void execSQL(java.lang.String r7, java.lang.Object[] r8) throws net.sqlcipher.SQLException {
        /*
            r6 = this;
            if (r8 == 0) goto L_0x0050
            long r0 = android.os.SystemClock.uptimeMillis()
            r6.lock()
            boolean r2 = r6.isOpen()
            if (r2 == 0) goto L_0x0048
            r2 = 0
            net.sqlcipher.database.SQLiteStatement r3 = r6.compileStatement(r7)     // Catch:{ SQLiteDatabaseCorruptException -> 0x003a }
            if (r8 == 0) goto L_0x0028
            int r2 = r8.length     // Catch:{ SQLiteDatabaseCorruptException -> 0x0025, all -> 0x0023 }
            r4 = 0
        L_0x0018:
            if (r4 >= r2) goto L_0x0028
            int r5 = r4 + 1
            r4 = r8[r4]     // Catch:{ SQLiteDatabaseCorruptException -> 0x0025, all -> 0x0023 }
            net.sqlcipher.DatabaseUtils.bindObjectToProgram(r3, r5, r4)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0025, all -> 0x0023 }
            r4 = r5
            goto L_0x0018
        L_0x0023:
            r7 = move-exception
            goto L_0x003f
        L_0x0025:
            r7 = move-exception
            r2 = r3
            goto L_0x003b
        L_0x0028:
            r3.execute()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0025, all -> 0x0023 }
            if (r3 == 0) goto L_0x0030
            r3.close()
        L_0x0030:
            r6.unlock()
            r6.logTimeStat(r7, r0)
            return
        L_0x0037:
            r7 = move-exception
            r3 = r2
            goto L_0x003f
        L_0x003a:
            r7 = move-exception
        L_0x003b:
            r6.onCorruption()     // Catch:{ all -> 0x0037 }
            throw r7     // Catch:{ all -> 0x0037 }
        L_0x003f:
            if (r3 == 0) goto L_0x0044
            r3.close()
        L_0x0044:
            r6.unlock()
            throw r7
        L_0x0048:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "database not open"
            r7.<init>(r8)
            throw r7
        L_0x0050:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r8 = "Empty bindArgs"
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.execSQL(java.lang.String, java.lang.Object[]):void");
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        if (isOpen()) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("close() was never explicitly called on database '");
            sb.append(this.mPath);
            sb.append("' ");
            Log.e(str, sb.toString(), this.mStackTrace);
            closeClosable();
            onAllReferencesReleased();
        }
    }

    public SQLiteDatabase(String str, char[] cArr, CursorFactory cursorFactory, int i) {
        this(str, cursorFactory, i, (DatabaseErrorHandler) null);
        openDatabaseInternal(cArr, null);
    }

    public SQLiteDatabase(String str, char[] cArr, CursorFactory cursorFactory, int i, SQLiteDatabaseHook sQLiteDatabaseHook) {
        this(str, cursorFactory, i, (DatabaseErrorHandler) null);
        openDatabaseInternal(cArr, sQLiteDatabaseHook);
    }

    private SQLiteDatabase(String str, CursorFactory cursorFactory, int i, DatabaseErrorHandler databaseErrorHandler) {
        this.mLock = new ReentrantLock(true);
        this.mLockAcquiredWallTime = 0;
        this.mLockAcquiredThreadTime = 0;
        this.mLastLockMessageTime = 0;
        this.mRandom = new Random();
        this.mLastSqlStatement = null;
        this.mNativeHandle = 0;
        this.mTempTableSequence = 0;
        this.mPathForLogs = null;
        this.mCompiledQueries = new HashMap();
        this.mMaxSqlCacheSize = MAX_SQL_CACHE_SIZE;
        this.mTimeOpened = null;
        this.mTimeClosed = null;
        this.mStackTrace = null;
        this.mLockingEnabled = true;
        this.mSyncUpdateInfo = new HashMap();
        if (str != null) {
            this.mFlags = i;
            this.mPath = str;
            this.mSlowQueryThreshold = -1;
            this.mStackTrace = new DatabaseObjectNotClosedException().fillInStackTrace();
            this.mFactory = cursorFactory;
            this.mPrograms = new WeakHashMap<>();
            this.mErrorHandler = databaseErrorHandler;
            return;
        }
        throw new IllegalArgumentException("path should not be null");
    }

    private void openDatabaseInternal(char[] cArr, SQLiteDatabaseHook sQLiteDatabaseHook) {
        dbopen(this.mPath, this.mFlags);
        if (sQLiteDatabaseHook != null) {
            sQLiteDatabaseHook.preKey(this);
        }
        if (cArr != null) {
            native_key(cArr);
        }
        if (sQLiteDatabaseHook != null) {
            sQLiteDatabaseHook.postKey(this);
        }
        if (SQLiteDebug.DEBUG_SQL_CACHE) {
            this.mTimeOpened = getTime();
        }
        try {
            Cursor rawQuery = rawQuery("select count(*) from sqlite_master;", new String[0]);
            if (rawQuery != null) {
                rawQuery.moveToFirst();
                rawQuery.getInt(0);
                rawQuery.close();
            }
        } catch (RuntimeException e) {
            Log.e(TAG, "Failed to setLocale() when constructing, closing the database", e);
            dbclose();
            if (SQLiteDebug.DEBUG_SQL_CACHE) {
                this.mTimeClosed = getTime();
            }
            throw e;
        }
    }

    private String getTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS ").format(Long.valueOf(System.currentTimeMillis()));
    }

    public boolean isReadOnly() {
        return (this.mFlags & 1) == 1;
    }

    public boolean isOpen() {
        return this.mNativeHandle != 0;
    }

    public boolean needUpgrade(int i) {
        return i > getVersion();
    }

    public final String getPath() {
        return this.mPath;
    }

    /* access modifiers changed from: 0000 */
    public void logTimeStat(String str, long j) {
        logTimeStat(str, j, null);
    }

    /* access modifiers changed from: 0000 */
    public void logTimeStat(String str, long j, String str2) {
        this.mLastSqlStatement = str;
        long uptimeMillis = SystemClock.uptimeMillis() - j;
        if (uptimeMillis != 0 || str2 != GET_LOCK_LOG_PREFIX) {
            if (sQueryLogTimeInMillis == 0) {
                sQueryLogTimeInMillis = 500;
            }
            if (uptimeMillis >= ((long) sQueryLogTimeInMillis) || this.mRandom.nextInt(100) < ((int) ((uptimeMillis * 100) / ((long) sQueryLogTimeInMillis))) + 1) {
                if (str2 != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    sb.append(str);
                    str = sb.toString();
                }
                if (str.length() > 64) {
                    str.substring(0, 64);
                }
            }
        }
    }

    private String getPathForLogs() {
        if (this.mPathForLogs != null) {
            return this.mPathForLogs;
        }
        if (this.mPath == null) {
            return null;
        }
        if (this.mPath.indexOf(64) == -1) {
            this.mPathForLogs = this.mPath;
        } else {
            this.mPathForLogs = EMAIL_IN_DB_PATTERN.matcher(this.mPath).replaceAll("XX@YY");
        }
        return this.mPathForLogs;
    }

    public void setLocale(Locale locale) {
        lock();
        try {
            native_setLocale(locale.toString(), this.mFlags);
        } finally {
            unlock();
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00b3, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addToCompiledQueries(java.lang.String r4, net.sqlcipher.database.SQLiteCompiledSql r5) {
        /*
            r3 = this;
            int r0 = r3.mMaxSqlCacheSize
            if (r0 != 0) goto L_0x002b
            boolean r5 = net.sqlcipher.database.SQLiteDebug.DEBUG_SQL_CACHE
            if (r5 == 0) goto L_0x002a
            java.lang.String r5 = "Database"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "|NOT adding_sql_to_cache|"
            r0.append(r1)
            java.lang.String r1 = r3.getPath()
            r0.append(r1)
            java.lang.String r1 = "|"
            r0.append(r1)
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            android.util.Log.v(r5, r4)
        L_0x002a:
            return
        L_0x002b:
            java.util.Map<java.lang.String, net.sqlcipher.database.SQLiteCompiledSql> r0 = r3.mCompiledQueries
            monitor-enter(r0)
            java.util.Map<java.lang.String, net.sqlcipher.database.SQLiteCompiledSql> r1 = r3.mCompiledQueries     // Catch:{ all -> 0x00b4 }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x00b4 }
            net.sqlcipher.database.SQLiteCompiledSql r1 = (net.sqlcipher.database.SQLiteCompiledSql) r1     // Catch:{ all -> 0x00b4 }
            if (r1 == 0) goto L_0x003a
            monitor-exit(r0)     // Catch:{ all -> 0x00b4 }
            return
        L_0x003a:
            java.util.Map<java.lang.String, net.sqlcipher.database.SQLiteCompiledSql> r1 = r3.mCompiledQueries     // Catch:{ all -> 0x00b4 }
            int r1 = r1.size()     // Catch:{ all -> 0x00b4 }
            int r2 = r3.mMaxSqlCacheSize     // Catch:{ all -> 0x00b4 }
            if (r1 != r2) goto L_0x0079
            int r5 = r3.mCacheFullWarnings     // Catch:{ all -> 0x00b4 }
            r1 = 1
            int r5 = r5 + r1
            r3.mCacheFullWarnings = r5     // Catch:{ all -> 0x00b4 }
            if (r5 != r1) goto L_0x00b2
            java.lang.String r5 = "Database"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b4 }
            r1.<init>()     // Catch:{ all -> 0x00b4 }
            java.lang.String r2 = "Reached MAX size for compiled-sql statement cache for database "
            r1.append(r2)     // Catch:{ all -> 0x00b4 }
            java.lang.String r2 = r3.getPath()     // Catch:{ all -> 0x00b4 }
            r1.append(r2)     // Catch:{ all -> 0x00b4 }
            java.lang.String r2 = "; i.e., NO space for this sql statement in cache: "
            r1.append(r2)     // Catch:{ all -> 0x00b4 }
            r1.append(r4)     // Catch:{ all -> 0x00b4 }
            java.lang.String r4 = ". Please change your sql statements to use '?' for "
            r1.append(r4)     // Catch:{ all -> 0x00b4 }
            java.lang.String r4 = "bindargs, instead of using actual values"
            r1.append(r4)     // Catch:{ all -> 0x00b4 }
            java.lang.String r4 = r1.toString()     // Catch:{ all -> 0x00b4 }
            android.util.Log.w(r5, r4)     // Catch:{ all -> 0x00b4 }
            goto L_0x00b2
        L_0x0079:
            java.util.Map<java.lang.String, net.sqlcipher.database.SQLiteCompiledSql> r1 = r3.mCompiledQueries     // Catch:{ all -> 0x00b4 }
            r1.put(r4, r5)     // Catch:{ all -> 0x00b4 }
            boolean r5 = net.sqlcipher.database.SQLiteDebug.DEBUG_SQL_CACHE     // Catch:{ all -> 0x00b4 }
            if (r5 == 0) goto L_0x00b2
            java.lang.String r5 = "Database"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b4 }
            r1.<init>()     // Catch:{ all -> 0x00b4 }
            java.lang.String r2 = "|adding_sql_to_cache|"
            r1.append(r2)     // Catch:{ all -> 0x00b4 }
            java.lang.String r2 = r3.getPath()     // Catch:{ all -> 0x00b4 }
            r1.append(r2)     // Catch:{ all -> 0x00b4 }
            java.lang.String r2 = "|"
            r1.append(r2)     // Catch:{ all -> 0x00b4 }
            java.util.Map<java.lang.String, net.sqlcipher.database.SQLiteCompiledSql> r2 = r3.mCompiledQueries     // Catch:{ all -> 0x00b4 }
            int r2 = r2.size()     // Catch:{ all -> 0x00b4 }
            r1.append(r2)     // Catch:{ all -> 0x00b4 }
            java.lang.String r2 = "|"
            r1.append(r2)     // Catch:{ all -> 0x00b4 }
            r1.append(r4)     // Catch:{ all -> 0x00b4 }
            java.lang.String r4 = r1.toString()     // Catch:{ all -> 0x00b4 }
            android.util.Log.v(r5, r4)     // Catch:{ all -> 0x00b4 }
        L_0x00b2:
            monitor-exit(r0)     // Catch:{ all -> 0x00b4 }
            return
        L_0x00b4:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00b4 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.addToCompiledQueries(java.lang.String, net.sqlcipher.database.SQLiteCompiledSql):void");
    }

    private void deallocCachedSqlStatements() {
        synchronized (this.mCompiledQueries) {
            for (SQLiteCompiledSql releaseSqlStatement : this.mCompiledQueries.values()) {
                releaseSqlStatement.releaseSqlStatement();
            }
            this.mCompiledQueries.clear();
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0037, code lost:
        if (r3 == false) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0039, code lost:
        r5.mNumCacheHits++;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003f, code lost:
        r5.mNumCacheMisses++;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0046, code lost:
        if (net.sqlcipher.database.SQLiteDebug.DEBUG_SQL_CACHE == false) goto L_0x00a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0048, code lost:
        r0 = TAG;
        r2 = new java.lang.StringBuilder();
        r2.append("|cache_stats|");
        r2.append(getPath());
        r2.append("|");
        r2.append(r5.mCompiledQueries.size());
        r2.append("|");
        r2.append(r5.mNumCacheHits);
        r2.append("|");
        r2.append(r5.mNumCacheMisses);
        r2.append("|");
        r2.append(r3);
        r2.append("|");
        r2.append(r5.mTimeOpened);
        r2.append("|");
        r2.append(r5.mTimeClosed);
        r2.append("|");
        r2.append(r6);
        android.util.Log.v(r0, r2.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00a8, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public net.sqlcipher.database.SQLiteCompiledSql getCompiledStatementForSql(java.lang.String r6) {
        /*
            r5 = this;
            java.util.Map<java.lang.String, net.sqlcipher.database.SQLiteCompiledSql> r0 = r5.mCompiledQueries
            monitor-enter(r0)
            int r1 = r5.mMaxSqlCacheSize     // Catch:{ all -> 0x00a9 }
            if (r1 != 0) goto L_0x0028
            boolean r6 = net.sqlcipher.database.SQLiteDebug.DEBUG_SQL_CACHE     // Catch:{ all -> 0x00a9 }
            if (r6 == 0) goto L_0x0025
            java.lang.String r6 = "Database"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a9 }
            r1.<init>()     // Catch:{ all -> 0x00a9 }
            java.lang.String r2 = "|cache NOT found|"
            r1.append(r2)     // Catch:{ all -> 0x00a9 }
            java.lang.String r2 = r5.getPath()     // Catch:{ all -> 0x00a9 }
            r1.append(r2)     // Catch:{ all -> 0x00a9 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00a9 }
            android.util.Log.v(r6, r1)     // Catch:{ all -> 0x00a9 }
        L_0x0025:
            r6 = 0
            monitor-exit(r0)     // Catch:{ all -> 0x00a9 }
            return r6
        L_0x0028:
            java.util.Map<java.lang.String, net.sqlcipher.database.SQLiteCompiledSql> r1 = r5.mCompiledQueries     // Catch:{ all -> 0x00a9 }
            java.lang.Object r1 = r1.get(r6)     // Catch:{ all -> 0x00a9 }
            net.sqlcipher.database.SQLiteCompiledSql r1 = (net.sqlcipher.database.SQLiteCompiledSql) r1     // Catch:{ all -> 0x00a9 }
            r2 = 1
            if (r1 == 0) goto L_0x0035
            r3 = 1
            goto L_0x0036
        L_0x0035:
            r3 = 0
        L_0x0036:
            monitor-exit(r0)     // Catch:{ all -> 0x00a9 }
            if (r3 == 0) goto L_0x003f
            int r0 = r5.mNumCacheHits
            int r0 = r0 + r2
            r5.mNumCacheHits = r0
            goto L_0x0044
        L_0x003f:
            int r0 = r5.mNumCacheMisses
            int r0 = r0 + r2
            r5.mNumCacheMisses = r0
        L_0x0044:
            boolean r0 = net.sqlcipher.database.SQLiteDebug.DEBUG_SQL_CACHE
            if (r0 == 0) goto L_0x00a8
            java.lang.String r0 = "Database"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "|cache_stats|"
            r2.append(r4)
            java.lang.String r4 = r5.getPath()
            r2.append(r4)
            java.lang.String r4 = "|"
            r2.append(r4)
            java.util.Map<java.lang.String, net.sqlcipher.database.SQLiteCompiledSql> r4 = r5.mCompiledQueries
            int r4 = r4.size()
            r2.append(r4)
            java.lang.String r4 = "|"
            r2.append(r4)
            int r4 = r5.mNumCacheHits
            r2.append(r4)
            java.lang.String r4 = "|"
            r2.append(r4)
            int r4 = r5.mNumCacheMisses
            r2.append(r4)
            java.lang.String r4 = "|"
            r2.append(r4)
            r2.append(r3)
            java.lang.String r3 = "|"
            r2.append(r3)
            java.lang.String r3 = r5.mTimeOpened
            r2.append(r3)
            java.lang.String r3 = "|"
            r2.append(r3)
            java.lang.String r3 = r5.mTimeClosed
            r2.append(r3)
            java.lang.String r3 = "|"
            r2.append(r3)
            r2.append(r6)
            java.lang.String r6 = r2.toString()
            android.util.Log.v(r0, r6)
        L_0x00a8:
            return r1
        L_0x00a9:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00a9 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.getCompiledStatementForSql(java.lang.String):net.sqlcipher.database.SQLiteCompiledSql");
    }

    public boolean isInCompiledSqlCache(String str) {
        boolean containsKey;
        synchronized (this.mCompiledQueries) {
            containsKey = this.mCompiledQueries.containsKey(str);
        }
        return containsKey;
    }

    public void purgeFromCompiledSqlCache(String str) {
        synchronized (this.mCompiledQueries) {
            this.mCompiledQueries.remove(str);
        }
    }

    public void resetCompiledSqlCache() {
        synchronized (this.mCompiledQueries) {
            this.mCompiledQueries.clear();
        }
    }

    public synchronized int getMaxSqlCacheSize() {
        return this.mMaxSqlCacheSize;
    }

    public synchronized void setMaxSqlCacheSize(int i) {
        if (i > 250 || i < 0) {
            throw new IllegalStateException("expected value between 0 and 250");
        } else if (i >= this.mMaxSqlCacheSize) {
            this.mMaxSqlCacheSize = i;
        } else {
            throw new IllegalStateException("cannot set cacheSize to a value less than the value set with previous setMaxSqlCacheSize() call.");
        }
    }

    static ArrayList<DbStats> getDbStats() {
        String str;
        ArrayList<DbStats> arrayList = new ArrayList<>();
        Iterator it = getActiveDatabases().iterator();
        while (it.hasNext()) {
            SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) it.next();
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                int native_getDbLookaside = sQLiteDatabase.native_getDbLookaside();
                String path = sQLiteDatabase.getPath();
                int lastIndexOf = path.lastIndexOf("/");
                String substring = path.substring(lastIndexOf != -1 ? lastIndexOf + 1 : 0);
                ArrayList attachedDbs = getAttachedDbs(sQLiteDatabase);
                if (attachedDbs != null) {
                    int i = native_getDbLookaside;
                    for (int i2 = 0; i2 < attachedDbs.size(); i2++) {
                        Pair pair = (Pair) attachedDbs.get(i2);
                        StringBuilder sb = new StringBuilder();
                        sb.append((String) pair.first);
                        sb.append(".page_count;");
                        long pragmaVal = getPragmaVal(sQLiteDatabase, sb.toString());
                        if (i2 == 0) {
                            str = substring;
                        } else {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("  (attached) ");
                            sb2.append((String) pair.first);
                            String sb3 = sb2.toString();
                            if (((String) pair.second).trim().length() > 0) {
                                int lastIndexOf2 = ((String) pair.second).lastIndexOf("/");
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append(sb3);
                                sb4.append(" : ");
                                sb4.append(((String) pair.second).substring(lastIndexOf2 != -1 ? lastIndexOf2 + 1 : 0));
                                sb3 = sb4.toString();
                            }
                            str = sb3;
                            i = 0;
                        }
                        if (pragmaVal > 0) {
                            DbStats dbStats = new DbStats(str, pragmaVal, sQLiteDatabase.getPageSize(), i);
                            arrayList.add(dbStats);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private static ArrayList<SQLiteDatabase> getActiveDatabases() {
        ArrayList<SQLiteDatabase> arrayList = new ArrayList<>();
        synchronized (sActiveDatabases) {
            arrayList.addAll(sActiveDatabases.keySet());
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long getPragmaVal(net.sqlcipher.database.SQLiteDatabase r4, java.lang.String r5) {
        /*
            boolean r0 = r4.isOpen()
            if (r0 != 0) goto L_0x0009
            r4 = 0
            return r4
        L_0x0009:
            r0 = 0
            net.sqlcipher.database.SQLiteStatement r1 = new net.sqlcipher.database.SQLiteStatement     // Catch:{ all -> 0x002b }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x002b }
            r2.<init>()     // Catch:{ all -> 0x002b }
            java.lang.String r3 = "PRAGMA "
            r2.append(r3)     // Catch:{ all -> 0x002b }
            r2.append(r5)     // Catch:{ all -> 0x002b }
            java.lang.String r5 = r2.toString()     // Catch:{ all -> 0x002b }
            r1.<init>(r4, r5)     // Catch:{ all -> 0x002b }
            long r4 = r1.simpleQueryForLong()     // Catch:{ all -> 0x0028 }
            r1.close()
            return r4
        L_0x0028:
            r4 = move-exception
            r0 = r1
            goto L_0x002c
        L_0x002b:
            r4 = move-exception
        L_0x002c:
            if (r0 == 0) goto L_0x0031
            r0.close()
        L_0x0031:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.getPragmaVal(net.sqlcipher.database.SQLiteDatabase, java.lang.String):long");
    }

    private static ArrayList<Pair<String, String>> getAttachedDbs(SQLiteDatabase sQLiteDatabase) {
        if (!sQLiteDatabase.isOpen()) {
            return null;
        }
        ArrayList<Pair<String, String>> arrayList = new ArrayList<>();
        Cursor rawQuery = sQLiteDatabase.rawQuery("pragma database_list;", null);
        while (rawQuery.moveToNext()) {
            arrayList.add(new Pair(rawQuery.getString(1), rawQuery.getString(2)));
        }
        rawQuery.close();
        return arrayList;
    }
}
