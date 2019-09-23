package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzfm;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

final class zzfk<FieldDescriptorType extends zzfm<FieldDescriptorType>> {
    private static final zzfk zzue = new zzfk(true);
    private final zzhz<FieldDescriptorType, Object> zzub = zzhz.zzbb(16);
    private boolean zzuc;
    private boolean zzud = false;

    private zzfk() {
    }

    private zzfk(boolean z) {
        zzev();
    }

    public static <T extends zzfm<T>> zzfk<T> zzgv() {
        return zzue;
    }

    /* access modifiers changed from: 0000 */
    public final boolean isEmpty() {
        return this.zzub.isEmpty();
    }

    public final void zzev() {
        if (!this.zzuc) {
            this.zzub.zzev();
            this.zzuc = true;
        }
    }

    public final boolean isImmutable() {
        return this.zzuc;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfk)) {
            return false;
        }
        return this.zzub.equals(((zzfk) obj).zzub);
    }

    public final int hashCode() {
        return this.zzub.hashCode();
    }

    public final Iterator<Entry<FieldDescriptorType, Object>> iterator() {
        if (this.zzud) {
            return new zzgi(this.zzub.entrySet().iterator());
        }
        return this.zzub.entrySet().iterator();
    }

    /* access modifiers changed from: 0000 */
    public final Iterator<Entry<FieldDescriptorType, Object>> descendingIterator() {
        if (this.zzud) {
            return new zzgi(this.zzub.zzjh().iterator());
        }
        return this.zzub.zzjh().iterator();
    }

    private final Object zza(FieldDescriptorType fielddescriptortype) {
        Object obj = this.zzub.get(fielddescriptortype);
        return obj instanceof zzgf ? zzgf.zzia() : obj;
    }

    private final void zza(FieldDescriptorType fielddescriptortype, Object obj) {
        if (!fielddescriptortype.zzha()) {
            zza(fielddescriptortype.zzgy(), obj);
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
                zza(fielddescriptortype.zzgy(), obj2);
            }
            r7 = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (r7 instanceof zzgf) {
            this.zzud = true;
        }
        this.zzub.put(fielddescriptortype, r7);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001b, code lost:
        if ((r3 instanceof com.google.android.gms.internal.firebase_auth.zzgf) == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        if ((r3 instanceof com.google.android.gms.internal.firebase_auth.zzfw) == false) goto L_0x0043;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zza(com.google.android.gms.internal.firebase_auth.zzjf r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.firebase_auth.zzfv.checkNotNull(r3)
            int[] r0 = com.google.android.gms.internal.firebase_auth.zzfl.zzuf
            com.google.android.gms.internal.firebase_auth.zzjk r2 = r2.zzjy()
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
            boolean r2 = r3 instanceof com.google.android.gms.internal.firebase_auth.zzhc
            if (r2 != 0) goto L_0x0026
            boolean r2 = r3 instanceof com.google.android.gms.internal.firebase_auth.zzgf
            if (r2 == 0) goto L_0x0043
            goto L_0x0026
        L_0x001e:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L_0x0026
            boolean r2 = r3 instanceof com.google.android.gms.internal.firebase_auth.zzfw
            if (r2 == 0) goto L_0x0043
        L_0x0026:
            r1 = 1
            goto L_0x0043
        L_0x0028:
            boolean r2 = r3 instanceof com.google.android.gms.internal.firebase_auth.zzeh
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzfk.zza(com.google.android.gms.internal.firebase_auth.zzjf, java.lang.Object):void");
    }

    public final boolean isInitialized() {
        for (int i = 0; i < this.zzub.zzjf(); i++) {
            if (!zzb(this.zzub.zzbc(i))) {
                return false;
            }
        }
        for (Entry zzb : this.zzub.zzjg()) {
            if (!zzb(zzb)) {
                return false;
            }
        }
        return true;
    }

    private static boolean zzb(Entry<FieldDescriptorType, Object> entry) {
        zzfm zzfm = (zzfm) entry.getKey();
        if (zzfm.zzgz() == zzjk.MESSAGE) {
            if (zzfm.zzha()) {
                for (zzhc isInitialized : (List) entry.getValue()) {
                    if (!isInitialized.isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzhc) {
                    if (!((zzhc) value).isInitialized()) {
                        return false;
                    }
                } else if (value instanceof zzgf) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void zza(zzfk<FieldDescriptorType> zzfk) {
        for (int i = 0; i < zzfk.zzub.zzjf(); i++) {
            zzc(zzfk.zzub.zzbc(i));
        }
        for (Entry zzc : zzfk.zzub.zzjg()) {
            zzc(zzc);
        }
    }

    private static Object zzg(Object obj) {
        if (obj instanceof zzhi) {
            return ((zzhi) obj).zziq();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private final void zzc(Entry<FieldDescriptorType, Object> entry) {
        Object obj;
        zzfm zzfm = (zzfm) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzgf) {
            value = zzgf.zzia();
        }
        if (zzfm.zzha()) {
            Object zza = zza((FieldDescriptorType) zzfm);
            if (zza == null) {
                zza = new ArrayList();
            }
            for (Object zzg : (List) value) {
                ((List) zza).add(zzg(zzg));
            }
            this.zzub.put(zzfm, zza);
        } else if (zzfm.zzgz() == zzjk.MESSAGE) {
            Object zza2 = zza((FieldDescriptorType) zzfm);
            if (zza2 == null) {
                this.zzub.put(zzfm, zzg(value));
                return;
            }
            if (zza2 instanceof zzhi) {
                obj = zzfm.zza((zzhi) zza2, (zzhi) value);
            } else {
                obj = zzfm.zza(((zzhc) zza2).zzhg(), (zzhc) value).zzhn();
            }
            this.zzub.put(zzfm, obj);
        } else {
            this.zzub.put(zzfm, zzg(value));
        }
    }

    static void zza(zzfa zzfa, zzjf zzjf, int i, Object obj) throws IOException {
        if (zzjf == zzjf.GROUP) {
            zzhc zzhc = (zzhc) obj;
            zzfv.zzg(zzhc);
            zzfa.zzf(i, 3);
            zzhc.zzb(zzfa);
            zzfa.zzf(i, 4);
            return;
        }
        zzfa.zzf(i, zzjf.zzjz());
        switch (zzfl.zzto[zzjf.ordinal()]) {
            case 1:
                zzfa.zza(((Double) obj).doubleValue());
                return;
            case 2:
                zzfa.zza(((Float) obj).floatValue());
                return;
            case 3:
                zzfa.zzb(((Long) obj).longValue());
                return;
            case 4:
                zzfa.zzb(((Long) obj).longValue());
                return;
            case 5:
                zzfa.zzac(((Integer) obj).intValue());
                return;
            case 6:
                zzfa.zzd(((Long) obj).longValue());
                return;
            case 7:
                zzfa.zzaf(((Integer) obj).intValue());
                return;
            case 8:
                zzfa.zzs(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzhc) obj).zzb(zzfa);
                return;
            case 10:
                zzfa.zzc((zzhc) obj);
                return;
            case 11:
                if (obj instanceof zzeh) {
                    zzfa.zza((zzeh) obj);
                    return;
                } else {
                    zzfa.zzda((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzeh) {
                    zzfa.zza((zzeh) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzfa.zzd(bArr, 0, bArr.length);
                return;
            case 13:
                zzfa.zzad(((Integer) obj).intValue());
                return;
            case 14:
                zzfa.zzaf(((Integer) obj).intValue());
                return;
            case 15:
                zzfa.zzd(((Long) obj).longValue());
                return;
            case 16:
                zzfa.zzae(((Integer) obj).intValue());
                return;
            case 17:
                zzfa.zzc(((Long) obj).longValue());
                return;
            case 18:
                if (!(obj instanceof zzfw)) {
                    zzfa.zzac(((Integer) obj).intValue());
                    break;
                } else {
                    zzfa.zzac(((zzfw) obj).zzbi());
                    return;
                }
        }
    }

    public final int zzgw() {
        int i = 0;
        for (int i2 = 0; i2 < this.zzub.zzjf(); i2++) {
            Entry zzbc = this.zzub.zzbc(i2);
            i += zzb((zzfm) zzbc.getKey(), zzbc.getValue());
        }
        for (Entry entry : this.zzub.zzjg()) {
            i += zzb((zzfm) entry.getKey(), entry.getValue());
        }
        return i;
    }

    public final int zzgx() {
        int i = 0;
        for (int i2 = 0; i2 < this.zzub.zzjf(); i2++) {
            i += zzd(this.zzub.zzbc(i2));
        }
        for (Entry zzd : this.zzub.zzjg()) {
            i += zzd(zzd);
        }
        return i;
    }

    private static int zzd(Entry<FieldDescriptorType, Object> entry) {
        zzfm zzfm = (zzfm) entry.getKey();
        Object value = entry.getValue();
        if (zzfm.zzgz() != zzjk.MESSAGE || zzfm.zzha() || zzfm.zzhb()) {
            return zzb(zzfm, value);
        }
        if (value instanceof zzgf) {
            return zzfa.zzb(((zzfm) entry.getKey()).zzbi(), (zzgj) (zzgf) value);
        }
        return zzfa.zzb(((zzfm) entry.getKey()).zzbi(), (zzhc) value);
    }

    static int zza(zzjf zzjf, int i, Object obj) {
        int zzag = zzfa.zzag(i);
        if (zzjf == zzjf.GROUP) {
            zzfv.zzg((zzhc) obj);
            zzag <<= 1;
        }
        return zzag + zzb(zzjf, obj);
    }

    private static int zzb(zzjf zzjf, Object obj) {
        switch (zzfl.zzto[zzjf.ordinal()]) {
            case 1:
                return zzfa.zzb(((Double) obj).doubleValue());
            case 2:
                return zzfa.zzb(((Float) obj).floatValue());
            case 3:
                return zzfa.zze(((Long) obj).longValue());
            case 4:
                return zzfa.zzf(((Long) obj).longValue());
            case 5:
                return zzfa.zzah(((Integer) obj).intValue());
            case 6:
                return zzfa.zzh(((Long) obj).longValue());
            case 7:
                return zzfa.zzak(((Integer) obj).intValue());
            case 8:
                return zzfa.zzt(((Boolean) obj).booleanValue());
            case 9:
                return zzfa.zze((zzhc) obj);
            case 10:
                if (obj instanceof zzgf) {
                    return zzfa.zza((zzgj) (zzgf) obj);
                }
                return zzfa.zzd((zzhc) obj);
            case 11:
                if (obj instanceof zzeh) {
                    return zzfa.zzb((zzeh) obj);
                }
                return zzfa.zzdb((String) obj);
            case 12:
                if (obj instanceof zzeh) {
                    return zzfa.zzb((zzeh) obj);
                }
                return zzfa.zzc((byte[]) obj);
            case 13:
                return zzfa.zzai(((Integer) obj).intValue());
            case 14:
                return zzfa.zzal(((Integer) obj).intValue());
            case 15:
                return zzfa.zzi(((Long) obj).longValue());
            case 16:
                return zzfa.zzaj(((Integer) obj).intValue());
            case 17:
                return zzfa.zzg(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzfw) {
                    return zzfa.zzam(((zzfw) obj).zzbi());
                }
                return zzfa.zzam(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    private static int zzb(zzfm<?> zzfm, Object obj) {
        zzjf zzgy = zzfm.zzgy();
        int zzbi = zzfm.zzbi();
        if (!zzfm.zzha()) {
            return zza(zzgy, zzbi, obj);
        }
        int i = 0;
        if (zzfm.zzhb()) {
            for (Object zzb : (List) obj) {
                i += zzb(zzgy, zzb);
            }
            return zzfa.zzag(zzbi) + i + zzfa.zzao(i);
        }
        for (Object zza : (List) obj) {
            i += zza(zzgy, zzbi, zza);
        }
        return i;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzfk zzfk = new zzfk();
        for (int i = 0; i < this.zzub.zzjf(); i++) {
            Entry zzbc = this.zzub.zzbc(i);
            zzfk.zza((FieldDescriptorType) (zzfm) zzbc.getKey(), zzbc.getValue());
        }
        for (Entry entry : this.zzub.zzjg()) {
            zzfk.zza((FieldDescriptorType) (zzfm) entry.getKey(), entry.getValue());
        }
        zzfk.zzud = this.zzud;
        return zzfk;
    }
}
