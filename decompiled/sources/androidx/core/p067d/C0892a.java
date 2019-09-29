package androidx.core.p067d;

import android.util.Base64;
import androidx.core.p069f.C0930e;
import java.util.List;

/* renamed from: androidx.core.d.a */
/* compiled from: FontRequest */
public final class C0892a {

    /* renamed from: a */
    private final String f2852a;

    /* renamed from: b */
    private final String f2853b;

    /* renamed from: c */
    private final String f2854c;

    /* renamed from: d */
    private final List<List<byte[]>> f2855d;

    /* renamed from: e */
    private final int f2856e = 0;

    /* renamed from: f */
    private final String f2857f;

    public C0892a(String str, String str2, String str3, List<List<byte[]>> list) {
        this.f2852a = (String) C0930e.m3403a(str);
        this.f2853b = (String) C0930e.m3403a(str2);
        this.f2854c = (String) C0930e.m3403a(str3);
        this.f2855d = (List) C0930e.m3403a(list);
        StringBuilder sb = new StringBuilder(this.f2852a);
        sb.append("-");
        sb.append(this.f2853b);
        sb.append("-");
        sb.append(this.f2854c);
        this.f2857f = sb.toString();
    }

    /* renamed from: a */
    public String mo3580a() {
        return this.f2852a;
    }

    /* renamed from: b */
    public String mo3581b() {
        return this.f2853b;
    }

    /* renamed from: c */
    public String mo3582c() {
        return this.f2854c;
    }

    /* renamed from: d */
    public List<List<byte[]>> mo3583d() {
        return this.f2855d;
    }

    /* renamed from: e */
    public int mo3584e() {
        return this.f2856e;
    }

    /* renamed from: f */
    public String mo3585f() {
        return this.f2857f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("FontRequest {mProviderAuthority: ");
        sb2.append(this.f2852a);
        sb2.append(", mProviderPackage: ");
        sb2.append(this.f2853b);
        sb2.append(", mQuery: ");
        sb2.append(this.f2854c);
        sb2.append(", mCertificates:");
        sb.append(sb2.toString());
        for (int i = 0; i < this.f2855d.size(); i++) {
            sb.append(" [");
            List list = (List) this.f2855d.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString((byte[]) list.get(i2), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        StringBuilder sb3 = new StringBuilder();
        sb3.append("mCertificatesArray: ");
        sb3.append(this.f2856e);
        sb.append(sb3.toString());
        return sb.toString();
    }
}
