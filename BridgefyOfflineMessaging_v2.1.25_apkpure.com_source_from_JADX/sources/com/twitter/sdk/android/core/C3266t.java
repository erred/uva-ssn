package com.twitter.sdk.android.core;

import android.content.Context;
import java.util.concurrent.ExecutorService;

/* renamed from: com.twitter.sdk.android.core.t */
/* compiled from: TwitterConfig */
public class C3266t {

    /* renamed from: a */
    final Context f8554a;

    /* renamed from: b */
    final C3135h f8555b;

    /* renamed from: c */
    final C3259p f8556c;

    /* renamed from: d */
    final ExecutorService f8557d;

    /* renamed from: e */
    final Boolean f8558e;

    /* renamed from: com.twitter.sdk.android.core.t$a */
    /* compiled from: TwitterConfig */
    public static class C3268a {

        /* renamed from: a */
        private final Context f8559a;

        /* renamed from: b */
        private C3135h f8560b;

        /* renamed from: c */
        private C3259p f8561c;

        /* renamed from: d */
        private ExecutorService f8562d;

        /* renamed from: e */
        private Boolean f8563e;

        public C3268a(Context context) {
            if (context != null) {
                this.f8559a = context.getApplicationContext();
                return;
            }
            throw new IllegalArgumentException("Context must not be null.");
        }

        /* renamed from: a */
        public C3268a mo27902a(C3259p pVar) {
            if (pVar != null) {
                this.f8561c = pVar;
                return this;
            }
            throw new IllegalArgumentException("TwitterAuthConfig must not be null.");
        }

        /* renamed from: a */
        public C3266t mo27903a() {
            C3266t tVar = new C3266t(this.f8559a, this.f8560b, this.f8561c, this.f8562d, this.f8563e);
            return tVar;
        }
    }

    private C3266t(Context context, C3135h hVar, C3259p pVar, ExecutorService executorService, Boolean bool) {
        this.f8554a = context;
        this.f8555b = hVar;
        this.f8556c = pVar;
        this.f8557d = executorService;
        this.f8558e = bool;
    }
}
