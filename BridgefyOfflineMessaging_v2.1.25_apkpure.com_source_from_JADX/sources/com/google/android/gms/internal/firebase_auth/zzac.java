package com.google.android.gms.internal.firebase_auth;

final class zzac<E> extends zzz<E> {
    static final zzz<Object> zzfq = new zzac(new Object[0], 0);
    private final transient int size;
    private final transient Object[] zzfr;

    zzac(Object[] objArr, int i) {
        this.zzfr = objArr;
        this.size = i;
    }

    /* access modifiers changed from: 0000 */
    public final int zzbq() {
        return 0;
    }

    public final int size() {
        return this.size;
    }

    /* access modifiers changed from: 0000 */
    public final Object[] zzbp() {
        return this.zzfr;
    }

    /* access modifiers changed from: 0000 */
    public final int zzbr() {
        return this.size;
    }

    /* access modifiers changed from: 0000 */
    public final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzfr, 0, objArr, 0, this.size);
        return this.size + 0;
    }

    public final E get(int i) {
        zzv.zza(i, this.size);
        return this.zzfr[i];
    }
}
