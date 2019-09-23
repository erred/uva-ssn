package org.joda.time.chrono;

import org.joda.time.Chronology;

abstract class BasicGJChronology extends BasicChronology {
    private static final long FEB_29 = 5097600000L;
    private static final int[] MAX_DAYS_PER_MONTH_ARRAY = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final long[] MAX_TOTAL_MILLIS_BY_MONTH_ARRAY = new long[12];
    private static final int[] MIN_DAYS_PER_MONTH_ARRAY = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final long[] MIN_TOTAL_MILLIS_BY_MONTH_ARRAY = new long[12];
    private static final long serialVersionUID = 538276888268L;

    static {
        long j = 0;
        int i = 0;
        long j2 = 0;
        while (i < 11) {
            j += ((long) MIN_DAYS_PER_MONTH_ARRAY[i]) * 86400000;
            int i2 = i + 1;
            MIN_TOTAL_MILLIS_BY_MONTH_ARRAY[i2] = j;
            j2 += ((long) MAX_DAYS_PER_MONTH_ARRAY[i]) * 86400000;
            MAX_TOTAL_MILLIS_BY_MONTH_ARRAY[i2] = j2;
            i = i2;
        }
    }

    BasicGJChronology(Chronology chronology, Object obj, int i) {
        super(chronology, obj, i);
    }

