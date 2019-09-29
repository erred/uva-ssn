package p140me.bridgefy.backend.bgfyUserApi.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

/* renamed from: me.bridgefy.backend.bgfyUserApi.model.EndpointPhoneListContainer */
public final class EndpointPhoneListContainer extends GenericJson {
    @Key
    private List<String> phoneList;

    public List<String> getPhoneList() {
        return this.phoneList;
    }

    public EndpointPhoneListContainer setPhoneList(List<String> list) {
        this.phoneList = list;
        return this;
    }

    public EndpointPhoneListContainer set(String str, Object obj) {
        return (EndpointPhoneListContainer) super.set(str, obj);
    }

    public EndpointPhoneListContainer clone() {
        return (EndpointPhoneListContainer) super.clone();
    }
}
