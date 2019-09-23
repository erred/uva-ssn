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
import p000a.p013b.C0165c;
import p000a.p013b.C0345l;
import p000a.p013b.C0346m;
import p000a.p013b.C0347n;
import p000a.p013b.C0349p;
import p000a.p013b.p017b.C0161b;
import p000a.p013b.p038h.C0331a;

public class Session extends C1907d implements com.bridgefy.sdk.client.Session, Comparable<Session> {
    public static final int MAX_CHUNK_SIZE_ANDROID = 256;

    /* renamed from: d */
    long f5859d;

    /* renamed from: e */
    private int f5860e = 0;

    /* renamed from: f */
    private Timer f5861f;

    /* renamed from: g */
    private int f5862g = 150;

    /* renamed from: h */
    private int f5863h = 0;

    /* renamed from: i */
    private boolean f5864i = false;

    /* renamed from: j */
    private long f5865j;

    /* renamed from: k */
    private String f5866k;

    public /* bridge */ /* synthetic */ Antenna getAntennaType() {
        return super.getAntennaType();
    }

    public /* bridge */ /* synthetic */ BluetoothDevice getBluetoothDevice() {
        return super.getBluetoothDevice();
    }

    public /* bridge */ /* synthetic */ Device getDevice() {
        return super.getDevice();
    }

