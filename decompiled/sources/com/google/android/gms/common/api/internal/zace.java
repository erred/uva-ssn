package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.internal.zac;
import com.google.android.gms.signin.internal.zaj;
import com.google.android.gms.signin.zaa;
import com.google.android.gms.signin.zad;
import java.util.Set;

public final class zace extends zac implements ConnectionCallbacks, OnConnectionFailedListener {
    private static AbstractClientBuilder<? extends zad, SignInOptions> zakh = zaa.zapg;
    private final Context mContext;
    private final Handler mHandler;
    private Set<Scope> mScopes;
    private final AbstractClientBuilder<? extends zad, SignInOptions> zaau;
    private ClientSettings zaes;
    private zad zaga;
    /* access modifiers changed from: private */
    public zach zaki;

    public zace(Context context, Handler handler, ClientSettings clientSettings) {
        this(context, handler, clientSettings, zakh);
    }

    public zace(Context context, Handler handler, ClientSettings clientSettings, AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder) {
        this.mContext = context;
        this.mHandler = handler;
        this.zaes = (ClientSettings) Preconditions.checkNotNull(clientSettings, "ClientSettings must not be null");
        this.mScopes = clientSettings.getRequiredScopes();
        this.zaau = abstractClientBuilder;
    }

    public final void zaa(zach zach) {
        if (this.zaga != null) {
            this.zaga.disconnect();
        }
        this.zaes.setClientSessionId(Integer.valueOf(System.identityHashCode(this)));
        this.zaga = (zad) this.zaau.buildClient(this.mContext, this.mHandler.getLooper(), this.zaes, this.zaes.getSignInOptions(), this, this);
        this.zaki = zach;
        if (this.mScopes == null || this.mScopes.isEmpty()) {
            this.mHandler.post(new zacf(this));
        } else {
            this.zaga.connect();
        }
    }

    public final zad zabq() {
        return this.zaga;
    }

    public final void zabs() {
        if (this.zaga != null) {
            this.zaga.disconnect();
        }
    }

    public final void onConnected(Bundle bundle) {
        this.zaga.zaa(this);
    }

    public final void onConnectionSuspended(int i) {
        this.zaga.disconnect();
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.zaki.zag(connectionResult);
    }

    public final void zab(zaj zaj) {
        this.mHandler.post(new zacg(this, zaj));
    }

    /* access modifiers changed from: private */
    public final void zac(zaj zaj) {
        ConnectionResult connectionResult = zaj.getConnectionResult();
        if (connectionResult.isSuccess()) {
            ResolveAccountResponse zacw = zaj.zacw();
            ConnectionResult connectionResult2 = zacw.getConnectionResult();
            if (!connectionResult2.isSuccess()) {
                String valueOf = String.valueOf(connectionResult2);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 48);
                sb.append("Sign-in succeeded with resolve account failure: ");
                sb.append(valueOf);
                Log.wtf("SignInCoordinator", sb.toString(), new Exception());
                this.zaki.zag(connectionResult2);
                this.zaga.disconnect();
                return;
            }
            this.zaki.zaa(zacw.getAccountAccessor(), this.mScopes);
        } else {
            this.zaki.zag(connectionResult);
        }
        this.zaga.disconnect();
    }
}
