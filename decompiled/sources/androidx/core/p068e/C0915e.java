package androidx.core.p068e;

import java.util.Locale;

/* renamed from: androidx.core.e.e */
/* compiled from: TextDirectionHeuristicsCompat */
public final class C0915e {

    /* renamed from: a */
    public static final C0914d f2932a = new C0920e(null, false);

    /* renamed from: b */
    public static final C0914d f2933b = new C0920e(null, true);

    /* renamed from: c */
    public static final C0914d f2934c = new C0920e(C0917b.f2941a, false);

    /* renamed from: d */
    public static final C0914d f2935d = new C0920e(C0917b.f2941a, true);

    /* renamed from: e */
    public static final C0914d f2936e = new C0920e(C0916a.f2938a, false);

    /* renamed from: f */
    public static final C0914d f2937f = C0921f.f2944a;

    /* renamed from: androidx.core.e.e$a */
    /* compiled from: TextDirectionHeuristicsCompat */
    private static class C0916a implements C0918c {

        /* renamed from: a */
        static final C0916a f2938a = new C0916a(true);

        /* renamed from: b */
        static final C0916a f2939b = new C0916a(false);

        /* renamed from: c */
        private final boolean f2940c;

        /* renamed from: a */
        public int mo3642a(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + i;
            boolean z = false;
            while (i < i3) {
                switch (C0915e.m3379a(Character.getDirectionality(charSequence.charAt(i)))) {
                    case 0:
                        if (this.f2940c) {
                            return 0;
                        }
                        break;
                    case 1:
                        if (!this.f2940c) {
                            return 1;
                        }
                        break;
                }
                z = true;
                i++;
            }
            if (z) {
                return this.f2940c ? 1 : 0;
            }
            return 2;
        }

        private C0916a(boolean z) {
            this.f2940c = z;
        }
    }

    /* renamed from: androidx.core.e.e$b */
    /* compiled from: TextDirectionHeuristicsCompat */
    private static class C0917b implements C0918c {

        /* renamed from: a */
        static final C0917b f2941a = new C0917b();

        /* renamed from: a */
        public int mo3642a(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + i;
            int i4 = 2;
            while (i < i3 && i4 == 2) {
                i4 = C0915e.m3380b(Character.getDirectionality(charSequence.charAt(i)));
                i++;
            }
            return i4;
        }

        private C0917b() {
        }
    }

    /* renamed from: androidx.core.e.e$c */
    /* compiled from: TextDirectionHeuristicsCompat */
    private interface C0918c {
        /* renamed from: a */
        int mo3642a(CharSequence charSequence, int i, int i2);
    }

    /* renamed from: androidx.core.e.e$d */
    /* compiled from: TextDirectionHeuristicsCompat */
    private static abstract class C0919d implements C0914d {

        /* renamed from: a */
        private final C0918c f2942a;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract boolean mo3643a();

        C0919d(C0918c cVar) {
            this.f2942a = cVar;
        }

        /* renamed from: a */
        public boolean mo3641a(CharSequence charSequence, int i, int i2) {
            if (charSequence == null || i < 0 || i2 < 0 || charSequence.length() - i2 < i) {
                throw new IllegalArgumentException();
            } else if (this.f2942a == null) {
                return mo3643a();
            } else {
                return m3384b(charSequence, i, i2);
            }
        }

        /* renamed from: b */
        private boolean m3384b(CharSequence charSequence, int i, int i2) {
            switch (this.f2942a.mo3642a(charSequence, i, i2)) {
                case 0:
                    return true;
                case 1:
                    return false;
                default:
                    return mo3643a();
            }
        }
    }

    /* renamed from: androidx.core.e.e$e */
    /* compiled from: TextDirectionHeuristicsCompat */
    private static class C0920e extends C0919d {

        /* renamed from: a */
        private final boolean f2943a;

        C0920e(C0918c cVar, boolean z) {
            super(cVar);
            this.f2943a = z;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo3643a() {
            return this.f2943a;
        }
    }

    /* renamed from: androidx.core.e.e$f */
    /* compiled from: TextDirectionHeuristicsCompat */
    private static class C0921f extends C0919d {

        /* renamed from: a */
        static final C0921f f2944a = new C0921f();

        C0921f() {
            super(null);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo3643a() {
            return C0922f.m3389a(Locale.getDefault()) == 1;
        }
    }

    /* renamed from: a */
    static int m3379a(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
            case 2:
                return 0;
            default:
                return 2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0009, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000b, code lost:
        return 1;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int m3380b(int r0) {
        /*
            switch(r0) {
                case 0: goto L_0x000a;
                case 1: goto L_0x0008;
                case 2: goto L_0x0008;
                default: goto L_0x0003;
            }
        L_0x0003:
            switch(r0) {
                case 14: goto L_0x000a;
                case 15: goto L_0x000a;
                case 16: goto L_0x0008;
                case 17: goto L_0x0008;
                default: goto L_0x0006;
            }
        L_0x0006:
            r0 = 2
            return r0
        L_0x0008:
            r0 = 0
            return r0
        L_0x000a:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.p068e.C0915e.m3380b(int):int");
    }
}
