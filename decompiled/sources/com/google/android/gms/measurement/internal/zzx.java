package com.google.android.gms.measurement.internal;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class zzx {
    private static Set<String> zzb(SQLiteDatabase sQLiteDatabase, String str) {
        HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 22);
        sb.append("SELECT * FROM ");
        sb.append(str);
        sb.append(" LIMIT 0");
        Cursor rawQuery = sQLiteDatabase.rawQuery(sb.toString(), null);
        try {
            Collections.addAll(hashSet, rawQuery.getColumnNames());
            return hashSet;
        } finally {
            rawQuery.close();
        }
    }

    static void zza(zzas zzas, SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, String[] strArr) throws SQLiteException {
        if (zzas != null) {
            if (!zza(zzas, sQLiteDatabase, str)) {
                sQLiteDatabase.execSQL(str2);
            }
            if (zzas != null) {
                try {
                    Set zzb = zzb(sQLiteDatabase, str);
                    String[] split = str3.split(",");
                    int length = split.length;
                    int i = 0;
                    while (i < length) {
                        String str4 = split[i];
                        if (zzb.remove(str4)) {
                            i++;
                        } else {
                            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 35 + String.valueOf(str4).length());
                            sb.append("Table ");
                            sb.append(str);
                            sb.append(" is missing required column: ");
                            sb.append(str4);
                            throw new SQLiteException(sb.toString());
                        }
                    }
                    if (strArr != null) {
                        for (int i2 = 0; i2 < strArr.length; i2 += 2) {
                            if (!zzb.remove(strArr[i2])) {
                                sQLiteDatabase.execSQL(strArr[i2 + 1]);
                            }
                        }
                    }
                    if (!zzb.isEmpty()) {
                        zzas.zzjj().zze("Table has extra columns. table, columns", str, TextUtils.join(", ", zzb));
                    }
                } catch (SQLiteException e) {
                    zzas.zzjg().zzg("Failed to verify columns on table that was just created", str);
                    throw e;
                }
            } else {
                throw new IllegalArgumentException("Monitor must not be null");
            }
        } else {
            throw new IllegalArgumentException("Monitor must not be null");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0041  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean zza(com.google.android.gms.measurement.internal.zzas r11, android.database.sqlite.SQLiteDatabase r12, java.lang.String r13) {
        /*
            if (r11 == 0) goto L_0x0045
            r0 = 0
            r1 = 0
            java.lang.String r3 = "SQLITE_MASTER"
            java.lang.String r2 = "name"
            java.lang.String[] r4 = new java.lang.String[]{r2}     // Catch:{ SQLiteException -> 0x002f }
            java.lang.String r5 = "name=?"
            r2 = 1
            java.lang.String[] r6 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x002f }
            r6[r1] = r13     // Catch:{ SQLiteException -> 0x002f }
            r7 = 0
            r8 = 0
            r9 = 0
            r2 = r12
            android.database.Cursor r12 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ SQLiteException -> 0x002f }
            boolean r0 = r12.moveToFirst()     // Catch:{ SQLiteException -> 0x0028, all -> 0x0025 }
            if (r12 == 0) goto L_0x0024
            r12.close()
        L_0x0024:
            return r0
        L_0x0025:
            r11 = move-exception
            r0 = r12
            goto L_0x003f
        L_0x0028:
            r0 = move-exception
            r10 = r0
            r0 = r12
            r12 = r10
            goto L_0x0030
        L_0x002d:
            r11 = move-exception
            goto L_0x003f
        L_0x002f:
            r12 = move-exception
        L_0x0030:
            com.google.android.gms.measurement.internal.zzau r11 = r11.zzjj()     // Catch:{ all -> 0x002d }
            java.lang.String r2 = "Error querying for table"
            r11.zze(r2, r13, r12)     // Catch:{ all -> 0x002d }
            if (r0 == 0) goto L_0x003e
            r0.close()
        L_0x003e:
            return r1
        L_0x003f:
            if (r0 == 0) goto L_0x0044
            r0.close()
        L_0x0044:
            throw r11
        L_0x0045:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.String r12 = "Monitor must not be null"
            r11.<init>(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzx.zza(com.google.android.gms.measurement.internal.zzas, android.database.sqlite.SQLiteDatabase, java.lang.String):boolean");
    }

    static void zza(zzas zzas, SQLiteDatabase sQLiteDatabase) {
        if (zzas != null) {
            File file = new File(sQLiteDatabase.getPath());
            if (!file.setReadable(false, false)) {
                zzas.zzjj().zzby("Failed to turn off database read permission");
            }
            if (!file.setWritable(false, false)) {
                zzas.zzjj().zzby("Failed to turn off database write permission");
            }
            if (!file.setReadable(true, true)) {
                zzas.zzjj().zzby("Failed to turn on database read permission for owner");
            }
            if (!file.setWritable(true, true)) {
                zzas.zzjj().zzby("Failed to turn on database write permission for owner");
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Monitor must not be null");
    }
}
