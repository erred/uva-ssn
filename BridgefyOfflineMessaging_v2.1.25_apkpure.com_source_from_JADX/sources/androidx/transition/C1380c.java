package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.p070g.C0962r;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: androidx.transition.c */
/* compiled from: ChangeBounds */
public class C1380c extends C1407m {

    /* renamed from: a */
    private static final String[] f4132a = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};

    /* renamed from: b */
    private static final Property<Drawable, PointF> f4133b = new Property<Drawable, PointF>(PointF.class, "boundsOrigin") {

        /* renamed from: a */
        private Rect f4143a = new Rect();

        /* renamed from: a */
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.f4143a);
            this.f4143a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.f4143a);
        }

        /* renamed from: a */
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.f4143a);
            return new PointF((float) this.f4143a.left, (float) this.f4143a.top);
        }
    };

    /* renamed from: c */
    private static final Property<C1391a, PointF> f4134c = new Property<C1391a, PointF>(PointF.class, "topLeft") {
        /* renamed from: a */
        public PointF get(C1391a aVar) {
            return null;
        }

        /* renamed from: a */
        public void set(C1391a aVar, PointF pointF) {
            aVar.mo5777a(pointF);
        }
    };

    /* renamed from: d */
    private static final Property<C1391a, PointF> f4135d = new Property<C1391a, PointF>(PointF.class, "bottomRight") {
        /* renamed from: a */
        public PointF get(C1391a aVar) {
            return null;
        }

        /* renamed from: a */
        public void set(C1391a aVar, PointF pointF) {
            aVar.mo5778b(pointF);
        }
    };

    /* renamed from: e */
    private static final Property<View, PointF> f4136e = new Property<View, PointF>(PointF.class, "bottomRight") {
        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        /* renamed from: a */
        public void set(View view, PointF pointF) {
            C1365ae.m5558a(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    };

    /* renamed from: f */
    private static final Property<View, PointF> f4137f = new Property<View, PointF>(PointF.class, "topLeft") {
        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        /* renamed from: a */
        public void set(View view, PointF pointF) {
            C1365ae.m5558a(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    };

    /* renamed from: g */
    private static final Property<View, PointF> f4138g = new Property<View, PointF>(PointF.class, "position") {
        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        /* renamed from: a */
        public void set(View view, PointF pointF) {
            int round = Math.round(pointF.x);
            int round2 = Math.round(pointF.y);
            C1365ae.m5558a(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
        }
    };

    /* renamed from: k */
    private static C1404j f4139k = new C1404j();

    /* renamed from: h */
    private int[] f4140h = new int[2];

    /* renamed from: i */
    private boolean f4141i = false;

    /* renamed from: j */
    private boolean f4142j = false;

    /* renamed from: androidx.transition.c$a */
    /* compiled from: ChangeBounds */
    private static class C1391a {

        /* renamed from: a */
        private int f4162a;

        /* renamed from: b */
        private int f4163b;

        /* renamed from: c */
        private int f4164c;

        /* renamed from: d */
        private int f4165d;

        /* renamed from: e */
        private View f4166e;

        /* renamed from: f */
        private int f4167f;

        /* renamed from: g */
        private int f4168g;

        C1391a(View view) {
            this.f4166e = view;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo5777a(PointF pointF) {
            this.f4162a = Math.round(pointF.x);
            this.f4163b = Math.round(pointF.y);
            this.f4167f++;
            if (this.f4167f == this.f4168g) {
                m5621a();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo5778b(PointF pointF) {
            this.f4164c = Math.round(pointF.x);
            this.f4165d = Math.round(pointF.y);
            this.f4168g++;
            if (this.f4167f == this.f4168g) {
                m5621a();
            }
        }

        /* renamed from: a */
        private void m5621a() {
            C1365ae.m5558a(this.f4166e, this.f4162a, this.f4163b, this.f4164c, this.f4165d);
            this.f4167f = 0;
            this.f4168g = 0;
        }
    }

    public String[] getTransitionProperties() {
        return f4132a;
    }

    /* renamed from: a */
    private void m5603a(C1424t tVar) {
        View view = tVar.f4234b;
        if (C0962r.m3603z(view) || view.getWidth() != 0 || view.getHeight() != 0) {
            tVar.f4233a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            tVar.f4233a.put("android:changeBounds:parent", tVar.f4234b.getParent());
            if (this.f4142j) {
                tVar.f4234b.getLocationInWindow(this.f4140h);
                tVar.f4233a.put("android:changeBounds:windowX", Integer.valueOf(this.f4140h[0]));
                tVar.f4233a.put("android:changeBounds:windowY", Integer.valueOf(this.f4140h[1]));
            }
            if (this.f4141i) {
                tVar.f4233a.put("android:changeBounds:clip", C0962r.m3542B(view));
            }
        }
    }

    public void captureStartValues(C1424t tVar) {
        m5603a(tVar);
    }

    public void captureEndValues(C1424t tVar) {
        m5603a(tVar);
    }

    /* renamed from: a */
    private boolean m5604a(View view, View view2) {
        if (!this.f4142j) {
            return true;
        }
        C1424t matchedTransitionValues = getMatchedTransitionValues(view, true);
        if (matchedTransitionValues == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == matchedTransitionValues.f4234b) {
            return true;
        }
        return false;
    }

    public Animator createAnimator(ViewGroup viewGroup, C1424t tVar, C1424t tVar2) {
        int i;
        View view;
        Animator animator;
        Animator animator2;
        int i2;
        Rect rect;
        ObjectAnimator objectAnimator;
        C1424t tVar3 = tVar;
        C1424t tVar4 = tVar2;
        if (tVar3 == null || tVar4 == null) {
            return null;
        }
        ViewGroup viewGroup2 = (ViewGroup) tVar3.f4233a.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) tVar4.f4233a.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = tVar4.f4234b;
        if (m5604a(viewGroup2, viewGroup3)) {
            Rect rect2 = (Rect) tVar3.f4233a.get("android:changeBounds:bounds");
            Rect rect3 = (Rect) tVar4.f4233a.get("android:changeBounds:bounds");
            int i3 = rect2.left;
            int i4 = rect3.left;
            int i5 = rect2.top;
            int i6 = rect3.top;
            int i7 = rect2.right;
            int i8 = rect3.right;
            int i9 = rect2.bottom;
            int i10 = rect3.bottom;
            int i11 = i7 - i3;
            int i12 = i9 - i5;
            int i13 = i8 - i4;
            int i14 = i10 - i6;
            View view3 = view2;
            Rect rect4 = (Rect) tVar3.f4233a.get("android:changeBounds:clip");
            Rect rect5 = (Rect) tVar4.f4233a.get("android:changeBounds:clip");
            if ((i11 == 0 || i12 == 0) && (i13 == 0 || i14 == 0)) {
                i = 0;
            } else {
                i = (i3 == i4 && i5 == i6) ? 0 : 1;
                if (!(i7 == i8 && i9 == i10)) {
                    i++;
                }
            }
            if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
                i++;
            }
            if (i > 0) {
                Rect rect6 = rect5;
                Rect rect7 = rect4;
                if (!this.f4141i) {
                    view = view3;
                    C1365ae.m5558a(view, i3, i5, i7, i9);
                    if (i == 2) {
                        if (i11 == i13 && i12 == i14) {
                            animator = C1400f.m5658a(view, f4138g, getPathMotion().mo5782a((float) i3, (float) i5, (float) i4, (float) i6));
                        } else {
                            final C1391a aVar = new C1391a(view);
                            ObjectAnimator a = C1400f.m5658a(aVar, f4134c, getPathMotion().mo5782a((float) i3, (float) i5, (float) i4, (float) i6));
                            ObjectAnimator a2 = C1400f.m5658a(aVar, f4135d, getPathMotion().mo5782a((float) i7, (float) i9, (float) i8, (float) i10));
                            AnimatorSet animatorSet = new AnimatorSet();
                            animatorSet.playTogether(new Animator[]{a, a2});
                            animatorSet.addListener(new AnimatorListenerAdapter() {
                                private C1391a mViewBounds = aVar;
                            });
                            animator = animatorSet;
                        }
                    } else if (i3 == i4 && i5 == i6) {
                        animator = C1400f.m5658a(view, f4136e, getPathMotion().mo5782a((float) i7, (float) i9, (float) i8, (float) i10));
                    } else {
                        animator = C1400f.m5658a(view, f4137f, getPathMotion().mo5782a((float) i3, (float) i5, (float) i4, (float) i6));
                    }
                } else {
                    view = view3;
                    C1365ae.m5558a(view, i3, i5, Math.max(i11, i13) + i3, Math.max(i12, i14) + i5);
                    if (i3 == i4 && i5 == i6) {
                        animator2 = null;
                    } else {
                        animator2 = C1400f.m5658a(view, f4138g, getPathMotion().mo5782a((float) i3, (float) i5, (float) i4, (float) i6));
                    }
                    if (rect7 == null) {
                        i2 = 0;
                        rect = new Rect(0, 0, i11, i12);
                    } else {
                        i2 = 0;
                        rect = rect7;
                    }
                    Rect rect8 = rect6 == null ? new Rect(i2, i2, i13, i14) : rect6;
                    if (!rect.equals(rect8)) {
                        C0962r.m3556a(view, rect);
                        C1404j jVar = f4139k;
                        Object[] objArr = new Object[2];
                        objArr[i2] = rect;
                        objArr[1] = rect8;
                        objectAnimator = ObjectAnimator.ofObject(view, "clipBounds", jVar, objArr);
                        final View view4 = view;
                        final Rect rect9 = rect6;
                        final int i15 = i4;
                        final int i16 = i6;
                        final int i17 = i8;
                        final int i18 = i10;
                        C13909 r0 = new AnimatorListenerAdapter() {

                            /* renamed from: h */
                            private boolean f4161h;

                            public void onAnimationCancel(Animator animator) {
                                this.f4161h = true;
                            }

                            public void onAnimationEnd(Animator animator) {
                                if (!this.f4161h) {
                                    C0962r.m3556a(view4, rect9);
                                    C1365ae.m5558a(view4, i15, i16, i17, i18);
                                }
                            }
                        };
                        objectAnimator.addListener(r0);
                    } else {
                        objectAnimator = null;
                    }
                    animator = C1423s.m5712a(animator2, objectAnimator);
                }
                if (view.getParent() instanceof ViewGroup) {
                    final ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                    C1429y.m5725a(viewGroup4, true);
                    addListener(new C1415n() {

                        /* renamed from: a */
                        boolean f4144a = false;

                        /* renamed from: a */
                        public void mo5737a(C1407m mVar) {
                            C1429y.m5725a(viewGroup4, false);
                            this.f4144a = true;
                        }

                        /* renamed from: b */
                        public void mo5738b(C1407m mVar) {
                            if (!this.f4144a) {
                                C1429y.m5725a(viewGroup4, false);
                            }
                            mVar.removeListener(this);
                        }

                        /* renamed from: c */
                        public void mo5739c(C1407m mVar) {
                            C1429y.m5725a(viewGroup4, false);
                        }

                        /* renamed from: d */
                        public void mo5740d(C1407m mVar) {
                            C1429y.m5725a(viewGroup4, true);
                        }
                    });
                }
                return animator;
            }
        } else {
            int intValue = ((Integer) tVar3.f4233a.get("android:changeBounds:windowX")).intValue();
            int intValue2 = ((Integer) tVar3.f4233a.get("android:changeBounds:windowY")).intValue();
            int intValue3 = ((Integer) tVar4.f4233a.get("android:changeBounds:windowX")).intValue();
            int intValue4 = ((Integer) tVar4.f4233a.get("android:changeBounds:windowY")).intValue();
            if (!(intValue == intValue3 && intValue2 == intValue4)) {
                viewGroup.getLocationInWindow(this.f4140h);
                Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Config.ARGB_8888);
                view2.draw(new Canvas(createBitmap));
                BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
                float c = C1365ae.m5562c(view2);
                C1365ae.m5556a(view2, (float) BitmapDescriptorFactory.HUE_RED);
                C1365ae.m5554a(viewGroup).mo5698a(bitmapDrawable);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, new PropertyValuesHolder[]{C1403i.m5662a(f4133b, getPathMotion().mo5782a((float) (intValue - this.f4140h[0]), (float) (intValue2 - this.f4140h[1]), (float) (intValue3 - this.f4140h[0]), (float) (intValue4 - this.f4140h[1])))});
                final ViewGroup viewGroup5 = viewGroup;
                final BitmapDrawable bitmapDrawable2 = bitmapDrawable;
                final View view5 = view2;
                final float f = c;
                C13832 r02 = new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        C1365ae.m5554a(viewGroup5).mo5699b(bitmapDrawable2);
                        C1365ae.m5556a(view5, f);
                    }
                };
                ofPropertyValuesHolder.addListener(r02);
                return ofPropertyValuesHolder;
            }
        }
        return null;
    }
}
