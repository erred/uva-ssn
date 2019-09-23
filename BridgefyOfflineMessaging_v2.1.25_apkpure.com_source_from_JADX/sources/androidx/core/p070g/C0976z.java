package androidx.core.p070g;

import android.os.Build.VERSION;
import android.view.WindowInsets;

/* renamed from: androidx.core.g.z */
/* compiled from: WindowInsetsCompat */
public class C0976z {

    /* renamed from: a */
    private final Object f3040a;

    private C0976z(Object obj) {
        this.f3040a = obj;
    }

    /* renamed from: a */
    public int mo3776a() {
        if (VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f3040a).getSystemWindowInsetLeft();
        }
        return 0;
    }

    /* renamed from: b */
    public int mo3778b() {
        if (VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f3040a).getSystemWindowInsetTop();
        }
        return 0;
    }

    /* renamed from: c */
    public int mo3779c() {
        if (VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f3040a).getSystemWindowInsetRight();
        }
        return 0;
    }

    /* renamed from: d */
    public int mo3780d() {
        if (VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f3040a).getSystemWindowInsetBottom();
        }
        return 0;
    }

    /* renamed from: e */
    public boolean mo3781e() {
        if (VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f3040a).hasSystemWindowInsets();
        }
        return false;
    }

    /* renamed from: f */
    public boolean mo3783f() {
        if (VERSION.SDK_INT >= 21) {
            return ((WindowInsets) this.f3040a).isConsumed();
        }
        return false;
    }

    /* renamed from: g */
    public C0976z mo3784g() {
        if (VERSION.SDK_INT >= 20) {
            return new C0976z(((WindowInsets) this.f3040a).consumeSystemWindowInsets());
        }
        return null;
    }

    /* renamed from: a */
    public C0976z mo3777a(int i, int i2, int i3, int i4) {
        if (VERSION.SDK_INT >= 20) {
            return new C0976z(((WindowInsets) this.f3040a).replaceSystemWindowInsets(i, i2, i3, i4));
        }
        return null;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0976z zVar = (C0976z) obj;
        if (this.f3040a != null) {
            z = this.f3040a.equals(zVar.f3040a);
        } else if (zVar.f3040a != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        if (this.f3040a == null) {
            return 0;
        }
        return this.f3040a.hashCode();
    }

    /* renamed from: a */
    static C0976z m3648a(Object obj) {
        if (obj == null) {
            return null;
        }
        return new C0976z(obj);
    }

    /* renamed from: a */
    static Object m3649a(C0976z zVar) {
        if (zVar == null) {
            return null;
        }
        return zVar.f3040a;
    }
}
