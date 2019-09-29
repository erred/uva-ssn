package androidx.transition;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.C1407m.C1413c;
import androidx.transition.C1407m.C1414d;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: androidx.transition.q */
/* compiled from: TransitionSet */
public class C1420q extends C1407m {

    /* renamed from: a */
    int f4222a;

    /* renamed from: b */
    boolean f4223b = false;

    /* renamed from: c */
    private ArrayList<C1407m> f4224c = new ArrayList<>();

    /* renamed from: d */
    private boolean f4225d = true;

    /* renamed from: e */
    private int f4226e = 0;

    /* renamed from: androidx.transition.q$a */
    /* compiled from: TransitionSet */
    static class C1422a extends C1415n {

        /* renamed from: a */
        C1420q f4229a;

        C1422a(C1420q qVar) {
            this.f4229a = qVar;
        }

        /* renamed from: e */
        public void mo5741e(C1407m mVar) {
            if (!this.f4229a.f4223b) {
                this.f4229a.start();
                this.f4229a.f4223b = true;
            }
        }

        /* renamed from: b */
        public void mo5738b(C1407m mVar) {
            this.f4229a.f4222a--;
            if (this.f4229a.f4222a == 0) {
                this.f4229a.f4223b = false;
                this.f4229a.end();
            }
            mVar.removeListener(this);
        }
    }

    /* renamed from: a */
    public C1420q mo5857a(int i) {
        switch (i) {
            case 0:
                this.f4225d = true;
                break;
            case 1:
                this.f4225d = false;
                break;
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid parameter for TransitionSet ordering: ");
                sb.append(i);
                throw new AndroidRuntimeException(sb.toString());
        }
        return this;
    }

    /* renamed from: a */
    public C1420q mo5863a(C1407m mVar) {
        this.f4224c.add(mVar);
        mVar.mParent = this;
        if (this.mDuration >= 0) {
            mVar.setDuration(this.mDuration);
        }
        if ((this.f4226e & 1) != 0) {
            mVar.setInterpolator(getInterpolator());
        }
        if ((this.f4226e & 2) != 0) {
            mVar.setPropagation(getPropagation());
        }
        if ((this.f4226e & 4) != 0) {
            mVar.setPathMotion(getPathMotion());
        }
        if ((this.f4226e & 8) != 0) {
            mVar.setEpicenterCallback(getEpicenterCallback());
        }
        return this;
    }

    /* renamed from: a */
    public int mo5856a() {
        return this.f4224c.size();
    }

    /* renamed from: b */
    public C1407m mo5866b(int i) {
        if (i < 0 || i >= this.f4224c.size()) {
            return null;
        }
        return (C1407m) this.f4224c.get(i);
    }

    /* renamed from: a */
    public C1420q setDuration(long j) {
        super.setDuration(j);
        if (this.mDuration >= 0) {
            int size = this.f4224c.size();
            for (int i = 0; i < size; i++) {
                ((C1407m) this.f4224c.get(i)).setDuration(j);
            }
        }
        return this;
    }

    /* renamed from: b */
    public C1420q setStartDelay(long j) {
        return (C1420q) super.setStartDelay(j);
    }

    /* renamed from: a */
    public C1420q setInterpolator(TimeInterpolator timeInterpolator) {
        this.f4226e |= 1;
        if (this.f4224c != null) {
            int size = this.f4224c.size();
            for (int i = 0; i < size; i++) {
                ((C1407m) this.f4224c.get(i)).setInterpolator(timeInterpolator);
            }
        }
        return (C1420q) super.setInterpolator(timeInterpolator);
    }

    /* renamed from: a */
    public C1420q addTarget(View view) {
        for (int i = 0; i < this.f4224c.size(); i++) {
            ((C1407m) this.f4224c.get(i)).addTarget(view);
        }
        return (C1420q) super.addTarget(view);
    }

    /* renamed from: c */
    public C1420q addTarget(int i) {
        for (int i2 = 0; i2 < this.f4224c.size(); i2++) {
            ((C1407m) this.f4224c.get(i2)).addTarget(i);
        }
        return (C1420q) super.addTarget(i);
    }

    /* renamed from: a */
    public C1420q addTarget(String str) {
        for (int i = 0; i < this.f4224c.size(); i++) {
            ((C1407m) this.f4224c.get(i)).addTarget(str);
        }
        return (C1420q) super.addTarget(str);
    }

