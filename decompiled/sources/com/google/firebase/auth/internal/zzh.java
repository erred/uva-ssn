package com.google.firebase.auth.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzaf;
import com.google.android.gms.internal.firebase_auth.zzct;
import com.google.android.gms.internal.firebase_auth.zzdb;
import com.google.firebase.auth.UserInfo;
import org.json.JSONException;
import org.json.JSONObject;

@Class(creator = "DefaultAuthUserInfoCreator")
public final class zzh extends AbstractSafeParcelable implements UserInfo {
    public static final Creator<zzh> CREATOR = new zzi();
    @Field(getter = "getProviderId", mo13446id = 2)
    private String zzgb;
    @Field(getter = "getEmail", mo13446id = 5)
    private String zzgh;
    @Field(getter = "getPhoneNumber", mo13446id = 6)
    private String zzhq;
    @Field(getter = "getDisplayName", mo13446id = 3)
    private String zzhw;
    @Field(getter = "getPhotoUrlString", mo13446id = 4)
    private String zzhx;
    private Uri zzia;
    @Field(getter = "isEmailVerified", mo13446id = 7)
    private boolean zzpa;
    @Field(getter = "getRawUserInfo", mo13446id = 8)
    private String zzpl;
    @Field(getter = "getUid", mo13446id = 1)
    private String zzqq;

    @Constructor
    @VisibleForTesting
    public zzh(@Param(mo13449id = 1) String str, @Param(mo13449id = 2) String str2, @Param(mo13449id = 5) String str3, @Param(mo13449id = 4) String str4, @Param(mo13449id = 3) String str5, @Param(mo13449id = 6) String str6, @Param(mo13449id = 7) boolean z, @Param(mo13449id = 8) String str7) {
        this.zzqq = str;
        this.zzgb = str2;
        this.zzgh = str3;
        this.zzhq = str4;
        this.zzhw = str5;
        this.zzhx = str6;
        if (!TextUtils.isEmpty(this.zzhx)) {
            this.zzia = Uri.parse(this.zzhx);
        }
        this.zzpa = z;
        this.zzpl = str7;
    }

    public zzh(zzct zzct, String str) {
        Preconditions.checkNotNull(zzct);
        Preconditions.checkNotEmpty(str);
        this.zzqq = Preconditions.checkNotEmpty(zzct.getLocalId());
        this.zzgb = str;
        this.zzgh = zzct.getEmail();
        this.zzhw = zzct.getDisplayName();
        Uri photoUri = zzct.getPhotoUri();
        if (photoUri != null) {
            this.zzhx = photoUri.toString();
            this.zzia = photoUri;
        }
        this.zzpa = zzct.isEmailVerified();
        this.zzpl = null;
        this.zzhq = zzct.getPhoneNumber();
    }

    public zzh(zzdb zzdb) {
        Preconditions.checkNotNull(zzdb);
        this.zzqq = zzdb.zzbg();
        this.zzgb = Preconditions.checkNotEmpty(zzdb.getProviderId());
        this.zzhw = zzdb.getDisplayName();
        Uri photoUri = zzdb.getPhotoUri();
        if (photoUri != null) {
            this.zzhx = photoUri.toString();
            this.zzia = photoUri;
        }
        this.zzgh = zzdb.getEmail();
        this.zzhq = zzdb.getPhoneNumber();
        this.zzpa = false;
        this.zzpl = zzdb.getRawUserInfo();
    }

    public final String getUid() {
        return this.zzqq;
    }

    public final String getProviderId() {
        return this.zzgb;
    }

    public final String getDisplayName() {
        return this.zzhw;
    }

    public final Uri getPhotoUrl() {
        if (!TextUtils.isEmpty(this.zzhx) && this.zzia == null) {
            this.zzia = Uri.parse(this.zzhx);
        }
        return this.zzia;
    }

    public final String getEmail() {
        return this.zzgh;
    }

    public final String getPhoneNumber() {
        return this.zzhq;
    }

    public final boolean isEmailVerified() {
        return this.zzpa;
    }

    public final String getRawUserInfo() {
        return this.zzpl;
    }

    public final String zzdz() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("userId", this.zzqq);
            jSONObject.putOpt("providerId", this.zzgb);
            jSONObject.putOpt("displayName", this.zzhw);
            jSONObject.putOpt("photoUrl", this.zzhx);
            jSONObject.putOpt(Scopes.EMAIL, this.zzgh);
            jSONObject.putOpt("phoneNumber", this.zzhq);
            jSONObject.putOpt("isEmailVerified", Boolean.valueOf(this.zzpa));
            jSONObject.putOpt("rawUserInfo", this.zzpl);
            return jSONObject.toString();
        } catch (JSONException e) {
            Log.d("DefaultAuthUserInfo", "Failed to jsonify this object");
            throw new zzaf((Throwable) e);
        }
    }

    public static zzh zzcs(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            zzh zzh = new zzh(jSONObject.optString("userId"), jSONObject.optString("providerId"), jSONObject.optString(Scopes.EMAIL), jSONObject.optString("phoneNumber"), jSONObject.optString("displayName"), jSONObject.optString("photoUrl"), jSONObject.optBoolean("isEmailVerified"), jSONObject.optString("rawUserInfo"));
            return zzh;
        } catch (JSONException e) {
            Log.d("DefaultAuthUserInfo", "Failed to unpack UserInfo from JSON");
            throw new zzaf((Throwable) e);
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getUid(), false);
        SafeParcelWriter.writeString(parcel, 2, getProviderId(), false);
        SafeParcelWriter.writeString(parcel, 3, getDisplayName(), false);
        SafeParcelWriter.writeString(parcel, 4, this.zzhx, false);
        SafeParcelWriter.writeString(parcel, 5, getEmail(), false);
        SafeParcelWriter.writeString(parcel, 6, getPhoneNumber(), false);
        SafeParcelWriter.writeBoolean(parcel, 7, isEmailVerified());
        SafeParcelWriter.writeString(parcel, 8, this.zzpl, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
