package com.firebase.p119ui.auth.p124ui.phone;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import androidx.appcompat.app.C0446c;
import androidx.appcompat.app.C0446c.C0447a;
import androidx.fragment.p081a.C1104o;
import com.firebase.p119ui.auth.C2016b;
import com.firebase.p119ui.auth.C2034c.C2036a;
import com.firebase.p119ui.auth.C2037d.C2039a;
import com.firebase.p119ui.auth.p124ui.C2040a;
import com.firebase.p119ui.auth.p124ui.C2048b;
import com.firebase.p119ui.auth.p124ui.C2051d;
import com.firebase.ui.auth.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.PhoneAuthProvider.ForceResendingToken;
import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks;
import java.util.concurrent.TimeUnit;

/* renamed from: com.firebase.ui.auth.ui.phone.PhoneVerificationActivity */
public class PhoneVerificationActivity extends C2040a {

    /* renamed from: a */
    C2095b f6407a;

    /* renamed from: b */
    private C0446c f6408b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Handler f6409c;

    /* renamed from: d */
    private String f6410d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f6411e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Boolean f6412f = Boolean.valueOf(false);
    /* access modifiers changed from: private */

    /* renamed from: g */
    public ForceResendingToken f6413g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public C2092a f6414h;

    /* renamed from: com.firebase.ui.auth.ui.phone.PhoneVerificationActivity$a */
    private enum C2092a {
        VERIFICATION_NOT_STARTED,
        VERIFICATION_STARTED,
        VERIFIED
    }

    /* renamed from: a */
    public static Intent m8367a(Context context, C2048b bVar, Bundle bundle) {
        return C2051d.m8287a(context, PhoneVerificationActivity.class, bVar).putExtra("extra_params", bundle);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.fui_activity_register_phone);
        this.f6409c = new Handler();
        this.f6414h = C2092a.VERIFICATION_NOT_STARTED;
        if (bundle == null || bundle.isEmpty()) {
            getSupportFragmentManager().mo4370a().mo4079b(R.id.fragment_verify_phone, C2111j.m8468a(mo11886b(), getIntent().getExtras().getBundle("extra_params")), "VerifyPhoneFragment").mo4065a().mo4084c();
            return;
        }
        this.f6410d = bundle.getString("KEY_VERIFICATION_PHONE");
        if (bundle.getSerializable("KEY_STATE") != null) {
            this.f6414h = (C2092a) bundle.getSerializable("KEY_STATE");
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        if (this.f6414h.equals(C2092a.VERIFICATION_STARTED)) {
            m8385b(this.f6410d, false);
        } else if (this.f6414h == C2092a.VERIFIED) {
            m8378a(mo11887c().mo11817c());
        }
    }

