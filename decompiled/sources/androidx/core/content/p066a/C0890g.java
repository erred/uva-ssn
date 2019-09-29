package androidx.core.content.p066a;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: androidx.core.content.a.g */
/* compiled from: TypedArrayUtils */
public class C0890g {
    /* renamed from: a */
    public static boolean m3304a(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    /* renamed from: a */
    public static float m3298a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, float f) {
        if (!m3304a(xmlPullParser, str)) {
            return f;
        }
        return typedArray.getFloat(i, f);
    }

    /* renamed from: a */
    public static boolean m3303a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, boolean z) {
        if (!m3304a(xmlPullParser, str)) {
            return z;
        }
        return typedArray.getBoolean(i, z);
    }

    /* renamed from: a */
    public static int m3299a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        if (!m3304a(xmlPullParser, str)) {
            return i2;
        }
        return typedArray.getInt(i, i2);
    }

    /* renamed from: b */
    public static int m3305b(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        if (!m3304a(xmlPullParser, str)) {
            return i2;
        }
        return typedArray.getColor(i, i2);
    }

    /* renamed from: a */
    public static C0877b m3301a(TypedArray typedArray, XmlPullParser xmlPullParser, Theme theme, String str, int i, int i2) {
        if (m3304a(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i, typedValue);
            if (typedValue.type >= 28 && typedValue.type <= 31) {
                return C0877b.m3255a(typedValue.data);
            }
            C0877b a = C0877b.m3257a(typedArray.getResources(), typedArray.getResourceId(i, 0), theme);
            if (a != null) {
                return a;
            }
        }
        return C0877b.m3255a(i2);
    }

    /* renamed from: c */
    public static int m3307c(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        if (!m3304a(xmlPullParser, str)) {
            return i2;
        }
        return typedArray.getResourceId(i, i2);
    }

    /* renamed from: a */
    public static String m3302a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i) {
        if (!m3304a(xmlPullParser, str)) {
            return null;
        }
        return typedArray.getString(i);
    }

    /* renamed from: b */
    public static TypedValue m3306b(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i) {
        if (!m3304a(xmlPullParser, str)) {
            return null;
        }
        return typedArray.peekValue(i);
    }

    /* renamed from: a */
    public static TypedArray m3300a(Resources resources, Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}
