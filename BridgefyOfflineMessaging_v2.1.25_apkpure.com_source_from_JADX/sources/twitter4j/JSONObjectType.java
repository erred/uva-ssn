package twitter4j;

public final class JSONObjectType {
    private static final Logger logger = Logger.getLogger(JSONObjectType.class);

    public enum Type {
        SENDER,
        STATUS,
        DIRECT_MESSAGE,
        DELETE,
        LIMIT,
        STALL_WARNING,
        SCRUB_GEO,
        FRIENDS,
        FAVORITE,
        UNFAVORITE,
        FOLLOW,
        UNFOLLOW,
        USER_LIST_MEMBER_ADDED,
        USER_LIST_MEMBER_DELETED,
        USER_LIST_SUBSCRIBED,
        USER_LIST_UNSUBSCRIBED,
        USER_LIST_CREATED,
        USER_LIST_UPDATED,
        USER_LIST_DESTROYED,
        USER_UPDATE,
        BLOCK,
        UNBLOCK,
        DISCONNECTION,
        UNKNOWN
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:94|95) */
    /* JADX WARNING: Code restructure failed: missing block: B:95:?, code lost:
        logger.warn("Failed to get event element: ", r3.toString(2));
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:94:0x0108 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static twitter4j.JSONObjectType.Type determine(twitter4j.JSONObject r3) {
        /*
            java.lang.String r0 = "sender"
            boolean r0 = r3.isNull(r0)
            if (r0 != 0) goto L_0x000b
            twitter4j.JSONObjectType$Type r3 = twitter4j.JSONObjectType.Type.SENDER
            return r3
        L_0x000b:
            java.lang.String r0 = "text"
            boolean r0 = r3.isNull(r0)
            if (r0 != 0) goto L_0x0016
            twitter4j.JSONObjectType$Type r3 = twitter4j.JSONObjectType.Type.STATUS
            return r3
        L_0x0016:
            java.lang.String r0 = "direct_message"
            boolean r0 = r3.isNull(r0)
            if (r0 != 0) goto L_0x0021
            twitter4j.JSONObjectType$Type r3 = twitter4j.JSONObjectType.Type.DIRECT_MESSAGE
            return r3
        L_0x0021:
            java.lang.String r0 = "delete"
            boolean r0 = r3.isNull(r0)
            if (r0 != 0) goto L_0x002c
            twitter4j.JSONObjectType$Type r3 = twitter4j.JSONObjectType.Type.DELETE
            return r3
        L_0x002c:
            java.lang.String r0 = "limit"
            boolean r0 = r3.isNull(r0)
            if (r0 != 0) goto L_0x0037
            twitter4j.JSONObjectType$Type r3 = twitter4j.JSONObjectType.Type.LIMIT
            return r3
        L_0x0037:
            java.lang.String r0 = "warning"
            boolean r0 = r3.isNull(r0)
            if (r0 != 0) goto L_0x0042
            twitter4j.JSONObjectType$Type r3 = twitter4j.JSONObjectType.Type.STALL_WARNING
            return r3
        L_0x0042:
            java.lang.String r0 = "scrub_geo"
            boolean r0 = r3.isNull(r0)
            if (r0 != 0) goto L_0x004d
            twitter4j.JSONObjectType$Type r3 = twitter4j.JSONObjectType.Type.SCRUB_GEO
            return r3
        L_0x004d:
            java.lang.String r0 = "friends"
            boolean r0 = r3.isNull(r0)
            if (r0 != 0) goto L_0x0058
            twitter4j.JSONObjectType$Type r3 = twitter4j.JSONObjectType.Type.FRIENDS
            return r3
        L_0x0058:
            java.lang.String r0 = "event"
            boolean r0 = r3.isNull(r0)
            if (r0 != 0) goto L_0x0115
            java.lang.String r0 = "event"
            java.lang.String r0 = r3.getString(r0)     // Catch:{ JSONException -> 0x0108 }
            java.lang.String r1 = "favorite"
            boolean r1 = r1.equals(r0)     // Catch:{ JSONException -> 0x0108 }
            if (r1 == 0) goto L_0x0071
            twitter4j.JSONObjectType$Type r0 = twitter4j.JSONObjectType.Type.FAVORITE     // Catch:{ JSONException -> 0x0108 }
            return r0
        L_0x0071:
            java.lang.String r1 = "unfavorite"
            boolean r1 = r1.equals(r0)     // Catch:{ JSONException -> 0x0108 }
            if (r1 == 0) goto L_0x007c
            twitter4j.JSONObjectType$Type r0 = twitter4j.JSONObjectType.Type.UNFAVORITE     // Catch:{ JSONException -> 0x0108 }
            return r0
        L_0x007c:
            java.lang.String r1 = "follow"
            boolean r1 = r1.equals(r0)     // Catch:{ JSONException -> 0x0108 }
            if (r1 == 0) goto L_0x0087
            twitter4j.JSONObjectType$Type r0 = twitter4j.JSONObjectType.Type.FOLLOW     // Catch:{ JSONException -> 0x0108 }
            return r0
        L_0x0087:
            java.lang.String r1 = "unfollow"
            boolean r1 = r1.equals(r0)     // Catch:{ JSONException -> 0x0108 }
            if (r1 == 0) goto L_0x0092
            twitter4j.JSONObjectType$Type r0 = twitter4j.JSONObjectType.Type.UNFOLLOW     // Catch:{ JSONException -> 0x0108 }
            return r0
        L_0x0092:
            java.lang.String r1 = "list"
            boolean r1 = r0.startsWith(r1)     // Catch:{ JSONException -> 0x0108 }
            if (r1 == 0) goto L_0x00e7
            java.lang.String r1 = "list_member_added"
            boolean r1 = r1.equals(r0)     // Catch:{ JSONException -> 0x0108 }
            if (r1 == 0) goto L_0x00a5
            twitter4j.JSONObjectType$Type r0 = twitter4j.JSONObjectType.Type.USER_LIST_MEMBER_ADDED     // Catch:{ JSONException -> 0x0108 }
            return r0
        L_0x00a5:
            java.lang.String r1 = "list_member_removed"
            boolean r1 = r1.equals(r0)     // Catch:{ JSONException -> 0x0108 }
            if (r1 == 0) goto L_0x00b0
            twitter4j.JSONObjectType$Type r0 = twitter4j.JSONObjectType.Type.USER_LIST_MEMBER_DELETED     // Catch:{ JSONException -> 0x0108 }
            return r0
        L_0x00b0:
            java.lang.String r1 = "list_user_subscribed"
            boolean r1 = r1.equals(r0)     // Catch:{ JSONException -> 0x0108 }
            if (r1 == 0) goto L_0x00bb
            twitter4j.JSONObjectType$Type r0 = twitter4j.JSONObjectType.Type.USER_LIST_SUBSCRIBED     // Catch:{ JSONException -> 0x0108 }
            return r0
        L_0x00bb:
            java.lang.String r1 = "list_user_unsubscribed"
            boolean r1 = r1.equals(r0)     // Catch:{ JSONException -> 0x0108 }
            if (r1 == 0) goto L_0x00c6
            twitter4j.JSONObjectType$Type r0 = twitter4j.JSONObjectType.Type.USER_LIST_UNSUBSCRIBED     // Catch:{ JSONException -> 0x0108 }
            return r0
        L_0x00c6:
            java.lang.String r1 = "list_created"
            boolean r1 = r1.equals(r0)     // Catch:{ JSONException -> 0x0108 }
            if (r1 == 0) goto L_0x00d1
            twitter4j.JSONObjectType$Type r0 = twitter4j.JSONObjectType.Type.USER_LIST_CREATED     // Catch:{ JSONException -> 0x0108 }
            return r0
        L_0x00d1:
            java.lang.String r1 = "list_updated"
            boolean r1 = r1.equals(r0)     // Catch:{ JSONException -> 0x0108 }
            if (r1 == 0) goto L_0x00dc
            twitter4j.JSONObjectType$Type r0 = twitter4j.JSONObjectType.Type.USER_LIST_UPDATED     // Catch:{ JSONException -> 0x0108 }
            return r0
        L_0x00dc:
            java.lang.String r1 = "list_destroyed"
            boolean r0 = r1.equals(r0)     // Catch:{ JSONException -> 0x0108 }
            if (r0 == 0) goto L_0x0120
            twitter4j.JSONObjectType$Type r0 = twitter4j.JSONObjectType.Type.USER_LIST_DESTROYED     // Catch:{ JSONException -> 0x0108 }
            return r0
        L_0x00e7:
            java.lang.String r1 = "user_update"
            boolean r1 = r1.equals(r0)     // Catch:{ JSONException -> 0x0108 }
            if (r1 == 0) goto L_0x00f2
            twitter4j.JSONObjectType$Type r0 = twitter4j.JSONObjectType.Type.USER_UPDATE     // Catch:{ JSONException -> 0x0108 }
            return r0
        L_0x00f2:
            java.lang.String r1 = "block"
            boolean r1 = r1.equals(r0)     // Catch:{ JSONException -> 0x0108 }
            if (r1 == 0) goto L_0x00fd
            twitter4j.JSONObjectType$Type r0 = twitter4j.JSONObjectType.Type.BLOCK     // Catch:{ JSONException -> 0x0108 }
            return r0
        L_0x00fd:
            java.lang.String r1 = "unblock"
            boolean r0 = r1.equals(r0)     // Catch:{ JSONException -> 0x0108 }
            if (r0 == 0) goto L_0x0120
            twitter4j.JSONObjectType$Type r0 = twitter4j.JSONObjectType.Type.UNBLOCK     // Catch:{ JSONException -> 0x0108 }
            return r0
        L_0x0108:
            twitter4j.Logger r0 = logger     // Catch:{ JSONException -> 0x0120 }
            java.lang.String r1 = "Failed to get event element: "
            r2 = 2
            java.lang.String r3 = r3.toString(r2)     // Catch:{ JSONException -> 0x0120 }
            r0.warn(r1, r3)     // Catch:{ JSONException -> 0x0120 }
            goto L_0x0120
        L_0x0115:
            java.lang.String r0 = "disconnect"
            boolean r3 = r3.isNull(r0)
            if (r3 != 0) goto L_0x0120
            twitter4j.JSONObjectType$Type r3 = twitter4j.JSONObjectType.Type.DISCONNECTION
            return r3
        L_0x0120:
            twitter4j.JSONObjectType$Type r3 = twitter4j.JSONObjectType.Type.UNKNOWN
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: twitter4j.JSONObjectType.determine(twitter4j.JSONObject):twitter4j.JSONObjectType$Type");
    }
}
