package androidx.appcompat.p049b.p050a;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.R;
import androidx.appcompat.p047a.p048a.C0424a;
import androidx.core.content.p066a.C0890g;
import androidx.p052b.C0717d;
import androidx.p052b.C0726h;
import androidx.vectordrawable.p089a.p090a.C1438c;
import androidx.vectordrawable.p089a.p090a.C1448i;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: androidx.appcompat.b.a.a */
/* compiled from: AnimatedStateListDrawableCompat */
public class C0488a extends C0501d {

    /* renamed from: a */
    private static final String f1143a = "a";

    /* renamed from: b */
    private C0491b f1144b;

    /* renamed from: c */
    private C0495f f1145c;

    /* renamed from: d */
    private int f1146d;

    /* renamed from: e */
    private int f1147e;

    /* renamed from: f */
    private boolean f1148f;

    /* renamed from: androidx.appcompat.b.a.a$a */
    /* compiled from: AnimatedStateListDrawableCompat */
    private static class C0490a extends C0495f {

        /* renamed from: a */
        private final Animatable f1149a;

        C0490a(Animatable animatable) {
            super();
            this.f1149a = animatable;
        }

        /* renamed from: a */
        public void mo1148a() {
            this.f1149a.start();
        }

        /* renamed from: b */
        public void mo1149b() {
            this.f1149a.stop();
        }
    }

    /* renamed from: androidx.appcompat.b.a.a$b */
    /* compiled from: AnimatedStateListDrawableCompat */
    static class C0491b extends C0502a {

        /* renamed from: a */
        C0717d<Long> f1150a;

        /* renamed from: b */
        C0726h<Integer> f1151b;

        /* renamed from: f */
        private static long m1564f(int i, int i2) {
            return ((long) i2) | (((long) i) << 32);
        }

