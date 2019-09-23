package com.google.android.gms.internal.measurement;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.analytics.zzk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.HttpUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.Closeable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

final class zzbf extends zzau implements Closeable {
    /* access modifiers changed from: private */
    public static final String zzxf = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", new Object[]{"hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id"});
    private static final String zzxg = String.format("SELECT MAX(%s) FROM %s WHERE 1;", new Object[]{"hit_time", "hits2"});
    private final zzbg zzxh;
    private final zzdc zzxi = new zzdc(zzbx());
    /* access modifiers changed from: private */
    public final zzdc zzxj = new zzdc(zzbx());

    zzbf(zzaw zzaw) {
        super(zzaw);
        this.zzxh = new zzbg(this, zzaw.getContext(), "google_analytics_v4.db");
    }

    /* access modifiers changed from: private */
    public static String zzdd() {
        return "google_analytics_v4.db";
    }

    /* access modifiers changed from: protected */
    public final void zzag() {
    }

    public final void beginTransaction() {
        zzcl();
        getWritableDatabase().beginTransaction();
    }

    public final void setTransactionSuccessful() {
        zzcl();
        getWritableDatabase().setTransactionSuccessful();
    }

    public final void endTransaction() {
        zzcl();
        getWritableDatabase().endTransaction();
    }

    public final void zzc(zzck zzck) {
        String str;
        Preconditions.checkNotNull(zzck);
        zzk.zzaf();
        zzcl();
        Preconditions.checkNotNull(zzck);
        Builder builder = new Builder();
        for (Entry entry : zzck.zzcw().entrySet()) {
            String str2 = (String) entry.getKey();
            if (!"ht".equals(str2) && !"qt".equals(str2) && !"AppUID".equals(str2)) {
                builder.appendQueryParameter(str2, (String) entry.getValue());
            }
        }
        String encodedQuery = builder.build().getEncodedQuery();
        if (encodedQuery == null) {
            encodedQuery = "";
        }
        if (encodedQuery.length() > 8192) {
            zzby().zza(zzck, "Hit length exceeds the maximum allowed size");
            return;
        }
        int intValue = ((Integer) zzcf.zzza.get()).intValue();
        long zzcv = zzcv();
        if (zzcv > ((long) (intValue - 1))) {
            List zzc = zzc((zzcv - ((long) intValue)) + 1);
            zzd("Store full, deleting hits to make room, count", Integer.valueOf(zzc.size()));
            zza(zzc);
        }
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("hit_string", encodedQuery);
        contentValues.put("hit_time", Long.valueOf(zzck.zzer()));
        contentValues.put("hit_app_id", Integer.valueOf(zzck.zzep()));
        String str3 = "hit_url";
        if (zzck.zzet()) {
            str = zzbx.zzed();
        } else {
            str = zzbx.zzee();
        }
        contentValues.put(str3, str);
        try {
            long insert = writableDatabase.insert("hits2", null, contentValues);
            if (insert == -1) {
                zzu("Failed to insert a hit (got -1)");
            } else {
                zzb("Hit saved to database. db-id, hit", Long.valueOf(insert), zzck);
            }
        } catch (SQLiteException e) {
            zze("Error storing a hit", e);
        }
    }

    private final long zzcv() {
        zzk.zzaf();
        zzcl();
        return zza("SELECT COUNT(*) FROM hits2", null);
    }

