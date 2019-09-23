package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import androidx.core.content.C0891b;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.util.Calendar;

/* renamed from: androidx.appcompat.app.m */
/* compiled from: TwilightManager */
class C0481m {

    /* renamed from: a */
    private static C0481m f1091a;

    /* renamed from: b */
    private final Context f1092b;

    /* renamed from: c */
    private final LocationManager f1093c;

    /* renamed from: d */
    private final C0482a f1094d = new C0482a();

    /* renamed from: androidx.appcompat.app.m$a */
    /* compiled from: TwilightManager */
    private static class C0482a {

        /* renamed from: a */
        boolean f1095a;

        /* renamed from: b */
        long f1096b;

        /* renamed from: c */
        long f1097c;

        /* renamed from: d */
        long f1098d;

        /* renamed from: e */
        long f1099e;

        /* renamed from: f */
        long f1100f;

        C0482a() {
        }
    }

    /* renamed from: a */
    static C0481m m1491a(Context context) {
        if (f1091a == null) {
            Context applicationContext = context.getApplicationContext();
            f1091a = new C0481m(applicationContext, (LocationManager) applicationContext.getSystemService(Param.LOCATION));
        }
        return f1091a;
    }

    C0481m(Context context, LocationManager locationManager) {
        this.f1092b = context;
        this.f1093c = locationManager;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo1082a() {
        C0482a aVar = this.f1094d;
        if (m1494c()) {
            return aVar.f1095a;
        }
        Location b = m1493b();
        if (b != null) {
            m1492a(b);
            return aVar.f1095a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i = Calendar.getInstance().get(11);
        return i < 6 || i >= 22;
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: b */
    private Location m1493b() {
        Location location = null;
        Location a = C0891b.m3308a(this.f1092b, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? m1490a("network") : null;
        if (C0891b.m3308a(this.f1092b, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            location = m1490a("gps");
        }
        if (location == null || a == null) {
            if (location != null) {
                a = location;
            }
            return a;
        }
        if (location.getTime() > a.getTime()) {
            a = location;
        }
        return a;
    }

    /* renamed from: a */
    private Location m1490a(String str) {
        try {
            if (this.f1093c.isProviderEnabled(str)) {
                return this.f1093c.getLastKnownLocation(str);
            }
        } catch (Exception e) {
            Log.d("TwilightManager", "Failed to get last known location", e);
        }
        return null;
    }

    /* renamed from: c */
    private boolean m1494c() {
        return this.f1094d.f1100f > System.currentTimeMillis();
    }

    /* renamed from: a */
    private void m1492a(Location location) {
        long j;
        C0482a aVar = this.f1094d;
        long currentTimeMillis = System.currentTimeMillis();
        C0480l a = C0480l.m1488a();
        C0480l lVar = a;
        lVar.mo1081a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j2 = a.f1088a;
        lVar.mo1081a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = a.f1090c == 1;
        long j3 = a.f1089b;
        long j4 = j2;
        long j5 = a.f1088a;
        long j6 = j3;
        boolean z2 = z;
        a.mo1081a(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j7 = a.f1089b;
        if (j6 == -1 || j5 == -1) {
            j = 43200000 + currentTimeMillis;
        } else {
            long j8 = currentTimeMillis > j5 ? 0 + j7 : currentTimeMillis > j6 ? 0 + j5 : 0 + j6;
            j = j8 + 60000;
        }
        aVar.f1095a = z2;
        aVar.f1096b = j4;
        aVar.f1097c = j6;
        aVar.f1098d = j5;
        aVar.f1099e = j7;
        aVar.f1100f = j;
    }
}
