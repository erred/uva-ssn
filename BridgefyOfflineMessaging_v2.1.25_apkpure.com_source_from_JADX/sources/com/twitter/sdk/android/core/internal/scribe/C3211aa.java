package com.twitter.sdk.android.core.internal.scribe;

import android.annotation.SuppressLint;
import android.content.Context;
import com.twitter.sdk.android.core.C3132f;
import com.twitter.sdk.android.core.C3254k;
import com.twitter.sdk.android.core.C3255l;
import com.twitter.sdk.android.core.C3262s;
import com.twitter.sdk.android.core.internal.C3181j;

/* renamed from: com.twitter.sdk.android.core.internal.scribe.aa */
/* compiled from: TwitterCoreScribeClientHolder */
public class C3211aa {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a */
    private static C3210a f8416a;

    /* renamed from: a */
    public static C3210a m9412a() {
        return f8416a;
    }

    /* renamed from: a */
    public static void m9413a(Context context, C3255l<? extends C3254k<C3262s>> lVar, C3132f fVar, C3181j jVar, String str, String str2) {
        C3210a aVar = new C3210a(context, lVar, fVar, jVar, C3210a.m9400a(str, str2));
        f8416a = aVar;
    }
}
