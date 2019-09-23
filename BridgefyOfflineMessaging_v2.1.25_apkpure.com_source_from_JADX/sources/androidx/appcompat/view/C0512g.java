package androidx.appcompat.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.C0537j;
import androidx.appcompat.view.menu.C0539k;
import androidx.appcompat.widget.C0607ad;
import androidx.core.p070g.C0943b;
import androidx.core.p070g.C0951g;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: androidx.appcompat.view.g */
/* compiled from: SupportMenuInflater */
public class C0512g extends MenuInflater {

    /* renamed from: a */
    static final Class<?>[] f1233a = {Context.class};

    /* renamed from: b */
    static final Class<?>[] f1234b = f1233a;

    /* renamed from: c */
    final Object[] f1235c;

    /* renamed from: d */
    final Object[] f1236d = this.f1235c;

    /* renamed from: e */
    Context f1237e;

    /* renamed from: f */
    private Object f1238f;

    /* renamed from: androidx.appcompat.view.g$a */
    /* compiled from: SupportMenuInflater */
    private static class C0513a implements OnMenuItemClickListener {

        /* renamed from: a */
        private static final Class<?>[] f1239a = {MenuItem.class};

        /* renamed from: b */
        private Object f1240b;

        /* renamed from: c */
        private Method f1241c;

        public C0513a(Object obj, String str) {
            this.f1240b = obj;
            Class cls = obj.getClass();
            try {
                this.f1241c = cls.getMethod(str, f1239a);
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Couldn't resolve menu item onClick handler ");
                sb.append(str);
                sb.append(" in class ");
                sb.append(cls.getName());
                InflateException inflateException = new InflateException(sb.toString());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f1241c.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f1241c.invoke(this.f1240b, new Object[]{menuItem})).booleanValue();
                }
                this.f1241c.invoke(this.f1240b, new Object[]{menuItem});
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* renamed from: androidx.appcompat.view.g$b */
    /* compiled from: SupportMenuInflater */
    private class C0514b {

        /* renamed from: A */
        private String f1242A;

        /* renamed from: B */
        private String f1243B;

        /* renamed from: C */
        private CharSequence f1244C;

        /* renamed from: D */
        private CharSequence f1245D;

        /* renamed from: E */
        private ColorStateList f1246E = null;

        /* renamed from: F */
        private Mode f1247F = null;

        /* renamed from: a */
        C0943b f1248a;

        /* renamed from: c */
        private Menu f1250c;

        /* renamed from: d */
        private int f1251d;

        /* renamed from: e */
        private int f1252e;

        /* renamed from: f */
        private int f1253f;

        /* renamed from: g */
        private int f1254g;

        /* renamed from: h */
        private boolean f1255h;

        /* renamed from: i */
        private boolean f1256i;

        /* renamed from: j */
        private boolean f1257j;

        /* renamed from: k */
        private int f1258k;

        /* renamed from: l */
        private int f1259l;

        /* renamed from: m */
        private CharSequence f1260m;

        /* renamed from: n */
        private CharSequence f1261n;

        /* renamed from: o */
        private int f1262o;

        /* renamed from: p */
        private char f1263p;

        /* renamed from: q */
        private int f1264q;

        /* renamed from: r */
        private char f1265r;

        /* renamed from: s */
        private int f1266s;

        /* renamed from: t */
        private int f1267t;

        /* renamed from: u */
        private boolean f1268u;

        /* renamed from: v */
        private boolean f1269v;

        /* renamed from: w */
        private boolean f1270w;

        /* renamed from: x */
        private int f1271x;

        /* renamed from: y */
        private int f1272y;

        /* renamed from: z */
        private String f1273z;

        public C0514b(Menu menu) {
            this.f1250c = menu;
            mo1283a();
        }

        /* renamed from: a */
        public void mo1283a() {
            this.f1251d = 0;
            this.f1252e = 0;
            this.f1253f = 0;
            this.f1254g = 0;
            this.f1255h = true;
            this.f1256i = true;
        }

