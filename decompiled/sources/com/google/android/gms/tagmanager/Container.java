package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzl;
import com.google.android.gms.internal.measurement.zzn;
import com.google.android.gms.internal.measurement.zzo;
import com.google.android.gms.internal.measurement.zzp;
import com.google.android.gms.internal.measurement.zzrg;
import com.google.android.gms.internal.measurement.zzrk;
import com.google.android.gms.internal.measurement.zzro;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@VisibleForTesting
public class Container {
    private final String zzazo;
    private final DataLayer zzazp;
    private zzfb zzazq;
    private Map<String, FunctionCallMacroCallback> zzazr = new HashMap();
    private Map<String, FunctionCallTagCallback> zzazs = new HashMap();
    private volatile long zzazt;
    private volatile String zzazu = "";
    private final Context zzri;

    public interface FunctionCallMacroCallback {
        Object getValue(String str, Map<String, Object> map);
    }

    public interface FunctionCallTagCallback {
        void execute(String str, Map<String, Object> map);
    }

    class zza implements zzan {
        private zza() {
        }

        public final Object zza(String str, Map<String, Object> map) {
            FunctionCallMacroCallback zzdc = Container.this.zzdc(str);
            if (zzdc == null) {
                return null;
            }
            return zzdc.getValue(str, map);
        }
    }

    class zzb implements zzan {
        private zzb() {
        }

        public final Object zza(String str, Map<String, Object> map) {
            FunctionCallTagCallback zzdd = Container.this.zzdd(str);
            if (zzdd != null) {
                zzdd.execute(str, map);
            }
            return zzgj.zzqp();
        }
    }

    Container(Context context, DataLayer dataLayer, String str, long j, zzrk zzrk) {
        this.zzri = context;
        this.zzazp = dataLayer;
        this.zzazo = str;
        this.zzazt = 0;
        zza(zzrk);
    }

