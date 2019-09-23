package androidx.vectordrawable.p089a.p090a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import androidx.core.content.p066a.C0890g;
import androidx.core.graphics.drawable.C0983a;
import androidx.p052b.C0712a;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: androidx.vectordrawable.a.a.c */
/* compiled from: AnimatedVectorDrawableCompat */
public class C1438c extends C1447h implements C1437b {

    /* renamed from: a */
    ArrayList<Object> f4258a;

    /* renamed from: b */
    final Callback f4259b;

    /* renamed from: d */
    private C1440a f4260d;

    /* renamed from: e */
    private Context f4261e;

    /* renamed from: f */
    private ArgbEvaluator f4262f;

    /* renamed from: g */
    private AnimatorListener f4263g;

    /* renamed from: androidx.vectordrawable.a.a.c$a */
    /* compiled from: AnimatedVectorDrawableCompat */
    private static class C1440a extends ConstantState {

        /* renamed from: a */
        int f4265a;

        /* renamed from: b */
        C1448i f4266b;

        /* renamed from: c */
        AnimatorSet f4267c;

        /* renamed from: d */
        ArrayList<Animator> f4268d;

        /* renamed from: e */
        C0712a<Animator, String> f4269e;

        public C1440a(Context context, C1440a aVar, Callback callback, Resources resources) {
            if (aVar != null) {
                this.f4265a = aVar.f4265a;
                if (aVar.f4266b != null) {
                    ConstantState constantState = aVar.f4266b.getConstantState();
                    if (resources != null) {
                        this.f4266b = (C1448i) constantState.newDrawable(resources);
                    } else {
                        this.f4266b = (C1448i) constantState.newDrawable();
                    }
                    this.f4266b = (C1448i) this.f4266b.mutate();
                    this.f4266b.setCallback(callback);
                    this.f4266b.setBounds(aVar.f4266b.getBounds());
                    this.f4266b.mo5937a(false);
                }
                if (aVar.f4268d != null) {
                    int size = aVar.f4268d.size();
                    this.f4268d = new ArrayList<>(size);
                    this.f4269e = new C0712a<>(size);
                    for (int i = 0; i < size; i++) {
                        Animator animator = (Animator) aVar.f4268d.get(i);
                        Animator clone = animator.clone();
                        String str = (String) aVar.f4269e.get(animator);
                        clone.setTarget(this.f4266b.mo5936a(str));
                        this.f4268d.add(clone);
                        this.f4269e.put(clone, str);
                    }
                    mo5922a();
                }
            }
        }

        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public int getChangingConfigurations() {
            return this.f4265a;
        }

        /* renamed from: a */
        public void mo5922a() {
            if (this.f4267c == null) {
                this.f4267c = new AnimatorSet();
            }
            this.f4267c.playTogether(this.f4268d);
        }
    }

    /* renamed from: androidx.vectordrawable.a.a.c$b */
    /* compiled from: AnimatedVectorDrawableCompat */
    private static class C1441b extends ConstantState {

        /* renamed from: a */
        private final ConstantState f4270a;

        public C1441b(ConstantState constantState) {
            this.f4270a = constantState;
        }

        public Drawable newDrawable() {
            C1438c cVar = new C1438c();
            cVar.f4275c = this.f4270a.newDrawable();
            cVar.f4275c.setCallback(cVar.f4259b);
            return cVar;
        }

        public Drawable newDrawable(Resources resources) {
            C1438c cVar = new C1438c();
            cVar.f4275c = this.f4270a.newDrawable(resources);
            cVar.f4275c.setCallback(cVar.f4259b);
            return cVar;
        }

        public Drawable newDrawable(Resources resources, Theme theme) {
            C1438c cVar = new C1438c();
            cVar.f4275c = this.f4270a.newDrawable(resources, theme);
            cVar.f4275c.setCallback(cVar.f4259b);
            return cVar;
        }

