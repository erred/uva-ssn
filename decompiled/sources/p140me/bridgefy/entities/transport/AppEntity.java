package p140me.bridgefy.entities.transport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;

@JsonInclude(Include.NON_NULL)
/* renamed from: me.bridgefy.entities.transport.AppEntity */
public class AppEntity {

    /* renamed from: ct */
    private String f9221ct;

    /* renamed from: ds */
    private long f9222ds;

    /* renamed from: et */
    private int f9223et;

    /* renamed from: mi */
    private String f9224mi;

    public String getMessageId() {
        return this.f9224mi;
    }

    public void setMessageId(String str) {
        this.f9224mi = str;
    }

    public int getEntityType() {
        return this.f9223et;
    }

    public void setEntityType(int i) {
        this.f9223et = i;
    }

    public long getDateSent() {
        return this.f9222ds;
    }

    public void setDateSent(long j) {
        this.f9222ds = j;
    }

    public String getCt() {
        return this.f9221ct;
    }

    public void setCt(String str) {
        this.f9221ct = str;
    }

    public String toString() {
        return new Gson().toJson((Object) this);
    }

    public HashMap<String, Object> toHashMap() {
        Gson gson = new Gson();
        return (HashMap) gson.fromJson(gson.toJson((Object) this), new TypeToken<HashMap<String, Object>>() {
        }.getType());
    }
}
