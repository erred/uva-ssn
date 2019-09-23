package p140me.bridgefy.backend.registration;

import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.util.Key;

/* renamed from: me.bridgefy.backend.registration.RegistrationRequest */
public abstract class RegistrationRequest<T> extends AbstractGoogleJsonClientRequest<T> {
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

    public RegistrationRequest(Registration registration, String str, String str2, Object obj, Class<T> cls) {
        super(registration, str, str2, obj, cls);
    }

    public String getAlt() {
        return this.alt;
    }

    public RegistrationRequest<T> setAlt(String str) {
        this.alt = str;
        return this;
    }

    public String getFields() {
        return this.fields;
    }

    public RegistrationRequest<T> setFields(String str) {
        this.fields = str;
        return this;
    }

    public String getKey() {
        return this.key;
    }

    public RegistrationRequest<T> setKey(String str) {
        this.key = str;
        return this;
    }

    public String getOauthToken() {
        return this.oauthToken;
    }

    public RegistrationRequest<T> setOauthToken(String str) {
        this.oauthToken = str;
        return this;
    }

    public Boolean getPrettyPrint() {
        return this.prettyPrint;
    }

    public RegistrationRequest<T> setPrettyPrint(Boolean bool) {
        this.prettyPrint = bool;
        return this;
    }

    public String getQuotaUser() {
        return this.quotaUser;
    }

    public RegistrationRequest<T> setQuotaUser(String str) {
        this.quotaUser = str;
        return this;
    }

    public String getUserIp() {
        return this.userIp;
    }

    public RegistrationRequest<T> setUserIp(String str) {
        this.userIp = str;
        return this;
    }

    public final Registration getAbstractGoogleClient() {
        return (Registration) super.getAbstractGoogleClient();
    }

    public RegistrationRequest<T> setDisableGZipContent(boolean z) {
        return (RegistrationRequest) super.setDisableGZipContent(z);
    }

    public RegistrationRequest<T> setRequestHeaders(HttpHeaders httpHeaders) {
        return (RegistrationRequest) super.setRequestHeaders(httpHeaders);
    }

    public RegistrationRequest<T> set(String str, Object obj) {
        return (RegistrationRequest) super.set(str, obj);
    }
}
