package p000a.p001a.p002a.p003a.p004a.p006b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import p000a.p001a.p002a.p003a.C0135c;

/* renamed from: a.a.a.a.a.b.e */
/* compiled from: AdvertisingInfoServiceStrategy */
class C0013e implements C0017f {

    /* renamed from: a */
    private final Context f21a;

    /* renamed from: a.a.a.a.a.b.e$a */
    /* compiled from: AdvertisingInfoServiceStrategy */
    private static final class C0015a implements ServiceConnection {

        /* renamed from: a */
        private boolean f22a;

        /* renamed from: b */
        private final LinkedBlockingQueue<IBinder> f23b;

        private C0015a() {
            this.f22a = false;
            this.f23b = new LinkedBlockingQueue<>(1);
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f23b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            this.f23b.clear();
        }

        /* renamed from: a */
        public IBinder mo33a() {
            if (this.f22a) {
                C0135c.m449h().mo279e("Fabric", "getBinder already called");
            }
            this.f22a = true;
            try {
                return (IBinder) this.f23b.poll(200, TimeUnit.MILLISECONDS);
            } catch (InterruptedException unused) {
                return null;
            }
        }
    }

    /* renamed from: a.a.a.a.a.b.e$b */
    /* compiled from: AdvertisingInfoServiceStrategy */
    private static final class C0016b implements IInterface {

        /* renamed from: a */
        private final IBinder f24a;

        public C0016b(IBinder iBinder) {
            this.f24a = iBinder;
        }

        public IBinder asBinder() {
            return this.f24a;
        }

        /* JADX INFO: finally extract failed */
        /* JADX WARNING: Can't wrap try/catch for region: R(4:5|6|7|10) */
        /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
            return null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0022, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
            p000a.p001a.p002a.p003a.C0135c.m449h().mo270a("Fabric", "Could not get parcel from Google Play Service to capture AdvertisingId");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x002f, code lost:
            r1.recycle();
            r0.recycle();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0037, code lost:
            r1.recycle();
            r0.recycle();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x003d, code lost:
            throw r2;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0024 */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String mo36a() throws android.os.RemoteException {
            /*
                r5 = this;
                android.os.Parcel r0 = android.os.Parcel.obtain()
                android.os.Parcel r1 = android.os.Parcel.obtain()
                java.lang.String r2 = "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService"
                r0.writeInterfaceToken(r2)     // Catch:{ Exception -> 0x0024 }
                android.os.IBinder r2 = r5.f24a     // Catch:{ Exception -> 0x0024 }
                r3 = 1
                r4 = 0
                r2.transact(r3, r0, r1, r4)     // Catch:{ Exception -> 0x0024 }
                r1.readException()     // Catch:{ Exception -> 0x0024 }
                java.lang.String r2 = r1.readString()     // Catch:{ Exception -> 0x0024 }
                r1.recycle()
                r0.recycle()
                goto L_0x0036
            L_0x0022:
                r2 = move-exception
                goto L_0x0037
            L_0x0024:
                a.a.a.a.l r2 = p000a.p001a.p002a.p003a.C0135c.m449h()     // Catch:{ all -> 0x0022 }
                java.lang.String r3 = "Fabric"
                java.lang.String r4 = "Could not get parcel from Google Play Service to capture AdvertisingId"
                r2.mo270a(r3, r4)     // Catch:{ all -> 0x0022 }
                r1.recycle()
                r0.recycle()
                r2 = 0
            L_0x0036:
                return r2
            L_0x0037:
                r1.recycle()
                r0.recycle()
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p004a.p006b.C0013e.C0016b.mo36a():java.lang.String");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(2:6|7) */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0037, code lost:
            r1.recycle();
            r0.recycle();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x003d, code lost:
            throw r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0023, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            p000a.p001a.p002a.p003a.C0135c.m449h().mo270a("Fabric", "Could not get parcel from Google Play Service to capture Advertising limitAdTracking");
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0025 */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean mo38b() throws android.os.RemoteException {
            /*
                r6 = this;
                android.os.Parcel r0 = android.os.Parcel.obtain()
                android.os.Parcel r1 = android.os.Parcel.obtain()
                r2 = 0
                java.lang.String r3 = "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService"
                r0.writeInterfaceToken(r3)     // Catch:{ Exception -> 0x0025 }
                r3 = 1
                r0.writeInt(r3)     // Catch:{ Exception -> 0x0025 }
                android.os.IBinder r4 = r6.f24a     // Catch:{ Exception -> 0x0025 }
                r5 = 2
                r4.transact(r5, r0, r1, r2)     // Catch:{ Exception -> 0x0025 }
                r1.readException()     // Catch:{ Exception -> 0x0025 }
                int r4 = r1.readInt()     // Catch:{ Exception -> 0x0025 }
                if (r4 == 0) goto L_0x0030
                r2 = 1
                goto L_0x0030
            L_0x0023:
                r2 = move-exception
                goto L_0x0037
            L_0x0025:
                a.a.a.a.l r3 = p000a.p001a.p002a.p003a.C0135c.m449h()     // Catch:{ all -> 0x0023 }
                java.lang.String r4 = "Fabric"
                java.lang.String r5 = "Could not get parcel from Google Play Service to capture Advertising limitAdTracking"
                r3.mo270a(r4, r5)     // Catch:{ all -> 0x0023 }
            L_0x0030:
                r1.recycle()
                r0.recycle()
                return r2
            L_0x0037:
                r1.recycle()
                r0.recycle()
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p004a.p006b.C0013e.C0016b.mo38b():boolean");
        }
    }

    public C0013e(Context context) {
        this.f21a = context.getApplicationContext();
    }

    /* renamed from: a */
    public C0009b mo31a() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            C0135c.m449h().mo270a("Fabric", "AdvertisingInfoServiceStrategy cannot be called on the main thread");
            return null;
        }
        try {
            this.f21a.getPackageManager().getPackageInfo("com.android.vending", 0);
            C0015a aVar = new C0015a();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            try {
                if (this.f21a.bindService(intent, aVar, 1)) {
                    try {
                        C0016b bVar = new C0016b(aVar.mo33a());
                        C0009b bVar2 = new C0009b(bVar.mo36a(), bVar.mo38b());
                        this.f21a.unbindService(aVar);
                        return bVar2;
                    } catch (Exception e) {
                        C0135c.m449h().mo278d("Fabric", "Exception in binding to Google Play Service to capture AdvertisingId", e);
                        this.f21a.unbindService(aVar);
                    }
                } else {
                    C0135c.m449h().mo270a("Fabric", "Could not bind to Google Play Service to capture AdvertisingId");
                    return null;
                }
            } catch (Throwable th) {
                C0135c.m449h().mo271a("Fabric", "Could not bind to Google Play Service to capture AdvertisingId", th);
            }
        } catch (NameNotFoundException unused) {
            C0135c.m449h().mo270a("Fabric", "Unable to find Google Play Services package name");
            return null;
        } catch (Exception e2) {
            C0135c.m449h().mo271a("Fabric", "Unable to determine if Google Play Services is available", (Throwable) e2);
            return null;
        }
    }
}
