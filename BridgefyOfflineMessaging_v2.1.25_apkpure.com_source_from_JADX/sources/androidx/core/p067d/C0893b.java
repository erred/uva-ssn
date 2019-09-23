package androidx.core.p067d;

import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import androidx.core.content.p066a.C0878c;
import androidx.core.graphics.C0981c;
import androidx.core.graphics.C0998i;
import androidx.core.p067d.C0901c.C0906a;
import androidx.core.p069f.C0930e;
import androidx.p052b.C0718e;
import androidx.p052b.C0725g;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import com.j256.ormlite.field.FieldType;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: androidx.core.d.b */
/* compiled from: FontsContractCompat */
public class C0893b {

    /* renamed from: a */
    static final C0718e<String, Typeface> f2858a = new C0718e<>(16);

    /* renamed from: b */
    static final Object f2859b = new Object();

    /* renamed from: c */
    static final C0725g<String, ArrayList<C0906a<C0900c>>> f2860c = new C0725g<>();

    /* renamed from: d */
    private static final C0901c f2861d = new C0901c("fonts", 10, 10000);

    /* renamed from: e */
    private static final Comparator<byte[]> f2862e = new Comparator<byte[]>() {
        /* renamed from: a */
        public int compare(byte[] bArr, byte[] bArr2) {
            if (bArr.length != bArr2.length) {
                return bArr.length - bArr2.length;
            }
            for (int i = 0; i < bArr.length; i++) {
                if (bArr[i] != bArr2[i]) {
                    return bArr[i] - bArr2[i];
                }
            }
            return 0;
        }
    };

    /* renamed from: androidx.core.d.b$a */
    /* compiled from: FontsContractCompat */
    public static class C0898a {

        /* renamed from: a */
        private final int f2870a;

        /* renamed from: b */
        private final C0899b[] f2871b;

        public C0898a(int i, C0899b[] bVarArr) {
            this.f2870a = i;
            this.f2871b = bVarArr;
        }

        /* renamed from: a */
        public int mo3594a() {
            return this.f2870a;
        }

        /* renamed from: b */
        public C0899b[] mo3595b() {
            return this.f2871b;
        }
    }

    /* renamed from: androidx.core.d.b$b */
    /* compiled from: FontsContractCompat */
    public static class C0899b {

        /* renamed from: a */
        private final Uri f2872a;

        /* renamed from: b */
        private final int f2873b;

        /* renamed from: c */
        private final int f2874c;

        /* renamed from: d */
        private final boolean f2875d;

        /* renamed from: e */
        private final int f2876e;

        public C0899b(Uri uri, int i, int i2, boolean z, int i3) {
            this.f2872a = (Uri) C0930e.m3403a(uri);
            this.f2873b = i;
            this.f2874c = i2;
            this.f2875d = z;
            this.f2876e = i3;
        }

        /* renamed from: a */
        public Uri mo3596a() {
            return this.f2872a;
        }

        /* renamed from: b */
        public int mo3597b() {
            return this.f2873b;
        }

        /* renamed from: c */
        public int mo3598c() {
            return this.f2874c;
        }

        /* renamed from: d */
        public boolean mo3599d() {
            return this.f2875d;
        }

        /* renamed from: e */
        public int mo3600e() {
            return this.f2876e;
        }
    }

    /* renamed from: androidx.core.d.b$c */
    /* compiled from: FontsContractCompat */
    private static final class C0900c {

        /* renamed from: a */
        final Typeface f2877a;

        /* renamed from: b */
        final int f2878b;

        C0900c(Typeface typeface, int i) {
            this.f2877a = typeface;
            this.f2878b = i;
        }
    }

