package p140me.bridgefy.cloud;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.util.Pair;
import com.bridgefy.sdk.framework.entities.BleHandshake;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.zip.GZIPInputStream;
import p000a.p013b.emitter;
import p140me.bridgefy.backend.p143v3.bgfyKeyApi.BgfyKeyApi;
import p140me.bridgefy.backend.p143v3.bgfyKeyApi.model.BgfyKey;
import p140me.bridgefy.backend.p143v3.bgfyMessageApi.BgfyMessageApi;
import p140me.bridgefy.backend.p143v3.bgfyMessageApi.BgfyMessageApi.Builder;
import p140me.bridgefy.backend.p143v3.bgfyMessageApi.model.BgfyMessage;
import p140me.bridgefy.backend.p143v3.bgfyMessageApi.model.BgfyMessageCollection;
import p140me.bridgefy.backend.p143v3.bgfyMessageApi.model.EndpointMessageContainer;
import p140me.bridgefy.backend.p143v3.bgfyMessageApi.model.EndpointMessageListContainer;
import p140me.bridgefy.backend.p143v3.bgfyMessageApi.model.EndpointMessageResponse;
import p140me.bridgefy.backend.p143v3.bgfyUserApi.BgfyUserApi;
import p140me.bridgefy.backend.p143v3.bgfyUserApi.model.BgfyUser;
import p140me.bridgefy.backend.p143v3.bgfyUserApi.model.CollectionResponseBgfyUser;
import p140me.bridgefy.backend.p143v3.bgfyUserApi.model.EndpointPhoneListContainer;
import p140me.bridgefy.entities.BridgefyPeer;
import p140me.bridgefy.entities.Message;
import p140me.bridgefy.storage.C3642a;
import p140me.bridgefy.storage.service.UploadService;
import p140me.bridgefy.utils.C3659b;

/* renamed from: me.bridgefy.cloud.a */
/* compiled from: GoogleController */
public class C3517a {

    /* renamed from: b */
    private static C3517a google_controller;

    /* renamed from: a */
    private SharedPreferences shared_preferences;

    /* renamed from: c */
    private String id_token;

    /* renamed from: d */
    private BgfyUserApi bgfy_user_api;

    /* renamed from: e */
    private BgfyKeyApi bgfy_key_api;

    /* renamed from: f */
    private BgfyMessageApi bgfy_message_api;

    private C3517a(Context context) {
        this.shared_preferences = context.getSharedPreferences("BgfyPrefs", 0);
        request_acquire_id_token((emitter) null);
    }

    /* renamed from: a */
    public static void initialize_google_controller(Context context) {
        if (google_controller == null) {
            Log.i("GoogleController", "Initializing GoogleController");
            google_controller = new C3517a(context);
        }
    }

    /* renamed from: a */
    public static C3517a get_google_controller() {
        return google_controller;
    }

    /* renamed from: b */
    public static void reset_google_controller() {
        if (google_controller != null) {
            google_controller.bgfy_key_api = null;
            google_controller.bgfy_message_api = null;
            google_controller.bgfy_user_api = null;
            google_controller.id_token = null;
            google_controller = null;
        }
    }

    /* renamed from: a */
    public BgfyUser bgfy_user_api_insert_user(BgfyUser bgfyUser) throws IOException {
        bgfyUser.setCreatedAt(Long.valueOf(System.currentTimeMillis()));
        bgfyUser.setDevice(BleHandshake.DEVICE_TYPE);
        return (BgfyUser) this.bgfy_user_api.bgfyUser().insertUser(bgfyUser).execute();
    }

    /* renamed from: b */
    public BgfyUser bgfy_user_api_update_user(BgfyUser bgfyUser) throws IOException {
        bgfyUser.setDevice(BleHandshake.DEVICE_TYPE);
        if (bgfyUser.getDigitsId() != null) {
            return (BgfyUser) this.bgfy_user_api.bgfyUser().updateUser(bgfyUser).execute();
        }
        Log.w("GoogleController", "Provider Id was null, won't update user in backend.");
        throw new IOException("Digits Id was null, won't update user in backend.");
    }

