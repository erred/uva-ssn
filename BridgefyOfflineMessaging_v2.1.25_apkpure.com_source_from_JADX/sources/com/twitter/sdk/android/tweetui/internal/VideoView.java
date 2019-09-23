package com.twitter.sdk.android.tweetui.internal;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.twitter.sdk.android.tweetui.internal.VideoControlView.C3334a;

public class VideoView extends SurfaceView implements C3334a {

    /* renamed from: A */
    private GestureDetector f8706A;

    /* renamed from: a */
    OnVideoSizeChangedListener f8707a;

    /* renamed from: b */
    OnPreparedListener f8708b;

    /* renamed from: c */
    Callback f8709c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f8710d;

    /* renamed from: e */
    private Uri f8711e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f8712f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f8713g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public SurfaceHolder f8714h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public MediaPlayer f8715i;

    /* renamed from: j */
    private int f8716j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f8717k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int f8718l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int f8719m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f8720n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public VideoControlView f8721o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public OnCompletionListener f8722p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public OnPreparedListener f8723q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public int f8724r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public OnErrorListener f8725s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public OnInfoListener f8726t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public int f8727u;

    /* renamed from: v */
    private boolean f8728v;

    /* renamed from: w */
    private OnCompletionListener f8729w;

    /* renamed from: x */
    private OnInfoListener f8730x;

    /* renamed from: y */
    private OnErrorListener f8731y;

    /* renamed from: z */
    private OnBufferingUpdateListener f8732z;

