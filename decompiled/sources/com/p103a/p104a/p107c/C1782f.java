package com.p103a.p104a.p107c;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.ScrollView;
import android.widget.TextView;
import java.util.concurrent.CountDownLatch;
import p000a.p001a.p002a.p003a.p004a.p012g.C0121o;

/* renamed from: com.a.a.c.f */
/* compiled from: CrashPromptDialog */
class C1782f {

    /* renamed from: a */
    private final C1787b f5560a;

    /* renamed from: b */
    private final Builder f5561b;

    /* renamed from: com.a.a.c.f$a */
    /* compiled from: CrashPromptDialog */
    interface C1786a {
        /* renamed from: a */
        void mo7079a(boolean z);
    }

    /* renamed from: com.a.a.c.f$b */
    /* compiled from: CrashPromptDialog */
    private static class C1787b {

        /* renamed from: a */
        private boolean f5566a;

        /* renamed from: b */
        private final CountDownLatch f5567b;

        private C1787b() {
            this.f5566a = false;
            this.f5567b = new CountDownLatch(1);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo7080a(boolean z) {
            this.f5566a = z;
            this.f5567b.countDown();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo7081a() {
            return this.f5566a;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo7082b() {
            try {
                this.f5567b.await();
            } catch (InterruptedException unused) {
            }
        }
    }

    /* renamed from: a */
    private static int m7408a(float f, int i) {
        return (int) (f * ((float) i));
    }

    /* renamed from: a */
    public static C1782f m7410a(Activity activity, C0121o oVar, final C1786a aVar) {
        final C1787b bVar = new C1787b();
        C1832r rVar = new C1832r(activity, oVar);
        Builder builder = new Builder(activity);
        ScrollView a = m7409a(activity, rVar.mo7162b());
        builder.setView(a).setTitle(rVar.mo7161a()).setCancelable(false).setNeutralButton(rVar.mo7163c(), new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                bVar.mo7080a(true);
                dialogInterface.dismiss();
            }
        });
        if (oVar.f268d) {
            builder.setNegativeButton(rVar.mo7165e(), new OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    bVar.mo7080a(false);
                    dialogInterface.dismiss();
                }
            });
        }
        if (oVar.f270f) {
            builder.setPositiveButton(rVar.mo7164d(), new OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    aVar.mo7079a(true);
                    bVar.mo7080a(true);
                    dialogInterface.dismiss();
                }
            });
        }
        return new C1782f(builder, bVar);
    }

    /* renamed from: a */
    private static ScrollView m7409a(Activity activity, String str) {
        float f = activity.getResources().getDisplayMetrics().density;
        int a = m7408a(f, 5);
        TextView textView = new TextView(activity);
        textView.setAutoLinkMask(15);
        textView.setText(str);
        textView.setTextAppearance(activity, 16973892);
        textView.setPadding(a, a, a, a);
        textView.setFocusable(false);
        ScrollView scrollView = new ScrollView(activity);
        scrollView.setPadding(m7408a(f, 14), m7408a(f, 2), m7408a(f, 10), m7408a(f, 12));
        scrollView.addView(textView);
        return scrollView;
    }

    private C1782f(Builder builder, C1787b bVar) {
        this.f5560a = bVar;
        this.f5561b = builder;
    }

    /* renamed from: a */
    public void mo7073a() {
        this.f5561b.show();
    }

    /* renamed from: b */
    public void mo7074b() {
        this.f5560a.mo7082b();
    }

    /* renamed from: c */
    public boolean mo7075c() {
        return this.f5560a.mo7081a();
    }
}
