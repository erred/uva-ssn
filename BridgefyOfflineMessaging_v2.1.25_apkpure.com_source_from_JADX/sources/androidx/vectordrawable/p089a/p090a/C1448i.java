package androidx.vectordrawable.p089a.p090a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.VectorDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import androidx.core.content.p066a.C0877b;
import androidx.core.content.p066a.C0890g;
import androidx.core.graphics.C0978b;
import androidx.core.graphics.C0978b.C0980b;
import androidx.core.graphics.drawable.C0983a;
import androidx.p052b.C0712a;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: androidx.vectordrawable.a.a.i */
/* compiled from: VectorDrawableCompat */
public class C1448i extends C1447h {

    /* renamed from: a */
    static final Mode f4276a = Mode.SRC_IN;

    /* renamed from: b */
    private C1456g f4277b;

    /* renamed from: d */
    private PorterDuffColorFilter f4278d;

    /* renamed from: e */
    private ColorFilter f4279e;

    /* renamed from: f */
    private boolean f4280f;

    /* renamed from: g */
    private boolean f4281g;

    /* renamed from: h */
    private ConstantState f4282h;

    /* renamed from: i */
    private final float[] f4283i;

    /* renamed from: j */
    private final Matrix f4284j;

    /* renamed from: k */
    private final Rect f4285k;

    /* renamed from: androidx.vectordrawable.a.a.i$a */
    /* compiled from: VectorDrawableCompat */
    private static class C1450a extends C1454e {
        /* renamed from: a */
        public boolean mo5960a() {
            return true;
        }

        public C1450a() {
        }

        public C1450a(C1450a aVar) {
            super(aVar);
        }

        /* renamed from: a */
        public void mo5959a(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
            if (C0890g.m3304a(xmlPullParser, "pathData")) {
                TypedArray a = C0890g.m3300a(resources, theme, attributeSet, C1436a.f4249d);
                m5769a(a);
                a.recycle();
            }
        }

