package com.p110b.p111a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.p110b.p111a.p112a.C1859b;

/* renamed from: com.b.a.b */
/* compiled from: SwipeToDismissTouchListener */
public class C1860b<SomeCollectionView extends C1859b> implements OnTouchListener {

    /* renamed from: a */
    static final /* synthetic */ boolean f5713a = (!C1860b.class.desiredAssertionStatus());

    /* renamed from: b */
    private int f5714b;

    /* renamed from: c */
    private int f5715c;

    /* renamed from: d */
    private int f5716d;

    /* renamed from: e */
    private long f5717e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public SomeCollectionView f5718f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public C1865a<SomeCollectionView> f5719g;

    /* renamed from: h */
    private int f5720h = 1;

    /* renamed from: i */
    private C1866b f5721i;

    /* renamed from: j */
    private float f5722j;

    /* renamed from: k */
    private float f5723k;

    /* renamed from: l */
    private boolean f5724l;

    /* renamed from: m */
    private int f5725m;

    /* renamed from: n */
    private VelocityTracker f5726n;

    /* renamed from: o */
    private int f5727o;

    /* renamed from: p */
    private C1867c f5728p;

    /* renamed from: q */
    private boolean f5729q;

    /* renamed from: com.b.a.b$a */
    /* compiled from: SwipeToDismissTouchListener */
    public interface C1865a<SomeCollectionView extends C1859b> {
        /* renamed from: a */
        void mo7195a(SomeCollectionView somecollectionview, int i);

        /* renamed from: a */
        boolean mo7196a(int i);
    }

    /* renamed from: com.b.a.b$b */
    /* compiled from: SwipeToDismissTouchListener */
    class C1866b implements Comparable<C1866b> {

        /* renamed from: a */
        public int f5741a;

        /* renamed from: b */
        public C1867c f5742b;

        public C1866b(int i, C1867c cVar) {
            this.f5741a = i;
            this.f5742b = cVar;
        }

        /* renamed from: a */
        public int compareTo(C1866b bVar) {
            return bVar.f5741a - this.f5741a;
        }
    }

    /* renamed from: com.b.a.b$c */
    /* compiled from: SwipeToDismissTouchListener */
    public class C1867c {

        /* renamed from: a */
        final View f5744a;

        /* renamed from: b */
        final View f5745b;

        /* renamed from: c */
        final View f5746c;

        /* renamed from: d */
        boolean f5747d = false;

        public C1867c(ViewGroup viewGroup) {
            this.f5744a = viewGroup;
            this.f5745b = viewGroup.getChildAt(0);
            this.f5746c = viewGroup.getChildAt(1);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public View mo7199a() {
            return this.f5747d ? this.f5746c : this.f5745b;
        }
    }