    /* access modifiers changed from: 0000 */
    public boolean isLeapDay(long j) {
        return dayOfMonth().get(j) == 29 && monthOfYear().isLeap(j);
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0046, code lost:
        if (r13 < 12825000) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005e, code lost:
        if (r13 < 20587500) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0086, code lost:
        if (r13 < 4978125) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0092, code lost:
        if (r13 < 12740625) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00a3, code lost:
        if (r13 < 20503125) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        return 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        return 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
        return 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        return 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
        return 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        return 9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0033, code lost:
        if (r13 < 5062500) goto L_0x0035;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getMonthOfYear(long r13, int r15) {
        /*
            r12 = this;
            long r0 = r12.getYearMillis(r15)
            long r13 = r13 - r0
            r0 = 10
            long r13 = r13 >> r0
            int r13 = (int) r13
            boolean r14 = r12.isLeapYear(r15)
            r15 = 12
            r1 = 11
            r2 = 9
            r3 = 8
            r4 = 6
            r5 = 5
            r6 = 3
            r7 = 2
            r8 = 7
            r9 = 4
            r10 = 1
            r11 = 2615625(0x27e949, float:3.665271E-39)
            if (r14 == 0) goto L_0x0076
            r14 = 15356250(0xea515a, float:2.151869E-38)
            if (r13 >= r14) goto L_0x004e
            r14 = 7678125(0x7528ad, float:1.0759345E-38)
            if (r13 >= r14) goto L_0x003b
            if (r13 >= r11) goto L_0x0030
        L_0x002d:
            r15 = 1
            goto L_0x00b2
        L_0x0030:
            r14 = 5062500(0x4d3f64, float:7.094073E-39)
            if (r13 >= r14) goto L_0x0038
        L_0x0035:
            r15 = 2
            goto L_0x00b2
        L_0x0038:
            r15 = 3
            goto L_0x00b2
        L_0x003b:
            r14 = 10209375(0x9bc85f, float:1.4306382E-38)
            if (r13 >= r14) goto L_0x0043
        L_0x0040:
            r15 = 4
            goto L_0x00b2
        L_0x0043:
            r14 = 12825000(0xc3b1a8, float:1.7971653E-38)
            if (r13 >= r14) goto L_0x004b
        L_0x0048:
            r15 = 5
            goto L_0x00b2
        L_0x004b:
            r15 = 6
            goto L_0x00b2
        L_0x004e:
            r14 = 23118750(0x160c39e, float:4.128265E-38)
            if (r13 >= r14) goto L_0x0066
            r14 = 17971875(0x1123aa3, float:2.6858035E-38)
            if (r13 >= r14) goto L_0x005b
        L_0x0058:
            r15 = 7
            goto L_0x00b2
        L_0x005b:
            r14 = 20587500(0x13a23ec, float:3.4188577E-38)
            if (r13 >= r14) goto L_0x0063
        L_0x0060:
            r15 = 8
            goto L_0x00b2
        L_0x0063:
            r15 = 9
            goto L_0x00b2
        L_0x0066:
            r14 = 25734375(0x188ace7, float:5.020661E-38)
            if (r13 >= r14) goto L_0x006e
        L_0x006b:
            r15 = 10
            goto L_0x00b2
        L_0x006e:
            r14 = 28265625(0x1af4c99, float:6.439476E-38)
            if (r13 >= r14) goto L_0x00b2
        L_0x0073:
            r15 = 11
            goto L_0x00b2
        L_0x0076:
            r14 = 15271875(0xe907c3, float:2.1400455E-38)
            if (r13 >= r14) goto L_0x0095
            r14 = 7593750(0x73df16, float:1.064111E-38)
            if (r13 >= r14) goto L_0x0089
            if (r13 >= r11) goto L_0x0083
            goto L_0x002d
        L_0x0083:
            r14 = 4978125(0x4bf5cd, float:6.975839E-39)
            if (r13 >= r14) goto L_0x0038
            goto L_0x0035
        L_0x0089:
            r14 = 10125000(0x9a7ec8, float:1.4188147E-38)
            if (r13 >= r14) goto L_0x008f
            goto L_0x0040
        L_0x008f:
            r14 = 12740625(0xc26811, float:1.7853418E-38)
            if (r13 >= r14) goto L_0x004b
            goto L_0x0048
        L_0x0095:
            r14 = 23034375(0x15f7a07, float:4.1046182E-38)
            if (r13 >= r14) goto L_0x00a6
            r14 = 17887500(0x110f10c, float:2.6621566E-38)
            if (r13 >= r14) goto L_0x00a0
            goto L_0x0058
        L_0x00a0:
            r14 = 20503125(0x138da55, float:3.3952108E-38)
            if (r13 >= r14) goto L_0x0063
            goto L_0x0060
        L_0x00a6:
            r14 = 25650000(0x1876350, float:4.9733674E-38)
            if (r13 >= r14) goto L_0x00ac
            goto L_0x006b
        L_0x00ac:
            r14 = 28181250(0x1ae0302, float:6.392182E-38)
            if (r13 >= r14) goto L_0x00b2
            goto L_0x0073
        L_0x00b2:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.chrono.BasicGJChronology.getMonthOfYear(long, int):int");
    }

    /* access modifiers changed from: 0000 */
    public int getDaysInYearMonth(int i, int i2) {
        if (isLeapYear(i)) {
            return MAX_DAYS_PER_MONTH_ARRAY[i2 - 1];
        }
        return MIN_DAYS_PER_MONTH_ARRAY[i2 - 1];
    }

    /* access modifiers changed from: 0000 */
    public int getDaysInMonthMax(int i) {
        return MAX_DAYS_PER_MONTH_ARRAY[i - 1];
    }

    /* access modifiers changed from: 0000 */
    public int getDaysInMonthMaxForSet(long j, int i) {
        if (i > 28 || i < 1) {
            return getDaysInMonthMax(j);
        }
        return 28;
    }

    /* access modifiers changed from: 0000 */
    public long getTotalMillisByYearMonth(int i, int i2) {
        if (isLeapYear(i)) {
            return MAX_TOTAL_MILLIS_BY_MONTH_ARRAY[i2 - 1];
        }
        return MIN_TOTAL_MILLIS_BY_MONTH_ARRAY[i2 - 1];
    }

    /* access modifiers changed from: 0000 */
    public long getYearDifference(long j, long j2) {
        int year = getYear(j);
        int year2 = getYear(j2);
        long yearMillis = j - getYearMillis(year);
        long yearMillis2 = j2 - getYearMillis(year2);
        if (yearMillis2 >= FEB_29) {
            if (isLeapYear(year2)) {
                if (!isLeapYear(year)) {
                    yearMillis2 -= 86400000;
                }
            } else if (yearMillis >= FEB_29 && isLeapYear(year)) {
                yearMillis -= 86400000;
            }
        }
        int i = year - year2;
        if (yearMillis < yearMillis2) {
            i--;
        }
        return (long) i;
    }

    /* access modifiers changed from: 0000 */
    public long setYear(long j, int i) {
        int year = getYear(j);
        int dayOfYear = getDayOfYear(j, year);
        int millisOfDay = getMillisOfDay(j);
        if (dayOfYear > 59) {
            if (isLeapYear(year)) {
                if (!isLeapYear(i)) {
                    dayOfYear--;
                }
            } else if (isLeapYear(i)) {
                dayOfYear++;
            }
        }
        return getYearMonthDayMillis(i, 1, dayOfYear) + ((long) millisOfDay);
    }
}
