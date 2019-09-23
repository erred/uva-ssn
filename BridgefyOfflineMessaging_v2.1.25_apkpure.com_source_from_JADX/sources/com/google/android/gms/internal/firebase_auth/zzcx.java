package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzj.zzh;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.api.internal.zzff;

public final class zzcx implements zzff<zzh> {
    private String zzgc;
    private String zzgh;
    private String zzgw;
    private ActionCodeSettings zzig;
    private String zzpf;

    public zzcx(zzjo zzjo) {
        String str;
        switch (zzjo) {
            case PASSWORD_RESET:
                str = "PASSWORD_RESET";
                break;
            case VERIFY_EMAIL:
                str = "VERIFY_EMAIL";
                break;
            case EMAIL_SIGNIN:
                str = "EMAIL_SIGNIN";
                break;
            default:
                str = "REQUEST_TYPE_UNSET_ENUM_VALUE";
                break;
        }
        this.zzpf = str;
    }

    public final zzcx zzcb(String str) {
        this.zzgh = Preconditions.checkNotEmpty(str);
        return this;
    }

    public final zzcx zzcc(String str) {
        this.zzgc = Preconditions.checkNotEmpty(str);
        return this;
    }

    public final zzcx zza(ActionCodeSettings actionCodeSettings) {
        this.zzig = (ActionCodeSettings) Preconditions.checkNotNull(actionCodeSettings);
        return this;
    }

    public final zzcx zzcd(String str) {
        this.zzgw = str;
        return this;
    }

