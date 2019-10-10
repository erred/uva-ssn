package p140me.bridgefy.integration;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.p079f.p080a.C1049a;
import com.bridgefy.sdk.client.Bridgefy;
import com.bridgefy.sdk.client.Config.Antenna;
import com.bridgefy.sdk.client.Device;
import com.bridgefy.sdk.client.Session;
import com.bridgefy.sdk.client.StateListener;
import com.bridgefy.sdk.framework.utils.Utils;
import p140me.bridgefy.entities.AppHandShake;
import p140me.bridgefy.entities.AppRequestJson;
import p140me.bridgefy.entities.AppResponseJson;
import p140me.bridgefy.entities.BridgefyPeer;
import p140me.bridgefy.entities.transport.AppEntityHandShake;
import p140me.bridgefy.main.C3608c;
import p140me.bridgefy.ormlite.DatabaseHelper;
import p140me.bridgefy.ormlite.entities.FriendDTO;
import p140me.bridgefy.p141a.C3457c;
import p140me.bridgefy.p141a.C3460d;
import p140me.bridgefy.service.p144a.C3615a;

/* renamed from: me.bridgefy.integration.a */
/* compiled from: DeviceCenter */
public class C3547a extends StateListener {

    /* renamed from: a */
    private final String f9287a = getClass().getSimpleName();

    /* renamed from: b */
    private Context f9288b;

    /* renamed from: c */
    private C3457c f9289c;

    /* renamed from: d */
    private C3460d f9290d;

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m10409b() {
    }

    public C3547a(Context context, DatabaseHelper databaseHelper) {
        this.f9288b = context;
        this.f9289c = new C3457c(databaseHelper);
        this.f9290d = new C3460d(databaseHelper);
    }

    public void onStarted() {
        C3608c.m10648b(true);
        Log.i(this.f9287a, "onStarted: Bridgefy has started");
        C1049a.m3996a(m10407a()).mo4060a(new Intent("bridgefy.event.start"));
    }

    public void onStopped() {
        C3608c.m10648b(false);
        Log.w(this.f9287a, "onStopped: Bridgefy has stopped");
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public final void run() {
                C3547a.this.m10409b();
            }
        });
        C1049a.m3996a(m10407a()).mo4060a(new Intent("bridgefy.event.stop"));
    }

    public void onStartError(String str, int i) {
        C3608c.m10648b(false);
        String str2 = this.f9287a;
        StringBuilder sb = new StringBuilder();
        sb.append("onStartError: Bridgefy startup error: ");
        sb.append(str);
        Log.e(str2, sb.toString());
        C1049a.m3996a(m10407a()).mo4060a(new Intent("bridgefy.event.error").putExtra("bridgefy.event.error.message", str).putExtra("bridgefy.event.error.code", i));
    }

    public void onDeviceConnected(Device device, Session session) {
        AppRequestJson appRequestJson;
        Antenna antenna = Antenna.UNREACHABLE;
        String str = this.f9287a;
        StringBuilder sb = new StringBuilder();
        sb.append("... Key from device is: ");
        sb.append(session.getPublicKey());
        Log.v(str, sb.toString());
        switch (Antenna.BLUETOOTH_LE) {
            case BLUETOOTH_LE:
                if (!(device == null || device.getUserId() == null)) {
                    FriendDTO c = this.f9289c.query_friend_dto_by_id(device.getUserId());
                    AppResponseJson appResponseJson = null;
                    if (c != null) {
                        String str2 = this.f9287a;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("... Found friend: ");
                        sb2.append(c.getId());
                        sb2.append(" (");
                        sb2.append(c.buildDisplayName());
                        sb2.append(")");
                        Log.d(str2, sb2.toString());
                        device.setDeviceName(c.buildDisplayName());
                        antenna = Antenna.BLUETOOTH_LE;
                        device.setDeviceName(c.buildDisplayName());
                        if (c.getPhoneNumber() == null) {
                            Log.i(this.f9287a, "onDeviceConnected: requesting telephone");
                            appRequestJson = new AppRequestJson(0);
                        } else {
                            appRequestJson = null;
                        }
                        if (appRequestJson == null) {
                            Log.i(this.f9287a, "onDeviceConnected: preparing handshake HS_RESPONSE_TYPE_FINISH");
                            appResponseJson = AppResponseJson.ResponseTypeHandshakeFinished(c.getId());
                        }
                    } else {
                        Log.w(this.f9287a, "onDeviceConnected: request type general for app");
                        appRequestJson = new AppRequestJson(0);
                    }
                    if (Utils.getCrcFromKey(Bridgefy.getInstance().getBridgefyClient().getUserUuid()) > Utils.getCrcFromKey(device.getUserId())) {
                        AppHandShake appHandShake = new AppHandShake(appRequestJson, appResponseJson);
                        if (appHandShake.getResponseJson() != null) {
                            appHandShake.getResponseJson().setVrf(C3608c.m10650c() ^ true ? 1 : 0);
                        }
                        String str3 = this.f9287a;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("onDeviceConnected: send handshake ---> ");
                        sb3.append(appHandShake.toString());
                        Log.w(str3, sb3.toString());
                        AppEntityHandShake appEntityHandShake = new AppEntityHandShake(appHandShake);
                        if (appEntityHandShake.toString() != null) {
                            device.sendMessage(appEntityHandShake.toHashMap());
                            break;
                        }
                    }
                }
                break;
        }
        m10408a(device, antenna);
    }

    public void onDeviceLost(Device device) {
        FriendDTO friendDTO;
        switch (Antenna.BLUETOOTH_LE) {
            case BLUETOOTH:
            case BLUETOOTH_LE:
                friendDTO = this.f9289c.mo28325d(device.getDeviceAddress());
                C3615a.m10678a().mo29649a(device.getUserId(), Antenna.BLUETOOTH_LE);
                break;
            default:
                friendDTO = null;
                break;
        }
        if (friendDTO != null) {
            this.f9290d.mo28349f(friendDTO.getId());
        }
    }

    /* renamed from: a */
    private Context m10407a() {
        return this.f9288b;
    }

    /* renamed from: a */
    private void m10408a(Device device, Antenna antenna) {
        FriendDTO c = this.f9289c.query_friend_dto_by_id(device.getUserId());
        BridgefyPeer bridgefyPeer = c != null ? new BridgefyPeer(c) : null;
        if (bridgefyPeer != null) {
            C3615a.m10678a().mo29650a(bridgefyPeer, antenna);
            C1049a.m3996a(m10407a()).mo4060a(new Intent("deviceFound").putExtra("bridgefyDevice", bridgefyPeer).putExtra("peerConnectionType", antenna));
            return;
        }
        String str = this.f9287a;
        StringBuilder sb = new StringBuilder();
        sb.append("reportNearbyPeer: peer not found in db ");
        sb.append(device.getDeviceName());
        Log.e(str, sb.toString());
    }
}
