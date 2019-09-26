package com.bridgefy.sdk.framework.controller;

import android.bluetooth.BluetoothDevice;
import android.os.AsyncTask;
import com.bridgefy.sdk.client.Bridgefy;
import com.bridgefy.sdk.framework.entities.BleEntity;
import com.bridgefy.sdk.framework.exceptions.MessageException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

/* renamed from: com.bridgefy.sdk.framework.controller.al */
class C1902al implements Comparable {

    /* renamed from: a */
    private C1903am f5911a;

    /* renamed from: b */
    private BleEntity ble_entity;

    /* renamed from: c */
    private String current_time_ms;

    /* renamed from: d */
    private ArrayList<byte[]> f5914d;

    /* renamed from: e */
    private int f5915e;

    /* renamed from: f */
    private Session session;

    /* renamed from: g */
    private BluetoothDevice bluetooth_device;

    /* renamed from: h */
    private AsyncTask<Void, Void, Void> async_tasks;

    /* renamed from: i */
    private int f5919i = 0;

    C1902al(Session session, BleEntity bleEntity, C1903am amVar) {
        this.session = session;
        this.f5915e = session.mo7394k();
        this.ble_entity = bleEntity;
        this.current_time_ms = String.valueOf(System.currentTimeMillis());
        this.f5911a = amVar;
        if (session.getDevice() != null) {
            this.bluetooth_device = session.getDevice().getBluetoothDevice();
            return;
        }
        throw new IllegalArgumentException("BluetoothDevice is null.");
    }

    /* renamed from: a */
    public ArrayList<byte[]> mo7464a() {
        if (this.f5914d == null) {
            this.f5914d = m7844i();
        }
        return this.f5914d;
    }

    /* renamed from: i */
    private ArrayList<byte[]> m7844i() {
        ArrayList<byte[]> arrayList = null;
        try {
            ArrayList<byte[]> a = C1927q.generate_compressed_chunk(this.ble_entity, this.f5915e, true, Bridgefy.getInstance().getConfig().isEncryption(), this.session.getUserId());
            try {
                this.f5919i = a.size();
                return a;
            } catch (MessageException | IOException e) {
                ArrayList<byte[]> arrayList2 = a;
                e = e;
                arrayList = arrayList2;
                e.printStackTrace();
                return arrayList;
            }
        } catch (MessageException | IOException e2) {
            e = e2;
            e.printStackTrace();
            return arrayList;
        }
    }

    /* renamed from: b */
    public BluetoothDevice get_bluetooth_device() {
        return this.bluetooth_device;
    }

    /* renamed from: j */
    private String m7845j() {
        return this.current_time_ms;
    }

    /* renamed from: c */
    public synchronized Session get_session() {
        return this.session;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public C1903am mo7468d() {
        return this.f5911a;
    }

    /* renamed from: e */
    public BleEntity get_ble_entity() {
        return this.ble_entity;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public void clear_async_tasks() {
        if (this.async_tasks != null) {
            this.async_tasks.cancel(true);
            this.async_tasks = null;
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof C1902al) {
            return this.current_time_ms.equalsIgnoreCase(((C1902al) obj).m7845j());
        }
        return false;
    }

    public int compareTo(Object obj) {
        if (obj instanceof C1902al) {
            return this.current_time_ms.compareTo(((C1902al) obj).m7845j());
        }
        StringBuilder sb = new StringBuilder();
        sb.append(obj.getClass().getName());
        sb.append(" is not a ");
        sb.append(getClass().getName());
        throw new IllegalArgumentException(sb.toString());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public int mo7472g() {
        return this.f5919i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public UUID get_ble_entity_uuid() {
        return UUID.fromString(this.ble_entity.getId());
    }
}
