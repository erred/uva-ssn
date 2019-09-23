package androidx.constraintlayout.p060b;

/* renamed from: androidx.constraintlayout.b.g */
/* compiled from: Pools */
final class C0789g {

    /* renamed from: androidx.constraintlayout.b.g$a */
    /* compiled from: Pools */
    interface C0790a<T> {
        /* renamed from: a */
        T mo3225a();

        /* renamed from: a */
        void mo3226a(T[] tArr, int i);

        /* renamed from: a */
        boolean mo3227a(T t);
    }

    /* renamed from: androidx.constraintlayout.b.g$b */
    /* compiled from: Pools */
    static class C0791b<T> implements C0790a<T> {

        /* renamed from: a */
        private final Object[] f2428a;

        /* renamed from: b */
        private int f2429b;

        C0791b(int i) {
            if (i > 0) {
                this.f2428a = new Object[i];
                return;
            }
            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        /* renamed from: a */
        public T mo3225a() {
            if (this.f2429b <= 0) {
                return null;
            }
            int i = this.f2429b - 1;
            T t = this.f2428a[i];
            this.f2428a[i] = null;
            this.f2429b--;
            return t;
        }

        /* renamed from: a */
        public boolean mo3227a(T t) {
            if (this.f2429b >= this.f2428a.length) {
                return false;
            }
            this.f2428a[this.f2429b] = t;
            this.f2429b++;
            return true;
        }

        /* renamed from: a */
        public void mo3226a(T[] tArr, int i) {
            if (i > tArr.length) {
                i = tArr.length;
            }
            for (int i2 = 0; i2 < i; i2++) {
                T t = tArr[i2];
                if (this.f2429b < this.f2428a.length) {
                    this.f2428a[this.f2429b] = t;
                    this.f2429b++;
                }
            }
        }
    }
}
