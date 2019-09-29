package com.twitter.sdk.android.core.p132a;

import java.util.Collections;
import java.util.List;

/* renamed from: com.twitter.sdk.android.core.a.k */
/* compiled from: ModelUtils */
public final class C3113k {
    /* renamed from: a */
    public static <T> List<T> m9131a(List<T> list) {
        if (list == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(list);
    }
}
