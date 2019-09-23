package com.twitter.sdk.android.core.services;

import com.twitter.sdk.android.core.p132a.C3123s;
import p136d.C3380b;
import p136d.p139b.C3386f;
import p136d.p139b.C3400t;

public interface AccountService {
    @C3386f(mo28214a = "/1.1/account/verify_credentials.json")
    C3380b<C3123s> verifyCredentials(@C3400t(mo28230a = "include_entities") Boolean bool, @C3400t(mo28230a = "skip_status") Boolean bool2, @C3400t(mo28230a = "include_email") Boolean bool3);
}
