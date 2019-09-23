package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.net.NetworkInfo;
import com.squareup.picasso.C3068t.C3074d;
import java.io.IOException;
import p102c.C1695s;

/* renamed from: com.squareup.picasso.y */
/* compiled from: RequestHandler */
public abstract class C3085y {

    /* renamed from: com.squareup.picasso.y$a */
    /* compiled from: RequestHandler */
    public static final class C3086a {

        /* renamed from: a */
        private final C3074d f8120a;

        /* renamed from: b */
        private final Bitmap f8121b;

        /* renamed from: c */
        private final C1695s f8122c;

        /* renamed from: d */
        private final int f8123d;

        public C3086a(Bitmap bitmap, C3074d dVar) {
            this((Bitmap) C3030af.m8937a(bitmap, "bitmap == null"), null, dVar, 0);
        }

        public C3086a(C1695s sVar, C3074d dVar) {
            this(null, (C1695s) C3030af.m8937a(sVar, "source == null"), dVar, 0);
        }

        C3086a(Bitmap bitmap, C1695s sVar, C3074d dVar, int i) {
            boolean z = false;
            boolean z2 = bitmap != null;
            if (sVar != null) {
                z = true;
            }
            if (z2 != z) {
                this.f8121b = bitmap;
                this.f8122c = sVar;
                this.f8120a = (C3074d) C3030af.m8937a(dVar, "loadedFrom == null");
                this.f8123d = i;
                return;
            }
            throw new AssertionError();
        }

        /* renamed from: a */
        public Bitmap mo27582a() {
            return this.f8121b;
        }

        /* renamed from: b */
        public C1695s mo27583b() {
            return this.f8122c;
        }

        /* renamed from: c */
        public C3074d mo27584c() {
            return this.f8120a;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public int mo27585d() {
            return this.f8123d;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int mo27528a() {
        return 0;
    }

    /* renamed from: a */
    public abstract C3086a mo27454a(C3081w wVar, int i) throws IOException;

    /* renamed from: a */
    public abstract boolean mo27455a(C3081w wVar);

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo27529a(boolean z, NetworkInfo networkInfo) {
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo27530b() {
        return false;
    }

    /* renamed from: c */
    static Options m9111c(C3081w wVar) {
        boolean d = wVar.mo27561d();
        boolean z = wVar.f8088s != null;
        Options options = null;
        if (d || z || wVar.f8087r) {
            options = new Options();
            options.inJustDecodeBounds = d;
            options.inInputShareable = wVar.f8087r;
            options.inPurgeable = wVar.f8087r;
            if (z) {
                options.inPreferredConfig = wVar.f8088s;
            }
        }
        return options;
    }

    /* renamed from: a */
    static boolean m9110a(Options options) {
        return options != null && options.inJustDecodeBounds;
    }

    /* renamed from: a */
    static void m9109a(int i, int i2, Options options, C3081w wVar) {
        m9108a(i, i2, options.outWidth, options.outHeight, options, wVar);
    }

    /* renamed from: a */
    static void m9108a(int i, int i2, int i3, int i4, Options options, C3081w wVar) {
        int i5;
        if (i4 <= i2 && i3 <= i) {
            i5 = 1;
        } else if (i2 == 0) {
            i5 = (int) Math.floor((double) (((float) i3) / ((float) i)));
        } else if (i == 0) {
            i5 = (int) Math.floor((double) (((float) i4) / ((float) i2)));
        } else {
            int floor = (int) Math.floor((double) (((float) i4) / ((float) i2)));
            int floor2 = (int) Math.floor((double) (((float) i3) / ((float) i)));
            i5 = wVar.f8081l ? Math.max(floor, floor2) : Math.min(floor, floor2);
        }
        options.inSampleSize = i5;
        options.inJustDecodeBounds = false;
    }
}