    public void onBackPressed() {
        if (getSupportFragmentManager().mo4375d() > 0) {
            this.f6414h = C2092a.VERIFICATION_NOT_STARTED;
            getSupportFragmentManager().mo4373b();
            return;
        }
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("KEY_STATE", this.f6414h);
        bundle.putString("KEY_VERIFICATION_PHONE", this.f6410d);
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.f6412f = Boolean.valueOf(true);
        this.f6409c.removeCallbacksAndMessages(null);
        m8392f();
        super.onDestroy();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo11923a(String str, boolean z) {
        m8385b(str, z);
        if (z) {
            m8387c(getString(R.string.fui_resending));
        } else {
            m8387c(getString(R.string.fui_verifying));
        }
    }

    /* renamed from: a */
    public void mo11922a(String str) {
        if (TextUtils.isEmpty(this.f6411e) || TextUtils.isEmpty(str)) {
            String str2 = "PhoneVerification";
            String str3 = "submitConfirmationCode: mVerificationId is %s ; confirmationCode is %s";
            Object[] objArr = new Object[2];
            objArr[0] = TextUtils.isEmpty(this.f6411e) ? "empty" : "not empty";
            objArr[1] = TextUtils.isEmpty(str) ? "empty" : "not empty";
            Log.w(str2, String.format(str3, objArr));
            return;
        }
        m8387c(getString(R.string.fui_verifying));
        m8383b(PhoneAuthProvider.getCredential(this.f6411e, str));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8379a(PhoneAuthCredential phoneAuthCredential) {
        if (TextUtils.isEmpty(phoneAuthCredential.getSmsCode())) {
            m8383b(phoneAuthCredential);
            return;
        }
        m8390e();
        C2104i g = m8393g();
        m8387c(getString(R.string.fui_retrieving_sms));
        if (g != null) {
            g.mo11969a(String.valueOf(phoneAuthCredential.getSmsCode()));
        }
        m8383b(phoneAuthCredential);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8371a() {
        m8384b(getString(R.string.fui_code_sent));
        this.f6409c.postDelayed(new Runnable() {
            public void run() {
                PhoneVerificationActivity.this.m8392f();
                PhoneVerificationActivity.this.m8390e();
            }
        }, 750);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8377a(FirebaseException firebaseException) {
        m8392f();
        if (firebaseException instanceof FirebaseAuthException) {
            C2016b a = C2016b.m8191a((FirebaseAuthException) firebaseException);
            switch (a) {
                case ERROR_INVALID_PHONE_NUMBER:
                    C2111j jVar = (C2111j) getSupportFragmentManager().mo4369a("VerifyPhoneFragment");
                    if (jVar != null) {
                        jVar.mo11973a(getString(R.string.fui_invalid_phone_number));
                        return;
                    }
                    return;
                case ERROR_TOO_MANY_REQUESTS:
                    m8380a(getString(R.string.fui_error_too_many_attempts), (OnClickListener) null);
                    return;
                case ERROR_QUOTA_EXCEEDED:
                    m8380a(getString(R.string.fui_error_quota_exceeded), (OnClickListener) null);
                    return;
                default:
                    Log.w("PhoneVerification", a.mo11813a(), firebaseException);
                    m8380a(a.mo11813a(), (OnClickListener) null);
                    return;
            }
        } else {
            Log.w("PhoneVerification", firebaseException.getLocalizedMessage());
            m8380a(firebaseException.getLocalizedMessage(), (OnClickListener) null);
        }
    }

    /* renamed from: b */
    private void m8385b(String str, boolean z) {
        this.f6410d = str;
        this.f6414h = C2092a.VERIFICATION_STARTED;
        mo11887c().mo11818d().verifyPhoneNumber(str, 120000, TimeUnit.MILLISECONDS, (Activity) this, (OnVerificationStateChangedCallbacks) new OnVerificationStateChangedCallbacks() {
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                if (!PhoneVerificationActivity.this.f6412f.booleanValue()) {
                    PhoneVerificationActivity.this.m8379a(phoneAuthCredential);
                }
            }

            public void onVerificationFailed(FirebaseException firebaseException) {
                if (!PhoneVerificationActivity.this.f6412f.booleanValue()) {
                    PhoneVerificationActivity.this.m8377a(firebaseException);
                }
            }

            public void onCodeSent(String str, ForceResendingToken forceResendingToken) {
                PhoneVerificationActivity.this.f6411e = str;
                PhoneVerificationActivity.this.f6413g = forceResendingToken;
                if (!PhoneVerificationActivity.this.f6412f.booleanValue()) {
                    PhoneVerificationActivity.this.m8371a();
                }
            }
        }, z ? this.f6413g : null);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m8390e() {
        if (m8393g() == null) {
            C1104o a = getSupportFragmentManager().mo4370a().mo4079b(R.id.fragment_verify_phone, C2104i.m8444a(mo11886b(), this.f6410d), "SubmitConfirmationCodeFragment").mo4070a((String) null);
            if (!isFinishing() && !this.f6412f.booleanValue()) {
                a.mo4086d();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8378a(FirebaseUser firebaseUser) {
        mo11883a(-1, new C2036a(new C2039a("phone", null).mo11864a(firebaseUser.getPhoneNumber()).mo11865a()).mo11848a().mo11835a());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8380a(String str, OnClickListener onClickListener) {
        this.f6408b = new C0447a(this).setMessage((CharSequence) str).setPositiveButton(R.string.fui_incorrect_code_dialog_positive_button_text, onClickListener).show();
    }

    /* renamed from: b */
    private void m8383b(PhoneAuthCredential phoneAuthCredential) {
        mo11887c().mo11815a().signInWithCredential(phoneAuthCredential).addOnSuccessListener((Activity) this, (OnSuccessListener<? super TResult>) new OnSuccessListener<AuthResult>() {
            /* renamed from: a */
            public void onSuccess(final AuthResult authResult) {
                PhoneVerificationActivity.this.f6414h = C2092a.VERIFIED;
                PhoneVerificationActivity.this.m8384b(PhoneVerificationActivity.this.getString(R.string.fui_verified));
                PhoneVerificationActivity.this.f6409c.postDelayed(new Runnable() {
                    public void run() {
                        if (!PhoneVerificationActivity.this.f6412f.booleanValue()) {
                            PhoneVerificationActivity.this.m8392f();
                            PhoneVerificationActivity.this.m8378a(authResult.getUser());
                        }
                    }
                }, 750);
            }
        }).addOnFailureListener((Activity) this, (OnFailureListener) new OnFailureListener() {
            public void onFailure(Exception exc) {
                PhoneVerificationActivity.this.m8392f();
                if (exc instanceof FirebaseAuthInvalidCredentialsException) {
                    C2016b a = C2016b.m8191a((FirebaseAuthInvalidCredentialsException) exc);
                    switch (C20915.f6423a[a.ordinal()]) {
                        case 4:
                            PhoneVerificationActivity.this.m8380a(PhoneVerificationActivity.this.getString(R.string.fui_incorrect_code_dialog_body), (OnClickListener) new OnClickListener() {
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    PhoneVerificationActivity.this.m8393g().mo11969a("");
                                }
                            });
                            return;
                        case 5:
                            PhoneVerificationActivity.this.m8380a(PhoneVerificationActivity.this.getString(R.string.fui_error_session_expired), (OnClickListener) new OnClickListener() {
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    PhoneVerificationActivity.this.m8393g().mo11969a("");
                                }
                            });
                            return;
                        default:
                            Log.w("PhoneVerification", a.mo11813a(), exc);
                            PhoneVerificationActivity.this.m8380a(a.mo11813a(), (OnClickListener) null);
                            return;
                    }
                } else {
                    PhoneVerificationActivity.this.m8380a(exc.getLocalizedMessage(), (OnClickListener) null);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m8384b(String str) {
        if (this.f6407a != null) {
            this.f6407a.mo11943a(str);
        }
    }

    /* renamed from: c */
    private void m8387c(String str) {
        m8392f();
        if (this.f6407a == null) {
            this.f6407a = C2095b.m8402a(getSupportFragmentManager());
        }
        this.f6407a.mo11942a((CharSequence) str);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m8392f() {
        if (this.f6407a != null) {
            this.f6407a.dismissAllowingStateLoss();
            this.f6407a = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public C2104i m8393g() {
        return (C2104i) getSupportFragmentManager().mo4369a("SubmitConfirmationCodeFragment");
    }
}
