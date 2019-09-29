package android.support.p041v4.p042a;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: android.support.v4.a.a */
/* compiled from: IResultReceiver */
public interface C0359a extends IInterface {

    /* renamed from: android.support.v4.a.a$a */
    /* compiled from: IResultReceiver */
    public static abstract class C0360a extends Binder implements C0359a {

        /* renamed from: android.support.v4.a.a$a$a */
        /* compiled from: IResultReceiver */
        private static class C0361a implements C0359a {

            /* renamed from: a */
            private IBinder f731a;

            C0361a(IBinder iBinder) {
                this.f731a = iBinder;
            }

            public IBinder asBinder() {
                return this.f731a;
            }

            /* renamed from: a */
            public void mo566a(int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.os.IResultReceiver");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f731a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public C0360a() {
            attachInterface(this, "android.support.v4.os.IResultReceiver");
        }

        /* renamed from: a */
        public static C0359a m959a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.v4.os.IResultReceiver");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof C0359a)) {
                return new C0361a(iBinder);
            }
            return (C0359a) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("android.support.v4.os.IResultReceiver");
                mo566a(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("android.support.v4.os.IResultReceiver");
                return true;
            }
        }
    }

    /* renamed from: a */
    void mo566a(int i, Bundle bundle) throws RemoteException;
}
