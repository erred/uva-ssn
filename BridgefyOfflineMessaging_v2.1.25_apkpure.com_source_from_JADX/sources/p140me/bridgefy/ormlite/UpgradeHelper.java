package p140me.bridgefy.ormlite;

import android.content.res.Resources;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.p156b.C3691c;

/* renamed from: me.bridgefy.ormlite.UpgradeHelper */
public class UpgradeHelper {
    private static final String LOG_TAG = "me.bridgefy.ormlite.UpgradeHelper";
    protected static final Set<Integer> VERSION = new LinkedHashSet();

    public static final void addUpgrade(int i) {
        String str = LOG_TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("Adding ");
        sb.append(i);
        sb.append(" to upgrade path");
        Log.d(str, sb.toString());
        VERSION.add(Integer.valueOf(i));
    }

    public static List<String> availableUpdates(Resources resources) {
        String[] split;
        ArrayList arrayList = new ArrayList();
        for (Integer num : VERSION) {
            String format = String.format("updates/migration-%s.sql", new Object[]{num});
            String str = LOG_TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("Adding db version ");
            sb.append(num);
            sb.append(" to update list, loading file ");
            sb.append(format);
            Log.d(str, sb.toString());
            for (String str2 : loadAssetFile(resources, format).split("\\r?\\n")) {
                if (isNotComment(str2)) {
                    arrayList.add(str2);
                }
            }
        }
        return arrayList;
    }

    private static String loadAssetFile(Resources resources, String str) {
        try {
            InputStream open = resources.getAssets().open(str);
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.close();
            open.close();
            return byteArrayOutputStream.toString();
        } catch (IOException e) {
            String str2 = LOG_TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("IOException: ");
            sb.append(e.getMessage());
            Log.e(str2, sb.toString());
            throw new RuntimeException(e);
        }
    }

    private static boolean isNotComment(String str) {
        return !C3691c.m10979a((CharSequence) str, (CharSequence) "--") || !C3691c.m10979a((CharSequence) str, (CharSequence) "#");
    }
}