        /* renamed from: a */
        public void mo1284a(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = C0512g.this.f1237e.obtainStyledAttributes(attributeSet, R.styleable.MenuGroup);
            this.f1251d = obtainStyledAttributes.getResourceId(R.styleable.MenuGroup_android_id, 0);
            this.f1252e = obtainStyledAttributes.getInt(R.styleable.MenuGroup_android_menuCategory, 0);
            this.f1253f = obtainStyledAttributes.getInt(R.styleable.MenuGroup_android_orderInCategory, 0);
            this.f1254g = obtainStyledAttributes.getInt(R.styleable.MenuGroup_android_checkableBehavior, 0);
            this.f1255h = obtainStyledAttributes.getBoolean(R.styleable.MenuGroup_android_visible, true);
            this.f1256i = obtainStyledAttributes.getBoolean(R.styleable.MenuGroup_android_enabled, true);
            obtainStyledAttributes.recycle();
        }

        /* renamed from: b */
        public void mo1286b(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = C0512g.this.f1237e.obtainStyledAttributes(attributeSet, R.styleable.MenuItem);
            this.f1258k = obtainStyledAttributes.getResourceId(R.styleable.MenuItem_android_id, 0);
            this.f1259l = (obtainStyledAttributes.getInt(R.styleable.MenuItem_android_menuCategory, this.f1252e) & -65536) | (obtainStyledAttributes.getInt(R.styleable.MenuItem_android_orderInCategory, this.f1253f) & 65535);
            this.f1260m = obtainStyledAttributes.getText(R.styleable.MenuItem_android_title);
            this.f1261n = obtainStyledAttributes.getText(R.styleable.MenuItem_android_titleCondensed);
            this.f1262o = obtainStyledAttributes.getResourceId(R.styleable.MenuItem_android_icon, 0);
            this.f1263p = m1691a(obtainStyledAttributes.getString(R.styleable.MenuItem_android_alphabeticShortcut));
            this.f1264q = obtainStyledAttributes.getInt(R.styleable.MenuItem_alphabeticModifiers, 4096);
            this.f1265r = m1691a(obtainStyledAttributes.getString(R.styleable.MenuItem_android_numericShortcut));
            this.f1266s = obtainStyledAttributes.getInt(R.styleable.MenuItem_numericModifiers, 4096);
            if (obtainStyledAttributes.hasValue(R.styleable.MenuItem_android_checkable)) {
                this.f1267t = obtainStyledAttributes.getBoolean(R.styleable.MenuItem_android_checkable, false) ? 1 : 0;
            } else {
                this.f1267t = this.f1254g;
            }
            this.f1268u = obtainStyledAttributes.getBoolean(R.styleable.MenuItem_android_checked, false);
            this.f1269v = obtainStyledAttributes.getBoolean(R.styleable.MenuItem_android_visible, this.f1255h);
            this.f1270w = obtainStyledAttributes.getBoolean(R.styleable.MenuItem_android_enabled, this.f1256i);
            this.f1271x = obtainStyledAttributes.getInt(R.styleable.MenuItem_showAsAction, -1);
            this.f1243B = obtainStyledAttributes.getString(R.styleable.MenuItem_android_onClick);
            this.f1272y = obtainStyledAttributes.getResourceId(R.styleable.MenuItem_actionLayout, 0);
            this.f1273z = obtainStyledAttributes.getString(R.styleable.MenuItem_actionViewClass);
            this.f1242A = obtainStyledAttributes.getString(R.styleable.MenuItem_actionProviderClass);
            boolean z = this.f1242A != null;
            if (z && this.f1272y == 0 && this.f1273z == null) {
                this.f1248a = (C0943b) m1692a(this.f1242A, C0512g.f1234b, C0512g.this.f1236d);
            } else {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.f1248a = null;
            }
            this.f1244C = obtainStyledAttributes.getText(R.styleable.MenuItem_contentDescription);
            this.f1245D = obtainStyledAttributes.getText(R.styleable.MenuItem_tooltipText);
            if (obtainStyledAttributes.hasValue(R.styleable.MenuItem_iconTintMode)) {
                this.f1247F = C0607ad.m2102a(obtainStyledAttributes.getInt(R.styleable.MenuItem_iconTintMode, -1), this.f1247F);
            } else {
                this.f1247F = null;
            }
            if (obtainStyledAttributes.hasValue(R.styleable.MenuItem_iconTint)) {
                this.f1246E = obtainStyledAttributes.getColorStateList(R.styleable.MenuItem_iconTint);
            } else {
                this.f1246E = null;
            }
            obtainStyledAttributes.recycle();
            this.f1257j = false;
        }

