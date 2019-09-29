package com.twitter.sdk.android.core.internal.scribe;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* renamed from: com.twitter.sdk.android.core.internal.scribe.d */
/* compiled from: EnabledScribeStrategy */
class C3214d extends C3213c<C3238s> {

    /* renamed from: f */
    private final C3229n f8422f;

    public C3214d(Context context, ScheduledExecutorService scheduledExecutorService, C3241u uVar, C3237r rVar, ScribeFilesSender scribeFilesSender) {
        super(context, scheduledExecutorService, uVar);
        this.f8422f = scribeFilesSender;
        mo27776a(rVar.f8490h);
    }

    /* renamed from: d */
    public C3229n mo27775d() {
        return this.f8422f;
    }
}
