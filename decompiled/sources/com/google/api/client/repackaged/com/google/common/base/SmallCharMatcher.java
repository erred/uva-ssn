package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.GwtIncompatible;
import com.google.api.client.repackaged.com.google.common.annotations.VisibleForTesting;
import java.util.BitSet;

@GwtIncompatible("no precomputation is done in GWT")
final class SmallCharMatcher extends FastMatcher {

    /* renamed from: C1 */
    private static final int f6721C1 = -862048943;

    /* renamed from: C2 */
    private static final int f6722C2 = 461845907;
    private static final double DESIRED_LOAD_FACTOR = 0.5d;
    static final int MAX_SIZE = 1023;
    private final boolean containsZero;
    private final long filter;
    private final char[] table;

    private SmallCharMatcher(char[] cArr, long j, boolean z, String str) {
        super(str);
        this.table = cArr;
        this.filter = j;
        this.containsZero = z;
    }

    static int smear(int i) {
        return Integer.rotateLeft(i * f6721C1, 15) * f6722C2;
    }

    private boolean checkFilter(int i) {
        return 1 == ((this.filter >> i) & 1);
    }

    @VisibleForTesting
    static int chooseTableSize(int i) {
        if (i == 1) {
            return 2;
        }
        int highestOneBit = Integer.highestOneBit(i - 1) << 1;
        while (((double) highestOneBit) * 0.5d < ((double) i)) {
            highestOneBit <<= 1;
        }
        return highestOneBit;
    }

    static CharMatcher from(BitSet bitSet, String str) {
        int i;
        int cardinality = bitSet.cardinality();
        boolean z = bitSet.get(0);
        char[] cArr = new char[chooseTableSize(cardinality)];
        int length = cArr.length - 1;
        int nextSetBit = bitSet.nextSetBit(0);
        long j = 0;
        while (nextSetBit != -1) {
            long j2 = (1 << nextSetBit) | j;
            int smear = smear(nextSetBit);
            while (true) {
                i = smear & length;
                if (cArr[i] == 0) {
                    break;
                }
                smear = i + 1;
            }
            cArr[i] = (char) nextSetBit;
            nextSetBit = bitSet.nextSetBit(nextSetBit + 1);
            j = j2;
        }
        SmallCharMatcher smallCharMatcher = new SmallCharMatcher(cArr, j, z, str);
        return smallCharMatcher;
    }

    public boolean matches(char c) {
        if (c == 0) {
            return this.containsZero;
        }
        if (!checkFilter(c)) {
            return false;
        }
        int length = this.table.length - 1;
        int smear = smear(c) & length;
        int i = smear;
        while (this.table[i] != 0) {
            if (this.table[i] == c) {
                return true;
            }
            i = (i + 1) & length;
            if (i == smear) {
                return false;
            }
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    public void setBits(BitSet bitSet) {
        char[] cArr;
        if (this.containsZero) {
            bitSet.set(0);
        }
        for (char c : this.table) {
            if (c != 0) {
                bitSet.set(c);
            }
        }
    }
}