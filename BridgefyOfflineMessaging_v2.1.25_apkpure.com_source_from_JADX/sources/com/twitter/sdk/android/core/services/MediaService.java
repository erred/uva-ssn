package com.twitter.sdk.android.core.services;

import com.twitter.sdk.android.core.p132a.C3111i;
import p091b.C1592ab;
import p136d.C3380b;
import p136d.p139b.C3392l;
import p136d.p139b.C3395o;
import p136d.p139b.C3397q;

public interface MediaService {
    @C3392l
    @C3395o(mo28223a = "https://upload.twitter.com/1.1/media/upload.json")
    C3380b<C3111i> upload(@C3397q(mo28225a = "media") C1592ab abVar, @C3397q(mo28225a = "media_data") C1592ab abVar2, @C3397q(mo28225a = "additional_owners") C1592ab abVar3);
}
