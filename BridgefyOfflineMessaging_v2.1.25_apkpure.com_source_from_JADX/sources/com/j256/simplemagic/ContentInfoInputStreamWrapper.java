package com.j256.simplemagic;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class ContentInfoInputStreamWrapper extends InputStream {
    private static ContentInfoUtil staticContentInfoUtil;
    private int byteCount;
    private final ContentInfoUtil contentInfoUtil;
    private final InputStream delegate;
    private final byte[] firstBytes;

    public ContentInfoInputStreamWrapper(InputStream inputStream, ContentInfoUtil contentInfoUtil2) {
        this.firstBytes = new byte[ContentInfoUtil.DEFAULT_READ_SIZE];
        this.delegate = inputStream;
        this.contentInfoUtil = contentInfoUtil2;
    }

    public ContentInfoInputStreamWrapper(InputStream inputStream) {
        this(inputStream, getStaticContentInfoUtil());
    }

    public ContentInfo findMatch() {
        byte[] bArr;
        if (this.byteCount < this.firstBytes.length) {
            bArr = Arrays.copyOf(this.firstBytes, this.byteCount);
        } else {
            bArr = this.firstBytes;
        }
        return this.contentInfoUtil.findMatch(bArr);
    }

    public int available() throws IOException {
        return this.delegate.available();
    }

    public int read() throws IOException {
        int read = this.delegate.read();
        if (this.byteCount < this.firstBytes.length) {
            byte[] bArr = this.firstBytes;
            int i = this.byteCount;
            this.byteCount = i + 1;
            bArr[i] = (byte) read;
        }
        return read;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.delegate.read(bArr, i, i2);
        int length = this.firstBytes.length - this.byteCount;
        if (length > read) {
            length = read;
        }
        for (int i3 = i; i3 < i + length; i3++) {
            byte[] bArr2 = this.firstBytes;
            int i4 = this.byteCount;
            this.byteCount = i4 + 1;
            bArr2[i4] = bArr[i3];
        }
        return read;
    }

    public long skip(long j) throws IOException {
        int length = this.firstBytes.length - this.byteCount;
        if (((long) length) > j) {
            length = (int) j;
        }
        int i = 0;
        if (length > 0) {
            i = read(this.firstBytes, this.byteCount, length);
            j -= (long) i;
        }
        if (j <= 0) {
            return (long) i;
        }
        return ((long) i) + this.delegate.skip(j);
    }

    public void close() throws IOException {
        this.delegate.close();
    }

    public void mark(int i) {
        this.delegate.mark(i);
    }

    public void reset() throws IOException {
        this.delegate.reset();
    }

    public boolean markSupported() {
        return this.delegate.markSupported();
    }

    private static synchronized ContentInfoUtil getStaticContentInfoUtil() {
        ContentInfoUtil contentInfoUtil2;
        synchronized (ContentInfoInputStreamWrapper.class) {
            if (staticContentInfoUtil == null) {
                staticContentInfoUtil = new ContentInfoUtil();
            }
            contentInfoUtil2 = staticContentInfoUtil;
        }
        return contentInfoUtil2;
    }
}
