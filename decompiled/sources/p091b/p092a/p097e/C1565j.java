package p091b.p092a.p097e;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.common.primitives.UnsignedBytes;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import p091b.p092a.C1508c;
import p102c.C1672c;
import p102c.C1675d;

/* renamed from: b.a.e.j */
/* compiled from: Http2Writer */
final class C1565j implements Closeable {

    /* renamed from: b */
    private static final Logger f4799b = Logger.getLogger(C1540e.class.getName());

    /* renamed from: a */
    final C1539b f4800a = new C1539b(this.f4803e);

    /* renamed from: c */
    private final C1675d f4801c;

    /* renamed from: d */
    private final boolean f4802d;

    /* renamed from: e */
    private final C1672c f4803e = new C1672c();

    /* renamed from: f */
    private int f4804f = 16384;

    /* renamed from: g */
    private boolean f4805g;

    C1565j(C1675d dVar, boolean z) {
        this.f4801c = dVar;
        this.f4802d = z;
    }

    /* renamed from: a */
    public synchronized void mo6379a() throws IOException {
        if (this.f4805g) {
            throw new IOException("closed");
        } else if (this.f4802d) {
            if (f4799b.isLoggable(Level.FINE)) {
                f4799b.fine(C1508c.m6075a(">> CONNECTION %s", C1540e.f4677a.mo6900f()));
            }
            this.f4801c.mo6831c(C1540e.f4677a.mo6904i());
            this.f4801c.flush();
        }
    }

