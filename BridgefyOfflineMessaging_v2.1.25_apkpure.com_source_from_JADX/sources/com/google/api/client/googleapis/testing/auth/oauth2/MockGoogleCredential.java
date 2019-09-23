package com.google.api.client.googleapis.testing.auth.oauth2;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.Json;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Clock;
import java.io.IOException;

@Beta
public class MockGoogleCredential extends GoogleCredential {
    public static final String ACCESS_TOKEN = "access_xyz";
    private static final String DEFAULT_TOKEN_RESPONSE_JSON = String.format(TOKEN_RESPONSE, new Object[]{ACCESS_TOKEN, EXPIRES_IN_SECONDS, REFRESH_TOKEN, TOKEN_TYPE});
    private static final String EXPIRES_IN_SECONDS = "3600";
    public static final String REFRESH_TOKEN = "refresh123";
    private static final String TOKEN_RESPONSE = "{\"access_token\": \"%s\", \"expires_in\":  %s, \"refresh_token\": \"%s\", \"token_type\": \"%s\"}";
    private static final String TOKEN_TYPE = "Bearer";

    @Beta
    public static class Builder extends com.google.api.client.googleapis.auth.oauth2.GoogleCredential.Builder {
        public Builder setTransport(HttpTransport httpTransport) {
            return (Builder) super.setTransport(httpTransport);
        }

        public Builder setClientAuthentication(HttpExecuteInterceptor httpExecuteInterceptor) {
            return (Builder) super.setClientAuthentication(httpExecuteInterceptor);
        }

        public Builder setJsonFactory(JsonFactory jsonFactory) {
            return (Builder) super.setJsonFactory(jsonFactory);
        }

        public Builder setClock(Clock clock) {
            return (Builder) super.setClock(clock);
        }

        public MockGoogleCredential build() {
            if (getTransport() == null) {
                setTransport((HttpTransport) new com.google.api.client.testing.http.MockHttpTransport.Builder().build());
            }
            if (getClientAuthentication() == null) {
                setClientAuthentication((HttpExecuteInterceptor) new MockClientAuthentication());
            }
            if (getJsonFactory() == null) {
                setJsonFactory((JsonFactory) new JacksonFactory());
            }
            return new MockGoogleCredential(this);
        }
    }

    @Beta
    private static class MockClientAuthentication implements HttpExecuteInterceptor {
        public void intercept(HttpRequest httpRequest) throws IOException {
        }

        private MockClientAuthentication() {
        }
    }

    public MockGoogleCredential(Builder builder) {
        super(builder);
    }

    public static MockHttpTransport newMockHttpTransportWithSampleTokenResponse() {
        return new com.google.api.client.testing.http.MockHttpTransport.Builder().setLowLevelHttpRequest(new MockLowLevelHttpRequest().setResponse(new MockLowLevelHttpResponse().setContentType(Json.MEDIA_TYPE).setContent(DEFAULT_TOKEN_RESPONSE_JSON))).build();
    }
}
