package com.firebase.p119ui.auth.p124ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.firebase.p119ui.auth.C2001a.C2003a;
import com.firebase.p119ui.auth.p121b.C2033e;
import java.util.Collections;
import java.util.List;

/* renamed from: com.firebase.ui.auth.ui.b */
/* compiled from: FlowParameters */
public class C2048b implements Parcelable {
    public static final Creator<C2048b> CREATOR = new Creator<C2048b>() {
        /* renamed from: a */
        public C2048b createFromParcel(Parcel parcel) {
            C2048b bVar = new C2048b(parcel.readString(), parcel.createTypedArrayList(C2003a.CREATOR), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0);
            return bVar;
        }

        /* renamed from: a */
        public C2048b[] newArray(int i) {
            return new C2048b[i];
        }
    };

    /* renamed from: a */
    public final String f6316a;

    /* renamed from: b */
    public final List<C2003a> f6317b;

    /* renamed from: c */
    public final int f6318c;

    /* renamed from: d */
    public final int f6319d;

    /* renamed from: e */
    public final String f6320e;

    /* renamed from: f */
    public final String f6321f;

    /* renamed from: g */
    public final boolean f6322g;

    /* renamed from: h */
    public final boolean f6323h;

    /* renamed from: i */
    public final boolean f6324i;

    public int describeContents() {
        return 0;
    }

    public C2048b(String str, List<C2003a> list, int i, int i2, String str2, String str3, boolean z, boolean z2, boolean z3) {
        this.f6316a = (String) C2033e.m8233a(str, "appName cannot be null", new Object[0]);
        this.f6317b = Collections.unmodifiableList((List) C2033e.m8233a(list, "providerInfo cannot be null", new Object[0]));
        this.f6318c = i;
        this.f6319d = i2;
        this.f6320e = str2;
        this.f6321f = str3;
        this.f6323h = z;
        this.f6324i = z2;
        this.f6322g = z3;
    }

    /* renamed from: a */
    public static C2048b m8277a(Intent intent) {
        return (C2048b) intent.getParcelableExtra("extra_flow_params");
    }

    /* renamed from: a */
    public static C2048b m8278a(Bundle bundle) {
        return (C2048b) bundle.getParcelable("extra_flow_params");
    }

    /* renamed from: a */
    public Bundle mo11872a() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("extra_flow_params", this);
        return bundle;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6316a);
        parcel.writeTypedList(this.f6317b);
        parcel.writeInt(this.f6318c);
        parcel.writeInt(this.f6319d);
        parcel.writeString(this.f6320e);
        parcel.writeString(this.f6321f);
        parcel.writeInt(this.f6323h ? 1 : 0);
        parcel.writeInt(this.f6324i ? 1 : 0);
        parcel.writeInt(this.f6322g ? 1 : 0);
    }
}
