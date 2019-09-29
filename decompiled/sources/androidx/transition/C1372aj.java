package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.C1407m.C1414d;

/* renamed from: androidx.transition.aj */
/* compiled from: Visibility */
public abstract class C1372aj extends C1407m {

    /* renamed from: a */
    private static final String[] f4113a = {"android:visibility:visibility", "android:visibility:parent"};

    /* renamed from: b */
    private int f4114b = 3;

    /* renamed from: androidx.transition.aj$a */
    /* compiled from: Visibility */
    private static class C1374a extends AnimatorListenerAdapter implements C1359a, C1414d {

        /* renamed from: a */
        boolean f4118a = false;

        /* renamed from: b */
        private final View f4119b;

        /* renamed from: c */
        private final int f4120c;

        /* renamed from: d */
        private final ViewGroup f4121d;

        /* renamed from: e */
        private final boolean f4122e;

        /* renamed from: f */
        private boolean f4123f;

        /* renamed from: a */
        public void mo5737a(C1407m mVar) {
        }

        /* renamed from: e */
        public void mo5741e(C1407m mVar) {
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }

        C1374a(View view, int i, boolean z) {
            this.f4119b = view;
            this.f4120c = i;
            this.f4121d = (ViewGroup) view.getParent();
            this.f4122e = z;
            m5596a(true);
        }

        public void onAnimationPause(Animator animator) {
            if (!this.f4118a) {
                C1365ae.m5557a(this.f4119b, this.f4120c);
            }
        }

        public void onAnimationResume(Animator animator) {
            if (!this.f4118a) {
                C1365ae.m5557a(this.f4119b, 0);
            }
        }

        public void onAnimationCancel(Animator animator) {
            this.f4118a = true;
        }

        public void onAnimationEnd(Animator animator) {
            m5595a();
        }

        /* renamed from: b */
        public void mo5738b(C1407m mVar) {
            m5595a();
            mVar.removeListener(this);
        }

        /* renamed from: c */
        public void mo5739c(C1407m mVar) {
            m5596a(false);
        }

        /* renamed from: d */
        public void mo5740d(C1407m mVar) {
            m5596a(true);
        }

        /* renamed from: a */
        private void m5595a() {
            if (!this.f4118a) {
                C1365ae.m5557a(this.f4119b, this.f4120c);
                if (this.f4121d != null) {
                    this.f4121d.invalidate();
                }
            }
            m5596a(false);
        }

        /* renamed from: a */
        private void m5596a(boolean z) {
            if (this.f4122e && this.f4123f != z && this.f4121d != null) {
                this.f4123f = z;
                C1429y.m5725a(this.f4121d, z);
            }
        }
    }

    /* renamed from: androidx.transition.aj$b */
    /* compiled from: Visibility */
    private static class C1375b {

        /* renamed from: a */
        boolean f4124a;

        /* renamed from: b */
        boolean f4125b;

        /* renamed from: c */
        int f4126c;

        /* renamed from: d */
        int f4127d;

        /* renamed from: e */
        ViewGroup f4128e;

        /* renamed from: f */
        ViewGroup f4129f;

        C1375b() {
        }
    }

    /* renamed from: a */
    public Animator mo5726a(ViewGroup viewGroup, View view, C1424t tVar, C1424t tVar2) {
        return null;
    }

    /* renamed from: b */
    public Animator mo5729b(ViewGroup viewGroup, View view, C1424t tVar, C1424t tVar2) {
        return null;
    }

