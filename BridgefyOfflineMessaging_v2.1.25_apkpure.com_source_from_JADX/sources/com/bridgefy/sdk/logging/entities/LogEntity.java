package com.bridgefy.sdk.logging.entities;

import com.bridgefy.sdk.client.Config.Antenna;

public abstract class LogEntity {
    public static final LogType[] logTypeOrdinalValues = LogType.values();

    /* renamed from: c */
    int f6102c;

    /* renamed from: d */
    int f6103d;

    /* renamed from: e */
    int f6104e;

    /* renamed from: f */
    long f6105f = System.currentTimeMillis();

    /* renamed from: g */
    String f6106g;

    /* renamed from: h */
    String f6107h;

    /* renamed from: i */
    String f6108i;

    public enum LogLevel {
        VERBOSE,
        DEBUG,
        INFO,
        WARN,
        ERROR
    }

    public enum LogType {
        TRANSMITTER,
        TRANSMITTER_ERROR,
        OPERATOR_STATUS,
        OPERATOR_STATUS_ERROR,
        COMMUNICATION,
        COMMUNICATION_ERROR,
        MESSAGE,
        MESSAGE_ERROR,
        MESH,
        MESH_ERROR
    }

    public abstract String getMessage();

    public abstract String serialize();

    public LogEntity(LogType logType, int i, long j, Antenna antenna) {
        this.f6102c = logType.ordinal();
        this.f6104e = antenna.ordinal();
        this.f6103d = i;
        StringBuilder sb = new StringBuilder();
        sb.append(j);
        sb.append("");
        this.f6106g = sb.toString();
        this.f6107h = getMessage();
    }

    public LogEntity(LogType logType, int i) {
        this.f6102c = logType.ordinal();
        this.f6104e = Antenna.UNREACHABLE.ordinal();
        this.f6103d = i;
        this.f6107h = getMessage();
    }

    public LogEntity(LogType logType, int i, Antenna antenna) {
        this.f6102c = logType.ordinal();
        this.f6104e = antenna.ordinal();
        this.f6103d = i;
        this.f6107h = getMessage();
    }

    public int getLogType() {
        return this.f6102c;
    }

    public void setMessage(String str) {
        this.f6107h = str;
    }
}
