package androidx.core.p069f;

/* renamed from: androidx.core.f.d */
/* compiled from: Pools */
public final class C0926d {

    /* renamed from: androidx.core.f.d$a */
    /* compiled from: Pools */
    public interface C0927a<T> {
        /* renamed from: a */
        T mo3647a();

        /* renamed from: a */
        boolean mo3648a(T t);
    }

    /* renamed from: androidx.core.f.d$b */
    /* compiled from: Pools */
    public static class C0928b<T> implements C0927a<T> {

        /* renamed from: a */
        private final Object[] f2948a;

        /* renamed from: b */
        private int f2949b;

        public C0928b(int i) {
            if (i > 0) {
                this.f2948a = new Object[i];
                return;
            }
            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        /* renamed from: a */
        public T mo3647a() {
            if (this.f2949b <= 0) {
                return null;
            }
            int i = this.f2949b - 1;
            T t = this.f2948a[i];
            this.f2948a[i] = null;
            this.f2949b--;
            return t;
        }

        /* renamed from: a */
        public boolean mo3648a(T t) {
            if (m3397b(t)) {
                throw new IllegalStateException("Already in the pool!");
            } else if (this.f2949b >= this.f2948a.length) {
                return false;
            } else {
                this.f2948a[this.f2949b] = t;
                this.f2949b++;
                return true;
            }
        }

        /* renamed from: b */
        private boolean m3397b(T t) {
            for (int i = 0; i < this.f2949b; i++) {
                if (this.f2948a[i] == t) {
                    return true;
                }
            }
            return false;
        }
    }

    /* renamed from: androidx.core.f.d$c */
    /* compiled from: Pools */
    public static class C0929c<T> extends C0928b<T> {

        /* renamed from: a */
        private final Object f2950a = new Object();

        public C0929c(int i) {
            super(i);
        }

        /* renamed from: a */
        public T mo3647a() {
            T a;
            synchronized (this.f2950a) {
                a = super.mo3647a();
            }
            return a;
        }

        /* renamed from: a */
        public boolean mo3648a(T t) {
            boolean a;
            synchronized (this.f2950a) {
                a = super.mo3648a(t);
            }
            return a;
        }
    }
}
