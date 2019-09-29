package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;

public class zzgc extends IOException {
    private zzhc zzxx = null;

    public zzgc(String str) {
        super(str);
    }

    public final zzgc zzh(zzhc zzhc) {
        this.zzxx = zzhc;
        return this;
    }

    static zzgc zzhq() {
        return new zzgc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static zzgc zzhr() {
        return new zzgc("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzgc zzhs() {
        return new zzgc("CodedInputStream encountered a malformed varint.");
    }

    static zzgc zzht() {
        return new zzgc("Protocol message contained an invalid tag (zero).");
    }

    static zzgc zzhu() {
        return new zzgc("Protocol message end-group tag did not match expected tag.");
    }

    static zzgd zzhv() {
        return new zzgd("Protocol message tag had invalid wire type.");
    }

    static zzgc zzhw() {
        return new zzgc("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    static zzgc zzhx() {
        return new zzgc("Failed to parse the message.");
    }

    static zzgc zzhy() {
        return new zzgc("Protocol message had invalid UTF-8.");
    }
}
