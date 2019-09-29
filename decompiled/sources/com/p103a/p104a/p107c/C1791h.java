package com.p103a.p104a.p107c;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import com.google.android.gms.measurement.AppMeasurement;
import com.p103a.p104a.p105a.C1700a;
import com.p103a.p104a.p107c.C1835u.C1837a;
import com.p103a.p104a.p107c.p108a.p109a.C1751d;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p000a.p001a.p002a.p003a.C0135c;
import p000a.p001a.p002a.p003a.C0146i;
import p000a.p001a.p002a.p003a.p004a.p006b.C0020i;
import p000a.p001a.p002a.p003a.p004a.p006b.C0023j.C0024a;
import p000a.p001a.p002a.p003a.p004a.p006b.C0026l;
import p000a.p001a.p002a.p003a.p004a.p006b.C0032o;
import p000a.p001a.p002a.p003a.p004a.p010e.C0098e;
import p000a.p001a.p002a.p003a.p004a.p011f.C0103a;
import p000a.p001a.p002a.p003a.p004a.p012g.C0121o;
import p000a.p001a.p002a.p003a.p004a.p012g.C0122p;
import p000a.p001a.p002a.p003a.p004a.p012g.C0123q;
import p000a.p001a.p002a.p003a.p004a.p012g.C0128t;

/* renamed from: com.a.a.c.h */
/* compiled from: CrashlyticsController */
class C1791h {

    /* renamed from: a */
    static final FilenameFilter f5573a = new FilenameFilter() {
        public boolean accept(File file, String str) {
            return str.length() == ".cls".length() + 35 && str.endsWith(".cls");
        }
    };

    /* renamed from: b */
    static final Comparator<File> f5574b = new Comparator<File>() {
        /* renamed from: a */
        public int compare(File file, File file2) {
            return file2.getName().compareTo(file.getName());
        }
    };

    /* renamed from: c */
    static final Comparator<File> f5575c = new Comparator<File>() {
        /* renamed from: a */
        public int compare(File file, File file2) {
            return file.getName().compareTo(file2.getName());
        }
    };

