package com.twitter.sdk.android.core.services;

import com.twitter.sdk.android.core.p132a.C3119o;
import java.util.List;
import p136d.C3380b;
import p136d.p139b.C3383c;
import p136d.p139b.C3385e;
import p136d.p139b.C3386f;
import p136d.p139b.C3395o;
import p136d.p139b.C3400t;

public interface FavoriteService {
    @C3385e
    @C3395o(mo28223a = "/1.1/favorites/create.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    C3380b<C3119o> create(@C3383c(mo28211a = "id") Long l, @C3383c(mo28211a = "include_entities") Boolean bool);

    @C3385e
    @C3395o(mo28223a = "/1.1/favorites/destroy.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    C3380b<C3119o> destroy(@C3383c(mo28211a = "id") Long l, @C3383c(mo28211a = "include_entities") Boolean bool);

    @C3386f(mo28214a = "/1.1/favorites/list.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    C3380b<List<C3119o>> list(@C3400t(mo28230a = "user_id") Long l, @C3400t(mo28230a = "screen_name") String str, @C3400t(mo28230a = "count") Integer num, @C3400t(mo28230a = "since_id") String str2, @C3400t(mo28230a = "max_id") String str3, @C3400t(mo28230a = "include_entities") Boolean bool);
}
