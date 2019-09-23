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
import com.google.android.gms.internal.firebase_auth.zzj.zzg;
import com.google.firebase.auth.api.internal.zzdw;
import java.util.List;

@Class(creator = "GetAccountInfoResponseCreator")
@Reserved({1})
public final class zzcr extends AbstractSafeParcelable implements zzdw<zzcr, zzg> {
    public static final Creator<zzcr> CREATOR = new zzcs();
    @Field(getter = "getUserList", mo13446id = 2)
    private zzcv zzoz;

    public zzcr() {
    }

    @Constructor
    zzcr(@Param(mo13449id = 2) zzcv zzcv) {
        zzcv zzcv2;
        if (zzcv == null) {
            zzcv2 = new zzcv();
        } else {
            zzcv2 = zzcv.zza(zzcv);
        }
        this.zzoz = zzcv2;
    }

    public final List<zzct> zzdt() {
        return this.zzoz.zzdt();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzoz, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzhm<zzg> zzdj() {
        return zzg.zzl();
    }

    public final /* synthetic */ zzdw zza(zzhc zzhc) {
        if (zzhc instanceof zzg) {
            zzg zzg = (zzg) zzhc;
            if (zzg.zzx() == 0) {
                this.zzoz = new zzcv();
            } else {
                this.zzoz = zzcv.zza(zzg);
            }
            return this;
        }
        throw new IllegalArgumentException("The passed proto must be an instance of GetAccountInfoResponse.");
    }
}
