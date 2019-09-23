package p140me.bridgefy.intro.verification;

import android.os.CountDownTimer;

/* renamed from: me.bridgefy.intro.verification.e */
/* compiled from: CustomCountDownTimer */
public abstract class C3579e {

    /* renamed from: a */
    private final long f9398a;

    /* renamed from: b */
    private final long f9399b;

    /* renamed from: c */
    private CountDownTimer f9400c;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo29457a();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo29458a(long j);

    public C3579e(long j, long j2) {
        this.f9398a = j;
        this.f9399b = j2;
        this.f9400c = m10517a(j, j2);
    }

    /* renamed from: a */
    private CountDownTimer m10517a(long j, long j2) {
        C35801 r0 = new CountDownTimer(j, j2) {
            public void onTick(long j) {
                C3579e.this.mo29458a(j);
            }

            public void onFinish() {
                C3579e.this.mo29457a();
            }
        };
        return r0;
    }

    /* renamed from: b */
    public void mo29495b() {
        this.f9400c.start();
    }
}
