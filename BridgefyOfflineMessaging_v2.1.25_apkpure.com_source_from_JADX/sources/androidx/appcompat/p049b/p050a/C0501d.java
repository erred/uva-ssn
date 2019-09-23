package androidx.appcompat.p049b.p050a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.R;
import androidx.appcompat.p047a.p048a.C0424a;
import androidx.core.content.p066a.C0890g;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: androidx.appcompat.b.a.d */
/* compiled from: StateListDrawable */
class C0501d extends C0496b {

    /* renamed from: a */
    private C0502a f1208a;

    /* renamed from: b */
    private boolean f1209b;

    /* renamed from: androidx.appcompat.b.a.d$a */
    /* compiled from: StateListDrawable */
    static class C0502a extends C0499b {

        /* renamed from: L */
        int[][] f1210L;

        C0502a(C0502a aVar, C0501d dVar, Resources resources) {
            super(aVar, dVar, resources);
            if (aVar != null) {
                this.f1210L = aVar.f1210L;
            } else {
                this.f1210L = new int[mo1185c()][];
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo1155a() {
            int[][] iArr = new int[this.f1210L.length][];
            for (int length = this.f1210L.length - 1; length >= 0; length--) {
                iArr[length] = this.f1210L[length] != null ? (int[]) this.f1210L[length].clone() : null;
            }
            this.f1210L = iArr;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public int mo1238a(int[] iArr, Drawable drawable) {
            int a = mo1178a(drawable);
            this.f1210L[a] = iArr;
            return a;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public int mo1239b(int[] iArr) {
            int[][] iArr2 = this.f1210L;
            int d = mo1188d();
            for (int i = 0; i < d; i++) {
                if (StateSet.stateSetMatches(iArr2[i], iArr)) {
                    return i;
                }
            }
            return -1;
        }

        public Drawable newDrawable() {
            return new C0501d(this, null);
        }

        public Drawable newDrawable(Resources resources) {
            return new C0501d(this, resources);
        }

        /* renamed from: e */
        public void mo1192e(int i, int i2) {
            super.mo1192e(i, i2);
            int[][] iArr = new int[i2][];
            System.arraycopy(this.f1210L, 0, iArr, 0, i);
            this.f1210L = iArr;
        }
    }

    public boolean isStateful() {
        return true;
    }

    C0501d() {
        this(null, null);
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        int b = this.f1208a.mo1239b(iArr);
        if (b < 0) {
            b = this.f1208a.mo1239b(StateSet.WILD_CARD);
        }
        return mo1167a(b) || onStateChange;
    }

    /* renamed from: b */
    public void mo1115b(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        TypedArray a = C0890g.m3300a(resources, theme, attributeSet, R.styleable.StateListDrawable);
        setVisible(a.getBoolean(R.styleable.StateListDrawable_android_visible, true), true);
        m1623a(a);
        mo1165a(resources);
        a.recycle();
        m1622a(context, resources, xmlPullParser, attributeSet, theme);
        onStateChange(getState());
    }

    /* renamed from: a */
    private void m1623a(TypedArray typedArray) {
        C0502a aVar = this.f1208a;
        if (VERSION.SDK_INT >= 21) {
            aVar.f1187f |= typedArray.getChangingConfigurations();
        }
        aVar.f1192k = typedArray.getBoolean(R.styleable.StateListDrawable_android_variablePadding, aVar.f1192k);
        aVar.f1195n = typedArray.getBoolean(R.styleable.StateListDrawable_android_constantSize, aVar.f1195n);
        aVar.f1175C = typedArray.getInt(R.styleable.StateListDrawable_android_enterFadeDuration, aVar.f1175C);
        aVar.f1176D = typedArray.getInt(R.styleable.StateListDrawable_android_exitFadeDuration, aVar.f1176D);
        aVar.f1207z = typedArray.getBoolean(R.styleable.StateListDrawable_android_dither, aVar.f1207z);
    }

    /* renamed from: a */
    private void m1622a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        int next;
        C0502a aVar = this.f1208a;
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next2 = xmlPullParser.next();
            if (next2 != 1) {
                int depth2 = xmlPullParser.getDepth();
                if (depth2 < depth && next2 == 3) {
                    return;
                }
                if (next2 == 2 && depth2 <= depth && xmlPullParser.getName().equals("item")) {
                    TypedArray a = C0890g.m3300a(resources, theme, attributeSet, R.styleable.StateListDrawableItem);
                    Drawable drawable = null;
                    int resourceId = a.getResourceId(R.styleable.StateListDrawableItem_android_drawable, -1);
                    if (resourceId > 0) {
                        drawable = C0424a.m1270b(context, resourceId);
                    }
                    a.recycle();
                    int[] a2 = mo1237a(attributeSet);
                    if (drawable == null) {
                        do {
                            next = xmlPullParser.next();
                        } while (next == 4);
                        if (next != 2) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(xmlPullParser.getPositionDescription());
                            sb.append(": <item> tag requires a 'drawable' attribute or ");
                            sb.append("child tag defining a drawable");
                            throw new XmlPullParserException(sb.toString());
                        } else if (VERSION.SDK_INT >= 21) {
                            drawable = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
                        } else {
                            drawable = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
                        }
                    }
                    aVar.mo1238a(a2, drawable);
                }
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int[] mo1237a(AttributeSet attributeSet) {
        int attributeCount = attributeSet.getAttributeCount();
        int[] iArr = new int[attributeCount];
        int i = 0;
        for (int i2 = 0; i2 < attributeCount; i2++) {
            int attributeNameResource = attributeSet.getAttributeNameResource(i2);
            if (!(attributeNameResource == 0 || attributeNameResource == 16842960 || attributeNameResource == 16843161)) {
                int i3 = i + 1;
                if (!attributeSet.getAttributeBooleanValue(i2, false)) {
                    attributeNameResource = -attributeNameResource;
                }
                iArr[i] = attributeNameResource;
                i = i3;
            }
        }
        return StateSet.trimStateSet(iArr, i);
    }

    public Drawable mutate() {
        if (!this.f1209b && super.mutate() == this) {
            this.f1208a.mo1155a();
            this.f1209b = true;
        }
        return this;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C0502a mo1116c() {
        return new C0502a(this.f1208a, this, null);
    }

    public void applyTheme(Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo1112a(C0499b bVar) {
        super.mo1112a(bVar);
        if (bVar instanceof C0502a) {
            this.f1208a = (C0502a) bVar;
        }
    }

    C0501d(C0502a aVar, Resources resources) {
        mo1112a((C0499b) new C0502a(aVar, this, resources));
        onStateChange(getState());
    }

    C0501d(C0502a aVar) {
        if (aVar != null) {
            mo1112a((C0499b) aVar);
        }
    }
}
