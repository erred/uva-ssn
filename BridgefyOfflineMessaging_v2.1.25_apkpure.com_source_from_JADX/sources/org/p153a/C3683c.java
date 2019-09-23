package org.p153a;

/* renamed from: org.a.c */
/* compiled from: Subscriber */
public interface C3683c<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t);

    void onSubscribe(C3684d dVar);
}
