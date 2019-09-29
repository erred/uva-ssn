package com.bridgefy.sdk.client.registration;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response<T> {
    @SerializedName("status")
    @Expose

    /* renamed from: a */
    String f5832a;
    @SerializedName("data")
    @Expose

    /* renamed from: b */
    T f5833b;
    @SerializedName("message")
    @Expose

    /* renamed from: c */
    String f5834c;

    public String getStatus() {
        return this.f5832a;
    }

    public void setStatus(String str) {
        this.f5832a = str;
    }

    public T getData() {
        return this.f5833b;
    }

    public void setData(T t) {
        this.f5833b = t;
    }

    public String getMessage() {
        return this.f5834c;
    }

    public void setMessage(String str) {
        this.f5834c = str;
    }
}
