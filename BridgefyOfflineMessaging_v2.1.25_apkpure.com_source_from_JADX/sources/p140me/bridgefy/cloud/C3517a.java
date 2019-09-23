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
import p000a.p013b.C0165c;
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
    private static C3517a f9154b;

    /* renamed from: a */
    private SharedPreferences f9155a;

    /* renamed from: c */
    private String f9156c;

    /* renamed from: d */
    private BgfyUserApi f9157d;

    /* renamed from: e */
    private BgfyKeyApi f9158e;

    /* renamed from: f */
    private BgfyMessageApi f9159f;

    private C3517a(Context context) {
        this.f9155a = context.getSharedPreferences("BgfyPrefs", 0);
        mo29191a((C0165c) null);
    }

    /* renamed from: a */
    public static void m10259a(Context context) {
        if (f9154b == null) {
            Log.i("GoogleController", "Initializing GoogleController");
            f9154b = new C3517a(context);
        }
    }

    /* renamed from: a */
    public static C3517a m10256a() {
        return f9154b;
    }

    /* renamed from: b */
    public static void m10262b() {
        if (f9154b != null) {
            f9154b.f9158e = null;
            f9154b.f9159f = null;
            f9154b.f9157d = null;
            f9154b.f9156c = null;
            f9154b = null;
        }
    }

    /* renamed from: a */
    public BgfyUser mo29189a(BgfyUser bgfyUser) throws IOException {
        bgfyUser.setCreatedAt(Long.valueOf(System.currentTimeMillis()));
        bgfyUser.setDevice(BleHandshake.DEVICE_TYPE);
        return (BgfyUser) this.f9157d.bgfyUser().insertUser(bgfyUser).execute();
    }

    /* renamed from: b */
    public BgfyUser mo29192b(BgfyUser bgfyUser) throws IOException {
        bgfyUser.setDevice(BleHandshake.DEVICE_TYPE);
        if (bgfyUser.getDigitsId() != null) {
            return (BgfyUser) this.f9157d.bgfyUser().updateUser(bgfyUser).execute();
        }
        Log.w("GoogleController", "Provider Id was null, won't update user in backend.");
        throw new IOException("Digits Id was null, won't update user in backend.");
    }

    /* renamed from: c */
    public BgfyUser mo29196c() throws Exception, AssertionError {
        StringBuilder sb = new StringBuilder();
        sb.append("getSelfUser() with idToken: ");
        sb.append(this.f9156c);
        Log.v("GoogleController", sb.toString());
        return (BgfyUser) this.f9157d.bgfyUser().getSelfUser().execute();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public List<BridgefyPeer> mo29185a(List<String> list) throws IOException {
        EndpointPhoneListContainer endpointPhoneListContainer = new EndpointPhoneListContainer();
        endpointPhoneListContainer.setPhoneList(list);
        CollectionResponseBgfyUser collectionResponseBgfyUser = (CollectionResponseBgfyUser) this.f9157d.contacts(endpointPhoneListContainer).execute();
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
    public List<BridgefyPeer> mo29184a(HashMap hashMap) throws IOException {
        EndpointPhoneListContainer endpointPhoneListContainer = new EndpointPhoneListContainer();
        ArrayList arrayList = new ArrayList();
        for (Entry key : hashMap.entrySet()) {
            arrayList.add(String.valueOf(key.getKey()));
        }
        endpointPhoneListContainer.setPhoneList(arrayList);
        CollectionResponseBgfyUser collectionResponseBgfyUser = (CollectionResponseBgfyUser) this.f9157d.contacts(endpointPhoneListContainer).execute();
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
        return ((BgfyKey) this.f9158e.get(str).execute()).getLoad();
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
        return (BgfyMessage) this.f9159f.insert(bgfyMessage).setChecksumKey(Long.valueOf(j)).execute();
    }

    /* renamed from: b */
    public void mo29195b(Message message, long j) throws IOException {
        UploadService.m10850a(message, C3642a.m10779a().mo29736a(message, j));
    }

    /* renamed from: a */
    public EndpointMessageResponse mo29188a(ArrayList<BgfyMessage> arrayList) throws IOException {
        EndpointMessageContainer endpointMessageContainer = new EndpointMessageContainer();
        endpointMessageContainer.setBgfyMessageList(arrayList);
        return (EndpointMessageResponse) this.f9159f.insertList(endpointMessageContainer).execute();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Message mo29190a(Long l) throws Exception {
        BgfyMessage bgfyMessage = (BgfyMessage) this.f9159f.get(l).execute();
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
        return new Message((BgfyMessage) this.f9159f.getImage(l).execute());
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
        return ((BgfyMessageCollection) this.f9159f.updateStatusMessage(endpointMessageListContainer).execute()).getItems();
    }

    /* renamed from: c */
    private BgfyMessageApi m10264c(String str) {
        return new Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), m10268f(str)).setApplicationName("Bridgefy").setRootUrl("https://bionic-torch-719.appspot.com/_ah/api/").setGoogleClientRequestInitializer((GoogleClientRequestInitializer) $$Lambda$a$P1wEO3iL2f48GEPXNfzBAbRwe8.INSTANCE).build();
    }

    /* renamed from: d */
    private BgfyKeyApi m10266d(String str) {
        return new BgfyKeyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), m10268f(str)).setApplicationName("Bridgefy").setRootUrl("https://bionic-torch-719.appspot.com/_ah/api/").setGoogleClientRequestInitializer((GoogleClientRequestInitializer) $$Lambda$a$Ml6bVuYVlmSs8AsYrOPe7ie9Bvc.INSTANCE).build();
    }

    /* renamed from: e */
    private BgfyUserApi m10267e(String str) {
        return new BgfyUserApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), m10268f(str)).setApplicationName("Bridgefy").setRootUrl("https://bionic-torch-719.appspot.com/_ah/api/").setGoogleClientRequestInitializer((GoogleClientRequestInitializer) $$Lambda$a$iGWdWwBLGzn1xSZB8F0id7612_Y.INSTANCE).build();
    }

    /* renamed from: f */
    private HttpRequestInitializer m10268f(String str) {
        return new HttpRequestInitializer(str) {
            private final /* synthetic */ String f$0;

            {
                this.f$0 = r1;
            }

            public final void initialize(HttpRequest httpRequest) {
                C3517a.m10261a(this.f$0, httpRequest);
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m10261a(String str, HttpRequest httpRequest) throws IOException {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("token", (Object) str);
        httpRequest.setHeaders(httpHeaders);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo29191a(C0165c cVar) {
        try {
            FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
            if (currentUser != null) {
                Log.d("GoogleController", "Request to acquire id token...");
                currentUser.getIdToken(false).addOnSuccessListener((Executor) Executors.newSingleThreadExecutor(), (OnSuccessListener<? super TResult>) new OnSuccessListener(cVar) {
                    private final /* synthetic */ C0165c f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onSuccess(Object obj) {
                        C3517a.this.m10257a(this.f$1, (GetTokenResult) obj);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    public final void onFailure(Exception exc) {
                        C3517a.m10258a(C0165c.this, exc);
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
    public /* synthetic */ void m10257a(C0165c cVar, GetTokenResult getTokenResult) {
        try {
            String token = getTokenResult.getToken();
            StringBuilder sb = new StringBuilder();
            sb.append("... acquired id token: ");
            sb.append(token);
            Log.v("GoogleController", sb.toString());
            m10269g(token);
            this.f9156c = token;
            if (cVar != null) {
                cVar.mo361a();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m10258a(C0165c cVar, Exception exc) {
        exc.printStackTrace();
        if (cVar != null) {
            cVar.mo362a(exc);
        }
    }

    /* renamed from: g */
    private void m10269g(String str) {
        this.f9157d = m10267e(str);
        this.f9158e = m10266d(str);
        this.f9159f = m10264c(str);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public BgfyUserApi.BgfyUser mo29197d() {
        return this.f9157d.bgfyUser();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public BgfyKeyApi mo29198e() {
        return this.f9158e;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public BgfyMessageApi mo29199f() {
        return this.f9159f;
    }

    /* renamed from: g */
    public String mo29200g() {
        return this.f9156c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public boolean mo29201h() {
        return this.f9156c != null && !C3659b.m10910e(this.f9156c);
    }

    /* renamed from: b */
    public void mo29194b(String str) {
        this.f9156c = str;
    }
}
