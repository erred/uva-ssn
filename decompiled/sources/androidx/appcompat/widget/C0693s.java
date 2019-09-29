package androidx.appcompat.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.core.graphics.drawable.C0985c;

/* renamed from: androidx.appcompat.widget.s */
/* compiled from: AppCompatProgressBarHelper */
class C0693s {

    /* renamed from: a */
    private static final int[] f2006a = {16843067, 16843068};

    /* renamed from: b */
    private final ProgressBar f2007b;

    /* renamed from: c */
    private Bitmap f2008c;

    C0693s(ProgressBar progressBar) {
        this.f2007b = progressBar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo2643a(AttributeSet attributeSet, int i) {
        C0645av a = C0645av.m2230a(this.f2007b.getContext(), attributeSet, f2006a, i, 0);
        Drawable b = a.mo2454b(0);
        if (b != null) {
            this.f2007b.setIndeterminateDrawable(mo2653a(b));
        }
        Drawable b2 = a.mo2454b(1);
        if (b2 != null) {
            this.f2007b.setProgressDrawable(m2442a(b2, false));
        }
        a.mo2450a();
    }

    /* renamed from: a */
    private Drawable m2442a(Drawable drawable, boolean z) {
        if (drawable instanceof C0985c) {
            C0985c cVar = (C0985c) drawable;
            Drawable a = cVar.mo3798a();
            if (a != null) {
                cVar.mo3799a(m2442a(a, z));
            }
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            Drawable[] drawableArr = new Drawable[numberOfLayers];
            for (int i = 0; i < numberOfLayers; i++) {
                int id = layerDrawable.getId(i);
                drawableArr[i] = m2442a(layerDrawable.getDrawable(i), id == 16908301 || id == 16908303);
            }
            LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
            for (int i2 = 0; i2 < numberOfLayers; i2++) {
                layerDrawable2.setId(i2, layerDrawable.getId(i2));
            }
            return layerDrawable2;
        } else if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            if (this.f2008c == null) {
                this.f2008c = bitmap;
            }
            ShapeDrawable shapeDrawable = new ShapeDrawable(mo2654b());
            shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, TileMode.REPEAT, TileMode.CLAMP));
            shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
            return z ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
        }
        return drawable;
    }

    /* renamed from: a */
    private Drawable mo2653a(Drawable drawable) {
        if (!(drawable instanceof AnimationDrawable)) {
            return drawable;
        }
        AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
        int numberOfFrames = animationDrawable.getNumberOfFrames();
        AnimationDrawable animationDrawable2 = new AnimationDrawable();
        animationDrawable2.setOneShot(animationDrawable.isOneShot());
        for (int i = 0; i < numberOfFrames; i++) {
            Drawable a = m2442a(animationDrawable.getFrame(i), true);
            a.setLevel(10000);
            animationDrawable2.addFrame(a, animationDrawable.getDuration(i));
        }
        animationDrawable2.setLevel(10000);
        return animationDrawable2;
    }

    /* renamed from: b */
    private Shape mo2654b() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Bitmap mo2642a() {
        return this.f2008c;
    }
}
