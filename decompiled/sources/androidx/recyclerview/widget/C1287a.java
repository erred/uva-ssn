package androidx.recyclerview.widget;

import androidx.core.p069f.C0926d.C0927a;
import androidx.core.p069f.C0926d.C0928b;
import androidx.recyclerview.widget.RecyclerView.C1277x;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import java.util.ArrayList;
import java.util.List;

/* renamed from: androidx.recyclerview.widget.a */
/* compiled from: AdapterHelper */
class C1287a implements C1316a {

    /* renamed from: a */
    final ArrayList<C1289b> f3845a;

    /* renamed from: b */
    final ArrayList<C1289b> f3846b;

    /* renamed from: c */
    final C1288a f3847c;

    /* renamed from: d */
    Runnable f3848d;

    /* renamed from: e */
    final boolean f3849e;

    /* renamed from: f */
    final C1315h f3850f;

    /* renamed from: g */
    private C0927a<C1289b> f3851g;

    /* renamed from: h */
    private int f3852h;

    /* renamed from: androidx.recyclerview.widget.a$a */
    /* compiled from: AdapterHelper */
    interface C1288a {
        /* renamed from: a */
        C1277x mo5014a(int i);

        /* renamed from: a */
        void mo5015a(int i, int i2);

        /* renamed from: a */
        void mo5016a(int i, int i2, Object obj);

        /* renamed from: a */
        void mo5017a(C1289b bVar);

        /* renamed from: b */
        void mo5018b(int i, int i2);

        /* renamed from: b */
        void mo5019b(C1289b bVar);

        /* renamed from: c */
        void mo5020c(int i, int i2);

        /* renamed from: d */
        void mo5022d(int i, int i2);
    }

    /* renamed from: androidx.recyclerview.widget.a$b */
    /* compiled from: AdapterHelper */
    static class C1289b {

        /* renamed from: a */
        int f3853a;

        /* renamed from: b */
        int f3854b;

        /* renamed from: c */
        Object f3855c;

        /* renamed from: d */
        int f3856d;

        C1289b(int i, int i2, int i3, Object obj) {
            this.f3853a = i;
            this.f3854b = i2;
            this.f3856d = i3;
            this.f3855c = obj;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public String mo5436a() {
            int i = this.f3853a;
            if (i == 4) {
                return "up";
            }
            if (i == 8) {
                return "mv";
            }
            switch (i) {
                case 1:
                    return ProductAction.ACTION_ADD;
                case 2:
                    return "rm";
                default:
                    return "??";
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append("[");
            sb.append(mo5436a());
            sb.append(",s:");
            sb.append(this.f3854b);
            sb.append("c:");
            sb.append(this.f3856d);
            sb.append(",p:");
            sb.append(this.f3855c);
            sb.append("]");
            return sb.toString();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C1289b bVar = (C1289b) obj;
            if (this.f3853a != bVar.f3853a) {
                return false;
            }
            if (this.f3853a == 8 && Math.abs(this.f3856d - this.f3854b) == 1 && this.f3856d == bVar.f3854b && this.f3854b == bVar.f3856d) {
                return true;
            }
            if (this.f3856d != bVar.f3856d || this.f3854b != bVar.f3854b) {
                return false;
            }
            if (this.f3855c != null) {
                if (!this.f3855c.equals(bVar.f3855c)) {
                    return false;
                }
            } else if (bVar.f3855c != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f3853a * 31) + this.f3854b) * 31) + this.f3856d;
        }
    }

    C1287a(C1288a aVar) {
        this(aVar, false);
    }

