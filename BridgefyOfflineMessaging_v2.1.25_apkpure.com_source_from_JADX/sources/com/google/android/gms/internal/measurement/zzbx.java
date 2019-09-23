package com.google.android.gms.internal.measurement;

import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashSet;
import java.util.Set;

public final class zzbx {
    private final zzaw zzqx;
    private volatile Boolean zzyk;
    private String zzyl;
    private Set<Integer> zzym;

    protected zzbx(zzaw zzaw) {
        Preconditions.checkNotNull(zzaw);
        this.zzqx = zzaw;
    }

    public final boolean zzdw() {
        if (this.zzyk == null) {
            synchronized (this) {
                if (this.zzyk == null) {
                    ApplicationInfo applicationInfo = this.zzqx.getContext().getApplicationInfo();
                    String myProcessName = ProcessUtils.getMyProcessName();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.zzyk = Boolean.valueOf(str != null && str.equals(myProcessName));
                    }
                    if ((this.zzyk == null || !this.zzyk.booleanValue()) && "com.google.android.gms.analytics".equals(myProcessName)) {
                        this.zzyk = Boolean.TRUE;
                    }
                    if (this.zzyk == null) {
                        this.zzyk = Boolean.TRUE;
                        this.zzqx.zzby().zzu("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.zzyk.booleanValue();
    }

    public static boolean zzdx() {
        return ((Boolean) zzcf.zzyw.get()).booleanValue();
    }

    public static int zzdy() {
        return ((Integer) zzcf.zzzt.get()).intValue();
    }

    public static long zzdz() {
        return ((Long) zzcf.zzze.get()).longValue();
    }

    public static long zzea() {
        return ((Long) zzcf.zzzh.get()).longValue();
    }

    public static int zzeb() {
        return ((Integer) zzcf.zzzj.get()).intValue();
    }

    public static int zzec() {
        return ((Integer) zzcf.zzzk.get()).intValue();
    }

    @VisibleForTesting
    public static String zzed() {
        return (String) zzcf.zzzm.get();
    }

    @VisibleForTesting
    public static String zzee() {
        return (String) zzcf.zzzl.get();
    }

    public static String zzef() {
        return (String) zzcf.zzzn.get();
    }

    public final Set<Integer> zzeg() {
        String str = (String) zzcf.zzzw.get();
        if (this.zzym == null || this.zzyl == null || !this.zzyl.equals(str)) {
            String[] split = TextUtils.split(str, ",");
            HashSet hashSet = new HashSet();
            for (String parseInt : split) {
                try {
                    hashSet.add(Integer.valueOf(Integer.parseInt(parseInt)));
                } catch (NumberFormatException unused) {
                }
            }
            this.zzyl = str;
            this.zzym = hashSet;
        }
        return this.zzym;
    }

    public static long zzeh() {
        return ((Long) zzcf.zzaab.get()).longValue();
    }
}
