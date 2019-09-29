package com.viewpagerindicator;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import androidx.core.p070g.C0952h;
import androidx.core.p070g.C0966s;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.C1475f;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import me.bridgefy.main.R;

public class CirclePageIndicator extends View implements C3369a {

    /* renamed from: a */
    private float f8790a;

    /* renamed from: b */
    private final Paint f8791b;

    /* renamed from: c */
    private final Paint f8792c;

    /* renamed from: d */
    private final Paint f8793d;

    /* renamed from: e */
    private ViewPager f8794e;

    /* renamed from: f */
    private C1475f f8795f;

    /* renamed from: g */
    private int f8796g;

    /* renamed from: h */
    private int f8797h;

    /* renamed from: i */
    private float f8798i;

    /* renamed from: j */
    private int f8799j;

    /* renamed from: k */
    private int f8800k;

    /* renamed from: l */
    private boolean f8801l;

    /* renamed from: m */
    private boolean f8802m;

    /* renamed from: n */
    private int f8803n;

    /* renamed from: o */
    private float f8804o;

    /* renamed from: p */
    private int f8805p;

    /* renamed from: q */
    private boolean f8806q;

    /* renamed from: com.viewpagerindicator.CirclePageIndicator$a */
    static class C3367a extends BaseSavedState {
        public static final Creator<C3367a> CREATOR = new Creator<C3367a>() {
            /* renamed from: a */
            public C3367a createFromParcel(Parcel parcel) {
                return new C3367a(parcel);
            }

            /* renamed from: a */
            public C3367a[] newArray(int i) {
                return new C3367a[i];
            }
        };

        /* renamed from: a */
        int f8807a;

        public C3367a(Parcelable parcelable) {
            super(parcelable);
        }

