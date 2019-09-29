package p140me.bridgefy.backend.p143v3.bgfyMessageApi;

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
import p140me.bridgefy.backend.p143v3.bgfyMessageApi.model.BgfyMessage;
import p140me.bridgefy.backend.p143v3.bgfyMessageApi.model.BgfyMessageCollection;
import p140me.bridgefy.backend.p143v3.bgfyMessageApi.model.BgfyUserCollection;
import p140me.bridgefy.backend.p143v3.bgfyMessageApi.model.BlockMessageResponse;
import p140me.bridgefy.backend.p143v3.bgfyMessageApi.model.CollectionResponseBgfyMessage;
import p140me.bridgefy.backend.p143v3.bgfyMessageApi.model.EndpointConversationListContainer;
import p140me.bridgefy.backend.p143v3.bgfyMessageApi.model.EndpointMessageContainer;
import p140me.bridgefy.backend.p143v3.bgfyMessageApi.model.EndpointMessageListContainer;
import p140me.bridgefy.backend.p143v3.bgfyMessageApi.model.EndpointMessageResponse;

/* renamed from: me.bridgefy.backend.v3.bgfyMessageApi.BgfyMessageApi */
public class BgfyMessageApi extends AbstractGoogleJsonClient {
    public static final String DEFAULT_BASE_URL = "https://bionic-armando.appspot.com/_ah/api/bgfyMessageApi/v3/";
    public static final String DEFAULT_BATCH_PATH = "batch";
    public static final String DEFAULT_ROOT_URL = "https://bionic-armando.appspot.com/_ah/api/";
    public static final String DEFAULT_SERVICE_PATH = "bgfyMessageApi/v3/";

    /* renamed from: me.bridgefy.backend.v3.bgfyMessageApi.BgfyMessageApi$BlockMessage */
    public class BlockMessage extends BgfyMessageApiRequest<BlockMessageResponse> {
        private static final String REST_PATH = "bgfyMessage/report/{messageId}";
        @Key
        private String message;
        @Key
        private Long messageId;
        @Key
        private Integer reasonId;
        @Key
        private String sender;

        protected BlockMessage(Long l, String str, Integer num) {
            super(BgfyMessageApi.this, HttpMethods.GET, REST_PATH, null, BlockMessageResponse.class);
            this.messageId = (Long) Preconditions.checkNotNull(l, "Required parameter messageId must be specified.");
            this.sender = (String) Preconditions.checkNotNull(str, "Required parameter sender must be specified.");
            this.reasonId = (Integer) Preconditions.checkNotNull(num, "Required parameter reasonId must be specified.");
        }

        public HttpResponse executeUsingHead() throws IOException {
            return super.executeUsingHead();
        }

        public HttpRequest buildHttpRequestUsingHead() throws IOException {
            return super.buildHttpRequestUsingHead();
        }

        public BlockMessage setAlt(String str) {
            return (BlockMessage) super.setAlt(str);
        }

        public BlockMessage setFields(String str) {
            return (BlockMessage) super.setFields(str);
        }

        public BlockMessage setKey(String str) {
            return (BlockMessage) super.setKey(str);
        }

        public BlockMessage setOauthToken(String str) {
            return (BlockMessage) super.setOauthToken(str);
        }

        public BlockMessage setPrettyPrint(Boolean bool) {
            return (BlockMessage) super.setPrettyPrint(bool);
        }

        public BlockMessage setQuotaUser(String str) {
            return (BlockMessage) super.setQuotaUser(str);
        }

        public BlockMessage setUserIp(String str) {
            return (BlockMessage) super.setUserIp(str);
        }

        public Long getMessageId() {
            return this.messageId;
        }

        public BlockMessage setMessageId(Long l) {
            this.messageId = l;
            return this;
        }

        public String getSender() {
            return this.sender;
        }

        public BlockMessage setSender(String str) {
            this.sender = str;
            return this;
        }

        public Integer getReasonId() {
            return this.reasonId;
        }

        public BlockMessage setReasonId(Integer num) {
            this.reasonId = num;
            return this;
        }

        public String getMessage() {
            return this.message;
        }

