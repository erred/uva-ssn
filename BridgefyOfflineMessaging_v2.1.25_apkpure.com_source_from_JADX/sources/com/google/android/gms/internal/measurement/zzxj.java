package com.google.android.gms.internal.measurement;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;

final class zzxj {
    private static final Logger logger = Logger.getLogger(zzxj.class.getName());
    private static final Class<?> zzbtm = zztb.zzuc();
    private static final boolean zzbum = zzyr();
    private static final Unsafe zzcap = zzyq();
    private static final boolean zzccm = zzn(Long.TYPE);
    private static final boolean zzccn = zzn(Integer.TYPE);
    private static final zzd zzcco;
    private static final boolean zzccp = zzys();
    /* access modifiers changed from: private */
    public static final long zzccq = ((long) zzl(byte[].class));
    private static final long zzccr = ((long) zzl(boolean[].class));
    private static final long zzccs = ((long) zzm(boolean[].class));
    private static final long zzcct = ((long) zzl(int[].class));
    private static final long zzccu = ((long) zzm(int[].class));
    private static final long zzccv = ((long) zzl(long[].class));
    private static final long zzccw = ((long) zzm(long[].class));
    private static final long zzccx = ((long) zzl(float[].class));
    private static final long zzccy = ((long) zzm(float[].class));
    private static final long zzccz = ((long) zzl(double[].class));
    private static final long zzcda = ((long) zzm(double[].class));
    private static final long zzcdb = ((long) zzl(Object[].class));
    private static final long zzcdc = ((long) zzm(Object[].class));
    private static final long zzcdd;
    /* access modifiers changed from: private */
    public static final boolean zzcde = (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN);

    static final class zza extends zzd {
        zza(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zza(long j, byte b) {
            Memory.pokeByte((int) (j & -1), b);
        }

        public final byte zzy(Object obj, long j) {
            if (zzxj.zzcde) {
                return zzxj.zzq(obj, j);
            }
            return zzxj.zzr(obj, j);
        }

        public final void zze(Object obj, long j, byte b) {
            if (zzxj.zzcde) {
                zzxj.zza(obj, j, b);
            } else {
                zzxj.zzb(obj, j, b);
            }
        }

        public final boolean zzm(Object obj, long j) {
            if (zzxj.zzcde) {
                return zzxj.zzs(obj, j);
            }
            return zzxj.zzt(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzxj.zzcde) {
                zzxj.zzb(obj, j, z);
            } else {
                zzxj.zzc(obj, j, z);
            }
        }

        public final float zzn(Object obj, long j) {
            return Float.intBitsToFloat(zzk(obj, j));
        }

        public final void zza(Object obj, long j, float f) {
            zzb(obj, j, Float.floatToIntBits(f));
        }

        public final double zzo(Object obj, long j) {
            return Double.longBitsToDouble(zzl(obj, j));
        }

        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }

        public final void zza(byte[] bArr, long j, long j2, long j3) {
            Memory.pokeByteArray((int) (j2 & -1), bArr, (int) j, (int) j3);
        }
    }

    static final class zzb extends zzd {
        zzb(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zza(long j, byte b) {
            Memory.pokeByte(j, b);
        }

        public final byte zzy(Object obj, long j) {
            if (zzxj.zzcde) {
                return zzxj.zzq(obj, j);
            }
            return zzxj.zzr(obj, j);
        }

        public final void zze(Object obj, long j, byte b) {
            if (zzxj.zzcde) {
                zzxj.zza(obj, j, b);
            } else {
                zzxj.zzb(obj, j, b);
            }
        }

        public final boolean zzm(Object obj, long j) {
            if (zzxj.zzcde) {
                return zzxj.zzs(obj, j);
            }
            return zzxj.zzt(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzxj.zzcde) {
                zzxj.zzb(obj, j, z);
            } else {
                zzxj.zzc(obj, j, z);
            }
        }

        public final float zzn(Object obj, long j) {
            return Float.intBitsToFloat(zzk(obj, j));
        }

        public final void zza(Object obj, long j, float f) {
            zzb(obj, j, Float.floatToIntBits(f));
        }

        public final double zzo(Object obj, long j) {
            return Double.longBitsToDouble(zzl(obj, j));
        }

        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }

        public final void zza(byte[] bArr, long j, long j2, long j3) {
            Memory.pokeByteArray(j2, bArr, (int) j, (int) j3);
        }
    }