        /* renamed from: a */
        private void m5769a(TypedArray typedArray) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f4313n = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f4312m = C0978b.m3670b(string2);
            }
        }
    }

    /* renamed from: androidx.vectordrawable.a.a.i$b */
    /* compiled from: VectorDrawableCompat */
    private static class C1451b extends C1454e {

        /* renamed from: a */
        C0877b f4286a;

        /* renamed from: b */
        float f4287b = BitmapDescriptorFactory.HUE_RED;

        /* renamed from: c */
        C0877b f4288c;

        /* renamed from: d */
        float f4289d = 1.0f;

        /* renamed from: e */
        int f4290e = 0;

        /* renamed from: f */
        float f4291f = 1.0f;

        /* renamed from: g */
        float f4292g = BitmapDescriptorFactory.HUE_RED;

        /* renamed from: h */
        float f4293h = 1.0f;

        /* renamed from: i */
        float f4294i = BitmapDescriptorFactory.HUE_RED;

        /* renamed from: j */
        Cap f4295j = Cap.BUTT;

        /* renamed from: k */
        Join f4296k = Join.MITER;

        /* renamed from: l */
        float f4297l = 4.0f;

        /* renamed from: p */
        private int[] f4298p;

        public C1451b() {
        }

        public C1451b(C1451b bVar) {
            super(bVar);
            this.f4298p = bVar.f4298p;
            this.f4286a = bVar.f4286a;
            this.f4287b = bVar.f4287b;
            this.f4289d = bVar.f4289d;
            this.f4288c = bVar.f4288c;
            this.f4290e = bVar.f4290e;
            this.f4291f = bVar.f4291f;
            this.f4292g = bVar.f4292g;
            this.f4293h = bVar.f4293h;
            this.f4294i = bVar.f4294i;
            this.f4295j = bVar.f4295j;
            this.f4296k = bVar.f4296k;
            this.f4297l = bVar.f4297l;
        }

        /* renamed from: a */
        private Cap m5772a(int i, Cap cap) {
            switch (i) {
                case 0:
                    return Cap.BUTT;
                case 1:
                    return Cap.ROUND;
                case 2:
                    return Cap.SQUARE;
                default:
                    return cap;
            }
        }

        /* renamed from: a */
        private Join m5773a(int i, Join join) {
            switch (i) {
                case 0:
                    return Join.MITER;
                case 1:
                    return Join.ROUND;
                case 2:
                    return Join.BEVEL;
                default:
                    return join;
            }
        }

        /* renamed from: a */
        public void mo5961a(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
            TypedArray a = C0890g.m3300a(resources, theme, attributeSet, C1436a.f4248c);
            m5774a(a, xmlPullParser, theme);
            a.recycle();
        }

        /* renamed from: a */
        private void m5774a(TypedArray typedArray, XmlPullParser xmlPullParser, Theme theme) {
            this.f4298p = null;
            if (C0890g.m3304a(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f4313n = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.f4312m = C0978b.m3670b(string2);
                }
                Theme theme2 = theme;
                this.f4288c = C0890g.m3301a(typedArray, xmlPullParser, theme2, "fillColor", 1, 0);
                this.f4291f = C0890g.m3298a(typedArray, xmlPullParser, "fillAlpha", 12, this.f4291f);
                this.f4295j = m5772a(C0890g.m3299a(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f4295j);
                this.f4296k = m5773a(C0890g.m3299a(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.f4296k);
                this.f4297l = C0890g.m3298a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f4297l);
                this.f4286a = C0890g.m3301a(typedArray, xmlPullParser, theme2, "strokeColor", 3, 0);
                this.f4289d = C0890g.m3298a(typedArray, xmlPullParser, "strokeAlpha", 11, this.f4289d);
                this.f4287b = C0890g.m3298a(typedArray, xmlPullParser, "strokeWidth", 4, this.f4287b);
                this.f4293h = C0890g.m3298a(typedArray, xmlPullParser, "trimPathEnd", 6, this.f4293h);
                this.f4294i = C0890g.m3298a(typedArray, xmlPullParser, "trimPathOffset", 7, this.f4294i);
                this.f4292g = C0890g.m3298a(typedArray, xmlPullParser, "trimPathStart", 5, this.f4292g);
                this.f4290e = C0890g.m3299a(typedArray, xmlPullParser, "fillType", 13, this.f4290e);
            }
        }

        /* renamed from: b */
        public boolean mo5963b() {
            return this.f4288c.mo3564d() || this.f4286a.mo3564d();
        }

        /* renamed from: a */
        public boolean mo5962a(int[] iArr) {
            return this.f4286a.mo3560a(iArr) | this.f4288c.mo3560a(iArr);
        }

        /* access modifiers changed from: 0000 */
        public int getStrokeColor() {
            return this.f4286a.mo3561b();
        }

        /* access modifiers changed from: 0000 */
        public void setStrokeColor(int i) {
            this.f4286a.mo3562b(i);
        }

        /* access modifiers changed from: 0000 */
        public float getStrokeWidth() {
            return this.f4287b;
        }

        /* access modifiers changed from: 0000 */
        public void setStrokeWidth(float f) {
            this.f4287b = f;
        }

        /* access modifiers changed from: 0000 */
        public float getStrokeAlpha() {
            return this.f4289d;
        }

        /* access modifiers changed from: 0000 */
        public void setStrokeAlpha(float f) {
            this.f4289d = f;
        }

        /* access modifiers changed from: 0000 */
        public int getFillColor() {
            return this.f4288c.mo3561b();
        }

        /* access modifiers changed from: 0000 */
        public void setFillColor(int i) {
            this.f4288c.mo3562b(i);
        }

        /* access modifiers changed from: 0000 */
        public float getFillAlpha() {
            return this.f4291f;
        }

        /* access modifiers changed from: 0000 */
        public void setFillAlpha(float f) {
            this.f4291f = f;
        }

        /* access modifiers changed from: 0000 */
        public float getTrimPathStart() {
            return this.f4292g;
        }

        /* access modifiers changed from: 0000 */
        public void setTrimPathStart(float f) {
            this.f4292g = f;
        }

        /* access modifiers changed from: 0000 */
        public float getTrimPathEnd() {
            return this.f4293h;
        }

        /* access modifiers changed from: 0000 */
        public void setTrimPathEnd(float f) {
            this.f4293h = f;
        }

        /* access modifiers changed from: 0000 */
        public float getTrimPathOffset() {
            return this.f4294i;
        }

        /* access modifiers changed from: 0000 */
        public void setTrimPathOffset(float f) {
            this.f4294i = f;
        }
    }

    /* renamed from: androidx.vectordrawable.a.a.i$c */
    /* compiled from: VectorDrawableCompat */
    private static class C1452c extends C1453d {

        /* renamed from: a */
        final Matrix f4299a = new Matrix();

        /* renamed from: b */
        final ArrayList<C1453d> f4300b = new ArrayList<>();

        /* renamed from: c */
        float f4301c = BitmapDescriptorFactory.HUE_RED;

        /* renamed from: d */
        final Matrix f4302d = new Matrix();

        /* renamed from: e */
        int f4303e;

        /* renamed from: f */
        private float f4304f = BitmapDescriptorFactory.HUE_RED;

        /* renamed from: g */
        private float f4305g = BitmapDescriptorFactory.HUE_RED;

        /* renamed from: h */
        private float f4306h = 1.0f;

        /* renamed from: i */
        private float f4307i = 1.0f;

        /* renamed from: j */
        private float f4308j = BitmapDescriptorFactory.HUE_RED;

        /* renamed from: k */
        private float f4309k = BitmapDescriptorFactory.HUE_RED;

        /* renamed from: l */
        private int[] f4310l;

        /* renamed from: m */
        private String f4311m = null;

        public C1452c(C1452c cVar, C0712a<String, Object> aVar) {
            C1454e eVar;
            super();
            this.f4301c = cVar.f4301c;
            this.f4304f = cVar.f4304f;
            this.f4305g = cVar.f4305g;
            this.f4306h = cVar.f4306h;
            this.f4307i = cVar.f4307i;
            this.f4308j = cVar.f4308j;
            this.f4309k = cVar.f4309k;
            this.f4310l = cVar.f4310l;
            this.f4311m = cVar.f4311m;
            this.f4303e = cVar.f4303e;
            if (this.f4311m != null) {
                aVar.put(this.f4311m, this);
            }
            this.f4302d.set(cVar.f4302d);
            ArrayList<C1453d> arrayList = cVar.f4300b;
            for (int i = 0; i < arrayList.size(); i++) {
                Object obj = arrayList.get(i);
                if (obj instanceof C1452c) {
                    this.f4300b.add(new C1452c((C1452c) obj, aVar));
                } else {
                    if (obj instanceof C1451b) {
                        eVar = new C1451b((C1451b) obj);
                    } else if (obj instanceof C1450a) {
                        eVar = new C1450a((C1450a) obj);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f4300b.add(eVar);
                    if (eVar.f4313n != null) {
                        aVar.put(eVar.f4313n, eVar);
                    }
                }
            }
        }

        public C1452c() {
            super();
        }

        public String getGroupName() {
            return this.f4311m;
        }

        public Matrix getLocalMatrix() {
            return this.f4302d;
        }

        /* renamed from: a */
        public void mo5980a(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
            TypedArray a = C0890g.m3300a(resources, theme, attributeSet, C1436a.f4247b);
            m5779a(a, xmlPullParser);
            a.recycle();
        }

        /* renamed from: a */
        private void m5779a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f4310l = null;
            this.f4301c = C0890g.m3298a(typedArray, xmlPullParser, "rotation", 5, this.f4301c);
            this.f4304f = typedArray.getFloat(1, this.f4304f);
            this.f4305g = typedArray.getFloat(2, this.f4305g);
            this.f4306h = C0890g.m3298a(typedArray, xmlPullParser, "scaleX", 3, this.f4306h);
            this.f4307i = C0890g.m3298a(typedArray, xmlPullParser, "scaleY", 4, this.f4307i);
            this.f4308j = C0890g.m3298a(typedArray, xmlPullParser, "translateX", 6, this.f4308j);
            this.f4309k = C0890g.m3298a(typedArray, xmlPullParser, "translateY", 7, this.f4309k);
            String string = typedArray.getString(0);
            if (string != null) {
                this.f4311m = string;
            }
            m5778a();
        }

        /* renamed from: a */
        private void m5778a() {
            this.f4302d.reset();
            this.f4302d.postTranslate(-this.f4304f, -this.f4305g);
            this.f4302d.postScale(this.f4306h, this.f4307i);
            this.f4302d.postRotate(this.f4301c, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
            this.f4302d.postTranslate(this.f4308j + this.f4304f, this.f4309k + this.f4305g);
        }

        public float getRotation() {
            return this.f4301c;
        }

        public void setRotation(float f) {
            if (f != this.f4301c) {
                this.f4301c = f;
                m5778a();
            }
        }

        public float getPivotX() {
            return this.f4304f;
        }

        public void setPivotX(float f) {
            if (f != this.f4304f) {
                this.f4304f = f;
                m5778a();
            }
        }

        public float getPivotY() {
            return this.f4305g;
        }

        public void setPivotY(float f) {
            if (f != this.f4305g) {
                this.f4305g = f;
                m5778a();
            }
        }

        public float getScaleX() {
            return this.f4306h;
        }

        public void setScaleX(float f) {
            if (f != this.f4306h) {
                this.f4306h = f;
                m5778a();
            }
        }

        public float getScaleY() {
            return this.f4307i;
        }

        public void setScaleY(float f) {
            if (f != this.f4307i) {
                this.f4307i = f;
                m5778a();
            }
        }

        public float getTranslateX() {
            return this.f4308j;
        }

        public void setTranslateX(float f) {
            if (f != this.f4308j) {
                this.f4308j = f;
                m5778a();
            }
        }

        public float getTranslateY() {
            return this.f4309k;
        }

        public void setTranslateY(float f) {
            if (f != this.f4309k) {
                this.f4309k = f;
                m5778a();
            }
        }

        /* renamed from: b */
        public boolean mo5963b() {
            for (int i = 0; i < this.f4300b.size(); i++) {
                if (((C1453d) this.f4300b.get(i)).mo5963b()) {
                    return true;
                }
            }
            return false;
        }

        /* renamed from: a */
        public boolean mo5962a(int[] iArr) {
            boolean z = false;
            for (int i = 0; i < this.f4300b.size(); i++) {
                z |= ((C1453d) this.f4300b.get(i)).mo5962a(iArr);
            }
            return z;
        }
    }

    /* renamed from: androidx.vectordrawable.a.a.i$d */
    /* compiled from: VectorDrawableCompat */
    private static abstract class C1453d {
        /* renamed from: a */
        public boolean mo5962a(int[] iArr) {
            return false;
        }

        /* renamed from: b */
        public boolean mo5963b() {
            return false;
        }

        private C1453d() {
        }
    }

    /* renamed from: androidx.vectordrawable.a.a.i$e */
    /* compiled from: VectorDrawableCompat */
    private static abstract class C1454e extends C1453d {

        /* renamed from: m */
        protected C0980b[] f4312m = null;

        /* renamed from: n */
        String f4313n;

        /* renamed from: o */
        int f4314o;

        /* renamed from: a */
        public boolean mo5960a() {
            return false;
        }

        public C1454e() {
            super();
        }

        public C1454e(C1454e eVar) {
            super();
            this.f4313n = eVar.f4313n;
            this.f4314o = eVar.f4314o;
            this.f4312m = C0978b.m3668a(eVar.f4312m);
        }

        /* renamed from: a */
        public void mo5997a(Path path) {
            path.reset();
            if (this.f4312m != null) {
                C0980b.m3675a(this.f4312m, path);
            }
        }

        public String getPathName() {
            return this.f4313n;
        }

        public C0980b[] getPathData() {
            return this.f4312m;
        }

        public void setPathData(C0980b[] bVarArr) {
            if (!C0978b.m3666a(this.f4312m, bVarArr)) {
                this.f4312m = C0978b.m3668a(bVarArr);
            } else {
                C0978b.m3669b(this.f4312m, bVarArr);
            }
        }
    }

    /* renamed from: androidx.vectordrawable.a.a.i$f */
    /* compiled from: VectorDrawableCompat */
    private static class C1455f {

        /* renamed from: n */
        private static final Matrix f4315n = new Matrix();

        /* renamed from: a */
        Paint f4316a;

        /* renamed from: b */
        Paint f4317b;

        /* renamed from: c */
        final C1452c f4318c;

        /* renamed from: d */
        float f4319d;

        /* renamed from: e */
        float f4320e;

        /* renamed from: f */
        float f4321f;

        /* renamed from: g */
        float f4322g;

        /* renamed from: h */
        int f4323h;

        /* renamed from: i */
        String f4324i;

        /* renamed from: j */
        Boolean f4325j;

        /* renamed from: k */
        final C0712a<String, Object> f4326k;

        /* renamed from: l */
        private final Path f4327l;

        /* renamed from: m */
        private final Path f4328m;

        /* renamed from: o */
        private final Matrix f4329o;

        /* renamed from: p */
        private PathMeasure f4330p;

        /* renamed from: q */
        private int f4331q;

        /* renamed from: a */
        private static float m5787a(float f, float f2, float f3, float f4) {
            return (f * f4) - (f2 * f3);
        }

        public C1455f() {
            this.f4329o = new Matrix();
            this.f4319d = BitmapDescriptorFactory.HUE_RED;
            this.f4320e = BitmapDescriptorFactory.HUE_RED;
            this.f4321f = BitmapDescriptorFactory.HUE_RED;
            this.f4322g = BitmapDescriptorFactory.HUE_RED;
            this.f4323h = 255;
            this.f4324i = null;
            this.f4325j = null;
            this.f4326k = new C0712a<>();
            this.f4318c = new C1452c();
            this.f4327l = new Path();
            this.f4328m = new Path();
        }

        public void setRootAlpha(int i) {
            this.f4323h = i;
        }

        public int getRootAlpha() {
            return this.f4323h;
        }

        public void setAlpha(float f) {
            setRootAlpha((int) (f * 255.0f));
        }

        public float getAlpha() {
            return ((float) getRootAlpha()) / 255.0f;
        }

        public C1455f(C1455f fVar) {
            this.f4329o = new Matrix();
            this.f4319d = BitmapDescriptorFactory.HUE_RED;
            this.f4320e = BitmapDescriptorFactory.HUE_RED;
            this.f4321f = BitmapDescriptorFactory.HUE_RED;
            this.f4322g = BitmapDescriptorFactory.HUE_RED;
            this.f4323h = 255;
            this.f4324i = null;
            this.f4325j = null;
            this.f4326k = new C0712a<>();
            this.f4318c = new C1452c(fVar.f4318c, this.f4326k);
            this.f4327l = new Path(fVar.f4327l);
            this.f4328m = new Path(fVar.f4328m);
            this.f4319d = fVar.f4319d;
            this.f4320e = fVar.f4320e;
            this.f4321f = fVar.f4321f;
            this.f4322g = fVar.f4322g;
            this.f4331q = fVar.f4331q;
            this.f4323h = fVar.f4323h;
            this.f4324i = fVar.f4324i;
            if (fVar.f4324i != null) {
                this.f4326k.put(fVar.f4324i, this);
            }
            this.f4325j = fVar.f4325j;
        }

        /* renamed from: a */
        private void m5789a(C1452c cVar, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            cVar.f4299a.set(matrix);
            cVar.f4299a.preConcat(cVar.f4302d);
            canvas.save();
            for (int i3 = 0; i3 < cVar.f4300b.size(); i3++) {
                C1453d dVar = (C1453d) cVar.f4300b.get(i3);
                if (dVar instanceof C1452c) {
                    m5789a((C1452c) dVar, cVar.f4299a, canvas, i, i2, colorFilter);
                } else if (dVar instanceof C1454e) {
                    m5790a(cVar, (C1454e) dVar, canvas, i, i2, colorFilter);
                }
            }
            canvas.restore();
        }

        /* renamed from: a */
        public void mo6001a(Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            m5789a(this.f4318c, f4315n, canvas, i, i2, colorFilter);
        }

        /* renamed from: a */
        private void m5790a(C1452c cVar, C1454e eVar, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            float f = ((float) i) / this.f4321f;
            float f2 = ((float) i2) / this.f4322g;
            float min = Math.min(f, f2);
            Matrix matrix = cVar.f4299a;
            this.f4329o.set(matrix);
            this.f4329o.postScale(f, f2);
            float a = m5788a(matrix);
            if (a != BitmapDescriptorFactory.HUE_RED) {
                eVar.mo5997a(this.f4327l);
                Path path = this.f4327l;
                this.f4328m.reset();
                if (eVar.mo5960a()) {
                    this.f4328m.addPath(path, this.f4329o);
                    canvas.clipPath(this.f4328m);
                } else {
                    C1451b bVar = (C1451b) eVar;
                    if (!(bVar.f4292g == BitmapDescriptorFactory.HUE_RED && bVar.f4293h == 1.0f)) {
                        float f3 = (bVar.f4292g + bVar.f4294i) % 1.0f;
                        float f4 = (bVar.f4293h + bVar.f4294i) % 1.0f;
                        if (this.f4330p == null) {
                            this.f4330p = new PathMeasure();
                        }
                        this.f4330p.setPath(this.f4327l, false);
                        float length = this.f4330p.getLength();
                        float f5 = f3 * length;
                        float f6 = f4 * length;
                        path.reset();
                        if (f5 > f6) {
                            this.f4330p.getSegment(f5, length, path, true);
                            this.f4330p.getSegment(BitmapDescriptorFactory.HUE_RED, f6, path, true);
                        } else {
                            this.f4330p.getSegment(f5, f6, path, true);
                        }
                        path.rLineTo(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
                    }
                    this.f4328m.addPath(path, this.f4329o);
                    if (bVar.f4288c.mo3565e()) {
                        C0877b bVar2 = bVar.f4288c;
                        if (this.f4317b == null) {
                            this.f4317b = new Paint(1);
                            this.f4317b.setStyle(Style.FILL);
                        }
                        Paint paint = this.f4317b;
                        if (bVar2.mo3563c()) {
                            Shader a2 = bVar2.mo3559a();
                            a2.setLocalMatrix(this.f4329o);
                            paint.setShader(a2);
                            paint.setAlpha(Math.round(bVar.f4291f * 255.0f));
                        } else {
                            paint.setShader(null);
                            paint.setAlpha(255);
                            paint.setColor(C1448i.m5759a(bVar2.mo3561b(), bVar.f4291f));
                        }
                        paint.setColorFilter(colorFilter);
                        this.f4328m.setFillType(bVar.f4290e == 0 ? FillType.WINDING : FillType.EVEN_ODD);
                        canvas.drawPath(this.f4328m, paint);
                    }
                    if (bVar.f4286a.mo3565e()) {
                        C0877b bVar3 = bVar.f4286a;
                        if (this.f4316a == null) {
                            this.f4316a = new Paint(1);
                            this.f4316a.setStyle(Style.STROKE);
                        }
                        Paint paint2 = this.f4316a;
                        if (bVar.f4296k != null) {
                            paint2.setStrokeJoin(bVar.f4296k);
                        }
                        if (bVar.f4295j != null) {
                            paint2.setStrokeCap(bVar.f4295j);
                        }
                        paint2.setStrokeMiter(bVar.f4297l);
                        if (bVar3.mo3563c()) {
                            Shader a3 = bVar3.mo3559a();
                            a3.setLocalMatrix(this.f4329o);
                            paint2.setShader(a3);
                            paint2.setAlpha(Math.round(bVar.f4289d * 255.0f));
                        } else {
                            paint2.setShader(null);
                            paint2.setAlpha(255);
                            paint2.setColor(C1448i.m5759a(bVar3.mo3561b(), bVar.f4289d));
                        }
                        paint2.setColorFilter(colorFilter);
                        paint2.setStrokeWidth(bVar.f4287b * min * a);
                        canvas.drawPath(this.f4328m, paint2);
                    }
                }
            }
        }

        /* renamed from: a */
        private float m5788a(Matrix matrix) {
            float[] fArr = {BitmapDescriptorFactory.HUE_RED, 1.0f, 1.0f, BitmapDescriptorFactory.HUE_RED};
            matrix.mapVectors(fArr);
            float hypot = (float) Math.hypot((double) fArr[0], (double) fArr[1]);
            float hypot2 = (float) Math.hypot((double) fArr[2], (double) fArr[3]);
            float a = m5787a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max(hypot, hypot2);
            if (max > BitmapDescriptorFactory.HUE_RED) {
                return Math.abs(a) / max;
            }
            return BitmapDescriptorFactory.HUE_RED;
        }

        /* renamed from: a */
        public boolean mo6002a() {
            if (this.f4325j == null) {
                this.f4325j = Boolean.valueOf(this.f4318c.mo5963b());
            }
            return this.f4325j.booleanValue();
        }

        /* renamed from: a */
        public boolean mo6003a(int[] iArr) {
            return this.f4318c.mo5962a(iArr);
        }
    }

    /* renamed from: androidx.vectordrawable.a.a.i$g */
    /* compiled from: VectorDrawableCompat */
    private static class C1456g extends ConstantState {

        /* renamed from: a */
        int f4332a;

        /* renamed from: b */
        C1455f f4333b;

        /* renamed from: c */
        ColorStateList f4334c;

        /* renamed from: d */
        Mode f4335d;

        /* renamed from: e */
        boolean f4336e;

        /* renamed from: f */
        Bitmap f4337f;

        /* renamed from: g */
        ColorStateList f4338g;

        /* renamed from: h */
        Mode f4339h;

        /* renamed from: i */
        int f4340i;

        /* renamed from: j */
        boolean f4341j;

        /* renamed from: k */
        boolean f4342k;

        /* renamed from: l */
        Paint f4343l;

        public C1456g(C1456g gVar) {
            this.f4334c = null;
            this.f4335d = C1448i.f4276a;
            if (gVar != null) {
                this.f4332a = gVar.f4332a;
                this.f4333b = new C1455f(gVar.f4333b);
                if (gVar.f4333b.f4317b != null) {
                    this.f4333b.f4317b = new Paint(gVar.f4333b.f4317b);
                }
                if (gVar.f4333b.f4316a != null) {
                    this.f4333b.f4316a = new Paint(gVar.f4333b.f4316a);
                }
                this.f4334c = gVar.f4334c;
                this.f4335d = gVar.f4335d;
                this.f4336e = gVar.f4336e;
            }
        }

        /* renamed from: a */
        public void mo6010a(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f4337f, null, rect, mo6008a(colorFilter));
        }

        /* renamed from: a */
        public boolean mo6011a() {
            return this.f4333b.getRootAlpha() < 255;
        }

        /* renamed from: a */
        public Paint mo6008a(ColorFilter colorFilter) {
            if (!mo6011a() && colorFilter == null) {
                return null;
            }
            if (this.f4343l == null) {
                this.f4343l = new Paint();
                this.f4343l.setFilterBitmap(true);
            }
            this.f4343l.setAlpha(this.f4333b.getRootAlpha());
            this.f4343l.setColorFilter(colorFilter);
            return this.f4343l;
        }

        /* renamed from: a */
        public void mo6009a(int i, int i2) {
            this.f4337f.eraseColor(0);
            this.f4333b.mo6001a(new Canvas(this.f4337f), i, i2, (ColorFilter) null);
        }

        /* renamed from: b */
        public void mo6013b(int i, int i2) {
            if (this.f4337f == null || !mo6016c(i, i2)) {
                this.f4337f = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
                this.f4342k = true;
            }
        }

        /* renamed from: c */
        public boolean mo6016c(int i, int i2) {
            return i == this.f4337f.getWidth() && i2 == this.f4337f.getHeight();
        }

        /* renamed from: b */
        public boolean mo6014b() {
            return !this.f4342k && this.f4338g == this.f4334c && this.f4339h == this.f4335d && this.f4341j == this.f4336e && this.f4340i == this.f4333b.getRootAlpha();
        }

        /* renamed from: c */
        public void mo6015c() {
            this.f4338g = this.f4334c;
            this.f4339h = this.f4335d;
            this.f4340i = this.f4333b.getRootAlpha();
            this.f4341j = this.f4336e;
            this.f4342k = false;
        }

        public C1456g() {
            this.f4334c = null;
            this.f4335d = C1448i.f4276a;
            this.f4333b = new C1455f();
        }

        public Drawable newDrawable() {
            return new C1448i(this);
        }

        public Drawable newDrawable(Resources resources) {
            return new C1448i(this);
        }

        public int getChangingConfigurations() {
            return this.f4332a;
        }

        /* renamed from: d */
        public boolean mo6017d() {
            return this.f4333b.mo6002a();
        }

        /* renamed from: a */
        public boolean mo6012a(int[] iArr) {
            boolean a = this.f4333b.mo6003a(iArr);
            this.f4342k |= a;
            return a;
        }
    }

    /* renamed from: androidx.vectordrawable.a.a.i$h */
    /* compiled from: VectorDrawableCompat */
    private static class C1457h extends ConstantState {

        /* renamed from: a */
        private final ConstantState f4344a;

        public C1457h(ConstantState constantState) {
            this.f4344a = constantState;
        }

        public Drawable newDrawable() {
            C1448i iVar = new C1448i();
            iVar.f4275c = (VectorDrawable) this.f4344a.newDrawable();
            return iVar;
        }

        public Drawable newDrawable(Resources resources) {
            C1448i iVar = new C1448i();
            iVar.f4275c = (VectorDrawable) this.f4344a.newDrawable(resources);
            return iVar;
        }

        public Drawable newDrawable(Resources resources, Theme theme) {
            C1448i iVar = new C1448i();
            iVar.f4275c = (VectorDrawable) this.f4344a.newDrawable(resources, theme);
            return iVar;
        }

        public boolean canApplyTheme() {
            return this.f4344a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f4344a.getChangingConfigurations();
        }
    }

    public /* bridge */ /* synthetic */ void applyTheme(Theme theme) {
        super.applyTheme(theme);
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i, Mode mode) {
        super.setColorFilter(i, mode);
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    C1448i() {
        this.f4281g = true;
        this.f4283i = new float[9];
        this.f4284j = new Matrix();
        this.f4285k = new Rect();
        this.f4277b = new C1456g();
    }

    C1448i(C1456g gVar) {
        this.f4281g = true;
        this.f4283i = new float[9];
        this.f4284j = new Matrix();
        this.f4285k = new Rect();
        this.f4277b = gVar;
        this.f4278d = mo5935a(this.f4278d, gVar.f4334c, gVar.f4335d);
    }

    public Drawable mutate() {
        if (this.f4275c != null) {
            this.f4275c.mutate();
            return this;
        }
        if (!this.f4280f && super.mutate() == this) {
            this.f4277b = new C1456g(this.f4277b);
            this.f4280f = true;
        }
        return this;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Object mo5936a(String str) {
        return this.f4277b.f4333b.f4326k.get(str);
    }

    public ConstantState getConstantState() {
        if (this.f4275c != null && VERSION.SDK_INT >= 24) {
            return new C1457h(this.f4275c.getConstantState());
        }
        this.f4277b.f4332a = getChangingConfigurations();
        return this.f4277b;
    }

    public void draw(Canvas canvas) {
        if (this.f4275c != null) {
            this.f4275c.draw(canvas);
            return;
        }
        copyBounds(this.f4285k);
        if (this.f4285k.width() > 0 && this.f4285k.height() > 0) {
            ColorFilter colorFilter = this.f4279e == null ? this.f4278d : this.f4279e;
            canvas.getMatrix(this.f4284j);
            this.f4284j.getValues(this.f4283i);
            float abs = Math.abs(this.f4283i[0]);
            float abs2 = Math.abs(this.f4283i[4]);
            float abs3 = Math.abs(this.f4283i[1]);
            float abs4 = Math.abs(this.f4283i[3]);
            if (!(abs3 == BitmapDescriptorFactory.HUE_RED && abs4 == BitmapDescriptorFactory.HUE_RED)) {
                abs = 1.0f;
                abs2 = 1.0f;
            }
            int height = (int) (((float) this.f4285k.height()) * abs2);
            int min = Math.min(2048, (int) (((float) this.f4285k.width()) * abs));
            int min2 = Math.min(2048, height);
            if (min > 0 && min2 > 0) {
                int save = canvas.save();
                canvas.translate((float) this.f4285k.left, (float) this.f4285k.top);
                if (m5764a()) {
                    canvas.translate((float) this.f4285k.width(), BitmapDescriptorFactory.HUE_RED);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.f4285k.offsetTo(0, 0);
                this.f4277b.mo6013b(min, min2);
                if (!this.f4281g) {
                    this.f4277b.mo6009a(min, min2);
                } else if (!this.f4277b.mo6014b()) {
                    this.f4277b.mo6009a(min, min2);
                    this.f4277b.mo6015c();
                }
                this.f4277b.mo6010a(canvas, colorFilter, this.f4285k);
                canvas.restoreToCount(save);
            }
        }
    }

    public int getAlpha() {
        if (this.f4275c != null) {
            return C0983a.m3705c(this.f4275c);
        }
        return this.f4277b.f4333b.getRootAlpha();
    }

    public void setAlpha(int i) {
        if (this.f4275c != null) {
            this.f4275c.setAlpha(i);
            return;
        }
        if (this.f4277b.f4333b.getRootAlpha() != i) {
            this.f4277b.f4333b.setRootAlpha(i);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f4275c != null) {
            this.f4275c.setColorFilter(colorFilter);
            return;
        }
        this.f4279e = colorFilter;
        invalidateSelf();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public PorterDuffColorFilter mo5935a(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public void setTint(int i) {
        if (this.f4275c != null) {
            C0983a.m3696a(this.f4275c, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.f4275c != null) {
            C0983a.m3698a(this.f4275c, colorStateList);
            return;
        }
        C1456g gVar = this.f4277b;
        if (gVar.f4334c != colorStateList) {
            gVar.f4334c = colorStateList;
            this.f4278d = mo5935a(this.f4278d, colorStateList, gVar.f4335d);
            invalidateSelf();
        }
    }

    public void setTintMode(Mode mode) {
        if (this.f4275c != null) {
            C0983a.m3701a(this.f4275c, mode);
            return;
        }
        C1456g gVar = this.f4277b;
        if (gVar.f4335d != mode) {
            gVar.f4335d = mode;
            this.f4278d = mo5935a(this.f4278d, gVar.f4334c, mode);
            invalidateSelf();
        }
    }

    public boolean isStateful() {
        if (this.f4275c != null) {
            return this.f4275c.isStateful();
        }
        return super.isStateful() || (this.f4277b != null && (this.f4277b.mo6017d() || (this.f4277b.f4334c != null && this.f4277b.f4334c.isStateful())));
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        if (this.f4275c != null) {
            return this.f4275c.setState(iArr);
        }
        boolean z = false;
        C1456g gVar = this.f4277b;
        if (!(gVar.f4334c == null || gVar.f4335d == null)) {
            this.f4278d = mo5935a(this.f4278d, gVar.f4334c, gVar.f4335d);
            invalidateSelf();
            z = true;
        }
        if (gVar.mo6017d() && gVar.mo6012a(iArr)) {
            invalidateSelf();
            z = true;
        }
        return z;
    }

    public int getOpacity() {
        if (this.f4275c != null) {
            return this.f4275c.getOpacity();
        }
        return -3;
    }

    public int getIntrinsicWidth() {
        if (this.f4275c != null) {
            return this.f4275c.getIntrinsicWidth();
        }
        return (int) this.f4277b.f4333b.f4319d;
    }

    public int getIntrinsicHeight() {
        if (this.f4275c != null) {
            return this.f4275c.getIntrinsicHeight();
        }
        return (int) this.f4277b.f4333b.f4320e;
    }

    public boolean canApplyTheme() {
        if (this.f4275c != null) {
            C0983a.m3706d(this.f4275c);
        }
        return false;
    }

    public boolean isAutoMirrored() {
        if (this.f4275c != null) {
            return C0983a.m3703b(this.f4275c);
        }
        return this.f4277b.f4336e;
    }

    public void setAutoMirrored(boolean z) {
        if (this.f4275c != null) {
            C0983a.m3702a(this.f4275c, z);
        } else {
            this.f4277b.f4336e = z;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0034 A[Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0041 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0039 A[Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0041 }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.vectordrawable.p089a.p090a.C1448i m5761a(android.content.res.Resources r4, int r5, android.content.res.Resources.Theme r6) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 24
            if (r0 < r1) goto L_0x001f
            androidx.vectordrawable.a.a.i r0 = new androidx.vectordrawable.a.a.i
            r0.<init>()
            android.graphics.drawable.Drawable r4 = androidx.core.content.p066a.C0886f.m3296a(r4, r5, r6)
            r0.f4275c = r4
            androidx.vectordrawable.a.a.i$h r4 = new androidx.vectordrawable.a.a.i$h
            android.graphics.drawable.Drawable r5 = r0.f4275c
            android.graphics.drawable.Drawable$ConstantState r5 = r5.getConstantState()
            r4.<init>(r5)
            r0.f4282h = r4
            return r0
        L_0x001f:
            android.content.res.XmlResourceParser r5 = r4.getXml(r5)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0041 }
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r5)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0041 }
        L_0x0027:
            int r1 = r5.next()     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0041 }
            r2 = 2
            if (r1 == r2) goto L_0x0032
            r3 = 1
            if (r1 == r3) goto L_0x0032
            goto L_0x0027
        L_0x0032:
            if (r1 != r2) goto L_0x0039
            androidx.vectordrawable.a.a.i r4 = m5762a(r4, r5, r0, r6)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0041 }
            return r4
        L_0x0039:
            org.xmlpull.v1.XmlPullParserException r4 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0041 }
            java.lang.String r5 = "No start tag found"
            r4.<init>(r5)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0041 }
            throw r4     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0041 }
        L_0x0041:
            r4 = move-exception
            java.lang.String r5 = "VectorDrawableCompat"
            java.lang.String r6 = "parser error"
            android.util.Log.e(r5, r6, r4)
            goto L_0x0052
        L_0x004a:
            r4 = move-exception
            java.lang.String r5 = "VectorDrawableCompat"
            java.lang.String r6 = "parser error"
            android.util.Log.e(r5, r6, r4)
        L_0x0052:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.p089a.p090a.C1448i.m5761a(android.content.res.Resources, int, android.content.res.Resources$Theme):androidx.vectordrawable.a.a.i");
    }

    /* renamed from: a */
    public static C1448i m5762a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        C1448i iVar = new C1448i();
        iVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return iVar;
    }

    /* renamed from: a */
    static int m5759a(int i, float f) {
        return (i & 16777215) | (((int) (((float) Color.alpha(i)) * f)) << 24);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        if (this.f4275c != null) {
            this.f4275c.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        if (this.f4275c != null) {
            C0983a.m3700a(this.f4275c, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        C1456g gVar = this.f4277b;
        gVar.f4333b = new C1455f();
        TypedArray a = C0890g.m3300a(resources, theme, attributeSet, C1436a.f4246a);
        m5763a(a, xmlPullParser);
        a.recycle();
        gVar.f4332a = getChangingConfigurations();
        gVar.f4342k = true;
        m5765b(resources, xmlPullParser, attributeSet, theme);
        this.f4278d = mo5935a(this.f4278d, gVar.f4334c, gVar.f4335d);
    }

    /* renamed from: a */
    private static Mode m5760a(int i, Mode mode) {
        if (i == 3) {
            return Mode.SRC_OVER;
        }
        if (i == 5) {
            return Mode.SRC_IN;
        }
        if (i == 9) {
            return Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return Mode.MULTIPLY;
            case 15:
                return Mode.SCREEN;
            case 16:
                return Mode.ADD;
            default:
                return mode;
        }
    }

    /* renamed from: a */
    private void m5763a(TypedArray typedArray, XmlPullParser xmlPullParser) throws XmlPullParserException {
        C1456g gVar = this.f4277b;
        C1455f fVar = gVar.f4333b;
        gVar.f4335d = m5760a(C0890g.m3299a(typedArray, xmlPullParser, "tintMode", 6, -1), Mode.SRC_IN);
        ColorStateList colorStateList = typedArray.getColorStateList(1);
        if (colorStateList != null) {
            gVar.f4334c = colorStateList;
        }
        gVar.f4336e = C0890g.m3303a(typedArray, xmlPullParser, "autoMirrored", 5, gVar.f4336e);
        fVar.f4321f = C0890g.m3298a(typedArray, xmlPullParser, "viewportWidth", 7, fVar.f4321f);
        fVar.f4322g = C0890g.m3298a(typedArray, xmlPullParser, "viewportHeight", 8, fVar.f4322g);
        if (fVar.f4321f <= BitmapDescriptorFactory.HUE_RED) {
            StringBuilder sb = new StringBuilder();
            sb.append(typedArray.getPositionDescription());
            sb.append("<vector> tag requires viewportWidth > 0");
            throw new XmlPullParserException(sb.toString());
        } else if (fVar.f4322g > BitmapDescriptorFactory.HUE_RED) {
            fVar.f4319d = typedArray.getDimension(3, fVar.f4319d);
            fVar.f4320e = typedArray.getDimension(2, fVar.f4320e);
            if (fVar.f4319d <= BitmapDescriptorFactory.HUE_RED) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(typedArray.getPositionDescription());
                sb2.append("<vector> tag requires width > 0");
                throw new XmlPullParserException(sb2.toString());
            } else if (fVar.f4320e > BitmapDescriptorFactory.HUE_RED) {
                fVar.setAlpha(C0890g.m3298a(typedArray, xmlPullParser, "alpha", 4, fVar.getAlpha()));
                String string = typedArray.getString(0);
                if (string != null) {
                    fVar.f4324i = string;
                    fVar.f4326k.put(string, fVar);
                }
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(typedArray.getPositionDescription());
                sb3.append("<vector> tag requires height > 0");
                throw new XmlPullParserException(sb3.toString());
            }
        } else {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(typedArray.getPositionDescription());
            sb4.append("<vector> tag requires viewportHeight > 0");
            throw new XmlPullParserException(sb4.toString());
        }
    }

    /* renamed from: b */
    private void m5765b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        C1456g gVar = this.f4277b;
        C1455f fVar = gVar.f4333b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(fVar.f4318c);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                C1452c cVar = (C1452c) arrayDeque.peek();
                if ("path".equals(name)) {
                    C1451b bVar = new C1451b();
                    bVar.mo5961a(resources, attributeSet, theme, xmlPullParser);
                    cVar.f4300b.add(bVar);
                    if (bVar.getPathName() != null) {
                        fVar.f4326k.put(bVar.getPathName(), bVar);
                    }
                    z = false;
                    gVar.f4332a = bVar.f4314o | gVar.f4332a;
                } else if ("clip-path".equals(name)) {
                    C1450a aVar = new C1450a();
                    aVar.mo5959a(resources, attributeSet, theme, xmlPullParser);
                    cVar.f4300b.add(aVar);
                    if (aVar.getPathName() != null) {
                        fVar.f4326k.put(aVar.getPathName(), aVar);
                    }
                    gVar.f4332a = aVar.f4314o | gVar.f4332a;
                } else if ("group".equals(name)) {
                    C1452c cVar2 = new C1452c();
                    cVar2.mo5980a(resources, attributeSet, theme, xmlPullParser);
                    cVar.f4300b.add(cVar2);
                    arrayDeque.push(cVar2);
                    if (cVar2.getGroupName() != null) {
                        fVar.f4326k.put(cVar2.getGroupName(), cVar2);
                    }
                    gVar.f4332a = cVar2.f4303e | gVar.f4332a;
                }
            } else if (eventType == 3) {
                if ("group".equals(xmlPullParser.getName())) {
                    arrayDeque.pop();
                }
            }
            eventType = xmlPullParser.next();
        }
        if (z) {
            throw new XmlPullParserException("no path defined");
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo5937a(boolean z) {
        this.f4281g = z;
    }

    /* renamed from: a */
    private boolean m5764a() {
        boolean z = false;
        if (VERSION.SDK_INT < 17) {
            return false;
        }
        if (isAutoMirrored() && C0983a.m3711i(this) == 1) {
            z = true;
        }
        return z;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        if (this.f4275c != null) {
            this.f4275c.setBounds(rect);
        }
    }

    public int getChangingConfigurations() {
        if (this.f4275c != null) {
            return this.f4275c.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f4277b.getChangingConfigurations();
    }

    public void invalidateSelf() {
        if (this.f4275c != null) {
            this.f4275c.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public void scheduleSelf(Runnable runnable, long j) {
        if (this.f4275c != null) {
            this.f4275c.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        if (this.f4275c != null) {
            return this.f4275c.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    public void unscheduleSelf(Runnable runnable) {
        if (this.f4275c != null) {
            this.f4275c.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }
}
