package com.bridgefy.sdk.client;

import com.bridgefy.sdk.client.Config.Antenna;

public interface Session {
    public static final int MAX_CHUNK_SIZE_ANDROID = 256;

    Antenna getAntennaType();

    long getCrc();

    String getPublicKey();

    String getUserId();
}
