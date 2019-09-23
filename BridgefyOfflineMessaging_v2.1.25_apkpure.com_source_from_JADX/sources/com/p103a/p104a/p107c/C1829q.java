package com.p103a.p104a.p107c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.concurrent.atomic.AtomicBoolean;
import p140me.bridgefy.ormlite.entities.MessageDTO;

/* renamed from: com.a.a.c.q */
/* compiled from: DevicePowerStateListener */
class C1829q {

    /* renamed from: a */
    private static final IntentFilter f5651a = new IntentFilter("android.intent.action.BATTERY_CHANGED");

    /* renamed from: b */
    private static final IntentFilter f5652b = new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED");

    /* renamed from: c */
    private static final IntentFilter f5653c = new IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTED");

    /* renamed from: d */
    private final AtomicBoolean f5654d;

    /* renamed from: e */
    private final Context f5655e;

    /* renamed from: f */
    private final BroadcastReceiver f5656f;

    /* renamed from: g */
    private final BroadcastReceiver f5657g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f5658h;

    public C1829q(Context context) {
        this.f5655e = context;
        Intent registerReceiver = context.registerReceiver(null, f5651a);
        int i = -1;
        if (registerReceiver != null) {
            i = registerReceiver.getIntExtra(MessageDTO.STATUS, -1);
        }
        this.f5658h = i == 2 || i == 5;
        this.f5657g = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                C1829q.this.f5658h = true;
            }
        };
        this.f5656f = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                C1829q.this.f5658h = false;
            }
        };
        context.registerReceiver(this.f5657g, f5652b);
        context.registerReceiver(this.f5656f, f5653c);
        this.f5654d = new AtomicBoolean(true);
    }

    /* renamed from: a */
    public boolean mo7157a() {
        return this.f5658h;
    }

    /* renamed from: b */
    public void mo7158b() {
        if (this.f5654d.getAndSet(false)) {
            this.f5655e.unregisterReceiver(this.f5657g);
            this.f5655e.unregisterReceiver(this.f5656f);
        }
    }
}
