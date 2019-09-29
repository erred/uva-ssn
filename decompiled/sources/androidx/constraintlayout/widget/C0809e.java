package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.p057a.p058a.C0754a;
import androidx.constraintlayout.p057a.p059b.C0755a;
import androidx.constraintlayout.widget.C0811f.C0812a;
import androidx.constraintlayout.widget.ConstraintLayout.C0795a;
import androidx.constraintlayout.widget.R.id;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: androidx.constraintlayout.widget.e */
/* compiled from: ConstraintSet */
public class C0809e {

    /* renamed from: b */
    private static final int[] f2585b = {0, 4, 8};

    /* renamed from: d */
    private static SparseIntArray f2586d = new SparseIntArray();

    /* renamed from: a */
    private HashMap<String, C0802b> f2587a = new HashMap<>();

    /* renamed from: c */
    private HashMap<Integer, C0810a> f2588c = new HashMap<>();

    /* renamed from: androidx.constraintlayout.widget.e$a */
    /* compiled from: ConstraintSet */
    public static class C0810a {

        /* renamed from: A */
        public int f2589A = -1;

        /* renamed from: B */
        public int f2590B = -1;

        /* renamed from: C */
        public int f2591C = -1;

        /* renamed from: D */
        public int f2592D = -1;

        /* renamed from: E */
        public int f2593E = -1;

        /* renamed from: F */
        public int f2594F = -1;

        /* renamed from: G */
        public int f2595G = -1;

        /* renamed from: H */
        public int f2596H = -1;

        /* renamed from: I */
        public int f2597I = -1;

        /* renamed from: J */
        public int f2598J = 0;

        /* renamed from: K */
        public int f2599K = -1;

        /* renamed from: L */
        public int f2600L = -1;

        /* renamed from: M */
        public int f2601M = -1;

        /* renamed from: N */
        public int f2602N = -1;

        /* renamed from: O */
        public int f2603O = -1;

        /* renamed from: P */
        public int f2604P = -1;

        /* renamed from: Q */
        public float f2605Q = BitmapDescriptorFactory.HUE_RED;

        /* renamed from: R */
        public float f2606R = BitmapDescriptorFactory.HUE_RED;

        /* renamed from: S */
        public int f2607S = 0;

        /* renamed from: T */
        public int f2608T = 0;

        /* renamed from: U */
        public float f2609U = 1.0f;

        /* renamed from: V */
        public boolean f2610V = false;

        /* renamed from: W */
        public float f2611W = BitmapDescriptorFactory.HUE_RED;

        /* renamed from: X */
        public float f2612X = BitmapDescriptorFactory.HUE_RED;

        /* renamed from: Y */
        public float f2613Y = BitmapDescriptorFactory.HUE_RED;

        /* renamed from: Z */
        public float f2614Z = BitmapDescriptorFactory.HUE_RED;

        /* renamed from: a */
        boolean f2615a = false;

        /* renamed from: aA */
        public float f2616aA = Float.NaN;

        /* renamed from: aB */
        public boolean f2617aB = true;

        /* renamed from: aC */
        public HashMap<String, C0802b> f2618aC = new HashMap<>();

        /* renamed from: aa */
        public float f2619aa = 1.0f;

        /* renamed from: ab */
        public float f2620ab = 1.0f;

        /* renamed from: ac */
        public float f2621ac = Float.NaN;

        /* renamed from: ad */
        public float f2622ad = Float.NaN;

        /* renamed from: ae */
        public float f2623ae = BitmapDescriptorFactory.HUE_RED;

        /* renamed from: af */
        public float f2624af = BitmapDescriptorFactory.HUE_RED;

        /* renamed from: ag */
        public float f2625ag = BitmapDescriptorFactory.HUE_RED;

        /* renamed from: ah */
        public boolean f2626ah = false;

        /* renamed from: ai */
        public boolean f2627ai = false;

        /* renamed from: aj */
        public int f2628aj = 0;

        /* renamed from: ak */
        public int f2629ak = 0;

        /* renamed from: al */
        public int f2630al = -1;

        /* renamed from: am */
        public int f2631am = -1;

        /* renamed from: an */
        public int f2632an = -1;

        /* renamed from: ao */
        public int f2633ao = -1;

        /* renamed from: ap */
        public float f2634ap = 1.0f;

        /* renamed from: aq */
        public float f2635aq = 1.0f;

        /* renamed from: ar */
        public int f2636ar = -1;

        /* renamed from: as */
        public int f2637as = -1;

        /* renamed from: at */
        public int[] f2638at;

        /* renamed from: au */
        public String f2639au;

        /* renamed from: av */
        public int f2640av = -1;

        /* renamed from: aw */
        public String f2641aw = null;

        /* renamed from: ax */
        public int f2642ax = -1;

        /* renamed from: ay */
        public int f2643ay = 0;

        /* renamed from: az */
        public float f2644az = Float.NaN;

        /* renamed from: b */
        public int f2645b;

        /* renamed from: c */
        public int f2646c;

        /* renamed from: d */
        int f2647d;

        /* renamed from: e */
        public int f2648e = -1;

        /* renamed from: f */
        public int f2649f = -1;

        /* renamed from: g */
        public float f2650g = -1.0f;

        /* renamed from: h */
        public int f2651h = -1;

        /* renamed from: i */
        public int f2652i = -1;

        /* renamed from: j */
        public int f2653j = -1;

        /* renamed from: k */
        public int f2654k = -1;