        public BlockMessage setMessage(String str) {
            this.message = str;
            return this;
        }

        public BlockMessage set(String str, Object obj) {
            return (BlockMessage) super.set(str, obj);
        }
    }

    /* renamed from: me.bridgefy.backend.v3.bgfyMessageApi.BgfyMessageApi$Builder */
    public static final class Builder extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder {
        public Builder(HttpTransport httpTransport, JsonFactory jsonFactory, HttpRequestInitializer httpRequestInitializer) {
            super(httpTransport, jsonFactory, "https://bionic-armando.appspot.com/_ah/api/", BgfyMessageApi.DEFAULT_SERVICE_PATH, httpRequestInitializer, false);
            setBatchPath("batch");
        }

        public BgfyMessageApi build() {
            return new BgfyMessageApi(this);
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

        public Builder setBgfyMessageApiRequestInitializer(BgfyMessageApiRequestInitializer bgfyMessageApiRequestInitializer) {
            return (Builder) super.setGoogleClientRequestInitializer((GoogleClientRequestInitializer) bgfyMessageApiRequestInitializer);
        }

        public Builder setGoogleClientRequestInitializer(GoogleClientRequestInitializer googleClientRequestInitializer) {
            return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
        }
    }

    /* renamed from: me.bridgefy.backend.v3.bgfyMessageApi.BgfyMessageApi$DeleteConversation */
    public class DeleteConversation extends BgfyMessageApiRequest<Void> {
        private static final String REST_PATH = "conversation/{receiver}/{sender}";
        @Key
        private String receiver;
        @Key
        private String sender;

        protected DeleteConversation(String str, String str2) {
            super(BgfyMessageApi.this, HttpMethods.DELETE, REST_PATH, null, Void.class);
            this.receiver = (String) Preconditions.checkNotNull(str, "Required parameter receiver must be specified.");
            this.sender = (String) Preconditions.checkNotNull(str2, "Required parameter sender must be specified.");
        }

        public DeleteConversation setAlt(String str) {
            return (DeleteConversation) super.setAlt(str);
        }

        public DeleteConversation setFields(String str) {
            return (DeleteConversation) super.setFields(str);
        }

        public DeleteConversation setKey(String str) {
            return (DeleteConversation) super.setKey(str);
        }

        public DeleteConversation setOauthToken(String str) {
            return (DeleteConversation) super.setOauthToken(str);
        }

        public DeleteConversation setPrettyPrint(Boolean bool) {
            return (DeleteConversation) super.setPrettyPrint(bool);
        }

        public DeleteConversation setQuotaUser(String str) {
            return (DeleteConversation) super.setQuotaUser(str);
        }

        public DeleteConversation setUserIp(String str) {
            return (DeleteConversation) super.setUserIp(str);
        }

        public String getReceiver() {
            return this.receiver;
        }

        public DeleteConversation setReceiver(String str) {
            this.receiver = str;
            return this;
        }

        public String getSender() {
            return this.sender;
        }

        public DeleteConversation setSender(String str) {
            this.sender = str;
            return this;
        }

        public DeleteConversation set(String str, Object obj) {
            return (DeleteConversation) super.set(str, obj);
        }
    }

    /* renamed from: me.bridgefy.backend.v3.bgfyMessageApi.BgfyMessageApi$Get */
    public class Get extends BgfyMessageApiRequest<BgfyMessage> {
        private static final String REST_PATH = "bgfyMessage/{messageId}";
        @Key
        private Long messageId;

        protected Get(Long l) {
            super(BgfyMessageApi.this, HttpMethods.GET, REST_PATH, null, BgfyMessage.class);
            this.messageId = (Long) Preconditions.checkNotNull(l, "Required parameter messageId must be specified.");
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

        public Long getMessageId() {
            return this.messageId;
        }

        public Get setMessageId(Long l) {
            this.messageId = l;
            return this;
        }

        public Get set(String str, Object obj) {
            return (Get) super.set(str, obj);
        }
    }

