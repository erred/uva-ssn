package androidx.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import androidx.lifecycle.C1172e.C1173a;

/* renamed from: androidx.lifecycle.o */
/* compiled from: ReportFragment */
public class C1186o extends Fragment {

    /* renamed from: a */
    private C1187a f3586a;

    /* renamed from: androidx.lifecycle.o$a */
    /* compiled from: ReportFragment */
    interface C1187a {
        /* renamed from: a */
        void mo4617a();

        /* renamed from: b */
        void mo4618b();

        /* renamed from: c */
        void mo4619c();
    }

    /* renamed from: a */
    public static void m4491a(Activity activity) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new C1186o(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }

    /* renamed from: a */
    private void m4493a(C1187a aVar) {
        if (aVar != null) {
            aVar.mo4617a();
        }
    }

    /* renamed from: b */
    private void m4494b(C1187a aVar) {
        if (aVar != null) {
            aVar.mo4618b();
        }
    }

    /* renamed from: c */
    private void m4495c(C1187a aVar) {
        if (aVar != null) {
            aVar.mo4619c();
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        m4493a(this.f3586a);
        m4492a(C1173a.ON_CREATE);
    }

    public void onStart() {
        super.onStart();
        m4494b(this.f3586a);
        m4492a(C1173a.ON_START);
    }

    public void onResume() {
        super.onResume();
        m4495c(this.f3586a);
        m4492a(C1173a.ON_RESUME);
    }

    public void onPause() {
        super.onPause();
        m4492a(C1173a.ON_PAUSE);
    }

    public void onStop() {
        super.onStop();
        m4492a(C1173a.ON_STOP);
    }

    public void onDestroy() {
        super.onDestroy();
        m4492a(C1173a.ON_DESTROY);
        this.f3586a = null;
    }

    /* renamed from: a */
    private void m4492a(C1173a aVar) {
        Activity activity = getActivity();
        if (activity instanceof C1180i) {
            ((C1180i) activity).mo4608a().mo4605a(aVar);
            return;
        }
        if (activity instanceof C1176g) {
            C1172e lifecycle = ((C1176g) activity).getLifecycle();
            if (lifecycle instanceof C1177h) {
                ((C1177h) lifecycle).mo4605a(aVar);
            }
        }
    }
}
