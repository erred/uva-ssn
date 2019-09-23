package p140me.bridgefy.backend.p143v3.bgfyMessageApi;

import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest;
import com.google.api.client.googleapis.services.json.CommonGoogleJsonClientRequestInitializer;
import java.io.IOException;

/* renamed from: me.bridgefy.backend.v3.bgfyMessageApi.BgfyMessageApiRequestInitializer */
public class BgfyMessageApiRequestInitializer extends CommonGoogleJsonClientRequestInitializer {
    /* access modifiers changed from: protected */
    public void initializeBgfyMessageApiRequest(BgfyMessageApiRequest<?> bgfyMessageApiRequest) throws IOException {
    }

    public BgfyMessageApiRequestInitializer() {
    }

    public BgfyMessageApiRequestInitializer(String str) {
        super(str);
    }

    public BgfyMessageApiRequestInitializer(String str, String str2) {
        super(str, str2);
    }

    public final void initializeJsonRequest(AbstractGoogleJsonClientRequest<?> abstractGoogleJsonClientRequest) throws IOException {
        super.initializeJsonRequest(abstractGoogleJsonClientRequest);
        initializeBgfyMessageApiRequest((BgfyMessageApiRequest) abstractGoogleJsonClientRequest);
    }
}
