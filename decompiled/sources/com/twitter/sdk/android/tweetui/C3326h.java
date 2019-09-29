package com.twitter.sdk.android.tweetui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.twitter.sdk.android.core.C3134g;
import com.twitter.sdk.android.core.C3256m;
import com.twitter.sdk.android.core.p132a.C3119o;

/* renamed from: com.twitter.sdk.android.tweetui.h */
/* compiled from: ShareTweetAction */
class C3326h implements OnClickListener {

    /* renamed from: a */
    final C3119o f8673a;

    /* renamed from: b */
    final C3363m f8674b;

    /* renamed from: c */
    final C3361k f8675c;

    C3326h(C3119o oVar, C3363m mVar) {
        this(oVar, mVar, new C3362l(mVar));
    }

    C3326h(C3119o oVar, C3363m mVar, C3361k kVar) {
        this.f8673a = oVar;
        this.f8674b = mVar;
        this.f8675c = kVar;
    }

    public void onClick(View view) {
        mo28023a(view.getContext(), view.getResources());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo28022a() {
        this.f8675c.mo28157a(this.f8673a);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo28023a(Context context, Resources resources) {
        if (this.f8673a != null && this.f8673a.f8181D != null) {
            mo28022a();
            mo28024a(Intent.createChooser(mo28020a(mo28025b(resources), mo28021a(resources)), resources.getString(R.string.tw__share_tweet)), context);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo28021a(Resources resources) {
        return resources.getString(R.string.tw__share_content_format, new Object[]{this.f8673a.f8181D.f8255d, Long.toString(this.f8673a.f8194i)});
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public String mo28025b(Resources resources) {
        return resources.getString(R.string.tw__share_subject_format, new Object[]{this.f8673a.f8181D.f8253b, this.f8673a.f8181D.f8255d});
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo28024a(Intent intent, Context context) {
        if (!C3134g.m9164b(context, intent)) {
            C3256m.m9537g().mo27612c("TweetUi", "Activity cannot be found to handle share intent");
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Intent mo28020a(String str, String str2) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.SUBJECT", str);
        intent.putExtra("android.intent.extra.TEXT", str2);
        intent.setType("text/plain");
        return intent;
    }
}
