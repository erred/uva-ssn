package com.twitter.sdk.android.core.internal.scribe;

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

/* renamed from: com.twitter.sdk.android.core.internal.scribe.o */
/* compiled from: QueueFile */
public class C3230o implements Closeable {

    /* renamed from: b */
    private static final Logger f8452b = Logger.getLogger(C3230o.class.getName());

    /* renamed from: a */
    int f8453a;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final RandomAccessFile f8454c;

    /* renamed from: d */
    private int f8455d;

    /* renamed from: e */
    private C3232a f8456e;

    /* renamed from: f */
    private C3232a f8457f;

    /* renamed from: g */
    private final byte[] f8458g = new byte[16];

    /* renamed from: com.twitter.sdk.android.core.internal.scribe.o$a */
    /* compiled from: QueueFile */
    static class C3232a {

        /* renamed from: a */
        static final C3232a f8462a = new C3232a(0, 0);

        /* renamed from: b */
        final int f8463b;

        /* renamed from: c */
        final int f8464c;

        C3232a(int i, int i2) {
            this.f8463b = i;
            this.f8464c = i2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getClass().getSimpleName());
            sb.append("[position = ");
            sb.append(this.f8463b);
            sb.append(", length = ");
            sb.append(this.f8464c);
            sb.append("]");
            return sb.toString();
        }
    }

    /* renamed from: com.twitter.sdk.android.core.internal.scribe.o$b */
    /* compiled from: QueueFile */
    private final class C3233b extends InputStream {

        /* renamed from: b */
        private int f8466b;

        /* renamed from: c */
        private int f8467c;

        private C3233b(C3232a aVar) {
            this.f8466b = C3230o.this.m9477b(aVar.f8463b + 4);
            this.f8467c = aVar.f8464c;
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            C3230o.m9479b(bArr, "buffer");
            if ((i | i2) < 0 || i2 > bArr.length - i) {
                throw new ArrayIndexOutOfBoundsException();
            } else if (this.f8467c <= 0) {
                return -1;
            } else {
                if (i2 > this.f8467c) {
                    i2 = this.f8467c;
                }
                C3230o.this.m9480b(this.f8466b, bArr, i, i2);
                this.f8466b = C3230o.this.m9477b(this.f8466b + i2);
                this.f8467c -= i2;
                return i2;
            }
        }

        public int read() throws IOException {
            if (this.f8467c == 0) {
                return -1;
            }
            C3230o.this.f8454c.seek((long) this.f8466b);
            int read = C3230o.this.f8454c.read();
            this.f8466b = C3230o.this.m9477b(this.f8466b + 1);
            this.f8467c--;
            return read;
        }
    }

    /* renamed from: com.twitter.sdk.android.core.internal.scribe.o$c */
    /* compiled from: QueueFile */
    public interface C3234c {
        /* renamed from: a */
        void mo27763a(InputStream inputStream, int i) throws IOException;
    }

    public C3230o(File file) throws IOException {
        if (!file.exists()) {
            m9475a(file);
        }
        this.f8454c = m9478b(file);
        m9482c();
    }

    /* renamed from: b */
    private static void m9481b(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 >> 24);
        bArr[i + 1] = (byte) (i2 >> 16);
        bArr[i + 2] = (byte) (i2 >> 8);
        bArr[i + 3] = (byte) i2;
    }

    /* renamed from: a */
    private static void m9476a(byte[] bArr, int... iArr) {
        int i = 0;
        for (int b : iArr) {
            m9481b(bArr, i, b);
            i += 4;
        }
    }

    /* renamed from: a */
    private static int m9468a(byte[] bArr, int i) {
        return ((bArr[i] & UnsignedBytes.MAX_VALUE) << Ascii.CAN) + ((bArr[i + 1] & UnsignedBytes.MAX_VALUE) << Ascii.DLE) + ((bArr[i + 2] & UnsignedBytes.MAX_VALUE) << 8) + (bArr[i + 3] & UnsignedBytes.MAX_VALUE);
    }

    /* renamed from: c */
    private void m9482c() throws IOException {
        this.f8454c.seek(0);
        this.f8454c.readFully(this.f8458g);
        this.f8453a = m9468a(this.f8458g, 0);
        if (((long) this.f8453a) <= this.f8454c.length()) {
            this.f8455d = m9468a(this.f8458g, 4);
            int a = m9468a(this.f8458g, 8);
            int a2 = m9468a(this.f8458g, 12);
            this.f8456e = m9469a(a);
            this.f8457f = m9469a(a2);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("File is truncated. Expected length: ");
        sb.append(this.f8453a);
        sb.append(", Actual length: ");
        sb.append(this.f8454c.length());
        throw new IOException(sb.toString());
    }

    /* renamed from: a */
    private void m9472a(int i, int i2, int i3, int i4) throws IOException {
        m9476a(this.f8458g, i, i2, i3, i4);
        this.f8454c.seek(0);
        this.f8454c.write(this.f8458g);
    }

    /* renamed from: a */
    private C3232a m9469a(int i) throws IOException {
        if (i == 0) {
            return C3232a.f8462a;
        }
        this.f8454c.seek((long) i);
        return new C3232a(i, this.f8454c.readInt());
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    private static void m9475a(File file) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(file.getPath());
        sb.append(".tmp");
        File file2 = new File(sb.toString());
        RandomAccessFile b = m9478b(file2);
        try {
            b.setLength(4096);
            b.seek(0);
            byte[] bArr = new byte[16];
            m9476a(bArr, 4096, 0, 0, 0);
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
    private static RandomAccessFile m9478b(File file) throws FileNotFoundException {
        return new RandomAccessFile(file, "rwd");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public int m9477b(int i) {
        return i < this.f8453a ? i : (i + 16) - this.f8453a;
    }

    /* renamed from: a */
    private void m9473a(int i, byte[] bArr, int i2, int i3) throws IOException {
        int b = m9477b(i);
        if (b + i3 <= this.f8453a) {
            this.f8454c.seek((long) b);
            this.f8454c.write(bArr, i2, i3);
            return;
        }
        int i4 = this.f8453a - b;
        this.f8454c.seek((long) b);
        this.f8454c.write(bArr, i2, i4);
        this.f8454c.seek(16);
        this.f8454c.write(bArr, i2 + i4, i3 - i4);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m9480b(int i, byte[] bArr, int i2, int i3) throws IOException {
        int b = m9477b(i);
        if (b + i3 <= this.f8453a) {
            this.f8454c.seek((long) b);
            this.f8454c.readFully(bArr, i2, i3);
            return;
        }
        int i4 = this.f8453a - b;
        this.f8454c.seek((long) b);
        this.f8454c.readFully(bArr, i2, i4);
        this.f8454c.seek(16);
        this.f8454c.readFully(bArr, i2 + i4, i3 - i4);
    }

    /* renamed from: a */
    public void mo27818a(byte[] bArr) throws IOException {
        mo27819a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public synchronized void mo27819a(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        m9479b(bArr, "buffer");
        if ((i | i2) < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        }
        m9483c(i2);
        boolean b = mo27821b();
        if (b) {
            i3 = 16;
        } else {
            i3 = m9477b(this.f8457f.f8463b + 4 + this.f8457f.f8464c);
        }
        C3232a aVar = new C3232a(i3, i2);
        m9481b(this.f8458g, 0, i2);
        m9473a(aVar.f8463b, this.f8458g, 0, 4);
        m9473a(aVar.f8463b + 4, bArr, i, i2);
        m9472a(this.f8453a, this.f8455d + 1, b ? aVar.f8463b : this.f8456e.f8463b, aVar.f8463b);
        this.f8457f = aVar;
        this.f8455d++;
        if (b) {
            this.f8456e = this.f8457f;
        }
    }

    /* renamed from: a */
    public int mo27816a() {
        if (this.f8455d == 0) {
            return 16;
        }
        if (this.f8457f.f8463b >= this.f8456e.f8463b) {
            return (this.f8457f.f8463b - this.f8456e.f8463b) + 4 + this.f8457f.f8464c + 16;
        }
        return (((this.f8457f.f8463b + 4) + this.f8457f.f8464c) + this.f8453a) - this.f8456e.f8463b;
    }

    /* renamed from: d */
    private int m9484d() {
        return this.f8453a - mo27816a();
    }

    /* renamed from: b */
    public synchronized boolean mo27821b() {
        return this.f8455d == 0;
    }

    /* renamed from: c */
    private void m9483c(int i) throws IOException {
        int i2 = i + 4;
        int d = m9484d();
        if (d < i2) {
            int i3 = this.f8453a;
            do {
                d += i3;
                i3 <<= 1;
            } while (d < i2);
            m9485d(i3);
            int b = m9477b(this.f8457f.f8463b + 4 + this.f8457f.f8464c);
            if (b < this.f8456e.f8463b) {
                FileChannel channel = this.f8454c.getChannel();
                channel.position((long) this.f8453a);
                long j = (long) (b - 4);
                if (channel.transferTo(16, j, channel) != j) {
                    throw new AssertionError("Copied insufficient number of bytes!");
                }
            }
            if (this.f8457f.f8463b < this.f8456e.f8463b) {
                int i4 = (this.f8453a + this.f8457f.f8463b) - 16;
                m9472a(i3, this.f8455d, this.f8456e.f8463b, i4);
                this.f8457f = new C3232a(i4, this.f8457f.f8464c);
            } else {
                m9472a(i3, this.f8455d, this.f8456e.f8463b, this.f8457f.f8463b);
            }
            this.f8453a = i3;
        }
    }

    /* renamed from: d */
    private void m9485d(int i) throws IOException {
        this.f8454c.setLength((long) i);
        this.f8454c.getChannel().force(true);
    }

    /* renamed from: a */
    public synchronized void mo27817a(C3234c cVar) throws IOException {
        int i = this.f8456e.f8463b;
        for (int i2 = 0; i2 < this.f8455d; i2++) {
            C3232a a = m9469a(i);
            cVar.mo27763a(new C3233b(a), a.f8464c);
            i = m9477b(a.f8463b + 4 + a.f8464c);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static <T> T m9479b(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public synchronized void close() throws IOException {
        this.f8454c.close();
    }

    /* renamed from: a */
    public boolean mo27820a(int i, int i2) {
        return (mo27816a() + 4) + i <= i2;
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append('[');
        sb.append("fileLength=");
        sb.append(this.f8453a);
        sb.append(", size=");
        sb.append(this.f8455d);
        sb.append(", first=");
        sb.append(this.f8456e);
        sb.append(", last=");
        sb.append(this.f8457f);
        sb.append(", element lengths=[");
        try {
            mo27817a((C3234c) new C3234c() {

                /* renamed from: a */
                boolean f8459a = true;

                /* renamed from: a */
                public void mo27763a(InputStream inputStream, int i) throws IOException {
                    if (this.f8459a) {
                        this.f8459a = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append(i);
                }
            });
        } catch (IOException e) {
            f8452b.log(Level.WARNING, "read error", e);
        }
        sb.append("]]");
        return sb.toString();
    }
}
