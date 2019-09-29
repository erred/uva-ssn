package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.R;
import com.bridgefy.sdk.framework.entities.BleHandshake;

/* renamed from: androidx.appcompat.widget.az */
/* compiled from: TooltipPopup */
class C0653az {

    /* renamed from: a */
    private final Context f1898a;

    /* renamed from: b */
    private final View f1899b;

    /* renamed from: c */
    private final TextView f1900c;

    /* renamed from: d */
    private final LayoutParams f1901d = new LayoutParams();

    /* renamed from: e */
    private final Rect f1902e = new Rect();

    /* renamed from: f */
    private final int[] f1903f = new int[2];

    /* renamed from: g */
    private final int[] f1904g = new int[2];

    C0653az(Context context) {
        this.f1898a = context;
        this.f1899b = LayoutInflater.from(this.f1898a).inflate(R.layout.abc_tooltip, null);
        this.f1900c = (TextView) this.f1899b.findViewById(R.id.message);
        this.f1901d.setTitle(getClass().getSimpleName());
        this.f1901d.packageName = this.f1898a.getPackageName();
        this.f1901d.type = 1002;
        this.f1901d.width = -2;
        this.f1901d.height = -2;
        this.f1901d.format = -3;
        this.f1901d.windowAnimations = R.style.Animation_AppCompat_Tooltip;
        this.f1901d.flags = 24;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo2482a(View view, int i, int i2, boolean z, CharSequence charSequence) {
        if (mo2483b()) {
            mo2481a();
        }
        this.f1900c.setText(charSequence);
        m2306a(view, i, i2, z, this.f1901d);
        ((WindowManager) this.f1898a.getSystemService("window")).addView(this.f1899b, this.f1901d);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo2481a() {
        if (mo2483b()) {
            ((WindowManager) this.f1898a.getSystemService("window")).removeView(this.f1899b);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo2483b() {
        return this.f1899b.getParent() != null;
    }

    /* renamed from: a */
    private void m2306a(View view, int i, int i2, boolean z, LayoutParams layoutParams) {
        int i3;
        int i4;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.f1898a.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_threshold);
        if (view.getWidth() < dimensionPixelOffset) {
            i = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.f1898a.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_extra_offset);
            i4 = i2 + dimensionPixelOffset2;
            i3 = i2 - dimensionPixelOffset2;
        } else {
            i4 = view.getHeight();
            i3 = 0;
        }
        layoutParams.gravity = 49;
        int dimensionPixelOffset3 = this.f1898a.getResources().getDimensionPixelOffset(z ? R.dimen.tooltip_y_offset_touch : R.dimen.tooltip_y_offset_non_touch);
        View a = m2305a(view);
        if (a == null) {
            Log.e("TooltipPopup", "Cannot find app view");
            return;
        }
        a.getWindowVisibleDisplayFrame(this.f1902e);
        if (this.f1902e.left < 0 && this.f1902e.top < 0) {
            Resources resources = this.f1898a.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", BleHandshake.DEVICE_TYPE);
            int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            this.f1902e.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        a.getLocationOnScreen(this.f1904g);
        view.getLocationOnScreen(this.f1903f);
        int[] iArr = this.f1903f;
        iArr[0] = iArr[0] - this.f1904g[0];
        int[] iArr2 = this.f1903f;
        iArr2[1] = iArr2[1] - this.f1904g[1];
        layoutParams.x = (this.f1903f[0] + i) - (a.getWidth() / 2);
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        this.f1899b.measure(makeMeasureSpec, makeMeasureSpec);
        int measuredHeight = this.f1899b.getMeasuredHeight();
        int i5 = ((this.f1903f[1] + i3) - dimensionPixelOffset3) - measuredHeight;
        int i6 = this.f1903f[1] + i4 + dimensionPixelOffset3;
        if (z) {
            if (i5 >= 0) {
                layoutParams.y = i5;
            } else {
                layoutParams.y = i6;
            }
        } else if (measuredHeight + i6 <= this.f1902e.height()) {
            layoutParams.y = i6;
        } else {
            layoutParams.y = i5;
        }
    }

    /* renamed from: a */
    private static View m2305a(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if ((layoutParams instanceof LayoutParams) && ((LayoutParams) layoutParams).type == 2) {
            return rootView;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }
}
