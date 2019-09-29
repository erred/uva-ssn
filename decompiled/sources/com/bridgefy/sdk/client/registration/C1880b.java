package com.bridgefy.sdk.client.registration;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;
import com.google.gson.annotations.Expose;

/* renamed from: com.bridgefy.sdk.client.registration.b */
class C1880b {
    @JsonProperty("timestamp")
    @Expose

    /* renamed from: a */
    public String f5837a;

    public C1880b() {
    }

    C1880b(String str) {
        this.f5837a = str;
    }

    public String toString() {
        return new Gson().toJson((Object) this);
    }
}
