package com.twitter.sdk.android.tweetui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.C1481a;
import com.squareup.picasso.C3027ac;
import com.squareup.picasso.C3068t;
import com.twitter.sdk.android.core.p132a.C3112j;
import com.twitter.sdk.android.tweetui.internal.C3345b;
import com.twitter.sdk.android.tweetui.internal.C3353f.C3355a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.twitter.sdk.android.tweetui.b */
/* compiled from: GalleryAdapter */
class C3314b extends C1481a {

    /* renamed from: a */
    final List<C3112j> f8646a = new ArrayList();

    /* renamed from: b */
    final Context f8647b;

    /* renamed from: c */
    final C3355a f8648c;

    /* renamed from: a */
    public boolean mo4503a(View view, Object obj) {
        return view == obj;
    }

    C3314b(Context context, C3355a aVar) {
        this.f8647b = context;
        this.f8648c = aVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo27997a(List<C3112j> list) {
        this.f8646a.addAll(list);
        mo6156c();
    }

    /* renamed from: b */
    public int mo6151b() {
        return this.f8646a.size();
    }

    /* renamed from: a */
    public Object mo4499a(ViewGroup viewGroup, int i) {
        C3345b bVar = new C3345b(this.f8647b);
        bVar.setSwipeToDismissCallback(this.f8648c);
        viewGroup.addView(bVar);
        C3068t.with(this.f8647b).mo27533a(((C3112j) this.f8646a.get(i)).f8169b).mo27577a((C3027ac) bVar);
        return bVar;
    }

    /* renamed from: a */
    public void mo4502a(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }
}
