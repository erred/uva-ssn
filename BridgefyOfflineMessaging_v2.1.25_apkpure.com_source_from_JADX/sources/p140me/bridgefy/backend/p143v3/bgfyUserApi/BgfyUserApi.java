package p140me.bridgefy.backend.p143v3.bgfyUserApi;

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
import p140me.bridgefy.backend.p143v3.bgfyUserApi.model.CollectionResponseBgfyUser;
import p140me.bridgefy.backend.p143v3.bgfyUserApi.model.EndpointPhoneListContainer;

/* renamed from: me.bridgefy.backend.v3.bgfyUserApi.BgfyUserApi */
public class BgfyUserApi extends AbstractGoogleJsonClient {
    public static final String DEFAULT_BASE_URL = "https://bionic-armando.appspot.com/_ah/api/bgfyUserApi/v3/";
    public static final String DEFAULT_BATCH_PATH = "batch";
    public static final String DEFAULT_ROOT_URL = "https://bionic-armando.appspot.com/_ah/api/";
    public static final String DEFAULT_SERVICE_PATH = "bgfyUserApi/v3/";

    /* renamed from: me.bridgefy.backend.v3.bgfyUserApi.BgfyUserApi$BgfyUser */
    public class BgfyUser {

        /* renamed from: me.bridgefy.backend.v3.bgfyUserApi.BgfyUserApi$BgfyUser$BlockUser */
        public class BlockUser extends BgfyUserApiRequest<Void> {
            private static final String REST_PATH = "blockUser";
            @Key
            private String blockedId;

            protected BlockUser(String str) {
                super(BgfyUserApi.this, HttpMethods.POST, REST_PATH, null, Void.class);
                this.blockedId = (String) Preconditions.checkNotNull(str, "Required parameter blockedId must be specified.");
            }

            public BlockUser setAlt(String str) {
                return (BlockUser) super.setAlt(str);
            }

            public BlockUser setFields(String str) {
                return (BlockUser) super.setFields(str);
            }

            public BlockUser setKey(String str) {
                return (BlockUser) super.setKey(str);
            }

            public BlockUser setOauthToken(String str) {
                return (BlockUser) super.setOauthToken(str);
            }

            public BlockUser setPrettyPrint(Boolean bool) {
                return (BlockUser) super.setPrettyPrint(bool);
            }

            public BlockUser setQuotaUser(String str) {
                return (BlockUser) super.setQuotaUser(str);
            }

            public BlockUser setUserIp(String str) {
                return (BlockUser) super.setUserIp(str);
            }

            public String getBlockedId() {
                return this.blockedId;
            }

            public BlockUser setBlockedId(String str) {
                this.blockedId = str;
                return this;
            }

            public BlockUser set(String str, Object obj) {
                return (BlockUser) super.set(str, obj);
            }
        }

        /* renamed from: me.bridgefy.backend.v3.bgfyUserApi.BgfyUserApi$BgfyUser$GetSelfUser */
        public class GetSelfUser extends BgfyUserApiRequest<p140me.bridgefy.backend.p143v3.bgfyUserApi.model.BgfyUser> {
            private static final String REST_PATH = "getSelfUser";

            protected GetSelfUser() {
                super(BgfyUserApi.this, HttpMethods.GET, REST_PATH, null, p140me.bridgefy.backend.p143v3.bgfyUserApi.model.BgfyUser.class);
            }

            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            public GetSelfUser setAlt(String str) {
                return (GetSelfUser) super.setAlt(str);
            }

            public GetSelfUser setFields(String str) {
                return (GetSelfUser) super.setFields(str);
            }

            public GetSelfUser setKey(String str) {
                return (GetSelfUser) super.setKey(str);
            }

            public GetSelfUser setOauthToken(String str) {
                return (GetSelfUser) super.setOauthToken(str);
            }

            public GetSelfUser setPrettyPrint(Boolean bool) {
                return (GetSelfUser) super.setPrettyPrint(bool);
            }

            public GetSelfUser setQuotaUser(String str) {
                return (GetSelfUser) super.setQuotaUser(str);
            }

            public GetSelfUser setUserIp(String str) {
                return (GetSelfUser) super.setUserIp(str);
            }

            public GetSelfUser set(String str, Object obj) {
                return (GetSelfUser) super.set(str, obj);
            }
        }

        /* renamed from: me.bridgefy.backend.v3.bgfyUserApi.BgfyUserApi$BgfyUser$GetUserById */
        public class GetUserById extends BgfyUserApiRequest<p140me.bridgefy.backend.p143v3.bgfyUserApi.model.BgfyUser> {
            private static final String REST_PATH = "bgfyUser/{uuid}";
            @Key
            private String uuid;

