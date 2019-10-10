package p140me.bridgefy.p141a;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.QueryBuilder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import net.sqlcipher.database.SQLiteException;
import p140me.bridgefy.cloud.C3518b;
import p140me.bridgefy.cloud.C3519c;
import p140me.bridgefy.cloud.C3519c.C3521a;
import p140me.bridgefy.entities.BridgefyPeer;
import p140me.bridgefy.main.BridgefyApp;
import p140me.bridgefy.ormlite.DatabaseHelper;
import p140me.bridgefy.ormlite.entities.FriendDTO;
import p140me.bridgefy.ormlite.exception.OrmLiteBridgefyException;
import p140me.bridgefy.utils.C3662d;

/* renamed from: me.bridgefy.a.c */
/* compiled from: FriendController */
public class C3457c extends C3456b {

    /* renamed from: a */
    private final String f8957a;

    /* renamed from: b */
    private RuntimeExceptionDao<FriendDTO, String> f8958b;

    public C3457c(Activity activity) throws OrmLiteBridgefyException {
        super(activity);
        this.f8957a = "FriendsController";
        this.f8958b = mo28313a().getFriendRuntimeDAO();
    }

    public C3457c(DatabaseHelper databaseHelper) {
        super(databaseHelper);
        this.f8957a = "FriendsController";
        this.f8958b = databaseHelper.getFriendRuntimeDAO();
    }

