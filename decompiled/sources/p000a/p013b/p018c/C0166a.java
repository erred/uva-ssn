package p000a.p013b.p018c;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

/* renamed from: a.b.c.a */
/* compiled from: CompositeException */
public final class C0166a extends RuntimeException {

    /* renamed from: a */
    private final List<Throwable> f383a;

    /* renamed from: b */
    private final String f384b;

    /* renamed from: c */
    private Throwable f385c;

    /* renamed from: a.b.c.a$a */
    /* compiled from: CompositeException */
    static final class C0167a extends RuntimeException {
        public String getMessage() {
            return "Chain of Causes for CompositeException In Order Received =>";
        }

        C0167a() {
        }
    }

    /* renamed from: a.b.c.a$b */
    /* compiled from: CompositeException */
    static abstract class C0168b {
        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public abstract void mo373a(Object obj);

        C0168b() {
        }
    }

    /* renamed from: a.b.c.a$c */
    /* compiled from: CompositeException */
    static final class C0169c extends C0168b {

        /* renamed from: a */
        private final PrintStream f386a;

        C0169c(PrintStream printStream) {
            this.f386a = printStream;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo373a(Object obj) {
            this.f386a.println(obj);
        }
    }

    /* renamed from: a.b.c.a$d */
    /* compiled from: CompositeException */
    static final class C0170d extends C0168b {

        /* renamed from: a */
        private final PrintWriter f387a;

        C0170d(PrintWriter printWriter) {
            this.f387a = printWriter;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo373a(Object obj) {
            this.f387a.println(obj);
        }
    }

    public C0166a(Throwable... thArr) {
        this((Iterable<? extends Throwable>) thArr == null ? Collections.singletonList(new NullPointerException("exceptions was null")) : Arrays.asList(thArr));
    }

    public C0166a(Iterable<? extends Throwable> iterable) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        if (iterable != null) {
            for (Throwable th : iterable) {
                if (th instanceof C0166a) {
                    linkedHashSet.addAll(((C0166a) th).mo366a());
                } else if (th != null) {
                    linkedHashSet.add(th);
                } else {
                    linkedHashSet.add(new NullPointerException("Throwable was null!"));
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException("errors was null"));
        }
        if (!linkedHashSet.isEmpty()) {
            arrayList.addAll(linkedHashSet);
            this.f383a = Collections.unmodifiableList(arrayList);
            StringBuilder sb = new StringBuilder();
            sb.append(this.f383a.size());
            sb.append(" exceptions occurred. ");
            this.f384b = sb.toString();
            return;
        }
        throw new IllegalArgumentException("errors is empty");
    }

    /* renamed from: a */
    public List<Throwable> mo366a() {
        return this.f383a;
    }

