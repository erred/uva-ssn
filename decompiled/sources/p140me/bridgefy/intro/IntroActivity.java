package p140me.bridgefy.intro;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.p081a.C1062d;
import androidx.fragment.p081a.C1078i;
import androidx.fragment.p081a.C1101m;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.C1476g;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.viewpagerindicator.CirclePageIndicator;
import java.lang.ref.WeakReference;
import me.bridgefy.main.R;
import net.sqlcipher.database.SQLiteDatabase;
import p140me.bridgefy.main.BridgefyApp;
import p140me.bridgefy.main.C3608c;
import p140me.bridgefy.ormlite.DatabaseHelper;
import p140me.bridgefy.ormlite.apptools.BridgefyOrmLiteBaseActivity;
import p140me.bridgefy.utils.C3659b;

/* renamed from: me.bridgefy.intro.IntroActivity */
public class IntroActivity extends BridgefyOrmLiteBaseActivity<DatabaseHelper> {

    /* renamed from: a */
    C3553b f9303a;
    @BindView(2131296341)
    Button btnGetStarted;
    @BindView(2131296539)
    ViewPager mViewPager;
    @BindView(2131296748)
    CirclePageIndicator titleIndicator;

    /* renamed from: me.bridgefy.intro.IntroActivity$a */
    public static class C3552a extends C1062d {

        /* renamed from: a */
        public Activity f9304a = null;

        /* renamed from: a */
        public static C3552a m10430a(int i, int i2, int i3, int i4) {
            C3552a aVar = new C3552a();
            Bundle bundle = new Bundle();
            bundle.putInt("drawableId", i);
            bundle.putInt("stringId", i3);
            bundle.putInt("titleId", i2);
            bundle.putInt("position", i4);
            aVar.setArguments(bundle);
            return aVar;
        }

        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View inflate = layoutInflater.inflate(R.layout.fragment_intro, viewGroup, false);
            TextView textView = (TextView) inflate.findViewById(R.id.description);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.image);
            ((TextView) inflate.findViewById(R.id.title)).setText(getResources().getString(getArguments().getInt("titleId")));
            textView.setText(getResources().getString(getArguments().getInt("stringId")));
            imageView.setImageDrawable(getResources().getDrawable(getArguments().getInt("drawableId")));
            return inflate;
        }
    }

    /* renamed from: me.bridgefy.intro.IntroActivity$b */
    public class C3553b extends C1101m {
        /* renamed from: b */
        public int mo6151b() {
            return 3;
        }

        /* renamed from: c */
        public CharSequence mo6155c(int i) {
            return "";
        }

        public C3553b(C1078i iVar) {
            super(iVar);
        }

        /* renamed from: a */
        public C1062d mo4498a(int i) {
            C3552a aVar;
            switch (i) {
                case 0:
                    aVar = C3552a.m10430a(R.drawable.il_1, R.string.title_1, R.string.intro_1, i);
                    break;
                case 1:
                    aVar = C3552a.m10430a(R.drawable.il_2, R.string.title_2, R.string.intro_2, i);
                    break;
                case 2:
                    aVar = C3552a.m10430a(R.drawable.il_3, R.string.title_3, R.string.intro_3, i);
                    break;
                default:
                    aVar = null;
                    break;
            }
            aVar.f9304a = IntroActivity.this;
            return aVar;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_intro);
        ButterKnife.bind((Activity) this);
        this.f9303a = new C3553b(getSupportFragmentManager());
        this.mViewPager.setAdapter(this.f9303a);
        this.mViewPager.mo6070a(true, (C1476g) new C3569a());
        float f = getResources().getDisplayMetrics().density;
        this.titleIndicator.setViewPager(this.mViewPager);
        this.titleIndicator.setStrokeWidth(BitmapDescriptorFactory.HUE_RED);
        this.titleIndicator.setFillColor(getResources().getColor(R.color.white));
        this.titleIndicator.setPageColor(getResources().getColor(R.color.white_transparent));
        this.titleIndicator.setRadius(f * 5.0f);
        this.titleIndicator.setPadding(20, 2, 20, 0);
        if (!C3659b.m10904b(new WeakReference<>(this))) {
            Log.e("IntroActivity", "onCreate(): Google Play Services Unavailable");
            this.btnGetStarted.setEnabled(false);
        }
    }

    @OnClick({2131296644})
    public void onClick() {
        C3659b.m10891a((Context) this, "https://www.bridgefy.me/terms");
    }

    @OnClick({2131296341})
    public void startLoginWorkflow() {
        C3659b.m10894a("Session", "newDigitsUserIntent", null, 0, BridgefyApp.m10557c().mo29529e());
        C3608c.m10647b(getBaseContext());
        startActivityForResult(new Intent(getApplicationContext(), VerificationActivity.class).putExtra("requestCode", 1313), 1313);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i != 1313) {
            return;
        }
        if (i2 == -1) {
            startActivity(new Intent(getApplicationContext(), SignupActivity.class).putExtras(intent.getExtras()).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY));
            finish();
            return;
        }
        Log.e("IntroActivity", "Unsuccessful verification");
    }
}
