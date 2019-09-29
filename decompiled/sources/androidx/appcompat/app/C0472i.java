package androidx.appcompat.app;

import android.app.Dialog;
import android.os.Bundle;
import androidx.fragment.p081a.C1061c;

/* renamed from: androidx.appcompat.app.i */
/* compiled from: AppCompatDialogFragment */
public class C0472i extends C1061c {
    public Dialog onCreateDialog(Bundle bundle) {
        return new C0470h(getContext(), getTheme());
    }

    public void setupDialog(Dialog dialog, int i) {
        if (dialog instanceof C0470h) {
            C0470h hVar = (C0470h) dialog;
            switch (i) {
                case 1:
                case 2:
                    break;
                case 3:
                    dialog.getWindow().addFlags(24);
                    break;
                default:
                    return;
            }
            hVar.supportRequestWindowFeature(1);
            return;
        }
        super.setupDialog(dialog, i);
    }
}
