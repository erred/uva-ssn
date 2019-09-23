package net.sqlcipher;

import android.util.Log;
import java.io.File;
import net.sqlcipher.database.SQLiteDatabase;

public final class DefaultDatabaseErrorHandler implements DatabaseErrorHandler {
    private static final String TAG = "DefaultDatabaseErrorHandler";

    public void onCorruption(SQLiteDatabase sQLiteDatabase) {
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("Corruption reported by sqlite on database, deleting: ");
        sb.append(sQLiteDatabase.getPath());
        Log.e(str, sb.toString());
        if (sQLiteDatabase.isOpen()) {
            Log.e(TAG, "Database object for corrupted database is already open, closing");
            try {
                sQLiteDatabase.close();
            } catch (Exception e) {
                Log.e(TAG, "Exception closing Database object for corrupted database, ignored", e);
            }
        }
        deleteDatabaseFile(sQLiteDatabase.getPath());
    }

    private void deleteDatabaseFile(String str) {
        if (!str.equalsIgnoreCase(SQLiteDatabase.MEMORY) && str.trim().length() != 0) {
            String str2 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("deleting the database file: ");
            sb.append(str);
            Log.e(str2, sb.toString());
            try {
                new File(str).delete();
            } catch (Exception e) {
                String str3 = TAG;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("delete failed: ");
                sb2.append(e.getMessage());
                Log.w(str3, sb2.toString());
            }
        }
    }
}
