package com.twitter.sdk.android.core.services;

import com.twitter.sdk.android.core.p132a.C3119o;
import java.util.List;
import p136d.C3380b;
import p136d.p139b.C3386f;
import p136d.p139b.C3400t;

public interface ListService {
    @C3386f(mo28214a = "/1.1/lists/statuses.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    C3380b<List<C3119o>> statuses(@C3400t(mo28230a = "list_id") Long l, @C3400t(mo28230a = "slug") String str, @C3400t(mo28230a = "owner_screen_name") String str2, @C3400t(mo28230a = "owner_id") Long l2, @C3400t(mo28230a = "since_id") Long l3, @C3400t(mo28230a = "max_id") Long l4, @C3400t(mo28230a = "count") Integer num, @C3400t(mo28230a = "include_entities") Boolean bool, @C3400t(mo28230a = "include_rts") Boolean bool2);
}
