package p091b;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: b.v */
/* compiled from: MediaType */
public final class C1647v {

    /* renamed from: a */
    private static final Pattern f5181a = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* renamed from: b */
    private static final Pattern f5182b = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* renamed from: c */
    private final String f5183c;

    /* renamed from: d */
    private final String f5184d;

    /* renamed from: e */
    private final String f5185e;

    /* renamed from: f */
    private final String f5186f;

    private C1647v(String str, String str2, String str3, String str4) {
        this.f5183c = str;
        this.f5184d = str2;
        this.f5185e = str3;
        this.f5186f = str4;
    }

    /* renamed from: a */
    public static C1647v m6791a(String str) {
        Matcher matcher = f5181a.matcher(str);
        if (!matcher.lookingAt()) {
            return null;
        }
        String lowerCase = matcher.group(1).toLowerCase(Locale.US);
        String lowerCase2 = matcher.group(2).toLowerCase(Locale.US);
        Matcher matcher2 = f5182b.matcher(str);
        String str2 = null;
        for (int end = matcher.end(); end < str.length(); end = matcher2.end()) {
            matcher2.region(end, str.length());
            if (!matcher2.lookingAt()) {
                return null;
            }
            String group = matcher2.group(1);
            if (group != null && group.equalsIgnoreCase("charset")) {
                String group2 = matcher2.group(2);
                if (group2 == null) {
                    group2 = matcher2.group(3);
                } else if (group2.startsWith("'") && group2.endsWith("'") && group2.length() > 2) {
                    group2 = group2.substring(1, group2.length() - 1);
                }
                if (str2 != null && !group2.equalsIgnoreCase(str2)) {
                    return null;
                }
                str2 = group2;
            }
        }
        return new C1647v(str, lowerCase, lowerCase2, str2);
    }

    /* renamed from: a */
    public String mo6696a() {
        return this.f5184d;
    }

    /* renamed from: a */
    public Charset mo6697a(Charset charset) {
        try {
            if (this.f5186f != null) {
                charset = Charset.forName(this.f5186f);
            }
            return charset;
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }

    public String toString() {
        return this.f5183c;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C1647v) && ((C1647v) obj).f5183c.equals(this.f5183c);
    }

    public int hashCode() {
        return this.f5183c.hashCode();
    }
}