    /* renamed from: c */
    public BgfyUser bgfy_user_api_get_self_user() throws Exception, AssertionError {
        StringBuilder sb = new StringBuilder();
        sb.append("getSelfUser() with idToken: ");
        sb.append(this.id_token);
        Log.v("GoogleController", sb.toString());
        return (BgfyUser) this.bgfy_user_api.bgfyUser().getSelfUser().execute();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public List<BridgefyPeer> bgfy_user_api_phone_list_to_peer(List<String> list) throws IOException {
        EndpointPhoneListContainer endpointPhoneListContainer = new EndpointPhoneListContainer();
        endpointPhoneListContainer.setPhoneList(list);
        CollectionResponseBgfyUser collectionResponseBgfyUser = (CollectionResponseBgfyUser) this.bgfy_user_api.contacts(endpointPhoneListContainer).execute();
        ArrayList arrayList = new ArrayList();
        List<BgfyUser> items = collectionResponseBgfyUser.getItems();
        if (items != null && !items.isEmpty()) {
            for (BgfyUser bridgefyPeer : items) {
                arrayList.add(new BridgefyPeer(bridgefyPeer));
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public List<BridgefyPeer> bgfy_user_api_phone_list_to_peer_contact(HashMap hashMap) throws IOException {
        EndpointPhoneListContainer endpointPhoneListContainer = new EndpointPhoneListContainer();
        ArrayList arrayList = new ArrayList();
        for (Entry key : hashMap.entrySet()) {
            arrayList.add(String.valueOf(key.getKey()));
        }
        endpointPhoneListContainer.setPhoneList(arrayList);
        CollectionResponseBgfyUser collectionResponseBgfyUser = (CollectionResponseBgfyUser) this.bgfy_user_api.contacts(endpointPhoneListContainer).execute();
        ArrayList arrayList2 = new ArrayList();
        List<BgfyUser> items = collectionResponseBgfyUser.getItems();
        if (items != null && !items.isEmpty()) {
            for (BgfyUser bgfyUser : items) {
                BridgefyPeer bridgefyPeer = new BridgefyPeer(bgfyUser);
                Pair pair = (Pair) hashMap.get(bgfyUser.getPhone());
                bridgefyPeer.setContactName((String) pair.first);
                bridgefyPeer.setLabel((String) pair.second);
                arrayList2.add(bridgefyPeer);
            }
        }
        return arrayList2;
    }

    /* renamed from: a */
    public String mo29183a(String str) throws IOException {
        return ((BgfyKey) this.bgfy_key_api.get(str).execute()).getLoad();
    }

    /* renamed from: a */
    public BgfyMessage mo29187a(Message message, long j) throws IOException {
        BgfyMessage bgfyMessage = new BgfyMessage();
        bgfyMessage.setDateSent(Long.valueOf(Long.parseLong(message.getDateSent())));
        bgfyMessage.setSender(message.getSender());
        bgfyMessage.setReceiver(message.getReceiver());
        bgfyMessage.setText(message.getText());
        bgfyMessage.setMessageType(Integer.valueOf(message.getType()));
        bgfyMessage.setLocalID(message.getOfflineId());
        return (BgfyMessage) this.bgfy_message_api.insert(bgfyMessage).setChecksumKey(Long.valueOf(j)).execute();
    }

    /* renamed from: b */
    public void mo29195b(Message message, long j) throws IOException {
        UploadService.m10850a(message, C3642a.m10779a().mo29736a(message, j));
    }

    /* renamed from: a */
    public EndpointMessageResponse mo29188a(ArrayList<BgfyMessage> arrayList) throws IOException {
        EndpointMessageContainer endpointMessageContainer = new EndpointMessageContainer();
        endpointMessageContainer.setBgfyMessageList(arrayList);
        return (EndpointMessageResponse) this.bgfy_message_api.insertList(endpointMessageContainer).execute();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Message mo29190a(Long l) throws Exception {
        BgfyMessage bgfyMessage = (BgfyMessage) this.bgfy_message_api.get(l).execute();
        Message message = new Message(bgfyMessage);
        if (message.getFileContent() != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bgfyMessage.decodeFileBytes()));
            byte[] bArr = new byte[4096];
            while (true) {
                int read = gZIPInputStream.read(bArr);
                if (read < 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            gZIPInputStream.close();
            message.setFileContent(byteArrayOutputStream.toByteArray());
            message.setMessageType(1);
        }
        return message;
    }

    /* renamed from: b */
    public Message mo29193b(Long l) throws IOException {
        return new Message((BgfyMessage) this.bgfy_message_api.getImage(l).execute());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public List<BgfyMessage> mo29186a(List<Long> list, int i) throws IOException {
        if (i == -1) {
            i = 2;
        } else if (i == 5) {
            i = 3;
        }
        EndpointMessageListContainer endpointMessageListContainer = new EndpointMessageListContainer();
        endpointMessageListContainer.setMessageIDs(list);
        endpointMessageListContainer.setMessagesStatus(Integer.valueOf(i));
        return ((BgfyMessageCollection) this.bgfy_message_api.updateStatusMessage(endpointMessageListContainer).execute()).getItems();
    }

    /* renamed from: c */
    private BgfyMessageApi m10264c(String str) {
        return new Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), http_request_initialize(str)).setApplicationName("Bridgefy").setRootUrl("https://bionic-torch-719.appspot.com/_ah/api/").setGoogleClientRequestInitializer((GoogleClientRequestInitializer) $$Lambda$a$P1wEO3iL2f48GEPXNfzBAbRwe8.INSTANCE).build();
    }

    /* renamed from: d */
    private BgfyKeyApi m10266d(String str) {
        return new BgfyKeyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), http_request_initialize(str)).setApplicationName("Bridgefy").setRootUrl("https://bionic-torch-719.appspot.com/_ah/api/").setGoogleClientRequestInitializer((GoogleClientRequestInitializer) $$Lambda$a$Ml6bVuYVlmSs8AsYrOPe7ie9Bvc.INSTANCE).build();
    }

    /* renamed from: e */
    private BgfyUserApi m10267e(String str) {
        return new BgfyUserApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), http_request_initialize(str)).setApplicationName("Bridgefy").setRootUrl("https://bionic-torch-719.appspot.com/_ah/api/").setGoogleClientRequestInitializer((GoogleClientRequestInitializer) $$Lambda$a$iGWdWwBLGzn1xSZB8F0id7612_Y.INSTANCE).build();
    }

