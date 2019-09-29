package com.bridgefy.sdk.framework.controller;

import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.HashMap;

public class Constants {
    public static final boolean DEBUG = false;
    public static final long KEEP_ALIVE_INTERVAL = 20000;
    public static final String LOGGING_EVENT_BROADCAST = "broadcast.logging.event";
    public static final String LOGGING_EVENT_ENTRY = "broadcast.logging.entry";
    public static final String LOGGING_EVENT_TYPE = "broadcast.logging.type";
    public static final Type TYPE = new TypeToken<HashMap<String, Object>>() {
    }.getType();
}
