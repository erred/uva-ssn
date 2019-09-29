package com.twitter.sdk.android.core.internal;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.twitter.sdk.android.core.internal.a */
/* compiled from: ActivityLifecycleManager */
public class C3152a {

    /* renamed from: a */
    private final C3153a f8303a;

    /* renamed from: com.twitter.sdk.android.core.internal.a$a */
    /* compiled from: ActivityLifecycleManager */
    private static class C3153a {

        /* renamed from: a */
        private final Set<ActivityLifecycleCallbacks> f8304a = new HashSet();

        /* renamed from: b */
        private final Application f8305b;

        C3153a(Application application) {
            this.f8305b = application;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public boolean m9235a(final C3155b bVar) {
            if (this.f8305b == null) {
                return false;
            }
            C31541 r0 = new ActivityLifecycleCallbacks() {
                public void onActivityCreated(Activity activity, Bundle bundle) {
                    bVar.mo27668a(activity, bundle);
                }

                public void onActivityStarted(Activity activity) {
                    bVar.mo27667a(activity);
                }

                public void onActivityResumed(Activity activity) {
                    bVar.mo27669b(activity);
                }

                public void onActivityPaused(Activity activity) {
                    bVar.mo27671c(activity);
                }

                public void onActivityStopped(Activity activity) {
                    bVar.mo27672d(activity);
                }

                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    bVar.mo27670b(activity, bundle);
                }

                public void onActivityDestroyed(Activity activity) {
                    bVar.mo27673e(activity);
                }
            };
            this.f8305b.registerActivityLifecycleCallbacks(r0);
            this.f8304a.add(r0);
            return true;
        }
    }

    /* renamed from: com.twitter.sdk.android.core.internal.a$b */
    /* compiled from: ActivityLifecycleManager */
    public static abstract class C3155b {
        /* renamed from: a */
        public void mo27667a(Activity activity) {
        }

        /* renamed from: a */
        public void mo27668a(Activity activity, Bundle bundle) {
        }

        /* renamed from: b */
        public void mo27669b(Activity activity) {
        }

        /* renamed from: b */
        public void mo27670b(Activity activity, Bundle bundle) {
        }

        /* renamed from: c */
        public void mo27671c(Activity activity) {
        }

        /* renamed from: d */
        public void mo27672d(Activity activity) {
        }

        /* renamed from: e */
        public void mo27673e(Activity activity) {
        }
    }

    public C3152a(Context context) {
        this.f8303a = new C3153a((Application) context.getApplicationContext());
    }

    /* renamed from: a */
    public boolean mo27659a(C3155b bVar) {
        return this.f8303a != null && this.f8303a.m9235a(bVar);
    }
}