    /* renamed from: f */
    private HttpRequestInitializer http_request_initialize(String str) {
        return new HttpRequestInitializer(str) {
            private final /* synthetic */ String f$0;

            {
                this.f$0 = r1;
            }

            public final void initialize(HttpRequest httpRequest) {
                C3517a.set_http_token_header(this.f$0, httpRequest);
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void set_http_token_header(String str, HttpRequest httpRequest) throws IOException {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("token", (Object) str);
        httpRequest.setHeaders(httpHeaders);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void request_acquire_id_token(emitter cVar) {
        try {
            FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
            if (currentUser != null) {
                Log.d("GoogleController", "Request to acquire id token...");
                currentUser.getIdToken(false).addOnSuccessListener((Executor) Executors.newSingleThreadExecutor(), (OnSuccessListener<? super TResult>) new OnSuccessListener(cVar) {
                    private final /* synthetic */ emitter f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onSuccess(Object obj) {
                        C3517a.this.try_set_bgfy_api_token(this.f$1, (GetTokenResult) obj);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    public final void onFailure(Exception exc) {
                        C3517a.m10258a(emitter.this, exc);
                    }
                });
                return;
            }
            throw new Exception("FirebaseUser is null. Has Digits migration completed?");
        } catch (Exception e) {
            if (cVar != null) {
                cVar.mo362a(e);
            } else {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void try_set_bgfy_api_token(emitter cVar, GetTokenResult getTokenResult) {
        try {
            String token = getTokenResult.getToken();
            StringBuilder sb = new StringBuilder();
            sb.append("... acquired id token: ");
            sb.append(token);
            Log.v("GoogleController", sb.toString());
            set_bgfy_api(token);
            this.id_token = token;
            if (cVar != null) {
                cVar.mo361a();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m10258a(emitter cVar, Exception exc) {
        exc.printStackTrace();
        if (cVar != null) {
            cVar.mo362a(exc);
        }
    }

    /* renamed from: g */
    private void set_bgfy_api(String str) {
        this.bgfy_user_api = m10267e(str);
        this.bgfy_key_api = m10266d(str);
        this.bgfy_message_api = m10264c(str);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public BgfyUserApi.BgfyUser get_bgfy_user_api_user() {
        return this.bgfy_user_api.bgfyUser();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public BgfyKeyApi get_bgfy_key_api() {
        return this.bgfy_key_api;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public BgfyMessageApi get_bgfy_message_api() {
        return this.bgfy_message_api;
    }

    /* renamed from: g */
    public String get_id_token() {
        return this.id_token;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public boolean id_token_not_null() {
        return this.id_token != null && !C3659b.m10910e(this.id_token);
    }

    /* renamed from: b */
    public void set_id_token(String str) {
        this.id_token = str;
    }
}
