package com.mikepenz.iconics.p128a;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.menu.ActionMenuItemView;
import com.mikepenz.iconics.C2981a;
import com.mikepenz.iconics.C2981a.C2982a;
import com.mikepenz.iconics.C2994b;
import com.mikepenz.iconics.core.R;

/* renamed from: com.mikepenz.iconics.a.d */
/* compiled from: IconicsFactory */
class C2987d {
    C2987d() {
    }

    /* renamed from: a */
    public View mo27325a(View view, Context context, AttributeSet attributeSet) {
        if (!(view == null || view.getTag(R.id.iconics_tag_id) == Boolean.TRUE)) {
            mo27326b(view, context, attributeSet);
            view.setTag(R.id.iconics_tag_id, Boolean.TRUE);
        }
        return view;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo27326b(View view, final Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            if (view instanceof ActionMenuItemView) {
                C2994b a = C2984a.m8792a(context, attributeSet);
                if (a != null) {
                    ((ActionMenuItemView) view).setIcon(a);
                }
            } else if (view instanceof EditText) {
                new C2982a().mo27307a(context).mo27308a((TextView) view).mo27309a();
            } else if (view instanceof TextView) {
                TextView textView = (TextView) view;
                new C2982a().mo27307a(context).mo27308a(textView).mo27309a();
                textView.addTextChangedListener(new TextWatcher() {
                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    public void afterTextChanged(Editable editable) {
                        C2981a.m8786a(context, editable);
                    }
                });
            } else if (view instanceof ImageView) {
                C2994b a2 = C2984a.m8792a(context, attributeSet);
                if (a2 != null) {
                    ((ImageView) view).setImageDrawable(a2);
                }
            }
        }
    }
}
