package p140me.bridgefy.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.C1253h;
import androidx.recyclerview.widget.RecyclerView.C1259j;

/* renamed from: me.bridgefy.utils.e */
/* compiled from: DividerItemDecoration */
public class C3665e extends C1253h {

    /* renamed from: a */
    private static final int[] f9697a = {16843284};

    /* renamed from: b */
    private Drawable f9698b;

    /* renamed from: c */
    private int f9699c;

    public C3665e(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f9697a);
        this.f9698b = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        mo29831a(i);
    }

    /* renamed from: a */
    public void mo29831a(int i) {
        if (i == 0 || i == 1) {
            this.f9699c = i;
            return;
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    /* renamed from: a */
    public void mo5092a(Canvas canvas, RecyclerView recyclerView) {
        if (this.f9699c == 1) {
            mo29832c(canvas, recyclerView);
        } else {
            mo29833d(canvas, recyclerView);
        }
    }

    /* renamed from: c */
    public void mo29832c(Canvas canvas, RecyclerView recyclerView) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            int bottom = childAt.getBottom() + ((C1259j) childAt.getLayoutParams()).bottomMargin;
            this.f9698b.setBounds(paddingLeft, bottom, width, this.f9698b.getIntrinsicHeight() + bottom);
            this.f9698b.draw(canvas);
        }
    }

    /* renamed from: d */
    public void mo29833d(Canvas canvas, RecyclerView recyclerView) {
        int paddingTop = recyclerView.getPaddingTop();
        int height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            int right = childAt.getRight() + ((C1259j) childAt.getLayoutParams()).rightMargin;
            this.f9698b.setBounds(right, paddingTop, this.f9698b.getIntrinsicHeight() + right, height);
            this.f9698b.draw(canvas);
        }
    }

    /* renamed from: a */
    public void mo5094a(Rect rect, int i, RecyclerView recyclerView) {
        if (this.f9699c == 1) {
            rect.set(0, 0, 0, this.f9698b.getIntrinsicHeight());
        } else {
            rect.set(0, 0, this.f9698b.getIntrinsicWidth(), 0);
        }
    }
}
