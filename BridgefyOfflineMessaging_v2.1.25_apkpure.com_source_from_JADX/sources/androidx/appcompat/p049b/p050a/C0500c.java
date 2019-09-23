package androidx.appcompat.p049b.p050a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import androidx.core.graphics.drawable.C0983a;

/* renamed from: androidx.appcompat.b.a.c */
/* compiled from: DrawableWrapper */
public class C0500c extends Drawable implements Callback {
    private Drawable mDrawable;

    public C0500c(Drawable drawable) {
        setWrappedDrawable(drawable);
    }

    public void draw(Canvas canvas) {
        this.mDrawable.draw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.mDrawable.setBounds(rect);
    }

    public void setChangingConfigurations(int i) {
        this.mDrawable.setChangingConfigurations(i);
    }

    public int getChangingConfigurations() {
        return this.mDrawable.getChangingConfigurations();
    }

    public void setDither(boolean z) {
        this.mDrawable.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.mDrawable.setFilterBitmap(z);
    }

    public void setAlpha(int i) {
        this.mDrawable.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mDrawable.setColorFilter(colorFilter);
    }

    public boolean isStateful() {
        return this.mDrawable.isStateful();
    }

    public boolean setState(int[] iArr) {
        return this.mDrawable.setState(iArr);
    }

    public int[] getState() {
        return this.mDrawable.getState();
    }

    public void jumpToCurrentState() {
        C0983a.m3694a(this.mDrawable);
    }

    public Drawable getCurrent() {
        return this.mDrawable.getCurrent();
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.mDrawable.setVisible(z, z2);
    }

    public int getOpacity() {
        return this.mDrawable.getOpacity();
    }

    public Region getTransparentRegion() {
        return this.mDrawable.getTransparentRegion();
    }

    public int getIntrinsicWidth() {
        return this.mDrawable.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        return this.mDrawable.getIntrinsicHeight();
    }

    public int getMinimumWidth() {
        return this.mDrawable.getMinimumWidth();
    }

    public int getMinimumHeight() {
        return this.mDrawable.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        return this.mDrawable.getPadding(rect);
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
        return this.mDrawable.setLevel(i);
    }

    public void setAutoMirrored(boolean z) {
        C0983a.m3702a(this.mDrawable, z);
    }

    public boolean isAutoMirrored() {
        return C0983a.m3703b(this.mDrawable);
    }

    public void setTint(int i) {
        C0983a.m3696a(this.mDrawable, i);
    }

    public void setTintList(ColorStateList colorStateList) {
        C0983a.m3698a(this.mDrawable, colorStateList);
    }

    public void setTintMode(Mode mode) {
        C0983a.m3701a(this.mDrawable, mode);
    }

    public void setHotspot(float f, float f2) {
        C0983a.m3695a(this.mDrawable, f, f2);
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        C0983a.m3697a(this.mDrawable, i, i2, i3, i4);
    }

    public Drawable getWrappedDrawable() {
        return this.mDrawable;
    }

    public void setWrappedDrawable(Drawable drawable) {
        if (this.mDrawable != null) {
            this.mDrawable.setCallback(null);
        }
        this.mDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }
}