            protected GetUserById(String str) {
                super(BgfyUserApi.this, HttpMethods.GET, REST_PATH, null, p140me.bridgefy.backend.p143v3.bgfyUserApi.model.BgfyUser.class);
                this.uuid = (String) Preconditions.checkNotNull(str, "Required parameter uuid must be specified.");
            }

            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            public GetUserById setAlt(String str) {
                return (GetUserById) super.setAlt(str);
            }

            public GetUserById setFields(String str) {
                return (GetUserById) super.setFields(str);
            }

            public GetUserById setKey(String str) {
                return (GetUserById) super.setKey(str);
            }

            public GetUserById setOauthToken(String str) {
                return (GetUserById) super.setOauthToken(str);
            }

            public GetUserById setPrettyPrint(Boolean bool) {
                return (GetUserById) super.setPrettyPrint(bool);
            }

            public GetUserById setQuotaUser(String str) {
                return (GetUserById) super.setQuotaUser(str);
            }

            public GetUserById setUserIp(String str) {
                return (GetUserById) super.setUserIp(str);
            }

            public String getUuid() {
                return this.uuid;
            }

            public GetUserById setUuid(String str) {
                this.uuid = str;
                return this;
            }

            public GetUserById set(String str, Object obj) {
                return (GetUserById) super.set(str, obj);
            }
        }

        /* renamed from: me.bridgefy.backend.v3.bgfyUserApi.BgfyUserApi$BgfyUser$InsertUser */
        public class InsertUser extends BgfyUserApiRequest<p140me.bridgefy.backend.p143v3.bgfyUserApi.model.BgfyUser> {
            private static final String REST_PATH = "bgfyuser";

            protected InsertUser(p140me.bridgefy.backend.p143v3.bgfyUserApi.model.BgfyUser bgfyUser) {
                super(BgfyUserApi.this, HttpMethods.POST, REST_PATH, bgfyUser, p140me.bridgefy.backend.p143v3.bgfyUserApi.model.BgfyUser.class);
            }

            public InsertUser setAlt(String str) {
                return (InsertUser) super.setAlt(str);
            }

            public InsertUser setFields(String str) {
                return (InsertUser) super.setFields(str);
            }

            public InsertUser setKey(String str) {
                return (InsertUser) super.setKey(str);
            }

            public InsertUser setOauthToken(String str) {
                return (InsertUser) super.setOauthToken(str);
            }

            public InsertUser setPrettyPrint(Boolean bool) {
                return (InsertUser) super.setPrettyPrint(bool);
            }

            public InsertUser setQuotaUser(String str) {
                return (InsertUser) super.setQuotaUser(str);
            }

            public InsertUser setUserIp(String str) {
                return (InsertUser) super.setUserIp(str);
            }

            public InsertUser set(String str, Object obj) {
                return (InsertUser) super.set(str, obj);
            }
        }

        /* renamed from: me.bridgefy.backend.v3.bgfyUserApi.BgfyUserApi$BgfyUser$UnblockUser */
        public class UnblockUser extends BgfyUserApiRequest<Void> {
            private static final String REST_PATH = "unblockUser";
            @Key
            private String blockedId;

            protected UnblockUser(String str) {
                super(BgfyUserApi.this, HttpMethods.POST, REST_PATH, null, Void.class);
                this.blockedId = (String) Preconditions.checkNotNull(str, "Required parameter blockedId must be specified.");
            }

            public UnblockUser setAlt(String str) {
                return (UnblockUser) super.setAlt(str);
            }

            public UnblockUser setFields(String str) {
                return (UnblockUser) super.setFields(str);
            }

            public UnblockUser setKey(String str) {
                return (UnblockUser) super.setKey(str);
            }

            public UnblockUser setOauthToken(String str) {
                return (UnblockUser) super.setOauthToken(str);
            }

            public UnblockUser setPrettyPrint(Boolean bool) {
                return (UnblockUser) super.setPrettyPrint(bool);
            }

            public UnblockUser setQuotaUser(String str) {
                return (UnblockUser) super.setQuotaUser(str);
            }

            public UnblockUser setUserIp(String str) {
                return (UnblockUser) super.setUserIp(str);
            }

            public String getBlockedId() {
                return this.blockedId;
            }

            public UnblockUser setBlockedId(String str) {
                this.blockedId = str;
                return this;
            }

            public UnblockUser set(String str, Object obj) {
                return (UnblockUser) super.set(str, obj);
            }
        }

