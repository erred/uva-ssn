package org.apache.commons.p156b;

import java.util.regex.Pattern;

/* renamed from: org.apache.commons.b.c */
/* compiled from: StringUtils */
public class C3691c {

    /* renamed from: a */
    private static final Pattern f9750a = Pattern.compile("(?: |\\u00A0|\\s|[\\s&&[^ ]])\\s*");

    /* renamed from: a */
    public static boolean m10978a(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    /* renamed from: a */
    public static String m10976a(Object[] objArr, String str) {
        if (objArr == null) {
            return null;
        }
        return m10977a(objArr, str, 0, objArr.length);
    }

    /* renamed from: a */
    public static String m10977a(Object[] objArr, String str, int i, int i2) {
        if (objArr == null) {
            return null;
        }
        if (str == null) {
            str = "";
        }
        int i3 = i2 - i;
        if (i3 <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(i3 * 16);
        for (int i4 = i; i4 < i2; i4++) {
            if (i4 > i) {
                sb.append(str);
            }
            if (objArr[i4] != null) {
                sb.append(objArr[i4]);
            }
        }
        return sb.toString();
    }

    /* renamed from: b */
    public static boolean m10981b(CharSequence charSequence) {
        if (m10978a(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isDigit(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m10979a(CharSequence charSequence, CharSequence charSequence2) {
        return m10980a(charSequence, charSequence2, false);
    }

    /* renamed from: a */
    private static boolean m10980a(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        boolean z2 = false;
        if (charSequence == null || charSequence2 == null) {
            if (charSequence == null && charSequence2 == null) {
                z2 = true;
            }
            return z2;
        } else if (charSequence2.length() > charSequence.length()) {
            return false;
        } else {
            return C3690b.m10975a(charSequence, z, 0, charSequence2, 0, charSequence2.length());
        }
    }
}
