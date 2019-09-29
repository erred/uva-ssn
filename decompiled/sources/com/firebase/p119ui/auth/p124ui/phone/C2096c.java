package com.firebase.p119ui.auth.p124ui.phone;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.text.Collator;
import java.util.Locale;

/* renamed from: com.firebase.ui.auth.ui.phone.c */
/* compiled from: CountryInfo */
final class C2096c implements Comparable<C2096c> {

    /* renamed from: a */
    public final Locale f6439a;

    /* renamed from: b */
    public final int f6440b;

    /* renamed from: c */
    private final Collator f6441c = Collator.getInstance(Locale.getDefault());

    public C2096c(Locale locale, int i) {
        this.f6441c.setStrength(0);
        this.f6439a = locale;
        this.f6440b = i;
    }

    /* renamed from: a */
    public static String m8406a(Locale locale) {
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
        C2096c cVar = (C2096c) obj;
        if (this.f6440b != cVar.f6440b || (this.f6439a == null ? cVar.f6439a != null : !this.f6439a.equals(cVar.f6439a))) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return ((this.f6439a != null ? this.f6439a.hashCode() : 0) * 31) + this.f6440b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(m8406a(this.f6439a));
        sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        sb.append(this.f6439a.getDisplayCountry());
        sb.append(" +");
        sb.append(this.f6440b);
        return sb.toString();
    }

    /* renamed from: a */
    public int compareTo(C2096c cVar) {
        return this.f6441c.compare(this.f6439a.getDisplayCountry(), cVar.f6439a.getDisplayCountry());
    }
}
