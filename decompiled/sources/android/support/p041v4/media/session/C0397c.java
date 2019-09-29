package android.support.p041v4.media.session;

import android.media.AudioAttributes;
import android.media.MediaMetadata;
import android.media.session.MediaController.Callback;
import android.media.session.MediaController.PlaybackInfo;
import android.media.session.MediaSession.QueueItem;
import android.media.session.PlaybackState;
import android.os.Bundle;
import java.util.List;

/* renamed from: android.support.v4.media.session.c */
/* compiled from: MediaControllerCompatApi21 */
class C0397c {

    /* renamed from: android.support.v4.media.session.c$a */
    /* compiled from: MediaControllerCompatApi21 */
    public interface C0398a {
        /* renamed from: a */
        void mo644a();

        /* renamed from: a */
        void mo645a(int i, int i2, int i3, int i4, int i5);

        /* renamed from: a */
        void mo646a(Bundle bundle);

        /* renamed from: a */
        void mo647a(CharSequence charSequence);

        /* renamed from: a */
        void mo648a(Object obj);

        /* renamed from: a */
        void mo649a(String str, Bundle bundle);

        /* renamed from: a */
        void mo650a(List<?> list);

        /* renamed from: b */
        void mo651b(Object obj);
    }

    /* renamed from: android.support.v4.media.session.c$b */
    /* compiled from: MediaControllerCompatApi21 */
    static class C0399b<T extends C0398a> extends Callback {

        /* renamed from: a */
        protected final T f823a;

        public C0399b(T t) {
            this.f823a = t;
        }

        public void onSessionDestroyed() {
            this.f823a.mo644a();
        }

        public void onSessionEvent(String str, Bundle bundle) {
            MediaSessionCompat.m1057a(bundle);
            this.f823a.mo649a(str, bundle);
        }

        public void onPlaybackStateChanged(PlaybackState playbackState) {
            this.f823a.mo648a((Object) playbackState);
        }

        public void onMetadataChanged(MediaMetadata mediaMetadata) {
            this.f823a.mo651b(mediaMetadata);
        }

        public void onQueueChanged(List<QueueItem> list) {
            this.f823a.mo650a(list);
        }

        public void onQueueTitleChanged(CharSequence charSequence) {
            this.f823a.mo647a(charSequence);
        }

        public void onExtrasChanged(Bundle bundle) {
            MediaSessionCompat.m1057a(bundle);
            this.f823a.mo646a(bundle);
        }

        public void onAudioInfoChanged(PlaybackInfo playbackInfo) {
            this.f823a.mo645a(playbackInfo.getPlaybackType(), C0400c.m1214b(playbackInfo), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume());
        }
    }

    /* renamed from: android.support.v4.media.session.c$c */
    /* compiled from: MediaControllerCompatApi21 */
    public static class C0400c {
        /* renamed from: a */
        public static AudioAttributes m1213a(Object obj) {
            return ((PlaybackInfo) obj).getAudioAttributes();
        }

        /* renamed from: b */
        public static int m1214b(Object obj) {
            return m1212a(m1213a(obj));
        }

        /* renamed from: a */
        private static int m1212a(AudioAttributes audioAttributes) {
            if ((audioAttributes.getFlags() & 1) == 1) {
                return 7;
            }
            if ((audioAttributes.getFlags() & 4) == 4) {
                return 6;
            }
            switch (audioAttributes.getUsage()) {
                case 1:
                case 11:
                case 12:
                case 14:
                    return 3;
                case 2:
                    return 0;
                case 3:
                    return 8;
                case 4:
                    return 4;
                case 5:
                case 7:
                case 8:
                case 9:
                case 10:
                    return 5;
                case 6:
                    return 2;
                case 13:
                    return 1;
                default:
                    return 3;
            }
        }
    }

    /* renamed from: a */
    public static Object m1203a(C0398a aVar) {
        return new C0399b(aVar);
    }
}
