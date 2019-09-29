package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListAdapter;
import androidx.appcompat.R;
import androidx.appcompat.app.AlertController.C0431a;

/* renamed from: androidx.appcompat.app.c */
/* compiled from: AlertDialog */
public class C0446c extends C0470h implements DialogInterface {

    /* renamed from: a */
    final AlertController f974a = new AlertController(getContext(), this, getWindow());

    /* renamed from: androidx.appcompat.app.c$a */
    /* compiled from: AlertDialog */
    public static class C0447a {

        /* renamed from: P */
        private final C0431a f975P;
        private final int mTheme;

        public C0447a(Context context) {
            this(context, C0446c.m1332a(context, 0));
        }

        public C0447a(Context context, int i) {
            this.f975P = new C0431a(new ContextThemeWrapper(context, C0446c.m1332a(context, i)));
            this.mTheme = i;
        }

        public Context getContext() {
            return this.f975P.f930a;
        }

        public C0447a setTitle(int i) {
            this.f975P.f935f = this.f975P.f930a.getText(i);
            return this;
        }

        public C0447a setTitle(CharSequence charSequence) {
            this.f975P.f935f = charSequence;
            return this;
        }

        public C0447a setCustomTitle(View view) {
            this.f975P.f936g = view;
            return this;
        }

        public C0447a setMessage(int i) {
            this.f975P.f937h = this.f975P.f930a.getText(i);
            return this;
        }

        public C0447a setMessage(CharSequence charSequence) {
            this.f975P.f937h = charSequence;
            return this;
        }

        public C0447a setIcon(int i) {
            this.f975P.f932c = i;
            return this;
        }

        public C0447a setIcon(Drawable drawable) {
            this.f975P.f933d = drawable;
            return this;
        }

        public C0447a setIconAttribute(int i) {
            TypedValue typedValue = new TypedValue();
            this.f975P.f930a.getTheme().resolveAttribute(i, typedValue, true);
            this.f975P.f932c = typedValue.resourceId;
            return this;
        }

        public C0447a setPositiveButton(int i, OnClickListener onClickListener) {
            this.f975P.f938i = this.f975P.f930a.getText(i);
            this.f975P.f940k = onClickListener;
            return this;
        }

        public C0447a setPositiveButton(CharSequence charSequence, OnClickListener onClickListener) {
            this.f975P.f938i = charSequence;
            this.f975P.f940k = onClickListener;
            return this;
        }

        public C0447a setPositiveButtonIcon(Drawable drawable) {
            this.f975P.f939j = drawable;
            return this;
        }

        public C0447a setNegativeButton(int i, OnClickListener onClickListener) {
            this.f975P.f941l = this.f975P.f930a.getText(i);
            this.f975P.f943n = onClickListener;
            return this;
        }

        public C0447a setNegativeButton(CharSequence charSequence, OnClickListener onClickListener) {
            this.f975P.f941l = charSequence;
            this.f975P.f943n = onClickListener;
            return this;
        }

        public C0447a setNegativeButtonIcon(Drawable drawable) {
            this.f975P.f942m = drawable;
            return this;
        }

        public C0447a setNeutralButton(int i, OnClickListener onClickListener) {
            this.f975P.f944o = this.f975P.f930a.getText(i);
            this.f975P.f946q = onClickListener;
            return this;
        }

        public C0447a setNeutralButton(CharSequence charSequence, OnClickListener onClickListener) {
            this.f975P.f944o = charSequence;
            this.f975P.f946q = onClickListener;
            return this;
        }

        public C0447a setNeutralButtonIcon(Drawable drawable) {
            this.f975P.f945p = drawable;
            return this;
        }

        public C0447a setCancelable(boolean z) {
            this.f975P.f947r = z;
            return this;
        }

        public C0447a setOnCancelListener(OnCancelListener onCancelListener) {
            this.f975P.f948s = onCancelListener;
            return this;
        }

        public C0447a setOnDismissListener(OnDismissListener onDismissListener) {
            this.f975P.f949t = onDismissListener;
            return this;
        }

        public C0447a setOnKeyListener(OnKeyListener onKeyListener) {
            this.f975P.f950u = onKeyListener;
            return this;
        }

        public C0447a setItems(int i, OnClickListener onClickListener) {
            this.f975P.f951v = this.f975P.f930a.getResources().getTextArray(i);
            this.f975P.f953x = onClickListener;
            return this;
        }

        public C0447a setItems(CharSequence[] charSequenceArr, OnClickListener onClickListener) {
            this.f975P.f951v = charSequenceArr;
            this.f975P.f953x = onClickListener;
            return this;
        }

