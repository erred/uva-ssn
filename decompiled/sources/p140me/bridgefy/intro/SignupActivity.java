package p140me.bridgefy.intro;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import androidx.core.app.C0840a;
import androidx.core.content.C0875a;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.firebase.analytics.FirebaseAnalytics.Event;
import com.google.firebase.iid.FirebaseInstanceId;
import java.net.UnknownHostException;
import java.util.List;
import java.util.UUID;
import me.bridgefy.main.R;
import p000a.p013b.p017b.C0161b;
import p140me.bridgefy.backend.p143v3.bgfyUserApi.model.BgfyUser;
import p140me.bridgefy.cloud.google_controller;
import p140me.bridgefy.cloud.C3519c;
import p140me.bridgefy.cloud.C3519c.C3521a;
import p140me.bridgefy.cloud.C3519c.C3522b;
import p140me.bridgefy.cloud.C3519c.C3523c;
import p140me.bridgefy.entities.BridgefyPeer;
import p140me.bridgefy.intro.verification.C3582g;
import p140me.bridgefy.intro.verification.C3583h;
import p140me.bridgefy.main.BridgefyApp;
import p140me.bridgefy.main.C3608c;
import p140me.bridgefy.main.TabbedMainActivity;
import p140me.bridgefy.ormlite.DatabaseHelper;
import p140me.bridgefy.ormlite.apptools.BridgefyOrmLiteBaseActivity;
import p140me.bridgefy.ormlite.entities.FriendDTO;
import p140me.bridgefy.p141a.C3457c;
import p140me.bridgefy.utils.C3659b;
import p140me.bridgefy.utils.C3662d;
import p140me.bridgefy.utils.PermissionFragment;
import p140me.bridgefy.utils.PermissionFragment.C3655a;

/* renamed from: me.bridgefy.intro.SignupActivity */
public class SignupActivity extends BridgefyOrmLiteBaseActivity<DatabaseHelper> implements C3655a {

    /* renamed from: a */
    final String f9313a = "SignupActivity";

    /* renamed from: b */
    boolean f9314b = false;

    /* renamed from: c */
    boolean f9315c = false;
    @BindString(2131689590)
    String contactsPermissionString;

    /* renamed from: d */
    PermissionFragment f9316d;

    /* renamed from: e */
    PermissionFragment f9317e;

    /* renamed from: f */
    protected BgfyUser f9318f;

    /* renamed from: g */
    C3582g f9319g;

    /* renamed from: h */
    String f9320h;

