package com.google.android.gms.common.wrappers;

import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;

@KeepForSdk
public class InstantApps {
    private static Context zzhu;
    private static Boolean zzhv;

    @KeepForSdk
    public static synchronized boolean isInstantApp(Context context) {
        synchronized (InstantApps.class) {
            Context applicationContext = context.getApplicationContext();
            if (zzhu == null || zzhv == null || zzhu != applicationContext) {
                zzhv = null;
                if (PlatformVersion.isAtLeastO()) {
                    zzhv = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
                } else {
                    try {
                        context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                        zzhv = Boolean.valueOf(true);
                    } catch (ClassNotFoundException unused) {
                        zzhv = Boolean.valueOf(false);
                    }
                }
                zzhu = applicationContext;
                boolean booleanValue = zzhv.booleanValue();
                return booleanValue;
            }
            boolean booleanValue2 = zzhv.booleanValue();
            return booleanValue2;
        }
    }
}
