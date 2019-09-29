package p140me.bridgefy.utils;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.C0446c;
import androidx.appcompat.app.C0446c.C0447a;
import me.bridgefy.main.R;

/* renamed from: me.bridgefy.utils.a */
/* compiled from: AntennaeDisabledDialogFragment */
public class C3657a extends DialogFragment {

    /* renamed from: a */
    public static String f9675a = "AntennaeDisabledDialog";

    /* renamed from: b */
    private SharedPreferences f9676b;

    /* renamed from: c */
    private C3658a f9677c;

    /* renamed from: me.bridgefy.utils.a$a */
    /* compiled from: AntennaeDisabledDialogFragment */
    public interface C3658a {
        void onAntennaeDelegate(boolean z);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f9676b = getActivity().getSharedPreferences("BgfyPrefs", 0);
        if (this.f9677c == null) {
            this.f9677c = (C3658a) activity;
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        C0447a d = C3659b.m10907d((Context) getActivity());
        StringBuilder sb = new StringBuilder();
        sb.append(getString(R.string.bluetooth_disabled_dialog));
        sb.append("\n");
        sb.append(getString(R.string.bluetooth_enable_prompt));
        C0446c create = d.setCancelable(true).setMessage((CharSequence) sb.toString()).setPositiveButton((int) R.string.enable_bluetooth, (OnClickListener) new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                C3657a.this.m10881c(dialogInterface, i);
            }
        }).setNeutralButton((int) R.string.no_thanks, (OnClickListener) new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                C3657a.this.m10880b(dialogInterface, i);
            }
        }).setNegativeButton((int) R.string.never_again, (OnClickListener) new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                C3657a.this.m10879a(dialogInterface, i);
            }
        }).create();
        create.setCanceledOnTouchOutside(true);
        return create;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m10881c(DialogInterface dialogInterface, int i) {
        this.f9677c.onAntennaeDelegate(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m10880b(DialogInterface dialogInterface, int i) {
        this.f9677c.onAntennaeDelegate(false);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m10879a(DialogInterface dialogInterface, int i) {
        this.f9677c.onAntennaeDelegate(false);
        this.f9676b.edit().putBoolean("showSignalMessage", false).apply();
    }
}
