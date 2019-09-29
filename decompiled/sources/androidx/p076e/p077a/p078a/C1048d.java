package androidx.p076e.p077a.p078a;

import android.view.animation.Interpolator;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: androidx.e.a.a.d */
/* compiled from: LookupTableInterpolator */
abstract class C1048d implements Interpolator {

    /* renamed from: a */
    private final float[] f3262a;

    /* renamed from: b */
    private final float f3263b = (1.0f / ((float) (this.f3262a.length - 1)));

    protected C1048d(float[] fArr) {
        this.f3262a = fArr;
    }

    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= BitmapDescriptorFactory.HUE_RED) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        int min = Math.min((int) (((float) (this.f3262a.length - 1)) * f), this.f3262a.length - 2);
        return this.f3262a[min] + (((f - (((float) min) * this.f3263b)) / this.f3263b) * (this.f3262a[min + 1] - this.f3262a[min]));
    }
}
