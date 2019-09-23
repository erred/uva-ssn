package p140me.bridgefy.backend.bgfyKeyApi;

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
import p140me.bridgefy.backend.bgfyKeyApi.model.CollectionResponseBgfyKey;

/* renamed from: me.bridgefy.backend.bgfyKeyApi.BgfyKeyApi */
public class BgfyKeyApi extends AbstractGoogleJsonClient {
    public static final String DEFAULT_BASE_URL = "https://bionic-armando.appspot.com/_ah/api/bgfyKeyApi/v1/";
    public static final String DEFAULT_BATCH_PATH = "batch";
    public static final String DEFAULT_ROOT_URL = "https://bionic-armando.appspot.com/_ah/api/";
    public static final String DEFAULT_SERVICE_PATH = "bgfyKeyApi/v1/";

    /* renamed from: me.bridgefy.backend.bgfyKeyApi.BgfyKeyApi$BgfyKey */
    public class BgfyKey {

        /* renamed from: me.bridgefy.backend.bgfyKeyApi.BgfyKeyApi$BgfyKey$InsertKey */
        public class InsertKey extends BgfyKeyApiRequest<p140me.bridgefy.backend.bgfyKeyApi.model.BgfyKey> {
            private static final String REST_PATH = "bgfykey";

            protected InsertKey(p140me.bridgefy.backend.bgfyKeyApi.model.BgfyKey bgfyKey) {
                super(BgfyKeyApi.this, HttpMethods.POST, REST_PATH, bgfyKey, p140me.bridgefy.backend.bgfyKeyApi.model.BgfyKey.class);
            }

            public InsertKey setAlt(String str) {
                return (InsertKey) super.setAlt(str);
            }

            public InsertKey setFields(String str) {
                return (InsertKey) super.setFields(str);
            }

            public InsertKey setKey(String str) {
                return (InsertKey) super.setKey(str);
            }

            public InsertKey setOauthToken(String str) {
                return (InsertKey) super.setOauthToken(str);
            }

            public InsertKey setPrettyPrint(Boolean bool) {
                return (InsertKey) super.setPrettyPrint(bool);
            }

            public InsertKey setQuotaUser(String str) {
                return (InsertKey) super.setQuotaUser(str);
            }

            public InsertKey setUserIp(String str) {
                return (InsertKey) super.setUserIp(str);
            }

            public InsertKey set(String str, Object obj) {
                return (InsertKey) super.set(str, obj);
            }
        }

        /* renamed from: me.bridgefy.backend.bgfyKeyApi.BgfyKeyApi$BgfyKey$ListKeys */
        public class ListKeys extends BgfyKeyApiRequest<CollectionResponseBgfyKey> {
            private static final String REST_PATH = "bgfykey";
            @Key
            private String cursor;
            @Key
            private Integer limit;

            protected ListKeys() {
                super(BgfyKeyApi.this, HttpMethods.GET, REST_PATH, null, CollectionResponseBgfyKey.class);
            }

            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            public ListKeys setAlt(String str) {
                return (ListKeys) super.setAlt(str);
            }

            public ListKeys setFields(String str) {
                return (ListKeys) super.setFields(str);
            }

            public ListKeys setKey(String str) {
                return (ListKeys) super.setKey(str);
            }

            public ListKeys setOauthToken(String str) {
                return (ListKeys) super.setOauthToken(str);
            }

            public ListKeys setPrettyPrint(Boolean bool) {
                return (ListKeys) super.setPrettyPrint(bool);
            }

            public ListKeys setQuotaUser(String str) {
                return (ListKeys) super.setQuotaUser(str);
            }

            public ListKeys setUserIp(String str) {
                return (ListKeys) super.setUserIp(str);
            }

            public String getCursor() {
                return this.cursor;
            }

            public ListKeys setCursor(String str) {
                this.cursor = str;
                return this;
            }

            public Integer getLimit() {
                return this.limit;
            }

            public ListKeys setLimit(Integer num) {
                this.limit = num;
                return this;
            }

            public ListKeys set(String str, Object obj) {
                return (ListKeys) super.set(str, obj);
            }
        }

