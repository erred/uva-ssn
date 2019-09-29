package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.customview.p073b.C1024a;
import androidx.p052b.C0712a;
import com.bridgefy.sdk.framework.entities.BleHandshake;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzfp;
import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.internal.measurement.zzfu;
import com.google.android.gms.internal.measurement.zzfw;
import com.google.api.client.http.HttpStatusCodes;
import com.google.common.net.HttpHeaders;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.joda.time.DateTimeConstants;

public class zzfo implements zzct {
    private static volatile zzfo zzatg;
    private final zzbw zzada;
    private zzbq zzath;
    private zzaw zzati;
    private zzt zzatj;
    private zzbb zzatk;
    private zzfk zzatl;
    private zzm zzatm;
    private final zzfu zzatn;
    private zzdv zzato;
    private boolean zzatp;
    private boolean zzatq;
    @VisibleForTesting
    private long zzatr;
    private List<Runnable> zzats;
    private int zzatt;
    private int zzatu;
    private boolean zzatv;
    private boolean zzatw;
    private boolean zzatx;
    private FileLock zzaty;
    private FileChannel zzatz;
    private List<Long> zzaua;
    private List<Long> zzaub;
    private long zzauc;
    private boolean zzvz;

    class zza implements zzv {
        zzfw zzaug;
        List<Long> zzauh;
        List<zzft> zzaui;
        private long zzauj;

        private zza() {
        }

        public final void zzb(zzfw zzfw) {
            Preconditions.checkNotNull(zzfw);
            this.zzaug = zzfw;
        }

        public final boolean zza(long j, zzft zzft) {
            Preconditions.checkNotNull(zzft);
            if (this.zzaui == null) {
                this.zzaui = new ArrayList();
            }
            if (this.zzauh == null) {
                this.zzauh = new ArrayList();
            }
            if (this.zzaui.size() > 0 && zza((zzft) this.zzaui.get(0)) != zza(zzft)) {
                return false;
            }
            long zzvx = this.zzauj + ((long) zzft.zzvx());
            if (zzvx >= ((long) Math.max(0, ((Integer) zzai.zzajc.get()).intValue()))) {
                return false;
            }
            this.zzauj = zzvx;
            this.zzaui.add(zzft);
            this.zzauh.add(Long.valueOf(j));
            if (this.zzaui.size() >= Math.max(1, ((Integer) zzai.zzajd.get()).intValue())) {
                return false;
            }
            return true;
        }

        private static long zza(zzft zzft) {
            return ((zzft.zzaxb.longValue() / 1000) / 60) / 60;
        }

        /* synthetic */ zza(zzfo zzfo, zzfp zzfp) {
            this();
        }
    }

