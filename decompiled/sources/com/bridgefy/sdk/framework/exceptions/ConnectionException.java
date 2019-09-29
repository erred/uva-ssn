package com.bridgefy.sdk.framework.exceptions;

public class ConnectionException extends Exception {
    public ConnectionException(String str, Exception exc) {
        super(str, exc);
    }

    public ConnectionException(String str) {
        super(str);
    }

    public ConnectionException(Exception exc) {
        super(exc);
    }
}
