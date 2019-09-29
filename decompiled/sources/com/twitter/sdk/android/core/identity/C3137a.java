package com.twitter.sdk.android.core.identity;

import android.app.Activity;
import android.content.Intent;
import com.twitter.sdk.android.core.C3128c;
import com.twitter.sdk.android.core.C3253j;
import com.twitter.sdk.android.core.C3259p;
import com.twitter.sdk.android.core.C3261q;
import com.twitter.sdk.android.core.C3262s;
import com.twitter.sdk.android.core.C3272w;
import com.twitter.sdk.android.core.C3274y;

/* renamed from: com.twitter.sdk.android.core.identity.a */
/* compiled from: AuthHandler */
public abstract class C3137a {

    /* renamed from: a */
    protected final int f8280a;

    /* renamed from: b */
    private final C3259p f8281b;

    /* renamed from: c */
    private final C3128c<C3274y> f8282c;

    /* renamed from: a */
    public abstract boolean mo27636a(Activity activity);

    C3137a(C3259p pVar, C3128c<C3274y> cVar, int i) {
        this.f8281b = pVar;
        this.f8282c = cVar;
        this.f8280a = i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C3259p mo27634a() {
        return this.f8281b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C3128c<C3274y> mo27637b() {
        return this.f8282c;
    }

    /* renamed from: a */
    public boolean mo27635a(int i, int i2, Intent intent) {
        if (this.f8280a != i) {
            return false;
        }
        C3128c b = mo27637b();
        if (b != null) {
            if (i2 == -1) {
                String stringExtra = intent.getStringExtra("tk");
                String stringExtra2 = intent.getStringExtra("ts");
                String stringExtra3 = intent.getStringExtra("screen_name");
                b.mo11811a(new C3253j<>(new C3274y(new C3262s(stringExtra, stringExtra2), intent.getLongExtra("user_id", 0), stringExtra3), null));
            } else if (intent == null || !intent.hasExtra("auth_error")) {
                b.mo11812a((C3272w) new C3261q("Authorize failed."));
            } else {
                b.mo11812a((C3272w) (C3261q) intent.getSerializableExtra("auth_error"));
            }
        }
        return true;
    }
}
