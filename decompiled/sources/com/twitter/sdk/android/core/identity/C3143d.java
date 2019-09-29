package com.twitter.sdk.android.core.identity;

import android.app.Activity;
import android.content.Intent;
import com.twitter.sdk.android.core.C3128c;
import com.twitter.sdk.android.core.C3259p;
import com.twitter.sdk.android.core.C3274y;

/* renamed from: com.twitter.sdk.android.core.identity.d */
/* compiled from: OAuthHandler */
class C3143d extends C3137a {
    public C3143d(C3259p pVar, C3128c<C3274y> cVar, int i) {
        super(pVar, cVar, i);
    }

    /* renamed from: a */
    public boolean mo27636a(Activity activity) {
        activity.startActivityForResult(mo27650b(activity), this.f8280a);
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public Intent mo27650b(Activity activity) {
        Intent intent = new Intent(activity, OAuthActivity.class);
        intent.putExtra("auth_config", mo27634a());
        return intent;
    }
}
