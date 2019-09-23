package com.firebase.p119ui.auth.p124ui;

import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

/* renamed from: com.firebase.ui.auth.ui.e */
/* compiled from: ImeHelper */
public class C2052e {

    /* renamed from: com.firebase.ui.auth.ui.e$a */
    /* compiled from: ImeHelper */
    public interface C2054a {
        /* renamed from: a */
        void mo11808a();
    }

    /* renamed from: a */
    public static void m8294a(EditText editText, final C2054a aVar) {
        editText.setOnEditorActionListener(new OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (keyEvent != null && keyEvent.getKeyCode() == 66) {
                    if (keyEvent.getAction() == 1) {
                        aVar.mo11808a();
                    }
                    return true;
                } else if (i != 6) {
                    return false;
                } else {
                    aVar.mo11808a();
                    return true;
                }
            }
        });
    }
}
