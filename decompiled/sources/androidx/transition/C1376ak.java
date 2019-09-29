package androidx.transition;

import android.os.IBinder;

/* renamed from: androidx.transition.ak */
/* compiled from: WindowIdApi14 */
class C1376ak implements C1378am {

    /* renamed from: a */
    private final IBinder f4130a;

    C1376ak(IBinder iBinder) {
        this.f4130a = iBinder;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C1376ak) && ((C1376ak) obj).f4130a.equals(this.f4130a);
    }

    public int hashCode() {
        return this.f4130a.hashCode();
    }
}
