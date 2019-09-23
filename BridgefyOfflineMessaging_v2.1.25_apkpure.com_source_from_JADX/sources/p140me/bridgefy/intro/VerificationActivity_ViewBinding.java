package p140me.bridgefy.intro;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.firebase.p119ui.auth.p124ui.phone.SpacedEditText;
import me.bridgefy.main.R;
import p140me.bridgefy.intro.verification.CountryListSpinner;

/* renamed from: me.bridgefy.intro.VerificationActivity_ViewBinding */
public class VerificationActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private VerificationActivity f9353a;

    /* renamed from: b */
    private View f9354b;

    /* renamed from: c */
    private View f9355c;

    /* renamed from: d */
    private View f9356d;

    /* renamed from: e */
    private View f9357e;

    /* renamed from: f */
    private View f9358f;

    public VerificationActivity_ViewBinding(final VerificationActivity verificationActivity, View view) {
        this.f9353a = verificationActivity;
        verificationActivity.mPhoneEditText = (EditText) Utils.findRequiredViewAsType(view, R.id.phone_number_input, "field 'mPhoneEditText'", EditText.class);
        verificationActivity.mPhoneLabel = (TextView) Utils.findRequiredViewAsType(view, R.id.phone_number_label, "field 'mPhoneLabel'", TextView.class);
        verificationActivity.mErrorEditText = (TextView) Utils.findRequiredViewAsType(view, R.id.phone_number_error, "field 'mErrorEditText'", TextView.class);
        verificationActivity.mCodeEditText = (SpacedEditText) Utils.findRequiredViewAsType(view, R.id.confirmation_code, "field 'mCodeEditText'", SpacedEditText.class);
        verificationActivity.mCountDownTextView = (TextView) Utils.findRequiredViewAsType(view, R.id.ticker, "field 'mCountDownTextView'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.resend_code, "field 'mResendCodeTextView' and method 'onRetryVerification'");
        verificationActivity.mResendCodeTextView = (TextView) Utils.castView(findRequiredView, R.id.resend_code, "field 'mResendCodeTextView'", TextView.class);
        this.f9354b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                verificationActivity.onRetryVerification();
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.txt_skip, "field 'mSkipTextView' and method 'onSkip'");
        verificationActivity.mSkipTextView = (TextView) Utils.castView(findRequiredView2, R.id.txt_skip, "field 'mSkipTextView'", TextView.class);
        this.f9355c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                verificationActivity.onSkip();
            }
        });
        View findRequiredView3 = Utils.findRequiredView(view, R.id.btn_submit, "field 'mSubmitPhoneButton' and method 'onRequestVerification'");
        verificationActivity.mSubmitPhoneButton = (Button) Utils.castView(findRequiredView3, R.id.btn_submit, "field 'mSubmitPhoneButton'", Button.class);
        this.f9356d = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                verificationActivity.onRequestVerification();
            }
        });
        View findRequiredView4 = Utils.findRequiredView(view, R.id.btn_verify, "field 'mSubmitCodeButton' and method 'completeVerificationRequest'");
        verificationActivity.mSubmitCodeButton = (Button) Utils.castView(findRequiredView4, R.id.btn_verify, "field 'mSubmitCodeButton'", Button.class);
        this.f9357e = findRequiredView4;
        findRequiredView4.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                verificationActivity.completeVerificationRequest();
            }
        });
        verificationActivity.layoutSkip = Utils.findRequiredView(view, R.id.layout_skip, "field 'layoutSkip'");
        verificationActivity.layoutCancel = Utils.findRequiredView(view, R.id.layout_cancel, "field 'layoutCancel'");
        verificationActivity.layoutPhone = Utils.findRequiredView(view, R.id.layout_phone, "field 'layoutPhone'");
        verificationActivity.layoutCode = Utils.findRequiredView(view, R.id.layout_code, "field 'layoutCode'");
        verificationActivity.mCountryListSpinner = (CountryListSpinner) Utils.findRequiredViewAsType(view, R.id.country_list, "field 'mCountryListSpinner'", CountryListSpinner.class);
        View findRequiredView5 = Utils.findRequiredView(view, R.id.txt_cancel, "method 'onCancel'");
        this.f9358f = findRequiredView5;
        findRequiredView5.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                verificationActivity.onCancel();
            }
        });
    }

    public void unbind() {
        VerificationActivity verificationActivity = this.f9353a;
        if (verificationActivity != null) {
            this.f9353a = null;
            verificationActivity.mPhoneEditText = null;
            verificationActivity.mPhoneLabel = null;
            verificationActivity.mErrorEditText = null;
            verificationActivity.mCodeEditText = null;
            verificationActivity.mCountDownTextView = null;
            verificationActivity.mResendCodeTextView = null;
            verificationActivity.mSkipTextView = null;
            verificationActivity.mSubmitPhoneButton = null;
            verificationActivity.mSubmitCodeButton = null;
            verificationActivity.layoutSkip = null;
            verificationActivity.layoutCancel = null;
            verificationActivity.layoutPhone = null;
            verificationActivity.layoutCode = null;
            verificationActivity.mCountryListSpinner = null;
            this.f9354b.setOnClickListener(null);
            this.f9354b = null;
            this.f9355c.setOnClickListener(null);
            this.f9355c = null;
            this.f9356d.setOnClickListener(null);
            this.f9356d = null;
            this.f9357e.setOnClickListener(null);
            this.f9357e = null;
            this.f9358f.setOnClickListener(null);
            this.f9358f = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
