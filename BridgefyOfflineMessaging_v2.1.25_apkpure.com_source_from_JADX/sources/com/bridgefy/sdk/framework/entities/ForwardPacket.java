package com.bridgefy.sdk.framework.entities;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.bridgefy.sdk.client.BFEngineProfile;
import com.bridgefy.sdk.client.Bridgefy;
import com.bridgefy.sdk.client.Message;
import com.bridgefy.sdk.framework.controller.Constants;
import com.bridgefy.sdk.framework.utils.Utils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import net.sqlcipher.database.SQLiteDatabase;
import org.joda.time.DateTimeConstants;

public class ForwardPacket implements Parcelable, Comparable {
    public static final Creator<ForwardPacket> CREATOR = new Creator<ForwardPacket>() {
        /* renamed from: a */
        public ForwardPacket createFromParcel(Parcel parcel) {
            return new ForwardPacket(parcel);
        }

        /* renamed from: a */
        public ForwardPacket[] newArray(int i) {
            return new ForwardPacket[i];
        }
    };
    public static final int RECEIVER_TYPE_BROADCAST = 1;
    public static final int RECEIVER_TYPE_CONTACT = 0;

    /* renamed from: n */
    private static int[] f6035n = {100, 50, 100, SQLiteDatabase.MAX_SQL_CACHE_SIZE, 50, 50};

    /* renamed from: o */
    private static int[] f6036o = {DateTimeConstants.SECONDS_PER_DAY, DateTimeConstants.SECONDS_PER_HOUR, 302400, DateTimeConstants.SECONDS_PER_WEEK, 1800, DateTimeConstants.SECONDS_PER_DAY};

    /* renamed from: p */
    private static int[] f6037p = {15000, 10000, 10000, 15000, 10000, 10000};

    /* renamed from: q */
    private static int[] f6038q = {200, 50, SQLiteDatabase.MAX_SQL_CACHE_SIZE, 1000, 50, 1};
    @JsonProperty("id")

    /* renamed from: a */
    String f6039a;
    @JsonProperty("payload")

    /* renamed from: b */
    HashMap<String, Object> f6040b;
    @JsonProperty("enc_payload")

    /* renamed from: c */
    int f6041c;
    @JsonProperty("sender")

    /* renamed from: d */
    String f6042d;
    @JsonProperty("receiver")

    /* renamed from: e */
    String f6043e;
    @JsonProperty("creation")

    /* renamed from: f */
    long f6044f;
    @JsonProperty("expiration")

    /* renamed from: g */
    long f6045g;
    @JsonProperty("receiver_type")

    /* renamed from: h */
    int f6046h;
    @JsonProperty("hops")

    /* renamed from: i */
    int f6047i;
    @JsonProperty("profile")

    /* renamed from: j */
    int f6048j;
    @JsonProperty("track")

    /* renamed from: k */
    ArrayList<Long> f6049k;
    @JsonIgnore

    /* renamed from: l */
    int f6050l;
    @JsonIgnore

    /* renamed from: m */
    Date f6051m;
    @JsonIgnore

    /* renamed from: r */
    private byte[] f6052r;

    public int describeContents() {
        return 0;
    }

    public ForwardPacket() {
        this.f6041c = -1;
        this.f6049k = new ArrayList<>();
    }

    public ForwardPacket(Message message, int i) {
        this.f6041c = -1;
        this.f6049k = new ArrayList<>();
        this.f6048j = BFEngineProfile.BFConfigProfileDefault.ordinal();
        this.f6044f = message.getDateSent();
        this.f6039a = message.getUuid() == null ? UUID.randomUUID().toString() : message.getUuid();
        this.f6042d = message.getSenderId();
        this.f6043e = message.getReceiverId();
        this.f6046h = i;
        this.f6051m = new Date(System.currentTimeMillis());
        this.f6045g = (long) mo7600a();
        this.f6050l = mo7603c();
        this.f6047i = getHopsLimitForEngineProfile();
        this.f6040b = message.getContent();
        addTrackingCRC(Utils.getCrcFromKey(Bridgefy.getInstance().getBridgefyClient().getUserUuid()));
    }

