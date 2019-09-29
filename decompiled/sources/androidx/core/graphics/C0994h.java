package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import androidx.core.content.p066a.C0878c.C0880b;
import androidx.core.content.p066a.C0878c.C0881c;
import androidx.core.p067d.C0893b.C0899b;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: androidx.core.graphics.h */
/* compiled from: TypefaceCompatBaseImpl */
class C0994h {

    /* renamed from: androidx.core.graphics.h$a */
    /* compiled from: TypefaceCompatBaseImpl */
    private interface C0997a<T> {
        /* renamed from: a */
        boolean mo3853a(T t);

        /* renamed from: b */
        int mo3854b(T t);
    }

    C0994h() {
    }

    /* renamed from: a */
    private static <T> T m3750a(T[] tArr, int i, C0997a<T> aVar) {
        int i2 = (i & 1) == 0 ? 400 : 700;
        boolean z = (i & 2) != 0;
        T t = null;
        int i3 = BaseClientBuilder.API_PRIORITY_OTHER;
        for (T t2 : tArr) {
            int abs = (Math.abs(aVar.mo3854b(t2) - i2) * 2) + (aVar.mo3853a(t2) == z ? 0 : 1);
            if (t == null || i3 > abs) {
                t = t2;
                i3 = abs;
            }
        }
        return t;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0899b mo3851a(C0899b[] bVarArr, int i) {
        return (C0899b) m3750a(bVarArr, i, new C0997a<C0899b>() {
            /* renamed from: a */
            public int mo3854b(C0899b bVar) {
                return bVar.mo3598c();
            }

            /* renamed from: b */
            public boolean mo3853a(C0899b bVar) {
                return bVar.mo3599d();
            }
        });
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Typeface mo3850a(Context context, InputStream inputStream) {
        File a = C0998i.m3766a(context);
        if (a == null) {
            return null;
        }
        try {
            if (!C0998i.m3772a(a, inputStream)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(a.getPath());
            a.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            a.delete();
        }
    }

    /* renamed from: a */
    public Typeface mo3787a(Context context, CancellationSignal cancellationSignal, C0899b[] bVarArr, int i) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        if (bVarArr.length < 1) {
            return null;
        }
        try {
            inputStream = context.getContentResolver().openInputStream(mo3851a(bVarArr, i).mo3596a());
            try {
                Typeface a = mo3850a(context, inputStream);
                C0998i.m3770a((Closeable) inputStream);
                return a;
            } catch (IOException unused) {
                C0998i.m3770a((Closeable) inputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                C0998i.m3770a((Closeable) inputStream2);
                throw th;
            }
        } catch (IOException unused2) {
            inputStream = null;
            C0998i.m3770a((Closeable) inputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            C0998i.m3770a((Closeable) inputStream2);
            throw th;
        }
    }

    /* renamed from: a */
    private C0881c m3749a(C0880b bVar, int i) {
        return (C0881c) m3750a(bVar.mo3566a(), i, new C0997a<C0881c>() {
            /* renamed from: a */
            public int mo3854b(C0881c cVar) {
                return cVar.mo3568b();
            }

            /* renamed from: b */
            public boolean mo3853a(C0881c cVar) {
                return cVar.mo3569c();
            }
        });
    }

    /* renamed from: a */
    public Typeface mo3840a(Context context, C0880b bVar, Resources resources, int i) {
        C0881c a = m3749a(bVar, i);
        if (a == null) {
            return null;
        }
        return C0981c.m3677a(context, resources, a.mo3572f(), a.mo3567a(), i);
    }

    /* renamed from: a */
    public Typeface mo3841a(Context context, Resources resources, int i, String str, int i2) {
        File a = C0998i.m3766a(context);
        if (a == null) {
            return null;
        }
        try {
            if (!C0998i.m3771a(a, resources, i)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(a.getPath());
            a.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            a.delete();
        }
    }
}
