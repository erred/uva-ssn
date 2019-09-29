package p000a.p013b.p014a.p016b;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Callable;
import p000a.p013b.C0350q;
import p000a.p013b.p014a.p015a.C0152a;

/* renamed from: a.b.a.b.a */
/* compiled from: AndroidSchedulers */
public final class C0153a {

    /* renamed from: a */
    private static final C0350q f371a = C0152a.m531a((Callable<C0350q>) new Callable<C0350q>() {
        /* renamed from: a */
        public C0350q call() throws Exception {
            return C0155a.f372a;
        }
    });

    /* renamed from: a.b.a.b.a$a */
    /* compiled from: AndroidSchedulers */
    private static final class C0155a {

        /* renamed from: a */
        static final C0350q f372a = new C0156b(new Handler(Looper.getMainLooper()), false);
    }

    /* renamed from: a */
    public static C0350q m534a() {
        return C0152a.m530a(f371a);
    }
}
