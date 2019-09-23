package com.google.android.gms.internal.firebase_auth;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.firebase.auth.zzd;
import java.util.List;

@Class(creator = "GetAccountInfoUserCreator")
@Reserved({1})
public final class zzct extends AbstractSafeParcelable {
    public static final Creator<zzct> CREATOR = new zzcu();
    @Field(getter = "getEmail", mo13446id = 3)
    private String zzgh;
    @Field(getter = "getPassword", mo13446id = 8)
    private String zzgi;
    @Field(getter = "getPhoneNumber", mo13446id = 9)
    private String zzhq;
    @Field(getter = "getDisplayName", mo13446id = 5)
    private String zzhw;
    @Field(getter = "getPhotoUrl", mo13446id = 6)
    private String zzhx;
    @Field(getter = "getDefaultOAuthCredential", mo13446id = 13)
    private zzd zzin;
    @Field(getter = "getLocalId", mo13446id = 2)
    private String zzoq;
    @Field(getter = "isNewUser", mo13446id = 12)
    private boolean zzor;
    @Field(getter = "isEmailVerified", mo13446id = 4)
    private boolean zzpa;
    @Field(getter = "getProviderInfoList", mo13446id = 7)
    private zzdd zzpb;
    @Field(getter = "getCreationTimestamp", mo13446id = 10)
    private long zzpc;
    @Field(getter = "getLastSignInTimestamp", mo13446id = 11)
    private long zzpd;

    public zzct() {
        this.zzpb = new zzdd();
    }

    @Constructor
    public zzct(@Param(mo13449id = 2) String str, @Param(mo13449id = 3) String str2, @Param(mo13449id = 4) boolean z, @Param(mo13449id = 5) String str3, @Param(mo13449id = 6) String str4, @Param(mo13449id = 7) zzdd zzdd, @Param(mo13449id = 8) String str5, @Param(mo13449id = 9) String str6, @Param(mo13449id = 10) long j, @Param(mo13449id = 11) long j2, @Param(mo13449id = 12) boolean z2, @Param(mo13449id = 13) zzd zzd) {
        zzdd zzdd2;
        this.zzoq = str;
        this.zzgh = str2;
        this.zzpa = z;
        this.zzhw = str3;
        this.zzhx = str4;
        if (zzdd == null) {
            zzdd2 = new zzdd();
        } else {
            zzdd2 = zzdd.zza(zzdd);
        }
        this.zzpb = zzdd2;
        this.zzgi = str5;
        this.zzhq = str6;
        this.zzpc = j;
        this.zzpd = j2;
        this.zzor = z2;
        this.zzin = zzd;
    }

    public final String getEmail() {
        return this.zzgh;
    }

    public final boolean isEmailVerified() {
        return this.zzpa;
    }

    public final String getLocalId() {
        return this.zzoq;
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

    public final String getPhoneNumber() {
        return this.zzhq;
    }

    public final long getCreationTimestamp() {
        return this.zzpc;
    }

    public final long getLastSignInTimestamp() {
        return this.zzpd;
    }

    public final boolean isNewUser() {
        return this.zzor;
    }

    public final zzct zzbx(String str) {
        this.zzgh = str;
        return this;
    }

    public final zzct zzby(String str) {
        this.zzhw = str;
        return this;
    }

    public final zzct zzbz(String str) {
        this.zzhx = str;
        return this;
    }

    public final zzct zzca(String str) {
        Preconditions.checkNotEmpty(str);
        this.zzgi = str;
        return this;
    }

    public final zzct zzb(List<zzdb> list) {
        Preconditions.checkNotNull(list);
        this.zzpb = new zzdd();
        this.zzpb.zzdu().addAll(list);
        return this;
    }

    public final zzct zzo(boolean z) {
        this.zzor = z;
        return this;
    }

    public final List<zzdb> zzdu() {
        return this.zzpb.zzdu();
    }

    public final zzdd zzdv() {
        return this.zzpb;
    }

    public final zzd zzcv() {
        return this.zzin;
    }

    public final zzct zza(zzd zzd) {
        this.zzin = zzd;
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzoq, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzgh, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzpa);
        SafeParcelWriter.writeString(parcel, 5, this.zzhw, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzhx, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzpb, i, false);
        SafeParcelWriter.writeString(parcel, 8, this.zzgi, false);
        SafeParcelWriter.writeString(parcel, 9, this.zzhq, false);
        SafeParcelWriter.writeLong(parcel, 10, this.zzpc);
        SafeParcelWriter.writeLong(parcel, 11, this.zzpd);
        SafeParcelWriter.writeBoolean(parcel, 12, this.zzor);
        SafeParcelWriter.writeParcelable(parcel, 13, this.zzin, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
