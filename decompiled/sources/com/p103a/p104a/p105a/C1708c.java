package com.p103a.p104a.p105a;

import android.content.Context;
import android.os.Looper;
import java.io.IOException;
import p000a.p001a.p002a.p003a.p004a.p006b.C0042s;
import p000a.p001a.p002a.p003a.p004a.p009d.C0083g;
import p000a.p001a.p002a.p003a.p004a.p011f.C0103a;

/* renamed from: com.a.a.a.c */
/* compiled from: AnswersFilesManagerProvider */
class C1708c {

    /* renamed from: a */
    final Context f5361a;

    /* renamed from: b */
    final C0103a f5362b;

    public C1708c(Context context, C0103a aVar) {
        this.f5361a = context;
        this.f5362b = aVar;
    }

    /* renamed from: a */
    public C1723o mo6960a() throws IOException {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return new C1723o(this.f5361a, new C1732u(), new C0042s(), new C0083g(this.f5361a, this.f5362b.mo243a(), "session_analytics.tap", "session_analytics_to_send"));
        }
        throw new IllegalStateException("AnswersFilesManagerProvider cannot be called on the main thread");
    }
}
