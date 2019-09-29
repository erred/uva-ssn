package com.firebase.p119ui.auth.p124ui.phone;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.firebase.p119ui.auth.p121b.C2020b;
import com.firebase.p119ui.auth.p124ui.C2048b;
import com.firebase.p119ui.auth.p124ui.C2050c;
import com.firebase.p119ui.auth.p124ui.C2052e;
import com.firebase.p119ui.auth.p124ui.C2052e.C2054a;
import com.firebase.ui.auth.R;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import java.util.Locale;

/* renamed from: com.firebase.ui.auth.ui.phone.j */
/* compiled from: VerifyPhoneNumberFragment */
public class C2111j extends C2050c implements OnClickListener {

    /* renamed from: a */
    private Context f6480a;

    /* renamed from: b */
    private CountryListSpinner f6481b;

    /* renamed from: c */
    private EditText f6482c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public TextView f6483d;

    /* renamed from: e */
    private Button f6484e;

    /* renamed from: f */
    private PhoneVerificationActivity f6485f;

    /* renamed from: g */
    private TextView f6486g;

    /* renamed from: a */
    public static C2111j m8468a(C2048b bVar, Bundle bundle) {
        C2111j jVar = new C2111j();
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("extra_flow_params", bVar);
        bundle2.putBundle("extra_params", bundle);
        jVar.setArguments(bundle2);
        return jVar;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.f6480a = context.getApplicationContext();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fui_phone_layout, viewGroup, false);
        this.f6481b = (CountryListSpinner) inflate.findViewById(R.id.country_list);
        this.f6482c = (EditText) inflate.findViewById(R.id.phone_number);
        this.f6483d = (TextView) inflate.findViewById(R.id.phone_number_error);
        this.f6484e = (Button) inflate.findViewById(R.id.send_code);
        this.f6486g = (TextView) inflate.findViewById(R.id.send_sms_tos);
        C2052e.m8294a(this.f6482c, new C2054a() {
            /* renamed from: a */
            public void mo11808a() {
                C2111j.this.m8474e();
            }
        });
        getActivity().setTitle(getString(R.string.fui_verify_phone_number_title));
        m8476g();
        m8477h();
        m8469a();
        return inflate;
    }

    /* renamed from: a */
    private void m8469a() {
        String string = getString(R.string.fui_verify_phone_number);
        this.f6486g.setText(getString(R.string.fui_sms_terms_of_service, string));
    }

    public void onActivityCreated(Bundle bundle) {
        String str;
        String str2;
        super.onActivityCreated(bundle);
        if (getActivity() instanceof PhoneVerificationActivity) {
            this.f6485f = (PhoneVerificationActivity) getActivity();
            if (bundle == null) {
                Bundle bundle2 = getArguments().getBundle("extra_params");
                String str3 = null;
                if (bundle2 != null) {
                    String string = bundle2.getString("extra_phone_number");
                    String string2 = bundle2.getString("extra_country_code");
                    str = bundle2.getString("extra_national_number");
                    String str4 = string2;
                    str2 = string;
                    str3 = str4;
                } else {
                    str = null;
                    str2 = null;
                }
                if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str)) {
                    C2102g a = C2103h.m8427a(str3, str);
                    m8470a(a);
                    m8473b(a);
                } else if (!TextUtils.isEmpty(str2)) {
                    C2102g a2 = C2103h.m8426a(str2);
                    m8470a(a2);
                    m8473b(a2);
                } else if (mo11880b().f6324i) {
                    m8478i();
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("Activity must implement PhoneVerificationHandler");
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 22 && intent != null) {
            Credential credential = (Credential) intent.getParcelableExtra(Credential.EXTRA_KEY);
            if (credential != null) {
                String id = credential.getId();
                String a = C2103h.m8428a(id, this.f6480a);
                if (a == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unable to normalize phone number from hint selector:");
                    sb.append(id);
                    Log.e("VerifyPhoneFragment", sb.toString());
                    return;
                }
                C2102g a2 = C2103h.m8426a(a);
                m8470a(a2);
                m8473b(a2);
                m8474e();
            }
        }
    }

    public void onClick(View view) {
        m8474e();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m8474e() {
        String f = m8475f();
        if (f == null) {
            this.f6483d.setText(R.string.fui_invalid_phone_number);
        } else {
            this.f6485f.mo11923a(f, false);
        }
    }

    /* renamed from: f */
    private String m8475f() {
        C2096c cVar = (C2096c) this.f6481b.getTag();
        String obj = this.f6482c.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            return null;
        }
        return C2103h.m8429a(obj, cVar);
    }

    /* renamed from: g */
    private void m8476g() {
        this.f6481b.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C2111j.this.f6483d.setText("");
            }
        });
    }

    /* renamed from: h */
    private void m8477h() {
        this.f6484e.setOnClickListener(this);
    }

    /* renamed from: i */
    private void m8478i() {
        try {
            mo11879a(m8479j().getIntentSender(), 22);
        } catch (SendIntentException e) {
            Log.e("VerifyPhoneFragment", "Unable to start hint intent", e);
        }
    }

    /* renamed from: j */
    private PendingIntent m8479j() {
        return Auth.CredentialsApi.getHintPickerIntent(new Builder(getContext()).addApi(Auth.CREDENTIALS_API).enableAutoManage(getActivity(), C2020b.m8200a(), new OnConnectionFailedListener() {
            public void onConnectionFailed(ConnectionResult connectionResult) {
                StringBuilder sb = new StringBuilder();
                sb.append("Client connection failed: ");
                sb.append(connectionResult.getErrorMessage());
                Log.e("VerifyPhoneFragment", sb.toString());
            }
        }).build(), new HintRequest.Builder().setHintPickerConfig(new CredentialPickerConfig.Builder().setShowCancelButton(true).build()).setPhoneNumberIdentifierSupported(true).setEmailAddressIdentifierSupported(false).build());
    }

    /* renamed from: a */
    private void m8470a(C2102g gVar) {
        if (C2102g.m8420a(gVar)) {
            this.f6482c.setText(gVar.mo11967b());
            this.f6482c.setSelection(gVar.mo11967b().length());
        }
    }

    /* renamed from: b */
    private void m8473b(C2102g gVar) {
        if (C2102g.m8421b(gVar)) {
            this.f6481b.mo11913a(new Locale("", gVar.mo11968c()), gVar.mo11966a());
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo11973a(String str) {
        this.f6483d.setText(str);
    }
}
