package p140me.bridgefy.backend.p143v3.bgfyUserApi;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: me.bridgefy.backend.v3.bgfyUserApi.BgfyUserApiScopes */
public class BgfyUserApiScopes {
    public static final String USERINFO_EMAIL = "https://www.googleapis.com/auth/userinfo.email";

    public static Set<String> all() {
        HashSet hashSet = new HashSet();
        hashSet.add("https://www.googleapis.com/auth/userinfo.email");
        return Collections.unmodifiableSet(hashSet);
    }

    private BgfyUserApiScopes() {
    }
}