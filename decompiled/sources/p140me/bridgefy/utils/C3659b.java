package p140me.bridgefy.utils;

import android.app.Activity;
import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.C0446c.C0447a;
import androidx.core.app.C0840a;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.gms.analytics.HitBuilders.EventBuilder;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.model.Circle;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import me.bridgefy.main.R;
import net.sqlcipher.database.SQLiteDatabase;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.json.JSONException;
import org.json.JSONObject;
import p140me.bridgefy.contacts.ContactsHelpActivity.C3533a;
import p140me.bridgefy.main.C3608c;

/* renamed from: me.bridgefy.utils.b */
/* compiled from: BridgefyUtils */
public class C3659b {

    /* renamed from: a */
    public static boolean f9678a = true;

    /* renamed from: b */
    private static String f9679b = "BridgefyUtils";

    /* renamed from: c */
    private static List<Integer> f9680c = Arrays.asList(new Integer[]{Integer.valueOf(-1499549), Integer.valueOf(-769226), Integer.valueOf(-16121), Integer.valueOf(-6543440), Integer.valueOf(-12627531), Integer.valueOf(-16728876), Integer.valueOf(-11751600), Integer.valueOf(-26624), Integer.valueOf(-8825528), Integer.valueOf(-10453621)});

    /* renamed from: me.bridgefy.utils.b$a */
    /* compiled from: BridgefyUtils */
    public static class C3660a {

        /* renamed from: a */
        static C3660a f9681a;

        /* renamed from: b */
        Class<?> f9682b;

        /* renamed from: c */
        String f9683c;

        /* renamed from: d */
        Object f9684d = null;

        /* renamed from: e */
        Class<?>[] f9685e = new Class[0];

        /* renamed from: f */
        Object[] f9686f = new Object[0];

        /* renamed from: a */
        public static C3660a m10913a(String str) {
            f9681a = new C3660a();
            f9681a.f9683c = str;
            return f9681a;
        }

        /* renamed from: a */
        public C3660a mo29822a(Class<?> cls) {
            f9681a.f9682b = cls;
            return f9681a;
        }

        /* renamed from: a */
        public C3660a mo29823a(Object obj) {
            f9681a.f9684d = obj;
            return f9681a;
        }

        /* renamed from: a */
        public C3660a mo29825a(Object... objArr) {
            f9681a.f9686f = objArr;
            return f9681a;
        }

        /* renamed from: a */
        public C3660a mo29824a(Class<?>... clsArr) {
            f9681a.f9685e = clsArr;
            return f9681a;
        }

        /* renamed from: a */
        public Object mo29821a() {
            Object obj;
            try {
                Method declaredMethod = this.f9682b.getDeclaredMethod(this.f9683c, this.f9685e);
                declaredMethod.setAccessible(true);
                obj = declaredMethod.invoke(this.f9684d, this.f9686f);
                try {
                    declaredMethod.setAccessible(false);
                } catch (Exception e) {
                    e = e;
                }
            } catch (Exception e2) {
                e = e2;
                obj = null;
                e.printStackTrace();
                return obj;
            }
            return obj;
        }
    }

    /* renamed from: a */
    public static long m10885a(String str) {
        byte[] bytes = str.getBytes();
        CRC32 crc32 = new CRC32();
        crc32.update(bytes, 0, bytes.length);
        return crc32.getValue();
    }

    /* renamed from: b */
    public static String m10902b(String str) {
        try {
            if (str.length() > 1) {
                String[] split = str.replace("(", "").replace(")", "").replace("+", "").split(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                if (split.length == 1) {
                    String str2 = split[0];
                    StringBuilder sb = new StringBuilder();
                    sb.append("");
                    sb.append(str2.charAt(0));
                    sb.append(str2.charAt(str2.length() - 1));
                    return sb.toString().toUpperCase();
                } else if (split.length < 2) {
                    return "--";
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("");
                    sb2.append(split[0].charAt(0));
                    sb2.append(split[1].charAt(0));
                    return sb2.toString().toUpperCase();
                }
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str.charAt(0));
                sb3.append("");
                return sb3.toString();
            }
        } catch (Exception unused) {
            return "--";
        }
    }

    /* renamed from: c */
    public static String m10905c(String str) {
        if (str.length() <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toUpperCase(str.charAt(0)));
        sb.append(str.substring(1));
        return sb.toString();
    }

    /* renamed from: d */
    public static boolean m10908d(String str) {
        return Pattern.compile("\\}").matcher(str).find() || Pattern.compile("\\{").matcher(str).find() || str.trim().length() == 0;
    }

