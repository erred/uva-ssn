package androidx.fragment.p081a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import androidx.core.p069f.C0923a;
import androidx.core.p069f.C0924b;
import androidx.core.p070g.C0962r;
import androidx.fragment.p081a.C1078i.C1079a;
import androidx.fragment.p081a.C1078i.C1080b;
import androidx.lifecycle.C1191r;
import androidx.p052b.C0714b;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: androidx.fragment.a.j */
/* compiled from: FragmentManager */
final class C1081j extends C1078i implements Factory2 {

    /* renamed from: F */
    static final Interpolator f3351F = new DecelerateInterpolator(2.5f);

    /* renamed from: G */
    static final Interpolator f3352G = new DecelerateInterpolator(1.5f);

    /* renamed from: H */
    static final Interpolator f3353H = new AccelerateInterpolator(2.5f);

    /* renamed from: I */
    static final Interpolator f3354I = new AccelerateInterpolator(1.5f);

    /* renamed from: a */
    static boolean f3355a = false;

    /* renamed from: q */
    static Field f3356q;

    /* renamed from: A */
    Bundle f3357A = null;

    /* renamed from: B */
    SparseArray<Parcelable> f3358B = null;

    /* renamed from: C */
    ArrayList<C1097j> f3359C;

    /* renamed from: D */
    C1098k f3360D;

    /* renamed from: E */
    Runnable f3361E = new Runnable() {
        public void run() {
            C1081j.this.mo4445i();
        }
    };

    /* renamed from: J */
    private final CopyOnWriteArrayList<C1093f> f3362J = new CopyOnWriteArrayList<>();

    /* renamed from: b */
    ArrayList<C1095h> f3363b;

    /* renamed from: c */
    boolean f3364c;

    /* renamed from: d */
    int f3365d = 0;

    /* renamed from: e */
    final ArrayList<C1062d> f3366e = new ArrayList<>();

    /* renamed from: f */
    SparseArray<C1062d> f3367f;

    /* renamed from: g */
    ArrayList<C1057a> f3368g;

    /* renamed from: h */
    ArrayList<C1062d> f3369h;

    /* renamed from: i */
    ArrayList<C1057a> f3370i;

    /* renamed from: j */
    ArrayList<Integer> f3371j;

    /* renamed from: k */
    ArrayList<C1080b> f3372k;

    /* renamed from: l */
    int f3373l = 0;

    /* renamed from: m */
    C1077h f3374m;

    /* renamed from: n */
    C1075f f3375n;

    /* renamed from: o */
    C1062d f3376o;

    /* renamed from: p */
    C1062d f3377p;

    /* renamed from: r */
    boolean f3378r;

    /* renamed from: s */
    boolean f3379s;

    /* renamed from: t */
    boolean f3380t;

    /* renamed from: u */
    boolean f3381u;

    /* renamed from: v */
    String f3382v;

    /* renamed from: w */
    boolean f3383w;

    /* renamed from: x */
    ArrayList<C1057a> f3384x;

    /* renamed from: y */
    ArrayList<Boolean> f3385y;

    /* renamed from: z */
    ArrayList<C1062d> f3386z;

    /* renamed from: androidx.fragment.a.j$a */
    /* compiled from: FragmentManager */
    private static class C1087a extends C1089b {

        /* renamed from: a */
        View f3400a;

        C1087a(View view, AnimationListener animationListener) {
            super(animationListener);
            this.f3400a = view;
        }

        public void onAnimationEnd(Animation animation) {
            if (C0962r.m3543C(this.f3400a) || VERSION.SDK_INT >= 24) {
                this.f3400a.post(new Runnable() {
                    public void run() {
                        C1087a.this.f3400a.setLayerType(0, null);
                    }
                });
            } else {
                this.f3400a.setLayerType(0, null);
            }
            super.onAnimationEnd(animation);
        }
    }

    /* renamed from: androidx.fragment.a.j$b */
    /* compiled from: FragmentManager */
    private static class C1089b implements AnimationListener {

        /* renamed from: a */
        private final AnimationListener f3402a;

        C1089b(AnimationListener animationListener) {
            this.f3402a = animationListener;
        }

        public void onAnimationStart(Animation animation) {
            if (this.f3402a != null) {
                this.f3402a.onAnimationStart(animation);
            }
        }

        public void onAnimationEnd(Animation animation) {
            if (this.f3402a != null) {
                this.f3402a.onAnimationEnd(animation);
            }
        }

        public void onAnimationRepeat(Animation animation) {
            if (this.f3402a != null) {
                this.f3402a.onAnimationRepeat(animation);
            }
        }
    }

    /* renamed from: androidx.fragment.a.j$c */
    /* compiled from: FragmentManager */
    private static class C1090c {

        /* renamed from: a */
        public final Animation f3403a;

        /* renamed from: b */
        public final Animator f3404b;

        C1090c(Animation animation) {
            this.f3403a = animation;
            this.f3404b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        C1090c(Animator animator) {
            this.f3403a = null;
            this.f3404b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    /* renamed from: androidx.fragment.a.j$d */
    /* compiled from: FragmentManager */
    private static class C1091d extends AnimatorListenerAdapter {

        /* renamed from: a */
        View f3405a;

        C1091d(View view) {
            this.f3405a = view;
        }

        public void onAnimationStart(Animator animator) {
            this.f3405a.setLayerType(2, null);
        }

        public void onAnimationEnd(Animator animator) {
            this.f3405a.setLayerType(0, null);
            animator.removeListener(this);
        }
    }

    /* renamed from: androidx.fragment.a.j$e */
    /* compiled from: FragmentManager */
    private static class C1092e extends AnimationSet implements Runnable {

        /* renamed from: a */
        private final ViewGroup f3406a;

        /* renamed from: b */
        private final View f3407b;

        /* renamed from: c */
        private boolean f3408c;

        /* renamed from: d */
        private boolean f3409d;

        /* renamed from: e */
        private boolean f3410e = true;

        C1092e(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f3406a = viewGroup;
            this.f3407b = view;
            addAnimation(animation);
            this.f3406a.post(this);
        }

        public boolean getTransformation(long j, Transformation transformation) {
            this.f3410e = true;
            if (this.f3408c) {
                return !this.f3409d;
            }
            if (!super.getTransformation(j, transformation)) {
                this.f3408c = true;
                C1120s.m4356a(this.f3406a, this);
            }
            return true;
        }

        public boolean getTransformation(long j, Transformation transformation, float f) {
            this.f3410e = true;
            if (this.f3408c) {
                return !this.f3409d;
            }
            if (!super.getTransformation(j, transformation, f)) {
                this.f3408c = true;
                C1120s.m4356a(this.f3406a, this);
            }
            return true;
        }

        public void run() {
            if (this.f3408c || !this.f3410e) {
                this.f3406a.endViewTransition(this.f3407b);
                this.f3409d = true;
                return;
            }
            this.f3410e = false;
            this.f3406a.post(this);
        }
    }

    /* renamed from: androidx.fragment.a.j$f */
    /* compiled from: FragmentManager */
    private static final class C1093f {

        /* renamed from: a */
        final C1079a f3411a;

        /* renamed from: b */
        final boolean f3412b;
    }

    /* renamed from: androidx.fragment.a.j$g */
    /* compiled from: FragmentManager */
    static class C1094g {

        /* renamed from: a */
        public static final int[] f3413a = {16842755, 16842960, 16842961};
    }

    /* renamed from: androidx.fragment.a.j$h */
    /* compiled from: FragmentManager */
    interface C1095h {
        /* renamed from: a */
        boolean mo4077a(ArrayList<C1057a> arrayList, ArrayList<Boolean> arrayList2);
    }

    /* renamed from: androidx.fragment.a.j$i */
    /* compiled from: FragmentManager */
    private class C1096i implements C1095h {

        /* renamed from: a */
        final String f3414a;

        /* renamed from: b */
        final int f3415b;

        /* renamed from: c */
        final int f3416c;

        C1096i(String str, int i, int i2) {
            this.f3414a = str;
            this.f3415b = i;
            this.f3416c = i2;
        }

        /* renamed from: a */
        public boolean mo4077a(ArrayList<C1057a> arrayList, ArrayList<Boolean> arrayList2) {
            if (C1081j.this.f3377p != null && this.f3415b < 0 && this.f3414a == null) {
                C1078i peekChildFragmentManager = C1081j.this.f3377p.peekChildFragmentManager();
                if (peekChildFragmentManager != null && peekChildFragmentManager.mo4374c()) {
                    return false;
                }
            }
            return C1081j.this.mo4415a(arrayList, arrayList2, this.f3414a, this.f3415b, this.f3416c);
        }
    }

    /* renamed from: androidx.fragment.a.j$j */
    /* compiled from: FragmentManager */
    static class C1097j implements C1068c {

        /* renamed from: a */
        final boolean f3418a;

        /* renamed from: b */
        final C1057a f3419b;

        /* renamed from: c */
        private int f3420c;

        C1097j(C1057a aVar, boolean z) {
            this.f3418a = z;
            this.f3419b = aVar;
        }

        /* renamed from: a */
        public void mo4280a() {
            this.f3420c--;
            if (this.f3420c == 0) {
                this.f3419b.f3278a.mo4441h();
            }
        }

        /* renamed from: b */
        public void mo4281b() {
            this.f3420c++;
        }

        /* renamed from: c */
        public boolean mo4485c() {
            return this.f3420c == 0;
        }

        /* renamed from: d */
        public void mo4486d() {
            boolean z = this.f3420c > 0;
            C1081j jVar = this.f3419b.f3278a;
            int size = jVar.f3366e.size();
            for (int i = 0; i < size; i++) {
                C1062d dVar = (C1062d) jVar.f3366e.get(i);
                dVar.setOnStartEnterTransitionListener(null);
                if (z && dVar.isPostponed()) {
                    dVar.startPostponedEnterTransition();
                }
            }
            this.f3419b.f3278a.mo4401a(this.f3419b, this.f3418a, !z, true);
        }

        /* renamed from: e */
        public void mo4487e() {
            this.f3419b.f3278a.mo4401a(this.f3419b, this.f3418a, false, false);
        }
    }

    /* renamed from: b */
    public static int m4148b(int i, boolean z) {
        if (i == 4097) {
            return z ? 1 : 2;
        }
        if (i == 4099) {
            return z ? 5 : 6;
        }
        if (i != 8194) {
            return -1;
        }
        return z ? 3 : 4;
    }

    /* renamed from: d */
    public static int m4155d(int i) {
        if (i == 4097) {
            return 8194;
        }
        if (i != 4099) {
            return i != 8194 ? 0 : 4097;
        }
        return 4099;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: z */
    public Factory2 mo4471z() {
        return this;
    }

    C1081j() {
    }

    /* renamed from: a */
    static boolean m4146a(C1090c cVar) {
        if (cVar.f3403a instanceof AlphaAnimation) {
            return true;
        }
        if (!(cVar.f3403a instanceof AnimationSet)) {
            return m4144a(cVar.f3404b);
        }
        List animations = ((AnimationSet) cVar.f3403a).getAnimations();
        for (int i = 0; i < animations.size(); i++) {
            if (animations.get(i) instanceof AlphaAnimation) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    static boolean m4144a(Animator animator) {
        if (animator == null) {
            return false;
        }
        if (animator instanceof ValueAnimator) {
            PropertyValuesHolder[] values = ((ValueAnimator) animator).getValues();
            for (PropertyValuesHolder propertyName : values) {
                if ("alpha".equals(propertyName.getPropertyName())) {
                    return true;
                }
            }
        } else if (animator instanceof AnimatorSet) {
            ArrayList childAnimations = ((AnimatorSet) animator).getChildAnimations();
            for (int i = 0; i < childAnimations.size(); i++) {
                if (m4144a((Animator) childAnimations.get(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    static boolean m4145a(View view, C1090c cVar) {
        boolean z = false;
        if (view == null || cVar == null) {
            return false;
        }
        if (VERSION.SDK_INT >= 19 && view.getLayerType() == 0 && C0962r.m3597t(view) && m4146a(cVar)) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    private void m4141a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new C0924b("FragmentManager"));
        if (this.f3374m != null) {
            try {
                this.f3374m.mo4330a("  ", (FileDescriptor) null, printWriter, new String[0]);
            } catch (Exception e) {
                Log.e("FragmentManager", "Failed dumping state", e);
            }
        } else {
            try {
                mo4372a("  ", (FileDescriptor) null, printWriter, new String[0]);
            } catch (Exception e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        }
        throw runtimeException;
    }

    /* renamed from: a */
    public C1104o mo4370a() {
        return new C1057a(this);
    }

    /* renamed from: b */
    public void mo4373b() {
        mo4409a((C1095h) new C1096i(null, -1, 0), false);
    }

    /* renamed from: c */
    public boolean mo4374c() {
        m4129A();
        return m4147a((String) null, -1, 0);
    }

    /* renamed from: a */
    public void mo4371a(int i, int i2) {
        if (i >= 0) {
            mo4409a((C1095h) new C1096i(null, i, i2), false);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Bad id: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: a */
    private boolean m4147a(String str, int i, int i2) {
        mo4445i();
        m4153c(true);
        if (this.f3377p != null && i < 0 && str == null) {
            C1078i peekChildFragmentManager = this.f3377p.peekChildFragmentManager();
            if (peekChildFragmentManager != null && peekChildFragmentManager.mo4374c()) {
                return true;
            }
        }
        boolean a = mo4415a(this.f3384x, this.f3385y, str, i, i2);
        if (a) {
            this.f3364c = true;
            try {
                m4151b(this.f3384x, this.f3385y);
            } finally {
                m4130B();
            }
        }
        mo4446j();
        m4133E();
        return a;
    }

    /* renamed from: d */
    public int mo4375d() {
        if (this.f3368g != null) {
            return this.f3368g.size();
        }
        return 0;
    }

    /* renamed from: a */
    public void mo4399a(Bundle bundle, String str, C1062d dVar) {
        if (dVar.mIndex < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Fragment ");
            sb.append(dVar);
            sb.append(" is not currently in the FragmentManager");
            m4141a((RuntimeException) new IllegalStateException(sb.toString()));
        }
        bundle.putInt(str, dVar.mIndex);
    }

    /* renamed from: a */
    public C1062d mo4394a(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        C1062d dVar = (C1062d) this.f3367f.get(i);
        if (dVar == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Fragment no longer exists for key ");
            sb.append(str);
            sb.append(": index ");
            sb.append(i);
            m4141a((RuntimeException) new IllegalStateException(sb.toString()));
        }
        return dVar;
    }

    /* renamed from: e */
    public List<C1062d> mo4376e() {
        List<C1062d> list;
        if (this.f3366e.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f3366e) {
            list = (List) this.f3366e.clone();
        }
        return list;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        if (this.f3376o != null) {
            C0923a.m3391a(this.f3376o, sb);
        } else {
            C0923a.m3391a(this.f3374m, sb);
        }
        sb.append("}}");
        return sb.toString();
    }

    /* renamed from: a */
    public void mo4372a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("    ");
        String sb2 = sb.toString();
        if (this.f3367f != null) {
            int size = this.f3367f.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.print("Active Fragments in ");
                printWriter.print(Integer.toHexString(System.identityHashCode(this)));
                printWriter.println(":");
                for (int i = 0; i < size; i++) {
                    C1062d dVar = (C1062d) this.f3367f.valueAt(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(dVar);
                    if (dVar != null) {
                        dVar.dump(sb2, fileDescriptor, printWriter, strArr);
                    }
                }
            }
        }
        int size2 = this.f3366e.size();
        if (size2 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i2 = 0; i2 < size2; i2++) {
                C1062d dVar2 = (C1062d) this.f3366e.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(dVar2.toString());
            }
        }
        if (this.f3369h != null) {
            int size3 = this.f3369h.size();
            if (size3 > 0) {
                printWriter.print(str);
                printWriter.println("Fragments Created Menus:");
                for (int i3 = 0; i3 < size3; i3++) {
                    C1062d dVar3 = (C1062d) this.f3369h.get(i3);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i3);
                    printWriter.print(": ");
                    printWriter.println(dVar3.toString());
                }
            }
        }
        if (this.f3368g != null) {
            int size4 = this.f3368g.size();
            if (size4 > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack:");
                for (int i4 = 0; i4 < size4; i4++) {
                    C1057a aVar = (C1057a) this.f3368g.get(i4);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i4);
                    printWriter.print(": ");
                    printWriter.println(aVar.toString());
                    aVar.mo4074a(sb2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        synchronized (this) {
            if (this.f3370i != null) {
                int size5 = this.f3370i.size();
                if (size5 > 0) {
                    printWriter.print(str);
                    printWriter.println("Back Stack Indices:");
                    for (int i5 = 0; i5 < size5; i5++) {
                        C1057a aVar2 = (C1057a) this.f3370i.get(i5);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i5);
                        printWriter.print(": ");
                        printWriter.println(aVar2);
                    }
                }
            }
            if (this.f3371j != null && this.f3371j.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.f3371j.toArray()));
            }
        }
        if (this.f3363b != null) {
            int size6 = this.f3363b.size();
            if (size6 > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                for (int i6 = 0; i6 < size6; i6++) {
                    C1095h hVar = (C1095h) this.f3363b.get(i6);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i6);
                    printWriter.print(": ");
                    printWriter.println(hVar);
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f3374m);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f3375n);
        if (this.f3376o != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f3376o);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f3373l);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f3379s);
        printWriter.print(" mStopped=");
        printWriter.print(this.f3380t);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f3381u);
        if (this.f3378r) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f3378r);
        }
        if (this.f3382v != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.f3382v);
        }
    }

    /* renamed from: a */
    static C1090c m4137a(Context context, float f, float f2, float f3, float f4) {
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(f3351F);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f3, f4);
        alphaAnimation.setInterpolator(f3352G);
        alphaAnimation.setDuration(220);
        animationSet.addAnimation(alphaAnimation);
        return new C1090c((Animation) animationSet);
    }

    /* renamed from: a */
    static C1090c m4136a(Context context, float f, float f2) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(f3352G);
        alphaAnimation.setDuration(220);
        return new C1090c((Animation) alphaAnimation);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C1090c mo4395a(C1062d dVar, int i, boolean z, int i2) {
        int nextAnim = dVar.getNextAnim();
        Animation onCreateAnimation = dVar.onCreateAnimation(i, z, nextAnim);
        if (onCreateAnimation != null) {
            return new C1090c(onCreateAnimation);
        }
        Animator onCreateAnimator = dVar.onCreateAnimator(i, z, nextAnim);
        if (onCreateAnimator != null) {
            return new C1090c(onCreateAnimator);
        }
        if (nextAnim != 0) {
            boolean equals = "anim".equals(this.f3374m.mo4366i().getResources().getResourceTypeName(nextAnim));
            boolean z2 = false;
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(this.f3374m.mo4366i(), nextAnim);
                    if (loadAnimation != null) {
                        return new C1090c(loadAnimation);
                    }
                    z2 = true;
                } catch (NotFoundException e) {
                    throw e;
                } catch (RuntimeException unused) {
                }
            }
            if (!z2) {
                try {
                    Animator loadAnimator = AnimatorInflater.loadAnimator(this.f3374m.mo4366i(), nextAnim);
                    if (loadAnimator != null) {
                        return new C1090c(loadAnimator);
                    }
                } catch (RuntimeException e2) {
                    if (!equals) {
                        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.f3374m.mo4366i(), nextAnim);
                        if (loadAnimation2 != null) {
                            return new C1090c(loadAnimation2);
                        }
                    } else {
                        throw e2;
                    }
                }
            }
        }
        if (i == 0) {
            return null;
        }
        int b = m4148b(i, z);
        if (b < 0) {
            return null;
        }
        switch (b) {
            case 1:
                return m4137a(this.f3374m.mo4366i(), 1.125f, 1.0f, (float) BitmapDescriptorFactory.HUE_RED, 1.0f);
            case 2:
                return m4137a(this.f3374m.mo4366i(), 1.0f, 0.975f, 1.0f, (float) BitmapDescriptorFactory.HUE_RED);
            case 3:
                return m4137a(this.f3374m.mo4366i(), 0.975f, 1.0f, (float) BitmapDescriptorFactory.HUE_RED, 1.0f);
            case 4:
                return m4137a(this.f3374m.mo4366i(), 1.0f, 1.075f, 1.0f, (float) BitmapDescriptorFactory.HUE_RED);
            case 5:
                return m4136a(this.f3374m.mo4366i(), (float) BitmapDescriptorFactory.HUE_RED, 1.0f);
            case 6:
                return m4136a(this.f3374m.mo4366i(), 1.0f, (float) BitmapDescriptorFactory.HUE_RED);
            default:
                if (i2 == 0 && this.f3374m.mo4337e()) {
                    i2 = this.f3374m.mo4338f();
                }
                return i2 == 0 ? null : null;
        }
    }

