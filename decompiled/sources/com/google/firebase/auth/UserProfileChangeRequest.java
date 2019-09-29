package com.google.firebase.auth;

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

@Class(creator = "UserProfileChangeRequestCreator")
@Reserved({1})
public class UserProfileChangeRequest extends AbstractSafeParcelable {
    public static final Creator<UserProfileChangeRequest> CREATOR = new zzz();
    @Field(getter = "getDisplayName", mo13446id = 2)
    private String zzhw;
    @Field(getter = "getPhotoUrl", mo13446id = 3)
    private String zzhx;
    @Field(getter = "shouldRemoveDisplayName", mo13446id = 4)
    private boolean zzhy;
    @Field(getter = "shouldRemovePhotoUri", mo13446id = 5)
    private boolean zzhz;
    private Uri zzia;

    public static class Builder {
        private String zzhw;
        private boolean zzhy;
        private boolean zzhz;
        private Uri zzia;

        public Builder setDisplayName(String str) {
            if (str == null) {
                this.zzhy = true;
            } else {
                this.zzhw = str;
            }
            return this;
        }

        public Builder setPhotoUri(Uri uri) {
            if (uri == null) {
                this.zzhz = true;
            } else {
                this.zzia = uri;
            }
            return this;
        }

        public UserProfileChangeRequest build() {
            return new UserProfileChangeRequest(this.zzhw, this.zzia == null ? null : this.zzia.toString(), this.zzhy, this.zzhz);
        }
    }

    @Constructor
    UserProfileChangeRequest(@Param(mo13449id = 2) String str, @Param(mo13449id = 3) String str2, @Param(mo13449id = 4) boolean z, @Param(mo13449id = 5) boolean z2) {
        this.zzhw = str;
        this.zzhx = str2;
        this.zzhy = z;
        this.zzhz = z2;
        this.zzia = TextUtils.isEmpty(str2) ? null : Uri.parse(str2);
    }

    public String getDisplayName() {
        return this.zzhw;
    }

    public final String zzal() {
        return this.zzhx;
    }

    public Uri getPhotoUri() {
        return this.zzia;
    }

    public final boolean zzck() {
        return this.zzhy;
    }

    public final boolean zzcl() {
        return this.zzhz;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getDisplayName(), false);
        SafeParcelWriter.writeString(parcel, 3, this.zzhx, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzhy);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzhz);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
