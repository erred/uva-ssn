package p000a.p001a.p002a.p003a.p004a.p006b;

import android.content.Context;
import p000a.p001a.p002a.p003a.C0135c;
import p000a.p001a.p002a.p003a.p004a.p005a.C0005b;
import p000a.p001a.p002a.p003a.p004a.p005a.C0007d;

/* renamed from: a.a.a.a.a.b.p */
/* compiled from: InstallerPackageNameProvider */
public class C0034p {

    /* renamed from: a */
    private final C0007d<String> f79a = new C0007d<String>() {
        /* renamed from: a */
        public String mo20b(Context context) throws Exception {
            String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
            return installerPackageName == null ? "" : installerPackageName;
        }
    };

    /* renamed from: b */
    private final C0005b<String> f80b = new C0005b<>();

    /* renamed from: a */
    public String mo68a(Context context) {
        try {
            String str = (String) this.f80b.mo18a(context, this.f79a);
            if ("".equals(str)) {
                str = null;
            }
            return str;
        } catch (Exception e) {
            C0135c.m449h().mo280e("Fabric", "Failed to determine installer package name", e);
            return null;
        }
    }
}
