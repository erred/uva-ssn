package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import androidx.core.content.p066a.C0890g;
import androidx.core.p070g.C0962r;
import androidx.p052b.C0712a;
import androidx.p052b.C0717d;
import androidx.p052b.C0725g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: androidx.transition.m */
/* compiled from: Transition */
public abstract class C1407m implements Cloneable {
    static final boolean DBG = false;
    private static final int[] DEFAULT_MATCH_ORDER = {2, 1, 3, 4};
    private static final String LOG_TAG = "Transition";
    private static final int MATCH_FIRST = 1;
    public static final int MATCH_ID = 3;
    private static final String MATCH_ID_STR = "id";
    public static final int MATCH_INSTANCE = 1;
    private static final String MATCH_INSTANCE_STR = "instance";
    public static final int MATCH_ITEM_ID = 4;
    private static final String MATCH_ITEM_ID_STR = "itemId";
    private static final int MATCH_LAST = 4;
    public static final int MATCH_NAME = 2;
    private static final String MATCH_NAME_STR = "name";
    private static final C1401g STRAIGHT_PATH_MOTION = new C1401g() {
        /* renamed from: a */
        public Path mo5782a(float f, float f2, float f3, float f4) {
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f3, f4);
            return path;
        }
    };
    private static ThreadLocal<C0712a<Animator, C1411a>> sRunningAnimators = new ThreadLocal<>();
    private ArrayList<Animator> mAnimators = new ArrayList<>();
    boolean mCanRemoveViews = false;
    ArrayList<Animator> mCurrentAnimators = new ArrayList<>();
    long mDuration = -1;
    private C1425u mEndValues = new C1425u();
    private ArrayList<C1424t> mEndValuesList;
    private boolean mEnded = false;
    private C1413c mEpicenterCallback;
    private TimeInterpolator mInterpolator = null;
    private ArrayList<C1414d> mListeners = null;
    private int[] mMatchOrder = DEFAULT_MATCH_ORDER;
    private String mName = getClass().getName();
    private C0712a<String, String> mNameOverrides;
    private int mNumInstances = 0;
    C1420q mParent = null;
    private C1401g mPathMotion = STRAIGHT_PATH_MOTION;
    private boolean mPaused = false;
    C1419p mPropagation;
    private ViewGroup mSceneRoot = null;
    private long mStartDelay = -1;
    private C1425u mStartValues = new C1425u();
    private ArrayList<C1424t> mStartValuesList;
    private ArrayList<View> mTargetChildExcludes = null;
    private ArrayList<View> mTargetExcludes = null;
    private ArrayList<Integer> mTargetIdChildExcludes = null;
    private ArrayList<Integer> mTargetIdExcludes = null;
    ArrayList<Integer> mTargetIds = new ArrayList<>();
    private ArrayList<String> mTargetNameExcludes = null;
    private ArrayList<String> mTargetNames = null;
    private ArrayList<Class> mTargetTypeChildExcludes = null;
    private ArrayList<Class> mTargetTypeExcludes = null;
    private ArrayList<Class> mTargetTypes = null;
    ArrayList<View> mTargets = new ArrayList<>();

    /* renamed from: androidx.transition.m$a */
    /* compiled from: Transition */
    private static class C1411a {

        /* renamed from: a */
        View f4210a;

        /* renamed from: b */
        String f4211b;

        /* renamed from: c */
        C1424t f4212c;

        /* renamed from: d */
        C1378am f4213d;

        /* renamed from: e */
        C1407m f4214e;

        C1411a(View view, String str, C1407m mVar, C1378am amVar, C1424t tVar) {
            this.f4210a = view;
            this.f4211b = str;
            this.f4212c = tVar;
            this.f4213d = amVar;
            this.f4214e = mVar;
        }
    }

    /* renamed from: androidx.transition.m$b */
    /* compiled from: Transition */
    private static class C1412b {
        /* renamed from: a */
        static <T> ArrayList<T> m5668a(ArrayList<T> arrayList, T t) {
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            if (!arrayList.contains(t)) {
                arrayList.add(t);
            }
            return arrayList;
        }

        /* renamed from: b */
        static <T> ArrayList<T> m5669b(ArrayList<T> arrayList, T t) {
            if (arrayList == null) {
                return arrayList;
            }
            arrayList.remove(t);
            if (arrayList.isEmpty()) {
                return null;
            }
            return arrayList;
        }
    }

    /* renamed from: androidx.transition.m$c */
    /* compiled from: Transition */
    public static abstract class C1413c {
        /* renamed from: a */
        public abstract Rect mo5781a(C1407m mVar);
    }

    /* renamed from: androidx.transition.m$d */
    /* compiled from: Transition */
    public interface C1414d {
        /* renamed from: a */
        void mo5737a(C1407m mVar);

        /* renamed from: b */
        void mo5738b(C1407m mVar);

        /* renamed from: c */
        void mo5739c(C1407m mVar);

        /* renamed from: d */
        void mo5740d(C1407m mVar);

        /* renamed from: e */
        void mo5741e(C1407m mVar);
    }

    private static boolean isValidMatch(int i) {
        return i >= 1 && i <= 4;
    }

    public abstract void captureEndValues(C1424t tVar);

    public abstract void captureStartValues(C1424t tVar);

    public Animator createAnimator(ViewGroup viewGroup, C1424t tVar, C1424t tVar2) {
        return null;
    }

    public String[] getTransitionProperties() {
        return null;
    }

    public C1407m() {
    }

    public C1407m(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1406l.f4198c);
        XmlResourceParser xmlResourceParser = (XmlResourceParser) attributeSet;
        long a = (long) C0890g.m3299a(obtainStyledAttributes, (XmlPullParser) xmlResourceParser, "duration", 1, -1);
        if (a >= 0) {
            setDuration(a);
        }
        long a2 = (long) C0890g.m3299a(obtainStyledAttributes, (XmlPullParser) xmlResourceParser, "startDelay", 2, -1);
        if (a2 > 0) {
            setStartDelay(a2);
        }
        int c = C0890g.m3307c(obtainStyledAttributes, xmlResourceParser, "interpolator", 0, 0);
        if (c > 0) {
            setInterpolator(AnimationUtils.loadInterpolator(context, c));
        }
        String a3 = C0890g.m3302a(obtainStyledAttributes, (XmlPullParser) xmlResourceParser, "matchOrder", 3);
        if (a3 != null) {
            setMatchOrder(parseMatchOrder(a3));
        }
        obtainStyledAttributes.recycle();
    }

    private static int[] parseMatchOrder(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        int[] iArr = new int[stringTokenizer.countTokens()];
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String trim = stringTokenizer.nextToken().trim();
            if ("id".equalsIgnoreCase(trim)) {
                iArr[i] = 3;
            } else if (MATCH_INSTANCE_STR.equalsIgnoreCase(trim)) {
                iArr[i] = 1;
            } else if (MATCH_NAME_STR.equalsIgnoreCase(trim)) {
                iArr[i] = 2;
            } else if (MATCH_ITEM_ID_STR.equalsIgnoreCase(trim)) {
                iArr[i] = 4;
            } else if (trim.isEmpty()) {
                int[] iArr2 = new int[(iArr.length - 1)];
                System.arraycopy(iArr, 0, iArr2, 0, i);
                i--;
                iArr = iArr2;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Unknown match type in matchOrder: '");
                sb.append(trim);
                sb.append("'");
                throw new InflateException(sb.toString());
            }
            i++;
        }
        return iArr;
    }

    public C1407m setDuration(long j) {
        this.mDuration = j;
        return this;
    }

    public long getDuration() {
        return this.mDuration;
    }

    public C1407m setStartDelay(long j) {
        this.mStartDelay = j;
        return this;
    }

    public long getStartDelay() {
        return this.mStartDelay;
    }

    public C1407m setInterpolator(TimeInterpolator timeInterpolator) {
        this.mInterpolator = timeInterpolator;
        return this;
    }

    public TimeInterpolator getInterpolator() {
        return this.mInterpolator;
    }

    public void setMatchOrder(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            this.mMatchOrder = DEFAULT_MATCH_ORDER;
            return;
        }
        int i = 0;
        while (i < iArr.length) {
            if (!isValidMatch(iArr[i])) {
                throw new IllegalArgumentException("matches contains invalid value");
            } else if (!alreadyContains(iArr, i)) {
                i++;
            } else {
                throw new IllegalArgumentException("matches contains a duplicate value");
            }
        }
        this.mMatchOrder = (int[]) iArr.clone();
    }

    private static boolean alreadyContains(int[] iArr, int i) {
        int i2 = iArr[i];
        for (int i3 = 0; i3 < i; i3++) {
            if (iArr[i3] == i2) {
                return true;
            }
        }
        return false;
    }

    private void matchInstances(C0712a<View, C1424t> aVar, C0712a<View, C1424t> aVar2) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View view = (View) aVar.mo2879b(size);
            if (view != null && isValidTarget(view)) {
                C1424t tVar = (C1424t) aVar2.remove(view);
                if (!(tVar == null || tVar.f4234b == null || !isValidTarget(tVar.f4234b))) {
                    this.mStartValuesList.add((C1424t) aVar.mo2884d(size));
                    this.mEndValuesList.add(tVar);
                }
            }
        }
    }

    private void matchItemIds(C0712a<View, C1424t> aVar, C0712a<View, C1424t> aVar2, C0717d<View> dVar, C0717d<View> dVar2) {
        int b = dVar.mo2782b();
        for (int i = 0; i < b; i++) {
            View view = (View) dVar.mo2787c(i);
            if (view != null && isValidTarget(view)) {
                View view2 = (View) dVar2.mo2779a(dVar.mo2783b(i));
                if (view2 != null && isValidTarget(view2)) {
                    C1424t tVar = (C1424t) aVar.get(view);
                    C1424t tVar2 = (C1424t) aVar2.get(view2);
                    if (!(tVar == null || tVar2 == null)) {
                        this.mStartValuesList.add(tVar);
                        this.mEndValuesList.add(tVar2);
                        aVar.remove(view);
                        aVar2.remove(view2);
                    }
                }
            }
        }
    }

    private void matchIds(C0712a<View, C1424t> aVar, C0712a<View, C1424t> aVar2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            View view = (View) sparseArray.valueAt(i);
            if (view != null && isValidTarget(view)) {
                View view2 = (View) sparseArray2.get(sparseArray.keyAt(i));
                if (view2 != null && isValidTarget(view2)) {
                    C1424t tVar = (C1424t) aVar.get(view);
                    C1424t tVar2 = (C1424t) aVar2.get(view2);
                    if (!(tVar == null || tVar2 == null)) {
                        this.mStartValuesList.add(tVar);
                        this.mEndValuesList.add(tVar2);
                        aVar.remove(view);
                        aVar2.remove(view2);
                    }
                }
            }
        }
    }

    private void matchNames(C0712a<View, C1424t> aVar, C0712a<View, C1424t> aVar2, C0712a<String, View> aVar3, C0712a<String, View> aVar4) {
        int size = aVar3.size();
        for (int i = 0; i < size; i++) {
            View view = (View) aVar3.mo2880c(i);
            if (view != null && isValidTarget(view)) {
                View view2 = (View) aVar4.get(aVar3.mo2879b(i));
                if (view2 != null && isValidTarget(view2)) {
                    C1424t tVar = (C1424t) aVar.get(view);
                    C1424t tVar2 = (C1424t) aVar2.get(view2);
                    if (!(tVar == null || tVar2 == null)) {
                        this.mStartValuesList.add(tVar);
                        this.mEndValuesList.add(tVar2);
                        aVar.remove(view);
                        aVar2.remove(view2);
                    }
                }
            }
        }
    }

    private void addUnmatched(C0712a<View, C1424t> aVar, C0712a<View, C1424t> aVar2) {
        for (int i = 0; i < aVar.size(); i++) {
            C1424t tVar = (C1424t) aVar.mo2880c(i);
            if (isValidTarget(tVar.f4234b)) {
                this.mStartValuesList.add(tVar);
                this.mEndValuesList.add(null);
            }
        }
        for (int i2 = 0; i2 < aVar2.size(); i2++) {
            C1424t tVar2 = (C1424t) aVar2.mo2880c(i2);
            if (isValidTarget(tVar2.f4234b)) {
                this.mEndValuesList.add(tVar2);
                this.mStartValuesList.add(null);
            }
        }
    }

    private void matchStartAndEnd(C1425u uVar, C1425u uVar2) {
        C0712a aVar = new C0712a((C0725g) uVar.f4236a);
        C0712a aVar2 = new C0712a((C0725g) uVar2.f4236a);
        for (int i : this.mMatchOrder) {
            switch (i) {
                case 1:
                    matchInstances(aVar, aVar2);
                    break;
                case 2:
                    matchNames(aVar, aVar2, uVar.f4239d, uVar2.f4239d);
                    break;
                case 3:
                    matchIds(aVar, aVar2, uVar.f4237b, uVar2.f4237b);
                    break;
                case 4:
                    matchItemIds(aVar, aVar2, uVar.f4238c, uVar2.f4238c);
                    break;
            }
        }
        addUnmatched(aVar, aVar2);
    }

    /* access modifiers changed from: protected */
    public void createAnimators(ViewGroup viewGroup, C1425u uVar, C1425u uVar2, ArrayList<C1424t> arrayList, ArrayList<C1424t> arrayList2) {
        int i;
        int i2;
        View view;
        Animator animator;
        C1424t tVar;
        C1424t tVar2;
        Animator animator2;
        ViewGroup viewGroup2 = viewGroup;
        C0712a runningAnimators = getRunningAnimators();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        long j = Long.MAX_VALUE;
        int i3 = 0;
        while (i3 < size) {
            C1424t tVar3 = (C1424t) arrayList.get(i3);
            C1424t tVar4 = (C1424t) arrayList2.get(i3);
            if (tVar3 != null && !tVar3.f4235c.contains(this)) {
                tVar3 = null;
            }
            if (tVar4 != null && !tVar4.f4235c.contains(this)) {
                tVar4 = null;
            }
            if (!(tVar3 == null && tVar4 == null)) {
                if (tVar3 == null || tVar4 == null || isTransitionRequired(tVar3, tVar4)) {
                    Animator createAnimator = createAnimator(viewGroup2, tVar3, tVar4);
                    if (createAnimator != null) {
                        if (tVar4 != null) {
                            view = tVar4.f4234b;
                            String[] transitionProperties = getTransitionProperties();
                            if (view != null && transitionProperties != null && transitionProperties.length > 0) {
                                tVar2 = new C1424t();
                                tVar2.f4234b = view;
                                Animator animator3 = createAnimator;
                                i2 = size;
                                C1424t tVar5 = (C1424t) uVar2.f4236a.get(view);
                                if (tVar5 != null) {
                                    int i4 = 0;
                                    while (i4 < transitionProperties.length) {
                                        int i5 = i3;
                                        C1424t tVar6 = tVar5;
                                        tVar2.f4233a.put(transitionProperties[i4], tVar5.f4233a.get(transitionProperties[i4]));
                                        i4++;
                                        i3 = i5;
                                        tVar5 = tVar6;
                                        ArrayList<C1424t> arrayList3 = arrayList2;
                                    }
                                }
                                i = i3;
                                int size2 = runningAnimators.size();
                                int i6 = 0;
                                while (true) {
                                    if (i6 >= size2) {
                                        animator2 = animator3;
                                        break;
                                    }
                                    C1411a aVar = (C1411a) runningAnimators.get((Animator) runningAnimators.mo2879b(i6));
                                    if (aVar.f4212c != null && aVar.f4210a == view && aVar.f4211b.equals(getName()) && aVar.f4212c.equals(tVar2)) {
                                        animator2 = null;
                                        break;
                                    }
                                    i6++;
                                }
                            } else {
                                i2 = size;
                                i = i3;
                                animator2 = createAnimator;
                                tVar2 = null;
                            }
                            animator = animator2;
                            tVar = tVar2;
                        } else {
                            Animator animator4 = createAnimator;
                            i2 = size;
                            i = i3;
                            view = tVar3.f4234b;
                            animator = animator4;
                            tVar = null;
                        }
                        if (animator != null) {
                            if (this.mPropagation != null) {
                                long a = this.mPropagation.mo5853a(viewGroup2, this, tVar3, tVar4);
                                sparseIntArray.put(this.mAnimators.size(), (int) a);
                                j = Math.min(a, j);
                            }
                            long j2 = j;
                            C1411a aVar2 = new C1411a(view, getName(), this, C1365ae.m5560b(viewGroup), tVar);
                            runningAnimators.put(animator, aVar2);
                            this.mAnimators.add(animator);
                            j = j2;
                        }
                        i3 = i + 1;
                        size = i2;
                    }
                }
            }
            i2 = size;
            i = i3;
            i3 = i + 1;
            size = i2;
        }
        if (j != 0) {
            for (int i7 = 0; i7 < sparseIntArray.size(); i7++) {
                Animator animator5 = (Animator) this.mAnimators.get(sparseIntArray.keyAt(i7));
                animator5.setStartDelay((((long) sparseIntArray.valueAt(i7)) - j) + animator5.getStartDelay());
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean isValidTarget(View view) {
        int id = view.getId();
        if (this.mTargetIdExcludes != null && this.mTargetIdExcludes.contains(Integer.valueOf(id))) {
            return false;
        }
        if (this.mTargetExcludes != null && this.mTargetExcludes.contains(view)) {
            return false;
        }
        if (this.mTargetTypeExcludes != null) {
            int size = this.mTargetTypeExcludes.size();
            for (int i = 0; i < size; i++) {
                if (((Class) this.mTargetTypeExcludes.get(i)).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.mTargetNameExcludes != null && C0962r.m3593p(view) != null && this.mTargetNameExcludes.contains(C0962r.m3593p(view))) {
            return false;
        }
        if ((this.mTargetIds.size() == 0 && this.mTargets.size() == 0 && ((this.mTargetTypes == null || this.mTargetTypes.isEmpty()) && (this.mTargetNames == null || this.mTargetNames.isEmpty()))) || this.mTargetIds.contains(Integer.valueOf(id)) || this.mTargets.contains(view)) {
            return true;
        }
        if (this.mTargetNames != null && this.mTargetNames.contains(C0962r.m3593p(view))) {
            return true;
        }
        if (this.mTargetTypes != null) {
            for (int i2 = 0; i2 < this.mTargetTypes.size(); i2++) {
                if (((Class) this.mTargetTypes.get(i2)).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static C0712a<Animator, C1411a> getRunningAnimators() {
        C0712a<Animator, C1411a> aVar = (C0712a) sRunningAnimators.get();
        if (aVar != null) {
            return aVar;
        }
        C0712a<Animator, C1411a> aVar2 = new C0712a<>();
        sRunningAnimators.set(aVar2);
        return aVar2;
    }

    /* access modifiers changed from: protected */
    public void runAnimators() {
        start();
        C0712a runningAnimators = getRunningAnimators();
        Iterator it = this.mAnimators.iterator();
        while (it.hasNext()) {
            Animator animator = (Animator) it.next();
            if (runningAnimators.containsKey(animator)) {
                start();
                runAnimator(animator, runningAnimators);
            }
        }
        this.mAnimators.clear();
        end();
    }

    private void runAnimator(Animator animator, final C0712a<Animator, C1411a> aVar) {
        if (animator != null) {
            animator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    C1407m.this.mCurrentAnimators.add(animator);
                }

                public void onAnimationEnd(Animator animator) {
                    aVar.remove(animator);
                    C1407m.this.mCurrentAnimators.remove(animator);
                }
            });
            animate(animator);
        }
    }

    public C1407m addTarget(View view) {
        this.mTargets.add(view);
        return this;
    }

    public C1407m addTarget(int i) {
        if (i != 0) {
            this.mTargetIds.add(Integer.valueOf(i));
        }
        return this;
    }

    public C1407m addTarget(String str) {
        if (this.mTargetNames == null) {
            this.mTargetNames = new ArrayList<>();
        }
        this.mTargetNames.add(str);
        return this;
    }

    public C1407m addTarget(Class cls) {
        if (this.mTargetTypes == null) {
            this.mTargetTypes = new ArrayList<>();
        }
        this.mTargetTypes.add(cls);
        return this;
    }

    public C1407m removeTarget(View view) {
        this.mTargets.remove(view);
        return this;
    }

    public C1407m removeTarget(int i) {
        if (i != 0) {
            this.mTargetIds.remove(Integer.valueOf(i));
        }
        return this;
    }

    public C1407m removeTarget(String str) {
        if (this.mTargetNames != null) {
            this.mTargetNames.remove(str);
        }
        return this;
    }

    public C1407m removeTarget(Class cls) {
        if (this.mTargetTypes != null) {
            this.mTargetTypes.remove(cls);
        }
        return this;
    }

    private static <T> ArrayList<T> excludeObject(ArrayList<T> arrayList, T t, boolean z) {
        if (t == null) {
            return arrayList;
        }
        if (z) {
            return C1412b.m5668a(arrayList, t);
        }
        return C1412b.m5669b(arrayList, t);
    }

    public C1407m excludeTarget(View view, boolean z) {
        this.mTargetExcludes = excludeView(this.mTargetExcludes, view, z);
        return this;
    }

    public C1407m excludeTarget(int i, boolean z) {
        this.mTargetIdExcludes = excludeId(this.mTargetIdExcludes, i, z);
        return this;
    }

    public C1407m excludeTarget(String str, boolean z) {
        this.mTargetNameExcludes = excludeObject(this.mTargetNameExcludes, str, z);
        return this;
    }

    public C1407m excludeChildren(View view, boolean z) {
        this.mTargetChildExcludes = excludeView(this.mTargetChildExcludes, view, z);
        return this;
    }

    public C1407m excludeChildren(int i, boolean z) {
        this.mTargetIdChildExcludes = excludeId(this.mTargetIdChildExcludes, i, z);
        return this;
    }

    private ArrayList<Integer> excludeId(ArrayList<Integer> arrayList, int i, boolean z) {
        if (i <= 0) {
            return arrayList;
        }
        if (z) {
            return C1412b.m5668a(arrayList, Integer.valueOf(i));
        }
        return C1412b.m5669b(arrayList, Integer.valueOf(i));
    }

    private ArrayList<View> excludeView(ArrayList<View> arrayList, View view, boolean z) {
        if (view == null) {
            return arrayList;
        }
        if (z) {
            return C1412b.m5668a(arrayList, view);
        }
        return C1412b.m5669b(arrayList, view);
    }

    public C1407m excludeTarget(Class cls, boolean z) {
        this.mTargetTypeExcludes = excludeType(this.mTargetTypeExcludes, cls, z);
        return this;
    }

    public C1407m excludeChildren(Class cls, boolean z) {
        this.mTargetTypeChildExcludes = excludeType(this.mTargetTypeChildExcludes, cls, z);
        return this;
    }

    private ArrayList<Class> excludeType(ArrayList<Class> arrayList, Class cls, boolean z) {
        if (cls == null) {
            return arrayList;
        }
        if (z) {
            return C1412b.m5668a(arrayList, cls);
        }
        return C1412b.m5669b(arrayList, cls);
    }

    public List<Integer> getTargetIds() {
        return this.mTargetIds;
    }

    public List<View> getTargets() {
        return this.mTargets;
    }

    public List<String> getTargetNames() {
        return this.mTargetNames;
    }

    public List<Class> getTargetTypes() {
        return this.mTargetTypes;
    }

    /* access modifiers changed from: 0000 */
    public void captureValues(ViewGroup viewGroup, boolean z) {
        clearValues(z);
        if ((this.mTargetIds.size() > 0 || this.mTargets.size() > 0) && ((this.mTargetNames == null || this.mTargetNames.isEmpty()) && (this.mTargetTypes == null || this.mTargetTypes.isEmpty()))) {
            for (int i = 0; i < this.mTargetIds.size(); i++) {
                View findViewById = viewGroup.findViewById(((Integer) this.mTargetIds.get(i)).intValue());
                if (findViewById != null) {
                    C1424t tVar = new C1424t();
                    tVar.f4234b = findViewById;
                    if (z) {
                        captureStartValues(tVar);
                    } else {
                        captureEndValues(tVar);
                    }
                    tVar.f4235c.add(this);
                    capturePropagationValues(tVar);
                    if (z) {
                        addViewValues(this.mStartValues, findViewById, tVar);
                    } else {
                        addViewValues(this.mEndValues, findViewById, tVar);
                    }
                }
            }
            for (int i2 = 0; i2 < this.mTargets.size(); i2++) {
                View view = (View) this.mTargets.get(i2);
                C1424t tVar2 = new C1424t();
                tVar2.f4234b = view;
                if (z) {
                    captureStartValues(tVar2);
                } else {
                    captureEndValues(tVar2);
                }
                tVar2.f4235c.add(this);
                capturePropagationValues(tVar2);
                if (z) {
                    addViewValues(this.mStartValues, view, tVar2);
                } else {
                    addViewValues(this.mEndValues, view, tVar2);
                }
            }
        } else {
            captureHierarchy(viewGroup, z);
        }
        if (!z && this.mNameOverrides != null) {
            int size = this.mNameOverrides.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i3 = 0; i3 < size; i3++) {
                arrayList.add(this.mStartValues.f4239d.remove((String) this.mNameOverrides.mo2879b(i3)));
            }
            for (int i4 = 0; i4 < size; i4++) {
                View view2 = (View) arrayList.get(i4);
                if (view2 != null) {
                    this.mStartValues.f4239d.put((String) this.mNameOverrides.mo2880c(i4), view2);
                }
            }
        }
    }

    private static void addViewValues(C1425u uVar, View view, C1424t tVar) {
        uVar.f4236a.put(view, tVar);
        int id = view.getId();
        if (id >= 0) {
            if (uVar.f4237b.indexOfKey(id) >= 0) {
                uVar.f4237b.put(id, null);
            } else {
                uVar.f4237b.put(id, view);
            }
        }
        String p = C0962r.m3593p(view);
        if (p != null) {
            if (uVar.f4239d.containsKey(p)) {
                uVar.f4239d.put(p, null);
            } else {
                uVar.f4239d.put(p, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (uVar.f4238c.mo2786c(itemIdAtPosition) >= 0) {
                    View view2 = (View) uVar.f4238c.mo2779a(itemIdAtPosition);
                    if (view2 != null) {
                        C0962r.m3565a(view2, false);
                        uVar.f4238c.mo2785b(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                C0962r.m3565a(view, true);
                uVar.f4238c.mo2785b(itemIdAtPosition, view);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void clearValues(boolean z) {
        if (z) {
            this.mStartValues.f4236a.clear();
            this.mStartValues.f4237b.clear();
            this.mStartValues.f4238c.mo2788c();
            return;
        }
        this.mEndValues.f4236a.clear();
        this.mEndValues.f4237b.clear();
        this.mEndValues.f4238c.mo2788c();
    }

    private void captureHierarchy(View view, boolean z) {
        if (view != null) {
            int id = view.getId();
            if (this.mTargetIdExcludes != null && this.mTargetIdExcludes.contains(Integer.valueOf(id))) {
                return;
            }
            if (this.mTargetExcludes == null || !this.mTargetExcludes.contains(view)) {
                if (this.mTargetTypeExcludes != null) {
                    int size = this.mTargetTypeExcludes.size();
                    int i = 0;
                    while (i < size) {
                        if (!((Class) this.mTargetTypeExcludes.get(i)).isInstance(view)) {
                            i++;
                        } else {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    C1424t tVar = new C1424t();
                    tVar.f4234b = view;
                    if (z) {
                        captureStartValues(tVar);
                    } else {
                        captureEndValues(tVar);
                    }
                    tVar.f4235c.add(this);
                    capturePropagationValues(tVar);
                    if (z) {
                        addViewValues(this.mStartValues, view, tVar);
                    } else {
                        addViewValues(this.mEndValues, view, tVar);
                    }
                }
                if ((view instanceof ViewGroup) && (this.mTargetIdChildExcludes == null || !this.mTargetIdChildExcludes.contains(Integer.valueOf(id)))) {
                    if (this.mTargetChildExcludes == null || !this.mTargetChildExcludes.contains(view)) {
                        if (this.mTargetTypeChildExcludes != null) {
                            int size2 = this.mTargetTypeChildExcludes.size();
                            int i2 = 0;
                            while (i2 < size2) {
                                if (!((Class) this.mTargetTypeChildExcludes.get(i2)).isInstance(view)) {
                                    i2++;
                                } else {
                                    return;
                                }
                            }
                        }
                        ViewGroup viewGroup = (ViewGroup) view;
                        for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                            captureHierarchy(viewGroup.getChildAt(i3), z);
                        }
                    }
                }
            }
        }
    }

    public C1424t getTransitionValues(View view, boolean z) {
        if (this.mParent != null) {
            return this.mParent.getTransitionValues(view, z);
        }
        return (C1424t) (z ? this.mStartValues : this.mEndValues).f4236a.get(view);
    }

    /* access modifiers changed from: 0000 */
    public C1424t getMatchedTransitionValues(View view, boolean z) {
        if (this.mParent != null) {
            return this.mParent.getMatchedTransitionValues(view, z);
        }
        ArrayList<C1424t> arrayList = z ? this.mStartValuesList : this.mEndValuesList;
        C1424t tVar = null;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i = -1;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            C1424t tVar2 = (C1424t) arrayList.get(i2);
            if (tVar2 == null) {
                return null;
            }
            if (tVar2.f4234b == view) {
                i = i2;
                break;
            }
            i2++;
        }
        if (i >= 0) {
            tVar = (C1424t) (z ? this.mEndValuesList : this.mStartValuesList).get(i);
        }
        return tVar;
    }

    public void pause(View view) {
        if (!this.mEnded) {
            C0712a runningAnimators = getRunningAnimators();
            int size = runningAnimators.size();
            C1378am b = C1365ae.m5560b(view);
            for (int i = size - 1; i >= 0; i--) {
                C1411a aVar = (C1411a) runningAnimators.mo2880c(i);
                if (aVar.f4210a != null && b.equals(aVar.f4213d)) {
                    C1358a.m5535a((Animator) runningAnimators.mo2879b(i));
                }
            }
            if (this.mListeners != null && this.mListeners.size() > 0) {
                ArrayList arrayList = (ArrayList) this.mListeners.clone();
                int size2 = arrayList.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    ((C1414d) arrayList.get(i2)).mo5739c(this);
                }
            }
            this.mPaused = true;
        }
    }

    public void resume(View view) {
        if (this.mPaused) {
            if (!this.mEnded) {
                C0712a runningAnimators = getRunningAnimators();
                int size = runningAnimators.size();
                C1378am b = C1365ae.m5560b(view);
                for (int i = size - 1; i >= 0; i--) {
                    C1411a aVar = (C1411a) runningAnimators.mo2880c(i);
                    if (aVar.f4210a != null && b.equals(aVar.f4213d)) {
                        C1358a.m5537b((Animator) runningAnimators.mo2879b(i));
                    }
                }
                if (this.mListeners != null && this.mListeners.size() > 0) {
                    ArrayList arrayList = (ArrayList) this.mListeners.clone();
                    int size2 = arrayList.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        ((C1414d) arrayList.get(i2)).mo5740d(this);
                    }
                }
            }
            this.mPaused = false;
        }
    }

    /* access modifiers changed from: 0000 */
    public void playTransition(ViewGroup viewGroup) {
        this.mStartValuesList = new ArrayList<>();
        this.mEndValuesList = new ArrayList<>();
        matchStartAndEnd(this.mStartValues, this.mEndValues);
        C0712a runningAnimators = getRunningAnimators();
        int size = runningAnimators.size();
        C1378am b = C1365ae.m5560b(viewGroup);
        for (int i = size - 1; i >= 0; i--) {
            Animator animator = (Animator) runningAnimators.mo2879b(i);
            if (animator != null) {
                C1411a aVar = (C1411a) runningAnimators.get(animator);
                if (!(aVar == null || aVar.f4210a == null || !b.equals(aVar.f4213d))) {
                    C1424t tVar = aVar.f4212c;
                    View view = aVar.f4210a;
                    C1424t transitionValues = getTransitionValues(view, true);
                    C1424t matchedTransitionValues = getMatchedTransitionValues(view, true);
                    if (!(transitionValues == null && matchedTransitionValues == null) && aVar.f4214e.isTransitionRequired(tVar, matchedTransitionValues)) {
                        if (animator.isRunning() || animator.isStarted()) {
                            animator.cancel();
                        } else {
                            runningAnimators.remove(animator);
                        }
                    }
                }
            }
        }
        createAnimators(viewGroup, this.mStartValues, this.mEndValues, this.mStartValuesList, this.mEndValuesList);
        runAnimators();
    }

    public boolean isTransitionRequired(C1424t tVar, C1424t tVar2) {
        if (tVar == null || tVar2 == null) {
            return false;
        }
        String[] transitionProperties = getTransitionProperties();
        if (transitionProperties != null) {
            int length = transitionProperties.length;
            int i = 0;
            while (i < length) {
                if (!isValueChanged(tVar, tVar2, transitionProperties[i])) {
                    i++;
                }
            }
            return false;
        }
        for (String isValueChanged : tVar.f4233a.keySet()) {
            if (isValueChanged(tVar, tVar2, isValueChanged)) {
            }
        }
        return false;
        return true;
    }

    private static boolean isValueChanged(C1424t tVar, C1424t tVar2, String str) {
        Object obj = tVar.f4233a.get(str);
        Object obj2 = tVar2.f4233a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return true ^ obj.equals(obj2);
    }

    /* access modifiers changed from: protected */
    public void animate(Animator animator) {
        if (animator == null) {
            end();
            return;
        }
        if (getDuration() >= 0) {
            animator.setDuration(getDuration());
        }
        if (getStartDelay() >= 0) {
            animator.setStartDelay(getStartDelay());
        }
        if (getInterpolator() != null) {
            animator.setInterpolator(getInterpolator());
        }
        animator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                C1407m.this.end();
                animator.removeListener(this);
            }
        });
        animator.start();
    }

    /* access modifiers changed from: protected */
    public void start() {
        if (this.mNumInstances == 0) {
            if (this.mListeners != null && this.mListeners.size() > 0) {
                ArrayList arrayList = (ArrayList) this.mListeners.clone();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((C1414d) arrayList.get(i)).mo5741e(this);
                }
            }
            this.mEnded = false;
        }
        this.mNumInstances++;
    }

    /* access modifiers changed from: protected */
    public void end() {
        this.mNumInstances--;
        if (this.mNumInstances == 0) {
            if (this.mListeners != null && this.mListeners.size() > 0) {
                ArrayList arrayList = (ArrayList) this.mListeners.clone();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((C1414d) arrayList.get(i)).mo5738b(this);
                }
            }
            for (int i2 = 0; i2 < this.mStartValues.f4238c.mo2782b(); i2++) {
                View view = (View) this.mStartValues.f4238c.mo2787c(i2);
                if (view != null) {
                    C0962r.m3565a(view, false);
                }
            }
            for (int i3 = 0; i3 < this.mEndValues.f4238c.mo2782b(); i3++) {
                View view2 = (View) this.mEndValues.f4238c.mo2787c(i3);
                if (view2 != null) {
                    C0962r.m3565a(view2, false);
                }
            }
            this.mEnded = true;
        }
    }

    /* access modifiers changed from: 0000 */
    public void forceToEnd(ViewGroup viewGroup) {
        C0712a runningAnimators = getRunningAnimators();
        int size = runningAnimators.size();
        if (viewGroup != null) {
            C1378am b = C1365ae.m5560b(viewGroup);
            for (int i = size - 1; i >= 0; i--) {
                C1411a aVar = (C1411a) runningAnimators.mo2880c(i);
                if (!(aVar.f4210a == null || b == null || !b.equals(aVar.f4213d))) {
                    ((Animator) runningAnimators.mo2879b(i)).end();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void cancel() {
        for (int size = this.mCurrentAnimators.size() - 1; size >= 0; size--) {
            ((Animator) this.mCurrentAnimators.get(size)).cancel();
        }
        if (this.mListeners != null && this.mListeners.size() > 0) {
            ArrayList arrayList = (ArrayList) this.mListeners.clone();
            int size2 = arrayList.size();
            for (int i = 0; i < size2; i++) {
                ((C1414d) arrayList.get(i)).mo5737a(this);
            }
        }
    }

    public C1407m addListener(C1414d dVar) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList<>();
        }
        this.mListeners.add(dVar);
        return this;
    }

    public C1407m removeListener(C1414d dVar) {
        if (this.mListeners == null) {
            return this;
        }
        this.mListeners.remove(dVar);
        if (this.mListeners.size() == 0) {
            this.mListeners = null;
        }
        return this;
    }

    public void setPathMotion(C1401g gVar) {
        if (gVar == null) {
            this.mPathMotion = STRAIGHT_PATH_MOTION;
        } else {
            this.mPathMotion = gVar;
        }
    }

    public C1401g getPathMotion() {
        return this.mPathMotion;
    }

    public void setEpicenterCallback(C1413c cVar) {
        this.mEpicenterCallback = cVar;
    }

    public C1413c getEpicenterCallback() {
        return this.mEpicenterCallback;
    }

    public Rect getEpicenter() {
        if (this.mEpicenterCallback == null) {
            return null;
        }
        return this.mEpicenterCallback.mo5781a(this);
    }

    public void setPropagation(C1419p pVar) {
        this.mPropagation = pVar;
    }

    public C1419p getPropagation() {
        return this.mPropagation;
    }

    /* access modifiers changed from: 0000 */
    public void capturePropagationValues(C1424t tVar) {
        if (this.mPropagation != null && !tVar.f4233a.isEmpty()) {
            String[] a = this.mPropagation.mo5855a();
            if (a != null) {
                boolean z = false;
                int i = 0;
                while (true) {
                    if (i >= a.length) {
                        z = true;
                        break;
                    } else if (!tVar.f4233a.containsKey(a[i])) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (!z) {
                    this.mPropagation.mo5854a(tVar);
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public C1407m setSceneRoot(ViewGroup viewGroup) {
        this.mSceneRoot = viewGroup;
        return this;
    }

    /* access modifiers changed from: 0000 */
    public void setCanRemoveViews(boolean z) {
        this.mCanRemoveViews = z;
    }

    public String toString() {
        return toString("");
    }

    public C1407m clone() {
        try {
            C1407m mVar = (C1407m) super.clone();
            mVar.mAnimators = new ArrayList<>();
            mVar.mStartValues = new C1425u();
            mVar.mEndValues = new C1425u();
            mVar.mStartValuesList = null;
            mVar.mEndValuesList = null;
            return mVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public String getName() {
        return this.mName;
    }

    /* access modifiers changed from: 0000 */
    public String toString(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(getClass().getSimpleName());
        sb.append("@");
        sb.append(Integer.toHexString(hashCode()));
        sb.append(": ");
        String sb2 = sb.toString();
        if (this.mDuration != -1) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            sb3.append("dur(");
            sb3.append(this.mDuration);
            sb3.append(") ");
            sb2 = sb3.toString();
        }
        if (this.mStartDelay != -1) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(sb2);
            sb4.append("dly(");
            sb4.append(this.mStartDelay);
            sb4.append(") ");
            sb2 = sb4.toString();
        }
        if (this.mInterpolator != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(sb2);
            sb5.append("interp(");
            sb5.append(this.mInterpolator);
            sb5.append(") ");
            sb2 = sb5.toString();
        }
        if (this.mTargetIds.size() <= 0 && this.mTargets.size() <= 0) {
            return sb2;
        }
        StringBuilder sb6 = new StringBuilder();
        sb6.append(sb2);
        sb6.append("tgts(");
        String sb7 = sb6.toString();
        if (this.mTargetIds.size() > 0) {
            String str2 = sb7;
            for (int i = 0; i < this.mTargetIds.size(); i++) {
                if (i > 0) {
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append(str2);
                    sb8.append(", ");
                    str2 = sb8.toString();
                }
                StringBuilder sb9 = new StringBuilder();
                sb9.append(str2);
                sb9.append(this.mTargetIds.get(i));
                str2 = sb9.toString();
            }
            sb7 = str2;
        }
        if (this.mTargets.size() > 0) {
            for (int i2 = 0; i2 < this.mTargets.size(); i2++) {
                if (i2 > 0) {
                    StringBuilder sb10 = new StringBuilder();
                    sb10.append(sb7);
                    sb10.append(", ");
                    sb7 = sb10.toString();
                }
                StringBuilder sb11 = new StringBuilder();
                sb11.append(sb7);
                sb11.append(this.mTargets.get(i2));
                sb7 = sb11.toString();
            }
        }
        StringBuilder sb12 = new StringBuilder();
        sb12.append(sb7);
        sb12.append(")");
        return sb12.toString();
    }
}
