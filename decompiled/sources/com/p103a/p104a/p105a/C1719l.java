package com.p103a.p104a.p105a;

import java.util.Random;
import p000a.p001a.p002a.p003a.p004a.p007c.p008a.C0055a;

/* renamed from: com.a.a.a.l */
/* compiled from: RandomBackoff */
class C1719l implements C0055a {

    /* renamed from: a */
    final C0055a f5387a;

    /* renamed from: b */
    final Random f5388b;

    /* renamed from: c */
    final double f5389c;

    public C1719l(C0055a aVar, double d) {
        this(aVar, d, new Random());
    }

    public C1719l(C0055a aVar, double d, Random random) {
        if (d < 0.0d || d > 1.0d) {
            throw new IllegalArgumentException("jitterPercent must be between 0.0 and 1.0");
        } else if (aVar == null) {
            throw new NullPointerException("backoff must not be null");
        } else if (random != null) {
            this.f5387a = aVar;
            this.f5389c = d;
            this.f5388b = random;
        } else {
            throw new NullPointerException("random must not be null");
        }
    }

    /* renamed from: a */
    public long mo101a(int i) {
        return (long) (mo6976a() * ((double) this.f5387a.mo101a(i)));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public double mo6976a() {
        double d = 1.0d - this.f5389c;
        return d + (((this.f5389c + 1.0d) - d) * this.f5388b.nextDouble());
    }
}