    /* renamed from: d */
    static final FilenameFilter f5576d = new FilenameFilter() {
        public boolean accept(File file, String str) {
            return C1791h.f5577e.matcher(str).matches();
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static final Pattern f5577e = Pattern.compile("([\\d|A-Z|a-z]{12}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{12}).+");

    /* renamed from: f */
    private static final Map<String, String> f5578f = Collections.singletonMap("X-CRASHLYTICS-SEND-FLAGS", "1");

    /* renamed from: g */
    private static final String[] f5579g = {"SessionUser", "SessionApp", "SessionOS", "SessionDevice"};

    /* renamed from: h */
    private final AtomicInteger f5580h = new AtomicInteger(0);
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final C1814i f5581i;

    /* renamed from: j */
    private final C1788g f5582j;

    /* renamed from: k */
    private final C0098e f5583k;

    /* renamed from: l */
    private final C0032o f5584l;

    /* renamed from: m */
    private final C1756ab f5585m;

    /* renamed from: n */
    private final C0103a f5586n;

    /* renamed from: o */
    private final C1746a f5587o;

    /* renamed from: p */
    private final C1806d f5588p;

    /* renamed from: q */
    private final C1835u f5589q;

    /* renamed from: r */
    private final C1764c f5590r;

    /* renamed from: s */
    private final C1763b f5591s;

    /* renamed from: t */
    private final C1829q f5592t;

    /* renamed from: u */
    private final C1769ai f5593u;

    /* renamed from: v */
    private final String f5594v;

    /* renamed from: w */
    private C1824m f5595w;

    /* renamed from: com.a.a.c.h$a */
    /* compiled from: CrashlyticsController */
    private static class C1803a implements FilenameFilter {
        private C1803a() {
        }

        public boolean accept(File file, String str) {
            return !C1791h.f5573a.accept(file, str) && C1791h.f5577e.matcher(str).matches();
        }
    }

    /* renamed from: com.a.a.c.h$b */
    /* compiled from: CrashlyticsController */
    static class C1804b implements FilenameFilter {

        /* renamed from: a */
        private final String f5609a;

        public C1804b(String str) {
            this.f5609a = str;
        }

        public boolean accept(File file, String str) {
            return str.contains(this.f5609a) && !str.endsWith(".cls_temp");
        }
    }

    /* renamed from: com.a.a.c.h$c */
    /* compiled from: CrashlyticsController */
    static class C1805c implements FilenameFilter {
        C1805c() {
        }

        public boolean accept(File file, String str) {
            return C1778d.f5551a.accept(file, str) || str.contains("SessionMissingBinaryImages");
        }
    }

    /* renamed from: com.a.a.c.h$d */
    /* compiled from: CrashlyticsController */
    private static final class C1806d implements C1837a {

        /* renamed from: a */
        private final C0103a f5610a;

        public C1806d(C0103a aVar) {
            this.f5610a = aVar;
        }

        /* renamed from: a */
        public File mo7125a() {
            File file = new File(this.f5610a.mo243a(), "log-files");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }

    /* renamed from: com.a.a.c.h$e */
    /* compiled from: CrashlyticsController */
    private static final class C1807e implements C1765d {

        /* renamed from: a */
        private final C0146i f5611a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final C1756ab f5612b;

        /* renamed from: c */
        private final C0121o f5613c;

        public C1807e(C0146i iVar, C1756ab abVar, C0121o oVar) {
            this.f5611a = iVar;
            this.f5612b = abVar;
            this.f5613c = oVar;
        }

        /* renamed from: a */
        public boolean mo7031a() {
            Activity b = this.f5611a.mo321r().mo285b();
            if (b == null || b.isFinishing()) {
                return true;
            }
            final C1782f a = C1782f.m7410a(b, this.f5613c, new C1786a() {
                /* renamed from: a */
                public void mo7079a(boolean z) {
                    C1807e.this.f5612b.mo7016a(z);
                }
            });
            b.runOnUiThread(new Runnable() {
                public void run() {
                    a.mo7073a();
                }
            });
            C0135c.m449h().mo270a("CrashlyticsCore", "Waiting for user opt-in.");
            a.mo7074b();
            return a.mo7075c();
        }
    }

    /* renamed from: com.a.a.c.h$f */
    /* compiled from: CrashlyticsController */
    private final class C1810f implements C1764c {
        private C1810f() {
        }

        /* renamed from: a */
        public File[] mo7033a() {
            return C1791h.this.mo7097b();
        }

        /* renamed from: b */
        public File[] mo7034b() {
            return C1791h.this.mo7104i().listFiles();
        }
    }

    /* renamed from: com.a.a.c.h$g */
    /* compiled from: CrashlyticsController */
    private final class C1811g implements C1763b {
        private C1811g() {
        }

        /* renamed from: a */
        public boolean mo7032a() {
            return C1791h.this.mo7100e();
        }
    }

    /* renamed from: com.a.a.c.h$h */
    /* compiled from: CrashlyticsController */
    private static final class C1812h implements Runnable {

        /* renamed from: a */
        private final Context f5619a;

        /* renamed from: b */
        private final C1760ae f5620b;

        /* renamed from: c */
        private final C1761af f5621c;

        public C1812h(Context context, C1760ae aeVar, C1761af afVar) {
            this.f5619a = context;
            this.f5620b = aeVar;
            this.f5621c = afVar;
        }

        public void run() {
            if (C0020i.m93n(this.f5619a)) {
                C0135c.m449h().mo270a("CrashlyticsCore", "Attempting to send crash report at time of crash...");
                this.f5621c.mo7030a(this.f5620b);
            }
        }
    }

    /* renamed from: com.a.a.c.h$i */
    /* compiled from: CrashlyticsController */
    static class C1813i implements FilenameFilter {

        /* renamed from: a */
        private final String f5622a;

        public C1813i(String str) {
            this.f5622a = str;
        }

        public boolean accept(File file, String str) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f5622a);
            sb.append(".cls");
            boolean z = false;
            if (str.equals(sb.toString())) {
                return false;
            }
            if (str.contains(this.f5622a) && !str.endsWith(".cls_temp")) {
                z = true;
            }
            return z;
        }
    }

    C1791h(C1814i iVar, C1788g gVar, C0098e eVar, C0032o oVar, C1756ab abVar, C0103a aVar, C1746a aVar2, C1771ak akVar) {
        this.f5581i = iVar;
        this.f5582j = gVar;
        this.f5583k = eVar;
        this.f5584l = oVar;
        this.f5585m = abVar;
        this.f5586n = aVar;
        this.f5587o = aVar2;
        this.f5594v = akVar.mo7035a();
        Context q = iVar.mo320q();
        this.f5588p = new C1806d(aVar);
        this.f5589q = new C1835u(q, this.f5588p);
        this.f5590r = new C1810f();
        this.f5591s = new C1811g();
        this.f5592t = new C1829q(q);
        this.f5593u = new C1841x(1024, new C1759ad(10));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7092a(UncaughtExceptionHandler uncaughtExceptionHandler) {
        mo7088a();
        this.f5595w = new C1824m(new C1825a() {
            /* renamed from: a */
            public void mo7106a(Thread thread, Throwable th) {
                C1791h.this.mo7093a(thread, th);
            }
        }, uncaughtExceptionHandler);
        Thread.setDefaultUncaughtExceptionHandler(this.f5595w);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public synchronized void mo7093a(final Thread thread, final Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("Crashlytics is handling uncaught exception \"");
        sb.append(th);
        sb.append("\" from thread ");
        sb.append(thread.getName());
        C0135c.m449h().mo270a("CrashlyticsCore", sb.toString());
        this.f5592t.mo7158b();
        final Date date = new Date();
        this.f5582j.mo7083a((Callable<T>) new Callable<Void>() {
            /* renamed from: a */
            public Void call() throws Exception {
                C1791h.this.f5581i.mo7139n();
                C1791h.this.m7439a(date, thread, th);
                C0128t b = C0123q.m412a().mo264b();
                C0122p pVar = b != null ? b.f289b : null;
                C1791h.this.mo7096b(pVar);
                C1791h.this.m7465m();
                if (pVar != null) {
                    C1791h.this.mo7090a(pVar.f278g);
                }
                if (!C1791h.this.m7442a(b)) {
                    C1791h.this.m7449b(b);
                }
                return null;
            }
        });
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7089a(float f, C0128t tVar) {
        if (tVar == null) {
            C0135c.m449h().mo277d("CrashlyticsCore", "Could not send reports. Settings are not available.");
            return;
        }
        new C1761af(this.f5587o.f5472a, m7461h(tVar.f288a.f244d), this.f5590r, this.f5591s).mo7029a(f, m7442a(tVar) ? new C1807e(this.f5581i, this.f5585m, tVar.f290c) : new C1762a());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7088a() {
        this.f5582j.mo7085b(new Callable<Void>() {
            /* renamed from: a */
            public Void call() throws Exception {
                C1791h.this.m7465m();
                return null;
            }
        });
    }

    /* renamed from: k */
    private String m7463k() {
        File[] n = m7466n();
        if (n.length > 0) {
            return m7422a(n[0]);
        }
        return null;
    }

    /* renamed from: l */
    private String m7464l() {
        File[] n = m7466n();
        if (n.length > 1) {
            return m7422a(n[1]);
        }
        return null;
    }

    /* renamed from: a */
    static String m7422a(File file) {
        return file.getName().substring(0, 35);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo7095a(final C0122p pVar) {
        return ((Boolean) this.f5582j.mo7083a((Callable<T>) new Callable<Boolean>() {
            /* renamed from: a */
            public Boolean call() throws Exception {
                if (C1791h.this.mo7100e()) {
                    C0135c.m449h().mo270a("CrashlyticsCore", "Skipping session finalization because a crash has already occurred.");
                    return Boolean.FALSE;
                }
                C0135c.m449h().mo270a("CrashlyticsCore", "Finalizing previously open sessions.");
                C1791h.this.m7423a(pVar, true);
                C0135c.m449h().mo270a("CrashlyticsCore", "Closed all previously open sessions");
                return Boolean.TRUE;
            }
        })).booleanValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public void m7465m() throws Exception {
        Date date = new Date();
        String cVar = new C1777c(this.f5584l).toString();
        StringBuilder sb = new StringBuilder();
        sb.append("Opening a new session with ID ");
        sb.append(cVar);
        C0135c.m449h().mo270a("CrashlyticsCore", sb.toString());
        m7438a(cVar, date);
        m7456c(cVar);
        m7457d(cVar);
        m7458e(cVar);
        this.f5589q.mo7168a(cVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo7096b(C0122p pVar) throws Exception {
        m7423a(pVar, false);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Incorrect type for immutable var: ssa=boolean, code=int, for r4v0, types: [boolean, int] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m7423a(p000a.p001a.p002a.p003a.p004a.p012g.C0122p r3, int r4) throws java.lang.Exception {
        /*
            r2 = this;
            int r0 = r4 + 8
            r2.m7448b(r0)
            java.io.File[] r0 = r2.m7466n()
            int r1 = r0.length
            if (r1 > r4) goto L_0x0018
            a.a.a.a.l r3 = p000a.p001a.p002a.p003a.C0135c.m449h()
            java.lang.String r4 = "CrashlyticsCore"
            java.lang.String r0 = "No open sessions to be closed."
            r3.mo270a(r4, r0)
            return
        L_0x0018:
            r1 = r0[r4]
            java.lang.String r1 = m7422a(r1)
            r2.m7459f(r1)
            if (r3 != 0) goto L_0x002f
            a.a.a.a.l r3 = p000a.p001a.p002a.p003a.C0135c.m449h()
            java.lang.String r4 = "CrashlyticsCore"
            java.lang.String r0 = "Unable to close session. Settings are not loaded."
            r3.mo270a(r4, r0)
            return
        L_0x002f:
            int r3 = r3.f274c
            r2.m7440a(r0, r4, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p103a.p104a.p107c.C1791h.m7423a(a.a.a.a.a.g.p, boolean):void");
    }

    /* renamed from: a */
    private void m7440a(File[] fileArr, int i, int i2) {
        C0135c.m449h().mo270a("CrashlyticsCore", "Closing open sessions.");
        while (i < fileArr.length) {
            File file = fileArr[i];
            String a = m7422a(file);
            StringBuilder sb = new StringBuilder();
            sb.append("Closing session: ");
            sb.append(a);
            C0135c.m449h().mo270a("CrashlyticsCore", sb.toString());
            m7432a(file, a, i2);
            i++;
        }
    }

    /* renamed from: a */
    private void m7424a(C1778d dVar) {
        if (dVar != null) {
            try {
                dVar.mo7044a();
            } catch (IOException e) {
                C0135c.m449h().mo280e("CrashlyticsCore", "Error closing session file stream in the presence of an exception", e);
            }
        }
    }

    /* renamed from: a */
    private void m7435a(String str) {
        for (File delete : m7454b(str)) {
            delete.delete();
        }
    }

    /* renamed from: b */
    private File[] m7454b(String str) {
        return m7446a((FilenameFilter) new C1813i(str));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public File[] mo7097b() {
        LinkedList linkedList = new LinkedList();
        Collections.addAll(linkedList, m7445a(mo7102g(), f5573a));
        Collections.addAll(linkedList, m7445a(mo7103h(), f5573a));
        Collections.addAll(linkedList, m7445a(mo7101f(), f5573a));
        return (File[]) linkedList.toArray(new File[linkedList.size()]);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public File[] mo7098c() {
        return m7446a((FilenameFilter) new C1804b("BeginSession"));
    }

    /* renamed from: n */
    private File[] m7466n() {
        File[] c = mo7098c();
        Arrays.sort(c, f5574b);
        return c;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public File[] m7446a(FilenameFilter filenameFilter) {
        return m7445a(mo7101f(), filenameFilter);
    }

    /* renamed from: a */
    private File[] m7445a(File file, FilenameFilter filenameFilter) {
        return m7455b(file.listFiles(filenameFilter));
    }

    /* renamed from: b */
    private File[] m7453b(File file) {
        return m7455b(file.listFiles());
    }

    /* renamed from: b */
    private File[] m7455b(File[] fileArr) {
        return fileArr == null ? new File[0] : fileArr;
    }

    /* renamed from: a */
    private void m7436a(String str, int i) {
        File f = mo7101f();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("SessionEvent");
        C1773am.m7348a(f, new C1804b(sb.toString()), i, f5575c);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7090a(int i) {
        int a = i - C1773am.m7347a(mo7102g(), i, f5575c);
        C1773am.m7348a(mo7101f(), f5573a, a - C1773am.m7347a(mo7103h(), a, f5575c), f5575c);
    }

    /* renamed from: b */
    private void m7448b(int i) {
        HashSet hashSet = new HashSet();
        File[] n = m7466n();
        int min = Math.min(i, n.length);
        for (int i2 = 0; i2 < min; i2++) {
            hashSet.add(m7422a(n[i2]));
        }
        this.f5589q.mo7169a((Set<String>) hashSet);
        m7441a(m7446a((FilenameFilter) new C1803a()), (Set<String>) hashSet);
    }

    /* renamed from: a */
    private void m7441a(File[] fileArr, Set<String> set) {
        for (File file : fileArr) {
            String name = file.getName();
            Matcher matcher = f5577e.matcher(name);
            if (!matcher.matches()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Deleting unknown file: ");
                sb.append(name);
                C0135c.m449h().mo270a("CrashlyticsCore", sb.toString());
                file.delete();
                return;
            }
            if (!set.contains(matcher.group(1))) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Trimming session file: ");
                sb2.append(name);
                C0135c.m449h().mo270a("CrashlyticsCore", sb2.toString());
                file.delete();
            }
        }
    }

    /* renamed from: a */
    private File[] m7447a(String str, File[] fileArr, int i) {
        if (fileArr.length <= i) {
            return fileArr;
        }
        C0135c.m449h().mo270a("CrashlyticsCore", String.format(Locale.US, "Trimming down to %d logged exceptions.", new Object[]{Integer.valueOf(i)}));
        m7436a(str, i);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("SessionEvent");
        return m7446a((FilenameFilter) new C1804b(sb.toString()));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo7099d() {
        this.f5582j.mo7084a((Runnable) new Runnable() {
            public void run() {
                C1791h.this.mo7094a(C1791h.this.m7446a((FilenameFilter) new C1805c()));
            }
        });
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7094a(File[] fileArr) {
        File[] a;
        final HashSet hashSet = new HashSet();
        for (File file : fileArr) {
            StringBuilder sb = new StringBuilder();
            sb.append("Found invalid session part file: ");
            sb.append(file);
            C0135c.m449h().mo270a("CrashlyticsCore", sb.toString());
            hashSet.add(m7422a(file));
        }
        if (!hashSet.isEmpty()) {
            File i = mo7104i();
            if (!i.exists()) {
                i.mkdir();
            }
            for (File file2 : m7446a((FilenameFilter) new FilenameFilter() {
                public boolean accept(File file, String str) {
                    if (str.length() < 35) {
                        return false;
                    }
                    return hashSet.contains(str.substring(0, 35));
                }
            })) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Moving session file: ");
                sb2.append(file2);
                C0135c.m449h().mo270a("CrashlyticsCore", sb2.toString());
                if (!file2.renameTo(new File(i, file2.getName()))) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Could not move session file. Deleting ");
                    sb3.append(file2);
                    C0135c.m449h().mo270a("CrashlyticsCore", sb3.toString());
                    file2.delete();
                }
            }
            m7467o();
        }
    }

    /* renamed from: o */
    private void m7467o() {
        File i = mo7104i();
        if (i.exists()) {
            File[] a = m7445a(i, (FilenameFilter) new C1805c());
            Arrays.sort(a, Collections.reverseOrder());
            HashSet hashSet = new HashSet();
            for (int i2 = 0; i2 < a.length && hashSet.size() < 4; i2++) {
                hashSet.add(m7422a(a[i2]));
            }
            m7441a(m7453b(i), (Set<String>) hashSet);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7439a(Date date, Thread thread, Throwable th) {
        C1778d dVar;
        C1780e eVar = null;
        try {
            String k = m7463k();
            if (k == null) {
                C0135c.m449h().mo280e("CrashlyticsCore", "Tried to write a fatal exception while no session was open.", null);
                C0020i.m71a((Flushable) null, "Failed to flush to session begin file.");
                C0020i.m70a((Closeable) null, "Failed to close fatal exception file output stream.");
                return;
            }
            m7437a(k, th.getClass().getName());
            File f = mo7101f();
            StringBuilder sb = new StringBuilder();
            sb.append(k);
            sb.append("SessionCrash");
            dVar = new C1778d(f, sb.toString());
            try {
                C1780e a = C1780e.m7361a((OutputStream) dVar);
                try {
                    m7427a(a, date, thread, th, AppMeasurement.CRASH_ORIGIN, true);
                    C0020i.m71a((Flushable) a, "Failed to flush to session begin file.");
                } catch (Exception e) {
                    e = e;
                    eVar = a;
                    try {
                        C0135c.m449h().mo280e("CrashlyticsCore", "An error occurred in the fatal exception logger", e);
                        C0020i.m71a((Flushable) eVar, "Failed to flush to session begin file.");
                        C0020i.m70a((Closeable) dVar, "Failed to close fatal exception file output stream.");
                    } catch (Throwable th2) {
                        th = th2;
                        C0020i.m71a((Flushable) eVar, "Failed to flush to session begin file.");
                        C0020i.m70a((Closeable) dVar, "Failed to close fatal exception file output stream.");
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    eVar = a;
                    C0020i.m71a((Flushable) eVar, "Failed to flush to session begin file.");
                    C0020i.m70a((Closeable) dVar, "Failed to close fatal exception file output stream.");
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                C0135c.m449h().mo280e("CrashlyticsCore", "An error occurred in the fatal exception logger", e);
                C0020i.m71a((Flushable) eVar, "Failed to flush to session begin file.");
                C0020i.m70a((Closeable) dVar, "Failed to close fatal exception file output stream.");
            }
            C0020i.m70a((Closeable) dVar, "Failed to close fatal exception file output stream.");
        } catch (Exception e3) {
            e = e3;
            dVar = null;
            C0135c.m449h().mo280e("CrashlyticsCore", "An error occurred in the fatal exception logger", e);
            C0020i.m71a((Flushable) eVar, "Failed to flush to session begin file.");
            C0020i.m70a((Closeable) dVar, "Failed to close fatal exception file output stream.");
        } catch (Throwable th4) {
            th = th4;
            dVar = null;
            C0020i.m71a((Flushable) eVar, "Failed to flush to session begin file.");
            C0020i.m70a((Closeable) dVar, "Failed to close fatal exception file output stream.");
            throw th;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7091a(final C1751d dVar) {
        this.f5582j.mo7085b(new Callable<Void>() {
            /* renamed from: a */
            public Void call() throws Exception {
                if (!C1791h.this.mo7100e()) {
                    C1791h.this.m7450b(dVar);
                }
                return null;
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m7450b(C1751d dVar) throws IOException {
        C1778d dVar2;
        C1780e eVar = null;
        try {
            String l = m7464l();
            if (l == null) {
                C0135c.m449h().mo280e("CrashlyticsCore", "Tried to write a native crash while no session was open.", null);
                C0020i.m71a((Flushable) null, "Failed to flush to session begin file.");
                C0020i.m70a((Closeable) null, "Failed to close fatal exception file output stream.");
                return;
            }
            boolean z = false;
            m7437a(l, String.format(Locale.US, "<native-crash [%s (%s)]>", new Object[]{dVar.f5493b.f5499b, dVar.f5493b.f5498a}));
            if (dVar.f5495d != null && dVar.f5495d.length > 0) {
                z = true;
            }
            String str = z ? "SessionCrash" : "SessionMissingBinaryImages";
            File f = mo7101f();
            StringBuilder sb = new StringBuilder();
            sb.append(l);
            sb.append(str);
            dVar2 = new C1778d(f, sb.toString());
            try {
                C1780e a = C1780e.m7361a((OutputStream) dVar2);
                try {
                    C1843z.m7587a(dVar, new C1835u(this.f5581i.mo320q(), this.f5588p, l), new C1840w(mo7101f()).mo7172b(l), a);
                    C0020i.m71a((Flushable) a, "Failed to flush to session begin file.");
                } catch (Exception e) {
                    e = e;
                    eVar = a;
                    try {
                        C0135c.m449h().mo280e("CrashlyticsCore", "An error occurred in the native crash logger", e);
                        C0020i.m71a((Flushable) eVar, "Failed to flush to session begin file.");
                        C0020i.m70a((Closeable) dVar2, "Failed to close fatal exception file output stream.");
                    } catch (Throwable th) {
                        th = th;
                        C0020i.m71a((Flushable) eVar, "Failed to flush to session begin file.");
                        C0020i.m70a((Closeable) dVar2, "Failed to close fatal exception file output stream.");
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    eVar = a;
                    C0020i.m71a((Flushable) eVar, "Failed to flush to session begin file.");
                    C0020i.m70a((Closeable) dVar2, "Failed to close fatal exception file output stream.");
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                C0135c.m449h().mo280e("CrashlyticsCore", "An error occurred in the native crash logger", e);
                C0020i.m71a((Flushable) eVar, "Failed to flush to session begin file.");
                C0020i.m70a((Closeable) dVar2, "Failed to close fatal exception file output stream.");
            }
            C0020i.m70a((Closeable) dVar2, "Failed to close fatal exception file output stream.");
        } catch (Exception e3) {
            e = e3;
            dVar2 = null;
            C0135c.m449h().mo280e("CrashlyticsCore", "An error occurred in the native crash logger", e);
            C0020i.m71a((Flushable) eVar, "Failed to flush to session begin file.");
            C0020i.m70a((Closeable) dVar2, "Failed to close fatal exception file output stream.");
        } catch (Throwable th3) {
            th = th3;
            dVar2 = null;
            C0020i.m71a((Flushable) eVar, "Failed to flush to session begin file.");
            C0020i.m70a((Closeable) dVar2, "Failed to close fatal exception file output stream.");
            throw th;
        }
    }

    /* renamed from: a */
    private void m7438a(String str, Date date) throws Exception {
        C1778d dVar;
        C1780e a;
        C1780e eVar = null;
        try {
            File f = mo7101f();
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("BeginSession");
            dVar = new C1778d(f, sb.toString());
            try {
                a = C1780e.m7361a((OutputStream) dVar);
            } catch (Throwable th) {
                th = th;
                C0020i.m71a((Flushable) eVar, "Failed to flush to session begin file.");
                C0020i.m70a((Closeable) dVar, "Failed to close begin session file.");
                throw th;
            }
            try {
                C1767ag.m7331a(a, str, String.format(Locale.US, "Crashlytics Android SDK/%s", new Object[]{this.f5581i.mo309a()}), date.getTime() / 1000);
                C0020i.m71a((Flushable) a, "Failed to flush to session begin file.");
                C0020i.m70a((Closeable) dVar, "Failed to close begin session file.");
            } catch (Throwable th2) {
                th = th2;
                eVar = a;
                C0020i.m71a((Flushable) eVar, "Failed to flush to session begin file.");
                C0020i.m70a((Closeable) dVar, "Failed to close begin session file.");
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            dVar = null;
            C0020i.m71a((Flushable) eVar, "Failed to flush to session begin file.");
            C0020i.m70a((Closeable) dVar, "Failed to close begin session file.");
            throw th;
        }
    }

    /* renamed from: c */
    private void m7456c(String str) throws Exception {
        C1780e eVar;
        C1778d dVar;
        Throwable th;
        try {
            File f = mo7101f();
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("SessionApp");
            dVar = new C1778d(f, sb.toString());
            try {
                eVar = C1780e.m7361a((OutputStream) dVar);
            } catch (Throwable th2) {
                th = th2;
                eVar = null;
                C0020i.m71a((Flushable) eVar, "Failed to flush to session app file.");
                C0020i.m70a((Closeable) dVar, "Failed to close session app file.");
                throw th;
            }
            try {
                C1780e eVar2 = eVar;
                C1767ag.m7333a(eVar2, this.f5584l.mo56c(), this.f5587o.f5472a, this.f5587o.f5476e, this.f5587o.f5477f, this.f5584l.mo55b(), C0026l.m99a(this.f5587o.f5474c).mo50a(), this.f5594v);
                C0020i.m71a((Flushable) eVar, "Failed to flush to session app file.");
                C0020i.m70a((Closeable) dVar, "Failed to close session app file.");
            } catch (Throwable th3) {
                th = th3;
                C0020i.m71a((Flushable) eVar, "Failed to flush to session app file.");
                C0020i.m70a((Closeable) dVar, "Failed to close session app file.");
                throw th;
            }
        } catch (Throwable th4) {
            dVar = null;
            th = th4;
            eVar = null;
            C0020i.m71a((Flushable) eVar, "Failed to flush to session app file.");
            C0020i.m70a((Closeable) dVar, "Failed to close session app file.");
            throw th;
        }
    }

    /* renamed from: d */
    private void m7457d(String str) throws Exception {
        C1778d dVar;
        C1780e a;
        C1780e eVar = null;
        try {
            File f = mo7101f();
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("SessionOS");
            dVar = new C1778d(f, sb.toString());
            try {
                a = C1780e.m7361a((OutputStream) dVar);
            } catch (Throwable th) {
                th = th;
                C0020i.m71a((Flushable) eVar, "Failed to flush to session OS file.");
                C0020i.m70a((Closeable) dVar, "Failed to close session OS file.");
                throw th;
            }
            try {
                C1767ag.m7336a(a, C0020i.m86g(this.f5581i.mo320q()));
                C0020i.m71a((Flushable) a, "Failed to flush to session OS file.");
                C0020i.m70a((Closeable) dVar, "Failed to close session OS file.");
            } catch (Throwable th2) {
                Throwable th3 = th2;
                eVar = a;
                th = th3;
                C0020i.m71a((Flushable) eVar, "Failed to flush to session OS file.");
                C0020i.m70a((Closeable) dVar, "Failed to close session OS file.");
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            dVar = null;
            C0020i.m71a((Flushable) eVar, "Failed to flush to session OS file.");
            C0020i.m70a((Closeable) dVar, "Failed to close session OS file.");
            throw th;
        }
    }

    /* renamed from: e */
    private void m7458e(String str) throws Exception {
        C1780e eVar;
        C1778d dVar;
        try {
            File f = mo7101f();
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("SessionDevice");
            dVar = new C1778d(f, sb.toString());
            try {
                eVar = C1780e.m7361a((OutputStream) dVar);
            } catch (Throwable th) {
                th = th;
                eVar = null;
                C0020i.m71a((Flushable) eVar, "Failed to flush session device info.");
                C0020i.m70a((Closeable) dVar, "Failed to close session device file.");
                throw th;
            }
            try {
                Context q = this.f5581i.mo320q();
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                C1780e eVar2 = eVar;
                C1767ag.m7330a(eVar2, this.f5584l.mo61h(), C0020i.m52a(), Build.MODEL, Runtime.getRuntime().availableProcessors(), C0020i.m74b(), ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize()), C0020i.m85f(q), this.f5584l.mo62i(), C0020i.m87h(q), Build.MANUFACTURER, Build.PRODUCT);
                C0020i.m71a((Flushable) eVar, "Failed to flush session device info.");
                C0020i.m70a((Closeable) dVar, "Failed to close session device file.");
            } catch (Throwable th2) {
                th = th2;
                C0020i.m71a((Flushable) eVar, "Failed to flush session device info.");
                C0020i.m70a((Closeable) dVar, "Failed to close session device file.");
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            dVar = null;
            eVar = null;
            C0020i.m71a((Flushable) eVar, "Failed to flush session device info.");
            C0020i.m70a((Closeable) dVar, "Failed to close session device file.");
            throw th;
        }
    }

    /* renamed from: f */
    private void m7459f(String str) throws Exception {
        C1778d dVar;
        C1780e a;
        C1780e eVar = null;
        try {
            File f = mo7101f();
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("SessionUser");
            dVar = new C1778d(f, sb.toString());
            try {
                a = C1780e.m7361a((OutputStream) dVar);
            } catch (Throwable th) {
                th = th;
                C0020i.m71a((Flushable) eVar, "Failed to flush session user file.");
                C0020i.m70a((Closeable) dVar, "Failed to close session user file.");
                throw th;
            }
            try {
                C1772al g = m7460g(str);
                if (g.mo7036a()) {
                    C0020i.m71a((Flushable) a, "Failed to flush session user file.");
                    C0020i.m70a((Closeable) dVar, "Failed to close session user file.");
                    return;
                }
                C1767ag.m7332a(a, g.f5538b, g.f5539c, g.f5540d);
                C0020i.m71a((Flushable) a, "Failed to flush session user file.");
                C0020i.m70a((Closeable) dVar, "Failed to close session user file.");
            } catch (Throwable th2) {
                th = th2;
                eVar = a;
                C0020i.m71a((Flushable) eVar, "Failed to flush session user file.");
                C0020i.m70a((Closeable) dVar, "Failed to close session user file.");
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            dVar = null;
            C0020i.m71a((Flushable) eVar, "Failed to flush session user file.");
            C0020i.m70a((Closeable) dVar, "Failed to close session user file.");
            throw th;
        }
    }

    /* JADX WARNING: type inference failed for: r6v2, types: [boolean] */
    /* JADX WARNING: type inference failed for: r6v4 */
    /* JADX WARNING: type inference failed for: r6v5 */
    /* JADX WARNING: type inference failed for: r6v8 */
    /* JADX WARNING: type inference failed for: r6v9 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r6v2, types: [boolean]
      assigns: []
      uses: [boolean, ?[int, byte, short, char]]
      mth insns count: 75
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m7427a(com.p103a.p104a.p107c.C1780e r25, java.util.Date r26, java.lang.Thread r27, java.lang.Throwable r28, java.lang.String r29, boolean r30) throws java.lang.Exception {
        /*
            r24 = this;
            r0 = r24
            com.a.a.c.aj r5 = new com.a.a.c.aj
            com.a.a.c.ai r1 = r0.f5593u
            r2 = r28
            r5.<init>(r2, r1)
            com.a.a.c.i r1 = r0.f5581i
            android.content.Context r1 = r1.mo320q()
            long r2 = r26.getTime()
            r6 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 / r6
            java.lang.Float r16 = p000a.p001a.p002a.p003a.p004a.p006b.C0020i.m79c(r1)
            com.a.a.c.q r4 = r0.f5592t
            boolean r4 = r4.mo7157a()
            int r17 = p000a.p001a.p002a.p003a.p004a.p006b.C0020i.m54a(r1, r4)
            boolean r18 = p000a.p001a.p002a.p003a.p004a.p006b.C0020i.m83d(r1)
            android.content.res.Resources r4 = r1.getResources()
            android.content.res.Configuration r4 = r4.getConfiguration()
            int r13 = r4.orientation
            long r6 = p000a.p001a.p002a.p003a.p004a.p006b.C0020i.m74b()
            long r8 = p000a.p001a.p002a.p003a.p004a.p006b.C0020i.m75b(r1)
            long r19 = r6 - r8
            java.io.File r4 = android.os.Environment.getDataDirectory()
            java.lang.String r4 = r4.getPath()
            long r21 = p000a.p001a.p002a.p003a.p004a.p006b.C0020i.m76b(r4)
            java.lang.String r4 = r1.getPackageName()
            android.app.ActivityManager$RunningAppProcessInfo r12 = p000a.p001a.p002a.p003a.p004a.p006b.C0020i.m56a(r4, r1)
            java.util.LinkedList r9 = new java.util.LinkedList
            r9.<init>()
            java.lang.StackTraceElement[] r7 = r5.f5535c
            com.a.a.c.a r4 = r0.f5587o
            java.lang.String r15 = r4.f5473b
            a.a.a.a.a.b.o r4 = r0.f5584l
            java.lang.String r14 = r4.mo56c()
            r4 = 0
            if (r30 == 0) goto L_0x00a1
            java.util.Map r8 = java.lang.Thread.getAllStackTraces()
            int r10 = r8.size()
            java.lang.Thread[] r10 = new java.lang.Thread[r10]
            java.util.Set r8 = r8.entrySet()
            java.util.Iterator r8 = r8.iterator()
        L_0x0078:
            boolean r11 = r8.hasNext()
            if (r11 == 0) goto L_0x009e
            java.lang.Object r11 = r8.next()
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11
            java.lang.Object r23 = r11.getKey()
            java.lang.Thread r23 = (java.lang.Thread) r23
            r10[r4] = r23
            com.a.a.c.ai r6 = r0.f5593u
            java.lang.Object r11 = r11.getValue()
            java.lang.StackTraceElement[] r11 = (java.lang.StackTraceElement[]) r11
            java.lang.StackTraceElement[] r6 = r6.mo7021a(r11)
            r9.add(r6)
            r6 = 1
            int r4 = r4 + r6
            goto L_0x0078
        L_0x009e:
            r6 = 1
            r8 = r10
            goto L_0x00a5
        L_0x00a1:
            r6 = 1
            java.lang.Thread[] r4 = new java.lang.Thread[r4]
            r8 = r4
        L_0x00a5:
            java.lang.String r4 = "com.crashlytics.CollectCustomKeys"
            boolean r1 = p000a.p001a.p002a.p003a.p004a.p006b.C0020i.m73a(r1, r4, r6)
            if (r1 != 0) goto L_0x00b4
            java.util.TreeMap r1 = new java.util.TreeMap
            r1.<init>()
        L_0x00b2:
            r10 = r1
            goto L_0x00c8
        L_0x00b4:
            com.a.a.c.i r1 = r0.f5581i
            java.util.Map r1 = r1.mo7131f()
            if (r1 == 0) goto L_0x00b2
            int r4 = r1.size()
            if (r4 <= r6) goto L_0x00b2
            java.util.TreeMap r4 = new java.util.TreeMap
            r4.<init>(r1)
            r10 = r4
        L_0x00c8:
            com.a.a.c.u r11 = r0.f5589q
            r1 = r25
            r4 = r29
            r6 = r27
            com.p103a.p104a.p107c.C1767ag.m7324a(r1, r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r21)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p103a.p104a.p107c.C1791h.m7427a(com.a.a.c.e, java.util.Date, java.lang.Thread, java.lang.Throwable, java.lang.String, boolean):void");
    }

    /* renamed from: a */
    private void m7432a(File file, String str, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("Collecting session parts for ID ");
        sb.append(str);
        C0135c.m449h().mo270a("CrashlyticsCore", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append("SessionCrash");
        File[] a = m7446a((FilenameFilter) new C1804b(sb2.toString()));
        boolean z = a != null && a.length > 0;
        C0135c.m449h().mo270a("CrashlyticsCore", String.format(Locale.US, "Session %s has fatal exception: %s", new Object[]{str, Boolean.valueOf(z)}));
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str);
        sb3.append("SessionEvent");
        File[] a2 = m7446a((FilenameFilter) new C1804b(sb3.toString()));
        boolean z2 = a2 != null && a2.length > 0;
        C0135c.m449h().mo270a("CrashlyticsCore", String.format(Locale.US, "Session %s has non-fatal exceptions: %s", new Object[]{str, Boolean.valueOf(z2)}));
        if (z || z2) {
            m7433a(file, str, m7447a(str, a2, i), z ? a[0] : null);
        } else {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("No events present for session ID ");
            sb4.append(str);
            C0135c.m449h().mo270a("CrashlyticsCore", sb4.toString());
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Removing session part files for ID ");
        sb5.append(str);
        C0135c.m449h().mo270a("CrashlyticsCore", sb5.toString());
        m7435a(str);
    }

    /* renamed from: a */
    private void m7433a(File file, String str, File[] fileArr, File file2) {
        C1778d dVar;
        C1780e eVar;
        boolean z = file2 != null;
        File g = z ? mo7102g() : mo7103h();
        if (!g.exists()) {
            g.mkdirs();
        }
        C1780e eVar2 = null;
        try {
            dVar = new C1778d(g, str);
            try {
                eVar = C1780e.m7361a((OutputStream) dVar);
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Collecting SessionStart data for session ID ");
                    sb.append(str);
                    C0135c.m449h().mo270a("CrashlyticsCore", sb.toString());
                    m7425a(eVar, file);
                    eVar.mo7052a(4, new Date().getTime() / 1000);
                    eVar.mo7054a(5, z);
                    eVar.mo7051a(11, 1);
                    eVar.mo7062b(12, 3);
                    m7426a(eVar, str);
                    m7428a(eVar, fileArr, str);
                    if (z) {
                        m7425a(eVar, file2);
                    }
                    C0020i.m71a((Flushable) eVar, "Error flushing session file stream");
                    C0020i.m70a((Closeable) dVar, "Failed to close CLS file");
                } catch (Exception e) {
                    e = e;
                    eVar2 = eVar;
                    try {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Failed to write session file for session ID: ");
                        sb2.append(str);
                        C0135c.m449h().mo280e("CrashlyticsCore", sb2.toString(), e);
                        C0020i.m71a((Flushable) eVar2, "Error flushing session file stream");
                        m7424a(dVar);
                    } catch (Throwable th) {
                        th = th;
                        eVar = eVar2;
                        C0020i.m71a((Flushable) eVar, "Error flushing session file stream");
                        C0020i.m70a((Closeable) dVar, "Failed to close CLS file");
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    C0020i.m71a((Flushable) eVar, "Error flushing session file stream");
                    C0020i.m70a((Closeable) dVar, "Failed to close CLS file");
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                StringBuilder sb22 = new StringBuilder();
                sb22.append("Failed to write session file for session ID: ");
                sb22.append(str);
                C0135c.m449h().mo280e("CrashlyticsCore", sb22.toString(), e);
                C0020i.m71a((Flushable) eVar2, "Error flushing session file stream");
                m7424a(dVar);
            }
        } catch (Exception e3) {
            e = e3;
            dVar = null;
            StringBuilder sb222 = new StringBuilder();
            sb222.append("Failed to write session file for session ID: ");
            sb222.append(str);
            C0135c.m449h().mo280e("CrashlyticsCore", sb222.toString(), e);
            C0020i.m71a((Flushable) eVar2, "Error flushing session file stream");
            m7424a(dVar);
        } catch (Throwable th3) {
            th = th3;
            eVar = null;
            dVar = null;
            C0020i.m71a((Flushable) eVar, "Error flushing session file stream");
            C0020i.m70a((Closeable) dVar, "Failed to close CLS file");
            throw th;
        }
    }

    /* renamed from: a */
    private static void m7428a(C1780e eVar, File[] fileArr, String str) {
        Arrays.sort(fileArr, C0020i.f25a);
        for (File file : fileArr) {
            try {
                C0135c.m449h().mo270a("CrashlyticsCore", String.format(Locale.US, "Found Non Fatal for session ID %s in %s ", new Object[]{str, file.getName()}));
                m7425a(eVar, file);
            } catch (Exception e) {
                C0135c.m449h().mo280e("CrashlyticsCore", "Error writting non-fatal to session.", e);
            }
        }
    }

    /* renamed from: a */
    private void m7426a(C1780e eVar, String str) throws IOException {
        String[] strArr;
        for (String str2 : f5579g) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(str2);
            File[] a = m7446a((FilenameFilter) new C1804b(sb.toString()));
            if (a.length == 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Can't find ");
                sb2.append(str2);
                sb2.append(" data for session ID ");
                sb2.append(str);
                C0135c.m449h().mo280e("CrashlyticsCore", sb2.toString(), null);
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Collecting ");
                sb3.append(str2);
                sb3.append(" data for session ID ");
                sb3.append(str);
                C0135c.m449h().mo270a("CrashlyticsCore", sb3.toString());
                m7425a(eVar, a[0]);
            }
        }
    }

    /* renamed from: a */
    private static void m7425a(C1780e eVar, File file) throws IOException {
        FileInputStream fileInputStream;
        if (!file.exists()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Tried to include a file that doesn't exist: ");
            sb.append(file.getName());
            C0135c.m449h().mo280e("CrashlyticsCore", sb.toString(), null);
            return;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                m7434a((InputStream) fileInputStream, eVar, (int) file.length());
                C0020i.m70a((Closeable) fileInputStream, "Failed to close file input stream.");
            } catch (Throwable th) {
                th = th;
                C0020i.m70a((Closeable) fileInputStream, "Failed to close file input stream.");
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            C0020i.m70a((Closeable) fileInputStream, "Failed to close file input stream.");
            throw th;
        }
    }

    /* renamed from: a */
    private static void m7434a(InputStream inputStream, C1780e eVar, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < bArr.length) {
            int read = inputStream.read(bArr, i2, bArr.length - i2);
            if (read < 0) {
                break;
            }
            i2 += read;
        }
        eVar.mo7059a(bArr);
    }

    /* renamed from: g */
    private C1772al m7460g(String str) {
        if (mo7100e()) {
            return new C1772al(this.f5581i.mo7132g(), this.f5581i.mo7134i(), this.f5581i.mo7133h());
        }
        return new C1840w(mo7101f()).mo7171a(str);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public boolean mo7100e() {
        return this.f5595w != null && this.f5595w.mo7154a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public File mo7101f() {
        return this.f5586n.mo243a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public File mo7102g() {
        return new File(mo7101f(), "fatal-sessions");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public File mo7103h() {
        return new File(mo7101f(), "nonfatal-sessions");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public File mo7104i() {
        return new File(mo7101f(), "invalidClsFiles");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m7442a(C0128t tVar) {
        boolean z = false;
        if (tVar == null) {
            return false;
        }
        if (tVar.f291d.f257a && !this.f5585m.mo7017a()) {
            z = true;
        }
        return z;
    }

    /* renamed from: h */
    private C1827o m7461h(String str) {
        return new C1828p(this.f5581i, C0020i.m77b(this.f5581i.mo320q(), "com.crashlytics.ApiEndpoint"), str, this.f5583k);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m7449b(C0128t tVar) {
        if (tVar == null) {
            C0135c.m449h().mo277d("CrashlyticsCore", "Cannot send reports. Settings are unavailable.");
            return;
        }
        Context q = this.f5581i.mo320q();
        C1761af afVar = new C1761af(this.f5587o.f5472a, m7461h(tVar.f288a.f244d), this.f5590r, this.f5591s);
        for (File ahVar : mo7097b()) {
            this.f5582j.mo7084a((Runnable) new C1812h(q, new C1768ah(ahVar, f5578f), afVar));
        }
    }

    /* renamed from: a */
    private static void m7437a(String str, String str2) {
        C1700a aVar = (C1700a) C0135c.m440a(C1700a.class);
        if (aVar == null) {
            C0135c.m449h().mo270a("CrashlyticsCore", "Answers is not available");
        } else {
            aVar.mo6943a(new C0024a(str, str2));
        }
    }
}
