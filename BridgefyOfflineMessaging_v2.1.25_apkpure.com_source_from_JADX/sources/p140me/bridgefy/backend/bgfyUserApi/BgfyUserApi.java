package p140me.bridgefy.backend.bgfyUserApi;

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
import p140me.bridgefy.backend.bgfyUserApi.model.CollectionResponseBgfyUser;
import p140me.bridgefy.backend.bgfyUserApi.model.EndpointPhoneListContainer;

/* renamed from: me.bridgefy.backend.bgfyUserApi.BgfyUserApi */
public class BgfyUserApi extends AbstractGoogleJsonClient {
    public static final String DEFAULT_BASE_URL = "https://bionic-armando.appspot.com/_ah/api/bgfyUserApi/v1/";
    public static final String DEFAULT_BATCH_PATH = "batch";
    public static final String DEFAULT_ROOT_URL = "https://bionic-armando.appspot.com/_ah/api/";
    public static final String DEFAULT_SERVICE_PATH = "bgfyUserApi/v1/";

    /* renamed from: me.bridgefy.backend.bgfyUserApi.BgfyUserApi$BgfyUser */
    public class BgfyUser {

        /* renamed from: me.bridgefy.backend.bgfyUserApi.BgfyUserApi$BgfyUser$BlockUser */
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

        /* renamed from: me.bridgefy.backend.bgfyUserApi.BgfyUserApi$BgfyUser$GetUser */
        public class GetUser extends BgfyUserApiRequest<p140me.bridgefy.backend.bgfyUserApi.model.BgfyUser> {
            private static final String REST_PATH = "bgfyUser/{uuid}";
            @Key
            private String uuid;

            protected GetUser(String str) {
                super(BgfyUserApi.this, HttpMethods.GET, REST_PATH, null, p140me.bridgefy.backend.bgfyUserApi.model.BgfyUser.class);
                this.uuid = (String) Preconditions.checkNotNull(str, "Required parameter uuid must be specified.");
            }

            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            public GetUser setAlt(String str) {
                return (GetUser) super.setAlt(str);
            }

            public GetUser setFields(String str) {
                return (GetUser) super.setFields(str);
            }

            public GetUser setKey(String str) {
                return (GetUser) super.setKey(str);
            }

            public GetUser setOauthToken(String str) {
                return (GetUser) super.setOauthToken(str);
            }

            public GetUser setPrettyPrint(Boolean bool) {
                return (GetUser) super.setPrettyPrint(bool);
            }

            public GetUser setQuotaUser(String str) {
                return (GetUser) super.setQuotaUser(str);
            }

            public GetUser setUserIp(String str) {
                return (GetUser) super.setUserIp(str);
            }

            public String getUuid() {
                return this.uuid;
            }

            public GetUser setUuid(String str) {
                this.uuid = str;
                return this;
            }

            public GetUser set(String str, Object obj) {
                return (GetUser) super.set(str, obj);
            }
        }

        /* renamed from: me.bridgefy.backend.bgfyUserApi.BgfyUserApi$BgfyUser$GetUserFromPhone */
        public class GetUserFromPhone extends BgfyUserApiRequest<p140me.bridgefy.backend.bgfyUserApi.model.BgfyUser> {
            private static final String REST_PATH = "bgfyUserPhone/{phone}";
            @Key
            private String phone;

            protected GetUserFromPhone(String str) {
                super(BgfyUserApi.this, HttpMethods.GET, REST_PATH, null, p140me.bridgefy.backend.bgfyUserApi.model.BgfyUser.class);
                this.phone = (String) Preconditions.checkNotNull(str, "Required parameter phone must be specified.");
            }

            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            public GetUserFromPhone setAlt(String str) {
                return (GetUserFromPhone) super.setAlt(str);
            }

            public GetUserFromPhone setFields(String str) {
                return (GetUserFromPhone) super.setFields(str);
            }

            public GetUserFromPhone setKey(String str) {
                return (GetUserFromPhone) super.setKey(str);
            }

