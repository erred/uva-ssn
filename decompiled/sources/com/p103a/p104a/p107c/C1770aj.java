package com.p103a.p104a.p107c;

/* renamed from: com.a.a.c.aj */
/* compiled from: TrimmedThrowableData */
class C1770aj {

    /* renamed from: a */
    public final String f5533a;

    /* renamed from: b */
    public final String f5534b;

    /* renamed from: c */
    public final StackTraceElement[] f5535c;

    /* renamed from: d */
    public final C1770aj f5536d;

    public C1770aj(Throwable th, C1769ai aiVar) {
        this.f5533a = th.getLocalizedMessage();
        this.f5534b = th.getClass().getName();
        this.f5535c = aiVar.mo7021a(th.getStackTrace());
        Throwable cause = th.getCause();
        this.f5536d = cause != null ? new C1770aj(cause, aiVar) : null;
    }
}
