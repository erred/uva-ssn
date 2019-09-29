package twitter4j;

class HashtagEntityJSONImpl extends EntityIndex implements HashtagEntity, SymbolEntity {
    private static final long serialVersionUID = -5317828991902848906L;
    private String text;

    HashtagEntityJSONImpl(JSONObject jSONObject) throws TwitterException {
        init(jSONObject);
    }

    HashtagEntityJSONImpl(int i, int i2, String str) {
        setStart(i);
        setEnd(i2);
        this.text = str;
    }

    HashtagEntityJSONImpl() {
    }

    private void init(JSONObject jSONObject) throws TwitterException {
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("indices");
            setStart(jSONArray.getInt(0));
            setEnd(jSONArray.getInt(1));
            if (!jSONObject.isNull("text")) {
                this.text = jSONObject.getString("text");
            }
        } catch (JSONException e) {
            throw new TwitterException((Exception) e);
        }
    }

    public String getText() {
        return this.text;
    }

    public int getStart() {
        return super.getStart();
    }

    public int getEnd() {
        return super.getEnd();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        HashtagEntityJSONImpl hashtagEntityJSONImpl = (HashtagEntityJSONImpl) obj;
        return this.text == null ? hashtagEntityJSONImpl.text == null : this.text.equals(hashtagEntityJSONImpl.text);
    }

    public int hashCode() {
        if (this.text != null) {
            return this.text.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HashtagEntityJSONImpl{text='");
        sb.append(this.text);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
