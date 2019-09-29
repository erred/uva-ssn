package com.j256.simplemagic.types;

public enum TestOperator {
    EQUALS('=') {
        public boolean doTest(boolean z, Number number, Number number2, NumberType numberType) {
            return numberType.compare(z, number, number2) == 0;
        }
    },
    NOT_EQUALS('!') {
        public boolean doTest(boolean z, Number number, Number number2, NumberType numberType) {
            return numberType.compare(z, number, number2) != 0;
        }
    },
    GREATER_THAN('>') {
        public boolean doTest(boolean z, Number number, Number number2, NumberType numberType) {
            return numberType.compare(z, number, number2) > 0;
        }
    },
    LESS_THAN('<') {
        public boolean doTest(boolean z, Number number, Number number2, NumberType numberType) {
            return numberType.compare(z, number, number2) < 0;
        }
    },
    AND_ALL_SET('&') {
        public boolean doTest(boolean z, Number number, Number number2, NumberType numberType) {
            long longValue = number2.longValue();
            return (number.longValue() & longValue) == longValue;
        }
    },
    AND_ALL_CLEARED('^') {
        public boolean doTest(boolean z, Number number, Number number2, NumberType numberType) {
            return (number.longValue() & number2.longValue()) == 0;
        }
    },
    NEGATE('~') {
        public boolean doTest(boolean z, Number number, Number number2, NumberType numberType) {
            return number.longValue() == numberType.maskValue(~number2.longValue());
        }
    };
    
    public static final TestOperator DEFAULT_OPERATOR = null;
    private final char prefixChar;

    public abstract boolean doTest(boolean z, Number number, Number number2, NumberType numberType);

    static {
        DEFAULT_OPERATOR = EQUALS;
    }

    private TestOperator(char c) {
        this.prefixChar = c;
    }

    public static TestOperator fromTest(String str) {
        TestOperator[] values;
        if (str.length() == 0) {
            return null;
        }
        char charAt = str.charAt(0);
        for (TestOperator testOperator : values()) {
            if (testOperator.prefixChar == charAt) {
                return testOperator;
            }
        }
        return null;
    }
}
