package com.bridgefy.sdk.framework.controller;

import android.bluetooth.BluetoothAdapter;
import android.util.Log;
import com.bridgefy.sdk.client.Bridgefy;
import com.bridgefy.sdk.client.BridgefyUtils;
import com.bridgefy.sdk.client.Config.Antenna;
import com.bridgefy.sdk.client.Device;
import p000a.p013b.C0176d;
import p000a.p013b.p017b.C0161b;
import p000a.p013b.p038h.C0331a;
import p000a.p013b.p039i.C0341a;

/* renamed from: com.bridgefy.sdk.framework.controller.s */
class C1930s extends C0341a<Device> {
    public void onError(Throwable th) {
    }

    C1930s() {
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        request(1);
    }

    /* renamed from: a */
    public void onNext(final Device device) {
        C19311 r0 = new C0176d() {
            public void onSubscribe(C0161b bVar) {
            }

            public void onComplete() {
                C1928r.m8009a((C1932t) null);
                C1930s.this.request(1);
            }

            public void onError(Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("onError: ");
                sb.append(th.getMessage());
                Log.e("Connection_Subscriber", sb.toString());
                C1932t a = C1928r.m8006a();
                if (a != null && a.mo7556b().equals(device)) {
                    if (a instanceof C1910g) {
                        C1930s.this.m8017b(a.mo7556b());
                    }
                    C1928r.m8009a((C1932t) null);
                    C1930s.this.request(1);
                }
            }
        };
        C1932t a = C1928r.m8007a(device);
        if (a == null) {
            request(1);
        } else if (device.getAntennaType() == Antenna.BLUETOOTH_LE) {
            a.mo7509a().mo345a((C0176d) r0);
        } else {
            a.mo7509a().mo347b(C0331a.m925b()).mo345a((C0176d) r0);
        }
    }

    public void onComplete() {
        if (!isDisposed()) {
            dispose();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m8017b(Device device) {
        C1928r.m8012b(DeviceManager.getDevice(device.getDeviceAddress()));
        Log.e("Connection_Subscriber", "accept: Connection failed adding to blacklist");
        SessionManager.m7755a(device.getDeviceAddress());
        BluetoothAdapter bluetoothAdapter = BridgefyUtils.getBluetoothAdapter(Bridgefy.getInstance().getBridgefyCore().getContext());
        if (bluetoothAdapter != null) {
            bluetoothAdapter.startDiscovery();
        }
    }
}
