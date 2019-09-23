package com.p113c.p114a.p115a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.c.a.a.a */
/* compiled from: IMessagingExtension */
public interface C1945a extends IInterface {

    /* renamed from: com.c.a.a.a$a */
    /* compiled from: IMessagingExtension */
    public static abstract class C1946a extends Binder implements C1945a {
        public IBinder asBinder() {
            return this;
        }

        public C1946a() {
            attachInterface(this, "com.pushbullet.android.extension.IMessagingExtension");
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.pushbullet.android.extension.IMessagingExtension");
                        mo7716a(parcel.readString(), parcel.readString());
                        return true;
                    case 2:
                        parcel.enforceInterface("com.pushbullet.android.extension.IMessagingExtension");
                        mo7715a(parcel.readString());
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString("com.pushbullet.android.extension.IMessagingExtension");
                return true;
            }
        }
    }

    /* renamed from: a */
    void mo7715a(String str) throws RemoteException;

    /* renamed from: a */
    void mo7716a(String str, String str2) throws RemoteException;
}
