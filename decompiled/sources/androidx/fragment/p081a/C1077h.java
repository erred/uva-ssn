package androidx.fragment.p081a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.core.app.C0840a;
import androidx.core.p069f.C0930e;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: androidx.fragment.a.h */
/* compiled from: FragmentHostCallback */
public abstract class C1077h<E> extends C1075f {

    /* renamed from: a */
    private final Activity f3346a;

    /* renamed from: b */
    final C1081j f3347b;

    /* renamed from: c */
    private final Context f3348c;

    /* renamed from: d */
    private final Handler f3349d;

    /* renamed from: e */
    private final int f3350e;

    /* renamed from: a */
    public View mo4277a(int i) {
        return null;
    }

    /* renamed from: a */
    public void mo4329a(C1062d dVar, String[] strArr, int i) {
    }

    /* renamed from: a */
    public void mo4330a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    /* renamed from: a */
    public boolean mo4279a() {
        return true;
    }

    /* renamed from: a */
    public boolean mo4331a(C1062d dVar) {
        return true;
    }

    /* renamed from: a */
    public boolean mo4332a(String str) {
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo4334b(C1062d dVar) {
    }

    /* renamed from: d */
    public void mo4336d() {
    }

    /* renamed from: e */
    public boolean mo4337e() {
        return true;
    }

    /* renamed from: g */
    public abstract E mo4339g();

    C1077h(C1071e eVar) {
        this(eVar, eVar, eVar.mHandler, 0);
    }

    C1077h(Activity activity, Context context, Handler handler, int i) {
        this.f3347b = new C1081j();
        this.f3346a = activity;
        this.f3348c = (Context) C0930e.m3404a(context, "context == null");
        this.f3349d = (Handler) C0930e.m3404a(handler, "handler == null");
        this.f3350e = i;
    }

    /* renamed from: b */
    public LayoutInflater mo4333b() {
        return LayoutInflater.from(this.f3348c);
    }

    /* renamed from: a */
    public void mo4327a(C1062d dVar, Intent intent, int i, Bundle bundle) {
        if (i == -1) {
            this.f3348c.startActivity(intent);
            return;
        }
        throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
    }

    /* renamed from: a */
    public void mo4328a(C1062d dVar, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws SendIntentException {
        if (i == -1) {
            C0840a.m3094a(this.f3346a, intentSender, i, intent, i2, i3, i4, bundle);
        } else {
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
    }

    /* renamed from: f */
    public int mo4338f() {
        return this.f3350e;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public Activity mo4365h() {
        return this.f3346a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public Context mo4366i() {
        return this.f3348c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public Handler mo4367j() {
        return this.f3349d;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: k */
    public C1081j mo4368k() {
        return this.f3347b;
    }
}
