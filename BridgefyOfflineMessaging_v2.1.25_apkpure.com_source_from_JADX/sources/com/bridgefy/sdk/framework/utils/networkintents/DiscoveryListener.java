package com.bridgefy.sdk.framework.utils.networkintents;

import android.content.Intent;
import java.net.InetAddress;

public interface DiscoveryListener {
    void onDiscoveryError(Exception exc);

    void onDiscoveryStarted();

    void onDiscoveryStopped();

    void onIntentDiscovered(InetAddress inetAddress, Intent intent);
}
