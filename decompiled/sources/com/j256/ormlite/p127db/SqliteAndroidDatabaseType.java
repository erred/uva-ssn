package com.j256.ormlite.p127db;

import com.j256.ormlite.android.DatabaseTableConfigUtil;
import com.j256.ormlite.field.DataPersister;
import com.j256.ormlite.field.FieldConverter;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.field.types.DateStringType;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.sql.SQLException;

/* renamed from: com.j256.ormlite.db.SqliteAndroidDatabaseType */
public class SqliteAndroidDatabaseType extends BaseSqliteDatabaseType implements DatabaseType {

    /* renamed from: com.j256.ormlite.db.SqliteAndroidDatabaseType$1 */
    static /* synthetic */ class C29481 {
        static final /* synthetic */ int[] $SwitchMap$com$j256$ormlite$field$SqlType = new int[SqlType.values().length];

        static {
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.DATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public String getDatabaseName() {
        return "Android SQLite";
    }

    /* access modifiers changed from: protected */
    public String getDriverClassName() {
        return null;
    }

    public boolean isBatchUseTransaction() {
        return true;
    }

    public boolean isDatabaseUrlThisType(String str, String str2) {
        return true;
    }

    public boolean isNestedSavePointsSupported() {
        return false;
    }

    public void loadDriver() {
    }

    /* access modifiers changed from: protected */
    public void appendDateType(StringBuilder sb, FieldType fieldType, int i) {
        appendStringType(sb, fieldType, i);
    }

    /* access modifiers changed from: protected */
    public void appendBooleanType(StringBuilder sb, FieldType fieldType, int i) {
        appendShortType(sb, fieldType, i);
    }

    public FieldConverter getFieldConverter(DataPersister dataPersister) {
        if (C29481.$SwitchMap$com$j256$ormlite$field$SqlType[dataPersister.getSqlType().ordinal()] != 1) {
            return super.getFieldConverter(dataPersister);
        }
        return DateStringType.getSingleton();
    }

    public <T> DatabaseTableConfig<T> extractDatabaseTableConfig(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        return DatabaseTableConfigUtil.fromClass(connectionSource, cls);
    }
}
