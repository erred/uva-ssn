package p000a.p013b.p020e.p033h;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.p153a.C3683c;
import org.p153a.C3684d;
import p000a.p013b.C0344k;
import p000a.p013b.p020e.p034i.C0310e;
import p000a.p013b.p020e.p035j.C0312b;
import p000a.p013b.p020e.p035j.C0317f;

/* renamed from: a.b.e.h.a */
/* compiled from: StrictSubscriber */
public class C0305a<T> extends AtomicInteger implements C0344k<T>, C3684d {

    /* renamed from: a */
    final C3683c<? super T> f646a;

    /* renamed from: b */
    final C0312b f647b = new C0312b();

    /* renamed from: c */
    final AtomicLong f648c = new AtomicLong();

    /* renamed from: d */
    final AtomicReference<C3684d> f649d = new AtomicReference<>();

    /* renamed from: e */
    final AtomicBoolean f650e = new AtomicBoolean();

    /* renamed from: f */
    volatile boolean f651f;

    public C0305a(C3683c<? super T> cVar) {
        this.f646a = cVar;
    }

    /* renamed from: a */
    public void mo408a(long j) {
        if (j <= 0) {
            mo407a();
            StringBuilder sb = new StringBuilder();
            sb.append("§3.9 violated: positive request amount required but it was ");
            sb.append(j);
            onError(new IllegalArgumentException(sb.toString()));
            return;
        }
        C0310e.m830a(this.f649d, this.f648c, j);
    }

    /* renamed from: a */
    public void mo407a() {
        if (!this.f651f) {
            C0310e.m831a(this.f649d);
        }
    }

    public void onSubscribe(C3684d dVar) {
        if (this.f650e.compareAndSet(false, true)) {
            this.f646a.onSubscribe(this);
            C0310e.m832a(this.f649d, this.f648c, dVar);
            return;
        }
        dVar.mo407a();
        mo407a();
        onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
    }

    public void onNext(T t) {
        C0317f.m855a(this.f646a, t, (AtomicInteger) this, this.f647b);
    }

    public void onError(Throwable th) {
        this.f651f = true;
        C0317f.m856a(this.f646a, th, (AtomicInteger) this, this.f647b);
    }

    public void onComplete() {
        this.f651f = true;
        C0317f.m857a(this.f646a, this, this.f647b);
    }
}