    /* renamed from: a */
    public void mo4402a(C1062d dVar) {
        if (dVar.mDeferStart) {
            if (this.f3364c) {
                this.f3383w = true;
                return;
            }
            dVar.mDeferStart = false;
            mo4403a(dVar, this.f3373l, 0, 0, false);
        }
    }

    /* renamed from: b */
    private static void m4149b(View view, C1090c cVar) {
        if (!(view == null || cVar == null || !m4145a(view, cVar))) {
            if (cVar.f3404b != null) {
                cVar.f3404b.addListener(new C1091d(view));
            } else {
                AnimationListener a = m4135a(cVar.f3403a);
                view.setLayerType(2, null);
                cVar.f3403a.setAnimationListener(new C1087a(view, a));
            }
        }
    }

    /* renamed from: a */
    private static AnimationListener m4135a(Animation animation) {
        try {
            if (f3356q == null) {
                f3356q = Animation.class.getDeclaredField("mListener");
                f3356q.setAccessible(true);
            }
            return (AnimationListener) f3356q.get(animation);
        } catch (NoSuchFieldException e) {
            Log.e("FragmentManager", "No field with the name mListener is found in Animation class", e);
            return null;
        } catch (IllegalAccessException e2) {
            Log.e("FragmentManager", "Cannot access Animation's mListener field", e2);
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo4411a(int i) {
        return this.f3373l >= i;
    }

    /* JADX WARNING: type inference failed for: r8v0 */
    /* JADX WARNING: type inference failed for: r8v1, types: [int] */
    /* JADX WARNING: type inference failed for: r11v1 */
    /* JADX WARNING: type inference failed for: r8v2 */
    /* JADX WARNING: type inference failed for: r11v2 */
    /* JADX WARNING: type inference failed for: r11v3 */
    /* JADX WARNING: type inference failed for: r11v4 */
    /* JADX WARNING: type inference failed for: r8v3, types: [boolean] */
    /* JADX WARNING: type inference failed for: r8v4 */
    /* JADX WARNING: type inference failed for: r11v5 */
    /* JADX WARNING: type inference failed for: r11v6 */
    /* JADX WARNING: type inference failed for: r8v5 */
    /* JADX WARNING: type inference failed for: r8v6 */
    /* JADX WARNING: type inference failed for: r11v9 */
    /* JADX WARNING: type inference failed for: r11v10 */
    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:100:?, code lost:
        r1 = r15.getResources().getResourceName(r7.mContainerId);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0211, code lost:
        r1 = "unknown";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0243, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x031e, code lost:
        if (r11 >= 3) goto L_0x0340;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0322, code lost:
        if (f3355a == false) goto L_0x033a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0324, code lost:
        r1 = new java.lang.StringBuilder();
        r1.append("movefrom STARTED: ");
        r1.append(r15);
        android.util.Log.v("FragmentManager", r1.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x033a, code lost:
        r15.performStop();
        mo4435e(r15, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0340, code lost:
        if (r11 >= 2) goto L_0x03c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x0344, code lost:
        if (f3355a == false) goto L_0x035c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x0346, code lost:
        r1 = new java.lang.StringBuilder();
        r1.append("movefrom ACTIVITY_CREATED: ");
        r1.append(r15);
        android.util.Log.v("FragmentManager", r1.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x035e, code lost:
        if (r7.mView == null) goto L_0x036f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x0366, code lost:
        if (r6.f3374m.mo4331a(r15) == false) goto L_0x036f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x036a, code lost:
        if (r7.mSavedViewState != null) goto L_0x036f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x036c, code lost:
        mo4453m(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x036f, code lost:
        r15.performDestroyView();
        mo4437f(r15, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x0377, code lost:
        if (r7.mView == null) goto L_0x03b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x037b, code lost:
        if (r7.mContainer == null) goto L_0x03b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x037d, code lost:
        r7.mContainer.endViewTransition(r7.mView);
        r7.mView.clearAnimation();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x038c, code lost:
        if (r6.f3373l <= 0) goto L_0x03a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x0390, code lost:
        if (r6.f3381u != false) goto L_0x03a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x0398, code lost:
        if (r7.mView.getVisibility() != 0) goto L_0x03a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x039e, code lost:
        if (r7.mPostponedAlpha < com.google.android.gms.maps.model.BitmapDescriptorFactory.HUE_RED) goto L_0x03a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x03a0, code lost:
        r0 = mo4395a(r15, r17, false, r18);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x03a9, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x03aa, code lost:
        r7.mPostponedAlpha = com.google.android.gms.maps.model.BitmapDescriptorFactory.HUE_RED;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x03ac, code lost:
        if (r0 == null) goto L_0x03b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x03ae, code lost:
        m4139a(r15, r0, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x03b1, code lost:
        r7.mContainer.removeView(r7.mView);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x03b8, code lost:
        r7.mContainer = null;
        r7.mView = null;
        r7.mViewLifecycleOwner = null;
        r7.mViewLifecycleOwnerLiveData.mo4580b(null);
        r7.mInnerView = null;
        r7.mInLayout = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x03c7, code lost:
        if (r11 >= 1) goto L_0x043d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x03cb, code lost:
        if (r6.f3381u == false) goto L_0x03ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x03d1, code lost:
        if (r15.getAnimatingAway() == null) goto L_0x03de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x03d3, code lost:
        r0 = r15.getAnimatingAway();
        r15.setAnimatingAway(null);
        r0.clearAnimation();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x03e2, code lost:
        if (r15.getAnimator() == null) goto L_0x03ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x03e4, code lost:
        r0 = r15.getAnimator();
        r15.setAnimator(null);
        r0.cancel();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x03f2, code lost:
        if (r15.getAnimatingAway() != null) goto L_0x0439;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x03f8, code lost:
        if (r15.getAnimator() == null) goto L_0x03fb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x03fd, code lost:
        if (f3355a == false) goto L_0x0415;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x03ff, code lost:
        r1 = new java.lang.StringBuilder();
        r1.append("movefrom CREATED: ");
        r1.append(r15);
        android.util.Log.v("FragmentManager", r1.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x0417, code lost:
        if (r7.mRetaining != false) goto L_0x0420;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x0419, code lost:
        r15.performDestroy();
        mo4440g(r15, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x0420, code lost:
        r7.mState = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x0422, code lost:
        r15.performDetach();
        mo4443h(r15, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x0428, code lost:
        if (r19 != false) goto L_0x043d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x042c, code lost:
        if (r7.mRetaining != false) goto L_0x0432;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x042e, code lost:
        mo4439g(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x0432, code lost:
        r7.mHost = null;
        r7.mParentFragment = null;
        r7.mFragmentManager = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x0439, code lost:
        r15.setStateAfterAnimating(r11);
        r8 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01ac, code lost:
        mo4428c(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01af, code lost:
        if (r11 <= 1) goto L_0x02a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01b3, code lost:
        if (f3355a == false) goto L_0x01cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01b5, code lost:
        r1 = new java.lang.StringBuilder();
        r1.append("moveto ACTIVITY_CREATED: ");
        r1.append(r15);
        android.util.Log.v("FragmentManager", r1.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01cd, code lost:
        if (r7.mFromLayout != false) goto L_0x0291;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01d1, code lost:
        if (r7.mContainerId == 0) goto L_0x0243;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01d6, code lost:
        if (r7.mContainerId != -1) goto L_0x01f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01d8, code lost:
        r1 = new java.lang.StringBuilder();
        r1.append("Cannot create fragment ");
        r1.append(r15);
        r1.append(" for a container view with no id");
        m4141a((java.lang.RuntimeException) new java.lang.IllegalArgumentException(r1.toString()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01f6, code lost:
        r0 = (android.view.ViewGroup) r6.f3375n.mo4277a(r7.mContainerId);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0200, code lost:
        if (r0 != null) goto L_0x0244;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0204, code lost:
        if (r7.mRestored != false) goto L_0x0244;
     */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r11v5
      assigns: []
      uses: []
      mth insns count: 441
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
    /* JADX WARNING: Removed duplicated region for block: B:209:0x0442  */
    /* JADX WARNING: Unknown variable types count: 5 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo4403a(androidx.fragment.p081a.C1062d r15, int r16, int r17, int r18, boolean r19) {
        /*
            r14 = this;
            r6 = r14
            r7 = r15
            boolean r0 = r7.mAdded
            r8 = 1
            if (r0 == 0) goto L_0x000f
            boolean r0 = r7.mDetached
            if (r0 == 0) goto L_0x000c
            goto L_0x000f
        L_0x000c:
            r0 = r16
            goto L_0x0014
        L_0x000f:
            r0 = r16
            if (r0 <= r8) goto L_0x0014
            r0 = 1
        L_0x0014:
            boolean r1 = r7.mRemoving
            if (r1 == 0) goto L_0x002a
            int r1 = r7.mState
            if (r0 <= r1) goto L_0x002a
            int r0 = r7.mState
            if (r0 != 0) goto L_0x0028
            boolean r0 = r15.isInBackStack()
            if (r0 == 0) goto L_0x0028
            r0 = 1
            goto L_0x002a
        L_0x0028:
            int r0 = r7.mState
        L_0x002a:
            boolean r1 = r7.mDeferStart
            r9 = 3
            r10 = 2
            if (r1 == 0) goto L_0x0038
            int r1 = r7.mState
            if (r1 >= r9) goto L_0x0038
            if (r0 <= r10) goto L_0x0038
            r11 = 2
            goto L_0x0039
        L_0x0038:
            r11 = r0
        L_0x0039:
            int r0 = r7.mState
            r12 = 0
            r13 = 0
            if (r0 > r11) goto L_0x02f0
            boolean r0 = r7.mFromLayout
            if (r0 == 0) goto L_0x0048
            boolean r0 = r7.mInLayout
            if (r0 != 0) goto L_0x0048
            return
        L_0x0048:
            android.view.View r0 = r15.getAnimatingAway()
            if (r0 != 0) goto L_0x0054
            android.animation.Animator r0 = r15.getAnimator()
            if (r0 == 0) goto L_0x0066
        L_0x0054:
            r15.setAnimatingAway(r12)
            r15.setAnimator(r12)
            int r2 = r15.getStateAfterAnimating()
            r3 = 0
            r4 = 0
            r5 = 1
            r0 = r14
            r1 = r15
            r0.mo4403a(r1, r2, r3, r4, r5)
        L_0x0066:
            int r0 = r7.mState
            switch(r0) {
                case 0: goto L_0x006d;
                case 1: goto L_0x01ac;
                case 2: goto L_0x02a6;
                case 3: goto L_0x02c8;
                default: goto L_0x006b;
            }
        L_0x006b:
            goto L_0x043d
        L_0x006d:
            if (r11 <= 0) goto L_0x01ac
            boolean r0 = f3355a
            if (r0 == 0) goto L_0x0089
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "moveto CREATED: "
            r1.append(r2)
            r1.append(r15)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
        L_0x0089:
            android.os.Bundle r0 = r7.mSavedFragmentState
            if (r0 == 0) goto L_0x00e0
            android.os.Bundle r0 = r7.mSavedFragmentState
            androidx.fragment.a.h r1 = r6.f3374m
            android.content.Context r1 = r1.mo4366i()
            java.lang.ClassLoader r1 = r1.getClassLoader()
            r0.setClassLoader(r1)
            android.os.Bundle r0 = r7.mSavedFragmentState
            java.lang.String r1 = "android:view_state"
            android.util.SparseArray r0 = r0.getSparseParcelableArray(r1)
            r7.mSavedViewState = r0
            android.os.Bundle r0 = r7.mSavedFragmentState
            java.lang.String r1 = "android:target_state"
            androidx.fragment.a.d r0 = r14.mo4394a(r0, r1)
            r7.mTarget = r0
            androidx.fragment.a.d r0 = r7.mTarget
            if (r0 == 0) goto L_0x00be
            android.os.Bundle r0 = r7.mSavedFragmentState
            java.lang.String r1 = "android:target_req_state"
            int r0 = r0.getInt(r1, r13)
            r7.mTargetRequestCode = r0
        L_0x00be:
            java.lang.Boolean r0 = r7.mSavedUserVisibleHint
            if (r0 == 0) goto L_0x00cd
            java.lang.Boolean r0 = r7.mSavedUserVisibleHint
            boolean r0 = r0.booleanValue()
            r7.mUserVisibleHint = r0
            r7.mSavedUserVisibleHint = r12
            goto L_0x00d7
        L_0x00cd:
            android.os.Bundle r0 = r7.mSavedFragmentState
            java.lang.String r1 = "android:user_visible_hint"
            boolean r0 = r0.getBoolean(r1, r8)
            r7.mUserVisibleHint = r0
        L_0x00d7:
            boolean r0 = r7.mUserVisibleHint
            if (r0 != 0) goto L_0x00e0
            r7.mDeferStart = r8
            if (r11 <= r10) goto L_0x00e0
            r11 = 2
        L_0x00e0:
            androidx.fragment.a.h r0 = r6.f3374m
            r7.mHost = r0
            androidx.fragment.a.d r0 = r6.f3376o
            r7.mParentFragment = r0
            androidx.fragment.a.d r0 = r6.f3376o
            if (r0 == 0) goto L_0x00f1
            androidx.fragment.a.d r0 = r6.f3376o
            androidx.fragment.a.j r0 = r0.mChildFragmentManager
            goto L_0x00f7
        L_0x00f1:
            androidx.fragment.a.h r0 = r6.f3374m
            androidx.fragment.a.j r0 = r0.mo4368k()
        L_0x00f7:
            r7.mFragmentManager = r0
            androidx.fragment.a.d r0 = r7.mTarget
            if (r0 == 0) goto L_0x0142
            android.util.SparseArray<androidx.fragment.a.d> r0 = r6.f3367f
            androidx.fragment.a.d r1 = r7.mTarget
            int r1 = r1.mIndex
            java.lang.Object r0 = r0.get(r1)
            androidx.fragment.a.d r1 = r7.mTarget
            if (r0 != r1) goto L_0x011c
            androidx.fragment.a.d r0 = r7.mTarget
            int r0 = r0.mState
            if (r0 >= r8) goto L_0x0142
            androidx.fragment.a.d r1 = r7.mTarget
            r2 = 1
            r3 = 0
            r4 = 0
            r5 = 1
            r0 = r14
            r0.mo4403a(r1, r2, r3, r4, r5)
            goto L_0x0142
        L_0x011c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Fragment "
            r1.append(r2)
            r1.append(r15)
            java.lang.String r2 = " declared target fragment "
            r1.append(r2)
            androidx.fragment.a.d r2 = r7.mTarget
            r1.append(r2)
            java.lang.String r2 = " that does not belong to this FragmentManager!"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0142:
            androidx.fragment.a.h r0 = r6.f3374m
            android.content.Context r0 = r0.mo4366i()
            r14.mo4404a(r15, r0, r13)
            r7.mCalled = r13
            androidx.fragment.a.h r0 = r6.f3374m
            android.content.Context r0 = r0.mo4366i()
            r15.onAttach(r0)
            boolean r0 = r7.mCalled
            if (r0 == 0) goto L_0x0190
            androidx.fragment.a.d r0 = r7.mParentFragment
            if (r0 != 0) goto L_0x0164
            androidx.fragment.a.h r0 = r6.f3374m
            r0.mo4334b(r15)
            goto L_0x0169
        L_0x0164:
            androidx.fragment.a.d r0 = r7.mParentFragment
            r0.onAttachFragment(r15)
        L_0x0169:
            androidx.fragment.a.h r0 = r6.f3374m
            android.content.Context r0 = r0.mo4366i()
            r14.mo4421b(r15, r0, r13)
            boolean r0 = r7.mIsCreated
            if (r0 != 0) goto L_0x0186
            android.os.Bundle r0 = r7.mSavedFragmentState
            r14.mo4405a(r15, r0, r13)
            android.os.Bundle r0 = r7.mSavedFragmentState
            r15.performCreate(r0)
            android.os.Bundle r0 = r7.mSavedFragmentState
            r14.mo4422b(r15, r0, r13)
            goto L_0x018d
        L_0x0186:
            android.os.Bundle r0 = r7.mSavedFragmentState
            r15.restoreChildFragmentState(r0)
            r7.mState = r8
        L_0x018d:
            r7.mRetaining = r13
            goto L_0x01ac
        L_0x0190:
            androidx.fragment.a.t r0 = new androidx.fragment.a.t
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Fragment "
            r1.append(r2)
            r1.append(r15)
            java.lang.String r2 = " did not call through to super.onAttach()"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x01ac:
            r14.mo4428c(r15)
            if (r11 <= r8) goto L_0x02a6
            boolean r0 = f3355a
            if (r0 == 0) goto L_0x01cb
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "moveto ACTIVITY_CREATED: "
            r1.append(r2)
            r1.append(r15)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
        L_0x01cb:
            boolean r0 = r7.mFromLayout
            if (r0 != 0) goto L_0x0291
            int r0 = r7.mContainerId
            if (r0 == 0) goto L_0x0243
            int r0 = r7.mContainerId
            r1 = -1
            if (r0 != r1) goto L_0x01f6
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Cannot create fragment "
            r1.append(r2)
            r1.append(r15)
            java.lang.String r2 = " for a container view with no id"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            r14.m4141a(r0)
        L_0x01f6:
            androidx.fragment.a.f r0 = r6.f3375n
            int r1 = r7.mContainerId
            android.view.View r0 = r0.mo4277a(r1)
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            if (r0 != 0) goto L_0x0244
            boolean r1 = r7.mRestored
            if (r1 != 0) goto L_0x0244
            android.content.res.Resources r1 = r15.getResources()     // Catch:{ NotFoundException -> 0x0211 }
            int r2 = r7.mContainerId     // Catch:{ NotFoundException -> 0x0211 }
            java.lang.String r1 = r1.getResourceName(r2)     // Catch:{ NotFoundException -> 0x0211 }
            goto L_0x0213
        L_0x0211:
            java.lang.String r1 = "unknown"
        L_0x0213:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "No view found for id 0x"
            r3.append(r4)
            int r4 = r7.mContainerId
            java.lang.String r4 = java.lang.Integer.toHexString(r4)
            r3.append(r4)
            java.lang.String r4 = " ("
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = ") for fragment "
            r3.append(r1)
            r3.append(r15)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            r14.m4141a(r2)
            goto L_0x0244
        L_0x0243:
            r0 = r12
        L_0x0244:
            r7.mContainer = r0
            android.os.Bundle r1 = r7.mSavedFragmentState
            android.view.LayoutInflater r1 = r15.performGetLayoutInflater(r1)
            android.os.Bundle r2 = r7.mSavedFragmentState
            r15.performCreateView(r1, r0, r2)
            android.view.View r1 = r7.mView
            if (r1 == 0) goto L_0x028f
            android.view.View r1 = r7.mView
            r7.mInnerView = r1
            android.view.View r1 = r7.mView
            r1.setSaveFromParentEnabled(r13)
            if (r0 == 0) goto L_0x0265
            android.view.View r1 = r7.mView
            r0.addView(r1)
        L_0x0265:
            boolean r0 = r7.mHidden
            if (r0 == 0) goto L_0x0270
            android.view.View r0 = r7.mView
            r1 = 8
            r0.setVisibility(r1)
        L_0x0270:
            android.view.View r0 = r7.mView
            android.os.Bundle r1 = r7.mSavedFragmentState
            r15.onViewCreated(r0, r1)
            android.view.View r0 = r7.mView
            android.os.Bundle r1 = r7.mSavedFragmentState
            r14.mo4406a(r15, r0, r1, r13)
            android.view.View r0 = r7.mView
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x028b
            android.view.ViewGroup r0 = r7.mContainer
            if (r0 == 0) goto L_0x028b
            goto L_0x028c
        L_0x028b:
            r8 = 0
        L_0x028c:
            r7.mIsNewlyAdded = r8
            goto L_0x0291
        L_0x028f:
            r7.mInnerView = r12
        L_0x0291:
            android.os.Bundle r0 = r7.mSavedFragmentState
            r15.performActivityCreated(r0)
            android.os.Bundle r0 = r7.mSavedFragmentState
            r14.mo4429c(r15, r0, r13)
            android.view.View r0 = r7.mView
            if (r0 == 0) goto L_0x02a4
            android.os.Bundle r0 = r7.mSavedFragmentState
            r15.restoreViewState(r0)
        L_0x02a4:
            r7.mSavedFragmentState = r12
        L_0x02a6:
            if (r11 <= r10) goto L_0x02c8
            boolean r0 = f3355a
            if (r0 == 0) goto L_0x02c2
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "moveto STARTED: "
            r1.append(r2)
            r1.append(r15)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
        L_0x02c2:
            r15.performStart()
            r14.mo4423b(r15, r13)
        L_0x02c8:
            if (r11 <= r9) goto L_0x043d
            boolean r0 = f3355a
            if (r0 == 0) goto L_0x02e4
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "moveto RESUMED: "
            r1.append(r2)
            r1.append(r15)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
        L_0x02e4:
            r15.performResume()
            r14.mo4430c(r15, r13)
            r7.mSavedFragmentState = r12
            r7.mSavedViewState = r12
            goto L_0x043d
        L_0x02f0:
            int r0 = r7.mState
            if (r0 <= r11) goto L_0x043d
            int r0 = r7.mState
            switch(r0) {
                case 1: goto L_0x03c7;
                case 2: goto L_0x0340;
                case 3: goto L_0x031e;
                case 4: goto L_0x02fb;
                default: goto L_0x02f9;
            }
        L_0x02f9:
            goto L_0x043d
        L_0x02fb:
            r0 = 4
            if (r11 >= r0) goto L_0x031e
            boolean r0 = f3355a
            if (r0 == 0) goto L_0x0318
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "movefrom RESUMED: "
            r1.append(r2)
            r1.append(r15)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
        L_0x0318:
            r15.performPause()
            r14.mo4433d(r15, r13)
        L_0x031e:
            if (r11 >= r9) goto L_0x0340
            boolean r0 = f3355a
            if (r0 == 0) goto L_0x033a
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "movefrom STARTED: "
            r1.append(r2)
            r1.append(r15)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
        L_0x033a:
            r15.performStop()
            r14.mo4435e(r15, r13)
        L_0x0340:
            if (r11 >= r10) goto L_0x03c7
            boolean r0 = f3355a
            if (r0 == 0) goto L_0x035c
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "movefrom ACTIVITY_CREATED: "
            r1.append(r2)
            r1.append(r15)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
        L_0x035c:
            android.view.View r0 = r7.mView
            if (r0 == 0) goto L_0x036f
            androidx.fragment.a.h r0 = r6.f3374m
            boolean r0 = r0.mo4331a(r15)
            if (r0 == 0) goto L_0x036f
            android.util.SparseArray<android.os.Parcelable> r0 = r7.mSavedViewState
            if (r0 != 0) goto L_0x036f
            r14.mo4453m(r15)
        L_0x036f:
            r15.performDestroyView()
            r14.mo4437f(r15, r13)
            android.view.View r0 = r7.mView
            if (r0 == 0) goto L_0x03b8
            android.view.ViewGroup r0 = r7.mContainer
            if (r0 == 0) goto L_0x03b8
            android.view.ViewGroup r0 = r7.mContainer
            android.view.View r1 = r7.mView
            r0.endViewTransition(r1)
            android.view.View r0 = r7.mView
            r0.clearAnimation()
            int r0 = r6.f3373l
            r1 = 0
            if (r0 <= 0) goto L_0x03a9
            boolean r0 = r6.f3381u
            if (r0 != 0) goto L_0x03a9
            android.view.View r0 = r7.mView
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x03a9
            float r0 = r7.mPostponedAlpha
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x03a9
            r0 = r17
            r2 = r18
            androidx.fragment.a.j$c r0 = r14.mo4395a(r15, r0, r13, r2)
            goto L_0x03aa
        L_0x03a9:
            r0 = r12
        L_0x03aa:
            r7.mPostponedAlpha = r1
            if (r0 == 0) goto L_0x03b1
            r14.m4139a(r15, r0, r11)
        L_0x03b1:
            android.view.ViewGroup r0 = r7.mContainer
            android.view.View r1 = r7.mView
            r0.removeView(r1)
        L_0x03b8:
            r7.mContainer = r12
            r7.mView = r12
            r7.mViewLifecycleOwner = r12
            androidx.lifecycle.l<androidx.lifecycle.g> r0 = r7.mViewLifecycleOwnerLiveData
            r0.mo4580b(r12)
            r7.mInnerView = r12
            r7.mInLayout = r13
        L_0x03c7:
            if (r11 >= r8) goto L_0x043d
            boolean r0 = r6.f3381u
            if (r0 == 0) goto L_0x03ee
            android.view.View r0 = r15.getAnimatingAway()
            if (r0 == 0) goto L_0x03de
            android.view.View r0 = r15.getAnimatingAway()
            r15.setAnimatingAway(r12)
            r0.clearAnimation()
            goto L_0x03ee
        L_0x03de:
            android.animation.Animator r0 = r15.getAnimator()
            if (r0 == 0) goto L_0x03ee
            android.animation.Animator r0 = r15.getAnimator()
            r15.setAnimator(r12)
            r0.cancel()
        L_0x03ee:
            android.view.View r0 = r15.getAnimatingAway()
            if (r0 != 0) goto L_0x0439
            android.animation.Animator r0 = r15.getAnimator()
            if (r0 == 0) goto L_0x03fb
            goto L_0x0439
        L_0x03fb:
            boolean r0 = f3355a
            if (r0 == 0) goto L_0x0415
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "movefrom CREATED: "
            r1.append(r2)
            r1.append(r15)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
        L_0x0415:
            boolean r0 = r7.mRetaining
            if (r0 != 0) goto L_0x0420
            r15.performDestroy()
            r14.mo4440g(r15, r13)
            goto L_0x0422
        L_0x0420:
            r7.mState = r13
        L_0x0422:
            r15.performDetach()
            r14.mo4443h(r15, r13)
            if (r19 != 0) goto L_0x043d
            boolean r0 = r7.mRetaining
            if (r0 != 0) goto L_0x0432
            r14.mo4439g(r15)
            goto L_0x043d
        L_0x0432:
            r7.mHost = r12
            r7.mParentFragment = r12
            r7.mFragmentManager = r12
            goto L_0x043d
        L_0x0439:
            r15.setStateAfterAnimating(r11)
            goto L_0x043e
        L_0x043d:
            r8 = r11
        L_0x043e:
            int r0 = r7.mState
            if (r0 == r8) goto L_0x0471
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "moveToState: Fragment state for "
            r1.append(r2)
            r1.append(r15)
            java.lang.String r2 = " not updated inline; "
            r1.append(r2)
            java.lang.String r2 = "expected state "
            r1.append(r2)
            r1.append(r8)
            java.lang.String r2 = " found "
            r1.append(r2)
            int r2 = r7.mState
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.util.Log.w(r0, r1)
            r7.mState = r8
        L_0x0471:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.p081a.C1081j.mo4403a(androidx.fragment.a.d, int, int, int, boolean):void");
    }

    /* renamed from: a */
    private void m4139a(final C1062d dVar, C1090c cVar, int i) {
        final View view = dVar.mView;
        final ViewGroup viewGroup = dVar.mContainer;
        viewGroup.startViewTransition(view);
        dVar.setStateAfterAnimating(i);
        if (cVar.f3403a != null) {
            C1092e eVar = new C1092e(cVar.f3403a, viewGroup, view);
            dVar.setAnimatingAway(dVar.mView);
            eVar.setAnimationListener(new C1089b(m4135a((Animation) eVar)) {
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    viewGroup.post(new Runnable() {
                        public void run() {
                            if (dVar.getAnimatingAway() != null) {
                                dVar.setAnimatingAway(null);
                                C1081j.this.mo4403a(dVar, dVar.getStateAfterAnimating(), 0, 0, false);
                            }
                        }
                    });
                }
            });
            m4149b(view, cVar);
            dVar.mView.startAnimation(eVar);
            return;
        }
        Animator animator = cVar.f3404b;
        dVar.setAnimator(cVar.f3404b);
        animator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                viewGroup.endViewTransition(view);
                Animator animator2 = dVar.getAnimator();
                dVar.setAnimator(null);
                if (animator2 != null && viewGroup.indexOfChild(view) < 0) {
                    C1081j.this.mo4403a(dVar, dVar.getStateAfterAnimating(), 0, 0, false);
                }
            }
        });
        animator.setTarget(dVar.mView);
        m4149b(dVar.mView, cVar);
        animator.start();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo4420b(C1062d dVar) {
        mo4403a(dVar, this.f3373l, 0, 0, false);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo4428c(C1062d dVar) {
        if (dVar.mFromLayout && !dVar.mPerformedCreateView) {
            dVar.performCreateView(dVar.performGetLayoutInflater(dVar.mSavedFragmentState), null, dVar.mSavedFragmentState);
            if (dVar.mView != null) {
                dVar.mInnerView = dVar.mView;
                dVar.mView.setSaveFromParentEnabled(false);
                if (dVar.mHidden) {
                    dVar.mView.setVisibility(8);
                }
                dVar.onViewCreated(dVar.mView, dVar.mSavedFragmentState);
                mo4406a(dVar, dVar.mView, dVar.mSavedFragmentState, false);
                return;
            }
            dVar.mInnerView = null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo4431d(final C1062d dVar) {
        if (dVar.mView != null) {
            C1090c a = mo4395a(dVar, dVar.getNextTransition(), !dVar.mHidden, dVar.getNextTransitionStyle());
            if (a == null || a.f3404b == null) {
                if (a != null) {
                    m4149b(dVar.mView, a);
                    dVar.mView.startAnimation(a.f3403a);
                    a.f3403a.start();
                }
                dVar.mView.setVisibility((!dVar.mHidden || dVar.isHideReplaced()) ? 0 : 8);
                if (dVar.isHideReplaced()) {
                    dVar.setHideReplaced(false);
                }
            } else {
                a.f3404b.setTarget(dVar.mView);
                if (!dVar.mHidden) {
                    dVar.mView.setVisibility(0);
                } else if (dVar.isHideReplaced()) {
                    dVar.setHideReplaced(false);
                } else {
                    final ViewGroup viewGroup = dVar.mContainer;
                    final View view = dVar.mView;
                    viewGroup.startViewTransition(view);
                    a.f3404b.addListener(new AnimatorListenerAdapter() {
                        public void onAnimationEnd(Animator animator) {
                            viewGroup.endViewTransition(view);
                            animator.removeListener(this);
                            if (dVar.mView != null) {
                                dVar.mView.setVisibility(8);
                            }
                        }
                    });
                }
                m4149b(dVar.mView, a);
                a.f3404b.start();
            }
        }
        if (dVar.mAdded && dVar.mHasMenu && dVar.mMenuVisible) {
            this.f3378r = true;
        }
        dVar.mHiddenChanged = false;
        dVar.onHiddenChanged(dVar.mHidden);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo4434e(C1062d dVar) {
        if (dVar != null) {
            int i = this.f3373l;
            if (dVar.mRemoving) {
                if (dVar.isInBackStack()) {
                    i = Math.min(i, 1);
                } else {
                    i = Math.min(i, 0);
                }
            }
            mo4403a(dVar, i, dVar.getNextTransition(), dVar.getNextTransitionStyle(), false);
            if (dVar.mView != null) {
                C1062d p = m4157p(dVar);
                if (p != null) {
                    View view = p.mView;
                    ViewGroup viewGroup = dVar.mContainer;
                    int indexOfChild = viewGroup.indexOfChild(view);
                    int indexOfChild2 = viewGroup.indexOfChild(dVar.mView);
                    if (indexOfChild2 < indexOfChild) {
                        viewGroup.removeViewAt(indexOfChild2);
                        viewGroup.addView(dVar.mView, indexOfChild);
                    }
                }
                if (dVar.mIsNewlyAdded && dVar.mContainer != null) {
                    if (dVar.mPostponedAlpha > BitmapDescriptorFactory.HUE_RED) {
                        dVar.mView.setAlpha(dVar.mPostponedAlpha);
                    }
                    dVar.mPostponedAlpha = BitmapDescriptorFactory.HUE_RED;
                    dVar.mIsNewlyAdded = false;
                    C1090c a = mo4395a(dVar, dVar.getNextTransition(), true, dVar.getNextTransitionStyle());
                    if (a != null) {
                        m4149b(dVar.mView, a);
                        if (a.f3403a != null) {
                            dVar.mView.startAnimation(a.f3403a);
                        } else {
                            a.f3404b.setTarget(dVar.mView);
                            a.f3404b.start();
                        }
                    }
                }
            }
            if (dVar.mHiddenChanged) {
                mo4431d(dVar);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4397a(int i, boolean z) {
        if (this.f3374m == null && i != 0) {
            throw new IllegalStateException("No activity");
        } else if (z || i != this.f3373l) {
            this.f3373l = i;
            if (this.f3367f != null) {
                int size = this.f3366e.size();
                for (int i2 = 0; i2 < size; i2++) {
                    mo4434e((C1062d) this.f3366e.get(i2));
                }
                int size2 = this.f3367f.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    C1062d dVar = (C1062d) this.f3367f.valueAt(i3);
                    if (dVar != null && ((dVar.mRemoving || dVar.mDetached) && !dVar.mIsNewlyAdded)) {
                        mo4434e(dVar);
                    }
                }
                mo4438g();
                if (this.f3378r && this.f3374m != null && this.f3373l == 4) {
                    this.f3374m.mo4336d();
                    this.f3378r = false;
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public void mo4438g() {
        if (this.f3367f != null) {
            for (int i = 0; i < this.f3367f.size(); i++) {
                C1062d dVar = (C1062d) this.f3367f.valueAt(i);
                if (dVar != null) {
                    mo4402a(dVar);
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public void mo4436f(C1062d dVar) {
        if (dVar.mIndex < 0) {
            int i = this.f3365d;
            this.f3365d = i + 1;
            dVar.setIndex(i, this.f3376o);
            if (this.f3367f == null) {
                this.f3367f = new SparseArray<>();
            }
            this.f3367f.put(dVar.mIndex, dVar);
            if (f3355a) {
                StringBuilder sb = new StringBuilder();
                sb.append("Allocated fragment index ");
                sb.append(dVar);
                Log.v("FragmentManager", sb.toString());
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public void mo4439g(C1062d dVar) {
        if (dVar.mIndex >= 0) {
            if (f3355a) {
                StringBuilder sb = new StringBuilder();
                sb.append("Freeing fragment index ");
                sb.append(dVar);
                Log.v("FragmentManager", sb.toString());
            }
            this.f3367f.put(dVar.mIndex, null);
            dVar.initState();
        }
    }

    /* renamed from: a */
    public void mo4407a(C1062d dVar, boolean z) {
        if (f3355a) {
            StringBuilder sb = new StringBuilder();
            sb.append("add: ");
            sb.append(dVar);
            Log.v("FragmentManager", sb.toString());
        }
        mo4436f(dVar);
        if (dVar.mDetached) {
            return;
        }
        if (!this.f3366e.contains(dVar)) {
            synchronized (this.f3366e) {
                this.f3366e.add(dVar);
            }
            dVar.mAdded = true;
            dVar.mRemoving = false;
            if (dVar.mView == null) {
                dVar.mHiddenChanged = false;
            }
            if (dVar.mHasMenu && dVar.mMenuVisible) {
                this.f3378r = true;
            }
            if (z) {
                mo4420b(dVar);
                return;
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Fragment already added: ");
        sb2.append(dVar);
        throw new IllegalStateException(sb2.toString());
    }

    /* renamed from: h */
    public void mo4442h(C1062d dVar) {
        if (f3355a) {
            StringBuilder sb = new StringBuilder();
            sb.append("remove: ");
            sb.append(dVar);
            sb.append(" nesting=");
            sb.append(dVar.mBackStackNesting);
            Log.v("FragmentManager", sb.toString());
        }
        boolean z = !dVar.isInBackStack();
        if (!dVar.mDetached || z) {
            synchronized (this.f3366e) {
                this.f3366e.remove(dVar);
            }
            if (dVar.mHasMenu && dVar.mMenuVisible) {
                this.f3378r = true;
            }
            dVar.mAdded = false;
            dVar.mRemoving = true;
        }
    }

    /* renamed from: i */
    public void mo4444i(C1062d dVar) {
        if (f3355a) {
            StringBuilder sb = new StringBuilder();
            sb.append("hide: ");
            sb.append(dVar);
            Log.v("FragmentManager", sb.toString());
        }
        if (!dVar.mHidden) {
            dVar.mHidden = true;
            dVar.mHiddenChanged = true ^ dVar.mHiddenChanged;
        }
    }

    /* renamed from: j */
    public void mo4447j(C1062d dVar) {
        if (f3355a) {
            StringBuilder sb = new StringBuilder();
            sb.append("show: ");
            sb.append(dVar);
            Log.v("FragmentManager", sb.toString());
        }
        if (dVar.mHidden) {
            dVar.mHidden = false;
            dVar.mHiddenChanged = !dVar.mHiddenChanged;
        }
    }

    /* renamed from: k */
    public void mo4449k(C1062d dVar) {
        if (f3355a) {
            StringBuilder sb = new StringBuilder();
            sb.append("detach: ");
            sb.append(dVar);
            Log.v("FragmentManager", sb.toString());
        }
        if (!dVar.mDetached) {
            dVar.mDetached = true;
            if (dVar.mAdded) {
                if (f3355a) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("remove from detach: ");
                    sb2.append(dVar);
                    Log.v("FragmentManager", sb2.toString());
                }
                synchronized (this.f3366e) {
                    this.f3366e.remove(dVar);
                }
                if (dVar.mHasMenu && dVar.mMenuVisible) {
                    this.f3378r = true;
                }
                dVar.mAdded = false;
            }
        }
    }

    /* renamed from: l */
    public void mo4451l(C1062d dVar) {
        if (f3355a) {
            StringBuilder sb = new StringBuilder();
            sb.append("attach: ");
            sb.append(dVar);
            Log.v("FragmentManager", sb.toString());
        }
        if (dVar.mDetached) {
            dVar.mDetached = false;
            if (dVar.mAdded) {
                return;
            }
            if (!this.f3366e.contains(dVar)) {
                if (f3355a) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("add from attach: ");
                    sb2.append(dVar);
                    Log.v("FragmentManager", sb2.toString());
                }
                synchronized (this.f3366e) {
                    this.f3366e.add(dVar);
                }
                dVar.mAdded = true;
                if (dVar.mHasMenu && dVar.mMenuVisible) {
                    this.f3378r = true;
                    return;
                }
                return;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Fragment already added: ");
            sb3.append(dVar);
            throw new IllegalStateException(sb3.toString());
        }
    }

    /* renamed from: b */
    public C1062d mo4416b(int i) {
        for (int size = this.f3366e.size() - 1; size >= 0; size--) {
            C1062d dVar = (C1062d) this.f3366e.get(size);
            if (dVar != null && dVar.mFragmentId == i) {
                return dVar;
            }
        }
        if (this.f3367f != null) {
            for (int size2 = this.f3367f.size() - 1; size2 >= 0; size2--) {
                C1062d dVar2 = (C1062d) this.f3367f.valueAt(size2);
                if (dVar2 != null && dVar2.mFragmentId == i) {
                    return dVar2;
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public C1062d mo4369a(String str) {
        if (str != null) {
            for (int size = this.f3366e.size() - 1; size >= 0; size--) {
                C1062d dVar = (C1062d) this.f3366e.get(size);
                if (dVar != null && str.equals(dVar.mTag)) {
                    return dVar;
                }
            }
        }
        if (!(this.f3367f == null || str == null)) {
            for (int size2 = this.f3367f.size() - 1; size2 >= 0; size2--) {
                C1062d dVar2 = (C1062d) this.f3367f.valueAt(size2);
                if (dVar2 != null && str.equals(dVar2.mTag)) {
                    return dVar2;
                }
            }
        }
        return null;
    }

    /* renamed from: b */
    public C1062d mo4417b(String str) {
        if (!(this.f3367f == null || str == null)) {
            for (int size = this.f3367f.size() - 1; size >= 0; size--) {
                C1062d dVar = (C1062d) this.f3367f.valueAt(size);
                if (dVar != null) {
                    C1062d findFragmentByWho = dVar.findFragmentByWho(str);
                    if (findFragmentByWho != null) {
                        return findFragmentByWho;
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: A */
    private void m4129A() {
        if (mo4377f()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        } else if (this.f3382v != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Can not perform this action inside of ");
            sb.append(this.f3382v);
            throw new IllegalStateException(sb.toString());
        }
    }

    /* renamed from: f */
    public boolean mo4377f() {
        return this.f3379s || this.f3380t;
    }

    /* renamed from: a */
    public void mo4409a(C1095h hVar, boolean z) {
        if (!z) {
            m4129A();
        }
        synchronized (this) {
            if (!this.f3381u) {
                if (this.f3374m != null) {
                    if (this.f3363b == null) {
                        this.f3363b = new ArrayList<>();
                    }
                    this.f3363b.add(hVar);
                    mo4441h();
                    return;
                }
            }
            if (!z) {
                throw new IllegalStateException("Activity has been destroyed");
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public void mo4441h() {
        synchronized (this) {
            boolean z = false;
            boolean z2 = this.f3359C != null && !this.f3359C.isEmpty();
            if (this.f3363b != null && this.f3363b.size() == 1) {
                z = true;
            }
            if (z2 || z) {
                this.f3374m.mo4367j().removeCallbacks(this.f3361E);
                this.f3374m.mo4367j().post(this.f3361E);
            }
        }
    }

    /* renamed from: a */
    public int mo4393a(C1057a aVar) {
        synchronized (this) {
            if (this.f3371j != null) {
                if (this.f3371j.size() > 0) {
                    int intValue = ((Integer) this.f3371j.remove(this.f3371j.size() - 1)).intValue();
                    if (f3355a) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Adding back stack index ");
                        sb.append(intValue);
                        sb.append(" with ");
                        sb.append(aVar);
                        Log.v("FragmentManager", sb.toString());
                    }
                    this.f3370i.set(intValue, aVar);
                    return intValue;
                }
            }
            if (this.f3370i == null) {
                this.f3370i = new ArrayList<>();
            }
            int size = this.f3370i.size();
            if (f3355a) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Setting back stack index ");
                sb2.append(size);
                sb2.append(" to ");
                sb2.append(aVar);
                Log.v("FragmentManager", sb2.toString());
            }
            this.f3370i.add(aVar);
            return size;
        }
    }

    /* renamed from: a */
    public void mo4396a(int i, C1057a aVar) {
        synchronized (this) {
            if (this.f3370i == null) {
                this.f3370i = new ArrayList<>();
            }
            int size = this.f3370i.size();
            if (i < size) {
                if (f3355a) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Setting back stack index ");
                    sb.append(i);
                    sb.append(" to ");
                    sb.append(aVar);
                    Log.v("FragmentManager", sb.toString());
                }
                this.f3370i.set(i, aVar);
            } else {
                while (size < i) {
                    this.f3370i.add(null);
                    if (this.f3371j == null) {
                        this.f3371j = new ArrayList<>();
                    }
                    if (f3355a) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Adding available back stack index ");
                        sb2.append(size);
                        Log.v("FragmentManager", sb2.toString());
                    }
                    this.f3371j.add(Integer.valueOf(size));
                    size++;
                }
                if (f3355a) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Adding back stack index ");
                    sb3.append(i);
                    sb3.append(" with ");
                    sb3.append(aVar);
                    Log.v("FragmentManager", sb3.toString());
                }
                this.f3370i.add(aVar);
            }
        }
    }

    /* renamed from: c */
    public void mo4427c(int i) {
        synchronized (this) {
            this.f3370i.set(i, null);
            if (this.f3371j == null) {
                this.f3371j = new ArrayList<>();
            }
            if (f3355a) {
                StringBuilder sb = new StringBuilder();
                sb.append("Freeing back stack index ");
                sb.append(i);
                Log.v("FragmentManager", sb.toString());
            }
            this.f3371j.add(Integer.valueOf(i));
        }
    }

    /* renamed from: c */
    private void m4153c(boolean z) {
        if (this.f3364c) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (this.f3374m == null) {
            throw new IllegalStateException("Fragment host has been destroyed");
        } else if (Looper.myLooper() == this.f3374m.mo4367j().getLooper()) {
            if (!z) {
                m4129A();
            }
            if (this.f3384x == null) {
                this.f3384x = new ArrayList<>();
                this.f3385y = new ArrayList<>();
            }
            this.f3364c = true;
            try {
                m4142a(null, null);
            } finally {
                this.f3364c = false;
            }
        } else {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
    }

    /* renamed from: b */
    public void mo4424b(C1095h hVar, boolean z) {
        if (!z || (this.f3374m != null && !this.f3381u)) {
            m4153c(z);
            if (hVar.mo4077a(this.f3384x, this.f3385y)) {
                this.f3364c = true;
                try {
                    m4151b(this.f3384x, this.f3385y);
                } finally {
                    m4130B();
                }
            }
            mo4446j();
            m4133E();
        }
    }

    /* renamed from: B */
    private void m4130B() {
        this.f3364c = false;
        this.f3385y.clear();
        this.f3384x.clear();
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: i */
    public boolean mo4445i() {
        m4153c(true);
        boolean z = false;
        while (m4154c(this.f3384x, this.f3385y)) {
            this.f3364c = true;
            try {
                m4151b(this.f3384x, this.f3385y);
                m4130B();
                z = true;
            } catch (Throwable th) {
                m4130B();
                throw th;
            }
        }
        mo4446j();
        m4133E();
        return z;
    }

    /* renamed from: a */
    private void m4142a(ArrayList<C1057a> arrayList, ArrayList<Boolean> arrayList2) {
        int size = this.f3359C == null ? 0 : this.f3359C.size();
        int i = 0;
        while (i < size) {
            C1097j jVar = (C1097j) this.f3359C.get(i);
            if (arrayList != null && !jVar.f3418a) {
                int indexOf = arrayList.indexOf(jVar.f3419b);
                if (indexOf != -1 && ((Boolean) arrayList2.get(indexOf)).booleanValue()) {
                    jVar.mo4487e();
                    i++;
                }
            }
            if (jVar.mo4485c() || (arrayList != null && jVar.f3419b.mo4076a(arrayList, 0, arrayList.size()))) {
                this.f3359C.remove(i);
                i--;
                size--;
                if (arrayList != null && !jVar.f3418a) {
                    int indexOf2 = arrayList.indexOf(jVar.f3419b);
                    if (indexOf2 != -1 && ((Boolean) arrayList2.get(indexOf2)).booleanValue()) {
                        jVar.mo4487e();
                    }
                }
                jVar.mo4486d();
            }
            i++;
        }
    }

    /* renamed from: b */
    private void m4151b(ArrayList<C1057a> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList != null && !arrayList.isEmpty()) {
            if (arrayList2 == null || arrayList.size() != arrayList2.size()) {
                throw new IllegalStateException("Internal error with the back stack records");
            }
            m4142a(arrayList, arrayList2);
            int size = arrayList.size();
            int i = 0;
            int i2 = 0;
            while (i < size) {
                if (!((C1057a) arrayList.get(i)).f3297t) {
                    if (i2 != i) {
                        m4143a(arrayList, arrayList2, i2, i);
                    }
                    i2 = i + 1;
                    if (((Boolean) arrayList2.get(i)).booleanValue()) {
                        while (i2 < size && ((Boolean) arrayList2.get(i2)).booleanValue() && !((C1057a) arrayList.get(i2)).f3297t) {
                            i2++;
                        }
                    }
                    m4143a(arrayList, arrayList2, i, i2);
                    i = i2 - 1;
                }
                i++;
            }
            if (i2 != size) {
                m4143a(arrayList, arrayList2, i2, size);
            }
        }
    }

    /* renamed from: a */
    private void m4143a(ArrayList<C1057a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        int i3;
        ArrayList<C1057a> arrayList3 = arrayList;
        ArrayList<Boolean> arrayList4 = arrayList2;
        int i4 = i;
        int i5 = i2;
        boolean z = ((C1057a) arrayList3.get(i4)).f3297t;
        if (this.f3386z == null) {
            this.f3386z = new ArrayList<>();
        } else {
            this.f3386z.clear();
        }
        this.f3386z.addAll(this.f3366e);
        C1062d y = mo4470y();
        boolean z2 = false;
        for (int i6 = i4; i6 < i5; i6++) {
            C1057a aVar = (C1057a) arrayList3.get(i6);
            if (!((Boolean) arrayList4.get(i6)).booleanValue()) {
                y = aVar.mo4064a(this.f3386z, y);
            } else {
                y = aVar.mo4078b(this.f3386z, y);
            }
            z2 = z2 || aVar.f3286i;
        }
        this.f3386z.clear();
        if (!z) {
            C1105p.m4298a(this, arrayList, arrayList2, i, i2, false);
        }
        m4152b(arrayList, arrayList2, i, i2);
        if (z) {
            C0714b bVar = new C0714b();
            m4150b(bVar);
            int a = m4134a(arrayList, arrayList2, i, i2, bVar);
            m4138a(bVar);
            i3 = a;
        } else {
            i3 = i5;
        }
        if (i3 != i4 && z) {
            C1105p.m4298a(this, arrayList, arrayList2, i, i3, true);
            mo4397a(this.f3373l, true);
        }
        while (i4 < i5) {
            C1057a aVar2 = (C1057a) arrayList3.get(i4);
            if (((Boolean) arrayList4.get(i4)).booleanValue() && aVar2.f3290m >= 0) {
                mo4427c(aVar2.f3290m);
                aVar2.f3290m = -1;
            }
            aVar2.mo4081b();
            i4++;
        }
        if (z2) {
            mo4448k();
        }
    }

    /* renamed from: a */
    private void m4138a(C0714b<C1062d> bVar) {
        int size = bVar.size();
        for (int i = 0; i < size; i++) {
            C1062d dVar = (C1062d) bVar.mo2762b(i);
            if (!dVar.mAdded) {
                View view = dVar.getView();
                dVar.mPostponedAlpha = view.getAlpha();
                view.setAlpha(BitmapDescriptorFactory.HUE_RED);
            }
        }
    }

    /* renamed from: a */
    private int m4134a(ArrayList<C1057a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, C0714b<C1062d> bVar) {
        int i3 = i2;
        for (int i4 = i2 - 1; i4 >= i; i4--) {
            C1057a aVar = (C1057a) arrayList.get(i4);
            boolean booleanValue = ((Boolean) arrayList2.get(i4)).booleanValue();
            if (aVar.mo4090h() && !aVar.mo4076a(arrayList, i4 + 1, i2)) {
                if (this.f3359C == null) {
                    this.f3359C = new ArrayList<>();
                }
                C1097j jVar = new C1097j(aVar, booleanValue);
                this.f3359C.add(jVar);
                aVar.mo4073a((C1068c) jVar);
                if (booleanValue) {
                    aVar.mo4089g();
                } else {
                    aVar.mo4082b(false);
                }
                i3--;
                if (i4 != i3) {
                    arrayList.remove(i4);
                    arrayList.add(i3, aVar);
                }
                m4150b(bVar);
            }
        }
        return i3;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4401a(C1057a aVar, boolean z, boolean z2, boolean z3) {
        if (z) {
            aVar.mo4082b(z3);
        } else {
            aVar.mo4089g();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(aVar);
        arrayList2.add(Boolean.valueOf(z));
        if (z2) {
            C1105p.m4298a(this, arrayList, arrayList2, 0, 1, true);
        }
        if (z3) {
            mo4397a(this.f3373l, true);
        }
        if (this.f3367f != null) {
            int size = this.f3367f.size();
            for (int i = 0; i < size; i++) {
                C1062d dVar = (C1062d) this.f3367f.valueAt(i);
                if (dVar != null && dVar.mView != null && dVar.mIsNewlyAdded && aVar.mo4083b(dVar.mContainerId)) {
                    if (dVar.mPostponedAlpha > BitmapDescriptorFactory.HUE_RED) {
                        dVar.mView.setAlpha(dVar.mPostponedAlpha);
                    }
                    if (z3) {
                        dVar.mPostponedAlpha = BitmapDescriptorFactory.HUE_RED;
                    } else {
                        dVar.mPostponedAlpha = -1.0f;
                        dVar.mIsNewlyAdded = false;
                    }
                }
            }
        }
    }

    /* renamed from: p */
    private C1062d m4157p(C1062d dVar) {
        ViewGroup viewGroup = dVar.mContainer;
        View view = dVar.mView;
        if (viewGroup == null || view == null) {
            return null;
        }
        for (int indexOf = this.f3366e.indexOf(dVar) - 1; indexOf >= 0; indexOf--) {
            C1062d dVar2 = (C1062d) this.f3366e.get(indexOf);
            if (dVar2.mContainer == viewGroup && dVar2.mView != null) {
                return dVar2;
            }
        }
        return null;
    }

    /* renamed from: b */
    private static void m4152b(ArrayList<C1057a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        while (i < i2) {
            C1057a aVar = (C1057a) arrayList.get(i);
            boolean z = true;
            if (((Boolean) arrayList2.get(i)).booleanValue()) {
                aVar.mo4071a(-1);
                if (i != i2 - 1) {
                    z = false;
                }
                aVar.mo4082b(z);
            } else {
                aVar.mo4071a(1);
                aVar.mo4089g();
            }
            i++;
        }
    }

    /* renamed from: b */
    private void m4150b(C0714b<C1062d> bVar) {
        if (this.f3373l >= 1) {
            int min = Math.min(this.f3373l, 3);
            int size = this.f3366e.size();
            for (int i = 0; i < size; i++) {
                C1062d dVar = (C1062d) this.f3366e.get(i);
                if (dVar.mState < min) {
                    mo4403a(dVar, min, dVar.getNextAnim(), dVar.getNextTransition(), false);
                    if (dVar.mView != null && !dVar.mHidden && dVar.mIsNewlyAdded) {
                        bVar.add(dVar);
                    }
                }
            }
        }
    }

    /* renamed from: C */
    private void m4131C() {
        if (this.f3359C != null) {
            while (!this.f3359C.isEmpty()) {
                ((C1097j) this.f3359C.remove(0)).mo4486d();
            }
        }
    }

    /* renamed from: D */
    private void m4132D() {
        int size = this.f3367f == null ? 0 : this.f3367f.size();
        for (int i = 0; i < size; i++) {
            C1062d dVar = (C1062d) this.f3367f.valueAt(i);
            if (dVar != null) {
                if (dVar.getAnimatingAway() != null) {
                    int stateAfterAnimating = dVar.getStateAfterAnimating();
                    View animatingAway = dVar.getAnimatingAway();
                    Animation animation = animatingAway.getAnimation();
                    if (animation != null) {
                        animation.cancel();
                        animatingAway.clearAnimation();
                    }
                    dVar.setAnimatingAway(null);
                    mo4403a(dVar, stateAfterAnimating, 0, 0, false);
                } else if (dVar.getAnimator() != null) {
                    dVar.getAnimator().end();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003b, code lost:
        return false;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m4154c(java.util.ArrayList<androidx.fragment.p081a.C1057a> r5, java.util.ArrayList<java.lang.Boolean> r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.ArrayList<androidx.fragment.a.j$h> r0 = r4.f3363b     // Catch:{ all -> 0x003c }
            r1 = 0
            if (r0 == 0) goto L_0x003a
            java.util.ArrayList<androidx.fragment.a.j$h> r0 = r4.f3363b     // Catch:{ all -> 0x003c }
            int r0 = r0.size()     // Catch:{ all -> 0x003c }
            if (r0 != 0) goto L_0x000f
            goto L_0x003a
        L_0x000f:
            java.util.ArrayList<androidx.fragment.a.j$h> r0 = r4.f3363b     // Catch:{ all -> 0x003c }
            int r0 = r0.size()     // Catch:{ all -> 0x003c }
            r2 = 0
        L_0x0016:
            if (r1 >= r0) goto L_0x0028
            java.util.ArrayList<androidx.fragment.a.j$h> r3 = r4.f3363b     // Catch:{ all -> 0x003c }
            java.lang.Object r3 = r3.get(r1)     // Catch:{ all -> 0x003c }
            androidx.fragment.a.j$h r3 = (androidx.fragment.p081a.C1081j.C1095h) r3     // Catch:{ all -> 0x003c }
            boolean r3 = r3.mo4077a(r5, r6)     // Catch:{ all -> 0x003c }
            r2 = r2 | r3
            int r1 = r1 + 1
            goto L_0x0016
        L_0x0028:
            java.util.ArrayList<androidx.fragment.a.j$h> r5 = r4.f3363b     // Catch:{ all -> 0x003c }
            r5.clear()     // Catch:{ all -> 0x003c }
            androidx.fragment.a.h r5 = r4.f3374m     // Catch:{ all -> 0x003c }
            android.os.Handler r5 = r5.mo4367j()     // Catch:{ all -> 0x003c }
            java.lang.Runnable r6 = r4.f3361E     // Catch:{ all -> 0x003c }
            r5.removeCallbacks(r6)     // Catch:{ all -> 0x003c }
            monitor-exit(r4)     // Catch:{ all -> 0x003c }
            return r2
        L_0x003a:
            monitor-exit(r4)     // Catch:{ all -> 0x003c }
            return r1
        L_0x003c:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x003c }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.p081a.C1081j.m4154c(java.util.ArrayList, java.util.ArrayList):boolean");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public void mo4446j() {
        if (this.f3383w) {
            this.f3383w = false;
            mo4438g();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: k */
    public void mo4448k() {
        if (this.f3372k != null) {
            for (int i = 0; i < this.f3372k.size(); i++) {
                ((C1080b) this.f3372k.get(i)).mo4392a();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo4419b(C1057a aVar) {
        if (this.f3368g == null) {
            this.f3368g = new ArrayList<>();
        }
        this.f3368g.add(aVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo4415a(ArrayList<C1057a> arrayList, ArrayList<Boolean> arrayList2, String str, int i, int i2) {
        int i3;
        if (this.f3368g == null) {
            return false;
        }
        if (str == null && i < 0 && (i2 & 1) == 0) {
            int size = this.f3368g.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.f3368g.remove(size));
            arrayList2.add(Boolean.valueOf(true));
        } else {
            if (str != null || i >= 0) {
                int size2 = this.f3368g.size() - 1;
                while (i3 >= 0) {
                    C1057a aVar = (C1057a) this.f3368g.get(i3);
                    if ((str != null && str.equals(aVar.mo4091i())) || (i >= 0 && i == aVar.f3290m)) {
                        break;
                    }
                    size2 = i3 - 1;
                }
                if (i3 < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    i3--;
                    while (i3 >= 0) {
                        C1057a aVar2 = (C1057a) this.f3368g.get(i3);
                        if ((str == null || !str.equals(aVar2.mo4091i())) && (i < 0 || i != aVar2.f3290m)) {
                            break;
                        }
                        i3--;
                    }
                }
            } else {
                i3 = -1;
            }
            if (i3 == this.f3368g.size() - 1) {
                return false;
            }
            for (int size3 = this.f3368g.size() - 1; size3 > i3; size3--) {
                arrayList.add(this.f3368g.remove(size3));
                arrayList2.add(Boolean.valueOf(true));
            }
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: l */
    public C1098k mo4450l() {
        m4140a(this.f3360D);
        return this.f3360D;
    }

    /* renamed from: a */
    private static void m4140a(C1098k kVar) {
        if (kVar != null) {
            List<C1062d> a = kVar.mo4488a();
            if (a != null) {
                for (C1062d dVar : a) {
                    dVar.mRetaining = true;
                }
            }
            List<C1098k> b = kVar.mo4489b();
            if (b != null) {
                for (C1098k a2 : b) {
                    m4140a(a2);
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: m */
    public void mo4452m() {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        C1098k kVar;
        if (this.f3367f != null) {
            arrayList3 = null;
            arrayList2 = null;
            arrayList = null;
            for (int i = 0; i < this.f3367f.size(); i++) {
                C1062d dVar = (C1062d) this.f3367f.valueAt(i);
                if (dVar != null) {
                    if (dVar.mRetainInstance) {
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList();
                        }
                        arrayList3.add(dVar);
                        dVar.mTargetIndex = dVar.mTarget != null ? dVar.mTarget.mIndex : -1;
                        if (f3355a) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("retainNonConfig: keeping retained ");
                            sb.append(dVar);
                            Log.v("FragmentManager", sb.toString());
                        }
                    }
                    if (dVar.mChildFragmentManager != null) {
                        dVar.mChildFragmentManager.mo4452m();
                        kVar = dVar.mChildFragmentManager.f3360D;
                    } else {
                        kVar = dVar.mChildNonConfig;
                    }
                    if (arrayList2 == null && kVar != null) {
                        arrayList2 = new ArrayList(this.f3367f.size());
                        for (int i2 = 0; i2 < i; i2++) {
                            arrayList2.add(null);
                        }
                    }
                    if (arrayList2 != null) {
                        arrayList2.add(kVar);
                    }
                    if (arrayList == null && dVar.mViewModelStore != null) {
                        arrayList = new ArrayList(this.f3367f.size());
                        for (int i3 = 0; i3 < i; i3++) {
                            arrayList.add(null);
                        }
                    }
                    if (arrayList != null) {
                        arrayList.add(dVar.mViewModelStore);
                    }
                }
            }
        } else {
            arrayList3 = null;
            arrayList2 = null;
            arrayList = null;
        }
        if (arrayList3 == null && arrayList2 == null && arrayList == null) {
            this.f3360D = null;
        } else {
            this.f3360D = new C1098k(arrayList3, arrayList2, arrayList);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: m */
    public void mo4453m(C1062d dVar) {
        if (dVar.mInnerView != null) {
            if (this.f3358B == null) {
                this.f3358B = new SparseArray<>();
            } else {
                this.f3358B.clear();
            }
            dVar.mInnerView.saveHierarchyState(this.f3358B);
            if (this.f3358B.size() > 0) {
                dVar.mSavedViewState = this.f3358B;
                this.f3358B = null;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: n */
    public Bundle mo4454n(C1062d dVar) {
        Bundle bundle;
        if (this.f3357A == null) {
            this.f3357A = new Bundle();
        }
        dVar.performSaveInstanceState(this.f3357A);
        mo4432d(dVar, this.f3357A, false);
        if (!this.f3357A.isEmpty()) {
            bundle = this.f3357A;
            this.f3357A = null;
        } else {
            bundle = null;
        }
        if (dVar.mView != null) {
            mo4453m(dVar);
        }
        if (dVar.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", dVar.mSavedViewState);
        }
        if (!dVar.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", dVar.mUserVisibleHint);
        }
        return bundle;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: n */
    public Parcelable mo4455n() {
        int[] iArr;
        m4131C();
        m4132D();
        mo4445i();
        this.f3379s = true;
        C1059b[] bVarArr = null;
        this.f3360D = null;
        if (this.f3367f == null || this.f3367f.size() <= 0) {
            return null;
        }
        int size = this.f3367f.size();
        C1102n[] nVarArr = new C1102n[size];
        boolean z = false;
        for (int i = 0; i < size; i++) {
            C1062d dVar = (C1062d) this.f3367f.valueAt(i);
            if (dVar != null) {
                if (dVar.mIndex < 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failure saving state: active ");
                    sb.append(dVar);
                    sb.append(" has cleared index: ");
                    sb.append(dVar.mIndex);
                    m4141a((RuntimeException) new IllegalStateException(sb.toString()));
                }
                C1102n nVar = new C1102n(dVar);
                nVarArr[i] = nVar;
                if (dVar.mState <= 0 || nVar.f3442k != null) {
                    nVar.f3442k = dVar.mSavedFragmentState;
                } else {
                    nVar.f3442k = mo4454n(dVar);
                    if (dVar.mTarget != null) {
                        if (dVar.mTarget.mIndex < 0) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Failure saving state: ");
                            sb2.append(dVar);
                            sb2.append(" has target not in fragment manager: ");
                            sb2.append(dVar.mTarget);
                            m4141a((RuntimeException) new IllegalStateException(sb2.toString()));
                        }
                        if (nVar.f3442k == null) {
                            nVar.f3442k = new Bundle();
                        }
                        mo4399a(nVar.f3442k, "android:target_state", dVar.mTarget);
                        if (dVar.mTargetRequestCode != 0) {
                            nVar.f3442k.putInt("android:target_req_state", dVar.mTargetRequestCode);
                        }
                    }
                }
                if (f3355a) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Saved state of ");
                    sb3.append(dVar);
                    sb3.append(": ");
                    sb3.append(nVar.f3442k);
                    Log.v("FragmentManager", sb3.toString());
                }
                z = true;
            }
        }
        if (!z) {
            if (f3355a) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        int size2 = this.f3366e.size();
        if (size2 > 0) {
            iArr = new int[size2];
            for (int i2 = 0; i2 < size2; i2++) {
                iArr[i2] = ((C1062d) this.f3366e.get(i2)).mIndex;
                if (iArr[i2] < 0) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Failure saving state: active ");
                    sb4.append(this.f3366e.get(i2));
                    sb4.append(" has cleared index: ");
                    sb4.append(iArr[i2]);
                    m4141a((RuntimeException) new IllegalStateException(sb4.toString()));
                }
                if (f3355a) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("saveAllState: adding fragment #");
                    sb5.append(i2);
                    sb5.append(": ");
                    sb5.append(this.f3366e.get(i2));
                    Log.v("FragmentManager", sb5.toString());
                }
            }
        } else {
            iArr = null;
        }
        if (this.f3368g != null) {
            int size3 = this.f3368g.size();
            if (size3 > 0) {
                bVarArr = new C1059b[size3];
                for (int i3 = 0; i3 < size3; i3++) {
                    bVarArr[i3] = new C1059b((C1057a) this.f3368g.get(i3));
                    if (f3355a) {
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("saveAllState: adding back stack #");
                        sb6.append(i3);
                        sb6.append(": ");
                        sb6.append(this.f3368g.get(i3));
                        Log.v("FragmentManager", sb6.toString());
                    }
                }
            }
        }
        C1099l lVar = new C1099l();
        lVar.f3424a = nVarArr;
        lVar.f3425b = iArr;
        lVar.f3426c = bVarArr;
        if (this.f3377p != null) {
            lVar.f3427d = this.f3377p.mIndex;
        }
        lVar.f3428e = this.f3365d;
        mo4452m();
        return lVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4400a(Parcelable parcelable, C1098k kVar) {
        List list;
        List list2;
        if (parcelable != null) {
            C1099l lVar = (C1099l) parcelable;
            if (lVar.f3424a != null) {
                if (kVar != null) {
                    List a = kVar.mo4488a();
                    list2 = kVar.mo4489b();
                    list = kVar.mo4490c();
                    int size = a != null ? a.size() : 0;
                    for (int i = 0; i < size; i++) {
                        C1062d dVar = (C1062d) a.get(i);
                        if (f3355a) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("restoreAllState: re-attaching retained ");
                            sb.append(dVar);
                            Log.v("FragmentManager", sb.toString());
                        }
                        int i2 = 0;
                        while (i2 < lVar.f3424a.length && lVar.f3424a[i2].f3433b != dVar.mIndex) {
                            i2++;
                        }
                        if (i2 == lVar.f3424a.length) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Could not find active fragment with index ");
                            sb2.append(dVar.mIndex);
                            m4141a((RuntimeException) new IllegalStateException(sb2.toString()));
                        }
                        C1102n nVar = lVar.f3424a[i2];
                        nVar.f3443l = dVar;
                        dVar.mSavedViewState = null;
                        dVar.mBackStackNesting = 0;
                        dVar.mInLayout = false;
                        dVar.mAdded = false;
                        dVar.mTarget = null;
                        if (nVar.f3442k != null) {
                            nVar.f3442k.setClassLoader(this.f3374m.mo4366i().getClassLoader());
                            dVar.mSavedViewState = nVar.f3442k.getSparseParcelableArray("android:view_state");
                            dVar.mSavedFragmentState = nVar.f3442k;
                        }
                    }
                } else {
                    list2 = null;
                    list = null;
                }
                this.f3367f = new SparseArray<>(lVar.f3424a.length);
                int i3 = 0;
                while (i3 < lVar.f3424a.length) {
                    C1102n nVar2 = lVar.f3424a[i3];
                    if (nVar2 != null) {
                        C1062d a2 = nVar2.mo4507a(this.f3374m, this.f3375n, this.f3376o, (list2 == null || i3 >= list2.size()) ? null : (C1098k) list2.get(i3), (list == null || i3 >= list.size()) ? null : (C1191r) list.get(i3));
                        if (f3355a) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("restoreAllState: active #");
                            sb3.append(i3);
                            sb3.append(": ");
                            sb3.append(a2);
                            Log.v("FragmentManager", sb3.toString());
                        }
                        this.f3367f.put(a2.mIndex, a2);
                        nVar2.f3443l = null;
                    }
                    i3++;
                }
                if (kVar != null) {
                    List a3 = kVar.mo4488a();
                    int size2 = a3 != null ? a3.size() : 0;
                    for (int i4 = 0; i4 < size2; i4++) {
                        C1062d dVar2 = (C1062d) a3.get(i4);
                        if (dVar2.mTargetIndex >= 0) {
                            dVar2.mTarget = (C1062d) this.f3367f.get(dVar2.mTargetIndex);
                            if (dVar2.mTarget == null) {
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append("Re-attaching retained fragment ");
                                sb4.append(dVar2);
                                sb4.append(" target no longer exists: ");
                                sb4.append(dVar2.mTargetIndex);
                                Log.w("FragmentManager", sb4.toString());
                            }
                        }
                    }
                }
                this.f3366e.clear();
                if (lVar.f3425b != null) {
                    int i5 = 0;
                    while (i5 < lVar.f3425b.length) {
                        C1062d dVar3 = (C1062d) this.f3367f.get(lVar.f3425b[i5]);
                        if (dVar3 == null) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("No instantiated fragment for index #");
                            sb5.append(lVar.f3425b[i5]);
                            m4141a((RuntimeException) new IllegalStateException(sb5.toString()));
                        }
                        dVar3.mAdded = true;
                        if (f3355a) {
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("restoreAllState: added #");
                            sb6.append(i5);
                            sb6.append(": ");
                            sb6.append(dVar3);
                            Log.v("FragmentManager", sb6.toString());
                        }
                        if (!this.f3366e.contains(dVar3)) {
                            synchronized (this.f3366e) {
                                this.f3366e.add(dVar3);
                            }
                            i5++;
                        } else {
                            throw new IllegalStateException("Already added!");
                        }
                    }
                }
                if (lVar.f3426c != null) {
                    this.f3368g = new ArrayList<>(lVar.f3426c.length);
                    for (int i6 = 0; i6 < lVar.f3426c.length; i6++) {
                        C1057a a4 = lVar.f3426c[i6].mo4093a(this);
                        if (f3355a) {
                            StringBuilder sb7 = new StringBuilder();
                            sb7.append("restoreAllState: back stack #");
                            sb7.append(i6);
                            sb7.append(" (index ");
                            sb7.append(a4.f3290m);
                            sb7.append("): ");
                            sb7.append(a4);
                            Log.v("FragmentManager", sb7.toString());
                            PrintWriter printWriter = new PrintWriter(new C0924b("FragmentManager"));
                            a4.mo4075a("  ", printWriter, false);
                            printWriter.close();
                        }
                        this.f3368g.add(a4);
                        if (a4.f3290m >= 0) {
                            mo4396a(a4.f3290m, a4);
                        }
                    }
                } else {
                    this.f3368g = null;
                }
                if (lVar.f3427d >= 0) {
                    this.f3377p = (C1062d) this.f3367f.get(lVar.f3427d);
                }
                this.f3365d = lVar.f3428e;
            }
        }
    }

    /* renamed from: E */
    private void m4133E() {
        if (this.f3367f != null) {
            for (int size = this.f3367f.size() - 1; size >= 0; size--) {
                if (this.f3367f.valueAt(size) == null) {
                    this.f3367f.delete(this.f3367f.keyAt(size));
                }
            }
        }
    }

    /* renamed from: a */
    public void mo4408a(C1077h hVar, C1075f fVar, C1062d dVar) {
        if (this.f3374m == null) {
            this.f3374m = hVar;
            this.f3375n = fVar;
            this.f3376o = dVar;
            return;
        }
        throw new IllegalStateException("Already attached");
    }

    /* renamed from: o */
    public void mo4456o() {
        this.f3360D = null;
        this.f3379s = false;
        this.f3380t = false;
        int size = this.f3366e.size();
        for (int i = 0; i < size; i++) {
            C1062d dVar = (C1062d) this.f3366e.get(i);
            if (dVar != null) {
                dVar.noteStateNotSaved();
            }
        }
    }

    /* renamed from: p */
    public void mo4460p() {
        this.f3379s = false;
        this.f3380t = false;
        m4156e(1);
    }

    /* renamed from: q */
    public void mo4461q() {
        this.f3379s = false;
        this.f3380t = false;
        m4156e(2);
    }

    /* renamed from: r */
    public void mo4462r() {
        this.f3379s = false;
        this.f3380t = false;
        m4156e(3);
    }

    /* renamed from: s */
    public void mo4463s() {
        this.f3379s = false;
        this.f3380t = false;
        m4156e(4);
    }

    /* renamed from: t */
    public void mo4464t() {
        m4156e(3);
    }

    /* renamed from: u */
    public void mo4466u() {
        this.f3380t = true;
        m4156e(2);
    }

    /* renamed from: v */
    public void mo4467v() {
        m4156e(1);
    }

    /* renamed from: w */
    public void mo4468w() {
        this.f3381u = true;
        mo4445i();
        m4156e(0);
        this.f3374m = null;
        this.f3375n = null;
        this.f3376o = null;
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: e */
    private void m4156e(int i) {
        try {
            this.f3364c = true;
            mo4397a(i, false);
            this.f3364c = false;
            mo4445i();
        } catch (Throwable th) {
            this.f3364c = false;
            throw th;
        }
    }

    /* renamed from: a */
    public void mo4410a(boolean z) {
        for (int size = this.f3366e.size() - 1; size >= 0; size--) {
            C1062d dVar = (C1062d) this.f3366e.get(size);
            if (dVar != null) {
                dVar.performMultiWindowModeChanged(z);
            }
        }
    }

    /* renamed from: b */
    public void mo4425b(boolean z) {
        for (int size = this.f3366e.size() - 1; size >= 0; size--) {
            C1062d dVar = (C1062d) this.f3366e.get(size);
            if (dVar != null) {
                dVar.performPictureInPictureModeChanged(z);
            }
        }
    }

    /* renamed from: a */
    public void mo4398a(Configuration configuration) {
        for (int i = 0; i < this.f3366e.size(); i++) {
            C1062d dVar = (C1062d) this.f3366e.get(i);
            if (dVar != null) {
                dVar.performConfigurationChanged(configuration);
            }
        }
    }

    /* renamed from: x */
    public void mo4469x() {
        for (int i = 0; i < this.f3366e.size(); i++) {
            C1062d dVar = (C1062d) this.f3366e.get(i);
            if (dVar != null) {
                dVar.performLowMemory();
            }
        }
    }

    /* renamed from: a */
    public boolean mo4413a(Menu menu, MenuInflater menuInflater) {
        if (this.f3373l < 1) {
            return false;
        }
        ArrayList<C1062d> arrayList = null;
        boolean z = false;
        for (int i = 0; i < this.f3366e.size(); i++) {
            C1062d dVar = (C1062d) this.f3366e.get(i);
            if (dVar != null && dVar.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(dVar);
                z = true;
            }
        }
        if (this.f3369h != null) {
            for (int i2 = 0; i2 < this.f3369h.size(); i2++) {
                C1062d dVar2 = (C1062d) this.f3369h.get(i2);
                if (arrayList == null || !arrayList.contains(dVar2)) {
                    dVar2.onDestroyOptionsMenu();
                }
            }
        }
        this.f3369h = arrayList;
        return z;
    }

    /* renamed from: a */
    public boolean mo4412a(Menu menu) {
        if (this.f3373l < 1) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.f3366e.size(); i++) {
            C1062d dVar = (C1062d) this.f3366e.get(i);
            if (dVar != null && dVar.performPrepareOptionsMenu(menu)) {
                z = true;
            }
        }
        return z;
    }

    /* renamed from: a */
    public boolean mo4414a(MenuItem menuItem) {
        if (this.f3373l < 1) {
            return false;
        }
        for (int i = 0; i < this.f3366e.size(); i++) {
            C1062d dVar = (C1062d) this.f3366e.get(i);
            if (dVar != null && dVar.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public boolean mo4426b(MenuItem menuItem) {
        if (this.f3373l < 1) {
            return false;
        }
        for (int i = 0; i < this.f3366e.size(); i++) {
            C1062d dVar = (C1062d) this.f3366e.get(i);
            if (dVar != null && dVar.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public void mo4418b(Menu menu) {
        if (this.f3373l >= 1) {
            for (int i = 0; i < this.f3366e.size(); i++) {
                C1062d dVar = (C1062d) this.f3366e.get(i);
                if (dVar != null) {
                    dVar.performOptionsMenuClosed(menu);
                }
            }
        }
    }

    /* renamed from: o */
    public void mo4457o(C1062d dVar) {
        if (dVar == null || (this.f3367f.get(dVar.mIndex) == dVar && (dVar.mHost == null || dVar.getFragmentManager() == this))) {
            this.f3377p = dVar;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(dVar);
        sb.append(" is not an active fragment of FragmentManager ");
        sb.append(this);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: y */
    public C1062d mo4470y() {
        return this.f3377p;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4404a(C1062d dVar, Context context, boolean z) {
        if (this.f3376o != null) {
            C1078i fragmentManager = this.f3376o.getFragmentManager();
            if (fragmentManager instanceof C1081j) {
                ((C1081j) fragmentManager).mo4404a(dVar, context, true);
            }
        }
        Iterator it = this.f3362J.iterator();
        while (it.hasNext()) {
            C1093f fVar = (C1093f) it.next();
            if (!z || fVar.f3412b) {
                fVar.f3411a.mo4379a((C1078i) this, dVar, context);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo4421b(C1062d dVar, Context context, boolean z) {
        if (this.f3376o != null) {
            C1078i fragmentManager = this.f3376o.getFragmentManager();
            if (fragmentManager instanceof C1081j) {
                ((C1081j) fragmentManager).mo4421b(dVar, context, true);
            }
        }
        Iterator it = this.f3362J.iterator();
        while (it.hasNext()) {
            C1093f fVar = (C1093f) it.next();
            if (!z || fVar.f3412b) {
                fVar.f3411a.mo4383b((C1078i) this, dVar, context);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4405a(C1062d dVar, Bundle bundle, boolean z) {
        if (this.f3376o != null) {
            C1078i fragmentManager = this.f3376o.getFragmentManager();
            if (fragmentManager instanceof C1081j) {
                ((C1081j) fragmentManager).mo4405a(dVar, bundle, true);
            }
        }
        Iterator it = this.f3362J.iterator();
        while (it.hasNext()) {
            C1093f fVar = (C1093f) it.next();
            if (!z || fVar.f3412b) {
                fVar.f3411a.mo4380a((C1078i) this, dVar, bundle);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo4422b(C1062d dVar, Bundle bundle, boolean z) {
        if (this.f3376o != null) {
            C1078i fragmentManager = this.f3376o.getFragmentManager();
            if (fragmentManager instanceof C1081j) {
                ((C1081j) fragmentManager).mo4422b(dVar, bundle, true);
            }
        }
        Iterator it = this.f3362J.iterator();
        while (it.hasNext()) {
            C1093f fVar = (C1093f) it.next();
            if (!z || fVar.f3412b) {
                fVar.f3411a.mo4384b((C1078i) this, dVar, bundle);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo4429c(C1062d dVar, Bundle bundle, boolean z) {
        if (this.f3376o != null) {
            C1078i fragmentManager = this.f3376o.getFragmentManager();
            if (fragmentManager instanceof C1081j) {
                ((C1081j) fragmentManager).mo4429c(dVar, bundle, true);
            }
        }
        Iterator it = this.f3362J.iterator();
        while (it.hasNext()) {
            C1093f fVar = (C1093f) it.next();
            if (!z || fVar.f3412b) {
                fVar.f3411a.mo4386c(this, dVar, bundle);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4406a(C1062d dVar, View view, Bundle bundle, boolean z) {
        if (this.f3376o != null) {
            C1078i fragmentManager = this.f3376o.getFragmentManager();
            if (fragmentManager instanceof C1081j) {
                ((C1081j) fragmentManager).mo4406a(dVar, view, bundle, true);
            }
        }
        Iterator it = this.f3362J.iterator();
        while (it.hasNext()) {
            C1093f fVar = (C1093f) it.next();
            if (!z || fVar.f3412b) {
                fVar.f3411a.mo4381a(this, dVar, view, bundle);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo4423b(C1062d dVar, boolean z) {
        if (this.f3376o != null) {
            C1078i fragmentManager = this.f3376o.getFragmentManager();
            if (fragmentManager instanceof C1081j) {
                ((C1081j) fragmentManager).mo4423b(dVar, true);
            }
        }
        Iterator it = this.f3362J.iterator();
        while (it.hasNext()) {
            C1093f fVar = (C1093f) it.next();
            if (!z || fVar.f3412b) {
                fVar.f3411a.mo4378a(this, dVar);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo4430c(C1062d dVar, boolean z) {
        if (this.f3376o != null) {
            C1078i fragmentManager = this.f3376o.getFragmentManager();
            if (fragmentManager instanceof C1081j) {
                ((C1081j) fragmentManager).mo4430c(dVar, true);
            }
        }
        Iterator it = this.f3362J.iterator();
        while (it.hasNext()) {
            C1093f fVar = (C1093f) it.next();
            if (!z || fVar.f3412b) {
                fVar.f3411a.mo4382b(this, dVar);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo4433d(C1062d dVar, boolean z) {
        if (this.f3376o != null) {
            C1078i fragmentManager = this.f3376o.getFragmentManager();
            if (fragmentManager instanceof C1081j) {
                ((C1081j) fragmentManager).mo4433d(dVar, true);
            }
        }
        Iterator it = this.f3362J.iterator();
        while (it.hasNext()) {
            C1093f fVar = (C1093f) it.next();
            if (!z || fVar.f3412b) {
                fVar.f3411a.mo4385c(this, dVar);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo4435e(C1062d dVar, boolean z) {
        if (this.f3376o != null) {
            C1078i fragmentManager = this.f3376o.getFragmentManager();
            if (fragmentManager instanceof C1081j) {
                ((C1081j) fragmentManager).mo4435e(dVar, true);
            }
        }
        Iterator it = this.f3362J.iterator();
        while (it.hasNext()) {
            C1093f fVar = (C1093f) it.next();
            if (!z || fVar.f3412b) {
                fVar.f3411a.mo4387d(this, dVar);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo4432d(C1062d dVar, Bundle bundle, boolean z) {
        if (this.f3376o != null) {
            C1078i fragmentManager = this.f3376o.getFragmentManager();
            if (fragmentManager instanceof C1081j) {
                ((C1081j) fragmentManager).mo4432d(dVar, bundle, true);
            }
        }
        Iterator it = this.f3362J.iterator();
        while (it.hasNext()) {
            C1093f fVar = (C1093f) it.next();
            if (!z || fVar.f3412b) {
                fVar.f3411a.mo4388d(this, dVar, bundle);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public void mo4437f(C1062d dVar, boolean z) {
        if (this.f3376o != null) {
            C1078i fragmentManager = this.f3376o.getFragmentManager();
            if (fragmentManager instanceof C1081j) {
                ((C1081j) fragmentManager).mo4437f(dVar, true);
            }
        }
        Iterator it = this.f3362J.iterator();
        while (it.hasNext()) {
            C1093f fVar = (C1093f) it.next();
            if (!z || fVar.f3412b) {
                fVar.f3411a.mo4389e(this, dVar);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public void mo4440g(C1062d dVar, boolean z) {
        if (this.f3376o != null) {
            C1078i fragmentManager = this.f3376o.getFragmentManager();
            if (fragmentManager instanceof C1081j) {
                ((C1081j) fragmentManager).mo4440g(dVar, true);
            }
        }
        Iterator it = this.f3362J.iterator();
        while (it.hasNext()) {
            C1093f fVar = (C1093f) it.next();
            if (!z || fVar.f3412b) {
                fVar.f3411a.mo4390f(this, dVar);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public void mo4443h(C1062d dVar, boolean z) {
        if (this.f3376o != null) {
            C1078i fragmentManager = this.f3376o.getFragmentManager();
            if (fragmentManager instanceof C1081j) {
                ((C1081j) fragmentManager).mo4443h(dVar, true);
            }
        }
        Iterator it = this.f3362J.iterator();
        while (it.hasNext()) {
            C1093f fVar = (C1093f) it.next();
            if (!z || fVar.f3412b) {
                fVar.f3411a.mo4391g(this, dVar);
            }
        }
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        C1062d dVar;
        Context context2 = context;
        AttributeSet attributeSet2 = attributeSet;
        String str2 = str;
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet2.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet2, C1094g.f3413a);
        int i = 0;
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(0);
        }
        String str3 = attributeValue;
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (!C1062d.isSupportFragmentClass(this.f3374m.mo4366i(), str3)) {
            return null;
        }
        if (view != null) {
            i = view.getId();
        }
        if (i == -1 && resourceId == -1 && string == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(attributeSet.getPositionDescription());
            sb.append(": Must specify unique android:id, android:tag, or have a parent with an id for ");
            sb.append(str3);
            throw new IllegalArgumentException(sb.toString());
        }
        C1062d b = resourceId != -1 ? mo4416b(resourceId) : null;
        if (b == null && string != null) {
            b = mo4369a(string);
        }
        if (b == null && i != -1) {
            b = mo4416b(i);
        }
        if (f3355a) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onCreateView: id=0x");
            sb2.append(Integer.toHexString(resourceId));
            sb2.append(" fname=");
            sb2.append(str3);
            sb2.append(" existing=");
            sb2.append(b);
            Log.v("FragmentManager", sb2.toString());
        }
        if (b == null) {
            C1062d a = this.f3375n.mo4278a(context2, str3, null);
            a.mFromLayout = true;
            a.mFragmentId = resourceId != 0 ? resourceId : i;
            a.mContainerId = i;
            a.mTag = string;
            a.mInLayout = true;
            a.mFragmentManager = this;
            a.mHost = this.f3374m;
            a.onInflate(this.f3374m.mo4366i(), attributeSet2, a.mSavedFragmentState);
            mo4407a(a, true);
            dVar = a;
        } else if (!b.mInLayout) {
            b.mInLayout = true;
            b.mHost = this.f3374m;
            if (!b.mRetaining) {
                b.onInflate(this.f3374m.mo4366i(), attributeSet2, b.mSavedFragmentState);
            }
            dVar = b;
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(attributeSet.getPositionDescription());
            sb3.append(": Duplicate id 0x");
            sb3.append(Integer.toHexString(resourceId));
            sb3.append(", tag ");
            sb3.append(string);
            sb3.append(", or parent id 0x");
            sb3.append(Integer.toHexString(i));
            sb3.append(" with another fragment for ");
            sb3.append(str3);
            throw new IllegalArgumentException(sb3.toString());
        }
        if (this.f3373l >= 1 || !dVar.mFromLayout) {
            mo4420b(dVar);
        } else {
            mo4403a(dVar, 1, 0, 0, false);
        }
        if (dVar.mView != null) {
            if (resourceId != 0) {
                dVar.mView.setId(resourceId);
            }
            if (dVar.mView.getTag() == null) {
                dVar.mView.setTag(string);
            }
            return dVar.mView;
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append("Fragment ");
        sb4.append(str3);
        sb4.append(" did not create a view.");
        throw new IllegalStateException(sb4.toString());
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
