package p000a.p013b.p020e.p035j;

import java.io.Serializable;
import org.p153a.C3683c;
import org.p153a.C3684d;
import p000a.p013b.p020e.p022b.C0204b;

/* renamed from: a.b.e.j.g */
/* compiled from: NotificationLite */
public enum C0318g {
    COMPLETE;

    /* renamed from: a.b.e.j.g$a */
    /* compiled from: NotificationLite */
    static final class C0319a implements Serializable {

        /* renamed from: a */
        final Throwable f672a;

        C0319a(Throwable th) {
            this.f672a = th;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("NotificationLite.Error[");
            sb.append(this.f672a);
            sb.append("]");
            return sb.toString();
        }

        public int hashCode() {
            return this.f672a.hashCode();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0319a)) {
                return false;
            }
            return C0204b.m616a((Object) this.f672a, (Object) ((C0319a) obj).f672a);
        }
    }

    /* renamed from: a.b.e.j.g$b */
    /* compiled from: NotificationLite */
    static final class C0320b implements Serializable {

        /* renamed from: a */
        final C3684d f673a;

        C0320b(C3684d dVar) {
            this.f673a = dVar;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("NotificationLite.Subscription[");
            sb.append(this.f673a);
            sb.append("]");
            return sb.toString();
        }
    }

    /* renamed from: a */
    public static <T> Object m859a(T t) {
        return t;
    }

    public String toString() {
        return "NotificationLite.Complete";
    }

    /* renamed from: a */
    public static Object m858a() {
        return COMPLETE;
    }

    /* renamed from: a */
    public static Object m860a(Throwable th) {
        return new C0319a(th);
    }

    /* renamed from: a */
    public static Object m861a(C3684d dVar) {
        return new C0320b(dVar);
    }

    /* renamed from: a */
    public static <T> boolean m862a(Object obj, C3683c<? super T> cVar) {
        if (obj == COMPLETE) {
            cVar.onComplete();
            return true;
        } else if (obj instanceof C0319a) {
            cVar.onError(((C0319a) obj).f672a);
            return true;
        } else if (obj instanceof C0320b) {
            cVar.onSubscribe(((C0320b) obj).f673a);
            return false;
        } else {
            cVar.onNext(obj);
            return false;
        }
    }
}
