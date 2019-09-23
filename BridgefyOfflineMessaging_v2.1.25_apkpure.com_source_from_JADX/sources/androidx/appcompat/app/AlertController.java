package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.widget.C0616ah.C0617a;
import androidx.core.p070g.C0962r;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.NestedScrollView.C1000b;
import com.bridgefy.sdk.client.RegistrationListener;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.ref.WeakReference;

class AlertController {

    /* renamed from: A */
    private int f853A;

    /* renamed from: B */
    private boolean f854B = false;

    /* renamed from: C */
    private CharSequence f855C;

    /* renamed from: D */
    private Drawable f856D;

    /* renamed from: E */
    private CharSequence f857E;

    /* renamed from: F */
    private Drawable f858F;

    /* renamed from: G */
    private CharSequence f859G;

    /* renamed from: H */
    private Drawable f860H;

    /* renamed from: I */
    private int f861I = 0;

    /* renamed from: J */
    private Drawable f862J;

    /* renamed from: K */
    private ImageView f863K;

    /* renamed from: L */
    private TextView f864L;

    /* renamed from: M */
    private TextView f865M;

    /* renamed from: N */
    private View f866N;

    /* renamed from: O */
    private int f867O;

    /* renamed from: P */
    private int f868P;

    /* renamed from: Q */
    private boolean f869Q;

    /* renamed from: R */
    private int f870R = 0;

    /* renamed from: S */
    private final OnClickListener f871S = new OnClickListener() {
        public void onClick(View view) {
            Message message = (view != AlertController.this.f874c || AlertController.this.f875d == null) ? (view != AlertController.this.f876e || AlertController.this.f877f == null) ? (view != AlertController.this.f878g || AlertController.this.f879h == null) ? null : Message.obtain(AlertController.this.f879h) : Message.obtain(AlertController.this.f877f) : Message.obtain(AlertController.this.f875d);
            if (message != null) {
                message.sendToTarget();
            }
            AlertController.this.f887p.obtainMessage(1, AlertController.this.f872a).sendToTarget();
        }
    };

    /* renamed from: a */
    final C0470h f872a;

    /* renamed from: b */
    ListView f873b;

    /* renamed from: c */
    Button f874c;

    /* renamed from: d */
    Message f875d;

    /* renamed from: e */
    Button f876e;

    /* renamed from: f */
    Message f877f;

    /* renamed from: g */
    Button f878g;

    /* renamed from: h */
    Message f879h;

    /* renamed from: i */
    NestedScrollView f880i;

    /* renamed from: j */
    ListAdapter f881j;

    /* renamed from: k */
    int f882k = -1;

    /* renamed from: l */
    int f883l;

    /* renamed from: m */
    int f884m;

    /* renamed from: n */
    int f885n;

    /* renamed from: o */
    int f886o;

    /* renamed from: p */
    Handler f887p;

    /* renamed from: q */
    private final Context f888q;

    /* renamed from: r */
    private final Window f889r;

    /* renamed from: s */
    private final int f890s;

    /* renamed from: t */
    private CharSequence f891t;

    /* renamed from: u */
    private CharSequence f892u;

    /* renamed from: v */
    private View f893v;

    /* renamed from: w */
    private int f894w;

    /* renamed from: x */
    private int f895x;

    /* renamed from: y */
    private int f896y;

    /* renamed from: z */
    private int f897z;

    public static class RecycleListView extends ListView {

        /* renamed from: a */
        private final int f911a;

        /* renamed from: b */
        private final int f912b;

