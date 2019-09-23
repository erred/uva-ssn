package com.google.android.gms.internal.measurement;

public class zzvc {
    private static final zzub zzbtk = zzub.zzvr();
    private zzte zzbzu;
    private volatile zzvv zzbzv;
    private volatile zzte zzbzw;

    public int hashCode() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzvc)) {
            return false;
        }
        zzvc zzvc = (zzvc) obj;
        zzvv zzvv = this.zzbzv;
        zzvv zzvv2 = zzvc.zzbzv;
        if (zzvv == null && zzvv2 == null) {
            return zztw().equals(zzvc.zztw());
        }
        if (zzvv != null && zzvv2 != null) {
            return zzvv.equals(zzvv2);
        }
        if (zzvv != null) {
            return zzvv.equals(zzvc.zzh(zzvv.zzwj()));
        }
        return zzh(zzvv2.zzwj()).equals(zzvv2);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:7|8|9|10|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.measurement.zzvv zzh(com.google.android.gms.internal.measurement.zzvv r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.measurement.zzvv r0 = r1.zzbzv
            if (r0 != 0) goto L_0x001d
            monitor-enter(r1)
            com.google.android.gms.internal.measurement.zzvv r0 = r1.zzbzv     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x000b
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x000b:
            r1.zzbzv = r2     // Catch:{ zzuv -> 0x0012 }
            com.google.android.gms.internal.measurement.zzte r0 = com.google.android.gms.internal.measurement.zzte.zzbtq     // Catch:{ zzuv -> 0x0012 }
            r1.zzbzw = r0     // Catch:{ zzuv -> 0x0012 }
            goto L_0x0018
        L_0x0012:
            r1.zzbzv = r2     // Catch:{ all -> 0x001a }
            com.google.android.gms.internal.measurement.zzte r2 = com.google.android.gms.internal.measurement.zzte.zzbtq     // Catch:{ all -> 0x001a }
            r1.zzbzw = r2     // Catch:{ all -> 0x001a }
        L_0x0018:
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x001a:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            throw r2
        L_0x001d:
            com.google.android.gms.internal.measurement.zzvv r2 = r1.zzbzv
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzvc.zzh(com.google.android.gms.internal.measurement.zzvv):com.google.android.gms.internal.measurement.zzvv");
    }

    public final zzvv zzi(zzvv zzvv) {
        zzvv zzvv2 = this.zzbzv;
        this.zzbzu = null;
        this.zzbzw = null;
        this.zzbzv = zzvv;
        return zzvv2;
    }

    public final int zzvx() {
        if (this.zzbzw != null) {
            return this.zzbzw.size();
        }
        if (this.zzbzv != null) {
            return this.zzbzv.zzvx();
        }
        return 0;
    }

    public final zzte zztw() {
        if (this.zzbzw != null) {
            return this.zzbzw;
        }
        synchronized (this) {
            if (this.zzbzw != null) {
                zzte zzte = this.zzbzw;
                return zzte;
            }
            if (this.zzbzv == null) {
                this.zzbzw = zzte.zzbtq;
            } else {
                this.zzbzw = this.zzbzv.zztw();
            }
            zzte zzte2 = this.zzbzw;
            return zzte2;
        }
    }
}
