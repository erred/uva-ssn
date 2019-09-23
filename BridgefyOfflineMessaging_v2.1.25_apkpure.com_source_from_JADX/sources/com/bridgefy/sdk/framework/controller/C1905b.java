package com.bridgefy.sdk.framework.controller;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* renamed from: com.bridgefy.sdk.framework.controller.b */
class C1905b {
    /* renamed from: a */
    static byte[] m7875a(ArrayList<byte[]> arrayList) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            byte[] bArr = (byte[]) it.next();
            int length = bArr.length;
            byteArrayOutputStream.write(22);
            byteArrayOutputStream.write((byte) ((length >> 24) & 255));
            byteArrayOutputStream.write((byte) ((length >> 16) & 255));
            byteArrayOutputStream.write((byte) ((length >> 8) & 255));
            byteArrayOutputStream.write((byte) (length & 255));
            try {
                byteArrayOutputStream.write(bArr);
            } catch (IOException unused) {
                return null;
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: a */
    static ArrayList<byte[]> m7874a(byte[] bArr) {
        ArrayList<byte[]> arrayList = new ArrayList<>();
        int i = 0;
        while (i < bArr.length) {
            int i2 = i + 1;
            if (bArr[i] == 22) {
                int i3 = i2 + 1;
                byte b = ((bArr[i2] & UnsignedBytes.MAX_VALUE) << Ascii.CAN) & Ascii.NUL;
                int i4 = i3 + 1;
                int i5 = i4 + 1;
                int i6 = i5 + 1;
                i = (((((((bArr[i3] & UnsignedBytes.MAX_VALUE) << Ascii.DLE) | b) & Ascii.NUL) | ((bArr[i4] & UnsignedBytes.MAX_VALUE) << 8)) & Ascii.NUL) | (bArr[i5] & UnsignedBytes.MAX_VALUE)) + i6;
                if (i > bArr.length || i < 0) {
                    return null;
                }
                arrayList.add(Arrays.copyOfRange(bArr, i6, i));
            } else if (!arrayList.isEmpty()) {
                return arrayList;
            } else {
                return null;
            }
        }
        return arrayList;
    }
}
