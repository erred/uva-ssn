package p140me.bridgefy.entities.transport;

import org.apache.commons.p156b.C3691c;

/* renamed from: me.bridgefy.entities.transport.AppEntitySignal */
public class AppEntitySignal extends AppEntity {

    /* renamed from: ms */
    private int f9230ms;

    public AppEntitySignal(int i, String str) {
        setEntityType(4);
        setSignalType(i);
        setMessageId(str);
    }

    public AppEntitySignal(String[] strArr) {
        setEntityType(4);
        setSignalType(666);
        setMessageId(C3691c.m10976a((Object[]) strArr, ","));
    }

    public int getSignalType() {
        return this.f9230ms;
    }

    public void setSignalType(int i) {
        this.f9230ms = i;
    }
}
