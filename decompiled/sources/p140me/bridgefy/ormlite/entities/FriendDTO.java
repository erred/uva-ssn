package p140me.bridgefy.ormlite.entities;

import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import p140me.bridgefy.entities.BridgefyPeer;
import p140me.bridgefy.utils.C3659b;

@DatabaseTable(tableName = "bgf_friend")
/* renamed from: me.bridgefy.ormlite.entities.FriendDTO */
public class FriendDTO extends ORMLiteActions<FriendDTO, String> {
    public static final String BLOCKED = "blocked";
    public static final int BLOCKED_CONTACT = 3;
    public static final int BLOCKED_CONTACT_PENDING = 2;
    public static final String BLUETOOTH_ADDRESS = "bluetooth_address";
    public static final String COLOR = "color";
    public static final String CONTACT_NAME = "contact_name";

    /* renamed from: ID */
    public static final String f9514ID = "id";
    public static final String LABEL = "label";
    public static final String PHONE_NUMBER = "phone_number";
    public static final String PUBLIC_KEY = "public_key";
    public static final String TABLE_NAME = "bgf_friend";
    public static final int UNBLOCKED_CONTACT = 0;
    public static final int UNBLOCKED_CONTACT_PENDING = 1;
    public static final String USER_NAME = "user_name";
    public static final String WIFI_P2P_ADDRESS = "wifi_p2p_address";
    @DatabaseField(canBeNull = false, columnName = "blocked", defaultValue = "0")
    private int blocked;
    @Deprecated
    @DatabaseField(columnName = "bluetooth_address")
    private String bluetoothAddress;
    @DatabaseField(columnName = "color")
    private int color;
    @DatabaseField(canBeNull = true, columnName = "contact_name")
    private String contactName;
    @DatabaseField(canBeNull = false, columnName = "id", generatedId = false, mo26675id = true, unique = true)

    /* renamed from: id */
    private String f9515id;
    @DatabaseField(canBeNull = true, columnName = "label", defaultValue = "")
    private String label;
    @DatabaseField(columnName = "phone_number")
    private String phoneNumber;
    @DatabaseField(canBeNull = true, columnName = "public_key")
    private String publicKey;
    @DatabaseField(canBeNull = true, columnName = "user_name")
    private String username;
    @Deprecated
    @DatabaseField(columnName = "wifi_p2p_address")
    private String wifiP2pAddress;

    public FriendDTO() {
    }

    public FriendDTO(BridgefyPeer bridgefyPeer) {
        this.f9515id = bridgefyPeer.getId().toLowerCase();
        this.username = bridgefyPeer.getUserName();
        this.phoneNumber = bridgefyPeer.getPhone();
        this.label = bridgefyPeer.getLabel();
        this.contactName = bridgefyPeer.getContactName();
        this.wifiP2pAddress = bridgefyPeer.getPreviousWifiP2pDeviceAddress();
        this.bluetoothAddress = bridgefyPeer.getPreviousBluetoothAddress();
    }

    public FriendDTO(String str, String str2, String str3) {
        this.f9515id = str;
        this.username = str2;
        this.phoneNumber = str3;
    }

    public boolean isVerified() {
        return getPhoneNumber() != null && getPhoneNumber().length() > 0;
    }

    public String buildDisplayName() {
        if (getContactName() != null) {
            return getContactName();
        }
        if (this.phoneNumber != null && getUsername() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(getUsername());
            sb.append(" (");
            sb.append(this.phoneNumber);
            sb.append(")");
            return sb.toString();
        } else if (getUsername() != null) {
            return C3659b.m10905c(getUsername());
        } else {
            return getId() != null ? getId() : "Unknown";
        }
    }

    public String getContactOrUsername() {
        if (getContactName() != null) {
            return getContactName();
        }
        return getUsername();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FriendDTO{id='");
        sb.append(this.f9515id);
        sb.append('\'');
        sb.append(", username='");
        sb.append(this.username);
        sb.append('\'');
        sb.append(", phoneNumber='");
        sb.append(this.phoneNumber);
        sb.append('\'');
        sb.append(", contactName='");
        sb.append(this.contactName);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }

    public FriendDTO set(RuntimeExceptionDao<FriendDTO, String> runtimeExceptionDao) {
        if (this.f9515id == null || !runtimeExceptionDao.idExists(this.f9515id)) {
            this.color = C3659b.m10900b();
            return (FriendDTO) runtimeExceptionDao.createIfNotExists(this);
        } else if (update(runtimeExceptionDao)) {
            return this;
        } else {
            return null;
        }
    }

    public boolean update(RuntimeExceptionDao<FriendDTO, String> runtimeExceptionDao) {
        if (!C3659b.m10898a(this.color)) {
            this.color = C3659b.m10900b();
        }
        return runtimeExceptionDao.update(this) != -1;
    }

    public boolean delete(RuntimeExceptionDao<FriendDTO, String> runtimeExceptionDao) {
        return runtimeExceptionDao.delete(this) != -1;
    }

    public String getId() {
        return this.f9515id;
    }

    public void setId(String str) {
        this.f9515id = str;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public String getPublicKey() {
        return this.publicKey;
    }

    public void setPublicKey(String str) {
        this.publicKey = str;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    public String getContactName() {
        return this.contactName;
    }

    public void setContactName(String str) {
        this.contactName = str;
    }

    public String getWifiP2pAddress() {
        return this.wifiP2pAddress;
    }

    public void setWifiP2pAddress(String str) {
        this.wifiP2pAddress = str;
    }

    public int getColor() {
        return this.color;
    }

    public void setColor(int i) {
        this.color = i;
    }

    public String getBluetoothAddress() {
        return this.bluetoothAddress;
    }

    public void setBluetoothAddress(String str) {
        this.bluetoothAddress = str;
    }

    public int getBlockedStatus() {
        return this.blocked;
    }

    public FriendDTO setBlockedStatus(int i) {
        this.blocked = i;
        return this;
    }

    public boolean isBlocked() {
        return this.blocked >= 2;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String str) {
        this.label = str;
    }
}
