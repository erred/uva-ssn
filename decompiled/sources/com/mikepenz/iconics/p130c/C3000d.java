package com.mikepenz.iconics.p130c;

import android.text.ParcelableSpan;
import android.text.style.CharacterStyle;
import com.mikepenz.iconics.p129b.C2996b;

/* renamed from: com.mikepenz.iconics.c.d */
/* compiled from: StyleContainer */
public class C3000d {

    /* renamed from: a */
    public int f7840a;

    /* renamed from: b */
    public int f7841b;

    /* renamed from: c */
    public String f7842c;

    /* renamed from: d */
    public C2996b f7843d;

    /* renamed from: e */
    public ParcelableSpan f7844e;

    /* renamed from: f */
    public CharacterStyle f7845f;

    /* renamed from: g */
    public int f7846g = 33;

    public C3000d(int i, int i2, String str, C2996b bVar) {
        this.f7840a = i;
        this.f7841b = i2;
        this.f7842c = str;
        this.f7843d = bVar;
    }

    public C3000d(int i, int i2, ParcelableSpan parcelableSpan, int i3) {
        this.f7840a = i;
        this.f7841b = i2;
        this.f7844e = parcelableSpan;
        this.f7846g = i3;
    }

    public C3000d(int i, int i2, CharacterStyle characterStyle, int i3) {
        this.f7840a = i;
        this.f7841b = i2;
        this.f7845f = characterStyle;
        this.f7846g = i3;
    }
}
