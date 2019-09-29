package p140me.bridgefy.backend.registration.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* renamed from: me.bridgefy.backend.registration.model.RegistrationRecord */
public final class RegistrationRecord extends GenericJson {
    @Key
    private String regId;

    public String getRegId() {
        return this.regId;
    }

    public RegistrationRecord setRegId(String str) {
        this.regId = str;
        return this;
    }

    public RegistrationRecord set(String str, Object obj) {
        return (RegistrationRecord) super.set(str, obj);
    }

    public RegistrationRecord clone() {
        return (RegistrationRecord) super.clone();
    }
}
