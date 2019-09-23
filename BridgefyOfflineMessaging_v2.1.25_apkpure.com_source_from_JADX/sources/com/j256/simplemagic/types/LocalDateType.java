package com.j256.simplemagic.types;

import com.j256.simplemagic.endian.EndianType;
import com.j256.simplemagic.entries.MagicFormatter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LocalDateType extends IntegerType {
    protected final ThreadLocal<SimpleDateFormat> dateFormat = new ThreadLocal<SimpleDateFormat>() {
        /* access modifiers changed from: protected */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
        }
    };

    /* access modifiers changed from: protected */
    public void assisgnTimeZone(SimpleDateFormat simpleDateFormat) {
    }

    public LocalDateType(EndianType endianType) {
        super(endianType);
    }

    public void renderValue(StringBuilder sb, Object obj, MagicFormatter magicFormatter) {
        Date dateFromExtractedValue = dateFromExtractedValue(((Long) obj).longValue());
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) this.dateFormat.get();
        assisgnTimeZone(simpleDateFormat);
        magicFormatter.format(sb, simpleDateFormat.format(dateFromExtractedValue));
    }

    /* access modifiers changed from: protected */
    public Date dateFromExtractedValue(long j) {
        return new Date(j * 1000);
    }
}
