package com.twitter.sdk.android.tweetui;

import com.twitter.sdk.android.core.C3128c;
import com.twitter.sdk.android.core.C3135h;
import com.twitter.sdk.android.core.C3272w;

/* renamed from: com.twitter.sdk.android.tweetui.f */
/* compiled from: LoggingCallback */
abstract class C3319f<T> extends C3128c<T> {

    /* renamed from: a */
    private final C3128c f8657a;

    /* renamed from: b */
    private final C3135h f8658b;

    C3319f(C3128c cVar, C3135h hVar) {
        this.f8657a = cVar;
        this.f8658b = hVar;
    }

    /* renamed from: a */
    public void mo11812a(C3272w wVar) {
        this.f8658b.mo27613c("TweetUi", wVar.getMessage(), wVar);
        if (this.f8657a != null) {
            this.f8657a.mo11812a(wVar);
        }
    }
}
