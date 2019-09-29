package com.twitter.sdk.android.tweetui;

import android.view.View;
import android.view.View.OnClickListener;
import com.twitter.sdk.android.core.C3128c;
import com.twitter.sdk.android.core.C3253j;
import com.twitter.sdk.android.core.C3258o;
import com.twitter.sdk.android.core.C3272w;
import com.twitter.sdk.android.core.p132a.C3119o;
import com.twitter.sdk.android.core.p132a.C3120p;

/* renamed from: com.twitter.sdk.android.tweetui.e */
/* compiled from: LikeTweetAction */
class C3317e extends C3313a implements OnClickListener {

    /* renamed from: b */
    final C3119o f8650b;

    /* renamed from: c */
    final C3358j f8651c;

    /* renamed from: d */
    final C3363m f8652d;

    /* renamed from: e */
    final C3361k f8653e;

    /* renamed from: com.twitter.sdk.android.tweetui.e$a */
    /* compiled from: LikeTweetAction */
    static class C3318a extends C3128c<C3119o> {

        /* renamed from: a */
        final ToggleImageButton f8654a;

        /* renamed from: b */
        final C3119o f8655b;

        /* renamed from: c */
        final C3128c<C3119o> f8656c;

        C3318a(ToggleImageButton toggleImageButton, C3119o oVar, C3128c<C3119o> cVar) {
            this.f8654a = toggleImageButton;
            this.f8655b = oVar;
            this.f8656c = cVar;
        }

        /* renamed from: a */
        public void mo11811a(C3253j<C3119o> jVar) {
            this.f8656c.mo11811a(jVar);
        }

        /* renamed from: a */
        public void mo11812a(C3272w wVar) {
            if (wVar instanceof C3258o) {
                int a = ((C3258o) wVar).mo27863a();
                if (a == 139) {
                    this.f8656c.mo11811a(new C3253j<>(new C3120p().mo27599a(this.f8655b).mo27600a(true).mo27598a(), null));
                } else if (a != 144) {
                    this.f8654a.setToggledOn(this.f8655b.f8192g);
                    this.f8656c.mo11812a(wVar);
                } else {
                    this.f8656c.mo11811a(new C3253j<>(new C3120p().mo27599a(this.f8655b).mo27600a(false).mo27598a(), null));
                }
            } else {
                this.f8654a.setToggledOn(this.f8655b.f8192g);
                this.f8656c.mo11812a(wVar);
            }
        }
    }

    C3317e(C3119o oVar, C3363m mVar, C3128c<C3119o> cVar) {
        this(oVar, mVar, cVar, new C3362l(mVar));
    }

    C3317e(C3119o oVar, C3363m mVar, C3128c<C3119o> cVar, C3361k kVar) {
        super(cVar);
        this.f8650b = oVar;
        this.f8652d = mVar;
        this.f8653e = kVar;
        this.f8651c = mVar.mo28164d();
    }

    public void onClick(View view) {
        if (view instanceof ToggleImageButton) {
            ToggleImageButton toggleImageButton = (ToggleImageButton) view;
            if (this.f8650b.f8192g) {
                mo28003c();
                this.f8651c.mo28156b(this.f8650b.f8194i, new C3318a(toggleImageButton, this.f8650b, mo27996a()));
                return;
            }
            mo28002b();
            this.f8651c.mo28154a(this.f8650b.f8194i, new C3318a(toggleImageButton, this.f8650b, mo27996a()));
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo28002b() {
        this.f8653e.mo28158b(this.f8650b);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo28003c() {
        this.f8653e.mo28159c(this.f8650b);
    }
}
