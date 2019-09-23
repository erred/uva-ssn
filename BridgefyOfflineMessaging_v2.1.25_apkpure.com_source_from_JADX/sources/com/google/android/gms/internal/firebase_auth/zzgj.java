package com.google.android.gms.internal.firebase_auth;

public class zzgj {
    private static final zzfg zzsj = zzfg.zzgq();
    private zzeh zzyo;
    private volatile zzhc zzyp;
    private volatile zzeh zzyq;

    public int hashCode() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzgj)) {
            return false;
        }
        zzgj zzgj = (zzgj) obj;
        zzhc zzhc = this.zzyp;
        zzhc zzhc2 = zzgj.zzyp;
        if (zzhc == null && zzhc2 == null) {
            return zzer().equals(zzgj.zzer());
        }
        if (zzhc != null && zzhc2 != null) {
            return zzhc.equals(zzhc2);
        }
        if (zzhc != null) {
            return zzhc.equals(zzgj.zzi(zzhc.zzhi()));
        }
        return zzi(zzhc2.zzhi()).equals(zzhc2);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:7|8|9|10|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.firebase_auth.zzhc zzi(com.google.android.gms.internal.firebase_auth.zzhc r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.firebase_auth.zzhc r0 = r1.zzyp
            if (r0 != 0) goto L_0x001d
            monitor-enter(r1)
            com.google.android.gms.internal.firebase_auth.zzhc r0 = r1.zzyp     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x000b
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x000b:
            r1.zzyp = r2     // Catch:{ zzgc -> 0x0012 }
            com.google.android.gms.internal.firebase_auth.zzeh r0 = com.google.android.gms.internal.firebase_auth.zzeh.zzso     // Catch:{ zzgc -> 0x0012 }
            r1.zzyq = r0     // Catch:{ zzgc -> 0x0012 }
            goto L_0x0018
        L_0x0012:
            r1.zzyp = r2     // Catch:{ all -> 0x001a }
            com.google.android.gms.internal.firebase_auth.zzeh r2 = com.google.android.gms.internal.firebase_auth.zzeh.zzso     // Catch:{ all -> 0x001a }
            r1.zzyq = r2     // Catch:{ all -> 0x001a }
        L_0x0018:
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x001a:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            throw r2
        L_0x001d:
            com.google.android.gms.internal.firebase_auth.zzhc r2 = r1.zzyp
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzgj.zzi(com.google.android.gms.internal.firebase_auth.zzhc):com.google.android.gms.internal.firebase_auth.zzhc");
    }

    public final zzhc zzj(zzhc zzhc) {
        zzhc zzhc2 = this.zzyp;
        this.zzyo = null;
        this.zzyq = null;
        this.zzyp = zzhc;
        return zzhc2;
    }

    public final int zzgw() {
        if (this.zzyq != null) {
            return this.zzyq.size();
        }
        if (this.zzyp != null) {
            return this.zzyp.zzgw();
        }
        return 0;
    }

    public final zzeh zzer() {
        if (this.zzyq != null) {
            return this.zzyq;
        }
        synchronized (this) {
            if (this.zzyq != null) {
                zzeh zzeh = this.zzyq;
                return zzeh;
            }
            if (this.zzyp == null) {
                this.zzyq = zzeh.zzso;
            } else {
                this.zzyq = this.zzyp.zzer();
            }
            zzeh zzeh2 = this.zzyq;
            return zzeh2;
        }
    }
}
