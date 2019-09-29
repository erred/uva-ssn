package com.bridgefy.sdk.framework.entities;

import com.bridgefy.sdk.framework.utils.Utils;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;

public class ResponseJson {
    public static final int HS_RESPONSE_TYPE_GENERAL = 0;
    public static final int HS_RESPONSE_TYPE_KEY = 1;
    @JsonProperty("type")

    /* renamed from: a */
    private int type;
    @JsonProperty("dt")

    /* renamed from: b */
    private int dt;
    @JsonProperty("crckey")

    /* renamed from: c */
    private long crckey;
    @JsonProperty("v")

    /* renamed from: d */
    private String v;
    @JsonProperty("lcv")

    /* renamed from: e */
    private String lcv;
    @JsonProperty("key")

    /* renamed from: f */
    private String key;
    @JsonProperty("uuid")

    /* renamed from: g */
    private String uuid;

    public ResponseJson() {
    }

    public ResponseJson(int i) {
        this.type = i;
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
        this.type = i;
        this.crckey = j;
        this.v = str;
        this.lcv = str2;
        this.key = str3;
        this.uuid = str4;
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
        return this.crckey;
    }

    public void setCrckey(long j) {
        this.crckey = j;
    }

    @JsonProperty("v")
    public String getV() {
        return this.v;
    }

    public void setV(String str) {
        this.v = str;
    }

    @JsonProperty("lcv")
    public String getLcv() {
        return this.lcv;
    }

    public void setLcv(String str) {
        this.lcv = str;
    }

    @JsonProperty("type")
    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    @JsonProperty("key")
    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    @JsonProperty("uuid")
    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    public String toString() {
        return new Gson().toJson((Object) this);
    }

    public int getDt() {
        return this.dt;
    }

    public void setDt(int i) {
        this.dt = i;
    }
}
