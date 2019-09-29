package androidx.transition;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

/* renamed from: androidx.transition.j */
/* compiled from: RectEvaluator */
class C1404j implements TypeEvaluator<Rect> {

    /* renamed from: a */
    private Rect f4193a;

    C1404j() {
    }

    /* renamed from: a */
    public Rect evaluate(float f, Rect rect, Rect rect2) {
        int i = rect.left + ((int) (((float) (rect2.left - rect.left)) * f));
        int i2 = rect.top + ((int) (((float) (rect2.top - rect.top)) * f));
        int i3 = rect.right + ((int) (((float) (rect2.right - rect.right)) * f));
        int i4 = rect.bottom + ((int) (((float) (rect2.bottom - rect.bottom)) * f));
        if (this.f4193a == null) {
            return new Rect(i, i2, i3, i4);
        }
        this.f4193a.set(i, i2, i3, i4);
        return this.f4193a;
    }
}
