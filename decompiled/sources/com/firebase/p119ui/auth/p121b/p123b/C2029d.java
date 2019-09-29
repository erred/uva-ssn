package com.firebase.p119ui.auth.p121b.p123b;

import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.widget.Toast;
import com.firebase.p119ui.auth.p124ui.C2050c;
import com.firebase.ui.auth.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;

/* renamed from: com.firebase.ui.auth.b.b.d */
/* compiled from: SmartLockBase */
public abstract class C2029d<R extends Result> extends C2050c implements ConnectionCallbacks, OnConnectionFailedListener, ResultCallback<R> {

    /* renamed from: a */
    protected GoogleApiClient f6273a;

    /* renamed from: b */
    private boolean f6274b;

    /* renamed from: c */
    private Pair<Integer, Intent> f6275c;

    public void onConnectionSuspended(int i) {
    }

    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m8225a(java.lang.String r1) {
        /*
            int r0 = r1.hashCode()
            switch(r0) {
                case -1830313082: goto L_0x0030;
                case -1536293812: goto L_0x0026;
                case -364826023: goto L_0x001c;
                case 106642798: goto L_0x0012;
                case 1216985755: goto L_0x0008;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x003a
        L_0x0008:
            java.lang.String r0 = "password"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x003a
            r1 = 3
            goto L_0x003b
        L_0x0012:
            java.lang.String r0 = "phone"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x003a
            r1 = 4
            goto L_0x003b
        L_0x001c:
            java.lang.String r0 = "facebook.com"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x003a
            r1 = 1
            goto L_0x003b
        L_0x0026:
            java.lang.String r0 = "google.com"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x003a
            r1 = 0
            goto L_0x003b
        L_0x0030:
            java.lang.String r0 = "twitter.com"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x003a
            r1 = 2
            goto L_0x003b
        L_0x003a:
            r1 = -1
        L_0x003b:
            r0 = 0
            switch(r1) {
                case 0: goto L_0x0048;
                case 1: goto L_0x0045;
                case 2: goto L_0x0042;
                case 3: goto L_0x0041;
                case 4: goto L_0x0040;
                default: goto L_0x003f;
            }
        L_0x003f:
            return r0
        L_0x0040:
            return r0
        L_0x0041:
            return r0
        L_0x0042:
            java.lang.String r1 = "https://twitter.com"
            return r1
        L_0x0045:
            java.lang.String r1 = "https://www.facebook.com"
            return r1
        L_0x0048:
            java.lang.String r1 = "https://accounts.google.com"
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.firebase.p119ui.auth.p121b.p123b.C2029d.m8225a(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003e  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m8226b(java.lang.String r2) {
        /*
            int r0 = r2.hashCode()
            r1 = -376862683(0xffffffffe9898825, float:-2.078322E25)
            if (r0 == r1) goto L_0x0028
            r1 = 746549591(0x2c7f7157, float:3.6300596E-12)
            if (r0 == r1) goto L_0x001e
            r1 = 1721158175(0x6696ca1f, float:3.5604172E23)
            if (r0 == r1) goto L_0x0014
            goto L_0x0032
        L_0x0014:
            java.lang.String r0 = "https://www.facebook.com"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0032
            r2 = 1
            goto L_0x0033
        L_0x001e:
            java.lang.String r0 = "https://twitter.com"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0032
            r2 = 2
            goto L_0x0033
        L_0x0028:
            java.lang.String r0 = "https://accounts.google.com"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0032
            r2 = 0
            goto L_0x0033
        L_0x0032:
            r2 = -1
        L_0x0033:
            switch(r2) {
                case 0: goto L_0x003e;
                case 1: goto L_0x003b;
                case 2: goto L_0x0038;
                default: goto L_0x0036;
            }
        L_0x0036:
            r2 = 0
            return r2
        L_0x0038:
            java.lang.String r2 = "twitter.com"
            return r2
        L_0x003b:
            java.lang.String r2 = "facebook.com"
            return r2
        L_0x003e:
            java.lang.String r2 = "google.com"
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.firebase.p119ui.auth.p121b.p123b.C2029d.m8226b(java.lang.String):java.lang.String");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    public void onStart() {
        super.onStart();
        if (this.f6275c != null) {
            mo11832a(((Integer) this.f6275c.first).intValue(), (Intent) this.f6275c.second);
        } else if (this.f6274b) {
            mo11882d().mo11908a(R.string.fui_progress_dialog_loading);
            this.f6274b = false;
        }
    }

    public void onStop() {
        super.onStop();
        this.f6274b = mo11882d().mo11909b();
        mo11882d().mo11907a();
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.f6273a != null) {
            this.f6273a.disconnect();
        }
    }

    /* renamed from: a */
    public void mo11832a(int i, Intent intent) {
        if (getActivity() == null) {
            this.f6275c = new Pair<>(Integer.valueOf(i), intent);
        } else {
            super.mo11832a(i, intent);
        }
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        Toast.makeText(getContext(), R.string.fui_general_error, 0).show();
    }
}
