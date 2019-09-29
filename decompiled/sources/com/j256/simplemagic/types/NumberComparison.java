package com.j256.simplemagic.types;

public class NumberComparison {
    private final NumberType numberType;
    private final TestOperator operator;
    private final Number value;

    public NumberComparison(NumberType numberType2, String str) {
        this.numberType = numberType2;
        TestOperator fromTest = TestOperator.fromTest(str);
        if (fromTest == null) {
            fromTest = TestOperator.DEFAULT_OPERATOR;
        } else {
            str = str.substring(1).trim();
        }
        this.operator = fromTest;
        try {
            this.value = numberType2.decodeValueString(str);
        } catch (NumberFormatException unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not parse number from: '");
            sb.append(str);
            sb.append("'");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public boolean isMatch(Long l, boolean z, Number number) {
        if (l != null) {
            number = Long.valueOf(number.longValue() & l.longValue());
        }
        return this.operator.doTest(z, number, this.value, this.numberType);
    }

    public Number getValue() {
        return this.value;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.operator);
        sb.append(", value ");
        sb.append(this.value);
        return sb.toString();
    }
}
