package com.google.common.p126io;

import java.io.IOException;

@Deprecated
/* renamed from: com.google.common.io.InputSupplier */
public interface InputSupplier<T> {
    T getInput() throws IOException;
}
