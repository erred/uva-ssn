package com.twitter.sdk.android.core.services;

import p136d.C3380b;
import p136d.p139b.C3386f;
import p136d.p139b.C3400t;

public interface CollectionService {
    @C3386f(mo28214a = "/1.1/collections/entries.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    C3380b<Object> collection(@C3400t(mo28230a = "id") String str, @C3400t(mo28230a = "count") Integer num, @C3400t(mo28230a = "max_position") Long l, @C3400t(mo28230a = "min_position") Long l2);
}
