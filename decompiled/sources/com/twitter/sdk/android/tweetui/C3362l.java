package com.twitter.sdk.android.tweetui;

import com.bridgefy.sdk.framework.entities.BleHandshake;
import com.google.firebase.analytics.FirebaseAnalytics.Event;
import com.twitter.sdk.android.core.internal.scribe.C3215e;
import com.twitter.sdk.android.core.internal.scribe.C3215e.C3216a;
import com.twitter.sdk.android.core.internal.scribe.C3243w;
import com.twitter.sdk.android.core.p132a.C3119o;
import java.util.ArrayList;

/* renamed from: com.twitter.sdk.android.tweetui.l */
/* compiled from: TweetScribeClientImpl */
class C3362l implements C3361k {

    /* renamed from: a */
    final C3363m f8781a;

    C3362l(C3363m mVar) {
        this.f8781a = mVar;
    }

    /* renamed from: a */
    public void mo28157a(C3119o oVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(C3243w.m9519a(oVar));
        this.f8781a.mo28160a(m9820c(), arrayList);
    }

    /* renamed from: b */
    public void mo28158b(C3119o oVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(C3243w.m9519a(oVar));
        this.f8781a.mo28160a(m9819b(), arrayList);
    }

    /* renamed from: c */
    public void mo28159c(C3119o oVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(C3243w.m9519a(oVar));
        this.f8781a.mo28160a(m9818a(), arrayList);
    }

    /* renamed from: a */
    static C3215e m9818a() {
        return new C3216a().mo27783a("tfw").mo27785b(BleHandshake.DEVICE_TYPE).mo27786c("tweet").mo27788e("actions").mo27789f("unfavorite").mo27784a();
    }

    /* renamed from: b */
    static C3215e m9819b() {
        return new C3216a().mo27783a("tfw").mo27785b(BleHandshake.DEVICE_TYPE).mo27786c("tweet").mo27788e("actions").mo27789f("favorite").mo27784a();
    }

    /* renamed from: c */
    static C3215e m9820c() {
        return new C3216a().mo27783a("tfw").mo27785b(BleHandshake.DEVICE_TYPE).mo27786c("tweet").mo27788e("actions").mo27789f(Event.SHARE).mo27784a();
    }
}
