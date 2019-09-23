package com.p103a.p104a.p106b;

import android.annotation.TargetApi;
import android.app.Activity;
import java.util.concurrent.ExecutorService;
import p000a.p001a.p002a.p003a.C0000a;
import p000a.p001a.p002a.p003a.C0000a.C0003b;

@TargetApi(14)
/* renamed from: com.a.a.b.b */
/* compiled from: ActivityLifecycleCheckForUpdatesController */
class C1735b extends C1734a {

    /* renamed from: a */
    private final C0003b f5454a = new C0003b() {
        /* renamed from: a */
        public void mo10a(Activity activity) {
            if (C1735b.this.mo6998a()) {
                C1735b.this.f5455b.submit(new Runnable() {
                    public void run() {
                        C1735b.this.mo7000c();
                    }
                });
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final ExecutorService f5455b;

    public C1735b(C0000a aVar, ExecutorService executorService) {
        this.f5455b = executorService;
        aVar.mo2a(this.f5454a);
    }
}