        /* renamed from: me.bridgefy.backend.bgfyKeyApi.BgfyKeyApi$BgfyKey$RemoveKey */
        public class RemoveKey extends BgfyKeyApiRequest<Void> {
            private static final String REST_PATH = "bgfyKey/{owner}";
            @Key
            private String owner;

            protected RemoveKey(String str) {
                super(BgfyKeyApi.this, HttpMethods.DELETE, REST_PATH, null, Void.class);
                this.owner = (String) Preconditions.checkNotNull(str, "Required parameter owner must be specified.");
            }

            public RemoveKey setAlt(String str) {
                return (RemoveKey) super.setAlt(str);
            }

            public RemoveKey setFields(String str) {
                return (RemoveKey) super.setFields(str);
            }

            public RemoveKey setKey(String str) {
                return (RemoveKey) super.setKey(str);
            }

            public RemoveKey setOauthToken(String str) {
                return (RemoveKey) super.setOauthToken(str);
            }

            public RemoveKey setPrettyPrint(Boolean bool) {
                return (RemoveKey) super.setPrettyPrint(bool);
            }

            public RemoveKey setQuotaUser(String str) {
                return (RemoveKey) super.setQuotaUser(str);
            }

            public RemoveKey setUserIp(String str) {
                return (RemoveKey) super.setUserIp(str);
            }

            public String getOwner() {
                return this.owner;
            }

            public RemoveKey setOwner(String str) {
                this.owner = str;
                return this;
            }

            public RemoveKey set(String str, Object obj) {
                return (RemoveKey) super.set(str, obj);
            }
        }

        /* renamed from: me.bridgefy.backend.bgfyKeyApi.BgfyKeyApi$BgfyKey$UpdateKey */
        public class UpdateKey extends BgfyKeyApiRequest<p140me.bridgefy.backend.bgfyKeyApi.model.BgfyKey> {
            private static final String REST_PATH = "bgfyKey/{owner}";
            @Key
            private String owner;

            protected UpdateKey(String str, p140me.bridgefy.backend.bgfyKeyApi.model.BgfyKey bgfyKey) {
                super(BgfyKeyApi.this, HttpMethods.PUT, REST_PATH, bgfyKey, p140me.bridgefy.backend.bgfyKeyApi.model.BgfyKey.class);
                this.owner = (String) Preconditions.checkNotNull(str, "Required parameter owner must be specified.");
            }

            public UpdateKey setAlt(String str) {
                return (UpdateKey) super.setAlt(str);
            }

            public UpdateKey setFields(String str) {
                return (UpdateKey) super.setFields(str);
            }

            public UpdateKey setKey(String str) {
                return (UpdateKey) super.setKey(str);
            }

            public UpdateKey setOauthToken(String str) {
                return (UpdateKey) super.setOauthToken(str);
            }

            public UpdateKey setPrettyPrint(Boolean bool) {
                return (UpdateKey) super.setPrettyPrint(bool);
            }

            public UpdateKey setQuotaUser(String str) {
                return (UpdateKey) super.setQuotaUser(str);
            }

            public UpdateKey setUserIp(String str) {
                return (UpdateKey) super.setUserIp(str);
            }

            public String getOwner() {
                return this.owner;
            }

            public UpdateKey setOwner(String str) {
                this.owner = str;
                return this;
            }

            public UpdateKey set(String str, Object obj) {
                return (UpdateKey) super.set(str, obj);
            }
        }

        public BgfyKey() {
        }

        public InsertKey insertKey(p140me.bridgefy.backend.bgfyKeyApi.model.BgfyKey bgfyKey) throws IOException {
            InsertKey insertKey = new InsertKey(bgfyKey);
            BgfyKeyApi.this.initialize(insertKey);
            return insertKey;
        }

        public ListKeys listKeys() throws IOException {
            ListKeys listKeys = new ListKeys();
            BgfyKeyApi.this.initialize(listKeys);
            return listKeys;
        }

        public RemoveKey removeKey(String str) throws IOException {
            RemoveKey removeKey = new RemoveKey(str);
            BgfyKeyApi.this.initialize(removeKey);
            return removeKey;
        }

