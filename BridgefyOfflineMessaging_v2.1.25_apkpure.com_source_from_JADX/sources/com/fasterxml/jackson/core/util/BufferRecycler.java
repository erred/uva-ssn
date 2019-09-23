package com.fasterxml.jackson.core.util;

import com.google.android.gms.auth.api.credentials.CredentialsApi;

public class BufferRecycler {
    public static final int BYTE_BASE64_CODEC_BUFFER = 3;
    private static final int[] BYTE_BUFFER_LENGTHS = {8000, 8000, CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE, CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE};
    public static final int BYTE_READ_IO_BUFFER = 0;
    public static final int BYTE_WRITE_CONCAT_BUFFER = 2;
    public static final int BYTE_WRITE_ENCODING_BUFFER = 1;
    private static final int[] CHAR_BUFFER_LENGTHS = {4000, 4000, 200, 200};
    public static final int CHAR_CONCAT_BUFFER = 1;
    public static final int CHAR_NAME_COPY_BUFFER = 3;
    public static final int CHAR_TEXT_BUFFER = 2;
    public static final int CHAR_TOKEN_BUFFER = 0;
    protected final byte[][] _byteBuffers;
    protected final char[][] _charBuffers;

    public BufferRecycler() {
        this(4, 4);
    }

    protected BufferRecycler(int i, int i2) {
        this._byteBuffers = new byte[i][];
        this._charBuffers = new char[i2][];
    }

    public final byte[] allocByteBuffer(int i) {
        return allocByteBuffer(i, 0);
    }

    public byte[] allocByteBuffer(int i, int i2) {
        int byteBufferLength = byteBufferLength(i);
        if (i2 < byteBufferLength) {
            i2 = byteBufferLength;
        }
        byte[] bArr = this._byteBuffers[i];
        if (bArr == null || bArr.length < i2) {
            return balloc(i2);
        }
        this._byteBuffers[i] = null;
        return bArr;
    }

    public final void releaseByteBuffer(int i, byte[] bArr) {
        this._byteBuffers[i] = bArr;
    }

    public final char[] allocCharBuffer(int i) {
        return allocCharBuffer(i, 0);
    }

    public char[] allocCharBuffer(int i, int i2) {
        int charBufferLength = charBufferLength(i);
        if (i2 < charBufferLength) {
            i2 = charBufferLength;
        }
        char[] cArr = this._charBuffers[i];
        if (cArr == null || cArr.length < i2) {
            return calloc(i2);
        }
        this._charBuffers[i] = null;
        return cArr;
    }

    public void releaseCharBuffer(int i, char[] cArr) {
        this._charBuffers[i] = cArr;
    }

    /* access modifiers changed from: protected */
    public int byteBufferLength(int i) {
        return BYTE_BUFFER_LENGTHS[i];
    }

    /* access modifiers changed from: protected */
    public int charBufferLength(int i) {
        return CHAR_BUFFER_LENGTHS[i];
    }

    /* access modifiers changed from: protected */
    public byte[] balloc(int i) {
        return new byte[i];
    }

    /* access modifiers changed from: protected */
    public char[] calloc(int i) {
        return new char[i];
    }
}
