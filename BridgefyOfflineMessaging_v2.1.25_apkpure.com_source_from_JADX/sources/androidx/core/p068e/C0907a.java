package androidx.core.p068e;

import android.text.SpannableStringBuilder;
import com.google.common.base.Ascii;
import java.util.Locale;

/* renamed from: androidx.core.e.a */
/* compiled from: BidiFormatter */
public final class C0907a {

    /* renamed from: a */
    static final C0914d f2900a = C0915e.f2934c;

    /* renamed from: b */
    static final C0907a f2901b = new C0907a(false, 2, f2900a);

    /* renamed from: c */
    static final C0907a f2902c = new C0907a(true, 2, f2900a);

    /* renamed from: d */
    private static final String f2903d = Character.toString(8206);

    /* renamed from: e */
    private static final String f2904e = Character.toString(8207);

    /* renamed from: f */
    private final boolean f2905f;

    /* renamed from: g */
    private final int f2906g;

    /* renamed from: h */
    private final C0914d f2907h;

    /* renamed from: androidx.core.e.a$a */
    /* compiled from: BidiFormatter */
    public static final class C0908a {

        /* renamed from: a */
        private boolean f2908a;

        /* renamed from: b */
        private int f2909b;

        /* renamed from: c */
        private C0914d f2910c;

        public C0908a() {
            m3353a(C0907a.m3346a(Locale.getDefault()));
        }

        /* renamed from: a */
        private void m3353a(boolean z) {
            this.f2908a = z;
            this.f2910c = C0907a.f2900a;
            this.f2909b = 2;
        }

        /* renamed from: b */
        private static C0907a m3354b(boolean z) {
            return z ? C0907a.f2902c : C0907a.f2901b;
        }

        /* renamed from: a */
        public C0907a mo3612a() {
            if (this.f2909b == 2 && this.f2910c == C0907a.f2900a) {
                return m3354b(this.f2908a);
            }
            return new C0907a(this.f2908a, this.f2909b, this.f2910c);
        }
    }

    /* renamed from: androidx.core.e.a$b */
    /* compiled from: BidiFormatter */
    private static class C0909b {

        /* renamed from: a */
        private static final byte[] f2911a = new byte[1792];

        /* renamed from: b */
        private final CharSequence f2912b;

        /* renamed from: c */
        private final boolean f2913c;

        /* renamed from: d */
        private final int f2914d;

        /* renamed from: e */
        private int f2915e;

        /* renamed from: f */
        private char f2916f;

        static {
            for (int i = 0; i < 1792; i++) {
                f2911a[i] = Character.getDirectionality(i);
            }
        }

