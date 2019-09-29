package com.twitter.sdk.android.core.identity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.bridgefy.sdk.framework.entities.BleHandshake;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.firebase.analytics.FirebaseAnalytics.Event;
import com.twitter.sdk.android.core.C3128c;
import com.twitter.sdk.android.core.C3253j;
import com.twitter.sdk.android.core.C3254k;
import com.twitter.sdk.android.core.C3255l;
import com.twitter.sdk.android.core.C3256m;
import com.twitter.sdk.android.core.C3259p;
import com.twitter.sdk.android.core.C3261q;
import com.twitter.sdk.android.core.C3270v;
import com.twitter.sdk.android.core.C3272w;
import com.twitter.sdk.android.core.C3274y;
import com.twitter.sdk.android.core.internal.scribe.C3210a;
import com.twitter.sdk.android.core.internal.scribe.C3211aa;
import com.twitter.sdk.android.core.internal.scribe.C3215e.C3216a;

/* renamed from: com.twitter.sdk.android.core.identity.h */
/* compiled from: TwitterAuthClient */
public class C3148h {

    /* renamed from: a */
    final C3270v f8294a;

    /* renamed from: b */
    final C3138b f8295b;

    /* renamed from: c */
    final C3255l<C3274y> f8296c;

    /* renamed from: d */
    final C3259p f8297d;

    /* renamed from: com.twitter.sdk.android.core.identity.h$a */
    /* compiled from: TwitterAuthClient */
    private static class C3149a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public static final C3138b f8298a = new C3138b();
    }

    /* renamed from: com.twitter.sdk.android.core.identity.h$b */
    /* compiled from: TwitterAuthClient */
    static class C3150b extends C3128c<C3274y> {

        /* renamed from: a */
        private final C3255l<C3274y> f8299a;

        /* renamed from: b */
        private final C3128c<C3274y> f8300b;

        C3150b(C3255l<C3274y> lVar, C3128c<C3274y> cVar) {
            this.f8299a = lVar;
            this.f8300b = cVar;
        }

        /* renamed from: a */
        public void mo11811a(C3253j<C3274y> jVar) {
            C3256m.m9537g().mo27607a("Twitter", "Authorization completed successfully");
            this.f8299a.mo27624a((C3254k) jVar.f8523a);
            this.f8300b.mo11811a(jVar);
        }

        /* renamed from: a */
        public void mo11812a(C3272w wVar) {
            C3256m.m9537g().mo27613c("Twitter", "Authorization completed with an error", wVar);
            this.f8300b.mo11812a(wVar);
        }
    }

    public C3148h() {
        this(C3270v.m9566a(), C3270v.m9566a().mo27914c(), C3270v.m9566a().mo27917f(), C3149a.f8298a);
    }

    C3148h(C3270v vVar, C3259p pVar, C3255l<C3274y> lVar, C3138b bVar) {
        this.f8294a = vVar;
        this.f8295b = bVar;
        this.f8297d = pVar;
        this.f8296c = lVar;
    }

    /* renamed from: a */
    public void mo27658a(Activity activity, C3128c<C3274y> cVar) {
        if (activity == null) {
            throw new IllegalArgumentException("Activity must not be null.");
        } else if (cVar == null) {
            throw new IllegalArgumentException("Callback must not be null.");
        } else if (activity.isFinishing()) {
            C3256m.m9537g().mo27613c("Twitter", "Cannot authorize, activity is finishing.", null);
        } else {
            m9225b(activity, cVar);
        }
    }

    /* renamed from: b */
    private void m9225b(Activity activity, C3128c<C3274y> cVar) {
        m9224b();
        C3150b bVar = new C3150b(this.f8296c, cVar);
        if (!m9223a(activity, bVar) && !m9226b(activity, bVar)) {
            bVar.mo11812a((C3272w) new C3261q("Authorize failed."));
        }
    }

    /* renamed from: a */
    private boolean m9223a(Activity activity, C3150b bVar) {
        if (!C3147g.m9219a((Context) activity)) {
            return false;
        }
        C3256m.m9537g().mo27607a("Twitter", "Using SSO");
        return this.f8295b.mo27639a(activity, new C3147g(this.f8297d, bVar, this.f8297d.mo27866c()));
    }

    /* renamed from: b */
    private boolean m9226b(Activity activity, C3150b bVar) {
        C3256m.m9537g().mo27607a("Twitter", "Using OAuth");
        return this.f8295b.mo27639a(activity, new C3143d(this.f8297d, bVar, this.f8297d.mo27866c()));
    }

    /* renamed from: b */
    private void m9224b() {
        C3210a a = mo27656a();
        if (a != null) {
            a.mo27770a(new C3216a().mo27783a(BleHandshake.DEVICE_TYPE).mo27785b(Event.LOGIN).mo27786c("").mo27787d("").mo27788e("").mo27789f("impression").mo27784a());
        }
    }

    /* renamed from: a */
    public void mo27657a(int i, int i2, Intent intent) {
        StringBuilder sb = new StringBuilder();
        sb.append("onActivityResult called with ");
        sb.append(i);
        sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        sb.append(i2);
        C3256m.m9537g().mo27607a("Twitter", sb.toString());
        if (!this.f8295b.mo27640b()) {
            C3256m.m9537g().mo27613c("Twitter", "Authorize not in progress", null);
            return;
        }
        C3137a c = this.f8295b.mo27641c();
        if (c != null && c.mo27635a(i, i2, intent)) {
            this.f8295b.mo27638a();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C3210a mo27656a() {
        return C3211aa.m9412a();
    }
}
