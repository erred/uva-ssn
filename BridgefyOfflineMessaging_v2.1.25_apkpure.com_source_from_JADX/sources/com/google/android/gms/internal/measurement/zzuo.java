package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzuo;
import com.google.android.gms.internal.measurement.zzuo.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzuo<MessageType extends zzuo<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzsx<MessageType, BuilderType> {
    private static Map<Object, zzuo<?, ?>> zzbyf = new ConcurrentHashMap();
    protected zzxe zzbyd = zzxe.zzyl();
    private int zzbye = -1;

    public static abstract class zza<MessageType extends zzuo<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzsy<MessageType, BuilderType> {
        private final MessageType zzbyg;
        protected MessageType zzbyh;
        private boolean zzbyi = false;

        protected zza(MessageType messagetype) {
            this.zzbyg = messagetype;
            this.zzbyh = (zzuo) messagetype.zza(zze.zzbyn, (Object) null, (Object) null);
        }

        /* access modifiers changed from: protected */
        public final void zzwk() {
            if (this.zzbyi) {
                MessageType messagetype = (zzuo) this.zzbyh.zza(zze.zzbyn, (Object) null, (Object) null);
                zza(messagetype, this.zzbyh);
                this.zzbyh = messagetype;
                this.zzbyi = false;
            }
        }

        public final boolean isInitialized() {
            return zzuo.zza(this.zzbyh, false);
        }

        /* renamed from: zzwl */
        public MessageType zzwn() {
            if (this.zzbyi) {
                return this.zzbyh;
            }
            MessageType messagetype = this.zzbyh;
            zzwh.zzxt().zzak(messagetype).zzy(messagetype);
            this.zzbyi = true;
            return this.zzbyh;
        }

        /* renamed from: zzwm */
        public final MessageType zzwo() {
            MessageType messagetype = (zzuo) zzwn();
            boolean booleanValue = Boolean.TRUE.booleanValue();
            byte byteValue = ((Byte) messagetype.zza(zze.zzbyk, (Object) null, (Object) null)).byteValue();
            boolean z = true;
            if (byteValue != 1) {
                if (byteValue == 0) {
                    z = false;
                } else {
                    z = zzwh.zzxt().zzak(messagetype).zzaj(messagetype);
                    if (booleanValue) {
                        messagetype.zza(zze.zzbyl, (Object) z ? messagetype : null, (Object) null);
                    }
                }
            }
            if (z) {
                return messagetype;
            }
            throw new zzxc(messagetype);
        }

        public final BuilderType zza(MessageType messagetype) {
            zzwk();
            zza(this.zzbyh, messagetype);
            return this;
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzwh.zzxt().zzak(messagetype).zzd(messagetype, messagetype2);
        }

        public final /* synthetic */ zzsy zzty() {
            return (zza) clone();
        }

        public final /* synthetic */ zzvv zzwj() {
            return this.zzbyg;
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zza zza = (zza) ((zzuo) this.zzbyg).zza(zze.zzbyo, (Object) null, (Object) null);
            zza.zza((MessageType) (zzuo) zzwn());
            return zza;
        }
    }

    public static class zzb<T extends zzuo<T, ?>> extends zzsz<T> {
        private final T zzbyg;

        public zzb(T t) {
            this.zzbyg = t;
        }

        public final /* synthetic */ Object zza(zztq zztq, zzub zzub) throws zzuv {
            return zzuo.zza(this.zzbyg, zztq, zzub);
        }
    }

    public static abstract class zzc<MessageType extends zzc<MessageType, BuilderType>, BuilderType> extends zzuo<MessageType, BuilderType> implements zzvx {
        protected zzuf<Object> zzbyj = zzuf.zzvw();
    }

    public static class zzd<ContainingType extends zzvv, Type> extends zztz<ContainingType, Type> {
    }

    /* 'enum' access flag removed */
    public static final class zze {
        public static final int zzbyk = 1;
        public static final int zzbyl = 2;
        public static final int zzbym = 3;
        public static final int zzbyn = 4;
        public static final int zzbyo = 5;
        public static final int zzbyp = 6;
        public static final int zzbyq = 7;
        private static final /* synthetic */ int[] zzbyr = {zzbyk, zzbyl, zzbym, zzbyn, zzbyo, zzbyp, zzbyq};
        public static final int zzbys = 1;
        public static final int zzbyt = 2;
        private static final /* synthetic */ int[] zzbyu = {zzbys, zzbyt};
        public static final int zzbyv = 1;
        public static final int zzbyw = 2;
        private static final /* synthetic */ int[] zzbyx = {zzbyv, zzbyw};

        public static int[] zzwp() {
            return (int[]) zzbyr.clone();
        }
    }

    /* access modifiers changed from: protected */
    public abstract Object zza(int i, Object obj, Object obj2);

    public String toString() {
        return zzvy.zza(this, super.toString());
    }

    public int hashCode() {
        if (this.zzbti != 0) {
            return this.zzbti;
        }
        this.zzbti = zzwh.zzxt().zzak(this).hashCode(this);
        return this.zzbti;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!((zzuo) zza(zze.zzbyp, (Object) null, (Object) null)).getClass().isInstance(obj)) {
            return false;
        }
        return zzwh.zzxt().zzak(this).equals(this, (zzuo) obj);
    }

    public final boolean isInitialized() {
        boolean booleanValue = Boolean.TRUE.booleanValue();
        byte byteValue = ((Byte) zza(zze.zzbyk, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzaj = zzwh.zzxt().zzak(this).zzaj(this);
        if (booleanValue) {
            zza(zze.zzbyl, (Object) zzaj ? this : null, (Object) null);
        }
        return zzaj;
    }

    public final BuilderType zzwf() {
        BuilderType buildertype = (zza) zza(zze.zzbyo, (Object) null, (Object) null);
        buildertype.zza(this);
        return buildertype;
    }

    /* access modifiers changed from: 0000 */
    public final int zztx() {
        return this.zzbye;
    }

    /* access modifiers changed from: 0000 */
    public final void zzai(int i) {
        this.zzbye = i;
    }

    public final void zzb(zztv zztv) throws IOException {
        zzwh.zzxt().zzi(getClass()).zza(this, zztx.zza(zztv));
    }

    public final int zzvx() {
        if (this.zzbye == -1) {
            this.zzbye = zzwh.zzxt().zzak(this).zzai(this);
        }
        return this.zzbye;
    }

    static <T extends zzuo<?, ?>> T zzg(Class<T> cls) {
        T t = (zzuo) zzbyf.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzuo) zzbyf.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t == null) {
            t = (zzuo) ((zzuo) zzxj.zzk(cls)).zza(zze.zzbyp, (Object) null, (Object) null);
            if (t != null) {
                zzbyf.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    protected static <T extends zzuo<?, ?>> void zza(Class<T> cls, T t) {
        zzbyf.put(cls, t);
    }

    protected static Object zza(zzvv zzvv, String str, Object[] objArr) {
        return new zzwj(zzvv, str, objArr);
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

    protected static final <T extends zzuo<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zze.zzbyk, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        return zzwh.zzxt().zzak(t).zzaj(t);
    }

    protected static <E> zzuu<E> zzwg() {
        return zzwi.zzxu();
    }

    static <T extends zzuo<T, ?>> T zza(T t, zztq zztq, zzub zzub) throws zzuv {
        T t2 = (zzuo) t.zza(zze.zzbyn, (Object) null, (Object) null);
        try {
            zzwh.zzxt().zzak(t2).zza(t2, zztt.zza(zztq), zzub);
            zzwh.zzxt().zzak(t2).zzy(t2);
            return t2;
        } catch (IOException e) {
            if (e.getCause() instanceof zzuv) {
                throw ((zzuv) e.getCause());
            }
            throw new zzuv(e.getMessage()).zzg(t2);
        } catch (RuntimeException e2) {
            if (e2.getCause() instanceof zzuv) {
                throw ((zzuv) e2.getCause());
            }
            throw e2;
        }
    }

    public final /* synthetic */ zzvw zzwh() {
        zza zza2 = (zza) zza(zze.zzbyo, (Object) null, (Object) null);
        zza2.zza(this);
        return zza2;
    }

    public final /* synthetic */ zzvw zzwi() {
        return (zza) zza(zze.zzbyo, (Object) null, (Object) null);
    }

    public final /* synthetic */ zzvv zzwj() {
        return (zzuo) zza(zze.zzbyp, (Object) null, (Object) null);
    }
}