        /* renamed from: me.bridgefy.backend.v3.bgfyUserApi.BgfyUserApi$BgfyUser$UpdateUser */
        public class UpdateUser extends BgfyUserApiRequest<p140me.bridgefy.backend.p143v3.bgfyUserApi.model.BgfyUser> {
            private static final String REST_PATH = "bgfyuser";

            protected UpdateUser(p140me.bridgefy.backend.p143v3.bgfyUserApi.model.BgfyUser bgfyUser) {
                super(BgfyUserApi.this, HttpMethods.PUT, REST_PATH, bgfyUser, p140me.bridgefy.backend.p143v3.bgfyUserApi.model.BgfyUser.class);
            }

            public UpdateUser setAlt(String str) {
                return (UpdateUser) super.setAlt(str);
            }

            public UpdateUser setFields(String str) {
                return (UpdateUser) super.setFields(str);
            }

            public UpdateUser setKey(String str) {
                return (UpdateUser) super.setKey(str);
            }

            public UpdateUser setOauthToken(String str) {
                return (UpdateUser) super.setOauthToken(str);
            }

            public UpdateUser setPrettyPrint(Boolean bool) {
                return (UpdateUser) super.setPrettyPrint(bool);
            }

            public UpdateUser setQuotaUser(String str) {
                return (UpdateUser) super.setQuotaUser(str);
            }

            public UpdateUser setUserIp(String str) {
                return (UpdateUser) super.setUserIp(str);
            }

            public UpdateUser set(String str, Object obj) {
                return (UpdateUser) super.set(str, obj);
            }
        }

        /* renamed from: me.bridgefy.backend.v3.bgfyUserApi.BgfyUserApi$BgfyUser$UpdateUserBluetoothAddress */
        public class UpdateUserBluetoothAddress extends BgfyUserApiRequest<Void> {
            private static final String REST_PATH = "bgfyUserBluetoothAddress";
            @Key
            private String bluetoothAddress;
            @Key
            private String uuid;

            protected UpdateUserBluetoothAddress(String str, String str2) {
                super(BgfyUserApi.this, HttpMethods.PUT, REST_PATH, null, Void.class);
                this.uuid = (String) Preconditions.checkNotNull(str, "Required parameter uuid must be specified.");
                this.bluetoothAddress = (String) Preconditions.checkNotNull(str2, "Required parameter bluetoothAddress must be specified.");
            }

            public UpdateUserBluetoothAddress setAlt(String str) {
                return (UpdateUserBluetoothAddress) super.setAlt(str);
            }

            public UpdateUserBluetoothAddress setFields(String str) {
                return (UpdateUserBluetoothAddress) super.setFields(str);
            }

            public UpdateUserBluetoothAddress setKey(String str) {
                return (UpdateUserBluetoothAddress) super.setKey(str);
            }

            public UpdateUserBluetoothAddress setOauthToken(String str) {
                return (UpdateUserBluetoothAddress) super.setOauthToken(str);
            }

            public UpdateUserBluetoothAddress setPrettyPrint(Boolean bool) {
                return (UpdateUserBluetoothAddress) super.setPrettyPrint(bool);
            }

            public UpdateUserBluetoothAddress setQuotaUser(String str) {
                return (UpdateUserBluetoothAddress) super.setQuotaUser(str);
            }

            public UpdateUserBluetoothAddress setUserIp(String str) {
                return (UpdateUserBluetoothAddress) super.setUserIp(str);
            }

            public String getUuid() {
                return this.uuid;
            }

            public UpdateUserBluetoothAddress setUuid(String str) {
                this.uuid = str;
                return this;
            }

            public String getBluetoothAddress() {
                return this.bluetoothAddress;
            }

            public UpdateUserBluetoothAddress setBluetoothAddress(String str) {
                this.bluetoothAddress = str;
                return this;
            }

            public UpdateUserBluetoothAddress set(String str, Object obj) {
                return (UpdateUserBluetoothAddress) super.set(str, obj);
            }
        }

        public BgfyUser() {
        }

        public BlockUser blockUser(String str) throws IOException {
            BlockUser blockUser = new BlockUser(str);
            BgfyUserApi.this.initialize(blockUser);
            return blockUser;
        }

        public GetSelfUser getSelfUser() throws IOException {
            GetSelfUser getSelfUser = new GetSelfUser();
            BgfyUserApi.this.initialize(getSelfUser);
            return getSelfUser;
        }

        public GetUserById getUserById(String str) throws IOException {
            GetUserById getUserById = new GetUserById(str);
            BgfyUserApi.this.initialize(getUserById);
            return getUserById;
        }

