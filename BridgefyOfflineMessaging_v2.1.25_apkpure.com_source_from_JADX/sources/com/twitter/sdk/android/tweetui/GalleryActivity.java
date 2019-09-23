package com.twitter.sdk.android.tweetui;

import android.app.Activity;
import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.C1475f;
import com.twitter.sdk.android.core.internal.scribe.C3243w;
import com.twitter.sdk.android.core.p132a.C3112j;
import com.twitter.sdk.android.tweetui.internal.C3353f.C3355a;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class GalleryActivity extends Activity {

    /* renamed from: a */
    C3305a f8620a;

    /* renamed from: b */
    final C3315c f8621b = new C3316d(C3363m.m9824a());

    /* renamed from: com.twitter.sdk.android.tweetui.GalleryActivity$a */
    public static class C3305a implements Serializable {

        /* renamed from: a */
        public final long f8625a;

        /* renamed from: b */
        public final int f8626b;

        /* renamed from: c */
        public final List<C3112j> f8627c;

        public C3305a(int i, List<C3112j> list) {
            this(0, i, list);
        }

        public C3305a(long j, int i, List<C3112j> list) {
            this.f8625a = j;
            this.f8626b = i;
            this.f8627c = list;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.tw__gallery_activity);
        this.f8620a = mo27972c();
        if (bundle == null) {
            mo27973d();
        }
        C3314b bVar = new C3314b(this, mo27971b());
        bVar.mo27997a(this.f8620a.f8627c);
        ViewPager viewPager = (ViewPager) findViewById(R.id.tw__view_pager);
        viewPager.setPageMargin(getResources().getDimensionPixelSize(R.dimen.tw__gallery_page_margin));
        viewPager.mo6069a(mo27969a());
        viewPager.setAdapter(bVar);
        viewPager.setCurrentItem(this.f8620a.f8626b);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C1475f mo27969a() {
        return new C1475f() {

            /* renamed from: a */
            int f8622a = -1;

            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
                if (this.f8622a == -1 && i == 0 && ((double) f) == 0.0d) {
                    GalleryActivity.this.mo27970a(i);
                    this.f8622a++;
                }
            }

            public void onPageSelected(int i) {
                if (this.f8622a >= 0) {
                    GalleryActivity.this.mo27975f();
                }
                this.f8622a++;
                GalleryActivity.this.mo27970a(i);
            }
        };
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C3355a mo27971b() {
        return new C3355a() {
            /* renamed from: a */
            public void mo27979a(float f) {
            }

            /* renamed from: a */
            public void mo27978a() {
                GalleryActivity.this.mo27974e();
                GalleryActivity.this.finish();
                GalleryActivity.this.overridePendingTransition(0, R.anim.tw__slide_out);
            }
        };
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public C3305a mo27972c() {
        C3112j jVar = (C3112j) getIntent().getSerializableExtra("MEDIA_ENTITY");
        if (jVar != null) {
            return new C3305a(0, Collections.singletonList(jVar));
        }
        return (C3305a) getIntent().getSerializableExtra("GALLERY_ITEM");
    }

    public void onBackPressed() {
        mo27974e();
        super.onBackPressed();
        overridePendingTransition(0, R.anim.tw__slide_out);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo27973d() {
        this.f8621b.mo27998a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo27974e() {
        this.f8621b.mo28001c();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo27970a(int i) {
        this.f8621b.mo27999a(C3243w.m9518a(this.f8620a.f8625a, (C3112j) this.f8620a.f8627c.get(i)));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public void mo27975f() {
        this.f8621b.mo28000b();
    }
}
