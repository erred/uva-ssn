package p000a.p001a.p002a.p003a.p004a.p006b;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;
import p000a.p001a.p002a.p003a.C0135c;
import p000a.p001a.p002a.p003a.C0146i;

/* renamed from: a.a.a.a.a.b.o */
/* compiled from: IdManager */
public class C0032o {

    /* renamed from: d */
    private static final Pattern f57d = Pattern.compile("[^\\p{Alnum}]");

    /* renamed from: e */
    private static final String f58e = Pattern.quote("/");

    /* renamed from: a */
    C0010c f59a;

    /* renamed from: b */
    C0009b f60b;

    /* renamed from: c */
    boolean f61c;

    /* renamed from: f */
    private final ReentrantLock f62f = new ReentrantLock();

    /* renamed from: g */
    private final C0034p f63g;

    /* renamed from: h */
    private final boolean f64h;

    /* renamed from: i */
    private final boolean f65i;

    /* renamed from: j */
    private final Context f66j;

    /* renamed from: k */
    private final String f67k;

    /* renamed from: l */
    private final String f68l;

    /* renamed from: m */
    private final Collection<C0146i> f69m;

    /* renamed from: a.a.a.a.a.b.o$a */
    /* compiled from: IdManager */
    public enum C0033a {
        WIFI_MAC_ADDRESS(1),
        BLUETOOTH_MAC_ADDRESS(2),
        FONT_TOKEN(53),
        ANDROID_ID(100),
        ANDROID_DEVICE_ID(101),
        ANDROID_SERIAL(102),
        ANDROID_ADVERTISING_ID(103);
        

        /* renamed from: h */
        public final int f78h;

        private C0033a(int i) {
            this.f78h = i;
        }
    }

    public C0032o(Context context, String str, String str2, Collection<C0146i> collection) {
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        } else if (str == null) {
            throw new IllegalArgumentException("appIdentifier must not be null");
        } else if (collection != null) {
            this.f66j = context;
            this.f67k = str;
            this.f68l = str2;
            this.f69m = collection;
            this.f63g = new C0034p();
            this.f59a = new C0010c(context);
            this.f64h = C0020i.m73a(context, "com.crashlytics.CollectDeviceIdentifiers", true);
            if (!this.f64h) {
                StringBuilder sb = new StringBuilder();
                sb.append("Device ID collection disabled for ");
                sb.append(context.getPackageName());
                C0135c.m449h().mo270a("Fabric", sb.toString());
            }
            this.f65i = C0020i.m73a(context, "com.crashlytics.CollectUserIdentifiers", true);
            if (!this.f65i) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("User information collection disabled for ");
                sb2.append(context.getPackageName());
                C0135c.m449h().mo270a("Fabric", sb2.toString());
            }
        } else {
            throw new IllegalArgumentException("kits must not be null");
        }
    }

    /* renamed from: a */
    public boolean mo54a() {
        return this.f65i;
    }

    /* renamed from: a */
    private String m110a(String str) {
        if (str == null) {
            return null;
        }
        return f57d.matcher(str).replaceAll("").toLowerCase(Locale.US);
    }

    /* renamed from: b */
    public String mo55b() {
        String str = this.f68l;
        if (str != null) {
            return str;
        }
        SharedPreferences a = C0020i.m57a(this.f66j);
        String string = a.getString("crashlytics.installation.id", null);
        return string == null ? m109a(a) : string;
    }

    /* renamed from: c */
    public String mo56c() {
        return this.f67k;
    }

    /* renamed from: d */
    public String mo57d() {
        StringBuilder sb = new StringBuilder();
        sb.append(mo58e());
        sb.append("/");
        sb.append(mo59f());
        return sb.toString();
    }

    /* renamed from: e */
    public String mo58e() {
        return m112b(VERSION.RELEASE);
    }

    /* renamed from: f */
    public String mo59f() {
        return m112b(VERSION.INCREMENTAL);
    }

    /* renamed from: g */
    public String mo60g() {
        return String.format(Locale.US, "%s/%s", new Object[]{m112b(Build.MANUFACTURER), m112b(Build.MODEL)});
    }

    /* renamed from: b */
    private String m112b(String str) {
        return str.replaceAll(f58e, "");
    }

    /* renamed from: h */
    public String mo61h() {
        String str = "";
        if (!this.f64h) {
            return str;
        }
        String n = mo67n();
        if (n != null) {
            return n;
        }
        SharedPreferences a = C0020i.m57a(this.f66j);
        String string = a.getString("crashlytics.installation.id", null);
        return string == null ? m109a(a) : string;
    }

    /* renamed from: a */
    private String m109a(SharedPreferences sharedPreferences) {
        this.f62f.lock();
        try {
            String string = sharedPreferences.getString("crashlytics.installation.id", null);
            if (string == null) {
                string = m110a(UUID.randomUUID().toString());
                sharedPreferences.edit().putString("crashlytics.installation.id", string).commit();
            }
            return string;
        } finally {
            this.f62f.unlock();
        }
    }

    /* renamed from: i */
    public Map<C0033a, String> mo62i() {
        HashMap hashMap = new HashMap();
        for (C0146i iVar : this.f69m) {
            if (iVar instanceof C0027m) {
                for (Entry entry : ((C0027m) iVar).mo52f().entrySet()) {
                    m111a(hashMap, (C0033a) entry.getKey(), (String) entry.getValue());
                }
            }
        }
        m111a(hashMap, C0033a.ANDROID_ID, mo67n());
        m111a(hashMap, C0033a.ANDROID_ADVERTISING_ID, mo66m());
        return Collections.unmodifiableMap(hashMap);
    }

    /* renamed from: j */
    public String mo63j() {
        return this.f63g.mo68a(this.f66j);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: k */
    public synchronized C0009b mo64k() {
        if (!this.f61c) {
            this.f60b = this.f59a.mo26a();
            this.f61c = true;
        }
        return this.f60b;
    }

    /* renamed from: l */
    public Boolean mo65l() {
        if (this.f64h) {
            C0009b k = mo64k();
            if (k != null) {
                return Boolean.valueOf(k.f15b);
            }
        }
        return null;
    }

    /* renamed from: m */
    public String mo66m() {
        if (this.f64h) {
            C0009b k = mo64k();
            if (k != null) {
                return k.f14a;
            }
        }
        return null;
    }

    /* renamed from: a */
    private void m111a(Map<C0033a, String> map, C0033a aVar, String str) {
        if (str != null) {
            map.put(aVar, str);
        }
    }

    /* renamed from: n */
    public String mo67n() {
        if (this.f64h) {
            String string = Secure.getString(this.f66j.getContentResolver(), "android_id");
            if (!"9774d56d682e549c".equals(string)) {
                return m110a(string);
            }
        }
        return null;
    }
}
