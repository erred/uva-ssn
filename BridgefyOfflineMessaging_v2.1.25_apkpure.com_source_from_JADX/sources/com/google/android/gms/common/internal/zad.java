package com.google.android.gms.common.internal;

import android.content.Intent;
import androidx.fragment.p081a.C1062d;

final class zad extends DialogRedirect {
    private final /* synthetic */ C1062d val$fragment;
    private final /* synthetic */ int val$requestCode;
    private final /* synthetic */ Intent zaog;

    zad(Intent intent, C1062d dVar, int i) {
        this.zaog = intent;
        this.val$fragment = dVar;
        this.val$requestCode = i;
    }

    public final void redirect() {
        if (this.zaog != null) {
            this.val$fragment.startActivityForResult(this.zaog, this.val$requestCode);
        }
    }
}