        public C0447a setAdapter(ListAdapter listAdapter, OnClickListener onClickListener) {
            this.f975P.f952w = listAdapter;
            this.f975P.f953x = onClickListener;
            return this;
        }

        public C0447a setCursor(Cursor cursor, OnClickListener onClickListener, String str) {
            this.f975P.f923K = cursor;
            this.f975P.f924L = str;
            this.f975P.f953x = onClickListener;
            return this;
        }

        public C0447a setMultiChoiceItems(int i, boolean[] zArr, OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.f975P.f951v = this.f975P.f930a.getResources().getTextArray(i);
            this.f975P.f922J = onMultiChoiceClickListener;
            this.f975P.f918F = zArr;
            this.f975P.f919G = true;
            return this;
        }

        public C0447a setMultiChoiceItems(CharSequence[] charSequenceArr, boolean[] zArr, OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.f975P.f951v = charSequenceArr;
            this.f975P.f922J = onMultiChoiceClickListener;
            this.f975P.f918F = zArr;
            this.f975P.f919G = true;
            return this;
        }

        public C0447a setMultiChoiceItems(Cursor cursor, String str, String str2, OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.f975P.f923K = cursor;
            this.f975P.f922J = onMultiChoiceClickListener;
            this.f975P.f925M = str;
            this.f975P.f924L = str2;
            this.f975P.f919G = true;
            return this;
        }

        public C0447a setSingleChoiceItems(int i, int i2, OnClickListener onClickListener) {
            this.f975P.f951v = this.f975P.f930a.getResources().getTextArray(i);
            this.f975P.f953x = onClickListener;
            this.f975P.f921I = i2;
            this.f975P.f920H = true;
            return this;
        }

        public C0447a setSingleChoiceItems(Cursor cursor, int i, String str, OnClickListener onClickListener) {
            this.f975P.f923K = cursor;
            this.f975P.f953x = onClickListener;
            this.f975P.f921I = i;
            this.f975P.f924L = str;
            this.f975P.f920H = true;
            return this;
        }

        public C0447a setSingleChoiceItems(CharSequence[] charSequenceArr, int i, OnClickListener onClickListener) {
            this.f975P.f951v = charSequenceArr;
            this.f975P.f953x = onClickListener;
            this.f975P.f921I = i;
            this.f975P.f920H = true;
            return this;
        }

        public C0447a setSingleChoiceItems(ListAdapter listAdapter, int i, OnClickListener onClickListener) {
            this.f975P.f952w = listAdapter;
            this.f975P.f953x = onClickListener;
            this.f975P.f921I = i;
            this.f975P.f920H = true;
            return this;
        }

        public C0447a setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
            this.f975P.f927O = onItemSelectedListener;
            return this;
        }

        public C0447a setView(int i) {
            this.f975P.f955z = null;
            this.f975P.f954y = i;
            this.f975P.f917E = false;
            return this;
        }

        public C0447a setView(View view) {
            this.f975P.f955z = view;
            this.f975P.f954y = 0;
            this.f975P.f917E = false;
            return this;
        }

        @Deprecated
        public C0447a setView(View view, int i, int i2, int i3, int i4) {
            this.f975P.f955z = view;
            this.f975P.f954y = 0;
            this.f975P.f917E = true;
            this.f975P.f913A = i;
            this.f975P.f914B = i2;
            this.f975P.f915C = i3;
            this.f975P.f916D = i4;
            return this;
        }

        @Deprecated
        public C0447a setInverseBackgroundForced(boolean z) {
            this.f975P.f926N = z;
            return this;
        }

        public C0447a setRecycleOnMeasureEnabled(boolean z) {
            this.f975P.f929Q = z;
            return this;
        }

        public C0446c create() {
            C0446c cVar = new C0446c(this.f975P.f930a, this.mTheme);
            this.f975P.mo822a(cVar.f974a);
            cVar.setCancelable(this.f975P.f947r);
            if (this.f975P.f947r) {
                cVar.setCanceledOnTouchOutside(true);
            }
            cVar.setOnCancelListener(this.f975P.f948s);
            cVar.setOnDismissListener(this.f975P.f949t);
            if (this.f975P.f950u != null) {
                cVar.setOnKeyListener(this.f975P.f950u);
            }
            return cVar;
        }

        public C0446c show() {
            C0446c create = create();
            create.show();
            return create;
        }
    }

    protected C0446c(Context context, int i) {
        super(context, m1332a(context, i));
    }

    /* renamed from: a */
    static int m1332a(Context context, int i) {
        if (((i >>> 24) & 255) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f974a.mo807a(charSequence);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f974a.mo802a();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f974a.mo808a(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.f974a.mo812b(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }
}
