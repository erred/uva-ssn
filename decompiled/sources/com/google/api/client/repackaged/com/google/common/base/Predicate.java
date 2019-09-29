package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.GwtCompatible;

@GwtCompatible
public interface Predicate<T> {
    boolean apply(T t);

    boolean equals(Object obj);
}
