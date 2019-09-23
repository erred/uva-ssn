package com.bridgefy.sdk.framework.controller;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothSocket;
import com.bridgefy.sdk.client.Config.Antenna;
import com.bridgefy.sdk.client.Device;
import com.bridgefy.sdk.framework.utils.Utils;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.regex.Pattern;
import p000a.p013b.C0165c;

/* renamed from: com.bridgefy.sdk.framework.controller.d */
abstract class C1907d {

    /* renamed from: a */
    protected final String f5931a = getClass().getSimpleName();

    /* renamed from: b */
    Pattern f5932b = Pattern.compile("\\}");

    /* renamed from: c */
    C0165c f5933c;

    /* renamed from: d */
    private BluetoothGattServer f5934d;

    /* renamed from: e */
    private BluetoothGatt f5935e;

    /* renamed from: f */
    private BluetoothDevice f5936f;

    /* renamed from: g */
    private ArrayList<byte[]> f5937g = new ArrayList<>();

    /* renamed from: h */
    private ArrayList<byte[]> f5938h = new ArrayList<>();

    /* renamed from: i */
    private BluetoothSocket f5939i;

    /* renamed from: j */
    private Socket f5940j;

    /* renamed from: k */
    private String f5941k;

    /* renamed from: l */
    private Device f5942l;

    /* renamed from: m */
    private Antenna f5943m;

    /* renamed from: n */
    private boolean f5944n = false;

    /* renamed from: o */
    private DataOutputStream f5945o;

    /* renamed from: p */
    private DataInputStream f5946p;

    /* renamed from: q */
    private String f5947q;

    /* renamed from: r */
    private String f5948r;

    /* renamed from: s */
    private boolean f5949s;

    public C0165c getEmitter() {
        return this.f5933c;
    }

    C1907d(BluetoothSocket bluetoothSocket) {
        mo7488a(bluetoothSocket);
        mo7489a(Antenna.BLUETOOTH);
        this.f5941k = Utils.generateSessionId();
    }

    C1907d(Socket socket, Antenna antenna) {
        mo7494a(socket);
        mo7489a(antenna);
        this.f5941k = Utils.generateSessionId();
    }

    C1907d(Antenna antenna) {
        mo7489a(antenna);
    }

    C1907d(BluetoothDevice bluetoothDevice, boolean z, C0165c cVar) {
        this.f5933c = cVar;
        mo7485a(bluetoothDevice);
        if (z) {
            mo7489a(Antenna.BLUETOOTH_LE);
        } else {
            mo7489a(Antenna.BLUETOOTH);
        }
    }

    C1907d() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public BluetoothSocket mo7484a() {
        return this.f5939i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7488a(BluetoothSocket bluetoothSocket) {
        this.f5939i = bluetoothSocket;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public Socket mo7496b() {
        return this.f5940j;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7494a(Socket socket) {
        this.f5940j = socket;
    }

    public Device getDevice() {
        return this.f5942l;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7490a(Device device) {
        this.f5942l = device;
    }

    public Antenna getAntennaType() {
        return this.f5943m;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7489a(Antenna antenna) {
        this.f5943m = antenna;
    }

    public boolean isConnected() {
        return this.f5944n;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7379a(boolean z) {
        this.f5944n = z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public DataOutputStream mo7499c() {
        return this.f5945o;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7492a(DataOutputStream dataOutputStream) {
        this.f5945o = dataOutputStream;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public DataInputStream mo7500d() {
        return this.f5946p;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7491a(DataInputStream dataInputStream) {
        this.f5946p = dataInputStream;
    }

    public BluetoothDevice getBluetoothDevice() {
        return this.f5936f;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7485a(BluetoothDevice bluetoothDevice) {
        this.f5936f = bluetoothDevice;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7486a(BluetoothGatt bluetoothGatt) {
        this.f5935e = bluetoothGatt;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public BluetoothGatt mo7501e() {
        return this.f5935e;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7487a(BluetoothGattServer bluetoothGattServer) {
        this.f5934d = bluetoothGattServer;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public BluetoothGattServer mo7502f() {
        return this.f5934d;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public ArrayList<byte[]> mo7503g() {
        return this.f5937g;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public synchronized void mo7495a(ArrayList<byte[]> arrayList) {
        this.f5937g = arrayList;
    }

    public String getUuid() {
        return this.f5941k;
    }

    public String getUserId() {
        return this.f5947q;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7493a(String str) {
        this.f5947q = str;
    }

    public boolean isClient() {
        return this.f5949s;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo7498b(boolean z) {
        this.f5949s = z;
    }

    public String getPublicKey() {
        return this.f5948r;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo7497b(String str) {
        this.f5948r = str;
    }

    /* renamed from: a */
    static int m7883a(String str, String str2) {
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int i = 0;
        while (i < split.length && i < split2.length && split[i].equals(split2[i])) {
            i++;
        }
        if (i >= split.length || i >= split2.length) {
            return Integer.signum(split.length - split2.length);
        }
        return Integer.signum(Integer.valueOf(split[i]).compareTo(Integer.valueOf(split2[i])));
    }
}
