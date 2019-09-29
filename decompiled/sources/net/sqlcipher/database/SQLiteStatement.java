package net.sqlcipher.database;

import android.os.SystemClock;

public class SQLiteStatement extends SQLiteProgram {
    private final native long native_1x1_long();

    private final native String native_1x1_string();

    private final native void native_execute();

    SQLiteStatement(SQLiteDatabase sQLiteDatabase, String str) {
        super(sQLiteDatabase, str);
    }

    public void execute() {
        if (this.mDatabase.isOpen()) {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.mDatabase.lock();
            acquireReference();
            try {
                native_execute();
                this.mDatabase.logTimeStat(this.mSql, uptimeMillis);
            } finally {
                releaseReference();
                this.mDatabase.unlock();
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("database ");
            sb.append(this.mDatabase.getPath());
            sb.append(" already closed");
            throw new IllegalStateException(sb.toString());
        }
    }

    public long executeInsert() {
        if (this.mDatabase.isOpen()) {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.mDatabase.lock();
            acquireReference();
            try {
                native_execute();
                this.mDatabase.logTimeStat(this.mSql, uptimeMillis);
                return this.mDatabase.lastChangeCount() > 0 ? this.mDatabase.lastInsertRow() : -1;
            } finally {
                releaseReference();
                this.mDatabase.unlock();
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("database ");
            sb.append(this.mDatabase.getPath());
            sb.append(" already closed");
            throw new IllegalStateException(sb.toString());
        }
    }

    public int executeUpdateDelete() {
        if (this.mDatabase.isOpen()) {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.mDatabase.lock();
            acquireReference();
            try {
                native_execute();
                this.mDatabase.logTimeStat(this.mSql, uptimeMillis);
                return this.mDatabase.lastChangeCount();
            } finally {
                releaseReference();
                this.mDatabase.unlock();
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("database ");
            sb.append(this.mDatabase.getPath());
            sb.append(" already closed");
            throw new IllegalStateException(sb.toString());
        }
    }

    public long simpleQueryForLong() {
        if (this.mDatabase.isOpen()) {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.mDatabase.lock();
            acquireReference();
            try {
                long native_1x1_long = native_1x1_long();
                this.mDatabase.logTimeStat(this.mSql, uptimeMillis);
                return native_1x1_long;
            } finally {
                releaseReference();
                this.mDatabase.unlock();
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("database ");
            sb.append(this.mDatabase.getPath());
            sb.append(" already closed");
            throw new IllegalStateException(sb.toString());
        }
    }

    public String simpleQueryForString() {
        if (this.mDatabase.isOpen()) {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.mDatabase.lock();
            acquireReference();
            try {
                String native_1x1_string = native_1x1_string();
                this.mDatabase.logTimeStat(this.mSql, uptimeMillis);
                return native_1x1_string;
            } finally {
                releaseReference();
                this.mDatabase.unlock();
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("database ");
            sb.append(this.mDatabase.getPath());
            sb.append(" already closed");
            throw new IllegalStateException(sb.toString());
        }
    }
}
