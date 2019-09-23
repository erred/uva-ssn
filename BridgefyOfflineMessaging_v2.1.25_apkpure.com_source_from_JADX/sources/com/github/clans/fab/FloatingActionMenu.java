package com.github.clans.fab;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class FloatingActionMenu extends ViewGroup {

    /* renamed from: A */
    private boolean f6562A;

    /* renamed from: B */
    private int f6563B;

    /* renamed from: C */
    private float f6564C;

    /* renamed from: D */
    private float f6565D;

    /* renamed from: E */
    private float f6566E;

    /* renamed from: F */
    private int f6567F;

    /* renamed from: G */
    private int f6568G;

    /* renamed from: H */
    private int f6569H;

    /* renamed from: I */
    private Drawable f6570I;

    /* renamed from: J */
    private int f6571J;

    /* renamed from: K */
    private Interpolator f6572K;

    /* renamed from: L */
    private Interpolator f6573L;
    /* access modifiers changed from: private */

    /* renamed from: M */
    public boolean f6574M;

    /* renamed from: N */
    private boolean f6575N;

    /* renamed from: O */
    private int f6576O;

    /* renamed from: P */
    private int f6577P;

    /* renamed from: Q */
    private int f6578Q;

    /* renamed from: R */
    private int f6579R;

    /* renamed from: S */
    private boolean f6580S;

    /* renamed from: T */
    private ImageView f6581T;

    /* renamed from: U */
    private Animation f6582U;

    /* renamed from: V */
    private Animation f6583V;
    /* access modifiers changed from: private */

    /* renamed from: W */
    public boolean f6584W;

    /* renamed from: a */
    GestureDetector f6585a;

    /* renamed from: aa */
    private int f6586aa;
    /* access modifiers changed from: private */

    /* renamed from: ab */
    public C2130a f6587ab;

    /* renamed from: ac */
    private ValueAnimator f6588ac;

    /* renamed from: ad */
    private ValueAnimator f6589ad;

    /* renamed from: ae */
    private int f6590ae;

    /* renamed from: af */
    private int f6591af;

    /* renamed from: ag */
    private Context f6592ag;

    /* renamed from: ah */
    private String f6593ah;

    /* renamed from: ai */
    private boolean f6594ai;

    /* renamed from: b */
    private AnimatorSet f6595b;

    /* renamed from: c */
    private AnimatorSet f6596c;

    /* renamed from: d */
    private AnimatorSet f6597d;

    /* renamed from: e */
    private int f6598e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public FloatingActionButton f6599f;

    /* renamed from: g */
    private int f6600g;

    /* renamed from: h */
    private int f6601h;

    /* renamed from: i */
    private int f6602i;

    /* renamed from: j */
    private int f6603j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f6604k;

    /* renamed from: l */
    private boolean f6605l;

    /* renamed from: m */
    private Handler f6606m;

    /* renamed from: n */
    private int f6607n;

    /* renamed from: o */
    private int f6608o;

    /* renamed from: p */
    private int f6609p;

    /* renamed from: q */
    private int f6610q;

    /* renamed from: r */
    private int f6611r;

    /* renamed from: s */
    private int f6612s;

    /* renamed from: t */
    private ColorStateList f6613t;

    /* renamed from: u */
    private float f6614u;

    /* renamed from: v */
    private int f6615v;

    /* renamed from: w */
    private boolean f6616w;

    /* renamed from: x */
    private int f6617x;

    /* renamed from: y */
    private int f6618y;

    /* renamed from: z */
    private int f6619z;

    /* renamed from: com.github.clans.fab.FloatingActionMenu$a */
    public interface C2130a {
        void onMenuToggle(boolean z);
    }

    /* renamed from: b */
    private int m8529b(int i) {
        double d = (double) i;
        return (int) ((0.03d * d) + d);
    }

    public FloatingActionMenu(Context context) {
        this(context, null);
    }

    public FloatingActionMenu(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FloatingActionMenu(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6595b = new AnimatorSet();
        this.f6596c = new AnimatorSet();
        this.f6598e = C2138b.m8571a(getContext(), BitmapDescriptorFactory.HUE_RED);
        this.f6601h = C2138b.m8571a(getContext(), BitmapDescriptorFactory.HUE_RED);
        this.f6602i = C2138b.m8571a(getContext(), BitmapDescriptorFactory.HUE_RED);
        this.f6606m = new Handler();
        this.f6609p = C2138b.m8571a(getContext(), 4.0f);
        this.f6610q = C2138b.m8571a(getContext(), 8.0f);
        this.f6611r = C2138b.m8571a(getContext(), 4.0f);
        this.f6612s = C2138b.m8571a(getContext(), 8.0f);
        this.f6615v = C2138b.m8571a(getContext(), 3.0f);
        this.f6564C = 4.0f;
        this.f6565D = 1.0f;
        this.f6566E = 3.0f;
        this.f6574M = true;
        this.f6580S = true;
        this.f6585a = new GestureDetector(getContext(), new SimpleOnGestureListener() {
            public boolean onDown(MotionEvent motionEvent) {
                return FloatingActionMenu.this.f6584W && FloatingActionMenu.this.mo12065b();
            }

            public boolean onSingleTapUp(MotionEvent motionEvent) {
                FloatingActionMenu.this.mo12066c(FloatingActionMenu.this.f6574M);
                return true;
            }
        });
        m8524a(context, attributeSet);
    }

    /* renamed from: a */
    private void m8524a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FloatingActionMenu, 0, 0);
        this.f6598e = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FloatingActionMenu_menu_buttonSpacing, this.f6598e);
        this.f6601h = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FloatingActionMenu_menu_labels_margin, this.f6601h);
        this.f6591af = obtainStyledAttributes.getInt(R.styleable.FloatingActionMenu_menu_labels_position, 0);
        this.f6607n = obtainStyledAttributes.getResourceId(R.styleable.FloatingActionMenu_menu_labels_showAnimation, this.f6591af == 0 ? R.anim.fab_slide_in_from_right : R.anim.fab_slide_in_from_left);
        this.f6608o = obtainStyledAttributes.getResourceId(R.styleable.FloatingActionMenu_menu_labels_hideAnimation, this.f6591af == 0 ? R.anim.fab_slide_out_to_right : R.anim.fab_slide_out_to_left);
        this.f6609p = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FloatingActionMenu_menu_labels_paddingTop, this.f6609p);
        this.f6610q = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FloatingActionMenu_menu_labels_paddingRight, this.f6610q);
        this.f6611r = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FloatingActionMenu_menu_labels_paddingBottom, this.f6611r);
        this.f6612s = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FloatingActionMenu_menu_labels_paddingLeft, this.f6612s);
        this.f6613t = obtainStyledAttributes.getColorStateList(R.styleable.FloatingActionMenu_menu_labels_textColor);
        if (this.f6613t == null) {
            this.f6613t = ColorStateList.valueOf(-1);
        }
        this.f6614u = obtainStyledAttributes.getDimension(R.styleable.FloatingActionMenu_menu_labels_textSize, getResources().getDimension(R.dimen.labels_text_size));
        this.f6615v = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FloatingActionMenu_menu_labels_cornerRadius, this.f6615v);
        this.f6616w = obtainStyledAttributes.getBoolean(R.styleable.FloatingActionMenu_menu_labels_showShadow, true);
        this.f6617x = obtainStyledAttributes.getColor(R.styleable.FloatingActionMenu_menu_labels_colorNormal, -13421773);
        this.f6618y = obtainStyledAttributes.getColor(R.styleable.FloatingActionMenu_menu_labels_colorPressed, -12303292);
        this.f6619z = obtainStyledAttributes.getColor(R.styleable.FloatingActionMenu_menu_labels_colorRipple, 1728053247);
        this.f6562A = obtainStyledAttributes.getBoolean(R.styleable.FloatingActionMenu_menu_showShadow, true);
        this.f6563B = obtainStyledAttributes.getColor(R.styleable.FloatingActionMenu_menu_shadowColor, 1711276032);
        this.f6564C = obtainStyledAttributes.getDimension(R.styleable.FloatingActionMenu_menu_shadowRadius, this.f6564C);
        this.f6565D = obtainStyledAttributes.getDimension(R.styleable.FloatingActionMenu_menu_shadowXOffset, this.f6565D);
        this.f6566E = obtainStyledAttributes.getDimension(R.styleable.FloatingActionMenu_menu_shadowYOffset, this.f6566E);
        this.f6567F = obtainStyledAttributes.getColor(R.styleable.FloatingActionMenu_menu_colorNormal, -2473162);
        this.f6568G = obtainStyledAttributes.getColor(R.styleable.FloatingActionMenu_menu_colorPressed, -1617853);
        this.f6569H = obtainStyledAttributes.getColor(R.styleable.FloatingActionMenu_menu_colorRipple, -1711276033);
        this.f6571J = obtainStyledAttributes.getInt(R.styleable.FloatingActionMenu_menu_animationDelayPerItem, 50);
        this.f6570I = obtainStyledAttributes.getDrawable(R.styleable.FloatingActionMenu_menu_icon);
        if (this.f6570I == null) {
            this.f6570I = getResources().getDrawable(R.drawable.fab_add);
        }
        this.f6575N = obtainStyledAttributes.getBoolean(R.styleable.FloatingActionMenu_menu_labels_singleLine, false);
        this.f6576O = obtainStyledAttributes.getInt(R.styleable.FloatingActionMenu_menu_labels_ellipsize, 0);
        this.f6577P = obtainStyledAttributes.getInt(R.styleable.FloatingActionMenu_menu_labels_maxLines, -1);
        this.f6578Q = obtainStyledAttributes.getInt(R.styleable.FloatingActionMenu_menu_fab_size, 0);
        this.f6579R = obtainStyledAttributes.getResourceId(R.styleable.FloatingActionMenu_menu_labels_style, 0);
        this.f6586aa = obtainStyledAttributes.getInt(R.styleable.FloatingActionMenu_menu_openDirection, 0);
        this.f6590ae = obtainStyledAttributes.getColor(R.styleable.FloatingActionMenu_menu_backgroundColor, 0);
        if (obtainStyledAttributes.hasValue(R.styleable.FloatingActionMenu_menu_fab_label)) {
            this.f6594ai = true;
            this.f6593ah = obtainStyledAttributes.getString(R.styleable.FloatingActionMenu_menu_fab_label);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.FloatingActionMenu_menu_labels_padding)) {
            m8523a(obtainStyledAttributes.getDimensionPixelSize(R.styleable.FloatingActionMenu_menu_labels_padding, 0));
        }
        this.f6572K = new OvershootInterpolator();
        this.f6573L = new AnticipateInterpolator();
        this.f6592ag = new ContextThemeWrapper(getContext(), this.f6579R);
        m8532c();
        m8535e();
        m8525a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    private void m8525a(TypedArray typedArray) {
        setMenuButtonShowAnimation(AnimationUtils.loadAnimation(getContext(), typedArray.getResourceId(R.styleable.FloatingActionMenu_menu_fab_show_animation, R.anim.fab_scale_up)));
        setMenuButtonHideAnimation(AnimationUtils.loadAnimation(getContext(), typedArray.getResourceId(R.styleable.FloatingActionMenu_menu_fab_hide_animation, R.anim.fab_scale_down)));
    }

    /* renamed from: c */
    private void m8532c() {
        int alpha = Color.alpha(this.f6590ae);
        final int red = Color.red(this.f6590ae);
        final int green = Color.green(this.f6590ae);
        final int blue = Color.blue(this.f6590ae);
        this.f6588ac = ValueAnimator.ofInt(new int[]{0, alpha});
        this.f6588ac.setDuration(300);
        this.f6588ac.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                FloatingActionMenu.this.setBackgroundColor(Color.argb(((Integer) valueAnimator.getAnimatedValue()).intValue(), red, green, blue));
            }
        });
        this.f6589ad = ValueAnimator.ofInt(new int[]{alpha, 0});
        this.f6589ad.setDuration(300);
        this.f6589ad.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                FloatingActionMenu.this.setBackgroundColor(Color.argb(((Integer) valueAnimator.getAnimatedValue()).intValue(), red, green, blue));
            }
        });
    }

    /* renamed from: d */
    private boolean m8534d() {
        return this.f6590ae != 0;
    }

    /* renamed from: a */
    private void m8523a(int i) {
        this.f6609p = i;
        this.f6610q = i;
        this.f6611r = i;
        this.f6612s = i;
    }

    /* renamed from: e */
    private void m8535e() {
        this.f6599f = new FloatingActionButton(getContext());
        this.f6599f.f6514b = this.f6562A;
        if (this.f6562A) {
            this.f6599f.f6516d = C2138b.m8571a(getContext(), this.f6564C);
            this.f6599f.f6517e = C2138b.m8571a(getContext(), this.f6565D);
            this.f6599f.f6518f = C2138b.m8571a(getContext(), this.f6566E);
        }
        this.f6599f.mo11977a(this.f6567F, this.f6568G, this.f6569H);
        this.f6599f.f6515c = this.f6563B;
        this.f6599f.f6513a = this.f6578Q;
        this.f6599f.mo11982c();
        this.f6599f.setLabelText(this.f6593ah);
        this.f6581T = new ImageView(getContext());
        this.f6581T.setImageDrawable(this.f6570I);
        addView(this.f6599f, super.generateDefaultLayoutParams());
        addView(this.f6581T);
        m8536f();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0023, code lost:
        if (r8.f6591af == 0) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0013, code lost:
        if (r8.f6591af == 0) goto L_0x0015;
     */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m8536f() {
        /*
            r8 = this;
            int r0 = r8.f6586aa
            r1 = 1124532224(0x43070000, float:135.0)
            r2 = -1022951424(0xffffffffc3070000, float:-135.0)
            if (r0 != 0) goto L_0x0018
            int r0 = r8.f6591af
            if (r0 != 0) goto L_0x000f
            r0 = -1022951424(0xffffffffc3070000, float:-135.0)
            goto L_0x0011
        L_0x000f:
            r0 = 1124532224(0x43070000, float:135.0)
        L_0x0011:
            int r3 = r8.f6591af
            if (r3 != 0) goto L_0x0025
        L_0x0015:
            r1 = -1022951424(0xffffffffc3070000, float:-135.0)
            goto L_0x0025
        L_0x0018:
            int r0 = r8.f6591af
            if (r0 != 0) goto L_0x001f
            r0 = 1124532224(0x43070000, float:135.0)
            goto L_0x0021
        L_0x001f:
            r0 = -1022951424(0xffffffffc3070000, float:-135.0)
        L_0x0021:
            int r3 = r8.f6591af
            if (r3 != 0) goto L_0x0015
        L_0x0025:
            android.widget.ImageView r2 = r8.f6581T
            java.lang.String r3 = "rotation"
            r4 = 2
            float[] r5 = new float[r4]
            r6 = 0
            r5[r6] = r0
            r0 = 0
            r7 = 1
            r5[r7] = r0
            android.animation.ObjectAnimator r2 = android.animation.ObjectAnimator.ofFloat(r2, r3, r5)
            android.widget.ImageView r3 = r8.f6581T
            java.lang.String r5 = "rotation"
            float[] r4 = new float[r4]
            r4[r6] = r0
            r4[r7] = r1
            android.animation.ObjectAnimator r0 = android.animation.ObjectAnimator.ofFloat(r3, r5, r4)
            android.animation.AnimatorSet r1 = r8.f6595b
            r1.play(r0)
            android.animation.AnimatorSet r0 = r8.f6596c
            r0.play(r2)
            android.animation.AnimatorSet r0 = r8.f6595b
            android.view.animation.Interpolator r1 = r8.f6572K
            r0.setInterpolator(r1)
            android.animation.AnimatorSet r0 = r8.f6596c
            android.view.animation.Interpolator r1 = r8.f6573L
            r0.setInterpolator(r1)
            android.animation.AnimatorSet r0 = r8.f6595b
            r1 = 300(0x12c, double:1.48E-321)
            r0.setDuration(r1)
            android.animation.AnimatorSet r0 = r8.f6596c
            r0.setDuration(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.clans.fab.FloatingActionMenu.m8536f():void");
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        this.f6600g = 0;
        measureChildWithMargins(this.f6581T, i, 0, i2, 0);
        for (int i3 = 0; i3 < this.f6603j; i3++) {
            View childAt = getChildAt(i3);
            if (!(childAt.getVisibility() == 8 || childAt == this.f6581T)) {
                measureChildWithMargins(childAt, i, 0, i2, 0);
                this.f6600g = Math.max(this.f6600g, childAt.getMeasuredWidth());
            }
        }
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int i7 = 1;
            if (i5 >= this.f6603j) {
                break;
            }
            View childAt2 = getChildAt(i5);
            if (!(childAt2.getVisibility() == 8 || childAt2 == this.f6581T)) {
                int measuredWidth = childAt2.getMeasuredWidth() + 0;
                int measuredHeight = i4 + childAt2.getMeasuredHeight();
                C2134a aVar = (C2134a) childAt2.getTag(R.id.fab_label);
                if (aVar != null) {
                    int measuredWidth2 = this.f6600g - childAt2.getMeasuredWidth();
                    if (!this.f6594ai) {
                        i7 = 2;
                    }
                    int i8 = measuredWidth2 / i7;
                    measureChildWithMargins(aVar, i, childAt2.getMeasuredWidth() + aVar.mo12111a() + this.f6601h + i8, i2, 0);
                    i6 = Math.max(i6, measuredWidth + aVar.getMeasuredWidth() + i8);
                }
                i4 = measuredHeight;
            }
            i5++;
        }
        int max = Math.max(this.f6600g, i6 + this.f6601h) + getPaddingLeft() + getPaddingRight();
        int b = m8529b(i4 + (this.f6598e * (this.f6603j - 1)) + getPaddingTop() + getPaddingBottom());
        if (getLayoutParams().width == -1) {
            max = getDefaultSize(getSuggestedMinimumWidth(), i);
        }
        if (getLayoutParams().height == -1) {
            b = getDefaultSize(getSuggestedMinimumHeight(), i2);
        }
        setMeasuredDimension(max, b);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        if (this.f6591af == 0) {
            i5 = ((i3 - i) - (this.f6600g / 2)) - getPaddingRight();
        } else {
            i5 = (this.f6600g / 2) + getPaddingLeft();
        }
        boolean z2 = this.f6586aa == 0;
        if (z2) {
            i6 = ((i4 - i2) - this.f6599f.getMeasuredHeight()) - getPaddingBottom();
        } else {
            i6 = getPaddingTop();
        }
        int measuredWidth = i5 - (this.f6599f.getMeasuredWidth() / 2);
        this.f6599f.layout(measuredWidth, i6, this.f6599f.getMeasuredWidth() + measuredWidth, this.f6599f.getMeasuredHeight() + i6);
        int measuredWidth2 = i5 - (this.f6581T.getMeasuredWidth() / 2);
        int measuredHeight = ((this.f6599f.getMeasuredHeight() / 2) + i6) - (this.f6581T.getMeasuredHeight() / 2);
        this.f6581T.layout(measuredWidth2, measuredHeight, this.f6581T.getMeasuredWidth() + measuredWidth2, this.f6581T.getMeasuredHeight() + measuredHeight);
        if (z2) {
            i6 = i6 + this.f6599f.getMeasuredHeight() + this.f6598e;
        }
        for (int i8 = this.f6603j - 1; i8 >= 0; i8--) {
            View childAt = getChildAt(i8);
            if (childAt != this.f6581T) {
                FloatingActionButton floatingActionButton = (FloatingActionButton) childAt;
                if (floatingActionButton.getVisibility() != 8) {
                    int measuredWidth3 = i5 - (floatingActionButton.getMeasuredWidth() / 2);
                    if (z2) {
                        i6 = (i6 - floatingActionButton.getMeasuredHeight()) - this.f6598e;
                    }
                    if (floatingActionButton != this.f6599f) {
                        floatingActionButton.layout(measuredWidth3, i6, floatingActionButton.getMeasuredWidth() + measuredWidth3, floatingActionButton.getMeasuredHeight() + i6);
                        if (!this.f6605l) {
                            floatingActionButton.mo11981b(false);
                        }
                    }
                    View view = (View) floatingActionButton.getTag(R.id.fab_label);
                    if (view != null) {
                        int measuredWidth4 = ((this.f6594ai ? this.f6600g : floatingActionButton.getMeasuredWidth()) / 2) + this.f6601h;
                        int i9 = this.f6591af == 0 ? i5 - measuredWidth4 : measuredWidth4 + i5;
                        if (this.f6591af == 0) {
                            i7 = i9 - view.getMeasuredWidth();
                        } else {
                            i7 = view.getMeasuredWidth() + i9;
                        }
                        int i10 = this.f6591af == 0 ? i7 : i9;
                        if (this.f6591af != 0) {
                            i9 = i7;
                        }
                        int measuredHeight2 = (i6 - this.f6602i) + ((floatingActionButton.getMeasuredHeight() - view.getMeasuredHeight()) / 2);
                        view.layout(i10, measuredHeight2, i9, view.getMeasuredHeight() + measuredHeight2);
                        if (!this.f6605l) {
                            view.setVisibility(4);
                        }
                    }
                    if (z2) {
                        i6 -= this.f6598e;
                    } else {
                        i6 = i6 + childAt.getMeasuredHeight() + this.f6598e;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        bringChildToFront(this.f6599f);
        bringChildToFront(this.f6581T);
        this.f6603j = getChildCount();
        m8537g();
    }

    /* renamed from: g */
    private void m8537g() {
        for (int i = 0; i < this.f6603j; i++) {
            if (getChildAt(i) != this.f6581T) {
                FloatingActionButton floatingActionButton = (FloatingActionButton) getChildAt(i);
                if (floatingActionButton.getTag(R.id.fab_label) == null) {
                    m8526a(floatingActionButton);
                    if (floatingActionButton == this.f6599f) {
                        this.f6599f.setOnClickListener(new OnClickListener() {
                            public void onClick(View view) {
                                FloatingActionMenu.this.mo12063a(FloatingActionMenu.this.f6574M);
                            }
                        });
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m8526a(FloatingActionButton floatingActionButton) {
        String labelText = floatingActionButton.getLabelText();
        if (!TextUtils.isEmpty(labelText)) {
            C2134a aVar = new C2134a(this.f6592ag);
            aVar.setClickable(true);
            aVar.setFab(floatingActionButton);
            aVar.setShowAnimation(AnimationUtils.loadAnimation(getContext(), this.f6607n));
            aVar.setHideAnimation(AnimationUtils.loadAnimation(getContext(), this.f6608o));
            if (this.f6579R > 0) {
                aVar.setTextAppearance(getContext(), this.f6579R);
                aVar.setShowShadow(false);
                aVar.setUsingStyle(true);
            } else {
                aVar.mo12112a(this.f6617x, this.f6618y, this.f6619z);
                aVar.setShowShadow(this.f6616w);
                aVar.setCornerRadius(this.f6615v);
                if (this.f6576O > 0) {
                    setLabelEllipsize(aVar);
                }
                aVar.setMaxLines(this.f6577P);
                aVar.mo12116c();
                aVar.setTextSize(0, this.f6614u);
                aVar.setTextColor(this.f6613t);
                int i = this.f6612s;
                int i2 = this.f6609p;
                if (this.f6616w) {
                    i += floatingActionButton.getShadowRadius() + Math.abs(floatingActionButton.getShadowXOffset());
                    i2 += floatingActionButton.getShadowRadius() + Math.abs(floatingActionButton.getShadowYOffset());
                }
                aVar.setPadding(i, i2, this.f6612s, this.f6609p);
                if (this.f6577P < 0 || this.f6575N) {
                    aVar.setSingleLine(this.f6575N);
                }
            }
            aVar.setText(labelText);
            aVar.setOnClickListener(floatingActionButton.getOnClickListener());
            addView(aVar);
            floatingActionButton.setTag(R.id.fab_label, aVar);
        }
    }

    private void setLabelEllipsize(C2134a aVar) {
        switch (this.f6576O) {
            case 1:
                aVar.setEllipsize(TruncateAt.START);
                return;
            case 2:
                aVar.setEllipsize(TruncateAt.MIDDLE);
                return;
            case 3:
                aVar.setEllipsize(TruncateAt.END);
                return;
            case 4:
                aVar.setEllipsize(TruncateAt.MARQUEE);
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    public MarginLayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new MarginLayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public MarginLayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return new MarginLayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public MarginLayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(-2, -2);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof MarginLayoutParams;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f6584W) {
            return this.f6585a.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    /* renamed from: b */
    public boolean mo12065b() {
        return this.f6604k;
    }

    /* renamed from: a */
    public void mo12063a(boolean z) {
        if (mo12065b()) {
            mo12066c(z);
        } else {
            mo12064b(z);
        }
    }

    /* renamed from: b */
    public void mo12064b(final boolean z) {
        if (!mo12065b()) {
            if (m8534d()) {
                this.f6588ac.start();
            }
            if (this.f6580S) {
                if (this.f6597d != null) {
                    this.f6597d.start();
                } else {
                    this.f6596c.cancel();
                    this.f6595b.start();
                }
            }
            this.f6605l = true;
            int i = 0;
            int i2 = 0;
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = getChildAt(childCount);
                if ((childAt instanceof FloatingActionButton) && childAt.getVisibility() != 8) {
                    i++;
                    final FloatingActionButton floatingActionButton = (FloatingActionButton) childAt;
                    this.f6606m.postDelayed(new Runnable() {
                        public void run() {
                            if (!FloatingActionMenu.this.mo12065b()) {
                                if (floatingActionButton != FloatingActionMenu.this.f6599f) {
                                    floatingActionButton.mo11979a(z);
                                }
                                C2134a aVar = (C2134a) floatingActionButton.getTag(R.id.fab_label);
                                if (aVar != null && aVar.mo12119f()) {
                                    aVar.mo12113a(z);
                                }
                            }
                        }
                    }, (long) i2);
                    i2 += this.f6571J;
                }
            }
            this.f6606m.postDelayed(new Runnable() {
                public void run() {
                    FloatingActionMenu.this.f6604k = true;
                    if (FloatingActionMenu.this.f6587ab != null) {
                        FloatingActionMenu.this.f6587ab.onMenuToggle(true);
                    }
                }
            }, (long) ((i + 1) * this.f6571J));
        }
    }

    /* renamed from: c */
    public void mo12066c(final boolean z) {
        if (mo12065b()) {
            if (m8534d()) {
                this.f6589ad.start();
            }
            if (this.f6580S) {
                if (this.f6597d != null) {
                    this.f6597d.start();
                } else {
                    this.f6596c.start();
                    this.f6595b.cancel();
                }
            }
            this.f6605l = false;
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if ((childAt instanceof FloatingActionButton) && childAt.getVisibility() != 8) {
                    i++;
                    final FloatingActionButton floatingActionButton = (FloatingActionButton) childAt;
                    this.f6606m.postDelayed(new Runnable() {
                        public void run() {
                            if (FloatingActionMenu.this.mo12065b()) {
                                if (floatingActionButton != FloatingActionMenu.this.f6599f) {
                                    floatingActionButton.mo11981b(z);
                                }
                                C2134a aVar = (C2134a) floatingActionButton.getTag(R.id.fab_label);
                                if (aVar != null && aVar.mo12119f()) {
                                    aVar.mo12115b(z);
                                }
                            }
                        }
                    }, (long) i2);
                    i2 += this.f6571J;
                }
            }
            this.f6606m.postDelayed(new Runnable() {
                public void run() {
                    FloatingActionMenu.this.f6604k = false;
                    if (FloatingActionMenu.this.f6587ab != null) {
                        FloatingActionMenu.this.f6587ab.onMenuToggle(false);
                    }
                }
            }, (long) ((i + 1) * this.f6571J));
        }
    }

    public void setIconAnimationInterpolator(Interpolator interpolator) {
        this.f6595b.setInterpolator(interpolator);
        this.f6596c.setInterpolator(interpolator);
    }

    public void setIconAnimationOpenInterpolator(Interpolator interpolator) {
        this.f6595b.setInterpolator(interpolator);
    }

    public void setIconAnimationCloseInterpolator(Interpolator interpolator) {
        this.f6596c.setInterpolator(interpolator);
    }

    public void setAnimated(boolean z) {
        this.f6574M = z;
        long j = 0;
        this.f6595b.setDuration(z ? 300 : 0);
        AnimatorSet animatorSet = this.f6596c;
        if (z) {
            j = 300;
        }
        animatorSet.setDuration(j);
    }

    public void setAnimationDelayPerItem(int i) {
        this.f6571J = i;
    }

    public int getAnimationDelayPerItem() {
        return this.f6571J;
    }

    public void setOnMenuToggleListener(C2130a aVar) {
        this.f6587ab = aVar;
    }

    public void setIconAnimated(boolean z) {
        this.f6580S = z;
    }

    public ImageView getMenuIconView() {
        return this.f6581T;
    }

    public void setIconToggleAnimatorSet(AnimatorSet animatorSet) {
        this.f6597d = animatorSet;
    }

    public AnimatorSet getIconToggleAnimatorSet() {
        return this.f6597d;
    }

    public void setMenuButtonShowAnimation(Animation animation) {
        this.f6582U = animation;
        this.f6599f.setShowAnimation(animation);
    }

    public void setMenuButtonHideAnimation(Animation animation) {
        this.f6583V = animation;
        this.f6599f.setHideAnimation(animation);
    }

    public void setClosedOnTouchOutside(boolean z) {
        this.f6584W = z;
    }

    public void setMenuButtonColorNormal(int i) {
        this.f6567F = i;
        this.f6599f.setColorNormal(i);
    }

    public void setMenuButtonColorNormalResId(int i) {
        this.f6567F = getResources().getColor(i);
        this.f6599f.setColorNormalResId(i);
    }

    public int getMenuButtonColorNormal() {
        return this.f6567F;
    }

    public void setMenuButtonColorPressed(int i) {
        this.f6568G = i;
        this.f6599f.setColorPressed(i);
    }

    public void setMenuButtonColorPressedResId(int i) {
        this.f6568G = getResources().getColor(i);
        this.f6599f.setColorPressedResId(i);
    }

    public int getMenuButtonColorPressed() {
        return this.f6568G;
    }

    public void setMenuButtonColorRipple(int i) {
        this.f6569H = i;
        this.f6599f.setColorRipple(i);
    }

    public void setMenuButtonColorRippleResId(int i) {
        this.f6569H = getResources().getColor(i);
        this.f6599f.setColorRippleResId(i);
    }

    public int getMenuButtonColorRipple() {
        return this.f6569H;
    }

    public void setMenuButtonLabelText(String str) {
        this.f6599f.setLabelText(str);
    }

    public String getMenuButtonLabelText() {
        return this.f6593ah;
    }

    public void setOnMenuButtonClickListener(OnClickListener onClickListener) {
        this.f6599f.setOnClickListener(onClickListener);
    }
}