    /* renamed from: a */
    public C1420q addTarget(Class cls) {
        for (int i = 0; i < this.f4224c.size(); i++) {
            ((C1407m) this.f4224c.get(i)).addTarget(cls);
        }
        return (C1420q) super.addTarget(cls);
    }

    /* renamed from: a */
    public C1420q addListener(C1414d dVar) {
        return (C1420q) super.addListener(dVar);
    }

    /* renamed from: d */
    public C1420q removeTarget(int i) {
        for (int i2 = 0; i2 < this.f4224c.size(); i2++) {
            ((C1407m) this.f4224c.get(i2)).removeTarget(i);
        }
        return (C1420q) super.removeTarget(i);
    }

    /* renamed from: b */
    public C1420q removeTarget(View view) {
        for (int i = 0; i < this.f4224c.size(); i++) {
            ((C1407m) this.f4224c.get(i)).removeTarget(view);
        }
        return (C1420q) super.removeTarget(view);
    }

    /* renamed from: b */
    public C1420q removeTarget(Class cls) {
        for (int i = 0; i < this.f4224c.size(); i++) {
            ((C1407m) this.f4224c.get(i)).removeTarget(cls);
        }
        return (C1420q) super.removeTarget(cls);
    }

    /* renamed from: b */
    public C1420q removeTarget(String str) {
        for (int i = 0; i < this.f4224c.size(); i++) {
            ((C1407m) this.f4224c.get(i)).removeTarget(str);
        }
        return (C1420q) super.removeTarget(str);
    }

    public C1407m excludeTarget(View view, boolean z) {
        for (int i = 0; i < this.f4224c.size(); i++) {
            ((C1407m) this.f4224c.get(i)).excludeTarget(view, z);
        }
        return super.excludeTarget(view, z);
    }

    public C1407m excludeTarget(String str, boolean z) {
        for (int i = 0; i < this.f4224c.size(); i++) {
            ((C1407m) this.f4224c.get(i)).excludeTarget(str, z);
        }
        return super.excludeTarget(str, z);
    }

    public C1407m excludeTarget(int i, boolean z) {
        for (int i2 = 0; i2 < this.f4224c.size(); i2++) {
            ((C1407m) this.f4224c.get(i2)).excludeTarget(i, z);
        }
        return super.excludeTarget(i, z);
    }

    public C1407m excludeTarget(Class cls, boolean z) {
        for (int i = 0; i < this.f4224c.size(); i++) {
            ((C1407m) this.f4224c.get(i)).excludeTarget(cls, z);
        }
        return super.excludeTarget(cls, z);
    }

    /* renamed from: b */
    public C1420q removeListener(C1414d dVar) {
        return (C1420q) super.removeListener(dVar);
    }

    public void setPathMotion(C1401g gVar) {
        super.setPathMotion(gVar);
        this.f4226e |= 4;
        for (int i = 0; i < this.f4224c.size(); i++) {
            ((C1407m) this.f4224c.get(i)).setPathMotion(gVar);
        }
    }

    /* renamed from: b */
    private void m5690b() {
        C1422a aVar = new C1422a(this);
        Iterator it = this.f4224c.iterator();
        while (it.hasNext()) {
            ((C1407m) it.next()).addListener(aVar);
        }
        this.f4222a = this.f4224c.size();
    }

    /* access modifiers changed from: protected */
    public void createAnimators(ViewGroup viewGroup, C1425u uVar, C1425u uVar2, ArrayList<C1424t> arrayList, ArrayList<C1424t> arrayList2) {
        long startDelay = getStartDelay();
        int size = this.f4224c.size();
        for (int i = 0; i < size; i++) {
            C1407m mVar = (C1407m) this.f4224c.get(i);
            if (startDelay > 0 && (this.f4225d || i == 0)) {
                long startDelay2 = mVar.getStartDelay();
                if (startDelay2 > 0) {
                    mVar.setStartDelay(startDelay2 + startDelay);
                } else {
                    mVar.setStartDelay(startDelay);
                }
            }
            mVar.createAnimators(viewGroup, uVar, uVar2, arrayList, arrayList2);
        }
    }

    /* access modifiers changed from: protected */
    public void runAnimators() {
        if (this.f4224c.isEmpty()) {
            start();
            end();
            return;
        }
        m5690b();
        if (!this.f4225d) {
            for (int i = 1; i < this.f4224c.size(); i++) {
                final C1407m mVar = (C1407m) this.f4224c.get(i);
                ((C1407m) this.f4224c.get(i - 1)).addListener(new C1415n() {
                    /* renamed from: b */
                    public void mo5738b(C1407m mVar) {
                        mVar.runAnimators();
                        mVar.removeListener(this);
                    }
                });
            }
            C1407m mVar2 = (C1407m) this.f4224c.get(0);
            if (mVar2 != null) {
                mVar2.runAnimators();
            }
        } else {
            Iterator it = this.f4224c.iterator();
            while (it.hasNext()) {
                ((C1407m) it.next()).runAnimators();
            }
        }
    }

