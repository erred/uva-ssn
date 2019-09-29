package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.fragment.p081a.C1071e;
import androidx.p079f.p080a.C1049a;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;

@KeepName
public class FederatedSignInActivity extends C1071e {
    private static final zzz zzgy = zzz.zzem();
    private static boolean zzrl = false;
    private boolean zzrm = false;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String action = getIntent().getAction();
        if (!"com.google.firebase.auth.internal.SIGN_IN".equals(action) && !"com.google.firebase.auth.internal.LINK".equals(action) && !"com.google.firebase.auth.internal.REAUTHENTICATE".equals(action)) {
            String str = "IdpSignInActivity";
            String str2 = "Unknown action: ";
            String valueOf = String.valueOf(action);
            Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            zzel();
        } else if (zzrl) {
            finish();
        } else {
            zzrl = true;
            if (bundle != null) {
                this.zzrm = bundle.getBoolean("com.google.firebase.auth.internal.KEY_STARTED_SIGN_IN");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("com.google.firebase.auth.internal.KEY_STARTED_SIGN_IN", this.zzrm);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00a3 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResume() {
        /*
            r6 = this;
            super.onResume()
            android.content.Intent r0 = r6.getIntent()
            java.lang.String r1 = "com.google.firebase.auth.internal.WEB_SIGN_IN_FAILED"
            java.lang.String r2 = r0.getAction()
            boolean r1 = r1.equals(r2)
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x002f
            java.lang.String r1 = "IdpSignInActivity"
            java.lang.String r2 = "Web sign-in failed, finishing"
            android.util.Log.e(r1, r2)
            boolean r1 = com.google.firebase.auth.internal.zzai.zza(r0)
            if (r1 == 0) goto L_0x002a
            com.google.android.gms.common.api.Status r0 = com.google.firebase.auth.internal.zzai.zzb(r0)
            r6.zze(r0)
            goto L_0x002d
        L_0x002a:
            r6.zzel()
        L_0x002d:
            r2 = 1
            goto L_0x00a1
        L_0x002f:
            java.lang.String r1 = "com.google.firebase.auth.internal.OPERATION"
            boolean r1 = r0.hasExtra(r1)
            if (r1 == 0) goto L_0x00a1
            java.lang.String r1 = "com.google.firebase.auth.internal.VERIFY_ASSERTION_REQUEST"
            boolean r1 = r0.hasExtra(r1)
            if (r1 == 0) goto L_0x00a1
            java.lang.String r1 = "com.google.firebase.auth.internal.OPERATION"
            java.lang.String r1 = r0.getStringExtra(r1)
            java.lang.String r4 = "com.google.firebase.auth.internal.SIGN_IN"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x005d
            java.lang.String r4 = "com.google.firebase.auth.internal.LINK"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x005d
            java.lang.String r4 = "com.google.firebase.auth.internal.REAUTHENTICATE"
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L_0x00a1
        L_0x005d:
            java.lang.String r4 = "com.google.firebase.auth.internal.VERIFY_ASSERTION_REQUEST"
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzdr> r5 = com.google.android.gms.internal.firebase_auth.zzdr.CREATOR
            com.google.android.gms.common.internal.safeparcel.SafeParcelable r4 = com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer.deserializeFromIntentExtra(r0, r4, r5)
            com.google.android.gms.internal.firebase_auth.zzdr r4 = (com.google.android.gms.internal.firebase_auth.zzdr) r4
            java.lang.String r5 = "com.google.firebase.auth.internal.EXTRA_TENANT_ID"
            java.lang.String r0 = r0.getStringExtra(r5)
            r4.zzcr(r0)
            zzrl = r2
            android.content.Intent r2 = new android.content.Intent
            r2.<init>()
            java.lang.String r5 = "com.google.firebase.auth.internal.VERIFY_ASSERTION_REQUEST"
            com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer.serializeToIntentExtra(r4, r2, r5)
            java.lang.String r5 = "com.google.firebase.auth.internal.OPERATION"
            r2.putExtra(r5, r1)
            java.lang.String r5 = "com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT"
            r2.setAction(r5)
            androidx.f.a.a r5 = androidx.p079f.p080a.C1049a.m3996a(r6)
            boolean r2 = r5.mo4060a(r2)
            if (r2 != 0) goto L_0x0098
            android.content.Context r2 = r6.getApplicationContext()
            com.google.firebase.auth.internal.zzac.zza(r2, r4, r1, r0)
            goto L_0x009d
        L_0x0098:
            com.google.firebase.auth.internal.zzz r0 = zzgy
            r0.zza(r6)
        L_0x009d:
            r6.finish()
            goto L_0x002d
        L_0x00a1:
            if (r2 == 0) goto L_0x00a4
            return
        L_0x00a4:
            boolean r0 = r6.zzrm
            if (r0 != 0) goto L_0x00e7
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "com.google.firebase.auth.api.gms.ui.START_WEB_SIGN_IN"
            r0.<init>(r1)
            java.lang.String r1 = "com.google.android.gms"
            r0.setPackage(r1)
            android.content.Intent r1 = r6.getIntent()
            android.os.Bundle r1 = r1.getExtras()
            r0.putExtras(r1)
            java.lang.String r1 = "com.google.firebase.auth.internal.OPERATION"
            android.content.Intent r2 = r6.getIntent()
            java.lang.String r2 = r2.getAction()
            r0.putExtra(r1, r2)
            r1 = 40963(0xa003, float:5.7401E-41)
            r6.startActivityForResult(r0, r1)     // Catch:{ ActivityNotFoundException -> 0x00d3 }
            goto L_0x00e4
        L_0x00d3:
            java.lang.String r0 = "Could not launch web sign-in Intent. Google Play service is unavailable"
            java.lang.String r1 = "IdpSignInActivity"
            android.util.Log.w(r1, r0)
            com.google.android.gms.common.api.Status r1 = new com.google.android.gms.common.api.Status
            r2 = 17499(0x445b, float:2.4521E-41)
            r1.<init>(r2, r0)
            r6.zze(r1)
        L_0x00e4:
            r6.zzrm = r3
            return
        L_0x00e7:
            r6.zzel()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.internal.FederatedSignInActivity.onResume():void");
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    private final void zzel() {
        zzrl = false;
        this.zzrm = false;
        Intent intent = new Intent();
        intent.putExtra("com.google.firebase.auth.internal.EXTRA_CANCELED", true);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        if (!C1049a.m3996a((Context) this).mo4060a(intent)) {
            zzac.zza(this, zzq.zzcu("WEB_CONTEXT_CANCELED"));
        } else {
            zzgy.zza(this);
        }
        finish();
    }

    private final void zze(Status status) {
        zzrl = false;
        Intent intent = new Intent();
        zzai.zza(intent, status);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        if (!C1049a.m3996a((Context) this).mo4060a(intent)) {
            zzac.zza(getApplicationContext(), status);
        } else {
            zzgy.zza(this);
        }
        finish();
    }
}
