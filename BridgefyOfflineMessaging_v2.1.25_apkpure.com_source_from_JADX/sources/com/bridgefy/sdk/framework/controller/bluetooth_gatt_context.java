package com.bridgefy.sdk.framework.controller;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.content.Context;
import android.os.Build.VERSION;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: com.bridgefy.sdk.framework.controller.f */
class bluetooth_gatt_context {

    /* renamed from: a */
    private final Context set_context;

    bluetooth_gatt_context(Context context) {
        this.set_context = context;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public BluetoothGatt mo7508a(BluetoothDevice bluetoothDevice, boolean z, BluetoothGattCallback bluetoothGattCallback) {
        if (bluetoothDevice == null) {
            return null;
        }
        if (VERSION.SDK_INT >= 24 || !z) {
            return m7909a(bluetoothGattCallback, bluetoothDevice, false);
        }
        try {
            Object a = invoke_get_bluetooth_gatt(invoke_get_bluetooth_manager());
            if (a == null) {
                return m7909a(bluetoothGattCallback, bluetoothDevice, true);
            }
            BluetoothGatt a2 = m7910a(a, bluetoothDevice);
            if (a2 == null) {
                return m7909a(bluetoothGattCallback, bluetoothDevice, true);
            }
            if (!m7915a(a2, bluetoothGattCallback, true)) {
                a2.close();
            }
            return a2;
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException unused) {
            return m7909a(bluetoothGattCallback, bluetoothDevice, true);
        }
    }

    /* renamed from: a */
    private BluetoothGatt m7909a(BluetoothGattCallback bluetoothGattCallback, BluetoothDevice bluetoothDevice, boolean z) {
        if (VERSION.SDK_INT >= 23) {
            return bluetoothDevice.connectGatt(this.set_context, z, bluetoothGattCallback, 0);
        }
        return bluetoothDevice.connectGatt(this.set_context, z, bluetoothGattCallback);
    }

    /* renamed from: a */
    private boolean m7915a(BluetoothGatt bluetoothGatt, BluetoothGattCallback bluetoothGattCallback, boolean z) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        m7914a(bluetoothGatt, z);
        Method declaredMethod = bluetoothGatt.getClass().getDeclaredMethod("connect", new Class[]{Boolean.class, BluetoothGattCallback.class});
        declaredMethod.setAccessible(true);
        return ((Boolean) declaredMethod.invoke(bluetoothGatt, new Object[]{Boolean.valueOf(true), bluetoothGattCallback})).booleanValue();
    }

    /* renamed from: a */
    private BluetoothGatt m7910a(Object obj, BluetoothDevice bluetoothDevice) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = BluetoothGatt.class.getDeclaredConstructors()[0];
        constructor.setAccessible(true);
        if (constructor.getParameterTypes().length == 4) {
            return (BluetoothGatt) constructor.newInstance(new Object[]{this.set_context, obj, bluetoothDevice, Integer.valueOf(2)});
        }
        return (BluetoothGatt) constructor.newInstance(new Object[]{this.set_context, obj, bluetoothDevice});
    }

    /* renamed from: a */
    private Object invoke_get_bluetooth_gatt(Object obj) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (obj == null) {
            return null;
        }
        return set_method_accessible(obj.getClass(), "getBluetoothGatt").invoke(obj, new Object[0]);
    }

    /* renamed from: a */
    private Object invoke_get_bluetooth_manager() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null) {
            return null;
        }
        return set_method_accessible(defaultAdapter.getClass(), "getBluetoothManager").invoke(defaultAdapter, new Object[0]);
    }

    /* renamed from: a */
    private Method set_method_accessible(Class<?> cls, String str) throws NoSuchMethodException {
        Method declaredMethod = cls.getDeclaredMethod(str, new Class[0]);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    /* renamed from: a */
    private void m7914a(BluetoothGatt bluetoothGatt, boolean z) throws NoSuchFieldException, IllegalAccessException {
        Field declaredField = bluetoothGatt.getClass().getDeclaredField("mAutoConnect");
        declaredField.setAccessible(true);
        declaredField.setBoolean(bluetoothGatt, z);
    }
}
