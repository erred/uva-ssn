package com.google.common.p126io;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

/* renamed from: com.google.common.io.MultiReader */
class MultiReader extends Reader {
    private Reader current;

    /* renamed from: it */
    private final Iterator<? extends CharSource> f6788it;

    MultiReader(Iterator<? extends CharSource> it) throws IOException {
        this.f6788it = it;
        advance();
    }

    private void advance() throws IOException {
        close();
        if (this.f6788it.hasNext()) {
            this.current = ((CharSource) this.f6788it.next()).openStream();
        }
    }

    public int read(char[] cArr, int i, int i2) throws IOException {
        if (this.current == null) {
            return -1;
        }
        int read = this.current.read(cArr, i, i2);
        if (read != -1) {
            return read;
        }
        advance();
        return read(cArr, i, i2);
    }

    public long skip(long j) throws IOException {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        Preconditions.checkArgument(i >= 0, "n is negative");
        if (i > 0) {
            while (this.current != null) {
                long skip = this.current.skip(j);
                if (skip > 0) {
                    return skip;
                }
                advance();
            }
        }
        return 0;
    }

    public boolean ready() throws IOException {
        return this.current != null && this.current.ready();
    }

    public void close() throws IOException {
        if (this.current != null) {
            try {
                this.current.close();
            } finally {
                this.current = null;
            }
        }
    }
}
