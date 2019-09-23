package p140me.bridgefy.main;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.bridgefy.sdk.framework.controller.Constants;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseNetworkException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuth.AuthStateListener;
import com.google.firebase.auth.FirebaseAuth.IdTokenListener;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.PhoneAuthProvider.ForceResendingToken;
import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks;
import java.util.concurrent.TimeUnit;
import p140me.bridgefy.cloud.C3517a;
import p140me.bridgefy.intro.verification.C3581f;
import p140me.bridgefy.intro.verification.C3582g;
import p140me.bridgefy.main.C3602a.C3603a;
import p140me.bridgefy.main.C3602a.C3604b;
import p140me.bridgefy.utils.C3659b;

/* renamed from: me.bridgefy.main.b */
/* compiled from: BGFirebaseAuth */
public class C3605b extends C3602a implements AuthStateListener, IdTokenListener {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static String f9493b = "BGFirebaseAuth";

    /* renamed from: c */
    private FirebaseAuth f9494c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C3604b f9495d;

    /* renamed from: e */
    private Context f9496e;

    /* renamed from: f */
    private int f9497f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public String f9498g;

    /* renamed from: h */
    private C3582g f9499h;

    /* renamed from: i */
    private OnVerificationStateChangedCallbacks f9500i = new OnVerificationStateChangedCallbacks() {
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
            String a = C3605b.f9493b;
            StringBuilder sb = new StringBuilder();
            sb.append("onVerificationCompleted: ");
            sb.append(phoneAuthCredential);
            Log.i(a, sb.toString());
            C3605b.this.m10629a(phoneAuthCredential);
        }

        public void onVerificationFailed(FirebaseException firebaseException) {
            Log.w(C3605b.f9493b, "onVerificationFailed", firebaseException);
            C3605b.this.m10631a((Exception) firebaseException);
        }

        public void onCodeAutoRetrievalTimeOut(String str) {
            String a = C3605b.f9493b;
            StringBuilder sb = new StringBuilder();
            sb.append("CodeAutoRetrievalTimeOut: ");
            sb.append(str);
            Log.w(a, sb.toString());
            C3605b.this.m10632a(C3603a.TIMEOUT, (String) null);
        }

