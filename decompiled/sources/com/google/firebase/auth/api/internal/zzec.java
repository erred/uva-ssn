package com.google.firebase.auth.api.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.firebase_auth.zza;
import com.google.android.gms.internal.firebase_auth.zzag;
import com.google.android.gms.internal.firebase_auth.zzai;
import com.google.android.gms.internal.firebase_auth.zzak;
import com.google.android.gms.internal.firebase_auth.zzam;
import com.google.android.gms.internal.firebase_auth.zzao;
import com.google.android.gms.internal.firebase_auth.zzaq;
import com.google.android.gms.internal.firebase_auth.zzas;
import com.google.android.gms.internal.firebase_auth.zzau;
import com.google.android.gms.internal.firebase_auth.zzaw;
import com.google.android.gms.internal.firebase_auth.zzay;
import com.google.android.gms.internal.firebase_auth.zzba;
import com.google.android.gms.internal.firebase_auth.zzbc;
import com.google.android.gms.internal.firebase_auth.zzbe;
import com.google.android.gms.internal.firebase_auth.zzbg;
import com.google.android.gms.internal.firebase_auth.zzbi;
import com.google.android.gms.internal.firebase_auth.zzbk;
import com.google.android.gms.internal.firebase_auth.zzbm;
import com.google.android.gms.internal.firebase_auth.zzbo;
import com.google.android.gms.internal.firebase_auth.zzbq;
import com.google.android.gms.internal.firebase_auth.zzbs;
import com.google.android.gms.internal.firebase_auth.zzbu;
import com.google.android.gms.internal.firebase_auth.zzbw;
import com.google.android.gms.internal.firebase_auth.zzby;
import com.google.android.gms.internal.firebase_auth.zzc;
import com.google.android.gms.internal.firebase_auth.zzca;
import com.google.android.gms.internal.firebase_auth.zzcc;
import com.google.android.gms.internal.firebase_auth.zzce;
import com.google.android.gms.internal.firebase_auth.zzdj;
import com.google.android.gms.internal.firebase_auth.zzdr;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.UserProfileChangeRequest;

public final class zzec extends zza implements zzea {
    zzec(IBinder iBinder) {
        super(iBinder, "com.google.firebase.auth.api.internal.IFirebaseAuthService");
    }

