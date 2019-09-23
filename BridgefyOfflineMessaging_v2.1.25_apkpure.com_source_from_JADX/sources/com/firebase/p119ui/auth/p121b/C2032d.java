package com.firebase.p119ui.auth.p121b;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnCancelListener;
import com.google.android.gms.common.GoogleApiAvailability;

/* renamed from: com.firebase.ui.auth.b.d */
/* compiled from: PlayServicesHelper */
public class C2032d {

    /* renamed from: a */
    private static GoogleApiAvailability f6279a;

    /* renamed from: a */
    public static GoogleApiAvailability m8231a() {
        if (f6279a == null) {
            f6279a = GoogleApiAvailability.getInstance();
        }
        return f6279a;
    }

    /* renamed from: a */
    public static boolean m8232a(Activity activity, int i, OnCancelListener onCancelListener) {
        Dialog errorDialog = m8231a().getErrorDialog(activity, m8231a().isGooglePlayServicesAvailable(activity), i, onCancelListener);
        if (errorDialog == null) {
            return true;
        }
        errorDialog.show();
        return false;
    }
}
