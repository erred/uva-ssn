package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.core.p070g.C0961q;
import androidx.core.widget.C1016k;

/* renamed from: androidx.appcompat.widget.p */
/* compiled from: AppCompatImageView */
public class C0690p extends ImageView implements C0961q, C1016k {

    /* renamed from: a */
    private final C0675f f1999a;

    /* renamed from: b */
    private final C0689o f2000b;

    public C0690p(Context context) {
        this(context, null);
    }

    public C0690p(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C0690p(Context context, AttributeSet attributeSet, int i) {
        super(C0642as.m2225a(context), attributeSet, i);
        this.f1999a = new C0675f(this);
        this.f1999a.mo2547a(attributeSet, i);
        this.f2000b = new C0689o(this);
        this.f2000b.mo2620a(attributeSet, i);
    }

    public void setImageResource(int i) {
        if (this.f2000b != null) {
            this.f2000b.mo2617a(i);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.f2000b != null) {
            this.f2000b.mo2624d();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.f2000b != null) {
            this.f2000b.mo2624d();
        }
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        if (this.f2000b != null) {
            this.f2000b.mo2624d();
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1999a != null) {
            this.f1999a.mo2543a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1999a != null) {
            this.f1999a.mo2546a(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1999a != null) {
            this.f1999a.mo2544a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        if (this.f1999a != null) {
            return this.f1999a.mo2542a();
        }
        return null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f1999a != null) {
            this.f1999a.mo2545a(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        if (this.f1999a != null) {
            return this.f1999a.mo2548b();
        }
        return null;
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.f2000b != null) {
            this.f2000b.mo2618a(colorStateList);
        }
    }

    public ColorStateList getSupportImageTintList() {
        if (this.f2000b != null) {
            return this.f2000b.mo2622b();
        }
        return null;
    }

    public void setSupportImageTintMode(Mode mode) {
        if (this.f2000b != null) {
            this.f2000b.mo2619a(mode);
        }
    }

    public Mode getSupportImageTintMode() {
        if (this.f2000b != null) {
            return this.f2000b.mo2623c();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1999a != null) {
            this.f1999a.mo2550c();
        }
        if (this.f2000b != null) {
            this.f2000b.mo2624d();
        }
    }

    public boolean hasOverlappingRendering() {
        return this.f2000b.mo2621a() && super.hasOverlappingRendering();
    }
}
