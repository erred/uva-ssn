package androidx.fragment.p081a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.core.app.C0840a;
import androidx.core.app.C0840a.C0842a;
import androidx.core.app.C0840a.C0843b;
import androidx.core.app.C0840a.C0844c;
import androidx.core.app.C0850d;
import androidx.core.app.C0866l;
import androidx.lifecycle.C1172e;
import androidx.lifecycle.C1172e.C1174b;
import androidx.lifecycle.C1191r;
import androidx.lifecycle.C1192s;
import androidx.loader.p087a.C1197a;
import androidx.p052b.C0726h;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: androidx.fragment.a.e */
/* compiled from: FragmentActivity */
public class C1071e extends C0850d implements C0842a, C0844c, C1192s {
    static final String ALLOCATED_REQUEST_INDICIES_TAG = "android:support:request_indicies";
    static final String FRAGMENTS_TAG = "android:support:fragments";
    static final int MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS = 65534;
    static final int MSG_RESUME_PENDING = 2;
    static final String NEXT_CANDIDATE_REQUEST_INDEX_TAG = "android:support:next_request_index";
    static final String REQUEST_FRAGMENT_WHO_TAG = "android:support:request_fragment_who";
    private static final String TAG = "FragmentActivity";
    boolean mCreated;
    final C1076g mFragments = C1076g.m4061a((C1077h<?>) new C1073a<Object>());
    final Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            if (message.what != 2) {
                super.handleMessage(message);
                return;
            }
            C1071e.this.onResumeFragments();
            C1071e.this.mFragments.mo4364m();
        }
    };
    int mNextCandidateRequestIndex;
    C0726h<String> mPendingFragmentActivityResults;
    boolean mRequestedPermissionsFromFragment;
    boolean mResumed;
    boolean mStartedActivityFromFragment;
    boolean mStartedIntentSenderFromFragment;
    boolean mStopped = true;
    private C1191r mViewModelStore;

    /* renamed from: androidx.fragment.a.e$a */
    /* compiled from: FragmentActivity */
    class C1073a extends C1077h<C1071e> {
        public C1073a() {
            super(C1071e.this);
        }

        /* renamed from: a */
        public void mo4330a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            C1071e.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        /* renamed from: a */
        public boolean mo4331a(C1062d dVar) {
            return !C1071e.this.isFinishing();
        }

        /* renamed from: b */
        public LayoutInflater mo4333b() {
            return C1071e.this.getLayoutInflater().cloneInContext(C1071e.this);
        }

        /* renamed from: c */
        public C1071e mo4339g() {
            return C1071e.this;
        }

        /* renamed from: d */
        public void mo4336d() {
            C1071e.this.supportInvalidateOptionsMenu();
        }

        /* renamed from: a */
        public void mo4327a(C1062d dVar, Intent intent, int i, Bundle bundle) {
            C1071e.this.startActivityFromFragment(dVar, intent, i, bundle);
        }

        /* renamed from: a */
        public void mo4328a(C1062d dVar, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws SendIntentException {
            C1071e.this.startIntentSenderFromFragment(dVar, intentSender, i, intent, i2, i3, i4, bundle);
        }

        /* renamed from: a */
        public void mo4329a(C1062d dVar, String[] strArr, int i) {
            C1071e.this.requestPermissionsFromFragment(dVar, strArr, i);
        }

        /* renamed from: a */
        public boolean mo4332a(String str) {
            return C0840a.m3097a((Activity) C1071e.this, str);
        }

        /* renamed from: e */
        public boolean mo4337e() {
            return C1071e.this.getWindow() != null;
        }

        /* renamed from: f */
        public int mo4338f() {
            Window window = C1071e.this.getWindow();
            if (window == null) {
                return 0;
            }
            return window.getAttributes().windowAnimations;
        }

        /* renamed from: b */
        public void mo4334b(C1062d dVar) {
            C1071e.this.onAttachFragment(dVar);
        }

        /* renamed from: a */
        public View mo4277a(int i) {
            return C1071e.this.findViewById(i);
        }

        /* renamed from: a */
        public boolean mo4279a() {
            Window window = C1071e.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }
    }

    /* renamed from: androidx.fragment.a.e$b */
    /* compiled from: FragmentActivity */
    static final class C1074b {

        /* renamed from: a */
        Object f3342a;

        /* renamed from: b */
        C1191r f3343b;

        /* renamed from: c */
        C1098k f3344c;

        C1074b() {
        }
    }

    public void onAttachFragment(C1062d dVar) {
    }

    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        this.mFragments.mo4350b();
        int i3 = i >> 16;
        if (i3 != 0) {
            int i4 = i3 - 1;
            String str = (String) this.mPendingFragmentActivityResults.mo2895a(i4);
            this.mPendingFragmentActivityResults.mo2901c(i4);
            if (str == null) {
                Log.w(TAG, "Activity result delivered for unknown Fragment.");
                return;
            }
            C1062d a = this.mFragments.mo4341a(str);
            if (a == null) {
                String str2 = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("Activity result no fragment exists for who: ");
                sb.append(str);
                Log.w(str2, sb.toString());
            } else {
                a.onActivityResult(i & 65535, i2, intent);
            }
            return;
        }
        C0843b a2 = C0840a.m3091a();
        if (a2 == null || !a2.mo3453a(this, i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
        }
    }

    public void onBackPressed() {
        C1078i a = this.mFragments.mo4342a();
        boolean f = a.mo4377f();
        if (!f || VERSION.SDK_INT > 25) {
            if (f || !a.mo4374c()) {
                super.onBackPressed();
            }
        }
    }

    public void supportFinishAfterTransition() {
        C0840a.m3098b(this);
    }

    public void setEnterSharedElementCallback(C0866l lVar) {
        C0840a.m3095a((Activity) this, lVar);
    }

    public void setExitSharedElementCallback(C0866l lVar) {
        C0840a.m3099b(this, lVar);
    }

    public void supportPostponeEnterTransition() {
        C0840a.m3100c(this);
    }

    public void supportStartPostponedEnterTransition() {
        C0840a.m3101d(this);
    }

    public void onMultiWindowModeChanged(boolean z) {
        this.mFragments.mo4346a(z);
    }

    public void onPictureInPictureModeChanged(boolean z) {
        this.mFragments.mo4352b(z);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mFragments.mo4350b();
        this.mFragments.mo4343a(configuration);
    }

    public C1191r getViewModelStore() {
        if (getApplication() != null) {
            if (this.mViewModelStore == null) {
                C1074b bVar = (C1074b) getLastNonConfigurationInstance();
                if (bVar != null) {
                    this.mViewModelStore = bVar.f3343b;
                }
                if (this.mViewModelStore == null) {
                    this.mViewModelStore = new C1191r();
                }
            }
            return this.mViewModelStore;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    public C1172e getLifecycle() {
        return super.getLifecycle();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        C1098k kVar = null;
        this.mFragments.mo4345a((C1062d) null);
        super.onCreate(bundle);
        C1074b bVar = (C1074b) getLastNonConfigurationInstance();
        if (!(bVar == null || bVar.f3343b == null || this.mViewModelStore != null)) {
            this.mViewModelStore = bVar.f3343b;
        }
        if (bundle != null) {
            Parcelable parcelable = bundle.getParcelable(FRAGMENTS_TAG);
            C1076g gVar = this.mFragments;
            if (bVar != null) {
                kVar = bVar.f3344c;
            }
            gVar.mo4344a(parcelable, kVar);
            if (bundle.containsKey(NEXT_CANDIDATE_REQUEST_INDEX_TAG)) {
                this.mNextCandidateRequestIndex = bundle.getInt(NEXT_CANDIDATE_REQUEST_INDEX_TAG);
                int[] intArray = bundle.getIntArray(ALLOCATED_REQUEST_INDICIES_TAG);
                String[] stringArray = bundle.getStringArray(REQUEST_FRAGMENT_WHO_TAG);
                if (intArray == null || stringArray == null || intArray.length != stringArray.length) {
                    Log.w(TAG, "Invalid requestCode mapping in savedInstanceState.");
                } else {
                    this.mPendingFragmentActivityResults = new C0726h<>(intArray.length);
                    for (int i = 0; i < intArray.length; i++) {
                        this.mPendingFragmentActivityResults.mo2899b(intArray[i], stringArray[i]);
                    }
                }
            }
        }
        if (this.mPendingFragmentActivityResults == null) {
            this.mPendingFragmentActivityResults = new C0726h<>();
            this.mNextCandidateRequestIndex = 0;
        }
        this.mFragments.mo4356e();
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i == 0) {
            return super.onCreatePanelMenu(i, menu) | this.mFragments.mo4348a(menu, getMenuInflater());
        }
        return super.onCreatePanelMenu(i, menu);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(null, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    /* access modifiers changed from: 0000 */
    public final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mFragments.mo4340a(view, str, context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (this.mViewModelStore != null && !isChangingConfigurations()) {
            this.mViewModelStore.mo4625a();
        }
        this.mFragments.mo4362k();
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.mFragments.mo4363l();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 0) {
            return this.mFragments.mo4349a(menuItem);
        }
        if (i != 6) {
            return false;
        }
        return this.mFragments.mo4353b(menuItem);
    }

    public void onPanelClosed(int i, Menu menu) {
        if (i == 0) {
            this.mFragments.mo4351b(menu);
        }
        super.onPanelClosed(i, menu);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.mResumed = false;
        if (this.mHandler.hasMessages(2)) {
            this.mHandler.removeMessages(2);
            onResumeFragments();
        }
        this.mFragments.mo4360i();
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.mFragments.mo4350b();
    }

    public void onStateNotSaved() {
        this.mFragments.mo4350b();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.mHandler.sendEmptyMessage(2);
        this.mResumed = true;
        this.mFragments.mo4364m();
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        super.onPostResume();
        this.mHandler.removeMessages(2);
        onResumeFragments();
        this.mFragments.mo4364m();
    }

    /* access modifiers changed from: protected */
    public void onResumeFragments() {
        this.mFragments.mo4359h();
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0 || menu == null) {
            return super.onPreparePanel(i, view, menu);
        }
        return onPrepareOptionsPanel(view, menu) | this.mFragments.mo4347a(menu);
    }

    /* access modifiers changed from: protected */
    public boolean onPrepareOptionsPanel(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    public final Object onRetainNonConfigurationInstance() {
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        C1098k d = this.mFragments.mo4355d();
        if (d == null && this.mViewModelStore == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        C1074b bVar = new C1074b();
        bVar.f3342a = onRetainCustomNonConfigurationInstance;
        bVar.f3343b = this.mViewModelStore;
        bVar.f3344c = d;
        return bVar;
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        markFragmentsCreated();
        Parcelable c = this.mFragments.mo4354c();
        if (c != null) {
            bundle.putParcelable(FRAGMENTS_TAG, c);
        }
        if (this.mPendingFragmentActivityResults.mo2897b() > 0) {
            bundle.putInt(NEXT_CANDIDATE_REQUEST_INDEX_TAG, this.mNextCandidateRequestIndex);
            int[] iArr = new int[this.mPendingFragmentActivityResults.mo2897b()];
            String[] strArr = new String[this.mPendingFragmentActivityResults.mo2897b()];
            for (int i = 0; i < this.mPendingFragmentActivityResults.mo2897b(); i++) {
                iArr[i] = this.mPendingFragmentActivityResults.mo2904d(i);
                strArr[i] = (String) this.mPendingFragmentActivityResults.mo2905e(i);
            }
            bundle.putIntArray(ALLOCATED_REQUEST_INDICIES_TAG, iArr);
            bundle.putStringArray(REQUEST_FRAGMENT_WHO_TAG, strArr);
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.mStopped = false;
        if (!this.mCreated) {
            this.mCreated = true;
            this.mFragments.mo4357f();
        }
        this.mFragments.mo4350b();
        this.mFragments.mo4364m();
        this.mFragments.mo4358g();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        this.mFragments.mo4361j();
    }

    public Object getLastCustomNonConfigurationInstance() {
        C1074b bVar = (C1074b) getLastNonConfigurationInstance();
        if (bVar != null) {
            return bVar.f3342a;
        }
        return null;
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateOptionsMenu();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("  ");
        String sb2 = sb.toString();
        printWriter.print(sb2);
        printWriter.print("mCreated=");
        printWriter.print(this.mCreated);
        printWriter.print(" mResumed=");
        printWriter.print(this.mResumed);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        if (getApplication() != null) {
            C1197a.m4506a(this).mo4629a(sb2, fileDescriptor, printWriter, strArr);
        }
        this.mFragments.mo4342a().mo4372a(str, fileDescriptor, printWriter, strArr);
    }

    public C1078i getSupportFragmentManager() {
        return this.mFragments.mo4342a();
    }

    @Deprecated
    public C1197a getSupportLoaderManager() {
        return C1197a.m4506a(this);
    }

    public void startActivityForResult(Intent intent, int i) {
        if (!this.mStartedActivityFromFragment && i != -1) {
            checkForValidRequestCode(i);
        }
        super.startActivityForResult(intent, i);
    }

    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        if (!this.mStartedActivityFromFragment && i != -1) {
            checkForValidRequestCode(i);
        }
        super.startActivityForResult(intent, i, bundle);
    }

    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) throws SendIntentException {
        if (!this.mStartedIntentSenderFromFragment && i != -1) {
            checkForValidRequestCode(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws SendIntentException {
        if (!this.mStartedIntentSenderFromFragment && i != -1) {
            checkForValidRequestCode(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    static void checkForValidRequestCode(int i) {
        if ((i & -65536) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
    }

    public final void validateRequestPermissionsRequestCode(int i) {
        if (!this.mRequestedPermissionsFromFragment && i != -1) {
            checkForValidRequestCode(i);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.mFragments.mo4350b();
        int i2 = (i >> 16) & 65535;
        if (i2 != 0) {
            int i3 = i2 - 1;
            String str = (String) this.mPendingFragmentActivityResults.mo2895a(i3);
            this.mPendingFragmentActivityResults.mo2901c(i3);
            if (str == null) {
                Log.w(TAG, "Activity result delivered for unknown Fragment.");
                return;
            }
            C1062d a = this.mFragments.mo4341a(str);
            if (a == null) {
                String str2 = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("Activity result no fragment exists for who: ");
                sb.append(str);
                Log.w(str2, sb.toString());
            } else {
                a.onRequestPermissionsResult(i & 65535, strArr, iArr);
            }
        }
    }

    public void startActivityFromFragment(C1062d dVar, Intent intent, int i) {
        startActivityFromFragment(dVar, intent, i, null);
    }

    public void startActivityFromFragment(C1062d dVar, Intent intent, int i, Bundle bundle) {
        this.mStartedActivityFromFragment = true;
        if (i == -1) {
            try {
                C0840a.m3093a(this, intent, -1, bundle);
            } finally {
                this.mStartedActivityFromFragment = false;
            }
        } else {
            checkForValidRequestCode(i);
            C0840a.m3093a(this, intent, ((allocateRequestIndex(dVar) + 1) << 16) + (i & 65535), bundle);
            this.mStartedActivityFromFragment = false;
        }
    }

    public void startIntentSenderFromFragment(C1062d dVar, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws SendIntentException {
        int i5 = i;
        this.mStartedIntentSenderFromFragment = true;
        if (i5 == -1) {
            try {
                C0840a.m3094a(this, intentSender, i, intent, i2, i3, i4, bundle);
            } finally {
                this.mStartedIntentSenderFromFragment = false;
            }
        } else {
            checkForValidRequestCode(i);
            C0840a.m3094a(this, intentSender, ((allocateRequestIndex(dVar) + 1) << 16) + (i5 & 65535), intent, i2, i3, i4, bundle);
            this.mStartedIntentSenderFromFragment = false;
        }
    }

    private int allocateRequestIndex(C1062d dVar) {
        if (this.mPendingFragmentActivityResults.mo2897b() < MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS) {
            while (this.mPendingFragmentActivityResults.mo2906f(this.mNextCandidateRequestIndex) >= 0) {
                this.mNextCandidateRequestIndex = (this.mNextCandidateRequestIndex + 1) % MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS;
            }
            int i = this.mNextCandidateRequestIndex;
            this.mPendingFragmentActivityResults.mo2899b(i, dVar.mWho);
            this.mNextCandidateRequestIndex = (this.mNextCandidateRequestIndex + 1) % MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS;
            return i;
        }
        throw new IllegalStateException("Too many pending Fragment activity results.");
    }

    /* access modifiers changed from: 0000 */
    public void requestPermissionsFromFragment(C1062d dVar, String[] strArr, int i) {
        if (i == -1) {
            C0840a.m3096a(this, strArr, i);
            return;
        }
        checkForValidRequestCode(i);
        try {
            this.mRequestedPermissionsFromFragment = true;
            C0840a.m3096a(this, strArr, ((allocateRequestIndex(dVar) + 1) << 16) + (i & 65535));
        } finally {
            this.mRequestedPermissionsFromFragment = false;
        }
    }

    private void markFragmentsCreated() {
        do {
        } while (markState(getSupportFragmentManager(), C1174b.CREATED));
    }

    private static boolean markState(C1078i iVar, C1174b bVar) {
        boolean z = false;
        for (C1062d dVar : iVar.mo4376e()) {
            if (dVar != null) {
                if (dVar.getLifecycle().mo4601a().mo4604a(C1174b.STARTED)) {
                    dVar.mLifecycleRegistry.mo4606a(bVar);
                    z = true;
                }
                C1078i peekChildFragmentManager = dVar.peekChildFragmentManager();
                if (peekChildFragmentManager != null) {
                    z |= markState(peekChildFragmentManager, bVar);
                }
            }
        }
        return z;
    }
}
