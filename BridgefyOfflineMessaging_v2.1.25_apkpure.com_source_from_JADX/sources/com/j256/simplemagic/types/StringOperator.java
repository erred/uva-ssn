package com.j256.simplemagic.types;

public enum StringOperator {
    EQUALS('=') {
        public boolean doTest(char c, char c2, boolean z) {
            return c == c2;
        }
    },
    NOT_EQUALS('!') {
        public boolean doTest(char c, char c2, boolean z) {
            return c != c2;
        }
    },
    GREATER_THAN('>') {
        public boolean doTest(char c, char c2, boolean z) {
            boolean z2 = false;
            if (z) {
                if (c > c2) {
                    z2 = true;
                }
                return z2;
            }
            if (c >= c2) {
                z2 = true;
            }
            return z2;
        }
    },
    LESS_THAN('<') {
        public boolean doTest(char c, char c2, boolean z) {
            boolean z2 = false;
            if (z) {
                if (c < c2) {
                    z2 = true;
                }
                return z2;
            }
            if (c <= c2) {
                z2 = true;
            }
            return z2;
        }
    };
    
    public static final StringOperator DEFAULT_OPERATOR = null;
    private final char prefixChar;

    public abstract boolean doTest(char c, char c2, boolean z);

    static {
        DEFAULT_OPERATOR = EQUALS;
    }

    private StringOperator(char c) {
        this.prefixChar = c;
    }

    public static StringOperator fromTest(String str) {
        StringOperator[] values;
        if (str.length() == 0) {
            return null;
        }
        char charAt = str.charAt(0);
        for (StringOperator stringOperator : values()) {
            if (stringOperator.prefixChar == charAt) {
                return stringOperator;
            }
        }
        return null;
    }
}
