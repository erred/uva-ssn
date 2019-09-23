package p000a.p001a.p002a.p003a.p004a.p006b;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: a.a.a.a.a.b.q */
/* compiled from: QueueFile */
public class C0036q implements Closeable {

    /* renamed from: b */
    private static final Logger f82b = Logger.getLogger(C0036q.class.getName());

    /* renamed from: a */
    int f83a;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final RandomAccessFile f84c;

    /* renamed from: d */
    private int f85d;

    /* renamed from: e */
    private C0038a f86e;

    /* renamed from: f */
    private C0038a f87f;

    /* renamed from: g */
    private final byte[] f88g = new byte[16];

    /* renamed from: a.a.a.a.a.b.q$a */
    /* compiled from: QueueFile */
    static class C0038a {

        /* renamed from: a */
        static final C0038a f92a = new C0038a(0, 0);

        /* renamed from: b */
        final int f93b;

        /* renamed from: c */
        final int f94c;

        C0038a(int i, int i2) {
            this.f93b = i;
            this.f94c = i2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getClass().getSimpleName());
            sb.append("[position = ");
            sb.append(this.f93b);
            sb.append(", length = ");
            sb.append(this.f94c);
            sb.append("]");
            return sb.toString();
        }
    }

    /* renamed from: a.a.a.a.a.b.q$b */
    /* compiled from: QueueFile */
    private final class C0039b extends InputStream {

        /* renamed from: b */
        private int f96b;

        /* renamed from: c */
        private int f97c;

        private C0039b(C0038a aVar) {
            this.f96b = C0036q.this.m140b(aVar.f93b + 4);
            this.f97c = aVar.f94c;
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            C0036q.m142b(bArr, "buffer");
            if ((i | i2) < 0 || i2 > bArr.length - i) {
                throw new ArrayIndexOutOfBoundsException();
            } else if (this.f97c <= 0) {
                return -1;
            } else {
                if (i2 > this.f97c) {
                    i2 = this.f97c;
                }
                C0036q.this.m143b(this.f96b, bArr, i, i2);
                this.f96b = C0036q.this.m140b(this.f96b + i2);
                this.f97c -= i2;
                return i2;
            }
        }

        public int read() throws IOException {
            if (this.f97c == 0) {
                return -1;
            }
            C0036q.this.f84c.seek((long) this.f96b);
            int read = C0036q.this.f84c.read();
            this.f96b = C0036q.this.m140b(this.f96b + 1);
            this.f97c--;
            return read;
        }
    }

    /* renamed from: a.a.a.a.a.b.q$c */
    /* compiled from: QueueFile */
    public interface C0040c {
        /* renamed from: a */
        void mo78a(InputStream inputStream, int i) throws IOException;
    }

    public C0036q(File file) throws IOException {
        if (!file.exists()) {
            m138a(file);
        }
        this.f84c = m141b(file);
        m145c();
    }

    /* renamed from: b */
    private static void m144b(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 >> 24);
        bArr[i + 1] = (byte) (i2 >> 16);
        bArr[i + 2] = (byte) (i2 >> 8);
        bArr[i + 3] = (byte) i2;
    }

    /* renamed from: a */
    private static void m139a(byte[] bArr, int... iArr) {
        int i = 0;
        for (int b : iArr) {
            m144b(bArr, i, b);
            i += 4;
        }
    }

    /* renamed from: a */
    private static int m131a(byte[] bArr, int i) {
        return ((bArr[i] & UnsignedBytes.MAX_VALUE) << Ascii.CAN) + ((bArr[i + 1] & UnsignedBytes.MAX_VALUE) << Ascii.DLE) + ((bArr[i + 2] & UnsignedBytes.MAX_VALUE) << 8) + (bArr[i + 3] & UnsignedBytes.MAX_VALUE);
    }

    /* renamed from: c */
    private void m145c() throws IOException {
        this.f84c.seek(0);
        this.f84c.readFully(this.f88g);
        this.f83a = m131a(this.f88g, 0);
        if (((long) this.f83a) <= this.f84c.length()) {
            this.f85d = m131a(this.f88g, 4);
            int a = m131a(this.f88g, 8);
            int a2 = m131a(this.f88g, 12);
            this.f86e = m132a(a);
            this.f87f = m132a(a2);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("File is truncated. Expected length: ");
        sb.append(this.f83a);
        sb.append(", Actual length: ");
        sb.append(this.f84c.length());
        throw new IOException(sb.toString());
    }

    /* renamed from: a */
    private void m135a(int i, int i2, int i3, int i4) throws IOException {
        m139a(this.f88g, i, i2, i3, i4);
        this.f84c.seek(0);
        this.f84c.write(this.f88g);
    }

    /* renamed from: a */
    private C0038a m132a(int i) throws IOException {
        if (i == 0) {
            return C0038a.f92a;
        }
        this.f84c.seek((long) i);
        return new C0038a(i, this.f84c.readInt());
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    private static void m138a(File file) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(file.getPath());
        sb.append(".tmp");
        File file2 = new File(sb.toString());
        RandomAccessFile b = m141b(file2);
        try {
            b.setLength(4096);
            b.seek(0);
            byte[] bArr = new byte[16];
            m139a(bArr, 4096, 0, 0, 0);
            b.write(bArr);
            b.close();
            if (!file2.renameTo(file)) {
                throw new IOException("Rename failed!");
            }
        } catch (Throwable th) {
            b.close();
            throw th;
        }
    }

    /* renamed from: b */
    private static RandomAccessFile m141b(File file) throws FileNotFoundException {
        return new RandomAccessFile(file, "rwd");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public int m140b(int i) {
        return i < this.f83a ? i : (i + 16) - this.f83a;
    }

    /* renamed from: a */
    private void m136a(int i, byte[] bArr, int i2, int i3) throws IOException {
        int b = m140b(i);
        if (b + i3 <= this.f83a) {
            this.f84c.seek((long) b);
            this.f84c.write(bArr, i2, i3);
            return;
        }
        int i4 = this.f83a - b;
        this.f84c.seek((long) b);
        this.f84c.write(bArr, i2, i4);
        this.f84c.seek(16);
        this.f84c.write(bArr, i2 + i4, i3 - i4);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m143b(int i, byte[] bArr, int i2, int i3) throws IOException {
        int b = m140b(i);
        if (b + i3 <= this.f83a) {
            this.f84c.seek((long) b);
            this.f84c.readFully(bArr, i2, i3);
            return;
        }
        int i4 = this.f83a - b;
        this.f84c.seek((long) b);
        this.f84c.readFully(bArr, i2, i4);
        this.f84c.seek(16);
        this.f84c.readFully(bArr, i2 + i4, i3 - i4);
    }

    /* renamed from: a */
    public void mo72a(byte[] bArr) throws IOException {
        mo73a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public synchronized void mo73a(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        m142b(bArr, "buffer");
        if ((i | i2) < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        }
        m146c(i2);
        boolean b = mo75b();
        if (b) {
            i3 = 16;
        } else {
            i3 = m140b(this.f87f.f93b + 4 + this.f87f.f94c);
        }
        C0038a aVar = new C0038a(i3, i2);
        m144b(this.f88g, 0, i2);
        m136a(aVar.f93b, this.f88g, 0, 4);
        m136a(aVar.f93b + 4, bArr, i, i2);
        m135a(this.f83a, this.f85d + 1, b ? aVar.f93b : this.f86e.f93b, aVar.f93b);
        this.f87f = aVar;
        this.f85d++;
        if (b) {
            this.f86e = this.f87f;
        }
    }

    /* renamed from: a */
    public int mo70a() {
        if (this.f85d == 0) {
            return 16;
        }
        if (this.f87f.f93b >= this.f86e.f93b) {
            return (this.f87f.f93b - this.f86e.f93b) + 4 + this.f87f.f94c + 16;
        }
        return (((this.f87f.f93b + 4) + this.f87f.f94c) + this.f83a) - this.f86e.f93b;
    }

    /* renamed from: d */
    private int m147d() {
        return this.f83a - mo70a();
    }

    /* renamed from: b */
    public synchronized boolean mo75b() {
        return this.f85d == 0;
    }

    /* renamed from: c */
    private void m146c(int i) throws IOException {
        int i2 = i + 4;
        int d = m147d();
        if (d < i2) {
            int i3 = this.f83a;
            do {
                d += i3;
                i3 <<= 1;
            } while (d < i2);
            m148d(i3);
            int b = m140b(this.f87f.f93b + 4 + this.f87f.f94c);
            if (b < this.f86e.f93b) {
                FileChannel channel = this.f84c.getChannel();
                channel.position((long) this.f83a);
                long j = (long) (b - 4);
                if (channel.transferTo(16, j, channel) != j) {
                    throw new AssertionError("Copied insufficient number of bytes!");
                }
            }
            if (this.f87f.f93b < this.f86e.f93b) {
                int i4 = (this.f83a + this.f87f.f93b) - 16;
                m135a(i3, this.f85d, this.f86e.f93b, i4);
                this.f87f = new C0038a(i4, this.f87f.f94c);
            } else {
                m135a(i3, this.f85d, this.f86e.f93b, this.f87f.f93b);
            }
            this.f83a = i3;
        }
    }

    /* renamed from: d */
    private void m148d(int i) throws IOException {
        this.f84c.setLength((long) i);
        this.f84c.getChannel().force(true);
    }

    /* renamed from: a */
    public synchronized void mo71a(C0040c cVar) throws IOException {
        int i = this.f86e.f93b;
        for (int i2 = 0; i2 < this.f85d; i2++) {
            C0038a a = m132a(i);
            cVar.mo78a(new C0039b(a), a.f94c);
            i = m140b(a.f93b + 4 + a.f94c);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static <T> T m142b(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public synchronized void close() throws IOException {
        this.f84c.close();
    }

    /* renamed from: a */
    public boolean mo74a(int i, int i2) {
        return (mo70a() + 4) + i <= i2;
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append('[');
        sb.append("fileLength=");
        sb.append(this.f83a);
        sb.append(", size=");
        sb.append(this.f85d);
        sb.append(", first=");
        sb.append(this.f86e);
        sb.append(", last=");
        sb.append(this.f87f);
        sb.append(", element lengths=[");
        try {
            mo71a((C0040c) new C0040c() {

                /* renamed from: a */
                boolean f89a = true;

                /* renamed from: a */
                public void mo78a(InputStream inputStream, int i) throws IOException {
                    if (this.f89a) {
                        this.f89a = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append(i);
                }
            });
        } catch (IOException e) {
            f82b.log(Level.WARNING, "read error", e);
        }
        sb.append("]]");
        return sb.toString();
    }
}
