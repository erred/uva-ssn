package com.j256.simplemagic.entries;

import com.google.firebase.analytics.FirebaseAnalytics.Event;
import com.j256.simplemagic.endian.EndianType;
import com.j256.simplemagic.types.BigEndianString16Type;
import com.j256.simplemagic.types.ByteType;
import com.j256.simplemagic.types.DefaultType;
import com.j256.simplemagic.types.DoubleType;
import com.j256.simplemagic.types.FloatType;
import com.j256.simplemagic.types.Id3LengthType;
import com.j256.simplemagic.types.IntegerType;
import com.j256.simplemagic.types.LittleEndianString16Type;
import com.j256.simplemagic.types.LocalDateType;
import com.j256.simplemagic.types.LocalLongDateType;
import com.j256.simplemagic.types.LongType;
import com.j256.simplemagic.types.PStringType;
import com.j256.simplemagic.types.RegexType;
import com.j256.simplemagic.types.SearchType;
import com.j256.simplemagic.types.ShortType;
import com.j256.simplemagic.types.StringType;
import com.j256.simplemagic.types.UtcDateType;
import com.j256.simplemagic.types.UtcLongDateType;
import java.util.HashMap;
import java.util.Map;

public enum MagicType {
    BYTE("byte", new ByteType()),
    SHORT("short", new ShortType(EndianType.NATIVE)),
    INTEGER("long", new IntegerType(EndianType.NATIVE)),
    QUAD("quad", new LongType(EndianType.NATIVE)),
    FLOAT("float", new FloatType(EndianType.NATIVE)),
    DOUBLE("double", new DoubleType(EndianType.NATIVE)),
    STRING("string", new StringType()),
    PSTRING("pstring", new PStringType()),
    DATE("date", new UtcDateType(EndianType.NATIVE)),
    LONG_DATE("qdate", new UtcLongDateType(EndianType.NATIVE)),
    LOCAL_DATE("ldate", new LocalDateType(EndianType.NATIVE)),
    LONG_LOCAL_DATE("qldate", new LocalLongDateType(EndianType.NATIVE)),
    BIG_ENDIAN_ID3("beid3", new Id3LengthType(EndianType.BIG)),
    BIG_ENDIAN_SHORT("beshort", new ShortType(EndianType.BIG)),
    BIG_ENDIAN_INTEGER("belong", new IntegerType(EndianType.BIG)),
    BIG_ENDIAN_QUAD("bequad", new LongType(EndianType.BIG)),
    BIG_ENDIAN_FLOAT("befloat", new FloatType(EndianType.BIG)),
    BIG_ENDIAN_DOUBLE("bedouble", new DoubleType(EndianType.BIG)),
    BIG_ENDIAN_DATE("bedate", new UtcDateType(EndianType.BIG)),
    BIG_ENDIAN_LONG_DATE("beqdate", new UtcLongDateType(EndianType.BIG)),
    BIG_ENDIAN_LOCAL_DATE("beldate", new LocalDateType(EndianType.BIG)),
    BIG_ENDIAN_LONG_LOCAL_DATE("beqldate", new LocalLongDateType(EndianType.BIG)),
    BIG_ENDIAN_TWO_BYTE_STRING("bestring16", new BigEndianString16Type()),
    LITTLE_ENDIAN_ID3("leid3", new Id3LengthType(EndianType.LITTLE)),
    LITTLE_ENDIAN_SHORT("leshort", new ShortType(EndianType.LITTLE)),
    LITTLE_ENDIAN_INTEGER("lelong", new IntegerType(EndianType.LITTLE)),
    LITTLE_ENDIAN_QUAD("lequad", new LongType(EndianType.LITTLE)),
    LITTLE_ENDIAN_FLOAT("lefloat", new FloatType(EndianType.LITTLE)),
    LITTLE_ENDIAN_DOUBLE("ledouble", new DoubleType(EndianType.LITTLE)),
    LITTLE_ENDIAN_DATE("ledate", new UtcDateType(EndianType.LITTLE)),
    LITTLE_ENDIAN_LONG_DATE("leqdate", new UtcLongDateType(EndianType.LITTLE)),
    LITTLE_ENDIAN_LOCAL_DATE("leldate", new LocalDateType(EndianType.LITTLE)),
    LITTLE_ENDIAN_LONG_LOCAL_DATE("leqldate", new LocalLongDateType(EndianType.LITTLE)),
    LITTLE_ENDIAN_TWO_BYTE_STRING("lestring16", new LittleEndianString16Type()),
    REGEX("regex", new RegexType()),
    SEARCH(Event.SEARCH, new SearchType()),
    MIDDLE_ENDIAN_INTEGER("melong", new IntegerType(EndianType.MIDDLE)),
    MIDDLE_ENDIAN_DATE("medate", new UtcDateType(EndianType.MIDDLE)),
    MIDDLE_ENDIAN_LOCAL_DATE("meldate", new LocalDateType(EndianType.MIDDLE)),
    DEFAULT("default", new DefaultType());
    
    private static final Map<String, MagicMatcher> typeMap = null;
    private final MagicMatcher matcher;
    private final String name;

    static {
        int i;
        MagicType[] values;
        typeMap = new HashMap();
        for (MagicType magicType : values()) {
            typeMap.put(magicType.name, magicType.matcher);
        }
    }

    private MagicType(String str, MagicMatcher magicMatcher) {
        this.name = str;
        this.matcher = magicMatcher;
    }

    public static MagicMatcher matcherfromString(String str) {
        MagicMatcher magicMatcher = (MagicMatcher) typeMap.get(str);
        if (magicMatcher == null) {
            return null;
        }
        return magicMatcher;
    }
}
