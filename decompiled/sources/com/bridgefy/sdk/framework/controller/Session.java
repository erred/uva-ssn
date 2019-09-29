package com.bridgefy.sdk.framework.controller;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothSocket;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import com.bridgefy.sdk.client.Bridgefy;
import com.bridgefy.sdk.client.Config.Antenna;
import com.bridgefy.sdk.client.Device;
import com.bridgefy.sdk.client.Message;
import com.bridgefy.sdk.client.Message.Builder;
import com.bridgefy.sdk.framework.entities.BleEntity;
import com.bridgefy.sdk.framework.entities.BleEntityContent;
import com.bridgefy.sdk.framework.entities.BleHandshake;
import com.bridgefy.sdk.framework.entities.ForwardTransaction;
import com.bridgefy.sdk.framework.entities.ResponseJson;
import com.bridgefy.sdk.framework.exceptions.ConnectionException;
import com.bridgefy.sdk.framework.exceptions.MessageException;
import com.bridgefy.sdk.framework.utils.Utils;
import com.bridgefy.sdk.logging.LogFactory;
import com.bridgefy.sdk.logging.Logger;
import com.bridgefy.sdk.logging.entities.CommunicationLog.CommunicationErrorEvent;
import com.bridgefy.sdk.logging.entities.CommunicationLog.CommunicationEvent;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Timer;
import p000a.p013b.emitter;
import p000a.p013b.C0345l;
import p000a.p013b.C0346m;
import p000a.p013b.C0347n;
import p000a.p013b.C0349p;
import p000a.p013b.p017b.C0161b;
import p000a.p013b.p038h.C0331a;

public class Session extends bluetooth_emitter_device implements com.bridgefy.sdk.client.Session, Comparable<Session> {
    public static final int MAX_CHUNK_SIZE_ANDROID = 256;

    /* renamed from: d */
    long current_time_ms;

    /* renamed from: e */
    private int f5860e = 0;

    /* renamed from: f */
    private Timer timer;

    /* renamed from: g */
    private int f5862g = 150;

    /* renamed from: h */
    private int f5863h = 0;

    /* renamed from: i */
    private boolean f5864i = false;

    /* renamed from: j */
    private long crc;

    /* renamed from: k */
    private String session_id;

    public /* bridge */ /* synthetic */ Antenna getAntennaType() {
        return super.getAntennaType();
    }

    public /* bridge */ /* synthetic */ BluetoothDevice getBluetoothDevice() {
        return super.getBluetoothDevice();
    }

    public /* bridge */ /* synthetic */ Device getDevice() {
        return super.getDevice();
    }

    public /* bridge */ /* synthetic */ emitter getEmitter() {
        return super.getEmitter();
    }

    public /* bridge */ /* synthetic */ String getPublicKey() {
        return super.getPublicKey();
    }

    public /* bridge */ /* synthetic */ String getUserId() {
        return super.getUserId();
    }

    public /* bridge */ /* synthetic */ String getUuid() {
        return super.getUuid();
    }

    public /* bridge */ /* synthetic */ boolean isClient() {
        return super.isClient();
    }

    public /* bridge */ /* synthetic */ boolean isConnected() {
        return super.isConnected();
    }

    public Session(BluetoothSocket bluetoothSocket) {
        super(bluetoothSocket);
    }

    public Session() {
    }

    public Session(BluetoothDevice bluetoothDevice, boolean z, emitter cVar) {
        super(bluetoothDevice, z, cVar);
        if (z) {
            set_is_connected(true);
        }
    }

    public Session(BluetoothGatt bluetoothGatt) {
        set_bluetooth_gatt(bluetoothGatt);
        set_antenna(Antenna.BLUETOOTH_LE);
        set_bluetooth_device(bluetoothGatt.getDevice());
        set_session_id(bluetoothGatt.getDevice().getAddress());
    }

    public Session(Socket socket, Antenna antenna) {
        super(socket, antenna);
    }

