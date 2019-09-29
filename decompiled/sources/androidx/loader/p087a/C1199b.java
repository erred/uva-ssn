package androidx.loader.p087a;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.core.p069f.C0923a;
import androidx.lifecycle.C1176g;
import androidx.lifecycle.C1183l;
import androidx.lifecycle.C1184m;
import androidx.lifecycle.C1188p;
import androidx.lifecycle.C1189q;
import androidx.lifecycle.C1189q.C1190a;
import androidx.lifecycle.C1191r;
import androidx.loader.p087a.C1197a.C1198a;
import androidx.loader.p088b.C1206b;
import androidx.loader.p088b.C1206b.C1208b;
import androidx.p052b.C0726h;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

/* renamed from: androidx.loader.a.b */
/* compiled from: LoaderManagerImpl */
class C1199b extends C1197a {

    /* renamed from: a */
    static boolean f3590a = false;

    /* renamed from: b */
    private final C1176g f3591b;

    /* renamed from: c */
    private final C1202c f3592c;

    /* renamed from: androidx.loader.a.b$a */
    /* compiled from: LoaderManagerImpl */
    public static class C1200a<D> extends C1183l<D> implements C1208b<D> {

        /* renamed from: e */
        private final int f3593e;

        /* renamed from: f */
        private final Bundle f3594f;

        /* renamed from: g */
        private final C1206b<D> f3595g;

        /* renamed from: h */
        private C1176g f3596h;

        /* renamed from: i */
        private C1201b<D> f3597i;

        /* renamed from: j */
        private C1206b<D> f3598j;

