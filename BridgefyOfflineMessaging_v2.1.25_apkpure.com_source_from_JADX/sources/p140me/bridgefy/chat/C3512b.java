package p140me.bridgefy.chat;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import androidx.fragment.p081a.C1061c;
import me.bridgefy.main.R;

/* renamed from: me.bridgefy.chat.b */
/* compiled from: MessageRetryDialogFragment */
public class C3512b extends C1061c {

    /* renamed from: a */
    C3513a f9146a;

    /* renamed from: me.bridgefy.chat.b$a */
    /* compiled from: MessageRetryDialogFragment */
    public interface C3513a {
        /* renamed from: e */
        void mo29066e();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m10249a(DialogInterface dialogInterface, int i) {
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.f9146a = (C3513a) getActivity();
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Builder builder = new Builder(getActivity());
        builder.setMessage(R.string.message_retry).setPositiveButton(R.string.dialog_retry, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                C3512b.this.m10250b(dialogInterface, i);
            }
        }).setNegativeButton(R.string.cancel, $$Lambda$b$4riTZCftJTG_GYnp0vQeqAsuSuk.INSTANCE);
        return builder.create();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m10250b(DialogInterface dialogInterface, int i) {
        this.f9146a.mo29066e();
    }
}