    public Session(Antenna antenna) {
        super(antenna);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public void mo7390h() {
        C0345l.m934a((C0347n<T>) new C0347n() {
            public final void subscribe(C0346m mVar) {
                Session.this.m7728a(mVar);
            }
        }).mo557b(C0331a.m925b()).mo556a((C0349p<? super T>) new C0349p<byte[]>() {
            public void onComplete() {
            }

            public void onSubscribe(C0161b bVar) {
                String str = Session.this.simple_name;
                StringBuilder sb = new StringBuilder();
                sb.append("run: Start runnable of session ");
                sb.append(Session.this.getSessionId());
                sb.append(" device: ");
                sb.append(Session.this.getDevice().getDeviceAddress());
                Log.w(str, sb.toString());
                if (Session.this.getAntennaType() == Antenna.BLUETOOTH) {
                    try {
                        Session.this.request_handshake_io(Session.this, Session.this.get_bluetooth_socket().getOutputStream(), Session.this.get_bluetooth_socket().getInputStream());
                    } catch (IOException unused) {
                        DeviceManager.remove_device(Session.this.getDevice());
                    }
                } else {
                    try {
                        Session.this.request_handshake_io(Session.this, Session.this.get_socket().getOutputStream(), Session.this.get_socket().getInputStream());
                    } catch (IOException unused2) {
                        DeviceManager.remove_device(Session.this.getDevice());
                    }
                }
            }

            /* renamed from: a */
            public void onNext(byte[] bArr) {
                Session session;
                ArrayList arrayList;
                Session.this.mo7503g().add(chunk_utils.m8002a(bArr));
                int c = chunk_utils.m8004c(bArr);
                if (c != 2) {
                    String str = Session.this.simple_name;
                    StringBuilder sb = new StringBuilder();
                    sb.append("call: default read case something went wrong in here ");
                    sb.append(c);
                    Log.e(str, sb.toString());
                    return;
                }
                try {
                    Session.this.mo7378a(chunk_utils.stitch_chunks_to_entity(Session.this.mo7503g(), true, Bridgefy.getInstance().getConfig().isEncryption()));
                    session = Session.this;
                    arrayList = new ArrayList();
                } catch (Exception e) {
                    String str2 = Session.this.simple_name;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("onRead: warning reading entity failed ");
                    sb2.append(e.getMessage());
                    Log.e(str2, sb2.toString(), e);
                    session = Session.this;
                    arrayList = new ArrayList();
                } catch (Throwable th) {
                    Session.this.mo7495a(new ArrayList<>());
                    throw th;
                }
                session.mo7495a(arrayList);
            }

            public void onError(Throwable th) {
                String str = Session.this.simple_name;
                StringBuilder sb = new StringBuilder();
                sb.append("run: currentConnectivity has broken cause: [ ");
                sb.append(th.getMessage());
                sb.append(" ]");
                Log.w(str, sb.toString());
                Session.this.disconnect();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m7728a(C0346m mVar) throws Exception {
        set_time_now();
        while (isConnected()) {
            try {
                byte[] bArr = new byte[get_data_input_stream().readInt()];
                get_data_input_stream().readFully(bArr);
                mVar.mo429a(bArr);
            } catch (IOException e) {
                mVar.mo451a(e);
            }
        }
    }

    /* renamed from: n */
    private void set_time_now() {
        this.current_time_ms = System.currentTimeMillis();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public void disconnect() {
        switch (getAntennaType()) {
            case BLUETOOTH:
                try {
                    if (!(get_data_input_stream() == null || get_data_output_stream() == null)) {
                        get_data_input_stream().close();
                        get_data_output_stream().close();
                    }
                    if (get_bluetooth_socket() != null) {
                        get_bluetooth_socket().close();
                    }
                    set_bluetooth_socket((BluetoothSocket) null);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            case BLUETOOTH_LE:
                cancel_ble_connectivity();
                break;
        }
        if (this.timer != null) {
            this.timer.cancel();
            this.timer = null;
        }
        set_is_connected(false);
        // Logger.log(LogFactory.build((com.bridgefy.sdk.client.Session) this, CommunicationErrorEvent.BFCommunicationErrorTypePeerDisconnected, new ConnectionException("Session was interrupted.")));
        Device device = getDevice();
        if (device != null) {
            device.setSessionId(null);
        }
        SessionManager.remove_session(this);
    }

    /* renamed from: o */
    private void cancel_ble_connectivity() {
        try {
            if (!(get_bluetooth_gatt_server() == null || getBluetoothDevice() == null)) {
                BluetoothGattCharacteristic characteristic = get_bluetooth_gatt_server().getService(C1922m.m7989b()).getCharacteristic(C1922m.m7991c());
                characteristic.setValue(new byte[]{5});
                get_bluetooth_gatt_server().notifyCharacteristicChanged(getBluetoothDevice(), characteristic, false);
                get_bluetooth_gatt_server().cancelConnection(getBluetoothDevice());
            }
            if (get_bluetooth_gatt() != null) {
                get_bluetooth_gatt().disconnect();
                remove_current_session();
            }
        } catch (NullPointerException e) {
            String str = this.simple_name;
            StringBuilder sb = new StringBuilder();
            sb.append("cancelBleConnectivity: ");
            sb.append(e.getMessage());
            Log.e(str, sb.toString());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void request_handshake_io(Session session, OutputStream outputStream, InputStream inputStream) {
        set_data_output_stream(new DataOutputStream(outputStream));
        set_data_input_stream(new DataInputStream(inputStream));
        request_handshake(session);
    }

    /* renamed from: a */
    private void m7732a(Session session, boolean z) {
        Bridgefy.getInstance().getBridgefyCore().get_core_listener_controller().mo7450a(this, z);
    }

    /* renamed from: a */
    private BleHandshake process_handshake(BleHandshake bleHandshake) {
        ResponseJson responseJson;
        Integer num = null;
        if (bleHandshake.getRq() != null) {
            switch (bleHandshake.getRq().intValue()) {
                case 0:
                    responseJson = ResponseJson.ResponseTypeGeneral(Bridgefy.getInstance().getBridgefyClient().getUserUuid(), Utils.getCrcFromKey(Bridgefy.getInstance().getBridgefyClient().getPublicKey()), "1.0.6", "1.0.6");
                    break;
                case 1:
                    responseJson = ResponseJson.ResponseTypeKey(Bridgefy.getInstance().getBridgefyClient().getPublicKey());
                    break;
                case 2:
                    disconnect();
                    return new BleHandshake(null, null);
            }
        }
        responseJson = null;
        if (bleHandshake.getRp() != null) {
            switch (bleHandshake.getRp().getType()) {
                case 0:
                    set_user_id(bleHandshake.getRp().getUuid());
                    if (getCrc() == 0) {
                        setCrc(Utils.getCrcFromKey(getUserId()));
                    }
                    getDevice().setUserId(bleHandshake.getRp().getUuid());
                    getDevice().setCrc(getCrc());
                    DeviceManager.add_device_null_session(getDevice());
                    if (bleHandshake.getRp().getV() != null && !"1.0.6".equalsIgnoreCase("1.0.6") && m7883a("1.0.6", bleHandshake.getRp().getV()) >= 0 && m7883a("1.0.6", bleHandshake.getRp().getV()) <= 0) {
                        String str = this.simple_name;
                        StringBuilder sb = new StringBuilder();
                        sb.append("processHandshake: cancel connection current version 1.0.6 other version: ");
                        sb.append(bleHandshake.getRp().getV());
                        Log.e(str, sb.toString());
                        num = Integer.valueOf(2);
                        break;
                    } else {
                        if (Bridgefy.getInstance().getConfig().isEncryption()) {
                            String a = chunk_utils.get_corresponding_key(getUserId());
                            if (a == null) {
                                num = Integer.valueOf(1);
                            } else if (Utils.getCrcFromKey(a) != bleHandshake.getRp().getCrckey()) {
                                num = Integer.valueOf(1);
                            } else {
                                set_public_key(a);
                            }
                        }
                        // Logger.log(LogFactory.build(getDevice(), bleHandshake, CommunicationEvent.BFCommunicationTypeReceivedHandshakePacket));
                        break;
                    }
                    break;
                case 1:
                    set_public_key(bleHandshake.getRp().getKey());
                    saveKey(getUserId(), bleHandshake.getRp().getKey());
                    // Logger.log(LogFactory.build(getDevice(), bleHandshake, CommunicationEvent.BFCommunicationTypeHandshakeFinished));
                    break;
            }
        }
        return new BleHandshake(num, responseJson);
    }

    /* renamed from: p */
    private static SharedPreferences get_shared_preferences() {
        return Bridgefy.getInstance().getBridgefyCore().get_shared_preferences();
    }

    /* renamed from: q */
    private static Editor get_editor() {
        return Bridgefy.getInstance().getBridgefyCore().get_editor();
    }

    /* renamed from: j */
    static HashMap<String, String> get_key_pairs() {
        String string = get_shared_preferences().getString("com.bridgefy.sdk.key.pairs", null);
        if (string == null) {
            return new HashMap<>();
        }
        return (HashMap) new Gson().fromJson(string, new TypeToken<HashMap<String, Object>>() {
        }.getType());
    }

    public static void saveKey(String str, String str2) {
        HashMap j = get_key_pairs();
        j.put(str, str2);
        get_editor().putString("com.bridgefy.sdk.key.pairs", new Gson().toJson((Object) j)).commit();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7378a(BleEntity bleEntity) {
        if (bleEntity != null) {
            switch (bleEntity.getEt()) {
                case 0:
                    set_is_connected(true);
                    BleHandshake a = process_handshake((BleHandshake) bleEntity.getCt());
                    if (!(a.getRq() == null && a.getRp() == null)) {
                        try {
                            BridgefyCore.send_entity(this, BleEntity.generateHandShake(a));
                        } catch (MessageException | IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (a.getRq() != null) {
                        return;
                    }
                    if ((getPublicKey() != null && Bridgefy.getInstance().getConfig().isEncryption()) || (getPublicKey() == null && !Bridgefy.getInstance().getConfig().isEncryption())) {
                        if (isClient()) {
                            m7732a(this, true);
                        }
                        DeviceManager.add_device(getDevice(), this);
                        if (isClient() && getEmitter() != null) {
                            getEmitter().mo361a();
                            return;
                        }
                        return;
                    }
                    return;
                case 1:
                    set_is_connected(true);
                    BleEntityContent bleEntityContent = (BleEntityContent) bleEntity.getCt();
                    HashMap hashMap = null;
                    if (bleEntityContent.getPld() != null) {
                        hashMap = (HashMap) new Gson().fromJson(new Gson().toJson((Object) bleEntityContent.getPld()), Constants.TYPE);
                    }
                    Builder builder = new Builder();
                    builder.setContent(hashMap);
                    Message build = builder.build();
                    build.setReceiverId(Bridgefy.getInstance().getBridgefyClient().getUserUuid());
                    build.setSenderId(getUserId());
                    if (bleEntity.getData() != null && bleEntity.getData().length > 0) {
                        build.setData(bleEntity.getData());
                    }
                    build.setUuid(bleEntityContent.getId());
                    Bridgefy.getInstance().getBridgefyCore().get_core_listener_controller().mo7448a(build, this);
                    return;
                case 3:
                    m7734c(bleEntity);
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: c */
    private void m7734c(BleEntity bleEntity) {
        ForwardTransaction forwardTransaction = (ForwardTransaction) bleEntity.getCt();
        if (forwardTransaction.getMesh_reach() == null || forwardTransaction.getMesh() == null || forwardTransaction.getMesh().size() != 0) {
            if (forwardTransaction.isDump() != null && forwardTransaction.isDump().booleanValue()) {
                m7732a(this, false);
            }
            Bridgefy.getInstance().getBridgefyCore().get_core_listener_controller().on_mesh_message_incoming_action(this, bleEntity);
            return;
        }
        Bridgefy.getInstance().getBridgefyCore().get_core_listener_controller().mo7452a(forwardTransaction.getMesh_reach());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo7380b(BleEntity bleEntity) throws IOException, MessageException, InterruptedException {
        try {
            Iterator it = chunk_utils.generate_compressed_chunk(bleEntity, 1000000, true, Bridgefy.getInstance().getConfig().isEncryption(), getUserId()).iterator();
            while (it.hasNext()) {
                byte[] bArr = (byte[]) it.next();
                get_data_output_stream().writeInt(bArr.length);
                get_data_output_stream().write(bArr);
                get_data_output_stream().flush();
            }
        } catch (IOException | NullPointerException e) {
            String str = this.simple_name;
            StringBuilder sb = new StringBuilder();
            sb.append("Outputstream or session was null, removing session: ");
            sb.append(getSessionId());
            Log.e(str, sb.toString(), e);
            disconnect();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7377a(int i) {
        this.f5862g = i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: k */
    public int mo7394k() {
        if (!getAntennaType().equals(Antenna.BLUETOOTH_LE)) {
            return 1000000;
        }
        return this.f5862g > 0 ? this.f5862g - 5 : 150;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: l */
    public int mo7395l() {
        return this.f5860e;
    }

    /* renamed from: b */
    private void m7733b(int i) {
        this.f5860e = i;
    }

    /* renamed from: r */
    private void remove_current_session() {
        SessionManager.remove_session(this);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: m */
    public boolean is_gatt_server() {
        return (get_bluetooth_gatt_server() == null || getBluetoothDevice() == null || get_bluetooth_gatt() != null) ? false : true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void set_is_connected(boolean z) {
        super.set_is_connected(z);
        if (z) {
            m7733b(2);
        } else {
            m7733b(0);
        }
    }

    public void setCrc(long j) {
        this.crc = j;
    }

    public long getCrc() {
        return this.crc;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Session) {
            return getSessionId().equals(((Session) obj).getSessionId());
        }
        return false;
    }

    public int compareTo(Session session) {
        return String.valueOf(getCrc()).compareTo(String.valueOf(session.getCrc()));
    }

    public String getSessionId() {
        return this.session_id;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void set_session_id(String str) {
        this.session_id = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Session: ");
        sb.append(this.session_id);
        sb.append("\nConfig.Antenna: ");
        sb.append(getAntennaType());
        sb.append("\nuserId: ");
        sb.append(getUserId());
        sb.append("\ncrc: ");
        sb.append(getCrc());
        sb.append("\ndevice: ");
        sb.append(getDevice());
        sb.append("\nclient: ");
        sb.append(isClient());
        sb.append("\nBLECentral: ");
        sb.append(is_gatt_server());
        sb.append("\nBLEServer: ");
        sb.append(is_gatt_server());
        sb.append("\n");
        return sb.toString();
    }

    /* renamed from: a */
    private void request_handshake(Session session) {
        String str = this.simple_name;
        StringBuilder sb = new StringBuilder();
        sb.append("client: ");
        sb.append(session.isClient());
        sb.append(" requestHandShake: ");
        sb.append(session.getSessionId());
        Log.i(str, sb.toString());
        if (session.isClient()) {
            try {
                BleEntity generateHandShake = BleEntity.generateHandShake();
                // Logger.log(LogFactory.build(session.getDevice(), (BleHandshake) generateHandShake.getCt(), CommunicationEvent.BFCommunicationTypeSentHandshakePacket));
                BridgefyCore.send_entity(session, generateHandShake);
                // Logger.log(LogFactory.build(session.getDevice(), (BleHandshake) generateHandShake.getCt(), CommunicationEvent.BFCommunicationTypeSentHandshakePacket));
            } catch (MessageException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}
