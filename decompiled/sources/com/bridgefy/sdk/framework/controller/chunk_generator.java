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
class chunk_generator implements Comparable {

    /* renamed from: a */
    private transaction_manager transaction_manager;

    /* renamed from: b */
    private BleEntity ble_entity;

    /* renamed from: c */
    private String current_time_ms;

    /* renamed from: d */
    private ArrayList<byte[]> generated_chunk;

    /* renamed from: e */
    private int f5915e;

    /* renamed from: f */
    private Session session;

    /* renamed from: g */
    private BluetoothDevice bluetooth_device;

    /* renamed from: h */
    private AsyncTask<Void, Void, Void> async_tasks;

    /* renamed from: i */
    private int compressed = 0;

    chunk_generator(Session session, BleEntity bleEntity, transaction_manager amVar) {
        this.session = session;
        this.f5915e = session.mo7394k();
        this.ble_entity = bleEntity;
        this.current_time_ms = String.valueOf(System.currentTimeMillis());
        this.transaction_manager = amVar;
        if (session.getDevice() != null) {
            this.bluetooth_device = session.getDevice().getBluetoothDevice();
            return;
        }
        throw new IllegalArgumentException("BluetoothDevice is null.");
    }

    /* renamed from: a */
    public ArrayList<byte[]> get_generated_chunk() {
        if (this.generated_chunk == null) {
            this.generated_chunk = generate_chunk();
        }
        return this.generated_chunk;
    }

    /* renamed from: i */
    private ArrayList<byte[]> generate_chunk() {
        ArrayList<byte[]> arrayList = null;
        try {
            ArrayList<byte[]> a = chunk_utils.generate_compressed_chunk(this.ble_entity, this.f5915e, true, Bridgefy.getInstance().getConfig().isEncryption(), this.session.getUserId());
            try {
                this.compressed = a.size();
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
    private String get_current_time_ms() {
        return this.current_time_ms;
    }

    /* renamed from: c */
    public synchronized Session get_session() {
        return this.session;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public transaction_manager get_transaction_manager() {
        return this.transaction_manager;
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
        if (obj instanceof chunk_generator) {
            return this.current_time_ms.equalsIgnoreCase(((chunk_generator) obj).get_current_time_ms());
        }
        return false;
    }

    public int compareTo(Object obj) {
        if (obj instanceof chunk_generator) {
            return this.current_time_ms.compareTo(((chunk_generator) obj).get_current_time_ms());
        }
        StringBuilder sb = new StringBuilder();
        sb.append(obj.getClass().getName());
        sb.append(" is not a ");
        sb.append(getClass().getName());
        throw new IllegalArgumentException(sb.toString());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public int get_compressed_size() {
        return this.compressed;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public UUID get_ble_entity_uuid() {
        return UUID.fromString(this.ble_entity.getId());
    }
}
