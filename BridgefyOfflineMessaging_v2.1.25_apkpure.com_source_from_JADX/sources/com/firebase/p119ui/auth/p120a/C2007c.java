package com.firebase.p119ui.auth.p120a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import androidx.fragment.p081a.C1071e;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.firebase.p119ui.auth.C2001a.C2003a;
import com.firebase.p119ui.auth.C2034c;
import com.firebase.p119ui.auth.C2034c.C2036a;
import com.firebase.p119ui.auth.C2037d.C2039a;
import com.firebase.p119ui.auth.p120a.C2008d.C2009a;
import com.firebase.p119ui.auth.p121b.C2020b;
import com.firebase.ui.auth.R;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.GoogleAuthProvider;

/* renamed from: com.firebase.ui.auth.a.c */
/* compiled from: GoogleProvider */
public class C2007c implements C2008d, OnConnectionFailedListener {

    /* renamed from: a */
    private GoogleApiClient f6200a;

    /* renamed from: b */
    private C1071e f6201b;

    /* renamed from: c */
    private C2003a f6202c;

    /* renamed from: d */
    private C2009a f6203d;

    /* renamed from: e */
    private boolean f6204e;

    public C2007c(C1071e eVar, C2003a aVar) {
        this(eVar, aVar, null);
    }

    public C2007c(C1071e eVar, C2003a aVar, String str) {
        this.f6201b = eVar;
        this.f6202c = aVar;
        this.f6204e = !TextUtils.isEmpty(str);
        this.f6200a = new Builder(this.f6201b).enableAutoManage(this.f6201b, C2020b.m8200a(), this).addApi(Auth.GOOGLE_SIGN_IN_API, m8153a(str)).build();
    }

    /* renamed from: a */
    public static AuthCredential m8154a(C2034c cVar) {
        return GoogleAuthProvider.getCredential(cVar.mo11840e(), null);
    }

    /* renamed from: a */
    private GoogleSignInOptions m8153a(String str) {
        GoogleSignInOptions.Builder requestIdToken = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().requestIdToken(this.f6201b.getString(R.string.default_web_client_id));
        for (String scope : this.f6202c.mo11790b()) {
            requestIdToken.requestScopes(new Scope(scope), new Scope[0]);
        }
        if (!TextUtils.isEmpty(str)) {
            requestIdToken.setAccountName(str);
        }
        return requestIdToken.build();
    }

    /* renamed from: a */
    public String mo11802a(Context context) {
        return context.getString(R.string.fui_idp_name_google);
    }

    /* renamed from: a */
    public int mo11801a() {
        return R.layout.fui_idp_button_google;
    }

    /* renamed from: a */
    public void mo11805a(C2009a aVar) {
        this.f6203d = aVar;
    }

    /* renamed from: b */
    public void mo11806b() {
        if (this.f6200a != null) {
            this.f6200a.disconnect();
            this.f6200a = null;
        }
    }

    /* renamed from: a */
    private C2034c m8152a(GoogleSignInAccount googleSignInAccount) {
        return new C2036a(new C2039a("google.com", googleSignInAccount.getEmail()).mo11866b(googleSignInAccount.getDisplayName()).mo11863a(googleSignInAccount.getPhotoUrl()).mo11865a()).mo11847a(googleSignInAccount.getIdToken()).mo11848a();
    }

    /* renamed from: a */
    public void mo11803a(int i, int i2, Intent intent) {
        if (i == 20) {
            GoogleSignInResult signInResultFromIntent = Auth.GoogleSignInApi.getSignInResultFromIntent(intent);
            if (signInResultFromIntent == null) {
                m8156b("No result found in intent");
            } else if (signInResultFromIntent.isSuccess()) {
                if (this.f6204e) {
                    Toast.makeText(this.f6201b, this.f6201b.getString(R.string.fui_signed_in_with_specific_account, new Object[]{signInResultFromIntent.getSignInAccount().getEmail()}), 0).show();
                }
                this.f6203d.mo11809a(m8152a(signInResultFromIntent.getSignInAccount()));
            } else {
                m8155a(signInResultFromIntent);
            }
        }
    }

    /* renamed from: a */
    public void mo11804a(Activity activity) {
        activity.startActivityForResult(Auth.GoogleSignInApi.getSignInIntent(this.f6200a), 20);
    }

    /* renamed from: a */
    private void m8155a(GoogleSignInResult googleSignInResult) {
        Status status = googleSignInResult.getStatus();
        if (status.getStatusCode() == 5) {
            this.f6200a.stopAutoManage(this.f6201b);
            this.f6200a.disconnect();
            this.f6200a = new Builder(this.f6201b).enableAutoManage(this.f6201b, C2020b.m8200a(), this).addApi(Auth.GOOGLE_SIGN_IN_API, m8153a((String) null)).build();
            mo11804a((Activity) this.f6201b);
            return;
        }
        if (status.getStatusCode() == 10) {
            Log.w("GoogleProvider", "Developer error: this application is misconfigured. Check your SHA1  and package name in the Firebase console.");
            Toast.makeText(this.f6201b, "Developer error.", 0).show();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(status.getStatusCode());
        sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        sb.append(status.getStatusMessage());
        m8156b(sb.toString());
    }

    /* renamed from: b */
    private void m8156b(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("Error logging in with Google. ");
        sb.append(str);
        Log.e("GoogleProvider", sb.toString());
        this.f6203d.mo11808a();
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        StringBuilder sb = new StringBuilder();
        sb.append("onConnectionFailed:");
        sb.append(connectionResult);
        Log.w("GoogleProvider", sb.toString());
    }
}
