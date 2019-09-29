package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.internal.firebase_auth.zzdr;

@Class(creator = "TwitterAuthCredentialCreator")
public class TwitterAuthCredential extends AuthCredential {
    public static final Creator<TwitterAuthCredential> CREATOR = new zzy();
    @Field(getter = "getToken", mo13446id = 1)
    private String zzhm;
    @Field(getter = "getSecret", mo13446id = 2)
    private String zzhv;

    @Constructor
    TwitterAuthCredential(@Param(mo13449id = 1) String str, @Param(mo13449id = 2) String str2) {
        this.zzhm = Preconditions.checkNotEmpty(str);
        this.zzhv = Preconditions.checkNotEmpty(str2);
    }

    public String getProvider() {
        return "twitter.com";
    }

    public String getSignInMethod() {
        return "twitter.com";
    }

    public static zzdr zza(TwitterAuthCredential twitterAuthCredential, String str) {
        Preconditions.checkNotNull(twitterAuthCredential);
        zzdr zzdr = new zzdr(null, twitterAuthCredential.zzhm, twitterAuthCredential.getProvider(), null, twitterAuthCredential.zzhv, null, str, null);
        return zzdr;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzhm, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzhv, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
