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
    private BleEntity f5912b;

    /* renamed from: c */
    private String f5913c;

    /* renamed from: d */
    private ArrayList<byte[]> f5914d;

    /* renamed from: e */
    private int f5915e;

    /* renamed from: f */
    private Session f5916f;

    /* renamed from: g */
    private BluetoothDevice f5917g;

    /* renamed from: h */
    private AsyncTask<Void, Void, Void> f5918h;

    /* renamed from: i */
    private int f5919i = 0;

    C1902al(Session session, BleEntity bleEntity, C1903am amVar) {
        this.f5916f = session;
        this.f5915e = session.mo7394k();
        this.f5912b = bleEntity;
        this.f5913c = String.valueOf(System.currentTimeMillis());
        this.f5911a = amVar;
        if (session.getDevice() != null) {
            this.f5917g = session.getDevice().getBluetoothDevice();
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
            ArrayList<byte[]> a = C1927q.m8001a(this.f5912b, this.f5915e, true, Bridgefy.getInstance().getConfig().isEncryption(), this.f5916f.getUserId());
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
    public BluetoothDevice mo7465b() {
        return this.f5917g;
    }

    /* renamed from: j */
    private String m7845j() {
        return this.f5913c;
    }

    /* renamed from: c */
    public synchronized Session mo7466c() {
        return this.f5916f;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public C1903am mo7468d() {
        return this.f5911a;
    }

    /* renamed from: e */
    public BleEntity mo7469e() {
        return this.f5912b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public void mo7471f() {
        if (this.f5918h != null) {
            this.f5918h.cancel(true);
            this.f5918h = null;
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof C1902al) {
            return this.f5913c.equalsIgnoreCase(((C1902al) obj).m7845j());
        }
        return false;
    }

    public int compareTo(Object obj) {
        if (obj instanceof C1902al) {
            return this.f5913c.compareTo(((C1902al) obj).m7845j());
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
    public UUID mo7473h() {
        return UUID.fromString(this.f5912b.getId());
    }
}
