package com.j256.simplemagic.types;

import com.j256.simplemagic.endian.EndianType;
import java.util.Date;

public class LocalLongDateType extends LocalDateType {
    private static final int BYTES_PER_LOCAL_LONG_DATE = 8;

    public int getBytesPerType() {
        return 8;
    }

    public LocalLongDateType(EndianType endianType) {
        super(endianType);
    }

    /* access modifiers changed from: protected */
    public Date dateFromExtractedValue(long j) {
        return new Date(j);
    }
}
