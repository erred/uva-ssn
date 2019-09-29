package p102c;

import java.io.IOException;

/* renamed from: c.h */
/* compiled from: ForwardingSource */
public abstract class C1679h implements C1695s {

    /* renamed from: a */
    private final C1695s f5299a;

    public C1679h(C1695s sVar) {
        if (sVar != null) {
            this.f5299a = sVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    /* renamed from: b */
    public final C1695s mo6907b() {
        return this.f5299a;
    }

    /* renamed from: a */
    public long mo6185a(C1672c cVar, long j) throws IOException {
        return this.f5299a.mo6185a(cVar, j);
    }

    /* renamed from: a */
    public C1696t mo6186a() {
        return this.f5299a.mo6186a();
    }

    public void close() throws IOException {
        this.f5299a.close();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("(");
        sb.append(this.f5299a.toString());
        sb.append(")");
        return sb.toString();
    }
}
