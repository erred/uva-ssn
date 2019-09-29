package com.google.firebase.auth.api.internal;

import android.app.Activity;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzcj;
import com.google.android.gms.internal.firebase_auth.zzct;
import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.android.gms.internal.firebase_auth.zzdg;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks;
import com.google.firebase.auth.internal.zzw;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

abstract class zzeo<ResultT, CallbackT> implements zzam<zzdq, ResultT> {
    protected FirebaseApp zzgm;
    protected String zzhn;
    protected final int zznb;
    @VisibleForTesting
    final zzep zznc = new zzep(this);
    protected FirebaseUser zznd;
    protected CallbackT zzne;
    protected zzw zznf;
    protected zzen<ResultT> zzng;
    protected final List<OnVerificationStateChangedCallbacks> zznh = new ArrayList();
    private Activity zzni;
    protected Executor zznj;
    protected zzcz zznk;
    protected zzct zznl;
    protected zzcj zznm;
    protected zzdg zznn;
    protected String zzno;
    protected AuthCredential zznp;
    protected String zznq;
    protected boolean zznr;
    /* access modifiers changed from: private */
    public boolean zzns;
    @VisibleForTesting
    boolean zznt;
    @VisibleForTesting
    private ResultT zznu;
    @VisibleForTesting
    private Status zznv;

    static class zza extends LifecycleCallback {
        private final List<OnVerificationStateChangedCallbacks> zznw;

        public static void zza(Activity activity, List<OnVerificationStateChangedCallbacks> list) {
            LifecycleFragment fragment = getFragment(activity);
            if (((zza) fragment.getCallbackOrNull("PhoneAuthActivityStopCallback", zza.class)) == null) {
                new zza(fragment, list);
            }
        }

        private zza(LifecycleFragment lifecycleFragment, List<OnVerificationStateChangedCallbacks> list) {
            super(lifecycleFragment);
            this.mLifecycleFragment.addCallback("PhoneAuthActivityStopCallback", this);
            this.zznw = list;
        }

        public void onStop() {
            synchronized (this.zznw) {
                this.zznw.clear();
            }
        }
    }

    public zzeo(int i) {
        this.zznb = i;
    }

    public abstract void zzdd();

    public final zzeo<ResultT, CallbackT> zza(FirebaseApp firebaseApp) {
        this.zzgm = (FirebaseApp) Preconditions.checkNotNull(firebaseApp, "firebaseApp cannot be null");
        return this;
    }

    public final zzeo<ResultT, CallbackT> zzf(FirebaseUser firebaseUser) {
        this.zznd = (FirebaseUser) Preconditions.checkNotNull(firebaseUser, "firebaseUser cannot be null");
        return this;
    }

    public final zzeo<ResultT, CallbackT> zzb(CallbackT callbackt) {
        this.zzne = Preconditions.checkNotNull(callbackt, "external callback cannot be null");
        return this;
    }

    public final zzeo<ResultT, CallbackT> zza(zzw zzw) {
        this.zznf = (zzw) Preconditions.checkNotNull(zzw, "external failure callback cannot be null");
        return this;
    }

    public final zzeo<ResultT, CallbackT> zza(OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Activity activity, Executor executor) {
        synchronized (this.zznh) {
            this.zznh.add((OnVerificationStateChangedCallbacks) Preconditions.checkNotNull(onVerificationStateChangedCallbacks));
        }
        this.zzni = activity;
        if (this.zzni != null) {
            zza.zza(activity, this.zznh);
        }
        this.zznj = (Executor) Preconditions.checkNotNull(executor);
        return this;
    }

    public final zzam<zzdq, ResultT> zzdc() {
        this.zznr = true;
        return this;
    }

    public final void zzc(ResultT resultt) {
        this.zzns = true;
        this.zznt = true;
        this.zznu = resultt;
        this.zzng.zza(resultt, null);
    }

    public final void zzc(Status status) {
        this.zzns = true;
        this.zznt = false;
        this.zznv = status;
        this.zzng.zza(null, status);
    }

    /* access modifiers changed from: private */
    public final void zzdp() {
        zzdd();
        Preconditions.checkState(this.zzns, "no success or failure set on method implementation");
    }

    /* access modifiers changed from: private */
    public final void zzd(Status status) {
        if (this.zznf != null) {
            this.zznf.zza(status);
        }
    }
}
