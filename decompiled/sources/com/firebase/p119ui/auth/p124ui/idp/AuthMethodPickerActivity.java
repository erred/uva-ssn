package com.firebase.p119ui.auth.p124ui.idp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.constraintlayout.widget.C0809e;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.firebase.p119ui.auth.C2034c;
import com.firebase.p119ui.auth.p120a.C2007c;
import com.firebase.p119ui.auth.p120a.C2008d.C2009a;
import com.firebase.p119ui.auth.p120a.C2011f;
import com.firebase.p119ui.auth.p120a.C2012g;
import com.firebase.p119ui.auth.p121b.p123b.C2024b;
import com.firebase.p119ui.auth.p124ui.C2040a;
import com.firebase.p119ui.auth.p124ui.C2048b;
import com.firebase.p119ui.auth.p124ui.C2051d;
import com.firebase.p119ui.auth.p124ui.C2077g;
import com.firebase.ui.auth.R;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import java.util.List;

/* renamed from: com.firebase.ui.auth.ui.idp.AuthMethodPickerActivity */
public class AuthMethodPickerActivity extends C2040a implements C2009a {

    /* renamed from: a */
    private List<C2011f> f6386a;

    /* renamed from: b */
    private C2024b f6387b;

    /* renamed from: a */
    public static Intent m8346a(Context context, C2048b bVar) {
        return C2051d.m8287a(context, AuthMethodPickerActivity.class, bVar);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.fui_auth_method_picker_layout);
        this.f6387b = mo11887c().mo11814a(this);
        m8347a(mo11886b().f6317b);
        int i = mo11886b().f6319d;
        if (i == -1) {
            findViewById(R.id.logo).setVisibility(8);
            ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.root);
            C0809e eVar = new C0809e();
            eVar.mo3293a(constraintLayout);
            eVar.mo3290a(R.id.container, 0.5f);
            eVar.mo3295b(R.id.container, 0.5f);
            eVar.mo3297b(constraintLayout);
            return;
        }
        ((ImageView) findViewById(R.id.logo)).setImageResource(i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0049, code lost:
        if (r2.equals("google.com") != false) goto L_0x0057;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m8347a(java.util.List<com.firebase.p119ui.auth.C2001a.C2003a> r6) {
        /*
            r5 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r5.f6386a = r0
            java.util.Iterator r6 = r6.iterator()
        L_0x000b:
            boolean r0 = r6.hasNext()
            r1 = 0
            if (r0 == 0) goto L_0x00be
            java.lang.Object r0 = r6.next()
            com.firebase.ui.auth.a$a r0 = (com.firebase.p119ui.auth.C2001a.C2003a) r0
            java.lang.String r2 = r0.mo11789a()
            r3 = -1
            int r4 = r2.hashCode()
            switch(r4) {
                case -1830313082: goto L_0x004c;
                case -1536293812: goto L_0x0043;
                case -364826023: goto L_0x0039;
                case 106642798: goto L_0x002f;
                case 1216985755: goto L_0x0025;
                default: goto L_0x0024;
            }
        L_0x0024:
            goto L_0x0056
        L_0x0025:
            java.lang.String r1 = "password"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0056
            r1 = 3
            goto L_0x0057
        L_0x002f:
            java.lang.String r1 = "phone"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0056
            r1 = 4
            goto L_0x0057
        L_0x0039:
            java.lang.String r1 = "facebook.com"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0056
            r1 = 1
            goto L_0x0057
        L_0x0043:
            java.lang.String r4 = "google.com"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0056
            goto L_0x0057
        L_0x004c:
            java.lang.String r1 = "twitter.com"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0056
            r1 = 2
            goto L_0x0057
        L_0x0056:
            r1 = -1
        L_0x0057:
            switch(r1) {
                case 0: goto L_0x00b2;
                case 1: goto L_0x00a0;
                case 2: goto L_0x0094;
                case 3: goto L_0x0084;
                case 4: goto L_0x0075;
                default: goto L_0x005a;
            }
        L_0x005a:
            java.lang.String r1 = "AuthMethodPicker"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Encountered unknown provider parcel with type: "
            r2.append(r3)
            java.lang.String r0 = r0.mo11789a()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            android.util.Log.e(r1, r0)
            goto L_0x000b
        L_0x0075:
            java.util.List<com.firebase.ui.auth.a.f> r0 = r5.f6386a
            com.firebase.ui.auth.a.e r1 = new com.firebase.ui.auth.a.e
            com.firebase.ui.auth.ui.b r2 = r5.mo11886b()
            r1.<init>(r5, r2)
            r0.add(r1)
            goto L_0x000b
        L_0x0084:
            java.util.List<com.firebase.ui.auth.a.f> r0 = r5.f6386a
            com.firebase.ui.auth.a.a r1 = new com.firebase.ui.auth.a.a
            com.firebase.ui.auth.ui.b r2 = r5.mo11886b()
            r1.<init>(r5, r2)
            r0.add(r1)
            goto L_0x000b
        L_0x0094:
            java.util.List<com.firebase.ui.auth.a.f> r0 = r5.f6386a
            com.firebase.ui.auth.a.h r1 = new com.firebase.ui.auth.a.h
            r1.<init>(r5)
            r0.add(r1)
            goto L_0x000b
        L_0x00a0:
            java.util.List<com.firebase.ui.auth.a.f> r1 = r5.f6386a
            com.firebase.ui.auth.a.b r2 = new com.firebase.ui.auth.a.b
            com.firebase.ui.auth.ui.b r3 = r5.mo11886b()
            int r3 = r3.f6318c
            r2.<init>(r0, r3)
            r1.add(r2)
            goto L_0x000b
        L_0x00b2:
            java.util.List<com.firebase.ui.auth.a.f> r1 = r5.f6386a
            com.firebase.ui.auth.a.c r2 = new com.firebase.ui.auth.a.c
            r2.<init>(r5, r0)
            r1.add(r2)
            goto L_0x000b
        L_0x00be:
            int r6 = com.firebase.ui.auth.R.id.btn_holder
            android.view.View r6 = r5.findViewById(r6)
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            java.util.List<com.firebase.ui.auth.a.f> r0 = r5.f6386a
            java.util.Iterator r0 = r0.iterator()
        L_0x00cc:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x00f9
            java.lang.Object r2 = r0.next()
            com.firebase.ui.auth.a.f r2 = (com.firebase.p119ui.auth.p120a.C2011f) r2
            android.view.LayoutInflater r3 = r5.getLayoutInflater()
            int r4 = r2.mo11801a()
            android.view.View r3 = r3.inflate(r4, r6, r1)
            com.firebase.ui.auth.ui.idp.AuthMethodPickerActivity$1 r4 = new com.firebase.ui.auth.ui.idp.AuthMethodPickerActivity$1
            r4.<init>(r2)
            r3.setOnClickListener(r4)
            boolean r4 = r2 instanceof com.firebase.p119ui.auth.p120a.C2008d
            if (r4 == 0) goto L_0x00f5
            com.firebase.ui.auth.a.d r2 = (com.firebase.p119ui.auth.p120a.C2008d) r2
            r2.mo11805a(r5)
        L_0x00f5:
            r6.addView(r3)
            goto L_0x00cc
        L_0x00f9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.firebase.p119ui.auth.p124ui.idp.AuthMethodPickerActivity.m8347a(java.util.List):void");
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 3) {
            mo11883a(i2, intent);
            return;
        }
        for (C2011f a : this.f6386a) {
            a.mo11803a(i, i2, intent);
        }
    }

    /* renamed from: a */
    public void mo11809a(C2034c cVar) {
        AuthCredential a = C2012g.m8175a(cVar);
        Task addOnCompleteListener = mo11887c().mo11815a().signInWithCredential(a).addOnCompleteListener(new C2079a(this, this.f6387b, 3, cVar));
        StringBuilder sb = new StringBuilder();
        sb.append("Firebase sign in with credential ");
        sb.append(a.getProvider());
        sb.append(" unsuccessful. Visit https://console.firebase.google.com to enable it.");
        addOnCompleteListener.addOnFailureListener(new C2077g("AuthMethodPicker", sb.toString()));
    }

    /* renamed from: a */
    public void mo11808a() {
        mo11888d().mo11907a();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (this.f6386a != null) {
            for (C2011f fVar : this.f6386a) {
                if (fVar instanceof C2007c) {
                    ((C2007c) fVar).mo11806b();
                }
            }
        }
    }
}
