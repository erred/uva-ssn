package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzft.zze;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

final class zzfc implements zzjl {
    private final zzfa zzsv;

    public static zzfc zza(zzfa zzfa) {
        if (zzfa.zztq != null) {
            return zzfa.zztq;
        }
        return new zzfc(zzfa);
    }

    private zzfc(zzfa zzfa) {
        this.zzsv = (zzfa) zzfv.zza(zzfa, "output");
    }

    public final int zzgl() {
        return zze.zzxq;
    }

    public final void zzq(int i, int i2) throws IOException {
        this.zzsv.zzj(i, i2);
    }

    public final void zzi(int i, long j) throws IOException {
        this.zzsv.zza(i, j);
    }

    public final void zzj(int i, long j) throws IOException {
        this.zzsv.zzc(i, j);
    }

    public final void zza(int i, float f) throws IOException {
        this.zzsv.zza(i, f);
    }

    public final void zza(int i, double d) throws IOException {
        this.zzsv.zza(i, d);
    }

    public final void zzr(int i, int i2) throws IOException {
        this.zzsv.zzg(i, i2);
    }

    public final void zza(int i, long j) throws IOException {
        this.zzsv.zza(i, j);
    }

    public final void zzg(int i, int i2) throws IOException {
        this.zzsv.zzg(i, i2);
    }

    public final void zzc(int i, long j) throws IOException {
        this.zzsv.zzc(i, j);
    }

    public final void zzj(int i, int i2) throws IOException {
        this.zzsv.zzj(i, i2);
    }

    public final void zzb(int i, boolean z) throws IOException {
        this.zzsv.zzb(i, z);
    }

    public final void zza(int i, String str) throws IOException {
        this.zzsv.zza(i, str);
    }

    public final void zza(int i, zzeh zzeh) throws IOException {
        this.zzsv.zza(i, zzeh);
    }

    public final void zzh(int i, int i2) throws IOException {
        this.zzsv.zzh(i, i2);
    }

    public final void zzi(int i, int i2) throws IOException {
        this.zzsv.zzi(i, i2);
    }

    public final void zzb(int i, long j) throws IOException {
        this.zzsv.zzb(i, j);
    }

    public final void zza(int i, Object obj, zzhw zzhw) throws IOException {
        this.zzsv.zza(i, (zzhc) obj, zzhw);
    }

    public final void zzb(int i, Object obj, zzhw zzhw) throws IOException {
        zzfa zzfa = this.zzsv;
        zzhc zzhc = (zzhc) obj;
        zzfa.zzf(i, 3);
        zzhw.zza(zzhc, zzfa.zztq);
        zzfa.zzf(i, 4);
    }

    public final void zzap(int i) throws IOException {
        this.zzsv.zzf(i, 3);
    }

    public final void zzaq(int i) throws IOException {
        this.zzsv.zzf(i, 4);
    }

    public final void zza(int i, Object obj) throws IOException {
        if (obj instanceof zzeh) {
            this.zzsv.zzb(i, (zzeh) obj);
        } else {
            this.zzsv.zza(i, (zzhc) obj);
        }
    }

