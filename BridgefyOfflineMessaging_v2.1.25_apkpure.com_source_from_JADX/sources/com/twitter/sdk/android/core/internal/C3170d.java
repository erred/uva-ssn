package com.twitter.sdk.android.core.internal;

import android.content.Context;
import com.twitter.sdk.android.core.C3256m;

/* renamed from: com.twitter.sdk.android.core.internal.d */
/* compiled from: AdvertisingInfoReflectionStrategy */
class C3170d implements C3175f {

    /* renamed from: a */
    private final Context f8323a;

    C3170d(Context context) {
        this.f8323a = context.getApplicationContext();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo27692a(Context context) {
        boolean z = false;
        try {
            if (((Integer) Class.forName("com.google.android.gms.common.GooglePlayServicesUtil").getMethod("isGooglePlayServicesAvailable", new Class[]{Context.class}).invoke(null, new Object[]{context})).intValue() == 0) {
                z = true;
            }
            return z;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a */
    public C3162b mo27691a() {
        if (mo27692a(this.f8323a)) {
            return new C3162b(m9288b(), m9289c());
        }
        return null;
    }

    /* renamed from: b */
    private String m9288b() {
        try {
            return (String) Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("getId", new Class[0]).invoke(m9290d(), new Object[0]);
        } catch (Exception unused) {
            C3256m.m9537g().mo27610b("Twitter", "Could not call getId on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
            return null;
        }
    }

    /* renamed from: c */
    private boolean m9289c() {
        try {
            return ((Boolean) Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(m9290d(), new Object[0])).booleanValue();
        } catch (Exception unused) {
            C3256m.m9537g().mo27610b("Twitter", "Could not call isLimitAdTrackingEnabled on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
            return false;
        }
    }

    /* renamed from: d */
    private Object m9290d() {
        try {
            return Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", new Class[]{Context.class}).invoke(null, new Object[]{this.f8323a});
        } catch (Exception unused) {
            C3256m.m9537g().mo27610b("Twitter", "Could not call getAdvertisingIdInfo on com.google.android.gms.ads.identifier.AdvertisingIdClient");
            return null;
        }
    }
}
