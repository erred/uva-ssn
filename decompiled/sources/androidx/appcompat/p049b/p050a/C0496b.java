package androidx.appcompat.p049b.p050a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.SparseArray;
import androidx.core.graphics.drawable.C0983a;

/* renamed from: androidx.appcompat.b.a.b */
/* compiled from: DrawableContainer */
class C0496b extends Drawable implements Callback {

    /* renamed from: a */
    private C0499b f1158a;

    /* renamed from: b */
    private Rect f1159b;

    /* renamed from: c */
    private Drawable f1160c;

    /* renamed from: d */
    private Drawable f1161d;

    /* renamed from: e */
    private int f1162e = 255;

    /* renamed from: f */
    private boolean f1163f;

    /* renamed from: g */
    private int f1164g = -1;

    /* renamed from: h */
    private int f1165h = -1;

    /* renamed from: i */
    private boolean f1166i;

    /* renamed from: j */
    private Runnable f1167j;

    /* renamed from: k */
    private long f1168k;

    /* renamed from: l */
    private long f1169l;

    /* renamed from: m */
    private C0498a f1170m;

    /* renamed from: androidx.appcompat.b.a.b$a */
    /* compiled from: DrawableContainer */
    static class C0498a implements Callback {

        /* renamed from: a */
        private Callback f1172a;

        public void invalidateDrawable(Drawable drawable) {
        }

        C0498a() {
        }

        /* renamed from: a */
        public C0498a mo1174a(Callback callback) {
            this.f1172a = callback;
            return this;
        }

        /* renamed from: a */
        public Callback mo1173a() {
            Callback callback = this.f1172a;
            this.f1172a = null;
            return callback;
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            if (this.f1172a != null) {
                this.f1172a.scheduleDrawable(drawable, runnable, j);
            }
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            if (this.f1172a != null) {
                this.f1172a.unscheduleDrawable(drawable, runnable);
            }
        }
    }

    /* renamed from: androidx.appcompat.b.a.b$b */
    /* compiled from: DrawableContainer */
    static abstract class C0499b extends ConstantState {

        /* renamed from: A */
        boolean f1173A;

        /* renamed from: B */
        int f1174B;

        /* renamed from: C */
        int f1175C;

        /* renamed from: D */
        int f1176D;

        /* renamed from: E */
        boolean f1177E;

        /* renamed from: F */
        ColorFilter f1178F;

        /* renamed from: G */
        boolean f1179G;

        /* renamed from: H */
        ColorStateList f1180H;

        /* renamed from: I */
        Mode f1181I;

        /* renamed from: J */
        boolean f1182J;

        /* renamed from: K */
        boolean f1183K;

        /* renamed from: c */
        final C0496b f1184c;

        /* renamed from: d */
        Resources f1185d;

        /* renamed from: e */
        int f1186e = 160;

        /* renamed from: f */
        int f1187f;

        /* renamed from: g */
        int f1188g;

        /* renamed from: h */
        SparseArray<ConstantState> f1189h;

        /* renamed from: i */
        Drawable[] f1190i;

        /* renamed from: j */
        int f1191j;

        /* renamed from: k */
        boolean f1192k;

        /* renamed from: l */
        boolean f1193l;

        /* renamed from: m */
        Rect f1194m;

        /* renamed from: n */
        boolean f1195n;

        /* renamed from: o */
        boolean f1196o;

        /* renamed from: p */
        int f1197p;

        /* renamed from: q */
        int f1198q;

        /* renamed from: r */
        int f1199r;

        /* renamed from: s */
        int f1200s;

        /* renamed from: t */
        boolean f1201t;

        /* renamed from: u */
        int f1202u;

        /* renamed from: v */
        boolean f1203v;

        /* renamed from: w */
        boolean f1204w;

        /* renamed from: x */
        boolean f1205x;

        /* renamed from: y */
        boolean f1206y;

        /* renamed from: z */
        boolean f1207z;

