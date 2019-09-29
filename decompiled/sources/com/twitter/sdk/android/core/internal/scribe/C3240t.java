package com.twitter.sdk.android.core.internal.scribe;

import java.util.List;

/* renamed from: com.twitter.sdk.android.core.internal.scribe.t */
/* compiled from: ScribeEventFactory */
public class C3240t {
    /* renamed from: a */
    public static C3238s m9513a(C3215e eVar, String str, long j, String str2, String str3, List<C3243w> list) {
        String str4 = eVar.f8423a;
        if (((str4.hashCode() == 114757 && str4.equals("tfw")) ? (char) 0 : 65535) != 0) {
            C3248x xVar = new C3248x(eVar, j, str2, str3, list);
            return xVar;
        }
        C3250y yVar = new C3250y(eVar, str, j, str2, str3, list);
        return yVar;
    }
}
