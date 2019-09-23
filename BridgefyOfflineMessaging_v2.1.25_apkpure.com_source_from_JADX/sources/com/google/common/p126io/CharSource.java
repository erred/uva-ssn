package com.google.common.p126io;

import com.google.common.annotations.Beta;
import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.regex.Pattern;

/* renamed from: com.google.common.io.CharSource */
public abstract class CharSource implements InputSupplier<Reader> {

    /* renamed from: com.google.common.io.CharSource$CharSequenceCharSource */
    private static class CharSequenceCharSource extends CharSource {
        /* access modifiers changed from: private */
        public static final Splitter LINE_SPLITTER = Splitter.m8658on(Pattern.compile("\r\n|\n|\r"));
        /* access modifiers changed from: private */
        public final CharSequence seq;

        public /* bridge */ /* synthetic */ Object getInput() throws IOException {
            return CharSource.super.getInput();
        }

        protected CharSequenceCharSource(CharSequence charSequence) {
            this.seq = (CharSequence) Preconditions.checkNotNull(charSequence);
        }

        public Reader openStream() {
            return new CharSequenceReader(this.seq);
        }

        public String read() {
            return this.seq.toString();
        }

        public boolean isEmpty() {
            return this.seq.length() == 0;
        }

        private Iterable<String> lines() {
            return new Iterable<String>() {
                public Iterator<String> iterator() {
                    return new AbstractIterator<String>() {
                        Iterator<String> lines = CharSequenceCharSource.LINE_SPLITTER.split(CharSequenceCharSource.this.seq).iterator();

                        /* access modifiers changed from: protected */
                        public String computeNext() {
                            if (this.lines.hasNext()) {
                                String str = (String) this.lines.next();
                                if (this.lines.hasNext() || str.length() != 0) {
                                    return str;
                                }
                            }
                            return (String) endOfData();
                        }
                    };
                }
            };
        }

        public String readFirstLine() {
            Iterator it = lines().iterator();
            if (it.hasNext()) {
                return (String) it.next();
            }
            return null;
        }

        public ImmutableList<String> readLines() {
            return ImmutableList.copyOf(lines());
        }

        public <T> T readLines(LineProcessor<T> lineProcessor) throws IOException {
            for (String processLine : lines()) {
                if (!lineProcessor.processLine(processLine)) {
                    break;
                }
            }
            return lineProcessor.getResult();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("CharSource.wrap(");
            sb.append(Ascii.truncate(this.seq, 30, "..."));
            sb.append(")");
            return sb.toString();
        }
    }

    /* renamed from: com.google.common.io.CharSource$ConcatenatedCharSource */
    private static final class ConcatenatedCharSource extends CharSource {
        private final Iterable<? extends CharSource> sources;

        public /* bridge */ /* synthetic */ Object getInput() throws IOException {
            return CharSource.super.getInput();
        }

        ConcatenatedCharSource(Iterable<? extends CharSource> iterable) {
            this.sources = (Iterable) Preconditions.checkNotNull(iterable);
        }

        public Reader openStream() throws IOException {
            return new MultiReader(this.sources.iterator());
        }

        public boolean isEmpty() throws IOException {
            for (CharSource isEmpty : this.sources) {
                if (!isEmpty.isEmpty()) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("CharSource.concat(");
            sb.append(this.sources);
            sb.append(")");
            return sb.toString();
        }
    }

    /* renamed from: com.google.common.io.CharSource$EmptyCharSource */
    private static final class EmptyCharSource extends CharSequenceCharSource {
        /* access modifiers changed from: private */
        public static final EmptyCharSource INSTANCE = new EmptyCharSource();

        public String toString() {
            return "CharSource.empty()";
        }

        private EmptyCharSource() {
            super("");
        }
    }

    public abstract Reader openStream() throws IOException;

    protected CharSource() {
    }

    @Deprecated
    public final Reader getInput() throws IOException {
        return openStream();
    }

    public BufferedReader openBufferedStream() throws IOException {
        Reader openStream = openStream();
        return openStream instanceof BufferedReader ? (BufferedReader) openStream : new BufferedReader(openStream);
    }

    public long copyTo(Appendable appendable) throws IOException {
        Preconditions.checkNotNull(appendable);
        Closer create = Closer.create();
        try {
            long copy = CharStreams.copy((Readable) (Reader) create.register(openStream()), appendable);
            create.close();
            return copy;
        } catch (Throwable th) {
            create.close();
            throw th;
        }
    }

    public long copyTo(CharSink charSink) throws IOException {
        Preconditions.checkNotNull(charSink);
        Closer create = Closer.create();
        try {
            long copy = CharStreams.copy((Readable) (Reader) create.register(openStream()), (Appendable) (Writer) create.register(charSink.openStream()));
            create.close();
            return copy;
        } catch (Throwable th) {
            create.close();
            throw th;
        }
    }

    public String read() throws IOException {
        Closer create = Closer.create();
        try {
            String charStreams = CharStreams.toString((Readable) (Reader) create.register(openStream()));
            create.close();
            return charStreams;
        } catch (Throwable th) {
            create.close();
            throw th;
        }
    }

    public String readFirstLine() throws IOException {
        Closer create = Closer.create();
        try {
            String readLine = ((BufferedReader) create.register(openBufferedStream())).readLine();
            create.close();
            return readLine;
        } catch (Throwable th) {
            create.close();
            throw th;
        }
    }

    public ImmutableList<String> readLines() throws IOException {
        Closer create = Closer.create();
        try {
            BufferedReader bufferedReader = (BufferedReader) create.register(openBufferedStream());
            ArrayList newArrayList = Lists.newArrayList();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    newArrayList.add(readLine);
                } else {
                    ImmutableList<String> copyOf = ImmutableList.copyOf((Collection<? extends E>) newArrayList);
                    create.close();
                    return copyOf;
                }
            }
        } catch (Throwable th) {
            create.close();
            throw th;
        }
    }

    @Beta
    public <T> T readLines(LineProcessor<T> lineProcessor) throws IOException {
        Preconditions.checkNotNull(lineProcessor);
        Closer create = Closer.create();
        try {
            T readLines = CharStreams.readLines((Readable) (Reader) create.register(openStream()), lineProcessor);
            create.close();
            return readLines;
        } catch (Throwable th) {
            create.close();
            throw th;
        }
    }

    public boolean isEmpty() throws IOException {
        Closer create = Closer.create();
        try {
            boolean z = ((Reader) create.register(openStream())).read() == -1;
            create.close();
            return z;
        } catch (Throwable th) {
            create.close();
            throw th;
        }
    }

    public static CharSource concat(Iterable<? extends CharSource> iterable) {
        return new ConcatenatedCharSource(iterable);
    }

    public static CharSource concat(Iterator<? extends CharSource> it) {
        return concat((Iterable<? extends CharSource>) ImmutableList.copyOf(it));
    }

    public static CharSource concat(CharSource... charSourceArr) {
        return concat((Iterable<? extends CharSource>) ImmutableList.copyOf((E[]) charSourceArr));
    }

    public static CharSource wrap(CharSequence charSequence) {
        return new CharSequenceCharSource(charSequence);
    }

    public static CharSource empty() {
        return EmptyCharSource.INSTANCE;
    }
}
