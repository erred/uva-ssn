package android.support.p041v4.media.session;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder.DeathRecipient;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.p041v4.media.MediaMetadataCompat;
import android.support.p041v4.media.session.C0391a.C0392a;
import android.support.p041v4.media.session.C0394b.C0395a;
import android.support.p041v4.media.session.C0397c.C0398a;
import android.support.p041v4.media.session.MediaSessionCompat.QueueItem;
import android.support.p041v4.media.session.MediaSessionCompat.Token;
import android.util.Log;
import androidx.core.app.C0848c;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

/* renamed from: android.support.v4.media.session.MediaControllerCompat */
public final class MediaControllerCompat {

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21 */
    static class MediaControllerImplApi21 {

        /* renamed from: a */
        final Object f775a;

        /* renamed from: b */
        final Token f776b;

        /* renamed from: c */
        private final List<C0380a> f777c;

        /* renamed from: d */
        private HashMap<C0380a, C0379a> f778d;

        /* renamed from: android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver */
        private static class ExtraBinderRequestResultReceiver extends ResultReceiver {

            /* renamed from: a */
            private WeakReference<MediaControllerImplApi21> f779a;

            /* access modifiers changed from: protected */
            public void onReceiveResult(int i, Bundle bundle) {
                MediaControllerImplApi21 mediaControllerImplApi21 = (MediaControllerImplApi21) this.f779a.get();
                if (mediaControllerImplApi21 != null && bundle != null) {
                    synchronized (mediaControllerImplApi21.f775a) {
                        mediaControllerImplApi21.f776b.mo674a(C0395a.m1153a(C0848c.m3107a(bundle, "android.support.v4.media.session.EXTRA_BINDER")));
                        mediaControllerImplApi21.f776b.mo673a(bundle.getBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE"));
                        mediaControllerImplApi21.mo622a();
                    }
                }
            }
        }

        /* renamed from: android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$a */
        private static class C0379a extends C0383c {
            C0379a(C0380a aVar) {
                super(aVar);
            }

            /* renamed from: a */
            public void mo624a() throws RemoteException {
                throw new AssertionError();
            }

            /* renamed from: a */
            public void mo626a(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
                throw new AssertionError();
            }

            /* renamed from: a */
            public void mo629a(List<QueueItem> list) throws RemoteException {
                throw new AssertionError();
            }

            /* renamed from: a */
            public void mo628a(CharSequence charSequence) throws RemoteException {
                throw new AssertionError();
            }

