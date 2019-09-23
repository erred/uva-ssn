package com.fasterxml.jackson.core.p116io;

import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.TextBuffer;
import java.lang.ref.SoftReference;

/* renamed from: com.fasterxml.jackson.core.io.JsonStringEncoder */
public final class JsonStringEncoder {

    /* renamed from: HB */
    private static final byte[] f6137HB = CharTypes.copyHexBytes();

    /* renamed from: HC */
    private static final char[] f6138HC = CharTypes.copyHexChars();
    private static final int SURR1_FIRST = 55296;
    private static final int SURR1_LAST = 56319;
    private static final int SURR2_FIRST = 56320;
    private static final int SURR2_LAST = 57343;
    protected static final ThreadLocal<SoftReference<JsonStringEncoder>> _threadEncoder = new ThreadLocal<>();
    protected ByteArrayBuilder _bytes;
    protected final char[] _qbuf = new char[6];
    protected TextBuffer _text;

    public JsonStringEncoder() {
        this._qbuf[0] = '\\';
        this._qbuf[2] = '0';
        this._qbuf[3] = '0';
    }

    public static JsonStringEncoder getInstance() {
        JsonStringEncoder jsonStringEncoder;
        SoftReference softReference = (SoftReference) _threadEncoder.get();
        if (softReference == null) {
            jsonStringEncoder = null;
        } else {
            jsonStringEncoder = (JsonStringEncoder) softReference.get();
        }
        if (jsonStringEncoder != null) {
            return jsonStringEncoder;
        }
        JsonStringEncoder jsonStringEncoder2 = new JsonStringEncoder();
        _threadEncoder.set(new SoftReference(jsonStringEncoder2));
        return jsonStringEncoder2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0031, code lost:
        if (r9 >= 0) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0033, code lost:
        r1 = _appendNumeric(r1, r11._qbuf);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003a, code lost:
        r1 = _appendNamed(r9, r11._qbuf);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0040, code lost:
        r9 = r6 + r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0043, code lost:
        if (r9 <= r7.length) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0045, code lost:
        r9 = r7.length - r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0047, code lost:
        if (r9 <= 0) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0049, code lost:
        java.lang.System.arraycopy(r11._qbuf, 0, r7, r6, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004e, code lost:
        r6 = r0.finishCurrentSegment();
        r1 = r1 - r9;
        java.lang.System.arraycopy(r11._qbuf, r9, r6, 0, r1);
        r7 = r6;
        r6 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005b, code lost:
        java.lang.System.arraycopy(r11._qbuf, 0, r7, r6, r1);
        r6 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0029, code lost:
        r8 = r1 + 1;
        r1 = r12.charAt(r1);
        r9 = r2[r1];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public char[] quoteAsString(java.lang.String r12) {
        /*
            r11 = this;
            com.fasterxml.jackson.core.util.TextBuffer r0 = r11._text
            if (r0 != 0) goto L_0x000c
            com.fasterxml.jackson.core.util.TextBuffer r0 = new com.fasterxml.jackson.core.util.TextBuffer
            r1 = 0
            r0.<init>(r1)
            r11._text = r0
        L_0x000c:
            char[] r1 = r0.emptyAndGetCurrentSegment()
            int[] r2 = com.fasterxml.jackson.core.p116io.CharTypes.get7BitOutputEscapes()
            int r3 = r2.length
            int r4 = r12.length()
            r5 = 0
            r7 = r1
            r1 = 0
            r6 = 0
        L_0x001d:
            if (r1 >= r4) goto L_0x0078
        L_0x001f:
            char r8 = r12.charAt(r1)
            if (r8 >= r3) goto L_0x0063
            r9 = r2[r8]
            if (r9 == 0) goto L_0x0063
            int r8 = r1 + 1
            char r1 = r12.charAt(r1)
            r9 = r2[r1]
            if (r9 >= 0) goto L_0x003a
            char[] r9 = r11._qbuf
            int r1 = r11._appendNumeric(r1, r9)
            goto L_0x0040
        L_0x003a:
            char[] r1 = r11._qbuf
            int r1 = r11._appendNamed(r9, r1)
        L_0x0040:
            int r9 = r6 + r1
            int r10 = r7.length
            if (r9 <= r10) goto L_0x005b
            int r9 = r7.length
            int r9 = r9 - r6
            if (r9 <= 0) goto L_0x004e
            char[] r10 = r11._qbuf
            java.lang.System.arraycopy(r10, r5, r7, r6, r9)
        L_0x004e:
            char[] r6 = r0.finishCurrentSegment()
            int r1 = r1 - r9
            char[] r7 = r11._qbuf
            java.lang.System.arraycopy(r7, r9, r6, r5, r1)
            r7 = r6
            r6 = r1
            goto L_0x0061
        L_0x005b:
            char[] r10 = r11._qbuf
            java.lang.System.arraycopy(r10, r5, r7, r6, r1)
            r6 = r9
        L_0x0061:
            r1 = r8
            goto L_0x001d
        L_0x0063:
            int r9 = r7.length
            if (r6 < r9) goto L_0x006c
            char[] r6 = r0.finishCurrentSegment()
            r7 = r6
            r6 = 0
        L_0x006c:
            int r9 = r6 + 1
            r7[r6] = r8
            int r1 = r1 + 1
            if (r1 < r4) goto L_0x0076
            r6 = r9
            goto L_0x0078
        L_0x0076:
            r6 = r9
            goto L_0x001f
        L_0x0078:
            r0.setCurrentLength(r6)
            char[] r12 = r0.contentsAsArray()
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.p116io.JsonStringEncoder.quoteAsString(java.lang.String):char[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
        r9.append(r7._qbuf, 0, r4);
        r4 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0017, code lost:
        r5 = r4 + 1;
        r4 = r8.charAt(r4);
        r6 = r0[r4];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001f, code lost:
        if (r6 >= 0) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0021, code lost:
        r4 = _appendNumeric(r4, r7._qbuf);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0028, code lost:
        r4 = _appendNamed(r6, r7._qbuf);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void quoteAsString(java.lang.CharSequence r8, java.lang.StringBuilder r9) {
        /*
            r7 = this;
            int[] r0 = com.fasterxml.jackson.core.p116io.CharTypes.get7BitOutputEscapes()
            int r1 = r0.length
            int r2 = r8.length()
            r3 = 0
            r4 = 0
        L_0x000b:
            if (r4 >= r2) goto L_0x003c
        L_0x000d:
            char r5 = r8.charAt(r4)
            if (r5 >= r1) goto L_0x0035
            r6 = r0[r5]
            if (r6 == 0) goto L_0x0035
            int r5 = r4 + 1
            char r4 = r8.charAt(r4)
            r6 = r0[r4]
            if (r6 >= 0) goto L_0x0028
            char[] r6 = r7._qbuf
            int r4 = r7._appendNumeric(r4, r6)
            goto L_0x002e
        L_0x0028:
            char[] r4 = r7._qbuf
            int r4 = r7._appendNamed(r6, r4)
        L_0x002e:
            char[] r6 = r7._qbuf
            r9.append(r6, r3, r4)
            r4 = r5
            goto L_0x000b
        L_0x0035:
            r9.append(r5)
            int r4 = r4 + 1
            if (r4 < r2) goto L_0x000d
        L_0x003c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.p116io.JsonStringEncoder.quoteAsString(java.lang.CharSequence, java.lang.StringBuilder):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0043, code lost:
        if (r4 < r5.length) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0045, code lost:
        r5 = r0.finishCurrentSegment();
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004a, code lost:
        r7 = r2 + 1;
        r2 = r11.charAt(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0050, code lost:
        if (r2 > 127) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0052, code lost:
        r4 = _appendByte(r2, r6[r2], r0, r4);
        r5 = r0.getCurrentSegment();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0060, code lost:
        if (r2 > 2047) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0062, code lost:
        r6 = r4 + 1;
        r5[r4] = (byte) ((r2 >> 6) | 192);
        r2 = (r2 & '?') | 128;
        r4 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0075, code lost:
        if (r2 < 55296) goto L_0x00d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007a, code lost:
        if (r2 <= 57343) goto L_0x007d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0080, code lost:
        if (r2 <= 56319) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0082, code lost:
        _illegal(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0085, code lost:
        if (r7 < r1) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0087, code lost:
        _illegal(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x008a, code lost:
        r6 = r7 + 1;
        r2 = _convert(r2, r11.charAt(r7));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0097, code lost:
        if (r2 <= 1114111) goto L_0x009c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0099, code lost:
        _illegal(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x009c, code lost:
        r7 = r4 + 1;
        r5[r4] = (byte) ((r2 >> 18) | 240);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a6, code lost:
        if (r7 < r5.length) goto L_0x00ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00a8, code lost:
        r5 = r0.finishCurrentSegment();
        r7 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00ad, code lost:
        r4 = r7 + 1;
        r5[r7] = (byte) (((r2 >> 12) & 63) | 128);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00b9, code lost:
        if (r4 < r5.length) goto L_0x00c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00bb, code lost:
        r5 = r0.finishCurrentSegment();
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00c1, code lost:
        r7 = r4 + 1;
        r5[r4] = (byte) (((r2 >> 6) & 63) | 128);
        r2 = (r2 & '?') | 128;
        r4 = r7;
        r7 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00d3, code lost:
        r6 = r4 + 1;
        r5[r4] = (byte) ((r2 >> 12) | 224);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00dd, code lost:
        if (r6 < r5.length) goto L_0x00e4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00df, code lost:
        r5 = r0.finishCurrentSegment();
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00e4, code lost:
        r4 = r6 + 1;
        r5[r6] = (byte) (((r2 >> 6) & 63) | 128);
        r2 = (r2 & '?') | 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00f4, code lost:
        if (r4 < r5.length) goto L_0x00fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00f6, code lost:
        r5 = r0.finishCurrentSegment();
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00fc, code lost:
        r6 = r4 + 1;
        r5[r4] = (byte) r2;
        r4 = r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] quoteAsUTF8(java.lang.String r11) {
        /*
            r10 = this;
            com.fasterxml.jackson.core.util.ByteArrayBuilder r0 = r10._bytes
            if (r0 != 0) goto L_0x000c
            com.fasterxml.jackson.core.util.ByteArrayBuilder r0 = new com.fasterxml.jackson.core.util.ByteArrayBuilder
            r1 = 0
            r0.<init>(r1)
            r10._bytes = r0
        L_0x000c:
            int r1 = r11.length()
            byte[] r2 = r0.resetAndGetFirstSegment()
            r3 = 0
            r5 = r2
            r2 = 0
            r4 = 0
        L_0x0018:
            if (r2 >= r1) goto L_0x0104
            int[] r6 = com.fasterxml.jackson.core.p116io.CharTypes.get7BitOutputEscapes()
        L_0x001e:
            char r7 = r11.charAt(r2)
            r8 = 127(0x7f, float:1.78E-43)
            if (r7 > r8) goto L_0x0042
            r9 = r6[r7]
            if (r9 == 0) goto L_0x002b
            goto L_0x0042
        L_0x002b:
            int r8 = r5.length
            if (r4 < r8) goto L_0x0034
            byte[] r4 = r0.finishCurrentSegment()
            r5 = r4
            r4 = 0
        L_0x0034:
            int r8 = r4 + 1
            byte r7 = (byte) r7
            r5[r4] = r7
            int r2 = r2 + 1
            if (r2 < r1) goto L_0x0040
            r4 = r8
            goto L_0x0104
        L_0x0040:
            r4 = r8
            goto L_0x001e
        L_0x0042:
            int r7 = r5.length
            if (r4 < r7) goto L_0x004a
            byte[] r5 = r0.finishCurrentSegment()
            r4 = 0
        L_0x004a:
            int r7 = r2 + 1
            char r2 = r11.charAt(r2)
            if (r2 > r8) goto L_0x005e
            r5 = r6[r2]
            int r4 = r10._appendByte(r2, r5, r0, r4)
            byte[] r5 = r0.getCurrentSegment()
        L_0x005c:
            r2 = r7
            goto L_0x0018
        L_0x005e:
            r6 = 2047(0x7ff, float:2.868E-42)
            if (r2 > r6) goto L_0x0072
            int r6 = r4 + 1
            int r8 = r2 >> 6
            r8 = r8 | 192(0xc0, float:2.69E-43)
            byte r8 = (byte) r8
            r5[r4] = r8
            r2 = r2 & 63
            r2 = r2 | 128(0x80, float:1.794E-43)
            r4 = r6
            goto L_0x00f3
        L_0x0072:
            r6 = 55296(0xd800, float:7.7486E-41)
            if (r2 < r6) goto L_0x00d3
            r6 = 57343(0xdfff, float:8.0355E-41)
            if (r2 <= r6) goto L_0x007d
            goto L_0x00d3
        L_0x007d:
            r6 = 56319(0xdbff, float:7.892E-41)
            if (r2 <= r6) goto L_0x0085
            _illegal(r2)
        L_0x0085:
            if (r7 < r1) goto L_0x008a
            _illegal(r2)
        L_0x008a:
            int r6 = r7 + 1
            char r7 = r11.charAt(r7)
            int r2 = _convert(r2, r7)
            r7 = 1114111(0x10ffff, float:1.561202E-39)
            if (r2 <= r7) goto L_0x009c
            _illegal(r2)
        L_0x009c:
            int r7 = r4 + 1
            int r8 = r2 >> 18
            r8 = r8 | 240(0xf0, float:3.36E-43)
            byte r8 = (byte) r8
            r5[r4] = r8
            int r4 = r5.length
            if (r7 < r4) goto L_0x00ad
            byte[] r5 = r0.finishCurrentSegment()
            r7 = 0
        L_0x00ad:
            int r4 = r7 + 1
            int r8 = r2 >> 12
            r8 = r8 & 63
            r8 = r8 | 128(0x80, float:1.794E-43)
            byte r8 = (byte) r8
            r5[r7] = r8
            int r7 = r5.length
            if (r4 < r7) goto L_0x00c1
            byte[] r4 = r0.finishCurrentSegment()
            r5 = r4
            r4 = 0
        L_0x00c1:
            int r7 = r4 + 1
            int r8 = r2 >> 6
            r8 = r8 & 63
            r8 = r8 | 128(0x80, float:1.794E-43)
            byte r8 = (byte) r8
            r5[r4] = r8
            r2 = r2 & 63
            r2 = r2 | 128(0x80, float:1.794E-43)
            r4 = r7
            r7 = r6
            goto L_0x00f3
        L_0x00d3:
            int r6 = r4 + 1
            int r8 = r2 >> 12
            r8 = r8 | 224(0xe0, float:3.14E-43)
            byte r8 = (byte) r8
            r5[r4] = r8
            int r4 = r5.length
            if (r6 < r4) goto L_0x00e4
            byte[] r5 = r0.finishCurrentSegment()
            r6 = 0
        L_0x00e4:
            int r4 = r6 + 1
            int r8 = r2 >> 6
            r8 = r8 & 63
            r8 = r8 | 128(0x80, float:1.794E-43)
            byte r8 = (byte) r8
            r5[r6] = r8
            r2 = r2 & 63
            r2 = r2 | 128(0x80, float:1.794E-43)
        L_0x00f3:
            int r6 = r5.length
            if (r4 < r6) goto L_0x00fc
            byte[] r4 = r0.finishCurrentSegment()
            r5 = r4
            r4 = 0
        L_0x00fc:
            int r6 = r4 + 1
            byte r2 = (byte) r2
            r5[r4] = r2
            r4 = r6
            goto L_0x005c
        L_0x0104:
            com.fasterxml.jackson.core.util.ByteArrayBuilder r11 = r10._bytes
            byte[] r11 = r11.completeAndCoalesce(r4)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.p116io.JsonStringEncoder.quoteAsUTF8(java.lang.String):byte[]");
    }

    public byte[] encodeAsUTF8(String str) {
        int i;
        ByteArrayBuilder byteArrayBuilder = this._bytes;
        if (byteArrayBuilder == null) {
            byteArrayBuilder = new ByteArrayBuilder((BufferRecycler) null);
            this._bytes = byteArrayBuilder;
        }
        int length = str.length();
        byte[] resetAndGetFirstSegment = byteArrayBuilder.resetAndGetFirstSegment();
        byte[] bArr = resetAndGetFirstSegment;
        int length2 = resetAndGetFirstSegment.length;
        int i2 = 0;
        int i3 = 0;
        loop0:
        while (true) {
            if (i2 >= length) {
                break;
            }
            int i4 = i2 + 1;
            int charAt = str.charAt(i2);
            while (charAt <= 127) {
                if (i3 >= length2) {
                    byte[] finishCurrentSegment = byteArrayBuilder.finishCurrentSegment();
                    length2 = finishCurrentSegment.length;
                    bArr = finishCurrentSegment;
                    i3 = 0;
                }
                int i5 = i3 + 1;
                bArr[i3] = (byte) charAt;
                if (i4 >= length) {
                    i3 = i5;
                    break loop0;
                }
                int i6 = i4 + 1;
                int charAt2 = str.charAt(i4);
                i4 = i6;
                charAt = charAt2;
                i3 = i5;
            }
            if (i3 >= length2) {
                bArr = byteArrayBuilder.finishCurrentSegment();
                length2 = bArr.length;
                i3 = 0;
            }
            if (charAt < 2048) {
                int i7 = i3 + 1;
                bArr[i3] = (byte) ((charAt >> 6) | 192);
                i = i7;
            } else if (charAt < 55296 || charAt > 57343) {
                int i8 = i3 + 1;
                bArr[i3] = (byte) ((charAt >> 12) | 224);
                if (i8 >= length2) {
                    bArr = byteArrayBuilder.finishCurrentSegment();
                    length2 = bArr.length;
                    i8 = 0;
                }
                i = i8 + 1;
                bArr[i8] = (byte) (((charAt >> 6) & 63) | 128);
            } else {
                if (charAt > 56319) {
                    _illegal(charAt);
                }
                if (i4 >= length) {
                    _illegal(charAt);
                }
                int i9 = i4 + 1;
                charAt = _convert(charAt, str.charAt(i4));
                if (charAt > 1114111) {
                    _illegal(charAt);
                }
                int i10 = i3 + 1;
                bArr[i3] = (byte) ((charAt >> 18) | 240);
                if (i10 >= length2) {
                    bArr = byteArrayBuilder.finishCurrentSegment();
                    length2 = bArr.length;
                    i10 = 0;
                }
                int i11 = i10 + 1;
                bArr[i10] = (byte) (((charAt >> 12) & 63) | 128);
                if (i11 >= length2) {
                    byte[] finishCurrentSegment2 = byteArrayBuilder.finishCurrentSegment();
                    length2 = finishCurrentSegment2.length;
                    bArr = finishCurrentSegment2;
                    i11 = 0;
                }
                int i12 = i11 + 1;
                bArr[i11] = (byte) (((charAt >> 6) & 63) | 128);
                i = i12;
                i4 = i9;
            }
            if (i >= length2) {
                byte[] finishCurrentSegment3 = byteArrayBuilder.finishCurrentSegment();
                length2 = finishCurrentSegment3.length;
                bArr = finishCurrentSegment3;
                i = 0;
            }
            int i13 = i + 1;
            bArr[i] = (byte) ((charAt & 63) | 128);
            i2 = i4;
            i3 = i13;
        }
        return this._bytes.completeAndCoalesce(i3);
    }

    private int _appendNumeric(int i, char[] cArr) {
        cArr[1] = 'u';
        cArr[4] = f6138HC[i >> 4];
        cArr[5] = f6138HC[i & 15];
        return 6;
    }

    private int _appendNamed(int i, char[] cArr) {
        cArr[1] = (char) i;
        return 2;
    }

    private int _appendByte(int i, int i2, ByteArrayBuilder byteArrayBuilder, int i3) {
        byteArrayBuilder.setCurrentSegmentLength(i3);
        byteArrayBuilder.append(92);
        if (i2 < 0) {
            byteArrayBuilder.append(117);
            if (i > 255) {
                int i4 = i >> 8;
                byteArrayBuilder.append(f6137HB[i4 >> 4]);
                byteArrayBuilder.append(f6137HB[i4 & 15]);
                i &= 255;
            } else {
                byteArrayBuilder.append(48);
                byteArrayBuilder.append(48);
            }
            byteArrayBuilder.append(f6137HB[i >> 4]);
            byteArrayBuilder.append(f6137HB[i & 15]);
        } else {
            byteArrayBuilder.append((byte) i2);
        }
        return byteArrayBuilder.getCurrentSegmentLength();
    }

    private static int _convert(int i, int i2) {
        if (i2 >= 56320 && i2 <= 57343) {
            return ((i - 55296) << 10) + 65536 + (i2 - 56320);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Broken surrogate pair: first char 0x");
        sb.append(Integer.toHexString(i));
        sb.append(", second 0x");
        sb.append(Integer.toHexString(i2));
        sb.append("; illegal combination");
        throw new IllegalArgumentException(sb.toString());
    }

    private static void _illegal(int i) {
        throw new IllegalArgumentException(UTF8Writer.illegalSurrogateDesc(i));
    }
}
