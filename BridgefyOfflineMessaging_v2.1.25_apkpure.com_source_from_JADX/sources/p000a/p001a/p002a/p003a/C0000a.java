package p000a.p001a.p002a.p003a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Set;

/* renamed from: a.a.a.a.a */
/* compiled from: ActivityLifecycleManager */
public class C0000a {

    /* renamed from: a */
    private final Application f0a;

    /* renamed from: b */
    private C0001a f1b;

    /* renamed from: a.a.a.a.a$a */
    /* compiled from: ActivityLifecycleManager */
    private static class C0001a {

        /* renamed from: a */
        private final Set<ActivityLifecycleCallbacks> f2a = new HashSet();

        /* renamed from: b */
        private final Application f3b;

        C0001a(Application application) {
            this.f3b = application;
        }

        /* access modifiers changed from: private */
        @TargetApi(14)
        /* renamed from: a */
        public void m2a() {
            for (ActivityLifecycleCallbacks unregisterActivityLifecycleCallbacks : this.f2a) {
                this.f3b.unregisterActivityLifecycleCallbacks(unregisterActivityLifecycleCallbacks);
            }
        }

        /* access modifiers changed from: private */
        @TargetApi(14)
        /* renamed from: a */
        public boolean m5a(final C0003b bVar) {
            if (this.f3b == null) {
                return false;
            }
            C00021 r0 = new ActivityLifecycleCallbacks() {
                public void onActivityCreated(Activity activity, Bundle bundle) {
                    bVar.mo11a(activity, bundle);
                }

                public void onActivityStarted(Activity activity) {
                    bVar.mo10a(activity);
                }

                public void onActivityResumed(Activity activity) {
                    bVar.mo12b(activity);
                }

                public void onActivityPaused(Activity activity) {
                    bVar.mo14c(activity);
                }

                public void onActivityStopped(Activity activity) {
                    bVar.mo15d(activity);
                }

                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    bVar.mo13b(activity, bundle);
                }

                public void onActivityDestroyed(Activity activity) {
                    bVar.mo16e(activity);
                }
            };
            this.f3b.registerActivityLifecycleCallbacks(r0);
            this.f2a.add(r0);
            return true;
        }
    }

    /* renamed from: a.a.a.a.a$b */
    /* compiled from: ActivityLifecycleManager */
    public static abstract class C0003b {
        /* renamed from: a */
        public void mo10a(Activity activity) {
        }

        /* renamed from: a */
        public void mo11a(Activity activity, Bundle bundle) {
        }

        /* renamed from: b */
        public void mo12b(Activity activity) {
        }

        /* renamed from: b */
        public void mo13b(Activity activity, Bundle bundle) {
        }

        /* renamed from: c */
        public void mo14c(Activity activity) {
        }

        /* renamed from: d */
        public void mo15d(Activity activity) {
        }

        /* renamed from: e */
        public void mo16e(Activity activity) {
        }
    }

    public C0000a(Context context) {
        this.f0a = (Application) context.getApplicationContext();
        if (VERSION.SDK_INT >= 14) {
            this.f1b = new C0001a(this.f0a);
        }
    }

    /* renamed from: a */
    public boolean mo2a(C0003b bVar) {
        return this.f1b != null && this.f1b.m5a(bVar);
    }

    /* renamed from: a */
    public void mo1a() {
        if (this.f1b != null) {
            this.f1b.m2a();
        }
    }
}
