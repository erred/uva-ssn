package com.bridgefy.sdk.client;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;

public class DeviceProfile {

    /* renamed from: a */
    private String device_evaluation;

    /* renamed from: b */
    private int rating;

    /* renamed from: c */
    private device_characteristics device_characteristics_profile;

    /* renamed from: com.bridgefy.sdk.client.DeviceProfile$a */
    enum device_characteristics {
        DeviceSupportsBluetoothClassic,
        DeviceSupportsBluetoothLeCentral,
        DeviceSupportsBluetoothLePeripheral,
        DeviceSupportsAllCharacteristics,
        DeviceSupportsBluetooth5
    }

    public static int getMaxConnectionsForDevice() {
        return 8;
    }

    public static int getMtuForDevice() {
        return (!Build.MANUFACTURER.equals("motorola") || Build.MODEL.equals("Moto G (4)") || Build.MODEL.equals("MotoE2(4G-LTE)")) ? 256 : 256;
    }

    public static int getMaxServerConnections() {
        return Build.MANUFACTURER.equals("motorola") ? 2 : 4;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0036  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean deviceCanStopScan() {
        /*
            java.lang.String r0 = android.os.Build.MANUFACTURER
            int r1 = r0.hashCode()
            r2 = -284840886(0xffffffffef05ac4a, float:-4.136979E28)
            r3 = 0
            r4 = 1
            if (r1 == r2) goto L_0x001d
            r2 = -151542385(0xfffffffff6f7a58f, float:-2.511436E33)
            if (r1 == r2) goto L_0x0013
            goto L_0x0027
        L_0x0013:
            java.lang.String r1 = "motorola"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0027
            r0 = 0
            goto L_0x0028
        L_0x001d:
            java.lang.String r1 = "unknown"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0027
            r0 = 1
            goto L_0x0028
        L_0x0027:
            r0 = -1
        L_0x0028:
            switch(r0) {
                case 0: goto L_0x0036;
                case 1: goto L_0x002c;
                default: goto L_0x002b;
            }
        L_0x002b:
            return r4
        L_0x002c:
            java.lang.String r0 = android.os.Build.MODEL
            java.lang.String r1 = "iot_rpi3"
            boolean r0 = r0.equalsIgnoreCase(r1)
            r0 = r0 ^ r4
            return r0
        L_0x0036:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 24
            if (r0 < r1) goto L_0x0046
            java.lang.String r0 = android.os.Build.MODEL
            java.lang.String r1 = "Nexus 6"
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L_0x0047
        L_0x0046:
            r3 = 1
        L_0x0047:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bridgefy.sdk.client.DeviceProfile.deviceCanStopScan():boolean");
    }

    DeviceProfile(Context context) {
        m7676a(context);
        get_device_characteristics(context);
    }

    /* renamed from: a */
    private void m7676a(Context context) {
        this.rating = VERSION.SDK_INT - 21;
        StringBuilder sb = new StringBuilder();
        sb.append(m7675a());
        sb.append(" Android SDK version ");
        sb.append(VERSION.SDK_INT);
        sb.append(" +");
        sb.append(this.rating);
        sb.append("\n");
        this.device_evaluation = sb.toString();
        if (BridgefyUtils.getBluetoothAdapter(context).getBluetoothLeAdvertiser() != null) {
            this.rating++;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.device_evaluation);
            sb2.append(" Device can act as a client and a server +1\n");
            this.device_evaluation = sb2.toString();
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(this.device_evaluation);
            sb3.append(" Device can only act as a client \n");
            this.device_evaluation = sb3.toString();
        }
        if (BridgefyUtils.getBluetoothAdapter(context).isOffloadedFilteringSupported()) {
            this.rating++;
            StringBuilder sb4 = new StringBuilder();
            sb4.append(this.device_evaluation);
            sb4.append(" Device can filter unwanted interference +1\n");
            this.device_evaluation = sb4.toString();
        } else {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.device_evaluation);
            sb5.append(" Device may experience interference from external sources \n");
            this.device_evaluation = sb5.toString();
        }
        if (BridgefyUtils.getBluetoothAdapter(context).isOffloadedScanBatchingSupported()) {
            this.rating++;
            StringBuilder sb6 = new StringBuilder();
            sb6.append(this.device_evaluation);
            sb6.append(" Device can batch scan results +1\n");
            this.device_evaluation = sb6.toString();
        } else {
            StringBuilder sb7 = new StringBuilder();
            sb7.append(this.device_evaluation);
            sb7.append(" Device cannot batch scan results \n");
            this.device_evaluation = sb7.toString();
        }
        if (VERSION.SDK_INT >= 26) {
            if (isLeExtendedRangeSupported(context)) {
                this.rating++;
                StringBuilder sb8 = new StringBuilder();
                sb8.append(this.device_evaluation);
                sb8.append(" Device supports Bluetooth 5 LE Coded PHY features +1 \n");
                this.device_evaluation = sb8.toString();
            }
            if (isLeDoubleRateSupported(context)) {
                this.rating++;
                StringBuilder sb9 = new StringBuilder();
                sb9.append(this.device_evaluation);
                sb9.append(" Device supports Bluetooth 5 LE 2M PHY features +1 \n");
                this.device_evaluation = sb9.toString();
            }
            if (isLeExtendedAdvertisingSupported(context)) {
                this.rating++;
                StringBuilder sb10 = new StringBuilder();
                sb10.append(this.device_evaluation);
                sb10.append(" Device supports Bluetooth 5 Extended Advertising +1 \n");
                this.device_evaluation = sb10.toString();
            }
            if (is_le_periodic_advertising_supported(context)) {
                this.rating++;
                StringBuilder sb11 = new StringBuilder();
                sb11.append(this.device_evaluation);
                sb11.append(" Device supports Bluetooth 5 Periodic Advertising +1 \n");
                this.device_evaluation = sb11.toString();
            }
        }
        if (deviceCanStopScan()) {
            this.rating++;
            StringBuilder sb12 = new StringBuilder();
            sb12.append(this.device_evaluation);
            sb12.append(" Device can reset ongoing scans without side effects +1\n");
            this.device_evaluation = sb12.toString();
            return;
        }
        StringBuilder sb13 = new StringBuilder();
        sb13.append(this.device_evaluation);
        sb13.append(" Device may not be able to reset ongoing scans\n");
        this.device_evaluation = sb13.toString();
    }

