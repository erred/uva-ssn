package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import androidx.core.p070g.C0962r;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: androidx.swiperefreshlayout.widget.a */
/* compiled from: CircleImageView */
class C1348a extends ImageView {

    /* renamed from: a */
    int f4050a;

    /* renamed from: b */
    private AnimationListener f4051b;

    /* renamed from: androidx.swiperefreshlayout.widget.a$a */
    /* compiled from: CircleImageView */
    private class C1349a extends OvalShape {

        /* renamed from: b */
        private RadialGradient f4053b;

        /* renamed from: c */
        private Paint f4054c = new Paint();

        C1349a(int i) {
            C1348a.this.f4050a = i;
            m5493a((int) rect().width());
        }

        /* access modifiers changed from: protected */
        public void onResize(float f, float f2) {
            super.onResize(f, f2);
            m5493a((int) f);
        }

        public void draw(Canvas canvas, Paint paint) {
            int width = C1348a.this.getWidth() / 2;
            float f = (float) width;
            float height = (float) (C1348a.this.getHeight() / 2);
            canvas.drawCircle(f, height, f, this.f4054c);
            canvas.drawCircle(f, height, (float) (width - C1348a.this.f4050a), paint);
        }

        /* renamed from: a */
        private void m5493a(int i) {
            float f = (float) (i / 2);
            RadialGradient radialGradient = new RadialGradient(f, f, (float) C1348a.this.f4050a, new int[]{1023410176, 0}, null, TileMode.CLAMP);
            this.f4053b = radialGradient;
            this.f4054c.setShader(this.f4053b);
        }
    }

    C1348a(Context context, int i) {
        ShapeDrawable shapeDrawable;
        super(context);
        float f = getContext().getResources().getDisplayMetrics().density;
        int i2 = (int) (1.75f * f);
        int i3 = (int) (BitmapDescriptorFactory.HUE_RED * f);
        this.f4050a = (int) (3.5f * f);
        if (m5491a()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            C0962r.m3550a((View) this, f * 4.0f);
        } else {
            ShapeDrawable shapeDrawable2 = new ShapeDrawable(new C1349a(this.f4050a));
            setLayerType(1, shapeDrawable2.getPaint());
            shapeDrawable2.getPaint().setShadowLayer((float) this.f4050a, (float) i3, (float) i2, 503316480);
            int i4 = this.f4050a;
            setPadding(i4, i4, i4, i4);
            shapeDrawable = shapeDrawable2;
        }
        shapeDrawable.getPaint().setColor(i);
        C0962r.m3557a((View) this, (Drawable) shapeDrawable);
    }

    /* renamed from: a */
    private boolean m5491a() {
        return VERSION.SDK_INT >= 21;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!m5491a()) {
            setMeasuredDimension(getMeasuredWidth() + (this.f4050a * 2), getMeasuredHeight() + (this.f4050a * 2));
        }
    }

    /* renamed from: a */
    public void mo5640a(AnimationListener animationListener) {
        this.f4051b = animationListener;
    }

    public void onAnimationStart() {
        super.onAnimationStart();
        if (this.f4051b != null) {
            this.f4051b.onAnimationStart(getAnimation());
        }
    }

    public void onAnimationEnd() {
        super.onAnimationEnd();
        if (this.f4051b != null) {
            this.f4051b.onAnimationEnd(getAnimation());
        }
    }

    public void setBackgroundColor(int i) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i);
        }
    }
}
