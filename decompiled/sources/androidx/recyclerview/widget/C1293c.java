package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.core.p070g.C0962r;
import androidx.recyclerview.widget.RecyclerView.C1277x;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: androidx.recyclerview.widget.c */
/* compiled from: DefaultItemAnimator */
public class C1293c extends C1323l {

    /* renamed from: i */
    private static TimeInterpolator f3862i;

    /* renamed from: a */
    ArrayList<ArrayList<C1277x>> f3863a = new ArrayList<>();

    /* renamed from: b */
    ArrayList<ArrayList<C1303b>> f3864b = new ArrayList<>();

    /* renamed from: c */
    ArrayList<ArrayList<C1302a>> f3865c = new ArrayList<>();

    /* renamed from: d */
    ArrayList<C1277x> f3866d = new ArrayList<>();

    /* renamed from: e */
    ArrayList<C1277x> f3867e = new ArrayList<>();

    /* renamed from: f */
    ArrayList<C1277x> f3868f = new ArrayList<>();

    /* renamed from: g */
    ArrayList<C1277x> f3869g = new ArrayList<>();

    /* renamed from: j */
    private ArrayList<C1277x> f3870j = new ArrayList<>();

    /* renamed from: k */
    private ArrayList<C1277x> f3871k = new ArrayList<>();

    /* renamed from: l */
    private ArrayList<C1303b> f3872l = new ArrayList<>();

    /* renamed from: m */
    private ArrayList<C1302a> f3873m = new ArrayList<>();

    /* renamed from: androidx.recyclerview.widget.c$a */
    /* compiled from: DefaultItemAnimator */
    private static class C1302a {

        /* renamed from: a */
        public C1277x f3902a;

        /* renamed from: b */
        public C1277x f3903b;

        /* renamed from: c */
        public int f3904c;

        /* renamed from: d */
        public int f3905d;

        /* renamed from: e */
        public int f3906e;

        /* renamed from: f */
        public int f3907f;

        private C1302a(C1277x xVar, C1277x xVar2) {
            this.f3902a = xVar;
            this.f3903b = xVar2;
        }

        C1302a(C1277x xVar, C1277x xVar2, int i, int i2, int i3, int i4) {
            this(xVar, xVar2);
            this.f3904c = i;
            this.f3905d = i2;
            this.f3906e = i3;
            this.f3907f = i4;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ChangeInfo{oldHolder=");
            sb.append(this.f3902a);
            sb.append(", newHolder=");
            sb.append(this.f3903b);
            sb.append(", fromX=");
            sb.append(this.f3904c);
            sb.append(", fromY=");
            sb.append(this.f3905d);
            sb.append(", toX=");
            sb.append(this.f3906e);
            sb.append(", toY=");
            sb.append(this.f3907f);
            sb.append('}');
            return sb.toString();
        }
    }

    /* renamed from: androidx.recyclerview.widget.c$b */
    /* compiled from: DefaultItemAnimator */
    private static class C1303b {

        /* renamed from: a */
        public C1277x f3908a;

        /* renamed from: b */
        public int f3909b;

        /* renamed from: c */
        public int f3910c;

        /* renamed from: d */
        public int f3911d;

        /* renamed from: e */
        public int f3912e;

        C1303b(C1277x xVar, int i, int i2, int i3, int i4) {
            this.f3908a = xVar;
            this.f3909b = i;
            this.f3910c = i2;
            this.f3911d = i3;
            this.f3912e = i4;
        }
    }