            public GetUserFromPhone setOauthToken(String str) {
                return (GetUserFromPhone) super.setOauthToken(str);
            }

            public GetUserFromPhone setPrettyPrint(Boolean bool) {
                return (GetUserFromPhone) super.setPrettyPrint(bool);
            }

            public GetUserFromPhone setQuotaUser(String str) {
                return (GetUserFromPhone) super.setQuotaUser(str);
            }

            public GetUserFromPhone setUserIp(String str) {
                return (GetUserFromPhone) super.setUserIp(str);
            }

            public String getPhone() {
                return this.phone;
            }

            public GetUserFromPhone setPhone(String str) {
                this.phone = str;
                return this;
            }

            public GetUserFromPhone set(String str, Object obj) {
                return (GetUserFromPhone) super.set(str, obj);
            }
        }

        /* renamed from: me.bridgefy.backend.bgfyUserApi.BgfyUserApi$BgfyUser$InsertUser */
        public class InsertUser extends BgfyUserApiRequest<p140me.bridgefy.backend.bgfyUserApi.model.BgfyUser> {
            private static final String REST_PATH = "bgfyuser";

            protected InsertUser(p140me.bridgefy.backend.bgfyUserApi.model.BgfyUser bgfyUser) {
                super(BgfyUserApi.this, HttpMethods.POST, REST_PATH, bgfyUser, p140me.bridgefy.backend.bgfyUserApi.model.BgfyUser.class);
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

        /* renamed from: me.bridgefy.backend.bgfyUserApi.BgfyUserApi$BgfyUser$ListUsers */
        public class ListUsers extends BgfyUserApiRequest<CollectionResponseBgfyUser> {
            private static final String REST_PATH = "bgfyuser";
            @Key
            private String cursor;
            @Key
            private Integer limit;

            protected ListUsers() {
                super(BgfyUserApi.this, HttpMethods.GET, REST_PATH, null, CollectionResponseBgfyUser.class);
            }

            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            public ListUsers setAlt(String str) {
                return (ListUsers) super.setAlt(str);
            }

            public ListUsers setFields(String str) {
                return (ListUsers) super.setFields(str);
            }

            public ListUsers setKey(String str) {
                return (ListUsers) super.setKey(str);
            }

            public ListUsers setOauthToken(String str) {
                return (ListUsers) super.setOauthToken(str);
            }

            public ListUsers setPrettyPrint(Boolean bool) {
                return (ListUsers) super.setPrettyPrint(bool);
            }

            public ListUsers setQuotaUser(String str) {
                return (ListUsers) super.setQuotaUser(str);
            }

            public ListUsers setUserIp(String str) {
                return (ListUsers) super.setUserIp(str);
            }

            public String getCursor() {
                return this.cursor;
            }

            public ListUsers setCursor(String str) {
                this.cursor = str;
                return this;
            }

            public Integer getLimit() {
                return this.limit;
            }

            public ListUsers setLimit(Integer num) {
                this.limit = num;
                return this;
            }

            public ListUsers set(String str, Object obj) {
                return (ListUsers) super.set(str, obj);
            }
        }

        /* renamed from: me.bridgefy.backend.bgfyUserApi.BgfyUserApi$BgfyUser$RemoveUser */
        public class RemoveUser extends BgfyUserApiRequest<Void> {
            private static final String REST_PATH = "bgfyUser/{uuid}";
            @Key
            private String uuid;

            protected RemoveUser(String str) {
                super(BgfyUserApi.this, HttpMethods.DELETE, REST_PATH, null, Void.class);
                this.uuid = (String) Preconditions.checkNotNull(str, "Required parameter uuid must be specified.");
            }

            public RemoveUser setAlt(String str) {
                return (RemoveUser) super.setAlt(str);
            }

            public RemoveUser setFields(String str) {
                return (RemoveUser) super.setFields(str);
            }

            public RemoveUser setKey(String str) {
                return (RemoveUser) super.setKey(str);
            }

            public RemoveUser setOauthToken(String str) {
                return (RemoveUser) super.setOauthToken(str);
            }

            public RemoveUser setPrettyPrint(Boolean bool) {
                return (RemoveUser) super.setPrettyPrint(bool);
            }

            public RemoveUser setQuotaUser(String str) {
                return (RemoveUser) super.setQuotaUser(str);
            }

            public RemoveUser setUserIp(String str) {
                return (RemoveUser) super.setUserIp(str);
            }

            public String getUuid() {
                return this.uuid;
            }

            public RemoveUser setUuid(String str) {
                this.uuid = str;
                return this;
            }

            public RemoveUser set(String str, Object obj) {
                return (RemoveUser) super.set(str, obj);
            }
        }

        /* renamed from: me.bridgefy.backend.bgfyUserApi.BgfyUserApi$BgfyUser$UnblockUser */
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

        /* renamed from: me.bridgefy.backend.bgfyUserApi.BgfyUserApi$BgfyUser$UpdateUser */
        public class UpdateUser extends BgfyUserApiRequest<p140me.bridgefy.backend.bgfyUserApi.model.BgfyUser> {
            private static final String REST_PATH = "bgfyUser/{uuid}";
            @Key
            private String uuid;

            protected UpdateUser(String str, p140me.bridgefy.backend.bgfyUserApi.model.BgfyUser bgfyUser) {
                super(BgfyUserApi.this, HttpMethods.PUT, REST_PATH, bgfyUser, p140me.bridgefy.backend.bgfyUserApi.model.BgfyUser.class);
                this.uuid = (String) Preconditions.checkNotNull(str, "Required parameter uuid must be specified.");
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

            public String getUuid() {
                return this.uuid;
            }

            public UpdateUser setUuid(String str) {
                this.uuid = str;
                return this;
            }

            public UpdateUser set(String str, Object obj) {
                return (UpdateUser) super.set(str, obj);
            }
        }

        public BgfyUser() {
        }

        public BlockUser blockUser(String str) throws IOException {
            BlockUser blockUser = new BlockUser(str);
            BgfyUserApi.this.initialize(blockUser);
            return blockUser;
        }

        public GetUser getUser(String str) throws IOException {
            GetUser getUser = new GetUser(str);
            BgfyUserApi.this.initialize(getUser);
            return getUser;
        }

        public GetUserFromPhone getUserFromPhone(String str) throws IOException {
            GetUserFromPhone getUserFromPhone = new GetUserFromPhone(str);
            BgfyUserApi.this.initialize(getUserFromPhone);
            return getUserFromPhone;
        }

        public InsertUser insertUser(p140me.bridgefy.backend.bgfyUserApi.model.BgfyUser bgfyUser) throws IOException {
            InsertUser insertUser = new InsertUser(bgfyUser);
            BgfyUserApi.this.initialize(insertUser);
            return insertUser;
        }

        public ListUsers listUsers() throws IOException {
            ListUsers listUsers = new ListUsers();
            BgfyUserApi.this.initialize(listUsers);
            return listUsers;
        }

        public RemoveUser removeUser(String str) throws IOException {
            RemoveUser removeUser = new RemoveUser(str);
            BgfyUserApi.this.initialize(removeUser);
            return removeUser;
        }

        public UnblockUser unblockUser(String str) throws IOException {
            UnblockUser unblockUser = new UnblockUser(str);
            BgfyUserApi.this.initialize(unblockUser);
            return unblockUser;
        }

        public UpdateUser updateUser(String str, p140me.bridgefy.backend.bgfyUserApi.model.BgfyUser bgfyUser) throws IOException {
            UpdateUser updateUser = new UpdateUser(str, bgfyUser);
            BgfyUserApi.this.initialize(updateUser);
            return updateUser;
        }
    }

    /* renamed from: me.bridgefy.backend.bgfyUserApi.BgfyUserApi$Builder */
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

    /* renamed from: me.bridgefy.backend.bgfyUserApi.BgfyUserApi$Contacts */
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
