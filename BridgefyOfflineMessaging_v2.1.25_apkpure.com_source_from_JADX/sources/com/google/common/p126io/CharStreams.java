package com.google.common.p126io;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Beta
/* renamed from: com.google.common.io.CharStreams */
public final class CharStreams {
    private static final int BUF_SIZE = 2048;

    /* renamed from: com.google.common.io.CharStreams$NullWriter */
    private static final class NullWriter extends Writer {
        /* access modifiers changed from: private */
        public static final NullWriter INSTANCE = new NullWriter();

        public Writer append(char c) {
            return this;
        }

        public void close() {
        }

        public void flush() {
        }

        public String toString() {
            return "CharStreams.nullWriter()";
        }

        public void write(int i) {
        }

        private NullWriter() {
        }

        public void write(char[] cArr) {
            Preconditions.checkNotNull(cArr);
        }

        public void write(char[] cArr, int i, int i2) {
            Preconditions.checkPositionIndexes(i, i2 + i, cArr.length);
        }

        public void write(String str) {
            Preconditions.checkNotNull(str);
        }

        public void write(String str, int i, int i2) {
            Preconditions.checkPositionIndexes(i, i2 + i, str.length());
        }

        public Writer append(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return this;
        }

        public Writer append(CharSequence charSequence, int i, int i2) {
            Preconditions.checkPositionIndexes(i, i2, charSequence.length());
            return this;
        }
    }

    private CharStreams() {
    }

    @Deprecated
    public static InputSupplier<StringReader> newReaderSupplier(String str) {
        return asInputSupplier(CharSource.wrap(str));
    }

    @Deprecated
    public static InputSupplier<InputStreamReader> newReaderSupplier(InputSupplier<? extends InputStream> inputSupplier, Charset charset) {
        return asInputSupplier(ByteStreams.asByteSource(inputSupplier).asCharSource(charset));
    }

    @Deprecated
    public static OutputSupplier<OutputStreamWriter> newWriterSupplier(OutputSupplier<? extends OutputStream> outputSupplier, Charset charset) {
        return asOutputSupplier(ByteStreams.asByteSink(outputSupplier).asCharSink(charset));
    }

    @Deprecated
    public static <W extends Appendable & Closeable> void write(CharSequence charSequence, OutputSupplier<W> outputSupplier) throws IOException {
        asCharSink(outputSupplier).write(charSequence);
    }

    @Deprecated
    public static <R extends Readable & Closeable, W extends Appendable & Closeable> long copy(InputSupplier<R> inputSupplier, OutputSupplier<W> outputSupplier) throws IOException {
        return asCharSource(inputSupplier).copyTo(asCharSink(outputSupplier));
    }

    @Deprecated
    public static <R extends Readable & Closeable> long copy(InputSupplier<R> inputSupplier, Appendable appendable) throws IOException {
        return asCharSource(inputSupplier).copyTo(appendable);
    }

    public static long copy(Readable readable, Appendable appendable) throws IOException {
        Preconditions.checkNotNull(readable);
        Preconditions.checkNotNull(appendable);
        CharBuffer allocate = CharBuffer.allocate(BUF_SIZE);
        long j = 0;
        while (readable.read(allocate) != -1) {
            allocate.flip();
            appendable.append(allocate);
            j += (long) allocate.remaining();
            allocate.clear();
        }
        return j;
    }

    public static String toString(Readable readable) throws IOException {
        return toStringBuilder(readable).toString();
    }

    @Deprecated
    public static <R extends Readable & Closeable> String toString(InputSupplier<R> inputSupplier) throws IOException {
        return asCharSource(inputSupplier).read();
    }

    private static StringBuilder toStringBuilder(Readable readable) throws IOException {
        StringBuilder sb = new StringBuilder();
        copy(readable, (Appendable) sb);
        return sb;
    }

    @Deprecated
    public static <R extends Readable & Closeable> String readFirstLine(InputSupplier<R> inputSupplier) throws IOException {
        return asCharSource(inputSupplier).readFirstLine();
    }

    @Deprecated
    public static <R extends Readable & Closeable> List<String> readLines(InputSupplier<R> inputSupplier) throws IOException {
        Closer create = Closer.create();
        try {
            List<String> readLines = readLines((Readable) create.register((Closeable) inputSupplier.getInput()));
            create.close();
            return readLines;
        } catch (Throwable th) {
            create.close();
            throw th;
        }
    }

