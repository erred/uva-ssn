package com.bridgefy.sdk.client.registration;

import androidx.annotation.Keep;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;
import com.google.gson.annotations.Expose;

@Keep
class ErrorResponse {
    @JsonProperty("code")
    @Expose
    private int code;
    @JsonProperty("message")
    @Expose
    private String message;

    ErrorResponse() {
    }

    ErrorResponse(int i, String str) {
        this.code = i;
        this.message = str;
    }

    public String toString() {
        return new Gson().toJson((Object) this);
    }

    /* access modifiers changed from: 0000 */
    public int getCode() {
        return this.code;
    }

    /* access modifiers changed from: 0000 */
    public String getMessage() {
        return this.message;
    }
}
