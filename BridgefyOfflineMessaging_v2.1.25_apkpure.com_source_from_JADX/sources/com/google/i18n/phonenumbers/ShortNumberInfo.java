package com.google.i18n.phonenumbers;

import com.google.i18n.phonenumbers.Phonemetadata.PhoneMetadata;
import com.google.i18n.phonenumbers.Phonemetadata.PhoneNumberDesc;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.google.i18n.phonenumbers.internal.MatcherApi;
import com.google.i18n.phonenumbers.internal.RegexBasedMatcher;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ShortNumberInfo {
    private static final ShortNumberInfo INSTANCE = new ShortNumberInfo(RegexBasedMatcher.create());
    private static final Set<String> REGIONS_WHERE_EMERGENCY_NUMBERS_MUST_BE_EXACT = new HashSet();
    private static final Logger logger = Logger.getLogger(ShortNumberInfo.class.getName());
    private final Map<Integer, List<String>> countryCallingCodeToRegionCodeMap = CountryCodeToRegionCodeMap.getCountryCodeToRegionCodeMap();
    private final MatcherApi matcherApi;

    public enum ShortNumberCost {
        TOLL_FREE,
        STANDARD_RATE,
        PREMIUM_RATE,
        UNKNOWN_COST
    }

    static {
        REGIONS_WHERE_EMERGENCY_NUMBERS_MUST_BE_EXACT.add("BR");
        REGIONS_WHERE_EMERGENCY_NUMBERS_MUST_BE_EXACT.add("CL");
        REGIONS_WHERE_EMERGENCY_NUMBERS_MUST_BE_EXACT.add("NI");
    }

    public static ShortNumberInfo getInstance() {
        return INSTANCE;
    }

    ShortNumberInfo(MatcherApi matcherApi2) {
        this.matcherApi = matcherApi2;
    }

    private List<String> getRegionCodesForCountryCode(int i) {
        List list = (List) this.countryCallingCodeToRegionCodeMap.get(Integer.valueOf(i));
        if (list == null) {
            list = new ArrayList(0);
        }
        return Collections.unmodifiableList(list);
    }

    @Deprecated
    public boolean isPossibleShortNumberForRegion(String str, String str2) {
        PhoneMetadata shortNumberMetadataForRegion = MetadataManager.getShortNumberMetadataForRegion(str2);
        if (shortNumberMetadataForRegion == null) {
            return false;
        }
        return this.matcherApi.matchesPossibleNumber(str, shortNumberMetadataForRegion.getGeneralDesc());
    }

    public boolean isPossibleShortNumberForRegion(PhoneNumber phoneNumber, String str) {
        PhoneMetadata shortNumberMetadataForRegion = MetadataManager.getShortNumberMetadataForRegion(str);
        if (shortNumberMetadataForRegion == null) {
            return false;
        }
        return this.matcherApi.matchesPossibleNumber(getNationalSignificantNumber(phoneNumber), shortNumberMetadataForRegion.getGeneralDesc());
    }

    public boolean isPossibleShortNumber(PhoneNumber phoneNumber) {
        List<String> regionCodesForCountryCode = getRegionCodesForCountryCode(phoneNumber.getCountryCode());
        String nationalSignificantNumber = getNationalSignificantNumber(phoneNumber);
        for (String shortNumberMetadataForRegion : regionCodesForCountryCode) {
            if (this.matcherApi.matchesPossibleNumber(nationalSignificantNumber, MetadataManager.getShortNumberMetadataForRegion(shortNumberMetadataForRegion).getGeneralDesc())) {
                return true;
            }
        }
        return false;
    }

    @Deprecated
    public boolean isValidShortNumberForRegion(String str, String str2) {
        PhoneMetadata shortNumberMetadataForRegion = MetadataManager.getShortNumberMetadataForRegion(str2);
        if (shortNumberMetadataForRegion != null && matchesPossibleNumberAndNationalNumber(str, shortNumberMetadataForRegion.getGeneralDesc())) {
            return matchesPossibleNumberAndNationalNumber(str, shortNumberMetadataForRegion.getShortCode());
        }
        return false;
    }

    public boolean isValidShortNumberForRegion(PhoneNumber phoneNumber, String str) {
        PhoneMetadata shortNumberMetadataForRegion = MetadataManager.getShortNumberMetadataForRegion(str);
        if (shortNumberMetadataForRegion == null) {
            return false;
        }
        String nationalSignificantNumber = getNationalSignificantNumber(phoneNumber);
        if (!matchesPossibleNumberAndNationalNumber(nationalSignificantNumber, shortNumberMetadataForRegion.getGeneralDesc())) {
            return false;
        }
        return matchesPossibleNumberAndNationalNumber(nationalSignificantNumber, shortNumberMetadataForRegion.getShortCode());
    }

    public boolean isValidShortNumber(PhoneNumber phoneNumber) {
        List regionCodesForCountryCode = getRegionCodesForCountryCode(phoneNumber.getCountryCode());
        String regionCodeForShortNumberFromRegionList = getRegionCodeForShortNumberFromRegionList(phoneNumber, regionCodesForCountryCode);
        if (regionCodesForCountryCode.size() <= 1 || regionCodeForShortNumberFromRegionList == null) {
            return isValidShortNumberForRegion(phoneNumber, regionCodeForShortNumberFromRegionList);
        }
        return true;
    }

    @Deprecated
    public ShortNumberCost getExpectedCostForRegion(String str, String str2) {
        PhoneMetadata shortNumberMetadataForRegion = MetadataManager.getShortNumberMetadataForRegion(str2);
        if (shortNumberMetadataForRegion == null) {
            return ShortNumberCost.UNKNOWN_COST;
        }
        if (matchesPossibleNumberAndNationalNumber(str, shortNumberMetadataForRegion.getPremiumRate())) {
            return ShortNumberCost.PREMIUM_RATE;
        }
        if (matchesPossibleNumberAndNationalNumber(str, shortNumberMetadataForRegion.getStandardRate())) {
            return ShortNumberCost.STANDARD_RATE;
        }
        if (matchesPossibleNumberAndNationalNumber(str, shortNumberMetadataForRegion.getTollFree())) {
            return ShortNumberCost.TOLL_FREE;
        }
        if (isEmergencyNumber(str, str2)) {
            return ShortNumberCost.TOLL_FREE;
        }
        return ShortNumberCost.UNKNOWN_COST;
    }

    public ShortNumberCost getExpectedCostForRegion(PhoneNumber phoneNumber, String str) {
        PhoneMetadata shortNumberMetadataForRegion = MetadataManager.getShortNumberMetadataForRegion(str);
        if (shortNumberMetadataForRegion == null) {
            return ShortNumberCost.UNKNOWN_COST;
        }
        String nationalSignificantNumber = getNationalSignificantNumber(phoneNumber);
        if (matchesPossibleNumberAndNationalNumber(nationalSignificantNumber, shortNumberMetadataForRegion.getPremiumRate())) {
            return ShortNumberCost.PREMIUM_RATE;
        }
        if (matchesPossibleNumberAndNationalNumber(nationalSignificantNumber, shortNumberMetadataForRegion.getStandardRate())) {
            return ShortNumberCost.STANDARD_RATE;
        }
        if (matchesPossibleNumberAndNationalNumber(nationalSignificantNumber, shortNumberMetadataForRegion.getTollFree())) {
            return ShortNumberCost.TOLL_FREE;
        }
        if (isEmergencyNumber(nationalSignificantNumber, str)) {
            return ShortNumberCost.TOLL_FREE;
        }
        return ShortNumberCost.UNKNOWN_COST;
    }

    public ShortNumberCost getExpectedCost(PhoneNumber phoneNumber) {
        List<String> regionCodesForCountryCode = getRegionCodesForCountryCode(phoneNumber.getCountryCode());
        if (regionCodesForCountryCode.size() == 0) {
            return ShortNumberCost.UNKNOWN_COST;
        }
        if (regionCodesForCountryCode.size() == 1) {
            return getExpectedCostForRegion(phoneNumber, (String) regionCodesForCountryCode.get(0));
        }
        ShortNumberCost shortNumberCost = ShortNumberCost.TOLL_FREE;
        for (String expectedCostForRegion : regionCodesForCountryCode) {
            ShortNumberCost expectedCostForRegion2 = getExpectedCostForRegion(phoneNumber, expectedCostForRegion);
            switch (expectedCostForRegion2) {
                case PREMIUM_RATE:
                    return ShortNumberCost.PREMIUM_RATE;
                case UNKNOWN_COST:
                    shortNumberCost = ShortNumberCost.UNKNOWN_COST;
                    break;
                case STANDARD_RATE:
                    if (shortNumberCost == ShortNumberCost.UNKNOWN_COST) {
                        break;
                    } else {
                        shortNumberCost = ShortNumberCost.STANDARD_RATE;
                        break;
                    }
                case TOLL_FREE:
                    break;
                default:
                    // Logger logger2 = logger;
                    Level level = Level.SEVERE;
                    String valueOf = String.valueOf(String.valueOf(expectedCostForRegion2));
                    StringBuilder sb = new StringBuilder(valueOf.length() + 30);
                    sb.append("Unrecognised cost for region: ");
                    sb.append(valueOf);
                    logger2.log(level, sb.toString());
                    break;
            }
        }
        return shortNumberCost;
    }

    private String getRegionCodeForShortNumberFromRegionList(PhoneNumber phoneNumber, List<String> list) {
        if (list.size() == 0) {
            return null;
        }
        if (list.size() == 1) {
            return (String) list.get(0);
        }
        String nationalSignificantNumber = getNationalSignificantNumber(phoneNumber);
        for (String str : list) {
            PhoneMetadata shortNumberMetadataForRegion = MetadataManager.getShortNumberMetadataForRegion(str);
            if (shortNumberMetadataForRegion != null && matchesPossibleNumberAndNationalNumber(nationalSignificantNumber, shortNumberMetadataForRegion.getShortCode())) {
                return str;
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public Set<String> getSupportedRegions() {
        return Collections.unmodifiableSet(MetadataManager.getShortNumberMetadataSupportedRegions());
    }

    /* access modifiers changed from: 0000 */
    public String getExampleShortNumber(String str) {
        PhoneMetadata shortNumberMetadataForRegion = MetadataManager.getShortNumberMetadataForRegion(str);
        if (shortNumberMetadataForRegion == null) {
            return "";
        }
        PhoneNumberDesc shortCode = shortNumberMetadataForRegion.getShortCode();
        return shortCode.hasExampleNumber() ? shortCode.getExampleNumber() : "";
    }

    /* access modifiers changed from: 0000 */
    public String getExampleShortNumberForCost(String str, ShortNumberCost shortNumberCost) {
        PhoneMetadata shortNumberMetadataForRegion = MetadataManager.getShortNumberMetadataForRegion(str);
        if (shortNumberMetadataForRegion == null) {
            return "";
        }
        PhoneNumberDesc phoneNumberDesc = null;
        int i = C29341.f6801xe1b2aad7[shortNumberCost.ordinal()];
        if (i != 1) {
            switch (i) {
                case 3:
                    phoneNumberDesc = shortNumberMetadataForRegion.getStandardRate();
                    break;
                case 4:
                    phoneNumberDesc = shortNumberMetadataForRegion.getTollFree();
                    break;
            }
        } else {
            phoneNumberDesc = shortNumberMetadataForRegion.getPremiumRate();
        }
        return (phoneNumberDesc == null || !phoneNumberDesc.hasExampleNumber()) ? "" : phoneNumberDesc.getExampleNumber();
    }

    public boolean connectsToEmergencyNumber(String str, String str2) {
        return matchesEmergencyNumberHelper(str, str2, true);
    }

    public boolean isEmergencyNumber(String str, String str2) {
        return matchesEmergencyNumberHelper(str, str2, false);
    }

    private boolean matchesEmergencyNumberHelper(String str, String str2, boolean z) {
        String extractPossibleNumber = PhoneNumberUtil.extractPossibleNumber(str);
        boolean z2 = false;
        if (PhoneNumberUtil.PLUS_CHARS_PATTERN.matcher(extractPossibleNumber).lookingAt()) {
            return false;
        }
        PhoneMetadata shortNumberMetadataForRegion = MetadataManager.getShortNumberMetadataForRegion(str2);
        if (shortNumberMetadataForRegion == null || !shortNumberMetadataForRegion.hasEmergency()) {
            return false;
        }
        String normalizeDigitsOnly = PhoneNumberUtil.normalizeDigitsOnly(extractPossibleNumber);
        PhoneNumberDesc emergency = shortNumberMetadataForRegion.getEmergency();
        if (z && !REGIONS_WHERE_EMERGENCY_NUMBERS_MUST_BE_EXACT.contains(str2)) {
            z2 = true;
        }
        return this.matcherApi.matchesNationalNumber(normalizeDigitsOnly, emergency, z2);
    }

    public boolean isCarrierSpecific(PhoneNumber phoneNumber) {
        String regionCodeForShortNumberFromRegionList = getRegionCodeForShortNumberFromRegionList(phoneNumber, getRegionCodesForCountryCode(phoneNumber.getCountryCode()));
        String nationalSignificantNumber = getNationalSignificantNumber(phoneNumber);
        PhoneMetadata shortNumberMetadataForRegion = MetadataManager.getShortNumberMetadataForRegion(regionCodeForShortNumberFromRegionList);
        return shortNumberMetadataForRegion != null && matchesPossibleNumberAndNationalNumber(nationalSignificantNumber, shortNumberMetadataForRegion.getCarrierSpecific());
    }

    private static String getNationalSignificantNumber(PhoneNumber phoneNumber) {
        StringBuilder sb = new StringBuilder();
        if (phoneNumber.isItalianLeadingZero()) {
            char[] cArr = new char[phoneNumber.getNumberOfLeadingZeros()];
            Arrays.fill(cArr, '0');
            sb.append(new String(cArr));
        }
        sb.append(phoneNumber.getNationalNumber());
        return sb.toString();
    }

    private boolean matchesPossibleNumberAndNationalNumber(String str, PhoneNumberDesc phoneNumberDesc) {
        return this.matcherApi.matchesPossibleNumber(str, phoneNumberDesc) && this.matcherApi.matchesNationalNumber(str, phoneNumberDesc, false);
    }
}
