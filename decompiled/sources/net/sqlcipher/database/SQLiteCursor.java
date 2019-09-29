package net.sqlcipher.database;

import android.database.DataSetObserver;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.j256.ormlite.field.FieldType;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.locks.ReentrantLock;
import net.sqlcipher.AbstractWindowedCursor;
import net.sqlcipher.CursorWindow;
import net.sqlcipher.SQLException;

public class SQLiteCursor extends AbstractWindowedCursor {
    static final int NO_COUNT = -1;
    static final String TAG = "Cursor";
    private Map<String, Integer> mColumnNameMap;
    private String[] mColumns;
    /* access modifiers changed from: private */
    public int mCount = -1;
    /* access modifiers changed from: private */
    public int mCursorState;
    private SQLiteDatabase mDatabase;
    private SQLiteCursorDriver mDriver;
    private String mEditTable;
    private int mInitialRead = BaseClientBuilder.API_PRIORITY_OTHER;
    /* access modifiers changed from: private */
    public ReentrantLock mLock;
    /* access modifiers changed from: private */
    public int mMaxRead = BaseClientBuilder.API_PRIORITY_OTHER;
    protected MainThreadNotificationHandler mNotificationHandler;
    /* access modifiers changed from: private */
    public boolean mPendingData;
    /* access modifiers changed from: private */
    public SQLiteQuery mQuery;
    private Throwable mStackTrace;

    protected class MainThreadNotificationHandler extends Handler {
        protected MainThreadNotificationHandler() {
        }

        public void handleMessage(Message message) {
            SQLiteCursor.this.notifyDataSetChange();
        }
    }

    private final class QueryThread implements Runnable {
        private final int mThreadState;

        QueryThread(int i) {
            this.mThreadState = i;
        }

