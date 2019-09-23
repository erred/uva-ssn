package p140me.bridgefy.backend.registration.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

/* renamed from: me.bridgefy.backend.registration.model.CollectionResponseRegistrationRecord */
public final class CollectionResponseRegistrationRecord extends GenericJson {
    @Key
    private List<RegistrationRecord> items;
    @Key
    private String nextPageToken;

    public List<RegistrationRecord> getItems() {
        return this.items;
    }

    public CollectionResponseRegistrationRecord setItems(List<RegistrationRecord> list) {
        this.items = list;
        return this;
    }

    public String getNextPageToken() {
        return this.nextPageToken;
    }

    public CollectionResponseRegistrationRecord setNextPageToken(String str) {
        this.nextPageToken = str;
        return this;
    }

    public CollectionResponseRegistrationRecord set(String str, Object obj) {
        return (CollectionResponseRegistrationRecord) super.set(str, obj);
    }

    public CollectionResponseRegistrationRecord clone() {
        return (CollectionResponseRegistrationRecord) super.clone();
    }
}
