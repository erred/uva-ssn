package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.internal.firebase_auth.zzjo;

@Class(creator = "ActionCodeSettingsCreator")
public class ActionCodeSettings extends AbstractSafeParcelable {
    public static final Creator<ActionCodeSettings> CREATOR = new zzb();
    @Field(getter = "getUrl", mo13446id = 1)
    private final String url;
    @Field(getter = "getIOSBundle", mo13446id = 2)
    private final String zzfs;
    @Field(getter = "getIOSAppStoreId", mo13446id = 3)
    private final String zzft;
    @Field(getter = "getAndroidPackageName", mo13446id = 4)
    private final String zzfu;
    @Field(getter = "getAndroidInstallApp", mo13446id = 5)
    private final boolean zzfv;
    @Field(getter = "getAndroidMinimumVersion", mo13446id = 6)
    private final String zzfw;
    @Field(getter = "canHandleCodeInApp", mo13446id = 7)
    private final boolean zzfx;
    @Field(getter = "getLocaleHeader", mo13446id = 8)
    private String zzfy;
    @Field(getter = "getRequestType", mo13446id = 9)
    private int zzfz;
    @Field(getter = "getDynamicLinkDomain", mo13446id = 10)
    private String zzga;

    public static class Builder {
        /* access modifiers changed from: private */
        public String url;
        /* access modifiers changed from: private */
        public String zzfs;
        /* access modifiers changed from: private */
        public String zzfu;
        /* access modifiers changed from: private */
        public boolean zzfv;
        /* access modifiers changed from: private */
        public String zzfw;
        /* access modifiers changed from: private */
        public boolean zzfx;
        /* access modifiers changed from: private */
        public String zzga;

        private Builder() {
            this.zzfx = false;
        }

        public Builder setUrl(String str) {
            this.url = str;
            return this;
        }

        public Builder setIOSBundleId(String str) {
            this.zzfs = str;
            return this;
        }

        public Builder setAndroidPackageName(String str, boolean z, String str2) {
            this.zzfu = str;
            this.zzfv = z;
            this.zzfw = str2;
            return this;
        }

        public Builder setHandleCodeInApp(boolean z) {
            this.zzfx = z;
            return this;
        }

        public Builder setDynamicLinkDomain(String str) {
            this.zzga = str;
            return this;
        }

        public ActionCodeSettings build() {
            if (this.url != null) {
                return new ActionCodeSettings(this);
            }
            throw new IllegalArgumentException("Cannot build ActionCodeSettings with null URL. Call #setUrl(String) before calling build()");
        }
    }

    @Constructor
    ActionCodeSettings(@Param(mo13449id = 1) String str, @Param(mo13449id = 2) String str2, @Param(mo13449id = 3) String str3, @Param(mo13449id = 4) String str4, @Param(mo13449id = 5) boolean z, @Param(mo13449id = 6) String str5, @Param(mo13449id = 7) boolean z2, @Param(mo13449id = 8) String str6, @Param(mo13449id = 9) int i, @Param(mo13449id = 10) String str7) {
        this.url = str;
        this.zzfs = str2;
        this.zzft = str3;
        this.zzfu = str4;
        this.zzfv = z;
        this.zzfw = str5;
        this.zzfx = z2;
        this.zzfy = str6;
        this.zzfz = i;
        this.zzga = str7;
    }

    public static ActionCodeSettings zzbs() {
        return new ActionCodeSettings(new Builder());
    }

    private ActionCodeSettings(Builder builder) {
        this.url = builder.url;
        this.zzfs = builder.zzfs;
        this.zzft = null;
        this.zzfu = builder.zzfu;
        this.zzfv = builder.zzfv;
        this.zzfw = builder.zzfw;
        this.zzfx = builder.zzfx;
        this.zzga = builder.zzga;
    }

    public String getUrl() {
        return this.url;
    }

    public String getIOSBundle() {
        return this.zzfs;
    }

    public final String zzbt() {
        return this.zzft;
    }

    public String getAndroidPackageName() {
        return this.zzfu;
    }

    public boolean getAndroidInstallApp() {
        return this.zzfv;
    }

    public String getAndroidMinimumVersion() {
        return this.zzfw;
    }

    public boolean canHandleCodeInApp() {
        return this.zzfx;
    }

    public final void zzbm(String str) {
        this.zzfy = str;
    }

    public final String zzbu() {
        return this.zzfy;
    }

    public final void zza(zzjo zzjo) {
        this.zzfz = zzjo.zzbi();
    }

    public final int getRequestType() {
        return this.zzfz;
    }

    public final String zzbv() {
        return this.zzga;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getUrl(), false);
        SafeParcelWriter.writeString(parcel, 2, getIOSBundle(), false);
        SafeParcelWriter.writeString(parcel, 3, this.zzft, false);
        SafeParcelWriter.writeString(parcel, 4, getAndroidPackageName(), false);
        SafeParcelWriter.writeBoolean(parcel, 5, getAndroidInstallApp());
        SafeParcelWriter.writeString(parcel, 6, getAndroidMinimumVersion(), false);
        SafeParcelWriter.writeBoolean(parcel, 7, canHandleCodeInApp());
        SafeParcelWriter.writeString(parcel, 8, this.zzfy, false);
        SafeParcelWriter.writeInt(parcel, 9, this.zzfz);
        SafeParcelWriter.writeString(parcel, 10, this.zzga, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
