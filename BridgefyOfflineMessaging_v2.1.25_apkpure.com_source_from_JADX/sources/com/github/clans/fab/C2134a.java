package com.github.clans.fab;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.animation.Animation;
import android.widget.TextView;

/* renamed from: com.github.clans.fab.a */
/* compiled from: Label */
public class C2134a extends TextView {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final Xfermode f6638b = new PorterDuffXfermode(Mode.CLEAR);

    /* renamed from: a */
    GestureDetector f6639a = new GestureDetector(getContext(), new SimpleOnGestureListener() {
        public boolean onDown(MotionEvent motionEvent) {
            C2134a.this.mo12117d();
            if (C2134a.this.f6652o != null) {
                C2134a.this.f6652o.mo11985f();
            }
            return super.onDown(motionEvent);
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            C2134a.this.mo12118e();
            if (C2134a.this.f6652o != null) {
                C2134a.this.f6652o.mo11986g();
            }
            return super.onSingleTapUp(motionEvent);
        }
    });
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f6640c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f6641d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f6642e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f6643f;

    /* renamed from: g */
    private Drawable f6644g;

    /* renamed from: h */
    private boolean f6645h = true;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f6646i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public int f6647j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f6648k;

    /* renamed from: l */
    private int f6649l;

    /* renamed from: m */
    private int f6650m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f6651n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public FloatingActionButton f6652o;

    /* renamed from: p */
    private Animation f6653p;

    /* renamed from: q */
    private Animation f6654q;

    /* renamed from: r */
    private boolean f6655r;

    /* renamed from: s */
    private boolean f6656s = true;

    /* renamed from: com.github.clans.fab.a$a */
    /* compiled from: Label */
    private class C2137a extends Drawable {

        /* renamed from: b */
        private Paint f6660b;

        /* renamed from: c */
        private Paint f6661c;

        public int getOpacity() {
            return 0;
        }

        public void setAlpha(int i) {
        }

        public void setColorFilter(ColorFilter colorFilter) {
        }

        private C2137a() {
            this.f6660b = new Paint(1);
            this.f6661c = new Paint(1);
            m8570a();
        }

        /* renamed from: a */
        private void m8570a() {
            C2134a.this.setLayerType(1, null);
            this.f6660b.setStyle(Style.FILL);
            this.f6660b.setColor(C2134a.this.f6648k);
            this.f6661c.setXfermode(C2134a.f6638b);
            if (!C2134a.this.isInEditMode()) {
                this.f6660b.setShadowLayer((float) C2134a.this.f6640c, (float) C2134a.this.f6641d, (float) C2134a.this.f6642e, C2134a.this.f6643f);
            }
        }

        public void draw(Canvas canvas) {
            RectF rectF = new RectF((float) (C2134a.this.f6640c + Math.abs(C2134a.this.f6641d)), (float) (C2134a.this.f6640c + Math.abs(C2134a.this.f6642e)), (float) C2134a.this.f6646i, (float) C2134a.this.f6647j);
            canvas.drawRoundRect(rectF, (float) C2134a.this.f6651n, (float) C2134a.this.f6651n, this.f6660b);
            canvas.drawRoundRect(rectF, (float) C2134a.this.f6651n, (float) C2134a.this.f6651n, this.f6661c);
        }
    }

    public C2134a(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(m8554h(), m8556i());
    }

    /* renamed from: h */
    private int m8554h() {
        if (this.f6646i == 0) {
            this.f6646i = getMeasuredWidth();
        }
        return getMeasuredWidth() + mo12111a();
    }