        public void onCodeSent(String str, ForceResendingToken forceResendingToken) {
            String a = C3605b.f9493b;
            StringBuilder sb = new StringBuilder();
            sb.append("onCodeSent: ");
            sb.append(str);
            Log.d(a, sb.toString());
            C3605b.this.f9498g = str;
            C3605b.this.f9495d.mo29450d();
        }
    };

    C3605b(Context context) {
        this.f9496e = context;
        this.f9494c = FirebaseAuth.getInstance();
        this.f9494c.addIdTokenListener((IdTokenListener) this);
        this.f9494c.addAuthStateListener(this);
        this.f9484a = context.getSharedPreferences("BgfyPrefs", 0);
    }

    /* renamed from: a */
    public void mo29552a(Activity activity, C3582g gVar, int i) {
        this.f9495d = (C3604b) activity;
        this.f9497f = i;
        this.f9499h = gVar;
        if (gVar != null) {
            String str = f9493b;
            StringBuilder sb = new StringBuilder();
            sb.append("Login requested: PHONE_NUMBER: ");
            sb.append(gVar);
            Log.i(str, sb.toString());
            PhoneAuthProvider.getInstance().verifyPhoneNumber(gVar.toString(), (long) Constants.KEEP_ALIVE_INTERVAL, TimeUnit.MILLISECONDS, activity, this.f9500i);
            return;
        }
        Log.i(f9493b, "Login requested: ANONYMOUS");
        this.f9494c.signInAnonymously().addOnCompleteListener(activity, (OnCompleteListener<TResult>) new OnCompleteListener() {
            public final void onComplete(Task task) {
                C3605b.this.m10627a(task);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m10627a(Task task) {
        if (task.isSuccessful()) {
            m10628a(((AuthResult) task.getResult()).getUser(), (String) null);
            return;
        }
        Log.w(f9493b, "signIn-anonymous: FAILURE", task.getException());
        m10631a(task.getException());
    }

    /* renamed from: a */
    public void mo29553a(String str) {
        if (str == null || str.trim().equals("")) {
            Log.w(f9493b, "The verification code was invalid");
            m10632a(C3603a.INCORRECT_CODE, this.f9496e.getString(R.string.verify_error_code));
            return;
        }
        m10629a(PhoneAuthProvider.getCredential(this.f9498g, str));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10629a(PhoneAuthCredential phoneAuthCredential) {
        int i = this.f9497f;
        if (i == 1313) {
            this.f9494c.signInWithCredential(phoneAuthCredential).addOnCompleteListener(new OnCompleteListener(phoneAuthCredential) {
                private final /* synthetic */ PhoneAuthCredential f$1;

                {
                    this.f$1 = r2;
                }

                public final void onComplete(Task task) {
                    C3605b.this.m10636b(this.f$1, task);
                }
            });
        } else if (i == 2323) {
            this.f9494c.getCurrentUser().linkWithCredential(phoneAuthCredential).addOnCompleteListener(new OnCompleteListener(phoneAuthCredential) {
                private final /* synthetic */ PhoneAuthCredential f$1;

                {
                    this.f$1 = r2;
                }

                public final void onComplete(Task task) {
                    C3605b.this.m10630a(this.f$1, task);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m10636b(PhoneAuthCredential phoneAuthCredential, Task task) {
        if (task.isSuccessful()) {
            m10628a(((AuthResult) task.getResult()).getUser(), phoneAuthCredential.getSmsCode());
            return;
        }
        Log.e(f9493b, "signIn-telephone: FAILURE", task.getException());
        m10631a(task.getException());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m10630a(PhoneAuthCredential phoneAuthCredential, Task task) {
        if (task.isSuccessful()) {
            m10628a(((AuthResult) task.getResult()).getUser(), phoneAuthCredential.getSmsCode());
            return;
        }
        Log.e(f9493b, "signIn-telephone: FAILURE", task.getException());
        m10631a(task.getException());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10631a(Exception exc) {
        if (exc == null) {
            m10632a(C3603a.UNKNOWN, this.f9496e.getString(R.string.error));
        } else if (exc instanceof FirebaseAuthException) {
            switch (C3581f.m10521a((FirebaseAuthException) exc)) {
                case ERROR_INVALID_VERIFICATION_CODE:
                    m10632a(C3603a.INCORRECT_CODE, this.f9496e.getString(R.string.verify_error_code));
                    return;
                case ERROR_INVALID_PHONE_NUMBER:
                    m10632a(C3603a.PHONE_FORMAT, this.f9496e.getString(R.string.verify_error_phone));
                    return;
                case ERROR_TOO_MANY_REQUESTS:
                    m10632a(C3603a.QUOTA_EXCEEDED, this.f9496e.getString(R.string.fui_error_too_many_attempts));
                    return;
                case ERROR_QUOTA_EXCEEDED:
                    m10632a(C3603a.QUOTA_EXCEEDED, this.f9496e.getString(R.string.fui_error_quota_exceeded));
                    return;
                case ERROR_CREDENTIAL_ALREADY_IN_USE:
                    m10632a(C3603a.USER_COLLISION, exc.getLocalizedMessage());
                    return;
                default:
                    m10632a(C3603a.UNKNOWN, this.f9496e.getString(R.string.error));
                    return;
            }
        } else if (exc instanceof FirebaseNetworkException) {
            m10632a(C3603a.NETWORK_ERROR, this.f9496e.getString(R.string.error_registration_network));
        } else {
            m10632a(C3603a.UNKNOWN, exc.getLocalizedMessage());
        }
    }

    public void onAuthStateChanged(FirebaseAuth firebaseAuth) {
        Log.i(f9493b, "onAuthStateChanged");
    }

    /* renamed from: a */
    private void m10628a(FirebaseUser firebaseUser, String str) {
        Log.i(f9493b, "onVerificationSuccess!");
        if (firebaseUser != null) {
            Bundle bundle = new Bundle();
            String phoneNumber = firebaseUser.getPhoneNumber();
            if (phoneNumber != null && !phoneNumber.trim().equals("")) {
                C3608c.m10644a(phoneNumber);
                this.f9484a.edit().putString("user_phone", phoneNumber).apply();
                bundle.putString("phone", this.f9499h.mo29501e());
            }
            bundle.putString("providerId", firebaseUser.getUid());
            String str2 = f9493b;
            StringBuilder sb = new StringBuilder();
            sb.append("... providerId: ");
            sb.append(firebaseUser.getUid());
            Log.v(str2, sb.toString());
            C3517a.m10259a(this.f9496e);
            if (this.f9495d != null) {
                new Handler().postDelayed(new Runnable(bundle, str) {
                    private final /* synthetic */ Bundle f$1;
                    private final /* synthetic */ String f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        C3605b.this.m10626a(this.f$1, this.f$2);
                    }
                }, 1000);
                return;
            }
            return;
        }
        Log.e(f9493b, "This is not supposed to happen!");
        m10632a(C3603a.UNKNOWN, (String) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m10626a(Bundle bundle, String str) {
        this.f9495d.mo29445a(bundle, str);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10632a(C3603a aVar, String str) {
        C3659b.m10894a("Session", "newDigitsUserFailed", null, 0, BridgefyApp.m10557c().mo29529e());
        if (this.f9495d != null) {
            C3604b bVar = this.f9495d;
            if (str == null) {
                str = this.f9496e.getString(R.string.error_try_again);
            }
            bVar.mo29446a(aVar, str);
        }
    }

    public void onIdTokenChanged(FirebaseAuth firebaseAuth) {
        Log.v(f9493b, "onIdTokenChanged");
    }
}
