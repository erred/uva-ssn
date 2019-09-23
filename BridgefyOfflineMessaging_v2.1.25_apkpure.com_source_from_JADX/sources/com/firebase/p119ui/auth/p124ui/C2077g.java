package com.firebase.p119ui.auth.p124ui;

import android.util.Log;
import com.google.android.gms.tasks.OnFailureListener;

/* renamed from: com.firebase.ui.auth.ui.g */
/* compiled from: TaskFailureLogger */
public class C2077g implements OnFailureListener {

    /* renamed from: a */
    private String f6384a;

    /* renamed from: b */
    private String f6385b;

    public C2077g(String str, String str2) {
        this.f6384a = str;
        this.f6385b = str2;
    }

    public void onFailure(Exception exc) {
        Log.w(this.f6384a, this.f6385b, exc);
    }
}