        private C3367a(Parcel parcel) {
            super(parcel);
            this.f8807a = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f8807a);
        }
    }

    public CirclePageIndicator(Context context) {
        this(context, null);
    }

    public CirclePageIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.vpiCirclePageIndicatorStyle);
    }

    public CirclePageIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8791b = new Paint(1);
        this.f8792c = new Paint(1);
        this.f8793d = new Paint(1);
        this.f8804o = -1.0f;
        this.f8805p = -1;
        if (!isInEditMode()) {
            Resources resources = getResources();
            int color = resources.getColor(R.color.default_circle_indicator_page_color);
            int color2 = resources.getColor(R.color.default_circle_indicator_fill_color);
            int integer = resources.getInteger(R.integer.default_circle_indicator_orientation);
            int color3 = resources.getColor(R.color.default_circle_indicator_stroke_color);
            float dimension = resources.getDimension(R.dimen.default_circle_indicator_stroke_width);
            float dimension2 = resources.getDimension(R.dimen.default_circle_indicator_radius);
            boolean z = resources.getBoolean(R.bool.default_circle_indicator_centered);
            boolean z2 = resources.getBoolean(R.bool.default_circle_indicator_snap);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CirclePageIndicator, i, 0);
            this.f8801l = obtainStyledAttributes.getBoolean(2, z);
            this.f8800k = obtainStyledAttributes.getInt(0, integer);
            this.f8791b.setStyle(Style.FILL);
            this.f8791b.setColor(obtainStyledAttributes.getColor(4, color));
            this.f8792c.setStyle(Style.STROKE);
            this.f8792c.setColor(obtainStyledAttributes.getColor(7, color3));
            this.f8792c.setStrokeWidth(obtainStyledAttributes.getDimension(8, dimension));
            this.f8793d.setStyle(Style.FILL);
            this.f8793d.setColor(obtainStyledAttributes.getColor(3, color2));
            this.f8790a = obtainStyledAttributes.getDimension(5, dimension2);
            this.f8802m = obtainStyledAttributes.getBoolean(6, z2);
            Drawable drawable = obtainStyledAttributes.getDrawable(1);
            if (drawable != null) {
                setBackgroundDrawable(drawable);
            }
            obtainStyledAttributes.recycle();
            this.f8803n = C0966s.m3613a(ViewConfiguration.get(context));
        }
    }

    public void setCentered(boolean z) {
        this.f8801l = z;
        invalidate();
    }

    public void setPageColor(int i) {
        this.f8791b.setColor(i);
        invalidate();
    }

    public int getPageColor() {
        return this.f8791b.getColor();
    }

    public void setFillColor(int i) {
        this.f8793d.setColor(i);
        invalidate();
    }

    public int getFillColor() {
        return this.f8793d.getColor();
    }

    public void setOrientation(int i) {
        switch (i) {
            case 0:
            case 1:
                this.f8800k = i;
                requestLayout();
                return;
            default:
                throw new IllegalArgumentException("Orientation must be either HORIZONTAL or VERTICAL.");
        }
    }

    public int getOrientation() {
        return this.f8800k;
    }

    public void setStrokeColor(int i) {
        this.f8792c.setColor(i);
        invalidate();
    }

    public int getStrokeColor() {
        return this.f8792c.getColor();
    }

    public void setStrokeWidth(float f) {
        this.f8792c.setStrokeWidth(f);
        invalidate();
    }

    public float getStrokeWidth() {
        return this.f8792c.getStrokeWidth();
    }

    public void setRadius(float f) {
        this.f8790a = f;
        invalidate();
    }

    public float getRadius() {
        return this.f8790a;
    }

    public void setSnap(boolean z) {
        this.f8802m = z;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        int i4;
        float f;
        float f2;
        super.onDraw(canvas);
        if (this.f8794e != null) {
            int b = this.f8794e.getAdapter().mo6151b();
            if (b != 0) {
                if (this.f8796g >= b) {
                    setCurrentItem(b - 1);
                    return;
                }
                if (this.f8800k == 0) {
                    i4 = getWidth();
                    i3 = getPaddingLeft();
                    i2 = getPaddingRight();
                    i = getPaddingTop();
                } else {
                    i4 = getHeight();
                    i3 = getPaddingTop();
                    i2 = getPaddingBottom();
                    i = getPaddingLeft();
                }
                float f3 = this.f8790a * 3.0f;
                float f4 = ((float) i) + this.f8790a;
                float f5 = ((float) i3) + this.f8790a;
                if (this.f8801l) {
                    f5 += (((float) ((i4 - i3) - i2)) / 2.0f) - ((((float) b) * f3) / 2.0f);
                }
                float f6 = this.f8790a;
                if (this.f8792c.getStrokeWidth() > BitmapDescriptorFactory.HUE_RED) {
                    f6 -= this.f8792c.getStrokeWidth() / 2.0f;
                }
                for (int i5 = 0; i5 < b; i5++) {
                    float f7 = (((float) i5) * f3) + f5;
                    if (this.f8800k == 0) {
                        f2 = f4;
                    } else {
                        f2 = f7;
                        f7 = f4;
                    }
                    if (this.f8791b.getAlpha() > 0) {
                        canvas.drawCircle(f7, f2, f6, this.f8791b);
                    }
                    if (f6 != this.f8790a) {
                        canvas.drawCircle(f7, f2, this.f8790a, this.f8792c);
                    }
                }
                float f8 = ((float) (this.f8802m ? this.f8797h : this.f8796g)) * f3;
                if (!this.f8802m) {
                    f8 += this.f8798i * f3;
                }
                if (this.f8800k == 0) {
                    f = f8 + f5;
                } else {
                    float f9 = f4;
                    f4 = f8 + f5;
                    f = f9;
                }
                canvas.drawCircle(f, f4, this.f8790a, this.f8793d);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (super.onTouchEvent(motionEvent)) {
            return true;
        }
        int i = 0;
        if (this.f8794e == null || this.f8794e.getAdapter().mo6151b() == 0) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        switch (action) {
            case 0:
                this.f8805p = C0952h.m3515b(motionEvent, 0);
                this.f8804o = motionEvent.getX();
                break;
            case 1:
            case 3:
                if (!this.f8806q) {
                    int b = this.f8794e.getAdapter().mo6151b();
                    float width = (float) getWidth();
                    float f = width / 2.0f;
                    float f2 = width / 6.0f;
                    if (this.f8796g > 0 && motionEvent.getX() < f - f2) {
                        if (action != 3) {
                            this.f8794e.setCurrentItem(this.f8796g - 1);
                        }
                        return true;
                    } else if (this.f8796g < b - 1 && motionEvent.getX() > f + f2) {
                        if (action != 3) {
                            this.f8794e.setCurrentItem(this.f8796g + 1);
                        }
                        return true;
                    }
                }
                this.f8806q = false;
                this.f8805p = -1;
                if (this.f8794e.mo6094f()) {
                    this.f8794e.mo6093e();
                    break;
                }
                break;
            case 2:
                float c = C0952h.m3516c(motionEvent, C0952h.m3514a(motionEvent, this.f8805p));
                float f3 = c - this.f8804o;
                if (!this.f8806q && Math.abs(f3) > ((float) this.f8803n)) {
                    this.f8806q = true;
                }
                if (this.f8806q) {
                    this.f8804o = c;
                    if (this.f8794e.mo6094f() || this.f8794e.mo6088d()) {
                        this.f8794e.mo6080b(f3);
                        break;
                    }
                }
                break;
            case 5:
                int a = C0952h.m3513a(motionEvent);
                this.f8804o = C0952h.m3516c(motionEvent, a);
                this.f8805p = C0952h.m3515b(motionEvent, a);
                break;
            case 6:
                int a2 = C0952h.m3513a(motionEvent);
                if (C0952h.m3515b(motionEvent, a2) == this.f8805p) {
                    if (a2 == 0) {
                        i = 1;
                    }
                    this.f8805p = C0952h.m3515b(motionEvent, i);
                }
                this.f8804o = C0952h.m3516c(motionEvent, C0952h.m3514a(motionEvent, this.f8805p));
                break;
        }
        return true;
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.f8794e != viewPager) {
            if (this.f8794e != null) {
                this.f8794e.setOnPageChangeListener(null);
            }
            if (viewPager.getAdapter() != null) {
                this.f8794e = viewPager;
                this.f8794e.setOnPageChangeListener(this);
                invalidate();
                return;
            }
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
    }

    public void setCurrentItem(int i) {
        if (this.f8794e != null) {
            this.f8794e.setCurrentItem(i);
            this.f8796g = i;
            invalidate();
            return;
        }
        throw new IllegalStateException("ViewPager has not been bound.");
    }

    public void onPageScrollStateChanged(int i) {
        this.f8799j = i;
        if (this.f8795f != null) {
            this.f8795f.onPageScrollStateChanged(i);
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        this.f8796g = i;
        this.f8798i = f;
        invalidate();
        if (this.f8795f != null) {
            this.f8795f.onPageScrolled(i, f, i2);
        }
    }

    public void onPageSelected(int i) {
        if (this.f8802m || this.f8799j == 0) {
            this.f8796g = i;
            this.f8797h = i;
            invalidate();
        }
        if (this.f8795f != null) {
            this.f8795f.onPageSelected(i);
        }
    }

    public void setOnPageChangeListener(C1475f fVar) {
        this.f8795f = fVar;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.f8800k == 0) {
            setMeasuredDimension(m9835a(i), m9836b(i2));
        } else {
            setMeasuredDimension(m9836b(i), m9835a(i2));
        }
    }

    /* renamed from: a */
    private int m9835a(int i) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == 1073741824 || this.f8794e == null) {
            return size;
        }
        int b = this.f8794e.getAdapter().mo6151b();
        int paddingLeft = (int) (((float) (getPaddingLeft() + getPaddingRight())) + (((float) (b * 2)) * this.f8790a) + (((float) (b - 1)) * this.f8790a) + 1.0f);
        return mode == Integer.MIN_VALUE ? Math.min(paddingLeft, size) : paddingLeft;
    }

    /* renamed from: b */
    private int m9836b(int i) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        int paddingTop = (int) ((this.f8790a * 2.0f) + ((float) getPaddingTop()) + ((float) getPaddingBottom()) + 1.0f);
        return mode == Integer.MIN_VALUE ? Math.min(paddingTop, size) : paddingTop;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        C3367a aVar = (C3367a) parcelable;
        super.onRestoreInstanceState(aVar.getSuperState());
        this.f8796g = aVar.f8807a;
        this.f8797h = aVar.f8807a;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        C3367a aVar = new C3367a(super.onSaveInstanceState());
        aVar.f8807a = this.f8796g;
        return aVar;
    }
}
