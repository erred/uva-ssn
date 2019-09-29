package p140me.bridgefy.image;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import me.bridgefy.main.R;

/* renamed from: me.bridgefy.image.BridgefyProgress */
public class BridgefyProgress extends View {

    /* renamed from: A */
    private RectF f9231A = new RectF();

    /* renamed from: B */
    private RectF f9232B = new RectF();

    /* renamed from: C */
    private RectF f9233C = new RectF();

    /* renamed from: D */
    private RectF f9234D = new RectF();

    /* renamed from: E */
    private int f9235E = 2;

    /* renamed from: F */
    private int f9236F = 0;

    /* renamed from: G */
    private String f9237G = "";

    /* renamed from: H */
    private String[] f9238H = new String[0];

    /* renamed from: a */
    int f9239a = 0;

    /* renamed from: b */
    public boolean f9240b = false;

    /* renamed from: c */
    private int f9241c = 0;

    /* renamed from: d */
    private int f9242d = 0;

    /* renamed from: e */
    private int f9243e = 100;

    /* renamed from: f */
    private int f9244f = 80;

    /* renamed from: g */
    private int f9245g = 60;

    /* renamed from: h */
    private int f9246h = 20;

    /* renamed from: i */
    private int f9247i = 20;

    /* renamed from: j */
    private int f9248j = 20;

    /* renamed from: k */
    private float f9249k = BitmapDescriptorFactory.HUE_RED;

    /* renamed from: l */
    private int f9250l = 40;

    /* renamed from: m */
    private int f9251m = this.f9250l;

    /* renamed from: n */
    private int f9252n = this.f9250l;

    /* renamed from: o */
    private int f9253o = this.f9250l;

    /* renamed from: p */
    private int f9254p = this.f9250l;

    /* renamed from: q */
    private int f9255q = -1442840576;

    /* renamed from: r */
    private int f9256r = -1442840576;

    /* renamed from: s */
    private int f9257s = 0;

    /* renamed from: t */
    private int f9258t = -1428300323;

    /* renamed from: u */
    private int f9259u = -16777216;

    /* renamed from: v */
    private Paint f9260v = new Paint();

    /* renamed from: w */
    private Paint f9261w = new Paint();

    /* renamed from: x */
    private Paint f9262x = new Paint();

    /* renamed from: y */
    private Paint f9263y = new Paint();

    /* renamed from: z */
    private Paint f9264z = new Paint();

    public BridgefyProgress(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10375a(context.obtainStyledAttributes(attributeSet, R.styleable.BridgefyProgress));
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f9242d = i;
        this.f9241c = i2;
        m10377f();
        m10376e();
        invalidate();
    }

    /* renamed from: e */
    private void m10376e() {
        this.f9260v.setColor(this.f9255q);
        this.f9260v.setAntiAlias(true);
        this.f9260v.setStyle(Style.STROKE);
        this.f9260v.setStrokeWidth((float) this.f9246h);
        this.f9262x.setColor(this.f9258t);
        this.f9262x.setAntiAlias(true);
        this.f9262x.setStyle(Style.STROKE);
        this.f9262x.setStrokeWidth((float) this.f9247i);
        this.f9261w.setColor(this.f9257s);
        this.f9261w.setAntiAlias(true);
        this.f9261w.setStyle(Style.FILL);
        this.f9263y.setColor(this.f9259u);
        this.f9263y.setStyle(Style.FILL);
        this.f9263y.setAntiAlias(true);
        this.f9263y.setTextSize((float) this.f9248j);
        this.f9264z.setColor(this.f9256r);
        this.f9264z.setAntiAlias(true);
        this.f9264z.setStyle(Style.STROKE);
        this.f9264z.setStrokeWidth(this.f9249k);
    }

