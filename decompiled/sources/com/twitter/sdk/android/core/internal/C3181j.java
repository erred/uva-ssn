package com.twitter.sdk.android.core.internal;

import android.content.Context;
import com.twitter.sdk.android.core.C3256m;
import com.twitter.sdk.android.core.internal.p134b.C3164b;
import com.twitter.sdk.android.core.internal.p134b.C3165c;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;

/* renamed from: com.twitter.sdk.android.core.internal.j */
/* compiled from: IdManager */
public class C3181j {

    /* renamed from: d */
    private static final Pattern f8338d = Pattern.compile("[^\\p{Alnum}]");

    /* renamed from: e */
    private static final String f8339e = Pattern.quote("/");

    /* renamed from: a */
    C3168c f8340a;

    /* renamed from: b */
    C3162b f8341b;

    /* renamed from: c */
    boolean f8342c;

    /* renamed from: f */
    private final ReentrantLock f8343f;

    /* renamed from: g */
    private final boolean f8344g;

    /* renamed from: h */
    private final String f8345h;

    /* renamed from: i */
    private final C3164b f8346i;

    public C3181j(Context context) {
        this(context, new C3165c(context, "com.twitter.sdk.android.AdvertisingPreferences"));
    }

    C3181j(Context context, C3164b bVar) {
        this(context, bVar, new C3168c(context, bVar));
    }

    C3181j(Context context, C3164b bVar, C3168c cVar) {
        this.f8343f = new ReentrantLock();
        if (context != null) {
            this.f8345h = context.getPackageName();
            this.f8340a = cVar;
            this.f8346i = bVar;
            this.f8344g = C3176g.m9307a(context, "com.twitter.sdk.android.COLLECT_IDENTIFIERS_ENABLED", true);
            if (!this.f8344g) {
                StringBuilder sb = new StringBuilder();
                sb.append("Device ID collection disabled for ");
                sb.append(context.getPackageName());
                C3256m.m9537g().mo27607a("Twitter", sb.toString());
                return;
            }
            return;
        }
        throw new IllegalArgumentException("appContext must not be null");
    }

    /* renamed from: a */
    private String m9316a(String str) {
        if (str == null) {
            return null;
        }
        return f8338d.matcher(str).replaceAll("").toLowerCase(Locale.US);
    }

    /* renamed from: a */
    public String mo27701a() {
        String str = "";
        if (!this.f8344g) {
            return str;
        }
        String string = this.f8346i.mo27683a().getString("installation_uuid", null);
        return string == null ? m9317d() : string;
    }

    /* renamed from: d */
    private String m9317d() {
        this.f8343f.lock();
        try {
            String string = this.f8346i.mo27683a().getString("installation_uuid", null);
            if (string == null) {
                string = m9316a(UUID.randomUUID().toString());
                this.f8346i.mo27684a(this.f8346i.mo27685b().putString("installation_uuid", string));
            }
            return string;
        } finally {
            this.f8343f.unlock();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public synchronized C3162b mo27702b() {
        if (!this.f8342c) {
            this.f8341b = this.f8340a.mo27689a();
            this.f8342c = true;
        }
        return this.f8341b;
    }

    /* renamed from: c */
    public String mo27703c() {
        if (this.f8344g) {
            C3162b b = mo27702b();
            if (b != null) {
                return b.f8312a;
            }
        }
        return null;
    }
}
