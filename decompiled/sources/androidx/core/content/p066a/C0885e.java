package androidx.core.content.p066a;

import java.lang.reflect.Array;

/* renamed from: androidx.core.content.a.e */
/* compiled from: GrowingArrayUtils */
final class C0885e {

    /* renamed from: a */
    static final /* synthetic */ boolean f2847a = (!C0885e.class.desiredAssertionStatus());

    /* renamed from: a */
    public static int m3289a(int i) {
        if (i <= 4) {
            return 8;
        }
        return i * 2;
    }

    /* renamed from: a */
    public static <T> T[] m3291a(T[] tArr, int i, T t) {
        if (f2847a || i <= tArr.length) {
            if (i + 1 > tArr.length) {
                T[] tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), m3289a(i));
                System.arraycopy(tArr, 0, tArr2, 0, i);
                tArr = tArr2;
            }
            tArr[i] = t;
            return tArr;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public static int[] m3290a(int[] iArr, int i, int i2) {
        if (f2847a || i <= iArr.length) {
            if (i + 1 > iArr.length) {
                int[] iArr2 = new int[m3289a(i)];
                System.arraycopy(iArr, 0, iArr2, 0, i);
                iArr = iArr2;
            }
            iArr[i] = i2;
            return iArr;
        }
        throw new AssertionError();
    }

    private C0885e() {
    }
}