    public void captureStartValues(C1424t tVar) {
        if (isValidTarget(tVar.f4234b)) {
            Iterator it = this.f4224c.iterator();
            while (it.hasNext()) {
                C1407m mVar = (C1407m) it.next();
                if (mVar.isValidTarget(tVar.f4234b)) {
                    mVar.captureStartValues(tVar);
                    tVar.f4235c.add(mVar);
                }
            }
        }
    }

    public void captureEndValues(C1424t tVar) {
        if (isValidTarget(tVar.f4234b)) {
            Iterator it = this.f4224c.iterator();
            while (it.hasNext()) {
                C1407m mVar = (C1407m) it.next();
                if (mVar.isValidTarget(tVar.f4234b)) {
                    mVar.captureEndValues(tVar);
                    tVar.f4235c.add(mVar);
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void capturePropagationValues(C1424t tVar) {
        super.capturePropagationValues(tVar);
        int size = this.f4224c.size();
        for (int i = 0; i < size; i++) {
            ((C1407m) this.f4224c.get(i)).capturePropagationValues(tVar);
        }
    }

    public void pause(View view) {
        super.pause(view);
        int size = this.f4224c.size();
        for (int i = 0; i < size; i++) {
            ((C1407m) this.f4224c.get(i)).pause(view);
        }
    }

    public void resume(View view) {
        super.resume(view);
        int size = this.f4224c.size();
        for (int i = 0; i < size; i++) {
            ((C1407m) this.f4224c.get(i)).resume(view);
        }
    }

    /* access modifiers changed from: protected */
    public void cancel() {
        super.cancel();
        int size = this.f4224c.size();
        for (int i = 0; i < size; i++) {
            ((C1407m) this.f4224c.get(i)).cancel();
        }
    }

    /* access modifiers changed from: 0000 */
    public void forceToEnd(ViewGroup viewGroup) {
        super.forceToEnd(viewGroup);
        int size = this.f4224c.size();
        for (int i = 0; i < size; i++) {
            ((C1407m) this.f4224c.get(i)).forceToEnd(viewGroup);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C1420q setSceneRoot(ViewGroup viewGroup) {
        super.setSceneRoot(viewGroup);
        int size = this.f4224c.size();
        for (int i = 0; i < size; i++) {
            ((C1407m) this.f4224c.get(i)).setSceneRoot(viewGroup);
        }
        return this;
    }

    /* access modifiers changed from: 0000 */
    public void setCanRemoveViews(boolean z) {
        super.setCanRemoveViews(z);
        int size = this.f4224c.size();
        for (int i = 0; i < size; i++) {
            ((C1407m) this.f4224c.get(i)).setCanRemoveViews(z);
        }
    }

    public void setPropagation(C1419p pVar) {
        super.setPropagation(pVar);
        this.f4226e |= 2;
        int size = this.f4224c.size();
        for (int i = 0; i < size; i++) {
            ((C1407m) this.f4224c.get(i)).setPropagation(pVar);
        }
    }

    public void setEpicenterCallback(C1413c cVar) {
        super.setEpicenterCallback(cVar);
        this.f4226e |= 8;
        int size = this.f4224c.size();
        for (int i = 0; i < size; i++) {
            ((C1407m) this.f4224c.get(i)).setEpicenterCallback(cVar);
        }
    }

    /* access modifiers changed from: 0000 */
    public String toString(String str) {
        String mVar = super.toString(str);
        for (int i = 0; i < this.f4224c.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(mVar);
            sb.append("\n");
            C1407m mVar2 = (C1407m) this.f4224c.get(i);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append("  ");
            sb.append(mVar2.toString(sb2.toString()));
            mVar = sb.toString();
        }
        return mVar;
    }

    public C1407m clone() {
        C1420q qVar = (C1420q) super.clone();
        qVar.f4224c = new ArrayList<>();
        int size = this.f4224c.size();
        for (int i = 0; i < size; i++) {
            qVar.mo5863a(((C1407m) this.f4224c.get(i)).clone());
        }
        return qVar;
    }
}
