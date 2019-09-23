package androidx.core.app;

import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.Notification.MessagingStyle;
import android.app.Notification.MessagingStyle.Message;
import android.app.PendingIntent;
import android.app.Person;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.AudioAttributes.Builder;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.widget.RemoteViews;
import androidx.core.R;
import androidx.core.p068e.C0907a;
import com.google.android.gms.measurement.AppMeasurement.Param;
import java.util.ArrayList;
import java.util.List;
import p140me.bridgefy.ormlite.entities.MessageDTO;

/* renamed from: androidx.core.app.g */
/* compiled from: NotificationCompat */
public class C0854g {

    /* renamed from: androidx.core.app.g$a */
    /* compiled from: NotificationCompat */
    public static class C0855a {

        /* renamed from: a */
        final Bundle f2726a;

        /* renamed from: b */
        boolean f2727b;

        /* renamed from: c */
        public int f2728c;

        /* renamed from: d */
        public CharSequence f2729d;

        /* renamed from: e */
        public PendingIntent f2730e;

        /* renamed from: f */
        private final C0865k[] f2731f;

        /* renamed from: g */
        private final C0865k[] f2732g;

        /* renamed from: h */
        private boolean f2733h;

        /* renamed from: i */
        private final int f2734i;

        public C0855a(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i, charSequence, pendingIntent, new Bundle(), null, null, true, 0, true);
        }

        C0855a(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, C0865k[] kVarArr, C0865k[] kVarArr2, boolean z, int i2, boolean z2) {
            this.f2727b = true;
            this.f2728c = i;
            this.f2729d = C0857c.m3132d(charSequence);
            this.f2730e = pendingIntent;
            if (bundle == null) {
                bundle = new Bundle();
            }
            this.f2726a = bundle;
            this.f2731f = kVarArr;
            this.f2732g = kVarArr2;
            this.f2733h = z;
            this.f2734i = i2;
            this.f2727b = z2;
        }

        /* renamed from: a */
        public int mo3469a() {
            return this.f2728c;
        }

        /* renamed from: b */
        public CharSequence mo3470b() {
            return this.f2729d;
        }

        /* renamed from: c */
        public PendingIntent mo3471c() {
            return this.f2730e;
        }

        /* renamed from: d */
        public Bundle mo3472d() {
            return this.f2726a;
        }

        /* renamed from: e */
        public boolean mo3473e() {
            return this.f2733h;
        }

        /* renamed from: f */
        public C0865k[] mo3474f() {
            return this.f2731f;
        }

        /* renamed from: g */
        public int mo3475g() {
            return this.f2734i;
        }

        /* renamed from: h */
        public C0865k[] mo3476h() {
            return this.f2732g;
        }

