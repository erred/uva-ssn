package com.bridgefy.sdk.client.registration;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Keep;
import com.bridgefy.sdk.BuildConfig;
import com.bridgefy.sdk.client.Bridgefy;
import com.bridgefy.sdk.client.BridgefyUtils;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import com.google.gson.annotations.Expose;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Keep
public class RegistrationRequest {
    private static final String HASH_PWD_DEV = "dev-hash-secret-4385a137-169f-4a5";
    private static final String HASH_PWD_PROD = "e7aaa5c218b2a2ff27edfd54bc872f0f4bba92c06bb581b4e712846975d4af3d";
    @JsonProperty("bundleId")
    @Expose
    private String bundleId;
    @JsonProperty("deviceType")
    @Expose
    private int deviceType = 0;
    @JsonProperty("hash")
    @Expose
    private String hash;
    @JsonProperty("sdkVersion")
    @Expose
    private String sdkVersion;
    @JsonProperty("timestamp")
    @Expose
    private String timestamp;
    @JsonProperty("userId")
    @Expose
    private String userId;

    private static String getHashPassword() {
        return HASH_PWD_PROD;
    }

    RegistrationRequest() {
    }

    RegistrationRequest(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(BuildConfig.APPLICATION_ID, 0);
        this.bundleId = context.getPackageName();
        this.userId = str;
        this.timestamp = BridgefyUtils.getTimeStamp();
        StringBuilder sb = new StringBuilder();
        sb.append(Bridgefy.loadApiKey(context, sharedPreferences.getString("com.bridgefy.sdk.API_KEY", null)));
        sb.append(this.bundleId);
        sb.append(str);
        sb.append(getHashPassword());
        this.hash = generateHash(sb.toString());
        this.sdkVersion = "1.0.6";
    }

    private static String generateHash(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(Integer.toString((b & UnsignedBytes.MAX_VALUE) + Ascii.NUL, 16).substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
