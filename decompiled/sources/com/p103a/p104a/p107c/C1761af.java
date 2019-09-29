package com.p103a.p104a.p107c;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import p000a.p001a.p002a.p003a.C0135c;
import p000a.p001a.p002a.p003a.C0149l;
import p000a.p001a.p002a.p003a.p004a.p006b.C0019h;

/* renamed from: com.a.a.c.af */
/* compiled from: ReportUploader */
class C1761af {

    /* renamed from: a */
    static final Map<String, String> f5517a = Collections.singletonMap("X-CRASHLYTICS-INVALID-SESSION", "1");
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final short[] f5518b = {10, 20, 30, 60, 120, 300};

    /* renamed from: c */
    private final Object f5519c = new Object();

    /* renamed from: d */
    private final C1827o f5520d;

    /* renamed from: e */
    private final String f5521e;

    /* renamed from: f */
    private final C1764c f5522f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final C1763b f5523g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Thread f5524h;

    /* renamed from: com.a.a.c.af$a */
    /* compiled from: ReportUploader */
    static final class C1762a implements C1765d {
        /* renamed from: a */
        public boolean mo7031a() {
            return true;
        }

        C1762a() {
        }
    }

    /* renamed from: com.a.a.c.af$b */
    /* compiled from: ReportUploader */
    interface C1763b {
        /* renamed from: a */
        boolean mo7032a();
    }

    /* renamed from: com.a.a.c.af$c */
    /* compiled from: ReportUploader */
    interface C1764c {
        /* renamed from: a */
        File[] mo7033a();

        /* renamed from: b */
        File[] mo7034b();
    }

    /* renamed from: com.a.a.c.af$d */
    /* compiled from: ReportUploader */
    interface C1765d {
        /* renamed from: a */
        boolean mo7031a();
    }

    /* renamed from: com.a.a.c.af$e */
    /* compiled from: ReportUploader */
    private class C1766e extends C0019h {

        /* renamed from: b */
        private final float f5526b;

        /* renamed from: c */
        private final C1765d f5527c;

        C1766e(float f, C1765d dVar) {
            this.f5526b = f;
            this.f5527c = dVar;
        }

        /* renamed from: a */
        public void mo30a() {
            try {
                m7305b();
            } catch (Exception e) {
                C0135c.m449h().mo280e("CrashlyticsCore", "An unexpected error occurred while attempting to upload crash reports.", e);
            }
            C1761af.this.f5524h = null;
        }

        /* renamed from: b */
        private void m7305b() {
            StringBuilder sb = new StringBuilder();
            sb.append("Starting report processing in ");
            sb.append(this.f5526b);
            sb.append(" second(s)...");
            C0135c.m449h().mo270a("CrashlyticsCore", sb.toString());
            if (this.f5526b > BitmapDescriptorFactory.HUE_RED) {
                try {
                    Thread.sleep((long) (this.f5526b * 1000.0f));
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            List<C1760ae> a = C1761af.this.mo7028a();
            if (!C1761af.this.f5523g.mo7032a()) {
                if (a.isEmpty() || this.f5527c.mo7031a()) {
                    int i = 0;
                    while (!a.isEmpty() && !C1761af.this.f5523g.mo7032a()) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Attempting to send ");
                        sb2.append(a.size());
                        sb2.append(" report(s)");
                        C0135c.m449h().mo270a("CrashlyticsCore", sb2.toString());
                        for (C1760ae a2 : a) {
                            C1761af.this.mo7030a(a2);
                        }
                        a = C1761af.this.mo7028a();
                        if (!a.isEmpty()) {
                            int i2 = i + 1;
                            long j = (long) C1761af.f5518b[Math.min(i, C1761af.f5518b.length - 1)];
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("Report submisson: scheduling delayed retry in ");
                            sb3.append(j);
                            sb3.append(" seconds");
                            C0135c.m449h().mo270a("CrashlyticsCore", sb3.toString());
                            try {
                                Thread.sleep(j * 1000);
                                i = i2;
                            } catch (InterruptedException unused2) {
                                Thread.currentThread().interrupt();
                                return;
                            }
                        }
                    }
                    return;
                }
                StringBuilder sb4 = new StringBuilder();
                sb4.append("User declined to send. Removing ");
                sb4.append(a.size());
                sb4.append(" Report(s).");
                C0135c.m449h().mo270a("CrashlyticsCore", sb4.toString());
                for (C1760ae f : a) {
                    f.mo7027f();
                }
            }
        }
    }

    public C1761af(String str, C1827o oVar, C1764c cVar, C1763b bVar) {
        if (oVar != null) {
            this.f5520d = oVar;
            this.f5521e = str;
            this.f5522f = cVar;
            this.f5523g = bVar;
            return;
        }
        throw new IllegalArgumentException("createReportCall must not be null.");
    }

    /* renamed from: a */
    public synchronized void mo7029a(float f, C1765d dVar) {
        if (this.f5524h != null) {
            C0135c.m449h().mo270a("CrashlyticsCore", "Report upload has already been started.");
            return;
        }
        this.f5524h = new Thread(new C1766e(f, dVar), "Crashlytics Report Uploader");
        this.f5524h.start();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo7030a(C1760ae aeVar) {
        boolean z;
        synchronized (this.f5519c) {
            z = false;
            try {
                boolean a = this.f5520d.mo7156a(new C1826n(this.f5521e, aeVar));
                C0149l h = C0135c.m449h();
                String str = "CrashlyticsCore";
                StringBuilder sb = new StringBuilder();
                sb.append("Crashlytics report upload ");
                sb.append(a ? "complete: " : "FAILED: ");
                sb.append(aeVar.mo7023b());
                h.mo275c(str, sb.toString());
                if (a) {
                    aeVar.mo7027f();
                    z = true;
                }
            } catch (Exception e) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Error occurred sending report ");
                sb2.append(aeVar);
                C0135c.m449h().mo280e("CrashlyticsCore", sb2.toString(), e);
            }
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public List<C1760ae> mo7028a() {
        File[] a;
        File[] b;
        C0135c.m449h().mo270a("CrashlyticsCore", "Checking for crash reports...");
        synchronized (this.f5519c) {
            a = this.f5522f.mo7033a();
            b = this.f5522f.mo7034b();
        }
        LinkedList linkedList = new LinkedList();
        if (a != null) {
            for (File file : a) {
                StringBuilder sb = new StringBuilder();
                sb.append("Found crash report ");
                sb.append(file.getPath());
                C0135c.m449h().mo270a("CrashlyticsCore", sb.toString());
                linkedList.add(new C1768ah(file));
            }
        }
        HashMap hashMap = new HashMap();
        if (b != null) {
            for (File file2 : b) {
                String a2 = C1791h.m7422a(file2);
                if (!hashMap.containsKey(a2)) {
                    hashMap.put(a2, new LinkedList());
                }
                ((List) hashMap.get(a2)).add(file2);
            }
        }
        for (String str : hashMap.keySet()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Found invalid session: ");
            sb2.append(str);
            C0135c.m449h().mo270a("CrashlyticsCore", sb2.toString());
            List list = (List) hashMap.get(str);
            linkedList.add(new C1834t(str, (File[]) list.toArray(new File[list.size()])));
        }
        if (linkedList.isEmpty()) {
            C0135c.m449h().mo270a("CrashlyticsCore", "No reports found.");
        }
        return linkedList;
    }
}
