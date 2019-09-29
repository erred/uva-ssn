package p140me.bridgefy.chat;

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

/* renamed from: me.bridgefy.chat.a */
/* compiled from: DeleteConversationDialogFragment */
public class C3510a extends DialogFragment {

    /* renamed from: a */
    public static String f9144a = "DeleteConversationDF";

    /* renamed from: b */
    private C3511a f9145b;

    /* renamed from: me.bridgefy.chat.a$a */
    /* compiled from: DeleteConversationDialogFragment */
    public interface C3511a {
        /* renamed from: a */
        void mo29057a(int i);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f9145b = (C3511a) activity;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        C0447a d = C3659b.m10907d((Context) getActivity());
        d.setTitle((int) R.string.action_chat_delete);
        d.setMessage((int) R.string.delete_chat_dialog).setPositiveButton((int) R.string.yes, (OnClickListener) new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                C3510a.this.m10247b(dialogInterface, i);
            }
        }).setNegativeButton((int) R.string.no, (OnClickListener) new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                C3510a.this.m10246a(dialogInterface, i);
            }
        });
        return d.create();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m10247b(DialogInterface dialogInterface, int i) {
        this.f9145b.mo29057a(getArguments() != null ? getArguments().getInt("position") : 0);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m10246a(DialogInterface dialogInterface, int i) {
        dismiss();
    }
}
