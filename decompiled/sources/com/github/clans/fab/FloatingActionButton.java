package com.github.clans.fab;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewOutlineProvider;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class FloatingActionButton extends ImageButton {
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static final Xfermode f6490h = new PorterDuffXfermode(Mode.CLEAR);

    /* renamed from: A */
    private float f6491A;

    /* renamed from: B */
    private float f6492B;

    /* renamed from: C */
    private boolean f6493C;

    /* renamed from: D */
    private RectF f6494D;

    /* renamed from: E */
    private Paint f6495E;

    /* renamed from: F */
    private Paint f6496F;

    /* renamed from: G */
    private boolean f6497G;

    /* renamed from: H */
    private long f6498H;

    /* renamed from: I */
    private float f6499I;

    /* renamed from: J */
    private long f6500J;

    /* renamed from: K */
    private double f6501K;

    /* renamed from: L */
    private boolean f6502L;

    /* renamed from: M */
    private int f6503M;

    /* renamed from: N */
    private float f6504N;

    /* renamed from: O */
    private float f6505O;

    /* renamed from: P */
    private float f6506P;

    /* renamed from: Q */
    private int f6507Q;

    /* renamed from: R */
    private boolean f6508R;

    /* renamed from: S */
    private boolean f6509S;

    /* renamed from: T */
    private boolean f6510T;

    /* renamed from: U */
    private int f6511U;
    /* access modifiers changed from: private */

    /* renamed from: V */
    public boolean f6512V;

    /* renamed from: a */
    int f6513a;

    /* renamed from: b */
    boolean f6514b;

    /* renamed from: c */
    int f6515c;

    /* renamed from: d */
    int f6516d;

    /* renamed from: e */
    int f6517e;

    /* renamed from: f */
    int f6518f;

    /* renamed from: g */
    GestureDetector f6519g;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f6520i;

    /* renamed from: j */
    private int f6521j;

    /* renamed from: k */
    private int f6522k;

    /* renamed from: l */
    private int f6523l;

    /* renamed from: m */
    private Drawable f6524m;

    /* renamed from: n */
    private int f6525n;

    /* renamed from: o */
    private Animation f6526o;

    /* renamed from: p */
    private Animation f6527p;

    /* renamed from: q */
    private String f6528q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public OnClickListener f6529r;

    /* renamed from: s */
    private Drawable f6530s;

    /* renamed from: t */
    private boolean f6531t;

    /* renamed from: u */
    private boolean f6532u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public boolean f6533v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public int f6534w;

    /* renamed from: x */
    private int f6535x;

    /* renamed from: y */
    private int f6536y;

    /* renamed from: z */
    private boolean f6537z;

    /* renamed from: com.github.clans.fab.FloatingActionButton$a */
    private class C2118a extends ShapeDrawable {

        /* renamed from: b */
        private int f6542b;

        /* renamed from: c */
        private int f6543c;

        private C2118a(Shape shape) {
            super(shape);
            int i = 0;
            this.f6542b = FloatingActionButton.this.mo12005h() ? FloatingActionButton.this.f6516d + Math.abs(FloatingActionButton.this.f6517e) : 0;
            if (FloatingActionButton.this.mo12005h()) {
                i = Math.abs(FloatingActionButton.this.f6518f) + FloatingActionButton.this.f6516d;
            }
            this.f6543c = i;
            if (FloatingActionButton.this.f6533v) {
                this.f6542b += FloatingActionButton.this.f6534w;
                this.f6543c += FloatingActionButton.this.f6534w;
            }
        }

        public void draw(Canvas canvas) {
            setBounds(this.f6542b, this.f6543c, FloatingActionButton.this.m8498k() - this.f6542b, FloatingActionButton.this.m8499l() - this.f6543c);
            super.draw(canvas);
        }
    }

    /* renamed from: com.github.clans.fab.FloatingActionButton$b */
    static class C2119b extends BaseSavedState {
        public static final Creator<C2119b> CREATOR = new Creator<C2119b>() {
            /* renamed from: a */
            public C2119b createFromParcel(Parcel parcel) {
                return new C2119b(parcel);
            }

            /* renamed from: a */
            public C2119b[] newArray(int i) {
                return new C2119b[i];
            }
        };

        /* renamed from: a */
        float f6544a;

        /* renamed from: b */
        float f6545b;

        /* renamed from: c */
        float f6546c;

        /* renamed from: d */
        int f6547d;

        /* renamed from: e */
        int f6548e;

        /* renamed from: f */
        int f6549f;

        /* renamed from: g */
        int f6550g;

        /* renamed from: h */
        boolean f6551h;

        /* renamed from: i */
        boolean f6552i;

        /* renamed from: j */
        boolean f6553j;

        /* renamed from: k */
        boolean f6554k;

        /* renamed from: l */
        boolean f6555l;

        /* renamed from: m */
        boolean f6556m;

        /* renamed from: n */
        boolean f6557n;

        C2119b(Parcelable parcelable) {
            super(parcelable);
        }

        private C2119b(Parcel parcel) {
            super(parcel);
            this.f6544a = parcel.readFloat();
            this.f6545b = parcel.readFloat();
            boolean z = false;
            this.f6551h = parcel.readInt() != 0;
            this.f6546c = parcel.readFloat();
            this.f6547d = parcel.readInt();
            this.f6548e = parcel.readInt();
            this.f6549f = parcel.readInt();
            this.f6550g = parcel.readInt();
            this.f6552i = parcel.readInt() != 0;
            this.f6553j = parcel.readInt() != 0;
            this.f6554k = parcel.readInt() != 0;
            this.f6555l = parcel.readInt() != 0;
            this.f6556m = parcel.readInt() != 0;
            if (parcel.readInt() != 0) {
                z = true;
            }
            this.f6557n = z;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeFloat(this.f6544a);
            parcel.writeFloat(this.f6545b);
            parcel.writeInt(this.f6551h ? 1 : 0);
            parcel.writeFloat(this.f6546c);
            parcel.writeInt(this.f6547d);
            parcel.writeInt(this.f6548e);
            parcel.writeInt(this.f6549f);
            parcel.writeInt(this.f6550g);
            parcel.writeInt(this.f6552i ? 1 : 0);
            parcel.writeInt(this.f6553j ? 1 : 0);
            parcel.writeInt(this.f6554k ? 1 : 0);
            parcel.writeInt(this.f6555l ? 1 : 0);
            parcel.writeInt(this.f6556m ? 1 : 0);
            parcel.writeInt(this.f6557n ? 1 : 0);
        }
    }

    /* renamed from: com.github.clans.fab.FloatingActionButton$c */
    private class C2121c extends Drawable {

        /* renamed from: b */
        private Paint f6559b;

        /* renamed from: c */
        private Paint f6560c;

        /* renamed from: d */
        private float f6561d;

        public int getOpacity() {
            return 0;
        }

        public void setAlpha(int i) {
        }

        public void setColorFilter(ColorFilter colorFilter) {
        }

        private C2121c() {
            this.f6559b = new Paint(1);
            this.f6560c = new Paint(1);
            m8522a();
        }

        /* renamed from: a */
        private void m8522a() {
            FloatingActionButton.this.setLayerType(1, null);
            this.f6559b.setStyle(Style.FILL);
            this.f6559b.setColor(FloatingActionButton.this.f6520i);
            this.f6560c.setXfermode(FloatingActionButton.f6490h);
            if (!FloatingActionButton.this.isInEditMode()) {
                this.f6559b.setShadowLayer((float) FloatingActionButton.this.f6516d, (float) FloatingActionButton.this.f6517e, (float) FloatingActionButton.this.f6518f, FloatingActionButton.this.f6515c);
            }
            this.f6561d = (float) (FloatingActionButton.this.getCircleSize() / 2);
            if (FloatingActionButton.this.f6533v && FloatingActionButton.this.f6512V) {
                this.f6561d += (float) FloatingActionButton.this.f6534w;
            }
        }

        public void draw(Canvas canvas) {
            canvas.drawCircle(FloatingActionButton.this.m8500m(), FloatingActionButton.this.m8501n(), this.f6561d, this.f6559b);
            canvas.drawCircle(FloatingActionButton.this.m8500m(), FloatingActionButton.this.m8501n(), this.f6561d, this.f6560c);
        }
    }

    public FloatingActionButton(Context context) {
        this(context, null);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6516d = C2138b.m8571a(getContext(), 4.0f);
        this.f6517e = C2138b.m8571a(getContext(), 1.0f);
        this.f6518f = C2138b.m8571a(getContext(), 3.0f);
        this.f6525n = C2138b.m8571a(getContext(), 24.0f);
        this.f6534w = C2138b.m8571a(getContext(), 6.0f);
        this.f6491A = -1.0f;
        this.f6492B = -1.0f;
        this.f6494D = new RectF();
        this.f6495E = new Paint(1);
        this.f6496F = new Paint(1);
        this.f6499I = 195.0f;
        this.f6500J = 0;
        this.f6502L = true;
        this.f6503M = 16;
        this.f6511U = 100;
        this.f6519g = new GestureDetector(getContext(), new SimpleOnGestureListener() {
            public boolean onDown(MotionEvent motionEvent) {
                C2134a aVar = (C2134a) FloatingActionButton.this.getTag(R.id.fab_label);
                if (aVar != null) {
                    aVar.mo12117d();
                }
                FloatingActionButton.this.mo11985f();
                return super.onDown(motionEvent);
            }

            public boolean onSingleTapUp(MotionEvent motionEvent) {
                C2134a aVar = (C2134a) FloatingActionButton.this.getTag(R.id.fab_label);
                if (aVar != null) {
                    aVar.mo12118e();
                }
                FloatingActionButton.this.mo11986g();
                return super.onSingleTapUp(motionEvent);
            }
        });
        m8484a(context, attributeSet, i);
    }

    @TargetApi(21)
    public FloatingActionButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f6516d = C2138b.m8571a(getContext(), 4.0f);
        this.f6517e = C2138b.m8571a(getContext(), 1.0f);
        this.f6518f = C2138b.m8571a(getContext(), 3.0f);
        this.f6525n = C2138b.m8571a(getContext(), 24.0f);
        this.f6534w = C2138b.m8571a(getContext(), 6.0f);
        this.f6491A = -1.0f;
        this.f6492B = -1.0f;
        this.f6494D = new RectF();
        this.f6495E = new Paint(1);
        this.f6496F = new Paint(1);
        this.f6499I = 195.0f;
        this.f6500J = 0;
        this.f6502L = true;
        this.f6503M = 16;
        this.f6511U = 100;
        this.f6519g = new GestureDetector(getContext(), new SimpleOnGestureListener() {
            public boolean onDown(MotionEvent motionEvent) {
                C2134a aVar = (C2134a) FloatingActionButton.this.getTag(R.id.fab_label);
                if (aVar != null) {
                    aVar.mo12117d();
                }
                FloatingActionButton.this.mo11985f();
                return super.onDown(motionEvent);
            }

            public boolean onSingleTapUp(MotionEvent motionEvent) {
                C2134a aVar = (C2134a) FloatingActionButton.this.getTag(R.id.fab_label);
                if (aVar != null) {
                    aVar.mo12118e();
                }
                FloatingActionButton.this.mo11986g();
                return super.onSingleTapUp(motionEvent);
            }
        });
        m8484a(context, attributeSet, i);
    }

    /* renamed from: a */
    private void m8484a(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FloatingActionButton, i, 0);
        this.f6520i = obtainStyledAttributes.getColor(R.styleable.FloatingActionButton_fab_colorNormal, -2473162);
        this.f6521j = obtainStyledAttributes.getColor(R.styleable.FloatingActionButton_fab_colorPressed, -1617853);
        this.f6522k = obtainStyledAttributes.getColor(R.styleable.FloatingActionButton_fab_colorDisabled, -5592406);
        this.f6523l = obtainStyledAttributes.getColor(R.styleable.FloatingActionButton_fab_colorRipple, -1711276033);
        this.f6514b = obtainStyledAttributes.getBoolean(R.styleable.FloatingActionButton_fab_showShadow, true);
        this.f6515c = obtainStyledAttributes.getColor(R.styleable.FloatingActionButton_fab_shadowColor, 1711276032);
        this.f6516d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FloatingActionButton_fab_shadowRadius, this.f6516d);
        this.f6517e = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FloatingActionButton_fab_shadowXOffset, this.f6517e);
        this.f6518f = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FloatingActionButton_fab_shadowYOffset, this.f6518f);
        this.f6513a = obtainStyledAttributes.getInt(R.styleable.FloatingActionButton_fab_size, 0);
        this.f6528q = obtainStyledAttributes.getString(R.styleable.FloatingActionButton_fab_label);
        this.f6509S = obtainStyledAttributes.getBoolean(R.styleable.FloatingActionButton_fab_progress_indeterminate, false);
        this.f6535x = obtainStyledAttributes.getColor(R.styleable.FloatingActionButton_fab_progress_color, -16738680);
        this.f6536y = obtainStyledAttributes.getColor(R.styleable.FloatingActionButton_fab_progress_backgroundColor, 1291845632);
        this.f6511U = obtainStyledAttributes.getInt(R.styleable.FloatingActionButton_fab_progress_max, this.f6511U);
        this.f6512V = obtainStyledAttributes.getBoolean(R.styleable.FloatingActionButton_fab_progress_showBackground, true);
        if (obtainStyledAttributes.hasValue(R.styleable.FloatingActionButton_fab_progress)) {
            this.f6507Q = obtainStyledAttributes.getInt(R.styleable.FloatingActionButton_fab_progress, 0);
            this.f6510T = true;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.FloatingActionButton_fab_elevationCompat)) {
            float dimensionPixelOffset = (float) obtainStyledAttributes.getDimensionPixelOffset(R.styleable.FloatingActionButton_fab_elevationCompat, 0);
            if (isInEditMode()) {
                setElevation(dimensionPixelOffset);
            } else {
                setElevationCompat(dimensionPixelOffset);
            }
        }
        m8485a(obtainStyledAttributes);
        m8488b(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        if (isInEditMode()) {
            if (this.f6509S) {
                setIndeterminate(true);
            } else if (this.f6510T) {
                m8503p();
                mo11978a(this.f6507Q, false);
            }
        }
        setClickable(true);
    }

    /* renamed from: a */
    private void m8485a(TypedArray typedArray) {
        this.f6526o = AnimationUtils.loadAnimation(getContext(), typedArray.getResourceId(R.styleable.FloatingActionButton_fab_showAnimation, R.anim.fab_scale_up));
    }

    /* renamed from: b */
    private void m8488b(TypedArray typedArray) {
        this.f6527p = AnimationUtils.loadAnimation(getContext(), typedArray.getResourceId(R.styleable.FloatingActionButton_fab_hideAnimation, R.anim.fab_scale_down));
    }

    /* access modifiers changed from: private */
    public int getCircleSize() {
        return getResources().getDimensionPixelSize(this.f6513a == 0 ? R.dimen.fab_size_normal : R.dimen.fab_size_mini);
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public int m8498k() {
        int circleSize = getCircleSize() + mo11976a();
        return this.f6533v ? circleSize + (this.f6534w * 2) : circleSize;
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public int m8499l() {
        int circleSize = getCircleSize() + mo11980b();
        return this.f6533v ? circleSize + (this.f6534w * 2) : circleSize;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int mo11976a() {
        if (mo12005h()) {
            return getShadowX() * 2;
        }
        return 0;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public int mo11980b() {
        if (mo12005h()) {
            return getShadowY() * 2;
        }
        return 0;
    }

    private int getShadowX() {
        return this.f6516d + Math.abs(this.f6517e);
    }

    private int getShadowY() {
        return this.f6516d + Math.abs(this.f6518f);
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public float m8500m() {
        return (float) (getMeasuredWidth() / 2);
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public float m8501n() {
        return (float) (getMeasuredHeight() / 2);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(m8498k(), m8499l());
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float f;
        float f2;
        super.onDraw(canvas);
        if (this.f6533v) {
            if (this.f6512V) {
                canvas.drawArc(this.f6494D, 360.0f, 360.0f, false, this.f6495E);
            }
            boolean z = true;
            if (this.f6497G) {
                long uptimeMillis = SystemClock.uptimeMillis() - this.f6498H;
                float f3 = (((float) uptimeMillis) * this.f6499I) / 1000.0f;
                m8483a(uptimeMillis);
                this.f6505O += f3;
                if (this.f6505O > 360.0f) {
                    this.f6505O -= 360.0f;
                }
                this.f6498H = SystemClock.uptimeMillis();
                float f4 = this.f6505O - 90.0f;
                float f5 = ((float) this.f6503M) + this.f6504N;
                if (isInEditMode()) {
                    f2 = BitmapDescriptorFactory.HUE_RED;
                    f = 135.0f;
                } else {
                    f2 = f4;
                    f = f5;
                }
                canvas.drawArc(this.f6494D, f2, f, false, this.f6496F);
            } else {
                if (this.f6505O != this.f6506P) {
                    float uptimeMillis2 = (((float) (SystemClock.uptimeMillis() - this.f6498H)) / 1000.0f) * this.f6499I;
                    if (this.f6505O > this.f6506P) {
                        this.f6505O = Math.max(this.f6505O - uptimeMillis2, this.f6506P);
                    } else {
                        this.f6505O = Math.min(this.f6505O + uptimeMillis2, this.f6506P);
                    }
                    this.f6498H = SystemClock.uptimeMillis();
                } else {
                    z = false;
                }
                canvas.drawArc(this.f6494D, -90.0f, this.f6505O, false, this.f6496F);
            }
            if (z) {
                invalidate();
            }
        }
    }

    /* renamed from: a */
    private void m8483a(long j) {
        if (this.f6500J >= 200) {
            this.f6501K += (double) j;
            if (this.f6501K > 500.0d) {
                this.f6501K -= 500.0d;
                this.f6500J = 0;
                this.f6502L = !this.f6502L;
            }
            float cos = (((float) Math.cos(((this.f6501K / 500.0d) + 1.0d) * 3.141592653589793d)) / 2.0f) + 0.5f;
            float f = (float) (270 - this.f6503M);
            if (this.f6502L) {
                this.f6504N = cos * f;
                return;
            }
            float f2 = f * (1.0f - cos);
            this.f6505O += this.f6504N - f2;
            this.f6504N = f2;
            return;
        }
        this.f6500J += j;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        m8503p();
        if (this.f6509S) {
            setIndeterminate(true);
            this.f6509S = false;
        } else if (this.f6510T) {
            mo11978a(this.f6507Q, this.f6508R);
            this.f6510T = false;
        } else if (this.f6537z) {
            m8504q();
            this.f6537z = false;
        }
        super.onSizeChanged(i, i2, i3, i4);
        m8506s();
        m8505r();
        mo11982c();
    }

    @TargetApi(21)
    public void setLayoutParams(LayoutParams layoutParams) {
        if ((layoutParams instanceof MarginLayoutParams) && this.f6532u) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin += getShadowX();
            marginLayoutParams.topMargin += getShadowY();
            marginLayoutParams.rightMargin += getShadowX();
            marginLayoutParams.bottomMargin += getShadowY();
        }
        super.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo11982c() {
        LayerDrawable layerDrawable;
        int i = 0;
        if (mo12005h()) {
            layerDrawable = new LayerDrawable(new Drawable[]{new C2121c(), m8502o(), getIconDrawable()});
        } else {
            layerDrawable = new LayerDrawable(new Drawable[]{m8502o(), getIconDrawable()});
        }
        int i2 = -1;
        if (getIconDrawable() != null) {
            i2 = Math.max(getIconDrawable().getIntrinsicWidth(), getIconDrawable().getIntrinsicHeight());
        }
        int circleSize = getCircleSize();
        if (i2 <= 0) {
            i2 = this.f6525n;
        }
        int i3 = (circleSize - i2) / 2;
        int abs = mo12005h() ? this.f6516d + Math.abs(this.f6517e) : 0;
        if (mo12005h()) {
            i = this.f6516d + Math.abs(this.f6518f);
        }
        if (this.f6533v) {
            abs += this.f6534w;
            i += this.f6534w;
        }
        int i4 = abs + i3;
        int i5 = i + i3;
        layerDrawable.setLayerInset(mo12005h() ? 2 : 1, i4, i5, i4, i5);
        setBackgroundCompat(layerDrawable);
    }

    /* access modifiers changed from: protected */
    public Drawable getIconDrawable() {
        if (this.f6524m != null) {
            return this.f6524m;
        }
        return new ColorDrawable(0);
    }

    @TargetApi(21)
    /* renamed from: o */
    private Drawable m8502o() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{-16842910}, m8482a(this.f6522k));
        stateListDrawable.addState(new int[]{16842919}, m8482a(this.f6521j));
        stateListDrawable.addState(new int[0], m8482a(this.f6520i));
        if (C2138b.m8573b()) {
            RippleDrawable rippleDrawable = new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{this.f6523l}), stateListDrawable, null);
            setOutlineProvider(new ViewOutlineProvider() {
                public void getOutline(View view, Outline outline) {
                    outline.setOval(0, 0, view.getWidth(), view.getHeight());
                }
            });
            setClipToOutline(true);
            this.f6530s = rippleDrawable;
            return rippleDrawable;
        }
        this.f6530s = stateListDrawable;
        return stateListDrawable;
    }

    /* renamed from: a */
    private Drawable m8482a(int i) {
        C2118a aVar = new C2118a(new OvalShape());
        aVar.getPaint().setColor(i);
        return aVar;
    }

    @TargetApi(16)
    private void setBackgroundCompat(Drawable drawable) {
        if (C2138b.m8572a()) {
            setBackground(drawable);
        } else {
            setBackgroundDrawable(drawable);
        }
    }

    /* renamed from: p */
    private void m8503p() {
        if (!this.f6493C) {
            if (this.f6491A == -1.0f) {
                this.f6491A = getX();
            }
            if (this.f6492B == -1.0f) {
                this.f6492B = getY();
            }
            this.f6493C = true;
        }
    }

    /* renamed from: q */
    private void m8504q() {
        float f;
        float f2;
        if (this.f6533v) {
            f2 = this.f6491A > getX() ? getX() + ((float) this.f6534w) : getX() - ((float) this.f6534w);
            f = this.f6492B > getY() ? getY() + ((float) this.f6534w) : getY() - ((float) this.f6534w);
        } else {
            f2 = this.f6491A;
            f = this.f6492B;
        }
        setX(f2);
        setY(f);
    }

    /* renamed from: r */
    private void m8505r() {
        this.f6495E.setColor(this.f6536y);
        this.f6495E.setStyle(Style.STROKE);
        this.f6495E.setStrokeWidth((float) this.f6534w);
        this.f6496F.setColor(this.f6535x);
        this.f6496F.setStyle(Style.STROKE);
        this.f6496F.setStrokeWidth((float) this.f6534w);
    }

    /* renamed from: s */
    private void m8506s() {
        int i = 0;
        int shadowX = mo12005h() ? getShadowX() : 0;
        if (mo12005h()) {
            i = getShadowY();
        }
        this.f6494D = new RectF((float) ((this.f6534w / 2) + shadowX), (float) ((this.f6534w / 2) + i), (float) ((m8498k() - shadowX) - (this.f6534w / 2)), (float) ((m8499l() - i) - (this.f6534w / 2)));
    }

    /* access modifiers changed from: 0000 */
    public Animation getShowAnimation() {
        return this.f6526o;
    }

    /* access modifiers changed from: 0000 */
    public Animation getHideAnimation() {
        return this.f6527p;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo11983d() {
        this.f6527p.cancel();
        startAnimation(this.f6526o);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo11984e() {
        this.f6526o.cancel();
        startAnimation(this.f6527p);
    }

    /* access modifiers changed from: 0000 */
    public OnClickListener getOnClickListener() {
        return this.f6529r;
    }

    /* access modifiers changed from: 0000 */
    public C2134a getLabelView() {
        return (C2134a) getTag(R.id.fab_label);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo11977a(int i, int i2, int i3) {
        this.f6520i = i;
        this.f6521j = i2;
        this.f6523l = i3;
    }

    /* access modifiers changed from: 0000 */
    @TargetApi(21)
    /* renamed from: f */
    public void mo11985f() {
        if (this.f6530s instanceof StateListDrawable) {
            ((StateListDrawable) this.f6530s).setState(new int[]{16842910, 16842919});
        } else if (C2138b.m8573b()) {
            RippleDrawable rippleDrawable = (RippleDrawable) this.f6530s;
            rippleDrawable.setState(new int[]{16842910, 16842919});
            rippleDrawable.setHotspot(m8500m(), m8501n());
            rippleDrawable.setVisible(true, true);
        }
    }

    /* access modifiers changed from: 0000 */
    @TargetApi(21)
    /* renamed from: g */
    public void mo11986g() {
        if (this.f6530s instanceof StateListDrawable) {
            ((StateListDrawable) this.f6530s).setState(new int[]{16842910});
        } else if (C2138b.m8573b()) {
            RippleDrawable rippleDrawable = (RippleDrawable) this.f6530s;
            rippleDrawable.setState(new int[]{16842910});
            rippleDrawable.setHotspot(m8500m(), m8501n());
            rippleDrawable.setVisible(true, true);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f6529r != null && isEnabled()) {
            C2134a aVar = (C2134a) getTag(R.id.fab_label);
            if (aVar == null) {
                return super.onTouchEvent(motionEvent);
            }
            int action = motionEvent.getAction();
            if (action == 1) {
                if (aVar != null) {
                    aVar.mo12118e();
                }
                mo11986g();
            } else if (action == 3) {
                if (aVar != null) {
                    aVar.mo12118e();
                }
                mo11986g();
            }
            this.f6519g.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public Parcelable onSaveInstanceState() {
        C2119b bVar = new C2119b(super.onSaveInstanceState());
        bVar.f6544a = this.f6505O;
        bVar.f6545b = this.f6506P;
        bVar.f6546c = this.f6499I;
        bVar.f6548e = this.f6534w;
        bVar.f6549f = this.f6535x;
        bVar.f6550g = this.f6536y;
        bVar.f6554k = this.f6497G;
        bVar.f6555l = this.f6533v && this.f6507Q > 0 && !this.f6497G;
        bVar.f6547d = this.f6507Q;
        bVar.f6556m = this.f6508R;
        bVar.f6557n = this.f6512V;
        return bVar;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof C2119b)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C2119b bVar = (C2119b) parcelable;
        super.onRestoreInstanceState(bVar.getSuperState());
        this.f6505O = bVar.f6544a;
        this.f6506P = bVar.f6545b;
        this.f6499I = bVar.f6546c;
        this.f6534w = bVar.f6548e;
        this.f6535x = bVar.f6549f;
        this.f6536y = bVar.f6550g;
        this.f6509S = bVar.f6554k;
        this.f6510T = bVar.f6555l;
        this.f6507Q = bVar.f6547d;
        this.f6508R = bVar.f6556m;
        this.f6512V = bVar.f6557n;
        this.f6498H = SystemClock.uptimeMillis();
    }

    public void setImageDrawable(Drawable drawable) {
        if (this.f6524m != drawable) {
            this.f6524m = drawable;
            mo11982c();
        }
    }

    public void setImageResource(int i) {
        Drawable drawable = getResources().getDrawable(i);
        if (this.f6524m != drawable) {
            this.f6524m = drawable;
            mo11982c();
        }
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.f6529r = onClickListener;
        View view = (View) getTag(R.id.fab_label);
        if (view != null) {
            view.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (FloatingActionButton.this.f6529r != null) {
                        FloatingActionButton.this.f6529r.onClick(FloatingActionButton.this);
                    }
                }
            });
        }
    }

    public void setButtonSize(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("Use @FabSize constants only!");
        } else if (this.f6513a != i) {
            this.f6513a = i;
            mo11982c();
        }
    }

    public int getButtonSize() {
        return this.f6513a;
    }

    public void setColorNormal(int i) {
        if (this.f6520i != i) {
            this.f6520i = i;
            mo11982c();
        }
    }

    public void setColorNormalResId(int i) {
        setColorNormal(getResources().getColor(i));
    }

    public int getColorNormal() {
        return this.f6520i;
    }

    public void setColorPressed(int i) {
        if (i != this.f6521j) {
            this.f6521j = i;
            mo11982c();
        }
    }

    public void setColorPressedResId(int i) {
        setColorPressed(getResources().getColor(i));
    }

    public int getColorPressed() {
        return this.f6521j;
    }

    public void setColorRipple(int i) {
        if (i != this.f6523l) {
            this.f6523l = i;
            mo11982c();
        }
    }

    public void setColorRippleResId(int i) {
        setColorRipple(getResources().getColor(i));
    }

    public int getColorRipple() {
        return this.f6523l;
    }

    public void setColorDisabled(int i) {
        if (i != this.f6522k) {
            this.f6522k = i;
            mo11982c();
        }
    }

    public void setColorDisabledResId(int i) {
        setColorDisabled(getResources().getColor(i));
    }

    public int getColorDisabled() {
        return this.f6522k;
    }

    public void setShowShadow(boolean z) {
        if (this.f6514b != z) {
            this.f6514b = z;
            mo11982c();
        }
    }

    /* renamed from: h */
    public boolean mo12005h() {
        return !this.f6531t && this.f6514b;
    }

    public void setShadowRadius(int i) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(i);
        if (this.f6516d != dimensionPixelSize) {
            this.f6516d = dimensionPixelSize;
            requestLayout();
            mo11982c();
        }
    }

    public void setShadowRadius(float f) {
        this.f6516d = C2138b.m8571a(getContext(), f);
        requestLayout();
        mo11982c();
    }

    public int getShadowRadius() {
        return this.f6516d;
    }

    public void setShadowXOffset(int i) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(i);
        if (this.f6517e != dimensionPixelSize) {
            this.f6517e = dimensionPixelSize;
            requestLayout();
            mo11982c();
        }
    }

    public void setShadowXOffset(float f) {
        this.f6517e = C2138b.m8571a(getContext(), f);
        requestLayout();
        mo11982c();
    }

    public int getShadowXOffset() {
        return this.f6517e;
    }

    public void setShadowYOffset(int i) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(i);
        if (this.f6518f != dimensionPixelSize) {
            this.f6518f = dimensionPixelSize;
            requestLayout();
            mo11982c();
        }
    }

    public void setShadowYOffset(float f) {
        this.f6518f = C2138b.m8571a(getContext(), f);
        requestLayout();
        mo11982c();
    }

    public int getShadowYOffset() {
        return this.f6518f;
    }

    public void setShadowColorResource(int i) {
        int color = getResources().getColor(i);
        if (this.f6515c != color) {
            this.f6515c = color;
            mo11982c();
        }
    }

    public void setShadowColor(int i) {
        if (this.f6515c != i) {
            this.f6515c = i;
            mo11982c();
        }
    }

    public int getShadowColor() {
        return this.f6515c;
    }

    /* renamed from: i */
    public boolean mo12006i() {
        return getVisibility() == 4;
    }

    /* renamed from: a */
    public void mo11979a(boolean z) {
        if (mo12006i()) {
            if (z) {
                mo11983d();
            }
            super.setVisibility(0);
        }
    }

    /* renamed from: b */
    public void mo11981b(boolean z) {
        if (!mo12006i()) {
            if (z) {
                mo11984e();
            }
            super.setVisibility(4);
        }
    }

    public void setLabelText(String str) {
        this.f6528q = str;
        C2134a labelView = getLabelView();
        if (labelView != null) {
            labelView.setText(str);
        }
    }

    public String getLabelText() {
        return this.f6528q;
    }

    public void setShowAnimation(Animation animation) {
        this.f6526o = animation;
    }

    public void setHideAnimation(Animation animation) {
        this.f6527p = animation;
    }

    public void setLabelVisibility(int i) {
        C2134a labelView = getLabelView();
        if (labelView != null) {
            labelView.setVisibility(i);
            labelView.setHandleVisibilityChanges(i == 0);
        }
    }

    public int getLabelVisibility() {
        C2134a labelView = getLabelView();
        if (labelView != null) {
            return labelView.getVisibility();
        }
        return -1;
    }

    public void setElevation(float f) {
        if (C2138b.m8573b() && f > BitmapDescriptorFactory.HUE_RED) {
            super.setElevation(f);
            if (!isInEditMode()) {
                this.f6531t = true;
                this.f6514b = false;
            }
            mo11982c();
        }
    }

    @TargetApi(21)
    public void setElevationCompat(float f) {
        this.f6515c = 637534208;
        float f2 = f / 2.0f;
        this.f6516d = Math.round(f2);
        this.f6517e = 0;
        if (this.f6513a == 0) {
            f2 = f;
        }
        this.f6518f = Math.round(f2);
        if (C2138b.m8573b()) {
            super.setElevation(f);
            this.f6532u = true;
            this.f6514b = false;
            mo11982c();
            LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        this.f6514b = true;
        mo11982c();
    }

    public synchronized void setIndeterminate(boolean z) {
        if (!z) {
            try {
                this.f6505O = BitmapDescriptorFactory.HUE_RED;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f6533v = z;
        this.f6537z = true;
        this.f6497G = z;
        this.f6498H = SystemClock.uptimeMillis();
        m8506s();
        m8503p();
        mo11982c();
    }

    public synchronized void setMax(int i) {
        this.f6511U = i;
    }

    public synchronized int getMax() {
        return this.f6511U;
    }

    /* renamed from: a */
    public synchronized void mo11978a(int i, boolean z) {
        if (!this.f6497G) {
            this.f6507Q = i;
            this.f6508R = z;
            if (!this.f6493C) {
                this.f6510T = true;
                return;
            }
            this.f6533v = true;
            this.f6537z = true;
            m8506s();
            m8503p();
            mo11982c();
            if (i < 0) {
                i = 0;
            } else if (i > this.f6511U) {
                i = this.f6511U;
            }
            float f = (float) i;
            if (f != this.f6506P) {
                this.f6506P = this.f6511U > 0 ? (f / ((float) this.f6511U)) * 360.0f : BitmapDescriptorFactory.HUE_RED;
                this.f6498H = SystemClock.uptimeMillis();
                if (!z) {
                    this.f6505O = this.f6506P;
                }
                invalidate();
            }
        }
    }

    public synchronized int getProgress() {
        return this.f6497G ? 0 : this.f6507Q;
    }

    public synchronized void setShowProgressBackground(boolean z) {
        this.f6512V = z;
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        C2134a aVar = (C2134a) getTag(R.id.fab_label);
        if (aVar != null) {
            aVar.setEnabled(z);
        }
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        C2134a aVar = (C2134a) getTag(R.id.fab_label);
        if (aVar != null) {
            aVar.setVisibility(i);
        }
    }
}
