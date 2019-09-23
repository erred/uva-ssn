package p000a.p013b.p020e.p035j;

import org.p153a.C3683c;

/* renamed from: a.b.e.j.a */
/* compiled from: AppendOnlyLinkedArrayList */
public class C0311a<T> {

    /* renamed from: a */
    final int f665a;

    /* renamed from: b */
    final Object[] f666b;

    /* renamed from: c */
    Object[] f667c = this.f666b;

    /* renamed from: d */
    int f668d;

    public C0311a(int i) {
        this.f665a = i;
        this.f666b = new Object[(i + 1)];
    }

    /* renamed from: a */
    public void mo512a(T t) {
        int i = this.f665a;
        int i2 = this.f668d;
        if (i2 == i) {
            Object[] objArr = new Object[(i + 1)];
            this.f667c[i] = objArr;
            this.f667c = objArr;
            i2 = 0;
        }
        this.f667c[i2] = t;
        this.f668d = i2 + 1;
    }

    /* renamed from: b */
    public void mo514b(T t) {
        this.f666b[0] = t;
    }

    /* renamed from: a */
    public <U> boolean mo513a(C3683c<? super U> cVar) {
        Object[] objArr = this.f666b;
        int i = this.f665a;
        while (true) {
            int i2 = 0;
            if (objArr == null) {
                return false;
            }
            while (i2 < i) {
                Object[] objArr2 = objArr[i2];
                if (objArr2 == null) {
                    continue;
                    break;
                } else if (C0318g.m862a(objArr2, cVar)) {
                    return true;
                } else {
                    i2++;
                }
            }
            objArr = objArr[i];
        }
    }
}
