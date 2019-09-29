package com.bridgefy.sdk.framework.exceptions;

public class MessageException extends Exception {
    public MessageException(String str) {
        super(str);
    }

    public MessageException(String str, Exception exc) {
        super(str, exc);
    }

    public MessageException(Exception exc) {
        super(exc);
    }
}
