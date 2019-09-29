package org.apache.commons.p156b;

/* renamed from: org.apache.commons.b.a */
/* compiled from: ArrayUtils */
public class C3689a {

    /* renamed from: a */
    public static final Object[] f9731a = new Object[0];

    /* renamed from: b */
    public static final Class<?>[] f9732b = new Class[0];

    /* renamed from: c */
    public static final String[] f9733c = new String[0];

    /* renamed from: d */
    public static final long[] f9734d = new long[0];

    /* renamed from: e */
    public static final Long[] f9735e = new Long[0];

    /* renamed from: f */
    public static final int[] f9736f = new int[0];

    /* renamed from: g */
    public static final Integer[] f9737g = new Integer[0];

    /* renamed from: h */
    public static final short[] f9738h = new short[0];

    /* renamed from: i */
    public static final Short[] f9739i = new Short[0];

    /* renamed from: j */
    public static final byte[] f9740j = new byte[0];

    /* renamed from: k */
    public static final Byte[] f9741k = new Byte[0];

    /* renamed from: l */
    public static final double[] f9742l = new double[0];

    /* renamed from: m */
    public static final Double[] f9743m = new Double[0];

    /* renamed from: n */
    public static final float[] f9744n = new float[0];

    /* renamed from: o */
    public static final Float[] f9745o = new Float[0];

    /* renamed from: p */
    public static final boolean[] f9746p = new boolean[0];

    /* renamed from: q */
    public static final Boolean[] f9747q = new Boolean[0];

    /* renamed from: r */
    public static final char[] f9748r = new char[0];

    /* renamed from: s */
    public static final Character[] f9749s = new Character[0];

    /* renamed from: a */
    public static byte[] m10974a(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            return null;
        }
        if (i < 0) {
            i = 0;
        }
        if (i2 > bArr.length) {
            i2 = bArr.length;
        }
        int i3 = i2 - i;
        if (i3 <= 0) {
            return f9740j;
        }
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i, bArr2, 0, i3);
        return bArr2;
    }
}
