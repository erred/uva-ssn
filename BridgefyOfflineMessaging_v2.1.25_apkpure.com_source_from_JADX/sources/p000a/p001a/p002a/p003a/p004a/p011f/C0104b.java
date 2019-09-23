package p000a.p001a.p002a.p003a.p004a.p011f;

import android.content.Context;
import java.io.File;
import p000a.p001a.p002a.p003a.C0135c;
import p000a.p001a.p002a.p003a.C0146i;

/* renamed from: a.a.a.a.a.f.b */
/* compiled from: FileStoreImpl */
public class C0104b implements C0103a {

    /* renamed from: a */
    private final Context f212a;

    /* renamed from: b */
    private final String f213b;

    /* renamed from: c */
    private final String f214c;

    public C0104b(C0146i iVar) {
        if (iVar.mo320q() != null) {
            this.f212a = iVar.mo320q();
            this.f213b = iVar.mo322s();
            StringBuilder sb = new StringBuilder();
            sb.append("Android/");
            sb.append(this.f212a.getPackageName());
            this.f214c = sb.toString();
            return;
        }
        throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
    }

    /* renamed from: a */
    public File mo243a() {
        return mo244a(this.f212a.getFilesDir());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public File mo244a(File file) {
        if (file == null) {
            C0135c.m449h().mo270a("Fabric", "Null File");
        } else if (file.exists() || file.mkdirs()) {
            return file;
        } else {
            C0135c.m449h().mo277d("Fabric", "Couldn't create file");
        }
        return null;
    }
}
