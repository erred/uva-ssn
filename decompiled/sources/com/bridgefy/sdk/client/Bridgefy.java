package com.bridgefy.sdk.client;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Keep;
import com.bridgefy.sdk.BuildConfig;
import com.bridgefy.sdk.client.BridgefyUtils.Reflection;
import com.bridgefy.sdk.client.Config.Builder;
import com.bridgefy.sdk.client.registration.BridgefyCertificate;
import com.bridgefy.sdk.client.registration.Registration;
import com.bridgefy.sdk.framework.controller.Analytics;
import com.bridgefy.sdk.framework.controller.BridgefyCore;
import com.bridgefy.sdk.framework.utils.Utils;
import java.util.HashMap;
import java.util.UUID;
import p000a.p013b.C0355t;
import p000a.p013b.p017b.C0161b;

public class Bridgefy {
    public static final String LAST_COMPATIBLE_VERSION = "1.0.6";
    public static final String SDK_VERSION = "1.1.24";
    public static final String VERSION = "1.0.6";

    /* renamed from: a */
    static Bridgefy bridgefy;

    /* renamed from: b */
    private BridgefyClient bridgefy_client;

    /* renamed from: c */
    private BridgefyCore bridgefy_core;

    /* renamed from: d */
    private Context context;

    /* renamed from: e */
    private Config config;

    /* renamed from: com.bridgefy.sdk.client.Bridgefy$a */
    private static class private_bridgefy {

        /* renamed from: a */
        private final Context context;

        /* renamed from: b */
        private final BridgefyClient bridgefy_client;

        private_bridgefy(Context context, BridgefyClient bridgefyClient) {
            boolean z = false;
            boolean z2 = context == null;
            if (bridgefyClient == null) {
                z = true;
            }
            if (!z && !z2) {
                this.context = context.getApplicationContext();
                this.bridgefy_client = bridgefyClient;
                return;
            }
            throw new IllegalArgumentException("Context or BridgefyClient must not be null.");
        }

        /* renamed from: a */
        public Bridgefy new_bridgefy() {
            return new Bridgefy(this.context, this.bridgefy_client);
        }
    }

    /* renamed from: com.bridgefy.sdk.client.Bridgefy$b */
    private static class registration_handler implements C0355t<BridgefyCertificate> {

        /* renamed from: a */
        String f5759a;

        /* renamed from: b */
        String f5760b;

        /* renamed from: c */
        RegistrationListener registration_listener;

        /* renamed from: d */
        Context context;

        /* renamed from: e */
        BridgefyCertificate bridgefy_certificate;

        public void onSubscribe(C0161b bVar) {
        }

        registration_handler(Context context, String str, String str2, RegistrationListener registrationListener, BridgefyCertificate bridgefyCertificate) {
            this.context = context;
            this.f5759a = str;
            this.f5760b = str2;
            this.registration_listener = registrationListener;
            this.bridgefy_certificate = bridgefyCertificate;
        }

        /* renamed from: a */
        public void onSuccess(BridgefyCertificate bridgefyCertificate) {
            bridgefyCertificate.save(this.context.getSharedPreferences(BridgefyCore.PREFS_NAME, 0));
            try {
                BridgefyClient c = new C1873a(this.context).mo7216a(this.f5759a).mo7218b(this.f5760b).mo7215a().mo7219c();
                Bridgefy.m7653b(this.context, c);
                Bridgefy.on_registration_success(this.registration_listener, c);
            } catch (Exception e) {
                onError(e);
            }
        }

