package com.twitter.sdk.android.tweetui;

import com.bridgefy.sdk.framework.entities.BleHandshake;
import com.twitter.sdk.android.core.internal.scribe.C3215e;
import com.twitter.sdk.android.core.internal.scribe.C3215e.C3216a;
import com.twitter.sdk.android.core.internal.scribe.C3243w;
import java.util.ArrayList;

/* renamed from: com.twitter.sdk.android.tweetui.o */
/* compiled from: VideoScribeClientImpl */
class C3365o implements C3364n {

    /* renamed from: a */
    final C3363m f8789a;

    C3365o(C3363m mVar) {
        this.f8789a = mVar;
    }

    /* renamed from: a */
    public void mo28166a(C3243w wVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(wVar);
        this.f8789a.mo28160a(m9833a(), arrayList);
    }

    /* renamed from: a */
    static C3215e m9833a() {
        return new C3216a().mo27783a("tfw").mo27785b(BleHandshake.DEVICE_TYPE).mo27786c("video").mo27789f("play").mo27784a();
    }
}
