package com.twitter.sdk.android.core.internal.scribe;

import android.content.Context;
import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import com.twitter.sdk.android.core.C3132f;
import com.twitter.sdk.android.core.C3254k;
import com.twitter.sdk.android.core.C3255l;
import com.twitter.sdk.android.core.C3259p;
import com.twitter.sdk.android.core.C3262s;
import com.twitter.sdk.android.core.internal.C3176g;
import com.twitter.sdk.android.core.internal.C3181j;
import com.twitter.sdk.android.core.internal.p133a.C3156a;
import com.twitter.sdk.android.core.internal.p133a.C3159d;
import com.twitter.sdk.android.core.internal.p133a.C3160e;
import com.twitter.sdk.android.core.internal.scribe.C3230o.C3234c;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicReference;
import p091b.C1590aa.C1591a;
import p091b.C1596ac;
import p091b.C1598ad;
import p091b.C1645u;
import p091b.C1645u.C1646a;
import p091b.C1651x;
import p091b.C1651x.C1653a;
import p136d.C3380b;
import p136d.C3445l;
import p136d.C3446m.C3448a;
import p136d.p139b.C3383c;
import p136d.p139b.C3385e;
import p136d.p139b.C3391k;
import p136d.p139b.C3395o;
import p136d.p139b.C3399s;

class ScribeFilesSender implements C3229n {

    /* renamed from: a */
    private static final byte[] f8395a = {91};
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final byte[] f8396b = {44};

    /* renamed from: c */
    private static final byte[] f8397c = {93};

    /* renamed from: d */
    private final Context f8398d;

    /* renamed from: e */
    private final C3237r f8399e;

    /* renamed from: f */
    private final long f8400f;

    /* renamed from: g */
    private final C3259p f8401g;

    /* renamed from: h */
    private final C3255l<? extends C3254k<C3262s>> f8402h;

    /* renamed from: i */
    private final C3132f f8403i;

    /* renamed from: j */
    private final AtomicReference<ScribeService> f8404j = new AtomicReference<>();

    /* renamed from: k */
    private final ExecutorService f8405k;

    /* renamed from: l */
    private final C3181j f8406l;

    interface ScribeService {
        @C3385e
        @C3391k(mo28220a = {"Content-Type: application/x-www-form-urlencoded;charset=UTF-8"})
        @C3395o(mo28223a = "/{version}/jot/{type}")
        C3380b<C1598ad> upload(@C3399s(mo28228a = "version") String str, @C3399s(mo28228a = "type") String str2, @C3383c(mo28211a = "log[]") String str3);

        @C3385e
        @C3391k(mo28220a = {"Content-Type: application/x-www-form-urlencoded;charset=UTF-8"})
        @C3395o(mo28223a = "/scribe/{sequence}")
        C3380b<C1598ad> uploadSequence(@C3399s(mo28228a = "sequence") String str, @C3383c(mo28211a = "log[]") String str2);
    }

    /* renamed from: com.twitter.sdk.android.core.internal.scribe.ScribeFilesSender$a */
    static class C3209a implements C1645u {

        /* renamed from: a */
        private final C3237r f8410a;

        /* renamed from: b */
        private final C3181j f8411b;

        C3209a(C3237r rVar, C3181j jVar) {
            this.f8410a = rVar;
            this.f8411b = jVar;
        }

        /* renamed from: a */
        public C1596ac mo6184a(C1646a aVar) throws IOException {
            C1591a e = aVar.mo6279a().mo6460e();
            if (!TextUtils.isEmpty(this.f8410a.f8488f)) {
                e.mo6470a(HttpHeaders.USER_AGENT, this.f8410a.f8488f);
            }
            if (!TextUtils.isEmpty(this.f8411b.mo27701a())) {
                e.mo6470a("X-Client-UUID", this.f8411b.mo27701a());
            }
            e.mo6470a("X-Twitter-Polling", "true");
            return aVar.mo6280a(e.mo6471a());
        }
    }

