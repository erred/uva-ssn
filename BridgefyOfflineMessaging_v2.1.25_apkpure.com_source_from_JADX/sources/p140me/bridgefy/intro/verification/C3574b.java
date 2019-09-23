package p140me.bridgefy.intro.verification;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Locale;

/* renamed from: me.bridgefy.intro.verification.b */
/* compiled from: CountryInfo */
public final class C3574b implements Comparable<C3574b> {

    /* renamed from: a */
    public static ArrayList<Integer> f9385a = new ArrayList<Integer>() {
        {
            add(Integer.valueOf(C3574b.f9386d));
            add(Integer.valueOf(C3574b.f9387e));
            add(Integer.valueOf(C3574b.f9388f));
            add(Integer.valueOf(C3574b.f9389g));
            add(Integer.valueOf(C3574b.f9390h));
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static int f9386d = 53;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static int f9387e = 98;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static int f9388f = 850;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static int f9389g = 249;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static int f9390h = 963;

    /* renamed from: b */
    public final Locale f9391b;

    /* renamed from: c */
    public final int f9392c;

    /* renamed from: i */
    private final Collator f9393i = Collator.getInstance(Locale.getDefault());

    C3574b(Locale locale, int i) {
        this.f9393i.setStrength(0);
        this.f9391b = locale;
        this.f9392c = i;
    }

    /* renamed from: a */
    public static String m10504a(Locale locale) {
        String country = locale.getCountry();
        int codePointAt = (Character.codePointAt(country, 0) - 65) + 127462;
        int codePointAt2 = (Character.codePointAt(country, 1) - 65) + 127462;
        StringBuilder sb = new StringBuilder();
        sb.append(new String(Character.toChars(codePointAt)));
        sb.append(new String(Character.toChars(codePointAt2)));
        return sb.toString();
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C3574b bVar = (C3574b) obj;
        if (this.f9392c != bVar.f9392c || (this.f9391b == null ? bVar.f9391b != null : !this.f9391b.equals(bVar.f9391b))) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return ((this.f9391b != null ? this.f9391b.hashCode() : 0) * 31) + this.f9392c;
    }

    /* renamed from: a */
    public String mo29481a() {
        return String.valueOf(this.f9392c);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(m10504a(this.f9391b));
        sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        sb.append(this.f9391b.getDisplayCountry());
        sb.append(" +");
        sb.append(this.f9392c);
        return sb.toString();
    }

    /* renamed from: a */
    public int compareTo(C3574b bVar) {
        return this.f9393i.compare(this.f9391b.getDisplayCountry(), bVar.f9391b.getDisplayCountry());
    }
}
