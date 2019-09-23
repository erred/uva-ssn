package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zzao extends zzf {
    private final zzap zzalm = new zzap(this, getContext(), "google_app_measurement_local.db");
    private boolean zzaln;

    zzao(zzbw zzbw) {
        super(zzbw);
    }

    /* access modifiers changed from: protected */
    public final boolean zzgy() {
        return false;
    }

    public final void resetAnalyticsData() {
        zzgg();
        zzaf();
        try {
            int delete = getWritableDatabase().delete("messages", null, null) + 0;
            if (delete > 0) {
                zzgt().zzjo().zzg("Reset local analytics data. records", Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzgt().zzjg().zzg("Error resetting local analytics data. error", e);
        }
    }

    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1, types: [boolean, int] */
    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r12v0, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r9v0, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARNING: type inference failed for: r9v1 */
    /* JADX WARNING: type inference failed for: r7v1 */
    /* JADX WARNING: type inference failed for: r12v1 */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r9v2, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARNING: type inference failed for: r7v2, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r9v3 */
    /* JADX WARNING: type inference failed for: r9v4, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARNING: type inference failed for: r7v3, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r9v5 */
    /* JADX WARNING: type inference failed for: r12v2, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r7v4, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARNING: type inference failed for: r9v6 */
    /* JADX WARNING: type inference failed for: r12v3 */
    /* JADX WARNING: type inference failed for: r9v7 */
    /* JADX WARNING: type inference failed for: r12v4 */
    /* JADX WARNING: type inference failed for: r9v8, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARNING: type inference failed for: r12v5, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r7v5 */
    /* JADX WARNING: type inference failed for: r7v6 */
    /* JADX WARNING: type inference failed for: r12v6 */
    /* JADX WARNING: type inference failed for: r7v7 */
    /* JADX WARNING: type inference failed for: r12v7 */
    /* JADX WARNING: type inference failed for: r2v11 */
    /* JADX WARNING: type inference failed for: r7v8 */
    /* JADX WARNING: type inference failed for: r7v9 */
    /* JADX WARNING: type inference failed for: r7v10 */
    /* JADX WARNING: type inference failed for: r7v11 */
    /* JADX WARNING: type inference failed for: r7v12 */
    /* JADX WARNING: type inference failed for: r9v9 */
    /* JADX WARNING: type inference failed for: r2v12 */
    /* JADX WARNING: type inference failed for: r9v10 */
    /* JADX WARNING: type inference failed for: r9v11 */
    /* JADX WARNING: type inference failed for: r7v13 */
    /* JADX WARNING: type inference failed for: r7v14 */
    /* JADX WARNING: type inference failed for: r9v12 */
    /* JADX WARNING: type inference failed for: r9v13 */
    /* JADX WARNING: type inference failed for: r7v15 */
    /* JADX WARNING: type inference failed for: r7v16 */
    /* JADX WARNING: type inference failed for: r12v8 */
    /* JADX WARNING: type inference failed for: r9v14 */
    /* JADX WARNING: type inference failed for: r9v15 */
    /* JADX WARNING: type inference failed for: r9v16 */
    /* JADX WARNING: type inference failed for: r9v17 */
    /* JADX WARNING: type inference failed for: r9v18 */
    /* JADX WARNING: type inference failed for: r12v9 */
    /* JADX WARNING: type inference failed for: r12v10 */
    /* JADX WARNING: type inference failed for: r12v11 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r2v1, types: [boolean, int]
      assigns: []
      uses: [?[int, short, byte, char], int, boolean]
      mth insns count: 163
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00cb A[SYNTHETIC, Splitter:B:49:0x00cb] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x011f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x011f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x011f A[SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 19 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zza(int r18, byte[] r19) {
        /*
            r17 = this;
            r1 = r17
            r17.zzgg()
            r17.zzaf()
            boolean r0 = r1.zzaln
            r2 = 0
            if (r0 == 0) goto L_0x000e
            return r2
        L_0x000e:
            android.content.ContentValues r3 = new android.content.ContentValues
            r3.<init>()
            java.lang.String r0 = "type"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r18)
            r3.put(r0, r4)
            java.lang.String r0 = "entry"
            r4 = r19
            r3.put(r0, r4)
            r4 = 5
            r5 = 0
            r6 = 5
        L_0x0026:
            if (r5 >= r4) goto L_0x0132
            r7 = 0
            r8 = 1
            android.database.sqlite.SQLiteDatabase r9 = r17.getWritableDatabase()     // Catch:{ SQLiteFullException -> 0x0104, SQLiteDatabaseLockedException -> 0x00f2, SQLiteException -> 0x00c7, all -> 0x00c3 }
            if (r9 != 0) goto L_0x0040
            r1.zzaln = r8     // Catch:{ SQLiteFullException -> 0x003d, SQLiteDatabaseLockedException -> 0x00f3, SQLiteException -> 0x0038 }
            if (r9 == 0) goto L_0x0037
            r9.close()
        L_0x0037:
            return r2
        L_0x0038:
            r0 = move-exception
            r12 = r7
        L_0x003a:
            r7 = r9
            goto L_0x00c9
        L_0x003d:
            r0 = move-exception
            goto L_0x0106
        L_0x0040:
            r9.beginTransaction()     // Catch:{ SQLiteFullException -> 0x003d, SQLiteDatabaseLockedException -> 0x00f3, SQLiteException -> 0x0038 }
            r10 = 0
            java.lang.String r0 = "select count(1) from messages"
            android.database.Cursor r12 = r9.rawQuery(r0, r7)     // Catch:{ SQLiteFullException -> 0x003d, SQLiteDatabaseLockedException -> 0x00f3, SQLiteException -> 0x0038 }
            if (r12 == 0) goto L_0x0061
            boolean r0 = r12.moveToFirst()     // Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
            if (r0 == 0) goto L_0x0061
            long r10 = r12.getLong(r2)     // Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
            goto L_0x0061
        L_0x0058:
            r0 = move-exception
            goto L_0x0127
        L_0x005b:
            r0 = move-exception
            goto L_0x003a
        L_0x005d:
            r0 = move-exception
            r7 = r12
            goto L_0x0106
        L_0x0061:
            r13 = 100000(0x186a0, double:4.94066E-319)
            int r0 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r0 < 0) goto L_0x00ab
            com.google.android.gms.measurement.internal.zzas r0 = r17.zzgt()     // Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
            com.google.android.gms.measurement.internal.zzau r0 = r0.zzjg()     // Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
            java.lang.String r15 = "Data loss, local db full"
            r0.zzby(r15)     // Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
            r0 = 0
            long r13 = r13 - r10
            r10 = 1
            long r13 = r13 + r10
            java.lang.String r0 = "messages"
            java.lang.String r10 = "rowid in (select rowid from messages order by rowid asc limit ?)"
            java.lang.String[] r11 = new java.lang.String[r8]     // Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
            java.lang.String r15 = java.lang.Long.toString(r13)     // Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
            r11[r2] = r15     // Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
            int r0 = r9.delete(r0, r10, r11)     // Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
            long r10 = (long) r0     // Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
            int r0 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r0 == 0) goto L_0x00ab
            com.google.android.gms.measurement.internal.zzas r0 = r17.zzgt()     // Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
            com.google.android.gms.measurement.internal.zzau r0 = r0.zzjg()     // Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
            java.lang.String r15 = "Different delete count than expected in local db. expected, received, difference"
            java.lang.Long r4 = java.lang.Long.valueOf(r13)     // Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
            java.lang.Long r2 = java.lang.Long.valueOf(r10)     // Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
            r16 = 0
            long r13 = r13 - r10
            java.lang.Long r10 = java.lang.Long.valueOf(r13)     // Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
            r0.zzd(r15, r4, r2, r10)     // Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
        L_0x00ab:
            java.lang.String r0 = "messages"
            r9.insertOrThrow(r0, r7, r3)     // Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
            r9.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
            r9.endTransaction()     // Catch:{ SQLiteFullException -> 0x005d, SQLiteDatabaseLockedException -> 0x00c1, SQLiteException -> 0x005b, all -> 0x0058 }
            if (r12 == 0) goto L_0x00bb
            r12.close()
        L_0x00bb:
            if (r9 == 0) goto L_0x00c0
            r9.close()
        L_0x00c0:
            return r8
        L_0x00c1:
            r7 = r12
            goto L_0x00f3
        L_0x00c3:
            r0 = move-exception
            r9 = r7
            r12 = r9
            goto L_0x0127
        L_0x00c7:
            r0 = move-exception
            r12 = r7
        L_0x00c9:
            if (r7 == 0) goto L_0x00d8
            boolean r2 = r7.inTransaction()     // Catch:{ all -> 0x00d5 }
            if (r2 == 0) goto L_0x00d8
            r7.endTransaction()     // Catch:{ all -> 0x00d5 }
            goto L_0x00d8
        L_0x00d5:
            r0 = move-exception
            r9 = r7
            goto L_0x0127
        L_0x00d8:
            com.google.android.gms.measurement.internal.zzas r2 = r17.zzgt()     // Catch:{ all -> 0x00d5 }
            com.google.android.gms.measurement.internal.zzau r2 = r2.zzjg()     // Catch:{ all -> 0x00d5 }
            java.lang.String r4 = "Error writing entry to local database"
            r2.zzg(r4, r0)     // Catch:{ all -> 0x00d5 }
            r1.zzaln = r8     // Catch:{ all -> 0x00d5 }
            if (r12 == 0) goto L_0x00ec
            r12.close()
        L_0x00ec:
            if (r7 == 0) goto L_0x011f
            r7.close()
            goto L_0x011f
        L_0x00f2:
            r9 = r7
        L_0x00f3:
            long r10 = (long) r6
            android.os.SystemClock.sleep(r10)     // Catch:{ all -> 0x0125 }
            int r6 = r6 + 20
            if (r7 == 0) goto L_0x00fe
            r7.close()
        L_0x00fe:
            if (r9 == 0) goto L_0x011f
            r9.close()
            goto L_0x011f
        L_0x0104:
            r0 = move-exception
            r9 = r7
        L_0x0106:
            com.google.android.gms.measurement.internal.zzas r2 = r17.zzgt()     // Catch:{ all -> 0x0125 }
            com.google.android.gms.measurement.internal.zzau r2 = r2.zzjg()     // Catch:{ all -> 0x0125 }
            java.lang.String r4 = "Error writing entry to local database"
            r2.zzg(r4, r0)     // Catch:{ all -> 0x0125 }
            r1.zzaln = r8     // Catch:{ all -> 0x0125 }
            if (r7 == 0) goto L_0x011a
            r7.close()
        L_0x011a:
            if (r9 == 0) goto L_0x011f
            r9.close()
        L_0x011f:
            int r5 = r5 + 1
            r2 = 0
            r4 = 5
            goto L_0x0026
        L_0x0125:
            r0 = move-exception
            r12 = r7
        L_0x0127:
            if (r12 == 0) goto L_0x012c
            r12.close()
        L_0x012c:
            if (r9 == 0) goto L_0x0131
            r9.close()
        L_0x0131:
            throw r0
        L_0x0132:
            com.google.android.gms.measurement.internal.zzas r0 = r17.zzgt()
            com.google.android.gms.measurement.internal.zzau r0 = r0.zzjj()
            java.lang.String r2 = "Failed to write entry to local database"
            r0.zzby(r2)
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzao.zza(int, byte[]):boolean");
    }

    public final boolean zza(zzag zzag) {
        Parcel obtain = Parcel.obtain();
        zzag.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zza(0, marshall);
        }
        zzgt().zzjj().zzby("Event is too long for local database. Sending event directly to service");
        return false;
    }

    public final boolean zza(zzfv zzfv) {
        Parcel obtain = Parcel.obtain();
        zzfv.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zza(1, marshall);
        }
        zzgt().zzjj().zzby("User property too long for local database. Sending directly to service");
        return false;
    }

    public final boolean zzc(zzo zzo) {
        zzgr();
        byte[] zza = zzfy.zza((Parcelable) zzo);
        if (zza.length <= 131072) {
            return zza(2, zza);
        }
        zzgt().zzjj().zzby("Conditional user property too long for local database. Sending directly to service");
        return false;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:57|58|59|60) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:72|73|74|75) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:44|45|46|47|160) */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x017d, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x017e, code lost:
        r4 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0043, code lost:
        r4 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        zzgt().zzjg().zzby("Failed to load event from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        r12.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        zzgt().zzjg().zzby("Failed to load user property from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        r12.recycle();
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        zzgt().zzjg().zzby("Failed to load user property from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
        r12.recycle();
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0172, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0173, code lost:
        r4 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0177, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0178, code lost:
        r4 = r15;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:44:0x00a2 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x00d2 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:72:0x0108 */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x018a A[SYNTHETIC, Splitter:B:111:0x018a] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x01bc  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x01d4  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x01d9  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x01e4  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x01e9  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x01dc A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x01dc A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x01dc A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[ExcHandler: SQLiteDatabaseLockedException (unused android.database.sqlite.SQLiteDatabaseLockedException), SYNTHETIC, Splitter:B:12:0x0031] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable> zzr(int r19) {
        /*
            r18 = this;
            r1 = r18
            r18.zzaf()
            r18.zzgg()
            boolean r0 = r1.zzaln
            r2 = 0
            if (r0 == 0) goto L_0x000e
            return r2
        L_0x000e:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            android.content.Context r0 = r18.getContext()
            java.lang.String r4 = "google_app_measurement_local.db"
            java.io.File r0 = r0.getDatabasePath(r4)
            boolean r0 = r0.exists()
            if (r0 != 0) goto L_0x0024
            return r3
        L_0x0024:
            r4 = 5
            r5 = 0
            r6 = 0
            r7 = 5
        L_0x0028:
            if (r6 >= r4) goto L_0x01ed
            r8 = 1
            android.database.sqlite.SQLiteDatabase r15 = r18.getWritableDatabase()     // Catch:{ SQLiteFullException -> 0x01c0, SQLiteDatabaseLockedException -> 0x01ad, SQLiteException -> 0x0185, all -> 0x0181 }
            if (r15 != 0) goto L_0x004b
            r1.zzaln = r8     // Catch:{ SQLiteFullException -> 0x0046, SQLiteDatabaseLockedException -> 0x0043, SQLiteException -> 0x003e, all -> 0x0039 }
            if (r15 == 0) goto L_0x0038
            r15.close()
        L_0x0038:
            return r2
        L_0x0039:
            r0 = move-exception
            r9 = r2
            r4 = r15
            goto L_0x01e2
        L_0x003e:
            r0 = move-exception
            r9 = r2
            r4 = r15
            goto L_0x0188
        L_0x0043:
            r4 = r15
            goto L_0x017b
        L_0x0046:
            r0 = move-exception
            r9 = r2
            r4 = r15
            goto L_0x01c3
        L_0x004b:
            r15.beginTransaction()     // Catch:{ SQLiteFullException -> 0x017d, SQLiteDatabaseLockedException -> 0x0043, SQLiteException -> 0x0177, all -> 0x0172 }
            java.lang.String r10 = "messages"
            java.lang.String r0 = "rowid"
            java.lang.String r9 = "type"
            java.lang.String r11 = "entry"
            java.lang.String[] r11 = new java.lang.String[]{r0, r9, r11}     // Catch:{ SQLiteFullException -> 0x017d, SQLiteDatabaseLockedException -> 0x0043, SQLiteException -> 0x0177, all -> 0x0172 }
            r12 = 0
            r13 = 0
            r14 = 0
            r0 = 0
            java.lang.String r16 = "rowid asc"
            r9 = 100
            java.lang.String r17 = java.lang.Integer.toString(r9)     // Catch:{ SQLiteFullException -> 0x017d, SQLiteDatabaseLockedException -> 0x0043, SQLiteException -> 0x0177, all -> 0x0172 }
            r9 = r15
            r4 = r15
            r15 = r0
            android.database.Cursor r9 = r9.query(r10, r11, r12, r13, r14, r15, r16, r17)     // Catch:{ SQLiteFullException -> 0x0170, SQLiteDatabaseLockedException -> 0x017b, SQLiteException -> 0x016e, all -> 0x016c }
            r10 = -1
        L_0x006f:
            boolean r0 = r9.moveToNext()     // Catch:{ SQLiteFullException -> 0x0169, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x0167 }
            if (r0 == 0) goto L_0x0133
            long r10 = r9.getLong(r5)     // Catch:{ SQLiteFullException -> 0x0169, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x0167 }
            int r0 = r9.getInt(r8)     // Catch:{ SQLiteFullException -> 0x0169, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x0167 }
            r12 = 2
            byte[] r13 = r9.getBlob(r12)     // Catch:{ SQLiteFullException -> 0x0169, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x0167 }
            if (r0 != 0) goto L_0x00b7
            android.os.Parcel r12 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x0169, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x0167 }
            int r0 = r13.length     // Catch:{ ParseException -> 0x00a2 }
            r12.unmarshall(r13, r5, r0)     // Catch:{ ParseException -> 0x00a2 }
            r12.setDataPosition(r5)     // Catch:{ ParseException -> 0x00a2 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzag> r0 = com.google.android.gms.measurement.internal.zzag.CREATOR     // Catch:{ ParseException -> 0x00a2 }
            java.lang.Object r0 = r0.createFromParcel(r12)     // Catch:{ ParseException -> 0x00a2 }
            com.google.android.gms.measurement.internal.zzag r0 = (com.google.android.gms.measurement.internal.zzag) r0     // Catch:{ ParseException -> 0x00a2 }
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x0169, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x0167 }
            if (r0 == 0) goto L_0x006f
            r3.add(r0)     // Catch:{ SQLiteFullException -> 0x0169, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x0167 }
            goto L_0x006f
        L_0x00a0:
            r0 = move-exception
            goto L_0x00b3
        L_0x00a2:
            com.google.android.gms.measurement.internal.zzas r0 = r18.zzgt()     // Catch:{ all -> 0x00a0 }
            com.google.android.gms.measurement.internal.zzau r0 = r0.zzjg()     // Catch:{ all -> 0x00a0 }
            java.lang.String r13 = "Failed to load event from local database"
            r0.zzby(r13)     // Catch:{ all -> 0x00a0 }
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x0169, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x0167 }
            goto L_0x006f
        L_0x00b3:
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x0169, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x0167 }
            throw r0     // Catch:{ SQLiteFullException -> 0x0169, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x0167 }
        L_0x00b7:
            if (r0 != r8) goto L_0x00ed
            android.os.Parcel r12 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x0169, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x0167 }
            int r0 = r13.length     // Catch:{ ParseException -> 0x00d2 }
            r12.unmarshall(r13, r5, r0)     // Catch:{ ParseException -> 0x00d2 }
            r12.setDataPosition(r5)     // Catch:{ ParseException -> 0x00d2 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzfv> r0 = com.google.android.gms.measurement.internal.zzfv.CREATOR     // Catch:{ ParseException -> 0x00d2 }
            java.lang.Object r0 = r0.createFromParcel(r12)     // Catch:{ ParseException -> 0x00d2 }
            com.google.android.gms.measurement.internal.zzfv r0 = (com.google.android.gms.measurement.internal.zzfv) r0     // Catch:{ ParseException -> 0x00d2 }
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x0169, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x0167 }
            goto L_0x00e3
        L_0x00d0:
            r0 = move-exception
            goto L_0x00e9
        L_0x00d2:
            com.google.android.gms.measurement.internal.zzas r0 = r18.zzgt()     // Catch:{ all -> 0x00d0 }
            com.google.android.gms.measurement.internal.zzau r0 = r0.zzjg()     // Catch:{ all -> 0x00d0 }
            java.lang.String r13 = "Failed to load user property from local database"
            r0.zzby(r13)     // Catch:{ all -> 0x00d0 }
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x0169, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x0167 }
            r0 = r2
        L_0x00e3:
            if (r0 == 0) goto L_0x006f
            r3.add(r0)     // Catch:{ SQLiteFullException -> 0x0169, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x0167 }
            goto L_0x006f
        L_0x00e9:
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x0169, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x0167 }
            throw r0     // Catch:{ SQLiteFullException -> 0x0169, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x0167 }
        L_0x00ed:
            if (r0 != r12) goto L_0x0124
            android.os.Parcel r12 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x0169, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x0167 }
            int r0 = r13.length     // Catch:{ ParseException -> 0x0108 }
            r12.unmarshall(r13, r5, r0)     // Catch:{ ParseException -> 0x0108 }
            r12.setDataPosition(r5)     // Catch:{ ParseException -> 0x0108 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzo> r0 = com.google.android.gms.measurement.internal.zzo.CREATOR     // Catch:{ ParseException -> 0x0108 }
            java.lang.Object r0 = r0.createFromParcel(r12)     // Catch:{ ParseException -> 0x0108 }
            com.google.android.gms.measurement.internal.zzo r0 = (com.google.android.gms.measurement.internal.zzo) r0     // Catch:{ ParseException -> 0x0108 }
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x0169, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x0167 }
            goto L_0x0119
        L_0x0106:
            r0 = move-exception
            goto L_0x0120
        L_0x0108:
            com.google.android.gms.measurement.internal.zzas r0 = r18.zzgt()     // Catch:{ all -> 0x0106 }
            com.google.android.gms.measurement.internal.zzau r0 = r0.zzjg()     // Catch:{ all -> 0x0106 }
            java.lang.String r13 = "Failed to load user property from local database"
            r0.zzby(r13)     // Catch:{ all -> 0x0106 }
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x0169, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x0167 }
            r0 = r2
        L_0x0119:
            if (r0 == 0) goto L_0x006f
            r3.add(r0)     // Catch:{ SQLiteFullException -> 0x0169, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x0167 }
            goto L_0x006f
        L_0x0120:
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x0169, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x0167 }
            throw r0     // Catch:{ SQLiteFullException -> 0x0169, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x0167 }
        L_0x0124:
            com.google.android.gms.measurement.internal.zzas r0 = r18.zzgt()     // Catch:{ SQLiteFullException -> 0x0169, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x0167 }
            com.google.android.gms.measurement.internal.zzau r0 = r0.zzjg()     // Catch:{ SQLiteFullException -> 0x0169, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x0167 }
            java.lang.String r12 = "Unknown record type in local database"
            r0.zzby(r12)     // Catch:{ SQLiteFullException -> 0x0169, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x0167 }
            goto L_0x006f
        L_0x0133:
            java.lang.String r0 = "messages"
            java.lang.String r12 = "rowid <= ?"
            java.lang.String[] r13 = new java.lang.String[r8]     // Catch:{ SQLiteFullException -> 0x0169, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x0167 }
            java.lang.String r10 = java.lang.Long.toString(r10)     // Catch:{ SQLiteFullException -> 0x0169, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x0167 }
            r13[r5] = r10     // Catch:{ SQLiteFullException -> 0x0169, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x0167 }
            int r0 = r4.delete(r0, r12, r13)     // Catch:{ SQLiteFullException -> 0x0169, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x0167 }
            int r10 = r3.size()     // Catch:{ SQLiteFullException -> 0x0169, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x0167 }
            if (r0 >= r10) goto L_0x0156
            com.google.android.gms.measurement.internal.zzas r0 = r18.zzgt()     // Catch:{ SQLiteFullException -> 0x0169, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x0167 }
            com.google.android.gms.measurement.internal.zzau r0 = r0.zzjg()     // Catch:{ SQLiteFullException -> 0x0169, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x0167 }
            java.lang.String r10 = "Fewer entries removed from local database than expected"
            r0.zzby(r10)     // Catch:{ SQLiteFullException -> 0x0169, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x0167 }
        L_0x0156:
            r4.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x0169, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x0167 }
            r4.endTransaction()     // Catch:{ SQLiteFullException -> 0x0169, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x0167 }
            if (r9 == 0) goto L_0x0161
            r9.close()
        L_0x0161:
            if (r4 == 0) goto L_0x0166
            r4.close()
        L_0x0166:
            return r3
        L_0x0167:
            r0 = move-exception
            goto L_0x0188
        L_0x0169:
            r0 = move-exception
            goto L_0x01c3
        L_0x016c:
            r0 = move-exception
            goto L_0x0174
        L_0x016e:
            r0 = move-exception
            goto L_0x0179
        L_0x0170:
            r0 = move-exception
            goto L_0x017f
        L_0x0172:
            r0 = move-exception
            r4 = r15
        L_0x0174:
            r9 = r2
            goto L_0x01e2
        L_0x0177:
            r0 = move-exception
            r4 = r15
        L_0x0179:
            r9 = r2
            goto L_0x0188
        L_0x017b:
            r9 = r2
            goto L_0x01af
        L_0x017d:
            r0 = move-exception
            r4 = r15
        L_0x017f:
            r9 = r2
            goto L_0x01c3
        L_0x0181:
            r0 = move-exception
            r4 = r2
            r9 = r4
            goto L_0x01e2
        L_0x0185:
            r0 = move-exception
            r4 = r2
            r9 = r4
        L_0x0188:
            if (r4 == 0) goto L_0x0193
            boolean r10 = r4.inTransaction()     // Catch:{ all -> 0x01e1 }
            if (r10 == 0) goto L_0x0193
            r4.endTransaction()     // Catch:{ all -> 0x01e1 }
        L_0x0193:
            com.google.android.gms.measurement.internal.zzas r10 = r18.zzgt()     // Catch:{ all -> 0x01e1 }
            com.google.android.gms.measurement.internal.zzau r10 = r10.zzjg()     // Catch:{ all -> 0x01e1 }
            java.lang.String r11 = "Error reading entries from local database"
            r10.zzg(r11, r0)     // Catch:{ all -> 0x01e1 }
            r1.zzaln = r8     // Catch:{ all -> 0x01e1 }
            if (r9 == 0) goto L_0x01a7
            r9.close()
        L_0x01a7:
            if (r4 == 0) goto L_0x01dc
            r4.close()
            goto L_0x01dc
        L_0x01ad:
            r4 = r2
            r9 = r4
        L_0x01af:
            long r10 = (long) r7
            android.os.SystemClock.sleep(r10)     // Catch:{ all -> 0x01e1 }
            int r7 = r7 + 20
            if (r9 == 0) goto L_0x01ba
            r9.close()
        L_0x01ba:
            if (r4 == 0) goto L_0x01dc
            r4.close()
            goto L_0x01dc
        L_0x01c0:
            r0 = move-exception
            r4 = r2
            r9 = r4
        L_0x01c3:
            com.google.android.gms.measurement.internal.zzas r10 = r18.zzgt()     // Catch:{ all -> 0x01e1 }
            com.google.android.gms.measurement.internal.zzau r10 = r10.zzjg()     // Catch:{ all -> 0x01e1 }
            java.lang.String r11 = "Error reading entries from local database"
            r10.zzg(r11, r0)     // Catch:{ all -> 0x01e1 }
            r1.zzaln = r8     // Catch:{ all -> 0x01e1 }
            if (r9 == 0) goto L_0x01d7
            r9.close()
        L_0x01d7:
            if (r4 == 0) goto L_0x01dc
            r4.close()
        L_0x01dc:
            int r6 = r6 + 1
            r4 = 5
            goto L_0x0028
        L_0x01e1:
            r0 = move-exception
        L_0x01e2:
            if (r9 == 0) goto L_0x01e7
            r9.close()
        L_0x01e7:
            if (r4 == 0) goto L_0x01ec
            r4.close()
        L_0x01ec:
            throw r0
        L_0x01ed:
            com.google.android.gms.measurement.internal.zzas r0 = r18.zzgt()
            com.google.android.gms.measurement.internal.zzau r0 = r0.zzjj()
            java.lang.String r3 = "Failed to read events from database in reasonable time"
            r0.zzby(r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzao.zzr(int):java.util.List");
    }

    @VisibleForTesting
    private final SQLiteDatabase getWritableDatabase() throws SQLiteException {
        if (this.zzaln) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.zzalm.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.zzaln = true;
        return null;
    }

    public final /* bridge */ /* synthetic */ void zzgf() {
        super.zzgf();
    }

    public final /* bridge */ /* synthetic */ void zzgg() {
        super.zzgg();
    }

    public final /* bridge */ /* synthetic */ void zzgh() {
        super.zzgh();
    }

    public final /* bridge */ /* synthetic */ void zzaf() {
        super.zzaf();
    }

    public final /* bridge */ /* synthetic */ zza zzgi() {
        return super.zzgi();
    }

    public final /* bridge */ /* synthetic */ zzda zzgj() {
        return super.zzgj();
    }

    public final /* bridge */ /* synthetic */ zzam zzgk() {
        return super.zzgk();
    }

    public final /* bridge */ /* synthetic */ zzeb zzgl() {
        return super.zzgl();
    }

    public final /* bridge */ /* synthetic */ zzdy zzgm() {
        return super.zzgm();
    }

    public final /* bridge */ /* synthetic */ zzao zzgn() {
        return super.zzgn();
    }

    public final /* bridge */ /* synthetic */ zzfd zzgo() {
        return super.zzgo();
    }

    public final /* bridge */ /* synthetic */ zzaa zzgp() {
        return super.zzgp();
    }

    public final /* bridge */ /* synthetic */ Clock zzbx() {
        return super.zzbx();
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public final /* bridge */ /* synthetic */ zzaq zzgq() {
        return super.zzgq();
    }

    public final /* bridge */ /* synthetic */ zzfy zzgr() {
        return super.zzgr();
    }

    public final /* bridge */ /* synthetic */ zzbr zzgs() {
        return super.zzgs();
    }

    public final /* bridge */ /* synthetic */ zzas zzgt() {
        return super.zzgt();
    }

    public final /* bridge */ /* synthetic */ zzbd zzgu() {
        return super.zzgu();
    }

    public final /* bridge */ /* synthetic */ zzq zzgv() {
        return super.zzgv();
    }

    public final /* bridge */ /* synthetic */ zzn zzgw() {
        return super.zzgw();
    }
}
