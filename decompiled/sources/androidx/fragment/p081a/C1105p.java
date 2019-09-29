package androidx.fragment.p081a;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.C0866l;
import androidx.core.p070g.C0962r;
import androidx.p052b.C0712a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* renamed from: androidx.fragment.a.p */
/* compiled from: FragmentTransition */
class C1105p {

    /* renamed from: a */
    private static final int[] f3444a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8};

    /* renamed from: b */
    private static final C1116r f3445b = (VERSION.SDK_INT >= 21 ? new C1111q() : null);

    /* renamed from: c */
    private static final C1116r f3446c = m4307b();

    /* renamed from: androidx.fragment.a.p$a */
    /* compiled from: FragmentTransition */
    static class C1110a {

        /* renamed from: a */
        public C1062d f3475a;

        /* renamed from: b */
        public boolean f3476b;

        /* renamed from: c */
        public C1057a f3477c;

        /* renamed from: d */
        public C1062d f3478d;

        /* renamed from: e */
        public boolean f3479e;

        /* renamed from: f */
        public C1057a f3480f;

        C1110a() {
        }
    }

    /* renamed from: b */
    private static C1116r m4307b() {
        try {
            return (C1116r) Class.forName("androidx.transition.e").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    static void m4298a(C1081j jVar, ArrayList<C1057a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, boolean z) {
        if (jVar.f3373l >= 1) {
            SparseArray sparseArray = new SparseArray();
            for (int i3 = i; i3 < i2; i3++) {
                C1057a aVar = (C1057a) arrayList.get(i3);
                if (((Boolean) arrayList2.get(i3)).booleanValue()) {
                    m4310b(aVar, sparseArray, z);
                } else {
                    m4294a(aVar, sparseArray, z);
                }
            }
            if (sparseArray.size() != 0) {
                View view = new View(jVar.f3374m.mo4366i());
                int size = sparseArray.size();
                for (int i4 = 0; i4 < size; i4++) {
                    int keyAt = sparseArray.keyAt(i4);
                    C0712a a = m4283a(keyAt, arrayList, arrayList2, i, i2);
                    C1110a aVar2 = (C1110a) sparseArray.valueAt(i4);
                    if (z) {
                        m4297a(jVar, keyAt, aVar2, view, a);
                    } else {
                        m4311b(jVar, keyAt, aVar2, view, a);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private static C0712a<String, String> m4283a(int i, ArrayList<C1057a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        ArrayList<String> arrayList3;
        ArrayList arrayList4;
        C0712a<String, String> aVar = new C0712a<>();
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            C1057a aVar2 = (C1057a) arrayList.get(i4);
            if (aVar2.mo4083b(i)) {
                boolean booleanValue = ((Boolean) arrayList2.get(i4)).booleanValue();
                if (aVar2.f3295r != null) {
                    int size = aVar2.f3295r.size();
                    if (booleanValue) {
                        arrayList3 = aVar2.f3295r;
                        arrayList4 = aVar2.f3296s;
                    } else {
                        ArrayList arrayList5 = aVar2.f3295r;
                        arrayList3 = aVar2.f3296s;
                        arrayList4 = arrayList5;
                    }
                    for (int i5 = 0; i5 < size; i5++) {
                        String str = (String) arrayList4.get(i5);
                        String str2 = (String) arrayList3.get(i5);
                        String str3 = (String) aVar.remove(str2);
                        if (str3 != null) {
                            aVar.put(str, str3);
                        } else {
                            aVar.put(str, str2);
                        }
                    }
                }
            }
        }
        return aVar;
    }

    /* renamed from: a */
    private static void m4297a(C1081j jVar, int i, C1110a aVar, View view, C0712a<String, String> aVar2) {
        Object obj;
        C1081j jVar2 = jVar;
        C1110a aVar3 = aVar;
        View view2 = view;
        ViewGroup viewGroup = jVar2.f3375n.mo4279a() ? (ViewGroup) jVar2.f3375n.mo4277a(i) : null;
        if (viewGroup != null) {
            C1062d dVar = aVar3.f3475a;
            C1062d dVar2 = aVar3.f3478d;
            C1116r a = m4286a(dVar2, dVar);
            if (a != null) {
                boolean z = aVar3.f3476b;
                boolean z2 = aVar3.f3479e;
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                Object a2 = m4289a(a, dVar, z);
                Object b = m4309b(a, dVar2, z2);
                Object obj2 = a2;
                ViewGroup viewGroup2 = viewGroup;
                ArrayList arrayList3 = arrayList2;
                Object a3 = m4287a(a, viewGroup, view, aVar2, aVar, arrayList2, arrayList, a2, b);
                Object obj3 = obj2;
                if (obj3 == null && a3 == null) {
                    obj = b;
                    if (obj == null) {
                        return;
                    }
                } else {
                    obj = b;
                }
                ArrayList a4 = m4292a(a, obj, dVar2, arrayList3, view2);
                ArrayList a5 = m4292a(a, obj3, dVar, arrayList, view2);
                m4302a(a5, 4);
                C1062d dVar3 = dVar;
                ArrayList arrayList4 = a4;
                Object a6 = m4290a(a, obj3, obj, a3, dVar3, z);
                if (a6 != null) {
                    m4300a(a, obj, dVar2, arrayList4);
                    ArrayList a7 = a.mo4546a(arrayList);
                    a.mo4523a(a6, obj3, a5, obj, arrayList4, a3, arrayList);
                    ViewGroup viewGroup3 = viewGroup2;
                    a.mo4519a(viewGroup3, a6);
                    a.mo4548a(viewGroup3, arrayList3, arrayList, a7, aVar2);
                    m4302a(a5, 0);
                    a.mo4525a(a3, arrayList3, arrayList);
                }
            }
        }
    }

    /* renamed from: a */
    private static void m4300a(C1116r rVar, Object obj, C1062d dVar, final ArrayList<View> arrayList) {
        if (dVar != null && obj != null && dVar.mAdded && dVar.mHidden && dVar.mHiddenChanged) {
            dVar.setHideReplaced(true);
            rVar.mo4530b(obj, dVar.getView(), arrayList);
            C1120s.m4356a(dVar.mContainer, new Runnable() {
                public void run() {
                    C1105p.m4302a(arrayList, 4);
                }
            });
        }
    }

    /* renamed from: b */
    private static void m4311b(C1081j jVar, int i, C1110a aVar, View view, C0712a<String, String> aVar2) {
        Object obj;
        C1081j jVar2 = jVar;
        C1110a aVar3 = aVar;
        View view2 = view;
        C0712a<String, String> aVar4 = aVar2;
        ViewGroup viewGroup = jVar2.f3375n.mo4279a() ? (ViewGroup) jVar2.f3375n.mo4277a(i) : null;
        if (viewGroup != null) {
            C1062d dVar = aVar3.f3475a;
            C1062d dVar2 = aVar3.f3478d;
            C1116r a = m4286a(dVar2, dVar);
            if (a != null) {
                boolean z = aVar3.f3476b;
                boolean z2 = aVar3.f3479e;
                Object a2 = m4289a(a, dVar, z);
                Object b = m4309b(a, dVar2, z2);
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = arrayList;
                Object obj2 = b;
                Object obj3 = a2;
                C1116r rVar = a;
                Object b2 = m4308b(a, viewGroup, view, aVar2, aVar, arrayList, arrayList2, a2, obj2);
                Object obj4 = obj3;
                if (obj4 == null && b2 == null) {
                    obj = obj2;
                    if (obj == null) {
                        return;
                    }
                } else {
                    obj = obj2;
                }
                ArrayList a3 = m4292a(rVar, obj, dVar2, arrayList3, view2);
                Object obj5 = (a3 == null || a3.isEmpty()) ? null : obj;
                rVar.mo4529b(obj4, view2);
                Object a4 = m4290a(rVar, obj4, obj5, b2, dVar, aVar3.f3476b);
                if (a4 != null) {
                    ArrayList arrayList4 = new ArrayList();
                    C1116r rVar2 = rVar;
                    rVar2.mo4523a(a4, obj4, arrayList4, obj5, a3, b2, arrayList2);
                    m4299a(rVar2, viewGroup, dVar, view, arrayList2, obj4, arrayList4, obj5, a3);
                    ArrayList arrayList5 = arrayList2;
                    rVar.mo4549a((View) viewGroup, arrayList5, (Map<String, String>) aVar4);
                    rVar.mo4519a(viewGroup, a4);
                    rVar.mo4550a(viewGroup, arrayList5, (Map<String, String>) aVar4);
                }
            }
        }
    }

    /* renamed from: a */
    private static void m4299a(C1116r rVar, ViewGroup viewGroup, C1062d dVar, View view, ArrayList<View> arrayList, Object obj, ArrayList<View> arrayList2, Object obj2, ArrayList<View> arrayList3) {
        final Object obj3 = obj;
        final C1116r rVar2 = rVar;
        final View view2 = view;
        final C1062d dVar2 = dVar;
        final ArrayList<View> arrayList4 = arrayList;
        final ArrayList<View> arrayList5 = arrayList2;
        final ArrayList<View> arrayList6 = arrayList3;
        final Object obj4 = obj2;
        C11072 r0 = new Runnable() {
            public void run() {
                if (obj3 != null) {
                    rVar2.mo4533c(obj3, view2);
                    arrayList5.addAll(C1105p.m4292a(rVar2, obj3, dVar2, arrayList4, view2));
                }
                if (arrayList6 != null) {
                    if (obj4 != null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(view2);
                        rVar2.mo4531b(obj4, arrayList6, arrayList);
                    }
                    arrayList6.clear();
                    arrayList6.add(view2);
                }
            }
        };
        ViewGroup viewGroup2 = viewGroup;
        C1120s.m4356a(viewGroup, r0);
    }

    /* renamed from: a */
    private static C1116r m4286a(C1062d dVar, C1062d dVar2) {
        ArrayList arrayList = new ArrayList();
        if (dVar != null) {
            Object exitTransition = dVar.getExitTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            Object returnTransition = dVar.getReturnTransition();
            if (returnTransition != null) {
                arrayList.add(returnTransition);
            }
            Object sharedElementReturnTransition = dVar.getSharedElementReturnTransition();
            if (sharedElementReturnTransition != null) {
                arrayList.add(sharedElementReturnTransition);
            }
        }
        if (dVar2 != null) {
            Object enterTransition = dVar2.getEnterTransition();
            if (enterTransition != null) {
                arrayList.add(enterTransition);
            }
            Object reenterTransition = dVar2.getReenterTransition();
            if (reenterTransition != null) {
                arrayList.add(reenterTransition);
            }
            Object sharedElementEnterTransition = dVar2.getSharedElementEnterTransition();
            if (sharedElementEnterTransition != null) {
                arrayList.add(sharedElementEnterTransition);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        if (f3445b != null && m4305a(f3445b, (List<Object>) arrayList)) {
            return f3445b;
        }
        if (f3446c != null && m4305a(f3446c, (List<Object>) arrayList)) {
            return f3446c;
        }
        if (f3445b == null && f3446c == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    /* renamed from: a */
    private static boolean m4305a(C1116r rVar, List<Object> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!rVar.mo4526a(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static Object m4288a(C1116r rVar, C1062d dVar, C1062d dVar2, boolean z) {
        Object obj;
        if (dVar == null || dVar2 == null) {
            return null;
        }
        if (z) {
            obj = dVar2.getSharedElementReturnTransition();
        } else {
            obj = dVar.getSharedElementEnterTransition();
        }
        return rVar.mo4532c(rVar.mo4527b(obj));
    }

    /* renamed from: a */
    private static Object m4289a(C1116r rVar, C1062d dVar, boolean z) {
        Object obj;
        if (dVar == null) {
            return null;
        }
        if (z) {
            obj = dVar.getReenterTransition();
        } else {
            obj = dVar.getEnterTransition();
        }
        return rVar.mo4527b(obj);
    }

    /* renamed from: b */
    private static Object m4309b(C1116r rVar, C1062d dVar, boolean z) {
        Object obj;
        if (dVar == null) {
            return null;
        }
        if (z) {
            obj = dVar.getReturnTransition();
        } else {
            obj = dVar.getExitTransition();
        }
        return rVar.mo4527b(obj);
    }

    /* renamed from: a */
    private static Object m4287a(C1116r rVar, ViewGroup viewGroup, View view, C0712a<String, String> aVar, C1110a aVar2, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        Object obj4;
        final Rect rect;
        final View view2;
        C1116r rVar2 = rVar;
        View view3 = view;
        C0712a<String, String> aVar3 = aVar;
        C1110a aVar4 = aVar2;
        ArrayList<View> arrayList3 = arrayList;
        ArrayList<View> arrayList4 = arrayList2;
        Object obj5 = obj;
        C1062d dVar = aVar4.f3475a;
        C1062d dVar2 = aVar4.f3478d;
        if (dVar != null) {
            dVar.getView().setVisibility(0);
        }
        if (dVar == null || dVar2 == null) {
            return null;
        }
        boolean z = aVar4.f3476b;
        if (aVar.isEmpty()) {
            obj3 = null;
        } else {
            obj3 = m4288a(rVar2, dVar, dVar2, z);
        }
        C0712a b = m4306b(rVar2, aVar3, obj3, aVar4);
        C0712a a = m4284a(rVar2, aVar3, obj3, aVar4);
        if (aVar.isEmpty()) {
            if (b != null) {
                b.clear();
            }
            if (a != null) {
                a.clear();
            }
            obj4 = null;
        } else {
            m4303a(arrayList3, b, (Collection<String>) aVar.keySet());
            m4303a(arrayList4, a, aVar.values());
            obj4 = obj3;
        }
        if (obj5 == null && obj2 == null && obj4 == null) {
            return null;
        }
        m4296a(dVar, dVar2, z, b, true);
        if (obj4 != null) {
            arrayList4.add(view3);
            rVar2.mo4522a(obj4, view3, arrayList3);
            m4301a(rVar, obj4, obj2, b, aVar4.f3479e, aVar4.f3480f);
            Rect rect2 = new Rect();
            View a2 = m4282a(a, aVar4, obj5, z);
            if (a2 != null) {
                rVar2.mo4520a(obj5, rect2);
            }
            rect = rect2;
            view2 = a2;
        } else {
            view2 = null;
            rect = null;
        }
        final C1062d dVar3 = dVar;
        final C1062d dVar4 = dVar2;
        final boolean z2 = z;
        final C0712a aVar5 = a;
        final C1116r rVar3 = rVar;
        C11083 r0 = new Runnable() {
            public void run() {
                C1105p.m4296a(dVar3, dVar4, z2, aVar5, false);
                if (view2 != null) {
                    rVar3.mo4547a(view2, rect);
                }
            }
        };
        C1120s.m4356a(viewGroup, r0);
        return obj4;
    }

    /* renamed from: a */
    private static void m4303a(ArrayList<View> arrayList, C0712a<String, View> aVar, Collection<String> collection) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View view = (View) aVar.mo2880c(size);
            if (collection.contains(C0962r.m3593p(view))) {
                arrayList.add(view);
            }
        }
    }

    /* renamed from: b */
    private static Object m4308b(C1116r rVar, ViewGroup viewGroup, View view, C0712a<String, String> aVar, C1110a aVar2, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        C0712a<String, String> aVar3;
        Object obj3;
        Object obj4;
        Rect rect;
        C1116r rVar2 = rVar;
        C1110a aVar4 = aVar2;
        ArrayList<View> arrayList3 = arrayList;
        Object obj5 = obj;
        C1062d dVar = aVar4.f3475a;
        C1062d dVar2 = aVar4.f3478d;
        if (dVar == null || dVar2 == null) {
            return null;
        }
        boolean z = aVar4.f3476b;
        if (aVar.isEmpty()) {
            aVar3 = aVar;
            obj3 = null;
        } else {
            obj3 = m4288a(rVar2, dVar, dVar2, z);
            aVar3 = aVar;
        }
        C0712a b = m4306b(rVar2, aVar3, obj3, aVar4);
        if (aVar.isEmpty()) {
            obj4 = null;
        } else {
            arrayList3.addAll(b.values());
            obj4 = obj3;
        }
        if (obj5 == null && obj2 == null && obj4 == null) {
            return null;
        }
        m4296a(dVar, dVar2, z, b, true);
        if (obj4 != null) {
            rect = new Rect();
            rVar2.mo4522a(obj4, view, arrayList3);
            m4301a(rVar, obj4, obj2, b, aVar4.f3479e, aVar4.f3480f);
            if (obj5 != null) {
                rVar2.mo4520a(obj5, rect);
            }
        } else {
            rect = null;
        }
        final C1116r rVar3 = rVar;
        final C0712a<String, String> aVar5 = aVar;
        final Object obj6 = obj4;
        final C1110a aVar6 = aVar2;
        C11094 r13 = r0;
        final ArrayList<View> arrayList4 = arrayList2;
        final View view2 = view;
        final C1062d dVar3 = dVar;
        final C1062d dVar4 = dVar2;
        final boolean z2 = z;
        final ArrayList<View> arrayList5 = arrayList;
        final Object obj7 = obj;
        final Rect rect2 = rect;
        C11094 r0 = new Runnable() {
            public void run() {
                C0712a a = C1105p.m4284a(rVar3, aVar5, obj6, aVar6);
                if (a != null) {
                    arrayList4.addAll(a.values());
                    arrayList4.add(view2);
                }
                C1105p.m4296a(dVar3, dVar4, z2, a, false);
                if (obj6 != null) {
                    rVar3.mo4525a(obj6, arrayList5, arrayList4);
                    View a2 = C1105p.m4282a(a, aVar6, obj7, z2);
                    if (a2 != null) {
                        rVar3.mo4547a(a2, rect2);
                    }
                }
            }
        };
        C1120s.m4356a(viewGroup, r13);
        return obj4;
    }

    /* renamed from: b */
    private static C0712a<String, View> m4306b(C1116r rVar, C0712a<String, String> aVar, Object obj, C1110a aVar2) {
        C0866l lVar;
        ArrayList<String> arrayList;
        if (aVar.isEmpty() || obj == null) {
            aVar.clear();
            return null;
        }
        C1062d dVar = aVar2.f3478d;
        C0712a<String, View> aVar3 = new C0712a<>();
        rVar.mo4552a((Map<String, View>) aVar3, dVar.getView());
        C1057a aVar4 = aVar2.f3480f;
        if (aVar2.f3479e) {
            lVar = dVar.getEnterTransitionCallback();
            arrayList = aVar4.f3296s;
        } else {
            lVar = dVar.getExitTransitionCallback();
            arrayList = aVar4.f3295r;
        }
        aVar3.mo2744a(arrayList);
        if (lVar != null) {
            lVar.mo3540a((List<String>) arrayList, (Map<String, View>) aVar3);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = (String) arrayList.get(size);
                View view = (View) aVar3.get(str);
                if (view == null) {
                    aVar.remove(str);
                } else if (!str.equals(C0962r.m3593p(view))) {
                    aVar.put(C0962r.m3593p(view), (String) aVar.remove(str));
                }
            }
        } else {
            aVar.mo2744a(aVar3.keySet());
        }
        return aVar3;
    }

    /* renamed from: a */
    static C0712a<String, View> m4284a(C1116r rVar, C0712a<String, String> aVar, Object obj, C1110a aVar2) {
        C0866l lVar;
        ArrayList<String> arrayList;
        C1062d dVar = aVar2.f3475a;
        View view = dVar.getView();
        if (aVar.isEmpty() || obj == null || view == null) {
            aVar.clear();
            return null;
        }
        C0712a<String, View> aVar3 = new C0712a<>();
        rVar.mo4552a((Map<String, View>) aVar3, view);
        C1057a aVar4 = aVar2.f3477c;
        if (aVar2.f3476b) {
            lVar = dVar.getExitTransitionCallback();
            arrayList = aVar4.f3295r;
        } else {
            lVar = dVar.getEnterTransitionCallback();
            arrayList = aVar4.f3296s;
        }
        if (arrayList != null) {
            aVar3.mo2744a(arrayList);
            aVar3.mo2744a(aVar.values());
        }
        if (lVar != null) {
            lVar.mo3540a((List<String>) arrayList, (Map<String, View>) aVar3);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = (String) arrayList.get(size);
                View view2 = (View) aVar3.get(str);
                if (view2 == null) {
                    String a = m4291a(aVar, str);
                    if (a != null) {
                        aVar.remove(a);
                    }
                } else if (!str.equals(C0962r.m3593p(view2))) {
                    String a2 = m4291a(aVar, str);
                    if (a2 != null) {
                        aVar.put(a2, C0962r.m3593p(view2));
                    }
                }
            }
        } else {
            m4293a(aVar, aVar3);
        }
        return aVar3;
    }

    /* renamed from: a */
    private static String m4291a(C0712a<String, String> aVar, String str) {
        int size = aVar.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(aVar.mo2880c(i))) {
                return (String) aVar.mo2879b(i);
            }
        }
        return null;
    }

    /* renamed from: a */
    static View m4282a(C0712a<String, View> aVar, C1110a aVar2, Object obj, boolean z) {
        String str;
        C1057a aVar3 = aVar2.f3477c;
        if (obj == null || aVar == null || aVar3.f3295r == null || aVar3.f3295r.isEmpty()) {
            return null;
        }
        if (z) {
            str = (String) aVar3.f3295r.get(0);
        } else {
            str = (String) aVar3.f3296s.get(0);
        }
        return (View) aVar.get(str);
    }

    /* renamed from: a */
    private static void m4301a(C1116r rVar, Object obj, Object obj2, C0712a<String, View> aVar, boolean z, C1057a aVar2) {
        String str;
        if (aVar2.f3295r != null && !aVar2.f3295r.isEmpty()) {
            if (z) {
                str = (String) aVar2.f3296s.get(0);
            } else {
                str = (String) aVar2.f3295r.get(0);
            }
            View view = (View) aVar.get(str);
            rVar.mo4521a(obj, view);
            if (obj2 != null) {
                rVar.mo4521a(obj2, view);
            }
        }
    }

    /* renamed from: a */
    private static void m4293a(C0712a<String, String> aVar, C0712a<String, View> aVar2) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            if (!aVar2.containsKey((String) aVar.mo2880c(size))) {
                aVar.mo2884d(size);
            }
        }
    }

    /* renamed from: a */
    static void m4296a(C1062d dVar, C1062d dVar2, boolean z, C0712a<String, View> aVar, boolean z2) {
        C0866l lVar;
        int i;
        if (z) {
            lVar = dVar2.getEnterTransitionCallback();
        } else {
            lVar = dVar.getEnterTransitionCallback();
        }
        if (lVar != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (aVar == null) {
                i = 0;
            } else {
                i = aVar.size();
            }
            for (int i2 = 0; i2 < i; i2++) {
                arrayList2.add(aVar.mo2879b(i2));
                arrayList.add(aVar.mo2880c(i2));
            }
            if (z2) {
                lVar.mo3539a((List<String>) arrayList2, (List<View>) arrayList, null);
            } else {
                lVar.mo3541b(arrayList2, arrayList, null);
            }
        }
    }

    /* renamed from: a */
    static ArrayList<View> m4292a(C1116r rVar, Object obj, C1062d dVar, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        View view2 = dVar.getView();
        if (view2 != null) {
            rVar.mo4551a(arrayList2, view2);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        rVar.mo4524a(obj, arrayList2);
        return arrayList2;
    }

    /* renamed from: a */
    static void m4302a(ArrayList<View> arrayList, int i) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((View) arrayList.get(size)).setVisibility(i);
            }
        }
    }

    /* renamed from: a */
    private static Object m4290a(C1116r rVar, Object obj, Object obj2, Object obj3, C1062d dVar, boolean z) {
        boolean z2 = (obj == null || obj2 == null || dVar == null) ? true : z ? dVar.getAllowReturnTransitionOverlap() : dVar.getAllowEnterTransitionOverlap();
        if (z2) {
            return rVar.mo4518a(obj2, obj, obj3);
        }
        return rVar.mo4528b(obj2, obj, obj3);
    }

    /* renamed from: a */
    public static void m4294a(C1057a aVar, SparseArray<C1110a> sparseArray, boolean z) {
        int size = aVar.f3279b.size();
        for (int i = 0; i < size; i++) {
            m4295a(aVar, (C1058a) aVar.f3279b.get(i), sparseArray, false, z);
        }
    }

    /* renamed from: b */
    public static void m4310b(C1057a aVar, SparseArray<C1110a> sparseArray, boolean z) {
        if (aVar.f3278a.f3375n.mo4279a()) {
            for (int size = aVar.f3279b.size() - 1; size >= 0; size--) {
                m4295a(aVar, (C1058a) aVar.f3279b.get(size), sparseArray, true, z);
            }
        }
    }

    /* renamed from: a */
    static boolean m4304a() {
        return (f3445b == null && f3446c == null) ? false : true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0034, code lost:
        if (r10.mAdded != false) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x006b, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x006d, code lost:
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0078, code lost:
        r13 = r1;
        r1 = false;
        r12 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0087, code lost:
        if (r10.mHidden == false) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0089, code lost:
        r1 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0097  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m4295a(androidx.fragment.p081a.C1057a r15, androidx.fragment.p081a.C1057a.C1058a r16, android.util.SparseArray<androidx.fragment.p081a.C1105p.C1110a> r17, boolean r18, boolean r19) {
        /*
            r0 = r15
            r1 = r16
            r2 = r17
            r3 = r18
            androidx.fragment.a.d r10 = r1.f3300b
            if (r10 != 0) goto L_0x000c
            return
        L_0x000c:
            int r11 = r10.mContainerId
            if (r11 != 0) goto L_0x0011
            return
        L_0x0011:
            if (r3 == 0) goto L_0x001a
            int[] r4 = f3444a
            int r1 = r1.f3299a
            r1 = r4[r1]
            goto L_0x001c
        L_0x001a:
            int r1 = r1.f3299a
        L_0x001c:
            r4 = 0
            r5 = 1
            if (r1 == r5) goto L_0x007c
            switch(r1) {
                case 3: goto L_0x0052;
                case 4: goto L_0x003a;
                case 5: goto L_0x0028;
                case 6: goto L_0x0052;
                case 7: goto L_0x007c;
                default: goto L_0x0023;
            }
        L_0x0023:
            r1 = 0
        L_0x0024:
            r12 = 0
            r13 = 0
            goto L_0x008f
        L_0x0028:
            if (r19 == 0) goto L_0x0037
            boolean r1 = r10.mHiddenChanged
            if (r1 == 0) goto L_0x008b
            boolean r1 = r10.mHidden
            if (r1 != 0) goto L_0x008b
            boolean r1 = r10.mAdded
            if (r1 == 0) goto L_0x008b
            goto L_0x0089
        L_0x0037:
            boolean r1 = r10.mHidden
            goto L_0x008c
        L_0x003a:
            if (r19 == 0) goto L_0x0049
            boolean r1 = r10.mHiddenChanged
            if (r1 == 0) goto L_0x006d
            boolean r1 = r10.mAdded
            if (r1 == 0) goto L_0x006d
            boolean r1 = r10.mHidden
            if (r1 == 0) goto L_0x006d
        L_0x0048:
            goto L_0x006b
        L_0x0049:
            boolean r1 = r10.mAdded
            if (r1 == 0) goto L_0x006d
            boolean r1 = r10.mHidden
            if (r1 != 0) goto L_0x006d
            goto L_0x0048
        L_0x0052:
            if (r19 == 0) goto L_0x006f
            boolean r1 = r10.mAdded
            if (r1 != 0) goto L_0x006d
            android.view.View r1 = r10.mView
            if (r1 == 0) goto L_0x006d
            android.view.View r1 = r10.mView
            int r1 = r1.getVisibility()
            if (r1 != 0) goto L_0x006d
            float r1 = r10.mPostponedAlpha
            r6 = 0
            int r1 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r1 < 0) goto L_0x006d
        L_0x006b:
            r1 = 1
            goto L_0x0078
        L_0x006d:
            r1 = 0
            goto L_0x0078
        L_0x006f:
            boolean r1 = r10.mAdded
            if (r1 == 0) goto L_0x006d
            boolean r1 = r10.mHidden
            if (r1 != 0) goto L_0x006d
            goto L_0x006b
        L_0x0078:
            r13 = r1
            r1 = 0
            r12 = 1
            goto L_0x008f
        L_0x007c:
            if (r19 == 0) goto L_0x0081
            boolean r1 = r10.mIsNewlyAdded
            goto L_0x008c
        L_0x0081:
            boolean r1 = r10.mAdded
            if (r1 != 0) goto L_0x008b
            boolean r1 = r10.mHidden
            if (r1 != 0) goto L_0x008b
        L_0x0089:
            r1 = 1
            goto L_0x008c
        L_0x008b:
            r1 = 0
        L_0x008c:
            r4 = r1
            r1 = 1
            goto L_0x0024
        L_0x008f:
            java.lang.Object r6 = r2.get(r11)
            androidx.fragment.a.p$a r6 = (androidx.fragment.p081a.C1105p.C1110a) r6
            if (r4 == 0) goto L_0x00a1
            androidx.fragment.a.p$a r6 = m4285a(r6, r2, r11)
            r6.f3475a = r10
            r6.f3476b = r3
            r6.f3477c = r0
        L_0x00a1:
            r14 = r6
            r9 = 0
            if (r19 != 0) goto L_0x00c9
            if (r1 == 0) goto L_0x00c9
            if (r14 == 0) goto L_0x00af
            androidx.fragment.a.d r1 = r14.f3478d
            if (r1 != r10) goto L_0x00af
            r14.f3478d = r9
        L_0x00af:
            androidx.fragment.a.j r4 = r0.f3278a
            int r1 = r10.mState
            if (r1 >= r5) goto L_0x00c9
            int r1 = r4.f3373l
            if (r1 < r5) goto L_0x00c9
            boolean r1 = r0.f3297t
            if (r1 != 0) goto L_0x00c9
            r4.mo4436f(r10)
            r6 = 1
            r7 = 0
            r8 = 0
            r1 = 0
            r5 = r10
            r9 = r1
            r4.mo4403a(r5, r6, r7, r8, r9)
        L_0x00c9:
            if (r13 == 0) goto L_0x00db
            if (r14 == 0) goto L_0x00d1
            androidx.fragment.a.d r1 = r14.f3478d
            if (r1 != 0) goto L_0x00db
        L_0x00d1:
            androidx.fragment.a.p$a r14 = m4285a(r14, r2, r11)
            r14.f3478d = r10
            r14.f3479e = r3
            r14.f3480f = r0
        L_0x00db:
            if (r19 != 0) goto L_0x00e8
            if (r12 == 0) goto L_0x00e8
            if (r14 == 0) goto L_0x00e8
            androidx.fragment.a.d r0 = r14.f3475a
            if (r0 != r10) goto L_0x00e8
            r0 = 0
            r14.f3475a = r0
        L_0x00e8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.p081a.C1105p.m4295a(androidx.fragment.a.a, androidx.fragment.a.a$a, android.util.SparseArray, boolean, boolean):void");
    }

    /* renamed from: a */
    private static C1110a m4285a(C1110a aVar, SparseArray<C1110a> sparseArray, int i) {
        if (aVar != null) {
            return aVar;
        }
        C1110a aVar2 = new C1110a();
        sparseArray.put(i, aVar2);
        return aVar2;
    }
}
