package com.google.android.gms.internal.firebase_auth;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@Class(creator = "ProviderUserInfoCreator")
@Reserved({1})
public final class zzdb extends AbstractSafeParcelable {
    public static final Creator<zzdb> CREATOR = new zzdc();
    @Field(getter = "getProviderId", mo13446id = 5)
    private String zzgb;
    @Field(getter = "getEmail", mo13446id = 8)
    private String zzgh;
    @Field(getter = "getPhoneNumber", mo13446id = 7)
    private String zzhq;
    @Field(getter = "getDisplayName", mo13446id = 3)
    private String zzhw;
    @Field(getter = "getPhotoUrl", mo13446id = 4)
    private String zzhx;
    @Field(getter = "getFederatedId", mo13446id = 2)
    private String zzpk;
    @Field(getter = "getRawUserInfo", mo13446id = 6)
    private String zzpl;

    public zzdb() {
    }

    @Constructor
    zzdb(@Param(mo13449id = 2) String str, @Param(mo13449id = 3) String str2, @Param(mo13449id = 4) String str3, @Param(mo13449id = 5) String str4, @Param(mo13449id = 6) String str5, @Param(mo13449id = 7) String str6, @Param(mo13449id = 8) String str7) {
        this.zzpk = str;
        this.zzhw = str2;
        this.zzhx = str3;
        this.zzgb = str4;
        this.zzpl = str5;
        this.zzhq = str6;
        this.zzgh = str7;
    }

    public final String zzbg() {
        return this.zzpk;
    }

    public final String getDisplayName() {
        return this.zzhw;
    }

    public final Uri getPhotoUri() {
        if (!TextUtils.isEmpty(this.zzhx)) {
            return Uri.parse(this.zzhx);
        }
        return null;
    }

    public final String getProviderId() {
        return this.zzgb;
    }

    public final String getPhoneNumber() {
        return this.zzhq;
    }

    public final void zzcg(String str) {
        this.zzpl = str;
    }

    public final String getRawUserInfo() {
        return this.zzpl;
    }

    public final String getEmail() {
        return this.zzgh;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzpk, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzhw, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzhx, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzgb, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzpl, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzhq, false);
        SafeParcelWriter.writeString(parcel, 8, this.zzgh, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
