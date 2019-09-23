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
    private String f5800a;

    /* renamed from: b */
    private String f5801b;

    /* renamed from: c */
    private BluetoothDevice f5802c;

    /* renamed from: d */
    // receiver ID
    private String f5803d;

    /* renamed from: e */
    private Antenna f5804e;

    /* renamed from: f */
    private long f5805f;

    /* renamed from: g */
    private String f5806g;

    public int describeContents() {
        return 0;
    }

    public Device() {
    }

    public Device(BluetoothDevice bluetoothDevice, boolean z) {
        this.f5802c = bluetoothDevice;
        this.f5800a = bluetoothDevice.getName();
        this.f5801b = bluetoothDevice.getAddress();
        this.f5804e = z ? Antenna.BLUETOOTH_LE : Antenna.BLUETOOTH;
    }

    public Device(String str, String str2, String str3) {
        this.f5803d = str;
        this.f5800a = str2;
        this.f5801b = str3;
    }

    public Device(String str) {
        this.f5803d = str;
    }

    public String sendMessage(HashMap<String, Object> hashMap) {
        Builder builder = new Builder();
        builder.setContent(hashMap).setReceiverId(this.f5803d);
        return Bridgefy.sendMessage(builder.build());
    }

    public String sendMessage(HashMap<String, Object> hashMap, byte[] bArr) {
        Builder builder = new Builder();
        builder.setContent(hashMap).setReceiverId(this.f5803d);
        builder.setData(bArr);
        return Bridgefy.sendMessage(builder.build());
    }

    protected Device(Parcel parcel) {
        this.f5800a = parcel.readString();
        this.f5801b = parcel.readString();
        this.f5802c = (BluetoothDevice) parcel.readParcelable(BluetoothDevice.class.getClassLoader());
        this.f5806g = parcel.readString();
        this.f5804e = (Antenna) parcel.readValue(Antenna.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5800a);
        parcel.writeString(this.f5801b);
        parcel.writeParcelable(this.f5802c, i);
        parcel.writeString(this.f5806g);
        parcel.writeValue(this.f5804e);
    }

    public String getDeviceName() {
        return this.f5800a;
    }

    public void setDeviceName(String str) {
        this.f5800a = str;
    }

    public BluetoothDevice getBluetoothDevice() {
        return this.f5802c;
    }

    public void setBluetoothDevice(BluetoothDevice bluetoothDevice) {
        this.f5802c = bluetoothDevice;
        this.f5801b = bluetoothDevice.getAddress();
    }

    public String getDeviceAddress() {
        return this.f5801b;
    }

    public void setDeviceAddress(String str) {
        this.f5801b = str;
    }

    public Antenna getAntennaType() {
        return this.f5804e;
    }

    public void setAntennaType(Antenna antenna) {
        this.f5804e = antenna;
    }

    public String getUserId() {
        return this.f5803d;
    }

    public void setUserId(String str) {
        this.f5803d = str;
    }

    public String getSessionId() {
        return this.f5806g;
    }

    public synchronized void setSessionId(String str) {
        this.f5806g = str;
    }

    public long getCrc() {
        return this.f5805f;
    }

    public void setCrc(long j) {
        this.f5805f = j;
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
