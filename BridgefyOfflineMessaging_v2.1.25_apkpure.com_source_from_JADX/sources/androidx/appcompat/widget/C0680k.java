package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import androidx.appcompat.R;
import androidx.appcompat.p047a.p048a.C0424a;
import androidx.appcompat.p049b.p050a.C0488a;
import androidx.core.content.C0875a;
import androidx.core.graphics.C0977a;
import androidx.core.graphics.drawable.C0983a;
import androidx.p052b.C0712a;
import androidx.p052b.C0717d;
import androidx.p052b.C0718e;
import androidx.p052b.C0726h;
import androidx.vectordrawable.p089a.p090a.C1438c;
import androidx.vectordrawable.p089a.p090a.C1448i;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: androidx.appcompat.widget.k */
/* compiled from: AppCompatDrawableManager */
public final class C0680k {

    /* renamed from: a */
    private static final Mode f1980a = Mode.SRC_IN;

    /* renamed from: b */
    private static C0680k f1981b;

    /* renamed from: c */
    private static final C0683c f1982c = new C0683c(6);

    /* renamed from: d */
    private static final int[] f1983d = {R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};

    /* renamed from: e */
    private static final int[] f1984e = {R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};

    /* renamed from: f */
    private static final int[] f1985f = {R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl_dark, R.drawable.abc_text_select_handle_middle_mtrl_dark, R.drawable.abc_text_select_handle_right_mtrl_dark, R.drawable.abc_text_select_handle_left_mtrl_light, R.drawable.abc_text_select_handle_middle_mtrl_light, R.drawable.abc_text_select_handle_right_mtrl_light};

    /* renamed from: g */
    private static final int[] f1986g = {R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};

    /* renamed from: h */
    private static final int[] f1987h = {R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};

    /* renamed from: i */
    private static final int[] f1988i = {R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material};

    /* renamed from: j */
    private WeakHashMap<Context, C0726h<ColorStateList>> f1989j;

    /* renamed from: k */
    private C0712a<String, C0684d> f1990k;

    /* renamed from: l */
    private C0726h<String> f1991l;

    /* renamed from: m */
    private final WeakHashMap<Context, C0717d<WeakReference<ConstantState>>> f1992m = new WeakHashMap<>(0);

    /* renamed from: n */
    private TypedValue f1993n;

    /* renamed from: o */
    private boolean f1994o;

    /* renamed from: androidx.appcompat.widget.k$a */
    /* compiled from: AppCompatDrawableManager */
    static class C0681a implements C0684d {
        C0681a() {
        }

        /* renamed from: a */
        public Drawable mo2595a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            try {
                return C0488a.m1550a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e);
                return null;
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.k$b */
    /* compiled from: AppCompatDrawableManager */
    private static class C0682b implements C0684d {
        C0682b() {
        }

        /* renamed from: a */
        public Drawable mo2595a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            try {
                return C1438c.m5728a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e);
                return null;
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.k$c */
    /* compiled from: AppCompatDrawableManager */
    private static class C0683c extends C0718e<Integer, PorterDuffColorFilter> {
        public C0683c(int i) {
            super(i);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public PorterDuffColorFilter mo2596a(int i, Mode mode) {
            return (PorterDuffColorFilter) get(Integer.valueOf(m2423b(i, mode)));
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public PorterDuffColorFilter mo2597a(int i, Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) put(Integer.valueOf(m2423b(i, mode)), porterDuffColorFilter);
        }

        /* renamed from: b */
        private static int m2423b(int i, Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }
    }

    /* renamed from: androidx.appcompat.widget.k$d */
    /* compiled from: AppCompatDrawableManager */
    private interface C0684d {
        /* renamed from: a */
        Drawable mo2595a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme);
    }

    /* renamed from: androidx.appcompat.widget.k$e */
    /* compiled from: AppCompatDrawableManager */
    private static class C0685e implements C0684d {
        C0685e() {
        }

        /* renamed from: a */
        public Drawable mo2595a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            try {
                return C1448i.m5762a(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e);
                return null;
            }
        }
    }