        C1200a(int i, Bundle bundle, C1206b<D> bVar, C1206b<D> bVar2) {
            this.f3593e = i;
            this.f3594f = bundle;
            this.f3595g = bVar;
            this.f3598j = bVar2;
            this.f3595g.registerListener(i, this);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: e */
        public C1206b<D> mo4638e() {
            return this.f3595g;
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void mo4579b() {
            if (C1199b.f3590a) {
                StringBuilder sb = new StringBuilder();
                sb.append("  Starting: ");
                sb.append(this);
                Log.v("LoaderManager", sb.toString());
            }
            this.f3595g.startLoading();
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public void mo4581c() {
            if (C1199b.f3590a) {
                StringBuilder sb = new StringBuilder();
                sb.append("  Stopping: ");
                sb.append(this);
                Log.v("LoaderManager", sb.toString());
            }
            this.f3595g.stopLoading();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C1206b<D> mo4634a(C1176g gVar, C1198a<D> aVar) {
            C1201b<D> bVar = new C1201b<>(this.f3595g, aVar);
            mo4576a(gVar, bVar);
            if (this.f3597i != null) {
                mo4577a((C1184m<? super D>) this.f3597i);
            }
            this.f3596h = gVar;
            this.f3597i = bVar;
            return this.f3595g;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: f */
        public void mo4639f() {
            C1176g gVar = this.f3596h;
            C1201b<D> bVar = this.f3597i;
            if (gVar != null && bVar != null) {
                super.mo4577a((C1184m<? super T>) bVar);
                mo4576a(gVar, bVar);
            }
        }

        /* renamed from: a */
        public void mo4577a(C1184m<? super D> mVar) {
            super.mo4577a(mVar);
            this.f3596h = null;
            this.f3597i = null;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C1206b<D> mo4635a(boolean z) {
            if (C1199b.f3590a) {
                StringBuilder sb = new StringBuilder();
                sb.append("  Destroying: ");
                sb.append(this);
                Log.v("LoaderManager", sb.toString());
            }
            this.f3595g.cancelLoad();
            this.f3595g.abandon();
            C1201b<D> bVar = this.f3597i;
            if (bVar != null) {
                mo4577a((C1184m<? super D>) bVar);
                if (z) {
                    bVar.mo4643b();
                }
            }
            this.f3595g.unregisterListener(this);
            if ((bVar == null || bVar.mo4642a()) && !z) {
                return this.f3595g;
            }
            this.f3595g.reset();
            return this.f3598j;
        }

        /* renamed from: a */
        public void mo4636a(C1206b<D> bVar, D d) {
            if (C1199b.f3590a) {
                StringBuilder sb = new StringBuilder();
                sb.append("onLoadComplete: ");
                sb.append(this);
                Log.v("LoaderManager", sb.toString());
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                mo4580b(d);
                return;
            }
            if (C1199b.f3590a) {
                Log.w("LoaderManager", "onLoadComplete was incorrectly called on a background thread");
            }
            mo4578a(d);
        }

        /* renamed from: b */
        public void mo4580b(D d) {
            super.mo4580b(d);
            if (this.f3598j != null) {
                this.f3598j.reset();
                this.f3598j = null;
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.f3593e);
            sb.append(" : ");
            C0923a.m3391a(this.f3595g, sb);
            sb.append("}}");
            return sb.toString();
        }

        /* renamed from: a */
        public void mo4637a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f3593e);
            printWriter.print(" mArgs=");
            printWriter.println(this.f3594f);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f3595g);
            C1206b<D> bVar = this.f3595g;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("  ");
            bVar.dump(sb.toString(), fileDescriptor, printWriter, strArr);
            if (this.f3597i != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.f3597i);
                C1201b<D> bVar2 = this.f3597i;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append("  ");
                bVar2.mo4641a(sb2.toString(), printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(mo4638e().dataToString(mo4574a()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(mo4582d());
        }
    }

    /* renamed from: androidx.loader.a.b$b */
    /* compiled from: LoaderManagerImpl */
    static class C1201b<D> implements C1184m<D> {

        /* renamed from: a */
        private final C1206b<D> f3599a;

        /* renamed from: b */
        private final C1198a<D> f3600b;

        /* renamed from: c */
        private boolean f3601c = false;

        C1201b(C1206b<D> bVar, C1198a<D> aVar) {
            this.f3599a = bVar;
            this.f3600b = aVar;
        }

        /* renamed from: a */
        public void mo4609a(D d) {
            if (C1199b.f3590a) {
                StringBuilder sb = new StringBuilder();
                sb.append("  onLoadFinished in ");
                sb.append(this.f3599a);
                sb.append(": ");
                sb.append(this.f3599a.dataToString(d));
                Log.v("LoaderManager", sb.toString());
            }
            this.f3600b.onLoadFinished(this.f3599a, d);
            this.f3601c = true;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo4642a() {
            return this.f3601c;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo4643b() {
            if (this.f3601c) {
                if (C1199b.f3590a) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("  Resetting: ");
                    sb.append(this.f3599a);
                    Log.v("LoaderManager", sb.toString());
                }
                this.f3600b.onLoaderReset(this.f3599a);
            }
        }

        public String toString() {
            return this.f3600b.toString();
        }

        /* renamed from: a */
        public void mo4641a(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.f3601c);
        }
    }

    /* renamed from: androidx.loader.a.b$c */
    /* compiled from: LoaderManagerImpl */
    static class C1202c extends C1188p {

        /* renamed from: a */
        private static final C1190a f3602a = new C1190a() {
            /* renamed from: a */
            public <T extends C1188p> T mo4623a(Class<T> cls) {
                return new C1202c();
            }
        };

        /* renamed from: b */
        private C0726h<C1200a> f3603b = new C0726h<>();

        /* renamed from: c */
        private boolean f3604c = false;

        C1202c() {
        }

        /* renamed from: a */
        static C1202c m4528a(C1191r rVar) {
            return (C1202c) new C1189q(rVar, f3602a).mo4621a(C1202c.class);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo4648b() {
            this.f3604c = true;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public boolean mo4649c() {
            return this.f3604c;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public void mo4650d() {
            this.f3604c = false;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo4646a(int i, C1200a aVar) {
            this.f3603b.mo2899b(i, aVar);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public <D> C1200a<D> mo4645a(int i) {
            return (C1200a) this.f3603b.mo2895a(i);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: e */
        public void mo4651e() {
            int b = this.f3603b.mo2897b();
            for (int i = 0; i < b; i++) {
                ((C1200a) this.f3603b.mo2905e(i)).mo4639f();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4620a() {
            super.mo4620a();
            int b = this.f3603b.mo2897b();
            for (int i = 0; i < b; i++) {
                ((C1200a) this.f3603b.mo2905e(i)).mo4635a(true);
            }
            this.f3603b.mo2900c();
        }

        /* renamed from: a */
        public void mo4647a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f3603b.mo2897b() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("    ");
                String sb2 = sb.toString();
                for (int i = 0; i < this.f3603b.mo2897b(); i++) {
                    C1200a aVar = (C1200a) this.f3603b.mo2905e(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f3603b.mo2904d(i));
                    printWriter.print(": ");
                    printWriter.println(aVar.toString());
                    aVar.mo4637a(sb2, fileDescriptor, printWriter, strArr);
                }
            }
        }
    }

    C1199b(C1176g gVar, C1191r rVar) {
        this.f3591b = gVar;
        this.f3592c = C1202c.m4528a(rVar);
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    private <D> C1206b<D> m4510a(int i, Bundle bundle, C1198a<D> aVar, C1206b<D> bVar) {
        try {
            this.f3592c.mo4648b();
            C1206b onCreateLoader = aVar.onCreateLoader(i, bundle);
            if (onCreateLoader != null) {
                if (onCreateLoader.getClass().isMemberClass()) {
                    if (!Modifier.isStatic(onCreateLoader.getClass().getModifiers())) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Object returned from onCreateLoader must not be a non-static inner member class: ");
                        sb.append(onCreateLoader);
                        throw new IllegalArgumentException(sb.toString());
                    }
                }
                C1200a aVar2 = new C1200a(i, bundle, onCreateLoader, bVar);
                if (f3590a) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("  Created new loader ");
                    sb2.append(aVar2);
                    Log.v("LoaderManager", sb2.toString());
                }
                this.f3592c.mo4646a(i, aVar2);
                this.f3592c.mo4650d();
                return aVar2.mo4634a(this.f3591b, aVar);
            }
            throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
        } catch (Throwable th) {
            this.f3592c.mo4650d();
            throw th;
        }
    }

    /* renamed from: a */
    public <D> C1206b<D> mo4627a(int i, Bundle bundle, C1198a<D> aVar) {
        if (this.f3592c.mo4649c()) {
            throw new IllegalStateException("Called while creating a loader");
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            C1200a a = this.f3592c.mo4645a(i);
            if (f3590a) {
                StringBuilder sb = new StringBuilder();
                sb.append("initLoader in ");
                sb.append(this);
                sb.append(": args=");
                sb.append(bundle);
                Log.v("LoaderManager", sb.toString());
            }
            if (a == null) {
                return m4510a(i, bundle, aVar, null);
            }
            if (f3590a) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("  Re-using existing loader ");
                sb2.append(a);
                Log.v("LoaderManager", sb2.toString());
            }
            return a.mo4634a(this.f3591b, aVar);
        } else {
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
    }

    /* renamed from: a */
    public void mo4628a() {
        this.f3592c.mo4651e();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        C0923a.m3391a(this.f3591b, sb);
        sb.append("}}");
        return sb.toString();
    }

    @Deprecated
    /* renamed from: a */
    public void mo4629a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f3592c.mo4647a(str, fileDescriptor, printWriter, strArr);
    }
}