        C0909b(CharSequence charSequence, boolean z) {
            this.f2912b = charSequence;
            this.f2913c = z;
            this.f2914d = charSequence.length();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public int mo3613a() {
            this.f2915e = 0;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (this.f2915e < this.f2914d && i == 0) {
                byte c = mo3615c();
                if (c != 9) {
                    switch (c) {
                        case 0:
                            if (i3 == 0) {
                                return -1;
                            }
                            break;
                        case 1:
                        case 2:
                            if (i3 == 0) {
                                return 1;
                            }
                            break;
                        default:
                            switch (c) {
                                case 14:
                                case 15:
                                    i3++;
                                    i2 = -1;
                                    continue;
                                case 16:
                                case 17:
                                    i3++;
                                    i2 = 1;
                                    continue;
                                case 18:
                                    i3--;
                                    i2 = 0;
                                    continue;
                                    continue;
                            }
                    }
                    i = i3;
                }
            }
            if (i == 0) {
                return 0;
            }
            if (i2 != 0) {
                return i2;
            }
            while (this.f2915e > 0) {
                switch (mo3616d()) {
                    case 14:
                    case 15:
                        if (i != i3) {
                            i3--;
                            break;
                        } else {
                            return -1;
                        }
                    case 16:
                    case 17:
                        if (i != i3) {
                            i3--;
                            break;
                        } else {
                            return 1;
                        }
                    case 18:
                        i3++;
                        break;
                }
            }
            return 0;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int mo3614b() {
            /*
                r6 = this;
                int r0 = r6.f2914d
                r6.f2915e = r0
                r0 = 0
                r1 = 0
                r2 = 0
            L_0x0007:
                int r3 = r6.f2915e
                if (r3 <= 0) goto L_0x003a
                byte r3 = r6.mo3616d()
                r4 = 9
                if (r3 == r4) goto L_0x0007
                r4 = 1
                r5 = -1
                switch(r3) {
                    case 0: goto L_0x0033;
                    case 1: goto L_0x002d;
                    case 2: goto L_0x002d;
                    default: goto L_0x0018;
                }
            L_0x0018:
                switch(r3) {
                    case 14: goto L_0x0027;
                    case 15: goto L_0x0027;
                    case 16: goto L_0x0021;
                    case 17: goto L_0x0021;
                    case 18: goto L_0x001e;
                    default: goto L_0x001b;
                }
            L_0x001b:
                if (r1 != 0) goto L_0x0007
                goto L_0x0038
            L_0x001e:
                int r2 = r2 + 1
                goto L_0x0007
            L_0x0021:
                if (r1 != r2) goto L_0x0024
                return r4
            L_0x0024:
                int r2 = r2 + -1
                goto L_0x0007
            L_0x0027:
                if (r1 != r2) goto L_0x002a
                return r5
            L_0x002a:
                int r2 = r2 + -1
                goto L_0x0007
            L_0x002d:
                if (r2 != 0) goto L_0x0030
                return r4
            L_0x0030:
                if (r1 != 0) goto L_0x0007
                goto L_0x0038
            L_0x0033:
                if (r2 != 0) goto L_0x0036
                return r5
            L_0x0036:
                if (r1 != 0) goto L_0x0007
            L_0x0038:
                r1 = r2
                goto L_0x0007
            L_0x003a:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.p068e.C0907a.C0909b.mo3614b():int");
        }

        /* renamed from: a */
        private static byte m3356a(char c) {
            return c < 1792 ? f2911a[c] : Character.getDirectionality(c);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public byte mo3615c() {
            this.f2916f = this.f2912b.charAt(this.f2915e);
            if (Character.isHighSurrogate(this.f2916f)) {
                int codePointAt = Character.codePointAt(this.f2912b, this.f2915e);
                this.f2915e += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.f2915e++;
            byte a = m3356a(this.f2916f);
            if (this.f2913c) {
                if (this.f2916f == '<') {
                    a = m3357e();
                } else if (this.f2916f == '&') {
                    a = m3359g();
                }
            }
            return a;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public byte mo3616d() {
            this.f2916f = this.f2912b.charAt(this.f2915e - 1);
            if (Character.isLowSurrogate(this.f2916f)) {
                int codePointBefore = Character.codePointBefore(this.f2912b, this.f2915e);
                this.f2915e -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.f2915e--;
            byte a = m3356a(this.f2916f);
            if (this.f2913c) {
                if (this.f2916f == '>') {
                    a = m3358f();
                } else if (this.f2916f == ';') {
                    a = m3360h();
                }
            }
            return a;
        }

        /* renamed from: e */
        private byte m3357e() {
            int i = this.f2915e;
            while (this.f2915e < this.f2914d) {
                CharSequence charSequence = this.f2912b;
                int i2 = this.f2915e;
                this.f2915e = i2 + 1;
                this.f2916f = charSequence.charAt(i2);
                if (this.f2916f == '>') {
                    return Ascii.f6727FF;
                }
                if (this.f2916f == '\"' || this.f2916f == '\'') {
                    char c = this.f2916f;
                    while (this.f2915e < this.f2914d) {
                        CharSequence charSequence2 = this.f2912b;
                        int i3 = this.f2915e;
                        this.f2915e = i3 + 1;
                        char charAt = charSequence2.charAt(i3);
                        this.f2916f = charAt;
                        if (charAt == c) {
                            break;
                        }
                    }
                }
            }
            this.f2915e = i;
            this.f2916f = '<';
            return Ascii.f6725CR;
        }

        /* renamed from: f */
        private byte m3358f() {
            int i = this.f2915e;
            while (this.f2915e > 0) {
                CharSequence charSequence = this.f2912b;
                int i2 = this.f2915e - 1;
                this.f2915e = i2;
                this.f2916f = charSequence.charAt(i2);
                if (this.f2916f == '<') {
                    return Ascii.f6727FF;
                }
                if (this.f2916f == '>') {
                    break;
                } else if (this.f2916f == '\"' || this.f2916f == '\'') {
                    char c = this.f2916f;
                    while (this.f2915e > 0) {
                        CharSequence charSequence2 = this.f2912b;
                        int i3 = this.f2915e - 1;
                        this.f2915e = i3;
                        char charAt = charSequence2.charAt(i3);
                        this.f2916f = charAt;
                        if (charAt == c) {
                            break;
                        }
                    }
                }
            }
            this.f2915e = i;
            this.f2916f = '>';
            return Ascii.f6725CR;
        }

        /* renamed from: g */
        private byte m3359g() {
            while (this.f2915e < this.f2914d) {
                CharSequence charSequence = this.f2912b;
                int i = this.f2915e;
                this.f2915e = i + 1;
                char charAt = charSequence.charAt(i);
                this.f2916f = charAt;
                if (charAt == ';') {
                    break;
                }
            }
            return Ascii.f6727FF;
        }

        /* renamed from: h */
        private byte m3360h() {
            int i = this.f2915e;
            while (this.f2915e > 0) {
                CharSequence charSequence = this.f2912b;
                int i2 = this.f2915e - 1;
                this.f2915e = i2;
                this.f2916f = charSequence.charAt(i2);
                if (this.f2916f != '&') {
                    if (this.f2916f == ';') {
                        break;
                    }
                } else {
                    return Ascii.f6727FF;
                }
            }
            this.f2915e = i;
            this.f2916f = ';';
            return Ascii.f6725CR;
        }
    }

    /* renamed from: a */
    public static C0907a m3344a() {
        return new C0908a().mo3612a();
    }

    C0907a(boolean z, int i, C0914d dVar) {
        this.f2905f = z;
        this.f2906g = i;
        this.f2907h = dVar;
    }

    /* renamed from: b */
    public boolean mo3611b() {
        return (this.f2906g & 2) != 0;
    }

    /* renamed from: a */
    private String m3345a(CharSequence charSequence, C0914d dVar) {
        boolean a = dVar.mo3641a(charSequence, 0, charSequence.length());
        if (this.f2905f || (!a && m3347b(charSequence) != 1)) {
            return (!this.f2905f || (a && m3347b(charSequence) != -1)) ? "" : f2904e;
        }
        return f2903d;
    }

    /* renamed from: b */
    private String m3348b(CharSequence charSequence, C0914d dVar) {
        boolean a = dVar.mo3641a(charSequence, 0, charSequence.length());
        if (this.f2905f || (!a && m3349c(charSequence) != 1)) {
            return (!this.f2905f || (a && m3349c(charSequence) != -1)) ? "" : f2904e;
        }
        return f2903d;
    }

    /* renamed from: a */
    public CharSequence mo3610a(CharSequence charSequence, C0914d dVar, boolean z) {
        if (charSequence == null) {
            return null;
        }
        boolean a = dVar.mo3641a(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (mo3611b() && z) {
            spannableStringBuilder.append(m3348b(charSequence, a ? C0915e.f2933b : C0915e.f2932a));
        }
        if (a != this.f2905f) {
            spannableStringBuilder.append(a ? (char) 8235 : 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append(8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z) {
            spannableStringBuilder.append(m3345a(charSequence, a ? C0915e.f2933b : C0915e.f2932a));
        }
        return spannableStringBuilder;
    }

    /* renamed from: a */
    public CharSequence mo3609a(CharSequence charSequence) {
        return mo3610a(charSequence, this.f2907h, true);
    }

    /* renamed from: a */
    static boolean m3346a(Locale locale) {
        return C0922f.m3389a(locale) == 1;
    }

    /* renamed from: b */
    private static int m3347b(CharSequence charSequence) {
        return new C0909b(charSequence, false).mo3614b();
    }

    /* renamed from: c */
    private static int m3349c(CharSequence charSequence) {
        return new C0909b(charSequence, false).mo3613a();
    }
}
