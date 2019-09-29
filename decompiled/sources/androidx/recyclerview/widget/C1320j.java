package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.p070g.C0932a;
import androidx.core.p070g.p071a.C0935b;

/* renamed from: androidx.recyclerview.widget.j */
/* compiled from: RecyclerViewAccessibilityDelegate */
public class C1320j extends C0932a {
    final C0932a mItemDelegate = new C1321a(this);
    final RecyclerView mRecyclerView;

    /* renamed from: androidx.recyclerview.widget.j$a */
    /* compiled from: RecyclerViewAccessibilityDelegate */
    public static class C1321a extends C0932a {

        /* renamed from: a */
        final C1320j f3983a;

        public C1321a(C1320j jVar) {
            this.f3983a = jVar;
        }

        public void onInitializeAccessibilityNodeInfo(View view, C0935b bVar) {
            super.onInitializeAccessibilityNodeInfo(view, bVar);
            if (!this.f3983a.shouldIgnore() && this.f3983a.mRecyclerView.getLayoutManager() != null) {
                this.f3983a.mRecyclerView.getLayoutManager().mo5116a(view, bVar);
            }
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            if (this.f3983a.shouldIgnore() || this.f3983a.mRecyclerView.getLayoutManager() == null) {
                return false;
            }
            return this.f3983a.mRecyclerView.getLayoutManager().mo5128a(view, i, bundle);
        }
    }

    public C1320j(RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
    }

    /* access modifiers changed from: 0000 */
    public boolean shouldIgnore() {
        return this.mRecyclerView.hasPendingAdapterUpdates();
    }

    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        if (super.performAccessibilityAction(view, i, bundle)) {
            return true;
        }
        if (shouldIgnore() || this.mRecyclerView.getLayoutManager() == null) {
            return false;
        }
        return this.mRecyclerView.getLayoutManager().mo5126a(i, bundle);
    }

    public void onInitializeAccessibilityNodeInfo(View view, C0935b bVar) {
        super.onInitializeAccessibilityNodeInfo(view, bVar);
        bVar.mo3679b((CharSequence) RecyclerView.class.getName());
        if (!shouldIgnore() && this.mRecyclerView.getLayoutManager() != null) {
            this.mRecyclerView.getLayoutManager().mo5119a(bVar);
        }
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setClassName(RecyclerView.class.getName());
        if ((view instanceof RecyclerView) && !shouldIgnore()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().mo4764a(accessibilityEvent);
            }
        }
    }

    public C0932a getItemDelegate() {
        return this.mItemDelegate;
    }
}
