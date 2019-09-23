package com.firebase.p119ui.auth.p120a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.firebase.p119ui.auth.C2034c;
import com.firebase.p119ui.auth.C2034c.C2036a;
import com.firebase.p119ui.auth.C2037d.C2039a;
import com.firebase.p119ui.auth.p120a.C2008d.C2009a;
import com.firebase.ui.auth.R;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.TwitterAuthProvider;
import com.twitter.sdk.android.core.C3128c;
import com.twitter.sdk.android.core.C3253j;
import com.twitter.sdk.android.core.C3256m;
import com.twitter.sdk.android.core.C3259p;
import com.twitter.sdk.android.core.C3262s;
import com.twitter.sdk.android.core.C3266t.C3268a;
import com.twitter.sdk.android.core.C3270v;
import com.twitter.sdk.android.core.C3272w;
import com.twitter.sdk.android.core.C3274y;
import com.twitter.sdk.android.core.identity.C3148h;
import com.twitter.sdk.android.core.p132a.C3123s;

/* renamed from: com.firebase.ui.auth.a.h */
/* compiled from: TwitterProvider */
public class C2014h extends C3128c<C3274y> implements C2008d {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C2009a f6207a;

    /* renamed from: b */
    private C3148h f6208b = new C3148h();

    public C2014h(Context context) {
        m8181b(context);
    }

    /* renamed from: a */
    public static AuthCredential m8180a(C2034c cVar) {
        if (!cVar.mo11837c().equalsIgnoreCase("twitter.com")) {
            return null;
        }
        return TwitterAuthProvider.getCredential(cVar.mo11840e(), cVar.mo11841f());
    }

    /* renamed from: b */
    private static void m8181b(Context context) {
        C3256m.m9534a(new C3268a(context).mo27902a(new C3259p(context.getString(R.string.twitter_consumer_key), context.getString(R.string.twitter_consumer_secret))).mo27903a());
    }

    /* renamed from: a */
    public String mo11802a(Context context) {
        return context.getString(R.string.fui_idp_name_twitter);
    }

    /* renamed from: a */
    public int mo11801a() {
        return R.layout.fui_idp_button_twitter;
    }

    /* renamed from: a */
    public void mo11805a(C2009a aVar) {
        this.f6207a = aVar;
    }

    /* renamed from: a */
    public void mo11803a(int i, int i2, Intent intent) {
        this.f6208b.mo27657a(i, i2, intent);
    }

    /* renamed from: a */
    public void mo11804a(Activity activity) {
        this.f6208b.mo27658a(activity, (C3128c<C3274y>) this);
    }

    /* renamed from: a */
    public void mo11811a(final C3253j<C3274y> jVar) {
        C3270v.m9566a().mo27919h().mo27858a().verifyCredentials(Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(true)).mo28207a(new C3128c<C3123s>() {
            /* renamed from: a */
            public void mo11811a(C3253j<C3123s> jVar) {
                C3123s sVar = (C3123s) jVar.f8523a;
                C2014h.this.f6207a.mo11809a(C2014h.this.m8179a((C3274y) jVar.f8523a, sVar.f8252a, sVar.f8253b, Uri.parse(sVar.f8254c)));
            }

            /* renamed from: a */
            public void mo11812a(C3272w wVar) {
                C2014h.this.f6207a.mo11808a();
            }
        });
    }

    /* renamed from: a */
    public void mo11812a(C3272w wVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("Failure logging in to Twitter. ");
        sb.append(wVar.getMessage());
        Log.e("TwitterProvider", sb.toString());
        this.f6207a.mo11808a();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public C2034c m8179a(C3274y yVar, String str, String str2, Uri uri) {
        return new C2036a(new C2039a("twitter.com", str).mo11866b(str2).mo11863a(uri).mo11865a()).mo11847a(((C3262s) yVar.mo27849a()).f8544b).mo11849b(((C3262s) yVar.mo27849a()).f8545c).mo11848a();
    }
}
