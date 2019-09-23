package twitter4j;

import java.util.Arrays;
import twitter4j.conf.Configuration;

final class IDsJSONImpl extends TwitterResponseImpl implements IDs {
    private static final long serialVersionUID = 6999637496007165672L;
    private long[] ids;
    private long nextCursor = -1;
    private long previousCursor = -1;

    IDsJSONImpl(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        super(httpResponse);
        String asString = httpResponse.asString();
        init(asString);
        if (configuration.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
            TwitterObjectFactory.registerJSONObject(this, asString);
        }
    }

    IDsJSONImpl(String str) throws TwitterException {
        init(str);
    }

    private void init(String str) throws TwitterException {
        JSONArray jSONArray;
        JSONObject jSONObject;
        try {
            int i = 0;
            if (str.startsWith("{")) {
                jSONObject = new JSONObject(str);
                JSONArray jSONArray2 = jSONObject.getJSONArray("ids");
                this.ids = new long[jSONArray2.length()];
                while (i < jSONArray2.length()) {
                    this.ids[i] = Long.parseLong(jSONArray2.getString(i));
                    i++;
                }
                this.previousCursor = ParseUtil.getLong("previous_cursor", jSONObject);
                this.nextCursor = ParseUtil.getLong("next_cursor", jSONObject);
                return;
            }
            jSONArray = new JSONArray(str);
            this.ids = new long[jSONArray.length()];
            while (i < jSONArray.length()) {
                this.ids[i] = Long.parseLong(jSONArray.getString(i));
                i++;
            }
        } catch (NumberFormatException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Twitter API returned malformed response: ");
            sb.append(jSONArray);
            throw new TwitterException(sb.toString(), (Throwable) e);
        } catch (NumberFormatException e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Twitter API returned malformed response: ");
            sb2.append(jSONObject);
            throw new TwitterException(sb2.toString(), (Throwable) e2);
        } catch (JSONException e3) {
            throw new TwitterException((Exception) e3);
        }
    }

    public long[] getIDs() {
        return this.ids;
    }

    public boolean hasPrevious() {
        return 0 != this.previousCursor;
    }

    public long getPreviousCursor() {
        return this.previousCursor;
    }

    public boolean hasNext() {
        return 0 != this.nextCursor;
    }

    public long getNextCursor() {
        return this.nextCursor;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IDs)) {
            return false;
        }
        return Arrays.equals(this.ids, ((IDs) obj).getIDs());
    }

    public int hashCode() {
        if (this.ids != null) {
            return Arrays.hashCode(this.ids);
        }
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("IDsJSONImpl{ids=");
        sb.append(Arrays.toString(this.ids));
        sb.append(", previousCursor=");
        sb.append(this.previousCursor);
        sb.append(", nextCursor=");
        sb.append(this.nextCursor);
        sb.append('}');
        return sb.toString();
    }
}