    /* renamed from: a */
    public void mo5069a() {
        boolean z = !this.f3870j.isEmpty();
        boolean z2 = !this.f3872l.isEmpty();
        boolean z3 = !this.f3873m.isEmpty();
        boolean z4 = !this.f3871k.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator it = this.f3870j.iterator();
            while (it.hasNext()) {
                m5276u((C1277x) it.next());
            }
            this.f3870j.clear();
            if (z2) {
                final ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.f3872l);
                this.f3864b.add(arrayList);
                this.f3872l.clear();
                C12941 r6 = new Runnable() {
                    public void run() {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            C1303b bVar = (C1303b) it.next();
                            C1293c.this.mo5471b(bVar.f3908a, bVar.f3909b, bVar.f3910c, bVar.f3911d, bVar.f3912e);
                        }
                        arrayList.clear();
                        C1293c.this.f3864b.remove(arrayList);
                    }
                };
                if (z) {
                    C0962r.m3563a(((C1303b) arrayList.get(0)).f3908a.itemView, (Runnable) r6, mo5082g());
                } else {
                    r6.run();
                }
            }
            if (z3) {
                final ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.f3873m);
                this.f3865c.add(arrayList2);
                this.f3873m.clear();
                C12952 r62 = new Runnable() {
                    public void run() {
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            C1293c.this.mo5466a((C1302a) it.next());
                        }
                        arrayList2.clear();
                        C1293c.this.f3865c.remove(arrayList2);
                    }
                };
                if (z) {
                    C0962r.m3563a(((C1302a) arrayList2.get(0)).f3902a.itemView, (Runnable) r62, mo5082g());
                } else {
                    r62.run();
                }
            }
            if (z4) {
                final ArrayList arrayList3 = new ArrayList();
                arrayList3.addAll(this.f3871k);
                this.f3863a.add(arrayList3);
                this.f3871k.clear();
                C12963 r5 = new Runnable() {
                    public void run() {
                        Iterator it = arrayList3.iterator();
                        while (it.hasNext()) {
                            C1293c.this.mo5474c((C1277x) it.next());
                        }
                        arrayList3.clear();
                        C1293c.this.f3863a.remove(arrayList3);
                    }
                };
                if (z || z2 || z3) {
                    long j = 0;
                    long g = z ? mo5082g() : 0;
                    long e = z2 ? mo5079e() : 0;
                    if (z3) {
                        j = mo5084h();
                    }
                    C0962r.m3563a(((C1277x) arrayList3.get(0)).itemView, (Runnable) r5, g + Math.max(e, j));
                } else {
                    r5.run();
                }
            }
        }
    }

    /* renamed from: a */
    public boolean mo5468a(C1277x xVar) {
        m5277v(xVar);
        this.f3870j.add(xVar);
        return true;
    }

    /* renamed from: u */
    private void m5276u(final C1277x xVar) {
        final View view = xVar.itemView;
        final ViewPropertyAnimator animate = view.animate();
        this.f3868f.add(xVar);
        animate.setDuration(mo5082g()).alpha(BitmapDescriptorFactory.HUE_RED).setListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                C1293c.this.mo5556l(xVar);
            }

            public void onAnimationEnd(Animator animator) {
                animate.setListener(null);
                view.setAlpha(1.0f);
                C1293c.this.mo5553i(xVar);
                C1293c.this.f3868f.remove(xVar);
                C1293c.this.mo5473c();
            }
        }).start();
    }

    /* renamed from: b */
    public boolean mo5472b(C1277x xVar) {
        m5277v(xVar);
        xVar.itemView.setAlpha(BitmapDescriptorFactory.HUE_RED);
        this.f3871k.add(xVar);
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo5474c(final C1277x xVar) {
        final View view = xVar.itemView;
        final ViewPropertyAnimator animate = view.animate();
        this.f3866d.add(xVar);
        animate.alpha(1.0f).setDuration(mo5080f()).setListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                C1293c.this.mo5558n(xVar);
            }

            public void onAnimationCancel(Animator animator) {
                view.setAlpha(1.0f);
            }

            public void onAnimationEnd(Animator animator) {
                animate.setListener(null);
                C1293c.this.mo5555k(xVar);
                C1293c.this.f3866d.remove(xVar);
                C1293c.this.mo5473c();
            }
        }).start();
    }

    /* renamed from: a */
    public boolean mo5469a(C1277x xVar, int i, int i2, int i3, int i4) {
        View view = xVar.itemView;
        int translationX = i + ((int) xVar.itemView.getTranslationX());
        int translationY = i2 + ((int) xVar.itemView.getTranslationY());
        m5277v(xVar);
        int i5 = i3 - translationX;
        int i6 = i4 - translationY;
        if (i5 == 0 && i6 == 0) {
            mo5554j(xVar);
            return false;
        }
        if (i5 != 0) {
            view.setTranslationX((float) (-i5));
        }
        if (i6 != 0) {
            view.setTranslationY((float) (-i6));
        }
        ArrayList<C1303b> arrayList = this.f3872l;
        C1303b bVar = new C1303b(xVar, translationX, translationY, i3, i4);
        arrayList.add(bVar);
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo5471b(C1277x xVar, int i, int i2, int i3, int i4) {
        final View view = xVar.itemView;
        final int i5 = i3 - i;
        final int i6 = i4 - i2;
        if (i5 != 0) {
            view.animate().translationX(BitmapDescriptorFactory.HUE_RED);
        }
        if (i6 != 0) {
            view.animate().translationY(BitmapDescriptorFactory.HUE_RED);
        }
        final ViewPropertyAnimator animate = view.animate();
        this.f3867e.add(xVar);
        ViewPropertyAnimator duration = animate.setDuration(mo5079e());
        final C1277x xVar2 = xVar;
        C12996 r0 = new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                C1293c.this.mo5557m(xVar2);
            }

            public void onAnimationCancel(Animator animator) {
                if (i5 != 0) {
                    view.setTranslationX(BitmapDescriptorFactory.HUE_RED);
                }
                if (i6 != 0) {
                    view.setTranslationY(BitmapDescriptorFactory.HUE_RED);
                }
            }

            public void onAnimationEnd(Animator animator) {
                animate.setListener(null);
                C1293c.this.mo5554j(xVar2);
                C1293c.this.f3867e.remove(xVar2);
                C1293c.this.mo5473c();
            }
        };
        duration.setListener(r0).start();
    }

    /* renamed from: a */
    public boolean mo5470a(C1277x xVar, C1277x xVar2, int i, int i2, int i3, int i4) {
        if (xVar == xVar2) {
            return mo5469a(xVar, i, i2, i3, i4);
        }
        float translationX = xVar.itemView.getTranslationX();
        float translationY = xVar.itemView.getTranslationY();
        float alpha = xVar.itemView.getAlpha();
        m5277v(xVar);
        int i5 = (int) (((float) (i3 - i)) - translationX);
        int i6 = (int) (((float) (i4 - i2)) - translationY);
        xVar.itemView.setTranslationX(translationX);
        xVar.itemView.setTranslationY(translationY);
        xVar.itemView.setAlpha(alpha);
        if (xVar2 != null) {
            m5277v(xVar2);
            xVar2.itemView.setTranslationX((float) (-i5));
            xVar2.itemView.setTranslationY((float) (-i6));
            xVar2.itemView.setAlpha(BitmapDescriptorFactory.HUE_RED);
        }
        ArrayList<C1302a> arrayList = this.f3873m;
        C1302a aVar = new C1302a(xVar, xVar2, i, i2, i3, i4);
        arrayList.add(aVar);
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo5466a(final C1302a aVar) {
        final View view;
        C1277x xVar = aVar.f3902a;
        final View view2 = null;
        if (xVar == null) {
            view = null;
        } else {
            view = xVar.itemView;
        }
        C1277x xVar2 = aVar.f3903b;
        if (xVar2 != null) {
            view2 = xVar2.itemView;
        }
        if (view != null) {
            final ViewPropertyAnimator duration = view.animate().setDuration(mo5084h());
            this.f3869g.add(aVar.f3902a);
            duration.translationX((float) (aVar.f3906e - aVar.f3904c));
            duration.translationY((float) (aVar.f3907f - aVar.f3905d));
            duration.alpha(BitmapDescriptorFactory.HUE_RED).setListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    C1293c.this.mo5550b(aVar.f3902a, true);
                }

                public void onAnimationEnd(Animator animator) {
                    duration.setListener(null);
                    view.setAlpha(1.0f);
                    view.setTranslationX(BitmapDescriptorFactory.HUE_RED);
                    view.setTranslationY(BitmapDescriptorFactory.HUE_RED);
                    C1293c.this.mo5548a(aVar.f3902a, true);
                    C1293c.this.f3869g.remove(aVar.f3902a);
                    C1293c.this.mo5473c();
                }
            }).start();
        }
        if (view2 != null) {
            final ViewPropertyAnimator animate = view2.animate();
            this.f3869g.add(aVar.f3903b);
            animate.translationX(BitmapDescriptorFactory.HUE_RED).translationY(BitmapDescriptorFactory.HUE_RED).setDuration(mo5084h()).alpha(1.0f).setListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    C1293c.this.mo5550b(aVar.f3903b, false);
                }

                public void onAnimationEnd(Animator animator) {
                    animate.setListener(null);
                    view2.setAlpha(1.0f);
                    view2.setTranslationX(BitmapDescriptorFactory.HUE_RED);
                    view2.setTranslationY(BitmapDescriptorFactory.HUE_RED);
                    C1293c.this.mo5548a(aVar.f3903b, false);
                    C1293c.this.f3869g.remove(aVar.f3903b);
                    C1293c.this.mo5473c();
                }
            }).start();
        }
    }

    /* renamed from: a */
    private void m5273a(List<C1302a> list, C1277x xVar) {
        for (int size = list.size() - 1; size >= 0; size--) {
            C1302a aVar = (C1302a) list.get(size);
            if (m5274a(aVar, xVar) && aVar.f3902a == null && aVar.f3903b == null) {
                list.remove(aVar);
            }
        }
    }

    /* renamed from: b */
    private void m5275b(C1302a aVar) {
        if (aVar.f3902a != null) {
            m5274a(aVar, aVar.f3902a);
        }
        if (aVar.f3903b != null) {
            m5274a(aVar, aVar.f3903b);
        }
    }

    /* renamed from: a */
    private boolean m5274a(C1302a aVar, C1277x xVar) {
        boolean z = false;
        if (aVar.f3903b == xVar) {
            aVar.f3903b = null;
        } else if (aVar.f3902a != xVar) {
            return false;
        } else {
            aVar.f3902a = null;
            z = true;
        }
        xVar.itemView.setAlpha(1.0f);
        xVar.itemView.setTranslationX(BitmapDescriptorFactory.HUE_RED);
        xVar.itemView.setTranslationY(BitmapDescriptorFactory.HUE_RED);
        mo5548a(xVar, z);
        return true;
    }

    /* renamed from: d */
    public void mo5078d(C1277x xVar) {
        View view = xVar.itemView;
        view.animate().cancel();
        int size = this.f3872l.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (((C1303b) this.f3872l.get(size)).f3908a == xVar) {
                view.setTranslationY(BitmapDescriptorFactory.HUE_RED);
                view.setTranslationX(BitmapDescriptorFactory.HUE_RED);
                mo5554j(xVar);
                this.f3872l.remove(size);
            }
        }
        m5273a((List<C1302a>) this.f3873m, xVar);
        if (this.f3870j.remove(xVar)) {
            view.setAlpha(1.0f);
            mo5553i(xVar);
        }
        if (this.f3871k.remove(xVar)) {
            view.setAlpha(1.0f);
            mo5555k(xVar);
        }
        for (int size2 = this.f3865c.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = (ArrayList) this.f3865c.get(size2);
            m5273a((List<C1302a>) arrayList, xVar);
            if (arrayList.isEmpty()) {
                this.f3865c.remove(size2);
            }
        }
        for (int size3 = this.f3864b.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList2 = (ArrayList) this.f3864b.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                } else if (((C1303b) arrayList2.get(size4)).f3908a == xVar) {
                    view.setTranslationY(BitmapDescriptorFactory.HUE_RED);
                    view.setTranslationX(BitmapDescriptorFactory.HUE_RED);
                    mo5554j(xVar);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.f3864b.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.f3863a.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList3 = (ArrayList) this.f3863a.get(size5);
            if (arrayList3.remove(xVar)) {
                view.setAlpha(1.0f);
                mo5555k(xVar);
                if (arrayList3.isEmpty()) {
                    this.f3863a.remove(size5);
                }
            }
        }
        this.f3868f.remove(xVar);
        this.f3866d.remove(xVar);
        this.f3869g.remove(xVar);
        this.f3867e.remove(xVar);
        mo5473c();
    }

    /* renamed from: v */
    private void m5277v(C1277x xVar) {
        if (f3862i == null) {
            f3862i = new ValueAnimator().getInterpolator();
        }
        xVar.itemView.animate().setInterpolator(f3862i);
        mo5078d(xVar);
    }

    /* renamed from: b */
    public boolean mo5074b() {
        return !this.f3871k.isEmpty() || !this.f3873m.isEmpty() || !this.f3872l.isEmpty() || !this.f3870j.isEmpty() || !this.f3867e.isEmpty() || !this.f3868f.isEmpty() || !this.f3866d.isEmpty() || !this.f3869g.isEmpty() || !this.f3864b.isEmpty() || !this.f3863a.isEmpty() || !this.f3865c.isEmpty();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo5473c() {
        if (!mo5074b()) {
            mo5086i();
        }
    }

    /* renamed from: d */
    public void mo5077d() {
        int size = this.f3872l.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            C1303b bVar = (C1303b) this.f3872l.get(size);
            View view = bVar.f3908a.itemView;
            view.setTranslationY(BitmapDescriptorFactory.HUE_RED);
            view.setTranslationX(BitmapDescriptorFactory.HUE_RED);
            mo5554j(bVar.f3908a);
            this.f3872l.remove(size);
        }
        for (int size2 = this.f3870j.size() - 1; size2 >= 0; size2--) {
            mo5553i((C1277x) this.f3870j.get(size2));
            this.f3870j.remove(size2);
        }
        int size3 = this.f3871k.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            C1277x xVar = (C1277x) this.f3871k.get(size3);
            xVar.itemView.setAlpha(1.0f);
            mo5555k(xVar);
            this.f3871k.remove(size3);
        }
        for (int size4 = this.f3873m.size() - 1; size4 >= 0; size4--) {
            m5275b((C1302a) this.f3873m.get(size4));
        }
        this.f3873m.clear();
        if (mo5074b()) {
            for (int size5 = this.f3864b.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList = (ArrayList) this.f3864b.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    C1303b bVar2 = (C1303b) arrayList.get(size6);
                    View view2 = bVar2.f3908a.itemView;
                    view2.setTranslationY(BitmapDescriptorFactory.HUE_RED);
                    view2.setTranslationX(BitmapDescriptorFactory.HUE_RED);
                    mo5554j(bVar2.f3908a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.f3864b.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.f3863a.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList2 = (ArrayList) this.f3863a.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    C1277x xVar2 = (C1277x) arrayList2.get(size8);
                    xVar2.itemView.setAlpha(1.0f);
                    mo5555k(xVar2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.f3863a.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.f3865c.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList3 = (ArrayList) this.f3865c.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    m5275b((C1302a) arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.f3865c.remove(arrayList3);
                    }
                }
            }
            mo5467a((List<C1277x>) this.f3868f);
            mo5467a((List<C1277x>) this.f3867e);
            mo5467a((List<C1277x>) this.f3866d);
            mo5467a((List<C1277x>) this.f3869g);
            mo5086i();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo5467a(List<C1277x> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ((C1277x) list.get(size)).itemView.animate().cancel();
        }
    }

    /* renamed from: a */
    public boolean mo5073a(C1277x xVar, List<Object> list) {
        return !list.isEmpty() || super.mo5073a(xVar, list);
    }
}
