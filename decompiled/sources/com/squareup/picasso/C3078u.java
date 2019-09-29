package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.widget.ImageView;
import com.squareup.picasso.C3068t.C3074d;

/* renamed from: com.squareup.picasso.u */
/* compiled from: PicassoDrawable */
final class C3078u extends BitmapDrawable {

    /* renamed from: e */
    private static final Paint f8060e = new Paint();

    /* renamed from: a */
    Drawable f8061a;

    /* renamed from: b */
    long f8062b;

    /* renamed from: c */
    boolean f8063c;

    /* renamed from: d */
    int f8064d = 255;

    /* renamed from: f */
    private final boolean f8065f;

    /* renamed from: g */
    private final float f8066g;

    /* renamed from: h */
    private final C3074d f8067h;

    /* renamed from: a */
    static void m9078a(ImageView imageView, Context context, Bitmap bitmap, C3074d dVar, boolean z, boolean z2) {
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).stop();
        }
        C3078u uVar = new C3078u(context, bitmap, drawable, dVar, z, z2);
        imageView.setImageDrawable(uVar);
    }

    /* renamed from: a */
    static void m9079a(ImageView imageView, Drawable drawable) {
        imageView.setImageDrawable(drawable);
        if (imageView.getDrawable() instanceof Animatable) {
            ((Animatable) imageView.getDrawable()).start();
        }
    }

    C3078u(Context context, Bitmap bitmap, Drawable drawable, C3074d dVar, boolean z, boolean z2) {
        super(context.getResources(), bitmap);
        this.f8065f = z2;
        this.f8066g = context.getResources().getDisplayMetrics().density;
        this.f8067h = dVar;
        if (dVar != C3074d.MEMORY && !z) {
            this.f8061a = drawable;
            this.f8063c = true;
            this.f8062b = SystemClock.uptimeMillis();
        }
    }

    public void draw(Canvas canvas) {
        if (!this.f8063c) {
            super.draw(canvas);
        } else {
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f8062b)) / 200.0f;
            if (uptimeMillis >= 1.0f) {
                this.f8063c = false;
                this.f8061a = null;
                super.draw(canvas);
            } else {
                if (this.f8061a != null) {
                    this.f8061a.draw(canvas);
                }
                super.setAlpha((int) (((float) this.f8064d) * uptimeMillis));
                super.draw(canvas);
                super.setAlpha(this.f8064d);
            }
        }
        if (this.f8065f) {
            m9077a(canvas);
        }
    }

    public void setAlpha(int i) {
        this.f8064d = i;
        if (this.f8061a != null) {
            this.f8061a.setAlpha(i);
        }
        super.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f8061a != null) {
            this.f8061a.setColorFilter(colorFilter);
        }
        super.setColorFilter(colorFilter);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        if (this.f8061a != null) {
            this.f8061a.setBounds(rect);
        }
        super.onBoundsChange(rect);
    }

    /* renamed from: a */
    private void m9077a(Canvas canvas) {
        f8060e.setColor(-1);
        canvas.drawPath(m9076a(0, 0, (int) (this.f8066g * 16.0f)), f8060e);
        f8060e.setColor(this.f8067h.f8054d);
        canvas.drawPath(m9076a(0, 0, (int) (this.f8066g * 15.0f)), f8060e);
    }

    /* renamed from: a */
    private static Path m9076a(int i, int i2, int i3) {
        Path path = new Path();
        float f = (float) i;
        float f2 = (float) i2;
        path.moveTo(f, f2);
        path.lineTo((float) (i + i3), f2);
        path.lineTo(f, (float) (i2 + i3));
        return path;
    }
}
