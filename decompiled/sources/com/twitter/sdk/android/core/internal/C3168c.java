package com.twitter.sdk.android.core.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.twitter.sdk.android.core.C3256m;
import com.twitter.sdk.android.core.internal.p134b.C3164b;

/* renamed from: com.twitter.sdk.android.core.internal.c */
/* compiled from: AdvertisingInfoProvider */
class C3168c {

    /* renamed from: a */
    private final Context f8319a;

    /* renamed from: b */
    private final C3164b f8320b;

    C3168c(Context context, C3164b bVar) {
        this.f8319a = context.getApplicationContext();
        this.f8320b = bVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C3162b mo27689a() {
        C3162b b = m9281b();
        if (m9284c(b)) {
            C3256m.m9537g().mo27607a("Twitter", "Using AdvertisingInfo from Preference Store");
            m9279a(b);
            return b;
        }
        C3162b e = m9286e();
        m9282b(e);
        return e;
    }

    /* renamed from: a */
    private void m9279a(final C3162b bVar) {
        new Thread(new Runnable() {
            public void run() {
                C3162b a = C3168c.this.m9286e();
                if (!bVar.equals(a)) {
                    C3256m.m9537g().mo27607a("Twitter", "Asychronously getting Advertising Info and storing it to preferences");
                    C3168c.this.m9282b(a);
                }
            }
        }).start();
    }

    /* access modifiers changed from: private */
    @SuppressLint({"CommitPrefEdits"})
    /* renamed from: b */
    public void m9282b(C3162b bVar) {
        if (m9284c(bVar)) {
            this.f8320b.mo27684a(this.f8320b.mo27685b().putString("advertising_id", bVar.f8312a).putBoolean("limit_ad_tracking_enabled", bVar.f8313b));
        } else {
            this.f8320b.mo27684a(this.f8320b.mo27685b().remove("advertising_id").remove("limit_ad_tracking_enabled"));
        }
    }

    /* renamed from: b */
    private C3162b m9281b() {
        return new C3162b(this.f8320b.mo27683a().getString("advertising_id", ""), this.f8320b.mo27683a().getBoolean("limit_ad_tracking_enabled", false));
    }

    /* renamed from: c */
    private C3175f m9283c() {
        return new C3170d(this.f8319a);
    }

    /* renamed from: d */
    private C3175f m9285d() {
        return new C3171e(this.f8319a);
    }

    /* renamed from: c */
    private boolean m9284c(C3162b bVar) {
        return bVar != null && !TextUtils.isEmpty(bVar.f8312a);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public C3162b m9286e() {
        C3162b a = m9283c().mo27691a();
        if (!m9284c(a)) {
            a = m9285d().mo27691a();
            if (!m9284c(a)) {
                C3256m.m9537g().mo27607a("Twitter", "AdvertisingInfo not present");
            } else {
                C3256m.m9537g().mo27607a("Twitter", "Using AdvertisingInfo from Service Provider");
            }
        } else {
            C3256m.m9537g().mo27607a("Twitter", "Using AdvertisingInfo from Reflection Provider");
        }
        return a;
    }
}
