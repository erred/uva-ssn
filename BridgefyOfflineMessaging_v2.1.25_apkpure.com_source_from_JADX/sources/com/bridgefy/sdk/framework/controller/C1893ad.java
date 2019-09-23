package com.bridgefy.sdk.framework.controller;

import android.content.Context;
import com.bridgefy.sdk.client.Bridgefy;
import com.bridgefy.sdk.client.Config;
import com.bridgefy.sdk.client.MessageListener;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.bridgefy.sdk.framework.controller.ad */
abstract class C1893ad<M> {

    /* renamed from: a */
    protected final String f5889a = getClass().getSimpleName();

    /* renamed from: b */
    protected Config f5890b;

    /* renamed from: c */
    protected Context f5891c;

    /* renamed from: d */
    CopyOnWriteArrayList<M> f5892d = new CopyOnWriteArrayList<>();

    /* renamed from: e */
    private ConcurrentHashMap<String, List<M>> f5893e = new ConcurrentHashMap<>();

    C1893ad() {
    }

    /* renamed from: a */
    public void mo7436a(Context context) {
        this.f5891c = context;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo7437a() {
        return Bridgefy.getInstance().getBridgefyCore().mo7363c() != null;
    }

    /* renamed from: b */
    public MessageListener mo7439b() {
        return Bridgefy.getInstance().getBridgefyCore().mo7363c();
    }

    /* renamed from: a */
    public boolean mo7438a(M m) {
        return this.f5892d.contains(m);
    }
}
