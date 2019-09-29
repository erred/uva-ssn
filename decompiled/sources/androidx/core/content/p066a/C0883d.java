package androidx.core.content.p066a;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import androidx.core.R;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.measurement.AppMeasurement.Param;
import java.io.IOException;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: androidx.core.content.a.d */
/* compiled from: GradientColorInflaterCompat */
final class C0883d {

    /* renamed from: androidx.core.content.a.d$a */
    /* compiled from: GradientColorInflaterCompat */
    static final class C0884a {

        /* renamed from: a */
        final int[] f2845a;

        /* renamed from: b */
        final float[] f2846b;

        C0884a(List<Integer> list, List<Float> list2) {
            int size = list.size();
            this.f2845a = new int[size];
            this.f2846b = new float[size];
            for (int i = 0; i < size; i++) {
                this.f2845a[i] = ((Integer) list.get(i)).intValue();
                this.f2846b[i] = ((Float) list2.get(i)).floatValue();
            }
        }

        C0884a(int i, int i2) {
            this.f2845a = new int[]{i, i2};
            this.f2846b = new float[]{BitmapDescriptorFactory.HUE_RED, 1.0f};
        }

        C0884a(int i, int i2, int i3) {
            this.f2845a = new int[]{i, i2, i3};
            this.f2846b = new float[]{BitmapDescriptorFactory.HUE_RED, 0.5f, 1.0f};
        }
    }

