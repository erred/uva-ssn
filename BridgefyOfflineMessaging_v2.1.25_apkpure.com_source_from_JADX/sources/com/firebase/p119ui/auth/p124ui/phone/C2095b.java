package com.firebase.p119ui.auth.p124ui.phone;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.C0446c.C0447a;
import androidx.fragment.p081a.C1061c;
import androidx.fragment.p081a.C1078i;
import com.firebase.ui.auth.R;

/* renamed from: com.firebase.ui.auth.ui.phone.b */
/* compiled from: CompletableProgressDialog */
public final class C2095b extends C1061c {

    /* renamed from: a */
    TextView f6435a;

    /* renamed from: b */
    private ProgressBar f6436b;

    /* renamed from: c */
    private CharSequence f6437c;

    /* renamed from: d */
    private ImageView f6438d;

    /* renamed from: a */
    public static C2095b m8402a(C1078i iVar) {
        C2095b bVar = new C2095b();
        bVar.mo11941a(iVar, "ComProgressDialog");
        return bVar;
    }

    /* renamed from: a */
    public void mo11941a(C1078i iVar, String str) {
        if (!iVar.mo4377f()) {
            show(iVar, str);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        View inflate = View.inflate(getContext(), R.layout.fui_phone_progress_dialog, null);
        this.f6436b = (ProgressBar) inflate.findViewById(R.id.progress_bar);
        this.f6435a = (TextView) inflate.findViewById(R.id.progress_msg);
        this.f6438d = (ImageView) inflate.findViewById(R.id.progress_success_imaage);
        if (this.f6437c != null) {
            mo11942a(this.f6437c);
        }
        return new C0447a(getContext()).setView(inflate).create();
    }

    /* renamed from: a */
    public void mo11943a(String str) {
        mo11942a((CharSequence) str);
        if (this.f6436b != null) {
            this.f6436b.setVisibility(8);
        }
        if (this.f6438d != null) {
            this.f6438d.setVisibility(0);
        }
    }

    /* renamed from: a */
    public void mo11942a(CharSequence charSequence) {
        if (this.f6436b == null || this.f6435a == null) {
            this.f6437c = charSequence;
        } else {
            this.f6435a.setText(charSequence);
        }
    }
}
