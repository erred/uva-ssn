package p140me.bridgefy.cloud;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import com.bridgefy.sdk.client.Bridgefy;
import com.bridgefy.sdk.framework.entities.BleHandshake;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p000a.p013b.C0159b;
import p000a.p013b.emitter;
import p000a.p013b.C0176d;
import p000a.p013b.C0184e;
import p000a.p013b.C0323f;
import p000a.p013b.C0345l;
import p000a.p013b.C0346m;
import p000a.p013b.C0347n;
import p000a.p013b.C0348o;
import p000a.p013b.C0349p;
import p000a.p013b.C0353r;
import p000a.p013b.C0354s;
import p000a.p013b.C0355t;
import p000a.p013b.C0356u;
import p000a.p013b.C0357v;
import p000a.p013b.p014a.p016b.C0153a;
import p000a.p013b.p017b.C0161b;
import p000a.p013b.p038h.C0331a;
import p140me.bridgefy.backend.p143v3.bgfyKeyApi.model.BgfyKey;
import p140me.bridgefy.backend.p143v3.bgfyUserApi.model.BgfyUser;
import p140me.bridgefy.entities.BridgefyPeer;
import p140me.bridgefy.entities.Message;
import p140me.bridgefy.ormlite.entities.FriendDTO;
import p140me.bridgefy.ormlite.entities.MessageDTO;
import p140me.bridgefy.p141a.C3457c;
import p140me.bridgefy.service.BridgefyService;
import p140me.bridgefy.utils.C3662d;

/* renamed from: me.bridgefy.cloud.c */
/* compiled from: ObservableFactory */
public class C3519c {

    /* renamed from: a */
    public static C0159b f9160a = C0159b.m542a((C0184e) $$Lambda$c$MDjc_cyiv2PaNMs5r7CJUtgWm0.INSTANCE);

    /* renamed from: me.bridgefy.cloud.c$a */
    /* compiled from: ObservableFactory */
    public static class C3521a implements C0176d {
        public void onComplete() {
        }

        public void onSubscribe(C0161b bVar) {
        }

