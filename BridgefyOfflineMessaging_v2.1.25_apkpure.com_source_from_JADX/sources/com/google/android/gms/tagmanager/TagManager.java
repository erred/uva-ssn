package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@VisibleForTesting
public class TagManager {
    private static TagManager zzbgq;
    private final DataLayer zzazp;
    private final zzal zzber;
    private final zza zzbgn;
    private final zzfm zzbgo;
    private final ConcurrentMap<String, zzv> zzbgp;
    private final Context zzri;

    @VisibleForTesting
    public interface zza {
        zzy zza(Context context, TagManager tagManager, Looper looper, String str, int i, zzal zzal);
    }

    @VisibleForTesting
    private TagManager(Context context, zza zza2, DataLayer dataLayer, zzfm zzfm) {
        if (context != null) {
            this.zzri = context.getApplicationContext();
            this.zzbgo = zzfm;
            this.zzbgn = zza2;
            this.zzbgp = new ConcurrentHashMap();
            this.zzazp = dataLayer;
            this.zzazp.zza((zzb) new zzga(this));
            this.zzazp.zza((zzb) new zzg(this.zzri));
            this.zzber = new zzal();
            this.zzri.registerComponentCallbacks(new zzgc(this));
            zza.zzo(this.zzri);
            return;
        }
        throw new NullPointerException("context cannot be null");
    }

    public static TagManager getInstance(Context context) {
        TagManager tagManager;
        synchronized (TagManager.class) {
            if (zzbgq == null) {
                if (context != null) {
                    zzbgq = new TagManager(context, new zzgb(), new DataLayer(new zzat(context)), zzfn.zzqe());
                } else {
                    zzdi.m8600e("TagManager.getInstance requires non-null context.");
                    throw new NullPointerException();
                }
            }
            tagManager = zzbgq;
        }
        return tagManager;
    }

    public DataLayer getDataLayer() {
        return this.zzazp;
    }

    public PendingResult<ContainerHolder> loadContainerDefaultOnly(String str, int i) {
        zzy zza2 = this.zzbgn.zza(this.zzri, this, null, str, i, this.zzber);
        zza2.zznt();
        return zza2;
    }

    public PendingResult<ContainerHolder> loadContainerDefaultOnly(String str, int i, Handler handler) {
        zzy zza2 = this.zzbgn.zza(this.zzri, this, handler.getLooper(), str, i, this.zzber);
        zza2.zznt();
        return zza2;
    }

    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String str, int i) {
        zzy zza2 = this.zzbgn.zza(this.zzri, this, null, str, i, this.zzber);
        zza2.zznu();
        return zza2;
    }

    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String str, int i, Handler handler) {
        zzy zza2 = this.zzbgn.zza(this.zzri, this, handler.getLooper(), str, i, this.zzber);
        zza2.zznu();
        return zza2;
    }

    public PendingResult<ContainerHolder> loadContainerPreferFresh(String str, int i) {
        zzy zza2 = this.zzbgn.zza(this.zzri, this, null, str, i, this.zzber);
        zza2.zznv();
        return zza2;
    }

    public PendingResult<ContainerHolder> loadContainerPreferFresh(String str, int i, Handler handler) {
        zzy zza2 = this.zzbgn.zza(this.zzri, this, handler.getLooper(), str, i, this.zzber);
        zza2.zznv();
        return zza2;
    }

    public void dispatch() {
        this.zzbgo.dispatch();
    }

    public void setVerboseLoggingEnabled(boolean z) {
        zzdi.setLogLevel(z ? 2 : 5);
    }

    /* access modifiers changed from: 0000 */
    public final synchronized boolean zzb(Uri uri) {
        zzeh zzpm = zzeh.zzpm();
        if (!zzpm.zzb(uri)) {
            return false;
        }
        String containerId = zzpm.getContainerId();
        switch (zzgd.zzbgs[zzpm.zzpn().ordinal()]) {
            case 1:
                zzv zzv = (zzv) this.zzbgp.get(containerId);
                if (zzv != null) {
                    zzv.zzdf(null);
                    zzv.refresh();
                    break;
                }
                break;
            case 2:
            case 3:
                for (String str : this.zzbgp.keySet()) {
                    zzv zzv2 = (zzv) this.zzbgp.get(str);
                    if (str.equals(containerId)) {
                        zzv2.zzdf(zzpm.zzpo());
                        zzv2.refresh();
                    } else if (zzv2.zznq() != null) {
                        zzv2.zzdf(null);
                        zzv2.refresh();
                    }
                }
                break;
        }
        return true;
    }

    @VisibleForTesting
    public final int zza(zzv zzv) {
        this.zzbgp.put(zzv.getContainerId(), zzv);
        return this.zzbgp.size();
    }

    @VisibleForTesting
    public final boolean zzb(zzv zzv) {
        return this.zzbgp.remove(zzv.getContainerId()) != null;
    }

    /* access modifiers changed from: private */
    public final void zzeb(String str) {
        for (zzv zzde : this.zzbgp.values()) {
            zzde.zzde(str);
        }
    }
}
