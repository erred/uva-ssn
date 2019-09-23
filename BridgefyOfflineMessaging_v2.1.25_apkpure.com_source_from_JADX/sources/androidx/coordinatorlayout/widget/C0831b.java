package androidx.coordinatorlayout.widget;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* renamed from: androidx.coordinatorlayout.widget.b */
/* compiled from: ViewGroupUtils */
public class C0831b {

    /* renamed from: a */
    private static final ThreadLocal<Matrix> f2713a = new ThreadLocal<>();

    /* renamed from: b */
    private static final ThreadLocal<RectF> f2714b = new ThreadLocal<>();

    /* renamed from: a */
    static void m3082a(ViewGroup viewGroup, View view, Rect rect) {
        Matrix matrix = (Matrix) f2713a.get();
        if (matrix == null) {
            matrix = new Matrix();
            f2713a.set(matrix);
        } else {
            matrix.reset();
        }
        m3083a((ViewParent) viewGroup, view, matrix);
        RectF rectF = (RectF) f2714b.get();
        if (rectF == null) {
            rectF = new RectF();
            f2714b.set(rectF);
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    /* renamed from: b */
    public static void m3084b(ViewGroup viewGroup, View view, Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        m3082a(viewGroup, view, rect);
    }

    /* renamed from: a */
    private static void m3083a(ViewParent viewParent, View view, Matrix matrix) {
        ViewParent parent = view.getParent();
        if ((parent instanceof View) && parent != viewParent) {
            View view2 = (View) parent;
            m3083a(viewParent, view2, matrix);
            matrix.preTranslate((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
        }
        matrix.preTranslate((float) view.getLeft(), (float) view.getTop());
        if (!view.getMatrix().isIdentity()) {
            matrix.preConcat(view.getMatrix());
        }
    }
}