    public final void zza(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsv.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfa.zzah(((Integer) list.get(i4)).intValue());
            }
            this.zzsv.zzad(i3);
            while (i2 < list.size()) {
                this.zzsv.zzac(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsv.zzg(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void zzb(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsv.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfa.zzak(((Integer) list.get(i4)).intValue());
            }
            this.zzsv.zzad(i3);
            while (i2 < list.size()) {
                this.zzsv.zzaf(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsv.zzj(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void zzc(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsv.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfa.zze(((Long) list.get(i4)).longValue());
            }
            this.zzsv.zzad(i3);
            while (i2 < list.size()) {
                this.zzsv.zzb(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsv.zza(i, ((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public final void zzd(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsv.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfa.zzf(((Long) list.get(i4)).longValue());
            }
            this.zzsv.zzad(i3);
            while (i2 < list.size()) {
                this.zzsv.zzb(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsv.zza(i, ((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public final void zze(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsv.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfa.zzh(((Long) list.get(i4)).longValue());
            }
            this.zzsv.zzad(i3);
            while (i2 < list.size()) {
                this.zzsv.zzd(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsv.zzc(i, ((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public final void zzf(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsv.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfa.zzb(((Float) list.get(i4)).floatValue());
            }
            this.zzsv.zzad(i3);
            while (i2 < list.size()) {
                this.zzsv.zza(((Float) list.get(i2)).floatValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsv.zza(i, ((Float) list.get(i2)).floatValue());
            i2++;
        }
    }

    public final void zzg(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsv.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfa.zzb(((Double) list.get(i4)).doubleValue());
            }
            this.zzsv.zzad(i3);
            while (i2 < list.size()) {
                this.zzsv.zza(((Double) list.get(i2)).doubleValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsv.zza(i, ((Double) list.get(i2)).doubleValue());
            i2++;
        }
    }

    public final void zzh(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsv.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfa.zzam(((Integer) list.get(i4)).intValue());
            }
            this.zzsv.zzad(i3);
            while (i2 < list.size()) {
                this.zzsv.zzac(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsv.zzg(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void zzi(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsv.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfa.zzt(((Boolean) list.get(i4)).booleanValue());
            }
            this.zzsv.zzad(i3);
            while (i2 < list.size()) {
                this.zzsv.zzs(((Boolean) list.get(i2)).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsv.zzb(i, ((Boolean) list.get(i2)).booleanValue());
            i2++;
        }
    }

    public final void zza(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (list instanceof zzgl) {
            zzgl zzgl = (zzgl) list;
            while (i2 < list.size()) {
                Object zzat = zzgl.zzat(i2);
                if (zzat instanceof String) {
                    this.zzsv.zza(i, (String) zzat);
                } else {
                    this.zzsv.zza(i, (zzeh) zzat);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsv.zza(i, (String) list.get(i2));
            i2++;
        }
    }

    public final void zzb(int i, List<zzeh> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zzsv.zza(i, (zzeh) list.get(i2));
        }
    }

    public final void zzj(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsv.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfa.zzai(((Integer) list.get(i4)).intValue());
            }
            this.zzsv.zzad(i3);
            while (i2 < list.size()) {
                this.zzsv.zzad(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsv.zzh(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void zzk(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsv.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfa.zzal(((Integer) list.get(i4)).intValue());
            }
            this.zzsv.zzad(i3);
            while (i2 < list.size()) {
                this.zzsv.zzaf(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsv.zzj(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void zzl(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsv.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfa.zzi(((Long) list.get(i4)).longValue());
            }
            this.zzsv.zzad(i3);
            while (i2 < list.size()) {
                this.zzsv.zzd(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsv.zzc(i, ((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public final void zzm(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsv.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfa.zzaj(((Integer) list.get(i4)).intValue());
            }
            this.zzsv.zzad(i3);
            while (i2 < list.size()) {
                this.zzsv.zzae(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsv.zzi(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void zzn(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsv.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfa.zzg(((Long) list.get(i4)).longValue());
            }
            this.zzsv.zzad(i3);
            while (i2 < list.size()) {
                this.zzsv.zzc(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsv.zzb(i, ((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public final void zza(int i, List<?> list, zzhw zzhw) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zza(i, list.get(i2), zzhw);
        }
    }

    public final void zzb(int i, List<?> list, zzhw zzhw) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzb(i, list.get(i2), zzhw);
        }
    }

    public final <K, V> void zza(int i, zzgv<K, V> zzgv, Map<K, V> map) throws IOException {
        for (Entry entry : map.entrySet()) {
            this.zzsv.zzf(i, 2);
            this.zzsv.zzad(zzgu.zza(zzgv, entry.getKey(), entry.getValue()));
            zzgu.zza(this.zzsv, zzgv, entry.getKey(), entry.getValue());
        }
    }
}
