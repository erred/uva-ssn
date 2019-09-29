package twitter4j;

import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import p140me.bridgefy.ormlite.entities.MessageDTO;
import twitter4j.api.DirectMessagesResources;
import twitter4j.api.FavoritesResources;
import twitter4j.api.FriendsFollowersResources;
import twitter4j.api.HelpResources;
import twitter4j.api.HelpResources.Language;
import twitter4j.api.ListsResources;
import twitter4j.api.PlacesGeoResources;
import twitter4j.api.SavedSearchesResources;
import twitter4j.api.SearchResource;
import twitter4j.api.SpamReportingResource;
import twitter4j.api.SuggestedUsersResources;
import twitter4j.api.TimelinesResources;
import twitter4j.api.TrendsResources;
import twitter4j.api.TweetsResources;
import twitter4j.api.UsersResources;
import twitter4j.auth.Authorization;
import twitter4j.conf.Configuration;

class TwitterImpl extends TwitterBaseImpl implements Twitter {
    private static final ConcurrentHashMap<Configuration, HttpParameter[]> implicitParamsMap = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<Configuration, String> implicitParamsStrMap = new ConcurrentHashMap<>();
    private static final long serialVersionUID = 9170943084096085770L;
    private final HttpParameter[] IMPLICIT_PARAMS;
    private final String IMPLICIT_PARAMS_STR;
    private final HttpParameter INCLUDE_MY_RETWEET;

    public DirectMessagesResources directMessages() {
        return this;
    }

    public FavoritesResources favorites() {
        return this;
    }

    public FriendsFollowersResources friendsFollowers() {
        return this;
    }

    public HelpResources help() {
        return this;
    }

    public ListsResources list() {
        return this;
    }

    public PlacesGeoResources placesGeo() {
        return this;
    }

    public SavedSearchesResources savedSearches() {
        return this;
    }

    public SearchResource search() {
        return this;
    }

    public SpamReportingResource spamReporting() {
        return this;
    }

    public SuggestedUsersResources suggestedUsers() {
        return this;
    }

    public TimelinesResources timelines() {
        return this;
    }

    public TrendsResources trends() {
        return this;
    }

    public TweetsResources tweets() {
        return this;
    }

    public UsersResources users() {
        return this;
    }

    TwitterImpl(Configuration configuration, Authorization authorization) {
        super(configuration, authorization);
        this.INCLUDE_MY_RETWEET = new HttpParameter("include_my_retweet", configuration.isIncludeMyRetweetEnabled());
        if (implicitParamsMap.containsKey(configuration)) {
            this.IMPLICIT_PARAMS = (HttpParameter[]) implicitParamsMap.get(configuration);
            this.IMPLICIT_PARAMS_STR = (String) implicitParamsStrMap.get(configuration);
            return;
        }
        String str = configuration.isIncludeEntitiesEnabled() ? "include_entities=true" : "";
        boolean z = configuration.getContributingTo() != -1;
        if (z) {
            if (!"".equals(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("?");
                str = sb.toString();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append("contributingto=");
            sb2.append(configuration.getContributingTo());
            str = sb2.toString();
        }
        ArrayList arrayList = new ArrayList(3);
        if (configuration.isIncludeEntitiesEnabled()) {
            arrayList.add(new HttpParameter("include_entities", "true"));
        }
        if (z) {
            arrayList.add(new HttpParameter("contributingto", configuration.getContributingTo()));
        }
        if (configuration.isTrimUserEnabled()) {
            arrayList.add(new HttpParameter("trim_user", "1"));
        }
        HttpParameter[] httpParameterArr = (HttpParameter[]) arrayList.toArray(new HttpParameter[arrayList.size()]);
        implicitParamsStrMap.putIfAbsent(configuration, str);
        implicitParamsMap.putIfAbsent(configuration, httpParameterArr);
        this.IMPLICIT_PARAMS = httpParameterArr;
        this.IMPLICIT_PARAMS_STR = str;
    }

    public ResponseList<Status> getMentionsTimeline() throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("statuses/mentions_timeline.json");
        return objectFactory.createStatusList(get(sb.toString()));
    }

    public ResponseList<Status> getMentionsTimeline(Paging paging) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("statuses/mentions_timeline.json");
        return objectFactory.createStatusList(get(sb.toString(), paging.asPostParameterArray()));
    }

