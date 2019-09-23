package p140me.bridgefy.utils;

import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import p140me.bridgefy.ormlite.entities.FriendDTO;

/* renamed from: me.bridgefy.utils.P2pAddressAcquisitionService */
public class P2pAddressAcquisitionService extends Service {

    /* renamed from: a */
    BroadcastReceiver f9656a = new BroadcastReceiver() {
        /* access modifiers changed from: private */
        /* renamed from: a */
        public static /* synthetic */ void m10876a() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(action)) {
                if (intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 0) == 12) {
                    P2pAddressAcquisitionService.this.m10867a();
                }
            } else if ("android.net.wifi.p2p.THIS_DEVICE_CHANGED".equals(action)) {
                P2pAddressAcquisitionService.this.f9663h = ((WifiP2pDevice) intent.getParcelableExtra("wifiP2pDevice")).deviceAddress;
                P2pAddressAcquisitionService.this.f9659d.putString("device_address", P2pAddressAcquisitionService.this.f9663h).commit();
                String d = P2pAddressAcquisitionService.this.f9657b;
                StringBuilder sb = new StringBuilder();
                sb.append("Acquired WifiDirect address: ");
                sb.append(P2pAddressAcquisitionService.this.f9663h);
                Log.i(d, sb.toString());
                if (P2pAddressAcquisitionService.this.f9665j) {
                    P2pAddressAcquisitionService.this.f9660e.setWifiEnabled(false);
                }
            } else if ("android.net.wifi.WIFI_STATE_CHANGED".equals(action)) {
                if (intent.getIntExtra("wifi_state", 900) == 1) {
                    P2pAddressAcquisitionService.this.f9660e.setWifiEnabled(true);
                    P2pAddressAcquisitionService.this.f9665j = true;
                }
                ((WifiP2pManager) P2pAddressAcquisitionService.this.getApplicationContext().getSystemService("wifip2p")).initialize(P2pAddressAcquisitionService.this.getApplicationContext(), P2pAddressAcquisitionService.this.getMainLooper(), C3652x28c0ada8.INSTANCE);
            }
            if (P2pAddressAcquisitionService.this.f9658c.getString(FriendDTO.BLUETOOTH_ADDRESS, null) != null && P2pAddressAcquisitionService.this.f9658c.getString("device_address", null) != null) {
                P2pAddressAcquisitionService.this.stopSelf();
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: b */
    public String f9657b = "P2pAddAcqService";
    /* access modifiers changed from: private */

    /* renamed from: c */
    public SharedPreferences f9658c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Editor f9659d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public WifiManager f9660e;

    /* renamed from: f */
    private BluetoothAdapter f9661f;

    /* renamed from: g */
    private final IntentFilter f9662g = new IntentFilter();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public String f9663h;

    /* renamed from: i */
    private String f9664i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f9665j = false;

    /* renamed from: me.bridgefy.utils.P2pAddressAcquisitionService$a */
    public class C3654a extends Binder {
        public C3654a() {
        }
    }

    public IBinder onBind(Intent intent) {
        return new C3654a();
    }

    public void onCreate() {
        super.onCreate();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        Log.i(this.f9657b, "Starting P2pAddressAcquisitionService.");
        this.f9658c = getSharedPreferences("BgfyPrefs", 0);
        this.f9659d = this.f9658c.edit();
        this.f9661f = ((BluetoothManager) getSystemService("bluetooth")).getAdapter();
        if (this.f9661f != null) {
            if (!this.f9661f.isEnabled()) {
                this.f9661f.enable();
                m10867a();
                this.f9661f.disable();
            } else {
                m10867a();
            }
        }
        this.f9660e = (WifiManager) getApplicationContext().getSystemService("wifi");
        if (!this.f9660e.isWifiEnabled()) {
            this.f9660e.setWifiEnabled(true);
            this.f9665j = true;
        }
        this.f9662g.addAction("android.net.wifi.p2p.THIS_DEVICE_CHANGED");
        this.f9662g.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        this.f9662g.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        registerReceiver(this.f9656a, this.f9662g);
        return super.onStartCommand(intent, i, i2);
    }

    public void onDestroy() {
        unregisterReceiver(this.f9656a);
        super.onDestroy();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10867a() {
        this.f9664i = this.f9661f.getAddress();
        this.f9659d.putString(FriendDTO.BLUETOOTH_ADDRESS, this.f9664i).commit();
        String str = this.f9657b;
        StringBuilder sb = new StringBuilder();
        sb.append("Acquired bluetooth address from saveBluetoothAddress(): ");
        sb.append(this.f9664i);
        Log.i(str, sb.toString());
    }
}