    public VideoView(Context context) {
        super(context);
        this.f8710d = "VideoView";
        this.f8712f = 0;
        this.f8713g = 0;
        this.f8714h = null;
        this.f8715i = null;
        this.f8707a = new OnVideoSizeChangedListener() {
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                VideoView.this.f8717k = mediaPlayer.getVideoWidth();
                VideoView.this.f8718l = mediaPlayer.getVideoHeight();
                if (VideoView.this.f8717k != 0 && VideoView.this.f8718l != 0) {
                    VideoView.this.getHolder().setFixedSize(VideoView.this.f8717k, VideoView.this.f8718l);
                    VideoView.this.requestLayout();
                }
            }
        };
        this.f8708b = new OnPreparedListener() {
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoView.this.f8712f = 2;
                if (VideoView.this.f8723q != null) {
                    VideoView.this.f8723q.onPrepared(VideoView.this.f8715i);
                }
                if (VideoView.this.f8721o != null) {
                    VideoView.this.f8721o.setEnabled(true);
                }
                VideoView.this.f8717k = mediaPlayer.getVideoWidth();
                VideoView.this.f8718l = mediaPlayer.getVideoHeight();
                int f = VideoView.this.f8727u;
                if (f != 0) {
                    VideoView.this.mo28082a(f);
                }
                if (VideoView.this.f8717k != 0 && VideoView.this.f8718l != 0) {
                    VideoView.this.getHolder().setFixedSize(VideoView.this.f8717k, VideoView.this.f8718l);
                    if (VideoView.this.f8719m != VideoView.this.f8717k || VideoView.this.f8720n != VideoView.this.f8718l) {
                        return;
                    }
                    if (VideoView.this.f8713g == 3) {
                        VideoView.this.mo28081a();
                        if (VideoView.this.f8721o != null) {
                            VideoView.this.f8721o.mo28069j();
                        }
                    } else if (VideoView.this.mo28084c()) {
                    } else {
                        if ((f != 0 || VideoView.this.getCurrentPosition() > 0) && VideoView.this.f8721o != null) {
                            VideoView.this.f8721o.mo28069j();
                        }
                    }
                } else if (VideoView.this.f8713g == 3) {
                    VideoView.this.mo28081a();
                }
            }
        };
        this.f8729w = new OnCompletionListener() {
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoView.this.f8712f = 5;
                VideoView.this.f8713g = 5;
                if (VideoView.this.f8722p != null) {
                    VideoView.this.f8722p.onCompletion(VideoView.this.f8715i);
                }
            }
        };
        this.f8730x = new OnInfoListener() {
            public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoView.this.f8726t != null) {
                    VideoView.this.f8726t.onInfo(mediaPlayer, i, i2);
                }
                return true;
            }
        };
        this.f8731y = new OnErrorListener() {
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                String l = VideoView.this.f8710d;
                StringBuilder sb = new StringBuilder();
                sb.append("Error: ");
                sb.append(i);
                sb.append(",");
                sb.append(i2);
                Log.d(l, sb.toString());
                VideoView.this.f8712f = -1;
                VideoView.this.f8713g = -1;
                if (VideoView.this.f8721o != null) {
                    VideoView.this.f8721o.mo28068i();
                }
                return (VideoView.this.f8725s == null || VideoView.this.f8725s.onError(VideoView.this.f8715i, i, i2)) ? true : true;
            }
        };
        this.f8732z = new OnBufferingUpdateListener() {
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                VideoView.this.f8724r = i;
            }
        };
        this.f8706A = new GestureDetector(getContext(), new SimpleOnGestureListener() {
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                if (VideoView.this.m9752i() && VideoView.this.f8721o != null) {
                    VideoView.this.m9750h();
                }
                return false;
            }
        });
        this.f8709c = new Callback() {
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                VideoView.this.f8719m = i2;
                VideoView.this.f8720n = i3;
                boolean z = false;
                boolean z2 = VideoView.this.f8713g == 3;
                if (VideoView.this.f8717k == i2 && VideoView.this.f8718l == i3) {
                    z = true;
                }
                if (VideoView.this.f8715i != null && z2 && z) {
                    if (VideoView.this.f8727u != 0) {
                        VideoView.this.mo28082a(VideoView.this.f8727u);
                    }
                    VideoView.this.mo28081a();
                    if (VideoView.this.f8721o != null) {
                        VideoView.this.f8721o.mo28069j();
                    }
                }
            }

            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoView.this.f8714h = surfaceHolder;
                VideoView.this.m9745f();
            }

            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoView.this.f8714h = null;
                if (VideoView.this.f8721o != null) {
                    VideoView.this.f8721o.mo28068i();
                }
                VideoView.this.m9733a(true);
            }
        };
        m9742e();
    }

    public VideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8710d = "VideoView";
        this.f8712f = 0;
        this.f8713g = 0;
        this.f8714h = null;
        this.f8715i = null;
        this.f8707a = new OnVideoSizeChangedListener() {
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                VideoView.this.f8717k = mediaPlayer.getVideoWidth();
                VideoView.this.f8718l = mediaPlayer.getVideoHeight();
                if (VideoView.this.f8717k != 0 && VideoView.this.f8718l != 0) {
                    VideoView.this.getHolder().setFixedSize(VideoView.this.f8717k, VideoView.this.f8718l);
                    VideoView.this.requestLayout();
                }
            }
        };
        this.f8708b = new OnPreparedListener() {
            public void onPrepared(MediaPlayer mediaPlayer) {
                VideoView.this.f8712f = 2;
                if (VideoView.this.f8723q != null) {
                    VideoView.this.f8723q.onPrepared(VideoView.this.f8715i);
                }
                if (VideoView.this.f8721o != null) {
                    VideoView.this.f8721o.setEnabled(true);
                }
                VideoView.this.f8717k = mediaPlayer.getVideoWidth();
                VideoView.this.f8718l = mediaPlayer.getVideoHeight();
                int f = VideoView.this.f8727u;
                if (f != 0) {
                    VideoView.this.mo28082a(f);
                }
                if (VideoView.this.f8717k != 0 && VideoView.this.f8718l != 0) {
                    VideoView.this.getHolder().setFixedSize(VideoView.this.f8717k, VideoView.this.f8718l);
                    if (VideoView.this.f8719m != VideoView.this.f8717k || VideoView.this.f8720n != VideoView.this.f8718l) {
                        return;
                    }
                    if (VideoView.this.f8713g == 3) {
                        VideoView.this.mo28081a();
                        if (VideoView.this.f8721o != null) {
                            VideoView.this.f8721o.mo28069j();
                        }
                    } else if (VideoView.this.mo28084c()) {
                    } else {
                        if ((f != 0 || VideoView.this.getCurrentPosition() > 0) && VideoView.this.f8721o != null) {
                            VideoView.this.f8721o.mo28069j();
                        }
                    }
                } else if (VideoView.this.f8713g == 3) {
                    VideoView.this.mo28081a();
                }
            }
        };
        this.f8729w = new OnCompletionListener() {
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoView.this.f8712f = 5;
                VideoView.this.f8713g = 5;
                if (VideoView.this.f8722p != null) {
                    VideoView.this.f8722p.onCompletion(VideoView.this.f8715i);
                }
            }
        };
        this.f8730x = new OnInfoListener() {
            public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                if (VideoView.this.f8726t != null) {
                    VideoView.this.f8726t.onInfo(mediaPlayer, i, i2);
                }
                return true;
            }
        };
        this.f8731y = new OnErrorListener() {
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                String l = VideoView.this.f8710d;
                StringBuilder sb = new StringBuilder();
                sb.append("Error: ");
                sb.append(i);
                sb.append(",");
                sb.append(i2);
                Log.d(l, sb.toString());
                VideoView.this.f8712f = -1;
                VideoView.this.f8713g = -1;
                if (VideoView.this.f8721o != null) {
                    VideoView.this.f8721o.mo28068i();
                }
                return (VideoView.this.f8725s == null || VideoView.this.f8725s.onError(VideoView.this.f8715i, i, i2)) ? true : true;
            }
        };
        this.f8732z = new OnBufferingUpdateListener() {
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                VideoView.this.f8724r = i;
            }
        };
        this.f8706A = new GestureDetector(getContext(), new SimpleOnGestureListener() {
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                if (VideoView.this.m9752i() && VideoView.this.f8721o != null) {
                    VideoView.this.m9750h();
                }
                return false;
            }
        });
        this.f8709c = new Callback() {
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                VideoView.this.f8719m = i2;
                VideoView.this.f8720n = i3;
                boolean z = false;
                boolean z2 = VideoView.this.f8713g == 3;
                if (VideoView.this.f8717k == i2 && VideoView.this.f8718l == i3) {
                    z = true;
                }
                if (VideoView.this.f8715i != null && z2 && z) {
                    if (VideoView.this.f8727u != 0) {
                        VideoView.this.mo28082a(VideoView.this.f8727u);
                    }
                    VideoView.this.mo28081a();
                    if (VideoView.this.f8721o != null) {
                        VideoView.this.f8721o.mo28069j();
                    }
                }
            }

            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoView.this.f8714h = surfaceHolder;
                VideoView.this.m9745f();
            }

            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoView.this.f8714h = null;
                if (VideoView.this.f8721o != null) {
                    VideoView.this.f8721o.mo28068i();
                }
                VideoView.this.m9733a(true);
            }
        };
        m9742e();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006e, code lost:
        if (r1 > r6) goto L_0x0094;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r6, int r7) {
        /*
            r5 = this;
            int r0 = r5.f8717k
            int r0 = getDefaultSize(r0, r6)
            int r1 = r5.f8718l
            int r1 = getDefaultSize(r1, r7)
            int r2 = r5.f8717k
            if (r2 <= 0) goto L_0x0092
            int r2 = r5.f8718l
            if (r2 <= 0) goto L_0x0092
            int r0 = android.view.View.MeasureSpec.getMode(r6)
            int r6 = android.view.View.MeasureSpec.getSize(r6)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            int r7 = android.view.View.MeasureSpec.getSize(r7)
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 != r2) goto L_0x0051
            if (r1 != r2) goto L_0x0051
            int r0 = r5.f8717k
            int r0 = r0 * r7
            int r1 = r5.f8718l
            int r1 = r1 * r6
            if (r0 >= r1) goto L_0x003e
            int r6 = r5.f8717k
            int r6 = r6 * r7
            int r0 = r5.f8718l
            int r0 = r6 / r0
            r6 = r0
            goto L_0x0094
        L_0x003e:
            int r0 = r5.f8717k
            int r0 = r0 * r7
            int r1 = r5.f8718l
            int r1 = r1 * r6
            if (r0 <= r1) goto L_0x0094
            int r7 = r5.f8718l
            int r7 = r7 * r6
            int r0 = r5.f8717k
            int r1 = r7 / r0
            goto L_0x0093
        L_0x0051:
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != r2) goto L_0x0063
            int r0 = r5.f8718l
            int r0 = r0 * r6
            int r2 = r5.f8717k
            int r0 = r0 / r2
            if (r1 != r3) goto L_0x0061
            if (r0 <= r7) goto L_0x0061
            goto L_0x0094
        L_0x0061:
            r7 = r0
            goto L_0x0094
        L_0x0063:
            if (r1 != r2) goto L_0x0073
            int r1 = r5.f8717k
            int r1 = r1 * r7
            int r2 = r5.f8718l
            int r1 = r1 / r2
            if (r0 != r3) goto L_0x0071
            if (r1 <= r6) goto L_0x0071
            goto L_0x0094
        L_0x0071:
            r6 = r1
            goto L_0x0094
        L_0x0073:
            int r2 = r5.f8717k
            int r4 = r5.f8718l
            if (r1 != r3) goto L_0x0083
            if (r4 <= r7) goto L_0x0083
            int r1 = r5.f8717k
            int r1 = r1 * r7
            int r2 = r5.f8718l
            int r1 = r1 / r2
            goto L_0x0085
        L_0x0083:
            r1 = r2
            r7 = r4
        L_0x0085:
            if (r0 != r3) goto L_0x0071
            if (r1 <= r6) goto L_0x0071
            int r7 = r5.f8718l
            int r7 = r7 * r6
            int r0 = r5.f8717k
            int r1 = r7 / r0
            goto L_0x0093
        L_0x0092:
            r6 = r0
        L_0x0093:
            r7 = r1
        L_0x0094:
            r5.setMeasuredDimension(r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.tweetui.internal.VideoView.onMeasure(int, int):void");
    }

    /* renamed from: e */
    private void m9742e() {
        this.f8717k = 0;
        this.f8718l = 0;
        getHolder().addCallback(this.f8709c);
        getHolder().setType(3);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setClickable(true);
        requestFocus();
        this.f8712f = 0;
        this.f8713g = 0;
    }

    /* renamed from: a */
    public void mo28088a(Uri uri, boolean z) {
        this.f8711e = uri;
        this.f8728v = z;
        this.f8727u = 0;
        m9745f();
        requestLayout();
        invalidate();
    }

    /* renamed from: d */
    public void mo28089d() {
        if (this.f8715i != null) {
            this.f8715i.stop();
            this.f8715i.release();
            this.f8715i = null;
            this.f8712f = 0;
            this.f8713g = 0;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m9745f() {
        if (this.f8711e != null && this.f8714h != null) {
            m9733a(false);
            try {
                this.f8715i = new MediaPlayer();
                if (this.f8716j != 0) {
                    this.f8715i.setAudioSessionId(this.f8716j);
                } else {
                    this.f8716j = this.f8715i.getAudioSessionId();
                }
                this.f8715i.setOnPreparedListener(this.f8708b);
                this.f8715i.setOnVideoSizeChangedListener(this.f8707a);
                this.f8715i.setOnCompletionListener(this.f8729w);
                this.f8715i.setOnErrorListener(this.f8731y);
                this.f8715i.setOnInfoListener(this.f8730x);
                this.f8715i.setOnBufferingUpdateListener(this.f8732z);
                this.f8724r = 0;
                this.f8715i.setLooping(this.f8728v);
                this.f8715i.setDataSource(getContext(), this.f8711e);
                this.f8715i.setDisplay(this.f8714h);
                this.f8715i.setAudioStreamType(3);
                this.f8715i.setScreenOnWhilePlaying(true);
                this.f8715i.prepareAsync();
                this.f8712f = 1;
                m9748g();
            } catch (Exception e) {
                String str = this.f8710d;
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to open content: ");
                sb.append(this.f8711e);
                Log.w(str, sb.toString(), e);
                this.f8712f = -1;
                this.f8713g = -1;
                this.f8731y.onError(this.f8715i, 1, 0);
            }
        }
    }

    public void setMediaController(VideoControlView videoControlView) {
        if (this.f8721o != null) {
            this.f8721o.mo28068i();
        }
        this.f8721o = videoControlView;
        m9748g();
    }

    /* renamed from: g */
    private void m9748g() {
        if (this.f8715i != null && this.f8721o != null) {
            this.f8721o.setMediaPlayer(this);
            this.f8721o.setEnabled(m9752i());
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f8706A.onTouchEvent(motionEvent) || super.onTouchEvent(motionEvent);
    }

    public void setOnPreparedListener(OnPreparedListener onPreparedListener) {
        this.f8723q = onPreparedListener;
    }

    public void setOnCompletionListener(OnCompletionListener onCompletionListener) {
        this.f8722p = onCompletionListener;
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.f8725s = onErrorListener;
    }

    public void setOnInfoListener(OnInfoListener onInfoListener) {
        this.f8726t = onInfoListener;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9733a(boolean z) {
        if (this.f8715i != null) {
            this.f8715i.reset();
            this.f8715i.release();
            this.f8715i = null;
            this.f8712f = 0;
            if (z) {
                this.f8713g = 0;
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z = (i == 4 || i == 24 || i == 25 || i == 82 || i == 5 || i == 6) ? false : true;
        if (m9752i() && z && this.f8721o != null) {
            if (i == 79 || i == 85) {
                if (this.f8715i.isPlaying()) {
                    mo28083b();
                    this.f8721o.mo28069j();
                } else {
                    mo28081a();
                    this.f8721o.mo28068i();
                }
                return true;
            } else if (i == 126) {
                if (!this.f8715i.isPlaying()) {
                    mo28081a();
                    this.f8721o.mo28068i();
                }
                return true;
            } else if (i == 86 || i == 127) {
                if (this.f8715i.isPlaying()) {
                    mo28083b();
                    this.f8721o.mo28069j();
                }
                return true;
            } else {
                m9750h();
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m9750h() {
        if (this.f8721o.mo28070k()) {
            this.f8721o.mo28068i();
        } else {
            this.f8721o.mo28069j();
        }
    }

    /* renamed from: a */
    public void mo28081a() {
        if (m9752i()) {
            this.f8715i.start();
            this.f8712f = 3;
        }
        this.f8713g = 3;
    }

    /* renamed from: b */
    public void mo28083b() {
        if (m9752i() && this.f8715i.isPlaying()) {
            this.f8715i.pause();
            this.f8712f = 4;
        }
        this.f8713g = 4;
    }

    public int getDuration() {
        if (m9752i()) {
            return this.f8715i.getDuration();
        }
        return -1;
    }

    public int getCurrentPosition() {
        if (m9752i()) {
            return this.f8715i.getCurrentPosition();
        }
        return 0;
    }

    /* renamed from: a */
    public void mo28082a(int i) {
        if (m9752i()) {
            this.f8715i.seekTo(i);
            this.f8727u = 0;
            return;
        }
        this.f8727u = i;
    }

    /* renamed from: c */
    public boolean mo28084c() {
        return m9752i() && this.f8715i.isPlaying();
    }

    public int getBufferPercentage() {
        if (this.f8715i != null) {
            return this.f8724r;
        }
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public boolean m9752i() {
        return (this.f8715i == null || this.f8712f == -1 || this.f8712f == 0 || this.f8712f == 1) ? false : true;
    }
}
