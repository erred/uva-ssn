package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import androidx.constraintlayout.widget.ConstraintLayout.C0795a;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: androidx.constraintlayout.widget.f */
/* compiled from: Constraints */
public class C0811f extends ViewGroup {

    /* renamed from: a */
    C0809e f2670a;

    /* renamed from: androidx.constraintlayout.widget.f$a */
    /* compiled from: Constraints */
    public static class C0812a extends C0795a {

        /* renamed from: aA */
        public float f2671aA;

        /* renamed from: ao */
        public float f2672ao;

        /* renamed from: ap */
        public boolean f2673ap;

        /* renamed from: aq */
        public float f2674aq;

        /* renamed from: ar */
        public float f2675ar;

        /* renamed from: as */
        public float f2676as;

        /* renamed from: at */
        public float f2677at;

        /* renamed from: au */
        public float f2678au;

        /* renamed from: av */
        public float f2679av;

        /* renamed from: aw */
        public float f2680aw;

        /* renamed from: ax */
        public float f2681ax;

        /* renamed from: ay */
        public float f2682ay;

        /* renamed from: az */
        public float f2683az;

        public C0812a(int i, int i2) {
            super(i, i2);
            this.f2672ao = 1.0f;
            this.f2673ap = false;
            this.f2674aq = BitmapDescriptorFactory.HUE_RED;
            this.f2675ar = BitmapDescriptorFactory.HUE_RED;
            this.f2676as = BitmapDescriptorFactory.HUE_RED;
            this.f2677at = BitmapDescriptorFactory.HUE_RED;
            this.f2678au = 1.0f;
            this.f2679av = 1.0f;
            this.f2680aw = BitmapDescriptorFactory.HUE_RED;
            this.f2681ax = BitmapDescriptorFactory.HUE_RED;
            this.f2682ay = BitmapDescriptorFactory.HUE_RED;
            this.f2683az = BitmapDescriptorFactory.HUE_RED;
            this.f2671aA = BitmapDescriptorFactory.HUE_RED;
        }

        public C0812a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2672ao = 1.0f;
            this.f2673ap = false;
            this.f2674aq = BitmapDescriptorFactory.HUE_RED;
            this.f2675ar = BitmapDescriptorFactory.HUE_RED;
            this.f2676as = BitmapDescriptorFactory.HUE_RED;
            this.f2677at = BitmapDescriptorFactory.HUE_RED;
            this.f2678au = 1.0f;
            this.f2679av = 1.0f;
            this.f2680aw = BitmapDescriptorFactory.HUE_RED;
            this.f2681ax = BitmapDescriptorFactory.HUE_RED;
            this.f2682ay = BitmapDescriptorFactory.HUE_RED;
            this.f2683az = BitmapDescriptorFactory.HUE_RED;
            this.f2671aA = BitmapDescriptorFactory.HUE_RED;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ConstraintSet);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.ConstraintSet_android_alpha) {
                    this.f2672ao = obtainStyledAttributes.getFloat(index, this.f2672ao);
                } else if (index == R.styleable.ConstraintSet_android_elevation) {
                    this.f2674aq = obtainStyledAttributes.getFloat(index, this.f2674aq);
                    this.f2673ap = true;
                } else if (index == R.styleable.ConstraintSet_android_rotationX) {
                    this.f2676as = obtainStyledAttributes.getFloat(index, this.f2676as);
                } else if (index == R.styleable.ConstraintSet_android_rotationY) {
                    this.f2677at = obtainStyledAttributes.getFloat(index, this.f2677at);
                } else if (index == R.styleable.ConstraintSet_android_rotation) {
                    this.f2675ar = obtainStyledAttributes.getFloat(index, this.f2675ar);
                } else if (index == R.styleable.ConstraintSet_android_scaleX) {
                    this.f2678au = obtainStyledAttributes.getFloat(index, this.f2678au);
                } else if (index == R.styleable.ConstraintSet_android_scaleY) {
                    this.f2679av = obtainStyledAttributes.getFloat(index, this.f2679av);
                } else if (index == R.styleable.ConstraintSet_android_transformPivotX) {
                    this.f2680aw = obtainStyledAttributes.getFloat(index, this.f2680aw);
                } else if (index == R.styleable.ConstraintSet_android_transformPivotY) {
                    this.f2681ax = obtainStyledAttributes.getFloat(index, this.f2681ax);
                } else if (index == R.styleable.ConstraintSet_android_translationX) {
                    this.f2682ay = obtainStyledAttributes.getFloat(index, this.f2682ay);
                } else if (index == R.styleable.ConstraintSet_android_translationY) {
                    this.f2683az = obtainStyledAttributes.getFloat(index, this.f2683az);
                } else if (index == R.styleable.ConstraintSet_android_translationZ) {
                    this.f2682ay = obtainStyledAttributes.getFloat(index, this.f2671aA);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    /* renamed from: a */
    public C0812a generateLayoutParams(AttributeSet attributeSet) {
        return new C0812a(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0812a generateDefaultLayoutParams() {
        return new C0812a(-2, -2);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return new C0795a(layoutParams);
    }

    public C0809e getConstraintSet() {
        if (this.f2670a == null) {
            this.f2670a = new C0809e();
        }
        this.f2670a.mo3294a(this);
        return this.f2670a;
    }
}