    /* renamed from: f */
    private void m10377f() {
        int min = Math.min(this.f9242d, this.f9241c);
        int i = this.f9242d - min;
        int i2 = (this.f9241c - min) / 2;
        this.f9251m = getPaddingTop() + i2;
        this.f9252n = getPaddingBottom() + i2;
        int i3 = i / 2;
        this.f9253o = getPaddingLeft() + i3;
        this.f9254p = getPaddingRight() + i3;
        int width = getWidth();
        int height = getHeight();
        this.f9231A = new RectF((float) this.f9253o, (float) this.f9251m, (float) (width - this.f9254p), (float) (height - this.f9252n));
        this.f9232B = new RectF((float) (this.f9253o + this.f9246h), (float) (this.f9251m + this.f9246h), (float) ((width - this.f9254p) - this.f9246h), (float) ((height - this.f9252n) - this.f9246h));
        this.f9234D = new RectF(this.f9232B.left + (((float) this.f9247i) / 2.0f) + (this.f9249k / 2.0f), this.f9232B.top + (((float) this.f9247i) / 2.0f) + (this.f9249k / 2.0f), (this.f9232B.right - (((float) this.f9247i) / 2.0f)) - (this.f9249k / 2.0f), (this.f9232B.bottom - (((float) this.f9247i) / 2.0f)) - (this.f9249k / 2.0f));
        this.f9233C = new RectF((this.f9232B.left - (((float) this.f9247i) / 2.0f)) - (this.f9249k / 2.0f), (this.f9232B.top - (((float) this.f9247i) / 2.0f)) - (this.f9249k / 2.0f), this.f9232B.right + (((float) this.f9247i) / 2.0f) + (this.f9249k / 2.0f), this.f9232B.bottom + (((float) this.f9247i) / 2.0f) + (this.f9249k / 2.0f));
        this.f9243e = ((width - this.f9254p) - this.f9246h) / 2;
        this.f9244f = (this.f9243e - this.f9246h) + 1;
    }

    /* renamed from: a */
    private void m10375a(TypedArray typedArray) {
        this.f9246h = (int) typedArray.getDimension(1, (float) this.f9246h);
        this.f9247i = (int) typedArray.getDimension(9, (float) this.f9247i);
        this.f9235E = (int) typedArray.getDimension(10, (float) this.f9235E);
        this.f9236F = typedArray.getInteger(5, this.f9236F);
        if (this.f9236F < 0) {
            this.f9236F = 0;
        }
        this.f9255q = typedArray.getColor(0, this.f9255q);
        this.f9245g = (int) typedArray.getDimension(6, (float) this.f9245g);
        this.f9248j = (int) typedArray.getDimension(13, (float) this.f9248j);
        this.f9259u = typedArray.getColor(12, this.f9259u);
        if (typedArray.hasValue(11)) {
            setText(typedArray.getString(11));
        }
        this.f9258t = typedArray.getColor(8, this.f9258t);
        this.f9257s = typedArray.getColor(2, this.f9257s);
        this.f9256r = typedArray.getColor(3, this.f9256r);
        this.f9249k = typedArray.getDimension(4, this.f9249k);
        typedArray.recycle();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        String[] strArr;
        super.onDraw(canvas);
        Canvas canvas2 = canvas;
        canvas2.drawArc(this.f9232B, 360.0f, 360.0f, false, this.f9261w);
        Canvas canvas3 = canvas;
        canvas3.drawArc(this.f9232B, 360.0f, 360.0f, false, this.f9262x);
        canvas2.drawArc(this.f9233C, 360.0f, 360.0f, false, this.f9264z);
        canvas3.drawArc(this.f9234D, 360.0f, 360.0f, false, this.f9264z);
        if (this.f9240b) {
            canvas.drawArc(this.f9232B, (float) (this.f9239a - 90), (float) this.f9245g, false, this.f9260v);
        } else {
            canvas.drawArc(this.f9232B, -90.0f, (float) this.f9239a, false, this.f9260v);
        }
        float descent = ((this.f9263y.descent() - this.f9263y.ascent()) / 2.0f) - this.f9263y.descent();
        for (String str : this.f9238H) {
            canvas.drawText(str, ((float) (getWidth() / 2)) - (this.f9263y.measureText(str) / 2.0f), ((float) (getHeight() / 2)) + descent, this.f9263y);
        }
        if (this.f9240b) {
            m10378g();
        }
    }

    /* renamed from: g */
    private void m10378g() {
        this.f9239a += this.f9235E;
        if (this.f9239a > 360) {
            this.f9239a = 0;
        }
        postInvalidateDelayed((long) this.f9236F);
    }

    /* renamed from: a */
    public boolean mo29363a() {
        return this.f9240b;
    }

