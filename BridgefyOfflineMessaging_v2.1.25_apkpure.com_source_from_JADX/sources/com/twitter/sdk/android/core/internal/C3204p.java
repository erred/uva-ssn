package com.twitter.sdk.android.core.internal;

import com.twitter.sdk.android.core.p132a.C3123s;

/* renamed from: com.twitter.sdk.android.core.internal.p */
/* compiled from: UserUtils */
public final class C3204p {

    /* renamed from: com.twitter.sdk.android.core.internal.p$a */
    /* compiled from: UserUtils */
    public enum C3206a {
        NORMAL("_normal"),
        BIGGER("_bigger"),
        MINI("_mini"),
        ORIGINAL("_original"),
        REASONABLY_SMALL("_reasonably_small");
        

        /* renamed from: f */
        private final String f8394f;

        private C3206a(String str) {
            this.f8394f = str;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public String mo27758a() {
            return this.f8394f;
        }
    }

    /* renamed from: a */
    public static String m9383a(C3123s sVar, C3206a aVar) {
        if (sVar == null || sVar.f8254c == null) {
            return null;
        }
        String str = sVar.f8254c;
        if (aVar == null || str == null) {
            return str;
        }
        switch (aVar) {
            case NORMAL:
            case BIGGER:
            case MINI:
            case ORIGINAL:
            case REASONABLY_SMALL:
                return str.replace(C3206a.NORMAL.mo27758a(), aVar.mo27758a());
            default:
                return str;
        }
    }
}
