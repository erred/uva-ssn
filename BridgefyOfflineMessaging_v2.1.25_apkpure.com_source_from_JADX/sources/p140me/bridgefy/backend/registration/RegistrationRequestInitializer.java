package p140me.bridgefy.backend.registration;

import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest;
import com.google.api.client.googleapis.services.json.CommonGoogleJsonClientRequestInitializer;
import java.io.IOException;

/* renamed from: me.bridgefy.backend.registration.RegistrationRequestInitializer */
public class RegistrationRequestInitializer extends CommonGoogleJsonClientRequestInitializer {
    /* access modifiers changed from: protected */
    public void initializeRegistrationRequest(RegistrationRequest<?> registrationRequest) throws IOException {
    }

    public RegistrationRequestInitializer() {
    }

    public RegistrationRequestInitializer(String str) {
        super(str);
    }

    public RegistrationRequestInitializer(String str, String str2) {
        super(str, str2);
    }

    public final void initializeJsonRequest(AbstractGoogleJsonClientRequest<?> abstractGoogleJsonClientRequest) throws IOException {
        super.initializeJsonRequest(abstractGoogleJsonClientRequest);
        initializeRegistrationRequest((RegistrationRequest) abstractGoogleJsonClientRequest);
    }
}
