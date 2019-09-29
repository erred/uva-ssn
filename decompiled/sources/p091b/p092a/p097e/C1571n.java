package p091b.p092a.p097e;

import java.io.IOException;

/* renamed from: b.a.e.n */
/* compiled from: StreamResetException */
public final class C1571n extends IOException {

    /* renamed from: a */
    public final C1535b f4816a;

    public C1571n(C1535b bVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("stream was reset: ");
        sb.append(bVar);
        super(sb.toString());
        this.f4816a = bVar;
    }
}