    public final ActionCodeSettings zzcq() {
        return this.zzig;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00de  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ com.google.android.gms.internal.firebase_auth.zzhc zzds() {
        /*
            r4 = this;
            com.google.android.gms.internal.firebase_auth.zzj$zzh$zza r0 = com.google.android.gms.internal.firebase_auth.zzj.zzh.zzz()
            java.lang.String r1 = r4.zzpf
            int r2 = r1.hashCode()
            r3 = -1452371317(0xffffffffa96e928b, float:-5.2973722E-14)
            if (r2 == r3) goto L_0x002e
            r3 = -1341836234(0xffffffffb0053436, float:-4.8459314E-10)
            if (r2 == r3) goto L_0x0024
            r3 = 870738373(0x33e669c5, float:1.0729449E-7)
            if (r2 == r3) goto L_0x001a
            goto L_0x0038
        L_0x001a:
            java.lang.String r2 = "EMAIL_SIGNIN"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0038
            r1 = 2
            goto L_0x0039
        L_0x0024:
            java.lang.String r2 = "VERIFY_EMAIL"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0038
            r1 = 1
            goto L_0x0039
        L_0x002e:
            java.lang.String r2 = "PASSWORD_RESET"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0038
            r1 = 0
            goto L_0x0039
        L_0x0038:
            r1 = -1
        L_0x0039:
            switch(r1) {
                case 0: goto L_0x0045;
                case 1: goto L_0x0042;
                case 2: goto L_0x003f;
                default: goto L_0x003c;
            }
        L_0x003c:
            com.google.android.gms.internal.firebase_auth.zzjo r1 = com.google.android.gms.internal.firebase_auth.zzjo.OOB_REQ_TYPE_UNSPECIFIED
            goto L_0x0047
        L_0x003f:
            com.google.android.gms.internal.firebase_auth.zzjo r1 = com.google.android.gms.internal.firebase_auth.zzjo.EMAIL_SIGNIN
            goto L_0x0047
        L_0x0042:
            com.google.android.gms.internal.firebase_auth.zzjo r1 = com.google.android.gms.internal.firebase_auth.zzjo.VERIFY_EMAIL
            goto L_0x0047
        L_0x0045:
            com.google.android.gms.internal.firebase_auth.zzjo r1 = com.google.android.gms.internal.firebase_auth.zzjo.PASSWORD_RESET
        L_0x0047:
            com.google.android.gms.internal.firebase_auth.zzj$zzh$zza r0 = r0.zzb(r1)
            java.lang.String r1 = r4.zzgh
            if (r1 == 0) goto L_0x0054
            java.lang.String r1 = r4.zzgh
            r0.zzv(r1)
        L_0x0054:
            java.lang.String r1 = r4.zzgc
            if (r1 == 0) goto L_0x005d
            java.lang.String r1 = r4.zzgc
            r0.zzw(r1)
        L_0x005d:
            com.google.firebase.auth.ActionCodeSettings r1 = r4.zzig
            if (r1 == 0) goto L_0x00da
            com.google.firebase.auth.ActionCodeSettings r1 = r4.zzig
            boolean r1 = r1.getAndroidInstallApp()
            com.google.android.gms.internal.firebase_auth.zzj$zzh$zza r1 = r0.zzc(r1)
            com.google.firebase.auth.ActionCodeSettings r2 = r4.zzig
            boolean r2 = r2.canHandleCodeInApp()
            r1.zzd(r2)
            com.google.firebase.auth.ActionCodeSettings r1 = r4.zzig
            java.lang.String r1 = r1.getUrl()
            if (r1 == 0) goto L_0x0085
            com.google.firebase.auth.ActionCodeSettings r1 = r4.zzig
            java.lang.String r1 = r1.getUrl()
            r0.zzx(r1)
        L_0x0085:
            com.google.firebase.auth.ActionCodeSettings r1 = r4.zzig
            java.lang.String r1 = r1.getIOSBundle()
            if (r1 == 0) goto L_0x0096
            com.google.firebase.auth.ActionCodeSettings r1 = r4.zzig
            java.lang.String r1 = r1.getIOSBundle()
            r0.zzy(r1)
        L_0x0096:
            com.google.firebase.auth.ActionCodeSettings r1 = r4.zzig
            java.lang.String r1 = r1.zzbt()
            if (r1 == 0) goto L_0x00a7
            com.google.firebase.auth.ActionCodeSettings r1 = r4.zzig
            java.lang.String r1 = r1.zzbt()
            r0.zzz(r1)
        L_0x00a7:
            com.google.firebase.auth.ActionCodeSettings r1 = r4.zzig
            java.lang.String r1 = r1.getAndroidPackageName()
            if (r1 == 0) goto L_0x00b8
            com.google.firebase.auth.ActionCodeSettings r1 = r4.zzig
            java.lang.String r1 = r1.getAndroidPackageName()
            r0.zzaa(r1)
        L_0x00b8:
            com.google.firebase.auth.ActionCodeSettings r1 = r4.zzig
            java.lang.String r1 = r1.getAndroidMinimumVersion()
            if (r1 == 0) goto L_0x00c9
            com.google.firebase.auth.ActionCodeSettings r1 = r4.zzig
            java.lang.String r1 = r1.getAndroidMinimumVersion()
            r0.zzab(r1)
        L_0x00c9:
            com.google.firebase.auth.ActionCodeSettings r1 = r4.zzig
            java.lang.String r1 = r1.zzbv()
            if (r1 == 0) goto L_0x00da
            com.google.firebase.auth.ActionCodeSettings r1 = r4.zzig
            java.lang.String r1 = r1.zzbv()
            r0.zzad(r1)
        L_0x00da:
            java.lang.String r1 = r4.zzgw
            if (r1 == 0) goto L_0x00e3
            java.lang.String r1 = r4.zzgw
            r0.zzac(r1)
        L_0x00e3:
            com.google.android.gms.internal.firebase_auth.zzhc r0 = r0.zzhn()
            com.google.android.gms.internal.firebase_auth.zzft r0 = (com.google.android.gms.internal.firebase_auth.zzft) r0
            com.google.android.gms.internal.firebase_auth.zzj$zzh r0 = (com.google.android.gms.internal.firebase_auth.zzj.zzh) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzcx.zzds():com.google.android.gms.internal.firebase_auth.zzhc");
    }
}
