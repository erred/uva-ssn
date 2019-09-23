package com.bridgefy.sdk.framework.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;
import java.util.HashMap;

public class BleEntityContent {
    @JsonProperty("pld")

    /* renamed from: a */
    private HashMap<String, Object> f6031a;
    @JsonProperty("id")

    /* renamed from: b */
    private String f6032b;

    public BleEntityContent() {
    }

    public BleEntityContent(String str) {
        this.f6032b = str;
    }

    public BleEntityContent(HashMap<String, Object> hashMap, String str) {
        this.f6031a = hashMap;
        this.f6032b = str;
    }

    @JsonProperty("pld")
    public HashMap<String, Object> getPld() {
        return this.f6031a;
    }

    public String toString() {
        return new Gson().toJson((Object) this);
    }

    @JsonProperty("id")
    public String getId() {
        return this.f6032b;
    }

    public void setId(String str) {
        this.f6032b = str;
    }
}
