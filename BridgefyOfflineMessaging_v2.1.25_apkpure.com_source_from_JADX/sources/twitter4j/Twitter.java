package twitter4j;

import java.io.Serializable;
import twitter4j.api.DirectMessagesResources;
import twitter4j.api.FavoritesResources;
import twitter4j.api.FriendsFollowersResources;
import twitter4j.api.HelpResources;
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
import twitter4j.auth.OAuth2Support;
import twitter4j.auth.OAuthSupport;

public interface Twitter extends Serializable, TwitterBase, DirectMessagesResources, FavoritesResources, FriendsFollowersResources, HelpResources, ListsResources, PlacesGeoResources, SavedSearchesResources, SearchResource, SpamReportingResource, SuggestedUsersResources, TimelinesResources, TrendsResources, TweetsResources, UsersResources, OAuth2Support, OAuthSupport {
    DirectMessagesResources directMessages();

    FavoritesResources favorites();

    FriendsFollowersResources friendsFollowers();

    HelpResources help();

    ListsResources list();

    PlacesGeoResources placesGeo();

    SavedSearchesResources savedSearches();

    SearchResource search();

    SpamReportingResource spamReporting();

    SuggestedUsersResources suggestedUsers();

    TimelinesResources timelines();

    TrendsResources trends();

    TweetsResources tweets();

    UsersResources users();
}
