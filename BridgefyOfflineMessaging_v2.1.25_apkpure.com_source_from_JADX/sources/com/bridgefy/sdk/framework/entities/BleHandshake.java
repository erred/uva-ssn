package com.bridgefy.sdk.framework.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;

public class BleHandshake {
    public static final String DEVICE_TYPE = "android";
    @JsonProperty("rq")

    /* renamed from: a */
    private Integer f6033a;
    @JsonProperty("rp")

    /* renamed from: b */
    private ResponseJson f6034b;

    public BleHandshake() {
    }

    public BleHandshake(Integer num, ResponseJson responseJson) {
        this.f6033a = num;
        this.f6034b = responseJson;
    }

    @JsonProperty("rq")
    public Integer getRq() {
        return this.f6033a;
    }

    public void setRq(Integer num) {
        this.f6033a = num;
    }

    @JsonProperty("rp")
    public ResponseJson getRp() {
        return this.f6034b;
    }

    public void setRp(ResponseJson responseJson) {
        this.f6034b = responseJson;
    }

    public String toString() {
        return new Gson().toJson((Object) this);
    }
}
