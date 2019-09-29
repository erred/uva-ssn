package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzft;
import com.google.android.gms.internal.firebase_auth.zzft.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzft<MessageType extends zzft<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzdz<MessageType, BuilderType> {
    private static Map<Object, zzft<?, ?>> zzxa = new ConcurrentHashMap();
    protected zzir zzwy = zzir.zzjp();
    private int zzwz = -1;

    public static abstract class zza<MessageType extends zzft<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzea<MessageType, BuilderType> {
        private final MessageType zzxb;
        protected MessageType zzxc;
        private boolean zzxd = false;

        protected zza(MessageType messagetype) {
            this.zzxb = messagetype;
            this.zzxc = (zzft) messagetype.zza(zze.zzxi, (Object) null, (Object) null);
        }

        /* access modifiers changed from: protected */
        public final void zzhj() {
            if (this.zzxd) {
                MessageType messagetype = (zzft) this.zzxc.zza(zze.zzxi, (Object) null, (Object) null);
                zza(messagetype, this.zzxc);
                this.zzxc = messagetype;
                this.zzxd = false;
            }
        }

        public final boolean isInitialized() {
            return zzft.zza(this.zzxc, false);
        }

        /* renamed from: zzhk */
        public MessageType zzhm() {
            if (this.zzxd) {
                return this.zzxc;
            }
            MessageType messagetype = this.zzxc;
            zzho.zziu().zzr(messagetype).zzf(messagetype);
            this.zzxd = true;
            return this.zzxc;
        }

        /* renamed from: zzhl */
        public final MessageType zzhn() {
            MessageType messagetype = (zzft) zzhm();
            boolean booleanValue = Boolean.TRUE.booleanValue();
            byte byteValue = ((Byte) messagetype.zza(zze.zzxf, (Object) null, (Object) null)).byteValue();
            boolean z = true;
            if (byteValue != 1) {
                if (byteValue == 0) {
                    z = false;
                } else {
                    z = zzho.zziu().zzr(messagetype).zzq(messagetype);
                    if (booleanValue) {
                        messagetype.zza(zze.zzxg, (Object) z ? messagetype : null, (Object) null);
                    }
                }
            }
            if (z) {
                return messagetype;
            }
            throw new zzip(messagetype);
        }

        public final BuilderType zza(MessageType messagetype) {
            zzhj();
            zza(this.zzxc, messagetype);
            return this;
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzho.zziu().zzr(messagetype).zzc(messagetype, messagetype2);
        }

        public final /* synthetic */ zzea zzet() {
            return (zza) clone();
        }

        public final /* synthetic */ zzhc zzhi() {
            return this.zzxb;
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zza zza = (zza) ((zzft) this.zzxb).zza(zze.zzxj, (Object) null, (Object) null);
            zza.zza((MessageType) (zzft) zzhm());
            return zza;
        }
    }

    public static class zzb<T extends zzft<T, ?>> extends zzec<T> {
        private final T zzxb;

        public zzb(T t) {
            this.zzxb = t;
        }

        public final /* synthetic */ Object zza(zzet zzet, zzfg zzfg) throws zzgc {
            return zzft.zza(this.zzxb, zzet, zzfg);
        }
    }

    public static abstract class zzc<MessageType extends zzc<MessageType, BuilderType>, BuilderType> extends zzft<MessageType, BuilderType> implements zzhe {
        protected zzfk<Object> zzxe = zzfk.zzgv();
    }

    public static class zzd<ContainingType extends zzhc, Type> extends zzfe<ContainingType, Type> {
    }

    /* 'enum' access flag removed */
    public static final class zze {
        public static final int zzxf = 1;
        public static final int zzxg = 2;
        public static final int zzxh = 3;
        public static final int zzxi = 4;
        public static final int zzxj = 5;
        public static final int zzxk = 6;
        public static final int zzxl = 7;
        private static final /* synthetic */ int[] zzxm = {zzxf, zzxg, zzxh, zzxi, zzxj, zzxk, zzxl};
        public static final int zzxn = 1;
        public static final int zzxo = 2;
        private static final /* synthetic */ int[] zzxp = {zzxn, zzxo};
        public static final int zzxq = 1;
        public static final int zzxr = 2;
        private static final /* synthetic */ int[] zzxs = {zzxq, zzxr};

        public static int[] zzho() {
            return (int[]) zzxm.clone();
        }
    }

    /* access modifiers changed from: protected */
    public abstract Object zza(int i, Object obj, Object obj2);

    public String toString() {
        return zzhf.zza(this, super.toString());
    }

    public int hashCode() {
        if (this.zzsf != 0) {
            return this.zzsf;
        }
        this.zzsf = zzho.zziu().zzr(this).hashCode(this);
        return this.zzsf;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!((zzft) zza(zze.zzxk, (Object) null, (Object) null)).getClass().isInstance(obj)) {
            return false;
        }
        return zzho.zziu().zzr(this).equals(this, (zzft) obj);
    }

    public final boolean isInitialized() {
        boolean booleanValue = Boolean.TRUE.booleanValue();
        byte byteValue = ((Byte) zza(zze.zzxf, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzq = zzho.zziu().zzr(this).zzq(this);
        if (booleanValue) {
            zza(zze.zzxg, (Object) zzq ? this : null, (Object) null);
        }
        return zzq;
    }

    /* access modifiers changed from: 0000 */
    public final int zzes() {
        return this.zzwz;
    }

    /* access modifiers changed from: 0000 */
    public final void zzg(int i) {
        this.zzwz = i;
    }

    public final void zzb(zzfa zzfa) throws IOException {
        zzho.zziu().zzf(getClass()).zza(this, zzfc.zza(zzfa));
    }

    public final int zzgw() {
        if (this.zzwz == -1) {
            this.zzwz = zzho.zziu().zzr(this).zzp(this);
        }
        return this.zzwz;
    }

    static <T extends zzft<?, ?>> T zzd(Class<T> cls) {
        T t = (zzft) zzxa.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzft) zzxa.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t == null) {
            t = (zzft) ((zzft) zziw.zzh(cls)).zza(zze.zzxk, (Object) null, (Object) null);
            if (t != null) {
                zzxa.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    protected static <T extends zzft<?, ?>> void zza(Class<T> cls, T t) {
        zzxa.put(cls, t);
    }

    protected static Object zza(zzhc zzhc, String str, Object[] objArr) {
        return new zzhq(zzhc, str, objArr);
    }

    static Object zza(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    protected static final <T extends zzft<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zze.zzxf, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        return zzho.zziu().zzr(t).zzq(t);
    }

    protected static zzfz zzhe() {
        return zzfu.zzhp();
    }

    protected static <E> zzgb<E> zzhf() {
        return zzhp.zziv();
    }

    static <T extends zzft<T, ?>> T zza(T t, zzet zzet, zzfg zzfg) throws zzgc {
        T t2 = (zzft) t.zza(zze.zzxi, (Object) null, (Object) null);
        try {
            zzho.zziu().zzr(t2).zza(t2, zzey.zza(zzet), zzfg);
            zzho.zziu().zzr(t2).zzf(t2);
            return t2;
        } catch (IOException e) {
            if (e.getCause() instanceof zzgc) {
                throw ((zzgc) e.getCause());
            }
            throw new zzgc(e.getMessage()).zzh(t2);
        } catch (RuntimeException e2) {
            if (e2.getCause() instanceof zzgc) {
                throw ((zzgc) e2.getCause());
            }
            throw e2;
        }
    }

    public final /* synthetic */ zzhd zzhg() {
        zza zza2 = (zza) zza(zze.zzxj, (Object) null, (Object) null);
        zza2.zza(this);
        return zza2;
    }

    public final /* synthetic */ zzhd zzhh() {
        return (zza) zza(zze.zzxj, (Object) null, (Object) null);
    }

    public final /* synthetic */ zzhc zzhi() {
        return (zzft) zza(zze.zzxk, (Object) null, (Object) null);
    }
}
