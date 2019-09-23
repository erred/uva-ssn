package com.google.firebase.auth.api.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzci;
import com.google.android.gms.internal.firebase_auth.zzcj;
import com.google.android.gms.internal.firebase_auth.zzcm;
import com.google.android.gms.internal.firebase_auth.zzcn;
import com.google.android.gms.internal.firebase_auth.zzcp;
import com.google.android.gms.internal.firebase_auth.zzcq;
import com.google.android.gms.internal.firebase_auth.zzcr;
import com.google.android.gms.internal.firebase_auth.zzct;
import com.google.android.gms.internal.firebase_auth.zzcx;
import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.android.gms.internal.firebase_auth.zzdf;
import com.google.android.gms.internal.firebase_auth.zzdg;
import com.google.android.gms.internal.firebase_auth.zzdl;
import com.google.android.gms.internal.firebase_auth.zzdm;
import com.google.android.gms.internal.firebase_auth.zzdn;
import com.google.android.gms.internal.firebase_auth.zzdo;
import com.google.android.gms.internal.firebase_auth.zzdr;
import com.google.android.gms.internal.firebase_auth.zzdt;
import com.google.android.gms.internal.firebase_auth.zzdu;
import com.google.android.gms.internal.firebase_auth.zzdv;
import com.google.android.gms.internal.firebase_auth.zzdx;
import com.google.android.gms.internal.firebase_auth.zzdy;
import com.google.android.gms.internal.firebase_auth.zzjo;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.zzd;

public final class zza {
    /* access modifiers changed from: private */
    public final zzex zzip;
    /* access modifiers changed from: private */
    public final zzdu zziq;

    public zza(zzex zzex, zzdu zzdu) {
        this.zzip = (zzex) Preconditions.checkNotNull(zzex);
        this.zziq = (zzdu) Preconditions.checkNotNull(zzdu);
    }