        public UpdateKey updateKey(String str, p140me.bridgefy.backend.bgfyKeyApi.model.BgfyKey bgfyKey) throws IOException {
            UpdateKey updateKey = new UpdateKey(str, bgfyKey);
            BgfyKeyApi.this.initialize(updateKey);
            return updateKey;
        }
    }

    /* renamed from: me.bridgefy.backend.bgfyKeyApi.BgfyKeyApi$Builder */
    public static final class Builder extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder {
        public Builder(HttpTransport httpTransport, JsonFactory jsonFactory, HttpRequestInitializer httpRequestInitializer) {
            super(httpTransport, jsonFactory, "https://bionic-armando.appspot.com/_ah/api/", BgfyKeyApi.DEFAULT_SERVICE_PATH, httpRequestInitializer, false);
            setBatchPath("batch");
        }

        public BgfyKeyApi build() {
            return new BgfyKeyApi(this);
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

        public Builder setBgfyKeyApiRequestInitializer(BgfyKeyApiRequestInitializer bgfyKeyApiRequestInitializer) {
            return (Builder) super.setGoogleClientRequestInitializer((GoogleClientRequestInitializer) bgfyKeyApiRequestInitializer);
        }

        public Builder setGoogleClientRequestInitializer(GoogleClientRequestInitializer googleClientRequestInitializer) {
            return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
        }
    }

    /* renamed from: me.bridgefy.backend.bgfyKeyApi.BgfyKeyApi$Get */
    public class Get extends BgfyKeyApiRequest<p140me.bridgefy.backend.bgfyKeyApi.model.BgfyKey> {
        private static final String REST_PATH = "bgfyKey/{owner}";
        @Key
        private String owner;

        protected Get(String str) {
            super(BgfyKeyApi.this, HttpMethods.GET, REST_PATH, null, p140me.bridgefy.backend.bgfyKeyApi.model.BgfyKey.class);
            this.owner = (String) Preconditions.checkNotNull(str, "Required parameter owner must be specified.");
        }

        public HttpResponse executeUsingHead() throws IOException {
            return super.executeUsingHead();
        }

        public HttpRequest buildHttpRequestUsingHead() throws IOException {
            return super.buildHttpRequestUsingHead();
        }

        public Get setAlt(String str) {
            return (Get) super.setAlt(str);
        }

        public Get setFields(String str) {
            return (Get) super.setFields(str);
        }

        public Get setKey(String str) {
            return (Get) super.setKey(str);
        }

        public Get setOauthToken(String str) {
            return (Get) super.setOauthToken(str);
        }

        public Get setPrettyPrint(Boolean bool) {
            return (Get) super.setPrettyPrint(bool);
        }

        public Get setQuotaUser(String str) {
            return (Get) super.setQuotaUser(str);
        }

        public Get setUserIp(String str) {
            return (Get) super.setUserIp(str);
        }

        public String getOwner() {
            return this.owner;
        }

        public Get setOwner(String str) {
            this.owner = str;
            return this;
        }

        public Get set(String str, Object obj) {
            return (Get) super.set(str, obj);
        }
    }

    static {
        Preconditions.checkState(GoogleUtils.MAJOR_VERSION.intValue() == 1 && GoogleUtils.MINOR_VERSION.intValue() >= 15, "You are currently running with version %s of google-api-client. You need at least version 1.15 of google-api-client to run version 1.25.0 of the bgfyKeyApi library.", GoogleUtils.VERSION);
    }

    public BgfyKeyApi(HttpTransport httpTransport, JsonFactory jsonFactory, HttpRequestInitializer httpRequestInitializer) {
        this(new Builder(httpTransport, jsonFactory, httpRequestInitializer));
    }

    BgfyKeyApi(Builder builder) {
        super(builder);
    }

    /* access modifiers changed from: protected */
    public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
        super.initialize(abstractGoogleClientRequest);
    }

    public BgfyKey bgfyKey() {
        return new BgfyKey();
    }

    public Get get(String str) throws IOException {
        Get get = new Get(str);
        initialize(get);
        return get;
    }
}