            /* renamed from: a */
            public void mo625a(Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            /* renamed from: a */
            public void mo627a(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
                throw new AssertionError();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo622a() {
            if (this.f776b.mo672a() != null) {
                for (C0380a aVar : this.f777c) {
                    C0379a aVar2 = new C0379a(aVar);
                    this.f778d.put(aVar, aVar2);
                    aVar.f782c = aVar2;
                    try {
                        this.f776b.mo672a().mo714a((C0391a) aVar2);
                        aVar.mo632a(13, null, null);
                    } catch (RemoteException e) {
                        Log.e("MediaControllerCompat", "Dead object in registerCallback.", e);
                    }
                }
                this.f777c.clear();
            }
        }
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$a */
    public static abstract class C0380a implements DeathRecipient {

        /* renamed from: a */
        final Object f780a;

        /* renamed from: b */
        C0381a f781b;

        /* renamed from: c */
        C0391a f782c;

        /* renamed from: android.support.v4.media.session.MediaControllerCompat$a$a */
        private class C0381a extends Handler {

            /* renamed from: a */
            boolean f783a;

            /* renamed from: b */
            final /* synthetic */ C0380a f784b;

            public void handleMessage(Message message) {
                if (this.f783a) {
                    switch (message.what) {
                        case 1:
                            Bundle data = message.getData();
                            MediaSessionCompat.m1057a(data);
                            this.f784b.mo638a((String) message.obj, data);
                            break;
                        case 2:
                            this.f784b.mo636a((PlaybackStateCompat) message.obj);
                            break;
                        case 3:
                            this.f784b.mo634a((MediaMetadataCompat) message.obj);
                            break;
                        case 4:
                            this.f784b.mo635a((C0384b) message.obj);
                            break;
                        case 5:
                            this.f784b.mo639a((List) message.obj);
                            break;
                        case 6:
                            this.f784b.mo637a((CharSequence) message.obj);
                            break;
                        case 7:
                            Bundle bundle = (Bundle) message.obj;
                            MediaSessionCompat.m1057a(bundle);
                            this.f784b.mo633a(bundle);
                            break;
                        case 8:
                            this.f784b.mo641b();
                            break;
                        case 9:
                            this.f784b.mo631a(((Integer) message.obj).intValue());
                            break;
                        case 11:
                            this.f784b.mo640a(((Boolean) message.obj).booleanValue());
                            break;
                        case 12:
                            this.f784b.mo642b(((Integer) message.obj).intValue());
                            break;
                        case 13:
                            this.f784b.mo630a();
                            break;
                    }
                }
            }
        }

        /* renamed from: android.support.v4.media.session.MediaControllerCompat$a$b */
        private static class C0382b implements C0398a {

            /* renamed from: a */
            private final WeakReference<C0380a> f785a;

            C0382b(C0380a aVar) {
                this.f785a = new WeakReference<>(aVar);
            }

            /* renamed from: a */
            public void mo644a() {
                C0380a aVar = (C0380a) this.f785a.get();
                if (aVar != null) {
                    aVar.mo641b();
                }
            }

            /* renamed from: a */
            public void mo649a(String str, Bundle bundle) {
                C0380a aVar = (C0380a) this.f785a.get();
                if (aVar == null) {
                    return;
                }
                if (aVar.f782c == null || VERSION.SDK_INT >= 23) {
                    aVar.mo638a(str, bundle);
                }
            }

            /* renamed from: a */
            public void mo648a(Object obj) {
                C0380a aVar = (C0380a) this.f785a.get();
                if (aVar != null && aVar.f782c == null) {
                    aVar.mo636a(PlaybackStateCompat.m1071a(obj));
                }
            }

            /* renamed from: b */
            public void mo651b(Object obj) {
                C0380a aVar = (C0380a) this.f785a.get();
                if (aVar != null) {
                    aVar.mo634a(MediaMetadataCompat.m990a(obj));
                }
            }

            /* renamed from: a */
            public void mo650a(List<?> list) {
                C0380a aVar = (C0380a) this.f785a.get();
                if (aVar != null) {
                    aVar.mo639a(QueueItem.m1059a(list));
                }
            }

            /* renamed from: a */
            public void mo647a(CharSequence charSequence) {
                C0380a aVar = (C0380a) this.f785a.get();
                if (aVar != null) {
                    aVar.mo637a(charSequence);
                }
            }

            /* renamed from: a */
            public void mo646a(Bundle bundle) {
                C0380a aVar = (C0380a) this.f785a.get();
                if (aVar != null) {
                    aVar.mo633a(bundle);
                }
            }

            /* renamed from: a */
            public void mo645a(int i, int i2, int i3, int i4, int i5) {
                C0380a aVar = (C0380a) this.f785a.get();
                if (aVar != null) {
                    C0384b bVar = new C0384b(i, i2, i3, i4, i5);
                    aVar.mo635a(bVar);
                }
            }
        }

        /* renamed from: android.support.v4.media.session.MediaControllerCompat$a$c */
        private static class C0383c extends C0392a {

            /* renamed from: a */
            private final WeakReference<C0380a> f786a;

            /* renamed from: a */
            public void mo655a(boolean z) throws RemoteException {
            }

            C0383c(C0380a aVar) {
                this.f786a = new WeakReference<>(aVar);
            }

            /* renamed from: a */
            public void mo654a(String str, Bundle bundle) throws RemoteException {
                C0380a aVar = (C0380a) this.f786a.get();
                if (aVar != null) {
                    aVar.mo632a(1, str, bundle);
                }
            }

            /* renamed from: a */
            public void mo624a() throws RemoteException {
                C0380a aVar = (C0380a) this.f786a.get();
                if (aVar != null) {
                    aVar.mo632a(8, null, null);
                }
            }

            /* renamed from: a */
            public void mo653a(PlaybackStateCompat playbackStateCompat) throws RemoteException {
                C0380a aVar = (C0380a) this.f786a.get();
                if (aVar != null) {
                    aVar.mo632a(2, playbackStateCompat, null);
                }
            }

            /* renamed from: a */
            public void mo626a(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
                C0380a aVar = (C0380a) this.f786a.get();
                if (aVar != null) {
                    aVar.mo632a(3, mediaMetadataCompat, null);
                }
            }

            /* renamed from: a */
            public void mo629a(List<QueueItem> list) throws RemoteException {
                C0380a aVar = (C0380a) this.f786a.get();
                if (aVar != null) {
                    aVar.mo632a(5, list, null);
                }
            }

            /* renamed from: a */
            public void mo628a(CharSequence charSequence) throws RemoteException {
                C0380a aVar = (C0380a) this.f786a.get();
                if (aVar != null) {
                    aVar.mo632a(6, charSequence, null);
                }
            }

            /* renamed from: b */
            public void mo658b(boolean z) throws RemoteException {
                C0380a aVar = (C0380a) this.f786a.get();
                if (aVar != null) {
                    aVar.mo632a(11, Boolean.valueOf(z), null);
                }
            }

            /* renamed from: a */
            public void mo652a(int i) throws RemoteException {
                C0380a aVar = (C0380a) this.f786a.get();
                if (aVar != null) {
                    aVar.mo632a(9, Integer.valueOf(i), null);
                }
            }

            /* renamed from: b */
            public void mo657b(int i) throws RemoteException {
                C0380a aVar = (C0380a) this.f786a.get();
                if (aVar != null) {
                    aVar.mo632a(12, Integer.valueOf(i), null);
                }
            }

            /* renamed from: a */
            public void mo625a(Bundle bundle) throws RemoteException {
                C0380a aVar = (C0380a) this.f786a.get();
                if (aVar != null) {
                    aVar.mo632a(7, bundle, null);
                }
            }

            /* renamed from: a */
            public void mo627a(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
                C0380a aVar = (C0380a) this.f786a.get();
                if (aVar != null) {
                    aVar.mo632a(4, parcelableVolumeInfo != null ? new C0384b(parcelableVolumeInfo.f799a, parcelableVolumeInfo.f800b, parcelableVolumeInfo.f801c, parcelableVolumeInfo.f802d, parcelableVolumeInfo.f803e) : null, null);
                }
            }

            /* renamed from: b */
            public void mo656b() throws RemoteException {
                C0380a aVar = (C0380a) this.f786a.get();
                if (aVar != null) {
                    aVar.mo632a(13, null, null);
                }
            }
        }

        /* renamed from: a */
        public void mo630a() {
        }

        /* renamed from: a */
        public void mo631a(int i) {
        }

        /* renamed from: a */
        public void mo633a(Bundle bundle) {
        }

        /* renamed from: a */
        public void mo634a(MediaMetadataCompat mediaMetadataCompat) {
        }

        /* renamed from: a */
        public void mo635a(C0384b bVar) {
        }

        /* renamed from: a */
        public void mo636a(PlaybackStateCompat playbackStateCompat) {
        }

        /* renamed from: a */
        public void mo637a(CharSequence charSequence) {
        }

        /* renamed from: a */
        public void mo638a(String str, Bundle bundle) {
        }

        /* renamed from: a */
        public void mo639a(List<QueueItem> list) {
        }

        /* renamed from: a */
        public void mo640a(boolean z) {
        }

        /* renamed from: b */
        public void mo641b() {
        }

        /* renamed from: b */
        public void mo642b(int i) {
        }

        public C0380a() {
            if (VERSION.SDK_INT >= 21) {
                this.f780a = C0397c.m1203a(new C0382b(this));
                return;
            }
            C0383c cVar = new C0383c(this);
            this.f782c = cVar;
            this.f780a = cVar;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo632a(int i, Object obj, Bundle bundle) {
            if (this.f781b != null) {
                Message obtainMessage = this.f781b.obtainMessage(i, obj);
                obtainMessage.setData(bundle);
                obtainMessage.sendToTarget();
            }
        }
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$b */
    public static final class C0384b {

        /* renamed from: a */
        private final int f787a;

        /* renamed from: b */
        private final int f788b;

        /* renamed from: c */
        private final int f789c;

        /* renamed from: d */
        private final int f790d;

        /* renamed from: e */
        private final int f791e;

        C0384b(int i, int i2, int i3, int i4, int i5) {
            this.f787a = i;
            this.f788b = i2;
            this.f789c = i3;
            this.f790d = i4;
            this.f791e = i5;
        }
    }
}
