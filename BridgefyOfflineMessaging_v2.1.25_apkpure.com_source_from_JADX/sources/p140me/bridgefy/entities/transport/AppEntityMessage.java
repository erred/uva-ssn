package p140me.bridgefy.entities.transport;

import p140me.bridgefy.entities.Message;

/* renamed from: me.bridgefy.entities.transport.AppEntityMessage */
public class AppEntityMessage extends AppEntity {

    /* renamed from: ku */
    private int f9227ku;

    /* renamed from: mt */
    private int f9228mt;

    /* renamed from: nm */
    private String f9229nm;

    public AppEntityMessage(Message message, int i) {
        setEntityType(i);
        setDateSent(Long.parseLong(message.getDateSent()));
        setMessageType(message.getType());
        setCt(message.getText());
        setMessageId(message.getOfflineId() != null ? message.getOfflineId() : message.getMessageId());
        setName(message.getOtherUserName());
    }

    public int getMessageType() {
        return this.f9228mt;
    }

    public void setMessageType(int i) {
        this.f9228mt = i;
    }

    public String getName() {
        return this.f9229nm;
    }

    public void setName(String str) {
        this.f9229nm = str;
    }

    public void setKu(int i) {
        this.f9227ku = i;
    }
}
