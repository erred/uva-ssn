package com.twitter.sdk.android.tweetui;

import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.twitter.sdk.android.core.C3134g;
import com.twitter.sdk.android.core.C3256m;
import com.twitter.sdk.android.tweetui.PlayerActivity.C3307a;
import com.twitter.sdk.android.tweetui.internal.C3353f;
import com.twitter.sdk.android.tweetui.internal.C3353f.C3355a;
import com.twitter.sdk.android.tweetui.internal.VideoControlView;
import com.twitter.sdk.android.tweetui.internal.VideoView;

/* renamed from: com.twitter.sdk.android.tweetui.g */
/* compiled from: PlayerController */
class C3320g {

    /* renamed from: a */
    final VideoView f8659a;

    /* renamed from: b */
    final VideoControlView f8660b;

    /* renamed from: c */
    final ProgressBar f8661c;

    /* renamed from: d */
    final TextView f8662d;

    /* renamed from: e */
    final View f8663e;

    /* renamed from: f */
    int f8664f;

    /* renamed from: g */
    boolean f8665g = true;

    /* renamed from: h */
    final C3355a f8666h;

    C3320g(View view, C3355a aVar) {
        this.f8663e = view;
        this.f8659a = (VideoView) view.findViewById(R.id.video_view);
        this.f8660b = (VideoControlView) view.findViewById(R.id.video_control_view);
        this.f8661c = (ProgressBar) view.findViewById(R.id.video_progress_view);
        this.f8662d = (TextView) view.findViewById(R.id.call_to_action_view);
        this.f8666h = aVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo28006a(C3307a aVar) {
        try {
            mo28010b(aVar);
            mo28008a(aVar.f8632b, aVar.f8633c);
            this.f8659a.setOnTouchListener(C3353f.m9788a((View) this.f8659a, this.f8666h));
            this.f8659a.setOnPreparedListener(new OnPreparedListener() {
                public void onPrepared(MediaPlayer mediaPlayer) {
                    C3320g.this.f8661c.setVisibility(8);
                }
            });
            this.f8659a.setOnInfoListener(new OnInfoListener() {
                public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                    if (i == 702) {
                        C3320g.this.f8661c.setVisibility(8);
                        return true;
                    } else if (i != 701) {
                        return false;
                    } else {
                        C3320g.this.f8661c.setVisibility(0);
                        return true;
                    }
                }
            });
            this.f8659a.mo28088a(Uri.parse(aVar.f8631a), aVar.f8632b);
            this.f8659a.requestFocus();
        } catch (Exception e) {
            C3256m.m9537g().mo27613c("PlayerController", "Error occurred during video playback", e);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo28005a() {
        if (this.f8664f != 0) {
            this.f8659a.mo28082a(this.f8664f);
        }
        if (this.f8665g) {
            this.f8659a.mo28081a();
            this.f8660b.mo28071l();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo28009b() {
        this.f8665g = this.f8659a.mo28084c();
        this.f8664f = this.f8659a.getCurrentPosition();
        this.f8659a.mo28083b();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo28011c() {
        this.f8659a.mo28089d();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo28008a(boolean z, boolean z2) {
        if (!z || z2) {
            mo28013e();
        } else {
            mo28012d();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo28012d() {
        this.f8660b.setVisibility(4);
        this.f8659a.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (C3320g.this.f8659a.mo28084c()) {
                    C3320g.this.f8659a.mo28083b();
                } else {
                    C3320g.this.f8659a.mo28081a();
                }
            }
        });
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo28013e() {
        this.f8659a.setMediaController(this.f8660b);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo28010b(C3307a aVar) {
        if (aVar.f8635e != null && aVar.f8634d != null) {
            this.f8662d.setVisibility(0);
            this.f8662d.setText(aVar.f8635e);
            mo28007a(aVar.f8634d);
            mo28014f();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo28007a(final String str) {
        this.f8662d.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C3134g.m9164b(C3320g.this.f8662d.getContext(), new Intent("android.intent.action.VIEW", Uri.parse(str)));
            }
        });
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public void mo28014f() {
        this.f8663e.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (C3320g.this.f8662d.getVisibility() == 0) {
                    C3320g.this.f8662d.setVisibility(8);
                } else {
                    C3320g.this.f8662d.setVisibility(0);
                }
            }
        });
    }
}
