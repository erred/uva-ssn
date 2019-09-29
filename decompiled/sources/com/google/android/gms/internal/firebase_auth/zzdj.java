package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.internal.firebase_auth.zzj.zzk;
import com.google.android.gms.internal.firebase_auth.zzj.zzk.zza;
import com.google.firebase.auth.api.internal.zzff;

@Class(creator = "SendVerificationCodeRequestCreator")
public final class zzdj extends AbstractSafeParcelable implements zzff<zzk> {
    public static final Creator<zzdj> CREATOR = new zzdk();
    @Field(getter = "getTenantId", mo13446id = 5)
    private final String zzgw;
    @Field(getter = "getPhoneNumber", mo13446id = 1)
    private final String zzhq;
    @Field(getter = "getTimeoutInSeconds", mo13446id = 2)
    private final long zzpo;
    @Field(getter = "getForceNewSmsVerificationSession", mo13446id = 3)
    private final boolean zzpp;
    @Field(getter = "getLanguageHeader", mo13446id = 4)
    private final String zzpq;

    @Constructor
    public zzdj(@Param(mo13449id = 1) String str, @Param(mo13449id = 2) long j, @Param(mo13449id = 3) boolean z, @Param(mo13449id = 4) String str2, @Param(mo13449id = 5) String str3) {
        this.zzhq = Preconditions.checkNotEmpty(str);
        this.zzpo = j;
        this.zzpp = z;
        this.zzpq = str2;
        this.zzgw = str3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzhq, false);
        SafeParcelWriter.writeLong(parcel, 2, this.zzpo);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzpp);
        SafeParcelWriter.writeString(parcel, 4, this.zzpq, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzgw, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final /* synthetic */ zzhc zzds() {
        zza zzaj = zzk.zzag().zzaj(this.zzhq);
        if (this.zzgw != null) {
            zzaj.zzak(this.zzgw);
        }
        return (zzk) ((zzft) zzaj.zzhn());
    }
}
