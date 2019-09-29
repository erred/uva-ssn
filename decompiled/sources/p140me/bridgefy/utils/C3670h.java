package p140me.bridgefy.utils;

import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import androidx.appcompat.app.C0446c;
import me.bridgefy.main.R;

/* renamed from: me.bridgefy.utils.h */
/* compiled from: HelpfulTipsDialogFragment */
public class C3670h extends DialogFragment {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    /* renamed from: a */
    public C0446c onCreateDialog(Bundle bundle) {
        return C3659b.m10907d((Context) getActivity()).setTitle((int) R.string.action_troubleshoot_title).setMessage((int) R.string.dialog_troubleshoot_content).setPositiveButton((int) R.string.dialog_gotit, (OnClickListener) $$Lambda$h$xPNs6Qzf_iSRMGUOMGwmTaeAKk.INSTANCE).create();
    }
}
