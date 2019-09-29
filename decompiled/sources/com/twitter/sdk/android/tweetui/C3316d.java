package com.twitter.sdk.android.tweetui;

import com.bridgefy.sdk.framework.entities.BleHandshake;
import com.twitter.sdk.android.core.internal.scribe.C3215e;
import com.twitter.sdk.android.core.internal.scribe.C3215e.C3216a;
import com.twitter.sdk.android.core.internal.scribe.C3243w;
import java.util.ArrayList;

/* renamed from: com.twitter.sdk.android.tweetui.d */
/* compiled from: GalleryScribeClientImpl */
public class C3316d implements C3315c {

    /* renamed from: a */
    final C3363m f8649a;

    public C3316d(C3363m mVar) {
        this.f8649a = mVar;
    }

    /* renamed from: a */
    public void mo27998a() {
        this.f8649a.mo28161a(m9663e());
    }

    /* renamed from: a */
    public void mo27999a(C3243w wVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(wVar);
        this.f8649a.mo28160a(m9662d(), arrayList);
    }

    /* renamed from: b */
    public void mo28000b() {
        this.f8649a.mo28161a(m9664f());
    }

    /* renamed from: c */
    public void mo28001c() {
        this.f8649a.mo28161a(m9665g());
    }

    /* renamed from: d */
    static C3215e m9662d() {
        return new C3216a().mo27783a("tfw").mo27785b(BleHandshake.DEVICE_TYPE).mo27786c("gallery").mo27789f("impression").mo27784a();
    }

    /* renamed from: e */
    static C3215e m9663e() {
        return new C3216a().mo27783a("tfw").mo27785b(BleHandshake.DEVICE_TYPE).mo27786c("gallery").mo27789f("show").mo27784a();
    }

    /* renamed from: f */
    static C3215e m9664f() {
        return new C3216a().mo27783a("tfw").mo27785b(BleHandshake.DEVICE_TYPE).mo27786c("gallery").mo27789f("navigate").mo27784a();
    }

    /* renamed from: g */
    static C3215e m9665g() {
        return new C3216a().mo27783a("tfw").mo27785b(BleHandshake.DEVICE_TYPE).mo27786c("gallery").mo27789f("dismiss").mo27784a();
    }
}
