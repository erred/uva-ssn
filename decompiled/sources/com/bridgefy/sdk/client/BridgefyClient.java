package com.bridgefy.sdk.client;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import com.bridgefy.sdk.framework.controller.BridgefyCore;
import java.util.HashMap;

public class BridgefyClient {

    /* renamed from: a */
    private String user_uuid;

    /* renamed from: b */
    private String bundle_id;

    /* renamed from: c */
    private String api_key;

    /* renamed from: d */
    private String public_key;

    /* renamed from: e */
    private String secret_key;

    /* renamed from: f */
    private DeviceProfile device_profile;

    /* renamed from: com.bridgefy.sdk.client.BridgefyClient$a */
    static class C1873a {

        /* renamed from: a */
        private SharedPreferences f5770a;

        /* renamed from: b */
        private Editor f5771b;

        /* renamed from: c */
        private String f5772c;

        /* renamed from: d */
        private String f5773d;

        /* renamed from: e */
        private String f5774e;

        /* renamed from: f */
        private String public_key;

        /* renamed from: g */
        private String private_key;

        /* renamed from: h */
        private DeviceProfile f5777h;

        C1873a(Context context) {
            if (context != null) {
                Context applicationContext = context.getApplicationContext();
                this.f5770a = applicationContext.getSharedPreferences(BridgefyCore.PREFS_NAME, 0);
                this.f5771b = this.f5770a.edit();
                this.f5774e = applicationContext.getPackageName();
                this.f5777h = new DeviceProfile(applicationContext);
                return;
            }
            throw new IllegalArgumentException("Context can not be null.");
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C1873a mo7216a(String str) {
            this.f5772c = str;
            return this;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public C1873a mo7218b(String str) {
            this.f5773d = str;
            return this;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C1873a initialize_new_key_pair() throws Exception {
            HashMap a = CryptoRSA.initialize_new_key_pair();
            this.public_key = (String) a.get("tirmo");
            this.private_key = (String) a.get("satya");
            Log.d("BridgefyClient", "... generated new pair of keys");
            this.f5771b.putString("com.bridgefy.sdk.key.public", this.public_key);
            this.f5771b.putString("com.bridgefy.sdk.key.secret", this.private_key);
            return this;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public C1873a mo7217b() {
            this.public_key = this.f5770a.getString("com.bridgefy.sdk.key.public", null);
            this.private_key = this.f5770a.getString("com.bridgefy.sdk.key.secret", null);
            return this;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public BridgefyClient mo7219c() {
            this.f5771b.putString(BridgefyCore.PREFS_USER_UUID, this.f5773d);
            this.f5771b.apply();
            BridgefyClient bridgefyClient = new BridgefyClient(this.f5773d, this.f5774e, this.f5772c, this.public_key, this.private_key, this.f5777h);
            return bridgefyClient;
        }
    }

    private BridgefyClient(String str, String str2, String str3, String str4, String str5, DeviceProfile deviceProfile) {
        this.user_uuid = str;
        this.bundle_id = str2;
        this.api_key = str3;
        this.public_key = str4;
        this.secret_key = str5;
        this.device_profile = deviceProfile;
    }

    public String getUserUuid() {
        return this.user_uuid;
    }

    public String getBundleId() {
        return this.bundle_id;
    }

    public String getApiKey() {
        return this.api_key;
    }

    public String getPublicKey() {
        return this.public_key;
    }

    public String getSecretKey() {
        return this.secret_key;
    }

    public DeviceProfile getDeviceProfile() {
        return this.device_profile;
    }
}
