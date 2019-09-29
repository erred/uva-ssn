package com.twitter.sdk.android.core.services;

import com.twitter.sdk.android.core.p132a.C3119o;
import java.util.List;
import p136d.C3380b;
import p136d.p139b.C3383c;
import p136d.p139b.C3385e;
import p136d.p139b.C3386f;
import p136d.p139b.C3395o;
import p136d.p139b.C3399s;
import p136d.p139b.C3400t;

public interface StatusesService {
    @C3385e
    @C3395o(mo28223a = "/1.1/statuses/destroy/{id}.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    C3380b<C3119o> destroy(@C3399s(mo28228a = "id") Long l, @C3383c(mo28211a = "trim_user") Boolean bool);

    @C3386f(mo28214a = "/1.1/statuses/home_timeline.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    C3380b<List<C3119o>> homeTimeline(@C3400t(mo28230a = "count") Integer num, @C3400t(mo28230a = "since_id") Long l, @C3400t(mo28230a = "max_id") Long l2, @C3400t(mo28230a = "trim_user") Boolean bool, @C3400t(mo28230a = "exclude_replies") Boolean bool2, @C3400t(mo28230a = "contributor_details") Boolean bool3, @C3400t(mo28230a = "include_entities") Boolean bool4);

    @C3386f(mo28214a = "/1.1/statuses/lookup.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    C3380b<List<C3119o>> lookup(@C3400t(mo28230a = "id") String str, @C3400t(mo28230a = "include_entities") Boolean bool, @C3400t(mo28230a = "trim_user") Boolean bool2, @C3400t(mo28230a = "map") Boolean bool3);

    @C3386f(mo28214a = "/1.1/statuses/mentions_timeline.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    C3380b<List<C3119o>> mentionsTimeline(@C3400t(mo28230a = "count") Integer num, @C3400t(mo28230a = "since_id") Long l, @C3400t(mo28230a = "max_id") Long l2, @C3400t(mo28230a = "trim_user") Boolean bool, @C3400t(mo28230a = "contributor_details") Boolean bool2, @C3400t(mo28230a = "include_entities") Boolean bool3);

    @C3385e
    @C3395o(mo28223a = "/1.1/statuses/retweet/{id}.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    C3380b<C3119o> retweet(@C3399s(mo28228a = "id") Long l, @C3383c(mo28211a = "trim_user") Boolean bool);

    @C3386f(mo28214a = "/1.1/statuses/retweets_of_me.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    C3380b<List<C3119o>> retweetsOfMe(@C3400t(mo28230a = "count") Integer num, @C3400t(mo28230a = "since_id") Long l, @C3400t(mo28230a = "max_id") Long l2, @C3400t(mo28230a = "trim_user") Boolean bool, @C3400t(mo28230a = "include_entities") Boolean bool2, @C3400t(mo28230a = "include_user_entities") Boolean bool3);

    @C3386f(mo28214a = "/1.1/statuses/show.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    C3380b<C3119o> show(@C3400t(mo28230a = "id") Long l, @C3400t(mo28230a = "trim_user") Boolean bool, @C3400t(mo28230a = "include_my_retweet") Boolean bool2, @C3400t(mo28230a = "include_entities") Boolean bool3);

    @C3385e
    @C3395o(mo28223a = "/1.1/statuses/unretweet/{id}.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    C3380b<C3119o> unretweet(@C3399s(mo28228a = "id") Long l, @C3383c(mo28211a = "trim_user") Boolean bool);

    @C3385e
    @C3395o(mo28223a = "/1.1/statuses/update.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    C3380b<C3119o> update(@C3383c(mo28211a = "status") String str, @C3383c(mo28211a = "in_reply_to_status_id") Long l, @C3383c(mo28211a = "possibly_sensitive") Boolean bool, @C3383c(mo28211a = "lat") Double d, @C3383c(mo28211a = "long") Double d2, @C3383c(mo28211a = "place_id") String str2, @C3383c(mo28211a = "display_coordinates") Boolean bool2, @C3383c(mo28211a = "trim_user") Boolean bool3, @C3383c(mo28211a = "media_ids") String str3);

    @C3386f(mo28214a = "/1.1/statuses/user_timeline.json?tweet_mode=extended&include_cards=true&cards_platform=TwitterKit-13")
    C3380b<List<C3119o>> userTimeline(@C3400t(mo28230a = "user_id") Long l, @C3400t(mo28230a = "screen_name") String str, @C3400t(mo28230a = "count") Integer num, @C3400t(mo28230a = "since_id") Long l2, @C3400t(mo28230a = "max_id") Long l3, @C3400t(mo28230a = "trim_user") Boolean bool, @C3400t(mo28230a = "exclude_replies") Boolean bool2, @C3400t(mo28230a = "contributor_details") Boolean bool3, @C3400t(mo28230a = "include_rts") Boolean bool4);
}
