package twitter4j;

import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.TreeSet;

public class JSONObject {
    public static final Object NULL = new Null();
    private final Map map;

    private static final class Null {
        /* access modifiers changed from: protected */
        public final Object clone() {
            return this;
        }

        public boolean equals(Object obj) {
            return obj == null || obj == this;
        }

        public String toString() {
            return "null";
        }

        private Null() {
        }
    }

    public JSONObject() {
        this.map = new HashMap();
    }

    public JSONObject(JSONObject jSONObject, String[] strArr) {
        this();
        for (String str : strArr) {
            try {
                putOnce(str, jSONObject.opt(str));
            } catch (Exception unused) {
            }
        }
    }

    public JSONObject(JSONTokener jSONTokener) throws JSONException {
        this();
        if (jSONTokener.nextClean() == '{') {
            while (true) {
                char nextClean = jSONTokener.nextClean();
                if (nextClean == 0) {
                    throw jSONTokener.syntaxError("A JSONObject text must end with '}'");
                } else if (nextClean != '}') {
                    jSONTokener.back();
                    String obj = jSONTokener.nextValue().toString();
                    char nextClean2 = jSONTokener.nextClean();
                    if (nextClean2 == '=') {
                        if (jSONTokener.next() != '>') {
                            jSONTokener.back();
                        }
                    } else if (nextClean2 != ':') {
                        throw jSONTokener.syntaxError("Expected a ':' after a key");
                    }
                    putOnce(obj, jSONTokener.nextValue());
                    char nextClean3 = jSONTokener.nextClean();
                    if (nextClean3 == ',' || nextClean3 == ';') {
                        if (jSONTokener.nextClean() != '}') {
                            jSONTokener.back();
                        } else {
                            return;
                        }
                    } else if (nextClean3 != '}') {
                        throw jSONTokener.syntaxError("Expected a ',' or '}'");
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("A JSONObject text must begin with '{' found:");
            sb.append(jSONTokener.nextClean());
            throw jSONTokener.syntaxError(sb.toString());
        }
    }

    public JSONObject(Map map2) {
        this.map = new HashMap();
        if (map2 != null) {
            for (Entry entry : map2.entrySet()) {
                Object value = entry.getValue();
                if (value != null) {
                    this.map.put(entry.getKey(), wrap(value));
                }
            }
        }
    }

    public JSONObject(Object obj) {
        this();
        populateMap(obj);
    }

    public JSONObject(Object obj, String[] strArr) {
        this();
        Class cls = obj.getClass();
        for (String str : strArr) {
            try {
                putOpt(str, cls.getField(str).get(obj));
            } catch (Exception unused) {
            }
        }
    }

    public JSONObject(String str) throws JSONException {
        this(new JSONTokener(str));
    }

    public JSONObject(String str, Locale locale) throws JSONException {
        this();
        ResourceBundle bundle = ResourceBundle.getBundle(str, locale, Thread.currentThread().getContextClassLoader());
        Enumeration keys = bundle.getKeys();
        while (keys.hasMoreElements()) {
            Object nextElement = keys.nextElement();
            if (nextElement instanceof String) {
                String str2 = (String) nextElement;
                String[] split = str2.split("\\.");
                int length = split.length - 1;
                JSONObject jSONObject = this;
                for (int i = 0; i < length; i++) {
                    String str3 = split[i];
                    Object opt = jSONObject.opt(str3);
                    JSONObject jSONObject2 = opt instanceof JSONObject ? (JSONObject) opt : null;
                    if (jSONObject2 == null) {
                        jSONObject2 = new JSONObject();
                        jSONObject.put(str3, (Object) jSONObject2);
                    }
                    jSONObject = jSONObject2;
                }
                jSONObject.put(split[length], (Object) bundle.getString(str2));
            }
        }
    }

    public JSONObject append(String str, Object obj) throws JSONException {
        testValidity(obj);
        Object opt = opt(str);
        if (opt == null) {
            put(str, (Object) new JSONArray().put(obj));
        } else if (opt instanceof JSONArray) {
            put(str, (Object) ((JSONArray) opt).put(obj));
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("JSONObject[");
            sb.append(str);
            sb.append("] is not a JSONArray.");
            throw new JSONException(sb.toString());
        }
        return this;
    }

    public Object get(String str) throws JSONException {
        if (str != null) {
            Object opt = opt(str);
            if (opt != null) {
                return opt;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("JSONObject[");
            sb.append(quote(str));
            sb.append("] not found.");
            throw new JSONException(sb.toString());
        }
        throw new JSONException("Null key.");
    }

    public boolean getBoolean(String str) throws JSONException {
        Object obj = get(str);
        if (!obj.equals(Boolean.FALSE)) {
            boolean z = obj instanceof String;
            if (!z || !((String) obj).equalsIgnoreCase("false")) {
                if (obj.equals(Boolean.TRUE) || (z && ((String) obj).equalsIgnoreCase("true"))) {
                    return true;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("JSONObject[");
                sb.append(quote(str));
                sb.append("] is not a Boolean.");
                throw new JSONException(sb.toString());
            }
        }
        return false;
    }

    public int getInt(String str) throws JSONException {
        Object obj = get(str);
        try {
            if (obj instanceof Number) {
                return ((Number) obj).intValue();
            }
            return Integer.parseInt((String) obj);
        } catch (Exception unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("JSONObject[");
            sb.append(quote(str));
            sb.append("] is not an int.");
            throw new JSONException(sb.toString());
        }
    }

    public JSONArray getJSONArray(String str) throws JSONException {
        Object obj = get(str);
        if (obj instanceof JSONArray) {
            return (JSONArray) obj;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("JSONObject[");
        sb.append(quote(str));
        sb.append("] is not a JSONArray.");
        throw new JSONException(sb.toString());
    }

    public JSONObject getJSONObject(String str) throws JSONException {
        Object obj = get(str);
        if (obj instanceof JSONObject) {
            return (JSONObject) obj;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("JSONObject[");
        sb.append(quote(str));
        sb.append("] is not a JSONObject.");
        throw new JSONException(sb.toString());
    }

    public long getLong(String str) throws JSONException {
        Object obj = get(str);
        try {
            if (obj instanceof Number) {
                return ((Number) obj).longValue();
            }
            return Long.parseLong((String) obj);
        } catch (Exception unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("JSONObject[");
            sb.append(quote(str));
            sb.append("] is not a long.");
            throw new JSONException(sb.toString());
        }
    }

    public String getString(String str) throws JSONException {
        Object obj = get(str);
        if (obj == NULL) {
            return null;
        }
        return obj.toString();
    }

    public boolean has(String str) {
        return this.map.containsKey(str);
    }

    public boolean isNull(String str) {
        return NULL.equals(opt(str));
    }

    public Iterator keys() {
        return this.map.keySet().iterator();
    }

    public int length() {
        return this.map.size();
    }

    public JSONArray names() {
        JSONArray jSONArray = new JSONArray();
        Iterator keys = keys();
        while (keys.hasNext()) {
            jSONArray.put(keys.next());
        }
        if (jSONArray.length() == 0) {
            return null;
        }
        return jSONArray;
    }

    public static String numberToString(Number number) throws JSONException {
        if (number != null) {
            testValidity(number);
            String obj = number.toString();
            if (obj.indexOf(46) <= 0 || obj.indexOf(101) >= 0 || obj.indexOf(69) >= 0) {
                return obj;
            }
            while (obj.endsWith("0")) {
                obj = obj.substring(0, obj.length() - 1);
            }
            return obj.endsWith(".") ? obj.substring(0, obj.length() - 1) : obj;
        }
        throw new JSONException("Null pointer");
    }

    public Object opt(String str) {
        if (str == null) {
            return null;
        }
        return this.map.get(str);
    }

    private void populateMap(Object obj) {
        Method[] methods;
        Class cls = obj.getClass();
        for (Method method : cls.getClassLoader() != null ? cls.getMethods() : cls.getDeclaredMethods()) {
            try {
                if (Modifier.isPublic(method.getModifiers())) {
                    String name = method.getName();
                    String str = "";
                    if (name.startsWith("get")) {
                        if (!name.equals("getClass")) {
                            if (!name.equals("getDeclaringClass")) {
                                str = name.substring(3);
                            }
                        }
                        str = "";
                    } else if (name.startsWith("is")) {
                        str = name.substring(2);
                    }
                    if (str.length() > 0 && Character.isUpperCase(str.charAt(0)) && method.getParameterTypes().length == 0) {
                        if (str.length() == 1) {
                            str = str.toLowerCase();
                        } else if (!Character.isUpperCase(str.charAt(1))) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(str.substring(0, 1).toLowerCase());
                            sb.append(str.substring(1));
                            str = sb.toString();
                        }
                        Object invoke = method.invoke(obj, null);
                        if (invoke != null) {
                            this.map.put(str, wrap(invoke));
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public JSONObject put(String str, boolean z) throws JSONException {
        put(str, (Object) z ? Boolean.TRUE : Boolean.FALSE);
        return this;
    }

    public JSONObject put(String str, Collection collection) throws JSONException {
        put(str, (Object) new JSONArray(collection));
        return this;
    }

    public JSONObject put(String str, double d) throws JSONException {
        put(str, (Object) new Double(d));
        return this;
    }

    public JSONObject put(String str, int i) throws JSONException {
        put(str, (Object) new Integer(i));
        return this;
    }

    public JSONObject put(String str, long j) throws JSONException {
        put(str, (Object) new Long(j));
        return this;
    }

    public JSONObject put(String str, Map map2) throws JSONException {
        put(str, (Object) new JSONObject(map2));
        return this;
    }

    public JSONObject put(String str, Object obj) throws JSONException {
        if (str != null) {
            if (obj != null) {
                testValidity(obj);
                this.map.put(str, obj);
            } else {
                remove(str);
            }
            return this;
        }
        throw new JSONException("Null key.");
    }

    public JSONObject putOnce(String str, Object obj) throws JSONException {
        if (!(str == null || obj == null)) {
            if (opt(str) == null) {
                put(str, obj);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Duplicate key \"");
                sb.append(str);
                sb.append("\"");
                throw new JSONException(sb.toString());
            }
        }
        return this;
    }

    public JSONObject putOpt(String str, Object obj) throws JSONException {
        if (!(str == null || obj == null)) {
            put(str, obj);
        }
        return this;
    }

    public static String quote(String str) {
        if (str == null || str.length() == 0) {
            return "\"\"";
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder(length + 4);
        sb.append('\"');
        int i = 0;
        char c = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt != '\"') {
                if (charAt != '/') {
                    if (charAt != '\\') {
                        switch (charAt) {
                            case 8:
                                sb.append("\\b");
                                break;
                            case 9:
                                sb.append("\\t");
                                break;
                            case 10:
                                sb.append("\\n");
                                break;
                            default:
                                switch (charAt) {
                                    case 12:
                                        sb.append("\\f");
                                        break;
                                    case 13:
                                        sb.append("\\r");
                                        break;
                                    default:
                                        if (charAt >= ' ' && ((charAt < 128 || charAt >= 160) && (charAt < 8192 || charAt >= 8448))) {
                                            sb.append(charAt);
                                            break;
                                        } else {
                                            StringBuilder sb2 = new StringBuilder();
                                            sb2.append("000");
                                            sb2.append(Integer.toHexString(charAt));
                                            String sb3 = sb2.toString();
                                            sb.append("\\u");
                                            sb.append(sb3.substring(sb3.length() - 4));
                                            break;
                                        }
                                }
                        }
                    }
                } else {
                    if (c == '<') {
                        sb.append('\\');
                    }
                    sb.append(charAt);
                }
                i++;
                c = charAt;
            }
            sb.append('\\');
            sb.append(charAt);
            i++;
            c = charAt;
        }
        sb.append('\"');
        return sb.toString();
    }

    public Object remove(String str) {
        return this.map.remove(str);
    }

    public Iterator sortedKeys() {
        return new TreeSet(this.map.keySet()).iterator();
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x006c */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0083 A[Catch:{ Exception -> 0x00a5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0084 A[Catch:{ Exception -> 0x00a5 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object stringToValue(java.lang.String r5) {
        /*
            java.lang.String r0 = ""
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0009
            return r5
        L_0x0009:
            java.lang.String r0 = "true"
            boolean r0 = r5.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x0014
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            return r5
        L_0x0014:
            java.lang.String r0 = "false"
            boolean r0 = r5.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x001f
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            return r5
        L_0x001f:
            java.lang.String r0 = "null"
            boolean r0 = r5.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x002a
            java.lang.Object r5 = NULL
            return r5
        L_0x002a:
            r0 = 0
            char r0 = r5.charAt(r0)
            r1 = 46
            r2 = 48
            if (r0 < r2) goto L_0x0039
            r3 = 57
            if (r0 <= r3) goto L_0x0043
        L_0x0039:
            if (r0 == r1) goto L_0x0043
            r3 = 45
            if (r0 == r3) goto L_0x0043
            r3 = 43
            if (r0 != r3) goto L_0x00a5
        L_0x0043:
            if (r0 != r2) goto L_0x006c
            int r0 = r5.length()
            r2 = 2
            if (r0 <= r2) goto L_0x006c
            r0 = 1
            char r3 = r5.charAt(r0)
            r4 = 120(0x78, float:1.68E-43)
            if (r3 == r4) goto L_0x005d
            char r0 = r5.charAt(r0)
            r3 = 88
            if (r0 != r3) goto L_0x006c
        L_0x005d:
            java.lang.String r0 = r5.substring(r2)     // Catch:{ Exception -> 0x006c }
            r2 = 16
            int r0 = java.lang.Integer.parseInt(r0, r2)     // Catch:{ Exception -> 0x006c }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x006c }
            return r0
        L_0x006c:
            int r0 = r5.indexOf(r1)     // Catch:{ Exception -> 0x00a5 }
            r1 = -1
            if (r0 > r1) goto L_0x00a0
            r0 = 101(0x65, float:1.42E-43)
            int r0 = r5.indexOf(r0)     // Catch:{ Exception -> 0x00a5 }
            if (r0 > r1) goto L_0x00a0
            r0 = 69
            int r0 = r5.indexOf(r0)     // Catch:{ Exception -> 0x00a5 }
            if (r0 <= r1) goto L_0x0084
            goto L_0x00a0
        L_0x0084:
            java.lang.Long r0 = new java.lang.Long     // Catch:{ Exception -> 0x00a5 }
            r0.<init>(r5)     // Catch:{ Exception -> 0x00a5 }
            long r1 = r0.longValue()     // Catch:{ Exception -> 0x00a5 }
            int r3 = r0.intValue()     // Catch:{ Exception -> 0x00a5 }
            long r3 = (long) r3     // Catch:{ Exception -> 0x00a5 }
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x009f
            int r0 = r0.intValue()     // Catch:{ Exception -> 0x00a5 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x00a5 }
            return r0
        L_0x009f:
            return r0
        L_0x00a0:
            java.lang.Double r0 = java.lang.Double.valueOf(r5)     // Catch:{ Exception -> 0x00a5 }
            return r0
        L_0x00a5:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: twitter4j.JSONObject.stringToValue(java.lang.String):java.lang.Object");
    }

    public static void testValidity(Object obj) throws JSONException {
        if (obj == null) {
            return;
        }
        if (obj instanceof Double) {
            Double d = (Double) obj;
            if (d.isInfinite() || d.isNaN()) {
                throw new JSONException("JSON does not allow non-finite numbers.");
            }
        } else if (obj instanceof Float) {
            Float f = (Float) obj;
            if (f.isInfinite() || f.isNaN()) {
                throw new JSONException("JSON does not allow non-finite numbers.");
            }
        }
    }

    public String toString() {
        try {
            Iterator keys = keys();
            StringBuilder sb = new StringBuilder("{");
            while (keys.hasNext()) {
                if (sb.length() > 1) {
                    sb.append(',');
                }
                Object next = keys.next();
                sb.append(quote(next.toString()));
                sb.append(':');
                sb.append(valueToString(this.map.get(next)));
            }
            sb.append('}');
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public String toString(int i) throws JSONException {
        return toString(i, 0);
    }

    /* access modifiers changed from: 0000 */
    public String toString(int i, int i2) throws JSONException {
        int i3;
        int length = length();
        if (length == 0) {
            return "{}";
        }
        Iterator sortedKeys = sortedKeys();
        int i4 = i2 + i;
        StringBuilder sb = new StringBuilder("{");
        if (length == 1) {
            Object next = sortedKeys.next();
            sb.append(quote(next.toString()));
            sb.append(": ");
            sb.append(valueToString(this.map.get(next), i, i2));
        } else {
            while (true) {
                i3 = 0;
                if (!sortedKeys.hasNext()) {
                    break;
                }
                Object next2 = sortedKeys.next();
                if (sb.length() > 1) {
                    sb.append(",\n");
                } else {
                    sb.append(10);
                }
                while (i3 < i4) {
                    sb.append(' ');
                    i3++;
                }
                sb.append(quote(next2.toString()));
                sb.append(": ");
                sb.append(valueToString(this.map.get(next2), i, i4));
            }
            if (sb.length() > 1) {
                sb.append(10);
                while (i3 < i2) {
                    sb.append(' ');
                    i3++;
                }
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public static String valueToString(Object obj) throws JSONException {
        if (obj == null || obj.equals(null)) {
            return "null";
        }
        if (obj instanceof Number) {
            return numberToString((Number) obj);
        }
        if ((obj instanceof Boolean) || (obj instanceof JSONObject) || (obj instanceof JSONArray)) {
            return obj.toString();
        }
        if (obj instanceof Map) {
            return new JSONObject((Map) obj).toString();
        }
        if (obj instanceof Collection) {
            return new JSONArray((Collection) obj).toString();
        }
        if (obj.getClass().isArray()) {
            return new JSONArray(obj).toString();
        }
        return quote(obj.toString());
    }

    static String valueToString(Object obj, int i, int i2) throws JSONException {
        if (obj == null || obj.equals(null)) {
            return "null";
        }
        if (obj instanceof Number) {
            return numberToString((Number) obj);
        }
        if (obj instanceof Boolean) {
            return obj.toString();
        }
        if (obj instanceof JSONObject) {
            return ((JSONObject) obj).toString(i, i2);
        }
        if (obj instanceof JSONArray) {
            return ((JSONArray) obj).toString(i, i2);
        }
        if (obj instanceof Map) {
            return new JSONObject((Map) obj).toString(i, i2);
        }
        if (obj instanceof Collection) {
            return new JSONArray((Collection) obj).toString(i, i2);
        }
        if (obj.getClass().isArray()) {
            return new JSONArray(obj).toString(i, i2);
        }
        return quote(obj.toString());
    }

    public static Object wrap(Object obj) {
        if (obj == null) {
            try {
                return NULL;
            } catch (Exception unused) {
                return null;
            }
        } else {
            if (!(obj instanceof JSONObject) && !(obj instanceof JSONArray) && !NULL.equals(obj) && !(obj instanceof Byte) && !(obj instanceof Character) && !(obj instanceof Short) && !(obj instanceof Integer) && !(obj instanceof Long) && !(obj instanceof Boolean) && !(obj instanceof Float) && !(obj instanceof Double)) {
                if (!(obj instanceof String)) {
                    if (obj instanceof Collection) {
                        return new JSONArray((Collection) obj);
                    }
                    if (obj.getClass().isArray()) {
                        return new JSONArray(obj);
                    }
                    if (obj instanceof Map) {
                        return new JSONObject((Map) obj);
                    }
                    Package packageR = obj.getClass().getPackage();
                    String name = packageR != null ? packageR.getName() : "";
                    if (!name.startsWith("java.") && !name.startsWith("javax.")) {
                        if (obj.getClass().getClassLoader() != null) {
                            return new JSONObject(obj);
                        }
                    }
                    return obj.toString();
                }
            }
            return obj;
        }
    }

    public Writer write(Writer writer) throws JSONException {
        boolean z = false;
        try {
            Iterator keys = keys();
            writer.write(123);
            while (keys.hasNext()) {
                if (z) {
                    writer.write(44);
                }
                Object next = keys.next();
                writer.write(quote(next.toString()));
                writer.write(58);
                Object obj = this.map.get(next);
                if (obj instanceof JSONObject) {
                    ((JSONObject) obj).write(writer);
                } else if (obj instanceof JSONArray) {
                    ((JSONArray) obj).write(writer);
                } else {
                    writer.write(valueToString(obj));
                }
                z = true;
            }
            writer.write(125);
            return writer;
        } catch (IOException e) {
            throw new JSONException((Throwable) e);
        }
    }
}
