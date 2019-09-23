package p140me.bridgefy.service.p144a;

import android.content.Intent;
import android.util.Log;
import androidx.p079f.p080a.C1049a;
import com.bridgefy.sdk.client.Config.Antenna;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import p140me.bridgefy.entities.BridgefyPeer;
import p140me.bridgefy.main.BridgefyApp;

/* renamed from: me.bridgefy.service.a.a */
/* compiled from: ActivePeers */
public class C3615a {

    /* renamed from: a */
    private static C3615a f9541a;

    /* renamed from: b */
    private CopyOnWriteArrayList<BridgefyPeer> f9542b = new CopyOnWriteArrayList<>();

    /* renamed from: c */
    private HashMap<String, ScheduledFuture> f9543c = new HashMap<>();

    /* renamed from: d */
    private ScheduledThreadPoolExecutor f9544d = new ScheduledThreadPoolExecutor(1);

    private C3615a() {
    }

    /* renamed from: a */
    public static C3615a m10678a() {
        if (f9541a == null) {
            f9541a = new C3615a();
        }
        return f9541a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002c, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo29650a(p140me.bridgefy.entities.BridgefyPeer r4, com.bridgefy.sdk.client.Config.Antenna r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            if (r4 != 0) goto L_0x000e
            java.lang.String r4 = "ActivePeers"
            java.lang.String r5 = "addPeerIfNotExist: peer is null"
            android.util.Log.e(r4, r5)     // Catch:{ all -> 0x000c }
            monitor-exit(r3)
            return
        L_0x000c:
            r4 = move-exception
            goto L_0x002d
        L_0x000e:
            r0 = 1
            java.lang.String r1 = r4.getId()     // Catch:{ all -> 0x000c }
            me.bridgefy.entities.BridgefyPeer r1 = r3.m10679b(r1, r5)     // Catch:{ all -> 0x000c }
            if (r1 == 0) goto L_0x0026
            int[] r1 = p140me.bridgefy.service.p144a.C3615a.C36161.f9545a     // Catch:{ all -> 0x000c }
            int r2 = r5.ordinal()     // Catch:{ all -> 0x000c }
            r1 = r1[r2]     // Catch:{ all -> 0x000c }
            switch(r1) {
                case 1: goto L_0x0025;
                case 2: goto L_0x0025;
                default: goto L_0x0024;
            }     // Catch:{ all -> 0x000c }
        L_0x0024:
            goto L_0x0026
        L_0x0025:
            r0 = 0
        L_0x0026:
            if (r0 == 0) goto L_0x002b
            r3.m10680b(r4, r5)     // Catch:{ all -> 0x000c }
        L_0x002b:
            monitor-exit(r3)
            return
        L_0x002d:
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p140me.bridgefy.service.p144a.C3615a.mo29650a(me.bridgefy.entities.BridgefyPeer, com.bridgefy.sdk.client.Config$Antenna):void");
    }

    /* renamed from: b */
    private synchronized BridgefyPeer m10679b(String str, Antenna antenna) {
        switch (antenna) {
            case BLUETOOTH_LE:
            case BLUETOOTH:
                return m10677a(str, this.f9542b);
            default:
                return null;
        }
    }

    /* renamed from: a */
    public boolean mo29651a(String str) {
        Iterator it = this.f9542b.iterator();
        while (it.hasNext()) {
            if (((BridgefyPeer) it.next()).getId().equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public synchronized BridgefyPeer mo29653b(String str) {
        if (str == null) {
            return null;
        }
        return m10677a(str, this.f9542b);
    }

    /* renamed from: a */
    private BridgefyPeer m10677a(String str, CopyOnWriteArrayList<BridgefyPeer> copyOnWriteArrayList) {
        if (str == null) {
            return null;
        }
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            BridgefyPeer bridgefyPeer = (BridgefyPeer) it.next();
            if (bridgefyPeer.getId() != null && bridgefyPeer.getId().trim().equalsIgnoreCase(str.trim())) {
                return bridgefyPeer;
            }
        }
        return null;
    }

    /* renamed from: b */
    private synchronized void m10680b(BridgefyPeer bridgefyPeer, Antenna antenna) {
        switch (antenna) {
            case BLUETOOTH_LE:
            case BLUETOOTH:
                this.f9542b.add(bridgefyPeer);
                break;
        }
    }

    /* renamed from: a */
    public void mo29649a(String str, Antenna antenna) {
        BridgefyPeer b = m10679b(str, antenna);
        if (b != null) {
            m10681c(b, antenna);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004e, code lost:
        return;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m10681c(p140me.bridgefy.entities.BridgefyPeer r4, com.bridgefy.sdk.client.Config.Antenna r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            if (r4 != 0) goto L_0x0005
            monitor-exit(r3)
            return
        L_0x0005:
            int[] r0 = p140me.bridgefy.service.p144a.C3615a.C36161.f9545a     // Catch:{ all -> 0x004f }
            int r1 = r5.ordinal()     // Catch:{ all -> 0x004f }
            r0 = r0[r1]     // Catch:{ all -> 0x004f }
            switch(r0) {
                case 1: goto L_0x0011;
                case 2: goto L_0x0011;
                default: goto L_0x0010;
            }     // Catch:{ all -> 0x004f }
        L_0x0010:
            goto L_0x003c
        L_0x0011:
            java.lang.String r0 = "ActivePeers"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x004f }
            r1.<init>()     // Catch:{ all -> 0x004f }
            java.lang.String r2 = "Removed peer from BT: "
            r1.append(r2)     // Catch:{ all -> 0x004f }
            java.lang.String r2 = r4.getId()     // Catch:{ all -> 0x004f }
            r1.append(r2)     // Catch:{ all -> 0x004f }
            java.lang.String r2 = ", "
            r1.append(r2)     // Catch:{ all -> 0x004f }
            java.lang.String r2 = r4.getDisplayName()     // Catch:{ all -> 0x004f }
            r1.append(r2)     // Catch:{ all -> 0x004f }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x004f }
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x004f }
            java.util.concurrent.CopyOnWriteArrayList<me.bridgefy.entities.BridgefyPeer> r0 = r3.f9542b     // Catch:{ all -> 0x004f }
            r0.remove(r4)     // Catch:{ all -> 0x004f }
        L_0x003c:
            boolean r0 = r4.isPeerNearby()     // Catch:{ all -> 0x004f }
            if (r0 != 0) goto L_0x0046
            r3.m10682d(r4, r5)     // Catch:{ all -> 0x004f }
            goto L_0x004d
        L_0x0046:
            java.lang.String r4 = "ActivePeers"
            java.lang.String r5 = "Peer is still nearby."
            android.util.Log.v(r4, r5)     // Catch:{ all -> 0x004f }
        L_0x004d:
            monitor-exit(r3)
            return
        L_0x004f:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p140me.bridgefy.service.p144a.C3615a.m10681c(me.bridgefy.entities.BridgefyPeer, com.bridgefy.sdk.client.Config$Antenna):void");
    }

    /* renamed from: d */
    private void m10682d(BridgefyPeer bridgefyPeer, Antenna antenna) {
        StringBuilder sb = new StringBuilder();
        sb.append("Broadcasting Lost Peer: ");
        sb.append(bridgefyPeer.getId());
        Log.v("ActivePeers", sb.toString());
        C1049a.m3996a(BridgefyApp.m10557c().getApplicationContext()).mo4060a(new Intent("deviceLost").putExtra("bridgefyDevice", bridgefyPeer).putExtra("peerConnectionType", antenna));
    }

    /* renamed from: a */
    public synchronized void mo29648a(Antenna antenna) {
        switch (antenna) {
            case BLUETOOTH_LE:
            case BLUETOOTH:
                this.f9542b.clear();
                break;
            default:
                this.f9542b.clear();
                break;
        }
    }

    /* renamed from: b */
    public List<BridgefyPeer> mo29652b() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f9542b);
        return arrayList;
    }
}
