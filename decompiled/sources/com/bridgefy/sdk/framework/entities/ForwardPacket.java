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
    String id;
    @JsonProperty("payload")

    /* renamed from: b */
    HashMap<String, Object> payload;
    @JsonProperty("enc_payload")

    /* renamed from: c */
    int enc_payload;
    @JsonProperty("sender")

    /* renamed from: d */
    String sender;
    @JsonProperty("receiver")

    /* renamed from: e */
    String receiver;
    @JsonProperty("creation")

    /* renamed from: f */
    long creation;
    @JsonProperty("expiration")

    /* renamed from: g */
    long expiration;
    @JsonProperty("receiver_type")

    /* renamed from: h */
    int receiver_type;
    @JsonProperty("hops")

    /* renamed from: i */
    int remaining_hops;
    @JsonProperty("profile")

    /* renamed from: j */
    int profile;
    @JsonProperty("track")

    /* renamed from: k */
    ArrayList<Long> track;
    @JsonIgnore

    /* renamed from: l */
    int propagation;
    @JsonIgnore

    /* renamed from: m */
    Date added;
    @JsonIgnore

    /* renamed from: r */
    private byte[] forwarded_payload;

    public int describeContents() {
        return 0;
    }

    public ForwardPacket() {
        this.enc_payload = -1;
        this.track = new ArrayList<>();
    }

    public ForwardPacket(Message message, int i) {
        this.enc_payload = -1;
        this.track = new ArrayList<>();
        this.profile = BFEngineProfile.BFConfigProfileDefault.ordinal();
        this.creation = message.getDateSent();
        this.id = message.getUuid() == null ? UUID.randomUUID().toString() : message.getUuid();
        this.sender = message.getSenderId();
        this.receiver = message.getReceiverId();
        this.receiver_type = i;
        this.added = new Date(System.currentTimeMillis());
        this.expiration = (long) mo7600a();
        this.propagation = mo7603c();
        this.remaining_hops = getHopsLimitForEngineProfile();
        this.payload = message.getContent();
        addTrackingCRC(Utils.getCrcFromKey(Bridgefy.getInstance().getBridgefyClient().getUserUuid()));
    }

    public ForwardPacket(Message message, int i, BFEngineProfile bFEngineProfile) {
        this.enc_payload = -1;
        this.track = new ArrayList<>();
        this.profile = bFEngineProfile.ordinal();
        this.creation = message.getDateSent();
        this.id = message.getUuid() == null ? UUID.randomUUID().toString() : message.getUuid();
        this.sender = message.getSenderId();
        this.receiver = message.getReceiverId();
        this.receiver_type = i;
        this.added = new Date(System.currentTimeMillis());
        this.expiration = (long) mo7600a();
        this.propagation = mo7603c();
        this.remaining_hops = getHopsLimitForEngineProfile();
        this.payload = message.getContent();
        addTrackingCRC(Utils.getCrcFromKey(Bridgefy.getInstance().getBridgefyClient().getUserUuid()));
    }

    protected ForwardPacket(Parcel parcel) {
        this.enc_payload = -1;
        this.track = new ArrayList<>();
        this.remaining_hops = parcel.readInt();
        this.creation = parcel.readLong();
        this.id = parcel.readString();
        this.expiration = parcel.readLong();
        this.payload = (HashMap) new Gson().fromJson(parcel.readString(), Constants.TYPE);
        this.enc_payload = parcel.readInt();
        this.track = (ArrayList) parcel.readSerializable();
        this.sender = parcel.readString();
        this.receiver_type = parcel.readInt();
        this.receiver = parcel.readString();
        this.profile = parcel.readInt();
        this.added = new Date(parcel.readLong());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.remaining_hops);
        parcel.writeLong(this.creation);
        parcel.writeString(this.id);
        parcel.writeLong(this.expiration);
        parcel.writeString(new Gson().toJson((Object) this.payload));
        parcel.writeInt(this.enc_payload);
        parcel.writeSerializable(this.track);
        parcel.writeString(this.sender);
        parcel.writeInt(this.receiver_type);
        parcel.writeString(this.receiver);
        parcel.writeInt(this.profile);
        if (this.added == null) {
            this.added = new Date(System.currentTimeMillis());
        }
        parcel.writeLong(this.added.getTime());
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
        return this.remaining_hops;
    }

    public void setHops(int i) {
        this.remaining_hops = i;
    }

    @JsonProperty("creation")
    public long getCreation() {
        return this.creation;
    }

    public void setCreation(long j) {
        this.creation = j;
    }

    @JsonProperty("id")
    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    @JsonProperty("expiration")
    public long getExpiration() {
        return this.expiration;
    }

    public void setExpiration(long j) {
        this.expiration = j;
    }

    @JsonProperty("track")
    public ArrayList<Long> getTrack() {
        return this.track;
    }

    public void setTrack(ArrayList<Long> arrayList) {
        this.track = arrayList;
    }

    @JsonProperty("payload")
    public HashMap<String, Object> getPayload() {
        return this.payload;
    }

    public void setPayload(HashMap<String, Object> hashMap) {
        this.payload = hashMap;
    }

    @JsonProperty("enc_payload")
    public int getEnc_payload() {
        return this.enc_payload;
    }

    public void setEnc_payload(int i) {
        this.enc_payload = i;
    }

    @JsonProperty("sender")
    public String getSender() {
        return this.sender;
    }

    public void setSender(String str) {
        this.sender = str;
    }

    @JsonProperty("receiver_type")
    public int getReceiver_type() {
        return this.receiver_type;
    }

    @JsonProperty("receiver")
    public String getReceiver() {
        return this.receiver;
    }

    public void setReceiver(String str) {
        this.receiver = str;
    }

    public int getPropagation() {
        return this.propagation;
    }

    @JsonIgnore
    public void setPropagation(int i) {
        this.propagation = i;
    }

    public int decreaseRemainingHops() {
        int i = this.remaining_hops - 1;
        this.remaining_hops = i;
        return i;
    }

    public void setForwardedPayload(byte[] bArr) {
        this.forwarded_payload = bArr;
    }

    public byte[] getForwardedPayload() {
        return this.forwarded_payload;
    }

    @JsonProperty("profile")
    public int getProfile() {
        return this.profile;
    }

    public void setProfile(int i) {
        this.profile = i;
    }

    public void setAdded(Date date) {
        this.added = date;
    }

    public Date getAdded() {
        return this.added;
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
        long time = new Date(System.currentTimeMillis()).getTime() - this.added.getTime();
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
        return f6035n[this.profile];
    }

    /* access modifiers changed from: 0000 */
    @JsonIgnore
    /* renamed from: a */
    public int mo7600a() {
        return f6036o[this.profile];
    }

    /* access modifiers changed from: 0000 */
    @JsonIgnore
    /* renamed from: b */
    public int mo7602b() {
        return f6037p[this.profile] * 1000;
    }

    /* access modifiers changed from: 0000 */
    @JsonIgnore
    /* renamed from: c */
    public int mo7603c() {
        return f6038q[this.profile];
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
