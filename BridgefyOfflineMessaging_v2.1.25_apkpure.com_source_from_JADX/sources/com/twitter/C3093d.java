package com.twitter;

import com.twitter.C3088a.C3089a;
import java.text.Normalizer;
import java.text.Normalizer.Form;

/* renamed from: com.twitter.d */
/* compiled from: Validator */
public class C3093d {

    /* renamed from: a */
    protected int f8156a = 23;

    /* renamed from: b */
    protected int f8157b = 23;

    /* renamed from: c */
    private C3088a f8158c = new C3088a();

    /* renamed from: a */
    public int mo27590a(String str) {
        String normalize = Normalizer.normalize(str, Form.NFC);
        int codePointCount = normalize.codePointCount(0, normalize.length());
        for (C3089a aVar : this.f8158c.mo27586a(normalize)) {
            codePointCount = codePointCount + (aVar.f8126a - aVar.f8127b) + (aVar.f8128c.toLowerCase().startsWith("https://") ? this.f8157b : this.f8156a);
        }
        return codePointCount;
    }
}
