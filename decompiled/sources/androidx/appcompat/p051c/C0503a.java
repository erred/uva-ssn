package androidx.appcompat.p051c;

import android.content.Context;
import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import java.util.Locale;

/* renamed from: androidx.appcompat.c.a */
/* compiled from: AllCapsTransformationMethod */
public class C0503a implements TransformationMethod {

    /* renamed from: a */
    private Locale f1211a;

    public void onFocusChanged(View view, CharSequence charSequence, boolean z, int i, Rect rect) {
    }

    public C0503a(Context context) {
        this.f1211a = context.getResources().getConfiguration().locale;
    }

    public CharSequence getTransformation(CharSequence charSequence, View view) {
        if (charSequence != null) {
            return charSequence.toString().toUpperCase(this.f1211a);
        }
        return null;
    }
}
