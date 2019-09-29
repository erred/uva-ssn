package com.bridgefy.sdk.framework.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;

public class BleHandshake {
    public static final String DEVICE_TYPE = "android";
    @JsonProperty("rq")

    /* renamed from: a */
    private Integer rq;
    @JsonProperty("rp")

    /* renamed from: b */
    private ResponseJson rp;

    public BleHandshake() {
    }

    public BleHandshake(Integer num, ResponseJson responseJson) {
        this.rq = num;
        this.rp = responseJson;
    }

    @JsonProperty("rq")
    public Integer getRq() {
        return this.rq;
    }

    public void setRq(Integer num) {
        this.rq = num;
    }

    @JsonProperty("rp")
    public ResponseJson getRp() {
        return this.rp;
    }

    public void setRp(ResponseJson responseJson) {
        this.rp = responseJson;
    }

    public String toString() {
        return new Gson().toJson((Object) this);
    }
}
