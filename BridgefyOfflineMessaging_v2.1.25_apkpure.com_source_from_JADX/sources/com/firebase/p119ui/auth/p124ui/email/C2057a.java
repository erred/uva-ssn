package com.firebase.p119ui.auth.p124ui.email;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import com.firebase.p119ui.auth.C2037d;
import com.firebase.p119ui.auth.C2037d.C2039a;
import com.firebase.p119ui.auth.p120a.C2012g;
import com.firebase.p119ui.auth.p121b.C2020b;
import com.firebase.p119ui.auth.p124ui.C2048b;
import com.firebase.p119ui.auth.p124ui.C2050c;
import com.firebase.p119ui.auth.p124ui.C2052e;
import com.firebase.p119ui.auth.p124ui.C2052e.C2054a;
import com.firebase.p119ui.auth.p124ui.email.p125a.C2063b;
import com.firebase.ui.auth.R;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;

/* renamed from: com.firebase.ui.auth.ui.email.a */
/* compiled from: CheckEmailFragment */
public class C2057a extends C2050c implements OnClickListener, C2054a {

    /* renamed from: a */
    private EditText f6337a;

    /* renamed from: b */
    private TextInputLayout f6338b;

    /* renamed from: c */
    private C2063b f6339c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C2061a f6340d;

    /* renamed from: e */
    private Credential f6341e;

    /* renamed from: com.firebase.ui.auth.ui.email.a$a */
    /* compiled from: CheckEmailFragment */
    interface C2061a {
        /* renamed from: a */
        void mo11892a(C2037d dVar);

        /* renamed from: b */
        void mo11893b(C2037d dVar);

        /* renamed from: c */
        void mo11894c(C2037d dVar);
    }

    /* renamed from: a */
    public static C2057a m8307a(C2048b bVar, String str) {
        C2057a aVar = new C2057a();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extra_flow_params", bVar);
        bundle.putString("extra_email", str);
        aVar.setArguments(bundle);
        return aVar;
    }

    @SuppressLint({"NewApi"})
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fui_check_email_layout, viewGroup, false);
        this.f6338b = (TextInputLayout) inflate.findViewById(R.id.email_layout);
        this.f6337a = (EditText) inflate.findViewById(R.id.email);
        this.f6339c = new C2063b(this.f6338b);
        this.f6338b.setOnClickListener(this);
        this.f6337a.setOnClickListener(this);
        C2052e.m8294a(this.f6337a, this);
        if (VERSION.SDK_INT >= 26 && mo11880b().f6324i) {
            this.f6337a.setImportantForAutofill(2);
        }
        inflate.findViewById(R.id.button_next).setOnClickListener(this);
        return inflate;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (getActivity() instanceof C2061a) {
            this.f6340d = (C2061a) getActivity();
            if (bundle == null) {
                String string = getArguments().getString("extra_email");
                if (!TextUtils.isEmpty(string)) {
                    this.f6337a.setText(string);
                    m8309e();
                } else if (mo11880b().f6324i) {
                    m8310f();
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("Activity must implement CheckEmailListener");
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("has_existing_instance", true);
        super.onSaveInstanceState(bundle);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 13:
                if (intent != null) {
                    this.f6341e = (Credential) intent.getParcelableExtra(Credential.EXTRA_KEY);
                    if (this.f6341e != null) {
                        this.f6337a.setText(this.f6341e.getId());
                        m8309e();
                        return;
                    }
                    return;
                }
                return;
            case 15:
            case 16:
                mo11832a(i2, intent);
                return;
            default:
                return;
        }
    }

    /* renamed from: e */
    private void m8309e() {
        String obj = this.f6337a.getText().toString();
        if (this.f6339c.mo11898b(obj)) {
            m8308a(obj);
        }
    }

    /* renamed from: a */
    private void m8308a(final String str) {
        final Uri uri;
        mo11882d().mo11908a(R.string.fui_progress_dialog_checking_accounts);
        final String str2 = null;
        if (this.f6341e == null || !this.f6341e.getId().equals(str)) {
            uri = null;
        } else {
            str2 = this.f6341e.getName();
            uri = this.f6341e.getProfilePictureUri();
        }
        C2012g.m8174a(mo11881c().mo11815a(), str).addOnSuccessListener((Activity) getActivity(), (OnSuccessListener<? super TResult>) new OnSuccessListener<String>() {
            /* renamed from: a */
            public void onSuccess(String str) {
                if (str == null) {
                    C2057a.this.f6340d.mo11894c(new C2039a("password", str).mo11866b(str2).mo11863a(uri).mo11865a());
                } else if ("password".equalsIgnoreCase(str)) {
                    C2057a.this.f6340d.mo11892a(new C2039a("password", str).mo11865a());
                } else {
                    C2057a.this.f6340d.mo11893b(new C2039a(str, str).mo11865a());
                }
            }
        }).addOnCompleteListener((Activity) getActivity(), (OnCompleteListener<TResult>) new OnCompleteListener<String>() {
            public void onComplete(Task<String> task) {
                C2057a.this.mo11882d().mo11907a();
            }
        });
    }

    /* renamed from: f */
    private void m8310f() {
        try {
            mo11879a(m8311g().getIntentSender(), 13);
        } catch (SendIntentException e) {
            Log.e("CheckEmailFragment", "Unable to start hint intent", e);
        }
    }

    /* renamed from: g */
    private PendingIntent m8311g() {
        return Auth.CredentialsApi.getHintPickerIntent(new Builder(getContext()).addApi(Auth.CREDENTIALS_API).enableAutoManage(getActivity(), C2020b.m8200a(), new OnConnectionFailedListener() {
            public void onConnectionFailed(ConnectionResult connectionResult) {
                StringBuilder sb = new StringBuilder();
                sb.append("Client connection failed: ");
                sb.append(connectionResult.getErrorMessage());
                Log.e("CheckEmailFragment", sb.toString());
            }
        }).build(), new HintRequest.Builder().setHintPickerConfig(new CredentialPickerConfig.Builder().setShowCancelButton(true).build()).setEmailAddressIdentifierSupported(true).build());
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.button_next) {
            m8309e();
        } else if (id == R.id.email_layout || id == R.id.email) {
            this.f6338b.setError(null);
        }
    }

    /* renamed from: a */
    public void mo11808a() {
        m8309e();
    }
}