    Container(Context context, DataLayer dataLayer, String str, long j, zzo zzo) {
        this.zzri = context;
        this.zzazp = dataLayer;
        this.zzazo = str;
        this.zzazt = j;
        zzl zzl = zzo.zzqg;
        if (zzl != null) {
            try {
                zza(zzrg.zza(zzl));
            } catch (zzro e) {
                String valueOf = String.valueOf(zzl);
                String zzro = e.toString();
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 46 + String.valueOf(zzro).length());
                sb.append("Not loading resource: ");
                sb.append(valueOf);
                sb.append(" because it is invalid: ");
                sb.append(zzro);
                zzdi.m8600e(sb.toString());
            }
            if (zzo.zzqf != null) {
                zzn[] zznArr = zzo.zzqf;
                ArrayList arrayList = new ArrayList();
                for (zzn add : zznArr) {
                    arrayList.add(add);
                }
                zznp().zzg(arrayList);
                return;
            }
            return;
        }
        throw new NullPointerException();
    }

    public String getContainerId() {
        return this.zzazo;
    }

    public boolean getBoolean(String str) {
        zzfb zznp = zznp();
        if (zznp == null) {
            zzdi.m8600e("getBoolean called for closed container.");
            return zzgj.zzqn().booleanValue();
        }
        try {
            return zzgj.zzg((zzp) zznp.zzdz(str).getObject()).booleanValue();
        } catch (Exception e) {
            String message = e.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 66);
            sb.append("Calling getBoolean() threw an exception: ");
            sb.append(message);
            sb.append(" Returning default value.");
            zzdi.m8600e(sb.toString());
            return zzgj.zzqn().booleanValue();
        }
    }

    public double getDouble(String str) {
        zzfb zznp = zznp();
        if (zznp == null) {
            zzdi.m8600e("getDouble called for closed container.");
            return zzgj.zzqm().doubleValue();
        }
        try {
            return zzgj.zzf((zzp) zznp.zzdz(str).getObject()).doubleValue();
        } catch (Exception e) {
            String message = e.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 65);
            sb.append("Calling getDouble() threw an exception: ");
            sb.append(message);
            sb.append(" Returning default value.");
            zzdi.m8600e(sb.toString());
            return zzgj.zzqm().doubleValue();
        }
    }

    public long getLong(String str) {
        zzfb zznp = zznp();
        if (zznp == null) {
            zzdi.m8600e("getLong called for closed container.");
            return zzgj.zzql().longValue();
        }
        try {
            return zzgj.zze((zzp) zznp.zzdz(str).getObject()).longValue();
        } catch (Exception e) {
            String message = e.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 63);
            sb.append("Calling getLong() threw an exception: ");
            sb.append(message);
            sb.append(" Returning default value.");
            zzdi.m8600e(sb.toString());
            return zzgj.zzql().longValue();
        }
    }

    public String getString(String str) {
        zzfb zznp = zznp();
        if (zznp == null) {
            zzdi.m8600e("getString called for closed container.");
            return zzgj.zzqp();
        }
        try {
            return zzgj.zzc((zzp) zznp.zzdz(str).getObject());
        } catch (Exception e) {
            String message = e.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 65);
            sb.append("Calling getString() threw an exception: ");
            sb.append(message);
            sb.append(" Returning default value.");
            zzdi.m8600e(sb.toString());
            return zzgj.zzqp();
        }
    }

    public long getLastRefreshTime() {
        return this.zzazt;
    }

    public boolean isDefault() {
        return getLastRefreshTime() == 0;
    }

    public void registerFunctionCallMacroCallback(String str, FunctionCallMacroCallback functionCallMacroCallback) {
        if (functionCallMacroCallback != null) {
            synchronized (this.zzazr) {
                this.zzazr.put(str, functionCallMacroCallback);
            }
            return;
        }
        throw new NullPointerException("Macro handler must be non-null");
    }

    public void unregisterFunctionCallMacroCallback(String str) {
        synchronized (this.zzazr) {
            this.zzazr.remove(str);
        }
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    public final FunctionCallMacroCallback zzdc(String str) {
        FunctionCallMacroCallback functionCallMacroCallback;
        synchronized (this.zzazr) {
            functionCallMacroCallback = (FunctionCallMacroCallback) this.zzazr.get(str);
        }
        return functionCallMacroCallback;
    }

    public void registerFunctionCallTagCallback(String str, FunctionCallTagCallback functionCallTagCallback) {
        if (functionCallTagCallback != null) {
            synchronized (this.zzazs) {
                this.zzazs.put(str, functionCallTagCallback);
            }
            return;
        }
        throw new NullPointerException("Tag callback must be non-null");
    }

    public void unregisterFunctionCallTagCallback(String str) {
        synchronized (this.zzazs) {
            this.zzazs.remove(str);
        }
    }

    @VisibleForTesting
    public final FunctionCallTagCallback zzdd(String str) {
        FunctionCallTagCallback functionCallTagCallback;
        synchronized (this.zzazs) {
            functionCallTagCallback = (FunctionCallTagCallback) this.zzazs.get(str);
        }
        return functionCallTagCallback;
    }

    @VisibleForTesting
    public final void zzde(String str) {
        zznp().zzde(str);
    }

    @VisibleForTesting
    public final String zzno() {
        return this.zzazu;
    }

    private final void zza(zzrk zzrk) {
        this.zzazu = zzrk.getVersion();
        String str = this.zzazu;
        zzeh.zzpm().zzpn().equals(zza.CONTAINER_DEBUG);
        zzrk zzrk2 = zzrk;
        zzfb zzfb = new zzfb(this.zzri, zzrk2, this.zzazp, new zza(), new zzb(), new zzdq());
        zza(zzfb);
        if (getBoolean("_gtm.loadEventEnabled")) {
            this.zzazp.pushEvent("gtm.load", DataLayer.mapOf("gtm.id", this.zzazo));
        }
    }

    private final synchronized void zza(zzfb zzfb) {
        this.zzazq = zzfb;
    }

    private final synchronized zzfb zznp() {
        return this.zzazq;
    }

    /* access modifiers changed from: 0000 */
    public final void release() {
        this.zzazq = null;
    }
}
