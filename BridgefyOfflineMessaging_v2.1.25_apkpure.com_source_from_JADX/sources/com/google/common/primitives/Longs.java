package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;

@GwtCompatible
public final class Longs {
    public static final int BYTES = 8;
    public static final long MAX_POWER_OF_TWO = 4611686018427387904L;

    private enum LexicographicalComparator implements Comparator<long[]> {
        INSTANCE;

        public int compare(long[] jArr, long[] jArr2) {
            int min = Math.min(jArr.length, jArr2.length);
            for (int i = 0; i < min; i++) {
                int compare = Longs.compare(jArr[i], jArr2[i]);
                if (compare != 0) {
                    return compare;
                }
            }
            return jArr.length - jArr2.length;
        }
    }

    @GwtCompatible
    private static class LongArrayAsList extends AbstractList<Long> implements Serializable, RandomAccess {
        private static final long serialVersionUID = 0;
        final long[] array;
        final int end;
        final int start;

        public boolean isEmpty() {
            return false;
        }

        LongArrayAsList(long[] jArr) {
            this(jArr, 0, jArr.length);
        }

        LongArrayAsList(long[] jArr, int i, int i2) {
            this.array = jArr;
            this.start = i;
            this.end = i2;
        }

        public int size() {
            return this.end - this.start;
        }

        public Long get(int i) {
            Preconditions.checkElementIndex(i, size());
            return Long.valueOf(this.array[this.start + i]);
        }

        public boolean contains(Object obj) {
            return (obj instanceof Long) && Longs.indexOf(this.array, ((Long) obj).longValue(), this.start, this.end) != -1;
        }

        public int indexOf(Object obj) {
            if (obj instanceof Long) {
                int access$000 = Longs.indexOf(this.array, ((Long) obj).longValue(), this.start, this.end);
                if (access$000 >= 0) {
                    return access$000 - this.start;
                }
            }
            return -1;
        }

        public int lastIndexOf(Object obj) {
            if (obj instanceof Long) {
                int access$100 = Longs.lastIndexOf(this.array, ((Long) obj).longValue(), this.start, this.end);
                if (access$100 >= 0) {
                    return access$100 - this.start;
                }
            }
            return -1;
        }

        public Long set(int i, Long l) {
            Preconditions.checkElementIndex(i, size());
            long j = this.array[this.start + i];
            this.array[this.start + i] = ((Long) Preconditions.checkNotNull(l)).longValue();
            return Long.valueOf(j);
        }

