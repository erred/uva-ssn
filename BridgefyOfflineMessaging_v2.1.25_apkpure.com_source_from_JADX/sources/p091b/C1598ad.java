package p091b;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import p091b.p092a.C1508c;
import p102c.C1672c;
import p102c.C1676e;

/* renamed from: b.ad */
/* compiled from: ResponseBody */
public abstract class C1598ad implements Closeable {

    /* renamed from: a */
    private Reader f4901a;

    /* renamed from: b.ad$a */
    /* compiled from: ResponseBody */
    static final class C1600a extends Reader {

        /* renamed from: a */
        private final C1676e f4905a;

        /* renamed from: b */
        private final Charset f4906b;

        /* renamed from: c */
        private boolean f4907c;

        /* renamed from: d */
        private Reader f4908d;

        C1600a(C1676e eVar, Charset charset) {
            this.f4905a = eVar;
            this.f4906b = charset;
        }

        public int read(char[] cArr, int i, int i2) throws IOException {
            if (!this.f4907c) {
                Reader reader = this.f4908d;
                if (reader == null) {
                    Reader inputStreamReader = new InputStreamReader(this.f4905a.mo6846g(), C1508c.m6077a(this.f4905a, this.f4906b));
                    this.f4908d = inputStreamReader;
                    reader = inputStreamReader;
                }
                return reader.read(cArr, i, i2);
            }
            throw new IOException("Stream closed");
        }

        public void close() throws IOException {
            this.f4907c = true;
            if (this.f4908d != null) {
                this.f4908d.close();
            } else {
                this.f4905a.close();
            }
        }
    }

    /* renamed from: a */
    public abstract C1647v mo6290a();

    /* renamed from: b */
    public abstract long mo6291b();

    /* renamed from: c */
    public abstract C1676e mo6292c();

    /* renamed from: d */
    public final InputStream mo6511d() {
        return mo6292c().mo6846g();
    }

    /* renamed from: e */
    public final Reader mo6512e() {
        Reader reader = this.f4901a;
        if (reader != null) {
            return reader;
        }
        C1600a aVar = new C1600a(mo6292c(), mo28244g());
        this.f4901a = aVar;
        return aVar;
    }

    /* renamed from: f */
    public final String mo6513f() throws IOException {
        C1676e c = mo6292c();
        try {
            return c.mo6817a(C1508c.m6077a(c, mo28244g()));
        } finally {
            C1508c.m6082a((Closeable) c);
        }
    }

    /* renamed from: g */
    private Charset mo28244g() {
        C1647v a = mo6290a();
        return a != null ? a.mo6697a(C1508c.f4564e) : C1508c.f4564e;
    }

    public void close() {
        C1508c.m6082a((Closeable) mo6292c());
    }

    /* renamed from: a */
    public static C1598ad m6544a(C1647v vVar, byte[] bArr) {
        return m6543a(vVar, (long) bArr.length, new C1672c().mo6831c(bArr));
    }

    /* renamed from: a */
    public static C1598ad m6543a(final C1647v vVar, final long j, final C1676e eVar) {
        if (eVar != null) {
            return new C1598ad() {
                /* renamed from: a */
                public C1647v mo6290a() {
                    return C1647v.this;
                }

                /* renamed from: b */
                public long mo6291b() {
                    return j;
                }

                /* renamed from: c */
                public C1676e mo6292c() {
                    return eVar;
                }
            };
        }
        throw new NullPointerException("source == null");
    }
}
