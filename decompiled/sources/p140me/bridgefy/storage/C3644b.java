package p140me.bridgefy.storage;

import android.content.Context;
import com.google.api.client.http.HttpMethods;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import p140me.bridgefy.storage.p150b.C3645a;
import p140me.bridgefy.storage.p151c.C3647a;
import p140me.bridgefy.storage.p151c.C3649b;

/* renamed from: me.bridgefy.storage.b */
/* compiled from: UploadRequest */
public class C3644b {

    /* renamed from: a */
    private C3645a f9617a;

    /* renamed from: b */
    private String f9618b = HttpMethods.POST;

    /* renamed from: c */
    private final Context f9619c;

    /* renamed from: d */
    private String f9620d;

    /* renamed from: e */
    private int f9621e;

    /* renamed from: f */
    private final String f9622f;

    /* renamed from: g */
    private final String f9623g;

    /* renamed from: h */
    private final ArrayList<C3647a> f9624h;

    /* renamed from: i */
    private final ArrayList<C3649b> f9625i;

    /* renamed from: j */
    private final ArrayList<C3649b> f9626j;

    /* renamed from: k */
    private int f9627k;

    public C3644b(Context context, String str, String str2) {
        this.f9619c = context;
        this.f9622f = str;
        this.f9617a = new C3645a();
        this.f9623g = str2;
        this.f9624h = new ArrayList<>();
        this.f9625i = new ArrayList<>();
        this.f9626j = new ArrayList<>();
        this.f9621e = 0;
    }

    /* renamed from: a */
    public void mo29743a(int i, String str, String str2, String str3, String str4, boolean z) {
        C3645a aVar = new C3645a(i, str, str2, str3, str4, z);
        this.f9617a = aVar;
    }

    /* renamed from: a */
    public void mo29741a() throws IllegalArgumentException, MalformedURLException {
        if (this.f9623g == null || "".equals(this.f9623g)) {
            throw new IllegalArgumentException("Request URL cannot be either null or empty");
        } else if (this.f9623g.startsWith("http")) {
            new URL(this.f9623g);
            if (this.f9624h.isEmpty()) {
                throw new IllegalArgumentException("You have to add at least one file to upload");
            }
        } else {
            throw new IllegalArgumentException("Specify either http:// or https:// as protocol");
        }
    }

    /* renamed from: a */
    public void mo29745a(String str, String str2, String str3, String str4) {
        this.f9624h.add(new C3647a(str, str2, str3, str4));
    }

    /* renamed from: a */
    public void mo29744a(String str, String str2) {
        this.f9625i.add(new C3649b(str, str2));
    }

    /* renamed from: b */
    public void mo29748b(String str, String str2) {
        this.f9626j.add(new C3649b(str, str2));
    }

    /* renamed from: b */
    public String mo29746b() {
        return this.f9618b;
    }

    /* renamed from: c */
    public String mo29749c() {
        return this.f9622f;
    }

    /* renamed from: d */
    public String mo29750d() {
        return this.f9623g;
    }

    /* renamed from: e */
    public ArrayList<C3647a> mo29751e() {
        return this.f9624h;
    }

    /* renamed from: f */
    public ArrayList<C3649b> mo29752f() {
        return this.f9625i;
    }

    /* renamed from: g */
    public ArrayList<C3649b> mo29753g() {
        return this.f9626j;
    }

    /* renamed from: h */
    public C3645a mo29754h() {
        return this.f9617a;
    }

    /* renamed from: i */
    public Context mo29755i() {
        return this.f9619c;
    }

    /* renamed from: j */
    public final String mo29756j() {
        return this.f9620d;
    }

    /* renamed from: k */
    public final int mo29757k() {
        return this.f9621e;
    }

    /* renamed from: a */
    public final void mo29742a(int i) {
        if (i < 0) {
            this.f9621e = 0;
        } else {
            this.f9621e = i;
        }
    }

    /* renamed from: l */
    public int mo29758l() {
        return this.f9627k;
    }

    /* renamed from: b */
    public void mo29747b(int i) {
        this.f9627k = i;
    }
}
