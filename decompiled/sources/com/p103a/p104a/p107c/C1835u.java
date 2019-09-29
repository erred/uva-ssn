package com.p103a.p104a.p107c;

import android.content.Context;
import java.io.File;
import java.util.Set;
import p000a.p001a.p002a.p003a.C0135c;
import p000a.p001a.p002a.p003a.p004a.p006b.C0020i;

/* renamed from: com.a.a.c.u */
/* compiled from: LogFileManager */
class C1835u {

    /* renamed from: a */
    private static final C1838b f5666a = new C1838b();

    /* renamed from: b */
    private final Context f5667b;

    /* renamed from: c */
    private final C1837a f5668c;

    /* renamed from: d */
    private C1833s f5669d;

    /* renamed from: com.a.a.c.u$a */
    /* compiled from: LogFileManager */
    public interface C1837a {
        /* renamed from: a */
        File mo7125a();
    }

    /* renamed from: com.a.a.c.u$b */
    /* compiled from: LogFileManager */
    private static final class C1838b implements C1833s {
        /* renamed from: a */
        public C1776b mo7018a() {
            return null;
        }

        /* renamed from: b */
        public void mo7019b() {
        }

        /* renamed from: c */
        public void mo7020c() {
        }

        private C1838b() {
        }
    }

    C1835u(Context context, C1837a aVar) {
        this(context, aVar, null);
    }

    C1835u(Context context, C1837a aVar, String str) {
        this.f5667b = context;
        this.f5668c = aVar;
        this.f5669d = f5666a;
        mo7168a(str);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo7168a(String str) {
        this.f5669d.mo7019b();
        this.f5669d = f5666a;
        if (str != null) {
            if (!C0020i.m73a(this.f5667b, "com.crashlytics.CollectCustomLogs", true)) {
                C0135c.m449h().mo270a("CrashlyticsCore", "Preferences requested no custom logs. Aborting log file creation.");
            } else {
                mo7167a(m7561b(str), 65536);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C1776b mo7166a() {
        return this.f5669d.mo7018a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo7170b() {
        this.f5669d.mo7020c();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7169a(Set<String> set) {
        File[] listFiles = this.f5668c.mo7125a().listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (!set.contains(m7560a(file))) {
                    file.delete();
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7167a(File file, int i) {
        this.f5669d = new C1757ac(file, i);
    }

    /* renamed from: b */
    private File m7561b(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("crashlytics-userlog-");
        sb.append(str);
        sb.append(".temp");
        return new File(this.f5668c.mo7125a(), sb.toString());
    }

    /* renamed from: a */
    private String m7560a(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".temp");
        if (lastIndexOf == -1) {
            return name;
        }
        return name.substring("crashlytics-userlog-".length(), lastIndexOf);
    }
}
