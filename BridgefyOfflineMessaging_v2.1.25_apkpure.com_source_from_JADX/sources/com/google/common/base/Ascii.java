package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible
public final class Ascii {
    public static final byte ACK = 6;
    public static final byte BEL = 7;

    /* renamed from: BS */
    public static final byte f6724BS = 8;
    public static final byte CAN = 24;

    /* renamed from: CR */
    public static final byte f6725CR = 13;
    public static final byte DC1 = 17;
    public static final byte DC2 = 18;
    public static final byte DC3 = 19;
    public static final byte DC4 = 20;
    public static final byte DEL = Byte.MAX_VALUE;
    public static final byte DLE = 16;

    /* renamed from: EM */
    public static final byte f6726EM = 25;
    public static final byte ENQ = 5;
    public static final byte EOT = 4;
    public static final byte ESC = 27;
    public static final byte ETB = 23;
    public static final byte ETX = 3;

    /* renamed from: FF */
    public static final byte f6727FF = 12;

    /* renamed from: FS */
    public static final byte f6728FS = 28;

    /* renamed from: GS */
    public static final byte f6729GS = 29;

    /* renamed from: HT */
    public static final byte f6730HT = 9;

    /* renamed from: LF */
    public static final byte f6731LF = 10;
    public static final char MAX = '';
    public static final char MIN = '\u0000';
    public static final byte NAK = 21;

    /* renamed from: NL */
    public static final byte f6732NL = 10;
    public static final byte NUL = 0;

    /* renamed from: RS */
    public static final byte f6733RS = 30;

    /* renamed from: SI */
    public static final byte f6734SI = 15;

    /* renamed from: SO */
    public static final byte f6735SO = 14;
    public static final byte SOH = 1;

    /* renamed from: SP */
    public static final byte f6736SP = 32;
    public static final byte SPACE = 32;
    public static final byte STX = 2;
    public static final byte SUB = 26;
    public static final byte SYN = 22;

    /* renamed from: US */
    public static final byte f6737US = 31;

    /* renamed from: VT */
    public static final byte f6738VT = 11;
    public static final byte XOFF = 19;
    public static final byte XON = 17;

    private static int getAlphaIndex(char c) {
        return (char) ((c | ' ') - 'a');
    }

    public static boolean isLowerCase(char c) {
        return c >= 'a' && c <= 'z';
    }

    public static boolean isUpperCase(char c) {
        return c >= 'A' && c <= 'Z';
    }

    private Ascii() {
    }

    public static String toLowerCase(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            if (isUpperCase(str.charAt(i))) {
                char[] charArray = str.toCharArray();
                while (i < length) {
                    char c = charArray[i];
                    if (isUpperCase(c)) {
                        charArray[i] = (char) (c ^ ' ');
                    }
                    i++;
                }
                return String.valueOf(charArray);
            }
            i++;
        }
        return str;
    }

    public static String toLowerCase(CharSequence charSequence) {
        if (charSequence instanceof String) {
            return toLowerCase((String) charSequence);
        }
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(toLowerCase(charSequence.charAt(i)));
        }
        return sb.toString();
    }

    public static char toLowerCase(char c) {
        return isUpperCase(c) ? (char) (c ^ ' ') : c;
    }

    public static String toUpperCase(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            if (isLowerCase(str.charAt(i))) {
                char[] charArray = str.toCharArray();
                while (i < length) {
                    char c = charArray[i];
                    if (isLowerCase(c)) {
                        charArray[i] = (char) (c & '_');
                    }
                    i++;
                }
                return String.valueOf(charArray);
            }
            i++;
        }
        return str;
    }

    public static String toUpperCase(CharSequence charSequence) {
        if (charSequence instanceof String) {
            return toUpperCase((String) charSequence);
        }
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(toUpperCase(charSequence.charAt(i)));
        }
        return sb.toString();
    }

    public static char toUpperCase(char c) {
        return isLowerCase(c) ? (char) (c & '_') : c;
    }

    /* JADX WARNING: type inference failed for: r7v0, types: [java.lang.CharSequence, java.lang.Object] */
    /* JADX WARNING: type inference failed for: r7v1, types: [java.lang.CharSequence] */
    /* JADX WARNING: type inference failed for: r7v3, types: [java.lang.String] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.CharSequence, code=null, for r7v0, types: [java.lang.CharSequence, java.lang.Object] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r7v3, types: [java.lang.String]
      assigns: [java.lang.String, java.lang.CharSequence]
      uses: [java.lang.String, java.lang.CharSequence, java.lang.Object]
      mth insns count: 25
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    @com.google.common.annotations.Beta
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String truncate(java.lang.CharSequence r7, int r8, java.lang.String r9) {
        /*
            com.google.common.base.Preconditions.checkNotNull(r7)
            int r0 = r9.length()
            int r0 = r8 - r0
            r1 = 1
            r2 = 0
            if (r0 < 0) goto L_0x000f
            r3 = 1
            goto L_0x0010
        L_0x000f:
            r3 = 0
        L_0x0010:
            java.lang.String r4 = "maxLength (%s) must be >= length of the truncation indicator (%s)"
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.Integer r6 = java.lang.Integer.valueOf(r8)
            r5[r2] = r6
            int r6 = r9.length()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r5[r1] = r6
            com.google.common.base.Preconditions.checkArgument(r3, r4, r5)
            int r1 = r7.length()
            if (r1 > r8) goto L_0x0039
            java.lang.String r7 = r7.toString()
            int r1 = r7.length()
            if (r1 > r8) goto L_0x0039
            return r7
        L_0x0039:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r8)
            r1.append(r7, r2, r0)
            r1.append(r9)
            java.lang.String r7 = r1.toString()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.base.Ascii.truncate(java.lang.CharSequence, int, java.lang.String):java.lang.String");
    }

    @Beta
    public static boolean equalsIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        int length = charSequence.length();
        if (charSequence == charSequence2) {
            return true;
        }
        if (length != charSequence2.length()) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            char charAt = charSequence.charAt(i);
            char charAt2 = charSequence2.charAt(i);
            if (charAt != charAt2) {
                int alphaIndex = getAlphaIndex(charAt);
                if (alphaIndex >= 26 || alphaIndex != getAlphaIndex(charAt2)) {
                    return false;
                }
            }
        }
        return true;
    }
}
