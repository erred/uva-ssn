package androidx.coordinatorlayout.widget;

import androidx.core.p069f.C0926d.C0927a;
import androidx.core.p069f.C0926d.C0928b;
import androidx.p052b.C0725g;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* renamed from: androidx.coordinatorlayout.widget.a */
/* compiled from: DirectedAcyclicGraph */
public final class C0830a<T> {

    /* renamed from: a */
    private final C0927a<ArrayList<T>> f2709a = new C0928b(10);

    /* renamed from: b */
    private final C0725g<T, ArrayList<T>> f2710b = new C0725g<>();

    /* renamed from: c */
    private final ArrayList<T> f2711c = new ArrayList<>();

    /* renamed from: d */
    private final HashSet<T> f2712d = new HashSet<>();

    /* renamed from: a */
    public void mo3438a(T t) {
        if (!this.f2710b.containsKey(t)) {
            this.f2710b.put(t, null);
        }
    }

    /* renamed from: b */
    public boolean mo3441b(T t) {
        return this.f2710b.containsKey(t);
    }

    /* renamed from: a */
    public void mo3439a(T t, T t2) {
        if (!this.f2710b.containsKey(t) || !this.f2710b.containsKey(t2)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList arrayList = (ArrayList) this.f2710b.get(t);
        if (arrayList == null) {
            arrayList = m3073c();
            this.f2710b.put(t, arrayList);
        }
        arrayList.add(t2);
    }

    /* renamed from: c */
    public List mo3442c(T t) {
        return (List) this.f2710b.get(t);
    }

    /* renamed from: d */
    public List<T> mo3443d(T t) {
        int size = this.f2710b.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            ArrayList arrayList2 = (ArrayList) this.f2710b.mo2880c(i);
            if (arrayList2 != null && arrayList2.contains(t)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f2710b.mo2879b(i));
            }
        }
        return arrayList;
    }

    /* renamed from: e */
    public boolean mo3444e(T t) {
        int size = this.f2710b.size();
        for (int i = 0; i < size; i++) {
            ArrayList arrayList = (ArrayList) this.f2710b.mo2880c(i);
            if (arrayList != null && arrayList.contains(t)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public void mo3437a() {
        int size = this.f2710b.size();
        for (int i = 0; i < size; i++) {
            ArrayList arrayList = (ArrayList) this.f2710b.mo2880c(i);
            if (arrayList != null) {
                m3072a(arrayList);
            }
        }
        this.f2710b.clear();
    }

    /* renamed from: b */
    public ArrayList<T> mo3440b() {
        this.f2711c.clear();
        this.f2712d.clear();
        int size = this.f2710b.size();
        for (int i = 0; i < size; i++) {
            m3071a(this.f2710b.mo2879b(i), this.f2711c, this.f2712d);
        }
        return this.f2711c;
    }

    /* renamed from: a */
    private void m3071a(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (!arrayList.contains(t)) {
            if (!hashSet.contains(t)) {
                hashSet.add(t);
                ArrayList arrayList2 = (ArrayList) this.f2710b.get(t);
                if (arrayList2 != null) {
                    int size = arrayList2.size();
                    for (int i = 0; i < size; i++) {
                        m3071a(arrayList2.get(i), arrayList, hashSet);
                    }
                }
                hashSet.remove(t);
                arrayList.add(t);
                return;
            }
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
    }

    /* renamed from: c */
    private ArrayList<T> m3073c() {
        ArrayList<T> arrayList = (ArrayList) this.f2709a.mo3647a();
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    /* renamed from: a */
    private void m3072a(ArrayList<T> arrayList) {
        arrayList.clear();
        this.f2709a.mo3648a(arrayList);
    }
}
