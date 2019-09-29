package p140me.bridgefy.image;

import android.app.Activity;
import android.net.Uri;
import android.os.AsyncTask;
import android.widget.ImageView;
import java.io.File;
import p140me.bridgefy.entities.Message;
import p140me.bridgefy.utils.C3667g;

/* renamed from: me.bridgefy.image.a */
/* compiled from: ImageLoader */
public class C3540a {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static C3540a f9265b;

    /* renamed from: a */
    private Activity f9266a;

    /* renamed from: c */
    private Message f9267c;

    /* renamed from: d */
    private int f9268d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C3542b f9269e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public BridgefyProgress f9270f;

    /* renamed from: g */
    private C3542b f9271g = new C3542b() {
        /* renamed from: a */
        public void mo29150a(C3540a aVar) {
            if (aVar.f9270f != null) {
                aVar.f9270f.setVisibility(0);
                aVar.f9270f.mo29366d();
            }
            if (aVar.f9269e != null) {
                aVar.f9269e.mo29150a(aVar);
            }
        }

        /* renamed from: a */
        public void mo29148a(Uri uri) {
            if (C3540a.f9265b.f9269e != null) {
                C3540a.f9265b.f9269e.mo29148a(uri);
            }
        }

        /* renamed from: a */
        public void mo29149a(Exception exc) {
            if (C3540a.f9265b.f9269e != null) {
                C3540a.f9265b.f9269e.mo29149a(exc);
            }
        }
    };

    private C3540a() {
    }

    /* renamed from: a */
    public static C3540a m10384a(Activity activity) {
        if (f9265b == null) {
            f9265b = new C3540a();
        }
        f9265b.f9266a = activity;
        return f9265b;
    }

    /* renamed from: a */
    public C3540a mo29410a(Message message) {
        if (message != null) {
            f9265b.f9267c = message;
            return f9265b;
        }
        throw new IllegalArgumentException("Message must not be null.");
    }

    /* renamed from: a */
    public C3540a mo29411a(BridgefyProgress bridgefyProgress) {
        if (bridgefyProgress != null) {
            f9265b.f9270f = bridgefyProgress;
            return f9265b;
        }
        throw new IllegalArgumentException("ProgresBar must not be null.");
    }

    /* renamed from: a */
    public C3540a mo29409a(int i) {
        if (i != 0) {
            f9265b.f9268d = i;
            return f9265b;
        }
        throw new IllegalArgumentException("Resource ID must not be zero.");
    }

    /* renamed from: a */
    public C3540a mo29412a(C3542b bVar) {
        if (bVar != null) {
            f9265b.f9269e = bVar;
            return f9265b;
        }
        throw new IllegalArgumentException("ImageLoaderListener must not be null.");
    }

    /* renamed from: a */
    public void mo29413a(ImageView imageView) {
        try {
            String findFilePath = f9265b.f9267c.findFilePath();
            if (m10386b(f9265b.f9267c) || findFilePath == null) {
                new C3543c(f9265b).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new C3540a[0]);
                f9265b.f9271g.mo29150a(f9265b);
            } else {
                f9265b.f9269e.mo29148a(Uri.parse(findFilePath));
            }
        } catch (Exception e) {
            e.printStackTrace();
            f9265b.f9269e.mo29149a(e);
        }
    }

    /* renamed from: b */
    private boolean m10386b(Message message) {
        StringBuilder sb = new StringBuilder();
        sb.append(C3667g.m10937a("Bridgefy/thumbs").getPath());
        sb.append("/");
        sb.append(message.getFileName());
        return new File(sb.toString()).exists();
    }

    /* renamed from: a */
    public Activity mo29408a() {
        return this.f9266a;
    }

    /* renamed from: b */
    public Message mo29414b() {
        return this.f9267c;
    }

    /* renamed from: c */
    public C3542b mo29415c() {
        return this.f9269e;
    }
}
