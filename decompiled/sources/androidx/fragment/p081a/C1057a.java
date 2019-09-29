package androidx.fragment.p081a;

import android.util.Log;
import android.view.View;
import androidx.core.p069f.C0924b;
import androidx.core.p070g.C0962r;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* renamed from: androidx.fragment.a.a */
/* compiled from: BackStackRecord */
final class C1057a extends C1104o implements C1095h {

    /* renamed from: a */
    final C1081j f3278a;

    /* renamed from: b */
    ArrayList<C1058a> f3279b = new ArrayList<>();

    /* renamed from: c */
    int f3280c;

    /* renamed from: d */
    int f3281d;

    /* renamed from: e */
    int f3282e;

    /* renamed from: f */
    int f3283f;

    /* renamed from: g */
    int f3284g;

    /* renamed from: h */
    int f3285h;

    /* renamed from: i */
    boolean f3286i;

    /* renamed from: j */
    boolean f3287j = true;

    /* renamed from: k */
    String f3288k;

    /* renamed from: l */
    boolean f3289l;

    /* renamed from: m */
    int f3290m = -1;

    /* renamed from: n */
    int f3291n;

    /* renamed from: o */
    CharSequence f3292o;

    /* renamed from: p */
    int f3293p;

    /* renamed from: q */
    CharSequence f3294q;

    /* renamed from: r */
    ArrayList<String> f3295r;

    /* renamed from: s */
    ArrayList<String> f3296s;

    /* renamed from: t */
    boolean f3297t = false;

    /* renamed from: u */
    ArrayList<Runnable> f3298u;

    /* renamed from: androidx.fragment.a.a$a */
    /* compiled from: BackStackRecord */
    static final class C1058a {

        /* renamed from: a */
        int f3299a;

        /* renamed from: b */
        C1062d f3300b;

        /* renamed from: c */
        int f3301c;

        /* renamed from: d */
        int f3302d;

        /* renamed from: e */
        int f3303e;

        /* renamed from: f */
        int f3304f;

        C1058a() {
        }

        C1058a(int i, C1062d dVar) {
            this.f3299a = i;
            this.f3300b = dVar;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f3290m >= 0) {
            sb.append(" #");
            sb.append(this.f3290m);
        }
        if (this.f3288k != null) {
            sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            sb.append(this.f3288k);
        }
        sb.append("}");
        return sb.toString();
    }

