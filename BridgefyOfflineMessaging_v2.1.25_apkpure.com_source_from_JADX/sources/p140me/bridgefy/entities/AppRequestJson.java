package p140me.bridgefy.entities;

import com.google.gson.Gson;

/* renamed from: me.bridgefy.entities.AppRequestJson */
public class AppRequestJson {

    /* renamed from: dt */
    private String f9214dt;

    /* renamed from: tp */
    private int f9215tp;

    public AppRequestJson(int i) {
        this.f9215tp = i;
    }

    public AppRequestJson(int i, String str) {
        this.f9215tp = i;
        this.f9214dt = str;
    }

    public int getTp() {
        return this.f9215tp;
    }

    public String toString() {
        return new Gson().toJson((Object) this);
    }
}
