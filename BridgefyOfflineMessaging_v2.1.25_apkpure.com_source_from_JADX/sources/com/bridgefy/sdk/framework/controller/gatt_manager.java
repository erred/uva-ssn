package com.bridgefy.sdk.framework.controller;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.os.AsyncTask;
import android.util.Log;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* renamed from: com.bridgefy.sdk.framework.controller.aa */
class gatt_manager {

    /* renamed from: a */
    private ConcurrentLinkedQueue<gatt_operation> f5879a = new ConcurrentLinkedQueue<>();

    /* renamed from: b */
    private ConcurrentHashMap<String, BluetoothGatt> f5880b = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public gatt_operation f5881c = null;

    /* renamed from: d */
    private AsyncTask<Void, Void, Void> f5882d;

    gatt_manager() {
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public synchronized void m7778e() {
        String str = "GATT_MANAGER";
        StringBuilder sb = new StringBuilder();
        sb.append("Cancelling current operation. Queue size before: ");
        sb.append(this.f5879a.size());
        Log.e(str, sb.toString());
        if (!(this.f5881c == null || this.f5881c.mo7428d() == null)) {
            Iterator it = this.f5881c.mo7428d().mo7433a().iterator();
            while (it.hasNext()) {
                this.f5879a.remove((gatt_operation) it.next());
            }
            this.f5881c.mo7428d().mo7435b().mo7468d().mo7475b(this.f5881c.mo7428d().mo7435b());
        }
        this.f5881c = null;
        mo7411a();
    }

    /* renamed from: a */
    public synchronized void mo7414a(gatt_operation abVar) {
        this.f5879a.add(abVar);
        mo7411a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public synchronized void mo7411a() {
        if (this.f5881c == null && this.f5879a.size() > 0) {
            gatt_operation abVar = (gatt_operation) this.f5879a.poll();
            mo7417b(abVar);
            this.f5882d = new AsyncTask<Void, Void, Void>() {
                /* access modifiers changed from: protected */
                /* renamed from: a */
                public synchronized Void doInBackground(Void... voidArr) {
                    try {
                        wait((long) gatt_manager.this.f5881c.mo7427c());
                        if (isCancelled()) {
                            Log.e("GATT_MANAGER", "The timeout has already been cancelled.");
                        } else if (gatt_manager.this.f5881c == null) {
                            Log.e("GATT_MANAGER", "The timeout was cancelled and the query was successful, so we do nothing.");
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Gatt manager Timeout ran to completion, time to cancel the operation. Abort ships! ");
                            sb.append(gatt_manager.this.f5881c.get_operation_id());
                            sb.append(" device ");
                            sb.append(gatt_manager.this.f5881c.mo7426b());
                            Log.e("GATT_MANAGER", sb.toString());
                            gatt_manager.this.m7778e();
                            gatt_manager.this.mo7417b((gatt_operation) null);
                            return null;
                        }
                    } catch (InterruptedException unused) {
                    }
                    return null;
                }

                /* access modifiers changed from: protected */
                public synchronized void onCancelled() {
                    super.onCancelled();
                    notify();
                }
            }.execute(new Void[0]);
            BluetoothDevice b = abVar.mo7426b();
            if (this.f5880b.containsKey(b.getAddress())) {
                mo7413a((BluetoothGatt) this.f5880b.get(b.getAddress()), abVar);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7413a(BluetoothGatt bluetoothGatt, gatt_operation abVar) {
        if (abVar == this.f5881c) {
            abVar.read_bluetooth_gatt_descriptor(bluetoothGatt);
            if (!abVar.mo7425a()) {
                mo7417b((gatt_operation) null);
                mo7411a();
            }
        }
    }

    /* renamed from: a */
    public void mo7415a(C1892ac acVar) {
        Iterator it = acVar.mo7433a().iterator();
        while (it.hasNext()) {
            this.f5879a.add((gatt_operation) it.next());
        }
        mo7411a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public ConcurrentHashMap<String, BluetoothGatt> mo7416b() {
        return this.f5880b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public synchronized void mo7417b(gatt_operation abVar) {
        this.f5881c = abVar;
        if (abVar == null) {
            if (this.f5882d != null) {
                this.f5882d.cancel(true);
                this.f5882d = null;
            }
            mo7411a();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public gatt_operation mo7418c() {
        return this.f5881c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo7419d() {
        this.f5879a.clear();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7412a(BluetoothDevice bluetoothDevice) {
        Iterator it = this.f5879a.iterator();
        while (it.hasNext()) {
            gatt_operation abVar = (gatt_operation) it.next();
            if (abVar.mo7426b().equals(bluetoothDevice)) {
                if (mo7418c() != null && mo7418c().equals(abVar)) {
                    mo7417b((gatt_operation) null);
                }
                this.f5879a.remove(abVar);
            }
        }
    }
}
