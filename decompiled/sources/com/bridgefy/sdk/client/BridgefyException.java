package com.bridgefy.sdk.client;

public class BridgefyException extends RuntimeException {

    /* renamed from: a */
    private int f5778a;

    public BridgefyException(int i, String str) {
        super(str);
        this.f5778a = i;
    }

    public int getErrorCode() {
        return this.f5778a;
    }
}
