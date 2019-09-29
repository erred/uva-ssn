package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;

/* renamed from: androidx.core.graphics.drawable.d */
/* compiled from: WrappedDrawableApi14 */
class C0986d extends Drawable implements Callback, C0984b, C0985c {

    /* renamed from: a */
    static final Mode f3062a = Mode.SRC_IN;

    /* renamed from: b */
    C0987a f3063b;

    /* renamed from: c */
    Drawable f3064c;

    /* renamed from: d */
    private int f3065d;

    /* renamed from: e */
    private Mode f3066e;

    /* renamed from: f */
    private boolean f3067f;

    /* renamed from: g */
    private boolean f3068g;

    /* renamed from: androidx.core.graphics.drawable.d$a */
    /* compiled from: WrappedDrawableApi14 */
    protected static abstract class C0987a extends ConstantState {

        /* renamed from: a */
        int f3069a;

        /* renamed from: b */
        ConstantState f3070b;

        /* renamed from: c */
        ColorStateList f3071c = null;

        /* renamed from: d */
        Mode f3072d = C0986d.f3062a;

        public abstract Drawable newDrawable(Resources resources);

        C0987a(C0987a aVar, Resources resources) {
            if (aVar != null) {
                this.f3069a = aVar.f3069a;
                this.f3070b = aVar.f3070b;
                this.f3071c = aVar.f3071c;
                this.f3072d = aVar.f3072d;
            }
        }

        public Drawable newDrawable() {
            return newDrawable(null);
        }

        public int getChangingConfigurations() {
            return this.f3069a | (this.f3070b != null ? this.f3070b.getChangingConfigurations() : 0);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo3831a() {
            return this.f3070b != null;
        }
    }

    /* renamed from: androidx.core.graphics.drawable.d$b */
    /* compiled from: WrappedDrawableApi14 */
    private static class C0988b extends C0987a {
        C0988b(C0987a aVar, Resources resources) {
            super(aVar, resources);
        }

        public Drawable newDrawable(Resources resources) {
            return new C0986d(this, resources);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public boolean mo3801c() {
        return true;
    }

    C0986d(C0987a aVar, Resources resources) {
        this.f3063b = aVar;
        m3714a(resources);
    }

    C0986d(Drawable drawable) {
        this.f3063b = mo3800b();
        mo3799a(drawable);
    }

    /* renamed from: a */
    private void m3714a(Resources resources) {
        if (this.f3063b != null && this.f3063b.f3070b != null) {
            mo3799a(this.f3063b.f3070b.newDrawable(resources));
        }
    }

    public void jumpToCurrentState() {
        this.f3064c.jumpToCurrentState();
    }

    public void draw(Canvas canvas) {
        this.f3064c.draw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        if (this.f3064c != null) {
            this.f3064c.setBounds(rect);
        }
    }

    public void setChangingConfigurations(int i) {
        this.f3064c.setChangingConfigurations(i);
    }

    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | (this.f3063b != null ? this.f3063b.getChangingConfigurations() : 0) | this.f3064c.getChangingConfigurations();
    }

    public void setDither(boolean z) {
        this.f3064c.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f3064c.setFilterBitmap(z);
    }

    public void setAlpha(int i) {
        this.f3064c.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f3064c.setColorFilter(colorFilter);
    }

    public boolean isStateful() {
        ColorStateList colorStateList = (!mo3801c() || this.f3063b == null) ? null : this.f3063b.f3071c;
        return (colorStateList != null && colorStateList.isStateful()) || this.f3064c.isStateful();
    }

    public boolean setState(int[] iArr) {
        return m3715a(iArr) || this.f3064c.setState(iArr);
    }

    public int[] getState() {
        return this.f3064c.getState();
    }

    public Drawable getCurrent() {
        return this.f3064c.getCurrent();
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f3064c.setVisible(z, z2);
    }

    public int getOpacity() {
        return this.f3064c.getOpacity();
    }

    public Region getTransparentRegion() {
        return this.f3064c.getTransparentRegion();
    }

    public int getIntrinsicWidth() {
        return this.f3064c.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        return this.f3064c.getIntrinsicHeight();
    }

    public int getMinimumWidth() {
        return this.f3064c.getMinimumWidth();
    }

    public int getMinimumHeight() {
        return this.f3064c.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        return this.f3064c.getPadding(rect);
    }

    public void setAutoMirrored(boolean z) {
        this.f3064c.setAutoMirrored(z);
    }

    public boolean isAutoMirrored() {
        return this.f3064c.isAutoMirrored();
    }

    public ConstantState getConstantState() {
        if (this.f3063b == null || !this.f3063b.mo3831a()) {
            return null;
        }
        this.f3063b.f3069a = getChangingConfigurations();
        return this.f3063b;
    }

    public Drawable mutate() {
        if (!this.f3068g && super.mutate() == this) {
            this.f3063b = mo3800b();
            if (this.f3064c != null) {
                this.f3064c.mutate();
            }
            if (this.f3063b != null) {
                this.f3063b.f3070b = this.f3064c != null ? this.f3064c.getConstantState() : null;
            }
            this.f3068g = true;
        }
        return this;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C0987a mo3800b() {
        return new C0988b(this.f3063b, null);
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i) {
        return this.f3064c.setLevel(i);
    }

    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f3063b.f3071c = colorStateList;
        m3715a(getState());
    }

    public void setTintMode(Mode mode) {
        this.f3063b.f3072d = mode;
        m3715a(getState());
    }

    /* renamed from: a */
    private boolean m3715a(int[] iArr) {
        if (!mo3801c()) {
            return false;
        }
        ColorStateList colorStateList = this.f3063b.f3071c;
        Mode mode = this.f3063b.f3072d;
        if (colorStateList == null || mode == null) {
            this.f3067f = false;
            clearColorFilter();
        } else {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!(this.f3067f && colorForState == this.f3065d && mode == this.f3066e)) {
                setColorFilter(colorForState, mode);
                this.f3065d = colorForState;
                this.f3066e = mode;
                this.f3067f = true;
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public final Drawable mo3798a() {
        return this.f3064c;
    }

    /* renamed from: a */
    public final void mo3799a(Drawable drawable) {
        if (this.f3064c != null) {
            this.f3064c.setCallback(null);
        }
        this.f3064c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            if (this.f3063b != null) {
                this.f3063b.f3070b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }
}
