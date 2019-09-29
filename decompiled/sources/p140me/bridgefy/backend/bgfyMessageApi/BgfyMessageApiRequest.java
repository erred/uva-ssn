package p140me.bridgefy.backend.bgfyMessageApi;

import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.util.Key;

/* renamed from: me.bridgefy.backend.bgfyMessageApi.BgfyMessageApiRequest */
public abstract class BgfyMessageApiRequest<T> extends AbstractGoogleJsonClientRequest<T> {
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

    public BgfyMessageApiRequest(BgfyMessageApi bgfyMessageApi, String str, String str2, Object obj, Class<T> cls) {
        super(bgfyMessageApi, str, str2, obj, cls);
    }

    public String getAlt() {
        return this.alt;
    }

    public BgfyMessageApiRequest<T> setAlt(String str) {
        this.alt = str;
        return this;
    }

    public String getFields() {
        return this.fields;
    }

    public BgfyMessageApiRequest<T> setFields(String str) {
        this.fields = str;
        return this;
    }

    public String getKey() {
        return this.key;
    }

    public BgfyMessageApiRequest<T> setKey(String str) {
        this.key = str;
        return this;
    }

    public String getOauthToken() {
        return this.oauthToken;
    }

    public BgfyMessageApiRequest<T> setOauthToken(String str) {
        this.oauthToken = str;
        return this;
    }

    public Boolean getPrettyPrint() {
        return this.prettyPrint;
    }

    public BgfyMessageApiRequest<T> setPrettyPrint(Boolean bool) {
        this.prettyPrint = bool;
        return this;
    }

    public String getQuotaUser() {
        return this.quotaUser;
    }

    public BgfyMessageApiRequest<T> setQuotaUser(String str) {
        this.quotaUser = str;
        return this;
    }

    public String getUserIp() {
        return this.userIp;
    }

    public BgfyMessageApiRequest<T> setUserIp(String str) {
        this.userIp = str;
        return this;
    }

    public final BgfyMessageApi getAbstractGoogleClient() {
        return (BgfyMessageApi) super.getAbstractGoogleClient();
    }

    public BgfyMessageApiRequest<T> setDisableGZipContent(boolean z) {
        return (BgfyMessageApiRequest) super.setDisableGZipContent(z);
    }

    public BgfyMessageApiRequest<T> setRequestHeaders(HttpHeaders httpHeaders) {
        return (BgfyMessageApiRequest) super.setRequestHeaders(httpHeaders);
    }

    public BgfyMessageApiRequest<T> set(String str, Object obj) {
        return (BgfyMessageApiRequest) super.set(str, obj);
    }
}
