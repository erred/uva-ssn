package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;
import java.util.List;
import java.util.Map;

interface zzhr {
    int getTag();

    double readDouble() throws IOException;

    float readFloat() throws IOException;

    String readString() throws IOException;

    void readStringList(List<String> list) throws IOException;

    <T> T zza(zzhw<T> zzhw, zzfg zzfg) throws IOException;

    <T> void zza(List<T> list, zzhw<T> zzhw, zzfg zzfg) throws IOException;

    <K, V> void zza(Map<K, V> map, zzgv<K, V> zzgv, zzfg zzfg) throws IOException;

    @Deprecated
    <T> T zzb(zzhw<T> zzhw, zzfg zzfg) throws IOException;

    @Deprecated
    <T> void zzb(List<T> list, zzhw<T> zzhw, zzfg zzfg) throws IOException;

    void zzd(List<Double> list) throws IOException;

    void zze(List<Float> list) throws IOException;

    void zzf(List<Long> list) throws IOException;

    long zzfj() throws IOException;

    long zzfk() throws IOException;

    int zzfl() throws IOException;

    long zzfm() throws IOException;

    int zzfn() throws IOException;

    boolean zzfo() throws IOException;

    String zzfp() throws IOException;

    zzeh zzfq() throws IOException;

    int zzfr() throws IOException;

    int zzfs() throws IOException;

    int zzft() throws IOException;

    long zzfu() throws IOException;

    int zzfv() throws IOException;

    long zzfw() throws IOException;

    void zzg(List<Long> list) throws IOException;

    int zzgg() throws IOException;

    boolean zzgh() throws IOException;

    void zzh(List<Integer> list) throws IOException;

    void zzi(List<Long> list) throws IOException;

    void zzj(List<Integer> list) throws IOException;

    void zzk(List<Boolean> list) throws IOException;

    void zzl(List<String> list) throws IOException;

    void zzm(List<zzeh> list) throws IOException;

    void zzn(List<Integer> list) throws IOException;

    void zzo(List<Integer> list) throws IOException;

    void zzp(List<Integer> list) throws IOException;

    void zzq(List<Long> list) throws IOException;

    void zzr(List<Integer> list) throws IOException;

    void zzs(List<Long> list) throws IOException;
}
