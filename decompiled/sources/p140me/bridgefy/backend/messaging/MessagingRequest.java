package p140me.bridgefy.backend.messaging;

import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.util.Key;

/* renamed from: me.bridgefy.backend.messaging.MessagingRequest */
public abstract class MessagingRequest<T> extends AbstractGoogleJsonClientRequest<T> {
    @Key
    private String alt;
    @Key
    private String fields;
    @Key
    private String key;
    @Key("oauth_token")
    private String oauthToken;
    @Key
    private Boolean prettyPrint;
    @Key
    private String quotaUser;
    @Key
    private String userIp;

    public MessagingRequest(Messaging messaging, String str, String str2, Object obj, Class<T> cls) {
        super(messaging, str, str2, obj, cls);
    }

    public String getAlt() {
        return this.alt;
    }

    public MessagingRequest<T> setAlt(String str) {
        this.alt = str;
        return this;
    }

    public String getFields() {
        return this.fields;
    }

    public MessagingRequest<T> setFields(String str) {
        this.fields = str;
        return this;
    }

    public String getKey() {
        return this.key;
    }

    public MessagingRequest<T> setKey(String str) {
        this.key = str;
        return this;
    }

    public String getOauthToken() {
        return this.oauthToken;
    }

    public MessagingRequest<T> setOauthToken(String str) {
        this.oauthToken = str;
        return this;
    }

    public Boolean getPrettyPrint() {
        return this.prettyPrint;
    }

    public MessagingRequest<T> setPrettyPrint(Boolean bool) {
        this.prettyPrint = bool;
        return this;
    }

    public String getQuotaUser() {
        return this.quotaUser;
    }

    public MessagingRequest<T> setQuotaUser(String str) {
        this.quotaUser = str;
        return this;
    }

    public String getUserIp() {
        return this.userIp;
    }

    public MessagingRequest<T> setUserIp(String str) {
        this.userIp = str;
        return this;
    }

    public final Messaging getAbstractGoogleClient() {
        return (Messaging) super.getAbstractGoogleClient();
    }

    public MessagingRequest<T> setDisableGZipContent(boolean z) {
        return (MessagingRequest) super.setDisableGZipContent(z);
    }

    public MessagingRequest<T> setRequestHeaders(HttpHeaders httpHeaders) {
        return (MessagingRequest) super.setRequestHeaders(httpHeaders);
    }

    public MessagingRequest<T> set(String str, Object obj) {
        return (MessagingRequest) super.set(str, obj);
    }
}