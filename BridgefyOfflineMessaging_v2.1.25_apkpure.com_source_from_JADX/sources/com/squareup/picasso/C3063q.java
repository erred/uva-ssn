package com.squareup.picasso;

/* renamed from: com.squareup.picasso.q */
/* compiled from: NetworkPolicy */
public enum C3063q {
    NO_CACHE(1),
    NO_STORE(2),
    OFFLINE(4);
    

    /* renamed from: d */
    final int f8011d;

    /* renamed from: a */
    public static boolean m9047a(int i) {
        return (i & NO_CACHE.f8011d) == 0;
    }

    /* renamed from: b */
    public static boolean m9048b(int i) {
        return (i & NO_STORE.f8011d) == 0;
    }

    /* renamed from: c */
    public static boolean m9049c(int i) {
        return (i & OFFLINE.f8011d) != 0;
    }

    private C3063q(int i) {
        this.f8011d = i;
    }
}
