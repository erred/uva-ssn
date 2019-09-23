package com.twitter.sdk.android.core.internal.p134b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/* renamed from: com.twitter.sdk.android.core.internal.b.c */
/* compiled from: PreferenceStoreImpl */
public class C3165c implements C3164b {

    /* renamed from: a */
    private final SharedPreferences f8315a;

    public C3165c(Context context, String str) {
        if (context != null) {
            this.f8315a = context.getSharedPreferences(str, 0);
            return;
        }
        throw new IllegalArgumentException("Context must not be null");
    }

    /* renamed from: a */
    public SharedPreferences mo27683a() {
        return this.f8315a;
    }

    /* renamed from: b */
    public Editor mo27685b() {
        return this.f8315a.edit();
    }

    /* renamed from: a */
    public boolean mo27684a(Editor editor) {
        editor.apply();
        return true;
    }
}
