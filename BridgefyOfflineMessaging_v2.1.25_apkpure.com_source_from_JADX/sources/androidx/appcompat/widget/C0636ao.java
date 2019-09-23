package androidx.appcompat.widget;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.core.content.C0875a;
import androidx.p054c.p055a.C0739c;
import com.google.firebase.analytics.FirebaseAnalytics.Event;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.WeakHashMap;

/* renamed from: androidx.appcompat.widget.ao */
/* compiled from: SuggestionsAdapter */
class C0636ao extends C0739c implements OnClickListener {

    /* renamed from: j */
    private final SearchManager f1821j = ((SearchManager) this.f2117d.getSystemService(Event.SEARCH));

    /* renamed from: k */
    private final SearchView f1822k;

    /* renamed from: l */
    private final SearchableInfo f1823l;

    /* renamed from: m */
    private final Context f1824m;

    /* renamed from: n */
    private final WeakHashMap<String, ConstantState> f1825n;

    /* renamed from: o */
    private final int f1826o;

    /* renamed from: p */
    private boolean f1827p = false;

    /* renamed from: q */
    private int f1828q = 1;

    /* renamed from: r */
    private ColorStateList f1829r;

    /* renamed from: s */
    private int f1830s = -1;

    /* renamed from: t */
    private int f1831t = -1;

    /* renamed from: u */
    private int f1832u = -1;

    /* renamed from: v */
    private int f1833v = -1;

    /* renamed from: w */
    private int f1834w = -1;

    /* renamed from: x */
    private int f1835x = -1;

    /* renamed from: androidx.appcompat.widget.ao$a */
    /* compiled from: SuggestionsAdapter */
    private static final class C0637a {

        /* renamed from: a */
        public final TextView f1836a;

        /* renamed from: b */
        public final TextView f1837b;

        /* renamed from: c */
        public final ImageView f1838c;

        /* renamed from: d */
        public final ImageView f1839d;

        /* renamed from: e */
        public final ImageView f1840e;

        public C0637a(View view) {
            this.f1836a = (TextView) view.findViewById(16908308);
            this.f1837b = (TextView) view.findViewById(16908309);
            this.f1838c = (ImageView) view.findViewById(16908295);
            this.f1839d = (ImageView) view.findViewById(16908296);
            this.f1840e = (ImageView) view.findViewById(R.id.edit_query);
        }
    }

    public boolean hasStableIds() {
        return false;
    }

    public C0636ao(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.f1822k = searchView;
        this.f1823l = searchableInfo;
        this.f1826o = searchView.getSuggestionCommitIconResId();
        this.f1824m = context;
        this.f1825n = weakHashMap;
    }

    /* renamed from: a */
    public void mo2375a(int i) {
        this.f1828q = i;
    }

