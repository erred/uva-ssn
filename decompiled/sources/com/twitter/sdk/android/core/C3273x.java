package com.twitter.sdk.android.core;

import p091b.C1640s;

/* renamed from: com.twitter.sdk.android.core.x */
/* compiled from: TwitterRateLimit */
public class C3273x {

    /* renamed from: a */
    private int f8575a;

    /* renamed from: b */
    private int f8576b;

    /* renamed from: c */
    private long f8577c;

    C3273x(C1640s sVar) {
        if (sVar != null) {
            for (int i = 0; i < sVar.mo6643a(); i++) {
                if ("x-rate-limit-limit".equals(sVar.mo6644a(i))) {
                    this.f8575a = Integer.valueOf(sVar.mo6647b(i)).intValue();
                } else if ("x-rate-limit-remaining".equals(sVar.mo6644a(i))) {
                    this.f8576b = Integer.valueOf(sVar.mo6647b(i)).intValue();
                } else if ("x-rate-limit-reset".equals(sVar.mo6644a(i))) {
                    this.f8577c = Long.valueOf(sVar.mo6647b(i)).longValue();
                }
            }
            return;
        }
        throw new IllegalArgumentException("headers must not be null");
    }
}
