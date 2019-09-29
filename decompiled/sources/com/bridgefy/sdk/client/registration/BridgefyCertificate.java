package com.bridgefy.sdk.client.registration;

import android.content.SharedPreferences;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class BridgefyCertificate {

    /* renamed from: a */
    SimpleDateFormat f5828a = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    /* renamed from: b */
    String f5829b;

    /* renamed from: c */
    Date f5830c;

    public abstract String[] getBundleIds();

    public abstract boolean isValid();

    public abstract void save(SharedPreferences sharedPreferences);

    BridgefyCertificate() {
    }

    public String getTimestamp() {
        return this.f5829b;
    }

    public Date getExpirationDate() {
        return this.f5830c;
    }
}