        public void onError(Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: me.bridgefy.cloud.c$b */
    /* compiled from: ObservableFactory */
    public static class C3522b<T> implements C0349p<T> {
        public void onComplete() {
        }

        public void onNext(T t) {
        }

        public void onSubscribe(C0161b bVar) {
        }

        public void onError(Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: me.bridgefy.cloud.c$c */
    /* compiled from: ObservableFactory */
    public static class C3523c<T> implements C0355t<T> {
        public void onSubscribe(C0161b bVar) {
        }

        public void onSuccess(T t) {
        }

        public void onError(Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    private static void m10294a(C0159b bVar, C3521a aVar) {
        f9160a.mo346b((C0323f) bVar).mo347b(C0331a.m925b()).mo342a(C0153a.m534a()).mo345a((C0176d) aVar);
    }

    /* renamed from: a */
    private static void m10297a(C0353r rVar, C3523c cVar) {
        f9160a.mo344a((C0357v<T>) rVar).mo564b(C0331a.m925b()).mo562a(C0153a.m534a()).mo563a((C0355t<? super T>) cVar);
    }

    /* renamed from: a */
    private static void m10296a(C0345l lVar, C3522b bVar) {
        f9160a.mo343a((C0348o<T>) lVar).mo557b(C0331a.m925b()).mo554a(C0153a.m534a()).mo556a((C0349p<? super T>) bVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m10295a(emitter cVar) throws Exception {
        if (google_controller.get_google_controller().id_token_not_null()) {
            cVar.mo361a();
        } else {
            google_controller.get_google_controller().request_acquire_id_token(cVar);
        }
    }

    /* renamed from: a */
    public static void m10312a(BgfyUser bgfyUser, C3521a aVar) {
        if (aVar == null) {
            aVar = new C3521a();
        }
        m10294a(C0159b.m542a((C0184e) new C0184e() {
            public final void subscribe(emitter cVar) {
                C3519c.m10317b(BgfyUser.this, cVar);
            }
        }), aVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m10317b(BgfyUser bgfyUser, emitter cVar) throws Exception {
        bgfyUser.setDevice(BleHandshake.DEVICE_TYPE);
        if (bgfyUser.getDigitsId() != null) {
            google_controller.get_google_controller().bgfy_user_api_update_user(bgfyUser);
            StringBuilder sb = new StringBuilder();
            sb.append("Updated user in backend: ");
            sb.append(bgfyUser.getUuid());
            Log.d("ObservableFactory", sb.toString());
            cVar.mo361a();
            return;
        }
        Log.w("ObservableFactory", "digitsId was null, won't update user in backend.");
        cVar.mo362a(new Exception("digitsId was null, won't update user in backend."));
    }

    /* renamed from: b */
    public static void m10318b(BgfyUser bgfyUser, C3521a aVar) {
        if (aVar == null) {
            aVar = new C3521a();
        }
        m10294a(C0159b.m542a((C0184e) new C0184e() {
            public final void subscribe(emitter cVar) {
                C3519c.m10311a(BgfyUser.this, cVar);
            }
        }), aVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m10311a(BgfyUser bgfyUser, emitter cVar) throws Exception {
        bgfyUser.setDevice(BleHandshake.DEVICE_TYPE);
        if (bgfyUser.getDigitsId() != null) {
            google_controller.get_google_controller().bgfy_user_api_insert_user(bgfyUser);
            StringBuilder sb = new StringBuilder();
            sb.append("Inserted user in backend: ");
            sb.append(bgfyUser.getUuid());
            Log.d("ObservableFactory", sb.toString());
            cVar.mo361a();
            return;
        }
        Log.e("ObservableFactory", "digitsId was null, won't insert user in backend.");
        cVar.mo362a(new Exception("digitsId was null, won't insert user in backend."));
    }

    /* renamed from: a */
    public static void m10314a(C3523c cVar) {
        if (cVar == null) {
            cVar = new C3523c();
        }
        m10297a(C0353r.m949a((C0356u<T>) $$Lambda$c$uqgkKdRtBZROYV8ofddTIQPCObA.INSTANCE), cVar);
    }

    /* renamed from: a */
    public static void m10307a(String str, C3521a aVar) {
        if (aVar == null) {
            aVar = new C3521a();
        }
        m10294a(C0159b.m542a((C0184e) new C0184e(str) {
            private final /* synthetic */ String f$0;

            {
                this.f$0 = r1;
            }

            public final void subscribe(emitter cVar) {
                C3519c.m10315b(this.f$0, cVar);
            }
        }), aVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m10315b(String str, emitter cVar) throws Exception {
        google_controller.get_google_controller().get_bgfy_user_api_user().blockUser(str).execute();
        cVar.mo361a();
    }

    /* renamed from: b */
    public static void m10316b(String str, C3521a aVar) {
        if (aVar == null) {
            aVar = new C3521a();
        }
        m10294a(C0159b.m542a((C0184e) new C0184e(str) {
            private final /* synthetic */ String f$0;

            {
                this.f$0 = r1;
            }

            public final void subscribe(emitter cVar) {
                C3519c.m10302a(this.f$0, cVar);
            }
        }), aVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m10302a(String str, emitter cVar) throws Exception {
        google_controller.get_google_controller().get_bgfy_user_api_user().unblockUser(str).execute();
        cVar.mo361a();
    }

    /* renamed from: a */
    public static void m10300a(SharedPreferences sharedPreferences, C3457c cVar, C3662d dVar, C3522b bVar) {
        if (bVar == null) {
            bVar = new C3522b();
        }
        m10296a(C0345l.m934a((C0347n<T>) new C0347n(sharedPreferences, dVar, cVar) {
            private final /* synthetic */ SharedPreferences f$0;
            private final /* synthetic */ C3662d f$1;
            private final /* synthetic */ C3457c f$2;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void subscribe(C0346m mVar) {
                C3519c.m10301a(this.f$0, this.f$1, this.f$2, mVar);
            }
        }), bVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m10301a(SharedPreferences sharedPreferences, C3662d dVar, C3457c cVar, C0346m mVar) throws Exception {
        String string = sharedPreferences.getString("user_phone", null);
        if (string != null) {
            string = C3662d.m10924c(string);
        }
        List<BridgefyPeer> a = google_controller.get_google_controller().bgfy_user_api_phone_list_to_peer_contact(dVar.get_phone_records(string));
        a.addAll(google_controller.get_google_controller().bgfy_user_api_phone_list_to_peer((List<String>) new C3457c(BridgefyService.get_database_helper()).get_friends_other_phone_numbers(string)));
        for (BridgefyPeer bridgefyPeer : a) {
            FriendDTO friendDTO = new FriendDTO(bridgefyPeer);
            FriendDTO c = cVar.query_friend_dto_by_id(bridgefyPeer.getId());
            if (c != null) {
                friendDTO.setPublicKey(c.getPublicKey());
                friendDTO.setColor(c.getColor());
                friendDTO.setBlockedStatus(c.getBlockedStatus());
            }
            cVar.set_friend_dto(friendDTO);
            mVar.on_next(bridgefyPeer);
        }
        mVar.mo427f_();
    }

    /* renamed from: a */
    public static void m10306a(String str, String str2, C3521a aVar) {
        if (aVar == null) {
            aVar = new C3521a();
        }
        m10294a(C0159b.m542a((C0184e) new C0184e(str, str2) {
            private final /* synthetic */ String f$0;
            private final /* synthetic */ String f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void subscribe(emitter cVar) {
                C3519c.m10305a(this.f$0, this.f$1, cVar);
            }
        }), aVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m10305a(String str, String str2, emitter cVar) throws Exception {
        google_controller.get_google_controller().get_bgfy_message_api().deleteConversation(str, str2).execute();
        cVar.mo361a();
    }

    /* renamed from: a */
    public static void m10293a(long j, C3523c cVar) {
        if (cVar == null) {
            cVar = new C3523c();
        }
        m10297a(C0353r.m949a((C0356u<T>) new C0356u(j) {
            private final /* synthetic */ long f$0;

            {
                this.f$0 = r1;
            }

            public final void subscribe(C0354s sVar) {
                C3519c.m10292a(this.f$0, sVar);
            }
        }), cVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m10292a(long j, C0354s sVar) throws Exception {
        try {
            Message a = google_controller.get_google_controller().mo29190a(Long.valueOf(j));
            if (a != null) {
                sVar.mo463a(a);
            }
        } catch (Exception e) {
            sVar.mo464a((Throwable) e);
        }
    }

    /* renamed from: a */
    public static void m10310a(ArrayList<MessageDTO> arrayList, int i, C3522b bVar) {
        if (bVar == null) {
            bVar = new C3522b();
        }
        m10296a(C0345l.m934a((C0347n<T>) new C0347n(arrayList, i) {
            private final /* synthetic */ ArrayList f$0;
            private final /* synthetic */ int f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void subscribe(C0346m mVar) {
                C3519c.m10309a(this.f$0, this.f$1, mVar);
            }
        }), bVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m10309a(ArrayList arrayList, int i, C0346m mVar) throws Exception {
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                MessageDTO messageDTO = (MessageDTO) it.next();
                try {
                    arrayList2.add(Long.valueOf(Long.parseLong(messageDTO.getMessageId())));
                } catch (NumberFormatException unused) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Won't update mesh message status on the backend: ");
                    sb.append(messageDTO.getMessageId());
                    Log.e("ObservableFactory", sb.toString());
                }
            }
            google_controller.get_google_controller().mo29186a((List<Long>) arrayList2, i);
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                mVar.on_next((MessageDTO) it2.next());
            }
        }
        mVar.mo427f_();
    }

    /* renamed from: a */
    public static void m10313a(C3521a aVar) {
        if (aVar == null) {
            aVar = new C3521a();
        }
        m10294a(C0159b.m542a((C0184e) new C0184e() {

            /* renamed from: a */
            BgfyKey f9161a = new BgfyKey();

            public void subscribe(emitter cVar) throws Exception {
                String userUuid = Bridgefy.getInstance().getBridgefyClient().getUserUuid();
                String publicKey = Bridgefy.getInstance().getBridgefyClient().getPublicKey();
                if (userUuid == null || publicKey == null) {
                    throw new Exception("Constants.PREFS_USER_UUID or Bridgefy.PUBLIC_KEY was null!");
                }
                this.f9161a.setLoad(publicKey);
                this.f9161a.setOwner(userUuid);
                google_controller.get_google_controller().get_bgfy_key_api().bgfyKey().insertKey(this.f9161a).execute();
                cVar.mo361a();
            }
        }), aVar);
    }

    /* renamed from: a */
    public static void m10308a(String str, C3523c cVar) {
        if (cVar == null) {
            cVar = new C3523c();
        }
        m10297a(C0353r.m949a((C0356u<T>) new C0356u(str) {
            private final /* synthetic */ String f$0;

            {
                this.f$0 = r1;
            }

            public final void subscribe(C0354s sVar) {
                sVar.mo463a(google_controller.get_google_controller().mo29183a(this.f$0));
            }
        }), cVar);
    }

    /* renamed from: a */
    public static void m10304a(String str, Context context, C3521a aVar) {
        if (aVar == null) {
            aVar = new C3521a();
        }
        m10294a(C0159b.m542a((C0184e) new C0184e(context, str) {
            private final /* synthetic */ Context f$0;
            private final /* synthetic */ String f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void subscribe(emitter cVar) {
                C3519c.m10299a(this.f$0, this.f$1, cVar);
            }
        }), aVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m10299a(Context context, String str, emitter cVar) throws Exception {
        SharedPreferences sharedPreferences = context.getSharedPreferences("BgfyPrefs", 0);
        Editor edit = sharedPreferences.edit();
        String string = sharedPreferences.getString("cgmRegistrationId", null);
        if (string == null || string.equals(str)) {
            cVar.mo361a();
            return;
        }
        try {
            BgfyUser c = google_controller.get_google_controller().bgfy_user_api_get_self_user();
            if (c != null) {
                c.setRegistrationId(str);
                google_controller.get_google_controller().bgfy_user_api_update_user(c);
            } else {
                edit.clear();
            }
            cVar.mo361a();
        } catch (Error | Exception e) {
            e.printStackTrace();
            cVar.mo362a(e);
        }
    }
}