    /* renamed from: a */
    public void mo4074a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        mo4075a(str, printWriter, true);
    }

    /* renamed from: a */
    public void mo4075a(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f3288k);
            printWriter.print(" mIndex=");
            printWriter.print(this.f3290m);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f3289l);
            if (this.f3284g != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f3284g));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.f3285h));
            }
            if (!(this.f3280c == 0 && this.f3281d == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f3280c));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f3281d));
            }
            if (!(this.f3282e == 0 && this.f3283f == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f3282e));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f3283f));
            }
            if (!(this.f3291n == 0 && this.f3292o == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f3291n));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f3292o);
            }
            if (!(this.f3293p == 0 && this.f3294q == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f3293p));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f3294q);
            }
        }
        if (!this.f3279b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("    ");
            sb.toString();
            int size = this.f3279b.size();
            for (int i = 0; i < size; i++) {
                C1058a aVar = (C1058a) this.f3279b.get(i);
                switch (aVar.f3299a) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    case 8:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    default:
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("cmd=");
                        sb2.append(aVar.f3299a);
                        str2 = sb2.toString();
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                printWriter.println(aVar.f3300b);
                if (z) {
                    if (!(aVar.f3301c == 0 && aVar.f3302d == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.f3301c));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f3302d));
                    }
                    if (aVar.f3303e != 0 || aVar.f3304f != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.f3303e));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f3304f));
                    }
                }
            }
        }
    }

    public C1057a(C1081j jVar) {
        this.f3278a = jVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4072a(C1058a aVar) {
        this.f3279b.add(aVar);
        aVar.f3301c = this.f3280c;
        aVar.f3302d = this.f3281d;
        aVar.f3303e = this.f3282e;
        aVar.f3304f = this.f3283f;
    }

    /* renamed from: a */
    public C1104o mo4069a(C1062d dVar, String str) {
        m4001a(0, dVar, str, 1);
        return this;
    }

    /* renamed from: a */
    public C1104o mo4066a(int i, C1062d dVar, String str) {
        m4001a(i, dVar, str, 1);
        return this;
    }

    /* renamed from: a */
    private void m4001a(int i, C1062d dVar, String str, int i2) {
        Class cls = dVar.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            StringBuilder sb = new StringBuilder();
            sb.append("Fragment ");
            sb.append(cls.getCanonicalName());
            sb.append(" must be a public static class to be  properly recreated from");
            sb.append(" instance state.");
            throw new IllegalStateException(sb.toString());
        }
        dVar.mFragmentManager = this.f3278a;
        if (str != null) {
            if (dVar.mTag == null || str.equals(dVar.mTag)) {
                dVar.mTag = str;
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Can't change tag of fragment ");
                sb2.append(dVar);
                sb2.append(": was ");
                sb2.append(dVar.mTag);
                sb2.append(" now ");
                sb2.append(str);
                throw new IllegalStateException(sb2.toString());
            }
        }
        if (i != 0) {
            if (i == -1) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Can't add fragment ");
                sb3.append(dVar);
                sb3.append(" with tag ");
                sb3.append(str);
                sb3.append(" to container view with no id");
                throw new IllegalArgumentException(sb3.toString());
            } else if (dVar.mFragmentId == 0 || dVar.mFragmentId == i) {
                dVar.mFragmentId = i;
                dVar.mContainerId = i;
            } else {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Can't change container ID of fragment ");
                sb4.append(dVar);
                sb4.append(": was ");
                sb4.append(dVar.mFragmentId);
                sb4.append(" now ");
                sb4.append(i);
                throw new IllegalStateException(sb4.toString());
            }
        }
        mo4072a(new C1058a(i2, dVar));
    }

    /* renamed from: b */
    public C1104o mo4079b(int i, C1062d dVar, String str) {
        if (i != 0) {
            m4001a(i, dVar, str, 2);
            return this;
        }
        throw new IllegalArgumentException("Must use non-zero containerViewId");
    }

    /* renamed from: a */
    public C1104o mo4068a(C1062d dVar) {
        mo4072a(new C1058a(3, dVar));
        return this;
    }

    /* renamed from: b */
    public C1104o mo4080b(C1062d dVar) {
        mo4072a(new C1058a(6, dVar));
        return this;
    }

    /* renamed from: c */
    public C1104o mo4085c(C1062d dVar) {
        mo4072a(new C1058a(7, dVar));
        return this;
    }

    /* renamed from: a */
    public C1104o mo4067a(View view, String str) {
        if (C1105p.m4304a()) {
            String p = C0962r.m3593p(view);
            if (p != null) {
                if (this.f3295r == null) {
                    this.f3295r = new ArrayList<>();
                    this.f3296s = new ArrayList<>();
                } else if (this.f3296s.contains(str)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("A shared element with the target name '");
                    sb.append(str);
                    sb.append("' has already been added to the transaction.");
                    throw new IllegalArgumentException(sb.toString());
                } else if (this.f3295r.contains(p)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("A shared element with the source name '");
                    sb2.append(p);
                    sb2.append(" has already been added to the transaction.");
                    throw new IllegalArgumentException(sb2.toString());
                }
                this.f3295r.add(p);
                this.f3296s.add(str);
            } else {
                throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
            }
        }
        return this;
    }

    /* renamed from: a */
    public C1104o mo4070a(String str) {
        if (this.f3287j) {
            this.f3286i = true;
            this.f3288k = str;
            return this;
        }
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    /* renamed from: a */
    public C1104o mo4065a() {
        if (!this.f3286i) {
            this.f3287j = false;
            return this;
        }
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4071a(int i) {
        if (this.f3286i) {
            if (C1081j.f3355a) {
                StringBuilder sb = new StringBuilder();
                sb.append("Bump nesting in ");
                sb.append(this);
                sb.append(" by ");
                sb.append(i);
                Log.v("FragmentManager", sb.toString());
            }
            int size = this.f3279b.size();
            for (int i2 = 0; i2 < size; i2++) {
                C1058a aVar = (C1058a) this.f3279b.get(i2);
                if (aVar.f3300b != null) {
                    aVar.f3300b.mBackStackNesting += i;
                    if (C1081j.f3355a) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Bump nesting of ");
                        sb2.append(aVar.f3300b);
                        sb2.append(" to ");
                        sb2.append(aVar.f3300b.mBackStackNesting);
                        Log.v("FragmentManager", sb2.toString());
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public void mo4081b() {
        if (this.f3298u != null) {
            int size = this.f3298u.size();
            for (int i = 0; i < size; i++) {
                ((Runnable) this.f3298u.get(i)).run();
            }
            this.f3298u = null;
        }
    }

    /* renamed from: c */
    public int mo4084c() {
        return mo4063a(false);
    }

    /* renamed from: d */
    public int mo4086d() {
        return mo4063a(true);
    }

    /* renamed from: e */
    public void mo4087e() {
        mo4065a();
        this.f3278a.mo4424b((C1095h) this, false);
    }

    /* renamed from: f */
    public void mo4088f() {
        mo4065a();
        this.f3278a.mo4424b((C1095h) this, true);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int mo4063a(boolean z) {
        if (!this.f3289l) {
            if (C1081j.f3355a) {
                StringBuilder sb = new StringBuilder();
                sb.append("Commit: ");
                sb.append(this);
                Log.v("FragmentManager", sb.toString());
                PrintWriter printWriter = new PrintWriter(new C0924b("FragmentManager"));
                mo4074a("  ", (FileDescriptor) null, printWriter, (String[]) null);
                printWriter.close();
            }
            this.f3289l = true;
            if (this.f3286i) {
                this.f3290m = this.f3278a.mo4393a(this);
            } else {
                this.f3290m = -1;
            }
            this.f3278a.mo4409a((C1095h) this, z);
            return this.f3290m;
        }
        throw new IllegalStateException("commit already called");
    }

    /* renamed from: a */
    public boolean mo4077a(ArrayList<C1057a> arrayList, ArrayList<Boolean> arrayList2) {
        if (C1081j.f3355a) {
            StringBuilder sb = new StringBuilder();
            sb.append("Run: ");
            sb.append(this);
            Log.v("FragmentManager", sb.toString());
        }
        arrayList.add(this);
        arrayList2.add(Boolean.valueOf(false));
        if (this.f3286i) {
            this.f3278a.mo4419b(this);
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo4083b(int i) {
        int size = this.f3279b.size();
        for (int i2 = 0; i2 < size; i2++) {
            C1058a aVar = (C1058a) this.f3279b.get(i2);
            int i3 = aVar.f3300b != null ? aVar.f3300b.mContainerId : 0;
            if (i3 != 0 && i3 == i) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo4076a(ArrayList<C1057a> arrayList, int i, int i2) {
        if (i2 == i) {
            return false;
        }
        int size = this.f3279b.size();
        int i3 = -1;
        for (int i4 = 0; i4 < size; i4++) {
            C1058a aVar = (C1058a) this.f3279b.get(i4);
            int i5 = aVar.f3300b != null ? aVar.f3300b.mContainerId : 0;
            if (!(i5 == 0 || i5 == i3)) {
                for (int i6 = i; i6 < i2; i6++) {
                    C1057a aVar2 = (C1057a) arrayList.get(i6);
                    int size2 = aVar2.f3279b.size();
                    for (int i7 = 0; i7 < size2; i7++) {
                        C1058a aVar3 = (C1058a) aVar2.f3279b.get(i7);
                        if ((aVar3.f3300b != null ? aVar3.f3300b.mContainerId : 0) == i5) {
                            return true;
                        }
                    }
                }
                i3 = i5;
            }
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public void mo4089g() {
        int size = this.f3279b.size();
        for (int i = 0; i < size; i++) {
            C1058a aVar = (C1058a) this.f3279b.get(i);
            C1062d dVar = aVar.f3300b;
            if (dVar != null) {
                dVar.setNextTransition(this.f3284g, this.f3285h);
            }
            int i2 = aVar.f3299a;
            if (i2 != 1) {
                switch (i2) {
                    case 3:
                        dVar.setNextAnim(aVar.f3302d);
                        this.f3278a.mo4442h(dVar);
                        break;
                    case 4:
                        dVar.setNextAnim(aVar.f3302d);
                        this.f3278a.mo4444i(dVar);
                        break;
                    case 5:
                        dVar.setNextAnim(aVar.f3301c);
                        this.f3278a.mo4447j(dVar);
                        break;
                    case 6:
                        dVar.setNextAnim(aVar.f3302d);
                        this.f3278a.mo4449k(dVar);
                        break;
                    case 7:
                        dVar.setNextAnim(aVar.f3301c);
                        this.f3278a.mo4451l(dVar);
                        break;
                    case 8:
                        this.f3278a.mo4457o(dVar);
                        break;
                    case 9:
                        this.f3278a.mo4457o(null);
                        break;
                    default:
                        StringBuilder sb = new StringBuilder();
                        sb.append("Unknown cmd: ");
                        sb.append(aVar.f3299a);
                        throw new IllegalArgumentException(sb.toString());
                }
            } else {
                dVar.setNextAnim(aVar.f3301c);
                this.f3278a.mo4407a(dVar, false);
            }
            if (!(this.f3297t || aVar.f3299a == 1 || dVar == null)) {
                this.f3278a.mo4434e(dVar);
            }
        }
        if (!this.f3297t) {
            this.f3278a.mo4397a(this.f3278a.f3373l, true);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo4082b(boolean z) {
        for (int size = this.f3279b.size() - 1; size >= 0; size--) {
            C1058a aVar = (C1058a) this.f3279b.get(size);
            C1062d dVar = aVar.f3300b;
            if (dVar != null) {
                dVar.setNextTransition(C1081j.m4155d(this.f3284g), this.f3285h);
            }
            int i = aVar.f3299a;
            if (i != 1) {
                switch (i) {
                    case 3:
                        dVar.setNextAnim(aVar.f3303e);
                        this.f3278a.mo4407a(dVar, false);
                        break;
                    case 4:
                        dVar.setNextAnim(aVar.f3303e);
                        this.f3278a.mo4447j(dVar);
                        break;
                    case 5:
                        dVar.setNextAnim(aVar.f3304f);
                        this.f3278a.mo4444i(dVar);
                        break;
                    case 6:
                        dVar.setNextAnim(aVar.f3303e);
                        this.f3278a.mo4451l(dVar);
                        break;
                    case 7:
                        dVar.setNextAnim(aVar.f3304f);
                        this.f3278a.mo4449k(dVar);
                        break;
                    case 8:
                        this.f3278a.mo4457o(null);
                        break;
                    case 9:
                        this.f3278a.mo4457o(dVar);
                        break;
                    default:
                        StringBuilder sb = new StringBuilder();
                        sb.append("Unknown cmd: ");
                        sb.append(aVar.f3299a);
                        throw new IllegalArgumentException(sb.toString());
                }
            } else {
                dVar.setNextAnim(aVar.f3304f);
                this.f3278a.mo4442h(dVar);
            }
            if (!(this.f3297t || aVar.f3299a == 3 || dVar == null)) {
                this.f3278a.mo4434e(dVar);
            }
        }
        if (!this.f3297t && z) {
            this.f3278a.mo4397a(this.f3278a.f3373l, true);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C1062d mo4064a(ArrayList<C1062d> arrayList, C1062d dVar) {
        C1062d dVar2 = dVar;
        int i = 0;
        while (i < this.f3279b.size()) {
            C1058a aVar = (C1058a) this.f3279b.get(i);
            switch (aVar.f3299a) {
                case 1:
                case 7:
                    arrayList.add(aVar.f3300b);
                    break;
                case 2:
                    C1062d dVar3 = aVar.f3300b;
                    int i2 = dVar3.mContainerId;
                    C1062d dVar4 = dVar2;
                    int i3 = i;
                    boolean z = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        C1062d dVar5 = (C1062d) arrayList.get(size);
                        if (dVar5.mContainerId == i2) {
                            if (dVar5 == dVar3) {
                                z = true;
                            } else {
                                if (dVar5 == dVar4) {
                                    this.f3279b.add(i3, new C1058a(9, dVar5));
                                    i3++;
                                    dVar4 = null;
                                }
                                C1058a aVar2 = new C1058a(3, dVar5);
                                aVar2.f3301c = aVar.f3301c;
                                aVar2.f3303e = aVar.f3303e;
                                aVar2.f3302d = aVar.f3302d;
                                aVar2.f3304f = aVar.f3304f;
                                this.f3279b.add(i3, aVar2);
                                arrayList.remove(dVar5);
                                i3++;
                            }
                        }
                    }
                    if (z) {
                        this.f3279b.remove(i3);
                        i3--;
                    } else {
                        aVar.f3299a = 1;
                        arrayList.add(dVar3);
                    }
                    i = i3;
                    dVar2 = dVar4;
                    break;
                case 3:
                case 6:
                    arrayList.remove(aVar.f3300b);
                    if (aVar.f3300b != dVar2) {
                        break;
                    } else {
                        this.f3279b.add(i, new C1058a(9, aVar.f3300b));
                        i++;
                        dVar2 = null;
                        break;
                    }
                case 8:
                    this.f3279b.add(i, new C1058a(9, dVar2));
                    i++;
                    dVar2 = aVar.f3300b;
                    break;
            }
            i++;
        }
        return dVar2;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C1062d mo4078b(ArrayList<C1062d> arrayList, C1062d dVar) {
        for (int i = 0; i < this.f3279b.size(); i++) {
            C1058a aVar = (C1058a) this.f3279b.get(i);
            int i2 = aVar.f3299a;
            if (i2 != 1) {
                if (i2 != 3) {
                    switch (i2) {
                        case 6:
                            break;
                        case 7:
                            break;
                        case 8:
                            dVar = null;
                            break;
                        case 9:
                            dVar = aVar.f3300b;
                            break;
                    }
                }
                arrayList.add(aVar.f3300b);
            }
            arrayList.remove(aVar.f3300b);
        }
        return dVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public boolean mo4090h() {
        for (int i = 0; i < this.f3279b.size(); i++) {
            if (m4002b((C1058a) this.f3279b.get(i))) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4073a(C1068c cVar) {
        for (int i = 0; i < this.f3279b.size(); i++) {
            C1058a aVar = (C1058a) this.f3279b.get(i);
            if (m4002b(aVar)) {
                aVar.f3300b.setOnStartEnterTransitionListener(cVar);
            }
        }
    }

    /* renamed from: b */
    private static boolean m4002b(C1058a aVar) {
        C1062d dVar = aVar.f3300b;
        return dVar != null && dVar.mAdded && dVar.mView != null && !dVar.mDetached && !dVar.mHidden && dVar.isPostponed();
    }

    /* renamed from: i */
    public String mo4091i() {
        return this.f3288k;
    }
}