    /* renamed from: a */
    public void mo5728a(int i) {
        if ((i & -4) == 0) {
            this.f4114b = i;
            return;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }

    public String[] getTransitionProperties() {
        return f4113a;
    }

    /* renamed from: a */
    private void m5589a(C1424t tVar) {
        tVar.f4233a.put("android:visibility:visibility", Integer.valueOf(tVar.f4234b.getVisibility()));
        tVar.f4233a.put("android:visibility:parent", tVar.f4234b.getParent());
        int[] iArr = new int[2];
        tVar.f4234b.getLocationOnScreen(iArr);
        tVar.f4233a.put("android:visibility:screenLocation", iArr);
    }

    public void captureStartValues(C1424t tVar) {
        m5589a(tVar);
    }

    public void captureEndValues(C1424t tVar) {
        m5589a(tVar);
    }

    /* renamed from: a */
    private C1375b m5588a(C1424t tVar, C1424t tVar2) {
        C1375b bVar = new C1375b();
        bVar.f4124a = false;
        bVar.f4125b = false;
        if (tVar == null || !tVar.f4233a.containsKey("android:visibility:visibility")) {
            bVar.f4126c = -1;
            bVar.f4128e = null;
        } else {
            bVar.f4126c = ((Integer) tVar.f4233a.get("android:visibility:visibility")).intValue();
            bVar.f4128e = (ViewGroup) tVar.f4233a.get("android:visibility:parent");
        }
        if (tVar2 == null || !tVar2.f4233a.containsKey("android:visibility:visibility")) {
            bVar.f4127d = -1;
            bVar.f4129f = null;
        } else {
            bVar.f4127d = ((Integer) tVar2.f4233a.get("android:visibility:visibility")).intValue();
            bVar.f4129f = (ViewGroup) tVar2.f4233a.get("android:visibility:parent");
        }
        if (tVar == null || tVar2 == null) {
            if (tVar == null && bVar.f4127d == 0) {
                bVar.f4125b = true;
                bVar.f4124a = true;
            } else if (tVar2 == null && bVar.f4126c == 0) {
                bVar.f4125b = false;
                bVar.f4124a = true;
            }
        } else if (bVar.f4126c == bVar.f4127d && bVar.f4128e == bVar.f4129f) {
            return bVar;
        } else {
            if (bVar.f4126c != bVar.f4127d) {
                if (bVar.f4126c == 0) {
                    bVar.f4125b = false;
                    bVar.f4124a = true;
                } else if (bVar.f4127d == 0) {
                    bVar.f4125b = true;
                    bVar.f4124a = true;
                }
            } else if (bVar.f4129f == null) {
                bVar.f4125b = false;
                bVar.f4124a = true;
            } else if (bVar.f4128e == null) {
                bVar.f4125b = true;
                bVar.f4124a = true;
            }
        }
        return bVar;
    }

    public Animator createAnimator(ViewGroup viewGroup, C1424t tVar, C1424t tVar2) {
        C1375b a = m5588a(tVar, tVar2);
        if (!a.f4124a || (a.f4128e == null && a.f4129f == null)) {
            return null;
        }
        if (a.f4125b) {
            return mo5727a(viewGroup, tVar, a.f4126c, tVar2, a.f4127d);
        }
        return mo5730b(viewGroup, tVar, a.f4126c, tVar2, a.f4127d);
    }

    /* renamed from: a */
    public Animator mo5727a(ViewGroup viewGroup, C1424t tVar, int i, C1424t tVar2, int i2) {
        if ((this.f4114b & 1) != 1 || tVar2 == null) {
            return null;
        }
        if (tVar == null) {
            View view = (View) tVar2.f4234b.getParent();
            if (m5588a(getMatchedTransitionValues(view, false), getTransitionValues(view, false)).f4124a) {
                return null;
            }
        }
        return mo5726a(viewGroup, tVar2.f4234b, tVar, tVar2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x007d, code lost:
        if (r6.mCanRemoveViews != false) goto L_0x003a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0087 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ee A[RETURN] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.animation.Animator mo5730b(android.view.ViewGroup r7, androidx.transition.C1424t r8, int r9, androidx.transition.C1424t r10, int r11) {
        /*
            r6 = this;
            int r9 = r6.f4114b
            r0 = 2
            r9 = r9 & r0
            r1 = 0
            if (r9 == r0) goto L_0x0008
            return r1
        L_0x0008:
            if (r8 == 0) goto L_0x000d
            android.view.View r9 = r8.f4234b
            goto L_0x000e
        L_0x000d:
            r9 = r1
        L_0x000e:
            if (r10 == 0) goto L_0x0013
            android.view.View r2 = r10.f4234b
            goto L_0x0014
        L_0x0013:
            r2 = r1
        L_0x0014:
            r3 = 1
            if (r2 == 0) goto L_0x0037
            android.view.ViewParent r4 = r2.getParent()
            if (r4 != 0) goto L_0x001e
            goto L_0x0037
        L_0x001e:
            r4 = 4
            if (r11 != r4) goto L_0x0022
            goto L_0x0024
        L_0x0022:
            if (r9 != r2) goto L_0x0027
        L_0x0024:
            r9 = r1
            goto L_0x0084
        L_0x0027:
            boolean r2 = r6.mCanRemoveViews
            if (r2 == 0) goto L_0x002c
            goto L_0x0044
        L_0x002c:
            android.view.ViewParent r2 = r9.getParent()
            android.view.View r2 = (android.view.View) r2
            android.view.View r9 = androidx.transition.C1423s.m5714a(r7, r9, r2)
            goto L_0x003a
        L_0x0037:
            if (r2 == 0) goto L_0x003c
            r9 = r2
        L_0x003a:
            r2 = r1
            goto L_0x0084
        L_0x003c:
            if (r9 == 0) goto L_0x0082
            android.view.ViewParent r2 = r9.getParent()
            if (r2 != 0) goto L_0x0045
        L_0x0044:
            goto L_0x003a
        L_0x0045:
            android.view.ViewParent r2 = r9.getParent()
            boolean r2 = r2 instanceof android.view.View
            if (r2 == 0) goto L_0x0082
            android.view.ViewParent r2 = r9.getParent()
            android.view.View r2 = (android.view.View) r2
            androidx.transition.t r4 = r6.getTransitionValues(r2, r3)
            androidx.transition.t r5 = r6.getMatchedTransitionValues(r2, r3)
            androidx.transition.aj$b r4 = r6.m5588a(r4, r5)
            boolean r4 = r4.f4124a
            if (r4 != 0) goto L_0x0068
            android.view.View r9 = androidx.transition.C1423s.m5714a(r7, r9, r2)
            goto L_0x003a
        L_0x0068:
            android.view.ViewParent r4 = r2.getParent()
            if (r4 != 0) goto L_0x0080
            int r2 = r2.getId()
            r4 = -1
            if (r2 == r4) goto L_0x0080
            android.view.View r2 = r7.findViewById(r2)
            if (r2 == 0) goto L_0x0080
            boolean r2 = r6.mCanRemoveViews
            if (r2 == 0) goto L_0x0080
            goto L_0x003a
        L_0x0080:
            r9 = r1
            goto L_0x003a
        L_0x0082:
            r9 = r1
            r2 = r9
        L_0x0084:
            r4 = 0
            if (r9 == 0) goto L_0x00cc
            if (r8 == 0) goto L_0x00cc
            java.util.Map<java.lang.String, java.lang.Object> r11 = r8.f4233a
            java.lang.String r1 = "android:visibility:screenLocation"
            java.lang.Object r11 = r11.get(r1)
            int[] r11 = (int[]) r11
            r1 = r11[r4]
            r11 = r11[r3]
            int[] r0 = new int[r0]
            r7.getLocationOnScreen(r0)
            r2 = r0[r4]
            int r1 = r1 - r2
            int r2 = r9.getLeft()
            int r1 = r1 - r2
            r9.offsetLeftAndRight(r1)
            r0 = r0[r3]
            int r11 = r11 - r0
            int r0 = r9.getTop()
            int r11 = r11 - r0
            r9.offsetTopAndBottom(r11)
            androidx.transition.x r11 = androidx.transition.C1429y.m5724a(r7)
            r11.mo5877a(r9)
            android.animation.Animator r7 = r6.mo5729b(r7, r9, r8, r10)
            if (r7 != 0) goto L_0x00c3
            r11.mo5878b(r9)
            goto L_0x00cb
        L_0x00c3:
            androidx.transition.aj$1 r8 = new androidx.transition.aj$1
            r8.<init>(r11, r9)
            r7.addListener(r8)
        L_0x00cb:
            return r7
        L_0x00cc:
            if (r2 == 0) goto L_0x00ee
            int r9 = r2.getVisibility()
            androidx.transition.C1365ae.m5557a(r2, r4)
            android.animation.Animator r7 = r6.mo5729b(r7, r2, r8, r10)
            if (r7 == 0) goto L_0x00ea
            androidx.transition.aj$a r8 = new androidx.transition.aj$a
            r8.<init>(r2, r11, r3)
            r7.addListener(r8)
            androidx.transition.C1358a.m5536a(r7, r8)
            r6.addListener(r8)
            goto L_0x00ed
        L_0x00ea:
            androidx.transition.C1365ae.m5557a(r2, r9)
        L_0x00ed:
            return r7
        L_0x00ee:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.C1372aj.mo5730b(android.view.ViewGroup, androidx.transition.t, int, androidx.transition.t, int):android.animation.Animator");
    }

    public boolean isTransitionRequired(C1424t tVar, C1424t tVar2) {
        boolean z = false;
        if (tVar == null && tVar2 == null) {
            return false;
        }
        if (tVar != null && tVar2 != null && tVar2.f4233a.containsKey("android:visibility:visibility") != tVar.f4233a.containsKey("android:visibility:visibility")) {
            return false;
        }
        C1375b a = m5588a(tVar, tVar2);
        if (a.f4124a && (a.f4126c == 0 || a.f4127d == 0)) {
            z = true;
        }
        return z;
    }
}