    /* renamed from: i */
    private int m8556i() {
        if (this.f6647j == 0) {
            this.f6647j = getMeasuredHeight();
        }
        return getMeasuredHeight() + mo12114b();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int mo12111a() {
        if (this.f6645h) {
            return this.f6640c + Math.abs(this.f6641d);
        }
        return 0;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public int mo12114b() {
        if (this.f6645h) {
            return this.f6640c + Math.abs(this.f6642e);
        }
        return 0;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo12116c() {
        LayerDrawable layerDrawable;
        if (this.f6645h) {
            layerDrawable = new LayerDrawable(new Drawable[]{new C2137a(), m8558j()});
            layerDrawable.setLayerInset(1, this.f6640c + Math.abs(this.f6641d), this.f6640c + Math.abs(this.f6642e), this.f6640c + Math.abs(this.f6641d), this.f6640c + Math.abs(this.f6642e));
        } else {
            layerDrawable = new LayerDrawable(new Drawable[]{m8558j()});
        }
        setBackgroundCompat(layerDrawable);
    }

    @TargetApi(21)
    /* renamed from: j */
    private Drawable m8558j() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, m8545a(this.f6649l));
        stateListDrawable.addState(new int[0], m8545a(this.f6648k));
        if (C2138b.m8573b()) {
            RippleDrawable rippleDrawable = new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{this.f6650m}), stateListDrawable, null);
            setOutlineProvider(new ViewOutlineProvider() {
                public void getOutline(View view, Outline outline) {
                    outline.setOval(0, 0, view.getWidth(), view.getHeight());
                }
            });
            setClipToOutline(true);
            this.f6644g = rippleDrawable;
            return rippleDrawable;
        }
        this.f6644g = stateListDrawable;
        return stateListDrawable;
    }

    /* renamed from: a */
    private Drawable m8545a(int i) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{(float) this.f6651n, (float) this.f6651n, (float) this.f6651n, (float) this.f6651n, (float) this.f6651n, (float) this.f6651n, (float) this.f6651n, (float) this.f6651n}, null, null));
        shapeDrawable.getPaint().setColor(i);
        return shapeDrawable;
    }

    private void setShadow(FloatingActionButton floatingActionButton) {
        this.f6643f = floatingActionButton.getShadowColor();
        this.f6640c = floatingActionButton.getShadowRadius();
        this.f6641d = floatingActionButton.getShadowXOffset();
        this.f6642e = floatingActionButton.getShadowYOffset();
        this.f6645h = floatingActionButton.mo12005h();
    }

    @TargetApi(21)
    private void setBackgroundCompat(Drawable drawable) {
        if (C2138b.m8572a()) {
            setBackground(drawable);
        } else {
            setBackgroundDrawable(drawable);
        }
    }

    /* renamed from: k */
    private void m8559k() {
        if (this.f6653p != null) {
            this.f6654q.cancel();
            startAnimation(this.f6653p);
        }
    }

    /* renamed from: l */
    private void m8560l() {
        if (this.f6654q != null) {
            this.f6653p.cancel();
            startAnimation(this.f6654q);
        }
    }

    /* access modifiers changed from: 0000 */
    @TargetApi(21)
    /* renamed from: d */
    public void mo12117d() {
        if (this.f6655r) {
            this.f6644g = getBackground();
        }
        if (this.f6644g instanceof StateListDrawable) {
            ((StateListDrawable) this.f6644g).setState(new int[]{16842919});
        } else if (C2138b.m8573b() && (this.f6644g instanceof RippleDrawable)) {
            RippleDrawable rippleDrawable = (RippleDrawable) this.f6644g;
            rippleDrawable.setState(new int[]{16842910, 16842919});
            rippleDrawable.setHotspot((float) (getMeasuredWidth() / 2), (float) (getMeasuredHeight() / 2));
            rippleDrawable.setVisible(true, true);
        }
        setPressed(true);
    }

    /* access modifiers changed from: 0000 */
    @TargetApi(21)
    /* renamed from: e */
    public void mo12118e() {
        if (this.f6655r) {
            this.f6644g = getBackground();
        }
        if (this.f6644g instanceof StateListDrawable) {
            ((StateListDrawable) this.f6644g).setState(new int[0]);
        } else if (C2138b.m8573b() && (this.f6644g instanceof RippleDrawable)) {
            RippleDrawable rippleDrawable = (RippleDrawable) this.f6644g;
            rippleDrawable.setState(new int[0]);
            rippleDrawable.setHotspot((float) (getMeasuredWidth() / 2), (float) (getMeasuredHeight() / 2));
            rippleDrawable.setVisible(true, true);
        }
        setPressed(false);
    }

    /* access modifiers changed from: 0000 */
    public void setFab(FloatingActionButton floatingActionButton) {
        this.f6652o = floatingActionButton;
        setShadow(floatingActionButton);
    }

    /* access modifiers changed from: 0000 */
    public void setShowShadow(boolean z) {
        this.f6645h = z;
    }

    /* access modifiers changed from: 0000 */
    public void setCornerRadius(int i) {
        this.f6651n = i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo12112a(int i, int i2, int i3) {
        this.f6648k = i;
        this.f6649l = i2;
        this.f6650m = i3;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo12113a(boolean z) {
        if (z) {
            m8559k();
        }
        setVisibility(0);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo12115b(boolean z) {
        if (z) {
            m8560l();
        }
        setVisibility(4);
    }

    /* access modifiers changed from: 0000 */
    public void setShowAnimation(Animation animation) {
        this.f6653p = animation;
    }

    /* access modifiers changed from: 0000 */
    public void setHideAnimation(Animation animation) {
        this.f6654q = animation;
    }

    /* access modifiers changed from: 0000 */
    public void setUsingStyle(boolean z) {
        this.f6655r = z;
    }

    /* access modifiers changed from: 0000 */
    public void setHandleVisibilityChanges(boolean z) {
        this.f6656s = z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public boolean mo12119f() {
        return this.f6656s;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f6652o == null || this.f6652o.getOnClickListener() == null || !this.f6652o.isEnabled()) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 1) {
            mo12118e();
            this.f6652o.mo11986g();
        } else if (action == 3) {
            mo12118e();
            this.f6652o.mo11986g();
        }
        this.f6639a.onTouchEvent(motionEvent);
        return super.onTouchEvent(motionEvent);
    }
}