    /* renamed from: a */
    public Cursor mo2372a(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        if (this.f1822k.getVisibility() != 0 || this.f1822k.getWindowVisibility() != 0) {
            return null;
        }
        try {
            Cursor a = mo2371a(this.f1823l, charSequence2, 50);
            if (a != null) {
                a.getCount();
                return a;
            }
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e);
        }
        return null;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        m2204d(mo2915a());
    }

    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        m2204d(mo2915a());
    }

    /* renamed from: d */
    private void m2204d(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null && !extras.getBoolean("in_progress")) {
        }
    }

    /* renamed from: a */
    public void mo2376a(Cursor cursor) {
        if (this.f1827p) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
            }
            return;
        }
        try {
            super.mo2376a(cursor);
            if (cursor != null) {
                this.f1830s = cursor.getColumnIndex("suggest_text_1");
                this.f1831t = cursor.getColumnIndex("suggest_text_2");
                this.f1832u = cursor.getColumnIndex("suggest_text_2_url");
                this.f1833v = cursor.getColumnIndex("suggest_icon_1");
                this.f1834w = cursor.getColumnIndex("suggest_icon_2");
                this.f1835x = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e);
        }
    }

    /* renamed from: a */
    public View mo2374a(Context context, Cursor cursor, ViewGroup viewGroup) {
        View a = super.mo2374a(context, cursor, viewGroup);
        a.setTag(new C0637a(a));
        ((ImageView) a.findViewById(R.id.edit_query)).setImageResource(this.f1826o);
        return a;
    }

    /* renamed from: a */
    public void mo2377a(View view, Context context, Cursor cursor) {
        CharSequence charSequence;
        C0637a aVar = (C0637a) view.getTag();
        int i = this.f1835x != -1 ? cursor.getInt(this.f1835x) : 0;
        if (aVar.f1836a != null) {
            m2198a(aVar.f1836a, (CharSequence) m2195a(cursor, this.f1830s));
        }
        if (aVar.f1837b != null) {
            String a = m2195a(cursor, this.f1832u);
            if (a != null) {
                charSequence = m2203b((CharSequence) a);
            } else {
                charSequence = m2195a(cursor, this.f1831t);
            }
            if (TextUtils.isEmpty(charSequence)) {
                if (aVar.f1836a != null) {
                    aVar.f1836a.setSingleLine(false);
                    aVar.f1836a.setMaxLines(2);
                }
            } else if (aVar.f1836a != null) {
                aVar.f1836a.setSingleLine(true);
                aVar.f1836a.setMaxLines(1);
            }
            m2198a(aVar.f1837b, charSequence);
        }
        if (aVar.f1838c != null) {
            m2197a(aVar.f1838c, m2205e(cursor), 4);
        }
        if (aVar.f1839d != null) {
            m2197a(aVar.f1839d, m2206f(cursor), 8);
        }
        if (this.f1828q == 2 || (this.f1828q == 1 && (i & 1) != 0)) {
            aVar.f1840e.setVisibility(0);
            aVar.f1840e.setTag(aVar.f1836a.getText());
            aVar.f1840e.setOnClickListener(this);
            return;
        }
        aVar.f1840e.setVisibility(8);
    }

    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f1822k.mo1945a((CharSequence) tag);
        }
    }

    /* renamed from: b */
    private CharSequence m2203b(CharSequence charSequence) {
        if (this.f1829r == null) {
            TypedValue typedValue = new TypedValue();
            this.f2117d.getTheme().resolveAttribute(R.attr.textColorSearchUrl, typedValue, true);
            this.f1829r = this.f2117d.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        TextAppearanceSpan textAppearanceSpan = new TextAppearanceSpan(null, 0, 0, this.f1829r, null);
        spannableString.setSpan(textAppearanceSpan, 0, charSequence.length(), 33);
        return spannableString;
    }

    /* renamed from: a */
    private void m2198a(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    /* renamed from: e */
    private Drawable m2205e(Cursor cursor) {
        if (this.f1833v == -1) {
            return null;
        }
        Drawable a = m2194a(cursor.getString(this.f1833v));
        if (a != null) {
            return a;
        }
        return m2207g(cursor);
    }

    /* renamed from: f */
    private Drawable m2206f(Cursor cursor) {
        if (this.f1834w == -1) {
            return null;
        }
        return m2194a(cursor.getString(this.f1834w));
    }

    /* renamed from: a */
    private void m2197a(ImageView imageView, Drawable drawable, int i) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    /* renamed from: b */
    public CharSequence mo2378b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        String a = m2196a(cursor, "suggest_intent_query");
        if (a != null) {
            return a;
        }
        if (this.f1823l.shouldRewriteQueryFromData()) {
            String a2 = m2196a(cursor, "suggest_intent_data");
            if (a2 != null) {
                return a2;
            }
        }
        if (this.f1823l.shouldRewriteQueryFromText()) {
            String a3 = m2196a(cursor, "suggest_text_1");
            if (a3 != null) {
                return a3;
            }
        }
        return null;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View a = mo2374a(this.f2117d, this.f2116c, viewGroup);
            if (a != null) {
                ((C0637a) a.getTag()).f1836a.setText(e.toString());
            }
            return a;
        }
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View b = mo2917b(this.f2117d, this.f2116c, viewGroup);
            if (b != null) {
                ((C0637a) b.getTag()).f1836a.setText(e.toString());
            }
            return b;
        }
    }

    /* renamed from: a */
    private Drawable m2194a(String str) {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(str);
            StringBuilder sb = new StringBuilder();
            sb.append("android.resource://");
            sb.append(this.f1824m.getPackageName());
            sb.append("/");
            sb.append(parseInt);
            String sb2 = sb.toString();
            Drawable b = m2202b(sb2);
            if (b != null) {
                return b;
            }
            Drawable a = C0875a.m3239a(this.f1824m, parseInt);
            m2199a(sb2, a);
            return a;
        } catch (NumberFormatException unused) {
            Drawable b2 = m2202b(str);
            if (b2 != null) {
                return b2;
            }
            Drawable b3 = m2201b(Uri.parse(str));
            m2199a(str, b3);
            return b3;
        } catch (NotFoundException unused2) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Icon resource not found: ");
            sb3.append(str);
            Log.w("SuggestionsAdapter", sb3.toString());
            return null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:7|8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        r2 = new java.lang.StringBuilder();
        r2.append("Resource does not exist: ");
        r2.append(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0028, code lost:
        throw new java.io.FileNotFoundException(r2.toString());
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0012 */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable m2201b(android.net.Uri r7) {
        /*
            r6 = this;
            r0 = 0
            java.lang.String r1 = r7.getScheme()     // Catch:{ FileNotFoundException -> 0x0089 }
            java.lang.String r2 = "android.resource"
            boolean r1 = r2.equals(r1)     // Catch:{ FileNotFoundException -> 0x0089 }
            if (r1 == 0) goto L_0x0029
            android.graphics.drawable.Drawable r1 = r6.mo2373a(r7)     // Catch:{ NotFoundException -> 0x0012 }
            return r1
        L_0x0012:
            java.io.FileNotFoundException r1 = new java.io.FileNotFoundException     // Catch:{ FileNotFoundException -> 0x0089 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0089 }
            r2.<init>()     // Catch:{ FileNotFoundException -> 0x0089 }
            java.lang.String r3 = "Resource does not exist: "
            r2.append(r3)     // Catch:{ FileNotFoundException -> 0x0089 }
            r2.append(r7)     // Catch:{ FileNotFoundException -> 0x0089 }
            java.lang.String r2 = r2.toString()     // Catch:{ FileNotFoundException -> 0x0089 }
            r1.<init>(r2)     // Catch:{ FileNotFoundException -> 0x0089 }
            throw r1     // Catch:{ FileNotFoundException -> 0x0089 }
        L_0x0029:
            android.content.Context r1 = r6.f1824m     // Catch:{ FileNotFoundException -> 0x0089 }
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch:{ FileNotFoundException -> 0x0089 }
            java.io.InputStream r1 = r1.openInputStream(r7)     // Catch:{ FileNotFoundException -> 0x0089 }
            if (r1 == 0) goto L_0x0072
            android.graphics.drawable.Drawable r2 = android.graphics.drawable.Drawable.createFromStream(r1, r0)     // Catch:{ all -> 0x0055 }
            r1.close()     // Catch:{ IOException -> 0x003d }
            goto L_0x0054
        L_0x003d:
            r1 = move-exception
            java.lang.String r3 = "SuggestionsAdapter"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0089 }
            r4.<init>()     // Catch:{ FileNotFoundException -> 0x0089 }
            java.lang.String r5 = "Error closing icon stream for "
            r4.append(r5)     // Catch:{ FileNotFoundException -> 0x0089 }
            r4.append(r7)     // Catch:{ FileNotFoundException -> 0x0089 }
            java.lang.String r4 = r4.toString()     // Catch:{ FileNotFoundException -> 0x0089 }
            android.util.Log.e(r3, r4, r1)     // Catch:{ FileNotFoundException -> 0x0089 }
        L_0x0054:
            return r2
        L_0x0055:
            r2 = move-exception
            r1.close()     // Catch:{ IOException -> 0x005a }
            goto L_0x0071
        L_0x005a:
            r1 = move-exception
            java.lang.String r3 = "SuggestionsAdapter"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0089 }
            r4.<init>()     // Catch:{ FileNotFoundException -> 0x0089 }
            java.lang.String r5 = "Error closing icon stream for "
            r4.append(r5)     // Catch:{ FileNotFoundException -> 0x0089 }
            r4.append(r7)     // Catch:{ FileNotFoundException -> 0x0089 }
            java.lang.String r4 = r4.toString()     // Catch:{ FileNotFoundException -> 0x0089 }
            android.util.Log.e(r3, r4, r1)     // Catch:{ FileNotFoundException -> 0x0089 }
        L_0x0071:
            throw r2     // Catch:{ FileNotFoundException -> 0x0089 }
        L_0x0072:
            java.io.FileNotFoundException r1 = new java.io.FileNotFoundException     // Catch:{ FileNotFoundException -> 0x0089 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0089 }
            r2.<init>()     // Catch:{ FileNotFoundException -> 0x0089 }
            java.lang.String r3 = "Failed to open "
            r2.append(r3)     // Catch:{ FileNotFoundException -> 0x0089 }
            r2.append(r7)     // Catch:{ FileNotFoundException -> 0x0089 }
            java.lang.String r2 = r2.toString()     // Catch:{ FileNotFoundException -> 0x0089 }
            r1.<init>(r2)     // Catch:{ FileNotFoundException -> 0x0089 }
            throw r1     // Catch:{ FileNotFoundException -> 0x0089 }
        L_0x0089:
            r1 = move-exception
            java.lang.String r2 = "SuggestionsAdapter"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Icon not found: "
            r3.append(r4)
            r3.append(r7)
            java.lang.String r7 = ", "
            r3.append(r7)
            java.lang.String r7 = r1.getMessage()
            r3.append(r7)
            java.lang.String r7 = r3.toString()
            android.util.Log.w(r2, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0636ao.m2201b(android.net.Uri):android.graphics.drawable.Drawable");
    }

    /* renamed from: b */
    private Drawable m2202b(String str) {
        ConstantState constantState = (ConstantState) this.f1825n.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    /* renamed from: a */
    private void m2199a(String str, Drawable drawable) {
        if (drawable != null) {
            this.f1825n.put(str, drawable.getConstantState());
        }
    }

    /* renamed from: g */
    private Drawable m2207g(Cursor cursor) {
        Drawable a = m2193a(this.f1823l.getSearchActivity());
        if (a != null) {
            return a;
        }
        return this.f2117d.getPackageManager().getDefaultActivityIcon();
    }

    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r2v2, types: [android.graphics.drawable.Drawable$ConstantState] */
    /* JADX WARNING: type inference failed for: r2v3, types: [android.graphics.drawable.Drawable] */
    /* JADX WARNING: type inference failed for: r2v4, types: [android.graphics.drawable.Drawable] */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r2v0
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], android.graphics.drawable.Drawable, android.graphics.drawable.Drawable$ConstantState]
      uses: [java.lang.Object, android.graphics.drawable.Drawable]
      mth insns count: 21
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable m2193a(android.content.ComponentName r4) {
        /*
            r3 = this;
            java.lang.String r0 = r4.flattenToShortString()
            java.util.WeakHashMap<java.lang.String, android.graphics.drawable.Drawable$ConstantState> r1 = r3.f1825n
            boolean r1 = r1.containsKey(r0)
            r2 = 0
            if (r1 == 0) goto L_0x0023
            java.util.WeakHashMap<java.lang.String, android.graphics.drawable.Drawable$ConstantState> r4 = r3.f1825n
            java.lang.Object r4 = r4.get(r0)
            android.graphics.drawable.Drawable$ConstantState r4 = (android.graphics.drawable.Drawable.ConstantState) r4
            if (r4 != 0) goto L_0x0018
            goto L_0x0022
        L_0x0018:
            android.content.Context r0 = r3.f1824m
            android.content.res.Resources r0 = r0.getResources()
            android.graphics.drawable.Drawable r2 = r4.newDrawable(r0)
        L_0x0022:
            return r2
        L_0x0023:
            android.graphics.drawable.Drawable r4 = r3.m2200b(r4)
            if (r4 != 0) goto L_0x002a
            goto L_0x002e
        L_0x002a:
            android.graphics.drawable.Drawable$ConstantState r2 = r4.getConstantState()
        L_0x002e:
            java.util.WeakHashMap<java.lang.String, android.graphics.drawable.Drawable$ConstantState> r1 = r3.f1825n
            r1.put(r0, r2)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0636ao.m2193a(android.content.ComponentName):android.graphics.drawable.Drawable");
    }

    /* renamed from: b */
    private Drawable m2200b(ComponentName componentName) {
        PackageManager packageManager = this.f2117d.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid icon resource ");
            sb.append(iconResource);
            sb.append(" for ");
            sb.append(componentName.flattenToShortString());
            Log.w("SuggestionsAdapter", sb.toString());
            return null;
        } catch (NameNotFoundException e) {
            Log.w("SuggestionsAdapter", e.toString());
            return null;
        }
    }

    /* renamed from: a */
    public static String m2196a(Cursor cursor, String str) {
        return m2195a(cursor, cursor.getColumnIndex(str));
    }

    /* renamed from: a */
    private static String m2195a(Cursor cursor, int i) {
        if (i == -1) {
            return null;
        }
        try {
            return cursor.getString(i);
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e);
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Drawable mo2373a(Uri uri) throws FileNotFoundException {
        int i;
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            try {
                Resources resourcesForApplication = this.f2117d.getPackageManager().getResourcesForApplication(authority);
                List pathSegments = uri.getPathSegments();
                if (pathSegments != null) {
                    int size = pathSegments.size();
                    if (size == 1) {
                        try {
                            i = Integer.parseInt((String) pathSegments.get(0));
                        } catch (NumberFormatException unused) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Single path segment is not a resource ID: ");
                            sb.append(uri);
                            throw new FileNotFoundException(sb.toString());
                        }
                    } else if (size == 2) {
                        i = resourcesForApplication.getIdentifier((String) pathSegments.get(1), (String) pathSegments.get(0), authority);
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("More than two path segments: ");
                        sb2.append(uri);
                        throw new FileNotFoundException(sb2.toString());
                    }
                    if (i != 0) {
                        return resourcesForApplication.getDrawable(i);
                    }
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("No resource found for: ");
                    sb3.append(uri);
                    throw new FileNotFoundException(sb3.toString());
                }
                StringBuilder sb4 = new StringBuilder();
                sb4.append("No path: ");
                sb4.append(uri);
                throw new FileNotFoundException(sb4.toString());
            } catch (NameNotFoundException unused2) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("No package found for authority: ");
                sb5.append(uri);
                throw new FileNotFoundException(sb5.toString());
            }
        } else {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("No authority: ");
            sb6.append(uri);
            throw new FileNotFoundException(sb6.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Cursor mo2371a(SearchableInfo searchableInfo, String str, int i) {
        String[] strArr = null;
        if (searchableInfo == null) {
            return null;
        }
        String suggestAuthority = searchableInfo.getSuggestAuthority();
        if (suggestAuthority == null) {
            return null;
        }
        Builder fragment = new Builder().scheme(Param.CONTENT).authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i));
        }
        return this.f2117d.getContentResolver().query(fragment.build(), null, suggestSelection, strArr2, null);
    }
}
