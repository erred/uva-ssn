package com.google.i18n.phonenumbers;

import com.google.i18n.phonenumbers.PhoneNumberUtil.Leniency;
import com.google.i18n.phonenumbers.PhoneNumberUtil.MatchType;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.google.i18n.phonenumbers.Phonemetadata.NumberFormat;
import com.google.i18n.phonenumbers.Phonemetadata.PhoneMetadata;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber.CountryCodeSource;
import java.lang.Character.UnicodeBlock;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class PhoneNumberMatcher implements Iterator<PhoneNumberMatch> {
    private static final Pattern[] INNER_MATCHES = {Pattern.compile("/+(.*)"), Pattern.compile("(\\([^(]*)"), Pattern.compile("(?:\\p{Z}-|-\\p{Z})\\p{Z}*(.+)"), Pattern.compile("[‒-―－]\\p{Z}*(.+)"), Pattern.compile("\\.+\\p{Z}*([^.]+)"), Pattern.compile("\\p{Z}+(\\P{Z}+)")};
    private static final Pattern LEAD_CLASS;
    private static final Pattern MATCHING_BRACKETS;
    private static final Pattern PATTERN;
    private static final Pattern PUB_PAGES = Pattern.compile("\\d{1,5}-+\\d{1,5}\\s{0,4}\\(\\d{1,4}");
    private static final Pattern SLASH_SEPARATED_DATES = Pattern.compile("(?:(?:[0-3]?\\d/[01]?\\d)|(?:[01]?\\d/[0-3]?\\d))/(?:[12]\\d)?\\d{2}");
    private static final Pattern TIME_STAMPS = Pattern.compile("[12]\\d{3}[-/]?[01]\\d[-/]?[0-3]\\d +[0-2]\\d$");
    private static final Pattern TIME_STAMPS_SUFFIX = Pattern.compile(":[0-5]\\d");
    private PhoneNumberMatch lastMatch = null;
    private final Leniency leniency;
    private long maxTries;
    private final PhoneNumberUtil phoneUtil;
    private final String preferredRegion;
    private int searchIndex = 0;
    private State state = State.NOT_READY;
    private final CharSequence text;

    interface NumberGroupingChecker {
        boolean checkGroups(PhoneNumberUtil phoneNumberUtil, PhoneNumber phoneNumber, StringBuilder sb, String[] strArr);
    }

    private enum State {
        NOT_READY,
        READY,
        DONE
    }

    static {
        String str = "(\\[（［";
        String str2 = ")\\]）］";
        String valueOf = String.valueOf(String.valueOf(str));
        String valueOf2 = String.valueOf(String.valueOf(str2));
        StringBuilder sb = new StringBuilder(valueOf.length() + 3 + valueOf2.length());
        sb.append("[^");
        sb.append(valueOf);
        sb.append(valueOf2);
        sb.append("]");
        String sb2 = sb.toString();
        String limit = limit(0, 3);
        String valueOf3 = String.valueOf(String.valueOf(str));
        String valueOf4 = String.valueOf(String.valueOf(sb2));
        String valueOf5 = String.valueOf(String.valueOf(str2));
        String valueOf6 = String.valueOf(String.valueOf(sb2));
        String valueOf7 = String.valueOf(String.valueOf(str));
        String valueOf8 = String.valueOf(String.valueOf(sb2));
        String valueOf9 = String.valueOf(String.valueOf(str2));
        String valueOf10 = String.valueOf(String.valueOf(limit));
        String valueOf11 = String.valueOf(String.valueOf(sb2));
        StringBuilder sb3 = new StringBuilder(valueOf3.length() + 26 + valueOf4.length() + valueOf5.length() + valueOf6.length() + valueOf7.length() + valueOf8.length() + valueOf9.length() + valueOf10.length() + valueOf11.length());
        sb3.append("(?:[");
        sb3.append(valueOf3);
        sb3.append("])?");
        sb3.append("(?:");
        sb3.append(valueOf4);
        sb3.append("+");
        sb3.append("[");
        sb3.append(valueOf5);
        sb3.append("])?");
        sb3.append(valueOf6);
        sb3.append("+");
        sb3.append("(?:[");
        sb3.append(valueOf7);
        sb3.append("]");
        sb3.append(valueOf8);
        sb3.append("+[");
        sb3.append(valueOf9);
        sb3.append("])");
        sb3.append(valueOf10);
        sb3.append(valueOf11);
        sb3.append("*");
        MATCHING_BRACKETS = Pattern.compile(sb3.toString());
        String limit2 = limit(0, 2);
        String limit3 = limit(0, 4);
        String limit4 = limit(0, 20);
        String valueOf12 = String.valueOf("[-x‐-―−ー－-／  ­​⁠　()（）［］.\\[\\]/~⁓∼～]");
        String valueOf13 = String.valueOf(limit3);
        String concat = valueOf13.length() != 0 ? valueOf12.concat(valueOf13) : new String(valueOf12);
        String str3 = "\\p{Nd}";
        String valueOf14 = String.valueOf(limit(1, 20));
        String concat2 = valueOf14.length() != 0 ? str3.concat(valueOf14) : new String(str3);
        String valueOf15 = String.valueOf(str);
        String valueOf16 = String.valueOf("+＋");
        String valueOf17 = String.valueOf(String.valueOf(valueOf16.length() != 0 ? valueOf15.concat(valueOf16) : new String(valueOf15)));
        StringBuilder sb4 = new StringBuilder(valueOf17.length() + 2);
        sb4.append("[");
        sb4.append(valueOf17);
        sb4.append("]");
        String sb5 = sb4.toString();
        LEAD_CLASS = Pattern.compile(sb5);
        String valueOf18 = String.valueOf(String.valueOf(sb5));
        String valueOf19 = String.valueOf(String.valueOf(concat));
        String valueOf20 = String.valueOf(String.valueOf(limit2));
        String valueOf21 = String.valueOf(String.valueOf(concat2));
        String valueOf22 = String.valueOf(String.valueOf(concat));
        String valueOf23 = String.valueOf(String.valueOf(concat2));
        String valueOf24 = String.valueOf(String.valueOf(limit4));
        String valueOf25 = String.valueOf(String.valueOf(PhoneNumberUtil.EXTN_PATTERNS_FOR_MATCHING));
        StringBuilder sb6 = new StringBuilder(valueOf18.length() + 13 + valueOf19.length() + valueOf20.length() + valueOf21.length() + valueOf22.length() + valueOf23.length() + valueOf24.length() + valueOf25.length());
        sb6.append("(?:");
        sb6.append(valueOf18);
        sb6.append(valueOf19);
        sb6.append(")");
        sb6.append(valueOf20);
        sb6.append(valueOf21);
        sb6.append("(?:");
        sb6.append(valueOf22);
        sb6.append(valueOf23);
        sb6.append(")");
        sb6.append(valueOf24);
        sb6.append("(?:");
        sb6.append(valueOf25);
        sb6.append(")?");
        PATTERN = Pattern.compile(sb6.toString(), 66);
    }

    private static String limit(int i, int i2) {
        if (i < 0 || i2 <= 0 || i2 < i) {
            throw new IllegalArgumentException();
        }
        StringBuilder sb = new StringBuilder(25);
        sb.append("{");
        sb.append(i);
        sb.append(",");
        sb.append(i2);
        sb.append("}");
        return sb.toString();
    }

    PhoneNumberMatcher(PhoneNumberUtil phoneNumberUtil, CharSequence charSequence, String str, Leniency leniency2, long j) {
        if (phoneNumberUtil == null || leniency2 == null) {
            throw new NullPointerException();
        } else if (j >= 0) {
            this.phoneUtil = phoneNumberUtil;
            if (charSequence == null) {
                charSequence = "";
            }
            this.text = charSequence;
            this.preferredRegion = str;
            this.leniency = leniency2;
            this.maxTries = j;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private PhoneNumberMatch find(int i) {
        Matcher matcher = PATTERN.matcher(this.text);
        while (this.maxTries > 0 && matcher.find(i)) {
            int start = matcher.start();
            CharSequence trimAfterFirstMatch = trimAfterFirstMatch(PhoneNumberUtil.SECOND_NUMBER_START_PATTERN, this.text.subSequence(start, matcher.end()));
            PhoneNumberMatch extractMatch = extractMatch(trimAfterFirstMatch, start);
            if (extractMatch != null) {
                return extractMatch;
            }
            i = start + trimAfterFirstMatch.length();
            this.maxTries--;
        }
        return null;
    }

    private static CharSequence trimAfterFirstMatch(Pattern pattern, CharSequence charSequence) {
        Matcher matcher = pattern.matcher(charSequence);
        return matcher.find() ? charSequence.subSequence(0, matcher.start()) : charSequence;
    }

    static boolean isLatinLetter(char c) {
        boolean z = false;
        if (!Character.isLetter(c) && Character.getType(c) != 6) {
            return false;
        }
        UnicodeBlock of = UnicodeBlock.of(c);
        if (of.equals(UnicodeBlock.BASIC_LATIN) || of.equals(UnicodeBlock.LATIN_1_SUPPLEMENT) || of.equals(UnicodeBlock.LATIN_EXTENDED_A) || of.equals(UnicodeBlock.LATIN_EXTENDED_ADDITIONAL) || of.equals(UnicodeBlock.LATIN_EXTENDED_B) || of.equals(UnicodeBlock.COMBINING_DIACRITICAL_MARKS)) {
            z = true;
        }
        return z;
    }

    private static boolean isInvalidPunctuationSymbol(char c) {
        return c == '%' || Character.getType(c) == 26;
    }

    private PhoneNumberMatch extractMatch(CharSequence charSequence, int i) {
        if (SLASH_SEPARATED_DATES.matcher(charSequence).find()) {
            return null;
        }
        if (TIME_STAMPS.matcher(charSequence).find()) {
            if (TIME_STAMPS_SUFFIX.matcher(this.text.toString().substring(charSequence.length() + i)).lookingAt()) {
                return null;
            }
        }
        String charSequence2 = charSequence.toString();
        PhoneNumberMatch parseAndVerify = parseAndVerify(charSequence2, i);
        if (parseAndVerify != null) {
            return parseAndVerify;
        }
        return extractInnerMatch(charSequence2, i);
    }

    private PhoneNumberMatch extractInnerMatch(String str, int i) {
        for (Pattern matcher : INNER_MATCHES) {
            Matcher matcher2 = matcher.matcher(str);
            boolean z = true;
            while (matcher2.find() && this.maxTries > 0) {
                if (z) {
                    PhoneNumberMatch parseAndVerify = parseAndVerify(trimAfterFirstMatch(PhoneNumberUtil.UNWANTED_END_CHAR_PATTERN, str.substring(0, matcher2.start())).toString(), i);
                    if (parseAndVerify != null) {
                        return parseAndVerify;
                    }
                    this.maxTries--;
                    z = false;
                }
                PhoneNumberMatch parseAndVerify2 = parseAndVerify(trimAfterFirstMatch(PhoneNumberUtil.UNWANTED_END_CHAR_PATTERN, matcher2.group(1)).toString(), matcher2.start(1) + i);
                if (parseAndVerify2 != null) {
                    return parseAndVerify2;
                }
                this.maxTries--;
            }
        }
        return null;
    }

    private PhoneNumberMatch parseAndVerify(String str, int i) {
        try {
            if (MATCHING_BRACKETS.matcher(str).matches()) {
                if (!PUB_PAGES.matcher(str).find()) {
                    if (this.leniency.compareTo(Leniency.VALID) >= 0) {
                        if (i > 0 && !LEAD_CLASS.matcher(str).lookingAt()) {
                            char charAt = this.text.charAt(i - 1);
                            if (isInvalidPunctuationSymbol(charAt) || isLatinLetter(charAt)) {
                                return null;
                            }
                        }
                        int length = str.length() + i;
                        if (length < this.text.length()) {
                            char charAt2 = this.text.charAt(length);
                            if (isInvalidPunctuationSymbol(charAt2) || isLatinLetter(charAt2)) {
                                return null;
                            }
                        }
                    }
                    PhoneNumber parseAndKeepRawInput = this.phoneUtil.parseAndKeepRawInput(str, this.preferredRegion);
                    if ((!this.phoneUtil.getRegionCodeForCountryCode(parseAndKeepRawInput.getCountryCode()).equals("IL") || this.phoneUtil.getNationalSignificantNumber(parseAndKeepRawInput).length() != 4 || (i != 0 && (i <= 0 || this.text.charAt(i - 1) == '*'))) && this.leniency.verify(parseAndKeepRawInput, str, this.phoneUtil)) {
                        parseAndKeepRawInput.clearCountryCodeSource();
                        parseAndKeepRawInput.clearRawInput();
                        parseAndKeepRawInput.clearPreferredDomesticCarrierCode();
                        return new PhoneNumberMatch(i, str, parseAndKeepRawInput);
                    }
                    return null;
                }
            }
            return null;
        } catch (NumberParseException unused) {
        }
    }

    static boolean allNumberGroupsRemainGrouped(PhoneNumberUtil phoneNumberUtil, PhoneNumber phoneNumber, StringBuilder sb, String[] strArr) {
        int i;
        if (phoneNumber.getCountryCodeSource() != CountryCodeSource.FROM_DEFAULT_COUNTRY) {
            String num = Integer.toString(phoneNumber.getCountryCode());
            i = num.length() + sb.indexOf(num);
        } else {
            i = 0;
        }
        int i2 = i;
        int i3 = 0;
        while (i3 < strArr.length) {
            int indexOf = sb.indexOf(strArr[i3], i2);
            if (indexOf < 0) {
                return false;
            }
            i2 = indexOf + strArr[i3].length();
            if (i3 != 0 || i2 >= sb.length() || phoneNumberUtil.getNddPrefixForRegion(phoneNumberUtil.getRegionCodeForCountryCode(phoneNumber.getCountryCode()), true) == null || !Character.isDigit(sb.charAt(i2))) {
                i3++;
            } else {
                return sb.substring(i2 - strArr[i3].length()).startsWith(phoneNumberUtil.getNationalSignificantNumber(phoneNumber));
            }
        }
        return sb.substring(i2).contains(phoneNumber.getExtension());
    }

    static boolean allNumberGroupsAreExactlyPresent(PhoneNumberUtil phoneNumberUtil, PhoneNumber phoneNumber, StringBuilder sb, String[] strArr) {
        boolean z;
        String[] split = PhoneNumberUtil.NON_DIGITS_PATTERN.split(sb.toString());
        int length = phoneNumber.hasExtension() ? split.length - 2 : split.length - 1;
        if (split.length == 1 || split[length].contains(phoneNumberUtil.getNationalSignificantNumber(phoneNumber))) {
            return true;
        }
        int length2 = strArr.length - 1;
        while (true) {
            z = false;
            if (length2 <= 0 || length < 0) {
                if (length >= 0 && split[length].endsWith(strArr[0])) {
                    z = true;
                }
            } else if (!split[length].equals(strArr[length2])) {
                return false;
            } else {
                length2--;
                length--;
            }
        }
        z = true;
        return z;
    }

    private static String[] getNationalNumberGroups(PhoneNumberUtil phoneNumberUtil, PhoneNumber phoneNumber, NumberFormat numberFormat) {
        if (numberFormat != null) {
            return phoneNumberUtil.formatNsnUsingPattern(phoneNumberUtil.getNationalSignificantNumber(phoneNumber), numberFormat, PhoneNumberFormat.RFC3966).split("-");
        }
        String format = phoneNumberUtil.format(phoneNumber, PhoneNumberFormat.RFC3966);
        int indexOf = format.indexOf(59);
        if (indexOf < 0) {
            indexOf = format.length();
        }
        return format.substring(format.indexOf(45) + 1, indexOf).split("-");
    }

    static boolean checkNumberGroupingIsValid(PhoneNumber phoneNumber, String str, PhoneNumberUtil phoneNumberUtil, NumberGroupingChecker numberGroupingChecker) {
        StringBuilder normalizeDigits = PhoneNumberUtil.normalizeDigits(str, true);
        if (numberGroupingChecker.checkGroups(phoneNumberUtil, phoneNumber, normalizeDigits, getNationalNumberGroups(phoneNumberUtil, phoneNumber, null))) {
            return true;
        }
        PhoneMetadata alternateFormatsForCountry = MetadataManager.getAlternateFormatsForCountry(phoneNumber.getCountryCode());
        if (alternateFormatsForCountry != null) {
            for (NumberFormat nationalNumberGroups : alternateFormatsForCountry.numberFormats()) {
                if (numberGroupingChecker.checkGroups(phoneNumberUtil, phoneNumber, normalizeDigits, getNationalNumberGroups(phoneNumberUtil, phoneNumber, nationalNumberGroups))) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean containsMoreThanOneSlashInNationalNumber(PhoneNumber phoneNumber, String str) {
        int indexOf = str.indexOf(47);
        if (indexOf < 0) {
            return false;
        }
        int indexOf2 = str.indexOf(47, indexOf + 1);
        if (indexOf2 < 0) {
            return false;
        }
        if (!(phoneNumber.getCountryCodeSource() == CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN || phoneNumber.getCountryCodeSource() == CountryCodeSource.FROM_NUMBER_WITHOUT_PLUS_SIGN) || !PhoneNumberUtil.normalizeDigitsOnly(str.substring(0, indexOf)).equals(Integer.toString(phoneNumber.getCountryCode()))) {
            return true;
        }
        return str.substring(indexOf2 + 1).contains("/");
    }

    static boolean containsOnlyValidXChars(PhoneNumber phoneNumber, String str, PhoneNumberUtil phoneNumberUtil) {
        int i = 0;
        while (i < str.length() - 1) {
            char charAt = str.charAt(i);
            if (charAt == 'x' || charAt == 'X') {
                int i2 = i + 1;
                char charAt2 = str.charAt(i2);
                if (charAt2 == 'x' || charAt2 == 'X') {
                    if (phoneNumberUtil.isNumberMatch(phoneNumber, str.substring(i2)) != MatchType.NSN_MATCH) {
                        return false;
                    }
                    i = i2;
                } else if (!PhoneNumberUtil.normalizeDigitsOnly(str.substring(i)).equals(phoneNumber.getExtension())) {
                    return false;
                }
            }
            i++;
        }
        return true;
    }

    static boolean isNationalPrefixPresentIfRequired(PhoneNumber phoneNumber, PhoneNumberUtil phoneNumberUtil) {
        if (phoneNumber.getCountryCodeSource() != CountryCodeSource.FROM_DEFAULT_COUNTRY) {
            return true;
        }
        PhoneMetadata metadataForRegion = phoneNumberUtil.getMetadataForRegion(phoneNumberUtil.getRegionCodeForCountryCode(phoneNumber.getCountryCode()));
        if (metadataForRegion == null) {
            return true;
        }
        NumberFormat chooseFormattingPatternForNumber = phoneNumberUtil.chooseFormattingPatternForNumber(metadataForRegion.numberFormats(), phoneNumberUtil.getNationalSignificantNumber(phoneNumber));
        if (chooseFormattingPatternForNumber == null || chooseFormattingPatternForNumber.getNationalPrefixFormattingRule().length() <= 0 || chooseFormattingPatternForNumber.isNationalPrefixOptionalWhenFormatting() || PhoneNumberUtil.formattingRuleHasFirstGroupOnly(chooseFormattingPatternForNumber.getNationalPrefixFormattingRule())) {
            return true;
        }
        return phoneNumberUtil.maybeStripNationalPrefixAndCarrierCode(new StringBuilder(PhoneNumberUtil.normalizeDigitsOnly(phoneNumber.getRawInput())), metadataForRegion, null);
    }

    public boolean hasNext() {
        if (this.state == State.NOT_READY) {
            this.lastMatch = find(this.searchIndex);
            if (this.lastMatch == null) {
                this.state = State.DONE;
            } else {
                this.searchIndex = this.lastMatch.end();
                this.state = State.READY;
            }
        }
        return this.state == State.READY;
    }

    public PhoneNumberMatch next() {
        if (hasNext()) {
            PhoneNumberMatch phoneNumberMatch = this.lastMatch;
            this.lastMatch = null;
            this.state = State.NOT_READY;
            return phoneNumberMatch;
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