    /* renamed from: me.bridgefy.backend.v3.bgfyMessageApi.BgfyMessageApi$GetConversation */
    public class GetConversation extends BgfyMessageApiRequest<CollectionResponseBgfyMessage> {
        private static final String REST_PATH = "bgfyMessage/conversation";
        @Key
        private String cursor;
        @Key
        private Long dateSent;
        @Key
        private Integer limit;
        @Key
        private String receiverId;
        @Key
        private String senderId;

        protected GetConversation(String str, Long l) {
            super(BgfyMessageApi.this, HttpMethods.GET, REST_PATH, null, CollectionResponseBgfyMessage.class);
            this.receiverId = (String) Preconditions.checkNotNull(str, "Required parameter receiverId must be specified.");
            this.dateSent = (Long) Preconditions.checkNotNull(l, "Required parameter dateSent must be specified.");
        }

        public HttpResponse executeUsingHead() throws IOException {
            return super.executeUsingHead();
        }

        public HttpRequest buildHttpRequestUsingHead() throws IOException {
            return super.buildHttpRequestUsingHead();
        }

        public GetConversation setAlt(String str) {
            return (GetConversation) super.setAlt(str);
        }

        public GetConversation setFields(String str) {
            return (GetConversation) super.setFields(str);
        }

        public GetConversation setKey(String str) {
            return (GetConversation) super.setKey(str);
        }

        public GetConversation setOauthToken(String str) {
            return (GetConversation) super.setOauthToken(str);
        }

        public GetConversation setPrettyPrint(Boolean bool) {
            return (GetConversation) super.setPrettyPrint(bool);
        }

        public GetConversation setQuotaUser(String str) {
            return (GetConversation) super.setQuotaUser(str);
        }

        public GetConversation setUserIp(String str) {
            return (GetConversation) super.setUserIp(str);
        }

        public String getCursor() {
            return this.cursor;
        }

        public GetConversation setCursor(String str) {
            this.cursor = str;
            return this;
        }

        public Integer getLimit() {
            return this.limit;
        }

        public GetConversation setLimit(Integer num) {
            this.limit = num;
            return this;
        }

        public String getReceiverId() {
            return this.receiverId;
        }

        public GetConversation setReceiverId(String str) {
            this.receiverId = str;
            return this;
        }

        public String getSenderId() {
            return this.senderId;
        }

        public GetConversation setSenderId(String str) {
            this.senderId = str;
            return this;
        }

        public Long getDateSent() {
            return this.dateSent;
        }

        public GetConversation setDateSent(Long l) {
            this.dateSent = l;
            return this;
        }

        public GetConversation set(String str, Object obj) {
            return (GetConversation) super.set(str, obj);
        }
    }

    /* renamed from: me.bridgefy.backend.v3.bgfyMessageApi.BgfyMessageApi$GetImage */
    public class GetImage extends BgfyMessageApiRequest<BgfyMessage> {
        private static final String REST_PATH = "bgfyMessage/attach/{messageId}";
        @Key
        private Long messageId;

        protected GetImage(Long l) {
            super(BgfyMessageApi.this, HttpMethods.GET, REST_PATH, null, BgfyMessage.class);
            this.messageId = (Long) Preconditions.checkNotNull(l, "Required parameter messageId must be specified.");
        }

        public HttpResponse executeUsingHead() throws IOException {
            return super.executeUsingHead();
        }

        public HttpRequest buildHttpRequestUsingHead() throws IOException {
            return super.buildHttpRequestUsingHead();
        }

        public GetImage setAlt(String str) {
            return (GetImage) super.setAlt(str);
        }

        public GetImage setFields(String str) {
            return (GetImage) super.setFields(str);
        }

        public GetImage setKey(String str) {
            return (GetImage) super.setKey(str);
        }

        public GetImage setOauthToken(String str) {
            return (GetImage) super.setOauthToken(str);
        }

        public GetImage setPrettyPrint(Boolean bool) {
            return (GetImage) super.setPrettyPrint(bool);
        }

        public GetImage setQuotaUser(String str) {
            return (GetImage) super.setQuotaUser(str);
        }

        public GetImage setUserIp(String str) {
            return (GetImage) super.setUserIp(str);
        }