    /* renamed from: b */
    private static boolean is_le_periodic_advertising_supported(Context context) {
        return VERSION.SDK_INT >= 26 && BridgefyUtils.getBluetoothAdapter(context).isLePeriodicAdvertisingSupported();
    }

    public static boolean isLeExtendedAdvertisingSupported(Context context) {
        return VERSION.SDK_INT >= 26 && BridgefyUtils.getBluetoothAdapter(context).isLeExtendedAdvertisingSupported();
    }

    public static boolean isLeDoubleRateSupported(Context context) {
        return VERSION.SDK_INT >= 26 && BridgefyUtils.getBluetoothAdapter(context).isLe2MPhySupported();
    }

    public static boolean isLeExtendedRangeSupported(Context context) {
        return VERSION.SDK_INT >= 26 && BridgefyUtils.getBluetoothAdapter(context).isLeCodedPhySupported();
    }

    /* renamed from: c */
    private void get_device_characteristics(Context context) {
        if (!context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
            this.device_characteristics_profile = device_characteristics.DeviceSupportsBluetoothClassic;
        } else if (!isAdvertisingSupported(context)) {
            this.device_characteristics_profile = device_characteristics.DeviceSupportsBluetoothLeCentral;
        } else if (VERSION.SDK_INT >= 23) {
            this.device_characteristics_profile = device_characteristics.DeviceSupportsAllCharacteristics;
        } else {
            this.device_characteristics_profile = device_characteristics.DeviceSupportsBluetoothLePeripheral;
        }
    }

    public boolean isAdvertisingSupported(Context context) {
        return (BridgefyUtils.getBluetoothAdapter(context) == null || BridgefyUtils.getBluetoothAdapter(context).getBluetoothLeAdvertiser() == null) ? false : true;
    }

    /* renamed from: a */
    private String m7675a() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.startsWith(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append(Character.toUpperCase(str2.charAt(0)));
            sb.append(str2.substring(1).toLowerCase());
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        sb2.append(str2);
        return sb2.toString();
    }

    public String getDeviceEvaluation() {
        return this.device_evaluation;
    }

    public int getRating() {
        return this.rating;
    }

    public device_characteristics getDeviceCharacteristicsProfile() {
        return this.device_characteristics_profile;
    }
}
