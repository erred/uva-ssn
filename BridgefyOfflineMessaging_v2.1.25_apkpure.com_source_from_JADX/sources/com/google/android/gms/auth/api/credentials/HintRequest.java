package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@Class(creator = "HintRequestCreator")
public final class HintRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<HintRequest> CREATOR = new zzj();
    @Field(getter = "getAccountTypes", mo13446id = 4)
    private final String[] zzaa;
    @Field(getter = "isIdTokenRequested", mo13446id = 5)
    private final boolean zzad;
    @Field(getter = "getServerClientId", mo13446id = 6)
    private final String zzae;
    @Field(getter = "getIdTokenNonce", mo13446id = 7)
    private final String zzaf;
    @Field(getter = "getHintPickerConfig", mo13446id = 1)
    private final CredentialPickerConfig zzah;
    @Field(getter = "isEmailAddressIdentifierSupported", mo13446id = 2)
    private final boolean zzai;
    @Field(getter = "isPhoneNumberIdentifierSupported", mo13446id = 3)
    private final boolean zzaj;
    @Field(mo13446id = 1000)
    private final int zzu;

    public static final class Builder {
        /* access modifiers changed from: private */
        public String[] zzaa;
        /* access modifiers changed from: private */
        public boolean zzad = false;
        /* access modifiers changed from: private */
        public String zzae;
        /* access modifiers changed from: private */
        public String zzaf;
        /* access modifiers changed from: private */
        public CredentialPickerConfig zzah = new com.google.android.gms.auth.api.credentials.CredentialPickerConfig.Builder().build();
        /* access modifiers changed from: private */
        public boolean zzai;
        /* access modifiers changed from: private */
        public boolean zzaj;

        public final Builder setEmailAddressIdentifierSupported(boolean z) {
            this.zzai = z;
            return this;
        }

        public final Builder setPhoneNumberIdentifierSupported(boolean z) {
            this.zzaj = z;
            return this;
        }

        public final Builder setAccountTypes(String... strArr) {
            if (strArr == null) {
                strArr = new String[0];
            }
            this.zzaa = strArr;
            return this;
        }

        public final Builder setHintPickerConfig(CredentialPickerConfig credentialPickerConfig) {
            this.zzah = (CredentialPickerConfig) Preconditions.checkNotNull(credentialPickerConfig);
            return this;
        }

        public final Builder setIdTokenRequested(boolean z) {
            this.zzad = z;
            return this;
        }

        public final Builder setServerClientId(String str) {
            this.zzae = str;
            return this;
        }

        public final Builder setIdTokenNonce(String str) {
            this.zzaf = str;
            return this;
        }

        public final HintRequest build() {
            if (this.zzaa == null) {
                this.zzaa = new String[0];
            }
            if (this.zzai || this.zzaj || this.zzaa.length != 0) {
                return new HintRequest(this);
            }
            throw new IllegalStateException("At least one authentication method must be specified");
        }
    }

    @Constructor
    HintRequest(@Param(mo13449id = 1000) int i, @Param(mo13449id = 1) CredentialPickerConfig credentialPickerConfig, @Param(mo13449id = 2) boolean z, @Param(mo13449id = 3) boolean z2, @Param(mo13449id = 4) String[] strArr, @Param(mo13449id = 5) boolean z3, @Param(mo13449id = 6) String str, @Param(mo13449id = 7) String str2) {
        this.zzu = i;
        this.zzah = (CredentialPickerConfig) Preconditions.checkNotNull(credentialPickerConfig);
        this.zzai = z;
        this.zzaj = z2;
        this.zzaa = (String[]) Preconditions.checkNotNull(strArr);
        if (this.zzu < 2) {
            this.zzad = true;
            this.zzae = null;
            this.zzaf = null;
            return;
        }
        this.zzad = z3;
        this.zzae = str;
        this.zzaf = str2;
    }

    private HintRequest(Builder builder) {
        this(2, builder.zzah, builder.zzai, builder.zzaj, builder.zzaa, builder.zzad, builder.zzae, builder.zzaf);
    }

    public final CredentialPickerConfig getHintPickerConfig() {
        return this.zzah;
    }

    public final boolean isEmailAddressIdentifierSupported() {
        return this.zzai;
    }

    public final String[] getAccountTypes() {
        return this.zzaa;
    }

    public final boolean isIdTokenRequested() {
        return this.zzad;
    }

    public final String getServerClientId() {
        return this.zzae;
    }

    public final String getIdTokenNonce() {
        return this.zzaf;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getHintPickerConfig(), i, false);
        SafeParcelWriter.writeBoolean(parcel, 2, isEmailAddressIdentifierSupported());
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzaj);
        SafeParcelWriter.writeStringArray(parcel, 4, getAccountTypes(), false);
        SafeParcelWriter.writeBoolean(parcel, 5, isIdTokenRequested());
        SafeParcelWriter.writeString(parcel, 6, getServerClientId(), false);
        SafeParcelWriter.writeString(parcel, 7, getIdTokenNonce(), false);
        SafeParcelWriter.writeInt(parcel, 1000, this.zzu);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
