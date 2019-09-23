package p140me.bridgefy.backend.p143v3.bgfyUserApi;

import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest;
import com.google.api.client.googleapis.services.json.CommonGoogleJsonClientRequestInitializer;
import java.io.IOException;

/* renamed from: me.bridgefy.backend.v3.bgfyUserApi.BgfyUserApiRequestInitializer */
public class BgfyUserApiRequestInitializer extends CommonGoogleJsonClientRequestInitializer {
    /* access modifiers changed from: protected */
    public void initializeBgfyUserApiRequest(BgfyUserApiRequest<?> bgfyUserApiRequest) throws IOException {
    }

    public BgfyUserApiRequestInitializer() {
    }

    public BgfyUserApiRequestInitializer(String str) {
        super(str);
    }

    public BgfyUserApiRequestInitializer(String str, String str2) {
        super(str, str2);
    }

    public final void initializeJsonRequest(AbstractGoogleJsonClientRequest<?> abstractGoogleJsonClientRequest) throws IOException {
        super.initializeJsonRequest(abstractGoogleJsonClientRequest);
        initializeBgfyUserApiRequest((BgfyUserApiRequest) abstractGoogleJsonClientRequest);
    }
}
