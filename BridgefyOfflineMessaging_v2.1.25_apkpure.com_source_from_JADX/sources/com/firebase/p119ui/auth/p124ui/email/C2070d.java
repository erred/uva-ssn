package com.firebase.p119ui.auth.p124ui.email;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.firebase.p119ui.auth.C2034c;
import com.firebase.p119ui.auth.C2034c.C2036a;
import com.firebase.p119ui.auth.C2037d;
import com.firebase.p119ui.auth.C2037d.C2039a;
import com.firebase.p119ui.auth.p120a.C2012g;
import com.firebase.p119ui.auth.p121b.p122a.C2018a;
import com.firebase.p119ui.auth.p121b.p123b.C2024b;
import com.firebase.p119ui.auth.p124ui.C2048b;
import com.firebase.p119ui.auth.p124ui.C2050c;
import com.firebase.p119ui.auth.p124ui.C2051d;
import com.firebase.p119ui.auth.p124ui.C2052e;
import com.firebase.p119ui.auth.p124ui.C2052e.C2054a;
import com.firebase.p119ui.auth.p124ui.C2077g;
import com.firebase.p119ui.auth.p124ui.accountlink.WelcomeBackIdpPrompt;
import com.firebase.p119ui.auth.p124ui.accountlink.WelcomeBackPasswordPrompt;
import com.firebase.p119ui.auth.p124ui.email.p125a.C2063b;
import com.firebase.p119ui.auth.p124ui.email.p125a.C2064c;
import com.firebase.p119ui.auth.p124ui.email.p125a.C2065d;
import com.firebase.ui.auth.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