    public ForwardPacket(Message message, int i, BFEngineProfile bFEngineProfile) {
        this.f6041c = -1;
        this.f6049k = new ArrayList<>();
        this.f6048j = bFEngineProfile.ordinal();
        this.f6044f = message.getDateSent();
        this.f6039a = message.getUuid() == null ? UUID.randomUUID().toString() : message.getUuid();
        this.f6042d = message.getSenderId();
        this.f6043e = message.getReceiverId();
        this.f6046h = i;
        this.f6051m = new Date(System.currentTimeMillis());
        this.f6045g = (long) mo7600a();
        this.f6050l = mo7603c();
        this.f6047i = getHopsLimitForEngineProfile();
        this.f6040b = message.getContent();
        addTrackingCRC(Utils.getCrcFromKey(Bridgefy.getInstance().getBridgefyClient().getUserUuid()));
    }

    protected ForwardPacket(Parcel parcel) {
        this.f6041c = -1;
        this.f6049k = new ArrayList<>();
        this.f6047i = parcel.readInt();
        this.f6044f = parcel.readLong();
        this.f6039a = parcel.readString();
        this.f6045g = parcel.readLong();
        this.f6040b = (HashMap) new Gson().fromJson(parcel.readString(), Constants.TYPE);
        this.f6041c = parcel.readInt();
        this.f6049k = (ArrayList) parcel.readSerializable();
        this.f6042d = parcel.readString();
        this.f6046h = parcel.readInt();
        this.f6043e = parcel.readString();
        this.f6048j = parcel.readInt();
        this.f6051m = new Date(parcel.readLong());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f6047i);
        parcel.writeLong(this.f6044f);
        parcel.writeString(this.f6039a);
        parcel.writeLong(this.f6045g);
        parcel.writeString(new Gson().toJson((Object) this.f6040b));
        parcel.writeInt(this.f6041c);
        parcel.writeSerializable(this.f6049k);
        parcel.writeString(this.f6042d);
        parcel.writeInt(this.f6046h);
        parcel.writeString(this.f6043e);
        parcel.writeInt(this.f6048j);
        if (this.f6051m == null) {
            this.f6051m = new Date(System.currentTimeMillis());
        }
        parcel.writeLong(this.f6051m.getTime());
    }

    public boolean containsCRC(long j) {
        return getTrack().contains(Long.valueOf(j));
    }

    public synchronized void addTrackingCRC(long j) {
        if (getTrack().size() < mo7603c()) {
            boolean z = true;
            Iterator it = getTrack().iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((Long) it.next()).longValue() == j) {
                        z = false;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (z || getTrack().isEmpty()) {
                getTrack().add(Long.valueOf(j));
            }
        } else if (!getTrack().contains(Long.valueOf(j))) {
            getTrack().remove(0);
            getTrack().add(Long.valueOf(j));
        }
    }

    public void removeTracking(long j) {
        getTrack().remove(Long.valueOf(j));
    }

    public String toString() {
        return new Gson().toJson((Object) this);
    }

    @JsonProperty("hops")
    public int getHops() {
        return this.f6047i;
    }

    public void setHops(int i) {
        this.f6047i = i;
    }

    @JsonProperty("creation")
    public long getCreation() {
        return this.f6044f;
    }

    public void setCreation(long j) {
        this.f6044f = j;
    }

    @JsonProperty("id")
    public String getId() {
        return this.f6039a;
    }

    public void setId(String str) {
        this.f6039a = str;
    }

    @JsonProperty("expiration")
    public long getExpiration() {
        return this.f6045g;
    }

    public void setExpiration(long j) {
        this.f6045g = j;
    }

    @JsonProperty("track")
    public ArrayList<Long> getTrack() {
        return this.f6049k;
    }

    public void setTrack(ArrayList<Long> arrayList) {
        this.f6049k = arrayList;
    }

    @JsonProperty("payload")
    public HashMap<String, Object> getPayload() {
        return this.f6040b;
    }

    public void setPayload(HashMap<String, Object> hashMap) {
        this.f6040b = hashMap;
    }

    @JsonProperty("enc_payload")
    public int getEnc_payload() {
        return this.f6041c;
    }

    public void setEnc_payload(int i) {
        this.f6041c = i;
    }

    @JsonProperty("sender")
    public String getSender() {
        return this.f6042d;
    }

    public void setSender(String str) {
        this.f6042d = str;
    }

    @JsonProperty("receiver_type")
    public int getReceiver_type() {
        return this.f6046h;
    }

    @JsonProperty("receiver")
    public String getReceiver() {
        return this.f6043e;
    }

    public void setReceiver(String str) {
        this.f6043e = str;
    }

    public int getPropagation() {
        return this.f6050l;
    }

    @JsonIgnore
    public void setPropagation(int i) {
        this.f6050l = i;
    }

    public int decreaseRemainingHops() {
        int i = this.f6047i - 1;
        this.f6047i = i;
        return i;
    }

    public void setForwardedPayload(byte[] bArr) {
        this.f6052r = bArr;
    }

    public byte[] getForwardedPayload() {
        return this.f6052r;
    }

    @JsonProperty("profile")
    public int getProfile() {
        return this.f6048j;
    }

    public void setProfile(int i) {
        this.f6048j = i;
    }

    public void setAdded(Date date) {
        this.f6051m = date;
    }

    public Date getAdded() {
        return this.f6051m;
    }

    public boolean expired() {
        if (getHops() <= 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("expired because: ");
            sb.append(getId());
            sb.append(" hops ");
            sb.append(getHops());
            Log.i("ForwardPacket", sb.toString());
            return true;
        }
        long creation = (getCreation() + (getExpiration() * 1000)) - System.currentTimeMillis();
        if (getHops() == 0 || creation <= 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("expired because: ");
            sb2.append(getId());
            sb2.append(" hops: ");
            sb2.append(getHops());
            sb2.append(" or expiration: ");
            sb2.append(creation);
            Log.i("ForwardPacket", sb2.toString());
            return true;
        }
        long time = new Date(System.currentTimeMillis()).getTime() - this.f6051m.getTime();
        if (time > ((long) mo7602b())) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("expired because: ");
            sb3.append(getId());
            sb3.append(" interval: ");
            sb3.append(time);
            sb3.append(" > ");
            sb3.append(mo7602b());
            sb3.append(" getMaxSharingTimeForEngineProfile | profile energy: ");
            sb3.append(getProfile());
            Log.i("ForwardPacket", sb3.toString());
            return true;
        } else if (getPropagation() <= mo7603c()) {
            return false;
        } else {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("expired because: ");
            sb4.append(getId());
            sb4.append(" propagation ");
            sb4.append(getPropagation());
            sb4.append(" > ");
            sb4.append(mo7603c());
            sb4.append(" getMaxPropagationForEngineProfile");
            Log.i("ForwardPacket", sb4.toString());
            return true;
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof ForwardPacket) {
            return ((ForwardPacket) obj).getId().trim().equalsIgnoreCase(getId().trim());
        }
        StringBuilder sb = new StringBuilder();
        sb.append(obj.getClass().getCanonicalName());
        sb.append(" is not instance of ForwardPacket.");
        throw new IllegalArgumentException(sb.toString());
    }

    @JsonIgnore
    public int getHopsLimitForEngineProfile() {
        return f6035n[this.f6048j];
    }

    /* access modifiers changed from: 0000 */
    @JsonIgnore
    /* renamed from: a */
    public int mo7600a() {
        return f6036o[this.f6048j];
    }

    /* access modifiers changed from: 0000 */
    @JsonIgnore
    /* renamed from: b */
    public int mo7602b() {
        return f6037p[this.f6048j] * 1000;
    }

    /* access modifiers changed from: 0000 */
    @JsonIgnore
    /* renamed from: c */
    public int mo7603c() {
        return f6038q[this.f6048j];
    }

    public int compareTo(Object obj) {
        ForwardPacket forwardPacket = (ForwardPacket) obj;
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(forwardPacket.getCreation());
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("");
        sb3.append(getCreation());
        return sb2.compareTo(sb3.toString());
    }
}