        C0499b(C0499b bVar, C0496b bVar2, Resources resources) {
            this.f1192k = false;
            this.f1195n = false;
            this.f1207z = true;
            this.f1175C = 0;
            this.f1176D = 0;
            this.f1184c = bVar2;
            Resources resources2 = resources != null ? resources : bVar != null ? bVar.f1185d : null;
            this.f1185d = resources2;
            this.f1186e = C0496b.m1585a(resources, bVar != null ? bVar.f1186e : 0);
            if (bVar != null) {
                this.f1187f = bVar.f1187f;
                this.f1188g = bVar.f1188g;
                this.f1205x = true;
                this.f1206y = true;
                this.f1192k = bVar.f1192k;
                this.f1195n = bVar.f1195n;
                this.f1207z = bVar.f1207z;
                this.f1173A = bVar.f1173A;
                this.f1174B = bVar.f1174B;
                this.f1175C = bVar.f1175C;
                this.f1176D = bVar.f1176D;
                this.f1177E = bVar.f1177E;
                this.f1178F = bVar.f1178F;
                this.f1179G = bVar.f1179G;
                this.f1180H = bVar.f1180H;
                this.f1181I = bVar.f1181I;
                this.f1182J = bVar.f1182J;
                this.f1183K = bVar.f1183K;
                if (bVar.f1186e == this.f1186e) {
                    if (bVar.f1193l) {
                        this.f1194m = new Rect(bVar.f1194m);
                        this.f1193l = true;
                    }
                    if (bVar.f1196o) {
                        this.f1197p = bVar.f1197p;
                        this.f1198q = bVar.f1198q;
                        this.f1199r = bVar.f1199r;
                        this.f1200s = bVar.f1200s;
                        this.f1196o = true;
                    }
                }
                if (bVar.f1201t) {
                    this.f1202u = bVar.f1202u;
                    this.f1201t = true;
                }
                if (bVar.f1203v) {
                    this.f1204w = bVar.f1204w;
                    this.f1203v = true;
                }
                Drawable[] drawableArr = bVar.f1190i;
                this.f1190i = new Drawable[drawableArr.length];
                this.f1191j = bVar.f1191j;
                SparseArray<ConstantState> sparseArray = bVar.f1189h;
                if (sparseArray != null) {
                    this.f1189h = sparseArray.clone();
                } else {
                    this.f1189h = new SparseArray<>(this.f1191j);
                }
                int i = this.f1191j;
                for (int i2 = 0; i2 < i; i2++) {
                    if (drawableArr[i2] != null) {
                        ConstantState constantState = drawableArr[i2].getConstantState();
                        if (constantState != null) {
                            this.f1189h.put(i2, constantState);
                        } else {
                            this.f1190i[i2] = drawableArr[i2];
                        }
                    }
                }
                return;
            }
            this.f1190i = new Drawable[10];
            this.f1191j = 0;
        }

        public int getChangingConfigurations() {
            return this.f1187f | this.f1188g;
        }

