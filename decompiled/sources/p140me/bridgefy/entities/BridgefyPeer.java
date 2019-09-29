package p140me.bridgefy.entities;

import android.bluetooth.BluetoothDevice;
import android.net.wifi.p2p.WifiP2pDevice;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.GsonBuilder;
import p140me.bridgefy.backend.p143v3.bgfyUserApi.model.BgfyUser;
import p140me.bridgefy.ormlite.entities.FriendDTO;
import p140me.bridgefy.service.p144a.C3615a;
import p140me.bridgefy.utils.C3659b;

@Deprecated
/* renamed from: me.bridgefy.entities.BridgefyPeer */
public class BridgefyPeer implements Parcelable {
    public static final Creator<BridgefyPeer> CREATOR = new Creator<BridgefyPeer>() {
        /* renamed from: a */
        public BridgefyPeer createFromParcel(Parcel parcel) {
            return new BridgefyPeer(parcel);
        }

        /* renamed from: a */
        public BridgefyPeer[] newArray(int i) {
            return new BridgefyPeer[i];
        }
    };
    private BluetoothDevice bluetoothDevice;
    private String contactName;
    private String hostAddress;

    /* renamed from: id */
    private String f9220id;
    private String instanceName;
    private String label;
    private String networkPass;
    private String phone;
    private String previousBluetoothAddress;
    private String previousWifiP2pDeviceAddress;
    private String regId;
    private String serviceRegistrationType;
    private String userName;
    private WifiP2pDevice wifiP2pDevice;
    private String wifiP2pDeviceAddress;

    public int describeContents() {
        return 0;
    }

    public BridgefyPeer() {
    }

    public BridgefyPeer(String str) {
        this.f9220id = str;
    }

    public BridgefyPeer(FriendDTO friendDTO) {
        this.f9220id = friendDTO.getId();
        this.userName = friendDTO.getUsername();
        this.contactName = friendDTO.getContactName();
        this.label = friendDTO.getLabel();
        this.phone = friendDTO.getPhoneNumber();
        this.previousWifiP2pDeviceAddress = friendDTO.getWifiP2pAddress();
        this.previousBluetoothAddress = friendDTO.getBluetoothAddress();
    }

    public BridgefyPeer(BgfyUser bgfyUser) {
        this.f9220id = bgfyUser.getUuid();
        this.userName = bgfyUser.getPublicName();
        this.phone = bgfyUser.getPhone();
        this.previousWifiP2pDeviceAddress = bgfyUser.getWifip2pAddress();
        this.previousBluetoothAddress = bgfyUser.getBluetoothAddress();
    }

    public boolean isPeerNearby() {
        return C3615a.m10678a().mo29651a(this.f9220id);
    }

    public String getDisplayName() {
        if (getContactName() != null) {
            return getContactName();
        }
        if (this.phone != null && getUserName() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(getUserName());
            sb.append(" (");
            sb.append(this.phone);
            sb.append(")");
            return sb.toString();
        } else if (getUserName() != null) {
            return C3659b.m10905c(getUserName());
        } else {
            return getId() != null ? getId() : "Unknown";
        }
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BridgefyPeer bridgefyPeer = (BridgefyPeer) obj;
        if (bridgefyPeer.getId() == null || getId() == null || !bridgefyPeer.getId().equals(getId())) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        if (this.wifiP2pDeviceAddress != null) {
            return this.wifiP2pDeviceAddress.hashCode();
        }
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f9220id);
        parcel.writeString(this.networkPass);
        parcel.writeParcelable(this.wifiP2pDevice, 0);
        parcel.writeString(this.instanceName);
        parcel.writeString(this.serviceRegistrationType);
        parcel.writeString(this.wifiP2pDeviceAddress);
        parcel.writeString(this.previousWifiP2pDeviceAddress);
        parcel.writeString(this.hostAddress);
        parcel.writeString(this.userName);
        parcel.writeString(this.regId);
        parcel.writeString(this.phone);
        parcel.writeString(this.label);
        parcel.writeString(this.contactName);
        parcel.writeParcelable(this.bluetoothDevice, 0);
        parcel.writeString(this.previousBluetoothAddress);
    }

    private BridgefyPeer(Parcel parcel) {
        this.f9220id = parcel.readString();
        this.networkPass = parcel.readString();
        this.wifiP2pDevice = (WifiP2pDevice) parcel.readParcelable(WifiP2pDevice.class.getClassLoader());
        this.instanceName = parcel.readString();
        this.serviceRegistrationType = parcel.readString();
        this.wifiP2pDeviceAddress = parcel.readString();
        this.previousWifiP2pDeviceAddress = parcel.readString();
        this.hostAddress = parcel.readString();
        this.userName = parcel.readString();
        this.regId = parcel.readString();
        this.phone = parcel.readString();
        this.label = parcel.readString();
        this.contactName = parcel.readString();
        this.bluetoothDevice = (BluetoothDevice) parcel.readParcelable(BluetoothDevice.class.getClassLoader());
        this.previousBluetoothAddress = parcel.readString();
    }

    public String getPhone() {
        return this.phone;
    }

    public String getContactName() {
        return this.contactName;
    }

    public void setContactName(String str) {
        this.contactName = str;
    }

    public String getPreviousWifiP2pDeviceAddress() {
        return this.previousWifiP2pDeviceAddress;
    }

    public String getPreviousBluetoothAddress() {
        return this.previousBluetoothAddress;
    }

    public String getId() {
        return this.f9220id;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public String toString() {
        return new GsonBuilder().setPrettyPrinting().create().toJson((Object) this);
    }
}
