package com.p103a.p104a.p107c;

import android.content.Context;
import p000a.p001a.p002a.p003a.p004a.p006b.C0020i;
import p000a.p001a.p002a.p003a.p004a.p012g.C0121o;

/* renamed from: com.a.a.c.r */
/* compiled from: DialogStringResolver */
class C1832r {

    /* renamed from: a */
    private final Context f5661a;

    /* renamed from: b */
    private final C0121o f5662b;

    public C1832r(Context context, C0121o oVar) {
        this.f5661a = context;
        this.f5662b = oVar;
    }

    /* renamed from: a */
    public String mo7161a() {
        return m7543a("com.crashlytics.CrashSubmissionPromptTitle", this.f5662b.f265a);
    }

    /* renamed from: b */
    public String mo7162b() {
        return m7543a("com.crashlytics.CrashSubmissionPromptMessage", this.f5662b.f266b);
    }

    /* renamed from: c */
    public String mo7163c() {
        return m7543a("com.crashlytics.CrashSubmissionSendTitle", this.f5662b.f267c);
    }

    /* renamed from: d */
    public String mo7164d() {
        return m7543a("com.crashlytics.CrashSubmissionAlwaysSendTitle", this.f5662b.f271g);
    }

    /* renamed from: e */
    public String mo7165e() {
        return m7543a("com.crashlytics.CrashSubmissionCancelTitle", this.f5662b.f269e);
    }

    /* renamed from: a */
    private String m7543a(String str, String str2) {
        return m7545b(C0020i.m77b(this.f5661a, str), str2);
    }

    /* renamed from: b */
    private String m7545b(String str, String str2) {
        return m7544a(str) ? str2 : str;
    }

    /* renamed from: a */
    private boolean m7544a(String str) {
        return str == null || str.length() == 0;
    }
}
