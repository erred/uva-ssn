package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

final class zzat implements zzc {
    /* access modifiers changed from: private */
    public static final String zzbbj = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", new Object[]{"datalayer", "ID", "key", Param.VALUE, "expires"});
    private final Executor zzbbk;
    private zzax zzbbl;
    private int zzbbm;
    /* access modifiers changed from: private */
    public final Context zzri;
    private Clock zzrz;

    public zzat(Context context) {
        this(context, DefaultClock.getInstance(), "google_tagmanager.db", CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE, Executors.newSingleThreadExecutor());
    }

    @VisibleForTesting
    private zzat(Context context, Clock clock, String str, int i, Executor executor) {
        this.zzri = context;
        this.zzrz = clock;
        this.zzbbm = CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE;
        this.zzbbk = executor;
        this.zzbbl = new zzax(this, this.zzri, str);
    }

    public final void zza(List<zza> list, long j) {
        ArrayList arrayList = new ArrayList();
        for (zza zza : list) {
            arrayList.add(new zzay(zza.mKey, zzg(zza.mValue)));
        }
        this.zzbbk.execute(new zzau(this, arrayList, j));
    }

    public final void zza(zzaq zzaq) {
        this.zzbbk.execute(new zzav(this, zzaq));
    }

    public final void zzdj(String str) {
        this.zzbbk.execute(new zzaw(this, str));
    }

