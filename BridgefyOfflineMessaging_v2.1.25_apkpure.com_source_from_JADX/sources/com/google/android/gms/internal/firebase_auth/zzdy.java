package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzj.zzu;
import com.google.firebase.auth.api.internal.zzdw;

public final class zzdy implements zzdw<zzdy, zzu> {
    private String zzgc;
    private String zzgh;
    private String zzhw;
    private String zzhx;
    private String zzid;
    private String zzoq;
    private long zzos;

    public final String getIdToken() {
        return this.zzgc;
    }

    public final String zzr() {
        return this.zzid;
    }

    public final long zzs() {
        return this.zzos;
    }

    public final zzhm<zzu> zzdj() {
        return zzu.zzl();
    }

    public final /* synthetic */ zzdw zza(zzhc zzhc) {
        if (zzhc instanceof zzu) {
            zzu zzu = (zzu) zzhc;
            this.zzoq = Strings.emptyToNull(zzu.getLocalId());
            this.zzgh = Strings.emptyToNull(zzu.getEmail());
            this.zzhw = Strings.emptyToNull(zzu.getDisplayName());
            this.zzgc = Strings.emptyToNull(zzu.getIdToken());
            this.zzhx = Strings.emptyToNull(zzu.zzal());
            this.zzid = Strings.emptyToNull(zzu.zzr());
            this.zzos = zzu.zzs();
            return this;
        }
        throw new IllegalArgumentException("The passed proto must be an instance of VerifyPasswordResponse.");
    }
}
