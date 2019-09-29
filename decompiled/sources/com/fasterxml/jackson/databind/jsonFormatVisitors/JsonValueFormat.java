package com.fasterxml.jackson.databind.jsonFormatVisitors;

import com.fasterxml.jackson.annotation.JsonValue;
import com.google.android.gms.common.Scopes;
import p140me.bridgefy.ormlite.entities.FriendDTO;

public enum JsonValueFormat {
    COLOR(FriendDTO.COLOR),
    DATE("date"),
    DATE_TIME("date-time"),
    EMAIL(Scopes.EMAIL),
    HOST_NAME("host-name"),
    IP_ADDRESS("ip-address"),
    IPV6("ipv6"),
    PHONE("phone"),
    REGEX("regex"),
    STYLE("style"),
    TIME("time"),
    URI("uri"),
    UTC_MILLISEC("utc-millisec");
    
    private final String _desc;

    private JsonValueFormat(String str) {
        this._desc = str;
    }

    @JsonValue
    public String toString() {
        return this._desc;
    }
}
