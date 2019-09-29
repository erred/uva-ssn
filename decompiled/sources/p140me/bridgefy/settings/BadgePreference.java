package p140me.bridgefy.settings;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.p047a.p048a.C0424a;
import me.bridgefy.main.R;

/* renamed from: me.bridgefy.settings.BadgePreference */
public class BadgePreference extends Preference {

    /* renamed from: a */
    private Drawable f9584a = null;

    /* renamed from: b */
    private TextView f9585b;

    public BadgePreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public BadgePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public BadgePreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.BadgePreference, -1, -1);
        try {
            this.f9584a = C0424a.m1270b(context, obtainStyledAttributes.getResourceId(0, -1));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public BadgePreference(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onBindView(View view) {
        super.onBindView(view);
        this.f9585b = (TextView) view.findViewById(16908310);
        if (this.f9584a != null) {
            mo29696a(this.f9584a);
        }
    }

    /* renamed from: a */
    public void mo29696a(Drawable drawable) {
        this.f9584a = drawable;
        this.f9585b.setCompoundDrawablePadding(20);
        this.f9585b.setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null);
    }
}
