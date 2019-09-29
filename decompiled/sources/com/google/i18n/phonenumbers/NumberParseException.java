package com.google.i18n.phonenumbers;

public class NumberParseException extends Exception {
    private ErrorType errorType;
    private String message;

    public enum ErrorType {
        INVALID_COUNTRY_CODE,
        NOT_A_NUMBER,
        TOO_SHORT_AFTER_IDD,
        TOO_SHORT_NSN,
        TOO_LONG
    }

    public NumberParseException(ErrorType errorType2, String str) {
        super(str);
        this.message = str;
        this.errorType = errorType2;
    }

    public ErrorType getErrorType() {
        return this.errorType;
    }

    public String toString() {
        String valueOf = String.valueOf(String.valueOf(this.errorType));
        String valueOf2 = String.valueOf(String.valueOf(this.message));
        StringBuilder sb = new StringBuilder(valueOf.length() + 14 + valueOf2.length());
        sb.append("Error type: ");
        sb.append(valueOf);
        sb.append(". ");
        sb.append(valueOf2);
        return sb.toString();
    }
}