        /* renamed from: a */
        private char m1691a(String str) {
            if (str == null) {
                return 0;
            }
            return str.charAt(0);
        }

        /* renamed from: a */
        private void m1693a(MenuItem menuItem) {
            boolean z = false;
            menuItem.setChecked(this.f1268u).setVisible(this.f1269v).setEnabled(this.f1270w).setCheckable(this.f1267t >= 1).setTitleCondensed(this.f1261n).setIcon(this.f1262o);
            if (this.f1271x >= 0) {
                menuItem.setShowAsAction(this.f1271x);
            }
            if (this.f1243B != null) {
                if (!C0512g.this.f1237e.isRestricted()) {
                    menuItem.setOnMenuItemClickListener(new C0513a(C0512g.this.mo1280a(), this.f1243B));
                } else {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
            }
            boolean z2 = menuItem instanceof C0537j;
            if (z2) {
                C0537j jVar = (C0537j) menuItem;
            }
            if (this.f1267t >= 2) {
                if (z2) {
                    ((C0537j) menuItem).mo1569a(true);
                } else if (menuItem instanceof C0539k) {
                    ((C0539k) menuItem).mo1626a(true);
                }
            }
            if (this.f1273z != null) {
                menuItem.setActionView((View) m1692a(this.f1273z, C0512g.f1233a, C0512g.this.f1235c));
                z = true;
            }
            if (this.f1272y > 0) {
                if (!z) {
                    menuItem.setActionView(this.f1272y);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            if (this.f1248a != null) {
                C0951g.m3506a(menuItem, this.f1248a);
            }
            C0951g.m3510a(menuItem, this.f1244C);
            C0951g.m3512b(menuItem, this.f1245D);
            C0951g.m3511b(menuItem, this.f1263p, this.f1264q);
            C0951g.m3507a(menuItem, this.f1265r, this.f1266s);
            if (this.f1247F != null) {
                C0951g.m3509a(menuItem, this.f1247F);
            }
            if (this.f1246E != null) {
                C0951g.m3508a(menuItem, this.f1246E);
            }
        }

        /* renamed from: b */
        public void mo1285b() {
            this.f1257j = true;
            m1693a(this.f1250c.add(this.f1251d, this.f1258k, this.f1259l, this.f1260m));
        }

        /* renamed from: c */
        public SubMenu mo1287c() {
            this.f1257j = true;
            SubMenu addSubMenu = this.f1250c.addSubMenu(this.f1251d, this.f1258k, this.f1259l, this.f1260m);
            m1693a(addSubMenu.getItem());
            return addSubMenu;
        }

        /* renamed from: d */
        public boolean mo1288d() {
            return this.f1257j;
        }

        /* renamed from: a */
        private <T> T m1692a(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor constructor = C0512g.this.f1237e.getClassLoader().loadClass(str).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Cannot instantiate class: ");
                sb.append(str);
                Log.w("SupportMenuInflater", sb.toString(), e);
                return null;
            }
        }
    }

    public C0512g(Context context) {
        super(context);
        this.f1237e = context;
        this.f1235c = new Object[]{context};
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void inflate(int r3, android.view.Menu r4) {
        /*
            r2 = this;
            boolean r0 = r4 instanceof androidx.core.p062a.p063a.C0836a
            if (r0 != 0) goto L_0x0008
            super.inflate(r3, r4)
            return
        L_0x0008:
            r0 = 0
            android.content.Context r1 = r2.f1237e     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x002b }
            android.content.res.Resources r1 = r1.getResources()     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x002b }
            android.content.res.XmlResourceParser r3 = r1.getLayout(r3)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x002b }
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r3)     // Catch:{ XmlPullParserException -> 0x0026, IOException -> 0x0023, all -> 0x0020 }
            r2.m1689a(r3, r0, r4)     // Catch:{ XmlPullParserException -> 0x0026, IOException -> 0x0023, all -> 0x0020 }
            if (r3 == 0) goto L_0x001f
            r3.close()
        L_0x001f:
            return
        L_0x0020:
            r4 = move-exception
            r0 = r3
            goto L_0x003d
        L_0x0023:
            r4 = move-exception
            r0 = r3
            goto L_0x002c
        L_0x0026:
            r4 = move-exception
            r0 = r3
            goto L_0x0035
        L_0x0029:
            r4 = move-exception
            goto L_0x003d
        L_0x002b:
            r4 = move-exception
        L_0x002c:
            android.view.InflateException r3 = new android.view.InflateException     // Catch:{ all -> 0x0029 }
            java.lang.String r1 = "Error inflating menu XML"
            r3.<init>(r1, r4)     // Catch:{ all -> 0x0029 }
            throw r3     // Catch:{ all -> 0x0029 }
        L_0x0034:
            r4 = move-exception
        L_0x0035:
            android.view.InflateException r3 = new android.view.InflateException     // Catch:{ all -> 0x0029 }
            java.lang.String r1 = "Error inflating menu XML"
            r3.<init>(r1, r4)     // Catch:{ all -> 0x0029 }
            throw r3     // Catch:{ all -> 0x0029 }
        L_0x003d:
            if (r0 == 0) goto L_0x0042
            r0.close()
        L_0x0042:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.C0512g.inflate(int, android.view.Menu):void");
    }

    /* renamed from: a */
    private void m1689a(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        C0514b bVar = new C0514b(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType != 2) {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            } else {
                String name = xmlPullParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlPullParser.next();
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Expecting menu, got ");
                    sb.append(name);
                    throw new RuntimeException(sb.toString());
                }
            }
        }
        int i = eventType;
        String str = null;
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            switch (i) {
                case 1:
                    throw new RuntimeException("Unexpected end of document");
                case 2:
                    if (!z2) {
                        String name2 = xmlPullParser.getName();
                        if (!name2.equals("group")) {
                            if (!name2.equals("item")) {
                                if (!name2.equals("menu")) {
                                    str = name2;
                                    z2 = true;
                                    break;
                                } else {
                                    m1689a(xmlPullParser, attributeSet, bVar.mo1287c());
                                    break;
                                }
                            } else {
                                bVar.mo1286b(attributeSet);
                                break;
                            }
                        } else {
                            bVar.mo1284a(attributeSet);
                            break;
                        }
                    } else {
                        break;
                    }
                case 3:
                    String name3 = xmlPullParser.getName();
                    if (!z2 || !name3.equals(str)) {
                        if (!name3.equals("group")) {
                            if (!name3.equals("item")) {
                                if (!name3.equals("menu")) {
                                    break;
                                } else {
                                    z = true;
                                    break;
                                }
                            } else if (!bVar.mo1288d()) {
                                if (bVar.f1248a != null && bVar.f1248a.mo1684c()) {
                                    bVar.mo1287c();
                                    break;
                                } else {
                                    bVar.mo1285b();
                                    break;
                                }
                            } else {
                                break;
                            }
                        } else {
                            bVar.mo1283a();
                            break;
                        }
                    } else {
                        str = null;
                        z2 = false;
                        break;
                    }
            }
            i = xmlPullParser.next();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Object mo1280a() {
        if (this.f1238f == null) {
            this.f1238f = m1688a(this.f1237e);
        }
        return this.f1238f;
    }

    /* renamed from: a */
    private Object m1688a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? m1688a(((ContextWrapper) obj).getBaseContext()) : obj;
    }
}