    /* access modifiers changed from: private */
    public final List<zza> zzoh() {
        try {
            zzap(this.zzrz.currentTimeMillis());
            List<zzay> zzoi = zzoi();
            ArrayList arrayList = new ArrayList();
            for (zzay zzay : zzoi) {
                arrayList.add(new zza(zzay.zzoj, zzd(zzay.zzbbs)));
            }
            return arrayList;
        } finally {
            zzok();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x001e A[SYNTHETIC, Splitter:B:13:0x001e] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0028 A[SYNTHETIC, Splitter:B:22:0x0028] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0032 A[SYNTHETIC, Splitter:B:31:0x0032] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Object zzd(byte[] r4) {
        /*
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream
            r0.<init>(r4)
            r4 = 0
            java.io.ObjectInputStream r1 = new java.io.ObjectInputStream     // Catch:{ IOException -> 0x002f, ClassNotFoundException -> 0x0025, all -> 0x001b }
            r1.<init>(r0)     // Catch:{ IOException -> 0x002f, ClassNotFoundException -> 0x0025, all -> 0x001b }
            java.lang.Object r2 = r1.readObject()     // Catch:{ IOException -> 0x0030, ClassNotFoundException -> 0x0026, all -> 0x0016 }
            r1.close()     // Catch:{ IOException -> 0x0015 }
            r0.close()     // Catch:{ IOException -> 0x0015 }
        L_0x0015:
            return r2
        L_0x0016:
            r4 = move-exception
            r3 = r1
            r1 = r4
            r4 = r3
            goto L_0x001c
        L_0x001b:
            r1 = move-exception
        L_0x001c:
            if (r4 == 0) goto L_0x0021
            r4.close()     // Catch:{ IOException -> 0x0024 }
        L_0x0021:
            r0.close()     // Catch:{ IOException -> 0x0024 }
        L_0x0024:
            throw r1
        L_0x0025:
            r1 = r4
        L_0x0026:
            if (r1 == 0) goto L_0x002b
            r1.close()     // Catch:{ IOException -> 0x002e }
        L_0x002b:
            r0.close()     // Catch:{ IOException -> 0x002e }
        L_0x002e:
            return r4
        L_0x002f:
            r1 = r4
        L_0x0030:
            if (r1 == 0) goto L_0x0035
            r1.close()     // Catch:{ IOException -> 0x0038 }
        L_0x0035:
            r0.close()     // Catch:{ IOException -> 0x0038 }
        L_0x0038:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzat.zzd(byte[]):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x001f A[SYNTHETIC, Splitter:B:13:0x001f] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0029 A[SYNTHETIC, Splitter:B:22:0x0029] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] zzg(java.lang.Object r3) {
        /*
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 0
            java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x0026, all -> 0x001c }
            r2.<init>(r0)     // Catch:{ IOException -> 0x0026, all -> 0x001c }
            r2.writeObject(r3)     // Catch:{ IOException -> 0x0027, all -> 0x0019 }
            byte[] r3 = r0.toByteArray()     // Catch:{ IOException -> 0x0027, all -> 0x0019 }
            r2.close()     // Catch:{ IOException -> 0x0018 }
            r0.close()     // Catch:{ IOException -> 0x0018 }
        L_0x0018:
            return r3
        L_0x0019:
            r3 = move-exception
            r1 = r2
            goto L_0x001d
        L_0x001c:
            r3 = move-exception
        L_0x001d:
            if (r1 == 0) goto L_0x0022
            r1.close()     // Catch:{ IOException -> 0x0025 }
        L_0x0022:
            r0.close()     // Catch:{ IOException -> 0x0025 }
        L_0x0025:
            throw r3
        L_0x0026:
            r2 = r1
        L_0x0027:
            if (r2 == 0) goto L_0x002c
            r2.close()     // Catch:{ IOException -> 0x002f }
        L_0x002c:
            r0.close()     // Catch:{ IOException -> 0x002f }
        L_0x002f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzat.zzg(java.lang.Object):byte[]");
    }

    /* access modifiers changed from: private */
    public final synchronized void zzb(List<zzay> list, long j) {
        long currentTimeMillis;
        String[] strArr;
        try {
            currentTimeMillis = this.zzrz.currentTimeMillis();
            zzap(currentTimeMillis);
            int zzoj = (zzoj() - this.zzbbm) + list.size();
            if (zzoj > 0) {
                List zzw = zzw(zzoj);
                int size = zzw.size();
                StringBuilder sb = new StringBuilder(64);
                sb.append("DataLayer store full, deleting ");
                sb.append(size);
                sb.append(" entries to make room.");
                zzdi.zzdm(sb.toString());
                strArr = (String[]) zzw.toArray(new String[0]);
                if (strArr != null) {
                    if (strArr.length != 0) {
                        SQLiteDatabase zzdl = zzdl("Error opening database for deleteEntries.");
                        if (zzdl != null) {
                            zzdl.delete("datalayer", String.format("%s in (%s)", new Object[]{"ID", TextUtils.join(",", Collections.nCopies(strArr.length, "?"))}), strArr);
                        }
                    }
                }
            }
        } catch (SQLiteException unused) {
            String str = "Error deleting entries ";
            String valueOf = String.valueOf(Arrays.toString(strArr));
            zzdi.zzab(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        } catch (Throwable th) {
            zzok();
            throw th;
        }
        long j2 = currentTimeMillis + j;
        SQLiteDatabase zzdl2 = zzdl("Error opening database for writeEntryToDatabase.");
        if (zzdl2 != null) {
            for (zzay zzay : list) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("expires", Long.valueOf(j2));
                contentValues.put("key", zzay.zzoj);
                contentValues.put(Param.VALUE, zzay.zzbbs);
                zzdl2.insert("datalayer", null, contentValues);
            }
        }
        zzok();
    }

    private final List<zzay> zzoi() {
        SQLiteDatabase zzdl = zzdl("Error opening database for loadSerialized.");
        ArrayList arrayList = new ArrayList();
        if (zzdl == null) {
            return arrayList;
        }
        Cursor query = zzdl.query("datalayer", new String[]{"key", Param.VALUE}, null, null, null, null, "ID", null);
        while (query.moveToNext()) {
            try {
                arrayList.add(new zzay(query.getString(0), query.getBlob(1)));
            } finally {
                query.close();
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public final void zzdk(String str) {
        SQLiteDatabase zzdl = zzdl("Error opening database for clearKeysWithPrefix.");
        if (zzdl != null) {
            try {
                int delete = zzdl.delete("datalayer", "key = ? OR key LIKE ?", new String[]{str, String.valueOf(str).concat(".%")});
                StringBuilder sb = new StringBuilder(25);
                sb.append("Cleared ");
                sb.append(delete);
                sb.append(" items");
                zzdi.m8601v(sb.toString());
            } catch (SQLiteException e) {
                String valueOf = String.valueOf(e);
                StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 44 + String.valueOf(valueOf).length());
                sb2.append("Error deleting entries with key prefix: ");
                sb2.append(str);
                sb2.append(" (");
                sb2.append(valueOf);
                sb2.append(").");
                zzdi.zzab(sb2.toString());
            } finally {
                zzok();
            }
        }
    }

    private final void zzap(long j) {
        SQLiteDatabase zzdl = zzdl("Error opening database for deleteOlderThan.");
        if (zzdl != null) {
            try {
                int delete = zzdl.delete("datalayer", "expires <= ?", new String[]{Long.toString(j)});
                StringBuilder sb = new StringBuilder(33);
                sb.append("Deleted ");
                sb.append(delete);
                sb.append(" expired items");
                zzdi.m8601v(sb.toString());
            } catch (SQLiteException unused) {
                zzdi.zzab("Error deleting old entries.");
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0071 A[Catch:{ all -> 0x005e }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0076 A[Catch:{ all -> 0x005e }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0086  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<java.lang.String> zzw(int r15) {
        /*
            r14 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            if (r15 > 0) goto L_0x000d
            java.lang.String r15 = "Invalid maxEntries specified. Skipping."
            com.google.android.gms.tagmanager.zzdi.zzab(r15)
            return r0
        L_0x000d:
            java.lang.String r1 = "Error opening database for peekEntryIds."
            android.database.sqlite.SQLiteDatabase r2 = r14.zzdl(r1)
            if (r2 != 0) goto L_0x0016
            return r0
        L_0x0016:
            r1 = 0
            java.lang.String r3 = "datalayer"
            java.lang.String r4 = "ID"
            java.lang.String[] r4 = new java.lang.String[]{r4}     // Catch:{ SQLiteException -> 0x0060 }
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            java.lang.String r9 = "%s ASC"
            r10 = 1
            java.lang.Object[] r10 = new java.lang.Object[r10]     // Catch:{ SQLiteException -> 0x0060 }
            java.lang.String r11 = "ID"
            r12 = 0
            r10[r12] = r11     // Catch:{ SQLiteException -> 0x0060 }
            java.lang.String r9 = java.lang.String.format(r9, r10)     // Catch:{ SQLiteException -> 0x0060 }
            java.lang.String r10 = java.lang.Integer.toString(r15)     // Catch:{ SQLiteException -> 0x0060 }
            android.database.Cursor r15 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x0060 }
            boolean r1 = r15.moveToFirst()     // Catch:{ SQLiteException -> 0x0059, all -> 0x0056 }
            if (r1 == 0) goto L_0x0050
        L_0x003f:
            long r1 = r15.getLong(r12)     // Catch:{ SQLiteException -> 0x0059, all -> 0x0056 }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ SQLiteException -> 0x0059, all -> 0x0056 }
            r0.add(r1)     // Catch:{ SQLiteException -> 0x0059, all -> 0x0056 }
            boolean r1 = r15.moveToNext()     // Catch:{ SQLiteException -> 0x0059, all -> 0x0056 }
            if (r1 != 0) goto L_0x003f
        L_0x0050:
            if (r15 == 0) goto L_0x0083
            r15.close()
            goto L_0x0083
        L_0x0056:
            r0 = move-exception
            r1 = r15
            goto L_0x0084
        L_0x0059:
            r1 = move-exception
            r13 = r1
            r1 = r15
            r15 = r13
            goto L_0x0061
        L_0x005e:
            r0 = move-exception
            goto L_0x0084
        L_0x0060:
            r15 = move-exception
        L_0x0061:
            java.lang.String r2 = "Error in peekEntries fetching entryIds: "
            java.lang.String r15 = r15.getMessage()     // Catch:{ all -> 0x005e }
            java.lang.String r15 = java.lang.String.valueOf(r15)     // Catch:{ all -> 0x005e }
            int r3 = r15.length()     // Catch:{ all -> 0x005e }
            if (r3 == 0) goto L_0x0076
            java.lang.String r15 = r2.concat(r15)     // Catch:{ all -> 0x005e }
            goto L_0x007b
        L_0x0076:
            java.lang.String r15 = new java.lang.String     // Catch:{ all -> 0x005e }
            r15.<init>(r2)     // Catch:{ all -> 0x005e }
        L_0x007b:
            com.google.android.gms.tagmanager.zzdi.zzab(r15)     // Catch:{ all -> 0x005e }
            if (r1 == 0) goto L_0x0083
            r1.close()
        L_0x0083:
            return r0
        L_0x0084:
            if (r1 == 0) goto L_0x0089
            r1.close()
        L_0x0089:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzat.zzw(int):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0036  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzoj() {
        /*
            r4 = this;
            java.lang.String r0 = "Error opening database for getNumStoredEntries."
            android.database.sqlite.SQLiteDatabase r0 = r4.zzdl(r0)
            r1 = 0
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            r2 = 0
            java.lang.String r3 = "SELECT COUNT(*) from datalayer"
            android.database.Cursor r0 = r0.rawQuery(r3, r2)     // Catch:{ SQLiteException -> 0x0029 }
            boolean r2 = r0.moveToFirst()     // Catch:{ SQLiteException -> 0x0025, all -> 0x0022 }
            if (r2 == 0) goto L_0x001c
            long r2 = r0.getLong(r1)     // Catch:{ SQLiteException -> 0x0025, all -> 0x0022 }
            int r1 = (int) r2
        L_0x001c:
            if (r0 == 0) goto L_0x0033
            r0.close()
            goto L_0x0033
        L_0x0022:
            r1 = move-exception
            r2 = r0
            goto L_0x0034
        L_0x0025:
            r2 = r0
            goto L_0x0029
        L_0x0027:
            r1 = move-exception
            goto L_0x0034
        L_0x0029:
            java.lang.String r0 = "Error getting numStoredEntries"
            com.google.android.gms.tagmanager.zzdi.zzab(r0)     // Catch:{ all -> 0x0027 }
            if (r2 == 0) goto L_0x0033
            r2.close()
        L_0x0033:
            return r1
        L_0x0034:
            if (r2 == 0) goto L_0x0039
            r2.close()
        L_0x0039:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzat.zzoj():int");
    }

    private final SQLiteDatabase zzdl(String str) {
        try {
            return this.zzbbl.getWritableDatabase();
        } catch (SQLiteException unused) {
            zzdi.zzab(str);
            return null;
        }
    }

    private final void zzok() {
        try {
            this.zzbbl.close();
        } catch (SQLiteException unused) {
        }
    }
}