        /* renamed from: a */
        public final int mo1178a(Drawable drawable) {
            int i = this.f1191j;
            if (i >= this.f1190i.length) {
                mo1192e(i, i + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.f1184c);
            this.f1190i[i] = drawable;
            this.f1191j++;
            this.f1188g = drawable.getChangingConfigurations() | this.f1188g;
            mo1183b();
            this.f1194m = null;
            this.f1193l = false;
            this.f1196o = false;
            this.f1205x = false;
            return i;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo1183b() {
            this.f1201t = false;
            this.f1203v = false;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public final int mo1185c() {
            return this.f1190i.length;
        }

        /* renamed from: o */
        private void m1597o() {
            if (this.f1189h != null) {
                int size = this.f1189h.size();
                for (int i = 0; i < size; i++) {
                    this.f1190i[this.f1189h.keyAt(i)] = m1596b(((ConstantState) this.f1189h.valueAt(i)).newDrawable(this.f1185d));
                }
                this.f1189h = null;
            }
        }

        /* renamed from: b */
        private Drawable m1596b(Drawable drawable) {
            if (VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(this.f1174B);
            }
            Drawable mutate = drawable.mutate();
            mutate.setCallback(this.f1184c);
            return mutate;
        }

        /* renamed from: d */
        public final int mo1188d() {
            return this.f1191j;
        }

        /* renamed from: b */
        public final Drawable mo1182b(int i) {
            Drawable drawable = this.f1190i[i];
            if (drawable != null) {
                return drawable;
            }
            if (this.f1189h != null) {
                int indexOfKey = this.f1189h.indexOfKey(i);
                if (indexOfKey >= 0) {
                    Drawable b = m1596b(((ConstantState) this.f1189h.valueAt(indexOfKey)).newDrawable(this.f1185d));
                    this.f1190i[i] = b;
                    this.f1189h.removeAt(indexOfKey);
                    if (this.f1189h.size() == 0) {
                        this.f1189h = null;
                    }
                    return b;
                }
            }
            return null;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public final boolean mo1190d(int i, int i2) {
            int i3 = this.f1191j;
            Drawable[] drawableArr = this.f1190i;
            boolean z = false;
            for (int i4 = 0; i4 < i3; i4++) {
                if (drawableArr[i4] != null) {
                    boolean layoutDirection = VERSION.SDK_INT >= 23 ? drawableArr[i4].setLayoutDirection(i) : false;
                    if (i4 == i2) {
                        z = layoutDirection;
                    }
                }
            }
            this.f1174B = i;
            return z;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public final void mo1180a(Resources resources) {
            if (resources != null) {
                this.f1185d = resources;
                int a = C0496b.m1585a(resources, this.f1186e);
                int i = this.f1186e;
                this.f1186e = a;
                if (i != a) {
                    this.f1196o = false;
                    this.f1193l = false;
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public final void mo1179a(Theme theme) {
            if (theme != null) {
                m1597o();
                int i = this.f1191j;
                Drawable[] drawableArr = this.f1190i;
                for (int i2 = 0; i2 < i; i2++) {
                    if (drawableArr[i2] != null && drawableArr[i2].canApplyTheme()) {
                        drawableArr[i2].applyTheme(theme);
                        this.f1188g |= drawableArr[i2].getChangingConfigurations();
                    }
                }
                mo1180a(theme.getResources());
            }
        }

        public boolean canApplyTheme() {
            int i = this.f1191j;
            Drawable[] drawableArr = this.f1190i;
            for (int i2 = 0; i2 < i; i2++) {
                Drawable drawable = drawableArr[i2];
                if (drawable == null) {
                    ConstantState constantState = (ConstantState) this.f1189h.get(i2);
                    if (constantState != null && constantState.canApplyTheme()) {
                        return true;
                    }
                } else if (drawable.canApplyTheme()) {
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo1155a() {
            int i = this.f1191j;
            Drawable[] drawableArr = this.f1190i;
            for (int i2 = 0; i2 < i; i2++) {
                if (drawableArr[i2] != null) {
                    drawableArr[i2].mutate();
                }
            }
            this.f1173A = true;
        }

        /* renamed from: a */
        public final void mo1181a(boolean z) {
            this.f1192k = z;
        }

        /* renamed from: e */
        public final Rect mo1191e() {
            if (this.f1192k) {
                return null;
            }
            if (this.f1194m != null || this.f1193l) {
                return this.f1194m;
            }
            m1597o();
            Rect rect = new Rect();
            int i = this.f1191j;
            Drawable[] drawableArr = this.f1190i;
            Rect rect2 = null;
            for (int i2 = 0; i2 < i; i2++) {
                if (drawableArr[i2].getPadding(rect)) {
                    if (rect2 == null) {
                        rect2 = new Rect(0, 0, 0, 0);
                    }
                    if (rect.left > rect2.left) {
                        rect2.left = rect.left;
                    }
                    if (rect.top > rect2.top) {
                        rect2.top = rect.top;
                    }
                    if (rect.right > rect2.right) {
                        rect2.right = rect.right;
                    }
                    if (rect.bottom > rect2.bottom) {
                        rect2.bottom = rect.bottom;
                    }
                }
            }
            this.f1193l = true;
            this.f1194m = rect2;
            return rect2;
        }

        /* renamed from: b */
        public final void mo1184b(boolean z) {
            this.f1195n = z;
        }

        /* renamed from: f */
        public final boolean mo1193f() {
            return this.f1195n;
        }

        /* renamed from: g */
        public final int mo1194g() {
            if (!this.f1196o) {
                mo1199k();
            }
            return this.f1197p;
        }

        /* renamed from: h */
        public final int mo1196h() {
            if (!this.f1196o) {
                mo1199k();
            }
            return this.f1198q;
        }

        /* renamed from: i */
        public final int mo1197i() {
            if (!this.f1196o) {
                mo1199k();
            }
            return this.f1199r;
        }

        /* renamed from: j */
        public final int mo1198j() {
            if (!this.f1196o) {
                mo1199k();
            }
            return this.f1200s;
        }

        /* access modifiers changed from: protected */
        /* renamed from: k */
        public void mo1199k() {
            this.f1196o = true;
            m1597o();
            int i = this.f1191j;
            Drawable[] drawableArr = this.f1190i;
            this.f1198q = -1;
            this.f1197p = -1;
            this.f1200s = 0;
            this.f1199r = 0;
            for (int i2 = 0; i2 < i; i2++) {
                Drawable drawable = drawableArr[i2];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.f1197p) {
                    this.f1197p = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.f1198q) {
                    this.f1198q = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.f1199r) {
                    this.f1199r = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.f1200s) {
                    this.f1200s = minimumHeight;
                }
            }
        }

        /* renamed from: c */
        public final void mo1186c(int i) {
            this.f1175C = i;
        }

        /* renamed from: d */
        public final void mo1189d(int i) {
            this.f1176D = i;
        }

        /* renamed from: l */
        public final int mo1200l() {
            if (this.f1201t) {
                return this.f1202u;
            }
            m1597o();
            int i = this.f1191j;
            Drawable[] drawableArr = this.f1190i;
            int opacity = i > 0 ? drawableArr[0].getOpacity() : -2;
            for (int i2 = 1; i2 < i; i2++) {
                opacity = Drawable.resolveOpacity(opacity, drawableArr[i2].getOpacity());
            }
            this.f1202u = opacity;
            this.f1201t = true;
            return opacity;
        }

        /* renamed from: m */
        public final boolean mo1201m() {
            if (this.f1203v) {
                return this.f1204w;
            }
            m1597o();
            int i = this.f1191j;
            Drawable[] drawableArr = this.f1190i;
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    break;
                } else if (drawableArr[i2].isStateful()) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            this.f1204w = z;
            this.f1203v = true;
            return z;
        }

        /* renamed from: e */
        public void mo1192e(int i, int i2) {
            Drawable[] drawableArr = new Drawable[i2];
            System.arraycopy(this.f1190i, 0, drawableArr, 0, i);
            this.f1190i = drawableArr;
        }

        /* renamed from: n */
        public synchronized boolean mo1202n() {
            if (this.f1205x) {
                return this.f1206y;
            }
            m1597o();
            this.f1205x = true;
            int i = this.f1191j;
            Drawable[] drawableArr = this.f1190i;
            for (int i2 = 0; i2 < i; i2++) {
                if (drawableArr[i2].getConstantState() == null) {
                    this.f1206y = false;
                    return false;
                }
            }
            this.f1206y = true;
            return true;
        }
    }

    C0496b() {
    }

    public void draw(Canvas canvas) {
        if (this.f1160c != null) {
            this.f1160c.draw(canvas);
        }
        if (this.f1161d != null) {
            this.f1161d.draw(canvas);
        }
    }

    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f1158a.getChangingConfigurations();
    }

    @SuppressLint({"WrongConstant"})
    @TargetApi(23)
    /* renamed from: a */
    private boolean mo1111a() {
        return isAutoMirrored() && getLayoutDirection() == 1;
    }

    public boolean getPadding(Rect rect) {
        boolean z;
        Rect e = this.f1158a.mo1191e();
        if (e != null) {
            rect.set(e);
            z = (e.right | ((e.left | e.top) | e.bottom)) != 0;
        } else {
            z = this.f1160c != null ? this.f1160c.getPadding(rect) : super.getPadding(rect);
        }
        if (mo1111a()) {
            int i = rect.left;
            rect.left = rect.right;
            rect.right = i;
        }
        return z;
    }

    public void getOutline(Outline outline) {
        if (this.f1160c != null) {
            this.f1160c.getOutline(outline);
        }
    }

    public void setAlpha(int i) {
        if (!this.f1163f || this.f1162e != i) {
            this.f1163f = true;
            this.f1162e = i;
            if (this.f1160c == null) {
                return;
            }
            if (this.f1168k == 0) {
                this.f1160c.setAlpha(i);
            } else {
                mo1166a(false);
            }
        }
    }

    public int getAlpha() {
        return this.f1162e;
    }

    public void setDither(boolean z) {
        if (this.f1158a.f1207z != z) {
            this.f1158a.f1207z = z;
            if (this.f1160c != null) {
                this.f1160c.setDither(this.f1158a.f1207z);
            }
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f1158a.f1179G = true;
        if (this.f1158a.f1178F != colorFilter) {
            this.f1158a.f1178F = colorFilter;
            if (this.f1160c != null) {
                this.f1160c.setColorFilter(colorFilter);
            }
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f1158a.f1182J = true;
        if (this.f1158a.f1180H != colorStateList) {
            this.f1158a.f1180H = colorStateList;
            C0983a.m3698a(this.f1160c, colorStateList);
        }
    }

    public void setTintMode(Mode mode) {
        this.f1158a.f1183K = true;
        if (this.f1158a.f1181I != mode) {
            this.f1158a.f1181I = mode;
            C0983a.m3701a(this.f1160c, mode);
        }
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        if (this.f1161d != null) {
            this.f1161d.setBounds(rect);
        }
        if (this.f1160c != null) {
            this.f1160c.setBounds(rect);
        }
    }

    public boolean isStateful() {
        return this.f1158a.mo1201m();
    }

    public void setAutoMirrored(boolean z) {
        if (this.f1158a.f1177E != z) {
            this.f1158a.f1177E = z;
            if (this.f1160c != null) {
                C0983a.m3702a(this.f1160c, this.f1158a.f1177E);
            }
        }
    }

    public boolean isAutoMirrored() {
        return this.f1158a.f1177E;
    }

    public void jumpToCurrentState() {
        boolean z;
        if (this.f1161d != null) {
            this.f1161d.jumpToCurrentState();
            this.f1161d = null;
            this.f1165h = -1;
            z = true;
        } else {
            z = false;
        }
        if (this.f1160c != null) {
            this.f1160c.jumpToCurrentState();
            if (this.f1163f) {
                this.f1160c.setAlpha(this.f1162e);
            }
        }
        if (this.f1169l != 0) {
            this.f1169l = 0;
            z = true;
        }
        if (this.f1168k != 0) {
            this.f1168k = 0;
            z = true;
        }
        if (z) {
            invalidateSelf();
        }
    }

    public void setHotspot(float f, float f2) {
        if (this.f1160c != null) {
            C0983a.m3695a(this.f1160c, f, f2);
        }
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        if (this.f1159b == null) {
            this.f1159b = new Rect(i, i2, i3, i4);
        } else {
            this.f1159b.set(i, i2, i3, i4);
        }
        if (this.f1160c != null) {
            C0983a.m3697a(this.f1160c, i, i2, i3, i4);
        }
    }

    public void getHotspotBounds(Rect rect) {
        if (this.f1159b != null) {
            rect.set(this.f1159b);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        if (this.f1161d != null) {
            return this.f1161d.setState(iArr);
        }
        if (this.f1160c != null) {
            return this.f1160c.setState(iArr);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i) {
        if (this.f1161d != null) {
            return this.f1161d.setLevel(i);
        }
        if (this.f1160c != null) {
            return this.f1160c.setLevel(i);
        }
        return false;
    }

    public boolean onLayoutDirectionChanged(int i) {
        return this.f1158a.mo1190d(i, mo1168d());
    }

    public int getIntrinsicWidth() {
        if (this.f1158a.mo1193f()) {
            return this.f1158a.mo1194g();
        }
        return this.f1160c != null ? this.f1160c.getIntrinsicWidth() : -1;
    }

    public int getIntrinsicHeight() {
        if (this.f1158a.mo1193f()) {
            return this.f1158a.mo1196h();
        }
        return this.f1160c != null ? this.f1160c.getIntrinsicHeight() : -1;
    }

    public int getMinimumWidth() {
        if (this.f1158a.mo1193f()) {
            return this.f1158a.mo1197i();
        }
        return this.f1160c != null ? this.f1160c.getMinimumWidth() : 0;
    }

    public int getMinimumHeight() {
        if (this.f1158a.mo1193f()) {
            return this.f1158a.mo1198j();
        }
        return this.f1160c != null ? this.f1160c.getMinimumHeight() : 0;
    }

    public void invalidateDrawable(Drawable drawable) {
        if (this.f1158a != null) {
            this.f1158a.mo1183b();
        }
        if (drawable == this.f1160c && getCallback() != null) {
            getCallback().invalidateDrawable(this);
        }
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        if (drawable == this.f1160c && getCallback() != null) {
            getCallback().scheduleDrawable(this, runnable, j);
        }
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable == this.f1160c && getCallback() != null) {
            getCallback().unscheduleDrawable(this, runnable);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (this.f1161d != null) {
            this.f1161d.setVisible(z, z2);
        }
        if (this.f1160c != null) {
            this.f1160c.setVisible(z, z2);
        }
        return visible;
    }

    public int getOpacity() {
        if (this.f1160c == null || !this.f1160c.isVisible()) {
            return -2;
        }
        return this.f1158a.mo1200l();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public int mo1168d() {
        return this.f1164g;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo1167a(int i) {
        if (i == this.f1164g) {
            return false;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.f1158a.f1176D > 0) {
            if (this.f1161d != null) {
                this.f1161d.setVisible(false, false);
            }
            if (this.f1160c != null) {
                this.f1161d = this.f1160c;
                this.f1165h = this.f1164g;
                this.f1169l = ((long) this.f1158a.f1176D) + uptimeMillis;
            } else {
                this.f1161d = null;
                this.f1165h = -1;
                this.f1169l = 0;
            }
        } else if (this.f1160c != null) {
            this.f1160c.setVisible(false, false);
        }
        if (i < 0 || i >= this.f1158a.f1191j) {
            this.f1160c = null;
            this.f1164g = -1;
        } else {
            Drawable b = this.f1158a.mo1182b(i);
            this.f1160c = b;
            this.f1164g = i;
            if (b != null) {
                if (this.f1158a.f1175C > 0) {
                    this.f1168k = uptimeMillis + ((long) this.f1158a.f1175C);
                }
                m1586a(b);
            }
        }
        if (!(this.f1168k == 0 && this.f1169l == 0)) {
            if (this.f1167j == null) {
                this.f1167j = new Runnable() {
                    public void run() {
                        C0496b.this.mo1166a(true);
                        C0496b.this.invalidateSelf();
                    }
                };
            } else {
                unscheduleSelf(this.f1167j);
            }
            mo1166a(true);
        }
        invalidateSelf();
        return true;
    }

    /* renamed from: a */
    private void m1586a(Drawable drawable) {
        if (this.f1170m == null) {
            this.f1170m = new C0498a();
        }
        drawable.setCallback(this.f1170m.mo1174a(drawable.getCallback()));
        try {
            if (this.f1158a.f1175C <= 0 && this.f1163f) {
                drawable.setAlpha(this.f1162e);
            }
            if (this.f1158a.f1179G) {
                drawable.setColorFilter(this.f1158a.f1178F);
            } else {
                if (this.f1158a.f1182J) {
                    C0983a.m3698a(drawable, this.f1158a.f1180H);
                }
                if (this.f1158a.f1183K) {
                    C0983a.m3701a(drawable, this.f1158a.f1181I);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f1158a.f1207z);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(getLayoutDirection());
            }
            if (VERSION.SDK_INT >= 19) {
                drawable.setAutoMirrored(this.f1158a.f1177E);
            }
            Rect rect = this.f1159b;
            if (VERSION.SDK_INT >= 21 && rect != null) {
                drawable.setHotspotBounds(rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            drawable.setCallback(this.f1170m.mo1173a());
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007d A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo1166a(boolean r12) {
        /*
            r11 = this;
            r0 = 1
            r11.f1163f = r0
            long r1 = android.os.SystemClock.uptimeMillis()
            android.graphics.drawable.Drawable r3 = r11.f1160c
            r4 = 255(0xff, double:1.26E-321)
            r6 = 0
            r7 = 0
            if (r3 == 0) goto L_0x0040
            long r9 = r11.f1168k
            int r3 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x0042
            long r9 = r11.f1168k
            int r3 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r3 > 0) goto L_0x0026
            android.graphics.drawable.Drawable r3 = r11.f1160c
            int r9 = r11.f1162e
            r3.setAlpha(r9)
            r11.f1168k = r7
            goto L_0x0042
        L_0x0026:
            long r9 = r11.f1168k
            long r9 = r9 - r1
            long r9 = r9 * r4
            int r3 = (int) r9
            androidx.appcompat.b.a.b$b r9 = r11.f1158a
            int r9 = r9.f1175C
            int r3 = r3 / r9
            android.graphics.drawable.Drawable r9 = r11.f1160c
            int r3 = 255 - r3
            int r10 = r11.f1162e
            int r3 = r3 * r10
            int r3 = r3 / 255
            r9.setAlpha(r3)
            r3 = 1
            goto L_0x0043
        L_0x0040:
            r11.f1168k = r7
        L_0x0042:
            r3 = 0
        L_0x0043:
            android.graphics.drawable.Drawable r9 = r11.f1161d
            if (r9 == 0) goto L_0x0078
            long r9 = r11.f1169l
            int r9 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r9 == 0) goto L_0x007a
            long r9 = r11.f1169l
            int r9 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r9 > 0) goto L_0x0061
            android.graphics.drawable.Drawable r0 = r11.f1161d
            r0.setVisible(r6, r6)
            r0 = 0
            r11.f1161d = r0
            r0 = -1
            r11.f1165h = r0
            r11.f1169l = r7
            goto L_0x007a
        L_0x0061:
            long r6 = r11.f1169l
            long r6 = r6 - r1
            long r6 = r6 * r4
            int r3 = (int) r6
            androidx.appcompat.b.a.b$b r4 = r11.f1158a
            int r4 = r4.f1176D
            int r3 = r3 / r4
            android.graphics.drawable.Drawable r4 = r11.f1161d
            int r5 = r11.f1162e
            int r3 = r3 * r5
            int r3 = r3 / 255
            r4.setAlpha(r3)
            goto L_0x007b
        L_0x0078:
            r11.f1169l = r7
        L_0x007a:
            r0 = r3
        L_0x007b:
            if (r12 == 0) goto L_0x0087
            if (r0 == 0) goto L_0x0087
            java.lang.Runnable r12 = r11.f1167j
            r3 = 16
            long r1 = r1 + r3
            r11.scheduleSelf(r12, r1)
        L_0x0087:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.p049b.p050a.C0496b.mo1166a(boolean):void");
    }

    public Drawable getCurrent() {
        return this.f1160c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo1165a(Resources resources) {
        this.f1158a.mo1180a(resources);
    }

    public void applyTheme(Theme theme) {
        this.f1158a.mo1179a(theme);
    }

    public boolean canApplyTheme() {
        return this.f1158a.canApplyTheme();
    }

    public final ConstantState getConstantState() {
        if (!this.f1158a.mo1202n()) {
            return null;
        }
        this.f1158a.f1187f = getChangingConfigurations();
        return this.f1158a;
    }

    public Drawable mutate() {
        if (!this.f1166i && super.mutate() == this) {
            C0499b c = mo1116c();
            c.mo1155a();
            mo1112a(c);
            this.f1166i = true;
        }
        return this;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public C0499b mo1116c() {
        return this.f1158a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo1112a(C0499b bVar) {
        this.f1158a = bVar;
        if (this.f1164g >= 0) {
            this.f1160c = bVar.mo1182b(this.f1164g);
            if (this.f1160c != null) {
                m1586a(this.f1160c);
            }
        }
        this.f1165h = -1;
        this.f1161d = null;
    }

    /* renamed from: a */
    static int m1585a(Resources resources, int i) {
        if (resources != null) {
            i = resources.getDisplayMetrics().densityDpi;
        }
        if (i == 0) {
            return 160;
        }
        return i;
    }
}
