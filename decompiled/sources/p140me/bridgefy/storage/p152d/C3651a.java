package p140me.bridgefy.storage.p152d;

import android.content.Intent;
import androidx.p079f.p080a.C1049a;
import com.google.api.client.http.HttpStatusCodes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import p140me.bridgefy.cloud.google_controller;
import p140me.bridgefy.entities.Message;
import p140me.bridgefy.main.BridgefyApp;
import p140me.bridgefy.ormlite.DatabaseHelper;
import p140me.bridgefy.ormlite.entities.MessageDTO;
import p140me.bridgefy.p141a.C3457c;
import p140me.bridgefy.p141a.C3460d;
import p140me.bridgefy.storage.p151c.C3649b;
import p140me.bridgefy.utils.C3659b;

/* renamed from: me.bridgefy.storage.d.a */
/* compiled from: ResponseActions */
public class C3651a {

    /* renamed from: d */
    private static C3651a f9641d = new C3651a();

    /* renamed from: a */
    private final int f9642a = HttpStatusCodes.STATUS_CODE_CONFLICT;

    /* renamed from: b */
    private final int f9643b = 500;

    /* renamed from: c */
    private final int f9644c = 200;

    private C3651a() {
    }

    /* renamed from: a */
    public static C3651a m10830a() {
        return f9641d;
    }

    /* renamed from: a */
    public boolean mo29792a(ArrayList<C3649b> arrayList, int i, ArrayList<C3649b> arrayList2, DatabaseHelper databaseHelper) {
        if (i == 200) {
            return m10832a(arrayList2, databaseHelper, 200);
        }
        if (i == 409) {
            return m10833b(arrayList, i, arrayList2, databaseHelper);
        }
        if (i != 500) {
            return false;
        }
        return m10832a(arrayList2, databaseHelper, 500);
    }

    /* renamed from: b */
    private boolean m10833b(ArrayList<C3649b> arrayList, int i, ArrayList<C3649b> arrayList2, DatabaseHelper databaseHelper) {
        C3649b bVar = null;
        try {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                C3649b bVar2 = (C3649b) it.next();
                if (bVar2.mo29782a().equals(MessageDTO.RECEIVER)) {
                    bVar = bVar2;
                }
            }
            String b = bVar.mo29783b();
            String a = google_controller.get_google_controller().mo29183a(b);
            if (a != null) {
                new C3457c(databaseHelper).mo28318a(b, a);
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    C3649b bVar3 = (C3649b) it2.next();
                    if (bVar3.mo29782a().equals("checksum-key")) {
                        arrayList.remove(bVar3);
                    }
                }
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(C3659b.m10885a(a));
                arrayList.add(new C3649b("checksum-key", sb.toString()));
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    private boolean m10832a(ArrayList<C3649b> arrayList, DatabaseHelper databaseHelper, int i) {
        C3649b a = m10829a(arrayList, "localID");
        if (a == null) {
            return false;
        }
        C3460d dVar = new C3460d(databaseHelper);
        Message b = dVar.mo28341b(a.mo29783b());
        b.setStatus(i == 200 ? 3 : 2);
        dVar.mo28337a(b);
        m10831a(b);
        return true;
    }

    /* renamed from: a */
    private C3649b m10829a(ArrayList<C3649b> arrayList, String str) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C3649b bVar = (C3649b) it.next();
            if (bVar.mo29782a().equals(str)) {
                return bVar;
            }
        }
        return null;
    }

    /* renamed from: a */
    private void m10831a(Message message) {
        C1049a.m3996a(BridgefyApp.m10557c().getApplicationContext()).mo4060a(new Intent("messageStatusUpdate").putExtra("bridgefyMessage", message.serialize()));
    }
}
