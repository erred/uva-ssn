package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.core.p116io.NumberInput;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class StdDateFormat extends DateFormat {
    protected static final String[] ALL_FORMATS = {DATE_FORMAT_STR_ISO8601, DATE_FORMAT_STR_ISO8601_Z, DATE_FORMAT_STR_ISO8601_NO_TZ, DATE_FORMAT_STR_RFC1123, DATE_FORMAT_STR_PLAIN};
    protected static final DateFormat DATE_FORMAT_ISO8601 = new SimpleDateFormat(DATE_FORMAT_STR_ISO8601, DEFAULT_LOCALE);
    protected static final DateFormat DATE_FORMAT_ISO8601_NO_TZ = new SimpleDateFormat(DATE_FORMAT_STR_ISO8601_NO_TZ, DEFAULT_LOCALE);
    protected static final DateFormat DATE_FORMAT_ISO8601_Z = new SimpleDateFormat(DATE_FORMAT_STR_ISO8601_Z, DEFAULT_LOCALE);
    protected static final DateFormat DATE_FORMAT_PLAIN = new SimpleDateFormat(DATE_FORMAT_STR_PLAIN, DEFAULT_LOCALE);
    protected static final DateFormat DATE_FORMAT_RFC1123 = new SimpleDateFormat(DATE_FORMAT_STR_RFC1123, DEFAULT_LOCALE);
    public static final String DATE_FORMAT_STR_ISO8601 = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
    protected static final String DATE_FORMAT_STR_ISO8601_NO_TZ = "yyyy-MM-dd'T'HH:mm:ss.SSS";
    protected static final String DATE_FORMAT_STR_ISO8601_Z = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    protected static final String DATE_FORMAT_STR_PLAIN = "yyyy-MM-dd";
    protected static final String DATE_FORMAT_STR_RFC1123 = "EEE, dd MMM yyyy HH:mm:ss zzz";
    private static final Locale DEFAULT_LOCALE = Locale.US;
    private static final TimeZone DEFAULT_TIMEZONE = TimeZone.getTimeZone("UTC");
    public static final StdDateFormat instance = new StdDateFormat();
    protected transient DateFormat _formatISO8601;
    protected transient DateFormat _formatISO8601_noTz;
    protected transient DateFormat _formatISO8601_z;
    protected transient DateFormat _formatPlain;
    protected transient DateFormat _formatRFC1123;
    protected Boolean _lenient;
    protected final Locale _locale;
    protected transient TimeZone _timezone;

    public boolean equals(Object obj) {
        return obj == this;
    }

    static {
        DATE_FORMAT_RFC1123.setTimeZone(DEFAULT_TIMEZONE);
        DATE_FORMAT_ISO8601.setTimeZone(DEFAULT_TIMEZONE);
        DATE_FORMAT_ISO8601_Z.setTimeZone(DEFAULT_TIMEZONE);
        DATE_FORMAT_ISO8601_NO_TZ.setTimeZone(DEFAULT_TIMEZONE);
        DATE_FORMAT_PLAIN.setTimeZone(DEFAULT_TIMEZONE);
    }

    public StdDateFormat() {
        this._locale = DEFAULT_LOCALE;
    }

    @Deprecated
    public StdDateFormat(TimeZone timeZone, Locale locale) {
        this._timezone = timeZone;
        this._locale = locale;
    }

    protected StdDateFormat(TimeZone timeZone, Locale locale, Boolean bool) {
        this._timezone = timeZone;
        this._locale = locale;
        this._lenient = bool;
    }

    public static TimeZone getDefaultTimeZone() {
        return DEFAULT_TIMEZONE;
    }

    public StdDateFormat withTimeZone(TimeZone timeZone) {
        if (timeZone == null) {
            timeZone = DEFAULT_TIMEZONE;
        }
        return (timeZone == this._timezone || timeZone.equals(this._timezone)) ? this : new StdDateFormat(timeZone, this._locale, this._lenient);
    }

    public StdDateFormat withLocale(Locale locale) {
        if (locale.equals(this._locale)) {
            return this;
        }
        return new StdDateFormat(this._timezone, locale, this._lenient);
    }

    public StdDateFormat clone() {
        return new StdDateFormat(this._timezone, this._locale, this._lenient);
    }

    @Deprecated
    public static DateFormat getISO8601Format(TimeZone timeZone) {
        return getISO8601Format(timeZone, DEFAULT_LOCALE);
    }

    public static DateFormat getISO8601Format(TimeZone timeZone, Locale locale) {
        return _cloneFormat(DATE_FORMAT_ISO8601, DATE_FORMAT_STR_ISO8601, timeZone, locale, null);
    }

    public static DateFormat getRFC1123Format(TimeZone timeZone, Locale locale) {
        return _cloneFormat(DATE_FORMAT_RFC1123, DATE_FORMAT_STR_RFC1123, timeZone, locale, null);
    }

    @Deprecated
    public static DateFormat getRFC1123Format(TimeZone timeZone) {
        return getRFC1123Format(timeZone, DEFAULT_LOCALE);
    }

    public TimeZone getTimeZone() {
        return this._timezone;
    }

    public void setTimeZone(TimeZone timeZone) {
        if (!timeZone.equals(this._timezone)) {
            _clearFormats();
            this._timezone = timeZone;
        }
    }

    public void setLenient(boolean z) {
        Boolean valueOf = Boolean.valueOf(z);
        if (this._lenient != valueOf) {
            this._lenient = valueOf;
            _clearFormats();
        }
    }

    public boolean isLenient() {
        if (this._lenient == null) {
            return true;
        }
        return this._lenient.booleanValue();
    }

    public Date parse(String str) throws ParseException {
        Date date;
        String[] strArr;
        String trim = str.trim();
        ParsePosition parsePosition = new ParsePosition(0);
        if (looksLikeISO8601(trim)) {
            date = parseAsISO8601(trim, parsePosition, true);
        } else {
            int length = trim.length();
            while (true) {
                length--;
                if (length < 0) {
                    break;
                }
                char charAt = trim.charAt(length);
                if ((charAt < '0' || charAt > '9') && (length > 0 || charAt != '-')) {
                    break;
                }
            }
            if (length >= 0 || (trim.charAt(0) != '-' && !NumberInput.inLongRange(trim, false))) {
                date = parseAsRFC1123(trim, parsePosition);
            } else {
                date = new Date(Long.parseLong(trim));
            }
        }
        if (date != null) {
            return date;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : ALL_FORMATS) {
            if (sb.length() > 0) {
                sb.append("\", \"");
            } else {
                sb.append('\"');
            }
            sb.append(str2);
        }
        sb.append('\"');
        throw new ParseException(String.format("Can not parse date \"%s\": not compatible with any of standard forms (%s)", new Object[]{trim, sb.toString()}), parsePosition.getErrorIndex());
    }

    public Date parse(String str, ParsePosition parsePosition) {
        if (looksLikeISO8601(str)) {
            try {
                return parseAsISO8601(str, parsePosition, false);
            } catch (ParseException unused) {
                return null;
            }
        } else {
            int length = str.length();
            while (true) {
                length--;
                if (length < 0) {
                    break;
                }
                char charAt = str.charAt(length);
                if ((charAt < '0' || charAt > '9') && (length > 0 || charAt != '-')) {
                    break;
                }
            }
            if (length >= 0 || (str.charAt(0) != '-' && !NumberInput.inLongRange(str, false))) {
                return parseAsRFC1123(str, parsePosition);
            }
            return new Date(Long.parseLong(str));
        }
    }

    public StringBuffer format(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (this._formatISO8601 == null) {
            this._formatISO8601 = _cloneFormat(DATE_FORMAT_ISO8601, DATE_FORMAT_STR_ISO8601, this._timezone, this._locale, this._lenient);
        }
        return this._formatISO8601.format(date, stringBuffer, fieldPosition);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DateFormat ");
        sb.append(getClass().getName());
        String sb2 = sb.toString();
        TimeZone timeZone = this._timezone;
        if (timeZone != null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            sb3.append(" (timezone: ");
            sb3.append(timeZone);
            sb3.append(")");
            sb2 = sb3.toString();
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append(sb2);
        sb4.append("(locale: ");
        sb4.append(this._locale);
        sb4.append(")");
        return sb4.toString();
    }

    public int hashCode() {
        return System.identityHashCode(this);
    }

    /* access modifiers changed from: protected */
    public boolean looksLikeISO8601(String str) {
        return str.length() >= 5 && Character.isDigit(str.charAt(0)) && Character.isDigit(str.charAt(3)) && str.charAt(4) == '-';
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00cf, code lost:
        r1.insert(r12, ":00.000");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00d4, code lost:
        r10 = r1.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0108, code lost:
        r0.append('0');
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x010b, code lost:
        r0.append('0');
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x010e, code lost:
        r10 = r0.toString();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Date parseAsISO8601(java.lang.String r10, java.text.ParsePosition r11, boolean r12) throws java.text.ParseException {
        /*
            r9 = this;
            int r12 = r10.length()
            int r0 = r12 + -1
            char r1 = r10.charAt(r0)
            r2 = 2
            r3 = 1
            r4 = 10
            if (r12 > r4) goto L_0x002c
            boolean r4 = java.lang.Character.isDigit(r1)
            if (r4 == 0) goto L_0x002c
            java.text.DateFormat r12 = r9._formatPlain
            java.lang.String r0 = "yyyy-MM-dd"
            if (r12 != 0) goto L_0x0126
            java.text.DateFormat r12 = DATE_FORMAT_PLAIN
            java.util.TimeZone r1 = r9._timezone
            java.util.Locale r4 = r9._locale
            java.lang.Boolean r5 = r9._lenient
            java.text.DateFormat r12 = _cloneFormat(r12, r0, r1, r4, r5)
            r9._formatPlain = r12
            goto L_0x0126
        L_0x002c:
            r4 = 90
            r5 = 58
            if (r1 != r4) goto L_0x0060
            java.text.DateFormat r1 = r9._formatISO8601_z
            java.lang.String r4 = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
            if (r1 != 0) goto L_0x0046
            java.text.DateFormat r1 = DATE_FORMAT_ISO8601_Z
            java.util.TimeZone r6 = DEFAULT_TIMEZONE
            java.util.Locale r7 = r9._locale
            java.lang.Boolean r8 = r9._lenient
            java.text.DateFormat r1 = _cloneFormat(r1, r4, r6, r7, r8)
            r9._formatISO8601_z = r1
        L_0x0046:
            int r12 = r12 + -4
            char r12 = r10.charAt(r12)
            if (r12 != r5) goto L_0x005c
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>(r10)
            java.lang.String r10 = ".000"
            r12.insert(r0, r10)
            java.lang.String r10 = r12.toString()
        L_0x005c:
            r12 = r1
            r0 = r4
            goto L_0x0126
        L_0x0060:
            boolean r0 = hasTimeZone(r10)
            r1 = 12
            r4 = 84
            r6 = 48
            if (r0 == 0) goto L_0x00ef
            int r0 = r12 + -3
            char r7 = r10.charAt(r0)
            if (r7 != r5) goto L_0x0082
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r10)
            int r12 = r12 - r2
            r5.delete(r0, r12)
            java.lang.String r10 = r5.toString()
            goto L_0x009b
        L_0x0082:
            r12 = 43
            if (r7 == r12) goto L_0x008a
            r12 = 45
            if (r7 != r12) goto L_0x009b
        L_0x008a:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r10)
            java.lang.String r10 = "00"
            r12.append(r10)
            java.lang.String r10 = r12.toString()
        L_0x009b:
            int r12 = r10.length()
            int r0 = r10.lastIndexOf(r4)
            int r0 = r12 - r0
            int r0 = r0 + -6
            if (r0 >= r1) goto L_0x00d8
            int r12 = r12 + -5
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r10)
            switch(r0) {
                case 5: goto L_0x00cf;
                case 6: goto L_0x00ca;
                case 7: goto L_0x00d4;
                case 8: goto L_0x00c4;
                case 9: goto L_0x00be;
                case 10: goto L_0x00b8;
                case 11: goto L_0x00b4;
                default: goto L_0x00b3;
            }
        L_0x00b3:
            goto L_0x00d4
        L_0x00b4:
            r1.insert(r12, r6)
            goto L_0x00d4
        L_0x00b8:
            java.lang.String r10 = "00"
            r1.insert(r12, r10)
            goto L_0x00d4
        L_0x00be:
            java.lang.String r10 = "000"
            r1.insert(r12, r10)
            goto L_0x00d4
        L_0x00c4:
            java.lang.String r10 = ".000"
            r1.insert(r12, r10)
            goto L_0x00d4
        L_0x00ca:
            java.lang.String r10 = "00.000"
            r1.insert(r12, r10)
        L_0x00cf:
            java.lang.String r10 = ":00.000"
            r1.insert(r12, r10)
        L_0x00d4:
            java.lang.String r10 = r1.toString()
        L_0x00d8:
            java.text.DateFormat r12 = r9._formatISO8601
            java.lang.String r0 = "yyyy-MM-dd'T'HH:mm:ss.SSSZ"
            java.text.DateFormat r1 = r9._formatISO8601
            if (r1 != 0) goto L_0x0126
            java.text.DateFormat r12 = DATE_FORMAT_ISO8601
            java.util.TimeZone r1 = r9._timezone
            java.util.Locale r4 = r9._locale
            java.lang.Boolean r5 = r9._lenient
            java.text.DateFormat r12 = _cloneFormat(r12, r0, r1, r4, r5)
            r9._formatISO8601 = r12
            goto L_0x0126
        L_0x00ef:
            int r0 = r10.lastIndexOf(r4)
            int r12 = r12 - r0
            int r12 = r12 - r3
            if (r12 >= r1) goto L_0x0112
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r10)
            switch(r12) {
                case 9: goto L_0x010b;
                case 10: goto L_0x0108;
                case 11: goto L_0x0105;
                default: goto L_0x00ff;
            }
        L_0x00ff:
            java.lang.String r10 = ".000"
            r0.append(r10)
            goto L_0x010e
        L_0x0105:
            r0.append(r6)
        L_0x0108:
            r0.append(r6)
        L_0x010b:
            r0.append(r6)
        L_0x010e:
            java.lang.String r10 = r0.toString()
        L_0x0112:
            java.text.DateFormat r12 = r9._formatISO8601_noTz
            java.lang.String r0 = "yyyy-MM-dd'T'HH:mm:ss.SSS"
            if (r12 != 0) goto L_0x0126
            java.text.DateFormat r12 = DATE_FORMAT_ISO8601_NO_TZ
            java.util.TimeZone r1 = r9._timezone
            java.util.Locale r4 = r9._locale
            java.lang.Boolean r5 = r9._lenient
            java.text.DateFormat r12 = _cloneFormat(r12, r0, r1, r4, r5)
            r9._formatISO8601_noTz = r12
        L_0x0126:
            java.util.Date r12 = r12.parse(r10, r11)
            if (r12 == 0) goto L_0x012d
            return r12
        L_0x012d:
            java.text.ParseException r12 = new java.text.ParseException
            r1 = 3
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r4 = 0
            r1[r4] = r10
            r1[r3] = r0
            java.lang.Boolean r10 = r9._lenient
            r1[r2] = r10
            java.lang.String r10 = "Can not parse date \"%s\": while it seems to fit format '%s', parsing fails (leniency? %s)"
            java.lang.String r10 = java.lang.String.format(r10, r1)
            int r11 = r11.getErrorIndex()
            r12.<init>(r10, r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.util.StdDateFormat.parseAsISO8601(java.lang.String, java.text.ParsePosition, boolean):java.util.Date");
    }

    /* access modifiers changed from: protected */
    public Date parseAsRFC1123(String str, ParsePosition parsePosition) {
        if (this._formatRFC1123 == null) {
            this._formatRFC1123 = _cloneFormat(DATE_FORMAT_RFC1123, DATE_FORMAT_STR_RFC1123, this._timezone, this._locale, this._lenient);
        }
        return this._formatRFC1123.parse(str, parsePosition);
    }

    private static final boolean hasTimeZone(String str) {
        int length = str.length();
        if (length >= 6) {
            char charAt = str.charAt(length - 6);
            if (charAt == '+' || charAt == '-') {
                return true;
            }
            char charAt2 = str.charAt(length - 5);
            if (charAt2 == '+' || charAt2 == '-') {
                return true;
            }
            char charAt3 = str.charAt(length - 3);
            if (charAt3 == '+' || charAt3 == '-') {
                return true;
            }
        }
        return false;
    }

    private static final DateFormat _cloneFormat(DateFormat dateFormat, String str, TimeZone timeZone, Locale locale, Boolean bool) {
        DateFormat dateFormat2;
        if (!locale.equals(DEFAULT_LOCALE)) {
            dateFormat2 = new SimpleDateFormat(str, locale);
            if (timeZone == null) {
                timeZone = DEFAULT_TIMEZONE;
            }
            dateFormat2.setTimeZone(timeZone);
        } else {
            dateFormat2 = (DateFormat) dateFormat.clone();
            if (timeZone != null) {
                dateFormat2.setTimeZone(timeZone);
            }
        }
        if (bool != null) {
            dateFormat2.setLenient(bool.booleanValue());
        }
        return dateFormat2;
    }

    /* access modifiers changed from: protected */
    public void _clearFormats() {
        this._formatRFC1123 = null;
        this._formatISO8601 = null;
        this._formatISO8601_z = null;
        this._formatISO8601_noTz = null;
        this._formatPlain = null;
    }
}