        /* renamed from: i */
        public boolean mo3477i() {
            return this.f2727b;
        }
    }

    /* renamed from: androidx.core.app.g$b */
    /* compiled from: NotificationCompat */
    public static class C0856b extends C0860e {

        /* renamed from: e */
        private CharSequence f2735e;

        /* renamed from: a */
        public C0856b mo3478a(CharSequence charSequence) {
            this.f2735e = C0857c.m3132d(charSequence);
            return this;
        }

        /* renamed from: a */
        public void mo3479a(C0853f fVar) {
            if (VERSION.SDK_INT >= 16) {
                BigTextStyle bigText = new BigTextStyle(fVar.mo3468a()).setBigContentTitle(this.f2788b).bigText(this.f2735e);
                if (this.f2790d) {
                    bigText.setSummaryText(this.f2789c);
                }
            }
        }
    }

    /* renamed from: androidx.core.app.g$c */
    /* compiled from: NotificationCompat */
    public static class C0857c {

        /* renamed from: A */
        String f2736A;

        /* renamed from: B */
        Bundle f2737B;

        /* renamed from: C */
        int f2738C;

        /* renamed from: D */
        int f2739D;

        /* renamed from: E */
        Notification f2740E;

        /* renamed from: F */
        RemoteViews f2741F;

        /* renamed from: G */
        RemoteViews f2742G;

        /* renamed from: H */
        RemoteViews f2743H;

        /* renamed from: I */
        String f2744I;

        /* renamed from: J */
        int f2745J;

        /* renamed from: K */
        String f2746K;

        /* renamed from: L */
        long f2747L;

        /* renamed from: M */
        int f2748M;

        /* renamed from: N */
        Notification f2749N;
        @Deprecated

        /* renamed from: O */
        public ArrayList<String> f2750O;

        /* renamed from: a */
        public Context f2751a;

        /* renamed from: b */
        public ArrayList<C0855a> f2752b;

        /* renamed from: c */
        ArrayList<C0855a> f2753c;

        /* renamed from: d */
        CharSequence f2754d;

        /* renamed from: e */
        CharSequence f2755e;

        /* renamed from: f */
        PendingIntent f2756f;

        /* renamed from: g */
        PendingIntent f2757g;

        /* renamed from: h */
        RemoteViews f2758h;

        /* renamed from: i */
        Bitmap f2759i;

        /* renamed from: j */
        CharSequence f2760j;

        /* renamed from: k */
        int f2761k;

        /* renamed from: l */
        int f2762l;

        /* renamed from: m */
        boolean f2763m;

        /* renamed from: n */
        boolean f2764n;

        /* renamed from: o */
        C0860e f2765o;

        /* renamed from: p */
        CharSequence f2766p;

        /* renamed from: q */
        CharSequence[] f2767q;

        /* renamed from: r */
        int f2768r;

        /* renamed from: s */
        int f2769s;

        /* renamed from: t */
        boolean f2770t;

        /* renamed from: u */
        String f2771u;

        /* renamed from: v */
        boolean f2772v;

        /* renamed from: w */
        String f2773w;

        /* renamed from: x */
        boolean f2774x;

        /* renamed from: y */
        boolean f2775y;

        /* renamed from: z */
        boolean f2776z;

        public C0857c(Context context, String str) {
            this.f2752b = new ArrayList<>();
            this.f2753c = new ArrayList<>();
            this.f2763m = true;
            this.f2774x = false;
            this.f2738C = 0;
            this.f2739D = 0;
            this.f2745J = 0;
            this.f2748M = 0;
            this.f2749N = new Notification();
            this.f2751a = context;
            this.f2744I = str;
            this.f2749N.when = System.currentTimeMillis();
            this.f2749N.audioStreamType = -1;
            this.f2762l = 0;
            this.f2750O = new ArrayList<>();
        }

        @Deprecated
        public C0857c(Context context) {
            this(context, null);
        }

        /* renamed from: a */
        public C0857c mo3485a(long j) {
            this.f2749N.when = j;
            return this;
        }

        /* renamed from: a */
        public C0857c mo3481a(int i) {
            this.f2749N.icon = i;
            return this;
        }

        /* renamed from: a */
        public C0857c mo3490a(CharSequence charSequence) {
            this.f2754d = m3132d(charSequence);
            return this;
        }

        /* renamed from: b */
        public C0857c mo3496b(CharSequence charSequence) {
            this.f2755e = m3132d(charSequence);
            return this;
        }

        /* renamed from: a */
        public C0857c mo3483a(int i, int i2, boolean z) {
            this.f2768r = i;
            this.f2769s = i2;
            this.f2770t = z;
            return this;
        }

        /* renamed from: a */
        public C0857c mo3486a(PendingIntent pendingIntent) {
            this.f2756f = pendingIntent;
            return this;
        }

        /* renamed from: b */
        public C0857c mo3495b(PendingIntent pendingIntent) {
            this.f2749N.deleteIntent = pendingIntent;
            return this;
        }

        /* renamed from: c */
        public C0857c mo3500c(CharSequence charSequence) {
            this.f2749N.tickerText = m3132d(charSequence);
            return this;
        }

        /* renamed from: a */
        public C0857c mo3487a(Bitmap bitmap) {
            this.f2759i = m3131b(bitmap);
            return this;
        }

        /* renamed from: b */
        private Bitmap m3131b(Bitmap bitmap) {
            if (bitmap == null || VERSION.SDK_INT >= 27) {
                return bitmap;
            }
            Resources resources = this.f2751a.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_width);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_height);
            if (bitmap.getWidth() <= dimensionPixelSize && bitmap.getHeight() <= dimensionPixelSize2) {
                return bitmap;
            }
            double min = Math.min(((double) dimensionPixelSize) / ((double) Math.max(1, bitmap.getWidth())), ((double) dimensionPixelSize2) / ((double) Math.max(1, bitmap.getHeight())));
            return Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(((double) bitmap.getWidth()) * min), (int) Math.ceil(((double) bitmap.getHeight()) * min), true);
        }

        /* renamed from: a */
        public C0857c mo3488a(Uri uri) {
            this.f2749N.sound = uri;
            this.f2749N.audioStreamType = -1;
            if (VERSION.SDK_INT >= 21) {
                this.f2749N.audioAttributes = new Builder().setContentType(4).setUsage(5).build();
            }
            return this;
        }

        /* renamed from: a */
        public C0857c mo3482a(int i, int i2, int i3) {
            this.f2749N.ledARGB = i;
            this.f2749N.ledOnMS = i2;
            this.f2749N.ledOffMS = i3;
            this.f2749N.flags = ((this.f2749N.ledOnMS == 0 || this.f2749N.ledOffMS == 0) ? 0 : 1) | (this.f2749N.flags & -2);
            return this;
        }

        /* renamed from: a */
        public C0857c mo3492a(boolean z) {
            m3130a(2, z);
            return this;
        }

        /* renamed from: b */
        public C0857c mo3497b(boolean z) {
            m3130a(8, z);
            return this;
        }

        /* renamed from: c */
        public C0857c mo3501c(boolean z) {
            m3130a(16, z);
            return this;
        }

        /* renamed from: d */
        public C0857c mo3503d(boolean z) {
            this.f2774x = z;
            return this;
        }

        /* renamed from: b */
        public C0857c mo3494b(int i) {
            this.f2749N.defaults = i;
            if ((i & 4) != 0) {
                this.f2749N.flags |= 1;
            }
            return this;
        }

        /* renamed from: a */
        private void m3130a(int i, boolean z) {
            if (z) {
                Notification notification = this.f2749N;
                notification.flags = i | notification.flags;
                return;
            }
            Notification notification2 = this.f2749N;
            notification2.flags = (~i) & notification2.flags;
        }

        /* renamed from: c */
        public C0857c mo3499c(int i) {
            this.f2762l = i;
            return this;
        }

        /* renamed from: a */
        public Bundle mo3480a() {
            if (this.f2737B == null) {
                this.f2737B = new Bundle();
            }
            return this.f2737B;
        }

        /* renamed from: a */
        public C0857c mo3484a(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this.f2752b.add(new C0855a(i, charSequence, pendingIntent));
            return this;
        }

        /* renamed from: a */
        public C0857c mo3489a(C0860e eVar) {
            if (this.f2765o != eVar) {
                this.f2765o = eVar;
                if (this.f2765o != null) {
                    this.f2765o.mo3513a(this);
                }
            }
            return this;
        }

        /* renamed from: d */
        public C0857c mo3502d(int i) {
            this.f2738C = i;
            return this;
        }

        /* renamed from: a */
        public C0857c mo3491a(String str) {
            this.f2744I = str;
            return this;
        }

        /* renamed from: b */
        public Notification mo3493b() {
            return new C0861h(this).mo3517b();
        }

        /* renamed from: d */
        protected static CharSequence m3132d(CharSequence charSequence) {
            if (charSequence == null) {
                return charSequence;
            }
            if (charSequence.length() > 5120) {
                charSequence = charSequence.subSequence(0, 5120);
            }
            return charSequence;
        }

        /* renamed from: c */
        public int mo3498c() {
            return this.f2738C;
        }
    }

    /* renamed from: androidx.core.app.g$d */
    /* compiled from: NotificationCompat */
    public static class C0858d extends C0860e {

        /* renamed from: e */
        private final List<C0859a> f2777e = new ArrayList();

        /* renamed from: f */
        private C0863j f2778f;

        /* renamed from: g */
        private CharSequence f2779g;

        /* renamed from: h */
        private Boolean f2780h;

        /* renamed from: androidx.core.app.g$d$a */
        /* compiled from: NotificationCompat */
        public static final class C0859a {

            /* renamed from: a */
            private final CharSequence f2781a;

            /* renamed from: b */
            private final long f2782b;

            /* renamed from: c */
            private final C0863j f2783c;

            /* renamed from: d */
            private Bundle f2784d = new Bundle();

            /* renamed from: e */
            private String f2785e;

            /* renamed from: f */
            private Uri f2786f;

            public C0859a(CharSequence charSequence, long j, C0863j jVar) {
                this.f2781a = charSequence;
                this.f2782b = j;
                this.f2783c = jVar;
            }

            /* renamed from: a */
            public CharSequence mo3508a() {
                return this.f2781a;
            }

            /* renamed from: b */
            public long mo3509b() {
                return this.f2782b;
            }

            /* renamed from: c */
            public C0863j mo3510c() {
                return this.f2783c;
            }

            /* renamed from: d */
            public String mo3511d() {
                return this.f2785e;
            }

            /* renamed from: e */
            public Uri mo3512e() {
                return this.f2786f;
            }

            /* renamed from: f */
            private Bundle m3167f() {
                Bundle bundle = new Bundle();
                if (this.f2781a != null) {
                    bundle.putCharSequence("text", this.f2781a);
                }
                bundle.putLong("time", this.f2782b);
                if (this.f2783c != null) {
                    bundle.putCharSequence(MessageDTO.SENDER, this.f2783c.mo3521c());
                    if (VERSION.SDK_INT >= 28) {
                        bundle.putParcelable("sender_person", this.f2783c.mo3520b());
                    } else {
                        bundle.putBundle("person", this.f2783c.mo3519a());
                    }
                }
                if (this.f2785e != null) {
                    bundle.putString(Param.TYPE, this.f2785e);
                }
                if (this.f2786f != null) {
                    bundle.putParcelable("uri", this.f2786f);
                }
                if (this.f2784d != null) {
                    bundle.putBundle("extras", this.f2784d);
                }
                return bundle;
            }

            /* renamed from: a */
            static Bundle[] m3166a(List<C0859a> list) {
                Bundle[] bundleArr = new Bundle[list.size()];
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    bundleArr[i] = ((C0859a) list.get(i)).m3167f();
                }
                return bundleArr;
            }
        }

        private C0858d() {
        }

        public C0858d(C0863j jVar) {
            if (!TextUtils.isEmpty(jVar.mo3521c())) {
                this.f2778f = jVar;
                return;
            }
            throw new IllegalArgumentException("User's name must not be empty.");
        }

        /* renamed from: a */
        public C0858d mo3504a(C0859a aVar) {
            this.f2777e.add(aVar);
            if (this.f2777e.size() > 25) {
                this.f2777e.remove(0);
            }
            return this;
        }

        /* renamed from: a */
        public C0858d mo3505a(boolean z) {
            this.f2780h = Boolean.valueOf(z);
            return this;
        }

        /* renamed from: a */
        public boolean mo3507a() {
            boolean z = false;
            if (this.f2787a == null || this.f2787a.f2751a.getApplicationInfo().targetSdkVersion >= 28 || this.f2780h != null) {
                if (this.f2780h != null) {
                    z = this.f2780h.booleanValue();
                }
                return z;
            }
            if (this.f2779g != null) {
                z = true;
            }
            return z;
        }

        /* renamed from: a */
        public void mo3479a(C0853f fVar) {
            CharSequence charSequence;
            MessagingStyle messagingStyle;
            Message message;
            Person person;
            mo3505a(mo3507a());
            if (VERSION.SDK_INT >= 24) {
                if (VERSION.SDK_INT >= 28) {
                    messagingStyle = new MessagingStyle(this.f2778f.mo3520b());
                } else {
                    messagingStyle = new MessagingStyle(this.f2778f.mo3521c());
                }
                if (this.f2780h.booleanValue() || VERSION.SDK_INT >= 28) {
                    messagingStyle.setConversationTitle(this.f2779g);
                }
                if (VERSION.SDK_INT >= 28) {
                    messagingStyle.setGroupConversation(this.f2780h.booleanValue());
                }
                for (C0859a aVar : this.f2777e) {
                    if (VERSION.SDK_INT >= 28) {
                        C0863j c = aVar.mo3510c();
                        CharSequence a = aVar.mo3508a();
                        long b = aVar.mo3509b();
                        if (c == null) {
                            person = null;
                        } else {
                            person = c.mo3520b();
                        }
                        message = new Message(a, b, person);
                    } else {
                        message = new Message(aVar.mo3508a(), aVar.mo3509b(), aVar.mo3510c() != null ? aVar.mo3510c().mo3521c() : null);
                    }
                    if (aVar.mo3511d() != null) {
                        message.setData(aVar.mo3511d(), aVar.mo3512e());
                    }
                    messagingStyle.addMessage(message);
                }
                messagingStyle.setBuilder(fVar.mo3468a());
                return;
            }
            C0859a b2 = m3158b();
            if (this.f2779g != null && this.f2780h.booleanValue()) {
                fVar.mo3468a().setContentTitle(this.f2779g);
            } else if (b2 != null) {
                fVar.mo3468a().setContentTitle("");
                if (b2.mo3510c() != null) {
                    fVar.mo3468a().setContentTitle(b2.mo3510c().mo3521c());
                }
            }
            if (b2 != null) {
                Notification.Builder a2 = fVar.mo3468a();
                if (this.f2779g != null) {
                    charSequence = m3159b(b2);
                } else {
                    charSequence = b2.mo3508a();
                }
                a2.setContentText(charSequence);
            }
            if (VERSION.SDK_INT >= 16) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                boolean z = this.f2779g != null || m3160c();
                for (int size = this.f2777e.size() - 1; size >= 0; size--) {
                    C0859a aVar2 = (C0859a) this.f2777e.get(size);
                    CharSequence b3 = z ? m3159b(aVar2) : aVar2.mo3508a();
                    if (size != this.f2777e.size() - 1) {
                        spannableStringBuilder.insert(0, "\n");
                    }
                    spannableStringBuilder.insert(0, b3);
                }
                new BigTextStyle(fVar.mo3468a()).setBigContentTitle(null).bigText(spannableStringBuilder);
            }
        }

        /* renamed from: b */
        private C0859a m3158b() {
            for (int size = this.f2777e.size() - 1; size >= 0; size--) {
                C0859a aVar = (C0859a) this.f2777e.get(size);
                if (aVar.mo3510c() != null && !TextUtils.isEmpty(aVar.mo3510c().mo3521c())) {
                    return aVar;
                }
            }
            if (!this.f2777e.isEmpty()) {
                return (C0859a) this.f2777e.get(this.f2777e.size() - 1);
            }
            return null;
        }

        /* renamed from: c */
        private boolean m3160c() {
            for (int size = this.f2777e.size() - 1; size >= 0; size--) {
                C0859a aVar = (C0859a) this.f2777e.get(size);
                if (aVar.mo3510c() != null && aVar.mo3510c().mo3521c() == null) {
                    return true;
                }
            }
            return false;
        }

        /* renamed from: b */
        private CharSequence m3159b(C0859a aVar) {
            C0907a a = C0907a.m3344a();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            boolean z = VERSION.SDK_INT >= 21;
            int i = z ? -16777216 : -1;
            CharSequence c = aVar.mo3510c() == null ? "" : aVar.mo3510c().mo3521c();
            if (TextUtils.isEmpty(c)) {
                c = this.f2778f.mo3521c();
                if (z && this.f2787a.mo3498c() != 0) {
                    i = this.f2787a.mo3498c();
                }
            }
            CharSequence a2 = a.mo3609a(c);
            spannableStringBuilder.append(a2);
            spannableStringBuilder.setSpan(m3157a(i), spannableStringBuilder.length() - a2.length(), spannableStringBuilder.length(), 33);
            spannableStringBuilder.append("  ").append(a.mo3609a(aVar.mo3508a() == null ? "" : aVar.mo3508a()));
            return spannableStringBuilder;
        }

        /* renamed from: a */
        private TextAppearanceSpan m3157a(int i) {
            TextAppearanceSpan textAppearanceSpan = new TextAppearanceSpan(null, 0, 0, ColorStateList.valueOf(i), null);
            return textAppearanceSpan;
        }

        /* renamed from: a */
        public void mo3506a(Bundle bundle) {
            super.mo3506a(bundle);
            bundle.putCharSequence("android.selfDisplayName", this.f2778f.mo3521c());
            bundle.putBundle("android.messagingStyleUser", this.f2778f.mo3519a());
            bundle.putCharSequence("android.hiddenConversationTitle", this.f2779g);
            if (this.f2779g != null && this.f2780h.booleanValue()) {
                bundle.putCharSequence("android.conversationTitle", this.f2779g);
            }
            if (!this.f2777e.isEmpty()) {
                bundle.putParcelableArray("android.messages", C0859a.m3166a(this.f2777e));
            }
            if (this.f2780h != null) {
                bundle.putBoolean("android.isGroupConversation", this.f2780h.booleanValue());
            }
        }
    }

    /* renamed from: androidx.core.app.g$e */
    /* compiled from: NotificationCompat */
    public static abstract class C0860e {

        /* renamed from: a */
        protected C0857c f2787a;

        /* renamed from: b */
        CharSequence f2788b;

        /* renamed from: c */
        CharSequence f2789c;

        /* renamed from: d */
        boolean f2790d = false;

        /* renamed from: a */
        public void mo3506a(Bundle bundle) {
        }

        /* renamed from: a */
        public void mo3479a(C0853f fVar) {
        }

        /* renamed from: b */
        public RemoteViews mo3514b(C0853f fVar) {
            return null;
        }

        /* renamed from: c */
        public RemoteViews mo3515c(C0853f fVar) {
            return null;
        }

        /* renamed from: d */
        public RemoteViews mo3516d(C0853f fVar) {
            return null;
        }

        /* renamed from: a */
        public void mo3513a(C0857c cVar) {
            if (this.f2787a != cVar) {
                this.f2787a = cVar;
                if (this.f2787a != null) {
                    this.f2787a.mo3489a(this);
                }
            }
        }
    }

    /* renamed from: a */
    public static Bundle m3118a(Notification notification) {
        if (VERSION.SDK_INT >= 19) {
            return notification.extras;
        }
        if (VERSION.SDK_INT >= 16) {
            return C0862i.m3185a(notification);
        }
        return null;
    }
}