    /* renamed from: b */
    public void mo28321b() {
        Iterator it = mo28324d().entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            String str = (String) entry.getKey();
            int intValue = ((Integer) entry.getValue()).intValue();
            StringBuilder sb = new StringBuilder();
            sb.append("Processing (un)blocked userId: ");
            sb.append(str);
            sb.append(" with status: ");
            sb.append(intValue);
            Log.d("FriendsController", sb.toString());
            final FriendDTO c = query_friend_dto_by_id(str);
            switch (intValue) {
                case 1:
                    C3519c.m10316b(str, (C3521a) new C3521a() {
                        public void onComplete() {
                            c.setBlockedStatus(0);
                            C3457c.this.set_friend_dto(c);
                        }

                        public void onError(Throwable th) {
                            th.printStackTrace();
                            C3518b.m10290a(BridgefyApp.m10557c().getApplicationContext(), 6004);
                        }
                    });
                    break;
                case 2:
                    C3519c.m10307a(str, (C3521a) new C3521a() {
                        public void onComplete() {
                            c.setBlockedStatus(3);
                            C3457c.this.set_friend_dto(c);
                        }

                        public void onError(Throwable th) {
                            th.printStackTrace();
                            C3518b.m10290a(BridgefyApp.m10557c().getApplicationContext(), 6004);
                        }
                    });
                    break;
            }
            it.remove();
        }
    }

    /* renamed from: a */
    public String mo28315a(String str) {
        FriendDTO friendDTO = (FriendDTO) this.f8958b.queryForId(str.toLowerCase());
        if (friendDTO != null) {
            return friendDTO.getPublicKey();
        }
        return null;
    }

    /* renamed from: a */
    public void set_friend_dto(FriendDTO friendDTO) {
        friendDTO.set((RuntimeExceptionDao) this.f8958b);
    }

    /* renamed from: a */
    public void mo28318a(String str, String str2) {
        FriendDTO friendDTO = (FriendDTO) this.f8958b.queryForId(str.toLowerCase());
        if (friendDTO != null) {
            friendDTO.setPublicKey(str2);
            if (friendDTO.update(this.f8958b)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Updated local public key for userId: ");
                sb.append(str);
                Log.i("FriendsController", sb.toString());
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unable to update local public key for userId: ");
            sb2.append(str);
            Log.w("FriendsController", sb2.toString());
            return;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Didn't find user to update local key with userId: ");
        sb3.append(str);
        Log.w("FriendsController", sb3.toString());
    }

    /* renamed from: a */
    public List<BridgefyPeer> mo28317a(boolean z) {
        ArrayList arrayList = new ArrayList();
        try {
            for (FriendDTO friendDTO : this.f8958b.query(this.f8958b.queryBuilder().orderBy(FriendDTO.CONTACT_NAME, true).distinct().prepare())) {
                if (z || friendDTO.getContactName() != null) {
                    arrayList.add(new BridgefyPeer(friendDTO));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    /* renamed from: b */
    public ArrayList<String> get_friends_other_phone_numbers(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            QueryBuilder queryBuilder = this.f8958b.queryBuilder();
            queryBuilder.where().isNull(FriendDTO.CONTACT_NAME);
            for (FriendDTO friendDTO : this.f8958b.query(queryBuilder.prepare())) {
                try {
                    if (!friendDTO.getPhoneNumber().equals(str)) {
                        arrayList.add(C3662d.m10924c(friendDTO.getPhoneNumber()));
                    }
                } catch (NullPointerException unused) {
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    /* renamed from: c */
    public FriendDTO query_friend_dto_by_id(String str) {
        if (str == null) {
            return null;
        }
        return (FriendDTO) this.f8958b.queryForId(str);
    }

    /* renamed from: d */
    public FriendDTO mo28325d(String str) {
        if (str == null) {
            return null;
        }
        try {
            QueryBuilder queryBuilder = this.f8958b.queryBuilder();
            queryBuilder.where().mo27052eq(FriendDTO.BLUETOOTH_ADDRESS, str);
            return (FriendDTO) this.f8958b.queryForFirst(queryBuilder.prepare());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (SQLiteException e2) {
            mo28314a(e2);
            return null;
        }
    }

    /* renamed from: e */
    public FriendDTO mo28326e(String str) {
        if (str == null) {
            return null;
        }
        try {
            QueryBuilder queryBuilder = this.f8958b.queryBuilder();
            queryBuilder.where().mo27052eq(FriendDTO.PHONE_NUMBER, str);
            return (FriendDTO) this.f8958b.queryForFirst(queryBuilder.prepare());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (SQLiteException e2) {
            mo28314a(e2);
            return null;
        }
    }

    /* renamed from: a */
    public String mo28316a(FriendDTO friendDTO, String str, String str2, String str3, Context context) {
        if (friendDTO != null && friendDTO.getContactName() != null && friendDTO.getContactName().length() > 0) {
            return friendDTO.getContactName();
        }
        if (friendDTO != null && friendDTO.getPhoneNumber() != null && friendDTO.getUsername() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(friendDTO.getUsername());
            sb.append(" (");
            sb.append(friendDTO.getPhoneNumber());
            sb.append(")");
            return sb.toString();
        } else if (friendDTO != null && friendDTO.getUsername() != null && friendDTO.getUsername().length() > 0) {
            return friendDTO.getUsername();
        } else {
            if (friendDTO == null && context != null) {
                try {
                    String a = C3662d.m10919a(context, str3);
                    if (a != null) {
                        return a;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (str3 == null || str2 == null) {
                return str3 == null ? str2 : str;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append(" (");
            sb2.append(str3);
            sb2.append(")");
            return sb2.toString();
        }
    }

    /* renamed from: f */
    public void mo28327f(String str) {
        FriendDTO c = query_friend_dto_by_id(str);
        if (c != null) {
            c.setBlockedStatus(2);
            c.set((RuntimeExceptionDao) this.f8958b);
            StringBuilder sb = new StringBuilder();
            sb.append("Succesfully blocked user: ");
            sb.append(str);
            Log.d("FriendsController", sb.toString());
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("User wasn't found: ");
        sb2.append(str);
        Log.w("FriendsController", sb2.toString());
    }

    /* renamed from: g */
    public void mo28328g(String str) {
        FriendDTO c = query_friend_dto_by_id(str);
        if (c != null) {
            c.setBlockedStatus(1);
            c.set((RuntimeExceptionDao) this.f8958b);
            StringBuilder sb = new StringBuilder();
            sb.append("Succesfully unblocked user: ");
            sb.append(str);
            Log.d("FriendsController", sb.toString());
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("User wasn't found: ");
        sb2.append(str);
        Log.w("FriendsController", sb2.toString());
    }

    /* renamed from: c */
    public ArrayList<FriendDTO> mo28322c() {
        try {
            QueryBuilder queryBuilder = this.f8958b.queryBuilder();
            queryBuilder.where().between(FriendDTO.BLOCKED, Integer.valueOf(2), Integer.valueOf(3));
            return (ArrayList) this.f8958b.query(queryBuilder.prepare());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: h */
    public boolean mo28329h(String str) {
        boolean z = false;
        try {
            QueryBuilder queryBuilder = this.f8958b.queryBuilder();
            queryBuilder.where().between(FriendDTO.BLOCKED, Integer.valueOf(2), Integer.valueOf(3)).and().mo27052eq("id", str);
            if (this.f8958b.queryForFirst(queryBuilder.prepare()) != null) {
                z = true;
            }
            return z;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: d */
    public HashMap<String, Integer> mo28324d() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        try {
            QueryBuilder queryBuilder = this.f8958b.queryBuilder();
            queryBuilder.where().between(FriendDTO.BLOCKED, Integer.valueOf(1), Integer.valueOf(2));
            for (FriendDTO friendDTO : this.f8958b.query(queryBuilder.prepare())) {
                hashMap.put(friendDTO.getId(), Integer.valueOf(friendDTO.getBlockedStatus()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hashMap;
    }
}