        public List<Long> subList(int i, int i2) {
            Preconditions.checkPositionIndexes(i, i2, size());
            if (i == i2) {
                return Collections.emptyList();
            }
            return new LongArrayAsList(this.array, this.start + i, this.start + i2);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof LongArrayAsList)) {
                return super.equals(obj);
            }
            LongArrayAsList longArrayAsList = (LongArrayAsList) obj;
            int size = size();
            if (longArrayAsList.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (this.array[this.start + i] != longArrayAsList.array[longArrayAsList.start + i]) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int i = 1;
            for (int i2 = this.start; i2 < this.end; i2++) {
                i = (i * 31) + Longs.hashCode(this.array[i2]);
            }
            return i;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 10);
            sb.append('[');
            sb.append(this.array[this.start]);
            int i = this.start;
            while (true) {
                i++;
                if (i < this.end) {
                    sb.append(", ");
                    sb.append(this.array[i]);
                } else {
                    sb.append(']');
                    return sb.toString();
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public long[] toLongArray() {
            int size = size();
            long[] jArr = new long[size];
            System.arraycopy(this.array, this.start, jArr, 0, size);
            return jArr;
        }
    }

    private static final class LongConverter extends Converter<String, Long> implements Serializable {
        static final LongConverter INSTANCE = new LongConverter();
        private static final long serialVersionUID = 1;

        public String toString() {
            return "Longs.stringConverter()";
        }

        private LongConverter() {
        }

        /* access modifiers changed from: protected */
        public Long doForward(String str) {
            return Long.decode(str);
        }

        /* access modifiers changed from: protected */
        public String doBackward(Long l) {
            return l.toString();
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }

    public static int compare(long j, long j2) {
        int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        if (i < 0) {
            return -1;
        }
        return i > 0 ? 1 : 0;
    }

    public static long fromBytes(byte b, byte b2, byte b3, byte b4, byte b5, byte b6, byte b7, byte b8) {
        return ((((long) b2) & 255) << 48) | ((((long) b) & 255) << 56) | ((((long) b3) & 255) << 40) | ((((long) b4) & 255) << 32) | ((((long) b5) & 255) << 24) | ((((long) b6) & 255) << 16) | ((((long) b7) & 255) << 8) | (((long) b8) & 255);
    }

    public static int hashCode(long j) {
        return (int) (j ^ (j >>> 32));
    }

    private Longs() {
    }

    public static boolean contains(long[] jArr, long j) {
        int length = jArr.length;
        for (int i = 0; i < length; i++) {
            if (jArr[i] == j) {
                return true;
            }
        }
        return false;
    }

    public static int indexOf(long[] jArr, long j) {
        return indexOf(jArr, j, 0, jArr.length);
    }

    /* access modifiers changed from: private */
    public static int indexOf(long[] jArr, long j, int i, int i2) {
        while (i < i2) {
            if (jArr[i] == j) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int indexOf(long[] jArr, long[] jArr2) {
        Preconditions.checkNotNull(jArr, "array");
        Preconditions.checkNotNull(jArr2, "target");
        if (jArr2.length == 0) {
            return 0;
        }
        int i = 0;
        while (i < (jArr.length - jArr2.length) + 1) {
            int i2 = 0;
            while (i2 < jArr2.length) {
                if (jArr[i + i2] != jArr2[i2]) {
                    i++;
                } else {
                    i2++;
                }
            }
            return i;
        }
        return -1;
    }

    public static int lastIndexOf(long[] jArr, long j) {
        return lastIndexOf(jArr, j, 0, jArr.length);
    }

    /* access modifiers changed from: private */
    public static int lastIndexOf(long[] jArr, long j, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            if (jArr[i3] == j) {
                return i3;
            }
        }
        return -1;
    }

    public static long min(long... jArr) {
        Preconditions.checkArgument(jArr.length > 0);
        long j = jArr[0];
        for (int i = 1; i < jArr.length; i++) {
            if (jArr[i] < j) {
                j = jArr[i];
            }
        }
        return j;
    }

    public static long max(long... jArr) {
        Preconditions.checkArgument(jArr.length > 0);
        long j = jArr[0];
        for (int i = 1; i < jArr.length; i++) {
            if (jArr[i] > j) {
                j = jArr[i];
            }
        }
        return j;
    }

    public static long[] concat(long[]... jArr) {
        int i = 0;
        for (long[] length : jArr) {
            i += length.length;
        }
        long[] jArr2 = new long[i];
        int i2 = 0;
        for (long[] jArr3 : jArr) {
            System.arraycopy(jArr3, 0, jArr2, i2, jArr3.length);
            i2 += jArr3.length;
        }
        return jArr2;
    }

    public static byte[] toByteArray(long j) {
        byte[] bArr = new byte[8];
        for (int i = 7; i >= 0; i--) {
            bArr[i] = (byte) ((int) (255 & j));
            j >>= 8;
        }
        return bArr;
    }

    public static long fromByteArray(byte[] bArr) {
        Preconditions.checkArgument(bArr.length >= 8, "array too small: %s < %s", Integer.valueOf(bArr.length), Integer.valueOf(8));
        return fromBytes(bArr[0], bArr[1], bArr[2], bArr[3], bArr[4], bArr[5], bArr[6], bArr[7]);
    }

    @Beta
    public static Long tryParse(String str) {
        if (((String) Preconditions.checkNotNull(str)).length() == 0) {
            return null;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            i = 1;
        }
        if (i == str.length()) {
            return null;
        }
        int i2 = i + 1;
        int charAt = str.charAt(i) - '0';
        if (charAt < 0 || charAt > 9) {
            return null;
        }
        long j = (long) (-charAt);
        while (i2 < str.length()) {
            int i3 = i2 + 1;
            int charAt2 = str.charAt(i2) - '0';
            if (charAt2 < 0 || charAt2 > 9 || j < -922337203685477580L) {
                return null;
            }
            long j2 = j * 10;
            long j3 = (long) charAt2;
            if (j2 < Long.MIN_VALUE + j3) {
                return null;
            }
            j = j2 - j3;
            i2 = i3;
        }
        if (i != 0) {
            return Long.valueOf(j);
        }
        if (j == Long.MIN_VALUE) {
            return null;
        }
        return Long.valueOf(-j);
    }

    @Beta
    public static Converter<String, Long> stringConverter() {
        return LongConverter.INSTANCE;
    }

    public static long[] ensureCapacity(long[] jArr, int i, int i2) {
        Preconditions.checkArgument(i >= 0, "Invalid minLength: %s", Integer.valueOf(i));
        Preconditions.checkArgument(i2 >= 0, "Invalid padding: %s", Integer.valueOf(i2));
        return jArr.length < i ? copyOf(jArr, i + i2) : jArr;
    }

    private static long[] copyOf(long[] jArr, int i) {
        long[] jArr2 = new long[i];
        System.arraycopy(jArr, 0, jArr2, 0, Math.min(jArr.length, i));
        return jArr2;
    }

    public static String join(String str, long... jArr) {
        Preconditions.checkNotNull(str);
        if (jArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(jArr.length * 10);
        sb.append(jArr[0]);
        for (int i = 1; i < jArr.length; i++) {
            sb.append(str);
            sb.append(jArr[i]);
        }
        return sb.toString();
    }

    public static Comparator<long[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static long[] toArray(Collection<? extends Number> collection) {
        if (collection instanceof LongArrayAsList) {
            return ((LongArrayAsList) collection).toLongArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        long[] jArr = new long[length];
        for (int i = 0; i < length; i++) {
            jArr[i] = ((Number) Preconditions.checkNotNull(array[i])).longValue();
        }
        return jArr;
    }

    public static List<Long> asList(long... jArr) {
        if (jArr.length == 0) {
            return Collections.emptyList();
        }
        return new LongArrayAsList(jArr);
    }
}
