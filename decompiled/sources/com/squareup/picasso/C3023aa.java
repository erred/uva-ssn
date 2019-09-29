package com.squareup.picasso;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* renamed from: com.squareup.picasso.aa */
/* compiled from: Stats */
class C3023aa {

    /* renamed from: a */
    final HandlerThread f7890a = new HandlerThread("Picasso-Stats", 10);

    /* renamed from: b */
    final C3042d f7891b;

    /* renamed from: c */
    final Handler f7892c;

    /* renamed from: d */
    long f7893d;

    /* renamed from: e */
    long f7894e;

    /* renamed from: f */
    long f7895f;

    /* renamed from: g */
    long f7896g;

    /* renamed from: h */
    long f7897h;

    /* renamed from: i */
    long f7898i;

    /* renamed from: j */
    long f7899j;

    /* renamed from: k */
    long f7900k;

    /* renamed from: l */
    int f7901l;

    /* renamed from: m */
    int f7902m;

    /* renamed from: n */
    int f7903n;

    /* renamed from: com.squareup.picasso.aa$a */
    /* compiled from: Stats */
    private static class C3024a extends Handler {

        /* renamed from: a */
        private final C3023aa f7904a;

        C3024a(Looper looper, C3023aa aaVar) {
            super(looper);
            this.f7904a = aaVar;
        }

        public void handleMessage(final Message message) {
            switch (message.what) {
                case 0:
                    this.f7904a.mo27438c();
                    return;
                case 1:
                    this.f7904a.mo27440d();
                    return;
                case 2:
                    this.f7904a.mo27436b((long) message.arg1);
                    return;
                case 3:
                    this.f7904a.mo27439c((long) message.arg1);
                    return;
                case 4:
                    this.f7904a.mo27434a((Long) message.obj);
                    return;
                default:
                    C3068t.f8019a.post(new Runnable() {
                        public void run() {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Unhandled stats message.");
                            sb.append(message.what);
                            throw new AssertionError(sb.toString());
                        }
                    });
                    return;
            }
        }
    }

    C3023aa(C3042d dVar) {
        this.f7891b = dVar;
        this.f7890a.start();
        C3030af.m8943a(this.f7890a.getLooper());
        this.f7892c = new C3024a(this.f7890a.getLooper(), this);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo27433a(Bitmap bitmap) {
        m8911a(bitmap, 2);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo27437b(Bitmap bitmap) {
        m8911a(bitmap, 3);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo27432a(long j) {
        this.f7892c.sendMessage(this.f7892c.obtainMessage(4, Long.valueOf(j)));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo27431a() {
        this.f7892c.sendEmptyMessage(0);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo27435b() {
        this.f7892c.sendEmptyMessage(1);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo27438c() {
        this.f7893d++;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo27440d() {
        this.f7894e++;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo27434a(Long l) {
        this.f7901l++;
        this.f7895f += l.longValue();
        this.f7898i = m8910a(this.f7901l, this.f7895f);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo27436b(long j) {
        this.f7902m++;
        this.f7896g += j;
        this.f7899j = m8910a(this.f7902m, this.f7896g);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo27439c(long j) {
        this.f7903n++;
        this.f7897h += j;
        this.f7900k = m8910a(this.f7902m, this.f7897h);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public C3026ab mo27441e() {
        C3026ab abVar = new C3026ab(this.f7891b.mo27483b(), this.f7891b.mo27480a(), this.f7893d, this.f7894e, this.f7895f, this.f7896g, this.f7897h, this.f7898i, this.f7899j, this.f7900k, this.f7901l, this.f7902m, this.f7903n, System.currentTimeMillis());
        return abVar;
    }

    /* renamed from: a */
    private void m8911a(Bitmap bitmap, int i) {
        this.f7892c.sendMessage(this.f7892c.obtainMessage(i, C3030af.m8932a(bitmap), 0));
    }

    /* renamed from: a */
    private static long m8910a(int i, long j) {
        return j / ((long) i);
    }
}
