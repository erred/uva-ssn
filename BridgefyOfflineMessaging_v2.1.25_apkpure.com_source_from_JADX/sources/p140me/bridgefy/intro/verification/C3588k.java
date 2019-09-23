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

/* renamed from: me.bridgefy.intro.verification.k */
/* compiled from: VerificationReminderDialogFragment */
public class C3588k extends DialogFragment {

    /* renamed from: a */
    public static String f9453a = "ReminderDialogFragment";

    /* renamed from: b */
    C3589a f9454b;

    /* renamed from: me.bridgefy.intro.verification.k$a */
    /* compiled from: VerificationReminderDialogFragment */
    public interface C3589a {
        /* renamed from: c */
        void mo29509c();

        /* renamed from: f */
        void mo29510f();

        /* renamed from: g */
        void mo29511g();
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f9454b = (C3589a) activity;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        return C3659b.m10907d((Context) getActivity()).setTitle((CharSequence) getString(R.string.verify_title)).setMessage((CharSequence) getString(R.string.verify_dialog_body)).setPositiveButton((int) R.string.verify, (OnClickListener) new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                C3588k.this.m10552c(dialogInterface, i);
            }
        }).setNegativeButton((int) R.string.verify_dialog_skip, (OnClickListener) new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                C3588k.this.m10551b(dialogInterface, i);
            }
        }).setNeutralButton((int) R.string.never_again, (OnClickListener) new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                C3588k.this.m10550a(dialogInterface, i);
            }
        }).create();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m10552c(DialogInterface dialogInterface, int i) {
        this.f9454b.mo29510f();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m10551b(DialogInterface dialogInterface, int i) {
        this.f9454b.mo29509c();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m10550a(DialogInterface dialogInterface, int i) {
        this.f9454b.mo29511g();
    }
}
