package com.google.common.p126io;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.LinkedList;
import java.util.Queue;

@Beta
/* renamed from: com.google.common.io.LineReader */
public final class LineReader {
    private final char[] buf = new char[4096];
    private final CharBuffer cbuf = CharBuffer.wrap(this.buf);
    private final LineBuffer lineBuf = new LineBuffer() {
        /* access modifiers changed from: protected */
        public void handleLine(String str, String str2) {
            LineReader.this.lines.add(str);
        }
    };
    /* access modifiers changed from: private */
    public final Queue<String> lines = new LinkedList();
    private final Readable readable;
    private final Reader reader;

    public LineReader(Readable readable2) {
        this.readable = (Readable) Preconditions.checkNotNull(readable2);
        this.reader = readable2 instanceof Reader ? (Reader) readable2 : null;
    }

    public String readLine() throws IOException {
        while (true) {
            if (this.lines.peek() != null) {
                break;
            }
            this.cbuf.clear();
            int read = this.reader != null ? this.reader.read(this.buf, 0, this.buf.length) : this.readable.read(this.cbuf);
            if (read == -1) {
                this.lineBuf.finish();
                break;
            }
            this.lineBuf.add(this.buf, 0, read);
        }
        return (String) this.lines.poll();
    }
}
