package androidx.constraintlayout.p060b.p061a;

import java.util.HashSet;
import java.util.List;

/* renamed from: androidx.constraintlayout.b.a.h */
/* compiled from: ConstraintWidgetGroup */
public class C0770h {

    /* renamed from: a */
    public List<C0766f> f2324a;

    /* renamed from: b */
    int f2325b = -1;

    /* renamed from: c */
    int f2326c = -1;

    /* renamed from: d */
    public final int[] f2327d = {this.f2325b, this.f2326c};

    /* renamed from: e */
    HashSet<C0766f> f2328e = new HashSet<>();

    /* renamed from: f */
    HashSet<C0766f> f2329f = new HashSet<>();

    /* renamed from: g */
    HashSet<C0766f> f2330g = new HashSet<>();

    /* renamed from: h */
    HashSet<C0766f> f2331h = new HashSet<>();

    C0770h(List<C0766f> list) {
        this.f2324a = list;
    }

    /* renamed from: a */
    public HashSet<C0766f> mo3141a(int i) {
        if (i == 0) {
            return this.f2328e;
        }
        if (i == 1) {
            return this.f2329f;
        }
        return null;
    }

    /* renamed from: b */
    public HashSet<C0766f> mo3142b(int i) {
        if (i == 0) {
            return this.f2330g;
        }
        if (i == 1) {
            return this.f2331h;
        }
        return null;
    }
}
