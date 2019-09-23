package com.firebase.p119ui.auth.p124ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.appcompat.app.C0448d;
import com.firebase.p119ui.auth.C2034c;
import com.firebase.p119ui.auth.p121b.C2017a;
import com.firebase.p119ui.auth.p121b.C2033e;
import com.firebase.p119ui.auth.p121b.p123b.C2024b;
import com.google.firebase.auth.FirebaseUser;

/* renamed from: com.firebase.ui.auth.ui.d */
/* compiled from: HelperActivityBase */
public class C2051d extends C0448d {

    /* renamed from: a */
    private C2048b f6328a;

    /* renamed from: b */
    private C2017a f6329b;

    /* renamed from: c */
    private C2076f f6330c;

    /* renamed from: a */
    public static Intent m8287a(Context context, Class<? extends Activity> cls, C2048b bVar) {
        return new Intent((Context) C2033e.m8233a(context, "context cannot be null", new Object[0]), (Class) C2033e.m8233a(cls, "target activity cannot be null", new Object[0])).putExtra("extra_flow_params", (Parcelable) C2033e.m8233a(bVar, "flowParams cannot be null", new Object[0]));
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6329b = new C2017a(mo11886b());
        this.f6330c = new C2076f(this);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f6330c.mo11907a();
    }

    /* renamed from: b */
    public C2048b mo11886b() {
        if (this.f6328a == null) {
            this.f6328a = C2048b.m8277a(getIntent());
        }
        return this.f6328a;
    }

    /* renamed from: c */
    public C2017a mo11887c() {
        return this.f6329b;
    }

    /* renamed from: d */
    public C2076f mo11888d() {
        return this.f6330c;
    }

    /* renamed from: a */
    public void mo11883a(int i, Intent intent) {
        setResult(i, intent);
        finish();
    }

    /* renamed from: a */
    public void mo11884a(C2024b bVar, FirebaseUser firebaseUser, C2034c cVar) {
        mo11885a(bVar, firebaseUser, null, cVar);
    }

    /* renamed from: a */
    public void mo11885a(C2024b bVar, FirebaseUser firebaseUser, String str, C2034c cVar) {
        if (bVar == null) {
            mo11883a(-1, cVar.mo11835a());
        } else {
            bVar.mo11827a(firebaseUser, str, cVar);
        }
    }
}
