package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.squareup.picasso.C3068t.C3074d;

/* renamed from: com.squareup.picasso.l */
/* compiled from: ImageViewAction */
class C3055l extends C3021a<ImageView> {

    /* renamed from: m */
    C3044e f7983m;

    C3055l(C3068t tVar, ImageView imageView, C3081w wVar, int i, int i2, int i3, Drawable drawable, String str, Object obj, C3044e eVar, boolean z) {
        super(tVar, imageView, wVar, i, i2, i3, drawable, str, obj, z);
        this.f7983m = eVar;
    }

    /* renamed from: a */
    public void mo27419a(Bitmap bitmap, C3074d dVar) {
        if (bitmap != null) {
            ImageView imageView = (ImageView) this.f7879c.get();
            if (imageView != null) {
                Bitmap bitmap2 = bitmap;
                C3074d dVar2 = dVar;
                C3078u.m9078a(imageView, this.f7877a.f8021c, bitmap2, dVar2, this.f7880d, this.f7877a.f8029k);
                if (this.f7983m != null) {
                    this.f7983m.mo27484a();
                }
                return;
            }
            return;
        }
        throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", new Object[]{this}));
    }

    /* renamed from: a */
    public void mo27420a(Exception exc) {
        ImageView imageView = (ImageView) this.f7879c.get();
        if (imageView != null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable instanceof Animatable) {
                ((Animatable) drawable).stop();
            }
            if (this.f7883g != 0) {
                imageView.setImageResource(this.f7883g);
            } else if (this.f7884h != null) {
                imageView.setImageDrawable(this.f7884h);
            }
            if (this.f7983m != null) {
                this.f7983m.mo27485a(exc);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo27418a() {
        super.mo27418a();
        if (this.f7983m != null) {
            this.f7983m = null;
        }
    }
}
