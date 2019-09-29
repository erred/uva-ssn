package twitter4j;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

public final class HttpParameter implements Serializable, Comparable {
    private static final String GIF = "image/gif";
    private static final String JPEG = "image/jpeg";
    private static final String OCTET = "application/octet-stream";
    private static final String PNG = "image/png";
    private static final long serialVersionUID = 4046908449190454692L;
    private File file = null;
    private InputStream fileBody = null;
    private String name = null;
    private String value = null;

    public HttpParameter(String str, String str2) {
        this.name = str;
        this.value = str2;
    }

    public HttpParameter(String str, File file2) {
        this.name = str;
        this.file = file2;
    }

    public HttpParameter(String str, String str2, InputStream inputStream) {
        this.name = str;
        this.file = new File(str2);
        this.fileBody = inputStream;
    }

    public HttpParameter(String str, int i) {
        this.name = str;
        this.value = String.valueOf(i);
    }

    public HttpParameter(String str, long j) {
        this.name = str;
        this.value = String.valueOf(j);
    }

    public HttpParameter(String str, double d) {
        this.name = str;
        this.value = String.valueOf(d);
    }

    public HttpParameter(String str, boolean z) {
        this.name = str;
        this.value = String.valueOf(z);
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public File getFile() {
        return this.file;
    }

    public InputStream getFileBody() {
        return this.fileBody;
    }

    public boolean isFile() {
        return this.file != null;
    }

    public boolean hasFileBody() {
        return this.fileBody != null;
    }

    public String getContentType() {
        if (isFile()) {
            String name2 = this.file.getName();
            if (-1 == name2.lastIndexOf(".")) {
                return OCTET;
            }
            String lowerCase = name2.substring(name2.lastIndexOf(".") + 1).toLowerCase();
            if (lowerCase.length() == 3) {
                if ("gif".equals(lowerCase)) {
                    return GIF;
                }
                if ("png".equals(lowerCase)) {
                    return PNG;
                }
                return "jpg".equals(lowerCase) ? JPEG : OCTET;
            } else if (lowerCase.length() == 4) {
                return "jpeg".equals(lowerCase) ? JPEG : OCTET;
            } else {
                return OCTET;
            }
        } else {
            throw new IllegalStateException("not a file");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HttpParameter)) {
            return false;
        }
        HttpParameter httpParameter = (HttpParameter) obj;
        if (this.file == null ? httpParameter.file != null : !this.file.equals(httpParameter.file)) {
            return false;
        }
        if (this.fileBody == null ? httpParameter.fileBody != null : !this.fileBody.equals(httpParameter.fileBody)) {
            return false;
        }
        if (!this.name.equals(httpParameter.name)) {
            return false;
        }
        return this.value == null ? httpParameter.value == null : this.value.equals(httpParameter.value);
    }

    public static boolean containsFile(HttpParameter[] httpParameterArr) {
        boolean z = false;
        if (httpParameterArr == null) {
            return false;
        }
        int length = httpParameterArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            } else if (httpParameterArr[i].isFile()) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        return z;
    }

    static boolean containsFile(List<HttpParameter> list) {
        for (HttpParameter isFile : list) {
            if (isFile.isFile()) {
                return true;
            }
        }
        return false;
    }

    public static HttpParameter[] getParameterArray(String str, String str2) {
        return new HttpParameter[]{new HttpParameter(str, str2)};
    }

    public static HttpParameter[] getParameterArray(String str, int i) {
        return getParameterArray(str, String.valueOf(i));
    }

    public static HttpParameter[] getParameterArray(String str, String str2, String str3, String str4) {
        return new HttpParameter[]{new HttpParameter(str, str2), new HttpParameter(str3, str4)};
    }

    public static HttpParameter[] getParameterArray(String str, int i, String str2, int i2) {
        return getParameterArray(str, String.valueOf(i), str2, String.valueOf(i2));
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((this.name.hashCode() * 31) + (this.value != null ? this.value.hashCode() : 0)) * 31) + (this.file != null ? this.file.hashCode() : 0)) * 31;
        if (this.fileBody != null) {
            i = this.fileBody.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PostParameter{name='");
        sb.append(this.name);
        sb.append('\'');
        sb.append(", value='");
        sb.append(this.value);
        sb.append('\'');
        sb.append(", file=");
        sb.append(this.file);
        sb.append(", fileBody=");
        sb.append(this.fileBody);
        sb.append('}');
        return sb.toString();
    }

    public int compareTo(Object obj) {
        HttpParameter httpParameter = (HttpParameter) obj;
        int compareTo = this.name.compareTo(httpParameter.name);
        return compareTo == 0 ? this.value.compareTo(httpParameter.value) : compareTo;
    }

    public static String encodeParameters(HttpParameter[] httpParameterArr) {
        if (httpParameterArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < httpParameterArr.length) {
            if (!httpParameterArr[i].isFile()) {
                if (i != 0) {
                    sb.append("&");
                }
                sb.append(encode(httpParameterArr[i].name));
                sb.append(SimpleComparison.EQUAL_TO_OPERATION);
                sb.append(encode(httpParameterArr[i].value));
                i++;
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("parameter [");
                sb2.append(httpParameterArr[i].name);
                sb2.append("]should be text");
                throw new IllegalArgumentException(sb2.toString());
            }
        }
        return sb.toString();
    }

    public static String encode(String str) {
        String str2;
        try {
            str2 = URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            str2 = null;
        }
        StringBuilder sb = new StringBuilder(str2.length());
        int i = 0;
        while (i < str2.length()) {
            char charAt = str2.charAt(i);
            if (charAt == '*') {
                sb.append("%2A");
            } else if (charAt == '+') {
                sb.append("%20");
            } else {
                if (charAt == '%') {
                    int i2 = i + 1;
                    if (i2 < str2.length() && str2.charAt(i2) == '7') {
                        int i3 = i + 2;
                        if (str2.charAt(i3) == 'E') {
                            sb.append('~');
                            i = i3;
                        }
                    }
                }
                sb.append(charAt);
            }
            i++;
        }
        return sb.toString();
    }
}
