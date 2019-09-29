package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.StaticLayout.Builder;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.appcompat.R;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: androidx.appcompat.widget.aa */
/* compiled from: AppCompatTextViewAutoSizeHelper */
class C0604aa {

    /* renamed from: a */
    private static final RectF f1700a = new RectF();

    /* renamed from: b */
    private static ConcurrentHashMap<String, Method> f1701b = new ConcurrentHashMap<>();

    /* renamed from: c */
    private int f1702c = 0;

    /* renamed from: d */
    private boolean f1703d = false;

    /* renamed from: e */
    private float f1704e = -1.0f;

    /* renamed from: f */
    private float f1705f = -1.0f;

    /* renamed from: g */
    private float f1706g = -1.0f;

    /* renamed from: h */
    private int[] f1707h = new int[0];

    /* renamed from: i */
    private boolean f1708i = false;

    /* renamed from: j */
    private TextPaint f1709j;

    /* renamed from: k */
    private final TextView f1710k;

    /* renamed from: l */
    private final Context f1711l;

    C0604aa(TextView textView) {
        this.f1710k = textView;
        this.f1711l = this.f1710k.getContext();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo2149a(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.f1711l.obtainStyledAttributes(attributeSet, R.styleable.AppCompatTextView, i, 0);
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_autoSizeTextType)) {
            this.f1702c = obtainStyledAttributes.getInt(R.styleable.AppCompatTextView_autoSizeTextType, 0);
        }
        float dimension = obtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_autoSizeStepGranularity) ? obtainStyledAttributes.getDimension(R.styleable.AppCompatTextView_autoSizeStepGranularity, -1.0f) : -1.0f;
        float dimension2 = obtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_autoSizeMinTextSize) ? obtainStyledAttributes.getDimension(R.styleable.AppCompatTextView_autoSizeMinTextSize, -1.0f) : -1.0f;
        float dimension3 = obtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_autoSizeMaxTextSize) ? obtainStyledAttributes.getDimension(R.styleable.AppCompatTextView_autoSizeMaxTextSize, -1.0f) : -1.0f;
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_autoSizePresetSizes)) {
            int resourceId = obtainStyledAttributes.getResourceId(R.styleable.AppCompatTextView_autoSizePresetSizes, 0);
            if (resourceId > 0) {
                TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId);
                m2043a(obtainTypedArray);
                obtainTypedArray.recycle();
            }
        }
        obtainStyledAttributes.recycle();
        if (!m2049k()) {
            this.f1702c = 0;
        } else if (this.f1702c == 1) {
            if (!this.f1708i) {
                DisplayMetrics displayMetrics = this.f1711l.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                m2042a(dimension2, dimension3, dimension);
            }
            m2047i();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo2146a(int i) {
        if (m2049k()) {
            switch (i) {
                case 0:
                    m2048j();
                    return;
                case 1:
                    DisplayMetrics displayMetrics = this.f1711l.getResources().getDisplayMetrics();
                    m2042a(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
                    if (m2047i()) {
                        mo2155f();
                        return;
                    }
                    return;
                default:
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unknown auto-size text type: ");
                    sb.append(i);
                    throw new IllegalArgumentException(sb.toString());
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo2148a(int i, int i2, int i3, int i4) throws IllegalArgumentException {
        if (m2049k()) {
            DisplayMetrics displayMetrics = this.f1711l.getResources().getDisplayMetrics();
            m2042a(TypedValue.applyDimension(i4, (float) i, displayMetrics), TypedValue.applyDimension(i4, (float) i2, displayMetrics), TypedValue.applyDimension(i4, (float) i3, displayMetrics));
            if (m2047i()) {
                mo2155f();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo2150a(int[] iArr, int i) throws IllegalArgumentException {
        if (m2049k()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.f1711l.getResources().getDisplayMetrics();
                    for (int i2 = 0; i2 < length; i2++) {
                        iArr2[i2] = Math.round(TypedValue.applyDimension(i, (float) iArr[i2], displayMetrics));
                    }
                }
                this.f1707h = m2045a(iArr2);
                if (!m2046h()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("None of the preset sizes is valid: ");
                    sb.append(Arrays.toString(iArr));
                    throw new IllegalArgumentException(sb.toString());
                }
            } else {
                this.f1708i = false;
            }
            if (m2047i()) {
                mo2155f();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int mo2145a() {
        return this.f1702c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public int mo2151b() {
        return Math.round(this.f1704e);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public int mo2152c() {
        return Math.round(this.f1705f);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public int mo2153d() {
        return Math.round(this.f1706g);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public int[] mo2154e() {
        return this.f1707h;
    }

    /* renamed from: a */
    private void m2043a(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                iArr[i] = typedArray.getDimensionPixelSize(i, -1);
            }
            this.f1707h = m2045a(iArr);
            m2046h();
        }
    }

    /* renamed from: h */
    private boolean m2046h() {
        int length = this.f1707h.length;
        this.f1708i = length > 0;
        if (this.f1708i) {
            this.f1702c = 1;
            this.f1705f = (float) this.f1707h[0];
            this.f1706g = (float) this.f1707h[length - 1];
            this.f1704e = -1.0f;
        }
        return this.f1708i;
    }

    /* renamed from: a */
    private int[] m2045a(int[] iArr) {
        if (r0 == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            if (i > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i)) < 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        if (r0 == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr2[i2] = ((Integer) arrayList.get(i2)).intValue();
        }
        return iArr2;
    }

    /* renamed from: a */
    private void m2042a(float f, float f2, float f3) throws IllegalArgumentException {
        if (f <= BitmapDescriptorFactory.HUE_RED) {
            StringBuilder sb = new StringBuilder();
            sb.append("Minimum auto-size text size (");
            sb.append(f);
            sb.append("px) is less or equal to (0px)");
            throw new IllegalArgumentException(sb.toString());
        } else if (f2 <= f) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Maximum auto-size text size (");
            sb2.append(f2);
            sb2.append("px) is less or equal to minimum auto-size ");
            sb2.append("text size (");
            sb2.append(f);
            sb2.append("px)");
            throw new IllegalArgumentException(sb2.toString());
        } else if (f3 > BitmapDescriptorFactory.HUE_RED) {
            this.f1702c = 1;
            this.f1705f = f;
            this.f1706g = f2;
            this.f1704e = f3;
            this.f1708i = false;
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("The auto-size step granularity (");
            sb3.append(f3);
            sb3.append("px) is less or equal to (0px)");
            throw new IllegalArgumentException(sb3.toString());
        }
    }

    /* renamed from: i */
    private boolean m2047i() {
        if (!m2049k() || this.f1702c != 1) {
            this.f1703d = false;
        } else {
            if (!this.f1708i || this.f1707h.length == 0) {
                float round = (float) Math.round(this.f1705f);
                int i = 1;
                while (Math.round(this.f1704e + round) <= Math.round(this.f1706g)) {
                    i++;
                    round += this.f1704e;
                }
                int[] iArr = new int[i];
                float f = this.f1705f;
                for (int i2 = 0; i2 < i; i2++) {
                    iArr[i2] = Math.round(f);
                    f += this.f1704e;
                }
                this.f1707h = m2045a(iArr);
            }
            this.f1703d = true;
        }
        return this.f1703d;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public void mo2155f() {
        int i;
        if (mo2156g()) {
            if (this.f1703d) {
                if (this.f1710k.getMeasuredHeight() > 0 && this.f1710k.getMeasuredWidth() > 0) {
                    if (((Boolean) m2039a((Object) this.f1710k, "getHorizontallyScrolling", (T) Boolean.valueOf(false))).booleanValue()) {
                        i = 1048576;
                    } else {
                        i = (this.f1710k.getMeasuredWidth() - this.f1710k.getTotalPaddingLeft()) - this.f1710k.getTotalPaddingRight();
                    }
                    int height = (this.f1710k.getHeight() - this.f1710k.getCompoundPaddingBottom()) - this.f1710k.getCompoundPaddingTop();
                    if (i > 0 && height > 0) {
                        synchronized (f1700a) {
                            f1700a.setEmpty();
                            f1700a.right = (float) i;
                            f1700a.bottom = (float) height;
                            float a = (float) m2036a(f1700a);
                            if (a != this.f1710k.getTextSize()) {
                                mo2147a(0, a);
                            }
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            this.f1703d = true;
        }
    }

    /* renamed from: j */
    private void m2048j() {
        this.f1702c = 0;
        this.f1705f = -1.0f;
        this.f1706g = -1.0f;
        this.f1704e = -1.0f;
        this.f1707h = new int[0];
        this.f1703d = false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo2147a(int i, float f) {
        Resources resources;
        if (this.f1711l == null) {
            resources = Resources.getSystem();
        } else {
            resources = this.f1711l.getResources();
        }
        m2041a(TypedValue.applyDimension(i, f, resources.getDisplayMetrics()));
    }

    /* renamed from: a */
    private void m2041a(float f) {
        if (f != this.f1710k.getPaint().getTextSize()) {
            this.f1710k.getPaint().setTextSize(f);
            boolean isInLayout = VERSION.SDK_INT >= 18 ? this.f1710k.isInLayout() : false;
            if (this.f1710k.getLayout() != null) {
                this.f1703d = false;
                try {
                    Method a = m2040a("nullLayouts");
                    if (a != null) {
                        a.invoke(this.f1710k, new Object[0]);
                    }
                } catch (Exception e) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e);
                }
                if (!isInLayout) {
                    this.f1710k.requestLayout();
                } else {
                    this.f1710k.forceLayout();
                }
                this.f1710k.invalidate();
            }
        }
    }

    /* renamed from: a */
    private int m2036a(RectF rectF) {
        int length = this.f1707h.length;
        if (length != 0) {
            int i = length - 1;
            int i2 = 1;
            int i3 = 0;
            while (i2 <= i) {
                int i4 = (i2 + i) / 2;
                if (m2044a(this.f1707h[i4], rectF)) {
                    int i5 = i4 + 1;
                    i3 = i2;
                    i2 = i5;
                } else {
                    i3 = i4 - 1;
                    i = i3;
                }
            }
            return this.f1707h[i3];
        }
        throw new IllegalStateException("No available text sizes to choose from.");
    }

    /* renamed from: a */
    private boolean m2044a(int i, RectF rectF) {
        StaticLayout staticLayout;
        CharSequence text = this.f1710k.getText();
        TransformationMethod transformationMethod = this.f1710k.getTransformationMethod();
        if (transformationMethod != null) {
            CharSequence transformation = transformationMethod.getTransformation(text, this.f1710k);
            if (transformation != null) {
                text = transformation;
            }
        }
        int maxLines = VERSION.SDK_INT >= 16 ? this.f1710k.getMaxLines() : -1;
        if (this.f1709j == null) {
            this.f1709j = new TextPaint();
        } else {
            this.f1709j.reset();
        }
        this.f1709j.set(this.f1710k.getPaint());
        this.f1709j.setTextSize((float) i);
        Alignment alignment = (Alignment) m2039a((Object) this.f1710k, "getLayoutAlignment", (T) Alignment.ALIGN_NORMAL);
        if (VERSION.SDK_INT >= 23) {
            staticLayout = m2038a(text, alignment, Math.round(rectF.right), maxLines);
        } else {
            staticLayout = m2037a(text, alignment, Math.round(rectF.right));
        }
        return (maxLines == -1 || (staticLayout.getLineCount() <= maxLines && staticLayout.getLineEnd(staticLayout.getLineCount() - 1) == text.length())) && ((float) staticLayout.getHeight()) <= rectF.bottom;
    }

    /* renamed from: a */
    private StaticLayout m2038a(CharSequence charSequence, Alignment alignment, int i, int i2) {
        TextDirectionHeuristic textDirectionHeuristic = (TextDirectionHeuristic) m2039a((Object) this.f1710k, "getTextDirectionHeuristic", (T) TextDirectionHeuristics.FIRSTSTRONG_LTR);
        Builder hyphenationFrequency = Builder.obtain(charSequence, 0, charSequence.length(), this.f1709j, i).setAlignment(alignment).setLineSpacing(this.f1710k.getLineSpacingExtra(), this.f1710k.getLineSpacingMultiplier()).setIncludePad(this.f1710k.getIncludeFontPadding()).setBreakStrategy(this.f1710k.getBreakStrategy()).setHyphenationFrequency(this.f1710k.getHyphenationFrequency());
        if (i2 == -1) {
            i2 = BaseClientBuilder.API_PRIORITY_OTHER;
        }
        return hyphenationFrequency.setMaxLines(i2).setTextDirection(textDirectionHeuristic).build();
    }

    /* renamed from: a */
    private StaticLayout m2037a(CharSequence charSequence, Alignment alignment, int i) {
        float floatValue;
        float floatValue2;
        boolean booleanValue;
        if (VERSION.SDK_INT >= 16) {
            floatValue = this.f1710k.getLineSpacingMultiplier();
            floatValue2 = this.f1710k.getLineSpacingExtra();
            booleanValue = this.f1710k.getIncludeFontPadding();
        } else {
            floatValue = ((Float) m2039a((Object) this.f1710k, "getLineSpacingMultiplier", (T) Float.valueOf(1.0f))).floatValue();
            floatValue2 = ((Float) m2039a((Object) this.f1710k, "getLineSpacingExtra", (T) Float.valueOf(BitmapDescriptorFactory.HUE_RED))).floatValue();
            booleanValue = ((Boolean) m2039a((Object) this.f1710k, "getIncludeFontPadding", (T) Boolean.valueOf(true))).booleanValue();
        }
        StaticLayout staticLayout = new StaticLayout(charSequence, this.f1709j, i, alignment, floatValue, floatValue2, booleanValue);
        return staticLayout;
    }

    /* renamed from: a */
    private <T> T m2039a(Object obj, String str, T t) {
        try {
            return m2040a(str).invoke(obj, new Object[0]);
        } catch (Exception e) {
            String str2 = "ACTVAutoSizeHelper";
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to invoke TextView#");
            sb.append(str);
            sb.append("() method");
            Log.w(str2, sb.toString(), e);
            return t;
        }
    }

    /* renamed from: a */
    private Method m2040a(String str) {
        try {
            Method method = (Method) f1701b.get(str);
            if (method == null) {
                method = TextView.class.getDeclaredMethod(str, new Class[0]);
                if (method != null) {
                    method.setAccessible(true);
                    f1701b.put(str, method);
                }
            }
            return method;
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to retrieve TextView#");
            sb.append(str);
            sb.append("() method");
            Log.w("ACTVAutoSizeHelper", sb.toString(), e);
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public boolean mo2156g() {
        return m2049k() && this.f1702c != 0;
    }

    /* renamed from: k */
    private boolean m2049k() {
        return !(this.f1710k instanceof C0686l);
    }
}
