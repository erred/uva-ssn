package com.google.common.p126io;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

/* renamed from: com.google.common.io.MultiInputStream */
final class MultiInputStream extends InputStream {

    /* renamed from: in */
    private InputStream f6786in;

    /* renamed from: it */
    private Iterator<? extends ByteSource> f6787it;

    public boolean markSupported() {
        return false;
    }

    public MultiInputStream(Iterator<? extends ByteSource> it) throws IOException {
        this.f6787it = (Iterator) Preconditions.checkNotNull(it);
        advance();
    }

    public void close() throws IOException {
        if (this.f6786in != null) {
            try {
                this.f6786in.close();
            } finally {
                this.f6786in = null;
            }
        }
    }

    private void advance() throws IOException {
        close();
        if (this.f6787it.hasNext()) {
            this.f6786in = ((ByteSource) this.f6787it.next()).openStream();
        }
    }

    public int available() throws IOException {
        if (this.f6786in == null) {
            return 0;
        }
        return this.f6786in.available();
    }

    public int read() throws IOException {
        if (this.f6786in == null) {
            return -1;
        }
        int read = this.f6786in.read();
        if (read != -1) {
            return read;
        }
        advance();
        return read();
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.f6786in == null) {
            return -1;
        }
        int read = this.f6786in.read(bArr, i, i2);
        if (read != -1) {
            return read;
        }
        advance();
        return read(bArr, i, i2);
    }

    public long skip(long j) throws IOException {
        if (this.f6786in == null || j <= 0) {
            return 0;
        }
        long skip = this.f6786in.skip(j);
        if (skip != 0) {
            return skip;
        }
        if (read() == -1) {
            return 0;
        }
        return this.f6786in.skip(j - 1) + 1;
    }
}