    /* renamed from: a */
    static Shader m3286a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws IOException, XmlPullParserException {
        XmlPullParser xmlPullParser2 = xmlPullParser;
        String name = xmlPullParser.getName();
        if (name.equals("gradient")) {
            Theme theme2 = theme;
            TypedArray a = C0890g.m3300a(resources, theme2, attributeSet, R.styleable.GradientColor);
            float a2 = C0890g.m3298a(a, xmlPullParser2, "startX", R.styleable.GradientColor_android_startX, (float) BitmapDescriptorFactory.HUE_RED);
            float a3 = C0890g.m3298a(a, xmlPullParser2, "startY", R.styleable.GradientColor_android_startY, (float) BitmapDescriptorFactory.HUE_RED);
            float a4 = C0890g.m3298a(a, xmlPullParser2, "endX", R.styleable.GradientColor_android_endX, (float) BitmapDescriptorFactory.HUE_RED);
            float a5 = C0890g.m3298a(a, xmlPullParser2, "endY", R.styleable.GradientColor_android_endY, (float) BitmapDescriptorFactory.HUE_RED);
            float a6 = C0890g.m3298a(a, xmlPullParser2, "centerX", R.styleable.GradientColor_android_centerX, (float) BitmapDescriptorFactory.HUE_RED);
            float a7 = C0890g.m3298a(a, xmlPullParser2, "centerY", R.styleable.GradientColor_android_centerY, (float) BitmapDescriptorFactory.HUE_RED);
            int a8 = C0890g.m3299a(a, xmlPullParser2, Param.TYPE, R.styleable.GradientColor_android_type, 0);
            int b = C0890g.m3305b(a, xmlPullParser2, "startColor", R.styleable.GradientColor_android_startColor, 0);
            boolean a9 = C0890g.m3304a(xmlPullParser2, "centerColor");
            int b2 = C0890g.m3305b(a, xmlPullParser2, "centerColor", R.styleable.GradientColor_android_centerColor, 0);
            int b3 = C0890g.m3305b(a, xmlPullParser2, "endColor", R.styleable.GradientColor_android_endColor, 0);
            int a10 = C0890g.m3299a(a, xmlPullParser2, "tileMode", R.styleable.GradientColor_android_tileMode, 0);
            float f = a5;
            float a11 = C0890g.m3298a(a, xmlPullParser2, "gradientRadius", R.styleable.GradientColor_android_gradientRadius, (float) BitmapDescriptorFactory.HUE_RED);
            a.recycle();
            C0884a a12 = m3287a(m3288b(resources, xmlPullParser, attributeSet, theme), b, b3, a9, b2);
            switch (a8) {
                case 1:
                    if (a11 > BitmapDescriptorFactory.HUE_RED) {
                        int[] iArr = a12.f2845a;
                        RadialGradient radialGradient = new RadialGradient(a6, a7, a11, iArr, a12.f2846b, m3285a(a10));
                        return radialGradient;
                    }
                    throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
                case 2:
                    return new SweepGradient(a6, a7, a12.f2845a, a12.f2846b);
                default:
                    LinearGradient linearGradient = new LinearGradient(a2, a3, a4, f, a12.f2845a, a12.f2846b, m3285a(a10));
                    return linearGradient;
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(xmlPullParser.getPositionDescription());
            sb.append(": invalid gradient color tag ");
            sb.append(name);
            throw new XmlPullParserException(sb.toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0089, code lost:
        throw new org.xmlpull.v1.XmlPullParserException(r10.toString());
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static androidx.core.content.p066a.C0883d.C0884a m3288b(android.content.res.Resources r8, org.xmlpull.v1.XmlPullParser r9, android.util.AttributeSet r10, android.content.res.Resources.Theme r11) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            int r0 = r9.getDepth()
            r1 = 1
            int r0 = r0 + r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 20
            r2.<init>(r3)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r3)
        L_0x0012:
            int r3 = r9.next()
            if (r3 == r1) goto L_0x008a
            int r5 = r9.getDepth()
            if (r5 >= r0) goto L_0x0021
            r6 = 3
            if (r3 == r6) goto L_0x008a
        L_0x0021:
            r6 = 2
            if (r3 == r6) goto L_0x0025
            goto L_0x0012
        L_0x0025:
            if (r5 > r0) goto L_0x0012
            java.lang.String r3 = r9.getName()
            java.lang.String r5 = "item"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x0034
            goto L_0x0012
        L_0x0034:
            int[] r3 = androidx.core.R.styleable.GradientColorItem
            android.content.res.TypedArray r3 = androidx.core.content.p066a.C0890g.m3300a(r8, r11, r10, r3)
            int r5 = androidx.core.R.styleable.GradientColorItem_android_color
            boolean r5 = r3.hasValue(r5)
            int r6 = androidx.core.R.styleable.GradientColorItem_android_offset
            boolean r6 = r3.hasValue(r6)
            if (r5 == 0) goto L_0x006a
            if (r6 == 0) goto L_0x006a
            int r5 = androidx.core.R.styleable.GradientColorItem_android_color
            r6 = 0
            int r5 = r3.getColor(r5, r6)
            int r6 = androidx.core.R.styleable.GradientColorItem_android_offset
            r7 = 0
            float r6 = r3.getFloat(r6, r7)
            r3.recycle()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            r4.add(r3)
            java.lang.Float r3 = java.lang.Float.valueOf(r6)
            r2.add(r3)
            goto L_0x0012
        L_0x006a:
            org.xmlpull.v1.XmlPullParserException r8 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r9 = r9.getPositionDescription()
            r10.append(r9)
            java.lang.String r9 = ": <item> tag requires a 'color' attribute and a 'offset' "
            r10.append(r9)
            java.lang.String r9 = "attribute!"
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            r8.<init>(r9)
            throw r8
        L_0x008a:
            int r8 = r4.size()
            if (r8 <= 0) goto L_0x0096
            androidx.core.content.a.d$a r8 = new androidx.core.content.a.d$a
            r8.<init>(r4, r2)
            return r8
        L_0x0096:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.p066a.C0883d.m3288b(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):androidx.core.content.a.d$a");
    }

    /* renamed from: a */
    private static C0884a m3287a(C0884a aVar, int i, int i2, boolean z, int i3) {
        if (aVar != null) {
            return aVar;
        }
        if (z) {
            return new C0884a(i, i3, i2);
        }
        return new C0884a(i, i2);
    }

    /* renamed from: a */
    private static TileMode m3285a(int i) {
        switch (i) {
            case 1:
                return TileMode.REPEAT;
            case 2:
                return TileMode.MIRROR;
            default:
                return TileMode.CLAMP;
        }
    }
}