        public void onError(Throwable th) {
            if (this.bridgefy_certificate != null) {
                Object buildConfigValue = Utils.getBuildConfigValue(this.context, "APPLICATION_ID");
                String trim = buildConfigValue != null ? buildConfigValue.toString().trim() : "";
                if (this.bridgefy_certificate.getBundleIds() == null || this.bridgefy_certificate.getBundleIds().length <= 0) {
                    Bridgefy.on_registration_failed(this.registration_listener, (Throwable) new BridgefyException(-3, th.getMessage()));
                    return;
                }
                String[] bundleIds = this.bridgefy_certificate.getBundleIds();
                int length = bundleIds.length;
                boolean z = false;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    } else if (bundleIds[i].trim().equalsIgnoreCase(trim)) {
                        z = true;
                        break;
                    } else {
                        i++;
                    }
                }
                if (!z || !this.bridgefy_certificate.isValid()) {
                    Bridgefy.on_registration_failed(this.registration_listener, (Throwable) new BridgefyException(-3, th.getMessage()));
                } else {
                    onSuccess(this.bridgefy_certificate);
                }
            } else {
                Bridgefy.on_registration_failed(this.registration_listener, th);
            }
        }
    }

    public static Bridgefy getInstance() {
        if (bridgefy != null) {
            return bridgefy;
        }
        throw new IllegalStateException("Bridgefy must be initialized before trying to reference it.");
    }

    private Bridgefy(Context context, BridgefyClient bridgefyClient) {
        this.context = context;
        this.bridgefy_client = bridgefyClient;
    }

    public static void initialize(Context context, RegistrationListener registrationListener) {
        initialize(context, null, registrationListener, null);
    }

    public static void initialize(Context context, String str, RegistrationListener registrationListener) {
        initialize(context, str, registrationListener, null);
    }

    @Keep
    private static void initialize(Context context, String str, RegistrationListener registrationListener, UUID uuid) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(BridgefyCore.PREFS_NAME, 0);
        String loadApiKey = loadApiKey(context, str);
        String string = sharedPreferences.getString(BridgefyCore.PREFS_USER_UUID, null);
        BridgefyCertificate loadCertificate = Registration.loadCertificate(context);
        if ((uuid == null || uuid.toString().equals(string)) && string != null) {
            BridgefyCertificate loadCertificate2 = Registration.loadCertificate(sharedPreferences);
            if (loadCertificate2 == null || !loadCertificate2.isValid() || !m7652a(sharedPreferences)) {
                Log.w("Bridgefy", "... Invalid certificate! Requesting new certificate.");
                registration_handler bVar = new registration_handler(context, loadApiKey, string, registrationListener, loadCertificate);
                Registration.requestCertificate(context, string, bVar);
                return;
            }
            m7653b(context, new C1873a(context).mo7216a(loadApiKey).mo7218b(string).mo7217b().mo7219c());
            on_registration_success(registrationListener, bridgefy.getBridgefyClient());
            return;
        }
        String uuid2 = uuid == null ? UUID.randomUUID().toString() : uuid.toString();
        registration_handler bVar2 = new registration_handler(context, loadApiKey, uuid2, registrationListener, loadCertificate);
        Registration.requestCertificate(context, uuid2, bVar2);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m7653b(Context context, BridgefyClient bridgefyClient) {
        synchronized (Bridgefy.class) {
            set_bridgefy(new private_bridgefy(context, bridgefyClient).new_bridgefy());
        }
    }

    public static void start(MessageListener messageListener, StateListener stateListener) {
        start(messageListener, stateListener, new Builder().build());
    }

    public static void start(MessageListener messageListener, StateListener stateListener, Config config) {
        try {
            if (getInstance().getBridgefyCore() == null) {
                BridgefyUtils.verify_has_bluetooth_le(getInstance().get_context(), config);
                getInstance().set_config(config);
                getInstance().setBridgefyCore(new BridgefyCore(getInstance().get_context(), config));
                getInstance().getBridgefyCore().setMessageListener(messageListener);
                getInstance().getBridgefyCore().setStateListener(stateListener);
                getInstance().getBridgefyCore().initializeServices();
                Reflection.privateMethod("initialize").ofClass(Analytics.class).withArgs(getInstance().get_context()).argTypes(Context.class).execute();
                if (stateListener != null) {
                    stateListener.onStarted();
                }
                getInstance().context.getSharedPreferences(BridgefyCore.PREFS_NAME, 0).edit().putLong("com.bridgefy.sdk.last_use", System.currentTimeMillis()).apply();
            }
        } catch (NullPointerException e) {
            if (stateListener != null) {
                stateListener.onStartError(StateListener.INITIALIZATION_ERROR_STRING, -40);
            } else {
                e.printStackTrace();
            }
        } catch (BridgefyException e2) {
            if (stateListener != null) {
                stateListener.onStartError(e2.getMessage(), e2.getErrorCode());
            } else {
                e2.printStackTrace();
            }
        }
    }

    public static boolean stop() {
        try {
            getInstance().getBridgefyCore().shutdownServices();
            return true;
        } catch (NullPointerException unused) {
            Log.e("Bridgefy", "stop: Bridgefy must be started with Bridgefy.start() before calling stop()");
            return false;
        }
    }

    public static boolean pause() {
        try {
            return getInstance().getBridgefyCore().pauseServices();
        } catch (NullPointerException unused) {
            Log.e("Bridgefy", "pause: Bridgefy must be started with Bridgefy.start() before calling pause()");
            return false;
        }
    }

    public static boolean resume() {
        try {
            getInstance().getBridgefyCore().resumeServices();
            return true;
        } catch (NullPointerException unused) {
            Log.e("Bridgefy", "pause: Bridgefy must be started with Bridgefy.start() before calling resume()");
            return false;
        }
    }

    @Deprecated
    public static Message createMessage(HashMap<String, Object> hashMap) {
        return createMessage(null, hashMap);
    }

    @Deprecated
    public static Message createMessage(String str, HashMap<String, Object> hashMap) {
        try {
            Message.Builder builder = new Message.Builder();
            builder.setContent(hashMap);
            builder.setReceiverId(str);
            return builder.build();
        } catch (NullPointerException unused) {
            throw new IllegalStateException("Bridgefy must be initialized before calling createMessage()");
        }
    }

    public static String sendMessage(Message message) {
        try {
            return sendMessage(message, getInstance().getConfig().getEngineProfile());
        } catch (NullPointerException unused) {
            Log.e("Bridgefy", "Bridgefy must be started with Bridgefy.start() before trying to send a message");
            return null;
        }
    }

    public static String sendMessage(Message message, BFEngineProfile bFEngineProfile) {
        m7649a(message);
        try {
            message.setSenderId(getInstance().getBridgefyClient().getUserUuid());
            getInstance().getBridgefyCore().sendMessage(message, message.getReceiverId(), bFEngineProfile);
            return message.getUuid();
        } catch (NullPointerException unused) {
            Log.e("Bridgefy", "Bridgefy must be started with Bridgefy.start() before trying to send a message");
            return null;
        }
    }

    public static String sendBroadcastMessage(Message message) {
        try {
            return sendBroadcastMessage(message, getInstance().getConfig().getEngineProfile());
        } catch (NullPointerException unused) {
            Log.e("Bridgefy", "Bridgefy must be started with Bridgefy.start() before trying to send a message");
            return null;
        }
    }

    public static String sendBroadcastMessage(HashMap<String, Object> hashMap) {
        return sendBroadcastMessage(createMessage(hashMap), BFEngineProfile.BFConfigProfileDefault);
    }

    public static String sendBroadcastMessage(Message message, BFEngineProfile bFEngineProfile) {
        m7649a(message);
        message.setReceiverId(null);
        try {
            getInstance().getBridgefyCore().sendBroadcastMessage(message, bFEngineProfile);
            return message.getUuid();
        } catch (NullPointerException unused) {
            Log.e("Bridgefy", "Bridgefy must be started with Bridgefy.start() before trying to send a message");
            return null;
        }
    }

    /* renamed from: a */
    private static boolean m7652a(SharedPreferences sharedPreferences) {
        return System.currentTimeMillis() > sharedPreferences.getLong("com.bridgefy.sdk.last_use", System.currentTimeMillis() - 1000);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void on_registration_success(RegistrationListener registrationListener, BridgefyClient bridgefyClient) {
        new Handler(Looper.getMainLooper()).post(new Runnable(bridgefyClient) {
            private final /* synthetic */ BridgefyClient f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                RegistrationListener.this.onRegistrationSuccessful(this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void on_registration_failed(RegistrationListener registrationListener, Throwable th) {
        com.bridgefy.sdk.logging.Log.m8075e("Bridgefy", "onRegistrationFailed: ", th);
        if (th instanceof BridgefyException) {
            new Handler(Looper.getMainLooper()).post(new Runnable(th) {
                private final /* synthetic */ Throwable f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    RegistrationListener.this.onRegistrationFailed(((BridgefyException) this.f$1).getErrorCode(), this.f$1.getMessage());
                }
            });
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable(th) {
                private final /* synthetic */ Throwable f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    RegistrationListener.this.onRegistrationFailed(-66, this.f$1.getMessage());
                }
            });
        }
    }

    public static String loadApiKey(Context context, String str) throws IllegalArgumentException {
        SharedPreferences sharedPreferences = context.getSharedPreferences(BuildConfig.APPLICATION_ID, 0);
        if (str == null) {
            try {
                String str2 = (String) context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get("com.bridgefy.sdk.API_KEY");
                if (str2 == null) {
                    str2 = sharedPreferences.getString("com.bridgefy.sdk.API_KEY", null);
                    if (str2 == null) {
                        throw new IllegalArgumentException("Missing API KEY in AndroidManifest.xml");
                    }
                }
                return str2;
            } catch (Exception unused) {
                throw new IllegalArgumentException("Missing or incorrect API KEY");
            }
        } else {
            sharedPreferences.edit().putString("com.bridgefy.sdk.API_KEY", str).apply();
            return str;
        }
    }

    public static void setMessageListener(MessageListener messageListener) {
        if (getInstance() != null) {
            try {
                getInstance().getBridgefyCore().setMessageListener(messageListener);
            } catch (NullPointerException unused) {
                throw new IllegalStateException("Bridgefy must be started before trying to set a MessageListener.");
            }
        } else {
            throw new IllegalStateException("Bridgefy must be initialized before trying to set a MessageListener.");
        }
    }

    public static void setStateListener(StateListener stateListener) {
        if (getInstance() != null) {
            try {
                getInstance().getBridgefyCore().setStateListener(stateListener);
            } catch (NullPointerException unused) {
                throw new IllegalStateException("Bridgefy must be started before trying to set a StateListener.");
            }
        } else {
            throw new IllegalStateException("Bridgefy must be initialized before trying to set a StateListener.");
        }
    }

    public Config getConfig() {
        return this.config;
    }

    public BridgefyClient getBridgefyClient() {
        return this.bridgefy_client;
    }

    public BridgefyCore getBridgefyCore() {
        return this.bridgefy_core;
    }

    public void setBridgefyCore(BridgefyCore bridgefyCore) {
        this.bridgefy_core = bridgefyCore;
    }

    public static boolean setEnergyProfile(BFEnergyProfile bFEnergyProfile) {
        try {
            getInstance().getConfig().setEnergyProfile(bFEnergyProfile);
            getInstance().getBridgefyCore().changeEnergyProfile(getInstance().getConfig().getAntennaType());
            return true;
        } catch (NullPointerException unused) {
            Log.e("Bridgefy", "Bridgefy must be started with Bridgefy.start() before setting an EnergyProfile.");
            return false;
        }
    }

    /* renamed from: a */
    private static void set_bridgefy(Bridgefy bridgefy) {
        bridgefy = bridgefy;
    }

    /* renamed from: a */
    private Context get_context() {
        return this.context;
    }

    /* renamed from: a */
    private void set_config(Config config) {
        this.config = config;
    }

    /* renamed from: a */
    private static void m7649a(Message message) {
        if (message == null) {
            throw new IllegalArgumentException("Message cannot be null.");
        }
    }
}
