package com.p103a.p104a.p107c;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/* renamed from: com.a.a.c.b */
/* compiled from: ByteString */
final class C1776b {

    /* renamed from: a */
    public static final C1776b f5546a = new C1776b(new byte[0]);

    /* renamed from: b */
    private final byte[] f5547b;

    /* renamed from: c */
    private volatile int f5548c = 0;

    private C1776b(byte[] bArr) {
        this.f5547b = bArr;
    }

    /* renamed from: a */
    public int mo7038a() {
        return this.f5547b.length;
    }

    /* renamed from: a */
    public static C1776b m7351a(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new C1776b(bArr2);
    }

    /* renamed from: a */
    public static C1776b m7350a(String str) {
        try {
            return new C1776b(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported.", e);
        }
    }

    /* renamed from: a */
    public void mo7039a(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.f5547b, i, bArr, i2, i3);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1776b)) {
            return false;
        }
        C1776b bVar = (C1776b) obj;
        int length = this.f5547b.length;
        if (length != bVar.f5547b.length) {
            return false;
        }
        byte[] bArr = this.f5547b;
        byte[] bArr2 = bVar.f5547b;
        for (int i = 0; i < length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = this.f5548c;
        if (i == 0) {
            byte[] bArr = this.f5547b;
            int length = this.f5547b.length;
            int i2 = length;
            for (int i3 = 0; i3 < length; i3++) {
                i2 = (i2 * 31) + bArr[i3];
            }
            i = i2 == 0 ? 1 : i2;
            this.f5548c = i;
        }
        return i;
    }

    /* renamed from: b */
    public InputStream mo7040b() {
        return new ByteArrayInputStream(this.f5547b);
    }
}
