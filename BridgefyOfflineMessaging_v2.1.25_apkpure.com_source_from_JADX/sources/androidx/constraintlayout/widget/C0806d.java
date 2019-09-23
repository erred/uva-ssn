package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: androidx.constraintlayout.widget.d */
/* compiled from: ConstraintLayoutStates */
public class C0806d {

    /* renamed from: a */
    C0809e f2568a;

    /* renamed from: b */
    int f2569b = -1;

    /* renamed from: c */
    int f2570c = -1;

    /* renamed from: d */
    private final ConstraintLayout f2571d;

    /* renamed from: e */
    private SparseArray<C0807a> f2572e = new SparseArray<>();

    /* renamed from: f */
    private SparseArray<C0809e> f2573f = new SparseArray<>();

    /* renamed from: g */
    private C0813g f2574g = null;

    /* renamed from: androidx.constraintlayout.widget.d$a */
    /* compiled from: ConstraintLayoutStates */
    static class C0807a {

        /* renamed from: a */
        int f2575a;

        /* renamed from: b */
        ArrayList<C0808b> f2576b = new ArrayList<>();

        /* renamed from: c */
        int f2577c = -1;

        /* renamed from: d */
        C0809e f2578d;

        public C0807a(Context context, XmlPullParser xmlPullParser) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.State);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.State_android_id) {
                    this.f2575a = obtainStyledAttributes.getResourceId(index, this.f2575a);
                } else if (index == R.styleable.State_constraints) {
                    this.f2577c = obtainStyledAttributes.getResourceId(index, this.f2577c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f2577c);
                    context.getResources().getResourceName(this.f2577c);
                    if ("layout".equals(resourceTypeName)) {
                        this.f2578d = new C0809e();
                        this.f2578d.mo3291a(context, this.f2577c);
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo3288a(C0808b bVar) {
            this.f2576b.add(bVar);
        }

        /* renamed from: a */
        public int mo3287a(float f, float f2) {
            for (int i = 0; i < this.f2576b.size(); i++) {
                if (((C0808b) this.f2576b.get(i)).mo3289a(f, f2)) {
                    return i;
                }
            }
            return -1;
        }
    }

    /* renamed from: androidx.constraintlayout.widget.d$b */
    /* compiled from: ConstraintLayoutStates */
    static class C0808b {

        /* renamed from: a */
        float f2579a = Float.NaN;

        /* renamed from: b */
        float f2580b = Float.NaN;

        /* renamed from: c */
        float f2581c = Float.NaN;

        /* renamed from: d */
        float f2582d = Float.NaN;

        /* renamed from: e */
        int f2583e = -1;

        /* renamed from: f */
        C0809e f2584f;

        public C0808b(Context context, XmlPullParser xmlPullParser) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.Variant);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.Variant_constraints) {
                    this.f2583e = obtainStyledAttributes.getResourceId(index, this.f2583e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f2583e);
                    context.getResources().getResourceName(this.f2583e);
                    if ("layout".equals(resourceTypeName)) {
                        this.f2584f = new C0809e();
                        this.f2584f.mo3291a(context, this.f2583e);
                    }
                } else if (index == R.styleable.Variant_region_heightLessThan) {
                    this.f2582d = obtainStyledAttributes.getDimension(index, this.f2582d);
                } else if (index == R.styleable.Variant_region_heightMoreThan) {
                    this.f2580b = obtainStyledAttributes.getDimension(index, this.f2580b);
                } else if (index == R.styleable.Variant_region_widthLessThan) {
                    this.f2581c = obtainStyledAttributes.getDimension(index, this.f2581c);
                } else if (index == R.styleable.Variant_region_widthMoreThan) {
                    this.f2579a = obtainStyledAttributes.getDimension(index, this.f2579a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            obtainStyledAttributes.recycle();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo3289a(float f, float f2) {
            if (!Float.isNaN(this.f2579a) && f < this.f2579a) {
                return false;
            }
            if (!Float.isNaN(this.f2580b) && f2 < this.f2580b) {
                return false;
            }
            if (!Float.isNaN(this.f2581c) && f > this.f2581c) {
                return false;
            }
            if (Float.isNaN(this.f2582d) || f2 <= this.f2582d) {
                return true;
            }
            return false;
        }
    }

    C0806d(Context context, ConstraintLayout constraintLayout, int i) {
        this.f2571d = constraintLayout;
        m3011a(context, i);
    }

    /* renamed from: a */
    public void mo3285a(int i, float f, float f2) {
        C0809e eVar;
        int i2;
        C0807a aVar;
        C0809e eVar2;
        int i3;
        if (this.f2569b == i) {
            if (i == -1) {
                aVar = (C0807a) this.f2572e.valueAt(0);
            } else {
                aVar = (C0807a) this.f2572e.get(this.f2569b);
            }
            if (this.f2570c == -1 || !((C0808b) aVar.f2576b.get(this.f2570c)).mo3289a(f, f2)) {
                int a = aVar.mo3287a(f, f2);
                if (this.f2570c != a) {
                    if (a == -1) {
                        eVar2 = this.f2568a;
                    } else {
                        eVar2 = ((C0808b) aVar.f2576b.get(a)).f2584f;
                    }
                    if (a == -1) {
                        i3 = aVar.f2577c;
                    } else {
                        i3 = ((C0808b) aVar.f2576b.get(a)).f2583e;
                    }
                    if (eVar2 != null) {
                        this.f2570c = a;
                        if (this.f2574g != null) {
                            this.f2574g.mo3309a(-1, i3);
                        }
                        eVar2.mo3297b(this.f2571d);
                        if (this.f2574g != null) {
                            this.f2574g.mo3310b(-1, i3);
                        }
                    }
                }
            }
        } else {
            this.f2569b = i;
            C0807a aVar2 = (C0807a) this.f2572e.get(this.f2569b);
            int a2 = aVar2.mo3287a(f, f2);
            if (a2 == -1) {
                eVar = aVar2.f2578d;
            } else {
                eVar = ((C0808b) aVar2.f2576b.get(a2)).f2584f;
            }
            if (a2 == -1) {
                i2 = aVar2.f2577c;
            } else {
                i2 = ((C0808b) aVar2.f2576b.get(a2)).f2583e;
            }
            if (eVar == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("NO Constraint set found ! id=");
                sb.append(i);
                sb.append(", dim =");
                sb.append(f);
                sb.append(", ");
                sb.append(f2);
                Log.v("ConstraintLayoutStates", sb.toString());
                return;
            }
            this.f2570c = a2;
            if (this.f2574g != null) {
                this.f2574g.mo3309a(i, i2);
            }
            eVar.mo3297b(this.f2571d);
            if (this.f2574g != null) {
                this.f2574g.mo3310b(i, i2);
            }
        }
    }

    /* renamed from: a */
    public void mo3286a(C0813g gVar) {
        this.f2574g = gVar;
    }

    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m3011a(android.content.Context r6, int r7) {
        /*
            r5 = this;
            android.content.res.Resources r0 = r6.getResources()
            android.content.res.XmlResourceParser r7 = r0.getXml(r7)
            r0 = 0
            int r1 = r7.getEventType()     // Catch:{ XmlPullParserException -> 0x009b, IOException -> 0x0096 }
        L_0x000d:
            r2 = 1
            if (r1 == r2) goto L_0x009f
            if (r1 == 0) goto L_0x008d
            switch(r1) {
                case 2: goto L_0x0017;
                case 3: goto L_0x0090;
                default: goto L_0x0015;
            }     // Catch:{ XmlPullParserException -> 0x009b, IOException -> 0x0096 }
        L_0x0015:
            goto L_0x0090
        L_0x0017:
            java.lang.String r1 = r7.getName()     // Catch:{ XmlPullParserException -> 0x009b, IOException -> 0x0096 }
            r3 = -1
            int r4 = r1.hashCode()     // Catch:{ XmlPullParserException -> 0x009b, IOException -> 0x0096 }
            switch(r4) {
                case -1349929691: goto L_0x004b;
                case 80204913: goto L_0x0041;
                case 1382829617: goto L_0x0038;
                case 1657696882: goto L_0x002e;
                case 1901439077: goto L_0x0024;
                default: goto L_0x0023;
            }     // Catch:{ XmlPullParserException -> 0x009b, IOException -> 0x0096 }
        L_0x0023:
            goto L_0x0055
        L_0x0024:
            java.lang.String r2 = "Variant"
            boolean r2 = r1.equals(r2)     // Catch:{ XmlPullParserException -> 0x009b, IOException -> 0x0096 }
            if (r2 == 0) goto L_0x0055
            r2 = 3
            goto L_0x0056
        L_0x002e:
            java.lang.String r2 = "layoutDescription"
            boolean r2 = r1.equals(r2)     // Catch:{ XmlPullParserException -> 0x009b, IOException -> 0x0096 }
            if (r2 == 0) goto L_0x0055
            r2 = 0
            goto L_0x0056
        L_0x0038:
            java.lang.String r4 = "StateSet"
            boolean r4 = r1.equals(r4)     // Catch:{ XmlPullParserException -> 0x009b, IOException -> 0x0096 }
            if (r4 == 0) goto L_0x0055
            goto L_0x0056
        L_0x0041:
            java.lang.String r2 = "State"
            boolean r2 = r1.equals(r2)     // Catch:{ XmlPullParserException -> 0x009b, IOException -> 0x0096 }
            if (r2 == 0) goto L_0x0055
            r2 = 2
            goto L_0x0056
        L_0x004b:
            java.lang.String r2 = "ConstraintSet"
            boolean r2 = r1.equals(r2)     // Catch:{ XmlPullParserException -> 0x009b, IOException -> 0x0096 }
            if (r2 == 0) goto L_0x0055
            r2 = 4
            goto L_0x0056
        L_0x0055:
            r2 = -1
        L_0x0056:
            switch(r2) {
                case 0: goto L_0x0090;
                case 1: goto L_0x0090;
                case 2: goto L_0x006b;
                case 3: goto L_0x0060;
                case 4: goto L_0x005c;
                default: goto L_0x0059;
            }     // Catch:{ XmlPullParserException -> 0x009b, IOException -> 0x0096 }
        L_0x0059:
            java.lang.String r2 = "ConstraintLayoutStates"
            goto L_0x0078
        L_0x005c:
            r5.m3012a(r6, r7)     // Catch:{ XmlPullParserException -> 0x009b, IOException -> 0x0096 }
            goto L_0x0090
        L_0x0060:
            androidx.constraintlayout.widget.d$b r1 = new androidx.constraintlayout.widget.d$b     // Catch:{ XmlPullParserException -> 0x009b, IOException -> 0x0096 }
            r1.<init>(r6, r7)     // Catch:{ XmlPullParserException -> 0x009b, IOException -> 0x0096 }
            if (r0 == 0) goto L_0x0090
            r0.mo3288a(r1)     // Catch:{ XmlPullParserException -> 0x009b, IOException -> 0x0096 }
            goto L_0x0090
        L_0x006b:
            androidx.constraintlayout.widget.d$a r0 = new androidx.constraintlayout.widget.d$a     // Catch:{ XmlPullParserException -> 0x009b, IOException -> 0x0096 }
            r0.<init>(r6, r7)     // Catch:{ XmlPullParserException -> 0x009b, IOException -> 0x0096 }
            android.util.SparseArray<androidx.constraintlayout.widget.d$a> r1 = r5.f2572e     // Catch:{ XmlPullParserException -> 0x009b, IOException -> 0x0096 }
            int r2 = r0.f2575a     // Catch:{ XmlPullParserException -> 0x009b, IOException -> 0x0096 }
            r1.put(r2, r0)     // Catch:{ XmlPullParserException -> 0x009b, IOException -> 0x0096 }
            goto L_0x0090
        L_0x0078:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x009b, IOException -> 0x0096 }
            r3.<init>()     // Catch:{ XmlPullParserException -> 0x009b, IOException -> 0x0096 }
            java.lang.String r4 = "unknown tag "
            r3.append(r4)     // Catch:{ XmlPullParserException -> 0x009b, IOException -> 0x0096 }
            r3.append(r1)     // Catch:{ XmlPullParserException -> 0x009b, IOException -> 0x0096 }
            java.lang.String r1 = r3.toString()     // Catch:{ XmlPullParserException -> 0x009b, IOException -> 0x0096 }
            android.util.Log.v(r2, r1)     // Catch:{ XmlPullParserException -> 0x009b, IOException -> 0x0096 }
            goto L_0x0090
        L_0x008d:
            r7.getName()     // Catch:{ XmlPullParserException -> 0x009b, IOException -> 0x0096 }
        L_0x0090:
            int r1 = r7.next()     // Catch:{ XmlPullParserException -> 0x009b, IOException -> 0x0096 }
            goto L_0x000d
        L_0x0096:
            r6 = move-exception
            r6.printStackTrace()
            goto L_0x009f
        L_0x009b:
            r6 = move-exception
            r6.printStackTrace()
        L_0x009f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.C0806d.m3011a(android.content.Context, int):void");
    }

    /* renamed from: a */
    private void m3012a(Context context, XmlPullParser xmlPullParser) {
        int i;
        C0809e eVar = new C0809e();
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i2 = 0; i2 < attributeCount; i2++) {
            if ("mId".equals(xmlPullParser.getAttributeName(i2))) {
                String attributeValue = xmlPullParser.getAttributeValue(i2);
                if (attributeValue.contains("/")) {
                    i = context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "mId", null);
                } else {
                    i = -1;
                }
                if (i == -1) {
                    if (attributeValue == null || attributeValue.length() <= 1) {
                        Log.e("ConstraintLayoutStates", "error in parsing mId");
                    } else {
                        i = Integer.parseInt(attributeValue.substring(1));
                    }
                }
                eVar.mo3292a(context, xmlPullParser);
                this.f2573f.put(i, eVar);
                return;
            }
        }
    }
}
