package androidx.transition;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

/* renamed from: androidx.transition.h */
/* compiled from: PathProperty */
class C1402h<T> extends Property<T, Float> {

    /* renamed from: a */
    private final Property<T, PointF> f4187a;

    /* renamed from: b */
    private final PathMeasure f4188b;

    /* renamed from: c */
    private final float f4189c;

    /* renamed from: d */
    private final float[] f4190d = new float[2];

    /* renamed from: e */
    private final PointF f4191e = new PointF();

    /* renamed from: f */
    private float f4192f;

    C1402h(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.f4187a = property;
        this.f4188b = new PathMeasure(path, false);
        this.f4189c = this.f4188b.getLength();
    }

    /* renamed from: a */
    public Float get(T t) {
        return Float.valueOf(this.f4192f);
    }

    /* renamed from: a */
    public void set(T t, Float f) {
        this.f4192f = f.floatValue();
        this.f4188b.getPosTan(this.f4189c * f.floatValue(), this.f4190d, null);
        this.f4191e.x = this.f4190d[0];
        this.f4191e.y = this.f4190d[1];
        this.f4187a.set(t, this.f4191e);
    }
}