    public C1860b(SomeCollectionView somecollectionview, C1865a<SomeCollectionView> aVar) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(somecollectionview.mo7180a());
        this.f5714b = viewConfiguration.getScaledTouchSlop();
        this.f5715c = viewConfiguration.getScaledMinimumFlingVelocity() * 16;
        this.f5716d = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f5717e = (long) somecollectionview.mo7180a().getResources().getInteger(17694720);
        this.f5718f = somecollectionview;
        this.f5719g = aVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0162, code lost:
        if (r11.f5726n.getXVelocity() > com.google.android.gms.maps.model.BitmapDescriptorFactory.HUE_RED) goto L_0x0167;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r12, android.view.MotionEvent r13) {
        /*
            r11 = this;
            int r12 = r11.f5720h
            r0 = 2
            if (r12 >= r0) goto L_0x000d
            SomeCollectionView r12 = r11.f5718f
            int r12 = r12.mo7185b()
            r11.f5720h = r12
        L_0x000d:
            int r12 = r13.getActionMasked()
            r1 = -1
            r2 = 1065353216(0x3f800000, float:1.0)
            r3 = 0
            r4 = 1
            r5 = 0
            r6 = 0
            switch(r12) {
                case 0: goto L_0x01ca;
                case 1: goto L_0x00ea;
                case 2: goto L_0x0059;
                case 3: goto L_0x001d;
                default: goto L_0x001b;
            }
        L_0x001b:
            goto L_0x027d
        L_0x001d:
            android.view.VelocityTracker r12 = r11.f5726n
            if (r12 != 0) goto L_0x0023
            goto L_0x027d
        L_0x0023:
            com.b.a.b$c<> r12 = r11.f5728p
            if (r12 == 0) goto L_0x0046
            boolean r12 = r11.f5724l
            if (r12 == 0) goto L_0x0046
            com.b.a.b$c<> r12 = r11.f5728p
            android.view.View r12 = r12.mo7199a()
            android.view.ViewPropertyAnimator r12 = r12.animate()
            android.view.ViewPropertyAnimator r12 = r12.translationX(r5)
            android.view.ViewPropertyAnimator r12 = r12.alpha(r2)
            long r7 = r11.f5717e
            android.view.ViewPropertyAnimator r12 = r12.setDuration(r7)
            r12.setListener(r3)
        L_0x0046:
            android.view.VelocityTracker r12 = r11.f5726n
            r12.recycle()
            r11.f5726n = r3
            r11.f5722j = r5
            r11.f5723k = r5
            r11.f5728p = r3
            r11.f5727o = r1
            r11.f5724l = r6
            goto L_0x027d
        L_0x0059:
            android.view.VelocityTracker r12 = r11.f5726n
            if (r12 == 0) goto L_0x027d
            boolean r12 = r11.f5729q
            if (r12 == 0) goto L_0x0063
            goto L_0x027d
        L_0x0063:
            android.view.VelocityTracker r12 = r11.f5726n
            r12.addMovement(r13)
            float r12 = r13.getRawX()
            float r0 = r11.f5722j
            float r12 = r12 - r0
            float r0 = r13.getRawY()
            float r1 = r11.f5723k
            float r0 = r0 - r1
            float r1 = java.lang.Math.abs(r12)
            int r3 = r11.f5714b
            float r3 = (float) r3
            r7 = 1073741824(0x40000000, float:2.0)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x00ba
            float r0 = java.lang.Math.abs(r0)
            float r1 = java.lang.Math.abs(r12)
            float r1 = r1 / r7
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x00ba
            r11.f5724l = r4
            int r0 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r0 <= 0) goto L_0x0099
            int r0 = r11.f5714b
            goto L_0x009c
        L_0x0099:
            int r0 = r11.f5714b
            int r0 = -r0
        L_0x009c:
            r11.f5725m = r0
            SomeCollectionView r0 = r11.f5718f
            r0.mo7183a(r4)
            android.view.MotionEvent r0 = android.view.MotionEvent.obtain(r13)
            int r13 = r13.getActionIndex()
            int r13 = r13 << 8
            r13 = r13 | 3
            r0.setAction(r13)
            SomeCollectionView r13 = r11.f5718f
            r13.mo7182a(r0)
            r0.recycle()
        L_0x00ba:
            boolean r13 = r11.f5724l
            if (r13 == 0) goto L_0x027d
            com.b.a.b$c<> r13 = r11.f5728p
            android.view.View r13 = r13.mo7199a()
            int r0 = r11.f5725m
            float r0 = (float) r0
            float r0 = r12 - r0
            r13.setTranslationX(r0)
            com.b.a.b$c<> r13 = r11.f5728p
            android.view.View r13 = r13.mo7199a()
            float r12 = java.lang.Math.abs(r12)
            float r12 = r12 * r7
            int r0 = r11.f5720h
            float r0 = (float) r0
            float r12 = r12 / r0
            float r12 = r2 - r12
            float r12 = java.lang.Math.min(r2, r12)
            float r12 = java.lang.Math.max(r5, r12)
            r13.setAlpha(r12)
            return r4
        L_0x00ea:
            android.view.VelocityTracker r12 = r11.f5726n
            if (r12 != 0) goto L_0x00f0
            goto L_0x027d
        L_0x00f0:
            float r12 = r13.getRawX()
            float r7 = r11.f5722j
            float r12 = r12 - r7
            android.view.VelocityTracker r7 = r11.f5726n
            r7.addMovement(r13)
            android.view.VelocityTracker r13 = r11.f5726n
            r7 = 1000(0x3e8, float:1.401E-42)
            r13.computeCurrentVelocity(r7)
            android.view.VelocityTracker r13 = r11.f5726n
            float r13 = r13.getXVelocity()
            float r7 = java.lang.Math.abs(r13)
            android.view.VelocityTracker r8 = r11.f5726n
            float r8 = r8.getYVelocity()
            float r8 = java.lang.Math.abs(r8)
            float r9 = java.lang.Math.abs(r12)
            int r10 = r11.f5720h
            int r10 = r10 / r0
            float r0 = (float) r10
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x0131
            boolean r0 = r11.f5724l
            if (r0 == 0) goto L_0x0131
            int r12 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r12 <= 0) goto L_0x012d
            r12 = 1
            goto L_0x012e
        L_0x012d:
            r12 = 0
        L_0x012e:
            r4 = r12
            r12 = 1
            goto L_0x0167
        L_0x0131:
            int r0 = r11.f5715c
            float r0 = (float) r0
            int r0 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r0 > 0) goto L_0x0165
            int r0 = r11.f5716d
            float r0 = (float) r0
            int r0 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r0 > 0) goto L_0x0165
            int r0 = (r8 > r7 ? 1 : (r8 == r7 ? 0 : -1))
            if (r0 >= 0) goto L_0x0165
            boolean r0 = r11.f5724l
            if (r0 == 0) goto L_0x0165
            int r13 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
            if (r13 >= 0) goto L_0x014d
            r13 = 1
            goto L_0x014e
        L_0x014d:
            r13 = 0
        L_0x014e:
            int r12 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r12 >= 0) goto L_0x0154
            r12 = 1
            goto L_0x0155
        L_0x0154:
            r12 = 0
        L_0x0155:
            if (r13 != r12) goto L_0x0159
            r12 = 1
            goto L_0x015a
        L_0x0159:
            r12 = 0
        L_0x015a:
            android.view.VelocityTracker r13 = r11.f5726n
            float r13 = r13.getXVelocity()
            int r13 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
            if (r13 <= 0) goto L_0x0166
            goto L_0x0167
        L_0x0165:
            r12 = 0
        L_0x0166:
            r4 = 0
        L_0x0167:
            if (r12 == 0) goto L_0x019c
            int r12 = r11.f5727o
            if (r12 == r1) goto L_0x019c
            com.b.a.b$c<> r12 = r11.f5728p
            int r13 = r11.f5727o
            com.b.a.b$c<> r0 = r11.f5728p
            android.view.View r0 = r0.mo7199a()
            android.view.ViewPropertyAnimator r0 = r0.animate()
            if (r4 == 0) goto L_0x0181
            int r2 = r11.f5720h
        L_0x017f:
            float r2 = (float) r2
            goto L_0x0185
        L_0x0181:
            int r2 = r11.f5720h
            int r2 = -r2
            goto L_0x017f
        L_0x0185:
            android.view.ViewPropertyAnimator r0 = r0.translationX(r2)
            android.view.ViewPropertyAnimator r0 = r0.alpha(r5)
            long r7 = r11.f5717e
            android.view.ViewPropertyAnimator r0 = r0.setDuration(r7)
            com.b.a.b$1 r2 = new com.b.a.b$1
            r2.<init>(r12, r13)
            r0.setListener(r2)
            goto L_0x01b7
        L_0x019c:
            com.b.a.b$c<> r12 = r11.f5728p
            android.view.View r12 = r12.mo7199a()
            android.view.ViewPropertyAnimator r12 = r12.animate()
            android.view.ViewPropertyAnimator r12 = r12.translationX(r5)
            android.view.ViewPropertyAnimator r12 = r12.alpha(r2)
            long r7 = r11.f5717e
            android.view.ViewPropertyAnimator r12 = r12.setDuration(r7)
            r12.setListener(r3)
        L_0x01b7:
            android.view.VelocityTracker r12 = r11.f5726n
            r12.recycle()
            r11.f5726n = r3
            r11.f5722j = r5
            r11.f5723k = r5
            r11.f5728p = r3
            r11.f5727o = r1
            r11.f5724l = r6
            goto L_0x027d
        L_0x01ca:
            boolean r12 = r11.f5729q
            if (r12 == 0) goto L_0x01cf
            return r6
        L_0x01cf:
            android.graphics.Rect r12 = new android.graphics.Rect
            r12.<init>()
            SomeCollectionView r1 = r11.f5718f
            int r1 = r1.mo7186c()
            int[] r2 = new int[r0]
            SomeCollectionView r5 = r11.f5718f
            r5.mo7184a(r2)
            float r5 = r13.getRawX()
            int r5 = (int) r5
            r7 = r2[r6]
            int r5 = r5 - r7
            float r7 = r13.getRawY()
            int r7 = (int) r7
            r2 = r2[r4]
            int r7 = r7 - r2
            r2 = 0
        L_0x01f2:
            if (r2 >= r1) goto L_0x0248
            SomeCollectionView r8 = r11.f5718f
            android.view.View r8 = r8.mo7181a(r2)
            r8.getHitRect(r12)
            boolean r9 = r12.contains(r5, r7)
            if (r9 == 0) goto L_0x0245
            boolean r12 = f5713a
            if (r12 != 0) goto L_0x021d
            boolean r12 = r8 instanceof android.view.ViewGroup
            if (r12 == 0) goto L_0x0215
            r12 = r8
            android.view.ViewGroup r12 = (android.view.ViewGroup) r12
            int r12 = r12.getChildCount()
            if (r12 != r0) goto L_0x0215
            goto L_0x021d
        L_0x0215:
            java.lang.AssertionError r12 = new java.lang.AssertionError
            java.lang.String r13 = "Each child needs to extend from ViewGroup and have two children"
            r12.<init>(r13)
            throw r12
        L_0x021d:
            com.b.a.b$b<> r12 = r11.f5721i
            if (r12 == 0) goto L_0x0236
            com.b.a.b$b<> r12 = r11.f5721i
            int r12 = r12.f5741a
            SomeCollectionView r0 = r11.f5718f
            int r0 = r0.mo7179a(r8)
            if (r12 != r0) goto L_0x0236
            com.b.a.b$b<> r12 = r11.f5721i
            com.b.a.b$c<> r12 = r12.f5742b
            boolean r12 = r12.f5747d
            if (r12 == 0) goto L_0x0236
            goto L_0x0237
        L_0x0236:
            r4 = 0
        L_0x0237:
            com.b.a.b$c r12 = new com.b.a.b$c
            android.view.ViewGroup r8 = (android.view.ViewGroup) r8
            r12.<init>(r8)
            r11.f5728p = r12
            com.b.a.b$c<> r12 = r11.f5728p
            r12.f5747d = r4
            goto L_0x0248
        L_0x0245:
            int r2 = r2 + 1
            goto L_0x01f2
        L_0x0248:
            com.b.a.b$c<> r12 = r11.f5728p
            if (r12 == 0) goto L_0x027c
            float r12 = r13.getRawX()
            r11.f5722j = r12
            float r12 = r13.getRawY()
            r11.f5723k = r12
            SomeCollectionView r12 = r11.f5718f
            com.b.a.b$c<> r0 = r11.f5728p
            android.view.View r0 = r0.f5744a
            int r12 = r12.mo7179a(r0)
            r11.f5727o = r12
            com.b.a.b$a<SomeCollectionView> r12 = r11.f5719g
            int r0 = r11.f5727o
            boolean r12 = r12.mo7196a(r0)
            if (r12 == 0) goto L_0x027a
            android.view.VelocityTracker r12 = android.view.VelocityTracker.obtain()
            r11.f5726n = r12
            android.view.VelocityTracker r12 = r11.f5726n
            r12.addMovement(r13)
            goto L_0x027c
        L_0x027a:
            r11.f5728p = r3
        L_0x027c:
            return r6
        L_0x027d:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p110b.p111a.C1860b.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7634a(C1867c cVar, int i) {
        if (this.f5721i != null) {
            boolean z = this.f5721i.f5741a != i;
            if (this.f5721i.f5741a < i) {
                i--;
            }
            mo7187a();
            if (z) {
                m7637b(cVar, i);
                return;
            }
            return;
        }
        m7637b(cVar, i);
    }

    /* renamed from: b */
    private void m7637b(C1867c cVar, int i) {
        cVar.f5747d = true;
        cVar.f5746c.setVisibility(0);
        this.f5721i = new C1866b<>(i, cVar);
    }

    /* renamed from: a */
    public boolean mo7187a() {
        boolean b = mo7188b();
        if (b) {
            m7633a(this.f5721i);
        }
        return b;
    }

    /* renamed from: b */
    public boolean mo7188b() {
        return this.f5721i != null && this.f5721i.f5742b.f5747d;
    }

    /* renamed from: c */
    public boolean mo7189c() {
        boolean b = mo7188b();
        if (b) {
            this.f5721i.f5742b.f5746c.setVisibility(8);
            this.f5721i.f5742b.f5745b.animate().translationX(BitmapDescriptorFactory.HUE_RED).alpha(1.0f).setDuration(this.f5717e).setListener(null);
            this.f5721i = null;
        }
        return b;
    }

    /* renamed from: a */
    private void m7633a(final C1866b bVar) {
        this.f5721i = null;
        final LayoutParams layoutParams = bVar.f5742b.f5744a.getLayoutParams();
        final int height = bVar.f5742b.f5744a.getHeight();
        ValueAnimator duration = ValueAnimator.ofInt(new int[]{height, 1}).setDuration(this.f5717e);
        duration.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (C1860b.this.f5719g.mo7196a(bVar.f5741a)) {
                    C1860b.this.f5719g.mo7195a(C1860b.this.f5718f, bVar.f5741a);
                }
                bVar.f5742b.f5745b.post(new Runnable() {
                    public void run() {
                        bVar.f5742b.f5745b.setTranslationX(BitmapDescriptorFactory.HUE_RED);
                        bVar.f5742b.f5745b.setAlpha(1.0f);
                        bVar.f5742b.f5746c.setVisibility(8);
                        bVar.f5742b.f5746c.setTranslationX(BitmapDescriptorFactory.HUE_RED);
                        bVar.f5742b.f5746c.setAlpha(1.0f);
                        layoutParams.height = height;
                        bVar.f5742b.f5744a.setLayoutParams(layoutParams);
                    }
                });
            }
        });
        duration.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                bVar.f5742b.f5744a.setLayoutParams(layoutParams);
            }
        });
        duration.start();
    }
}
