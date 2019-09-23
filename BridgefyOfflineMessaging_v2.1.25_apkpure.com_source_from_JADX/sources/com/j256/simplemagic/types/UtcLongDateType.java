package com.j256.simplemagic.types;

import com.j256.simplemagic.endian.EndianType;
import java.util.Date;

public class UtcLongDateType extends UtcDateType {
    private static final int BYTES_PER_UTC_LONG_DATE = 8;

    public int getBytesPerType() {
        return 8;
    }

    public UtcLongDateType(EndianType endianType) {
        super(endianType);
    }

    /* access modifiers changed from: protected */
    public Date dateFromExtractedValue(long j) {
        return new Date(j);
    }
}
