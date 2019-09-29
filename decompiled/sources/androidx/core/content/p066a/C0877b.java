package androidx.core.content.p066a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Shader;
import android.util.Log;

/* renamed from: androidx.core.content.a.b */
/* compiled from: ComplexColorCompat */
public final class C0877b {

    /* renamed from: a */
    private final Shader f2832a;

    /* renamed from: b */
    private final ColorStateList f2833b;

    /* renamed from: c */
    private int f2834c;

    private C0877b(Shader shader, ColorStateList colorStateList, int i) {
        this.f2832a = shader;
        this.f2833b = colorStateList;
        this.f2834c = i;
    }

    /* renamed from: a */
    static C0877b m3258a(Shader shader) {
        return new C0877b(shader, null, 0);
    }

    /* renamed from: a */
    static C0877b m3256a(ColorStateList colorStateList) {
        return new C0877b(null, colorStateList, colorStateList.getDefaultColor());
    }

    /* renamed from: a */
    static C0877b m3255a(int i) {
        return new C0877b(null, null, i);
    }

    /* renamed from: a */
    public Shader mo3559a() {
        return this.f2832a;
    }

    /* renamed from: b */
    public int mo3561b() {
        return this.f2834c;
    }

    /* renamed from: b */
    public void mo3562b(int i) {
        this.f2834c = i;
    }

    /* renamed from: c */
    public boolean mo3563c() {
        return this.f2832a != null;
    }

    /* renamed from: d */
    public boolean mo3564d() {
        return this.f2832a == null && this.f2833b != null && this.f2833b.isStateful();
    }

    /* renamed from: a */
    public boolean mo3560a(int[] iArr) {
        if (mo3564d()) {
            int colorForState = this.f2833b.getColorForState(iArr, this.f2833b.getDefaultColor());
            if (colorForState != this.f2834c) {
                this.f2834c = colorForState;
                return true;
            }
        }
        return false;
    }

    /* renamed from: e */
    public boolean mo3565e() {
        return mo3563c() || this.f2834c != 0;
    }

    /* renamed from: a */
    public static C0877b m3257a(Resources resources, int i, Theme theme) {
        try {
            return m3259b(resources, i, theme);
        } catch (Exception e) {
            Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0039, code lost:
        if (r1.equals("gradient") != false) goto L_0x003d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0067  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static androidx.core.content.p066a.C0877b m3259b(android.content.res.Resources r6, int r7, android.content.res.Resources.Theme r8) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException {
        /*
            android.content.res.XmlResourceParser r7 = r6.getXml(r7)
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r7)
        L_0x0008:
            int r1 = r7.next()
            r2 = 1
            r3 = 2
            if (r1 == r3) goto L_0x0013
            if (r1 == r2) goto L_0x0013
            goto L_0x0008
        L_0x0013:
            if (r1 != r3) goto L_0x0070
            java.lang.String r1 = r7.getName()
            r3 = -1
            int r4 = r1.hashCode()
            r5 = 89650992(0x557f730, float:1.01546526E-35)
            if (r4 == r5) goto L_0x0033
            r2 = 1191572447(0x4705f3df, float:34291.87)
            if (r4 == r2) goto L_0x0029
            goto L_0x003c
        L_0x0029:
            java.lang.String r2 = "selector"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x003c
            r2 = 0
            goto L_0x003d
        L_0x0033:
            java.lang.String r4 = "gradient"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x003c
            goto L_0x003d
        L_0x003c:
            r2 = -1
        L_0x003d:
            switch(r2) {
                case 0: goto L_0x0067;
                case 1: goto L_0x005e;
                default: goto L_0x0040;
            }
        L_0x0040:
            org.xmlpull.v1.XmlPullParserException r6 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r7 = r7.getPositionDescription()
            r8.append(r7)
            java.lang.String r7 = ": unsupported complex color tag "
            r8.append(r7)
            r8.append(r1)
            java.lang.String r7 = r8.toString()
            r6.<init>(r7)
            throw r6
        L_0x005e:
            android.graphics.Shader r6 = androidx.core.content.p066a.C0883d.m3286a(r6, r7, r0, r8)
            androidx.core.content.a.b r6 = m3258a(r6)
            return r6
        L_0x0067:
            android.content.res.ColorStateList r6 = androidx.core.content.p066a.C0876a.m3252a(r6, r7, r0, r8)
            androidx.core.content.a.b r6 = m3256a(r6)
            return r6
        L_0x0070:
            org.xmlpull.v1.XmlPullParserException r6 = new org.xmlpull.v1.XmlPullParserException
            java.lang.String r7 = "No start tag found"
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.p066a.C0877b.m3259b(android.content.res.Resources, int, android.content.res.Resources$Theme):androidx.core.content.a.b");
    }
}
