package com.p110b.p111a.p112a;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: com.b.a.a.a */
/* compiled from: RecyclerViewAdapter */
public class C1858a implements C1859b {

    /* renamed from: a */
    private final RecyclerView f5712a;

    public C1858a(RecyclerView recyclerView) {
        this.f5712a = recyclerView;
    }

    /* renamed from: a */
    public Context mo7180a() {
        return this.f5712a.getContext();
    }

    /* renamed from: b */
    public int mo7185b() {
        return this.f5712a.getWidth();
    }

    /* renamed from: c */
    public int mo7186c() {
        return this.f5712a.getChildCount();
    }

    /* renamed from: a */
    public void mo7184a(int[] iArr) {
        this.f5712a.getLocationOnScreen(iArr);
    }

    /* renamed from: a */
    public View mo7181a(int i) {
        return this.f5712a.getChildAt(i);
    }

    /* renamed from: a */
    public int mo7179a(View view) {
        return this.f5712a.getChildPosition(view);
    }

    /* renamed from: a */
    public void mo7183a(boolean z) {
        this.f5712a.requestDisallowInterceptTouchEvent(z);
    }

    /* renamed from: a */
    public void mo7182a(MotionEvent motionEvent) {
        this.f5712a.onTouchEvent(motionEvent);
    }
}
