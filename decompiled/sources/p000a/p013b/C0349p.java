package p000a.p013b;

import p000a.p013b.p017b.C0161b;

/* renamed from: a.b.p */
/* compiled from: Observer */
public interface C0349p<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t);

    void onSubscribe(C0161b bVar);
}
