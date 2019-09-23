package com.google.api.client.http;

import com.google.api.client.util.Charsets;
import com.google.api.client.util.IOUtils;
import java.io.IOException;
import java.nio.charset.Charset;

public abstract class AbstractHttpContent implements HttpContent {
    private long computedLength;
    private HttpMediaType mediaType;

    public boolean retrySupported() {
        return true;
    }

    protected AbstractHttpContent(String str) {
        this(str == null ? null : new HttpMediaType(str));
    }

    protected AbstractHttpContent(HttpMediaType httpMediaType) {
        this.computedLength = -1;
        this.mediaType = httpMediaType;
    }

    public long getLength() throws IOException {
        if (this.computedLength == -1) {
            this.computedLength = computeLength();
        }
        return this.computedLength;
    }

    public final HttpMediaType getMediaType() {
        return this.mediaType;
    }

    public AbstractHttpContent setMediaType(HttpMediaType httpMediaType) {
        this.mediaType = httpMediaType;
        return this;
    }

    /* access modifiers changed from: protected */
    public final Charset getCharset() {
        return (this.mediaType == null || this.mediaType.getCharsetParameter() == null) ? Charsets.UTF_8 : this.mediaType.getCharsetParameter();
    }

    public String getType() {
        if (this.mediaType == null) {
            return null;
        }
        return this.mediaType.build();
    }

    /* access modifiers changed from: protected */
    public long computeLength() throws IOException {
        return computeLength(this);
    }

    public static long computeLength(HttpContent httpContent) throws IOException {
        if (!httpContent.retrySupported()) {
            return -1;
        }
        return IOUtils.computeLength(httpContent);
    }
}
