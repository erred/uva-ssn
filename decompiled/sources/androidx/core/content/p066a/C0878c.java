package androidx.core.content.p066a;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import androidx.core.R;
import androidx.core.p067d.C0892a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: androidx.core.content.a.c */
/* compiled from: FontResourcesParserCompat */
public class C0878c {

    /* renamed from: androidx.core.content.a.c$a */
    /* compiled from: FontResourcesParserCompat */
    public interface C0879a {
    }

    /* renamed from: androidx.core.content.a.c$b */
    /* compiled from: FontResourcesParserCompat */
    public static final class C0880b implements C0879a {

        /* renamed from: a */
        private final C0881c[] f2835a;

        public C0880b(C0881c[] cVarArr) {
            this.f2835a = cVarArr;
        }

        /* renamed from: a */
        public C0881c[] mo3566a() {
            return this.f2835a;
        }
    }

    /* renamed from: androidx.core.content.a.c$c */
    /* compiled from: FontResourcesParserCompat */
    public static final class C0881c {

        /* renamed from: a */
        private final String f2836a;

        /* renamed from: b */
        private int f2837b;

        /* renamed from: c */
        private boolean f2838c;

        /* renamed from: d */
        private String f2839d;

        /* renamed from: e */
        private int f2840e;

        /* renamed from: f */
        private int f2841f;

        public C0881c(String str, int i, boolean z, String str2, int i2, int i3) {
            this.f2836a = str;
            this.f2837b = i;
            this.f2838c = z;
            this.f2839d = str2;
            this.f2840e = i2;
            this.f2841f = i3;
        }

        /* renamed from: a */
        public String mo3567a() {
            return this.f2836a;
        }

        /* renamed from: b */
        public int mo3568b() {
            return this.f2837b;
        }

        /* renamed from: c */
        public boolean mo3569c() {
            return this.f2838c;
        }

        /* renamed from: d */
        public String mo3570d() {
            return this.f2839d;
        }

        /* renamed from: e */
        public int mo3571e() {
            return this.f2840e;
        }

        /* renamed from: f */
        public int mo3572f() {
            return this.f2841f;
        }
    }

    /* renamed from: androidx.core.content.a.c$d */
    /* compiled from: FontResourcesParserCompat */
    public static final class C0882d implements C0879a {

        /* renamed from: a */
        private final C0892a f2842a;

        /* renamed from: b */
        private final int f2843b;

        /* renamed from: c */
        private final int f2844c;

        public C0882d(C0892a aVar, int i, int i2) {
            this.f2842a = aVar;
            this.f2844c = i;
            this.f2843b = i2;
        }

        /* renamed from: a */
        public C0892a mo3573a() {
            return this.f2842a;
        }

        /* renamed from: b */
        public int mo3574b() {
            return this.f2844c;
        }

        /* renamed from: c */
        public int mo3575c() {
            return this.f2843b;
        }
    }

    /* renamed from: a */
    public static C0879a m3268a(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return m3272b(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    /* renamed from: b */
    private static C0879a m3272b(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return m3273c(xmlPullParser, resources);
        }
        m3271a(xmlPullParser);
        return null;
    }

    /* renamed from: c */
    private static C0879a m3273c(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.FontFamily);
        String string = obtainAttributes.getString(R.styleable.FontFamily_fontProviderAuthority);
        String string2 = obtainAttributes.getString(R.styleable.FontFamily_fontProviderPackage);
        String string3 = obtainAttributes.getString(R.styleable.FontFamily_fontProviderQuery);
        int resourceId = obtainAttributes.getResourceId(R.styleable.FontFamily_fontProviderCerts, 0);
        int integer = obtainAttributes.getInteger(R.styleable.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = obtainAttributes.getInteger(R.styleable.FontFamily_fontProviderFetchTimeout, 500);
        obtainAttributes.recycle();
        if (string == null || string2 == null || string3 == null) {
            ArrayList arrayList = new ArrayList();
            while (xmlPullParser.next() != 3) {
                if (xmlPullParser.getEventType() == 2) {
                    if (xmlPullParser.getName().equals("font")) {
                        arrayList.add(m3274d(xmlPullParser, resources));
                    } else {
                        m3271a(xmlPullParser);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            return new C0880b((C0881c[]) arrayList.toArray(new C0881c[arrayList.size()]));
        }
        while (xmlPullParser.next() != 3) {
            m3271a(xmlPullParser);
        }
        return new C0882d(new C0892a(string, string2, string3, m3269a(resources, resourceId)), integer, integer2);
    }

    /* renamed from: a */
    private static int m3267a(TypedArray typedArray, int i) {
        if (VERSION.SDK_INT >= 21) {
            return typedArray.getType(i);
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i, typedValue);
        return typedValue.type;
    }

    /* renamed from: a */
    public static List<List<byte[]>> m3269a(Resources resources, int i) {
        if (i == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (m3267a(obtainTypedArray, 0) == 1) {
                for (int i2 = 0; i2 < obtainTypedArray.length(); i2++) {
                    int resourceId = obtainTypedArray.getResourceId(i2, 0);
                    if (resourceId != 0) {
                        arrayList.add(m3270a(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(m3270a(resources.getStringArray(i)));
            }
            obtainTypedArray.recycle();
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    /* renamed from: a */
    private static List<byte[]> m3270a(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String decode : strArr) {
            arrayList.add(Base64.decode(decode, 0));
        }
        return arrayList;
    }

    /* renamed from: d */
    private static C0881c m3274d(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.FontFamilyFont);
        int i = obtainAttributes.getInt(obtainAttributes.hasValue(R.styleable.FontFamilyFont_fontWeight) ? R.styleable.FontFamilyFont_fontWeight : R.styleable.FontFamilyFont_android_fontWeight, 400);
        boolean z = 1 == obtainAttributes.getInt(obtainAttributes.hasValue(R.styleable.FontFamilyFont_fontStyle) ? R.styleable.FontFamilyFont_fontStyle : R.styleable.FontFamilyFont_android_fontStyle, 0);
        int i2 = obtainAttributes.hasValue(R.styleable.FontFamilyFont_ttcIndex) ? R.styleable.FontFamilyFont_ttcIndex : R.styleable.FontFamilyFont_android_ttcIndex;
        String string = obtainAttributes.getString(obtainAttributes.hasValue(R.styleable.FontFamilyFont_fontVariationSettings) ? R.styleable.FontFamilyFont_fontVariationSettings : R.styleable.FontFamilyFont_android_fontVariationSettings);
        int i3 = obtainAttributes.getInt(i2, 0);
        int i4 = obtainAttributes.hasValue(R.styleable.FontFamilyFont_font) ? R.styleable.FontFamilyFont_font : R.styleable.FontFamilyFont_android_font;
        int resourceId = obtainAttributes.getResourceId(i4, 0);
        String string2 = obtainAttributes.getString(i4);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            m3271a(xmlPullParser);
        }
        C0881c cVar = new C0881c(string2, i, z, string, i3, resourceId);
        return cVar;
    }

    /* renamed from: a */
    private static void m3271a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i = 1;
        while (i > 0) {
            switch (xmlPullParser.next()) {
                case 2:
                    i++;
                    break;
                case 3:
                    i--;
                    break;
            }
        }
    }
}
