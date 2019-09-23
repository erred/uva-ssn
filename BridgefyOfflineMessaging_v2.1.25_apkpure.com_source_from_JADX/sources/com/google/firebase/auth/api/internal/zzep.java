package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzcg;
import com.google.android.gms.internal.firebase_auth.zzcj;
import com.google.android.gms.internal.firebase_auth.zzct;
import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.android.gms.internal.firebase_auth.zzdg;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.PhoneAuthCredential;

@VisibleForTesting
final class zzep extends zzdy {
    final /* synthetic */ zzeo zznx;

    zzep(zzeo zzeo) {
        this.zznx = zzeo;
    }

    public final void zzb(zzcz zzcz) throws RemoteException {
        boolean z = true;
        if (this.zznx.zznb != 1) {
            z = false;
        }
        int i = this.zznx.zznb;
        StringBuilder sb = new StringBuilder(37);
        sb.append("Unexpected response type: ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        this.zznx.zznk = zzcz;
        this.zznx.zzdp();
    }

    public final void zza(zzcz zzcz, zzct zzct) throws RemoteException {
        boolean z = this.zznx.zznb == 2;
        int i = this.zznx.zznb;
        StringBuilder sb = new StringBuilder(37);
        sb.append("Unexpected response type: ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        this.zznx.zznk = zzcz;
        this.zznx.zznl = zzct;
        this.zznx.zzdp();
    }

    public final void zza(zzcj zzcj) throws RemoteException {
        boolean z = this.zznx.zznb == 3;
        int i = this.zznx.zznb;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        this.zznx.zznm = zzcj;
        this.zznx.zzdp();
    }

    public final void zza(zzdg zzdg) throws RemoteException {
        boolean z = this.zznx.zznb == 4;
        int i = this.zznx.zznb;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        this.zznx.zznn = zzdg;
        this.zznx.zzdp();
    }

    public final void zzde() throws RemoteException {
        boolean z = this.zznx.zznb == 5;
        int i = this.zznx.zznb;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        this.zznx.zzdp();
    }

    public final void zzdf() throws RemoteException {
        boolean z = this.zznx.zznb == 6;
        int i = this.zznx.zznb;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        this.zznx.zzdp();
    }

    public final void zzbs(String str) throws RemoteException {
        boolean z = this.zznx.zznb == 7;
        int i = this.zznx.zznb;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        this.zznx.zzno = str;
        this.zznx.zzdp();
    }

    public final void zzbt(String str) throws RemoteException {
        boolean z = this.zznx.zznb == 8;
        int i = this.zznx.zznb;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        this.zznx.zzhn = str;
        zza((zzev) new zzeq(this, str));
    }

    public final void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        boolean z = this.zznx.zznb == 8;
        int i = this.zznx.zznb;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        this.zznx.zzns = true;
        this.zznx.zznt = true;
        zza((zzev) new zzer(this, phoneAuthCredential));
    }

    public final void zzbu(String str) throws RemoteException {
        boolean z = this.zznx.zznb == 8;
        int i = this.zznx.zznb;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        this.zznx.zzhn = str;
        this.zznx.zzns = true;
        this.zznx.zznt = true;
        zza((zzev) new zzes(this, str));
    }

    public final void onFailure(Status status) throws RemoteException {
        if (this.zznx.zznb == 8) {
            this.zznx.zzns = true;
            this.zznx.zznt = false;
            zza((zzev) new zzet(this, status));
            return;
        }
        this.zznx.zzd(status);
        this.zznx.zzc(status);
    }

    public final void zza(Status status, PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        boolean z = this.zznx.zznb == 2;
        int i = this.zznx.zznb;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        zzb(status, phoneAuthCredential, null);
    }

    public final void zza(zzcg zzcg) {
        zzb(zzcg.getStatus(), zzcg.zzcv(), zzcg.getEmail());
    }

    private final void zzb(Status status, AuthCredential authCredential, String str) {
        this.zznx.zzd(status);
        this.zznx.zznp = authCredential;
        this.zznx.zznq = str;
        if (this.zznx.zznf != null) {
            this.zznx.zznf.zza(status);
        }
        this.zznx.zzc(status);
    }

    public final void zzdg() throws RemoteException {
        boolean z = this.zznx.zznb == 9;
        int i = this.zznx.zznb;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        this.zznx.zzdp();
    }

    private final void zza(zzev zzev) {
        this.zznx.zznj.execute(new zzeu(this, zzev));
    }
}
