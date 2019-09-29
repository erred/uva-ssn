package androidx.fragment.p081a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.p070g.C0962r;
import androidx.core.p070g.C0967t;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: androidx.fragment.a.r */
/* compiled from: FragmentTransitionImpl */
public abstract class C1116r {
    /* renamed from: a */
    public abstract Object mo4518a(Object obj, Object obj2, Object obj3);

    /* renamed from: a */
    public abstract void mo4519a(ViewGroup viewGroup, Object obj);

    /* renamed from: a */
    public abstract void mo4520a(Object obj, Rect rect);

    /* renamed from: a */
    public abstract void mo4521a(Object obj, View view);

    /* renamed from: a */
    public abstract void mo4522a(Object obj, View view, ArrayList<View> arrayList);

    /* renamed from: a */
    public abstract void mo4523a(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3);

    /* renamed from: a */
    public abstract void mo4524a(Object obj, ArrayList<View> arrayList);

    /* renamed from: a */
    public abstract void mo4525a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    /* renamed from: a */
    public abstract boolean mo4526a(Object obj);

    /* renamed from: b */
    public abstract Object mo4527b(Object obj);

    /* renamed from: b */
    public abstract Object mo4528b(Object obj, Object obj2, Object obj3);

    /* renamed from: b */
    public abstract void mo4529b(Object obj, View view);

    /* renamed from: b */
    public abstract void mo4530b(Object obj, View view, ArrayList<View> arrayList);

    /* renamed from: b */
    public abstract void mo4531b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    /* renamed from: c */
    public abstract Object mo4532c(Object obj);

    /* renamed from: c */
    public abstract void mo4533c(Object obj, View view);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4547a(View view, Rect rect) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        rect.set(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public ArrayList<String> mo4546a(ArrayList<View> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = (View) arrayList.get(i);
            arrayList2.add(C0962r.m3593p(view));
            C0962r.m3564a(view, (String) null);
        }
        return arrayList2;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4548a(View view, ArrayList<View> arrayList, ArrayList<View> arrayList2, ArrayList<String> arrayList3, Map<String, String> map) {
        final int size = arrayList2.size();
        final ArrayList arrayList4 = new ArrayList();
        for (int i = 0; i < size; i++) {
            View view2 = (View) arrayList.get(i);
            String p = C0962r.m3593p(view2);
            arrayList4.add(p);
            if (p != null) {
                C0962r.m3564a(view2, (String) null);
                String str = (String) map.get(p);
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    } else if (str.equals(arrayList3.get(i2))) {
                        C0962r.m3564a((View) arrayList2.get(i2), p);
                        break;
                    } else {
                        i2++;
                    }
                }
            }
        }
        final ArrayList<View> arrayList5 = arrayList2;
        final ArrayList<String> arrayList6 = arrayList3;
        final ArrayList<View> arrayList7 = arrayList;
        C11171 r0 = new Runnable() {
            public void run() {
                for (int i = 0; i < size; i++) {
                    C0962r.m3564a((View) arrayList5.get(i), (String) arrayList6.get(i));
                    C0962r.m3564a((View) arrayList7.get(i), (String) arrayList4.get(i));
                }
            }
        };
        C1120s.m4356a(view, r0);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4551a(ArrayList<View> arrayList, View view) {
        if (view.getVisibility() != 0) {
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (C0967t.m3618a(viewGroup)) {
                arrayList.add(viewGroup);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                mo4551a(arrayList, viewGroup.getChildAt(i));
            }
            return;
        }
        arrayList.add(view);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4552a(Map<String, View> map, View view) {
        if (view.getVisibility() == 0) {
            String p = C0962r.m3593p(view);
            if (p != null) {
                map.put(p, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    mo4552a(map, viewGroup.getChildAt(i));
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4549a(View view, final ArrayList<View> arrayList, final Map<String, String> map) {
        C1120s.m4356a(view, new Runnable() {
            public void run() {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    View view = (View) arrayList.get(i);
                    String p = C0962r.m3593p(view);
                    if (p != null) {
                        C0962r.m3564a(view, C1116r.m4329a(map, p));
                    }
                }
            }
        });
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4550a(ViewGroup viewGroup, final ArrayList<View> arrayList, final Map<String, String> map) {
        C1120s.m4356a(viewGroup, new Runnable() {
            public void run() {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    View view = (View) arrayList.get(i);
                    C0962r.m3564a(view, (String) map.get(C0962r.m3593p(view)));
                }
            }
        });
    }

    /* renamed from: a */
    protected static void m4330a(List<View> list, View view) {
        int size = list.size();
        if (!m4332a(list, view, size)) {
            list.add(view);
            for (int i = size; i < list.size(); i++) {
                View view2 = (View) list.get(i);
                if (view2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    int childCount = viewGroup.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = viewGroup.getChildAt(i2);
                        if (!m4332a(list, childAt, size)) {
                            list.add(childAt);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private static boolean m4332a(List<View> list, View view, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (list.get(i2) == view) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    protected static boolean m4331a(List list) {
        return list == null || list.isEmpty();
    }

    /* renamed from: a */
    static String m4329a(Map<String, String> map, String str) {
        for (Entry entry : map.entrySet()) {
            if (str.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        return null;
    }
}