        public Long getMessageId() {
            return this.messageId;
        }

        public GetImage setMessageId(Long l) {
            this.messageId = l;
            return this;
        }

        public GetImage set(String str, Object obj) {
            return (GetImage) super.set(str, obj);
        }
    }

    /* renamed from: me.bridgefy.backend.v3.bgfyMessageApi.BgfyMessageApi$Insert */
    public class Insert extends BgfyMessageApiRequest<BgfyMessage> {
        private static final String REST_PATH = "bgfyMessage";
        @Key("checksum_key")
        private Long checksumKey;
        @Key
        private String mimeType;

        protected Insert(BgfyMessage bgfyMessage) {
            super(BgfyMessageApi.this, HttpMethods.POST, REST_PATH, bgfyMessage, BgfyMessage.class);
        }

        public Insert setAlt(String str) {
            return (Insert) super.setAlt(str);
        }

        public Insert setFields(String str) {
            return (Insert) super.setFields(str);
        }

        public Insert setKey(String str) {
            return (Insert) super.setKey(str);
        }

        public Insert setOauthToken(String str) {
            return (Insert) super.setOauthToken(str);
        }

        public Insert setPrettyPrint(Boolean bool) {
            return (Insert) super.setPrettyPrint(bool);
        }

        public Insert setQuotaUser(String str) {
            return (Insert) super.setQuotaUser(str);
        }

        public Insert setUserIp(String str) {
            return (Insert) super.setUserIp(str);
        }

        public String getMimeType() {
            return this.mimeType;
        }

        public Insert setMimeType(String str) {
            this.mimeType = str;
            return this;
        }

        public Long getChecksumKey() {
            return this.checksumKey;
        }

        public Insert setChecksumKey(Long l) {
            this.checksumKey = l;
            return this;
        }

        public Insert set(String str, Object obj) {
            return (Insert) super.set(str, obj);
        }
    }

    /* renamed from: me.bridgefy.backend.v3.bgfyMessageApi.BgfyMessageApi$InsertList */
    public class InsertList extends BgfyMessageApiRequest<EndpointMessageResponse> {
        private static final String REST_PATH = "bgfyMessage/list";

        protected InsertList(EndpointMessageContainer endpointMessageContainer) {
            super(BgfyMessageApi.this, HttpMethods.POST, REST_PATH, endpointMessageContainer, EndpointMessageResponse.class);
        }

        public InsertList setAlt(String str) {
            return (InsertList) super.setAlt(str);
        }

        public InsertList setFields(String str) {
            return (InsertList) super.setFields(str);
        }

        public InsertList setKey(String str) {
            return (InsertList) super.setKey(str);
        }

        public InsertList setOauthToken(String str) {
            return (InsertList) super.setOauthToken(str);
        }

        public InsertList setPrettyPrint(Boolean bool) {
            return (InsertList) super.setPrettyPrint(bool);
        }

        public InsertList setQuotaUser(String str) {
            return (InsertList) super.setQuotaUser(str);
        }

        public InsertList setUserIp(String str) {
            return (InsertList) super.setUserIp(str);
        }

        public InsertList set(String str, Object obj) {
            return (InsertList) super.set(str, obj);
        }
    }

    /* renamed from: me.bridgefy.backend.v3.bgfyMessageApi.BgfyMessageApi$LastMessageStatus */
    public class LastMessageStatus extends BgfyMessageApiRequest<BgfyMessage> {
        private static final String REST_PATH = "conversation/status";
        @Key
        private String receiver;
        @Key
        private Integer status;

        protected LastMessageStatus(Integer num, String str) {
            super(BgfyMessageApi.this, HttpMethods.POST, REST_PATH, null, BgfyMessage.class);
            this.status = (Integer) Preconditions.checkNotNull(num, "Required parameter status must be specified.");
            this.receiver = (String) Preconditions.checkNotNull(str, "Required parameter receiver must be specified.");
        }

        public LastMessageStatus setAlt(String str) {
            return (LastMessageStatus) super.setAlt(str);
        }

        public LastMessageStatus setFields(String str) {
            return (LastMessageStatus) super.setFields(str);
        }

