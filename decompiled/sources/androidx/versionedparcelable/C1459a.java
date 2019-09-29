package androidx.versionedparcelable;

import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;

/* renamed from: androidx.versionedparcelable.a */
/* compiled from: VersionedParcel */
public abstract class C1459a {
    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo6032a(int i);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo6034a(Parcelable parcelable);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo6038a(String str);

    /* renamed from: a */
    public void mo6040a(boolean z, boolean z2) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo6041a(byte[] bArr);

    /* renamed from: a */
    public boolean mo6043a() {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo6048b();

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract boolean mo6049b(int i);

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract C1459a mo6051c();

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract void mo6052c(int i);

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public abstract int mo6053d();

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public abstract String mo6054e();

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public abstract byte[] mo6055f();

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public abstract <T extends Parcelable> T mo6056g();

    /* renamed from: a */
    public void mo6042a(byte[] bArr, int i) {
        mo6052c(i);
        mo6041a(bArr);
    }

    /* renamed from: a */
    public void mo6033a(int i, int i2) {
        mo6052c(i2);
        mo6032a(i);
    }

    /* renamed from: a */
    public void mo6039a(String str, int i) {
        mo6052c(i);
        mo6038a(str);
    }

    /* renamed from: a */
    public void mo6035a(Parcelable parcelable, int i) {
        mo6052c(i);
        mo6034a(parcelable);
    }

    /* renamed from: b */
    public int mo6044b(int i, int i2) {
        if (!mo6049b(i2)) {
            return i;
        }
        return mo6053d();
    }

    /* renamed from: b */
    public String mo6047b(String str, int i) {
        if (!mo6049b(i)) {
            return str;
        }
        return mo6054e();
    }

    /* renamed from: b */
    public byte[] mo6050b(byte[] bArr, int i) {
        if (!mo6049b(i)) {
            return bArr;
        }
        return mo6055f();
    }

    /* renamed from: b */
    public <T extends Parcelable> T mo6045b(T t, int i) {
        if (!mo6049b(i)) {
            return t;
        }
        return mo6056g();
    }

    /* renamed from: a */
    public void mo6037a(C1461c cVar, int i) {
        mo6052c(i);
        mo6036a(cVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6036a(C1461c cVar) {
        if (cVar == null) {
            mo6038a((String) null);
            return;
        }
        m5811b(cVar);
        C1459a c = mo6051c();
        m5810a((T) cVar, c);
        c.mo6048b();
    }

    /* renamed from: b */
    private void m5811b(C1461c cVar) {
        try {
            mo6038a(m5809a(cVar.getClass()).getName());
        } catch (ClassNotFoundException e) {
            StringBuilder sb = new StringBuilder();
            sb.append(cVar.getClass().getSimpleName());
            sb.append(" does not have a Parcelizer");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    /* renamed from: b */
    public <T extends C1461c> T mo6046b(T t, int i) {
        if (!mo6049b(i)) {
            return t;
        }
        return mo6057h();
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public <T extends C1461c> T mo6057h() {
        String e = mo6054e();
        if (e == null) {
            return null;
        }
        return m5808a(e, mo6051c());
    }

    /* renamed from: a */
    protected static <T extends C1461c> T m5808a(String str, C1459a aVar) {
        try {
            return (C1461c) Class.forName(str, true, C1459a.class.getClassLoader()).getDeclaredMethod("read", new Class[]{C1459a.class}).invoke(null, new Object[]{aVar});
        } catch (IllegalAccessException e) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e);
        } catch (InvocationTargetException e2) {
            if (e2.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e2.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (ClassNotFoundException e4) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e4);
        }
    }

    /* renamed from: a */
    protected static <T extends C1461c> void m5810a(T t, C1459a aVar) {
        try {
            m5812c(t).getDeclaredMethod("write", new Class[]{t.getClass(), C1459a.class}).invoke(null, new Object[]{t, aVar});
        } catch (IllegalAccessException e) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e);
        } catch (InvocationTargetException e2) {
            if (e2.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e2.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (ClassNotFoundException e4) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e4);
        }
    }

    /* renamed from: c */
    private static <T extends C1461c> Class m5812c(T t) throws ClassNotFoundException {
        return m5809a(t.getClass());
    }

    /* renamed from: a */
    private static Class m5809a(Class<? extends C1461c> cls) throws ClassNotFoundException {
        return Class.forName(String.format("%s.%sParcelizer", new Object[]{cls.getPackage().getName(), cls.getSimpleName()}), false, cls.getClassLoader());
    }
}
