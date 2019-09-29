package p140me.bridgefy.backend.bgfyKeyApi;

import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.util.Key;

/* renamed from: me.bridgefy.backend.bgfyKeyApi.BgfyKeyApiRequest */
public abstract class BgfyKeyApiRequest<T> extends AbstractGoogleJsonClientRequest<T> {
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

    public BgfyKeyApiRequest(BgfyKeyApi bgfyKeyApi, String str, String str2, Object obj, Class<T> cls) {
        super(bgfyKeyApi, str, str2, obj, cls);
    }

    public String getAlt() {
        return this.alt;
    }

    public BgfyKeyApiRequest<T> setAlt(String str) {
        this.alt = str;
        return this;
    }

    public String getFields() {
        return this.fields;
    }

    public BgfyKeyApiRequest<T> setFields(String str) {
        this.fields = str;
        return this;
    }

    public String getKey() {
        return this.key;
    }

    public BgfyKeyApiRequest<T> setKey(String str) {
        this.key = str;
        return this;
    }

    public String getOauthToken() {
        return this.oauthToken;
    }

    public BgfyKeyApiRequest<T> setOauthToken(String str) {
        this.oauthToken = str;
        return this;
    }

    public Boolean getPrettyPrint() {
        return this.prettyPrint;
    }

    public BgfyKeyApiRequest<T> setPrettyPrint(Boolean bool) {
        this.prettyPrint = bool;
        return this;
    }

    public String getQuotaUser() {
        return this.quotaUser;
    }

    public BgfyKeyApiRequest<T> setQuotaUser(String str) {
        this.quotaUser = str;
        return this;
    }

    public String getUserIp() {
        return this.userIp;
    }

    public BgfyKeyApiRequest<T> setUserIp(String str) {
        this.userIp = str;
        return this;
    }

    public final BgfyKeyApi getAbstractGoogleClient() {
        return (BgfyKeyApi) super.getAbstractGoogleClient();
    }

    public BgfyKeyApiRequest<T> setDisableGZipContent(boolean z) {
        return (BgfyKeyApiRequest) super.setDisableGZipContent(z);
    }

    public BgfyKeyApiRequest<T> setRequestHeaders(HttpHeaders httpHeaders) {
        return (BgfyKeyApiRequest) super.setRequestHeaders(httpHeaders);
    }

    public BgfyKeyApiRequest<T> set(String str, Object obj) {
        return (BgfyKeyApiRequest) super.set(str, obj);
    }
}
