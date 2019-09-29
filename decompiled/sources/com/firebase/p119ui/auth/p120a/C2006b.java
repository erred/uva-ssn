package com.firebase.p119ui.auth.p120a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.facebook.CallbackManager;
import com.facebook.CallbackManager.Factory;
import com.facebook.FacebookCallback;
import com.facebook.WebDialog;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.firebase.p119ui.auth.C2001a.C2003a;
import com.firebase.p119ui.auth.C2034c;
import com.firebase.p119ui.auth.p120a.C2008d.C2009a;
import com.firebase.ui.auth.R;
import com.google.android.gms.common.Scopes;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FacebookAuthProvider;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.firebase.ui.auth.a.b */
/* compiled from: FacebookProvider */
public class C2006b implements FacebookCallback<LoginResult>, C2008d {

    /* renamed from: a */
    private static CallbackManager f6197a;

    /* renamed from: b */
    private final List<String> f6198b;

    /* renamed from: c */
    private C2009a f6199c;

    public C2006b(C2003a aVar, int i) {
        List<String> b = aVar.mo11790b();
        if (b == null) {
            this.f6198b = new ArrayList();
        } else {
            this.f6198b = b;
        }
        WebDialog.setWebDialogTheme(i);
    }

    /* renamed from: a */
    public static AuthCredential m8146a(C2034c cVar) {
        if (!cVar.mo11837c().equals("facebook.com")) {
            return null;
        }
        return FacebookAuthProvider.getCredential(cVar.mo11840e());
    }

    /* renamed from: a */
    public String mo11802a(Context context) {
        return context.getString(R.string.fui_idp_name_facebook);
    }

    /* renamed from: a */
    public int mo11801a() {
        return R.layout.fui_idp_button_facebook;
    }

    /* renamed from: a */
    public void mo11804a(Activity activity) {
        f6197a = Factory.create();
        LoginManager instance = LoginManager.getInstance();
        instance.registerCallback(f6197a, this);
        ArrayList arrayList = new ArrayList(this.f6198b);
        if (!arrayList.contains(Scopes.EMAIL)) {
            arrayList.add(Scopes.EMAIL);
        }
        if (!arrayList.contains("public_profile")) {
            arrayList.add("public_profile");
        }
        instance.logInWithReadPermissions(activity, arrayList);
    }

    /* renamed from: a */
    public void mo11805a(C2009a aVar) {
        this.f6199c = aVar;
    }

    /* renamed from: a */
    public void mo11803a(int i, int i2, Intent intent) {
        if (f6197a != null) {
            f6197a.onActivityResult(i, i2, intent);
        }
    }
}
