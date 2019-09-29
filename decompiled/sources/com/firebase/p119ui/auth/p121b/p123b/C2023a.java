package com.firebase.p119ui.auth.p121b.p123b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.fragment.p081a.C1062d;
import androidx.fragment.p081a.C1071e;
import androidx.fragment.p081a.C1078i;
import com.firebase.p119ui.auth.C2001a.C2003a;
import com.firebase.p119ui.auth.C2034c;
import com.firebase.p119ui.auth.C2037d;
import com.firebase.p119ui.auth.p120a.C2006b;
import com.firebase.p119ui.auth.p120a.C2007c;
import com.firebase.p119ui.auth.p120a.C2008d;
import com.firebase.p119ui.auth.p120a.C2008d.C2009a;
import com.firebase.p119ui.auth.p120a.C2012g;
import com.firebase.p119ui.auth.p120a.C2014h;
import com.firebase.p119ui.auth.p124ui.C2048b;
import com.firebase.p119ui.auth.p124ui.C2050c;
import com.firebase.p119ui.auth.p124ui.C2051d;
import com.firebase.p119ui.auth.p124ui.C2077g;
import com.firebase.p119ui.auth.p124ui.idp.C2079a;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import java.util.Iterator;

/* renamed from: com.firebase.ui.auth.b.b.a */
/* compiled from: IdpSignInContainer */
public class C2023a extends C2050c implements C2009a {

    /* renamed from: a */
    private C2051d f6259a;

    /* renamed from: b */
    private C2008d f6260b;

    /* renamed from: c */
    private C2024b f6261c;

    /* renamed from: a */
    public static void m8203a(C1071e eVar, C2048b bVar, C2037d dVar) {
        C1078i supportFragmentManager = eVar.getSupportFragmentManager();
        if (!(supportFragmentManager.mo4369a("IDPSignInContainer") instanceof C2023a)) {
            C2023a aVar = new C2023a();
            Bundle a = bVar.mo11872a();
            a.putParcelable("extra_user", dVar);
            aVar.setArguments(a);
            try {
                supportFragmentManager.mo4370a().mo4069a((C1062d) aVar, "IDPSignInContainer").mo4065a().mo4084c();
            } catch (IllegalStateException e) {
                Log.e("IDPSignInContainer", "Cannot add fragment", e);
            }
        }
    }

    /* renamed from: a */
    public static C2023a m8202a(C1071e eVar) {
        C1062d a = eVar.getSupportFragmentManager().mo4369a("IDPSignInContainer");
        if (a instanceof C2023a) {
            return (C2023a) a;
        }
        return null;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (getActivity() instanceof C2051d) {
            this.f6259a = (C2051d) getActivity();
            return;
        }
        throw new RuntimeException("Can only attach IdpSignInContainer to HelperActivityBase.");
    }

    public void onCreate(Bundle bundle) {
        C2003a aVar;
        super.onCreate(bundle);
        this.f6261c = mo11881c().mo11814a(this.f6259a);
        C2037d a = C2037d.m8248a(getArguments());
        String a2 = a.mo11850a();
        Iterator it = mo11880b().f6317b.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = null;
                break;
            }
            aVar = (C2003a) it.next();
            if (aVar.mo11789a().equalsIgnoreCase(a2)) {
                break;
            }
        }
        if (aVar == null) {
            mo11832a(0, C2034c.m8234a(20));
            return;
        }
        if (a2.equalsIgnoreCase("google.com")) {
            this.f6260b = new C2007c(getActivity(), aVar, a.mo11851b());
        } else if (a2.equalsIgnoreCase("facebook.com")) {
            this.f6260b = new C2006b(aVar, mo11880b().f6318c);
        } else if (a2.equalsIgnoreCase("twitter.com")) {
            this.f6260b = new C2014h(getContext());
        }
        this.f6260b.mo11805a(this);
        if (bundle == null) {
            this.f6260b.mo11804a((Activity) getActivity());
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("has_existing_instance", true);
        super.onSaveInstanceState(bundle);
    }

    /* renamed from: a */
    public void mo11809a(C2034c cVar) {
        AuthCredential a = C2012g.m8175a(cVar);
        Task addOnCompleteListener = mo11881c().mo11815a().signInWithCredential(a).addOnCompleteListener(new C2079a(this.f6259a, this.f6261c, 4, cVar));
        StringBuilder sb = new StringBuilder();
        sb.append("Failure authenticating with credential ");
        sb.append(a.getProvider());
        addOnCompleteListener.addOnFailureListener(new C2077g("IDPSignInContainer", sb.toString()));
    }

    /* renamed from: a */
    public void mo11808a() {
        mo11832a(0, C2034c.m8234a(20));
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 4) {
            mo11832a(i2, intent);
        } else {
            this.f6260b.mo11803a(i, i2, intent);
        }
    }
}
