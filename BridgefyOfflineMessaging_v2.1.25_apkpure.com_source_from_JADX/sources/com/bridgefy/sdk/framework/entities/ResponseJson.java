package com.bridgefy.sdk.framework.entities;

import com.bridgefy.sdk.framework.utils.Utils;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;

public class ResponseJson {
    public static final int HS_RESPONSE_TYPE_GENERAL = 0;
    public static final int HS_RESPONSE_TYPE_KEY = 1;
    @JsonProperty("type")

    /* renamed from: a */
    private int f6059a;
    @JsonProperty("dt")

    /* renamed from: b */
    private int f6060b;
    @JsonProperty("crckey")

    /* renamed from: c */
    private long f6061c;
    @JsonProperty("v")

    /* renamed from: d */
    private String f6062d;
    @JsonProperty("lcv")

    /* renamed from: e */
    private String f6063e;
    @JsonProperty("key")

    /* renamed from: f */
    private String f6064f;
    @JsonProperty("uuid")

    /* renamed from: g */
    private String f6065g;

    public ResponseJson() {
    }

    public ResponseJson(int i) {
        this.f6059a = i;
    }

    public static ResponseJson ResponseTypeGeneral(String str, long j, String str2, String str3) {
        ResponseJson responseJson = new ResponseJson();
        responseJson.setUuid(str);
        responseJson.setCrckey(j);
        responseJson.setV(str2);
        responseJson.setDt(1);
        responseJson.setLcv(str3);
        responseJson.setType(0);
        return responseJson;
    }

    public ResponseJson(int i, long j, String str, String str2, String str3, String str4) {
        this.f6059a = i;
        this.f6061c = j;
        this.f6062d = str;
        this.f6063e = str2;
        this.f6064f = str3;
        this.f6065g = str4;
    }

    public static ResponseJson ResponseTypeKey(String str) {
        ResponseJson responseJson = new ResponseJson();
        responseJson.setType(1);
        responseJson.setKey(str);
        responseJson.setCrckey(Utils.getCrcFromKey(str));
        return responseJson;
    }

    @JsonProperty("crckey")
    public long getCrckey() {
        return this.f6061c;
    }

    public void setCrckey(long j) {
        this.f6061c = j;
    }

    @JsonProperty("v")
    public String getV() {
        return this.f6062d;
    }

    public void setV(String str) {
        this.f6062d = str;
    }

    @JsonProperty("lcv")
    public String getLcv() {
        return this.f6063e;
    }

    public void setLcv(String str) {
        this.f6063e = str;
    }

    @JsonProperty("type")
    public int getType() {
        return this.f6059a;
    }

    public void setType(int i) {
        this.f6059a = i;
    }

    @JsonProperty("key")
    public String getKey() {
        return this.f6064f;
    }

    public void setKey(String str) {
        this.f6064f = str;
    }

    @JsonProperty("uuid")
    public String getUuid() {
        return this.f6065g;
    }

    public void setUuid(String str) {
        this.f6065g = str;
    }

    public String toString() {
        return new Gson().toJson((Object) this);
    }

    public int getDt() {
        return this.f6060b;
    }

    public void setDt(int i) {
        this.f6060b = i;
    }
}