    /* renamed from: b */
    public void mo29364b() {
        this.f9239a = 0;
        setText("0%");
        invalidate();
    }

    /* renamed from: c */
    public void mo29365c() {
        this.f9240b = false;
        this.f9239a = 0;
        postInvalidate();
    }

    /* renamed from: d */
    public void mo29366d() {
        this.f9240b = true;
        postInvalidate();
    }

    public void setProgress(int i) {
        this.f9240b = false;
        this.f9239a = i;
        StringBuilder sb = new StringBuilder();
        sb.append(Math.round((((float) this.f9239a) / 360.0f) * 100.0f));
        sb.append("%");
        setText(sb.toString());
        postInvalidate();
    }

    public void setText(String str) {
        this.f9237G = str;
        this.f9238H = this.f9237G.split("\n");
    }

    public int getCircleRadius() {
        return this.f9244f;
    }

    public void setCircleRadius(int i) {
        this.f9244f = i;
    }

    public int getBarLength() {
        return this.f9245g;
    }

    public void setBarLength(int i) {
        this.f9245g = i;
    }

    public int getBarWidth() {
        return this.f9246h;
    }

    public void setBarWidth(int i) {
        this.f9246h = i;
        if (this.f9260v != null) {
            this.f9260v.setStrokeWidth((float) this.f9246h);
        }
    }

    public int getTextSize() {
        return this.f9248j;
    }

    public void setTextSize(int i) {
        this.f9248j = i;
        if (this.f9263y != null) {
            this.f9263y.setTextSize((float) this.f9248j);
        }
    }

    public int getPaddingTop() {
        return this.f9251m;
    }

    public void setPaddingTop(int i) {
        this.f9251m = i;
    }

    public int getPaddingBottom() {
        return this.f9252n;
    }

    public void setPaddingBottom(int i) {
        this.f9252n = i;
    }

    public int getPaddingLeft() {
        return this.f9253o;
    }

    public void setPaddingLeft(int i) {
        this.f9253o = i;
    }

    public int getPaddingRight() {
        return this.f9254p;
    }

    public void setPaddingRight(int i) {
        this.f9254p = i;
    }

    public int getBarColor() {
        return this.f9255q;
    }

    public void setBarColor(int i) {
        this.f9255q = i;
        if (this.f9260v != null) {
            this.f9260v.setColor(this.f9255q);
        }
    }

    public int getCircleColor() {
        return this.f9257s;
    }

    public void setCircleColor(int i) {
        this.f9257s = i;
        if (this.f9261w != null) {
            this.f9261w.setColor(this.f9257s);
        }
    }

    public int getRimColor() {
        return this.f9258t;
    }

    public void setRimColor(int i) {
        this.f9258t = i;
        if (this.f9262x != null) {
            this.f9262x.setColor(this.f9258t);
        }
    }

    public Shader getRimShader() {
        return this.f9262x.getShader();
    }

    public void setRimShader(Shader shader) {
        this.f9262x.setShader(shader);
    }

    public int getTextColor() {
        return this.f9259u;
    }

    public void setTextColor(int i) {
        this.f9259u = i;
        if (this.f9263y != null) {
            this.f9263y.setColor(this.f9259u);
        }
    }

    public int getSpinSpeed() {
        return this.f9235E;
    }

    public void setSpinSpeed(int i) {
        this.f9235E = i;
    }

    public int getRimWidth() {
        return this.f9247i;
    }

    public void setRimWidth(int i) {
        this.f9247i = i;
        if (this.f9262x != null) {
            this.f9262x.setStrokeWidth((float) this.f9247i);
        }
    }

    public int getDelayMillis() {
        return this.f9236F;
    }

    public void setDelayMillis(int i) {
        this.f9236F = i;
    }

    public int getContourColor() {
        return this.f9256r;
    }

    public void setContourColor(int i) {
        this.f9256r = i;
        if (this.f9264z != null) {
            this.f9264z.setColor(this.f9256r);
        }
    }

    public float getContourSize() {
        return this.f9249k;
    }

    public void setContourSize(float f) {
        this.f9249k = f;
        if (this.f9264z != null) {
            this.f9264z.setStrokeWidth(this.f9249k);
        }
    }
}
