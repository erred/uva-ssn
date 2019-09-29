package p140me.bridgefy.service.p147d;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;
import androidx.p079f.p080a.C1049a;
import com.bridgefy.sdk.client.CryptoRSA;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import me.bridgefy.main.R;
import org.apache.commons.p154a.C3688b;
import p000a.p013b.p017b.C0161b;
import p140me.bridgefy.backend.p143v3.bgfyMessageApi.model.BgfyMessage;
import p140me.bridgefy.backend.p143v3.bgfyMessageApi.model.EndpointMessageResponse;
import p140me.bridgefy.cloud.C3517a;
import p140me.bridgefy.cloud.C3519c;
import p140me.bridgefy.cloud.C3519c.C3522b;
import p140me.bridgefy.cloud.C3519c.C3523c;
import p140me.bridgefy.entities.BridgefyPeer;
import p140me.bridgefy.entities.Message;
import p140me.bridgefy.integration.C3549b;
import p140me.bridgefy.main.BridgefyApp;
import p140me.bridgefy.ormlite.DatabaseHelper;
import p140me.bridgefy.ormlite.entities.MessageDTO;
import p140me.bridgefy.p141a.C3455a;
import p140me.bridgefy.p141a.C3460d;
import p140me.bridgefy.service.p144a.C3615a;
import p140me.bridgefy.utils.C3659b;
import p140me.bridgefy.utils.C3661c;
import p140me.bridgefy.utils.C3667g;

/* renamed from: me.bridgefy.service.d.b */
/* compiled from: OnlineManager */
public class C3622b extends C3629c {

    /* renamed from: b */
    static C3622b f9556b;

    /* renamed from: a */
    String f9557a = C3661c.f9688b[0];

    /* renamed from: g */
    private final String f9558g = "internetAvailable";

    /* renamed from: h */
    private SharedPreferences f9559h;

    /* renamed from: me.bridgefy.service.d.b$a */
    /* compiled from: OnlineManager */
    private class C3628a extends AsyncTask<Intent, Void, Void> {

        /* renamed from: a */
        Context f9571a;

        /* renamed from: b */
        DatabaseHelper f9572b;

        /* renamed from: c */
        Intent f9573c;

        public C3628a(Context context, DatabaseHelper databaseHelper) {
            this.f9571a = context;
            this.f9572b = databaseHelper;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Intent... intentArr) {
            this.f9573c = intentArr[0];
            if (this.f9573c == null) {
                return null;
            }
            HashMap hashMap = (HashMap) this.f9573c.getExtras().getSerializable("map");
            if (hashMap != null && !hashMap.isEmpty()) {
                if (hashMap.get(MessageDTO.CONVERSATION) != null) {
                    C3622b.this.m10725a(hashMap, this.f9571a, this.f9572b);
                    return null;
                } else if (hashMap.get(MessageDTO.STATUS) != null && hashMap.get("cloudId") != null) {
                    C3622b.this.m10718a(hashMap, this.f9572b);
                    return null;
                } else if (hashMap.get("cloudId") != null) {
                    if (C3622b.this.f9579e == null) {
                        C3622b.this.f9579e = new C3460d(this.f9572b);
                    }
                    C3622b.this.m10716a(Long.parseLong((String) hashMap.get("cloudId")), hashMap);
                }
            }
            return null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Void voidR) {
            super.onPostExecute(voidR);
        }
    }

    private C3622b(Context context, DatabaseHelper databaseHelper) {
        super(context, databaseHelper);
        this.f9559h = context.getSharedPreferences("BgfyPrefs", 0);
        if (C3517a.m10256a() == null) {
            C3517a.m10259a(mo29676c());
        }
        BridgefyApp.m10557c().mo29530g().mo27385a((Object) this);
    }

    /* renamed from: a */
    public static synchronized C3622b m10715a(Context context, DatabaseHelper databaseHelper) {
        C3622b bVar;
        synchronized (C3622b.class) {
            boolean z = true;
            if (f9556b != null) {
                if (f9556b.mo29677d() != null && f9556b.mo29677d().isOpen()) {
                    if (databaseHelper != null) {
                        boolean isOpen = databaseHelper.isOpen();
                    }
                    z = false;
                }
                if (z) {
                    f9556b.mo29657a();
                }
            }
            if (z) {
                f9556b = new C3622b(context, databaseHelper);
            }
            bVar = f9556b;
        }
        return bVar;
    }

