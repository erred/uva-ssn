package android.support.p041v4.media;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.p041v4.media.session.MediaSessionCompat;
import android.support.p041v4.p042a.C0362b;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.media.MediaBrowserCompat */
public final class MediaBrowserCompat {

    /* renamed from: a */
    static final boolean f739a = Log.isLoggable("MediaBrowserCompat", 3);

    /* renamed from: android.support.v4.media.MediaBrowserCompat$CustomActionResultReceiver */
    private static class CustomActionResultReceiver extends C0362b {

        /* renamed from: d */
        private final String f740d;

        /* renamed from: e */
        private final Bundle f741e;

        /* renamed from: f */
        private final C0367a f742f;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo570a(int i, Bundle bundle) {
            if (this.f742f != null) {
                MediaSessionCompat.m1057a(bundle);
                switch (i) {
                    case -1:
                        this.f742f.mo587c(this.f740d, this.f741e, bundle);
                        break;
                    case 0:
                        this.f742f.mo586b(this.f740d, this.f741e, bundle);
                        break;
                    case 1:
                        this.f742f.mo585a(this.f740d, this.f741e, bundle);
                        break;
                    default:
                        StringBuilder sb = new StringBuilder();
                        sb.append("Unknown result code: ");
                        sb.append(i);
                        sb.append(" (extras=");
                        sb.append(this.f741e);
                        sb.append(", resultData=");
                        sb.append(bundle);
                        sb.append(")");
                        Log.w("MediaBrowserCompat", sb.toString());
                        break;
                }
            }
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$ItemReceiver */
    private static class ItemReceiver extends C0362b {

        /* renamed from: d */
        private final String f743d;

        /* renamed from: e */
        private final C0368b f744e;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo570a(int i, Bundle bundle) {
            MediaSessionCompat.m1057a(bundle);
            if (i != 0 || bundle == null || !bundle.containsKey("media_item")) {
                this.f744e.mo589a(this.f743d);
                return;
            }
            Parcelable parcelable = bundle.getParcelable("media_item");
            if (parcelable == null || (parcelable instanceof MediaItem)) {
                this.f744e.mo588a((MediaItem) parcelable);
            } else {
                this.f744e.mo589a(this.f743d);
            }
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaItem */
    public static class MediaItem implements Parcelable {
        public static final Creator<MediaItem> CREATOR = new Creator<MediaItem>() {
            /* renamed from: a */
            public MediaItem createFromParcel(Parcel parcel) {
                return new MediaItem(parcel);
            }

            /* renamed from: a */
            public MediaItem[] newArray(int i) {
                return new MediaItem[i];
            }
        };

        /* renamed from: a */
        private final int f745a;

        /* renamed from: b */
        private final MediaDescriptionCompat f746b;

        public int describeContents() {
            return 0;
        }

        MediaItem(Parcel parcel) {
            this.f745a = parcel.readInt();
            this.f746b = (MediaDescriptionCompat) MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f745a);
            this.f746b.writeToParcel(parcel, i);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("MediaItem{");
            sb.append("mFlags=");
            sb.append(this.f745a);
            sb.append(", mDescription=");
            sb.append(this.f746b);
            sb.append('}');
            return sb.toString();
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$SearchResultReceiver */
    private static class SearchResultReceiver extends C0362b {

        /* renamed from: d */
        private final String f747d;

        /* renamed from: e */
        private final Bundle f748e;

        /* renamed from: f */
        private final C0369c f749f;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo570a(int i, Bundle bundle) {
            MediaSessionCompat.m1057a(bundle);
            if (i != 0 || bundle == null || !bundle.containsKey("search_results")) {
                this.f749f.mo590a(this.f747d, this.f748e);
                return;
            }
            Parcelable[] parcelableArray = bundle.getParcelableArray("search_results");
            ArrayList arrayList = null;
            if (parcelableArray != null) {
                arrayList = new ArrayList();
                for (Parcelable parcelable : parcelableArray) {
                    arrayList.add((MediaItem) parcelable);
                }
            }
            this.f749f.mo591a(this.f747d, this.f748e, arrayList);
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$a */
    public static abstract class C0367a {
        /* renamed from: a */
        public void mo585a(String str, Bundle bundle, Bundle bundle2) {
        }

        /* renamed from: b */
        public void mo586b(String str, Bundle bundle, Bundle bundle2) {
        }

        /* renamed from: c */
        public void mo587c(String str, Bundle bundle, Bundle bundle2) {
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$b */
    public static abstract class C0368b {
        /* renamed from: a */
        public void mo588a(MediaItem mediaItem) {
        }

        /* renamed from: a */
        public void mo589a(String str) {
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$c */
    public static abstract class C0369c {
        /* renamed from: a */
        public void mo590a(String str, Bundle bundle) {
        }

        /* renamed from: a */
        public void mo591a(String str, Bundle bundle, List<MediaItem> list) {
        }
    }
}
