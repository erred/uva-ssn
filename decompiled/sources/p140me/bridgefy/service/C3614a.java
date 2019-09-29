package p140me.bridgefy.service;

import java.util.ArrayList;
import p140me.bridgefy.entities.Message;

/* renamed from: me.bridgefy.service.a */
/* compiled from: MessageHolder */
public class C3614a {

    /* renamed from: a */
    private String f9538a;

    /* renamed from: b */
    private int f9539b;

    /* renamed from: c */
    private ArrayList<Message> f9540c = new ArrayList<>();

    public C3614a(String str, ArrayList<Message> arrayList, int i) {
        this.f9538a = str;
        this.f9539b = i;
        if (arrayList != null) {
            this.f9540c = arrayList;
        }
    }

    public boolean equals(Object obj) {
        C3614a aVar = (C3614a) obj;
        return this.f9538a == null ? aVar.f9538a == null : this.f9538a.equals(aVar.f9538a);
    }

    public int hashCode() {
        if (this.f9538a != null) {
            return this.f9538a.hashCode();
        }
        return 0;
    }

    /* renamed from: a */
    public int mo29643a() {
        return this.f9539b;
    }

    /* renamed from: b */
    public String mo29644b() {
        return this.f9538a;
    }

    /* renamed from: c */
    public ArrayList<Message> mo29645c() {
        if (this.f9540c == null) {
            this.f9540c = new ArrayList<>();
        }
        return this.f9540c;
    }
}