    C1287a(C1288a aVar, boolean z) {
        this.f3851g = new C0928b(30);
        this.f3845a = new ArrayList<>();
        this.f3846b = new ArrayList<>();
        this.f3852h = 0;
        this.f3847c = aVar;
        this.f3849e = z;
        this.f3850f = new C1315h(this);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo5420a() {
        mo5423a((List<C1289b>) this.f3845a);
        mo5423a((List<C1289b>) this.f3846b);
        this.f3852h = 0;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo5428b() {
        this.f3850f.mo5527a(this.f3845a);
        int size = this.f3845a.size();
        for (int i = 0; i < size; i++) {
            C1289b bVar = (C1289b) this.f3845a.get(i);
            int i2 = bVar.f3853a;
            if (i2 == 4) {
                m5202d(bVar);
            } else if (i2 != 8) {
                switch (i2) {
                    case 1:
                        m5205f(bVar);
                        break;
                    case 2:
                        m5200c(bVar);
                        break;
                }
            } else {
                m5199b(bVar);
            }
            if (this.f3848d != null) {
                this.f3848d.run();
            }
        }
        this.f3845a.clear();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo5431c() {
        int size = this.f3846b.size();
        for (int i = 0; i < size; i++) {
            this.f3847c.mo5019b((C1289b) this.f3846b.get(i));
        }
        mo5423a((List<C1289b>) this.f3846b);
        this.f3852h = 0;
    }

    /* renamed from: b */
    private void m5199b(C1289b bVar) {
        m5206g(bVar);
    }

    /* renamed from: c */
    private void m5200c(C1289b bVar) {
        char c;
        boolean z;
        boolean z2;
        int i = bVar.f3854b;
        int i2 = bVar.f3854b + bVar.f3856d;
        int i3 = bVar.f3854b;
        int i4 = 0;
        char c2 = 65535;
        while (i3 < i2) {
            if (this.f3847c.mo5014a(i3) != null || m5203d(i3)) {
                if (c2 == 0) {
                    m5204e(mo5419a(2, i, i4, null));
                    z2 = true;
                } else {
                    z2 = false;
                }
                c = 1;
            } else {
                if (c2 == 1) {
                    m5206g(mo5419a(2, i, i4, null));
                    z = true;
                } else {
                    z = false;
                }
                c = 0;
            }
            if (z) {
                i3 -= i4;
                i2 -= i4;
                i4 = 1;
            } else {
                i4++;
            }
            i3++;
            c2 = c;
        }
        if (i4 != bVar.f3856d) {
            mo5421a(bVar);
            bVar = mo5419a(2, i, i4, null);
        }
        if (c2 == 0) {
            m5204e(bVar);
        } else {
            m5206g(bVar);
        }
    }

    /* renamed from: d */
    private void m5202d(C1289b bVar) {
        int i = bVar.f3854b;
        int i2 = bVar.f3854b + bVar.f3856d;
        char c = 65535;
        int i3 = i;
        int i4 = 0;
        for (int i5 = bVar.f3854b; i5 < i2; i5++) {
            if (this.f3847c.mo5014a(i5) != null || m5203d(i5)) {
                if (c == 0) {
                    m5204e(mo5419a(4, i3, i4, bVar.f3855c));
                    i3 = i5;
                    i4 = 0;
                }
                c = 1;
            } else {
                if (c == 1) {
                    m5206g(mo5419a(4, i3, i4, bVar.f3855c));
                    i3 = i5;
                    i4 = 0;
                }
                c = 0;
            }
            i4++;
        }
        if (i4 != bVar.f3856d) {
            Object obj = bVar.f3855c;
            mo5421a(bVar);
            bVar = mo5419a(4, i3, i4, obj);
        }
        if (c == 0) {
            m5204e(bVar);
        } else {
            m5206g(bVar);
        }
    }

    /* renamed from: e */
    private void m5204e(C1289b bVar) {
        int i;
        if (bVar.f3853a == 1 || bVar.f3853a == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int d = m5201d(bVar.f3854b, bVar.f3853a);
        int i2 = bVar.f3854b;
        int i3 = bVar.f3853a;
        if (i3 == 2) {
            i = 0;
        } else if (i3 == 4) {
            i = 1;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("op should be remove or update.");
            sb.append(bVar);
            throw new IllegalArgumentException(sb.toString());
        }
        int i4 = d;
        int i5 = i2;
        int i6 = 1;
        for (int i7 = 1; i7 < bVar.f3856d; i7++) {
            int d2 = m5201d(bVar.f3854b + (i * i7), bVar.f3853a);
            int i8 = bVar.f3853a;
            if (i8 == 2 ? d2 == i4 : i8 == 4 && d2 == i4 + 1) {
                i6++;
            } else {
                C1289b a = mo5419a(bVar.f3853a, i4, i6, bVar.f3855c);
                mo5422a(a, i5);
                mo5421a(a);
                if (bVar.f3853a == 4) {
                    i5 += i6;
                }
                i4 = d2;
                i6 = 1;
            }
        }
        Object obj = bVar.f3855c;
        mo5421a(bVar);
        if (i6 > 0) {
            C1289b a2 = mo5419a(bVar.f3853a, i4, i6, obj);
            mo5422a(a2, i5);
            mo5421a(a2);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo5422a(C1289b bVar, int i) {
        this.f3847c.mo5017a(bVar);
        int i2 = bVar.f3853a;
        if (i2 == 2) {
            this.f3847c.mo5015a(i, bVar.f3856d);
        } else if (i2 == 4) {
            this.f3847c.mo5016a(i, bVar.f3856d, bVar.f3855c);
        } else {
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    /* renamed from: d */
    private int m5201d(int i, int i2) {
        int i3;
        int i4;
        for (int size = this.f3846b.size() - 1; size >= 0; size--) {
            C1289b bVar = (C1289b) this.f3846b.get(size);
            if (bVar.f3853a == 8) {
                if (bVar.f3854b < bVar.f3856d) {
                    i4 = bVar.f3854b;
                    i3 = bVar.f3856d;
                } else {
                    i4 = bVar.f3856d;
                    i3 = bVar.f3854b;
                }
                if (i < i4 || i > i3) {
                    if (i < bVar.f3854b) {
                        if (i2 == 1) {
                            bVar.f3854b++;
                            bVar.f3856d++;
                        } else if (i2 == 2) {
                            bVar.f3854b--;
                            bVar.f3856d--;
                        }
                    }
                } else if (i4 == bVar.f3854b) {
                    if (i2 == 1) {
                        bVar.f3856d++;
                    } else if (i2 == 2) {
                        bVar.f3856d--;
                    }
                    i++;
                } else {
                    if (i2 == 1) {
                        bVar.f3854b++;
                    } else if (i2 == 2) {
                        bVar.f3854b--;
                    }
                    i--;
                }
            } else if (bVar.f3854b <= i) {
                if (bVar.f3853a == 1) {
                    i -= bVar.f3856d;
                } else if (bVar.f3853a == 2) {
                    i += bVar.f3856d;
                }
            } else if (i2 == 1) {
                bVar.f3854b++;
            } else if (i2 == 2) {
                bVar.f3854b--;
            }
        }
        for (int size2 = this.f3846b.size() - 1; size2 >= 0; size2--) {
            C1289b bVar2 = (C1289b) this.f3846b.get(size2);
            if (bVar2.f3853a == 8) {
                if (bVar2.f3856d == bVar2.f3854b || bVar2.f3856d < 0) {
                    this.f3846b.remove(size2);
                    mo5421a(bVar2);
                }
            } else if (bVar2.f3856d <= 0) {
                this.f3846b.remove(size2);
                mo5421a(bVar2);
            }
        }
        return i;
    }

    /* renamed from: d */
    private boolean m5203d(int i) {
        int size = this.f3846b.size();
        for (int i2 = 0; i2 < size; i2++) {
            C1289b bVar = (C1289b) this.f3846b.get(i2);
            if (bVar.f3853a == 8) {
                if (mo5418a(bVar.f3856d, i2 + 1) == i) {
                    return true;
                }
            } else if (bVar.f3853a == 1) {
                int i3 = bVar.f3854b + bVar.f3856d;
                for (int i4 = bVar.f3854b; i4 < i3; i4++) {
                    if (mo5418a(i4, i2 + 1) == i) {
                        return true;
                    }
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    /* renamed from: f */
    private void m5205f(C1289b bVar) {
        m5206g(bVar);
    }

    /* renamed from: g */
    private void m5206g(C1289b bVar) {
        this.f3846b.add(bVar);
        int i = bVar.f3853a;
        if (i == 4) {
            this.f3847c.mo5016a(bVar.f3854b, bVar.f3856d, bVar.f3855c);
        } else if (i != 8) {
            switch (i) {
                case 1:
                    this.f3847c.mo5020c(bVar.f3854b, bVar.f3856d);
                    return;
                case 2:
                    this.f3847c.mo5018b(bVar.f3854b, bVar.f3856d);
                    return;
                default:
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unknown update op type for ");
                    sb.append(bVar);
                    throw new IllegalArgumentException(sb.toString());
            }
        } else {
            this.f3847c.mo5022d(bVar.f3854b, bVar.f3856d);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public boolean mo5433d() {
        return this.f3845a.size() > 0;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo5424a(int i) {
        return (i & this.f3852h) != 0;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public int mo5427b(int i) {
        return mo5418a(i, 0);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int mo5418a(int i, int i2) {
        int size = this.f3846b.size();
        while (i2 < size) {
            C1289b bVar = (C1289b) this.f3846b.get(i2);
            if (bVar.f3853a == 8) {
                if (bVar.f3854b == i) {
                    i = bVar.f3856d;
                } else {
                    if (bVar.f3854b < i) {
                        i--;
                    }
                    if (bVar.f3856d <= i) {
                        i++;
                    }
                }
            } else if (bVar.f3854b > i) {
                continue;
            } else if (bVar.f3853a == 2) {
                if (i < bVar.f3854b + bVar.f3856d) {
                    return -1;
                }
                i -= bVar.f3856d;
            } else if (bVar.f3853a == 1) {
                i += bVar.f3856d;
            }
            i2++;
        }
        return i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo5426a(int i, int i2, Object obj) {
        boolean z = false;
        if (i2 < 1) {
            return false;
        }
        this.f3845a.add(mo5419a(4, i, i2, obj));
        this.f3852h |= 4;
        if (this.f3845a.size() == 1) {
            z = true;
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo5429b(int i, int i2) {
        boolean z = false;
        if (i2 < 1) {
            return false;
        }
        this.f3845a.add(mo5419a(1, i, i2, null));
        this.f3852h |= 1;
        if (this.f3845a.size() == 1) {
            z = true;
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public boolean mo5432c(int i, int i2) {
        boolean z = false;
        if (i2 < 1) {
            return false;
        }
        this.f3845a.add(mo5419a(2, i, i2, null));
        this.f3852h |= 2;
        if (this.f3845a.size() == 1) {
            z = true;
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo5425a(int i, int i2, int i3) {
        boolean z = false;
        if (i == i2) {
            return false;
        }
        if (i3 == 1) {
            this.f3845a.add(mo5419a(8, i, i2, null));
            this.f3852h |= 8;
            if (this.f3845a.size() == 1) {
                z = true;
            }
            return z;
        }
        throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo5434e() {
        mo5431c();
        int size = this.f3845a.size();
        for (int i = 0; i < size; i++) {
            C1289b bVar = (C1289b) this.f3845a.get(i);
            int i2 = bVar.f3853a;
            if (i2 == 4) {
                this.f3847c.mo5019b(bVar);
                this.f3847c.mo5016a(bVar.f3854b, bVar.f3856d, bVar.f3855c);
            } else if (i2 != 8) {
                switch (i2) {
                    case 1:
                        this.f3847c.mo5019b(bVar);
                        this.f3847c.mo5020c(bVar.f3854b, bVar.f3856d);
                        break;
                    case 2:
                        this.f3847c.mo5019b(bVar);
                        this.f3847c.mo5015a(bVar.f3854b, bVar.f3856d);
                        break;
                }
            } else {
                this.f3847c.mo5019b(bVar);
                this.f3847c.mo5022d(bVar.f3854b, bVar.f3856d);
            }
            if (this.f3848d != null) {
                this.f3848d.run();
            }
        }
        mo5423a((List<C1289b>) this.f3845a);
        this.f3852h = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0047, code lost:
        continue;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int mo5430c(int r6) {
        /*
            r5 = this;
            java.util.ArrayList<androidx.recyclerview.widget.a$b> r0 = r5.f3845a
            int r0 = r0.size()
            r1 = 0
        L_0x0007:
            if (r1 >= r0) goto L_0x004a
            java.util.ArrayList<androidx.recyclerview.widget.a$b> r2 = r5.f3845a
            java.lang.Object r2 = r2.get(r1)
            androidx.recyclerview.widget.a$b r2 = (androidx.recyclerview.widget.C1287a.C1289b) r2
            int r3 = r2.f3853a
            r4 = 8
            if (r3 == r4) goto L_0x0034
            switch(r3) {
                case 1: goto L_0x002c;
                case 2: goto L_0x001b;
                default: goto L_0x001a;
            }
        L_0x001a:
            goto L_0x0047
        L_0x001b:
            int r3 = r2.f3854b
            if (r3 > r6) goto L_0x0047
            int r3 = r2.f3854b
            int r4 = r2.f3856d
            int r3 = r3 + r4
            if (r3 <= r6) goto L_0x0028
            r6 = -1
            return r6
        L_0x0028:
            int r2 = r2.f3856d
            int r6 = r6 - r2
            goto L_0x0047
        L_0x002c:
            int r3 = r2.f3854b
            if (r3 > r6) goto L_0x0047
            int r2 = r2.f3856d
            int r6 = r6 + r2
            goto L_0x0047
        L_0x0034:
            int r3 = r2.f3854b
            if (r3 != r6) goto L_0x003b
            int r6 = r2.f3856d
            goto L_0x0047
        L_0x003b:
            int r3 = r2.f3854b
            if (r3 >= r6) goto L_0x0041
            int r6 = r6 + -1
        L_0x0041:
            int r2 = r2.f3856d
            if (r2 > r6) goto L_0x0047
            int r6 = r6 + 1
        L_0x0047:
            int r1 = r1 + 1
            goto L_0x0007
        L_0x004a:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.C1287a.mo5430c(int):int");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public boolean mo5435f() {
        return !this.f3846b.isEmpty() && !this.f3845a.isEmpty();
    }

    /* renamed from: a */
    public C1289b mo5419a(int i, int i2, int i3, Object obj) {
        C1289b bVar = (C1289b) this.f3851g.mo3647a();
        if (bVar == null) {
            return new C1289b(i, i2, i3, obj);
        }
        bVar.f3853a = i;
        bVar.f3854b = i2;
        bVar.f3856d = i3;
        bVar.f3855c = obj;
        return bVar;
    }

    /* renamed from: a */
    public void mo5421a(C1289b bVar) {
        if (!this.f3849e) {
            bVar.f3855c = null;
            this.f3851g.mo3648a(bVar);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo5423a(List<C1289b> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            mo5421a((C1289b) list.get(i));
        }
        list.clear();
    }
}
