package com.twitter.sdk.android.core;

import android.util.Log;

/* renamed from: com.twitter.sdk.android.core.d */
/* compiled from: DefaultLogger */
public class C3129d implements C3135h {

    /* renamed from: a */
    private int f8263a = 4;

    /* renamed from: a */
    public boolean mo27609a(String str, int i) {
        return this.f8263a <= i;
    }

    /* renamed from: a */
    public void mo27608a(String str, String str2, Throwable th) {
        if (mo27609a(str, 3)) {
            Log.d(str, str2, th);
        }
    }

    /* renamed from: b */
    public void mo27611b(String str, String str2, Throwable th) {
        if (mo27609a(str, 5)) {
            Log.w(str, str2, th);
        }
    }

    /* renamed from: c */
    public void mo27613c(String str, String str2, Throwable th) {
        if (mo27609a(str, 6)) {
            Log.e(str, str2, th);
        }
    }

    /* renamed from: a */
    public void mo27607a(String str, String str2) {
        mo27608a(str, str2, (Throwable) null);
    }

    /* renamed from: b */
    public void mo27610b(String str, String str2) {
        mo27611b(str, str2, null);
    }

    /* renamed from: c */
    public void mo27612c(String str, String str2) {
        mo27613c(str, str2, null);
    }

    /* renamed from: a */
    public void mo27605a(int i, String str, String str2) {
        mo27606a(i, str, str2, false);
    }

    /* renamed from: a */
    public void mo27606a(int i, String str, String str2, boolean z) {
        if (z || mo27609a(str, i)) {
            Log.println(i, str, str2);
        }
    }
}
