package twitter4j;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.LinkedBlockingQueue;

final class ParseUtil {
    private static final Map<String, LinkedBlockingQueue<SimpleDateFormat>> formatMapQueue = new HashMap();

    private ParseUtil() {
        throw new AssertionError();
    }

    static String getUnescapedString(String str, JSONObject jSONObject) {
        return HTMLEntity.unescape(getRawString(str, jSONObject));
    }

    public static String getRawString(String str, JSONObject jSONObject) {
        try {
            if (jSONObject.isNull(str)) {
                return null;
            }
            return jSONObject.getString(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    static String getURLDecodedString(String str, JSONObject jSONObject) {
        String rawString = getRawString(str, jSONObject);
        if (rawString == null) {
            return rawString;
        }
        try {
            return URLDecoder.decode(rawString, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return rawString;
        }
    }

    public static Date parseTrendsDate(String str) throws TwitterException {
        int length = str.length();
        if (length == 10) {
            return new Date(Long.parseLong(str) * 1000);
        }
        if (length != 20) {
            return getDate(str, "EEE, d MMM yyyy HH:mm:ss z");
        }
        return getDate(str, "yyyy-MM-dd'T'HH:mm:ss'Z'");
    }

    public static Date getDate(String str, JSONObject jSONObject) throws TwitterException {
        return getDate(str, jSONObject, "EEE MMM d HH:mm:ss z yyyy");
    }

    public static Date getDate(String str, JSONObject jSONObject, String str2) throws TwitterException {
        String unescapedString = getUnescapedString(str, jSONObject);
        if ("null".equals(unescapedString) || unescapedString == null) {
            return null;
        }
        return getDate(unescapedString, str2);
    }

    public static Date getDate(String str, String str2) throws TwitterException {
        LinkedBlockingQueue linkedBlockingQueue = (LinkedBlockingQueue) formatMapQueue.get(str2);
        if (linkedBlockingQueue == null) {
            linkedBlockingQueue = new LinkedBlockingQueue();
            formatMapQueue.put(str2, linkedBlockingQueue);
        }
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) linkedBlockingQueue.poll();
        if (simpleDateFormat == null) {
            simpleDateFormat = new SimpleDateFormat(str2, Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        }
        try {
            Date parse = simpleDateFormat.parse(str);
            try {
                linkedBlockingQueue.put(simpleDateFormat);
            } catch (InterruptedException unused) {
            }
            return parse;
        } catch (ParseException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unexpected date format(");
            sb.append(str);
            sb.append(") returned from twitter.com");
            throw new TwitterException(sb.toString(), (Throwable) e);
        } catch (Throwable th) {
            try {
                linkedBlockingQueue.put(simpleDateFormat);
            } catch (InterruptedException unused2) {
            }
            throw th;
        }
    }

    public static int getInt(String str, JSONObject jSONObject) {
        return getInt(getRawString(str, jSONObject));
    }

    public static int getInt(String str) {
        if (str == null || "".equals(str) || "null".equals(str)) {
            return -1;
        }
        try {
            return Integer.valueOf(str).intValue();
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static long getLong(String str, JSONObject jSONObject) {
        return getLong(getRawString(str, jSONObject));
    }

    public static long getLong(String str) {
        if (str == null || "".equals(str) || "null".equals(str)) {
            return -1;
        }
        if (str.endsWith("+")) {
            return Long.valueOf(str.substring(0, str.length() - 1)).longValue() + 1;
        }
        return Long.valueOf(str).longValue();
    }

    public static double getDouble(String str, JSONObject jSONObject) {
        String rawString = getRawString(str, jSONObject);
        if (rawString == null || "".equals(rawString) || "null".equals(rawString)) {
            return -1.0d;
        }
        return Double.valueOf(rawString).doubleValue();
    }

    public static boolean getBoolean(String str, JSONObject jSONObject) {
        String rawString = getRawString(str, jSONObject);
        if (rawString == null || "null".equals(rawString)) {
            return false;
        }
        return Boolean.valueOf(rawString).booleanValue();
    }

    public static int toAccessLevel(HttpResponse httpResponse) {
        if (httpResponse == null) {
            return -1;
        }
        String responseHeader = httpResponse.getResponseHeader("X-Access-Level");
        int i = 3;
        if (responseHeader != null) {
            int length = responseHeader.length();
            if (length == 4) {
                i = 1;
            } else if (length != 10) {
                switch (length) {
                    case 25:
                    case 26:
                        break;
                }
            } else {
                i = 2;
            }
            return i;
        }
        i = 0;
        return i;
    }
}