    public static zzfo zzn(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzatg == null) {
            synchronized (zzfo.class) {
                if (zzatg == null) {
                    zzatg = new zzfo(new zzft(context));
                }
            }
        }
        return zzatg;
    }

    private zzfo(zzft zzft) {
        this(zzft, null);
    }

    private zzfo(zzft zzft, zzbw zzbw) {
        this.zzvz = false;
        Preconditions.checkNotNull(zzft);
        this.zzada = zzbw.zza(zzft.zzri, (zzan) null);
        this.zzauc = -1;
        zzfu zzfu = new zzfu(this);
        zzfu.zzq();
        this.zzatn = zzfu;
        zzaw zzaw = new zzaw(this);
        zzaw.zzq();
        this.zzati = zzaw;
        zzbq zzbq = new zzbq(this);
        zzbq.zzq();
        this.zzath = zzbq;
        this.zzada.zzgs().zzc((Runnable) new zzfp(this, zzft));
    }

    /* access modifiers changed from: private */
    public final void zza(zzft zzft) {
        this.zzada.zzgs().zzaf();
        zzt zzt = new zzt(this);
        zzt.zzq();
        this.zzatj = zzt;
        this.zzada.zzgv().zza((zzs) this.zzath);
        zzm zzm = new zzm(this);
        zzm.zzq();
        this.zzatm = zzm;
        zzdv zzdv = new zzdv(this);
        zzdv.zzq();
        this.zzato = zzdv;
        zzfk zzfk = new zzfk(this);
        zzfk.zzq();
        this.zzatl = zzfk;
        this.zzatk = new zzbb(this);
        if (this.zzatt != this.zzatu) {
            this.zzada.zzgt().zzjg().zze("Not all upload components initialized", Integer.valueOf(this.zzatt), Integer.valueOf(this.zzatu));
        }
        this.zzvz = true;
    }

    /* access modifiers changed from: protected */
    public final void start() {
        this.zzada.zzgs().zzaf();
        zzjt().zzij();
        if (this.zzada.zzgu().zzana.get() == 0) {
            this.zzada.zzgu().zzana.set(this.zzada.zzbx().currentTimeMillis());
        }
        zzmb();
    }

    public final zzn zzgw() {
        return this.zzada.zzgw();
    }

    public final zzq zzgv() {
        return this.zzada.zzgv();
    }

    public final zzas zzgt() {
        return this.zzada.zzgt();
    }

    public final zzbr zzgs() {
        return this.zzada.zzgs();
    }

    private final zzbq zzls() {
        zza((zzfn) this.zzath);
        return this.zzath;
    }

    public final zzaw zzlt() {
        zza((zzfn) this.zzati);
        return this.zzati;
    }

    public final zzt zzjt() {
        zza((zzfn) this.zzatj);
        return this.zzatj;
    }

    private final zzbb zzlu() {
        if (this.zzatk != null) {
            return this.zzatk;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    private final zzfk zzlv() {
        zza((zzfn) this.zzatl);
        return this.zzatl;
    }

    public final zzm zzjs() {
        zza((zzfn) this.zzatm);
        return this.zzatm;
    }

    public final zzdv zzlw() {
        zza((zzfn) this.zzato);
        return this.zzato;
    }

    public final zzfu zzjr() {
        zza((zzfn) this.zzatn);
        return this.zzatn;
    }

    public final zzaq zzgq() {
        return this.zzada.zzgq();
    }

    public final Context getContext() {
        return this.zzada.getContext();
    }

    public final Clock zzbx() {
        return this.zzada.zzbx();
    }

    public final zzfy zzgr() {
        return this.zzada.zzgr();
    }

    private final void zzaf() {
        this.zzada.zzgs().zzaf();
    }

    /* access modifiers changed from: 0000 */
    public final void zzlx() {
        if (!this.zzvz) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    private static void zza(zzfn zzfn) {
        if (zzfn == null) {
            throw new IllegalStateException("Upload Component not created");
        } else if (!zzfn.isInitialized()) {
            String valueOf = String.valueOf(zzfn.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zze(zzk zzk) {
        zzaf();
        zzlx();
        Preconditions.checkNotEmpty(zzk.packageName);
        zzg(zzk);
    }

    private final long zzly() {
        long currentTimeMillis = this.zzada.zzbx().currentTimeMillis();
        zzbd zzgu = this.zzada.zzgu();
        zzgu.zzcl();
        zzgu.zzaf();
        long j = zzgu.zzane.get();
        if (j == 0) {
            j = 1 + ((long) zzgu.zzgr().zzmk().nextInt(DateTimeConstants.MILLIS_PER_DAY));
            zzgu.zzane.set(j);
        }
        return ((((currentTimeMillis + j) / 1000) / 60) / 60) / 24;
    }

    /* access modifiers changed from: 0000 */
    public final void zzd(zzag zzag, String str) {
        zzag zzag2 = zzag;
        String str2 = str;
        zzg zzbm = zzjt().zzbm(str2);
        if (zzbm == null || TextUtils.isEmpty(zzbm.zzak())) {
            this.zzada.zzgt().zzjn().zzg("No app data available; dropping event", str2);
            return;
        }
        Boolean zzc = zzc(zzbm);
        if (zzc == null) {
            if (!"_ui".equals(zzag2.name)) {
                this.zzada.zzgt().zzjj().zzg("Could not find package. appId", zzas.zzbw(str));
            }
        } else if (!zzc.booleanValue()) {
            this.zzada.zzgt().zzjg().zzg("App version does not match; dropping event. appId", zzas.zzbw(str));
            return;
        }
        zzk zzk = r2;
        zzg zzg = zzbm;
        zzk zzk2 = new zzk(str, zzbm.getGmpAppId(), zzbm.zzak(), zzbm.zzhf(), zzbm.zzhg(), zzbm.zzhh(), zzbm.zzhi(), (String) null, zzbm.isMeasurementEnabled(), false, zzg.getFirebaseInstanceId(), zzg.zzhv(), 0, 0, zzg.zzhw(), zzg.zzhx(), false, zzg.zzhb());
        zzc(zzag2, zzk);
    }

    /* access modifiers changed from: 0000 */
    public final void zzc(zzag zzag, zzk zzk) {
        List<zzo> list;
        List<zzo> list2;
        List<zzo> list3;
        zzag zzag2 = zzag;
        zzk zzk2 = zzk;
        Preconditions.checkNotNull(zzk);
        Preconditions.checkNotEmpty(zzk2.packageName);
        zzaf();
        zzlx();
        String str = zzk2.packageName;
        long j = zzag2.zzaig;
        if (zzjr().zze(zzag2, zzk2)) {
            if (!zzk2.zzafr) {
                zzg(zzk2);
                return;
            }
            zzjt().beginTransaction();
            try {
                zzt zzjt = zzjt();
                Preconditions.checkNotEmpty(str);
                zzjt.zzaf();
                zzjt.zzcl();
                int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                if (i < 0) {
                    zzjt.zzgt().zzjj().zze("Invalid time querying timed out conditional properties", zzas.zzbw(str), Long.valueOf(j));
                    list = Collections.emptyList();
                } else {
                    list = zzjt.zzb("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str, String.valueOf(j)});
                }
                for (zzo zzo : list) {
                    if (zzo != null) {
                        this.zzada.zzgt().zzjn().zzd("User property timed out", zzo.packageName, this.zzada.zzgq().zzbv(zzo.zzags.name), zzo.zzags.getValue());
                        if (zzo.zzagt != null) {
                            zzd(new zzag(zzo.zzagt, j), zzk2);
                        }
                        zzjt().zzk(str, zzo.zzags.name);
                    }
                }
                zzt zzjt2 = zzjt();
                Preconditions.checkNotEmpty(str);
                zzjt2.zzaf();
                zzjt2.zzcl();
                if (i < 0) {
                    zzjt2.zzgt().zzjj().zze("Invalid time querying expired conditional properties", zzas.zzbw(str), Long.valueOf(j));
                    list2 = Collections.emptyList();
                } else {
                    list2 = zzjt2.zzb("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str, String.valueOf(j)});
                }
                ArrayList arrayList = new ArrayList(list2.size());
                for (zzo zzo2 : list2) {
                    if (zzo2 != null) {
                        this.zzada.zzgt().zzjn().zzd("User property expired", zzo2.packageName, this.zzada.zzgq().zzbv(zzo2.zzags.name), zzo2.zzags.getValue());
                        zzjt().zzh(str, zzo2.zzags.name);
                        if (zzo2.zzagv != null) {
                            arrayList.add(zzo2.zzagv);
                        }
                        zzjt().zzk(str, zzo2.zzags.name);
                    }
                }
                ArrayList arrayList2 = arrayList;
                int size = arrayList2.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList2.get(i2);
                    i2++;
                    zzd(new zzag((zzag) obj, j), zzk2);
                }
                zzt zzjt3 = zzjt();
                String str2 = zzag2.name;
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotEmpty(str2);
                zzjt3.zzaf();
                zzjt3.zzcl();
                if (i < 0) {
                    zzjt3.zzgt().zzjj().zzd("Invalid time querying triggered conditional properties", zzas.zzbw(str), zzjt3.zzgq().zzbt(str2), Long.valueOf(j));
                    list3 = Collections.emptyList();
                } else {
                    list3 = zzjt3.zzb("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str, str2, String.valueOf(j)});
                }
                ArrayList arrayList3 = new ArrayList(list3.size());
                for (zzo zzo3 : list3) {
                    if (zzo3 != null) {
                        zzfv zzfv = zzo3.zzags;
                        zzfx zzfx = r4;
                        zzfx zzfx2 = new zzfx(zzo3.packageName, zzo3.origin, zzfv.name, j, zzfv.getValue());
                        if (zzjt().zza(zzfx)) {
                            this.zzada.zzgt().zzjn().zzd("User property triggered", zzo3.packageName, this.zzada.zzgq().zzbv(zzfx.name), zzfx.value);
                        } else {
                            this.zzada.zzgt().zzjg().zzd("Too many active user properties, ignoring", zzas.zzbw(zzo3.packageName), this.zzada.zzgq().zzbv(zzfx.name), zzfx.value);
                        }
                        if (zzo3.zzagu != null) {
                            arrayList3.add(zzo3.zzagu);
                        }
                        zzo3.zzags = new zzfv(zzfx);
                        zzo3.active = true;
                        zzjt().zza(zzo3);
                    }
                }
                zzd(zzag, zzk);
                ArrayList arrayList4 = arrayList3;
                int size2 = arrayList4.size();
                int i3 = 0;
                while (i3 < size2) {
                    Object obj2 = arrayList4.get(i3);
                    i3++;
                    zzd(new zzag((zzag) obj2, j), zzk2);
                }
                zzjt().setTransactionSuccessful();
            } finally {
                zzjt().endTransaction();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:186:0x073d, code lost:
        r2 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0256 A[Catch:{ SQLiteException -> 0x0223, all -> 0x07f0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0289 A[Catch:{ SQLiteException -> 0x0223, all -> 0x07f0 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzd(com.google.android.gms.measurement.internal.zzag r26, com.google.android.gms.measurement.internal.zzk r27) {
        /*
            r25 = this;
            r1 = r25
            r2 = r26
            r3 = r27
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r27)
            java.lang.String r0 = r3.packageName
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r0)
            long r4 = java.lang.System.nanoTime()
            r25.zzaf()
            r25.zzlx()
            java.lang.String r15 = r3.packageName
            com.google.android.gms.measurement.internal.zzfu r0 = r25.zzjr()
            boolean r0 = r0.zze(r2, r3)
            if (r0 != 0) goto L_0x0025
            return
        L_0x0025:
            boolean r0 = r3.zzafr
            if (r0 != 0) goto L_0x002d
            r1.zzg(r3)
            return
        L_0x002d:
            com.google.android.gms.measurement.internal.zzbq r0 = r25.zzls()
            java.lang.String r6 = r2.name
            boolean r0 = r0.zzo(r15, r6)
            r14 = 0
            r21 = 1
            if (r0 == 0) goto L_0x00d7
            com.google.android.gms.measurement.internal.zzbw r0 = r1.zzada
            com.google.android.gms.measurement.internal.zzas r0 = r0.zzgt()
            com.google.android.gms.measurement.internal.zzau r0 = r0.zzjj()
            java.lang.String r3 = "Dropping blacklisted event. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzas.zzbw(r15)
            com.google.android.gms.measurement.internal.zzbw r5 = r1.zzada
            com.google.android.gms.measurement.internal.zzaq r5 = r5.zzgq()
            java.lang.String r6 = r2.name
            java.lang.String r5 = r5.zzbt(r6)
            r0.zze(r3, r4, r5)
            com.google.android.gms.measurement.internal.zzbq r0 = r25.zzls()
            boolean r0 = r0.zzcl(r15)
            if (r0 != 0) goto L_0x006f
            com.google.android.gms.measurement.internal.zzbq r0 = r25.zzls()
            boolean r0 = r0.zzcm(r15)
            if (r0 == 0) goto L_0x0070
        L_0x006f:
            r14 = 1
        L_0x0070:
            if (r14 != 0) goto L_0x008d
            java.lang.String r0 = "_err"
            java.lang.String r3 = r2.name
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x008d
            com.google.android.gms.measurement.internal.zzbw r0 = r1.zzada
            com.google.android.gms.measurement.internal.zzfy r6 = r0.zzgr()
            r8 = 11
            java.lang.String r9 = "_ev"
            java.lang.String r10 = r2.name
            r11 = 0
            r7 = r15
            r6.zza(r7, r8, r9, r10, r11)
        L_0x008d:
            if (r14 == 0) goto L_0x00d6
            com.google.android.gms.measurement.internal.zzt r0 = r25.zzjt()
            com.google.android.gms.measurement.internal.zzg r0 = r0.zzbm(r15)
            if (r0 == 0) goto L_0x00d6
            long r2 = r0.zzhl()
            long r4 = r0.zzhk()
            long r2 = java.lang.Math.max(r2, r4)
            com.google.android.gms.measurement.internal.zzbw r4 = r1.zzada
            com.google.android.gms.common.util.Clock r4 = r4.zzbx()
            long r4 = r4.currentTimeMillis()
            long r4 = r4 - r2
            long r2 = java.lang.Math.abs(r4)
            com.google.android.gms.measurement.internal.zzai$zza<java.lang.Long> r4 = com.google.android.gms.measurement.internal.zzai.zzajt
            java.lang.Object r4 = r4.get()
            java.lang.Long r4 = (java.lang.Long) r4
            long r4 = r4.longValue()
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x00d6
            com.google.android.gms.measurement.internal.zzbw r2 = r1.zzada
            com.google.android.gms.measurement.internal.zzas r2 = r2.zzgt()
            com.google.android.gms.measurement.internal.zzau r2 = r2.zzjn()
            java.lang.String r3 = "Fetching config for blacklisted app"
            r2.zzby(r3)
            r1.zzb(r0)
        L_0x00d6:
            return
        L_0x00d7:
            com.google.android.gms.measurement.internal.zzbw r0 = r1.zzada
            com.google.android.gms.measurement.internal.zzas r0 = r0.zzgt()
            r13 = 2
            boolean r0 = r0.isLoggable(r13)
            if (r0 == 0) goto L_0x00fd
            com.google.android.gms.measurement.internal.zzbw r0 = r1.zzada
            com.google.android.gms.measurement.internal.zzas r0 = r0.zzgt()
            com.google.android.gms.measurement.internal.zzau r0 = r0.zzjo()
            java.lang.String r6 = "Logging event"
            com.google.android.gms.measurement.internal.zzbw r7 = r1.zzada
            com.google.android.gms.measurement.internal.zzaq r7 = r7.zzgq()
            java.lang.String r7 = r7.zzb(r2)
            r0.zzg(r6, r7)
        L_0x00fd:
            com.google.android.gms.measurement.internal.zzt r0 = r25.zzjt()
            r0.beginTransaction()
            r1.zzg(r3)     // Catch:{ all -> 0x07f0 }
            java.lang.String r0 = "_iap"
            java.lang.String r6 = r2.name     // Catch:{ all -> 0x07f0 }
            boolean r0 = r0.equals(r6)     // Catch:{ all -> 0x07f0 }
            if (r0 != 0) goto L_0x011b
            java.lang.String r0 = "ecommerce_purchase"
            java.lang.String r6 = r2.name     // Catch:{ all -> 0x07f0 }
            boolean r0 = r0.equals(r6)     // Catch:{ all -> 0x07f0 }
            if (r0 == 0) goto L_0x0298
        L_0x011b:
            com.google.android.gms.measurement.internal.zzad r0 = r2.zzahu     // Catch:{ all -> 0x07f0 }
            java.lang.String r6 = "currency"
            java.lang.String r0 = r0.getString(r6)     // Catch:{ all -> 0x07f0 }
            java.lang.String r6 = "ecommerce_purchase"
            java.lang.String r7 = r2.name     // Catch:{ all -> 0x07f0 }
            boolean r6 = r6.equals(r7)     // Catch:{ all -> 0x07f0 }
            if (r6 == 0) goto L_0x0180
            com.google.android.gms.measurement.internal.zzad r6 = r2.zzahu     // Catch:{ all -> 0x07f0 }
            java.lang.String r7 = "value"
            java.lang.Double r6 = r6.zzbr(r7)     // Catch:{ all -> 0x07f0 }
            double r6 = r6.doubleValue()     // Catch:{ all -> 0x07f0 }
            r8 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r6 = r6 * r8
            r10 = 0
            int r10 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r10 != 0) goto L_0x0155
            com.google.android.gms.measurement.internal.zzad r6 = r2.zzahu     // Catch:{ all -> 0x07f0 }
            java.lang.String r7 = "value"
            java.lang.Long r6 = r6.getLong(r7)     // Catch:{ all -> 0x07f0 }
            long r6 = r6.longValue()     // Catch:{ all -> 0x07f0 }
            double r6 = (double) r6     // Catch:{ all -> 0x07f0 }
            double r6 = r6 * r8
        L_0x0155:
            r8 = 4890909195324358656(0x43e0000000000000, double:9.223372036854776E18)
            int r8 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r8 > 0) goto L_0x0166
            r8 = -4332462841530417152(0xc3e0000000000000, double:-9.223372036854776E18)
            int r8 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r8 < 0) goto L_0x0166
            long r6 = java.lang.Math.round(r6)     // Catch:{ all -> 0x07f0 }
            goto L_0x018c
        L_0x0166:
            com.google.android.gms.measurement.internal.zzbw r0 = r1.zzada     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzas r0 = r0.zzgt()     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzau r0 = r0.zzjj()     // Catch:{ all -> 0x07f0 }
            java.lang.String r8 = "Data lost. Currency value is too big. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzas.zzbw(r15)     // Catch:{ all -> 0x07f0 }
            java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ all -> 0x07f0 }
            r0.zze(r8, r9, r6)     // Catch:{ all -> 0x07f0 }
            r0 = 0
            goto L_0x0287
        L_0x0180:
            com.google.android.gms.measurement.internal.zzad r6 = r2.zzahu     // Catch:{ all -> 0x07f0 }
            java.lang.String r7 = "value"
            java.lang.Long r6 = r6.getLong(r7)     // Catch:{ all -> 0x07f0 }
            long r6 = r6.longValue()     // Catch:{ all -> 0x07f0 }
        L_0x018c:
            boolean r8 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x07f0 }
            if (r8 != 0) goto L_0x0286
            java.util.Locale r8 = java.util.Locale.US     // Catch:{ all -> 0x07f0 }
            java.lang.String r0 = r0.toUpperCase(r8)     // Catch:{ all -> 0x07f0 }
            java.lang.String r8 = "[A-Z]{3}"
            boolean r8 = r0.matches(r8)     // Catch:{ all -> 0x07f0 }
            if (r8 == 0) goto L_0x0286
            java.lang.String r8 = "_ltv_"
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x07f0 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x07f0 }
            int r9 = r0.length()     // Catch:{ all -> 0x07f0 }
            if (r9 == 0) goto L_0x01b6
            java.lang.String r0 = r8.concat(r0)     // Catch:{ all -> 0x07f0 }
        L_0x01b4:
            r9 = r0
            goto L_0x01bc
        L_0x01b6:
            java.lang.String r0 = new java.lang.String     // Catch:{ all -> 0x07f0 }
            r0.<init>(r8)     // Catch:{ all -> 0x07f0 }
            goto L_0x01b4
        L_0x01bc:
            com.google.android.gms.measurement.internal.zzt r0 = r25.zzjt()     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzfx r0 = r0.zzi(r15, r9)     // Catch:{ all -> 0x07f0 }
            if (r0 == 0) goto L_0x01f1
            java.lang.Object r8 = r0.value     // Catch:{ all -> 0x07f0 }
            boolean r8 = r8 instanceof java.lang.Long     // Catch:{ all -> 0x07f0 }
            if (r8 != 0) goto L_0x01cd
            goto L_0x01f1
        L_0x01cd:
            java.lang.Object r0 = r0.value     // Catch:{ all -> 0x07f0 }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ all -> 0x07f0 }
            long r10 = r0.longValue()     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzfx r0 = new com.google.android.gms.measurement.internal.zzfx     // Catch:{ all -> 0x07f0 }
            java.lang.String r8 = r2.origin     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzbw r12 = r1.zzada     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.common.util.Clock r12 = r12.zzbx()     // Catch:{ all -> 0x07f0 }
            long r16 = r12.currentTimeMillis()     // Catch:{ all -> 0x07f0 }
            r12 = 0
            long r10 = r10 + r6
            java.lang.Long r12 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x07f0 }
            r6 = r0
            r7 = r15
            r10 = r16
            r6.<init>(r7, r8, r9, r10, r12)     // Catch:{ all -> 0x07f0 }
            goto L_0x024c
        L_0x01f1:
            com.google.android.gms.measurement.internal.zzt r8 = r25.zzjt()     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzbw r0 = r1.zzada     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzq r0 = r0.zzgv()     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzai$zza<java.lang.Integer> r10 = com.google.android.gms.measurement.internal.zzai.zzajy     // Catch:{ all -> 0x07f0 }
            int r0 = r0.zzb(r15, r10)     // Catch:{ all -> 0x07f0 }
            int r0 = r0 + -1
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r15)     // Catch:{ all -> 0x07f0 }
            r8.zzaf()     // Catch:{ all -> 0x07f0 }
            r8.zzcl()     // Catch:{ all -> 0x07f0 }
            android.database.sqlite.SQLiteDatabase r10 = r8.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0223 }
            java.lang.String r11 = "delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);"
            r12 = 3
            java.lang.String[] r12 = new java.lang.String[r12]     // Catch:{ SQLiteException -> 0x0223 }
            r12[r14] = r15     // Catch:{ SQLiteException -> 0x0223 }
            r12[r21] = r15     // Catch:{ SQLiteException -> 0x0223 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ SQLiteException -> 0x0223 }
            r12[r13] = r0     // Catch:{ SQLiteException -> 0x0223 }
            r10.execSQL(r11, r12)     // Catch:{ SQLiteException -> 0x0223 }
            goto L_0x0235
        L_0x0223:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzas r8 = r8.zzgt()     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzau r8 = r8.zzjg()     // Catch:{ all -> 0x07f0 }
            java.lang.String r10 = "Error pruning currencies. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzas.zzbw(r15)     // Catch:{ all -> 0x07f0 }
            r8.zze(r10, r11, r0)     // Catch:{ all -> 0x07f0 }
        L_0x0235:
            com.google.android.gms.measurement.internal.zzfx r0 = new com.google.android.gms.measurement.internal.zzfx     // Catch:{ all -> 0x07f0 }
            java.lang.String r8 = r2.origin     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzbw r10 = r1.zzada     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.common.util.Clock r10 = r10.zzbx()     // Catch:{ all -> 0x07f0 }
            long r10 = r10.currentTimeMillis()     // Catch:{ all -> 0x07f0 }
            java.lang.Long r12 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x07f0 }
            r6 = r0
            r7 = r15
            r6.<init>(r7, r8, r9, r10, r12)     // Catch:{ all -> 0x07f0 }
        L_0x024c:
            com.google.android.gms.measurement.internal.zzt r6 = r25.zzjt()     // Catch:{ all -> 0x07f0 }
            boolean r6 = r6.zza(r0)     // Catch:{ all -> 0x07f0 }
            if (r6 != 0) goto L_0x0286
            com.google.android.gms.measurement.internal.zzbw r6 = r1.zzada     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzas r6 = r6.zzgt()     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzau r6 = r6.zzjg()     // Catch:{ all -> 0x07f0 }
            java.lang.String r7 = "Too many unique user properties are set. Ignoring user property. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzas.zzbw(r15)     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzbw r9 = r1.zzada     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzaq r9 = r9.zzgq()     // Catch:{ all -> 0x07f0 }
            java.lang.String r10 = r0.name     // Catch:{ all -> 0x07f0 }
            java.lang.String r9 = r9.zzbv(r10)     // Catch:{ all -> 0x07f0 }
            java.lang.Object r0 = r0.value     // Catch:{ all -> 0x07f0 }
            r6.zzd(r7, r8, r9, r0)     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzbw r0 = r1.zzada     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzfy r6 = r0.zzgr()     // Catch:{ all -> 0x07f0 }
            r8 = 9
            r9 = 0
            r10 = 0
            r11 = 0
            r7 = r15
            r6.zza(r7, r8, r9, r10, r11)     // Catch:{ all -> 0x07f0 }
        L_0x0286:
            r0 = 1
        L_0x0287:
            if (r0 != 0) goto L_0x0298
            com.google.android.gms.measurement.internal.zzt r0 = r25.zzjt()     // Catch:{ all -> 0x07f0 }
            r0.setTransactionSuccessful()     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzt r0 = r25.zzjt()
            r0.endTransaction()
            return
        L_0x0298:
            java.lang.String r0 = r2.name     // Catch:{ all -> 0x07f0 }
            boolean r0 = com.google.android.gms.measurement.internal.zzfy.zzct(r0)     // Catch:{ all -> 0x07f0 }
            java.lang.String r6 = "_err"
            java.lang.String r7 = r2.name     // Catch:{ all -> 0x07f0 }
            boolean r16 = r6.equals(r7)     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzt r6 = r25.zzjt()     // Catch:{ all -> 0x07f0 }
            long r7 = r25.zzly()     // Catch:{ all -> 0x07f0 }
            r10 = 1
            r12 = 0
            r17 = 0
            r9 = r15
            r11 = r0
            r13 = r16
            r22 = r4
            r4 = 0
            r14 = r17
            com.google.android.gms.measurement.internal.zzu r5 = r6.zza(r7, r9, r10, r11, r12, r13, r14)     // Catch:{ all -> 0x07f0 }
            long r6 = r5.zzahi     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzai$zza<java.lang.Integer> r8 = com.google.android.gms.measurement.internal.zzai.zzaje     // Catch:{ all -> 0x07f0 }
            java.lang.Object r8 = r8.get()     // Catch:{ all -> 0x07f0 }
            java.lang.Integer r8 = (java.lang.Integer) r8     // Catch:{ all -> 0x07f0 }
            int r8 = r8.intValue()     // Catch:{ all -> 0x07f0 }
            long r8 = (long) r8     // Catch:{ all -> 0x07f0 }
            long r6 = r6 - r8
            r8 = 1000(0x3e8, double:4.94E-321)
            r10 = 1
            r13 = 0
            int r12 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
            if (r12 <= 0) goto L_0x0306
            long r6 = r6 % r8
            int r0 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r0 != 0) goto L_0x02f7
            com.google.android.gms.measurement.internal.zzbw r0 = r1.zzada     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzas r0 = r0.zzgt()     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzau r0 = r0.zzjg()     // Catch:{ all -> 0x07f0 }
            java.lang.String r2 = "Data loss. Too many events logged. appId, count"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzas.zzbw(r15)     // Catch:{ all -> 0x07f0 }
            long r4 = r5.zzahi     // Catch:{ all -> 0x07f0 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x07f0 }
            r0.zze(r2, r3, r4)     // Catch:{ all -> 0x07f0 }
        L_0x02f7:
            com.google.android.gms.measurement.internal.zzt r0 = r25.zzjt()     // Catch:{ all -> 0x07f0 }
            r0.setTransactionSuccessful()     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzt r0 = r25.zzjt()
            r0.endTransaction()
            return
        L_0x0306:
            if (r0 == 0) goto L_0x0360
            long r6 = r5.zzahh     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzai$zza<java.lang.Integer> r12 = com.google.android.gms.measurement.internal.zzai.zzajg     // Catch:{ all -> 0x07f0 }
            java.lang.Object r12 = r12.get()     // Catch:{ all -> 0x07f0 }
            java.lang.Integer r12 = (java.lang.Integer) r12     // Catch:{ all -> 0x07f0 }
            int r12 = r12.intValue()     // Catch:{ all -> 0x07f0 }
            r24 = r5
            long r4 = (long) r12     // Catch:{ all -> 0x07f0 }
            long r6 = r6 - r4
            int r4 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
            if (r4 <= 0) goto L_0x035e
            long r6 = r6 % r8
            int r0 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r0 != 0) goto L_0x033e
            com.google.android.gms.measurement.internal.zzbw r0 = r1.zzada     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzas r0 = r0.zzgt()     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzau r0 = r0.zzjg()     // Catch:{ all -> 0x07f0 }
            java.lang.String r3 = "Data loss. Too many public events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzas.zzbw(r15)     // Catch:{ all -> 0x07f0 }
            r5 = r24
            long r5 = r5.zzahh     // Catch:{ all -> 0x07f0 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x07f0 }
            r0.zze(r3, r4, r5)     // Catch:{ all -> 0x07f0 }
        L_0x033e:
            com.google.android.gms.measurement.internal.zzbw r0 = r1.zzada     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzfy r6 = r0.zzgr()     // Catch:{ all -> 0x07f0 }
            r8 = 16
            java.lang.String r9 = "_ev"
            java.lang.String r10 = r2.name     // Catch:{ all -> 0x07f0 }
            r11 = 0
            r7 = r15
            r6.zza(r7, r8, r9, r10, r11)     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzt r0 = r25.zzjt()     // Catch:{ all -> 0x07f0 }
            r0.setTransactionSuccessful()     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzt r0 = r25.zzjt()
            r0.endTransaction()
            return
        L_0x035e:
            r5 = r24
        L_0x0360:
            if (r16 == 0) goto L_0x03b0
            long r6 = r5.zzahk     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzbw r4 = r1.zzada     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzq r4 = r4.zzgv()     // Catch:{ all -> 0x07f0 }
            java.lang.String r8 = r3.packageName     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzai$zza<java.lang.Integer> r9 = com.google.android.gms.measurement.internal.zzai.zzajf     // Catch:{ all -> 0x07f0 }
            int r4 = r4.zzb(r8, r9)     // Catch:{ all -> 0x07f0 }
            r8 = 1000000(0xf4240, float:1.401298E-39)
            int r4 = java.lang.Math.min(r8, r4)     // Catch:{ all -> 0x07f0 }
            r12 = 0
            int r4 = java.lang.Math.max(r12, r4)     // Catch:{ all -> 0x07f0 }
            long r8 = (long) r4     // Catch:{ all -> 0x07f0 }
            long r6 = r6 - r8
            int r4 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
            if (r4 <= 0) goto L_0x03b1
            int r0 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r0 != 0) goto L_0x03a1
            com.google.android.gms.measurement.internal.zzbw r0 = r1.zzada     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzas r0 = r0.zzgt()     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzau r0 = r0.zzjg()     // Catch:{ all -> 0x07f0 }
            java.lang.String r2 = "Too many error events logged. appId, count"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzas.zzbw(r15)     // Catch:{ all -> 0x07f0 }
            long r4 = r5.zzahk     // Catch:{ all -> 0x07f0 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x07f0 }
            r0.zze(r2, r3, r4)     // Catch:{ all -> 0x07f0 }
        L_0x03a1:
            com.google.android.gms.measurement.internal.zzt r0 = r25.zzjt()     // Catch:{ all -> 0x07f0 }
            r0.setTransactionSuccessful()     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzt r0 = r25.zzjt()
            r0.endTransaction()
            return
        L_0x03b0:
            r12 = 0
        L_0x03b1:
            com.google.android.gms.measurement.internal.zzad r4 = r2.zzahu     // Catch:{ all -> 0x07f0 }
            android.os.Bundle r4 = r4.zziy()     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzbw r5 = r1.zzada     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzfy r5 = r5.zzgr()     // Catch:{ all -> 0x07f0 }
            java.lang.String r6 = "_o"
            java.lang.String r7 = r2.origin     // Catch:{ all -> 0x07f0 }
            r5.zza(r4, r6, r7)     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzbw r5 = r1.zzada     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzfy r5 = r5.zzgr()     // Catch:{ all -> 0x07f0 }
            boolean r5 = r5.zzcz(r15)     // Catch:{ all -> 0x07f0 }
            if (r5 == 0) goto L_0x03ee
            com.google.android.gms.measurement.internal.zzbw r5 = r1.zzada     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzfy r5 = r5.zzgr()     // Catch:{ all -> 0x07f0 }
            java.lang.String r6 = "_dbg"
            java.lang.Long r7 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x07f0 }
            r5.zza(r4, r6, r7)     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzbw r5 = r1.zzada     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzfy r5 = r5.zzgr()     // Catch:{ all -> 0x07f0 }
            java.lang.String r6 = "_r"
            java.lang.Long r7 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x07f0 }
            r5.zza(r4, r6, r7)     // Catch:{ all -> 0x07f0 }
        L_0x03ee:
            com.google.android.gms.measurement.internal.zzbw r5 = r1.zzada     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzq r5 = r5.zzgv()     // Catch:{ all -> 0x07f0 }
            java.lang.String r6 = r3.packageName     // Catch:{ all -> 0x07f0 }
            boolean r5 = r5.zzbh(r6)     // Catch:{ all -> 0x07f0 }
            if (r5 == 0) goto L_0x0427
            java.lang.String r5 = "_s"
            java.lang.String r6 = r2.name     // Catch:{ all -> 0x07f0 }
            boolean r5 = r5.equals(r6)     // Catch:{ all -> 0x07f0 }
            if (r5 == 0) goto L_0x0427
            com.google.android.gms.measurement.internal.zzt r5 = r25.zzjt()     // Catch:{ all -> 0x07f0 }
            java.lang.String r6 = r3.packageName     // Catch:{ all -> 0x07f0 }
            java.lang.String r7 = "_sno"
            com.google.android.gms.measurement.internal.zzfx r5 = r5.zzi(r6, r7)     // Catch:{ all -> 0x07f0 }
            if (r5 == 0) goto L_0x0427
            java.lang.Object r6 = r5.value     // Catch:{ all -> 0x07f0 }
            boolean r6 = r6 instanceof java.lang.Long     // Catch:{ all -> 0x07f0 }
            if (r6 == 0) goto L_0x0427
            com.google.android.gms.measurement.internal.zzbw r6 = r1.zzada     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzfy r6 = r6.zzgr()     // Catch:{ all -> 0x07f0 }
            java.lang.String r7 = "_sno"
            java.lang.Object r5 = r5.value     // Catch:{ all -> 0x07f0 }
            r6.zza(r4, r7, r5)     // Catch:{ all -> 0x07f0 }
        L_0x0427:
            com.google.android.gms.measurement.internal.zzt r5 = r25.zzjt()     // Catch:{ all -> 0x07f0 }
            long r5 = r5.zzbn(r15)     // Catch:{ all -> 0x07f0 }
            int r7 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r7 <= 0) goto L_0x044a
            com.google.android.gms.measurement.internal.zzbw r7 = r1.zzada     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzas r7 = r7.zzgt()     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzau r7 = r7.zzjj()     // Catch:{ all -> 0x07f0 }
            java.lang.String r8 = "Data lost. Too many events stored on disk, deleted. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzas.zzbw(r15)     // Catch:{ all -> 0x07f0 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x07f0 }
            r7.zze(r8, r9, r5)     // Catch:{ all -> 0x07f0 }
        L_0x044a:
            com.google.android.gms.measurement.internal.zzab r5 = new com.google.android.gms.measurement.internal.zzab     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzbw r7 = r1.zzada     // Catch:{ all -> 0x07f0 }
            java.lang.String r8 = r2.origin     // Catch:{ all -> 0x07f0 }
            java.lang.String r10 = r2.name     // Catch:{ all -> 0x07f0 }
            long r12 = r2.zzaig     // Catch:{ all -> 0x07f0 }
            r16 = 0
            r6 = r5
            r9 = r15
            r2 = 0
            r11 = r12
            r13 = r16
            r2 = r15
            r15 = r4
            r6.<init>(r7, r8, r9, r10, r11, r13, r15)     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzt r4 = r25.zzjt()     // Catch:{ all -> 0x07f0 }
            java.lang.String r6 = r5.name     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzac r4 = r4.zzg(r2, r6)     // Catch:{ all -> 0x07f0 }
            if (r4 != 0) goto L_0x04d3
            com.google.android.gms.measurement.internal.zzt r4 = r25.zzjt()     // Catch:{ all -> 0x07f0 }
            long r6 = r4.zzbq(r2)     // Catch:{ all -> 0x07f0 }
            r8 = 500(0x1f4, double:2.47E-321)
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 < 0) goto L_0x04b9
            if (r0 == 0) goto L_0x04b9
            com.google.android.gms.measurement.internal.zzbw r0 = r1.zzada     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzas r0 = r0.zzgt()     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzau r0 = r0.zzjg()     // Catch:{ all -> 0x07f0 }
            java.lang.String r3 = "Too many event names used, ignoring event. appId, name, supported count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzas.zzbw(r2)     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzbw r6 = r1.zzada     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzaq r6 = r6.zzgq()     // Catch:{ all -> 0x07f0 }
            java.lang.String r5 = r5.name     // Catch:{ all -> 0x07f0 }
            java.lang.String r5 = r6.zzbt(r5)     // Catch:{ all -> 0x07f0 }
            r6 = 500(0x1f4, float:7.0E-43)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x07f0 }
            r0.zzd(r3, r4, r5, r6)     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzbw r0 = r1.zzada     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzfy r6 = r0.zzgr()     // Catch:{ all -> 0x07f0 }
            r8 = 8
            r9 = 0
            r10 = 0
            r11 = 0
            r7 = r2
            r6.zza(r7, r8, r9, r10, r11)     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzt r0 = r25.zzjt()
            r0.endTransaction()
            return
        L_0x04b9:
            com.google.android.gms.measurement.internal.zzac r0 = new com.google.android.gms.measurement.internal.zzac     // Catch:{ all -> 0x07f0 }
            java.lang.String r8 = r5.name     // Catch:{ all -> 0x07f0 }
            r9 = 0
            r11 = 0
            long r13 = r5.timestamp     // Catch:{ all -> 0x07f0 }
            r15 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r6 = r0
            r7 = r2
            r6.<init>(r7, r8, r9, r11, r13, r15, r17, r18, r19, r20)     // Catch:{ all -> 0x07f0 }
            goto L_0x04e1
        L_0x04d3:
            com.google.android.gms.measurement.internal.zzbw r0 = r1.zzada     // Catch:{ all -> 0x07f0 }
            long r6 = r4.zzahx     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzab r5 = r5.zza(r0, r6)     // Catch:{ all -> 0x07f0 }
            long r6 = r5.timestamp     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzac r0 = r4.zzae(r6)     // Catch:{ all -> 0x07f0 }
        L_0x04e1:
            com.google.android.gms.measurement.internal.zzt r2 = r25.zzjt()     // Catch:{ all -> 0x07f0 }
            r2.zza(r0)     // Catch:{ all -> 0x07f0 }
            r25.zzaf()     // Catch:{ all -> 0x07f0 }
            r25.zzlx()     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r27)     // Catch:{ all -> 0x07f0 }
            java.lang.String r0 = r5.zztt     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r0)     // Catch:{ all -> 0x07f0 }
            java.lang.String r0 = r5.zztt     // Catch:{ all -> 0x07f0 }
            java.lang.String r2 = r3.packageName     // Catch:{ all -> 0x07f0 }
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.common.internal.Preconditions.checkArgument(r0)     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.internal.measurement.zzfw r2 = new com.google.android.gms.internal.measurement.zzfw     // Catch:{ all -> 0x07f0 }
            r2.<init>()     // Catch:{ all -> 0x07f0 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r21)     // Catch:{ all -> 0x07f0 }
            r2.zzaxh = r0     // Catch:{ all -> 0x07f0 }
            java.lang.String r0 = "android"
            r2.zzaxp = r0     // Catch:{ all -> 0x07f0 }
            java.lang.String r0 = r3.packageName     // Catch:{ all -> 0x07f0 }
            r2.zztt = r0     // Catch:{ all -> 0x07f0 }
            java.lang.String r0 = r3.zzafp     // Catch:{ all -> 0x07f0 }
            r2.zzafp = r0     // Catch:{ all -> 0x07f0 }
            java.lang.String r0 = r3.zzts     // Catch:{ all -> 0x07f0 }
            r2.zzts = r0     // Catch:{ all -> 0x07f0 }
            long r6 = r3.zzafo     // Catch:{ all -> 0x07f0 }
            r8 = -2147483648(0xffffffff80000000, double:NaN)
            r0 = 0
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 != 0) goto L_0x052b
            r4 = r0
            goto L_0x0532
        L_0x052b:
            long r6 = r3.zzafo     // Catch:{ all -> 0x07f0 }
            int r4 = (int) r6     // Catch:{ all -> 0x07f0 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x07f0 }
        L_0x0532:
            r2.zzayb = r4     // Catch:{ all -> 0x07f0 }
            long r6 = r3.zzade     // Catch:{ all -> 0x07f0 }
            java.lang.Long r4 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x07f0 }
            r2.zzaxt = r4     // Catch:{ all -> 0x07f0 }
            java.lang.String r4 = r3.zzafi     // Catch:{ all -> 0x07f0 }
            r2.zzafi = r4     // Catch:{ all -> 0x07f0 }
            java.lang.String r4 = r3.zzafv     // Catch:{ all -> 0x07f0 }
            r2.zzawp = r4     // Catch:{ all -> 0x07f0 }
            long r6 = r3.zzafq     // Catch:{ all -> 0x07f0 }
            r8 = 0
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 != 0) goto L_0x054e
            r4 = r0
            goto L_0x0554
        L_0x054e:
            long r6 = r3.zzafq     // Catch:{ all -> 0x07f0 }
            java.lang.Long r4 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x07f0 }
        L_0x0554:
            r2.zzaxx = r4     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzbw r4 = r1.zzada     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzq r4 = r4.zzgv()     // Catch:{ all -> 0x07f0 }
            java.lang.String r6 = r3.packageName     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzai$zza<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzai.zzale     // Catch:{ all -> 0x07f0 }
            boolean r4 = r4.zze(r6, r7)     // Catch:{ all -> 0x07f0 }
            if (r4 == 0) goto L_0x0570
            com.google.android.gms.measurement.internal.zzfu r4 = r25.zzjr()     // Catch:{ all -> 0x07f0 }
            int[] r4 = r4.zzmi()     // Catch:{ all -> 0x07f0 }
            r2.zzayl = r4     // Catch:{ all -> 0x07f0 }
        L_0x0570:
            com.google.android.gms.measurement.internal.zzbw r4 = r1.zzada     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzbd r4 = r4.zzgu()     // Catch:{ all -> 0x07f0 }
            java.lang.String r6 = r3.packageName     // Catch:{ all -> 0x07f0 }
            android.util.Pair r4 = r4.zzbz(r6)     // Catch:{ all -> 0x07f0 }
            if (r4 == 0) goto L_0x0599
            java.lang.Object r6 = r4.first     // Catch:{ all -> 0x07f0 }
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ all -> 0x07f0 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x07f0 }
            if (r6 != 0) goto L_0x0599
            boolean r6 = r3.zzaft     // Catch:{ all -> 0x07f0 }
            if (r6 == 0) goto L_0x05f6
            java.lang.Object r6 = r4.first     // Catch:{ all -> 0x07f0 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x07f0 }
            r2.zzaxv = r6     // Catch:{ all -> 0x07f0 }
            java.lang.Object r4 = r4.second     // Catch:{ all -> 0x07f0 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ all -> 0x07f0 }
            r2.zzaxw = r4     // Catch:{ all -> 0x07f0 }
            goto L_0x05f6
        L_0x0599:
            com.google.android.gms.measurement.internal.zzbw r4 = r1.zzada     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzaa r4 = r4.zzgp()     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzbw r6 = r1.zzada     // Catch:{ all -> 0x07f0 }
            android.content.Context r6 = r6.getContext()     // Catch:{ all -> 0x07f0 }
            boolean r4 = r4.zzl(r6)     // Catch:{ all -> 0x07f0 }
            if (r4 != 0) goto L_0x05f6
            boolean r4 = r3.zzafu     // Catch:{ all -> 0x07f0 }
            if (r4 == 0) goto L_0x05f6
            com.google.android.gms.measurement.internal.zzbw r4 = r1.zzada     // Catch:{ all -> 0x07f0 }
            android.content.Context r4 = r4.getContext()     // Catch:{ all -> 0x07f0 }
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch:{ all -> 0x07f0 }
            java.lang.String r6 = "android_id"
            java.lang.String r4 = android.provider.Settings.Secure.getString(r4, r6)     // Catch:{ all -> 0x07f0 }
            if (r4 != 0) goto L_0x05d9
            com.google.android.gms.measurement.internal.zzbw r4 = r1.zzada     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzas r4 = r4.zzgt()     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzau r4 = r4.zzjj()     // Catch:{ all -> 0x07f0 }
            java.lang.String r6 = "null secure ID. appId"
            java.lang.String r7 = r2.zztt     // Catch:{ all -> 0x07f0 }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzas.zzbw(r7)     // Catch:{ all -> 0x07f0 }
            r4.zzg(r6, r7)     // Catch:{ all -> 0x07f0 }
            java.lang.String r4 = "null"
            goto L_0x05f4
        L_0x05d9:
            boolean r6 = r4.isEmpty()     // Catch:{ all -> 0x07f0 }
            if (r6 == 0) goto L_0x05f4
            com.google.android.gms.measurement.internal.zzbw r6 = r1.zzada     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzas r6 = r6.zzgt()     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzau r6 = r6.zzjj()     // Catch:{ all -> 0x07f0 }
            java.lang.String r7 = "empty secure ID. appId"
            java.lang.String r10 = r2.zztt     // Catch:{ all -> 0x07f0 }
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzas.zzbw(r10)     // Catch:{ all -> 0x07f0 }
            r6.zzg(r7, r10)     // Catch:{ all -> 0x07f0 }
        L_0x05f4:
            r2.zzaye = r4     // Catch:{ all -> 0x07f0 }
        L_0x05f6:
            com.google.android.gms.measurement.internal.zzbw r4 = r1.zzada     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzaa r4 = r4.zzgp()     // Catch:{ all -> 0x07f0 }
            r4.zzcl()     // Catch:{ all -> 0x07f0 }
            java.lang.String r4 = android.os.Build.MODEL     // Catch:{ all -> 0x07f0 }
            r2.zzaxr = r4     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzbw r4 = r1.zzada     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzaa r4 = r4.zzgp()     // Catch:{ all -> 0x07f0 }
            r4.zzcl()     // Catch:{ all -> 0x07f0 }
            java.lang.String r4 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x07f0 }
            r2.zzaxq = r4     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzbw r4 = r1.zzada     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzaa r4 = r4.zzgp()     // Catch:{ all -> 0x07f0 }
            long r6 = r4.zziw()     // Catch:{ all -> 0x07f0 }
            int r4 = (int) r6     // Catch:{ all -> 0x07f0 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x07f0 }
            r2.zzaxs = r4     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzbw r4 = r1.zzada     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzaa r4 = r4.zzgp()     // Catch:{ all -> 0x07f0 }
            java.lang.String r4 = r4.zzix()     // Catch:{ all -> 0x07f0 }
            r2.zzahr = r4     // Catch:{ all -> 0x07f0 }
            r2.zzaxu = r0     // Catch:{ all -> 0x07f0 }
            r2.zzaxk = r0     // Catch:{ all -> 0x07f0 }
            r2.zzaxl = r0     // Catch:{ all -> 0x07f0 }
            r2.zzaxm = r0     // Catch:{ all -> 0x07f0 }
            long r6 = r3.zzafs     // Catch:{ all -> 0x07f0 }
            java.lang.Long r4 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x07f0 }
            r2.zzayg = r4     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzbw r4 = r1.zzada     // Catch:{ all -> 0x07f0 }
            boolean r4 = r4.isEnabled()     // Catch:{ all -> 0x07f0 }
            if (r4 == 0) goto L_0x064d
            boolean r4 = com.google.android.gms.measurement.internal.zzq.zzie()     // Catch:{ all -> 0x07f0 }
            if (r4 == 0) goto L_0x064d
            r2.zzayh = r0     // Catch:{ all -> 0x07f0 }
        L_0x064d:
            com.google.android.gms.measurement.internal.zzt r0 = r25.zzjt()     // Catch:{ all -> 0x07f0 }
            java.lang.String r4 = r3.packageName     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzg r0 = r0.zzbm(r4)     // Catch:{ all -> 0x07f0 }
            if (r0 != 0) goto L_0x06bb
            com.google.android.gms.measurement.internal.zzg r0 = new com.google.android.gms.measurement.internal.zzg     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzbw r4 = r1.zzada     // Catch:{ all -> 0x07f0 }
            java.lang.String r6 = r3.packageName     // Catch:{ all -> 0x07f0 }
            r0.<init>(r4, r6)     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzbw r4 = r1.zzada     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzfy r4 = r4.zzgr()     // Catch:{ all -> 0x07f0 }
            java.lang.String r4 = r4.zzmm()     // Catch:{ all -> 0x07f0 }
            r0.zzaj(r4)     // Catch:{ all -> 0x07f0 }
            java.lang.String r4 = r3.zzafk     // Catch:{ all -> 0x07f0 }
            r0.zzan(r4)     // Catch:{ all -> 0x07f0 }
            java.lang.String r4 = r3.zzafi     // Catch:{ all -> 0x07f0 }
            r0.zzak(r4)     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzbw r4 = r1.zzada     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzbd r4 = r4.zzgu()     // Catch:{ all -> 0x07f0 }
            java.lang.String r6 = r3.packageName     // Catch:{ all -> 0x07f0 }
            java.lang.String r4 = r4.zzca(r6)     // Catch:{ all -> 0x07f0 }
            r0.zzam(r4)     // Catch:{ all -> 0x07f0 }
            r0.zzt(r8)     // Catch:{ all -> 0x07f0 }
            r0.zzo(r8)     // Catch:{ all -> 0x07f0 }
            r0.zzp(r8)     // Catch:{ all -> 0x07f0 }
            java.lang.String r4 = r3.zzts     // Catch:{ all -> 0x07f0 }
            r0.setAppVersion(r4)     // Catch:{ all -> 0x07f0 }
            long r6 = r3.zzafo     // Catch:{ all -> 0x07f0 }
            r0.zzq(r6)     // Catch:{ all -> 0x07f0 }
            java.lang.String r4 = r3.zzafp     // Catch:{ all -> 0x07f0 }
            r0.zzao(r4)     // Catch:{ all -> 0x07f0 }
            long r6 = r3.zzade     // Catch:{ all -> 0x07f0 }
            r0.zzr(r6)     // Catch:{ all -> 0x07f0 }
            long r6 = r3.zzafq     // Catch:{ all -> 0x07f0 }
            r0.zzs(r6)     // Catch:{ all -> 0x07f0 }
            boolean r4 = r3.zzafr     // Catch:{ all -> 0x07f0 }
            r0.setMeasurementEnabled(r4)     // Catch:{ all -> 0x07f0 }
            long r6 = r3.zzafs     // Catch:{ all -> 0x07f0 }
            r0.zzac(r6)     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzt r4 = r25.zzjt()     // Catch:{ all -> 0x07f0 }
            r4.zza(r0)     // Catch:{ all -> 0x07f0 }
        L_0x06bb:
            java.lang.String r4 = r0.getAppInstanceId()     // Catch:{ all -> 0x07f0 }
            r2.zzafh = r4     // Catch:{ all -> 0x07f0 }
            java.lang.String r0 = r0.getFirebaseInstanceId()     // Catch:{ all -> 0x07f0 }
            r2.zzafk = r0     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzt r0 = r25.zzjt()     // Catch:{ all -> 0x07f0 }
            java.lang.String r3 = r3.packageName     // Catch:{ all -> 0x07f0 }
            java.util.List r0 = r0.zzbl(r3)     // Catch:{ all -> 0x07f0 }
            int r3 = r0.size()     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.internal.measurement.zzfz[] r3 = new com.google.android.gms.internal.measurement.zzfz[r3]     // Catch:{ all -> 0x07f0 }
            r2.zzaxj = r3     // Catch:{ all -> 0x07f0 }
            r3 = 0
        L_0x06da:
            int r4 = r0.size()     // Catch:{ all -> 0x07f0 }
            if (r3 >= r4) goto L_0x0713
            com.google.android.gms.internal.measurement.zzfz r4 = new com.google.android.gms.internal.measurement.zzfz     // Catch:{ all -> 0x07f0 }
            r4.<init>()     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.internal.measurement.zzfz[] r6 = r2.zzaxj     // Catch:{ all -> 0x07f0 }
            r6[r3] = r4     // Catch:{ all -> 0x07f0 }
            java.lang.Object r6 = r0.get(r3)     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzfx r6 = (com.google.android.gms.measurement.internal.zzfx) r6     // Catch:{ all -> 0x07f0 }
            java.lang.String r6 = r6.name     // Catch:{ all -> 0x07f0 }
            r4.name = r6     // Catch:{ all -> 0x07f0 }
            java.lang.Object r6 = r0.get(r3)     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzfx r6 = (com.google.android.gms.measurement.internal.zzfx) r6     // Catch:{ all -> 0x07f0 }
            long r6 = r6.zzauk     // Catch:{ all -> 0x07f0 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x07f0 }
            r4.zzayu = r6     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzfu r6 = r25.zzjr()     // Catch:{ all -> 0x07f0 }
            java.lang.Object r7 = r0.get(r3)     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzfx r7 = (com.google.android.gms.measurement.internal.zzfx) r7     // Catch:{ all -> 0x07f0 }
            java.lang.Object r7 = r7.value     // Catch:{ all -> 0x07f0 }
            r6.zza(r4, r7)     // Catch:{ all -> 0x07f0 }
            int r3 = r3 + 1
            goto L_0x06da
        L_0x0713:
            com.google.android.gms.measurement.internal.zzt r0 = r25.zzjt()     // Catch:{ IOException -> 0x0781 }
            long r3 = r0.zza(r2)     // Catch:{ IOException -> 0x0781 }
            com.google.android.gms.measurement.internal.zzt r0 = r25.zzjt()     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzad r2 = r5.zzahu     // Catch:{ all -> 0x07f0 }
            if (r2 == 0) goto L_0x0777
            com.google.android.gms.measurement.internal.zzad r2 = r5.zzahu     // Catch:{ all -> 0x07f0 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x07f0 }
        L_0x0729:
            boolean r6 = r2.hasNext()     // Catch:{ all -> 0x07f0 }
            if (r6 == 0) goto L_0x073f
            java.lang.Object r6 = r2.next()     // Catch:{ all -> 0x07f0 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x07f0 }
            java.lang.String r7 = "_r"
            boolean r6 = r7.equals(r6)     // Catch:{ all -> 0x07f0 }
            if (r6 == 0) goto L_0x0729
        L_0x073d:
            r2 = 1
            goto L_0x0778
        L_0x073f:
            com.google.android.gms.measurement.internal.zzbq r2 = r25.zzls()     // Catch:{ all -> 0x07f0 }
            java.lang.String r6 = r5.zztt     // Catch:{ all -> 0x07f0 }
            java.lang.String r7 = r5.name     // Catch:{ all -> 0x07f0 }
            boolean r2 = r2.zzp(r6, r7)     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzt r10 = r25.zzjt()     // Catch:{ all -> 0x07f0 }
            long r11 = r25.zzly()     // Catch:{ all -> 0x07f0 }
            java.lang.String r13 = r5.zztt     // Catch:{ all -> 0x07f0 }
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            com.google.android.gms.measurement.internal.zzu r6 = r10.zza(r11, r13, r14, r15, r16, r17, r18)     // Catch:{ all -> 0x07f0 }
            if (r2 == 0) goto L_0x0777
            long r6 = r6.zzahl     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzbw r2 = r1.zzada     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzq r2 = r2.zzgv()     // Catch:{ all -> 0x07f0 }
            java.lang.String r10 = r5.zztt     // Catch:{ all -> 0x07f0 }
            int r2 = r2.zzaq(r10)     // Catch:{ all -> 0x07f0 }
            long r10 = (long) r2     // Catch:{ all -> 0x07f0 }
            int r2 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r2 >= 0) goto L_0x0777
            goto L_0x073d
        L_0x0777:
            r2 = 0
        L_0x0778:
            boolean r0 = r0.zza(r5, r3, r2)     // Catch:{ all -> 0x07f0 }
            if (r0 == 0) goto L_0x0797
            r1.zzatr = r8     // Catch:{ all -> 0x07f0 }
            goto L_0x0797
        L_0x0781:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzbw r3 = r1.zzada     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzas r3 = r3.zzgt()     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzau r3 = r3.zzjg()     // Catch:{ all -> 0x07f0 }
            java.lang.String r4 = "Data loss. Failed to insert raw event metadata. appId"
            java.lang.String r2 = r2.zztt     // Catch:{ all -> 0x07f0 }
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzas.zzbw(r2)     // Catch:{ all -> 0x07f0 }
            r3.zze(r4, r2, r0)     // Catch:{ all -> 0x07f0 }
        L_0x0797:
            com.google.android.gms.measurement.internal.zzt r0 = r25.zzjt()     // Catch:{ all -> 0x07f0 }
            r0.setTransactionSuccessful()     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzbw r0 = r1.zzada     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzas r0 = r0.zzgt()     // Catch:{ all -> 0x07f0 }
            r2 = 2
            boolean r0 = r0.isLoggable(r2)     // Catch:{ all -> 0x07f0 }
            if (r0 == 0) goto L_0x07c4
            com.google.android.gms.measurement.internal.zzbw r0 = r1.zzada     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzas r0 = r0.zzgt()     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzau r0 = r0.zzjo()     // Catch:{ all -> 0x07f0 }
            java.lang.String r2 = "Event recorded"
            com.google.android.gms.measurement.internal.zzbw r3 = r1.zzada     // Catch:{ all -> 0x07f0 }
            com.google.android.gms.measurement.internal.zzaq r3 = r3.zzgq()     // Catch:{ all -> 0x07f0 }
            java.lang.String r3 = r3.zza(r5)     // Catch:{ all -> 0x07f0 }
            r0.zzg(r2, r3)     // Catch:{ all -> 0x07f0 }
        L_0x07c4:
            com.google.android.gms.measurement.internal.zzt r0 = r25.zzjt()
            r0.endTransaction()
            r25.zzmb()
            com.google.android.gms.measurement.internal.zzbw r0 = r1.zzada
            com.google.android.gms.measurement.internal.zzas r0 = r0.zzgt()
            com.google.android.gms.measurement.internal.zzau r0 = r0.zzjo()
            java.lang.String r2 = "Background event processing time, ms"
            long r3 = java.lang.System.nanoTime()
            long r3 = r3 - r22
            r5 = 500000(0x7a120, double:2.47033E-318)
            long r3 = r3 + r5
            r5 = 1000000(0xf4240, double:4.940656E-318)
            long r3 = r3 / r5
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r0.zzg(r2, r3)
            return
        L_0x07f0:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzt r2 = r25.zzjt()
            r2.endTransaction()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfo.zzd(com.google.android.gms.measurement.internal.zzag, com.google.android.gms.measurement.internal.zzk):void");
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:88|89) */
    /* JADX WARNING: Code restructure failed: missing block: B:89:?, code lost:
        r1.zzada.zzgt().zzjg().zze("Failed to parse upload URL. Not uploading. appId", com.google.android.gms.measurement.internal.zzas.zzbw(r5), r6);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:88:0x029e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzlz() {
        /*
            r17 = this;
            r1 = r17
            r17.zzaf()
            r17.zzlx()
            r0 = 1
            r1.zzatx = r0
            r2 = 0
            com.google.android.gms.measurement.internal.zzbw r3 = r1.zzada     // Catch:{ all -> 0x02db }
            r3.zzgw()     // Catch:{ all -> 0x02db }
            com.google.android.gms.measurement.internal.zzbw r3 = r1.zzada     // Catch:{ all -> 0x02db }
            com.google.android.gms.measurement.internal.zzeb r3 = r3.zzgl()     // Catch:{ all -> 0x02db }
            java.lang.Boolean r3 = r3.zzli()     // Catch:{ all -> 0x02db }
            if (r3 != 0) goto L_0x0032
            com.google.android.gms.measurement.internal.zzbw r0 = r1.zzada     // Catch:{ all -> 0x02db }
            com.google.android.gms.measurement.internal.zzas r0 = r0.zzgt()     // Catch:{ all -> 0x02db }
            com.google.android.gms.measurement.internal.zzau r0 = r0.zzjj()     // Catch:{ all -> 0x02db }
            java.lang.String r3 = "Upload data called on the client side before use of service was decided"
            r0.zzby(r3)     // Catch:{ all -> 0x02db }
            r1.zzatx = r2
            r17.zzmc()
            return
        L_0x0032:
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x02db }
            if (r3 == 0) goto L_0x004d
            com.google.android.gms.measurement.internal.zzbw r0 = r1.zzada     // Catch:{ all -> 0x02db }
            com.google.android.gms.measurement.internal.zzas r0 = r0.zzgt()     // Catch:{ all -> 0x02db }
            com.google.android.gms.measurement.internal.zzau r0 = r0.zzjg()     // Catch:{ all -> 0x02db }
            java.lang.String r3 = "Upload called in the client side when service should be used"
            r0.zzby(r3)     // Catch:{ all -> 0x02db }
            r1.zzatx = r2
            r17.zzmc()
            return
        L_0x004d:
            long r3 = r1.zzatr     // Catch:{ all -> 0x02db }
            r5 = 0
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 <= 0) goto L_0x005e
            r17.zzmb()     // Catch:{ all -> 0x02db }
            r1.zzatx = r2
            r17.zzmc()
            return
        L_0x005e:
            r17.zzaf()     // Catch:{ all -> 0x02db }
            java.util.List<java.lang.Long> r3 = r1.zzaua     // Catch:{ all -> 0x02db }
            if (r3 == 0) goto L_0x0067
            r3 = 1
            goto L_0x0068
        L_0x0067:
            r3 = 0
        L_0x0068:
            if (r3 == 0) goto L_0x007f
            com.google.android.gms.measurement.internal.zzbw r0 = r1.zzada     // Catch:{ all -> 0x02db }
            com.google.android.gms.measurement.internal.zzas r0 = r0.zzgt()     // Catch:{ all -> 0x02db }
            com.google.android.gms.measurement.internal.zzau r0 = r0.zzjo()     // Catch:{ all -> 0x02db }
            java.lang.String r3 = "Uploading requested multiple times"
            r0.zzby(r3)     // Catch:{ all -> 0x02db }
            r1.zzatx = r2
            r17.zzmc()
            return
        L_0x007f:
            com.google.android.gms.measurement.internal.zzaw r3 = r17.zzlt()     // Catch:{ all -> 0x02db }
            boolean r3 = r3.zzfb()     // Catch:{ all -> 0x02db }
            if (r3 != 0) goto L_0x00a1
            com.google.android.gms.measurement.internal.zzbw r0 = r1.zzada     // Catch:{ all -> 0x02db }
            com.google.android.gms.measurement.internal.zzas r0 = r0.zzgt()     // Catch:{ all -> 0x02db }
            com.google.android.gms.measurement.internal.zzau r0 = r0.zzjo()     // Catch:{ all -> 0x02db }
            java.lang.String r3 = "Network not connected, ignoring upload request"
            r0.zzby(r3)     // Catch:{ all -> 0x02db }
            r17.zzmb()     // Catch:{ all -> 0x02db }
            r1.zzatx = r2
            r17.zzmc()
            return
        L_0x00a1:
            com.google.android.gms.measurement.internal.zzbw r3 = r1.zzada     // Catch:{ all -> 0x02db }
            com.google.android.gms.common.util.Clock r3 = r3.zzbx()     // Catch:{ all -> 0x02db }
            long r3 = r3.currentTimeMillis()     // Catch:{ all -> 0x02db }
            long r7 = com.google.android.gms.measurement.internal.zzq.zzic()     // Catch:{ all -> 0x02db }
            r9 = 0
            long r7 = r3 - r7
            r9 = 0
            r1.zzd(r9, r7)     // Catch:{ all -> 0x02db }
            com.google.android.gms.measurement.internal.zzbw r7 = r1.zzada     // Catch:{ all -> 0x02db }
            com.google.android.gms.measurement.internal.zzbd r7 = r7.zzgu()     // Catch:{ all -> 0x02db }
            com.google.android.gms.measurement.internal.zzbg r7 = r7.zzana     // Catch:{ all -> 0x02db }
            long r7 = r7.get()     // Catch:{ all -> 0x02db }
            int r5 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r5 == 0) goto L_0x00e0
            com.google.android.gms.measurement.internal.zzbw r5 = r1.zzada     // Catch:{ all -> 0x02db }
            com.google.android.gms.measurement.internal.zzas r5 = r5.zzgt()     // Catch:{ all -> 0x02db }
            com.google.android.gms.measurement.internal.zzau r5 = r5.zzjn()     // Catch:{ all -> 0x02db }
            java.lang.String r6 = "Uploading events. Elapsed time since last upload attempt (ms)"
            r10 = 0
            long r7 = r3 - r7
            long r7 = java.lang.Math.abs(r7)     // Catch:{ all -> 0x02db }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x02db }
            r5.zzg(r6, r7)     // Catch:{ all -> 0x02db }
        L_0x00e0:
            com.google.android.gms.measurement.internal.zzt r5 = r17.zzjt()     // Catch:{ all -> 0x02db }
            java.lang.String r5 = r5.zzih()     // Catch:{ all -> 0x02db }
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x02db }
            r7 = -1
            if (r6 != 0) goto L_0x02b2
            long r10 = r1.zzauc     // Catch:{ all -> 0x02db }
            int r6 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r6 != 0) goto L_0x0100
            com.google.android.gms.measurement.internal.zzt r6 = r17.zzjt()     // Catch:{ all -> 0x02db }
            long r6 = r6.zzio()     // Catch:{ all -> 0x02db }
            r1.zzauc = r6     // Catch:{ all -> 0x02db }
        L_0x0100:
            com.google.android.gms.measurement.internal.zzbw r6 = r1.zzada     // Catch:{ all -> 0x02db }
            com.google.android.gms.measurement.internal.zzq r6 = r6.zzgv()     // Catch:{ all -> 0x02db }
            com.google.android.gms.measurement.internal.zzai$zza<java.lang.Integer> r7 = com.google.android.gms.measurement.internal.zzai.zzaja     // Catch:{ all -> 0x02db }
            int r6 = r6.zzb(r5, r7)     // Catch:{ all -> 0x02db }
            com.google.android.gms.measurement.internal.zzbw r7 = r1.zzada     // Catch:{ all -> 0x02db }
            com.google.android.gms.measurement.internal.zzq r7 = r7.zzgv()     // Catch:{ all -> 0x02db }
            com.google.android.gms.measurement.internal.zzai$zza<java.lang.Integer> r8 = com.google.android.gms.measurement.internal.zzai.zzajb     // Catch:{ all -> 0x02db }
            int r7 = r7.zzb(r5, r8)     // Catch:{ all -> 0x02db }
            int r7 = java.lang.Math.max(r2, r7)     // Catch:{ all -> 0x02db }
            com.google.android.gms.measurement.internal.zzt r8 = r17.zzjt()     // Catch:{ all -> 0x02db }
            java.util.List r6 = r8.zzb(r5, r6, r7)     // Catch:{ all -> 0x02db }
            boolean r7 = r6.isEmpty()     // Catch:{ all -> 0x02db }
            if (r7 != 0) goto L_0x02d5
            java.util.Iterator r7 = r6.iterator()     // Catch:{ all -> 0x02db }
        L_0x012e:
            boolean r8 = r7.hasNext()     // Catch:{ all -> 0x02db }
            if (r8 == 0) goto L_0x0149
            java.lang.Object r8 = r7.next()     // Catch:{ all -> 0x02db }
            android.util.Pair r8 = (android.util.Pair) r8     // Catch:{ all -> 0x02db }
            java.lang.Object r8 = r8.first     // Catch:{ all -> 0x02db }
            com.google.android.gms.internal.measurement.zzfw r8 = (com.google.android.gms.internal.measurement.zzfw) r8     // Catch:{ all -> 0x02db }
            java.lang.String r10 = r8.zzaxv     // Catch:{ all -> 0x02db }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x02db }
            if (r10 != 0) goto L_0x012e
            java.lang.String r7 = r8.zzaxv     // Catch:{ all -> 0x02db }
            goto L_0x014a
        L_0x0149:
            r7 = r9
        L_0x014a:
            if (r7 == 0) goto L_0x0175
            r8 = 0
        L_0x014d:
            int r10 = r6.size()     // Catch:{ all -> 0x02db }
            if (r8 >= r10) goto L_0x0175
            java.lang.Object r10 = r6.get(r8)     // Catch:{ all -> 0x02db }
            android.util.Pair r10 = (android.util.Pair) r10     // Catch:{ all -> 0x02db }
            java.lang.Object r10 = r10.first     // Catch:{ all -> 0x02db }
            com.google.android.gms.internal.measurement.zzfw r10 = (com.google.android.gms.internal.measurement.zzfw) r10     // Catch:{ all -> 0x02db }
            java.lang.String r11 = r10.zzaxv     // Catch:{ all -> 0x02db }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x02db }
            if (r11 != 0) goto L_0x0172
            java.lang.String r10 = r10.zzaxv     // Catch:{ all -> 0x02db }
            boolean r10 = r10.equals(r7)     // Catch:{ all -> 0x02db }
            if (r10 != 0) goto L_0x0172
            java.util.List r6 = r6.subList(r2, r8)     // Catch:{ all -> 0x02db }
            goto L_0x0175
        L_0x0172:
            int r8 = r8 + 1
            goto L_0x014d
        L_0x0175:
            com.google.android.gms.internal.measurement.zzfv r7 = new com.google.android.gms.internal.measurement.zzfv     // Catch:{ all -> 0x02db }
            r7.<init>()     // Catch:{ all -> 0x02db }
            int r8 = r6.size()     // Catch:{ all -> 0x02db }
            com.google.android.gms.internal.measurement.zzfw[] r8 = new com.google.android.gms.internal.measurement.zzfw[r8]     // Catch:{ all -> 0x02db }
            r7.zzaxf = r8     // Catch:{ all -> 0x02db }
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ all -> 0x02db }
            int r10 = r6.size()     // Catch:{ all -> 0x02db }
            r8.<init>(r10)     // Catch:{ all -> 0x02db }
            boolean r10 = com.google.android.gms.measurement.internal.zzq.zzie()     // Catch:{ all -> 0x02db }
            if (r10 == 0) goto L_0x019f
            com.google.android.gms.measurement.internal.zzbw r10 = r1.zzada     // Catch:{ all -> 0x02db }
            com.google.android.gms.measurement.internal.zzq r10 = r10.zzgv()     // Catch:{ all -> 0x02db }
            boolean r10 = r10.zzas(r5)     // Catch:{ all -> 0x02db }
            if (r10 == 0) goto L_0x019f
            r10 = 1
            goto L_0x01a0
        L_0x019f:
            r10 = 0
        L_0x01a0:
            r11 = 0
        L_0x01a1:
            com.google.android.gms.internal.measurement.zzfw[] r12 = r7.zzaxf     // Catch:{ all -> 0x02db }
            int r12 = r12.length     // Catch:{ all -> 0x02db }
            if (r11 >= r12) goto L_0x01f9
            com.google.android.gms.internal.measurement.zzfw[] r12 = r7.zzaxf     // Catch:{ all -> 0x02db }
            java.lang.Object r13 = r6.get(r11)     // Catch:{ all -> 0x02db }
            android.util.Pair r13 = (android.util.Pair) r13     // Catch:{ all -> 0x02db }
            java.lang.Object r13 = r13.first     // Catch:{ all -> 0x02db }
            com.google.android.gms.internal.measurement.zzfw r13 = (com.google.android.gms.internal.measurement.zzfw) r13     // Catch:{ all -> 0x02db }
            r12[r11] = r13     // Catch:{ all -> 0x02db }
            java.lang.Object r12 = r6.get(r11)     // Catch:{ all -> 0x02db }
            android.util.Pair r12 = (android.util.Pair) r12     // Catch:{ all -> 0x02db }
            java.lang.Object r12 = r12.second     // Catch:{ all -> 0x02db }
            java.lang.Long r12 = (java.lang.Long) r12     // Catch:{ all -> 0x02db }
            r8.add(r12)     // Catch:{ all -> 0x02db }
            com.google.android.gms.internal.measurement.zzfw[] r12 = r7.zzaxf     // Catch:{ all -> 0x02db }
            r12 = r12[r11]     // Catch:{ all -> 0x02db }
            com.google.android.gms.measurement.internal.zzbw r13 = r1.zzada     // Catch:{ all -> 0x02db }
            com.google.android.gms.measurement.internal.zzq r13 = r13.zzgv()     // Catch:{ all -> 0x02db }
            long r13 = r13.zzhh()     // Catch:{ all -> 0x02db }
            java.lang.Long r13 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x02db }
            r12.zzaxu = r13     // Catch:{ all -> 0x02db }
            com.google.android.gms.internal.measurement.zzfw[] r12 = r7.zzaxf     // Catch:{ all -> 0x02db }
            r12 = r12[r11]     // Catch:{ all -> 0x02db }
            java.lang.Long r13 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x02db }
            r12.zzaxk = r13     // Catch:{ all -> 0x02db }
            com.google.android.gms.internal.measurement.zzfw[] r12 = r7.zzaxf     // Catch:{ all -> 0x02db }
            r12 = r12[r11]     // Catch:{ all -> 0x02db }
            com.google.android.gms.measurement.internal.zzbw r13 = r1.zzada     // Catch:{ all -> 0x02db }
            r13.zzgw()     // Catch:{ all -> 0x02db }
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r2)     // Catch:{ all -> 0x02db }
            r12.zzaxz = r13     // Catch:{ all -> 0x02db }
            if (r10 != 0) goto L_0x01f6
            com.google.android.gms.internal.measurement.zzfw[] r12 = r7.zzaxf     // Catch:{ all -> 0x02db }
            r12 = r12[r11]     // Catch:{ all -> 0x02db }
            r12.zzayh = r9     // Catch:{ all -> 0x02db }
        L_0x01f6:
            int r11 = r11 + 1
            goto L_0x01a1
        L_0x01f9:
            com.google.android.gms.measurement.internal.zzbw r6 = r1.zzada     // Catch:{ all -> 0x02db }
            com.google.android.gms.measurement.internal.zzas r6 = r6.zzgt()     // Catch:{ all -> 0x02db }
            r10 = 2
            boolean r6 = r6.isLoggable(r10)     // Catch:{ all -> 0x02db }
            if (r6 == 0) goto L_0x020e
            com.google.android.gms.measurement.internal.zzfu r6 = r17.zzjr()     // Catch:{ all -> 0x02db }
            java.lang.String r9 = r6.zzb(r7)     // Catch:{ all -> 0x02db }
        L_0x020e:
            com.google.android.gms.measurement.internal.zzfu r6 = r17.zzjr()     // Catch:{ all -> 0x02db }
            byte[] r14 = r6.zza(r7)     // Catch:{ all -> 0x02db }
            com.google.android.gms.measurement.internal.zzai$zza<java.lang.String> r6 = com.google.android.gms.measurement.internal.zzai.zzajk     // Catch:{ all -> 0x02db }
            java.lang.Object r6 = r6.get()     // Catch:{ all -> 0x02db }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x02db }
            java.net.URL r13 = new java.net.URL     // Catch:{ MalformedURLException -> 0x029e }
            r13.<init>(r6)     // Catch:{ MalformedURLException -> 0x029e }
            boolean r10 = r8.isEmpty()     // Catch:{ MalformedURLException -> 0x029e }
            r10 = r10 ^ r0
            com.google.android.gms.common.internal.Preconditions.checkArgument(r10)     // Catch:{ MalformedURLException -> 0x029e }
            java.util.List<java.lang.Long> r10 = r1.zzaua     // Catch:{ MalformedURLException -> 0x029e }
            if (r10 == 0) goto L_0x023f
            com.google.android.gms.measurement.internal.zzbw r8 = r1.zzada     // Catch:{ MalformedURLException -> 0x029e }
            com.google.android.gms.measurement.internal.zzas r8 = r8.zzgt()     // Catch:{ MalformedURLException -> 0x029e }
            com.google.android.gms.measurement.internal.zzau r8 = r8.zzjg()     // Catch:{ MalformedURLException -> 0x029e }
            java.lang.String r10 = "Set uploading progress before finishing the previous upload"
            r8.zzby(r10)     // Catch:{ MalformedURLException -> 0x029e }
            goto L_0x0246
        L_0x023f:
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ MalformedURLException -> 0x029e }
            r10.<init>(r8)     // Catch:{ MalformedURLException -> 0x029e }
            r1.zzaua = r10     // Catch:{ MalformedURLException -> 0x029e }
        L_0x0246:
            com.google.android.gms.measurement.internal.zzbw r8 = r1.zzada     // Catch:{ MalformedURLException -> 0x029e }
            com.google.android.gms.measurement.internal.zzbd r8 = r8.zzgu()     // Catch:{ MalformedURLException -> 0x029e }
            com.google.android.gms.measurement.internal.zzbg r8 = r8.zzanb     // Catch:{ MalformedURLException -> 0x029e }
            r8.set(r3)     // Catch:{ MalformedURLException -> 0x029e }
            java.lang.String r3 = "?"
            com.google.android.gms.internal.measurement.zzfw[] r4 = r7.zzaxf     // Catch:{ MalformedURLException -> 0x029e }
            int r4 = r4.length     // Catch:{ MalformedURLException -> 0x029e }
            if (r4 <= 0) goto L_0x025e
            com.google.android.gms.internal.measurement.zzfw[] r3 = r7.zzaxf     // Catch:{ MalformedURLException -> 0x029e }
            r3 = r3[r2]     // Catch:{ MalformedURLException -> 0x029e }
            java.lang.String r3 = r3.zztt     // Catch:{ MalformedURLException -> 0x029e }
        L_0x025e:
            com.google.android.gms.measurement.internal.zzbw r4 = r1.zzada     // Catch:{ MalformedURLException -> 0x029e }
            com.google.android.gms.measurement.internal.zzas r4 = r4.zzgt()     // Catch:{ MalformedURLException -> 0x029e }
            com.google.android.gms.measurement.internal.zzau r4 = r4.zzjo()     // Catch:{ MalformedURLException -> 0x029e }
            java.lang.String r7 = "Uploading data. app, uncompressed size, data"
            int r8 = r14.length     // Catch:{ MalformedURLException -> 0x029e }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ MalformedURLException -> 0x029e }
            r4.zzd(r7, r3, r8, r9)     // Catch:{ MalformedURLException -> 0x029e }
            r1.zzatw = r0     // Catch:{ MalformedURLException -> 0x029e }
            com.google.android.gms.measurement.internal.zzaw r11 = r17.zzlt()     // Catch:{ MalformedURLException -> 0x029e }
            com.google.android.gms.measurement.internal.zzfq r0 = new com.google.android.gms.measurement.internal.zzfq     // Catch:{ MalformedURLException -> 0x029e }
            r0.<init>(r1, r5)     // Catch:{ MalformedURLException -> 0x029e }
            r11.zzaf()     // Catch:{ MalformedURLException -> 0x029e }
            r11.zzcl()     // Catch:{ MalformedURLException -> 0x029e }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r13)     // Catch:{ MalformedURLException -> 0x029e }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r14)     // Catch:{ MalformedURLException -> 0x029e }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ MalformedURLException -> 0x029e }
            com.google.android.gms.measurement.internal.zzbr r3 = r11.zzgs()     // Catch:{ MalformedURLException -> 0x029e }
            com.google.android.gms.measurement.internal.zzba r4 = new com.google.android.gms.measurement.internal.zzba     // Catch:{ MalformedURLException -> 0x029e }
            r15 = 0
            r10 = r4
            r12 = r5
            r16 = r0
            r10.<init>(r11, r12, r13, r14, r15, r16)     // Catch:{ MalformedURLException -> 0x029e }
            r3.zzd(r4)     // Catch:{ MalformedURLException -> 0x029e }
            goto L_0x02d5
        L_0x029e:
            com.google.android.gms.measurement.internal.zzbw r0 = r1.zzada     // Catch:{ all -> 0x02db }
            com.google.android.gms.measurement.internal.zzas r0 = r0.zzgt()     // Catch:{ all -> 0x02db }
            com.google.android.gms.measurement.internal.zzau r0 = r0.zzjg()     // Catch:{ all -> 0x02db }
            java.lang.String r3 = "Failed to parse upload URL. Not uploading. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzas.zzbw(r5)     // Catch:{ all -> 0x02db }
            r0.zze(r3, r4, r6)     // Catch:{ all -> 0x02db }
            goto L_0x02d5
        L_0x02b2:
            r1.zzauc = r7     // Catch:{ all -> 0x02db }
            com.google.android.gms.measurement.internal.zzt r0 = r17.zzjt()     // Catch:{ all -> 0x02db }
            long r5 = com.google.android.gms.measurement.internal.zzq.zzic()     // Catch:{ all -> 0x02db }
            r7 = 0
            long r3 = r3 - r5
            java.lang.String r0 = r0.zzad(r3)     // Catch:{ all -> 0x02db }
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x02db }
            if (r3 != 0) goto L_0x02d5
            com.google.android.gms.measurement.internal.zzt r3 = r17.zzjt()     // Catch:{ all -> 0x02db }
            com.google.android.gms.measurement.internal.zzg r0 = r3.zzbm(r0)     // Catch:{ all -> 0x02db }
            if (r0 == 0) goto L_0x02d5
            r1.zzb(r0)     // Catch:{ all -> 0x02db }
        L_0x02d5:
            r1.zzatx = r2
            r17.zzmc()
            return
        L_0x02db:
            r0 = move-exception
            r1.zzatx = r2
            r17.zzmc()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfo.zzlz():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0040, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0041, code lost:
        r5 = r1;
        r22 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0046, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0047, code lost:
        r6 = null;
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x009c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x009d, code lost:
        r6 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:495:0x0b41, code lost:
        if (r18 != r14) goto L_0x0b43;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0040 A[ExcHandler: all (th java.lang.Throwable), PHI: r3 
      PHI: (r3v158 android.database.Cursor) = (r3v153 android.database.Cursor), (r3v153 android.database.Cursor), (r3v153 android.database.Cursor), (r3v161 android.database.Cursor), (r3v161 android.database.Cursor), (r3v161 android.database.Cursor), (r3v161 android.database.Cursor), (r3v0 android.database.Cursor), (r3v0 android.database.Cursor) binds: [B:45:0x00e0, B:51:0x00ed, B:52:?, B:23:0x007f, B:29:0x008c, B:31:0x0090, B:32:?, B:9:0x0031, B:10:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:9:0x0031] */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0290 A[SYNTHETIC, Splitter:B:153:0x0290] */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x0297 A[Catch:{ IOException -> 0x0239, all -> 0x0df5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x02a5 A[Catch:{ IOException -> 0x0239, all -> 0x0df5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x03bd A[Catch:{ IOException -> 0x0239, all -> 0x0df5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x03bf A[Catch:{ IOException -> 0x0239, all -> 0x0df5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x03c2 A[Catch:{ IOException -> 0x0239, all -> 0x0df5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x03c3 A[Catch:{ IOException -> 0x0239, all -> 0x0df5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:266:0x05df A[ADDED_TO_REGION, Catch:{ IOException -> 0x0239, all -> 0x0df5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:309:0x06a2 A[Catch:{ IOException -> 0x0239, all -> 0x0df5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:337:0x0723 A[Catch:{ IOException -> 0x0239, all -> 0x0df5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:381:0x0871 A[Catch:{ IOException -> 0x0239, all -> 0x0df5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:387:0x088b A[Catch:{ IOException -> 0x0239, all -> 0x0df5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:390:0x08ab A[Catch:{ IOException -> 0x0239, all -> 0x0df5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:442:0x0a04 A[Catch:{ IOException -> 0x0239, all -> 0x0df5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:443:0x0a13 A[Catch:{ IOException -> 0x0239, all -> 0x0df5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:445:0x0a16 A[Catch:{ IOException -> 0x0239, all -> 0x0df5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:447:0x0a36 A[SYNTHETIC, Splitter:B:447:0x0a36] */
    /* JADX WARNING: Removed duplicated region for block: B:502:0x0b63 A[Catch:{ all -> 0x0c03 }] */
    /* JADX WARNING: Removed duplicated region for block: B:506:0x0baf A[Catch:{ all -> 0x0c03 }] */
    /* JADX WARNING: Removed duplicated region for block: B:590:0x0dd6  */
    /* JADX WARNING: Removed duplicated region for block: B:598:0x0dee A[SYNTHETIC, Splitter:B:598:0x0dee] */
    /* JADX WARNING: Removed duplicated region for block: B:637:0x0888 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzd(java.lang.String r56, long r57) {
        /*
            r55 = this;
            r1 = r55
            com.google.android.gms.measurement.internal.zzt r2 = r55.zzjt()
            r2.beginTransaction()
            com.google.android.gms.measurement.internal.zzfo$zza r2 = new com.google.android.gms.measurement.internal.zzfo$zza     // Catch:{ all -> 0x0df5 }
            r3 = 0
            r2.<init>(r1, r3)     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.measurement.internal.zzt r4 = r55.zzjt()     // Catch:{ all -> 0x0df5 }
            long r5 = r1.zzauc     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r2)     // Catch:{ all -> 0x0df5 }
            r4.zzaf()     // Catch:{ all -> 0x0df5 }
            r4.zzcl()     // Catch:{ all -> 0x0df5 }
            r8 = -1
            r10 = 2
            r11 = 0
            r12 = 1
            android.database.sqlite.SQLiteDatabase r15 = r4.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0279, all -> 0x0272 }
            boolean r13 = android.text.TextUtils.isEmpty(r3)     // Catch:{ SQLiteException -> 0x0279, all -> 0x0272 }
            if (r13 == 0) goto L_0x009f
            int r13 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r13 == 0) goto L_0x004c
            java.lang.String[] r14 = new java.lang.String[r10]     // Catch:{ SQLiteException -> 0x0046, all -> 0x0040 }
            java.lang.String r16 = java.lang.String.valueOf(r5)     // Catch:{ SQLiteException -> 0x0046, all -> 0x0040 }
            r14[r11] = r16     // Catch:{ SQLiteException -> 0x0046, all -> 0x0040 }
            java.lang.String r16 = java.lang.String.valueOf(r57)     // Catch:{ SQLiteException -> 0x0046, all -> 0x0040 }
            r14[r12] = r16     // Catch:{ SQLiteException -> 0x0046, all -> 0x0040 }
            goto L_0x0054
        L_0x0040:
            r0 = move-exception
            r5 = r1
            r22 = r3
            goto L_0x0276
        L_0x0046:
            r0 = move-exception
            r6 = r3
            r7 = r6
        L_0x0049:
            r3 = r0
            goto L_0x027d
        L_0x004c:
            java.lang.String[] r14 = new java.lang.String[r12]     // Catch:{ SQLiteException -> 0x0279, all -> 0x0272 }
            java.lang.String r16 = java.lang.String.valueOf(r57)     // Catch:{ SQLiteException -> 0x0279, all -> 0x0272 }
            r14[r11] = r16     // Catch:{ SQLiteException -> 0x0279, all -> 0x0272 }
        L_0x0054:
            if (r13 == 0) goto L_0x0059
            java.lang.String r13 = "rowid <= ? and "
            goto L_0x005b
        L_0x0059:
            java.lang.String r13 = ""
        L_0x005b:
            java.lang.String r16 = java.lang.String.valueOf(r13)     // Catch:{ SQLiteException -> 0x0279, all -> 0x0272 }
            int r7 = r16.length()     // Catch:{ SQLiteException -> 0x0279, all -> 0x0272 }
            int r7 = r7 + 148
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0279, all -> 0x0272 }
            r3.<init>(r7)     // Catch:{ SQLiteException -> 0x0279, all -> 0x0272 }
            java.lang.String r7 = "select app_id, metadata_fingerprint from raw_events where "
            r3.append(r7)     // Catch:{ SQLiteException -> 0x0279, all -> 0x0272 }
            r3.append(r13)     // Catch:{ SQLiteException -> 0x0279, all -> 0x0272 }
            java.lang.String r7 = "app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;"
            r3.append(r7)     // Catch:{ SQLiteException -> 0x0279, all -> 0x0272 }
            java.lang.String r3 = r3.toString()     // Catch:{ SQLiteException -> 0x0279, all -> 0x0272 }
            android.database.Cursor r3 = r15.rawQuery(r3, r14)     // Catch:{ SQLiteException -> 0x0279, all -> 0x0272 }
            boolean r7 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x026d, all -> 0x0040 }
            if (r7 != 0) goto L_0x008c
            if (r3 == 0) goto L_0x0293
            r3.close()     // Catch:{ all -> 0x0df5 }
            goto L_0x0293
        L_0x008c:
            java.lang.String r7 = r3.getString(r11)     // Catch:{ SQLiteException -> 0x026d, all -> 0x0040 }
            java.lang.String r13 = r3.getString(r12)     // Catch:{ SQLiteException -> 0x009c, all -> 0x0040 }
            r3.close()     // Catch:{ SQLiteException -> 0x009c, all -> 0x0040 }
            r23 = r3
            r3 = r7
            r7 = r13
            goto L_0x00f8
        L_0x009c:
            r0 = move-exception
            r6 = r3
            goto L_0x0049
        L_0x009f:
            int r3 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r3 == 0) goto L_0x00b0
            java.lang.String[] r7 = new java.lang.String[r10]     // Catch:{ SQLiteException -> 0x0279, all -> 0x0272 }
            r13 = 0
            r7[r11] = r13     // Catch:{ SQLiteException -> 0x0279, all -> 0x0272 }
            java.lang.String r13 = java.lang.String.valueOf(r5)     // Catch:{ SQLiteException -> 0x0279, all -> 0x0272 }
            r7[r12] = r13     // Catch:{ SQLiteException -> 0x0279, all -> 0x0272 }
            r13 = r7
            goto L_0x00b5
        L_0x00b0:
            r7 = 0
            java.lang.String[] r13 = new java.lang.String[]{r7}     // Catch:{ SQLiteException -> 0x0279, all -> 0x0272 }
        L_0x00b5:
            if (r3 == 0) goto L_0x00ba
            java.lang.String r3 = " and rowid <= ?"
            goto L_0x00bc
        L_0x00ba:
            java.lang.String r3 = ""
        L_0x00bc:
            java.lang.String r7 = java.lang.String.valueOf(r3)     // Catch:{ SQLiteException -> 0x0279, all -> 0x0272 }
            int r7 = r7.length()     // Catch:{ SQLiteException -> 0x0279, all -> 0x0272 }
            int r7 = r7 + 84
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0279, all -> 0x0272 }
            r14.<init>(r7)     // Catch:{ SQLiteException -> 0x0279, all -> 0x0272 }
            java.lang.String r7 = "select metadata_fingerprint from raw_events where app_id = ?"
            r14.append(r7)     // Catch:{ SQLiteException -> 0x0279, all -> 0x0272 }
            r14.append(r3)     // Catch:{ SQLiteException -> 0x0279, all -> 0x0272 }
            java.lang.String r3 = " order by rowid limit 1;"
            r14.append(r3)     // Catch:{ SQLiteException -> 0x0279, all -> 0x0272 }
            java.lang.String r3 = r14.toString()     // Catch:{ SQLiteException -> 0x0279, all -> 0x0272 }
            android.database.Cursor r3 = r15.rawQuery(r3, r13)     // Catch:{ SQLiteException -> 0x0279, all -> 0x0272 }
            boolean r7 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x026d, all -> 0x0040 }
            if (r7 != 0) goto L_0x00ed
            if (r3 == 0) goto L_0x0293
            r3.close()     // Catch:{ all -> 0x0df5 }
            goto L_0x0293
        L_0x00ed:
            java.lang.String r13 = r3.getString(r11)     // Catch:{ SQLiteException -> 0x026d, all -> 0x0040 }
            r3.close()     // Catch:{ SQLiteException -> 0x026d, all -> 0x0040 }
            r23 = r3
            r7 = r13
            r3 = 0
        L_0x00f8:
            java.lang.String r14 = "raw_events_metadata"
            java.lang.String r13 = "metadata"
            java.lang.String[] r16 = new java.lang.String[]{r13}     // Catch:{ SQLiteException -> 0x0267, all -> 0x0262 }
            java.lang.String r17 = "app_id = ? and metadata_fingerprint = ?"
            java.lang.String[] r13 = new java.lang.String[r10]     // Catch:{ SQLiteException -> 0x0267, all -> 0x0262 }
            r13[r11] = r3     // Catch:{ SQLiteException -> 0x0267, all -> 0x0262 }
            r13[r12] = r7     // Catch:{ SQLiteException -> 0x0267, all -> 0x0262 }
            r18 = 0
            r19 = 0
            java.lang.String r20 = "rowid"
            java.lang.String r21 = "2"
            r24 = r13
            r13 = r15
            r25 = r15
            r15 = r16
            r16 = r17
            r17 = r24
            android.database.Cursor r15 = r13.query(r14, r15, r16, r17, r18, r19, r20, r21)     // Catch:{ SQLiteException -> 0x0267, all -> 0x0262 }
            boolean r13 = r15.moveToFirst()     // Catch:{ SQLiteException -> 0x025d, all -> 0x0257 }
            if (r13 != 0) goto L_0x0148
            com.google.android.gms.measurement.internal.zzas r5 = r4.zzgt()     // Catch:{ SQLiteException -> 0x0143, all -> 0x013d }
            com.google.android.gms.measurement.internal.zzau r5 = r5.zzjg()     // Catch:{ SQLiteException -> 0x0143, all -> 0x013d }
            java.lang.String r6 = "Raw event metadata record is missing. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzas.zzbw(r3)     // Catch:{ SQLiteException -> 0x0143, all -> 0x013d }
            r5.zzg(r6, r7)     // Catch:{ SQLiteException -> 0x0143, all -> 0x013d }
            if (r15 == 0) goto L_0x0293
            r15.close()     // Catch:{ all -> 0x0df5 }
            goto L_0x0293
        L_0x013d:
            r0 = move-exception
            r5 = r1
            r22 = r15
            goto L_0x0276
        L_0x0143:
            r0 = move-exception
            r7 = r3
            r6 = r15
            goto L_0x0049
        L_0x0148:
            byte[] r13 = r15.getBlob(r11)     // Catch:{ SQLiteException -> 0x025d, all -> 0x0257 }
            int r14 = r13.length     // Catch:{ SQLiteException -> 0x025d, all -> 0x0257 }
            com.google.android.gms.internal.measurement.zzxz r13 = com.google.android.gms.internal.measurement.zzxz.zzj(r13, r11, r14)     // Catch:{ SQLiteException -> 0x025d, all -> 0x0257 }
            com.google.android.gms.internal.measurement.zzfw r14 = new com.google.android.gms.internal.measurement.zzfw     // Catch:{ SQLiteException -> 0x025d, all -> 0x0257 }
            r14.<init>()     // Catch:{ SQLiteException -> 0x025d, all -> 0x0257 }
            r14.zza(r13)     // Catch:{ IOException -> 0x0239 }
            boolean r13 = r15.moveToNext()     // Catch:{ SQLiteException -> 0x025d, all -> 0x0257 }
            if (r13 == 0) goto L_0x0170
            com.google.android.gms.measurement.internal.zzas r13 = r4.zzgt()     // Catch:{ SQLiteException -> 0x0143, all -> 0x013d }
            com.google.android.gms.measurement.internal.zzau r13 = r13.zzjj()     // Catch:{ SQLiteException -> 0x0143, all -> 0x013d }
            java.lang.String r10 = "Get multiple raw event metadata records, expected one. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzas.zzbw(r3)     // Catch:{ SQLiteException -> 0x0143, all -> 0x013d }
            r13.zzg(r10, r12)     // Catch:{ SQLiteException -> 0x0143, all -> 0x013d }
        L_0x0170:
            r15.close()     // Catch:{ SQLiteException -> 0x025d, all -> 0x0257 }
            r2.zzb(r14)     // Catch:{ SQLiteException -> 0x025d, all -> 0x0257 }
            int r10 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x0190
            java.lang.String r10 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?"
            r12 = 3
            java.lang.String[] r13 = new java.lang.String[r12]     // Catch:{ SQLiteException -> 0x0143, all -> 0x013d }
            r13[r11] = r3     // Catch:{ SQLiteException -> 0x0143, all -> 0x013d }
            r12 = 1
            r13[r12] = r7     // Catch:{ SQLiteException -> 0x0143, all -> 0x013d }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ SQLiteException -> 0x0143, all -> 0x013d }
            r6 = 2
            r13[r6] = r5     // Catch:{ SQLiteException -> 0x0143, all -> 0x013d }
            r16 = r10
            r17 = r13
            goto L_0x019e
        L_0x0190:
            java.lang.String r5 = "app_id = ? and metadata_fingerprint = ?"
            r6 = 2
            java.lang.String[] r10 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x025d, all -> 0x0257 }
            r10[r11] = r3     // Catch:{ SQLiteException -> 0x025d, all -> 0x0257 }
            r6 = 1
            r10[r6] = r7     // Catch:{ SQLiteException -> 0x025d, all -> 0x0257 }
            r16 = r5
            r17 = r10
        L_0x019e:
            java.lang.String r14 = "raw_events"
            java.lang.String r5 = "rowid"
            java.lang.String r6 = "name"
            java.lang.String r7 = "timestamp"
            java.lang.String r10 = "data"
            java.lang.String[] r5 = new java.lang.String[]{r5, r6, r7, r10}     // Catch:{ SQLiteException -> 0x025d, all -> 0x0257 }
            r18 = 0
            r19 = 0
            java.lang.String r20 = "rowid"
            r21 = 0
            r13 = r25
            r6 = r15
            r15 = r5
            android.database.Cursor r5 = r13.query(r14, r15, r16, r17, r18, r19, r20, r21)     // Catch:{ SQLiteException -> 0x0255, all -> 0x0253 }
            boolean r6 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x0234, all -> 0x022f }
            if (r6 != 0) goto L_0x01da
            com.google.android.gms.measurement.internal.zzas r6 = r4.zzgt()     // Catch:{ SQLiteException -> 0x0234, all -> 0x022f }
            com.google.android.gms.measurement.internal.zzau r6 = r6.zzjj()     // Catch:{ SQLiteException -> 0x0234, all -> 0x022f }
            java.lang.String r7 = "Raw event data disappeared while in transaction. appId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzas.zzbw(r3)     // Catch:{ SQLiteException -> 0x0234, all -> 0x022f }
            r6.zzg(r7, r10)     // Catch:{ SQLiteException -> 0x0234, all -> 0x022f }
            if (r5 == 0) goto L_0x0293
            r5.close()     // Catch:{ all -> 0x0df5 }
            goto L_0x0293
        L_0x01da:
            long r6 = r5.getLong(r11)     // Catch:{ SQLiteException -> 0x0234, all -> 0x022f }
            r10 = 3
            byte[] r12 = r5.getBlob(r10)     // Catch:{ SQLiteException -> 0x0234, all -> 0x022f }
            int r10 = r12.length     // Catch:{ SQLiteException -> 0x0234, all -> 0x022f }
            com.google.android.gms.internal.measurement.zzxz r10 = com.google.android.gms.internal.measurement.zzxz.zzj(r12, r11, r10)     // Catch:{ SQLiteException -> 0x0234, all -> 0x022f }
            com.google.android.gms.internal.measurement.zzft r12 = new com.google.android.gms.internal.measurement.zzft     // Catch:{ SQLiteException -> 0x0234, all -> 0x022f }
            r12.<init>()     // Catch:{ SQLiteException -> 0x0234, all -> 0x022f }
            r12.zza(r10)     // Catch:{ IOException -> 0x020f }
            r10 = 1
            java.lang.String r13 = r5.getString(r10)     // Catch:{ SQLiteException -> 0x0234, all -> 0x022f }
            r12.name = r13     // Catch:{ SQLiteException -> 0x0234, all -> 0x022f }
            r10 = 2
            long r13 = r5.getLong(r10)     // Catch:{ SQLiteException -> 0x0234, all -> 0x022f }
            java.lang.Long r10 = java.lang.Long.valueOf(r13)     // Catch:{ SQLiteException -> 0x0234, all -> 0x022f }
            r12.zzaxb = r10     // Catch:{ SQLiteException -> 0x0234, all -> 0x022f }
            boolean r6 = r2.zza(r6, r12)     // Catch:{ SQLiteException -> 0x0234, all -> 0x022f }
            if (r6 != 0) goto L_0x0222
            if (r5 == 0) goto L_0x0293
            r5.close()     // Catch:{ all -> 0x0df5 }
            goto L_0x0293
        L_0x020f:
            r0 = move-exception
            r6 = r0
            com.google.android.gms.measurement.internal.zzas r7 = r4.zzgt()     // Catch:{ SQLiteException -> 0x0234, all -> 0x022f }
            com.google.android.gms.measurement.internal.zzau r7 = r7.zzjg()     // Catch:{ SQLiteException -> 0x0234, all -> 0x022f }
            java.lang.String r10 = "Data loss. Failed to merge raw event. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzas.zzbw(r3)     // Catch:{ SQLiteException -> 0x0234, all -> 0x022f }
            r7.zze(r10, r12, r6)     // Catch:{ SQLiteException -> 0x0234, all -> 0x022f }
        L_0x0222:
            boolean r6 = r5.moveToNext()     // Catch:{ SQLiteException -> 0x0234, all -> 0x022f }
            if (r6 != 0) goto L_0x01da
            if (r5 == 0) goto L_0x0293
            r5.close()     // Catch:{ all -> 0x0df5 }
            goto L_0x0293
        L_0x022f:
            r0 = move-exception
            r22 = r5
            r5 = r1
            goto L_0x0276
        L_0x0234:
            r0 = move-exception
            r7 = r3
            r6 = r5
            goto L_0x0049
        L_0x0239:
            r0 = move-exception
            r5 = r0
            r6 = r15
            com.google.android.gms.measurement.internal.zzas r7 = r4.zzgt()     // Catch:{ SQLiteException -> 0x0255, all -> 0x0253 }
            com.google.android.gms.measurement.internal.zzau r7 = r7.zzjg()     // Catch:{ SQLiteException -> 0x0255, all -> 0x0253 }
            java.lang.String r10 = "Data loss. Failed to merge raw event metadata. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzas.zzbw(r3)     // Catch:{ SQLiteException -> 0x0255, all -> 0x0253 }
            r7.zze(r10, r12, r5)     // Catch:{ SQLiteException -> 0x0255, all -> 0x0253 }
            if (r6 == 0) goto L_0x0293
            r6.close()     // Catch:{ all -> 0x0df5 }
            goto L_0x0293
        L_0x0253:
            r0 = move-exception
            goto L_0x0259
        L_0x0255:
            r0 = move-exception
            goto L_0x025f
        L_0x0257:
            r0 = move-exception
            r6 = r15
        L_0x0259:
            r5 = r1
            r22 = r6
            goto L_0x0276
        L_0x025d:
            r0 = move-exception
            r6 = r15
        L_0x025f:
            r7 = r3
            goto L_0x0049
        L_0x0262:
            r0 = move-exception
            r5 = r1
            r22 = r23
            goto L_0x0276
        L_0x0267:
            r0 = move-exception
            r7 = r3
            r6 = r23
            goto L_0x0049
        L_0x026d:
            r0 = move-exception
            r6 = r3
            r7 = 0
            goto L_0x0049
        L_0x0272:
            r0 = move-exception
            r5 = r1
            r22 = 0
        L_0x0276:
            r1 = r0
            goto L_0x0dec
        L_0x0279:
            r0 = move-exception
            r3 = r0
            r6 = 0
            r7 = 0
        L_0x027d:
            com.google.android.gms.measurement.internal.zzas r4 = r4.zzgt()     // Catch:{ all -> 0x0de7 }
            com.google.android.gms.measurement.internal.zzau r4 = r4.zzjg()     // Catch:{ all -> 0x0de7 }
            java.lang.String r5 = "Data loss. Error selecting raw event. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzas.zzbw(r7)     // Catch:{ all -> 0x0de7 }
            r4.zze(r5, r7, r3)     // Catch:{ all -> 0x0de7 }
            if (r6 == 0) goto L_0x0293
            r6.close()     // Catch:{ all -> 0x0df5 }
        L_0x0293:
            java.util.List<com.google.android.gms.internal.measurement.zzft> r3 = r2.zzaui     // Catch:{ all -> 0x0df5 }
            if (r3 == 0) goto L_0x02a2
            java.util.List<com.google.android.gms.internal.measurement.zzft> r3 = r2.zzaui     // Catch:{ all -> 0x0df5 }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x0df5 }
            if (r3 == 0) goto L_0x02a0
            goto L_0x02a2
        L_0x02a0:
            r3 = 0
            goto L_0x02a3
        L_0x02a2:
            r3 = 1
        L_0x02a3:
            if (r3 != 0) goto L_0x0dd6
            com.google.android.gms.internal.measurement.zzfw r3 = r2.zzaug     // Catch:{ all -> 0x0df5 }
            java.util.List<com.google.android.gms.internal.measurement.zzft> r4 = r2.zzaui     // Catch:{ all -> 0x0df5 }
            int r4 = r4.size()     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.internal.measurement.zzft[] r4 = new com.google.android.gms.internal.measurement.zzft[r4]     // Catch:{ all -> 0x0df5 }
            r3.zzaxi = r4     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.measurement.internal.zzbw r4 = r1.zzada     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.measurement.internal.zzq r4 = r4.zzgv()     // Catch:{ all -> 0x0df5 }
            java.lang.String r5 = r3.zztt     // Catch:{ all -> 0x0df5 }
            boolean r4 = r4.zzau(r5)     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.measurement.internal.zzbw r5 = r1.zzada     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.measurement.internal.zzq r5 = r5.zzgv()     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.internal.measurement.zzfw r6 = r2.zzaug     // Catch:{ all -> 0x0df5 }
            java.lang.String r6 = r6.zztt     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.measurement.internal.zzai$zza<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzai.zzala     // Catch:{ all -> 0x0df5 }
            boolean r5 = r5.zze(r6, r7)     // Catch:{ all -> 0x0df5 }
            r8 = 0
            r9 = 0
            r10 = 0
            r12 = 0
            r13 = 0
            r14 = 0
        L_0x02d4:
            java.util.List<com.google.android.gms.internal.measurement.zzft> r6 = r2.zzaui     // Catch:{ all -> 0x0df5 }
            int r6 = r6.size()     // Catch:{ all -> 0x0df5 }
            r16 = 1
            if (r10 >= r6) goto L_0x0780
            java.util.List<com.google.android.gms.internal.measurement.zzft> r6 = r2.zzaui     // Catch:{ all -> 0x0df5 }
            java.lang.Object r6 = r6.get(r10)     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.internal.measurement.zzft r6 = (com.google.android.gms.internal.measurement.zzft) r6     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.measurement.internal.zzbq r7 = r55.zzls()     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.internal.measurement.zzfw r11 = r2.zzaug     // Catch:{ all -> 0x0df5 }
            java.lang.String r11 = r11.zztt     // Catch:{ all -> 0x0df5 }
            r26 = r12
            java.lang.String r12 = r6.name     // Catch:{ all -> 0x0df5 }
            boolean r7 = r7.zzo(r11, r12)     // Catch:{ all -> 0x0df5 }
            if (r7 == 0) goto L_0x036b
            com.google.android.gms.measurement.internal.zzbw r7 = r1.zzada     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.measurement.internal.zzas r7 = r7.zzgt()     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.measurement.internal.zzau r7 = r7.zzjj()     // Catch:{ all -> 0x0df5 }
            java.lang.String r11 = "Dropping blacklisted raw event. appId"
            com.google.android.gms.internal.measurement.zzfw r12 = r2.zzaug     // Catch:{ all -> 0x0df5 }
            java.lang.String r12 = r12.zztt     // Catch:{ all -> 0x0df5 }
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzas.zzbw(r12)     // Catch:{ all -> 0x0df5 }
            r27 = r10
            com.google.android.gms.measurement.internal.zzbw r10 = r1.zzada     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.measurement.internal.zzaq r10 = r10.zzgq()     // Catch:{ all -> 0x0df5 }
            r28 = r13
            java.lang.String r13 = r6.name     // Catch:{ all -> 0x0df5 }
            java.lang.String r10 = r10.zzbt(r13)     // Catch:{ all -> 0x0df5 }
            r7.zze(r11, r12, r10)     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.measurement.internal.zzbq r7 = r55.zzls()     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.internal.measurement.zzfw r10 = r2.zzaug     // Catch:{ all -> 0x0df5 }
            java.lang.String r10 = r10.zztt     // Catch:{ all -> 0x0df5 }
            boolean r7 = r7.zzcl(r10)     // Catch:{ all -> 0x0df5 }
            if (r7 != 0) goto L_0x033e
            com.google.android.gms.measurement.internal.zzbq r7 = r55.zzls()     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.internal.measurement.zzfw r10 = r2.zzaug     // Catch:{ all -> 0x0df5 }
            java.lang.String r10 = r10.zztt     // Catch:{ all -> 0x0df5 }
            boolean r7 = r7.zzcm(r10)     // Catch:{ all -> 0x0df5 }
            if (r7 == 0) goto L_0x033c
            goto L_0x033e
        L_0x033c:
            r7 = 0
            goto L_0x033f
        L_0x033e:
            r7 = 1
        L_0x033f:
            if (r7 != 0) goto L_0x0364
            java.lang.String r7 = "_err"
            java.lang.String r10 = r6.name     // Catch:{ all -> 0x0df5 }
            boolean r7 = r7.equals(r10)     // Catch:{ all -> 0x0df5 }
            if (r7 != 0) goto L_0x0364
            com.google.android.gms.measurement.internal.zzbw r7 = r1.zzada     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.measurement.internal.zzfy r16 = r7.zzgr()     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.internal.measurement.zzfw r7 = r2.zzaug     // Catch:{ all -> 0x0df5 }
            java.lang.String r7 = r7.zztt     // Catch:{ all -> 0x0df5 }
            r18 = 11
            java.lang.String r19 = "_ev"
            java.lang.String r6 = r6.name     // Catch:{ all -> 0x0df5 }
            r21 = 0
            r17 = r7
            r20 = r6
            r16.zza(r17, r18, r19, r20, r21)     // Catch:{ all -> 0x0df5 }
        L_0x0364:
            r40 = r26
            r13 = r28
            r12 = 3
            goto L_0x0779
        L_0x036b:
            r27 = r10
            r28 = r13
            com.google.android.gms.measurement.internal.zzbq r7 = r55.zzls()     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.internal.measurement.zzfw r10 = r2.zzaug     // Catch:{ all -> 0x0df5 }
            java.lang.String r10 = r10.zztt     // Catch:{ all -> 0x0df5 }
            java.lang.String r11 = r6.name     // Catch:{ all -> 0x0df5 }
            boolean r7 = r7.zzp(r10, r11)     // Catch:{ all -> 0x0df5 }
            if (r7 != 0) goto L_0x03cb
            r55.zzjr()     // Catch:{ all -> 0x0df5 }
            java.lang.String r11 = r6.name     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r11)     // Catch:{ all -> 0x0df5 }
            int r12 = r11.hashCode()     // Catch:{ all -> 0x0df5 }
            r13 = 94660(0x171c4, float:1.32647E-40)
            if (r12 == r13) goto L_0x03af
            r13 = 95025(0x17331, float:1.33158E-40)
            if (r12 == r13) goto L_0x03a5
            r13 = 95027(0x17333, float:1.33161E-40)
            if (r12 == r13) goto L_0x039b
            goto L_0x03b9
        L_0x039b:
            java.lang.String r12 = "_ui"
            boolean r11 = r11.equals(r12)     // Catch:{ all -> 0x0df5 }
            if (r11 == 0) goto L_0x03b9
            r11 = 1
            goto L_0x03ba
        L_0x03a5:
            java.lang.String r12 = "_ug"
            boolean r11 = r11.equals(r12)     // Catch:{ all -> 0x0df5 }
            if (r11 == 0) goto L_0x03b9
            r11 = 2
            goto L_0x03ba
        L_0x03af:
            java.lang.String r12 = "_in"
            boolean r11 = r11.equals(r12)     // Catch:{ all -> 0x0df5 }
            if (r11 == 0) goto L_0x03b9
            r11 = 0
            goto L_0x03ba
        L_0x03b9:
            r11 = -1
        L_0x03ba:
            switch(r11) {
                case 0: goto L_0x03bf;
                case 1: goto L_0x03bf;
                case 2: goto L_0x03bf;
                default: goto L_0x03bd;
            }     // Catch:{ all -> 0x0df5 }
        L_0x03bd:
            r11 = 0
            goto L_0x03c0
        L_0x03bf:
            r11 = 1
        L_0x03c0:
            if (r11 == 0) goto L_0x03c3
            goto L_0x03cb
        L_0x03c3:
            r39 = r3
            r43 = r14
            r40 = r26
            goto L_0x05cf
        L_0x03cb:
            com.google.android.gms.internal.measurement.zzfu[] r11 = r6.zzaxa     // Catch:{ all -> 0x0df5 }
            if (r11 != 0) goto L_0x03d4
            r11 = 0
            com.google.android.gms.internal.measurement.zzfu[] r12 = new com.google.android.gms.internal.measurement.zzfu[r11]     // Catch:{ all -> 0x0df5 }
            r6.zzaxa = r12     // Catch:{ all -> 0x0df5 }
        L_0x03d4:
            com.google.android.gms.internal.measurement.zzfu[] r11 = r6.zzaxa     // Catch:{ all -> 0x0df5 }
            int r12 = r11.length     // Catch:{ all -> 0x0df5 }
            r13 = 0
            r18 = 0
            r19 = 0
        L_0x03dc:
            if (r13 >= r12) goto L_0x0410
            r10 = r11[r13]     // Catch:{ all -> 0x0df5 }
            r30 = r11
            java.lang.String r11 = "_c"
            r31 = r12
            java.lang.String r12 = r10.name     // Catch:{ all -> 0x0df5 }
            boolean r11 = r11.equals(r12)     // Catch:{ all -> 0x0df5 }
            if (r11 == 0) goto L_0x03f7
            java.lang.Long r11 = java.lang.Long.valueOf(r16)     // Catch:{ all -> 0x0df5 }
            r10.zzaxe = r11     // Catch:{ all -> 0x0df5 }
            r18 = 1
            goto L_0x0409
        L_0x03f7:
            java.lang.String r11 = "_r"
            java.lang.String r12 = r10.name     // Catch:{ all -> 0x0df5 }
            boolean r11 = r11.equals(r12)     // Catch:{ all -> 0x0df5 }
            if (r11 == 0) goto L_0x0409
            java.lang.Long r11 = java.lang.Long.valueOf(r16)     // Catch:{ all -> 0x0df5 }
            r10.zzaxe = r11     // Catch:{ all -> 0x0df5 }
            r19 = 1
        L_0x0409:
            int r13 = r13 + 1
            r11 = r30
            r12 = r31
            goto L_0x03dc
        L_0x0410:
            if (r18 != 0) goto L_0x0452
            if (r7 == 0) goto L_0x0452
            com.google.android.gms.measurement.internal.zzbw r10 = r1.zzada     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.measurement.internal.zzas r10 = r10.zzgt()     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.measurement.internal.zzau r10 = r10.zzjo()     // Catch:{ all -> 0x0df5 }
            java.lang.String r11 = "Marking event as conversion"
            com.google.android.gms.measurement.internal.zzbw r12 = r1.zzada     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.measurement.internal.zzaq r12 = r12.zzgq()     // Catch:{ all -> 0x0df5 }
            java.lang.String r13 = r6.name     // Catch:{ all -> 0x0df5 }
            java.lang.String r12 = r12.zzbt(r13)     // Catch:{ all -> 0x0df5 }
            r10.zzg(r11, r12)     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.internal.measurement.zzfu[] r10 = r6.zzaxa     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.internal.measurement.zzfu[] r11 = r6.zzaxa     // Catch:{ all -> 0x0df5 }
            int r11 = r11.length     // Catch:{ all -> 0x0df5 }
            r12 = 1
            int r11 = r11 + r12
            java.lang.Object[] r10 = java.util.Arrays.copyOf(r10, r11)     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.internal.measurement.zzfu[] r10 = (com.google.android.gms.internal.measurement.zzfu[]) r10     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.internal.measurement.zzfu r11 = new com.google.android.gms.internal.measurement.zzfu     // Catch:{ all -> 0x0df5 }
            r11.<init>()     // Catch:{ all -> 0x0df5 }
            java.lang.String r12 = "_c"
            r11.name = r12     // Catch:{ all -> 0x0df5 }
            java.lang.Long r12 = java.lang.Long.valueOf(r16)     // Catch:{ all -> 0x0df5 }
            r11.zzaxe = r12     // Catch:{ all -> 0x0df5 }
            int r12 = r10.length     // Catch:{ all -> 0x0df5 }
            r13 = 1
            int r12 = r12 - r13
            r10[r12] = r11     // Catch:{ all -> 0x0df5 }
            r6.zzaxa = r10     // Catch:{ all -> 0x0df5 }
        L_0x0452:
            if (r19 != 0) goto L_0x0492
            com.google.android.gms.measurement.internal.zzbw r10 = r1.zzada     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.measurement.internal.zzas r10 = r10.zzgt()     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.measurement.internal.zzau r10 = r10.zzjo()     // Catch:{ all -> 0x0df5 }
            java.lang.String r11 = "Marking event as real-time"
            com.google.android.gms.measurement.internal.zzbw r12 = r1.zzada     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.measurement.internal.zzaq r12 = r12.zzgq()     // Catch:{ all -> 0x0df5 }
            java.lang.String r13 = r6.name     // Catch:{ all -> 0x0df5 }
            java.lang.String r12 = r12.zzbt(r13)     // Catch:{ all -> 0x0df5 }
            r10.zzg(r11, r12)     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.internal.measurement.zzfu[] r10 = r6.zzaxa     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.internal.measurement.zzfu[] r11 = r6.zzaxa     // Catch:{ all -> 0x0df5 }
            int r11 = r11.length     // Catch:{ all -> 0x0df5 }
            r12 = 1
            int r11 = r11 + r12
            java.lang.Object[] r10 = java.util.Arrays.copyOf(r10, r11)     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.internal.measurement.zzfu[] r10 = (com.google.android.gms.internal.measurement.zzfu[]) r10     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.internal.measurement.zzfu r11 = new com.google.android.gms.internal.measurement.zzfu     // Catch:{ all -> 0x0df5 }
            r11.<init>()     // Catch:{ all -> 0x0df5 }
            java.lang.String r12 = "_r"
            r11.name = r12     // Catch:{ all -> 0x0df5 }
            java.lang.Long r12 = java.lang.Long.valueOf(r16)     // Catch:{ all -> 0x0df5 }
            r11.zzaxe = r12     // Catch:{ all -> 0x0df5 }
            int r12 = r10.length     // Catch:{ all -> 0x0df5 }
            r13 = 1
            int r12 = r12 - r13
            r10[r12] = r11     // Catch:{ all -> 0x0df5 }
            r6.zzaxa = r10     // Catch:{ all -> 0x0df5 }
        L_0x0492:
            com.google.android.gms.measurement.internal.zzt r30 = r55.zzjt()     // Catch:{ all -> 0x0df5 }
            long r31 = r55.zzly()     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.internal.measurement.zzfw r10 = r2.zzaug     // Catch:{ all -> 0x0df5 }
            java.lang.String r10 = r10.zztt     // Catch:{ all -> 0x0df5 }
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r38 = 1
            r33 = r10
            com.google.android.gms.measurement.internal.zzu r10 = r30.zza(r31, r33, r34, r35, r36, r37, r38)     // Catch:{ all -> 0x0df5 }
            long r10 = r10.zzahl     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.measurement.internal.zzbw r12 = r1.zzada     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.measurement.internal.zzq r12 = r12.zzgv()     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.internal.measurement.zzfw r13 = r2.zzaug     // Catch:{ all -> 0x0df5 }
            java.lang.String r13 = r13.zztt     // Catch:{ all -> 0x0df5 }
            int r12 = r12.zzaq(r13)     // Catch:{ all -> 0x0df5 }
            long r12 = (long) r12     // Catch:{ all -> 0x0df5 }
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 <= 0) goto L_0x0504
            r10 = 0
        L_0x04c4:
            com.google.android.gms.internal.measurement.zzfu[] r11 = r6.zzaxa     // Catch:{ all -> 0x0df5 }
            int r11 = r11.length     // Catch:{ all -> 0x0df5 }
            if (r10 >= r11) goto L_0x04ff
            java.lang.String r11 = "_r"
            com.google.android.gms.internal.measurement.zzfu[] r12 = r6.zzaxa     // Catch:{ all -> 0x0df5 }
            r12 = r12[r10]     // Catch:{ all -> 0x0df5 }
            java.lang.String r12 = r12.name     // Catch:{ all -> 0x0df5 }
            boolean r11 = r11.equals(r12)     // Catch:{ all -> 0x0df5 }
            if (r11 == 0) goto L_0x04fa
            com.google.android.gms.internal.measurement.zzfu[] r11 = r6.zzaxa     // Catch:{ all -> 0x0df5 }
            int r11 = r11.length     // Catch:{ all -> 0x0df5 }
            r12 = 1
            int r11 = r11 - r12
            com.google.android.gms.internal.measurement.zzfu[] r11 = new com.google.android.gms.internal.measurement.zzfu[r11]     // Catch:{ all -> 0x0df5 }
            if (r10 <= 0) goto L_0x04e6
            com.google.android.gms.internal.measurement.zzfu[] r12 = r6.zzaxa     // Catch:{ all -> 0x0df5 }
            r13 = 0
            java.lang.System.arraycopy(r12, r13, r11, r13, r10)     // Catch:{ all -> 0x0df5 }
        L_0x04e6:
            int r12 = r11.length     // Catch:{ all -> 0x0df5 }
            if (r10 >= r12) goto L_0x04f5
            com.google.android.gms.internal.measurement.zzfu[] r12 = r6.zzaxa     // Catch:{ all -> 0x0df5 }
            int r13 = r10 + 1
            r39 = r3
            int r3 = r11.length     // Catch:{ all -> 0x0df5 }
            int r3 = r3 - r10
            java.lang.System.arraycopy(r12, r13, r11, r10, r3)     // Catch:{ all -> 0x0df5 }
            goto L_0x04f7
        L_0x04f5:
            r39 = r3
        L_0x04f7:
            r6.zzaxa = r11     // Catch:{ all -> 0x0df5 }
            goto L_0x0501
        L_0x04fa:
            r39 = r3
            int r10 = r10 + 1
            goto L_0x04c4
        L_0x04ff:
            r39 = r3
        L_0x0501:
            r12 = r26
            goto L_0x0507
        L_0x0504:
            r39 = r3
            r12 = 1
        L_0x0507:
            java.lang.String r3 = r6.name     // Catch:{ all -> 0x0df5 }
            boolean r3 = com.google.android.gms.measurement.internal.zzfy.zzct(r3)     // Catch:{ all -> 0x0df5 }
            if (r3 == 0) goto L_0x05cb
            if (r7 == 0) goto L_0x05cb
            com.google.android.gms.measurement.internal.zzt r30 = r55.zzjt()     // Catch:{ all -> 0x0df5 }
            long r31 = r55.zzly()     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.internal.measurement.zzfw r3 = r2.zzaug     // Catch:{ all -> 0x0df5 }
            java.lang.String r3 = r3.zztt     // Catch:{ all -> 0x0df5 }
            r34 = 0
            r35 = 0
            r36 = 1
            r37 = 0
            r38 = 0
            r33 = r3
            com.google.android.gms.measurement.internal.zzu r3 = r30.zza(r31, r33, r34, r35, r36, r37, r38)     // Catch:{ all -> 0x0df5 }
            long r10 = r3.zzahj     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.measurement.internal.zzbw r3 = r1.zzada     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.measurement.internal.zzq r3 = r3.zzgv()     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.internal.measurement.zzfw r13 = r2.zzaug     // Catch:{ all -> 0x0df5 }
            java.lang.String r13 = r13.zztt     // Catch:{ all -> 0x0df5 }
            r40 = r12
            com.google.android.gms.measurement.internal.zzai$zza<java.lang.Integer> r12 = com.google.android.gms.measurement.internal.zzai.zzajh     // Catch:{ all -> 0x0df5 }
            int r3 = r3.zzb(r13, r12)     // Catch:{ all -> 0x0df5 }
            long r12 = (long) r3     // Catch:{ all -> 0x0df5 }
            int r3 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r3 <= 0) goto L_0x05cd
            com.google.android.gms.measurement.internal.zzbw r3 = r1.zzada     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.measurement.internal.zzas r3 = r3.zzgt()     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.measurement.internal.zzau r3 = r3.zzjj()     // Catch:{ all -> 0x0df5 }
            java.lang.String r10 = "Too many conversions. Not logging as conversion. appId"
            com.google.android.gms.internal.measurement.zzfw r11 = r2.zzaug     // Catch:{ all -> 0x0df5 }
            java.lang.String r11 = r11.zztt     // Catch:{ all -> 0x0df5 }
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzas.zzbw(r11)     // Catch:{ all -> 0x0df5 }
            r3.zzg(r10, r11)     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.internal.measurement.zzfu[] r3 = r6.zzaxa     // Catch:{ all -> 0x0df5 }
            int r10 = r3.length     // Catch:{ all -> 0x0df5 }
            r11 = 0
            r12 = 0
            r13 = 0
        L_0x0563:
            if (r11 >= r10) goto L_0x058d
            r41 = r10
            r10 = r3[r11]     // Catch:{ all -> 0x0df5 }
            r42 = r3
            java.lang.String r3 = "_c"
            r43 = r14
            java.lang.String r14 = r10.name     // Catch:{ all -> 0x0df5 }
            boolean r3 = r3.equals(r14)     // Catch:{ all -> 0x0df5 }
            if (r3 == 0) goto L_0x0579
            r13 = r10
            goto L_0x0584
        L_0x0579:
            java.lang.String r3 = "_err"
            java.lang.String r10 = r10.name     // Catch:{ all -> 0x0df5 }
            boolean r3 = r3.equals(r10)     // Catch:{ all -> 0x0df5 }
            if (r3 == 0) goto L_0x0584
            r12 = 1
        L_0x0584:
            int r11 = r11 + 1
            r10 = r41
            r3 = r42
            r14 = r43
            goto L_0x0563
        L_0x058d:
            r43 = r14
            if (r12 == 0) goto L_0x05a4
            if (r13 == 0) goto L_0x05a4
            com.google.android.gms.internal.measurement.zzfu[] r3 = r6.zzaxa     // Catch:{ all -> 0x0df5 }
            r10 = 1
            com.google.android.gms.internal.measurement.zzfu[] r11 = new com.google.android.gms.internal.measurement.zzfu[r10]     // Catch:{ all -> 0x0df5 }
            r10 = 0
            r11[r10] = r13     // Catch:{ all -> 0x0df5 }
            java.lang.Object[] r3 = com.google.android.gms.common.util.ArrayUtils.removeAll(r3, r11)     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.internal.measurement.zzfu[] r3 = (com.google.android.gms.internal.measurement.zzfu[]) r3     // Catch:{ all -> 0x0df5 }
            r6.zzaxa = r3     // Catch:{ all -> 0x0df5 }
            goto L_0x05cf
        L_0x05a4:
            if (r13 == 0) goto L_0x05b3
            java.lang.String r3 = "_err"
            r13.name = r3     // Catch:{ all -> 0x0df5 }
            r10 = 10
            java.lang.Long r3 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x0df5 }
            r13.zzaxe = r3     // Catch:{ all -> 0x0df5 }
            goto L_0x05cf
        L_0x05b3:
            com.google.android.gms.measurement.internal.zzbw r3 = r1.zzada     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.measurement.internal.zzas r3 = r3.zzgt()     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.measurement.internal.zzau r3 = r3.zzjg()     // Catch:{ all -> 0x0df5 }
            java.lang.String r10 = "Did not find conversion parameter. appId"
            com.google.android.gms.internal.measurement.zzfw r11 = r2.zzaug     // Catch:{ all -> 0x0df5 }
            java.lang.String r11 = r11.zztt     // Catch:{ all -> 0x0df5 }
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzas.zzbw(r11)     // Catch:{ all -> 0x0df5 }
            r3.zzg(r10, r11)     // Catch:{ all -> 0x0df5 }
            goto L_0x05cf
        L_0x05cb:
            r40 = r12
        L_0x05cd:
            r43 = r14
        L_0x05cf:
            com.google.android.gms.measurement.internal.zzbw r3 = r1.zzada     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.measurement.internal.zzq r3 = r3.zzgv()     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.internal.measurement.zzfw r10 = r2.zzaug     // Catch:{ all -> 0x0df5 }
            java.lang.String r10 = r10.zztt     // Catch:{ all -> 0x0df5 }
            boolean r3 = r3.zzbd(r10)     // Catch:{ all -> 0x0df5 }
            if (r3 == 0) goto L_0x068f
            if (r7 == 0) goto L_0x068f
            com.google.android.gms.internal.measurement.zzfu[] r3 = r6.zzaxa     // Catch:{ all -> 0x0df5 }
            r7 = 0
            r10 = -1
            r11 = -1
        L_0x05e6:
            int r12 = r3.length     // Catch:{ all -> 0x0df5 }
            if (r7 >= r12) goto L_0x0607
            java.lang.String r12 = "value"
            r13 = r3[r7]     // Catch:{ all -> 0x0df5 }
            java.lang.String r13 = r13.name     // Catch:{ all -> 0x0df5 }
            boolean r12 = r12.equals(r13)     // Catch:{ all -> 0x0df5 }
            if (r12 == 0) goto L_0x05f7
            r10 = r7
            goto L_0x0604
        L_0x05f7:
            java.lang.String r12 = "currency"
            r13 = r3[r7]     // Catch:{ all -> 0x0df5 }
            java.lang.String r13 = r13.name     // Catch:{ all -> 0x0df5 }
            boolean r12 = r12.equals(r13)     // Catch:{ all -> 0x0df5 }
            if (r12 == 0) goto L_0x0604
            r11 = r7
        L_0x0604:
            int r7 = r7 + 1
            goto L_0x05e6
        L_0x0607:
            r7 = -1
            if (r10 == r7) goto L_0x0637
            r7 = r3[r10]     // Catch:{ all -> 0x0df5 }
            java.lang.Long r7 = r7.zzaxe     // Catch:{ all -> 0x0df5 }
            if (r7 != 0) goto L_0x0639
            r7 = r3[r10]     // Catch:{ all -> 0x0df5 }
            java.lang.Double r7 = r7.zzaun     // Catch:{ all -> 0x0df5 }
            if (r7 != 0) goto L_0x0639
            com.google.android.gms.measurement.internal.zzbw r7 = r1.zzada     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.measurement.internal.zzas r7 = r7.zzgt()     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.measurement.internal.zzau r7 = r7.zzjl()     // Catch:{ all -> 0x0df5 }
            java.lang.String r11 = "Value must be specified with a numeric type."
            r7.zzby(r11)     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.internal.measurement.zzfu[] r3 = zza(r3, r10)     // Catch:{ all -> 0x0df5 }
            java.lang.String r7 = "_c"
            com.google.android.gms.internal.measurement.zzfu[] r3 = zza(r3, r7)     // Catch:{ all -> 0x0df5 }
            r7 = 18
            java.lang.String r10 = "value"
            com.google.android.gms.internal.measurement.zzfu[] r3 = zza(r3, r7, r10)     // Catch:{ all -> 0x0df5 }
        L_0x0637:
            r12 = 3
            goto L_0x068c
        L_0x0639:
            r7 = -1
            if (r11 != r7) goto L_0x063f
            r7 = 1
            r12 = 3
            goto L_0x0669
        L_0x063f:
            r7 = r3[r11]     // Catch:{ all -> 0x0df5 }
            java.lang.String r7 = r7.zzaml     // Catch:{ all -> 0x0df5 }
            if (r7 == 0) goto L_0x0667
            int r11 = r7.length()     // Catch:{ all -> 0x0df5 }
            r12 = 3
            if (r11 == r12) goto L_0x064d
            goto L_0x0668
        L_0x064d:
            r11 = 0
        L_0x064e:
            int r13 = r7.length()     // Catch:{ all -> 0x0df5 }
            if (r11 >= r13) goto L_0x0665
            int r13 = r7.codePointAt(r11)     // Catch:{ all -> 0x0df5 }
            boolean r14 = java.lang.Character.isLetter(r13)     // Catch:{ all -> 0x0df5 }
            if (r14 != 0) goto L_0x065f
            goto L_0x0668
        L_0x065f:
            int r13 = java.lang.Character.charCount(r13)     // Catch:{ all -> 0x0df5 }
            int r11 = r11 + r13
            goto L_0x064e
        L_0x0665:
            r7 = 0
            goto L_0x0669
        L_0x0667:
            r12 = 3
        L_0x0668:
            r7 = 1
        L_0x0669:
            if (r7 == 0) goto L_0x068c
            com.google.android.gms.measurement.internal.zzbw r7 = r1.zzada     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.measurement.internal.zzas r7 = r7.zzgt()     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.measurement.internal.zzau r7 = r7.zzjl()     // Catch:{ all -> 0x0df5 }
            java.lang.String r11 = "Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter."
            r7.zzby(r11)     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.internal.measurement.zzfu[] r3 = zza(r3, r10)     // Catch:{ all -> 0x0df5 }
            java.lang.String r7 = "_c"
            com.google.android.gms.internal.measurement.zzfu[] r3 = zza(r3, r7)     // Catch:{ all -> 0x0df5 }
            r7 = 19
            java.lang.String r10 = "currency"
            com.google.android.gms.internal.measurement.zzfu[] r3 = zza(r3, r7, r10)     // Catch:{ all -> 0x0df5 }
        L_0x068c:
            r6.zzaxa = r3     // Catch:{ all -> 0x0df5 }
            goto L_0x0690
        L_0x068f:
            r12 = 3
        L_0x0690:
            com.google.android.gms.measurement.internal.zzbw r3 = r1.zzada     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.measurement.internal.zzq r3 = r3.zzgv()     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.internal.measurement.zzfw r7 = r2.zzaug     // Catch:{ all -> 0x0df5 }
            java.lang.String r7 = r7.zztt     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.measurement.internal.zzai$zza<java.lang.Boolean> r10 = com.google.android.gms.measurement.internal.zzai.zzakz     // Catch:{ all -> 0x0df5 }
            boolean r3 = r3.zze(r7, r10)     // Catch:{ all -> 0x0df5 }
            if (r3 == 0) goto L_0x0711
            java.lang.String r3 = "_e"
            java.lang.String r7 = r6.name     // Catch:{ all -> 0x0df5 }
            boolean r3 = r3.equals(r7)     // Catch:{ all -> 0x0df5 }
            r10 = 1000(0x3e8, double:4.94E-321)
            if (r3 == 0) goto L_0x06dc
            r55.zzjr()     // Catch:{ all -> 0x0df5 }
            java.lang.String r3 = "_fr"
            com.google.android.gms.internal.measurement.zzfu r3 = com.google.android.gms.measurement.internal.zzfu.zza(r6, r3)     // Catch:{ all -> 0x0df5 }
            if (r3 != 0) goto L_0x0711
            if (r9 == 0) goto L_0x06da
            java.lang.Long r3 = r9.zzaxb     // Catch:{ all -> 0x0df5 }
            long r7 = r3.longValue()     // Catch:{ all -> 0x0df5 }
            java.lang.Long r3 = r6.zzaxb     // Catch:{ all -> 0x0df5 }
            long r13 = r3.longValue()     // Catch:{ all -> 0x0df5 }
            r3 = 0
            long r7 = r7 - r13
            long r7 = java.lang.Math.abs(r7)     // Catch:{ all -> 0x0df5 }
            int r3 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r3 > 0) goto L_0x06da
            boolean r3 = r1.zza(r6, r9)     // Catch:{ all -> 0x0df5 }
            if (r3 == 0) goto L_0x06da
        L_0x06d7:
            r8 = 0
            r9 = 0
            goto L_0x0711
        L_0x06da:
            r8 = r6
            goto L_0x0711
        L_0x06dc:
            java.lang.String r3 = "_vs"
            java.lang.String r7 = r6.name     // Catch:{ all -> 0x0df5 }
            boolean r3 = r3.equals(r7)     // Catch:{ all -> 0x0df5 }
            if (r3 == 0) goto L_0x0711
            r55.zzjr()     // Catch:{ all -> 0x0df5 }
            java.lang.String r3 = "_et"
            com.google.android.gms.internal.measurement.zzfu r3 = com.google.android.gms.measurement.internal.zzfu.zza(r6, r3)     // Catch:{ all -> 0x0df5 }
            if (r3 != 0) goto L_0x0711
            if (r8 == 0) goto L_0x0710
            java.lang.Long r3 = r8.zzaxb     // Catch:{ all -> 0x0df5 }
            long r13 = r3.longValue()     // Catch:{ all -> 0x0df5 }
            java.lang.Long r3 = r6.zzaxb     // Catch:{ all -> 0x0df5 }
            long r15 = r3.longValue()     // Catch:{ all -> 0x0df5 }
            r3 = 0
            long r13 = r13 - r15
            long r13 = java.lang.Math.abs(r13)     // Catch:{ all -> 0x0df5 }
            int r3 = (r13 > r10 ? 1 : (r13 == r10 ? 0 : -1))
            if (r3 > 0) goto L_0x0710
            boolean r3 = r1.zza(r8, r6)     // Catch:{ all -> 0x0df5 }
            if (r3 == 0) goto L_0x0710
            goto L_0x06d7
        L_0x0710:
            r9 = r6
        L_0x0711:
            if (r4 == 0) goto L_0x076f
            if (r5 != 0) goto L_0x076f
            java.lang.String r3 = "_e"
            java.lang.String r7 = r6.name     // Catch:{ all -> 0x0df5 }
            boolean r3 = r3.equals(r7)     // Catch:{ all -> 0x0df5 }
            if (r3 == 0) goto L_0x076f
            com.google.android.gms.internal.measurement.zzfu[] r3 = r6.zzaxa     // Catch:{ all -> 0x0df5 }
            if (r3 == 0) goto L_0x0758
            com.google.android.gms.internal.measurement.zzfu[] r3 = r6.zzaxa     // Catch:{ all -> 0x0df5 }
            int r3 = r3.length     // Catch:{ all -> 0x0df5 }
            if (r3 != 0) goto L_0x0729
            goto L_0x0758
        L_0x0729:
            r55.zzjr()     // Catch:{ all -> 0x0df5 }
            java.lang.String r3 = "_et"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzfu.zzb(r6, r3)     // Catch:{ all -> 0x0df5 }
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ all -> 0x0df5 }
            if (r3 != 0) goto L_0x074e
            com.google.android.gms.measurement.internal.zzbw r3 = r1.zzada     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.measurement.internal.zzas r3 = r3.zzgt()     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.measurement.internal.zzau r3 = r3.zzjj()     // Catch:{ all -> 0x0df5 }
            java.lang.String r7 = "Engagement event does not include duration. appId"
            com.google.android.gms.internal.measurement.zzfw r10 = r2.zzaug     // Catch:{ all -> 0x0df5 }
            java.lang.String r10 = r10.zztt     // Catch:{ all -> 0x0df5 }
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzas.zzbw(r10)     // Catch:{ all -> 0x0df5 }
            r3.zzg(r7, r10)     // Catch:{ all -> 0x0df5 }
            goto L_0x076f
        L_0x074e:
            long r10 = r3.longValue()     // Catch:{ all -> 0x0df5 }
            r3 = 0
            long r14 = r43 + r10
            r3 = r39
            goto L_0x0773
        L_0x0758:
            com.google.android.gms.measurement.internal.zzbw r3 = r1.zzada     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.measurement.internal.zzas r3 = r3.zzgt()     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.measurement.internal.zzau r3 = r3.zzjj()     // Catch:{ all -> 0x0df5 }
            java.lang.String r7 = "Engagement event does not contain any parameters. appId"
            com.google.android.gms.internal.measurement.zzfw r10 = r2.zzaug     // Catch:{ all -> 0x0df5 }
            java.lang.String r10 = r10.zztt     // Catch:{ all -> 0x0df5 }
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzas.zzbw(r10)     // Catch:{ all -> 0x0df5 }
            r3.zzg(r7, r10)     // Catch:{ all -> 0x0df5 }
        L_0x076f:
            r3 = r39
            r14 = r43
        L_0x0773:
            com.google.android.gms.internal.measurement.zzft[] r7 = r3.zzaxi     // Catch:{ all -> 0x0df5 }
            int r13 = r28 + 1
            r7[r28] = r6     // Catch:{ all -> 0x0df5 }
        L_0x0779:
            int r10 = r27 + 1
            r12 = r40
            r11 = 0
            goto L_0x02d4
        L_0x0780:
            r26 = r12
            r28 = r13
            r43 = r14
            if (r5 == 0) goto L_0x07de
            r13 = r28
            r14 = r43
            r5 = 0
        L_0x078d:
            if (r5 >= r13) goto L_0x07e2
            com.google.android.gms.internal.measurement.zzft[] r6 = r3.zzaxi     // Catch:{ all -> 0x0df5 }
            r6 = r6[r5]     // Catch:{ all -> 0x0df5 }
            java.lang.String r7 = "_e"
            java.lang.String r8 = r6.name     // Catch:{ all -> 0x0df5 }
            boolean r7 = r7.equals(r8)     // Catch:{ all -> 0x0df5 }
            if (r7 == 0) goto L_0x07ba
            r55.zzjr()     // Catch:{ all -> 0x0df5 }
            java.lang.String r7 = "_fr"
            com.google.android.gms.internal.measurement.zzfu r7 = com.google.android.gms.measurement.internal.zzfu.zza(r6, r7)     // Catch:{ all -> 0x0df5 }
            if (r7 == 0) goto L_0x07ba
            com.google.android.gms.internal.measurement.zzft[] r6 = r3.zzaxi     // Catch:{ all -> 0x0df5 }
            int r7 = r5 + 1
            com.google.android.gms.internal.measurement.zzft[] r8 = r3.zzaxi     // Catch:{ all -> 0x0df5 }
            int r9 = r13 - r5
            r10 = 1
            int r9 = r9 - r10
            java.lang.System.arraycopy(r6, r7, r8, r5, r9)     // Catch:{ all -> 0x0df5 }
            int r13 = r13 + -1
            int r5 = r5 + -1
            goto L_0x07db
        L_0x07ba:
            if (r4 == 0) goto L_0x07db
            r55.zzjr()     // Catch:{ all -> 0x0df5 }
            java.lang.String r7 = "_et"
            com.google.android.gms.internal.measurement.zzfu r6 = com.google.android.gms.measurement.internal.zzfu.zza(r6, r7)     // Catch:{ all -> 0x0df5 }
            if (r6 == 0) goto L_0x07db
            java.lang.Long r6 = r6.zzaxe     // Catch:{ all -> 0x0df5 }
            if (r6 == 0) goto L_0x07db
            long r7 = r6.longValue()     // Catch:{ all -> 0x0df5 }
            r9 = 0
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 <= 0) goto L_0x07db
            long r6 = r6.longValue()     // Catch:{ all -> 0x0df5 }
            r8 = 0
            long r14 = r14 + r6
        L_0x07db:
            r6 = 1
            int r5 = r5 + r6
            goto L_0x078d
        L_0x07de:
            r13 = r28
            r14 = r43
        L_0x07e2:
            java.util.List<com.google.android.gms.internal.measurement.zzft> r5 = r2.zzaui     // Catch:{ all -> 0x0df5 }
            int r5 = r5.size()     // Catch:{ all -> 0x0df5 }
            if (r13 >= r5) goto L_0x07f4
            com.google.android.gms.internal.measurement.zzft[] r5 = r3.zzaxi     // Catch:{ all -> 0x0df5 }
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r5, r13)     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.internal.measurement.zzft[] r5 = (com.google.android.gms.internal.measurement.zzft[]) r5     // Catch:{ all -> 0x0df5 }
            r3.zzaxi = r5     // Catch:{ all -> 0x0df5 }
        L_0x07f4:
            if (r4 == 0) goto L_0x08c3
            com.google.android.gms.measurement.internal.zzt r4 = r55.zzjt()     // Catch:{ all -> 0x0df5 }
            java.lang.String r5 = r3.zztt     // Catch:{ all -> 0x0df5 }
            java.lang.String r6 = "_lte"
            com.google.android.gms.measurement.internal.zzfx r4 = r4.zzi(r5, r6)     // Catch:{ all -> 0x0df5 }
            if (r4 == 0) goto L_0x082f
            java.lang.Object r5 = r4.value     // Catch:{ all -> 0x0df5 }
            if (r5 != 0) goto L_0x0809
            goto L_0x082f
        L_0x0809:
            com.google.android.gms.measurement.internal.zzfx r5 = new com.google.android.gms.measurement.internal.zzfx     // Catch:{ all -> 0x0df5 }
            java.lang.String r7 = r3.zztt     // Catch:{ all -> 0x0df5 }
            java.lang.String r8 = "auto"
            java.lang.String r9 = "_lte"
            com.google.android.gms.measurement.internal.zzbw r6 = r1.zzada     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.common.util.Clock r6 = r6.zzbx()     // Catch:{ all -> 0x0df5 }
            long r10 = r6.currentTimeMillis()     // Catch:{ all -> 0x0df5 }
            java.lang.Object r4 = r4.value     // Catch:{ all -> 0x0df5 }
            java.lang.Long r4 = (java.lang.Long) r4     // Catch:{ all -> 0x0df5 }
            long r12 = r4.longValue()     // Catch:{ all -> 0x0df5 }
            r4 = 0
            long r12 = r12 + r14
            java.lang.Long r12 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x0df5 }
            r6 = r5
            r6.<init>(r7, r8, r9, r10, r12)     // Catch:{ all -> 0x0df5 }
            r4 = r5
            goto L_0x084c
        L_0x082f:
            com.google.android.gms.measurement.internal.zzfx r4 = new com.google.android.gms.measurement.internal.zzfx     // Catch:{ all -> 0x0df5 }
            java.lang.String r5 = r3.zztt     // Catch:{ all -> 0x0df5 }
            java.lang.String r29 = "auto"
            java.lang.String r30 = "_lte"
            com.google.android.gms.measurement.internal.zzbw r6 = r1.zzada     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.common.util.Clock r6 = r6.zzbx()     // Catch:{ all -> 0x0df5 }
            long r31 = r6.currentTimeMillis()     // Catch:{ all -> 0x0df5 }
            java.lang.Long r33 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x0df5 }
            r27 = r4
            r28 = r5
            r27.<init>(r28, r29, r30, r31, r33)     // Catch:{ all -> 0x0df5 }
        L_0x084c:
            com.google.android.gms.internal.measurement.zzfz r5 = new com.google.android.gms.internal.measurement.zzfz     // Catch:{ all -> 0x0df5 }
            r5.<init>()     // Catch:{ all -> 0x0df5 }
            java.lang.String r6 = "_lte"
            r5.name = r6     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.measurement.internal.zzbw r6 = r1.zzada     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.common.util.Clock r6 = r6.zzbx()     // Catch:{ all -> 0x0df5 }
            long r6 = r6.currentTimeMillis()     // Catch:{ all -> 0x0df5 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0df5 }
            r5.zzayu = r6     // Catch:{ all -> 0x0df5 }
            java.lang.Object r6 = r4.value     // Catch:{ all -> 0x0df5 }
            java.lang.Long r6 = (java.lang.Long) r6     // Catch:{ all -> 0x0df5 }
            r5.zzaxe = r6     // Catch:{ all -> 0x0df5 }
            r6 = 0
        L_0x086c:
            com.google.android.gms.internal.measurement.zzfz[] r7 = r3.zzaxj     // Catch:{ all -> 0x0df5 }
            int r7 = r7.length     // Catch:{ all -> 0x0df5 }
            if (r6 >= r7) goto L_0x0888
            java.lang.String r7 = "_lte"
            com.google.android.gms.internal.measurement.zzfz[] r8 = r3.zzaxj     // Catch:{ all -> 0x0df5 }
            r8 = r8[r6]     // Catch:{ all -> 0x0df5 }
            java.lang.String r8 = r8.name     // Catch:{ all -> 0x0df5 }
            boolean r7 = r7.equals(r8)     // Catch:{ all -> 0x0df5 }
            if (r7 == 0) goto L_0x0885
            com.google.android.gms.internal.measurement.zzfz[] r7 = r3.zzaxj     // Catch:{ all -> 0x0df5 }
            r7[r6] = r5     // Catch:{ all -> 0x0df5 }
            r6 = 1
            goto L_0x0889
        L_0x0885:
            int r6 = r6 + 1
            goto L_0x086c
        L_0x0888:
            r6 = 0
        L_0x0889:
            if (r6 != 0) goto L_0x08a5
            com.google.android.gms.internal.measurement.zzfz[] r6 = r3.zzaxj     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.internal.measurement.zzfz[] r7 = r3.zzaxj     // Catch:{ all -> 0x0df5 }
            int r7 = r7.length     // Catch:{ all -> 0x0df5 }
            r8 = 1
            int r7 = r7 + r8
            java.lang.Object[] r6 = java.util.Arrays.copyOf(r6, r7)     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.internal.measurement.zzfz[] r6 = (com.google.android.gms.internal.measurement.zzfz[]) r6     // Catch:{ all -> 0x0df5 }
            r3.zzaxj = r6     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.internal.measurement.zzfz[] r6 = r3.zzaxj     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.internal.measurement.zzfw r7 = r2.zzaug     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.internal.measurement.zzfz[] r7 = r7.zzaxj     // Catch:{ all -> 0x0df5 }
            int r7 = r7.length     // Catch:{ all -> 0x0df5 }
            r8 = 1
            int r7 = r7 - r8
            r6[r7] = r5     // Catch:{ all -> 0x0df5 }
        L_0x08a5:
            r5 = 0
            int r7 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x08c3
            com.google.android.gms.measurement.internal.zzt r5 = r55.zzjt()     // Catch:{ all -> 0x0df5 }
            r5.zza(r4)     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.measurement.internal.zzbw r5 = r1.zzada     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.measurement.internal.zzas r5 = r5.zzgt()     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.measurement.internal.zzau r5 = r5.zzjn()     // Catch:{ all -> 0x0df5 }
            java.lang.String r6 = "Updated lifetime engagement user property with value. Value"
            java.lang.Object r4 = r4.value     // Catch:{ all -> 0x0df5 }
            r5.zzg(r6, r4)     // Catch:{ all -> 0x0df5 }
        L_0x08c3:
            java.lang.String r4 = r3.zztt     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.internal.measurement.zzfz[] r5 = r3.zzaxj     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.internal.measurement.zzft[] r6 = r3.zzaxi     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r4)     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.measurement.internal.zzm r7 = r55.zzjs()     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.internal.measurement.zzfr[] r4 = r7.zza(r4, r6, r5)     // Catch:{ all -> 0x0df5 }
            r3.zzaya = r4     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.measurement.internal.zzbw r4 = r1.zzada     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.measurement.internal.zzq r4 = r4.zzgv()     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.internal.measurement.zzfw r5 = r2.zzaug     // Catch:{ all -> 0x0df5 }
            java.lang.String r5 = r5.zztt     // Catch:{ all -> 0x0df5 }
            boolean r4 = r4.zzat(r5)     // Catch:{ all -> 0x0df5 }
            if (r4 == 0) goto L_0x0c09
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ all -> 0x0c03 }
            r4.<init>()     // Catch:{ all -> 0x0c03 }
            com.google.android.gms.internal.measurement.zzft[] r5 = r3.zzaxi     // Catch:{ all -> 0x0c03 }
            int r5 = r5.length     // Catch:{ all -> 0x0c03 }
            com.google.android.gms.internal.measurement.zzft[] r5 = new com.google.android.gms.internal.measurement.zzft[r5]     // Catch:{ all -> 0x0c03 }
            com.google.android.gms.measurement.internal.zzbw r6 = r1.zzada     // Catch:{ all -> 0x0c03 }
            com.google.android.gms.measurement.internal.zzfy r6 = r6.zzgr()     // Catch:{ all -> 0x0c03 }
            java.security.SecureRandom r6 = r6.zzmk()     // Catch:{ all -> 0x0c03 }
            com.google.android.gms.internal.measurement.zzft[] r7 = r3.zzaxi     // Catch:{ all -> 0x0c03 }
            int r8 = r7.length     // Catch:{ all -> 0x0c03 }
            r9 = 0
            r10 = 0
        L_0x08ff:
            if (r9 >= r8) goto L_0x0bd1
            r11 = r7[r9]     // Catch:{ all -> 0x0c03 }
            java.lang.String r12 = r11.name     // Catch:{ all -> 0x0c03 }
            java.lang.String r13 = "_ep"
            boolean r12 = r12.equals(r13)     // Catch:{ all -> 0x0c03 }
            if (r12 == 0) goto L_0x098a
            r55.zzjr()     // Catch:{ all -> 0x0df5 }
            java.lang.String r12 = "_en"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzfu.zzb(r11, r12)     // Catch:{ all -> 0x0df5 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x0df5 }
            java.lang.Object r13 = r4.get(r12)     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.measurement.internal.zzac r13 = (com.google.android.gms.measurement.internal.zzac) r13     // Catch:{ all -> 0x0df5 }
            if (r13 != 0) goto L_0x092f
            com.google.android.gms.measurement.internal.zzt r13 = r55.zzjt()     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.internal.measurement.zzfw r14 = r2.zzaug     // Catch:{ all -> 0x0df5 }
            java.lang.String r14 = r14.zztt     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.measurement.internal.zzac r13 = r13.zzg(r14, r12)     // Catch:{ all -> 0x0df5 }
            r4.put(r12, r13)     // Catch:{ all -> 0x0df5 }
        L_0x092f:
            java.lang.Long r12 = r13.zzaia     // Catch:{ all -> 0x0df5 }
            if (r12 != 0) goto L_0x097c
            java.lang.Long r12 = r13.zzaib     // Catch:{ all -> 0x0df5 }
            long r14 = r12.longValue()     // Catch:{ all -> 0x0df5 }
            int r12 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r12 <= 0) goto L_0x094c
            r55.zzjr()     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.internal.measurement.zzfu[] r12 = r11.zzaxa     // Catch:{ all -> 0x0df5 }
            java.lang.String r14 = "_sr"
            java.lang.Long r15 = r13.zzaib     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.internal.measurement.zzfu[] r12 = com.google.android.gms.measurement.internal.zzfu.zza(r12, r14, r15)     // Catch:{ all -> 0x0df5 }
            r11.zzaxa = r12     // Catch:{ all -> 0x0df5 }
        L_0x094c:
            java.lang.Boolean r12 = r13.zzaic     // Catch:{ all -> 0x0df5 }
            if (r12 == 0) goto L_0x0969
            java.lang.Boolean r12 = r13.zzaic     // Catch:{ all -> 0x0df5 }
            boolean r12 = r12.booleanValue()     // Catch:{ all -> 0x0df5 }
            if (r12 == 0) goto L_0x0969
            r55.zzjr()     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.internal.measurement.zzfu[] r12 = r11.zzaxa     // Catch:{ all -> 0x0df5 }
            java.lang.String r13 = "_efs"
            java.lang.Long r14 = java.lang.Long.valueOf(r16)     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.internal.measurement.zzfu[] r12 = com.google.android.gms.measurement.internal.zzfu.zza(r12, r13, r14)     // Catch:{ all -> 0x0df5 }
            r11.zzaxa = r12     // Catch:{ all -> 0x0df5 }
        L_0x0969:
            int r12 = r10 + 1
            r5[r10] = r11     // Catch:{ all -> 0x0df5 }
            r53 = r2
            r47 = r3
            r52 = r6
            r45 = r7
            r46 = r8
            r48 = r9
            r10 = r12
            goto L_0x0bc1
        L_0x097c:
            r53 = r2
            r47 = r3
            r52 = r6
            r45 = r7
            r46 = r8
            r48 = r9
            goto L_0x0bc1
        L_0x098a:
            com.google.android.gms.measurement.internal.zzbq r12 = r55.zzls()     // Catch:{ all -> 0x0c03 }
            com.google.android.gms.internal.measurement.zzfw r13 = r2.zzaug     // Catch:{ all -> 0x0c03 }
            java.lang.String r13 = r13.zztt     // Catch:{ all -> 0x0c03 }
            long r12 = r12.zzck(r13)     // Catch:{ all -> 0x0c03 }
            com.google.android.gms.measurement.internal.zzbw r14 = r1.zzada     // Catch:{ all -> 0x0c03 }
            r14.zzgr()     // Catch:{ all -> 0x0c03 }
            java.lang.Long r14 = r11.zzaxb     // Catch:{ all -> 0x0c03 }
            long r14 = r14.longValue()     // Catch:{ all -> 0x0c03 }
            long r14 = com.google.android.gms.measurement.internal.zzfy.zzc(r14, r12)     // Catch:{ all -> 0x0c03 }
            r45 = r7
            java.lang.String r7 = "_dbg"
            r46 = r8
            java.lang.Long r8 = java.lang.Long.valueOf(r16)     // Catch:{ all -> 0x0c03 }
            boolean r18 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0c03 }
            if (r18 != 0) goto L_0x09fb
            if (r8 != 0) goto L_0x09b8
            goto L_0x09fb
        L_0x09b8:
            r47 = r3
            com.google.android.gms.internal.measurement.zzfu[] r3 = r11.zzaxa     // Catch:{ all -> 0x0df5 }
            r48 = r9
            int r9 = r3.length     // Catch:{ all -> 0x0df5 }
            r49 = r12
            r12 = 0
        L_0x09c2:
            if (r12 >= r9) goto L_0x0a01
            r13 = r3[r12]     // Catch:{ all -> 0x0df5 }
            r51 = r3
            java.lang.String r3 = r13.name     // Catch:{ all -> 0x0df5 }
            boolean r3 = r7.equals(r3)     // Catch:{ all -> 0x0df5 }
            if (r3 == 0) goto L_0x09f6
            boolean r3 = r8 instanceof java.lang.Long     // Catch:{ all -> 0x0df5 }
            if (r3 == 0) goto L_0x09dc
            java.lang.Long r3 = r13.zzaxe     // Catch:{ all -> 0x0df5 }
            boolean r3 = r8.equals(r3)     // Catch:{ all -> 0x0df5 }
            if (r3 != 0) goto L_0x09f4
        L_0x09dc:
            boolean r3 = r8 instanceof java.lang.String     // Catch:{ all -> 0x0df5 }
            if (r3 == 0) goto L_0x09e8
            java.lang.String r3 = r13.zzaml     // Catch:{ all -> 0x0df5 }
            boolean r3 = r8.equals(r3)     // Catch:{ all -> 0x0df5 }
            if (r3 != 0) goto L_0x09f4
        L_0x09e8:
            boolean r3 = r8 instanceof java.lang.Double     // Catch:{ all -> 0x0df5 }
            if (r3 == 0) goto L_0x0a01
            java.lang.Double r3 = r13.zzaun     // Catch:{ all -> 0x0df5 }
            boolean r3 = r8.equals(r3)     // Catch:{ all -> 0x0df5 }
            if (r3 == 0) goto L_0x0a01
        L_0x09f4:
            r3 = 1
            goto L_0x0a02
        L_0x09f6:
            int r12 = r12 + 1
            r3 = r51
            goto L_0x09c2
        L_0x09fb:
            r47 = r3
            r48 = r9
            r49 = r12
        L_0x0a01:
            r3 = 0
        L_0x0a02:
            if (r3 != 0) goto L_0x0a13
            com.google.android.gms.measurement.internal.zzbq r3 = r55.zzls()     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.internal.measurement.zzfw r7 = r2.zzaug     // Catch:{ all -> 0x0df5 }
            java.lang.String r7 = r7.zztt     // Catch:{ all -> 0x0df5 }
            java.lang.String r8 = r11.name     // Catch:{ all -> 0x0df5 }
            int r12 = r3.zzq(r7, r8)     // Catch:{ all -> 0x0df5 }
            goto L_0x0a14
        L_0x0a13:
            r12 = 1
        L_0x0a14:
            if (r12 > 0) goto L_0x0a36
            com.google.android.gms.measurement.internal.zzbw r3 = r1.zzada     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.measurement.internal.zzas r3 = r3.zzgt()     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.measurement.internal.zzau r3 = r3.zzjj()     // Catch:{ all -> 0x0df5 }
            java.lang.String r7 = "Sample rate must be positive. event, rate"
            java.lang.String r8 = r11.name     // Catch:{ all -> 0x0df5 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r12)     // Catch:{ all -> 0x0df5 }
            r3.zze(r7, r8, r9)     // Catch:{ all -> 0x0df5 }
            int r3 = r10 + 1
            r5[r10] = r11     // Catch:{ all -> 0x0df5 }
            r53 = r2
            r10 = r3
            r52 = r6
            goto L_0x0bc1
        L_0x0a36:
            java.lang.String r3 = r11.name     // Catch:{ all -> 0x0c03 }
            java.lang.Object r3 = r4.get(r3)     // Catch:{ all -> 0x0c03 }
            com.google.android.gms.measurement.internal.zzac r3 = (com.google.android.gms.measurement.internal.zzac) r3     // Catch:{ all -> 0x0c03 }
            if (r3 != 0) goto L_0x0a8a
            com.google.android.gms.measurement.internal.zzt r3 = r55.zzjt()     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.internal.measurement.zzfw r7 = r2.zzaug     // Catch:{ all -> 0x0df5 }
            java.lang.String r7 = r7.zztt     // Catch:{ all -> 0x0df5 }
            java.lang.String r8 = r11.name     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.measurement.internal.zzac r3 = r3.zzg(r7, r8)     // Catch:{ all -> 0x0df5 }
            if (r3 != 0) goto L_0x0a8a
            com.google.android.gms.measurement.internal.zzbw r3 = r1.zzada     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.measurement.internal.zzas r3 = r3.zzgt()     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.measurement.internal.zzau r3 = r3.zzjj()     // Catch:{ all -> 0x0df5 }
            java.lang.String r7 = "Event being bundled has no eventAggregate. appId, eventName"
            com.google.android.gms.internal.measurement.zzfw r8 = r2.zzaug     // Catch:{ all -> 0x0df5 }
            java.lang.String r8 = r8.zztt     // Catch:{ all -> 0x0df5 }
            java.lang.String r9 = r11.name     // Catch:{ all -> 0x0df5 }
            r3.zze(r7, r8, r9)     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.measurement.internal.zzac r3 = new com.google.android.gms.measurement.internal.zzac     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.internal.measurement.zzfw r7 = r2.zzaug     // Catch:{ all -> 0x0df5 }
            java.lang.String r7 = r7.zztt     // Catch:{ all -> 0x0df5 }
            java.lang.String r8 = r11.name     // Catch:{ all -> 0x0df5 }
            r30 = 1
            r32 = 1
            java.lang.Long r9 = r11.zzaxb     // Catch:{ all -> 0x0df5 }
            long r34 = r9.longValue()     // Catch:{ all -> 0x0df5 }
            r36 = 0
            r38 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r27 = r3
            r28 = r7
            r29 = r8
            r27.<init>(r28, r29, r30, r32, r34, r36, r38, r39, r40, r41)     // Catch:{ all -> 0x0df5 }
        L_0x0a8a:
            r55.zzjr()     // Catch:{ all -> 0x0c03 }
            java.lang.String r7 = "_eid"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzfu.zzb(r11, r7)     // Catch:{ all -> 0x0c03 }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ all -> 0x0c03 }
            if (r7 == 0) goto L_0x0a99
            r8 = 1
            goto L_0x0a9a
        L_0x0a99:
            r8 = 0
        L_0x0a9a:
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)     // Catch:{ all -> 0x0c03 }
            r9 = 1
            if (r12 != r9) goto L_0x0ac8
            int r7 = r10 + 1
            r5[r10] = r11     // Catch:{ all -> 0x0df5 }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x0df5 }
            if (r8 == 0) goto L_0x0ac1
            java.lang.Long r8 = r3.zzaia     // Catch:{ all -> 0x0df5 }
            if (r8 != 0) goto L_0x0ab7
            java.lang.Long r8 = r3.zzaib     // Catch:{ all -> 0x0df5 }
            if (r8 != 0) goto L_0x0ab7
            java.lang.Boolean r8 = r3.zzaic     // Catch:{ all -> 0x0df5 }
            if (r8 == 0) goto L_0x0ac1
        L_0x0ab7:
            r8 = 0
            com.google.android.gms.measurement.internal.zzac r3 = r3.zza(r8, r8, r8)     // Catch:{ all -> 0x0df5 }
            java.lang.String r8 = r11.name     // Catch:{ all -> 0x0df5 }
            r4.put(r8, r3)     // Catch:{ all -> 0x0df5 }
        L_0x0ac1:
            r53 = r2
            r52 = r6
            r10 = r7
            goto L_0x0bc1
        L_0x0ac8:
            int r9 = r6.nextInt(r12)     // Catch:{ all -> 0x0c03 }
            if (r9 != 0) goto L_0x0b09
            r55.zzjr()     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.internal.measurement.zzfu[] r7 = r11.zzaxa     // Catch:{ all -> 0x0df5 }
            java.lang.String r9 = "_sr"
            long r12 = (long) r12     // Catch:{ all -> 0x0df5 }
            r52 = r6
            java.lang.Long r6 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.internal.measurement.zzfu[] r6 = com.google.android.gms.measurement.internal.zzfu.zza(r7, r9, r6)     // Catch:{ all -> 0x0df5 }
            r11.zzaxa = r6     // Catch:{ all -> 0x0df5 }
            int r6 = r10 + 1
            r5[r10] = r11     // Catch:{ all -> 0x0df5 }
            boolean r7 = r8.booleanValue()     // Catch:{ all -> 0x0df5 }
            if (r7 == 0) goto L_0x0af5
            java.lang.Long r7 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x0df5 }
            r8 = 0
            com.google.android.gms.measurement.internal.zzac r3 = r3.zza(r8, r7, r8)     // Catch:{ all -> 0x0df5 }
        L_0x0af5:
            java.lang.String r7 = r11.name     // Catch:{ all -> 0x0df5 }
            java.lang.Long r8 = r11.zzaxb     // Catch:{ all -> 0x0df5 }
            long r8 = r8.longValue()     // Catch:{ all -> 0x0df5 }
            com.google.android.gms.measurement.internal.zzac r3 = r3.zza(r8, r14)     // Catch:{ all -> 0x0df5 }
            r4.put(r7, r3)     // Catch:{ all -> 0x0df5 }
            r53 = r2
            r10 = r6
            goto L_0x0bc1
        L_0x0b09:
            r52 = r6
            com.google.android.gms.measurement.internal.zzbw r6 = r1.zzada     // Catch:{ all -> 0x0c03 }
            com.google.android.gms.measurement.internal.zzq r6 = r6.zzgv()     // Catch:{ all -> 0x0c03 }
            com.google.android.gms.internal.measurement.zzfw r9 = r2.zzaug     // Catch:{ all -> 0x0c03 }
            java.lang.String r9 = r9.zztt     // Catch:{ all -> 0x0c03 }
            boolean r6 = r6.zzbf(r9)     // Catch:{ all -> 0x0c03 }
            if (r6 == 0) goto L_0x0b47
            java.lang.Long r6 = r3.zzahz     // Catch:{ all -> 0x0c03 }
            if (r6 == 0) goto L_0x0b2a
            java.lang.Long r6 = r3.zzahz     // Catch:{ all -> 0x0df5 }
            long r18 = r6.longValue()     // Catch:{ all -> 0x0df5 }
            r53 = r2
            r54 = r7
            goto L_0x0b3f
        L_0x0b2a:
            com.google.android.gms.measurement.internal.zzbw r6 = r1.zzada     // Catch:{ all -> 0x0c03 }
            r6.zzgr()     // Catch:{ all -> 0x0c03 }
            java.lang.Long r6 = r11.zzaxc     // Catch:{ all -> 0x0c03 }
            r53 = r2
            long r1 = r6.longValue()     // Catch:{ all -> 0x0c03 }
            r54 = r7
            r6 = r49
            long r18 = com.google.android.gms.measurement.internal.zzfy.zzc(r1, r6)     // Catch:{ all -> 0x0c03 }
        L_0x0b3f:
            int r1 = (r18 > r14 ? 1 : (r18 == r14 ? 0 : -1))
            if (r1 == 0) goto L_0x0b45
        L_0x0b43:
            r1 = 1
            goto L_0x0b61
        L_0x0b45:
            r1 = 0
            goto L_0x0b61
        L_0x0b47:
            r53 = r2
            r54 = r7
            long r1 = r3.zzahy     // Catch:{ all -> 0x0c03 }
            java.lang.Long r6 = r11.zzaxb     // Catch:{ all -> 0x0c03 }
            long r6 = r6.longValue()     // Catch:{ all -> 0x0c03 }
            r9 = 0
            long r6 = r6 - r1
            long r1 = java.lang.Math.abs(r6)     // Catch:{ all -> 0x0c03 }
            r6 = 86400000(0x5265c00, double:4.2687272E-316)
            int r1 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r1 < 0) goto L_0x0b45
            goto L_0x0b43
        L_0x0b61:
            if (r1 == 0) goto L_0x0baf
            r55.zzjr()     // Catch:{ all -> 0x0c03 }
            com.google.android.gms.internal.measurement.zzfu[] r1 = r11.zzaxa     // Catch:{ all -> 0x0c03 }
            java.lang.String r2 = "_efs"
            java.lang.Long r6 = java.lang.Long.valueOf(r16)     // Catch:{ all -> 0x0c03 }
            com.google.android.gms.internal.measurement.zzfu[] r1 = com.google.android.gms.measurement.internal.zzfu.zza(r1, r2, r6)     // Catch:{ all -> 0x0c03 }
            r11.zzaxa = r1     // Catch:{ all -> 0x0c03 }
            r55.zzjr()     // Catch:{ all -> 0x0c03 }
            com.google.android.gms.internal.measurement.zzfu[] r1 = r11.zzaxa     // Catch:{ all -> 0x0c03 }
            java.lang.String r2 = "_sr"
            long r6 = (long) r12     // Catch:{ all -> 0x0c03 }
            java.lang.Long r9 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0c03 }
            com.google.android.gms.internal.measurement.zzfu[] r1 = com.google.android.gms.measurement.internal.zzfu.zza(r1, r2, r9)     // Catch:{ all -> 0x0c03 }
            r11.zzaxa = r1     // Catch:{ all -> 0x0c03 }
            int r1 = r10 + 1
            r5[r10] = r11     // Catch:{ all -> 0x0c03 }
            boolean r2 = r8.booleanValue()     // Catch:{ all -> 0x0c03 }
            if (r2 == 0) goto L_0x0b9e
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0c03 }
            r6 = 1
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r6)     // Catch:{ all -> 0x0c03 }
            r6 = 0
            com.google.android.gms.measurement.internal.zzac r3 = r3.zza(r6, r2, r7)     // Catch:{ all -> 0x0c03 }
        L_0x0b9e:
            java.lang.String r2 = r11.name     // Catch:{ all -> 0x0c03 }
            java.lang.Long r6 = r11.zzaxb     // Catch:{ all -> 0x0c03 }
            long r6 = r6.longValue()     // Catch:{ all -> 0x0c03 }
            com.google.android.gms.measurement.internal.zzac r3 = r3.zza(r6, r14)     // Catch:{ all -> 0x0c03 }
            r4.put(r2, r3)     // Catch:{ all -> 0x0c03 }
            r10 = r1
            goto L_0x0bc1
        L_0x0baf:
            boolean r1 = r8.booleanValue()     // Catch:{ all -> 0x0c03 }
            if (r1 == 0) goto L_0x0bc1
            java.lang.String r1 = r11.name     // Catch:{ all -> 0x0c03 }
            r7 = r54
            r2 = 0
            com.google.android.gms.measurement.internal.zzac r3 = r3.zza(r7, r2, r2)     // Catch:{ all -> 0x0c03 }
            r4.put(r1, r3)     // Catch:{ all -> 0x0c03 }
        L_0x0bc1:
            int r9 = r48 + 1
            r7 = r45
            r8 = r46
            r3 = r47
            r6 = r52
            r2 = r53
            r1 = r55
            goto L_0x08ff
        L_0x0bd1:
            r53 = r2
            r1 = r3
            com.google.android.gms.internal.measurement.zzft[] r2 = r1.zzaxi     // Catch:{ all -> 0x0c03 }
            int r2 = r2.length     // Catch:{ all -> 0x0c03 }
            if (r10 >= r2) goto L_0x0be1
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r5, r10)     // Catch:{ all -> 0x0c03 }
            com.google.android.gms.internal.measurement.zzft[] r2 = (com.google.android.gms.internal.measurement.zzft[]) r2     // Catch:{ all -> 0x0c03 }
            r1.zzaxi = r2     // Catch:{ all -> 0x0c03 }
        L_0x0be1:
            java.util.Set r2 = r4.entrySet()     // Catch:{ all -> 0x0c03 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0c03 }
        L_0x0be9:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0c03 }
            if (r3 == 0) goto L_0x0c0c
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0c03 }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ all -> 0x0c03 }
            com.google.android.gms.measurement.internal.zzt r4 = r55.zzjt()     // Catch:{ all -> 0x0c03 }
            java.lang.Object r3 = r3.getValue()     // Catch:{ all -> 0x0c03 }
            com.google.android.gms.measurement.internal.zzac r3 = (com.google.android.gms.measurement.internal.zzac) r3     // Catch:{ all -> 0x0c03 }
            r4.zza(r3)     // Catch:{ all -> 0x0c03 }
            goto L_0x0be9
        L_0x0c03:
            r0 = move-exception
            r1 = r0
            r5 = r55
            goto L_0x0df8
        L_0x0c09:
            r53 = r2
            r1 = r3
        L_0x0c0c:
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x0dd2 }
            r1.zzaxl = r2     // Catch:{ all -> 0x0dd2 }
            r2 = -9223372036854775808
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x0dd2 }
            r1.zzaxm = r2     // Catch:{ all -> 0x0dd2 }
            r2 = 0
        L_0x0c20:
            com.google.android.gms.internal.measurement.zzft[] r3 = r1.zzaxi     // Catch:{ all -> 0x0dd2 }
            int r3 = r3.length     // Catch:{ all -> 0x0dd2 }
            if (r2 >= r3) goto L_0x0c54
            com.google.android.gms.internal.measurement.zzft[] r3 = r1.zzaxi     // Catch:{ all -> 0x0c03 }
            r3 = r3[r2]     // Catch:{ all -> 0x0c03 }
            java.lang.Long r4 = r3.zzaxb     // Catch:{ all -> 0x0c03 }
            long r4 = r4.longValue()     // Catch:{ all -> 0x0c03 }
            java.lang.Long r6 = r1.zzaxl     // Catch:{ all -> 0x0c03 }
            long r6 = r6.longValue()     // Catch:{ all -> 0x0c03 }
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 >= 0) goto L_0x0c3d
            java.lang.Long r4 = r3.zzaxb     // Catch:{ all -> 0x0c03 }
            r1.zzaxl = r4     // Catch:{ all -> 0x0c03 }
        L_0x0c3d:
            java.lang.Long r4 = r3.zzaxb     // Catch:{ all -> 0x0c03 }
            long r4 = r4.longValue()     // Catch:{ all -> 0x0c03 }
            java.lang.Long r6 = r1.zzaxm     // Catch:{ all -> 0x0c03 }
            long r6 = r6.longValue()     // Catch:{ all -> 0x0c03 }
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 <= 0) goto L_0x0c51
            java.lang.Long r3 = r3.zzaxb     // Catch:{ all -> 0x0c03 }
            r1.zzaxm = r3     // Catch:{ all -> 0x0c03 }
        L_0x0c51:
            int r2 = r2 + 1
            goto L_0x0c20
        L_0x0c54:
            r2 = r53
            com.google.android.gms.internal.measurement.zzfw r3 = r2.zzaug     // Catch:{ all -> 0x0dd2 }
            java.lang.String r3 = r3.zztt     // Catch:{ all -> 0x0dd2 }
            com.google.android.gms.measurement.internal.zzt r4 = r55.zzjt()     // Catch:{ all -> 0x0dd2 }
            com.google.android.gms.measurement.internal.zzg r4 = r4.zzbm(r3)     // Catch:{ all -> 0x0dd2 }
            if (r4 != 0) goto L_0x0c7e
            r5 = r55
            com.google.android.gms.measurement.internal.zzbw r4 = r5.zzada     // Catch:{ all -> 0x0df2 }
            com.google.android.gms.measurement.internal.zzas r4 = r4.zzgt()     // Catch:{ all -> 0x0df2 }
            com.google.android.gms.measurement.internal.zzau r4 = r4.zzjg()     // Catch:{ all -> 0x0df2 }
            java.lang.String r6 = "Bundling raw events w/o app info. appId"
            com.google.android.gms.internal.measurement.zzfw r7 = r2.zzaug     // Catch:{ all -> 0x0df2 }
            java.lang.String r7 = r7.zztt     // Catch:{ all -> 0x0df2 }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzas.zzbw(r7)     // Catch:{ all -> 0x0df2 }
            r4.zzg(r6, r7)     // Catch:{ all -> 0x0df2 }
            goto L_0x0cdc
        L_0x0c7e:
            r5 = r55
            com.google.android.gms.internal.measurement.zzft[] r6 = r1.zzaxi     // Catch:{ all -> 0x0df2 }
            int r6 = r6.length     // Catch:{ all -> 0x0df2 }
            if (r6 <= 0) goto L_0x0cdc
            long r6 = r4.zzhe()     // Catch:{ all -> 0x0df2 }
            r8 = 0
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x0c94
            java.lang.Long r8 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0df2 }
            goto L_0x0c95
        L_0x0c94:
            r8 = 0
        L_0x0c95:
            r1.zzaxo = r8     // Catch:{ all -> 0x0df2 }
            long r8 = r4.zzhd()     // Catch:{ all -> 0x0df2 }
            r10 = 0
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 != 0) goto L_0x0ca2
            goto L_0x0ca3
        L_0x0ca2:
            r6 = r8
        L_0x0ca3:
            int r8 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r8 == 0) goto L_0x0cac
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0df2 }
            goto L_0x0cad
        L_0x0cac:
            r6 = 0
        L_0x0cad:
            r1.zzaxn = r6     // Catch:{ all -> 0x0df2 }
            r4.zzhm()     // Catch:{ all -> 0x0df2 }
            long r6 = r4.zzhj()     // Catch:{ all -> 0x0df2 }
            int r6 = (int) r6     // Catch:{ all -> 0x0df2 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0df2 }
            r1.zzaxy = r6     // Catch:{ all -> 0x0df2 }
            java.lang.Long r6 = r1.zzaxl     // Catch:{ all -> 0x0df2 }
            long r6 = r6.longValue()     // Catch:{ all -> 0x0df2 }
            r4.zzo(r6)     // Catch:{ all -> 0x0df2 }
            java.lang.Long r6 = r1.zzaxm     // Catch:{ all -> 0x0df2 }
            long r6 = r6.longValue()     // Catch:{ all -> 0x0df2 }
            r4.zzp(r6)     // Catch:{ all -> 0x0df2 }
            java.lang.String r6 = r4.zzhu()     // Catch:{ all -> 0x0df2 }
            r1.zzagm = r6     // Catch:{ all -> 0x0df2 }
            com.google.android.gms.measurement.internal.zzt r6 = r55.zzjt()     // Catch:{ all -> 0x0df2 }
            r6.zza(r4)     // Catch:{ all -> 0x0df2 }
        L_0x0cdc:
            com.google.android.gms.internal.measurement.zzft[] r4 = r1.zzaxi     // Catch:{ all -> 0x0df2 }
            int r4 = r4.length     // Catch:{ all -> 0x0df2 }
            if (r4 <= 0) goto L_0x0d31
            com.google.android.gms.measurement.internal.zzbw r4 = r5.zzada     // Catch:{ all -> 0x0df2 }
            r4.zzgw()     // Catch:{ all -> 0x0df2 }
            com.google.android.gms.measurement.internal.zzbq r4 = r55.zzls()     // Catch:{ all -> 0x0df2 }
            com.google.android.gms.internal.measurement.zzfw r6 = r2.zzaug     // Catch:{ all -> 0x0df2 }
            java.lang.String r6 = r6.zztt     // Catch:{ all -> 0x0df2 }
            com.google.android.gms.internal.measurement.zzfp r4 = r4.zzcg(r6)     // Catch:{ all -> 0x0df2 }
            if (r4 == 0) goto L_0x0cfe
            java.lang.Long r6 = r4.zzawk     // Catch:{ all -> 0x0df2 }
            if (r6 != 0) goto L_0x0cf9
            goto L_0x0cfe
        L_0x0cf9:
            java.lang.Long r4 = r4.zzawk     // Catch:{ all -> 0x0df2 }
            r1.zzayf = r4     // Catch:{ all -> 0x0df2 }
            goto L_0x0d28
        L_0x0cfe:
            com.google.android.gms.internal.measurement.zzfw r4 = r2.zzaug     // Catch:{ all -> 0x0df2 }
            java.lang.String r4 = r4.zzafi     // Catch:{ all -> 0x0df2 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0df2 }
            if (r4 == 0) goto L_0x0d11
            r6 = -1
            java.lang.Long r4 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0df2 }
            r1.zzayf = r4     // Catch:{ all -> 0x0df2 }
            goto L_0x0d28
        L_0x0d11:
            com.google.android.gms.measurement.internal.zzbw r4 = r5.zzada     // Catch:{ all -> 0x0df2 }
            com.google.android.gms.measurement.internal.zzas r4 = r4.zzgt()     // Catch:{ all -> 0x0df2 }
            com.google.android.gms.measurement.internal.zzau r4 = r4.zzjj()     // Catch:{ all -> 0x0df2 }
            java.lang.String r6 = "Did not find measurement config or missing version info. appId"
            com.google.android.gms.internal.measurement.zzfw r7 = r2.zzaug     // Catch:{ all -> 0x0df2 }
            java.lang.String r7 = r7.zztt     // Catch:{ all -> 0x0df2 }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzas.zzbw(r7)     // Catch:{ all -> 0x0df2 }
            r4.zzg(r6, r7)     // Catch:{ all -> 0x0df2 }
        L_0x0d28:
            com.google.android.gms.measurement.internal.zzt r4 = r55.zzjt()     // Catch:{ all -> 0x0df2 }
            r11 = r26
            r4.zza(r1, r11)     // Catch:{ all -> 0x0df2 }
        L_0x0d31:
            com.google.android.gms.measurement.internal.zzt r1 = r55.zzjt()     // Catch:{ all -> 0x0df2 }
            java.util.List<java.lang.Long> r2 = r2.zzauh     // Catch:{ all -> 0x0df2 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r2)     // Catch:{ all -> 0x0df2 }
            r1.zzaf()     // Catch:{ all -> 0x0df2 }
            r1.zzcl()     // Catch:{ all -> 0x0df2 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0df2 }
            java.lang.String r6 = "rowid in ("
            r4.<init>(r6)     // Catch:{ all -> 0x0df2 }
            r6 = 0
        L_0x0d48:
            int r7 = r2.size()     // Catch:{ all -> 0x0df2 }
            if (r6 >= r7) goto L_0x0d65
            if (r6 == 0) goto L_0x0d55
            java.lang.String r7 = ","
            r4.append(r7)     // Catch:{ all -> 0x0df2 }
        L_0x0d55:
            java.lang.Object r7 = r2.get(r6)     // Catch:{ all -> 0x0df2 }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ all -> 0x0df2 }
            long r7 = r7.longValue()     // Catch:{ all -> 0x0df2 }
            r4.append(r7)     // Catch:{ all -> 0x0df2 }
            int r6 = r6 + 1
            goto L_0x0d48
        L_0x0d65:
            java.lang.String r6 = ")"
            r4.append(r6)     // Catch:{ all -> 0x0df2 }
            android.database.sqlite.SQLiteDatabase r6 = r1.getWritableDatabase()     // Catch:{ all -> 0x0df2 }
            java.lang.String r7 = "raw_events"
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0df2 }
            r8 = 0
            int r4 = r6.delete(r7, r4, r8)     // Catch:{ all -> 0x0df2 }
            int r6 = r2.size()     // Catch:{ all -> 0x0df2 }
            if (r4 == r6) goto L_0x0d98
            com.google.android.gms.measurement.internal.zzas r1 = r1.zzgt()     // Catch:{ all -> 0x0df2 }
            com.google.android.gms.measurement.internal.zzau r1 = r1.zzjg()     // Catch:{ all -> 0x0df2 }
            java.lang.String r6 = "Deleted fewer rows from raw events table than expected"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0df2 }
            int r2 = r2.size()     // Catch:{ all -> 0x0df2 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0df2 }
            r1.zze(r6, r4, r2)     // Catch:{ all -> 0x0df2 }
        L_0x0d98:
            com.google.android.gms.measurement.internal.zzt r1 = r55.zzjt()     // Catch:{ all -> 0x0df2 }
            android.database.sqlite.SQLiteDatabase r2 = r1.getWritableDatabase()     // Catch:{ all -> 0x0df2 }
            java.lang.String r4 = "delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)"
            r6 = 2
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x0daf }
            r7 = 0
            r6[r7] = r3     // Catch:{ SQLiteException -> 0x0daf }
            r7 = 1
            r6[r7] = r3     // Catch:{ SQLiteException -> 0x0daf }
            r2.execSQL(r4, r6)     // Catch:{ SQLiteException -> 0x0daf }
            goto L_0x0dc2
        L_0x0daf:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.zzas r1 = r1.zzgt()     // Catch:{ all -> 0x0df2 }
            com.google.android.gms.measurement.internal.zzau r1 = r1.zzjg()     // Catch:{ all -> 0x0df2 }
            java.lang.String r4 = "Failed to remove unused event metadata. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzas.zzbw(r3)     // Catch:{ all -> 0x0df2 }
            r1.zze(r4, r3, r2)     // Catch:{ all -> 0x0df2 }
        L_0x0dc2:
            com.google.android.gms.measurement.internal.zzt r1 = r55.zzjt()     // Catch:{ all -> 0x0df2 }
            r1.setTransactionSuccessful()     // Catch:{ all -> 0x0df2 }
            com.google.android.gms.measurement.internal.zzt r1 = r55.zzjt()
            r1.endTransaction()
            r1 = 1
            return r1
        L_0x0dd2:
            r0 = move-exception
            r5 = r55
            goto L_0x0df7
        L_0x0dd6:
            r5 = r1
            com.google.android.gms.measurement.internal.zzt r1 = r55.zzjt()     // Catch:{ all -> 0x0df2 }
            r1.setTransactionSuccessful()     // Catch:{ all -> 0x0df2 }
            com.google.android.gms.measurement.internal.zzt r1 = r55.zzjt()
            r1.endTransaction()
            r1 = 0
            return r1
        L_0x0de7:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r22 = r6
        L_0x0dec:
            if (r22 == 0) goto L_0x0df4
            r22.close()     // Catch:{ all -> 0x0df2 }
            goto L_0x0df4
        L_0x0df2:
            r0 = move-exception
            goto L_0x0df7
        L_0x0df4:
            throw r1     // Catch:{ all -> 0x0df2 }
        L_0x0df5:
            r0 = move-exception
            r5 = r1
        L_0x0df7:
            r1 = r0
        L_0x0df8:
            com.google.android.gms.measurement.internal.zzt r2 = r55.zzjt()
            r2.endTransaction()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfo.zzd(java.lang.String, long):boolean");
    }

    private final boolean zza(zzft zzft, zzft zzft2) {
        Object obj;
        Preconditions.checkArgument("_e".equals(zzft.name));
        zzjr();
        zzfu zza2 = zzfu.zza(zzft, "_sc");
        String str = null;
        if (zza2 == null) {
            obj = null;
        } else {
            obj = zza2.zzaml;
        }
        zzjr();
        zzfu zza3 = zzfu.zza(zzft2, "_pc");
        if (zza3 != null) {
            str = zza3.zzaml;
        }
        if (str == null || !str.equals(obj)) {
            return false;
        }
        zzjr();
        zzfu zza4 = zzfu.zza(zzft, "_et");
        if (zza4.zzaxe == null || zza4.zzaxe.longValue() <= 0) {
            return true;
        }
        long longValue = zza4.zzaxe.longValue();
        zzjr();
        zzfu zza5 = zzfu.zza(zzft2, "_et");
        if (!(zza5 == null || zza5.zzaxe == null || zza5.zzaxe.longValue() <= 0)) {
            longValue += zza5.zzaxe.longValue();
        }
        zzjr();
        zzft2.zzaxa = zzfu.zza(zzft2.zzaxa, "_et", (Object) Long.valueOf(longValue));
        zzjr();
        zzft.zzaxa = zzfu.zza(zzft.zzaxa, "_fr", (Object) Long.valueOf(1));
        return true;
    }

    @VisibleForTesting
    private static zzfu[] zza(zzfu[] zzfuArr, String str) {
        int i = 0;
        while (true) {
            if (i >= zzfuArr.length) {
                i = -1;
                break;
            } else if (str.equals(zzfuArr[i].name)) {
                break;
            } else {
                i++;
            }
        }
        if (i < 0) {
            return zzfuArr;
        }
        return zza(zzfuArr, i);
    }

    @VisibleForTesting
    private static zzfu[] zza(zzfu[] zzfuArr, int i) {
        zzfu[] zzfuArr2 = new zzfu[(zzfuArr.length - 1)];
        if (i > 0) {
            System.arraycopy(zzfuArr, 0, zzfuArr2, 0, i);
        }
        if (i < zzfuArr2.length) {
            System.arraycopy(zzfuArr, i + 1, zzfuArr2, i, zzfuArr2.length - i);
        }
        return zzfuArr2;
    }

    @VisibleForTesting
    private static zzfu[] zza(zzfu[] zzfuArr, int i, String str) {
        for (zzfu zzfu : zzfuArr) {
            if ("_err".equals(zzfu.name)) {
                return zzfuArr;
            }
        }
        zzfu[] zzfuArr2 = new zzfu[(zzfuArr.length + 2)];
        System.arraycopy(zzfuArr, 0, zzfuArr2, 0, zzfuArr.length);
        zzfu zzfu2 = new zzfu();
        zzfu2.name = "_err";
        zzfu2.zzaxe = Long.valueOf((long) i);
        zzfu zzfu3 = new zzfu();
        zzfu3.name = "_ev";
        zzfu3.zzaml = str;
        zzfuArr2[zzfuArr2.length - 2] = zzfu2;
        zzfuArr2[zzfuArr2.length - 1] = zzfu3;
        return zzfuArr2;
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    public final void zza(int i, Throwable th, byte[] bArr, String str) {
        zzt zzjt;
        zzaf();
        zzlx();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzatw = false;
                zzmc();
                throw th2;
            }
        }
        List<Long> list = this.zzaua;
        this.zzaua = null;
        boolean z = true;
        if ((i == 200 || i == 204) && th == null) {
            try {
                this.zzada.zzgu().zzana.set(this.zzada.zzbx().currentTimeMillis());
                this.zzada.zzgu().zzanb.set(0);
                zzmb();
                this.zzada.zzgt().zzjo().zze("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                zzjt().beginTransaction();
                try {
                    for (Long l : list) {
                        try {
                            zzjt = zzjt();
                            long longValue = l.longValue();
                            zzjt.zzaf();
                            zzjt.zzcl();
                            if (zzjt.getWritableDatabase().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                                throw new SQLiteException("Deleted fewer rows from queue than expected");
                            }
                        } catch (SQLiteException e) {
                            zzjt.zzgt().zzjg().zzg("Failed to delete a bundle in a queue table", e);
                            throw e;
                        } catch (SQLiteException e2) {
                            if (this.zzaub == null || !this.zzaub.contains(l)) {
                                throw e2;
                            }
                        }
                    }
                    zzjt().setTransactionSuccessful();
                    zzjt().endTransaction();
                    this.zzaub = null;
                    if (!zzlt().zzfb() || !zzma()) {
                        this.zzauc = -1;
                        zzmb();
                    } else {
                        zzlz();
                    }
                    this.zzatr = 0;
                } catch (Throwable th3) {
                    zzjt().endTransaction();
                    throw th3;
                }
            } catch (SQLiteException e3) {
                this.zzada.zzgt().zzjg().zzg("Database error while trying to delete uploaded bundles", e3);
                this.zzatr = this.zzada.zzbx().elapsedRealtime();
                this.zzada.zzgt().zzjo().zzg("Disable upload, time", Long.valueOf(this.zzatr));
            }
        } else {
            this.zzada.zzgt().zzjo().zze("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            this.zzada.zzgu().zzanb.set(this.zzada.zzbx().currentTimeMillis());
            if (i != 503) {
                if (i != 429) {
                    z = false;
                }
            }
            if (z) {
                this.zzada.zzgu().zzanc.set(this.zzada.zzbx().currentTimeMillis());
            }
            if (this.zzada.zzgv().zzaw(str)) {
                zzjt().zzc(list);
            }
            zzmb();
        }
        this.zzatw = false;
        zzmc();
    }

    private final boolean zzma() {
        zzaf();
        zzlx();
        return zzjt().zzim() || !TextUtils.isEmpty(zzjt().zzih());
    }

    private final void zzb(zzg zzg) {
        Map map;
        zzaf();
        if (!TextUtils.isEmpty(zzg.getGmpAppId()) || (zzq.zzig() && !TextUtils.isEmpty(zzg.zzhb()))) {
            zzq zzgv = this.zzada.zzgv();
            Builder builder = new Builder();
            String gmpAppId = zzg.getGmpAppId();
            if (TextUtils.isEmpty(gmpAppId) && zzq.zzig()) {
                gmpAppId = zzg.zzhb();
            }
            Builder encodedAuthority = builder.scheme((String) zzai.zzaiy.get()).encodedAuthority((String) zzai.zzaiz.get());
            String str = "config/app/";
            String valueOf = String.valueOf(gmpAppId);
            encodedAuthority.path(valueOf.length() != 0 ? str.concat(valueOf) : new String(str)).appendQueryParameter("app_instance_id", zzg.getAppInstanceId()).appendQueryParameter("platform", BleHandshake.DEVICE_TYPE).appendQueryParameter("gmp_version", String.valueOf(zzgv.zzhh()));
            String uri = builder.build().toString();
            try {
                URL url = new URL(uri);
                this.zzada.zzgt().zzjo().zzg("Fetching remote configuration", zzg.zzal());
                zzfp zzcg = zzls().zzcg(zzg.zzal());
                String zzch = zzls().zzch(zzg.zzal());
                if (zzcg == null || TextUtils.isEmpty(zzch)) {
                    map = null;
                } else {
                    C0712a aVar = new C0712a();
                    aVar.put(HttpHeaders.IF_MODIFIED_SINCE, zzch);
                    map = aVar;
                }
                this.zzatv = true;
                zzaw zzlt = zzlt();
                String zzal = zzg.zzal();
                zzfr zzfr = new zzfr(this);
                zzlt.zzaf();
                zzlt.zzcl();
                Preconditions.checkNotNull(url);
                Preconditions.checkNotNull(zzfr);
                zzbr zzgs = zzlt.zzgs();
                zzba zzba = new zzba(zzlt, zzal, url, null, map, zzfr);
                zzgs.zzd((Runnable) zzba);
            } catch (MalformedURLException unused) {
                this.zzada.zzgt().zzjg().zze("Failed to parse config URL. Not fetching. appId", zzas.zzbw(zzg.zzal()), uri);
            }
        } else {
            zzb(zzg.zzal(), HttpStatusCodes.STATUS_CODE_NO_CONTENT, null, null, null);
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x013e A[Catch:{ all -> 0x0191, all -> 0x000f }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x014e A[Catch:{ all -> 0x0191, all -> 0x000f }] */
    @com.google.android.gms.common.util.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(java.lang.String r7, int r8, java.lang.Throwable r9, byte[] r10, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r11) {
        /*
            r6 = this;
            r6.zzaf()
            r6.zzlx()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r7)
            r0 = 0
            if (r10 != 0) goto L_0x0012
            byte[] r10 = new byte[r0]     // Catch:{ all -> 0x000f }
            goto L_0x0012
        L_0x000f:
            r7 = move-exception
            goto L_0x019a
        L_0x0012:
            com.google.android.gms.measurement.internal.zzbw r1 = r6.zzada     // Catch:{ all -> 0x000f }
            com.google.android.gms.measurement.internal.zzas r1 = r1.zzgt()     // Catch:{ all -> 0x000f }
            com.google.android.gms.measurement.internal.zzau r1 = r1.zzjo()     // Catch:{ all -> 0x000f }
            java.lang.String r2 = "onConfigFetched. Response size"
            int r3 = r10.length     // Catch:{ all -> 0x000f }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x000f }
            r1.zzg(r2, r3)     // Catch:{ all -> 0x000f }
            com.google.android.gms.measurement.internal.zzt r1 = r6.zzjt()     // Catch:{ all -> 0x000f }
            r1.beginTransaction()     // Catch:{ all -> 0x000f }
            com.google.android.gms.measurement.internal.zzt r1 = r6.zzjt()     // Catch:{ all -> 0x0191 }
            com.google.android.gms.measurement.internal.zzg r1 = r1.zzbm(r7)     // Catch:{ all -> 0x0191 }
            r2 = 200(0xc8, float:2.8E-43)
            r3 = 1
            r4 = 304(0x130, float:4.26E-43)
            if (r8 == r2) goto L_0x0042
            r2 = 204(0xcc, float:2.86E-43)
            if (r8 == r2) goto L_0x0042
            if (r8 != r4) goto L_0x0046
        L_0x0042:
            if (r9 != 0) goto L_0x0046
            r2 = 1
            goto L_0x0047
        L_0x0046:
            r2 = 0
        L_0x0047:
            if (r1 != 0) goto L_0x005e
            com.google.android.gms.measurement.internal.zzbw r8 = r6.zzada     // Catch:{ all -> 0x0191 }
            com.google.android.gms.measurement.internal.zzas r8 = r8.zzgt()     // Catch:{ all -> 0x0191 }
            com.google.android.gms.measurement.internal.zzau r8 = r8.zzjj()     // Catch:{ all -> 0x0191 }
            java.lang.String r9 = "App does not exist in onConfigFetched. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzas.zzbw(r7)     // Catch:{ all -> 0x0191 }
            r8.zzg(r9, r7)     // Catch:{ all -> 0x0191 }
            goto L_0x017d
        L_0x005e:
            r5 = 404(0x194, float:5.66E-43)
            if (r2 != 0) goto L_0x00ce
            if (r8 != r5) goto L_0x0065
            goto L_0x00ce
        L_0x0065:
            com.google.android.gms.measurement.internal.zzbw r10 = r6.zzada     // Catch:{ all -> 0x0191 }
            com.google.android.gms.common.util.Clock r10 = r10.zzbx()     // Catch:{ all -> 0x0191 }
            long r10 = r10.currentTimeMillis()     // Catch:{ all -> 0x0191 }
            r1.zzv(r10)     // Catch:{ all -> 0x0191 }
            com.google.android.gms.measurement.internal.zzt r10 = r6.zzjt()     // Catch:{ all -> 0x0191 }
            r10.zza(r1)     // Catch:{ all -> 0x0191 }
            com.google.android.gms.measurement.internal.zzbw r10 = r6.zzada     // Catch:{ all -> 0x0191 }
            com.google.android.gms.measurement.internal.zzas r10 = r10.zzgt()     // Catch:{ all -> 0x0191 }
            com.google.android.gms.measurement.internal.zzau r10 = r10.zzjo()     // Catch:{ all -> 0x0191 }
            java.lang.String r11 = "Fetching config failed. code, error"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0191 }
            r10.zze(r11, r1, r9)     // Catch:{ all -> 0x0191 }
            com.google.android.gms.measurement.internal.zzbq r9 = r6.zzls()     // Catch:{ all -> 0x0191 }
            r9.zzci(r7)     // Catch:{ all -> 0x0191 }
            com.google.android.gms.measurement.internal.zzbw r7 = r6.zzada     // Catch:{ all -> 0x0191 }
            com.google.android.gms.measurement.internal.zzbd r7 = r7.zzgu()     // Catch:{ all -> 0x0191 }
            com.google.android.gms.measurement.internal.zzbg r7 = r7.zzanb     // Catch:{ all -> 0x0191 }
            com.google.android.gms.measurement.internal.zzbw r9 = r6.zzada     // Catch:{ all -> 0x0191 }
            com.google.android.gms.common.util.Clock r9 = r9.zzbx()     // Catch:{ all -> 0x0191 }
            long r9 = r9.currentTimeMillis()     // Catch:{ all -> 0x0191 }
            r7.set(r9)     // Catch:{ all -> 0x0191 }
            r7 = 503(0x1f7, float:7.05E-43)
            if (r8 == r7) goto L_0x00b2
            r7 = 429(0x1ad, float:6.01E-43)
            if (r8 != r7) goto L_0x00b1
            goto L_0x00b2
        L_0x00b1:
            r3 = 0
        L_0x00b2:
            if (r3 == 0) goto L_0x00c9
            com.google.android.gms.measurement.internal.zzbw r7 = r6.zzada     // Catch:{ all -> 0x0191 }
            com.google.android.gms.measurement.internal.zzbd r7 = r7.zzgu()     // Catch:{ all -> 0x0191 }
            com.google.android.gms.measurement.internal.zzbg r7 = r7.zzanc     // Catch:{ all -> 0x0191 }
            com.google.android.gms.measurement.internal.zzbw r8 = r6.zzada     // Catch:{ all -> 0x0191 }
            com.google.android.gms.common.util.Clock r8 = r8.zzbx()     // Catch:{ all -> 0x0191 }
            long r8 = r8.currentTimeMillis()     // Catch:{ all -> 0x0191 }
            r7.set(r8)     // Catch:{ all -> 0x0191 }
        L_0x00c9:
            r6.zzmb()     // Catch:{ all -> 0x0191 }
            goto L_0x017d
        L_0x00ce:
            r9 = 0
            if (r11 == 0) goto L_0x00da
            java.lang.String r2 = "Last-Modified"
            java.lang.Object r11 = r11.get(r2)     // Catch:{ all -> 0x0191 }
            java.util.List r11 = (java.util.List) r11     // Catch:{ all -> 0x0191 }
            goto L_0x00db
        L_0x00da:
            r11 = r9
        L_0x00db:
            if (r11 == 0) goto L_0x00ea
            int r2 = r11.size()     // Catch:{ all -> 0x0191 }
            if (r2 <= 0) goto L_0x00ea
            java.lang.Object r11 = r11.get(r0)     // Catch:{ all -> 0x0191 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x0191 }
            goto L_0x00eb
        L_0x00ea:
            r11 = r9
        L_0x00eb:
            if (r8 == r5) goto L_0x0107
            if (r8 != r4) goto L_0x00f0
            goto L_0x0107
        L_0x00f0:
            com.google.android.gms.measurement.internal.zzbq r9 = r6.zzls()     // Catch:{ all -> 0x0191 }
            boolean r9 = r9.zza(r7, r10, r11)     // Catch:{ all -> 0x0191 }
            if (r9 != 0) goto L_0x0128
            com.google.android.gms.measurement.internal.zzt r7 = r6.zzjt()     // Catch:{ all -> 0x000f }
            r7.endTransaction()     // Catch:{ all -> 0x000f }
            r6.zzatv = r0
            r6.zzmc()
            return
        L_0x0107:
            com.google.android.gms.measurement.internal.zzbq r11 = r6.zzls()     // Catch:{ all -> 0x0191 }
            com.google.android.gms.internal.measurement.zzfp r11 = r11.zzcg(r7)     // Catch:{ all -> 0x0191 }
            if (r11 != 0) goto L_0x0128
            com.google.android.gms.measurement.internal.zzbq r11 = r6.zzls()     // Catch:{ all -> 0x0191 }
            boolean r9 = r11.zza(r7, r9, r9)     // Catch:{ all -> 0x0191 }
            if (r9 != 0) goto L_0x0128
            com.google.android.gms.measurement.internal.zzt r7 = r6.zzjt()     // Catch:{ all -> 0x000f }
            r7.endTransaction()     // Catch:{ all -> 0x000f }
            r6.zzatv = r0
            r6.zzmc()
            return
        L_0x0128:
            com.google.android.gms.measurement.internal.zzbw r9 = r6.zzada     // Catch:{ all -> 0x0191 }
            com.google.android.gms.common.util.Clock r9 = r9.zzbx()     // Catch:{ all -> 0x0191 }
            long r2 = r9.currentTimeMillis()     // Catch:{ all -> 0x0191 }
            r1.zzu(r2)     // Catch:{ all -> 0x0191 }
            com.google.android.gms.measurement.internal.zzt r9 = r6.zzjt()     // Catch:{ all -> 0x0191 }
            r9.zza(r1)     // Catch:{ all -> 0x0191 }
            if (r8 != r5) goto L_0x014e
            com.google.android.gms.measurement.internal.zzbw r8 = r6.zzada     // Catch:{ all -> 0x0191 }
            com.google.android.gms.measurement.internal.zzas r8 = r8.zzgt()     // Catch:{ all -> 0x0191 }
            com.google.android.gms.measurement.internal.zzau r8 = r8.zzjl()     // Catch:{ all -> 0x0191 }
            java.lang.String r9 = "Config not found. Using empty config. appId"
            r8.zzg(r9, r7)     // Catch:{ all -> 0x0191 }
            goto L_0x0166
        L_0x014e:
            com.google.android.gms.measurement.internal.zzbw r7 = r6.zzada     // Catch:{ all -> 0x0191 }
            com.google.android.gms.measurement.internal.zzas r7 = r7.zzgt()     // Catch:{ all -> 0x0191 }
            com.google.android.gms.measurement.internal.zzau r7 = r7.zzjo()     // Catch:{ all -> 0x0191 }
            java.lang.String r9 = "Successfully fetched config. Got network response. code, size"
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0191 }
            int r10 = r10.length     // Catch:{ all -> 0x0191 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0191 }
            r7.zze(r9, r8, r10)     // Catch:{ all -> 0x0191 }
        L_0x0166:
            com.google.android.gms.measurement.internal.zzaw r7 = r6.zzlt()     // Catch:{ all -> 0x0191 }
            boolean r7 = r7.zzfb()     // Catch:{ all -> 0x0191 }
            if (r7 == 0) goto L_0x017a
            boolean r7 = r6.zzma()     // Catch:{ all -> 0x0191 }
            if (r7 == 0) goto L_0x017a
            r6.zzlz()     // Catch:{ all -> 0x0191 }
            goto L_0x017d
        L_0x017a:
            r6.zzmb()     // Catch:{ all -> 0x0191 }
        L_0x017d:
            com.google.android.gms.measurement.internal.zzt r7 = r6.zzjt()     // Catch:{ all -> 0x0191 }
            r7.setTransactionSuccessful()     // Catch:{ all -> 0x0191 }
            com.google.android.gms.measurement.internal.zzt r7 = r6.zzjt()     // Catch:{ all -> 0x000f }
            r7.endTransaction()     // Catch:{ all -> 0x000f }
            r6.zzatv = r0
            r6.zzmc()
            return
        L_0x0191:
            r7 = move-exception
            com.google.android.gms.measurement.internal.zzt r8 = r6.zzjt()     // Catch:{ all -> 0x000f }
            r8.endTransaction()     // Catch:{ all -> 0x000f }
            throw r7     // Catch:{ all -> 0x000f }
        L_0x019a:
            r6.zzatv = r0
            r6.zzmc()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfo.zzb(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x01a1  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01bf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzmb() {
        /*
            r20 = this;
            r0 = r20
            r20.zzaf()
            r20.zzlx()
            boolean r1 = r20.zzmf()
            if (r1 != 0) goto L_0x001d
            com.google.android.gms.measurement.internal.zzbw r1 = r0.zzada
            com.google.android.gms.measurement.internal.zzq r1 = r1.zzgv()
            com.google.android.gms.measurement.internal.zzai$zza<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzai.zzald
            boolean r1 = r1.zza(r2)
            if (r1 != 0) goto L_0x001d
            return
        L_0x001d:
            long r1 = r0.zzatr
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x0062
            com.google.android.gms.measurement.internal.zzbw r1 = r0.zzada
            com.google.android.gms.common.util.Clock r1 = r1.zzbx()
            long r1 = r1.elapsedRealtime()
            r5 = 3600000(0x36ee80, double:1.7786363E-317)
            long r7 = r0.zzatr
            long r1 = r1 - r7
            long r1 = java.lang.Math.abs(r1)
            long r5 = r5 - r1
            int r1 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x0060
            com.google.android.gms.measurement.internal.zzbw r1 = r0.zzada
            com.google.android.gms.measurement.internal.zzas r1 = r1.zzgt()
            com.google.android.gms.measurement.internal.zzau r1 = r1.zzjo()
            java.lang.String r2 = "Upload has been suspended. Will update scheduling later in approximately ms"
            java.lang.Long r3 = java.lang.Long.valueOf(r5)
            r1.zzg(r2, r3)
            com.google.android.gms.measurement.internal.zzbb r1 = r20.zzlu()
            r1.unregister()
            com.google.android.gms.measurement.internal.zzfk r1 = r20.zzlv()
            r1.cancel()
            return
        L_0x0060:
            r0.zzatr = r3
        L_0x0062:
            com.google.android.gms.measurement.internal.zzbw r1 = r0.zzada
            boolean r1 = r1.zzkv()
            if (r1 == 0) goto L_0x0268
            boolean r1 = r20.zzma()
            if (r1 != 0) goto L_0x0072
            goto L_0x0268
        L_0x0072:
            com.google.android.gms.measurement.internal.zzbw r1 = r0.zzada
            com.google.android.gms.common.util.Clock r1 = r1.zzbx()
            long r1 = r1.currentTimeMillis()
            com.google.android.gms.measurement.internal.zzai$zza<java.lang.Long> r5 = com.google.android.gms.measurement.internal.zzai.zzaju
            java.lang.Object r5 = r5.get()
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            long r5 = java.lang.Math.max(r3, r5)
            com.google.android.gms.measurement.internal.zzt r7 = r20.zzjt()
            boolean r7 = r7.zzin()
            if (r7 != 0) goto L_0x00a3
            com.google.android.gms.measurement.internal.zzt r7 = r20.zzjt()
            boolean r7 = r7.zzii()
            if (r7 == 0) goto L_0x00a1
            goto L_0x00a3
        L_0x00a1:
            r7 = 0
            goto L_0x00a4
        L_0x00a3:
            r7 = 1
        L_0x00a4:
            if (r7 == 0) goto L_0x00e0
            com.google.android.gms.measurement.internal.zzbw r9 = r0.zzada
            com.google.android.gms.measurement.internal.zzq r9 = r9.zzgv()
            java.lang.String r9 = r9.zzid()
            boolean r10 = android.text.TextUtils.isEmpty(r9)
            if (r10 != 0) goto L_0x00cf
            java.lang.String r10 = ".none."
            boolean r9 = r10.equals(r9)
            if (r9 != 0) goto L_0x00cf
            com.google.android.gms.measurement.internal.zzai$zza<java.lang.Long> r9 = com.google.android.gms.measurement.internal.zzai.zzajp
            java.lang.Object r9 = r9.get()
            java.lang.Long r9 = (java.lang.Long) r9
            long r9 = r9.longValue()
            long r9 = java.lang.Math.max(r3, r9)
            goto L_0x00f0
        L_0x00cf:
            com.google.android.gms.measurement.internal.zzai$zza<java.lang.Long> r9 = com.google.android.gms.measurement.internal.zzai.zzajo
            java.lang.Object r9 = r9.get()
            java.lang.Long r9 = (java.lang.Long) r9
            long r9 = r9.longValue()
            long r9 = java.lang.Math.max(r3, r9)
            goto L_0x00f0
        L_0x00e0:
            com.google.android.gms.measurement.internal.zzai$zza<java.lang.Long> r9 = com.google.android.gms.measurement.internal.zzai.zzajn
            java.lang.Object r9 = r9.get()
            java.lang.Long r9 = (java.lang.Long) r9
            long r9 = r9.longValue()
            long r9 = java.lang.Math.max(r3, r9)
        L_0x00f0:
            com.google.android.gms.measurement.internal.zzbw r11 = r0.zzada
            com.google.android.gms.measurement.internal.zzbd r11 = r11.zzgu()
            com.google.android.gms.measurement.internal.zzbg r11 = r11.zzana
            long r11 = r11.get()
            com.google.android.gms.measurement.internal.zzbw r13 = r0.zzada
            com.google.android.gms.measurement.internal.zzbd r13 = r13.zzgu()
            com.google.android.gms.measurement.internal.zzbg r13 = r13.zzanb
            long r13 = r13.get()
            com.google.android.gms.measurement.internal.zzt r15 = r20.zzjt()
            r16 = r9
            long r8 = r15.zzik()
            com.google.android.gms.measurement.internal.zzt r10 = r20.zzjt()
            r18 = r5
            long r5 = r10.zzil()
            long r5 = java.lang.Math.max(r8, r5)
            int r8 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r8 != 0) goto L_0x0127
        L_0x0124:
            r8 = r3
            goto L_0x019d
        L_0x0127:
            r8 = 0
            long r5 = r5 - r1
            long r5 = java.lang.Math.abs(r5)
            long r5 = r1 - r5
            long r11 = r11 - r1
            long r8 = java.lang.Math.abs(r11)
            long r8 = r1 - r8
            long r13 = r13 - r1
            long r10 = java.lang.Math.abs(r13)
            long r1 = r1 - r10
            long r8 = java.lang.Math.max(r8, r1)
            long r10 = r5 + r18
            if (r7 == 0) goto L_0x014e
            int r7 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r7 <= 0) goto L_0x014e
            long r10 = java.lang.Math.min(r5, r8)
            long r10 = r10 + r16
        L_0x014e:
            com.google.android.gms.measurement.internal.zzfu r7 = r20.zzjr()
            r12 = r16
            boolean r7 = r7.zzb(r8, r12)
            if (r7 != 0) goto L_0x015c
            long r8 = r8 + r12
            goto L_0x015d
        L_0x015c:
            r8 = r10
        L_0x015d:
            int r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r7 == 0) goto L_0x019d
            int r5 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r5 < 0) goto L_0x019d
            r5 = 0
        L_0x0166:
            r6 = 20
            com.google.android.gms.measurement.internal.zzai$zza<java.lang.Integer> r7 = com.google.android.gms.measurement.internal.zzai.zzajw
            java.lang.Object r7 = r7.get()
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r10 = 0
            int r7 = java.lang.Math.max(r10, r7)
            int r6 = java.lang.Math.min(r6, r7)
            if (r5 >= r6) goto L_0x0124
            r6 = 1
            long r6 = r6 << r5
            com.google.android.gms.measurement.internal.zzai$zza<java.lang.Long> r11 = com.google.android.gms.measurement.internal.zzai.zzajv
            java.lang.Object r11 = r11.get()
            java.lang.Long r11 = (java.lang.Long) r11
            long r11 = r11.longValue()
            long r11 = java.lang.Math.max(r3, r11)
            long r11 = r11 * r6
            long r8 = r8 + r11
            int r6 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r6 <= 0) goto L_0x019a
            goto L_0x019d
        L_0x019a:
            int r5 = r5 + 1
            goto L_0x0166
        L_0x019d:
            int r1 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x01bf
            com.google.android.gms.measurement.internal.zzbw r1 = r0.zzada
            com.google.android.gms.measurement.internal.zzas r1 = r1.zzgt()
            com.google.android.gms.measurement.internal.zzau r1 = r1.zzjo()
            java.lang.String r2 = "Next upload time is 0"
            r1.zzby(r2)
            com.google.android.gms.measurement.internal.zzbb r1 = r20.zzlu()
            r1.unregister()
            com.google.android.gms.measurement.internal.zzfk r1 = r20.zzlv()
            r1.cancel()
            return
        L_0x01bf:
            com.google.android.gms.measurement.internal.zzaw r1 = r20.zzlt()
            boolean r1 = r1.zzfb()
            if (r1 != 0) goto L_0x01e7
            com.google.android.gms.measurement.internal.zzbw r1 = r0.zzada
            com.google.android.gms.measurement.internal.zzas r1 = r1.zzgt()
            com.google.android.gms.measurement.internal.zzau r1 = r1.zzjo()
            java.lang.String r2 = "No network"
            r1.zzby(r2)
            com.google.android.gms.measurement.internal.zzbb r1 = r20.zzlu()
            r1.zzey()
            com.google.android.gms.measurement.internal.zzfk r1 = r20.zzlv()
            r1.cancel()
            return
        L_0x01e7:
            com.google.android.gms.measurement.internal.zzbw r1 = r0.zzada
            com.google.android.gms.measurement.internal.zzbd r1 = r1.zzgu()
            com.google.android.gms.measurement.internal.zzbg r1 = r1.zzanc
            long r1 = r1.get()
            com.google.android.gms.measurement.internal.zzai$zza<java.lang.Long> r5 = com.google.android.gms.measurement.internal.zzai.zzajl
            java.lang.Object r5 = r5.get()
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            long r5 = java.lang.Math.max(r3, r5)
            com.google.android.gms.measurement.internal.zzfu r7 = r20.zzjr()
            boolean r7 = r7.zzb(r1, r5)
            if (r7 != 0) goto L_0x0212
            long r1 = r1 + r5
            long r8 = java.lang.Math.max(r8, r1)
        L_0x0212:
            com.google.android.gms.measurement.internal.zzbb r1 = r20.zzlu()
            r1.unregister()
            com.google.android.gms.measurement.internal.zzbw r1 = r0.zzada
            com.google.android.gms.common.util.Clock r1 = r1.zzbx()
            long r1 = r1.currentTimeMillis()
            long r8 = r8 - r1
            int r1 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x024d
            com.google.android.gms.measurement.internal.zzai$zza<java.lang.Long> r1 = com.google.android.gms.measurement.internal.zzai.zzajq
            java.lang.Object r1 = r1.get()
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            long r8 = java.lang.Math.max(r3, r1)
            com.google.android.gms.measurement.internal.zzbw r1 = r0.zzada
            com.google.android.gms.measurement.internal.zzbd r1 = r1.zzgu()
            com.google.android.gms.measurement.internal.zzbg r1 = r1.zzana
            com.google.android.gms.measurement.internal.zzbw r2 = r0.zzada
            com.google.android.gms.common.util.Clock r2 = r2.zzbx()
            long r2 = r2.currentTimeMillis()
            r1.set(r2)
        L_0x024d:
            com.google.android.gms.measurement.internal.zzbw r1 = r0.zzada
            com.google.android.gms.measurement.internal.zzas r1 = r1.zzgt()
            com.google.android.gms.measurement.internal.zzau r1 = r1.zzjo()
            java.lang.String r2 = "Upload scheduled in approximately ms"
            java.lang.Long r3 = java.lang.Long.valueOf(r8)
            r1.zzg(r2, r3)
            com.google.android.gms.measurement.internal.zzfk r1 = r20.zzlv()
            r1.zzh(r8)
            return
        L_0x0268:
            com.google.android.gms.measurement.internal.zzbw r1 = r0.zzada
            com.google.android.gms.measurement.internal.zzas r1 = r1.zzgt()
            com.google.android.gms.measurement.internal.zzau r1 = r1.zzjo()
            java.lang.String r2 = "Nothing to upload or uploading impossible"
            r1.zzby(r2)
            com.google.android.gms.measurement.internal.zzbb r1 = r20.zzlu()
            r1.unregister()
            com.google.android.gms.measurement.internal.zzfk r1 = r20.zzlv()
            r1.cancel()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfo.zzmb():void");
    }

    /* access modifiers changed from: 0000 */
    public final void zzg(Runnable runnable) {
        zzaf();
        if (this.zzats == null) {
            this.zzats = new ArrayList();
        }
        this.zzats.add(runnable);
    }

    private final void zzmc() {
        zzaf();
        if (this.zzatv || this.zzatw || this.zzatx) {
            this.zzada.zzgt().zzjo().zzd("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzatv), Boolean.valueOf(this.zzatw), Boolean.valueOf(this.zzatx));
            return;
        }
        this.zzada.zzgt().zzjo().zzby("Stopping uploading service(s)");
        if (this.zzats != null) {
            for (Runnable run : this.zzats) {
                run.run();
            }
            this.zzats.clear();
        }
    }

    private final Boolean zzc(zzg zzg) {
        try {
            if (zzg.zzhf() != -2147483648L) {
                if (zzg.zzhf() == ((long) Wrappers.packageManager(this.zzada.getContext()).getPackageInfo(zzg.zzal(), 0).versionCode)) {
                    return Boolean.valueOf(true);
                }
            } else {
                String str = Wrappers.packageManager(this.zzada.getContext()).getPackageInfo(zzg.zzal(), 0).versionName;
                if (zzg.zzak() != null && zzg.zzak().equals(str)) {
                    return Boolean.valueOf(true);
                }
            }
            return Boolean.valueOf(false);
        } catch (NameNotFoundException unused) {
            return null;
        }
    }

    @VisibleForTesting
    private final boolean zzmd() {
        zzaf();
        try {
            this.zzatz = new RandomAccessFile(new File(this.zzada.getContext().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
            this.zzaty = this.zzatz.tryLock();
            if (this.zzaty != null) {
                this.zzada.zzgt().zzjo().zzby("Storage concurrent access okay");
                return true;
            }
            this.zzada.zzgt().zzjg().zzby("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e) {
            this.zzada.zzgt().zzjg().zzg("Failed to acquire storage lock", e);
        } catch (IOException e2) {
            this.zzada.zzgt().zzjg().zzg("Failed to access storage lock file", e2);
        }
    }

    @VisibleForTesting
    private final int zza(FileChannel fileChannel) {
        int i;
        zzaf();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.zzada.zzgt().zzjg().zzby("Bad channel to read from");
            return 0;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        try {
            fileChannel.position(0);
            int read = fileChannel.read(allocate);
            if (read != 4) {
                if (read != -1) {
                    this.zzada.zzgt().zzjj().zzg("Unexpected data length. Bytes read", Integer.valueOf(read));
                }
                return 0;
            }
            allocate.flip();
            i = allocate.getInt();
            return i;
        } catch (IOException e) {
            this.zzada.zzgt().zzjg().zzg("Failed to read from channel", e);
            i = 0;
        }
    }

    @VisibleForTesting
    private final boolean zza(int i, FileChannel fileChannel) {
        zzaf();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.zzada.zzgt().zzjg().zzby("Bad channel to read from");
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i);
        allocate.flip();
        try {
            fileChannel.truncate(0);
            fileChannel.write(allocate);
            fileChannel.force(true);
            if (fileChannel.size() != 4) {
                this.zzada.zzgt().zzjg().zzg("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            }
            return true;
        } catch (IOException e) {
            this.zzada.zzgt().zzjg().zzg("Failed to write to channel", e);
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zzme() {
        zzaf();
        zzlx();
        if (!this.zzatq) {
            this.zzatq = true;
            zzaf();
            zzlx();
            if ((this.zzada.zzgv().zza(zzai.zzald) || zzmf()) && zzmd()) {
                int zza2 = zza(this.zzatz);
                int zzjd = this.zzada.zzgk().zzjd();
                zzaf();
                if (zza2 > zzjd) {
                    this.zzada.zzgt().zzjg().zze("Panic: can't downgrade version. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzjd));
                } else if (zza2 < zzjd) {
                    if (zza(zzjd, this.zzatz)) {
                        this.zzada.zzgt().zzjo().zze("Storage version upgraded. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzjd));
                    } else {
                        this.zzada.zzgt().zzjg().zze("Storage version upgrade failed. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzjd));
                    }
                }
            }
        }
        if (!this.zzatp && !this.zzada.zzgv().zza(zzai.zzald)) {
            this.zzada.zzgt().zzjm().zzby("This instance being marked as an uploader");
            this.zzatp = true;
            zzmb();
        }
    }

    private final boolean zzmf() {
        zzaf();
        zzlx();
        return this.zzatp;
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    public final void zzd(zzk zzk) {
        if (this.zzaua != null) {
            this.zzaub = new ArrayList();
            this.zzaub.addAll(this.zzaua);
        }
        zzt zzjt = zzjt();
        String str = zzk.packageName;
        Preconditions.checkNotEmpty(str);
        zzjt.zzaf();
        zzjt.zzcl();
        try {
            SQLiteDatabase writableDatabase = zzjt.getWritableDatabase();
            String[] strArr = {str};
            int delete = writableDatabase.delete("apps", "app_id=?", strArr) + 0 + writableDatabase.delete("events", "app_id=?", strArr) + writableDatabase.delete("user_attributes", "app_id=?", strArr) + writableDatabase.delete("conditional_properties", "app_id=?", strArr) + writableDatabase.delete("raw_events", "app_id=?", strArr) + writableDatabase.delete("raw_events_metadata", "app_id=?", strArr) + writableDatabase.delete("queue", "app_id=?", strArr) + writableDatabase.delete("audience_filter_values", "app_id=?", strArr) + writableDatabase.delete("main_event_params", "app_id=?", strArr);
            if (delete > 0) {
                zzjt.zzgt().zzjo().zze("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzjt.zzgt().zzjg().zze("Error resetting analytics data. appId, error", zzas.zzbw(str), e);
        }
        zzk zza2 = zza(this.zzada.getContext(), zzk.packageName, zzk.zzafi, zzk.zzafr, zzk.zzaft, zzk.zzafu, zzk.zzago, zzk.zzafv);
        if (!this.zzada.zzgv().zzba(zzk.packageName) || zzk.zzafr) {
            zzf(zza2);
        }
    }

    private final zzk zza(Context context, String str, String str2, boolean z, boolean z2, boolean z3, long j, String str3) {
        String str4;
        int i;
        String str5 = str;
        String str6 = "Unknown";
        String str7 = "Unknown";
        String str8 = "Unknown";
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            this.zzada.zzgt().zzjg().zzby("PackageManager is null, can not log app install information");
            return null;
        }
        try {
            str6 = packageManager.getInstallerPackageName(str5);
        } catch (IllegalArgumentException unused) {
            this.zzada.zzgt().zzjg().zzg("Error retrieving installer package name. appId", zzas.zzbw(str));
        }
        if (str6 == null) {
            str6 = "manual_install";
        } else if ("com.android.vending".equals(str6)) {
            str6 = "";
        }
        String str9 = str6;
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str5, 0);
            if (packageInfo != null) {
                CharSequence applicationLabel = Wrappers.packageManager(context).getApplicationLabel(str5);
                if (!TextUtils.isEmpty(applicationLabel)) {
                    String charSequence = applicationLabel.toString();
                }
                str4 = packageInfo.versionName;
                i = packageInfo.versionCode;
            } else {
                str4 = str7;
                i = C1024a.INVALID_ID;
            }
            this.zzada.zzgw();
            zzk zzk = new zzk(str, str2, str4, (long) i, str9, this.zzada.zzgv().zzhh(), this.zzada.zzgr().zzd(context, str5), (String) null, z, false, "", 0, this.zzada.zzgv().zzbc(str5) ? j : 0, 0, z2, z3, false, str3);
            return zzk;
        } catch (NameNotFoundException unused2) {
            this.zzada.zzgt().zzjg().zze("Error retrieving newly installed package info. appId, appName", zzas.zzbw(str), str8);
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zzb(zzfv zzfv, zzk zzk) {
        zzaf();
        zzlx();
        if (TextUtils.isEmpty(zzk.zzafi) && TextUtils.isEmpty(zzk.zzafv)) {
            return;
        }
        if (!zzk.zzafr) {
            zzg(zzk);
            return;
        }
        int zzcv = this.zzada.zzgr().zzcv(zzfv.name);
        if (zzcv != 0) {
            this.zzada.zzgr();
            this.zzada.zzgr().zza(zzk.packageName, zzcv, "_ev", zzfy.zza(zzfv.name, 24, true), zzfv.name != null ? zzfv.name.length() : 0);
            return;
        }
        int zzi = this.zzada.zzgr().zzi(zzfv.name, zzfv.getValue());
        if (zzi != 0) {
            this.zzada.zzgr();
            String zza2 = zzfy.zza(zzfv.name, 24, true);
            Object value = zzfv.getValue();
            this.zzada.zzgr().zza(zzk.packageName, zzi, "_ev", zza2, (value == null || (!(value instanceof String) && !(value instanceof CharSequence))) ? 0 : String.valueOf(value).length());
            return;
        }
        Object zzj = this.zzada.zzgr().zzj(zzfv.name, zzfv.getValue());
        if (zzj != null) {
            if (this.zzada.zzgv().zzbh(zzk.packageName) && "_sno".equals(zzfv.name)) {
                long j = 0;
                zzfx zzi2 = zzjt().zzi(zzk.packageName, "_sno");
                if (zzi2 == null || !(zzi2.value instanceof Long)) {
                    zzac zzg = zzjt().zzg(zzk.packageName, "_s");
                    if (zzg != null) {
                        j = zzg.zzahv;
                        this.zzada.zzgt().zzjo().zzg("Backfill the session number. Last used session number", Long.valueOf(j));
                    }
                } else {
                    j = ((Long) zzi2.value).longValue();
                }
                zzj = Long.valueOf(j + 1);
            }
            zzfx zzfx = new zzfx(zzk.packageName, zzfv.origin, zzfv.name, zzfv.zzauk, zzj);
            this.zzada.zzgt().zzjn().zze("Setting user property", this.zzada.zzgq().zzbv(zzfx.name), zzj);
            zzjt().beginTransaction();
            try {
                zzg(zzk);
                boolean zza3 = zzjt().zza(zzfx);
                zzjt().setTransactionSuccessful();
                if (zza3) {
                    this.zzada.zzgt().zzjn().zze("User property set", this.zzada.zzgq().zzbv(zzfx.name), zzfx.value);
                } else {
                    this.zzada.zzgt().zzjg().zze("Too many unique user properties are set. Ignoring user property", this.zzada.zzgq().zzbv(zzfx.name), zzfx.value);
                    this.zzada.zzgr().zza(zzk.packageName, 9, (String) null, (String) null, 0);
                }
            } finally {
                zzjt().endTransaction();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zzc(zzfv zzfv, zzk zzk) {
        zzaf();
        zzlx();
        if (TextUtils.isEmpty(zzk.zzafi) && TextUtils.isEmpty(zzk.zzafv)) {
            return;
        }
        if (!zzk.zzafr) {
            zzg(zzk);
            return;
        }
        this.zzada.zzgt().zzjn().zzg("Removing user property", this.zzada.zzgq().zzbv(zzfv.name));
        zzjt().beginTransaction();
        try {
            zzg(zzk);
            zzjt().zzh(zzk.packageName, zzfv.name);
            zzjt().setTransactionSuccessful();
            this.zzada.zzgt().zzjn().zzg("User property removed", this.zzada.zzgq().zzbv(zzfv.name));
        } finally {
            zzjt().endTransaction();
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zzb(zzfn zzfn) {
        this.zzatt++;
    }

    /* access modifiers changed from: 0000 */
    public final void zzmg() {
        this.zzatu++;
    }

    /* access modifiers changed from: 0000 */
    public final zzbw zzmh() {
        return this.zzada;
    }

    /* access modifiers changed from: 0000 */
    public final void zzf(zzk zzk) {
        int i;
        zzg zzbm;
        long j;
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo;
        boolean z;
        zzt zzjt;
        String zzal;
        zzk zzk2 = zzk;
        zzaf();
        zzlx();
        Preconditions.checkNotNull(zzk);
        Preconditions.checkNotEmpty(zzk2.packageName);
        if (!TextUtils.isEmpty(zzk2.zzafi) || !TextUtils.isEmpty(zzk2.zzafv)) {
            zzg zzbm2 = zzjt().zzbm(zzk2.packageName);
            if (zzbm2 != null && TextUtils.isEmpty(zzbm2.getGmpAppId()) && !TextUtils.isEmpty(zzk2.zzafi)) {
                zzbm2.zzu(0);
                zzjt().zza(zzbm2);
                zzls().zzcj(zzk2.packageName);
            }
            if (!zzk2.zzafr) {
                zzg(zzk);
                return;
            }
            long j2 = zzk2.zzago;
            if (j2 == 0) {
                j2 = this.zzada.zzbx().currentTimeMillis();
            }
            int i2 = zzk2.zzagp;
            if (i2 == 0 || i2 == 1) {
                i = i2;
            } else {
                this.zzada.zzgt().zzjj().zze("Incorrect app type, assuming installed app. appId, appType", zzas.zzbw(zzk2.packageName), Integer.valueOf(i2));
                i = 0;
            }
            zzjt().beginTransaction();
            try {
                zzbm = zzjt().zzbm(zzk2.packageName);
                if (zzbm != null) {
                    this.zzada.zzgr();
                    if (zzfy.zza(zzk2.zzafi, zzbm.getGmpAppId(), zzk2.zzafv, zzbm.zzhb())) {
                        this.zzada.zzgt().zzjj().zzg("New GMP App Id passed in. Removing cached database data. appId", zzas.zzbw(zzbm.zzal()));
                        zzjt = zzjt();
                        zzal = zzbm.zzal();
                        zzjt.zzcl();
                        zzjt.zzaf();
                        Preconditions.checkNotEmpty(zzal);
                        SQLiteDatabase writableDatabase = zzjt.getWritableDatabase();
                        String[] strArr = {zzal};
                        int delete = writableDatabase.delete("events", "app_id=?", strArr) + 0 + writableDatabase.delete("user_attributes", "app_id=?", strArr) + writableDatabase.delete("conditional_properties", "app_id=?", strArr) + writableDatabase.delete("apps", "app_id=?", strArr) + writableDatabase.delete("raw_events", "app_id=?", strArr) + writableDatabase.delete("raw_events_metadata", "app_id=?", strArr) + writableDatabase.delete("event_filters", "app_id=?", strArr) + writableDatabase.delete("property_filters", "app_id=?", strArr) + writableDatabase.delete("audience_filter_values", "app_id=?", strArr);
                        if (delete > 0) {
                            zzjt.zzgt().zzjo().zze("Deleted application data. app, records", zzal, Integer.valueOf(delete));
                        }
                        zzbm = null;
                    }
                }
            } catch (SQLiteException e) {
                zzjt.zzgt().zzjg().zze("Error deleting application data. appId, error", zzas.zzbw(zzal), e);
            } catch (Throwable th) {
                zzjt().endTransaction();
                throw th;
            }
            if (zzbm != null) {
                if (zzbm.zzhf() != -2147483648L) {
                    if (zzbm.zzhf() != zzk2.zzafo) {
                        Bundle bundle = new Bundle();
                        bundle.putString("_pv", zzbm.zzak());
                        zzag zzag = new zzag("_au", new zzad(bundle), "auto", j2);
                        zzc(zzag, zzk2);
                    }
                } else if (zzbm.zzak() != null && !zzbm.zzak().equals(zzk2.zzts)) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("_pv", zzbm.zzak());
                    zzag zzag2 = new zzag("_au", new zzad(bundle2), "auto", j2);
                    zzc(zzag2, zzk2);
                }
            }
            zzg(zzk);
            zzac zzac = i == 0 ? zzjt().zzg(zzk2.packageName, "_f") : i == 1 ? zzjt().zzg(zzk2.packageName, "_v") : null;
            if (zzac == null) {
                long j3 = ((j2 / 3600000) + 1) * 3600000;
                if (i == 0) {
                    j = 1;
                    zzfv zzfv = new zzfv("_fot", j2, Long.valueOf(j3), "auto");
                    zzb(zzfv, zzk2);
                    if (this.zzada.zzgv().zzbe(zzk2.zzafi)) {
                        zzaf();
                        this.zzada.zzkk().zzce(zzk2.packageName);
                    }
                    zzaf();
                    zzlx();
                    Bundle bundle3 = new Bundle();
                    bundle3.putLong("_c", 1);
                    bundle3.putLong("_r", 1);
                    bundle3.putLong("_uwa", 0);
                    bundle3.putLong("_pfo", 0);
                    bundle3.putLong("_sys", 0);
                    bundle3.putLong("_sysu", 0);
                    if (this.zzada.zzgv().zzbk(zzk2.packageName)) {
                        bundle3.putLong("_et", 1);
                    }
                    if (this.zzada.zzgv().zzba(zzk2.packageName) && zzk2.zzagq) {
                        bundle3.putLong("_dac", 1);
                    }
                    if (this.zzada.getContext().getPackageManager() == null) {
                        this.zzada.zzgt().zzjg().zzg("PackageManager is null, first open report might be inaccurate. appId", zzas.zzbw(zzk2.packageName));
                    } else {
                        try {
                            packageInfo = Wrappers.packageManager(this.zzada.getContext()).getPackageInfo(zzk2.packageName, 0);
                        } catch (NameNotFoundException e2) {
                            this.zzada.zzgt().zzjg().zze("Package info is null, first open report might be inaccurate. appId", zzas.zzbw(zzk2.packageName), e2);
                            packageInfo = null;
                        }
                        if (!(packageInfo == null || packageInfo.firstInstallTime == 0)) {
                            if (packageInfo.firstInstallTime != packageInfo.lastUpdateTime) {
                                bundle3.putLong("_uwa", 1);
                                z = false;
                            } else {
                                z = true;
                            }
                            zzfv zzfv2 = r7;
                            zzfv zzfv3 = new zzfv("_fi", j2, Long.valueOf(z ? 1 : 0), "auto");
                            zzb(zzfv2, zzk2);
                        }
                        try {
                            applicationInfo = Wrappers.packageManager(this.zzada.getContext()).getApplicationInfo(zzk2.packageName, 0);
                        } catch (NameNotFoundException e3) {
                            this.zzada.zzgt().zzjg().zze("Application info is null, first open report might be inaccurate. appId", zzas.zzbw(zzk2.packageName), e3);
                            applicationInfo = null;
                        }
                        if (applicationInfo != null) {
                            if ((applicationInfo.flags & 1) != 0) {
                                bundle3.putLong("_sys", 1);
                            }
                            if ((applicationInfo.flags & 128) != 0) {
                                bundle3.putLong("_sysu", 1);
                            }
                        }
                    }
                    zzt zzjt2 = zzjt();
                    String str = zzk2.packageName;
                    Preconditions.checkNotEmpty(str);
                    zzjt2.zzaf();
                    zzjt2.zzcl();
                    long zzn = zzjt2.zzn(str, "first_open_count");
                    if (zzn >= 0) {
                        bundle3.putLong("_pfo", zzn);
                    }
                    zzag zzag3 = new zzag("_f", new zzad(bundle3), "auto", j2);
                    zzc(zzag3, zzk2);
                } else {
                    j = 1;
                    if (i == 1) {
                        zzfv zzfv4 = new zzfv("_fvt", j2, Long.valueOf(j3), "auto");
                        zzb(zzfv4, zzk2);
                        zzaf();
                        zzlx();
                        Bundle bundle4 = new Bundle();
                        bundle4.putLong("_c", 1);
                        bundle4.putLong("_r", 1);
                        if (this.zzada.zzgv().zzbk(zzk2.packageName)) {
                            bundle4.putLong("_et", 1);
                        }
                        if (this.zzada.zzgv().zzba(zzk2.packageName) && zzk2.zzagq) {
                            bundle4.putLong("_dac", 1);
                        }
                        zzag zzag4 = new zzag("_v", new zzad(bundle4), "auto", j2);
                        zzc(zzag4, zzk2);
                    }
                }
                if (!this.zzada.zzgv().zze(zzk2.packageName, zzai.zzala)) {
                    Bundle bundle5 = new Bundle();
                    bundle5.putLong("_et", j);
                    if (this.zzada.zzgv().zzbk(zzk2.packageName)) {
                        bundle5.putLong("_fr", j);
                    }
                    zzag zzag5 = new zzag("_e", new zzad(bundle5), "auto", j2);
                    zzc(zzag5, zzk2);
                }
            } else if (zzk2.zzagn) {
                zzag zzag6 = new zzag("_cd", new zzad(new Bundle()), "auto", j2);
                zzc(zzag6, zzk2);
            }
            zzjt().setTransactionSuccessful();
            zzjt().endTransaction();
        }
    }

    private final zzk zzcr(String str) {
        String str2 = str;
        zzg zzbm = zzjt().zzbm(str2);
        if (zzbm == null || TextUtils.isEmpty(zzbm.zzak())) {
            this.zzada.zzgt().zzjn().zzg("No app data available; dropping", str2);
            return null;
        }
        Boolean zzc = zzc(zzbm);
        if (zzc == null || zzc.booleanValue()) {
            zzg zzg = zzbm;
            zzk zzk = new zzk(str, zzbm.getGmpAppId(), zzbm.zzak(), zzbm.zzhf(), zzbm.zzhg(), zzbm.zzhh(), zzbm.zzhi(), (String) null, zzbm.isMeasurementEnabled(), false, zzbm.getFirebaseInstanceId(), zzg.zzhv(), 0, 0, zzg.zzhw(), zzg.zzhx(), false, zzg.zzhb());
            return zzk;
        }
        this.zzada.zzgt().zzjg().zzg("App version does not match; dropping. appId", zzas.zzbw(str));
        return null;
    }

    /* access modifiers changed from: 0000 */
    public final void zze(zzo zzo) {
        zzk zzcr = zzcr(zzo.packageName);
        if (zzcr != null) {
            zzb(zzo, zzcr);
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zzb(zzo zzo, zzk zzk) {
        Preconditions.checkNotNull(zzo);
        Preconditions.checkNotEmpty(zzo.packageName);
        Preconditions.checkNotNull(zzo.origin);
        Preconditions.checkNotNull(zzo.zzags);
        Preconditions.checkNotEmpty(zzo.zzags.name);
        zzaf();
        zzlx();
        if (TextUtils.isEmpty(zzk.zzafi) && TextUtils.isEmpty(zzk.zzafv)) {
            return;
        }
        if (!zzk.zzafr) {
            zzg(zzk);
            return;
        }
        zzo zzo2 = new zzo(zzo);
        boolean z = false;
        zzo2.active = false;
        zzjt().beginTransaction();
        try {
            zzo zzj = zzjt().zzj(zzo2.packageName, zzo2.zzags.name);
            if (zzj != null && !zzj.origin.equals(zzo2.origin)) {
                this.zzada.zzgt().zzjj().zzd("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzada.zzgq().zzbv(zzo2.zzags.name), zzo2.origin, zzj.origin);
            }
            if (zzj != null && zzj.active) {
                zzo2.origin = zzj.origin;
                zzo2.creationTimestamp = zzj.creationTimestamp;
                zzo2.triggerTimeout = zzj.triggerTimeout;
                zzo2.triggerEventName = zzj.triggerEventName;
                zzo2.zzagu = zzj.zzagu;
                zzo2.active = zzj.active;
                zzfv zzfv = new zzfv(zzo2.zzags.name, zzj.zzags.zzauk, zzo2.zzags.getValue(), zzj.zzags.origin);
                zzo2.zzags = zzfv;
            } else if (TextUtils.isEmpty(zzo2.triggerEventName)) {
                zzfv zzfv2 = new zzfv(zzo2.zzags.name, zzo2.creationTimestamp, zzo2.zzags.getValue(), zzo2.zzags.origin);
                zzo2.zzags = zzfv2;
                zzo2.active = true;
                z = true;
            }
            if (zzo2.active) {
                zzfv zzfv3 = zzo2.zzags;
                zzfx zzfx = new zzfx(zzo2.packageName, zzo2.origin, zzfv3.name, zzfv3.zzauk, zzfv3.getValue());
                if (zzjt().zza(zzfx)) {
                    this.zzada.zzgt().zzjn().zzd("User property updated immediately", zzo2.packageName, this.zzada.zzgq().zzbv(zzfx.name), zzfx.value);
                } else {
                    this.zzada.zzgt().zzjg().zzd("(2)Too many active user properties, ignoring", zzas.zzbw(zzo2.packageName), this.zzada.zzgq().zzbv(zzfx.name), zzfx.value);
                }
                if (z && zzo2.zzagu != null) {
                    zzd(new zzag(zzo2.zzagu, zzo2.creationTimestamp), zzk);
                }
            }
            if (zzjt().zza(zzo2)) {
                this.zzada.zzgt().zzjn().zzd("Conditional property added", zzo2.packageName, this.zzada.zzgq().zzbv(zzo2.zzags.name), zzo2.zzags.getValue());
            } else {
                this.zzada.zzgt().zzjg().zzd("Too many conditional properties, ignoring", zzas.zzbw(zzo2.packageName), this.zzada.zzgq().zzbv(zzo2.zzags.name), zzo2.zzags.getValue());
            }
            zzjt().setTransactionSuccessful();
        } finally {
            zzjt().endTransaction();
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zzf(zzo zzo) {
        zzk zzcr = zzcr(zzo.packageName);
        if (zzcr != null) {
            zzc(zzo, zzcr);
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zzc(zzo zzo, zzk zzk) {
        Preconditions.checkNotNull(zzo);
        Preconditions.checkNotEmpty(zzo.packageName);
        Preconditions.checkNotNull(zzo.zzags);
        Preconditions.checkNotEmpty(zzo.zzags.name);
        zzaf();
        zzlx();
        if (TextUtils.isEmpty(zzk.zzafi) && TextUtils.isEmpty(zzk.zzafv)) {
            return;
        }
        if (!zzk.zzafr) {
            zzg(zzk);
            return;
        }
        zzjt().beginTransaction();
        try {
            zzg(zzk);
            zzo zzj = zzjt().zzj(zzo.packageName, zzo.zzags.name);
            if (zzj != null) {
                this.zzada.zzgt().zzjn().zze("Removing conditional user property", zzo.packageName, this.zzada.zzgq().zzbv(zzo.zzags.name));
                zzjt().zzk(zzo.packageName, zzo.zzags.name);
                if (zzj.active) {
                    zzjt().zzh(zzo.packageName, zzo.zzags.name);
                }
                if (zzo.zzagv != null) {
                    Bundle bundle = null;
                    if (zzo.zzagv.zzahu != null) {
                        bundle = zzo.zzagv.zzahu.zziy();
                    }
                    Bundle bundle2 = bundle;
                    zzd(this.zzada.zzgr().zza(zzo.packageName, zzo.zzagv.name, bundle2, zzj.origin, zzo.zzagv.zzaig, true, false), zzk);
                }
            } else {
                this.zzada.zzgt().zzjj().zze("Conditional user property doesn't exist", zzas.zzbw(zzo.packageName), this.zzada.zzgq().zzbv(zzo.zzags.name));
            }
            zzjt().setTransactionSuccessful();
        } finally {
            zzjt().endTransaction();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x015a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzg zzg(com.google.android.gms.measurement.internal.zzk r8) {
        /*
            r7 = this;
            r7.zzaf()
            r7.zzlx()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)
            java.lang.String r0 = r8.packageName
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r0)
            com.google.android.gms.measurement.internal.zzt r0 = r7.zzjt()
            java.lang.String r1 = r8.packageName
            com.google.android.gms.measurement.internal.zzg r0 = r0.zzbm(r1)
            com.google.android.gms.measurement.internal.zzbw r1 = r7.zzada
            com.google.android.gms.measurement.internal.zzbd r1 = r1.zzgu()
            java.lang.String r2 = r8.packageName
            java.lang.String r1 = r1.zzca(r2)
            r2 = 1
            if (r0 != 0) goto L_0x0042
            com.google.android.gms.measurement.internal.zzg r0 = new com.google.android.gms.measurement.internal.zzg
            com.google.android.gms.measurement.internal.zzbw r3 = r7.zzada
            java.lang.String r4 = r8.packageName
            r0.<init>(r3, r4)
            com.google.android.gms.measurement.internal.zzbw r3 = r7.zzada
            com.google.android.gms.measurement.internal.zzfy r3 = r3.zzgr()
            java.lang.String r3 = r3.zzmm()
            r0.zzaj(r3)
            r0.zzam(r1)
        L_0x0040:
            r1 = 1
            goto L_0x005e
        L_0x0042:
            java.lang.String r3 = r0.zzhc()
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x005d
            r0.zzam(r1)
            com.google.android.gms.measurement.internal.zzbw r1 = r7.zzada
            com.google.android.gms.measurement.internal.zzfy r1 = r1.zzgr()
            java.lang.String r1 = r1.zzmm()
            r0.zzaj(r1)
            goto L_0x0040
        L_0x005d:
            r1 = 0
        L_0x005e:
            java.lang.String r3 = r8.zzafi
            java.lang.String r4 = r0.getGmpAppId()
            boolean r3 = android.text.TextUtils.equals(r3, r4)
            if (r3 != 0) goto L_0x0070
            java.lang.String r1 = r8.zzafi
            r0.zzak(r1)
            r1 = 1
        L_0x0070:
            java.lang.String r3 = r8.zzafv
            java.lang.String r4 = r0.zzhb()
            boolean r3 = android.text.TextUtils.equals(r3, r4)
            if (r3 != 0) goto L_0x0082
            java.lang.String r1 = r8.zzafv
            r0.zzal(r1)
            r1 = 1
        L_0x0082:
            java.lang.String r3 = r8.zzafk
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x009c
            java.lang.String r3 = r8.zzafk
            java.lang.String r4 = r0.getFirebaseInstanceId()
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x009c
            java.lang.String r1 = r8.zzafk
            r0.zzan(r1)
            r1 = 1
        L_0x009c:
            long r3 = r8.zzade
            r5 = 0
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x00b4
            long r3 = r8.zzade
            long r5 = r0.zzhh()
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x00b4
            long r3 = r8.zzade
            r0.zzr(r3)
            r1 = 1
        L_0x00b4:
            java.lang.String r3 = r8.zzts
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x00ce
            java.lang.String r3 = r8.zzts
            java.lang.String r4 = r0.zzak()
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x00ce
            java.lang.String r1 = r8.zzts
            r0.setAppVersion(r1)
            r1 = 1
        L_0x00ce:
            long r3 = r8.zzafo
            long r5 = r0.zzhf()
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x00de
            long r3 = r8.zzafo
            r0.zzq(r3)
            r1 = 1
        L_0x00de:
            java.lang.String r3 = r8.zzafp
            if (r3 == 0) goto L_0x00f4
            java.lang.String r3 = r8.zzafp
            java.lang.String r4 = r0.zzhg()
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x00f4
            java.lang.String r1 = r8.zzafp
            r0.zzao(r1)
            r1 = 1
        L_0x00f4:
            long r3 = r8.zzafq
            long r5 = r0.zzhi()
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x0104
            long r3 = r8.zzafq
            r0.zzs(r3)
            r1 = 1
        L_0x0104:
            boolean r3 = r8.zzafr
            boolean r4 = r0.isMeasurementEnabled()
            if (r3 == r4) goto L_0x0112
            boolean r1 = r8.zzafr
            r0.setMeasurementEnabled(r1)
            r1 = 1
        L_0x0112:
            java.lang.String r3 = r8.zzagm
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x012c
            java.lang.String r3 = r8.zzagm
            java.lang.String r4 = r0.zzht()
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x012c
            java.lang.String r1 = r8.zzagm
            r0.zzap(r1)
            r1 = 1
        L_0x012c:
            long r3 = r8.zzafs
            long r5 = r0.zzhv()
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x013c
            long r3 = r8.zzafs
            r0.zzac(r3)
            r1 = 1
        L_0x013c:
            boolean r3 = r8.zzaft
            boolean r4 = r0.zzhw()
            if (r3 == r4) goto L_0x014a
            boolean r1 = r8.zzaft
            r0.zze(r1)
            r1 = 1
        L_0x014a:
            boolean r3 = r8.zzafu
            boolean r4 = r0.zzhx()
            if (r3 == r4) goto L_0x0158
            boolean r8 = r8.zzafu
            r0.zzf(r8)
            r1 = 1
        L_0x0158:
            if (r1 == 0) goto L_0x0161
            com.google.android.gms.measurement.internal.zzt r8 = r7.zzjt()
            r8.zza(r0)
        L_0x0161:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfo.zzg(com.google.android.gms.measurement.internal.zzk):com.google.android.gms.measurement.internal.zzg");
    }

    /* access modifiers changed from: 0000 */
    public final String zzh(zzk zzk) {
        try {
            return (String) this.zzada.zzgs().zzb((Callable<V>) new zzfs<V>(this, zzk)).get(30000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            this.zzada.zzgt().zzjg().zze("Failed to get app instance id. appId", zzas.zzbw(zzk.packageName), e);
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zzm(boolean z) {
        zzmb();
    }
}
