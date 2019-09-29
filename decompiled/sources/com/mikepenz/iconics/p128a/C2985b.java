package com.mikepenz.iconics.p128a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.text.TextUtils;
import androidx.customview.p073b.C1024a;
import com.mikepenz.iconics.C2994b;

/* renamed from: com.mikepenz.iconics.a.b */
/* compiled from: IconicsAttrsExtractor */
public class C2985b {

    /* renamed from: a */
    private final Context f7774a;

    /* renamed from: b */
    private final TypedArray f7775b;

    /* renamed from: c */
    private int f7776c;

    /* renamed from: d */
    private int f7777d;

    /* renamed from: e */
    private int f7778e;

    /* renamed from: f */
    private int f7779f;

    /* renamed from: g */
    private int f7780g;

    /* renamed from: h */
    private int f7781h;

    /* renamed from: i */
    private int f7782i;

    /* renamed from: j */
    private int f7783j;

    /* renamed from: k */
    private int f7784k;

    /* renamed from: l */
    private int f7785l;

    /* renamed from: m */
    private int f7786m;

    /* renamed from: n */
    private int f7787n;

    public C2985b(Context context, TypedArray typedArray) {
        this.f7774a = context;
        this.f7775b = typedArray;
    }

    /* renamed from: a */
    public C2985b mo27310a(int i) {
        this.f7776c = i;
        return this;
    }

    /* renamed from: b */
    public C2985b mo27312b(int i) {
        this.f7777d = i;
        return this;
    }

    /* renamed from: c */
    public C2985b mo27313c(int i) {
        this.f7778e = i;
        return this;
    }

    /* renamed from: d */
    public C2985b mo27314d(int i) {
        this.f7779f = i;
        return this;
    }

    /* renamed from: e */
    public C2985b mo27315e(int i) {
        this.f7780g = i;
        return this;
    }

    /* renamed from: f */
    public C2985b mo27316f(int i) {
        this.f7781h = i;
        return this;
    }

    /* renamed from: g */
    public C2985b mo27317g(int i) {
        this.f7782i = i;
        return this;
    }

    /* renamed from: h */
    public C2985b mo27318h(int i) {
        this.f7783j = i;
        return this;
    }

    /* renamed from: i */
    public C2985b mo27319i(int i) {
        this.f7784k = i;
        return this;
    }

    /* renamed from: j */
    public C2985b mo27320j(int i) {
        this.f7785l = i;
        return this;
    }

    /* renamed from: k */
    public C2985b mo27321k(int i) {
        this.f7786m = i;
        return this;
    }

    /* renamed from: l */
    public C2985b mo27322l(int i) {
        this.f7787n = i;
        return this;
    }

    /* renamed from: a */
    public C2994b mo27311a() {
        return m8795a(null, true, false);
    }

    /* renamed from: a */
    private C2994b m8795a(C2994b bVar, boolean z, boolean z2) {
        C2994b a = m8793a(bVar);
        String string = this.f7775b.getString(this.f7776c);
        if (!TextUtils.isEmpty(string)) {
            a = m8794a(a, this.f7774a).mo27346a(string);
        }
        ColorStateList colorStateList = this.f7775b.getColorStateList(this.f7778e);
        if (colorStateList != null) {
            a = m8794a(a, this.f7774a).mo27342a(colorStateList);
        }
        int dimensionPixelSize = this.f7775b.getDimensionPixelSize(this.f7777d, -1);
        if (dimensionPixelSize != -1) {
            a = m8794a(a, this.f7774a).mo27355d(dimensionPixelSize);
        }
        int dimensionPixelSize2 = this.f7775b.getDimensionPixelSize(this.f7779f, -1);
        if (dimensionPixelSize2 != -1) {
            a = m8794a(a, this.f7774a).mo27352c(dimensionPixelSize2);
        }
        int color = this.f7775b.getColor(this.f7780g, C1024a.INVALID_ID);
        if (color != Integer.MIN_VALUE) {
            a = m8794a(a, this.f7774a).mo27364h(color);
        }
        int dimensionPixelSize3 = this.f7775b.getDimensionPixelSize(this.f7781h, -1);
        if (dimensionPixelSize3 != -1) {
            a = m8794a(a, this.f7774a).mo27370m(dimensionPixelSize3);
        }
        int color2 = this.f7775b.getColor(this.f7782i, C1024a.INVALID_ID);
        if (color2 != Integer.MIN_VALUE) {
            a = m8794a(a, this.f7774a).mo27365i(color2);
        }
        int dimensionPixelSize4 = this.f7775b.getDimensionPixelSize(this.f7783j, -1);
        if (dimensionPixelSize4 != -1) {
            a = m8794a(a, this.f7774a).mo27369l(dimensionPixelSize4);
        }
        int color3 = this.f7775b.getColor(this.f7784k, C1024a.INVALID_ID);
        if (color3 != Integer.MIN_VALUE) {
            a = m8794a(a, this.f7774a).mo27359g(color3);
        }
        int dimensionPixelSize5 = this.f7775b.getDimensionPixelSize(this.f7785l, -1);
        if (dimensionPixelSize5 != -1) {
            a = m8794a(a, this.f7774a).mo27371n(dimensionPixelSize5);
        }
        if (z) {
            int dimensionPixelSize6 = this.f7775b.getDimensionPixelSize(this.f7787n, -1);
            if (dimensionPixelSize6 != -1) {
                a = m8794a(a, this.f7774a).mo27349b(dimensionPixelSize6);
            }
            int dimensionPixelSize7 = this.f7775b.getDimensionPixelSize(this.f7786m, -1);
            if (dimensionPixelSize7 != -1) {
                a = m8794a(a, this.f7774a).mo27341a(dimensionPixelSize7);
            }
        }
        return z2 ? m8794a(a, this.f7774a) : a;
    }

    /* renamed from: a */
    private static C2994b m8793a(C2994b bVar) {
        if (bVar != null) {
            return bVar.clone();
        }
        return null;
    }

    /* renamed from: a */
    private static C2994b m8794a(C2994b bVar, Context context) {
        return bVar == null ? new C2994b(context) : bVar;
    }
}
