package com.bridgefy.sdk.framework.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;
import java.util.HashMap;

public class BleEntityContent {
    @JsonProperty("pld")

    /* renamed from: a */
    private HashMap<String, Object> pld;
    @JsonProperty("id")

    /* renamed from: b */
    private String id;

    public BleEntityContent() {
    }

    public BleEntityContent(String str) {
        this.id = str;
    }

    public BleEntityContent(HashMap<String, Object> hashMap, String str) {
        this.pld = hashMap;
        this.id = str;
    }

    @JsonProperty("pld")
    public HashMap<String, Object> getPld() {
        return this.pld;
    }

    public String toString() {
        return new Gson().toJson((Object) this);
    }

    @JsonProperty("id")
    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }
}
