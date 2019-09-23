package com.twitter.sdk.android.core.p132a;

import java.util.Collections;
import java.util.Map;

/* renamed from: com.twitter.sdk.android.core.a.c */
/* compiled from: BindingValues */
public class C3105c {

    /* renamed from: a */
    private final Map<String, Object> f8162a;

    public C3105c() {
        this(Collections.EMPTY_MAP);
    }

    public C3105c(Map<String, Object> map) {
        this.f8162a = Collections.unmodifiableMap(map);
    }

    /* renamed from: a */
    public <T> T mo27591a(String str) {
        try {
            return this.f8162a.get(str);
        } catch (ClassCastException unused) {
            return null;
        }
    }
}
