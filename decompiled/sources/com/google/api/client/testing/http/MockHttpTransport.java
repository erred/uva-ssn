package com.google.api.client.testing.http;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;

@Beta
public class MockHttpTransport extends HttpTransport {
    private MockLowLevelHttpRequest lowLevelHttpRequest;
    private MockLowLevelHttpResponse lowLevelHttpResponse;
    private Set<String> supportedMethods;

    @Beta
    public static class Builder {
        MockLowLevelHttpRequest lowLevelHttpRequest;
        MockLowLevelHttpResponse lowLevelHttpResponse;
        Set<String> supportedMethods;

        public MockHttpTransport build() {
            return new MockHttpTransport(this);
        }

        public final Set<String> getSupportedMethods() {
            return this.supportedMethods;
        }

        public final Builder setSupportedMethods(Set<String> set) {
            this.supportedMethods = set;
            return this;
        }

        public final Builder setLowLevelHttpRequest(MockLowLevelHttpRequest mockLowLevelHttpRequest) {
            Preconditions.checkState(this.lowLevelHttpResponse == null, "Cannnot set a low level HTTP request when a low level HTTP response has been set.");
            this.lowLevelHttpRequest = mockLowLevelHttpRequest;
            return this;
        }

        public final MockLowLevelHttpRequest getLowLevelHttpRequest() {
            return this.lowLevelHttpRequest;
        }

        public final Builder setLowLevelHttpResponse(MockLowLevelHttpResponse mockLowLevelHttpResponse) {
            Preconditions.checkState(this.lowLevelHttpRequest == null, "Cannot set a low level HTTP response when a low level HTTP request has been set.");
            this.lowLevelHttpResponse = mockLowLevelHttpResponse;
            return this;
        }

        /* access modifiers changed from: 0000 */
        public MockLowLevelHttpResponse getLowLevelHttpResponse() {
            return this.lowLevelHttpResponse;
        }
    }

    public MockHttpTransport() {
    }

    protected MockHttpTransport(Builder builder) {
        this.supportedMethods = builder.supportedMethods;
        this.lowLevelHttpRequest = builder.lowLevelHttpRequest;
        this.lowLevelHttpResponse = builder.lowLevelHttpResponse;
    }

    public boolean supportsMethod(String str) throws IOException {
        return this.supportedMethods == null || this.supportedMethods.contains(str);
    }

    public LowLevelHttpRequest buildRequest(String str, String str2) throws IOException {
        Preconditions.checkArgument(supportsMethod(str), "HTTP method %s not supported", str);
        if (this.lowLevelHttpRequest != null) {
            return this.lowLevelHttpRequest;
        }
        MockLowLevelHttpRequest mockLowLevelHttpRequest = new MockLowLevelHttpRequest(str2);
        if (this.lowLevelHttpResponse != null) {
            mockLowLevelHttpRequest.setResponse(this.lowLevelHttpResponse);
        }
        return mockLowLevelHttpRequest;
    }

    public final Set<String> getSupportedMethods() {
        if (this.supportedMethods == null) {
            return null;
        }
        return Collections.unmodifiableSet(this.supportedMethods);
    }

    public final MockLowLevelHttpRequest getLowLevelHttpRequest() {
        return this.lowLevelHttpRequest;
    }

    @Deprecated
    public static Builder builder() {
        return new Builder();
    }
}
