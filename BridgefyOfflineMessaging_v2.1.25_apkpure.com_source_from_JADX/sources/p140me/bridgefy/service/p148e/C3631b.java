package p140me.bridgefy.service.p148e;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import p140me.bridgefy.service.p146c.C3619a;

/* renamed from: me.bridgefy.service.e.b */
/* compiled from: PeerBroadcastReceiver */
public class C3631b extends BroadcastReceiver {

    /* renamed from: a */
    private C3619a f9582a;

    /* renamed from: b */
    private String f9583b;

    public C3631b(String str, C3619a aVar) {
        this.f9582a = aVar;
        this.f9583b = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReceive(android.content.Context r4, android.content.Intent r5) {
        /*
            r3 = this;
            java.lang.String r4 = r5.getAction()
            java.lang.String r0 = "bridgefyDevice"
            android.os.Parcelable r0 = r5.getParcelableExtra(r0)
            me.bridgefy.entities.BridgefyPeer r0 = (p140me.bridgefy.entities.BridgefyPeer) r0
            java.lang.String r1 = "peerConnectionType"
            java.io.Serializable r5 = r5.getSerializableExtra(r1)
            com.bridgefy.sdk.client.Config$Antenna r5 = (com.bridgefy.sdk.client.Config.Antenna) r5
            int r1 = r4.hashCode()
            r2 = -1566110004(0xffffffffa2a70ecc, float:-4.5281108E-18)
            if (r1 == r2) goto L_0x004b
            r2 = 476010634(0x1c5f588a, float:7.3898945E-22)
            if (r1 == r2) goto L_0x0041
            r2 = 780943002(0x2e8c3e9a, float:6.377583E-11)
            if (r1 == r2) goto L_0x0037
            r2 = 1381257706(0x525451ea, float:2.27976839E11)
            if (r1 == r2) goto L_0x002d
            goto L_0x0055
        L_0x002d:
            java.lang.String r1 = "appOpened"
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L_0x0055
            r4 = 3
            goto L_0x0056
        L_0x0037:
            java.lang.String r1 = "deviceLost"
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L_0x0055
            r4 = 1
            goto L_0x0056
        L_0x0041:
            java.lang.String r1 = "deviceClearAll"
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L_0x0055
            r4 = 2
            goto L_0x0056
        L_0x004b:
            java.lang.String r1 = "deviceFound"
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L_0x0055
            r4 = 0
            goto L_0x0056
        L_0x0055:
            r4 = -1
        L_0x0056:
            switch(r4) {
                case 0: goto L_0x006c;
                case 1: goto L_0x0060;
                case 2: goto L_0x005a;
                default: goto L_0x0059;
            }
        L_0x0059:
            goto L_0x0071
        L_0x005a:
            me.bridgefy.service.c.a r4 = r3.f9582a
            r4.mo29014a(r5)
            goto L_0x0071
        L_0x0060:
            boolean r4 = r0.isPeerNearby()
            if (r4 != 0) goto L_0x0071
            me.bridgefy.service.c.a r4 = r3.f9582a
            r4.mo29018b(r0, r5)
            goto L_0x0071
        L_0x006c:
            me.bridgefy.service.c.a r4 = r3.f9582a
            r4.mo29017a(r0, r5)
        L_0x0071:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p140me.bridgefy.service.p148e.C3631b.onReceive(android.content.Context, android.content.Intent):void");
    }

    /* renamed from: a */
    public IntentFilter mo29681a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("deviceFound");
        intentFilter.addAction("deviceLost");
        intentFilter.addAction("deviceClearAll");
        intentFilter.addAction("appOpened");
        return intentFilter;
    }
}
