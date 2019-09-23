package com.j256.simplemagic.types;

import com.j256.simplemagic.endian.EndianType;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class UtcDateType extends LocalDateType {
    private static final TimeZone UTC_TIME_ZONE = TimeZone.getTimeZone("UTC");

    public UtcDateType(EndianType endianType) {
        super(endianType);
    }

    /* access modifiers changed from: protected */
    public Date dateFromExtractedValue(long j) {
        return new Date(j * 1000);
    }

    /* access modifiers changed from: protected */
    public void assisgnTimeZone(SimpleDateFormat simpleDateFormat) {
        simpleDateFormat.setTimeZone(UTC_TIME_ZONE);
    }
}
