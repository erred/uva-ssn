package p140me.bridgefy.backend.registration;

import com.google.api.client.googleapis.GoogleUtils;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient;
import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import p140me.bridgefy.backend.registration.model.CollectionResponseRegistrationRecord;

/* renamed from: me.bridgefy.backend.registration.Registration */
public class Registration extends AbstractGoogleJsonClient {
    public static final String DEFAULT_BASE_URL = "https://bionic-armando.appspot.com/_ah/api/registration/v1/";
    public static final String DEFAULT_BATCH_PATH = "batch";
    public static final String DEFAULT_ROOT_URL = "https://bionic-armando.appspot.com/_ah/api/";
    public static final String DEFAULT_SERVICE_PATH = "registration/v1/";

    /* renamed from: me.bridgefy.backend.registration.Registration$Builder */
    public static final class Builder extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder {
        public Builder(HttpTransport httpTransport, JsonFactory jsonFactory, HttpRequestInitializer httpRequestInitializer) {
            super(httpTransport, jsonFactory, "https://bionic-armando.appspot.com/_ah/api/", Registration.DEFAULT_SERVICE_PATH, httpRequestInitializer, false);
            setBatchPath("batch");
        }

        public Registration build() {
            return new Registration(this);
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

        public Builder setRegistrationRequestInitializer(RegistrationRequestInitializer registrationRequestInitializer) {
            return (Builder) super.setGoogleClientRequestInitializer((GoogleClientRequestInitializer) registrationRequestInitializer);
        }

        public Builder setGoogleClientRequestInitializer(GoogleClientRequestInitializer googleClientRequestInitializer) {
            return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
        }
    }

    /* renamed from: me.bridgefy.backend.registration.Registration$ListDevices */
    public class ListDevices extends RegistrationRequest<CollectionResponseRegistrationRecord> {
        private static final String REST_PATH = "registrationrecord/{count}";
        @Key
        private Integer count;

        protected ListDevices(Integer num) {
            super(Registration.this, HttpMethods.GET, REST_PATH, null, CollectionResponseRegistrationRecord.class);
            this.count = (Integer) Preconditions.checkNotNull(num, "Required parameter count must be specified.");
        }

        public HttpResponse executeUsingHead() throws IOException {
            return super.executeUsingHead();
        }

        public HttpRequest buildHttpRequestUsingHead() throws IOException {
            return super.buildHttpRequestUsingHead();
        }

        public ListDevices setAlt(String str) {
            return (ListDevices) super.setAlt(str);
        }

        public ListDevices setFields(String str) {
            return (ListDevices) super.setFields(str);
        }

        public ListDevices setKey(String str) {
            return (ListDevices) super.setKey(str);
        }

        public ListDevices setOauthToken(String str) {
            return (ListDevices) super.setOauthToken(str);
        }

        public ListDevices setPrettyPrint(Boolean bool) {
            return (ListDevices) super.setPrettyPrint(bool);
        }

        public ListDevices setQuotaUser(String str) {
            return (ListDevices) super.setQuotaUser(str);
        }

        public ListDevices setUserIp(String str) {
            return (ListDevices) super.setUserIp(str);
        }

        public Integer getCount() {
            return this.count;
        }

        public ListDevices setCount(Integer num) {
            this.count = num;
            return this;
        }

        public ListDevices set(String str, Object obj) {
            return (ListDevices) super.set(str, obj);
        }
    }

    /* renamed from: me.bridgefy.backend.registration.Registration$Register */
    public class Register extends RegistrationRequest<Void> {
        private static final String REST_PATH = "registerDevice/{regId}";
        @Key
        private String regId;

        protected Register(String str) {
            super(Registration.this, HttpMethods.POST, REST_PATH, null, Void.class);
            this.regId = (String) Preconditions.checkNotNull(str, "Required parameter regId must be specified.");
        }

        public Register setAlt(String str) {
            return (Register) super.setAlt(str);
        }

        public Register setFields(String str) {
            return (Register) super.setFields(str);
        }

        public Register setKey(String str) {
            return (Register) super.setKey(str);
        }

        public Register setOauthToken(String str) {
            return (Register) super.setOauthToken(str);
        }

        public Register setPrettyPrint(Boolean bool) {
            return (Register) super.setPrettyPrint(bool);
        }

        public Register setQuotaUser(String str) {
            return (Register) super.setQuotaUser(str);
        }

        public Register setUserIp(String str) {
            return (Register) super.setUserIp(str);
        }

        public String getRegId() {
            return this.regId;
        }

        public Register setRegId(String str) {
            this.regId = str;
            return this;
        }

        public Register set(String str, Object obj) {
            return (Register) super.set(str, obj);
        }
    }

    /* renamed from: me.bridgefy.backend.registration.Registration$Unregister */
    public class Unregister extends RegistrationRequest<Void> {
        private static final String REST_PATH = "unregisterDevice/{regId}";
        @Key
        private String regId;

        protected Unregister(String str) {
            super(Registration.this, HttpMethods.POST, REST_PATH, null, Void.class);
            this.regId = (String) Preconditions.checkNotNull(str, "Required parameter regId must be specified.");
        }

        public Unregister setAlt(String str) {
            return (Unregister) super.setAlt(str);
        }

        public Unregister setFields(String str) {
            return (Unregister) super.setFields(str);
        }

        public Unregister setKey(String str) {
            return (Unregister) super.setKey(str);
        }

        public Unregister setOauthToken(String str) {
            return (Unregister) super.setOauthToken(str);
        }

        public Unregister setPrettyPrint(Boolean bool) {
            return (Unregister) super.setPrettyPrint(bool);
        }

        public Unregister setQuotaUser(String str) {
            return (Unregister) super.setQuotaUser(str);
        }

        public Unregister setUserIp(String str) {
            return (Unregister) super.setUserIp(str);
        }

        public String getRegId() {
            return this.regId;
        }

        public Unregister setRegId(String str) {
            this.regId = str;
            return this;
        }

        public Unregister set(String str, Object obj) {
            return (Unregister) super.set(str, obj);
        }
    }

    static {
        Preconditions.checkState(GoogleUtils.MAJOR_VERSION.intValue() == 1 && GoogleUtils.MINOR_VERSION.intValue() >= 15, "You are currently running with version %s of google-api-client. You need at least version 1.15 of google-api-client to run version 1.25.0 of the registration library.", GoogleUtils.VERSION);
    }

    public Registration(HttpTransport httpTransport, JsonFactory jsonFactory, HttpRequestInitializer httpRequestInitializer) {
        this(new Builder(httpTransport, jsonFactory, httpRequestInitializer));
    }

    Registration(Builder builder) {
        super(builder);
    }

    /* access modifiers changed from: protected */
    public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
        super.initialize(abstractGoogleClientRequest);
    }

    public ListDevices listDevices(Integer num) throws IOException {
        ListDevices listDevices = new ListDevices(num);
        initialize(listDevices);
        return listDevices;
    }

    public Register register(String str) throws IOException {
        Register register = new Register(str);
        initialize(register);
        return register;
    }

    public Unregister unregister(String str) throws IOException {
        Unregister unregister = new Unregister(str);
        initialize(unregister);
        return unregister;
    }
}
