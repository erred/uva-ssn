package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.Beta;
import com.google.api.client.repackaged.com.google.common.annotations.GwtCompatible;
import com.google.api.client.repackaged.com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import java.util.Arrays;
import java.util.BitSet;

@Beta
@GwtCompatible(emulated = true)
public abstract class CharMatcher implements Predicate<Character> {
    public static final CharMatcher ANY = new FastMatcher("CharMatcher.ANY") {
        public boolean matches(char c) {
            return true;
        }

        public int indexIn(CharSequence charSequence) {
            return charSequence.length() == 0 ? -1 : 0;
        }

        public int indexIn(CharSequence charSequence, int i) {
            int length = charSequence.length();
            Preconditions.checkPositionIndex(i, length);
            if (i == length) {
                return -1;
            }
            return i;
        }

        public int lastIndexIn(CharSequence charSequence) {
            return charSequence.length() - 1;
        }

        public boolean matchesAllOf(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return true;
        }

        public boolean matchesNoneOf(CharSequence charSequence) {
            return charSequence.length() == 0;
        }

        public String removeFrom(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return "";
        }

        public String replaceFrom(CharSequence charSequence, char c) {
            char[] cArr = new char[charSequence.length()];
            Arrays.fill(cArr, c);
            return new String(cArr);
        }

        public String replaceFrom(CharSequence charSequence, CharSequence charSequence2) {
            StringBuilder sb = new StringBuilder(charSequence.length() * charSequence2.length());
            for (int i = 0; i < charSequence.length(); i++) {
                sb.append(charSequence2);
            }
            return sb.toString();
        }

        public String collapseFrom(CharSequence charSequence, char c) {
            return charSequence.length() == 0 ? "" : String.valueOf(c);
        }

        public String trimFrom(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return "";
        }

        public int countIn(CharSequence charSequence) {
            return charSequence.length();
        }

        public CharMatcher and(CharMatcher charMatcher) {
            return (CharMatcher) Preconditions.checkNotNull(charMatcher);
        }

        /* renamed from: or */
        public CharMatcher mo20898or(CharMatcher charMatcher) {
            Preconditions.checkNotNull(charMatcher);
            return this;
        }

        public CharMatcher negate() {
            return NONE;
        }
    };
    public static final CharMatcher ASCII = inRange(0, Ascii.MAX, "CharMatcher.ASCII");
    public static final CharMatcher BREAKING_WHITESPACE = new CharMatcher() {
        public boolean matches(char c) {
            boolean z = true;
            if (!(c == ' ' || c == 133 || c == 5760)) {
                if (c == 8199) {
                    return false;
                }
                if (!(c == 8287 || c == 12288)) {
                    switch (c) {
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                            break;
                        default:
                            switch (c) {
                                case 8232:
                                case 8233:
                                    break;
                                default:
                                    if (c < 8192 || c > 8202) {
                                        z = false;
                                    }
                                    return z;
                            }
                    }
                }
            }
            return true;
        }

        public String toString() {
            return "CharMatcher.BREAKING_WHITESPACE";
        }

        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return CharMatcher.super.apply((Character) obj);
        }
    };
    public static final CharMatcher DIGIT = new RangesMatcher("CharMatcher.DIGIT", ZEROES.toCharArray(), NINES.toCharArray());
    private static final int DISTINCT_CHARS = 65536;
    public static final CharMatcher INVISIBLE = new RangesMatcher("CharMatcher.INVISIBLE", "\u0000­؀؜۝܏ ᠎   ⁦⁧⁨⁩⁪　?﻿￹￺".toCharArray(), "  ­؄؜۝܏ ᠎‏ ⁤⁦⁧⁨⁩⁯　﻿￹￻".toCharArray());
    public static final CharMatcher JAVA_DIGIT = new CharMatcher("CharMatcher.JAVA_DIGIT") {
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return CharMatcher.super.apply((Character) obj);
        }

        public boolean matches(char c) {
            return Character.isDigit(c);
        }
    };
    public static final CharMatcher JAVA_ISO_CONTROL = inRange(0, 31).mo20898or(inRange(Ascii.MAX, 159)).withToString("CharMatcher.JAVA_ISO_CONTROL");
    public static final CharMatcher JAVA_LETTER = new CharMatcher("CharMatcher.JAVA_LETTER") {
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return CharMatcher.super.apply((Character) obj);
        }

        public boolean matches(char c) {
            return Character.isLetter(c);
        }
    };
    public static final CharMatcher JAVA_LETTER_OR_DIGIT = new CharMatcher("CharMatcher.JAVA_LETTER_OR_DIGIT") {
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return CharMatcher.super.apply((Character) obj);
        }

        public boolean matches(char c) {
            return Character.isLetterOrDigit(c);
        }
    };
    public static final CharMatcher JAVA_LOWER_CASE = new CharMatcher("CharMatcher.JAVA_LOWER_CASE") {
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return CharMatcher.super.apply((Character) obj);
        }

        public boolean matches(char c) {
            return Character.isLowerCase(c);
        }
    };
    public static final CharMatcher JAVA_UPPER_CASE = new CharMatcher("CharMatcher.JAVA_UPPER_CASE") {
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return CharMatcher.super.apply((Character) obj);
        }

        public boolean matches(char c) {
            return Character.isUpperCase(c);
        }
    };
    private static final String NINES;
    public static final CharMatcher NONE = new FastMatcher("CharMatcher.NONE") {
        public boolean matches(char c) {
            return false;
        }

        public int indexIn(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return -1;
        }

        public int indexIn(CharSequence charSequence, int i) {
            Preconditions.checkPositionIndex(i, charSequence.length());
            return -1;
        }

        public int lastIndexIn(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return -1;
        }

        public boolean matchesAllOf(CharSequence charSequence) {
            return charSequence.length() == 0;
        }

        public boolean matchesNoneOf(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return true;
        }

        public String removeFrom(CharSequence charSequence) {
            return charSequence.toString();
        }

        public String replaceFrom(CharSequence charSequence, char c) {
            return charSequence.toString();
        }

        public String replaceFrom(CharSequence charSequence, CharSequence charSequence2) {
            Preconditions.checkNotNull(charSequence2);
            return charSequence.toString();
        }

        public String collapseFrom(CharSequence charSequence, char c) {
            return charSequence.toString();
        }

        public String trimFrom(CharSequence charSequence) {
            return charSequence.toString();
        }

        public String trimLeadingFrom(CharSequence charSequence) {
            return charSequence.toString();
        }

        public String trimTrailingFrom(CharSequence charSequence) {
            return charSequence.toString();
        }

        public int countIn(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return 0;
        }

        public CharMatcher and(CharMatcher charMatcher) {
            Preconditions.checkNotNull(charMatcher);
            return this;
        }

        /* renamed from: or */
        public CharMatcher mo20898or(CharMatcher charMatcher) {
            return (CharMatcher) Preconditions.checkNotNull(charMatcher);
        }

        public CharMatcher negate() {
            return ANY;
        }
    };
    public static final CharMatcher SINGLE_WIDTH = new RangesMatcher("CharMatcher.SINGLE_WIDTH", "\u0000־א׳؀ݐ฀Ḁ℀ﭐﹰ｡".toCharArray(), "ӹ־ת״ۿݿ๿₯℺﷿﻿ￜ".toCharArray());
    public static final CharMatcher WHITESPACE = new FastMatcher("WHITESPACE") {
        public boolean matches(char c) {
            return CharMatcher.WHITESPACE_TABLE.charAt((CharMatcher.WHITESPACE_MULTIPLIER * c) >>> WHITESPACE_SHIFT) == c;
        }

        /* access modifiers changed from: 0000 */
        @GwtIncompatible("java.util.BitSet")
        public void setBits(BitSet bitSet) {
            for (int i = 0; i < CharMatcher.WHITESPACE_TABLE.length(); i++) {
                bitSet.set(CharMatcher.WHITESPACE_TABLE.charAt(i));
            }
        }
    };
    static final int WHITESPACE_MULTIPLIER = 1682554634;
    static final int WHITESPACE_SHIFT = Integer.numberOfLeadingZeros(WHITESPACE_TABLE.length() - 1);
    static final String WHITESPACE_TABLE = " 　\r   　 \u000b　   　 \t     \f 　 　　 \n 　";
    private static final String ZEROES = "0٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０";
    final String description;

    private static class And extends CharMatcher {
        final CharMatcher first;
        final CharMatcher second;

        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return CharMatcher.super.apply((Character) obj);
        }

        And(CharMatcher charMatcher, CharMatcher charMatcher2) {
            StringBuilder sb = new StringBuilder();
            sb.append("CharMatcher.and(");
            sb.append(charMatcher);
            sb.append(", ");
            sb.append(charMatcher2);
            sb.append(")");
            this(charMatcher, charMatcher2, sb.toString());
        }

        And(CharMatcher charMatcher, CharMatcher charMatcher2, String str) {
            super(str);
            this.first = (CharMatcher) Preconditions.checkNotNull(charMatcher);
            this.second = (CharMatcher) Preconditions.checkNotNull(charMatcher2);
        }

        public boolean matches(char c) {
            return this.first.matches(c) && this.second.matches(c);
        }

        /* access modifiers changed from: 0000 */
        @GwtIncompatible("java.util.BitSet")
        public void setBits(BitSet bitSet) {
            BitSet bitSet2 = new BitSet();
            this.first.setBits(bitSet2);
            BitSet bitSet3 = new BitSet();
            this.second.setBits(bitSet3);
            bitSet2.and(bitSet3);
            bitSet.or(bitSet2);
        }

        /* access modifiers changed from: 0000 */
        public CharMatcher withToString(String str) {
            return new And(this.first, this.second, str);
        }
    }

    @GwtIncompatible("java.util.BitSet")
    private static class BitSetMatcher extends FastMatcher {
        private final BitSet table;

        private BitSetMatcher(BitSet bitSet, String str) {
            super(str);
            if (bitSet.length() + 64 < bitSet.size()) {
                bitSet = (BitSet) bitSet.clone();
            }
            this.table = bitSet;
        }

        public boolean matches(char c) {
            return this.table.get(c);
        }

        /* access modifiers changed from: 0000 */
        public void setBits(BitSet bitSet) {
            bitSet.or(this.table);
        }
    }

    static abstract class FastMatcher extends CharMatcher {
        public final CharMatcher precomputed() {
            return this;
        }

        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return CharMatcher.super.apply((Character) obj);
        }

        FastMatcher() {
        }

        FastMatcher(String str) {
            super(str);
        }

        public CharMatcher negate() {
            return new NegatedFastMatcher(this);
        }
    }

    static final class NegatedFastMatcher extends NegatedMatcher {
        public final CharMatcher precomputed() {
            return this;
        }

        NegatedFastMatcher(CharMatcher charMatcher) {
            super(charMatcher);
        }

        NegatedFastMatcher(String str, CharMatcher charMatcher) {
            super(str, charMatcher);
        }

        /* access modifiers changed from: 0000 */
        public CharMatcher withToString(String str) {
            return new NegatedFastMatcher(str, this.original);
        }
    }

    private static class NegatedMatcher extends CharMatcher {
        final CharMatcher original;

        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return CharMatcher.super.apply((Character) obj);
        }

        NegatedMatcher(String str, CharMatcher charMatcher) {
            super(str);
            this.original = charMatcher;
        }

        NegatedMatcher(CharMatcher charMatcher) {
            StringBuilder sb = new StringBuilder();
            sb.append(charMatcher);
            sb.append(".negate()");
            this(sb.toString(), charMatcher);
        }

        public boolean matches(char c) {
            return !this.original.matches(c);
        }

        public boolean matchesAllOf(CharSequence charSequence) {
            return this.original.matchesNoneOf(charSequence);
        }

        public boolean matchesNoneOf(CharSequence charSequence) {
            return this.original.matchesAllOf(charSequence);
        }

        public int countIn(CharSequence charSequence) {
            return charSequence.length() - this.original.countIn(charSequence);
        }

        /* access modifiers changed from: 0000 */
        @GwtIncompatible("java.util.BitSet")
        public void setBits(BitSet bitSet) {
            BitSet bitSet2 = new BitSet();
            this.original.setBits(bitSet2);
            bitSet2.flip(0, CharMatcher.DISTINCT_CHARS);
            bitSet.or(bitSet2);
        }

        public CharMatcher negate() {
            return this.original;
        }

        /* access modifiers changed from: 0000 */
        public CharMatcher withToString(String str) {
            return new NegatedMatcher(str, this.original);
        }
    }

    /* renamed from: com.google.api.client.repackaged.com.google.common.base.CharMatcher$Or */
    private static class C2295Or extends CharMatcher {
        final CharMatcher first;
        final CharMatcher second;

        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return CharMatcher.super.apply((Character) obj);
        }

        C2295Or(CharMatcher charMatcher, CharMatcher charMatcher2, String str) {
            super(str);
            this.first = (CharMatcher) Preconditions.checkNotNull(charMatcher);
            this.second = (CharMatcher) Preconditions.checkNotNull(charMatcher2);
        }

        C2295Or(CharMatcher charMatcher, CharMatcher charMatcher2) {
            StringBuilder sb = new StringBuilder();
            sb.append("CharMatcher.or(");
            sb.append(charMatcher);
            sb.append(", ");
            sb.append(charMatcher2);
            sb.append(")");
            this(charMatcher, charMatcher2, sb.toString());
        }

        /* access modifiers changed from: 0000 */
        @GwtIncompatible("java.util.BitSet")
        public void setBits(BitSet bitSet) {
            this.first.setBits(bitSet);
            this.second.setBits(bitSet);
        }

        public boolean matches(char c) {
            return this.first.matches(c) || this.second.matches(c);
        }

        /* access modifiers changed from: 0000 */
        public CharMatcher withToString(String str) {
            return new C2295Or(this.first, this.second, str);
        }
    }

    private static class RangesMatcher extends CharMatcher {
        private final char[] rangeEnds;
        private final char[] rangeStarts;

        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return CharMatcher.super.apply((Character) obj);
        }

        RangesMatcher(String str, char[] cArr, char[] cArr2) {
            super(str);
            this.rangeStarts = cArr;
            this.rangeEnds = cArr2;
            Preconditions.checkArgument(cArr.length == cArr2.length);
            int i = 0;
            while (i < cArr.length) {
                Preconditions.checkArgument(cArr[i] <= cArr2[i]);
                int i2 = i + 1;
                if (i2 < cArr.length) {
                    Preconditions.checkArgument(cArr2[i] < cArr[i2]);
                }
                i = i2;
            }
        }

        public boolean matches(char c) {
            int binarySearch = Arrays.binarySearch(this.rangeStarts, c);
            boolean z = true;
            if (binarySearch >= 0) {
                return true;
            }
            int i = (~binarySearch) - 1;
            if (i < 0 || c > this.rangeEnds[i]) {
                z = false;
            }
            return z;
        }
    }

    @GwtIncompatible("SmallCharMatcher")
    private static boolean isSmall(int i, int i2) {
        return i <= 1023 && i2 > (i * 4) * 16;
    }

    public abstract boolean matches(char c);

    static {
        StringBuilder sb = new StringBuilder(ZEROES.length());
        for (int i = 0; i < ZEROES.length(); i++) {
            sb.append((char) (ZEROES.charAt(i) + 9));
        }
        NINES = sb.toString();
    }

    private static String showCharacter(char c) {
        String str = "0123456789ABCDEF";
        char[] cArr = {'\\', 'u', 0, 0, 0, 0};
        for (int i = 0; i < 4; i++) {
            cArr[5 - i] = str.charAt(c & 15);
            c = (char) (c >> 4);
        }
        return String.copyValueOf(cArr);
    }

    /* renamed from: is */
    public static CharMatcher m8607is(final char c) {
        StringBuilder sb = new StringBuilder();
        sb.append("CharMatcher.is('");
        sb.append(showCharacter(c));
        sb.append("')");
        return new FastMatcher(sb.toString()) {
            public boolean matches(char c) {
                return c == c;
            }

            public String replaceFrom(CharSequence charSequence, char c) {
                return charSequence.toString().replace(c, c);
            }

            public CharMatcher and(CharMatcher charMatcher) {
                return charMatcher.matches(c) ? this : NONE;
            }

            /* renamed from: or */
            public CharMatcher mo20898or(CharMatcher charMatcher) {
                return charMatcher.matches(c) ? charMatcher : super.mo20898or(charMatcher);
            }

            public CharMatcher negate() {
                return isNot(c);
            }

            /* access modifiers changed from: 0000 */
            @GwtIncompatible("java.util.BitSet")
            public void setBits(BitSet bitSet) {
                bitSet.set(c);
            }
        };
    }

    public static CharMatcher isNot(final char c) {
        StringBuilder sb = new StringBuilder();
        sb.append("CharMatcher.isNot('");
        sb.append(showCharacter(c));
        sb.append("')");
        return new FastMatcher(sb.toString()) {
            public boolean matches(char c) {
                return c != c;
            }

            public CharMatcher and(CharMatcher charMatcher) {
                return charMatcher.matches(c) ? super.and(charMatcher) : charMatcher;
            }

            /* renamed from: or */
            public CharMatcher mo20898or(CharMatcher charMatcher) {
                return charMatcher.matches(c) ? ANY : this;
            }

            /* access modifiers changed from: 0000 */
            @GwtIncompatible("java.util.BitSet")
            public void setBits(BitSet bitSet) {
                bitSet.set(0, c);
                bitSet.set(c + 1, CharMatcher.DISTINCT_CHARS);
            }

            public CharMatcher negate() {
                return m8607is(c);
            }
        };
    }

    public static CharMatcher anyOf(CharSequence charSequence) {
        switch (charSequence.length()) {
            case 0:
                return NONE;
            case 1:
                return m8607is(charSequence.charAt(0));
            case 2:
                return isEither(charSequence.charAt(0), charSequence.charAt(1));
            default:
                final char[] charArray = charSequence.toString().toCharArray();
                Arrays.sort(charArray);
                StringBuilder sb = new StringBuilder("CharMatcher.anyOf(\"");
                for (char showCharacter : charArray) {
                    sb.append(showCharacter(showCharacter));
                }
                sb.append("\")");
                return new CharMatcher(sb.toString()) {
                    public /* bridge */ /* synthetic */ boolean apply(Object obj) {
                        return CharMatcher.super.apply((Character) obj);
                    }

                    public boolean matches(char c) {
                        return Arrays.binarySearch(charArray, c) >= 0;
                    }

                    /* access modifiers changed from: 0000 */
                    @GwtIncompatible("java.util.BitSet")
                    public void setBits(BitSet bitSet) {
                        for (char c : charArray) {
                            bitSet.set(c);
                        }
                    }
                };
        }
    }

    private static CharMatcher isEither(final char c, final char c2) {
        StringBuilder sb = new StringBuilder();
        sb.append("CharMatcher.anyOf(\"");
        sb.append(showCharacter(c));
        sb.append(showCharacter(c2));
        sb.append("\")");
        return new FastMatcher(sb.toString()) {
            public boolean matches(char c) {
                return c == c || c == c2;
            }

            /* access modifiers changed from: 0000 */
            @GwtIncompatible("java.util.BitSet")
            public void setBits(BitSet bitSet) {
                bitSet.set(c);
                bitSet.set(c2);
            }
        };
    }

    public static CharMatcher noneOf(CharSequence charSequence) {
        return anyOf(charSequence).negate();
    }

    public static CharMatcher inRange(char c, char c2) {
        Preconditions.checkArgument(c2 >= c);
        StringBuilder sb = new StringBuilder();
        sb.append("CharMatcher.inRange('");
        sb.append(showCharacter(c));
        sb.append("', '");
        sb.append(showCharacter(c2));
        sb.append("')");
        return inRange(c, c2, sb.toString());
    }

    static CharMatcher inRange(final char c, final char c2, String str) {
        return new FastMatcher(str) {
            public boolean matches(char c) {
                return c <= c && c <= c2;
            }

            /* access modifiers changed from: 0000 */
            @GwtIncompatible("java.util.BitSet")
            public void setBits(BitSet bitSet) {
                bitSet.set(c, c2 + 1);
            }
        };
    }

    public static CharMatcher forPredicate(final Predicate<? super Character> predicate) {
        Preconditions.checkNotNull(predicate);
        if (predicate instanceof CharMatcher) {
            return (CharMatcher) predicate;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("CharMatcher.forPredicate(");
        sb.append(predicate);
        sb.append(")");
        return new CharMatcher(sb.toString()) {
            public boolean matches(char c) {
                return predicate.apply(Character.valueOf(c));
            }

            public boolean apply(Character ch) {
                return predicate.apply(Preconditions.checkNotNull(ch));
            }
        };
    }

    CharMatcher(String str) {
        this.description = str;
    }

    protected CharMatcher() {
        this.description = super.toString();
    }

    public CharMatcher negate() {
        return new NegatedMatcher(this);
    }

    public CharMatcher and(CharMatcher charMatcher) {
        return new And(this, (CharMatcher) Preconditions.checkNotNull(charMatcher));
    }

    /* renamed from: or */
    public CharMatcher mo20898or(CharMatcher charMatcher) {
        return new C2295Or(this, (CharMatcher) Preconditions.checkNotNull(charMatcher));
    }

    public CharMatcher precomputed() {
        return Platform.precomputeCharMatcher(this);
    }

    /* access modifiers changed from: 0000 */
    public CharMatcher withToString(String str) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: 0000 */
    @GwtIncompatible("java.util.BitSet")
    public CharMatcher precomputedInternal() {
        String str;
        BitSet bitSet = new BitSet();
        setBits(bitSet);
        int cardinality = bitSet.cardinality();
        if (cardinality * 2 <= DISTINCT_CHARS) {
            return precomputedPositive(cardinality, bitSet, this.description);
        }
        bitSet.flip(0, DISTINCT_CHARS);
        int i = DISTINCT_CHARS - cardinality;
        String str2 = ".negate()";
        if (this.description.endsWith(str2)) {
            str = this.description.substring(0, this.description.length() - str2.length());
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(this.description);
            sb.append(str2);
            str = sb.toString();
        }
        return new NegatedFastMatcher(toString(), precomputedPositive(i, bitSet, str));
    }

    @GwtIncompatible("java.util.BitSet")
    private static CharMatcher precomputedPositive(int i, BitSet bitSet, String str) {
        switch (i) {
            case 0:
                return NONE;
            case 1:
                return m8607is((char) bitSet.nextSetBit(0));
            case 2:
                char nextSetBit = (char) bitSet.nextSetBit(0);
                return isEither(nextSetBit, (char) bitSet.nextSetBit(nextSetBit + 1));
            default:
                return isSmall(i, bitSet.length()) ? SmallCharMatcher.from(bitSet, str) : new BitSetMatcher(bitSet, str);
        }
    }

    /* access modifiers changed from: 0000 */
    @GwtIncompatible("java.util.BitSet")
    public void setBits(BitSet bitSet) {
        for (int i = 65535; i >= 0; i--) {
            if (matches((char) i)) {
                bitSet.set(i);
            }
        }
    }

    public boolean matchesAnyOf(CharSequence charSequence) {
        return !matchesNoneOf(charSequence);
    }

    public boolean matchesAllOf(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!matches(charSequence.charAt(length))) {
                return false;
            }
        }
        return true;
    }

    public boolean matchesNoneOf(CharSequence charSequence) {
        return indexIn(charSequence) == -1;
    }

    public int indexIn(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (matches(charSequence.charAt(i))) {
                return i;
            }
        }
        return -1;
    }

    public int indexIn(CharSequence charSequence, int i) {
        int length = charSequence.length();
        Preconditions.checkPositionIndex(i, length);
        while (i < length) {
            if (matches(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public int lastIndexIn(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (matches(charSequence.charAt(length))) {
                return length;
            }
        }
        return -1;
    }

    public int countIn(CharSequence charSequence) {
        int i = 0;
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            if (matches(charSequence.charAt(i2))) {
                i++;
            }
        }
        return i;
    }

    public String removeFrom(CharSequence charSequence) {
        String charSequence2 = charSequence.toString();
        int indexIn = indexIn(charSequence2);
        if (indexIn == -1) {
            return charSequence2;
        }
        char[] charArray = charSequence2.toCharArray();
        int i = 1;
        while (true) {
            indexIn++;
            while (indexIn != charArray.length) {
                if (matches(charArray[indexIn])) {
                    i++;
                } else {
                    charArray[indexIn - i] = charArray[indexIn];
                    indexIn++;
                }
            }
            return new String(charArray, 0, indexIn - i);
        }
    }

    public String retainFrom(CharSequence charSequence) {
        return negate().removeFrom(charSequence);
    }

    public String replaceFrom(CharSequence charSequence, char c) {
        String charSequence2 = charSequence.toString();
        int indexIn = indexIn(charSequence2);
        if (indexIn == -1) {
            return charSequence2;
        }
        char[] charArray = charSequence2.toCharArray();
        charArray[indexIn] = c;
        while (true) {
            indexIn++;
            if (indexIn >= charArray.length) {
                return new String(charArray);
            }
            if (matches(charArray[indexIn])) {
                charArray[indexIn] = c;
            }
        }
    }

    public String replaceFrom(CharSequence charSequence, CharSequence charSequence2) {
        int length = charSequence2.length();
        if (length == 0) {
            return removeFrom(charSequence);
        }
        int i = 0;
        if (length == 1) {
            return replaceFrom(charSequence, charSequence2.charAt(0));
        }
        String charSequence3 = charSequence.toString();
        int indexIn = indexIn(charSequence3);
        if (indexIn == -1) {
            return charSequence3;
        }
        int length2 = charSequence3.length();
        StringBuilder sb = new StringBuilder(((length2 * 3) / 2) + 16);
        do {
            sb.append(charSequence3, i, indexIn);
            sb.append(charSequence2);
            i = indexIn + 1;
            indexIn = indexIn(charSequence3, i);
        } while (indexIn != -1);
        sb.append(charSequence3, i, length2);
        return sb.toString();
    }

    public String trimFrom(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && matches(charSequence.charAt(i))) {
            i++;
        }
        int i2 = length - 1;
        while (i2 > i && matches(charSequence.charAt(i2))) {
            i2--;
        }
        return charSequence.subSequence(i, i2 + 1).toString();
    }

    public String trimLeadingFrom(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!matches(charSequence.charAt(i))) {
                return charSequence.subSequence(i, length).toString();
            }
        }
        return "";
    }

    public String trimTrailingFrom(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!matches(charSequence.charAt(length))) {
                return charSequence.subSequence(0, length + 1).toString();
            }
        }
        return "";
    }

    public String collapseFrom(CharSequence charSequence, char c) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (matches(charAt)) {
                if (charAt != c || (i != length - 1 && matches(charSequence.charAt(i + 1)))) {
                    StringBuilder sb = new StringBuilder(length);
                    sb.append(charSequence.subSequence(0, i));
                    sb.append(c);
                    return finishCollapseFrom(charSequence, i + 1, length, c, sb, true);
                }
                i++;
            }
            i++;
        }
        return charSequence.toString();
    }

    public String trimAndCollapseFrom(CharSequence charSequence, char c) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && matches(charSequence.charAt(i))) {
            i++;
        }
        int i2 = length - 1;
        int i3 = i2;
        while (i3 > i && matches(charSequence.charAt(i3))) {
            i3--;
        }
        if (i == 0 && i3 == i2) {
            return collapseFrom(charSequence, c);
        }
        int i4 = i3 + 1;
        return finishCollapseFrom(charSequence, i, i4, c, new StringBuilder(i4 - i), false);
    }

    private String finishCollapseFrom(CharSequence charSequence, int i, int i2, char c, StringBuilder sb, boolean z) {
        while (i < i2) {
            char charAt = charSequence.charAt(i);
            if (!matches(charAt)) {
                sb.append(charAt);
                z = false;
            } else if (!z) {
                sb.append(c);
                z = true;
            }
            i++;
        }
        return sb.toString();
    }

    @Deprecated
    public boolean apply(Character ch) {
        return matches(ch.charValue());
    }

    public String toString() {
        return this.description;
    }
}
