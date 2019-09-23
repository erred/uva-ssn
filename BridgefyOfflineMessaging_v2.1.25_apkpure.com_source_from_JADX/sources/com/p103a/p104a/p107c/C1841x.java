package com.p103a.p104a.p107c;

/* renamed from: com.a.a.c.x */
/* compiled from: MiddleOutFallbackStrategy */
class C1841x implements C1769ai {

    /* renamed from: a */
    private final int f5674a;

    /* renamed from: b */
    private final C1769ai[] f5675b;

    /* renamed from: c */
    private final C1842y f5676c;

    public C1841x(int i, C1769ai... aiVarArr) {
        this.f5674a = i;
        this.f5675b = aiVarArr;
        this.f5676c = new C1842y(i);
    }

    /* renamed from: a */
    public StackTraceElement[] mo7021a(StackTraceElement[] stackTraceElementArr) {
        C1769ai[] aiVarArr;
        if (stackTraceElementArr.length <= this.f5674a) {
            return stackTraceElementArr;
        }
        StackTraceElement[] stackTraceElementArr2 = stackTraceElementArr;
        for (C1769ai aiVar : this.f5675b) {
            if (stackTraceElementArr2.length <= this.f5674a) {
                break;
            }
            stackTraceElementArr2 = aiVar.mo7021a(stackTraceElementArr);
        }
        if (stackTraceElementArr2.length > this.f5674a) {
            stackTraceElementArr2 = this.f5676c.mo7021a(stackTraceElementArr2);
        }
        return stackTraceElementArr2;
    }
}