    /* renamed from: a */
    public static void m10890a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("BgfyPrefs", 0);
        if (m10897a() || !sharedPreferences.getBoolean("showSignalBluetooth", false)) {
            Log.v(f9679b, "Bluetooth was enabled. Doing nothing.");
            return;
        }
        Log.i(f9679b, "Bluetooth wasn't enabled. Disabling it now.");
        m10892a(context, false);
        m10896a(true);
    }

    /* renamed from: b */
    public static BluetoothAdapter m10901b(Context context) {
        return ((BluetoothManager) context.getSystemService("bluetooth")).getAdapter();
    }

    /* renamed from: c */
    public static boolean m10906c(Context context) {
        return m10901b(context).isEnabled();
    }

    /* renamed from: a */
    public static void m10892a(Context context, boolean z) {
        if (z) {
            Toast.makeText(context, context.getString(R.string.enabling_bluetooth), 0).show();
            Log.i(f9679b, "Enabling Bluetooth.");
            m10901b(context).enable();
            return;
        }
        Log.i(f9679b, "Disabling Bluetooth.");
        m10901b(context).disable();
    }

    /* renamed from: a */
    public static void m10896a(boolean z) {
        f9678a = z;
    }

    /* renamed from: a */
    public static boolean m10897a() {
        return f9678a;
    }

    /* renamed from: e */
    public static boolean m10910e(String str) {
        String str2 = str.split("\\.")[1];
        try {
            str2 = new String(Base64.decode(str2, 0), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            long j = new JSONObject(str2).getLong("exp");
            Timestamp timestamp = new Timestamp(j);
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            String str3 = f9679b;
            StringBuilder sb = new StringBuilder();
            sb.append("authToken expires in: ");
            sb.append((j - currentTimeMillis) / 60);
            sb.append(" minutes.");
            Log.v(str3, sb.toString());
            return new Timestamp(currentTimeMillis).after(timestamp);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return true;
        }
    }

    /* renamed from: b */
    public static int m10900b() {
        return ((Integer) f9680c.get(m10882a(0, f9680c.size() - 1))).intValue();
    }

    /* renamed from: a */
    public static boolean m10898a(int i) {
        return f9680c.contains(Integer.valueOf(i));
    }

    /* renamed from: a */
    public static void m10893a(View view) {
        view.findViewById(R.id.inRangeBadge).setVisibility(0);
    }

    /* renamed from: b */
    public static void m10903b(View view) {
        view.findViewById(R.id.inRangeBadge).setVisibility(8);
    }

    /* renamed from: a */
    public static int m10883a(Context context, int i) {
        return (int) ((((float) i) * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: d */
    public static C0447a m10907d(Context context) {
        return new C0447a(context, R.style.DialogTheme);
    }

    /* renamed from: a */
    public static int m10884a(Circle circle) {
        return (int) (16.0d - (Math.log(circle.getRadius() / 500.0d) / Math.log(2.0d)));
    }

    /* renamed from: a */
    public static void m10887a(Activity activity) {
        SharedPreferences sharedPreferences = activity.getSharedPreferences("BgfyPrefs", 0);
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("message/rfc822");
        intent.putExtra("android.intent.extra.EMAIL", new String[]{"android@bridgefy.me"});
        intent.putExtra("android.intent.extra.SUBJECT", activity.getString(R.string.email_subject));
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n--\nBridgefy 2.1.25 (82)\n");
        sb.append(Build.MANUFACTURER);
        sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        sb.append(Build.MODEL);
        sb.append(", Android ");
        sb.append(VERSION.SDK_INT);
        sb.append(" (");
        sb.append(VERSION.RELEASE);
        sb.append(")\nSession State: ");
        sb.append(C3608c.m10639a());
        sb.append("\nDevice Evaluation: ");
        sb.append(sharedPreferences.getString("advertising", "N/A"));
        sb.append("\n--\n\n\n");
        intent.putExtra("android.intent.extra.TEXT", sb.toString());
        try {
            activity.startActivity(Intent.createChooser(intent, activity.getString(R.string.settings_contact_us_title)));
        } catch (ActivityNotFoundException unused) {
            new C3533a().show(activity.getFragmentManager(), C3533a.f9205a);
        }
    }

    /* renamed from: a */
    public static void m10891a(Context context, String str) {
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(context, R.string.activity_not_found, 1).show();
        }
    }

    /* renamed from: a */
    public static void m10895a(WeakReference<Context> weakReference) {
        Intent intent = new Intent("android.intent.action.SEND");
        try {
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.SUBJECT", ((Context) weakReference.get()).getString(R.string.share_subject));
            intent.putExtra("android.intent.extra.TEXT", ((Context) weakReference.get()).getString(R.string.share_body));
            ((Context) weakReference.get()).startActivity(Intent.createChooser(intent, ((Context) weakReference.get()).getString(R.string.share_bridgefy)));
        } catch (Exception e) {
            Toast.makeText((Context) weakReference.get(), ((Context) weakReference.get()).getString(R.string.error), 0).show();
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static void m10894a(String str, String str2, String str3, long j, Tracker tracker) {
        if (tracker != null) {
            EventBuilder eventBuilder = new EventBuilder();
            eventBuilder.setCategory(str);
            eventBuilder.setAction(str2);
            eventBuilder.setLabel(str3);
            eventBuilder.setValue(j);
            tracker.send(eventBuilder.build());
        }
    }

    /* renamed from: a */
    public static void m10888a(Activity activity, int i) {
        Intent intent;
        try {
            intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            StringBuilder sb = new StringBuilder();
            sb.append("package:");
            sb.append(activity.getPackageName());
            intent.setData(Uri.parse(sb.toString()));
        } catch (ActivityNotFoundException unused) {
            intent = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
        }
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        activity.startActivityForResult(intent, i);
    }

    /* renamed from: a */
    public static void m10889a(Activity activity, String[] strArr, int i) {
        if (strArr.length > 0) {
            SharedPreferences sharedPreferences = activity.getSharedPreferences("BgfyPrefs", 0);
            if (m10899a(sharedPreferences, activity, strArr[0])) {
                m10888a(activity, i);
            } else {
                C0840a.m3096a(activity, strArr, i);
            }
            sharedPreferences.edit().putBoolean(strArr[0], true).apply();
            return;
        }
        Toast.makeText(activity, activity.getString(R.string.error_try_again), 0).show();
    }

    /* renamed from: a */
    private static boolean m10899a(SharedPreferences sharedPreferences, Activity activity, String str) {
        if (C0840a.m3097a(activity, str) || !sharedPreferences.getBoolean(str, false)) {
            return false;
        }
        return true;
    }

    /* renamed from: f */
    public static int m10911f(String str) throws NumberFormatException {
        String normalizeDigitsOnly = PhoneNumberUtil.normalizeDigitsOnly(str);
        return Integer.parseInt(normalizeDigitsOnly.substring(0, normalizeDigitsOnly.length() - 10));
    }

    /* renamed from: a */
    public static int m10882a(int i, int i2) {
        return new Random().nextInt((i2 - i) + 1) + i;
    }

    /* renamed from: g */
    public static boolean m10912g(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    /* renamed from: e */
    public static boolean m10909e(Context context) {
        boolean hasSystemFeature = context.getPackageManager().hasSystemFeature("android.hardware.telephony");
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            boolean z = true;
            if (telephonyManager.getPhoneType() == 1) {
                if (!hasSystemFeature || telephonyManager.getSimState() != 5) {
                    z = false;
                }
                return z;
            }
        }
        return hasSystemFeature;
    }

    /* renamed from: b */
    public static boolean m10904b(WeakReference<Activity> weakReference) {
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable((Context) weakReference.get());
        if (isGooglePlayServicesAvailable == 0) {
            return true;
        }
        Dialog errorDialog = GooglePlayServicesUtil.getErrorDialog(isGooglePlayServicesAvailable, (Activity) weakReference.get(), 999);
        if (errorDialog != null) {
            errorDialog.show();
        } else {
            Log.e(f9679b, "Google Play Services weren't found ¯\\_(ツ)_/¯");
            Toast.makeText((Context) weakReference.get(), ((Activity) weakReference.get()).getResources().getString(R.string.error_play_services_unavailable), 1).show();
            ((Activity) weakReference.get()).finish();
        }
        return false;
    }

    /* renamed from: a */
    public static String m10886a(Resources resources, String str) {
        LocalDateTime localDateTime = new DateTime().toLocalDateTime();
        try {
            LocalDateTime localDateTime2 = new DateTime(Long.parseLong(str)).toLocalDateTime();
            if (localDateTime.getDayOfMonth() == localDateTime2.getDayOfMonth()) {
                StringBuilder sb = new StringBuilder();
                sb.append(String.format("%02d", new Object[]{Integer.valueOf(localDateTime2.getHourOfDay())}));
                sb.append(":");
                sb.append(String.format("%02d", new Object[]{Integer.valueOf(localDateTime2.getMinuteOfHour())}));
                return sb.toString();
            } else if (localDateTime2.getDayOfMonth() == localDateTime.minusDays(1).getDayOfMonth()) {
                return resources.getString(R.string.message_date_yesterday);
            } else {
                if (localDateTime.minusDays(6).isBefore(localDateTime2)) {
                    return resources.getStringArray(R.array.days_of_the_week)[localDateTime2.getDayOfWeek() - 1];
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(String.format("%02d", new Object[]{Integer.valueOf(localDateTime2.getDayOfMonth())}));
                sb2.append("/");
                sb2.append(String.format("%02d", new Object[]{Integer.valueOf(localDateTime2.getMonthOfYear())}));
                sb2.append("/");
                sb2.append(String.format("%02d", new Object[]{Integer.valueOf(localDateTime2.getYear())}));
                return sb2.toString();
            }
        } catch (IllegalArgumentException unused) {
            return "";
        }
    }
}
