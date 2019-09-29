package com.google.i18n.phonenumbers;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.i18n.phonenumbers.NumberParseException.ErrorType;
import com.google.i18n.phonenumbers.Phonemetadata.NumberFormat;
import com.google.i18n.phonenumbers.Phonemetadata.PhoneMetadata;
import com.google.i18n.phonenumbers.Phonemetadata.PhoneNumberDesc;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber.CountryCodeSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberUtil {
    private static final Map<Character, Character> ALL_PLUS_NUMBER_GROUPING_SYMBOLS;
    private static final Map<Character, Character> ALPHA_MAPPINGS;
    private static final Map<Character, Character> ALPHA_PHONE_MAPPINGS;
    private static final Pattern CAPTURING_DIGIT_PATTERN = Pattern.compile("(\\p{Nd})");
    private static final String CAPTURING_EXTN_DIGITS = "(\\p{Nd}{1,7})";
    private static final Pattern CC_PATTERN = Pattern.compile("\\$CC");
    private static final String COLOMBIA_MOBILE_TO_FIXED_LINE_PREFIX = "3";
    private static final String DEFAULT_EXTN_PREFIX = " ext. ";
    static final MetadataLoader DEFAULT_METADATA_LOADER = new MetadataLoader() {
        public InputStream loadMetadata(String str) {
            return PhoneNumberUtil.class.getResourceAsStream(str);
        }
    };
    private static final Map<Character, Character> DIALLABLE_CHAR_MAPPINGS;
    private static final String DIGITS = "\\p{Nd}";
    private static final Pattern EXTN_PATTERN;
    static final String EXTN_PATTERNS_FOR_MATCHING;
    private static final String EXTN_PATTERNS_FOR_PARSING;
    private static final Pattern FG_PATTERN = Pattern.compile("\\$FG");
    private static final Pattern FIRST_GROUP_ONLY_PREFIX_PATTERN = Pattern.compile("\\(?\\$1\\)?");
    private static final Pattern FIRST_GROUP_PATTERN = Pattern.compile("(\\$\\d)");
    private static final int MAX_INPUT_STRING_LENGTH = 250;
    static final int MAX_LENGTH_COUNTRY_CODE = 3;
    static final int MAX_LENGTH_FOR_NSN = 17;
    private static final String META_DATA_FILE_PREFIX = "/com/google/i18n/phonenumbers/data/PhoneNumberMetadataProto";
    private static final int MIN_LENGTH_FOR_NSN = 2;
    private static final Map<Integer, String> MOBILE_TOKEN_MAPPINGS;
    private static final int NANPA_COUNTRY_CODE = 1;
    static final Pattern NON_DIGITS_PATTERN = Pattern.compile("(\\D+)");
    private static final Pattern NP_PATTERN = Pattern.compile("\\$NP");
    static final String PLUS_CHARS = "+＋";
    static final Pattern PLUS_CHARS_PATTERN = Pattern.compile("[+＋]+");
    static final char PLUS_SIGN = '+';
    static final int REGEX_FLAGS = 66;
    public static final String REGION_CODE_FOR_NON_GEO_ENTITY = "001";
    private static final String RFC3966_EXTN_PREFIX = ";ext=";
    private static final String RFC3966_ISDN_SUBADDRESS = ";isub=";
    private static final String RFC3966_PHONE_CONTEXT = ";phone-context=";
    private static final String RFC3966_PREFIX = "tel:";
    private static final String SECOND_NUMBER_START = "[\\\\/] *x";
    static final Pattern SECOND_NUMBER_START_PATTERN = Pattern.compile(SECOND_NUMBER_START);
    private static final Pattern SEPARATOR_PATTERN = Pattern.compile("[-x‐-―−ー－-／  ­​⁠　()（）［］.\\[\\]/~⁓∼～]+");
    private static final char STAR_SIGN = '*';
    private static final Pattern UNIQUE_INTERNATIONAL_PREFIX = Pattern.compile("[\\d]+(?:[~⁓∼～][\\d]+)?");
    private static final String UNKNOWN_REGION = "ZZ";
    private static final String UNWANTED_END_CHARS = "[[\\P{N}&&\\P{L}]&&[^#]]+$";
    static final Pattern UNWANTED_END_CHAR_PATTERN = Pattern.compile(UNWANTED_END_CHARS);
    private static final String VALID_ALPHA;
    private static final Pattern VALID_ALPHA_PHONE_PATTERN = Pattern.compile("(?:.*?[A-Za-z]){3}.*");
    private static final String VALID_PHONE_NUMBER;
    private static final Pattern VALID_PHONE_NUMBER_PATTERN;
    static final String VALID_PUNCTUATION = "-x‐-―−ー－-／  ­​⁠　()（）［］.\\[\\]/~⁓∼～";
    private static final String VALID_START_CHAR = "[+＋\\p{Nd}]";
    private static final Pattern VALID_START_CHAR_PATTERN = Pattern.compile(VALID_START_CHAR);
    private static PhoneNumberUtil instance = null;
    private static final Logger logger = Logger.getLogger(PhoneNumberUtil.class.getName());
    private final Map<Integer, List<String>> countryCallingCodeToRegionCodeMap;
    private final Map<Integer, PhoneMetadata> countryCodeToNonGeographicalMetadataMap = Collections.synchronizedMap(new HashMap());
    private final Set<Integer> countryCodesForNonGeographicalRegion = new HashSet();
    private final String currentFilePrefix;
    private final MetadataLoader metadataLoader;
    private final Set<String> nanpaRegions = new HashSet(35);
    private final RegexCache regexCache = new RegexCache(100);
    private final Map<String, PhoneMetadata> regionToMetadataMap = Collections.synchronizedMap(new HashMap());
    private final Set<String> supportedRegions = new HashSet(320);

    public enum Leniency {
        POSSIBLE {
            /* access modifiers changed from: 0000 */
            public boolean verify(PhoneNumber phoneNumber, String str, PhoneNumberUtil phoneNumberUtil) {
                return phoneNumberUtil.isPossibleNumber(phoneNumber);
            }
        },
        VALID {
            /* access modifiers changed from: 0000 */
            public boolean verify(PhoneNumber phoneNumber, String str, PhoneNumberUtil phoneNumberUtil) {
                if (!phoneNumberUtil.isValidNumber(phoneNumber) || !PhoneNumberMatcher.containsOnlyValidXChars(phoneNumber, str, phoneNumberUtil)) {
                    return false;
                }
                return PhoneNumberMatcher.isNationalPrefixPresentIfRequired(phoneNumber, phoneNumberUtil);
            }
        },
        STRICT_GROUPING {
            /* access modifiers changed from: 0000 */
            public boolean verify(PhoneNumber phoneNumber, String str, PhoneNumberUtil phoneNumberUtil) {
                if (!phoneNumberUtil.isValidNumber(phoneNumber) || !PhoneNumberMatcher.containsOnlyValidXChars(phoneNumber, str, phoneNumberUtil) || PhoneNumberMatcher.containsMoreThanOneSlashInNationalNumber(phoneNumber, str) || !PhoneNumberMatcher.isNationalPrefixPresentIfRequired(phoneNumber, phoneNumberUtil)) {
                    return false;
                }
                return PhoneNumberMatcher.checkNumberGroupingIsValid(phoneNumber, str, phoneNumberUtil, new NumberGroupingChecker() {
                    public boolean checkGroups(PhoneNumberUtil phoneNumberUtil, PhoneNumber phoneNumber, StringBuilder sb, String[] strArr) {
                        return PhoneNumberMatcher.allNumberGroupsRemainGrouped(phoneNumberUtil, phoneNumber, sb, strArr);
                    }
                });
            }
        },
        EXACT_GROUPING {
            /* access modifiers changed from: 0000 */
            public boolean verify(PhoneNumber phoneNumber, String str, PhoneNumberUtil phoneNumberUtil) {
                if (!phoneNumberUtil.isValidNumber(phoneNumber) || !PhoneNumberMatcher.containsOnlyValidXChars(phoneNumber, str, phoneNumberUtil) || PhoneNumberMatcher.containsMoreThanOneSlashInNationalNumber(phoneNumber, str) || !PhoneNumberMatcher.isNationalPrefixPresentIfRequired(phoneNumber, phoneNumberUtil)) {
                    return false;
                }
                return PhoneNumberMatcher.checkNumberGroupingIsValid(phoneNumber, str, phoneNumberUtil, new NumberGroupingChecker() {
                    public boolean checkGroups(PhoneNumberUtil phoneNumberUtil, PhoneNumber phoneNumber, StringBuilder sb, String[] strArr) {
                        return PhoneNumberMatcher.allNumberGroupsAreExactlyPresent(phoneNumberUtil, phoneNumber, sb, strArr);
                    }
                });
            }
        };

        /* access modifiers changed from: 0000 */
        public abstract boolean verify(PhoneNumber phoneNumber, String str, PhoneNumberUtil phoneNumberUtil);
    }

    public enum MatchType {
        NOT_A_NUMBER,
        NO_MATCH,
        SHORT_NSN_MATCH,
        NSN_MATCH,
        EXACT_MATCH
    }

    public enum PhoneNumberFormat {
        E164,
        INTERNATIONAL,
        NATIONAL,
        RFC3966
    }

    public enum PhoneNumberType {
        FIXED_LINE,
        MOBILE,
        FIXED_LINE_OR_MOBILE,
        TOLL_FREE,
        PREMIUM_RATE,
        SHARED_COST,
        VOIP,
        PERSONAL_NUMBER,
        PAGER,
        UAN,
        VOICEMAIL,
        UNKNOWN
    }

    public enum ValidationResult {
        IS_POSSIBLE,
        INVALID_COUNTRY_CODE,
        TOO_SHORT,
        TOO_LONG
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf(52), "1");
        hashMap.put(Integer.valueOf(54), "9");
        MOBILE_TOKEN_MAPPINGS = Collections.unmodifiableMap(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(Character.valueOf('0'), Character.valueOf('0'));
        hashMap2.put(Character.valueOf('1'), Character.valueOf('1'));
        hashMap2.put(Character.valueOf('2'), Character.valueOf('2'));
        hashMap2.put(Character.valueOf('3'), Character.valueOf('3'));
        hashMap2.put(Character.valueOf('4'), Character.valueOf('4'));
        hashMap2.put(Character.valueOf('5'), Character.valueOf('5'));
        hashMap2.put(Character.valueOf('6'), Character.valueOf('6'));
        hashMap2.put(Character.valueOf('7'), Character.valueOf('7'));
        hashMap2.put(Character.valueOf('8'), Character.valueOf('8'));
        hashMap2.put(Character.valueOf('9'), Character.valueOf('9'));
        HashMap hashMap3 = new HashMap(40);
        hashMap3.put(Character.valueOf('A'), Character.valueOf('2'));
        hashMap3.put(Character.valueOf('B'), Character.valueOf('2'));
        hashMap3.put(Character.valueOf('C'), Character.valueOf('2'));
        hashMap3.put(Character.valueOf('D'), Character.valueOf('3'));
        hashMap3.put(Character.valueOf('E'), Character.valueOf('3'));
        hashMap3.put(Character.valueOf('F'), Character.valueOf('3'));
        hashMap3.put(Character.valueOf('G'), Character.valueOf('4'));
        hashMap3.put(Character.valueOf('H'), Character.valueOf('4'));
        hashMap3.put(Character.valueOf('I'), Character.valueOf('4'));
        hashMap3.put(Character.valueOf('J'), Character.valueOf('5'));
        hashMap3.put(Character.valueOf('K'), Character.valueOf('5'));
        hashMap3.put(Character.valueOf('L'), Character.valueOf('5'));
        hashMap3.put(Character.valueOf('M'), Character.valueOf('6'));
        hashMap3.put(Character.valueOf('N'), Character.valueOf('6'));
        hashMap3.put(Character.valueOf('O'), Character.valueOf('6'));
        hashMap3.put(Character.valueOf('P'), Character.valueOf('7'));
        hashMap3.put(Character.valueOf('Q'), Character.valueOf('7'));
        hashMap3.put(Character.valueOf('R'), Character.valueOf('7'));
        hashMap3.put(Character.valueOf('S'), Character.valueOf('7'));
        hashMap3.put(Character.valueOf('T'), Character.valueOf('8'));
        hashMap3.put(Character.valueOf('U'), Character.valueOf('8'));
        hashMap3.put(Character.valueOf('V'), Character.valueOf('8'));
        hashMap3.put(Character.valueOf('W'), Character.valueOf('9'));
        hashMap3.put(Character.valueOf('X'), Character.valueOf('9'));
        hashMap3.put(Character.valueOf('Y'), Character.valueOf('9'));
        hashMap3.put(Character.valueOf('Z'), Character.valueOf('9'));
        ALPHA_MAPPINGS = Collections.unmodifiableMap(hashMap3);
        HashMap hashMap4 = new HashMap(100);
        hashMap4.putAll(ALPHA_MAPPINGS);
        hashMap4.putAll(hashMap2);
        ALPHA_PHONE_MAPPINGS = Collections.unmodifiableMap(hashMap4);
        HashMap hashMap5 = new HashMap();
        hashMap5.putAll(hashMap2);
        hashMap5.put(Character.valueOf(PLUS_SIGN), Character.valueOf(PLUS_SIGN));
        hashMap5.put(Character.valueOf(STAR_SIGN), Character.valueOf(STAR_SIGN));
        DIALLABLE_CHAR_MAPPINGS = Collections.unmodifiableMap(hashMap5);
        HashMap hashMap6 = new HashMap();
        for (Character charValue : ALPHA_MAPPINGS.keySet()) {
            char charValue2 = charValue.charValue();
            hashMap6.put(Character.valueOf(Character.toLowerCase(charValue2)), Character.valueOf(charValue2));
            hashMap6.put(Character.valueOf(charValue2), Character.valueOf(charValue2));
        }
        hashMap6.putAll(hashMap2);
        hashMap6.put(Character.valueOf('-'), Character.valueOf('-'));
        hashMap6.put(Character.valueOf(65293), Character.valueOf('-'));
        hashMap6.put(Character.valueOf(8208), Character.valueOf('-'));
        hashMap6.put(Character.valueOf(8209), Character.valueOf('-'));
        hashMap6.put(Character.valueOf(8210), Character.valueOf('-'));
        hashMap6.put(Character.valueOf(8211), Character.valueOf('-'));
        hashMap6.put(Character.valueOf(8212), Character.valueOf('-'));
        hashMap6.put(Character.valueOf(8213), Character.valueOf('-'));
        hashMap6.put(Character.valueOf(8722), Character.valueOf('-'));
        hashMap6.put(Character.valueOf('/'), Character.valueOf('/'));
        hashMap6.put(Character.valueOf(65295), Character.valueOf('/'));
        hashMap6.put(Character.valueOf(' '), Character.valueOf(' '));
        hashMap6.put(Character.valueOf(12288), Character.valueOf(' '));
        hashMap6.put(Character.valueOf(8288), Character.valueOf(' '));
        hashMap6.put(Character.valueOf('.'), Character.valueOf('.'));
        hashMap6.put(Character.valueOf(65294), Character.valueOf('.'));
        ALL_PLUS_NUMBER_GROUPING_SYMBOLS = Collections.unmodifiableMap(hashMap6);
        String valueOf = String.valueOf(Arrays.toString(ALPHA_MAPPINGS.keySet().toArray()).replaceAll("[, \\[\\]]", ""));
        String valueOf2 = String.valueOf(Arrays.toString(ALPHA_MAPPINGS.keySet().toArray()).toLowerCase().replaceAll("[, \\[\\]]", ""));
        VALID_ALPHA = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        String valueOf3 = String.valueOf(String.valueOf("\\p{Nd}{2}|[+＋]*+(?:[-x‐-―−ー－-／  ­​⁠　()（）［］.\\[\\]/~⁓∼～*]*\\p{Nd}){3,}[-x‐-―−ー－-／  ­​⁠　()（）［］.\\[\\]/~⁓∼～*"));
        String valueOf4 = String.valueOf(String.valueOf(VALID_ALPHA));
        String valueOf5 = String.valueOf(String.valueOf(DIGITS));
        StringBuilder sb = new StringBuilder(valueOf3.length() + 2 + valueOf4.length() + valueOf5.length());
        sb.append(valueOf3);
        sb.append(valueOf4);
        sb.append(valueOf5);
        sb.append("]*");
        VALID_PHONE_NUMBER = sb.toString();
        String str = "xｘ#＃~～";
        String str2 = ",";
        String valueOf6 = String.valueOf(str);
        EXTN_PATTERNS_FOR_PARSING = createExtnPattern(valueOf6.length() != 0 ? str2.concat(valueOf6) : new String(str2));
        EXTN_PATTERNS_FOR_MATCHING = createExtnPattern(str);
        String valueOf7 = String.valueOf(String.valueOf(EXTN_PATTERNS_FOR_PARSING));
        StringBuilder sb2 = new StringBuilder(valueOf7.length() + 5);
        sb2.append("(?:");
        sb2.append(valueOf7);
        sb2.append(")$");
        EXTN_PATTERN = Pattern.compile(sb2.toString(), 66);
        String valueOf8 = String.valueOf(String.valueOf(VALID_PHONE_NUMBER));
        String valueOf9 = String.valueOf(String.valueOf(EXTN_PATTERNS_FOR_PARSING));
        StringBuilder sb3 = new StringBuilder(valueOf8.length() + 5 + valueOf9.length());
        sb3.append(valueOf8);
        sb3.append("(?:");
        sb3.append(valueOf9);
        sb3.append(")?");
        VALID_PHONE_NUMBER_PATTERN = Pattern.compile(sb3.toString(), 66);
    }

    private static String createExtnPattern(String str) {
        String valueOf = String.valueOf(String.valueOf(";ext=(\\p{Nd}{1,7})|[  \\t,]*(?:e?xt(?:ensi(?:ó?|ó))?n?|ｅ?ｘｔｎ?|["));
        String valueOf2 = String.valueOf(String.valueOf(str));
        String valueOf3 = String.valueOf(String.valueOf(CAPTURING_EXTN_DIGITS));
        String valueOf4 = String.valueOf(String.valueOf(DIGITS));
        StringBuilder sb = new StringBuilder(valueOf.length() + 48 + valueOf2.length() + valueOf3.length() + valueOf4.length());
        sb.append(valueOf);
        sb.append(valueOf2);
        sb.append("]|int|anexo|ｉｎｔ)");
        sb.append("[:\\.．]?[  \\t,-]*");
        sb.append(valueOf3);
        sb.append("#?|");
        sb.append("[- ]+(");
        sb.append(valueOf4);
        sb.append("{1,5})#");
        return sb.toString();
    }

    PhoneNumberUtil(String str, MetadataLoader metadataLoader2, Map<Integer, List<String>> map) {
        this.currentFilePrefix = str;
        this.metadataLoader = metadataLoader2;
        this.countryCallingCodeToRegionCodeMap = map;
        for (Entry entry : map.entrySet()) {
            List list = (List) entry.getValue();
            if (list.size() != 1 || !REGION_CODE_FOR_NON_GEO_ENTITY.equals(list.get(0))) {
                this.supportedRegions.addAll(list);
            } else {
                this.countryCodesForNonGeographicalRegion.add(entry.getKey());
            }
        }
        if (this.supportedRegions.remove(REGION_CODE_FOR_NON_GEO_ENTITY)) {
            logger.log(Level.WARNING, "invalid metadata (country calling code was mapped to the non-geo entity as well as specific region(s))");
        }
        this.nanpaRegions.addAll((Collection) map.get(Integer.valueOf(1)));
    }

    /* access modifiers changed from: 0000 */
    public void loadMetadataFromFile(String str, String str2, int i, MetadataLoader metadataLoader2) {
        boolean equals = REGION_CODE_FOR_NON_GEO_ENTITY.equals(str2);
        String valueOf = String.valueOf(String.valueOf(str));
        String valueOf2 = String.valueOf(String.valueOf(equals ? String.valueOf(i) : str2));
        StringBuilder sb = new StringBuilder(valueOf.length() + 1 + valueOf2.length());
        sb.append(valueOf);
        sb.append("_");
        sb.append(valueOf2);
        String sb2 = sb.toString();
        InputStream loadMetadata = metadataLoader2.loadMetadata(sb2);
        if (loadMetadata == null) {
            // Logger logger2 = logger;
            Level level = Level.SEVERE;
            String str3 = "missing metadata: ";
            String valueOf3 = String.valueOf(sb2);
            logger2.log(level, valueOf3.length() != 0 ? str3.concat(valueOf3) : new String(str3));
            String str4 = "missing metadata: ";
            String valueOf4 = String.valueOf(sb2);
            throw new IllegalStateException(valueOf4.length() != 0 ? str4.concat(valueOf4) : new String(str4));
        }
        try {
            List metadataList = loadMetadataAndCloseInput(new ObjectInputStream(loadMetadata)).getMetadataList();
            if (metadataList.isEmpty()) {
                // Logger logger3 = logger;
                Level level2 = Level.SEVERE;
                String str5 = "empty metadata: ";
                String valueOf5 = String.valueOf(sb2);
                logger3.log(level2, valueOf5.length() != 0 ? str5.concat(valueOf5) : new String(str5));
                String str6 = "empty metadata: ";
                String valueOf6 = String.valueOf(sb2);
                throw new IllegalStateException(valueOf6.length() != 0 ? str6.concat(valueOf6) : new String(str6));
            }
            if (metadataList.size() > 1) {
                // Logger logger4 = logger;
                Level level3 = Level.WARNING;
                String str7 = "invalid metadata (too many entries): ";
                String valueOf7 = String.valueOf(sb2);
                logger4.log(level3, valueOf7.length() != 0 ? str7.concat(valueOf7) : new String(str7));
            }
            PhoneMetadata phoneMetadata = (PhoneMetadata) metadataList.get(0);
            if (equals) {
                this.countryCodeToNonGeographicalMetadataMap.put(Integer.valueOf(i), phoneMetadata);
            } else {
                this.regionToMetadataMap.put(str2, phoneMetadata);
            }
        } catch (IOException e) {
            // Logger logger5 = logger;
            Level level4 = Level.SEVERE;
            String str8 = "cannot load/parse metadata: ";
            String valueOf8 = String.valueOf(sb2);
            logger5.log(level4, valueOf8.length() != 0 ? str8.concat(valueOf8) : new String(str8), e);
            String str9 = "cannot load/parse metadata: ";
            String valueOf9 = String.valueOf(sb2);
            throw new RuntimeException(valueOf9.length() != 0 ? str9.concat(valueOf9) : new String(str9), e);
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0030 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.i18n.phonenumbers.Phonemetadata.PhoneMetadataCollection loadMetadataAndCloseInput(java.io.ObjectInputStream r5) {
        /*
            com.google.i18n.phonenumbers.Phonemetadata$PhoneMetadataCollection r0 = new com.google.i18n.phonenumbers.Phonemetadata$PhoneMetadataCollection
            r0.<init>()
            r0.readExternal(r5)     // Catch:{ IOException -> 0x0017 }
            r5.close()     // Catch:{ IOException -> 0x000c }
            return r0
        L_0x000c:
            r5 = move-exception
            java.util.logging.Logger r1 = logger     // Catch:{ all -> 0x0016 }
            java.util.logging.Level r2 = java.util.logging.Level.WARNING     // Catch:{ all -> 0x0016 }
            java.lang.String r3 = "error closing input stream (ignored)"
            r1.log(r2, r3, r5)     // Catch:{ all -> 0x0016 }
        L_0x0016:
            return r0
        L_0x0017:
            r1 = move-exception
            java.util.logging.Logger r2 = logger     // Catch:{ all -> 0x0030 }
            java.util.logging.Level r3 = java.util.logging.Level.WARNING     // Catch:{ all -> 0x0030 }
            java.lang.String r4 = "error reading input (ignored)"
            r2.log(r3, r4, r1)     // Catch:{ all -> 0x0030 }
            r5.close()     // Catch:{ IOException -> 0x0025 }
            return r0
        L_0x0025:
            r5 = move-exception
            java.util.logging.Logger r1 = logger     // Catch:{ all -> 0x002f }
            java.util.logging.Level r2 = java.util.logging.Level.WARNING     // Catch:{ all -> 0x002f }
            java.lang.String r3 = "error closing input stream (ignored)"
            r1.log(r2, r3, r5)     // Catch:{ all -> 0x002f }
        L_0x002f:
            return r0
        L_0x0030:
            r5.close()     // Catch:{ IOException -> 0x0034 }
            return r0
        L_0x0034:
            r5 = move-exception
            java.util.logging.Logger r1 = logger     // Catch:{ all -> 0x003e }
            java.util.logging.Level r2 = java.util.logging.Level.WARNING     // Catch:{ all -> 0x003e }
            java.lang.String r3 = "error closing input stream (ignored)"
            r1.log(r2, r3, r5)     // Catch:{ all -> 0x003e }
        L_0x003e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.i18n.phonenumbers.PhoneNumberUtil.loadMetadataAndCloseInput(java.io.ObjectInputStream):com.google.i18n.phonenumbers.Phonemetadata$PhoneMetadataCollection");
    }

    static String extractPossibleNumber(String str) {
        Matcher matcher = VALID_START_CHAR_PATTERN.matcher(str);
        if (!matcher.find()) {
            return "";
        }
        String substring = str.substring(matcher.start());
        Matcher matcher2 = UNWANTED_END_CHAR_PATTERN.matcher(substring);
        if (matcher2.find()) {
            substring = substring.substring(0, matcher2.start());
            // Logger logger2 = logger;
            Level level = Level.FINER;
            String str2 = "Stripped trailing characters: ";
            String valueOf = String.valueOf(substring);
            logger2.log(level, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        }
        Matcher matcher3 = SECOND_NUMBER_START_PATTERN.matcher(substring);
        if (matcher3.find()) {
            substring = substring.substring(0, matcher3.start());
        }
        return substring;
    }

    static boolean isViablePhoneNumber(String str) {
        if (str.length() < 2) {
            return false;
        }
        return VALID_PHONE_NUMBER_PATTERN.matcher(str).matches();
    }

    static String normalize(String str) {
        if (VALID_ALPHA_PHONE_PATTERN.matcher(str).matches()) {
            return normalizeHelper(str, ALPHA_PHONE_MAPPINGS, true);
        }
        return normalizeDigitsOnly(str);
    }

    static void normalize(StringBuilder sb) {
        sb.replace(0, sb.length(), normalize(sb.toString()));
    }

    public static String normalizeDigitsOnly(String str) {
        return normalizeDigits(str, false).toString();
    }

    static StringBuilder normalizeDigits(String str, boolean z) {
        char[] charArray;
        StringBuilder sb = new StringBuilder(str.length());
        for (char c : str.toCharArray()) {
            int digit = Character.digit(c, 10);
            if (digit != -1) {
                sb.append(digit);
            } else if (z) {
                sb.append(c);
            }
        }
        return sb;
    }

    static String normalizeDiallableCharsOnly(String str) {
        return normalizeHelper(str, DIALLABLE_CHAR_MAPPINGS, true);
    }

    public static String convertAlphaCharactersInNumber(String str) {
        return normalizeHelper(str, ALPHA_PHONE_MAPPINGS, false);
    }

    public int getLengthOfGeographicalAreaCode(PhoneNumber phoneNumber) {
        PhoneMetadata metadataForRegion = getMetadataForRegion(getRegionCodeForNumber(phoneNumber));
        if (metadataForRegion == null) {
            return 0;
        }
        if ((metadataForRegion.hasNationalPrefix() || phoneNumber.isItalianLeadingZero()) && isNumberGeographical(phoneNumber)) {
            return getLengthOfNationalDestinationCode(phoneNumber);
        }
        return 0;
    }

    public int getLengthOfNationalDestinationCode(PhoneNumber phoneNumber) {
        PhoneNumber phoneNumber2;
        if (phoneNumber.hasExtension()) {
            phoneNumber2 = new PhoneNumber();
            phoneNumber2.mergeFrom(phoneNumber);
            phoneNumber2.clearExtension();
        } else {
            phoneNumber2 = phoneNumber;
        }
        String[] split = NON_DIGITS_PATTERN.split(format(phoneNumber2, PhoneNumberFormat.INTERNATIONAL));
        if (split.length <= 3) {
            return 0;
        }
        if (getNumberType(phoneNumber) != PhoneNumberType.MOBILE || getCountryMobileToken(phoneNumber.getCountryCode()).equals("")) {
            return split[2].length();
        }
        return split[2].length() + split[3].length();
    }

    public static String getCountryMobileToken(int i) {
        return MOBILE_TOKEN_MAPPINGS.containsKey(Integer.valueOf(i)) ? (String) MOBILE_TOKEN_MAPPINGS.get(Integer.valueOf(i)) : "";
    }

    private static String normalizeHelper(String str, Map<Character, Character> map, boolean z) {
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            Character ch = (Character) map.get(Character.valueOf(Character.toUpperCase(charAt)));
            if (ch != null) {
                sb.append(ch);
            } else if (!z) {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    static synchronized void setInstance(PhoneNumberUtil phoneNumberUtil) {
        synchronized (PhoneNumberUtil.class) {
            instance = phoneNumberUtil;
        }
    }

    public Set<String> getSupportedRegions() {
        return Collections.unmodifiableSet(this.supportedRegions);
    }

    public Set<Integer> getSupportedGlobalNetworkCallingCodes() {
        return Collections.unmodifiableSet(this.countryCodesForNonGeographicalRegion);
    }

    public static synchronized PhoneNumberUtil getInstance() {
        PhoneNumberUtil phoneNumberUtil;
        synchronized (PhoneNumberUtil.class) {
            if (instance == null) {
                setInstance(createInstance(DEFAULT_METADATA_LOADER));
            }
            phoneNumberUtil = instance;
        }
        return phoneNumberUtil;
    }

    public static PhoneNumberUtil createInstance(MetadataLoader metadataLoader2) {
        if (metadataLoader2 != null) {
            return new PhoneNumberUtil(META_DATA_FILE_PREFIX, metadataLoader2, CountryCodeToRegionCodeMap.getCountryCodeToRegionCodeMap());
        }
        throw new IllegalArgumentException("metadataLoader could not be null.");
    }

    static boolean formattingRuleHasFirstGroupOnly(String str) {
        return str.length() == 0 || FIRST_GROUP_ONLY_PREFIX_PATTERN.matcher(str).matches();
    }

    /* access modifiers changed from: 0000 */
    public boolean isNumberGeographical(PhoneNumber phoneNumber) {
        PhoneNumberType numberType = getNumberType(phoneNumber);
        return numberType == PhoneNumberType.FIXED_LINE || numberType == PhoneNumberType.FIXED_LINE_OR_MOBILE;
    }

    private boolean isValidRegionCode(String str) {
        return str != null && this.supportedRegions.contains(str);
    }

    private boolean hasValidCountryCallingCode(int i) {
        return this.countryCallingCodeToRegionCodeMap.containsKey(Integer.valueOf(i));
    }

    public String format(PhoneNumber phoneNumber, PhoneNumberFormat phoneNumberFormat) {
        if (phoneNumber.getNationalNumber() == 0 && phoneNumber.hasRawInput()) {
            String rawInput = phoneNumber.getRawInput();
            if (rawInput.length() > 0) {
                return rawInput;
            }
        }
        StringBuilder sb = new StringBuilder(20);
        format(phoneNumber, phoneNumberFormat, sb);
        return sb.toString();
    }

    public void format(PhoneNumber phoneNumber, PhoneNumberFormat phoneNumberFormat, StringBuilder sb) {
        sb.setLength(0);
        int countryCode = phoneNumber.getCountryCode();
        String nationalSignificantNumber = getNationalSignificantNumber(phoneNumber);
        if (phoneNumberFormat == PhoneNumberFormat.E164) {
            sb.append(nationalSignificantNumber);
            prefixNumberWithCountryCallingCode(countryCode, PhoneNumberFormat.E164, sb);
        } else if (!hasValidCountryCallingCode(countryCode)) {
            sb.append(nationalSignificantNumber);
        } else {
            PhoneMetadata metadataForRegionOrCallingCode = getMetadataForRegionOrCallingCode(countryCode, getRegionCodeForCountryCode(countryCode));
            sb.append(formatNsn(nationalSignificantNumber, metadataForRegionOrCallingCode, phoneNumberFormat));
            maybeAppendFormattedExtension(phoneNumber, metadataForRegionOrCallingCode, phoneNumberFormat, sb);
            prefixNumberWithCountryCallingCode(countryCode, phoneNumberFormat, sb);
        }
    }

    public String formatByPattern(PhoneNumber phoneNumber, PhoneNumberFormat phoneNumberFormat, List<NumberFormat> list) {
        int countryCode = phoneNumber.getCountryCode();
        String nationalSignificantNumber = getNationalSignificantNumber(phoneNumber);
        if (!hasValidCountryCallingCode(countryCode)) {
            return nationalSignificantNumber;
        }
        PhoneMetadata metadataForRegionOrCallingCode = getMetadataForRegionOrCallingCode(countryCode, getRegionCodeForCountryCode(countryCode));
        StringBuilder sb = new StringBuilder(20);
        NumberFormat chooseFormattingPatternForNumber = chooseFormattingPatternForNumber(list, nationalSignificantNumber);
        if (chooseFormattingPatternForNumber == null) {
            sb.append(nationalSignificantNumber);
        } else {
            NumberFormat numberFormat = new NumberFormat();
            numberFormat.mergeFrom(chooseFormattingPatternForNumber);
            String nationalPrefixFormattingRule = chooseFormattingPatternForNumber.getNationalPrefixFormattingRule();
            if (nationalPrefixFormattingRule.length() > 0) {
                String nationalPrefix = metadataForRegionOrCallingCode.getNationalPrefix();
                if (nationalPrefix.length() > 0) {
                    numberFormat.setNationalPrefixFormattingRule(FG_PATTERN.matcher(NP_PATTERN.matcher(nationalPrefixFormattingRule).replaceFirst(nationalPrefix)).replaceFirst("\\$1"));
                } else {
                    numberFormat.clearNationalPrefixFormattingRule();
                }
            }
            sb.append(formatNsnUsingPattern(nationalSignificantNumber, numberFormat, phoneNumberFormat));
        }
        maybeAppendFormattedExtension(phoneNumber, metadataForRegionOrCallingCode, phoneNumberFormat, sb);
        prefixNumberWithCountryCallingCode(countryCode, phoneNumberFormat, sb);
        return sb.toString();
    }

    public String formatNationalNumberWithCarrierCode(PhoneNumber phoneNumber, String str) {
        int countryCode = phoneNumber.getCountryCode();
        String nationalSignificantNumber = getNationalSignificantNumber(phoneNumber);
        if (!hasValidCountryCallingCode(countryCode)) {
            return nationalSignificantNumber;
        }
        PhoneMetadata metadataForRegionOrCallingCode = getMetadataForRegionOrCallingCode(countryCode, getRegionCodeForCountryCode(countryCode));
        StringBuilder sb = new StringBuilder(20);
        sb.append(formatNsn(nationalSignificantNumber, metadataForRegionOrCallingCode, PhoneNumberFormat.NATIONAL, str));
        maybeAppendFormattedExtension(phoneNumber, metadataForRegionOrCallingCode, PhoneNumberFormat.NATIONAL, sb);
        prefixNumberWithCountryCallingCode(countryCode, PhoneNumberFormat.NATIONAL, sb);
        return sb.toString();
    }

    private PhoneMetadata getMetadataForRegionOrCallingCode(int i, String str) {
        return REGION_CODE_FOR_NON_GEO_ENTITY.equals(str) ? getMetadataForNonGeographicalRegion(i) : getMetadataForRegion(str);
    }

    public String formatNationalNumberWithPreferredCarrierCode(PhoneNumber phoneNumber, String str) {
        if (phoneNumber.hasPreferredDomesticCarrierCode()) {
            str = phoneNumber.getPreferredDomesticCarrierCode();
        }
        return formatNationalNumberWithCarrierCode(phoneNumber, str);
    }

    public String formatNumberForMobileDialing(PhoneNumber phoneNumber, String str, boolean z) {
        String format;
        int countryCode = phoneNumber.getCountryCode();
        if (!hasValidCountryCallingCode(countryCode)) {
            return phoneNumber.hasRawInput() ? phoneNumber.getRawInput() : "";
        }
        String str2 = "";
        PhoneNumber clearExtension = new PhoneNumber().mergeFrom(phoneNumber).clearExtension();
        String regionCodeForCountryCode = getRegionCodeForCountryCode(countryCode);
        PhoneNumberType numberType = getNumberType(clearExtension);
        boolean z2 = false;
        boolean z3 = numberType != PhoneNumberType.UNKNOWN;
        if (str.equals(regionCodeForCountryCode)) {
            if (numberType == PhoneNumberType.FIXED_LINE || numberType == PhoneNumberType.MOBILE || numberType == PhoneNumberType.FIXED_LINE_OR_MOBILE) {
                z2 = true;
            }
            if (regionCodeForCountryCode.equals("CO") && numberType == PhoneNumberType.FIXED_LINE) {
                format = formatNationalNumberWithCarrierCode(clearExtension, COLOMBIA_MOBILE_TO_FIXED_LINE_PREFIX);
            } else if (regionCodeForCountryCode.equals("BR") && z2) {
                format = clearExtension.hasPreferredDomesticCarrierCode() ? formatNationalNumberWithPreferredCarrierCode(clearExtension, "") : "";
            } else if (z3 && regionCodeForCountryCode.equals("HU")) {
                String valueOf = String.valueOf(String.valueOf(getNddPrefixForRegion(regionCodeForCountryCode, true)));
                String valueOf2 = String.valueOf(String.valueOf(format(clearExtension, PhoneNumberFormat.NATIONAL)));
                StringBuilder sb = new StringBuilder(valueOf.length() + 1 + valueOf2.length());
                sb.append(valueOf);
                sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                sb.append(valueOf2);
                format = sb.toString();
            } else if (countryCode == 1) {
                format = (!canBeInternationallyDialled(clearExtension) || isShorterThanPossibleNormalNumber(getMetadataForRegion(str), getNationalSignificantNumber(clearExtension))) ? format(clearExtension, PhoneNumberFormat.NATIONAL) : format(clearExtension, PhoneNumberFormat.INTERNATIONAL);
            } else {
                format = ((regionCodeForCountryCode.equals(REGION_CODE_FOR_NON_GEO_ENTITY) || ((regionCodeForCountryCode.equals("MX") || regionCodeForCountryCode.equals("CL")) && z2)) && canBeInternationallyDialled(clearExtension)) ? format(clearExtension, PhoneNumberFormat.INTERNATIONAL) : format(clearExtension, PhoneNumberFormat.NATIONAL);
            }
            str2 = format;
        } else if (z3 && canBeInternationallyDialled(clearExtension)) {
            return format(clearExtension, z ? PhoneNumberFormat.INTERNATIONAL : PhoneNumberFormat.E164);
        }
        if (!z) {
            str2 = normalizeDiallableCharsOnly(str2);
        }
        return str2;
    }

    public String formatOutOfCountryCallingNumber(PhoneNumber phoneNumber, String str) {
        if (!isValidRegionCode(str)) {
            // Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(String.valueOf(str));
            StringBuilder sb = new StringBuilder(valueOf.length() + 79);
            sb.append("Trying to format number from invalid region ");
            sb.append(valueOf);
            sb.append(". International formatting applied.");
            logger2.log(level, sb.toString());
            return format(phoneNumber, PhoneNumberFormat.INTERNATIONAL);
        }
        int countryCode = phoneNumber.getCountryCode();
        String nationalSignificantNumber = getNationalSignificantNumber(phoneNumber);
        if (!hasValidCountryCallingCode(countryCode)) {
            return nationalSignificantNumber;
        }
        if (countryCode == 1) {
            if (isNANPACountry(str)) {
                String valueOf2 = String.valueOf(String.valueOf(format(phoneNumber, PhoneNumberFormat.NATIONAL)));
                StringBuilder sb2 = new StringBuilder(valueOf2.length() + 12);
                sb2.append(countryCode);
                sb2.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                sb2.append(valueOf2);
                return sb2.toString();
            }
        } else if (countryCode == getCountryCodeForValidRegion(str)) {
            return format(phoneNumber, PhoneNumberFormat.NATIONAL);
        }
        PhoneMetadata metadataForRegion = getMetadataForRegion(str);
        String internationalPrefix = metadataForRegion.getInternationalPrefix();
        String str2 = "";
        if (!UNIQUE_INTERNATIONAL_PREFIX.matcher(internationalPrefix).matches()) {
            internationalPrefix = metadataForRegion.hasPreferredInternationalPrefix() ? metadataForRegion.getPreferredInternationalPrefix() : str2;
        }
        PhoneMetadata metadataForRegionOrCallingCode = getMetadataForRegionOrCallingCode(countryCode, getRegionCodeForCountryCode(countryCode));
        StringBuilder sb3 = new StringBuilder(formatNsn(nationalSignificantNumber, metadataForRegionOrCallingCode, PhoneNumberFormat.INTERNATIONAL));
        maybeAppendFormattedExtension(phoneNumber, metadataForRegionOrCallingCode, PhoneNumberFormat.INTERNATIONAL, sb3);
        if (internationalPrefix.length() > 0) {
            sb3.insert(0, MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).insert(0, countryCode).insert(0, MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).insert(0, internationalPrefix);
        } else {
            prefixNumberWithCountryCallingCode(countryCode, PhoneNumberFormat.INTERNATIONAL, sb3);
        }
        return sb3.toString();
    }

    public String formatInOriginalFormat(PhoneNumber phoneNumber, String str) {
        String str2;
        if (phoneNumber.hasRawInput() && (hasUnexpectedItalianLeadingZero(phoneNumber) || !hasFormattingPatternForNumber(phoneNumber))) {
            return phoneNumber.getRawInput();
        }
        if (!phoneNumber.hasCountryCodeSource()) {
            return format(phoneNumber, PhoneNumberFormat.NATIONAL);
        }
        switch (phoneNumber.getCountryCodeSource()) {
            case FROM_NUMBER_WITH_PLUS_SIGN:
                str2 = format(phoneNumber, PhoneNumberFormat.INTERNATIONAL);
                break;
            case FROM_NUMBER_WITH_IDD:
                str2 = formatOutOfCountryCallingNumber(phoneNumber, str);
                break;
            case FROM_NUMBER_WITHOUT_PLUS_SIGN:
                str2 = format(phoneNumber, PhoneNumberFormat.INTERNATIONAL).substring(1);
                break;
            default:
                String regionCodeForCountryCode = getRegionCodeForCountryCode(phoneNumber.getCountryCode());
                String nddPrefixForRegion = getNddPrefixForRegion(regionCodeForCountryCode, true);
                String format = format(phoneNumber, PhoneNumberFormat.NATIONAL);
                if (!(nddPrefixForRegion == null || nddPrefixForRegion.length() == 0 || rawInputContainsNationalPrefix(phoneNumber.getRawInput(), nddPrefixForRegion, regionCodeForCountryCode))) {
                    PhoneMetadata metadataForRegion = getMetadataForRegion(regionCodeForCountryCode);
                    NumberFormat chooseFormattingPatternForNumber = chooseFormattingPatternForNumber(metadataForRegion.numberFormats(), getNationalSignificantNumber(phoneNumber));
                    if (chooseFormattingPatternForNumber != null) {
                        String nationalPrefixFormattingRule = chooseFormattingPatternForNumber.getNationalPrefixFormattingRule();
                        int indexOf = nationalPrefixFormattingRule.indexOf("$1");
                        if (indexOf > 0 && normalizeDigitsOnly(nationalPrefixFormattingRule.substring(0, indexOf)).length() != 0) {
                            NumberFormat numberFormat = new NumberFormat();
                            numberFormat.mergeFrom(chooseFormattingPatternForNumber);
                            numberFormat.clearNationalPrefixFormattingRule();
                            ArrayList arrayList = new ArrayList(1);
                            arrayList.add(numberFormat);
                            str2 = formatByPattern(phoneNumber, PhoneNumberFormat.NATIONAL, arrayList);
                            break;
                        }
                    }
                }
                str2 = format;
                break;
        }
        String rawInput = phoneNumber.getRawInput();
        if (str2 == null || rawInput.length() <= 0 || normalizeDiallableCharsOnly(str2).equals(normalizeDiallableCharsOnly(rawInput))) {
            rawInput = str2;
        }
        return rawInput;
    }

    private boolean rawInputContainsNationalPrefix(String str, String str2, String str3) {
        String normalizeDigitsOnly = normalizeDigitsOnly(str);
        if (!normalizeDigitsOnly.startsWith(str2)) {
            return false;
        }
        try {
            return isValidNumber(parse(normalizeDigitsOnly.substring(str2.length()), str3));
        } catch (NumberParseException unused) {
            return false;
        }
    }

    private boolean hasUnexpectedItalianLeadingZero(PhoneNumber phoneNumber) {
        return phoneNumber.isItalianLeadingZero() && !isLeadingZeroPossible(phoneNumber.getCountryCode());
    }

    private boolean hasFormattingPatternForNumber(PhoneNumber phoneNumber) {
        int countryCode = phoneNumber.getCountryCode();
        PhoneMetadata metadataForRegionOrCallingCode = getMetadataForRegionOrCallingCode(countryCode, getRegionCodeForCountryCode(countryCode));
        boolean z = false;
        if (metadataForRegionOrCallingCode == null) {
            return false;
        }
        if (chooseFormattingPatternForNumber(metadataForRegionOrCallingCode.numberFormats(), getNationalSignificantNumber(phoneNumber)) != null) {
            z = true;
        }
        return z;
    }

    public String formatOutOfCountryKeepingAlphaChars(PhoneNumber phoneNumber, String str) {
        String rawInput = phoneNumber.getRawInput();
        if (rawInput.length() == 0) {
            return formatOutOfCountryCallingNumber(phoneNumber, str);
        }
        int countryCode = phoneNumber.getCountryCode();
        if (!hasValidCountryCallingCode(countryCode)) {
            return rawInput;
        }
        String normalizeHelper = normalizeHelper(rawInput, ALL_PLUS_NUMBER_GROUPING_SYMBOLS, true);
        String nationalSignificantNumber = getNationalSignificantNumber(phoneNumber);
        if (nationalSignificantNumber.length() > 3) {
            int indexOf = normalizeHelper.indexOf(nationalSignificantNumber.substring(0, 3));
            if (indexOf != -1) {
                normalizeHelper = normalizeHelper.substring(indexOf);
            }
        }
        PhoneMetadata metadataForRegion = getMetadataForRegion(str);
        if (countryCode == 1) {
            if (isNANPACountry(str)) {
                String valueOf = String.valueOf(String.valueOf(normalizeHelper));
                StringBuilder sb = new StringBuilder(valueOf.length() + 12);
                sb.append(countryCode);
                sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                sb.append(valueOf);
                return sb.toString();
            }
        } else if (metadataForRegion != null && countryCode == getCountryCodeForValidRegion(str)) {
            NumberFormat chooseFormattingPatternForNumber = chooseFormattingPatternForNumber(metadataForRegion.numberFormats(), nationalSignificantNumber);
            if (chooseFormattingPatternForNumber == null) {
                return normalizeHelper;
            }
            NumberFormat numberFormat = new NumberFormat();
            numberFormat.mergeFrom(chooseFormattingPatternForNumber);
            numberFormat.setPattern("(\\d+)(.*)");
            numberFormat.setFormat("$1$2");
            return formatNsnUsingPattern(normalizeHelper, numberFormat, PhoneNumberFormat.NATIONAL);
        }
        String str2 = "";
        if (metadataForRegion != null) {
            str2 = metadataForRegion.getInternationalPrefix();
            if (!UNIQUE_INTERNATIONAL_PREFIX.matcher(str2).matches()) {
                str2 = metadataForRegion.getPreferredInternationalPrefix();
            }
        }
        StringBuilder sb2 = new StringBuilder(normalizeHelper);
        maybeAppendFormattedExtension(phoneNumber, getMetadataForRegionOrCallingCode(countryCode, getRegionCodeForCountryCode(countryCode)), PhoneNumberFormat.INTERNATIONAL, sb2);
        if (str2.length() > 0) {
            sb2.insert(0, MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).insert(0, countryCode).insert(0, MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).insert(0, str2);
        } else {
            // Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf2 = String.valueOf(String.valueOf(str));
            StringBuilder sb3 = new StringBuilder(valueOf2.length() + 79);
            sb3.append("Trying to format number from invalid region ");
            sb3.append(valueOf2);
            sb3.append(". International formatting applied.");
            logger2.log(level, sb3.toString());
            prefixNumberWithCountryCallingCode(countryCode, PhoneNumberFormat.INTERNATIONAL, sb2);
        }
        return sb2.toString();
    }

    public String getNationalSignificantNumber(PhoneNumber phoneNumber) {
        StringBuilder sb = new StringBuilder();
        if (phoneNumber.isItalianLeadingZero()) {
            char[] cArr = new char[phoneNumber.getNumberOfLeadingZeros()];
            Arrays.fill(cArr, '0');
            sb.append(new String(cArr));
        }
        sb.append(phoneNumber.getNationalNumber());
        return sb.toString();
    }

    private void prefixNumberWithCountryCallingCode(int i, PhoneNumberFormat phoneNumberFormat, StringBuilder sb) {
        switch (phoneNumberFormat) {
            case E164:
                sb.insert(0, i).insert(0, PLUS_SIGN);
                return;
            case INTERNATIONAL:
                sb.insert(0, MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).insert(0, i).insert(0, PLUS_SIGN);
                return;
            case RFC3966:
                sb.insert(0, "-").insert(0, i).insert(0, PLUS_SIGN).insert(0, RFC3966_PREFIX);
                return;
            default:
                return;
        }
    }

    private String formatNsn(String str, PhoneMetadata phoneMetadata, PhoneNumberFormat phoneNumberFormat) {
        return formatNsn(str, phoneMetadata, phoneNumberFormat, null);
    }

    private String formatNsn(String str, PhoneMetadata phoneMetadata, PhoneNumberFormat phoneNumberFormat, String str2) {
        NumberFormat chooseFormattingPatternForNumber = chooseFormattingPatternForNumber((phoneMetadata.intlNumberFormats().size() == 0 || phoneNumberFormat == PhoneNumberFormat.NATIONAL) ? phoneMetadata.numberFormats() : phoneMetadata.intlNumberFormats(), str);
        return chooseFormattingPatternForNumber == null ? str : formatNsnUsingPattern(str, chooseFormattingPatternForNumber, phoneNumberFormat, str2);
    }

    /* access modifiers changed from: 0000 */
    public NumberFormat chooseFormattingPatternForNumber(List<NumberFormat> list, String str) {
        for (NumberFormat numberFormat : list) {
            int leadingDigitsPatternSize = numberFormat.leadingDigitsPatternSize();
            if ((leadingDigitsPatternSize == 0 || this.regexCache.getPatternForRegex(numberFormat.getLeadingDigitsPattern(leadingDigitsPatternSize - 1)).matcher(str).lookingAt()) && this.regexCache.getPatternForRegex(numberFormat.getPattern()).matcher(str).matches()) {
                return numberFormat;
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public String formatNsnUsingPattern(String str, NumberFormat numberFormat, PhoneNumberFormat phoneNumberFormat) {
        return formatNsnUsingPattern(str, numberFormat, phoneNumberFormat, null);
    }

    private String formatNsnUsingPattern(String str, NumberFormat numberFormat, PhoneNumberFormat phoneNumberFormat, String str2) {
        String str3;
        String format = numberFormat.getFormat();
        Matcher matcher = this.regexCache.getPatternForRegex(numberFormat.getPattern()).matcher(str);
        if (phoneNumberFormat != PhoneNumberFormat.NATIONAL || str2 == null || str2.length() <= 0 || numberFormat.getDomesticCarrierCodeFormattingRule().length() <= 0) {
            String nationalPrefixFormattingRule = numberFormat.getNationalPrefixFormattingRule();
            if (phoneNumberFormat != PhoneNumberFormat.NATIONAL || nationalPrefixFormattingRule == null || nationalPrefixFormattingRule.length() <= 0) {
                str3 = matcher.replaceAll(format);
            } else {
                str3 = matcher.replaceAll(FIRST_GROUP_PATTERN.matcher(format).replaceFirst(nationalPrefixFormattingRule));
            }
        } else {
            str3 = matcher.replaceAll(FIRST_GROUP_PATTERN.matcher(format).replaceFirst(CC_PATTERN.matcher(numberFormat.getDomesticCarrierCodeFormattingRule()).replaceFirst(str2)));
        }
        if (phoneNumberFormat != PhoneNumberFormat.RFC3966) {
            return str3;
        }
        Matcher matcher2 = SEPARATOR_PATTERN.matcher(str3);
        if (matcher2.lookingAt()) {
            str3 = matcher2.replaceFirst("");
        }
        return matcher2.reset(str3).replaceAll("-");
    }

    public PhoneNumber getExampleNumber(String str) {
        return getExampleNumberForType(str, PhoneNumberType.FIXED_LINE);
    }

    public PhoneNumber getExampleNumberForType(String str, PhoneNumberType phoneNumberType) {
        if (!isValidRegionCode(str)) {
            // Logger logger2 = logger;
            Level level = Level.WARNING;
            String str2 = "Invalid or unknown region code provided: ";
            String valueOf = String.valueOf(str);
            logger2.log(level, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            return null;
        }
        PhoneNumberDesc numberDescByType = getNumberDescByType(getMetadataForRegion(str), phoneNumberType);
        try {
            if (numberDescByType.hasExampleNumber()) {
                return parse(numberDescByType.getExampleNumber(), str);
            }
        } catch (NumberParseException e) {
            logger.log(Level.SEVERE, e.toString());
        }
        return null;
    }

    public PhoneNumber getExampleNumberForNonGeoEntity(int i) {
        PhoneMetadata metadataForNonGeographicalRegion = getMetadataForNonGeographicalRegion(i);
        if (metadataForNonGeographicalRegion != null) {
            PhoneNumberDesc generalDesc = metadataForNonGeographicalRegion.getGeneralDesc();
            try {
                if (generalDesc.hasExampleNumber()) {
                    String valueOf = String.valueOf(String.valueOf(generalDesc.getExampleNumber()));
                    StringBuilder sb = new StringBuilder(valueOf.length() + 12);
                    sb.append("+");
                    sb.append(i);
                    sb.append(valueOf);
                    return parse(sb.toString(), UNKNOWN_REGION);
                }
            } catch (NumberParseException e) {
                logger.log(Level.SEVERE, e.toString());
            }
        } else {
            // Logger logger2 = logger;
            Level level = Level.WARNING;
            StringBuilder sb2 = new StringBuilder(61);
            sb2.append("Invalid or unknown country calling code provided: ");
            sb2.append(i);
            logger2.log(level, sb2.toString());
        }
        return null;
    }

    private void maybeAppendFormattedExtension(PhoneNumber phoneNumber, PhoneMetadata phoneMetadata, PhoneNumberFormat phoneNumberFormat, StringBuilder sb) {
        if (phoneNumber.hasExtension() && phoneNumber.getExtension().length() > 0) {
            if (phoneNumberFormat == PhoneNumberFormat.RFC3966) {
                sb.append(RFC3966_EXTN_PREFIX);
                sb.append(phoneNumber.getExtension());
            } else if (phoneMetadata.hasPreferredExtnPrefix()) {
                sb.append(phoneMetadata.getPreferredExtnPrefix());
                sb.append(phoneNumber.getExtension());
            } else {
                sb.append(DEFAULT_EXTN_PREFIX);
                sb.append(phoneNumber.getExtension());
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public PhoneNumberDesc getNumberDescByType(PhoneMetadata phoneMetadata, PhoneNumberType phoneNumberType) {
        switch (phoneNumberType) {
            case PREMIUM_RATE:
                return phoneMetadata.getPremiumRate();
            case TOLL_FREE:
                return phoneMetadata.getTollFree();
            case MOBILE:
                return phoneMetadata.getMobile();
            case FIXED_LINE:
            case FIXED_LINE_OR_MOBILE:
                return phoneMetadata.getFixedLine();
            case SHARED_COST:
                return phoneMetadata.getSharedCost();
            case VOIP:
                return phoneMetadata.getVoip();
            case PERSONAL_NUMBER:
                return phoneMetadata.getPersonalNumber();
            case PAGER:
                return phoneMetadata.getPager();
            case UAN:
                return phoneMetadata.getUan();
            case VOICEMAIL:
                return phoneMetadata.getVoicemail();
            default:
                return phoneMetadata.getGeneralDesc();
        }
    }

    public PhoneNumberType getNumberType(PhoneNumber phoneNumber) {
        PhoneMetadata metadataForRegionOrCallingCode = getMetadataForRegionOrCallingCode(phoneNumber.getCountryCode(), getRegionCodeForNumber(phoneNumber));
        if (metadataForRegionOrCallingCode == null) {
            return PhoneNumberType.UNKNOWN;
        }
        return getNumberTypeHelper(getNationalSignificantNumber(phoneNumber), metadataForRegionOrCallingCode);
    }

    private PhoneNumberType getNumberTypeHelper(String str, PhoneMetadata phoneMetadata) {
        if (!isNumberMatchingDesc(str, phoneMetadata.getGeneralDesc())) {
            return PhoneNumberType.UNKNOWN;
        }
        if (isNumberMatchingDesc(str, phoneMetadata.getPremiumRate())) {
            return PhoneNumberType.PREMIUM_RATE;
        }
        if (isNumberMatchingDesc(str, phoneMetadata.getTollFree())) {
            return PhoneNumberType.TOLL_FREE;
        }
        if (isNumberMatchingDesc(str, phoneMetadata.getSharedCost())) {
            return PhoneNumberType.SHARED_COST;
        }
        if (isNumberMatchingDesc(str, phoneMetadata.getVoip())) {
            return PhoneNumberType.VOIP;
        }
        if (isNumberMatchingDesc(str, phoneMetadata.getPersonalNumber())) {
            return PhoneNumberType.PERSONAL_NUMBER;
        }
        if (isNumberMatchingDesc(str, phoneMetadata.getPager())) {
            return PhoneNumberType.PAGER;
        }
        if (isNumberMatchingDesc(str, phoneMetadata.getUan())) {
            return PhoneNumberType.UAN;
        }
        if (isNumberMatchingDesc(str, phoneMetadata.getVoicemail())) {
            return PhoneNumberType.VOICEMAIL;
        }
        if (isNumberMatchingDesc(str, phoneMetadata.getFixedLine())) {
            if (phoneMetadata.isSameMobileAndFixedLinePattern()) {
                return PhoneNumberType.FIXED_LINE_OR_MOBILE;
            }
            if (isNumberMatchingDesc(str, phoneMetadata.getMobile())) {
                return PhoneNumberType.FIXED_LINE_OR_MOBILE;
            }
            return PhoneNumberType.FIXED_LINE;
        } else if (phoneMetadata.isSameMobileAndFixedLinePattern() || !isNumberMatchingDesc(str, phoneMetadata.getMobile())) {
            return PhoneNumberType.UNKNOWN;
        } else {
            return PhoneNumberType.MOBILE;
        }
    }

    /* access modifiers changed from: 0000 */
    public PhoneMetadata getMetadataForRegion(String str) {
        if (!isValidRegionCode(str)) {
            return null;
        }
        synchronized (this.regionToMetadataMap) {
            if (!this.regionToMetadataMap.containsKey(str)) {
                loadMetadataFromFile(this.currentFilePrefix, str, 0, this.metadataLoader);
            }
        }
        return (PhoneMetadata) this.regionToMetadataMap.get(str);
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0034, code lost:
        return (com.google.i18n.phonenumbers.Phonemetadata.PhoneMetadata) r4.countryCodeToNonGeographicalMetadataMap.get(java.lang.Integer.valueOf(r5));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.i18n.phonenumbers.Phonemetadata.PhoneMetadata getMetadataForNonGeographicalRegion(int r5) {
        /*
            r4 = this;
            java.util.Map<java.lang.Integer, com.google.i18n.phonenumbers.Phonemetadata$PhoneMetadata> r0 = r4.countryCodeToNonGeographicalMetadataMap
            monitor-enter(r0)
            java.util.Map<java.lang.Integer, java.util.List<java.lang.String>> r1 = r4.countryCallingCodeToRegionCodeMap     // Catch:{ all -> 0x0035 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0035 }
            boolean r1 = r1.containsKey(r2)     // Catch:{ all -> 0x0035 }
            if (r1 != 0) goto L_0x0012
            r5 = 0
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            return r5
        L_0x0012:
            java.util.Map<java.lang.Integer, com.google.i18n.phonenumbers.Phonemetadata$PhoneMetadata> r1 = r4.countryCodeToNonGeographicalMetadataMap     // Catch:{ all -> 0x0035 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0035 }
            boolean r1 = r1.containsKey(r2)     // Catch:{ all -> 0x0035 }
            if (r1 != 0) goto L_0x0027
            java.lang.String r1 = r4.currentFilePrefix     // Catch:{ all -> 0x0035 }
            java.lang.String r2 = "001"
            com.google.i18n.phonenumbers.MetadataLoader r3 = r4.metadataLoader     // Catch:{ all -> 0x0035 }
            r4.loadMetadataFromFile(r1, r2, r5, r3)     // Catch:{ all -> 0x0035 }
        L_0x0027:
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            java.util.Map<java.lang.Integer, com.google.i18n.phonenumbers.Phonemetadata$PhoneMetadata> r0 = r4.countryCodeToNonGeographicalMetadataMap
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.Object r5 = r0.get(r5)
            com.google.i18n.phonenumbers.Phonemetadata$PhoneMetadata r5 = (com.google.i18n.phonenumbers.Phonemetadata.PhoneMetadata) r5
            return r5
        L_0x0035:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.i18n.phonenumbers.PhoneNumberUtil.getMetadataForNonGeographicalRegion(int):com.google.i18n.phonenumbers.Phonemetadata$PhoneMetadata");
    }

    /* access modifiers changed from: 0000 */
    public boolean isNumberPossibleForDesc(String str, PhoneNumberDesc phoneNumberDesc) {
        return this.regexCache.getPatternForRegex(phoneNumberDesc.getPossibleNumberPattern()).matcher(str).matches();
    }

    /* access modifiers changed from: 0000 */
    public boolean isNumberMatchingDesc(String str, PhoneNumberDesc phoneNumberDesc) {
        return isNumberPossibleForDesc(str, phoneNumberDesc) && this.regexCache.getPatternForRegex(phoneNumberDesc.getNationalNumberPattern()).matcher(str).matches();
    }

    public boolean isValidNumber(PhoneNumber phoneNumber) {
        return isValidNumberForRegion(phoneNumber, getRegionCodeForNumber(phoneNumber));
    }

    public boolean isValidNumberForRegion(PhoneNumber phoneNumber, String str) {
        int countryCode = phoneNumber.getCountryCode();
        PhoneMetadata metadataForRegionOrCallingCode = getMetadataForRegionOrCallingCode(countryCode, str);
        boolean z = false;
        if (metadataForRegionOrCallingCode == null || (!REGION_CODE_FOR_NON_GEO_ENTITY.equals(str) && countryCode != getCountryCodeForValidRegion(str))) {
            return false;
        }
        if (getNumberTypeHelper(getNationalSignificantNumber(phoneNumber), metadataForRegionOrCallingCode) != PhoneNumberType.UNKNOWN) {
            z = true;
        }
        return z;
    }

    public String getRegionCodeForNumber(PhoneNumber phoneNumber) {
        int countryCode = phoneNumber.getCountryCode();
        List list = (List) this.countryCallingCodeToRegionCodeMap.get(Integer.valueOf(countryCode));
        if (list == null) {
            String nationalSignificantNumber = getNationalSignificantNumber(phoneNumber);
            // Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(String.valueOf(nationalSignificantNumber));
            StringBuilder sb = new StringBuilder(valueOf.length() + 54);
            sb.append("Missing/invalid country_code (");
            sb.append(countryCode);
            sb.append(") for number ");
            sb.append(valueOf);
            logger2.log(level, sb.toString());
            return null;
        } else if (list.size() == 1) {
            return (String) list.get(0);
        } else {
            return getRegionCodeForNumberFromRegionList(phoneNumber, list);
        }
    }

    private String getRegionCodeForNumberFromRegionList(PhoneNumber phoneNumber, List<String> list) {
        String nationalSignificantNumber = getNationalSignificantNumber(phoneNumber);
        for (String str : list) {
            PhoneMetadata metadataForRegion = getMetadataForRegion(str);
            if (metadataForRegion.hasLeadingDigits()) {
                if (this.regexCache.getPatternForRegex(metadataForRegion.getLeadingDigits()).matcher(nationalSignificantNumber).lookingAt()) {
                    return str;
                }
            } else if (getNumberTypeHelper(nationalSignificantNumber, metadataForRegion) != PhoneNumberType.UNKNOWN) {
                return str;
            }
        }
        return null;
    }

    public String getRegionCodeForCountryCode(int i) {
        List list = (List) this.countryCallingCodeToRegionCodeMap.get(Integer.valueOf(i));
        if (list == null) {
            return UNKNOWN_REGION;
        }
        return (String) list.get(0);
    }

    public List<String> getRegionCodesForCountryCode(int i) {
        List list = (List) this.countryCallingCodeToRegionCodeMap.get(Integer.valueOf(i));
        if (list == null) {
            list = new ArrayList(0);
        }
        return Collections.unmodifiableList(list);
    }

    public int getCountryCodeForRegion(String str) {
        if (isValidRegionCode(str)) {
            return getCountryCodeForValidRegion(str);
        }
        // Logger logger2 = logger;
        Level level = Level.WARNING;
        if (str == null) {
            str = "null";
        }
        String valueOf = String.valueOf(String.valueOf(str));
        StringBuilder sb = new StringBuilder(valueOf.length() + 43);
        sb.append("Invalid or missing region code (");
        sb.append(valueOf);
        sb.append(") provided.");
        logger2.log(level, sb.toString());
        return 0;
    }

    private int getCountryCodeForValidRegion(String str) {
        PhoneMetadata metadataForRegion = getMetadataForRegion(str);
        if (metadataForRegion != null) {
            return metadataForRegion.getCountryCode();
        }
        String str2 = "Invalid region code: ";
        String valueOf = String.valueOf(str);
        throw new IllegalArgumentException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
    }

    public String getNddPrefixForRegion(String str, boolean z) {
        PhoneMetadata metadataForRegion = getMetadataForRegion(str);
        if (metadataForRegion == null) {
            // Logger logger2 = logger;
            Level level = Level.WARNING;
            if (str == null) {
                str = "null";
            }
            String valueOf = String.valueOf(String.valueOf(str));
            StringBuilder sb = new StringBuilder(valueOf.length() + 43);
            sb.append("Invalid or missing region code (");
            sb.append(valueOf);
            sb.append(") provided.");
            logger2.log(level, sb.toString());
            return null;
        }
        String nationalPrefix = metadataForRegion.getNationalPrefix();
        if (nationalPrefix.length() == 0) {
            return null;
        }
        if (z) {
            nationalPrefix = nationalPrefix.replace("~", "");
        }
        return nationalPrefix;
    }

    public boolean isNANPACountry(String str) {
        return this.nanpaRegions.contains(str);
    }

    /* access modifiers changed from: 0000 */
    public boolean isLeadingZeroPossible(int i) {
        PhoneMetadata metadataForRegionOrCallingCode = getMetadataForRegionOrCallingCode(i, getRegionCodeForCountryCode(i));
        if (metadataForRegionOrCallingCode == null) {
            return false;
        }
        return metadataForRegionOrCallingCode.isLeadingZeroPossible();
    }

    public boolean isAlphaNumber(String str) {
        if (!isViablePhoneNumber(str)) {
            return false;
        }
        StringBuilder sb = new StringBuilder(str);
        maybeStripExtension(sb);
        return VALID_ALPHA_PHONE_PATTERN.matcher(sb).matches();
    }

    public boolean isPossibleNumber(PhoneNumber phoneNumber) {
        return isPossibleNumberWithReason(phoneNumber) == ValidationResult.IS_POSSIBLE;
    }

    private ValidationResult testNumberLengthAgainstPattern(Pattern pattern, String str) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches()) {
            return ValidationResult.IS_POSSIBLE;
        }
        if (matcher.lookingAt()) {
            return ValidationResult.TOO_LONG;
        }
        return ValidationResult.TOO_SHORT;
    }

    private boolean isShorterThanPossibleNormalNumber(PhoneMetadata phoneMetadata, String str) {
        return testNumberLengthAgainstPattern(this.regexCache.getPatternForRegex(phoneMetadata.getGeneralDesc().getPossibleNumberPattern()), str) == ValidationResult.TOO_SHORT;
    }

    public ValidationResult isPossibleNumberWithReason(PhoneNumber phoneNumber) {
        String nationalSignificantNumber = getNationalSignificantNumber(phoneNumber);
        int countryCode = phoneNumber.getCountryCode();
        if (!hasValidCountryCallingCode(countryCode)) {
            return ValidationResult.INVALID_COUNTRY_CODE;
        }
        return testNumberLengthAgainstPattern(this.regexCache.getPatternForRegex(getMetadataForRegionOrCallingCode(countryCode, getRegionCodeForCountryCode(countryCode)).getGeneralDesc().getPossibleNumberPattern()), nationalSignificantNumber);
    }

    public boolean isPossibleNumber(String str, String str2) {
        try {
            return isPossibleNumber(parse(str, str2));
        } catch (NumberParseException unused) {
            return false;
        }
    }

    public boolean truncateTooLongNumber(PhoneNumber phoneNumber) {
        if (isValidNumber(phoneNumber)) {
            return true;
        }
        PhoneNumber phoneNumber2 = new PhoneNumber();
        phoneNumber2.mergeFrom(phoneNumber);
        long nationalNumber = phoneNumber.getNationalNumber();
        do {
            nationalNumber /= 10;
            phoneNumber2.setNationalNumber(nationalNumber);
            if (isPossibleNumberWithReason(phoneNumber2) == ValidationResult.TOO_SHORT || nationalNumber == 0) {
                return false;
            }
        } while (!isValidNumber(phoneNumber2));
        phoneNumber.setNationalNumber(nationalNumber);
        return true;
    }

    public AsYouTypeFormatter getAsYouTypeFormatter(String str) {
        return new AsYouTypeFormatter(str);
    }

    /* access modifiers changed from: 0000 */
    public int extractCountryCode(StringBuilder sb, StringBuilder sb2) {
        if (sb.length() == 0 || sb.charAt(0) == '0') {
            return 0;
        }
        int length = sb.length();
        int i = 1;
        while (i <= 3 && i <= length) {
            int parseInt = Integer.parseInt(sb.substring(0, i));
            if (this.countryCallingCodeToRegionCodeMap.containsKey(Integer.valueOf(parseInt))) {
                sb2.append(sb.substring(i));
                return parseInt;
            }
            i++;
        }
        return 0;
    }

    /* access modifiers changed from: 0000 */
    public int maybeExtractCountryCode(String str, PhoneMetadata phoneMetadata, StringBuilder sb, boolean z, PhoneNumber phoneNumber) throws NumberParseException {
        if (str.length() == 0) {
            return 0;
        }
        StringBuilder sb2 = new StringBuilder(str);
        String str2 = "NonMatch";
        if (phoneMetadata != null) {
            str2 = phoneMetadata.getInternationalPrefix();
        }
        CountryCodeSource maybeStripInternationalPrefixAndNormalize = maybeStripInternationalPrefixAndNormalize(sb2, str2);
        if (z) {
            phoneNumber.setCountryCodeSource(maybeStripInternationalPrefixAndNormalize);
        }
        if (maybeStripInternationalPrefixAndNormalize == CountryCodeSource.FROM_DEFAULT_COUNTRY) {
            if (phoneMetadata != null) {
                int countryCode = phoneMetadata.getCountryCode();
                String valueOf = String.valueOf(countryCode);
                String sb3 = sb2.toString();
                if (sb3.startsWith(valueOf)) {
                    StringBuilder sb4 = new StringBuilder(sb3.substring(valueOf.length()));
                    PhoneNumberDesc generalDesc = phoneMetadata.getGeneralDesc();
                    Pattern patternForRegex = this.regexCache.getPatternForRegex(generalDesc.getNationalNumberPattern());
                    maybeStripNationalPrefixAndCarrierCode(sb4, phoneMetadata, null);
                    Pattern patternForRegex2 = this.regexCache.getPatternForRegex(generalDesc.getPossibleNumberPattern());
                    if ((!patternForRegex.matcher(sb2).matches() && patternForRegex.matcher(sb4).matches()) || testNumberLengthAgainstPattern(patternForRegex2, sb2.toString()) == ValidationResult.TOO_LONG) {
                        sb.append(sb4);
                        if (z) {
                            phoneNumber.setCountryCodeSource(CountryCodeSource.FROM_NUMBER_WITHOUT_PLUS_SIGN);
                        }
                        phoneNumber.setCountryCode(countryCode);
                        return countryCode;
                    }
                }
            }
            phoneNumber.setCountryCode(0);
            return 0;
        } else if (sb2.length() > 2) {
            int extractCountryCode = extractCountryCode(sb2, sb);
            if (extractCountryCode != 0) {
                phoneNumber.setCountryCode(extractCountryCode);
                return extractCountryCode;
            }
            throw new NumberParseException(ErrorType.INVALID_COUNTRY_CODE, "Country calling code supplied was not recognised.");
        } else {
            throw new NumberParseException(ErrorType.TOO_SHORT_AFTER_IDD, "Phone number had an IDD, but after this was not long enough to be a viable phone number.");
        }
    }

    private boolean parsePrefixAsIdd(Pattern pattern, StringBuilder sb) {
        Matcher matcher = pattern.matcher(sb);
        if (!matcher.lookingAt()) {
            return false;
        }
        int end = matcher.end();
        Matcher matcher2 = CAPTURING_DIGIT_PATTERN.matcher(sb.substring(end));
        if (matcher2.find() && normalizeDigitsOnly(matcher2.group(1)).equals("0")) {
            return false;
        }
        sb.delete(0, end);
        return true;
    }

    /* access modifiers changed from: 0000 */
    public CountryCodeSource maybeStripInternationalPrefixAndNormalize(StringBuilder sb, String str) {
        if (sb.length() == 0) {
            return CountryCodeSource.FROM_DEFAULT_COUNTRY;
        }
        Matcher matcher = PLUS_CHARS_PATTERN.matcher(sb);
        if (matcher.lookingAt()) {
            sb.delete(0, matcher.end());
            normalize(sb);
            return CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN;
        }
        Pattern patternForRegex = this.regexCache.getPatternForRegex(str);
        normalize(sb);
        return parsePrefixAsIdd(patternForRegex, sb) ? CountryCodeSource.FROM_NUMBER_WITH_IDD : CountryCodeSource.FROM_DEFAULT_COUNTRY;
    }

    /* access modifiers changed from: 0000 */
    public boolean maybeStripNationalPrefixAndCarrierCode(StringBuilder sb, PhoneMetadata phoneMetadata, StringBuilder sb2) {
        int length = sb.length();
        String nationalPrefixForParsing = phoneMetadata.getNationalPrefixForParsing();
        if (length == 0 || nationalPrefixForParsing.length() == 0) {
            return false;
        }
        Matcher matcher = this.regexCache.getPatternForRegex(nationalPrefixForParsing).matcher(sb);
        if (!matcher.lookingAt()) {
            return false;
        }
        Pattern patternForRegex = this.regexCache.getPatternForRegex(phoneMetadata.getGeneralDesc().getNationalNumberPattern());
        boolean matches = patternForRegex.matcher(sb).matches();
        int groupCount = matcher.groupCount();
        String nationalPrefixTransformRule = phoneMetadata.getNationalPrefixTransformRule();
        if (nationalPrefixTransformRule != null && nationalPrefixTransformRule.length() != 0 && matcher.group(groupCount) != null) {
            StringBuilder sb3 = new StringBuilder(sb);
            sb3.replace(0, length, matcher.replaceFirst(nationalPrefixTransformRule));
            if (matches && !patternForRegex.matcher(sb3.toString()).matches()) {
                return false;
            }
            if (sb2 != null && groupCount > 1) {
                sb2.append(matcher.group(1));
            }
            sb.replace(0, sb.length(), sb3.toString());
            return true;
        } else if (matches && !patternForRegex.matcher(sb.substring(matcher.end())).matches()) {
            return false;
        } else {
            if (!(sb2 == null || groupCount <= 0 || matcher.group(groupCount) == null)) {
                sb2.append(matcher.group(1));
            }
            sb.delete(0, matcher.end());
            return true;
        }
    }

    /* access modifiers changed from: 0000 */
    public String maybeStripExtension(StringBuilder sb) {
        Matcher matcher = EXTN_PATTERN.matcher(sb);
        if (matcher.find() && isViablePhoneNumber(sb.substring(0, matcher.start()))) {
            int groupCount = matcher.groupCount();
            for (int i = 1; i <= groupCount; i++) {
                if (matcher.group(i) != null) {
                    String group = matcher.group(i);
                    sb.delete(matcher.start(), sb.length());
                    return group;
                }
            }
        }
        return "";
    }

    private boolean checkRegionForParsing(String str, String str2) {
        return isValidRegionCode(str2) || !(str == null || str.length() == 0 || !PLUS_CHARS_PATTERN.matcher(str).lookingAt());
    }

    public PhoneNumber parse(String str, String str2) throws NumberParseException {
        PhoneNumber phoneNumber = new PhoneNumber();
        parse(str, str2, phoneNumber);
        return phoneNumber;
    }

    public void parse(String str, String str2, PhoneNumber phoneNumber) throws NumberParseException {
        parseHelper(str, str2, false, true, phoneNumber);
    }

    public PhoneNumber parseAndKeepRawInput(String str, String str2) throws NumberParseException {
        PhoneNumber phoneNumber = new PhoneNumber();
        parseAndKeepRawInput(str, str2, phoneNumber);
        return phoneNumber;
    }

    public void parseAndKeepRawInput(String str, String str2, PhoneNumber phoneNumber) throws NumberParseException {
        parseHelper(str, str2, true, true, phoneNumber);
    }

    public Iterable<PhoneNumberMatch> findNumbers(CharSequence charSequence, String str) {
        return findNumbers(charSequence, str, Leniency.VALID, Long.MAX_VALUE);
    }

    public Iterable<PhoneNumberMatch> findNumbers(CharSequence charSequence, String str, Leniency leniency, long j) {
        final CharSequence charSequence2 = charSequence;
        final String str2 = str;
        final Leniency leniency2 = leniency;
        final long j2 = j;
        C29252 r0 = new Iterable<PhoneNumberMatch>() {
            public Iterator<PhoneNumberMatch> iterator() {
                PhoneNumberMatcher phoneNumberMatcher = new PhoneNumberMatcher(PhoneNumberUtil.this, charSequence2, str2, leniency2, j2);
                return phoneNumberMatcher;
            }
        };
        return r0;
    }

    static void setItalianLeadingZerosForPhoneNumber(String str, PhoneNumber phoneNumber) {
        if (str.length() > 1 && str.charAt(0) == '0') {
            phoneNumber.setItalianLeadingZero(true);
            int i = 1;
            while (i < str.length() - 1 && str.charAt(i) == '0') {
                i++;
            }
            if (i != 1) {
                phoneNumber.setNumberOfLeadingZeros(i);
            }
        }
    }

    private void parseHelper(String str, String str2, boolean z, boolean z2, PhoneNumber phoneNumber) throws NumberParseException {
        int i;
        if (str == null) {
            throw new NumberParseException(ErrorType.NOT_A_NUMBER, "The phone number supplied was null.");
        } else if (str.length() <= 250) {
            StringBuilder sb = new StringBuilder();
            buildNationalNumberForParsing(str, sb);
            if (!isViablePhoneNumber(sb.toString())) {
                throw new NumberParseException(ErrorType.NOT_A_NUMBER, "The string supplied did not seem to be a phone number.");
            } else if (!z2 || checkRegionForParsing(sb.toString(), str2)) {
                if (z) {
                    phoneNumber.setRawInput(str);
                }
                String maybeStripExtension = maybeStripExtension(sb);
                if (maybeStripExtension.length() > 0) {
                    phoneNumber.setExtension(maybeStripExtension);
                }
                PhoneMetadata metadataForRegion = getMetadataForRegion(str2);
                StringBuilder sb2 = new StringBuilder();
                try {
                    i = maybeExtractCountryCode(sb.toString(), metadataForRegion, sb2, z, phoneNumber);
                } catch (NumberParseException e) {
                    Matcher matcher = PLUS_CHARS_PATTERN.matcher(sb.toString());
                    if (e.getErrorType() != ErrorType.INVALID_COUNTRY_CODE || !matcher.lookingAt()) {
                        throw new NumberParseException(e.getErrorType(), e.getMessage());
                    }
                    i = maybeExtractCountryCode(sb.substring(matcher.end()), metadataForRegion, sb2, z, phoneNumber);
                    if (i == 0) {
                        throw new NumberParseException(ErrorType.INVALID_COUNTRY_CODE, "Could not interpret numbers after plus-sign.");
                    }
                }
                if (i != 0) {
                    String regionCodeForCountryCode = getRegionCodeForCountryCode(i);
                    if (!regionCodeForCountryCode.equals(str2)) {
                        metadataForRegion = getMetadataForRegionOrCallingCode(i, regionCodeForCountryCode);
                    }
                } else {
                    normalize(sb);
                    sb2.append(sb);
                    if (str2 != null) {
                        phoneNumber.setCountryCode(metadataForRegion.getCountryCode());
                    } else if (z) {
                        phoneNumber.clearCountryCodeSource();
                    }
                }
                if (sb2.length() >= 2) {
                    if (metadataForRegion != null) {
                        StringBuilder sb3 = new StringBuilder();
                        StringBuilder sb4 = new StringBuilder(sb2);
                        maybeStripNationalPrefixAndCarrierCode(sb4, metadataForRegion, sb3);
                        if (!isShorterThanPossibleNormalNumber(metadataForRegion, sb4.toString())) {
                            if (z) {
                                phoneNumber.setPreferredDomesticCarrierCode(sb3.toString());
                            }
                            sb2 = sb4;
                        }
                    }
                    int length = sb2.length();
                    if (length < 2) {
                        throw new NumberParseException(ErrorType.TOO_SHORT_NSN, "The string supplied is too short to be a phone number.");
                    } else if (length <= 17) {
                        setItalianLeadingZerosForPhoneNumber(sb2.toString(), phoneNumber);
                        phoneNumber.setNationalNumber(Long.parseLong(sb2.toString()));
                    } else {
                        throw new NumberParseException(ErrorType.TOO_LONG, "The string supplied is too long to be a phone number.");
                    }
                } else {
                    throw new NumberParseException(ErrorType.TOO_SHORT_NSN, "The string supplied is too short to be a phone number.");
                }
            } else {
                throw new NumberParseException(ErrorType.INVALID_COUNTRY_CODE, "Missing or invalid default region.");
            }
        } else {
            throw new NumberParseException(ErrorType.TOO_LONG, "The string supplied was too long to parse.");
        }
    }

    private void buildNationalNumberForParsing(String str, StringBuilder sb) {
        int indexOf = str.indexOf(RFC3966_PHONE_CONTEXT);
        if (indexOf > 0) {
            int length = RFC3966_PHONE_CONTEXT.length() + indexOf;
            if (str.charAt(length) == '+') {
                int indexOf2 = str.indexOf(59, length);
                if (indexOf2 > 0) {
                    sb.append(str.substring(length, indexOf2));
                } else {
                    sb.append(str.substring(length));
                }
            }
            int indexOf3 = str.indexOf(RFC3966_PREFIX);
            sb.append(str.substring(indexOf3 >= 0 ? indexOf3 + RFC3966_PREFIX.length() : 0, indexOf));
        } else {
            sb.append(extractPossibleNumber(str));
        }
        int indexOf4 = sb.indexOf(RFC3966_ISDN_SUBADDRESS);
        if (indexOf4 > 0) {
            sb.delete(indexOf4, sb.length());
        }
    }

    public MatchType isNumberMatch(PhoneNumber phoneNumber, PhoneNumber phoneNumber2) {
        PhoneNumber phoneNumber3 = new PhoneNumber();
        phoneNumber3.mergeFrom(phoneNumber);
        PhoneNumber phoneNumber4 = new PhoneNumber();
        phoneNumber4.mergeFrom(phoneNumber2);
        phoneNumber3.clearRawInput();
        phoneNumber3.clearCountryCodeSource();
        phoneNumber3.clearPreferredDomesticCarrierCode();
        phoneNumber4.clearRawInput();
        phoneNumber4.clearCountryCodeSource();
        phoneNumber4.clearPreferredDomesticCarrierCode();
        if (phoneNumber3.hasExtension() && phoneNumber3.getExtension().length() == 0) {
            phoneNumber3.clearExtension();
        }
        if (phoneNumber4.hasExtension() && phoneNumber4.getExtension().length() == 0) {
            phoneNumber4.clearExtension();
        }
        if (phoneNumber3.hasExtension() && phoneNumber4.hasExtension() && !phoneNumber3.getExtension().equals(phoneNumber4.getExtension())) {
            return MatchType.NO_MATCH;
        }
        int countryCode = phoneNumber3.getCountryCode();
        int countryCode2 = phoneNumber4.getCountryCode();
        if (countryCode == 0 || countryCode2 == 0) {
            phoneNumber3.setCountryCode(countryCode2);
            if (phoneNumber3.exactlySameAs(phoneNumber4)) {
                return MatchType.NSN_MATCH;
            }
            if (isNationalNumberSuffixOfTheOther(phoneNumber3, phoneNumber4)) {
                return MatchType.SHORT_NSN_MATCH;
            }
            return MatchType.NO_MATCH;
        } else if (phoneNumber3.exactlySameAs(phoneNumber4)) {
            return MatchType.EXACT_MATCH;
        } else {
            if (countryCode != countryCode2 || !isNationalNumberSuffixOfTheOther(phoneNumber3, phoneNumber4)) {
                return MatchType.NO_MATCH;
            }
            return MatchType.SHORT_NSN_MATCH;
        }
    }

    private boolean isNationalNumberSuffixOfTheOther(PhoneNumber phoneNumber, PhoneNumber phoneNumber2) {
        String valueOf = String.valueOf(phoneNumber.getNationalNumber());
        String valueOf2 = String.valueOf(phoneNumber2.getNationalNumber());
        return valueOf.endsWith(valueOf2) || valueOf2.endsWith(valueOf);
    }

    public MatchType isNumberMatch(String str, String str2) {
        try {
            return isNumberMatch(parse(str, UNKNOWN_REGION), str2);
        } catch (NumberParseException e) {
            if (e.getErrorType() == ErrorType.INVALID_COUNTRY_CODE) {
                try {
                    return isNumberMatch(parse(str2, UNKNOWN_REGION), str);
                } catch (NumberParseException e2) {
                    if (e2.getErrorType() == ErrorType.INVALID_COUNTRY_CODE) {
                        try {
                            PhoneNumber phoneNumber = new PhoneNumber();
                            PhoneNumber phoneNumber2 = new PhoneNumber();
                            parseHelper(str, null, false, false, phoneNumber);
                            parseHelper(str2, null, false, false, phoneNumber2);
                            return isNumberMatch(phoneNumber, phoneNumber2);
                        } catch (NumberParseException unused) {
                            return MatchType.NOT_A_NUMBER;
                        }
                    }
                    return MatchType.NOT_A_NUMBER;
                }
            }
            return MatchType.NOT_A_NUMBER;
        }
    }

    public MatchType isNumberMatch(PhoneNumber phoneNumber, String str) {
        try {
            return isNumberMatch(phoneNumber, parse(str, UNKNOWN_REGION));
        } catch (NumberParseException e) {
            if (e.getErrorType() == ErrorType.INVALID_COUNTRY_CODE) {
                String regionCodeForCountryCode = getRegionCodeForCountryCode(phoneNumber.getCountryCode());
                try {
                    if (!regionCodeForCountryCode.equals(UNKNOWN_REGION)) {
                        MatchType isNumberMatch = isNumberMatch(phoneNumber, parse(str, regionCodeForCountryCode));
                        return isNumberMatch == MatchType.EXACT_MATCH ? MatchType.NSN_MATCH : isNumberMatch;
                    }
                    PhoneNumber phoneNumber2 = new PhoneNumber();
                    parseHelper(str, null, false, false, phoneNumber2);
                    return isNumberMatch(phoneNumber, phoneNumber2);
                } catch (NumberParseException unused) {
                    return MatchType.NOT_A_NUMBER;
                }
            }
            return MatchType.NOT_A_NUMBER;
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean canBeInternationallyDialled(PhoneNumber phoneNumber) {
        PhoneMetadata metadataForRegion = getMetadataForRegion(getRegionCodeForNumber(phoneNumber));
        if (metadataForRegion == null) {
            return true;
        }
        return !isNumberMatchingDesc(getNationalSignificantNumber(phoneNumber), metadataForRegion.getNoInternationalDialling());
    }

    public boolean isMobileNumberPortableRegion(String str) {
        PhoneMetadata metadataForRegion = getMetadataForRegion(str);
        if (metadataForRegion != null) {
            return metadataForRegion.isMobileNumberPortableRegion();
        }
        // Logger logger2 = logger;
        Level level = Level.WARNING;
        String str2 = "Invalid or unknown region code provided: ";
        String valueOf = String.valueOf(str);
        logger2.log(level, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        return false;
    }
}
