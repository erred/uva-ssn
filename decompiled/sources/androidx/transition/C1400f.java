package androidx.transition;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.util.Property;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: androidx.transition.f */
/* compiled from: ObjectAnimatorUtils */
class C1400f {
    /* renamed from: a */
    static <T> ObjectAnimator m5658a(T t, Property<T, PointF> property, Path path) {
        if (VERSION.SDK_INT >= 21) {
            return ObjectAnimator.ofObject(t, property, null, path);
        }
        return ObjectAnimator.ofFloat(t, new C1402h(property, path), new float[]{BitmapDescriptorFactory.HUE_RED, 1.0f});
    }
}
