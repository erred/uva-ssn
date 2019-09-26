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
class multicast_discoverer extends Thread {

    /* renamed from: a */
    private String multicast_address;

    /* renamed from: b */
    private int multicast_port;

    /* renamed from: c */
    private MulticastSocket multicast_socket;

    /* renamed from: d */
    private DiscoveryListener discovery_listener;

    /* renamed from: e */
    private volatile boolean is_running;

    multicast_discoverer(String str, int i, DiscoveryListener discoveryListener) {
        this.multicast_address = str;
        this.multicast_port = i;
        this.discovery_listener = discoveryListener;
    }

    public void run() {
        this.is_running = true;
        this.discovery_listener.onDiscoveryStarted();
        try {
            this.multicast_socket = create_multicast_socket();
            run_discovery();
        } catch (IOException e) {
            if (this.is_running) {
                this.discovery_listener.onDiscoveryError(e);
            }
        } catch (Throwable th) {
            close_socket();
            throw th;
        }
        close_socket();
        this.discovery_listener.onDiscoveryStopped();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public MulticastSocket create_multicast_socket() throws IOException {
        InetAddress byName = InetAddress.getByName(this.multicast_address);
        MulticastSocket multicastSocket = new MulticastSocket(this.multicast_port);
        multicastSocket.joinGroup(byName);
        return multicastSocket;
    }

    /* renamed from: d */
    private void close_socket() {
        if (this.multicast_socket != null) {
            this.multicast_socket.close();
        }
    }

    /* renamed from: b */
    public void stop() {
        this.is_running = false;
        close_socket();
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void run_discovery() throws IOException {
        while (this.is_running) {
            DatagramPacket datagramPacket = new DatagramPacket(new byte[102400], 102400);
            try {
                this.multicast_socket.receive(datagramPacket);
                try {
                    Result result = (Result) new Gson().fromJson(new String(datagramPacket.getData(), 0, datagramPacket.getLength()), Result.class);
                    if (result != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString(JavaHelper.PROP_SERVICE_NAME, result.getSn());
                        bundle.putString(JavaHelper.PROP_USER_ID, result.getUi());
                        this.discovery_listener.onIntentDiscovered(datagramPacket.getAddress(), new Intent().putExtras(bundle));
                    }
                } catch (JsonSyntaxException e) {
                    e.printStackTrace();
                }
            } catch (SocketException unused) {
            }
        }
    }
}
