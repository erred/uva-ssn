package com.google.common.p126io;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.common.annotations.Beta;
import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.hash.Funnels;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;

/* renamed from: com.google.common.io.ByteSource */
public abstract class ByteSource implements InputSupplier<InputStream> {
    private static final int BUF_SIZE = 4096;
    private static final byte[] countBuffer = new byte[BUF_SIZE];

    /* renamed from: com.google.common.io.ByteSource$AsCharSource */
    private final class AsCharSource extends CharSource {
        private final Charset charset;

        private AsCharSource(Charset charset2) {
            this.charset = (Charset) Preconditions.checkNotNull(charset2);
        }

        public Reader openStream() throws IOException {
            return new InputStreamReader(ByteSource.this.openStream(), this.charset);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(ByteSource.this.toString());
            sb.append(".asCharSource(");
            sb.append(this.charset);
            sb.append(")");
            return sb.toString();
        }
    }

    /* renamed from: com.google.common.io.ByteSource$ByteArrayByteSource */
    private static class ByteArrayByteSource extends ByteSource {
        protected final byte[] bytes;

        public /* bridge */ /* synthetic */ Object getInput() throws IOException {
            return ByteSource.super.getInput();
        }

        protected ByteArrayByteSource(byte[] bArr) {
            this.bytes = (byte[]) Preconditions.checkNotNull(bArr);
        }

        public InputStream openStream() {
            return new ByteArrayInputStream(this.bytes);
        }

        public InputStream openBufferedStream() throws IOException {
            return openStream();
        }

        public boolean isEmpty() {
            return this.bytes.length == 0;
        }

        public long size() {
            return (long) this.bytes.length;
        }

        public byte[] read() {
            return (byte[]) this.bytes.clone();
        }

        public long copyTo(OutputStream outputStream) throws IOException {
            outputStream.write(this.bytes);
            return (long) this.bytes.length;
        }

        public <T> T read(ByteProcessor<T> byteProcessor) throws IOException {
            byteProcessor.processBytes(this.bytes, 0, this.bytes.length);
            return byteProcessor.getResult();
        }

        public HashCode hash(HashFunction hashFunction) throws IOException {
            return hashFunction.hashBytes(this.bytes);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ByteSource.wrap(");
            sb.append(Ascii.truncate(BaseEncoding.base16().encode(this.bytes), 30, "..."));
            sb.append(")");
            return sb.toString();
        }
    }

    /* renamed from: com.google.common.io.ByteSource$ConcatenatedByteSource */
    private static final class ConcatenatedByteSource extends ByteSource {
        private final Iterable<? extends ByteSource> sources;

        public /* bridge */ /* synthetic */ Object getInput() throws IOException {
            return ByteSource.super.getInput();
        }

        ConcatenatedByteSource(Iterable<? extends ByteSource> iterable) {
            this.sources = (Iterable) Preconditions.checkNotNull(iterable);
        }

        public InputStream openStream() throws IOException {
            return new MultiInputStream(this.sources.iterator());
        }

        public boolean isEmpty() throws IOException {
            for (ByteSource isEmpty : this.sources) {
                if (!isEmpty.isEmpty()) {
                    return false;
                }
            }
            return true;
        }

        public long size() throws IOException {
            long j = 0;
            for (ByteSource size : this.sources) {
                j += size.size();
            }
            return j;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ByteSource.concat(");
            sb.append(this.sources);
            sb.append(")");
            return sb.toString();
        }
    }

    /* renamed from: com.google.common.io.ByteSource$EmptyByteSource */
    private static final class EmptyByteSource extends ByteArrayByteSource {
        /* access modifiers changed from: private */
        public static final EmptyByteSource INSTANCE = new EmptyByteSource();

        public String toString() {
            return "ByteSource.empty()";
        }

        private EmptyByteSource() {
            super(new byte[0]);
        }

        public CharSource asCharSource(Charset charset) {
            Preconditions.checkNotNull(charset);
            return CharSource.empty();
        }

        public byte[] read() {
            return this.bytes;
        }
    }

    /* renamed from: com.google.common.io.ByteSource$SlicedByteSource */
    private final class SlicedByteSource extends ByteSource {
        private final long length;
        private final long offset;

        public /* bridge */ /* synthetic */ Object getInput() throws IOException {
            return ByteSource.super.getInput();
        }

        private SlicedByteSource(long j, long j2) {
            Preconditions.checkArgument(j >= 0, "offset (%s) may not be negative", Long.valueOf(j));
            Preconditions.checkArgument(j2 >= 0, "length (%s) may not be negative", Long.valueOf(j2));
            this.offset = j;
            this.length = j2;
        }

        public InputStream openStream() throws IOException {
            return sliceStream(ByteSource.this.openStream());
        }

        public InputStream openBufferedStream() throws IOException {
            return sliceStream(ByteSource.this.openBufferedStream());
        }

        private InputStream sliceStream(InputStream inputStream) throws IOException {
            Closer create;
            if (this.offset > 0) {
                try {
                    ByteStreams.skipFully(inputStream, this.offset);
                } catch (Throwable th) {
                    create.close();
                    throw th;
                }
            }
            return ByteStreams.limit(inputStream, this.length);
        }

        public ByteSource slice(long j, long j2) {
            Preconditions.checkArgument(j >= 0, "offset (%s) may not be negative", Long.valueOf(j));
            Preconditions.checkArgument(j2 >= 0, "length (%s) may not be negative", Long.valueOf(j2));
            return ByteSource.this.slice(this.offset + j, Math.min(j2, this.length - j));
        }