    public ScribeFilesSender(Context context, C3237r rVar, long j, C3259p pVar, C3255l<? extends C3254k<C3262s>> lVar, C3132f fVar, ExecutorService executorService, C3181j jVar) {
        this.f8398d = context;
        this.f8399e = rVar;
        this.f8400f = j;
        this.f8401g = pVar;
        this.f8402h = lVar;
        this.f8403i = fVar;
        this.f8405k = executorService;
        this.f8406l = jVar;
    }

    /* renamed from: a */
    public boolean mo27761a(List<File> list) {
        if (m9393c()) {
            try {
                String b = mo27762b(list);
                C3176g.m9302a(this.f8398d, b);
                C3445l a = mo27760a(b);
                if (a.mo28269a() == 200) {
                    return true;
                }
                C3176g.m9303a(this.f8398d, "Failed sending files", (Throwable) null);
                if (a.mo28269a() == 500 || a.mo28269a() == 400) {
                    return true;
                }
            } catch (Exception e) {
                C3176g.m9303a(this.f8398d, "Failed sending files", (Throwable) e);
            }
        } else {
            C3176g.m9302a(this.f8398d, "Cannot attempt upload at this time");
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public String mo27762b(List<File> list) throws IOException {
        C3230o oVar;
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        final boolean[] zArr = new boolean[1];
        byteArrayOutputStream.write(f8395a);
        for (File oVar2 : list) {
            try {
                oVar = new C3230o(oVar2);
                try {
                    oVar.mo27817a((C3234c) new C3234c() {
                        /* renamed from: a */
                        public void mo27763a(InputStream inputStream, int i) throws IOException {
                            byte[] bArr = new byte[i];
                            inputStream.read(bArr);
                            if (zArr[0]) {
                                byteArrayOutputStream.write(ScribeFilesSender.f8396b);
                            } else {
                                zArr[0] = true;
                            }
                            byteArrayOutputStream.write(bArr);
                        }
                    });
                    C3176g.m9304a((Closeable) oVar);
                } catch (Throwable th) {
                    th = th;
                    C3176g.m9304a((Closeable) oVar);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                oVar = null;
                C3176g.m9304a((Closeable) oVar);
                throw th;
            }
        }
        byteArrayOutputStream.write(f8397c);
        return byteArrayOutputStream.toString("UTF-8");
    }

    /* renamed from: c */
    private boolean m9393c() {
        return mo27759a() != null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public synchronized ScribeService mo27759a() {
        C1651x xVar;
        if (this.f8404j.get() == null) {
            C3254k a = m9390a(this.f8400f);
            if (m9391a(a)) {
                xVar = new C1653a().mo6733a(C3160e.m9255a()).mo6734a((C1645u) new C3209a(this.f8399e, this.f8406l)).mo6734a((C1645u) new C3159d(a, this.f8401g)).mo6735a();
            } else {
                xVar = new C1653a().mo6733a(C3160e.m9255a()).mo6734a((C1645u) new C3209a(this.f8399e, this.f8406l)).mo6734a((C1645u) new C3156a(this.f8403i)).mo6735a();
            }
            this.f8404j.compareAndSet(null, new C3448a().mo28290a(this.f8399e.f8484b).mo28288a(xVar).mo28291a().mo28281a(ScribeService.class));
        }
        return (ScribeService) this.f8404j.get();
    }

    /* renamed from: a */
    private C3254k m9390a(long j) {
        return this.f8402h.mo27622a(j);
    }

    /* renamed from: a */
    private boolean m9391a(C3254k kVar) {
        return (kVar == null || kVar.mo27849a() == null) ? false : true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C3445l<C1598ad> mo27760a(String str) throws IOException {
        ScribeService a = mo27759a();
        if (!TextUtils.isEmpty(this.f8399e.f8487e)) {
            return a.uploadSequence(this.f8399e.f8487e, str).mo28206a();
        }
        return a.upload(this.f8399e.f8485c, this.f8399e.f8486d, str).mo28206a();
    }
}
