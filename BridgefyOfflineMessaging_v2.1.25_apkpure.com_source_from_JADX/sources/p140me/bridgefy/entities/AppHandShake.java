package p140me.bridgefy.entities;

import com.google.gson.GsonBuilder;

/* renamed from: me.bridgefy.entities.AppHandShake */
public class AppHandShake {

    /* renamed from: rq */
    private AppRequestJson f9212rq;

    /* renamed from: rs */
    private AppResponseJson f9213rs;

    public AppHandShake(AppRequestJson appRequestJson, AppResponseJson appResponseJson) {
        this.f9212rq = appRequestJson;
        this.f9213rs = appResponseJson;
    }

    public String toString() {
        return new GsonBuilder().setPrettyPrinting().create().toJson((Object) this);
    }

    public AppRequestJson getRequestJson() {
        return this.f9212rq;
    }

    public AppResponseJson getResponseJson() {
        return this.f9213rs;
    }
}
