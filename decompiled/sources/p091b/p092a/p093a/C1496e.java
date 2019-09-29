package p091b.p092a.p093a;

import java.io.IOException;
import p102c.C1672c;
import p102c.C1678g;
import p102c.C1694r;

/* renamed from: b.a.a.e */
/* compiled from: FaultHidingSink */
class C1496e extends C1678g {

    /* renamed from: a */
    private boolean f4510a;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6206a(IOException iOException) {
    }

    C1496e(C1694r rVar) {
        super(rVar);
    }

    /* renamed from: a_ */
    public void mo6217a_(C1672c cVar, long j) throws IOException {
        if (this.f4510a) {
            cVar.mo6850h(j);
            return;
        }
        try {
            super.mo6217a_(cVar, j);
        } catch (IOException e) {
            this.f4510a = true;
            mo6206a(e);
        }
    }

    public void flush() throws IOException {
        if (!this.f4510a) {
            try {
                super.flush();
            } catch (IOException e) {
                this.f4510a = true;
                mo6206a(e);
            }
        }
    }

    public void close() throws IOException {
        if (!this.f4510a) {
            try {
                super.close();
            } catch (IOException e) {
                this.f4510a = true;
                mo6206a(e);
            }
        }
    }
}
