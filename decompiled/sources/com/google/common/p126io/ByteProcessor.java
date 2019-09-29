package com.google.common.p126io;

import com.google.common.annotations.Beta;
import java.io.IOException;

@Beta
/* renamed from: com.google.common.io.ByteProcessor */
public interface ByteProcessor<T> {
    T getResult();

    boolean processBytes(byte[] bArr, int i, int i2) throws IOException;
}
