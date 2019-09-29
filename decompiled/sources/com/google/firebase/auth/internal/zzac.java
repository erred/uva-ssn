package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.firebase_auth.zzdr;
import com.google.android.gms.internal.firebase_auth.zzz;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

public final class zzac {
    private static long zzrr = 3600000;
    private static final zzz<String> zzrs = zzz.zza("firebaseAppName", "firebaseUserUid", "operation", "tenantId", "verifyAssertionRequest", "statusCode", "statusMessage", Param.TIMESTAMP);
    private static final zzac zzrt = new zzac();
    private Task<AuthResult> zzru;
    private long zzrv = 0;

    private zzac() {
    }

    public static zzac zzen() {
        return zzrt;
    }

    public static void zza(Context context, zzdr zzdr, String str, String str2) {
        Editor edit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        edit.putString("verifyAssertionRequest", SafeParcelableSerializer.serializeToString(zzdr));
        edit.putString("operation", str);
        edit.putString("tenantId", str2);
        edit.putLong(Param.TIMESTAMP, DefaultClock.getInstance().currentTimeMillis());
        edit.commit();
    }

    public static void zza(Context context, Status status) {
        Editor edit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        edit.putInt("statusCode", status.getStatusCode());
        edit.putString("statusMessage", status.getStatusMessage());
        edit.putLong(Param.TIMESTAMP, DefaultClock.getInstance().currentTimeMillis());
        edit.commit();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0085, code lost:
        if (r5.equals("com.google.firebase.auth.internal.SIGN_IN") == false) goto L_0x009c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00e3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzh(com.google.firebase.auth.FirebaseAuth r11) {
        /*
            r10 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r11)
            com.google.firebase.FirebaseApp r0 = r11.zzcc()
            android.content.Context r0 = r0.getApplicationContext()
            java.lang.String r1 = "com.google.firebase.auth.internal.ProcessDeathHelper"
            r2 = 0
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r1, r2)
            java.lang.String r1 = "firebaseAppName"
            java.lang.String r3 = ""
            java.lang.String r1 = r0.getString(r1, r3)
            com.google.firebase.FirebaseApp r3 = r11.zzcc()
            java.lang.String r3 = r3.getName()
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x0029
            return
        L_0x0029:
            java.lang.String r1 = "verifyAssertionRequest"
            boolean r1 = r0.contains(r1)
            r3 = 0
            if (r1 == 0) goto L_0x00f1
            java.lang.String r1 = "verifyAssertionRequest"
            java.lang.String r5 = ""
            java.lang.String r1 = r0.getString(r1, r5)
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzdr> r5 = com.google.android.gms.internal.firebase_auth.zzdr.CREATOR
            com.google.android.gms.common.internal.safeparcel.SafeParcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer.deserializeFromString(r1, r5)
            com.google.android.gms.internal.firebase_auth.zzdr r1 = (com.google.android.gms.internal.firebase_auth.zzdr) r1
            java.lang.String r5 = "operation"
            java.lang.String r6 = ""
            java.lang.String r5 = r0.getString(r5, r6)
            java.lang.String r6 = "tenantId"
            r7 = 0
            java.lang.String r6 = r0.getString(r6, r7)
            java.lang.String r8 = "firebaseUserUid"
            java.lang.String r9 = ""
            java.lang.String r8 = r0.getString(r8, r9)
            java.lang.String r9 = "timestamp"
            long r3 = r0.getLong(r9, r3)
            r10.zzrv = r3
            if (r6 == 0) goto L_0x006a
            r11.zzc(r6)
            r1.zzcr(r6)
        L_0x006a:
            r3 = -1
            int r4 = r5.hashCode()
            r6 = -1843829902(0xffffffff92196372, float:-4.8400863E-28)
            if (r4 == r6) goto L_0x0092
            r6 = -286760092(0xffffffffeee86364, float:-3.596034E28)
            if (r4 == r6) goto L_0x0088
            r6 = 1731327805(0x6731f73d, float:8.404196E23)
            if (r4 == r6) goto L_0x007f
            goto L_0x009c
        L_0x007f:
            java.lang.String r4 = "com.google.firebase.auth.internal.SIGN_IN"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x009c
            goto L_0x009d
        L_0x0088:
            java.lang.String r2 = "com.google.firebase.auth.internal.LINK"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x009c
            r2 = 1
            goto L_0x009d
        L_0x0092:
            java.lang.String r2 = "com.google.firebase.auth.internal.REAUTHENTICATE"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x009c
            r2 = 2
            goto L_0x009d
        L_0x009c:
            r2 = -1
        L_0x009d:
            switch(r2) {
                case 0: goto L_0x00e3;
                case 1: goto L_0x00c3;
                case 2: goto L_0x00a3;
                default: goto L_0x00a0;
            }
        L_0x00a0:
            r10.zzru = r7
            goto L_0x00ed
        L_0x00a3:
            com.google.firebase.auth.FirebaseUser r2 = r11.getCurrentUser()
            java.lang.String r2 = r2.getUid()
            boolean r2 = r2.equals(r8)
            if (r2 == 0) goto L_0x00c0
            com.google.firebase.auth.FirebaseUser r11 = r11.getCurrentUser()
            com.google.firebase.auth.zzd r1 = com.google.firebase.auth.zzd.zza(r1)
            com.google.android.gms.tasks.Task r11 = r11.reauthenticateAndRetrieveData(r1)
            r10.zzru = r11
            goto L_0x00ed
        L_0x00c0:
            r10.zzru = r7
            goto L_0x00ed
        L_0x00c3:
            com.google.firebase.auth.FirebaseUser r2 = r11.getCurrentUser()
            java.lang.String r2 = r2.getUid()
            boolean r2 = r2.equals(r8)
            if (r2 == 0) goto L_0x00e0
            com.google.firebase.auth.FirebaseUser r11 = r11.getCurrentUser()
            com.google.firebase.auth.zzd r1 = com.google.firebase.auth.zzd.zza(r1)
            com.google.android.gms.tasks.Task r11 = r11.linkWithCredential(r1)
            r10.zzru = r11
            goto L_0x00ed
        L_0x00e0:
            r10.zzru = r7
            goto L_0x00ed
        L_0x00e3:
            com.google.firebase.auth.zzd r1 = com.google.firebase.auth.zzd.zza(r1)
            com.google.android.gms.tasks.Task r11 = r11.signInWithCredential(r1)
            r10.zzru = r11
        L_0x00ed:
            zza(r0)
            return
        L_0x00f1:
            java.lang.String r11 = "statusCode"
            boolean r11 = r0.contains(r11)
            if (r11 == 0) goto L_0x0124
            java.lang.String r11 = "statusCode"
            r1 = 17062(0x42a6, float:2.3909E-41)
            int r11 = r0.getInt(r11, r1)
            java.lang.String r1 = "statusMessage"
            java.lang.String r2 = ""
            java.lang.String r1 = r0.getString(r1, r2)
            com.google.android.gms.common.api.Status r2 = new com.google.android.gms.common.api.Status
            r2.<init>(r11, r1)
            java.lang.String r11 = "timestamp"
            long r3 = r0.getLong(r11, r3)
            r10.zzrv = r3
            zza(r0)
            com.google.firebase.FirebaseException r11 = com.google.firebase.auth.api.internal.zzds.zzb(r2)
            com.google.android.gms.tasks.Task r11 = com.google.android.gms.tasks.Tasks.forException(r11)
            r10.zzru = r11
            return
        L_0x0124:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.internal.zzac.zzh(com.google.firebase.auth.FirebaseAuth):void");
    }

    public final void zza(Context context) {
        Preconditions.checkNotNull(context);
        zza(context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0));
        this.zzru = null;
        this.zzrv = 0;
    }

    private static void zza(SharedPreferences sharedPreferences) {
        Editor edit = sharedPreferences.edit();
        zzz zzz = zzrs;
        int size = zzz.size();
        int i = 0;
        while (i < size) {
            Object obj = zzz.get(i);
            i++;
            edit.remove((String) obj);
        }
        edit.commit();
    }
}
