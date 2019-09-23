package p000a.p013b.p020e.p031f;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import p000a.p013b.p020e.p023c.C0211f;
import p000a.p013b.p020e.p035j.C0322i;

/* renamed from: a.b.e.f.a */
/* compiled from: SpscArrayQueue */
public final class C0278a<E> extends AtomicReferenceArray<E> implements C0211f<E> {

    /* renamed from: f */
    private static final Integer f555f = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);

    /* renamed from: a */
    final int f556a = (length() - 1);

    /* renamed from: b */
    final AtomicLong f557b = new AtomicLong();

    /* renamed from: c */
    long f558c;

    /* renamed from: d */
    final AtomicLong f559d = new AtomicLong();

    /* renamed from: e */
    final int f560e;

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int mo470a(long j, int i) {
        return ((int) j) & i;
    }

    public C0278a(int i) {
        super(C0322i.m869a(i));
        this.f560e = Math.min(i / 4, f555f.intValue());
    }

    /* renamed from: a */
    public boolean mo383a(E e) {
        if (e != null) {
            int i = this.f556a;
            long j = this.f557b.get();
            int a = mo470a(j, i);
            if (j >= this.f558c) {
                long j2 = ((long) this.f560e) + j;
                if (mo471a(mo470a(j2, i)) == null) {
                    this.f558c = j2;
                } else if (mo471a(a) != null) {
                    return false;
                }
            }
            mo472a(a, e);
            mo473a(j + 1);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    /* renamed from: e_ */
    public E mo386e_() {
        long j = this.f559d.get();
        int c = mo475c(j);
        E a = mo471a(c);
        if (a == null) {
            return null;
        }
        mo474b(j + 1);
        mo472a(c, (E) null);
        return a;
    }

    /* renamed from: b */
    public boolean mo384b() {
        return this.f557b.get() == this.f559d.get();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo473a(long j) {
        this.f557b.lazySet(j);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo474b(long j) {
        this.f559d.lazySet(j);
    }

    /* renamed from: c */
    public void mo385c() {
        while (true) {
            if (mo386e_() == null && mo384b()) {
                return;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public int mo475c(long j) {
        return ((int) j) & this.f556a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo472a(int i, E e) {
        lazySet(i, e);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public E mo471a(int i) {
        return get(i);
    }
}