        public boolean canApplyTheme() {
            return this.f4270a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f4270a.getChangingConfigurations();
        }
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i, Mode mode) {
        super.setColorFilter(i, mode);
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    C1438c() {
        this(null, null, null);
    }

    private C1438c(Context context) {
        this(context, null, null);
    }

    private C1438c(Context context, C1440a aVar, Resources resources) {
        this.f4262f = null;
        this.f4263g = null;
        this.f4258a = null;
        this.f4259b = new Callback() {
            public void invalidateDrawable(Drawable drawable) {
                C1438c.this.invalidateSelf();
            }

            public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
                C1438c.this.scheduleSelf(runnable, j);
            }

            public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                C1438c.this.unscheduleSelf(runnable);
            }
        };
        this.f4261e = context;
        if (aVar != null) {
            this.f4260d = aVar;
        } else {
            this.f4260d = new C1440a(context, aVar, this.f4259b, resources);
        }
    }

    public Drawable mutate() {
        if (this.f4275c != null) {
            this.f4275c.mutate();
        }
        return this;
    }

    /* renamed from: a */
    public static C1438c m5728a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        C1438c cVar = new C1438c(context);
        cVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return cVar;
    }

    public ConstantState getConstantState() {
        if (this.f4275c == null || VERSION.SDK_INT < 24) {
            return null;
        }
        return new C1441b(this.f4275c.getConstantState());
    }

    public int getChangingConfigurations() {
        if (this.f4275c != null) {
            return this.f4275c.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f4260d.f4265a;
    }

    public void draw(Canvas canvas) {
        if (this.f4275c != null) {
            this.f4275c.draw(canvas);
            return;
        }
        this.f4260d.f4266b.draw(canvas);
        if (this.f4260d.f4267c.isStarted()) {
            invalidateSelf();
        }
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        if (this.f4275c != null) {
            this.f4275c.setBounds(rect);
        } else {
            this.f4260d.f4266b.setBounds(rect);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        if (this.f4275c != null) {
            return this.f4275c.setState(iArr);
        }
        return this.f4260d.f4266b.setState(iArr);
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i) {
        if (this.f4275c != null) {
            return this.f4275c.setLevel(i);
        }
        return this.f4260d.f4266b.setLevel(i);
    }

    public int getAlpha() {
        if (this.f4275c != null) {
            return C0983a.m3705c(this.f4275c);
        }
        return this.f4260d.f4266b.getAlpha();
    }

    public void setAlpha(int i) {
        if (this.f4275c != null) {
            this.f4275c.setAlpha(i);
        } else {
            this.f4260d.f4266b.setAlpha(i);
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f4275c != null) {
            this.f4275c.setColorFilter(colorFilter);
        } else {
            this.f4260d.f4266b.setColorFilter(colorFilter);
        }
    }

    public void setTint(int i) {
        if (this.f4275c != null) {
            C0983a.m3696a(this.f4275c, i);
        } else {
            this.f4260d.f4266b.setTint(i);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.f4275c != null) {
            C0983a.m3698a(this.f4275c, colorStateList);
        } else {
            this.f4260d.f4266b.setTintList(colorStateList);
        }
    }

    public void setTintMode(Mode mode) {
        if (this.f4275c != null) {
            C0983a.m3701a(this.f4275c, mode);
        } else {
            this.f4260d.f4266b.setTintMode(mode);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        if (this.f4275c != null) {
            return this.f4275c.setVisible(z, z2);
        }
        this.f4260d.f4266b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    public boolean isStateful() {
        if (this.f4275c != null) {
            return this.f4275c.isStateful();
        }
        return this.f4260d.f4266b.isStateful();
    }

    public int getOpacity() {
        if (this.f4275c != null) {
            return this.f4275c.getOpacity();
        }
        return this.f4260d.f4266b.getOpacity();
    }

    public int getIntrinsicWidth() {
        if (this.f4275c != null) {
            return this.f4275c.getIntrinsicWidth();
        }
        return this.f4260d.f4266b.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        if (this.f4275c != null) {
            return this.f4275c.getIntrinsicHeight();
        }
        return this.f4260d.f4266b.getIntrinsicHeight();
    }

    public boolean isAutoMirrored() {
        if (this.f4275c != null) {
            return C0983a.m3703b(this.f4275c);
        }
        return this.f4260d.f4266b.isAutoMirrored();
    }

    public void setAutoMirrored(boolean z) {
        if (this.f4275c != null) {
            C0983a.m3702a(this.f4275c, z);
        } else {
            this.f4260d.f4266b.setAutoMirrored(z);
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        if (this.f4275c != null) {
            C0983a.m3700a(this.f4275c, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray a = C0890g.m3300a(resources, theme, attributeSet, C1436a.f4250e);
                    int resourceId = a.getResourceId(0, 0);
                    if (resourceId != 0) {
                        C1448i a2 = C1448i.m5761a(resources, resourceId, theme);
                        a2.mo5937a(false);
                        a2.setCallback(this.f4259b);
                        if (this.f4260d.f4266b != null) {
                            this.f4260d.f4266b.setCallback(null);
                        }
                        this.f4260d.f4266b = a2;
                    }
                    a.recycle();
                } else if ("target".equals(name)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, C1436a.f4251f);
                    String string = obtainAttributes.getString(0);
                    int resourceId2 = obtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        if (this.f4261e != null) {
                            m5730a(string, C1443e.m5736a(this.f4261e, resourceId2));
                        } else {
                            obtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    obtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        this.f4260d.mo5922a();
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    public void applyTheme(Theme theme) {
        if (this.f4275c != null) {
            C0983a.m3699a(this.f4275c, theme);
        }
    }

    public boolean canApplyTheme() {
        if (this.f4275c != null) {
            return C0983a.m3706d(this.f4275c);
        }
        return false;
    }

    /* renamed from: a */
    private void m5729a(Animator animator) {
        if (animator instanceof AnimatorSet) {
            ArrayList childAnimations = ((AnimatorSet) animator).getChildAnimations();
            if (childAnimations != null) {
                for (int i = 0; i < childAnimations.size(); i++) {
                    m5729a((Animator) childAnimations.get(i));
                }
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.f4262f == null) {
                    this.f4262f = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.f4262f);
            }
        }
    }

    /* renamed from: a */
    private void m5730a(String str, Animator animator) {
        animator.setTarget(this.f4260d.f4266b.mo5936a(str));
        if (VERSION.SDK_INT < 21) {
            m5729a(animator);
        }
        if (this.f4260d.f4268d == null) {
            this.f4260d.f4268d = new ArrayList<>();
            this.f4260d.f4269e = new C0712a<>();
        }
        this.f4260d.f4268d.add(animator);
        this.f4260d.f4269e.put(animator, str);
    }

    public boolean isRunning() {
        if (this.f4275c != null) {
            return ((AnimatedVectorDrawable) this.f4275c).isRunning();
        }
        return this.f4260d.f4267c.isRunning();
    }

    public void start() {
        if (this.f4275c != null) {
            ((AnimatedVectorDrawable) this.f4275c).start();
        } else if (!this.f4260d.f4267c.isStarted()) {
            this.f4260d.f4267c.start();
            invalidateSelf();
        }
    }

    public void stop() {
        if (this.f4275c != null) {
            ((AnimatedVectorDrawable) this.f4275c).stop();
        } else {
            this.f4260d.f4267c.end();
        }
    }
}
