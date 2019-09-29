package p140me.bridgefy.backend.bgfyUserApi;

import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.util.Key;

/* renamed from: me.bridgefy.backend.bgfyUserApi.BgfyUserApiRequest */
public abstract class BgfyUserApiRequest<T> extends AbstractGoogleJsonClientRequest<T> {
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

    public BgfyUserApiRequest(BgfyUserApi bgfyUserApi, String str, String str2, Object obj, Class<T> cls) {
        super(bgfyUserApi, str, str2, obj, cls);
    }

    public String getAlt() {
        return this.alt;
    }

    public BgfyUserApiRequest<T> setAlt(String str) {
        this.alt = str;
        return this;
    }

    public String getFields() {
        return this.fields;
    }

    public BgfyUserApiRequest<T> setFields(String str) {
        this.fields = str;
        return this;
    }

    public String getKey() {
        return this.key;
    }

    public BgfyUserApiRequest<T> setKey(String str) {
        this.key = str;
        return this;
    }

    public String getOauthToken() {
        return this.oauthToken;
    }

    public BgfyUserApiRequest<T> setOauthToken(String str) {
        this.oauthToken = str;
        return this;
    }

    public Boolean getPrettyPrint() {
        return this.prettyPrint;
    }

    public BgfyUserApiRequest<T> setPrettyPrint(Boolean bool) {
        this.prettyPrint = bool;
        return this;
    }

    public String getQuotaUser() {
        return this.quotaUser;
    }

    public BgfyUserApiRequest<T> setQuotaUser(String str) {
        this.quotaUser = str;
        return this;
    }

    public String getUserIp() {
        return this.userIp;
    }

    public BgfyUserApiRequest<T> setUserIp(String str) {
        this.userIp = str;
        return this;
    }

    public final BgfyUserApi getAbstractGoogleClient() {
        return (BgfyUserApi) super.getAbstractGoogleClient();
    }

    public BgfyUserApiRequest<T> setDisableGZipContent(boolean z) {
        return (BgfyUserApiRequest) super.setDisableGZipContent(z);
    }

    public BgfyUserApiRequest<T> setRequestHeaders(HttpHeaders httpHeaders) {
        return (BgfyUserApiRequest) super.setRequestHeaders(httpHeaders);
    }

    public BgfyUserApiRequest<T> set(String str, Object obj) {
        return (BgfyUserApiRequest) super.set(str, obj);
    }
}