    public /* bridge */ /* synthetic */ C0165c getEmitter() {
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

    public Session(BluetoothDevice bluetoothDevice, boolean z, C0165c cVar) {
        super(bluetoothDevice, z, cVar);
        if (z) {
            mo7379a(true);
        }
    }

    public Session(BluetoothGatt bluetoothGatt) {
        mo7486a(bluetoothGatt);
        mo7489a(Antenna.BLUETOOTH_LE);
        mo7485a(bluetoothGatt.getDevice());
        mo7381c(bluetoothGatt.getDevice().getAddress());
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
                String str = Session.this.f5931a;
                StringBuilder sb = new StringBuilder();
                sb.append("run: Start runnable of session ");
                sb.append(Session.this.getSessionId());
                sb.append(" device: ");
                sb.append(Session.this.getDevice().getDeviceAddress());
                Log.w(str, sb.toString());
                if (Session.this.getAntennaType() == Antenna.BLUETOOTH) {
                    try {
                        Session.this.m7731a(Session.this, Session.this.mo7484a().getOutputStream(), Session.this.mo7484a().getInputStream());
                    } catch (IOException unused) {
                        DeviceManager.m7719b(Session.this.getDevice());
                    }
                } else {
                    try {
                        Session.this.m7731a(Session.this, Session.this.mo7496b().getOutputStream(), Session.this.mo7496b().getInputStream());
                    } catch (IOException unused2) {
                        DeviceManager.m7719b(Session.this.getDevice());
                    }
                }
            }

            /* renamed from: a */
            public void onNext(byte[] bArr) {
                Session session;
                ArrayList arrayList;
                Session.this.mo7503g().add(C1927q.m8002a(bArr));
                int c = C1927q.m8004c(bArr);
                if (c != 2) {
                    String str = Session.this.f5931a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("call: default read case something went wrong in here ");
                    sb.append(c);
                    Log.e(str, sb.toString());
                    return;
                }
                try {
                    Session.this.mo7378a(C1927q.m7999a(Session.this.mo7503g(), true, Bridgefy.getInstance().getConfig().isEncryption()));
                    session = Session.this;
                    arrayList = new ArrayList();
                } catch (Exception e) {
                    String str2 = Session.this.f5931a;
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
                String str = Session.this.f5931a;
                StringBuilder sb = new StringBuilder();
                sb.append("run: currentConnectivity has broken cause: [ ");
                sb.append(th.getMessage());
                sb.append(" ]");
                Log.w(str, sb.toString());
                Session.this.mo7391i();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m7728a(C0346m mVar) throws Exception {
        m7736n();
        while (isConnected()) {
            try {
                byte[] bArr = new byte[mo7500d().readInt()];
                mo7500d().readFully(bArr);
                mVar.mo429a(bArr);
            } catch (IOException e) {
                mVar.mo451a(e);
            }
        }
    }

    /* renamed from: n */
    private void m7736n() {
        this.f5859d = System.currentTimeMillis();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public void mo7391i() {
        switch (getAntennaType()) {
            case BLUETOOTH:
                try {
                    if (!(mo7500d() == null || mo7499c() == null)) {
                        mo7500d().close();
                        mo7499c().close();
                    }
                    if (mo7484a() != null) {
                        mo7484a().close();
                    }
                    mo7488a((BluetoothSocket) null);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            case BLUETOOTH_LE:
                m7737o();
                break;
        }
        if (this.f5861f != null) {
            this.f5861f.cancel();
            this.f5861f = null;
        }
        mo7379a(false);
        // Logger.log(LogFactory.build((com.bridgefy.sdk.client.Session) this, CommunicationErrorEvent.BFCommunicationErrorTypePeerDisconnected, new ConnectionException("Session was interrupted.")));
        Device device = getDevice();
        if (device != null) {
            device.setSessionId(null);
        }
        SessionManager.m7756b(this);
    }

    /* renamed from: o */
    private void m7737o() {
        try {
            if (!(mo7502f() == null || getBluetoothDevice() == null)) {
                BluetoothGattCharacteristic characteristic = mo7502f().getService(C1922m.m7989b()).getCharacteristic(C1922m.m7991c());
                characteristic.setValue(new byte[]{5});
                mo7502f().notifyCharacteristicChanged(getBluetoothDevice(), characteristic, false);
                mo7502f().cancelConnection(getBluetoothDevice());
            }
            if (mo7501e() != null) {
                mo7501e().disconnect();
                m7740r();
            }
        } catch (NullPointerException e) {
            String str = this.f5931a;
            StringBuilder sb = new StringBuilder();
            sb.append("cancelBleConnectivity: ");
            sb.append(e.getMessage());
            Log.e(str, sb.toString());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7731a(Session session, OutputStream outputStream, InputStream inputStream) {
        mo7492a(new DataOutputStream(outputStream));
        mo7491a(new DataInputStream(inputStream));
        m7729a(session);
    }

    /* renamed from: a */
    private void m7732a(Session session, boolean z) {
        Bridgefy.getInstance().getBridgefyCore().mo7366e().mo7450a(this, z);
    }

    /* renamed from: a */
    private BleHandshake m7727a(BleHandshake bleHandshake) {
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
                    mo7391i();
                    return new BleHandshake(null, null);
            }
        }
        responseJson = null;
        if (bleHandshake.getRp() != null) {
            switch (bleHandshake.getRp().getType()) {
                case 0:
                    mo7493a(bleHandshake.getRp().getUuid());
                    if (getCrc() == 0) {
                        setCrc(Utils.getCrcFromKey(getUserId()));
                    }
                    getDevice().setUserId(bleHandshake.getRp().getUuid());
                    getDevice().setCrc(getCrc());
                    DeviceManager.m7715a(getDevice());
                    if (bleHandshake.getRp().getV() != null && !"1.0.6".equalsIgnoreCase("1.0.6") && m7883a("1.0.6", bleHandshake.getRp().getV()) >= 0 && m7883a("1.0.6", bleHandshake.getRp().getV()) <= 0) {
                        String str = this.f5931a;
                        StringBuilder sb = new StringBuilder();
                        sb.append("processHandshake: cancel connection current version 1.0.6 other version: ");
                        sb.append(bleHandshake.getRp().getV());
                        Log.e(str, sb.toString());
                        num = Integer.valueOf(2);
                        break;
                    } else {
                        if (Bridgefy.getInstance().getConfig().isEncryption()) {
                            String a = C1927q.m8000a(getUserId());
                            if (a == null) {
                                num = Integer.valueOf(1);
                            } else if (Utils.getCrcFromKey(a) != bleHandshake.getRp().getCrckey()) {
                                num = Integer.valueOf(1);
                            } else {
                                mo7497b(a);
                            }
                        }
                        // Logger.log(LogFactory.build(getDevice(), bleHandshake, CommunicationEvent.BFCommunicationTypeReceivedHandshakePacket));
                        break;
                    }
                    break;
                case 1:
                    mo7497b(bleHandshake.getRp().getKey());
                    saveKey(getUserId(), bleHandshake.getRp().getKey());
                    // Logger.log(LogFactory.build(getDevice(), bleHandshake, CommunicationEvent.BFCommunicationTypeHandshakeFinished));
                    break;
            }
        }
        return new BleHandshake(num, responseJson);
    }

    /* renamed from: p */
    private static SharedPreferences m7738p() {
        return Bridgefy.getInstance().getBridgefyCore().get_shared_preferences();
    }

    /* renamed from: q */
    private static Editor m7739q() {
        return Bridgefy.getInstance().getBridgefyCore().get_editor();
    }

    /* renamed from: j */
    static HashMap<String, String> get_key_pairs() {
        String string = m7738p().getString("com.bridgefy.sdk.key.pairs", null);
        if (string == null) {
            return new HashMap<>();
        }
        return (HashMap) new Gson().fromJson(string, new TypeToken<HashMap<String, Object>>() {
        }.getType());
    }

    public static void saveKey(String str, String str2) {
        HashMap j = get_key_pairs();
        j.put(str, str2);
        m7739q().putString("com.bridgefy.sdk.key.pairs", new Gson().toJson((Object) j)).commit();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7378a(BleEntity bleEntity) {
        if (bleEntity != null) {
            switch (bleEntity.getEt()) {
                case 0:
                    mo7379a(true);
                    BleHandshake a = m7727a((BleHandshake) bleEntity.getCt());
                    if (!(a.getRq() == null && a.getRp() == null)) {
                        try {
                            BridgefyCore.m7704a(this, BleEntity.generateHandShake(a));
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
                        DeviceManager.m7717a(getDevice(), this);
                        if (isClient() && getEmitter() != null) {
                            getEmitter().mo361a();
                            return;
                        }
                        return;
                    }
                    return;
                case 1:
                    mo7379a(true);
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
                    Bridgefy.getInstance().getBridgefyCore().mo7366e().mo7448a(build, this);
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
            Bridgefy.getInstance().getBridgefyCore().mo7366e().mo7449a(this, bleEntity);
            return;
        }
        Bridgefy.getInstance().getBridgefyCore().mo7366e().mo7452a(forwardTransaction.getMesh_reach());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo7380b(BleEntity bleEntity) throws IOException, MessageException, InterruptedException {
        try {
            Iterator it = C1927q.m8001a(bleEntity, 1000000, true, Bridgefy.getInstance().getConfig().isEncryption(), getUserId()).iterator();
            while (it.hasNext()) {
                byte[] bArr = (byte[]) it.next();
                mo7499c().writeInt(bArr.length);
                mo7499c().write(bArr);
                mo7499c().flush();
            }
        } catch (IOException | NullPointerException e) {
            String str = this.f5931a;
            StringBuilder sb = new StringBuilder();
            sb.append("Outputstream or session was null, removing session: ");
            sb.append(getSessionId());
            Log.e(str, sb.toString(), e);
            mo7391i();
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
    private void m7740r() {
        SessionManager.m7756b(this);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: m */
    public boolean mo7396m() {
        return (mo7502f() == null || getBluetoothDevice() == null || mo7501e() != null) ? false : true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7379a(boolean z) {
        super.mo7379a(z);
        if (z) {
            m7733b(2);
        } else {
            m7733b(0);
        }
    }

    public void setCrc(long j) {
        this.f5865j = j;
    }

    public long getCrc() {
        return this.f5865j;
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
        return this.f5866k;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo7381c(String str) {
        this.f5866k = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Session: ");
        sb.append(this.f5866k);
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
        sb.append(mo7396m());
        sb.append("\nBLEServer: ");
        sb.append(mo7396m());
        sb.append("\n");
        return sb.toString();
    }

    /* renamed from: a */
    private void m7729a(Session session) {
        String str = this.f5931a;
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
                BridgefyCore.m7704a(session, generateHandShake);
                // Logger.log(LogFactory.build(session.getDevice(), (BleHandshake) generateHandShake.getCt(), CommunicationEvent.BFCommunicationTypeSentHandshakePacket));
            } catch (MessageException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}
