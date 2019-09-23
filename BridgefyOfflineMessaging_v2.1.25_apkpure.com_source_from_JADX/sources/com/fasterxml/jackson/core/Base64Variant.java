package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.io.Serializable;
import java.util.Arrays;

public final class Base64Variant implements Serializable {
    public static final int BASE64_VALUE_INVALID = -1;
    public static final int BASE64_VALUE_PADDING = -2;
    private static final int INT_SPACE = 32;
    static final char PADDING_CHAR_NONE = '\u0000';
    private static final long serialVersionUID = 1;
    private final transient int[] _asciiToBase64;
    private final transient byte[] _base64ToAsciiB;
    private final transient char[] _base64ToAsciiC;
    private final transient int _maxLineLength;
    final String _name;
    private final transient char _paddingChar;
    private final transient boolean _usesPadding;

    public boolean equals(Object obj) {
        return obj == this;
    }

    public Base64Variant(String str, String str2, boolean z, char c, int i) {
        this._asciiToBase64 = new int[128];
        this._base64ToAsciiC = new char[64];
        this._base64ToAsciiB = new byte[64];
        this._name = str;
        this._usesPadding = z;
        this._paddingChar = c;
        this._maxLineLength = i;
        int length = str2.length();
        if (length == 64) {
            str2.getChars(0, length, this._base64ToAsciiC, 0);
            Arrays.fill(this._asciiToBase64, -1);
            for (int i2 = 0; i2 < length; i2++) {
                char c2 = this._base64ToAsciiC[i2];
                this._base64ToAsciiB[i2] = (byte) c2;
                this._asciiToBase64[c2] = i2;
            }
            if (z) {
                this._asciiToBase64[c] = -2;
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Base64Alphabet length must be exactly 64 (was ");
        sb.append(length);
        sb.append(")");
        throw new IllegalArgumentException(sb.toString());
    }

    public Base64Variant(Base64Variant base64Variant, String str, int i) {
        this(base64Variant, str, base64Variant._usesPadding, base64Variant._paddingChar, i);
    }

    public Base64Variant(Base64Variant base64Variant, String str, boolean z, char c, int i) {
        this._asciiToBase64 = new int[128];
        this._base64ToAsciiC = new char[64];
        this._base64ToAsciiB = new byte[64];
        this._name = str;
        byte[] bArr = base64Variant._base64ToAsciiB;
        System.arraycopy(bArr, 0, this._base64ToAsciiB, 0, bArr.length);
        char[] cArr = base64Variant._base64ToAsciiC;
        System.arraycopy(cArr, 0, this._base64ToAsciiC, 0, cArr.length);
        int[] iArr = base64Variant._asciiToBase64;
        System.arraycopy(iArr, 0, this._asciiToBase64, 0, iArr.length);
        this._usesPadding = z;
        this._paddingChar = c;
        this._maxLineLength = i;
    }

    /* access modifiers changed from: protected */
    public Object readResolve() {
        return Base64Variants.valueOf(this._name);
    }

    public String getName() {
        return this._name;
    }

    public boolean usesPadding() {
        return this._usesPadding;
    }

    public boolean usesPaddingChar(char c) {
        return c == this._paddingChar;
    }

    public boolean usesPaddingChar(int i) {
        return i == this._paddingChar;
    }

    public char getPaddingChar() {
        return this._paddingChar;
    }

    public byte getPaddingByte() {
        return (byte) this._paddingChar;
    }

    public int getMaxLineLength() {
        return this._maxLineLength;
    }

    public int decodeBase64Char(char c) {
        if (c <= 127) {
            return this._asciiToBase64[c];
        }
        return -1;
    }

    public int decodeBase64Char(int i) {
        if (i <= 127) {
            return this._asciiToBase64[i];
        }
        return -1;
    }

    public int decodeBase64Byte(byte b) {
        if (b < 0) {
            return -1;
        }
        return this._asciiToBase64[b];
    }

    public char encodeBase64BitsAsChar(int i) {
        return this._base64ToAsciiC[i];
    }

    public int encodeBase64Chunk(int i, char[] cArr, int i2) {
        int i3 = i2 + 1;
        cArr[i2] = this._base64ToAsciiC[(i >> 18) & 63];
        int i4 = i3 + 1;
        cArr[i3] = this._base64ToAsciiC[(i >> 12) & 63];
        int i5 = i4 + 1;
        cArr[i4] = this._base64ToAsciiC[(i >> 6) & 63];
        int i6 = i5 + 1;
        cArr[i5] = this._base64ToAsciiC[i & 63];
        return i6;
    }

    public void encodeBase64Chunk(StringBuilder sb, int i) {
        sb.append(this._base64ToAsciiC[(i >> 18) & 63]);
        sb.append(this._base64ToAsciiC[(i >> 12) & 63]);
        sb.append(this._base64ToAsciiC[(i >> 6) & 63]);
        sb.append(this._base64ToAsciiC[i & 63]);
    }

    public int encodeBase64Partial(int i, int i2, char[] cArr, int i3) {
        int i4 = i3 + 1;
        cArr[i3] = this._base64ToAsciiC[(i >> 18) & 63];
        int i5 = i4 + 1;
        cArr[i4] = this._base64ToAsciiC[(i >> 12) & 63];
        if (this._usesPadding) {
            int i6 = i5 + 1;
            cArr[i5] = i2 == 2 ? this._base64ToAsciiC[(i >> 6) & 63] : this._paddingChar;
            int i7 = i6 + 1;
            cArr[i6] = this._paddingChar;
            return i7;
        } else if (i2 != 2) {
            return i5;
        } else {
            int i8 = i5 + 1;
            cArr[i5] = this._base64ToAsciiC[(i >> 6) & 63];
            return i8;
        }
    }

    public void encodeBase64Partial(StringBuilder sb, int i, int i2) {
        sb.append(this._base64ToAsciiC[(i >> 18) & 63]);
        sb.append(this._base64ToAsciiC[(i >> 12) & 63]);
        if (this._usesPadding) {
            sb.append(i2 == 2 ? this._base64ToAsciiC[(i >> 6) & 63] : this._paddingChar);
            sb.append(this._paddingChar);
        } else if (i2 == 2) {
            sb.append(this._base64ToAsciiC[(i >> 6) & 63]);
        }
    }

    public byte encodeBase64BitsAsByte(int i) {
        return this._base64ToAsciiB[i];
    }

    public int encodeBase64Chunk(int i, byte[] bArr, int i2) {
        int i3 = i2 + 1;
        bArr[i2] = this._base64ToAsciiB[(i >> 18) & 63];
        int i4 = i3 + 1;
        bArr[i3] = this._base64ToAsciiB[(i >> 12) & 63];
        int i5 = i4 + 1;
        bArr[i4] = this._base64ToAsciiB[(i >> 6) & 63];
        int i6 = i5 + 1;
        bArr[i5] = this._base64ToAsciiB[i & 63];
        return i6;
    }

    public int encodeBase64Partial(int i, int i2, byte[] bArr, int i3) {
        int i4 = i3 + 1;
        bArr[i3] = this._base64ToAsciiB[(i >> 18) & 63];
        int i5 = i4 + 1;
        bArr[i4] = this._base64ToAsciiB[(i >> 12) & 63];
        if (this._usesPadding) {
            byte b = (byte) this._paddingChar;
            int i6 = i5 + 1;
            bArr[i5] = i2 == 2 ? this._base64ToAsciiB[(i >> 6) & 63] : b;
            int i7 = i6 + 1;
            bArr[i6] = b;
            return i7;
        } else if (i2 != 2) {
            return i5;
        } else {
            int i8 = i5 + 1;
            bArr[i5] = this._base64ToAsciiB[(i >> 6) & 63];
            return i8;
        }
    }

    public String encode(byte[] bArr) {
        return encode(bArr, false);
    }

    public String encode(byte[] bArr, boolean z) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder((length >> 2) + length + (length >> 3));
        if (z) {
            sb.append('\"');
        }
        int maxLineLength = getMaxLineLength() >> 2;
        int i = 0;
        int i2 = length - 3;
        while (i <= i2) {
            int i3 = i + 1;
            int i4 = i3 + 1;
            int i5 = i4 + 1;
            encodeBase64Chunk(sb, (((bArr[i] << 8) | (bArr[i3] & UnsignedBytes.MAX_VALUE)) << 8) | (bArr[i4] & UnsignedBytes.MAX_VALUE));
            maxLineLength--;
            if (maxLineLength <= 0) {
                sb.append('\\');
                sb.append('n');
                maxLineLength = getMaxLineLength() >> 2;
            }
            i = i5;
        }
        int i6 = length - i;
        if (i6 > 0) {
            int i7 = i + 1;
            int i8 = bArr[i] << Ascii.DLE;
            if (i6 == 2) {
                i8 |= (bArr[i7] & UnsignedBytes.MAX_VALUE) << 8;
            }
            encodeBase64Partial(sb, i8, i6);
        }
        if (z) {
            sb.append('\"');
        }
        return sb.toString();
    }

    public byte[] decode(String str) throws IllegalArgumentException {
        ByteArrayBuilder byteArrayBuilder = new ByteArrayBuilder();
        decode(str, byteArrayBuilder);
        return byteArrayBuilder.toByteArray();
    }

    public void decode(String str, ByteArrayBuilder byteArrayBuilder) throws IllegalArgumentException {
        int i;
        char charAt;
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            while (true) {
                i = i2 + 1;
                charAt = str.charAt(i2);
                if (i >= length || charAt > ' ') {
                    int decodeBase64Char = decodeBase64Char(charAt);
                } else {
                    i2 = i;
                }
            }
            int decodeBase64Char2 = decodeBase64Char(charAt);
            if (decodeBase64Char2 < 0) {
                _reportInvalidBase64(charAt, 0, null);
            }
            if (i >= length) {
                _reportBase64EOF();
            }
            int i3 = i + 1;
            char charAt2 = str.charAt(i);
            int decodeBase64Char3 = decodeBase64Char(charAt2);
            if (decodeBase64Char3 < 0) {
                _reportInvalidBase64(charAt2, 1, null);
            }
            int i4 = (decodeBase64Char2 << 6) | decodeBase64Char3;
            if (i3 >= length) {
                if (!usesPadding()) {
                    byteArrayBuilder.append(i4 >> 4);
                    return;
                }
                _reportBase64EOF();
            }
            int i5 = i3 + 1;
            char charAt3 = str.charAt(i3);
            int decodeBase64Char4 = decodeBase64Char(charAt3);
            if (decodeBase64Char4 < 0) {
                if (decodeBase64Char4 != -2) {
                    _reportInvalidBase64(charAt3, 2, null);
                }
                if (i5 >= length) {
                    _reportBase64EOF();
                }
                i2 = i5 + 1;
                char charAt4 = str.charAt(i5);
                if (!usesPaddingChar(charAt4)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("expected padding character '");
                    sb.append(getPaddingChar());
                    sb.append("'");
                    _reportInvalidBase64(charAt4, 3, sb.toString());
                }
                byteArrayBuilder.append(i4 >> 4);
            } else {
                int i6 = (i4 << 6) | decodeBase64Char4;
                if (i5 >= length) {
                    if (!usesPadding()) {
                        byteArrayBuilder.appendTwoBytes(i6 >> 2);
                        return;
                    }
                    _reportBase64EOF();
                }
                int i7 = i5 + 1;
                char charAt5 = str.charAt(i5);
                int decodeBase64Char5 = decodeBase64Char(charAt5);
                if (decodeBase64Char5 < 0) {
                    if (decodeBase64Char5 != -2) {
                        _reportInvalidBase64(charAt5, 3, null);
                    }
                    byteArrayBuilder.appendTwoBytes(i6 >> 2);
                } else {
                    byteArrayBuilder.appendThreeBytes((i6 << 6) | decodeBase64Char5);
                }
                i2 = i7;
            }
        }
    }

    public String toString() {
        return this._name;
    }

    public int hashCode() {
        return this._name.hashCode();
    }

    /* access modifiers changed from: protected */
    public void _reportInvalidBase64(char c, int i, String str) throws IllegalArgumentException {
        String str2;
        if (c <= ' ') {
            StringBuilder sb = new StringBuilder();
            sb.append("Illegal white space character (code 0x");
            sb.append(Integer.toHexString(c));
            sb.append(") as character #");
            sb.append(i + 1);
            sb.append(" of 4-char base64 unit: can only used between units");
            str2 = sb.toString();
        } else if (usesPaddingChar(c)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unexpected padding character ('");
            sb2.append(getPaddingChar());
            sb2.append("') as character #");
            sb2.append(i + 1);
            sb2.append(" of 4-char base64 unit: padding only legal as 3rd or 4th character");
            str2 = sb2.toString();
        } else if (!Character.isDefined(c) || Character.isISOControl(c)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Illegal character (code 0x");
            sb3.append(Integer.toHexString(c));
            sb3.append(") in base64 content");
            str2 = sb3.toString();
        } else {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Illegal character '");
            sb4.append(c);
            sb4.append("' (code 0x");
            sb4.append(Integer.toHexString(c));
            sb4.append(") in base64 content");
            str2 = sb4.toString();
        }
        if (str != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str2);
            sb5.append(": ");
            sb5.append(str);
            str2 = sb5.toString();
        }
        throw new IllegalArgumentException(str2);
    }

    /* access modifiers changed from: protected */
    public void _reportBase64EOF() throws IllegalArgumentException {
        throw new IllegalArgumentException("Unexpected end-of-String in base64 content");
    }
}
