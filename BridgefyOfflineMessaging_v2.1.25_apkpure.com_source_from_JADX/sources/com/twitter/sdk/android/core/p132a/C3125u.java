package com.twitter.sdk.android.core.p132a;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* renamed from: com.twitter.sdk.android.core.a.u */
/* compiled from: VideoInfo */
public class C3125u implements Serializable {
    @SerializedName("duration_millis")

    /* renamed from: a */
    public final long f8257a;
    @SerializedName("variants")

    /* renamed from: b */
    public final List<C3126a> f8258b;

    /* renamed from: com.twitter.sdk.android.core.a.u$a */
    /* compiled from: VideoInfo */
    public static class C3126a implements Serializable {
        @SerializedName("content_type")

        /* renamed from: a */
        public final String f8259a;
        @SerializedName("url")

        /* renamed from: b */
        public final String f8260b;
    }
}
