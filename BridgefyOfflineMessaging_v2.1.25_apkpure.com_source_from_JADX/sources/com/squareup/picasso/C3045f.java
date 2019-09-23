package com.squareup.picasso;

import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract.Contacts;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import com.squareup.picasso.C3068t.C3074d;
import com.squareup.picasso.C3085y.C3086a;
import java.io.IOException;
import java.io.InputStream;
import p102c.C1683l;

/* renamed from: com.squareup.picasso.f */
/* compiled from: ContactsPhotoRequestHandler */
class C3045f extends C3085y {

    /* renamed from: a */
    private static final UriMatcher f7957a = new UriMatcher(-1);

    /* renamed from: b */
    private final Context f7958b;

    static {
        f7957a.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        f7957a.addURI("com.android.contacts", "contacts/lookup/*", 1);
        f7957a.addURI("com.android.contacts", "contacts/#/photo", 2);
        f7957a.addURI("com.android.contacts", "contacts/#", 3);
        f7957a.addURI("com.android.contacts", "display_photo/#", 4);
    }

    C3045f(Context context) {
        this.f7958b = context;
    }

    /* renamed from: a */
    public boolean mo27455a(C3081w wVar) {
        Uri uri = wVar.f8073d;
        return Param.CONTENT.equals(uri.getScheme()) && Contacts.CONTENT_URI.getHost().equals(uri.getHost()) && f7957a.match(wVar.f8073d) != -1;
    }

    /* renamed from: a */
    public C3086a mo27454a(C3081w wVar, int i) throws IOException {
        InputStream b = m8993b(wVar);
        if (b == null) {
            return null;
        }
        return new C3086a(C1683l.m7039a(b), C3074d.DISK);
    }

    /* renamed from: b */
    private InputStream m8993b(C3081w wVar) throws IOException {
        ContentResolver contentResolver = this.f7958b.getContentResolver();
        Uri uri = wVar.f8073d;
        switch (f7957a.match(uri)) {
            case 1:
                uri = Contacts.lookupContact(contentResolver, uri);
                if (uri == null) {
                    return null;
                }
                break;
            case 2:
            case 4:
                return contentResolver.openInputStream(uri);
            case 3:
                break;
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid uri: ");
                sb.append(uri);
                throw new IllegalStateException(sb.toString());
        }
        return Contacts.openContactPhotoInputStream(contentResolver, uri, true);
    }
}
