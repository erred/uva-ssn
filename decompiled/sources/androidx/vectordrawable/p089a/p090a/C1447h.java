package androidx.vectordrawable.p089a.p090a;

import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.C0983a;
import androidx.core.graphics.drawable.C0984b;

/* renamed from: androidx.vectordrawable.a.a.h */
/* compiled from: VectorDrawableCommon */
abstract class C1447h extends Drawable implements C0984b {

    /* renamed from: c */
    Drawable f4275c;

    C1447h() {
    }

    public void setColorFilter(int i, Mode mode) {
        if (this.f4275c != null) {
            this.f4275c.setColorFilter(i, mode);
        } else {
            super.setColorFilter(i, mode);
        }
    }

    public ColorFilter getColorFilter() {
        if (this.f4275c != null) {
            return C0983a.m3707e(this.f4275c);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i) {
        if (this.f4275c != null) {
            return this.f4275c.setLevel(i);
        }
        return super.onLevelChange(i);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        if (this.f4275c != null) {
            this.f4275c.setBounds(rect);
        } else {
            super.onBoundsChange(rect);
        }
    }

    public void setHotspot(float f, float f2) {
        if (this.f4275c != null) {
            C0983a.m3695a(this.f4275c, f, f2);
        }
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        if (this.f4275c != null) {
            C0983a.m3697a(this.f4275c, i, i2, i3, i4);
        }
    }

    public void setFilterBitmap(boolean z) {
        if (this.f4275c != null) {
            this.f4275c.setFilterBitmap(z);
        }
    }

    public void jumpToCurrentState() {
        if (this.f4275c != null) {
            C0983a.m3694a(this.f4275c);
        }
    }

    public void applyTheme(Theme theme) {
        if (this.f4275c != null) {
            C0983a.m3699a(this.f4275c, theme);
        }
    }

    public void clearColorFilter() {
        if (this.f4275c != null) {
            this.f4275c.clearColorFilter();
        } else {
            super.clearColorFilter();
        }
    }

    public Drawable getCurrent() {
        if (this.f4275c != null) {
            return this.f4275c.getCurrent();
        }
        return super.getCurrent();
    }

    public int getMinimumWidth() {
        if (this.f4275c != null) {
            return this.f4275c.getMinimumWidth();
        }
        return super.getMinimumWidth();
    }

    public int getMinimumHeight() {
        if (this.f4275c != null) {
            return this.f4275c.getMinimumHeight();
        }
        return super.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        if (this.f4275c != null) {
            return this.f4275c.getPadding(rect);
        }
        return super.getPadding(rect);
    }

    public int[] getState() {
        if (this.f4275c != null) {
            return this.f4275c.getState();
        }
        return super.getState();
    }

    public Region getTransparentRegion() {
        if (this.f4275c != null) {
            return this.f4275c.getTransparentRegion();
        }
        return super.getTransparentRegion();
    }

    public void setChangingConfigurations(int i) {
        if (this.f4275c != null) {
            this.f4275c.setChangingConfigurations(i);
        } else {
            super.setChangingConfigurations(i);
        }
    }

    public boolean setState(int[] iArr) {
        if (this.f4275c != null) {
            return this.f4275c.setState(iArr);
        }
        return super.setState(iArr);
    }
}