        public InsertUser insertUser(p140me.bridgefy.backend.p143v3.bgfyUserApi.model.BgfyUser bgfyUser) throws IOException {
            InsertUser insertUser = new InsertUser(bgfyUser);
            BgfyUserApi.this.initialize(insertUser);
            return insertUser;
        }

        public UnblockUser unblockUser(String str) throws IOException {
            UnblockUser unblockUser = new UnblockUser(str);
            BgfyUserApi.this.initialize(unblockUser);
            return unblockUser;
        }

        public UpdateUser updateUser(p140me.bridgefy.backend.p143v3.bgfyUserApi.model.BgfyUser bgfyUser) throws IOException {
            UpdateUser updateUser = new UpdateUser(bgfyUser);
            BgfyUserApi.this.initialize(updateUser);
            return updateUser;
        }

        public UpdateUserBluetoothAddress updateUserBluetoothAddress(String str, String str2) throws IOException {
            UpdateUserBluetoothAddress updateUserBluetoothAddress = new UpdateUserBluetoothAddress(str, str2);
            BgfyUserApi.this.initialize(updateUserBluetoothAddress);
            return updateUserBluetoothAddress;
        }
    }

    /* renamed from: me.bridgefy.backend.v3.bgfyUserApi.BgfyUserApi$Builder */
    public static final class Builder extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder {
        public Builder(HttpTransport httpTransport, JsonFactory jsonFactory, HttpRequestInitializer httpRequestInitializer) {
            super(httpTransport, jsonFactory, "https://bionic-armando.appspot.com/_ah/api/", BgfyUserApi.DEFAULT_SERVICE_PATH, httpRequestInitializer, false);
            setBatchPath("batch");
        }

        public BgfyUserApi build() {
            return new BgfyUserApi(this);
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

        public Builder setBgfyUserApiRequestInitializer(BgfyUserApiRequestInitializer bgfyUserApiRequestInitializer) {
            return (Builder) super.setGoogleClientRequestInitializer((GoogleClientRequestInitializer) bgfyUserApiRequestInitializer);
        }

        public Builder setGoogleClientRequestInitializer(GoogleClientRequestInitializer googleClientRequestInitializer) {
            return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
        }
    }

    /* renamed from: me.bridgefy.backend.v3.bgfyUserApi.BgfyUserApi$Contacts */
    public class Contacts extends BgfyUserApiRequest<CollectionResponseBgfyUser> {
        private static final String REST_PATH = "contacts";

        protected Contacts(EndpointPhoneListContainer endpointPhoneListContainer) {
            super(BgfyUserApi.this, HttpMethods.POST, REST_PATH, endpointPhoneListContainer, CollectionResponseBgfyUser.class);
        }

        public Contacts setAlt(String str) {
            return (Contacts) super.setAlt(str);
        }

        public Contacts setFields(String str) {
            return (Contacts) super.setFields(str);
        }

        public Contacts setKey(String str) {
            return (Contacts) super.setKey(str);
        }

        public Contacts setOauthToken(String str) {
            return (Contacts) super.setOauthToken(str);
        }

        public Contacts setPrettyPrint(Boolean bool) {
            return (Contacts) super.setPrettyPrint(bool);
        }

        public Contacts setQuotaUser(String str) {
            return (Contacts) super.setQuotaUser(str);
        }

        public Contacts setUserIp(String str) {
            return (Contacts) super.setUserIp(str);
        }

        public Contacts set(String str, Object obj) {
            return (Contacts) super.set(str, obj);
        }
    }

    static {
        Preconditions.checkState(GoogleUtils.MAJOR_VERSION.intValue() == 1 && GoogleUtils.MINOR_VERSION.intValue() >= 15, "You are currently running with version %s of google-api-client. You need at least version 1.15 of google-api-client to run version 1.25.0 of the bgfyUserApi library.", GoogleUtils.VERSION);
    }

    public BgfyUserApi(HttpTransport httpTransport, JsonFactory jsonFactory, HttpRequestInitializer httpRequestInitializer) {
        this(new Builder(httpTransport, jsonFactory, httpRequestInitializer));
    }

    BgfyUserApi(Builder builder) {
        super(builder);
    }

    /* access modifiers changed from: protected */
    public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
        super.initialize(abstractGoogleClientRequest);
    }

    public BgfyUser bgfyUser() {
        return new BgfyUser();
    }

    public Contacts contacts(EndpointPhoneListContainer endpointPhoneListContainer) throws IOException {
        Contacts contacts = new Contacts(endpointPhoneListContainer);
        initialize(contacts);
        return contacts;
    }
}
