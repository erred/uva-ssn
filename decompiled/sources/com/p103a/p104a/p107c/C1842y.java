package com.p103a.p104a.p107c;

/* renamed from: com.a.a.c.y */
/* compiled from: MiddleOutStrategy */
class C1842y implements C1769ai {

    /* renamed from: a */
    private final int f5677a;

    public C1842y(int i) {
        this.f5677a = i;
    }

    /* renamed from: a */
    public StackTraceElement[] mo7021a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr.length <= this.f5677a) {
            return stackTraceElementArr;
        }
        int i = this.f5677a / 2;
        int i2 = this.f5677a - i;
        StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[this.f5677a];
        System.arraycopy(stackTraceElementArr, 0, stackTraceElementArr2, 0, i2);
        System.arraycopy(stackTraceElementArr, stackTraceElementArr.length - i, stackTraceElementArr2, i2, i);
        return stackTraceElementArr2;
    }
}
