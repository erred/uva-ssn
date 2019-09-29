package p000a.p001a.p002a.p003a.p004a.p007c;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* renamed from: a.a.a.a.a.c.h */
/* compiled from: PriorityFutureTask */
public class C0068h<V> extends FutureTask<V> implements C0060b<C0073l>, C0069i, C0073l {

    /* renamed from: b */
    final Object f149b;

    public C0068h(Callable<V> callable) {
        super(callable);
        this.f149b = mo142a((Object) callable);
    }

    public C0068h(Runnable runnable, V v) {
        super(runnable, v);
        this.f149b = mo142a((Object) runnable);
    }

    public int compareTo(Object obj) {
        return ((C0069i) mo141a()).compareTo(obj);
    }

    /* renamed from: a */
    public void mo106c(C0073l lVar) {
        ((C0060b) ((C0069i) mo141a())).mo106c(lVar);
    }

    /* renamed from: c */
    public Collection<C0073l> mo105c() {
        return ((C0060b) ((C0069i) mo141a())).mo105c();
    }

    /* renamed from: d */
    public boolean mo107d() {
        return ((C0060b) ((C0069i) mo141a())).mo107d();
    }

    /* renamed from: b */
    public C0063e mo135b() {
        return ((C0069i) mo141a()).mo135b();
    }

    /* renamed from: b */
    public void mo136b(boolean z) {
        ((C0073l) ((C0069i) mo141a())).mo136b(z);
    }

    /* renamed from: f */
    public boolean mo138f() {
        return ((C0073l) ((C0069i) mo141a())).mo138f();
    }

    /* renamed from: a */
    public void mo133a(Throwable th) {
        ((C0073l) ((C0069i) mo141a())).mo133a(th);
    }

    /* renamed from: a */
    public <T extends C0060b<C0073l> & C0069i & C0073l> T mo141a() {
        return (C0060b) this.f149b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public <T extends C0060b<C0073l> & C0069i & C0073l> T mo142a(Object obj) {
        if (C0070j.m223a(obj)) {
            return (C0060b) obj;
        }
        return new C0070j();
    }
}
