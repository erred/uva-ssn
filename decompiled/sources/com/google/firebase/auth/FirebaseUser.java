package com.google.firebase.auth;

import android.net.Uri;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import java.util.List;

public abstract class FirebaseUser extends AbstractSafeParcelable implements UserInfo {
    public abstract String getDisplayName();

    public abstract String getEmail();

    public abstract FirebaseUserMetadata getMetadata();

    public abstract String getPhoneNumber();

    public abstract Uri getPhotoUrl();

    public abstract List<? extends UserInfo> getProviderData();

    public abstract String getProviderId();

    public abstract List<String> getProviders();

    public abstract String getUid();

    public abstract boolean isAnonymous();

    public abstract FirebaseUser zza(List<? extends UserInfo> list);

    public abstract void zza(zzcz zzcz);

    public abstract FirebaseApp zzcc();

    public abstract FirebaseUser zzce();

    public abstract String zzcf();

    public abstract zzcz zzcg();

    public abstract String zzch();

    public abstract String zzci();

    public Task<GetTokenResult> getIdToken(boolean z) {
        return FirebaseAuth.getInstance(zzcc()).zza(this, z);
    }

    public Task<Void> reload() {
        return FirebaseAuth.getInstance(zzcc()).zzd(this);
    }

    public Task<Void> reauthenticate(AuthCredential authCredential) {
        Preconditions.checkNotNull(authCredential);
        return FirebaseAuth.getInstance(zzcc()).zza(this, authCredential);
    }

    public Task<AuthResult> reauthenticateAndRetrieveData(AuthCredential authCredential) {
        Preconditions.checkNotNull(authCredential);
        return FirebaseAuth.getInstance(zzcc()).zzb(this, authCredential);
    }

    public Task<AuthResult> linkWithCredential(AuthCredential authCredential) {
        Preconditions.checkNotNull(authCredential);
        return FirebaseAuth.getInstance(zzcc()).zzc(this, authCredential);
    }

    public Task<AuthResult> unlink(String str) {
        Preconditions.checkNotEmpty(str);
        return FirebaseAuth.getInstance(zzcc()).zza(this, str);
    }

    public Task<Void> updateProfile(UserProfileChangeRequest userProfileChangeRequest) {
        Preconditions.checkNotNull(userProfileChangeRequest);
        return FirebaseAuth.getInstance(zzcc()).zza(this, userProfileChangeRequest);
    }

    public Task<Void> updateEmail(String str) {
        Preconditions.checkNotEmpty(str);
        return FirebaseAuth.getInstance(zzcc()).zzb(this, str);
    }

    public Task<Void> updatePhoneNumber(PhoneAuthCredential phoneAuthCredential) {
        return FirebaseAuth.getInstance(zzcc()).zza(this, phoneAuthCredential);
    }

    public Task<Void> updatePassword(String str) {
        Preconditions.checkNotEmpty(str);
        return FirebaseAuth.getInstance(zzcc()).zzc(this, str);
    }

    public Task<Void> delete() {
        return FirebaseAuth.getInstance(zzcc()).zze(this);
    }

    public Task<Void> sendEmailVerification() {
        return FirebaseAuth.getInstance(zzcc()).zza(this, false).continueWithTask(new zzr(this));
    }

    public Task<Void> sendEmailVerification(ActionCodeSettings actionCodeSettings) {
        return FirebaseAuth.getInstance(zzcc()).zza(this, false).continueWithTask(new zzs(this, actionCodeSettings));
    }
}
