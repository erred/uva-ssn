package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

final class zzhy {
    private static final Class<?> zzaau = zzjd();
    private static final zziq<?, ?> zzaav = zzv(false);
    private static final zziq<?, ?> zzaaw = zzv(true);
    private static final zziq<?, ?> zzaax = new zzis();

    public static void zzg(Class<?> cls) {
        if (!zzft.class.isAssignableFrom(cls) && zzaau != null && !zzaau.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zza(int i, List<Double> list, zzjl zzjl, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjl.zzg(i, list, z);
        }
    }

    public static void zzb(int i, List<Float> list, zzjl zzjl, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjl.zzf(i, list, z);
        }
    }

    public static void zzc(int i, List<Long> list, zzjl zzjl, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjl.zzc(i, list, z);
        }
    }

    public static void zzd(int i, List<Long> list, zzjl zzjl, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjl.zzd(i, list, z);
        }
    }

    public static void zze(int i, List<Long> list, zzjl zzjl, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjl.zzn(i, list, z);
        }
    }

    public static void zzf(int i, List<Long> list, zzjl zzjl, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjl.zze(i, list, z);
        }
    }

    public static void zzg(int i, List<Long> list, zzjl zzjl, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjl.zzl(i, list, z);
        }
    }

    public static void zzh(int i, List<Integer> list, zzjl zzjl, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjl.zza(i, list, z);
        }
    }

    public static void zzi(int i, List<Integer> list, zzjl zzjl, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjl.zzj(i, list, z);
        }
    }

    public static void zzj(int i, List<Integer> list, zzjl zzjl, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjl.zzm(i, list, z);
        }
    }

    public static void zzk(int i, List<Integer> list, zzjl zzjl, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjl.zzb(i, list, z);
        }
    }

    public static void zzl(int i, List<Integer> list, zzjl zzjl, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjl.zzk(i, list, z);
        }
    }

    public static void zzm(int i, List<Integer> list, zzjl zzjl, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjl.zzh(i, list, z);
        }
    }

    public static void zzn(int i, List<Boolean> list, zzjl zzjl, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjl.zzi(i, list, z);
        }
    }

    public static void zza(int i, List<String> list, zzjl zzjl) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjl.zza(i, list);
        }
    }

    public static void zzb(int i, List<zzeh> list, zzjl zzjl) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjl.zzb(i, list);
        }
    }

    public static void zza(int i, List<?> list, zzjl zzjl, zzhw zzhw) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjl.zza(i, list, zzhw);
        }
    }

    public static void zzb(int i, List<?> list, zzjl zzjl, zzhw zzhw) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjl.zzb(i, list, zzhw);
        }
    }

    static int zzt(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgq) {
            zzgq zzgq = (zzgq) list;
            i = 0;
            while (i2 < size) {
                i += zzfa.zze(zzgq.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzfa.zze(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzo(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzt(list) + (list.size() * zzfa.zzag(i));
    }

    static int zzu(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgq) {
            zzgq zzgq = (zzgq) list;
            i = 0;
            while (i2 < size) {
                i += zzfa.zzf(zzgq.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzfa.zzf(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzp(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzu(list) + (size * zzfa.zzag(i));
    }

    static int zzv(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgq) {
            zzgq zzgq = (zzgq) list;
            i = 0;
            while (i2 < size) {
                i += zzfa.zzg(zzgq.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzfa.zzg(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzq(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzv(list) + (size * zzfa.zzag(i));
    }

    static int zzw(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfu) {
            zzfu zzfu = (zzfu) list;
            i = 0;
            while (i2 < size) {
                i += zzfa.zzam(zzfu.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzfa.zzam(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzr(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzw(list) + (size * zzfa.zzag(i));
    }

    static int zzx(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfu) {
            zzfu zzfu = (zzfu) list;
            i = 0;
            while (i2 < size) {
                i += zzfa.zzah(zzfu.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzfa.zzah(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzs(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzx(list) + (size * zzfa.zzag(i));
    }

    static int zzy(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfu) {
            zzfu zzfu = (zzfu) list;
            i = 0;
            while (i2 < size) {
                i += zzfa.zzai(zzfu.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzfa.zzai(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzt(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzy(list) + (size * zzfa.zzag(i));
    }

    static int zzz(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfu) {
            zzfu zzfu = (zzfu) list;
            i = 0;
            while (i2 < size) {
                i += zzfa.zzaj(zzfu.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzfa.zzaj(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzu(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzz(list) + (size * zzfa.zzag(i));
    }

    static int zzaa(List<?> list) {
        return list.size() << 2;
    }

    static int zzv(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzfa.zzn(i, 0);
    }

    static int zzab(List<?> list) {
        return list.size() << 3;
    }

    static int zzw(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzfa.zzg(i, 0);
    }

    static int zzac(List<?> list) {
        return list.size();
    }

    static int zzx(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzfa.zzc(i, true);
    }

    static int zzc(int i, List<?> list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int zzag = zzfa.zzag(i) * size;
        if (list instanceof zzgl) {
            zzgl zzgl = (zzgl) list;
            while (i4 < size) {
                Object zzat = zzgl.zzat(i4);
                if (zzat instanceof zzeh) {
                    i3 = zzfa.zzb((zzeh) zzat);
                } else {
                    i3 = zzfa.zzdb((String) zzat);
                }
                zzag += i3;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof zzeh) {
                    i2 = zzfa.zzb((zzeh) obj);
                } else {
                    i2 = zzfa.zzdb((String) obj);
                }
                zzag += i2;
                i4++;
            }
        }
        return zzag;
    }

    static int zzc(int i, Object obj, zzhw zzhw) {
        if (obj instanceof zzgj) {
            return zzfa.zza(i, (zzgj) obj);
        }
        return zzfa.zzb(i, (zzhc) obj, zzhw);
    }

    static int zzc(int i, List<?> list, zzhw zzhw) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzag = zzfa.zzag(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzgj) {
                i2 = zzfa.zza((zzgj) obj);
            } else {
                i2 = zzfa.zza((zzhc) obj, zzhw);
            }
            zzag += i2;
        }
        return zzag;
    }

    static int zzd(int i, List<zzeh> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzag = size * zzfa.zzag(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzag += zzfa.zzb((zzeh) list.get(i2));
        }
        return zzag;
    }

    static int zzd(int i, List<zzhc> list, zzhw zzhw) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzfa.zzc(i, (zzhc) list.get(i3), zzhw);
        }
        return i2;
    }

    public static zziq<?, ?> zzja() {
        return zzaav;
    }

    public static zziq<?, ?> zzjb() {
        return zzaaw;
    }

    public static zziq<?, ?> zzjc() {
        return zzaax;
    }

    private static zziq<?, ?> zzv(boolean z) {
        try {
            Class zzje = zzje();
            if (zzje == null) {
                return null;
            }
            return (zziq) zzje.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzjd() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzje() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean zzd(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    static <T> void zza(zzgx zzgx, T t, T t2, long j) {
        zziw.zza((Object) t, j, zzgx.zzb(zziw.zzp(t, j), zziw.zzp(t2, j)));
    }

    static <T, FT extends zzfm<FT>> void zza(zzfh<FT> zzfh, T t, T t2) {
        zzfk zzd = zzfh.zzd(t2);
        if (!zzd.isEmpty()) {
            zzfh.zze(t).zza(zzd);
        }
    }

    static <T, UT, UB> void zza(zziq<UT, UB> zziq, T t, T t2) {
        zziq.zze(t, zziq.zzg(zziq.zzs(t), zziq.zzs(t2)));
    }

    static <UT, UB> UB zza(int i, List<Integer> list, zzfy zzfy, UB ub, zziq<UT, UB> zziq) {
        UB ub2;
        if (zzfy == null) {
            return ub;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator it = list.iterator();
            loop1:
            while (true) {
                ub2 = ub;
                while (it.hasNext()) {
                    int intValue = ((Integer) it.next()).intValue();
                    if (!zzfy.zzc(intValue)) {
                        ub = zza(i, intValue, ub2, zziq);
                        it.remove();
                    }
                }
                break loop1;
            }
        } else {
            int size = list.size();
            ub2 = ub;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue2 = ((Integer) list.get(i3)).intValue();
                if (zzfy.zzc(intValue2)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue2));
                    }
                    i2++;
                } else {
                    ub2 = zza(i, intValue2, ub2, zziq);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        }
        return ub2;
    }

    static <UT, UB> UB zza(int i, int i2, UB ub, zziq<UT, UB> zziq) {
        if (ub == null) {
            ub = zziq.zzjo();
        }
        zziq.zza(ub, i, (long) i2);
        return ub;
    }
}