        public LastMessageStatus setKey(String str) {
            return (LastMessageStatus) super.setKey(str);
        }

        public LastMessageStatus setOauthToken(String str) {
            return (LastMessageStatus) super.setOauthToken(str);
        }

        public LastMessageStatus setPrettyPrint(Boolean bool) {
            return (LastMessageStatus) super.setPrettyPrint(bool);
        }

        public LastMessageStatus setQuotaUser(String str) {
            return (LastMessageStatus) super.setQuotaUser(str);
        }

        public LastMessageStatus setUserIp(String str) {
            return (LastMessageStatus) super.setUserIp(str);
        }

        public Integer getStatus() {
            return this.status;
        }

        public LastMessageStatus setStatus(Integer num) {
            this.status = num;
            return this;
        }

        public String getReceiver() {
            return this.receiver;
        }

        public LastMessageStatus setReceiver(String str) {
            this.receiver = str;
            return this;
        }

        public LastMessageStatus set(String str, Object obj) {
            return (LastMessageStatus) super.set(str, obj);
        }
    }

    /* renamed from: me.bridgefy.backend.v3.bgfyMessageApi.BgfyMessageApi$List */
    public class List extends BgfyMessageApiRequest<CollectionResponseBgfyMessage> {
        private static final String REST_PATH = "bgfyMessage";
        @Key
        private String cursor;
        @Key
        private Integer limit;

        protected List() {
            super(BgfyMessageApi.this, HttpMethods.GET, REST_PATH, null, CollectionResponseBgfyMessage.class);
        }

        public HttpResponse executeUsingHead() throws IOException {
            return super.executeUsingHead();
        }

        public HttpRequest buildHttpRequestUsingHead() throws IOException {
            return super.buildHttpRequestUsingHead();
        }

        public List setAlt(String str) {
            return (List) super.setAlt(str);
        }

        public List setFields(String str) {
            return (List) super.setFields(str);
        }

        public List setKey(String str) {
            return (List) super.setKey(str);
        }

        public List setOauthToken(String str) {
            return (List) super.setOauthToken(str);
        }

        public List setPrettyPrint(Boolean bool) {
            return (List) super.setPrettyPrint(bool);
        }

        public List setQuotaUser(String str) {
            return (List) super.setQuotaUser(str);
        }

        public List setUserIp(String str) {
            return (List) super.setUserIp(str);
        }

        public String getCursor() {
            return this.cursor;
        }

        public List setCursor(String str) {
            this.cursor = str;
            return this;
        }

        public Integer getLimit() {
            return this.limit;
        }

        public List setLimit(Integer num) {
            this.limit = num;
            return this;
        }

        public List set(String str, Object obj) {
            return (List) super.set(str, obj);
        }
    }

    /* renamed from: me.bridgefy.backend.v3.bgfyMessageApi.BgfyMessageApi$Remove */
    public class Remove extends BgfyMessageApiRequest<Void> {
        private static final String REST_PATH = "bgfyMessage/{messageId}";
        @Key
        private Long messageId;

        protected Remove(Long l) {
            super(BgfyMessageApi.this, HttpMethods.DELETE, REST_PATH, null, Void.class);
            this.messageId = (Long) Preconditions.checkNotNull(l, "Required parameter messageId must be specified.");
        }

        public Remove setAlt(String str) {
            return (Remove) super.setAlt(str);
        }

        public Remove setFields(String str) {
            return (Remove) super.setFields(str);
        }

        public Remove setKey(String str) {
            return (Remove) super.setKey(str);
        }

        public Remove setOauthToken(String str) {
            return (Remove) super.setOauthToken(str);
        }

        public Remove setPrettyPrint(Boolean bool) {
            return (Remove) super.setPrettyPrint(bool);
        }

        public Remove setQuotaUser(String str) {
            return (Remove) super.setQuotaUser(str);
        }

        public Remove setUserIp(String str) {
            return (Remove) super.setUserIp(str);
        }

        public Long getMessageId() {
            return this.messageId;
        }

        public Remove setMessageId(Long l) {
            this.messageId = l;
            return this;
        }

