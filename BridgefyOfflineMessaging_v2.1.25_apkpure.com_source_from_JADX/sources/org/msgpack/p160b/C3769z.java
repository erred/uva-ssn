package org.msgpack.p160b;

/* renamed from: org.msgpack.b.z */
/* compiled from: ValueType */
public enum C3769z {
    NIL(false, false),
    BOOLEAN(false, false),
    INTEGER(true, false),
    FLOAT(true, false),
    STRING(false, true),
    BINARY(false, true),
    ARRAY(false, false),
    MAP(false, false),
    EXTENSION(false, false);
    

    /* renamed from: j */
    private final boolean f9910j;

    /* renamed from: k */
    private final boolean f9911k;

    private C3769z(boolean z, boolean z2) {
        this.f9910j = z;
        this.f9911k = z2;
    }

    /* renamed from: a */
    public boolean mo32030a() {
        return this == NIL;
    }

    /* renamed from: b */
    public boolean mo32031b() {
        return this == BOOLEAN;
    }

    /* renamed from: c */
    public boolean mo32032c() {
        return this == INTEGER;
    }

    /* renamed from: d */
    public boolean mo32033d() {
        return this == FLOAT;
    }

    /* renamed from: e */
    public boolean mo32034e() {
        return this.f9911k;
    }

    /* renamed from: f */
    public boolean mo32035f() {
        return this == STRING;
    }

    /* renamed from: g */
    public boolean mo32036g() {
        return this == BINARY;
    }

    /* renamed from: h */
    public boolean mo32037h() {
        return this == ARRAY;
    }

    /* renamed from: i */
    public boolean mo32038i() {
        return this == MAP;
    }

    /* renamed from: j */
    public boolean mo32039j() {
        return this == EXTENSION;
    }
}
