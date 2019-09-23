package p140me.bridgefy.main;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import java.lang.ref.WeakReference;
import p140me.bridgefy.ormlite.DatabaseHelper;
import p140me.bridgefy.ormlite.apptools.BridgefyOrmLiteBaseActivity;
import p140me.bridgefy.utils.C3659b;

/* renamed from: me.bridgefy.main.AboutActivity */
public class AboutActivity extends BridgefyOrmLiteBaseActivity<DatabaseHelper> {

    /* renamed from: a */
    private Unbinder f9455a;
    @BindView(2131296741)
    TextView view;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_about);
        this.f9455a = ButterKnife.bind((Activity) this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.about_toolbar);
        toolbar.setTitle((int) R.string.about);
        setSupportActionBar(toolbar);
        getSupportActionBar().mo854a(true);
        setTheme(R.style.BridgefyThemeInverted);
        this.view.setText("2.1.25");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        getSupportActionBar().mo852a(getResources().getDrawable(R.drawable.ic_arrow_back));
        ((LinearLayout) findViewById(R.id.about_layout)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AboutActivity.this.m10556a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m10556a(View view2) {
        finish();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f9455a.unbind();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_about, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.action_share) {
            C3659b.m10895a(new WeakReference<>(this));
        } else if (itemId == R.id.action_terms) {
            C3659b.m10891a((Context) this, "https://www.bridgefy.me/terms");
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
