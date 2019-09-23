package org.apache.commons.p154a.p155a;

import java.io.Serializable;
import java.io.Writer;

/* renamed from: org.apache.commons.a.a.b */
/* compiled from: StringBuilderWriter */
public class C3687b extends Writer implements Serializable {

    /* renamed from: a */
    private final StringBuilder f9728a;

    public void close() {
    }

    public void flush() {
    }

    public C3687b() {
        this.f9728a = new StringBuilder();
    }

    public C3687b(int i) {
        this.f9728a = new StringBuilder(i);
    }

    public Writer append(char c) {
        this.f9728a.append(c);
        return this;
    }

    public Writer append(CharSequence charSequence) {
        this.f9728a.append(charSequence);
        return this;
    }

    public Writer append(CharSequence charSequence, int i, int i2) {
        this.f9728a.append(charSequence, i, i2);
        return this;
    }

    public void write(String str) {
        if (str != null) {
            this.f9728a.append(str);
        }
    }

    public void write(char[] cArr, int i, int i2) {
        if (cArr != null) {
            this.f9728a.append(cArr, i, i2);
        }
    }

    public String toString() {
        return this.f9728a.toString();
    }
}
