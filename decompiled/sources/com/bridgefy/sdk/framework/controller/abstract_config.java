package com.bridgefy.sdk.framework.controller;

/* renamed from: com.bridgefy.sdk.framework.controller.ah */
class abstract_config {
    /* renamed from: a */
    public static <T> T null_or_except(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    /* renamed from: a */
    public static <T> T null_or_except_msg(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }
}
