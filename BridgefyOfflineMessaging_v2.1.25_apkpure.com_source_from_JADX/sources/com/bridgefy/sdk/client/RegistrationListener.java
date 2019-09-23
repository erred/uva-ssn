package com.bridgefy.sdk.client;

public abstract class RegistrationListener {
    public static final int REGISTRATION_FAILED = -66;
    public static final int REGISTRATION_FAILED_DEVICE = -2;
    public static final int REGISTRATION_FAILED_INVALID = -3;
    public static final int REGISTRATION_FAILED_NETWORK = -1;

    public void onRegistrationFailed(int i, String str) {
    }

    public void onRegistrationSuccessful(BridgefyClient bridgefyClient) {
    }
}
