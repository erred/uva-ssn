package com.j256.ormlite.android;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.p127db.DatabaseType;
import com.j256.ormlite.p127db.SqliteAndroidDatabaseType;
import com.j256.ormlite.support.BaseConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import java.sql.SQLException;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteOpenHelper;

public class AndroidConnectionSource extends BaseConnectionSource implements ConnectionSource {
    private static final Logger logger = LoggerFactory.getLogger(AndroidConnectionSource.class);
    private AndroidDatabaseConnection connection;
    private final DatabaseType databaseType;
    private final SQLiteOpenHelper helper;
    private volatile boolean isOpen;
    private final SQLiteDatabase sqliteDatabase;

    public void releaseConnection(DatabaseConnection databaseConnection) {
    }

    public AndroidConnectionSource(SQLiteOpenHelper sQLiteOpenHelper) {
        this.connection = null;
        this.isOpen = true;
        this.databaseType = new SqliteAndroidDatabaseType();
        this.helper = sQLiteOpenHelper;
        this.sqliteDatabase = null;
    }

    public AndroidConnectionSource(SQLiteDatabase sQLiteDatabase) {
        this.connection = null;
        this.isOpen = true;
        this.databaseType = new SqliteAndroidDatabaseType();
        this.helper = null;
        this.sqliteDatabase = sQLiteDatabase;
    }

    public DatabaseConnection getReadOnlyConnection() throws SQLException {
        return getReadWriteConnection();
    }

    public DatabaseConnection getReadWriteConnection() throws SQLException {
        SQLiteDatabase sQLiteDatabase;
        DatabaseConnection savedConnection = getSavedConnection();
        if (savedConnection != null) {
            return savedConnection;
        }
        if (this.connection == null) {
            if (this.sqliteDatabase == null) {
                try {
                    if (this.helper instanceof OrmLiteSqliteOpenHelper) {
                        sQLiteDatabase = this.helper.getWritableDatabase(((OrmLiteSqliteOpenHelper) this.helper).getPassword());
                    } else {
                        throw new IllegalStateException("SQLiteOpenHelper must be an instance of OrmLiteSqliteOpenHelper");
                    }
                } catch (android.database.SQLException e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Getting a writable database from helper ");
                    sb.append(this.helper);
                    sb.append(" failed");
                    throw SqlExceptionUtil.create(sb.toString(), e);
                }
            } else {
                sQLiteDatabase = this.sqliteDatabase;
            }
            this.connection = new AndroidDatabaseConnection(sQLiteDatabase, true);
            logger.trace("created connection {} for db {}, helper {}", (Object) this.connection, (Object) sQLiteDatabase, (Object) this.helper);
        } else {
            logger.trace("{}: returning read-write connection {}, helper {}", (Object) this, (Object) this.connection, (Object) this.helper);
        }
        return this.connection;
    }

    public boolean saveSpecialConnection(DatabaseConnection databaseConnection) throws SQLException {
        return saveSpecial(databaseConnection);
    }

    public void clearSpecialConnection(DatabaseConnection databaseConnection) {
        clearSpecial(databaseConnection, logger);
    }

    public void close() {
        this.isOpen = false;
    }

    public void closeQuietly() {
        close();
    }

    public DatabaseType getDatabaseType() {
        return this.databaseType;
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("@");
        sb.append(Integer.toHexString(super.hashCode()));
        return sb.toString();
    }
}