        public boolean isEmpty() throws IOException {
            return this.length == 0 || ByteSource.super.isEmpty();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(ByteSource.this.toString());
            sb.append(".slice(");
            sb.append(this.offset);
            sb.append(", ");
            sb.append(this.length);
            sb.append(")");
            return sb.toString();
        }
    }

    public abstract InputStream openStream() throws IOException;

    protected ByteSource() {
    }

    public CharSource asCharSource(Charset charset) {
        return new AsCharSource(charset);
    }

    @Deprecated
    public final InputStream getInput() throws IOException {
        return openStream();
    }

    public InputStream openBufferedStream() throws IOException {
        InputStream openStream = openStream();
        return openStream instanceof BufferedInputStream ? (BufferedInputStream) openStream : new BufferedInputStream(openStream);
    }

    public ByteSource slice(long j, long j2) {
        SlicedByteSource slicedByteSource = new SlicedByteSource(j, j2);
        return slicedByteSource;
    }

    public boolean isEmpty() throws IOException {
        Closer create = Closer.create();
        try {
            boolean z = ((InputStream) create.register(openStream())).read() == -1;
            create.close();
            return z;
        } catch (Throwable th) {
            create.close();
            throw th;
        }
    }

    public long size() throws IOException {
        Closer create;
        Closer create2 = Closer.create();
        try {
            long countBySkipping = countBySkipping((InputStream) create2.register(openStream()));
            create2.close();
            return countBySkipping;
        } catch (IOException unused) {
            create2.close();
            create = Closer.create();
            long countByReading = countByReading((InputStream) create.register(openStream()));
            create.close();
            return countByReading;
        } catch (Throwable th) {
            try {
                throw create.rethrow(th);
            } catch (Throwable th2) {
                create.close();
                throw th2;
            }
        }
    }

    private long countBySkipping(InputStream inputStream) throws IOException {
        long j = 0;
        while (true) {
            long skip = inputStream.skip((long) Math.min(inputStream.available(), BaseClientBuilder.API_PRIORITY_OTHER));
            if (skip > 0) {
                j += skip;
            } else if (inputStream.read() == -1) {
                return j;
            } else {
                if (j == 0 && inputStream.available() == 0) {
                    throw new IOException();
                }
                j++;
            }
        }
    }

    private long countByReading(InputStream inputStream) throws IOException {
        long j = 0;
        while (true) {
            long read = (long) inputStream.read(countBuffer);
            if (read == -1) {
                return j;
            }
            j += read;
        }
    }

    public long copyTo(OutputStream outputStream) throws IOException {
        Preconditions.checkNotNull(outputStream);
        Closer create = Closer.create();
        try {
            long copy = ByteStreams.copy((InputStream) create.register(openStream()), outputStream);
            create.close();
            return copy;
        } catch (Throwable th) {
            create.close();
            throw th;
        }
    }

    public long copyTo(ByteSink byteSink) throws IOException {
        Preconditions.checkNotNull(byteSink);
        Closer create = Closer.create();
        try {
            long copy = ByteStreams.copy((InputStream) create.register(openStream()), (OutputStream) create.register(byteSink.openStream()));
            create.close();
            return copy;
        } catch (Throwable th) {
            create.close();
            throw th;
        }
    }

    public byte[] read() throws IOException {
        Closer create = Closer.create();
        try {
            byte[] byteArray = ByteStreams.toByteArray((InputStream) create.register(openStream()));
            create.close();
            return byteArray;
        } catch (Throwable th) {
            create.close();
            throw th;
        }
    }

    @Beta
    public <T> T read(ByteProcessor<T> byteProcessor) throws IOException {
        Preconditions.checkNotNull(byteProcessor);
        Closer create = Closer.create();
        try {
            T readBytes = ByteStreams.readBytes((InputStream) create.register(openStream()), byteProcessor);
            create.close();
            return readBytes;
        } catch (Throwable th) {
            create.close();
            throw th;
        }
    }

    public HashCode hash(HashFunction hashFunction) throws IOException {
        Hasher newHasher = hashFunction.newHasher();
        copyTo(Funnels.asOutputStream(newHasher));
        return newHasher.hash();
    }

    public boolean contentEquals(ByteSource byteSource) throws IOException {
        int read;
        Preconditions.checkNotNull(byteSource);
        byte[] bArr = new byte[BUF_SIZE];
        byte[] bArr2 = new byte[BUF_SIZE];
        Closer create = Closer.create();
        try {
            InputStream inputStream = (InputStream) create.register(openStream());
            InputStream inputStream2 = (InputStream) create.register(byteSource.openStream());
            do {
                read = ByteStreams.read(inputStream, bArr, 0, BUF_SIZE);
                if (read != ByteStreams.read(inputStream2, bArr2, 0, BUF_SIZE) || !Arrays.equals(bArr, bArr2)) {
                    create.close();
                    return false;
                }
            } while (read == BUF_SIZE);
            create.close();
            return true;
        } catch (Throwable th) {
            create.close();
            throw th;
        }
    }

    public static ByteSource concat(Iterable<? extends ByteSource> iterable) {
        return new ConcatenatedByteSource(iterable);
    }

    public static ByteSource concat(Iterator<? extends ByteSource> it) {
        return concat((Iterable<? extends ByteSource>) ImmutableList.copyOf(it));
    }

    public static ByteSource concat(ByteSource... byteSourceArr) {
        return concat((Iterable<? extends ByteSource>) ImmutableList.copyOf((E[]) byteSourceArr));
    }

    public static ByteSource wrap(byte[] bArr) {
        return new ByteArrayByteSource(bArr);
    }

    public static ByteSource empty() {
        return EmptyByteSource.INSTANCE;
    }
}
