package com.google.common.hash;

import com.google.common.base.Preconditions;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

abstract class AbstractNonStreamingHashFunction implements HashFunction {

    private final class BufferingHasher extends AbstractHasher {
        static final int BOTTOM_BYTE = 255;
        final ExposedByteArrayOutputStream stream;

        BufferingHasher(int i) {
            this.stream = new ExposedByteArrayOutputStream(i);
        }

        public Hasher putByte(byte b) {
            this.stream.write(b);
            return this;
        }

        public Hasher putBytes(byte[] bArr) {
            try {
                this.stream.write(bArr);
                return this;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public Hasher putBytes(byte[] bArr, int i, int i2) {
            this.stream.write(bArr, i, i2);
            return this;
        }

        public Hasher putShort(short s) {
            this.stream.write(s & 255);
            this.stream.write((s >>> 8) & BOTTOM_BYTE);
            return this;
        }

        public Hasher putInt(int i) {
            this.stream.write(i & BOTTOM_BYTE);
            this.stream.write((i >>> 8) & BOTTOM_BYTE);
            this.stream.write((i >>> 16) & BOTTOM_BYTE);
            this.stream.write((i >>> 24) & BOTTOM_BYTE);
            return this;
        }

        public Hasher putLong(long j) {
            for (int i = 0; i < 64; i += 8) {
                this.stream.write((byte) ((int) ((j >>> i) & 255)));
            }
            return this;
        }

        public Hasher putChar(char c) {
            this.stream.write(c & 255);
            this.stream.write((c >>> 8) & BOTTOM_BYTE);
            return this;
        }

        public <T> Hasher putObject(T t, Funnel<? super T> funnel) {
            funnel.funnel(t, this);
            return this;
        }

        public HashCode hash() {
            return AbstractNonStreamingHashFunction.this.hashBytes(this.stream.byteArray(), 0, this.stream.length());
        }
    }

    private static final class ExposedByteArrayOutputStream extends ByteArrayOutputStream {
        ExposedByteArrayOutputStream(int i) {
            super(i);
        }

        /* access modifiers changed from: 0000 */
        public byte[] byteArray() {
            return this.buf;
        }

        /* access modifiers changed from: 0000 */
        public int length() {
            return this.count;
        }
    }

    AbstractNonStreamingHashFunction() {
    }

    public Hasher newHasher() {
        return new BufferingHasher(32);
    }

    public Hasher newHasher(int i) {
        Preconditions.checkArgument(i >= 0);
        return new BufferingHasher(i);
    }

    public <T> HashCode hashObject(T t, Funnel<? super T> funnel) {
        return newHasher().putObject(t, funnel).hash();
    }

    public HashCode hashUnencodedChars(CharSequence charSequence) {
        int length = charSequence.length();
        Hasher newHasher = newHasher(length * 2);
        for (int i = 0; i < length; i++) {
            newHasher.putChar(charSequence.charAt(i));
        }
        return newHasher.hash();
    }

    public HashCode hashString(CharSequence charSequence, Charset charset) {
        try {
            return hashBytes(charSequence.toString().getBytes(charset.name()));
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public HashCode hashInt(int i) {
        return newHasher(4).putInt(i).hash();
    }

    public HashCode hashLong(long j) {
        return newHasher(8).putLong(j).hash();
    }

    public HashCode hashBytes(byte[] bArr) {
        return hashBytes(bArr, 0, bArr.length);
    }
}
