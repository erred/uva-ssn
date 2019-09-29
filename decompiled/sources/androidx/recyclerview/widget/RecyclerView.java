package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.p065c.C0872b;
import androidx.core.p069f.C0930e;
import androidx.core.p070g.C0932a;
import androidx.core.p070g.C0952h;
import androidx.core.p070g.C0954j;
import androidx.core.p070g.C0955k;
import androidx.core.p070g.C0962r;
import androidx.core.p070g.C0966s;
import androidx.core.p070g.p071a.C0934a;
import androidx.core.p070g.p071a.C0935b;
import androidx.core.p070g.p071a.C0935b.C0937b;
import androidx.core.p070g.p071a.C0935b.C0938c;
import androidx.customview.p072a.C1021a;
import androidx.customview.p073b.C1024a;
import androidx.recyclerview.R;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.api.client.googleapis.media.MediaHttpUploader;
import com.google.common.primitives.Ints;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecyclerView extends ViewGroup implements C0954j {
    static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC = (VERSION.SDK_INT >= 23);
    static final boolean ALLOW_THREAD_GAP_WORK = (VERSION.SDK_INT >= 21);
    private static final int[] CLIP_TO_PADDING_ATTR = {16842987};
    static final boolean DEBUG = false;
    static final int DEFAULT_ORIENTATION = 1;
    static final boolean DISPATCH_TEMP_DETACH = false;
    private static final boolean FORCE_ABS_FOCUS_SEARCH_DIRECTION = (VERSION.SDK_INT <= 15);
    static final boolean FORCE_INVALIDATE_DISPLAY_LIST = (VERSION.SDK_INT == 18 || VERSION.SDK_INT == 19 || VERSION.SDK_INT == 20);
    static final long FOREVER_NS = Long.MAX_VALUE;
    public static final int HORIZONTAL = 0;
    private static final boolean IGNORE_DETACHED_FOCUSED_CHILD = (VERSION.SDK_INT <= 15);
    private static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = {Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
    static final int MAX_SCROLL_DURATION = 2000;
    private static final int[] NESTED_SCROLLING_ATTRS = {16843830};
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    static final boolean POST_UPDATES_ON_ANIMATION = (VERSION.SDK_INT >= 16);
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    static final String TAG = "RecyclerView";
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    static final String TRACE_BIND_VIEW_TAG = "RV OnBindView";
    static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
    private static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
    static final String TRACE_NESTED_PREFETCH_TAG = "RV Nested Prefetch";
    private static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
    private static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
    static final String TRACE_PREFETCH_TAG = "RV Prefetch";
    static final String TRACE_SCROLL_TAG = "RV Scroll";
    static final boolean VERBOSE_TRACING = false;
    public static final int VERTICAL = 1;
    static final Interpolator sQuinticInterpolator = new Interpolator() {
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };
    C1320j mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    private C1262m mActiveOnItemTouchListener;
    C1243a mAdapter;
    C1287a mAdapterHelper;
    boolean mAdapterUpdateDuringMeasure;
    private EdgeEffect mBottomGlow;
    private C1246d mChildDrawingOrderCallback;
    C1290b mChildHelper;
    boolean mClipToPadding;
    boolean mDataSetHasChangedAfterLayout;
    boolean mDispatchItemsChangedEvent;
    private int mDispatchScrollCounter;
    private int mEatenAccessibilityChangeFlags;
    private C1247e mEdgeEffectFactory;
    boolean mEnableFastScroller;
    boolean mFirstLayoutComplete;
    C1309e mGapWorker;
    boolean mHasFixedSize;
    private boolean mIgnoreMotionEventTillDown;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private int mInterceptRequestLayoutDepth;
    boolean mIsAttached;
    C1248f mItemAnimator;
    private C1250b mItemAnimatorListener;
    private Runnable mItemAnimatorRunner;
    final ArrayList<C1253h> mItemDecorations;
    boolean mItemsAddedOrRemoved;
    boolean mItemsChanged;
    private int mLastTouchX;
    private int mLastTouchY;
    C1254i mLayout;
    boolean mLayoutFrozen;
    private int mLayoutOrScrollCounter;
    boolean mLayoutWasDefered;
    private EdgeEffect mLeftGlow;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int[] mMinMaxLayoutPositions;
    private final int[] mNestedOffsets;
    private final C1268r mObserver;
    private List<C1260k> mOnChildAttachStateListeners;
    private C1261l mOnFlingListener;
    private final ArrayList<C1262m> mOnItemTouchListeners;
    final List<C1277x> mPendingAccessibilityImportanceChange;
    private C1269s mPendingSavedState;
    boolean mPostedAnimatorRunner;
    C1311a mPrefetchRegistry;
    private boolean mPreserveFocusAfterLayout;
    final C1266p mRecycler;
    C1267q mRecyclerListener;
    private EdgeEffect mRightGlow;
    private float mScaledHorizontalScrollFactor;
    private float mScaledVerticalScrollFactor;
    final int[] mScrollConsumed;
    private C1263n mScrollListener;
    private List<C1263n> mScrollListeners;
    private final int[] mScrollOffset;
    private int mScrollPointerId;
    private int mScrollState;
    final int[] mScrollStepConsumed;
    private C0955k mScrollingChildHelper;
    final C1274u mState;
    final Rect mTempRect;
    private final Rect mTempRect2;
    final RectF mTempRectF;
    private EdgeEffect mTopGlow;
    private int mTouchSlop;
    final Runnable mUpdateChildViewsRunnable;
    private VelocityTracker mVelocityTracker;
    final C1276w mViewFlinger;
    private final C1329b mViewInfoProcessCallback;
    final C1327n mViewInfoStore;

    /* renamed from: androidx.recyclerview.widget.RecyclerView$a */
    public static abstract class C1243a<VH extends C1277x> {
        private boolean mHasStableIds = false;
        private final C1244b mObservable = new C1244b();

        public abstract int getItemCount();

        public long getItemId(int i) {
            return -1;
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        }

        public abstract void onBindViewHolder(VH vh, int i);

        public abstract VH onCreateViewHolder(ViewGroup viewGroup, int i);

        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        }

        public boolean onFailedToRecycleView(VH vh) {
            return false;
        }

        public void onViewAttachedToWindow(VH vh) {
        }

        public void onViewDetachedFromWindow(VH vh) {
        }

        public void onViewRecycled(VH vh) {
        }

        public void onBindViewHolder(VH vh, int i, List<Object> list) {
            onBindViewHolder(vh, i);
        }

        public final VH createViewHolder(ViewGroup viewGroup, int i) {
            try {
                C0872b.m3226a(RecyclerView.TRACE_CREATE_VIEW_TAG);
                VH onCreateViewHolder = onCreateViewHolder(viewGroup, i);
                if (onCreateViewHolder.itemView.getParent() == null) {
                    onCreateViewHolder.mItemViewType = i;
                    return onCreateViewHolder;
                }
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            } finally {
                C0872b.m3225a();
            }
        }

        public final void bindViewHolder(VH vh, int i) {
            vh.mPosition = i;
            if (hasStableIds()) {
                vh.mItemId = getItemId(i);
            }
            vh.setFlags(1, 519);
            C0872b.m3226a(RecyclerView.TRACE_BIND_VIEW_TAG);
            onBindViewHolder(vh, i, vh.getUnmodifiedPayloads());
            vh.clearPayload();
            LayoutParams layoutParams = vh.itemView.getLayoutParams();
            if (layoutParams instanceof C1259j) {
                ((C1259j) layoutParams).f3731e = true;
            }
            C0872b.m3225a();
        }

        public void setHasStableIds(boolean z) {
            if (!hasObservers()) {
                this.mHasStableIds = z;
                return;
            }
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public final boolean hasObservers() {
            return this.mObservable.mo5054a();
        }

        public void registerAdapterDataObserver(C1245c cVar) {
            this.mObservable.registerObserver(cVar);
        }

        public void unregisterAdapterDataObserver(C1245c cVar) {
            this.mObservable.unregisterObserver(cVar);
        }

        public final void notifyDataSetChanged() {
            this.mObservable.mo5055b();
        }

        public final void notifyItemChanged(int i) {
            this.mObservable.mo5052a(i, 1);
        }

        public final void notifyItemChanged(int i, Object obj) {
            this.mObservable.mo5053a(i, 1, obj);
        }

        public final void notifyItemRangeChanged(int i, int i2) {
            this.mObservable.mo5052a(i, i2);
        }

        public final void notifyItemRangeChanged(int i, int i2, Object obj) {
            this.mObservable.mo5053a(i, i2, obj);
        }

        public final void notifyItemInserted(int i) {
            this.mObservable.mo5056b(i, 1);
        }

        public final void notifyItemMoved(int i, int i2) {
            this.mObservable.mo5058d(i, i2);
        }

        public final void notifyItemRangeInserted(int i, int i2) {
            this.mObservable.mo5056b(i, i2);
        }

        public final void notifyItemRemoved(int i) {
            this.mObservable.mo5057c(i, 1);
        }

        public final void notifyItemRangeRemoved(int i, int i2) {
            this.mObservable.mo5057c(i, i2);
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$b */
    static class C1244b extends Observable<C1245c> {
        C1244b() {
        }

        /* renamed from: a */
        public boolean mo5054a() {
            return !this.mObservers.isEmpty();
        }

        /* renamed from: b */
        public void mo5055b() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((C1245c) this.mObservers.get(size)).mo5059a();
            }
        }

        /* renamed from: a */
        public void mo5052a(int i, int i2) {
            mo5053a(i, i2, null);
        }

        /* renamed from: a */
        public void mo5053a(int i, int i2, Object obj) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((C1245c) this.mObservers.get(size)).mo5062a(i, i2, obj);
            }
        }

        /* renamed from: b */
        public void mo5056b(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((C1245c) this.mObservers.get(size)).mo5063b(i, i2);
            }
        }

        /* renamed from: c */
        public void mo5057c(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((C1245c) this.mObservers.get(size)).mo5064c(i, i2);
            }
        }

        /* renamed from: d */
        public void mo5058d(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((C1245c) this.mObservers.get(size)).mo5061a(i, i2, 1);
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$c */
    public static abstract class C1245c {
        /* renamed from: a */
        public void mo5059a() {
        }

        /* renamed from: a */
        public void mo5060a(int i, int i2) {
        }

        /* renamed from: a */
        public void mo5061a(int i, int i2, int i3) {
        }

        /* renamed from: b */
        public void mo5063b(int i, int i2) {
        }

        /* renamed from: c */
        public void mo5064c(int i, int i2) {
        }

        /* renamed from: a */
        public void mo5062a(int i, int i2, Object obj) {
            mo5060a(i, i2);
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$d */
    public interface C1246d {
        /* renamed from: a */
        int mo5065a(int i, int i2);
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$e */
    public static class C1247e {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public EdgeEffect mo5066a(RecyclerView recyclerView, int i) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$f */
    public static abstract class C1248f {

        /* renamed from: a */
        private C1250b f3694a = null;

        /* renamed from: b */
        private ArrayList<C1249a> f3695b = new ArrayList<>();

        /* renamed from: c */
        private long f3696c = 120;

        /* renamed from: d */
        private long f3697d = 120;

        /* renamed from: e */
        private long f3698e = 250;

        /* renamed from: f */
        private long f3699f = 250;

        /* renamed from: androidx.recyclerview.widget.RecyclerView$f$a */
        public interface C1249a {
            /* renamed from: a */
            void mo5088a();
        }

        /* renamed from: androidx.recyclerview.widget.RecyclerView$f$b */
        interface C1250b {
            /* renamed from: a */
            void mo5089a(C1277x xVar);
        }

        /* renamed from: androidx.recyclerview.widget.RecyclerView$f$c */
        public static class C1251c {

            /* renamed from: a */
            public int f3700a;

            /* renamed from: b */
            public int f3701b;

            /* renamed from: c */
            public int f3702c;

            /* renamed from: d */
            public int f3703d;

            /* renamed from: a */
            public C1251c mo5090a(C1277x xVar) {
                return mo5091a(xVar, 0);
            }

            /* renamed from: a */
            public C1251c mo5091a(C1277x xVar, int i) {
                View view = xVar.itemView;
                this.f3700a = view.getLeft();
                this.f3701b = view.getTop();
                this.f3702c = view.getRight();
                this.f3703d = view.getBottom();
                return this;
            }
        }

        /* renamed from: a */
        public abstract void mo5069a();

        /* renamed from: a */
        public abstract boolean mo5071a(C1277x xVar, C1251c cVar, C1251c cVar2);

        /* renamed from: a */
        public abstract boolean mo5072a(C1277x xVar, C1277x xVar2, C1251c cVar, C1251c cVar2);

        /* renamed from: b */
        public abstract boolean mo5074b();

        /* renamed from: b */
        public abstract boolean mo5075b(C1277x xVar, C1251c cVar, C1251c cVar2);

        /* renamed from: c */
        public abstract boolean mo5076c(C1277x xVar, C1251c cVar, C1251c cVar2);

        /* renamed from: d */
        public abstract void mo5077d();

        /* renamed from: d */
        public abstract void mo5078d(C1277x xVar);

        /* renamed from: g */
        public void mo5083g(C1277x xVar) {
        }

        /* renamed from: h */
        public boolean mo5085h(C1277x xVar) {
            return true;
        }

        /* renamed from: e */
        public long mo5079e() {
            return this.f3698e;
        }

        /* renamed from: f */
        public long mo5080f() {
            return this.f3696c;
        }

        /* renamed from: g */
        public long mo5082g() {
            return this.f3697d;
        }

        /* renamed from: h */
        public long mo5084h() {
            return this.f3699f;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo5070a(C1250b bVar) {
            this.f3694a = bVar;
        }

        /* renamed from: a */
        public C1251c mo5068a(C1274u uVar, C1277x xVar, int i, List<Object> list) {
            return mo5087j().mo5090a(xVar);
        }

        /* renamed from: a */
        public C1251c mo5067a(C1274u uVar, C1277x xVar) {
            return mo5087j().mo5090a(xVar);
        }

        /* renamed from: e */
        static int m4749e(C1277x xVar) {
            int i = xVar.mFlags & 14;
            if (xVar.isInvalid()) {
                return 4;
            }
            if ((i & 4) == 0) {
                int oldPosition = xVar.getOldPosition();
                int adapterPosition = xVar.getAdapterPosition();
                if (!(oldPosition == -1 || adapterPosition == -1 || oldPosition == adapterPosition)) {
                    i |= 2048;
                }
            }
            return i;
        }

        /* renamed from: f */
        public final void mo5081f(C1277x xVar) {
            mo5083g(xVar);
            if (this.f3694a != null) {
                this.f3694a.mo5089a(xVar);
            }
        }

        /* renamed from: a */
        public boolean mo5073a(C1277x xVar, List<Object> list) {
            return mo5085h(xVar);
        }

        /* renamed from: i */
        public final void mo5086i() {
            int size = this.f3695b.size();
            for (int i = 0; i < size; i++) {
                ((C1249a) this.f3695b.get(i)).mo5088a();
            }
            this.f3695b.clear();
        }

        /* renamed from: j */
        public C1251c mo5087j() {
            return new C1251c();
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$g */
    private class C1252g implements C1250b {
        C1252g() {
        }

        /* renamed from: a */
        public void mo5089a(C1277x xVar) {
            xVar.setIsRecyclable(true);
            if (xVar.mShadowedHolder != null && xVar.mShadowingHolder == null) {
                xVar.mShadowedHolder = null;
            }
            xVar.mShadowingHolder = null;
            if (!xVar.shouldBeKeptAsChild() && !RecyclerView.this.removeAnimatingView(xVar.itemView) && xVar.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(xVar.itemView, false);
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$h */
    public static abstract class C1253h {
        @Deprecated
        /* renamed from: a */
        public void mo5092a(Canvas canvas, RecyclerView recyclerView) {
        }

        @Deprecated
        /* renamed from: b */
        public void mo5096b(Canvas canvas, RecyclerView recyclerView) {
        }

        /* renamed from: b */
        public void mo5097b(Canvas canvas, RecyclerView recyclerView, C1274u uVar) {
            mo5092a(canvas, recyclerView);
        }

        /* renamed from: a */
        public void mo5093a(Canvas canvas, RecyclerView recyclerView, C1274u uVar) {
            mo5096b(canvas, recyclerView);
        }

        @Deprecated
        /* renamed from: a */
        public void mo5094a(Rect rect, int i, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        /* renamed from: a */
        public void mo5095a(Rect rect, View view, RecyclerView recyclerView, C1274u uVar) {
            mo5094a(rect, ((C1259j) view.getLayoutParams()).mo5199f(), recyclerView);
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$i */
    public static abstract class C1254i {

        /* renamed from: a */
        private final C1326b f3705a = new C1326b() {
            /* renamed from: a */
            public View mo5192a(int i) {
                return C1254i.this.mo5169i(i);
            }

            /* renamed from: a */
            public int mo5190a() {
                return C1254i.this.mo5099B();
            }

            /* renamed from: b */
            public int mo5193b() {
                return C1254i.this.mo5189z() - C1254i.this.mo5101D();
            }

            /* renamed from: a */
            public int mo5191a(View view) {
                return C1254i.this.mo5166h(view) - ((C1259j) view.getLayoutParams()).leftMargin;
            }

            /* renamed from: b */
            public int mo5194b(View view) {
                return C1254i.this.mo5170j(view) + ((C1259j) view.getLayoutParams()).rightMargin;
            }
        };

        /* renamed from: b */
        private final C1326b f3706b = new C1326b() {
            /* renamed from: a */
            public View mo5192a(int i) {
                return C1254i.this.mo5169i(i);
            }

            /* renamed from: a */
            public int mo5190a() {
                return C1254i.this.mo5100C();
            }

            /* renamed from: b */
            public int mo5193b() {
                return C1254i.this.mo5098A() - C1254i.this.mo5102E();
            }

            /* renamed from: a */
            public int mo5191a(View view) {
                return C1254i.this.mo5168i(view) - ((C1259j) view.getLayoutParams()).topMargin;
            }

            /* renamed from: b */
            public int mo5194b(View view) {
                return C1254i.this.mo5172k(view) + ((C1259j) view.getLayoutParams()).bottomMargin;
            }
        };

        /* renamed from: c */
        private boolean f3707c = true;

        /* renamed from: d */
        private boolean f3708d = true;

        /* renamed from: e */
        private int f3709e;

        /* renamed from: f */
        private int f3710f;

        /* renamed from: g */
        private int f3711g;

        /* renamed from: h */
        private int f3712h;

        /* renamed from: p */
        C1290b f3713p;

        /* renamed from: q */
        RecyclerView f3714q;

        /* renamed from: r */
        C1324m f3715r = new C1324m(this.f3705a);

        /* renamed from: s */
        C1324m f3716s = new C1324m(this.f3706b);

        /* renamed from: t */
        C1271t f3717t;

        /* renamed from: u */
        boolean f3718u = false;

        /* renamed from: v */
        boolean f3719v = false;

        /* renamed from: w */
        boolean f3720w = false;

        /* renamed from: x */
        int f3721x;

        /* renamed from: y */
        boolean f3722y;

        /* renamed from: androidx.recyclerview.widget.RecyclerView$i$a */
        public interface C1257a {
            /* renamed from: b */
            void mo5195b(int i, int i2);
        }

        /* renamed from: androidx.recyclerview.widget.RecyclerView$i$b */
        public static class C1258b {

            /* renamed from: a */
            public int f3725a;

            /* renamed from: b */
            public int f3726b;

            /* renamed from: c */
            public boolean f3727c;

            /* renamed from: d */
            public boolean f3728d;
        }

        /* renamed from: a */
        public int mo4726a(int i, C1266p pVar, C1274u uVar) {
            return 0;
        }

        /* renamed from: a */
        public View mo4728a(View view, int i, C1266p pVar, C1274u uVar) {
            return null;
        }

        /* renamed from: a */
        public abstract C1259j mo4730a();

        /* renamed from: a */
        public void mo4761a(int i, int i2, C1274u uVar, C1257a aVar) {
        }

        /* renamed from: a */
        public void mo4762a(int i, C1257a aVar) {
        }

        /* renamed from: a */
        public void mo4763a(Parcelable parcelable) {
        }

        /* renamed from: a */
        public void mo5120a(C1243a aVar, C1243a aVar2) {
        }

        /* renamed from: a */
        public void mo4738a(C1274u uVar) {
        }

        /* renamed from: a */
        public void mo4740a(RecyclerView recyclerView) {
        }

        /* renamed from: a */
        public void mo4741a(RecyclerView recyclerView, int i, int i2) {
        }

        /* renamed from: a */
        public void mo4742a(RecyclerView recyclerView, int i, int i2, int i3) {
        }

        /* renamed from: a */
        public boolean mo4745a(C1259j jVar) {
            return jVar != null;
        }

        /* renamed from: a */
        public boolean mo5131a(C1266p pVar, C1274u uVar, View view, int i, Bundle bundle) {
            return false;
        }

        /* renamed from: a */
        public boolean mo5136a(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        /* renamed from: b */
        public int mo4746b(int i, C1266p pVar, C1274u uVar) {
            return 0;
        }

        /* renamed from: b */
        public void mo4748b(RecyclerView recyclerView, int i, int i2) {
        }

        /* renamed from: b */
        public boolean mo4749b() {
            return false;
        }

        /* renamed from: c */
        public int mo4773c(C1274u uVar) {
            return 0;
        }

        /* renamed from: c */
        public void mo5151c(RecyclerView recyclerView, int i, int i2) {
        }

        /* renamed from: d */
        public int mo5153d(C1266p pVar, C1274u uVar) {
            return 0;
        }

        /* renamed from: d */
        public int mo4776d(C1274u uVar) {
            return 0;
        }

        /* renamed from: d */
        public Parcelable mo4778d() {
            return null;
        }

        /* renamed from: d */
        public View mo5154d(View view, int i) {
            return null;
        }

        /* renamed from: d */
        public void mo5156d(RecyclerView recyclerView) {
        }

        /* renamed from: e */
        public int mo4779e(C1274u uVar) {
            return 0;
        }

        /* renamed from: e */
        public void mo4780e(int i) {
        }

        @Deprecated
        /* renamed from: e */
        public void mo5159e(RecyclerView recyclerView) {
        }

        /* renamed from: e */
        public boolean mo4781e() {
            return false;
        }

        /* renamed from: e */
        public boolean mo5160e(C1266p pVar, C1274u uVar) {
            return false;
        }

        /* renamed from: f */
        public int mo4783f(C1274u uVar) {
            return 0;
        }

        /* renamed from: f */
        public boolean mo4784f() {
            return false;
        }

        /* renamed from: g */
        public int mo4786g(C1274u uVar) {
            return 0;
        }

        /* renamed from: h */
        public int mo4787h(C1274u uVar) {
            return 0;
        }

        /* renamed from: l */
        public void mo5175l(int i) {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: l */
        public boolean mo4792l() {
            return false;
        }

        /* renamed from: v */
        public int mo5185v() {
            return -1;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo5143b(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.f3714q = null;
                this.f3713p = null;
                this.f3711g = 0;
                this.f3712h = 0;
            } else {
                this.f3714q = recyclerView;
                this.f3713p = recyclerView.mChildHelper;
                this.f3711g = recyclerView.getWidth();
                this.f3712h = recyclerView.getHeight();
            }
            this.f3709e = Ints.MAX_POWER_OF_TWO;
            this.f3710f = Ints.MAX_POWER_OF_TWO;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public void mo5146c(int i, int i2) {
            this.f3711g = MeasureSpec.getSize(i);
            this.f3709e = MeasureSpec.getMode(i);
            if (this.f3709e == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.f3711g = 0;
            }
            this.f3712h = MeasureSpec.getSize(i2);
            this.f3710f = MeasureSpec.getMode(i2);
            if (this.f3710f == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.f3712h = 0;
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public void mo5155d(int i, int i2) {
            int w = mo5186w();
            if (w == 0) {
                this.f3714q.defaultOnMeasure(i, i2);
                return;
            }
            int i3 = BaseClientBuilder.API_PRIORITY_OTHER;
            int i4 = BaseClientBuilder.API_PRIORITY_OTHER;
            int i5 = C1024a.INVALID_ID;
            int i6 = C1024a.INVALID_ID;
            for (int i7 = 0; i7 < w; i7++) {
                View i8 = mo5169i(i7);
                Rect rect = this.f3714q.mTempRect;
                mo5115a(i8, rect);
                if (rect.left < i3) {
                    i3 = rect.left;
                }
                if (rect.right > i5) {
                    i5 = rect.right;
                }
                if (rect.top < i4) {
                    i4 = rect.top;
                }
                if (rect.bottom > i6) {
                    i6 = rect.bottom;
                }
            }
            this.f3714q.mTempRect.set(i3, i4, i5, i6);
            mo4734a(this.f3714q.mTempRect, i, i2);
        }

        /* renamed from: a */
        public void mo4734a(Rect rect, int i, int i2) {
            mo5162f(m4782a(i, rect.width() + mo5099B() + mo5101D(), mo5104G()), m4782a(i2, rect.height() + mo5100C() + mo5102E(), mo5105H()));
        }

        /* renamed from: p */
        public void mo5179p() {
            if (this.f3714q != null) {
                this.f3714q.requestLayout();
            }
        }

        /* renamed from: a */
        public static int m4782a(int i, int i2, int i3) {
            int mode = MeasureSpec.getMode(i);
            int size = MeasureSpec.getSize(i);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? Math.max(i2, i3) : size;
            }
            return Math.min(size, Math.max(i2, i3));
        }

        /* renamed from: a */
        public void mo4767a(String str) {
            if (this.f3714q != null) {
                this.f3714q.assertNotInLayoutOrScroll(str);
            }
        }

        /* renamed from: c */
        public boolean mo4775c() {
            return this.f3720w;
        }

        /* renamed from: q */
        public final boolean mo5180q() {
            return this.f3708d;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public void mo5150c(RecyclerView recyclerView) {
            this.f3719v = true;
            mo5156d(recyclerView);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo5144b(RecyclerView recyclerView, C1266p pVar) {
            this.f3719v = false;
            mo4765a(recyclerView, pVar);
        }

        /* renamed from: r */
        public boolean mo5181r() {
            return this.f3719v;
        }

        /* renamed from: a */
        public boolean mo5137a(Runnable runnable) {
            if (this.f3714q != null) {
                return this.f3714q.removeCallbacks(runnable);
            }
            return false;
        }

        /* renamed from: a */
        public void mo4765a(RecyclerView recyclerView, C1266p pVar) {
            mo5159e(recyclerView);
        }

        /* renamed from: s */
        public boolean mo5182s() {
            return this.f3714q != null && this.f3714q.mClipToPadding;
        }

        /* renamed from: c */
        public void mo4750c(C1266p pVar, C1274u uVar) {
            Log.e(RecyclerView.TAG, "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        /* renamed from: a */
        public C1259j mo4732a(LayoutParams layoutParams) {
            if (layoutParams instanceof C1259j) {
                return new C1259j((C1259j) layoutParams);
            }
            if (layoutParams instanceof MarginLayoutParams) {
                return new C1259j((MarginLayoutParams) layoutParams);
            }
            return new C1259j(layoutParams);
        }

        /* renamed from: a */
        public C1259j mo4731a(Context context, AttributeSet attributeSet) {
            return new C1259j(context, attributeSet);
        }

        /* renamed from: a */
        public void mo4766a(RecyclerView recyclerView, C1274u uVar, int i) {
            Log.e(RecyclerView.TAG, "You must override smoothScrollToPosition to support smooth scrolling");
        }

        /* renamed from: a */
        public void mo5125a(C1271t tVar) {
            if (!(this.f3717t == null || tVar == this.f3717t || !this.f3717t.mo5278h())) {
                this.f3717t.mo5276f();
            }
            this.f3717t = tVar;
            this.f3717t.mo5269a(this.f3714q, this);
        }

        /* renamed from: t */
        public boolean mo5183t() {
            return this.f3717t != null && this.f3717t.mo5278h();
        }

        /* renamed from: u */
        public int mo5184u() {
            return C0962r.m3579f(this.f3714q);
        }

        /* renamed from: a */
        public void mo5110a(View view) {
            mo5111a(view, -1);
        }

        /* renamed from: a */
        public void mo5111a(View view, int i) {
            m4786a(view, i, true);
        }

        /* renamed from: b */
        public void mo5138b(View view) {
            mo5139b(view, -1);
        }

        /* renamed from: b */
        public void mo5139b(View view, int i) {
            m4786a(view, i, false);
        }

        /* renamed from: a */
        private void m4786a(View view, int i, boolean z) {
            C1277x childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (z || childViewHolderInt.isRemoved()) {
                this.f3714q.mViewInfoStore.mo5584e(childViewHolderInt);
            } else {
                this.f3714q.mViewInfoStore.mo5585f(childViewHolderInt);
            }
            C1259j jVar = (C1259j) view.getLayoutParams();
            if (childViewHolderInt.wasReturnedFromScrap() || childViewHolderInt.isScrap()) {
                if (childViewHolderInt.isScrap()) {
                    childViewHolderInt.unScrap();
                } else {
                    childViewHolderInt.clearReturnedFromScrapFlag();
                }
                this.f3713p.mo5443a(view, i, view.getLayoutParams(), false);
            } else if (view.getParent() == this.f3714q) {
                int b = this.f3713p.mo5447b(view);
                if (i == -1) {
                    i = this.f3713p.mo5446b();
                }
                if (b == -1) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:");
                    sb.append(this.f3714q.indexOfChild(view));
                    sb.append(this.f3714q.exceptionLabel());
                    throw new IllegalStateException(sb.toString());
                } else if (b != i) {
                    this.f3714q.mLayout.mo5158e(b, i);
                }
            } else {
                this.f3713p.mo5444a(view, i, false);
                jVar.f3731e = true;
                if (this.f3717t != null && this.f3717t.mo5278h()) {
                    this.f3717t.mo5271b(view);
                }
            }
            if (jVar.f3732f) {
                childViewHolderInt.itemView.invalidate();
                jVar.f3732f = false;
            }
        }

        /* renamed from: c */
        public void mo5147c(View view) {
            this.f3713p.mo5442a(view);
        }

        /* renamed from: g */
        public void mo5165g(int i) {
            if (mo5169i(i) != null) {
                this.f3713p.mo5441a(i);
            }
        }

        /* renamed from: d */
        public int mo5152d(View view) {
            return ((C1259j) view.getLayoutParams()).mo5199f();
        }

        /* renamed from: e */
        public View mo5157e(View view) {
            if (this.f3714q == null) {
                return null;
            }
            View findContainingItemView = this.f3714q.findContainingItemView(view);
            if (findContainingItemView != null && !this.f3713p.mo5451c(findContainingItemView)) {
                return findContainingItemView;
            }
            return null;
        }

        /* renamed from: c */
        public View mo4774c(int i) {
            int w = mo5186w();
            for (int i2 = 0; i2 < w; i2++) {
                View i3 = mo5169i(i2);
                C1277x childViewHolderInt = RecyclerView.getChildViewHolderInt(i3);
                if (childViewHolderInt != null && childViewHolderInt.getLayoutPosition() == i && !childViewHolderInt.shouldIgnore() && (this.f3714q.mState.mo5287a() || !childViewHolderInt.isRemoved())) {
                    return i3;
                }
            }
            return null;
        }

        /* renamed from: h */
        public void mo5167h(int i) {
            m4785a(i, mo5169i(i));
        }

        /* renamed from: a */
        private void m4785a(int i, View view) {
            this.f3713p.mo5454e(i);
        }

        /* renamed from: a */
        public void mo5114a(View view, int i, C1259j jVar) {
            C1277x childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isRemoved()) {
                this.f3714q.mViewInfoStore.mo5584e(childViewHolderInt);
            } else {
                this.f3714q.mViewInfoStore.mo5585f(childViewHolderInt);
            }
            this.f3713p.mo5443a(view, i, jVar, childViewHolderInt.isRemoved());
        }

        /* renamed from: c */
        public void mo5148c(View view, int i) {
            mo5114a(view, i, (C1259j) view.getLayoutParams());
        }

        /* renamed from: e */
        public void mo5158e(int i, int i2) {
            View i3 = mo5169i(i);
            if (i3 != null) {
                mo5167h(i);
                mo5148c(i3, i2);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot move a child from non-existing index:");
            sb.append(i);
            sb.append(this.f3714q.toString());
            throw new IllegalArgumentException(sb.toString());
        }

        /* renamed from: a */
        public void mo5117a(View view, C1266p pVar) {
            mo5147c(view);
            pVar.mo5226a(view);
        }

        /* renamed from: a */
        public void mo5109a(int i, C1266p pVar) {
            View i2 = mo5169i(i);
            mo5165g(i);
            pVar.mo5226a(i2);
        }

        /* renamed from: w */
        public int mo5186w() {
            if (this.f3713p != null) {
                return this.f3713p.mo5446b();
            }
            return 0;
        }

        /* renamed from: i */
        public View mo5169i(int i) {
            if (this.f3713p != null) {
                return this.f3713p.mo5448b(i);
            }
            return null;
        }

        /* renamed from: x */
        public int mo5187x() {
            return this.f3709e;
        }

        /* renamed from: y */
        public int mo5188y() {
            return this.f3710f;
        }

        /* renamed from: z */
        public int mo5189z() {
            return this.f3711g;
        }

        /* renamed from: A */
        public int mo5098A() {
            return this.f3712h;
        }

        /* renamed from: B */
        public int mo5099B() {
            if (this.f3714q != null) {
                return this.f3714q.getPaddingLeft();
            }
            return 0;
        }

        /* renamed from: C */
        public int mo5100C() {
            if (this.f3714q != null) {
                return this.f3714q.getPaddingTop();
            }
            return 0;
        }

        /* renamed from: D */
        public int mo5101D() {
            if (this.f3714q != null) {
                return this.f3714q.getPaddingRight();
            }
            return 0;
        }

        /* renamed from: E */
        public int mo5102E() {
            if (this.f3714q != null) {
                return this.f3714q.getPaddingBottom();
            }
            return 0;
        }

        /* renamed from: F */
        public View mo5103F() {
            if (this.f3714q == null) {
                return null;
            }
            View focusedChild = this.f3714q.getFocusedChild();
            if (focusedChild == null || this.f3713p.mo5451c(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        /* renamed from: j */
        public void mo5171j(int i) {
            if (this.f3714q != null) {
                this.f3714q.offsetChildrenHorizontal(i);
            }
        }

        /* renamed from: k */
        public void mo5173k(int i) {
            if (this.f3714q != null) {
                this.f3714q.offsetChildrenVertical(i);
            }
        }

        /* renamed from: a */
        public void mo5121a(C1266p pVar) {
            for (int w = mo5186w() - 1; w >= 0; w--) {
                m4787a(pVar, w, mo5169i(w));
            }
        }

        /* renamed from: a */
        private void m4787a(C1266p pVar, int i, View view) {
            C1277x childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (!childViewHolderInt.shouldIgnore()) {
                if (!childViewHolderInt.isInvalid() || childViewHolderInt.isRemoved() || this.f3714q.mAdapter.hasStableIds()) {
                    mo5167h(i);
                    pVar.mo5241c(view);
                    this.f3714q.mViewInfoStore.mo5587h(childViewHolderInt);
                } else {
                    mo5165g(i);
                    pVar.mo5237b(childViewHolderInt);
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo5141b(C1266p pVar) {
            int e = pVar.mo5246e();
            for (int i = e - 1; i >= 0; i--) {
                View e2 = pVar.mo5247e(i);
                C1277x childViewHolderInt = RecyclerView.getChildViewHolderInt(e2);
                if (!childViewHolderInt.shouldIgnore()) {
                    childViewHolderInt.setIsRecyclable(false);
                    if (childViewHolderInt.isTmpDetached()) {
                        this.f3714q.removeDetachedView(e2, false);
                    }
                    if (this.f3714q.mItemAnimator != null) {
                        this.f3714q.mItemAnimator.mo5078d(childViewHolderInt);
                    }
                    childViewHolderInt.setIsRecyclable(true);
                    pVar.mo5236b(e2);
                }
            }
            pVar.mo5249f();
            if (e > 0) {
                this.f3714q.invalidate();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo5127a(View view, int i, int i2, C1259j jVar) {
            return !this.f3707c || !m4788b(view.getMeasuredWidth(), i, jVar.width) || !m4788b(view.getMeasuredHeight(), i2, jVar.height);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public boolean mo5145b(View view, int i, int i2, C1259j jVar) {
            return view.isLayoutRequested() || !this.f3707c || !m4788b(view.getWidth(), i, jVar.width) || !m4788b(view.getHeight(), i2, jVar.height);
        }

        /* renamed from: b */
        private static boolean m4788b(int i, int i2, int i3) {
            int mode = MeasureSpec.getMode(i2);
            int size = MeasureSpec.getSize(i2);
            boolean z = false;
            if (i3 > 0 && i != i3) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                if (size >= i) {
                    z = true;
                }
                return z;
            } else if (mode == 0) {
                return true;
            } else {
                if (mode != 1073741824) {
                    return false;
                }
                if (size == i) {
                    z = true;
                }
                return z;
            }
        }

        /* renamed from: a */
        public void mo5112a(View view, int i, int i2) {
            C1259j jVar = (C1259j) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.f3714q.getItemDecorInsetsForChild(view);
            int i3 = i2 + itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom;
            int a = m4783a(mo5189z(), mo5187x(), mo5099B() + mo5101D() + jVar.leftMargin + jVar.rightMargin + i + itemDecorInsetsForChild.left + itemDecorInsetsForChild.right, jVar.width, mo4781e());
            int a2 = m4783a(mo5098A(), mo5188y(), mo5100C() + mo5102E() + jVar.topMargin + jVar.bottomMargin + i3, jVar.height, mo4784f());
            if (mo5145b(view, a, a2, jVar)) {
                view.measure(a, a2);
            }
        }

        /* renamed from: a */
        public static int m4783a(int i, int i2, int i3, int i4, boolean z) {
            int i5;
            int i6 = i - i3;
            int i7 = 0;
            int max = Math.max(0, i6);
            if (z) {
                if (i4 < 0) {
                    if (i4 == -1) {
                        if (i2 == Integer.MIN_VALUE || (i2 != 0 && i2 == 1073741824)) {
                            i5 = max;
                        } else {
                            i2 = 0;
                            i5 = 0;
                        }
                        i7 = i2;
                        max = i5;
                        return MeasureSpec.makeMeasureSpec(max, i7);
                    }
                    max = 0;
                    return MeasureSpec.makeMeasureSpec(max, i7);
                }
            } else if (i4 < 0) {
                if (i4 == -1) {
                    i7 = i2;
                } else {
                    if (i4 == -2) {
                        if (i2 == Integer.MIN_VALUE || i2 == 1073741824) {
                            i7 = C1024a.INVALID_ID;
                        }
                    }
                    max = 0;
                }
                return MeasureSpec.makeMeasureSpec(max, i7);
            }
            max = i4;
            i7 = Ints.MAX_POWER_OF_TWO;
            return MeasureSpec.makeMeasureSpec(max, i7);
        }

        /* renamed from: f */
        public int mo5161f(View view) {
            Rect rect = ((C1259j) view.getLayoutParams()).f3730d;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        /* renamed from: g */
        public int mo5164g(View view) {
            Rect rect = ((C1259j) view.getLayoutParams()).f3730d;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        /* renamed from: a */
        public void mo5113a(View view, int i, int i2, int i3, int i4) {
            C1259j jVar = (C1259j) view.getLayoutParams();
            Rect rect = jVar.f3730d;
            view.layout(i + rect.left + jVar.leftMargin, i2 + rect.top + jVar.topMargin, (i3 - rect.right) - jVar.rightMargin, (i4 - rect.bottom) - jVar.bottomMargin);
        }

        /* renamed from: a */
        public void mo5118a(View view, boolean z, Rect rect) {
            if (z) {
                Rect rect2 = ((C1259j) view.getLayoutParams()).f3730d;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.f3714q != null) {
                Matrix matrix = view.getMatrix();
                if (matrix != null && !matrix.isIdentity()) {
                    RectF rectF = this.f3714q.mTempRectF;
                    rectF.set(rect);
                    matrix.mapRect(rectF);
                    rect.set((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
                }
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        /* renamed from: a */
        public void mo5115a(View view, Rect rect) {
            RecyclerView.getDecoratedBoundsWithMarginsInt(view, rect);
        }

        /* renamed from: h */
        public int mo5166h(View view) {
            return view.getLeft() - mo5177n(view);
        }

        /* renamed from: i */
        public int mo5168i(View view) {
            return view.getTop() - mo5174l(view);
        }

        /* renamed from: j */
        public int mo5170j(View view) {
            return view.getRight() + mo5178o(view);
        }

        /* renamed from: k */
        public int mo5172k(View view) {
            return view.getBottom() + mo5176m(view);
        }

        /* renamed from: b */
        public void mo5140b(View view, Rect rect) {
            if (this.f3714q == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(this.f3714q.getItemDecorInsetsForChild(view));
            }
        }

        /* renamed from: l */
        public int mo5174l(View view) {
            return ((C1259j) view.getLayoutParams()).f3730d.top;
        }

        /* renamed from: m */
        public int mo5176m(View view) {
            return ((C1259j) view.getLayoutParams()).f3730d.bottom;
        }

        /* renamed from: n */
        public int mo5177n(View view) {
            return ((C1259j) view.getLayoutParams()).f3730d.left;
        }

        /* renamed from: o */
        public int mo5178o(View view) {
            return ((C1259j) view.getLayoutParams()).f3730d.right;
        }

        /* renamed from: b */
        private int[] m4789b(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            int[] iArr = new int[2];
            int B = mo5099B();
            int C = mo5100C();
            int z2 = mo5189z() - mo5101D();
            int A = mo5098A() - mo5102E();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width = rect.width() + left;
            int height = rect.height() + top;
            int i = left - B;
            int min = Math.min(0, i);
            int i2 = top - C;
            int min2 = Math.min(0, i2);
            int i3 = width - z2;
            int max = Math.max(0, i3);
            int max2 = Math.max(0, height - A);
            if (mo5184u() != 1) {
                if (min == 0) {
                    min = Math.min(i, max);
                }
                max = min;
            } else if (max == 0) {
                max = Math.max(min, i3);
            }
            if (min2 == 0) {
                min2 = Math.min(i2, max2);
            }
            iArr[0] = max;
            iArr[1] = min2;
            return iArr;
        }

        /* renamed from: a */
        public boolean mo5132a(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return mo5133a(recyclerView, view, rect, z, false);
        }

        /* renamed from: a */
        public boolean mo5133a(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            int[] b = m4789b(recyclerView, view, rect, z);
            int i = b[0];
            int i2 = b[1];
            if ((z2 && !m4790d(recyclerView, i, i2)) || (i == 0 && i2 == 0)) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(i, i2);
            } else {
                recyclerView.smoothScrollBy(i, i2);
            }
            return true;
        }

        /* renamed from: a */
        public boolean mo5129a(View view, boolean z, boolean z2) {
            boolean z3 = this.f3715r.mo5566a(view, 24579) && this.f3716s.mo5566a(view, 24579);
            return z ? z3 : !z3;
        }

        /* renamed from: d */
        private boolean m4790d(RecyclerView recyclerView, int i, int i2) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int B = mo5099B();
            int C = mo5100C();
            int z = mo5189z() - mo5101D();
            int A = mo5098A() - mo5102E();
            Rect rect = this.f3714q.mTempRect;
            mo5115a(focusedChild, rect);
            if (rect.left - i >= z || rect.right - i <= B || rect.top - i2 >= A || rect.bottom - i2 <= C) {
                return false;
            }
            return true;
        }

        @Deprecated
        /* renamed from: a */
        public boolean mo5134a(RecyclerView recyclerView, View view, View view2) {
            return mo5183t() || recyclerView.isComputingLayout();
        }

        /* renamed from: a */
        public boolean mo5135a(RecyclerView recyclerView, C1274u uVar, View view, View view2) {
            return mo5134a(recyclerView, view, view2);
        }

        /* renamed from: a */
        public void mo4743a(RecyclerView recyclerView, int i, int i2, Object obj) {
            mo5151c(recyclerView, i, i2);
        }

        /* renamed from: a */
        public void mo5122a(C1266p pVar, C1274u uVar, int i, int i2) {
            this.f3714q.defaultOnMeasure(i, i2);
        }

        /* renamed from: f */
        public void mo5162f(int i, int i2) {
            this.f3714q.setMeasuredDimension(i, i2);
        }

        /* renamed from: G */
        public int mo5104G() {
            return C0962r.m3589l(this.f3714q);
        }

        /* renamed from: H */
        public int mo5105H() {
            return C0962r.m3590m(this.f3714q);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: I */
        public void mo5106I() {
            if (this.f3717t != null) {
                this.f3717t.mo5276f();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo5142b(C1271t tVar) {
            if (this.f3717t == tVar) {
                this.f3717t = null;
            }
        }

        /* renamed from: c */
        public void mo5149c(C1266p pVar) {
            for (int w = mo5186w() - 1; w >= 0; w--) {
                if (!RecyclerView.getChildViewHolderInt(mo5169i(w)).shouldIgnore()) {
                    mo5109a(w, pVar);
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo5119a(C0935b bVar) {
            mo5124a(this.f3714q.mRecycler, this.f3714q.mState, bVar);
        }

        /* renamed from: a */
        public void mo5124a(C1266p pVar, C1274u uVar, C0935b bVar) {
            if (this.f3714q.canScrollVertically(-1) || this.f3714q.canScrollHorizontally(-1)) {
                bVar.mo3669a(8192);
                bVar.mo3703i(true);
            }
            if (this.f3714q.canScrollVertically(1) || this.f3714q.canScrollHorizontally(1)) {
                bVar.mo3669a(4096);
                bVar.mo3703i(true);
            }
            bVar.mo3674a((Object) C0937b.m3470a(mo4727a(pVar, uVar), mo4747b(pVar, uVar), mo5160e(pVar, uVar), mo5153d(pVar, uVar)));
        }

        /* renamed from: a */
        public void mo4764a(AccessibilityEvent accessibilityEvent) {
            mo5123a(this.f3714q.mRecycler, this.f3714q.mState, accessibilityEvent);
        }

        /* renamed from: a */
        public void mo5123a(C1266p pVar, C1274u uVar, AccessibilityEvent accessibilityEvent) {
            if (this.f3714q != null && accessibilityEvent != null) {
                boolean z = true;
                if (!this.f3714q.canScrollVertically(1) && !this.f3714q.canScrollVertically(-1) && !this.f3714q.canScrollHorizontally(-1) && !this.f3714q.canScrollHorizontally(1)) {
                    z = false;
                }
                accessibilityEvent.setScrollable(z);
                if (this.f3714q.mAdapter != null) {
                    accessibilityEvent.setItemCount(this.f3714q.mAdapter.getItemCount());
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo5116a(View view, C0935b bVar) {
            C1277x childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && !this.f3713p.mo5451c(childViewHolderInt.itemView)) {
                mo4735a(this.f3714q.mRecycler, this.f3714q.mState, view, bVar);
            }
        }

        /* renamed from: a */
        public void mo4735a(C1266p pVar, C1274u uVar, View view, C0935b bVar) {
            bVar.mo3680b((Object) C0938c.m3471a(mo4784f() ? mo5152d(view) : 0, 1, mo4781e() ? mo5152d(view) : 0, 1, false, false));
        }

        /* renamed from: J */
        public void mo5107J() {
            this.f3718u = true;
        }

        /* renamed from: a */
        public int mo4727a(C1266p pVar, C1274u uVar) {
            int i = 1;
            if (this.f3714q == null || this.f3714q.mAdapter == null) {
                return 1;
            }
            if (mo4784f()) {
                i = this.f3714q.mAdapter.getItemCount();
            }
            return i;
        }

        /* renamed from: b */
        public int mo4747b(C1266p pVar, C1274u uVar) {
            int i = 1;
            if (this.f3714q == null || this.f3714q.mAdapter == null) {
                return 1;
            }
            if (mo4781e()) {
                i = this.f3714q.mAdapter.getItemCount();
            }
            return i;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo5126a(int i, Bundle bundle) {
            return mo5130a(this.f3714q.mRecycler, this.f3714q.mState, i, bundle);
        }

        /* JADX WARNING: Removed duplicated region for block: B:24:0x0074 A[ADDED_TO_REGION] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean mo5130a(androidx.recyclerview.widget.RecyclerView.C1266p r2, androidx.recyclerview.widget.RecyclerView.C1274u r3, int r4, android.os.Bundle r5) {
            /*
                r1 = this;
                androidx.recyclerview.widget.RecyclerView r2 = r1.f3714q
                r3 = 0
                if (r2 != 0) goto L_0x0006
                return r3
            L_0x0006:
                r2 = 4096(0x1000, float:5.74E-42)
                r5 = 1
                if (r4 == r2) goto L_0x0044
                r2 = 8192(0x2000, float:1.14794E-41)
                if (r4 == r2) goto L_0x0012
                r2 = 0
            L_0x0010:
                r4 = 0
                goto L_0x0072
            L_0x0012:
                androidx.recyclerview.widget.RecyclerView r2 = r1.f3714q
                r4 = -1
                boolean r2 = r2.canScrollVertically(r4)
                if (r2 == 0) goto L_0x002b
                int r2 = r1.mo5098A()
                int r0 = r1.mo5100C()
                int r2 = r2 - r0
                int r0 = r1.mo5102E()
                int r2 = r2 - r0
                int r2 = -r2
                goto L_0x002c
            L_0x002b:
                r2 = 0
            L_0x002c:
                androidx.recyclerview.widget.RecyclerView r0 = r1.f3714q
                boolean r4 = r0.canScrollHorizontally(r4)
                if (r4 == 0) goto L_0x0010
                int r4 = r1.mo5189z()
                int r0 = r1.mo5099B()
                int r4 = r4 - r0
                int r0 = r1.mo5101D()
                int r4 = r4 - r0
                int r4 = -r4
                goto L_0x0072
            L_0x0044:
                androidx.recyclerview.widget.RecyclerView r2 = r1.f3714q
                boolean r2 = r2.canScrollVertically(r5)
                if (r2 == 0) goto L_0x005b
                int r2 = r1.mo5098A()
                int r4 = r1.mo5100C()
                int r2 = r2 - r4
                int r4 = r1.mo5102E()
                int r2 = r2 - r4
                goto L_0x005c
            L_0x005b:
                r2 = 0
            L_0x005c:
                androidx.recyclerview.widget.RecyclerView r4 = r1.f3714q
                boolean r4 = r4.canScrollHorizontally(r5)
                if (r4 == 0) goto L_0x0010
                int r4 = r1.mo5189z()
                int r0 = r1.mo5099B()
                int r4 = r4 - r0
                int r0 = r1.mo5101D()
                int r4 = r4 - r0
            L_0x0072:
                if (r2 != 0) goto L_0x0077
                if (r4 != 0) goto L_0x0077
                return r3
            L_0x0077:
                androidx.recyclerview.widget.RecyclerView r3 = r1.f3714q
                r3.smoothScrollBy(r4, r2)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.C1254i.mo5130a(androidx.recyclerview.widget.RecyclerView$p, androidx.recyclerview.widget.RecyclerView$u, int, android.os.Bundle):boolean");
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo5128a(View view, int i, Bundle bundle) {
            return mo5131a(this.f3714q.mRecycler, this.f3714q.mState, view, i, bundle);
        }

        /* renamed from: a */
        public static C1258b m4784a(Context context, AttributeSet attributeSet, int i, int i2) {
            C1258b bVar = new C1258b();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RecyclerView, i, i2);
            bVar.f3725a = obtainStyledAttributes.getInt(R.styleable.RecyclerView_android_orientation, 1);
            bVar.f3726b = obtainStyledAttributes.getInt(R.styleable.RecyclerView_spanCount, 1);
            bVar.f3727c = obtainStyledAttributes.getBoolean(R.styleable.RecyclerView_reverseLayout, false);
            bVar.f3728d = obtainStyledAttributes.getBoolean(R.styleable.RecyclerView_stackFromEnd, false);
            obtainStyledAttributes.recycle();
            return bVar;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: f */
        public void mo5163f(RecyclerView recyclerView) {
            mo5146c(MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), Ints.MAX_POWER_OF_TWO), MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), Ints.MAX_POWER_OF_TWO));
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: K */
        public boolean mo5108K() {
            int w = mo5186w();
            for (int i = 0; i < w; i++) {
                LayoutParams layoutParams = mo5169i(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$j */
    public static class C1259j extends MarginLayoutParams {

        /* renamed from: c */
        C1277x f3729c;

        /* renamed from: d */
        final Rect f3730d = new Rect();

        /* renamed from: e */
        boolean f3731e = true;

        /* renamed from: f */
        boolean f3732f = false;

        public C1259j(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C1259j(int i, int i2) {
            super(i, i2);
        }

        public C1259j(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public C1259j(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public C1259j(C1259j jVar) {
            super(jVar);
        }

        /* renamed from: c */
        public boolean mo5196c() {
            return this.f3729c.isInvalid();
        }

        /* renamed from: d */
        public boolean mo5197d() {
            return this.f3729c.isRemoved();
        }

        /* renamed from: e */
        public boolean mo5198e() {
            return this.f3729c.isUpdated();
        }

        /* renamed from: f */
        public int mo5199f() {
            return this.f3729c.getLayoutPosition();
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$k */
    public interface C1260k {
        /* renamed from: a */
        void mo5200a(View view);

        /* renamed from: b */
        void mo5201b(View view);
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$l */
    public static abstract class C1261l {
        /* renamed from: a */
        public abstract boolean mo5202a(int i, int i2);
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$m */
    public interface C1262m {
        /* renamed from: a */
        void mo5203a(boolean z);

        /* renamed from: a */
        boolean mo5204a(RecyclerView recyclerView, MotionEvent motionEvent);

        /* renamed from: b */
        void mo5205b(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$n */
    public static abstract class C1263n {
        /* renamed from: a */
        public void mo5206a(RecyclerView recyclerView, int i) {
        }

        /* renamed from: a */
        public void mo5207a(RecyclerView recyclerView, int i, int i2) {
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$o */
    public static class C1264o {

        /* renamed from: a */
        SparseArray<C1265a> f3733a = new SparseArray<>();

        /* renamed from: b */
        private int f3734b = 0;

        /* renamed from: androidx.recyclerview.widget.RecyclerView$o$a */
        static class C1265a {

            /* renamed from: a */
            final ArrayList<C1277x> f3735a = new ArrayList<>();

            /* renamed from: b */
            int f3736b = 5;

            /* renamed from: c */
            long f3737c = 0;

            /* renamed from: d */
            long f3738d = 0;

            C1265a() {
            }
        }

        /* renamed from: a */
        public void mo5210a() {
            for (int i = 0; i < this.f3733a.size(); i++) {
                ((C1265a) this.f3733a.valueAt(i)).f3735a.clear();
            }
        }

        /* renamed from: a */
        public C1277x mo5209a(int i) {
            C1265a aVar = (C1265a) this.f3733a.get(i);
            if (aVar == null || aVar.f3735a.isEmpty()) {
                return null;
            }
            ArrayList<C1277x> arrayList = aVar.f3735a;
            return (C1277x) arrayList.remove(arrayList.size() - 1);
        }

        /* renamed from: a */
        public void mo5213a(C1277x xVar) {
            int itemViewType = xVar.getItemViewType();
            ArrayList<C1277x> arrayList = m4945b(itemViewType).f3735a;
            if (((C1265a) this.f3733a.get(itemViewType)).f3736b > arrayList.size()) {
                xVar.resetInternal();
                arrayList.add(xVar);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public long mo5208a(long j, long j2) {
            return j == 0 ? j2 : ((j / 4) * 3) + (j2 / 4);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo5211a(int i, long j) {
            C1265a b = m4945b(i);
            b.f3737c = mo5208a(b.f3737c, j);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo5216b(int i, long j) {
            C1265a b = m4945b(i);
            b.f3738d = mo5208a(b.f3738d, j);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo5214a(int i, long j, long j2) {
            long j3 = m4945b(i).f3737c;
            return j3 == 0 || j + j3 < j2;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public boolean mo5217b(int i, long j, long j2) {
            long j3 = m4945b(i).f3738d;
            return j3 == 0 || j + j3 < j2;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo5215b() {
            this.f3734b++;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public void mo5218c() {
            this.f3734b--;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo5212a(C1243a aVar, C1243a aVar2, boolean z) {
            if (aVar != null) {
                mo5218c();
            }
            if (!z && this.f3734b == 0) {
                mo5210a();
            }
            if (aVar2 != null) {
                mo5215b();
            }
        }

        /* renamed from: b */
        private C1265a m4945b(int i) {
            C1265a aVar = (C1265a) this.f3733a.get(i);
            if (aVar != null) {
                return aVar;
            }
            C1265a aVar2 = new C1265a();
            this.f3733a.put(i, aVar2);
            return aVar2;
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$p */
    public final class C1266p {

        /* renamed from: a */
        final ArrayList<C1277x> f3739a = new ArrayList<>();

        /* renamed from: b */
        ArrayList<C1277x> f3740b = null;

        /* renamed from: c */
        final ArrayList<C1277x> f3741c = new ArrayList<>();

        /* renamed from: d */
        int f3742d = 2;

        /* renamed from: e */
        C1264o f3743e;

        /* renamed from: g */
        private final List<C1277x> f3745g = Collections.unmodifiableList(this.f3739a);

        /* renamed from: h */
        private int f3746h = 2;

        /* renamed from: i */
        private C1275v f3747i;

        public C1266p() {
        }

        /* renamed from: a */
        public void mo5222a() {
            this.f3739a.clear();
            mo5243d();
        }

        /* renamed from: a */
        public void mo5223a(int i) {
            this.f3746h = i;
            mo5234b();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo5234b() {
            this.f3742d = this.f3746h + (RecyclerView.this.mLayout != null ? RecyclerView.this.mLayout.f3721x : 0);
            for (int size = this.f3741c.size() - 1; size >= 0 && this.f3741c.size() > this.f3742d; size--) {
                mo5244d(size);
            }
        }

        /* renamed from: c */
        public List<C1277x> mo5239c() {
            return this.f3745g;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo5231a(C1277x xVar) {
            if (xVar.isRemoved()) {
                return RecyclerView.this.mState.mo5287a();
            }
            if (xVar.mPosition < 0 || xVar.mPosition >= RecyclerView.this.mAdapter.getItemCount()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Inconsistency detected. Invalid view holder adapter position");
                sb.append(xVar);
                sb.append(RecyclerView.this.exceptionLabel());
                throw new IndexOutOfBoundsException(sb.toString());
            }
            boolean z = false;
            if (!RecyclerView.this.mState.mo5287a() && RecyclerView.this.mAdapter.getItemViewType(xVar.mPosition) != xVar.getItemViewType()) {
                return false;
            }
            if (!RecyclerView.this.mAdapter.hasStableIds()) {
                return true;
            }
            if (xVar.getItemId() == RecyclerView.this.mAdapter.getItemId(xVar.mPosition)) {
                z = true;
            }
            return z;
        }

        /* renamed from: a */
        private boolean m4958a(C1277x xVar, int i, int i2, long j) {
            xVar.mOwnerRecyclerView = RecyclerView.this;
            int itemViewType = xVar.getItemViewType();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j != RecyclerView.FOREVER_NS && !this.f3743e.mo5217b(itemViewType, nanoTime, j)) {
                return false;
            }
            RecyclerView.this.mAdapter.bindViewHolder(xVar, i);
            this.f3743e.mo5216b(xVar.getItemViewType(), RecyclerView.this.getNanoTime() - nanoTime);
            m4959e(xVar);
            if (RecyclerView.this.mState.mo5287a()) {
                xVar.mPreLayoutPosition = i2;
            }
            return true;
        }

        /* renamed from: b */
        public int mo5232b(int i) {
            if (i < 0 || i >= RecyclerView.this.mState.mo5291e()) {
                StringBuilder sb = new StringBuilder();
                sb.append("invalid position ");
                sb.append(i);
                sb.append(". State ");
                sb.append("item count is ");
                sb.append(RecyclerView.this.mState.mo5291e());
                sb.append(RecyclerView.this.exceptionLabel());
                throw new IndexOutOfBoundsException(sb.toString());
            } else if (!RecyclerView.this.mState.mo5287a()) {
                return i;
            } else {
                return RecyclerView.this.mAdapterHelper.mo5427b(i);
            }
        }

        /* renamed from: c */
        public View mo5238c(int i) {
            return mo5219a(i, false);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public View mo5219a(int i, boolean z) {
            return mo5220a(i, z, (long) RecyclerView.FOREVER_NS).itemView;
        }

        /* access modifiers changed from: 0000 */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x002b  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x005f  */
        /* JADX WARNING: Removed duplicated region for block: B:78:0x01aa  */
        /* JADX WARNING: Removed duplicated region for block: B:81:0x01cf  */
        /* JADX WARNING: Removed duplicated region for block: B:94:0x0208  */
        /* JADX WARNING: Removed duplicated region for block: B:95:0x0216  */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public androidx.recyclerview.widget.RecyclerView.C1277x mo5220a(int r17, boolean r18, long r19) {
            /*
                r16 = this;
                r6 = r16
                r3 = r17
                r0 = r18
                if (r3 < 0) goto L_0x0239
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$u r1 = r1.mState
                int r1 = r1.mo5291e()
                if (r3 >= r1) goto L_0x0239
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$u r1 = r1.mState
                boolean r1 = r1.mo5287a()
                r2 = 0
                r7 = 1
                r8 = 0
                if (r1 == 0) goto L_0x0027
                androidx.recyclerview.widget.RecyclerView$x r1 = r16.mo5248f(r17)
                if (r1 == 0) goto L_0x0028
                r4 = 1
                goto L_0x0029
            L_0x0027:
                r1 = r2
            L_0x0028:
                r4 = 0
            L_0x0029:
                if (r1 != 0) goto L_0x005d
                androidx.recyclerview.widget.RecyclerView$x r1 = r16.mo5233b(r17, r18)
                if (r1 == 0) goto L_0x005d
                boolean r5 = r6.mo5231a(r1)
                if (r5 != 0) goto L_0x005c
                if (r0 != 0) goto L_0x005a
                r5 = 4
                r1.addFlags(r5)
                boolean r5 = r1.isScrap()
                if (r5 == 0) goto L_0x004e
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                android.view.View r9 = r1.itemView
                r5.removeDetachedView(r9, r8)
                r1.unScrap()
                goto L_0x0057
            L_0x004e:
                boolean r5 = r1.wasReturnedFromScrap()
                if (r5 == 0) goto L_0x0057
                r1.clearReturnedFromScrapFlag()
            L_0x0057:
                r6.mo5237b(r1)
            L_0x005a:
                r1 = r2
                goto L_0x005d
            L_0x005c:
                r4 = 1
            L_0x005d:
                if (r1 != 0) goto L_0x0189
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.a r5 = r5.mAdapterHelper
                int r5 = r5.mo5427b(r3)
                if (r5 < 0) goto L_0x014c
                androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$a r9 = r9.mAdapter
                int r9 = r9.getItemCount()
                if (r5 >= r9) goto L_0x014c
                androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$a r9 = r9.mAdapter
                int r9 = r9.getItemViewType(r5)
                androidx.recyclerview.widget.RecyclerView r10 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$a r10 = r10.mAdapter
                boolean r10 = r10.hasStableIds()
                if (r10 == 0) goto L_0x0096
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$a r1 = r1.mAdapter
                long r10 = r1.getItemId(r5)
                androidx.recyclerview.widget.RecyclerView$x r1 = r6.mo5221a(r10, r9, r0)
                if (r1 == 0) goto L_0x0096
                r1.mPosition = r5
                r4 = 1
            L_0x0096:
                if (r1 != 0) goto L_0x00ed
                androidx.recyclerview.widget.RecyclerView$v r0 = r6.f3747i
                if (r0 == 0) goto L_0x00ed
                androidx.recyclerview.widget.RecyclerView$v r0 = r6.f3747i
                android.view.View r0 = r0.mo5293a(r6, r3, r9)
                if (r0 == 0) goto L_0x00ed
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$x r1 = r1.getChildViewHolder(r0)
                if (r1 == 0) goto L_0x00d0
                boolean r0 = r1.shouldIgnore()
                if (r0 != 0) goto L_0x00b3
                goto L_0x00ed
            L_0x00b3:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view."
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.exceptionLabel()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x00d0:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "getViewForPositionAndType returned a view which does not have a ViewHolder"
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.exceptionLabel()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x00ed:
                if (r1 != 0) goto L_0x0103
                androidx.recyclerview.widget.RecyclerView$o r0 = r16.mo5250g()
                androidx.recyclerview.widget.RecyclerView$x r1 = r0.mo5209a(r9)
                if (r1 == 0) goto L_0x0103
                r1.resetInternal()
                boolean r0 = androidx.recyclerview.widget.RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST
                if (r0 == 0) goto L_0x0103
                r6.m4960f(r1)
            L_0x0103:
                if (r1 != 0) goto L_0x0189
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                long r0 = r0.getNanoTime()
                r10 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r5 = (r19 > r10 ? 1 : (r19 == r10 ? 0 : -1))
                if (r5 == 0) goto L_0x0121
                androidx.recyclerview.widget.RecyclerView$o r10 = r6.f3743e
                r11 = r9
                r12 = r0
                r14 = r19
                boolean r5 = r10.mo5214a(r11, r12, r14)
                if (r5 != 0) goto L_0x0121
                return r2
            L_0x0121:
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$a r2 = r2.mAdapter
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$x r2 = r2.createViewHolder(r5, r9)
                boolean r5 = androidx.recyclerview.widget.RecyclerView.ALLOW_THREAD_GAP_WORK
                if (r5 == 0) goto L_0x013e
                android.view.View r5 = r2.itemView
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.findNestedRecyclerView(r5)
                if (r5 == 0) goto L_0x013e
                java.lang.ref.WeakReference r10 = new java.lang.ref.WeakReference
                r10.<init>(r5)
                r2.mNestedRecyclerView = r10
            L_0x013e:
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                long r10 = r5.getNanoTime()
                androidx.recyclerview.widget.RecyclerView$o r5 = r6.f3743e
                long r10 = r10 - r0
                r5.mo5211a(r9, r10)
                r10 = r2
                goto L_0x018a
            L_0x014c:
                java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Inconsistency detected. Invalid item position "
                r1.append(r2)
                r1.append(r3)
                java.lang.String r2 = "(offset:"
                r1.append(r2)
                r1.append(r5)
                java.lang.String r2 = ")."
                r1.append(r2)
                java.lang.String r2 = "state:"
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$u r2 = r2.mState
                int r2 = r2.mo5291e()
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.exceptionLabel()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x0189:
                r10 = r1
            L_0x018a:
                r9 = r4
                if (r9 == 0) goto L_0x01c5
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$u r0 = r0.mState
                boolean r0 = r0.mo5287a()
                if (r0 != 0) goto L_0x01c5
                r0 = 8192(0x2000, float:1.14794E-41)
                boolean r1 = r10.hasAnyOfTheFlags(r0)
                if (r1 == 0) goto L_0x01c5
                r10.setFlags(r8, r0)
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$u r0 = r0.mState
                boolean r0 = r0.f3774j
                if (r0 == 0) goto L_0x01c5
                int r0 = androidx.recyclerview.widget.RecyclerView.C1248f.m4749e(r10)
                r0 = r0 | 4096(0x1000, float:5.74E-42)
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$f r1 = r1.mItemAnimator
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$u r2 = r2.mState
                java.util.List r4 = r10.getUnmodifiedPayloads()
                androidx.recyclerview.widget.RecyclerView$f$c r0 = r1.mo5068a(r2, r10, r0, r4)
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                r1.recordAnimationInfoIfBouncedHiddenView(r10, r0)
            L_0x01c5:
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$u r0 = r0.mState
                boolean r0 = r0.mo5287a()
                if (r0 == 0) goto L_0x01d8
                boolean r0 = r10.isBound()
                if (r0 == 0) goto L_0x01d8
                r10.mPreLayoutPosition = r3
                goto L_0x01eb
            L_0x01d8:
                boolean r0 = r10.isBound()
                if (r0 == 0) goto L_0x01ed
                boolean r0 = r10.needsUpdate()
                if (r0 != 0) goto L_0x01ed
                boolean r0 = r10.isInvalid()
                if (r0 == 0) goto L_0x01eb
                goto L_0x01ed
            L_0x01eb:
                r0 = 0
                goto L_0x0200
            L_0x01ed:
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.a r0 = r0.mAdapterHelper
                int r2 = r0.mo5427b(r3)
                r0 = r16
                r1 = r10
                r3 = r17
                r4 = r19
                boolean r0 = r0.m4958a(r1, r2, r3, r4)
            L_0x0200:
                android.view.View r1 = r10.itemView
                android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
                if (r1 != 0) goto L_0x0216
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                android.view.ViewGroup$LayoutParams r1 = r1.generateDefaultLayoutParams()
                androidx.recyclerview.widget.RecyclerView$j r1 = (androidx.recyclerview.widget.RecyclerView.C1259j) r1
                android.view.View r2 = r10.itemView
                r2.setLayoutParams(r1)
                goto L_0x022e
            L_0x0216:
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                boolean r2 = r2.checkLayoutParams(r1)
                if (r2 != 0) goto L_0x022c
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                android.view.ViewGroup$LayoutParams r1 = r2.generateLayoutParams(r1)
                androidx.recyclerview.widget.RecyclerView$j r1 = (androidx.recyclerview.widget.RecyclerView.C1259j) r1
                android.view.View r2 = r10.itemView
                r2.setLayoutParams(r1)
                goto L_0x022e
            L_0x022c:
                androidx.recyclerview.widget.RecyclerView$j r1 = (androidx.recyclerview.widget.RecyclerView.C1259j) r1
            L_0x022e:
                r1.f3729c = r10
                if (r9 == 0) goto L_0x0235
                if (r0 == 0) goto L_0x0235
                goto L_0x0236
            L_0x0235:
                r7 = 0
            L_0x0236:
                r1.f3732f = r7
                return r10
            L_0x0239:
                java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Invalid item position "
                r1.append(r2)
                r1.append(r3)
                java.lang.String r2 = "("
                r1.append(r2)
                r1.append(r3)
                java.lang.String r2 = "). Item count:"
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$u r2 = r2.mState
                int r2 = r2.mo5291e()
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.exceptionLabel()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.C1266p.mo5220a(int, boolean, long):androidx.recyclerview.widget.RecyclerView$x");
        }

        /* renamed from: e */
        private void m4959e(C1277x xVar) {
            if (RecyclerView.this.isAccessibilityEnabled()) {
                View view = xVar.itemView;
                if (C0962r.m3577e(view) == 0) {
                    C0962r.m3569b(view, 1);
                }
                if (!C0962r.m3571b(view)) {
                    xVar.addFlags(16384);
                    C0962r.m3559a(view, RecyclerView.this.mAccessibilityDelegate.getItemDelegate());
                }
            }
        }

        /* renamed from: f */
        private void m4960f(C1277x xVar) {
            if (xVar.itemView instanceof ViewGroup) {
                m4957a((ViewGroup) xVar.itemView, false);
            }
        }

        /* renamed from: a */
        private void m4957a(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    m4957a((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                } else {
                    int visibility = viewGroup.getVisibility();
                    viewGroup.setVisibility(4);
                    viewGroup.setVisibility(visibility);
                }
            }
        }

        /* renamed from: a */
        public void mo5226a(View view) {
            C1277x childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (childViewHolderInt.isScrap()) {
                childViewHolderInt.unScrap();
            } else if (childViewHolderInt.wasReturnedFromScrap()) {
                childViewHolderInt.clearReturnedFromScrapFlag();
            }
            mo5237b(childViewHolderInt);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public void mo5243d() {
            for (int size = this.f3741c.size() - 1; size >= 0; size--) {
                mo5244d(size);
            }
            this.f3741c.clear();
            if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                RecyclerView.this.mPrefetchRegistry.mo5510a();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public void mo5244d(int i) {
            mo5230a((C1277x) this.f3741c.get(i), true);
            this.f3741c.remove(i);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo5237b(C1277x xVar) {
            boolean z;
            boolean z2 = false;
            if (xVar.isScrap() || xVar.itemView.getParent() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Scrapped or attached views may not be recycled. isScrap:");
                sb.append(xVar.isScrap());
                sb.append(" isAttached:");
                if (xVar.itemView.getParent() != null) {
                    z2 = true;
                }
                sb.append(z2);
                sb.append(RecyclerView.this.exceptionLabel());
                throw new IllegalArgumentException(sb.toString());
            } else if (xVar.isTmpDetached()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Tmp detached view should be removed from RecyclerView before it can be recycled: ");
                sb2.append(xVar);
                sb2.append(RecyclerView.this.exceptionLabel());
                throw new IllegalArgumentException(sb2.toString());
            } else if (!xVar.shouldIgnore()) {
                boolean doesTransientStatePreventRecycling = xVar.doesTransientStatePreventRecycling();
                if ((RecyclerView.this.mAdapter != null && doesTransientStatePreventRecycling && RecyclerView.this.mAdapter.onFailedToRecycleView(xVar)) || xVar.isRecyclable()) {
                    if (this.f3742d <= 0 || xVar.hasAnyOfTheFlags(526)) {
                        z = false;
                    } else {
                        int size = this.f3741c.size();
                        if (size >= this.f3742d && size > 0) {
                            mo5244d(0);
                            size--;
                        }
                        if (RecyclerView.ALLOW_THREAD_GAP_WORK && size > 0 && !RecyclerView.this.mPrefetchRegistry.mo5513a(xVar.mPosition)) {
                            int i = size - 1;
                            while (i >= 0) {
                                if (!RecyclerView.this.mPrefetchRegistry.mo5513a(((C1277x) this.f3741c.get(i)).mPosition)) {
                                    break;
                                }
                                i--;
                            }
                            size = i + 1;
                        }
                        this.f3741c.add(size, xVar);
                        z = true;
                    }
                    if (!z) {
                        mo5230a(xVar, true);
                        z2 = true;
                    }
                } else {
                    z = false;
                }
                RecyclerView.this.mViewInfoStore.mo5586g(xVar);
                if (!z && !z2 && doesTransientStatePreventRecycling) {
                    xVar.mOwnerRecyclerView = null;
                }
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
                sb3.append(RecyclerView.this.exceptionLabel());
                throw new IllegalArgumentException(sb3.toString());
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo5230a(C1277x xVar, boolean z) {
            RecyclerView.clearNestedRecyclerViewIfNotNested(xVar);
            if (xVar.hasAnyOfTheFlags(16384)) {
                xVar.setFlags(0, 16384);
                C0962r.m3559a(xVar.itemView, (C0932a) null);
            }
            if (z) {
                mo5245d(xVar);
            }
            xVar.mOwnerRecyclerView = null;
            mo5250g().mo5213a(xVar);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo5236b(View view) {
            C1277x childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.mScrapContainer = null;
            childViewHolderInt.mInChangeScrap = false;
            childViewHolderInt.clearReturnedFromScrapFlag();
            mo5237b(childViewHolderInt);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public void mo5241c(View view) {
            C1277x childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (!childViewHolderInt.hasAnyOfTheFlags(12) && childViewHolderInt.isUpdated() && !RecyclerView.this.canReuseUpdatedViewHolder(childViewHolderInt)) {
                if (this.f3740b == null) {
                    this.f3740b = new ArrayList<>();
                }
                childViewHolderInt.setScrapContainer(this, true);
                this.f3740b.add(childViewHolderInt);
            } else if (!childViewHolderInt.isInvalid() || childViewHolderInt.isRemoved() || RecyclerView.this.mAdapter.hasStableIds()) {
                childViewHolderInt.setScrapContainer(this, false);
                this.f3739a.add(childViewHolderInt);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
                sb.append(RecyclerView.this.exceptionLabel());
                throw new IllegalArgumentException(sb.toString());
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public void mo5242c(C1277x xVar) {
            if (xVar.mInChangeScrap) {
                this.f3740b.remove(xVar);
            } else {
                this.f3739a.remove(xVar);
            }
            xVar.mScrapContainer = null;
            xVar.mInChangeScrap = false;
            xVar.clearReturnedFromScrapFlag();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: e */
        public int mo5246e() {
            return this.f3739a.size();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: e */
        public View mo5247e(int i) {
            return ((C1277x) this.f3739a.get(i)).itemView;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: f */
        public void mo5249f() {
            this.f3739a.clear();
            if (this.f3740b != null) {
                this.f3740b.clear();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: f */
        public C1277x mo5248f(int i) {
            if (this.f3740b != null) {
                int size = this.f3740b.size();
                if (size != 0) {
                    int i2 = 0;
                    int i3 = 0;
                    while (i3 < size) {
                        C1277x xVar = (C1277x) this.f3740b.get(i3);
                        if (xVar.wasReturnedFromScrap() || xVar.getLayoutPosition() != i) {
                            i3++;
                        } else {
                            xVar.addFlags(32);
                            return xVar;
                        }
                    }
                    if (RecyclerView.this.mAdapter.hasStableIds()) {
                        int b = RecyclerView.this.mAdapterHelper.mo5427b(i);
                        if (b > 0 && b < RecyclerView.this.mAdapter.getItemCount()) {
                            long itemId = RecyclerView.this.mAdapter.getItemId(b);
                            while (i2 < size) {
                                C1277x xVar2 = (C1277x) this.f3740b.get(i2);
                                if (xVar2.wasReturnedFromScrap() || xVar2.getItemId() != itemId) {
                                    i2++;
                                } else {
                                    xVar2.addFlags(32);
                                    return xVar2;
                                }
                            }
                        }
                    }
                    return null;
                }
            }
            return null;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public C1277x mo5233b(int i, boolean z) {
            int size = this.f3739a.size();
            int i2 = 0;
            int i3 = 0;
            while (i3 < size) {
                C1277x xVar = (C1277x) this.f3739a.get(i3);
                if (xVar.wasReturnedFromScrap() || xVar.getLayoutPosition() != i || xVar.isInvalid() || (!RecyclerView.this.mState.f3771g && xVar.isRemoved())) {
                    i3++;
                } else {
                    xVar.addFlags(32);
                    return xVar;
                }
            }
            if (!z) {
                View c = RecyclerView.this.mChildHelper.mo5450c(i);
                if (c != null) {
                    C1277x childViewHolderInt = RecyclerView.getChildViewHolderInt(c);
                    RecyclerView.this.mChildHelper.mo5455e(c);
                    int b = RecyclerView.this.mChildHelper.mo5447b(c);
                    if (b != -1) {
                        RecyclerView.this.mChildHelper.mo5454e(b);
                        mo5241c(c);
                        childViewHolderInt.addFlags(8224);
                        return childViewHolderInt;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("layout index should not be -1 after unhiding a view:");
                    sb.append(childViewHolderInt);
                    sb.append(RecyclerView.this.exceptionLabel());
                    throw new IllegalStateException(sb.toString());
                }
            }
            int size2 = this.f3741c.size();
            while (i2 < size2) {
                C1277x xVar2 = (C1277x) this.f3741c.get(i2);
                if (xVar2.isInvalid() || xVar2.getLayoutPosition() != i) {
                    i2++;
                } else {
                    if (!z) {
                        this.f3741c.remove(i2);
                    }
                    return xVar2;
                }
            }
            return null;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C1277x mo5221a(long j, int i, boolean z) {
            for (int size = this.f3739a.size() - 1; size >= 0; size--) {
                C1277x xVar = (C1277x) this.f3739a.get(size);
                if (xVar.getItemId() == j && !xVar.wasReturnedFromScrap()) {
                    if (i == xVar.getItemViewType()) {
                        xVar.addFlags(32);
                        if (xVar.isRemoved() && !RecyclerView.this.mState.mo5287a()) {
                            xVar.setFlags(2, 14);
                        }
                        return xVar;
                    } else if (!z) {
                        this.f3739a.remove(size);
                        RecyclerView.this.removeDetachedView(xVar.itemView, false);
                        mo5236b(xVar.itemView);
                    }
                }
            }
            int size2 = this.f3741c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                C1277x xVar2 = (C1277x) this.f3741c.get(size2);
                if (xVar2.getItemId() == j) {
                    if (i == xVar2.getItemViewType()) {
                        if (!z) {
                            this.f3741c.remove(size2);
                        }
                        return xVar2;
                    } else if (!z) {
                        mo5244d(size2);
                        return null;
                    }
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public void mo5245d(C1277x xVar) {
            if (RecyclerView.this.mRecyclerListener != null) {
                RecyclerView.this.mRecyclerListener.mo5254a(xVar);
            }
            if (RecyclerView.this.mAdapter != null) {
                RecyclerView.this.mAdapter.onViewRecycled(xVar);
            }
            if (RecyclerView.this.mState != null) {
                RecyclerView.this.mViewInfoStore.mo5586g(xVar);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo5227a(C1243a aVar, C1243a aVar2, boolean z) {
            mo5222a();
            mo5250g().mo5212a(aVar, aVar2, z);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo5224a(int i, int i2) {
            int i3;
            int i4;
            int i5;
            if (i < i2) {
                i5 = i;
                i4 = i2;
                i3 = -1;
            } else {
                i4 = i;
                i5 = i2;
                i3 = 1;
            }
            int size = this.f3741c.size();
            for (int i6 = 0; i6 < size; i6++) {
                C1277x xVar = (C1277x) this.f3741c.get(i6);
                if (xVar != null && xVar.mPosition >= i5 && xVar.mPosition <= i4) {
                    if (xVar.mPosition == i) {
                        xVar.offsetPosition(i2 - i, false);
                    } else {
                        xVar.offsetPosition(i3, false);
                    }
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo5235b(int i, int i2) {
            int size = this.f3741c.size();
            for (int i3 = 0; i3 < size; i3++) {
                C1277x xVar = (C1277x) this.f3741c.get(i3);
                if (xVar != null && xVar.mPosition >= i) {
                    xVar.offsetPosition(i2, true);
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo5225a(int i, int i2, boolean z) {
            int i3 = i + i2;
            for (int size = this.f3741c.size() - 1; size >= 0; size--) {
                C1277x xVar = (C1277x) this.f3741c.get(size);
                if (xVar != null) {
                    if (xVar.mPosition >= i3) {
                        xVar.offsetPosition(-i2, z);
                    } else if (xVar.mPosition >= i) {
                        xVar.addFlags(8);
                        mo5244d(size);
                    }
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo5229a(C1275v vVar) {
            this.f3747i = vVar;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo5228a(C1264o oVar) {
            if (this.f3743e != null) {
                this.f3743e.mo5218c();
            }
            this.f3743e = oVar;
            if (this.f3743e != null && RecyclerView.this.getAdapter() != null) {
                this.f3743e.mo5215b();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: g */
        public C1264o mo5250g() {
            if (this.f3743e == null) {
                this.f3743e = new C1264o();
            }
            return this.f3743e;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public void mo5240c(int i, int i2) {
            int i3 = i2 + i;
            for (int size = this.f3741c.size() - 1; size >= 0; size--) {
                C1277x xVar = (C1277x) this.f3741c.get(size);
                if (xVar != null) {
                    int i4 = xVar.mPosition;
                    if (i4 >= i && i4 < i3) {
                        xVar.addFlags(2);
                        mo5244d(size);
                    }
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: h */
        public void mo5251h() {
            int size = this.f3741c.size();
            for (int i = 0; i < size; i++) {
                C1277x xVar = (C1277x) this.f3741c.get(i);
                if (xVar != null) {
                    xVar.addFlags(6);
                    xVar.addChangePayload(null);
                }
            }
            if (RecyclerView.this.mAdapter == null || !RecyclerView.this.mAdapter.hasStableIds()) {
                mo5243d();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: i */
        public void mo5252i() {
            int size = this.f3741c.size();
            for (int i = 0; i < size; i++) {
                ((C1277x) this.f3741c.get(i)).clearOldPosition();
            }
            int size2 = this.f3739a.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((C1277x) this.f3739a.get(i2)).clearOldPosition();
            }
            if (this.f3740b != null) {
                int size3 = this.f3740b.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    ((C1277x) this.f3740b.get(i3)).clearOldPosition();
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: j */
        public void mo5253j() {
            int size = this.f3741c.size();
            for (int i = 0; i < size; i++) {
                C1259j jVar = (C1259j) ((C1277x) this.f3741c.get(i)).itemView.getLayoutParams();
                if (jVar != null) {
                    jVar.f3731e = true;
                }
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$q */
    public interface C1267q {
        /* renamed from: a */
        void mo5254a(C1277x xVar);
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$r */
    private class C1268r extends C1245c {
        C1268r() {
        }

        /* renamed from: a */
        public void mo5059a() {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            RecyclerView.this.mState.f3770f = true;
            RecyclerView.this.processDataSetCompletelyChanged(true);
            if (!RecyclerView.this.mAdapterHelper.mo5433d()) {
                RecyclerView.this.requestLayout();
            }
        }

        /* renamed from: a */
        public void mo5062a(int i, int i2, Object obj) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.mo5426a(i, i2, obj)) {
                mo5255b();
            }
        }

        /* renamed from: b */
        public void mo5063b(int i, int i2) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.mo5429b(i, i2)) {
                mo5255b();
            }
        }

        /* renamed from: c */
        public void mo5064c(int i, int i2) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.mo5432c(i, i2)) {
                mo5255b();
            }
        }

        /* renamed from: a */
        public void mo5061a(int i, int i2, int i3) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.mo5425a(i, i2, i3)) {
                mo5255b();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo5255b() {
            if (!RecyclerView.POST_UPDATES_ON_ANIMATION || !RecyclerView.this.mHasFixedSize || !RecyclerView.this.mIsAttached) {
                RecyclerView.this.mAdapterUpdateDuringMeasure = true;
                RecyclerView.this.requestLayout();
                return;
            }
            C0962r.m3562a((View) RecyclerView.this, RecyclerView.this.mUpdateChildViewsRunnable);
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$s */
    public static class C1269s extends C1021a {
        public static final Creator<C1269s> CREATOR = new ClassLoaderCreator<C1269s>() {
            /* renamed from: a */
            public C1269s createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new C1269s(parcel, classLoader);
            }

            /* renamed from: a */
            public C1269s createFromParcel(Parcel parcel) {
                return new C1269s(parcel, null);
            }

            /* renamed from: a */
            public C1269s[] newArray(int i) {
                return new C1269s[i];
            }
        };

        /* renamed from: a */
        Parcelable f3749a;

        C1269s(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                classLoader = C1254i.class.getClassLoader();
            }
            this.f3749a = parcel.readParcelable(classLoader);
        }

        C1269s(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.f3749a, 0);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo5256a(C1269s sVar) {
            this.f3749a = sVar.f3749a;
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$t */
    public static abstract class C1271t {

        /* renamed from: a */
        private int f3750a = -1;

        /* renamed from: b */
        private RecyclerView f3751b;

        /* renamed from: c */
        private C1254i f3752c;

        /* renamed from: d */
        private boolean f3753d;

        /* renamed from: e */
        private boolean f3754e;

        /* renamed from: f */
        private View f3755f;

        /* renamed from: g */
        private final C1272a f3756g = new C1272a(0, 0);

        /* renamed from: h */
        private boolean f3757h;

        /* renamed from: androidx.recyclerview.widget.RecyclerView$t$a */
        public static class C1272a {

            /* renamed from: a */
            private int f3758a;

            /* renamed from: b */
            private int f3759b;

            /* renamed from: c */
            private int f3760c;

            /* renamed from: d */
            private int f3761d;

            /* renamed from: e */
            private Interpolator f3762e;

            /* renamed from: f */
            private boolean f3763f;

            /* renamed from: g */
            private int f3764g;

            public C1272a(int i, int i2) {
                this(i, i2, C1024a.INVALID_ID, null);
            }

            public C1272a(int i, int i2, int i3, Interpolator interpolator) {
                this.f3761d = -1;
                this.f3763f = false;
                this.f3764g = 0;
                this.f3758a = i;
                this.f3759b = i2;
                this.f3760c = i3;
                this.f3762e = interpolator;
            }

            /* renamed from: a */
            public void mo5281a(int i) {
                this.f3761d = i;
            }

            /* access modifiers changed from: 0000 */
            /* renamed from: a */
            public boolean mo5284a() {
                return this.f3761d >= 0;
            }

            /* access modifiers changed from: 0000 */
            /* renamed from: a */
            public void mo5283a(RecyclerView recyclerView) {
                if (this.f3761d >= 0) {
                    int i = this.f3761d;
                    this.f3761d = -1;
                    recyclerView.jumpToPositionForSmoothScroller(i);
                    this.f3763f = false;
                    return;
                }
                if (this.f3763f) {
                    m5025b();
                    if (this.f3762e != null) {
                        recyclerView.mViewFlinger.mo5298a(this.f3758a, this.f3759b, this.f3760c, this.f3762e);
                    } else if (this.f3760c == Integer.MIN_VALUE) {
                        recyclerView.mViewFlinger.mo5301b(this.f3758a, this.f3759b);
                    } else {
                        recyclerView.mViewFlinger.mo5296a(this.f3758a, this.f3759b, this.f3760c);
                    }
                    this.f3764g++;
                    if (this.f3764g > 10) {
                        Log.e(RecyclerView.TAG, "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f3763f = false;
                } else {
                    this.f3764g = 0;
                }
            }

            /* renamed from: b */
            private void m5025b() {
                if (this.f3762e != null && this.f3760c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                } else if (this.f3760c < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            /* renamed from: a */
            public void mo5282a(int i, int i2, int i3, Interpolator interpolator) {
                this.f3758a = i;
                this.f3759b = i2;
                this.f3760c = i3;
                this.f3762e = interpolator;
                this.f3763f = true;
            }
        }

        /* renamed from: androidx.recyclerview.widget.RecyclerView$t$b */
        public interface C1273b {
            /* renamed from: d */
            PointF mo4777d(int i);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract void mo5264a();

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract void mo5266a(int i, int i2, C1274u uVar, C1272a aVar);

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract void mo5268a(View view, C1274u uVar, C1272a aVar);

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public abstract void mo5270b();

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo5269a(RecyclerView recyclerView, C1254i iVar) {
            if (this.f3757h) {
                String str = RecyclerView.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("An instance of ");
                sb.append(getClass().getSimpleName());
                sb.append(" was started ");
                sb.append("more than once. Each instance of");
                sb.append(getClass().getSimpleName());
                sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                sb.append("is intended to only be used once. You should create a new instance for ");
                sb.append("each use.");
                Log.w(str, sb.toString());
            }
            this.f3751b = recyclerView;
            this.f3752c = iVar;
            if (this.f3750a != -1) {
                this.f3751b.mState.f3765a = this.f3750a;
                this.f3754e = true;
                this.f3753d = true;
                this.f3755f = mo5274e(mo5279i());
                mo5264a();
                this.f3751b.mViewFlinger.mo5294a();
                this.f3757h = true;
                return;
            }
            throw new IllegalArgumentException("Invalid target position");
        }

        /* renamed from: c */
        public void mo5272c(int i) {
            this.f3750a = i;
        }

        /* renamed from: d */
        public PointF mo5273d(int i) {
            C1254i e = mo5275e();
            if (e instanceof C1273b) {
                return ((C1273b) e).mo4777d(i);
            }
            String str = RecyclerView.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("You should override computeScrollVectorForPosition when the LayoutManager does not implement ");
            sb.append(C1273b.class.getCanonicalName());
            Log.w(str, sb.toString());
            return null;
        }

        /* renamed from: e */
        public C1254i mo5275e() {
            return this.f3752c;
        }

        /* access modifiers changed from: protected */
        /* renamed from: f */
        public final void mo5276f() {
            if (this.f3754e) {
                this.f3754e = false;
                mo5270b();
                this.f3751b.mState.f3765a = -1;
                this.f3755f = null;
                this.f3750a = -1;
                this.f3753d = false;
                this.f3752c.mo5142b(this);
                this.f3752c = null;
                this.f3751b = null;
            }
        }

        /* renamed from: g */
        public boolean mo5277g() {
            return this.f3753d;
        }

        /* renamed from: h */
        public boolean mo5278h() {
            return this.f3754e;
        }

        /* renamed from: i */
        public int mo5279i() {
            return this.f3750a;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo5265a(int i, int i2) {
            RecyclerView recyclerView = this.f3751b;
            if (!this.f3754e || this.f3750a == -1 || recyclerView == null) {
                mo5276f();
            }
            if (this.f3753d && this.f3755f == null && this.f3752c != null) {
                PointF d = mo5273d(this.f3750a);
                if (!(d == null || (d.x == BitmapDescriptorFactory.HUE_RED && d.y == BitmapDescriptorFactory.HUE_RED))) {
                    recyclerView.scrollStep((int) Math.signum(d.x), (int) Math.signum(d.y), null);
                }
            }
            this.f3753d = false;
            if (this.f3755f != null) {
                if (mo5263a(this.f3755f) == this.f3750a) {
                    mo5268a(this.f3755f, recyclerView.mState, this.f3756g);
                    this.f3756g.mo5283a(recyclerView);
                    mo5276f();
                } else {
                    Log.e(RecyclerView.TAG, "Passed over target position while smooth scrolling.");
                    this.f3755f = null;
                }
            }
            if (this.f3754e) {
                mo5266a(i, i2, recyclerView.mState, this.f3756g);
                boolean a = this.f3756g.mo5284a();
                this.f3756g.mo5283a(recyclerView);
                if (!a) {
                    return;
                }
                if (this.f3754e) {
                    this.f3753d = true;
                    recyclerView.mViewFlinger.mo5294a();
                    return;
                }
                mo5276f();
            }
        }

        /* renamed from: a */
        public int mo5263a(View view) {
            return this.f3751b.getChildLayoutPosition(view);
        }

        /* renamed from: j */
        public int mo5280j() {
            return this.f3751b.mLayout.mo5186w();
        }

        /* renamed from: e */
        public View mo5274e(int i) {
            return this.f3751b.mLayout.mo4774c(i);
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void mo5271b(View view) {
            if (mo5263a(view) == mo5279i()) {
                this.f3755f = view;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo5267a(PointF pointF) {
            float sqrt = (float) Math.sqrt((double) ((pointF.x * pointF.x) + (pointF.y * pointF.y)));
            pointF.x /= sqrt;
            pointF.y /= sqrt;
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$u */
    public static class C1274u {

        /* renamed from: a */
        int f3765a = -1;

        /* renamed from: b */
        int f3766b = 0;

        /* renamed from: c */
        int f3767c = 0;

        /* renamed from: d */
        int f3768d = 1;

        /* renamed from: e */
        int f3769e = 0;

        /* renamed from: f */
        boolean f3770f = false;

        /* renamed from: g */
        boolean f3771g = false;

        /* renamed from: h */
        boolean f3772h = false;

        /* renamed from: i */
        boolean f3773i = false;

        /* renamed from: j */
        boolean f3774j = false;

        /* renamed from: k */
        boolean f3775k = false;

        /* renamed from: l */
        int f3776l;

        /* renamed from: m */
        long f3777m;

        /* renamed from: n */
        int f3778n;

        /* renamed from: o */
        int f3779o;

        /* renamed from: p */
        int f3780p;

        /* renamed from: q */
        private SparseArray<Object> f3781q;

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo5285a(int i) {
            if ((this.f3768d & i) == 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("Layout state should be one of ");
                sb.append(Integer.toBinaryString(i));
                sb.append(" but it is ");
                sb.append(Integer.toBinaryString(this.f3768d));
                throw new IllegalStateException(sb.toString());
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo5286a(C1243a aVar) {
            this.f3768d = 1;
            this.f3769e = aVar.getItemCount();
            this.f3771g = false;
            this.f3772h = false;
            this.f3773i = false;
        }

        /* renamed from: a */
        public boolean mo5287a() {
            return this.f3771g;
        }

        /* renamed from: b */
        public boolean mo5288b() {
            return this.f3775k;
        }

        /* renamed from: c */
        public int mo5289c() {
            return this.f3765a;
        }

        /* renamed from: d */
        public boolean mo5290d() {
            return this.f3765a != -1;
        }

        /* renamed from: e */
        public int mo5291e() {
            return this.f3771g ? this.f3766b - this.f3767c : this.f3769e;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("State{mTargetPosition=");
            sb.append(this.f3765a);
            sb.append(", mData=");
            sb.append(this.f3781q);
            sb.append(", mItemCount=");
            sb.append(this.f3769e);
            sb.append(", mIsMeasuring=");
            sb.append(this.f3773i);
            sb.append(", mPreviousLayoutItemCount=");
            sb.append(this.f3766b);
            sb.append(", mDeletedInvisibleItemCountSincePreviousLayout=");
            sb.append(this.f3767c);
            sb.append(", mStructureChanged=");
            sb.append(this.f3770f);
            sb.append(", mInPreLayout=");
            sb.append(this.f3771g);
            sb.append(", mRunSimpleAnimations=");
            sb.append(this.f3774j);
            sb.append(", mRunPredictiveAnimations=");
            sb.append(this.f3775k);
            sb.append('}');
            return sb.toString();
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$v */
    public static abstract class C1275v {
        /* renamed from: a */
        public abstract View mo5293a(C1266p pVar, int i, int i2);
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$w */
    class C1276w implements Runnable {

        /* renamed from: a */
        OverScroller f3782a;

        /* renamed from: b */
        Interpolator f3783b = RecyclerView.sQuinticInterpolator;

        /* renamed from: d */
        private int f3785d;

        /* renamed from: e */
        private int f3786e;

        /* renamed from: f */
        private boolean f3787f = false;

        /* renamed from: g */
        private boolean f3788g = false;

        C1276w() {
            this.f3782a = new OverScroller(RecyclerView.this.getContext(), RecyclerView.sQuinticInterpolator);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:45:0x00f3, code lost:
            if (r8 > 0) goto L_0x00f7;
         */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x00ef  */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x00ff  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r22 = this;
                r0 = r22
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$i r1 = r1.mLayout
                if (r1 != 0) goto L_0x000c
                r22.mo5300b()
                return
            L_0x000c:
                r22.m5041c()
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                r1.consumePendingUpdateOperations()
                android.widget.OverScroller r1 = r0.f3782a
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$i r2 = r2.mLayout
                androidx.recyclerview.widget.RecyclerView$t r2 = r2.f3717t
                boolean r3 = r1.computeScrollOffset()
                r4 = 0
                if (r3 == 0) goto L_0x0199
                androidx.recyclerview.widget.RecyclerView r3 = androidx.recyclerview.widget.RecyclerView.this
                int[] r3 = r3.mScrollConsumed
                int r11 = r1.getCurrX()
                int r12 = r1.getCurrY()
                int r5 = r0.f3785d
                int r13 = r11 - r5
                int r5 = r0.f3786e
                int r14 = r12 - r5
                r0.f3785d = r11
                r0.f3786e = r12
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                r9 = 0
                r10 = 1
                r6 = r13
                r7 = r14
                r8 = r3
                boolean r5 = r5.dispatchNestedPreScroll(r6, r7, r8, r9, r10)
                r6 = 1
                if (r5 == 0) goto L_0x004f
                r5 = r3[r4]
                int r13 = r13 - r5
                r3 = r3[r6]
                int r14 = r14 - r3
            L_0x004f:
                androidx.recyclerview.widget.RecyclerView r3 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$a r3 = r3.mAdapter
                if (r3 == 0) goto L_0x00a4
                androidx.recyclerview.widget.RecyclerView r3 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                int[] r5 = r5.mScrollStepConsumed
                r3.scrollStep(r13, r14, r5)
                androidx.recyclerview.widget.RecyclerView r3 = androidx.recyclerview.widget.RecyclerView.this
                int[] r3 = r3.mScrollStepConsumed
                r3 = r3[r4]
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                int[] r5 = r5.mScrollStepConsumed
                r5 = r5[r6]
                int r7 = r13 - r3
                int r8 = r14 - r5
                if (r2 == 0) goto L_0x00a8
                boolean r9 = r2.mo5277g()
                if (r9 != 0) goto L_0x00a8
                boolean r9 = r2.mo5278h()
                if (r9 == 0) goto L_0x00a8
                androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$u r9 = r9.mState
                int r9 = r9.mo5291e()
                if (r9 != 0) goto L_0x008a
                r2.mo5276f()
                goto L_0x00a8
            L_0x008a:
                int r10 = r2.mo5279i()
                if (r10 < r9) goto L_0x009c
                int r9 = r9 - r6
                r2.mo5272c(r9)
                int r9 = r13 - r7
                int r10 = r14 - r8
                r2.mo5265a(r9, r10)
                goto L_0x00a8
            L_0x009c:
                int r9 = r13 - r7
                int r10 = r14 - r8
                r2.mo5265a(r9, r10)
                goto L_0x00a8
            L_0x00a4:
                r3 = 0
                r5 = 0
                r7 = 0
                r8 = 0
            L_0x00a8:
                androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
                java.util.ArrayList<androidx.recyclerview.widget.RecyclerView$h> r9 = r9.mItemDecorations
                boolean r9 = r9.isEmpty()
                if (r9 != 0) goto L_0x00b7
                androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
                r9.invalidate()
            L_0x00b7:
                androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
                int r9 = r9.getOverScrollMode()
                r10 = 2
                if (r9 == r10) goto L_0x00c5
                androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
                r9.considerReleasingGlowsOnScroll(r13, r14)
            L_0x00c5:
                androidx.recyclerview.widget.RecyclerView r15 = androidx.recyclerview.widget.RecyclerView.this
                r20 = 0
                r21 = 1
                r16 = r3
                r17 = r5
                r18 = r7
                r19 = r8
                boolean r9 = r15.dispatchNestedScroll(r16, r17, r18, r19, r20, r21)
                if (r9 != 0) goto L_0x011b
                if (r7 != 0) goto L_0x00dd
                if (r8 == 0) goto L_0x011b
            L_0x00dd:
                float r9 = r1.getCurrVelocity()
                int r9 = (int) r9
                if (r7 == r11) goto L_0x00ec
                if (r7 >= 0) goto L_0x00e8
                int r15 = -r9
                goto L_0x00ed
            L_0x00e8:
                if (r7 <= 0) goto L_0x00ec
                r15 = r9
                goto L_0x00ed
            L_0x00ec:
                r15 = 0
            L_0x00ed:
                if (r8 == r12) goto L_0x00f6
                if (r8 >= 0) goto L_0x00f3
                int r9 = -r9
                goto L_0x00f7
            L_0x00f3:
                if (r8 <= 0) goto L_0x00f6
                goto L_0x00f7
            L_0x00f6:
                r9 = 0
            L_0x00f7:
                androidx.recyclerview.widget.RecyclerView r4 = androidx.recyclerview.widget.RecyclerView.this
                int r4 = r4.getOverScrollMode()
                if (r4 == r10) goto L_0x0104
                androidx.recyclerview.widget.RecyclerView r4 = androidx.recyclerview.widget.RecyclerView.this
                r4.absorbGlows(r15, r9)
            L_0x0104:
                if (r15 != 0) goto L_0x010e
                if (r7 == r11) goto L_0x010e
                int r4 = r1.getFinalX()
                if (r4 != 0) goto L_0x011b
            L_0x010e:
                if (r9 != 0) goto L_0x0118
                if (r8 == r12) goto L_0x0118
                int r4 = r1.getFinalY()
                if (r4 != 0) goto L_0x011b
            L_0x0118:
                r1.abortAnimation()
            L_0x011b:
                if (r3 != 0) goto L_0x011f
                if (r5 == 0) goto L_0x0124
            L_0x011f:
                androidx.recyclerview.widget.RecyclerView r4 = androidx.recyclerview.widget.RecyclerView.this
                r4.dispatchOnScrolled(r3, r5)
            L_0x0124:
                androidx.recyclerview.widget.RecyclerView r4 = androidx.recyclerview.widget.RecyclerView.this
                boolean r4 = r4.awakenScrollBars()
                if (r4 != 0) goto L_0x0131
                androidx.recyclerview.widget.RecyclerView r4 = androidx.recyclerview.widget.RecyclerView.this
                r4.invalidate()
            L_0x0131:
                if (r14 == 0) goto L_0x0141
                androidx.recyclerview.widget.RecyclerView r4 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$i r4 = r4.mLayout
                boolean r4 = r4.mo4784f()
                if (r4 == 0) goto L_0x0141
                if (r5 != r14) goto L_0x0141
                r4 = 1
                goto L_0x0142
            L_0x0141:
                r4 = 0
            L_0x0142:
                if (r13 == 0) goto L_0x0152
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$i r5 = r5.mLayout
                boolean r5 = r5.mo4781e()
                if (r5 == 0) goto L_0x0152
                if (r3 != r13) goto L_0x0152
                r3 = 1
                goto L_0x0153
            L_0x0152:
                r3 = 0
            L_0x0153:
                if (r13 != 0) goto L_0x0157
                if (r14 == 0) goto L_0x015e
            L_0x0157:
                if (r3 != 0) goto L_0x015e
                if (r4 == 0) goto L_0x015c
                goto L_0x015e
            L_0x015c:
                r3 = 0
                goto L_0x015f
            L_0x015e:
                r3 = 1
            L_0x015f:
                boolean r1 = r1.isFinished()
                if (r1 != 0) goto L_0x0183
                if (r3 != 0) goto L_0x0170
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                boolean r1 = r1.hasNestedScrollingParent(r6)
                if (r1 != 0) goto L_0x0170
                goto L_0x0183
            L_0x0170:
                r22.mo5294a()
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.e r1 = r1.mGapWorker
                if (r1 == 0) goto L_0x0199
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.e r1 = r1.mGapWorker
                androidx.recyclerview.widget.RecyclerView r3 = androidx.recyclerview.widget.RecyclerView.this
                r1.mo5505a(r3, r13, r14)
                goto L_0x0199
            L_0x0183:
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                r3 = 0
                r1.setScrollState(r3)
                boolean r1 = androidx.recyclerview.widget.RecyclerView.ALLOW_THREAD_GAP_WORK
                if (r1 == 0) goto L_0x0194
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.e$a r1 = r1.mPrefetchRegistry
                r1.mo5510a()
            L_0x0194:
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                r1.stopNestedScroll(r6)
            L_0x0199:
                if (r2 == 0) goto L_0x01ac
                boolean r1 = r2.mo5277g()
                if (r1 == 0) goto L_0x01a5
                r1 = 0
                r2.mo5265a(r1, r1)
            L_0x01a5:
                boolean r1 = r0.f3788g
                if (r1 != 0) goto L_0x01ac
                r2.mo5276f()
            L_0x01ac:
                r22.m5042d()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.C1276w.run():void");
        }

        /* renamed from: c */
        private void m5041c() {
            this.f3788g = false;
            this.f3787f = true;
        }

        /* renamed from: d */
        private void m5042d() {
            this.f3787f = false;
            if (this.f3788g) {
                mo5294a();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo5294a() {
            if (this.f3787f) {
                this.f3788g = true;
                return;
            }
            RecyclerView.this.removeCallbacks(this);
            C0962r.m3562a((View) RecyclerView.this, (Runnable) this);
        }

        /* renamed from: a */
        public void mo5295a(int i, int i2) {
            RecyclerView.this.setScrollState(2);
            this.f3786e = 0;
            this.f3785d = 0;
            this.f3782a.fling(0, 0, i, i2, C1024a.INVALID_ID, BaseClientBuilder.API_PRIORITY_OTHER, C1024a.INVALID_ID, BaseClientBuilder.API_PRIORITY_OTHER);
            mo5294a();
        }

        /* renamed from: b */
        public void mo5301b(int i, int i2) {
            mo5297a(i, i2, 0, 0);
        }

        /* renamed from: a */
        public void mo5297a(int i, int i2, int i3, int i4) {
            mo5296a(i, i2, m5040b(i, i2, i3, i4));
        }

        /* renamed from: a */
        private float m5039a(float f) {
            return (float) Math.sin((double) ((f - 0.5f) * 0.47123894f));
        }

        /* renamed from: b */
        private int m5040b(int i, int i2, int i3, int i4) {
            int i5;
            int abs = Math.abs(i);
            int abs2 = Math.abs(i2);
            boolean z = abs > abs2;
            int sqrt = (int) Math.sqrt((double) ((i3 * i3) + (i4 * i4)));
            int sqrt2 = (int) Math.sqrt((double) ((i * i) + (i2 * i2)));
            int width = z ? RecyclerView.this.getWidth() : RecyclerView.this.getHeight();
            int i6 = width / 2;
            float f = (float) width;
            float f2 = (float) i6;
            float a = f2 + (m5039a(Math.min(1.0f, (((float) sqrt2) * 1.0f) / f)) * f2);
            if (sqrt > 0) {
                i5 = Math.round(Math.abs(a / ((float) sqrt)) * 1000.0f) * 4;
            } else {
                if (!z) {
                    abs = abs2;
                }
                i5 = (int) (((((float) abs) / f) + 1.0f) * 300.0f);
            }
            return Math.min(i5, 2000);
        }

        /* renamed from: a */
        public void mo5296a(int i, int i2, int i3) {
            mo5298a(i, i2, i3, RecyclerView.sQuinticInterpolator);
        }

        /* renamed from: a */
        public void mo5299a(int i, int i2, Interpolator interpolator) {
            int b = m5040b(i, i2, 0, 0);
            if (interpolator == null) {
                interpolator = RecyclerView.sQuinticInterpolator;
            }
            mo5298a(i, i2, b, interpolator);
        }

        /* renamed from: a */
        public void mo5298a(int i, int i2, int i3, Interpolator interpolator) {
            if (this.f3783b != interpolator) {
                this.f3783b = interpolator;
                this.f3782a = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            RecyclerView.this.setScrollState(2);
            this.f3786e = 0;
            this.f3785d = 0;
            this.f3782a.startScroll(0, 0, i, i2, i3);
            if (VERSION.SDK_INT < 23) {
                this.f3782a.computeScrollOffset();
            }
            mo5294a();
        }

        /* renamed from: b */
        public void mo5300b() {
            RecyclerView.this.removeCallbacks(this);
            this.f3782a.abortAnimation();
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$x */
    public static abstract class C1277x {
        static final int FLAG_ADAPTER_FULLUPDATE = 1024;
        static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
        static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
        static final int FLAG_BOUND = 1;
        static final int FLAG_IGNORE = 128;
        static final int FLAG_INVALID = 4;
        static final int FLAG_MOVED = 2048;
        static final int FLAG_NOT_RECYCLABLE = 16;
        static final int FLAG_REMOVED = 8;
        static final int FLAG_RETURNED_FROM_SCRAP = 32;
        static final int FLAG_SET_A11Y_ITEM_DELEGATE = 16384;
        static final int FLAG_TMP_DETACHED = 256;
        static final int FLAG_UPDATE = 2;
        private static final List<Object> FULLUPDATE_PAYLOADS = Collections.emptyList();
        static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;
        public final View itemView;
        int mFlags;
        boolean mInChangeScrap = false;
        private int mIsRecyclableCount = 0;
        long mItemId = -1;
        int mItemViewType = -1;
        WeakReference<RecyclerView> mNestedRecyclerView;
        int mOldPosition = -1;
        RecyclerView mOwnerRecyclerView;
        List<Object> mPayloads = null;
        int mPendingAccessibilityState = -1;
        int mPosition = -1;
        int mPreLayoutPosition = -1;
        C1266p mScrapContainer = null;
        C1277x mShadowedHolder = null;
        C1277x mShadowingHolder = null;
        List<Object> mUnmodifiedPayloads = null;
        private int mWasImportantForAccessibilityBeforeHidden = 0;

        public C1277x(View view) {
            if (view != null) {
                this.itemView = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        /* access modifiers changed from: 0000 */
        public void flagRemovedAndOffsetPosition(int i, int i2, boolean z) {
            addFlags(8);
            offsetPosition(i2, z);
            this.mPosition = i;
        }

        /* access modifiers changed from: 0000 */
        public void offsetPosition(int i, boolean z) {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
            if (this.mPreLayoutPosition == -1) {
                this.mPreLayoutPosition = this.mPosition;
            }
            if (z) {
                this.mPreLayoutPosition += i;
            }
            this.mPosition += i;
            if (this.itemView.getLayoutParams() != null) {
                ((C1259j) this.itemView.getLayoutParams()).f3731e = true;
            }
        }

        /* access modifiers changed from: 0000 */
        public void clearOldPosition() {
            this.mOldPosition = -1;
            this.mPreLayoutPosition = -1;
        }

        /* access modifiers changed from: 0000 */
        public void saveOldPosition() {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
        }

        /* access modifiers changed from: 0000 */
        public boolean shouldIgnore() {
            return (this.mFlags & FLAG_IGNORE) != 0;
        }

        @Deprecated
        public final int getPosition() {
            return this.mPreLayoutPosition == -1 ? this.mPosition : this.mPreLayoutPosition;
        }

        public final int getLayoutPosition() {
            return this.mPreLayoutPosition == -1 ? this.mPosition : this.mPreLayoutPosition;
        }

        public final int getAdapterPosition() {
            if (this.mOwnerRecyclerView == null) {
                return -1;
            }
            return this.mOwnerRecyclerView.getAdapterPositionFor(this);
        }

        public final int getOldPosition() {
            return this.mOldPosition;
        }

        public final long getItemId() {
            return this.mItemId;
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        /* access modifiers changed from: 0000 */
        public boolean isScrap() {
            return this.mScrapContainer != null;
        }

        /* access modifiers changed from: 0000 */
        public void unScrap() {
            this.mScrapContainer.mo5242c(this);
        }

        /* access modifiers changed from: 0000 */
        public boolean wasReturnedFromScrap() {
            return (this.mFlags & 32) != 0;
        }

        /* access modifiers changed from: 0000 */
        public void clearReturnedFromScrapFlag() {
            this.mFlags &= -33;
        }

        /* access modifiers changed from: 0000 */
        public void clearTmpDetachFlag() {
            this.mFlags &= -257;
        }

        /* access modifiers changed from: 0000 */
        public void stopIgnoring() {
            this.mFlags &= -129;
        }

        /* access modifiers changed from: 0000 */
        public void setScrapContainer(C1266p pVar, boolean z) {
            this.mScrapContainer = pVar;
            this.mInChangeScrap = z;
        }

        /* access modifiers changed from: 0000 */
        public boolean isInvalid() {
            return (this.mFlags & 4) != 0;
        }

        /* access modifiers changed from: 0000 */
        public boolean needsUpdate() {
            return (this.mFlags & 2) != 0;
        }

        /* access modifiers changed from: 0000 */
        public boolean isBound() {
            return (this.mFlags & 1) != 0;
        }

        /* access modifiers changed from: 0000 */
        public boolean isRemoved() {
            return (this.mFlags & 8) != 0;
        }

        /* access modifiers changed from: 0000 */
        public boolean hasAnyOfTheFlags(int i) {
            return (i & this.mFlags) != 0;
        }

        /* access modifiers changed from: 0000 */
        public boolean isTmpDetached() {
            return (this.mFlags & 256) != 0;
        }

        /* access modifiers changed from: 0000 */
        public boolean isAdapterPositionUnknown() {
            return (this.mFlags & FLAG_ADAPTER_POSITION_UNKNOWN) != 0 || isInvalid();
        }

        /* access modifiers changed from: 0000 */
        public void setFlags(int i, int i2) {
            this.mFlags = (i & i2) | (this.mFlags & (~i2));
        }

        /* access modifiers changed from: 0000 */
        public void addFlags(int i) {
            this.mFlags = i | this.mFlags;
        }

        /* access modifiers changed from: 0000 */
        public void addChangePayload(Object obj) {
            if (obj == null) {
                addFlags(FLAG_ADAPTER_FULLUPDATE);
            } else if ((FLAG_ADAPTER_FULLUPDATE & this.mFlags) == 0) {
                createPayloadsIfNeeded();
                this.mPayloads.add(obj);
            }
        }

        private void createPayloadsIfNeeded() {
            if (this.mPayloads == null) {
                this.mPayloads = new ArrayList();
                this.mUnmodifiedPayloads = Collections.unmodifiableList(this.mPayloads);
            }
        }

        /* access modifiers changed from: 0000 */
        public void clearPayload() {
            if (this.mPayloads != null) {
                this.mPayloads.clear();
            }
            this.mFlags &= -1025;
        }

        /* access modifiers changed from: 0000 */
        public List<Object> getUnmodifiedPayloads() {
            if ((this.mFlags & FLAG_ADAPTER_FULLUPDATE) != 0) {
                return FULLUPDATE_PAYLOADS;
            }
            if (this.mPayloads == null || this.mPayloads.size() == 0) {
                return FULLUPDATE_PAYLOADS;
            }
            return this.mUnmodifiedPayloads;
        }

        /* access modifiers changed from: 0000 */
        public void resetInternal() {
            this.mFlags = 0;
            this.mPosition = -1;
            this.mOldPosition = -1;
            this.mItemId = -1;
            this.mPreLayoutPosition = -1;
            this.mIsRecyclableCount = 0;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            clearPayload();
            this.mWasImportantForAccessibilityBeforeHidden = 0;
            this.mPendingAccessibilityState = -1;
            RecyclerView.clearNestedRecyclerViewIfNotNested(this);
        }

        /* access modifiers changed from: 0000 */
        public void onEnteredHiddenState(RecyclerView recyclerView) {
            if (this.mPendingAccessibilityState != -1) {
                this.mWasImportantForAccessibilityBeforeHidden = this.mPendingAccessibilityState;
            } else {
                this.mWasImportantForAccessibilityBeforeHidden = C0962r.m3577e(this.itemView);
            }
            recyclerView.setChildImportantForAccessibilityInternal(this, 4);
        }

        /* access modifiers changed from: 0000 */
        public void onLeftHiddenState(RecyclerView recyclerView) {
            recyclerView.setChildImportantForAccessibilityInternal(this, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ViewHolder{");
            sb.append(Integer.toHexString(hashCode()));
            sb.append(" position=");
            sb.append(this.mPosition);
            sb.append(" id=");
            sb.append(this.mItemId);
            sb.append(", oldPos=");
            sb.append(this.mOldPosition);
            sb.append(", pLpos:");
            sb.append(this.mPreLayoutPosition);
            StringBuilder sb2 = new StringBuilder(sb.toString());
            if (isScrap()) {
                sb2.append(" scrap ");
                sb2.append(this.mInChangeScrap ? "[changeScrap]" : "[attachedScrap]");
            }
            if (isInvalid()) {
                sb2.append(" invalid");
            }
            if (!isBound()) {
                sb2.append(" unbound");
            }
            if (needsUpdate()) {
                sb2.append(" update");
            }
            if (isRemoved()) {
                sb2.append(" removed");
            }
            if (shouldIgnore()) {
                sb2.append(" ignored");
            }
            if (isTmpDetached()) {
                sb2.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(" not recyclable(");
                sb3.append(this.mIsRecyclableCount);
                sb3.append(")");
                sb2.append(sb3.toString());
            }
            if (isAdapterPositionUnknown()) {
                sb2.append(" undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                sb2.append(" no parent");
            }
            sb2.append("}");
            return sb2.toString();
        }

        public final void setIsRecyclable(boolean z) {
            this.mIsRecyclableCount = z ? this.mIsRecyclableCount - 1 : this.mIsRecyclableCount + 1;
            if (this.mIsRecyclableCount < 0) {
                this.mIsRecyclableCount = 0;
                StringBuilder sb = new StringBuilder();
                sb.append("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ");
                sb.append(this);
                Log.e("View", sb.toString());
            } else if (!z && this.mIsRecyclableCount == 1) {
                this.mFlags |= 16;
            } else if (z && this.mIsRecyclableCount == 0) {
                this.mFlags &= -17;
            }
        }

        public final boolean isRecyclable() {
            return (this.mFlags & 16) == 0 && !C0962r.m3574c(this.itemView);
        }

        /* access modifiers changed from: 0000 */
        public boolean shouldBeKeptAsChild() {
            return (this.mFlags & 16) != 0;
        }

        /* access modifiers changed from: 0000 */
        public boolean doesTransientStatePreventRecycling() {
            return (this.mFlags & 16) == 0 && C0962r.m3574c(this.itemView);
        }

        /* access modifiers changed from: 0000 */
        public boolean isUpdated() {
            return (this.mFlags & 2) != 0;
        }
    }

    public void onChildAttachedToWindow(View view) {
    }

    public void onChildDetachedFromWindow(View view) {
    }

    public void onScrollStateChanged(int i) {
    }

    public void onScrolled(int i, int i2) {
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mObserver = new C1268r();
        this.mRecycler = new C1266p();
        this.mViewInfoStore = new C1327n();
        this.mUpdateChildViewsRunnable = new Runnable() {
            public void run() {
                if (RecyclerView.this.mFirstLayoutComplete && !RecyclerView.this.isLayoutRequested()) {
                    if (!RecyclerView.this.mIsAttached) {
                        RecyclerView.this.requestLayout();
                    } else if (RecyclerView.this.mLayoutFrozen) {
                        RecyclerView.this.mLayoutWasDefered = true;
                    } else {
                        RecyclerView.this.consumePendingUpdateOperations();
                    }
                }
            }
        };
        this.mTempRect = new Rect();
        this.mTempRect2 = new Rect();
        this.mTempRectF = new RectF();
        this.mItemDecorations = new ArrayList<>();
        this.mOnItemTouchListeners = new ArrayList<>();
        this.mInterceptRequestLayoutDepth = 0;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mLayoutOrScrollCounter = 0;
        this.mDispatchScrollCounter = 0;
        this.mEdgeEffectFactory = new C1247e();
        this.mItemAnimator = new C1293c();
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mScaledHorizontalScrollFactor = Float.MIN_VALUE;
        this.mScaledVerticalScrollFactor = Float.MIN_VALUE;
        boolean z = true;
        this.mPreserveFocusAfterLayout = true;
        this.mViewFlinger = new C1276w();
        this.mPrefetchRegistry = ALLOW_THREAD_GAP_WORK ? new C1311a() : null;
        this.mState = new C1274u();
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        this.mItemAnimatorListener = new C1252g();
        this.mPostedAnimatorRunner = false;
        this.mMinMaxLayoutPositions = new int[2];
        this.mScrollOffset = new int[2];
        this.mScrollConsumed = new int[2];
        this.mNestedOffsets = new int[2];
        this.mScrollStepConsumed = new int[2];
        this.mPendingAccessibilityImportanceChange = new ArrayList();
        this.mItemAnimatorRunner = new Runnable() {
            public void run() {
                if (RecyclerView.this.mItemAnimator != null) {
                    RecyclerView.this.mItemAnimator.mo5069a();
                }
                RecyclerView.this.mPostedAnimatorRunner = false;
            }
        };
        this.mViewInfoProcessCallback = new C1329b() {
            /* renamed from: a */
            public void mo5000a(C1277x xVar, C1251c cVar, C1251c cVar2) {
                RecyclerView.this.mRecycler.mo5242c(xVar);
                RecyclerView.this.animateDisappearance(xVar, cVar, cVar2);
            }

            /* renamed from: b */
            public void mo5001b(C1277x xVar, C1251c cVar, C1251c cVar2) {
                RecyclerView.this.animateAppearance(xVar, cVar, cVar2);
            }

            /* renamed from: c */
            public void mo5002c(C1277x xVar, C1251c cVar, C1251c cVar2) {
                xVar.setIsRecyclable(false);
                if (RecyclerView.this.mDataSetHasChangedAfterLayout) {
                    if (RecyclerView.this.mItemAnimator.mo5072a(xVar, xVar, cVar, cVar2)) {
                        RecyclerView.this.postAnimationRunner();
                    }
                } else if (RecyclerView.this.mItemAnimator.mo5076c(xVar, cVar, cVar2)) {
                    RecyclerView.this.postAnimationRunner();
                }
            }

            /* renamed from: a */
            public void mo4999a(C1277x xVar) {
                RecyclerView.this.mLayout.mo5117a(xVar.itemView, RecyclerView.this.mRecycler);
            }
        };
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, CLIP_TO_PADDING_ATTR, i, 0);
            this.mClipToPadding = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            this.mClipToPadding = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mScaledHorizontalScrollFactor = C0966s.m3612a(viewConfiguration, context);
        this.mScaledVerticalScrollFactor = C0966s.m3614b(viewConfiguration, context);
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.mItemAnimator.mo5070a(this.mItemAnimatorListener);
        initAdapterManager();
        initChildrenHelper();
        initAutofill();
        if (C0962r.m3577e(this) == 0) {
            C0962r.m3569b((View) this, 1);
        }
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new C1320j(this));
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.RecyclerView, i, 0);
            String string = obtainStyledAttributes2.getString(R.styleable.RecyclerView_layoutManager);
            if (obtainStyledAttributes2.getInt(R.styleable.RecyclerView_android_descendantFocusability, -1) == -1) {
                setDescendantFocusability(MediaHttpUploader.MINIMUM_CHUNK_SIZE);
            }
            this.mEnableFastScroller = obtainStyledAttributes2.getBoolean(R.styleable.RecyclerView_fastScrollEnabled, false);
            if (this.mEnableFastScroller) {
                initFastScroller((StateListDrawable) obtainStyledAttributes2.getDrawable(R.styleable.RecyclerView_fastScrollVerticalThumbDrawable), obtainStyledAttributes2.getDrawable(R.styleable.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) obtainStyledAttributes2.getDrawable(R.styleable.RecyclerView_fastScrollHorizontalThumbDrawable), obtainStyledAttributes2.getDrawable(R.styleable.RecyclerView_fastScrollHorizontalTrackDrawable));
            }
            obtainStyledAttributes2.recycle();
            createLayoutManager(context, string, attributeSet, i, 0);
            if (VERSION.SDK_INT >= 21) {
                TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, NESTED_SCROLLING_ATTRS, i, 0);
                boolean z2 = obtainStyledAttributes3.getBoolean(0, true);
                obtainStyledAttributes3.recycle();
                z = z2;
            }
        } else {
            setDescendantFocusability(MediaHttpUploader.MINIMUM_CHUNK_SIZE);
        }
        setNestedScrollingEnabled(z);
    }

    /* access modifiers changed from: 0000 */
    public String exceptionLabel() {
        StringBuilder sb = new StringBuilder();
        sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        sb.append(super.toString());
        sb.append(", adapter:");
        sb.append(this.mAdapter);
        sb.append(", layout:");
        sb.append(this.mLayout);
        sb.append(", context:");
        sb.append(getContext());
        return sb.toString();
    }

    @SuppressLint({"InlinedApi"})
    private void initAutofill() {
        if (C0962r.m3547a(this) == 0) {
            C0962r.m3551a((View) this, 8);
        }
    }

    public C1320j getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public void setAccessibilityDelegateCompat(C1320j jVar) {
        this.mAccessibilityDelegate = jVar;
        C0962r.m3559a((View) this, (C0932a) this.mAccessibilityDelegate);
    }

    private void createLayoutManager(Context context, String str, AttributeSet attributeSet, int i, int i2) {
        ClassLoader classLoader;
        Constructor constructor;
        if (str != null) {
            String trim = str.trim();
            if (!trim.isEmpty()) {
                String fullClassName = getFullClassName(context, trim);
                try {
                    if (isInEditMode()) {
                        classLoader = getClass().getClassLoader();
                    } else {
                        classLoader = context.getClassLoader();
                    }
                    Class asSubclass = classLoader.loadClass(fullClassName).asSubclass(C1254i.class);
                    Object[] objArr = null;
                    try {
                        constructor = asSubclass.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
                        objArr = new Object[]{context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
                    } catch (NoSuchMethodException e) {
                        constructor = asSubclass.getConstructor(new Class[0]);
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((C1254i) constructor.newInstance(objArr));
                } catch (NoSuchMethodException e2) {
                    e2.initCause(e);
                    StringBuilder sb = new StringBuilder();
                    sb.append(attributeSet.getPositionDescription());
                    sb.append(": Error creating LayoutManager ");
                    sb.append(fullClassName);
                    throw new IllegalStateException(sb.toString(), e2);
                } catch (ClassNotFoundException e3) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(attributeSet.getPositionDescription());
                    sb2.append(": Unable to find LayoutManager ");
                    sb2.append(fullClassName);
                    throw new IllegalStateException(sb2.toString(), e3);
                } catch (InvocationTargetException e4) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(attributeSet.getPositionDescription());
                    sb3.append(": Could not instantiate the LayoutManager: ");
                    sb3.append(fullClassName);
                    throw new IllegalStateException(sb3.toString(), e4);
                } catch (InstantiationException e5) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(attributeSet.getPositionDescription());
                    sb4.append(": Could not instantiate the LayoutManager: ");
                    sb4.append(fullClassName);
                    throw new IllegalStateException(sb4.toString(), e5);
                } catch (IllegalAccessException e6) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(attributeSet.getPositionDescription());
                    sb5.append(": Cannot access non-public constructor ");
                    sb5.append(fullClassName);
                    throw new IllegalStateException(sb5.toString(), e6);
                } catch (ClassCastException e7) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(attributeSet.getPositionDescription());
                    sb6.append(": Class is not a LayoutManager ");
                    sb6.append(fullClassName);
                    throw new IllegalStateException(sb6.toString(), e7);
                }
            }
        }
    }

    private String getFullClassName(Context context, String str) {
        if (str.charAt(0) == '.') {
            StringBuilder sb = new StringBuilder();
            sb.append(context.getPackageName());
            sb.append(str);
            return sb.toString();
        } else if (str.contains(".")) {
            return str;
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(RecyclerView.class.getPackage().getName());
            sb2.append('.');
            sb2.append(str);
            return sb2.toString();
        }
    }

    private void initChildrenHelper() {
        this.mChildHelper = new C1290b(new C1292b() {
            /* renamed from: a */
            public int mo5003a() {
                return RecyclerView.this.getChildCount();
            }

            /* renamed from: a */
            public void mo5006a(View view, int i) {
                RecyclerView.this.addView(view, i);
                RecyclerView.this.dispatchChildAttached(view);
            }

            /* renamed from: a */
            public int mo5004a(View view) {
                return RecyclerView.this.indexOfChild(view);
            }

            /* renamed from: a */
            public void mo5005a(int i) {
                View childAt = RecyclerView.this.getChildAt(i);
                if (childAt != null) {
                    RecyclerView.this.dispatchChildDetached(childAt);
                    childAt.clearAnimation();
                }
                RecyclerView.this.removeViewAt(i);
            }

            /* renamed from: b */
            public View mo5008b(int i) {
                return RecyclerView.this.getChildAt(i);
            }

            /* renamed from: b */
            public void mo5010b() {
                int a = mo5003a();
                for (int i = 0; i < a; i++) {
                    View b = mo5008b(i);
                    RecyclerView.this.dispatchChildDetached(b);
                    b.clearAnimation();
                }
                RecyclerView.this.removeAllViews();
            }

            /* renamed from: b */
            public C1277x mo5009b(View view) {
                return RecyclerView.getChildViewHolderInt(view);
            }

            /* renamed from: a */
            public void mo5007a(View view, int i, LayoutParams layoutParams) {
                C1277x childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    if (childViewHolderInt.isTmpDetached() || childViewHolderInt.shouldIgnore()) {
                        childViewHolderInt.clearTmpDetachFlag();
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Called attach on a child which is not detached: ");
                        sb.append(childViewHolderInt);
                        sb.append(RecyclerView.this.exceptionLabel());
                        throw new IllegalArgumentException(sb.toString());
                    }
                }
                RecyclerView.this.attachViewToParent(view, i, layoutParams);
            }

            /* renamed from: c */
            public void mo5011c(int i) {
                View b = mo5008b(i);
                if (b != null) {
                    C1277x childViewHolderInt = RecyclerView.getChildViewHolderInt(b);
                    if (childViewHolderInt != null) {
                        if (!childViewHolderInt.isTmpDetached() || childViewHolderInt.shouldIgnore()) {
                            childViewHolderInt.addFlags(256);
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append("called detach on an already detached child ");
                            sb.append(childViewHolderInt);
                            sb.append(RecyclerView.this.exceptionLabel());
                            throw new IllegalArgumentException(sb.toString());
                        }
                    }
                }
                RecyclerView.this.detachViewFromParent(i);
            }

            /* renamed from: c */
            public void mo5012c(View view) {
                C1277x childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    childViewHolderInt.onEnteredHiddenState(RecyclerView.this);
                }
            }

            /* renamed from: d */
            public void mo5013d(View view) {
                C1277x childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    childViewHolderInt.onLeftHiddenState(RecyclerView.this);
                }
            }
        });
    }

    /* access modifiers changed from: 0000 */
    public void initAdapterManager() {
        this.mAdapterHelper = new C1287a(new C1288a() {
            /* renamed from: a */
            public C1277x mo5014a(int i) {
                C1277x findViewHolderForPosition = RecyclerView.this.findViewHolderForPosition(i, true);
                if (findViewHolderForPosition != null && !RecyclerView.this.mChildHelper.mo5451c(findViewHolderForPosition.itemView)) {
                    return findViewHolderForPosition;
                }
                return null;
            }

            /* renamed from: a */
            public void mo5015a(int i, int i2) {
                RecyclerView.this.offsetPositionRecordsForRemove(i, i2, true);
                RecyclerView.this.mItemsAddedOrRemoved = true;
                RecyclerView.this.mState.f3767c += i2;
            }

            /* renamed from: b */
            public void mo5018b(int i, int i2) {
                RecyclerView.this.offsetPositionRecordsForRemove(i, i2, false);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }

            /* renamed from: a */
            public void mo5016a(int i, int i2, Object obj) {
                RecyclerView.this.viewRangeUpdate(i, i2, obj);
                RecyclerView.this.mItemsChanged = true;
            }

            /* renamed from: a */
            public void mo5017a(C1289b bVar) {
                mo5021c(bVar);
            }

            /* access modifiers changed from: 0000 */
            /* renamed from: c */
            public void mo5021c(C1289b bVar) {
                int i = bVar.f3853a;
                if (i == 4) {
                    RecyclerView.this.mLayout.mo4743a(RecyclerView.this, bVar.f3854b, bVar.f3856d, bVar.f3855c);
                } else if (i != 8) {
                    switch (i) {
                        case 1:
                            RecyclerView.this.mLayout.mo4741a(RecyclerView.this, bVar.f3854b, bVar.f3856d);
                            return;
                        case 2:
                            RecyclerView.this.mLayout.mo4748b(RecyclerView.this, bVar.f3854b, bVar.f3856d);
                            return;
                        default:
                            return;
                    }
                } else {
                    RecyclerView.this.mLayout.mo4742a(RecyclerView.this, bVar.f3854b, bVar.f3856d, 1);
                }
            }

            /* renamed from: b */
            public void mo5019b(C1289b bVar) {
                mo5021c(bVar);
            }

            /* renamed from: c */
            public void mo5020c(int i, int i2) {
                RecyclerView.this.offsetPositionRecordsForInsert(i, i2);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }

            /* renamed from: d */
            public void mo5022d(int i, int i2) {
                RecyclerView.this.offsetPositionRecordsForMove(i, i2);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }
        });
    }

    public void setHasFixedSize(boolean z) {
        this.mHasFixedSize = z;
    }

    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }

    public void setClipToPadding(boolean z) {
        if (z != this.mClipToPadding) {
            invalidateGlows();
        }
        this.mClipToPadding = z;
        super.setClipToPadding(z);
        if (this.mFirstLayoutComplete) {
            requestLayout();
        }
    }

    public boolean getClipToPadding() {
        return this.mClipToPadding;
    }

    public void setScrollingTouchSlop(int i) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        switch (i) {
            case 0:
                break;
            case 1:
                this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
                return;
            default:
                String str = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("setScrollingTouchSlop(): bad argument constant ");
                sb.append(i);
                sb.append("; using default value");
                Log.w(str, sb.toString());
                break;
        }
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
    }

    public void swapAdapter(C1243a aVar, boolean z) {
        setLayoutFrozen(false);
        setAdapterInternal(aVar, true, z);
        processDataSetCompletelyChanged(true);
        requestLayout();
    }

    public void setAdapter(C1243a aVar) {
        setLayoutFrozen(false);
        setAdapterInternal(aVar, false, true);
        processDataSetCompletelyChanged(false);
        requestLayout();
    }

    /* access modifiers changed from: 0000 */
    public void removeAndRecycleViews() {
        if (this.mItemAnimator != null) {
            this.mItemAnimator.mo5077d();
        }
        if (this.mLayout != null) {
            this.mLayout.mo5149c(this.mRecycler);
            this.mLayout.mo5141b(this.mRecycler);
        }
        this.mRecycler.mo5222a();
    }

    private void setAdapterInternal(C1243a aVar, boolean z, boolean z2) {
        if (this.mAdapter != null) {
            this.mAdapter.unregisterAdapterDataObserver(this.mObserver);
            this.mAdapter.onDetachedFromRecyclerView(this);
        }
        if (!z || z2) {
            removeAndRecycleViews();
        }
        this.mAdapterHelper.mo5420a();
        C1243a aVar2 = this.mAdapter;
        this.mAdapter = aVar;
        if (aVar != null) {
            aVar.registerAdapterDataObserver(this.mObserver);
            aVar.onAttachedToRecyclerView(this);
        }
        if (this.mLayout != null) {
            this.mLayout.mo5120a(aVar2, this.mAdapter);
        }
        this.mRecycler.mo5227a(aVar2, this.mAdapter, z);
        this.mState.f3770f = true;
    }

    public C1243a getAdapter() {
        return this.mAdapter;
    }

    public void setRecyclerListener(C1267q qVar) {
        this.mRecyclerListener = qVar;
    }

    public int getBaseline() {
        if (this.mLayout != null) {
            return this.mLayout.mo5185v();
        }
        return super.getBaseline();
    }

    public void addOnChildAttachStateChangeListener(C1260k kVar) {
        if (this.mOnChildAttachStateListeners == null) {
            this.mOnChildAttachStateListeners = new ArrayList();
        }
        this.mOnChildAttachStateListeners.add(kVar);
    }

    public void removeOnChildAttachStateChangeListener(C1260k kVar) {
        if (this.mOnChildAttachStateListeners != null) {
            this.mOnChildAttachStateListeners.remove(kVar);
        }
    }

    public void clearOnChildAttachStateChangeListeners() {
        if (this.mOnChildAttachStateListeners != null) {
            this.mOnChildAttachStateListeners.clear();
        }
    }

    public void setLayoutManager(C1254i iVar) {
        if (iVar != this.mLayout) {
            stopScroll();
            if (this.mLayout != null) {
                if (this.mItemAnimator != null) {
                    this.mItemAnimator.mo5077d();
                }
                this.mLayout.mo5149c(this.mRecycler);
                this.mLayout.mo5141b(this.mRecycler);
                this.mRecycler.mo5222a();
                if (this.mIsAttached) {
                    this.mLayout.mo5144b(this, this.mRecycler);
                }
                this.mLayout.mo5143b((RecyclerView) null);
                this.mLayout = null;
            } else {
                this.mRecycler.mo5222a();
            }
            this.mChildHelper.mo5440a();
            this.mLayout = iVar;
            if (iVar != null) {
                if (iVar.f3714q == null) {
                    this.mLayout.mo5143b(this);
                    if (this.mIsAttached) {
                        this.mLayout.mo5150c(this);
                    }
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("LayoutManager ");
                    sb.append(iVar);
                    sb.append(" is already attached to a RecyclerView:");
                    sb.append(iVar.f3714q.exceptionLabel());
                    throw new IllegalArgumentException(sb.toString());
                }
            }
            this.mRecycler.mo5234b();
            requestLayout();
        }
    }

    public void setOnFlingListener(C1261l lVar) {
        this.mOnFlingListener = lVar;
    }

    public C1261l getOnFlingListener() {
        return this.mOnFlingListener;
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        C1269s sVar = new C1269s(super.onSaveInstanceState());
        if (this.mPendingSavedState != null) {
            sVar.mo5256a(this.mPendingSavedState);
        } else if (this.mLayout != null) {
            sVar.f3749a = this.mLayout.mo4778d();
        } else {
            sVar.f3749a = null;
        }
        return sVar;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof C1269s)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        this.mPendingSavedState = (C1269s) parcelable;
        super.onRestoreInstanceState(this.mPendingSavedState.getSuperState());
        if (!(this.mLayout == null || this.mPendingSavedState.f3749a == null)) {
            this.mLayout.mo4763a(this.mPendingSavedState.f3749a);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    private void addAnimatingView(C1277x xVar) {
        View view = xVar.itemView;
        boolean z = view.getParent() == this;
        this.mRecycler.mo5242c(getChildViewHolder(view));
        if (xVar.isTmpDetached()) {
            this.mChildHelper.mo5443a(view, -1, view.getLayoutParams(), true);
        } else if (!z) {
            this.mChildHelper.mo5445a(view, true);
        } else {
            this.mChildHelper.mo5453d(view);
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean removeAnimatingView(View view) {
        startInterceptRequestLayout();
        boolean f = this.mChildHelper.mo5456f(view);
        if (f) {
            C1277x childViewHolderInt = getChildViewHolderInt(view);
            this.mRecycler.mo5242c(childViewHolderInt);
            this.mRecycler.mo5237b(childViewHolderInt);
        }
        stopInterceptRequestLayout(!f);
        return f;
    }

    public C1254i getLayoutManager() {
        return this.mLayout;
    }

    public C1264o getRecycledViewPool() {
        return this.mRecycler.mo5250g();
    }

    public void setRecycledViewPool(C1264o oVar) {
        this.mRecycler.mo5228a(oVar);
    }

    public void setViewCacheExtension(C1275v vVar) {
        this.mRecycler.mo5229a(vVar);
    }

    public void setItemViewCacheSize(int i) {
        this.mRecycler.mo5223a(i);
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    /* access modifiers changed from: 0000 */
    public void setScrollState(int i) {
        if (i != this.mScrollState) {
            this.mScrollState = i;
            if (i != 2) {
                stopScrollersInternal();
            }
            dispatchOnScrollStateChanged(i);
        }
    }

    public void addItemDecoration(C1253h hVar, int i) {
        if (this.mLayout != null) {
            this.mLayout.mo4767a("Cannot add item decoration during a scroll  or layout");
        }
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i < 0) {
            this.mItemDecorations.add(hVar);
        } else {
            this.mItemDecorations.add(i, hVar);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void addItemDecoration(C1253h hVar) {
        addItemDecoration(hVar, -1);
    }

    public C1253h getItemDecorationAt(int i) {
        int itemDecorationCount = getItemDecorationCount();
        if (i >= 0 && i < itemDecorationCount) {
            return (C1253h) this.mItemDecorations.get(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append(" is an invalid index for size ");
        sb.append(itemDecorationCount);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public int getItemDecorationCount() {
        return this.mItemDecorations.size();
    }

    public void removeItemDecorationAt(int i) {
        int itemDecorationCount = getItemDecorationCount();
        if (i < 0 || i >= itemDecorationCount) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            sb.append(" is an invalid index for size ");
            sb.append(itemDecorationCount);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        removeItemDecoration(getItemDecorationAt(i));
    }

    public void removeItemDecoration(C1253h hVar) {
        if (this.mLayout != null) {
            this.mLayout.mo4767a("Cannot remove item decoration during a scroll  or layout");
        }
        this.mItemDecorations.remove(hVar);
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void setChildDrawingOrderCallback(C1246d dVar) {
        if (dVar != this.mChildDrawingOrderCallback) {
            this.mChildDrawingOrderCallback = dVar;
            setChildrenDrawingOrderEnabled(this.mChildDrawingOrderCallback != null);
        }
    }

    @Deprecated
    public void setOnScrollListener(C1263n nVar) {
        this.mScrollListener = nVar;
    }

    public void addOnScrollListener(C1263n nVar) {
        if (this.mScrollListeners == null) {
            this.mScrollListeners = new ArrayList();
        }
        this.mScrollListeners.add(nVar);
    }

    public void removeOnScrollListener(C1263n nVar) {
        if (this.mScrollListeners != null) {
            this.mScrollListeners.remove(nVar);
        }
    }

    public void clearOnScrollListeners() {
        if (this.mScrollListeners != null) {
            this.mScrollListeners.clear();
        }
    }

    public void scrollToPosition(int i) {
        if (!this.mLayoutFrozen) {
            stopScroll();
            if (this.mLayout == null) {
                Log.e(TAG, "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
                return;
            }
            this.mLayout.mo4780e(i);
            awakenScrollBars();
        }
    }

    /* access modifiers changed from: 0000 */
    public void jumpToPositionForSmoothScroller(int i) {
        if (this.mLayout != null) {
            this.mLayout.mo4780e(i);
            awakenScrollBars();
        }
    }

    public void smoothScrollToPosition(int i) {
        if (!this.mLayoutFrozen) {
            if (this.mLayout == null) {
                Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            } else {
                this.mLayout.mo4766a(this, this.mState, i);
            }
        }
    }

    public void scrollTo(int i, int i2) {
        Log.w(TAG, "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollBy(int i, int i2) {
        if (this.mLayout == null) {
            Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.mLayoutFrozen) {
            boolean e = this.mLayout.mo4781e();
            boolean f = this.mLayout.mo4784f();
            if (e || f) {
                if (!e) {
                    i = 0;
                }
                if (!f) {
                    i2 = 0;
                }
                scrollByInternal(i, i2, null);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void scrollStep(int i, int i2, int[] iArr) {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        C0872b.m3226a(TRACE_SCROLL_TAG);
        fillRemainingScrollValues(this.mState);
        int a = i != 0 ? this.mLayout.mo4726a(i, this.mRecycler, this.mState) : 0;
        int b = i2 != 0 ? this.mLayout.mo4746b(i2, this.mRecycler, this.mState) : 0;
        C0872b.m3225a();
        repositionShadowingViews();
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        if (iArr != null) {
            iArr[0] = a;
            iArr[1] = b;
        }
    }

    /* access modifiers changed from: 0000 */
    public void consumePendingUpdateOperations() {
        if (!this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout) {
            C0872b.m3226a(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
            dispatchLayout();
            C0872b.m3225a();
        } else if (this.mAdapterHelper.mo5433d()) {
            if (this.mAdapterHelper.mo5424a(4) && !this.mAdapterHelper.mo5424a(11)) {
                C0872b.m3226a(TRACE_HANDLE_ADAPTER_UPDATES_TAG);
                startInterceptRequestLayout();
                onEnterLayoutOrScroll();
                this.mAdapterHelper.mo5428b();
                if (!this.mLayoutWasDefered) {
                    if (hasUpdatedView()) {
                        dispatchLayout();
                    } else {
                        this.mAdapterHelper.mo5431c();
                    }
                }
                stopInterceptRequestLayout(true);
                onExitLayoutOrScroll();
                C0872b.m3225a();
            } else if (this.mAdapterHelper.mo5433d()) {
                C0872b.m3226a(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
                dispatchLayout();
                C0872b.m3225a();
            }
        }
    }

    private boolean hasUpdatedView() {
        int b = this.mChildHelper.mo5446b();
        for (int i = 0; i < b; i++) {
            C1277x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.mo5448b(i));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.isUpdated()) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    public boolean scrollByInternal(int i, int i2, MotionEvent motionEvent) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = i;
        int i8 = i2;
        MotionEvent motionEvent2 = motionEvent;
        consumePendingUpdateOperations();
        if (this.mAdapter != null) {
            scrollStep(i7, i8, this.mScrollStepConsumed);
            int i9 = this.mScrollStepConsumed[0];
            int i10 = this.mScrollStepConsumed[1];
            i5 = i9;
            i4 = i10;
            i3 = i7 - i9;
            i6 = i8 - i10;
        } else {
            i6 = 0;
            i5 = 0;
            i4 = 0;
            i3 = 0;
        }
        if (!this.mItemDecorations.isEmpty()) {
            invalidate();
        }
        int i11 = i6;
        if (dispatchNestedScroll(i5, i4, i3, i6, this.mScrollOffset, 0)) {
            this.mLastTouchX -= this.mScrollOffset[0];
            this.mLastTouchY -= this.mScrollOffset[1];
            if (motionEvent2 != null) {
                motionEvent2.offsetLocation((float) this.mScrollOffset[0], (float) this.mScrollOffset[1]);
            }
            int[] iArr = this.mNestedOffsets;
            iArr[0] = iArr[0] + this.mScrollOffset[0];
            int[] iArr2 = this.mNestedOffsets;
            iArr2[1] = iArr2[1] + this.mScrollOffset[1];
        } else if (getOverScrollMode() != 2) {
            if (motionEvent2 != null && !C0952h.m3517d(motionEvent2, 8194)) {
                pullGlows(motionEvent.getX(), (float) i3, motionEvent.getY(), (float) i11);
            }
            considerReleasingGlowsOnScroll(i, i2);
        }
        if (!(i5 == 0 && i4 == 0)) {
            dispatchOnScrolled(i5, i4);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        if (i5 == 0 && i4 == 0) {
            return false;
        }
        return true;
    }

    public int computeHorizontalScrollOffset() {
        int i = 0;
        if (this.mLayout == null) {
            return 0;
        }
        if (this.mLayout.mo4781e()) {
            i = this.mLayout.mo4773c(this.mState);
        }
        return i;
    }

    public int computeHorizontalScrollExtent() {
        int i = 0;
        if (this.mLayout == null) {
            return 0;
        }
        if (this.mLayout.mo4781e()) {
            i = this.mLayout.mo4779e(this.mState);
        }
        return i;
    }

    public int computeHorizontalScrollRange() {
        int i = 0;
        if (this.mLayout == null) {
            return 0;
        }
        if (this.mLayout.mo4781e()) {
            i = this.mLayout.mo4786g(this.mState);
        }
        return i;
    }

    public int computeVerticalScrollOffset() {
        int i = 0;
        if (this.mLayout == null) {
            return 0;
        }
        if (this.mLayout.mo4784f()) {
            i = this.mLayout.mo4776d(this.mState);
        }
        return i;
    }

    public int computeVerticalScrollExtent() {
        int i = 0;
        if (this.mLayout == null) {
            return 0;
        }
        if (this.mLayout.mo4784f()) {
            i = this.mLayout.mo4783f(this.mState);
        }
        return i;
    }

    public int computeVerticalScrollRange() {
        int i = 0;
        if (this.mLayout == null) {
            return 0;
        }
        if (this.mLayout.mo4784f()) {
            i = this.mLayout.mo4787h(this.mState);
        }
        return i;
    }

    /* access modifiers changed from: 0000 */
    public void startInterceptRequestLayout() {
        this.mInterceptRequestLayoutDepth++;
        if (this.mInterceptRequestLayoutDepth == 1 && !this.mLayoutFrozen) {
            this.mLayoutWasDefered = false;
        }
    }

    /* access modifiers changed from: 0000 */
    public void stopInterceptRequestLayout(boolean z) {
        if (this.mInterceptRequestLayoutDepth < 1) {
            this.mInterceptRequestLayoutDepth = 1;
        }
        if (!z && !this.mLayoutFrozen) {
            this.mLayoutWasDefered = false;
        }
        if (this.mInterceptRequestLayoutDepth == 1) {
            if (z && this.mLayoutWasDefered && !this.mLayoutFrozen && this.mLayout != null && this.mAdapter != null) {
                dispatchLayout();
            }
            if (!this.mLayoutFrozen) {
                this.mLayoutWasDefered = false;
            }
        }
        this.mInterceptRequestLayoutDepth--;
    }

    public void setLayoutFrozen(boolean z) {
        if (z != this.mLayoutFrozen) {
            assertNotInLayoutOrScroll("Do not setLayoutFrozen in layout or scroll");
            if (!z) {
                this.mLayoutFrozen = false;
                if (!(!this.mLayoutWasDefered || this.mLayout == null || this.mAdapter == null)) {
                    requestLayout();
                }
                this.mLayoutWasDefered = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 0));
            this.mLayoutFrozen = true;
            this.mIgnoreMotionEventTillDown = true;
            stopScroll();
        }
    }

    public boolean isLayoutFrozen() {
        return this.mLayoutFrozen;
    }

    public void smoothScrollBy(int i, int i2) {
        smoothScrollBy(i, i2, null);
    }

    public void smoothScrollBy(int i, int i2, Interpolator interpolator) {
        if (this.mLayout == null) {
            Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.mLayoutFrozen) {
            if (!this.mLayout.mo4781e()) {
                i = 0;
            }
            if (!this.mLayout.mo4784f()) {
                i2 = 0;
            }
            if (!(i == 0 && i2 == 0)) {
                this.mViewFlinger.mo5299a(i, i2, interpolator);
            }
        }
    }

    public boolean fling(int i, int i2) {
        int i3 = 0;
        if (this.mLayout == null) {
            Log.e(TAG, "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        } else if (this.mLayoutFrozen) {
            return false;
        } else {
            boolean e = this.mLayout.mo4781e();
            boolean f = this.mLayout.mo4784f();
            if (!e || Math.abs(i) < this.mMinFlingVelocity) {
                i = 0;
            }
            if (!f || Math.abs(i2) < this.mMinFlingVelocity) {
                i2 = 0;
            }
            if (i == 0 && i2 == 0) {
                return false;
            }
            float f2 = (float) i;
            float f3 = (float) i2;
            if (!dispatchNestedPreFling(f2, f3)) {
                boolean z = e || f;
                dispatchNestedFling(f2, f3, z);
                if (this.mOnFlingListener != null && this.mOnFlingListener.mo5202a(i, i2)) {
                    return true;
                }
                if (z) {
                    if (e) {
                        i3 = 1;
                    }
                    if (f) {
                        i3 |= 2;
                    }
                    startNestedScroll(i3, 1);
                    this.mViewFlinger.mo5295a(Math.max(-this.mMaxFlingVelocity, Math.min(i, this.mMaxFlingVelocity)), Math.max(-this.mMaxFlingVelocity, Math.min(i2, this.mMaxFlingVelocity)));
                    return true;
                }
            }
            return false;
        }
    }

    public void stopScroll() {
        setScrollState(0);
        stopScrollersInternal();
    }

    private void stopScrollersInternal() {
        this.mViewFlinger.mo5300b();
        if (this.mLayout != null) {
            this.mLayout.mo5106I();
        }
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0056  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void pullGlows(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = 1
            r2 = 0
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 >= 0) goto L_0x0021
            r6.ensureLeftGlow()
            android.widget.EdgeEffect r3 = r6.mLeftGlow
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r0 - r9
            androidx.core.widget.C1008d.m3847a(r3, r4, r9)
        L_0x001f:
            r9 = 1
            goto L_0x003c
        L_0x0021:
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 <= 0) goto L_0x003b
            r6.ensureRightGlow()
            android.widget.EdgeEffect r3 = r6.mRightGlow
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            androidx.core.widget.C1008d.m3847a(r3, r4, r9)
            goto L_0x001f
        L_0x003b:
            r9 = 0
        L_0x003c:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 >= 0) goto L_0x0056
            r6.ensureTopGlow()
            android.widget.EdgeEffect r9 = r6.mTopGlow
            float r0 = -r10
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r0 = r0 / r3
            int r3 = r6.getWidth()
            float r3 = (float) r3
            float r7 = r7 / r3
            androidx.core.widget.C1008d.m3847a(r9, r0, r7)
            goto L_0x0072
        L_0x0056:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 <= 0) goto L_0x0071
            r6.ensureBottomGlow()
            android.widget.EdgeEffect r9 = r6.mBottomGlow
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r3 = r10 / r3
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r0 = r0 - r7
            androidx.core.widget.C1008d.m3847a(r9, r3, r0)
            goto L_0x0072
        L_0x0071:
            r1 = r9
        L_0x0072:
            if (r1 != 0) goto L_0x007c
            int r7 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r7 != 0) goto L_0x007c
            int r7 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r7 == 0) goto L_0x007f
        L_0x007c:
            androidx.core.p070g.C0962r.m3575d(r6)
        L_0x007f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.pullGlows(float, float, float, float):void");
    }

    private void releaseGlows() {
        boolean z;
        if (this.mLeftGlow != null) {
            this.mLeftGlow.onRelease();
            z = this.mLeftGlow.isFinished();
        } else {
            z = false;
        }
        if (this.mTopGlow != null) {
            this.mTopGlow.onRelease();
            z |= this.mTopGlow.isFinished();
        }
        if (this.mRightGlow != null) {
            this.mRightGlow.onRelease();
            z |= this.mRightGlow.isFinished();
        }
        if (this.mBottomGlow != null) {
            this.mBottomGlow.onRelease();
            z |= this.mBottomGlow.isFinished();
        }
        if (z) {
            C0962r.m3575d(this);
        }
    }

    /* access modifiers changed from: 0000 */
    public void considerReleasingGlowsOnScroll(int i, int i2) {
        boolean z;
        if (this.mLeftGlow == null || this.mLeftGlow.isFinished() || i <= 0) {
            z = false;
        } else {
            this.mLeftGlow.onRelease();
            z = this.mLeftGlow.isFinished();
        }
        if (this.mRightGlow != null && !this.mRightGlow.isFinished() && i < 0) {
            this.mRightGlow.onRelease();
            z |= this.mRightGlow.isFinished();
        }
        if (this.mTopGlow != null && !this.mTopGlow.isFinished() && i2 > 0) {
            this.mTopGlow.onRelease();
            z |= this.mTopGlow.isFinished();
        }
        if (this.mBottomGlow != null && !this.mBottomGlow.isFinished() && i2 < 0) {
            this.mBottomGlow.onRelease();
            z |= this.mBottomGlow.isFinished();
        }
        if (z) {
            C0962r.m3575d(this);
        }
    }

    /* access modifiers changed from: 0000 */
    public void absorbGlows(int i, int i2) {
        if (i < 0) {
            ensureLeftGlow();
            this.mLeftGlow.onAbsorb(-i);
        } else if (i > 0) {
            ensureRightGlow();
            this.mRightGlow.onAbsorb(i);
        }
        if (i2 < 0) {
            ensureTopGlow();
            this.mTopGlow.onAbsorb(-i2);
        } else if (i2 > 0) {
            ensureBottomGlow();
            this.mBottomGlow.onAbsorb(i2);
        }
        if (i != 0 || i2 != 0) {
            C0962r.m3575d(this);
        }
    }

    /* access modifiers changed from: 0000 */
    public void ensureLeftGlow() {
        if (this.mLeftGlow == null) {
            this.mLeftGlow = this.mEdgeEffectFactory.mo5066a(this, 0);
            if (this.mClipToPadding) {
                this.mLeftGlow.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.mLeftGlow.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void ensureRightGlow() {
        if (this.mRightGlow == null) {
            this.mRightGlow = this.mEdgeEffectFactory.mo5066a(this, 2);
            if (this.mClipToPadding) {
                this.mRightGlow.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.mRightGlow.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void ensureTopGlow() {
        if (this.mTopGlow == null) {
            this.mTopGlow = this.mEdgeEffectFactory.mo5066a(this, 1);
            if (this.mClipToPadding) {
                this.mTopGlow.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.mTopGlow.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void ensureBottomGlow() {
        if (this.mBottomGlow == null) {
            this.mBottomGlow = this.mEdgeEffectFactory.mo5066a(this, 3);
            if (this.mClipToPadding) {
                this.mBottomGlow.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.mBottomGlow.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void invalidateGlows() {
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }

    public void setEdgeEffectFactory(C1247e eVar) {
        C0930e.m3403a(eVar);
        this.mEdgeEffectFactory = eVar;
        invalidateGlows();
    }

    public C1247e getEdgeEffectFactory() {
        return this.mEdgeEffectFactory;
    }

    public View focusSearch(View view, int i) {
        View view2;
        boolean z;
        View d = this.mLayout.mo5154d(view, i);
        if (d != null) {
            return d;
        }
        boolean z2 = this.mAdapter != null && this.mLayout != null && !isComputingLayout() && !this.mLayoutFrozen;
        FocusFinder instance = FocusFinder.getInstance();
        if (!z2 || !(i == 2 || i == 1)) {
            View findNextFocus = instance.findNextFocus(this, view, i);
            if (findNextFocus != null || !z2) {
                view2 = findNextFocus;
            } else {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                view2 = this.mLayout.mo4728a(view, i, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            }
        } else {
            if (this.mLayout.mo4784f()) {
                int i2 = i == 2 ? 130 : 33;
                z = instance.findNextFocus(this, view, i2) == null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i = i2;
                }
            } else {
                z = false;
            }
            if (!z && this.mLayout.mo4781e()) {
                int i3 = (this.mLayout.mo5184u() == 1) ^ (i == 2) ? 66 : 17;
                z = instance.findNextFocus(this, view, i3) == null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i = i3;
                }
            }
            if (z) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                this.mLayout.mo4728a(view, i, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            }
            view2 = instance.findNextFocus(this, view, i);
        }
        if (view2 == null || view2.hasFocusable()) {
            if (!isPreferredNextFocus(view, view2, i)) {
                view2 = super.focusSearch(view, i);
            }
            return view2;
        } else if (getFocusedChild() == null) {
            return super.focusSearch(view, i);
        } else {
            requestChildOnScreen(view2, null);
            return view;
        }
    }

    private boolean isPreferredNextFocus(View view, View view2, int i) {
        boolean z = false;
        if (view2 == null || view2 == this || findContainingItemView(view2) == null) {
            return false;
        }
        if (view == null || findContainingItemView(view) == null) {
            return true;
        }
        this.mTempRect.set(0, 0, view.getWidth(), view.getHeight());
        this.mTempRect2.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        offsetDescendantRectToMyCoords(view2, this.mTempRect2);
        char c = 65535;
        int i2 = this.mLayout.mo5184u() == 1 ? -1 : 1;
        int i3 = ((this.mTempRect.left < this.mTempRect2.left || this.mTempRect.right <= this.mTempRect2.left) && this.mTempRect.right < this.mTempRect2.right) ? 1 : ((this.mTempRect.right > this.mTempRect2.right || this.mTempRect.left >= this.mTempRect2.right) && this.mTempRect.left > this.mTempRect2.left) ? -1 : 0;
        if ((this.mTempRect.top < this.mTempRect2.top || this.mTempRect.bottom <= this.mTempRect2.top) && this.mTempRect.bottom < this.mTempRect2.bottom) {
            c = 1;
        } else if ((this.mTempRect.bottom <= this.mTempRect2.bottom && this.mTempRect.top < this.mTempRect2.bottom) || this.mTempRect.top <= this.mTempRect2.top) {
            c = 0;
        }
        if (i == 17) {
            if (i3 < 0) {
                z = true;
            }
            return z;
        } else if (i == 33) {
            if (c < 0) {
                z = true;
            }
            return z;
        } else if (i == 66) {
            if (i3 > 0) {
                z = true;
            }
            return z;
        } else if (i != 130) {
            switch (i) {
                case 1:
                    if (c < 0 || (c == 0 && i3 * i2 <= 0)) {
                        z = true;
                    }
                    return z;
                case 2:
                    if (c > 0 || (c == 0 && i3 * i2 >= 0)) {
                        z = true;
                    }
                    return z;
                default:
                    StringBuilder sb = new StringBuilder();
                    sb.append("Invalid direction: ");
                    sb.append(i);
                    sb.append(exceptionLabel());
                    throw new IllegalArgumentException(sb.toString());
            }
        } else {
            if (c > 0) {
                z = true;
            }
            return z;
        }
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.mLayout.mo5135a(this, this.mState, view, view2) && view2 != null) {
            requestChildOnScreen(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    private void requestChildOnScreen(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.mTempRect.set(0, 0, view3.getWidth(), view3.getHeight());
        LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof C1259j) {
            C1259j jVar = (C1259j) layoutParams;
            if (!jVar.f3731e) {
                Rect rect = jVar.f3730d;
                this.mTempRect.left -= rect.left;
                this.mTempRect.right += rect.right;
                this.mTempRect.top -= rect.top;
                this.mTempRect.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.mTempRect);
            offsetRectIntoDescendantCoords(view, this.mTempRect);
        }
        this.mLayout.mo5133a(this, view, this.mTempRect, !this.mFirstLayoutComplete, view2 == null);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.mLayout.mo5132a(this, view, rect, z);
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (this.mLayout == null || !this.mLayout.mo5136a(this, arrayList, i, i2)) {
            super.addFocusables(arrayList, i, i2);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (isComputingLayout()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i, rect);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0051, code lost:
        if (r0 >= 30.0f) goto L_0x0056;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onAttachedToWindow() {
        /*
            r4 = this;
            super.onAttachedToWindow()
            r0 = 0
            r4.mLayoutOrScrollCounter = r0
            r1 = 1
            r4.mIsAttached = r1
            boolean r2 = r4.mFirstLayoutComplete
            if (r2 == 0) goto L_0x0014
            boolean r2 = r4.isLayoutRequested()
            if (r2 != 0) goto L_0x0014
            goto L_0x0015
        L_0x0014:
            r1 = 0
        L_0x0015:
            r4.mFirstLayoutComplete = r1
            androidx.recyclerview.widget.RecyclerView$i r1 = r4.mLayout
            if (r1 == 0) goto L_0x0020
            androidx.recyclerview.widget.RecyclerView$i r1 = r4.mLayout
            r1.mo5150c(r4)
        L_0x0020:
            r4.mPostedAnimatorRunner = r0
            boolean r0 = ALLOW_THREAD_GAP_WORK
            if (r0 == 0) goto L_0x006b
            java.lang.ThreadLocal<androidx.recyclerview.widget.e> r0 = androidx.recyclerview.widget.C1309e.f3949a
            java.lang.Object r0 = r0.get()
            androidx.recyclerview.widget.e r0 = (androidx.recyclerview.widget.C1309e) r0
            r4.mGapWorker = r0
            androidx.recyclerview.widget.e r0 = r4.mGapWorker
            if (r0 != 0) goto L_0x0066
            androidx.recyclerview.widget.e r0 = new androidx.recyclerview.widget.e
            r0.<init>()
            r4.mGapWorker = r0
            android.view.Display r0 = androidx.core.p070g.C0962r.m3545E(r4)
            r1 = 1114636288(0x42700000, float:60.0)
            boolean r2 = r4.isInEditMode()
            if (r2 != 0) goto L_0x0054
            if (r0 == 0) goto L_0x0054
            float r0 = r0.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x0054
            goto L_0x0056
        L_0x0054:
            r0 = 1114636288(0x42700000, float:60.0)
        L_0x0056:
            androidx.recyclerview.widget.e r1 = r4.mGapWorker
            r2 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r2 = r2 / r0
            long r2 = (long) r2
            r1.f3953d = r2
            java.lang.ThreadLocal<androidx.recyclerview.widget.e> r0 = androidx.recyclerview.widget.C1309e.f3949a
            androidx.recyclerview.widget.e r1 = r4.mGapWorker
            r0.set(r1)
        L_0x0066:
            androidx.recyclerview.widget.e r0 = r4.mGapWorker
            r0.mo5504a(r4)
        L_0x006b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onAttachedToWindow():void");
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mItemAnimator != null) {
            this.mItemAnimator.mo5077d();
        }
        stopScroll();
        this.mIsAttached = false;
        if (this.mLayout != null) {
            this.mLayout.mo5144b(this, this.mRecycler);
        }
        this.mPendingAccessibilityImportanceChange.clear();
        removeCallbacks(this.mItemAnimatorRunner);
        this.mViewInfoStore.mo5579b();
        if (ALLOW_THREAD_GAP_WORK && this.mGapWorker != null) {
            this.mGapWorker.mo5506b(this);
            this.mGapWorker = null;
        }
    }

    public boolean isAttachedToWindow() {
        return this.mIsAttached;
    }

    /* access modifiers changed from: 0000 */
    public void assertInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            return;
        }
        if (str == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot call this method unless RecyclerView is computing a layout or scrolling");
            sb.append(exceptionLabel());
            throw new IllegalStateException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(exceptionLabel());
        throw new IllegalStateException(sb2.toString());
    }

    /* access modifiers changed from: 0000 */
    public void assertNotInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            if (str == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Cannot call this method while RecyclerView is computing a layout or scrolling");
                sb.append(exceptionLabel());
                throw new IllegalStateException(sb.toString());
            }
            throw new IllegalStateException(str);
        } else if (this.mDispatchScrollCounter > 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("");
            sb2.append(exceptionLabel());
            Log.w(TAG, "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(sb2.toString()));
        }
    }

    public void addOnItemTouchListener(C1262m mVar) {
        this.mOnItemTouchListeners.add(mVar);
    }

    public void removeOnItemTouchListener(C1262m mVar) {
        this.mOnItemTouchListeners.remove(mVar);
        if (this.mActiveOnItemTouchListener == mVar) {
            this.mActiveOnItemTouchListener = null;
        }
    }

    private boolean dispatchOnItemTouchIntercept(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.mActiveOnItemTouchListener = null;
        }
        int size = this.mOnItemTouchListeners.size();
        int i = 0;
        while (i < size) {
            C1262m mVar = (C1262m) this.mOnItemTouchListeners.get(i);
            if (!mVar.mo5204a(this, motionEvent) || action == 3) {
                i++;
            } else {
                this.mActiveOnItemTouchListener = mVar;
                return true;
            }
        }
        return false;
    }

    private boolean dispatchOnItemTouch(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mActiveOnItemTouchListener != null) {
            if (action == 0) {
                this.mActiveOnItemTouchListener = null;
            } else {
                this.mActiveOnItemTouchListener.mo5205b(this, motionEvent);
                if (action == 3 || action == 1) {
                    this.mActiveOnItemTouchListener = null;
                }
                return true;
            }
        }
        if (action != 0) {
            int size = this.mOnItemTouchListeners.size();
            for (int i = 0; i < size; i++) {
                C1262m mVar = (C1262m) this.mOnItemTouchListeners.get(i);
                if (mVar.mo5204a(this, motionEvent)) {
                    this.mActiveOnItemTouchListener = mVar;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2 = false;
        if (this.mLayoutFrozen) {
            return false;
        }
        if (dispatchOnItemTouchIntercept(motionEvent)) {
            cancelTouch();
            return true;
        } else if (this.mLayout == null) {
            return false;
        } else {
            boolean e = this.mLayout.mo4781e();
            boolean f = this.mLayout.mo4784f();
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            int actionIndex = motionEvent.getActionIndex();
            switch (actionMasked) {
                case 0:
                    if (this.mIgnoreMotionEventTillDown) {
                        this.mIgnoreMotionEventTillDown = false;
                    }
                    this.mScrollPointerId = motionEvent.getPointerId(0);
                    int x = (int) (motionEvent.getX() + 0.5f);
                    this.mLastTouchX = x;
                    this.mInitialTouchX = x;
                    int y = (int) (motionEvent.getY() + 0.5f);
                    this.mLastTouchY = y;
                    this.mInitialTouchY = y;
                    if (this.mScrollState == 2) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                    }
                    int[] iArr = this.mNestedOffsets;
                    this.mNestedOffsets[1] = 0;
                    iArr[0] = 0;
                    int i = e ? 1 : 0;
                    if (f) {
                        i |= 2;
                    }
                    startNestedScroll(i, 0);
                    break;
                case 1:
                    this.mVelocityTracker.clear();
                    stopNestedScroll(0);
                    break;
                case 2:
                    int findPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
                    if (findPointerIndex >= 0) {
                        int x2 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
                        int y2 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
                        if (this.mScrollState != 1) {
                            int i2 = x2 - this.mInitialTouchX;
                            int i3 = y2 - this.mInitialTouchY;
                            if (!e || Math.abs(i2) <= this.mTouchSlop) {
                                z = false;
                            } else {
                                this.mLastTouchX = x2;
                                z = true;
                            }
                            if (f && Math.abs(i3) > this.mTouchSlop) {
                                this.mLastTouchY = y2;
                                z = true;
                            }
                            if (z) {
                                setScrollState(1);
                                break;
                            }
                        }
                    } else {
                        String str = TAG;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Error processing scroll; pointer index for id ");
                        sb.append(this.mScrollPointerId);
                        sb.append(" not found. Did any MotionEvents get skipped?");
                        Log.e(str, sb.toString());
                        return false;
                    }
                    break;
                case 3:
                    cancelTouch();
                    break;
                case 5:
                    this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
                    int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                    this.mLastTouchX = x3;
                    this.mInitialTouchX = x3;
                    int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                    this.mLastTouchY = y3;
                    this.mInitialTouchY = y3;
                    break;
                case 6:
                    onPointerUp(motionEvent);
                    break;
            }
            if (this.mScrollState == 1) {
                z2 = true;
            }
            return z2;
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.mOnItemTouchListeners.size();
        for (int i = 0; i < size; i++) {
            ((C1262m) this.mOnItemTouchListeners.get(i)).mo5203a(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        int i2;
        boolean z;
        boolean z2 = false;
        if (this.mLayoutFrozen || this.mIgnoreMotionEventTillDown) {
            return false;
        }
        if (dispatchOnItemTouch(motionEvent)) {
            cancelTouch();
            return true;
        } else if (this.mLayout == null) {
            return false;
        } else {
            boolean e = this.mLayout.mo4781e();
            boolean f = this.mLayout.mo4784f();
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            int actionIndex = motionEvent.getActionIndex();
            if (actionMasked == 0) {
                int[] iArr = this.mNestedOffsets;
                this.mNestedOffsets[1] = 0;
                iArr[0] = 0;
            }
            obtain.offsetLocation((float) this.mNestedOffsets[0], (float) this.mNestedOffsets[1]);
            switch (actionMasked) {
                case 0:
                    this.mScrollPointerId = motionEvent.getPointerId(0);
                    int x = (int) (motionEvent.getX() + 0.5f);
                    this.mLastTouchX = x;
                    this.mInitialTouchX = x;
                    int y = (int) (motionEvent.getY() + 0.5f);
                    this.mLastTouchY = y;
                    this.mInitialTouchY = y;
                    int i3 = e ? 1 : 0;
                    if (f) {
                        i3 |= 2;
                    }
                    startNestedScroll(i3, 0);
                    break;
                case 1:
                    this.mVelocityTracker.addMovement(obtain);
                    this.mVelocityTracker.computeCurrentVelocity(1000, (float) this.mMaxFlingVelocity);
                    float f2 = e ? -this.mVelocityTracker.getXVelocity(this.mScrollPointerId) : BitmapDescriptorFactory.HUE_RED;
                    float f3 = f ? -this.mVelocityTracker.getYVelocity(this.mScrollPointerId) : BitmapDescriptorFactory.HUE_RED;
                    if ((f2 == BitmapDescriptorFactory.HUE_RED && f3 == BitmapDescriptorFactory.HUE_RED) || !fling((int) f2, (int) f3)) {
                        setScrollState(0);
                    }
                    resetTouch();
                    z2 = true;
                    break;
                case 2:
                    int findPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
                    if (findPointerIndex >= 0) {
                        int x2 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
                        int y2 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
                        int i4 = this.mLastTouchX - x2;
                        int i5 = this.mLastTouchY - y2;
                        if (dispatchNestedPreScroll(i4, i5, this.mScrollConsumed, this.mScrollOffset, 0)) {
                            i4 -= this.mScrollConsumed[0];
                            i5 -= this.mScrollConsumed[1];
                            obtain.offsetLocation((float) this.mScrollOffset[0], (float) this.mScrollOffset[1]);
                            int[] iArr2 = this.mNestedOffsets;
                            iArr2[0] = iArr2[0] + this.mScrollOffset[0];
                            int[] iArr3 = this.mNestedOffsets;
                            iArr3[1] = iArr3[1] + this.mScrollOffset[1];
                        }
                        if (this.mScrollState != 1) {
                            if (!e || Math.abs(i2) <= this.mTouchSlop) {
                                z = false;
                            } else {
                                if (i2 > 0) {
                                    i2 -= this.mTouchSlop;
                                } else {
                                    i2 += this.mTouchSlop;
                                }
                                z = true;
                            }
                            if (f && Math.abs(i) > this.mTouchSlop) {
                                if (i > 0) {
                                    i -= this.mTouchSlop;
                                } else {
                                    i += this.mTouchSlop;
                                }
                                z = true;
                            }
                            if (z) {
                                setScrollState(1);
                            }
                        }
                        if (this.mScrollState == 1) {
                            this.mLastTouchX = x2 - this.mScrollOffset[0];
                            this.mLastTouchY = y2 - this.mScrollOffset[1];
                            if (scrollByInternal(e ? i2 : 0, f ? i : 0, obtain)) {
                                getParent().requestDisallowInterceptTouchEvent(true);
                            }
                            if (!(this.mGapWorker == null || (i2 == 0 && i == 0))) {
                                this.mGapWorker.mo5505a(this, i2, i);
                                break;
                            }
                        }
                    } else {
                        String str = TAG;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Error processing scroll; pointer index for id ");
                        sb.append(this.mScrollPointerId);
                        sb.append(" not found. Did any MotionEvents get skipped?");
                        Log.e(str, sb.toString());
                        return false;
                    }
                    break;
                case 3:
                    cancelTouch();
                    break;
                case 5:
                    this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
                    int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                    this.mLastTouchX = x3;
                    this.mInitialTouchX = x3;
                    int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                    this.mLastTouchY = y3;
                    this.mInitialTouchY = y3;
                    break;
                case 6:
                    onPointerUp(motionEvent);
                    break;
            }
            if (!z2) {
                this.mVelocityTracker.addMovement(obtain);
            }
            obtain.recycle();
            return true;
        }
    }

    private void resetTouch() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
        }
        stopNestedScroll(0);
        releaseGlows();
    }

    private void cancelTouch() {
        resetTouch();
        setScrollState(0);
    }

    private void onPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mScrollPointerId) {
            int i = actionIndex == 0 ? 1 : 0;
            this.mScrollPointerId = motionEvent.getPointerId(i);
            int x = (int) (motionEvent.getX(i) + 0.5f);
            this.mLastTouchX = x;
            this.mInitialTouchX = x;
            int y = (int) (motionEvent.getY(i) + 0.5f);
            this.mLastTouchY = y;
            this.mInitialTouchY = y;
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f;
        float f2;
        if (this.mLayout != null && !this.mLayoutFrozen && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                f2 = this.mLayout.mo4784f() ? -motionEvent.getAxisValue(9) : BitmapDescriptorFactory.HUE_RED;
                if (this.mLayout.mo4781e()) {
                    f = motionEvent.getAxisValue(10);
                    if (!(f2 == BitmapDescriptorFactory.HUE_RED && f == BitmapDescriptorFactory.HUE_RED)) {
                        scrollByInternal((int) (f * this.mScaledHorizontalScrollFactor), (int) (f2 * this.mScaledVerticalScrollFactor), motionEvent);
                    }
                }
            } else {
                if ((motionEvent.getSource() & 4194304) != 0) {
                    float axisValue = motionEvent.getAxisValue(26);
                    if (this.mLayout.mo4784f()) {
                        f2 = -axisValue;
                    } else if (this.mLayout.mo4781e()) {
                        f = axisValue;
                        f2 = BitmapDescriptorFactory.HUE_RED;
                        scrollByInternal((int) (f * this.mScaledHorizontalScrollFactor), (int) (f2 * this.mScaledVerticalScrollFactor), motionEvent);
                    }
                }
                f2 = BitmapDescriptorFactory.HUE_RED;
            }
            f = BitmapDescriptorFactory.HUE_RED;
            scrollByInternal((int) (f * this.mScaledHorizontalScrollFactor), (int) (f2 * this.mScaledVerticalScrollFactor), motionEvent);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.mLayout == null) {
            defaultOnMeasure(i, i2);
            return;
        }
        boolean z = false;
        if (this.mLayout.mo4775c()) {
            int mode = MeasureSpec.getMode(i);
            int mode2 = MeasureSpec.getMode(i2);
            this.mLayout.mo5122a(this.mRecycler, this.mState, i, i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            if (!z && this.mAdapter != null) {
                if (this.mState.f3768d == 1) {
                    dispatchLayoutStep1();
                }
                this.mLayout.mo5146c(i, i2);
                this.mState.f3773i = true;
                dispatchLayoutStep2();
                this.mLayout.mo5155d(i, i2);
                if (this.mLayout.mo4792l()) {
                    this.mLayout.mo5146c(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), Ints.MAX_POWER_OF_TWO), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), Ints.MAX_POWER_OF_TWO));
                    this.mState.f3773i = true;
                    dispatchLayoutStep2();
                    this.mLayout.mo5155d(i, i2);
                }
            }
        } else if (this.mHasFixedSize) {
            this.mLayout.mo5122a(this.mRecycler, this.mState, i, i2);
        } else {
            if (this.mAdapterUpdateDuringMeasure) {
                startInterceptRequestLayout();
                onEnterLayoutOrScroll();
                processAdapterUpdatesAndSetAnimationFlags();
                onExitLayoutOrScroll();
                if (this.mState.f3775k) {
                    this.mState.f3771g = true;
                } else {
                    this.mAdapterHelper.mo5434e();
                    this.mState.f3771g = false;
                }
                this.mAdapterUpdateDuringMeasure = false;
                stopInterceptRequestLayout(false);
            } else if (this.mState.f3775k) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            if (this.mAdapter != null) {
                this.mState.f3769e = this.mAdapter.getItemCount();
            } else {
                this.mState.f3769e = 0;
            }
            startInterceptRequestLayout();
            this.mLayout.mo5122a(this.mRecycler, this.mState, i, i2);
            stopInterceptRequestLayout(false);
            this.mState.f3771g = false;
        }
    }

    /* access modifiers changed from: 0000 */
    public void defaultOnMeasure(int i, int i2) {
        setMeasuredDimension(C1254i.m4782a(i, getPaddingLeft() + getPaddingRight(), C0962r.m3589l(this)), C1254i.m4782a(i2, getPaddingTop() + getPaddingBottom(), C0962r.m3590m(this)));
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            invalidateGlows();
        }
    }

    public void setItemAnimator(C1248f fVar) {
        if (this.mItemAnimator != null) {
            this.mItemAnimator.mo5077d();
            this.mItemAnimator.mo5070a(null);
        }
        this.mItemAnimator = fVar;
        if (this.mItemAnimator != null) {
            this.mItemAnimator.mo5070a(this.mItemAnimatorListener);
        }
    }

    /* access modifiers changed from: 0000 */
    public void onEnterLayoutOrScroll() {
        this.mLayoutOrScrollCounter++;
    }

    /* access modifiers changed from: 0000 */
    public void onExitLayoutOrScroll() {
        onExitLayoutOrScroll(true);
    }

    /* access modifiers changed from: 0000 */
    public void onExitLayoutOrScroll(boolean z) {
        this.mLayoutOrScrollCounter--;
        if (this.mLayoutOrScrollCounter < 1) {
            this.mLayoutOrScrollCounter = 0;
            if (z) {
                dispatchContentChangedIfNecessary();
                dispatchPendingImportantForAccessibilityChanges();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean isAccessibilityEnabled() {
        return this.mAccessibilityManager != null && this.mAccessibilityManager.isEnabled();
    }

    private void dispatchContentChangedIfNecessary() {
        int i = this.mEatenAccessibilityChangeFlags;
        this.mEatenAccessibilityChangeFlags = 0;
        if (i != 0 && isAccessibilityEnabled()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(2048);
            C0934a.m3412a(obtain, i);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    public boolean isComputingLayout() {
        return this.mLayoutOrScrollCounter > 0;
    }

    /* access modifiers changed from: 0000 */
    public boolean shouldDeferAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (!isComputingLayout()) {
            return false;
        }
        int a = accessibilityEvent != null ? C0934a.m3411a(accessibilityEvent) : 0;
        if (a == 0) {
            a = 0;
        }
        this.mEatenAccessibilityChangeFlags = a | this.mEatenAccessibilityChangeFlags;
        return true;
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!shouldDeferAccessibilityEvent(accessibilityEvent)) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public C1248f getItemAnimator() {
        return this.mItemAnimator;
    }

    /* access modifiers changed from: 0000 */
    public void postAnimationRunner() {
        if (!this.mPostedAnimatorRunner && this.mIsAttached) {
            C0962r.m3562a((View) this, this.mItemAnimatorRunner);
            this.mPostedAnimatorRunner = true;
        }
    }

    private boolean predictiveItemAnimationsEnabled() {
        return this.mItemAnimator != null && this.mLayout.mo4749b();
    }

    private void processAdapterUpdatesAndSetAnimationFlags() {
        if (this.mDataSetHasChangedAfterLayout) {
            this.mAdapterHelper.mo5420a();
            if (this.mDispatchItemsChangedEvent) {
                this.mLayout.mo4740a(this);
            }
        }
        if (predictiveItemAnimationsEnabled()) {
            this.mAdapterHelper.mo5428b();
        } else {
            this.mAdapterHelper.mo5434e();
        }
        boolean z = false;
        boolean z2 = this.mItemsAddedOrRemoved || this.mItemsChanged;
        this.mState.f3774j = this.mFirstLayoutComplete && this.mItemAnimator != null && (this.mDataSetHasChangedAfterLayout || z2 || this.mLayout.f3718u) && (!this.mDataSetHasChangedAfterLayout || this.mAdapter.hasStableIds());
        C1274u uVar = this.mState;
        if (this.mState.f3774j && z2 && !this.mDataSetHasChangedAfterLayout && predictiveItemAnimationsEnabled()) {
            z = true;
        }
        uVar.f3775k = z;
    }

    /* access modifiers changed from: 0000 */
    public void dispatchLayout() {
        if (this.mAdapter == null) {
            Log.e(TAG, "No adapter attached; skipping layout");
        } else if (this.mLayout == null) {
            Log.e(TAG, "No layout manager attached; skipping layout");
        } else {
            this.mState.f3773i = false;
            if (this.mState.f3768d == 1) {
                dispatchLayoutStep1();
                this.mLayout.mo5163f(this);
                dispatchLayoutStep2();
            } else if (!this.mAdapterHelper.mo5435f() && this.mLayout.mo5189z() == getWidth() && this.mLayout.mo5098A() == getHeight()) {
                this.mLayout.mo5163f(this);
            } else {
                this.mLayout.mo5163f(this);
                dispatchLayoutStep2();
            }
            dispatchLayoutStep3();
        }
    }

    private void saveFocusInfo() {
        int i;
        C1277x xVar = null;
        View focusedChild = (!this.mPreserveFocusAfterLayout || !hasFocus() || this.mAdapter == null) ? null : getFocusedChild();
        if (focusedChild != null) {
            xVar = findContainingViewHolder(focusedChild);
        }
        if (xVar == null) {
            resetFocusInfo();
            return;
        }
        this.mState.f3777m = this.mAdapter.hasStableIds() ? xVar.getItemId() : -1;
        C1274u uVar = this.mState;
        if (this.mDataSetHasChangedAfterLayout) {
            i = -1;
        } else if (xVar.isRemoved()) {
            i = xVar.mOldPosition;
        } else {
            i = xVar.getAdapterPosition();
        }
        uVar.f3776l = i;
        this.mState.f3778n = getDeepestFocusedViewWithId(xVar.itemView);
    }

    private void resetFocusInfo() {
        this.mState.f3777m = -1;
        this.mState.f3776l = -1;
        this.mState.f3778n = -1;
    }

    private View findNextViewToFocus() {
        int i = this.mState.f3776l != -1 ? this.mState.f3776l : 0;
        int e = this.mState.mo5291e();
        int i2 = i;
        while (i2 < e) {
            C1277x findViewHolderForAdapterPosition = findViewHolderForAdapterPosition(i2);
            if (findViewHolderForAdapterPosition == null) {
                break;
            } else if (findViewHolderForAdapterPosition.itemView.hasFocusable()) {
                return findViewHolderForAdapterPosition.itemView;
            } else {
                i2++;
            }
        }
        int min = Math.min(e, i);
        while (true) {
            min--;
            if (min < 0) {
                return null;
            }
            C1277x findViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(min);
            if (findViewHolderForAdapterPosition2 == null) {
                return null;
            }
            if (findViewHolderForAdapterPosition2.itemView.hasFocusable()) {
                return findViewHolderForAdapterPosition2.itemView;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00af, code lost:
        if (r0.isFocusable() != false) goto L_0x00b3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void recoverFocusFromState() {
        /*
            r6 = this;
            boolean r0 = r6.mPreserveFocusAfterLayout
            if (r0 == 0) goto L_0x00b7
            androidx.recyclerview.widget.RecyclerView$a r0 = r6.mAdapter
            if (r0 == 0) goto L_0x00b7
            boolean r0 = r6.hasFocus()
            if (r0 == 0) goto L_0x00b7
            int r0 = r6.getDescendantFocusability()
            r1 = 393216(0x60000, float:5.51013E-40)
            if (r0 == r1) goto L_0x00b7
            int r0 = r6.getDescendantFocusability()
            r1 = 131072(0x20000, float:1.83671E-40)
            if (r0 != r1) goto L_0x0026
            boolean r0 = r6.isFocused()
            if (r0 == 0) goto L_0x0026
            goto L_0x00b7
        L_0x0026:
            boolean r0 = r6.isFocused()
            if (r0 != 0) goto L_0x0055
            android.view.View r0 = r6.getFocusedChild()
            boolean r1 = IGNORE_DETACHED_FOCUSED_CHILD
            if (r1 == 0) goto L_0x004c
            android.view.ViewParent r1 = r0.getParent()
            if (r1 == 0) goto L_0x0040
            boolean r1 = r0.hasFocus()
            if (r1 != 0) goto L_0x004c
        L_0x0040:
            androidx.recyclerview.widget.b r0 = r6.mChildHelper
            int r0 = r0.mo5446b()
            if (r0 != 0) goto L_0x0055
            r6.requestFocus()
            return
        L_0x004c:
            androidx.recyclerview.widget.b r1 = r6.mChildHelper
            boolean r0 = r1.mo5451c(r0)
            if (r0 != 0) goto L_0x0055
            return
        L_0x0055:
            androidx.recyclerview.widget.RecyclerView$u r0 = r6.mState
            long r0 = r0.f3777m
            r2 = -1
            r4 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x0071
            androidx.recyclerview.widget.RecyclerView$a r0 = r6.mAdapter
            boolean r0 = r0.hasStableIds()
            if (r0 == 0) goto L_0x0071
            androidx.recyclerview.widget.RecyclerView$u r0 = r6.mState
            long r0 = r0.f3777m
            androidx.recyclerview.widget.RecyclerView$x r0 = r6.findViewHolderForItemId(r0)
            goto L_0x0072
        L_0x0071:
            r0 = r4
        L_0x0072:
            if (r0 == 0) goto L_0x008a
            androidx.recyclerview.widget.b r1 = r6.mChildHelper
            android.view.View r5 = r0.itemView
            boolean r1 = r1.mo5451c(r5)
            if (r1 != 0) goto L_0x008a
            android.view.View r1 = r0.itemView
            boolean r1 = r1.hasFocusable()
            if (r1 != 0) goto L_0x0087
            goto L_0x008a
        L_0x0087:
            android.view.View r4 = r0.itemView
            goto L_0x0096
        L_0x008a:
            androidx.recyclerview.widget.b r0 = r6.mChildHelper
            int r0 = r0.mo5446b()
            if (r0 <= 0) goto L_0x0096
            android.view.View r4 = r6.findNextViewToFocus()
        L_0x0096:
            if (r4 == 0) goto L_0x00b6
            androidx.recyclerview.widget.RecyclerView$u r0 = r6.mState
            int r0 = r0.f3778n
            long r0 = (long) r0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x00b2
            androidx.recyclerview.widget.RecyclerView$u r0 = r6.mState
            int r0 = r0.f3778n
            android.view.View r0 = r4.findViewById(r0)
            if (r0 == 0) goto L_0x00b2
            boolean r1 = r0.isFocusable()
            if (r1 == 0) goto L_0x00b2
            goto L_0x00b3
        L_0x00b2:
            r0 = r4
        L_0x00b3:
            r0.requestFocus()
        L_0x00b6:
            return
        L_0x00b7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.recoverFocusFromState():void");
    }

    private int getDeepestFocusedViewWithId(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    /* access modifiers changed from: 0000 */
    public final void fillRemainingScrollValues(C1274u uVar) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.mViewFlinger.f3782a;
            uVar.f3779o = overScroller.getFinalX() - overScroller.getCurrX();
            uVar.f3780p = overScroller.getFinalY() - overScroller.getCurrY();
            return;
        }
        uVar.f3779o = 0;
        uVar.f3780p = 0;
    }

    private void dispatchLayoutStep1() {
        boolean z = true;
        this.mState.mo5285a(1);
        fillRemainingScrollValues(this.mState);
        this.mState.f3773i = false;
        startInterceptRequestLayout();
        this.mViewInfoStore.mo5573a();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        saveFocusInfo();
        C1274u uVar = this.mState;
        if (!this.mState.f3774j || !this.mItemsChanged) {
            z = false;
        }
        uVar.f3772h = z;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        this.mState.f3771g = this.mState.f3775k;
        this.mState.f3769e = this.mAdapter.getItemCount();
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        if (this.mState.f3774j) {
            int b = this.mChildHelper.mo5446b();
            for (int i = 0; i < b; i++) {
                C1277x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.mo5448b(i));
                if (!childViewHolderInt.shouldIgnore() && (!childViewHolderInt.isInvalid() || this.mAdapter.hasStableIds())) {
                    this.mViewInfoStore.mo5575a(childViewHolderInt, this.mItemAnimator.mo5068a(this.mState, childViewHolderInt, C1248f.m4749e(childViewHolderInt), childViewHolderInt.getUnmodifiedPayloads()));
                    if (this.mState.f3772h && childViewHolderInt.isUpdated() && !childViewHolderInt.isRemoved() && !childViewHolderInt.shouldIgnore() && !childViewHolderInt.isInvalid()) {
                        this.mViewInfoStore.mo5574a(getChangedHolderKey(childViewHolderInt), childViewHolderInt);
                    }
                }
            }
        }
        if (this.mState.f3775k) {
            saveOldPositions();
            boolean z2 = this.mState.f3770f;
            this.mState.f3770f = false;
            this.mLayout.mo4750c(this.mRecycler, this.mState);
            this.mState.f3770f = z2;
            for (int i2 = 0; i2 < this.mChildHelper.mo5446b(); i2++) {
                C1277x childViewHolderInt2 = getChildViewHolderInt(this.mChildHelper.mo5448b(i2));
                if (!childViewHolderInt2.shouldIgnore() && !this.mViewInfoStore.mo5583d(childViewHolderInt2)) {
                    int e = C1248f.m4749e(childViewHolderInt2);
                    boolean hasAnyOfTheFlags = childViewHolderInt2.hasAnyOfTheFlags(8192);
                    if (!hasAnyOfTheFlags) {
                        e |= 4096;
                    }
                    C1251c a = this.mItemAnimator.mo5068a(this.mState, childViewHolderInt2, e, childViewHolderInt2.getUnmodifiedPayloads());
                    if (hasAnyOfTheFlags) {
                        recordAnimationInfoIfBouncedHiddenView(childViewHolderInt2, a);
                    } else {
                        this.mViewInfoStore.mo5580b(childViewHolderInt2, a);
                    }
                }
            }
            clearOldPositions();
        } else {
            clearOldPositions();
        }
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mState.f3768d = 2;
    }

    private void dispatchLayoutStep2() {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.mo5285a(6);
        this.mAdapterHelper.mo5434e();
        this.mState.f3769e = this.mAdapter.getItemCount();
        this.mState.f3767c = 0;
        this.mState.f3771g = false;
        this.mLayout.mo4750c(this.mRecycler, this.mState);
        this.mState.f3770f = false;
        this.mPendingSavedState = null;
        this.mState.f3774j = this.mState.f3774j && this.mItemAnimator != null;
        this.mState.f3768d = 4;
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
    }

    private void dispatchLayoutStep3() {
        this.mState.mo5285a(4);
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.f3768d = 1;
        if (this.mState.f3774j) {
            for (int b = this.mChildHelper.mo5446b() - 1; b >= 0; b--) {
                C1277x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.mo5448b(b));
                if (!childViewHolderInt.shouldIgnore()) {
                    long changedHolderKey = getChangedHolderKey(childViewHolderInt);
                    C1251c a = this.mItemAnimator.mo5067a(this.mState, childViewHolderInt);
                    C1277x a2 = this.mViewInfoStore.mo5572a(changedHolderKey);
                    if (a2 == null || a2.shouldIgnore()) {
                        this.mViewInfoStore.mo5582c(childViewHolderInt, a);
                    } else {
                        boolean a3 = this.mViewInfoStore.mo5577a(a2);
                        boolean a4 = this.mViewInfoStore.mo5577a(childViewHolderInt);
                        if (!a3 || a2 != childViewHolderInt) {
                            C1251c b2 = this.mViewInfoStore.mo5578b(a2);
                            this.mViewInfoStore.mo5582c(childViewHolderInt, a);
                            C1251c c = this.mViewInfoStore.mo5581c(childViewHolderInt);
                            if (b2 == null) {
                                handleMissingPreInfoForChangeError(changedHolderKey, childViewHolderInt, a2);
                            } else {
                                animateChange(a2, childViewHolderInt, b2, c, a3, a4);
                            }
                        } else {
                            this.mViewInfoStore.mo5582c(childViewHolderInt, a);
                        }
                    }
                }
            }
            this.mViewInfoStore.mo5576a(this.mViewInfoProcessCallback);
        }
        this.mLayout.mo5141b(this.mRecycler);
        this.mState.f3766b = this.mState.f3769e;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mState.f3774j = false;
        this.mState.f3775k = false;
        this.mLayout.f3718u = false;
        if (this.mRecycler.f3740b != null) {
            this.mRecycler.f3740b.clear();
        }
        if (this.mLayout.f3722y) {
            this.mLayout.f3721x = 0;
            this.mLayout.f3722y = false;
            this.mRecycler.mo5234b();
        }
        this.mLayout.mo4738a(this.mState);
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mViewInfoStore.mo5573a();
        if (didChildRangeChange(this.mMinMaxLayoutPositions[0], this.mMinMaxLayoutPositions[1])) {
            dispatchOnScrolled(0, 0);
        }
        recoverFocusFromState();
        resetFocusInfo();
    }

    private void handleMissingPreInfoForChangeError(long j, C1277x xVar, C1277x xVar2) {
        int b = this.mChildHelper.mo5446b();
        int i = 0;
        while (i < b) {
            C1277x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.mo5448b(i));
            if (childViewHolderInt == xVar || getChangedHolderKey(childViewHolderInt) != j) {
                i++;
            } else if (this.mAdapter == null || !this.mAdapter.hasStableIds()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:");
                sb.append(childViewHolderInt);
                sb.append(" \n View Holder 2:");
                sb.append(xVar);
                sb.append(exceptionLabel());
                throw new IllegalStateException(sb.toString());
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:");
                sb2.append(childViewHolderInt);
                sb2.append(" \n View Holder 2:");
                sb2.append(xVar);
                sb2.append(exceptionLabel());
                throw new IllegalStateException(sb2.toString());
            }
        }
        String str = TAG;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Problem while matching changed view holders with the newones. The pre-layout information for the change holder ");
        sb3.append(xVar2);
        sb3.append(" cannot be found but it is necessary for ");
        sb3.append(xVar);
        sb3.append(exceptionLabel());
        Log.e(str, sb3.toString());
    }

    /* access modifiers changed from: 0000 */
    public void recordAnimationInfoIfBouncedHiddenView(C1277x xVar, C1251c cVar) {
        xVar.setFlags(0, 8192);
        if (this.mState.f3772h && xVar.isUpdated() && !xVar.isRemoved() && !xVar.shouldIgnore()) {
            this.mViewInfoStore.mo5574a(getChangedHolderKey(xVar), xVar);
        }
        this.mViewInfoStore.mo5575a(xVar, cVar);
    }

    private void findMinMaxChildLayoutPositions(int[] iArr) {
        int b = this.mChildHelper.mo5446b();
        if (b == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i = BaseClientBuilder.API_PRIORITY_OTHER;
        int i2 = C1024a.INVALID_ID;
        for (int i3 = 0; i3 < b; i3++) {
            C1277x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.mo5448b(i3));
            if (!childViewHolderInt.shouldIgnore()) {
                int layoutPosition = childViewHolderInt.getLayoutPosition();
                if (layoutPosition < i) {
                    i = layoutPosition;
                }
                if (layoutPosition > i2) {
                    i2 = layoutPosition;
                }
            }
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    private boolean didChildRangeChange(int i, int i2) {
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        return (this.mMinMaxLayoutPositions[0] == i && this.mMinMaxLayoutPositions[1] == i2) ? false : true;
    }

    /* access modifiers changed from: protected */
    public void removeDetachedView(View view, boolean z) {
        C1277x childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (childViewHolderInt.isTmpDetached()) {
                childViewHolderInt.clearTmpDetachFlag();
            } else if (!childViewHolderInt.shouldIgnore()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Called removeDetachedView with a view which is not flagged as tmp detached.");
                sb.append(childViewHolderInt);
                sb.append(exceptionLabel());
                throw new IllegalArgumentException(sb.toString());
            }
        }
        view.clearAnimation();
        dispatchChildDetached(view);
        super.removeDetachedView(view, z);
    }

    /* access modifiers changed from: 0000 */
    public long getChangedHolderKey(C1277x xVar) {
        return this.mAdapter.hasStableIds() ? xVar.getItemId() : (long) xVar.mPosition;
    }

    /* access modifiers changed from: 0000 */
    public void animateAppearance(C1277x xVar, C1251c cVar, C1251c cVar2) {
        xVar.setIsRecyclable(false);
        if (this.mItemAnimator.mo5075b(xVar, cVar, cVar2)) {
            postAnimationRunner();
        }
    }

    /* access modifiers changed from: 0000 */
    public void animateDisappearance(C1277x xVar, C1251c cVar, C1251c cVar2) {
        addAnimatingView(xVar);
        xVar.setIsRecyclable(false);
        if (this.mItemAnimator.mo5071a(xVar, cVar, cVar2)) {
            postAnimationRunner();
        }
    }

    private void animateChange(C1277x xVar, C1277x xVar2, C1251c cVar, C1251c cVar2, boolean z, boolean z2) {
        xVar.setIsRecyclable(false);
        if (z) {
            addAnimatingView(xVar);
        }
        if (xVar != xVar2) {
            if (z2) {
                addAnimatingView(xVar2);
            }
            xVar.mShadowedHolder = xVar2;
            addAnimatingView(xVar);
            this.mRecycler.mo5242c(xVar);
            xVar2.setIsRecyclable(false);
            xVar2.mShadowingHolder = xVar;
        }
        if (this.mItemAnimator.mo5072a(xVar, xVar2, cVar, cVar2)) {
            postAnimationRunner();
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        C0872b.m3226a(TRACE_ON_LAYOUT_TAG);
        dispatchLayout();
        C0872b.m3225a();
        this.mFirstLayoutComplete = true;
    }

    public void requestLayout() {
        if (this.mInterceptRequestLayoutDepth != 0 || this.mLayoutFrozen) {
            this.mLayoutWasDefered = true;
        } else {
            super.requestLayout();
        }
    }

    /* access modifiers changed from: 0000 */
    public void markItemDecorInsetsDirty() {
        int c = this.mChildHelper.mo5449c();
        for (int i = 0; i < c; i++) {
            ((C1259j) this.mChildHelper.mo5452d(i).getLayoutParams()).f3731e = true;
        }
        this.mRecycler.mo5253j();
    }

    public void draw(Canvas canvas) {
        boolean z;
        boolean z2;
        super.draw(canvas);
        int size = this.mItemDecorations.size();
        boolean z3 = false;
        for (int i = 0; i < size; i++) {
            ((C1253h) this.mItemDecorations.get(i)).mo5093a(canvas, this, this.mState);
        }
        if (this.mLeftGlow == null || this.mLeftGlow.isFinished()) {
            z = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.mClipToPadding ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((float) ((-getHeight()) + paddingBottom), BitmapDescriptorFactory.HUE_RED);
            z = this.mLeftGlow != null && this.mLeftGlow.draw(canvas);
            canvas.restoreToCount(save);
        }
        if (this.mTopGlow != null && !this.mTopGlow.isFinished()) {
            int save2 = canvas.save();
            if (this.mClipToPadding) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            z |= this.mTopGlow != null && this.mTopGlow.draw(canvas);
            canvas.restoreToCount(save2);
        }
        if (this.mRightGlow != null && !this.mRightGlow.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.mClipToPadding ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate((float) (-paddingTop), (float) (-width));
            z |= this.mRightGlow != null && this.mRightGlow.draw(canvas);
            canvas.restoreToCount(save3);
        }
        if (this.mBottomGlow == null || this.mBottomGlow.isFinished()) {
            z2 = z;
        } else {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.mClipToPadding) {
                canvas.translate((float) ((-getWidth()) + getPaddingRight()), (float) ((-getHeight()) + getPaddingBottom()));
            } else {
                canvas.translate((float) (-getWidth()), (float) (-getHeight()));
            }
            if (this.mBottomGlow != null && this.mBottomGlow.draw(canvas)) {
                z3 = true;
            }
            z2 = z3 | z;
            canvas.restoreToCount(save4);
        }
        if (!z2 && this.mItemAnimator != null && this.mItemDecorations.size() > 0 && this.mItemAnimator.mo5074b()) {
            z2 = true;
        }
        if (z2) {
            C0962r.m3575d(this);
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.mItemDecorations.size();
        for (int i = 0; i < size; i++) {
            ((C1253h) this.mItemDecorations.get(i)).mo5097b(canvas, this, this.mState);
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof C1259j) && this.mLayout.mo4745a((C1259j) layoutParams);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        if (this.mLayout != null) {
            return this.mLayout.mo4730a();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("RecyclerView has no LayoutManager");
        sb.append(exceptionLabel());
        throw new IllegalStateException(sb.toString());
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        if (this.mLayout != null) {
            return this.mLayout.mo4731a(getContext(), attributeSet);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("RecyclerView has no LayoutManager");
        sb.append(exceptionLabel());
        throw new IllegalStateException(sb.toString());
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        if (this.mLayout != null) {
            return this.mLayout.mo4732a(layoutParams);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("RecyclerView has no LayoutManager");
        sb.append(exceptionLabel());
        throw new IllegalStateException(sb.toString());
    }

    public boolean isAnimating() {
        return this.mItemAnimator != null && this.mItemAnimator.mo5074b();
    }

    /* access modifiers changed from: 0000 */
    public void saveOldPositions() {
        int c = this.mChildHelper.mo5449c();
        for (int i = 0; i < c; i++) {
            C1277x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.mo5452d(i));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.saveOldPosition();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void clearOldPositions() {
        int c = this.mChildHelper.mo5449c();
        for (int i = 0; i < c; i++) {
            C1277x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.mo5452d(i));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.clearOldPosition();
            }
        }
        this.mRecycler.mo5252i();
    }

    /* access modifiers changed from: 0000 */
    public void offsetPositionRecordsForMove(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int c = this.mChildHelper.mo5449c();
        if (i < i2) {
            i5 = i;
            i4 = i2;
            i3 = -1;
        } else {
            i4 = i;
            i5 = i2;
            i3 = 1;
        }
        for (int i6 = 0; i6 < c; i6++) {
            C1277x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.mo5452d(i6));
            if (childViewHolderInt != null && childViewHolderInt.mPosition >= i5 && childViewHolderInt.mPosition <= i4) {
                if (childViewHolderInt.mPosition == i) {
                    childViewHolderInt.offsetPosition(i2 - i, false);
                } else {
                    childViewHolderInt.offsetPosition(i3, false);
                }
                this.mState.f3770f = true;
            }
        }
        this.mRecycler.mo5224a(i, i2);
        requestLayout();
    }

    /* access modifiers changed from: 0000 */
    public void offsetPositionRecordsForInsert(int i, int i2) {
        int c = this.mChildHelper.mo5449c();
        for (int i3 = 0; i3 < c; i3++) {
            C1277x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.mo5452d(i3));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= i) {
                childViewHolderInt.offsetPosition(i2, false);
                this.mState.f3770f = true;
            }
        }
        this.mRecycler.mo5235b(i, i2);
        requestLayout();
    }

    /* access modifiers changed from: 0000 */
    public void offsetPositionRecordsForRemove(int i, int i2, boolean z) {
        int i3 = i + i2;
        int c = this.mChildHelper.mo5449c();
        for (int i4 = 0; i4 < c; i4++) {
            C1277x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.mo5452d(i4));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                if (childViewHolderInt.mPosition >= i3) {
                    childViewHolderInt.offsetPosition(-i2, z);
                    this.mState.f3770f = true;
                } else if (childViewHolderInt.mPosition >= i) {
                    childViewHolderInt.flagRemovedAndOffsetPosition(i - 1, -i2, z);
                    this.mState.f3770f = true;
                }
            }
        }
        this.mRecycler.mo5225a(i, i2, z);
        requestLayout();
    }

    /* access modifiers changed from: 0000 */
    public void viewRangeUpdate(int i, int i2, Object obj) {
        int c = this.mChildHelper.mo5449c();
        int i3 = i + i2;
        for (int i4 = 0; i4 < c; i4++) {
            View d = this.mChildHelper.mo5452d(i4);
            C1277x childViewHolderInt = getChildViewHolderInt(d);
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= i && childViewHolderInt.mPosition < i3) {
                childViewHolderInt.addFlags(2);
                childViewHolderInt.addChangePayload(obj);
                ((C1259j) d.getLayoutParams()).f3731e = true;
            }
        }
        this.mRecycler.mo5240c(i, i2);
    }

    /* access modifiers changed from: 0000 */
    public boolean canReuseUpdatedViewHolder(C1277x xVar) {
        return this.mItemAnimator == null || this.mItemAnimator.mo5073a(xVar, xVar.getUnmodifiedPayloads());
    }

    /* access modifiers changed from: 0000 */
    public void processDataSetCompletelyChanged(boolean z) {
        this.mDispatchItemsChangedEvent = z | this.mDispatchItemsChangedEvent;
        this.mDataSetHasChangedAfterLayout = true;
        markKnownViewsInvalid();
    }

    /* access modifiers changed from: 0000 */
    public void markKnownViewsInvalid() {
        int c = this.mChildHelper.mo5449c();
        for (int i = 0; i < c; i++) {
            C1277x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.mo5452d(i));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.addFlags(6);
            }
        }
        markItemDecorInsetsDirty();
        this.mRecycler.mo5251h();
    }

    public void invalidateItemDecorations() {
        if (this.mItemDecorations.size() != 0) {
            if (this.mLayout != null) {
                this.mLayout.mo4767a("Cannot invalidate item decorations during a scroll or layout");
            }
            markItemDecorInsetsDirty();
            requestLayout();
        }
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.mPreserveFocusAfterLayout;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.mPreserveFocusAfterLayout = z;
    }

    public C1277x getChildViewHolder(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return getChildViewHolderInt(view);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("View ");
        sb.append(view);
        sb.append(" is not a direct child of ");
        sb.append(this);
        throw new IllegalArgumentException(sb.toString());
    }

    public View findContainingItemView(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = (View) parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    public C1277x findContainingViewHolder(View view) {
        View findContainingItemView = findContainingItemView(view);
        if (findContainingItemView == null) {
            return null;
        }
        return getChildViewHolder(findContainingItemView);
    }

    static C1277x getChildViewHolderInt(View view) {
        if (view == null) {
            return null;
        }
        return ((C1259j) view.getLayoutParams()).f3729c;
    }

    @Deprecated
    public int getChildPosition(View view) {
        return getChildAdapterPosition(view);
    }

    public int getChildAdapterPosition(View view) {
        C1277x childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getAdapterPosition();
        }
        return -1;
    }

    public int getChildLayoutPosition(View view) {
        C1277x childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getLayoutPosition();
        }
        return -1;
    }

    public long getChildItemId(View view) {
        long j = -1;
        if (this.mAdapter == null || !this.mAdapter.hasStableIds()) {
            return -1;
        }
        C1277x childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            j = childViewHolderInt.getItemId();
        }
        return j;
    }

    @Deprecated
    public C1277x findViewHolderForPosition(int i) {
        return findViewHolderForPosition(i, false);
    }

    public C1277x findViewHolderForLayoutPosition(int i) {
        return findViewHolderForPosition(i, false);
    }

    public C1277x findViewHolderForAdapterPosition(int i) {
        C1277x xVar = null;
        if (this.mDataSetHasChangedAfterLayout) {
            return null;
        }
        int c = this.mChildHelper.mo5449c();
        for (int i2 = 0; i2 < c; i2++) {
            C1277x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.mo5452d(i2));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && getAdapterPositionFor(childViewHolderInt) == i) {
                if (!this.mChildHelper.mo5451c(childViewHolderInt.itemView)) {
                    return childViewHolderInt;
                }
                xVar = childViewHolderInt;
            }
        }
        return xVar;
    }

    /* access modifiers changed from: 0000 */
    public C1277x findViewHolderForPosition(int i, boolean z) {
        int c = this.mChildHelper.mo5449c();
        C1277x xVar = null;
        for (int i2 = 0; i2 < c; i2++) {
            C1277x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.mo5452d(i2));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved()) {
                if (z) {
                    if (childViewHolderInt.mPosition != i) {
                        continue;
                    }
                } else if (childViewHolderInt.getLayoutPosition() != i) {
                    continue;
                }
                if (!this.mChildHelper.mo5451c(childViewHolderInt.itemView)) {
                    return childViewHolderInt;
                }
                xVar = childViewHolderInt;
            }
        }
        return xVar;
    }

    public C1277x findViewHolderForItemId(long j) {
        C1277x xVar = null;
        if (this.mAdapter == null || !this.mAdapter.hasStableIds()) {
            return null;
        }
        int c = this.mChildHelper.mo5449c();
        for (int i = 0; i < c; i++) {
            C1277x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.mo5452d(i));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && childViewHolderInt.getItemId() == j) {
                if (!this.mChildHelper.mo5451c(childViewHolderInt.itemView)) {
                    return childViewHolderInt;
                }
                xVar = childViewHolderInt;
            }
        }
        return xVar;
    }

    public View findChildViewUnder(float f, float f2) {
        for (int b = this.mChildHelper.mo5446b() - 1; b >= 0; b--) {
            View b2 = this.mChildHelper.mo5448b(b);
            float translationX = b2.getTranslationX();
            float translationY = b2.getTranslationY();
            if (f >= ((float) b2.getLeft()) + translationX && f <= ((float) b2.getRight()) + translationX && f2 >= ((float) b2.getTop()) + translationY && f2 <= ((float) b2.getBottom()) + translationY) {
                return b2;
            }
        }
        return null;
    }

    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    public void offsetChildrenVertical(int i) {
        int b = this.mChildHelper.mo5446b();
        for (int i2 = 0; i2 < b; i2++) {
            this.mChildHelper.mo5448b(i2).offsetTopAndBottom(i);
        }
    }

    public void offsetChildrenHorizontal(int i) {
        int b = this.mChildHelper.mo5446b();
        for (int i2 = 0; i2 < b; i2++) {
            this.mChildHelper.mo5448b(i2).offsetLeftAndRight(i);
        }
    }

    public void getDecoratedBoundsWithMargins(View view, Rect rect) {
        getDecoratedBoundsWithMarginsInt(view, rect);
    }

    static void getDecoratedBoundsWithMarginsInt(View view, Rect rect) {
        C1259j jVar = (C1259j) view.getLayoutParams();
        Rect rect2 = jVar.f3730d;
        rect.set((view.getLeft() - rect2.left) - jVar.leftMargin, (view.getTop() - rect2.top) - jVar.topMargin, view.getRight() + rect2.right + jVar.rightMargin, view.getBottom() + rect2.bottom + jVar.bottomMargin);
    }

    /* access modifiers changed from: 0000 */
    public Rect getItemDecorInsetsForChild(View view) {
        C1259j jVar = (C1259j) view.getLayoutParams();
        if (!jVar.f3731e) {
            return jVar.f3730d;
        }
        if (this.mState.mo5287a() && (jVar.mo5198e() || jVar.mo5196c())) {
            return jVar.f3730d;
        }
        Rect rect = jVar.f3730d;
        rect.set(0, 0, 0, 0);
        int size = this.mItemDecorations.size();
        for (int i = 0; i < size; i++) {
            this.mTempRect.set(0, 0, 0, 0);
            ((C1253h) this.mItemDecorations.get(i)).mo5095a(this.mTempRect, view, this, this.mState);
            rect.left += this.mTempRect.left;
            rect.top += this.mTempRect.top;
            rect.right += this.mTempRect.right;
            rect.bottom += this.mTempRect.bottom;
        }
        jVar.f3731e = false;
        return rect;
    }

    /* access modifiers changed from: 0000 */
    public void dispatchOnScrolled(int i, int i2) {
        this.mDispatchScrollCounter++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        onScrolled(i, i2);
        if (this.mScrollListener != null) {
            this.mScrollListener.mo5207a(this, i, i2);
        }
        if (this.mScrollListeners != null) {
            for (int size = this.mScrollListeners.size() - 1; size >= 0; size--) {
                ((C1263n) this.mScrollListeners.get(size)).mo5207a(this, i, i2);
            }
        }
        this.mDispatchScrollCounter--;
    }

    /* access modifiers changed from: 0000 */
    public void dispatchOnScrollStateChanged(int i) {
        if (this.mLayout != null) {
            this.mLayout.mo5175l(i);
        }
        onScrollStateChanged(i);
        if (this.mScrollListener != null) {
            this.mScrollListener.mo5206a(this, i);
        }
        if (this.mScrollListeners != null) {
            for (int size = this.mScrollListeners.size() - 1; size >= 0; size--) {
                ((C1263n) this.mScrollListeners.get(size)).mo5206a(this, i);
            }
        }
    }

    public boolean hasPendingAdapterUpdates() {
        return !this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout || this.mAdapterHelper.mo5433d();
    }

    /* access modifiers changed from: 0000 */
    public void repositionShadowingViews() {
        int b = this.mChildHelper.mo5446b();
        for (int i = 0; i < b; i++) {
            View b2 = this.mChildHelper.mo5448b(i);
            C1277x childViewHolder = getChildViewHolder(b2);
            if (!(childViewHolder == null || childViewHolder.mShadowingHolder == null)) {
                View view = childViewHolder.mShadowingHolder.itemView;
                int left = b2.getLeft();
                int top = b2.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    static RecyclerView findNestedRecyclerView(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            RecyclerView findNestedRecyclerView = findNestedRecyclerView(viewGroup.getChildAt(i));
            if (findNestedRecyclerView != null) {
                return findNestedRecyclerView;
            }
        }
        return null;
    }

    static void clearNestedRecyclerViewIfNotNested(C1277x xVar) {
        if (xVar.mNestedRecyclerView != null) {
            View view = (View) xVar.mNestedRecyclerView.get();
            while (view != null) {
                if (view != xVar.itemView) {
                    ViewParent parent = view.getParent();
                    view = parent instanceof View ? (View) parent : null;
                } else {
                    return;
                }
            }
            xVar.mNestedRecyclerView = null;
        }
    }

    /* access modifiers changed from: 0000 */
    public long getNanoTime() {
        if (ALLOW_THREAD_GAP_WORK) {
            return System.nanoTime();
        }
        return 0;
    }

    /* access modifiers changed from: 0000 */
    public void dispatchChildDetached(View view) {
        C1277x childViewHolderInt = getChildViewHolderInt(view);
        onChildDetachedFromWindow(view);
        if (!(this.mAdapter == null || childViewHolderInt == null)) {
            this.mAdapter.onViewDetachedFromWindow(childViewHolderInt);
        }
        if (this.mOnChildAttachStateListeners != null) {
            for (int size = this.mOnChildAttachStateListeners.size() - 1; size >= 0; size--) {
                ((C1260k) this.mOnChildAttachStateListeners.get(size)).mo5201b(view);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void dispatchChildAttached(View view) {
        C1277x childViewHolderInt = getChildViewHolderInt(view);
        onChildAttachedToWindow(view);
        if (!(this.mAdapter == null || childViewHolderInt == null)) {
            this.mAdapter.onViewAttachedToWindow(childViewHolderInt);
        }
        if (this.mOnChildAttachStateListeners != null) {
            for (int size = this.mOnChildAttachStateListeners.size() - 1; size >= 0; size--) {
                ((C1260k) this.mOnChildAttachStateListeners.get(size)).mo5200a(view);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean setChildImportantForAccessibilityInternal(C1277x xVar, int i) {
        if (isComputingLayout()) {
            xVar.mPendingAccessibilityState = i;
            this.mPendingAccessibilityImportanceChange.add(xVar);
            return false;
        }
        C0962r.m3569b(xVar.itemView, i);
        return true;
    }

    /* access modifiers changed from: 0000 */
    public void dispatchPendingImportantForAccessibilityChanges() {
        for (int size = this.mPendingAccessibilityImportanceChange.size() - 1; size >= 0; size--) {
            C1277x xVar = (C1277x) this.mPendingAccessibilityImportanceChange.get(size);
            if (xVar.itemView.getParent() == this && !xVar.shouldIgnore()) {
                int i = xVar.mPendingAccessibilityState;
                if (i != -1) {
                    C0962r.m3569b(xVar.itemView, i);
                    xVar.mPendingAccessibilityState = -1;
                }
            }
        }
        this.mPendingAccessibilityImportanceChange.clear();
    }

    /* access modifiers changed from: 0000 */
    public int getAdapterPositionFor(C1277x xVar) {
        if (xVar.hasAnyOfTheFlags(524) || !xVar.isBound()) {
            return -1;
        }
        return this.mAdapterHelper.mo5430c(xVar.mPosition);
    }

    /* access modifiers changed from: 0000 */
    public void initFastScroller(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Trying to set fast scroller without both required drawables.");
            sb.append(exceptionLabel());
            throw new IllegalArgumentException(sb.toString());
        }
        Resources resources = getContext().getResources();
        new C1304d(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(R.dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(R.dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(R.dimen.fastscroll_margin));
    }

    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().mo3738a(z);
    }

    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().mo3739a();
    }

    public boolean startNestedScroll(int i) {
        return getScrollingChildHelper().mo3749b(i);
    }

    public boolean startNestedScroll(int i, int i2) {
        return getScrollingChildHelper().mo3743a(i, i2);
    }

    public void stopNestedScroll() {
        getScrollingChildHelper().mo3750c();
    }

    public void stopNestedScroll(int i) {
        getScrollingChildHelper().mo3751c(i);
    }

    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().mo3748b();
    }

    public boolean hasNestedScrollingParent(int i) {
        return getScrollingChildHelper().mo3742a(i);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return getScrollingChildHelper().mo3744a(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return getScrollingChildHelper().mo3745a(i, i2, i3, i4, iArr, i5);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().mo3746a(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return getScrollingChildHelper().mo3747a(i, i2, iArr, iArr2, i3);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return getScrollingChildHelper().mo3741a(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return getScrollingChildHelper().mo3740a(f, f2);
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i, int i2) {
        if (this.mChildDrawingOrderCallback == null) {
            return super.getChildDrawingOrder(i, i2);
        }
        return this.mChildDrawingOrderCallback.mo5065a(i, i2);
    }

    private C0955k getScrollingChildHelper() {
        if (this.mScrollingChildHelper == null) {
            this.mScrollingChildHelper = new C0955k(this);
        }
        return this.mScrollingChildHelper;
    }
}
