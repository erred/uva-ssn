package com.squareup.picasso;

/* renamed from: com.squareup.picasso.p */
/* compiled from: MemoryPolicy */
public enum C3062p {
    NO_CACHE(1),
    NO_STORE(2);
    

    /* renamed from: c */
    final int f8006c;

    /* renamed from: a */
    static boolean m9045a(int i) {
        return (i & NO_CACHE.f8006c) == 0;
    }

    /* renamed from: b */
    static boolean m9046b(int i) {
        return (i & NO_STORE.f8006c) == 0;
    }

    private C3062p(int i) {
        this.f8006c = i;
    }
}
