package com.firebase.p119ui.auth.p124ui.phone;

import android.os.CountDownTimer;

/* renamed from: com.firebase.ui.auth.ui.phone.f */
/* compiled from: CustomCountDownTimer */
abstract class C2100f {

    /* renamed from: a */
    private final long f6446a;

    /* renamed from: b */
    private final long f6447b;

    /* renamed from: c */
    private CountDownTimer f6448c;

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo11961b(long j);

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public abstract void mo11963d();

    C2100f(long j, long j2) {
        this.f6446a = j;
        this.f6447b = j2;
        this.f6448c = m8413a(j, j2);
    }

    /* renamed from: a */
    public void mo11959a(long j) {
        this.f6448c.cancel();
        this.f6448c = m8413a(j, this.f6447b);
        this.f6448c.start();
    }

    /* renamed from: a */
    public void mo11958a() {
        mo11959a(this.f6446a);
    }

    /* renamed from: a */
    private CountDownTimer m8413a(long j, long j2) {
        C21011 r0 = new CountDownTimer(j, j2) {
            public void onTick(long j) {
                C2100f.this.mo11961b(j);
            }

            public void onFinish() {
                C2100f.this.mo11963d();
            }
        };
        return r0;
    }

    /* renamed from: b */
    public void mo11960b() {
        this.f6448c.cancel();
    }

    /* renamed from: c */
    public void mo11962c() {
        this.f6448c.start();
    }
}