    public String getMessage() {
        return this.f384b;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:10|(4:13|(2:15|33)(2:16|34)|32|11)|17|18|19|20|31) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0055 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.Throwable getCause() {
        /*
            r8 = this;
            monitor-enter(r8)
            java.lang.Throwable r0 = r8.f385c     // Catch:{ all -> 0x0060 }
            if (r0 != 0) goto L_0x005c
            a.b.c.a$a r0 = new a.b.c.a$a     // Catch:{ all -> 0x0060 }
            r0.<init>()     // Catch:{ all -> 0x0060 }
            java.util.HashSet r1 = new java.util.HashSet     // Catch:{ all -> 0x0060 }
            r1.<init>()     // Catch:{ all -> 0x0060 }
            java.util.List<java.lang.Throwable> r2 = r8.f383a     // Catch:{ all -> 0x0060 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0060 }
            r3 = r0
        L_0x0016:
            boolean r4 = r2.hasNext()     // Catch:{ all -> 0x0060 }
            if (r4 == 0) goto L_0x005a
            java.lang.Object r4 = r2.next()     // Catch:{ all -> 0x0060 }
            java.lang.Throwable r4 = (java.lang.Throwable) r4     // Catch:{ all -> 0x0060 }
            boolean r5 = r1.contains(r4)     // Catch:{ all -> 0x0060 }
            if (r5 == 0) goto L_0x0029
            goto L_0x0016
        L_0x0029:
            r1.add(r4)     // Catch:{ all -> 0x0060 }
            java.util.List r5 = r8.m577b(r4)     // Catch:{ all -> 0x0060 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x0060 }
        L_0x0034:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x0060 }
            if (r6 == 0) goto L_0x0052
            java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x0060 }
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ all -> 0x0060 }
            boolean r7 = r1.contains(r6)     // Catch:{ all -> 0x0060 }
            if (r7 == 0) goto L_0x004e
            java.lang.RuntimeException r4 = new java.lang.RuntimeException     // Catch:{ all -> 0x0060 }
            java.lang.String r6 = "Duplicate found in causal chain so cropping to prevent loop ..."
            r4.<init>(r6)     // Catch:{ all -> 0x0060 }
            goto L_0x0034
        L_0x004e:
            r1.add(r6)     // Catch:{ all -> 0x0060 }
            goto L_0x0034
        L_0x0052:
            r3.initCause(r4)     // Catch:{ Throwable -> 0x0055 }
        L_0x0055:
            java.lang.Throwable r3 = r8.mo365a(r3)     // Catch:{ all -> 0x0060 }
            goto L_0x0016
        L_0x005a:
            r8.f385c = r0     // Catch:{ all -> 0x0060 }
        L_0x005c:
            java.lang.Throwable r0 = r8.f385c     // Catch:{ all -> 0x0060 }
            monitor-exit(r8)
            return r0
        L_0x0060:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p013b.p018c.C0166a.getCause():java.lang.Throwable");
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public void printStackTrace(PrintStream printStream) {
        m575a((C0168b) new C0169c(printStream));
    }

    public void printStackTrace(PrintWriter printWriter) {
        m575a((C0168b) new C0170d(printWriter));
    }

    /* renamed from: a */
    private void m575a(C0168b bVar) {
        StackTraceElement[] stackTrace;
        StringBuilder sb = new StringBuilder(128);
        sb.append(this);
        sb.append(10);
        for (StackTraceElement stackTraceElement : getStackTrace()) {
            sb.append("\tat ");
            sb.append(stackTraceElement);
            sb.append(10);
        }
        int i = 1;
        for (Throwable th : this.f383a) {
            sb.append("  ComposedException ");
            sb.append(i);
            sb.append(" :\n");
            m576a(sb, th, "\t");
            i++;
        }
        bVar.mo373a(sb.toString());
    }

    /* renamed from: a */
    private void m576a(StringBuilder sb, Throwable th, String str) {
        StackTraceElement[] stackTrace;
        sb.append(str);
        sb.append(th);
        sb.append(10);
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            sb.append("\t\tat ");
            sb.append(stackTraceElement);
            sb.append(10);
        }
        if (th.getCause() != null) {
            sb.append("\tCaused by: ");
            m576a(sb, th.getCause(), "");
        }
    }

    /* renamed from: b */
    private List<Throwable> m577b(Throwable th) {
        ArrayList arrayList = new ArrayList();
        Throwable cause = th.getCause();
        if (cause == null || cause == th) {
            return arrayList;
        }
        while (true) {
            arrayList.add(cause);
            Throwable cause2 = cause.getCause();
            if (cause2 == null || cause2 == cause) {
                return arrayList;
            }
            cause = cause2;
        }
        return arrayList;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Throwable mo365a(Throwable th) {
        Throwable cause = th.getCause();
        if (cause == null || this.f385c == cause) {
            return th;
        }
        while (true) {
            Throwable cause2 = cause.getCause();
            if (cause2 == null || cause2 == cause) {
                return cause;
            }
            cause = cause2;
        }
        return cause;
    }
}
