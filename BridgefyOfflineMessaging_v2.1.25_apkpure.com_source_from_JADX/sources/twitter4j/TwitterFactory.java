package twitter4j;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import twitter4j.auth.AccessToken;
import twitter4j.auth.Authorization;
import twitter4j.auth.AuthorizationFactory;
import twitter4j.auth.OAuthAuthorization;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationContext;

public final class TwitterFactory implements Serializable {
    static final Authorization DEFAULT_AUTHORIZATION = AuthorizationFactory.getInstance(ConfigurationContext.getInstance());
    private static final Twitter SINGLETON;
    private static final Constructor<Twitter> TWITTER_CONSTRUCTOR;
    private static final long serialVersionUID = -563983536986910054L;
    private final Configuration conf;

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0022  */
    static {
        /*
            twitter4j.conf.Configuration r0 = twitter4j.conf.ConfigurationContext.getInstance()
            twitter4j.auth.Authorization r0 = twitter4j.auth.AuthorizationFactory.getInstance(r0)
            DEFAULT_AUTHORIZATION = r0
            r0 = 1
            r1 = 0
            java.lang.String r2 = "com.google.appengine.api.urlfetch.URLFetchService"
            java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException -> 0x0013 }
            r2 = 1
            goto L_0x0014
        L_0x0013:
            r2 = 0
        L_0x0014:
            r3 = 0
            if (r2 == 0) goto L_0x001f
            java.lang.String r2 = "twitter4j.AppEngineTwitterImpl"
            java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException -> 0x001f }
            java.lang.String r2 = "twitter4j.AppEngineTwitterImpl"
            goto L_0x0020
        L_0x001f:
            r2 = r3
        L_0x0020:
            if (r2 != 0) goto L_0x0024
            java.lang.String r2 = "twitter4j.TwitterImpl"
        L_0x0024:
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ NoSuchMethodException -> 0x006c, ClassNotFoundException -> 0x0065 }
            r3 = 2
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ NoSuchMethodException -> 0x006c, ClassNotFoundException -> 0x0065 }
            java.lang.Class<twitter4j.conf.Configuration> r5 = twitter4j.conf.Configuration.class
            r4[r1] = r5     // Catch:{ NoSuchMethodException -> 0x006c, ClassNotFoundException -> 0x0065 }
            java.lang.Class<twitter4j.auth.Authorization> r5 = twitter4j.auth.Authorization.class
            r4[r0] = r5     // Catch:{ NoSuchMethodException -> 0x006c, ClassNotFoundException -> 0x0065 }
            java.lang.reflect.Constructor r2 = r2.getDeclaredConstructor(r4)     // Catch:{ NoSuchMethodException -> 0x006c, ClassNotFoundException -> 0x0065 }
            TWITTER_CONSTRUCTOR = r2
            java.lang.reflect.Constructor<twitter4j.Twitter> r2 = TWITTER_CONSTRUCTOR     // Catch:{ InstantiationException -> 0x005e, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0050 }
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ InstantiationException -> 0x005e, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0050 }
            twitter4j.conf.Configuration r4 = twitter4j.conf.ConfigurationContext.getInstance()     // Catch:{ InstantiationException -> 0x005e, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0050 }
            r3[r1] = r4     // Catch:{ InstantiationException -> 0x005e, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0050 }
            twitter4j.auth.Authorization r1 = DEFAULT_AUTHORIZATION     // Catch:{ InstantiationException -> 0x005e, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0050 }
            r3[r0] = r1     // Catch:{ InstantiationException -> 0x005e, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0050 }
            java.lang.Object r0 = r2.newInstance(r3)     // Catch:{ InstantiationException -> 0x005e, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0050 }
            twitter4j.Twitter r0 = (twitter4j.Twitter) r0     // Catch:{ InstantiationException -> 0x005e, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0050 }
            SINGLETON = r0     // Catch:{ InstantiationException -> 0x005e, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0050 }
            return
        L_0x0050:
            r0 = move-exception
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>(r0)
            throw r1
        L_0x0057:
            r0 = move-exception
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>(r0)
            throw r1
        L_0x005e:
            r0 = move-exception
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>(r0)
            throw r1
        L_0x0065:
            r0 = move-exception
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>(r0)
            throw r1
        L_0x006c:
            r0 = move-exception
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: twitter4j.TwitterFactory.<clinit>():void");
    }

    public TwitterFactory() {
        this(ConfigurationContext.getInstance());
    }

    public TwitterFactory(Configuration configuration) {
        if (configuration != null) {
            this.conf = configuration;
            return;
        }
        throw new NullPointerException("configuration cannot be null");
    }

    public TwitterFactory(String str) {
        this(ConfigurationContext.getInstance(str));
    }

    public Twitter getInstance() {
        return getInstance(AuthorizationFactory.getInstance(this.conf));
    }

    public Twitter getInstance(AccessToken accessToken) {
        String oAuthConsumerKey = this.conf.getOAuthConsumerKey();
        String oAuthConsumerSecret = this.conf.getOAuthConsumerSecret();
        if (oAuthConsumerKey == null && oAuthConsumerSecret == null) {
            throw new IllegalStateException("Consumer key and Consumer secret not supplied.");
        }
        OAuthAuthorization oAuthAuthorization = new OAuthAuthorization(this.conf);
        oAuthAuthorization.setOAuthAccessToken(accessToken);
        return getInstance((Authorization) oAuthAuthorization);
    }

    public Twitter getInstance(Authorization authorization) {
        try {
            return (Twitter) TWITTER_CONSTRUCTOR.newInstance(new Object[]{this.conf, authorization});
        } catch (InstantiationException e) {
            throw new AssertionError(e);
        } catch (IllegalAccessException e2) {
            throw new AssertionError(e2);
        } catch (InvocationTargetException e3) {
            throw new AssertionError(e3);
        }
    }

    public static Twitter getSingleton() {
        return SINGLETON;
    }
}
