package com.google.android.gms.internal.firebase_auth;

import android.text.TextUtils;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzj.zzq;
import com.google.firebase.auth.api.internal.zzdw;
import com.google.firebase.auth.zzd;

public final class zzdt implements zzdw<zzdt, zzq> {
    private String zzgb;
    private String zzgc;
    private String zzgf;
    private String zzgh;
    private String zzhw;
    private String zzhx;
    private String zzid;
    private String zzoq;
    private boolean zzor;
    private long zzos;
    private String zzpl;
    private boolean zzqf;
    private boolean zzqg;
    private String zzqh;
    private String zzqi;
    private String zzqj;

    public final boolean zzed() {
        return this.zzqf;
    }

    public final String getIdToken() {
        return this.zzgc;
    }

    public final String getEmail() {
        return this.zzgh;
    }

    public final String getProviderId() {
        return this.zzgb;
    }

    public final String getRawUserInfo() {
        return this.zzpl;
    }

    public final String zzr() {
        return this.zzid;
    }

    public final long zzs() {
        return this.zzos;
    }

    public final boolean isNewUser() {
        return this.zzor;
    }

    public final String getErrorMessage() {
        return this.zzqj;
    }

    public final zzd zzcv() {
        if (TextUtils.isEmpty(this.zzqh) && TextUtils.isEmpty(this.zzqi)) {
            return null;
        }
        if (this.zzgf != null) {
            return zzd.zza(this.zzgb, this.zzqi, this.zzqh, this.zzgf);
        }
        return zzd.zza(this.zzgb, this.zzqi, this.zzqh);
    }

    public final zzhm<zzq> zzdj() {
        return zzq.zzl();
    }

    public final /* synthetic */ zzdw zza(zzhc zzhc) {
        if (zzhc instanceof zzq) {
            zzq zzq = (zzq) zzhc;
            this.zzqf = zzq.zzau();
            this.zzqg = zzq.zzaw();
            this.zzgc = Strings.emptyToNull(zzq.getIdToken());
            this.zzid = Strings.emptyToNull(zzq.zzr());
            this.zzos = zzq.zzs();
            this.zzoq = Strings.emptyToNull(zzq.getLocalId());
            this.zzgh = Strings.emptyToNull(zzq.getEmail());
            this.zzhw = Strings.emptyToNull(zzq.getDisplayName());
            this.zzhx = Strings.emptyToNull(zzq.zzal());
            this.zzgb = Strings.emptyToNull(zzq.getProviderId());
            this.zzpl = Strings.emptyToNull(zzq.getRawUserInfo());
            this.zzor = zzq.zzt();
            this.zzqh = zzq.zzav();
            this.zzqi = zzq.zzax();
            this.zzqj = Strings.emptyToNull(zzq.getErrorMessage());
            this.zzgf = Strings.emptyToNull(zzq.zzay());
            return this;
        }
        throw new IllegalArgumentException("The passed proto must be an instance of VerifyAssertionResponse.");
    }
}
