package com.twitter.sdk.android.tweetui.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* renamed from: com.twitter.sdk.android.tweetui.internal.e */
/* compiled from: OverlayImageView */
public class C3351e extends ImageView {

    /* renamed from: a */
    C3352a f8758a = new C3352a(null);

    /* renamed from: com.twitter.sdk.android.tweetui.internal.e$a */
    /* compiled from: OverlayImageView */
    protected static class C3352a {

        /* renamed from: a */
        final Drawable f8759a;

        C3352a(Drawable drawable) {
            this.f8759a = drawable;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo28139a(ImageView imageView) {
            if (this.f8759a != null) {
                this.f8759a.setCallback(null);
                imageView.unscheduleDrawable(this.f8759a);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo28137a(int i, int i2) {
            if (this.f8759a != null) {
                this.f8759a.setBounds(0, 0, i, i2);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo28140a(int[] iArr) {
            if (this.f8759a != null && this.f8759a.isStateful()) {
                this.f8759a.setState(iArr);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo28138a(Canvas canvas) {
            if (this.f8759a != null) {
                this.f8759a.draw(canvas);
            }
        }
    }

    public C3351e(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f8758a.mo28138a(canvas);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.f8758a.mo28140a(getDrawableState());
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f8758a.mo28137a(getMeasuredWidth(), getMeasuredHeight());
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f8758a.mo28137a(i, i2);
    }

    public void invalidateDrawable(Drawable drawable) {
        if (drawable == this.f8758a.f8759a) {
            invalidate();
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    public void setOverlayDrawable(Drawable drawable) {
        if (drawable != this.f8758a.f8759a) {
            this.f8758a.mo28139a((ImageView) this);
            if (drawable != null) {
                drawable.setCallback(this);
            }
            this.f8758a = new C3352a(drawable);
            this.f8758a.mo28140a(getDrawableState());
            requestLayout();
        }
    }
}
