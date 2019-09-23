package p102c;

import java.io.IOException;

/* renamed from: c.g */
/* compiled from: ForwardingSink */
public abstract class C1678g implements C1694r {

    /* renamed from: a */
    private final C1694r f5298a;

    public C1678g(C1694r rVar) {
        if (rVar != null) {
            this.f5298a = rVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    /* renamed from: a_ */
    public void mo6217a_(C1672c cVar, long j) throws IOException {
        this.f5298a.mo6217a_(cVar, j);
    }

    public void flush() throws IOException {
        this.f5298a.flush();
    }

    /* renamed from: a */
    public C1696t mo6306a() {
        return this.f5298a.mo6306a();
    }

    public void close() throws IOException {
        this.f5298a.close();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("(");
        sb.append(this.f5298a.toString());
        sb.append(")");
        return sb.toString();
    }
}
