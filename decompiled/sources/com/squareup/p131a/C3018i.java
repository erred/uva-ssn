package com.squareup.p131a;

import android.os.Looper;

/* renamed from: com.squareup.a.i */
/* compiled from: ThreadEnforcer */
public interface C3018i {

    /* renamed from: a */
    public static final C3018i f7874a = new C3018i() {
        /* renamed from: a */
        public void mo27411a(C3007b bVar) {
        }
    };

    /* renamed from: b */
    public static final C3018i f7875b = new C3018i() {
        /* renamed from: a */
        public void mo27411a(C3007b bVar) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Event bus ");
                sb.append(bVar);
                sb.append(" accessed from non-main thread ");
                sb.append(Looper.myLooper());
                throw new IllegalStateException(sb.toString());
            }
        }
    };

    /* renamed from: a */
    void mo27411a(C3007b bVar);
}