        /* renamed from: l */
        public int f2655l = -1;

        /* renamed from: m */
        public int f2656m = -1;

        /* renamed from: n */
        public int f2657n = -1;

        /* renamed from: o */
        public int f2658o = -1;

        /* renamed from: p */
        public int f2659p = -1;

        /* renamed from: q */
        public int f2660q = -1;

        /* renamed from: r */
        public int f2661r = -1;

        /* renamed from: s */
        public int f2662s = -1;

        /* renamed from: t */
        public int f2663t = -1;

        /* renamed from: u */
        public float f2664u = 0.5f;

        /* renamed from: v */
        public float f2665v = 0.5f;

        /* renamed from: w */
        public String f2666w = null;

        /* renamed from: x */
        public int f2667x = -1;

        /* renamed from: y */
        public int f2668y = 0;

        /* renamed from: z */
        public float f2669z = BitmapDescriptorFactory.HUE_RED;

        /* renamed from: a */
        public C0810a clone() {
            C0810a aVar = new C0810a();
            aVar.f2615a = this.f2615a;
            aVar.f2645b = this.f2645b;
            aVar.f2646c = this.f2646c;
            aVar.f2648e = this.f2648e;
            aVar.f2649f = this.f2649f;
            aVar.f2650g = this.f2650g;
            aVar.f2651h = this.f2651h;
            aVar.f2652i = this.f2652i;
            aVar.f2653j = this.f2653j;
            aVar.f2654k = this.f2654k;
            aVar.f2655l = this.f2655l;
            aVar.f2656m = this.f2656m;
            aVar.f2657n = this.f2657n;
            aVar.f2658o = this.f2658o;
            aVar.f2659p = this.f2659p;
            aVar.f2660q = this.f2660q;
            aVar.f2661r = this.f2661r;
            aVar.f2662s = this.f2662s;
            aVar.f2663t = this.f2663t;
            aVar.f2664u = this.f2664u;
            aVar.f2665v = this.f2665v;
            aVar.f2666w = this.f2666w;
            aVar.f2589A = this.f2589A;
            aVar.f2590B = this.f2590B;
            aVar.f2664u = this.f2664u;
            aVar.f2664u = this.f2664u;
            aVar.f2664u = this.f2664u;
            aVar.f2664u = this.f2664u;
            aVar.f2664u = this.f2664u;
            aVar.f2591C = this.f2591C;
            aVar.f2592D = this.f2592D;
            aVar.f2593E = this.f2593E;
            aVar.f2594F = this.f2594F;
            aVar.f2595G = this.f2595G;
            aVar.f2596H = this.f2596H;
            aVar.f2597I = this.f2597I;
            aVar.f2598J = this.f2598J;
            aVar.f2599K = this.f2599K;
            aVar.f2600L = this.f2600L;
            aVar.f2601M = this.f2601M;
            aVar.f2602N = this.f2602N;
            aVar.f2603O = this.f2603O;
            aVar.f2604P = this.f2604P;
            aVar.f2605Q = this.f2605Q;
            aVar.f2606R = this.f2606R;
            aVar.f2607S = this.f2607S;
            aVar.f2608T = this.f2608T;
            aVar.f2609U = this.f2609U;
            aVar.f2610V = this.f2610V;
            aVar.f2611W = this.f2611W;
            aVar.f2612X = this.f2612X;
            aVar.f2613Y = this.f2613Y;
            aVar.f2614Z = this.f2614Z;
            aVar.f2619aa = this.f2619aa;
            aVar.f2620ab = this.f2620ab;
            aVar.f2621ac = this.f2621ac;
            aVar.f2622ad = this.f2622ad;
            aVar.f2623ae = this.f2623ae;
            aVar.f2624af = this.f2624af;
            aVar.f2625ag = this.f2625ag;
            aVar.f2626ah = this.f2626ah;
            aVar.f2627ai = this.f2627ai;
            aVar.f2628aj = this.f2628aj;
            aVar.f2629ak = this.f2629ak;
            aVar.f2630al = this.f2630al;
            aVar.f2631am = this.f2631am;
            aVar.f2632an = this.f2632an;
            aVar.f2633ao = this.f2633ao;
            aVar.f2634ap = this.f2634ap;
            aVar.f2635aq = this.f2635aq;
            aVar.f2636ar = this.f2636ar;
            aVar.f2637as = this.f2637as;
            if (this.f2638at != null) {
                aVar.f2638at = Arrays.copyOf(this.f2638at, this.f2638at.length);
            }
            aVar.f2667x = this.f2667x;
            aVar.f2668y = this.f2668y;
            aVar.f2669z = this.f2669z;
            aVar.f2640av = this.f2640av;
            aVar.f2641aw = this.f2641aw;
            aVar.f2642ax = this.f2642ax;
            aVar.f2643ay = this.f2643ay;
            aVar.f2617aB = this.f2617aB;
            return aVar;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m3034a(C0805c cVar, int i, C0812a aVar) {
            m3033a(i, aVar);
            if (cVar instanceof C0801a) {
                this.f2637as = 1;
                C0801a aVar2 = (C0801a) cVar;
                this.f2636ar = aVar2.getType();
                this.f2638at = aVar2.getReferencedIds();
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m3033a(int i, C0812a aVar) {
            m3032a(i, (C0795a) aVar);
            this.f2609U = aVar.f2672ao;
            this.f2612X = aVar.f2675ar;
            this.f2613Y = aVar.f2676as;
            this.f2614Z = aVar.f2677at;
            this.f2619aa = aVar.f2678au;
            this.f2620ab = aVar.f2679av;
            this.f2621ac = aVar.f2680aw;
            this.f2622ad = aVar.f2681ax;
            this.f2623ae = aVar.f2682ay;
            this.f2624af = aVar.f2683az;
            this.f2625ag = aVar.f2671aA;
            this.f2611W = aVar.f2674aq;
            this.f2610V = aVar.f2673ap;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m3032a(int i, C0795a aVar) {
            this.f2647d = i;
            this.f2651h = aVar.f2518d;
            this.f2652i = aVar.f2519e;
            this.f2653j = aVar.f2520f;
            this.f2654k = aVar.f2521g;
            this.f2655l = aVar.f2522h;
            this.f2656m = aVar.f2523i;
            this.f2657n = aVar.f2524j;
            this.f2658o = aVar.f2525k;
            this.f2659p = aVar.f2526l;
            this.f2660q = aVar.f2530p;
            this.f2661r = aVar.f2531q;
            this.f2662s = aVar.f2532r;
            this.f2663t = aVar.f2533s;
            this.f2664u = aVar.f2540z;
            this.f2665v = aVar.f2475A;
            this.f2666w = aVar.f2476B;
            this.f2667x = aVar.f2527m;
            this.f2668y = aVar.f2528n;
            this.f2669z = aVar.f2529o;
            this.f2589A = aVar.f2491Q;
            this.f2590B = aVar.f2492R;
            this.f2591C = aVar.f2493S;
            this.f2650g = aVar.f2517c;
            this.f2648e = aVar.f2501a;
            this.f2649f = aVar.f2516b;
            this.f2645b = aVar.width;
            this.f2646c = aVar.height;
            this.f2592D = aVar.leftMargin;
            this.f2593E = aVar.rightMargin;
            this.f2594F = aVar.topMargin;
            this.f2595G = aVar.bottomMargin;
            this.f2605Q = aVar.f2480F;
            this.f2606R = aVar.f2479E;
            this.f2608T = aVar.f2482H;
            this.f2607S = aVar.f2481G;
            this.f2626ah = aVar.f2494T;
            this.f2627ai = aVar.f2495U;
            this.f2628aj = aVar.f2483I;
            this.f2629ak = aVar.f2484J;
            this.f2626ah = aVar.f2494T;
            this.f2630al = aVar.f2487M;
            this.f2631am = aVar.f2488N;
            this.f2632an = aVar.f2485K;
            this.f2633ao = aVar.f2486L;
            this.f2634ap = aVar.f2489O;
            this.f2635aq = aVar.f2490P;
            if (VERSION.SDK_INT >= 17) {
                this.f2596H = aVar.getMarginEnd();
                this.f2597I = aVar.getMarginStart();
            }
        }

        /* renamed from: a */
        public void mo3300a(C0795a aVar) {
            aVar.f2518d = this.f2651h;
            aVar.f2519e = this.f2652i;
            aVar.f2520f = this.f2653j;
            aVar.f2521g = this.f2654k;
            aVar.f2522h = this.f2655l;
            aVar.f2523i = this.f2656m;
            aVar.f2524j = this.f2657n;
            aVar.f2525k = this.f2658o;
            aVar.f2526l = this.f2659p;
            aVar.f2530p = this.f2660q;
            aVar.f2531q = this.f2661r;
            aVar.f2532r = this.f2662s;
            aVar.f2533s = this.f2663t;
            aVar.leftMargin = this.f2592D;
            aVar.rightMargin = this.f2593E;
            aVar.topMargin = this.f2594F;
            aVar.bottomMargin = this.f2595G;
            aVar.f2538x = this.f2604P;
            aVar.f2539y = this.f2603O;
            aVar.f2540z = this.f2664u;
            aVar.f2475A = this.f2665v;
            aVar.f2527m = this.f2667x;
            aVar.f2528n = this.f2668y;
            aVar.f2529o = this.f2669z;
            aVar.f2476B = this.f2666w;
            aVar.f2491Q = this.f2589A;
            aVar.f2492R = this.f2590B;
            aVar.f2480F = this.f2605Q;
            aVar.f2479E = this.f2606R;
            aVar.f2482H = this.f2608T;
            aVar.f2481G = this.f2607S;
            aVar.f2494T = this.f2626ah;
            aVar.f2495U = this.f2627ai;
            aVar.f2483I = this.f2628aj;
            aVar.f2484J = this.f2629ak;
            aVar.f2487M = this.f2630al;
            aVar.f2488N = this.f2631am;
            aVar.f2485K = this.f2632an;
            aVar.f2486L = this.f2633ao;
            aVar.f2489O = this.f2634ap;
            aVar.f2490P = this.f2635aq;
            aVar.f2493S = this.f2591C;
            aVar.f2517c = this.f2650g;
            aVar.f2501a = this.f2648e;
            aVar.f2516b = this.f2649f;
            aVar.width = this.f2645b;
            aVar.height = this.f2646c;
            if (VERSION.SDK_INT >= 17) {
                aVar.setMarginStart(this.f2597I);
                aVar.setMarginEnd(this.f2596H);
            }
            aVar.mo3268a();
        }
    }

    static {
        f2586d.append(R.styleable.ConstraintSet_layout_constraintLeft_toLeftOf, 25);
        f2586d.append(R.styleable.ConstraintSet_layout_constraintLeft_toRightOf, 26);
        f2586d.append(R.styleable.ConstraintSet_layout_constraintRight_toLeftOf, 29);
        f2586d.append(R.styleable.ConstraintSet_layout_constraintRight_toRightOf, 30);
        f2586d.append(R.styleable.ConstraintSet_layout_constraintTop_toTopOf, 36);
        f2586d.append(R.styleable.ConstraintSet_layout_constraintTop_toBottomOf, 35);
        f2586d.append(R.styleable.ConstraintSet_layout_constraintBottom_toTopOf, 4);
        f2586d.append(R.styleable.ConstraintSet_layout_constraintBottom_toBottomOf, 3);
        f2586d.append(R.styleable.ConstraintSet_layout_constraintBaseline_toBaselineOf, 1);
        f2586d.append(R.styleable.ConstraintSet_layout_editor_absoluteX, 6);
        f2586d.append(R.styleable.ConstraintSet_layout_editor_absoluteY, 7);
        f2586d.append(R.styleable.ConstraintSet_layout_constraintGuide_begin, 17);
        f2586d.append(R.styleable.ConstraintSet_layout_constraintGuide_end, 18);
        f2586d.append(R.styleable.ConstraintSet_layout_constraintGuide_percent, 19);
        f2586d.append(R.styleable.ConstraintSet_android_orientation, 27);
        f2586d.append(R.styleable.ConstraintSet_layout_constraintStart_toEndOf, 32);
        f2586d.append(R.styleable.ConstraintSet_layout_constraintStart_toStartOf, 33);
        f2586d.append(R.styleable.ConstraintSet_layout_constraintEnd_toStartOf, 10);
        f2586d.append(R.styleable.ConstraintSet_layout_constraintEnd_toEndOf, 9);
        f2586d.append(R.styleable.ConstraintSet_layout_goneMarginLeft, 13);
        f2586d.append(R.styleable.ConstraintSet_layout_goneMarginTop, 16);
        f2586d.append(R.styleable.ConstraintSet_layout_goneMarginRight, 14);
        f2586d.append(R.styleable.ConstraintSet_layout_goneMarginBottom, 11);
        f2586d.append(R.styleable.ConstraintSet_layout_goneMarginStart, 15);
        f2586d.append(R.styleable.ConstraintSet_layout_goneMarginEnd, 12);
        f2586d.append(R.styleable.ConstraintSet_layout_constraintVertical_weight, 40);
        f2586d.append(R.styleable.ConstraintSet_layout_constraintHorizontal_weight, 39);
        f2586d.append(R.styleable.ConstraintSet_layout_constraintHorizontal_chainStyle, 41);
        f2586d.append(R.styleable.ConstraintSet_layout_constraintVertical_chainStyle, 42);
        f2586d.append(R.styleable.ConstraintSet_layout_constraintHorizontal_bias, 20);
        f2586d.append(R.styleable.ConstraintSet_layout_constraintVertical_bias, 37);
        f2586d.append(R.styleable.ConstraintSet_layout_constraintDimensionRatio, 5);
        f2586d.append(R.styleable.ConstraintSet_layout_constraintLeft_creator, 76);
        f2586d.append(R.styleable.ConstraintSet_layout_constraintTop_creator, 76);
        f2586d.append(R.styleable.ConstraintSet_layout_constraintRight_creator, 76);
        f2586d.append(R.styleable.ConstraintSet_layout_constraintBottom_creator, 76);
        f2586d.append(R.styleable.ConstraintSet_layout_constraintBaseline_creator, 76);
        f2586d.append(R.styleable.ConstraintSet_android_layout_marginLeft, 24);
        f2586d.append(R.styleable.ConstraintSet_android_layout_marginRight, 28);
        f2586d.append(R.styleable.ConstraintSet_android_layout_marginStart, 31);
        f2586d.append(R.styleable.ConstraintSet_android_layout_marginEnd, 8);
        f2586d.append(R.styleable.ConstraintSet_android_layout_marginTop, 34);
        f2586d.append(R.styleable.ConstraintSet_android_layout_marginBottom, 2);
        f2586d.append(R.styleable.ConstraintSet_android_layout_width, 23);
        f2586d.append(R.styleable.ConstraintSet_android_layout_height, 21);
        f2586d.append(R.styleable.ConstraintSet_android_visibility, 22);
        f2586d.append(R.styleable.ConstraintSet_android_alpha, 43);
        f2586d.append(R.styleable.ConstraintSet_android_elevation, 44);
        f2586d.append(R.styleable.ConstraintSet_android_rotationX, 45);
        f2586d.append(R.styleable.ConstraintSet_android_rotationY, 46);
        f2586d.append(R.styleable.ConstraintSet_android_rotation, 60);
        f2586d.append(R.styleable.ConstraintSet_android_scaleX, 47);
        f2586d.append(R.styleable.ConstraintSet_android_scaleY, 48);
        f2586d.append(R.styleable.ConstraintSet_android_transformPivotX, 49);
        f2586d.append(R.styleable.ConstraintSet_android_transformPivotY, 50);
        f2586d.append(R.styleable.ConstraintSet_android_translationX, 51);
        f2586d.append(R.styleable.ConstraintSet_android_translationY, 52);
        f2586d.append(R.styleable.ConstraintSet_android_translationZ, 53);
        f2586d.append(R.styleable.ConstraintSet_layout_constraintWidth_default, 54);
        f2586d.append(R.styleable.ConstraintSet_layout_constraintHeight_default, 55);
        f2586d.append(R.styleable.ConstraintSet_layout_constraintWidth_max, 56);
        f2586d.append(R.styleable.ConstraintSet_layout_constraintHeight_max, 57);
        f2586d.append(R.styleable.ConstraintSet_layout_constraintWidth_min, 58);
        f2586d.append(R.styleable.ConstraintSet_layout_constraintHeight_min, 59);
        f2586d.append(R.styleable.ConstraintSet_layout_constraintCircle, 61);
        f2586d.append(R.styleable.ConstraintSet_layout_constraintCircleRadius, 62);
        f2586d.append(R.styleable.ConstraintSet_layout_constraintCircleAngle, 63);
        f2586d.append(R.styleable.ConstraintSet_animate_relativeTo, 64);
        f2586d.append(R.styleable.ConstraintSet_transitionEasing, 65);
        f2586d.append(R.styleable.ConstraintSet_drawPath, 66);
        f2586d.append(R.styleable.ConstraintSet_transitionPathRotate, 67);
        f2586d.append(R.styleable.ConstraintSet_android_id, 38);
        f2586d.append(R.styleable.ConstraintSet_progress, 68);
        f2586d.append(R.styleable.ConstraintSet_layout_constraintWidth_percent, 69);
        f2586d.append(R.styleable.ConstraintSet_layout_constraintHeight_percent, 70);
        f2586d.append(R.styleable.ConstraintSet_chainUseRtl, 71);
        f2586d.append(R.styleable.ConstraintSet_barrierDirection, 72);
        f2586d.append(R.styleable.ConstraintSet_constraint_referenced_ids, 73);
        f2586d.append(R.styleable.ConstraintSet_barrierAllowsGoneWidgets, 74);
        f2586d.append(R.styleable.ConstraintSet_pathMotionArc, 75);
    }

    /* renamed from: a */
    public void mo3291a(Context context, int i) {
        mo3293a((ConstraintLayout) LayoutInflater.from(context).inflate(i, null));
    }

    /* renamed from: a */
    public void mo3293a(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.f2588c.clear();
        int i = 0;
        while (i < childCount) {
            View childAt = constraintLayout.getChildAt(i);
            C0795a aVar = (C0795a) childAt.getLayoutParams();
            int id = childAt.getId();
            if (id != -1) {
                if (!this.f2588c.containsKey(Integer.valueOf(id))) {
                    this.f2588c.put(Integer.valueOf(id), new C0810a());
                }
                C0810a aVar2 = (C0810a) this.f2588c.get(Integer.valueOf(id));
                aVar2.f2618aC = C0802b.m3001a(this.f2587a, childAt);
                aVar2.m3032a(id, aVar);
                aVar2.f2598J = childAt.getVisibility();
                if (VERSION.SDK_INT >= 17) {
                    aVar2.f2609U = childAt.getAlpha();
                    aVar2.f2612X = childAt.getRotation();
                    aVar2.f2613Y = childAt.getRotationX();
                    aVar2.f2614Z = childAt.getRotationY();
                    aVar2.f2619aa = childAt.getScaleX();
                    aVar2.f2620ab = childAt.getScaleY();
                    float pivotX = childAt.getPivotX();
                    float pivotY = childAt.getPivotY();
                    if (!(((double) pivotX) == 0.0d && ((double) pivotY) == 0.0d)) {
                        aVar2.f2621ac = pivotX;
                        aVar2.f2622ad = pivotY;
                    }
                    aVar2.f2623ae = childAt.getTranslationX();
                    aVar2.f2624af = childAt.getTranslationY();
                    if (VERSION.SDK_INT >= 21) {
                        aVar2.f2625ag = childAt.getTranslationZ();
                        if (aVar2.f2610V) {
                            aVar2.f2611W = childAt.getElevation();
                        }
                    }
                }
                if (childAt instanceof C0801a) {
                    C0801a aVar3 = (C0801a) childAt;
                    aVar2.f2617aB = aVar3.mo3271a();
                    aVar2.f2638at = aVar3.getReferencedIds();
                    aVar2.f2636ar = aVar3.getType();
                }
                i++;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    /* renamed from: a */
    public void mo3294a(C0811f fVar) {
        int childCount = fVar.getChildCount();
        this.f2588c.clear();
        int i = 0;
        while (i < childCount) {
            View childAt = fVar.getChildAt(i);
            C0812a aVar = (C0812a) childAt.getLayoutParams();
            int id = childAt.getId();
            if (id != -1) {
                if (!this.f2588c.containsKey(Integer.valueOf(id))) {
                    this.f2588c.put(Integer.valueOf(id), new C0810a());
                }
                C0810a aVar2 = (C0810a) this.f2588c.get(Integer.valueOf(id));
                if (childAt instanceof C0805c) {
                    aVar2.m3034a((C0805c) childAt, id, aVar);
                }
                aVar2.m3033a(id, aVar);
                i++;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    /* renamed from: b */
    public void mo3297b(ConstraintLayout constraintLayout) {
        mo3298c(constraintLayout);
        constraintLayout.setConstraintSet(null);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo3298c(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.f2588c.keySet());
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            int id = childAt.getId();
            if (!this.f2588c.containsKey(Integer.valueOf(id))) {
                StringBuilder sb = new StringBuilder();
                sb.append("id unknown ");
                sb.append(C0755a.m2696a(childAt));
                Log.v("ConstraintSet", sb.toString());
            } else if (id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else if (this.f2588c.containsKey(Integer.valueOf(id))) {
                hashSet.remove(Integer.valueOf(id));
                C0810a aVar = (C0810a) this.f2588c.get(Integer.valueOf(id));
                if (childAt instanceof C0801a) {
                    aVar.f2637as = 1;
                }
                if (aVar.f2637as != -1 && aVar.f2637as == 1) {
                    C0801a aVar2 = (C0801a) childAt;
                    aVar2.setId(id);
                    aVar2.setType(aVar.f2636ar);
                    aVar2.setAllowsGoneWidget(aVar.f2617aB);
                    if (aVar.f2638at != null) {
                        aVar2.setReferencedIds(aVar.f2638at);
                    } else if (aVar.f2639au != null) {
                        aVar.f2638at = m3022a((View) aVar2, aVar.f2639au);
                        aVar2.setReferencedIds(aVar.f2638at);
                    }
                }
                C0795a aVar3 = (C0795a) childAt.getLayoutParams();
                aVar.mo3300a(aVar3);
                C0802b.m3003a(childAt, aVar.f2618aC);
                childAt.setLayoutParams(aVar3);
                childAt.setVisibility(aVar.f2598J);
                if (VERSION.SDK_INT >= 17) {
                    childAt.setAlpha(aVar.f2609U);
                    childAt.setRotation(aVar.f2612X);
                    childAt.setRotationX(aVar.f2613Y);
                    childAt.setRotationY(aVar.f2614Z);
                    childAt.setScaleX(aVar.f2619aa);
                    childAt.setScaleY(aVar.f2620ab);
                    if (!Float.isNaN(aVar.f2621ac)) {
                        childAt.setPivotX(aVar.f2621ac);
                    }
                    if (!Float.isNaN(aVar.f2622ad)) {
                        childAt.setPivotY(aVar.f2622ad);
                    }
                    childAt.setTranslationX(aVar.f2623ae);
                    childAt.setTranslationY(aVar.f2624af);
                    if (VERSION.SDK_INT >= 21) {
                        childAt.setTranslationZ(aVar.f2625ag);
                        if (aVar.f2610V) {
                            childAt.setElevation(aVar.f2611W);
                        }
                    }
                }
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("WARNING NO CONSTRAINTS for view ");
                sb2.append(id);
                Log.v("ConstraintSet", sb2.toString());
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            C0810a aVar4 = (C0810a) this.f2588c.get(num);
            if (aVar4.f2637as != -1 && aVar4.f2637as == 1) {
                C0801a aVar5 = new C0801a(constraintLayout.getContext());
                aVar5.setId(num.intValue());
                if (aVar4.f2638at != null) {
                    aVar5.setReferencedIds(aVar4.f2638at);
                } else if (aVar4.f2639au != null) {
                    aVar4.f2638at = m3022a((View) aVar5, aVar4.f2639au);
                    aVar5.setReferencedIds(aVar4.f2638at);
                }
                aVar5.setType(aVar4.f2636ar);
                C0795a a = constraintLayout.generateDefaultLayoutParams();
                aVar5.mo3277b();
                aVar4.mo3300a(a);
                constraintLayout.addView(aVar5, a);
            }
            if (aVar4.f2615a) {
                C0814h hVar = new C0814h(constraintLayout.getContext());
                hVar.setId(num.intValue());
                C0795a a2 = constraintLayout.generateDefaultLayoutParams();
                aVar4.mo3300a(a2);
                constraintLayout.addView(hVar, a2);
            }
        }
    }

    /* renamed from: a */
    public void mo3290a(int i, float f) {
        m3019a(i).f2664u = f;
    }

    /* renamed from: b */
    public void mo3295b(int i, float f) {
        m3019a(i).f2665v = f;
    }

    /* renamed from: a */
    private C0810a m3019a(int i) {
        if (!this.f2588c.containsKey(Integer.valueOf(i))) {
            this.f2588c.put(Integer.valueOf(i), new C0810a());
        }
        return (C0810a) this.f2588c.get(Integer.valueOf(i));
    }

    /* renamed from: b */
    public void mo3296b(Context context, int i) {
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType != 0) {
                    switch (eventType) {
                        case 2:
                            String name = xml.getName();
                            C0810a a = m3020a(context, Xml.asAttributeSet(xml));
                            if (name.equalsIgnoreCase("Guideline")) {
                                a.f2615a = true;
                            }
                            this.f2588c.put(Integer.valueOf(a.f2647d), a);
                            break;
                        case 3:
                            break;
                    }
                } else {
                    xml.getName();
                }
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: a */
    public void mo3292a(Context context, XmlPullParser xmlPullParser) {
        C0810a a;
        try {
            int eventType = xmlPullParser.getEventType();
            C0810a aVar = null;
            while (eventType != 1) {
                if (eventType != 0) {
                    switch (eventType) {
                        case 2:
                            String name = xmlPullParser.getName();
                            if (!name.equalsIgnoreCase("Constraint")) {
                                if (!name.equalsIgnoreCase("Guideline")) {
                                    if (!name.equalsIgnoreCase("CustomAttribute")) {
                                        break;
                                    } else {
                                        C0802b.m3002a(context, xmlPullParser, aVar.f2618aC);
                                        break;
                                    }
                                } else {
                                    a = m3020a(context, Xml.asAttributeSet(xmlPullParser));
                                    a.f2615a = true;
                                }
                            } else {
                                a = m3020a(context, Xml.asAttributeSet(xmlPullParser));
                            }
                            aVar = a;
                            break;
                        case 3:
                            String name2 = xmlPullParser.getName();
                            if (!"ConstraintSet".equals(name2)) {
                                if (!name2.equalsIgnoreCase("Constraint")) {
                                    break;
                                } else {
                                    this.f2588c.put(Integer.valueOf(aVar.f2647d), aVar);
                                    aVar = null;
                                    break;
                                }
                            } else {
                                return;
                            }
                    }
                } else {
                    xmlPullParser.getName();
                }
                eventType = xmlPullParser.next();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: a */
    private static int m3018a(TypedArray typedArray, int i, int i2) {
        int resourceId = typedArray.getResourceId(i, i2);
        return resourceId == -1 ? typedArray.getInt(i, -1) : resourceId;
    }

    /* renamed from: a */
    private C0810a m3020a(Context context, AttributeSet attributeSet) {
        C0810a aVar = new C0810a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ConstraintSet);
        m3021a(aVar, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        return aVar;
    }

    /* renamed from: a */
    private void m3021a(C0810a aVar, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArray.getIndex(i);
            int i2 = f2586d.get(index);
            switch (i2) {
                case 1:
                    aVar.f2659p = m3018a(typedArray, index, aVar.f2659p);
                    break;
                case 2:
                    aVar.f2595G = typedArray.getDimensionPixelSize(index, aVar.f2595G);
                    break;
                case 3:
                    aVar.f2658o = m3018a(typedArray, index, aVar.f2658o);
                    break;
                case 4:
                    aVar.f2657n = m3018a(typedArray, index, aVar.f2657n);
                    break;
                case 5:
                    aVar.f2666w = typedArray.getString(index);
                    break;
                case 6:
                    aVar.f2589A = typedArray.getDimensionPixelOffset(index, aVar.f2589A);
                    break;
                case 7:
                    aVar.f2590B = typedArray.getDimensionPixelOffset(index, aVar.f2590B);
                    break;
                case 8:
                    aVar.f2596H = typedArray.getDimensionPixelSize(index, aVar.f2596H);
                    break;
                case 9:
                    aVar.f2663t = m3018a(typedArray, index, aVar.f2663t);
                    break;
                case 10:
                    aVar.f2662s = m3018a(typedArray, index, aVar.f2662s);
                    break;
                case 11:
                    aVar.f2602N = typedArray.getDimensionPixelSize(index, aVar.f2602N);
                    break;
                case 12:
                    aVar.f2603O = typedArray.getDimensionPixelSize(index, aVar.f2603O);
                    break;
                case 13:
                    aVar.f2599K = typedArray.getDimensionPixelSize(index, aVar.f2599K);
                    break;
                case 14:
                    aVar.f2601M = typedArray.getDimensionPixelSize(index, aVar.f2601M);
                    break;
                case 15:
                    aVar.f2604P = typedArray.getDimensionPixelSize(index, aVar.f2604P);
                    break;
                case 16:
                    aVar.f2600L = typedArray.getDimensionPixelSize(index, aVar.f2600L);
                    break;
                case 17:
                    aVar.f2648e = typedArray.getDimensionPixelOffset(index, aVar.f2648e);
                    break;
                case 18:
                    aVar.f2649f = typedArray.getDimensionPixelOffset(index, aVar.f2649f);
                    break;
                case 19:
                    aVar.f2650g = typedArray.getFloat(index, aVar.f2650g);
                    break;
                case 20:
                    aVar.f2664u = typedArray.getFloat(index, aVar.f2664u);
                    break;
                case 21:
                    aVar.f2646c = typedArray.getLayoutDimension(index, aVar.f2646c);
                    break;
                case 22:
                    aVar.f2598J = typedArray.getInt(index, aVar.f2598J);
                    aVar.f2598J = f2585b[aVar.f2598J];
                    break;
                case 23:
                    aVar.f2645b = typedArray.getLayoutDimension(index, aVar.f2645b);
                    break;
                case 24:
                    aVar.f2592D = typedArray.getDimensionPixelSize(index, aVar.f2592D);
                    break;
                case 25:
                    aVar.f2651h = m3018a(typedArray, index, aVar.f2651h);
                    break;
                case 26:
                    aVar.f2652i = m3018a(typedArray, index, aVar.f2652i);
                    break;
                case 27:
                    aVar.f2591C = typedArray.getInt(index, aVar.f2591C);
                    break;
                case 28:
                    aVar.f2593E = typedArray.getDimensionPixelSize(index, aVar.f2593E);
                    break;
                case 29:
                    aVar.f2653j = m3018a(typedArray, index, aVar.f2653j);
                    break;
                case 30:
                    aVar.f2654k = m3018a(typedArray, index, aVar.f2654k);
                    break;
                case 31:
                    aVar.f2597I = typedArray.getDimensionPixelSize(index, aVar.f2597I);
                    break;
                case 32:
                    aVar.f2660q = m3018a(typedArray, index, aVar.f2660q);
                    break;
                case 33:
                    aVar.f2661r = m3018a(typedArray, index, aVar.f2661r);
                    break;
                case 34:
                    aVar.f2594F = typedArray.getDimensionPixelSize(index, aVar.f2594F);
                    break;
                case 35:
                    aVar.f2656m = m3018a(typedArray, index, aVar.f2656m);
                    break;
                case 36:
                    aVar.f2655l = m3018a(typedArray, index, aVar.f2655l);
                    break;
                case 37:
                    aVar.f2665v = typedArray.getFloat(index, aVar.f2665v);
                    break;
                case 38:
                    aVar.f2647d = typedArray.getResourceId(index, aVar.f2647d);
                    break;
                case 39:
                    aVar.f2606R = typedArray.getFloat(index, aVar.f2606R);
                    break;
                case 40:
                    aVar.f2605Q = typedArray.getFloat(index, aVar.f2605Q);
                    break;
                case 41:
                    aVar.f2607S = typedArray.getInt(index, aVar.f2607S);
                    break;
                case 42:
                    aVar.f2608T = typedArray.getInt(index, aVar.f2608T);
                    break;
                case 43:
                    aVar.f2609U = typedArray.getFloat(index, aVar.f2609U);
                    break;
                case 44:
                    aVar.f2610V = true;
                    aVar.f2611W = typedArray.getDimension(index, aVar.f2611W);
                    break;
                case 45:
                    aVar.f2613Y = typedArray.getFloat(index, aVar.f2613Y);
                    break;
                case 46:
                    aVar.f2614Z = typedArray.getFloat(index, aVar.f2614Z);
                    break;
                case 47:
                    aVar.f2619aa = typedArray.getFloat(index, aVar.f2619aa);
                    break;
                case 48:
                    aVar.f2620ab = typedArray.getFloat(index, aVar.f2620ab);
                    break;
                case 49:
                    aVar.f2621ac = typedArray.getFloat(index, aVar.f2621ac);
                    break;
                case 50:
                    aVar.f2622ad = typedArray.getFloat(index, aVar.f2622ad);
                    break;
                case 51:
                    aVar.f2623ae = typedArray.getDimension(index, aVar.f2623ae);
                    break;
                case 52:
                    aVar.f2624af = typedArray.getDimension(index, aVar.f2624af);
                    break;
                case 53:
                    if (VERSION.SDK_INT < 21) {
                        break;
                    } else {
                        aVar.f2625ag = typedArray.getDimension(index, aVar.f2625ag);
                        break;
                    }
                default:
                    switch (i2) {
                        case 60:
                            aVar.f2612X = typedArray.getFloat(index, aVar.f2612X);
                            break;
                        case 61:
                            aVar.f2667x = m3018a(typedArray, index, aVar.f2667x);
                            break;
                        case 62:
                            aVar.f2668y = typedArray.getDimensionPixelSize(index, aVar.f2668y);
                            break;
                        case 63:
                            aVar.f2669z = typedArray.getFloat(index, aVar.f2669z);
                            break;
                        case 64:
                            aVar.f2640av = m3018a(typedArray, index, aVar.f2640av);
                            break;
                        case 65:
                            if (typedArray.peekValue(index).type != 3) {
                                aVar.f2641aw = C0754a.f2164c[typedArray.getInteger(index, 0)];
                                break;
                            } else {
                                aVar.f2641aw = typedArray.getString(index);
                                break;
                            }
                        case 66:
                            aVar.f2643ay = typedArray.getInt(index, 0);
                            break;
                        case 67:
                            aVar.f2644az = typedArray.getFloat(index, aVar.f2644az);
                            break;
                        case 68:
                            aVar.f2616aA = typedArray.getFloat(index, aVar.f2616aA);
                            break;
                        case 69:
                            aVar.f2634ap = typedArray.getFloat(index, 1.0f);
                            break;
                        case 70:
                            aVar.f2635aq = typedArray.getFloat(index, 1.0f);
                            break;
                        case 71:
                            Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                            break;
                        case 72:
                            aVar.f2636ar = typedArray.getInt(index, aVar.f2636ar);
                            break;
                        case 73:
                            aVar.f2639au = typedArray.getString(index);
                            break;
                        case 74:
                            aVar.f2617aB = typedArray.getBoolean(index, aVar.f2617aB);
                            break;
                        case 75:
                            aVar.f2642ax = typedArray.getInt(index, aVar.f2642ax);
                            break;
                        case 76:
                            StringBuilder sb = new StringBuilder();
                            sb.append("unused attribute 0x");
                            sb.append(Integer.toHexString(index));
                            sb.append("   ");
                            sb.append(f2586d.get(index));
                            Log.w("ConstraintSet", sb.toString());
                            break;
                        default:
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Unknown attribute 0x");
                            sb2.append(Integer.toHexString(index));
                            sb2.append("   ");
                            sb2.append(f2586d.get(index));
                            Log.w("ConstraintSet", sb2.toString());
                            break;
                    }
            }
        }
    }

    /* renamed from: a */
    private int[] m3022a(View view, String str) {
        int i;
        String[] split = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[split.length];
        int i2 = 0;
        int i3 = 0;
        while (i2 < split.length) {
            String trim = split[i2].trim();
            try {
                i = id.class.getField(trim).getInt(null);
            } catch (Exception unused) {
                i = 0;
            }
            if (i == 0) {
                i = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout)) {
                Object a = ((ConstraintLayout) view.getParent()).mo3237a(0, (Object) trim);
                if (a != null && (a instanceof Integer)) {
                    i = ((Integer) a).intValue();
                }
            }
            int i4 = i3 + 1;
            iArr[i3] = i;
            i2++;
            i3 = i4;
        }
        return i3 != split.length ? Arrays.copyOf(iArr, i3) : iArr;
    }
}
