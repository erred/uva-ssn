package com.google.android.gms.internal.measurement;

final class zztm {
    private final byte[] buffer;
    private final zztv zzbtw;

    private zztm(int i) {
        this.buffer = new byte[i];
        this.zzbtw = zztv.zzj(this.buffer);
    }

    public final zzte zzuh() {
        if (this.zzbtw.zzvj() == 0) {
            return new zzto(this.buffer);
        }
        throw new IllegalStateException("Did not write as much data as expected.");
    }

    public final zztv zzui() {
        return this.zzbtw;
    }

    /* synthetic */ zztm(int i, zztf zztf) {
        this(i);
    }
}
