package com.twitter.sdk.android.core;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.twitter.sdk.android.core.internal.oauth.C3194a;
import com.twitter.sdk.android.core.internal.p134b.C3167e;

/* renamed from: com.twitter.sdk.android.core.e */
/* compiled from: GuestSession */
public class C3130e extends C3254k<C3194a> {

    /* renamed from: com.twitter.sdk.android.core.e$a */
    /* compiled from: GuestSession */
    public static class C3131a implements C3167e<C3130e> {

        /* renamed from: a */
        private final Gson f8264a = new GsonBuilder().registerTypeAdapter(C3194a.class, new C3127b()).create();

        /* renamed from: a */
        public String mo27616a(C3130e eVar) {
            if (!(eVar == null || eVar.mo27849a() == null)) {
                try {
                    return this.f8264a.toJson((Object) eVar);
                } catch (Exception e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to serialize session ");
                    sb.append(e.getMessage());
                    C3256m.m9537g().mo27607a("Twitter", sb.toString());
                }
            }
            return "";
        }

        /* renamed from: a */
        public C3130e mo27617b(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    return (C3130e) this.f8264a.fromJson(str, C3130e.class);
                } catch (Exception e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to deserialize session ");
                    sb.append(e.getMessage());
                    C3256m.m9537g().mo27607a("Twitter", sb.toString());
                }
            }
            return null;
        }
    }

    public C3130e(C3194a aVar) {
        super(aVar, 0);
    }
}
