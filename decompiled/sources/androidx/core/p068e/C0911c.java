package androidx.core.p068e;

import android.os.Build.VERSION;
import android.text.PrecomputedText.Params;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import androidx.core.p069f.C0925c;
import java.util.concurrent.Executor;

/* renamed from: androidx.core.e.c */
/* compiled from: PrecomputedTextCompat */
public class C0911c implements Spannable {

    /* renamed from: a */
    private static final Object f2919a = new Object();

    /* renamed from: b */
    private static Executor f2920b = null;

    /* renamed from: c */
    private final Spannable f2921c;

    /* renamed from: d */
    private final C0912a f2922d;

    /* renamed from: androidx.core.e.c$a */
    /* compiled from: PrecomputedTextCompat */
    public static final class C0912a {

        /* renamed from: a */
        final Params f2923a = null;

        /* renamed from: b */
        private final TextPaint f2924b;

        /* renamed from: c */
        private final TextDirectionHeuristic f2925c;

        /* renamed from: d */
        private final int f2926d;

        /* renamed from: e */
        private final int f2927e;

        /* renamed from: androidx.core.e.c$a$a */
        /* compiled from: PrecomputedTextCompat */
        public static class C0913a {

            /* renamed from: a */
            private final TextPaint f2928a;

            /* renamed from: b */
            private TextDirectionHeuristic f2929b;

            /* renamed from: c */
            private int f2930c;

            /* renamed from: d */
            private int f2931d;

            public C0913a(TextPaint textPaint) {
                this.f2928a = textPaint;
                if (VERSION.SDK_INT >= 23) {
                    this.f2930c = 1;
                    this.f2931d = 1;
                } else {
                    this.f2931d = 0;
                    this.f2930c = 0;
                }
                if (VERSION.SDK_INT >= 18) {
                    this.f2929b = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                } else {
                    this.f2929b = null;
                }
            }

            /* renamed from: a */
            public C0913a mo3637a(int i) {
                this.f2930c = i;
                return this;
            }

            /* renamed from: b */
            public C0913a mo3640b(int i) {
                this.f2931d = i;
                return this;
            }

            /* renamed from: a */
            public C0913a mo3638a(TextDirectionHeuristic textDirectionHeuristic) {
                this.f2929b = textDirectionHeuristic;
                return this;
            }

            /* renamed from: a */
            public C0912a mo3639a() {
                return new C0912a(this.f2928a, this.f2929b, this.f2930c, this.f2931d);
            }
        }

        C0912a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i, int i2) {
            this.f2924b = textPaint;
            this.f2925c = textDirectionHeuristic;
            this.f2926d = i;
            this.f2927e = i2;
        }

        public C0912a(Params params) {
            this.f2924b = params.getTextPaint();
            this.f2925c = params.getTextDirection();
            this.f2926d = params.getBreakStrategy();
            this.f2927e = params.getHyphenationFrequency();
        }

        /* renamed from: a */
        public TextPaint mo3629a() {
            return this.f2924b;
        }

        /* renamed from: b */
        public TextDirectionHeuristic mo3631b() {
            return this.f2925c;
        }

        /* renamed from: c */
        public int mo3632c() {
            return this.f2926d;
        }

        /* renamed from: d */
        public int mo3633d() {
            return this.f2927e;
        }