    public static List<String> readLines(Readable readable) throws IOException {
        ArrayList arrayList = new ArrayList();
        LineReader lineReader = new LineReader(readable);
        while (true) {
            String readLine = lineReader.readLine();
            if (readLine == null) {
                return arrayList;
            }
            arrayList.add(readLine);
        }
    }

    public static <T> T readLines(Readable readable, LineProcessor<T> lineProcessor) throws IOException {
        String readLine;
        Preconditions.checkNotNull(readable);
        Preconditions.checkNotNull(lineProcessor);
        LineReader lineReader = new LineReader(readable);
        do {
            readLine = lineReader.readLine();
            if (readLine == null) {
                break;
            }
        } while (lineProcessor.processLine(readLine));
        return lineProcessor.getResult();
    }

    @Deprecated
    public static <R extends Readable & Closeable, T> T readLines(InputSupplier<R> inputSupplier, LineProcessor<T> lineProcessor) throws IOException {
        Preconditions.checkNotNull(inputSupplier);
        Preconditions.checkNotNull(lineProcessor);
        Closer create = Closer.create();
        try {
            T readLines = readLines((Readable) create.register((Closeable) inputSupplier.getInput()), lineProcessor);
            create.close();
            return readLines;
        } catch (Throwable th) {
            create.close();
            throw th;
        }
    }

    @Deprecated
    public static InputSupplier<Reader> join(Iterable<? extends InputSupplier<? extends Reader>> iterable) {
        Preconditions.checkNotNull(iterable);
        return asInputSupplier(CharSource.concat(Iterables.transform(iterable, new Function<InputSupplier<? extends Reader>, CharSource>() {
            public CharSource apply(InputSupplier<? extends Reader> inputSupplier) {
                return CharStreams.asCharSource(inputSupplier);
            }
        })));
    }

    @Deprecated
    public static InputSupplier<Reader> join(InputSupplier<? extends Reader>... inputSupplierArr) {
        return join((Iterable<? extends InputSupplier<? extends Reader>>) Arrays.asList(inputSupplierArr));
    }

    public static void skipFully(Reader reader, long j) throws IOException {
        Preconditions.checkNotNull(reader);
        while (j > 0) {
            long skip = reader.skip(j);
            if (skip != 0) {
                j -= skip;
            } else if (reader.read() != -1) {
                j--;
            } else {
                throw new EOFException();
            }
        }
    }

    public static Writer nullWriter() {
        return NullWriter.INSTANCE;
    }

    public static Writer asWriter(Appendable appendable) {
        if (appendable instanceof Writer) {
            return (Writer) appendable;
        }
        return new AppendableWriter(appendable);
    }

    static Reader asReader(final Readable readable) {
        Preconditions.checkNotNull(readable);
        if (readable instanceof Reader) {
            return (Reader) readable;
        }
        return new Reader() {
            public int read(char[] cArr, int i, int i2) throws IOException {
                return read(CharBuffer.wrap(cArr, i, i2));
            }

            public int read(CharBuffer charBuffer) throws IOException {
                return readable.read(charBuffer);
            }

            public void close() throws IOException {
                if (readable instanceof Closeable) {
                    ((Closeable) readable).close();
                }
            }
        };
    }

    @Deprecated
    public static CharSource asCharSource(final InputSupplier<? extends Readable> inputSupplier) {
        Preconditions.checkNotNull(inputSupplier);
        return new CharSource() {
            public Reader openStream() throws IOException {
                return CharStreams.asReader((Readable) inputSupplier.getInput());
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("CharStreams.asCharSource(");
                sb.append(inputSupplier);
                sb.append(")");
                return sb.toString();
            }
        };
    }

    @Deprecated
    public static CharSink asCharSink(final OutputSupplier<? extends Appendable> outputSupplier) {
        Preconditions.checkNotNull(outputSupplier);
        return new CharSink() {
            public Writer openStream() throws IOException {
                return CharStreams.asWriter((Appendable) outputSupplier.getOutput());
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("CharStreams.asCharSink(");
                sb.append(outputSupplier);
                sb.append(")");
                return sb.toString();
            }
        };
    }

    static <R extends Reader> InputSupplier<R> asInputSupplier(CharSource charSource) {
        return (InputSupplier) Preconditions.checkNotNull(charSource);
    }

    static <W extends Writer> OutputSupplier<W> asOutputSupplier(CharSink charSink) {
        return (OutputSupplier) Preconditions.checkNotNull(charSink);
    }
}
