package com.bridgefy.sdk.framework.controller;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.util.Log;
import com.bridgefy.sdk.client.Bridgefy;
import com.bridgefy.sdk.client.BridgefyException;
import com.bridgefy.sdk.client.BridgefyUtils;
import com.bridgefy.sdk.client.Config;
import com.bridgefy.sdk.client.Config.Antenna;
import com.bridgefy.sdk.client.DeviceProfile;
import com.bridgefy.sdk.framework.exceptions.ConnectionException;
import com.bridgefy.sdk.framework.utils.Utils;

/* renamed from: com.bridgefy.sdk.framework.controller.a */
class broadcast_receiver extends BroadcastReceiver {

    /* renamed from: a */
    private final String f5873a = getClass().getSimpleName();

    /* renamed from: b */
    private Config config;

    /* renamed from: c */
    private Context context;

    /* renamed from: d */
    private boolean f5876d = false;

    /* renamed from: e */
    private C1911h f5877e;

    protected broadcast_receiver(Context context, Config config) throws BridgefyException {
        this.config = config;
        this.context = context;
        m7760a(context, config);
    }

    public void onReceive(Context context, Intent intent) {
        this.context = context;
        m7759a(context, intent);
    }

    /* renamed from: a */
    private void m7759a(Context context, Intent intent) {
        switch (this.config.getAntennaType()) {
            case BLUETOOTH:
            case BLUETOOTH_LE:
                m7763b(context, intent);
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    private IntentFilter m7758a() {
        IntentFilter intentFilter = new IntentFilter();
        switch (this.config.getAntennaType()) {
            case BLUETOOTH:
                m7764b(intentFilter);
                break;
            case BLUETOOTH_LE:
                break;
        }
        m7761a(intentFilter);
        return intentFilter;
    }

    /* renamed from: a */
    private void m7761a(IntentFilter intentFilter) {
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
    }

    /* renamed from: b */
    private void m7764b(IntentFilter intentFilter) {
        intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_STARTED");
        intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
        intentFilter.addAction("android.bluetooth.device.action.FOUND");
        intentFilter.addAction("android.bluetooth.device.action.UUID");
        if (VERSION.SDK_INT >= 23) {
            try {
                String str = (String) BluetoothDevice.class.getDeclaredField("EXTRA_SDP_SEARCH_STATUS").get(null);
                intentFilter.addAction((String) BluetoothDevice.class.getDeclaredField("ACTION_SDP_RECORD").get(null));
                intentFilter.addAction(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public void mo7400a(Context context) {
        if (!this.f5876d) {
            context.registerReceiver(this, m7758a());
            this.f5876d = true;
        }
    }

    /* renamed from: b */
    public void mo7402b(Context context) {
        if (this.f5876d) {
            context.unregisterReceiver(this);
            this.f5876d = false;
        }
    }

    /* renamed from: a */
    private void m7760a(Context context, Config config) throws BridgefyException {
        switch (config.getAntennaType()) {
            case BLUETOOTH:
            case BLUETOOTH_LE:
                this.f5877e = new C1911h(context, config);
                return;
            default:
                return;
        }
    }

    /* renamed from: b */
    private void m7763b(Context context, Intent intent) {
        this.f5877e.mo7511a(intent, context);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7401a(Antenna antenna) {
        switch (antenna) {
            case BLUETOOTH:
            case BLUETOOTH_LE:
                m7762b();
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo7403b(Antenna antenna) {
        switch (antenna) {
            case BLUETOOTH:
            case BLUETOOTH_LE:
                m7765c();
                return;
            default:
                return;
        }
    }

    /* renamed from: b */
    private void m7762b() {
        if (BridgefyUtils.getBluetoothAdapter(this.context).isEnabled()) {
            try {
                this.f5877e.mo7515d(this.context);
            } catch (ConnectionException unused) {
            }
        }
    }

    /* renamed from: c */
    private void m7765c() {
        try {
            this.f5877e.mo7512b();
        } catch (ConnectionException e) {
            String str = this.f5873a;
            StringBuilder sb = new StringBuilder();
            sb.append("onBluetoothServerStop: ");
            sb.append(e.getMessage());
            Log.e(str, sb.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo7404c(Antenna antenna) {
        switch (antenna) {
            case BLUETOOTH:
                SessionManager.m7753a(Antenna.BLUETOOTH);
                return;
            case BLUETOOTH_LE:
                SessionManager.m7753a(Antenna.BLUETOOTH_LE);
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo7405d(Antenna antenna) {
        switch (antenna) {
            case BLUETOOTH:
            case BLUETOOTH_LE:
                this.f5877e.mo7510a(this.context);
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo7406e(Antenna antenna) {
        switch (antenna) {
            case BLUETOOTH:
            case BLUETOOTH_LE:
                this.f5877e.stop_discovery(this.context);
                return;
            default:
                return;
        }
    }

    /* renamed from: f */
    public void mo7407f(Antenna antenna) {
        if (C18881.f5878a[antenna.ordinal()] == 2) {
            this.f5877e.stop_advertising();
        }
    }

    /* renamed from: g */
    public void mo7408g(Antenna antenna) {
        if (C18881.f5878a[antenna.ordinal()] == 2) {
            this.f5877e.mo7454a(String.valueOf(Utils.getCrcFromKey(Bridgefy.getInstance().getBridgefyClient().getUserUuid())));
        }
    }

    /* renamed from: h */
    public void mo7409h(Antenna antenna) {
        if (C18881.f5878a[antenna.ordinal()] == 2) {
            if (DeviceProfile.deviceCanStopScan() || SessionManager.getSessionsByType(Antenna.BLUETOOTH_LE).isEmpty()) {
                this.f5877e.stop_discovery(this.context);
                this.f5877e.mo7510a(this.context);
                this.f5877e.stop_advertising();
                this.f5877e.mo7454a(String.valueOf(Utils.getCrcFromKey(Bridgefy.getInstance().getBridgefyClient().getUserUuid())));
            }
        }
    }
}
