package p000a.p013b.p020e.p031f;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import p000a.p013b.p020e.p023c.C0211f;
import p000a.p013b.p020e.p035j.C0322i;

/* renamed from: a.b.e.f.b */
/* compiled from: SpscLinkedArrayQueue */
public final class C0279b<T> implements C0211f<T> {

    /* renamed from: a */
    static final int f561a = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();

    /* renamed from: j */
    private static final Object f562j = new Object();

    /* renamed from: b */
    final AtomicLong f563b = new AtomicLong();

    /* renamed from: c */
    int f564c;

    /* renamed from: d */
    long f565d;

    /* renamed from: e */
    final int f566e;

    /* renamed from: f */
    AtomicReferenceArray<Object> f567f;

    /* renamed from: g */
    final int f568g;

    /* renamed from: h */
    AtomicReferenceArray<Object> f569h;

    /* renamed from: i */
    final AtomicLong f570i = new AtomicLong();

    /* renamed from: b */
    private static int m749b(int i) {
        return i;
    }

    public C0279b(int i) {
        int a = C0322i.m869a(Math.max(8, i));
        int i2 = a - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(a + 1);
        this.f567f = atomicReferenceArray;
        this.f566e = i2;
        m743a(a);
        this.f569h = atomicReferenceArray;
        this.f568g = i2;
        this.f565d = (long) (i2 - 1);
        m744a(0);
    }

    /* renamed from: a */
    public boolean mo383a(T t) {
        if (t != null) {
            AtomicReferenceArray<Object> atomicReferenceArray = this.f567f;
            long f = m754f();
            int i = this.f566e;
            int a = m740a(f, i);
            if (f < this.f565d) {
                return m748a(atomicReferenceArray, t, f, a);
            }
            long j = ((long) this.f564c) + f;
            if (m750b(atomicReferenceArray, m740a(j, i)) == null) {
                this.f565d = j - 1;
                return m748a(atomicReferenceArray, t, f, a);
            } else if (m750b(atomicReferenceArray, m740a(1 + f, i)) == null) {
                return m748a(atomicReferenceArray, t, f, a);
            } else {
                m746a(atomicReferenceArray, f, a, t, (long) i);
                return true;
            }
        } else {
            throw new NullPointerException("Null is not a valid element");
        }
    }

    /* renamed from: a */
    private boolean m748a(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j, int i) {
        m745a(atomicReferenceArray, i, (Object) t);
        m744a(j + 1);
        return true;
    }

    /* renamed from: a */
    private void m746a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i, T t, long j2) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f567f = atomicReferenceArray2;
        this.f565d = (j2 + j) - 1;
        m745a(atomicReferenceArray2, i, (Object) t);
        m747a(atomicReferenceArray, atomicReferenceArray2);
        m745a(atomicReferenceArray, i, f562j);
        m744a(j + 1);
    }

    /* renamed from: a */
    private void m747a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        m745a(atomicReferenceArray, m749b(atomicReferenceArray.length() - 1), (Object) atomicReferenceArray2);
    }

    /* renamed from: a */
    private AtomicReferenceArray<Object> m742a(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        int b = m749b(i);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) m750b(atomicReferenceArray, b);
        m745a(atomicReferenceArray, b, (Object) null);
        return atomicReferenceArray2;
    }

    /* renamed from: e_ */
    public T mo386e_() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f569h;
        long g = m755g();
        int i = this.f568g;
        int a = m740a(g, i);
        T b = m750b(atomicReferenceArray, a);
        boolean z = b == f562j;
        if (b != null && !z) {
            m745a(atomicReferenceArray, a, (Object) null);
            m751b(g + 1);
            return b;
        } else if (z) {
            return m741a(m742a(atomicReferenceArray, i + 1), g, i);
        } else {
            return null;
        }
    }

    /* renamed from: a */
    private T m741a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.f569h = atomicReferenceArray;
        int a = m740a(j, i);
        T b = m750b(atomicReferenceArray, a);
        if (b != null) {
            m745a(atomicReferenceArray, a, (Object) null);
            m751b(j + 1);
        }
        return b;
    }

    /* renamed from: c */
    public void mo385c() {
        while (true) {
            if (mo386e_() == null && mo384b()) {
                return;
            }
        }
    }

    /* renamed from: b */
    public boolean mo384b() {
        return m752d() == m753e();
    }

    /* renamed from: a */
    private void m743a(int i) {
        this.f564c = Math.min(i / 4, f561a);
    }

    /* renamed from: d */
    private long m752d() {
        return this.f563b.get();
    }

    /* renamed from: e */
    private long m753e() {
        return this.f570i.get();
    }

    /* renamed from: f */
    private long m754f() {
        return this.f563b.get();
    }

    /* renamed from: g */
    private long m755g() {
        return this.f570i.get();
    }

    /* renamed from: a */
    private void m744a(long j) {
        this.f563b.lazySet(j);
    }

    /* renamed from: b */
    private void m751b(long j) {
        this.f570i.lazySet(j);
    }

    /* renamed from: a */
    private static int m740a(long j, int i) {
        return m749b(((int) j) & i);
    }

    /* renamed from: a */
    private static void m745a(AtomicReferenceArray<Object> atomicReferenceArray, int i, Object obj) {
        atomicReferenceArray.lazySet(i, obj);
    }

    /* renamed from: b */
    private static <E> Object m750b(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        return atomicReferenceArray.get(i);
    }
}
