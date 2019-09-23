package com.twitter.sdk.android.core;

import android.annotation.SuppressLint;
import android.content.Context;
import com.twitter.sdk.android.core.internal.C3152a;
import com.twitter.sdk.android.core.internal.C3176g;
import com.twitter.sdk.android.core.internal.C3178i;
import com.twitter.sdk.android.core.internal.C3181j;
import java.io.File;
import java.util.concurrent.ExecutorService;

/* renamed from: com.twitter.sdk.android.core.m */
/* compiled from: Twitter */
public class C3256m {

    /* renamed from: a */
    static final C3135h f8527a = new C3129d();
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: b */
    static volatile C3256m f8528b;

    /* renamed from: c */
    private final Context f8529c;

    /* renamed from: d */
    private final C3181j f8530d = new C3181j(this.f8529c);

    /* renamed from: e */
    private final ExecutorService f8531e;

    /* renamed from: f */
    private final C3259p f8532f;

    /* renamed from: g */
    private final C3152a f8533g = new C3152a(this.f8529c);

    /* renamed from: h */
    private final C3135h f8534h;

    /* renamed from: i */
    private final boolean f8535i;

    private C3256m(C3266t tVar) {
        this.f8529c = tVar.f8554a;
        if (tVar.f8556c == null) {
            this.f8532f = new C3259p(C3176g.m9308b(this.f8529c, "com.twitter.sdk.android.CONSUMER_KEY", ""), C3176g.m9308b(this.f8529c, "com.twitter.sdk.android.CONSUMER_SECRET", ""));
        } else {
            this.f8532f = tVar.f8556c;
        }
        if (tVar.f8557d == null) {
            this.f8531e = C3178i.m9311a("twitter-worker");
        } else {
            this.f8531e = tVar.f8557d;
        }
        if (tVar.f8555b == null) {
            this.f8534h = f8527a;
        } else {
            this.f8534h = tVar.f8555b;
        }
        if (tVar.f8558e == null) {
            this.f8535i = false;
        } else {
            this.f8535i = tVar.f8558e.booleanValue();
        }
    }

    /* renamed from: a */
    public static void m9534a(C3266t tVar) {
        m9536b(tVar);
    }

    /* renamed from: b */
    static synchronized C3256m m9536b(C3266t tVar) {
        synchronized (C3256m.class) {
            if (f8528b == null) {
                f8528b = new C3256m(tVar);
                C3256m mVar = f8528b;
                return mVar;
            }
            C3256m mVar2 = f8528b;
            return mVar2;
        }
    }

    /* renamed from: a */
    static void m9533a() {
        if (f8528b == null) {
            throw new IllegalStateException("Must initialize Twitter before using getInstance()");
        }
    }

    /* renamed from: b */
    public static C3256m m9535b() {
        m9533a();
        return f8528b;
    }

    /* renamed from: a */
    public Context mo27853a(String str) {
        Context context = this.f8529c;
        StringBuilder sb = new StringBuilder();
        sb.append(".TwitterKit");
        sb.append(File.separator);
        sb.append(str);
        return new C3269u(context, str, sb.toString());
    }

    /* renamed from: c */
    public C3181j mo27854c() {
        return this.f8530d;
    }

    /* renamed from: d */
    public C3259p mo27855d() {
        return this.f8532f;
    }

    /* renamed from: e */
    public ExecutorService mo27856e() {
        return this.f8531e;
    }

    /* renamed from: f */
    public C3152a mo27857f() {
        return this.f8533g;
    }

    /* renamed from: g */
    public static C3135h m9537g() {
        if (f8528b == null) {
            return f8527a;
        }
        return f8528b.f8534h;
    }
}
