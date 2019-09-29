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

/* renamed from: me.bridgefy.intro.verification.j */
/* compiled from: VerificationCollisionDialogFragment */
public class C3586j extends DialogFragment {

    /* renamed from: a */
    public static String f9451a = "VerifCollisionDialogFragment";

    /* renamed from: b */
    C3587a f9452b;

    /* renamed from: me.bridgefy.intro.verification.j$a */
    /* compiled from: VerificationCollisionDialogFragment */
    public interface C3587a {
        /* renamed from: c */
        void mo29448c();

        void onCancel();
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f9452b = (C3587a) activity;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        return C3659b.m10907d((Context) getActivity()).setTitle((CharSequence) getString(R.string.verify_collision_title)).setMessage((CharSequence) getString(R.string.verify_collision_description)).setPositiveButton((int) R.string.signout, (OnClickListener) new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                C3586j.this.m10548b(dialogInterface, i);
            }
        }).setNegativeButton((int) R.string.verify_collision_continue, (OnClickListener) new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                C3586j.this.m10547a(dialogInterface, i);
            }
        }).create();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m10548b(DialogInterface dialogInterface, int i) {
        this.f9452b.mo29448c();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m10547a(DialogInterface dialogInterface, int i) {
        this.f9452b.onCancel();
    }
}
