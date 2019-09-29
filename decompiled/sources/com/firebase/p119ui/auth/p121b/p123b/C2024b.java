package com.firebase.p119ui.auth.p121b.p123b;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import androidx.fragment.p081a.C1062d;
import androidx.fragment.p081a.C1078i;
import com.firebase.p119ui.auth.C2034c;
import com.firebase.p119ui.auth.p121b.C2020b;
import com.firebase.p119ui.auth.p121b.C2032d;
import com.firebase.p119ui.auth.p124ui.C2051d;
import com.firebase.ui.auth.R;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.Credential.Builder;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.FirebaseUser;

/* renamed from: com.firebase.ui.auth.b.b.b */
/* compiled from: SaveSmartLock */
public class C2024b extends C2029d<Status> {

    /* renamed from: b */
    private Context f6262b;

    /* renamed from: c */
    private String f6263c;

    /* renamed from: d */
    private String f6264d;

    /* renamed from: e */
    private String f6265e;

    /* renamed from: f */
    private String f6266f;

    /* renamed from: g */
    private C2034c f6267g;

    /* renamed from: a */
    public static C2024b m8206a(C2051d dVar) {
        C2024b bVar;
        C1078i supportFragmentManager = dVar.getSupportFragmentManager();
        C1062d a = supportFragmentManager.mo4369a("SaveSmartLock");
        if (!(a instanceof C2024b)) {
            bVar = new C2024b();
            bVar.setArguments(dVar.mo11886b().mo11872a());
            try {
                supportFragmentManager.mo4370a().mo4069a((C1062d) bVar, "SaveSmartLock").mo4065a().mo4084c();
            } catch (IllegalStateException e) {
                Log.e("SaveSmartLock", "Cannot add fragment", e);
                return null;
            }
        } else {
            bVar = (C2024b) a;
        }
        return bVar;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.f6262b = context.getApplicationContext();
    }

    public void onConnected(Bundle bundle) {
        if (TextUtils.isEmpty(this.f6264d)) {
            Log.e("SaveSmartLock", "Unable to save null credential!");
            m8207a();
            return;
        }
        Builder builder = new Builder(this.f6264d);
        builder.setPassword(this.f6265e);
        if (this.f6265e == null && this.f6267g != null) {
            String a = m8225a(this.f6267g.mo11837c());
            if (a != null) {
                builder.setAccountType(a);
            } else {
                Log.e("SaveSmartLock", "Unable to save null credential!");
                m8207a();
                return;
            }
        }
        if (this.f6263c != null) {
            builder.setName(this.f6263c);
        }
        if (this.f6266f != null) {
            builder.setProfilePictureUri(Uri.parse(this.f6266f));
        }
        mo11881c().mo11816b().save(this.f6273a, builder.build()).setResultCallback(this);
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        Toast.makeText(getContext(), R.string.fui_general_error, 0).show();
        try {
            mo11879a(C2032d.m8231a().getErrorResolutionPendingIntent(getContext(), connectionResult.getErrorCode(), 28).getIntentSender(), 28);
        } catch (SendIntentException e) {
            Log.e("SaveSmartLock", "STATUS: Failed to send resolution.", e);
            m8207a();
        }
    }

    /* renamed from: a */
    public void onResult(Status status) {
        if (status.isSuccess()) {
            m8207a();
        } else if (status.hasResolution()) {
            try {
                mo11879a(status.getResolution().getIntentSender(), 100);
            } catch (SendIntentException e) {
                Log.e("SaveSmartLock", "STATUS: Failed to send resolution.", e);
                m8207a();
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Status message:\n");
            sb.append(status.getStatusMessage());
            Log.w("SaveSmartLock", sb.toString());
            m8207a();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            if (i2 != -1) {
                Log.e("SaveSmartLock", "SAVE: Canceled by user");
            }
            m8207a();
        } else if (i != 28) {
        } else {
            if (i2 == -1) {
                mo11881c().mo11816b().save(this.f6273a, new Builder(this.f6264d).setPassword(this.f6265e).build()).setResultCallback(this);
                return;
            }
            Log.e("SaveSmartLock", "SAVE: Canceled by user");
            m8207a();
        }
    }

    /* renamed from: a */
    private void m8207a() {
        mo11832a(-1, this.f6267g.mo11835a());
    }

    /* renamed from: a */
    public void mo11827a(FirebaseUser firebaseUser, String str, C2034c cVar) {
        this.f6267g = cVar;
        if (!mo11880b().f6323h) {
            m8207a();
            return;
        }
        this.f6263c = firebaseUser.getDisplayName();
        this.f6264d = firebaseUser.getEmail();
        this.f6265e = str;
        this.f6266f = firebaseUser.getPhotoUrl() != null ? firebaseUser.getPhotoUrl().toString() : null;
        this.f6273a = new GoogleApiClient.Builder(this.f6262b).addConnectionCallbacks(this).addOnConnectionFailedListener(this).addApi(Auth.CREDENTIALS_API).enableAutoManage(getActivity(), C2020b.m8200a(), this).build();
        this.f6273a.connect();
    }
}
