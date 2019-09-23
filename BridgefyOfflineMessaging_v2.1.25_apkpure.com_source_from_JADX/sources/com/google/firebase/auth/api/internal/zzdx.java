package com.google.firebase.auth.api.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.firebase_auth.zzcg;
import com.google.android.gms.internal.firebase_auth.zzcj;
import com.google.android.gms.internal.firebase_auth.zzct;
import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.android.gms.internal.firebase_auth.zzdg;
import com.google.firebase.auth.PhoneAuthCredential;

public interface zzdx extends IInterface {
    void onFailure(Status status) throws RemoteException;

    void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) throws RemoteException;

    void zza(Status status, PhoneAuthCredential phoneAuthCredential) throws RemoteException;

    void zza(zzcg zzcg) throws RemoteException;

    void zza(zzcj zzcj) throws RemoteException;

    void zza(zzcz zzcz, zzct zzct) throws RemoteException;

    void zza(zzdg zzdg) throws RemoteException;

    void zzb(zzcz zzcz) throws RemoteException;

    void zzbs(String str) throws RemoteException;

    void zzbt(String str) throws RemoteException;

    void zzbu(String str) throws RemoteException;

    void zzde() throws RemoteException;

    void zzdf() throws RemoteException;

    void zzdg() throws RemoteException;
}
