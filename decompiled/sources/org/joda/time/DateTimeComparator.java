package org.joda.time;

import java.io.Serializable;
import java.util.Comparator;
import org.joda.time.convert.ConverterManager;
import org.joda.time.convert.InstantConverter;

public class DateTimeComparator implements Serializable, Comparator<Object> {
    private static final DateTimeComparator ALL_INSTANCE = new DateTimeComparator(null, null);
    private static final DateTimeComparator DATE_INSTANCE = new DateTimeComparator(DateTimeFieldType.dayOfYear(), null);
    private static final DateTimeComparator TIME_INSTANCE = new DateTimeComparator(null, DateTimeFieldType.dayOfYear());
    private static final long serialVersionUID = -6097339773320178364L;
    private final DateTimeFieldType iLowerLimit;
    private final DateTimeFieldType iUpperLimit;

    public static DateTimeComparator getInstance() {
        return ALL_INSTANCE;
    }

    public static DateTimeComparator getInstance(DateTimeFieldType dateTimeFieldType) {
        return getInstance(dateTimeFieldType, null);
    }

    public static DateTimeComparator getInstance(DateTimeFieldType dateTimeFieldType, DateTimeFieldType dateTimeFieldType2) {
        if (dateTimeFieldType == null && dateTimeFieldType2 == null) {
            return ALL_INSTANCE;
        }
        if (dateTimeFieldType == DateTimeFieldType.dayOfYear() && dateTimeFieldType2 == null) {
            return DATE_INSTANCE;
        }
        if (dateTimeFieldType == null && dateTimeFieldType2 == DateTimeFieldType.dayOfYear()) {
            return TIME_INSTANCE;
        }
        return new DateTimeComparator(dateTimeFieldType, dateTimeFieldType2);
    }

    public static DateTimeComparator getDateOnlyInstance() {
        return DATE_INSTANCE;
    }

    public static DateTimeComparator getTimeOnlyInstance() {
        return TIME_INSTANCE;
    }

    protected DateTimeComparator(DateTimeFieldType dateTimeFieldType, DateTimeFieldType dateTimeFieldType2) {
        this.iLowerLimit = dateTimeFieldType;
        this.iUpperLimit = dateTimeFieldType2;
    }

    public DateTimeFieldType getLowerLimit() {
        return this.iLowerLimit;
    }

    public DateTimeFieldType getUpperLimit() {
        return this.iUpperLimit;
    }

    public int compare(Object obj, Object obj2) {
        InstantConverter instantConverter = ConverterManager.getInstance().getInstantConverter(obj);
        Chronology chronology = null;
        Chronology chronology2 = instantConverter.getChronology(obj, chronology);
        long instantMillis = instantConverter.getInstantMillis(obj, chronology2);
        InstantConverter instantConverter2 = ConverterManager.getInstance().getInstantConverter(obj2);
        Chronology chronology3 = instantConverter2.getChronology(obj2, chronology);
        long instantMillis2 = instantConverter2.getInstantMillis(obj2, chronology3);
        if (this.iLowerLimit != null) {
            instantMillis = this.iLowerLimit.getField(chronology2).roundFloor(instantMillis);
            instantMillis2 = this.iLowerLimit.getField(chronology3).roundFloor(instantMillis2);
        }
        if (this.iUpperLimit != null) {
            instantMillis = this.iUpperLimit.getField(chronology2).remainder(instantMillis);
            instantMillis2 = this.iUpperLimit.getField(chronology3).remainder(instantMillis2);
        }
        int i = (instantMillis > instantMillis2 ? 1 : (instantMillis == instantMillis2 ? 0 : -1));
        if (i < 0) {
            return -1;
        }
        return i > 0 ? 1 : 0;
    }

    private Object readResolve() {
        return getInstance(this.iLowerLimit, this.iUpperLimit);
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof DateTimeComparator)) {
            return false;
        }
        DateTimeComparator dateTimeComparator = (DateTimeComparator) obj;
        if ((this.iLowerLimit == dateTimeComparator.getLowerLimit() || (this.iLowerLimit != null && this.iLowerLimit.equals(dateTimeComparator.getLowerLimit()))) && (this.iUpperLimit == dateTimeComparator.getUpperLimit() || (this.iUpperLimit != null && this.iUpperLimit.equals(dateTimeComparator.getUpperLimit())))) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = this.iLowerLimit == null ? 0 : this.iLowerLimit.hashCode();
        if (this.iUpperLimit != null) {
            i = this.iUpperLimit.hashCode();
        }
        return hashCode + (i * 123);
    }

    public String toString() {
        if (this.iLowerLimit == this.iUpperLimit) {
            StringBuilder sb = new StringBuilder();
            sb.append("DateTimeComparator[");
            sb.append(this.iLowerLimit == null ? "" : this.iLowerLimit.getName());
            sb.append("]");
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("DateTimeComparator[");
        sb2.append(this.iLowerLimit == null ? "" : this.iLowerLimit.getName());
        sb2.append("-");
        sb2.append(this.iUpperLimit == null ? "" : this.iUpperLimit.getName());
        sb2.append("]");
        return sb2.toString();
    }
}
