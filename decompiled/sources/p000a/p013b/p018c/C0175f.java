package p000a.p013b.p018c;

/* renamed from: a.b.c.f */
/* compiled from: UndeliverableException */
public final class C0175f extends IllegalStateException {
    public C0175f(Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("The exception could not be delivered to the consumer because it has already canceled/disposed the flow or the exception has nowhere to go to begin with. Further reading: https://github.com/ReactiveX/RxJava/wiki/What's-different-in-2.0#error-handling | ");
        sb.append(th.getMessage());
        super(sb.toString(), th);
    }
}
