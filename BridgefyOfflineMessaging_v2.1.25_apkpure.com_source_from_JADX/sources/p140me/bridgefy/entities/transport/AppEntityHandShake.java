package p140me.bridgefy.entities.transport;

import p140me.bridgefy.entities.AppHandShake;

/* renamed from: me.bridgefy.entities.transport.AppEntityHandShake */
public class AppEntityHandShake extends AppEntity {

    /* renamed from: hi */
    private AppHandShake f9226hi;

    public AppEntityHandShake(AppHandShake appHandShake) {
        setEntityType(0);
        setDateSent(System.currentTimeMillis());
        setHandShake(appHandShake);
    }

    public AppHandShake getHandShake() {
        return this.f9226hi;
    }

    public void setHandShake(AppHandShake appHandShake) {
        this.f9226hi = appHandShake;
    }
}