    public final void zza(String str, zzdp zzdp) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzdp);
        this.zzip.zza(new zzcp(str), (zzez<zzcz>) new zzb<zzcz>(this, zzdp));
    }

    public final void zzb(String str, zzdp zzdp) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzdp);
        this.zzip.zza(new zzdu(str), (zzez<zzdv>) new zzm<zzdv>(this, zzdp));
    }

    public final void zza(zzdr zzdr, zzdp zzdp) {
        Preconditions.checkNotNull(zzdr);
        Preconditions.checkNotNull(zzdp);
        if (this.zziq.zzdi().booleanValue()) {
            zzdr.zzq(this.zziq.zzdi().booleanValue());
        }
        this.zzip.zza(zzdr, (zzez<zzdt>) new zzx<zzdt>(this, zzdp));
    }

    public final void zzc(String str, zzdp zzdp) {
        Preconditions.checkNotNull(zzdp);
        this.zzip.zza(new zzdn(str), (zzez<zzdo>) new zzab<zzdo>(this, zzdp));
    }

    public final void zza(String str, UserProfileChangeRequest userProfileChangeRequest, zzdp zzdp) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(userProfileChangeRequest);
        Preconditions.checkNotNull(zzdp);
        zza(str, (zzez<zzcz>) new zzac<zzcz>(this, userProfileChangeRequest, zzdp));
    }

    public final void zza(String str, String str2, zzdp zzdp) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzdp);
        zza(str, (zzez<zzcz>) new zzad<zzcz>(this, str2, zzdp));
    }

    public final void zzb(String str, String str2, zzdp zzdp) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzdp);
        zza(str, (zzez<zzcz>) new zzae<zzcz>(this, str2, zzdp));
    }

    public final void zzc(String str, String str2, zzdp zzdp) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzdp);
        zzdl zzdl = new zzdl();
        zzdl.zzco(str);
        zzdl.zzcp(str2);
        this.zzip.zza(zzdl, (zzez<zzdm>) new zzaf<zzdm>(this, zzdp));
    }

    private final void zza(String str, zzez<zzcz> zzez) {
        Preconditions.checkNotNull(zzez);
        Preconditions.checkNotEmpty(str);
        zzcz zzcf = zzcz.zzcf(str);
        if (zzcf.isValid()) {
            zzez.onSuccess(zzcf);
            return;
        }
        this.zzip.zza(new zzcp(zzcf.zzr()), (zzez<zzcz>) new zzag<zzcz>(this, zzez));
    }

    public final void zza(String str, String str2, String str3, zzdp zzdp) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzdp);
        this.zzip.zza(new zzdn(str, str2, null, str3), (zzez<zzdo>) new zzc<zzdo>(this, zzdp));
    }

    public final void zzb(String str, String str2, String str3, zzdp zzdp) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzdp);
        this.zzip.zza(new zzdx(str, str2, str3), (zzez<zzdy>) new zzd<zzdy>(this, zzdp));
    }

    public final void zza(EmailAuthCredential emailAuthCredential, zzdp zzdp) {
        Preconditions.checkNotNull(emailAuthCredential);
        Preconditions.checkNotNull(zzdp);
        if (emailAuthCredential.zzby()) {
            zza(emailAuthCredential.zzbx(), (zzez<zzcz>) new zze<zzcz>(this, emailAuthCredential, zzdp));
        } else {
            zza(new zzcm(emailAuthCredential, null), zzdp);
        }
    }

    /* access modifiers changed from: private */
    public final void zza(zzcm zzcm, zzdp zzdp) {
        Preconditions.checkNotNull(zzcm);
        Preconditions.checkNotNull(zzdp);
        this.zzip.zza(zzcm, (zzez<zzcn>) new zzf<zzcn>(this, zzdp));
    }

    /* access modifiers changed from: private */
    public final void zza(zzdp zzdp, zzcz zzcz, zzdl zzdl, zzey zzey) {
        Preconditions.checkNotNull(zzdp);
        Preconditions.checkNotNull(zzcz);
        Preconditions.checkNotNull(zzdl);
        Preconditions.checkNotNull(zzey);
        zzcq zzcq = new zzcq(zzcz.zzdw());
        zzex zzex = this.zzip;
        zzg zzg = new zzg(this, zzey, zzdp, zzcz, zzdl);
        zzex.zza(zzcq, (zzez<zzcr>) zzg);
    }

    /* access modifiers changed from: private */
    public final void zza(zzdp zzdp, zzcz zzcz, zzct zzct, zzdl zzdl, zzey zzey) {
        Preconditions.checkNotNull(zzdp);
        Preconditions.checkNotNull(zzcz);
        Preconditions.checkNotNull(zzct);
        Preconditions.checkNotNull(zzdl);
        Preconditions.checkNotNull(zzey);
        zzex zzex = this.zzip;
        zzh zzh = new zzh(this, zzdl, zzct, zzdp, zzcz, zzey);
        zzex.zza(zzdl, (zzez<zzdm>) zzh);
    }

    /* access modifiers changed from: private */
    public static zzcz zza(zzcz zzcz, zzdm zzdm) {
        Preconditions.checkNotNull(zzcz);
        Preconditions.checkNotNull(zzdm);
        String idToken = zzdm.getIdToken();
        String zzr = zzdm.zzr();
        return (TextUtils.isEmpty(idToken) || TextUtils.isEmpty(zzr)) ? zzcz : new zzcz(zzr, idToken, Long.valueOf(zzdm.zzs()), zzcz.zzdx());
    }

    /* access modifiers changed from: private */
    public final void zza(zzcz zzcz, String str, String str2, Boolean bool, zzd zzd, zzdp zzdp, zzey zzey) {
        Preconditions.checkNotNull(zzcz);
        Preconditions.checkNotNull(zzey);
        Preconditions.checkNotNull(zzdp);
        zzcq zzcq = new zzcq(zzcz.zzdw());
        zzex zzex = this.zzip;
        zzi zzi = new zzi(this, zzey, str2, str, bool, zzd, zzdp, zzcz);
        zzex.zza(zzcq, (zzez<zzcr>) zzi);
    }

    public final void zzd(String str, String str2, zzdp zzdp) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzdp);
        this.zzip.zza(new zzci(str, str2), (zzez<zzcj>) new zzj<zzcj>(this, zzdp));
    }

    public final void zza(String str, ActionCodeSettings actionCodeSettings, String str2, zzdp zzdp) {
        zzcx zzcx;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzdp);
        zzjo zzbg = zzjo.zzbg(actionCodeSettings.getRequestType());
        if (zzbg != null) {
            zzcx = new zzcx(zzbg);
        } else {
            zzcx = new zzcx(zzjo.OOB_REQ_TYPE_UNSPECIFIED);
        }
        zzcx.zzcb(str);
        zzcx.zza(actionCodeSettings);
        zzcx.zzcd(str2);
        this.zzip.zza(zzcx, (zzez<Object>) new zzk<Object>(this, zzdp));
    }

    public final void zza(String str, ActionCodeSettings actionCodeSettings, zzdp zzdp) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzdp);
        zzcx zzcx = new zzcx(zzjo.VERIFY_EMAIL);
        zzcx.zzcc(str);
        if (actionCodeSettings != null) {
            zzcx.zza(actionCodeSettings);
        }
        this.zzip.zza(zzcx, (zzez<Object>) new zzl<Object>(this, zzdp));
    }

    public final void zze(String str, String str2, zzdp zzdp) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzdp);
        this.zzip.zza(new zzdf(str, null, str2), (zzez<zzdg>) new zzn<zzdg>(this, zzdp));
    }

    public final void zzc(String str, String str2, String str3, zzdp zzdp) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzdp);
        this.zzip.zza(new zzdf(str, str2, str3), (zzez<zzdg>) new zzo<zzdg>(this, zzdp));
    }

    public final void zzd(String str, String str2, String str3, zzdp zzdp) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzdp);
        zza(str3, (zzez<zzcz>) new zzp<zzcz>(this, str, str2, zzdp));
    }

    public final void zza(String str, zzdr zzdr, zzdp zzdp) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzdr);
        Preconditions.checkNotNull(zzdp);
        zza(str, (zzez<zzcz>) new zzq<zzcz>(this, zzdr, zzdp));
    }

    public final void zzd(String str, zzdp zzdp) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzdp);
        zza(str, (zzez<zzcz>) new zzs<zzcz>(this, zzdp));
    }

    public final void zzf(String str, String str2, zzdp zzdp) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzdp);
        zza(str2, (zzez<zzcz>) new zzt<zzcz>(this, str, zzdp));
    }

    public final void zze(String str, zzdp zzdp) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzdp);
        zza(str, (zzez<zzcz>) new zzv<zzcz>(this, zzdp));
    }

    public final void zzf(String str, zzdp zzdp) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzdp);
        zza(str, (zzez<zzcz>) new zzy<zzcz>(this, zzdp));
    }

    public final void zzg(String str, zzdp zzdp) {
        Preconditions.checkNotNull(zzdp);
        this.zzip.zzb(str, new zzaa(this, zzdp));
    }
}