    public final void zza(String str, zzdx zzdx) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc.zza(zza, (IInterface) zzdx);
        zza(1, zza);
    }

    public final void zzb(String str, zzdx zzdx) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc.zza(zza, (IInterface) zzdx);
        zza(2, zza);
    }

    public final void zza(zzdr zzdr, zzdx zzdx) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) zzdr);
        zzc.zza(zza, (IInterface) zzdx);
        zza(3, zza);
    }

    public final void zza(String str, UserProfileChangeRequest userProfileChangeRequest, zzdx zzdx) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc.zza(zza, (Parcelable) userProfileChangeRequest);
        zzc.zza(zza, (IInterface) zzdx);
        zza(4, zza);
    }

    public final void zza(String str, String str2, zzdx zzdx) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzc.zza(zza, (IInterface) zzdx);
        zza(5, zza);
    }

    public final void zzb(String str, String str2, zzdx zzdx) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzc.zza(zza, (IInterface) zzdx);
        zza(6, zza);
    }

    public final void zzc(String str, String str2, zzdx zzdx) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzc.zza(zza, (IInterface) zzdx);
        zza(7, zza);
    }

    public final void zzd(String str, String str2, zzdx zzdx) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzc.zza(zza, (IInterface) zzdx);
        zza(8, zza);
    }

    public final void zzc(String str, zzdx zzdx) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc.zza(zza, (IInterface) zzdx);
        zza(9, zza);
    }

    public final void zzd(String str, zzdx zzdx) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc.zza(zza, (IInterface) zzdx);
        zza(10, zza);
    }

    public final void zza(String str, String str2, String str3, zzdx zzdx) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zza.writeString(str3);
        zzc.zza(zza, (IInterface) zzdx);
        zza(11, zza);
    }

    public final void zza(String str, zzdr zzdr, zzdx zzdx) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc.zza(zza, (Parcelable) zzdr);
        zzc.zza(zza, (IInterface) zzdx);
        zza(12, zza);
    }

    public final void zze(String str, zzdx zzdx) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc.zza(zza, (IInterface) zzdx);
        zza(13, zza);
    }

    public final void zze(String str, String str2, zzdx zzdx) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzc.zza(zza, (IInterface) zzdx);
        zza(14, zza);
    }

    public final void zzf(String str, zzdx zzdx) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc.zza(zza, (IInterface) zzdx);
        zza(15, zza);
    }

    public final void zza(zzdx zzdx) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzdx);
        zza(16, zza);
    }

    public final void zzg(String str, zzdx zzdx) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc.zza(zza, (IInterface) zzdx);
        zza(17, zza);
    }

    public final void zzh(String str, zzdx zzdx) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc.zza(zza, (IInterface) zzdx);
        zza(18, zza);
    }

    public final void zzi(String str, zzdx zzdx) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc.zza(zza, (IInterface) zzdx);
        zza(19, zza);
    }

    public final void zzj(String str, zzdx zzdx) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc.zza(zza, (IInterface) zzdx);
        zza(20, zza);
    }

    public final void zzf(String str, String str2, zzdx zzdx) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzc.zza(zza, (IInterface) zzdx);
        zza(21, zza);
    }

    public final void zza(zzdj zzdj, zzdx zzdx) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) zzdj);
        zzc.zza(zza, (IInterface) zzdx);
        zza(22, zza);
    }

    public final void zza(PhoneAuthCredential phoneAuthCredential, zzdx zzdx) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) phoneAuthCredential);
        zzc.zza(zza, (IInterface) zzdx);
        zza(23, zza);
    }

    public final void zza(String str, PhoneAuthCredential phoneAuthCredential, zzdx zzdx) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc.zza(zza, (Parcelable) phoneAuthCredential);
        zzc.zza(zza, (IInterface) zzdx);
        zza(24, zza);
    }

    public final void zza(String str, ActionCodeSettings actionCodeSettings, zzdx zzdx) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc.zza(zza, (Parcelable) actionCodeSettings);
        zzc.zza(zza, (IInterface) zzdx);
        zza(25, zza);
    }

    public final void zzb(String str, ActionCodeSettings actionCodeSettings, zzdx zzdx) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc.zza(zza, (Parcelable) actionCodeSettings);
        zzc.zza(zza, (IInterface) zzdx);
        zza(26, zza);
    }

    public final void zzk(String str, zzdx zzdx) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc.zza(zza, (IInterface) zzdx);
        zza(27, zza);
    }

    public final void zzc(String str, ActionCodeSettings actionCodeSettings, zzdx zzdx) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc.zza(zza, (Parcelable) actionCodeSettings);
        zzc.zza(zza, (IInterface) zzdx);
        zza(28, zza);
    }

    public final void zza(EmailAuthCredential emailAuthCredential, zzdx zzdx) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) emailAuthCredential);
        zzc.zza(zza, (IInterface) zzdx);
        zza(29, zza);
    }

    public final void zza(zzau zzau, zzdx zzdx) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) zzau);
        zzc.zza(zza, (IInterface) zzdx);
        zza(101, zza);
    }

    public final void zza(zzbs zzbs, zzdx zzdx) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) zzbs);
        zzc.zza(zza, (IInterface) zzdx);
        zza(102, zza);
    }

    public final void zza(zzbq zzbq, zzdx zzdx) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) zzbq);
        zzc.zza(zza, (IInterface) zzdx);
        zza(103, zza);
    }

    public final void zza(zzce zzce, zzdx zzdx) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) zzce);
        zzc.zza(zza, (IInterface) zzdx);
        zza(104, zza);
    }

    public final void zza(zzai zzai, zzdx zzdx) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) zzai);
        zzc.zza(zza, (IInterface) zzdx);
        zza(105, zza);
    }

    public final void zza(zzak zzak, zzdx zzdx) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) zzak);
        zzc.zza(zza, (IInterface) zzdx);
        zza(106, zza);
    }

    public final void zza(zzaq zzaq, zzdx zzdx) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) zzaq);
        zzc.zza(zza, (IInterface) zzdx);
        zza(107, zza);
    }

    public final void zza(zzbu zzbu, zzdx zzdx) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) zzbu);
        zzc.zza(zza, (IInterface) zzdx);
        zza(108, zza);
    }

    public final void zza(zzaw zzaw, zzdx zzdx) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) zzaw);
        zzc.zza(zza, (IInterface) zzdx);
        zza(109, zza);
    }

    public final void zza(zzay zzay, zzdx zzdx) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) zzay);
        zzc.zza(zza, (IInterface) zzdx);
        zza(111, zza);
    }

    public final void zza(zzba zzba, zzdx zzdx) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) zzba);
        zzc.zza(zza, (IInterface) zzdx);
        zza(112, zza);
    }

    public final void zza(zzca zzca, zzdx zzdx) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) zzca);
        zzc.zza(zza, (IInterface) zzdx);
        zza(113, zza);
    }

    public final void zza(zzcc zzcc, zzdx zzdx) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) zzcc);
        zzc.zza(zza, (IInterface) zzdx);
        zza(114, zza);
    }

    public final void zza(zzbe zzbe, zzdx zzdx) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) zzbe);
        zzc.zza(zza, (IInterface) zzdx);
        zza(115, zza);
    }

    public final void zza(zzbo zzbo, zzdx zzdx) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) zzbo);
        zzc.zza(zza, (IInterface) zzdx);
        zza(116, zza);
    }

    public final void zza(zzas zzas, zzdx zzdx) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) zzas);
        zzc.zza(zza, (IInterface) zzdx);
        zza(117, zza);
    }

    public final void zza(zzam zzam, zzdx zzdx) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) zzam);
        zzc.zza(zza, (IInterface) zzdx);
        zza(119, zza);
    }

    public final void zza(zzag zzag, zzdx zzdx) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) zzag);
        zzc.zza(zza, (IInterface) zzdx);
        zza(120, zza);
    }

    public final void zza(zzao zzao, zzdx zzdx) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) zzao);
        zzc.zza(zza, (IInterface) zzdx);
        zza(121, zza);
    }

    public final void zza(zzbk zzbk, zzdx zzdx) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) zzbk);
        zzc.zza(zza, (IInterface) zzdx);
        zza(122, zza);
    }

    public final void zza(zzby zzby, zzdx zzdx) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) zzby);
        zzc.zza(zza, (IInterface) zzdx);
        zza(123, zza);
    }

    public final void zza(zzbc zzbc, zzdx zzdx) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) zzbc);
        zzc.zza(zza, (IInterface) zzdx);
        zza(124, zza);
    }

    public final void zza(zzbg zzbg, zzdx zzdx) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) zzbg);
        zzc.zza(zza, (IInterface) zzdx);
        zza(126, zza);
    }

    public final void zza(zzbm zzbm, zzdx zzdx) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) zzbm);
        zzc.zza(zza, (IInterface) zzdx);
        zza(127, zza);
    }

    public final void zza(zzbi zzbi, zzdx zzdx) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) zzbi);
        zzc.zza(zza, (IInterface) zzdx);
        zza(128, zza);
    }

    public final void zza(zzbw zzbw, zzdx zzdx) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) zzbw);
        zzc.zza(zza, (IInterface) zzdx);
        zza(129, zza);
    }
}
