package com.fasterxml.jackson.core.p116io;

import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.fasterxml.jackson.core.io.MergedStream */
public final class MergedStream extends InputStream {

    /* renamed from: _b */
    private byte[] f6139_b;
    private final IOContext _ctxt;
    private final int _end;
    private final InputStream _in;
    private int _ptr;

    public MergedStream(IOContext iOContext, InputStream inputStream, byte[] bArr, int i, int i2) {
        this._ctxt = iOContext;
        this._in = inputStream;
        this.f6139_b = bArr;
        this._ptr = i;
        this._end = i2;
    }

    public int available() throws IOException {
        if (this.f6139_b != null) {
            return this._end - this._ptr;
        }
        return this._in.available();
    }

    public void close() throws IOException {
        _free();
        this._in.close();
    }

    public void mark(int i) {
        if (this.f6139_b == null) {
            this._in.mark(i);
        }
    }

    public boolean markSupported() {
        return this.f6139_b == null && this._in.markSupported();
    }

    public int read() throws IOException {
        if (this.f6139_b == null) {
            return this._in.read();
        }
        byte[] bArr = this.f6139_b;
        int i = this._ptr;
        this._ptr = i + 1;
        byte b = bArr[i] & UnsignedBytes.MAX_VALUE;
        if (this._ptr >= this._end) {
            _free();
        }
        return b;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.f6139_b == null) {
            return this._in.read(bArr, i, i2);
        }
        int i3 = this._end - this._ptr;
        if (i2 > i3) {
            i2 = i3;
        }
        System.arraycopy(this.f6139_b, this._ptr, bArr, i, i2);
        this._ptr += i2;
        if (this._ptr >= this._end) {
            _free();
        }
        return i2;
    }

    public void reset() throws IOException {
        if (this.f6139_b == null) {
            this._in.reset();
        }
    }

    public long skip(long j) throws IOException {
        long j2;
        if (this.f6139_b != null) {
            long j3 = (long) (this._end - this._ptr);
            if (j3 > j) {
                this._ptr += (int) j;
                return j;
            }
            _free();
            j2 = j3 + 0;
            j -= j3;
        } else {
            j2 = 0;
        }
        if (j > 0) {
            j2 += this._in.skip(j);
        }
        return j2;
    }

    private void _free() {
        byte[] bArr = this.f6139_b;
        if (bArr != null) {
            this.f6139_b = null;
            if (this._ctxt != null) {
                this._ctxt.releaseReadIOBuffer(bArr);
            }
        }
    }
}