        /* renamed from: a */
        public boolean mo3630a(C0912a aVar) {
            if (this.f2923a != null) {
                return this.f2923a.equals(aVar.f2923a);
            }
            if ((VERSION.SDK_INT >= 23 && (this.f2926d != aVar.mo3632c() || this.f2927e != aVar.mo3633d())) || this.f2924b.getTextSize() != aVar.mo3629a().getTextSize() || this.f2924b.getTextScaleX() != aVar.mo3629a().getTextScaleX() || this.f2924b.getTextSkewX() != aVar.mo3629a().getTextSkewX()) {
                return false;
            }
            if ((VERSION.SDK_INT >= 21 && (this.f2924b.getLetterSpacing() != aVar.mo3629a().getLetterSpacing() || !TextUtils.equals(this.f2924b.getFontFeatureSettings(), aVar.mo3629a().getFontFeatureSettings()))) || this.f2924b.getFlags() != aVar.mo3629a().getFlags()) {
                return false;
            }
            if (VERSION.SDK_INT >= 24) {
                if (!this.f2924b.getTextLocales().equals(aVar.mo3629a().getTextLocales())) {
                    return false;
                }
            } else if (VERSION.SDK_INT >= 17 && !this.f2924b.getTextLocale().equals(aVar.mo3629a().getTextLocale())) {
                return false;
            }
            if (this.f2924b.getTypeface() == null) {
                if (aVar.mo3629a().getTypeface() != null) {
                    return false;
                }
            } else if (!this.f2924b.getTypeface().equals(aVar.mo3629a().getTypeface())) {
                return false;
            }
            return true;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C0912a)) {
                return false;
            }
            C0912a aVar = (C0912a) obj;
            if (!mo3630a(aVar)) {
                return false;
            }
            return VERSION.SDK_INT < 18 || this.f2925c == aVar.mo3631b();
        }

        public int hashCode() {
            if (VERSION.SDK_INT >= 24) {
                return C0925c.m3393a(Float.valueOf(this.f2924b.getTextSize()), Float.valueOf(this.f2924b.getTextScaleX()), Float.valueOf(this.f2924b.getTextSkewX()), Float.valueOf(this.f2924b.getLetterSpacing()), Integer.valueOf(this.f2924b.getFlags()), this.f2924b.getTextLocales(), this.f2924b.getTypeface(), Boolean.valueOf(this.f2924b.isElegantTextHeight()), this.f2925c, Integer.valueOf(this.f2926d), Integer.valueOf(this.f2927e));
            } else if (VERSION.SDK_INT >= 21) {
                return C0925c.m3393a(Float.valueOf(this.f2924b.getTextSize()), Float.valueOf(this.f2924b.getTextScaleX()), Float.valueOf(this.f2924b.getTextSkewX()), Float.valueOf(this.f2924b.getLetterSpacing()), Integer.valueOf(this.f2924b.getFlags()), this.f2924b.getTextLocale(), this.f2924b.getTypeface(), Boolean.valueOf(this.f2924b.isElegantTextHeight()), this.f2925c, Integer.valueOf(this.f2926d), Integer.valueOf(this.f2927e));
            } else if (VERSION.SDK_INT >= 18) {
                return C0925c.m3393a(Float.valueOf(this.f2924b.getTextSize()), Float.valueOf(this.f2924b.getTextScaleX()), Float.valueOf(this.f2924b.getTextSkewX()), Integer.valueOf(this.f2924b.getFlags()), this.f2924b.getTextLocale(), this.f2924b.getTypeface(), this.f2925c, Integer.valueOf(this.f2926d), Integer.valueOf(this.f2927e));
            } else if (VERSION.SDK_INT >= 17) {
                return C0925c.m3393a(Float.valueOf(this.f2924b.getTextSize()), Float.valueOf(this.f2924b.getTextScaleX()), Float.valueOf(this.f2924b.getTextSkewX()), Integer.valueOf(this.f2924b.getFlags()), this.f2924b.getTextLocale(), this.f2924b.getTypeface(), this.f2925c, Integer.valueOf(this.f2926d), Integer.valueOf(this.f2927e));
            } else {
                return C0925c.m3393a(Float.valueOf(this.f2924b.getTextSize()), Float.valueOf(this.f2924b.getTextScaleX()), Float.valueOf(this.f2924b.getTextSkewX()), Integer.valueOf(this.f2924b.getFlags()), this.f2924b.getTypeface(), this.f2925c, Integer.valueOf(this.f2926d), Integer.valueOf(this.f2927e));
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("textSize=");
            sb2.append(this.f2924b.getTextSize());
            sb.append(sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append(", textScaleX=");
            sb3.append(this.f2924b.getTextScaleX());
            sb.append(sb3.toString());
            StringBuilder sb4 = new StringBuilder();
            sb4.append(", textSkewX=");
            sb4.append(this.f2924b.getTextSkewX());
            sb.append(sb4.toString());
            if (VERSION.SDK_INT >= 21) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(", letterSpacing=");
                sb5.append(this.f2924b.getLetterSpacing());
                sb.append(sb5.toString());
                StringBuilder sb6 = new StringBuilder();
                sb6.append(", elegantTextHeight=");
                sb6.append(this.f2924b.isElegantTextHeight());
                sb.append(sb6.toString());
            }
            if (VERSION.SDK_INT >= 24) {
                StringBuilder sb7 = new StringBuilder();
                sb7.append(", textLocale=");
                sb7.append(this.f2924b.getTextLocales());
                sb.append(sb7.toString());
            } else if (VERSION.SDK_INT >= 17) {
                StringBuilder sb8 = new StringBuilder();
                sb8.append(", textLocale=");
                sb8.append(this.f2924b.getTextLocale());
                sb.append(sb8.toString());
            }
            StringBuilder sb9 = new StringBuilder();
            sb9.append(", typeface=");
            sb9.append(this.f2924b.getTypeface());
            sb.append(sb9.toString());
            if (VERSION.SDK_INT >= 26) {
                StringBuilder sb10 = new StringBuilder();
                sb10.append(", variationSettings=");
                sb10.append(this.f2924b.getFontVariationSettings());
                sb.append(sb10.toString());
            }
            StringBuilder sb11 = new StringBuilder();
            sb11.append(", textDir=");
            sb11.append(this.f2925c);
            sb.append(sb11.toString());
            StringBuilder sb12 = new StringBuilder();
            sb12.append(", breakStrategy=");
            sb12.append(this.f2926d);
            sb.append(sb12.toString());
            StringBuilder sb13 = new StringBuilder();
            sb13.append(", hyphenationFrequency=");
            sb13.append(this.f2927e);
            sb.append(sb13.toString());
            sb.append("}");
            return sb.toString();
        }
    }

    /* renamed from: a */
    public C0912a mo3617a() {
        return this.f2922d;
    }

    public void setSpan(Object obj, int i, int i2, int i3) {
        if (!(obj instanceof MetricAffectingSpan)) {
            this.f2921c.setSpan(obj, i, i2, i3);
            return;
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
    }

    public void removeSpan(Object obj) {
        if (!(obj instanceof MetricAffectingSpan)) {
            this.f2921c.removeSpan(obj);
            return;
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
    }

    public <T> T[] getSpans(int i, int i2, Class<T> cls) {
        return this.f2921c.getSpans(i, i2, cls);
    }

    public int getSpanStart(Object obj) {
        return this.f2921c.getSpanStart(obj);
    }

    public int getSpanEnd(Object obj) {
        return this.f2921c.getSpanEnd(obj);
    }

    public int getSpanFlags(Object obj) {
        return this.f2921c.getSpanFlags(obj);
    }

    public int nextSpanTransition(int i, int i2, Class cls) {
        return this.f2921c.nextSpanTransition(i, i2, cls);
    }

    public int length() {
        return this.f2921c.length();
    }

    public char charAt(int i) {
        return this.f2921c.charAt(i);
    }

    public CharSequence subSequence(int i, int i2) {
        return this.f2921c.subSequence(i, i2);
    }

    public String toString() {
        return this.f2921c.toString();
    }
}
