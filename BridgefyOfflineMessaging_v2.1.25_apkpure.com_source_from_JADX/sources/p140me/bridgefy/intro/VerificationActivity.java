package p140me.bridgefy.intro;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.bridgefy.sdk.framework.controller.Constants;
import com.firebase.p119ui.auth.p121b.C2020b;
import com.firebase.p119ui.auth.p124ui.phone.C2095b;
import com.firebase.p119ui.auth.p124ui.phone.SpacedEditText;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import java.util.Locale;
import me.bridgefy.main.R;
import net.sqlcipher.database.SQLiteDatabase;
import p140me.bridgefy.intro.verification.C3572a;
import p140me.bridgefy.intro.verification.C3572a.C3573a;
import p140me.bridgefy.intro.verification.C3574b;
import p140me.bridgefy.intro.verification.C3579e;
import p140me.bridgefy.intro.verification.C3582g;
import p140me.bridgefy.intro.verification.C3583h;
import p140me.bridgefy.intro.verification.C3584i;
import p140me.bridgefy.intro.verification.C3584i.C3585a;
import p140me.bridgefy.intro.verification.C3586j;
import p140me.bridgefy.intro.verification.C3586j.C3587a;
import p140me.bridgefy.intro.verification.CountryListSpinner;
import p140me.bridgefy.main.BridgefyApp;
import p140me.bridgefy.main.C3602a.C3603a;
import p140me.bridgefy.main.C3602a.C3604b;
import p140me.bridgefy.main.C3608c;
import p140me.bridgefy.ormlite.DatabaseHelper;
import p140me.bridgefy.ormlite.apptools.BridgefyOrmLiteBaseActivity;
import p140me.bridgefy.utils.C3659b;

/* renamed from: me.bridgefy.intro.VerificationActivity */
public class VerificationActivity extends BridgefyOrmLiteBaseActivity<DatabaseHelper> implements C3585a, C3587a, C3604b {

    /* renamed from: a */
    C3582g f9339a;

    /* renamed from: b */
    C2095b f9340b;

    /* renamed from: c */
    private C3579e f9341c;

    /* renamed from: d */
    private String f9342d = "------";

    /* renamed from: e */
    private int f9343e = 1;

    /* renamed from: f */
    private int f9344f = 0;

    /* renamed from: g */
    private Handler f9345g;

