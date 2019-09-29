package com.fasterxml.jackson.core.p116io;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

/* renamed from: com.fasterxml.jackson.core.io.UTF8Writer */
public final class UTF8Writer extends Writer {
    static final int SURR1_FIRST = 55296;
    static final int SURR1_LAST = 56319;
    static final int SURR2_FIRST = 56320;
    static final int SURR2_LAST = 57343;
    private final IOContext _context;
    private OutputStream _out;
    private byte[] _outBuffer;
    private final int _outBufferEnd = (this._outBuffer.length - 4);
    private int _outPtr = 0;
    private int _surrogate;

    public UTF8Writer(IOContext iOContext, OutputStream outputStream) {
        this._context = iOContext;
        this._out = outputStream;
        this._outBuffer = iOContext.allocWriteEncodingBuffer();
    }

    public Writer append(char c) throws IOException {
        write((int) c);
        return this;
    }

    public void close() throws IOException {
        if (this._out != null) {
            if (this._outPtr > 0) {
                this._out.write(this._outBuffer, 0, this._outPtr);
                this._outPtr = 0;
            }
            OutputStream outputStream = this._out;
            this._out = null;
            byte[] bArr = this._outBuffer;
            if (bArr != null) {
                this._outBuffer = null;
                this._context.releaseWriteEncodingBuffer(bArr);
            }
            outputStream.close();
            int i = this._surrogate;
            this._surrogate = 0;
            if (i > 0) {
                illegalSurrogate(i);
            }
        }
    }

    public void flush() throws IOException {
        if (this._out != null) {
            if (this._outPtr > 0) {
                this._out.write(this._outBuffer, 0, this._outPtr);
                this._outPtr = 0;
            }
            this._out.flush();
        }
    }

    public void write(char[] cArr) throws IOException {
        write(cArr, 0, cArr.length);
    }

    public void write(char[] cArr, int i, int i2) throws IOException {
        if (i2 < 2) {
            if (i2 == 1) {
                write((int) cArr[i]);
            }
            return;
        }
        if (this._surrogate > 0) {
            int i3 = i + 1;
            i2--;
            write(convertSurrogate(cArr[i]));
            i = i3;
        }
        int i4 = this._outPtr;
        byte[] bArr = this._outBuffer;
        int i5 = this._outBufferEnd;
        int i6 = i2 + r9;
        while (r9 < i6) {
            if (i4 >= i5) {
                this._out.write(bArr, 0, i4);
                i4 = 0;
            }
            int i7 = r9 + 1;
            char c = cArr[r9];
            if (c < 128) {
                int i8 = i4 + 1;
                bArr[i4] = (byte) c;
                int i9 = i6 - i7;
                int i10 = i5 - i8;
                if (i9 > i10) {
                    i9 = i10;
                }
                int i11 = i9 + i7;
                while (true) {
                    r9 = i7;
                    i4 = i8;
                    if (r9 >= i11) {
                        continue;
                        break;
                    }
                    i7 = r9 + 1;
                    c = cArr[r9];
                    if (c >= 128) {
                        break;
                    }
                    i8 = i4 + 1;
                    bArr[i4] = (byte) c;
                }
            }
            if (c < 2048) {
                int i12 = i4 + 1;
                bArr[i4] = (byte) ((c >> 6) | 192);
                i4 = i12 + 1;
                bArr[i12] = (byte) ((c & '?') | 128);
                r9 = i7;
            } else if (c < 55296 || c > 57343) {
                int i13 = i4 + 1;
                bArr[i4] = (byte) ((c >> 12) | 224);
                int i14 = i13 + 1;
                bArr[i13] = (byte) (((c >> 6) & 63) | 128);
                int i15 = i14 + 1;
                bArr[i14] = (byte) ((c & '?') | 128);
                r9 = i7;
                i4 = i15;
            } else {
                if (c > 56319) {
                    this._outPtr = i4;
                    illegalSurrogate(c);
                }
                this._surrogate = c;
                if (i7 >= i6) {
                    break;
                }
                r9 = i7 + 1;
                int convertSurrogate = convertSurrogate(cArr[i7]);
                if (convertSurrogate > 1114111) {
                    this._outPtr = i4;
                    illegalSurrogate(convertSurrogate);
                }
                int i16 = i4 + 1;
                bArr[i4] = (byte) ((convertSurrogate >> 18) | 240);
                int i17 = i16 + 1;
                bArr[i16] = (byte) (((convertSurrogate >> 12) & 63) | 128);
                int i18 = i17 + 1;
                bArr[i17] = (byte) (((convertSurrogate >> 6) & 63) | 128);
                i4 = i18 + 1;
                bArr[i18] = (byte) ((convertSurrogate & 63) | 128);
            }
        }
        this._outPtr = i4;
    }

