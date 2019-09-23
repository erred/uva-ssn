package p140me.bridgefy.backend.messaging;

import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest;
import com.google.api.client.googleapis.services.json.CommonGoogleJsonClientRequestInitializer;
import java.io.IOException;

/* renamed from: me.bridgefy.backend.messaging.MessagingRequestInitializer */
public class MessagingRequestInitializer extends CommonGoogleJsonClientRequestInitializer {
    /* access modifiers changed from: protected */
    public void initializeMessagingRequest(MessagingRequest<?> messagingRequest) throws IOException {
    }

    public MessagingRequestInitializer() {
    }

    public MessagingRequestInitializer(String str) {
        super(str);
    }

    public MessagingRequestInitializer(String str, String str2) {
        super(str, str2);
    }

    public final void initializeJsonRequest(AbstractGoogleJsonClientRequest<?> abstractGoogleJsonClientRequest) throws IOException {
        super.initializeJsonRequest(abstractGoogleJsonClientRequest);
        initializeMessagingRequest((MessagingRequest) abstractGoogleJsonClientRequest);
    }
}
