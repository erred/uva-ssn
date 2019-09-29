package p000a.p001a.p002a.p003a.p004a.p012g;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import p000a.p001a.p002a.p003a.C0135c;
import p000a.p001a.p002a.p003a.p004a.p006b.C0020i;

/* renamed from: a.a.a.a.a.g.n */
/* compiled from: IconRequest */
public class C0120n {

    /* renamed from: a */
    public final String f261a;

    /* renamed from: b */
    public final int f262b;

    /* renamed from: c */
    public final int f263c;

    /* renamed from: d */
    public final int f264d;

    public C0120n(String str, int i, int i2, int i3) {
        this.f261a = str;
        this.f262b = i;
        this.f263c = i2;
        this.f264d = i3;
    }

    /* renamed from: a */
    public static C0120n m411a(Context context, String str) {
        if (str != null) {
            try {
                int l = C0020i.m91l(context);
                StringBuilder sb = new StringBuilder();
                sb.append("App icon resource ID is ");
                sb.append(l);
                C0135c.m449h().mo270a("Fabric", sb.toString());
                Options options = new Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeResource(context.getResources(), l, options);
                return new C0120n(str, l, options.outWidth, options.outHeight);
            } catch (Exception e) {
                C0135c.m449h().mo280e("Fabric", "Failed to load icon", e);
            }
        }
        return null;
    }
}
