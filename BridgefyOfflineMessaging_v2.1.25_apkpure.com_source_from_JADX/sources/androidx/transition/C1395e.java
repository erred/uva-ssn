package androidx.transition;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.p081a.C1116r;
import androidx.transition.C1407m.C1413c;
import androidx.transition.C1407m.C1414d;
import java.util.ArrayList;
import java.util.List;

/* renamed from: androidx.transition.e */
/* compiled from: FragmentTransitionSupport */
public class C1395e extends C1116r {
    /* renamed from: a */
    public boolean mo4526a(Object obj) {
        return obj instanceof C1407m;
    }

    /* renamed from: b */
    public Object mo4527b(Object obj) {
        if (obj != null) {
            return ((C1407m) obj).clone();
        }
        return null;
    }

    /* renamed from: c */
    public Object mo4532c(Object obj) {
        if (obj == null) {
            return null;
        }
        C1420q qVar = new C1420q();
        qVar.mo5863a((C1407m) obj);
        return qVar;
    }

    /* renamed from: a */
    public void mo4522a(Object obj, View view, ArrayList<View> arrayList) {
        C1420q qVar = (C1420q) obj;
        List targets = qVar.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            m4330a(targets, (View) arrayList.get(i));
        }
        targets.add(view);
        arrayList.add(view);
        mo4524a((Object) qVar, arrayList);
    }

    /* renamed from: a */
    public void mo4521a(Object obj, View view) {
        if (view != null) {
            C1407m mVar = (C1407m) obj;
            final Rect rect = new Rect();
            mo4547a(view, rect);
            mVar.setEpicenterCallback(new C1413c() {
                /* renamed from: a */
                public Rect mo5781a(C1407m mVar) {
                    return rect;
                }
            });
        }
    }

    /* renamed from: a */
    public void mo4524a(Object obj, ArrayList<View> arrayList) {
        C1407m mVar = (C1407m) obj;
        if (mVar != null) {
            int i = 0;
            if (mVar instanceof C1420q) {
                C1420q qVar = (C1420q) mVar;
                int a = qVar.mo5856a();
                while (i < a) {
                    mo4524a((Object) qVar.mo5866b(i), arrayList);
                    i++;
                }
            } else if (!m5629a(mVar) && m4331a(mVar.getTargets())) {
                int size = arrayList.size();
                while (i < size) {
                    mVar.addTarget((View) arrayList.get(i));
                    i++;
                }
            }
        }
    }

    /* renamed from: a */
    private static boolean m5629a(C1407m mVar) {
        return !m4331a(mVar.getTargetIds()) || !m4331a(mVar.getTargetNames()) || !m4331a(mVar.getTargetTypes());
    }

    /* renamed from: a */
    public Object mo4518a(Object obj, Object obj2, Object obj3) {
        C1420q qVar = new C1420q();
        if (obj != null) {
            qVar.mo5863a((C1407m) obj);
        }
        if (obj2 != null) {
            qVar.mo5863a((C1407m) obj2);
        }
        if (obj3 != null) {
            qVar.mo5863a((C1407m) obj3);
        }
        return qVar;
    }

    /* renamed from: b */
    public void mo4530b(Object obj, final View view, final ArrayList<View> arrayList) {
        ((C1407m) obj).addListener(new C1414d() {
            /* renamed from: a */
            public void mo5737a(C1407m mVar) {
            }

            /* renamed from: c */
            public void mo5739c(C1407m mVar) {
            }

            /* renamed from: d */
            public void mo5740d(C1407m mVar) {
            }

            /* renamed from: e */
            public void mo5741e(C1407m mVar) {
            }

            /* renamed from: b */
            public void mo5738b(C1407m mVar) {
                mVar.removeListener(this);
                view.setVisibility(8);
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((View) arrayList.get(i)).setVisibility(0);
                }
            }
        });
    }

    /* renamed from: b */
    public Object mo4528b(Object obj, Object obj2, Object obj3) {
        C1407m mVar = (C1407m) obj;
        C1407m mVar2 = (C1407m) obj2;
        C1407m mVar3 = (C1407m) obj3;
        if (mVar != null && mVar2 != null) {
            mVar = new C1420q().mo5863a(mVar).mo5863a(mVar2).mo5857a(1);
        } else if (mVar == null) {
            mVar = mVar2 != null ? mVar2 : null;
        }
        if (mVar3 == null) {
            return mVar;
        }
        C1420q qVar = new C1420q();
        if (mVar != null) {
            qVar.mo5863a(mVar);
        }
        qVar.mo5863a(mVar3);
        return qVar;
    }

    /* renamed from: a */
    public void mo4519a(ViewGroup viewGroup, Object obj) {
        C1416o.m5682a(viewGroup, (C1407m) obj);
    }

    /* renamed from: a */
    public void mo4523a(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        C1407m mVar = (C1407m) obj;
        final Object obj5 = obj2;
        final ArrayList<View> arrayList4 = arrayList;
        final Object obj6 = obj3;
        final ArrayList<View> arrayList5 = arrayList2;
        final Object obj7 = obj4;
        final ArrayList<View> arrayList6 = arrayList3;
        C13983 r1 = new C1414d() {
            /* renamed from: a */
            public void mo5737a(C1407m mVar) {
            }

            /* renamed from: b */
            public void mo5738b(C1407m mVar) {
            }

            /* renamed from: c */
            public void mo5739c(C1407m mVar) {
            }

            /* renamed from: d */
            public void mo5740d(C1407m mVar) {
            }

            /* renamed from: e */
            public void mo5741e(C1407m mVar) {
                if (obj5 != null) {
                    C1395e.this.mo4531b(obj5, arrayList4, null);
                }
                if (obj6 != null) {
                    C1395e.this.mo4531b(obj6, arrayList5, null);
                }
                if (obj7 != null) {
                    C1395e.this.mo4531b(obj7, arrayList6, null);
                }
            }
        };
        mVar.addListener(r1);
    }

    /* renamed from: a */
    public void mo4525a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        C1420q qVar = (C1420q) obj;
        if (qVar != null) {
            qVar.getTargets().clear();
            qVar.getTargets().addAll(arrayList2);
            mo4531b((Object) qVar, arrayList, arrayList2);
        }
    }

    /* renamed from: b */
    public void mo4531b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        int i;
        C1407m mVar = (C1407m) obj;
        int i2 = 0;
        if (mVar instanceof C1420q) {
            C1420q qVar = (C1420q) mVar;
            int a = qVar.mo5856a();
            while (i2 < a) {
                mo4531b((Object) qVar.mo5866b(i2), arrayList, arrayList2);
                i2++;
            }
        } else if (!m5629a(mVar)) {
            List targets = mVar.getTargets();
            if (targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
                if (arrayList2 == null) {
                    i = 0;
                } else {
                    i = arrayList2.size();
                }
                while (i2 < i) {
                    mVar.addTarget((View) arrayList2.get(i2));
                    i2++;
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    mVar.removeTarget((View) arrayList.get(size));
                }
            }
        }
    }

    /* renamed from: b */
    public void mo4529b(Object obj, View view) {
        if (obj != null) {
            ((C1407m) obj).addTarget(view);
        }
    }

    /* renamed from: c */
    public void mo4533c(Object obj, View view) {
        if (obj != null) {
            ((C1407m) obj).removeTarget(view);
        }
    }

    /* renamed from: a */
    public void mo4520a(Object obj, final Rect rect) {
        if (obj != null) {
            ((C1407m) obj).setEpicenterCallback(new C1413c() {
                /* renamed from: a */
                public Rect mo5781a(C1407m mVar) {
                    if (rect == null || rect.isEmpty()) {
                        return null;
                    }
                    return rect;
                }
            });
        }
    }
}
