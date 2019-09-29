package com.bridgefy.sdk.client.registration;

import androidx.annotation.Keep;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

@Keep
class CertificateResponse {
    @JsonProperty("data")
    @Expose
    private byte[] data;
    @JsonProperty("signature")
    @Expose
    private byte[] signature;

    CertificateResponse() {
    }

    CertificateResponse(byte[] bArr, byte[] bArr2) {
        this.data = bArr;
        this.signature = bArr2;
    }

    /* access modifiers changed from: 0000 */
    public byte[] getData() {
        return this.data;
    }

    /* access modifiers changed from: 0000 */
    public byte[] getSignature() {
        return this.signature;
    }

    public String toString() {
        return new Gson().toJson((Object) this);
    }

    /* access modifiers changed from: 0000 */
    public String prettyString() {
        return new GsonBuilder().setPrettyPrinting().create().toJson((Object) this);
    }
}
