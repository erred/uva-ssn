package com.squareup.picasso;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.provider.MediaStore.Images;
import android.provider.MediaStore.Video.Thumbnails;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import com.squareup.picasso.C3068t.C3074d;
import com.squareup.picasso.C3085y.C3086a;
import java.io.IOException;
import p102c.C1683l;

/* renamed from: com.squareup.picasso.o */
/* compiled from: MediaStoreRequestHandler */
class C3060o extends C3046g {

    /* renamed from: b */
    private static final String[] f7995b = {"orientation"};

    /* renamed from: com.squareup.picasso.o$a */
    /* compiled from: MediaStoreRequestHandler */
    enum C3061a {
        MICRO(3, 96, 96),
        MINI(1, 512, 384),
        FULL(2, -1, -1);
        

        /* renamed from: d */
        final int f8000d;

        /* renamed from: e */
        final int f8001e;

        /* renamed from: f */
        final int f8002f;

        private C3061a(int i, int i2, int i3) {
            this.f8000d = i;
            this.f8001e = i2;
            this.f8002f = i3;
        }
    }

    C3060o(Context context) {
        super(context);
    }

    /* renamed from: a */
    public boolean mo27455a(C3081w wVar) {
        Uri uri = wVar.f8073d;
        return Param.CONTENT.equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    /* renamed from: a */
    public C3086a mo27454a(C3081w wVar, int i) throws IOException {
        Bitmap bitmap;
        C3081w wVar2 = wVar;
        ContentResolver contentResolver = this.f7959a.getContentResolver();
        int a = m9041a(contentResolver, wVar2.f8073d);
        String type = contentResolver.getType(wVar2.f8073d);
        boolean z = type != null && type.startsWith("video/");
        if (wVar.mo27561d()) {
            C3061a a2 = m9042a(wVar2.f8077h, wVar2.f8078i);
            if (!z && a2 == C3061a.FULL) {
                return new C3086a(null, C1683l.m7039a(mo27486b(wVar)), C3074d.DISK, a);
            }
            long parseId = ContentUris.parseId(wVar2.f8073d);
            Options c = m9111c(wVar);
            c.inJustDecodeBounds = true;
            Options options = c;
            m9108a(wVar2.f8077h, wVar2.f8078i, a2.f8001e, a2.f8002f, c, wVar);
            if (z) {
                bitmap = Thumbnails.getThumbnail(contentResolver, parseId, a2 == C3061a.FULL ? 1 : a2.f8000d, options);
            } else {
                bitmap = Images.Thumbnails.getThumbnail(contentResolver, parseId, a2.f8000d, options);
            }
            if (bitmap != null) {
                return new C3086a(bitmap, null, C3074d.DISK, a);
            }
        }
        return new C3086a(null, C1683l.m7039a(mo27486b(wVar)), C3074d.DISK, a);
    }

    /* renamed from: a */
    static C3061a m9042a(int i, int i2) {
        if (i <= C3061a.MICRO.f8001e && i2 <= C3061a.MICRO.f8002f) {
            return C3061a.MICRO;
        }
        if (i > C3061a.MINI.f8001e || i2 > C3061a.MINI.f8002f) {
            return C3061a.FULL;
        }
        return C3061a.MINI;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0035  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int m9041a(android.content.ContentResolver r8, android.net.Uri r9) {
        /*
            r0 = 0
            r1 = 0
            java.lang.String[] r4 = f7995b     // Catch:{ RuntimeException -> 0x0032, all -> 0x002a }
            r5 = 0
            r6 = 0
            r7 = 0
            r2 = r8
            r3 = r9
            android.database.Cursor r8 = r2.query(r3, r4, r5, r6, r7)     // Catch:{ RuntimeException -> 0x0032, all -> 0x002a }
            if (r8 == 0) goto L_0x0024
            boolean r9 = r8.moveToFirst()     // Catch:{ RuntimeException -> 0x0022, all -> 0x0020 }
            if (r9 != 0) goto L_0x0016
            goto L_0x0024
        L_0x0016:
            int r9 = r8.getInt(r0)     // Catch:{ RuntimeException -> 0x0022, all -> 0x0020 }
            if (r8 == 0) goto L_0x001f
            r8.close()
        L_0x001f:
            return r9
        L_0x0020:
            r9 = move-exception
            goto L_0x002c
        L_0x0022:
            goto L_0x0033
        L_0x0024:
            if (r8 == 0) goto L_0x0029
            r8.close()
        L_0x0029:
            return r0
        L_0x002a:
            r9 = move-exception
            r8 = r1
        L_0x002c:
            if (r8 == 0) goto L_0x0031
            r8.close()
        L_0x0031:
            throw r9
        L_0x0032:
            r8 = r1
        L_0x0033:
            if (r8 == 0) goto L_0x0038
            r8.close()
        L_0x0038:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.C3060o.m9041a(android.content.ContentResolver, android.net.Uri):int");
    }
}
