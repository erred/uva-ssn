package com.bridgefy.sdk.framework.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;

public class RequestJson {
    public static final int HS_REQUEST_TYPE_CANCEL = 2;
    public static final int HS_REQUEST_TYPE_GENERAL = 0;
    public static final int HS_REQUEST_TYPE_KEY = 1;
    @JsonProperty("type")

    /* renamed from: a */
    int f6057a;
    @JsonProperty("crc")

    /* renamed from: b */
    String f6058b;

    public RequestJson(int i) {
        this.f6057a = i;
    }

    public RequestJson() {
    }

    @JsonProperty("type")
    public int getType() {
        return this.f6057a;
    }

    public void setType(int i) {
        this.f6057a = i;
    }

    @JsonProperty("crc")
    public String getCrc() {
        return this.f6058b;
    }

    public void setCrc(String str) {
        this.f6058b = str;
    }

    public String toString() {
        return new Gson().toJson((Object) this);
    }
}