    public void write(int i) throws IOException {
        int i2;
        if (this._surrogate > 0) {
            i = convertSurrogate(i);
        } else if (i >= 55296 && i <= 57343) {
            if (i > 56319) {
                illegalSurrogate(i);
            }
            this._surrogate = i;
            return;
        }
        if (this._outPtr >= this._outBufferEnd) {
            this._out.write(this._outBuffer, 0, this._outPtr);
            this._outPtr = 0;
        }
        if (i < 128) {
            byte[] bArr = this._outBuffer;
            int i3 = this._outPtr;
            this._outPtr = i3 + 1;
            bArr[i3] = (byte) i;
        } else {
            int i4 = this._outPtr;
            if (i < 2048) {
                int i5 = i4 + 1;
                this._outBuffer[i4] = (byte) ((i >> 6) | 192);
                i2 = i5 + 1;
                this._outBuffer[i5] = (byte) ((i & 63) | 128);
            } else if (i <= 65535) {
                int i6 = i4 + 1;
                this._outBuffer[i4] = (byte) ((i >> 12) | 224);
                int i7 = i6 + 1;
                this._outBuffer[i6] = (byte) (((i >> 6) & 63) | 128);
                int i8 = i7 + 1;
                this._outBuffer[i7] = (byte) ((i & 63) | 128);
                i2 = i8;
            } else {
                if (i > 1114111) {
                    illegalSurrogate(i);
                }
                int i9 = i4 + 1;
                this._outBuffer[i4] = (byte) ((i >> 18) | 240);
                int i10 = i9 + 1;
                this._outBuffer[i9] = (byte) (((i >> 12) & 63) | 128);
                int i11 = i10 + 1;
                this._outBuffer[i10] = (byte) (((i >> 6) & 63) | 128);
                i2 = i11 + 1;
                this._outBuffer[i11] = (byte) ((i & 63) | 128);
            }
            this._outPtr = i2;
        }
    }

    public void write(String str) throws IOException {
        write(str, 0, str.length());
    }

    public void write(String str, int i, int i2) throws IOException {
        if (i2 < 2) {
            if (i2 == 1) {
                write((int) str.charAt(i));
            }
            return;
        }
        if (this._surrogate > 0) {
            int i3 = i + 1;
            i2--;
            write(convertSurrogate(str.charAt(i)));
            i = i3;
        }
        int i4 = this._outPtr;
        byte[] bArr = this._outBuffer;
        int i5 = this._outBufferEnd;
        int i6 = i2 + r9;
        while (r9 < i6) {
            if (i4 >= i5) {
                this._out.write(bArr, 0, i4);
                i4 = 0;
            }
            int i7 = r9 + 1;
            char charAt = str.charAt(r9);
            if (charAt < 128) {
                int i8 = i4 + 1;
                bArr[i4] = (byte) charAt;
                int i9 = i6 - i7;
                int i10 = i5 - i8;
                if (i9 > i10) {
                    i9 = i10;
                }
                int i11 = i9 + i7;
                while (true) {
                    r9 = i7;
                    i4 = i8;
                    if (r9 >= i11) {
                        continue;
                        break;
                    }
                    i7 = r9 + 1;
                    charAt = str.charAt(r9);
                    if (charAt >= 128) {
                        break;
                    }
                    i8 = i4 + 1;
                    bArr[i4] = (byte) charAt;
                }
            }
            if (charAt < 2048) {
                int i12 = i4 + 1;
                bArr[i4] = (byte) ((charAt >> 6) | 192);
                i4 = i12 + 1;
                bArr[i12] = (byte) ((charAt & '?') | 128);
                r9 = i7;
            } else if (charAt < 55296 || charAt > 57343) {
                int i13 = i4 + 1;
                bArr[i4] = (byte) ((charAt >> 12) | 224);
                int i14 = i13 + 1;
                bArr[i13] = (byte) (((charAt >> 6) & 63) | 128);
                int i15 = i14 + 1;
                bArr[i14] = (byte) ((charAt & '?') | 128);
                r9 = i7;
                i4 = i15;
            } else {
                if (charAt > 56319) {
                    this._outPtr = i4;
                    illegalSurrogate(charAt);
                }
                this._surrogate = charAt;
                if (i7 >= i6) {
                    break;
                }
                r9 = i7 + 1;
                int convertSurrogate = convertSurrogate(str.charAt(i7));
                if (convertSurrogate > 1114111) {
                    this._outPtr = i4;
                    illegalSurrogate(convertSurrogate);
                }
                int i16 = i4 + 1;
                bArr[i4] = (byte) ((convertSurrogate >> 18) | 240);
                int i17 = i16 + 1;
                bArr[i16] = (byte) (((convertSurrogate >> 12) & 63) | 128);
                int i18 = i17 + 1;
                bArr[i17] = (byte) (((convertSurrogate >> 6) & 63) | 128);
                i4 = i18 + 1;
                bArr[i18] = (byte) ((convertSurrogate & 63) | 128);
            }
        }
        this._outPtr = i4;
    }

    /* access modifiers changed from: protected */
    public int convertSurrogate(int i) throws IOException {
        int i2 = this._surrogate;
        this._surrogate = 0;
        if (i >= 56320 && i <= 57343) {
            return ((i2 - 55296) << 10) + 65536 + (i - 56320);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Broken surrogate pair: first char 0x");
        sb.append(Integer.toHexString(i2));
        sb.append(", second 0x");
        sb.append(Integer.toHexString(i));
        sb.append("; illegal combination");
        throw new IOException(sb.toString());
    }

    protected static void illegalSurrogate(int i) throws IOException {
        throw new IOException(illegalSurrogateDesc(i));
    }

    protected static String illegalSurrogateDesc(int i) {
        if (i > 1114111) {
            StringBuilder sb = new StringBuilder();
            sb.append("Illegal character point (0x");
            sb.append(Integer.toHexString(i));
            sb.append(") to output; max is 0x10FFFF as per RFC 4627");
            return sb.toString();
        } else if (i < 55296) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Illegal character point (0x");
            sb2.append(Integer.toHexString(i));
            sb2.append(") to output");
            return sb2.toString();
        } else if (i <= 56319) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Unmatched first part of surrogate pair (0x");
            sb3.append(Integer.toHexString(i));
            sb3.append(")");
            return sb3.toString();
        } else {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Unmatched second part of surrogate pair (0x");
            sb4.append(Integer.toHexString(i));
            sb4.append(")");
            return sb4.toString();
        }
    }
}