    public ResponseList<Status> getHomeTimeline() throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("statuses/home_timeline.json");
        return objectFactory.createStatusList(get(sb.toString(), new HttpParameter[]{this.INCLUDE_MY_RETWEET}));
    }

    public ResponseList<Status> getHomeTimeline(Paging paging) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("statuses/home_timeline.json");
        return objectFactory.createStatusList(get(sb.toString(), mergeParameters(paging.asPostParameterArray(), new HttpParameter[]{this.INCLUDE_MY_RETWEET})));
    }

    public ResponseList<Status> getRetweetsOfMe() throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("statuses/retweets_of_me.json");
        return objectFactory.createStatusList(get(sb.toString()));
    }

    public ResponseList<Status> getRetweetsOfMe(Paging paging) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("statuses/retweets_of_me.json");
        return objectFactory.createStatusList(get(sb.toString(), paging.asPostParameterArray()));
    }

    public ResponseList<Status> getUserTimeline(String str, Paging paging) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("statuses/user_timeline.json");
        return objectFactory.createStatusList(get(sb.toString(), mergeParameters(new HttpParameter[]{new HttpParameter("screen_name", str), this.INCLUDE_MY_RETWEET}, paging.asPostParameterArray())));
    }

    public ResponseList<Status> getUserTimeline(long j, Paging paging) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("statuses/user_timeline.json");
        return objectFactory.createStatusList(get(sb.toString(), mergeParameters(new HttpParameter[]{new HttpParameter("user_id", j), this.INCLUDE_MY_RETWEET}, paging.asPostParameterArray())));
    }

    public ResponseList<Status> getUserTimeline(String str) throws TwitterException {
        return getUserTimeline(str, new Paging());
    }

    public ResponseList<Status> getUserTimeline(long j) throws TwitterException {
        return getUserTimeline(j, new Paging());
    }

    public ResponseList<Status> getUserTimeline() throws TwitterException {
        return getUserTimeline(new Paging());
    }

    public ResponseList<Status> getUserTimeline(Paging paging) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("statuses/user_timeline.json");
        return objectFactory.createStatusList(get(sb.toString(), mergeParameters(new HttpParameter[]{this.INCLUDE_MY_RETWEET}, paging.asPostParameterArray())));
    }

    public ResponseList<Status> getRetweets(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("statuses/retweets/");
        sb.append(j);
        sb.append(".json?count=100");
        return objectFactory.createStatusList(get(sb.toString()));
    }

    public IDs getRetweeterIds(long j, long j2) throws TwitterException {
        return getRetweeterIds(j, 100, j2);
    }

    public IDs getRetweeterIds(long j, int i, long j2) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("statuses/retweeters/ids.json?id=");
        sb.append(j);
        sb.append("&cursor=");
        sb.append(j2);
        sb.append("&count=");
        sb.append(i);
        return objectFactory.createIDs(get(sb.toString()));
    }

    public Status showStatus(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("statuses/show/");
        sb.append(j);
        sb.append(".json");
        return objectFactory.createStatus(get(sb.toString(), new HttpParameter[]{this.INCLUDE_MY_RETWEET}));
    }

    public Status destroyStatus(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("statuses/destroy/");
        sb.append(j);
        sb.append(".json");
        return objectFactory.createStatus(post(sb.toString()));
    }

    public Status updateStatus(String str) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("statuses/update.json");
        return objectFactory.createStatus(post(sb.toString(), new HttpParameter[]{new HttpParameter(MessageDTO.STATUS, str)}));
    }

    public Status updateStatus(StatusUpdate statusUpdate) throws TwitterException {
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append(statusUpdate.isForUpdateWithMedia() ? "statuses/update_with_media.json" : "statuses/update.json");
        return this.factory.createStatus(post(sb.toString(), statusUpdate.asHttpParameterArray()));
    }

    public Status retweetStatus(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("statuses/retweet/");
        sb.append(j);
        sb.append(".json");
        return objectFactory.createStatus(post(sb.toString()));
    }

    public OEmbed getOEmbed(OEmbedRequest oEmbedRequest) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("statuses/oembed.json");
        return objectFactory.createOEmbed(get(sb.toString(), oEmbedRequest.asHttpParameterArray()));
    }

    public ResponseList<Status> lookup(long[] jArr) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("statuses/lookup.json?id=");
        sb.append(StringUtil.join(jArr));
        return objectFactory.createStatusList(get(sb.toString()));
    }

    public UploadedMedia uploadMedia(File file) throws TwitterException {
        checkFileValidity(file);
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getUploadBaseURL());
        sb.append("media/upload.json");
        return new UploadedMedia(post(sb.toString(), new HttpParameter[]{new HttpParameter("media", file)}).asJSONObject());
    }

    public QueryResult search(Query query) throws TwitterException {
        if (query.nextPage() != null) {
            ObjectFactory objectFactory = this.factory;
            StringBuilder sb = new StringBuilder();
            sb.append(this.conf.getRestBaseURL());
            sb.append("search/tweets.json");
            sb.append(query.nextPage());
            return objectFactory.createQueryResult(get(sb.toString()), query);
        }
        ObjectFactory objectFactory2 = this.factory;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.conf.getRestBaseURL());
        sb2.append("search/tweets.json");
        return objectFactory2.createQueryResult(get(sb2.toString(), query.asHttpParameterArray()), query);
    }

    public ResponseList<DirectMessage> getDirectMessages() throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("direct_messages.json");
        return objectFactory.createDirectMessageList(get(sb.toString()));
    }

    public ResponseList<DirectMessage> getDirectMessages(Paging paging) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("direct_messages.json");
        return objectFactory.createDirectMessageList(get(sb.toString(), paging.asPostParameterArray()));
    }

    public ResponseList<DirectMessage> getSentDirectMessages() throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("direct_messages/sent.json");
        return objectFactory.createDirectMessageList(get(sb.toString()));
    }

    public ResponseList<DirectMessage> getSentDirectMessages(Paging paging) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("direct_messages/sent.json");
        return objectFactory.createDirectMessageList(get(sb.toString(), paging.asPostParameterArray()));
    }

    public DirectMessage showDirectMessage(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("direct_messages/show.json?id=");
        sb.append(j);
        return objectFactory.createDirectMessage(get(sb.toString()));
    }

    public DirectMessage destroyDirectMessage(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("direct_messages/destroy.json?id=");
        sb.append(j);
        return objectFactory.createDirectMessage(post(sb.toString()));
    }

    public DirectMessage sendDirectMessage(long j, String str) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("direct_messages/new.json");
        return objectFactory.createDirectMessage(post(sb.toString(), new HttpParameter[]{new HttpParameter("user_id", j), new HttpParameter("text", str)}));
    }

    public DirectMessage sendDirectMessage(String str, String str2) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("direct_messages/new.json");
        return objectFactory.createDirectMessage(post(sb.toString(), new HttpParameter[]{new HttpParameter("screen_name", str), new HttpParameter("text", str2)}));
    }

    public InputStream getDMImageAsStream(String str) throws TwitterException {
        return get(str).asStream();
    }

    public IDs getNoRetweetsFriendships() throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("friendships/no_retweets/ids.json");
        return objectFactory.createIDs(get(sb.toString()));
    }

    public IDs getFriendsIDs(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("friends/ids.json?cursor=");
        sb.append(j);
        return objectFactory.createIDs(get(sb.toString()));
    }

    public IDs getFriendsIDs(long j, long j2) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("friends/ids.json?user_id=");
        sb.append(j);
        sb.append("&cursor=");
        sb.append(j2);
        return objectFactory.createIDs(get(sb.toString()));
    }

    public IDs getFriendsIDs(long j, long j2, int i) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("friends/ids.json?user_id=");
        sb.append(j);
        sb.append("&cursor=");
        sb.append(j2);
        sb.append("&count=");
        sb.append(i);
        return objectFactory.createIDs(get(sb.toString()));
    }

    public IDs getFriendsIDs(String str, long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("friends/ids.json?screen_name=");
        sb.append(str);
        sb.append("&cursor=");
        sb.append(j);
        return objectFactory.createIDs(get(sb.toString()));
    }

    public IDs getFriendsIDs(String str, long j, int i) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("friends/ids.json?screen_name=");
        sb.append(str);
        sb.append("&cursor=");
        sb.append(j);
        sb.append("&count=");
        sb.append(i);
        return objectFactory.createIDs(get(sb.toString()));
    }

    public IDs getFollowersIDs(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("followers/ids.json?cursor=");
        sb.append(j);
        return objectFactory.createIDs(get(sb.toString()));
    }

    public IDs getFollowersIDs(long j, long j2) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("followers/ids.json?user_id=");
        sb.append(j);
        sb.append("&cursor=");
        sb.append(j2);
        return objectFactory.createIDs(get(sb.toString()));
    }

    public IDs getFollowersIDs(long j, long j2, int i) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("followers/ids.json?user_id=");
        sb.append(j);
        sb.append("&cursor=");
        sb.append(j2);
        sb.append("&count=");
        sb.append(i);
        return objectFactory.createIDs(get(sb.toString()));
    }

    public IDs getFollowersIDs(String str, long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("followers/ids.json?screen_name=");
        sb.append(str);
        sb.append("&cursor=");
        sb.append(j);
        return objectFactory.createIDs(get(sb.toString()));
    }

    public IDs getFollowersIDs(String str, long j, int i) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("followers/ids.json?screen_name=");
        sb.append(str);
        sb.append("&cursor=");
        sb.append(j);
        sb.append("&count=");
        sb.append(i);
        return objectFactory.createIDs(get(sb.toString()));
    }

    public ResponseList<Friendship> lookupFriendships(long[] jArr) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("friendships/lookup.json?user_id=");
        sb.append(StringUtil.join(jArr));
        return objectFactory.createFriendshipList(get(sb.toString()));
    }

    public ResponseList<Friendship> lookupFriendships(String[] strArr) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("friendships/lookup.json?screen_name=");
        sb.append(StringUtil.join(strArr));
        return objectFactory.createFriendshipList(get(sb.toString()));
    }

    public IDs getIncomingFriendships(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("friendships/incoming.json?cursor=");
        sb.append(j);
        return objectFactory.createIDs(get(sb.toString()));
    }

    public IDs getOutgoingFriendships(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("friendships/outgoing.json?cursor=");
        sb.append(j);
        return objectFactory.createIDs(get(sb.toString()));
    }

    public User createFriendship(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("friendships/create.json?user_id=");
        sb.append(j);
        return objectFactory.createUser(post(sb.toString()));
    }

    public User createFriendship(String str) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("friendships/create.json?screen_name=");
        sb.append(str);
        return objectFactory.createUser(post(sb.toString()));
    }

    public User createFriendship(long j, boolean z) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("friendships/create.json?user_id=");
        sb.append(j);
        sb.append("&follow=");
        sb.append(z);
        return objectFactory.createUser(post(sb.toString()));
    }

    public User createFriendship(String str, boolean z) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("friendships/create.json?screen_name=");
        sb.append(str);
        sb.append("&follow=");
        sb.append(z);
        return objectFactory.createUser(post(sb.toString()));
    }

    public User destroyFriendship(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("friendships/destroy.json?user_id=");
        sb.append(j);
        return objectFactory.createUser(post(sb.toString()));
    }

    public User destroyFriendship(String str) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("friendships/destroy.json?screen_name=");
        sb.append(str);
        return objectFactory.createUser(post(sb.toString()));
    }

    public Relationship updateFriendship(long j, boolean z, boolean z2) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("friendships/update.json");
        return objectFactory.createRelationship(post(sb.toString(), new HttpParameter[]{new HttpParameter("user_id", j), new HttpParameter("device", z), new HttpParameter("retweets", z2)}));
    }

    public Relationship updateFriendship(String str, boolean z, boolean z2) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("friendships/update.json");
        return objectFactory.createRelationship(post(sb.toString(), new HttpParameter[]{new HttpParameter("screen_name", str), new HttpParameter("device", z), new HttpParameter("retweets", z2)}));
    }

    public Relationship showFriendship(long j, long j2) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("friendships/show.json");
        return objectFactory.createRelationship(get(sb.toString(), new HttpParameter[]{new HttpParameter("source_id", j), new HttpParameter("target_id", j2)}));
    }

    public Relationship showFriendship(String str, String str2) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("friendships/show.json");
        return objectFactory.createRelationship(get(sb.toString(), HttpParameter.getParameterArray("source_screen_name", str, "target_screen_name", str2)));
    }

    public PagableResponseList<User> getFriendsList(long j, long j2) throws TwitterException {
        return getFriendsList(j, j2, 20);
    }

    public PagableResponseList<User> getFriendsList(long j, long j2, int i) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("friends/list.json?user_id=");
        sb.append(j);
        sb.append("&cursor=");
        sb.append(j2);
        sb.append("&count=");
        sb.append(i);
        return objectFactory.createPagableUserList(get(sb.toString()));
    }

    public PagableResponseList<User> getFriendsList(String str, long j) throws TwitterException {
        return getFriendsList(str, j, 20);
    }

    public PagableResponseList<User> getFriendsList(String str, long j, int i) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("friends/list.json?screen_name=");
        sb.append(str);
        sb.append("&cursor=");
        sb.append(j);
        sb.append("&count=");
        sb.append(i);
        return objectFactory.createPagableUserList(get(sb.toString()));
    }

    public PagableResponseList<User> getFriendsList(long j, long j2, int i, boolean z, boolean z2) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("friends/list.json?user_id=");
        sb.append(j);
        sb.append("&cursor=");
        sb.append(j2);
        sb.append("&count=");
        sb.append(i);
        sb.append("&skip_status=");
        sb.append(z);
        sb.append("&include_user_entities=");
        sb.append(z2);
        return objectFactory.createPagableUserList(get(sb.toString()));
    }

    public PagableResponseList<User> getFriendsList(String str, long j, int i, boolean z, boolean z2) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("friends/list.json?screen_name=");
        sb.append(str);
        sb.append("&cursor=");
        sb.append(j);
        sb.append("&count=");
        sb.append(i);
        sb.append("&skip_status=");
        sb.append(z);
        sb.append("&include_user_entities=");
        sb.append(z2);
        return objectFactory.createPagableUserList(get(sb.toString()));
    }

    public PagableResponseList<User> getFollowersList(long j, long j2) throws TwitterException {
        return getFollowersList(j, j2, 20);
    }

    public PagableResponseList<User> getFollowersList(String str, long j) throws TwitterException {
        return getFollowersList(str, j, 20);
    }

    public PagableResponseList<User> getFollowersList(long j, long j2, int i) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("followers/list.json?user_id=");
        sb.append(j);
        sb.append("&cursor=");
        sb.append(j2);
        sb.append("&count=");
        sb.append(i);
        return objectFactory.createPagableUserList(get(sb.toString()));
    }

    public PagableResponseList<User> getFollowersList(String str, long j, int i) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("followers/list.json?screen_name=");
        sb.append(str);
        sb.append("&cursor=");
        sb.append(j);
        sb.append("&count=");
        sb.append(i);
        return objectFactory.createPagableUserList(get(sb.toString()));
    }

    public PagableResponseList<User> getFollowersList(long j, long j2, int i, boolean z, boolean z2) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("followers/list.json?user_id=");
        sb.append(j);
        sb.append("&cursor=");
        sb.append(j2);
        sb.append("&count=");
        sb.append(i);
        sb.append("&skip_status=");
        sb.append(z);
        sb.append("&include_user_entities=");
        sb.append(z2);
        return objectFactory.createPagableUserList(get(sb.toString()));
    }

    public PagableResponseList<User> getFollowersList(String str, long j, int i, boolean z, boolean z2) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("followers/list.json?screen_name=");
        sb.append(str);
        sb.append("&cursor=");
        sb.append(j);
        sb.append("&count=");
        sb.append(i);
        sb.append("&skip_status=");
        sb.append(z);
        sb.append("&include_user_entities=");
        sb.append(z2);
        return objectFactory.createPagableUserList(get(sb.toString()));
    }

    public AccountSettings getAccountSettings() throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("account/settings.json");
        return objectFactory.createAccountSettings(get(sb.toString()));
    }

    public User verifyCredentials() throws TwitterException {
        return super.fillInIDAndScreenName();
    }

    public AccountSettings updateAccountSettings(Integer num, Boolean bool, String str, String str2, String str3, String str4) throws TwitterException {
        ArrayList arrayList = new ArrayList(6);
        if (num != null) {
            arrayList.add(new HttpParameter("trend_location_woeid", num.intValue()));
        }
        if (bool != null) {
            arrayList.add(new HttpParameter("sleep_time_enabled", bool.toString()));
        }
        if (str != null) {
            arrayList.add(new HttpParameter("start_sleep_time", str));
        }
        if (str2 != null) {
            arrayList.add(new HttpParameter("end_sleep_time", str2));
        }
        if (str3 != null) {
            arrayList.add(new HttpParameter("time_zone", str3));
        }
        if (str4 != null) {
            arrayList.add(new HttpParameter("lang", str4));
        }
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("account/settings.json");
        return objectFactory.createAccountSettings(post(sb.toString(), (HttpParameter[]) arrayList.toArray(new HttpParameter[arrayList.size()])));
    }

    public User updateProfile(String str, String str2, String str3, String str4) throws TwitterException {
        ArrayList arrayList = new ArrayList(4);
        addParameterToList(arrayList, "name", str);
        addParameterToList(arrayList, ImagesContract.URL, str2);
        addParameterToList(arrayList, Param.LOCATION, str3);
        addParameterToList(arrayList, "description", str4);
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("account/update_profile.json");
        return objectFactory.createUser(post(sb.toString(), (HttpParameter[]) arrayList.toArray(new HttpParameter[arrayList.size()])));
    }

    public User updateProfileBackgroundImage(File file, boolean z) throws TwitterException {
        checkFileValidity(file);
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("account/update_profile_background_image.json");
        return objectFactory.createUser(post(sb.toString(), new HttpParameter[]{new HttpParameter(MessageDTO.IMAGE, file), new HttpParameter("tile", z)}));
    }

    public User updateProfileBackgroundImage(InputStream inputStream, boolean z) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("account/update_profile_background_image.json");
        return objectFactory.createUser(post(sb.toString(), new HttpParameter[]{new HttpParameter(MessageDTO.IMAGE, MessageDTO.IMAGE, inputStream), new HttpParameter("tile", z)}));
    }

    public User updateProfileColors(String str, String str2, String str3, String str4, String str5) throws TwitterException {
        ArrayList arrayList = new ArrayList(6);
        addParameterToList(arrayList, "profile_background_color", str);
        addParameterToList(arrayList, "profile_text_color", str2);
        addParameterToList(arrayList, "profile_link_color", str3);
        addParameterToList(arrayList, "profile_sidebar_fill_color", str4);
        addParameterToList(arrayList, "profile_sidebar_border_color", str5);
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("account/update_profile_colors.json");
        return objectFactory.createUser(post(sb.toString(), (HttpParameter[]) arrayList.toArray(new HttpParameter[arrayList.size()])));
    }

    private void addParameterToList(List<HttpParameter> list, String str, String str2) {
        if (str2 != null) {
            list.add(new HttpParameter(str, str2));
        }
    }

    public User updateProfileImage(File file) throws TwitterException {
        checkFileValidity(file);
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("account/update_profile_image.json");
        return objectFactory.createUser(post(sb.toString(), new HttpParameter[]{new HttpParameter(MessageDTO.IMAGE, file)}));
    }

    public User updateProfileImage(InputStream inputStream) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("account/update_profile_image.json");
        return objectFactory.createUser(post(sb.toString(), new HttpParameter[]{new HttpParameter(MessageDTO.IMAGE, MessageDTO.IMAGE, inputStream)}));
    }

    private void checkFileValidity(File file) throws TwitterException {
        if (!file.exists()) {
            StringBuilder sb = new StringBuilder();
            sb.append(file);
            sb.append(" is not found.");
            throw new TwitterException((Exception) new FileNotFoundException(sb.toString()));
        } else if (!file.isFile()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(file);
            sb2.append(" is not a file.");
            throw new TwitterException((Exception) new IOException(sb2.toString()));
        }
    }

    public PagableResponseList<User> getBlocksList() throws TwitterException {
        return getBlocksList(-1);
    }

    public PagableResponseList<User> getBlocksList(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("blocks/list.json?cursor=");
        sb.append(j);
        return objectFactory.createPagableUserList(get(sb.toString()));
    }

    public IDs getBlocksIDs() throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("blocks/ids.json");
        return objectFactory.createIDs(get(sb.toString()));
    }

    public IDs getBlocksIDs(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("blocks/ids.json?cursor=");
        sb.append(j);
        return objectFactory.createIDs(get(sb.toString()));
    }

    public User createBlock(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("blocks/create.json?user_id=");
        sb.append(j);
        return objectFactory.createUser(post(sb.toString()));
    }

    public User createBlock(String str) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("blocks/create.json?screen_name=");
        sb.append(str);
        return objectFactory.createUser(post(sb.toString()));
    }

    public User destroyBlock(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("blocks/destroy.json?user_id=");
        sb.append(j);
        return objectFactory.createUser(post(sb.toString()));
    }

    public User destroyBlock(String str) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("blocks/destroy.json?screen_name=");
        sb.append(str);
        return objectFactory.createUser(post(sb.toString()));
    }

    public PagableResponseList<User> getMutesList(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("mutes/users/list.json?cursor=");
        sb.append(j);
        return objectFactory.createPagableUserList(get(sb.toString()));
    }

    public IDs getMutesIDs(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("mutes/users/ids.json?cursor=");
        sb.append(j);
        return objectFactory.createIDs(get(sb.toString()));
    }

    public User createMute(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("mutes/users/create.json?user_id=");
        sb.append(j);
        return objectFactory.createUser(post(sb.toString()));
    }

    public User createMute(String str) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("mutes/users/create.json?screen_name=");
        sb.append(str);
        return objectFactory.createUser(post(sb.toString()));
    }

    public User destroyMute(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("mutes/users/destroy.json?user_id=");
        sb.append(j);
        return objectFactory.createUser(post(sb.toString()));
    }

    public User destroyMute(String str) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("mutes/users/destroy.json?screen_name=");
        sb.append(str);
        return objectFactory.createUser(post(sb.toString()));
    }

    public ResponseList<User> lookupUsers(long[] jArr) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("users/lookup.json");
        return objectFactory.createUserList(get(sb.toString(), new HttpParameter[]{new HttpParameter("user_id", StringUtil.join(jArr))}));
    }

    public ResponseList<User> lookupUsers(String[] strArr) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("users/lookup.json");
        return objectFactory.createUserList(get(sb.toString(), new HttpParameter[]{new HttpParameter("screen_name", StringUtil.join(strArr))}));
    }

    public User showUser(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("users/show.json?user_id=");
        sb.append(j);
        return objectFactory.createUser(get(sb.toString()));
    }

    public User showUser(String str) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("users/show.json?screen_name=");
        sb.append(str);
        return objectFactory.createUser(get(sb.toString()));
    }

    public ResponseList<User> searchUsers(String str, int i) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("users/search.json");
        return objectFactory.createUserList(get(sb.toString(), new HttpParameter[]{new HttpParameter("q", str), new HttpParameter("per_page", 20), new HttpParameter("page", i)}));
    }

    public ResponseList<User> getContributees(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("users/contributees.json?user_id=");
        sb.append(j);
        return objectFactory.createUserList(get(sb.toString()));
    }

    public ResponseList<User> getContributees(String str) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("users/contributees.json?screen_name=");
        sb.append(str);
        return objectFactory.createUserList(get(sb.toString()));
    }

    public ResponseList<User> getContributors(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("users/contributors.json?user_id=");
        sb.append(j);
        return objectFactory.createUserList(get(sb.toString()));
    }

    public ResponseList<User> getContributors(String str) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("users/contributors.json?screen_name=");
        sb.append(str);
        return objectFactory.createUserList(get(sb.toString()));
    }

    public void removeProfileBanner() throws TwitterException {
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("account/remove_profile_banner.json");
        post(sb.toString());
    }

    public void updateProfileBanner(File file) throws TwitterException {
        checkFileValidity(file);
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("account/update_profile_banner.json");
        post(sb.toString(), new HttpParameter[]{new HttpParameter("banner", file)});
    }

    public void updateProfileBanner(InputStream inputStream) throws TwitterException {
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("account/update_profile_banner.json");
        post(sb.toString(), new HttpParameter[]{new HttpParameter("banner", "banner", inputStream)});
    }

    public ResponseList<User> getUserSuggestions(String str) throws TwitterException {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(this.conf.getRestBaseURL());
            sb.append("users/suggestions/");
            sb.append(URLEncoder.encode(str, "UTF-8"));
            sb.append(".json");
            return this.factory.createUserListFromJSONArray_Users(get(sb.toString()));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public ResponseList<Category> getSuggestedUserCategories() throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("users/suggestions.json");
        return objectFactory.createCategoryList(get(sb.toString()));
    }

    public ResponseList<User> getMemberSuggestions(String str) throws TwitterException {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(this.conf.getRestBaseURL());
            sb.append("users/suggestions/");
            sb.append(URLEncoder.encode(str, "UTF-8"));
            sb.append("/members.json");
            return this.factory.createUserListFromJSONArray(get(sb.toString()));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public ResponseList<Status> getFavorites() throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("favorites/list.json");
        return objectFactory.createStatusList(get(sb.toString()));
    }

    public ResponseList<Status> getFavorites(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("favorites/list.json?user_id=");
        sb.append(j);
        return objectFactory.createStatusList(get(sb.toString()));
    }

    public ResponseList<Status> getFavorites(String str) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("favorites/list.json?screen_name=");
        sb.append(str);
        return objectFactory.createStatusList(get(sb.toString()));
    }

    public ResponseList<Status> getFavorites(Paging paging) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("favorites/list.json");
        return objectFactory.createStatusList(get(sb.toString(), paging.asPostParameterArray()));
    }

    public ResponseList<Status> getFavorites(long j, Paging paging) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("favorites/list.json");
        return objectFactory.createStatusList(get(sb.toString(), mergeParameters(new HttpParameter[]{new HttpParameter("user_id", j)}, paging.asPostParameterArray())));
    }

    public ResponseList<Status> getFavorites(String str, Paging paging) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("favorites/list.json");
        return objectFactory.createStatusList(get(sb.toString(), mergeParameters(new HttpParameter[]{new HttpParameter("screen_name", str)}, paging.asPostParameterArray())));
    }

    public Status destroyFavorite(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("favorites/destroy.json?id=");
        sb.append(j);
        return objectFactory.createStatus(post(sb.toString()));
    }

    public Status createFavorite(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("favorites/create.json?id=");
        sb.append(j);
        return objectFactory.createStatus(post(sb.toString()));
    }

    public ResponseList<UserList> getUserLists(String str) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("lists/list.json?screen_name=");
        sb.append(str);
        return objectFactory.createUserListList(get(sb.toString()));
    }

    public ResponseList<UserList> getUserLists(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("lists/list.json?user_id=");
        sb.append(j);
        return objectFactory.createUserListList(get(sb.toString()));
    }

    public ResponseList<Status> getUserListStatuses(long j, Paging paging) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("lists/statuses.json");
        return objectFactory.createStatusList(get(sb.toString(), mergeParameters(paging.asPostParameterArray(Paging.SMCP, "count"), new HttpParameter("list_id", j))));
    }

    public ResponseList<Status> getUserListStatuses(long j, String str, Paging paging) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("lists/statuses.json");
        return objectFactory.createStatusList(get(sb.toString(), mergeParameters(paging.asPostParameterArray(Paging.SMCP, "count"), new HttpParameter[]{new HttpParameter("owner_id", j), new HttpParameter("slug", str)})));
    }

    public ResponseList<Status> getUserListStatuses(String str, String str2, Paging paging) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("lists/statuses.json");
        return objectFactory.createStatusList(get(sb.toString(), mergeParameters(paging.asPostParameterArray(Paging.SMCP, "count"), new HttpParameter[]{new HttpParameter("owner_screen_name", str), new HttpParameter("slug", str2)})));
    }

    public UserList destroyUserListMember(long j, long j2) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("lists/members/destroy.json");
        return objectFactory.createAUserList(post(sb.toString(), new HttpParameter[]{new HttpParameter("list_id", j), new HttpParameter("user_id", j2)}));
    }

    public UserList destroyUserListMember(long j, String str, long j2) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("lists/members/destroy.json");
        return objectFactory.createAUserList(post(sb.toString(), new HttpParameter[]{new HttpParameter("owner_id", j), new HttpParameter("slug", str), new HttpParameter("user_id", j2)}));
    }

    public UserList destroyUserListMember(long j, String str) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("lists/members/destroy.json");
        return objectFactory.createAUserList(post(sb.toString(), new HttpParameter[]{new HttpParameter("list_id", j), new HttpParameter("screen_name", str)}));
    }

    public UserList destroyUserListMember(String str, String str2, long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("lists/members/destroy.json");
        return objectFactory.createAUserList(post(sb.toString(), new HttpParameter[]{new HttpParameter("owner_screen_name", str), new HttpParameter("slug", str2), new HttpParameter("user_id", j)}));
    }

    public UserList destroyUserListMembers(long j, String[] strArr) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("lists/members/destroy_all.json");
        return objectFactory.createAUserList(post(sb.toString(), new HttpParameter[]{new HttpParameter("list_id", j), new HttpParameter("screen_name", StringUtil.join(strArr))}));
    }

    public UserList destroyUserListMembers(long j, long[] jArr) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("lists/members/destroy_all.json");
        return objectFactory.createAUserList(post(sb.toString(), new HttpParameter[]{new HttpParameter("list_id", j), new HttpParameter("user_id", StringUtil.join(jArr))}));
    }

    public UserList destroyUserListMembers(String str, String str2, String[] strArr) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("lists/members/destroy_all.json");
        return objectFactory.createAUserList(post(sb.toString(), new HttpParameter[]{new HttpParameter("owner_screen_name", str), new HttpParameter("slug", str2), new HttpParameter("screen_name", StringUtil.join(strArr))}));
    }

    public PagableResponseList<UserList> getUserListMemberships(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("lists/memberships.json?cursor=");
        sb.append(j);
        return objectFactory.createPagableUserListList(get(sb.toString()));
    }

    public PagableResponseList<UserList> getUserListMemberships(String str, long j) throws TwitterException {
        return getUserListMemberships(str, j, false);
    }

    public PagableResponseList<UserList> getUserListMemberships(long j, long j2) throws TwitterException {
        return getUserListMemberships(j, j2, false);
    }

    public PagableResponseList<UserList> getUserListMemberships(long j, long j2, boolean z) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("lists/memberships.json?user_id=");
        sb.append(j);
        sb.append("&cursor=");
        sb.append(j2);
        sb.append("&filter_to_owned_lists=");
        sb.append(z);
        return objectFactory.createPagableUserListList(get(sb.toString()));
    }

    public PagableResponseList<UserList> getUserListMemberships(String str, long j, boolean z) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("lists/memberships.json?screen_name=");
        sb.append(str);
        sb.append("&cursor=");
        sb.append(j);
        sb.append("&filter_to_owned_lists=");
        sb.append(z);
        return objectFactory.createPagableUserListList(get(sb.toString()));
    }

    public PagableResponseList<User> getUserListSubscribers(long j, long j2) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("lists/subscribers.json?list_id=");
        sb.append(j);
        sb.append("&cursor=");
        sb.append(j2);
        return objectFactory.createPagableUserList(get(sb.toString()));
    }

    public PagableResponseList<User> getUserListSubscribers(long j, String str, long j2) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("lists/subscribers.json?owner_id=");
        sb.append(j);
        sb.append("&slug=");
        sb.append(str);
        sb.append("&cursor=");
        sb.append(j2);
        return objectFactory.createPagableUserList(get(sb.toString()));
    }

    public PagableResponseList<User> getUserListSubscribers(String str, String str2, long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("lists/subscribers.json?owner_screen_name=");
        sb.append(str);
        sb.append("&slug=");
        sb.append(str2);
        sb.append("&cursor=");
        sb.append(j);
        return objectFactory.createPagableUserList(get(sb.toString()));
    }

    public UserList createUserListSubscription(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("lists/subscribers/create.json");
        return objectFactory.createAUserList(post(sb.toString(), new HttpParameter[]{new HttpParameter("list_id", j)}));
    }

    public UserList createUserListSubscription(long j, String str) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("lists/subscribers/create.json");
        return objectFactory.createAUserList(post(sb.toString(), new HttpParameter[]{new HttpParameter("owner_id", j), new HttpParameter("slug", str)}));
    }

    public UserList createUserListSubscription(String str, String str2) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("lists/subscribers/create.json");
        return objectFactory.createAUserList(post(sb.toString(), new HttpParameter[]{new HttpParameter("owner_screen_name", str), new HttpParameter("slug", str2)}));
    }

    public User showUserListSubscription(long j, long j2) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("lists/subscribers/show.json?list_id=");
        sb.append(j);
        sb.append("&user_id=");
        sb.append(j2);
        return objectFactory.createUser(get(sb.toString()));
    }

    public User showUserListSubscription(long j, String str, long j2) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("lists/subscribers/show.json?owner_id=");
        sb.append(j);
        sb.append("&slug=");
        sb.append(str);
        sb.append("&user_id=");
        sb.append(j2);
        return objectFactory.createUser(get(sb.toString()));
    }

    public User showUserListSubscription(String str, String str2, long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("lists/subscribers/show.json?owner_screen_name=");
        sb.append(str);
        sb.append("&slug=");
        sb.append(str2);
        sb.append("&user_id=");
        sb.append(j);
        return objectFactory.createUser(get(sb.toString()));
    }

    public UserList destroyUserListSubscription(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("lists/subscribers/destroy.json");
        return objectFactory.createAUserList(post(sb.toString(), new HttpParameter[]{new HttpParameter("list_id", j)}));
    }

    public UserList destroyUserListSubscription(long j, String str) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("lists/subscribers/destroy.json");
        return objectFactory.createAUserList(post(sb.toString(), new HttpParameter[]{new HttpParameter("owner_id", j), new HttpParameter("slug", str)}));
    }

    public UserList destroyUserListSubscription(String str, String str2) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("lists/subscribers/destroy.json");
        return objectFactory.createAUserList(post(sb.toString(), new HttpParameter[]{new HttpParameter("owner_screen_name", str), new HttpParameter("slug", str2)}));
    }

    public UserList createUserListMembers(long j, long[] jArr) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("lists/members/create_all.json");
        return objectFactory.createAUserList(post(sb.toString(), new HttpParameter[]{new HttpParameter("list_id", j), new HttpParameter("user_id", StringUtil.join(jArr))}));
    }

    public UserList createUserListMembers(long j, String str, long[] jArr) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("lists/members/create_all.json");
        return objectFactory.createAUserList(post(sb.toString(), new HttpParameter[]{new HttpParameter("owner_id", j), new HttpParameter("slug", str), new HttpParameter("user_id", StringUtil.join(jArr))}));
    }

    public UserList createUserListMembers(String str, String str2, long[] jArr) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("lists/members/create_all.json");
        return objectFactory.createAUserList(post(sb.toString(), new HttpParameter[]{new HttpParameter("owner_screen_name", str), new HttpParameter("slug", str2), new HttpParameter("user_id", StringUtil.join(jArr))}));
    }

    public UserList createUserListMembers(long j, String[] strArr) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("lists/members/create_all.json");
        return objectFactory.createAUserList(post(sb.toString(), new HttpParameter[]{new HttpParameter("list_id", j), new HttpParameter("screen_name", StringUtil.join(strArr))}));
    }

    public UserList createUserListMembers(long j, String str, String[] strArr) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("lists/members/create_all.json");
        return objectFactory.createAUserList(post(sb.toString(), new HttpParameter[]{new HttpParameter("owner_id", j), new HttpParameter("slug", str), new HttpParameter("screen_name", StringUtil.join(strArr))}));
    }

    public UserList createUserListMembers(String str, String str2, String[] strArr) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("lists/members/create_all.json");
        return objectFactory.createAUserList(post(sb.toString(), new HttpParameter[]{new HttpParameter("owner_screen_name", str), new HttpParameter("slug", str2), new HttpParameter("screen_name", StringUtil.join(strArr))}));
    }

    public User showUserListMembership(long j, long j2) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("lists/members/show.json?list_id=");
        sb.append(j);
        sb.append("&user_id=");
        sb.append(j2);
        return objectFactory.createUser(get(sb.toString()));
    }

    public User showUserListMembership(long j, String str, long j2) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("lists/members/show.json?owner_id=");
        sb.append(j);
        sb.append("&slug=");
        sb.append(str);
        sb.append("&user_id=");
        sb.append(j2);
        return objectFactory.createUser(get(sb.toString()));
    }

    public User showUserListMembership(String str, String str2, long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("lists/members/show.json?owner_screen_name=");
        sb.append(str);
        sb.append("&slug=");
        sb.append(str2);
        sb.append("&user_id=");
        sb.append(j);
        return objectFactory.createUser(get(sb.toString()));
    }

    public PagableResponseList<User> getUserListMembers(long j, long j2) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("lists/members.json?list_id=");
        sb.append(j);
        sb.append("&cursor=");
        sb.append(j2);
        return objectFactory.createPagableUserList(get(sb.toString()));
    }

    public PagableResponseList<User> getUserListMembers(long j, String str, long j2) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("lists/members.json?owner_id=");
        sb.append(j);
        sb.append("&slug=");
        sb.append(str);
        sb.append("&cursor=");
        sb.append(j2);
        return objectFactory.createPagableUserList(get(sb.toString()));
    }

    public PagableResponseList<User> getUserListMembers(String str, String str2, long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("lists/members.json?owner_screen_name=");
        sb.append(str);
        sb.append("&slug=");
        sb.append(str2);
        sb.append("&cursor=");
        sb.append(j);
        return objectFactory.createPagableUserList(get(sb.toString()));
    }

    public UserList createUserListMember(long j, long j2) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("lists/members/create.json");
        return objectFactory.createAUserList(post(sb.toString(), new HttpParameter[]{new HttpParameter("user_id", j2), new HttpParameter("list_id", j)}));
    }

    public UserList createUserListMember(long j, String str, long j2) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("lists/members/create.json");
        return objectFactory.createAUserList(post(sb.toString(), new HttpParameter[]{new HttpParameter("user_id", j2), new HttpParameter("owner_id", j), new HttpParameter("slug", str)}));
    }

    public UserList createUserListMember(String str, String str2, long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("lists/members/create.json");
        return objectFactory.createAUserList(post(sb.toString(), new HttpParameter[]{new HttpParameter("user_id", j), new HttpParameter("owner_screen_name", str), new HttpParameter("slug", str2)}));
    }

    public UserList destroyUserList(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("lists/destroy.json");
        return objectFactory.createAUserList(post(sb.toString(), new HttpParameter[]{new HttpParameter("list_id", j)}));
    }

    public UserList destroyUserList(long j, String str) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("lists/destroy.json");
        return objectFactory.createAUserList(post(sb.toString(), new HttpParameter[]{new HttpParameter("owner_id", j), new HttpParameter("slug", str)}));
    }

    public UserList destroyUserList(String str, String str2) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("lists/destroy.json");
        return objectFactory.createAUserList(post(sb.toString(), new HttpParameter[]{new HttpParameter("owner_screen_name", str), new HttpParameter("slug", str2)}));
    }

    public UserList updateUserList(long j, String str, boolean z, String str2) throws TwitterException {
        return updateUserList(str, z, str2, new HttpParameter("list_id", j));
    }

    public UserList updateUserList(long j, String str, String str2, boolean z, String str3) throws TwitterException {
        return updateUserList(str2, z, str3, new HttpParameter("owner_id", j), new HttpParameter("slug", str));
    }

    public UserList updateUserList(String str, String str2, String str3, boolean z, String str4) throws TwitterException {
        return updateUserList(str3, z, str4, new HttpParameter("owner_screen_name", str), new HttpParameter("slug", str2));
    }

    private UserList updateUserList(String str, boolean z, String str2, HttpParameter... httpParameterArr) throws TwitterException {
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, httpParameterArr);
        if (str != null) {
            arrayList.add(new HttpParameter("name", str));
        }
        arrayList.add(new HttpParameter("mode", z ? "public" : "private"));
        if (str2 != null) {
            arrayList.add(new HttpParameter("description", str2));
        }
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("lists/update.json");
        return objectFactory.createAUserList(post(sb.toString(), (HttpParameter[]) arrayList.toArray(new HttpParameter[arrayList.size()])));
    }

    public UserList createUserList(String str, boolean z, String str2) throws TwitterException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HttpParameter("name", str));
        arrayList.add(new HttpParameter("mode", z ? "public" : "private"));
        if (str2 != null) {
            arrayList.add(new HttpParameter("description", str2));
        }
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("lists/create.json");
        return objectFactory.createAUserList(post(sb.toString(), (HttpParameter[]) arrayList.toArray(new HttpParameter[arrayList.size()])));
    }

    public UserList showUserList(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("lists/show.json?list_id=");
        sb.append(j);
        return objectFactory.createAUserList(get(sb.toString()));
    }

    public UserList showUserList(long j, String str) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("lists/show.json?owner_id=");
        sb.append(j);
        sb.append("&slug=");
        sb.append(str);
        return objectFactory.createAUserList(get(sb.toString()));
    }

    public UserList showUserList(String str, String str2) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("lists/show.json?owner_screen_name=");
        sb.append(str);
        sb.append("&slug=");
        sb.append(str2);
        return objectFactory.createAUserList(get(sb.toString()));
    }

    public PagableResponseList<UserList> getUserListSubscriptions(String str, long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("lists/subscriptions.json?screen_name=");
        sb.append(str);
        sb.append("&cursor=");
        sb.append(j);
        return objectFactory.createPagableUserListList(get(sb.toString()));
    }

    public PagableResponseList<UserList> getUserListsOwnerships(String str, int i, long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("lists/ownerships.json");
        return objectFactory.createPagableUserListList(get(sb.toString(), new HttpParameter[]{new HttpParameter("screen_name", str), new HttpParameter("count", i), new HttpParameter("cursor", j)}));
    }

    public PagableResponseList<UserList> getUserListsOwnerships(long j, int i, long j2) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("lists/ownerships.json");
        return objectFactory.createPagableUserListList(get(sb.toString(), new HttpParameter[]{new HttpParameter("user_id", j), new HttpParameter("count", i), new HttpParameter("cursor", j2)}));
    }

    public ResponseList<SavedSearch> getSavedSearches() throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("saved_searches/list.json");
        return objectFactory.createSavedSearchList(get(sb.toString()));
    }

    public SavedSearch showSavedSearch(int i) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("saved_searches/show/");
        sb.append(i);
        sb.append(".json");
        return objectFactory.createSavedSearch(get(sb.toString()));
    }

    public SavedSearch createSavedSearch(String str) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("saved_searches/create.json");
        return objectFactory.createSavedSearch(post(sb.toString(), new HttpParameter[]{new HttpParameter(SearchIntents.EXTRA_QUERY, str)}));
    }

    public SavedSearch destroySavedSearch(int i) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("saved_searches/destroy/");
        sb.append(i);
        sb.append(".json");
        return objectFactory.createSavedSearch(post(sb.toString()));
    }

    public Place getGeoDetails(String str) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("geo/id/");
        sb.append(str);
        sb.append(".json");
        return objectFactory.createPlace(get(sb.toString()));
    }

    public ResponseList<Place> reverseGeoCode(GeoQuery geoQuery) throws TwitterException {
        try {
            ObjectFactory objectFactory = this.factory;
            StringBuilder sb = new StringBuilder();
            sb.append(this.conf.getRestBaseURL());
            sb.append("geo/reverse_geocode.json");
            return objectFactory.createPlaceList(get(sb.toString(), geoQuery.asHttpParameterArray()));
        } catch (TwitterException e) {
            if (e.getStatusCode() == 404) {
                return this.factory.createEmptyResponseList();
            }
            throw e;
        }
    }

    public ResponseList<Place> searchPlaces(GeoQuery geoQuery) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("geo/search.json");
        return objectFactory.createPlaceList(get(sb.toString(), geoQuery.asHttpParameterArray()));
    }

    public ResponseList<Place> getSimilarPlaces(GeoLocation geoLocation, String str, String str2, String str3) throws TwitterException {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(new HttpParameter("lat", geoLocation.getLatitude()));
        arrayList.add(new HttpParameter("long", geoLocation.getLongitude()));
        arrayList.add(new HttpParameter("name", str));
        if (str2 != null) {
            arrayList.add(new HttpParameter("contained_within", str2));
        }
        if (str3 != null) {
            arrayList.add(new HttpParameter("attribute:street_address", str3));
        }
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("geo/similar_places.json");
        return objectFactory.createPlaceList(get(sb.toString(), (HttpParameter[]) arrayList.toArray(new HttpParameter[arrayList.size()])));
    }

    public Trends getPlaceTrends(int i) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("trends/place.json?id=");
        sb.append(i);
        return objectFactory.createTrends(get(sb.toString()));
    }

    public ResponseList<Location> getAvailableTrends() throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("trends/available.json");
        return objectFactory.createLocationList(get(sb.toString()));
    }

    public ResponseList<Location> getClosestTrends(GeoLocation geoLocation) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("trends/closest.json");
        return objectFactory.createLocationList(get(sb.toString(), new HttpParameter[]{new HttpParameter("lat", geoLocation.getLatitude()), new HttpParameter("long", geoLocation.getLongitude())}));
    }

    public User reportSpam(long j) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("users/report_spam.json?user_id=");
        sb.append(j);
        return objectFactory.createUser(post(sb.toString()));
    }

    public User reportSpam(String str) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("users/report_spam.json?screen_name=");
        sb.append(str);
        return objectFactory.createUser(post(sb.toString()));
    }

    public TwitterAPIConfiguration getAPIConfiguration() throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("help/configuration.json");
        return objectFactory.createTwitterAPIConfiguration(get(sb.toString()));
    }

    public ResponseList<Language> getLanguages() throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("help/languages.json");
        return objectFactory.createLanguageList(get(sb.toString()));
    }

    public String getPrivacyPolicy() throws TwitterException {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(this.conf.getRestBaseURL());
            sb.append("help/privacy.json");
            return get(sb.toString()).asJSONObject().getString("privacy");
        } catch (JSONException e) {
            throw new TwitterException((Exception) e);
        }
    }

    public String getTermsOfService() throws TwitterException {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(this.conf.getRestBaseURL());
            sb.append("help/tos.json");
            return get(sb.toString()).asJSONObject().getString("tos");
        } catch (JSONException e) {
            throw new TwitterException((Exception) e);
        }
    }

    public Map<String, RateLimitStatus> getRateLimitStatus() throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("application/rate_limit_status.json");
        return objectFactory.createRateLimitStatuses(get(sb.toString()));
    }

    public Map<String, RateLimitStatus> getRateLimitStatus(String... strArr) throws TwitterException {
        ObjectFactory objectFactory = this.factory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.conf.getRestBaseURL());
        sb.append("application/rate_limit_status.json?resources=");
        sb.append(StringUtil.join(strArr));
        return objectFactory.createRateLimitStatuses(get(sb.toString()));
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [twitter4j.HttpResponse, twitter4j.HttpParameter[]] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r1v0, types: [twitter4j.HttpResponse, twitter4j.HttpParameter[]]
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY]]
      uses: [twitter4j.HttpResponse, twitter4j.HttpParameter[]]
      mth insns count: 47
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private twitter4j.HttpResponse get(java.lang.String r7) throws twitter4j.TwitterException {
        /*
            r6 = this;
            r6.ensureAuthorizationEnabled()
            java.lang.String r0 = r6.IMPLICIT_PARAMS_STR
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x0040
            java.lang.String r0 = "?"
            boolean r0 = r7.contains(r0)
            if (r0 == 0) goto L_0x002a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r7)
            java.lang.String r7 = "&"
            r0.append(r7)
            java.lang.String r7 = r6.IMPLICIT_PARAMS_STR
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            goto L_0x0040
        L_0x002a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r7)
            java.lang.String r7 = "?"
            r0.append(r7)
            java.lang.String r7 = r6.IMPLICIT_PARAMS_STR
            r0.append(r7)
            java.lang.String r7 = r0.toString()
        L_0x0040:
            twitter4j.conf.Configuration r0 = r6.conf
            boolean r0 = r0.isMBeanEnabled()
            r1 = 0
            if (r0 != 0) goto L_0x0052
            twitter4j.HttpClient r0 = r6.http
            twitter4j.auth.Authorization r2 = r6.auth
            twitter4j.HttpResponse r7 = r0.get(r7, r1, r2, r6)
            return r7
        L_0x0052:
            long r2 = java.lang.System.currentTimeMillis()
            twitter4j.HttpClient r0 = r6.http     // Catch:{ all -> 0x006f }
            twitter4j.auth.Authorization r4 = r6.auth     // Catch:{ all -> 0x006f }
            twitter4j.HttpResponse r0 = r0.get(r7, r1, r4, r6)     // Catch:{ all -> 0x006f }
            long r4 = java.lang.System.currentTimeMillis()
            long r4 = r4 - r2
            twitter4j.TwitterAPIMonitor r1 = twitter4j.TwitterAPIMonitor.getInstance()
            boolean r2 = r6.isOk(r0)
            r1.methodCalled(r7, r4, r2)
            return r0
        L_0x006f:
            r0 = move-exception
            long r4 = java.lang.System.currentTimeMillis()
            long r4 = r4 - r2
            twitter4j.TwitterAPIMonitor r2 = twitter4j.TwitterAPIMonitor.getInstance()
            boolean r1 = r6.isOk(r1)
            r2.methodCalled(r7, r4, r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: twitter4j.TwitterImpl.get(java.lang.String):twitter4j.HttpResponse");
    }

    private HttpResponse get(String str, HttpParameter[] httpParameterArr) throws TwitterException {
        ensureAuthorizationEnabled();
        if (!this.conf.isMBeanEnabled()) {
            return this.http.get(str, mergeImplicitParams(httpParameterArr), this.auth, this);
        }
        HttpResponse httpResponse = null;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            httpResponse = this.http.get(str, mergeImplicitParams(httpParameterArr), this.auth, this);
            return httpResponse;
        } finally {
            TwitterAPIMonitor.getInstance().methodCalled(str, System.currentTimeMillis() - currentTimeMillis, isOk(httpResponse));
        }
    }

    private HttpResponse post(String str) throws TwitterException {
        ensureAuthorizationEnabled();
        if (!this.conf.isMBeanEnabled()) {
            return this.http.post(str, this.IMPLICIT_PARAMS, this.auth, this);
        }
        HttpResponse httpResponse = null;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            httpResponse = this.http.post(str, this.IMPLICIT_PARAMS, this.auth, this);
            return httpResponse;
        } finally {
            TwitterAPIMonitor.getInstance().methodCalled(str, System.currentTimeMillis() - currentTimeMillis, isOk(httpResponse));
        }
    }

    private HttpResponse post(String str, HttpParameter[] httpParameterArr) throws TwitterException {
        ensureAuthorizationEnabled();
        if (!this.conf.isMBeanEnabled()) {
            return this.http.post(str, mergeImplicitParams(httpParameterArr), this.auth, this);
        }
        HttpResponse httpResponse = null;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            httpResponse = this.http.post(str, mergeImplicitParams(httpParameterArr), this.auth, this);
            return httpResponse;
        } finally {
            TwitterAPIMonitor.getInstance().methodCalled(str, System.currentTimeMillis() - currentTimeMillis, isOk(httpResponse));
        }
    }

    private HttpParameter[] mergeParameters(HttpParameter[] httpParameterArr, HttpParameter[] httpParameterArr2) {
        if (httpParameterArr != null && httpParameterArr2 != null) {
            HttpParameter[] httpParameterArr3 = new HttpParameter[(httpParameterArr.length + httpParameterArr2.length)];
            System.arraycopy(httpParameterArr, 0, httpParameterArr3, 0, httpParameterArr.length);
            System.arraycopy(httpParameterArr2, 0, httpParameterArr3, httpParameterArr.length, httpParameterArr2.length);
            return httpParameterArr3;
        } else if (httpParameterArr == null && httpParameterArr2 == null) {
            return new HttpParameter[0];
        } else {
            return httpParameterArr != null ? httpParameterArr : httpParameterArr2;
        }
    }

    private HttpParameter[] mergeParameters(HttpParameter[] httpParameterArr, HttpParameter httpParameter) {
        if (httpParameterArr != null && httpParameter != null) {
            HttpParameter[] httpParameterArr2 = new HttpParameter[(httpParameterArr.length + 1)];
            System.arraycopy(httpParameterArr, 0, httpParameterArr2, 0, httpParameterArr.length);
            httpParameterArr2[httpParameterArr2.length - 1] = httpParameter;
            return httpParameterArr2;
        } else if (httpParameterArr == null && httpParameter == null) {
            return new HttpParameter[0];
        } else {
            if (httpParameterArr != null) {
                return httpParameterArr;
            }
            return new HttpParameter[]{httpParameter};
        }
    }

    private HttpParameter[] mergeImplicitParams(HttpParameter[] httpParameterArr) {
        return mergeParameters(httpParameterArr, this.IMPLICIT_PARAMS);
    }

    private boolean isOk(HttpResponse httpResponse) {
        return httpResponse != null && httpResponse.getStatusCode() < 300;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TwitterImpl{INCLUDE_MY_RETWEET=");
        sb.append(this.INCLUDE_MY_RETWEET);
        sb.append('}');
        return sb.toString();
    }
}
