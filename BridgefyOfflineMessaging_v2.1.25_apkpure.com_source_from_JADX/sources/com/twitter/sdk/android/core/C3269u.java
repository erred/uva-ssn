package com.twitter.sdk.android.core;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import java.io.File;

/* renamed from: com.twitter.sdk.android.core.u */
/* compiled from: TwitterContext */
class C3269u extends ContextWrapper {

    /* renamed from: a */
    private final String f8564a;

    /* renamed from: b */
    private final String f8565b;

    public C3269u(Context context, String str, String str2) {
        super(context);
        this.f8565b = str;
        this.f8564a = str2;
    }

    public File getDatabasePath(String str) {
        File file = new File(super.getDatabasePath(str).getParentFile(), this.f8564a);
        file.mkdirs();
        return new File(file, str);
    }

    public SQLiteDatabase openOrCreateDatabase(String str, int i, CursorFactory cursorFactory) {
        return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(str), cursorFactory);
    }

    public SQLiteDatabase openOrCreateDatabase(String str, int i, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(str).getPath(), cursorFactory, databaseErrorHandler);
    }

    public File getFilesDir() {
        return new File(super.getFilesDir(), this.f8564a);
    }

    public File getExternalFilesDir(String str) {
        return new File(super.getExternalFilesDir(str), this.f8564a);
    }

    public File getCacheDir() {
        return new File(super.getCacheDir(), this.f8564a);
    }

    public File getExternalCacheDir() {
        return new File(super.getExternalCacheDir(), this.f8564a);
    }

    public SharedPreferences getSharedPreferences(String str, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f8565b);
        sb.append(":");
        sb.append(str);
        return super.getSharedPreferences(sb.toString(), i);
    }
}
