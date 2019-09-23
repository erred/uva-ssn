package com.twitter.sdk.android.tweetui.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.twitter.sdk.android.tweetui.R;

public class VideoControlView extends FrameLayout {

    /* renamed from: a */
    C3334a f8697a;

    /* renamed from: b */
    ImageButton f8698b;

    /* renamed from: c */
    TextView f8699c;

    /* renamed from: d */
    TextView f8700d;

    /* renamed from: e */
    SeekBar f8701e;
    /* access modifiers changed from: private */
    @SuppressLint({"HandlerLeak"})

    /* renamed from: f */
    public final Handler f8702f = new Handler() {
        public void handleMessage(Message message) {
            if (message.what == 1001 && VideoControlView.this.f8697a != null) {
                VideoControlView.this.mo28063d();
                VideoControlView.this.mo28064e();
                if (VideoControlView.this.mo28070k() && VideoControlView.this.f8697a.mo28084c()) {
                    sendMessageDelayed(obtainMessage(1001), 500);
                }
            }
        }
    };

    /* renamed from: com.twitter.sdk.android.tweetui.internal.VideoControlView$a */
    public interface C3334a {
        /* renamed from: a */
        void mo28081a();

        /* renamed from: a */
        void mo28082a(int i);

        /* renamed from: b */
        void mo28083b();

        /* renamed from: c */
        boolean mo28084c();

        int getBufferPercentage();

        int getCurrentPosition();

        int getDuration();
    }

    public VideoControlView(Context context) {
        super(context);
    }

    public VideoControlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VideoControlView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setMediaPlayer(C3334a aVar) {
        this.f8697a = aVar;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        mo28059a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo28059a() {
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.tw__video_control, this);
        this.f8698b = (ImageButton) findViewById(R.id.tw__state_control);
        this.f8699c = (TextView) findViewById(R.id.tw__current_time);
        this.f8700d = (TextView) findViewById(R.id.tw__duration);
        this.f8701e = (SeekBar) findViewById(R.id.tw__progress);
        this.f8701e.setMax(1000);
        this.f8701e.setOnSeekBarChangeListener(mo28062c());
        this.f8698b.setOnClickListener(mo28061b());
        setDuration(0);
        setCurrentTime(0);
        mo28060a(0, 0, 0);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public OnClickListener mo28061b() {
        return new OnClickListener() {
            public void onClick(View view) {
                if (VideoControlView.this.f8697a.mo28084c()) {
                    VideoControlView.this.f8697a.mo28083b();
                } else {
                    VideoControlView.this.f8697a.mo28081a();
                }
                VideoControlView.this.mo28069j();
            }
        };
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public OnSeekBarChangeListener mo28062c() {
        return new OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    int duration = (int) (((long) (VideoControlView.this.f8697a.getDuration() * i)) / 1000);
                    VideoControlView.this.f8697a.mo28082a(duration);
                    VideoControlView.this.setCurrentTime(duration);
                }
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                VideoControlView.this.f8702f.removeMessages(1001);
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                VideoControlView.this.f8702f.sendEmptyMessage(1001);
            }
        };
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo28063d() {
        int duration = this.f8697a.getDuration();
        int currentPosition = this.f8697a.getCurrentPosition();
        int bufferPercentage = this.f8697a.getBufferPercentage();
        setDuration(duration);
        setCurrentTime(currentPosition);
        mo28060a(currentPosition, duration, bufferPercentage);
    }

    /* access modifiers changed from: 0000 */
    public void setDuration(int i) {
        this.f8700d.setText(C3346c.m9770a((long) i));
    }

    /* access modifiers changed from: 0000 */
    public void setCurrentTime(int i) {
        this.f8699c.setText(C3346c.m9770a((long) i));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo28060a(int i, int i2, int i3) {
        this.f8701e.setProgress((int) (i2 > 0 ? (((long) i) * 1000) / ((long) i2) : 0));
        this.f8701e.setSecondaryProgress(i3 * 10);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo28064e() {
        if (this.f8697a.mo28084c()) {
            mo28066g();
        } else if (this.f8697a.getCurrentPosition() > Math.max(this.f8697a.getDuration() - 500, 0)) {
            mo28067h();
        } else {
            mo28065f();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public void mo28065f() {
        this.f8698b.setImageResource(R.drawable.tw__video_play_btn);
        this.f8698b.setContentDescription(getContext().getString(R.string.tw__play));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public void mo28066g() {
        this.f8698b.setImageResource(R.drawable.tw__video_pause_btn);
        this.f8698b.setContentDescription(getContext().getString(R.string.tw__pause));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public void mo28067h() {
        this.f8698b.setImageResource(R.drawable.tw__video_replay_btn);
        this.f8698b.setContentDescription(getContext().getString(R.string.tw__replay));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public void mo28068i() {
        this.f8702f.removeMessages(1001);
        C3343a.m9766a(this, 150);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public void mo28069j() {
        this.f8702f.sendEmptyMessage(1001);
        C3343a.m9767b(this, 150);
    }

    /* renamed from: k */
    public boolean mo28070k() {
        return getVisibility() == 0;
    }

    /* renamed from: l */
    public void mo28071l() {
        this.f8702f.sendEmptyMessage(1001);
    }
}
