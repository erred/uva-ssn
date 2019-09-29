package com.twitter.sdk.android.core.internal.scribe;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.bridgefy.sdk.BuildConfig;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.twitter.sdk.android.core.C3132f;
import com.twitter.sdk.android.core.C3254k;
import com.twitter.sdk.android.core.C3255l;
import com.twitter.sdk.android.core.C3259p;
import com.twitter.sdk.android.core.C3262s;
import com.twitter.sdk.android.core.C3270v;
import com.twitter.sdk.android.core.internal.C3178i;
import com.twitter.sdk.android.core.internal.C3181j;
import com.twitter.sdk.android.core.internal.scribe.C3238s.C3239a;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

/* renamed from: com.twitter.sdk.android.core.internal.scribe.a */
/* compiled from: DefaultScribeClient */
public class C3210a extends C3236q {

    /* renamed from: b */
    private static volatile ScheduledExecutorService f8412b;

    /* renamed from: c */
    private final C3255l<? extends C3254k<C3262s>> f8413c;

    /* renamed from: d */
    private final String f8414d;

    /* renamed from: e */
    private final Context f8415e;

    public C3210a(Context context, C3255l<? extends C3254k<C3262s>> lVar, C3132f fVar, C3181j jVar, C3237r rVar) {
        this(context, C3270v.m9566a().mo27914c(), lVar, fVar, jVar, rVar);
    }

    C3210a(Context context, C3259p pVar, C3255l<? extends C3254k<C3262s>> lVar, C3132f fVar, C3181j jVar, C3237r rVar) {
        super(context, m9405d(), rVar, new C3239a(m9403c()), pVar, lVar, fVar, jVar);
        this.f8415e = context;
        this.f8413c = lVar;
        this.f8414d = jVar.mo27703c();
    }

    /* renamed from: a */
    public void mo27770a(C3215e... eVarArr) {
        for (C3215e a : eVarArr) {
            mo27768a(a, Collections.emptyList());
        }
    }

    /* renamed from: a */
    public void mo27768a(C3215e eVar, List<C3243w> list) {
        String str = "";
        C3215e eVar2 = eVar;
        mo27769a(C3240t.m9513a(eVar2, str, System.currentTimeMillis(), m9401b(), this.f8414d, list));
    }

    /* renamed from: a */
    public void mo27769a(C3238s sVar) {
        super.mo27830a(sVar, mo27766a(mo27767a()));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C3254k mo27767a() {
        return this.f8413c.mo27626b();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public long mo27766a(C3254k kVar) {
        if (kVar != null) {
            return kVar.mo27850b();
        }
        return 0;
    }

    /* renamed from: b */
    private String m9401b() {
        return this.f8415e.getResources().getConfiguration().locale.getLanguage();
    }

    /* renamed from: c */
    private static Gson m9403c() {
        return new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
    }

    /* renamed from: d */
    private static ScheduledExecutorService m9405d() {
        if (f8412b == null) {
            synchronized (C3210a.class) {
                if (f8412b == null) {
                    f8412b = C3178i.m9314b("scribe");
                }
            }
        }
        return f8412b;
    }

    /* renamed from: a */
    public static C3237r m9400a(String str, String str2) {
        C3237r rVar = new C3237r(m9406e(), m9404c("https://syndication.twitter.com", ""), "i", "sdk", "", m9402b(str, str2), 100, 600);
        return rVar;
    }

    /* renamed from: e */
    private static boolean m9406e() {
        return !BuildConfig.BUILD_TYPE.equals(com.j256.ormlite.BuildConfig.BUILD_TYPE);
    }

    /* renamed from: b */
    static String m9402b(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("TwitterKit/");
        sb.append("3.0");
        sb.append(" (Android ");
        sb.append(VERSION.SDK_INT);
        sb.append(") ");
        sb.append(str);
        sb.append("/");
        sb.append(str2);
        return sb.toString();
    }

    /* renamed from: c */
    static String m9404c(String str, String str2) {
        return !TextUtils.isEmpty(str2) ? str2 : str;
    }
}
