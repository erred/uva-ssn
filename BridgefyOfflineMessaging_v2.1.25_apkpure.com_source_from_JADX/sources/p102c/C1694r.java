package p102c;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/* renamed from: c.r */
/* compiled from: Sink */
public interface C1694r extends Closeable, Flushable {
    /* renamed from: a */
    C1696t mo6306a();

    /* renamed from: a_ */
    void mo6217a_(C1672c cVar, long j) throws IOException;

    void close() throws IOException;

    void flush() throws IOException;
}
