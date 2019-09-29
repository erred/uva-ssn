package com.google.android.gms.auth.api.signin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.fragment.p081a.C1062d;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder;
import com.google.android.gms.auth.api.signin.internal.zzh;
import com.google.android.gms.auth.api.signin.internal.zzp;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public final class GoogleSignIn {
    private GoogleSignIn() {
    }

    public static GoogleSignInClient getClient(Context context, GoogleSignInOptions googleSignInOptions) {
        return new GoogleSignInClient(context, (GoogleSignInOptions) Preconditions.checkNotNull(googleSignInOptions));
    }

    public static GoogleSignInClient getClient(Activity activity, GoogleSignInOptions googleSignInOptions) {
        return new GoogleSignInClient(activity, (GoogleSignInOptions) Preconditions.checkNotNull(googleSignInOptions));
    }

    public static Task<GoogleSignInAccount> getSignedInAccountFromIntent(Intent intent) {
        GoogleSignInResult signInResultFromIntent = zzh.getSignInResultFromIntent(intent);
        if (signInResultFromIntent == null) {
            return Tasks.forException(ApiExceptionUtil.fromStatus(Status.RESULT_INTERNAL_ERROR));
        }
        if (!signInResultFromIntent.getStatus().isSuccess() || signInResultFromIntent.getSignInAccount() == null) {
            return Tasks.forException(ApiExceptionUtil.fromStatus(signInResultFromIntent.getStatus()));
        }
        return Tasks.forResult(signInResultFromIntent.getSignInAccount());
    }

    public static GoogleSignInAccount getLastSignedInAccount(Context context) {
        return zzp.zzd(context).zzh();
    }

    public static GoogleSignInAccount getAccountForScopes(Context context, Scope scope, Scope... scopeArr) {
        Preconditions.checkNotNull(context, "please provide a valid Context object");
        Preconditions.checkNotNull(scope, "please provide at least one valid scope");
        GoogleSignInAccount lastSignedInAccount = getLastSignedInAccount(context);
        if (lastSignedInAccount == null) {
            lastSignedInAccount = GoogleSignInAccount.createDefault();
        }
        lastSignedInAccount.requestExtraScopes(scope);
        lastSignedInAccount.requestExtraScopes(scopeArr);
        return lastSignedInAccount;
    }

    public static GoogleSignInAccount getAccountForExtension(Context context, GoogleSignInOptionsExtension googleSignInOptionsExtension) {
        Preconditions.checkNotNull(context, "please provide a valid Context object");
        Preconditions.checkNotNull(googleSignInOptionsExtension, "please provide valid GoogleSignInOptionsExtension");
        GoogleSignInAccount lastSignedInAccount = getLastSignedInAccount(context);
        if (lastSignedInAccount == null) {
            lastSignedInAccount = GoogleSignInAccount.createDefault();
        }
        return lastSignedInAccount.requestExtraScopes(zzc(googleSignInOptionsExtension.getImpliedScopes()));
    }

    public static boolean hasPermissions(GoogleSignInAccount googleSignInAccount, GoogleSignInOptionsExtension googleSignInOptionsExtension) {
        Preconditions.checkNotNull(googleSignInOptionsExtension, "Please provide a non-null GoogleSignInOptionsExtension");
        return hasPermissions(googleSignInAccount, zzc(googleSignInOptionsExtension.getImpliedScopes()));
    }

    public static boolean hasPermissions(GoogleSignInAccount googleSignInAccount, Scope... scopeArr) {
        if (googleSignInAccount == null) {
            return false;
        }
        HashSet hashSet = new HashSet();
        Collections.addAll(hashSet, scopeArr);
        return googleSignInAccount.getGrantedScopes().containsAll(hashSet);
    }

    public static void requestPermissions(Activity activity, int i, GoogleSignInAccount googleSignInAccount, GoogleSignInOptionsExtension googleSignInOptionsExtension) {
        Preconditions.checkNotNull(activity, "Please provide a non-null Activity");
        Preconditions.checkNotNull(googleSignInOptionsExtension, "Please provide a non-null GoogleSignInOptionsExtension");
        requestPermissions(activity, i, googleSignInAccount, zzc(googleSignInOptionsExtension.getImpliedScopes()));
    }

    public static void requestPermissions(C1062d dVar, int i, GoogleSignInAccount googleSignInAccount, GoogleSignInOptionsExtension googleSignInOptionsExtension) {
        Preconditions.checkNotNull(dVar, "Please provide a non-null Fragment");
        Preconditions.checkNotNull(googleSignInOptionsExtension, "Please provide a non-null GoogleSignInOptionsExtension");
        requestPermissions(dVar, i, googleSignInAccount, zzc(googleSignInOptionsExtension.getImpliedScopes()));
    }

    public static void requestPermissions(Activity activity, int i, GoogleSignInAccount googleSignInAccount, Scope... scopeArr) {
        Preconditions.checkNotNull(activity, "Please provide a non-null Activity");
        Preconditions.checkNotNull(scopeArr, "Please provide at least one scope");
        activity.startActivityForResult(zzc(activity, googleSignInAccount, scopeArr), i);
    }

    public static void requestPermissions(C1062d dVar, int i, GoogleSignInAccount googleSignInAccount, Scope... scopeArr) {
        Preconditions.checkNotNull(dVar, "Please provide a non-null Fragment");
        Preconditions.checkNotNull(scopeArr, "Please provide at least one scope");
        dVar.startActivityForResult(zzc(dVar.getActivity(), googleSignInAccount, scopeArr), i);
    }

    private static Intent zzc(Activity activity, GoogleSignInAccount googleSignInAccount, Scope... scopeArr) {
        Builder builder = new Builder();
        if (scopeArr.length > 0) {
            builder.requestScopes(scopeArr[0], scopeArr);
        }
        if (googleSignInAccount != null && !TextUtils.isEmpty(googleSignInAccount.getEmail())) {
            builder.setAccountName(googleSignInAccount.getEmail());
        }
        return new GoogleSignInClient(activity, builder.build()).getSignInIntent();
    }

    private static Scope[] zzc(List<Scope> list) {
        if (list == null) {
            return new Scope[0];
        }
        return (Scope[]) list.toArray(new Scope[list.size()]);
    }
}
