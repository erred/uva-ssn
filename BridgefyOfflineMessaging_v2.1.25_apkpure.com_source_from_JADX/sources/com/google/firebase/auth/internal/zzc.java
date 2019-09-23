package com.google.firebase.auth.internal;

import android.text.TextUtils;
import com.google.android.gms.internal.firebase_auth.zzdg;
import com.google.firebase.auth.ActionCodeResult;

public final class zzc implements ActionCodeResult {
    private final String zzgh;
    private final int zzqk;
    private final String zzql;

    public zzc(zzdg zzdg) {
        if (TextUtils.isEmpty(zzdg.zzad())) {
            this.zzgh = zzdg.getEmail();
        } else {
            this.zzgh = zzdg.zzad();
        }
        this.zzql = zzdg.getEmail();
        if (TextUtils.isEmpty(zzdg.zzea())) {
            this.zzqk = 3;
        } else if (zzdg.zzea().equals("PASSWORD_RESET")) {
            this.zzqk = 0;
        } else if (zzdg.zzea().equals("VERIFY_EMAIL")) {
            this.zzqk = 1;
        } else if (zzdg.zzea().equals("RECOVER_EMAIL")) {
            this.zzqk = 2;
        } else if (zzdg.zzea().equals("EMAIL_SIGNIN")) {
            this.zzqk = 4;
        } else {
            this.zzqk = 3;
        }
    }

    public final int getOperation() {
        return this.zzqk;
    }

    public final String getData(int i) {
        switch (i) {
            case 0:
                if (this.zzqk == 4) {
                    return null;
                }
                return this.zzgh;
            case 1:
                return this.zzql;
            default:
                return null;
        }
    }
}
