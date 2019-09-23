package androidx.core.p070g;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.p070g.p071a.C0935b;
import androidx.core.p070g.p071a.C0939c;

/* renamed from: androidx.core.g.a */
/* compiled from: AccessibilityDelegateCompat */
public class C0932a {
    private static final AccessibilityDelegate DEFAULT_DELEGATE = new AccessibilityDelegate();
    private final AccessibilityDelegate mBridge = new C0933a(this);

    /* renamed from: androidx.core.g.a$a */
    /* compiled from: AccessibilityDelegateCompat */
    private static final class C0933a extends AccessibilityDelegate {

        /* renamed from: a */
        private final C0932a f2953a;

        C0933a(C0932a aVar) {
            this.f2953a = aVar;
        }

        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f2953a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f2953a.onInitializeAccessibilityEvent(view, accessibilityEvent);
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            this.f2953a.onInitializeAccessibilityNodeInfo(view, C0935b.m3414a(accessibilityNodeInfo));
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f2953a.onPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f2953a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        public void sendAccessibilityEvent(View view, int i) {
            this.f2953a.sendAccessibilityEvent(view, i);
        }

        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f2953a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
        }

        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            C0939c accessibilityNodeProvider = this.f2953a.getAccessibilityNodeProvider(view);
            if (accessibilityNodeProvider != null) {
                return (AccessibilityNodeProvider) accessibilityNodeProvider.mo3722a();
            }
            return null;
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return this.f2953a.performAccessibilityAction(view, i, bundle);
        }
    }

    /* access modifiers changed from: 0000 */
    public AccessibilityDelegate getBridge() {
        return this.mBridge;
    }

    public void sendAccessibilityEvent(View view, int i) {
        DEFAULT_DELEGATE.sendAccessibilityEvent(view, i);
    }

    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        DEFAULT_DELEGATE.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return DEFAULT_DELEGATE.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        DEFAULT_DELEGATE.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        DEFAULT_DELEGATE.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void onInitializeAccessibilityNodeInfo(View view, C0935b bVar) {
        DEFAULT_DELEGATE.onInitializeAccessibilityNodeInfo(view, bVar.mo3668a());
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return DEFAULT_DELEGATE.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public C0939c getAccessibilityNodeProvider(View view) {
        if (VERSION.SDK_INT >= 16) {
            AccessibilityNodeProvider accessibilityNodeProvider = DEFAULT_DELEGATE.getAccessibilityNodeProvider(view);
            if (accessibilityNodeProvider != null) {
                return new C0939c(accessibilityNodeProvider);
            }
        }
        return null;
    }

    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        if (VERSION.SDK_INT >= 16) {
            return DEFAULT_DELEGATE.performAccessibilityAction(view, i, bundle);
        }
        return false;
    }
}
