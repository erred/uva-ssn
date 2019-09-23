package com.bridgefy.sdk.framework.utils.networkintents;

import android.content.Intent;
import android.os.Bundle;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;

/* renamed from: com.bridgefy.sdk.framework.utils.networkintents.a */
class C1943a extends Thread {

    /* renamed from: a */
    private String f6075a;

    /* renamed from: b */
    private int f6076b;

    /* renamed from: c */
    private MulticastSocket f6077c;

    /* renamed from: d */
    private DiscoveryListener f6078d;

    /* renamed from: e */
    private volatile boolean f6079e;

    C1943a(String str, int i, DiscoveryListener discoveryListener) {
        this.f6075a = str;
        this.f6076b = i;
        this.f6078d = discoveryListener;
    }

    public void run() {
        this.f6079e = true;
        this.f6078d.onDiscoveryStarted();
        try {
            this.f6077c = mo7696a();
            mo7698c();
        } catch (IOException e) {
            if (this.f6079e) {
                this.f6078d.onDiscoveryError(e);
            }
        } catch (Throwable th) {
            m8069d();
            throw th;
        }
        m8069d();
        this.f6078d.onDiscoveryStopped();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public MulticastSocket mo7696a() throws IOException {
        InetAddress byName = InetAddress.getByName(this.f6075a);
        MulticastSocket multicastSocket = new MulticastSocket(this.f6076b);
        multicastSocket.joinGroup(byName);
        return multicastSocket;
    }

    /* renamed from: d */
    private void m8069d() {
        if (this.f6077c != null) {
            this.f6077c.close();
        }
    }

    /* renamed from: b */
    public void mo7697b() {
        this.f6079e = false;
        m8069d();
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo7698c() throws IOException {
        while (this.f6079e) {
            DatagramPacket datagramPacket = new DatagramPacket(new byte[102400], 102400);
            try {
                this.f6077c.receive(datagramPacket);
                try {
                    Result result = (Result) new Gson().fromJson(new String(datagramPacket.getData(), 0, datagramPacket.getLength()), Result.class);
                    if (result != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString(JavaHelper.PROP_SERVICE_NAME, result.getSn());
                        bundle.putString(JavaHelper.PROP_USER_ID, result.getUi());
                        this.f6078d.onIntentDiscovered(datagramPacket.getAddress(), new Intent().putExtras(bundle));
                    }
                } catch (JsonSyntaxException e) {
                    e.printStackTrace();
                }
            } catch (SocketException unused) {
            }
        }
    }
}
