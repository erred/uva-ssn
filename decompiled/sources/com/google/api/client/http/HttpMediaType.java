package com.google.api.client.http;

import com.google.api.client.util.Preconditions;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class HttpMediaType {
    private static final Pattern FULL_MEDIA_TYPE_REGEX;
    private static final Pattern PARAMETER_REGEX;
    private static final Pattern TOKEN_REGEX = Pattern.compile("[\\p{ASCII}&&[^\\p{Cntrl} ;/=\\[\\]\\(\\)\\<\\>\\@\\,\\:\\\"\\?\\=]]+");
    private static final Pattern TYPE_REGEX = Pattern.compile("[\\w!#$&.+\\-\\^_]+|[*]");
    private String cachedBuildResult;
    private final SortedMap<String, String> parameters = new TreeMap();
    private String subType = "octet-stream";
    private String type = "application";

    static {
        String str = "[^\\s/=;\"]+";
        String valueOf = String.valueOf(String.valueOf(str));
        String valueOf2 = String.valueOf(String.valueOf(str));
        String valueOf3 = String.valueOf(String.valueOf(";.*"));
        StringBuilder sb = new StringBuilder(valueOf.length() + 14 + valueOf2.length() + valueOf3.length());
        sb.append("\\s*(");
        sb.append(valueOf);
        sb.append(")/(");
        sb.append(valueOf2);
        sb.append(")");
        sb.append("\\s*(");
        sb.append(valueOf3);
        sb.append(")?");
        FULL_MEDIA_TYPE_REGEX = Pattern.compile(sb.toString(), 32);
        String valueOf4 = String.valueOf(String.valueOf("\"([^\"]*)\""));
        String valueOf5 = String.valueOf(String.valueOf("[^\\s;\"]*"));
        StringBuilder sb2 = new StringBuilder(valueOf4.length() + 1 + valueOf5.length());
        sb2.append(valueOf4);
        sb2.append("|");
        sb2.append(valueOf5);
        String sb3 = sb2.toString();
        String valueOf6 = String.valueOf(String.valueOf(str));
        String valueOf7 = String.valueOf(String.valueOf(sb3));
        StringBuilder sb4 = new StringBuilder(valueOf6.length() + 12 + valueOf7.length());
        sb4.append("\\s*;\\s*(");
        sb4.append(valueOf6);
        sb4.append(")");
        sb4.append("=(");
        sb4.append(valueOf7);
        sb4.append(")");
        PARAMETER_REGEX = Pattern.compile(sb4.toString());
    }

    public HttpMediaType(String str, String str2) {
        setType(str);
        setSubType(str2);
    }

    public HttpMediaType(String str) {
        fromString(str);
    }

    public HttpMediaType setType(String str) {
        Preconditions.checkArgument(TYPE_REGEX.matcher(str).matches(), "Type contains reserved characters");
        this.type = str;
        this.cachedBuildResult = null;
        return this;
    }

    public String getType() {
        return this.type;
    }

    public HttpMediaType setSubType(String str) {
        Preconditions.checkArgument(TYPE_REGEX.matcher(str).matches(), "Subtype contains reserved characters");
        this.subType = str;
        this.cachedBuildResult = null;
        return this;
    }

    public String getSubType() {
        return this.subType;
    }

    private HttpMediaType fromString(String str) {
        Matcher matcher = FULL_MEDIA_TYPE_REGEX.matcher(str);
        Preconditions.checkArgument(matcher.matches(), "Type must be in the 'maintype/subtype; parameter=value' format");
        setType(matcher.group(1));
        setSubType(matcher.group(2));
        String group = matcher.group(3);
        if (group != null) {
            Matcher matcher2 = PARAMETER_REGEX.matcher(group);
            while (matcher2.find()) {
                String group2 = matcher2.group(1);
                String group3 = matcher2.group(3);
                if (group3 == null) {
                    group3 = matcher2.group(2);
                }
                setParameter(group2, group3);
            }
        }
        return this;
    }

    public HttpMediaType setParameter(String str, String str2) {
        if (str2 == null) {
            removeParameter(str);
            return this;
        }
        Preconditions.checkArgument(TOKEN_REGEX.matcher(str).matches(), "Name contains reserved characters");
        this.cachedBuildResult = null;
        this.parameters.put(str.toLowerCase(), str2);
        return this;
    }

    public String getParameter(String str) {
        return (String) this.parameters.get(str.toLowerCase());
    }

    public HttpMediaType removeParameter(String str) {
        this.cachedBuildResult = null;
        this.parameters.remove(str.toLowerCase());
        return this;
    }

    public void clearParameters() {
        this.cachedBuildResult = null;
        this.parameters.clear();
    }

    public Map<String, String> getParameters() {
        return Collections.unmodifiableMap(this.parameters);
    }

    static boolean matchesToken(String str) {
        return TOKEN_REGEX.matcher(str).matches();
    }

    private static String quoteString(String str) {
        String valueOf = String.valueOf(String.valueOf(str.replace("\\", "\\\\").replace("\"", "\\\"")));
        StringBuilder sb = new StringBuilder(valueOf.length() + 2);
        sb.append("\"");
        sb.append(valueOf);
        sb.append("\"");
        return sb.toString();
    }

    public String build() {
        if (this.cachedBuildResult != null) {
            return this.cachedBuildResult;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.type);
        sb.append('/');
        sb.append(this.subType);
        if (this.parameters != null) {
            for (Entry entry : this.parameters.entrySet()) {
                String str = (String) entry.getValue();
                sb.append("; ");
                sb.append((String) entry.getKey());
                sb.append(SimpleComparison.EQUAL_TO_OPERATION);
                if (!matchesToken(str)) {
                    str = quoteString(str);
                }
                sb.append(str);
            }
        }
        this.cachedBuildResult = sb.toString();
        return this.cachedBuildResult;
    }

    public String toString() {
        return build();
    }

    public boolean equalsIgnoreParameters(HttpMediaType httpMediaType) {
        return httpMediaType != null && getType().equalsIgnoreCase(httpMediaType.getType()) && getSubType().equalsIgnoreCase(httpMediaType.getSubType());
    }

    public static boolean equalsIgnoreParameters(String str, String str2) {
        return (str == null && str2 == null) || !(str == null || str2 == null || !new HttpMediaType(str).equalsIgnoreParameters(new HttpMediaType(str2)));
    }

    public HttpMediaType setCharsetParameter(Charset charset) {
        setParameter("charset", charset == null ? null : charset.name());
        return this;
    }

    public Charset getCharsetParameter() {
        String parameter = getParameter("charset");
        if (parameter == null) {
            return null;
        }
        return Charset.forName(parameter);
    }

    public int hashCode() {
        return build().hashCode();
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof HttpMediaType)) {
            return false;
        }
        HttpMediaType httpMediaType = (HttpMediaType) obj;
        if (equalsIgnoreParameters(httpMediaType) && this.parameters.equals(httpMediaType.parameters)) {
            z = true;
        }
        return z;
    }
}
