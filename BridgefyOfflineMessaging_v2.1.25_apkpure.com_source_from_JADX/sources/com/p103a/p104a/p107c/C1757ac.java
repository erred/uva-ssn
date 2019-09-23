package com.p103a.p104a.p107c;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import p000a.p001a.p002a.p003a.C0135c;
import p000a.p001a.p002a.p003a.p004a.p006b.C0020i;
import p000a.p001a.p002a.p003a.p004a.p006b.C0036q;
import p000a.p001a.p002a.p003a.p004a.p006b.C0036q.C0040c;

/* renamed from: com.a.a.c.ac */
/* compiled from: QueueFileLogStore */
class C1757ac implements C1833s {

    /* renamed from: a */
    private final File f5510a;

    /* renamed from: b */
    private final int f5511b;

    /* renamed from: c */
    private C0036q f5512c;

    public C1757ac(File file, int i) {
        this.f5510a = file;
        this.f5511b = i;
    }

    /* renamed from: a */
    public C1776b mo7018a() {
        if (!this.f5510a.exists()) {
            return null;
        }
        m7280d();
        if (this.f5512c == null) {
            return null;
        }
        final int[] iArr = {0};
        final byte[] bArr = new byte[this.f5512c.mo70a()];
        try {
            this.f5512c.mo71a((C0040c) new C0040c() {
                /* renamed from: a */
                public void mo78a(InputStream inputStream, int i) throws IOException {
                    try {
                        inputStream.read(bArr, iArr[0], i);
                        int[] iArr = iArr;
                        iArr[0] = iArr[0] + i;
                    } finally {
                        inputStream.close();
                    }
                }
            });
        } catch (IOException e) {
            C0135c.m449h().mo280e("CrashlyticsCore", "A problem occurred while reading the Crashlytics log file.", e);
        }
        return C1776b.m7351a(bArr, 0, iArr[0]);
    }

    /* renamed from: b */
    public void mo7019b() {
        C0020i.m70a((Closeable) this.f5512c, "There was a problem closing the Crashlytics log file.");
        this.f5512c = null;
    }

    /* renamed from: c */
    public void mo7020c() {
        mo7019b();
        this.f5510a.delete();
    }

    /* renamed from: d */
    private void m7280d() {
        if (this.f5512c == null) {
            try {
                this.f5512c = new C0036q(this.f5510a);
            } catch (IOException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Could not open log file: ");
                sb.append(this.f5510a);
                C0135c.m449h().mo280e("CrashlyticsCore", sb.toString(), e);
            }
        }
    }
}