    /* renamed from: a */
    static C0900c m3319a(Context context, C0892a aVar, int i) {
        try {
            C0898a a = m3318a(context, (CancellationSignal) null, aVar);
            int i2 = -3;
            if (a.mo3594a() == 0) {
                Typeface a2 = C0981c.m3678a(context, null, a.mo3595b(), i);
                if (a2 != null) {
                    i2 = 0;
                }
                return new C0900c(a2, i2);
            }
            if (a.mo3594a() == 1) {
                i2 = -2;
            }
            return new C0900c(null, i2);
        } catch (NameNotFoundException unused) {
            return new C0900c(null, -1);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x007b, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x008c, code lost:
        f2861d.mo3604a((java.util.concurrent.Callable<T>) r1, (androidx.core.p067d.C0901c.C0906a<T>) new androidx.core.p067d.C0893b.C08963<T>());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0096, code lost:
        return null;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Typeface m3317a(final android.content.Context r2, final androidx.core.p067d.C0892a r3, final androidx.core.content.p066a.C0886f.C0887a r4, final android.os.Handler r5, boolean r6, int r7, final int r8) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r3.mo3585f()
            r0.append(r1)
            java.lang.String r1 = "-"
            r0.append(r1)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            androidx.b.e<java.lang.String, android.graphics.Typeface> r1 = f2858a
            java.lang.Object r1 = r1.get(r0)
            android.graphics.Typeface r1 = (android.graphics.Typeface) r1
            if (r1 == 0) goto L_0x0028
            if (r4 == 0) goto L_0x0027
            r4.onFontRetrieved(r1)
        L_0x0027:
            return r1
        L_0x0028:
            if (r6 == 0) goto L_0x0045
            r1 = -1
            if (r7 != r1) goto L_0x0045
            androidx.core.d.b$c r2 = m3319a(r2, r3, r8)
            if (r4 == 0) goto L_0x0042
            int r3 = r2.f2878b
            if (r3 != 0) goto L_0x003d
            android.graphics.Typeface r3 = r2.f2877a
            r4.callbackSuccessAsync(r3, r5)
            goto L_0x0042
        L_0x003d:
            int r3 = r2.f2878b
            r4.callbackFailAsync(r3, r5)
        L_0x0042:
            android.graphics.Typeface r2 = r2.f2877a
            return r2
        L_0x0045:
            androidx.core.d.b$1 r1 = new androidx.core.d.b$1
            r1.<init>(r2, r3, r8, r0)
            r2 = 0
            if (r6 == 0) goto L_0x0059
            androidx.core.d.c r3 = f2861d     // Catch:{ InterruptedException -> 0x0058 }
            java.lang.Object r3 = r3.mo3601a(r1, r7)     // Catch:{ InterruptedException -> 0x0058 }
            androidx.core.d.b$c r3 = (androidx.core.p067d.C0893b.C0900c) r3     // Catch:{ InterruptedException -> 0x0058 }
            android.graphics.Typeface r3 = r3.f2877a     // Catch:{ InterruptedException -> 0x0058 }
            return r3
        L_0x0058:
            return r2
        L_0x0059:
            if (r4 != 0) goto L_0x005d
            r3 = r2
            goto L_0x0062
        L_0x005d:
            androidx.core.d.b$2 r3 = new androidx.core.d.b$2
            r3.<init>(r4, r5)
        L_0x0062:
            java.lang.Object r4 = f2859b
            monitor-enter(r4)
            androidx.b.g<java.lang.String, java.util.ArrayList<androidx.core.d.c$a<androidx.core.d.b$c>>> r5 = f2860c     // Catch:{ all -> 0x0097 }
            boolean r5 = r5.containsKey(r0)     // Catch:{ all -> 0x0097 }
            if (r5 == 0) goto L_0x007c
            if (r3 == 0) goto L_0x007a
            androidx.b.g<java.lang.String, java.util.ArrayList<androidx.core.d.c$a<androidx.core.d.b$c>>> r5 = f2860c     // Catch:{ all -> 0x0097 }
            java.lang.Object r5 = r5.get(r0)     // Catch:{ all -> 0x0097 }
            java.util.ArrayList r5 = (java.util.ArrayList) r5     // Catch:{ all -> 0x0097 }
            r5.add(r3)     // Catch:{ all -> 0x0097 }
        L_0x007a:
            monitor-exit(r4)     // Catch:{ all -> 0x0097 }
            return r2
        L_0x007c:
            if (r3 == 0) goto L_0x008b
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x0097 }
            r5.<init>()     // Catch:{ all -> 0x0097 }
            r5.add(r3)     // Catch:{ all -> 0x0097 }
            androidx.b.g<java.lang.String, java.util.ArrayList<androidx.core.d.c$a<androidx.core.d.b$c>>> r3 = f2860c     // Catch:{ all -> 0x0097 }
            r3.put(r0, r5)     // Catch:{ all -> 0x0097 }
        L_0x008b:
            monitor-exit(r4)     // Catch:{ all -> 0x0097 }
            androidx.core.d.c r3 = f2861d
            androidx.core.d.b$3 r4 = new androidx.core.d.b$3
            r4.<init>(r0)
            r3.mo3604a(r1, r4)
            return r2
        L_0x0097:
            r2 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0097 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.p067d.C0893b.m3317a(android.content.Context, androidx.core.d.a, androidx.core.content.a.f$a, android.os.Handler, boolean, int, int):android.graphics.Typeface");
    }

