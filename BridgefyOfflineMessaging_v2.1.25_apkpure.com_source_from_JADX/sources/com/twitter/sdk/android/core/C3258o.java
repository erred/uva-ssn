package com.twitter.sdk.android.core;

import android.text.TextUtils;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.twitter.sdk.android.core.p132a.C3103a;
import com.twitter.sdk.android.core.p132a.C3104b;
import com.twitter.sdk.android.core.p132a.C3115m;
import com.twitter.sdk.android.core.p132a.C3117n;
import p136d.C3445l;

/* renamed from: com.twitter.sdk.android.core.o */
/* compiled from: TwitterApiException */
public class C3258o extends C3272w {

    /* renamed from: a */
    private final C3103a f8538a;

    /* renamed from: b */
    private final C3273x f8539b;

    /* renamed from: c */
    private final int f8540c;

    /* renamed from: d */
    private final C3445l f8541d;

    public C3258o(C3445l lVar) {
        this(lVar, m9554b(lVar), m9552a(lVar), lVar.mo28269a());
    }

    C3258o(C3445l lVar, C3103a aVar, C3273x xVar, int i) {
        super(m9553a(i));
        this.f8538a = aVar;
        this.f8539b = xVar;
        this.f8540c = i;
        this.f8541d = lVar;
    }

    /* renamed from: a */
    public int mo27863a() {
        if (this.f8538a == null) {
            return 0;
        }
        return this.f8538a.f8160a;
    }

    /* renamed from: a */
    public static C3273x m9552a(C3445l lVar) {
        return new C3273x(lVar.mo28270b());
    }

    /* renamed from: b */
    public static C3103a m9554b(C3445l lVar) {
        try {
            String q = lVar.mo28273e().mo6292c().mo6829c().clone().mo6866q();
            if (!TextUtils.isEmpty(q)) {
                return m9551a(q);
            }
        } catch (Exception e) {
            C3256m.m9537g().mo27613c("Twitter", "Unexpected response", e);
        }
        return null;
    }

    /* renamed from: a */
    static C3103a m9551a(String str) {
        try {
            C3104b bVar = (C3104b) new GsonBuilder().registerTypeAdapterFactory(new C3115m()).registerTypeAdapterFactory(new C3117n()).create().fromJson(str, C3104b.class);
            if (!bVar.f8161a.isEmpty()) {
                return (C3103a) bVar.f8161a.get(0);
            }
        } catch (JsonSyntaxException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid json: ");
            sb.append(str);
            C3256m.m9537g().mo27613c("Twitter", sb.toString(), e);
        }
        return null;
    }

    /* renamed from: a */
    static String m9553a(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("HTTP request failed, Status: ");
        sb.append(i);
        return sb.toString();
    }
}
