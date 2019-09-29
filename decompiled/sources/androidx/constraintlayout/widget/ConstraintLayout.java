package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.constraintlayout.p060b.C0788f;
import androidx.constraintlayout.p060b.p061a.C0761e.C0764b;
import androidx.constraintlayout.p060b.p061a.C0761e.C0765c;
import androidx.constraintlayout.p060b.p061a.C0766f;
import androidx.constraintlayout.p060b.p061a.C0766f.C0768a;
import androidx.constraintlayout.p060b.p061a.C0769g;
import androidx.constraintlayout.p060b.p061a.C0771i;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.HashMap;

public class ConstraintLayout extends ViewGroup {

    /* renamed from: a */
    SparseArray<View> f2451a = new SparseArray<>();

    /* renamed from: b */
    C0769g f2452b = new C0769g();

    /* renamed from: c */
    protected C0806d f2453c = null;

    /* renamed from: d */
    int f2454d = -1;

    /* renamed from: e */
    int f2455e = -1;

    /* renamed from: f */
    int f2456f = 0;

    /* renamed from: g */
    int f2457g = 0;

    /* renamed from: h */
    Handler f2458h = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            ConstraintLayout.this.mo3239a(ConstraintLayout.this.f2468r, message.arg1, message.arg2);
        }
    };

    /* renamed from: i */
    private ArrayList<C0805c> f2459i = new ArrayList<>(4);

    /* renamed from: j */
    private final ArrayList<C0766f> f2460j = new ArrayList<>(100);

    /* renamed from: k */
    private int f2461k = 0;

    /* renamed from: l */
    private int f2462l = 0;

    /* renamed from: m */
    private int f2463m = BaseClientBuilder.API_PRIORITY_OTHER;

    /* renamed from: n */
    private int f2464n = BaseClientBuilder.API_PRIORITY_OTHER;

    /* renamed from: o */
    private boolean f2465o = true;

    /* renamed from: p */
    private int f2466p = 3;

    /* renamed from: q */
    private C0809e f2467q = null;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public int f2468r = -1;

    /* renamed from: s */
    private HashMap<String, Integer> f2469s = new HashMap<>();

    /* renamed from: t */
    private int f2470t = -1;

    /* renamed from: u */
    private int f2471u = -1;

    /* renamed from: v */
    private C0813g f2472v;

    /* renamed from: w */
    private C0788f f2473w;

    /* renamed from: androidx.constraintlayout.widget.ConstraintLayout$a */
    public static class C0795a extends MarginLayoutParams {

        /* renamed from: A */
        public float f2475A = 0.5f;

        /* renamed from: B */
        public String f2476B = null;

        /* renamed from: C */
        float f2477C = BitmapDescriptorFactory.HUE_RED;

        /* renamed from: D */
        int f2478D = 1;

        /* renamed from: E */
        public float f2479E = -1.0f;

        /* renamed from: F */
        public float f2480F = -1.0f;

        /* renamed from: G */
        public int f2481G = 0;

        /* renamed from: H */
        public int f2482H = 0;

        /* renamed from: I */
        public int f2483I = 0;

        /* renamed from: J */
        public int f2484J = 0;

        /* renamed from: K */
        public int f2485K = 0;

        /* renamed from: L */
        public int f2486L = 0;

        /* renamed from: M */
        public int f2487M = 0;

        /* renamed from: N */
        public int f2488N = 0;

        /* renamed from: O */
        public float f2489O = 1.0f;

        /* renamed from: P */
        public float f2490P = 1.0f;

        /* renamed from: Q */
        public int f2491Q = -1;

        /* renamed from: R */
        public int f2492R = -1;

        /* renamed from: S */
        public int f2493S = -1;

        /* renamed from: T */
        public boolean f2494T = false;

        /* renamed from: U */
        public boolean f2495U = false;

        /* renamed from: V */
        boolean f2496V = true;

        /* renamed from: W */
        boolean f2497W = true;

        /* renamed from: X */
        boolean f2498X = false;

        /* renamed from: Y */
        boolean f2499Y = false;

        /* renamed from: Z */
        boolean f2500Z = false;

        /* renamed from: a */
        public int f2501a = -1;

        /* renamed from: aa */
        boolean f2502aa = false;

        /* renamed from: ab */
        boolean f2503ab = false;

        /* renamed from: ac */
        int f2504ac = -1;

        /* renamed from: ad */
        int f2505ad = -1;

        /* renamed from: ae */
        int f2506ae = -1;

        /* renamed from: af */
        int f2507af = -1;

        /* renamed from: ag */
        int f2508ag = -1;

        /* renamed from: ah */
        int f2509ah = -1;

        /* renamed from: ai */
        float f2510ai = 0.5f;

        /* renamed from: aj */
        int f2511aj;

        /* renamed from: ak */
        int f2512ak;

        /* renamed from: al */
        float f2513al;

        /* renamed from: am */
        C0766f f2514am = new C0766f();

        /* renamed from: an */
        public boolean f2515an = false;

        /* renamed from: b */
        public int f2516b = -1;

        /* renamed from: c */
        public float f2517c = -1.0f;

        /* renamed from: d */
        public int f2518d = -1;

        /* renamed from: e */
        public int f2519e = -1;

        /* renamed from: f */
        public int f2520f = -1;

        /* renamed from: g */
        public int f2521g = -1;

        /* renamed from: h */
        public int f2522h = -1;

        /* renamed from: i */
        public int f2523i = -1;

        /* renamed from: j */
        public int f2524j = -1;

        /* renamed from: k */
        public int f2525k = -1;

        /* renamed from: l */
        public int f2526l = -1;

        /* renamed from: m */
        public int f2527m = -1;

        /* renamed from: n */
        public int f2528n = 0;

        /* renamed from: o */
        public float f2529o = BitmapDescriptorFactory.HUE_RED;

        /* renamed from: p */
        public int f2530p = -1;

        /* renamed from: q */
        public int f2531q = -1;

        /* renamed from: r */
        public int f2532r = -1;

        /* renamed from: s */
        public int f2533s = -1;

        /* renamed from: t */
        public int f2534t = -1;

        /* renamed from: u */
        public int f2535u = -1;

        /* renamed from: v */
        public int f2536v = -1;

        /* renamed from: w */
        public int f2537w = -1;

        /* renamed from: x */
        public int f2538x = -1;

        /* renamed from: y */
        public int f2539y = -1;

        /* renamed from: z */
        public float f2540z = 0.5f;

        /* renamed from: androidx.constraintlayout.widget.ConstraintLayout$a$a */
        private static class C0796a {

            /* renamed from: a */
            public static final SparseIntArray f2541a = new SparseIntArray();

            static {
                f2541a.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                f2541a.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                f2541a.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                f2541a.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                f2541a.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                f2541a.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                f2541a.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                f2541a.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                f2541a.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                f2541a.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
                f2541a.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                f2541a.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                f2541a.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                f2541a.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                f2541a.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                f2541a.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                f2541a.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                f2541a.append(R.styleable.ConstraintLayout_Layout_android_orientation, 1);
                f2541a.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                f2541a.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                f2541a.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                f2541a.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                f2541a.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                f2541a.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                f2541a.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                f2541a.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                f2541a.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                f2541a.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                f2541a.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                f2541a.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                f2541a.append(R.styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                f2541a.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                f2541a.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                f2541a.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                f2541a.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                f2541a.append(R.styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                f2541a.append(R.styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                f2541a.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                f2541a.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                f2541a.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                f2541a.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                f2541a.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                f2541a.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                f2541a.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                f2541a.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                f2541a.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                f2541a.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                f2541a.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                f2541a.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                f2541a.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
            }
        }

        public C0795a(Context context, AttributeSet attributeSet) {
            int i;
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                switch (C0796a.f2541a.get(index)) {
                    case 1:
                        this.f2493S = obtainStyledAttributes.getInt(index, this.f2493S);
                        break;
                    case 2:
                        this.f2527m = obtainStyledAttributes.getResourceId(index, this.f2527m);
                        if (this.f2527m != -1) {
                            break;
                        } else {
                            this.f2527m = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 3:
                        this.f2528n = obtainStyledAttributes.getDimensionPixelSize(index, this.f2528n);
                        break;
                    case 4:
                        this.f2529o = obtainStyledAttributes.getFloat(index, this.f2529o) % 360.0f;
                        if (this.f2529o >= BitmapDescriptorFactory.HUE_RED) {
                            break;
                        } else {
                            this.f2529o = (360.0f - this.f2529o) % 360.0f;
                            break;
                        }
                    case 5:
                        this.f2501a = obtainStyledAttributes.getDimensionPixelOffset(index, this.f2501a);
                        break;
                    case 6:
                        this.f2516b = obtainStyledAttributes.getDimensionPixelOffset(index, this.f2516b);
                        break;
                    case 7:
                        this.f2517c = obtainStyledAttributes.getFloat(index, this.f2517c);
                        break;
                    case 8:
                        this.f2518d = obtainStyledAttributes.getResourceId(index, this.f2518d);
                        if (this.f2518d != -1) {
                            break;
                        } else {
                            this.f2518d = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 9:
                        this.f2519e = obtainStyledAttributes.getResourceId(index, this.f2519e);
                        if (this.f2519e != -1) {
                            break;
                        } else {
                            this.f2519e = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 10:
                        this.f2520f = obtainStyledAttributes.getResourceId(index, this.f2520f);
                        if (this.f2520f != -1) {
                            break;
                        } else {
                            this.f2520f = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 11:
                        this.f2521g = obtainStyledAttributes.getResourceId(index, this.f2521g);
                        if (this.f2521g != -1) {
                            break;
                        } else {
                            this.f2521g = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 12:
                        this.f2522h = obtainStyledAttributes.getResourceId(index, this.f2522h);
                        if (this.f2522h != -1) {
                            break;
                        } else {
                            this.f2522h = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 13:
                        this.f2523i = obtainStyledAttributes.getResourceId(index, this.f2523i);
                        if (this.f2523i != -1) {
                            break;
                        } else {
                            this.f2523i = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 14:
                        this.f2524j = obtainStyledAttributes.getResourceId(index, this.f2524j);
                        if (this.f2524j != -1) {
                            break;
                        } else {
                            this.f2524j = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 15:
                        this.f2525k = obtainStyledAttributes.getResourceId(index, this.f2525k);
                        if (this.f2525k != -1) {
                            break;
                        } else {
                            this.f2525k = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 16:
                        this.f2526l = obtainStyledAttributes.getResourceId(index, this.f2526l);
                        if (this.f2526l != -1) {
                            break;
                        } else {
                            this.f2526l = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 17:
                        this.f2530p = obtainStyledAttributes.getResourceId(index, this.f2530p);
                        if (this.f2530p != -1) {
                            break;
                        } else {
                            this.f2530p = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 18:
                        this.f2531q = obtainStyledAttributes.getResourceId(index, this.f2531q);
                        if (this.f2531q != -1) {
                            break;
                        } else {
                            this.f2531q = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 19:
                        this.f2532r = obtainStyledAttributes.getResourceId(index, this.f2532r);
                        if (this.f2532r != -1) {
                            break;
                        } else {
                            this.f2532r = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 20:
                        this.f2533s = obtainStyledAttributes.getResourceId(index, this.f2533s);
                        if (this.f2533s != -1) {
                            break;
                        } else {
                            this.f2533s = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 21:
                        this.f2534t = obtainStyledAttributes.getDimensionPixelSize(index, this.f2534t);
                        break;
                    case 22:
                        this.f2535u = obtainStyledAttributes.getDimensionPixelSize(index, this.f2535u);
                        break;
                    case 23:
                        this.f2536v = obtainStyledAttributes.getDimensionPixelSize(index, this.f2536v);
                        break;
                    case 24:
                        this.f2537w = obtainStyledAttributes.getDimensionPixelSize(index, this.f2537w);
                        break;
                    case 25:
                        this.f2538x = obtainStyledAttributes.getDimensionPixelSize(index, this.f2538x);
                        break;
                    case 26:
                        this.f2539y = obtainStyledAttributes.getDimensionPixelSize(index, this.f2539y);
                        break;
                    case 27:
                        this.f2494T = obtainStyledAttributes.getBoolean(index, this.f2494T);
                        break;
                    case 28:
                        this.f2495U = obtainStyledAttributes.getBoolean(index, this.f2495U);
                        break;
                    case 29:
                        this.f2540z = obtainStyledAttributes.getFloat(index, this.f2540z);
                        break;
                    case 30:
                        this.f2475A = obtainStyledAttributes.getFloat(index, this.f2475A);
                        break;
                    case 31:
                        this.f2483I = obtainStyledAttributes.getInt(index, 0);
                        if (this.f2483I != 1) {
                            break;
                        } else {
                            Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                            break;
                        }
                    case 32:
                        this.f2484J = obtainStyledAttributes.getInt(index, 0);
                        if (this.f2484J != 1) {
                            break;
                        } else {
                            Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                            break;
                        }
                    case 33:
                        try {
                            this.f2485K = obtainStyledAttributes.getDimensionPixelSize(index, this.f2485K);
                            break;
                        } catch (Exception unused) {
                            if (obtainStyledAttributes.getInt(index, this.f2485K) != -2) {
                                break;
                            } else {
                                this.f2485K = -2;
                                break;
                            }
                        }
                    case 34:
                        try {
                            this.f2487M = obtainStyledAttributes.getDimensionPixelSize(index, this.f2487M);
                            break;
                        } catch (Exception unused2) {
                            if (obtainStyledAttributes.getInt(index, this.f2487M) != -2) {
                                break;
                            } else {
                                this.f2487M = -2;
                                break;
                            }
                        }
                    case 35:
                        this.f2489O = Math.max(BitmapDescriptorFactory.HUE_RED, obtainStyledAttributes.getFloat(index, this.f2489O));
                        break;
                    case 36:
                        try {
                            this.f2486L = obtainStyledAttributes.getDimensionPixelSize(index, this.f2486L);
                            break;
                        } catch (Exception unused3) {
                            if (obtainStyledAttributes.getInt(index, this.f2486L) != -2) {
                                break;
                            } else {
                                this.f2486L = -2;
                                break;
                            }
                        }
                    case 37:
                        try {
                            this.f2488N = obtainStyledAttributes.getDimensionPixelSize(index, this.f2488N);
                            break;
                        } catch (Exception unused4) {
                            if (obtainStyledAttributes.getInt(index, this.f2488N) != -2) {
                                break;
                            } else {
                                this.f2488N = -2;
                                break;
                            }
                        }
                    case 38:
                        this.f2490P = Math.max(BitmapDescriptorFactory.HUE_RED, obtainStyledAttributes.getFloat(index, this.f2490P));
                        break;
                    case 44:
                        this.f2476B = obtainStyledAttributes.getString(index);
                        this.f2477C = Float.NaN;
                        this.f2478D = -1;
                        if (this.f2476B == null) {
                            break;
                        } else {
                            int length = this.f2476B.length();
                            int indexOf = this.f2476B.indexOf(44);
                            if (indexOf <= 0 || indexOf >= length - 1) {
                                i = 0;
                            } else {
                                String substring = this.f2476B.substring(0, indexOf);
                                if (substring.equalsIgnoreCase("W")) {
                                    this.f2478D = 0;
                                } else if (substring.equalsIgnoreCase("H")) {
                                    this.f2478D = 1;
                                }
                                i = indexOf + 1;
                            }
                            int indexOf2 = this.f2476B.indexOf(58);
                            if (indexOf2 >= 0 && indexOf2 < length - 1) {
                                String substring2 = this.f2476B.substring(i, indexOf2);
                                String substring3 = this.f2476B.substring(indexOf2 + 1);
                                if (substring2.length() > 0 && substring3.length() > 0) {
                                    try {
                                        float parseFloat = Float.parseFloat(substring2);
                                        float parseFloat2 = Float.parseFloat(substring3);
                                        if (parseFloat > BitmapDescriptorFactory.HUE_RED && parseFloat2 > BitmapDescriptorFactory.HUE_RED) {
                                            if (this.f2478D != 1) {
                                                this.f2477C = Math.abs(parseFloat / parseFloat2);
                                                break;
                                            } else {
                                                this.f2477C = Math.abs(parseFloat2 / parseFloat);
                                                break;
                                            }
                                        }
                                    } catch (NumberFormatException unused5) {
                                        break;
                                    }
                                }
                            } else {
                                String substring4 = this.f2476B.substring(i);
                                if (substring4.length() <= 0) {
                                    break;
                                } else {
                                    this.f2477C = Float.parseFloat(substring4);
                                    break;
                                }
                            }
                        }
                        break;
                    case 45:
                        this.f2479E = obtainStyledAttributes.getFloat(index, this.f2479E);
                        break;
                    case 46:
                        this.f2480F = obtainStyledAttributes.getFloat(index, this.f2480F);
                        break;
                    case 47:
                        this.f2481G = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 48:
                        this.f2482H = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 49:
                        this.f2491Q = obtainStyledAttributes.getDimensionPixelOffset(index, this.f2491Q);
                        break;
                    case 50:
                        this.f2492R = obtainStyledAttributes.getDimensionPixelOffset(index, this.f2492R);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
            mo3268a();
        }

        /* renamed from: a */
        public void mo3268a() {
            this.f2499Y = false;
            this.f2496V = true;
            this.f2497W = true;
            if (this.width == -2 && this.f2494T) {
                this.f2496V = false;
                this.f2483I = 1;
            }
            if (this.height == -2 && this.f2495U) {
                this.f2497W = false;
                this.f2484J = 1;
            }
            if (this.width == 0 || this.width == -1) {
                this.f2496V = false;
                if (this.width == 0 && this.f2483I == 1) {
                    this.width = -2;
                    this.f2494T = true;
                }
            }
            if (this.height == 0 || this.height == -1) {
                this.f2497W = false;
                if (this.height == 0 && this.f2484J == 1) {
                    this.height = -2;
                    this.f2495U = true;
                }
            }
            if (this.f2517c != -1.0f || this.f2501a != -1 || this.f2516b != -1) {
                this.f2499Y = true;
                this.f2496V = true;
                this.f2497W = true;
                if (!(this.f2514am instanceof C0771i)) {
                    this.f2514am = new C0771i();
                }
                ((C0771i) this.f2514am).mo3029a(this.f2493S);
            }
        }

        public C0795a(int i, int i2) {
            super(i, i2);
        }

        public C0795a(LayoutParams layoutParams) {
            super(layoutParams);
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0050  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0059  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0062  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x006a  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0072  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x0088  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0092  */
        @android.annotation.TargetApi(17)
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void resolveLayoutDirection(int r6) {
            /*
                r5 = this;
                int r0 = r5.leftMargin
                int r1 = r5.rightMargin
                super.resolveLayoutDirection(r6)
                r6 = -1
                r5.f2506ae = r6
                r5.f2507af = r6
                r5.f2504ac = r6
                r5.f2505ad = r6
                r5.f2508ag = r6
                r5.f2509ah = r6
                int r2 = r5.f2534t
                r5.f2508ag = r2
                int r2 = r5.f2536v
                r5.f2509ah = r2
                float r2 = r5.f2540z
                r5.f2510ai = r2
                int r2 = r5.f2501a
                r5.f2511aj = r2
                int r2 = r5.f2516b
                r5.f2512ak = r2
                float r2 = r5.f2517c
                r5.f2513al = r2
                int r2 = r5.getLayoutDirection()
                r3 = 0
                r4 = 1
                if (r4 != r2) goto L_0x0036
                r2 = 1
                goto L_0x0037
            L_0x0036:
                r2 = 0
            L_0x0037:
                if (r2 == 0) goto L_0x00ac
                int r2 = r5.f2530p
                if (r2 == r6) goto L_0x0043
                int r2 = r5.f2530p
                r5.f2506ae = r2
            L_0x0041:
                r3 = 1
                goto L_0x004c
            L_0x0043:
                int r2 = r5.f2531q
                if (r2 == r6) goto L_0x004c
                int r2 = r5.f2531q
                r5.f2507af = r2
                goto L_0x0041
            L_0x004c:
                int r2 = r5.f2532r
                if (r2 == r6) goto L_0x0055
                int r2 = r5.f2532r
                r5.f2505ad = r2
                r3 = 1
            L_0x0055:
                int r2 = r5.f2533s
                if (r2 == r6) goto L_0x005e
                int r2 = r5.f2533s
                r5.f2504ac = r2
                r3 = 1
            L_0x005e:
                int r2 = r5.f2538x
                if (r2 == r6) goto L_0x0066
                int r2 = r5.f2538x
                r5.f2509ah = r2
            L_0x0066:
                int r2 = r5.f2539y
                if (r2 == r6) goto L_0x006e
                int r2 = r5.f2539y
                r5.f2508ag = r2
            L_0x006e:
                r2 = 1065353216(0x3f800000, float:1.0)
                if (r3 == 0) goto L_0x0078
                float r3 = r5.f2540z
                float r3 = r2 - r3
                r5.f2510ai = r3
            L_0x0078:
                boolean r3 = r5.f2499Y
                if (r3 == 0) goto L_0x00dc
                int r3 = r5.f2493S
                if (r3 != r4) goto L_0x00dc
                float r3 = r5.f2517c
                r4 = -1082130432(0xffffffffbf800000, float:-1.0)
                int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
                if (r3 == 0) goto L_0x0092
                float r3 = r5.f2517c
                float r2 = r2 - r3
                r5.f2513al = r2
                r5.f2511aj = r6
                r5.f2512ak = r6
                goto L_0x00dc
            L_0x0092:
                int r2 = r5.f2501a
                if (r2 == r6) goto L_0x009f
                int r2 = r5.f2501a
                r5.f2512ak = r2
                r5.f2511aj = r6
                r5.f2513al = r4
                goto L_0x00dc
            L_0x009f:
                int r2 = r5.f2516b
                if (r2 == r6) goto L_0x00dc
                int r2 = r5.f2516b
                r5.f2511aj = r2
                r5.f2512ak = r6
                r5.f2513al = r4
                goto L_0x00dc
            L_0x00ac:
                int r2 = r5.f2530p
                if (r2 == r6) goto L_0x00b4
                int r2 = r5.f2530p
                r5.f2505ad = r2
            L_0x00b4:
                int r2 = r5.f2531q
                if (r2 == r6) goto L_0x00bc
                int r2 = r5.f2531q
                r5.f2504ac = r2
            L_0x00bc:
                int r2 = r5.f2532r
                if (r2 == r6) goto L_0x00c4
                int r2 = r5.f2532r
                r5.f2506ae = r2
            L_0x00c4:
                int r2 = r5.f2533s
                if (r2 == r6) goto L_0x00cc
                int r2 = r5.f2533s
                r5.f2507af = r2
            L_0x00cc:
                int r2 = r5.f2538x
                if (r2 == r6) goto L_0x00d4
                int r2 = r5.f2538x
                r5.f2508ag = r2
            L_0x00d4:
                int r2 = r5.f2539y
                if (r2 == r6) goto L_0x00dc
                int r2 = r5.f2539y
                r5.f2509ah = r2
            L_0x00dc:
                int r2 = r5.f2532r
                if (r2 != r6) goto L_0x012e
                int r2 = r5.f2533s
                if (r2 != r6) goto L_0x012e
                int r2 = r5.f2531q
                if (r2 != r6) goto L_0x012e
                int r2 = r5.f2530p
                if (r2 != r6) goto L_0x012e
                int r2 = r5.f2520f
                if (r2 == r6) goto L_0x00fd
                int r2 = r5.f2520f
                r5.f2506ae = r2
                int r2 = r5.rightMargin
                if (r2 > 0) goto L_0x010d
                if (r1 <= 0) goto L_0x010d
                r5.rightMargin = r1
                goto L_0x010d
            L_0x00fd:
                int r2 = r5.f2521g
                if (r2 == r6) goto L_0x010d
                int r2 = r5.f2521g
                r5.f2507af = r2
                int r2 = r5.rightMargin
                if (r2 > 0) goto L_0x010d
                if (r1 <= 0) goto L_0x010d
                r5.rightMargin = r1
            L_0x010d:
                int r1 = r5.f2518d
                if (r1 == r6) goto L_0x011e
                int r6 = r5.f2518d
                r5.f2504ac = r6
                int r6 = r5.leftMargin
                if (r6 > 0) goto L_0x012e
                if (r0 <= 0) goto L_0x012e
                r5.leftMargin = r0
                goto L_0x012e
            L_0x011e:
                int r1 = r5.f2519e
                if (r1 == r6) goto L_0x012e
                int r6 = r5.f2519e
                r5.f2505ad = r6
                int r6 = r5.leftMargin
                if (r6 > 0) goto L_0x012e
                if (r0 <= 0) goto L_0x012e
                r5.leftMargin = r0
            L_0x012e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.C0795a.resolveLayoutDirection(int):void");
        }
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* renamed from: a */
    public Object mo3237a(int i, Object obj) {
        if (i == 0 && (obj instanceof String)) {
            String str = (String) obj;
            if (this.f2469s != null && this.f2469s.containsKey(str)) {
                return this.f2469s.get(str);
            }
        }
        return null;
    }

    public ConstraintLayout(Context context) {
        super(context);
        m2987b((AttributeSet) null);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m2987b(attributeSet);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2987b(attributeSet);
    }

    public void setId(int i) {
        this.f2451a.remove(getId());
        super.setId(i);
        this.f2451a.put(getId(), this);
    }

    /* renamed from: b */
    private void m2987b(AttributeSet attributeSet) {
        this.f2452b.mo3073a((Object) this);
        this.f2451a.put(getId(), this);
        this.f2467q = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.ConstraintLayout_Layout_android_minWidth) {
                    this.f2461k = obtainStyledAttributes.getDimensionPixelOffset(index, this.f2461k);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_minHeight) {
                    this.f2462l = obtainStyledAttributes.getDimensionPixelOffset(index, this.f2462l);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_maxWidth) {
                    this.f2463m = obtainStyledAttributes.getDimensionPixelOffset(index, this.f2463m);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_maxHeight) {
                    this.f2464n = obtainStyledAttributes.getDimensionPixelOffset(index, this.f2464n);
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.f2466p = obtainStyledAttributes.getInt(index, this.f2466p);
                } else if (index == R.styleable.ConstraintLayout_Layout_layoutDescription) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            mo3238a(resourceId);
                        } catch (NotFoundException unused) {
                            this.f2453c = null;
                        }
                    }
                } else if (index == R.styleable.ConstraintLayout_Layout_constraintSet) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        this.f2467q = new C0809e();
                        this.f2467q.mo3296b(getContext(), resourceId2);
                    } catch (NotFoundException unused2) {
                        this.f2467q = null;
                    }
                    this.f2468r = resourceId2;
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f2452b.mo3029a(this.f2466p);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3238a(int i) {
        this.f2453c = new C0806d(getContext(), this, i);
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (VERSION.SDK_INT < 14) {
            onViewAdded(view);
        }
    }

    public void removeView(View view) {
        super.removeView(view);
        if (VERSION.SDK_INT < 14) {
            onViewRemoved(view);
        }
    }

    public void onViewAdded(View view) {
        if (VERSION.SDK_INT >= 14) {
            super.onViewAdded(view);
        }
        C0766f a = mo3234a(view);
        if ((view instanceof C0814h) && !(a instanceof C0771i)) {
            C0795a aVar = (C0795a) view.getLayoutParams();
            aVar.f2514am = new C0771i();
            aVar.f2499Y = true;
            ((C0771i) aVar.f2514am).mo3029a(aVar.f2493S);
        }
        if (view instanceof C0805c) {
            C0805c cVar = (C0805c) view;
            cVar.mo3277b();
            ((C0795a) view.getLayoutParams()).f2500Z = true;
            if (!this.f2459i.contains(cVar)) {
                this.f2459i.add(cVar);
            }
        }
        this.f2451a.put(view.getId(), view);
        this.f2465o = true;
    }

    public void onViewRemoved(View view) {
        if (VERSION.SDK_INT >= 14) {
            super.onViewRemoved(view);
        }
        this.f2451a.remove(view.getId());
        C0766f a = mo3234a(view);
        this.f2452b.mo3175c(a);
        this.f2459i.remove(view);
        this.f2460j.remove(a);
        this.f2465o = true;
    }

    public void setMinWidth(int i) {
        if (i != this.f2461k) {
            this.f2461k = i;
            requestLayout();
        }
    }

    public void setMinHeight(int i) {
        if (i != this.f2462l) {
            this.f2462l = i;
            requestLayout();
        }
    }

    public int getMinWidth() {
        return this.f2461k;
    }

    public int getMinHeight() {
        return this.f2462l;
    }

    public void setMaxWidth(int i) {
        if (i != this.f2463m) {
            this.f2463m = i;
            requestLayout();
        }
    }

    public void setMaxHeight(int i) {
        if (i != this.f2464n) {
            this.f2464n = i;
            requestLayout();
        }
    }

    public int getMaxWidth() {
        return this.f2463m;
    }

    public int getMaxHeight() {
        return this.f2464n;
    }

    /* renamed from: b */
    private void m2985b() {
        int childCount = getChildCount();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            } else if (getChildAt(i).isLayoutRequested()) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            this.f2460j.clear();
            m2988c();
        }
    }

    /* renamed from: c */
    private void m2988c() {
        int i;
        int i2;
        int i3;
        float f;
        int i4;
        int i5;
        boolean isInEditMode = isInEditMode();
        int childCount = getChildCount();
        boolean z = false;
        for (int i6 = 0; i6 < childCount; i6++) {
            C0766f a = mo3234a(getChildAt(i6));
            if (a != null) {
                a.mo3095g();
            }
        }
        if (this.f2468r != -1) {
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = getChildAt(i7);
                if (childAt.getId() == this.f2468r && (childAt instanceof C0811f)) {
                    this.f2467q = ((C0811f) childAt).getConstraintSet();
                }
            }
        }
        if (this.f2467q != null) {
            this.f2467q.mo3298c(this);
        }
        this.f2452b.mo3173U();
        int size = this.f2459i.size();
        if (size > 0) {
            for (int i8 = 0; i8 < size; i8++) {
                ((C0805c) this.f2459i.get(i8)).mo3276a(this);
            }
        }
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt2 = getChildAt(i9);
            if (childAt2 instanceof C0815i) {
                ((C0815i) childAt2).mo3317a(this);
            }
        }
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt3 = getChildAt(i10);
            C0766f a2 = mo3234a(childAt3);
            if (a2 != null) {
                C0795a aVar = (C0795a) childAt3.getLayoutParams();
                aVar.mo3268a();
                if (aVar.f2515an) {
                    aVar.f2515an = z;
                }
                a2.mo3091e(childAt3.getVisibility());
                if (aVar.f2502aa) {
                    a2.mo3091e(8);
                }
                a2.mo3073a((Object) childAt3);
                this.f2452b.mo3174b(a2);
                if (!aVar.f2497W || !aVar.f2496V) {
                    this.f2460j.add(a2);
                }
                if (aVar.f2499Y) {
                    C0771i iVar = (C0771i) a2;
                    int i11 = aVar.f2511aj;
                    int i12 = aVar.f2512ak;
                    float f2 = aVar.f2513al;
                    if (VERSION.SDK_INT < 17) {
                        i11 = aVar.f2501a;
                        i12 = aVar.f2516b;
                        f2 = aVar.f2517c;
                    }
                    if (f2 != -1.0f) {
                        iVar.mo3143e(f2);
                    } else if (i11 != -1) {
                        iVar.mo3144q(i11);
                    } else if (i12 != -1) {
                        iVar.mo3145r(i12);
                    }
                } else if (aVar.f2518d != -1 || aVar.f2519e != -1 || aVar.f2520f != -1 || aVar.f2521g != -1 || aVar.f2531q != -1 || aVar.f2530p != -1 || aVar.f2532r != -1 || aVar.f2533s != -1 || aVar.f2522h != -1 || aVar.f2523i != -1 || aVar.f2524j != -1 || aVar.f2525k != -1 || aVar.f2526l != -1 || aVar.f2491Q != -1 || aVar.f2492R != -1 || aVar.f2527m != -1 || aVar.width == -1 || aVar.height == -1) {
                    int i13 = aVar.f2504ac;
                    int i14 = aVar.f2505ad;
                    int i15 = aVar.f2506ae;
                    int i16 = aVar.f2507af;
                    int i17 = aVar.f2508ag;
                    int i18 = aVar.f2509ah;
                    float f3 = aVar.f2510ai;
                    if (VERSION.SDK_INT < 17) {
                        int i19 = aVar.f2518d;
                        int i20 = aVar.f2519e;
                        i15 = aVar.f2520f;
                        i16 = aVar.f2521g;
                        int i21 = aVar.f2534t;
                        int i22 = aVar.f2536v;
                        f3 = aVar.f2540z;
                        if (i19 == -1 && i20 == -1) {
                            if (aVar.f2531q != -1) {
                                i19 = aVar.f2531q;
                            } else if (aVar.f2530p != -1) {
                                i20 = aVar.f2530p;
                            }
                        }
                        int i23 = i20;
                        i13 = i19;
                        i3 = i23;
                        if (i15 == -1 && i16 == -1) {
                            if (aVar.f2532r != -1) {
                                i15 = aVar.f2532r;
                            } else if (aVar.f2533s != -1) {
                                i16 = aVar.f2533s;
                            }
                        }
                        i2 = i21;
                        i = i22;
                    } else {
                        i3 = i14;
                        i = i18;
                        i2 = i17;
                    }
                    int i24 = i16;
                    float f4 = f3;
                    int i25 = i15;
                    if (aVar.f2527m != -1) {
                        C0766f b = m2984b(aVar.f2527m);
                        if (b != null) {
                            a2.mo3071a(b, aVar.f2529o, aVar.f2528n);
                        }
                    } else {
                        if (i13 != -1) {
                            C0766f b2 = m2984b(i13);
                            if (b2 != null) {
                                C0765c cVar = C0765c.LEFT;
                                f = f4;
                                C0765c cVar2 = C0765c.LEFT;
                                i5 = i24;
                                a2.mo3069a(cVar, b2, cVar2, aVar.leftMargin, i2);
                            } else {
                                f = f4;
                                i5 = i24;
                            }
                            i4 = i5;
                        } else {
                            f = f4;
                            i4 = i24;
                            if (i3 != -1) {
                                C0766f b3 = m2984b(i3);
                                if (b3 != null) {
                                    a2.mo3069a(C0765c.LEFT, b3, C0765c.RIGHT, aVar.leftMargin, i2);
                                }
                            }
                        }
                        if (i25 != -1) {
                            C0766f b4 = m2984b(i25);
                            if (b4 != null) {
                                a2.mo3069a(C0765c.RIGHT, b4, C0765c.LEFT, aVar.rightMargin, i);
                            }
                        } else if (i4 != -1) {
                            C0766f b5 = m2984b(i4);
                            if (b5 != null) {
                                a2.mo3069a(C0765c.RIGHT, b5, C0765c.RIGHT, aVar.rightMargin, i);
                            }
                        }
                        if (aVar.f2522h != -1) {
                            C0766f b6 = m2984b(aVar.f2522h);
                            if (b6 != null) {
                                a2.mo3069a(C0765c.TOP, b6, C0765c.TOP, aVar.topMargin, aVar.f2535u);
                            }
                        } else if (aVar.f2523i != -1) {
                            C0766f b7 = m2984b(aVar.f2523i);
                            if (b7 != null) {
                                a2.mo3069a(C0765c.TOP, b7, C0765c.BOTTOM, aVar.topMargin, aVar.f2535u);
                            }
                        }
                        if (aVar.f2524j != -1) {
                            C0766f b8 = m2984b(aVar.f2524j);
                            if (b8 != null) {
                                a2.mo3069a(C0765c.BOTTOM, b8, C0765c.TOP, aVar.bottomMargin, aVar.f2537w);
                            }
                        } else if (aVar.f2525k != -1) {
                            C0766f b9 = m2984b(aVar.f2525k);
                            if (b9 != null) {
                                a2.mo3069a(C0765c.BOTTOM, b9, C0765c.BOTTOM, aVar.bottomMargin, aVar.f2537w);
                            }
                        }
                        if (aVar.f2526l != -1) {
                            View view = (View) this.f2451a.get(aVar.f2526l);
                            C0766f b10 = m2984b(aVar.f2526l);
                            if (!(b10 == null || view == null || !(view.getLayoutParams() instanceof C0795a))) {
                                C0795a aVar2 = (C0795a) view.getLayoutParams();
                                aVar.f2498X = true;
                                aVar2.f2498X = true;
                                a2.mo3063a(C0765c.BASELINE).mo3041a(b10.mo3063a(C0765c.BASELINE), 0, -1, C0764b.STRONG, 0, true);
                                a2.mo3063a(C0765c.TOP).mo3050i();
                                a2.mo3063a(C0765c.BOTTOM).mo3050i();
                            }
                        }
                        float f5 = f;
                        if (f5 >= BitmapDescriptorFactory.HUE_RED && f5 != 0.5f) {
                            a2.mo3064a(f5);
                        }
                        if (aVar.f2475A >= BitmapDescriptorFactory.HUE_RED && aVar.f2475A != 0.5f) {
                            a2.mo3077b(aVar.f2475A);
                        }
                    }
                    if (isInEditMode && !(aVar.f2491Q == -1 && aVar.f2492R == -1)) {
                        a2.mo3065a(aVar.f2491Q, aVar.f2492R);
                    }
                    if (aVar.f2496V) {
                        a2.mo3070a(C0768a.FIXED);
                        a2.mo3098h(aVar.width);
                    } else if (aVar.width == -1) {
                        a2.mo3070a(C0768a.MATCH_PARENT);
                        a2.mo3063a(C0765c.LEFT).f2200d = aVar.leftMargin;
                        a2.mo3063a(C0765c.RIGHT).f2200d = aVar.rightMargin;
                    } else {
                        a2.mo3070a(C0768a.MATCH_CONSTRAINT);
                        a2.mo3098h(0);
                    }
                    if (aVar.f2497W) {
                        z = false;
                        a2.mo3080b(C0768a.FIXED);
                        a2.mo3100i(aVar.height);
                    } else if (aVar.height == -1) {
                        a2.mo3080b(C0768a.MATCH_PARENT);
                        a2.mo3063a(C0765c.TOP).f2200d = aVar.topMargin;
                        a2.mo3063a(C0765c.BOTTOM).f2200d = aVar.bottomMargin;
                        z = false;
                    } else {
                        a2.mo3080b(C0768a.MATCH_CONSTRAINT);
                        z = false;
                        a2.mo3100i(0);
                    }
                    if (aVar.f2476B != null) {
                        a2.mo3074a(aVar.f2476B);
                    }
                    a2.mo3083c(aVar.f2479E);
                    a2.mo3088d(aVar.f2480F);
                    a2.mo3112o(aVar.f2481G);
                    a2.mo3114p(aVar.f2482H);
                    a2.mo3067a(aVar.f2483I, aVar.f2485K, aVar.f2487M, aVar.f2489O);
                    a2.mo3079b(aVar.f2484J, aVar.f2486L, aVar.f2488N, aVar.f2490P);
                }
            }
        }
    }

    /* renamed from: b */
    private final C0766f m2984b(int i) {
        C0766f fVar;
        if (i == 0) {
            return this.f2452b;
        }
        View view = (View) this.f2451a.get(i);
        if (view == this) {
            return this.f2452b;
        }
        if (view == null) {
            fVar = null;
        } else {
            fVar = ((C0795a) view.getLayoutParams()).f2514am;
        }
        return fVar;
    }

    /* renamed from: a */
    public final C0766f mo3234a(View view) {
        C0766f fVar;
        if (view == this) {
            return this.f2452b;
        }
        if (view == null) {
            fVar = null;
        } else {
            fVar = ((C0795a) view.getLayoutParams()).f2514am;
        }
        return fVar;
    }

    /* renamed from: a */
    private void m2983a(int i, int i2) {
        boolean z;
        boolean z2;
        int i3;
        int i4;
        int i5 = i;
        int i6 = i2;
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int childCount = getChildCount();
        int i7 = 0;
        int i8 = 0;
        while (i8 < childCount) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                C0795a aVar = (C0795a) childAt.getLayoutParams();
                C0766f fVar = aVar.f2514am;
                if (!aVar.f2499Y && (!aVar.f2500Z || aVar.f2503ab)) {
                    fVar.mo3091e(childAt.getVisibility());
                    if (aVar.f2503ab) {
                        fVar.mo3091e(i7);
                    }
                    int i9 = aVar.width;
                    int i10 = aVar.height;
                    if (aVar.f2496V || aVar.f2497W || (!aVar.f2496V && aVar.f2483I == 1) || aVar.width == -1 || (!aVar.f2497W && (aVar.f2484J == 1 || aVar.height == -1))) {
                        if (i9 == 0) {
                            i3 = getChildMeasureSpec(i5, paddingLeft, -2);
                            z2 = true;
                        } else if (i9 == -1) {
                            i3 = getChildMeasureSpec(i5, paddingLeft, -1);
                            z2 = false;
                        } else {
                            z2 = i9 == -2;
                            i3 = getChildMeasureSpec(i5, paddingLeft, i9);
                        }
                        if (i10 == 0) {
                            i4 = getChildMeasureSpec(i6, paddingTop, -2);
                            z = true;
                        } else if (i10 == -1) {
                            i4 = getChildMeasureSpec(i6, paddingTop, -1);
                            z = false;
                        } else {
                            z = i10 == -2;
                            i4 = getChildMeasureSpec(i6, paddingTop, i10);
                        }
                        childAt.measure(i3, i4);
                        if (this.f2473w != null) {
                            this.f2473w.f2402a++;
                        }
                        fVar.mo3082b(i9 == -2);
                        fVar.mo3087c(i10 == -2);
                        i9 = childAt.getMeasuredWidth();
                        i10 = childAt.getMeasuredHeight();
                    } else {
                        z2 = false;
                        z = false;
                    }
                    fVar.mo3098h(i9);
                    fVar.mo3100i(i10);
                    if (z2) {
                        fVar.mo3106l(i9);
                    }
                    if (z) {
                        fVar.mo3108m(i10);
                    }
                    if (aVar.f2498X) {
                        int baseline = childAt.getBaseline();
                        if (baseline != -1) {
                            fVar.mo3110n(baseline);
                        }
                    }
                }
            }
            i8++;
            i7 = 0;
        }
    }

    /* renamed from: d */
    private void m2990d() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof C0815i) {
                ((C0815i) childAt).mo3318b(this);
            }
        }
        int size = this.f2459i.size();
        if (size > 0) {
            for (int i2 = 0; i2 < size; i2++) {
                ((C0805c) this.f2459i.get(i2)).mo3279c(this);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:110:0x021a  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0258  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0277  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0282  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0287  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0289  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x028f  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0291  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x02a5  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x02aa  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x02af  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x02b7  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x02c0  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x02ca  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x02d6  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x02e1  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m2986b(int r25, int r26) {
        /*
            r24 = this;
            r0 = r24
            r1 = r25
            r2 = r26
            int r3 = r24.getPaddingTop()
            int r4 = r24.getPaddingBottom()
            int r3 = r3 + r4
            int r4 = r24.getPaddingLeft()
            int r5 = r24.getPaddingRight()
            int r4 = r4 + r5
            int r5 = r24.getChildCount()
            r7 = 0
        L_0x001d:
            r8 = 1
            r10 = 8
            r12 = -2
            if (r7 >= r5) goto L_0x00e3
            android.view.View r14 = r0.getChildAt(r7)
            int r15 = r14.getVisibility()
            if (r15 != r10) goto L_0x0032
        L_0x002e:
            r18 = r3
            goto L_0x00db
        L_0x0032:
            android.view.ViewGroup$LayoutParams r10 = r14.getLayoutParams()
            androidx.constraintlayout.widget.ConstraintLayout$a r10 = (androidx.constraintlayout.widget.ConstraintLayout.C0795a) r10
            androidx.constraintlayout.b.a.f r15 = r10.f2514am
            boolean r6 = r10.f2499Y
            if (r6 != 0) goto L_0x002e
            boolean r6 = r10.f2500Z
            if (r6 == 0) goto L_0x0043
            goto L_0x002e
        L_0x0043:
            int r6 = r14.getVisibility()
            r15.mo3091e(r6)
            int r6 = r10.width
            int r13 = r10.height
            if (r6 == 0) goto L_0x00cb
            if (r13 != 0) goto L_0x0054
            goto L_0x00cb
        L_0x0054:
            if (r6 != r12) goto L_0x0059
            r16 = 1
            goto L_0x005b
        L_0x0059:
            r16 = 0
        L_0x005b:
            int r11 = getChildMeasureSpec(r1, r4, r6)
            if (r13 != r12) goto L_0x0064
            r17 = 1
            goto L_0x0066
        L_0x0064:
            r17 = 0
        L_0x0066:
            int r12 = getChildMeasureSpec(r2, r3, r13)
            r14.measure(r11, r12)
            androidx.constraintlayout.b.f r11 = r0.f2473w
            if (r11 == 0) goto L_0x007b
            androidx.constraintlayout.b.f r11 = r0.f2473w
            r18 = r3
            long r2 = r11.f2402a
            long r2 = r2 + r8
            r11.f2402a = r2
            goto L_0x007d
        L_0x007b:
            r18 = r3
        L_0x007d:
            r2 = -2
            if (r6 != r2) goto L_0x0082
            r3 = 1
            goto L_0x0083
        L_0x0082:
            r3 = 0
        L_0x0083:
            r15.mo3082b(r3)
            if (r13 != r2) goto L_0x008a
            r2 = 1
            goto L_0x008b
        L_0x008a:
            r2 = 0
        L_0x008b:
            r15.mo3087c(r2)
            int r2 = r14.getMeasuredWidth()
            int r3 = r14.getMeasuredHeight()
            r15.mo3098h(r2)
            r15.mo3100i(r3)
            if (r16 == 0) goto L_0x00a1
            r15.mo3106l(r2)
        L_0x00a1:
            if (r17 == 0) goto L_0x00a6
            r15.mo3108m(r3)
        L_0x00a6:
            boolean r6 = r10.f2498X
            if (r6 == 0) goto L_0x00b4
            int r6 = r14.getBaseline()
            r8 = -1
            if (r6 == r8) goto L_0x00b4
            r15.mo3110n(r6)
        L_0x00b4:
            boolean r6 = r10.f2496V
            if (r6 == 0) goto L_0x00db
            boolean r6 = r10.f2497W
            if (r6 == 0) goto L_0x00db
            androidx.constraintlayout.b.a.o r6 = r15.mo3099i()
            r6.mo3162a(r2)
            androidx.constraintlayout.b.a.o r2 = r15.mo3101j()
            r2.mo3162a(r3)
            goto L_0x00db
        L_0x00cb:
            r18 = r3
            androidx.constraintlayout.b.a.o r2 = r15.mo3099i()
            r2.mo3165e()
            androidx.constraintlayout.b.a.o r2 = r15.mo3101j()
            r2.mo3165e()
        L_0x00db:
            int r7 = r7 + 1
            r3 = r18
            r2 = r26
            goto L_0x001d
        L_0x00e3:
            r18 = r3
            androidx.constraintlayout.b.a.g r2 = r0.f2452b
            r2.mo3131P()
            r2 = 0
        L_0x00eb:
            if (r2 >= r5) goto L_0x02ee
            android.view.View r3 = r0.getChildAt(r2)
            int r6 = r3.getVisibility()
            if (r6 != r10) goto L_0x0105
        L_0x00f7:
            r22 = r2
            r21 = r5
            r19 = r8
            r9 = r18
            r3 = -1
            r8 = r26
            r13 = -2
            goto L_0x02e2
        L_0x0105:
            android.view.ViewGroup$LayoutParams r6 = r3.getLayoutParams()
            androidx.constraintlayout.widget.ConstraintLayout$a r6 = (androidx.constraintlayout.widget.ConstraintLayout.C0795a) r6
            androidx.constraintlayout.b.a.f r7 = r6.f2514am
            boolean r11 = r6.f2499Y
            if (r11 != 0) goto L_0x00f7
            boolean r11 = r6.f2500Z
            if (r11 == 0) goto L_0x0116
            goto L_0x00f7
        L_0x0116:
            int r11 = r3.getVisibility()
            r7.mo3091e(r11)
            int r11 = r6.width
            int r12 = r6.height
            if (r11 == 0) goto L_0x0126
            if (r12 == 0) goto L_0x0126
            goto L_0x00f7
        L_0x0126:
            androidx.constraintlayout.b.a.e$c r13 = androidx.constraintlayout.p060b.p061a.C0761e.C0765c.LEFT
            androidx.constraintlayout.b.a.e r13 = r7.mo3063a(r13)
            androidx.constraintlayout.b.a.n r13 = r13.mo3038a()
            androidx.constraintlayout.b.a.e$c r14 = androidx.constraintlayout.p060b.p061a.C0761e.C0765c.RIGHT
            androidx.constraintlayout.b.a.e r14 = r7.mo3063a(r14)
            androidx.constraintlayout.b.a.n r14 = r14.mo3038a()
            androidx.constraintlayout.b.a.e$c r15 = androidx.constraintlayout.p060b.p061a.C0761e.C0765c.LEFT
            androidx.constraintlayout.b.a.e r15 = r7.mo3063a(r15)
            androidx.constraintlayout.b.a.e r15 = r15.mo3048g()
            if (r15 == 0) goto L_0x0154
            androidx.constraintlayout.b.a.e$c r15 = androidx.constraintlayout.p060b.p061a.C0761e.C0765c.RIGHT
            androidx.constraintlayout.b.a.e r15 = r7.mo3063a(r15)
            androidx.constraintlayout.b.a.e r15 = r15.mo3048g()
            if (r15 == 0) goto L_0x0154
            r15 = 1
            goto L_0x0155
        L_0x0154:
            r15 = 0
        L_0x0155:
            androidx.constraintlayout.b.a.e$c r10 = androidx.constraintlayout.p060b.p061a.C0761e.C0765c.TOP
            androidx.constraintlayout.b.a.e r10 = r7.mo3063a(r10)
            androidx.constraintlayout.b.a.n r10 = r10.mo3038a()
            androidx.constraintlayout.b.a.e$c r8 = androidx.constraintlayout.p060b.p061a.C0761e.C0765c.BOTTOM
            androidx.constraintlayout.b.a.e r8 = r7.mo3063a(r8)
            androidx.constraintlayout.b.a.n r8 = r8.mo3038a()
            androidx.constraintlayout.b.a.e$c r9 = androidx.constraintlayout.p060b.p061a.C0761e.C0765c.TOP
            androidx.constraintlayout.b.a.e r9 = r7.mo3063a(r9)
            androidx.constraintlayout.b.a.e r9 = r9.mo3048g()
            if (r9 == 0) goto L_0x0183
            androidx.constraintlayout.b.a.e$c r9 = androidx.constraintlayout.p060b.p061a.C0761e.C0765c.BOTTOM
            androidx.constraintlayout.b.a.e r9 = r7.mo3063a(r9)
            androidx.constraintlayout.b.a.e r9 = r9.mo3048g()
            if (r9 == 0) goto L_0x0183
            r9 = 1
            goto L_0x0184
        L_0x0183:
            r9 = 0
        L_0x0184:
            if (r11 != 0) goto L_0x019a
            if (r12 != 0) goto L_0x019a
            if (r15 == 0) goto L_0x019a
            if (r9 == 0) goto L_0x019a
            r22 = r2
            r21 = r5
            r9 = r18
            r3 = -1
            r8 = r26
            r13 = -2
            r19 = 1
            goto L_0x02e2
        L_0x019a:
            r21 = r5
            androidx.constraintlayout.b.a.g r5 = r0.f2452b
            androidx.constraintlayout.b.a.f$a r5 = r5.mo3059G()
            r22 = r2
            androidx.constraintlayout.b.a.f$a r2 = androidx.constraintlayout.p060b.p061a.C0766f.C0768a.WRAP_CONTENT
            if (r5 == r2) goto L_0x01aa
            r2 = 1
            goto L_0x01ab
        L_0x01aa:
            r2 = 0
        L_0x01ab:
            androidx.constraintlayout.b.a.g r5 = r0.f2452b
            androidx.constraintlayout.b.a.f$a r5 = r5.mo3060H()
            r23 = r6
            androidx.constraintlayout.b.a.f$a r6 = androidx.constraintlayout.p060b.p061a.C0766f.C0768a.WRAP_CONTENT
            if (r5 == r6) goto L_0x01b9
            r6 = 1
            goto L_0x01ba
        L_0x01b9:
            r6 = 0
        L_0x01ba:
            if (r2 != 0) goto L_0x01c3
            androidx.constraintlayout.b.a.o r5 = r7.mo3099i()
            r5.mo3165e()
        L_0x01c3:
            if (r6 != 0) goto L_0x01cc
            androidx.constraintlayout.b.a.o r5 = r7.mo3101j()
            r5.mo3165e()
        L_0x01cc:
            if (r11 != 0) goto L_0x0204
            if (r2 == 0) goto L_0x01fb
            boolean r5 = r7.mo3092e()
            if (r5 == 0) goto L_0x01fb
            if (r15 == 0) goto L_0x01fb
            boolean r5 = r13.mo3167g()
            if (r5 == 0) goto L_0x01fb
            boolean r5 = r14.mo3167g()
            if (r5 == 0) goto L_0x01fb
            float r5 = r14.mo3160d()
            float r11 = r13.mo3160d()
            float r5 = r5 - r11
            int r11 = (int) r5
            androidx.constraintlayout.b.a.o r5 = r7.mo3099i()
            r5.mo3162a(r11)
            int r5 = getChildMeasureSpec(r1, r4, r11)
            r13 = r5
            goto L_0x020d
        L_0x01fb:
            r5 = -2
            int r2 = getChildMeasureSpec(r1, r4, r5)
            r13 = r2
            r2 = 0
            r5 = 1
            goto L_0x0218
        L_0x0204:
            r5 = -2
            r13 = -1
            if (r11 != r13) goto L_0x020f
            int r14 = getChildMeasureSpec(r1, r4, r13)
            r13 = r14
        L_0x020d:
            r5 = 0
            goto L_0x0218
        L_0x020f:
            if (r11 != r5) goto L_0x0213
            r5 = 1
            goto L_0x0214
        L_0x0213:
            r5 = 0
        L_0x0214:
            int r13 = getChildMeasureSpec(r1, r4, r11)
        L_0x0218:
            if (r12 != 0) goto L_0x0258
            if (r6 == 0) goto L_0x024b
            boolean r14 = r7.mo3094f()
            if (r14 == 0) goto L_0x024b
            if (r9 == 0) goto L_0x024b
            boolean r9 = r10.mo3167g()
            if (r9 == 0) goto L_0x024b
            boolean r9 = r8.mo3167g()
            if (r9 == 0) goto L_0x024b
            float r8 = r8.mo3160d()
            float r9 = r10.mo3160d()
            float r8 = r8 - r9
            int r12 = (int) r8
            androidx.constraintlayout.b.a.o r8 = r7.mo3101j()
            r8.mo3162a(r12)
            r9 = r18
            r8 = r26
            int r10 = getChildMeasureSpec(r8, r9, r12)
            r14 = r10
            goto L_0x0265
        L_0x024b:
            r9 = r18
            r8 = r26
            r10 = -2
            int r6 = getChildMeasureSpec(r8, r9, r10)
            r14 = r6
            r6 = 0
            r10 = 1
            goto L_0x0270
        L_0x0258:
            r9 = r18
            r8 = r26
            r10 = -2
            r14 = -1
            if (r12 != r14) goto L_0x0267
            int r15 = getChildMeasureSpec(r8, r9, r14)
            r14 = r15
        L_0x0265:
            r10 = 0
            goto L_0x0270
        L_0x0267:
            if (r12 != r10) goto L_0x026b
            r10 = 1
            goto L_0x026c
        L_0x026b:
            r10 = 0
        L_0x026c:
            int r14 = getChildMeasureSpec(r8, r9, r12)
        L_0x0270:
            r3.measure(r13, r14)
            androidx.constraintlayout.b.f r13 = r0.f2473w
            if (r13 == 0) goto L_0x0282
            androidx.constraintlayout.b.f r13 = r0.f2473w
            long r14 = r13.f2402a
            r19 = 1
            long r14 = r14 + r19
            r13.f2402a = r14
            goto L_0x0284
        L_0x0282:
            r19 = 1
        L_0x0284:
            r13 = -2
            if (r11 != r13) goto L_0x0289
            r11 = 1
            goto L_0x028a
        L_0x0289:
            r11 = 0
        L_0x028a:
            r7.mo3082b(r11)
            if (r12 != r13) goto L_0x0291
            r11 = 1
            goto L_0x0292
        L_0x0291:
            r11 = 0
        L_0x0292:
            r7.mo3087c(r11)
            int r11 = r3.getMeasuredWidth()
            int r12 = r3.getMeasuredHeight()
            r7.mo3098h(r11)
            r7.mo3100i(r12)
            if (r5 == 0) goto L_0x02a8
            r7.mo3106l(r11)
        L_0x02a8:
            if (r10 == 0) goto L_0x02ad
            r7.mo3108m(r12)
        L_0x02ad:
            if (r2 == 0) goto L_0x02b7
            androidx.constraintlayout.b.a.o r2 = r7.mo3099i()
            r2.mo3162a(r11)
            goto L_0x02be
        L_0x02b7:
            androidx.constraintlayout.b.a.o r2 = r7.mo3099i()
            r2.mo3163c()
        L_0x02be:
            if (r6 == 0) goto L_0x02ca
            androidx.constraintlayout.b.a.o r2 = r7.mo3101j()
            r2.mo3162a(r12)
        L_0x02c7:
            r6 = r23
            goto L_0x02d2
        L_0x02ca:
            androidx.constraintlayout.b.a.o r2 = r7.mo3101j()
            r2.mo3163c()
            goto L_0x02c7
        L_0x02d2:
            boolean r2 = r6.f2498X
            if (r2 == 0) goto L_0x02e1
            int r2 = r3.getBaseline()
            r3 = -1
            if (r2 == r3) goto L_0x02e2
            r7.mo3110n(r2)
            goto L_0x02e2
        L_0x02e1:
            r3 = -1
        L_0x02e2:
            int r2 = r22 + 1
            r18 = r9
            r8 = r19
            r5 = r21
            r10 = 8
            goto L_0x00eb
        L_0x02ee:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.m2986b(int, int):void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x036c  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0381  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x03ba  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0145  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r26, int r27) {
        /*
            r25 = this;
            r0 = r25
            r1 = r26
            r2 = r27
            java.lang.System.currentTimeMillis()
            int r3 = android.view.View.MeasureSpec.getMode(r26)
            int r4 = android.view.View.MeasureSpec.getSize(r26)
            int r5 = android.view.View.MeasureSpec.getMode(r27)
            int r6 = android.view.View.MeasureSpec.getSize(r27)
            int r7 = r25.getPaddingLeft()
            int r8 = r25.getPaddingTop()
            androidx.constraintlayout.b.a.g r9 = r0.f2452b
            r9.mo3093f(r7)
            androidx.constraintlayout.b.a.g r9 = r0.f2452b
            r9.mo3096g(r8)
            androidx.constraintlayout.b.a.g r9 = r0.f2452b
            int r10 = r0.f2463m
            r9.mo3084c(r10)
            androidx.constraintlayout.b.a.g r9 = r0.f2452b
            int r10 = r0.f2464n
            r9.mo3089d(r10)
            int r9 = android.os.Build.VERSION.SDK_INT
            r10 = 0
            r11 = 1
            r12 = 17
            if (r9 < r12) goto L_0x004f
            androidx.constraintlayout.b.a.g r9 = r0.f2452b
            int r12 = r25.getLayoutDirection()
            if (r12 != r11) goto L_0x004b
            r12 = 1
            goto L_0x004c
        L_0x004b:
            r12 = 0
        L_0x004c:
            r9.mo3137a(r12)
        L_0x004f:
            r25.m2989c(r26, r27)
            androidx.constraintlayout.b.a.g r9 = r0.f2452b
            int r9 = r9.mo3113p()
            androidx.constraintlayout.b.a.g r12 = r0.f2452b
            int r12 = r12.mo3116r()
            boolean r13 = r0.f2465o
            if (r13 == 0) goto L_0x0069
            r0.f2465o = r10
            r25.m2985b()
            r13 = 1
            goto L_0x006a
        L_0x0069:
            r13 = 0
        L_0x006a:
            int r14 = r0.f2466p
            r15 = 8
            r14 = r14 & r15
            if (r14 != r15) goto L_0x0073
            r14 = 1
            goto L_0x0074
        L_0x0073:
            r14 = 0
        L_0x0074:
            if (r14 == 0) goto L_0x0084
            androidx.constraintlayout.b.a.g r15 = r0.f2452b
            r15.mo3130O()
            androidx.constraintlayout.b.a.g r15 = r0.f2452b
            r15.mo3139e(r9, r12)
            r25.m2986b(r26, r27)
            goto L_0x0087
        L_0x0084:
            r25.m2983a(r26, r27)
        L_0x0087:
            r25.m2990d()
            int r15 = r25.getChildCount()
            if (r15 <= 0) goto L_0x0097
            if (r13 == 0) goto L_0x0097
            androidx.constraintlayout.b.a.g r13 = r0.f2452b
            androidx.constraintlayout.p060b.p061a.C0757a.m2716a(r13)
        L_0x0097:
            androidx.constraintlayout.b.a.g r13 = r0.f2452b
            boolean r13 = r13.f2314ap
            if (r13 == 0) goto L_0x00db
            androidx.constraintlayout.b.a.g r13 = r0.f2452b
            boolean r13 = r13.f2315aq
            r15 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r13 == 0) goto L_0x00bd
            if (r3 != r15) goto L_0x00bd
            androidx.constraintlayout.b.a.g r13 = r0.f2452b
            int r13 = r13.f2317as
            if (r13 >= r4) goto L_0x00b6
            androidx.constraintlayout.b.a.g r13 = r0.f2452b
            androidx.constraintlayout.b.a.g r11 = r0.f2452b
            int r11 = r11.f2317as
            r13.mo3098h(r11)
        L_0x00b6:
            androidx.constraintlayout.b.a.g r11 = r0.f2452b
            androidx.constraintlayout.b.a.f$a r13 = androidx.constraintlayout.p060b.p061a.C0766f.C0768a.FIXED
            r11.mo3070a(r13)
        L_0x00bd:
            androidx.constraintlayout.b.a.g r11 = r0.f2452b
            boolean r11 = r11.f2316ar
            if (r11 == 0) goto L_0x00db
            if (r5 != r15) goto L_0x00db
            androidx.constraintlayout.b.a.g r11 = r0.f2452b
            int r11 = r11.f2318at
            if (r11 >= r6) goto L_0x00d4
            androidx.constraintlayout.b.a.g r11 = r0.f2452b
            androidx.constraintlayout.b.a.g r13 = r0.f2452b
            int r13 = r13.f2318at
            r11.mo3100i(r13)
        L_0x00d4:
            androidx.constraintlayout.b.a.g r11 = r0.f2452b
            androidx.constraintlayout.b.a.f$a r13 = androidx.constraintlayout.p060b.p061a.C0766f.C0768a.FIXED
            r11.mo3080b(r13)
        L_0x00db:
            androidx.constraintlayout.b.a.g r11 = r0.f2452b
            boolean r11 = r11.f2319au
            r13 = 1073741824(0x40000000, float:2.0)
            if (r11 == 0) goto L_0x0127
            if (r3 != r13) goto L_0x00ff
            if (r5 != r13) goto L_0x00ff
            int r3 = r0.f2470t
            if (r3 == r4) goto L_0x00f2
            androidx.constraintlayout.b.a.g r3 = r0.f2452b
            java.util.List<androidx.constraintlayout.b.a.h> r3 = r3.f2313ao
            androidx.constraintlayout.p060b.p061a.C0757a.m2717a(r3, r10, r4)
        L_0x00f2:
            int r3 = r0.f2471u
            if (r3 == r6) goto L_0x0127
            androidx.constraintlayout.b.a.g r3 = r0.f2452b
            java.util.List<androidx.constraintlayout.b.a.h> r3 = r3.f2313ao
            r4 = 1
            androidx.constraintlayout.p060b.p061a.C0757a.m2717a(r3, r4, r6)
            goto L_0x0128
        L_0x00ff:
            androidx.constraintlayout.b.a.g r3 = r0.f2452b
            boolean r3 = r3.f2315aq
            if (r3 == 0) goto L_0x0127
            androidx.constraintlayout.b.a.g r3 = r0.f2452b
            boolean r3 = r3.f2316ar
            if (r3 == 0) goto L_0x0127
            androidx.constraintlayout.b.a.g r3 = r0.f2452b
            int r3 = r3.f2317as
            if (r3 <= r4) goto L_0x0118
            androidx.constraintlayout.b.a.g r3 = r0.f2452b
            java.util.List<androidx.constraintlayout.b.a.h> r3 = r3.f2313ao
            androidx.constraintlayout.p060b.p061a.C0757a.m2717a(r3, r10, r4)
        L_0x0118:
            androidx.constraintlayout.b.a.g r3 = r0.f2452b
            int r3 = r3.f2318at
            if (r3 <= r6) goto L_0x0127
            androidx.constraintlayout.b.a.g r3 = r0.f2452b
            java.util.List<androidx.constraintlayout.b.a.h> r3 = r3.f2313ao
            r4 = 1
            androidx.constraintlayout.p060b.p061a.C0757a.m2717a(r3, r4, r6)
            goto L_0x0128
        L_0x0127:
            r4 = 1
        L_0x0128:
            int r3 = r25.getChildCount()
            if (r3 <= 0) goto L_0x0133
            java.lang.String r3 = "First pass"
            r0.mo3240a(r3)
        L_0x0133:
            java.util.ArrayList<androidx.constraintlayout.b.a.f> r3 = r0.f2460j
            int r3 = r3.size()
            int r5 = r25.getPaddingBottom()
            int r8 = r8 + r5
            int r5 = r25.getPaddingRight()
            int r7 = r7 + r5
            if (r3 <= 0) goto L_0x036c
            androidx.constraintlayout.b.a.g r6 = r0.f2452b
            androidx.constraintlayout.b.a.f$a r6 = r6.mo3059G()
            androidx.constraintlayout.b.a.f$a r11 = androidx.constraintlayout.p060b.p061a.C0766f.C0768a.WRAP_CONTENT
            if (r6 != r11) goto L_0x0151
            r6 = 1
            goto L_0x0152
        L_0x0151:
            r6 = 0
        L_0x0152:
            androidx.constraintlayout.b.a.g r11 = r0.f2452b
            androidx.constraintlayout.b.a.f$a r11 = r11.mo3060H()
            androidx.constraintlayout.b.a.f$a r15 = androidx.constraintlayout.p060b.p061a.C0766f.C0768a.WRAP_CONTENT
            if (r11 != r15) goto L_0x015e
            r11 = 1
            goto L_0x015f
        L_0x015e:
            r11 = 0
        L_0x015f:
            androidx.constraintlayout.b.a.g r15 = r0.f2452b
            int r15 = r15.mo3113p()
            int r4 = r0.f2461k
            int r4 = java.lang.Math.max(r15, r4)
            androidx.constraintlayout.b.a.g r15 = r0.f2452b
            int r15 = r15.mo3116r()
            int r10 = r0.f2462l
            int r10 = java.lang.Math.max(r15, r10)
            r15 = r4
            r5 = r10
            r4 = 0
            r10 = 0
            r18 = 0
        L_0x017d:
            r19 = 1
            if (r4 >= r3) goto L_0x02c3
            java.util.ArrayList<androidx.constraintlayout.b.a.f> r13 = r0.f2460j
            java.lang.Object r13 = r13.get(r4)
            androidx.constraintlayout.b.a.f r13 = (androidx.constraintlayout.p060b.p061a.C0766f) r13
            java.lang.Object r16 = r13.mo3055C()
            r21 = r3
            r3 = r16
            android.view.View r3 = (android.view.View) r3
            if (r3 != 0) goto L_0x019c
            r23 = r9
            r24 = r10
            r22 = r12
            goto L_0x01da
        L_0x019c:
            android.view.ViewGroup$LayoutParams r16 = r3.getLayoutParams()
            r22 = r12
            r12 = r16
            androidx.constraintlayout.widget.ConstraintLayout$a r12 = (androidx.constraintlayout.widget.ConstraintLayout.C0795a) r12
            r23 = r9
            boolean r9 = r12.f2500Z
            if (r9 == 0) goto L_0x01b4
            boolean r9 = r12.f2503ab
            if (r9 == 0) goto L_0x01b1
            goto L_0x01b4
        L_0x01b1:
            r24 = r10
            goto L_0x01da
        L_0x01b4:
            boolean r9 = r12.f2499Y
            if (r9 == 0) goto L_0x01b9
            goto L_0x01b1
        L_0x01b9:
            int r9 = r3.getVisibility()
            r24 = r10
            r10 = 8
            if (r9 != r10) goto L_0x01c4
            goto L_0x01da
        L_0x01c4:
            if (r14 == 0) goto L_0x01de
            androidx.constraintlayout.b.a.o r9 = r13.mo3099i()
            boolean r9 = r9.mo3167g()
            if (r9 == 0) goto L_0x01de
            androidx.constraintlayout.b.a.o r9 = r13.mo3101j()
            boolean r9 = r9.mo3167g()
            if (r9 == 0) goto L_0x01de
        L_0x01da:
            r10 = r24
            goto L_0x02b5
        L_0x01de:
            int r9 = r12.width
            r10 = -2
            if (r9 != r10) goto L_0x01ee
            boolean r9 = r12.f2496V
            if (r9 == 0) goto L_0x01ee
            int r9 = r12.width
            int r9 = getChildMeasureSpec(r1, r7, r9)
            goto L_0x01f8
        L_0x01ee:
            int r9 = r13.mo3113p()
            r10 = 1073741824(0x40000000, float:2.0)
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r10)
        L_0x01f8:
            int r10 = r12.height
            r1 = -2
            if (r10 != r1) goto L_0x0208
            boolean r1 = r12.f2497W
            if (r1 == 0) goto L_0x0208
            int r1 = r12.height
            int r1 = getChildMeasureSpec(r2, r8, r1)
            goto L_0x0212
        L_0x0208:
            int r1 = r13.mo3116r()
            r10 = 1073741824(0x40000000, float:2.0)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r10)
        L_0x0212:
            r3.measure(r9, r1)
            androidx.constraintlayout.b.f r1 = r0.f2473w
            if (r1 == 0) goto L_0x0221
            androidx.constraintlayout.b.f r1 = r0.f2473w
            long r9 = r1.f2403b
            long r9 = r9 + r19
            r1.f2403b = r9
        L_0x0221:
            int r1 = r3.getMeasuredWidth()
            int r9 = r3.getMeasuredHeight()
            int r10 = r13.mo3113p()
            if (r1 == r10) goto L_0x0259
            r13.mo3098h(r1)
            if (r14 == 0) goto L_0x023b
            androidx.constraintlayout.b.a.o r10 = r13.mo3099i()
            r10.mo3162a(r1)
        L_0x023b:
            if (r6 == 0) goto L_0x0257
            int r1 = r13.mo3123x()
            if (r1 <= r15) goto L_0x0257
            int r1 = r13.mo3123x()
            androidx.constraintlayout.b.a.e$c r10 = androidx.constraintlayout.p060b.p061a.C0761e.C0765c.RIGHT
            androidx.constraintlayout.b.a.e r10 = r13.mo3063a(r10)
            int r10 = r10.mo3046e()
            int r1 = r1 + r10
            int r1 = java.lang.Math.max(r15, r1)
            r15 = r1
        L_0x0257:
            r24 = 1
        L_0x0259:
            int r1 = r13.mo3116r()
            if (r9 == r1) goto L_0x0289
            r13.mo3100i(r9)
            if (r14 == 0) goto L_0x026b
            androidx.constraintlayout.b.a.o r1 = r13.mo3101j()
            r1.mo3162a(r9)
        L_0x026b:
            if (r11 == 0) goto L_0x0287
            int r1 = r13.mo3124y()
            if (r1 <= r5) goto L_0x0287
            int r1 = r13.mo3124y()
            androidx.constraintlayout.b.a.e$c r9 = androidx.constraintlayout.p060b.p061a.C0761e.C0765c.BOTTOM
            androidx.constraintlayout.b.a.e r9 = r13.mo3063a(r9)
            int r9 = r9.mo3046e()
            int r1 = r1 + r9
            int r1 = java.lang.Math.max(r5, r1)
            r5 = r1
        L_0x0287:
            r24 = 1
        L_0x0289:
            boolean r1 = r12.f2498X
            if (r1 == 0) goto L_0x029f
            int r1 = r3.getBaseline()
            r9 = -1
            if (r1 == r9) goto L_0x029f
            int r9 = r13.mo3054B()
            if (r1 == r9) goto L_0x029f
            r13.mo3110n(r1)
            r24 = 1
        L_0x029f:
            int r1 = android.os.Build.VERSION.SDK_INT
            r9 = 11
            if (r1 < r9) goto L_0x02b1
            int r1 = r3.getMeasuredState()
            r3 = r18
            int r18 = combineMeasuredStates(r3, r1)
            goto L_0x01da
        L_0x02b1:
            r3 = r18
            goto L_0x01da
        L_0x02b5:
            int r4 = r4 + 1
            r3 = r21
            r12 = r22
            r9 = r23
            r1 = r26
            r13 = 1073741824(0x40000000, float:2.0)
            goto L_0x017d
        L_0x02c3:
            r21 = r3
            r23 = r9
            r24 = r10
            r22 = r12
            r3 = r18
            if (r24 == 0) goto L_0x0312
            androidx.constraintlayout.b.a.g r1 = r0.f2452b
            r4 = r23
            r1.mo3098h(r4)
            androidx.constraintlayout.b.a.g r1 = r0.f2452b
            r4 = r22
            r1.mo3100i(r4)
            if (r14 == 0) goto L_0x02e4
            androidx.constraintlayout.b.a.g r1 = r0.f2452b
            r1.mo3131P()
        L_0x02e4:
            java.lang.String r1 = "2nd pass"
            r0.mo3240a(r1)
            androidx.constraintlayout.b.a.g r1 = r0.f2452b
            int r1 = r1.mo3113p()
            if (r1 >= r15) goto L_0x02f8
            androidx.constraintlayout.b.a.g r1 = r0.f2452b
            r1.mo3098h(r15)
            r11 = 1
            goto L_0x02f9
        L_0x02f8:
            r11 = 0
        L_0x02f9:
            androidx.constraintlayout.b.a.g r1 = r0.f2452b
            int r1 = r1.mo3116r()
            if (r1 >= r5) goto L_0x0309
            androidx.constraintlayout.b.a.g r1 = r0.f2452b
            r1.mo3100i(r5)
            r17 = 1
            goto L_0x030b
        L_0x0309:
            r17 = r11
        L_0x030b:
            if (r17 == 0) goto L_0x0312
            java.lang.String r1 = "3rd pass"
            r0.mo3240a(r1)
        L_0x0312:
            r1 = r21
            r4 = 0
        L_0x0315:
            if (r4 >= r1) goto L_0x036d
            java.util.ArrayList<androidx.constraintlayout.b.a.f> r5 = r0.f2460j
            java.lang.Object r5 = r5.get(r4)
            androidx.constraintlayout.b.a.f r5 = (androidx.constraintlayout.p060b.p061a.C0766f) r5
            java.lang.Object r6 = r5.mo3055C()
            android.view.View r6 = (android.view.View) r6
            if (r6 != 0) goto L_0x032c
        L_0x0327:
            r10 = 8
        L_0x0329:
            r11 = 1073741824(0x40000000, float:2.0)
            goto L_0x0369
        L_0x032c:
            int r9 = r6.getMeasuredWidth()
            int r10 = r5.mo3113p()
            if (r9 != r10) goto L_0x0340
            int r9 = r6.getMeasuredHeight()
            int r10 = r5.mo3116r()
            if (r9 == r10) goto L_0x0327
        L_0x0340:
            int r9 = r5.mo3105l()
            r10 = 8
            if (r9 == r10) goto L_0x0329
            int r9 = r5.mo3113p()
            r11 = 1073741824(0x40000000, float:2.0)
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r11)
            int r5 = r5.mo3116r()
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r11)
            r6.measure(r9, r5)
            androidx.constraintlayout.b.f r5 = r0.f2473w
            if (r5 == 0) goto L_0x0369
            androidx.constraintlayout.b.f r5 = r0.f2473w
            long r12 = r5.f2403b
            long r12 = r12 + r19
            r5.f2403b = r12
        L_0x0369:
            int r4 = r4 + 1
            goto L_0x0315
        L_0x036c:
            r3 = 0
        L_0x036d:
            androidx.constraintlayout.b.a.g r1 = r0.f2452b
            int r1 = r1.mo3113p()
            int r1 = r1 + r7
            androidx.constraintlayout.b.a.g r4 = r0.f2452b
            int r4 = r4.mo3116r()
            int r4 = r4 + r8
            int r5 = android.os.Build.VERSION.SDK_INT
            r6 = 11
            if (r5 < r6) goto L_0x03ba
            r5 = r26
            int r1 = resolveSizeAndState(r1, r5, r3)
            int r3 = r3 << 16
            int r2 = resolveSizeAndState(r4, r2, r3)
            r3 = 16777215(0xffffff, float:2.3509886E-38)
            r1 = r1 & r3
            r2 = r2 & r3
            int r3 = r0.f2463m
            int r1 = java.lang.Math.min(r3, r1)
            int r3 = r0.f2464n
            int r2 = java.lang.Math.min(r3, r2)
            androidx.constraintlayout.b.a.g r3 = r0.f2452b
            boolean r3 = r3.mo3126K()
            r4 = 16777216(0x1000000, float:2.3509887E-38)
            if (r3 == 0) goto L_0x03a9
            r1 = r1 | r4
        L_0x03a9:
            androidx.constraintlayout.b.a.g r3 = r0.f2452b
            boolean r3 = r3.mo3127L()
            if (r3 == 0) goto L_0x03b2
            r2 = r2 | r4
        L_0x03b2:
            r0.setMeasuredDimension(r1, r2)
            r0.f2470t = r1
            r0.f2471u = r2
            goto L_0x03c1
        L_0x03ba:
            r0.setMeasuredDimension(r1, r4)
            r0.f2470t = r1
            r0.f2471u = r4
        L_0x03c1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.onMeasure(int, int):void");
    }

    /* renamed from: c */
    private void m2989c(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        C0768a aVar = C0768a.FIXED;
        C0768a aVar2 = C0768a.FIXED;
        getLayoutParams();
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                aVar = C0768a.WRAP_CONTENT;
            } else if (mode == 1073741824) {
                size = Math.min(this.f2463m, size) - paddingLeft;
            }
            size = 0;
        } else {
            aVar = C0768a.WRAP_CONTENT;
        }
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 == 0) {
                aVar2 = C0768a.WRAP_CONTENT;
            } else if (mode2 == 1073741824) {
                size2 = Math.min(this.f2464n, size2) - paddingTop;
            }
            size2 = 0;
        } else {
            aVar2 = C0768a.WRAP_CONTENT;
        }
        this.f2452b.mo3102j(0);
        this.f2452b.mo3104k(0);
        this.f2452b.mo3070a(aVar);
        this.f2452b.mo3098h(size);
        this.f2452b.mo3080b(aVar2);
        this.f2452b.mo3100i(size2);
        this.f2452b.mo3102j((this.f2461k - getPaddingLeft()) - getPaddingRight());
        this.f2452b.mo3104k((this.f2462l - getPaddingTop()) - getPaddingBottom());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3240a(String str) {
        if (this.f2473w != null) {
            this.f2473w.f2404c++;
        }
        this.f2452b.mo3129N();
    }

    /* renamed from: a */
    public void mo3239a(int i, int i2, int i3) {
        if (this.f2453c != null) {
            this.f2453c.mo3285a(i, (float) i2, (float) i3);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            C0795a aVar = (C0795a) childAt.getLayoutParams();
            C0766f fVar = aVar.f2514am;
            if ((childAt.getVisibility() != 8 || aVar.f2499Y || aVar.f2500Z || aVar.f2503ab || isInEditMode) && !aVar.f2502aa) {
                int t = fVar.mo3118t();
                int u = fVar.mo3120u();
                int p = fVar.mo3113p() + t;
                int r = fVar.mo3116r() + u;
                childAt.layout(t, u, p, r);
                if (childAt instanceof C0815i) {
                    View content = ((C0815i) childAt).getContent();
                    if (content != null) {
                        content.setVisibility(0);
                        content.layout(t, u, p, r);
                    }
                }
            }
        }
        int size = this.f2459i.size();
        if (size > 0) {
            for (int i6 = 0; i6 < size; i6++) {
                ((C0805c) this.f2459i.get(i6)).mo3278b(this);
            }
        }
    }

    public void setOptimizationLevel(int i) {
        this.f2452b.mo3029a(i);
    }

    public int getOptimizationLevel() {
        return this.f2452b.mo3034b();
    }

    /* renamed from: a */
    public C0795a generateLayoutParams(AttributeSet attributeSet) {
        return new C0795a(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0795a generateDefaultLayoutParams() {
        return new C0795a(-2, -2);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return new C0795a(layoutParams);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof C0795a;
    }

    public void setConstraintSet(C0809e eVar) {
        this.f2467q = eVar;
    }

    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = (float) getWidth();
            float height = (float) getHeight();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt.getVisibility() != 8) {
                    Object tag = childAt.getTag();
                    if (tag != null && (tag instanceof String)) {
                        String[] split = ((String) tag).split(",");
                        if (split.length == 4) {
                            int parseInt = Integer.parseInt(split[0]);
                            int parseInt2 = Integer.parseInt(split[1]);
                            int i2 = (int) ((((float) parseInt) / 1080.0f) * width);
                            int i3 = (int) ((((float) parseInt2) / 1920.0f) * height);
                            int parseInt3 = (int) ((((float) Integer.parseInt(split[2])) / 1080.0f) * width);
                            int parseInt4 = (int) ((((float) Integer.parseInt(split[3])) / 1920.0f) * height);
                            Paint paint = new Paint();
                            paint.setColor(-65536);
                            float f = (float) i2;
                            float f2 = (float) (i2 + parseInt3);
                            Canvas canvas2 = canvas;
                            float f3 = (float) i3;
                            float f4 = f;
                            float f5 = f;
                            float f6 = f3;
                            Paint paint2 = paint;
                            float f7 = f2;
                            Paint paint3 = paint2;
                            canvas2.drawLine(f4, f6, f7, f3, paint3);
                            float f8 = (float) (i3 + parseInt4);
                            float f9 = f2;
                            float f10 = f8;
                            canvas2.drawLine(f9, f6, f7, f10, paint3);
                            float f11 = f8;
                            float f12 = f5;
                            canvas2.drawLine(f9, f11, f12, f10, paint3);
                            float f13 = f5;
                            canvas2.drawLine(f13, f11, f12, f3, paint3);
                            Paint paint4 = paint2;
                            paint4.setColor(-16711936);
                            Paint paint5 = paint4;
                            float f14 = f2;
                            Paint paint6 = paint5;
                            canvas2.drawLine(f13, f3, f14, f8, paint6);
                            canvas2.drawLine(f13, f8, f14, f3, paint6);
                        }
                    }
                }
            }
        }
    }

    public void setOnConstraintsChanged(C0813g gVar) {
        this.f2472v = gVar;
        if (this.f2453c != null) {
            this.f2453c.mo3286a(gVar);
        }
    }

    public void requestLayout() {
        super.requestLayout();
        this.f2465o = true;
        this.f2470t = -1;
        this.f2471u = -1;
        this.f2454d = -1;
        this.f2455e = -1;
        this.f2456f = 0;
        this.f2457g = 0;
    }
}