    /* renamed from: a */
    public static Map<Uri, ByteBuffer> m3322a(Context context, C0899b[] bVarArr, CancellationSignal cancellationSignal) {
        HashMap hashMap = new HashMap();
        for (C0899b bVar : bVarArr) {
            if (bVar.mo3600e() == 0) {
                Uri a = bVar.mo3596a();
                if (!hashMap.containsKey(a)) {
                    hashMap.put(a, C0998i.m3768a(context, cancellationSignal, a));
                }
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    /* renamed from: a */
    public static C0898a m3318a(Context context, CancellationSignal cancellationSignal, C0892a aVar) throws NameNotFoundException {
        ProviderInfo a = m3316a(context.getPackageManager(), aVar, context.getResources());
        if (a == null) {
            return new C0898a(1, null);
        }
        return new C0898a(0, m3324a(context, aVar, a.authority, cancellationSignal));
    }

    /* renamed from: a */
    public static ProviderInfo m3316a(PackageManager packageManager, C0892a aVar, Resources resources) throws NameNotFoundException {
        String a = aVar.mo3580a();
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(a, 0);
        if (resolveContentProvider == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("No package found for authority: ");
            sb.append(a);
            throw new NameNotFoundException(sb.toString());
        } else if (resolveContentProvider.packageName.equals(aVar.mo3581b())) {
            List a2 = m3321a(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
            Collections.sort(a2, f2862e);
            List a3 = m3320a(aVar, resources);
            for (int i = 0; i < a3.size(); i++) {
                ArrayList arrayList = new ArrayList((Collection) a3.get(i));
                Collections.sort(arrayList, f2862e);
                if (m3323a(a2, (List<byte[]>) arrayList)) {
                    return resolveContentProvider;
                }
            }
            return null;
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Found content provider ");
            sb2.append(a);
            sb2.append(", but package was not ");
            sb2.append(aVar.mo3581b());
            throw new NameNotFoundException(sb2.toString());
        }
    }

    /* renamed from: a */
    private static List<List<byte[]>> m3320a(C0892a aVar, Resources resources) {
        if (aVar.mo3583d() != null) {
            return aVar.mo3583d();
        }
        return C0878c.m3269a(resources, aVar.mo3584e());
    }

    /* renamed from: a */
    private static boolean m3323a(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals((byte[]) list.get(i), (byte[]) list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static List<byte[]> m3321a(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature byteArray : signatureArr) {
            arrayList.add(byteArray.toByteArray());
        }
        return arrayList;
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    static C0899b[] m3324a(Context context, C0892a aVar, String str, CancellationSignal cancellationSignal) {
        Cursor query;
        Uri withAppendedId;
        String str2 = str;
        ArrayList arrayList = new ArrayList();
        Uri build = new Builder().scheme(Param.CONTENT).authority(str2).build();
        Uri build2 = new Builder().scheme(Param.CONTENT).authority(str2).appendPath("file").build();
        Cursor cursor = null;
        try {
            if (VERSION.SDK_INT > 16) {
                query = context.getContentResolver().query(build, new String[]{FieldType.FOREIGN_ID_FIELD_SUFFIX, "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{aVar.mo3582c()}, null, cancellationSignal);
            } else {
                query = context.getContentResolver().query(build, new String[]{FieldType.FOREIGN_ID_FIELD_SUFFIX, "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{aVar.mo3582c()}, null);
            }
            Cursor cursor2 = query;
            if (cursor2 != null && cursor2.getCount() > 0) {
                int columnIndex = cursor2.getColumnIndex("result_code");
                ArrayList arrayList2 = new ArrayList();
                int columnIndex2 = cursor2.getColumnIndex(FieldType.FOREIGN_ID_FIELD_SUFFIX);
                int columnIndex3 = cursor2.getColumnIndex("file_id");
                int columnIndex4 = cursor2.getColumnIndex("font_ttc_index");
                int columnIndex5 = cursor2.getColumnIndex("font_weight");
                int columnIndex6 = cursor2.getColumnIndex("font_italic");
                while (cursor2.moveToNext()) {
                    int i = columnIndex != -1 ? cursor2.getInt(columnIndex) : 0;
                    int i2 = columnIndex4 != -1 ? cursor2.getInt(columnIndex4) : 0;
                    if (columnIndex3 == -1) {
                        withAppendedId = ContentUris.withAppendedId(build, cursor2.getLong(columnIndex2));
                    } else {
                        withAppendedId = ContentUris.withAppendedId(build2, cursor2.getLong(columnIndex3));
                    }
                    C0899b bVar = new C0899b(withAppendedId, i2, columnIndex5 != -1 ? cursor2.getInt(columnIndex5) : 400, columnIndex6 != -1 && cursor2.getInt(columnIndex6) == 1, i);
                    arrayList2.add(bVar);
                }
                arrayList = arrayList2;
            }
            if (cursor2 != null) {
                cursor2.close();
            }
            return (C0899b[]) arrayList.toArray(new C0899b[0]);
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }
}
