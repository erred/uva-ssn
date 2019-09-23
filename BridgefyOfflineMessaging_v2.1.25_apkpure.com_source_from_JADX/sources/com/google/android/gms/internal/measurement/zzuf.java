package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzuh;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

final class zzuf<FieldDescriptorType extends zzuh<FieldDescriptorType>> {
    private static final zzuf zzbvj = new zzuf(true);
    private boolean zzbpy;
    private final zzwo<FieldDescriptorType, Object> zzbvh = zzwo.zzbw(16);
    private boolean zzbvi = false;

    private zzuf() {
    }

    private zzuf(boolean z) {
        zzsw();
    }

    public static <T extends zzuh<T>> zzuf<T> zzvw() {
        return zzbvj;
    }

    /* access modifiers changed from: 0000 */
    public final boolean isEmpty() {
        return this.zzbvh.isEmpty();
    }

    public final void zzsw() {
        if (!this.zzbpy) {
            this.zzbvh.zzsw();
            this.zzbpy = true;
        }
    }

    public final boolean isImmutable() {
        return this.zzbpy;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzuf)) {
            return false;
        }
        return this.zzbvh.equals(((zzuf) obj).zzbvh);
    }

    public final int hashCode() {
        return this.zzbvh.hashCode();
    }

    public final Iterator<Entry<FieldDescriptorType, Object>> iterator() {
        if (this.zzbvi) {
            return new zzvb(this.zzbvh.entrySet().iterator());
        }
        return this.zzbvh.entrySet().iterator();
    }

    /* access modifiers changed from: 0000 */
    public final Iterator<Entry<FieldDescriptorType, Object>> descendingIterator() {
        if (this.zzbvi) {
            return new zzvb(this.zzbvh.zzye().iterator());
        }
        return this.zzbvh.zzye().iterator();
    }

    private final Object zza(FieldDescriptorType fielddescriptortype) {
        Object obj = this.zzbvh.get(fielddescriptortype);
        return obj instanceof zzuy ? zzuy.zzwz() : obj;
    }

    private final void zza(FieldDescriptorType fielddescriptortype, Object obj) {
        if (!fielddescriptortype.zzwb()) {
            zza(fielddescriptortype.zzvz(), obj);
            r7 = obj;
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList2.get(i);
                i++;
                zza(fielddescriptortype.zzvz(), obj2);
            }
            r7 = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (r7 instanceof zzuy) {
            this.zzbvi = true;
        }
        this.zzbvh.put(fielddescriptortype, r7);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001b, code lost:
        if ((r3 instanceof com.google.android.gms.internal.measurement.zzuy) == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        if ((r3 instanceof com.google.android.gms.internal.measurement.zzur) == false) goto L_0x0043;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zza(com.google.android.gms.internal.measurement.zzxs r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.measurement.zzuq.checkNotNull(r3)
            int[] r0 = com.google.android.gms.internal.measurement.zzug.zzbvk
            com.google.android.gms.internal.measurement.zzxx r2 = r2.zzyv()
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 1
            r1 = 0
            switch(r2) {
                case 1: goto L_0x0040;
                case 2: goto L_0x003d;
                case 3: goto L_0x003a;
                case 4: goto L_0x0037;
                case 5: goto L_0x0034;
                case 6: goto L_0x0031;
                case 7: goto L_0x0028;
                case 8: goto L_0x001e;
                case 9: goto L_0x0015;
                default: goto L_0x0014;
            }
        L_0x0014:
            goto L_0x0043
        L_0x0015:
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzvv
            if (r2 != 0) goto L_0x0026
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzuy
            if (r2 == 0) goto L_0x0043
            goto L_0x0026
        L_0x001e:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L_0x0026
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzur
            if (r2 == 0) goto L_0x0043
        L_0x0026:
            r1 = 1
            goto L_0x0043
        L_0x0028:
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzte
            if (r2 != 0) goto L_0x0026
            boolean r2 = r3 instanceof byte[]
            if (r2 == 0) goto L_0x0043
            goto L_0x0026
        L_0x0031:
            boolean r0 = r3 instanceof java.lang.String
            goto L_0x0042
        L_0x0034:
            boolean r0 = r3 instanceof java.lang.Boolean
            goto L_0x0042
        L_0x0037:
            boolean r0 = r3 instanceof java.lang.Double
            goto L_0x0042
        L_0x003a:
            boolean r0 = r3 instanceof java.lang.Float
            goto L_0x0042
        L_0x003d:
            boolean r0 = r3 instanceof java.lang.Long
            goto L_0x0042
        L_0x0040:
            boolean r0 = r3 instanceof java.lang.Integer
        L_0x0042:
            r1 = r0
        L_0x0043:
            if (r1 == 0) goto L_0x0046
            return
        L_0x0046:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Wrong object type used with protocol message reflection."
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzuf.zza(com.google.android.gms.internal.measurement.zzxs, java.lang.Object):void");
    }

    public final boolean isInitialized() {
        for (int i = 0; i < this.zzbvh.zzyc(); i++) {
            if (!zzc(this.zzbvh.zzbx(i))) {
                return false;
            }
        }
        for (Entry zzc : this.zzbvh.zzyd()) {
            if (!zzc(zzc)) {
                return false;
            }
        }
        return true;
    }

    private static boolean zzc(Entry<FieldDescriptorType, Object> entry) {
        zzuh zzuh = (zzuh) entry.getKey();
        if (zzuh.zzwa() == zzxx.MESSAGE) {
            if (zzuh.zzwb()) {
                for (zzvv isInitialized : (List) entry.getValue()) {
                    if (!isInitialized.isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzvv) {
                    if (!((zzvv) value).isInitialized()) {
                        return false;
                    }
                } else if (value instanceof zzuy) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void zza(zzuf<FieldDescriptorType> zzuf) {
        for (int i = 0; i < zzuf.zzbvh.zzyc(); i++) {
            zzd(zzuf.zzbvh.zzbx(i));
        }
        for (Entry zzd : zzuf.zzbvh.zzyd()) {
            zzd(zzd);
        }
    }

    private static Object zzz(Object obj) {
        if (obj instanceof zzwb) {
            return ((zzwb) obj).zzxp();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private final void zzd(Entry<FieldDescriptorType, Object> entry) {
        Object obj;
        zzuh zzuh = (zzuh) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzuy) {
            value = zzuy.zzwz();
        }
        if (zzuh.zzwb()) {
            Object zza = zza((FieldDescriptorType) zzuh);
            if (zza == null) {
                zza = new ArrayList();
            }
            for (Object zzz : (List) value) {
                ((List) zza).add(zzz(zzz));
            }
            this.zzbvh.put(zzuh, zza);
        } else if (zzuh.zzwa() == zzxx.MESSAGE) {
            Object zza2 = zza((FieldDescriptorType) zzuh);
            if (zza2 == null) {
                this.zzbvh.put(zzuh, zzz(value));
                return;
            }
            if (zza2 instanceof zzwb) {
                obj = zzuh.zza((zzwb) zza2, (zzwb) value);
            } else {
                obj = zzuh.zza(((zzvv) zza2).zzwh(), (zzvv) value).zzwo();
            }
            this.zzbvh.put(zzuh, obj);
        } else {
            this.zzbvh.put(zzuh, zzz(value));
        }
    }

    static void zza(zztv zztv, zzxs zzxs, int i, Object obj) throws IOException {
        if (zzxs == zzxs.GROUP) {
            zzvv zzvv = (zzvv) obj;
            zzuq.zzf(zzvv);
            zztv.zzc(i, 3);
            zzvv.zzb(zztv);
            zztv.zzc(i, 4);
            return;
        }
        zztv.zzc(i, zzxs.zzyw());
        switch (zzug.zzbul[zzxs.ordinal()]) {
            case 1:
                zztv.zzb(((Double) obj).doubleValue());
                return;
            case 2:
                zztv.zza(((Float) obj).floatValue());
                return;
            case 3:
                zztv.zzat(((Long) obj).longValue());
                return;
            case 4:
                zztv.zzat(((Long) obj).longValue());
                return;
            case 5:
                zztv.zzaz(((Integer) obj).intValue());
                return;
            case 6:
                zztv.zzav(((Long) obj).longValue());
                return;
            case 7:
                zztv.zzbc(((Integer) obj).intValue());
                return;
            case 8:
                zztv.zzs(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzvv) obj).zzb(zztv);
                return;
            case 10:
                zztv.zzb((zzvv) obj);
                return;
            case 11:
                if (obj instanceof zzte) {
                    zztv.zza((zzte) obj);
                    return;
                } else {
                    zztv.zzgb((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzte) {
                    zztv.zza((zzte) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zztv.zze(bArr, 0, bArr.length);
                return;
            case 13:
                zztv.zzba(((Integer) obj).intValue());
                return;
            case 14:
                zztv.zzbc(((Integer) obj).intValue());
                return;
            case 15:
                zztv.zzav(((Long) obj).longValue());
                return;
            case 16:
                zztv.zzbb(((Integer) obj).intValue());
                return;
            case 17:
                zztv.zzau(((Long) obj).longValue());
                return;
            case 18:
                if (!(obj instanceof zzur)) {
                    zztv.zzaz(((Integer) obj).intValue());
                    break;
                } else {
                    zztv.zzaz(((zzur) obj).zzc());
                    return;
                }
        }
    }

    public final int zzvx() {
        int i = 0;
        for (int i2 = 0; i2 < this.zzbvh.zzyc(); i2++) {
            Entry zzbx = this.zzbvh.zzbx(i2);
            i += zzb((zzuh) zzbx.getKey(), zzbx.getValue());
        }
        for (Entry entry : this.zzbvh.zzyd()) {
            i += zzb((zzuh) entry.getKey(), entry.getValue());
        }
        return i;
    }

    public final int zzvy() {
        int i = 0;
        for (int i2 = 0; i2 < this.zzbvh.zzyc(); i2++) {
            i += zze(this.zzbvh.zzbx(i2));
        }
        for (Entry zze : this.zzbvh.zzyd()) {
            i += zze(zze);
        }
        return i;
    }

    private static int zze(Entry<FieldDescriptorType, Object> entry) {
        zzuh zzuh = (zzuh) entry.getKey();
        Object value = entry.getValue();
        if (zzuh.zzwa() != zzxx.MESSAGE || zzuh.zzwb() || zzuh.zzwc()) {
            return zzb(zzuh, value);
        }
        if (value instanceof zzuy) {
            return zztv.zzb(((zzuh) entry.getKey()).zzc(), (zzvc) (zzuy) value);
        }
        return zztv.zzd(((zzuh) entry.getKey()).zzc(), (zzvv) value);
    }

    static int zza(zzxs zzxs, int i, Object obj) {
        int zzbd = zztv.zzbd(i);
        if (zzxs == zzxs.GROUP) {
            zzuq.zzf((zzvv) obj);
            zzbd <<= 1;
        }
        return zzbd + zzb(zzxs, obj);
    }

    private static int zzb(zzxs zzxs, Object obj) {
        switch (zzug.zzbul[zzxs.ordinal()]) {
            case 1:
                return zztv.zzc(((Double) obj).doubleValue());
            case 2:
                return zztv.zzb(((Float) obj).floatValue());
            case 3:
                return zztv.zzaw(((Long) obj).longValue());
            case 4:
                return zztv.zzax(((Long) obj).longValue());
            case 5:
                return zztv.zzbe(((Integer) obj).intValue());
            case 6:
                return zztv.zzaz(((Long) obj).longValue());
            case 7:
                return zztv.zzbh(((Integer) obj).intValue());
            case 8:
                return zztv.zzt(((Boolean) obj).booleanValue());
            case 9:
                return zztv.zzd((zzvv) obj);
            case 10:
                if (obj instanceof zzuy) {
                    return zztv.zza((zzvc) (zzuy) obj);
                }
                return zztv.zzc((zzvv) obj);
            case 11:
                if (obj instanceof zzte) {
                    return zztv.zzb((zzte) obj);
                }
                return zztv.zzgc((String) obj);
            case 12:
                if (obj instanceof zzte) {
                    return zztv.zzb((zzte) obj);
                }
                return zztv.zzk((byte[]) obj);
            case 13:
                return zztv.zzbf(((Integer) obj).intValue());
            case 14:
                return zztv.zzbi(((Integer) obj).intValue());
            case 15:
                return zztv.zzba(((Long) obj).longValue());
            case 16:
                return zztv.zzbg(((Integer) obj).intValue());
            case 17:
                return zztv.zzay(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzur) {
                    return zztv.zzbj(((zzur) obj).zzc());
                }
                return zztv.zzbj(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    private static int zzb(zzuh<?> zzuh, Object obj) {
        zzxs zzvz = zzuh.zzvz();
        int zzc = zzuh.zzc();
        if (!zzuh.zzwb()) {
            return zza(zzvz, zzc, obj);
        }
        int i = 0;
        if (zzuh.zzwc()) {
            for (Object zzb : (List) obj) {
                i += zzb(zzvz, zzb);
            }
            return zztv.zzbd(zzc) + i + zztv.zzbl(i);
        }
        for (Object zza : (List) obj) {
            i += zza(zzvz, zzc, zza);
        }
        return i;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzuf zzuf = new zzuf();
        for (int i = 0; i < this.zzbvh.zzyc(); i++) {
            Entry zzbx = this.zzbvh.zzbx(i);
            zzuf.zza((FieldDescriptorType) (zzuh) zzbx.getKey(), zzbx.getValue());
        }
        for (Entry entry : this.zzbvh.zzyd()) {
            zzuf.zza((FieldDescriptorType) (zzuh) entry.getKey(), entry.getValue());
        }
        zzuf.zzbvi = this.zzbvi;
        return zzuf;
    }
}
