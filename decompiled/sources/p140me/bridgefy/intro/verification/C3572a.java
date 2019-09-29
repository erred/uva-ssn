package p140me.bridgefy.intro.verification;

import android.annotation.SuppressLint;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.util.Collections;

/* renamed from: me.bridgefy.intro.verification.a */
/* compiled from: BucketedTextChangeListener */
public final class C3572a implements TextWatcher {

    /* renamed from: a */
    private final EditText f9380a;

    /* renamed from: b */
    private final C3573a f9381b;

    /* renamed from: c */
    private final String[] f9382c;

    /* renamed from: d */
    private final String f9383d;

    /* renamed from: e */
    private final int f9384e;

    /* renamed from: me.bridgefy.intro.verification.a$a */
    /* compiled from: BucketedTextChangeListener */
    public interface C3573a {
        /* renamed from: a */
        void mo29455a();

        /* renamed from: b */
        void mo29456b();
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public C3572a(EditText editText, int i, String str, C3573a aVar) {
        this.f9380a = editText;
        this.f9384e = i;
        this.f9382c = m10501a(str, i);
        this.f9381b = aVar;
        this.f9383d = str;
    }

    @SuppressLint({"SetTextI18n"})
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String replaceAll = charSequence.toString().replaceAll(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, "").replaceAll(this.f9383d, "");
        int min = Math.min(replaceAll.length(), this.f9384e);
        String substring = replaceAll.substring(0, min);
        this.f9380a.removeTextChangedListener(this);
        EditText editText = this.f9380a;
        StringBuilder sb = new StringBuilder();
        sb.append(substring);
        sb.append(this.f9382c[this.f9384e - min]);
        editText.setText(sb.toString());
        this.f9380a.setSelection(min);
        this.f9380a.addTextChangedListener(this);
        if (min == this.f9384e && this.f9381b != null) {
            this.f9381b.mo29455a();
        } else if (this.f9381b != null) {
            this.f9381b.mo29456b();
        }
    }

    /* renamed from: a */
    private String[] m10501a(CharSequence charSequence, int i) {
        String[] strArr = new String[(i + 1)];
        for (int i2 = 0; i2 <= i; i2++) {
            strArr[i2] = TextUtils.join("", Collections.nCopies(i2, charSequence));
        }
        return strArr;
    }
}
