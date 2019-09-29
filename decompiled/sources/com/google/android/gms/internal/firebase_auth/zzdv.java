package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzj.zzs;
import com.google.firebase.auth.api.internal.zzdw;

@Class(creator = "VerifyCustomTokenResponseCreator")
@Reserved({1})
public final class zzdv extends AbstractSafeParcelable implements zzdw<zzdv, zzs> {
    public static final Creator<zzdv> CREATOR = new zzdw();
    @Field(getter = "getIdToken", mo13446id = 2)
    private String zzgc;
    @Field(getter = "getRefreshToken", mo13446id = 3)
    private String zzid;
    @Field(getter = "isNewUser", mo13446id = 5)
    private boolean zzor;
    @Field(getter = "getExpiresIn", mo13446id = 4)
    private long zzos;

    public zzdv() {
    }

    @Constructor
    zzdv(@Param(mo13449id = 2) String str, @Param(mo13449id = 3) String str2, @Param(mo13449id = 4) long j, @Param(mo13449id = 5) boolean z) {
        this.zzgc = str;
        this.zzid = str2;
        this.zzos = j;
        this.zzor = z;
    }

    public final String getIdToken() {
        return this.zzgc;
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

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzgc, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzid, false);
        SafeParcelWriter.writeLong(parcel, 4, this.zzos);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzor);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzhm<zzs> zzdj() {
        return zzs.zzl();
    }

    public final /* synthetic */ zzdw zza(zzhc zzhc) {
        if (zzhc instanceof zzs) {
            zzs zzs = (zzs) zzhc;
            this.zzgc = Strings.emptyToNull(zzs.getIdToken());
            this.zzid = Strings.emptyToNull(zzs.zzr());
            this.zzos = zzs.zzs();
            this.zzor = zzs.zzt();
            return this;
        }
        throw new IllegalArgumentException("The passed proto must be an instance of VerifyCustomTokenResponse.");
    }
}
