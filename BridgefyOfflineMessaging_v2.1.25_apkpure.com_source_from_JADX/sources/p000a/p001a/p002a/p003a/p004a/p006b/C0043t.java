package p000a.p001a.p002a.p003a.p004a.p006b;

import android.os.SystemClock;
import android.util.Log;

/* renamed from: a.a.a.a.a.b.t */
/* compiled from: TimingMetric */
public class C0043t {

    /* renamed from: a */
    private final String f98a;

    /* renamed from: b */
    private final String f99b;

    /* renamed from: c */
    private final boolean f100c;

    /* renamed from: d */
    private long f101d;

    /* renamed from: e */
    private long f102e;

    public C0043t(String str, String str2) {
        this.f98a = str;
        this.f99b = str2;
        this.f100c = !Log.isLoggable(str2, 2);
    }

    /* renamed from: a */
    public synchronized void mo82a() {
        if (!this.f100c) {
            this.f101d = SystemClock.elapsedRealtime();
            this.f102e = 0;
        }
    }

    /* renamed from: b */
    public synchronized void mo83b() {
        if (!this.f100c) {
            if (this.f102e == 0) {
                this.f102e = SystemClock.elapsedRealtime() - this.f101d;
                m159c();
            }
        }
    }

    /* renamed from: c */
    private void m159c() {
        String str = this.f99b;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f98a);
        sb.append(": ");
        sb.append(this.f102e);
        sb.append("ms");
        Log.v(str, sb.toString());
    }
}
