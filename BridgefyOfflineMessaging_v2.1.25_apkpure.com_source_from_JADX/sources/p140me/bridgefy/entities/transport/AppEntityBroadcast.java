package p140me.bridgefy.entities.transport;

/* renamed from: me.bridgefy.entities.transport.AppEntityBroadcast */
public class AppEntityBroadcast extends AppEntity {

    /* renamed from: be */
    private boolean f9225be = false;

    public AppEntityBroadcast(boolean z) {
        this.f9225be = z;
        setEntityType(3);
        setDateSent(System.currentTimeMillis());
    }

    public static AppEntityBroadcast getAppEntityBroadcastChange(boolean z) {
        return new AppEntityBroadcast(z);
    }
}