    /* access modifiers changed from: 0000 */
    public final boolean isEmpty() {
        return zzcv() == 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0070  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<java.lang.Long> zzc(long r14) {
        /*
            r13 = this;
            com.google.android.gms.analytics.zzk.zzaf()
            r13.zzcl()
            r0 = 0
            int r0 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r0 > 0) goto L_0x0011
            java.util.List r14 = java.util.Collections.emptyList()
            return r14
        L_0x0011:
            android.database.sqlite.SQLiteDatabase r0 = r13.getWritableDatabase()
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            r10 = 0
            java.lang.String r1 = "hits2"
            java.lang.String r2 = "hit_id"
            java.lang.String[] r2 = new java.lang.String[]{r2}     // Catch:{ SQLiteException -> 0x0062 }
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            java.lang.String r7 = "%s ASC"
            r8 = 1
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ SQLiteException -> 0x0062 }
            java.lang.String r11 = "hit_id"
            r12 = 0
            r8[r12] = r11     // Catch:{ SQLiteException -> 0x0062 }
            java.lang.String r7 = java.lang.String.format(r7, r8)     // Catch:{ SQLiteException -> 0x0062 }
            java.lang.String r8 = java.lang.Long.toString(r14)     // Catch:{ SQLiteException -> 0x0062 }
            android.database.Cursor r14 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x0062 }
            boolean r15 = r14.moveToFirst()     // Catch:{ SQLiteException -> 0x005d, all -> 0x005a }
            if (r15 == 0) goto L_0x0054
        L_0x0043:
            long r0 = r14.getLong(r12)     // Catch:{ SQLiteException -> 0x005d, all -> 0x005a }
            java.lang.Long r15 = java.lang.Long.valueOf(r0)     // Catch:{ SQLiteException -> 0x005d, all -> 0x005a }
            r9.add(r15)     // Catch:{ SQLiteException -> 0x005d, all -> 0x005a }
            boolean r15 = r14.moveToNext()     // Catch:{ SQLiteException -> 0x005d, all -> 0x005a }
            if (r15 != 0) goto L_0x0043
        L_0x0054:
            if (r14 == 0) goto L_0x006d
            r14.close()
            goto L_0x006d
        L_0x005a:
            r15 = move-exception
            r10 = r14
            goto L_0x006e
        L_0x005d:
            r15 = move-exception
            r10 = r14
            goto L_0x0063
        L_0x0060:
            r15 = move-exception
            goto L_0x006e
        L_0x0062:
            r15 = move-exception
        L_0x0063:
            java.lang.String r14 = "Error selecting hit ids"
            r13.zzd(r14, r15)     // Catch:{ all -> 0x0060 }
            if (r10 == 0) goto L_0x006d
            r10.close()
        L_0x006d:
            return r9
        L_0x006e:
            if (r10 == 0) goto L_0x0073
            r10.close()
        L_0x0073:
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzbf.zzc(long):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0092  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.internal.measurement.zzck> zzd(long r14) {
        /*
            r13 = this;
            r0 = 0
            r1 = 1
            r2 = 0
            int r2 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x000a
            r2 = 1
            goto L_0x000b
        L_0x000a:
            r2 = 0
        L_0x000b:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r2)
            com.google.android.gms.analytics.zzk.zzaf()
            r13.zzcl()
            android.database.sqlite.SQLiteDatabase r3 = r13.getWritableDatabase()
            r2 = 0
            java.lang.String r4 = "hits2"
            java.lang.String r5 = "hit_id"
            java.lang.String r6 = "hit_time"
            java.lang.String r7 = "hit_string"
            java.lang.String r8 = "hit_url"
            java.lang.String r9 = "hit_app_id"
            java.lang.String[] r5 = new java.lang.String[]{r5, r6, r7, r8, r9}     // Catch:{ SQLiteException -> 0x0089 }
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            java.lang.String r10 = "%s ASC"
            java.lang.Object[] r11 = new java.lang.Object[r1]     // Catch:{ SQLiteException -> 0x0089 }
            java.lang.String r12 = "hit_id"
            r11[r0] = r12     // Catch:{ SQLiteException -> 0x0089 }
            java.lang.String r10 = java.lang.String.format(r10, r11)     // Catch:{ SQLiteException -> 0x0089 }
            java.lang.String r11 = java.lang.Long.toString(r14)     // Catch:{ SQLiteException -> 0x0089 }
            android.database.Cursor r14 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ SQLiteException -> 0x0089 }
            java.util.ArrayList r15 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0084, all -> 0x0081 }
            r15.<init>()     // Catch:{ SQLiteException -> 0x0084, all -> 0x0081 }
            boolean r2 = r14.moveToFirst()     // Catch:{ SQLiteException -> 0x0084, all -> 0x0081 }
            if (r2 == 0) goto L_0x007b
        L_0x004c:
            long r9 = r14.getLong(r0)     // Catch:{ SQLiteException -> 0x0084, all -> 0x0081 }
            long r6 = r14.getLong(r1)     // Catch:{ SQLiteException -> 0x0084, all -> 0x0081 }
            r2 = 2
            java.lang.String r2 = r14.getString(r2)     // Catch:{ SQLiteException -> 0x0084, all -> 0x0081 }
            r3 = 3
            java.lang.String r3 = r14.getString(r3)     // Catch:{ SQLiteException -> 0x0084, all -> 0x0081 }
            r4 = 4
            int r11 = r14.getInt(r4)     // Catch:{ SQLiteException -> 0x0084, all -> 0x0081 }
            java.util.Map r5 = r13.zzv(r2)     // Catch:{ SQLiteException -> 0x0084, all -> 0x0081 }
            boolean r8 = com.google.android.gms.internal.measurement.zzdg.zzai(r3)     // Catch:{ SQLiteException -> 0x0084, all -> 0x0081 }
            com.google.android.gms.internal.measurement.zzck r2 = new com.google.android.gms.internal.measurement.zzck     // Catch:{ SQLiteException -> 0x0084, all -> 0x0081 }
            r3 = r2
            r4 = r13
            r3.<init>(r4, r5, r6, r8, r9, r11)     // Catch:{ SQLiteException -> 0x0084, all -> 0x0081 }
            r15.add(r2)     // Catch:{ SQLiteException -> 0x0084, all -> 0x0081 }
            boolean r2 = r14.moveToNext()     // Catch:{ SQLiteException -> 0x0084, all -> 0x0081 }
            if (r2 != 0) goto L_0x004c
        L_0x007b:
            if (r14 == 0) goto L_0x0080
            r14.close()
        L_0x0080:
            return r15
        L_0x0081:
            r15 = move-exception
            r2 = r14
            goto L_0x0090
        L_0x0084:
            r15 = move-exception
            r2 = r14
            goto L_0x008a
        L_0x0087:
            r15 = move-exception
            goto L_0x0090
        L_0x0089:
            r15 = move-exception
        L_0x008a:
            java.lang.String r14 = "Error loading hits from the database"
            r13.zze(r14, r15)     // Catch:{ all -> 0x0087 }
            throw r15     // Catch:{ all -> 0x0087 }
        L_0x0090:
            if (r2 == 0) goto L_0x0095
            r2.close()
        L_0x0095:
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzbf.zzd(long):java.util.List");
    }

    public final void zza(List<Long> list) {
        Preconditions.checkNotNull(list);
        zzk.zzaf();
        zzcl();
        if (!list.isEmpty()) {
            StringBuilder sb = new StringBuilder("hit_id");
            sb.append(" in (");
            for (int i = 0; i < list.size(); i++) {
                Long l = (Long) list.get(i);
                if (l == null || l.longValue() == 0) {
                    throw new SQLiteException("Invalid hit id");
                }
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(l);
            }
            sb.append(")");
            String sb2 = sb.toString();
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                zza("Deleting dispatched hits. count", Integer.valueOf(list.size()));
                int delete = writableDatabase.delete("hits2", sb2, null);
                if (delete != list.size()) {
                    zzb("Deleted fewer hits then expected", Integer.valueOf(list.size()), Integer.valueOf(delete), sb2);
                }
            } catch (SQLiteException e) {
                zze("Error deleting hits", e);
                throw e;
            }
        }
    }

    public final void zze(long j) {
        zzk.zzaf();
        zzcl();
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(Long.valueOf(j));
        zza("Deleting hit, id", Long.valueOf(j));
        zza((List<Long>) arrayList);
    }

    public final int zzdb() {
        zzk.zzaf();
        zzcl();
        if (!this.zzxi.zzj(86400000)) {
            return 0;
        }
        this.zzxi.start();
        zzq("Deleting stale hits (if any)");
        int delete = getWritableDatabase().delete("hits2", "hit_time < ?", new String[]{Long.toString(zzbx().currentTimeMillis() - 2592000000L)});
        zza("Deleted stale hits, count", Integer.valueOf(delete));
        return delete;
    }

    public final long zzdc() {
        zzk.zzaf();
        zzcl();
        return zza(zzxg, (String[]) null, 0);
    }

    public final long zza(long j, String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzcl();
        zzk.zzaf();
        return zza("SELECT hits_count FROM properties WHERE app_uid=? AND cid=? AND tid=?", new String[]{String.valueOf(j), str, str2}, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00af  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.internal.measurement.zzaz> zzf(long r12) {
        /*
            r11 = this;
            r11.zzcl()
            com.google.android.gms.analytics.zzk.zzaf()
            android.database.sqlite.SQLiteDatabase r0 = r11.getWritableDatabase()
            r12 = 0
            java.lang.String r13 = "cid"
            java.lang.String r1 = "tid"
            java.lang.String r2 = "adid"
            java.lang.String r3 = "hits_count"
            java.lang.String r4 = "params"
            java.lang.String[] r2 = new java.lang.String[]{r13, r1, r2, r3, r4}     // Catch:{ SQLiteException -> 0x00a3, all -> 0x009f }
            com.google.android.gms.internal.measurement.zzcg<java.lang.Integer> r13 = com.google.android.gms.internal.measurement.zzcf.zzzc     // Catch:{ SQLiteException -> 0x00a3, all -> 0x009f }
            java.lang.Object r13 = r13.get()     // Catch:{ SQLiteException -> 0x00a3, all -> 0x009f }
            java.lang.Integer r13 = (java.lang.Integer) r13     // Catch:{ SQLiteException -> 0x00a3, all -> 0x009f }
            int r13 = r13.intValue()     // Catch:{ SQLiteException -> 0x00a3, all -> 0x009f }
            java.lang.String r8 = java.lang.String.valueOf(r13)     // Catch:{ SQLiteException -> 0x00a3, all -> 0x009f }
            java.lang.String r3 = "app_uid=?"
            java.lang.String r1 = "0"
            java.lang.String[] r4 = new java.lang.String[]{r1}     // Catch:{ SQLiteException -> 0x00a3, all -> 0x009f }
            java.lang.String r1 = "properties"
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x00a3, all -> 0x009f }
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x009d }
            r12.<init>()     // Catch:{ SQLiteException -> 0x009d }
            boolean r1 = r0.moveToFirst()     // Catch:{ SQLiteException -> 0x009d }
            if (r1 == 0) goto L_0x008c
        L_0x0045:
            r1 = 0
            java.lang.String r5 = r0.getString(r1)     // Catch:{ SQLiteException -> 0x009d }
            r2 = 1
            java.lang.String r6 = r0.getString(r2)     // Catch:{ SQLiteException -> 0x009d }
            r3 = 2
            int r3 = r0.getInt(r3)     // Catch:{ SQLiteException -> 0x009d }
            if (r3 == 0) goto L_0x0058
            r7 = 1
            goto L_0x0059
        L_0x0058:
            r7 = 0
        L_0x0059:
            r1 = 3
            int r1 = r0.getInt(r1)     // Catch:{ SQLiteException -> 0x009d }
            long r8 = (long) r1     // Catch:{ SQLiteException -> 0x009d }
            r1 = 4
            java.lang.String r1 = r0.getString(r1)     // Catch:{ SQLiteException -> 0x009d }
            java.util.Map r10 = r11.zzw(r1)     // Catch:{ SQLiteException -> 0x009d }
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch:{ SQLiteException -> 0x009d }
            if (r1 != 0) goto L_0x0081
            boolean r1 = android.text.TextUtils.isEmpty(r6)     // Catch:{ SQLiteException -> 0x009d }
            if (r1 == 0) goto L_0x0075
            goto L_0x0081
        L_0x0075:
            com.google.android.gms.internal.measurement.zzaz r1 = new com.google.android.gms.internal.measurement.zzaz     // Catch:{ SQLiteException -> 0x009d }
            r3 = 0
            r2 = r1
            r2.<init>(r3, r5, r6, r7, r8, r10)     // Catch:{ SQLiteException -> 0x009d }
            r12.add(r1)     // Catch:{ SQLiteException -> 0x009d }
            goto L_0x0086
        L_0x0081:
            java.lang.String r1 = "Read property with empty client id or tracker id"
            r11.zzc(r1, r5, r6)     // Catch:{ SQLiteException -> 0x009d }
        L_0x0086:
            boolean r1 = r0.moveToNext()     // Catch:{ SQLiteException -> 0x009d }
            if (r1 != 0) goto L_0x0045
        L_0x008c:
            int r1 = r12.size()     // Catch:{ SQLiteException -> 0x009d }
            if (r1 < r13) goto L_0x0097
            java.lang.String r13 = "Sending hits to too many properties. Campaign report might be incorrect"
            r11.zzt(r13)     // Catch:{ SQLiteException -> 0x009d }
        L_0x0097:
            if (r0 == 0) goto L_0x009c
            r0.close()
        L_0x009c:
            return r12
        L_0x009d:
            r12 = move-exception
            goto L_0x00a6
        L_0x009f:
            r13 = move-exception
            r0 = r12
            r12 = r13
            goto L_0x00ad
        L_0x00a3:
            r13 = move-exception
            r0 = r12
            r12 = r13
        L_0x00a6:
            java.lang.String r13 = "Error loading hits from the database"
            r11.zze(r13, r12)     // Catch:{ all -> 0x00ac }
            throw r12     // Catch:{ all -> 0x00ac }
        L_0x00ac:
            r12 = move-exception
        L_0x00ad:
            if (r0 == 0) goto L_0x00b2
            r0.close()
        L_0x00b2:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzbf.zzf(long):java.util.List");
    }

    public final void close() {
        try {
            this.zzxh.close();
        } catch (SQLiteException e) {
            zze("Sql error closing database", e);
        } catch (IllegalStateException e2) {
            zze("Error closing database", e2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0035  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final long zza(java.lang.String r4, java.lang.String[] r5) {
        /*
            r3 = this;
            android.database.sqlite.SQLiteDatabase r5 = r3.getWritableDatabase()
            r0 = 0
            android.database.Cursor r5 = r5.rawQuery(r4, r0)     // Catch:{ SQLiteException -> 0x0029, all -> 0x0026 }
            boolean r0 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x0024 }
            if (r0 == 0) goto L_0x001a
            r0 = 0
            long r0 = r5.getLong(r0)     // Catch:{ SQLiteException -> 0x0024 }
            if (r5 == 0) goto L_0x0019
            r5.close()
        L_0x0019:
            return r0
        L_0x001a:
            android.database.sqlite.SQLiteException r0 = new android.database.sqlite.SQLiteException     // Catch:{ SQLiteException -> 0x0024 }
            java.lang.String r1 = "Database returned empty set"
            r0.<init>(r1)     // Catch:{ SQLiteException -> 0x0024 }
            throw r0     // Catch:{ SQLiteException -> 0x0024 }
        L_0x0022:
            r4 = move-exception
            goto L_0x0033
        L_0x0024:
            r0 = move-exception
            goto L_0x002d
        L_0x0026:
            r4 = move-exception
            r5 = r0
            goto L_0x0033
        L_0x0029:
            r5 = move-exception
            r2 = r0
            r0 = r5
            r5 = r2
        L_0x002d:
            java.lang.String r1 = "Database error"
            r3.zzd(r1, r4, r0)     // Catch:{ all -> 0x0022 }
            throw r0     // Catch:{ all -> 0x0022 }
        L_0x0033:
            if (r5 == 0) goto L_0x0038
            r5.close()
        L_0x0038:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzbf.zza(java.lang.String, java.lang.String[]):long");
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0033  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final long zza(java.lang.String r1, java.lang.String[] r2, long r3) {
        /*
            r0 = this;
            android.database.sqlite.SQLiteDatabase r3 = r0.getWritableDatabase()
            r4 = 0
            android.database.Cursor r2 = r3.rawQuery(r1, r2)     // Catch:{ SQLiteException -> 0x002a }
            boolean r3 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x0025, all -> 0x0022 }
            if (r3 == 0) goto L_0x001a
            r3 = 0
            long r3 = r2.getLong(r3)     // Catch:{ SQLiteException -> 0x0025, all -> 0x0022 }
            if (r2 == 0) goto L_0x0019
            r2.close()
        L_0x0019:
            return r3
        L_0x001a:
            if (r2 == 0) goto L_0x001f
            r2.close()
        L_0x001f:
            r1 = 0
            return r1
        L_0x0022:
            r1 = move-exception
            r4 = r2
            goto L_0x0031
        L_0x0025:
            r3 = move-exception
            r4 = r2
            goto L_0x002b
        L_0x0028:
            r1 = move-exception
            goto L_0x0031
        L_0x002a:
            r3 = move-exception
        L_0x002b:
            java.lang.String r2 = "Database error"
            r0.zzd(r2, r1, r3)     // Catch:{ all -> 0x0028 }
            throw r3     // Catch:{ all -> 0x0028 }
        L_0x0031:
            if (r4 == 0) goto L_0x0036
            r4.close()
        L_0x0036:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzbf.zza(java.lang.String, java.lang.String[], long):long");
    }

    @VisibleForTesting
    private final Map<String, String> zzv(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap(0);
        }
        try {
            if (!str.startsWith("?")) {
                String str2 = "?";
                String valueOf = String.valueOf(str);
                str = valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2);
            }
            return HttpUtils.parse(new URI(str), "UTF-8");
        } catch (URISyntaxException e) {
            zze("Error parsing hit parameters", e);
            return new HashMap(0);
        }
    }

    @VisibleForTesting
    private final Map<String, String> zzw(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap(0);
        }
        String str2 = "?";
        try {
            String valueOf = String.valueOf(str);
            return HttpUtils.parse(new URI(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2)), "UTF-8");
        } catch (URISyntaxException e) {
            zze("Error parsing property parameters", e);
            return new HashMap(0);
        }
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    public final SQLiteDatabase getWritableDatabase() {
        try {
            return this.zzxh.getWritableDatabase();
        } catch (SQLiteException e) {
            zzd("Error opening database", e);
            throw e;
        }
    }
}
