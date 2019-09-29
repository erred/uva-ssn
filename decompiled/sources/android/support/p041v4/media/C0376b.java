package android.support.p041v4.media;

import android.media.MediaDescription;
import android.media.MediaDescription.Builder;
import android.net.Uri;

/* renamed from: android.support.v4.media.b */
/* compiled from: MediaDescriptionCompatApi23 */
class C0376b {

    /* renamed from: android.support.v4.media.b$a */
    /* compiled from: MediaDescriptionCompatApi23 */
    static class C0377a {
        /* renamed from: a */
        public static void m1014a(Object obj, Uri uri) {
            ((Builder) obj).setMediaUri(uri);
        }
    }

    /* renamed from: a */
    public static Uri m1013a(Object obj) {
        return ((MediaDescription) obj).getMediaUri();
    }
}
