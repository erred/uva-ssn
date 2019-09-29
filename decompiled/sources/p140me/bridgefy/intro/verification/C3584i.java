package p140me.bridgefy.intro.verification;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import me.bridgefy.main.R;
import p140me.bridgefy.utils.C3659b;

/* renamed from: me.bridgefy.intro.verification.i */
/* compiled from: VerificationBypassDialogFragment */
public class C3584i extends DialogFragment {

    /* renamed from: a */
    public static String f9449a = "BypassDialogFragment";

    /* renamed from: b */
    C3585a f9450b;

    /* renamed from: me.bridgefy.intro.verification.i$a */
    /* compiled from: VerificationBypassDialogFragment */
    public interface C3585a {
        /* renamed from: a */
        void mo29444a();

        /* renamed from: b */
        void mo29447b();

        void onRequestVerification();
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f9450b = (C3585a) activity;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        return C3659b.m10907d((Context) getActivity()).setTitle((CharSequence) getString(R.string.verify_title)).setMessage((CharSequence) getString(R.string.verify_dialog_body)).setPositiveButton((int) R.string.verify, (OnClickListener) new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                C3584i.this.m10544c(dialogInterface, i);
            }
        }).setNegativeButton((int) R.string.verify_dialog_skip, (OnClickListener) new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                C3584i.this.m10543b(dialogInterface, i);
            }
        }).setNeutralButton((int) R.string.verify_dialog_trouble, (OnClickListener) new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                C3584i.this.m10542a(dialogInterface, i);
            }
        }).create();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m10544c(DialogInterface dialogInterface, int i) {
        this.f9450b.onRequestVerification();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m10543b(DialogInterface dialogInterface, int i) {
        this.f9450b.mo29444a();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m10542a(DialogInterface dialogInterface, int i) {
        this.f9450b.mo29447b();
    }
}
