package com.bridgefy.sdk.client;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.location.LocationManager;
import android.os.Build.VERSION;
import com.bridgefy.sdk.client.Config.Antenna;
import com.google.common.net.HttpHeaders;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import p091b.C1590aa.C1591a;
import p091b.C1592ab;
import p091b.C1596ac;
import p091b.C1647v;
import p091b.C1651x;

public class BridgefyUtils {

    public static class Reflection {

        /* renamed from: a */
        static Reflection f5780a;

        /* renamed from: b */
        Class<?> f5781b;

        /* renamed from: c */
        String f5782c;

        /* renamed from: d */
        Object f5783d = null;

        /* renamed from: e */
        Class<?>[] f5784e = new Class[0];

        /* renamed from: f */
        Object[] f5785f = new Object[0];

        public static Reflection privateMethod(String str) {
            f5780a = new Reflection();
            f5780a.f5782c = str;
            return f5780a;
        }

        public Reflection ofClass(Class<?> cls) {
            f5780a.f5781b = cls;
            return f5780a;
        }

        public Reflection onObject(Object obj) {
            f5780a.f5783d = obj;
            return f5780a;
        }

        public Reflection withArgs(Object... objArr) {
            f5780a.f5785f = objArr;
            return f5780a;
        }

        public Reflection argTypes(Class<?>... clsArr) {
            f5780a.f5784e = clsArr;
            return f5780a;
        }

        public Object execute() {
            Object obj;
            try {
                Method declaredMethod = this.f5781b.getDeclaredMethod(this.f5782c, this.f5784e);
                declaredMethod.setAccessible(true);
                obj = declaredMethod.invoke(this.f5783d, this.f5785f);
                try {
                    declaredMethod.setAccessible(false);
                } catch (Exception e) {
                    e = e;
                }
            } catch (Exception e2) {
                e = e2;
                obj = null;
                e.printStackTrace();
                return obj;
            }
            return obj;
        }
    }

    public static void enableBluetooth(Context context) {
        getBluetoothAdapter(context).enable();
    }

    /* renamed from: a */
    private static boolean m7667a(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }

    public static BluetoothAdapter getBluetoothAdapter(Context context) {
        return ((BluetoothManager) context.getSystemService("bluetooth")).getAdapter();
    }

    public static boolean isLocationAvailable(Context context) {
        boolean z = false;
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService(Param.LOCATION);
            if (isThingsDevice(context) || locationManager.isProviderEnabled("gps") || locationManager.isProviderEnabled("network")) {
                z = true;
            }
            return z;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isThingsDevice(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.type.embedded");
    }

    /* renamed from: a */
    static void m7666a(Context context, Config config) throws BridgefyException {
        switch (config.getAntennaType()) {
            case BLUETOOTH:
            case BLUETOOTH_LE:
                m7668b(context);
                if (config.getAntennaType() == Antenna.BLUETOOTH || (config.getAntennaType() == Antenna.BLUETOOTH_LE && !m7667a(context))) {
                    throw new BridgefyException(-10, StateListener.BLE_NOT_SUPPORTED_STRING);
                }
                return;
            default:
                return;
        }
    }

    public static boolean checkLocationPermissions(Context context) {
        return context.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0 || context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0;
    }

    public static boolean checkBluetoothPermission(Context context) {
        return context.checkCallingOrSelfPermission("android.permission.BLUETOOTH") == 0 && context.checkCallingOrSelfPermission("android.permission.BLUETOOTH_ADMIN") == 0;
    }

    /* renamed from: b */
    private static void m7668b(Context context) throws BridgefyException {
        if (VERSION.SDK_INT >= 23) {
            if (!checkLocationPermissions(context)) {
                throw new BridgefyException(-20, StateListener.INSUFFICIENT_LOCATION_PERMISSIONS_STRING);
            } else if (!isLocationAvailable(context)) {
                throw new BridgefyException(-30, StateListener.LOCATION_SERVICES_STRING);
            }
        }
        if (!checkBluetoothPermission(context)) {
            throw new BridgefyException(-20, StateListener.INSUFFICIENT_BLUETOOTH_PERMISSIONS_STRING);
        }
    }

    public static String getTimeStamp() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat.format(new Date());
    }

    public static C1596ac post(C1647v vVar, String str, byte[] bArr, String str2) throws Exception {
        C1651x xVar = new C1651x();
        C1591a a = new C1591a().mo6468a(str).mo6464a(C1592ab.m6496a(vVar, bArr));
        if (str2 != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Bearer ");
            sb.append(str2);
            a.mo6473b("authorization", sb.toString());
        }
        C1596ac a2 = xVar.mo6555a(a.mo6471a()).mo6552a();
        return a2.mo6481c() == 307 ? post(vVar, a2.mo6478a(HttpHeaders.LOCATION), bArr, str2) : a2;
    }
}
