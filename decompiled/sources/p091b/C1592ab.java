package p091b;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import p091b.p092a.C1508c;
import p102c.C1675d;
import p102c.C1677f;
import p102c.C1683l;
import p102c.C1695s;

/* renamed from: b.ab */
/* compiled from: RequestBody */
public abstract class C1592ab {
    /* renamed from: a */
    public abstract void mo6474a(C1675d dVar) throws IOException;

    /* renamed from: b */
    public abstract C1647v mo6475b();

    /* renamed from: c */
    public long mo6476c() throws IOException {
        return -1;
    }

    /* renamed from: a */
    public static C1592ab m6494a(final C1647v vVar, final C1677f fVar) {
        return new C1592ab() {
            /* renamed from: b */
            public C1647v mo6475b() {
                return C1647v.this;
            }

            /* renamed from: c */
            public long mo6476c() throws IOException {
                return (long) fVar.mo6902h();
            }

            /* renamed from: a */
            public void mo6474a(C1675d dVar) throws IOException {
                dVar.mo6827b(fVar);
            }
        };
    }

    /* renamed from: a */
    public static C1592ab m6496a(C1647v vVar, byte[] bArr) {
        return m6497a(vVar, bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public static C1592ab m6497a(final C1647v vVar, final byte[] bArr, final int i, final int i2) {
        if (bArr != null) {
            C1508c.m6081a((long) bArr.length, (long) i, (long) i2);
            return new C1592ab() {
                /* renamed from: b */
                public C1647v mo6475b() {
                    return C1647v.this;
                }

                /* renamed from: c */
                public long mo6476c() {
                    return (long) i2;
                }

                /* renamed from: a */
                public void mo6474a(C1675d dVar) throws IOException {
                    dVar.mo6832c(bArr, i, i2);
                }
            };
        }
        throw new NullPointerException("content == null");
    }

    /* renamed from: a */
    public static C1592ab m6495a(final C1647v vVar, final File file) {
        if (file != null) {
            return new C1592ab() {
                /* renamed from: b */
                public C1647v mo6475b() {
                    return C1647v.this;
                }

                /* renamed from: c */
                public long mo6476c() {
                    return file.length();
                }

                /* renamed from: a */
                public void mo6474a(C1675d dVar) throws IOException {
                    C1695s sVar = null;
                    try {
                        C1695s a = C1683l.m7038a(file);
                        try {
                            dVar.mo6809a(a);
                            C1508c.m6082a((Closeable) a);
                        } catch (Throwable th) {
                            th = th;
                            sVar = a;
                            C1508c.m6082a((Closeable) sVar);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        C1508c.m6082a((Closeable) sVar);
                        throw th;
                    }
                }
            };
        }
        throw new NullPointerException("content == null");
    }
}
