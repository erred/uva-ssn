package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;
import androidx.appcompat.R;
import androidx.core.p070g.C0961q;
import androidx.core.widget.C1016k;

/* renamed from: androidx.appcompat.widget.n */
/* compiled from: AppCompatImageButton */
public class C0688n extends ImageButton implements C0961q, C1016k {
    private final C0675f mBackgroundTintHelper;
    private final C0689o mImageHelper;

    public C0688n(Context context) {
        this(context, null);
    }

    public C0688n(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.imageButtonStyle);
    }

    public C0688n(Context context, AttributeSet attributeSet, int i) {
        super(C0642as.m2225a(context), attributeSet, i);
        this.mBackgroundTintHelper = new C0675f(this);
        this.mBackgroundTintHelper.mo2547a(attributeSet, i);
        this.mImageHelper = new C0689o(this);
        this.mImageHelper.mo2620a(attributeSet, i);
    }

    public void setImageResource(int i) {
        this.mImageHelper.mo2617a(i);
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.mImageHelper != null) {
            this.mImageHelper.mo2624d();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.mImageHelper != null) {
            this.mImageHelper.mo2624d();
        }
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        if (this.mImageHelper != null) {
            this.mImageHelper.mo2624d();
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.mBackgroundTintHelper != null) {
            this.mBackgroundTintHelper.mo2543a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.mBackgroundTintHelper != null) {
            this.mBackgroundTintHelper.mo2546a(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.mBackgroundTintHelper != null) {
            this.mBackgroundTintHelper.mo2544a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        if (this.mBackgroundTintHelper != null) {
            return this.mBackgroundTintHelper.mo2542a();
        }
        return null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.mBackgroundTintHelper != null) {
            this.mBackgroundTintHelper.mo2545a(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        if (this.mBackgroundTintHelper != null) {
            return this.mBackgroundTintHelper.mo2548b();
        }
        return null;
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.mImageHelper != null) {
            this.mImageHelper.mo2618a(colorStateList);
        }
    }

    public ColorStateList getSupportImageTintList() {
        if (this.mImageHelper != null) {
            return this.mImageHelper.mo2622b();
        }
        return null;
    }

    public void setSupportImageTintMode(Mode mode) {
        if (this.mImageHelper != null) {
            this.mImageHelper.mo2619a(mode);
        }
    }

    public Mode getSupportImageTintMode() {
        if (this.mImageHelper != null) {
            return this.mImageHelper.mo2623c();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.mBackgroundTintHelper != null) {
            this.mBackgroundTintHelper.mo2550c();
        }
        if (this.mImageHelper != null) {
            this.mImageHelper.mo2624d();
        }
    }

    public boolean hasOverlappingRendering() {
        return this.mImageHelper.mo2621a() && super.hasOverlappingRendering();
    }
}
