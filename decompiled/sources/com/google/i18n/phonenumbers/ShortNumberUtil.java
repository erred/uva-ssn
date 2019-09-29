package com.google.i18n.phonenumbers;

import java.util.Set;

@Deprecated
public class ShortNumberUtil {

    public enum ShortNumberCost {
        TOLL_FREE,
        STANDARD_RATE,
        PREMIUM_RATE,
        UNKNOWN_COST
    }

    public Set<String> getSupportedRegions() {
        return ShortNumberInfo.getInstance().getSupportedRegions();
    }

    public boolean connectsToEmergencyNumber(String str, String str2) {
        return ShortNumberInfo.getInstance().connectsToEmergencyNumber(str, str2);
    }

    public boolean isEmergencyNumber(String str, String str2) {
        return ShortNumberInfo.getInstance().isEmergencyNumber(str, str2);
    }
}