        public Remove set(String str, Object obj) {
            return (Remove) super.set(str, obj);
        }
    }

    /* renamed from: me.bridgefy.backend.v3.bgfyMessageApi.BgfyMessageApi$Update */
    public class Update extends BgfyMessageApiRequest<BgfyMessage> {
        private static final String REST_PATH = "bgfyMessage/{messageId}";
        @Key
        private Long messageId;

        protected Update(Long l, BgfyMessage bgfyMessage) {
            super(BgfyMessageApi.this, HttpMethods.PUT, REST_PATH, bgfyMessage, BgfyMessage.class);
            this.messageId = (Long) Preconditions.checkNotNull(l, "Required parameter messageId must be specified.");
        }

        public Update setAlt(String str) {
            return (Update) super.setAlt(str);
        }

        public Update setFields(String str) {
            return (Update) super.setFields(str);
        }

        public Update setKey(String str) {
            return (Update) super.setKey(str);
        }

        public Update setOauthToken(String str) {
            return (Update) super.setOauthToken(str);
        }

        public Update setPrettyPrint(Boolean bool) {
            return (Update) super.setPrettyPrint(bool);
        }

        public Update setQuotaUser(String str) {
            return (Update) super.setQuotaUser(str);
        }

        public Update setUserIp(String str) {
            return (Update) super.setUserIp(str);
        }

        public Long getMessageId() {
            return this.messageId;
        }

        public Update setMessageId(Long l) {
            this.messageId = l;
            return this;
        }

        public Update set(String str, Object obj) {
            return (Update) super.set(str, obj);
        }
    }

    /* renamed from: me.bridgefy.backend.v3.bgfyMessageApi.BgfyMessageApi$UpdateConversation */
    public class UpdateConversation extends BgfyMessageApiRequest<BgfyUserCollection> {
        private static final String REST_PATH = "conversation/update";
        @Key
        private Integer status;

        protected UpdateConversation(Integer num, EndpointConversationListContainer endpointConversationListContainer) {
            super(BgfyMessageApi.this, HttpMethods.POST, REST_PATH, endpointConversationListContainer, BgfyUserCollection.class);
            this.status = (Integer) Preconditions.checkNotNull(num, "Required parameter status must be specified.");
        }

        public UpdateConversation setAlt(String str) {
            return (UpdateConversation) super.setAlt(str);
        }

        public UpdateConversation setFields(String str) {
            return (UpdateConversation) super.setFields(str);
        }

        public UpdateConversation setKey(String str) {
            return (UpdateConversation) super.setKey(str);
        }

        public UpdateConversation setOauthToken(String str) {
            return (UpdateConversation) super.setOauthToken(str);
        }

        public UpdateConversation setPrettyPrint(Boolean bool) {
            return (UpdateConversation) super.setPrettyPrint(bool);
        }

        public UpdateConversation setQuotaUser(String str) {
            return (UpdateConversation) super.setQuotaUser(str);
        }

        public UpdateConversation setUserIp(String str) {
            return (UpdateConversation) super.setUserIp(str);
        }

        public Integer getStatus() {
            return this.status;
        }

        public UpdateConversation setStatus(Integer num) {
            this.status = num;
            return this;
        }

        public UpdateConversation set(String str, Object obj) {
            return (UpdateConversation) super.set(str, obj);
        }
    }

    /* renamed from: me.bridgefy.backend.v3.bgfyMessageApi.BgfyMessageApi$UpdateStatusMessage */
    public class UpdateStatusMessage extends BgfyMessageApiRequest<BgfyMessageCollection> {
        private static final String REST_PATH = "bgfyMessage/updateStatus";

        protected UpdateStatusMessage(EndpointMessageListContainer endpointMessageListContainer) {
            super(BgfyMessageApi.this, HttpMethods.POST, REST_PATH, endpointMessageListContainer, BgfyMessageCollection.class);
        }

        public UpdateStatusMessage setAlt(String str) {
            return (UpdateStatusMessage) super.setAlt(str);
        }

        public UpdateStatusMessage setFields(String str) {
            return (UpdateStatusMessage) super.setFields(str);
        }

