package androidx.appcompat.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewConfiguration;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import androidx.appcompat.R;
import androidx.appcompat.view.C0507c;
import androidx.core.p070g.C0962r;
import androidx.customview.p072a.C1021a;
import androidx.p054c.p055a.C0734a;
import com.google.android.gms.actions.SearchIntents;
import com.google.api.client.googleapis.media.MediaHttpDownloader;
import com.google.common.primitives.Ints;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import net.sqlcipher.database.SQLiteDatabase;

public class SearchView extends C0616ah implements C0507c {

    /* renamed from: i */
    static final C0586a f1599i = new C0586a();

    /* renamed from: A */
    private C0588c f1600A;

    /* renamed from: B */
    private C0587b f1601B;

    /* renamed from: C */
    private C0589d f1602C;

    /* renamed from: D */
    private OnClickListener f1603D;

    /* renamed from: E */
    private boolean f1604E;

    /* renamed from: F */
    private boolean f1605F;

    /* renamed from: G */
    private boolean f1606G;

    /* renamed from: H */
    private CharSequence f1607H;

    /* renamed from: I */
    private boolean f1608I;

    /* renamed from: J */
    private boolean f1609J;

    /* renamed from: K */
    private int f1610K;

    /* renamed from: L */
    private boolean f1611L;

    /* renamed from: M */
    private CharSequence f1612M;

    /* renamed from: N */
    private CharSequence f1613N;

    /* renamed from: O */
    private boolean f1614O;

    /* renamed from: P */
    private int f1615P;

    /* renamed from: Q */
    private Bundle f1616Q;

    /* renamed from: R */
    private final Runnable f1617R;

    /* renamed from: S */
    private Runnable f1618S;

    /* renamed from: T */
    private final WeakHashMap<String, ConstantState> f1619T;

    /* renamed from: U */
    private final OnClickListener f1620U;

    /* renamed from: V */
    private final OnEditorActionListener f1621V;

    /* renamed from: W */
    private final OnItemClickListener f1622W;

    /* renamed from: a */
    final SearchAutoComplete f1623a;

    /* renamed from: aa */
    private final OnItemSelectedListener f1624aa;

    /* renamed from: ab */
    private TextWatcher f1625ab;

    /* renamed from: b */
    final ImageView f1626b;

    /* renamed from: c */
    final ImageView f1627c;

    /* renamed from: d */
    final ImageView f1628d;

    /* renamed from: e */
    final ImageView f1629e;

    /* renamed from: f */
    OnFocusChangeListener f1630f;

    /* renamed from: g */
    C0734a f1631g;

    /* renamed from: h */
    SearchableInfo f1632h;

    /* renamed from: j */
    OnKeyListener f1633j;

    /* renamed from: k */
    private final View f1634k;

    /* renamed from: l */
    private final View f1635l;

    /* renamed from: m */
    private final View f1636m;

    /* renamed from: n */
    private final View f1637n;

    /* renamed from: o */
    private C0592f f1638o;

    /* renamed from: p */
    private Rect f1639p;

    /* renamed from: q */
    private Rect f1640q;

    /* renamed from: r */
    private int[] f1641r;

    /* renamed from: s */
    private int[] f1642s;

    /* renamed from: t */
    private final ImageView f1643t;

    /* renamed from: u */
    private final Drawable f1644u;

    /* renamed from: v */
    private final int f1645v;

    /* renamed from: w */
    private final int f1646w;

    /* renamed from: x */
    private final Intent f1647x;

    /* renamed from: y */
    private final Intent f1648y;

    /* renamed from: z */
    private final CharSequence f1649z;

    public static class SearchAutoComplete extends C0674e {

        /* renamed from: a */
        final Runnable f1660a;

        /* renamed from: b */
        private int f1661b;

        /* renamed from: c */
        private SearchView f1662c;

        /* renamed from: d */
        private boolean f1663d;

        public void performCompletion() {
        }

        /* access modifiers changed from: protected */
        public void replaceText(CharSequence charSequence) {
        }

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, R.attr.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.f1660a = new Runnable() {
                public void run() {
                    SearchAutoComplete.this.mo2004b();
                }
            };
            this.f1661b = getThreshold();
        }

        /* access modifiers changed from: protected */
        public void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, (float) getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        /* access modifiers changed from: 0000 */
        public void setSearchView(SearchView searchView) {
            this.f1662c = searchView;
        }