        private void sendMessage() {
            if (SQLiteCursor.this.mNotificationHandler != null) {
                SQLiteCursor.this.mNotificationHandler.sendEmptyMessage(1);
                SQLiteCursor.this.mPendingData = false;
                return;
            }
            SQLiteCursor.this.mPendingData = true;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
            net.sqlcipher.database.SQLiteCursor.access$502(r4.this$0, r1);
            sendMessage();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r4 = this;
                net.sqlcipher.database.SQLiteCursor r0 = net.sqlcipher.database.SQLiteCursor.this
                net.sqlcipher.CursorWindow r0 = r0.mWindow
                int r1 = android.os.Process.myTid()
                r2 = 10
                android.os.Process.setThreadPriority(r1, r2)
            L_0x000f:
                net.sqlcipher.database.SQLiteCursor r1 = net.sqlcipher.database.SQLiteCursor.this
                java.util.concurrent.locks.ReentrantLock r1 = r1.mLock
                r1.lock()
                net.sqlcipher.database.SQLiteCursor r1 = net.sqlcipher.database.SQLiteCursor.this
                int r1 = r1.mCursorState
                int r2 = r4.mThreadState
                if (r1 == r2) goto L_0x002c
                net.sqlcipher.database.SQLiteCursor r0 = net.sqlcipher.database.SQLiteCursor.this
                java.util.concurrent.locks.ReentrantLock r0 = r0.mLock
                r0.unlock()
                goto L_0x007c
            L_0x002c:
                net.sqlcipher.database.SQLiteCursor r1 = net.sqlcipher.database.SQLiteCursor.this     // Catch:{ Exception -> 0x0073, all -> 0x0068 }
                net.sqlcipher.database.SQLiteQuery r1 = r1.mQuery     // Catch:{ Exception -> 0x0073, all -> 0x0068 }
                net.sqlcipher.database.SQLiteCursor r2 = net.sqlcipher.database.SQLiteCursor.this     // Catch:{ Exception -> 0x0073, all -> 0x0068 }
                int r2 = r2.mMaxRead     // Catch:{ Exception -> 0x0073, all -> 0x0068 }
                net.sqlcipher.database.SQLiteCursor r3 = net.sqlcipher.database.SQLiteCursor.this     // Catch:{ Exception -> 0x0073, all -> 0x0068 }
                int r3 = r3.mCount     // Catch:{ Exception -> 0x0073, all -> 0x0068 }
                int r1 = r1.fillWindow(r0, r2, r3)     // Catch:{ Exception -> 0x0073, all -> 0x0068 }
                if (r1 == 0) goto L_0x0073
                r2 = -1
                if (r1 != r2) goto L_0x005f
                net.sqlcipher.database.SQLiteCursor r1 = net.sqlcipher.database.SQLiteCursor.this     // Catch:{ Exception -> 0x0073, all -> 0x0068 }
                net.sqlcipher.database.SQLiteCursor r2 = net.sqlcipher.database.SQLiteCursor.this     // Catch:{ Exception -> 0x0073, all -> 0x0068 }
                int r2 = r2.mMaxRead     // Catch:{ Exception -> 0x0073, all -> 0x0068 }
                net.sqlcipher.database.SQLiteCursor.access$512(r1, r2)     // Catch:{ Exception -> 0x0073, all -> 0x0068 }
                r4.sendMessage()     // Catch:{ Exception -> 0x0073, all -> 0x0068 }
                net.sqlcipher.database.SQLiteCursor r1 = net.sqlcipher.database.SQLiteCursor.this
                java.util.concurrent.locks.ReentrantLock r1 = r1.mLock
                r1.unlock()
                goto L_0x000f
            L_0x005f:
                net.sqlcipher.database.SQLiteCursor r0 = net.sqlcipher.database.SQLiteCursor.this     // Catch:{ Exception -> 0x0073, all -> 0x0068 }
                r0.mCount = r1     // Catch:{ Exception -> 0x0073, all -> 0x0068 }
                r4.sendMessage()     // Catch:{ Exception -> 0x0073, all -> 0x0068 }
                goto L_0x0073
            L_0x0068:
                r0 = move-exception
                net.sqlcipher.database.SQLiteCursor r1 = net.sqlcipher.database.SQLiteCursor.this
                java.util.concurrent.locks.ReentrantLock r1 = r1.mLock
                r1.unlock()
                throw r0
            L_0x0073:
                net.sqlcipher.database.SQLiteCursor r0 = net.sqlcipher.database.SQLiteCursor.this
                java.util.concurrent.locks.ReentrantLock r0 = r0.mLock
                r0.unlock()
            L_0x007c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteCursor.QueryThread.run():void");
        }
    }

    static /* synthetic */ int access$512(SQLiteCursor sQLiteCursor, int i) {
        int i2 = sQLiteCursor.mCount + i;
        sQLiteCursor.mCount = i2;
        return i2;
    }

    public void setLoadStyle(int i, int i2) {
        this.mMaxRead = i2;
        this.mInitialRead = i;
        this.mLock = new ReentrantLock(true);
    }

    private void queryThreadLock() {
        if (this.mLock != null) {
            this.mLock.lock();
        }
    }

    private void queryThreadUnlock() {
        if (this.mLock != null) {
            this.mLock.unlock();
        }
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        super.registerDataSetObserver(dataSetObserver);
        if (!(Integer.MAX_VALUE == this.mMaxRead && Integer.MAX_VALUE == this.mInitialRead) && this.mNotificationHandler == null) {
            queryThreadLock();
            try {
                this.mNotificationHandler = new MainThreadNotificationHandler();
                if (this.mPendingData) {
                    notifyDataSetChange();
                    this.mPendingData = false;
                }
            } finally {
                queryThreadUnlock();
            }
        }
    }