        public UpdateStatusMessage setKey(String str) {
            return (UpdateStatusMessage) super.setKey(str);
        }

        public UpdateStatusMessage setOauthToken(String str) {
            return (UpdateStatusMessage) super.setOauthToken(str);
        }

        public UpdateStatusMessage setPrettyPrint(Boolean bool) {
            return (UpdateStatusMessage) super.setPrettyPrint(bool);
        }

        public UpdateStatusMessage setQuotaUser(String str) {
            return (UpdateStatusMessage) super.setQuotaUser(str);
        }

        public UpdateStatusMessage setUserIp(String str) {
            return (UpdateStatusMessage) super.setUserIp(str);
        }

        public UpdateStatusMessage set(String str, Object obj) {
            return (UpdateStatusMessage) super.set(str, obj);
        }
    }

    static {
        Preconditions.checkState(GoogleUtils.MAJOR_VERSION.intValue() == 1 && GoogleUtils.MINOR_VERSION.intValue() >= 15, "You are currently running with version %s of google-api-client. You need at least version 1.15 of google-api-client to run version 1.25.0 of the bgfyMessageApi library.", GoogleUtils.VERSION);
    }

    public BgfyMessageApi(HttpTransport httpTransport, JsonFactory jsonFactory, HttpRequestInitializer httpRequestInitializer) {
        this(new Builder(httpTransport, jsonFactory, httpRequestInitializer));
    }

    BgfyMessageApi(Builder builder) {
        super(builder);
    }

    /* access modifiers changed from: protected */
    public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
        super.initialize(abstractGoogleClientRequest);
    }

    public BlockMessage blockMessage(Long l, String str, Integer num) throws IOException {
        BlockMessage blockMessage = new BlockMessage(l, str, num);
        initialize(blockMessage);
        return blockMessage;
    }

    public DeleteConversation deleteConversation(String str, String str2) throws IOException {
        DeleteConversation deleteConversation = new DeleteConversation(str, str2);
        initialize(deleteConversation);
        return deleteConversation;
    }

    public Get get(Long l) throws IOException {
        Get get = new Get(l);
        initialize(get);
        return get;
    }

    public GetConversation getConversation(String str, Long l) throws IOException {
        GetConversation getConversation = new GetConversation(str, l);
        initialize(getConversation);
        return getConversation;
    }

    public GetImage getImage(Long l) throws IOException {
        GetImage getImage = new GetImage(l);
        initialize(getImage);
        return getImage;
    }

    public Insert insert(BgfyMessage bgfyMessage) throws IOException {
        Insert insert = new Insert(bgfyMessage);
        initialize(insert);
        return insert;
    }

    public InsertList insertList(EndpointMessageContainer endpointMessageContainer) throws IOException {
        InsertList insertList = new InsertList(endpointMessageContainer);
        initialize(insertList);
        return insertList;
    }

    public LastMessageStatus lastMessageStatus(Integer num, String str) throws IOException {
        LastMessageStatus lastMessageStatus = new LastMessageStatus(num, str);
        initialize(lastMessageStatus);
        return lastMessageStatus;
    }

    public List list() throws IOException {
        List list = new List();
        initialize(list);
        return list;
    }

    public Remove remove(Long l) throws IOException {
        Remove remove = new Remove(l);
        initialize(remove);
        return remove;
    }

    public Update update(Long l, BgfyMessage bgfyMessage) throws IOException {
        Update update = new Update(l, bgfyMessage);
        initialize(update);
        return update;
    }

    public UpdateConversation updateConversation(Integer num, EndpointConversationListContainer endpointConversationListContainer) throws IOException {
        UpdateConversation updateConversation = new UpdateConversation(num, endpointConversationListContainer);
        initialize(updateConversation);
        return updateConversation;
    }

    public UpdateStatusMessage updateStatusMessage(EndpointMessageListContainer endpointMessageListContainer) throws IOException {
        UpdateStatusMessage updateStatusMessage = new UpdateStatusMessage(endpointMessageListContainer);
        initialize(updateStatusMessage);
        return updateStatusMessage;
    }
}
