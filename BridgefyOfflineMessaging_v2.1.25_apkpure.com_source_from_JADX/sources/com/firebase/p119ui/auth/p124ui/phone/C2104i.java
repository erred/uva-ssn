package com.firebase.p119ui.auth.p124ui.phone;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.p081a.C1071e;
import com.firebase.p119ui.auth.p124ui.C2048b;
import com.firebase.p119ui.auth.p124ui.C2050c;
import com.firebase.p119ui.auth.p124ui.C2052e;
import com.firebase.p119ui.auth.p124ui.C2052e.C2054a;
import com.firebase.p119ui.auth.p124ui.email.C2066b;
import com.firebase.ui.auth.R;

/* renamed from: com.firebase.ui.auth.ui.phone.i */
/* compiled from: SubmitConfirmationCodeFragment */
public class C2104i extends C2050c {

    /* renamed from: a */
    private TextView f6459a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public TextView f6460b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public TextView f6461c;

    /* renamed from: d */
    private SpacedEditText f6462d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Button f6463e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C2100f f6464f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public PhoneVerificationActivity f6465g;

    /* renamed from: h */
    private TextView f6466h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public long f6467i;

    /* renamed from: a */
    public static C2104i m8444a(C2048b bVar, String str) {
        C2104i iVar = new C2104i();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extra_flow_params", bVar);
        bundle.putString("extra_phone_number", str);
        iVar.setArguments(bundle);
        return iVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fui_confirmation_code_layout, viewGroup, false);
        C1071e activity = getActivity();
        this.f6459a = (TextView) inflate.findViewById(R.id.edit_phone_number);
        this.f6461c = (TextView) inflate.findViewById(R.id.ticker);
        this.f6460b = (TextView) inflate.findViewById(R.id.resend_code);
        this.f6462d = (SpacedEditText) inflate.findViewById(R.id.confirmation_code);
        this.f6463e = (Button) inflate.findViewById(R.id.submit_confirmation_code);
        this.f6466h = (TextView) inflate.findViewById(R.id.create_account_tos);
        String string = getArguments().getString("extra_phone_number");
        activity.setTitle(getString(R.string.fui_verify_your_phone_title));
        m8457f();
        m8452c(string);
        m8448b(15000);
        m8445a();
        m8450b(string);
        m8461j();
        return inflate;
    }

    public void onStart() {
        super.onStart();
        this.f6462d.requestFocus();
        ((InputMethodManager) getActivity().getSystemService("input_method")).showSoftInput(this.f6462d, 0);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (bundle != null) {
            this.f6464f.mo11959a(bundle.getLong("EXTRA_MILLIS_UNTIL_FINISHED"));
        }
        if (getActivity() instanceof PhoneVerificationActivity) {
            this.f6465g = (PhoneVerificationActivity) getActivity();
            return;
        }
        throw new IllegalStateException("Activity must implement PhoneVerificationHandler");
    }

    public void onDestroy() {
        m8460i();
        super.onDestroy();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong("EXTRA_MILLIS_UNTIL_FINISHED", this.f6467i);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8446a(long j) {
        this.f6461c.setText(String.format(getString(R.string.fui_resend_code_in), new Object[]{Integer.valueOf(m8439a((double) j))}));
    }

    /* renamed from: b */
    private void m8450b(final String str) {
        this.f6460b.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C2104i.this.f6465g.mo11923a(str, true);
                C2104i.this.f6460b.setVisibility(8);
                C2104i.this.f6461c.setVisibility(0);
                C2104i.this.f6461c.setText(String.format(C2104i.this.getString(R.string.fui_resend_code_in), new Object[]{Long.valueOf(15)}));
                C2104i.this.f6464f.mo11958a();
            }
        });
    }

    /* renamed from: b */
    private void m8448b(long j) {
        m8446a(j / 1000);
        this.f6464f = m8443a(this.f6461c, this.f6460b, this, j);
        m8459h();
    }

    /* renamed from: a */
    private void m8445a() {
        this.f6463e.setEnabled(false);
        this.f6463e.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C2104i.this.m8454e();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m8454e() {
        this.f6465g.mo11922a(this.f6462d.getUnspacedText().toString());
    }

    /* renamed from: c */
    private void m8452c(String str) {
        TextView textView = this.f6459a;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        textView.setText(str);
        this.f6459a.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (C2104i.this.getFragmentManager().mo4375d() > 0) {
                    C2104i.this.getFragmentManager().mo4373b();
                }
            }
        });
    }

    /* renamed from: f */
    private void m8457f() {
        this.f6462d.setText("------");
        this.f6462d.addTextChangedListener(m8458g());
        C2052e.m8294a(this.f6462d, new C2054a() {
            /* renamed from: a */
            public void mo11808a() {
                if (C2104i.this.f6463e.isEnabled()) {
                    C2104i.this.m8454e();
                }
            }
        });
    }

    /* renamed from: g */
    private C2093a m8458g() {
        return new C2093a(this.f6462d, 6, "-", m8442a(this.f6463e));
    }

    /* renamed from: h */
    private void m8459h() {
        if (this.f6464f != null) {
            this.f6464f.mo11962c();
        }
    }

    /* renamed from: i */
    private void m8460i() {
        if (this.f6464f != null) {
            this.f6464f.mo11960b();
        }
    }

    /* renamed from: j */
    private void m8461j() {
        new C2066b(getContext(), mo11880b(), R.string.fui_continue_phone_login).mo11899a(this.f6466h);
    }

    /* renamed from: a */
    private int m8439a(double d) {
        return (int) Math.ceil(d / 1000.0d);
    }

    /* renamed from: a */
    private C2100f m8443a(TextView textView, TextView textView2, C2104i iVar, long j) {
        final C2104i iVar2 = iVar;
        final TextView textView3 = textView;
        final TextView textView4 = textView2;
        C21095 r0 = new C2100f(j, 500) {

            /* renamed from: a */
            C2104i f6473a = iVar2;

            /* renamed from: b */
            public void mo11961b(long j) {
                C2104i.this.f6467i = j;
                this.f6473a.m8446a(j);
            }

            /* renamed from: d */
            public void mo11963d() {
                textView3.setText("");
                textView3.setVisibility(8);
                textView4.setVisibility(0);
            }
        };
        return r0;
    }

    /* renamed from: a */
    private C2094a m8442a(final Button button) {
        return new C2094a() {
            /* renamed from: a */
            public void mo11939a() {
                button.setEnabled(true);
            }

            /* renamed from: b */
            public void mo11940b() {
                button.setEnabled(false);
            }
        };
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo11969a(String str) {
        this.f6462d.setText(str);
    }
}
