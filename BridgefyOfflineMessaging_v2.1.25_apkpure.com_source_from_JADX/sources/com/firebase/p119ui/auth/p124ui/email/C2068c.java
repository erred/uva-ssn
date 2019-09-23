package com.firebase.p119ui.auth.p124ui.email;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.C0446c.C0447a;
import androidx.fragment.p081a.C1061c;
import androidx.fragment.p081a.C1078i;
import com.firebase.ui.auth.R;

/* renamed from: com.firebase.ui.auth.ui.email.c */
/* compiled from: RecoveryEmailSentDialog */
public class C2068c extends C1061c {
    /* renamed from: a */
    public static void m8330a(String str, C1078i iVar) {
        C2068c cVar = new C2068c();
        Bundle bundle = new Bundle();
        bundle.putString("extra_email", str);
        cVar.setArguments(bundle);
        cVar.show(iVar, "RecoveryEmailSentDialog");
    }

    public Dialog onCreateDialog(Bundle bundle) {
        return new C0447a(getContext()).setTitle(R.string.fui_title_confirm_recover_password).setMessage((CharSequence) getString(R.string.fui_confirm_recovery_body, getArguments().getString("extra_email"))).setOnDismissListener(new OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                C2068c.this.m8328a(-1, new Intent());
            }
        }).setPositiveButton(17039370, (OnClickListener) null).show();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8328a(int i, Intent intent) {
        getActivity().setResult(i, intent);
        getActivity().finish();
    }
}
