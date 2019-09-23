package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.C1277x;
import java.util.ArrayList;
import java.util.List;

/* renamed from: androidx.recyclerview.widget.b */
/* compiled from: ChildHelper */
class C1290b {

    /* renamed from: a */
    final C1292b f3857a;

    /* renamed from: b */
    final C1291a f3858b = new C1291a();

    /* renamed from: c */
    final List<View> f3859c = new ArrayList();

    /* renamed from: androidx.recyclerview.widget.b$a */
    /* compiled from: ChildHelper */
    static class C1291a {

        /* renamed from: a */
        long f3860a = 0;

        /* renamed from: b */
        C1291a f3861b;

        C1291a() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo5459a(int i) {
            if (i >= 64) {
                m5254b();
                this.f3861b.mo5459a(i - 64);
                return;
            }
            this.f3860a |= 1 << i;
        }

        /* renamed from: b */
        private void m5254b() {
            if (this.f3861b == null) {
                this.f3861b = new C1291a();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo5461b(int i) {
            if (i < 64) {
                this.f3860a &= ~(1 << i);
            } else if (this.f3861b != null) {
                this.f3861b.mo5461b(i - 64);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public boolean mo5462c(int i) {
            if (i >= 64) {
                m5254b();
                return this.f3861b.mo5462c(i - 64);
            }
            return (this.f3860a & (1 << i)) != 0;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo5458a() {
            this.f3860a = 0;
            if (this.f3861b != null) {
                this.f3861b.mo5458a();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo5460a(int i, boolean z) {
            if (i >= 64) {
                m5254b();
                this.f3861b.mo5460a(i - 64, z);
                return;
            }
            boolean z2 = (this.f3860a & Long.MIN_VALUE) != 0;
            long j = (1 << i) - 1;
            this.f3860a = (this.f3860a & j) | (((~j) & this.f3860a) << 1);
            if (z) {
                mo5459a(i);
            } else {
                mo5461b(i);
            }
            if (z2 || this.f3861b != null) {
                m5254b();
                this.f3861b.mo5460a(0, z2);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public boolean mo5463d(int i) {
            if (i >= 64) {
                m5254b();
                return this.f3861b.mo5463d(i - 64);
            }
            long j = 1 << i;
            boolean z = (this.f3860a & j) != 0;
            this.f3860a &= ~j;
            long j2 = j - 1;
            this.f3860a = (this.f3860a & j2) | Long.rotateRight((~j2) & this.f3860a, 1);
            if (this.f3861b != null) {
                if (this.f3861b.mo5462c(0)) {
                    mo5459a(63);
                }
                this.f3861b.mo5463d(0);
            }
            return z;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: e */
        public int mo5464e(int i) {
            if (this.f3861b == null) {
                if (i >= 64) {
                    return Long.bitCount(this.f3860a);
                }
                return Long.bitCount(this.f3860a & ((1 << i) - 1));
            } else if (i < 64) {
                return Long.bitCount(this.f3860a & ((1 << i) - 1));
            } else {
                return this.f3861b.mo5464e(i - 64) + Long.bitCount(this.f3860a);
            }
        }

        public String toString() {
            if (this.f3861b == null) {
                return Long.toBinaryString(this.f3860a);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.f3861b.toString());
            sb.append("xx");
            sb.append(Long.toBinaryString(this.f3860a));
            return sb.toString();
        }
    }

    /* renamed from: androidx.recyclerview.widget.b$b */
    /* compiled from: ChildHelper */
    interface C1292b {
        /* renamed from: a */
        int mo5003a();

        /* renamed from: a */
        int mo5004a(View view);

        /* renamed from: a */
        void mo5005a(int i);

        /* renamed from: a */
        void mo5006a(View view, int i);

        /* renamed from: a */
        void mo5007a(View view, int i, LayoutParams layoutParams);

        /* renamed from: b */
        View mo5008b(int i);

        /* renamed from: b */
        C1277x mo5009b(View view);

        /* renamed from: b */
        void mo5010b();

        /* renamed from: c */
        void mo5011c(int i);

        /* renamed from: c */
        void mo5012c(View view);

        /* renamed from: d */
        void mo5013d(View view);
    }

    C1290b(C1292b bVar) {
        this.f3857a = bVar;
    }

    /* renamed from: g */
    private void m5235g(View view) {
        this.f3859c.add(view);
        this.f3857a.mo5012c(view);
    }

    /* renamed from: h */
    private boolean m5236h(View view) {
        if (!this.f3859c.remove(view)) {
            return false;
        }
        this.f3857a.mo5013d(view);
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo5445a(View view, boolean z) {
        mo5444a(view, -1, z);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo5444a(View view, int i, boolean z) {
        int i2;
        if (i < 0) {
            i2 = this.f3857a.mo5003a();
        } else {
            i2 = m5234f(i);
        }
        this.f3858b.mo5460a(i2, z);
        if (z) {
            m5235g(view);
        }
        this.f3857a.mo5006a(view, i2);
    }

    /* renamed from: f */
    private int m5234f(int i) {
        if (i < 0) {
            return -1;
        }
        int a = this.f3857a.mo5003a();
        int i2 = i;
        while (i2 < a) {
            int e = i - (i2 - this.f3858b.mo5464e(i2));
            if (e == 0) {
                while (this.f3858b.mo5462c(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += e;
        }
        return -1;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo5442a(View view) {
        int a = this.f3857a.mo5004a(view);
        if (a >= 0) {
            if (this.f3858b.mo5463d(a)) {
                m5236h(view);
            }
            this.f3857a.mo5005a(a);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo5441a(int i) {
        int f = m5234f(i);
        View b = this.f3857a.mo5008b(f);
        if (b != null) {
            if (this.f3858b.mo5463d(f)) {
                m5236h(b);
            }
            this.f3857a.mo5005a(f);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public View mo5448b(int i) {
        return this.f3857a.mo5008b(m5234f(i));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo5440a() {
        this.f3858b.mo5458a();
        for (int size = this.f3859c.size() - 1; size >= 0; size--) {
            this.f3857a.mo5013d((View) this.f3859c.get(size));
            this.f3859c.remove(size);
        }
        this.f3857a.mo5010b();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public View mo5450c(int i) {
        int size = this.f3859c.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = (View) this.f3859c.get(i2);
            C1277x b = this.f3857a.mo5009b(view);
            if (b.getLayoutPosition() == i && !b.isInvalid() && !b.isRemoved()) {
                return view;
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo5443a(View view, int i, LayoutParams layoutParams, boolean z) {
        int i2;
        if (i < 0) {
            i2 = this.f3857a.mo5003a();
        } else {
            i2 = m5234f(i);
        }
        this.f3858b.mo5460a(i2, z);
        if (z) {
            m5235g(view);
        }
        this.f3857a.mo5007a(view, i2, layoutParams);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public int mo5446b() {
        return this.f3857a.mo5003a() - this.f3859c.size();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public int mo5449c() {
        return this.f3857a.mo5003a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public View mo5452d(int i) {
        return this.f3857a.mo5008b(i);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo5454e(int i) {
        int f = m5234f(i);
        this.f3858b.mo5463d(f);
        this.f3857a.mo5011c(f);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public int mo5447b(View view) {
        int a = this.f3857a.mo5004a(view);
        if (a != -1 && !this.f3858b.mo5462c(a)) {
            return a - this.f3858b.mo5464e(a);
        }
        return -1;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public boolean mo5451c(View view) {
        return this.f3859c.contains(view);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo5453d(View view) {
        int a = this.f3857a.mo5004a(view);
        if (a >= 0) {
            this.f3858b.mo5459a(a);
            m5235g(view);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("view is not a child, cannot hide ");
        sb.append(view);
        throw new IllegalArgumentException(sb.toString());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo5455e(View view) {
        int a = this.f3857a.mo5004a(view);
        if (a < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("view is not a child, cannot hide ");
            sb.append(view);
            throw new IllegalArgumentException(sb.toString());
        } else if (this.f3858b.mo5462c(a)) {
            this.f3858b.mo5461b(a);
            m5236h(view);
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("trying to unhide a view that was not hidden");
            sb2.append(view);
            throw new RuntimeException(sb2.toString());
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f3858b.toString());
        sb.append(", hidden list:");
        sb.append(this.f3859c.size());
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public boolean mo5456f(View view) {
        int a = this.f3857a.mo5004a(view);
        if (a == -1) {
            m5236h(view);
            return true;
        } else if (!this.f3858b.mo5462c(a)) {
            return false;
        } else {
            this.f3858b.mo5463d(a);
            m5236h(view);
            this.f3857a.mo5005a(a);
            return true;
        }
    }
}
