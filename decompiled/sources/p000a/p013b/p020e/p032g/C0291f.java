package p000a.p013b.p020e.p032g;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: a.b.e.g.f */
/* compiled from: RxThreadFactory */
public final class C0291f extends AtomicLong implements ThreadFactory {

    /* renamed from: a */
    final String f611a;

    /* renamed from: b */
    final int f612b;

    /* renamed from: c */
    final boolean f613c;

    /* renamed from: a.b.e.g.f$a */
    /* compiled from: RxThreadFactory */
    static final class C0292a extends Thread {
        C0292a(Runnable runnable, String str) {
            super(runnable, str);
        }
    }

    public C0291f(String str) {
        this(str, 5, false);
    }

    public C0291f(String str, int i) {
        this(str, i, false);
    }

    public C0291f(String str, int i, boolean z) {
        this.f611a = str;
        this.f612b = i;
        this.f613c = z;
    }

    public Thread newThread(Runnable runnable) {
        StringBuilder sb = new StringBuilder(this.f611a);
        sb.append('-');
        sb.append(incrementAndGet());
        String sb2 = sb.toString();
        Thread aVar = this.f613c ? new C0292a(runnable, sb2) : new Thread(runnable, sb2);
        aVar.setPriority(this.f612b);
        aVar.setDaemon(true);
        return aVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RxThreadFactory[");
        sb.append(this.f611a);
        sb.append("]");
        return sb.toString();
    }
}
