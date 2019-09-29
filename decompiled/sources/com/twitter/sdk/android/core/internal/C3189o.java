package com.twitter.sdk.android.core.internal;

import com.bridgefy.sdk.framework.entities.BleHandshake;
import com.twitter.sdk.android.core.C3257n;
import com.twitter.sdk.android.core.C3274y;
import com.twitter.sdk.android.core.internal.scribe.C3210a;
import com.twitter.sdk.android.core.internal.scribe.C3211aa;
import com.twitter.sdk.android.core.internal.scribe.C3215e;
import com.twitter.sdk.android.core.internal.scribe.C3215e.C3216a;
import com.twitter.sdk.android.core.services.AccountService;
import java.io.IOException;

/* renamed from: com.twitter.sdk.android.core.internal.o */
/* compiled from: TwitterSessionVerifier */
public class C3189o implements C3186l<C3274y> {

    /* renamed from: a */
    private final C3190a f8358a = new C3190a();

    /* renamed from: b */
    private final C3210a f8359b = C3211aa.m9412a();

    /* renamed from: com.twitter.sdk.android.core.internal.o$a */
    /* compiled from: TwitterSessionVerifier */
    protected static class C3190a {
        protected C3190a() {
        }

        /* renamed from: a */
        public AccountService mo27714a(C3274y yVar) {
            return new C3257n(yVar).mo27858a();
        }
    }

    /* renamed from: a */
    public void mo27710a(C3274y yVar) {
        AccountService a = this.f8358a.mo27714a(yVar);
        try {
            m9335a();
            a.verifyCredentials(Boolean.valueOf(true), Boolean.valueOf(false), Boolean.valueOf(false)).mo28206a();
        } catch (IOException | RuntimeException unused) {
        }
    }

    /* renamed from: a */
    private void m9335a() {
        if (this.f8359b != null) {
            C3215e a = new C3216a().mo27783a(BleHandshake.DEVICE_TYPE).mo27785b("credentials").mo27786c("").mo27787d("").mo27788e("").mo27789f("impression").mo27784a();
            this.f8359b.mo27770a(a);
        }
    }
}
