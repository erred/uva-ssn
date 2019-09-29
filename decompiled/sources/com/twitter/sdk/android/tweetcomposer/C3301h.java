package com.twitter.sdk.android.tweetcomposer;

import android.annotation.SuppressLint;
import android.content.Context;
import com.twitter.sdk.android.core.C3132f;
import com.twitter.sdk.android.core.C3255l;
import com.twitter.sdk.android.core.C3256m;
import com.twitter.sdk.android.core.C3270v;
import com.twitter.sdk.android.core.C3274y;
import com.twitter.sdk.android.core.internal.scribe.C3210a;

/* renamed from: com.twitter.sdk.android.tweetcomposer.h */
/* compiled from: TweetComposer */
public class C3301h {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a */
    static volatile C3301h f8614a;

    /* renamed from: b */
    C3255l<C3274y> f8615b = C3270v.m9566a().mo27917f();

    /* renamed from: c */
    C3132f f8616c = C3270v.m9566a().mo27918g();

    /* renamed from: d */
    Context f8617d = C3256m.m9535b().mo27853a(mo27965c());

    /* renamed from: e */
    C3298e f8618e = new C3299f(null);

    /* renamed from: b */
    public String mo27964b() {
        return "3.1.0.8";
    }

    /* renamed from: c */
    public String mo27965c() {
        return "com.twitter.sdk.android:tweet-composer";
    }

    /* renamed from: a */
    public static C3301h m9631a() {
        if (f8614a == null) {
            synchronized (C3301h.class) {
                if (f8614a == null) {
                    f8614a = new C3301h();
                }
            }
        }
        return f8614a;
    }

    C3301h() {
        m9632e();
    }

    /* renamed from: e */
    private void m9632e() {
        C3210a aVar = new C3210a(this.f8617d, this.f8615b, this.f8616c, C3256m.m9535b().mo27854c(), C3210a.m9400a("TweetComposer", mo27964b()));
        this.f8618e = new C3299f(aVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public C3298e mo27966d() {
        return this.f8618e;
    }
}
