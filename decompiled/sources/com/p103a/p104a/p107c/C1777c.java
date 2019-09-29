package com.p103a.p104a.p107c;

import android.os.Process;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;
import p000a.p001a.p002a.p003a.p004a.p006b.C0020i;
import p000a.p001a.p002a.p003a.p004a.p006b.C0032o;

/* renamed from: com.a.a.c.c */
/* compiled from: CLSUUID */
class C1777c {

    /* renamed from: a */
    private static final AtomicLong f5549a = new AtomicLong(0);

    /* renamed from: b */
    private static String f5550b;

    public C1777c(C0032o oVar) {
        byte[] bArr = new byte[10];
        m7355a(bArr);
        m7357b(bArr);
        m7359c(bArr);
        String a = C0020i.m61a(oVar.mo55b());
        String a2 = C0020i.m63a(bArr);
        f5550b = String.format(Locale.US, "%s-%s-%s-%s", new Object[]{a2.substring(0, 12), a2.substring(12, 16), a2.subSequence(16, 20), a.substring(0, 12)}).toUpperCase(Locale.US);
    }

    /* renamed from: a */
    private void m7355a(byte[] bArr) {
        long time = new Date().getTime();
        long j = time / 1000;
        long j2 = time % 1000;
        byte[] a = m7356a(j);
        bArr[0] = a[0];
        bArr[1] = a[1];
        bArr[2] = a[2];
        bArr[3] = a[3];
        byte[] b = m7358b(j2);
        bArr[4] = b[0];
        bArr[5] = b[1];
    }

    /* renamed from: b */
    private void m7357b(byte[] bArr) {
        byte[] b = m7358b(f5549a.incrementAndGet());
        bArr[6] = b[0];
        bArr[7] = b[1];
    }

    /* renamed from: c */
    private void m7359c(byte[] bArr) {
        byte[] b = m7358b((long) Integer.valueOf(Process.myPid()).shortValue());
        bArr[8] = b[0];
        bArr[9] = b[1];
    }

    /* renamed from: a */
    private static byte[] m7356a(long j) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt((int) j);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }

    /* renamed from: b */
    private static byte[] m7358b(long j) {
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.putShort((short) ((int) j));
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }

    public String toString() {
        return f5550b;
    }
}
