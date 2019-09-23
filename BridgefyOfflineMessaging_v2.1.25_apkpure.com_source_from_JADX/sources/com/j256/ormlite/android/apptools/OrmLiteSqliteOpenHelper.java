package com.j256.ormlite.android.apptools;

import android.content.Context;
import com.j256.ormlite.android.AndroidConnectionSource;
import com.j256.ormlite.android.AndroidDatabaseConnection;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.DatabaseTableConfigLoader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteDatabase.CursorFactory;
import net.sqlcipher.database.SQLiteOpenHelper;

public abstract class OrmLiteSqliteOpenHelper extends SQLiteOpenHelper {
    protected static Logger logger = LoggerFactory.getLogger(OrmLiteSqliteOpenHelper.class);
    protected AndroidConnectionSource connectionSource;
    private volatile boolean isOpen;
    private String password;

    public abstract void onCreate(SQLiteDatabase sQLiteDatabase, ConnectionSource connectionSource2);

    public abstract void onUpgrade(SQLiteDatabase sQLiteDatabase, ConnectionSource connectionSource2, int i, int i2);

    public OrmLiteSqliteOpenHelper(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
        this.connectionSource = new AndroidConnectionSource((SQLiteOpenHelper) this);
        this.isOpen = true;
        logger.trace("{}: constructed connectionSource {}", (Object) this, (Object) this.connectionSource);
    }

    public OrmLiteSqliteOpenHelper(Context context, String str, CursorFactory cursorFactory, int i, String str2) {
        this(context, str, cursorFactory, i);
        this.password = str2;
    }

    public OrmLiteSqliteOpenHelper(Context context, String str, CursorFactory cursorFactory, int i, int i2, String str2) {
        this(context, str, cursorFactory, i, openFileId(context, i2), str2);
    }

    public OrmLiteSqliteOpenHelper(Context context, String str, CursorFactory cursorFactory, int i, File file, String str2) {
        this(context, str, cursorFactory, i, openFile(file), str2);
    }

    public OrmLiteSqliteOpenHelper(Context context, String str, CursorFactory cursorFactory, int i, InputStream inputStream, String str2) {
        super(context, str, cursorFactory, i);
        this.connectionSource = new AndroidConnectionSource((SQLiteOpenHelper) this);
        this.isOpen = true;
        this.password = str2;
        if (inputStream != null) {
            try {
                DaoManager.addCachedDatabaseConfigs(DatabaseTableConfigLoader.loadDatabaseConfigFromReader(new BufferedReader(new InputStreamReader(inputStream), 4096)));
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
            } catch (SQLException e) {
                throw new IllegalStateException("Could not load object config file", e);
            } catch (Throwable th) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
                throw th;
            }
        }
    }

    public ConnectionSource getConnectionSource() {
        if (!this.isOpen) {
            logger.warn((Throwable) new IllegalStateException(), "Getting connectionSource was called after closed");
        }
        return this.connectionSource;
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        ConnectionSource connectionSource2 = getConnectionSource();
        DatabaseConnection specialConnection = connectionSource2.getSpecialConnection();
        boolean z = true;
        if (specialConnection == null) {
            specialConnection = new AndroidDatabaseConnection(sQLiteDatabase, z);
            try {
                connectionSource2.saveSpecialConnection(specialConnection);
            } catch (SQLException e) {
                throw new IllegalStateException("Could not save special connection", e);
            }
        } else {
            z = false;
        }
        try {
            onCreate(sQLiteDatabase, connectionSource2);
        } finally {
            if (z) {
                connectionSource2.clearSpecialConnection(specialConnection);
            }
        }
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        ConnectionSource connectionSource2 = getConnectionSource();
        DatabaseConnection specialConnection = connectionSource2.getSpecialConnection();
        boolean z = true;
        if (specialConnection == null) {
            specialConnection = new AndroidDatabaseConnection(sQLiteDatabase, z);
            try {
                connectionSource2.saveSpecialConnection(specialConnection);
            } catch (SQLException e) {
                throw new IllegalStateException("Could not save special connection", e);
            }
        } else {
            z = false;
        }
        try {
            onUpgrade(sQLiteDatabase, connectionSource2, i, i2);
        } finally {
            if (z) {
                connectionSource2.clearSpecialConnection(specialConnection);
            }
        }
    }

    public void close() {
        super.close();
        this.connectionSource.close();
        this.isOpen = false;
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    public <D extends Dao<T, ?>, T> D getDao(Class<T> cls) throws SQLException {
        return DaoManager.createDao(getConnectionSource(), cls);
    }

    public <D extends RuntimeExceptionDao<T, ?>, T> D getRuntimeExceptionDao(Class<T> cls) {
        try {
            return new RuntimeExceptionDao(getDao(cls));
        } catch (SQLException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not create RuntimeExcepitionDao for class ");
            sb.append(cls);
            throw new RuntimeException(sb.toString(), e);
        }
    }

    public String getPassword() {
        return this.password;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("@");
        sb.append(Integer.toHexString(super.hashCode()));
        return sb.toString();
    }

    private static InputStream openFileId(Context context, int i) {
        InputStream openRawResource = context.getResources().openRawResource(i);
        if (openRawResource != null) {
            return openRawResource;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Could not find object config file with id ");
        sb.append(i);
        throw new IllegalStateException(sb.toString());
    }

    private static InputStream openFile(File file) {
        if (file == null) {
            return null;
        }
        try {
            return new FileInputStream(file);
        } catch (FileNotFoundException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not open config file ");
            sb.append(file);
            throw new IllegalArgumentException(sb.toString(), e);
        }
    }
}
