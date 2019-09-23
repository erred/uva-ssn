package androidx.vectordrawable.p089a.p090a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import androidx.core.content.p066a.C0890g;
import androidx.core.graphics.C0978b;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: androidx.vectordrawable.a.a.g */
/* compiled from: PathInterpolatorCompat */
public class C1446g implements Interpolator {

    /* renamed from: a */
    private float[] f4273a;

    /* renamed from: b */
    private float[] f4274b;

    public C1446g(Context context, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        this(context.getResources(), context.getTheme(), attributeSet, xmlPullParser);
    }

    public C1446g(Resources resources, Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray a = C0890g.m3300a(resources, theme, attributeSet, C1436a.f4257l);
        m5757a(a, xmlPullParser);
        a.recycle();
    }

    /* renamed from: a */
    private void m5757a(TypedArray typedArray, XmlPullParser xmlPullParser) {
        if (C0890g.m3304a(xmlPullParser, "pathData")) {
            String a = C0890g.m3302a(typedArray, xmlPullParser, "pathData", 4);
            Path a2 = C0978b.m3663a(a);
            if (a2 != null) {
                m5758a(a2);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("The path is null, which is created from ");
            sb.append(a);
            throw new InflateException(sb.toString());
        } else if (!C0890g.m3304a(xmlPullParser, "controlX1")) {
            throw new InflateException("pathInterpolator requires the controlX1 attribute");
        } else if (C0890g.m3304a(xmlPullParser, "controlY1")) {
            float a3 = C0890g.m3298a(typedArray, xmlPullParser, "controlX1", 0, (float) BitmapDescriptorFactory.HUE_RED);
            float a4 = C0890g.m3298a(typedArray, xmlPullParser, "controlY1", 1, (float) BitmapDescriptorFactory.HUE_RED);
            boolean a5 = C0890g.m3304a(xmlPullParser, "controlX2");
            if (a5 != C0890g.m3304a(xmlPullParser, "controlY2")) {
                throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
            } else if (!a5) {
                m5755a(a3, a4);
            } else {
                m5756a(a3, a4, C0890g.m3298a(typedArray, xmlPullParser, "controlX2", 2, (float) BitmapDescriptorFactory.HUE_RED), C0890g.m3298a(typedArray, xmlPullParser, "controlY2", 3, (float) BitmapDescriptorFactory.HUE_RED));
            }
        } else {
            throw new InflateException("pathInterpolator requires the controlY1 attribute");
        }
    }

    /* renamed from: a */
    private void m5755a(float f, float f2) {
        Path path = new Path();
        path.moveTo(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
        path.quadTo(f, f2, 1.0f, 1.0f);
        m5758a(path);
    }

    /* renamed from: a */
    private void m5756a(float f, float f2, float f3, float f4) {
        Path path = new Path();
        path.moveTo(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
        path.cubicTo(f, f2, f3, f4, 1.0f, 1.0f);
        m5758a(path);
    }

    /* renamed from: a */
    private void m5758a(Path path) {
        int i = 0;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int min = Math.min(AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS, ((int) (length / 0.002f)) + 1);
        if (min > 0) {
            this.f4273a = new float[min];
            this.f4274b = new float[min];
            float[] fArr = new float[2];
            for (int i2 = 0; i2 < min; i2++) {
                pathMeasure.getPosTan((((float) i2) * length) / ((float) (min - 1)), fArr, null);
                this.f4273a[i2] = fArr[0];
                this.f4274b[i2] = fArr[1];
            }
            if (((double) Math.abs(this.f4273a[0])) <= 1.0E-5d && ((double) Math.abs(this.f4274b[0])) <= 1.0E-5d) {
                int i3 = min - 1;
                if (((double) Math.abs(this.f4273a[i3] - 1.0f)) <= 1.0E-5d && ((double) Math.abs(this.f4274b[i3] - 1.0f)) <= 1.0E-5d) {
                    int i4 = 0;
                    float f = BitmapDescriptorFactory.HUE_RED;
                    while (i < min) {
                        int i5 = i4 + 1;
                        float f2 = this.f4273a[i4];
                        if (f2 >= f) {
                            this.f4273a[i] = f2;
                            i++;
                            f = f2;
                            i4 = i5;
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append("The Path cannot loop back on itself, x :");
                            sb.append(f2);
                            throw new IllegalArgumentException(sb.toString());
                        }
                    }
                    if (pathMeasure.nextContour()) {
                        throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
                    }
                    return;
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("The Path must start at (0,0) and end at (1,1) start: ");
            sb2.append(this.f4273a[0]);
            sb2.append(",");
            sb2.append(this.f4274b[0]);
            sb2.append(" end:");
            int i6 = min - 1;
            sb2.append(this.f4273a[i6]);
            sb2.append(",");
            sb2.append(this.f4274b[i6]);
            throw new IllegalArgumentException(sb2.toString());
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("The Path has a invalid length ");
        sb3.append(length);
        throw new IllegalArgumentException(sb3.toString());
    }

    public float getInterpolation(float f) {
        if (f <= BitmapDescriptorFactory.HUE_RED) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int i = 0;
        int length = this.f4273a.length - 1;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f < this.f4273a[i2]) {
                length = i2;
            } else {
                i = i2;
            }
        }
        float f2 = this.f4273a[length] - this.f4273a[i];
        if (f2 == BitmapDescriptorFactory.HUE_RED) {
            return this.f4274b[i];
        }
        float f3 = (f - this.f4273a[i]) / f2;
        float f4 = this.f4274b[i];
        return f4 + (f3 * (this.f4274b[length] - f4));
    }
}
