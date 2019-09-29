package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.util.Log;
import java.lang.reflect.Method;

/* renamed from: androidx.core.graphics.drawable.e */
/* compiled from: WrappedDrawableApi21 */
class C0989e extends C0986d {

    /* renamed from: d */
    private static Method f3073d;

    /* renamed from: androidx.core.graphics.drawable.e$a */
    /* compiled from: WrappedDrawableApi21 */
    private static class C0990a extends C0987a {
        C0990a(C0987a aVar, Resources resources) {
            super(aVar, resources);
        }

        public Drawable newDrawable(Resources resources) {
            return new C0989e(this, resources);
        }
    }

    C0989e(Drawable drawable) {
        super(drawable);
        m3721d();
    }

    C0989e(C0987a aVar, Resources resources) {
        super(aVar, resources);
        m3721d();
    }

    public void setHotspot(float f, float f2) {
        this.f3064c.setHotspot(f, f2);
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        this.f3064c.setHotspotBounds(i, i2, i3, i4);
    }

    public void getOutline(Outline outline) {
        this.f3064c.getOutline(outline);
    }

    public Rect getDirtyBounds() {
        return this.f3064c.getDirtyBounds();
    }

    public void setTintList(ColorStateList colorStateList) {
        if (mo3801c()) {
            super.setTintList(colorStateList);
        } else {
            this.f3064c.setTintList(colorStateList);
        }
    }

    public void setTint(int i) {
        if (mo3801c()) {
            super.setTint(i);
        } else {
            this.f3064c.setTint(i);
        }
    }

    public void setTintMode(Mode mode) {
        if (mo3801c()) {
            super.setTintMode(mode);
        } else {
            this.f3064c.setTintMode(mode);
        }
    }

    public boolean setState(int[] iArr) {
        if (!super.setState(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public boolean mo3801c() {
        boolean z = false;
        if (VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.f3064c;
        if ((drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable) || (drawable instanceof RippleDrawable)) {
            z = true;
        }
        return z;
    }

    public boolean isProjected() {
        if (!(this.f3064c == null || f3073d == null)) {
            try {
                return ((Boolean) f3073d.invoke(this.f3064c, new Object[0])).booleanValue();
            } catch (Exception e) {
                Log.w("WrappedDrawableApi21", "Error calling Drawable#isProjected() method", e);
            }
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C0987a mo3800b() {
        return new C0990a(this.f3063b, null);
    }

    /* renamed from: d */
    private void m3721d() {
        if (f3073d == null) {
            try {
                f3073d = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
            } catch (Exception e) {
                Log.w("WrappedDrawableApi21", "Failed to retrieve Drawable#isProjected() method", e);
            }
        }
    }
}
