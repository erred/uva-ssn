package com.fasterxml.jackson.databind.util;

import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class ByteBufferBackedInputStream extends InputStream {

    /* renamed from: _b */
    protected final ByteBuffer f6157_b;

    public ByteBufferBackedInputStream(ByteBuffer byteBuffer) {
        this.f6157_b = byteBuffer;
    }

    public int available() {
        return this.f6157_b.remaining();
    }

    public int read() throws IOException {
        if (this.f6157_b.hasRemaining()) {
            return this.f6157_b.get() & UnsignedBytes.MAX_VALUE;
        }
        return -1;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (!this.f6157_b.hasRemaining()) {
            return -1;
        }
        int min = Math.min(i2, this.f6157_b.remaining());
        this.f6157_b.get(bArr, i, min);
        return min;
    }
}
