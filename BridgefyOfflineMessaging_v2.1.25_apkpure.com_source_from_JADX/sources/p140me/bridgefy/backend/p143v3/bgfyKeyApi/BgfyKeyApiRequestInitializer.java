package p140me.bridgefy.backend.p143v3.bgfyKeyApi;

import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest;
import com.google.api.client.googleapis.services.json.CommonGoogleJsonClientRequestInitializer;
import java.io.IOException;

/* renamed from: me.bridgefy.backend.v3.bgfyKeyApi.BgfyKeyApiRequestInitializer */
public class BgfyKeyApiRequestInitializer extends CommonGoogleJsonClientRequestInitializer {
    /* access modifiers changed from: protected */
    public void initializeBgfyKeyApiRequest(BgfyKeyApiRequest<?> bgfyKeyApiRequest) throws IOException {
    }

    public BgfyKeyApiRequestInitializer() {
    }

    public BgfyKeyApiRequestInitializer(String str) {
        super(str);
    }

    public BgfyKeyApiRequestInitializer(String str, String str2) {
        super(str, str2);
    }

    public final void initializeJsonRequest(AbstractGoogleJsonClientRequest<?> abstractGoogleJsonClientRequest) throws IOException {
        super.initializeJsonRequest(abstractGoogleJsonClientRequest);
        initializeBgfyKeyApiRequest((BgfyKeyApiRequest) abstractGoogleJsonClientRequest);
    }
}
