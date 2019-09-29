package p000a.p013b.p018c;

/* renamed from: a.b.c.d */
/* compiled from: OnErrorNotImplementedException */
public final class C0173d extends RuntimeException {
    public C0173d(String str, Throwable th) {
        if (th == null) {
            th = new NullPointerException();
        }
        super(str, th);
    }

    public C0173d(Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("The exception was not handled due to missing onError handler in the subscribe() method call. Further reading: https://github.com/ReactiveX/RxJava/wiki/Error-Handling | ");
        sb.append(th != null ? th.getMessage() : "");
        this(sb.toString(), th);
    }
}
