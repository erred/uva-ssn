package androidx.transition;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import androidx.core.p070g.C0962r;
import androidx.p052b.C0712a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: androidx.transition.o */
/* compiled from: TransitionManager */
public class C1416o {

    /* renamed from: a */
    static ArrayList<ViewGroup> f4215a = new ArrayList<>();

    /* renamed from: b */
    private static C1407m f4216b = new C1379b();

    /* renamed from: c */
    private static ThreadLocal<WeakReference<C0712a<ViewGroup, ArrayList<C1407m>>>> f4217c = new ThreadLocal<>();

    /* renamed from: androidx.transition.o$a */
    /* compiled from: TransitionManager */
    private static class C1417a implements OnAttachStateChangeListener, OnPreDrawListener {

        /* renamed from: a */
        C1407m f4218a;

        /* renamed from: b */
        ViewGroup f4219b;

        public void onViewAttachedToWindow(View view) {
        }

        C1417a(C1407m mVar, ViewGroup viewGroup) {
            this.f4218a = mVar;
            this.f4219b = viewGroup;
        }

        /* renamed from: a */
        private void m5685a() {
            this.f4219b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f4219b.removeOnAttachStateChangeListener(this);
        }

        public void onViewDetachedFromWindow(View view) {
            m5685a();
            C1416o.f4215a.remove(this.f4219b);
            ArrayList arrayList = (ArrayList) C1416o.m5681a().get(this.f4219b);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((C1407m) it.next()).resume(this.f4219b);
                }
            }
            this.f4218a.clearValues(true);
        }

        public boolean onPreDraw() {
            m5685a();
            if (!C1416o.f4215a.remove(this.f4219b)) {
                return true;
            }
            final C0712a a = C1416o.m5681a();
            ArrayList arrayList = (ArrayList) a.get(this.f4219b);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList();
                a.put(this.f4219b, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f4218a);
            this.f4218a.addListener(new C1415n() {
                /* renamed from: b */
                public void mo5738b(C1407m mVar) {
                    ((ArrayList) a.get(C1417a.this.f4219b)).remove(mVar);
                }
            });
            this.f4218a.captureValues(this.f4219b, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((C1407m) it.next()).resume(this.f4219b);
                }
            }
            this.f4218a.playTransition(this.f4219b);
            return true;
        }
    }

    /* renamed from: a */
    static C0712a<ViewGroup, ArrayList<C1407m>> m5681a() {
        WeakReference weakReference = (WeakReference) f4217c.get();
        if (weakReference != null) {
            C0712a<ViewGroup, ArrayList<C1407m>> aVar = (C0712a) weakReference.get();
            if (aVar != null) {
                return aVar;
            }
        }
        C0712a<ViewGroup, ArrayList<C1407m>> aVar2 = new C0712a<>();
        f4217c.set(new WeakReference(aVar2));
        return aVar2;
    }

    /* renamed from: b */
    private static void m5683b(ViewGroup viewGroup, C1407m mVar) {
        if (mVar != null && viewGroup != null) {
            C1417a aVar = new C1417a(mVar, viewGroup);
            viewGroup.addOnAttachStateChangeListener(aVar);
            viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
        }
    }

    /* renamed from: c */
    private static void m5684c(ViewGroup viewGroup, C1407m mVar) {
        ArrayList arrayList = (ArrayList) m5681a().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((C1407m) it.next()).pause(viewGroup);
            }
        }
        if (mVar != null) {
            mVar.captureValues(viewGroup, true);
        }
        C1405k a = C1405k.m5664a(viewGroup);
        if (a != null) {
            a.mo5789a();
        }
    }

    /* renamed from: a */
    public static void m5682a(ViewGroup viewGroup, C1407m mVar) {
        if (!f4215a.contains(viewGroup) && C0962r.m3603z(viewGroup)) {
            f4215a.add(viewGroup);
            if (mVar == null) {
                mVar = f4216b;
            }
            C1407m clone = mVar.clone();
            m5684c(viewGroup, clone);
            C1405k.m5665a(viewGroup, null);
            m5683b(viewGroup, clone);
        }
    }
}
