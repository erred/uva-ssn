package com.twitter.sdk.android.tweetui;

import android.os.Handler;
import androidx.p052b.C0718e;
import com.twitter.sdk.android.core.C3128c;
import com.twitter.sdk.android.core.C3253j;
import com.twitter.sdk.android.core.C3255l;
import com.twitter.sdk.android.core.C3256m;
import com.twitter.sdk.android.core.C3261q;
import com.twitter.sdk.android.core.C3270v;
import com.twitter.sdk.android.core.C3272w;
import com.twitter.sdk.android.core.C3274y;
import com.twitter.sdk.android.core.p132a.C3119o;

/* renamed from: com.twitter.sdk.android.tweetui.j */
/* compiled from: TweetRepository */
class C3358j {

    /* renamed from: a */
    final C0718e<Long, C3119o> f8770a;

    /* renamed from: b */
    final C0718e<Long, Object> f8771b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C3270v f8772c;

    /* renamed from: d */
    private final Handler f8773d;

    /* renamed from: e */
    private final C3255l<C3274y> f8774e;

    C3358j(Handler handler, C3255l<C3274y> lVar) {
        this(handler, lVar, C3270v.m9566a());
    }

    C3358j(Handler handler, C3255l<C3274y> lVar, C3270v vVar) {
        this.f8772c = vVar;
        this.f8773d = handler;
        this.f8774e = lVar;
        this.f8770a = new C0718e<>(20);
        this.f8771b = new C0718e<>(20);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo28154a(long j, C3128c<C3119o> cVar) {
        final long j2 = j;
        final C3128c<C3119o> cVar2 = cVar;
        C33591 r0 = new C3319f<C3274y>(cVar, C3256m.m9537g()) {
            /* renamed from: a */
            public void mo11811a(C3253j<C3274y> jVar) {
                C3358j.this.f8772c.mo27912a((C3274y) jVar.f8523a).mo27860b().create(Long.valueOf(j2), Boolean.valueOf(false)).mo28207a(cVar2);
            }
        };
        mo28155a((C3128c<C3274y>) r0);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo28156b(long j, C3128c<C3119o> cVar) {
        final long j2 = j;
        final C3128c<C3119o> cVar2 = cVar;
        C33602 r0 = new C3319f<C3274y>(cVar, C3256m.m9537g()) {
            /* renamed from: a */
            public void mo11811a(C3253j<C3274y> jVar) {
                C3358j.this.f8772c.mo27912a((C3274y) jVar.f8523a).mo27860b().destroy(Long.valueOf(j2), Boolean.valueOf(false)).mo28207a(cVar2);
            }
        };
        mo28155a((C3128c<C3274y>) r0);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo28155a(C3128c<C3274y> cVar) {
        C3274y yVar = (C3274y) this.f8774e.mo27626b();
        if (yVar == null) {
            cVar.mo11812a((C3272w) new C3261q("User authorization required"));
        } else {
            cVar.mo11811a(new C3253j<>(yVar, null));
        }
    }
}
