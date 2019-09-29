package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class zzyf implements Cloneable {
    private Object value;
    private zzyd<?, ?> zzcfa;
    private List<zzyk> zzcfb = new ArrayList();

    zzyf() {
    }

    /* access modifiers changed from: 0000 */
    public final void zza(zzyk zzyk) throws IOException {
        Object obj;
        Object obj2;
        if (this.zzcfb != null) {
            this.zzcfb.add(zzyk);
            return;
        }
        if (this.value instanceof zzyi) {
            byte[] bArr = zzyk.zzbtx;
            zzxz zzj = zzxz.zzj(bArr, 0, bArr.length);
            int zzvb = zzj.zzvb();
            if (zzvb == bArr.length - zzya.zzbe(zzvb)) {
                obj = ((zzyi) this.value).zza(zzj);
            } else {
                throw zzyh.zzzd();
            }
        } else {
            if (this.value instanceof zzyi[]) {
                zzyi[] zzyiArr = (zzyi[]) this.zzcfa.zzai(Collections.singletonList(zzyk));
                zzyi[] zzyiArr2 = (zzyi[]) this.value;
                obj2 = (zzyi[]) Arrays.copyOf(zzyiArr2, zzyiArr2.length + zzyiArr.length);
                System.arraycopy(zzyiArr, 0, obj2, zzyiArr2.length, zzyiArr.length);
            } else if (this.value instanceof zzvv) {
                obj = ((zzvv) this.value).zzwh().zza((zzvv) this.zzcfa.zzai(Collections.singletonList(zzyk))).zzwo();
            } else if (this.value instanceof zzvv[]) {
                zzvv[] zzvvArr = (zzvv[]) this.zzcfa.zzai(Collections.singletonList(zzyk));
                zzvv[] zzvvArr2 = (zzvv[]) this.value;
                obj2 = (zzvv[]) Arrays.copyOf(zzvvArr2, zzvvArr2.length + zzvvArr.length);
                System.arraycopy(zzvvArr, 0, obj2, zzvvArr2.length, zzvvArr.length);
            } else {
                obj = this.zzcfa.zzai(Collections.singletonList(zzyk));
            }
            obj = obj2;
        }
        this.zzcfa = this.zzcfa;
        this.value = obj;
        this.zzcfb = null;
    }

    /* access modifiers changed from: 0000 */
    public final <T> T zzb(zzyd<?, T> zzyd) {
        if (this.value == null) {
            this.zzcfa = zzyd;
            this.value = zzyd.zzai(this.zzcfb);
            this.zzcfb = null;
        } else if (!this.zzcfa.equals(zzyd)) {
            throw new IllegalStateException("Tried to getExtension with a different Extension.");
        }
        return this.value;
    }

    /* access modifiers changed from: 0000 */
    public final int zzf() {
        if (this.value != null) {
            zzyd<?, ?> zzyd = this.zzcfa;
            Object obj = this.value;
            if (!zzyd.zzcev) {
                return zzyd.zzao(obj);
            }
            int length = Array.getLength(obj);
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                Object obj2 = Array.get(obj, i2);
                if (obj2 != null) {
                    i += zzyd.zzao(obj2);
                }
            }
            return i;
        }
        int i3 = 0;
        for (zzyk zzyk : this.zzcfb) {
            i3 += zzya.zzbl(zzyk.tag) + 0 + zzyk.zzbtx.length;
        }
        return i3;
    }

    /* access modifiers changed from: 0000 */
    public final void zza(zzya zzya) throws IOException {
        if (this.value != null) {
            zzyd<?, ?> zzyd = this.zzcfa;
            Object obj = this.value;
            if (zzyd.zzcev) {
                int length = Array.getLength(obj);
                for (int i = 0; i < length; i++) {
                    Object obj2 = Array.get(obj, i);
                    if (obj2 != null) {
                        zzyd.zza(obj2, zzya);
                    }
                }
                return;
            }
            zzyd.zza(obj, zzya);
            return;
        }
        for (zzyk zzyk : this.zzcfb) {
            zzya.zzcd(zzyk.tag);
            zzya.zzp(zzyk.zzbtx);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzyf)) {
            return false;
        }
        zzyf zzyf = (zzyf) obj;
        if (this.value == null || zzyf.value == null) {
            if (this.zzcfb != null && zzyf.zzcfb != null) {
                return this.zzcfb.equals(zzyf.zzcfb);
            }
            try {
                return Arrays.equals(toByteArray(), zzyf.toByteArray());
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        } else if (this.zzcfa != zzyf.zzcfa) {
            return false;
        } else {
            if (!this.zzcfa.zzceu.isArray()) {
                return this.value.equals(zzyf.value);
            }
            if (this.value instanceof byte[]) {
                return Arrays.equals((byte[]) this.value, (byte[]) zzyf.value);
            }
            if (this.value instanceof int[]) {
                return Arrays.equals((int[]) this.value, (int[]) zzyf.value);
            }
            if (this.value instanceof long[]) {
                return Arrays.equals((long[]) this.value, (long[]) zzyf.value);
            }
            if (this.value instanceof float[]) {
                return Arrays.equals((float[]) this.value, (float[]) zzyf.value);
            }
            if (this.value instanceof double[]) {
                return Arrays.equals((double[]) this.value, (double[]) zzyf.value);
            }
            if (this.value instanceof boolean[]) {
                return Arrays.equals((boolean[]) this.value, (boolean[]) zzyf.value);
            }
            return Arrays.deepEquals((Object[]) this.value, (Object[]) zzyf.value);
        }
    }

    public final int hashCode() {
        try {
            return Arrays.hashCode(toByteArray()) + 527;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private final byte[] toByteArray() throws IOException {
        byte[] bArr = new byte[zzf()];
        zza(zzya.zzo(bArr));
        return bArr;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzzc */
    public final zzyf clone() {
        zzyf zzyf = new zzyf();
        try {
            zzyf.zzcfa = this.zzcfa;
            if (this.zzcfb == null) {
                zzyf.zzcfb = null;
            } else {
                zzyf.zzcfb.addAll(this.zzcfb);
            }
            if (this.value != null) {
                if (this.value instanceof zzyi) {
                    zzyf.value = (zzyi) ((zzyi) this.value).clone();
                } else if (this.value instanceof byte[]) {
                    zzyf.value = ((byte[]) this.value).clone();
                } else {
                    int i = 0;
                    if (this.value instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) this.value;
                        byte[][] bArr2 = new byte[bArr.length][];
                        zzyf.value = bArr2;
                        while (i < bArr.length) {
                            bArr2[i] = (byte[]) bArr[i].clone();
                            i++;
                        }
                    } else if (this.value instanceof boolean[]) {
                        zzyf.value = ((boolean[]) this.value).clone();
                    } else if (this.value instanceof int[]) {
                        zzyf.value = ((int[]) this.value).clone();
                    } else if (this.value instanceof long[]) {
                        zzyf.value = ((long[]) this.value).clone();
                    } else if (this.value instanceof float[]) {
                        zzyf.value = ((float[]) this.value).clone();
                    } else if (this.value instanceof double[]) {
                        zzyf.value = ((double[]) this.value).clone();
                    } else if (this.value instanceof zzyi[]) {
                        zzyi[] zzyiArr = (zzyi[]) this.value;
                        zzyi[] zzyiArr2 = new zzyi[zzyiArr.length];
                        zzyf.value = zzyiArr2;
                        while (i < zzyiArr.length) {
                            zzyiArr2[i] = (zzyi) zzyiArr[i].clone();
                            i++;
                        }
                    }
                }
            }
            return zzyf;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
