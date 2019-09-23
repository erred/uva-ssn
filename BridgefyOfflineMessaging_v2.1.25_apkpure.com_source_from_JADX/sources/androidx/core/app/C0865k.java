package androidx.core.app;

import android.app.RemoteInput;
import android.app.RemoteInput.Builder;
import android.os.Bundle;
import java.util.Set;

/* renamed from: androidx.core.app.k */
/* compiled from: RemoteInput */
public final class C0865k {

    /* renamed from: a */
    private final String f2815a;

    /* renamed from: b */
    private final CharSequence f2816b;

    /* renamed from: c */
    private final CharSequence[] f2817c;

    /* renamed from: d */
    private final boolean f2818d;

    /* renamed from: e */
    private final Bundle f2819e;

    /* renamed from: f */
    private final Set<String> f2820f;

    /* renamed from: a */
    public String mo3529a() {
        return this.f2815a;
    }

    /* renamed from: b */
    public CharSequence mo3530b() {
        return this.f2816b;
    }

    /* renamed from: c */
    public CharSequence[] mo3531c() {
        return this.f2817c;
    }

    /* renamed from: d */
    public Set<String> mo3532d() {
        return this.f2820f;
    }

    /* renamed from: e */
    public boolean mo3533e() {
        return this.f2818d;
    }

    /* renamed from: f */
    public Bundle mo3534f() {
        return this.f2819e;
    }

    /* renamed from: a */
    static RemoteInput[] m3201a(C0865k[] kVarArr) {
        if (kVarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[kVarArr.length];
        for (int i = 0; i < kVarArr.length; i++) {
            remoteInputArr[i] = m3200a(kVarArr[i]);
        }
        return remoteInputArr;
    }

    /* renamed from: a */
    static RemoteInput m3200a(C0865k kVar) {
        return new Builder(kVar.mo3529a()).setLabel(kVar.mo3530b()).setChoices(kVar.mo3531c()).setAllowFreeFormInput(kVar.mo3533e()).addExtras(kVar.mo3534f()).build();
    }
}