    static final class zzc extends zzd {
        zzc(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zza(long j, byte b) {
            this.zzcdf.putByte(j, b);
        }

        public final byte zzy(Object obj, long j) {
            return this.zzcdf.getByte(obj, j);
        }

        public final void zze(Object obj, long j, byte b) {
            this.zzcdf.putByte(obj, j, b);
        }

        public final boolean zzm(Object obj, long j) {
            return this.zzcdf.getBoolean(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            this.zzcdf.putBoolean(obj, j, z);
        }

        public final float zzn(Object obj, long j) {
            return this.zzcdf.getFloat(obj, j);
        }

        public final void zza(Object obj, long j, float f) {
            this.zzcdf.putFloat(obj, j, f);
        }

        public final double zzo(Object obj, long j) {
            return this.zzcdf.getDouble(obj, j);
        }

        public final void zza(Object obj, long j, double d) {
            this.zzcdf.putDouble(obj, j, d);
        }

        public final void zza(byte[] bArr, long j, long j2, long j3) {
            this.zzcdf.copyMemory(bArr, zzxj.zzccq + j, null, j2, j3);
        }
    }

    static abstract class zzd {
        Unsafe zzcdf;

        zzd(Unsafe unsafe) {
            this.zzcdf = unsafe;
        }

        public abstract void zza(long j, byte b);

        public abstract void zza(Object obj, long j, double d);

        public abstract void zza(Object obj, long j, float f);

        public abstract void zza(Object obj, long j, boolean z);

        public abstract void zza(byte[] bArr, long j, long j2, long j3);

        public abstract void zze(Object obj, long j, byte b);

        public abstract boolean zzm(Object obj, long j);

        public abstract float zzn(Object obj, long j);

        public abstract double zzo(Object obj, long j);

        public abstract byte zzy(Object obj, long j);

        public final int zzk(Object obj, long j) {
            return this.zzcdf.getInt(obj, j);
        }

        public final void zzb(Object obj, long j, int i) {
            this.zzcdf.putInt(obj, j, i);
        }

        public final long zzl(Object obj, long j) {
            return this.zzcdf.getLong(obj, j);
        }

        public final void zza(Object obj, long j, long j2) {
            this.zzcdf.putLong(obj, j, j2);
        }
    }

    private zzxj() {
    }

    static boolean zzyo() {
        return zzbum;
    }

    static boolean zzyp() {
        return zzccp;
    }

    static <T> T zzk(Class<T> cls) {
        try {
            return zzcap.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    private static int zzl(Class<?> cls) {
        if (zzbum) {
            return zzcco.zzcdf.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzm(Class<?> cls) {
        if (zzbum) {
            return zzcco.zzcdf.arrayIndexScale(cls);
        }
        return -1;
    }

    static int zzk(Object obj, long j) {
        return zzcco.zzk(obj, j);
    }

    static void zzb(Object obj, long j, int i) {
        zzcco.zzb(obj, j, i);
    }

    static long zzl(Object obj, long j) {
        return zzcco.zzl(obj, j);
    }

    static void zza(Object obj, long j, long j2) {
        zzcco.zza(obj, j, j2);
    }

    static boolean zzm(Object obj, long j) {
        return zzcco.zzm(obj, j);
    }

    static void zza(Object obj, long j, boolean z) {
        zzcco.zza(obj, j, z);
    }

    static float zzn(Object obj, long j) {
        return zzcco.zzn(obj, j);
    }

    static void zza(Object obj, long j, float f) {
        zzcco.zza(obj, j, f);
    }

    static double zzo(Object obj, long j) {
        return zzcco.zzo(obj, j);
    }

    static void zza(Object obj, long j, double d) {
        zzcco.zza(obj, j, d);
    }

    static Object zzp(Object obj, long j) {
        return zzcco.zzcdf.getObject(obj, j);
    }

    static void zza(Object obj, long j, Object obj2) {
        zzcco.zzcdf.putObject(obj, j, obj2);
    }

    static byte zza(byte[] bArr, long j) {
        return zzcco.zzy(bArr, zzccq + j);
    }

    static void zza(byte[] bArr, long j, byte b) {
        zzcco.zze(bArr, zzccq + j, b);
    }

    static void zza(byte[] bArr, long j, long j2, long j3) {
        zzcco.zza(bArr, j, j2, j3);
    }

    static void zza(long j, byte b) {
        zzcco.zza(j, b);
    }

    static long zzb(ByteBuffer byteBuffer) {
        return zzcco.zzl(byteBuffer, zzcdd);
    }

    static Unsafe zzyq() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzxk());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean zzyr() {
        if (zzcap == null) {
            return false;
        }
        try {
            Class cls = zzcap.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod("arrayBaseOffset", new Class[]{Class.class});
            cls.getMethod("arrayIndexScale", new Class[]{Class.class});
            cls.getMethod("getInt", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putInt", new Class[]{Object.class, Long.TYPE, Integer.TYPE});
            cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putLong", new Class[]{Object.class, Long.TYPE, Long.TYPE});
            cls.getMethod("getObject", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putObject", new Class[]{Object.class, Long.TYPE, Object.class});
            if (zztb.zzub()) {
                return true;
            }
            cls.getMethod("getByte", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putByte", new Class[]{Object.class, Long.TYPE, Byte.TYPE});
            cls.getMethod("getBoolean", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putBoolean", new Class[]{Object.class, Long.TYPE, Boolean.TYPE});
            cls.getMethod("getFloat", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putFloat", new Class[]{Object.class, Long.TYPE, Float.TYPE});
            cls.getMethod("getDouble", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putDouble", new Class[]{Object.class, Long.TYPE, Double.TYPE});
            return true;
        } catch (Throwable th) {
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger.logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
            return false;
        }
    }

    private static boolean zzys() {
        if (zzcap == null) {
            return false;
        }
        try {
            Class cls = zzcap.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
            if (zzyt() == null) {
                return false;
            }
            if (zztb.zzub()) {
                return true;
            }
            cls.getMethod("getByte", new Class[]{Long.TYPE});
            cls.getMethod("putByte", new Class[]{Long.TYPE, Byte.TYPE});
            cls.getMethod("getInt", new Class[]{Long.TYPE});
            cls.getMethod("putInt", new Class[]{Long.TYPE, Integer.TYPE});
            cls.getMethod("getLong", new Class[]{Long.TYPE});
            cls.getMethod("putLong", new Class[]{Long.TYPE, Long.TYPE});
            cls.getMethod("copyMemory", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
            cls.getMethod("copyMemory", new Class[]{Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE});
            return true;
        } catch (Throwable th) {
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger.logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb.toString());
            return false;
        }
    }

    private static boolean zzn(Class<?> cls) {
        if (!zztb.zzub()) {
            return false;
        }
        try {
            Class<?> cls2 = zzbtm;
            cls2.getMethod("peekLong", new Class[]{cls, Boolean.TYPE});
            cls2.getMethod("pokeLong", new Class[]{cls, Long.TYPE, Boolean.TYPE});
            cls2.getMethod("pokeInt", new Class[]{cls, Integer.TYPE, Boolean.TYPE});
            cls2.getMethod("peekInt", new Class[]{cls, Boolean.TYPE});
            cls2.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls2.getMethod("peekByte", new Class[]{cls});
            cls2.getMethod("pokeByteArray", new Class[]{cls, byte[].class, Integer.TYPE, Integer.TYPE});
            cls2.getMethod("peekByteArray", new Class[]{cls, byte[].class, Integer.TYPE, Integer.TYPE});
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static Field zzyt() {
        if (zztb.zzub()) {
            Field zzb2 = zzb(Buffer.class, "effectiveDirectAddress");
            if (zzb2 != null) {
                return zzb2;
            }
        }
        Field zzb3 = zzb(Buffer.class, "address");
        if (zzb3 == null || zzb3.getType() != Long.TYPE) {
            return null;
        }
        return zzb3;
    }

    private static Field zzb(Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static byte zzq(Object obj, long j) {
        return (byte) (zzk(obj, -4 & j) >>> ((int) (((~j) & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static byte zzr(Object obj, long j) {
        return (byte) (zzk(obj, -4 & j) >>> ((int) ((j & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static void zza(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int i = ((~((int) j)) & 3) << 3;
        int i2 = (255 & b) << i;
        zzb(obj, j2, i2 | (zzk(obj, j2) & (~(255 << i))));
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int i = (((int) j) & 3) << 3;
        zzb(obj, j2, ((255 & b) << i) | (zzk(obj, j2) & (~(255 << i))));
    }

    /* access modifiers changed from: private */
    public static boolean zzs(Object obj, long j) {
        return zzq(obj, j) != 0;
    }

    /* access modifiers changed from: private */
    public static boolean zzt(Object obj, long j) {
        return zzr(obj, j) != 0;
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j, boolean z) {
        zza(obj, j, z ? (byte) 1 : 0);
    }

    /* access modifiers changed from: private */
    public static void zzc(Object obj, long j, boolean z) {
        zzb(obj, j, z ? (byte) 1 : 0);
    }

    static {
        zzd zzd2 = null;
        if (zzcap != null) {
            if (!zztb.zzub()) {
                zzd2 = new zzc(zzcap);
            } else if (zzccm) {
                zzd2 = new zzb(zzcap);
            } else if (zzccn) {
                zzd2 = new zza(zzcap);
            }
        }
        zzcco = zzd2;
        Field zzyt = zzyt();
        zzcdd = (zzyt == null || zzcco == null) ? -1 : zzcco.zzcdf.objectFieldOffset(zzyt);
    }
}
