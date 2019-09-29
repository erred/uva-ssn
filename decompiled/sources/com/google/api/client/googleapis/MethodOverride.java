package com.google.api.client.googleapis;

import com.google.api.client.http.EmptyContent;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.UrlEncodedContent;
import java.io.IOException;

public final class MethodOverride implements HttpExecuteInterceptor, HttpRequestInitializer {
    public static final String HEADER = "X-HTTP-Method-Override";
    static final int MAX_URL_LENGTH = 2048;
    private final boolean overrideAllMethods;

    public static final class Builder {
        private boolean overrideAllMethods;

        public MethodOverride build() {
            return new MethodOverride(this.overrideAllMethods);
        }

        public boolean getOverrideAllMethods() {
            return this.overrideAllMethods;
        }

        public Builder setOverrideAllMethods(boolean z) {
            this.overrideAllMethods = z;
            return this;
        }
    }

    public MethodOverride() {
        this(false);
    }

    MethodOverride(boolean z) {
        this.overrideAllMethods = z;
    }

    public void initialize(HttpRequest httpRequest) {
        httpRequest.setInterceptor(this);
    }

    public void intercept(HttpRequest httpRequest) throws IOException {
        if (overrideThisMethod(httpRequest)) {
            String requestMethod = httpRequest.getRequestMethod();
            httpRequest.setRequestMethod(HttpMethods.POST);
            httpRequest.getHeaders().set(HEADER, (Object) requestMethod);
            if (requestMethod.equals(HttpMethods.GET)) {
                httpRequest.setContent(new UrlEncodedContent(httpRequest.getUrl().clone()));
                httpRequest.getUrl().clear();
            } else if (httpRequest.getContent() == null) {
                httpRequest.setContent(new EmptyContent());
            }
        }
    }

    private boolean overrideThisMethod(HttpRequest httpRequest) throws IOException {
        String requestMethod = httpRequest.getRequestMethod();
        if (requestMethod.equals(HttpMethods.POST)) {
            return false;
        }
        if (!requestMethod.equals(HttpMethods.GET) ? !this.overrideAllMethods : httpRequest.getUrl().build().length() <= MAX_URL_LENGTH) {
            return !httpRequest.getTransport().supportsMethod(requestMethod);
        }
        return true;
    }
}
