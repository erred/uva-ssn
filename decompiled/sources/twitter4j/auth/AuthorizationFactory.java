package twitter4j.auth;

public final class AuthorizationFactory {
    /* JADX WARNING: type inference failed for: r0v1, types: [twitter4j.auth.Authorization] */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r1v1, types: [twitter4j.auth.BasicAuthorization] */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v7, types: [twitter4j.auth.OAuthAuthorization] */
    /* JADX WARNING: type inference failed for: r0v8, types: [twitter4j.auth.OAuth2Authorization] */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v5
      assigns: [?[OBJECT, ARRAY], twitter4j.auth.OAuthAuthorization, twitter4j.auth.OAuth2Authorization]
      uses: [?[int, boolean, OBJECT, ARRAY, byte, short, char], twitter4j.auth.Authorization, twitter4j.auth.OAuthAuthorization, twitter4j.auth.OAuth2Authorization]
      mth insns count: 32
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static twitter4j.auth.Authorization getInstance(twitter4j.conf.Configuration r3) {
        /*
            java.lang.String r0 = r3.getOAuthConsumerKey()
            java.lang.String r1 = r3.getOAuthConsumerSecret()
            if (r0 == 0) goto L_0x0046
            if (r1 == 0) goto L_0x0046
            boolean r0 = r3.isApplicationOnlyAuthEnabled()
            if (r0 == 0) goto L_0x002c
            twitter4j.auth.OAuth2Authorization r0 = new twitter4j.auth.OAuth2Authorization
            r0.<init>(r3)
            java.lang.String r1 = r3.getOAuth2TokenType()
            java.lang.String r3 = r3.getOAuth2AccessToken()
            if (r1 == 0) goto L_0x005a
            if (r3 == 0) goto L_0x005a
            twitter4j.auth.OAuth2Token r2 = new twitter4j.auth.OAuth2Token
            r2.<init>(r1, r3)
            r0.setOAuth2Token(r2)
            goto L_0x005a
        L_0x002c:
            twitter4j.auth.OAuthAuthorization r0 = new twitter4j.auth.OAuthAuthorization
            r0.<init>(r3)
            java.lang.String r1 = r3.getOAuthAccessToken()
            java.lang.String r3 = r3.getOAuthAccessTokenSecret()
            if (r1 == 0) goto L_0x005a
            if (r3 == 0) goto L_0x005a
            twitter4j.auth.AccessToken r2 = new twitter4j.auth.AccessToken
            r2.<init>(r1, r3)
            r0.setOAuthAccessToken(r2)
            goto L_0x005a
        L_0x0046:
            java.lang.String r0 = r3.getUser()
            java.lang.String r3 = r3.getPassword()
            if (r0 == 0) goto L_0x0059
            if (r3 == 0) goto L_0x0059
            twitter4j.auth.BasicAuthorization r1 = new twitter4j.auth.BasicAuthorization
            r1.<init>(r0, r3)
            r0 = r1
            goto L_0x005a
        L_0x0059:
            r0 = 0
        L_0x005a:
            if (r0 != 0) goto L_0x0060
            twitter4j.auth.NullAuthorization r0 = twitter4j.auth.NullAuthorization.getInstance()
        L_0x0060:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: twitter4j.auth.AuthorizationFactory.getInstance(twitter4j.conf.Configuration):twitter4j.auth.Authorization");
    }
}