    /* renamed from: h */
    private int f9346h;
    @BindView(2131296493)
    View layoutCancel;
    @BindView(2131296494)
    View layoutCode;
    @BindView(2131296495)
    View layoutPhone;
    @BindView(2131296496)
    View layoutSkip;
    @BindView(2131296371)
    SpacedEditText mCodeEditText;
    @BindView(2131296657)
    TextView mCountDownTextView;
    @BindView(2131296380)
    CountryListSpinner mCountryListSpinner;
    @BindView(2131296555)
    TextView mErrorEditText;
    @BindView(2131296556)
    EditText mPhoneEditText;
    @BindView(2131296557)
    TextView mPhoneLabel;
    @BindView(2131296571)
    TextView mResendCodeTextView;
    @BindView(2131296731)
    TextView mSkipTextView;
    @BindView(2131296345)
    Button mSubmitCodeButton;
    @BindView(2131296344)
    Button mSubmitPhoneButton;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_verification);
        ButterKnife.bind((Activity) this);
        this.f9345g = new Handler();
        this.f9346h = getIntent().getIntExtra("requestCode", -1);
        if (!C3659b.m10909e((Context) this) || this.f9346h == 2323) {
            this.f9344f = this.f9343e;
            m10469e();
        }
        if (bundle == null) {
            m10475k();
        }
        m10470f();
        TextView textView = this.mSkipTextView;
        StringBuilder sb = new StringBuilder();
        sb.append(getString(R.string.verify_skip));
        sb.append(" <u>");
        sb.append(getString(R.string.verify_skip_tag));
        sb.append("</u>");
        textView.setText(Html.fromHtml(sb.toString()));
    }

    public void onBackPressed() {
        if (this.layoutCode.getVisibility() == 0) {
            this.layoutPhone.setVisibility(0);
            this.layoutCode.setVisibility(8);
            return;
        }
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        m10474j();
        super.onDestroy();
    }

    @OnClick({2131296344})
    public void onRequestVerification() {
        m10472h();
        if (this.f9339a != null) {
            m10466b(getString(R.string.fui_verifying));
        } else {
            this.f9339a = m10473i();
        }
        if (this.f9339a != null) {
            try {
                BridgefyApp.m10558f().mo29552a(this, this.f9339a, this.f9346h);
            } catch (NullPointerException unused) {
                Toast.makeText(this, getString(R.string.verification_accountless_google), 1).show();
            }
        } else {
            mo29446a(C3603a.PHONE_FORMAT, getString(R.string.verify_error_phone));
        }
    }

    @OnClick({2131296345})
    public void completeVerificationRequest() {
        m10466b(getString(R.string.fui_verifying));
        m10472h();
        BridgefyApp.m10558f().mo29553a(this.mCodeEditText.getText().toString().replaceAll("\\s+", ""));
    }

    @OnClick({2131296571})
    public void onRetryVerification() {
        this.mCodeEditText.setError(null);
        m10472h();
        m10469e();
        m10466b(getString(R.string.fui_resending));
        BridgefyApp.m10558f().mo29552a(this, this.f9339a, this.f9346h);
    }

    @OnClick({2131296731})
    public void onSkip() {
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        beginTransaction.add(new C3584i(), C3584i.f9449a);
        beginTransaction.commitAllowingStateLoss();
    }

    @OnClick({2131296728})
    public void onCancel() {
        setResult(0);
        finish();
    }

    /* renamed from: a */
    public void mo29444a() {
        m10466b(getString(R.string.verify_bypass_progress));
        this.settings.edit().putLong("verificationTimer", System.currentTimeMillis()).apply();
        BridgefyApp.m10558f().mo29552a(this, null, this.f9346h);
    }

    /* renamed from: b */
    public void mo29447b() {
        C3659b.m10887a((Activity) this);
    }

    /* renamed from: c */
    public void mo29448c() {
        C3608c.m10642a(this, (DatabaseHelper) getHelper(), 1);
    }

    /* renamed from: d */
    public void mo29450d() {
        m10460a(getString(R.string.fui_code_sent));
        this.f9345g.postDelayed(new Runnable() {
            public final void run() {
                VerificationActivity.this.m10477m();
            }
        }, 750);
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public /* synthetic */ void m10477m() {
        m10474j();
        if (!(this.layoutPhone.getVisibility() == 8 || this.mPhoneLabel == null)) {
            this.layoutPhone.setVisibility(8);
            this.layoutCode.setVisibility(0);
            this.mPhoneLabel.setText(this.f9339a.mo29499c());
            this.f9344f = 0;
        }
        m10469e();
        m10465b((long) Constants.KEEP_ALIVE_INTERVAL);
        m10464a(true);
    }

    /* renamed from: a */
    public void mo29445a(Bundle bundle, String str) {
        if (str != null) {
            m10460a(getString(R.string.fui_verified));
        } else {
            m10460a(getString(R.string.verify_bypass_success));
            str = this.f9342d;
        }
        this.mCodeEditText.setText(str);
        int i = this.f9346h;
        if (i == 1313) {
            Intent addFlags = new Intent(getApplicationContext(), SignupActivity.class).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            addFlags.putExtras(bundle);
            setResult(-1, addFlags);
        } else if (i == 2323) {
            setResult(-1);
        }
        finish();
    }

    /* renamed from: a */
    public void mo29446a(C3603a aVar, String str) {
        m10474j();
        switch (aVar) {
            case PHONE_FORMAT:
                this.mPhoneEditText.setError(str);
                m10469e();
                break;
            case TIMEOUT:
                m10472h();
                m10469e();
                break;
            case INCORRECT_CODE:
                m10464a(false);
                this.mCodeEditText.setError(str);
                m10469e();
                break;
            case USER_COLLISION:
                new C3586j().show(getFragmentManager(), C3586j.f9451a);
                break;
            default:
                m10464a(false);
                Toast.makeText(this, str, 1).show();
                m10469e();
                break;
        }
        setResult(0);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 22 && intent != null) {
            Credential credential = (Credential) intent.getParcelableExtra(Credential.EXTRA_KEY);
            if (credential != null) {
                String id = credential.getId();
                String a = C3583h.m10530a(id, (Context) this);
                if (a == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unable to normalize phone number from hint selector:");
                    sb.append(id);
                    Log.e("VerificationActivity", sb.toString());
                    return;
                }
                this.f9339a = C3583h.m10535a(a);
                m10463a(this.f9339a);
                m10468b(this.f9339a);
                onRequestVerification();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m10469e() {
        StringBuilder sb = new StringBuilder();
        sb.append("Current retries: ");
        sb.append(this.f9344f);
        Log.d("VerificationActivity", sb.toString());
        if (this.f9344f >= this.f9343e) {
            int i = this.f9346h;
            if (i == 1313) {
                this.layoutSkip.setAnimation(AnimationUtils.loadAnimation(this, R.anim.view_entry_anim_slide_down));
                this.layoutSkip.setVisibility(0);
            } else if (i == 2323) {
                this.layoutCancel.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m10458a(View view) {
        this.mErrorEditText.setText("");
    }

    /* renamed from: f */
    private void m10470f() {
        this.mCountryListSpinner.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                VerificationActivity.this.m10458a(view);
            }
        });
    }

    /* renamed from: a */
    private void m10464a(boolean z) {
        this.mCodeEditText.requestFocus();
        this.mCodeEditText.setText(this.f9342d);
        if (z) {
            this.mCodeEditText.addTextChangedListener(new C3572a(this.mCodeEditText, 6, "-", m10455a(this.mSubmitCodeButton)));
        }
    }

    /* renamed from: a */
    private C3573a m10455a(final Button button) {
        return new C3573a() {
            /* renamed from: a */
            public void mo29455a() {
                button.setEnabled(true);
            }

            /* renamed from: b */
            public void mo29456b() {
                button.setEnabled(false);
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10457a(long j) {
        this.mCountDownTextView.setText(String.format(getString(R.string.fui_resend_code_in), new Object[]{Integer.valueOf(m10454a((double) j))}));
    }

    /* renamed from: b */
    private void m10465b(long j) {
        this.mCountDownTextView.setVisibility(0);
        this.mResendCodeTextView.setVisibility(8);
        m10457a(j / 1000);
        this.f9341c = m10456a(this.mCountDownTextView, this.mResendCodeTextView, j);
        m10471g();
    }

    /* renamed from: a */
    private int m10454a(double d) {
        return (int) Math.ceil(d / 1000.0d);
    }

    /* renamed from: a */
    private C3579e m10456a(TextView textView, TextView textView2, long j) {
        final TextView textView3 = textView;
        final TextView textView4 = textView2;
        C35622 r0 = new C3579e(j, 1000) {
            /* renamed from: a */
            public void mo29458a(long j) {
                VerificationActivity.this.m10457a(j);
            }

            /* renamed from: a */
            public void mo29457a() {
                textView3.setText("");
                textView3.setVisibility(8);
                textView4.setVisibility(0);
                VerificationActivity.this.m10472h();
                VerificationActivity.this.m10469e();
            }
        };
        return r0;
    }

    /* renamed from: g */
    private void m10471g() {
        if (this.f9341c != null) {
            this.f9341c.mo29495b();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m10472h() {
        this.f9344f++;
    }

    /* renamed from: a */
    private void m10463a(C3582g gVar) {
        if (C3582g.m10524a(gVar)) {
            this.mPhoneEditText.setText(gVar.mo29499c());
            this.mPhoneEditText.setSelection(gVar.mo29499c().length());
        }
    }

    /* renamed from: b */
    private void m10468b(C3582g gVar) {
        if (C3582g.m10525b(gVar)) {
            this.mCountryListSpinner.mo29468a(new Locale("", gVar.mo29500d()), gVar.mo29498b());
        }
    }

    /* renamed from: i */
    private C3582g m10473i() {
        C3574b bVar = (C3574b) this.mCountryListSpinner.getTag();
        String trim = this.mPhoneEditText.getText().toString().trim();
        if (!TextUtils.isEmpty(trim)) {
            return new C3582g(bVar.mo29481a(), trim);
        }
        return null;
    }

    /* renamed from: a */
    private void m10460a(String str) {
        if (this.f9340b != null) {
            this.f9340b.mo11943a(str);
        }
    }

    /* renamed from: b */
    private void m10466b(String str) {
        m10474j();
        if (this.f9340b == null) {
            this.f9340b = C2095b.m8402a(getSupportFragmentManager());
        }
        this.f9340b.mo11942a((CharSequence) str);
    }

    /* renamed from: j */
    private void m10474j() {
        if (this.f9340b != null && this.f9340b.isAdded()) {
            if (getFragmentManager() != null) {
                this.f9340b.dismissAllowingStateLoss();
            } else {
                this.f9340b.dismiss();
            }
            this.f9340b = null;
        }
    }

    /* renamed from: k */
    private void m10475k() {
        try {
            startIntentSenderForResult(m10476l().getIntentSender(), 22, null, 0, 0, 0);
        } catch (SendIntentException e) {
            Log.e("VerificationActivity", "Unable to start hint intent", e);
        }
    }

    /* renamed from: l */
    private PendingIntent m10476l() {
        return Auth.CredentialsApi.getHintPickerIntent(new Builder(this).addApi(Auth.CREDENTIALS_API).enableAutoManage(this, C2020b.m8200a(), $$Lambda$VerificationActivity$V1HbBWn0Xb_QL0UyqfalSCfJXoc.INSTANCE).build(), new HintRequest.Builder().setHintPickerConfig(new CredentialPickerConfig.Builder().setShowCancelButton(true).build()).setPhoneNumberIdentifierSupported(true).setEmailAddressIdentifierSupported(false).build());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m10459a(ConnectionResult connectionResult) {
        StringBuilder sb = new StringBuilder();
        sb.append("Client connection failed: ");
        sb.append(connectionResult.getErrorMessage());
        Log.e("VerificationActivity", sb.toString());
    }
}
