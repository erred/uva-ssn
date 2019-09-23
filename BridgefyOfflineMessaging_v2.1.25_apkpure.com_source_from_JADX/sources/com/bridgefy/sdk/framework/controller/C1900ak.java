package com.bridgefy.sdk.framework.controller;

import android.util.Log;
import com.bridgefy.sdk.client.Bridgefy;
import com.bridgefy.sdk.client.Config.Antenna;
import com.bridgefy.sdk.framework.exceptions.ConnectionException;

/* renamed from: com.bridgefy.sdk.framework.controller.ak */
class C1900ak {

    /* renamed from: a */
    private static C1924n f5908a;

    /* renamed from: b */
    private static C1921l f5909b;

    /* renamed from: a */
    static C1899aj m7841a(Antenna antenna, boolean z) {
        switch (antenna) {
            case BLUETOOTH:
                if (f5908a == null && z) {
                    try {
                        f5908a = new C1924n(Bridgefy.getInstance().getConfig(), false, Bridgefy.getInstance().getBridgefyCore().getContext());
                    } catch (ConnectionException e) {
                        Log.e("ServerFactory", "getServerInstance: Cannot be possible create a instance of BluetoothServer", e);
                    }
                }
                return f5908a;
            case BLUETOOTH_LE:
                if (f5909b == null && z) {
                    String str = "ServerFactory";
                    try {
                        StringBuilder sb = new StringBuilder();
                        sb.append("getServerInstance: creating new bluetooth le server with context ");
                        sb.append(Bridgefy.getInstance().getBridgefyCore().getContext());
                        Log.w(str, sb.toString());
                        f5909b = new C1921l(Bridgefy.getInstance().getConfig(), Bridgefy.getInstance().getBridgefyCore().getContext());
                    } catch (ConnectionException e2) {
                        e2.printStackTrace();
                    }
                }
                return f5909b;
            default:
                throw new IllegalArgumentException("Server connection type not valid.");
        }
    }

    /* renamed from: a */
    static void m7843a(C1924n nVar) {
        f5908a = nVar;
    }

    /* renamed from: a */
    static void m7842a(C1921l lVar) {
        f5909b = lVar;
    }
}
