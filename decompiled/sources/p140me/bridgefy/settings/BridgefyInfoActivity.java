package p140me.bridgefy.settings;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.C0448d;
import androidx.appcompat.widget.Toolbar;
import me.bridgefy.main.R;

/* renamed from: me.bridgefy.settings.BridgefyInfoActivity */
public class BridgefyInfoActivity extends C0448d {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_bridgefy_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.sdk_info_toolbar);
        toolbar.setTitle((int) R.string.sdk_text);
        setSupportActionBar(toolbar);
        getSupportActionBar().mo854a(true);
        setTheme(R.style.SettingsTheme);
        SharedPreferences sharedPreferences = getSharedPreferences("BgfyPrefs", 0);
        if (sharedPreferences.getBoolean("tooltipSDK", true)) {
            sharedPreferences.edit().putBoolean("tooltipSDK", false).apply();
        }
    }
}
