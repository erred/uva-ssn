package com.google.i18n.phonenumbers;

import com.google.i18n.phonenumbers.Phonemetadata.PhoneMetadata;
import com.google.i18n.phonenumbers.Phonemetadata.PhoneMetadataCollection;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

class MetadataManager {
    private static final String ALTERNATE_FORMATS_FILE_PREFIX = "/com/google/i18n/phonenumbers/data/PhoneNumberAlternateFormatsProto";
    private static final Logger LOGGER = Logger.getLogger(MetadataManager.class.getName());
    private static final String SHORT_NUMBER_METADATA_FILE_PREFIX = "/com/google/i18n/phonenumbers/data/ShortNumberMetadataProto";
    private static final Map<Integer, PhoneMetadata> callingCodeToAlternateFormatsMap = Collections.synchronizedMap(new HashMap());
    private static final Set<Integer> countryCodeSet = AlternateFormatsCountryCodeSet.getCountryCodeSet();
    private static final Set<String> regionCodeSet = ShortNumbersRegionCodeSet.getRegionCodeSet();
    private static final Map<String, PhoneMetadata> regionCodeToShortNumberMetadataMap = Collections.synchronizedMap(new HashMap());

    private MetadataManager() {
    }

    private static void close(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                LOGGER.log(Level.WARNING, e.toString());
            }
        }
    }

    private static void loadAlternateFormatsMetadataFromFile(int i) {
        String valueOf = String.valueOf(String.valueOf("/com/google/i18n/phonenumbers/data/PhoneNumberAlternateFormatsProto_"));
        StringBuilder sb = new StringBuilder(valueOf.length() + 11);
        sb.append(valueOf);
        sb.append(i);
        ObjectInputStream objectInputStream = null;
        try {
            ObjectInputStream objectInputStream2 = new ObjectInputStream(PhoneNumberMatcher.class.getResourceAsStream(sb.toString()));
            try {
                PhoneMetadataCollection phoneMetadataCollection = new PhoneMetadataCollection();
                phoneMetadataCollection.readExternal(objectInputStream2);
                for (PhoneMetadata phoneMetadata : phoneMetadataCollection.getMetadataList()) {
                    callingCodeToAlternateFormatsMap.put(Integer.valueOf(phoneMetadata.getCountryCode()), phoneMetadata);
                }
                close(objectInputStream2);
            } catch (IOException e) {
                e = e;
                objectInputStream = objectInputStream2;
                try {
                    LOGGER.log(Level.WARNING, e.toString());
                    close(objectInputStream);
                } catch (Throwable th) {
                    th = th;
                    objectInputStream2 = objectInputStream;
                    close(objectInputStream2);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                close(objectInputStream2);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            LOGGER.log(Level.WARNING, e.toString());
            close(objectInputStream);
        }
    }

    static PhoneMetadata getAlternateFormatsForCountry(int i) {
        if (!countryCodeSet.contains(Integer.valueOf(i))) {
            return null;
        }
        synchronized (callingCodeToAlternateFormatsMap) {
            if (!callingCodeToAlternateFormatsMap.containsKey(Integer.valueOf(i))) {
                loadAlternateFormatsMetadataFromFile(i);
            }
        }
        return (PhoneMetadata) callingCodeToAlternateFormatsMap.get(Integer.valueOf(i));
    }

    private static void loadShortNumberMetadataFromFile(String str) {
        Class<PhoneNumberMatcher> cls = PhoneNumberMatcher.class;
        String valueOf = String.valueOf("/com/google/i18n/phonenumbers/data/ShortNumberMetadataProto_");
        String valueOf2 = String.valueOf(str);
        InputStream resourceAsStream = cls.getResourceAsStream(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        ObjectInputStream objectInputStream = null;
        try {
            ObjectInputStream objectInputStream2 = new ObjectInputStream(resourceAsStream);
            try {
                PhoneMetadataCollection phoneMetadataCollection = new PhoneMetadataCollection();
                phoneMetadataCollection.readExternal(objectInputStream2);
                for (PhoneMetadata put : phoneMetadataCollection.getMetadataList()) {
                    regionCodeToShortNumberMetadataMap.put(str, put);
                }
                close(objectInputStream2);
            } catch (IOException e) {
                e = e;
                objectInputStream = objectInputStream2;
                try {
                    LOGGER.log(Level.WARNING, e.toString());
                    close(objectInputStream);
                } catch (Throwable th) {
                    th = th;
                    objectInputStream2 = objectInputStream;
                    close(objectInputStream2);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                close(objectInputStream2);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            LOGGER.log(Level.WARNING, e.toString());
            close(objectInputStream);
        }
    }

    static Set<String> getShortNumberMetadataSupportedRegions() {
        return regionCodeSet;
    }

    static PhoneMetadata getShortNumberMetadataForRegion(String str) {
        if (!regionCodeSet.contains(str)) {
            return null;
        }
        synchronized (regionCodeToShortNumberMetadataMap) {
            if (!regionCodeToShortNumberMetadataMap.containsKey(str)) {
                loadShortNumberMetadataFromFile(str);
            }
        }
        return (PhoneMetadata) regionCodeToShortNumberMetadataMap.get(str);
    }
}
