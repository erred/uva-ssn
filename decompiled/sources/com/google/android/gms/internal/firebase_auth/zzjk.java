package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public enum zzjk {
    INT(Integer.valueOf(0)),
    LONG(Long.valueOf(0)),
    FLOAT(Float.valueOf(BitmapDescriptorFactory.HUE_RED)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(Boolean.valueOf(false)),
    STRING(""),
    BYTE_STRING(zzeh.zzso),
    ENUM(null),
    MESSAGE(null);
    
    private final Object zzyk;

    private zzjk(Object obj) {
        this.zzyk = obj;
    }
}
