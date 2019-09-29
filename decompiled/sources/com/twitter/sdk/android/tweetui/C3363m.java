package com.twitter.sdk.android.tweetui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.squareup.picasso.C3068t;
import com.twitter.sdk.android.core.C3132f;
import com.twitter.sdk.android.core.C3255l;
import com.twitter.sdk.android.core.C3256m;
import com.twitter.sdk.android.core.C3270v;
import com.twitter.sdk.android.core.C3274y;
import com.twitter.sdk.android.core.internal.scribe.C3210a;
import com.twitter.sdk.android.core.internal.scribe.C3215e;
import com.twitter.sdk.android.core.internal.scribe.C3243w;
import java.util.List;

/* renamed from: com.twitter.sdk.android.tweetui.m */
/* compiled from: TweetUi */
public class C3363m {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a */
    static volatile C3363m f8782a;

    /* renamed from: b */
    C3255l<C3274y> f8783b;

    /* renamed from: c */
    C3132f f8784c;

    /* renamed from: d */
    C3210a f8785d;

    /* renamed from: e */
    Context f8786e = C3256m.m9535b().mo27853a(mo28162b());

    /* renamed from: f */
    private C3358j f8787f;

    /* renamed from: g */
    private C3068t f8788g;

    /* renamed from: b */
    public String mo28162b() {
        return "com.twitter.sdk.android:tweet-ui";
    }

    /* renamed from: c */
    public String mo28163c() {
        return "3.1.0.8";
    }

    /* renamed from: a */
    public static C3363m m9824a() {
        if (f8782a == null) {
            synchronized (C3363m.class) {
                if (f8782a == null) {
                    f8782a = new C3363m();
                }
            }
        }
        return f8782a;
    }

    C3363m() {
        C3270v a = C3270v.m9566a();
        this.f8783b = a.mo27917f();
        this.f8784c = a.mo27918g();
        this.f8787f = new C3358j(new Handler(Looper.getMainLooper()), a.mo27917f());
        this.f8788g = C3068t.with(C3256m.m9535b().mo27853a(mo28162b()));
        m9825f();
    }

    /* renamed from: f */
    private void m9825f() {
        C3210a aVar = new C3210a(this.f8786e, this.f8783b, this.f8784c, C3256m.m9535b().mo27854c(), C3210a.m9400a("TweetUi", mo28163c()));
        this.f8785d = aVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo28161a(C3215e... eVarArr) {
        if (this.f8785d != null) {
            for (C3215e eVar : eVarArr) {
                this.f8785d.mo27770a(eVar);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo28160a(C3215e eVar, List<C3243w> list) {
        if (this.f8785d != null) {
            this.f8785d.mo27768a(eVar, list);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public C3358j mo28164d() {
        return this.f8787f;
    }

    /* renamed from: e */
    public C3068t mo28165e() {
        return this.f8788g;
    }
}