    /* renamed from: a */
    public static synchronized C0680k m2397a() {
        C0680k kVar;
        synchronized (C0680k.class) {
            if (f1981b == null) {
                f1981b = new C0680k();
                m2401a(f1981b);
            }
            kVar = f1981b;
        }
        return kVar;
    }

    /* renamed from: a */
    private static void m2401a(C0680k kVar) {
        if (VERSION.SDK_INT < 24) {
            kVar.m2402a("vector", (C0684d) new C0685e());
            kVar.m2402a("animated-vector", (C0684d) new C0682b());
            kVar.m2402a("animated-selector", (C0684d) new C0681a());
        }
    }

    /* renamed from: a */
    public synchronized Drawable mo2590a(Context context, int i) {
        return mo2591a(context, i, false);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public synchronized Drawable mo2591a(Context context, int i, boolean z) {
        Drawable d;
        m2415f(context);
        d = m2411d(context, i);
        if (d == null) {
            d = m2409c(context, i);
        }
        if (d == null) {
            d = C0875a.m3239a(context, i);
        }
        if (d != null) {
            d = m2395a(context, i, z, d);
        }
        if (d != null) {
            C0607ad.m2104b(d);
        }
        return d;
    }

    /* renamed from: a */
    public synchronized void mo2593a(Context context) {
        C0717d dVar = (C0717d) this.f1992m.get(context);
        if (dVar != null) {
            dVar.mo2788c();
        }
    }

    /* renamed from: a */
    private static long m2391a(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    /* renamed from: c */
    private Drawable m2409c(Context context, int i) {
        if (this.f1993n == null) {
            this.f1993n = new TypedValue();
        }
        TypedValue typedValue = this.f1993n;
        context.getResources().getValue(i, typedValue, true);
        long a = m2391a(typedValue);
        Drawable a2 = m2396a(context, a);
        if (a2 != null) {
            return a2;
        }
        if (i == R.drawable.abc_cab_background_top_material) {
            a2 = new LayerDrawable(new Drawable[]{mo2590a(context, R.drawable.abc_cab_background_internal_bg), mo2590a(context, R.drawable.abc_cab_background_top_mtrl_alpha)});
        }
        if (a2 != null) {
            a2.setChangingConfigurations(typedValue.changingConfigurations);
            m2404a(context, a, a2);
        }
        return a2;
    }

    /* renamed from: a */
    private Drawable m2395a(Context context, int i, boolean z, Drawable drawable) {
        ColorStateList b = mo2594b(context, i);
        if (b != null) {
            if (C0607ad.m2105c(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable g = C0983a.m3709g(drawable);
            C0983a.m3698a(g, b);
            Mode a = m2392a(i);
            if (a == null) {
                return g;
            }
            C0983a.m3701a(g, a);
            return g;
        } else if (i == R.drawable.abc_seekbar_track_material) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            m2399a(layerDrawable.findDrawableByLayerId(16908288), C0640aq.m2218a(context, R.attr.colorControlNormal), f1980a);
            m2399a(layerDrawable.findDrawableByLayerId(16908303), C0640aq.m2218a(context, R.attr.colorControlNormal), f1980a);
            m2399a(layerDrawable.findDrawableByLayerId(16908301), C0640aq.m2218a(context, R.attr.colorControlActivated), f1980a);
            return drawable;
        } else if (i == R.drawable.abc_ratingbar_material || i == R.drawable.abc_ratingbar_indicator_material || i == R.drawable.abc_ratingbar_small_material) {
            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
            m2399a(layerDrawable2.findDrawableByLayerId(16908288), C0640aq.m2222c(context, R.attr.colorControlNormal), f1980a);
            m2399a(layerDrawable2.findDrawableByLayerId(16908303), C0640aq.m2218a(context, R.attr.colorControlActivated), f1980a);
            m2399a(layerDrawable2.findDrawableByLayerId(16908301), C0640aq.m2218a(context, R.attr.colorControlActivated), f1980a);
            return drawable;
        } else if (m2403a(context, i, drawable) || !z) {
            return drawable;
        } else {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0079 A[Catch:{ Exception -> 0x00a8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a0 A[Catch:{ Exception -> 0x00a8 }] */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable m2411d(android.content.Context r10, int r11) {
        /*
            r9 = this;
            androidx.b.a<java.lang.String, androidx.appcompat.widget.k$d> r0 = r9.f1990k
            r1 = 0
            if (r0 == 0) goto L_0x00ba
            androidx.b.a<java.lang.String, androidx.appcompat.widget.k$d> r0 = r9.f1990k
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x00ba
            androidx.b.h<java.lang.String> r0 = r9.f1991l
            if (r0 == 0) goto L_0x002c
            androidx.b.h<java.lang.String> r0 = r9.f1991l
            java.lang.Object r0 = r0.mo2895a(r11)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r2 = "appcompat_skip_skip"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x002b
            if (r0 == 0) goto L_0x0033
            androidx.b.a<java.lang.String, androidx.appcompat.widget.k$d> r2 = r9.f1990k
            java.lang.Object r0 = r2.get(r0)
            if (r0 != 0) goto L_0x0033
        L_0x002b:
            return r1
        L_0x002c:
            androidx.b.h r0 = new androidx.b.h
            r0.<init>()
            r9.f1991l = r0
        L_0x0033:
            android.util.TypedValue r0 = r9.f1993n
            if (r0 != 0) goto L_0x003e
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            r9.f1993n = r0
        L_0x003e:
            android.util.TypedValue r0 = r9.f1993n
            android.content.res.Resources r1 = r10.getResources()
            r2 = 1
            r1.getValue(r11, r0, r2)
            long r3 = m2391a(r0)
            android.graphics.drawable.Drawable r5 = r9.m2396a(r10, r3)
            if (r5 == 0) goto L_0x0053
            return r5
        L_0x0053:
            java.lang.CharSequence r6 = r0.string
            if (r6 == 0) goto L_0x00b0
            java.lang.CharSequence r6 = r0.string
            java.lang.String r6 = r6.toString()
            java.lang.String r7 = ".xml"
            boolean r6 = r6.endsWith(r7)
            if (r6 == 0) goto L_0x00b0
            android.content.res.XmlResourceParser r1 = r1.getXml(r11)     // Catch:{ Exception -> 0x00a8 }
            android.util.AttributeSet r6 = android.util.Xml.asAttributeSet(r1)     // Catch:{ Exception -> 0x00a8 }
        L_0x006d:
            int r7 = r1.next()     // Catch:{ Exception -> 0x00a8 }
            r8 = 2
            if (r7 == r8) goto L_0x0077
            if (r7 == r2) goto L_0x0077
            goto L_0x006d
        L_0x0077:
            if (r7 != r8) goto L_0x00a0
            java.lang.String r2 = r1.getName()     // Catch:{ Exception -> 0x00a8 }
            androidx.b.h<java.lang.String> r7 = r9.f1991l     // Catch:{ Exception -> 0x00a8 }
            r7.mo2902c(r11, r2)     // Catch:{ Exception -> 0x00a8 }
            androidx.b.a<java.lang.String, androidx.appcompat.widget.k$d> r7 = r9.f1990k     // Catch:{ Exception -> 0x00a8 }
            java.lang.Object r2 = r7.get(r2)     // Catch:{ Exception -> 0x00a8 }
            androidx.appcompat.widget.k$d r2 = (androidx.appcompat.widget.C0680k.C0684d) r2     // Catch:{ Exception -> 0x00a8 }
            if (r2 == 0) goto L_0x0095
            android.content.res.Resources$Theme r7 = r10.getTheme()     // Catch:{ Exception -> 0x00a8 }
            android.graphics.drawable.Drawable r1 = r2.mo2595a(r10, r1, r6, r7)     // Catch:{ Exception -> 0x00a8 }
            r5 = r1
        L_0x0095:
            if (r5 == 0) goto L_0x00b0
            int r0 = r0.changingConfigurations     // Catch:{ Exception -> 0x00a8 }
            r5.setChangingConfigurations(r0)     // Catch:{ Exception -> 0x00a8 }
            r9.m2404a(r10, r3, r5)     // Catch:{ Exception -> 0x00a8 }
            goto L_0x00b0
        L_0x00a0:
            org.xmlpull.v1.XmlPullParserException r10 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ Exception -> 0x00a8 }
            java.lang.String r0 = "No start tag found"
            r10.<init>(r0)     // Catch:{ Exception -> 0x00a8 }
            throw r10     // Catch:{ Exception -> 0x00a8 }
        L_0x00a8:
            r10 = move-exception
            java.lang.String r0 = "AppCompatDrawableManag"
            java.lang.String r1 = "Exception while inflating drawable"
            android.util.Log.e(r0, r1, r10)
        L_0x00b0:
            if (r5 != 0) goto L_0x00b9
            androidx.b.h<java.lang.String> r10 = r9.f1991l
            java.lang.String r0 = "appcompat_skip_skip"
            r10.mo2902c(r11, r0)
        L_0x00b9:
            return r5
        L_0x00ba:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0680k.m2411d(android.content.Context, int):android.graphics.drawable.Drawable");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002c, code lost:
        return null;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized android.graphics.drawable.Drawable m2396a(android.content.Context r4, long r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.WeakHashMap<android.content.Context, androidx.b.d<java.lang.ref.WeakReference<android.graphics.drawable.Drawable$ConstantState>>> r0 = r3.f1992m     // Catch:{ all -> 0x002d }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x002d }
            androidx.b.d r0 = (androidx.p052b.C0717d) r0     // Catch:{ all -> 0x002d }
            r1 = 0
            if (r0 != 0) goto L_0x000e
            monitor-exit(r3)
            return r1
        L_0x000e:
            java.lang.Object r2 = r0.mo2779a(r5)     // Catch:{ all -> 0x002d }
            java.lang.ref.WeakReference r2 = (java.lang.ref.WeakReference) r2     // Catch:{ all -> 0x002d }
            if (r2 == 0) goto L_0x002b
            java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x002d }
            android.graphics.drawable.Drawable$ConstantState r2 = (android.graphics.drawable.Drawable.ConstantState) r2     // Catch:{ all -> 0x002d }
            if (r2 == 0) goto L_0x0028
            android.content.res.Resources r4 = r4.getResources()     // Catch:{ all -> 0x002d }
            android.graphics.drawable.Drawable r4 = r2.newDrawable(r4)     // Catch:{ all -> 0x002d }
            monitor-exit(r3)
            return r4
        L_0x0028:
            r0.mo2784b(r5)     // Catch:{ all -> 0x002d }
        L_0x002b:
            monitor-exit(r3)
            return r1
        L_0x002d:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0680k.m2396a(android.content.Context, long):android.graphics.drawable.Drawable");
    }

    /* renamed from: a */
    private synchronized boolean m2404a(Context context, long j, Drawable drawable) {
        ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        C0717d dVar = (C0717d) this.f1992m.get(context);
        if (dVar == null) {
            dVar = new C0717d();
            this.f1992m.put(context, dVar);
        }
        dVar.mo2785b(j, new WeakReference(constantState));
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public synchronized Drawable mo2592a(Context context, C0655ba baVar, int i) {
        Drawable d = m2411d(context, i);
        if (d == null) {
            d = baVar.mo2489a(i);
        }
        if (d == null) {
            return null;
        }
        return m2395a(context, i, false, d);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0061 A[RETURN] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean m2403a(android.content.Context r6, int r7, android.graphics.drawable.Drawable r8) {
        /*
            android.graphics.PorterDuff$Mode r0 = f1980a
            int[] r1 = f1983d
            boolean r1 = m2406a(r1, r7)
            r2 = 16842801(0x1010031, float:2.3693695E-38)
            r3 = -1
            r4 = 0
            r5 = 1
            if (r1 == 0) goto L_0x0015
            int r2 = androidx.appcompat.R.attr.colorControlNormal
        L_0x0012:
            r7 = 1
            r1 = -1
            goto L_0x0044
        L_0x0015:
            int[] r1 = f1985f
            boolean r1 = m2406a(r1, r7)
            if (r1 == 0) goto L_0x0020
            int r2 = androidx.appcompat.R.attr.colorControlActivated
            goto L_0x0012
        L_0x0020:
            int[] r1 = f1986g
            boolean r1 = m2406a(r1, r7)
            if (r1 == 0) goto L_0x002b
            android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
            goto L_0x0012
        L_0x002b:
            int r1 = androidx.appcompat.R.drawable.abc_list_divider_mtrl_alpha
            if (r7 != r1) goto L_0x003c
            r2 = 16842800(0x1010030, float:2.3693693E-38)
            r7 = 1109603123(0x42233333, float:40.8)
            int r7 = java.lang.Math.round(r7)
            r1 = r7
            r7 = 1
            goto L_0x0044
        L_0x003c:
            int r1 = androidx.appcompat.R.drawable.abc_dialog_material_background
            if (r7 != r1) goto L_0x0041
            goto L_0x0012
        L_0x0041:
            r7 = 0
            r1 = -1
            r2 = 0
        L_0x0044:
            if (r7 == 0) goto L_0x0061
            boolean r7 = androidx.appcompat.widget.C0607ad.m2105c(r8)
            if (r7 == 0) goto L_0x0050
            android.graphics.drawable.Drawable r8 = r8.mutate()
        L_0x0050:
            int r6 = androidx.appcompat.widget.C0640aq.m2218a(r6, r2)
            android.graphics.PorterDuffColorFilter r6 = m2393a(r6, r0)
            r8.setColorFilter(r6)
            if (r1 == r3) goto L_0x0060
            r8.setAlpha(r1)
        L_0x0060:
            return r5
        L_0x0061:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0680k.m2403a(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
    }

    /* renamed from: a */
    private void m2402a(String str, C0684d dVar) {
        if (this.f1990k == null) {
            this.f1990k = new C0712a<>();
        }
        this.f1990k.put(str, dVar);
    }

    /* renamed from: a */
    private static boolean m2406a(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    static Mode m2392a(int i) {
        if (i == R.drawable.abc_switch_thumb_material) {
            return Mode.MULTIPLY;
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public synchronized ColorStateList mo2594b(Context context, int i) {
        ColorStateList e;
        e = m2413e(context, i);
        if (e == null) {
            if (i == R.drawable.abc_edit_text_material) {
                e = C0424a.m1267a(context, R.color.abc_tint_edittext);
            } else if (i == R.drawable.abc_switch_track_mtrl_alpha) {
                e = C0424a.m1267a(context, R.color.abc_tint_switch_track);
            } else if (i == R.drawable.abc_switch_thumb_material) {
                e = m2412e(context);
            } else if (i == R.drawable.abc_btn_default_mtrl_shape) {
                e = m2407b(context);
            } else if (i == R.drawable.abc_btn_borderless_material) {
                e = m2408c(context);
            } else if (i == R.drawable.abc_btn_colored_material) {
                e = m2410d(context);
            } else {
                if (i != R.drawable.abc_spinner_mtrl_am_alpha) {
                    if (i != R.drawable.abc_spinner_textfield_background_material) {
                        if (m2406a(f1984e, i)) {
                            e = C0640aq.m2221b(context, R.attr.colorControlNormal);
                        } else if (m2406a(f1987h, i)) {
                            e = C0424a.m1267a(context, R.color.abc_tint_default);
                        } else if (m2406a(f1988i, i)) {
                            e = C0424a.m1267a(context, R.color.abc_tint_btn_checkable);
                        } else if (i == R.drawable.abc_seekbar_thumb_material) {
                            e = C0424a.m1267a(context, R.color.abc_tint_seek_thumb);
                        }
                    }
                }
                e = C0424a.m1267a(context, R.color.abc_tint_spinner);
            }
            if (e != null) {
                m2398a(context, i, e);
            }
        }
        return e;
    }

    /* renamed from: e */
    private ColorStateList m2413e(Context context, int i) {
        ColorStateList colorStateList = null;
        if (this.f1989j == null) {
            return null;
        }
        C0726h hVar = (C0726h) this.f1989j.get(context);
        if (hVar != null) {
            colorStateList = (ColorStateList) hVar.mo2895a(i);
        }
        return colorStateList;
    }

    /* renamed from: a */
    private void m2398a(Context context, int i, ColorStateList colorStateList) {
        if (this.f1989j == null) {
            this.f1989j = new WeakHashMap<>();
        }
        C0726h hVar = (C0726h) this.f1989j.get(context);
        if (hVar == null) {
            hVar = new C0726h();
            this.f1989j.put(context, hVar);
        }
        hVar.mo2902c(i, colorStateList);
    }

    /* renamed from: b */
    private ColorStateList m2407b(Context context) {
        return m2414f(context, C0640aq.m2218a(context, R.attr.colorButtonNormal));
    }

    /* renamed from: c */
    private ColorStateList m2408c(Context context) {
        return m2414f(context, 0);
    }

    /* renamed from: d */
    private ColorStateList m2410d(Context context) {
        return m2414f(context, C0640aq.m2218a(context, R.attr.colorAccent));
    }

    /* renamed from: f */
    private ColorStateList m2414f(Context context, int i) {
        int a = C0640aq.m2218a(context, R.attr.colorControlHighlight);
        return new ColorStateList(new int[][]{C0640aq.f1841a, C0640aq.f1844d, C0640aq.f1842b, C0640aq.f1848h}, new int[]{C0640aq.m2222c(context, R.attr.colorButtonNormal), C0977a.m3658a(a, i), C0977a.m3658a(a, i), i});
    }

    /* renamed from: e */
    private ColorStateList m2412e(Context context) {
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList b = C0640aq.m2221b(context, R.attr.colorSwitchThumbNormal);
        if (b == null || !b.isStateful()) {
            iArr[0] = C0640aq.f1841a;
            iArr2[0] = C0640aq.m2222c(context, R.attr.colorSwitchThumbNormal);
            iArr[1] = C0640aq.f1845e;
            iArr2[1] = C0640aq.m2218a(context, R.attr.colorControlActivated);
            iArr[2] = C0640aq.f1848h;
            iArr2[2] = C0640aq.m2218a(context, R.attr.colorSwitchThumbNormal);
        } else {
            iArr[0] = C0640aq.f1841a;
            iArr2[0] = b.getColorForState(iArr[0], 0);
            iArr[1] = C0640aq.f1845e;
            iArr2[1] = C0640aq.m2218a(context, R.attr.colorControlActivated);
            iArr[2] = C0640aq.f1848h;
            iArr2[2] = b.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }

    /* renamed from: a */
    static void m2400a(Drawable drawable, C0643at atVar, int[] iArr) {
        if (!C0607ad.m2105c(drawable) || drawable.mutate() == drawable) {
            if (atVar.f1858d || atVar.f1857c) {
                drawable.setColorFilter(m2394a(atVar.f1858d ? atVar.f1855a : null, atVar.f1857c ? atVar.f1856b : f1980a, iArr));
            } else {
                drawable.clearColorFilter();
            }
            if (VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
            }
            return;
        }
        Log.d("AppCompatDrawableManag", "Mutated drawable is not the same instance as the input.");
    }

    /* renamed from: a */
    private static PorterDuffColorFilter m2394a(ColorStateList colorStateList, Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return m2393a(colorStateList.getColorForState(iArr, 0), mode);
    }

    /* renamed from: a */
    public static synchronized PorterDuffColorFilter m2393a(int i, Mode mode) {
        PorterDuffColorFilter a;
        synchronized (C0680k.class) {
            a = f1982c.mo2596a(i, mode);
            if (a == null) {
                a = new PorterDuffColorFilter(i, mode);
                f1982c.mo2597a(i, mode, a);
            }
        }
        return a;
    }

    /* renamed from: a */
    private static void m2399a(Drawable drawable, int i, Mode mode) {
        if (C0607ad.m2105c(drawable)) {
            drawable = drawable.mutate();
        }
        if (mode == null) {
            mode = f1980a;
        }
        drawable.setColorFilter(m2393a(i, mode));
    }

    /* renamed from: f */
    private void m2415f(Context context) {
        if (!this.f1994o) {
            this.f1994o = true;
            Drawable a = mo2590a(context, R.drawable.abc_vector_test);
            if (a == null || !m2405a(a)) {
                this.f1994o = false;
                throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
            }
        }
    }

    /* renamed from: a */
    private static boolean m2405a(Drawable drawable) {
        return (drawable instanceof C1448i) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }
}
