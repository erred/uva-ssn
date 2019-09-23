package p091b.p092a.p097e;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import p091b.p092a.C1508c;
import p102c.C1672c;
import p102c.C1676e;
import p102c.C1677f;
import p102c.C1695s;
import p102c.C1696t;

/* renamed from: b.a.e.h */
/* compiled from: Http2Reader */
final class C1558h implements Closeable {

    /* renamed from: a */
    static final Logger f4762a = Logger.getLogger(C1540e.class.getName());

    /* renamed from: b */
    final C1538a f4763b = new C1538a(4096, this.f4765d);

    /* renamed from: c */
    private final C1676e f4764c;

    /* renamed from: d */
    private final C1559a f4765d = new C1559a(this.f4764c);

    /* renamed from: e */
    private final boolean f4766e;

    /* renamed from: b.a.e.h$a */
    /* compiled from: Http2Reader */
    static final class C1559a implements C1695s {

        /* renamed from: a */
        int f4767a;

        /* renamed from: b */
        byte f4768b;

        /* renamed from: c */
        int f4769c;

        /* renamed from: d */
        int f4770d;

        /* renamed from: e */
        short f4771e;

        /* renamed from: f */
        private final C1676e f4772f;

        public void close() throws IOException {
        }

        C1559a(C1676e eVar) {
            this.f4772f = eVar;
        }

        /* renamed from: a */
        public long mo6185a(C1672c cVar, long j) throws IOException {
            while (this.f4770d == 0) {
                this.f4772f.mo6850h((long) this.f4771e);
                this.f4771e = 0;
                if ((this.f4768b & 4) != 0) {
                    return -1;
                }
                m6303b();
            }
            long a = this.f4772f.mo6185a(cVar, Math.min(j, (long) this.f4770d));
            if (a == -1) {
                return -1;
            }
            this.f4770d = (int) (((long) this.f4770d) - a);
            return a;
        }

        /* renamed from: a */
        public C1696t mo6186a() {
            return this.f4772f.mo6186a();
        }

