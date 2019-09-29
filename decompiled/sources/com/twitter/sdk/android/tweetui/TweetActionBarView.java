package com.twitter.sdk.android.tweetui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.twitter.sdk.android.core.C3128c;
import com.twitter.sdk.android.core.p132a.C3119o;

public class TweetActionBarView extends LinearLayout {

    /* renamed from: a */
    final C3312a f8641a;

    /* renamed from: b */
    ToggleImageButton f8642b;

    /* renamed from: c */
    ImageButton f8643c;

    /* renamed from: d */
    C3128c<C3119o> f8644d;

    /* renamed from: com.twitter.sdk.android.tweetui.TweetActionBarView$a */
    static class C3312a {
        C3312a() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C3363m mo27995a() {
            return C3363m.m9824a();
        }
    }

    public TweetActionBarView(Context context) {
        this(context, null, new C3312a());
    }

    public TweetActionBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, new C3312a());
    }

    TweetActionBarView(Context context, AttributeSet attributeSet, C3312a aVar) {
        super(context, attributeSet);
        this.f8641a = aVar;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        mo27989a();
    }

    /* access modifiers changed from: 0000 */
    public void setOnActionCallback(C3128c<C3119o> cVar) {
        this.f8644d = cVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo27989a() {
        this.f8642b = (ToggleImageButton) findViewById(R.id.tw__tweet_like_button);
        this.f8643c = (ImageButton) findViewById(R.id.tw__tweet_share_button);
    }

    /* access modifiers changed from: 0000 */
    public void setTweet(C3119o oVar) {
        setLike(oVar);
        setShare(oVar);
    }

    /* access modifiers changed from: 0000 */
    public void setLike(C3119o oVar) {
        C3363m a = this.f8641a.mo27995a();
        if (oVar != null) {
            this.f8642b.setToggledOn(oVar.f8192g);
            this.f8642b.setOnClickListener(new C3317e(oVar, a, this.f8644d));
        }
    }

    /* access modifiers changed from: 0000 */
    public void setShare(C3119o oVar) {
        C3363m a = this.f8641a.mo27995a();
        if (oVar != null) {
            this.f8643c.setOnClickListener(new C3326h(oVar, a));
        }
    }
}