    /* renamed from: a */
    public void mo29657a() {
        this.f9578d = null;
        this.f9579e = null;
        f9556b = null;
        BridgefyApp.m10557c().mo29530g().mo27388b((Object) this);
    }

    /* renamed from: a */
    public void mo29661a(final ArrayList<Message> arrayList, final String str) {
        m10717a("Messages", (Object) arrayList);
        new AsyncTask<Object, Object, Object[]>() {
            /* access modifiers changed from: protected */
            public void onPreExecute() {
                C3517a.m10259a(C3622b.this.mo29676c());
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public Object[] doInBackground(Object[] objArr) {
                BgfyMessage bgfyMessage;
                if (arrayList.size() <= 15) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Message message = (Message) it.next();
                        try {
                            MessageDTO a = C3622b.this.f9579e.mo28335a(message.getOfflineId());
                            switch (message.getType()) {
                                case 1:
                                    C3659b.m10894a("Messages", "imageMessageSent", C3622b.this.f9557a, 0, BridgefyApp.m10557c().mo29529e());
                                    bgfyMessage = C3622b.this.m10711a(message, true);
                                    C3517a.m10256a().mo29195b(C3622b.this.m10713a(message), C3622b.this.m10727b(message.getReceiver()));
                                    break;
                                case 2:
                                    C3659b.m10894a("Messages", "locationMessageSent", C3622b.this.f9557a, 0, BridgefyApp.m10557c().mo29529e());
                                    BgfyMessage b = C3622b.this.m10728b(message);
                                    bgfyMessage = C3517a.m10256a().mo29187a(new Message(b), b.getChecksumKey().longValue());
                                    message.setStatus(3);
                                    a.setStatus(3);
                                    break;
                                default:
                                    C3659b.m10894a("Messages", "textMessageSent", C3622b.this.f9557a, 0, BridgefyApp.m10557c().mo29529e());
                                    BgfyMessage b2 = C3622b.this.m10728b(message);
                                    bgfyMessage = C3517a.m10256a().mo29187a(new Message(b2), b2.getChecksumKey().longValue());
                                    message.setStatus(3);
                                    a.setStatus(3);
                                    break;
                            }
                            message.setMessageId(String.valueOf(bgfyMessage.getMessageId()));
                            a.setMessageId(String.valueOf(bgfyMessage.getMessageId()));
                            C3622b.this.f9579e.mo28338a(a);
                        } catch (IllegalArgumentException unused) {
                            publishProgress(new Object[0]);
                        } catch (GoogleJsonResponseException e) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Error code: ");
                            sb.append(e.getStatusCode());
                            sb.append(" message: ");
                            sb.append(e.getStatusMessage());
                            Log.w("OnlineManager", sb.toString());
                            int statusCode = e.getStatusCode();
                            if (statusCode == 401) {
                                e.printStackTrace();
                                message.setStatus(3);
                                C3622b.this.f9579e.mo28337a(message);
                            } else if (statusCode != 409) {
                                e.printStackTrace();
                                message.setStatus(2);
                                C3622b.this.f9579e.mo28337a(message);
                            } else {
                                message.setStatus(0);
                                C3622b.this.f9579e.mo28337a(message);
                                final String receiver = message.getReceiver();
                                C3519c.m10308a(receiver, (C3523c) new C3523c<String>() {
                                    public void onSubscribe(C0161b bVar) {
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("Updating key for userId: ");
                                        sb.append(receiver);
                                        Log.d("OnlineManager", sb.toString());
                                    }

                                    /* renamed from: a */
                                    public void onSuccess(String str) {
                                        C3622b.this.mo29662a(true);
                                        C3622b.this.f9578d.mo28318a(receiver, str);
                                    }

                                    public void onError(Throwable th) {
                                        C3622b.this.mo29662a(false);
                                        th.printStackTrace();
                                    }
                                });
                            }
                        } catch (UnknownHostException e2) {
                            C3622b.this.mo29662a(false);
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Unable to send message through OnlineManager ");
                            sb2.append(e2.getLocalizedMessage());
                            Log.e("OnlineManager", sb2.toString());
                            message.setStatus(2);
                            C3622b.this.f9579e.mo28337a(message);
                        } catch (Exception unused2) {
                            Log.e("OnlineManager", "Unable to send message through OnlineManager.");
                            message.setStatus(2);
                            C3622b.this.f9579e.mo28337a(message);
                            C3659b.m10894a("Messages", C3661c.f9691e[message.getType()], C3622b.this.f9557a, 0, BridgefyApp.m10557c().mo29529e());
                        }
                        C3549b.m10417a(message);
                    }
                } else {
                    try {
                        EndpointMessageResponse a2 = C3517a.m10256a().mo29188a(C3622b.this.m10709a(arrayList));
                        if (a2.getBgfyMessages() != null && a2.getBgfyMessages().size() > 0) {
                            C3622b.this.m10719a(a2.getBgfyMessages());
                        }
                        if (a2.getBgfyMessagesError() != null && a2.getBgfyMessagesError().size() > 0) {
                            C3622b.this.m10731b(a2.getBgfyMessagesError());
                        }
                    } catch (IllegalArgumentException unused3) {
                        publishProgress(new Object[0]);
                    } catch (NullPointerException | UnknownHostException unused4) {
                        C3622b.this.mo29662a(false);
                        BridgefyPeer b3 = C3615a.m10678a().mo29653b(str);
                        Intent putExtra = new Intent().setAction("chatMessageSendqueueBackground").putExtra("userId", str);
                        if (b3 != null) {
                            C1049a.m3996a(C3622b.this.mo29676c()).mo4060a(putExtra);
                        }
                    } catch (IOException e3) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("error: ");
                        sb3.append(e3.getMessage());
                        Log.e("OnlineManager", sb3.toString());
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            Message message2 = (Message) it2.next();
                            message2.setStatus(2);
                            try {
                                C3622b.this.f9579e.mo28337a(message2);
                                C3549b.m10417a(message2);
                            } catch (NullPointerException unused5) {
                            }
                        }
                        e3.printStackTrace();
                    }
                }
                return null;
            }

            /* access modifiers changed from: protected */
            public void onProgressUpdate(Object[] objArr) {
                super.onProgressUpdate(objArr);
                Toast.makeText(C3622b.this.mo29676c(), C3622b.this.mo29676c().getResources().getString(R.string.message_error), 0).show();
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public ArrayList<BgfyMessage> m10709a(ArrayList<Message> arrayList) throws IOException {
        ArrayList<BgfyMessage> arrayList2 = new ArrayList<>();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Message message = (Message) it.next();
            if (message.getType() != 1) {
                arrayList2.add(m10728b(message));
            } else {
                arrayList2.add(m10711a(message, true));
            }
        }
        return arrayList2;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Message m10713a(Message message) throws IOException, IllegalArgumentException {
        Uri findFileUri = message.findFileUri();
        ContentResolver contentResolver = mo29676c().getContentResolver();
        C3667g.m10938a(findFileUri);
        InputStream openInputStream = contentResolver.openInputStream(findFileUri);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(C3688b.m10972a(openInputStream));
        gZIPOutputStream.close();
        message.setFileContent(byteArrayOutputStream.toByteArray());
        return message;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public BgfyMessage m10711a(Message message, boolean z) throws IOException, IllegalArgumentException {
        byte[] bArr;
        Uri findFileUri = message.findFileUri();
        long b = m10727b(message.getReceiver());
        ContentResolver contentResolver = mo29676c().getContentResolver();
        HashMap a = C3667g.m10938a(findFileUri);
        InputStream openInputStream = contentResolver.openInputStream(findFileUri);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (z) {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(C3688b.m10972a(openInputStream));
            gZIPOutputStream.close();
            bArr = byteArrayOutputStream.toByteArray();
        } else {
            bArr = C3688b.m10972a(openInputStream);
        }
        BgfyMessage bgfyMessage = new BgfyMessage();
        bgfyMessage.setDateSent(Long.valueOf(Long.parseLong(message.getDateSent())));
        bgfyMessage.setSender(message.getSender());
        bgfyMessage.setReceiver(message.getReceiver());
        bgfyMessage.setText(message.getText());
        bgfyMessage.setFileBytes(Base64.encodeBase64String(bArr));
        bgfyMessage.setFilePath(message.getFileName());
        bgfyMessage.setMimetype((String) a.get("mimeType"));
        bgfyMessage.setChecksumKey(Long.valueOf(b));
        bgfyMessage.setLocalID(message.getOfflineId());
        bgfyMessage.setMessageType(Integer.valueOf(1));
        return bgfyMessage;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public BgfyMessage m10728b(Message message) throws IOException {
        BgfyMessage bgfyMessage = new BgfyMessage();
        String c = m10733c(message);
        if (c != null) {
            bgfyMessage.setText(c);
            long b = m10727b(message.getReceiver());
            bgfyMessage.setDateSent(Long.valueOf(Long.parseLong(message.getDateSent())));
            bgfyMessage.setSender(message.getSender());
            bgfyMessage.setReceiver(message.getReceiver());
            bgfyMessage.setChecksumKey(Long.valueOf(b));
            bgfyMessage.setLocalID(message.getOfflineId());
            bgfyMessage.setMessageType(Integer.valueOf(message.getType()));
            return bgfyMessage;
        }
        throw new IllegalArgumentException("Text encryption failure");
    }

    /* renamed from: c */
    private String m10733c(Message message) throws IOException {
        String a = this.f9578d.mo28315a(message.getReceiver());
        if (a == null) {
            Log.i("OnlineManager", "Updating key from backend");
            a = C3517a.m10256a().mo29183a(message.getReceiver());
            this.f9578d.mo28318a(message.getReceiver(), a);
        }
        try {
            return CryptoRSA.base64StringFromBytes(CryptoRSA.encrypt(a, message.getText().getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public long m10727b(String str) {
        String a = this.f9578d.mo28315a(str);
        if (a != null) {
            return C3659b.m10885a(a);
        }
        return 0;
    }

    /* renamed from: a */
    public void mo29658a(Intent intent, Context context, DatabaseHelper databaseHelper) {
        new C3628a(context, databaseHelper).execute(new Intent[]{intent});
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10716a(long j, final HashMap hashMap) {
        C3519c.m10293a(j, (C3523c) new C3523c<Message>() {
            /* renamed from: a */
            public void onSuccess(Message message) {
                C3622b.this.mo29662a(true);
                C3622b.this.m10720a(message, hashMap);
            }

            public void onError(Throwable th) {
                th.printStackTrace();
            }
        });
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x012e, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0130, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m10720a(p140me.bridgefy.entities.Message r9, java.util.HashMap r10) {
        /*
            r8 = this;
            monitor-enter(r8)
            me.bridgefy.a.d r0 = r8.f9579e     // Catch:{ all -> 0x0131 }
            if (r0 != 0) goto L_0x0019
            me.bridgefy.ormlite.DatabaseHelper r0 = r8.mo29677d()     // Catch:{ all -> 0x0131 }
            if (r0 == 0) goto L_0x0017
            me.bridgefy.a.d r0 = new me.bridgefy.a.d     // Catch:{ all -> 0x0131 }
            me.bridgefy.ormlite.DatabaseHelper r1 = r8.mo29677d()     // Catch:{ all -> 0x0131 }
            r0.<init>(r1)     // Catch:{ all -> 0x0131 }
            r8.f9579e = r0     // Catch:{ all -> 0x0131 }
            goto L_0x0019
        L_0x0017:
            monitor-exit(r8)
            return
        L_0x0019:
            java.lang.String r0 = "dateSent"
            java.lang.Object r0 = r10.get(r0)     // Catch:{ all -> 0x0131 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0131 }
            r9.setDateSent(r0)     // Catch:{ all -> 0x0131 }
            me.bridgefy.a.d r0 = r8.f9579e     // Catch:{ all -> 0x0131 }
            java.lang.String r1 = r9.getDateSent()     // Catch:{ all -> 0x0131 }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x0131 }
            java.lang.String r2 = r9.getSender()     // Catch:{ all -> 0x0131 }
            me.bridgefy.entities.Message r0 = r0.mo28334a(r1, r2)     // Catch:{ all -> 0x0131 }
            if (r0 != 0) goto L_0x012f
            me.bridgefy.a.d r0 = r8.f9579e     // Catch:{ all -> 0x0131 }
            java.lang.String r1 = r9.getOfflineId()     // Catch:{ all -> 0x0131 }
            me.bridgefy.entities.Message r0 = r0.mo28341b(r1)     // Catch:{ all -> 0x0131 }
            if (r0 == 0) goto L_0x0046
            goto L_0x012f
        L_0x0046:
            java.lang.String r0 = "senderPhone"
            java.lang.Object r0 = r10.get(r0)     // Catch:{ all -> 0x0131 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0131 }
            java.lang.String r1 = "senderName"
            java.lang.Object r10 = r10.get(r1)     // Catch:{ all -> 0x0131 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x0131 }
            me.bridgefy.a.c r1 = r8.f9578d     // Catch:{ all -> 0x0131 }
            java.lang.String r2 = r9.getSender()     // Catch:{ all -> 0x0131 }
            me.bridgefy.ormlite.entities.FriendDTO r7 = r1.mo28323c(r2)     // Catch:{ all -> 0x0131 }
            if (r7 == 0) goto L_0x006f
            boolean r1 = r7.isBlocked()     // Catch:{ all -> 0x0131 }
            if (r1 == 0) goto L_0x006f
            me.bridgefy.a.c r9 = r8.f9578d     // Catch:{ all -> 0x0131 }
            r9.mo28321b()     // Catch:{ all -> 0x0131 }
            monitor-exit(r8)
            return
        L_0x006f:
            me.bridgefy.a.c r1 = r8.f9578d     // Catch:{ all -> 0x0131 }
            java.lang.String r3 = r9.getSender()     // Catch:{ all -> 0x0131 }
            android.content.Context r6 = r8.mo29676c()     // Catch:{ all -> 0x0131 }
            r2 = r7
            r4 = r10
            r5 = r0
            java.lang.String r1 = r1.mo28316a(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0131 }
            r9.setOtherUserName(r10)     // Catch:{ all -> 0x0131 }
            java.lang.String r10 = r9.getText()     // Catch:{ Exception -> 0x00a7 }
            if (r10 == 0) goto L_0x00ab
            int r10 = r9.getType()     // Catch:{ Exception -> 0x00a7 }
            r2 = 1
            if (r10 == r2) goto L_0x00ab
            java.lang.String r10 = new java.lang.String     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r2 = r8.f9577c     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r3 = r9.getText()     // Catch:{ Exception -> 0x00a7 }
            byte[] r3 = com.bridgefy.sdk.client.CryptoRSA.bytesFromBase64(r3)     // Catch:{ Exception -> 0x00a7 }
            byte[] r2 = com.bridgefy.sdk.client.CryptoRSA.decrypt(r2, r3)     // Catch:{ Exception -> 0x00a7 }
            r10.<init>(r2)     // Catch:{ Exception -> 0x00a7 }
            r9.setText(r10)     // Catch:{ Exception -> 0x00a7 }
            goto L_0x00ab
        L_0x00a7:
            r10 = move-exception
            r10.printStackTrace()     // Catch:{ all -> 0x0131 }
        L_0x00ab:
            java.lang.String r10 = r9.getFileName()     // Catch:{ IOException -> 0x00c1 }
            if (r10 == 0) goto L_0x00c5
            java.lang.String r10 = r9.getFileName()     // Catch:{ IOException -> 0x00c1 }
            int r10 = r10.length()     // Catch:{ IOException -> 0x00c1 }
            if (r10 <= 0) goto L_0x00c5
            java.lang.String r10 = "Bridgefy/thumbs"
            p140me.bridgefy.utils.C3667g.m10941a(r9, r10)     // Catch:{ IOException -> 0x00c1 }
            goto L_0x00c5
        L_0x00c1:
            r10 = move-exception
            r10.printStackTrace()     // Catch:{ all -> 0x0131 }
        L_0x00c5:
            r10 = -1
            r9.setStatus(r10)     // Catch:{ all -> 0x0131 }
            me.bridgefy.a.d r2 = r8.f9579e     // Catch:{ all -> 0x0131 }
            r2.mo28336a(r7, r9, r0)     // Catch:{ all -> 0x0131 }
            java.lang.String r2 = r9.getSender()     // Catch:{ all -> 0x0131 }
            r8.mo29660a(r2, r10)     // Catch:{ all -> 0x0131 }
            android.content.Context r10 = r8.mo29676c()     // Catch:{ all -> 0x0131 }
            android.os.Bundle r10 = p140me.bridgefy.service.p147d.C3620a.m10700a(r10, r9, r1)     // Catch:{ all -> 0x0131 }
            java.lang.String r2 = "otherUserName"
            r10.putString(r2, r1)     // Catch:{ all -> 0x0131 }
            java.lang.String r2 = "otherUserPhone"
            r10.putString(r2, r0)     // Catch:{ all -> 0x0131 }
            java.lang.String r0 = "cloudId"
            java.lang.String r2 = r9.getMessageId()     // Catch:{ all -> 0x0131 }
            long r2 = java.lang.Long.parseLong(r2)     // Catch:{ all -> 0x0131 }
            r10.putLong(r0, r2)     // Catch:{ all -> 0x0131 }
            android.content.Intent r0 = new android.content.Intent     // Catch:{ all -> 0x0131 }
            r0.<init>()     // Catch:{ all -> 0x0131 }
            java.lang.String r2 = "chatMessage"
            android.content.Intent r0 = r0.setAction(r2)     // Catch:{ all -> 0x0131 }
            android.content.Context r2 = r8.mo29676c()     // Catch:{ all -> 0x0131 }
            java.lang.Class<me.bridgefy.chat.ChatActivity> r3 = p140me.bridgefy.chat.ChatActivity.class
            android.content.Intent r0 = r0.setClass(r2, r3)     // Catch:{ all -> 0x0131 }
            android.content.Intent r0 = r0.putExtras(r10)     // Catch:{ all -> 0x0131 }
            android.content.Context r2 = r8.mo29676c()     // Catch:{ all -> 0x0131 }
            androidx.f.a.a r2 = androidx.p079f.p080a.C1049a.m3996a(r2)     // Catch:{ all -> 0x0131 }
            r2.mo4060a(r0)     // Catch:{ all -> 0x0131 }
            java.lang.String r9 = r9.getSender()     // Catch:{ all -> 0x0131 }
            java.lang.String r0 = p140me.bridgefy.service.BridgefyService.m10666e()     // Catch:{ all -> 0x0131 }
            boolean r9 = r9.equals(r0)     // Catch:{ all -> 0x0131 }
            if (r9 != 0) goto L_0x012d
            me.bridgefy.service.d.a r9 = p140me.bridgefy.service.p147d.C3620a.m10702a()     // Catch:{ all -> 0x0131 }
            r9.mo29656a(r10, r1)     // Catch:{ all -> 0x0131 }
        L_0x012d:
            monitor-exit(r8)
            return
        L_0x012f:
            monitor-exit(r8)
            return
        L_0x0131:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: p140me.bridgefy.service.p147d.C3622b.m10720a(me.bridgefy.entities.Message, java.util.HashMap):void");
    }

    /* renamed from: a */
    public void mo29660a(String str, final int i) {
        C3519c.m10310a(this.f9579e.mo28340b(i, str), i, (C3522b) new C3522b<MessageDTO>() {
            /* renamed from: a */
            public void onNext(MessageDTO messageDTO) {
                int i = i;
                if (i == -1) {
                    messageDTO.setStatus(-2);
                } else if (i != 5) {
                    messageDTO.setStatus(i);
                } else {
                    messageDTO.setStatus(-3);
                }
                if (C3622b.this.f9579e != null) {
                    C3622b.this.f9579e.mo28338a(messageDTO);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m10718a(HashMap hashMap, DatabaseHelper databaseHelper) {
        int parseInt = Integer.parseInt((String) hashMap.get(MessageDTO.STATUS));
        long parseLong = Long.parseLong((String) hashMap.get("cloudId"));
        if (this.f9579e == null) {
            this.f9579e = new C3460d(databaseHelper);
        }
        Message b = this.f9579e.mo28341b(String.valueOf(parseLong));
        if (b != null) {
            switch (parseInt) {
                case 2:
                    parseInt = 4;
                    break;
                case 3:
                    parseInt = 5;
                    break;
            }
            b.setStatus(parseInt);
            this.f9579e.mo28337a(b);
            C3549b.m10417a(b);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized boolean m10725a(HashMap hashMap, Context context, DatabaseHelper databaseHelper) {
        String str = (String) hashMap.get(MessageDTO.CONVERSATION);
        if (this.f9580f == null) {
            this.f9580f = new C3455a(databaseHelper);
        }
        int parseInt = Integer.parseInt((String) hashMap.get(MessageDTO.STATUS));
        switch (parseInt) {
            case 2:
                parseInt = 4;
                break;
            case 3:
                parseInt = 5;
                break;
        }
        this.f9580f.mo28310a(str, Integer.valueOf(parseInt));
        C1049a.m3996a(context).mo4060a(new Intent("messageStatusUpdate"));
        return true;
    }

    /* renamed from: b */
    private void m10730b(ArrayList<BgfyMessage> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            BgfyMessage bgfyMessage = (BgfyMessage) it.next();
            boolean z = true;
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                if (bgfyMessage.getReceiver().equals((String) it2.next())) {
                    z = false;
                }
            }
            if (z) {
                arrayList2.add(bgfyMessage.getReceiver());
            }
        }
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            mo29659a((String) it3.next());
        }
    }

    /* renamed from: a */
    public void mo29659a(final String str) {
        C3519c.m10308a(str, (C3523c) new C3523c<String>() {
            public void onSubscribe(C0161b bVar) {
                StringBuilder sb = new StringBuilder();
                sb.append("Updating key for userId: ");
                sb.append(str);
                Log.d("OnlineManager", sb.toString());
            }

            /* renamed from: a */
            public void onSuccess(String str) {
                C3622b.this.mo29662a(true);
                C3622b.this.f9578d.mo28318a(str, str);
            }

            public void onError(Throwable th) {
                C3622b.this.mo29662a(false);
                th.printStackTrace();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10719a(List<BgfyMessage> list) {
        for (BgfyMessage bgfyMessage : list) {
            Message message = new Message(this.f9579e.mo28335a(bgfyMessage.getLocalID()));
            message.setStatus(3);
            message.setMessageId(String.valueOf(bgfyMessage.getMessageId()));
            this.f9579e.mo28337a(message);
            C3549b.m10417a(message);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m10731b(List<BgfyMessage> list) {
        ArrayList arrayList = new ArrayList();
        for (BgfyMessage bgfyMessage : list) {
            C3659b.m10894a("Messages", C3661c.f9691e[bgfyMessage.getMessageType().intValue()], this.f9557a, 0, BridgefyApp.m10557c().mo29529e());
            int parseInt = Integer.parseInt(bgfyMessage.getMessageError());
            if (parseInt != 404) {
                if (parseInt == 409) {
                    arrayList.add(bgfyMessage);
                }
            }
            try {
                Message message = new Message(this.f9579e.mo28335a(bgfyMessage.getLocalID()));
                message.setStatus(2);
                this.f9579e.mo28337a(message);
                C3549b.m10417a(message);
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
        m10730b(arrayList);
    }

    /* renamed from: a */
    private void m10717a(String str, Object obj) {
        if (obj == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" cannot be null");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: b */
    public boolean mo29663b() {
        return this.f9559h.getBoolean("internetAvailable", true);
    }

    /* renamed from: a */
    public synchronized void mo29662a(boolean z) {
        this.f9559h.edit().putBoolean("internetAvailable", z).apply();
        BridgefyApp.m10557c().mo29530g().mo27391c((Object) Boolean.valueOf(z));
    }
}
