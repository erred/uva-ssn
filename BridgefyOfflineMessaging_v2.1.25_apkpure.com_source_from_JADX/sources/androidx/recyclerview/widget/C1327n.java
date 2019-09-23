package androidx.recyclerview.widget;

import androidx.core.p069f.C0926d.C0927a;
import androidx.core.p069f.C0926d.C0928b;
import androidx.p052b.C0712a;
import androidx.p052b.C0717d;
import androidx.recyclerview.widget.RecyclerView.C1248f.C1251c;
import androidx.recyclerview.widget.RecyclerView.C1277x;

/* renamed from: androidx.recyclerview.widget.n */
/* compiled from: ViewInfoStore */
class C1327n {

    /* renamed from: a */
    final C0712a<C1277x, C1328a> f3992a = new C0712a<>();

    /* renamed from: b */
    final C0717d<C1277x> f3993b = new C0717d<>();

    /* renamed from: androidx.recyclerview.widget.n$a */
    /* compiled from: ViewInfoStore */
    static class C1328a {

        /* renamed from: d */
        static C0927a<C1328a> f3994d = new C0928b(20);

        /* renamed from: a */
        int f3995a;

        /* renamed from: b */
        C1251c f3996b;

        /* renamed from: c */
        C1251c f3997c;

        private C1328a() {
        }

        /* renamed from: a */
        static C1328a m5463a() {
            C1328a aVar = (C1328a) f3994d.mo3647a();
            return aVar == null ? new C1328a() : aVar;
        }

        /* renamed from: a */
        static void m5464a(C1328a aVar) {
            aVar.f3995a = 0;
            aVar.f3996b = null;
            aVar.f3997c = null;
            f3994d.mo3648a(aVar);
        }

        /* renamed from: b */
        static void m5465b() {
            do {
            } while (f3994d.mo3647a() != null);
        }
    }

    /* renamed from: androidx.recyclerview.widget.n$b */
    /* compiled from: ViewInfoStore */
    interface C1329b {
        /* renamed from: a */
        void mo4999a(C1277x xVar);

        /* renamed from: a */
        void mo5000a(C1277x xVar, C1251c cVar, C1251c cVar2);

        /* renamed from: b */
        void mo5001b(C1277x xVar, C1251c cVar, C1251c cVar2);

        /* renamed from: c */
        void mo5002c(C1277x xVar, C1251c cVar, C1251c cVar2);
    }

    C1327n() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo5573a() {
        this.f3992a.clear();
        this.f3993b.mo2788c();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo5575a(C1277x xVar, C1251c cVar) {
        C1328a aVar = (C1328a) this.f3992a.get(xVar);
        if (aVar == null) {
            aVar = C1328a.m5463a();
            this.f3992a.put(xVar, aVar);
        }
        aVar.f3996b = cVar;
        aVar.f3995a |= 4;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo5577a(C1277x xVar) {
        C1328a aVar = (C1328a) this.f3992a.get(xVar);
        if (aVar == null || (aVar.f3995a & 1) == 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C1251c mo5578b(C1277x xVar) {
        return m5446a(xVar, 4);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public C1251c mo5581c(C1277x xVar) {
        return m5446a(xVar, 8);
    }

    /* renamed from: a */
    private C1251c m5446a(C1277x xVar, int i) {
        C1251c cVar;
        int a = this.f3992a.mo2873a((Object) xVar);
        if (a < 0) {
            return null;
        }
        C1328a aVar = (C1328a) this.f3992a.mo2880c(a);
        if (aVar == null || (aVar.f3995a & i) == 0) {
            return null;
        }
        aVar.f3995a &= ~i;
        if (i == 4) {
            cVar = aVar.f3996b;
        } else if (i == 8) {
            cVar = aVar.f3997c;
        } else {
            throw new IllegalArgumentException("Must provide flag PRE or POST");
        }
        if ((aVar.f3995a & 12) == 0) {
            this.f3992a.mo2884d(a);
            C1328a.m5464a(aVar);
        }
        return cVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo5574a(long j, C1277x xVar) {
        this.f3993b.mo2785b(j, xVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo5580b(C1277x xVar, C1251c cVar) {
        C1328a aVar = (C1328a) this.f3992a.get(xVar);
        if (aVar == null) {
            aVar = C1328a.m5463a();
            this.f3992a.put(xVar, aVar);
        }
        aVar.f3995a |= 2;
        aVar.f3996b = cVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public boolean mo5583d(C1277x xVar) {
        C1328a aVar = (C1328a) this.f3992a.get(xVar);
        return (aVar == null || (aVar.f3995a & 4) == 0) ? false : true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C1277x mo5572a(long j) {
        return (C1277x) this.f3993b.mo2779a(j);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo5582c(C1277x xVar, C1251c cVar) {
        C1328a aVar = (C1328a) this.f3992a.get(xVar);
        if (aVar == null) {
            aVar = C1328a.m5463a();
            this.f3992a.put(xVar, aVar);
        }
        aVar.f3997c = cVar;
        aVar.f3995a |= 8;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo5584e(C1277x xVar) {
        C1328a aVar = (C1328a) this.f3992a.get(xVar);
        if (aVar == null) {
            aVar = C1328a.m5463a();
            this.f3992a.put(xVar, aVar);
        }
        aVar.f3995a |= 1;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public void mo5585f(C1277x xVar) {
        C1328a aVar = (C1328a) this.f3992a.get(xVar);
        if (aVar != null) {
            aVar.f3995a &= -2;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo5576a(C1329b bVar) {
        for (int size = this.f3992a.size() - 1; size >= 0; size--) {
            C1277x xVar = (C1277x) this.f3992a.mo2879b(size);
            C1328a aVar = (C1328a) this.f3992a.mo2884d(size);
            if ((aVar.f3995a & 3) == 3) {
                bVar.mo4999a(xVar);
            } else if ((aVar.f3995a & 1) != 0) {
                if (aVar.f3996b == null) {
                    bVar.mo4999a(xVar);
                } else {
                    bVar.mo5000a(xVar, aVar.f3996b, aVar.f3997c);
                }
            } else if ((aVar.f3995a & 14) == 14) {
                bVar.mo5001b(xVar, aVar.f3996b, aVar.f3997c);
            } else if ((aVar.f3995a & 12) == 12) {
                bVar.mo5002c(xVar, aVar.f3996b, aVar.f3997c);
            } else if ((aVar.f3995a & 4) != 0) {
                bVar.mo5000a(xVar, aVar.f3996b, null);
            } else if ((aVar.f3995a & 8) != 0) {
                bVar.mo5001b(xVar, aVar.f3996b, aVar.f3997c);
            } else {
                int i = aVar.f3995a;
            }
            C1328a.m5464a(aVar);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public void mo5586g(C1277x xVar) {
        int b = this.f3993b.mo2782b() - 1;
        while (true) {
            if (b < 0) {
                break;
            } else if (xVar == this.f3993b.mo2787c(b)) {
                this.f3993b.mo2781a(b);
                break;
            } else {
                b--;
            }
        }
        C1328a aVar = (C1328a) this.f3992a.remove(xVar);
        if (aVar != null) {
            C1328a.m5464a(aVar);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo5579b() {
        C1328a.m5465b();
    }

    /* renamed from: h */
    public void mo5587h(C1277x xVar) {
        mo5585f(xVar);
    }
}
