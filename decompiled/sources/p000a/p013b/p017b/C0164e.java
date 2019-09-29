package p000a.p013b.p017b;

/* renamed from: a.b.b.e */
/* compiled from: RunnableDisposable */
final class C0164e extends C0163d<Runnable> {
    C0164e(Runnable runnable) {
        super(runnable);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo357a(Runnable runnable) {
        runnable.run();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RunnableDisposable(disposed=");
        sb.append(mo358a());
        sb.append(", ");
        sb.append(get());
        sb.append(")");
        return sb.toString();
    }
}