        C0491b(C0491b bVar, C0488a aVar, Resources resources) {
            super(bVar, aVar, resources);
            if (bVar != null) {
                this.f1150a = bVar.f1150a;
                this.f1151b = bVar.f1151b;
                return;
            }
            this.f1150a = new C0717d<>();
            this.f1151b = new C0726h<>();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo1155a() {
            this.f1150a = this.f1150a.clone();
            this.f1151b = this.f1151b.clone();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public int mo1152a(int i, int i2, Drawable drawable, boolean z) {
            int a = super.mo1178a(drawable);
            long f = m1564f(i, i2);
            long j = z ? 8589934592L : 0;
            long j2 = (long) a;
            this.f1150a.mo2789c(f, Long.valueOf(j2 | j));
            if (z) {
                this.f1150a.mo2789c(m1564f(i2, i), Long.valueOf(4294967296L | j2 | j));
            }
            return a;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public int mo1154a(int[] iArr, Drawable drawable, int i) {
            int a = super.mo1238a(iArr, drawable);
            this.f1151b.mo2899b(a, Integer.valueOf(i));
            return a;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public int mo1153a(int[] iArr) {
            int b = super.mo1239b(iArr);
            if (b >= 0) {
                return b;
            }
            return super.mo1239b(StateSet.WILD_CARD);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public int mo1150a(int i) {
            if (i < 0) {
                return 0;
            }
            return ((Integer) this.f1151b.mo2896a(i, Integer.valueOf(0))).intValue();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public int mo1151a(int i, int i2) {
            return (int) ((Long) this.f1150a.mo2780a(m1564f(i, i2), Long.valueOf(-1))).longValue();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public boolean mo1156b(int i, int i2) {
            return (((Long) this.f1150a.mo2780a(m1564f(i, i2), Long.valueOf(-1))).longValue() & 4294967296L) != 0;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public boolean mo1157c(int i, int i2) {
            return (((Long) this.f1150a.mo2780a(m1564f(i, i2), Long.valueOf(-1))).longValue() & 8589934592L) != 0;
        }

        public Drawable newDrawable() {
            return new C0488a(this, null);
        }

        public Drawable newDrawable(Resources resources) {
            return new C0488a(this, resources);
        }
    }

    /* renamed from: androidx.appcompat.b.a.a$c */
    /* compiled from: AnimatedStateListDrawableCompat */
    private static class C0492c extends C0495f {

        /* renamed from: a */
        private final C1438c f1152a;

        C0492c(C1438c cVar) {
            super();
            this.f1152a = cVar;
        }

        /* renamed from: a */
        public void mo1148a() {
            this.f1152a.start();
        }

        /* renamed from: b */
        public void mo1149b() {
            this.f1152a.stop();
        }
    }

    /* renamed from: androidx.appcompat.b.a.a$d */
    /* compiled from: AnimatedStateListDrawableCompat */
    private static class C0493d extends C0495f {

        /* renamed from: a */
        private final ObjectAnimator f1153a;

        /* renamed from: b */
        private final boolean f1154b;

        C0493d(AnimationDrawable animationDrawable, boolean z, boolean z2) {
            super();
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i = z ? numberOfFrames - 1 : 0;
            int i2 = z ? 0 : numberOfFrames - 1;
            C0494e eVar = new C0494e(animationDrawable, z);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", new int[]{i, i2});
            if (VERSION.SDK_INT >= 18) {
                ofInt.setAutoCancel(true);
            }
            ofInt.setDuration((long) eVar.mo1162a());
            ofInt.setInterpolator(eVar);
            this.f1154b = z2;
            this.f1153a = ofInt;
        }

        /* renamed from: c */
        public boolean mo1160c() {
            return this.f1154b;
        }

        /* renamed from: a */
        public void mo1148a() {
            this.f1153a.start();
        }

        /* renamed from: d */
        public void mo1161d() {
            this.f1153a.reverse();
        }

        /* renamed from: b */
        public void mo1149b() {
            this.f1153a.cancel();
        }
    }

    /* renamed from: androidx.appcompat.b.a.a$e */
    /* compiled from: AnimatedStateListDrawableCompat */
    private static class C0494e implements TimeInterpolator {

        /* renamed from: a */
        private int[] f1155a;

        /* renamed from: b */
        private int f1156b;

        /* renamed from: c */
        private int f1157c;

        C0494e(AnimationDrawable animationDrawable, boolean z) {
            mo1163a(animationDrawable, z);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public int mo1163a(AnimationDrawable animationDrawable, boolean z) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.f1156b = numberOfFrames;
            if (this.f1155a == null || this.f1155a.length < numberOfFrames) {
                this.f1155a = new int[numberOfFrames];
            }
            int[] iArr = this.f1155a;
            int i = 0;
            for (int i2 = 0; i2 < numberOfFrames; i2++) {
                int duration = animationDrawable.getDuration(z ? (numberOfFrames - i2) - 1 : i2);
                iArr[i2] = duration;
                i += duration;
            }
            this.f1157c = i;
            return i;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public int mo1162a() {
            return this.f1157c;
        }

        public float getInterpolation(float f) {
            int i = (int) ((f * ((float) this.f1157c)) + 0.5f);
            int i2 = this.f1156b;
            int[] iArr = this.f1155a;
            int i3 = 0;
            while (i3 < i2 && i >= iArr[i3]) {
                i -= iArr[i3];
                i3++;
            }
            return (((float) i3) / ((float) i2)) + (i3 < i2 ? ((float) i) / ((float) this.f1157c) : BitmapDescriptorFactory.HUE_RED);
        }
    }

    /* renamed from: androidx.appcompat.b.a.a$f */
    /* compiled from: AnimatedStateListDrawableCompat */
    private static abstract class C0495f {
        /* renamed from: a */
        public abstract void mo1148a();

        /* renamed from: b */
        public abstract void mo1149b();

        /* renamed from: c */
        public boolean mo1160c() {
            return false;
        }

        /* renamed from: d */
        public void mo1161d() {
        }

        private C0495f() {
        }
    }

    public boolean isStateful() {
        return true;
    }

    public /* bridge */ /* synthetic */ void applyTheme(Theme theme) {
        super.applyTheme(theme);
    }

    public /* bridge */ /* synthetic */ boolean canApplyTheme() {
        return super.canApplyTheme();
    }

    public /* bridge */ /* synthetic */ void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    public /* bridge */ /* synthetic */ int getChangingConfigurations() {
        return super.getChangingConfigurations();
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public /* bridge */ /* synthetic */ void getHotspotBounds(Rect rect) {
        super.getHotspotBounds(rect);
    }

    public /* bridge */ /* synthetic */ int getIntrinsicHeight() {
        return super.getIntrinsicHeight();
    }

    public /* bridge */ /* synthetic */ int getIntrinsicWidth() {
        return super.getIntrinsicWidth();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    public /* bridge */ /* synthetic */ void getOutline(Outline outline) {
        super.getOutline(outline);
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ void invalidateDrawable(Drawable drawable) {
        super.invalidateDrawable(drawable);
    }

    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    public /* bridge */ /* synthetic */ boolean onLayoutDirectionChanged(int i) {
        return super.onLayoutDirectionChanged(i);
    }

    public /* bridge */ /* synthetic */ void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        super.scheduleDrawable(drawable, runnable, j);
    }

    public /* bridge */ /* synthetic */ void setAlpha(int i) {
        super.setAlpha(i);
    }

    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    public /* bridge */ /* synthetic */ void setDither(boolean z) {
        super.setDither(z);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ void setTintList(ColorStateList colorStateList) {
        super.setTintList(colorStateList);
    }

    public /* bridge */ /* synthetic */ void setTintMode(Mode mode) {
        super.setTintMode(mode);
    }

    public /* bridge */ /* synthetic */ void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        super.unscheduleDrawable(drawable, runnable);
    }

    public C0488a() {
        this(null, null);
    }

    C0488a(C0491b bVar, Resources resources) {
        super(null);
        this.f1146d = -1;
        this.f1147e = -1;
        mo1112a((C0499b) new C0491b(bVar, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }

    /* renamed from: a */
    public static C0488a m1550a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws IOException, XmlPullParserException {
        String name = xmlPullParser.getName();
        if (name.equals("animated-selector")) {
            C0488a aVar = new C0488a();
            aVar.mo1115b(context, resources, xmlPullParser, attributeSet, theme);
            return aVar;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(xmlPullParser.getPositionDescription());
        sb.append(": invalid animated-selector tag ");
        sb.append(name);
        throw new XmlPullParserException(sb.toString());
    }

    /* renamed from: b */
    public void mo1115b(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        TypedArray a = C0890g.m3300a(resources, theme, attributeSet, R.styleable.AnimatedStateListDrawableCompat);
        setVisible(a.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_visible, true), true);
        m1551a(a);
        mo1165a(resources);
        a.recycle();
        m1553c(context, resources, xmlPullParser, attributeSet, theme);
        m1556e();
    }

    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (this.f1145c != null && (visible || z2)) {
            if (z) {
                this.f1145c.mo1148a();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        if (this.f1145c != null) {
            this.f1145c.mo1149b();
            this.f1145c = null;
            mo1167a(this.f1146d);
            this.f1146d = -1;
            this.f1147e = -1;
        }
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        int a = this.f1144b.mo1153a(iArr);
        boolean z = a != mo1168d() && (m1552b(a) || mo1167a(a));
        Drawable current = getCurrent();
        return current != null ? z | current.setState(iArr) : z;
    }

    /* renamed from: b */
    private boolean m1552b(int i) {
        int i2;
        C0495f fVar;
        C0495f fVar2 = this.f1145c;
        if (fVar2 == null) {
            i2 = mo1168d();
        } else if (i == this.f1146d) {
            return true;
        } else {
            if (i != this.f1147e || !fVar2.mo1160c()) {
                i2 = this.f1146d;
                fVar2.mo1149b();
            } else {
                fVar2.mo1161d();
                this.f1146d = this.f1147e;
                this.f1147e = i;
                return true;
            }
        }
        this.f1145c = null;
        this.f1147e = -1;
        this.f1146d = -1;
        C0491b bVar = this.f1144b;
        int a = bVar.mo1150a(i2);
        int a2 = bVar.mo1150a(i);
        if (a2 == 0 || a == 0) {
            return false;
        }
        int a3 = bVar.mo1151a(a, a2);
        if (a3 < 0) {
            return false;
        }
        boolean c = bVar.mo1157c(a, a2);
        mo1167a(a3);
        Drawable current = getCurrent();
        if (current instanceof AnimationDrawable) {
            fVar = new C0493d((AnimationDrawable) current, bVar.mo1156b(a, a2), c);
        } else if (current instanceof C1438c) {
            fVar = new C0492c((C1438c) current);
        } else if (!(current instanceof Animatable)) {
            return false;
        } else {
            fVar = new C0490a((Animatable) current);
        }
        fVar.mo1148a();
        this.f1145c = fVar;
        this.f1147e = i2;
        this.f1146d = i;
        return true;
    }

    /* renamed from: a */
    private void m1551a(TypedArray typedArray) {
        C0491b bVar = this.f1144b;
        if (VERSION.SDK_INT >= 21) {
            bVar.f1187f |= typedArray.getChangingConfigurations();
        }
        bVar.mo1181a(typedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_variablePadding, bVar.f1192k));
        bVar.mo1184b(typedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_constantSize, bVar.f1195n));
        bVar.mo1186c(typedArray.getInt(R.styleable.AnimatedStateListDrawableCompat_android_enterFadeDuration, bVar.f1175C));
        bVar.mo1189d(typedArray.getInt(R.styleable.AnimatedStateListDrawableCompat_android_exitFadeDuration, bVar.f1176D));
        setDither(typedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_dither, bVar.f1207z));
    }

    /* renamed from: e */
    private void m1556e() {
        onStateChange(getState());
    }

    /* renamed from: c */
    private void m1553c(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next != 1) {
                int depth2 = xmlPullParser.getDepth();
                if (depth2 < depth && next == 3) {
                    return;
                }
                if (next == 2 && depth2 <= depth) {
                    if (xmlPullParser.getName().equals("item")) {
                        m1555e(context, resources, xmlPullParser, attributeSet, theme);
                    } else if (xmlPullParser.getName().equals("transition")) {
                        m1554d(context, resources, xmlPullParser, attributeSet, theme);
                    }
                }
            } else {
                return;
            }
        }
    }

    /* renamed from: d */
    private int m1554d(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray a = C0890g.m3300a(resources, theme, attributeSet, R.styleable.AnimatedStateListDrawableTransition);
        int resourceId = a.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_fromId, -1);
        int resourceId2 = a.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_toId, -1);
        int resourceId3 = a.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_drawable, -1);
        Drawable b = resourceId3 > 0 ? C0424a.m1270b(context, resourceId3) : null;
        boolean z = a.getBoolean(R.styleable.AnimatedStateListDrawableTransition_android_reversible, false);
        a.recycle();
        if (b == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                StringBuilder sb = new StringBuilder();
                sb.append(xmlPullParser.getPositionDescription());
                sb.append(": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
                throw new XmlPullParserException(sb.toString());
            } else if (xmlPullParser.getName().equals("animated-vector")) {
                b = C1438c.m5728a(context, resources, xmlPullParser, attributeSet, theme);
            } else if (VERSION.SDK_INT >= 21) {
                b = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
            } else {
                b = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
            }
        }
        if (b == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(xmlPullParser.getPositionDescription());
            sb2.append(": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
            throw new XmlPullParserException(sb2.toString());
        } else if (resourceId != -1 && resourceId2 != -1) {
            return this.f1144b.mo1152a(resourceId, resourceId2, b, z);
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(xmlPullParser.getPositionDescription());
            sb3.append(": <transition> tag requires 'fromId' & 'toId' attributes");
            throw new XmlPullParserException(sb3.toString());
        }
    }

    /* renamed from: e */
    private int m1555e(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray a = C0890g.m3300a(resources, theme, attributeSet, R.styleable.AnimatedStateListDrawableItem);
        int resourceId = a.getResourceId(R.styleable.AnimatedStateListDrawableItem_android_id, 0);
        int resourceId2 = a.getResourceId(R.styleable.AnimatedStateListDrawableItem_android_drawable, -1);
        Drawable b = resourceId2 > 0 ? C0424a.m1270b(context, resourceId2) : null;
        a.recycle();
        int[] a2 = mo1237a(attributeSet);
        if (b == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                StringBuilder sb = new StringBuilder();
                sb.append(xmlPullParser.getPositionDescription());
                sb.append(": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
                throw new XmlPullParserException(sb.toString());
            } else if (xmlPullParser.getName().equals("vector")) {
                b = C1448i.m5762a(resources, xmlPullParser, attributeSet, theme);
            } else if (VERSION.SDK_INT >= 21) {
                b = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
            } else {
                b = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
            }
        }
        if (b != null) {
            return this.f1144b.mo1154a(a2, b, resourceId);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(xmlPullParser.getPositionDescription());
        sb2.append(": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
        throw new XmlPullParserException(sb2.toString());
    }

    public Drawable mutate() {
        if (!this.f1148f && super.mutate() == this) {
            this.f1144b.mo1155a();
            this.f1148f = true;
        }
        return this;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C0491b mo1116c() {
        return new C0491b(this.f1144b, this, null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo1112a(C0499b bVar) {
        super.mo1112a(bVar);
        if (bVar instanceof C0491b) {
            this.f1144b = (C0491b) bVar;
        }
    }
}
