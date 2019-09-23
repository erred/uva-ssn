package com.twitter.sdk.android.core.internal.scribe;

import android.content.Context;
import com.twitter.sdk.android.core.C3132f;
import com.twitter.sdk.android.core.C3254k;
import com.twitter.sdk.android.core.C3255l;
import com.twitter.sdk.android.core.C3259p;
import com.twitter.sdk.android.core.C3262s;
import com.twitter.sdk.android.core.internal.C3176g;
import com.twitter.sdk.android.core.internal.C3181j;
import com.twitter.sdk.android.core.internal.C3187m;
import com.twitter.sdk.android.core.internal.p134b.C3163a;
import com.twitter.sdk.android.core.internal.scribe.C3238s.C3239a;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;

/* renamed from: com.twitter.sdk.android.core.internal.scribe.q */
/* compiled from: ScribeClient */
public class C3236q {

    /* renamed from: a */
    final ConcurrentHashMap<Long, C3242v> f8474a = new ConcurrentHashMap<>(2);

    /* renamed from: b */
    private final Context f8475b;

    /* renamed from: c */
    private final ScheduledExecutorService f8476c;

    /* renamed from: d */
    private final C3237r f8477d;

    /* renamed from: e */
    private final C3239a f8478e;

    /* renamed from: f */
    private final C3259p f8479f;

    /* renamed from: g */
    private final C3255l<? extends C3254k<C3262s>> f8480g;

    /* renamed from: h */
    private final C3132f f8481h;

    /* renamed from: i */
    private final C3181j f8482i;

    public C3236q(Context context, ScheduledExecutorService scheduledExecutorService, C3237r rVar, C3239a aVar, C3259p pVar, C3255l<? extends C3254k<C3262s>> lVar, C3132f fVar, C3181j jVar) {
        this.f8475b = context;
        this.f8476c = scheduledExecutorService;
        this.f8477d = rVar;
        this.f8478e = aVar;
        this.f8479f = pVar;
        this.f8480g = lVar;
        this.f8481h = fVar;
        this.f8482i = jVar;
    }

    /* renamed from: a */
    public boolean mo27830a(C3238s sVar, long j) {
        try {
            mo27829a(j).mo27837a(sVar);
            return true;
        } catch (IOException e) {
            C3176g.m9303a(this.f8475b, "Failed to scribe event", (Throwable) e);
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C3242v mo27829a(long j) throws IOException {
        if (!this.f8474a.containsKey(Long.valueOf(j))) {
            this.f8474a.putIfAbsent(Long.valueOf(j), m9505d(j));
        }
        return (C3242v) this.f8474a.get(Long.valueOf(j));
    }

    /* renamed from: d */
    private C3242v m9505d(long j) throws IOException {
        C3241u uVar = new C3241u(this.f8475b, this.f8478e, new C3187m(), new C3235p(this.f8475b, new C3163a(this.f8475b).mo27681a(), mo27831b(j), mo27832c(j)), this.f8477d.f8489g);
        return new C3242v(this.f8475b, mo27828a(j, uVar), uVar, this.f8476c);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C3227l<C3238s> mo27828a(long j, C3241u uVar) {
        if (this.f8477d.f8483a) {
            C3176g.m9302a(this.f8475b, "Scribe enabled");
            Context context = this.f8475b;
            ScheduledExecutorService scheduledExecutorService = this.f8476c;
            C3237r rVar = this.f8477d;
            ScribeFilesSender scribeFilesSender = new ScribeFilesSender(this.f8475b, this.f8477d, j, this.f8479f, this.f8480g, this.f8481h, this.f8476c, this.f8482i);
            C3214d dVar = new C3214d(context, scheduledExecutorService, uVar, rVar, scribeFilesSender);
            return dVar;
        }
        C3176g.m9302a(this.f8475b, "Scribe disabled");
        return new C3212b();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public String mo27831b(long j) {
        StringBuilder sb = new StringBuilder();
        sb.append(j);
        sb.append("_se.tap");
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public String mo27832c(long j) {
        StringBuilder sb = new StringBuilder();
        sb.append(j);
        sb.append("_se_to_send");
        return sb.toString();
    }
}
