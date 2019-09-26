package com.bridgefy.sdk.framework.controller;

import android.util.Log;
import com.bridgefy.sdk.client.Bridgefy;
import com.bridgefy.sdk.client.Config.Antenna;
import com.bridgefy.sdk.framework.exceptions.ConnectionException;

/* renamed from: com.bridgefy.sdk.framework.controller.ak */
class server_factory {

    /* renamed from: a */
    private static bluetooth_server f5908a;

    /* renamed from: b */
    private static bluetooth_le_server f5909b;

    /* renamed from: a */
    static C1899aj get_server_instance(Antenna antenna, boolean z) {
        switch (antenna) {
            case BLUETOOTH:
                if (f5908a == null && z) {
                    try {
                        f5908a = new bluetooth_server(Bridgefy.getInstance().getConfig(), false, Bridgefy.getInstance().getBridgefyCore().getContext());
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
                        f5909b = new bluetooth_le_server(Bridgefy.getInstance().getConfig(), Bridgefy.getInstance().getBridgefyCore().getContext());
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
    static void m7843a(bluetooth_server nVar) {
        f5908a = nVar;
    }

    /* renamed from: a */
    static void m7842a(bluetooth_le_server lVar) {
        f5909b = lVar;
    }
}
