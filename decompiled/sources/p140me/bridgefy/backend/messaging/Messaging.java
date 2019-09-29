package p140me.bridgefy.backend.messaging;

import com.google.api.client.googleapis.GoogleUtils;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient;
import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import java.io.IOException;

/* renamed from: me.bridgefy.backend.messaging.Messaging */
public class Messaging extends AbstractGoogleJsonClient {
    public static final String DEFAULT_BASE_URL = "https://bionic-armando.appspot.com/_ah/api/messaging/v1/";
    public static final String DEFAULT_BATCH_PATH = "batch";
    public static final String DEFAULT_ROOT_URL = "https://bionic-armando.appspot.com/_ah/api/";
    public static final String DEFAULT_SERVICE_PATH = "messaging/v1/";

    /* renamed from: me.bridgefy.backend.messaging.Messaging$Builder */
    public static final class Builder extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder {
        public Builder(HttpTransport httpTransport, JsonFactory jsonFactory, HttpRequestInitializer httpRequestInitializer) {
            super(httpTransport, jsonFactory, "https://bionic-armando.appspot.com/_ah/api/", Messaging.DEFAULT_SERVICE_PATH, httpRequestInitializer, false);
            setBatchPath("batch");
        }

        public Messaging build() {
            return new Messaging(this);
        }

        public Builder setRootUrl(String str) {
            return (Builder) super.setRootUrl(str);
        }

        public Builder setServicePath(String str) {
            return (Builder) super.setServicePath(str);
        }

        public Builder setBatchPath(String str) {
            return (Builder) super.setBatchPath(str);
        }

        public Builder setHttpRequestInitializer(HttpRequestInitializer httpRequestInitializer) {
            return (Builder) super.setHttpRequestInitializer(httpRequestInitializer);
        }

        public Builder setApplicationName(String str) {
            return (Builder) super.setApplicationName(str);
        }

        public Builder setSuppressPatternChecks(boolean z) {
            return (Builder) super.setSuppressPatternChecks(z);
        }

        public Builder setSuppressRequiredParameterChecks(boolean z) {
            return (Builder) super.setSuppressRequiredParameterChecks(z);
        }

        public Builder setSuppressAllChecks(boolean z) {
            return (Builder) super.setSuppressAllChecks(z);
        }

        public Builder setMessagingRequestInitializer(MessagingRequestInitializer messagingRequestInitializer) {
            return (Builder) super.setGoogleClientRequestInitializer((GoogleClientRequestInitializer) messagingRequestInitializer);
        }

        public Builder setGoogleClientRequestInitializer(GoogleClientRequestInitializer googleClientRequestInitializer) {
            return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
        }
    }

    /* renamed from: me.bridgefy.backend.messaging.Messaging$MessagingEndpoint */
    public class MessagingEndpoint {

        /* renamed from: me.bridgefy.backend.messaging.Messaging$MessagingEndpoint$SendMessage */
        public class SendMessage extends MessagingRequest<Void> {
            private static final String REST_PATH = "sendMessage/{message}";
            @Key
            private String message;

            protected SendMessage(String str) {
                super(Messaging.this, HttpMethods.POST, REST_PATH, null, Void.class);
                this.message = (String) Preconditions.checkNotNull(str, "Required parameter message must be specified.");
            }

            public SendMessage setAlt(String str) {
                return (SendMessage) super.setAlt(str);
            }

            public SendMessage setFields(String str) {
                return (SendMessage) super.setFields(str);
            }

            public SendMessage setKey(String str) {
                return (SendMessage) super.setKey(str);
            }

            public SendMessage setOauthToken(String str) {
                return (SendMessage) super.setOauthToken(str);
            }

            public SendMessage setPrettyPrint(Boolean bool) {
                return (SendMessage) super.setPrettyPrint(bool);
            }

            public SendMessage setQuotaUser(String str) {
                return (SendMessage) super.setQuotaUser(str);
            }

            public SendMessage setUserIp(String str) {
                return (SendMessage) super.setUserIp(str);
            }

            public String getMessage() {
                return this.message;
            }

            public SendMessage setMessage(String str) {
                this.message = str;
                return this;
            }

            public SendMessage set(String str, Object obj) {
                return (SendMessage) super.set(str, obj);
            }
        }

        /* renamed from: me.bridgefy.backend.messaging.Messaging$MessagingEndpoint$SendMessageiOS */
        public class SendMessageiOS extends MessagingRequest<Void> {
            private static final String REST_PATH = "sendMessageiOS/{message}/{token}";
            @Key
            private String message;
            @Key
            private String token;

            protected SendMessageiOS(String str, String str2) {
                super(Messaging.this, HttpMethods.POST, REST_PATH, null, Void.class);
                this.message = (String) Preconditions.checkNotNull(str, "Required parameter message must be specified.");
                this.token = (String) Preconditions.checkNotNull(str2, "Required parameter token must be specified.");
            }

            public SendMessageiOS setAlt(String str) {
                return (SendMessageiOS) super.setAlt(str);
            }

            public SendMessageiOS setFields(String str) {
                return (SendMessageiOS) super.setFields(str);
            }

            public SendMessageiOS setKey(String str) {
                return (SendMessageiOS) super.setKey(str);
            }

            public SendMessageiOS setOauthToken(String str) {
                return (SendMessageiOS) super.setOauthToken(str);
            }

            public SendMessageiOS setPrettyPrint(Boolean bool) {
                return (SendMessageiOS) super.setPrettyPrint(bool);
            }

            public SendMessageiOS setQuotaUser(String str) {
                return (SendMessageiOS) super.setQuotaUser(str);
            }

            public SendMessageiOS setUserIp(String str) {
                return (SendMessageiOS) super.setUserIp(str);
            }

            public String getMessage() {
                return this.message;
            }

            public SendMessageiOS setMessage(String str) {
                this.message = str;
                return this;
            }

            public String getToken() {
                return this.token;
            }

            public SendMessageiOS setToken(String str) {
                this.token = str;
                return this;
            }

            public SendMessageiOS set(String str, Object obj) {
                return (SendMessageiOS) super.set(str, obj);
            }
        }

        public MessagingEndpoint() {
        }

        public SendMessage sendMessage(String str) throws IOException {
            SendMessage sendMessage = new SendMessage(str);
            Messaging.this.initialize(sendMessage);
            return sendMessage;
        }

        public SendMessageiOS sendMessageiOS(String str, String str2) throws IOException {
            SendMessageiOS sendMessageiOS = new SendMessageiOS(str, str2);
            Messaging.this.initialize(sendMessageiOS);
            return sendMessageiOS;
        }
    }

    static {
        Preconditions.checkState(GoogleUtils.MAJOR_VERSION.intValue() == 1 && GoogleUtils.MINOR_VERSION.intValue() >= 15, "You are currently running with version %s of google-api-client. You need at least version 1.15 of google-api-client to run version 1.25.0 of the messaging library.", GoogleUtils.VERSION);
    }

    public Messaging(HttpTransport httpTransport, JsonFactory jsonFactory, HttpRequestInitializer httpRequestInitializer) {
        this(new Builder(httpTransport, jsonFactory, httpRequestInitializer));
    }

    Messaging(Builder builder) {
        super(builder);
    }

    /* access modifiers changed from: protected */
    public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
        super.initialize(abstractGoogleClientRequest);
    }

    public MessagingEndpoint messagingEndpoint() {
        return new MessagingEndpoint();
    }
}
