package com.google.firebase.auth.api.internal;

import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.zzd;

public final class zzds {
    @VisibleForTesting
    private static final SparseArray<Pair<String, String>> zzmi;

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0068, code lost:
        return new com.google.firebase.auth.zzq(zzd(r0), r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00d4, code lost:
        return new com.google.firebase.auth.FirebaseAuthUserCollisionException(zzd(r0), r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00de, code lost:
        return new com.google.firebase.auth.FirebaseAuthException(zzd(r0), r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00e8, code lost:
        return new com.google.firebase.auth.FirebaseAuthInvalidUserException(zzd(r0), r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00f2, code lost:
        return new com.google.firebase.auth.FirebaseAuthInvalidCredentialsException(zzd(r0), r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.firebase.FirebaseException zzb(com.google.android.gms.common.api.Status r3) {
        /*
            int r0 = r3.getStatusCode()
            java.lang.String r1 = zze(r0)
            java.lang.String r1 = zza(r1, r3)
            switch(r0) {
                case 17004: goto L_0x00e9;
                case 17005: goto L_0x00df;
                case 17006: goto L_0x00d5;
                case 17007: goto L_0x00cb;
                case 17008: goto L_0x00e9;
                case 17009: goto L_0x00e9;
                case 17010: goto L_0x00bf;
                case 17011: goto L_0x00df;
                case 17012: goto L_0x00cb;
                default: goto L_0x000f;
            }
        L_0x000f:
            switch(r0) {
                case 17014: goto L_0x00b5;
                case 17015: goto L_0x00a9;
                case 17016: goto L_0x009d;
                case 17017: goto L_0x00df;
                default: goto L_0x0012;
            }
        L_0x0012:
            switch(r0) {
                case 17020: goto L_0x0091;
                case 17021: goto L_0x00df;
                default: goto L_0x0015;
            }
        L_0x0015:
            switch(r0) {
                case 17024: goto L_0x00e9;
                case 17025: goto L_0x00cb;
                case 17026: goto L_0x0083;
                default: goto L_0x0018;
            }
        L_0x0018:
            switch(r0) {
                case 17028: goto L_0x00d5;
                case 17029: goto L_0x0079;
                case 17030: goto L_0x0079;
                case 17031: goto L_0x006f;
                case 17032: goto L_0x006f;
                case 17033: goto L_0x006f;
                case 17034: goto L_0x00e9;
                case 17035: goto L_0x00e9;
                default: goto L_0x001b;
            }
        L_0x001b:
            switch(r0) {
                case 17040: goto L_0x00d5;
                case 17041: goto L_0x00e9;
                case 17042: goto L_0x00e9;
                case 17043: goto L_0x00e9;
                case 17044: goto L_0x00e9;
                case 17045: goto L_0x00e9;
                case 17046: goto L_0x00e9;
                default: goto L_0x001e;
            }
        L_0x001e:
            switch(r0) {
                case 17051: goto L_0x00e9;
                case 17052: goto L_0x0069;
                default: goto L_0x0021;
            }
        L_0x0021:
            switch(r0) {
                case 17057: goto L_0x005f;
                case 17058: goto L_0x005f;
                default: goto L_0x0024;
            }
        L_0x0024:
            switch(r0) {
                case 17061: goto L_0x0053;
                case 17062: goto L_0x005f;
                case 17063: goto L_0x004d;
                case 17064: goto L_0x00d5;
                case 17065: goto L_0x005f;
                default: goto L_0x0027;
            }
        L_0x0027:
            switch(r0) {
                case 17071: goto L_0x00d5;
                case 17072: goto L_0x00d5;
                case 17073: goto L_0x00d5;
                case 17074: goto L_0x00d5;
                case 17075: goto L_0x00e9;
                default: goto L_0x002a;
            }
        L_0x002a:
            switch(r0) {
                case 17000: goto L_0x00e9;
                case 17002: goto L_0x00e9;
                case 17049: goto L_0x00e9;
                case 17068: goto L_0x00d5;
                case 17495: goto L_0x0041;
                case 17499: goto L_0x0035;
                default: goto L_0x002d;
            }
        L_0x002d:
            com.google.firebase.FirebaseException r3 = new com.google.firebase.FirebaseException
            java.lang.String r0 = "An internal error has occurred."
            r3.<init>(r0)
            return r3
        L_0x0035:
            java.lang.String r0 = "An internal error has occurred."
            java.lang.String r3 = zza(r0, r3)
            com.google.firebase.FirebaseException r0 = new com.google.firebase.FirebaseException
            r0.<init>(r3)
            return r0
        L_0x0041:
            java.lang.String r0 = "Please sign in before trying to get a token."
            java.lang.String r3 = zza(r0, r3)
            com.google.firebase.internal.api.FirebaseNoSignedInUserException r0 = new com.google.firebase.internal.api.FirebaseNoSignedInUserException
            r0.<init>(r3)
            return r0
        L_0x004d:
            com.google.firebase.FirebaseApiNotAvailableException r3 = new com.google.firebase.FirebaseApiNotAvailableException
            r3.<init>(r1)
            return r3
        L_0x0053:
            java.lang.String r0 = "There was a failure in the connection between the web widget and the Firebase Auth backend."
            java.lang.String r3 = zza(r0, r3)
            com.google.firebase.FirebaseNetworkException r0 = new com.google.firebase.FirebaseNetworkException
            r0.<init>(r3)
            return r0
        L_0x005f:
            com.google.firebase.auth.zzq r3 = new com.google.firebase.auth.zzq
            java.lang.String r0 = zzd(r0)
            r3.<init>(r0, r1)
            return r3
        L_0x0069:
            com.google.firebase.FirebaseTooManyRequestsException r3 = new com.google.firebase.FirebaseTooManyRequestsException
            r3.<init>(r1)
            return r3
        L_0x006f:
            com.google.firebase.auth.FirebaseAuthEmailException r3 = new com.google.firebase.auth.FirebaseAuthEmailException
            java.lang.String r0 = zzd(r0)
            r3.<init>(r0, r1)
            return r3
        L_0x0079:
            com.google.firebase.auth.FirebaseAuthActionCodeException r3 = new com.google.firebase.auth.FirebaseAuthActionCodeException
            java.lang.String r0 = zzd(r0)
            r3.<init>(r0, r1)
            return r3
        L_0x0083:
            com.google.firebase.auth.FirebaseAuthWeakPasswordException r2 = new com.google.firebase.auth.FirebaseAuthWeakPasswordException
            java.lang.String r0 = zzd(r0)
            java.lang.String r3 = r3.getStatusMessage()
            r2.<init>(r0, r1, r3)
            return r2
        L_0x0091:
            java.lang.String r0 = "A network error (such as timeout, interrupted connection or unreachable host) has occurred."
            java.lang.String r3 = zza(r0, r3)
            com.google.firebase.FirebaseNetworkException r0 = new com.google.firebase.FirebaseNetworkException
            r0.<init>(r3)
            return r0
        L_0x009d:
            java.lang.String r0 = "User was not linked to an account with the given provider."
            java.lang.String r3 = zza(r0, r3)
            com.google.firebase.FirebaseException r0 = new com.google.firebase.FirebaseException
            r0.<init>(r3)
            return r0
        L_0x00a9:
            java.lang.String r0 = "User has already been linked to the given provider."
            java.lang.String r3 = zza(r0, r3)
            com.google.firebase.FirebaseException r0 = new com.google.firebase.FirebaseException
            r0.<init>(r3)
            return r0
        L_0x00b5:
            com.google.firebase.auth.FirebaseAuthRecentLoginRequiredException r3 = new com.google.firebase.auth.FirebaseAuthRecentLoginRequiredException
            java.lang.String r0 = zzd(r0)
            r3.<init>(r0, r1)
            return r3
        L_0x00bf:
            java.lang.String r0 = "We have blocked all requests from this device due to unusual activity. Try again later."
            java.lang.String r3 = zza(r0, r3)
            com.google.firebase.FirebaseTooManyRequestsException r0 = new com.google.firebase.FirebaseTooManyRequestsException
            r0.<init>(r3)
            return r0
        L_0x00cb:
            com.google.firebase.auth.FirebaseAuthUserCollisionException r3 = new com.google.firebase.auth.FirebaseAuthUserCollisionException
            java.lang.String r0 = zzd(r0)
            r3.<init>(r0, r1)
            return r3
        L_0x00d5:
            com.google.firebase.auth.FirebaseAuthException r3 = new com.google.firebase.auth.FirebaseAuthException
            java.lang.String r0 = zzd(r0)
            r3.<init>(r0, r1)
            return r3
        L_0x00df:
            com.google.firebase.auth.FirebaseAuthInvalidUserException r3 = new com.google.firebase.auth.FirebaseAuthInvalidUserException
            java.lang.String r0 = zzd(r0)
            r3.<init>(r0, r1)
            return r3
        L_0x00e9:
            com.google.firebase.auth.FirebaseAuthInvalidCredentialsException r3 = new com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
            java.lang.String r0 = zzd(r0)
            r3.<init>(r0, r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.api.internal.zzds.zzb(com.google.android.gms.common.api.Status):com.google.firebase.FirebaseException");
    }

    public static FirebaseAuthUserCollisionException zza(Status status, AuthCredential authCredential, String str) {
        int statusCode = status.getStatusCode();
        FirebaseAuthUserCollisionException firebaseAuthUserCollisionException = new FirebaseAuthUserCollisionException(zzd(statusCode), zza(zze(statusCode), status));
        if (!(authCredential instanceof zzd) || ((zzd) authCredential).zzay() != null || (!authCredential.getProvider().equals("yahoo.com") && !authCredential.getProvider().equals("hotmail.com"))) {
            return firebaseAuthUserCollisionException.zza(authCredential).zzbo(str);
        }
        return firebaseAuthUserCollisionException;
    }

    private static String zza(String str, Status status) {
        if (TextUtils.isEmpty(status.getStatusMessage())) {
            return str;
        }
        return String.format(String.valueOf(str).concat(" [ %s ]"), new Object[]{status.getStatusMessage()});
    }

    private static String zzd(int i) {
        Pair pair = (Pair) zzmi.get(i);
        return pair != null ? (String) pair.first : "INTERNAL_ERROR";
    }

    private static String zze(int i) {
        Pair pair = (Pair) zzmi.get(i);
        return pair != null ? (String) pair.second : "An internal error has occurred.";
    }

    static {
        SparseArray<Pair<String, String>> sparseArray = new SparseArray<>();
        zzmi = sparseArray;
        sparseArray.put(FirebaseError.ERROR_INVALID_CUSTOM_TOKEN, new Pair("ERROR_INVALID_CUSTOM_TOKEN", "The custom token format is incorrect. Please check the documentation."));
        zzmi.put(FirebaseError.ERROR_CUSTOM_TOKEN_MISMATCH, new Pair("ERROR_CUSTOM_TOKEN_MISMATCH", "The custom token corresponds to a different audience."));
        zzmi.put(FirebaseError.ERROR_INVALID_CREDENTIAL, new Pair("ERROR_INVALID_CREDENTIAL", "The supplied auth credential is malformed or has expired."));
        zzmi.put(FirebaseError.ERROR_INVALID_EMAIL, new Pair("ERROR_INVALID_EMAIL", "The email address is badly formatted."));
        zzmi.put(FirebaseError.ERROR_WRONG_PASSWORD, new Pair("ERROR_WRONG_PASSWORD", "The password is invalid or the user does not have a password."));
        zzmi.put(FirebaseError.ERROR_USER_MISMATCH, new Pair("ERROR_USER_MISMATCH", "The supplied credentials do not correspond to the previously signed in user."));
        zzmi.put(FirebaseError.ERROR_REQUIRES_RECENT_LOGIN, new Pair("ERROR_REQUIRES_RECENT_LOGIN", "This operation is sensitive and requires recent authentication. Log in again before retrying this request."));
        zzmi.put(FirebaseError.ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIAL, new Pair("ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIAL", "An account already exists with the same email address but different sign-in credentials. Sign in using a provider associated with this email address."));
        zzmi.put(FirebaseError.ERROR_EMAIL_ALREADY_IN_USE, new Pair("ERROR_EMAIL_ALREADY_IN_USE", "The email address is already in use by another account."));
        zzmi.put(FirebaseError.ERROR_CREDENTIAL_ALREADY_IN_USE, new Pair("ERROR_CREDENTIAL_ALREADY_IN_USE", "This credential is already associated with a different user account."));
        zzmi.put(FirebaseError.ERROR_USER_DISABLED, new Pair("ERROR_USER_DISABLED", "The user account has been disabled by an administrator."));
        zzmi.put(FirebaseError.ERROR_USER_TOKEN_EXPIRED, new Pair("ERROR_USER_TOKEN_EXPIRED", "The user's credential is no longer valid. The user must sign in again."));
        zzmi.put(FirebaseError.ERROR_USER_NOT_FOUND, new Pair("ERROR_USER_NOT_FOUND", "There is no user record corresponding to this identifier. The user may have been deleted."));
        zzmi.put(FirebaseError.ERROR_INVALID_USER_TOKEN, new Pair("ERROR_INVALID_USER_TOKEN", "This user's credential isn't valid for this project. This can happen if the user's token has been tampered with, or if the user isn't for the project associated with this API key."));
        zzmi.put(FirebaseError.ERROR_OPERATION_NOT_ALLOWED, new Pair("ERROR_OPERATION_NOT_ALLOWED", "The given sign-in provider is disabled for this Firebase project. Enable it in the Firebase console, under the sign-in method tab of the Auth section."));
        zzmi.put(FirebaseError.ERROR_WEAK_PASSWORD, new Pair("ERROR_WEAK_PASSWORD", "The given password is invalid."));
        zzmi.put(17029, new Pair("ERROR_EXPIRED_ACTION_CODE", "The out of band code has expired."));
        zzmi.put(17030, new Pair("ERROR_INVALID_ACTION_CODE", "The out of band code is invalid. This can happen if the code is malformed, expired, or has already been used."));
        zzmi.put(17031, new Pair("ERROR_INVALID_MESSAGE_PAYLOAD", "The email template corresponding to this action contains invalid characters in its message. Please fix by going to the Auth email templates section in the Firebase Console."));
        zzmi.put(17033, new Pair("ERROR_INVALID_RECIPIENT_EMAIL", "The email corresponding to this action failed to send as the provided recipient email address is invalid."));
        zzmi.put(17032, new Pair("ERROR_INVALID_SENDER", "The email template corresponding to this action contains an invalid sender email or name. Please fix by going to the Auth email templates section in the Firebase Console."));
        zzmi.put(17034, new Pair("ERROR_MISSING_EMAIL", "An email address must be provided."));
        zzmi.put(17035, new Pair("ERROR_MISSING_PASSWORD", "A password must be provided."));
        zzmi.put(17041, new Pair("ERROR_MISSING_PHONE_NUMBER", "To send verification codes, provide a phone number for the recipient."));
        zzmi.put(17042, new Pair("ERROR_INVALID_PHONE_NUMBER", "The format of the phone number provided is incorrect. Please enter the phone number in a format that can be parsed into E.164 format. E.164 phone numbers are written in the format [+][country code][subscriber number including area code]."));
        zzmi.put(17043, new Pair("ERROR_MISSING_VERIFICATION_CODE", "The Phone Auth Credential was created with an empty sms verification Code"));
        zzmi.put(17044, new Pair("ERROR_INVALID_VERIFICATION_CODE", "The sms verification code used to create the phone auth credential is invalid. Please resend the verification code sms and be sure use the verification code provided by the user."));
        zzmi.put(17045, new Pair("ERROR_MISSING_VERIFICATION_ID", "The Phone Auth Credential was created with an empty verification ID"));
        zzmi.put(17046, new Pair("ERROR_INVALID_VERIFICATION_ID", "The verification ID used to create the phone auth credential is invalid."));
        zzmi.put(17049, new Pair("ERROR_RETRY_PHONE_AUTH", "An error occurred during authentication using the PhoneAuthCredential. Please retry authentication."));
        zzmi.put(17051, new Pair("ERROR_SESSION_EXPIRED", "The sms code has expired. Please re-send the verification code to try again."));
        zzmi.put(17052, new Pair("ERROR_QUOTA_EXCEEDED", "The sms quota for this project has been exceeded."));
        zzmi.put(FirebaseError.ERROR_APP_NOT_AUTHORIZED, new Pair("ERROR_APP_NOT_AUTHORIZED", "This app is not authorized to use Firebase Authentication. Please verifythat the correct package name and SHA-1 are configured in the Firebase Console."));
        zzmi.put(17063, new Pair("ERROR_API_NOT_AVAILABLE", "The API that you are calling is not available on devices without Google Play Services."));
        zzmi.put(17062, new Pair("ERROR_WEB_INTERNAL_ERROR", "There was an internal error in the web widget."));
        zzmi.put(17064, new Pair("ERROR_INVALID_CERT_HASH", "There was an error while trying to get your package certificate hash."));
        zzmi.put(17065, new Pair("ERROR_WEB_STORAGE_UNSUPPORTED", "This browser is not supported or 3rd party cookies and data may be disabled."));
        zzmi.put(17040, new Pair("ERROR_MISSING_CONTINUE_URI", "A continue URL must be provided in the request."));
        zzmi.put(17068, new Pair("ERROR_DYNAMIC_LINK_NOT_ACTIVATED", "Please activate Dynamic Links in the Firebase Console and agree to the terms and conditions."));
        zzmi.put(17071, new Pair("ERROR_INVALID_PROVIDER_ID", "The provider ID provided for the attempted web operation is invalid."));
        zzmi.put(17057, new Pair("ERROR_WEB_CONTEXT_ALREADY_PRESENTED", "A headful operation is already in progress. Please wait for that to finish."));
        zzmi.put(17058, new Pair("ERROR_WEB_CONTEXT_CANCELED", "The web operation was canceled by the user."));
        zzmi.put(17072, new Pair("ERROR_TENANT_ID_MISMATCH", "The provided user's tenant ID does not match the Auth instance's tenant ID."));
        zzmi.put(17073, new Pair("ERROR_UNSUPPORTED_TENANT_OPERATION", "This operation is not supported in a multi-tenant context."));
        zzmi.put(17074, new Pair("ERROR_INVALID_DYNAMIC_LINK_DOMAIN", "The provided dynamic link domain is not configured or authorized for the current project."));
        zzmi.put(17075, new Pair("ERROR_REJECTED_CREDENTIAL", "The request contains malformed or mismatching credentials"));
    }
}
