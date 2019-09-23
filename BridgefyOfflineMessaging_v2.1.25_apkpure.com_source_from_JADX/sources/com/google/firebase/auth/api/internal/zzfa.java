package com.google.firebase.auth.api.internal;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;

public final class zzfa {
    private final String packageName;
    private final String zzof;

    public zzfa(Context context) {
        this(context, context.getPackageName());
    }

    private zzfa(Context context, String str) {
        Preconditions.checkNotNull(context);
        this.packageName = Preconditions.checkNotEmpty(str);
        try {
            byte[] packageCertificateHashBytes = AndroidUtilsLight.getPackageCertificateHashBytes(context, this.packageName);
            if (packageCertificateHashBytes == null) {
                String str2 = "FBA-PackageInfo";
                String str3 = "single cert required: ";
                String valueOf = String.valueOf(str);
                Log.e(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                this.zzof = null;
                return;
            }
            this.zzof = Hex.bytesToStringUppercase(packageCertificateHashBytes, false);
        } catch (NameNotFoundException unused) {
            String str4 = "FBA-PackageInfo";
            String str5 = "no pkg: ";
            String valueOf2 = String.valueOf(str);
            Log.e(str4, valueOf2.length() != 0 ? str5.concat(valueOf2) : new String(str5));
            this.zzof = null;
        }
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String zzdq() {
        return this.zzof;
    }
}
