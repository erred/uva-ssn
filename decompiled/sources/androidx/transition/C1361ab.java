package androidx.transition;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.p070g.C0962r;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* renamed from: androidx.transition.ab */
/* compiled from: ViewOverlayApi14 */
class C1361ab implements C1364ad {

    /* renamed from: a */
    protected C1362a f4091a;

    /* renamed from: androidx.transition.ab$a */
    /* compiled from: ViewOverlayApi14 */
    static class C1362a extends ViewGroup {

        /* renamed from: a */
        static Method f4092a;

        /* renamed from: b */
        ViewGroup f4093b;

        /* renamed from: c */
        View f4094c;

        /* renamed from: d */
        ArrayList<Drawable> f4095d = null;

        /* renamed from: e */
        C1361ab f4096e;

        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        /* access modifiers changed from: protected */
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        }

        static {
            try {
                f4092a = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", new Class[]{Integer.TYPE, Integer.TYPE, Rect.class});
            } catch (NoSuchMethodException unused) {
            }
        }

        C1362a(Context context, ViewGroup viewGroup, View view, C1361ab abVar) {
            super(context);
            this.f4093b = viewGroup;
            this.f4094c = view;
            setRight(viewGroup.getWidth());
            setBottom(viewGroup.getHeight());
            viewGroup.addView(this);
            this.f4096e = abVar;
        }

        /* renamed from: a */
        public void mo5700a(Drawable drawable) {
            if (this.f4095d == null) {
                this.f4095d = new ArrayList<>();
            }
            if (!this.f4095d.contains(drawable)) {
                this.f4095d.add(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(this);
            }
        }

        /* renamed from: b */
        public void mo5703b(Drawable drawable) {
            if (this.f4095d != null) {
                this.f4095d.remove(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(null);
            }
        }

        /* access modifiers changed from: protected */
        public boolean verifyDrawable(Drawable drawable) {
            return super.verifyDrawable(drawable) || (this.f4095d != null && this.f4095d.contains(drawable));
        }

        /* renamed from: a */
        public void mo5701a(View view) {
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (!(viewGroup == this.f4093b || viewGroup.getParent() == null || !C0962r.m3543C(viewGroup))) {
                    int[] iArr = new int[2];
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationOnScreen(iArr);
                    this.f4093b.getLocationOnScreen(iArr2);
                    C0962r.m3582g(view, iArr[0] - iArr2[0]);
                    C0962r.m3580f(view, iArr[1] - iArr2[1]);
                }
                viewGroup.removeView(view);
                if (view.getParent() != null) {
                    viewGroup.removeView(view);
                }
            }
            super.addView(view, getChildCount() - 1);
        }

        /* renamed from: b */
        public void mo5704b(View view) {
            super.removeView(view);
            if (mo5702a()) {
                this.f4093b.removeView(this);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo5702a() {
            return getChildCount() == 0 && (this.f4095d == null || this.f4095d.size() == 0);
        }

        public void invalidateDrawable(Drawable drawable) {
            invalidate(drawable.getBounds());
        }

        /* access modifiers changed from: protected */
        public void dispatchDraw(Canvas canvas) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            this.f4093b.getLocationOnScreen(iArr);
            this.f4094c.getLocationOnScreen(iArr2);
            canvas.translate((float) (iArr2[0] - iArr[0]), (float) (iArr2[1] - iArr[1]));
            canvas.clipRect(new Rect(0, 0, this.f4094c.getWidth(), this.f4094c.getHeight()));
            super.dispatchDraw(canvas);
            int size = this.f4095d == null ? 0 : this.f4095d.size();
            for (int i = 0; i < size; i++) {
                ((Drawable) this.f4095d.get(i)).draw(canvas);
            }
        }

        /* renamed from: a */
        private void m5544a(int[] iArr) {
            int[] iArr2 = new int[2];
            int[] iArr3 = new int[2];
            this.f4093b.getLocationOnScreen(iArr2);
            this.f4094c.getLocationOnScreen(iArr3);
            iArr[0] = iArr3[0] - iArr2[0];
            iArr[1] = iArr3[1] - iArr2[1];
        }

        public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
            if (this.f4093b != null) {
                rect.offset(iArr[0], iArr[1]);
                if (this.f4093b instanceof ViewGroup) {
                    iArr[0] = 0;
                    iArr[1] = 0;
                    int[] iArr2 = new int[2];
                    m5544a(iArr2);
                    rect.offset(iArr2[0], iArr2[1]);
                    return super.invalidateChildInParent(iArr, rect);
                }
                invalidate(rect);
            }
            return null;
        }
    }

    C1361ab(Context context, ViewGroup viewGroup, View view) {
        this.f4091a = new C1362a(context, viewGroup, view, this);
    }

    /* renamed from: c */
    static ViewGroup m5540c(View view) {
        while (view != null) {
            if (view.getId() == 16908290 && (view instanceof ViewGroup)) {
                return (ViewGroup) view;
            }
            if (view.getParent() instanceof ViewGroup) {
                view = (ViewGroup) view.getParent();
            }
        }
        return null;
    }

    /* renamed from: d */
    static C1361ab m5541d(View view) {
        ViewGroup c = m5540c(view);
        if (c == null) {
            return null;
        }
        int childCount = c.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = c.getChildAt(i);
            if (childAt instanceof C1362a) {
                return ((C1362a) childAt).f4096e;
            }
        }
        return new C1426v(c.getContext(), c, view);
    }

    /* renamed from: a */
    public void mo5698a(Drawable drawable) {
        this.f4091a.mo5700a(drawable);
    }

    /* renamed from: b */
    public void mo5699b(Drawable drawable) {
        this.f4091a.mo5703b(drawable);
    }
}