    /* renamed from: i */
    C3521a f9321i = new C3521a() {
        public void onComplete() {
            SignupActivity.this.m10445c(SignupActivity.this.f9324l);
            C3659b.m10894a("Session", Event.LOGIN, String.valueOf(SignupActivity.this.f9318f.getCountry()), 0, BridgefyApp.m10557c().mo29529e());
            C3608c.m10641a(SignupActivity.this, SignupActivity.this.f9318f);
            SignupActivity.this.m10446d();
        }

        public void onError(Throwable th) {
            th.printStackTrace();
            SignupActivity.this.m10445c(SignupActivity.this.f9324l);
            SignupActivity.this.m10434a(th);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f9322j = false;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f9323k = true;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f9324l = false;
    @BindString(2131689785)
    String locationPermissionString;
    @BindView(2131296511)
    View mProgressView;
    @BindView(2131296570)
    Button mRegisterButton;
    @BindView(2131296740)
    EditText mUsernameView;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_signup);
        ButterKnife.bind((Activity) this);
        BridgefyApp.m10557c().mo29530g().mo27385a((Object) this);
        mo29439a(true);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        Log.d("SignupActivity", "onStart()");
        super.onStart();
        if (getIntent() == null || getIntent().getExtras() == null) {
            Log.w("SignupActivity", "Bundle information was null, probably an illegal state. Clearing everything.");
            C3608c.m10642a(this, (DatabaseHelper) getHelper(), 3);
            return;
        }
        this.f9320h = getIntent().getExtras().getString("providerId", null);
        String string = getIntent().getExtras().getString("phone", null);
        try {
            this.f9319g = C3582g.m10523a(string);
        } catch (Exception unused) {
            this.f9319g = C3583h.m10535a(string);
        }
        if (string == null || string.trim().equals("")) {
            this.f9319g = C3582g.m10522a();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("phoneNumber: ");
        sb.append(this.f9319g);
        Log.v("SignupActivity", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("providerId:  ");
        sb2.append(this.f9320h);
        Log.v("SignupActivity", sb2.toString());
        this.mUsernameView.setText(Build.MODEL);
        m10437a(this.f9319g, this.f9320h);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Log.w("SignupActivity", "onDestroy()");
        BridgefyApp.m10557c().mo29530g().mo27388b((Object) this);
        super.onDestroy();
    }

    /* renamed from: a */
    private void m10437a(final C3582g gVar, final String str) {
        C3519c.m10314a((C3523c) new C3523c<BgfyUser>() {
            public void onSubscribe(C0161b bVar) {
                google_controller.initialize_google_controller((Context) SignupActivity.this);
                SignupActivity.this.m10440b(SignupActivity.this.f9323k);
            }

            /* renamed from: a */
            public void onSuccess(BgfyUser bgfyUser) {
                SignupActivity.this.f9318f = bgfyUser;
                if (SignupActivity.this.f9318f != null) {
                    if (bgfyUser.getUuid() != null) {
                        Log.d("SignupActivity", "This is a returning user, how exciting!");
                        StringBuilder sb = new StringBuilder();
                        sb.append("... with providerId: ");
                        sb.append(bgfyUser.getDigitsId());
                        Log.v("SignupActivity", sb.toString());
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("... and userId: ");
                        sb2.append(bgfyUser.getUuid());
                        Log.v("SignupActivity", sb2.toString());
                        SignupActivity.this.f9322j = true;
                        SignupActivity.this.mUsernameView.setText(SignupActivity.this.f9318f.getPublicName());
                        SignupActivity.this.f9318f.setDigitsId(str);
                    } else {
                        Log.v("SignupActivity", "Creating new user from scratch!");
                        SignupActivity.this.f9318f.setPhone(gVar.mo29499c());
                        SignupActivity.this.f9318f.setCountry(Integer.valueOf(Integer.parseInt(gVar.mo29498b())));
                        SignupActivity.this.f9318f.setUuid(UUID.randomUUID().toString());
                    }
                    SignupActivity.this.m10445c(SignupActivity.this.f9324l);
                    String token = FirebaseInstanceId.getInstance().getToken();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("onSuccess: token is ");
                    sb3.append(token);
                    Log.i("SignupActivity", sb3.toString());
                    if (token != null) {
                        SignupActivity.this.f9318f.setRegistrationId(token);
                    } else {
                        onError(new Exception(SignupActivity.this.getString(R.string.error)));
                    }
                } else {
                    onError(new Exception(SignupActivity.this.getString(R.string.error)));
                }
            }

            public void onError(Throwable th) {
                th.printStackTrace();
                SignupActivity.this.m10434a(th);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m10440b(boolean z) {
        this.mUsernameView.setEnabled(false);
        this.mRegisterButton.setEnabled(false);
        mo29439a(z);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m10445c(boolean z) {
        this.mUsernameView.setEnabled(true);
        this.mRegisterButton.setEnabled(true);
        mo29439a(z);
    }

    @OnClick({2131296570})
    public void attemptLogin() {
        if (this.f9318f == null) {
            m10437a(this.f9319g, this.f9320h);
            return;
        }
        String b = m10439b();
        if (b != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
            View currentFocus = getCurrentFocus();
            if (currentFocus != null) {
                inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
            }
            m10445c(this.f9323k);
            this.f9318f.setPublicName(b);
            if (this.f9322j) {
                C3519c.m10312a(this.f9318f, this.f9321i);
            } else {
                C3519c.m10318b(this.f9318f, this.f9321i);
            }
        }
    }

    /* renamed from: b */
    private String m10439b() {
        this.mUsernameView.setError(null);
        String obj = this.mUsernameView.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            this.mUsernameView.setError(getString(R.string.error_field_required));
            this.mUsernameView.requestFocus();
        } else if (!C3659b.m10908d(obj)) {
            return obj;
        } else {
            this.mUsernameView.setError(getString(R.string.error_username_invalid));
            this.mUsernameView.requestFocus();
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10434a(Throwable th) {
        m10445c(this.f9324l);
        if (th.getClass().equals(UnknownHostException.class)) {
            this.mUsernameView.setError(getString(R.string.error_registration_network));
        } else {
            this.mUsernameView.setError(getString(R.string.error_try_again));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m10446d() {
        Log.d("SignupActivity", "checkPermissions()");
        if (C0875a.m3245b((Context) this, "android.permission.ACCESS_FINE_LOCATION") != 0 && !isFinishing()) {
            Log.v("SignupActivity", "... showing Location permission fragment");
            FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
            PermissionFragment a = PermissionFragment.m10877a(this.locationPermissionString);
            this.f9316d = a;
            beginTransaction.add(R.id.signup_container, a).commitAllowingStateLoss();
        } else if (C0875a.m3245b((Context) this, "android.permission.READ_CONTACTS") == 0 || isFinishing()) {
            Log.v("SignupActivity", "... both permissions granted!");
            mo29438a();
            m10447e();
        } else {
            this.f9314b = true;
            Log.v("SignupActivity", "... showing Contacts permission fragment");
            FragmentTransaction beginTransaction2 = getFragmentManager().beginTransaction();
            PermissionFragment a2 = PermissionFragment.m10877a(this.contactsPermissionString);
            this.f9317e = a2;
            beginTransaction2.add(R.id.signup_container, a2).commitAllowingStateLoss();
        }
    }

    /* renamed from: c */
    public void mo29157c() {
        Log.d("SignupActivity", "onFragmentInteraction()");
        if (!this.f9314b) {
            Log.v("SignupActivity", "... click on Location Fragment");
            this.f9314b = true;
            C0840a.m3096a(this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 2);
            return;
        }
        Log.v("SignupActivity", "... click on Contacts Fragment");
        C0840a.m3096a(this, new String[]{"android.permission.READ_CONTACTS"}, 3);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Log.d("SignupActivity", "onRequestPermissionsResult()");
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (iArr.length <= 0 || strArr.length <= 0) {
            Log.w("SignupActivity", "... permission request canceled by the user.");
            m10447e();
            return;
        }
        if (i == 2) {
            StringBuilder sb = new StringBuilder();
            sb.append("... Location permission result: ");
            sb.append(iArr[0]);
            Log.v("SignupActivity", sb.toString());
            if (strArr[0].equals("android.permission.ACCESS_FINE_LOCATION") && iArr[0] == 0) {
                this.f9315c = true;
            }
            if (this.f9316d != null) {
                FragmentTransaction remove = getFragmentManager().beginTransaction().remove(this.f9316d);
                PermissionFragment a = PermissionFragment.m10877a(this.contactsPermissionString);
                this.f9317e = a;
                remove.add(R.id.signup_container, a).commit();
            } else {
                FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
                PermissionFragment a2 = PermissionFragment.m10877a(this.contactsPermissionString);
                this.f9317e = a2;
                beginTransaction.add(R.id.signup_container, a2).commit();
            }
        }
        if (i == 3) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("... Contacts permission result: ");
            sb2.append(iArr[0]);
            Log.v("SignupActivity", sb2.toString());
            if (this.f9317e != null) {
                getFragmentManager().beginTransaction().remove(this.f9317e).commit();
            }
            if (strArr[0].equals("android.permission.READ_CONTACTS") && iArr[0] == 0) {
                mo29438a();
            }
            m10447e();
        }
    }

    /* renamed from: e */
    private void m10447e() {
        Log.d("SignupActivity", "Signup successful! Starting TabbedMainActivity...");
        Intent intent = new Intent(getBaseContext(), TabbedMainActivity.class);
        intent.setFlags(268468224);
        startActivity(intent);
        finish();
    }

    /* renamed from: a */
    public void mo29438a() {
        try {
            C3662d dVar = new C3662d(this, null);
            final C3457c cVar = new C3457c((DatabaseHelper) getHelper());
            final List blockedContacts = this.f9318f.getBlockedContacts();
            C3519c.m10300a(this.settings, cVar, dVar, (C3522b) new C3522b<BridgefyPeer>() {
                /* renamed from: a */
                public void onNext(BridgefyPeer bridgefyPeer) {
                    if (blockedContacts != null && blockedContacts.size() > 0) {
                        for (String str : blockedContacts) {
                            if (str.equals(bridgefyPeer.getId())) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("Updating local blocked contact: ");
                                sb.append(str);
                                Log.d("SignupActivity", sb.toString());
                                cVar.set_friend_dto(new FriendDTO(bridgefyPeer).setBlockedStatus(3));
                                return;
                            }
                        }
                    }
                }

                public void onError(Throwable th) {
                    th.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void mo29439a(final boolean z) {
        int integer = getResources().getInteger(17694720);
        this.mProgressView.setVisibility(z ? 0 : 8);
        this.mProgressView.animate().setDuration((long) integer).alpha(z ? 1.0f : BitmapDescriptorFactory.HUE_RED).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                SignupActivity.this.mProgressView.setVisibility(z ? 0 : 8);
            }
        });
    }
}
