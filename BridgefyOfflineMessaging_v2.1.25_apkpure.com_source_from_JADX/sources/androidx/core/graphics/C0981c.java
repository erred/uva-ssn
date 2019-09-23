package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.core.content.p066a.C0878c.C0879a;
import androidx.core.content.p066a.C0878c.C0880b;
import androidx.core.content.p066a.C0878c.C0882d;
import androidx.core.content.p066a.C0886f.C0887a;
import androidx.core.p067d.C0893b;
import androidx.core.p067d.C0893b.C0899b;
import androidx.p052b.C0718e;

/* renamed from: androidx.core.graphics.c */
/* compiled from: TypefaceCompat */
public class C0981c {

    /* renamed from: a */
    private static final C0994h f3046a;

    /* renamed from: b */
    private static final C0718e<String, Typeface> f3047b = new C0718e<>(16);

    static {
        if (VERSION.SDK_INT >= 28) {
            f3046a = new C0993g();
        } else if (VERSION.SDK_INT >= 26) {
            f3046a = new C0992f();
        } else if (VERSION.SDK_INT >= 24 && C0991e.m3725a()) {
            f3046a = new C0991e();
        } else if (VERSION.SDK_INT >= 21) {
            f3046a = new C0982d();
        } else {
            f3046a = new C0994h();
        }
    }

    /* renamed from: a */
    public static Typeface m3680a(Resources resources, int i, int i2) {
        return (Typeface) f3047b.get(m3681b(resources, i, i2));
    }

    /* renamed from: b */
    private static String m3681b(Resources resources, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append(resources.getResourcePackageName(i));
        sb.append("-");
        sb.append(i);
        sb.append("-");
        sb.append(i2);
        return sb.toString();
    }

    /* renamed from: a */
    public static Typeface m3679a(Context context, C0879a aVar, Resources resources, int i, int i2, C0887a aVar2, Handler handler, boolean z) {
        Typeface typeface;
        if (aVar instanceof C0882d) {
            C0882d dVar = (C0882d) aVar;
            boolean z2 = false;
            if (!z ? aVar2 == null : dVar.mo3574b() == 0) {
                z2 = true;
            }
            typeface = C0893b.m3317a(context, dVar.mo3573a(), aVar2, handler, z2, z ? dVar.mo3575c() : -1, i2);
        } else {
            typeface = f3046a.mo3840a(context, (C0880b) aVar, resources, i2);
            if (aVar2 != null) {
                if (typeface != null) {
                    aVar2.callbackSuccessAsync(typeface, handler);
                } else {
                    aVar2.callbackFailAsync(-3, handler);
                }
            }
        }
        if (typeface != null) {
            f3047b.put(m3681b(resources, i, i2), typeface);
        }
        return typeface;
    }

    /* renamed from: a */
    public static Typeface m3677a(Context context, Resources resources, int i, String str, int i2) {
        Typeface a = f3046a.mo3841a(context, resources, i, str, i2);
        if (a != null) {
            f3047b.put(m3681b(resources, i, i2), a);
        }
        return a;
    }

    /* renamed from: a */
    public static Typeface m3678a(Context context, CancellationSignal cancellationSignal, C0899b[] bVarArr, int i) {
        return f3046a.mo3787a(context, cancellationSignal, bVarArr, i);
    }
}
