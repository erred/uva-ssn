package com.twitter.sdk.android.core.services;

import com.twitter.sdk.android.core.services.p135a.C3264a;
import p136d.C3380b;
import p136d.p139b.C3386f;
import p136d.p139b.C3400t;

public interface SearchService {
    @C3386f(mo28214a = "/1.1/search/tweets.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    C3380b<Object> tweets(@C3400t(mo28230a = "q") String str, @C3400t(mo28230a = "geocode", mo28231b = true) C3264a aVar, @C3400t(mo28230a = "lang") String str2, @C3400t(mo28230a = "locale") String str3, @C3400t(mo28230a = "result_type") String str4, @C3400t(mo28230a = "count") Integer num, @C3400t(mo28230a = "until") String str5, @C3400t(mo28230a = "since_id") Long l, @C3400t(mo28230a = "max_id") Long l2, @C3400t(mo28230a = "include_entities") Boolean bool);
}