    /* renamed from: a */
    public synchronized void mo6386a(C1570m mVar) throws IOException {
        if (!this.f4805g) {
            this.f4804f = mVar.mo6411d(this.f4804f);
            if (mVar.mo6408c() != -1) {
                this.f4800a.mo6314a(mVar.mo6408c());
            }
            mo6381a(0, 0, 4, 1);
            this.f4801c.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void mo6382a(int i, int i2, List<C1536c> list) throws IOException {
        if (!this.f4805g) {
            this.f4800a.mo6317a(list);
            long b = this.f4803e.mo6823b();
            int min = (int) Math.min((long) (this.f4804f - 4), b);
            long j = (long) min;
            int i3 = (b > j ? 1 : (b == j ? 0 : -1));
            mo6381a(i, min + 4, 5, i3 == 0 ? (byte) 4 : 0);
            this.f4801c.mo6845g(i2 & BaseClientBuilder.API_PRIORITY_OTHER);
            this.f4801c.mo6217a_(this.f4803e, j);
            if (i3 > 0) {
                m6347b(i, b - j);
            }
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: b */
    public synchronized void mo6391b() throws IOException {
        if (!this.f4805g) {
            this.f4801c.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void mo6388a(boolean z, int i, int i2, List<C1536c> list) throws IOException {
        if (!this.f4805g) {
            mo6390a(z, i, list);
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void mo6384a(int i, C1535b bVar) throws IOException {
        if (this.f4805g) {
            throw new IOException("closed");
        } else if (bVar.f4647l != -1) {
            mo6381a(i, 4, 3, 0);
            this.f4801c.mo6845g(bVar.f4647l);
            this.f4801c.flush();
        } else {
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: c */
    public int mo6393c() {
        return this.f4804f;
    }

    /* renamed from: a */
    public synchronized void mo6389a(boolean z, int i, C1672c cVar, int i2) throws IOException {
        if (!this.f4805g) {
            byte b = 0;
            if (z) {
                b = (byte) 1;
            }
            mo6380a(i, b, cVar, i2);
        } else {
            throw new IOException("closed");
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo6380a(int i, byte b, C1672c cVar, int i2) throws IOException {
        mo6381a(i, i2, 0, b);
        if (i2 > 0) {
            this.f4801c.mo6217a_(cVar, (long) i2);
        }
    }

    /* renamed from: b */
    public synchronized void mo6392b(C1570m mVar) throws IOException {
        if (!this.f4805g) {
            int i = 0;
            mo6381a(0, mVar.mo6406b() * 6, 4, 0);
            while (i < 10) {
                if (mVar.mo6405a(i)) {
                    int i2 = i == 4 ? 3 : i == 7 ? 4 : i;
                    this.f4801c.mo6849h(i2);
                    this.f4801c.mo6845g(mVar.mo6407b(i));
                }
                i++;
            }
            this.f4801c.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void mo6387a(boolean z, int i, int i2) throws IOException {
        if (!this.f4805g) {
            mo6381a(0, 8, 6, z ? (byte) 1 : 0);
            this.f4801c.mo6845g(i);
            this.f4801c.mo6845g(i2);
            this.f4801c.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void mo6385a(int i, C1535b bVar, byte[] bArr) throws IOException {
        if (this.f4805g) {
            throw new IOException("closed");
        } else if (bVar.f4647l != -1) {
            mo6381a(0, bArr.length + 8, 7, 0);
            this.f4801c.mo6845g(i);
            this.f4801c.mo6845g(bVar.f4647l);
            if (bArr.length > 0) {
                this.f4801c.mo6831c(bArr);
            }
            this.f4801c.flush();
        } else {
            throw C1540e.m6217a("errorCode.httpCode == -1", new Object[0]);
        }
    }

    /* renamed from: a */
    public synchronized void mo6383a(int i, long j) throws IOException {
        if (this.f4805g) {
            throw new IOException("closed");
        } else if (j == 0 || j > 2147483647L) {
            throw C1540e.m6217a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
        } else {
            mo6381a(i, 4, 8, 0);
            this.f4801c.mo6845g((int) j);
            this.f4801c.flush();
        }
    }

    /* renamed from: a */
    public void mo6381a(int i, int i2, byte b, byte b2) throws IOException {
        if (f4799b.isLoggable(Level.FINE)) {
            f4799b.fine(C1540e.m6219a(false, i, i2, b, b2));
        }
        if (i2 > this.f4804f) {
            throw C1540e.m6217a("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(this.f4804f), Integer.valueOf(i2));
        } else if ((Integer.MIN_VALUE & i) == 0) {
            m6346a(this.f4801c, i2);
            this.f4801c.mo6854i(b & UnsignedBytes.MAX_VALUE);
            this.f4801c.mo6854i(b2 & UnsignedBytes.MAX_VALUE);
            this.f4801c.mo6845g(i & BaseClientBuilder.API_PRIORITY_OTHER);
        } else {
            throw C1540e.m6217a("reserved bit set: %s", Integer.valueOf(i));
        }
    }

    public synchronized void close() throws IOException {
        this.f4805g = true;
        this.f4801c.close();
    }

    /* renamed from: a */
    private static void m6346a(C1675d dVar, int i) throws IOException {
        dVar.mo6854i((i >>> 16) & 255);
        dVar.mo6854i((i >>> 8) & 255);
        dVar.mo6854i(i & 255);
    }

    /* renamed from: b */
    private void m6347b(int i, long j) throws IOException {
        while (j > 0) {
            int min = (int) Math.min((long) this.f4804f, j);
            long j2 = (long) min;
            j -= j2;
            mo6381a(i, min, 9, j == 0 ? (byte) 4 : 0);
            this.f4801c.mo6217a_(this.f4803e, j2);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo6390a(boolean z, int i, List<C1536c> list) throws IOException {
        if (!this.f4805g) {
            this.f4800a.mo6317a(list);
            long b = this.f4803e.mo6823b();
            int min = (int) Math.min((long) this.f4804f, b);
            long j = (long) min;
            int i2 = (b > j ? 1 : (b == j ? 0 : -1));
            byte b2 = i2 == 0 ? (byte) 4 : 0;
            if (z) {
                b2 = (byte) (b2 | 1);
            }
            mo6381a(i, min, 1, b2);
            this.f4801c.mo6217a_(this.f4803e, j);
            if (i2 > 0) {
                m6347b(i, b - j);
                return;
            }
            return;
        }
        throw new IOException("closed");
    }
}
