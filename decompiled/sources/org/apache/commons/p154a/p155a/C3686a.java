package org.apache.commons.p154a.p155a;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/* renamed from: org.apache.commons.a.a.a */
/* compiled from: ByteArrayOutputStream */
public class C3686a extends OutputStream {

    /* renamed from: a */
    private static final byte[] f9722a = new byte[0];

    /* renamed from: b */
    private final List<byte[]> f9723b;

    /* renamed from: c */
    private int f9724c;

    /* renamed from: d */
    private int f9725d;

    /* renamed from: e */
    private byte[] f9726e;

    /* renamed from: f */
    private int f9727f;

    public void close() throws IOException {
    }

    public C3686a() {
        this(1024);
    }

    public C3686a(int i) {
        this.f9723b = new ArrayList();
        if (i >= 0) {
            synchronized (this) {
                m10967a(i);
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Negative initial size: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: a */
    private void m10967a(int i) {
        if (this.f9724c < this.f9723b.size() - 1) {
            this.f9725d += this.f9726e.length;
            this.f9724c++;
            this.f9726e = (byte[]) this.f9723b.get(this.f9724c);
            return;
        }
        if (this.f9726e == null) {
            this.f9725d = 0;
        } else {
            i = Math.max(this.f9726e.length << 1, i - this.f9725d);
            this.f9725d += this.f9726e.length;
        }
        this.f9724c++;
        this.f9726e = new byte[i];
        this.f9723b.add(this.f9726e);
    }

    public void write(byte[] bArr, int i, int i2) {
        if (i >= 0 && i <= bArr.length && i2 >= 0) {
            int i3 = i + i2;
            if (i3 <= bArr.length && i3 >= 0) {
                if (i2 != 0) {
                    synchronized (this) {
                        int i4 = this.f9727f + i2;
                        int i5 = this.f9727f - this.f9725d;
                        while (i2 > 0) {
                            int min = Math.min(i2, this.f9726e.length - i5);
                            System.arraycopy(bArr, i3 - i2, this.f9726e, i5, min);
                            i2 -= min;
                            if (i2 > 0) {
                                m10967a(i4);
                                i5 = 0;
                            }
                        }
                        this.f9727f = i4;
                    }
                    return;
                }
                return;
            }
        }
        throw new IndexOutOfBoundsException();
    }

    public synchronized void write(int i) {
        int i2 = this.f9727f - this.f9725d;
        if (i2 == this.f9726e.length) {
            m10967a(this.f9727f + 1);
            i2 = 0;
        }
        this.f9726e[i2] = (byte) i;
        this.f9727f++;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002c, code lost:
        return r1;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized byte[] mo30141a() {
        /*
            r7 = this;
            monitor-enter(r7)
            int r0 = r7.f9727f     // Catch:{ all -> 0x002d }
            if (r0 != 0) goto L_0x0009
            byte[] r0 = f9722a     // Catch:{ all -> 0x002d }
            monitor-exit(r7)
            return r0
        L_0x0009:
            byte[] r1 = new byte[r0]     // Catch:{ all -> 0x002d }
            java.util.List<byte[]> r2 = r7.f9723b     // Catch:{ all -> 0x002d }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x002d }
            r3 = 0
            r4 = 0
        L_0x0013:
            boolean r5 = r2.hasNext()     // Catch:{ all -> 0x002d }
            if (r5 == 0) goto L_0x002b
            java.lang.Object r5 = r2.next()     // Catch:{ all -> 0x002d }
            byte[] r5 = (byte[]) r5     // Catch:{ all -> 0x002d }
            int r6 = r5.length     // Catch:{ all -> 0x002d }
            int r6 = java.lang.Math.min(r6, r0)     // Catch:{ all -> 0x002d }
            java.lang.System.arraycopy(r5, r3, r1, r4, r6)     // Catch:{ all -> 0x002d }
            int r4 = r4 + r6
            int r0 = r0 - r6
            if (r0 != 0) goto L_0x0013
        L_0x002b:
            monitor-exit(r7)
            return r1
        L_0x002d:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.p154a.p155a.C3686a.mo30141a():byte[]");
    }

    public String toString() {
        return new String(mo30141a());
    }
}
