package com.bridgefy.sdk.client;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import com.bridgefy.sdk.framework.controller.BridgefyCore;
import java.util.HashMap;

public class BridgefyClient {

    /* renamed from: a */
    private String f5764a;

    /* renamed from: b */
    private String f5765b;

    /* renamed from: c */
    private String f5766c;

    /* renamed from: d */
    private String f5767d;

    /* renamed from: e */
    private String f5768e;

    /* renamed from: f */
    private DeviceProfile f5769f;

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
        private String f5775f;

        /* renamed from: g */
        private String f5776g;

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
        public C1873a mo7215a() throws Exception {
            HashMap a = CryptoRSA.m7670a();
            this.f5775f = (String) a.get("tirmo");
            this.f5776g = (String) a.get("satya");
            Log.d("BridgefyClient", "... generated new pair of keys");
            this.f5771b.putString("com.bridgefy.sdk.key.public", this.f5775f);
            this.f5771b.putString("com.bridgefy.sdk.key.secret", this.f5776g);
            return this;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public C1873a mo7217b() {
            this.f5775f = this.f5770a.getString("com.bridgefy.sdk.key.public", null);
            this.f5776g = this.f5770a.getString("com.bridgefy.sdk.key.secret", null);
            return this;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public BridgefyClient mo7219c() {
            this.f5771b.putString(BridgefyCore.PREFS_USER_UUID, this.f5773d);
            this.f5771b.apply();
            BridgefyClient bridgefyClient = new BridgefyClient(this.f5773d, this.f5774e, this.f5772c, this.f5775f, this.f5776g, this.f5777h);
            return bridgefyClient;
        }
    }

    private BridgefyClient(String str, String str2, String str3, String str4, String str5, DeviceProfile deviceProfile) {
        this.f5764a = str;
        this.f5765b = str2;
        this.f5766c = str3;
        this.f5767d = str4;
        this.f5768e = str5;
        this.f5769f = deviceProfile;
    }

    public String getUserUuid() {
        return this.f5764a;
    }

    public String getBundleId() {
        return this.f5765b;
    }

    public String getApiKey() {
        return this.f5766c;
    }

    public String getPublicKey() {
        return this.f5767d;
    }

    public String getSecretKey() {
        return this.f5768e;
    }

    public DeviceProfile getDeviceProfile() {
        return this.f5769f;
    }
}
