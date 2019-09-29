package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzfj;
import com.google.android.gms.internal.measurement.zzfk;
import com.google.android.gms.internal.measurement.zzfl;
import com.google.android.gms.internal.measurement.zzfm;
import com.google.android.gms.internal.measurement.zzfn;
import com.google.android.gms.internal.measurement.zzfr;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.internal.measurement.zzfv;
import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzfx;
import com.google.android.gms.internal.measurement.zzfy;
import com.google.android.gms.internal.measurement.zzfz;
import com.google.android.gms.internal.measurement.zzya;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public final class zzfu extends zzfn {
    zzfu(zzfo zzfo) {
        super(zzfo);
    }

    /* access modifiers changed from: protected */
    public final boolean zzgy() {
        return false;
    }

    /* access modifiers changed from: 0000 */
    public final void zza(zzfz zzfz, Object obj) {
        Preconditions.checkNotNull(obj);
        zzfz.zzaml = null;
        zzfz.zzaxe = null;
        zzfz.zzaun = null;
        if (obj instanceof String) {
            zzfz.zzaml = (String) obj;
        } else if (obj instanceof Long) {
            zzfz.zzaxe = (Long) obj;
        } else if (obj instanceof Double) {
            zzfz.zzaun = (Double) obj;
        } else {
            zzgt().zzjg().zzg("Ignoring invalid (type) user attribute value", obj);
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zza(com.google.android.gms.internal.measurement.zzfu zzfu, Object obj) {
        Preconditions.checkNotNull(obj);
        zzfu.zzaml = null;
        zzfu.zzaxe = null;
        zzfu.zzaun = null;
        if (obj instanceof String) {
            zzfu.zzaml = (String) obj;
        } else if (obj instanceof Long) {
            zzfu.zzaxe = (Long) obj;
        } else if (obj instanceof Double) {
            zzfu.zzaun = (Double) obj;
        } else {
            zzgt().zzjg().zzg("Ignoring invalid (type) event param value", obj);
        }
    }

    /* access modifiers changed from: 0000 */
    public final byte[] zza(zzfv zzfv) {
        try {
            byte[] bArr = new byte[zzfv.zzvx()];
            zzya zzk = zzya.zzk(bArr, 0, bArr.length);
            zzfv.zza(zzk);
            zzk.zzza();
            return bArr;
        } catch (IOException e) {
            zzgt().zzjg().zzg("Data loss. Failed to serialize batch", e);
            return null;
        }
    }

    static com.google.android.gms.internal.measurement.zzfu zza(zzft zzft, String str) {
        com.google.android.gms.internal.measurement.zzfu[] zzfuArr;
        for (com.google.android.gms.internal.measurement.zzfu zzfu : zzft.zzaxa) {
            if (zzfu.name.equals(str)) {
                return zzfu;
            }
        }
        return null;
    }

    static Object zzb(zzft zzft, String str) {
        com.google.android.gms.internal.measurement.zzfu zza = zza(zzft, str);
        if (zza != null) {
            if (zza.zzaml != null) {
                return zza.zzaml;
            }
            if (zza.zzaxe != null) {
                return zza.zzaxe;
            }
            if (zza.zzaun != null) {
                return zza.zzaun;
            }
        }
        return null;
    }

    static com.google.android.gms.internal.measurement.zzfu[] zza(com.google.android.gms.internal.measurement.zzfu[] zzfuArr, String str, Object obj) {
        for (com.google.android.gms.internal.measurement.zzfu zzfu : zzfuArr) {
            if (str.equals(zzfu.name)) {
                zzfu.zzaxe = null;
                zzfu.zzaml = null;
                zzfu.zzaun = null;
                if (obj instanceof Long) {
                    zzfu.zzaxe = (Long) obj;
                } else if (obj instanceof String) {
                    zzfu.zzaml = (String) obj;
                } else if (obj instanceof Double) {
                    zzfu.zzaun = (Double) obj;
                }
                return zzfuArr;
            }
        }
        com.google.android.gms.internal.measurement.zzfu[] zzfuArr2 = new com.google.android.gms.internal.measurement.zzfu[(zzfuArr.length + 1)];
        System.arraycopy(zzfuArr, 0, zzfuArr2, 0, zzfuArr.length);
        com.google.android.gms.internal.measurement.zzfu zzfu2 = new com.google.android.gms.internal.measurement.zzfu();
        zzfu2.name = str;
        if (obj instanceof Long) {
            zzfu2.zzaxe = (Long) obj;
        } else if (obj instanceof String) {
            zzfu2.zzaml = (String) obj;
        } else if (obj instanceof Double) {
            zzfu2.zzaun = (Double) obj;
        }
        zzfuArr2[zzfuArr.length] = zzfu2;
        return zzfuArr2;
    }

    /* access modifiers changed from: 0000 */
    public final String zzb(zzfv zzfv) {
        zzfw[] zzfwArr;
        int i;
        int i2;
        zzfv zzfv2 = zzfv;
        StringBuilder sb = new StringBuilder();
        sb.append("\nbatch {\n");
        if (zzfv2.zzaxf != null) {
            for (zzfw zzfw : zzfv2.zzaxf) {
                if (!(zzfw == null || zzfw == null)) {
                    zza(sb, 1);
                    sb.append("bundle {\n");
                    zza(sb, 1, "protocol_version", (Object) zzfw.zzaxh);
                    zza(sb, 1, "platform", (Object) zzfw.zzaxp);
                    zza(sb, 1, "gmp_version", (Object) zzfw.zzaxt);
                    zza(sb, 1, "uploading_gmp_version", (Object) zzfw.zzaxu);
                    zza(sb, 1, "config_version", (Object) zzfw.zzayf);
                    zza(sb, 1, "gmp_app_id", (Object) zzfw.zzafi);
                    zza(sb, 1, "admob_app_id", (Object) zzfw.zzawp);
                    zza(sb, 1, "app_id", (Object) zzfw.zztt);
                    zza(sb, 1, "app_version", (Object) zzfw.zzts);
                    zza(sb, 1, "app_version_major", (Object) zzfw.zzayb);
                    zza(sb, 1, "firebase_instance_id", (Object) zzfw.zzafk);
                    zza(sb, 1, "dev_cert_hash", (Object) zzfw.zzaxx);
                    zza(sb, 1, "app_store", (Object) zzfw.zzafp);
                    zza(sb, 1, "upload_timestamp_millis", (Object) zzfw.zzaxk);
                    zza(sb, 1, "start_timestamp_millis", (Object) zzfw.zzaxl);
                    zza(sb, 1, "end_timestamp_millis", (Object) zzfw.zzaxm);
                    zza(sb, 1, "previous_bundle_start_timestamp_millis", (Object) zzfw.zzaxn);
                    zza(sb, 1, "previous_bundle_end_timestamp_millis", (Object) zzfw.zzaxo);
                    zza(sb, 1, "app_instance_id", (Object) zzfw.zzafh);
                    zza(sb, 1, "resettable_device_id", (Object) zzfw.zzaxv);
                    zza(sb, 1, "device_id", (Object) zzfw.zzaye);
                    zza(sb, 1, "ds_id", (Object) zzfw.zzayh);
                    zza(sb, 1, "limited_ad_tracking", (Object) zzfw.zzaxw);
                    zza(sb, 1, "os_version", (Object) zzfw.zzaxq);
                    zza(sb, 1, "device_model", (Object) zzfw.zzaxr);
                    zza(sb, 1, "user_default_language", (Object) zzfw.zzahr);
                    zza(sb, 1, "time_zone_offset_minutes", (Object) zzfw.zzaxs);
                    zza(sb, 1, "bundle_sequential_index", (Object) zzfw.zzaxy);
                    zza(sb, 1, "service_upload", (Object) zzfw.zzaxz);
                    zza(sb, 1, "health_monitor", (Object) zzfw.zzagm);
                    if (!(zzfw.zzayg == null || zzfw.zzayg.longValue() == 0)) {
                        zza(sb, 1, "android_id", (Object) zzfw.zzayg);
                    }
                    if (zzfw.zzayj != null) {
                        zza(sb, 1, "retry_counter", (Object) zzfw.zzayj);
                    }
                    zzfz[] zzfzArr = zzfw.zzaxj;
                    if (zzfzArr != null) {
                        for (zzfz zzfz : zzfzArr) {
                            if (zzfz != null) {
                                zza(sb, 2);
                                sb.append("user_property {\n");
                                zza(sb, 2, "set_timestamp_millis", (Object) zzfz.zzayu);
                                zza(sb, 2, "name", (Object) zzgq().zzbv(zzfz.name));
                                zza(sb, 2, "string_value", (Object) zzfz.zzaml);
                                zza(sb, 2, "int_value", (Object) zzfz.zzaxe);
                                zza(sb, 2, "double_value", (Object) zzfz.zzaun);
                                zza(sb, 2);
                                sb.append("}\n");
                            }
                        }
                    }
                    zzfr[] zzfrArr = zzfw.zzaya;
                    String str = zzfw.zztt;
                    if (zzfrArr != null) {
                        int length = zzfrArr.length;
                        int i3 = 0;
                        while (i3 < length) {
                            zzfr zzfr = zzfrArr[i3];
                            if (zzfr != null) {
                                zza(sb, 2);
                                sb.append("audience_membership {\n");
                                zza(sb, 2, "audience_id", (Object) zzfr.zzave);
                                zza(sb, 2, "new_audience", (Object) zzfr.zzawv);
                                StringBuilder sb2 = sb;
                                zzfr zzfr2 = zzfr;
                                i2 = i3;
                                i = length;
                                String str2 = str;
                                zza(sb2, 2, "current_data", zzfr.zzawt, str2);
                                zza(sb2, 2, "previous_data", zzfr2.zzawu, str2);
                                zza(sb, 2);
                                sb.append("}\n");
                            } else {
                                i2 = i3;
                                i = length;
                            }
                            i3 = i2 + 1;
                            length = i;
                        }
                    }
                    zzft[] zzftArr = zzfw.zzaxi;
                    if (zzftArr != null) {
                        for (zzft zzft : zzftArr) {
                            if (zzft != null) {
                                zza(sb, 2);
                                sb.append("event {\n");
                                zza(sb, 2, "name", (Object) zzgq().zzbt(zzft.name));
                                zza(sb, 2, "timestamp_millis", (Object) zzft.zzaxb);
                                zza(sb, 2, "previous_timestamp_millis", (Object) zzft.zzaxc);
                                zza(sb, 2, "count", (Object) zzft.count);
                                com.google.android.gms.internal.measurement.zzfu[] zzfuArr = zzft.zzaxa;
                                if (zzfuArr != null) {
                                    for (com.google.android.gms.internal.measurement.zzfu zzfu : zzfuArr) {
                                        if (zzfu != null) {
                                            zza(sb, 3);
                                            sb.append("param {\n");
                                            zza(sb, 3, "name", (Object) zzgq().zzbu(zzfu.name));
                                            zza(sb, 3, "string_value", (Object) zzfu.zzaml);
                                            zza(sb, 3, "int_value", (Object) zzfu.zzaxe);
                                            zza(sb, 3, "double_value", (Object) zzfu.zzaun);
                                            zza(sb, 3);
                                            sb.append("}\n");
                                        }
                                    }
                                }
                                zza(sb, 2);
                                sb.append("}\n");
                            }
                        }
                    }
                    zza(sb, 1);
                    sb.append("}\n");
                }
            }
        }
        sb.append("}\n");
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    public final String zza(zzfj zzfj) {
        if (zzfj == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nevent_filter {\n");
        zza(sb, 0, "filter_id", (Object) zzfj.zzavk);
        zza(sb, 0, "event_name", (Object) zzgq().zzbt(zzfj.zzavl));
        zza(sb, 1, "event_count_filter", zzfj.zzavo);
        sb.append("  filters {\n");
        for (zzfk zza : zzfj.zzavm) {
            zza(sb, 2, zza);
        }
        zza(sb, 1);
        sb.append("}\n}\n");
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    public final String zza(zzfm zzfm) {
        if (zzfm == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nproperty_filter {\n");
        zza(sb, 0, "filter_id", (Object) zzfm.zzavk);
        zza(sb, 0, "property_name", (Object) zzgq().zzbv(zzfm.zzawa));
        zza(sb, 1, zzfm.zzawb);
        sb.append("}\n");
        return sb.toString();
    }

    private final void zza(StringBuilder sb, int i, String str, zzfx zzfx, String str2) {
        if (zzfx != null) {
            zza(sb, 3);
            sb.append(str);
            sb.append(" {\n");
            if (zzfx.zzayo != null) {
                zza(sb, 4);
                sb.append("results: ");
                long[] jArr = zzfx.zzayo;
                int length = jArr.length;
                int i2 = 0;
                int i3 = 0;
                while (i2 < length) {
                    Long valueOf = Long.valueOf(jArr[i2]);
                    int i4 = i3 + 1;
                    if (i3 != 0) {
                        sb.append(", ");
                    }
                    sb.append(valueOf);
                    i2++;
                    i3 = i4;
                }
                sb.append(10);
            }
            if (zzfx.zzayn != null) {
                zza(sb, 4);
                sb.append("status: ");
                long[] jArr2 = zzfx.zzayn;
                int length2 = jArr2.length;
                int i5 = 0;
                int i6 = 0;
                while (i5 < length2) {
                    Long valueOf2 = Long.valueOf(jArr2[i5]);
                    int i7 = i6 + 1;
                    if (i6 != 0) {
                        sb.append(", ");
                    }
                    sb.append(valueOf2);
                    i5++;
                    i6 = i7;
                }
                sb.append(10);
            }
            if (zzgv().zzbb(str2)) {
                if (zzfx.zzayp != null) {
                    zza(sb, 4);
                    sb.append("dynamic_filter_timestamps: {");
                    zzfs[] zzfsArr = zzfx.zzayp;
                    int length3 = zzfsArr.length;
                    int i8 = 0;
                    int i9 = 0;
                    while (i8 < length3) {
                        zzfs zzfs = zzfsArr[i8];
                        int i10 = i9 + 1;
                        if (i9 != 0) {
                            sb.append(", ");
                        }
                        sb.append(zzfs.zzawx);
                        sb.append(":");
                        sb.append(zzfs.zzawy);
                        i8++;
                        i9 = i10;
                    }
                    sb.append("}\n");
                }
                if (zzfx.zzayq != null) {
                    zza(sb, 4);
                    sb.append("sequence_filter_timestamps: {");
                    zzfy[] zzfyArr = zzfx.zzayq;
                    int length4 = zzfyArr.length;
                    int i11 = 0;
                    int i12 = 0;
                    while (i11 < length4) {
                        zzfy zzfy = zzfyArr[i11];
                        int i13 = i12 + 1;
                        if (i12 != 0) {
                            sb.append(", ");
                        }
                        sb.append(zzfy.zzawx);
                        sb.append(": [");
                        long[] jArr3 = zzfy.zzays;
                        int length5 = jArr3.length;
                        int i14 = 0;
                        int i15 = 0;
                        while (i14 < length5) {
                            long j = jArr3[i14];
                            int i16 = i15 + 1;
                            if (i15 != 0) {
                                sb.append(", ");
                            }
                            sb.append(j);
                            i14++;
                            i15 = i16;
                        }
                        sb.append("]");
                        i11++;
                        i12 = i13;
                    }
                    sb.append("}\n");
                }
            }
            zza(sb, 3);
            sb.append("}\n");
        }
    }

    private final void zza(StringBuilder sb, int i, String str, zzfl zzfl) {
        if (zzfl != null) {
            zza(sb, i);
            sb.append(str);
            sb.append(" {\n");
            if (zzfl.zzavu != null) {
                String str2 = "UNKNOWN_COMPARISON_TYPE";
                switch (zzfl.zzavu.intValue()) {
                    case 1:
                        str2 = "LESS_THAN";
                        break;
                    case 2:
                        str2 = "GREATER_THAN";
                        break;
                    case 3:
                        str2 = "EQUAL";
                        break;
                    case 4:
                        str2 = "BETWEEN";
                        break;
                }
                zza(sb, i, "comparison_type", (Object) str2);
            }
            zza(sb, i, "match_as_float", (Object) zzfl.zzavv);
            zza(sb, i, "comparison_value", (Object) zzfl.zzavw);
            zza(sb, i, "min_comparison_value", (Object) zzfl.zzavx);
            zza(sb, i, "max_comparison_value", (Object) zzfl.zzavy);
            zza(sb, i);
            sb.append("}\n");
        }
    }

    private final void zza(StringBuilder sb, int i, zzfk zzfk) {
        String[] strArr;
        if (zzfk != null) {
            zza(sb, i);
            sb.append("filter {\n");
            zza(sb, i, "complement", (Object) zzfk.zzavs);
            zza(sb, i, "param_name", (Object) zzgq().zzbu(zzfk.zzavt));
            int i2 = i + 1;
            String str = "string_filter";
            zzfn zzfn = zzfk.zzavq;
            if (zzfn != null) {
                zza(sb, i2);
                sb.append(str);
                sb.append(" {\n");
                if (zzfn.zzawc != null) {
                    String str2 = "UNKNOWN_MATCH_TYPE";
                    switch (zzfn.zzawc.intValue()) {
                        case 1:
                            str2 = "REGEXP";
                            break;
                        case 2:
                            str2 = "BEGINS_WITH";
                            break;
                        case 3:
                            str2 = "ENDS_WITH";
                            break;
                        case 4:
                            str2 = "PARTIAL";
                            break;
                        case 5:
                            str2 = "EXACT";
                            break;
                        case 6:
                            str2 = "IN_LIST";
                            break;
                    }
                    zza(sb, i2, "match_type", (Object) str2);
                }
                zza(sb, i2, "expression", (Object) zzfn.zzawd);
                zza(sb, i2, "case_sensitive", (Object) zzfn.zzawe);
                if (zzfn.zzawf.length > 0) {
                    zza(sb, i2 + 1);
                    sb.append("expression_list {\n");
                    for (String str3 : zzfn.zzawf) {
                        zza(sb, i2 + 2);
                        sb.append(str3);
                        sb.append("\n");
                    }
                    sb.append("}\n");
                }
                zza(sb, i2);
                sb.append("}\n");
            }
            zza(sb, i2, "number_filter", zzfk.zzavr);
            zza(sb, i);
            sb.append("}\n");
        }
    }

    private static void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
    }

    private static void zza(StringBuilder sb, int i, String str, Object obj) {
        if (obj != null) {
            zza(sb, i + 1);
            sb.append(str);
            sb.append(": ");
            sb.append(obj);
            sb.append(10);
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        zzgt().zzjg().zzby("Failed to load parcelable from buffer");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002c, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        r1.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0030, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T extends android.os.Parcelable> T zza(byte[] r5, android.os.Parcelable.Creator<T> r6) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            android.os.Parcel r1 = android.os.Parcel.obtain()
            int r2 = r5.length     // Catch:{ ParseException -> 0x001c }
            r3 = 0
            r1.unmarshall(r5, r3, r2)     // Catch:{ ParseException -> 0x001c }
            r1.setDataPosition(r3)     // Catch:{ ParseException -> 0x001c }
            java.lang.Object r5 = r6.createFromParcel(r1)     // Catch:{ ParseException -> 0x001c }
            android.os.Parcelable r5 = (android.os.Parcelable) r5     // Catch:{ ParseException -> 0x001c }
            r1.recycle()
            return r5
        L_0x001a:
            r5 = move-exception
            goto L_0x002d
        L_0x001c:
            com.google.android.gms.measurement.internal.zzas r5 = r4.zzgt()     // Catch:{ all -> 0x001a }
            com.google.android.gms.measurement.internal.zzau r5 = r5.zzjg()     // Catch:{ all -> 0x001a }
            java.lang.String r6 = "Failed to load parcelable from buffer"
            r5.zzby(r6)     // Catch:{ all -> 0x001a }
            r1.recycle()
            return r0
        L_0x002d:
            r1.recycle()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfu.zza(byte[], android.os.Parcelable$Creator):android.os.Parcelable");
    }

    /* access modifiers changed from: 0000 */
    public final boolean zze(zzag zzag, zzk zzk) {
        Preconditions.checkNotNull(zzag);
        Preconditions.checkNotNull(zzk);
        if (!TextUtils.isEmpty(zzk.zzafi) || !TextUtils.isEmpty(zzk.zzafv)) {
            return true;
        }
        zzgw();
        return false;
    }

    static boolean zzcs(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    static boolean zza(long[] jArr, int i) {
        if (i >= (jArr.length << 6)) {
            return false;
        }
        if (((1 << (i % 64)) & jArr[i / 64]) != 0) {
            return true;
        }
        return false;
    }

    static long[] zza(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        long[] jArr = new long[length];
        for (int i = 0; i < length; i++) {
            jArr[i] = 0;
            for (int i2 = 0; i2 < 64; i2++) {
                int i3 = (i << 6) + i2;
                if (i3 >= bitSet.length()) {
                    break;
                }
                if (bitSet.get(i3)) {
                    jArr[i] = jArr[i] | (1 << i2);
                }
            }
        }
        return jArr;
    }

    /* access modifiers changed from: 0000 */
    public final boolean zzb(long j, long j2) {
        return j == 0 || j2 <= 0 || Math.abs(zzbx().currentTimeMillis() - j) > j2;
    }

    /* access modifiers changed from: 0000 */
    public final byte[] zza(byte[] bArr) throws IOException {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e) {
            zzgt().zzjg().zzg("Failed to ungzip content", e);
            throw e;
        }
    }

    /* access modifiers changed from: 0000 */
    public final byte[] zzb(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            zzgt().zzjg().zzg("Failed to gzip content", e);
            throw e;
        }
    }

    /* access modifiers changed from: 0000 */
    public final int[] zzmi() {
        Map zzm = zzai.zzm(this.zzamv.getContext());
        if (zzm == null || zzm.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int intValue = ((Integer) zzai.zzakg.get()).intValue();
        Iterator it = zzm.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Entry entry = (Entry) it.next();
            if (((String) entry.getKey()).startsWith("measurement.id.")) {
                try {
                    int parseInt = Integer.parseInt((String) entry.getValue());
                    if (parseInt != 0) {
                        arrayList.add(Integer.valueOf(parseInt));
                        if (arrayList.size() >= intValue) {
                            zzgt().zzjj().zzg("Too many experiment IDs. Number of IDs", Integer.valueOf(arrayList.size()));
                            break;
                        }
                    } else {
                        continue;
                    }
                } catch (NumberFormatException e) {
                    zzgt().zzjj().zzg("Experiment ID NumberFormatException", e);
                }
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        int[] iArr = new int[arrayList.size()];
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            int i3 = i2 + 1;
            iArr[i2] = ((Integer) obj).intValue();
            i2 = i3;
        }
        return iArr;
    }

    public final /* bridge */ /* synthetic */ zzfu zzjr() {
        return super.zzjr();
    }

    public final /* bridge */ /* synthetic */ zzm zzjs() {
        return super.zzjs();
    }

    public final /* bridge */ /* synthetic */ zzt zzjt() {
        return super.zzjt();
    }

    public final /* bridge */ /* synthetic */ void zzgf() {
        super.zzgf();
    }

    public final /* bridge */ /* synthetic */ void zzgg() {
        super.zzgg();
    }

    public final /* bridge */ /* synthetic */ void zzgh() {
        super.zzgh();
    }

    public final /* bridge */ /* synthetic */ void zzaf() {
        super.zzaf();
    }

    public final /* bridge */ /* synthetic */ zzaa zzgp() {
        return super.zzgp();
    }

    public final /* bridge */ /* synthetic */ Clock zzbx() {
        return super.zzbx();
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public final /* bridge */ /* synthetic */ zzaq zzgq() {
        return super.zzgq();
    }

    public final /* bridge */ /* synthetic */ zzfy zzgr() {
        return super.zzgr();
    }

    public final /* bridge */ /* synthetic */ zzbr zzgs() {
        return super.zzgs();
    }

    public final /* bridge */ /* synthetic */ zzas zzgt() {
        return super.zzgt();
    }

    public final /* bridge */ /* synthetic */ zzbd zzgu() {
        return super.zzgu();
    }

    public final /* bridge */ /* synthetic */ zzq zzgv() {
        return super.zzgv();
    }

    public final /* bridge */ /* synthetic */ zzn zzgw() {
        return super.zzgw();
    }
}
