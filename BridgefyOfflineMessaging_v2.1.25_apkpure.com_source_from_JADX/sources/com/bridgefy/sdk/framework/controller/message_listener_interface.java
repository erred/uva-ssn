package com.bridgefy.sdk.framework.controller;

import android.content.Context;
import com.bridgefy.sdk.client.Bridgefy;
import com.bridgefy.sdk.client.Config;
import com.bridgefy.sdk.client.MessageListener;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.bridgefy.sdk.framework.controller.ad */
abstract class message_listener_interface<M> {

    /* renamed from: a */
    protected final String simple_name = getClass().getSimpleName();

    /* renamed from: b */
    protected Config config;

    /* renamed from: c */
    protected Context context;

    /* renamed from: d */
    CopyOnWriteArrayList<M> f5892d = new CopyOnWriteArrayList<>();

    /* renamed from: e */
    private ConcurrentHashMap<String, List<M>> f5893e = new ConcurrentHashMap<>();

    message_listener_interface() {
    }

    /* renamed from: a */
    public void set_context(Context context) {
        this.context = context;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean get_message_listener() {
        return Bridgefy.getInstance().getBridgefyCore().get_message_listener() != null;
    }

    /* renamed from: b */
    public MessageListener get_message_listener_obj() {
        return Bridgefy.getInstance().getBridgefyCore().get_message_listener();
    }

    /* renamed from: a */
    public boolean contains(M m) {
        return this.f5892d.contains(m);
    }
}