        public RecycleListView(Context context) {
            this(context, null);
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RecycleListView);
            this.f912b = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RecycleListView_paddingBottomNoButtons, -1);
            this.f911a = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RecycleListView_paddingTopNoTitle, -1);
        }

        /* renamed from: a */
        public void mo821a(boolean z, boolean z2) {
            if (!z2 || !z) {
                setPadding(getPaddingLeft(), z ? getPaddingTop() : this.f911a, getPaddingRight(), z2 ? getPaddingBottom() : this.f912b);
            }
        }
    }

    /* renamed from: androidx.appcompat.app.AlertController$a */
    public static class C0431a {

        /* renamed from: A */
        public int f913A;

        /* renamed from: B */
        public int f914B;

        /* renamed from: C */
        public int f915C;

        /* renamed from: D */
        public int f916D;

        /* renamed from: E */
        public boolean f917E = false;

        /* renamed from: F */
        public boolean[] f918F;

        /* renamed from: G */
        public boolean f919G;

        /* renamed from: H */
        public boolean f920H;

        /* renamed from: I */
        public int f921I = -1;

        /* renamed from: J */
        public OnMultiChoiceClickListener f922J;

        /* renamed from: K */
        public Cursor f923K;

        /* renamed from: L */
        public String f924L;

        /* renamed from: M */
        public String f925M;

        /* renamed from: N */
        public boolean f926N;

        /* renamed from: O */
        public OnItemSelectedListener f927O;

        /* renamed from: P */
        public C0436a f928P;

        /* renamed from: Q */
        public boolean f929Q = true;

        /* renamed from: a */
        public final Context f930a;

        /* renamed from: b */
        public final LayoutInflater f931b;

        /* renamed from: c */
        public int f932c = 0;

        /* renamed from: d */
        public Drawable f933d;

        /* renamed from: e */
        public int f934e = 0;

        /* renamed from: f */
        public CharSequence f935f;

        /* renamed from: g */
        public View f936g;

        /* renamed from: h */
        public CharSequence f937h;

        /* renamed from: i */
        public CharSequence f938i;

        /* renamed from: j */
        public Drawable f939j;

        /* renamed from: k */
        public DialogInterface.OnClickListener f940k;

        /* renamed from: l */
        public CharSequence f941l;

        /* renamed from: m */
        public Drawable f942m;

        /* renamed from: n */
        public DialogInterface.OnClickListener f943n;

        /* renamed from: o */
        public CharSequence f944o;

        /* renamed from: p */
        public Drawable f945p;

        /* renamed from: q */
        public DialogInterface.OnClickListener f946q;

        /* renamed from: r */
        public boolean f947r;

        /* renamed from: s */
        public OnCancelListener f948s;

        /* renamed from: t */
        public OnDismissListener f949t;

        /* renamed from: u */
        public OnKeyListener f950u;

        /* renamed from: v */
        public CharSequence[] f951v;

        /* renamed from: w */
        public ListAdapter f952w;

        /* renamed from: x */
        public DialogInterface.OnClickListener f953x;

        /* renamed from: y */
        public int f954y;

        /* renamed from: z */
        public View f955z;

        /* renamed from: androidx.appcompat.app.AlertController$a$a */
        public interface C0436a {
            /* renamed from: a */
            void mo828a(ListView listView);
        }

        public C0431a(Context context) {
            this.f930a = context;
            this.f947r = true;
            this.f931b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        /* renamed from: a */
        public void mo822a(AlertController alertController) {
            if (this.f936g != null) {
                alertController.mo810b(this.f936g);
            } else {
                if (this.f935f != null) {
                    alertController.mo807a(this.f935f);
                }
                if (this.f933d != null) {
                    alertController.mo805a(this.f933d);
                }
                if (this.f932c != 0) {
                    alertController.mo809b(this.f932c);
                }
                if (this.f934e != 0) {
                    alertController.mo809b(alertController.mo813c(this.f934e));
                }
            }
            if (this.f937h != null) {
                alertController.mo811b(this.f937h);
            }
            if (!(this.f938i == null && this.f939j == null)) {
                alertController.mo804a(-1, this.f938i, this.f940k, (Message) null, this.f939j);
            }
            if (!(this.f941l == null && this.f942m == null)) {
                alertController.mo804a(-2, this.f941l, this.f943n, (Message) null, this.f942m);
            }
            if (!(this.f944o == null && this.f945p == null)) {
                alertController.mo804a(-3, this.f944o, this.f946q, (Message) null, this.f945p);
            }
            if (!(this.f951v == null && this.f923K == null && this.f952w == null)) {
                m1301b(alertController);
            }
            if (this.f955z != null) {
                if (this.f917E) {
                    alertController.mo806a(this.f955z, this.f913A, this.f914B, this.f915C, this.f916D);
                    return;
                }
                alertController.mo814c(this.f955z);
            } else if (this.f954y != 0) {
                alertController.mo803a(this.f954y);
            }
        }

        /* JADX WARNING: type inference failed for: r9v0, types: [android.widget.ListAdapter] */
        /* JADX WARNING: type inference failed for: r9v1, types: [androidx.appcompat.app.AlertController$c] */
        /* JADX WARNING: type inference failed for: r9v2, types: [android.widget.ListAdapter] */
        /* JADX WARNING: type inference failed for: r2v2, types: [android.widget.SimpleCursorAdapter] */
        /* JADX WARNING: type inference failed for: r9v4 */
        /* JADX WARNING: type inference failed for: r1v23, types: [androidx.appcompat.app.AlertController$a$2] */
        /* JADX WARNING: type inference failed for: r1v24, types: [androidx.appcompat.app.AlertController$a$1] */
        /* JADX WARNING: type inference failed for: r9v7 */
        /* JADX WARNING: type inference failed for: r9v8 */
        /* JADX WARNING: type inference failed for: r1v25, types: [androidx.appcompat.app.AlertController$a$2] */
        /* JADX WARNING: type inference failed for: r1v26, types: [androidx.appcompat.app.AlertController$a$1] */
        /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r9v4
          assigns: [?[OBJECT, ARRAY], androidx.appcompat.app.AlertController$a$2, androidx.appcompat.app.AlertController$a$1]
          uses: [android.widget.ListAdapter, androidx.appcompat.app.AlertController$a$2, androidx.appcompat.app.AlertController$a$1]
          mth insns count: 73
        	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
        	at jadx.core.ProcessClass.process(ProcessClass.java:30)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
         */
        /* JADX WARNING: Unknown variable types count: 6 */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void m1301b(final androidx.appcompat.app.AlertController r11) {
            /*
                r10 = this;
                android.view.LayoutInflater r0 = r10.f931b
                int r1 = r11.f883l
                r2 = 0
                android.view.View r0 = r0.inflate(r1, r2)
                androidx.appcompat.app.AlertController$RecycleListView r0 = (androidx.appcompat.app.AlertController.RecycleListView) r0
                boolean r1 = r10.f919G
                r8 = 1
                if (r1 == 0) goto L_0x0035
                android.database.Cursor r1 = r10.f923K
                if (r1 != 0) goto L_0x0026
                androidx.appcompat.app.AlertController$a$1 r9 = new androidx.appcompat.app.AlertController$a$1
                android.content.Context r3 = r10.f930a
                int r4 = r11.f884m
                r5 = 16908308(0x1020014, float:2.3877285E-38)
                java.lang.CharSequence[] r6 = r10.f951v
                r1 = r9
                r2 = r10
                r7 = r0
                r1.<init>(r3, r4, r5, r6, r7)
                goto L_0x006e
            L_0x0026:
                androidx.appcompat.app.AlertController$a$2 r9 = new androidx.appcompat.app.AlertController$a$2
                android.content.Context r3 = r10.f930a
                android.database.Cursor r4 = r10.f923K
                r5 = 0
                r1 = r9
                r2 = r10
                r6 = r0
                r7 = r11
                r1.<init>(r3, r4, r5, r6, r7)
                goto L_0x006e
            L_0x0035:
                boolean r1 = r10.f920H
                if (r1 == 0) goto L_0x003d
                int r1 = r11.f885n
            L_0x003b:
                r4 = r1
                goto L_0x0040
            L_0x003d:
                int r1 = r11.f886o
                goto L_0x003b
            L_0x0040:
                android.database.Cursor r1 = r10.f923K
                r2 = 16908308(0x1020014, float:2.3877285E-38)
                if (r1 == 0) goto L_0x005e
                android.widget.SimpleCursorAdapter r1 = new android.widget.SimpleCursorAdapter
                android.content.Context r3 = r10.f930a
                android.database.Cursor r5 = r10.f923K
                java.lang.String[] r6 = new java.lang.String[r8]
                java.lang.String r7 = r10.f924L
                r9 = 0
                r6[r9] = r7
                int[] r7 = new int[r8]
                r7[r9] = r2
                r2 = r1
                r2.<init>(r3, r4, r5, r6, r7)
                r9 = r1
                goto L_0x006e
            L_0x005e:
                android.widget.ListAdapter r1 = r10.f952w
                if (r1 == 0) goto L_0x0065
                android.widget.ListAdapter r9 = r10.f952w
                goto L_0x006e
            L_0x0065:
                androidx.appcompat.app.AlertController$c r9 = new androidx.appcompat.app.AlertController$c
                android.content.Context r1 = r10.f930a
                java.lang.CharSequence[] r3 = r10.f951v
                r9.<init>(r1, r4, r2, r3)
            L_0x006e:
                androidx.appcompat.app.AlertController$a$a r1 = r10.f928P
                if (r1 == 0) goto L_0x0077
                androidx.appcompat.app.AlertController$a$a r1 = r10.f928P
                r1.mo828a(r0)
            L_0x0077:
                r11.f881j = r9
                int r1 = r10.f921I
                r11.f882k = r1
                android.content.DialogInterface$OnClickListener r1 = r10.f953x
                if (r1 == 0) goto L_0x008a
                androidx.appcompat.app.AlertController$a$3 r1 = new androidx.appcompat.app.AlertController$a$3
                r1.<init>(r11)
                r0.setOnItemClickListener(r1)
                goto L_0x0096
            L_0x008a:
                android.content.DialogInterface$OnMultiChoiceClickListener r1 = r10.f922J
                if (r1 == 0) goto L_0x0096
                androidx.appcompat.app.AlertController$a$4 r1 = new androidx.appcompat.app.AlertController$a$4
                r1.<init>(r0, r11)
                r0.setOnItemClickListener(r1)
            L_0x0096:
                android.widget.AdapterView$OnItemSelectedListener r1 = r10.f927O
                if (r1 == 0) goto L_0x009f
                android.widget.AdapterView$OnItemSelectedListener r1 = r10.f927O
                r0.setOnItemSelectedListener(r1)
            L_0x009f:
                boolean r1 = r10.f920H
                if (r1 == 0) goto L_0x00a7
                r0.setChoiceMode(r8)
                goto L_0x00af
            L_0x00a7:
                boolean r1 = r10.f919G
                if (r1 == 0) goto L_0x00af
                r1 = 2
                r0.setChoiceMode(r1)
            L_0x00af:
                r11.f873b = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AlertController.C0431a.m1301b(androidx.appcompat.app.AlertController):void");
        }
    }

    /* renamed from: androidx.appcompat.app.AlertController$b */
    private static final class C0437b extends Handler {

        /* renamed from: a */
        private WeakReference<DialogInterface> f968a;

        public C0437b(DialogInterface dialogInterface) {
            this.f968a = new WeakReference<>(dialogInterface);
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 1) {
                switch (i) {
                    case RegistrationListener.REGISTRATION_FAILED_INVALID /*-3*/:
                    case -2:
                    case -1:
                        ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.f968a.get(), message.what);
                        return;
                    default:
                        return;
                }
            } else {
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    /* renamed from: androidx.appcompat.app.AlertController$c */
    private static class C0438c extends ArrayAdapter<CharSequence> {
        public long getItemId(int i) {
            return (long) i;
        }

        public boolean hasStableIds() {
            return true;
        }

        public C0438c(Context context, int i, int i2, CharSequence[] charSequenceArr) {
            super(context, i, i2, charSequenceArr);
        }
    }

    /* renamed from: a */
    private static boolean m1279a(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogCenterButtons, typedValue, true);
        if (typedValue.data != 0) {
            return true;
        }
        return false;
    }

    public AlertController(Context context, C0470h hVar, Window window) {
        this.f888q = context;
        this.f872a = hVar;
        this.f889r = window;
        this.f887p = new C0437b(hVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.AlertDialog, R.attr.alertDialogStyle, 0);
        this.f867O = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_android_layout, 0);
        this.f868P = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.f883l = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_listLayout, 0);
        this.f884m = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.f885n = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.f886o = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_listItemLayout, 0);
        this.f869Q = obtainStyledAttributes.getBoolean(R.styleable.AlertDialog_showTitle, true);
        this.f890s = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AlertDialog_buttonIconDimen, 0);
        obtainStyledAttributes.recycle();
        hVar.supportRequestWindowFeature(1);
    }

    /* renamed from: a */
    static boolean m1280a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (m1280a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public void mo802a() {
        this.f872a.setContentView(m1281b());
        m1283c();
    }

    /* renamed from: b */
    private int m1281b() {
        if (this.f868P == 0) {
            return this.f867O;
        }
        if (this.f870R == 1) {
            return this.f868P;
        }
        return this.f867O;
    }

    /* renamed from: a */
    public void mo807a(CharSequence charSequence) {
        this.f891t = charSequence;
        if (this.f864L != null) {
            this.f864L.setText(charSequence);
        }
    }

    /* renamed from: b */
    public void mo810b(View view) {
        this.f866N = view;
    }

    /* renamed from: b */
    public void mo811b(CharSequence charSequence) {
        this.f892u = charSequence;
        if (this.f865M != null) {
            this.f865M.setText(charSequence);
        }
    }

    /* renamed from: a */
    public void mo803a(int i) {
        this.f893v = null;
        this.f894w = i;
        this.f854B = false;
    }

    /* renamed from: c */
    public void mo814c(View view) {
        this.f893v = view;
        this.f894w = 0;
        this.f854B = false;
    }

    /* renamed from: a */
    public void mo806a(View view, int i, int i2, int i3, int i4) {
        this.f893v = view;
        this.f894w = 0;
        this.f854B = true;
        this.f895x = i;
        this.f896y = i2;
        this.f897z = i3;
        this.f853A = i4;
    }

    /* renamed from: a */
    public void mo804a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.f887p.obtainMessage(i, onClickListener);
        }
        switch (i) {
            case RegistrationListener.REGISTRATION_FAILED_INVALID /*-3*/:
                this.f859G = charSequence;
                this.f879h = message;
                this.f860H = drawable;
                return;
            case -2:
                this.f857E = charSequence;
                this.f877f = message;
                this.f858F = drawable;
                return;
            case -1:
                this.f855C = charSequence;
                this.f875d = message;
                this.f856D = drawable;
                return;
            default:
                throw new IllegalArgumentException("Button does not exist");
        }
    }

    /* renamed from: b */
    public void mo809b(int i) {
        this.f862J = null;
        this.f861I = i;
        if (this.f863K == null) {
            return;
        }
        if (i != 0) {
            this.f863K.setVisibility(0);
            this.f863K.setImageResource(this.f861I);
            return;
        }
        this.f863K.setVisibility(8);
    }

    /* renamed from: a */
    public void mo805a(Drawable drawable) {
        this.f862J = drawable;
        this.f861I = 0;
        if (this.f863K == null) {
            return;
        }
        if (drawable != null) {
            this.f863K.setVisibility(0);
            this.f863K.setImageDrawable(drawable);
            return;
        }
        this.f863K.setVisibility(8);
    }

    /* renamed from: c */
    public int mo813c(int i) {
        TypedValue typedValue = new TypedValue();
        this.f888q.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    /* renamed from: a */
    public boolean mo808a(int i, KeyEvent keyEvent) {
        return this.f880i != null && this.f880i.mo3864a(keyEvent);
    }

    /* renamed from: b */
    public boolean mo812b(int i, KeyEvent keyEvent) {
        return this.f880i != null && this.f880i.mo3864a(keyEvent);
    }

    /* renamed from: a */
    private ViewGroup m1274a(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    /* renamed from: c */
    private void m1283c() {
        View findViewById = this.f889r.findViewById(R.id.parentPanel);
        View findViewById2 = findViewById.findViewById(R.id.topPanel);
        View findViewById3 = findViewById.findViewById(R.id.contentPanel);
        View findViewById4 = findViewById.findViewById(R.id.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById.findViewById(R.id.customPanel);
        m1276a(viewGroup);
        View findViewById5 = viewGroup.findViewById(R.id.topPanel);
        View findViewById6 = viewGroup.findViewById(R.id.contentPanel);
        View findViewById7 = viewGroup.findViewById(R.id.buttonPanel);
        ViewGroup a = m1274a(findViewById5, findViewById2);
        ViewGroup a2 = m1274a(findViewById6, findViewById3);
        ViewGroup a3 = m1274a(findViewById7, findViewById4);
        m1284c(a2);
        m1285d(a3);
        m1282b(a);
        char c = 0;
        boolean z = (viewGroup == null || viewGroup.getVisibility() == 8) ? false : true;
        boolean z2 = (a == null || a.getVisibility() == 8) ? false : true;
        boolean z3 = (a3 == null || a3.getVisibility() == 8) ? false : true;
        if (!z3 && a2 != null) {
            View findViewById8 = a2.findViewById(R.id.textSpacerNoButtons);
            if (findViewById8 != null) {
                findViewById8.setVisibility(0);
            }
        }
        if (z2) {
            if (this.f880i != null) {
                this.f880i.setClipToPadding(true);
            }
            View view = null;
            if (!(this.f892u == null && this.f873b == null)) {
                view = a.findViewById(R.id.titleDividerNoCustom);
            }
            if (view != null) {
                view.setVisibility(0);
            }
        } else if (a2 != null) {
            View findViewById9 = a2.findViewById(R.id.textSpacerNoTitle);
            if (findViewById9 != null) {
                findViewById9.setVisibility(0);
            }
        }
        if (this.f873b instanceof RecycleListView) {
            ((RecycleListView) this.f873b).mo821a(z2, z3);
        }
        if (!z) {
            View view2 = this.f873b != null ? this.f873b : this.f880i;
            if (view2 != null) {
                if (z3) {
                    c = 2;
                }
                m1277a(a2, view2, z2 | c ? 1 : 0, 3);
            }
        }
        ListView listView = this.f873b;
        if (listView != null && this.f881j != null) {
            listView.setAdapter(this.f881j);
            int i = this.f882k;
            if (i > -1) {
                listView.setItemChecked(i, true);
                listView.setSelection(i);
            }
        }
    }

    /* renamed from: a */
    private void m1277a(ViewGroup viewGroup, View view, int i, int i2) {
        final View findViewById = this.f889r.findViewById(R.id.scrollIndicatorUp);
        View findViewById2 = this.f889r.findViewById(R.id.scrollIndicatorDown);
        if (VERSION.SDK_INT >= 23) {
            C0962r.m3552a(view, i, i2);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
                return;
            }
            return;
        }
        final View view2 = null;
        if (findViewById != null && (i & 1) == 0) {
            viewGroup.removeView(findViewById);
            findViewById = null;
        }
        if (findViewById2 == null || (i & 2) != 0) {
            view2 = findViewById2;
        } else {
            viewGroup.removeView(findViewById2);
        }
        if (findViewById != null || view2 != null) {
            if (this.f892u != null) {
                this.f880i.setOnScrollChangeListener(new C1000b() {
                    /* renamed from: a */
                    public void mo816a(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                        AlertController.m1275a(nestedScrollView, findViewById, view2);
                    }
                });
                this.f880i.post(new Runnable() {
                    public void run() {
                        AlertController.m1275a(AlertController.this.f880i, findViewById, view2);
                    }
                });
            } else if (this.f873b != null) {
                this.f873b.setOnScrollListener(new OnScrollListener() {
                    public void onScrollStateChanged(AbsListView absListView, int i) {
                    }

                    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                        AlertController.m1275a(absListView, findViewById, view2);
                    }
                });
                this.f873b.post(new Runnable() {
                    public void run() {
                        AlertController.m1275a(AlertController.this.f873b, findViewById, view2);
                    }
                });
            } else {
                if (findViewById != null) {
                    viewGroup.removeView(findViewById);
                }
                if (view2 != null) {
                    viewGroup.removeView(view2);
                }
            }
        }
    }

    /* renamed from: a */
    private void m1276a(ViewGroup viewGroup) {
        boolean z = false;
        View view = this.f893v != null ? this.f893v : this.f894w != 0 ? LayoutInflater.from(this.f888q).inflate(this.f894w, viewGroup, false) : null;
        if (view != null) {
            z = true;
        }
        if (!z || !m1280a(view)) {
            this.f889r.setFlags(131072, 131072);
        }
        if (z) {
            FrameLayout frameLayout = (FrameLayout) this.f889r.findViewById(R.id.custom);
            frameLayout.addView(view, new LayoutParams(-1, -1));
            if (this.f854B) {
                frameLayout.setPadding(this.f895x, this.f896y, this.f897z, this.f853A);
            }
            if (this.f873b != null) {
                ((C0617a) viewGroup.getLayoutParams()).f1741g = BitmapDescriptorFactory.HUE_RED;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    /* renamed from: b */
    private void m1282b(ViewGroup viewGroup) {
        if (this.f866N != null) {
            viewGroup.addView(this.f866N, 0, new LayoutParams(-1, -2));
            this.f889r.findViewById(R.id.title_template).setVisibility(8);
            return;
        }
        this.f863K = (ImageView) this.f889r.findViewById(16908294);
        if (!(!TextUtils.isEmpty(this.f891t)) || !this.f869Q) {
            this.f889r.findViewById(R.id.title_template).setVisibility(8);
            this.f863K.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        this.f864L = (TextView) this.f889r.findViewById(R.id.alertTitle);
        this.f864L.setText(this.f891t);
        if (this.f861I != 0) {
            this.f863K.setImageResource(this.f861I);
        } else if (this.f862J != null) {
            this.f863K.setImageDrawable(this.f862J);
        } else {
            this.f864L.setPadding(this.f863K.getPaddingLeft(), this.f863K.getPaddingTop(), this.f863K.getPaddingRight(), this.f863K.getPaddingBottom());
            this.f863K.setVisibility(8);
        }
    }

    /* renamed from: c */
    private void m1284c(ViewGroup viewGroup) {
        this.f880i = (NestedScrollView) this.f889r.findViewById(R.id.scrollView);
        this.f880i.setFocusable(false);
        this.f880i.setNestedScrollingEnabled(false);
        this.f865M = (TextView) viewGroup.findViewById(16908299);
        if (this.f865M != null) {
            if (this.f892u != null) {
                this.f865M.setText(this.f892u);
            } else {
                this.f865M.setVisibility(8);
                this.f880i.removeView(this.f865M);
                if (this.f873b != null) {
                    ViewGroup viewGroup2 = (ViewGroup) this.f880i.getParent();
                    int indexOfChild = viewGroup2.indexOfChild(this.f880i);
                    viewGroup2.removeViewAt(indexOfChild);
                    viewGroup2.addView(this.f873b, indexOfChild, new LayoutParams(-1, -1));
                } else {
                    viewGroup.setVisibility(8);
                }
            }
        }
    }

    /* renamed from: a */
    static void m1275a(View view, View view2, View view3) {
        int i = 4;
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            if (view.canScrollVertically(1)) {
                i = 0;
            }
            view3.setVisibility(i);
        }
    }

    /* renamed from: d */
    private void m1285d(ViewGroup viewGroup) {
        boolean z;
        this.f874c = (Button) viewGroup.findViewById(16908313);
        this.f874c.setOnClickListener(this.f871S);
        boolean z2 = true;
        if (!TextUtils.isEmpty(this.f855C) || this.f856D != null) {
            this.f874c.setText(this.f855C);
            if (this.f856D != null) {
                this.f856D.setBounds(0, 0, this.f890s, this.f890s);
                this.f874c.setCompoundDrawables(this.f856D, null, null, null);
            }
            this.f874c.setVisibility(0);
            z = true;
        } else {
            this.f874c.setVisibility(8);
            z = false;
        }
        this.f876e = (Button) viewGroup.findViewById(16908314);
        this.f876e.setOnClickListener(this.f871S);
        if (!TextUtils.isEmpty(this.f857E) || this.f858F != null) {
            this.f876e.setText(this.f857E);
            if (this.f858F != null) {
                this.f858F.setBounds(0, 0, this.f890s, this.f890s);
                this.f876e.setCompoundDrawables(this.f858F, null, null, null);
            }
            this.f876e.setVisibility(0);
            z |= true;
        } else {
            this.f876e.setVisibility(8);
        }
        this.f878g = (Button) viewGroup.findViewById(16908315);
        this.f878g.setOnClickListener(this.f871S);
        if (!TextUtils.isEmpty(this.f859G) || this.f860H != null) {
            this.f878g.setText(this.f859G);
            if (this.f856D != null) {
                this.f856D.setBounds(0, 0, this.f890s, this.f890s);
                this.f874c.setCompoundDrawables(this.f856D, null, null, null);
            }
            this.f878g.setVisibility(0);
            z |= true;
        } else {
            this.f878g.setVisibility(8);
        }
        if (m1279a(this.f888q)) {
            if (z) {
                m1278a(this.f874c);
            } else if (z) {
                m1278a(this.f876e);
            } else if (z) {
                m1278a(this.f878g);
            }
        }
        if (!z) {
            z2 = false;
        }
        if (!z2) {
            viewGroup.setVisibility(8);
        }
    }

    /* renamed from: a */
    private void m1278a(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }
}