        /* renamed from: b */
        private void m6303b() throws IOException {
            int i = this.f4769c;
            int a = C1558h.m6289a(this.f4772f);
            this.f4770d = a;
            this.f4767a = a;
            byte i2 = (byte) (this.f4772f.mo6852i() & UnsignedBytes.MAX_VALUE);
            this.f4768b = (byte) (this.f4772f.mo6852i() & UnsignedBytes.MAX_VALUE);
            if (C1558h.f4762a.isLoggable(Level.FINE)) {
                C1558h.f4762a.fine(C1540e.m6219a(true, this.f4769c, this.f4767a, i2, this.f4768b));
            }
            this.f4769c = this.f4772f.mo6858k() & BaseClientBuilder.API_PRIORITY_OTHER;
            if (i2 != 9) {
                throw C1540e.m6220b("%s != TYPE_CONTINUATION", Byte.valueOf(i2));
            } else if (this.f4769c != i) {
                throw C1540e.m6220b("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }
    }

    /* renamed from: b.a.e.h$b */
    /* compiled from: Http2Reader */
    interface C1560b {
        /* renamed from: a */
        void mo6344a();

        /* renamed from: a */
        void mo6345a(int i, int i2, int i3, boolean z);

        /* renamed from: a */
        void mo6346a(int i, int i2, List<C1536c> list) throws IOException;

        /* renamed from: a */
        void mo6347a(int i, long j);

        /* renamed from: a */
        void mo6348a(int i, C1535b bVar);

        /* renamed from: a */
        void mo6349a(int i, C1535b bVar, C1677f fVar);

        /* renamed from: a */
        void mo6350a(boolean z, int i, int i2);

        /* renamed from: a */
        void mo6351a(boolean z, int i, int i2, List<C1536c> list);

        /* renamed from: a */
        void mo6352a(boolean z, int i, C1676e eVar, int i2) throws IOException;

        /* renamed from: a */
        void mo6353a(boolean z, C1570m mVar);
    }

    C1558h(C1676e eVar, boolean z) {
        this.f4764c = eVar;
        this.f4766e = z;
    }

    /* renamed from: a */
    public void mo6354a(C1560b bVar) throws IOException {
        if (!this.f4766e) {
            C1677f c = this.f4764c.mo6833c((long) C1540e.f4677a.mo6902h());
            if (f4762a.isLoggable(Level.FINE)) {
                f4762a.fine(C1508c.m6075a("<< CONNECTION %s", c.mo6900f()));
            }
            if (!C1540e.f4677a.equals(c)) {
                throw C1540e.m6220b("Expected a connection header but was %s", c.mo6888a());
            }
        } else if (!mo6355a(true, bVar)) {
            throw C1540e.m6220b("Required SETTINGS preface not received", new Object[0]);
        }
    }

    /* renamed from: a */
    public boolean mo6355a(boolean z, C1560b bVar) throws IOException {
        try {
            this.f4764c.mo6818a(9);
            int a = m6289a(this.f4764c);
            if (a < 0 || a > 16384) {
                throw C1540e.m6220b("FRAME_SIZE_ERROR: %s", Integer.valueOf(a));
            }
            byte i = (byte) (this.f4764c.mo6852i() & UnsignedBytes.MAX_VALUE);
            if (!z || i == 4) {
                byte i2 = (byte) (this.f4764c.mo6852i() & UnsignedBytes.MAX_VALUE);
                int k = this.f4764c.mo6858k() & BaseClientBuilder.API_PRIORITY_OTHER;
                if (f4762a.isLoggable(Level.FINE)) {
                    f4762a.fine(C1540e.m6219a(true, k, a, i, i2));
                }
                switch (i) {
                    case 0:
                        m6293b(bVar, a, i2, k);
                        break;
                    case 1:
                        m6292a(bVar, a, i2, k);
                        break;
                    case 2:
                        m6294c(bVar, a, i2, k);
                        break;
                    case 3:
                        m6295d(bVar, a, i2, k);
                        break;
                    case 4:
                        m6296e(bVar, a, i2, k);
                        break;
                    case 5:
                        m6297f(bVar, a, i2, k);
                        break;
                    case 6:
                        m6298g(bVar, a, i2, k);
                        break;
                    case 7:
                        m6299h(bVar, a, i2, k);
                        break;
                    case 8:
                        m6300i(bVar, a, i2, k);
                        break;
                    default:
                        this.f4764c.mo6850h((long) a);
                        break;
                }
                return true;
            }
            throw C1540e.m6220b("Expected a SETTINGS frame but was %s", Byte.valueOf(i));
        } catch (IOException unused) {
            return false;
        }
    }

    /* renamed from: a */
    private void m6292a(C1560b bVar, int i, byte b, int i2) throws IOException {
        short s = 0;
        if (i2 != 0) {
            boolean z = (b & 1) != 0;
            if ((b & 8) != 0) {
                s = (short) (this.f4764c.mo6852i() & UnsignedBytes.MAX_VALUE);
            }
            if ((b & 32) != 0) {
                m6291a(bVar, i2);
                i -= 5;
            }
            bVar.mo6351a(z, i2, -1, m6290a(m6288a(i, b, s), s, b, i2));
            return;
        }
        throw C1540e.m6220b("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
    }

    /* renamed from: a */
    private List<C1536c> m6290a(int i, short s, byte b, int i2) throws IOException {
        C1559a aVar = this.f4765d;
        this.f4765d.f4770d = i;
        aVar.f4767a = i;
        this.f4765d.f4771e = s;
        this.f4765d.f4768b = b;
        this.f4765d.f4769c = i2;
        this.f4763b.mo6311a();
        return this.f4763b.mo6312b();
    }

    /* renamed from: b */
    private void m6293b(C1560b bVar, int i, byte b, int i2) throws IOException {
        short s = 0;
        if (i2 != 0) {
            boolean z = true;
            boolean z2 = (b & 1) != 0;
            if ((b & 32) == 0) {
                z = false;
            }
            if (!z) {
                if ((b & 8) != 0) {
                    s = (short) (this.f4764c.mo6852i() & UnsignedBytes.MAX_VALUE);
                }
                bVar.mo6352a(z2, i2, this.f4764c, m6288a(i, b, s));
                this.f4764c.mo6850h((long) s);
                return;
            }
            throw C1540e.m6220b("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        throw C1540e.m6220b("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
    }

    /* renamed from: c */
    private void m6294c(C1560b bVar, int i, byte b, int i2) throws IOException {
        if (i != 5) {
            throw C1540e.m6220b("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
        } else if (i2 != 0) {
            m6291a(bVar, i2);
        } else {
            throw C1540e.m6220b("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
    }

    /* renamed from: a */
    private void m6291a(C1560b bVar, int i) throws IOException {
        int k = this.f4764c.mo6858k();
        bVar.mo6345a(i, k & BaseClientBuilder.API_PRIORITY_OTHER, (this.f4764c.mo6852i() & UnsignedBytes.MAX_VALUE) + 1, (Integer.MIN_VALUE & k) != 0);
    }

    /* renamed from: d */
    private void m6295d(C1560b bVar, int i, byte b, int i2) throws IOException {
        if (i != 4) {
            throw C1540e.m6220b("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
        } else if (i2 != 0) {
            int k = this.f4764c.mo6858k();
            C1535b a = C1535b.m6189a(k);
            if (a != null) {
                bVar.mo6348a(i2, a);
            } else {
                throw C1540e.m6220b("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(k));
            }
        } else {
            throw C1540e.m6220b("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
    }

    /* renamed from: e */
    private void m6296e(C1560b bVar, int i, byte b, int i2) throws IOException {
        if (i2 != 0) {
            throw C1540e.m6220b("TYPE_SETTINGS streamId != 0", new Object[0]);
        } else if ((b & 1) != 0) {
            if (i == 0) {
                bVar.mo6344a();
            } else {
                throw C1540e.m6220b("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            }
        } else if (i % 6 == 0) {
            C1570m mVar = new C1570m();
            for (int i3 = 0; i3 < i; i3 += 6) {
                short j = this.f4764c.mo6857j() & 65535;
                int k = this.f4764c.mo6858k();
                switch (j) {
                    case 2:
                        if (!(k == 0 || k == 1)) {
                            throw C1540e.m6220b("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                        }
                    case 3:
                        j = 4;
                        break;
                    case 4:
                        j = 7;
                        if (k >= 0) {
                            break;
                        } else {
                            throw C1540e.m6220b("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                        }
                    case 5:
                        if (k >= 16384 && k <= 16777215) {
                            break;
                        } else {
                            throw C1540e.m6220b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(k));
                        }
                        break;
                }
                mVar.mo6402a(j, k);
            }
            bVar.mo6353a(false, mVar);
        } else {
            throw C1540e.m6220b("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
        }
    }

    /* renamed from: f */
    private void m6297f(C1560b bVar, int i, byte b, int i2) throws IOException {
        short s = 0;
        if (i2 != 0) {
            if ((b & 8) != 0) {
                s = (short) (this.f4764c.mo6852i() & UnsignedBytes.MAX_VALUE);
            }
            bVar.mo6346a(i2, this.f4764c.mo6858k() & BaseClientBuilder.API_PRIORITY_OTHER, m6290a(m6288a(i - 4, b, s), s, b, i2));
            return;
        }
        throw C1540e.m6220b("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
    }

    /* renamed from: g */
    private void m6298g(C1560b bVar, int i, byte b, int i2) throws IOException {
        boolean z = false;
        if (i != 8) {
            throw C1540e.m6220b("TYPE_PING length != 8: %s", Integer.valueOf(i));
        } else if (i2 == 0) {
            int k = this.f4764c.mo6858k();
            int k2 = this.f4764c.mo6858k();
            if ((b & 1) != 0) {
                z = true;
            }
            bVar.mo6350a(z, k, k2);
        } else {
            throw C1540e.m6220b("TYPE_PING streamId != 0", new Object[0]);
        }
    }

    /* renamed from: h */
    private void m6299h(C1560b bVar, int i, byte b, int i2) throws IOException {
        if (i < 8) {
            throw C1540e.m6220b("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
        } else if (i2 == 0) {
            int k = this.f4764c.mo6858k();
            int k2 = this.f4764c.mo6858k();
            int i3 = i - 8;
            C1535b a = C1535b.m6189a(k2);
            if (a != null) {
                C1677f fVar = C1677f.f5294b;
                if (i3 > 0) {
                    fVar = this.f4764c.mo6833c((long) i3);
                }
                bVar.mo6349a(k, a, fVar);
                return;
            }
            throw C1540e.m6220b("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(k2));
        } else {
            throw C1540e.m6220b("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
    }

    /* renamed from: i */
    private void m6300i(C1560b bVar, int i, byte b, int i2) throws IOException {
        if (i == 4) {
            long k = ((long) this.f4764c.mo6858k()) & 2147483647L;
            if (k != 0) {
                bVar.mo6347a(i2, k);
            } else {
                throw C1540e.m6220b("windowSizeIncrement was 0", Long.valueOf(k));
            }
        } else {
            throw C1540e.m6220b("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
        }
    }

    public void close() throws IOException {
        this.f4764c.close();
    }

    /* renamed from: a */
    static int m6289a(C1676e eVar) throws IOException {
        return (eVar.mo6852i() & UnsignedBytes.MAX_VALUE) | ((eVar.mo6852i() & UnsignedBytes.MAX_VALUE) << Ascii.DLE) | ((eVar.mo6852i() & UnsignedBytes.MAX_VALUE) << 8);
    }

    /* renamed from: a */
    static int m6288a(int i, byte b, short s) throws IOException {
        if ((b & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        throw C1540e.m6220b("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
    }
}
