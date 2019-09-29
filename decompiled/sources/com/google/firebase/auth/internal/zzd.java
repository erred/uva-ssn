package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.firebase.analytics.FirebaseAnalytics.Event;
import com.google.firebase.auth.AdditionalUserInfo;
import java.util.Map;

@Class(creator = "DefaultAdditionalUserInfoCreator")
public final class zzd implements AdditionalUserInfo {
    public static final Creator<zzd> CREATOR = new zze();
    @Field(getter = "getProviderId", mo13446id = 1)
    private final String zzgb;
    @Field(getter = "isNewUser", mo13446id = 3)
    private boolean zzor;
    @Field(getter = "getRawUserInfo", mo13446id = 2)
    private final String zzpl;
    private Map<String, Object> zzqm;

    @Constructor
    public zzd(@Param(mo13449id = 1) String str, @Param(mo13449id = 2) String str2, @Param(mo13449id = 3) boolean z) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        this.zzgb = str;
        this.zzpl = str2;
        this.zzqm = zzab.zzcx(str2);
        this.zzor = z;
    }

    public final int describeContents() {
        return 0;
    }

    public zzd(boolean z) {
        this.zzor = z;
        this.zzpl = null;
        this.zzgb = null;
        this.zzqm = null;
    }

    public final String getProviderId() {
        return this.zzgb;
    }

    public final Map<String, Object> getProfile() {
        return this.zzqm;
    }

    public final String getUsername() {
        if ("github.com".equals(this.zzgb)) {
            return (String) this.zzqm.get(Event.LOGIN);
        }
        if ("twitter.com".equals(this.zzgb)) {
            return (String) this.zzqm.get("screen_name");
        }
        return null;
    }

    public final boolean isNewUser() {
        return this.zzor;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getProviderId(), false);
        SafeParcelWriter.writeString(parcel, 2, this.zzpl, false);
        SafeParcelWriter.writeBoolean(parcel, 3, isNewUser());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
