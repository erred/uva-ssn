package com.google.i18n.phonenumbers;

import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import java.util.Arrays;

public final class PhoneNumberMatch {
    private final PhoneNumber number;
    private final String rawString;
    private final int start;

    PhoneNumberMatch(int i, String str, PhoneNumber phoneNumber) {
        if (i < 0) {
            throw new IllegalArgumentException("Start index must be >= 0.");
        } else if (str == null || phoneNumber == null) {
            throw new NullPointerException();
        } else {
            this.start = i;
            this.rawString = str;
            this.number = phoneNumber;
        }
    }

    public PhoneNumber number() {
        return this.number;
    }

    public int start() {
        return this.start;
    }

    public int end() {
        return this.start + this.rawString.length();
    }

    public String rawString() {
        return this.rawString;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.start), this.rawString, this.number});
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PhoneNumberMatch)) {
            return false;
        }
        PhoneNumberMatch phoneNumberMatch = (PhoneNumberMatch) obj;
        if (!this.rawString.equals(phoneNumberMatch.rawString) || this.start != phoneNumberMatch.start || !this.number.equals(phoneNumberMatch.number)) {
            z = false;
        }
        return z;
    }

    public String toString() {
        int start2 = start();
        int end = end();
        String valueOf = String.valueOf(String.valueOf(this.rawString));
        StringBuilder sb = new StringBuilder(valueOf.length() + 43);
        sb.append("PhoneNumberMatch [");
        sb.append(start2);
        sb.append(",");
        sb.append(end);
        sb.append(") ");
        sb.append(valueOf);
        return sb.toString();
    }
}
