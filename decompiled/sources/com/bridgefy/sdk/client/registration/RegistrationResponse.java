package com.bridgefy.sdk.client.registration;

import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Keep
class RegistrationResponse {
    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    @SerializedName("token")
    @Expose
    private String token;

    RegistrationResponse() {
    }

    RegistrationResponse(String str, String str2) {
        this.token = str;
        this.timestamp = str2;
    }

    /* access modifiers changed from: 0000 */
    public String getTimestamp() {
        return this.timestamp;
    }

    /* access modifiers changed from: 0000 */
    public String getToken() {
        return this.token;
    }

    public String toString() {
        return new Gson().toJson((Object) this);
    }

    /* access modifiers changed from: 0000 */
    public String prettyString() {
        return new GsonBuilder().setPrettyPrinting().create().toJson((Object) this);
    }
}
