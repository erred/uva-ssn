package com.bridgefy.sdk.client;

public abstract class StateListener {
    public static final int BLE_NOT_SUPPORTED = -10;
    public static final String BLE_NOT_SUPPORTED_STRING = "Bluetooth Low Energy (BLE) is notsupported in this device";
    public static final int INITIALIZATION_ERROR = -40;
    public static final String INITIALIZATION_ERROR_STRING = "Bridgefy must be initialized before calling start().";
    public static final String INSUFFICIENT_BLUETOOTH_PERMISSIONS_STRING = "BLUETOOTH and BLUETOOTH_ADMIN permissions must be granted for Bluetooth Connectivity to work";
    public static final String INSUFFICIENT_LOCATION_PERMISSIONS_STRING = "Either ACCESS_FINE_LOCATION or ACCESS_COARSE_LOCATION must be granted for Bluetooth connectivity to work";
    public static final int INSUFFICIENT_PERMISSIONS = -20;
    public static final int LOCATION_SERVICES_DISABLED = -30;
    public static final String LOCATION_SERVICES_STRING = "Location Services must be enabled on devices with Android 6.0+ or higher for BLE connectivity to work";

    public void onDeviceBlackListed(Device device) {
    }

    public void onDeviceConnected(Device device, Session session) {
    }

    public void onDeviceLost(Device device) {
    }

    public void onStartError(String str, int i) {
    }

    public void onStarted() {
    }

    public void onStopped() {
    }
}
