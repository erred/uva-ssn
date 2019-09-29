package com.twitter.sdk.android.tweetcomposer;

import java.util.Collections;

/* renamed from: com.twitter.sdk.android.tweetcomposer.c */
/* compiled from: ComposerScribeClientImpl */
class C3296c implements C3295b {

    /* renamed from: a */
    private final C3298e f8611a;

    C3296c(C3298e eVar) {
        if (eVar != null) {
            this.f8611a = eVar;
            return;
        }
        throw new NullPointerException("scribeClient must not be null");
    }

    /* renamed from: a */
    public void mo27961a() {
        this.f8611a.mo27963a(C3300g.f8613a.mo27787d("").mo27788e("").mo27789f("impression").mo27784a(), Collections.EMPTY_LIST);
    }

    /* renamed from: a */
    public void mo27962a(String str) {
        this.f8611a.mo27963a(C3300g.f8613a.mo27787d("").mo27788e(str).mo27789f("click").mo27784a(), Collections.EMPTY_LIST);
    }
}
