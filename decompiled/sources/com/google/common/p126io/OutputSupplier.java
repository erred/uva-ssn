package com.google.common.p126io;

import java.io.IOException;

@Deprecated
/* renamed from: com.google.common.io.OutputSupplier */
public interface OutputSupplier<T> {
    T getOutput() throws IOException;
}