        public void setThreshold(int i) {
            super.setThreshold(i);
            this.f1661b = i;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo2003a() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.f1662c.hasFocus() && getVisibility() == 0) {
                this.f1663d = true;
                if (SearchView.m1970a(getContext())) {
                    SearchView.f1599i.mo2018a(this, true);
                }
            }
        }

        /* access modifiers changed from: protected */
        public void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.f1662c.mo1966i();
        }

        public boolean enoughToFilter() {
            return this.f1661b <= 0 || super.enoughToFilter();
        }

        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f1662c.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i = configuration.screenWidthDp;
            int i2 = configuration.screenHeightDp;
            if (i < 960 || i2 < 720 || configuration.orientation != 2) {
                return (i >= 600 || (i >= 640 && i2 >= 480)) ? 192 : 160;
            }
            return 256;
        }

        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f1663d) {
                removeCallbacks(this.f1660a);
                post(this.f1660a);
            }
            return onCreateInputConnection;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo2004b() {
            if (this.f1663d) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.f1663d = false;
            }
        }

        /* access modifiers changed from: 0000 */
        public void setImeVisibility(boolean z) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z) {
                this.f1663d = false;
                removeCallbacks(this.f1660a);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else if (inputMethodManager.isActive(this)) {
                this.f1663d = false;
                removeCallbacks(this.f1660a);
                inputMethodManager.showSoftInput(this, 0);
            } else {
                this.f1663d = true;
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$a */
    private static class C0586a {

        /* renamed from: a */
        private Method f1665a;

        /* renamed from: b */
        private Method f1666b;

        /* renamed from: c */
        private Method f1667c;

        C0586a() {
            try {
                this.f1665a = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f1665a.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                this.f1666b = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f1666b.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                this.f1667c = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[]{Boolean.TYPE});
                this.f1667c.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo2017a(AutoCompleteTextView autoCompleteTextView) {
            if (this.f1665a != null) {
                try {
                    this.f1665a.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo2019b(AutoCompleteTextView autoCompleteTextView) {
            if (this.f1666b != null) {
                try {
                    this.f1666b.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo2018a(AutoCompleteTextView autoCompleteTextView, boolean z) {
            if (this.f1667c != null) {
                try {
                    this.f1667c.invoke(autoCompleteTextView, new Object[]{Boolean.valueOf(z)});
                } catch (Exception unused) {
                }
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$b */
    public interface C0587b {
        /* renamed from: a */
        boolean mo2020a();
    }

    /* renamed from: androidx.appcompat.widget.SearchView$c */
    public interface C0588c {
        /* renamed from: a */
        boolean mo2021a(String str);

        /* renamed from: b */
        boolean mo2022b(String str);
    }

    /* renamed from: androidx.appcompat.widget.SearchView$d */
    public interface C0589d {
        /* renamed from: a */
        boolean mo2023a(int i);

        /* renamed from: b */
        boolean mo2024b(int i);
    }

    /* renamed from: androidx.appcompat.widget.SearchView$e */
    static class C0590e extends C1021a {
        public static final Creator<C0590e> CREATOR = new ClassLoaderCreator<C0590e>() {
            /* renamed from: a */
            public C0590e createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new C0590e(parcel, classLoader);
            }

            /* renamed from: a */
            public C0590e createFromParcel(Parcel parcel) {
                return new C0590e(parcel, null);
            }

            /* renamed from: a */
            public C0590e[] newArray(int i) {
                return new C0590e[i];
            }
        };

        /* renamed from: a */
        boolean f1668a;

        C0590e(Parcelable parcelable) {
            super(parcelable);
        }

        public C0590e(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1668a = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.f1668a));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("SearchView.SavedState{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" isIconified=");
            sb.append(this.f1668a);
            sb.append("}");
            return sb.toString();
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$f */
    private static class C0592f extends TouchDelegate {

        /* renamed from: a */
        private final View f1669a;

        /* renamed from: b */
        private final Rect f1670b = new Rect();

        /* renamed from: c */
        private final Rect f1671c = new Rect();

        /* renamed from: d */
        private final Rect f1672d = new Rect();

        /* renamed from: e */
        private final int f1673e;

        /* renamed from: f */
        private boolean f1674f;

        public C0592f(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f1673e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            mo2033a(rect, rect2);
            this.f1669a = view;
        }

        /* renamed from: a */
        public void mo2033a(Rect rect, Rect rect2) {
            this.f1670b.set(rect);
            this.f1672d.set(rect);
            this.f1672d.inset(-this.f1673e, -this.f1673e);
            this.f1671c.set(rect2);
        }

        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTouchEvent(android.view.MotionEvent r7) {
            /*
                r6 = this;
                float r0 = r7.getX()
                int r0 = (int) r0
                float r1 = r7.getY()
                int r1 = (int) r1
                int r2 = r7.getAction()
                r3 = 1
                r4 = 0
                switch(r2) {
                    case 0: goto L_0x0027;
                    case 1: goto L_0x0019;
                    case 2: goto L_0x0019;
                    case 3: goto L_0x0014;
                    default: goto L_0x0013;
                }
            L_0x0013:
                goto L_0x0033
            L_0x0014:
                boolean r2 = r6.f1674f
                r6.f1674f = r4
                goto L_0x0034
            L_0x0019:
                boolean r2 = r6.f1674f
                if (r2 == 0) goto L_0x0034
                android.graphics.Rect r5 = r6.f1672d
                boolean r5 = r5.contains(r0, r1)
                if (r5 != 0) goto L_0x0034
                r3 = 0
                goto L_0x0034
            L_0x0027:
                android.graphics.Rect r2 = r6.f1670b
                boolean r2 = r2.contains(r0, r1)
                if (r2 == 0) goto L_0x0033
                r6.f1674f = r3
                r2 = 1
                goto L_0x0034
            L_0x0033:
                r2 = 0
            L_0x0034:
                if (r2 == 0) goto L_0x006b
                if (r3 == 0) goto L_0x0056
                android.graphics.Rect r2 = r6.f1671c
                boolean r2 = r2.contains(r0, r1)
                if (r2 != 0) goto L_0x0056
                android.view.View r0 = r6.f1669a
                int r0 = r0.getWidth()
                int r0 = r0 / 2
                float r0 = (float) r0
                android.view.View r1 = r6.f1669a
                int r1 = r1.getHeight()
                int r1 = r1 / 2
                float r1 = (float) r1
                r7.setLocation(r0, r1)
                goto L_0x0065
            L_0x0056:
                android.graphics.Rect r2 = r6.f1671c
                int r2 = r2.left
                int r0 = r0 - r2
                float r0 = (float) r0
                android.graphics.Rect r2 = r6.f1671c
                int r2 = r2.top
                int r1 = r1 - r2
                float r1 = (float) r1
                r7.setLocation(r0, r1)
            L_0x0065:
                android.view.View r0 = r6.f1669a
                boolean r4 = r0.dispatchTouchEvent(r7)
            L_0x006b:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.C0592f.onTouchEvent(android.view.MotionEvent):boolean");
        }
    }

    public SearchView(Context context) {
        this(context, null);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.searchViewStyle);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1639p = new Rect();
        this.f1640q = new Rect();
        this.f1641r = new int[2];
        this.f1642s = new int[2];
        this.f1617R = new Runnable() {
            public void run() {
                SearchView.this.mo1953d();
            }
        };
        this.f1618S = new Runnable() {
            public void run() {
                if (SearchView.this.f1631g != null && (SearchView.this.f1631g instanceof C0636ao)) {
                    SearchView.this.f1631g.mo2376a((Cursor) null);
                }
            }
        };
        this.f1619T = new WeakHashMap<>();
        this.f1620U = new OnClickListener() {
            public void onClick(View view) {
                if (view == SearchView.this.f1626b) {
                    SearchView.this.mo1956g();
                } else if (view == SearchView.this.f1628d) {
                    SearchView.this.mo1955f();
                } else if (view == SearchView.this.f1627c) {
                    SearchView.this.mo1954e();
                } else if (view == SearchView.this.f1629e) {
                    SearchView.this.mo1965h();
                } else if (view == SearchView.this.f1623a) {
                    SearchView.this.mo1968k();
                }
            }
        };
        this.f1633j = new OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (SearchView.this.f1632h == null) {
                    return false;
                }
                if (SearchView.this.f1623a.isPopupShowing() && SearchView.this.f1623a.getListSelection() != -1) {
                    return SearchView.this.mo1949a(view, i, keyEvent);
                }
                if (SearchView.this.f1623a.mo2003a() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i != 66) {
                    return false;
                }
                view.cancelLongPress();
                SearchView.this.mo1944a(0, (String) null, SearchView.this.f1623a.getText().toString());
                return true;
            }
        };
        this.f1621V = new OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                SearchView.this.mo1954e();
                return true;
            }
        };
        this.f1622W = new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                SearchView.this.mo1948a(i, 0, (String) null);
            }
        };
        this.f1624aa = new OnItemSelectedListener() {
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                SearchView.this.mo1947a(i);
            }
        };
        this.f1625ab = new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                SearchView.this.mo1950b(charSequence);
            }
        };
        C0645av a = C0645av.m2230a(context, attributeSet, R.styleable.SearchView, i, 0);
        LayoutInflater.from(context).inflate(a.mo2463g(R.styleable.SearchView_layout, R.layout.abc_search_view), this, true);
        this.f1623a = (SearchAutoComplete) findViewById(R.id.search_src_text);
        this.f1623a.setSearchView(this);
        this.f1634k = findViewById(R.id.search_edit_frame);
        this.f1635l = findViewById(R.id.search_plate);
        this.f1636m = findViewById(R.id.submit_area);
        this.f1626b = (ImageView) findViewById(R.id.search_button);
        this.f1627c = (ImageView) findViewById(R.id.search_go_btn);
        this.f1628d = (ImageView) findViewById(R.id.search_close_btn);
        this.f1629e = (ImageView) findViewById(R.id.search_voice_btn);
        this.f1643t = (ImageView) findViewById(R.id.search_mag_icon);
        C0962r.m3557a(this.f1635l, a.mo2449a(R.styleable.SearchView_queryBackground));
        C0962r.m3557a(this.f1636m, a.mo2449a(R.styleable.SearchView_submitBackground));
        this.f1626b.setImageDrawable(a.mo2449a(R.styleable.SearchView_searchIcon));
        this.f1627c.setImageDrawable(a.mo2449a(R.styleable.SearchView_goIcon));
        this.f1628d.setImageDrawable(a.mo2449a(R.styleable.SearchView_closeIcon));
        this.f1629e.setImageDrawable(a.mo2449a(R.styleable.SearchView_voiceIcon));
        this.f1643t.setImageDrawable(a.mo2449a(R.styleable.SearchView_searchIcon));
        this.f1644u = a.mo2449a(R.styleable.SearchView_searchHintIcon);
        C0649ax.m2296a(this.f1626b, getResources().getString(R.string.abc_searchview_description_search));
        this.f1645v = a.mo2463g(R.styleable.SearchView_suggestionRowLayout, R.layout.abc_search_dropdown_item_icons_2line);
        this.f1646w = a.mo2463g(R.styleable.SearchView_commitIcon, 0);
        this.f1626b.setOnClickListener(this.f1620U);
        this.f1628d.setOnClickListener(this.f1620U);
        this.f1627c.setOnClickListener(this.f1620U);
        this.f1629e.setOnClickListener(this.f1620U);
        this.f1623a.setOnClickListener(this.f1620U);
        this.f1623a.addTextChangedListener(this.f1625ab);
        this.f1623a.setOnEditorActionListener(this.f1621V);
        this.f1623a.setOnItemClickListener(this.f1622W);
        this.f1623a.setOnItemSelectedListener(this.f1624aa);
        this.f1623a.setOnKeyListener(this.f1633j);
        this.f1623a.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (SearchView.this.f1630f != null) {
                    SearchView.this.f1630f.onFocusChange(SearchView.this, z);
                }
            }
        });
        setIconifiedByDefault(a.mo2451a(R.styleable.SearchView_iconifiedByDefault, true));
        int e = a.mo2459e(R.styleable.SearchView_android_maxWidth, -1);
        if (e != -1) {
            setMaxWidth(e);
        }
        this.f1649z = a.mo2456c(R.styleable.SearchView_defaultQueryHint);
        this.f1607H = a.mo2456c(R.styleable.SearchView_queryHint);
        int a2 = a.mo2447a(R.styleable.SearchView_android_imeOptions, -1);
        if (a2 != -1) {
            setImeOptions(a2);
        }
        int a3 = a.mo2447a(R.styleable.SearchView_android_inputType, -1);
        if (a3 != -1) {
            setInputType(a3);
        }
        setFocusable(a.mo2451a(R.styleable.SearchView_android_focusable, true));
        a.mo2450a();
        this.f1647x = new Intent("android.speech.action.WEB_SEARCH");
        this.f1647x.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        this.f1647x.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        this.f1648y = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.f1648y.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        this.f1637n = findViewById(this.f1623a.getDropDownAnchor());
        if (this.f1637n != null) {
            this.f1637n.addOnLayoutChangeListener(new OnLayoutChangeListener() {
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    SearchView.this.mo1967j();
                }
            });
        }
        m1969a(this.f1604E);
        m1982q();
    }

    /* access modifiers changed from: 0000 */
    public int getSuggestionRowLayout() {
        return this.f1645v;
    }

    /* access modifiers changed from: 0000 */
    public int getSuggestionCommitIconResId() {
        return this.f1646w;
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f1632h = searchableInfo;
        if (this.f1632h != null) {
            m1983r();
            m1982q();
        }
        this.f1611L = m1977l();
        if (this.f1611L) {
            this.f1623a.setPrivateImeOptions("nm");
        }
        m1969a(mo1951c());
    }

    public void setAppSearchData(Bundle bundle) {
        this.f1616Q = bundle;
    }

    public void setImeOptions(int i) {
        this.f1623a.setImeOptions(i);
    }

    public int getImeOptions() {
        return this.f1623a.getImeOptions();
    }

    public void setInputType(int i) {
        this.f1623a.setInputType(i);
    }

    public int getInputType() {
        return this.f1623a.getInputType();
    }

    public boolean requestFocus(int i, Rect rect) {
        if (this.f1609J || !isFocusable()) {
            return false;
        }
        if (mo1951c()) {
            return super.requestFocus(i, rect);
        }
        boolean requestFocus = this.f1623a.requestFocus(i, rect);
        if (requestFocus) {
            m1969a(false);
        }
        return requestFocus;
    }

    public void clearFocus() {
        this.f1609J = true;
        super.clearFocus();
        this.f1623a.clearFocus();
        this.f1623a.setImeVisibility(false);
        this.f1609J = false;
    }

    public void setOnQueryTextListener(C0588c cVar) {
        this.f1600A = cVar;
    }

    public void setOnCloseListener(C0587b bVar) {
        this.f1601B = bVar;
    }

    public void setOnQueryTextFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.f1630f = onFocusChangeListener;
    }

    public void setOnSuggestionListener(C0589d dVar) {
        this.f1602C = dVar;
    }

    public void setOnSearchClickListener(OnClickListener onClickListener) {
        this.f1603D = onClickListener;
    }

    public CharSequence getQuery() {
        return this.f1623a.getText();
    }

    /* renamed from: a */
    public void mo1946a(CharSequence charSequence, boolean z) {
        this.f1623a.setText(charSequence);
        if (charSequence != null) {
            this.f1623a.setSelection(this.f1623a.length());
            this.f1613N = charSequence;
        }
        if (z && !TextUtils.isEmpty(charSequence)) {
            mo1954e();
        }
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f1607H = charSequence;
        m1982q();
    }

    public CharSequence getQueryHint() {
        if (this.f1607H != null) {
            return this.f1607H;
        }
        if (this.f1632h == null || this.f1632h.getHintId() == 0) {
            return this.f1649z;
        }
        return getContext().getText(this.f1632h.getHintId());
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.f1604E != z) {
            this.f1604E = z;
            m1969a(z);
            m1982q();
        }
    }

    public void setIconified(boolean z) {
        if (z) {
            mo1955f();
        } else {
            mo1956g();
        }
    }

    /* renamed from: c */
    public boolean mo1951c() {
        return this.f1605F;
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.f1606G = z;
        m1969a(mo1951c());
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.f1608I = z;
        if (this.f1631g instanceof C0636ao) {
            ((C0636ao) this.f1631g).mo2375a(z ? 2 : 1);
        }
    }

    public void setSuggestionsAdapter(C0734a aVar) {
        this.f1631g = aVar;
        this.f1623a.setAdapter(this.f1631g);
    }

    public C0734a getSuggestionsAdapter() {
        return this.f1631g;
    }

    public void setMaxWidth(int i) {
        this.f1610K = i;
        requestLayout();
    }

    public int getMaxWidth() {
        return this.f1610K;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (mo1951c()) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE) {
            size = this.f1610K > 0 ? Math.min(this.f1610K, size) : Math.min(getPreferredWidth(), size);
        } else if (mode == 0) {
            size = this.f1610K > 0 ? this.f1610K : getPreferredWidth();
        } else if (mode == 1073741824 && this.f1610K > 0) {
            size = Math.min(this.f1610K, size);
        }
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(size, Ints.MAX_POWER_OF_TWO), MeasureSpec.makeMeasureSpec(size2, Ints.MAX_POWER_OF_TWO));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            m1968a((View) this.f1623a, this.f1639p);
            this.f1640q.set(this.f1639p.left, 0, this.f1639p.right, i4 - i2);
            if (this.f1638o == null) {
                this.f1638o = new C0592f(this.f1640q, this.f1639p, this.f1623a);
                setTouchDelegate(this.f1638o);
                return;
            }
            this.f1638o.mo2033a(this.f1640q, this.f1639p);
        }
    }

    /* renamed from: a */
    private void m1968a(View view, Rect rect) {
        view.getLocationInWindow(this.f1641r);
        getLocationInWindow(this.f1642s);
        int i = this.f1641r[1] - this.f1642s[1];
        int i2 = this.f1641r[0] - this.f1642s[0];
        rect.set(i2, i, view.getWidth() + i2, view.getHeight() + i);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_width);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_height);
    }

    /* renamed from: a */
    private void m1969a(boolean z) {
        this.f1605F = z;
        int i = 8;
        boolean z2 = false;
        boolean z3 = !TextUtils.isEmpty(this.f1623a.getText());
        this.f1626b.setVisibility(z ? 0 : 8);
        m1973b(z3);
        this.f1634k.setVisibility(z ? 8 : 0);
        if (this.f1643t.getDrawable() != null && !this.f1604E) {
            i = 0;
        }
        this.f1643t.setVisibility(i);
        m1980o();
        if (!z3) {
            z2 = true;
        }
        m1976c(z2);
        m1979n();
    }

    /* renamed from: l */
    private boolean m1977l() {
        boolean z = false;
        if (this.f1632h != null && this.f1632h.getVoiceSearchEnabled()) {
            Intent intent = null;
            if (this.f1632h.getVoiceSearchLaunchWebSearch()) {
                intent = this.f1647x;
            } else if (this.f1632h.getVoiceSearchLaunchRecognizer()) {
                intent = this.f1648y;
            }
            if (intent != null) {
                if (getContext().getPackageManager().resolveActivity(intent, 65536) != null) {
                    z = true;
                }
                return z;
            }
        }
        return false;
    }

    /* renamed from: m */
    private boolean m1978m() {
        return (this.f1606G || this.f1611L) && !mo1951c();
    }

    /* renamed from: b */
    private void m1973b(boolean z) {
        this.f1627c.setVisibility((!this.f1606G || !m1978m() || !hasFocus() || (!z && this.f1611L)) ? 8 : 0);
    }

    /* renamed from: n */
    private void m1979n() {
        this.f1636m.setVisibility((!m1978m() || !(this.f1627c.getVisibility() == 0 || this.f1629e.getVisibility() == 0)) ? 8 : 0);
    }

    /* renamed from: o */
    private void m1980o() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.f1623a.getText());
        int i = 0;
        if (!z2 && (!this.f1604E || this.f1614O)) {
            z = false;
        }
        ImageView imageView = this.f1628d;
        if (!z) {
            i = 8;
        }
        imageView.setVisibility(i);
        Drawable drawable = this.f1628d.getDrawable();
        if (drawable != null) {
            drawable.setState(z2 ? ENABLED_STATE_SET : EMPTY_STATE_SET);
        }
    }

    /* renamed from: p */
    private void m1981p() {
        post(this.f1617R);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo1953d() {
        int[] iArr = this.f1623a.hasFocus() ? FOCUSED_STATE_SET : EMPTY_STATE_SET;
        Drawable background = this.f1635l.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.f1636m.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        removeCallbacks(this.f1617R);
        post(this.f1618S);
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo1945a(CharSequence charSequence) {
        setQuery(charSequence);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo1949a(View view, int i, KeyEvent keyEvent) {
        int i2;
        if (this.f1632h != null && this.f1631g != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i == 66 || i == 84 || i == 61) {
                return mo1948a(this.f1623a.getListSelection(), 0, (String) null);
            }
            if (i == 21 || i == 22) {
                if (i == 21) {
                    i2 = 0;
                } else {
                    i2 = this.f1623a.length();
                }
                this.f1623a.setSelection(i2);
                this.f1623a.setListSelection(0);
                this.f1623a.clearListSelection();
                f1599i.mo2018a(this.f1623a, true);
                return true;
            } else if (i != 19 || this.f1623a.getListSelection() == 0) {
                return false;
            }
        }
        return false;
    }

    /* renamed from: c */
    private CharSequence m1975c(CharSequence charSequence) {
        if (!this.f1604E || this.f1644u == null) {
            return charSequence;
        }
        int textSize = (int) (((double) this.f1623a.getTextSize()) * 1.25d);
        this.f1644u.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.f1644u), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    /* renamed from: q */
    private void m1982q() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f1623a;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(m1975c(queryHint));
    }

    /* renamed from: r */
    private void m1983r() {
        this.f1623a.setThreshold(this.f1632h.getSuggestThreshold());
        this.f1623a.setImeOptions(this.f1632h.getImeOptions());
        int inputType = this.f1632h.getInputType();
        int i = 1;
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.f1632h.getSuggestAuthority() != null) {
                inputType = inputType | 65536 | 524288;
            }
        }
        this.f1623a.setInputType(inputType);
        if (this.f1631g != null) {
            this.f1631g.mo2376a((Cursor) null);
        }
        if (this.f1632h.getSuggestAuthority() != null) {
            this.f1631g = new C0636ao(getContext(), this, this.f1632h, this.f1619T);
            this.f1623a.setAdapter(this.f1631g);
            C0636ao aoVar = (C0636ao) this.f1631g;
            if (this.f1608I) {
                i = 2;
            }
            aoVar.mo2375a(i);
        }
    }

    /* renamed from: c */
    private void m1976c(boolean z) {
        int i;
        if (!this.f1611L || mo1951c() || !z) {
            i = 8;
        } else {
            i = 0;
            this.f1627c.setVisibility(8);
        }
        this.f1629e.setVisibility(i);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo1950b(CharSequence charSequence) {
        Editable text = this.f1623a.getText();
        this.f1613N = text;
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(text);
        m1973b(z2);
        if (z2) {
            z = false;
        }
        m1976c(z);
        m1980o();
        m1979n();
        if (this.f1600A != null && !TextUtils.equals(charSequence, this.f1612M)) {
            this.f1600A.mo2022b(charSequence.toString());
        }
        this.f1612M = charSequence.toString();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo1954e() {
        Editable text = this.f1623a.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            if (this.f1600A == null || !this.f1600A.mo2021a(text.toString())) {
                if (this.f1632h != null) {
                    mo1944a(0, (String) null, text.toString());
                }
                this.f1623a.setImeVisibility(false);
                m1984s();
            }
        }
    }

    /* renamed from: s */
    private void m1984s() {
        this.f1623a.dismissDropDown();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public void mo1955f() {
        if (!TextUtils.isEmpty(this.f1623a.getText())) {
            this.f1623a.setText("");
            this.f1623a.requestFocus();
            this.f1623a.setImeVisibility(true);
        } else if (!this.f1604E) {
        } else {
            if (this.f1601B == null || !this.f1601B.mo2020a()) {
                clearFocus();
                m1969a(true);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public void mo1956g() {
        m1969a(false);
        this.f1623a.requestFocus();
        this.f1623a.setImeVisibility(true);
        if (this.f1603D != null) {
            this.f1603D.onClick(this);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public void mo1965h() {
        if (this.f1632h != null) {
            SearchableInfo searchableInfo = this.f1632h;
            try {
                if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                    getContext().startActivity(m1964a(this.f1647x, searchableInfo));
                } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                    getContext().startActivity(m1971b(this.f1648y, searchableInfo));
                }
            } catch (ActivityNotFoundException unused) {
                Log.w("SearchView", "Could not find voice search activity");
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public void mo1966i() {
        m1969a(mo1951c());
        m1981p();
        if (this.f1623a.hasFocus()) {
            mo1968k();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        m1981p();
    }

    /* renamed from: b */
    public void mo1253b() {
        mo1946a((CharSequence) "", false);
        clearFocus();
        m1969a(true);
        this.f1623a.setImeOptions(this.f1615P);
        this.f1614O = false;
    }

    /* renamed from: a */
    public void mo1252a() {
        if (!this.f1614O) {
            this.f1614O = true;
            this.f1615P = this.f1623a.getImeOptions();
            this.f1623a.setImeOptions(this.f1615P | MediaHttpDownloader.MAXIMUM_CHUNK_SIZE);
            this.f1623a.setText("");
            setIconified(false);
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        C0590e eVar = new C0590e(super.onSaveInstanceState());
        eVar.f1668a = mo1951c();
        return eVar;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof C0590e)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C0590e eVar = (C0590e) parcelable;
        super.onRestoreInstanceState(eVar.getSuperState());
        m1969a(eVar.f1668a);
        requestLayout();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public void mo1967j() {
        int i;
        if (this.f1637n.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.f1635l.getPaddingLeft();
            Rect rect = new Rect();
            boolean a = C0656bb.m2314a(this);
            int dimensionPixelSize = this.f1604E ? resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_icon_width) + resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_text_padding_left) : 0;
            this.f1623a.getDropDownBackground().getPadding(rect);
            if (a) {
                i = -rect.left;
            } else {
                i = paddingLeft - (rect.left + dimensionPixelSize);
            }
            this.f1623a.setDropDownHorizontalOffset(i);
            this.f1623a.setDropDownWidth((((this.f1637n.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo1948a(int i, int i2, String str) {
        if (this.f1602C != null && this.f1602C.mo2024b(i)) {
            return false;
        }
        m1974b(i, 0, null);
        this.f1623a.setImeVisibility(false);
        m1984s();
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo1947a(int i) {
        if (this.f1602C != null && this.f1602C.mo2023a(i)) {
            return false;
        }
        m1972b(i);
        return true;
    }

    /* renamed from: b */
    private void m1972b(int i) {
        Editable text = this.f1623a.getText();
        Cursor a = this.f1631g.mo2915a();
        if (a != null) {
            if (a.moveToPosition(i)) {
                CharSequence b = this.f1631g.mo2378b(a);
                if (b != null) {
                    setQuery(b);
                } else {
                    setQuery(text);
                }
            } else {
                setQuery(text);
            }
        }
    }

    /* renamed from: b */
    private boolean m1974b(int i, int i2, String str) {
        Cursor a = this.f1631g.mo2915a();
        if (a == null || !a.moveToPosition(i)) {
            return false;
        }
        m1967a(m1965a(a, i2, str));
        return true;
    }

    /* renamed from: a */
    private void m1967a(Intent intent) {
        if (intent != null) {
            try {
                getContext().startActivity(intent);
            } catch (RuntimeException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed launch activity: ");
                sb.append(intent);
                Log.e("SearchView", sb.toString(), e);
            }
        }
    }

    private void setQuery(CharSequence charSequence) {
        this.f1623a.setText(charSequence);
        this.f1623a.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo1944a(int i, String str, String str2) {
        getContext().startActivity(m1966a("android.intent.action.SEARCH", null, null, str2, i, str));
    }

    /* renamed from: a */
    private Intent m1966a(String str, Uri uri, String str2, String str3, int i, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f1613N);
        if (str3 != null) {
            intent.putExtra(SearchIntents.EXTRA_QUERY, str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        if (this.f1616Q != null) {
            intent.putExtra("app_data", this.f1616Q);
        }
        if (i != 0) {
            intent.putExtra("action_key", i);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.f1632h.getSearchActivity());
        return intent;
    }

    /* renamed from: a */
    private Intent m1964a(Intent intent, SearchableInfo searchableInfo) {
        String str;
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        String str2 = "calling_package";
        if (searchActivity == null) {
            str = null;
        } else {
            str = searchActivity.flattenToShortString();
        }
        intent2.putExtra(str2, str);
        return intent2;
    }

    /* renamed from: b */
    private Intent m1971b(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, Ints.MAX_POWER_OF_TWO);
        Bundle bundle = new Bundle();
        if (this.f1616Q != null) {
            bundle.putParcelable("app_data", this.f1616Q);
        }
        Intent intent3 = new Intent(intent);
        String str = "free_form";
        int i = 1;
        Resources resources = getResources();
        if (searchableInfo.getVoiceLanguageModeId() != 0) {
            str = resources.getString(searchableInfo.getVoiceLanguageModeId());
        }
        String str2 = null;
        String string = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string2 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        if (searchableInfo.getVoiceMaxResults() != 0) {
            i = searchableInfo.getVoiceMaxResults();
        }
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", str);
        intent3.putExtra("android.speech.extra.PROMPT", string);
        intent3.putExtra("android.speech.extra.LANGUAGE", string2);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", i);
        String str3 = "calling_package";
        if (searchActivity != null) {
            str2 = searchActivity.flattenToShortString();
        }
        intent3.putExtra(str3, str2);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    /* renamed from: a */
    private Intent m1965a(Cursor cursor, int i, String str) {
        int i2;
        Uri uri;
        try {
            String a = C0636ao.m2196a(cursor, "suggest_intent_action");
            if (a == null) {
                a = this.f1632h.getSuggestIntentAction();
            }
            if (a == null) {
                a = "android.intent.action.SEARCH";
            }
            String str2 = a;
            String a2 = C0636ao.m2196a(cursor, "suggest_intent_data");
            if (a2 == null) {
                a2 = this.f1632h.getSuggestIntentData();
            }
            if (a2 != null) {
                String a3 = C0636ao.m2196a(cursor, "suggest_intent_data_id");
                if (a3 != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(a2);
                    sb.append("/");
                    sb.append(Uri.encode(a3));
                    a2 = sb.toString();
                }
            }
            if (a2 == null) {
                uri = null;
            } else {
                uri = Uri.parse(a2);
            }
            String a4 = C0636ao.m2196a(cursor, "suggest_intent_query");
            return m1966a(str2, uri, C0636ao.m2196a(cursor, "suggest_intent_extra_data"), a4, i, str);
        } catch (RuntimeException e) {
            try {
                i2 = cursor.getPosition();
            } catch (RuntimeException unused) {
                i2 = -1;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Search suggestions cursor at row ");
            sb2.append(i2);
            sb2.append(" returned exception.");
            Log.w("SearchView", sb2.toString(), e);
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: k */
    public void mo1968k() {
        f1599i.mo2017a(this.f1623a);
        f1599i.mo2019b(this.f1623a);
    }

    /* renamed from: a */
    static boolean m1970a(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }
}
