package androidx.core.app;

import android.app.Notification;
import android.app.Notification.Action;
import android.app.Notification.Builder;
import android.app.RemoteInput;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.core.app.C0854g.C0855a;
import androidx.core.app.C0854g.C0857c;
import androidx.core.app.C0854g.C0860e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: androidx.core.app.h */
/* compiled from: NotificationCompatBuilder */
class C0861h implements C0853f {

    /* renamed from: a */
    private final Builder f2791a;

    /* renamed from: b */
    private final C0857c f2792b;

    /* renamed from: c */
    private RemoteViews f2793c;

    /* renamed from: d */
    private RemoteViews f2794d;

    /* renamed from: e */
    private final List<Bundle> f2795e = new ArrayList();

    /* renamed from: f */
    private final Bundle f2796f = new Bundle();

    /* renamed from: g */
    private int f2797g;

    /* renamed from: h */
    private RemoteViews f2798h;

    C0861h(C0857c cVar) {
        this.f2792b = cVar;
        if (VERSION.SDK_INT >= 26) {
            this.f2791a = new Builder(cVar.f2751a, cVar.f2744I);
        } else {
            this.f2791a = new Builder(cVar.f2751a);
        }
        Notification notification = cVar.f2749N;
        this.f2791a.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, cVar.f2758h).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(cVar.f2754d).setContentText(cVar.f2755e).setContentInfo(cVar.f2760j).setContentIntent(cVar.f2756f).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(cVar.f2757g, (notification.flags & 128) != 0).setLargeIcon(cVar.f2759i).setNumber(cVar.f2761k).setProgress(cVar.f2768r, cVar.f2769s, cVar.f2770t);
        if (VERSION.SDK_INT < 21) {
            this.f2791a.setSound(notification.sound, notification.audioStreamType);
        }
        if (VERSION.SDK_INT >= 16) {
            this.f2791a.setSubText(cVar.f2766p).setUsesChronometer(cVar.f2764n).setPriority(cVar.f2762l);
            Iterator it = cVar.f2752b.iterator();
            while (it.hasNext()) {
                m3180a((C0855a) it.next());
            }
            if (cVar.f2737B != null) {
                this.f2796f.putAll(cVar.f2737B);
            }
            if (VERSION.SDK_INT < 20) {
                if (cVar.f2774x) {
                    this.f2796f.putBoolean("android.support.localOnly", true);
                }
                if (cVar.f2771u != null) {
                    this.f2796f.putString("android.support.groupKey", cVar.f2771u);
                    if (cVar.f2772v) {
                        this.f2796f.putBoolean("android.support.isGroupSummary", true);
                    } else {
                        this.f2796f.putBoolean("android.support.useSideChannel", true);
                    }
                }
                if (cVar.f2773w != null) {
                    this.f2796f.putString("android.support.sortKey", cVar.f2773w);
                }
            }
            this.f2793c = cVar.f2741F;
            this.f2794d = cVar.f2742G;
        }
        if (VERSION.SDK_INT >= 19) {
            this.f2791a.setShowWhen(cVar.f2763m);
            if (VERSION.SDK_INT < 21 && cVar.f2750O != null && !cVar.f2750O.isEmpty()) {
                this.f2796f.putStringArray("android.people", (String[]) cVar.f2750O.toArray(new String[cVar.f2750O.size()]));
            }
        }
        if (VERSION.SDK_INT >= 20) {
            this.f2791a.setLocalOnly(cVar.f2774x).setGroup(cVar.f2771u).setGroupSummary(cVar.f2772v).setSortKey(cVar.f2773w);
            this.f2797g = cVar.f2748M;
        }
        if (VERSION.SDK_INT >= 21) {
            this.f2791a.setCategory(cVar.f2736A).setColor(cVar.f2738C).setVisibility(cVar.f2739D).setPublicVersion(cVar.f2740E).setSound(notification.sound, notification.audioAttributes);
            Iterator it2 = cVar.f2750O.iterator();
            while (it2.hasNext()) {
                this.f2791a.addPerson((String) it2.next());
            }
            this.f2798h = cVar.f2743H;
            if (cVar.f2753c.size() > 0) {
                Bundle bundle = cVar.mo3480a().getBundle("android.car.EXTENSIONS");
                if (bundle == null) {
                    bundle = new Bundle();
                }
                Bundle bundle2 = new Bundle();
                for (int i = 0; i < cVar.f2753c.size(); i++) {
                    bundle2.putBundle(Integer.toString(i), C0862i.m3186a((C0855a) cVar.f2753c.get(i)));
                }
                bundle.putBundle("invisible_actions", bundle2);
                cVar.mo3480a().putBundle("android.car.EXTENSIONS", bundle);
                this.f2796f.putBundle("android.car.EXTENSIONS", bundle);
            }
        }
        if (VERSION.SDK_INT >= 24) {
            this.f2791a.setExtras(cVar.f2737B).setRemoteInputHistory(cVar.f2767q);
            if (cVar.f2741F != null) {
                this.f2791a.setCustomContentView(cVar.f2741F);
            }
            if (cVar.f2742G != null) {
                this.f2791a.setCustomBigContentView(cVar.f2742G);
            }
            if (cVar.f2743H != null) {
                this.f2791a.setCustomHeadsUpContentView(cVar.f2743H);
            }
        }
        if (VERSION.SDK_INT >= 26) {
            this.f2791a.setBadgeIconType(cVar.f2745J).setShortcutId(cVar.f2746K).setTimeoutAfter(cVar.f2747L).setGroupAlertBehavior(cVar.f2748M);
            if (cVar.f2776z) {
                this.f2791a.setColorized(cVar.f2775y);
            }
            if (!TextUtils.isEmpty(cVar.f2744I)) {
                this.f2791a.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
    }

    /* renamed from: a */
    public Builder mo3468a() {
        return this.f2791a;
    }

    /* renamed from: b */
    public Notification mo3517b() {
        C0860e eVar = this.f2792b.f2765o;
        if (eVar != null) {
            eVar.mo3479a((C0853f) this);
        }
        RemoteViews b = eVar != null ? eVar.mo3514b(this) : null;
        Notification c = mo3518c();
        if (b != null) {
            c.contentView = b;
        } else if (this.f2792b.f2741F != null) {
            c.contentView = this.f2792b.f2741F;
        }
        if (VERSION.SDK_INT >= 16 && eVar != null) {
            RemoteViews c2 = eVar.mo3515c(this);
            if (c2 != null) {
                c.bigContentView = c2;
            }
        }
        if (VERSION.SDK_INT >= 21 && eVar != null) {
            RemoteViews d = this.f2792b.f2765o.mo3516d(this);
            if (d != null) {
                c.headsUpContentView = d;
            }
        }
        if (VERSION.SDK_INT >= 16 && eVar != null) {
            Bundle a = C0854g.m3118a(c);
            if (a != null) {
                eVar.mo3506a(a);
            }
        }
        return c;
    }

    /* renamed from: a */
    private void m3180a(C0855a aVar) {
        Bundle bundle;
        if (VERSION.SDK_INT >= 20) {
            Action.Builder builder = new Action.Builder(aVar.mo3469a(), aVar.mo3470b(), aVar.mo3471c());
            if (aVar.mo3474f() != null) {
                for (RemoteInput addRemoteInput : C0865k.m3201a(aVar.mo3474f())) {
                    builder.addRemoteInput(addRemoteInput);
                }
            }
            if (aVar.mo3472d() != null) {
                bundle = new Bundle(aVar.mo3472d());
            } else {
                bundle = new Bundle();
            }
            bundle.putBoolean("android.support.allowGeneratedReplies", aVar.mo3473e());
            if (VERSION.SDK_INT >= 24) {
                builder.setAllowGeneratedReplies(aVar.mo3473e());
            }
            bundle.putInt("android.support.action.semanticAction", aVar.mo3475g());
            if (VERSION.SDK_INT >= 28) {
                builder.setSemanticAction(aVar.mo3475g());
            }
            bundle.putBoolean("android.support.action.showsUserInterface", aVar.mo3477i());
            builder.addExtras(bundle);
            this.f2791a.addAction(builder.build());
        } else if (VERSION.SDK_INT >= 16) {
            this.f2795e.add(C0862i.m3184a(this.f2791a, aVar));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public Notification mo3518c() {
        if (VERSION.SDK_INT >= 26) {
            return this.f2791a.build();
        }
        if (VERSION.SDK_INT >= 24) {
            Notification build = this.f2791a.build();
            if (this.f2797g != 0) {
                if (!(build.getGroup() == null || (build.flags & 512) == 0 || this.f2797g != 2)) {
                    m3179a(build);
                }
                if (build.getGroup() != null && (build.flags & 512) == 0 && this.f2797g == 1) {
                    m3179a(build);
                }
            }
            return build;
        } else if (VERSION.SDK_INT >= 21) {
            this.f2791a.setExtras(this.f2796f);
            Notification build2 = this.f2791a.build();
            if (this.f2793c != null) {
                build2.contentView = this.f2793c;
            }
            if (this.f2794d != null) {
                build2.bigContentView = this.f2794d;
            }
            if (this.f2798h != null) {
                build2.headsUpContentView = this.f2798h;
            }
            if (this.f2797g != 0) {
                if (!(build2.getGroup() == null || (build2.flags & 512) == 0 || this.f2797g != 2)) {
                    m3179a(build2);
                }
                if (build2.getGroup() != null && (build2.flags & 512) == 0 && this.f2797g == 1) {
                    m3179a(build2);
                }
            }
            return build2;
        } else if (VERSION.SDK_INT >= 20) {
            this.f2791a.setExtras(this.f2796f);
            Notification build3 = this.f2791a.build();
            if (this.f2793c != null) {
                build3.contentView = this.f2793c;
            }
            if (this.f2794d != null) {
                build3.bigContentView = this.f2794d;
            }
            if (this.f2797g != 0) {
                if (!(build3.getGroup() == null || (build3.flags & 512) == 0 || this.f2797g != 2)) {
                    m3179a(build3);
                }
                if (build3.getGroup() != null && (build3.flags & 512) == 0 && this.f2797g == 1) {
                    m3179a(build3);
                }
            }
            return build3;
        } else if (VERSION.SDK_INT >= 19) {
            SparseArray a = C0862i.m3188a(this.f2795e);
            if (a != null) {
                this.f2796f.putSparseParcelableArray("android.support.actionExtras", a);
            }
            this.f2791a.setExtras(this.f2796f);
            Notification build4 = this.f2791a.build();
            if (this.f2793c != null) {
                build4.contentView = this.f2793c;
            }
            if (this.f2794d != null) {
                build4.bigContentView = this.f2794d;
            }
            return build4;
        } else if (VERSION.SDK_INT < 16) {
            return this.f2791a.getNotification();
        } else {
            Notification build5 = this.f2791a.build();
            Bundle a2 = C0854g.m3118a(build5);
            Bundle bundle = new Bundle(this.f2796f);
            for (String str : this.f2796f.keySet()) {
                if (a2.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            a2.putAll(bundle);
            SparseArray a3 = C0862i.m3188a(this.f2795e);
            if (a3 != null) {
                C0854g.m3118a(build5).putSparseParcelableArray("android.support.actionExtras", a3);
            }
            if (this.f2793c != null) {
                build5.contentView = this.f2793c;
            }
            if (this.f2794d != null) {
                build5.bigContentView = this.f2794d;
            }
            return build5;
        }
    }

    /* renamed from: a */
    private void m3179a(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -2;
        notification.defaults &= -3;
    }
}
