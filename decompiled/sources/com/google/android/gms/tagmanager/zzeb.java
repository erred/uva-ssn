package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Collections;
import java.util.List;

@VisibleForTesting
final class zzeb implements zzcb {
    /* access modifiers changed from: private */
    public static final String zzxf = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL,'%s' INTEGER NOT NULL);", new Object[]{"gtm_hits", "hit_id", "hit_time", "hit_url", "hit_first_send_time"});
    private final zzed zzbdp;
    private volatile zzbe zzbdq;
    private final zzcc zzbdr;
    /* access modifiers changed from: private */
    public final String zzbds;
    private long zzbdt;
    private final int zzbdu;
    /* access modifiers changed from: private */
    public final Context zzri;
    /* access modifiers changed from: private */
    public Clock zzrz;

    zzeb(zzcc zzcc, Context context) {
        this(zzcc, context, "gtm_urls.db", CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE);
    }

    @VisibleForTesting
    private zzeb(zzcc zzcc, Context context, String str, int i) {
        this.zzri = context.getApplicationContext();
        this.zzbds = str;
        this.zzbdr = zzcc;
        this.zzrz = DefaultClock.getInstance();
        this.zzbdp = new zzed(this, this.zzri, this.zzbds);
        this.zzbdq = new zzfu(this.zzri, new zzec(this));
        this.zzbdt = 0;
        this.zzbdu = CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE;
    }

    public final void zzb(long j, String str) {
        long currentTimeMillis = this.zzrz.currentTimeMillis();
        if (currentTimeMillis > this.zzbdt + 86400000) {
            this.zzbdt = currentTimeMillis;
            SQLiteDatabase zzdl = zzdl("Error opening database for deleteStaleHits.");
            if (zzdl != null) {
                zzdl.delete("gtm_hits", "HIT_TIME < ?", new String[]{Long.toString(this.zzrz.currentTimeMillis() - 2592000000L)});
                this.zzbdr.zzo(zzpj() == 0);
            }
        }
        int zzpj = (zzpj() - this.zzbdu) + 1;
        if (zzpj > 0) {
            List zzab = zzab(zzpj);
            int size = zzab.size();
            StringBuilder sb = new StringBuilder(51);
            sb.append("Store full, deleting ");
            sb.append(size);
            sb.append(" hits to make room.");
            zzdi.m8601v(sb.toString());
            zza((String[]) zzab.toArray(new String[0]));
        }
        SQLiteDatabase zzdl2 = zzdl("Error opening database for putHit");
        if (zzdl2 != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("hit_time", Long.valueOf(j));
            contentValues.put("hit_url", str);
            contentValues.put("hit_first_send_time", Integer.valueOf(0));
            try {
                zzdl2.insert("gtm_hits", null, contentValues);
                this.zzbdr.zzo(false);
            } catch (SQLiteException unused) {
                zzdi.zzab("Error storing hit");
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0071 A[Catch:{ all -> 0x005e }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0076 A[Catch:{ all -> 0x005e }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0086  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<java.lang.String> zzab(int r15) {
        /*
            r14 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            if (r15 > 0) goto L_0x000d
            java.lang.String r15 = "Invalid maxHits specified. Skipping"
            com.google.android.gms.tagmanager.zzdi.zzab(r15)
            return r0
        L_0x000d:
            java.lang.String r1 = "Error opening database for peekHitIds."
            android.database.sqlite.SQLiteDatabase r2 = r14.zzdl(r1)
            if (r2 != 0) goto L_0x0016
            return r0
        L_0x0016:
            r1 = 0
            java.lang.String r3 = "gtm_hits"
            java.lang.String r4 = "hit_id"
            java.lang.String[] r4 = new java.lang.String[]{r4}     // Catch:{ SQLiteException -> 0x0060 }
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            java.lang.String r9 = "%s ASC"
            r10 = 1
            java.lang.Object[] r10 = new java.lang.Object[r10]     // Catch:{ SQLiteException -> 0x0060 }
            java.lang.String r11 = "hit_id"
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
            java.lang.String r2 = "Error in peekHits fetching hitIds: "
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzeb.zzab(int):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0142, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0143, code lost:
        r12 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0146, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0147, code lost:
        r15 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0172, code lost:
        r12.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00fd A[Catch:{ all -> 0x0137 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0102 A[Catch:{ all -> 0x0137 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0118 A[Catch:{ all -> 0x0137 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0142 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:6:0x003a] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x015d A[Catch:{ all -> 0x014a }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0162 A[Catch:{ all -> 0x014a }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0172  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<com.google.android.gms.tagmanager.zzbw> zzac(int r17) {
        /*
            r16 = this;
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.lang.String r0 = "Error opening database for peekHits"
            r2 = r16
            android.database.sqlite.SQLiteDatabase r0 = r2.zzdl(r0)
            if (r0 != 0) goto L_0x0010
            return r1
        L_0x0010:
            r12 = 0
            java.lang.String r4 = "gtm_hits"
            java.lang.String r3 = "hit_id"
            java.lang.String r5 = "hit_time"
            java.lang.String r6 = "hit_first_send_time"
            java.lang.String[] r5 = new java.lang.String[]{r3, r5, r6}     // Catch:{ SQLiteException -> 0x014c }
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            java.lang.String r3 = "%s ASC"
            r13 = 1
            java.lang.Object[] r10 = new java.lang.Object[r13]     // Catch:{ SQLiteException -> 0x014c }
            java.lang.String r11 = "hit_id"
            r14 = 0
            r10[r14] = r11     // Catch:{ SQLiteException -> 0x014c }
            java.lang.String r10 = java.lang.String.format(r3, r10)     // Catch:{ SQLiteException -> 0x014c }
            r15 = 40
            java.lang.String r11 = java.lang.Integer.toString(r15)     // Catch:{ SQLiteException -> 0x014c }
            r3 = r0
            android.database.Cursor r11 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ SQLiteException -> 0x014c }
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0146, all -> 0x0142 }
            r12.<init>()     // Catch:{ SQLiteException -> 0x0146, all -> 0x0142 }
            boolean r1 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x013e, all -> 0x0142 }
            if (r1 == 0) goto L_0x006b
        L_0x0045:
            com.google.android.gms.tagmanager.zzbw r1 = new com.google.android.gms.tagmanager.zzbw     // Catch:{ SQLiteException -> 0x0066, all -> 0x0062 }
            long r4 = r11.getLong(r14)     // Catch:{ SQLiteException -> 0x0066, all -> 0x0062 }
            long r6 = r11.getLong(r13)     // Catch:{ SQLiteException -> 0x0066, all -> 0x0062 }
            r3 = 2
            long r8 = r11.getLong(r3)     // Catch:{ SQLiteException -> 0x0066, all -> 0x0062 }
            r3 = r1
            r3.<init>(r4, r6, r8)     // Catch:{ SQLiteException -> 0x0066, all -> 0x0062 }
            r12.add(r1)     // Catch:{ SQLiteException -> 0x0066, all -> 0x0062 }
            boolean r1 = r11.moveToNext()     // Catch:{ SQLiteException -> 0x0066, all -> 0x0062 }
            if (r1 != 0) goto L_0x0045
            goto L_0x006b
        L_0x0062:
            r0 = move-exception
            r12 = r11
            goto L_0x0170
        L_0x0066:
            r0 = move-exception
            r1 = r12
            r12 = r11
            goto L_0x014d
        L_0x006b:
            if (r11 == 0) goto L_0x0070
            r11.close()
        L_0x0070:
            java.lang.String r4 = "gtm_hits"
            java.lang.String r1 = "hit_id"
            java.lang.String r3 = "hit_url"
            java.lang.String[] r5 = new java.lang.String[]{r1, r3}     // Catch:{ SQLiteException -> 0x00eb, all -> 0x00e8 }
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            java.lang.String r1 = "%s ASC"
            java.lang.Object[] r3 = new java.lang.Object[r13]     // Catch:{ SQLiteException -> 0x00eb, all -> 0x00e8 }
            java.lang.String r10 = "hit_id"
            r3[r14] = r10     // Catch:{ SQLiteException -> 0x00eb, all -> 0x00e8 }
            java.lang.String r10 = java.lang.String.format(r1, r3)     // Catch:{ SQLiteException -> 0x00eb, all -> 0x00e8 }
            java.lang.String r1 = java.lang.Integer.toString(r15)     // Catch:{ SQLiteException -> 0x00eb, all -> 0x00e8 }
            r3 = r0
            r15 = r11
            r11 = r1
            android.database.Cursor r11 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ SQLiteException -> 0x00e5, all -> 0x00e2 }
            boolean r0 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x00e0 }
            if (r0 == 0) goto L_0x00da
            r0 = 0
        L_0x009c:
            r1 = r11
            android.database.sqlite.SQLiteCursor r1 = (android.database.sqlite.SQLiteCursor) r1     // Catch:{ SQLiteException -> 0x00e0 }
            android.database.CursorWindow r1 = r1.getWindow()     // Catch:{ SQLiteException -> 0x00e0 }
            int r1 = r1.getNumRows()     // Catch:{ SQLiteException -> 0x00e0 }
            if (r1 <= 0) goto L_0x00b7
            java.lang.Object r1 = r12.get(r0)     // Catch:{ SQLiteException -> 0x00e0 }
            com.google.android.gms.tagmanager.zzbw r1 = (com.google.android.gms.tagmanager.zzbw) r1     // Catch:{ SQLiteException -> 0x00e0 }
            java.lang.String r3 = r11.getString(r13)     // Catch:{ SQLiteException -> 0x00e0 }
            r1.zzds(r3)     // Catch:{ SQLiteException -> 0x00e0 }
            goto L_0x00d2
        L_0x00b7:
            java.lang.String r1 = "HitString for hitId %d too large.  Hit will be deleted."
            java.lang.Object[] r3 = new java.lang.Object[r13]     // Catch:{ SQLiteException -> 0x00e0 }
            java.lang.Object r4 = r12.get(r0)     // Catch:{ SQLiteException -> 0x00e0 }
            com.google.android.gms.tagmanager.zzbw r4 = (com.google.android.gms.tagmanager.zzbw) r4     // Catch:{ SQLiteException -> 0x00e0 }
            long r4 = r4.zzov()     // Catch:{ SQLiteException -> 0x00e0 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ SQLiteException -> 0x00e0 }
            r3[r14] = r4     // Catch:{ SQLiteException -> 0x00e0 }
            java.lang.String r1 = java.lang.String.format(r1, r3)     // Catch:{ SQLiteException -> 0x00e0 }
            com.google.android.gms.tagmanager.zzdi.zzab(r1)     // Catch:{ SQLiteException -> 0x00e0 }
        L_0x00d2:
            int r0 = r0 + 1
            boolean r1 = r11.moveToNext()     // Catch:{ SQLiteException -> 0x00e0 }
            if (r1 != 0) goto L_0x009c
        L_0x00da:
            if (r11 == 0) goto L_0x00df
            r11.close()
        L_0x00df:
            return r12
        L_0x00e0:
            r0 = move-exception
            goto L_0x00ed
        L_0x00e2:
            r0 = move-exception
            r11 = r15
            goto L_0x0138
        L_0x00e5:
            r0 = move-exception
            r11 = r15
            goto L_0x00ed
        L_0x00e8:
            r0 = move-exception
            r15 = r11
            goto L_0x0138
        L_0x00eb:
            r0 = move-exception
            r15 = r11
        L_0x00ed:
            java.lang.String r1 = "Error in peekHits fetching hit url: "
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0137 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0137 }
            int r3 = r0.length()     // Catch:{ all -> 0x0137 }
            if (r3 == 0) goto L_0x0102
            java.lang.String r0 = r1.concat(r0)     // Catch:{ all -> 0x0137 }
            goto L_0x0107
        L_0x0102:
            java.lang.String r0 = new java.lang.String     // Catch:{ all -> 0x0137 }
            r0.<init>(r1)     // Catch:{ all -> 0x0137 }
        L_0x0107:
            com.google.android.gms.tagmanager.zzdi.zzab(r0)     // Catch:{ all -> 0x0137 }
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0137 }
            r0.<init>()     // Catch:{ all -> 0x0137 }
            java.util.ArrayList r12 = (java.util.ArrayList) r12     // Catch:{ all -> 0x0137 }
            int r1 = r12.size()     // Catch:{ all -> 0x0137 }
            r3 = 0
        L_0x0116:
            if (r14 >= r1) goto L_0x0131
            java.lang.Object r4 = r12.get(r14)     // Catch:{ all -> 0x0137 }
            int r14 = r14 + 1
            com.google.android.gms.tagmanager.zzbw r4 = (com.google.android.gms.tagmanager.zzbw) r4     // Catch:{ all -> 0x0137 }
            java.lang.String r5 = r4.zzox()     // Catch:{ all -> 0x0137 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0137 }
            if (r5 == 0) goto L_0x012d
            if (r3 != 0) goto L_0x0131
            r3 = 1
        L_0x012d:
            r0.add(r4)     // Catch:{ all -> 0x0137 }
            goto L_0x0116
        L_0x0131:
            if (r11 == 0) goto L_0x0136
            r11.close()
        L_0x0136:
            return r0
        L_0x0137:
            r0 = move-exception
        L_0x0138:
            if (r11 == 0) goto L_0x013d
            r11.close()
        L_0x013d:
            throw r0
        L_0x013e:
            r0 = move-exception
            r15 = r11
            r1 = r12
            goto L_0x0148
        L_0x0142:
            r0 = move-exception
            r15 = r11
            r12 = r15
            goto L_0x0170
        L_0x0146:
            r0 = move-exception
            r15 = r11
        L_0x0148:
            r12 = r15
            goto L_0x014d
        L_0x014a:
            r0 = move-exception
            goto L_0x0170
        L_0x014c:
            r0 = move-exception
        L_0x014d:
            java.lang.String r3 = "Error in peekHits fetching hitIds: "
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x014a }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x014a }
            int r4 = r0.length()     // Catch:{ all -> 0x014a }
            if (r4 == 0) goto L_0x0162
            java.lang.String r0 = r3.concat(r0)     // Catch:{ all -> 0x014a }
            goto L_0x0167
        L_0x0162:
            java.lang.String r0 = new java.lang.String     // Catch:{ all -> 0x014a }
            r0.<init>(r3)     // Catch:{ all -> 0x014a }
        L_0x0167:
            com.google.android.gms.tagmanager.zzdi.zzab(r0)     // Catch:{ all -> 0x014a }
            if (r12 == 0) goto L_0x016f
            r12.close()
        L_0x016f:
            return r1
        L_0x0170:
            if (r12 == 0) goto L_0x0175
            r12.close()
        L_0x0175:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzeb.zzac(int):java.util.List");
    }

    private final void zza(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            SQLiteDatabase zzdl = zzdl("Error opening database for deleteHits.");
            if (zzdl != null) {
                boolean z = true;
                try {
                    zzdl.delete("gtm_hits", String.format("HIT_ID in (%s)", new Object[]{TextUtils.join(",", Collections.nCopies(strArr.length, "?"))}), strArr);
                    zzcc zzcc = this.zzbdr;
                    if (zzpj() != 0) {
                        z = false;
                    }
                    zzcc.zzo(z);
                } catch (SQLiteException unused) {
                    zzdi.zzab("Error deleting hits");
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void zze(long j) {
        zza(new String[]{String.valueOf(j)});
    }

    /* access modifiers changed from: private */
    public final void zze(long j, long j2) {
        SQLiteDatabase zzdl = zzdl("Error opening database for getNumStoredHits.");
        if (zzdl != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("hit_first_send_time", Long.valueOf(j2));
            try {
                zzdl.update("gtm_hits", contentValues, "hit_id=?", new String[]{String.valueOf(j)});
            } catch (SQLiteException unused) {
                StringBuilder sb = new StringBuilder(69);
                sb.append("Error setting HIT_FIRST_DISPATCH_TIME for hitId: ");
                sb.append(j);
                zzdi.zzab(sb.toString());
                zze(j);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0036  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzpj() {
        /*
            r4 = this;
            java.lang.String r0 = "Error opening database for getNumStoredHits."
            android.database.sqlite.SQLiteDatabase r0 = r4.zzdl(r0)
            r1 = 0
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            r2 = 0
            java.lang.String r3 = "SELECT COUNT(*) from gtm_hits"
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
            java.lang.String r0 = "Error getting numStoredHits"
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzeb.zzpj():int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzpk() {
        /*
            r10 = this;
            java.lang.String r0 = "Error opening database for getNumStoredHits."
            android.database.sqlite.SQLiteDatabase r1 = r10.zzdl(r0)
            r0 = 0
            if (r1 != 0) goto L_0x000a
            return r0
        L_0x000a:
            r9 = 0
            java.lang.String r2 = "gtm_hits"
            java.lang.String r3 = "hit_id"
            java.lang.String r4 = "hit_first_send_time"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}     // Catch:{ SQLiteException -> 0x0031 }
            java.lang.String r4 = "hit_first_send_time=0"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x0031 }
            int r2 = r1.getCount()     // Catch:{ SQLiteException -> 0x002d, all -> 0x002a }
            if (r1 == 0) goto L_0x0028
            r1.close()
        L_0x0028:
            r0 = r2
            goto L_0x003b
        L_0x002a:
            r0 = move-exception
            r9 = r1
            goto L_0x003c
        L_0x002d:
            r9 = r1
            goto L_0x0031
        L_0x002f:
            r0 = move-exception
            goto L_0x003c
        L_0x0031:
            java.lang.String r1 = "Error getting num untried hits"
            com.google.android.gms.tagmanager.zzdi.zzab(r1)     // Catch:{ all -> 0x002f }
            if (r9 == 0) goto L_0x003b
            r9.close()
        L_0x003b:
            return r0
        L_0x003c:
            if (r9 == 0) goto L_0x0041
            r9.close()
        L_0x0041:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzeb.zzpk():int");
    }

    public final void dispatch() {
        zzdi.m8601v("GTM Dispatch running...");
        if (this.zzbdq.zzom()) {
            List zzac = zzac(40);
            if (zzac.isEmpty()) {
                zzdi.m8601v("...nothing to dispatch");
                this.zzbdr.zzo(true);
                return;
            }
            this.zzbdq.zzf(zzac);
            if (zzpk() > 0) {
                zzfn.zzqe().dispatch();
            }
        }
    }

    private final SQLiteDatabase zzdl(String str) {
        try {
            return this.zzbdp.getWritableDatabase();
        } catch (SQLiteException unused) {
            zzdi.zzab(str);
            return null;
        }
    }
}
