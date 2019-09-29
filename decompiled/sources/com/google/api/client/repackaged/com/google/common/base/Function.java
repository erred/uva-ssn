package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.GwtCompatible;

@GwtCompatible
public interface Function<F, T> {
    T apply(F f);

    boolean equals(Object obj);
}
