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
import p000a.p013b.emitter;

/* renamed from: com.bridgefy.sdk.framework.controller.d */
abstract class bluetooth_emitter_device {

    /* renamed from: a */
    protected final String simple_name = getClass().getSimpleName();

    /* renamed from: b */
    Pattern pattern = Pattern.compile("\\}");

    /* renamed from: c */
    emitter emitter;

    /* renamed from: d */
    private BluetoothGattServer bluetooth_gatt_server;

    /* renamed from: e */
    private BluetoothGatt bluetooth_gatt;

    /* renamed from: f */
    private BluetoothDevice bluetooth_device;

    /* renamed from: g */
    private ArrayList<byte[]> f5937g = new ArrayList<>();

    /* renamed from: h */
    private ArrayList<byte[]> f5938h = new ArrayList<>();

    /* renamed from: i */
    private BluetoothSocket bluetooth_socket;

    /* renamed from: j */
    private Socket socket;

    /* renamed from: k */
    private String uuid;

    /* renamed from: l */
    private Device device;

    /* renamed from: m */
    private Antenna antenna;

    /* renamed from: n */
    private boolean is_connected = false;

    /* renamed from: o */
    private DataOutputStream data_output_stream;

    /* renamed from: p */
    private DataInputStream data_input_stream;

    /* renamed from: q */
    private String user_id;

    /* renamed from: r */
    private String public_key;

    /* renamed from: s */
    private boolean is_client;

    public emitter getEmitter() {
        return this.emitter;
    }

    bluetooth_emitter_device(BluetoothSocket bluetoothSocket) {
        set_bluetooth_socket(bluetoothSocket);
        set_antenna(Antenna.BLUETOOTH);
        this.uuid = Utils.generateSessionId();
    }

    bluetooth_emitter_device(Socket socket, Antenna antenna) {
        set_socket(socket);
        set_antenna(antenna);
        this.uuid = Utils.generateSessionId();
    }

    bluetooth_emitter_device(Antenna antenna) {
        set_antenna(antenna);
    }

    bluetooth_emitter_device(BluetoothDevice bluetoothDevice, boolean z, emitter cVar) {
        this.emitter = cVar;
        set_bluetooth_device(bluetoothDevice);
        if (z) {
            set_antenna(Antenna.BLUETOOTH_LE);
        } else {
            set_antenna(Antenna.BLUETOOTH);
        }
    }

    bluetooth_emitter_device() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public BluetoothSocket get_bluetooth_socket() {
        return this.bluetooth_socket;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void set_bluetooth_socket(BluetoothSocket bluetoothSocket) {
        this.bluetooth_socket = bluetoothSocket;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public Socket get_socket() {
        return this.socket;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void set_socket(Socket socket) {
        this.socket = socket;
    }

    public Device getDevice() {
        return this.device;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void set_device(Device device) {
        this.device = device;
    }

    public Antenna getAntennaType() {
        return this.antenna;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void set_antenna(Antenna antenna) {
        this.antenna = antenna;
    }

    public boolean isConnected() {
        return this.is_connected;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void set_is_connected(boolean z) {
        this.is_connected = z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public DataOutputStream get_data_output_stream() {
        return this.data_output_stream;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void set_data_output_stream(DataOutputStream dataOutputStream) {
        this.data_output_stream = dataOutputStream;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public DataInputStream get_data_input_stream() {
        return this.data_input_stream;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void set_data_input_stream(DataInputStream dataInputStream) {
        this.data_input_stream = dataInputStream;
    }

    public BluetoothDevice getBluetoothDevice() {
        return this.bluetooth_device;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void set_bluetooth_device(BluetoothDevice bluetoothDevice) {
        this.bluetooth_device = bluetoothDevice;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void set_bluetooth_gatt(BluetoothGatt bluetoothGatt) {
        this.bluetooth_gatt = bluetoothGatt;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public BluetoothGatt get_bluetooth_gatt() {
        return this.bluetooth_gatt;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void set_bluetooth_gatt_server(BluetoothGattServer bluetoothGattServer) {
        this.bluetooth_gatt_server = bluetoothGattServer;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public BluetoothGattServer get_bluetooth_gatt_server() {
        return this.bluetooth_gatt_server;
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
        return this.uuid;
    }

    public String getUserId() {
        return this.user_id;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void set_user_id(String str) {
        this.user_id = str;
    }

    public boolean isClient() {
        return this.is_client;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void set_is_client(boolean z) {
        this.is_client = z;
    }

    public String getPublicKey() {
        return this.public_key;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void set_public_key(String str) {
        this.public_key = str;
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
