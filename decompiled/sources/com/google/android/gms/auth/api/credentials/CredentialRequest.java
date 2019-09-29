package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Class(creator = "CredentialRequestCreator")
public final class CredentialRequest extends AbstractSafeParcelable {
    public static final Creator<CredentialRequest> CREATOR = new zzg();
    @Field(getter = "getAccountTypes", mo13446id = 2)
    private final String[] zzaa;
    @Field(getter = "getCredentialPickerConfig", mo13446id = 3)
    private final CredentialPickerConfig zzab;
    @Field(getter = "getCredentialHintPickerConfig", mo13446id = 4)
    private final CredentialPickerConfig zzac;
    @Field(getter = "isIdTokenRequested", mo13446id = 5)
    private final boolean zzad;
    @Field(getter = "getServerClientId", mo13446id = 6)
    private final String zzae;
    @Field(getter = "getIdTokenNonce", mo13446id = 7)
    private final String zzaf;
    @Field(getter = "getRequireUserMediation", mo13446id = 8)
    private final boolean zzag;
    @Field(mo13446id = 1000)
    private final int zzu;
    @Field(getter = "isPasswordLoginSupported", mo13446id = 1)
    private final boolean zzz;

    public static final class Builder {
        /* access modifiers changed from: private */
        public String[] zzaa;
        /* access modifiers changed from: private */
        public CredentialPickerConfig zzab;
        /* access modifiers changed from: private */
        public CredentialPickerConfig zzac;
        /* access modifiers changed from: private */
        public boolean zzad = false;
        /* access modifiers changed from: private */
        public String zzae = null;
        /* access modifiers changed from: private */
        public String zzaf;
        private boolean zzag = false;
        /* access modifiers changed from: private */
        public boolean zzz;

        @Deprecated
        public final Builder setSupportsPasswordLogin(boolean z) {
            return setPasswordLoginSupported(z);
        }

        public final Builder setPasswordLoginSupported(boolean z) {
            this.zzz = z;
            return this;
        }

        public final Builder setAccountTypes(String... strArr) {
            if (strArr == null) {
                strArr = new String[0];
            }
            this.zzaa = strArr;
            return this;
        }

        public final Builder setCredentialPickerConfig(CredentialPickerConfig credentialPickerConfig) {
            this.zzab = credentialPickerConfig;
            return this;
        }

        public final Builder setCredentialHintPickerConfig(CredentialPickerConfig credentialPickerConfig) {
            this.zzac = credentialPickerConfig;
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

        public final CredentialRequest build() {
            if (this.zzaa == null) {
                this.zzaa = new String[0];
            }
            if (this.zzz || this.zzaa.length != 0) {
                return new CredentialRequest(this);
            }
            throw new IllegalStateException("At least one authentication method must be specified");
        }
    }

    @Constructor
    CredentialRequest(@Param(mo13449id = 1000) int i, @Param(mo13449id = 1) boolean z, @Param(mo13449id = 2) String[] strArr, @Param(mo13449id = 3) CredentialPickerConfig credentialPickerConfig, @Param(mo13449id = 4) CredentialPickerConfig credentialPickerConfig2, @Param(mo13449id = 5) boolean z2, @Param(mo13449id = 6) String str, @Param(mo13449id = 7) String str2, @Param(mo13449id = 8) boolean z3) {
        this.zzu = i;
        this.zzz = z;
        this.zzaa = (String[]) Preconditions.checkNotNull(strArr);
        if (credentialPickerConfig == null) {
            credentialPickerConfig = new com.google.android.gms.auth.api.credentials.CredentialPickerConfig.Builder().build();
        }
        this.zzab = credentialPickerConfig;
        if (credentialPickerConfig2 == null) {
            credentialPickerConfig2 = new com.google.android.gms.auth.api.credentials.CredentialPickerConfig.Builder().build();
        }
        this.zzac = credentialPickerConfig2;
        if (i < 3) {
            this.zzad = true;
            this.zzae = null;
            this.zzaf = null;
        } else {
            this.zzad = z2;
            this.zzae = str;
            this.zzaf = str2;
        }
        this.zzag = z3;
    }

    private CredentialRequest(Builder builder) {
        this(4, builder.zzz, builder.zzaa, builder.zzab, builder.zzac, builder.zzad, builder.zzae, builder.zzaf, false);
    }

    @Deprecated
    public final boolean getSupportsPasswordLogin() {
        return isPasswordLoginSupported();
    }

    public final boolean isPasswordLoginSupported() {
        return this.zzz;
    }

    public final String[] getAccountTypes() {
        return this.zzaa;
    }

    public final Set<String> getAccountTypesSet() {
        return new HashSet(Arrays.asList(this.zzaa));
    }

    public final CredentialPickerConfig getCredentialPickerConfig() {
        return this.zzab;
    }

    public final CredentialPickerConfig getCredentialHintPickerConfig() {
        return this.zzac;
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
        SafeParcelWriter.writeBoolean(parcel, 1, isPasswordLoginSupported());
        SafeParcelWriter.writeStringArray(parcel, 2, getAccountTypes(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, getCredentialPickerConfig(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, getCredentialHintPickerConfig(), i, false);
        SafeParcelWriter.writeBoolean(parcel, 5, isIdTokenRequested());
        SafeParcelWriter.writeString(parcel, 6, getServerClientId(), false);
        SafeParcelWriter.writeString(parcel, 7, getIdTokenNonce(), false);
        SafeParcelWriter.writeInt(parcel, 1000, this.zzu);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzag);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
