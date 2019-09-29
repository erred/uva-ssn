package com.twitter.sdk.android.core.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.twitter.sdk.android.core.C3256m;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* renamed from: com.twitter.sdk.android.core.internal.e */
/* compiled from: AdvertisingInfoServiceStrategy */
class C3171e implements C3175f {

    /* renamed from: a */
    private final Context f8324a;

    /* renamed from: com.twitter.sdk.android.core.internal.e$a */
    /* compiled from: AdvertisingInfoServiceStrategy */
    private static final class C3173a implements ServiceConnection {

        /* renamed from: a */
        private boolean f8325a;

        /* renamed from: b */
        private final LinkedBlockingQueue<IBinder> f8326b;

        private C3173a() {
            this.f8326b = new LinkedBlockingQueue<>(1);
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f8326b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            this.f8326b.clear();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public IBinder mo27693a() {
            if (this.f8325a) {
                C3256m.m9537g().mo27612c("Twitter", "getBinder already called");
            }
            this.f8325a = true;
            try {
                return (IBinder) this.f8326b.poll(200, TimeUnit.MILLISECONDS);
            } catch (InterruptedException unused) {
                return null;
            }
        }
    }

    /* renamed from: com.twitter.sdk.android.core.internal.e$b */
    /* compiled from: AdvertisingInfoServiceStrategy */
    private static final class C3174b implements IInterface {

        /* renamed from: a */
        private final IBinder f8327a;

        private C3174b(IBinder iBinder) {
            this.f8327a = iBinder;
        }

        public IBinder asBinder() {
            return this.f8327a;
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
            com.twitter.sdk.android.core.C3256m.m9537g().mo27607a("Twitter", "Could not get parcel from Google Play Service to capture AdvertisingId");
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
        public java.lang.String mo27696a() throws android.os.RemoteException {
            /*
                r5 = this;
                android.os.Parcel r0 = android.os.Parcel.obtain()
                android.os.Parcel r1 = android.os.Parcel.obtain()
                java.lang.String r2 = "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService"
                r0.writeInterfaceToken(r2)     // Catch:{ Exception -> 0x0024 }
                android.os.IBinder r2 = r5.f8327a     // Catch:{ Exception -> 0x0024 }
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
                com.twitter.sdk.android.core.h r2 = com.twitter.sdk.android.core.C3256m.m9537g()     // Catch:{ all -> 0x0022 }
                java.lang.String r3 = "Twitter"
                java.lang.String r4 = "Could not get parcel from Google Play Service to capture AdvertisingId"
                r2.mo27607a(r3, r4)     // Catch:{ all -> 0x0022 }
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
            throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.core.internal.C3171e.C3174b.mo27696a():java.lang.String");
        }

        /* access modifiers changed from: private */
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
            com.twitter.sdk.android.core.C3256m.m9537g().mo27607a("Twitter", "Could not get parcel from Google Play Service to capture Advertising limitAdTracking");
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0025 */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean m9296b() throws android.os.RemoteException {
            /*
                r6 = this;
                android.os.Parcel r0 = android.os.Parcel.obtain()
                android.os.Parcel r1 = android.os.Parcel.obtain()
                r2 = 0
                java.lang.String r3 = "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService"
                r0.writeInterfaceToken(r3)     // Catch:{ Exception -> 0x0025 }
                r3 = 1
                r0.writeInt(r3)     // Catch:{ Exception -> 0x0025 }
                android.os.IBinder r4 = r6.f8327a     // Catch:{ Exception -> 0x0025 }
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
                com.twitter.sdk.android.core.h r3 = com.twitter.sdk.android.core.C3256m.m9537g()     // Catch:{ all -> 0x0023 }
                java.lang.String r4 = "Twitter"
                java.lang.String r5 = "Could not get parcel from Google Play Service to capture Advertising limitAdTracking"
                r3.mo27607a(r4, r5)     // Catch:{ all -> 0x0023 }
            L_0x0030:
                r1.recycle()
                r0.recycle()
                return r2
            L_0x0037:
                r1.recycle()
                r0.recycle()
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.core.internal.C3171e.C3174b.m9296b():boolean");
        }
    }

    C3171e(Context context) {
        this.f8324a = context.getApplicationContext();
    }

    /* renamed from: a */
    public C3162b mo27691a() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            C3256m.m9537g().mo27607a("Twitter", "AdvertisingInfoServiceStrategy cannot be called on the main thread");
            return null;
        }
        try {
            this.f8324a.getPackageManager().getPackageInfo("com.android.vending", 0);
            C3173a aVar = new C3173a();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            try {
                if (this.f8324a.bindService(intent, aVar, 1)) {
                    try {
                        C3174b bVar = new C3174b(aVar.mo27693a());
                        C3162b bVar2 = new C3162b(bVar.mo27696a(), bVar.m9296b());
                        this.f8324a.unbindService(aVar);
                        return bVar2;
                    } catch (Exception e) {
                        C3256m.m9537g().mo27611b("Twitter", "Exception in binding to Google Play Service to capture AdvertisingId", e);
                        this.f8324a.unbindService(aVar);
                    }
                } else {
                    C3256m.m9537g().mo27607a("Twitter", "Could not bind to Google Play Service to capture AdvertisingId");
                    return null;
                }
            } catch (Throwable th) {
                C3256m.m9537g().mo27608a("Twitter", "Could not bind to Google Play Service to capture AdvertisingId", th);
            }
        } catch (NameNotFoundException unused) {
            C3256m.m9537g().mo27607a("Twitter", "Unable to find Google Play Services package name");
            return null;
        } catch (Exception e2) {
            C3256m.m9537g().mo27608a("Twitter", "Unable to determine if Google Play Services is available", (Throwable) e2);
            return null;
        }
    }
}