/* renamed from: com.firebase.ui.auth.ui.email.d */
/* compiled from: RegisterEmailFragment */
public class C2070d extends C2050c implements OnClickListener, OnFocusChangeListener, C2054a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C2051d f6361a;

    /* renamed from: b */
    private EditText f6362b;

    /* renamed from: c */
    private EditText f6363c;

    /* renamed from: d */
    private EditText f6364d;

    /* renamed from: e */
    private TextView f6365e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public TextInputLayout f6366f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public TextInputLayout f6367g;

    /* renamed from: h */
    private C2063b f6368h;

    /* renamed from: i */
    private C2064c f6369i;

    /* renamed from: j */
    private C2065d f6370j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public C2024b f6371k;

    /* renamed from: l */
    private C2037d f6372l;

    /* renamed from: a */
    public static C2070d m8331a(C2048b bVar, C2037d dVar) {
        C2070d dVar2 = new C2070d();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extra_flow_params", bVar);
        bundle.putParcelable("extra_user", dVar);
        dVar2.setArguments(bundle);
        return dVar2;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            this.f6372l = C2037d.m8248a(getArguments());
        } else {
            this.f6372l = C2037d.m8248a(bundle);
        }
    }

    @SuppressLint({"NewApi"})
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fui_register_email_layout, viewGroup, false);
        this.f6362b = (EditText) inflate.findViewById(R.id.email);
        this.f6363c = (EditText) inflate.findViewById(R.id.name);
        this.f6364d = (EditText) inflate.findViewById(R.id.password);
        this.f6365e = (TextView) inflate.findViewById(R.id.create_account_text);
        this.f6366f = (TextInputLayout) inflate.findViewById(R.id.email_layout);
        this.f6367g = (TextInputLayout) inflate.findViewById(R.id.password_layout);
        this.f6369i = new C2064c(this.f6367g, getResources().getInteger(R.integer.fui_min_password_length));
        this.f6370j = new C2065d((TextInputLayout) inflate.findViewById(R.id.name_layout));
        this.f6368h = new C2063b(this.f6366f);
        C2052e.m8294a(this.f6364d, this);
        this.f6362b.setOnFocusChangeListener(this);
        this.f6363c.setOnFocusChangeListener(this);
        this.f6364d.setOnFocusChangeListener(this);
        inflate.findViewById(R.id.button_create).setOnClickListener(this);
        if (VERSION.SDK_INT >= 26 && mo11880b().f6323h) {
            this.f6362b.setImportantForAutofill(2);
        }
        if (bundle != null) {
            return inflate;
        }
        String b = this.f6372l.mo11851b();
        if (!TextUtils.isEmpty(b)) {
            this.f6362b.setText(b);
        }
        String c = this.f6372l.mo11852c();
        if (!TextUtils.isEmpty(c)) {
            this.f6363c.setText(c);
        }
        if (!TextUtils.isEmpty(this.f6363c.getText())) {
            m8333a((View) this.f6364d);
        } else if (!TextUtils.isEmpty(this.f6362b.getText())) {
            m8333a((View) this.f6363c);
        } else {
            m8333a((View) this.f6362b);
        }
        return inflate;
    }

    /* renamed from: a */
    private void m8333a(final View view) {
        view.post(new Runnable() {
            public void run() {
                view.requestFocus();
            }
        });
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getActivity().setTitle(R.string.fui_title_register_email);
        if (getActivity() instanceof C2051d) {
            this.f6361a = (C2051d) getActivity();
            this.f6371k = mo11881c().mo11814a(this.f6361a);
            new C2066b(getContext(), mo11880b(), R.string.fui_button_text_save).mo11899a(this.f6365e);
            return;
        }
        throw new RuntimeException("Must be attached to a HelperActivityBase.");
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putParcelable("extra_user", new C2039a("password", this.f6362b.getText().toString()).mo11866b(this.f6363c.getText().toString()).mo11863a(this.f6372l.mo11853d()).mo11865a());
        super.onSaveInstanceState(bundle);
    }

    public void onFocusChange(View view, boolean z) {
        if (!z) {
            int id = view.getId();
            if (id == R.id.email) {
                this.f6368h.mo11898b(this.f6362b.getText());
            } else if (id == R.id.name) {
                this.f6370j.mo11898b(this.f6363c.getText());
            } else if (id == R.id.password) {
                this.f6369i.mo11898b(this.f6364d.getText());
            }
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.button_create) {
            m8338e();
        }
    }

    /* renamed from: a */
    public void mo11808a() {
        m8338e();
    }

    /* renamed from: e */
    private void m8338e() {
        String obj = this.f6362b.getText().toString();
        String obj2 = this.f6364d.getText().toString();
        String obj3 = this.f6363c.getText().toString();
        boolean b = this.f6368h.mo11898b(obj);
        boolean b2 = this.f6369i.mo11898b(obj2);
        boolean b3 = this.f6370j.mo11898b(obj3);
        if (b && b2 && b3) {
            mo11882d().mo11908a(R.string.fui_progress_dialog_signing_up);
            m8334a(obj, obj3, obj2);
        }
    }

    /* renamed from: a */
    private void m8334a(final String str, String str2, final String str3) {
        final C2034c a = new C2036a(new C2039a("password", str).mo11866b(str2).mo11863a(this.f6372l.mo11853d()).mo11865a()).mo11848a();
        mo11881c().mo11815a().createUserWithEmailAndPassword(str, str3).continueWithTask(new C2018a(a)).addOnFailureListener(new C2077g("RegisterEmailFragment", "Error creating user")).addOnSuccessListener((Activity) getActivity(), (OnSuccessListener<? super TResult>) new OnSuccessListener<AuthResult>() {
            /* renamed from: a */
            public void onSuccess(AuthResult authResult) {
                C2070d.this.f6361a.mo11885a(C2070d.this.f6371k, authResult.getUser(), str3, a);
            }
        }).addOnFailureListener((Activity) getActivity(), (OnFailureListener) new OnFailureListener() {
            public void onFailure(Exception exc) {
                if (exc instanceof FirebaseAuthWeakPasswordException) {
                    C2070d.this.f6367g.setError(C2070d.this.getResources().getQuantityString(R.plurals.fui_error_weak_password, R.integer.fui_min_password_length));
                } else if (exc instanceof FirebaseAuthInvalidCredentialsException) {
                    C2070d.this.f6366f.setError(C2070d.this.getString(R.string.fui_invalid_email_address));
                } else if (exc instanceof FirebaseAuthUserCollisionException) {
                    C2012g.m8174a(C2070d.this.mo11881c().mo11815a(), str).addOnSuccessListener((Activity) C2070d.this.getActivity(), (OnSuccessListener<? super TResult>) new OnSuccessListener<String>() {
                        /* renamed from: a */
                        public void onSuccess(String str) {
                            Toast.makeText(C2070d.this.getContext(), R.string.fui_error_user_collision, 1).show();
                            if (str == null) {
                                throw new IllegalStateException("User has no providers even though we got a FirebaseAuthUserCollisionException");
                            } else if ("password".equalsIgnoreCase(str)) {
                                C2070d.this.getActivity().startActivityForResult(WelcomeBackPasswordPrompt.m8269a(C2070d.this.getContext(), C2070d.this.mo11880b(), new C2036a(new C2039a("password", str).mo11865a()).mo11848a()), 18);
                            } else {
                                C2070d.this.getActivity().startActivityForResult(WelcomeBackIdpPrompt.m8260a(C2070d.this.getContext(), C2070d.this.mo11880b(), new C2039a(str, str).mo11865a(), null), 18);
                            }
                        }
                    }).addOnCompleteListener(new OnCompleteListener<String>() {
                        public void onComplete(Task<String> task) {
                            C2070d.this.mo11882d().mo11907a();
                        }
                    });
                    return;
                } else {
                    C2070d.this.f6366f.setError(C2070d.this.getString(R.string.fui_email_account_creation_error));
                }
                C2070d.this.mo11882d().mo11907a();
            }
        });
    }
}
