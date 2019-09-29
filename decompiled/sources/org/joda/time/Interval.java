package org.joda.time;

import java.io.Serializable;
import org.joda.time.base.BaseInterval;
import org.joda.time.chrono.ISOChronology;

public final class Interval extends BaseInterval implements Serializable, ReadableInterval {
    private static final long serialVersionUID = 4922451897541386752L;

    public Interval toInterval() {
        return this;
    }

    public static Interval parse(String str) {
        return new Interval(str);
    }

    public Interval(long j, long j2) {
        super(j, j2, null);
    }

    public Interval(long j, long j2, DateTimeZone dateTimeZone) {
        super(j, j2, ISOChronology.getInstance(dateTimeZone));
    }

    public Interval(long j, long j2, Chronology chronology) {
        super(j, j2, chronology);
    }

    public Interval(ReadableInstant readableInstant, ReadableInstant readableInstant2) {
        super(readableInstant, readableInstant2);
    }

    public Interval(ReadableInstant readableInstant, ReadableDuration readableDuration) {
        super(readableInstant, readableDuration);
    }

    public Interval(ReadableDuration readableDuration, ReadableInstant readableInstant) {
        super(readableDuration, readableInstant);
    }

    public Interval(ReadableInstant readableInstant, ReadablePeriod readablePeriod) {
        super(readableInstant, readablePeriod);
    }

    public Interval(ReadablePeriod readablePeriod, ReadableInstant readableInstant) {
        super(readablePeriod, readableInstant);
    }

    public Interval(Object obj) {
        super(obj, (Chronology) null);
    }

    public Interval(Object obj, Chronology chronology) {
        super(obj, chronology);
    }

    public Interval overlap(ReadableInterval readableInterval) {
        ReadableInterval readableInterval2 = DateTimeUtils.getReadableInterval(readableInterval);
        if (!overlaps(readableInterval2)) {
            return null;
        }
        Interval interval = new Interval(Math.max(getStartMillis(), readableInterval2.getStartMillis()), Math.min(getEndMillis(), readableInterval2.getEndMillis()), getChronology());
        return interval;
    }

    public Interval gap(ReadableInterval readableInterval) {
        ReadableInterval readableInterval2 = DateTimeUtils.getReadableInterval(readableInterval);
        long startMillis = readableInterval2.getStartMillis();
        long endMillis = readableInterval2.getEndMillis();
        long startMillis2 = getStartMillis();
        long endMillis2 = getEndMillis();
        if (startMillis2 > endMillis) {
            Interval interval = new Interval(endMillis, startMillis2, getChronology());
            return interval;
        } else if (startMillis <= endMillis2) {
            return null;
        } else {
            Interval interval2 = new Interval(endMillis2, startMillis, getChronology());
            return interval2;
        }
    }

    public boolean abuts(ReadableInterval readableInterval) {
        boolean z = false;
        if (readableInterval == null) {
            long currentTimeMillis = DateTimeUtils.currentTimeMillis();
            if (getStartMillis() == currentTimeMillis || getEndMillis() == currentTimeMillis) {
                z = true;
            }
            return z;
        }
        if (readableInterval.getEndMillis() == getStartMillis() || getEndMillis() == readableInterval.getStartMillis()) {
            z = true;
        }
        return z;
    }

    public Interval withChronology(Chronology chronology) {
        if (getChronology() == chronology) {
            return this;
        }
        Interval interval = new Interval(getStartMillis(), getEndMillis(), chronology);
        return interval;
    }

    public Interval withStartMillis(long j) {
        if (j == getStartMillis()) {
            return this;
        }
        Interval interval = new Interval(j, getEndMillis(), getChronology());
        return interval;
    }

    public Interval withStart(ReadableInstant readableInstant) {
        return withStartMillis(DateTimeUtils.getInstantMillis(readableInstant));
    }

    public Interval withEndMillis(long j) {
        if (j == getEndMillis()) {
            return this;
        }
        Interval interval = new Interval(getStartMillis(), j, getChronology());
        return interval;
    }

    public Interval withEnd(ReadableInstant readableInstant) {
        return withEndMillis(DateTimeUtils.getInstantMillis(readableInstant));
    }

    public Interval withDurationAfterStart(ReadableDuration readableDuration) {
        long durationMillis = DateTimeUtils.getDurationMillis(readableDuration);
        if (durationMillis == toDurationMillis()) {
            return this;
        }
        Chronology chronology = getChronology();
        long startMillis = getStartMillis();
        Interval interval = new Interval(startMillis, chronology.add(startMillis, durationMillis, 1), chronology);
        return interval;
    }

    public Interval withDurationBeforeEnd(ReadableDuration readableDuration) {
        long durationMillis = DateTimeUtils.getDurationMillis(readableDuration);
        if (durationMillis == toDurationMillis()) {
            return this;
        }
        Chronology chronology = getChronology();
        long endMillis = getEndMillis();
        Interval interval = new Interval(chronology.add(endMillis, durationMillis, -1), endMillis, chronology);
        return interval;
    }

    public Interval withPeriodAfterStart(ReadablePeriod readablePeriod) {
        if (readablePeriod == null) {
            return withDurationAfterStart(null);
        }
        Chronology chronology = getChronology();
        long startMillis = getStartMillis();
        Interval interval = new Interval(startMillis, chronology.add(readablePeriod, startMillis, 1), chronology);
        return interval;
    }

    public Interval withPeriodBeforeEnd(ReadablePeriod readablePeriod) {
        if (readablePeriod == null) {
            return withDurationBeforeEnd(null);
        }
        Chronology chronology = getChronology();
        long endMillis = getEndMillis();
        Interval interval = new Interval(chronology.add(readablePeriod, endMillis, -1), endMillis, chronology);
        return interval;
    }
}
