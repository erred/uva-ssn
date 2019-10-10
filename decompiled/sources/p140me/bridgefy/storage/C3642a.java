package p140me.bridgefy.storage;

import android.webkit.MimeTypeMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import me.bridgefy.main.R;
import p140me.bridgefy.cloud.google_controller;
import p140me.bridgefy.entities.Message;
import p140me.bridgefy.main.BridgefyApp;
import p140me.bridgefy.ormlite.entities.MessageDTO;

/* renamed from: me.bridgefy.storage.a */
/* compiled from: StorageRequestList */
public class C3642a {

    /* renamed from: b */
    private static C3642a f9615b = new C3642a();

    /* renamed from: a */
    private final CopyOnWriteArrayList<C3644b> f9616a = new CopyOnWriteArrayList<>();

    private C3642a() {
    }

    /* renamed from: a */
    public static C3642a m10779a() {
        return f9615b;
    }

    /* renamed from: a */
    public C3644b mo29736a(Message message, long j) {
        C3644b a = mo29735a(message.getOfflineId());
        if (a != null) {
            return a;
        }
        return m10780a(m10782b(message, j));
    }

    /* renamed from: a */
    private synchronized C3644b m10780a(C3644b bVar) {
        synchronized (this.f9616a) {
            this.f9616a.add(bVar);
        }
        return bVar;
    }

    /* renamed from: b */
    private C3644b m10782b(Message message, long j) {
        C3644b bVar = new C3644b(BridgefyApp.m10557c().getApplicationContext(), message.getOfflineId(), "https://bionic-torch-719.appspot.com/_ah/files/upload");
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(message.getFileName()));
        bVar.mo29745a(message.getBridgefyImagePath(), "bridgefy-file", "bridgefy", "multipart/form-data");
        bVar.mo29744a("token", google_controller.get_google_controller().get_id_token());
        bVar.mo29744a("mime-type", mimeTypeFromExtension);
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(j);
        bVar.mo29744a("checksum-key", sb.toString());
        m10781a(message, bVar);
        bVar.mo29743a(17301589, bVar.mo29755i().getString(R.string.app_name), bVar.mo29755i().getString(R.string.bridgefy_loading_text), bVar.mo29755i().getString(R.string.upload_completed), bVar.mo29755i().getString(R.string.image_error), true);
        bVar.mo29742a(2);
        return bVar;
    }

    /* renamed from: a */
    public synchronized C3644b mo29735a(String str) {
        Iterator it = this.f9616a.iterator();
        while (it.hasNext()) {
            C3644b bVar = (C3644b) it.next();
            if (bVar.mo29749c() != null && str != null && bVar.mo29749c().trim().equals(str.trim())) {
                return bVar;
            }
        }
        return null;
    }

    /* renamed from: b */
    public synchronized void mo29737b(String str) {
        Iterator it = this.f9616a.iterator();
        while (it.hasNext()) {
            C3644b bVar = (C3644b) it.next();
            if (!(bVar.mo29749c() == null || str == null || !bVar.mo29749c().trim().equals(str.trim()))) {
                this.f9616a.remove(bVar);
            }
        }
    }

    /* renamed from: a */
    private void m10781a(Message message, C3644b bVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(message.getDateSent());
        bVar.mo29748b("dateSent", sb.toString());
        bVar.mo29748b("filePath", message.getFileName());
        bVar.mo29748b("localID", message.getOfflineId());
        bVar.mo29748b("messageID", message.getMessageId());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("");
        sb2.append(message.getType());
        bVar.mo29748b("messageType", sb2.toString());
        bVar.mo29748b(MessageDTO.RECEIVER, message.getReceiver());
        String str = MessageDTO.STATUS;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("");
        sb3.append(message.getStatus());
        bVar.mo29748b(str, sb3.toString());
        bVar.mo29748b("text", message.getText());
    }
}