    public SQLiteCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        this.mCursorState = 0;
        this.mLock = null;
        this.mPendingData = false;
        this.mStackTrace = new DatabaseObjectNotClosedException().fillInStackTrace();
        this.mDatabase = sQLiteDatabase;
        this.mDriver = sQLiteCursorDriver;
        this.mEditTable = str;
        this.mColumnNameMap = null;
        this.mQuery = sQLiteQuery;
        try {
            sQLiteDatabase.lock();
            int columnCountLocked = this.mQuery.columnCountLocked();
            this.mColumns = new String[columnCountLocked];
            for (int i = 0; i < columnCountLocked; i++) {
                String columnNameLocked = this.mQuery.columnNameLocked(i);
                this.mColumns[i] = columnNameLocked;
                if (FieldType.FOREIGN_ID_FIELD_SUFFIX.equals(columnNameLocked)) {
                    this.mRowIdColumnIndex = i;
                }
            }
        } finally {
            sQLiteDatabase.unlock();
        }
    }

    public SQLiteDatabase getDatabase() {
        return this.mDatabase;
    }

    public boolean onMove(int i, int i2) {
        if (this.mWindow == null || i2 < this.mWindow.getStartPosition() || i2 >= this.mWindow.getStartPosition() + this.mWindow.getNumRows()) {
            fillWindow(i2);
        }
        return true;
    }

    public int getCount() {
        if (this.mCount == -1) {
            fillWindow(0);
        }
        return this.mCount;
    }

    private void fillWindow(int i) {
        if (this.mWindow == null) {
            this.mWindow = new CursorWindow(true);
        } else {
            this.mCursorState++;
            queryThreadLock();
            try {
                this.mWindow.clear();
            } finally {
                queryThreadUnlock();
            }
        }
        this.mWindow.setStartPosition(i);
        this.mCount = this.mQuery.fillWindow(this.mWindow, this.mInitialRead, 0);
        if (this.mCount == -1) {
            this.mCount = i + this.mInitialRead;
            new Thread(new QueryThread(this.mCursorState), "query thread").start();
        }
    }

    public int getColumnIndex(String str) {
        if (this.mColumnNameMap == null) {
            String[] strArr = this.mColumns;
            int length = strArr.length;
            HashMap hashMap = new HashMap(length, 1.0f);
            for (int i = 0; i < length; i++) {
                hashMap.put(strArr[i], Integer.valueOf(i));
            }
            this.mColumnNameMap = hashMap;
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf != -1) {
            Exception exc = new Exception();
            String str2 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("requesting column name with table name -- ");
            sb.append(str);
            Log.e(str2, sb.toString(), exc);
            str = str.substring(lastIndexOf + 1);
        }
        Integer num = (Integer) this.mColumnNameMap.get(str);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    public boolean deleteRow() {
        boolean z;
        checkPosition();
        if (this.mRowIdColumnIndex == -1 || this.mCurrentRowID == null) {
            Log.e(TAG, "Could not delete row because either the row ID column is not available or ithas not been read.");
            return false;
        }
        this.mDatabase.lock();
        try {
            SQLiteDatabase sQLiteDatabase = this.mDatabase;
            String str = this.mEditTable;
            StringBuilder sb = new StringBuilder();
            sb.append(this.mColumns[this.mRowIdColumnIndex]);
            sb.append("=?");
            sQLiteDatabase.delete(str, sb.toString(), new String[]{this.mCurrentRowID.toString()});
            z = true;
        } catch (SQLException unused) {
            z = false;
        }
        try {
            int i = this.mPos;
            requery();
            moveToPosition(i);
            if (!z) {
                return false;
            }
            onChange(true);
            return true;
        } finally {
            this.mDatabase.unlock();
        }
    }

    public String[] getColumnNames() {
        return this.mColumns;
    }

    public boolean supportsUpdates() {
        return !TextUtils.isEmpty(this.mEditTable);
    }

    public boolean commitUpdates(Map<? extends Long, ? extends Map<String, Object>> map) {
        if (!supportsUpdates()) {
            Log.e(TAG, "commitUpdates not supported on this cursor, did you include the _id column?");
            return false;
        }
        synchronized (this.mUpdatedRows) {
            if (map != null) {
                try {
                    this.mUpdatedRows.putAll(map);
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.mUpdatedRows.size() == 0) {
                return true;
            }
            this.mDatabase.beginTransaction();
            StringBuilder sb = new StringBuilder(128);
            for (Entry entry : this.mUpdatedRows.entrySet()) {
                Map map2 = (Map) entry.getValue();
                Long l = (Long) entry.getKey();
                if (l == null || map2 == null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("null rowId or values found! rowId = ");
                    sb2.append(l);
                    sb2.append(", values = ");
                    sb2.append(map2);
                    throw new IllegalStateException(sb2.toString());
                } else if (map2.size() != 0) {
                    long longValue = l.longValue();
                    Iterator it = map2.entrySet().iterator();
                    sb.setLength(0);
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("UPDATE ");
                    sb3.append(this.mEditTable);
                    sb3.append(" SET ");
                    sb.append(sb3.toString());
                    Object[] objArr = new Object[map2.size()];
                    int i = 0;
                    while (it.hasNext()) {
                        Entry entry2 = (Entry) it.next();
                        sb.append((String) entry2.getKey());
                        sb.append("=?");
                        objArr[i] = entry2.getValue();
                        if (it.hasNext()) {
                            sb.append(", ");
                        }
                        i++;
                    }
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(" WHERE ");
                    sb4.append(this.mColumns[this.mRowIdColumnIndex]);
                    sb4.append('=');
                    sb4.append(longValue);
                    sb.append(sb4.toString());
                    sb.append(';');
                    this.mDatabase.execSQL(sb.toString(), objArr);
                    this.mDatabase.rowUpdated(this.mEditTable, longValue);
                }
            }
            this.mDatabase.setTransactionSuccessful();
            this.mDatabase.endTransaction();
            this.mUpdatedRows.clear();
            onChange(true);
            return true;
        }
    }

    private void deactivateCommon() {
        this.mCursorState = 0;
        if (this.mWindow != null) {
            this.mWindow.close();
            this.mWindow = null;
        }
    }

    public void deactivate() {
        super.deactivate();
        deactivateCommon();
        this.mDriver.cursorDeactivated();
    }

    public void close() {
        super.close();
        deactivateCommon();
        this.mQuery.close();
        this.mDriver.cursorClosed();
    }

    public boolean requery() {
        if (isClosed()) {
            return false;
        }
        this.mDatabase.lock();
        try {
            if (this.mWindow != null) {
                this.mWindow.clear();
            }
            this.mPos = -1;
            this.mDriver.cursorRequeried(this);
            this.mCount = -1;
            this.mCursorState++;
            queryThreadLock();
            this.mQuery.requery();
            queryThreadUnlock();
            this.mDatabase.unlock();
            return super.requery();
        } catch (Throwable th) {
            this.mDatabase.unlock();
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    public void setWindow(CursorWindow cursorWindow) {
        if (this.mWindow != null) {
            this.mCursorState++;
            queryThreadLock();
            try {
                this.mWindow.close();
                queryThreadUnlock();
                this.mCount = -1;
            } catch (Throwable th) {
                queryThreadUnlock();
                throw th;
            }
        }
        this.mWindow = cursorWindow;
    }

    public void setSelectionArguments(String[] strArr) {
        this.mDriver.setBindArguments(strArr);
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        try {
            if (this.mWindow != null) {
                int length = this.mQuery.mSql.length();
                String str = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("Finalizing a Cursor that has not been deactivated or closed. database = ");
                sb.append(this.mDatabase.getPath());
                sb.append(", table = ");
                sb.append(this.mEditTable);
                sb.append(", query = ");
                String str2 = this.mQuery.mSql;
                if (length > 100) {
                    length = 100;
                }
                sb.append(str2.substring(0, length));
                Log.e(str, sb.toString(), this.mStackTrace);
                close();
                SQLiteDebug.notifyActiveCursorFinalized();
            }
        } finally {
            super.finalize();
        }
    }

    public void fillWindow(int i, android.database.CursorWindow cursorWindow) {
        if (this.mWindow == null) {
            this.mWindow = new CursorWindow(true);
        } else {
            this.mCursorState++;
            queryThreadLock();
            try {
                this.mWindow.clear();
            } finally {
                queryThreadUnlock();
            }
        }
        this.mWindow.setStartPosition(i);
        this.mCount = this.mQuery.fillWindow(this.mWindow, this.mInitialRead, 0);
        if (this.mCount == -1) {
            this.mCount = i + this.mInitialRead;
            new Thread(new QueryThread(this.mCursorState), "query thread").start();
        }
    }
}
