package p140me.bridgefy.integration;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.C0840a;
import androidx.core.app.C0840a.C0842a;
import androidx.core.content.C0875a;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.bridgefy.sdk.logging.Logger;
import com.bridgefy.sdk.logging.entities.LogEntity;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.squareup.p131a.C3017h;
import me.bridgefy.main.R;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import p140me.bridgefy.ormlite.DatabaseHelper;
import p140me.bridgefy.ormlite.apptools.BridgefyOrmLiteBaseActivity;
import p140me.bridgefy.ormlite.entities.FriendDTO;

/* renamed from: me.bridgefy.integration.LogTestsActivity */
public class LogTestsActivity extends BridgefyOrmLiteBaseActivity<DatabaseHelper> implements C0842a {
    @BindView(2131296336)
    Button btnFinishTests;
    @BindView(2131296339)
    Button btnStartTests;
    @BindView(2131296340)
    Button btnUploadTests;
    @BindView(2131296509)
    TextView logView;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_log_tests);
        ButterKnife.bind((Activity) this);
        if (Logger.getInstance().getLogHashMap().get(Logger.DEVICE_STR) != null) {
            this.btnStartTests.setVisibility(8);
            this.btnFinishTests.setVisibility(0);
        }
    }

    @OnClick({2131296339})
    public void newTest() {
        if (C0875a.m3245b((Context) this, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            C0840a.m3096a(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 0);
            return;
        }
        // Logger.startLogs(m10405a());
        this.btnStartTests.setVisibility(8);
        this.btnFinishTests.setVisibility(0);
        Toast.makeText(this, "Iniciando logging", 0).show();
        finish();
    }

    @OnClick({2131296336})
    public void finishTests() {
        int stopLogs = Logger.stopLogs();
        if (stopLogs >= 0) {
            this.btnFinishTests.setVisibility(8);
            this.btnUploadTests.setVisibility(0);
            StringBuilder sb = new StringBuilder();
            sb.append("Archivo generado: ");
            sb.append(Logger.getInstance().getFileName());
            sb.append(", ");
            sb.append(stopLogs);
            sb.append(" rows.");
            Toast.makeText(this, sb.toString(), 1).show();
            return;
        }
        Toast.makeText(this, "Error creando archivo de logs.", 1).show();
    }

    @OnClick({2131296340})
    public void uploadTests() {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        StringBuilder sb = new StringBuilder();
        sb.append("file://");
        sb.append(Logger.getOrCreateFile(Logger.getInstance().getFileName()).getAbsolutePath());
        intent.putExtra("android.intent.extra.STREAM", Uri.parse(sb.toString()));
        startActivity(Intent.createChooser(intent, ""));
        this.btnUploadTests.setVisibility(8);
        this.btnStartTests.setVisibility(0);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m10406a(LogEntity logEntity) {
        TextView textView = this.logView;
        StringBuilder sb = new StringBuilder();
        sb.append(logEntity.getMessage());
        sb.append("\n");
        textView.append(sb.toString());
    }

    @C3017h
    public void consumeLog(LogEntity logEntity) {
        runOnUiThread(new Runnable(logEntity) {
            private final /* synthetic */ LogEntity f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                LogTestsActivity.this.m10406a(this.f$1);
            }
        });
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        newTest();
    }

    /* renamed from: a */
    private String m10405a() {
        LocalDateTime localDateTime = new DateTime().toLocalDateTime();
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%02d", new Object[]{Integer.valueOf(localDateTime.getYear())}));
        sb.append(String.format("%02d", new Object[]{Integer.valueOf(localDateTime.getMonthOfYear())}));
        sb.append(String.format("%02d", new Object[]{Integer.valueOf(localDateTime.getDayOfMonth())}));
        sb.append("-");
        sb.append(String.format("%02d", new Object[]{Integer.valueOf(localDateTime.getHourOfDay())}));
        sb.append(String.format("%02d", new Object[]{Integer.valueOf(localDateTime.getMinuteOfHour())}));
        sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        sb.append(Build.MANUFACTURER);
        sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        sb.append(this.settings.getString(FriendDTO.USER_NAME, ""));
        sb.append(".txt");
        return sb.toString();
    }
}
