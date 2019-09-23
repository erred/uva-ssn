package p000a.p001a.p002a.p003a.p004a.p006b;

import android.content.Context;
import p000a.p001a.p002a.p003a.C0135c;

/* renamed from: a.a.a.a.a.b.d */
/* compiled from: AdvertisingInfoReflectionStrategy */
class C0012d implements C0017f {

    /* renamed from: a */
    private final Context f20a;

    public C0012d(Context context) {
        this.f20a = context.getApplicationContext();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo32a(Context context) {
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
    public C0009b mo31a() {
        if (mo32a(this.f20a)) {
            return new C0009b(m36b(), m37c());
        }
        return null;
    }

    /* renamed from: b */
    private String m36b() {
        try {
            return (String) Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("getId", new Class[0]).invoke(m38d(), new Object[0]);
        } catch (Exception unused) {
            C0135c.m449h().mo277d("Fabric", "Could not call getId on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
            return null;
        }
    }

    /* renamed from: c */
    private boolean m37c() {
        try {
            return ((Boolean) Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(m38d(), new Object[0])).booleanValue();
        } catch (Exception unused) {
            C0135c.m449h().mo277d("Fabric", "Could not call isLimitAdTrackingEnabled on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
            return false;
        }
    }

    /* renamed from: d */
    private Object m38d() {
        try {
            return Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", new Class[]{Context.class}).invoke(null, new Object[]{this.f20a});
        } catch (Exception unused) {
            C0135c.m449h().mo277d("Fabric", "Could not call getAdvertisingIdInfo on com.google.android.gms.ads.identifier.AdvertisingIdClient");
            return null;
        }
    }
}
