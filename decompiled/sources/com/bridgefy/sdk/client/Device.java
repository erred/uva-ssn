package com.bridgefy.sdk.client;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.bridgefy.sdk.client.Config.Antenna;
import com.bridgefy.sdk.client.Message.Builder;
import com.google.gson.Gson;
import java.util.HashMap;

public class Device implements Parcelable {
    public static final Creator<Device> CREATOR = new Creator<Device>() {
        /* renamed from: a */
        public Device createFromParcel(Parcel parcel) {
            return new Device(parcel);
        }

        /* renamed from: a */
        public Device[] newArray(int i) {
            return new Device[i];
        }
    };

    /* renamed from: a */
    private String bluetooth_name;

    /* renamed from: b */
    private String bluetooth_address;

    /* renamed from: c */
    private BluetoothDevice bluetooth_device;

    /* renamed from: d */
    // receiver ID
    private String device_id;

    /* renamed from: e */
    private Antenna antenna;

    /* renamed from: f */
    private long crc_code;

    /* renamed from: g */
    private String session_id;

    public int describeContents() {
        return 0;
    }

    public Device() {
    }

    public Device(BluetoothDevice bluetoothDevice, boolean z) {
        this.bluetooth_device = bluetoothDevice;
        this.bluetooth_name = bluetoothDevice.getName();
        this.bluetooth_address = bluetoothDevice.getAddress();
        this.antenna = z ? Antenna.BLUETOOTH_LE : Antenna.BLUETOOTH;
    }

    public Device(String str, String str2, String str3) {
        this.device_id = str;
        this.bluetooth_name = str2;
        this.bluetooth_address = str3;
    }

    public Device(String str) {
        this.device_id = str;
    }

    public String sendMessage(HashMap<String, Object> hashMap) {
        Builder builder = new Builder();
        builder.setContent(hashMap).setReceiverId(this.device_id);
        return Bridgefy.sendMessage(builder.build());
    }

    public String sendMessage(HashMap<String, Object> hashMap, byte[] bArr) {
        Builder builder = new Builder();
        builder.setContent(hashMap).setReceiverId(this.device_id);
        builder.setData(bArr);
        return Bridgefy.sendMessage(builder.build());
    }

    protected Device(Parcel parcel) {
        this.bluetooth_name = parcel.readString();
        this.bluetooth_address = parcel.readString();
        this.bluetooth_device = (BluetoothDevice) parcel.readParcelable(BluetoothDevice.class.getClassLoader());
        this.session_id = parcel.readString();
        this.antenna = (Antenna) parcel.readValue(Antenna.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.bluetooth_name);
        parcel.writeString(this.bluetooth_address);
        parcel.writeParcelable(this.bluetooth_device, i);
        parcel.writeString(this.session_id);
        parcel.writeValue(this.antenna);
    }

    public String getDeviceName() {
        return this.bluetooth_name;
    }

    public void setDeviceName(String str) {
        this.bluetooth_name = str;
    }

    public BluetoothDevice getBluetoothDevice() {
        return this.bluetooth_device;
    }

    public void setBluetoothDevice(BluetoothDevice bluetoothDevice) {
        this.bluetooth_device = bluetoothDevice;
        this.bluetooth_address = bluetoothDevice.getAddress();
    }

    public String getDeviceAddress() {
        return this.bluetooth_address;
    }

    public void setDeviceAddress(String str) {
        this.bluetooth_address = str;
    }

    public Antenna getAntennaType() {
        return this.antenna;
    }

    public void setAntennaType(Antenna antenna) {
        this.antenna = antenna;
    }

    public String getUserId() {
        return this.device_id;
    }

    public void setUserId(String str) {
        this.device_id = str;
    }

    public String getSessionId() {
        return this.session_id;
    }

    public synchronized void setSessionId(String str) {
        this.session_id = str;
    }

    public long getCrc() {
        return this.crc_code;
    }

    public void setCrc(long j) {
        this.crc_code = j;
    }

    public String toString() {
        return new Gson().toJson((Object) this);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Device) {
            Device device = (Device) obj;
            return device.getDeviceAddress() != null && device.getDeviceAddress().trim().equalsIgnoreCase(getDeviceAddress().trim());
        }
        StringBuilder sb = new StringBuilder();
        sb.append(obj.getClass().getName());
        sb.append(" is not a Device.");
        throw new IllegalArgumentException(sb.toString());
    }
}
