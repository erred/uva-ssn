package com.fasterxml.jackson.core.p116io;

import com.fasterxml.jackson.core.base.GeneratorBase;
import com.google.common.primitives.UnsignedBytes;
import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/* renamed from: com.fasterxml.jackson.core.io.UTF32Reader */
public class UTF32Reader extends Reader {
    protected static final int LAST_VALID_UNICODE_CHAR = 1114111;

    /* renamed from: NC */
    protected static final char f6140NC = 0;
    protected final boolean _bigEndian;
    protected byte[] _buffer;
    protected int _byteCount;
    protected int _charCount;
    protected final IOContext _context;
    protected InputStream _in;
    protected int _length;
    protected final boolean _managedBuffers;
    protected int _ptr;
    protected char _surrogate = 0;
    protected char[] _tmpBuf;

    public UTF32Reader(IOContext iOContext, InputStream inputStream, byte[] bArr, int i, int i2, boolean z) {
        boolean z2 = false;
        this._context = iOContext;
        this._in = inputStream;
        this._buffer = bArr;
        this._ptr = i;
        this._length = i2;
        this._bigEndian = z;
        if (inputStream != null) {
            z2 = true;
        }
        this._managedBuffers = z2;
    }

    public void close() throws IOException {
        InputStream inputStream = this._in;
        if (inputStream != null) {
            this._in = null;
            freeBuffers();
            inputStream.close();
        }
    }

    public int read() throws IOException {
        if (this._tmpBuf == null) {
            this._tmpBuf = new char[1];
        }
        if (read(this._tmpBuf, 0, 1) < 1) {
            return -1;
        }
        return this._tmpBuf[0];
    }

    public int read(char[] cArr, int i, int i2) throws IOException {
        int i3;
        int i4;
        byte b;
        byte b2;
        if (this._buffer == null) {
            return -1;
        }
        if (i2 < 1) {
            return i2;
        }
        if (i < 0 || i + i2 > cArr.length) {
            reportBounds(cArr, i, i2);
        }
        int i5 = i2 + i;
        if (this._surrogate != 0) {
            i3 = i + 1;
            cArr[i] = this._surrogate;
            this._surrogate = 0;
        } else {
            int i6 = this._length - this._ptr;
            if (i6 < 4 && !loadMore(i6)) {
                if (i6 == 0) {
                    return -1;
                }
                reportUnexpectedEOF(this._length - this._ptr, 4);
            }
            i3 = i;
        }
        int i7 = this._length - 3;
        while (true) {
            if (i3 >= i5) {
                i4 = i3;
                break;
            }
            int i8 = this._ptr;
            if (this._bigEndian) {
                byte b3 = (this._buffer[i8] << 8) | (this._buffer[i8 + 1] & UnsignedBytes.MAX_VALUE);
                b = (this._buffer[i8 + 3] & UnsignedBytes.MAX_VALUE) | ((this._buffer[i8 + 2] & UnsignedBytes.MAX_VALUE) << 8);
                b2 = b3;
            } else {
                b = (this._buffer[i8] & UnsignedBytes.MAX_VALUE) | ((this._buffer[i8 + 1] & UnsignedBytes.MAX_VALUE) << 8);
                b2 = (this._buffer[i8 + 3] << 8) | (this._buffer[i8 + 2] & UnsignedBytes.MAX_VALUE);
            }
            this._ptr += 4;
            if (b2 != 0) {
                byte b4 = b2 & UnsignedBytes.MAX_VALUE;
                byte b5 = b | ((b4 - 1) << 16);
                if (b4 > 16) {
                    reportInvalid(b5, i3 - i, String.format(" (above 0x%08x)", new Object[]{Integer.valueOf(LAST_VALID_UNICODE_CHAR)}));
                }
                i4 = i3 + 1;
                cArr[i3] = (char) ((b5 >> 10) + GeneratorBase.SURR1_FIRST);
                byte b6 = 56320 | (b5 & UnsignedBytes.MAX_VALUE);
                if (i4 >= i5) {
                    this._surrogate = (char) b5;
                    break;
                }
                b = b6;
                i3 = i4;
            }
            i4 = i3 + 1;
            cArr[i3] = (char) b;
            if (this._ptr > i7) {
                break;
            }
            i3 = i4;
        }
        int i9 = i4 - i;
        this._charCount += i9;
        return i9;
    }

    private void reportUnexpectedEOF(int i, int i2) throws IOException {
        int i3 = this._byteCount + i;
        int i4 = this._charCount;
        StringBuilder sb = new StringBuilder();
        sb.append("Unexpected EOF in the middle of a 4-byte UTF-32 char: got ");
        sb.append(i);
        sb.append(", needed ");
        sb.append(i2);
        sb.append(", at char #");
        sb.append(i4);
        sb.append(", byte #");
        sb.append(i3);
        sb.append(")");
        throw new CharConversionException(sb.toString());
    }

    private void reportInvalid(int i, int i2, String str) throws IOException {
        int i3 = (this._byteCount + this._ptr) - 1;
        int i4 = this._charCount + i2;
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid UTF-32 character 0x");
        sb.append(Integer.toHexString(i));
        sb.append(str);
        sb.append(" at char #");
        sb.append(i4);
        sb.append(", byte #");
        sb.append(i3);
        sb.append(")");
        throw new CharConversionException(sb.toString());
    }

    private boolean loadMore(int i) throws IOException {
        this._byteCount += this._length - i;
        if (i > 0) {
            if (this._ptr > 0) {
                System.arraycopy(this._buffer, this._ptr, this._buffer, 0, i);
                this._ptr = 0;
            }
            this._length = i;
        } else {
            this._ptr = 0;
            int read = this._in == null ? -1 : this._in.read(this._buffer);
            if (read < 1) {
                this._length = 0;
                if (read < 0) {
                    if (this._managedBuffers) {
                        freeBuffers();
                    }
                    return false;
                }
                reportStrangeStream();
            }
            this._length = read;
        }
        while (this._length < 4) {
            int read2 = this._in == null ? -1 : this._in.read(this._buffer, this._length, this._buffer.length - this._length);
            if (read2 < 1) {
                if (read2 < 0) {
                    if (this._managedBuffers) {
                        freeBuffers();
                    }
                    reportUnexpectedEOF(this._length, 4);
                }
                reportStrangeStream();
            }
            this._length += read2;
        }
        return true;
    }

    private void freeBuffers() {
        byte[] bArr = this._buffer;
        if (bArr != null) {
            this._buffer = null;
            this._context.releaseReadIOBuffer(bArr);
        }
    }

    private void reportBounds(char[] cArr, int i, int i2) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("read(buf,");
        sb.append(i);
        sb.append(",");
        sb.append(i2);
        sb.append("), cbuf[");
        sb.append(cArr.length);
        sb.append("]");
        throw new ArrayIndexOutOfBoundsException(sb.toString());
    }

    private void reportStrangeStream() throws IOException {
        throw new IOException("Strange I/O stream, returned 0 bytes on read");
    }
}
