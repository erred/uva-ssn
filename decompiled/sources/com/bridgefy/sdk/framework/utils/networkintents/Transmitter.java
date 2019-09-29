package com.bridgefy.sdk.framework.utils.networkintents;

import android.content.Intent;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Transmitter {

    /* renamed from: a */
    private String multicast_address;

    /* renamed from: b */
    private int multicast_port;

    public Transmitter() {
        this("225.4.5.6", 5775);
    }

    public Transmitter(int i) {
        this("225.4.5.6", i);
    }

    public Transmitter(String str, int i) {
        this.multicast_address = str;
        this.multicast_port = i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0039  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void transmit(android.content.Intent r4) throws com.bridgefy.sdk.framework.utils.networkintents.TransmitterException {
        /*
            r3 = this;
            r0 = 0
            java.net.MulticastSocket r1 = r3.new_multicast_socket()     // Catch:{ UnknownHostException -> 0x002e, SocketException -> 0x0025, IOException -> 0x001c }
            r3.send_intent_multicast(r1, r4)     // Catch:{ UnknownHostException -> 0x0017, SocketException -> 0x0014, IOException -> 0x0011, all -> 0x000e }
            if (r1 == 0) goto L_0x000d
            r1.close()
        L_0x000d:
            return
        L_0x000e:
            r4 = move-exception
            r0 = r1
            goto L_0x0037
        L_0x0011:
            r4 = move-exception
            r0 = r1
            goto L_0x001d
        L_0x0014:
            r4 = move-exception
            r0 = r1
            goto L_0x0026
        L_0x0017:
            r4 = move-exception
            r0 = r1
            goto L_0x002f
        L_0x001a:
            r4 = move-exception
            goto L_0x0037
        L_0x001c:
            r4 = move-exception
        L_0x001d:
            com.bridgefy.sdk.framework.utils.networkintents.TransmitterException r1 = new com.bridgefy.sdk.framework.utils.networkintents.TransmitterException     // Catch:{ all -> 0x001a }
            java.lang.String r2 = "IOException during sending intent"
            r1.<init>(r2, r4)     // Catch:{ all -> 0x001a }
            throw r1     // Catch:{ all -> 0x001a }
        L_0x0025:
            r4 = move-exception
        L_0x0026:
            com.bridgefy.sdk.framework.utils.networkintents.TransmitterException r1 = new com.bridgefy.sdk.framework.utils.networkintents.TransmitterException     // Catch:{ all -> 0x001a }
            java.lang.String r2 = "Can't create DatagramSocket"
            r1.<init>(r2, r4)     // Catch:{ all -> 0x001a }
            throw r1     // Catch:{ all -> 0x001a }
        L_0x002e:
            r4 = move-exception
        L_0x002f:
            com.bridgefy.sdk.framework.utils.networkintents.TransmitterException r1 = new com.bridgefy.sdk.framework.utils.networkintents.TransmitterException     // Catch:{ all -> 0x001a }
            java.lang.String r2 = "Unknown host"
            r1.<init>(r2, r4)     // Catch:{ all -> 0x001a }
            throw r1     // Catch:{ all -> 0x001a }
        L_0x0037:
            if (r0 == 0) goto L_0x003c
            r0.close()
        L_0x003c:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bridgefy.sdk.framework.utils.networkintents.Transmitter.transmit(android.content.Intent):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0039  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void transmit(com.bridgefy.sdk.framework.utils.networkintents.Result r4) throws com.bridgefy.sdk.framework.utils.networkintents.TransmitterException {
        /*
            r3 = this;
            r0 = 0
            java.net.MulticastSocket r1 = r3.new_multicast_socket()     // Catch:{ UnknownHostException -> 0x002e, SocketException -> 0x0025, IOException -> 0x001c }
            r3.send_result_multicast(r1, r4)     // Catch:{ UnknownHostException -> 0x0017, SocketException -> 0x0014, IOException -> 0x0011, all -> 0x000e }
            if (r1 == 0) goto L_0x000d
            r1.close()
        L_0x000d:
            return
        L_0x000e:
            r4 = move-exception
            r0 = r1
            goto L_0x0037
        L_0x0011:
            r4 = move-exception
            r0 = r1
            goto L_0x001d
        L_0x0014:
            r4 = move-exception
            r0 = r1
            goto L_0x0026
        L_0x0017:
            r4 = move-exception
            r0 = r1
            goto L_0x002f
        L_0x001a:
            r4 = move-exception
            goto L_0x0037
        L_0x001c:
            r4 = move-exception
        L_0x001d:
            com.bridgefy.sdk.framework.utils.networkintents.TransmitterException r1 = new com.bridgefy.sdk.framework.utils.networkintents.TransmitterException     // Catch:{ all -> 0x001a }
            java.lang.String r2 = "IOException during sending intent"
            r1.<init>(r2, r4)     // Catch:{ all -> 0x001a }
            throw r1     // Catch:{ all -> 0x001a }
        L_0x0025:
            r4 = move-exception
        L_0x0026:
            com.bridgefy.sdk.framework.utils.networkintents.TransmitterException r1 = new com.bridgefy.sdk.framework.utils.networkintents.TransmitterException     // Catch:{ all -> 0x001a }
            java.lang.String r2 = "Can't create DatagramSocket"
            r1.<init>(r2, r4)     // Catch:{ all -> 0x001a }
            throw r1     // Catch:{ all -> 0x001a }
        L_0x002e:
            r4 = move-exception
        L_0x002f:
            com.bridgefy.sdk.framework.utils.networkintents.TransmitterException r1 = new com.bridgefy.sdk.framework.utils.networkintents.TransmitterException     // Catch:{ all -> 0x001a }
            java.lang.String r2 = "Unknown host"
            r1.<init>(r2, r4)     // Catch:{ all -> 0x001a }
            throw r1     // Catch:{ all -> 0x001a }
        L_0x0037:
            if (r0 == 0) goto L_0x003c
            r0.close()
        L_0x003c:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bridgefy.sdk.framework.utils.networkintents.Transmitter.transmit(com.bridgefy.sdk.framework.utils.networkintents.Result):void");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public MulticastSocket new_multicast_socket() throws IOException {
        return new MulticastSocket();
    }

    /* renamed from: a */
    private void send_intent_multicast(MulticastSocket multicastSocket, Intent intent) throws IOException {
        byte[] bytes = intent.toUri(0).getBytes();
        multicastSocket.send(new DatagramPacket(bytes, bytes.length, InetAddress.getByName(this.multicast_address), this.multicast_port));
    }

    /* renamed from: a */
    private void send_result_multicast(MulticastSocket multicastSocket, Result result) throws IOException {
        byte[] bytes = new Gson().toJson((Object) result).getBytes();
        multicastSocket.send(new DatagramPacket(bytes, bytes.length, InetAddress.getByName(this.multicast_address), this.multicast_port));
    }
}
