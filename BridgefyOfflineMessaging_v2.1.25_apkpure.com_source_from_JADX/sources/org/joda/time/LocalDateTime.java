package org.joda.time;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import org.joda.convert.FromString;
import org.joda.convert.ToString;
import org.joda.time.base.BaseLocal;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.convert.ConverterManager;
import org.joda.time.convert.PartialConverter;
import org.joda.time.field.AbstractReadableInstantFieldProperty;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public final class LocalDateTime extends BaseLocal implements Serializable, ReadablePartial {
    private static final int DAY_OF_MONTH = 2;
    private static final int MILLIS_OF_DAY = 3;
    private static final int MONTH_OF_YEAR = 1;
    private static final int YEAR = 0;
    private static final long serialVersionUID = -268716875315837168L;
    private final Chronology iChronology;
    private final long iLocalMillis;

    public static final class Property extends AbstractReadableInstantFieldProperty {
        private static final long serialVersionUID = -358138762846288L;
        private transient DateTimeField iField;
        private transient LocalDateTime iInstant;

        Property(LocalDateTime localDateTime, DateTimeField dateTimeField) {
            this.iInstant = localDateTime;
            this.iField = dateTimeField;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeObject(this.iInstant);
            objectOutputStream.writeObject(this.iField.getType());
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            this.iInstant = (LocalDateTime) objectInputStream.readObject();
            this.iField = ((DateTimeFieldType) objectInputStream.readObject()).getField(this.iInstant.getChronology());
        }

        public DateTimeField getField() {
            return this.iField;
        }

        /* access modifiers changed from: protected */
        public long getMillis() {
            return this.iInstant.getLocalMillis();
        }

        /* access modifiers changed from: protected */
        public Chronology getChronology() {
            return this.iInstant.getChronology();
        }

        public LocalDateTime getLocalDateTime() {
            return this.iInstant;
        }

        public LocalDateTime addToCopy(int i) {
            return this.iInstant.withLocalMillis(this.iField.add(this.iInstant.getLocalMillis(), i));
        }

        public LocalDateTime addToCopy(long j) {
            return this.iInstant.withLocalMillis(this.iField.add(this.iInstant.getLocalMillis(), j));
        }

        public LocalDateTime addWrapFieldToCopy(int i) {
            return this.iInstant.withLocalMillis(this.iField.addWrapField(this.iInstant.getLocalMillis(), i));
        }

        public LocalDateTime setCopy(int i) {
            return this.iInstant.withLocalMillis(this.iField.set(this.iInstant.getLocalMillis(), i));
        }

        public LocalDateTime setCopy(String str, Locale locale) {
            return this.iInstant.withLocalMillis(this.iField.set(this.iInstant.getLocalMillis(), str, locale));
        }

        public LocalDateTime setCopy(String str) {
            return setCopy(str, null);
        }

        public LocalDateTime withMaximumValue() {
            return setCopy(getMaximumValue());
        }

        public LocalDateTime withMinimumValue() {
            return setCopy(getMinimumValue());
        }

        public LocalDateTime roundFloorCopy() {
            return this.iInstant.withLocalMillis(this.iField.roundFloor(this.iInstant.getLocalMillis()));
        }

        public LocalDateTime roundCeilingCopy() {
            return this.iInstant.withLocalMillis(this.iField.roundCeiling(this.iInstant.getLocalMillis()));
        }

        public LocalDateTime roundHalfFloorCopy() {
            return this.iInstant.withLocalMillis(this.iField.roundHalfFloor(this.iInstant.getLocalMillis()));
        }

        public LocalDateTime roundHalfCeilingCopy() {
            return this.iInstant.withLocalMillis(this.iField.roundHalfCeiling(this.iInstant.getLocalMillis()));
        }

        public LocalDateTime roundHalfEvenCopy() {
            return this.iInstant.withLocalMillis(this.iField.roundHalfEven(this.iInstant.getLocalMillis()));
        }
    }

    public int size() {
        return 4;
    }

    public static LocalDateTime now() {
        return new LocalDateTime();
    }

    public static LocalDateTime now(DateTimeZone dateTimeZone) {
        if (dateTimeZone != null) {
            return new LocalDateTime(dateTimeZone);
        }
        throw new NullPointerException("Zone must not be null");
    }

    public static LocalDateTime now(Chronology chronology) {
        if (chronology != null) {
            return new LocalDateTime(chronology);
        }
        throw new NullPointerException("Chronology must not be null");
    }

    @FromString
    public static LocalDateTime parse(String str) {
        return parse(str, ISODateTimeFormat.localDateOptionalTimeParser());
    }

    public static LocalDateTime parse(String str, DateTimeFormatter dateTimeFormatter) {
        return dateTimeFormatter.parseLocalDateTime(str);
    }

    public static LocalDateTime fromCalendarFields(Calendar calendar) {
        if (calendar != null) {
            int i = calendar.get(0);
            int i2 = calendar.get(1);
            if (i != 1) {
                i2 = 1 - i2;
            }
            LocalDateTime localDateTime = new LocalDateTime(i2, calendar.get(2) + 1, calendar.get(5), calendar.get(11), calendar.get(12), calendar.get(13), calendar.get(14));
            return localDateTime;
        }
        throw new IllegalArgumentException("The calendar must not be null");
    }

    public static LocalDateTime fromDateFields(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        } else if (date.getTime() < 0) {
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTime(date);
            return fromCalendarFields(gregorianCalendar);
        } else {
            LocalDateTime localDateTime = new LocalDateTime(date.getYear() + 1900, date.getMonth() + 1, date.getDate(), date.getHours(), date.getMinutes(), date.getSeconds(), (((int) (date.getTime() % 1000)) + 1000) % 1000);
            return localDateTime;
        }
    }

    public LocalDateTime() {
        this(DateTimeUtils.currentTimeMillis(), (Chronology) ISOChronology.getInstance());
    }

    public LocalDateTime(DateTimeZone dateTimeZone) {
        this(DateTimeUtils.currentTimeMillis(), (Chronology) ISOChronology.getInstance(dateTimeZone));
    }

    public LocalDateTime(Chronology chronology) {
        this(DateTimeUtils.currentTimeMillis(), chronology);
    }

    public LocalDateTime(long j) {
        this(j, (Chronology) ISOChronology.getInstance());
    }

    public LocalDateTime(long j, DateTimeZone dateTimeZone) {
        this(j, (Chronology) ISOChronology.getInstance(dateTimeZone));
    }

    public LocalDateTime(long j, Chronology chronology) {
        Chronology chronology2 = DateTimeUtils.getChronology(chronology);
        this.iLocalMillis = chronology2.getZone().getMillisKeepLocal(DateTimeZone.UTC, j);
        this.iChronology = chronology2.withUTC();
    }

    public LocalDateTime(Object obj) {
        this(obj, (Chronology) null);
    }

    public LocalDateTime(Object obj, DateTimeZone dateTimeZone) {
        PartialConverter partialConverter = ConverterManager.getInstance().getPartialConverter(obj);
        Chronology chronology = DateTimeUtils.getChronology(partialConverter.getChronology(obj, dateTimeZone));
        this.iChronology = chronology.withUTC();
        int[] partialValues = partialConverter.getPartialValues(this, obj, chronology, ISODateTimeFormat.localDateOptionalTimeParser());
        this.iLocalMillis = this.iChronology.getDateTimeMillis(partialValues[0], partialValues[1], partialValues[2], partialValues[3]);
    }

    public LocalDateTime(Object obj, Chronology chronology) {
        PartialConverter partialConverter = ConverterManager.getInstance().getPartialConverter(obj);
        Chronology chronology2 = DateTimeUtils.getChronology(partialConverter.getChronology(obj, chronology));
        this.iChronology = chronology2.withUTC();
        int[] partialValues = partialConverter.getPartialValues(this, obj, chronology2, ISODateTimeFormat.localDateOptionalTimeParser());
        this.iLocalMillis = this.iChronology.getDateTimeMillis(partialValues[0], partialValues[1], partialValues[2], partialValues[3]);
    }

    public LocalDateTime(int i, int i2, int i3, int i4, int i5) {
        this(i, i2, i3, i4, i5, 0, 0, ISOChronology.getInstanceUTC());
    }

    public LocalDateTime(int i, int i2, int i3, int i4, int i5, int i6) {
        this(i, i2, i3, i4, i5, i6, 0, ISOChronology.getInstanceUTC());
    }

    public LocalDateTime(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this(i, i2, i3, i4, i5, i6, i7, ISOChronology.getInstanceUTC());
    }

    public LocalDateTime(int i, int i2, int i3, int i4, int i5, int i6, int i7, Chronology chronology) {
        Chronology withUTC = DateTimeUtils.getChronology(chronology).withUTC();
        long dateTimeMillis = withUTC.getDateTimeMillis(i, i2, i3, i4, i5, i6, i7);
        this.iChronology = withUTC;
        this.iLocalMillis = dateTimeMillis;
    }

    private Object readResolve() {
        if (this.iChronology == null) {
            return new LocalDateTime(this.iLocalMillis, (Chronology) ISOChronology.getInstanceUTC());
        }
        return !DateTimeZone.UTC.equals(this.iChronology.getZone()) ? new LocalDateTime(this.iLocalMillis, this.iChronology.withUTC()) : this;
    }

    /* access modifiers changed from: protected */
    public DateTimeField getField(int i, Chronology chronology) {
        switch (i) {
            case 0:
                return chronology.year();
            case 1:
                return chronology.monthOfYear();
            case 2:
                return chronology.dayOfMonth();
            case 3:
                return chronology.millisOfDay();
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid index: ");
                sb.append(i);
                throw new IndexOutOfBoundsException(sb.toString());
        }
    }

    public int getValue(int i) {
        switch (i) {
            case 0:
                return getChronology().year().get(getLocalMillis());
            case 1:
                return getChronology().monthOfYear().get(getLocalMillis());
            case 2:
                return getChronology().dayOfMonth().get(getLocalMillis());
            case 3:
                return getChronology().millisOfDay().get(getLocalMillis());
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid index: ");
                sb.append(i);
                throw new IndexOutOfBoundsException(sb.toString());
        }
    }

    public int get(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType != null) {
            return dateTimeFieldType.getField(getChronology()).get(getLocalMillis());
        }
        throw new IllegalArgumentException("The DateTimeFieldType must not be null");
    }

    public boolean isSupported(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType == null) {
            return false;
        }
        return dateTimeFieldType.getField(getChronology()).isSupported();
    }

    public boolean isSupported(DurationFieldType durationFieldType) {
        if (durationFieldType == null) {
            return false;
        }
        return durationFieldType.getField(getChronology()).isSupported();
    }

    /* access modifiers changed from: protected */
    public long getLocalMillis() {
        return this.iLocalMillis;
    }

    public Chronology getChronology() {
        return this.iChronology;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj instanceof LocalDateTime) {
            LocalDateTime localDateTime = (LocalDateTime) obj;
            if (this.iChronology.equals(localDateTime.iChronology)) {
                if (this.iLocalMillis != localDateTime.iLocalMillis) {
                    z = false;
                }
                return z;
            }
        }
        return super.equals(obj);
    }

    public int compareTo(ReadablePartial readablePartial) {
        int i = 0;
        if (this == readablePartial) {
            return 0;
        }
        if (readablePartial instanceof LocalDateTime) {
            LocalDateTime localDateTime = (LocalDateTime) readablePartial;
            if (this.iChronology.equals(localDateTime.iChronology)) {
                if (this.iLocalMillis < localDateTime.iLocalMillis) {
                    i = -1;
                } else if (this.iLocalMillis != localDateTime.iLocalMillis) {
                    i = 1;
                }
                return i;
            }
        }
        return super.compareTo(readablePartial);
    }

    public DateTime toDateTime() {
        return toDateTime(null);
    }

    public DateTime toDateTime(DateTimeZone dateTimeZone) {
        DateTime dateTime = new DateTime(getYear(), getMonthOfYear(), getDayOfMonth(), getHourOfDay(), getMinuteOfHour(), getSecondOfMinute(), getMillisOfSecond(), this.iChronology.withZone(DateTimeUtils.getZone(dateTimeZone)));
        return dateTime;
    }

    public LocalDate toLocalDate() {
        return new LocalDate(getLocalMillis(), getChronology());
    }

    public LocalTime toLocalTime() {
        return new LocalTime(getLocalMillis(), getChronology());
    }

    public Date toDate() {
        Date date = new Date(getYear() - 1900, getMonthOfYear() - 1, getDayOfMonth(), getHourOfDay(), getMinuteOfHour(), getSecondOfMinute());
        date.setTime(date.getTime() + ((long) getMillisOfSecond()));
        return correctDstTransition(date, TimeZone.getDefault());
    }

    public Date toDate(TimeZone timeZone) {
        Calendar instance = Calendar.getInstance(timeZone);
        instance.clear();
        instance.set(getYear(), getMonthOfYear() - 1, getDayOfMonth(), getHourOfDay(), getMinuteOfHour(), getSecondOfMinute());
        Date time = instance.getTime();
        time.setTime(time.getTime() + ((long) getMillisOfSecond()));
        return correctDstTransition(time, timeZone);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0064, code lost:
        if (fromCalendarFields(r6).equals(r5) != false) goto L_0x0068;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Date correctDstTransition(java.util.Date r6, java.util.TimeZone r7) {
        /*
            r5 = this;
            java.util.Calendar r0 = java.util.Calendar.getInstance(r7)
            r0.setTime(r6)
            org.joda.time.LocalDateTime r6 = fromCalendarFields(r0)
            boolean r1 = r6.isBefore(r5)
            if (r1 == 0) goto L_0x0045
        L_0x0011:
            boolean r7 = r6.isBefore(r5)
            if (r7 == 0) goto L_0x0027
            long r6 = r0.getTimeInMillis()
            r1 = 60000(0xea60, double:2.9644E-319)
            long r6 = r6 + r1
            r0.setTimeInMillis(r6)
            org.joda.time.LocalDateTime r6 = fromCalendarFields(r0)
            goto L_0x0011
        L_0x0027:
            boolean r6 = r6.isBefore(r5)
            r1 = 1000(0x3e8, double:4.94E-321)
            if (r6 != 0) goto L_0x003c
            long r6 = r0.getTimeInMillis()
            long r6 = r6 - r1
            r0.setTimeInMillis(r6)
            org.joda.time.LocalDateTime r6 = fromCalendarFields(r0)
            goto L_0x0027
        L_0x003c:
            long r6 = r0.getTimeInMillis()
            long r6 = r6 + r1
            r0.setTimeInMillis(r6)
            goto L_0x0067
        L_0x0045:
            boolean r6 = r6.equals(r5)
            if (r6 == 0) goto L_0x0067
            java.util.Calendar r6 = java.util.Calendar.getInstance(r7)
            long r1 = r0.getTimeInMillis()
            int r7 = r7.getDSTSavings()
            long r3 = (long) r7
            long r1 = r1 - r3
            r6.setTimeInMillis(r1)
            org.joda.time.LocalDateTime r7 = fromCalendarFields(r6)
            boolean r7 = r7.equals(r5)
            if (r7 == 0) goto L_0x0067
            goto L_0x0068
        L_0x0067:
            r6 = r0
        L_0x0068:
            java.util.Date r6 = r6.getTime()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.LocalDateTime.correctDstTransition(java.util.Date, java.util.TimeZone):java.util.Date");
    }

    /* access modifiers changed from: 0000 */
    public LocalDateTime withLocalMillis(long j) {
        return j == getLocalMillis() ? this : new LocalDateTime(j, getChronology());
    }

    public LocalDateTime withDate(int i, int i2, int i3) {
        Chronology chronology = getChronology();
        return withLocalMillis(chronology.dayOfMonth().set(chronology.monthOfYear().set(chronology.year().set(getLocalMillis(), i), i2), i3));
    }

    public LocalDateTime withTime(int i, int i2, int i3, int i4) {
        Chronology chronology = getChronology();
        return withLocalMillis(chronology.millisOfSecond().set(chronology.secondOfMinute().set(chronology.minuteOfHour().set(chronology.hourOfDay().set(getLocalMillis(), i), i2), i3), i4));
    }

    public LocalDateTime withFields(ReadablePartial readablePartial) {
        return readablePartial == null ? this : withLocalMillis(getChronology().set(readablePartial, getLocalMillis()));
    }

    public LocalDateTime withField(DateTimeFieldType dateTimeFieldType, int i) {
        if (dateTimeFieldType != null) {
            return withLocalMillis(dateTimeFieldType.getField(getChronology()).set(getLocalMillis(), i));
        }
        throw new IllegalArgumentException("Field must not be null");
    }

    public LocalDateTime withFieldAdded(DurationFieldType durationFieldType, int i) {
        if (durationFieldType == null) {
            throw new IllegalArgumentException("Field must not be null");
        } else if (i == 0) {
            return this;
        } else {
            return withLocalMillis(durationFieldType.getField(getChronology()).add(getLocalMillis(), i));
        }
    }

    public LocalDateTime withDurationAdded(ReadableDuration readableDuration, int i) {
        return (readableDuration == null || i == 0) ? this : withLocalMillis(getChronology().add(getLocalMillis(), readableDuration.getMillis(), i));
    }

    public LocalDateTime withPeriodAdded(ReadablePeriod readablePeriod, int i) {
        return (readablePeriod == null || i == 0) ? this : withLocalMillis(getChronology().add(readablePeriod, getLocalMillis(), i));
    }

    public LocalDateTime plus(ReadableDuration readableDuration) {
        return withDurationAdded(readableDuration, 1);
    }

    public LocalDateTime plus(ReadablePeriod readablePeriod) {
        return withPeriodAdded(readablePeriod, 1);
    }

    public LocalDateTime plusYears(int i) {
        if (i == 0) {
            return this;
        }
        return withLocalMillis(getChronology().years().add(getLocalMillis(), i));
    }

    public LocalDateTime plusMonths(int i) {
        if (i == 0) {
            return this;
        }
        return withLocalMillis(getChronology().months().add(getLocalMillis(), i));
    }

    public LocalDateTime plusWeeks(int i) {
        if (i == 0) {
            return this;
        }
        return withLocalMillis(getChronology().weeks().add(getLocalMillis(), i));
    }

    public LocalDateTime plusDays(int i) {
        if (i == 0) {
            return this;
        }
        return withLocalMillis(getChronology().days().add(getLocalMillis(), i));
    }

    public LocalDateTime plusHours(int i) {
        if (i == 0) {
            return this;
        }
        return withLocalMillis(getChronology().hours().add(getLocalMillis(), i));
    }

    public LocalDateTime plusMinutes(int i) {
        if (i == 0) {
            return this;
        }
        return withLocalMillis(getChronology().minutes().add(getLocalMillis(), i));
    }

    public LocalDateTime plusSeconds(int i) {
        if (i == 0) {
            return this;
        }
        return withLocalMillis(getChronology().seconds().add(getLocalMillis(), i));
    }

    public LocalDateTime plusMillis(int i) {
        if (i == 0) {
            return this;
        }
        return withLocalMillis(getChronology().millis().add(getLocalMillis(), i));
    }

    public LocalDateTime minus(ReadableDuration readableDuration) {
        return withDurationAdded(readableDuration, -1);
    }

    public LocalDateTime minus(ReadablePeriod readablePeriod) {
        return withPeriodAdded(readablePeriod, -1);
    }

    public LocalDateTime minusYears(int i) {
        if (i == 0) {
            return this;
        }
        return withLocalMillis(getChronology().years().subtract(getLocalMillis(), i));
    }

    public LocalDateTime minusMonths(int i) {
        if (i == 0) {
            return this;
        }
        return withLocalMillis(getChronology().months().subtract(getLocalMillis(), i));
    }

    public LocalDateTime minusWeeks(int i) {
        if (i == 0) {
            return this;
        }
        return withLocalMillis(getChronology().weeks().subtract(getLocalMillis(), i));
    }

    public LocalDateTime minusDays(int i) {
        if (i == 0) {
            return this;
        }
        return withLocalMillis(getChronology().days().subtract(getLocalMillis(), i));
    }

    public LocalDateTime minusHours(int i) {
        if (i == 0) {
            return this;
        }
        return withLocalMillis(getChronology().hours().subtract(getLocalMillis(), i));
    }

    public LocalDateTime minusMinutes(int i) {
        if (i == 0) {
            return this;
        }
        return withLocalMillis(getChronology().minutes().subtract(getLocalMillis(), i));
    }

    public LocalDateTime minusSeconds(int i) {
        if (i == 0) {
            return this;
        }
        return withLocalMillis(getChronology().seconds().subtract(getLocalMillis(), i));
    }

    public LocalDateTime minusMillis(int i) {
        if (i == 0) {
            return this;
        }
        return withLocalMillis(getChronology().millis().subtract(getLocalMillis(), i));
    }

    public Property property(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType == null) {
            throw new IllegalArgumentException("The DateTimeFieldType must not be null");
        } else if (isSupported(dateTimeFieldType)) {
            return new Property(this, dateTimeFieldType.getField(getChronology()));
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Field '");
            sb.append(dateTimeFieldType);
            sb.append("' is not supported");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public int getEra() {
        return getChronology().era().get(getLocalMillis());
    }

    public int getCenturyOfEra() {
        return getChronology().centuryOfEra().get(getLocalMillis());
    }

    public int getYearOfEra() {
        return getChronology().yearOfEra().get(getLocalMillis());
    }

    public int getYearOfCentury() {
        return getChronology().yearOfCentury().get(getLocalMillis());
    }

    public int getYear() {
        return getChronology().year().get(getLocalMillis());
    }

    public int getWeekyear() {
        return getChronology().weekyear().get(getLocalMillis());
    }

    public int getMonthOfYear() {
        return getChronology().monthOfYear().get(getLocalMillis());
    }

    public int getWeekOfWeekyear() {
        return getChronology().weekOfWeekyear().get(getLocalMillis());
    }

    public int getDayOfYear() {
        return getChronology().dayOfYear().get(getLocalMillis());
    }

    public int getDayOfMonth() {
        return getChronology().dayOfMonth().get(getLocalMillis());
    }

    public int getDayOfWeek() {
        return getChronology().dayOfWeek().get(getLocalMillis());
    }

    public int getHourOfDay() {
        return getChronology().hourOfDay().get(getLocalMillis());
    }

    public int getMinuteOfHour() {
        return getChronology().minuteOfHour().get(getLocalMillis());
    }

    public int getSecondOfMinute() {
        return getChronology().secondOfMinute().get(getLocalMillis());
    }

    public int getMillisOfSecond() {
        return getChronology().millisOfSecond().get(getLocalMillis());
    }

    public int getMillisOfDay() {
        return getChronology().millisOfDay().get(getLocalMillis());
    }

    public LocalDateTime withEra(int i) {
        return withLocalMillis(getChronology().era().set(getLocalMillis(), i));
    }

    public LocalDateTime withCenturyOfEra(int i) {
        return withLocalMillis(getChronology().centuryOfEra().set(getLocalMillis(), i));
    }

    public LocalDateTime withYearOfEra(int i) {
        return withLocalMillis(getChronology().yearOfEra().set(getLocalMillis(), i));
    }

    public LocalDateTime withYearOfCentury(int i) {
        return withLocalMillis(getChronology().yearOfCentury().set(getLocalMillis(), i));
    }

    public LocalDateTime withYear(int i) {
        return withLocalMillis(getChronology().year().set(getLocalMillis(), i));
    }

    public LocalDateTime withWeekyear(int i) {
        return withLocalMillis(getChronology().weekyear().set(getLocalMillis(), i));
    }

    public LocalDateTime withMonthOfYear(int i) {
        return withLocalMillis(getChronology().monthOfYear().set(getLocalMillis(), i));
    }

    public LocalDateTime withWeekOfWeekyear(int i) {
        return withLocalMillis(getChronology().weekOfWeekyear().set(getLocalMillis(), i));
    }

    public LocalDateTime withDayOfYear(int i) {
        return withLocalMillis(getChronology().dayOfYear().set(getLocalMillis(), i));
    }

    public LocalDateTime withDayOfMonth(int i) {
        return withLocalMillis(getChronology().dayOfMonth().set(getLocalMillis(), i));
    }

    public LocalDateTime withDayOfWeek(int i) {
        return withLocalMillis(getChronology().dayOfWeek().set(getLocalMillis(), i));
    }

    public LocalDateTime withHourOfDay(int i) {
        return withLocalMillis(getChronology().hourOfDay().set(getLocalMillis(), i));
    }

    public LocalDateTime withMinuteOfHour(int i) {
        return withLocalMillis(getChronology().minuteOfHour().set(getLocalMillis(), i));
    }

    public LocalDateTime withSecondOfMinute(int i) {
        return withLocalMillis(getChronology().secondOfMinute().set(getLocalMillis(), i));
    }

    public LocalDateTime withMillisOfSecond(int i) {
        return withLocalMillis(getChronology().millisOfSecond().set(getLocalMillis(), i));
    }

    public LocalDateTime withMillisOfDay(int i) {
        return withLocalMillis(getChronology().millisOfDay().set(getLocalMillis(), i));
    }

    public Property era() {
        return new Property(this, getChronology().era());
    }

    public Property centuryOfEra() {
        return new Property(this, getChronology().centuryOfEra());
    }

    public Property yearOfCentury() {
        return new Property(this, getChronology().yearOfCentury());
    }

    public Property yearOfEra() {
        return new Property(this, getChronology().yearOfEra());
    }

    public Property year() {
        return new Property(this, getChronology().year());
    }

    public Property weekyear() {
        return new Property(this, getChronology().weekyear());
    }

    public Property monthOfYear() {
        return new Property(this, getChronology().monthOfYear());
    }

    public Property weekOfWeekyear() {
        return new Property(this, getChronology().weekOfWeekyear());
    }

    public Property dayOfYear() {
        return new Property(this, getChronology().dayOfYear());
    }

    public Property dayOfMonth() {
        return new Property(this, getChronology().dayOfMonth());
    }

    public Property dayOfWeek() {
        return new Property(this, getChronology().dayOfWeek());
    }

    public Property hourOfDay() {
        return new Property(this, getChronology().hourOfDay());
    }

    public Property minuteOfHour() {
        return new Property(this, getChronology().minuteOfHour());
    }

    public Property secondOfMinute() {
        return new Property(this, getChronology().secondOfMinute());
    }

    public Property millisOfSecond() {
        return new Property(this, getChronology().millisOfSecond());
    }

    public Property millisOfDay() {
        return new Property(this, getChronology().millisOfDay());
    }

    @ToString
    public String toString() {
        return ISODateTimeFormat.dateTime().print((ReadablePartial) this);
    }

    public String toString(String str) {
        if (str == null) {
            return toString();
        }
        return DateTimeFormat.forPattern(str).print((ReadablePartial) this);
    }

    public String toString(String str, Locale locale) throws IllegalArgumentException {
        if (str == null) {
            return toString();
        }
        return DateTimeFormat.forPattern(str).withLocale(locale).print((ReadablePartial) this);
    }
}
