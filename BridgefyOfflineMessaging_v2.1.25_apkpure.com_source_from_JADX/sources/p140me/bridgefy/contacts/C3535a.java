package p140me.bridgefy.contacts;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import androidx.appcompat.app.C0446c.C0447a;
import me.bridgefy.main.R;
import p140me.bridgefy.utils.C3659b;

/* renamed from: me.bridgefy.contacts.a */
/* compiled from: ShareContentDialogFragment */
public class C3535a extends DialogFragment {

    /* renamed from: a */
    public static String f9210a = "shareContentConfirmationDialogFragment";

    /* renamed from: b */
    C3536a f9211b;

    /* renamed from: me.bridgefy.contacts.a$a */
    /* compiled from: ShareContentDialogFragment */
    public interface C3536a {
        /* renamed from: a */
        void mo29254a(Bundle bundle);

        /* renamed from: b */
        void mo29255b();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m10367a(DialogInterface dialogInterface, int i) {
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f9211b = (C3536a) activity;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        C0447a d = C3659b.m10907d((Context) getActivity());
        d.setTitle((int) R.string.share_content_title);
        d.setMessage((CharSequence) String.format(getString(R.string.share_content_dialog), new Object[]{getArguments().getString("otherUserName")})).setPositiveButton((int) R.string.yes, (OnClickListener) new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                C3535a.this.m10368b(dialogInterface, i);
            }
        }).setNegativeButton((int) R.string.cancel, (OnClickListener) $$Lambda$a$szxMNr8D7NvigeYnbIshkqxwgE.INSTANCE);
        return d.create();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m10368b(DialogInterface dialogInterface, int i) {
        this.f9211b.mo29254a(getArguments());
        this.f9211b.mo29255b();
    }
}
