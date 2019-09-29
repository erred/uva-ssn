package p140me.bridgefy.utils;

import android.content.Context;
import android.os.Vibrator;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.p070g.C0962r;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.C1262m;
import com.p110b.p111a.C1857a;
import p140me.bridgefy.chat.ChatEntryFragment;

/* renamed from: me.bridgefy.utils.k */
/* compiled from: SwipeableItemClickAndLongClickListener */
public class C3673k implements C1262m {

    /* renamed from: a */
    private final C1857a f9709a;

    /* renamed from: b */
    private final GestureDetector f9710b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f9711c;

    /* renamed from: a */
    public void mo5203a(boolean z) {
    }

    /* renamed from: b */
    public void mo5205b(RecyclerView recyclerView, MotionEvent motionEvent) {
    }

    public C3673k(final Context context, C1857a aVar, final ChatEntryFragment chatEntryFragment) {
        this.f9709a = aVar;
        this.f9710b = new GestureDetector(context, new SimpleOnGestureListener() {
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                return true;
            }

            public void onLongPress(MotionEvent motionEvent) {
                ((Vibrator) context.getSystemService("vibrator")).vibrate(C3661c.f9690d, -1);
                chatEntryFragment.mo29107a(C3673k.this.f9711c);
            }
        });
    }

    /* renamed from: a */
    public boolean mo5204a(RecyclerView recyclerView, MotionEvent motionEvent) {
        View findChildViewUnder = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
        this.f9711c = recyclerView.getChildLayoutPosition(findChildViewUnder);
        if (!(findChildViewUnder == null || this.f9709a == null || !this.f9710b.onTouchEvent(motionEvent) || this.f9711c == -1)) {
            this.f9709a.onItemClick(m10959a(findChildViewUnder, motionEvent), this.f9711c);
        }
        return false;
    }

    /* renamed from: a */
    private View m10959a(View view, MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        View view2 = view;
        while ((view instanceof ViewGroup) && view2 != null) {
            x -= (float) view.getLeft();
            y -= (float) view.getTop();
            view2 = m10960a((ViewGroup) view, x, y);
            if (view2 != null) {
                view = view2;
            }
        }
        return view;
    }

    /* renamed from: a */
    private View m10960a(ViewGroup viewGroup, float f, float f2) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt.getVisibility() != 8) {
                float j = C0962r.m3587j(childAt);
                float k = C0962r.m3588k(childAt);
                if (f >= ((float) childAt.getLeft()) + j && f <= ((float) childAt.getRight()) + j && f2 >= ((float) childAt.getTop()) + k && f2 <= ((float) childAt.getBottom()) + k) {
                    return childAt;
                }
            }
        }
        return null;
    }
}
