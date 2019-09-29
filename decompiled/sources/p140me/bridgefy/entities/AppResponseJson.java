package p140me.bridgefy.entities;

import com.google.gson.Gson;

/* renamed from: me.bridgefy.entities.AppResponseJson */
public class AppResponseJson {

    /* renamed from: dn */
    private boolean f9216dn;

    /* renamed from: ph */
    private String f9217ph;

    /* renamed from: tp */
    private int f9218tp;
    private String uid;

    /* renamed from: un */
    private String f9219un;
    private int vrf;

    public static AppResponseJson ResponseTypeGeneral(String str, int i, String str2) {
        AppResponseJson appResponseJson = new AppResponseJson();
        appResponseJson.setUid(str2);
        appResponseJson.setTp(0);
        appResponseJson.setUn(str);
        appResponseJson.setVrf(i);
        return appResponseJson;
    }

    public static AppResponseJson ResponseTypeTelephone(String str, String str2) {
        AppResponseJson appResponseJson = new AppResponseJson();
        appResponseJson.setUid(str2);
        appResponseJson.setTp(1);
        appResponseJson.setPh(str);
        return appResponseJson;
    }

    public static AppResponseJson ResponseTypeHandshakeFinished(String str) {
        AppResponseJson appResponseJson = new AppResponseJson();
        appResponseJson.setTp(2);
        appResponseJson.setUid(str);
        return appResponseJson;
    }

    public int getTp() {
        return this.f9218tp;
    }

    public void setTp(int i) {
        this.f9218tp = i;
    }

    public String getUn() {
        return this.f9219un;
    }

    public void setUn(String str) {
        this.f9219un = str;
    }

    public void setVrf(int i) {
        this.vrf = i;
    }

    public int getVrf() {
        return this.vrf;
    }

    public String getPh() {
        return this.f9217ph;
    }

    public void setPh(String str) {
        this.f9217ph = str;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public boolean isDn() {
        return this.f9216dn;
    }

    public void setDn(boolean z) {
        this.f9216dn = z;
    }

    public String toString() {
        return new Gson().toJson((Object) this);
    }
}
