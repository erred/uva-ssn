package com.twitter.sdk.android.core.internal;

import com.twitter.sdk.android.core.p132a.C3107e;
import com.twitter.sdk.android.core.p132a.C3110h;
import com.twitter.sdk.android.core.p132a.C3124t;

/* renamed from: com.twitter.sdk.android.core.internal.q */
/* compiled from: VineCardUtils */
public class C3207q {
    /* renamed from: a */
    public static boolean m9385a(C3107e eVar) {
        return ("player".equals(eVar.f8164b) || "vine".equals(eVar.f8164b)) && m9389e(eVar);
    }

    /* renamed from: e */
    private static boolean m9389e(C3107e eVar) {
        C3124t tVar = (C3124t) eVar.f8163a.mo27591a("site");
        if (tVar != null) {
            try {
                if (Long.parseLong(tVar.f8256a) == 586671909) {
                    return true;
                }
            } catch (NumberFormatException unused) {
                return false;
            }
        }
        return false;
    }

    /* renamed from: b */
    public static String m9386b(C3107e eVar) {
        return ((C3124t) eVar.f8163a.mo27591a("site")).f8256a;
    }

    /* renamed from: c */
    public static String m9387c(C3107e eVar) {
        return (String) eVar.f8163a.mo27591a("player_stream_url");
    }

    /* renamed from: d */
    public static C3110h m9388d(C3107e eVar) {
        return (C3110h) eVar.f8163a.mo27591a("player_image");
    }
}
