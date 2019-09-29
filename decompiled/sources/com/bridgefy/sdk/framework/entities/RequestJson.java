package com.bridgefy.sdk.framework.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;

public class RequestJson {
    public static final int HS_REQUEST_TYPE_CANCEL = 2;
    public static final int HS_REQUEST_TYPE_GENERAL = 0;
    public static final int HS_REQUEST_TYPE_KEY = 1;
    @JsonProperty("type")

    /* renamed from: a */
    int type;
    @JsonProperty("crc")

    /* renamed from: b */
    String crc;

    public RequestJson(int i) {
        this.type = i;
    }

    public RequestJson() {
    }

    @JsonProperty("type")
    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    @JsonProperty("crc")
    public String getCrc() {
        return this.crc;
    }

    public void setCrc(String str) {
        this.crc = str;
    }

    public String toString() {
        return new Gson().toJson((Object) this);
    }
}
