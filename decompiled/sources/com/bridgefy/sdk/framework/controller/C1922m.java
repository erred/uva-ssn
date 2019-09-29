package com.bridgefy.sdk.framework.controller;

import android.bluetooth.le.AdvertiseData;
import android.bluetooth.le.AdvertiseData.Builder;
import android.bluetooth.le.AdvertiseSettings;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanSettings;
import android.os.Build.VERSION;
import android.os.ParcelUuid;
import com.bridgefy.sdk.client.BFEnergyProfile;
import com.bridgefy.sdk.client.Bridgefy;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/* renamed from: com.bridgefy.sdk.framework.controller.m */
class C1922m {

    /* renamed from: a */
    static UUID f5994a = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");

    /* renamed from: b */
    private static UUID f5995b;

    /* renamed from: c */
    private static UUID f5996c;

    /* renamed from: com.bridgefy.sdk.framework.controller.m$1 */
    static /* synthetic */ class C19231 {

        /* renamed from: a */
        static final /* synthetic */ int[] f5997a = new int[BFEnergyProfile.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.bridgefy.sdk.client.BFEnergyProfile[] r0 = com.bridgefy.sdk.client.BFEnergyProfile.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5997a = r0
                int[] r0 = f5997a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.bridgefy.sdk.client.BFEnergyProfile r1 = com.bridgefy.sdk.client.BFEnergyProfile.ENERGY_SAVER     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f5997a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.bridgefy.sdk.client.BFEnergyProfile r1 = com.bridgefy.sdk.client.BFEnergyProfile.BALANCED     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f5997a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.bridgefy.sdk.client.BFEnergyProfile r1 = com.bridgefy.sdk.client.BFEnergyProfile.HIGH_PERFORMANCE     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bridgefy.sdk.framework.controller.C1922m.C19231.<clinit>():void");
        }
    }

    /* renamed from: a */
    static AdvertiseData m7984a(String str, UUID uuid) {
        Builder builder = new Builder();
        if (VERSION.SDK_INT >= 26) {
            builder.addServiceData(new ParcelUuid(m7987a(uuid)), str.getBytes());
        } else {
            builder.addServiceData(new ParcelUuid(uuid), str.getBytes());
        }
        builder.setIncludeDeviceName(false);
        return builder.build();
    }

    /* renamed from: a */
    static AdvertiseSettings m7985a() {
        AdvertiseSettings.Builder builder = new AdvertiseSettings.Builder();
        int i = C19231.f5997a[Bridgefy.getInstance().getConfig().getEnergyProfile().ordinal()];
        if (i == 1) {
            builder.setAdvertiseMode(0);
        } else if (i != 3) {
            builder.setAdvertiseMode(1);
        } else {
            builder.setAdvertiseMode(2);
        }
        builder.setConnectable(true);
        builder.setTimeout(0);
        return builder.build();
    }

    /* renamed from: a */
    static UUID m7987a(UUID uuid) {
        StringBuilder sb = new StringBuilder();
        sb.append("0000");
        sb.append(uuid.toString().substring(4, 8));
        sb.append("-0000-1000-8000-00805f9b34fb");
        return UUID.fromString(sb.toString());
    }

    /* renamed from: a */
    private static UUID m7986a(String str) {
        ByteBuffer wrap = ByteBuffer.wrap(Arrays.copyOfRange(m7990b(str), 0, 16));
        return new UUID(wrap.getLong(), wrap.getLong());
    }

    /* renamed from: b */
    private static byte[] m7990b(String str) {
        MessageDigest messageDigest;
        byte[] bArr = new byte[32];
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            try {
                bArr = messageDigest.digest(str.getBytes("UTF-8"));
            } catch (NoSuchAlgorithmException e) {
                e = e;
                e.printStackTrace();
                messageDigest.reset();
                return bArr;
            } catch (UnsupportedEncodingException e2) {
                e = e2;
                e.printStackTrace();
                messageDigest.reset();
                return bArr;
            }
        } catch (NoSuchAlgorithmException e3) {
            e = e3;
            messageDigest = null;
            e.printStackTrace();
            messageDigest.reset();
            return bArr;
        } catch (UnsupportedEncodingException e4) {
            e = e4;
            messageDigest = null;
            e.printStackTrace();
            messageDigest.reset();
            return bArr;
        }
        messageDigest.reset();
        return bArr;
    }

    /* renamed from: b */
    static UUID m7989b() {
        if (f5995b == null) {
            f5995b = m7986a(Bridgefy.getInstance().getBridgefyClient().getApiKey());
        }
        return f5995b;
    }

    /* renamed from: c */
    static UUID m7991c() {
        if (f5996c == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(Bridgefy.getInstance().getBridgefyClient().getApiKey());
            sb.append("CHARACTERISTIC");
            f5996c = m7986a(sb.toString());
        }
        return f5996c;
    }

    /* renamed from: b */
    static List<ScanFilter> m7988b(UUID uuid) {
        ArrayList arrayList = new ArrayList();
        ScanFilter.Builder builder = new ScanFilter.Builder();
        builder.setServiceUuid(new ParcelUuid(uuid));
        arrayList.add(builder.build());
        ScanFilter.Builder builder2 = new ScanFilter.Builder();
        builder2.setServiceData(new ParcelUuid(m7987a(uuid)), null);
        arrayList.add(builder2.build());
        return arrayList;
    }

    /* renamed from: d */
    static ScanSettings m7992d() {
        ScanSettings.Builder builder = new ScanSettings.Builder();
        if (VERSION.SDK_INT >= 23) {
            builder.setNumOfMatches(1);
        }
        int i = C19231.f5997a[Bridgefy.getInstance().getConfig().getEnergyProfile().ordinal()];
        if (i == 1) {
            builder.setScanMode(0);
        } else if (i != 3) {
            builder.setScanMode(1);
        } else {
            builder.setScanMode(2);
        }
        return builder.build();
    }
}
