package p140me.bridgefy.backend.p143v3.bgfyMessageApi.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonString;
import com.google.api.client.util.Key;
import java.util.List;

/* renamed from: me.bridgefy.backend.v3.bgfyMessageApi.model.BgfyUser */
public final class BgfyUser extends GenericJson {
    @Key
    private String authToken;
    @Key
    private Boolean blocked;
    @Key
    private List<String> blockedContacts;
    @Key
    private String bluetoothAddress;
    @Key
    private Integer country;
    @JsonString
    @Key
    private Long createdAt;
    @Key
    private String device;
    @Key
    private String digitsId;
    @Key
    private String phone;
    @Key
    private String publicName;
    @Key
    private String registrationId;
    @Key
    private String uuid;
    @Key
    private String wifip2pAddress;

    public String getAuthToken() {
        return this.authToken;
    }

    public BgfyUser setAuthToken(String str) {
        this.authToken = str;
        return this;
    }

    public Boolean getBlocked() {
        return this.blocked;
    }

    public BgfyUser setBlocked(Boolean bool) {
        this.blocked = bool;
        return this;
    }

    public List<String> getBlockedContacts() {
        return this.blockedContacts;
    }

    public BgfyUser setBlockedContacts(List<String> list) {
        this.blockedContacts = list;
        return this;
    }

    public String getBluetoothAddress() {
        return this.bluetoothAddress;
    }

    public BgfyUser setBluetoothAddress(String str) {
        this.bluetoothAddress = str;
        return this;
    }

    public Integer getCountry() {
        return this.country;
    }

    public BgfyUser setCountry(Integer num) {
        this.country = num;
        return this;
    }

    public Long getCreatedAt() {
        return this.createdAt;
    }

    public BgfyUser setCreatedAt(Long l) {
        this.createdAt = l;
        return this;
    }

    public String getDevice() {
        return this.device;
    }

    public BgfyUser setDevice(String str) {
        this.device = str;
        return this;
    }

    public String getDigitsId() {
        return this.digitsId;
    }

    public BgfyUser setDigitsId(String str) {
        this.digitsId = str;
        return this;
    }

    public String getPhone() {
        return this.phone;
    }

    public BgfyUser setPhone(String str) {
        this.phone = str;
        return this;
    }

    public String getPublicName() {
        return this.publicName;
    }

    public BgfyUser setPublicName(String str) {
        this.publicName = str;
        return this;
    }

    public String getRegistrationId() {
        return this.registrationId;
    }

    public BgfyUser setRegistrationId(String str) {
        this.registrationId = str;
        return this;
    }

    public String getUuid() {
        return this.uuid;
    }

    public BgfyUser setUuid(String str) {
        this.uuid = str;
        return this;
    }

    public String getWifip2pAddress() {
        return this.wifip2pAddress;
    }

    public BgfyUser setWifip2pAddress(String str) {
        this.wifip2pAddress = str;
        return this;
    }

    public BgfyUser set(String str, Object obj) {
        return (BgfyUser) super.set(str, obj);
    }

    public BgfyUser clone() {
        return (BgfyUser) super.clone();
    }
}
