package p140me.bridgefy.cloud;

import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

/* renamed from: me.bridgefy.cloud.-$$Lambda$a$P1w-EO3iL2f48GEPXNfzBAbRwe8 reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$a$P1wEO3iL2f48GEPXNfzBAbRwe8 implements GoogleClientRequestInitializer {
    public static final /* synthetic */ $$Lambda$a$P1wEO3iL2f48GEPXNfzBAbRwe8 INSTANCE = new $$Lambda$a$P1wEO3iL2f48GEPXNfzBAbRwe8();

    private /* synthetic */ $$Lambda$a$P1wEO3iL2f48GEPXNfzBAbRwe8() {
    }

    public final void initialize(AbstractGoogleClientRequest abstractGoogleClientRequest) {
        abstractGoogleClientRequest.setDisableGZipContent(true);
    }
}
