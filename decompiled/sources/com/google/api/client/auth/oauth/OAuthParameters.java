package com.google.api.client.auth.oauth;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.util.Beta;
import com.google.api.client.util.escape.PercentEscaper;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.Collection;
import java.util.Map.Entry;
import java.util.TreeMap;

@Beta
public final class OAuthParameters implements HttpExecuteInterceptor, HttpRequestInitializer {
    private static final PercentEscaper ESCAPER = new PercentEscaper("-_.~", false);
    private static final SecureRandom RANDOM = new SecureRandom();
    public String callback;
    public String consumerKey;
    public String nonce;
    public String realm;
    public String signature;
    public String signatureMethod;
    public OAuthSigner signer;
    public String timestamp;
    public String token;
    public String verifier;
    public String version;

    public void computeNonce() {
        this.nonce = Long.toHexString(Math.abs(RANDOM.nextLong()));
    }

    public void computeTimestamp() {
        this.timestamp = Long.toString(System.currentTimeMillis() / 1000);
    }

    public void computeSignature(String str, GenericUrl genericUrl) throws GeneralSecurityException {
        OAuthSigner oAuthSigner = this.signer;
        String signatureMethod2 = oAuthSigner.getSignatureMethod();
        this.signatureMethod = signatureMethod2;
        TreeMap treeMap = new TreeMap();
        putParameterIfValueNotNull(treeMap, "oauth_callback", this.callback);
        putParameterIfValueNotNull(treeMap, "oauth_consumer_key", this.consumerKey);
        putParameterIfValueNotNull(treeMap, "oauth_nonce", this.nonce);
        putParameterIfValueNotNull(treeMap, "oauth_signature_method", signatureMethod2);
        putParameterIfValueNotNull(treeMap, "oauth_timestamp", this.timestamp);
        putParameterIfValueNotNull(treeMap, "oauth_token", this.token);
        putParameterIfValueNotNull(treeMap, "oauth_verifier", this.verifier);
        putParameterIfValueNotNull(treeMap, "oauth_version", this.version);
        for (Entry entry : genericUrl.entrySet()) {
            Object value = entry.getValue();
            if (value != null) {
                String str2 = (String) entry.getKey();
                if (value instanceof Collection) {
                    for (Object putParameter : (Collection) value) {
                        putParameter(treeMap, str2, putParameter);
                    }
                } else {
                    putParameter(treeMap, str2, value);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Entry entry2 : treeMap.entrySet()) {
            if (z) {
                z = false;
            } else {
                sb.append('&');
            }
            sb.append((String) entry2.getKey());
            String str3 = (String) entry2.getValue();
            if (str3 != null) {
                sb.append('=');
                sb.append(str3);
            }
        }
        String sb2 = sb.toString();
        GenericUrl genericUrl2 = new GenericUrl();
        String scheme = genericUrl.getScheme();
        genericUrl2.setScheme(scheme);
        genericUrl2.setHost(genericUrl.getHost());
        genericUrl2.setPathParts(genericUrl.getPathParts());
        int port = genericUrl.getPort();
        if (("http".equals(scheme) && port == 80) || ("https".equals(scheme) && port == 443)) {
            port = -1;
        }
        genericUrl2.setPort(port);
        String build = genericUrl2.build();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(escape(str));
        sb3.append('&');
        sb3.append(escape(build));
        sb3.append('&');
        sb3.append(escape(sb2));
        this.signature = oAuthSigner.computeSignature(sb3.toString());
    }

    public String getAuthorizationHeader() {
        StringBuilder sb = new StringBuilder("OAuth");
        appendParameter(sb, "realm", this.realm);
        appendParameter(sb, "oauth_callback", this.callback);
        appendParameter(sb, "oauth_consumer_key", this.consumerKey);
        appendParameter(sb, "oauth_nonce", this.nonce);
        appendParameter(sb, "oauth_signature", this.signature);
        appendParameter(sb, "oauth_signature_method", this.signatureMethod);
        appendParameter(sb, "oauth_timestamp", this.timestamp);
        appendParameter(sb, "oauth_token", this.token);
        appendParameter(sb, "oauth_verifier", this.verifier);
        appendParameter(sb, "oauth_version", this.version);
        return sb.substring(0, sb.length() - 1);
    }

    private void appendParameter(StringBuilder sb, String str, String str2) {
        if (str2 != null) {
            sb.append(' ');
            sb.append(escape(str));
            sb.append("=\"");
            sb.append(escape(str2));
            sb.append("\",");
        }
    }

    private void putParameterIfValueNotNull(TreeMap<String, String> treeMap, String str, String str2) {
        if (str2 != null) {
            putParameter(treeMap, str, str2);
        }
    }

    private void putParameter(TreeMap<String, String> treeMap, String str, Object obj) {
        treeMap.put(escape(str), obj == null ? null : escape(obj.toString()));
    }

    public static String escape(String str) {
        return ESCAPER.escape(str);
    }

    public void initialize(HttpRequest httpRequest) throws IOException {
        httpRequest.setInterceptor(this);
    }

    public void intercept(HttpRequest httpRequest) throws IOException {
        computeNonce();
        computeTimestamp();
        try {
            computeSignature(httpRequest.getRequestMethod(), httpRequest.getUrl());
            httpRequest.getHeaders().setAuthorization(getAuthorizationHeader());
        } catch (GeneralSecurityException e) {
            IOException iOException = new IOException();
            iOException.initCause(e);
            throw iOException;
        }
    }
}
