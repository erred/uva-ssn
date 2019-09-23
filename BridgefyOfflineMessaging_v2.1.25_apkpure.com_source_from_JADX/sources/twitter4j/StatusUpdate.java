package twitter4j;

import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import p140me.bridgefy.ormlite.entities.MessageDTO;

public final class StatusUpdate implements Serializable {
    private static final long serialVersionUID = 7422094739799350035L;
    private boolean displayCoordinates = true;
    private long inReplyToStatusId = -1;
    private GeoLocation location = null;
    private transient InputStream mediaBody;
    private File mediaFile;
    private long[] mediaIds;
    private String mediaName;
    private String placeId = null;
    private boolean possiblySensitive;
    private final String status;

    public StatusUpdate(String str) {
        this.status = str;
    }

    public String getStatus() {
        return this.status;
    }

    public long getInReplyToStatusId() {
        return this.inReplyToStatusId;
    }

    public void setInReplyToStatusId(long j) {
        this.inReplyToStatusId = j;
    }

    public StatusUpdate inReplyToStatusId(long j) {
        setInReplyToStatusId(j);
        return this;
    }

    public GeoLocation getLocation() {
        return this.location;
    }

    public void setLocation(GeoLocation geoLocation) {
        this.location = geoLocation;
    }

    public StatusUpdate location(GeoLocation geoLocation) {
        setLocation(geoLocation);
        return this;
    }

    public String getPlaceId() {
        return this.placeId;
    }

    public void setPlaceId(String str) {
        this.placeId = str;
    }

    public StatusUpdate placeId(String str) {
        setPlaceId(str);
        return this;
    }

    public boolean isDisplayCoordinates() {
        return this.displayCoordinates;
    }

    public void setDisplayCoordinates(boolean z) {
        this.displayCoordinates = z;
    }

    public StatusUpdate displayCoordinates(boolean z) {
        setDisplayCoordinates(z);
        return this;
    }

    public void setMedia(File file) {
        this.mediaFile = file;
    }

    public StatusUpdate media(File file) {
        setMedia(file);
        return this;
    }

    public void setMedia(String str, InputStream inputStream) {
        this.mediaName = str;
        this.mediaBody = inputStream;
    }

    public void setMediaIds(long[] jArr) {
        this.mediaIds = jArr;
    }

    /* access modifiers changed from: 0000 */
    public boolean isForUpdateWithMedia() {
        return (this.mediaFile == null && this.mediaName == null) ? false : true;
    }

    public StatusUpdate media(String str, InputStream inputStream) {
        setMedia(str, inputStream);
        return this;
    }

    public void setPossiblySensitive(boolean z) {
        this.possiblySensitive = z;
    }

    public StatusUpdate possiblySensitive(boolean z) {
        setPossiblySensitive(z);
        return this;
    }

    public boolean isPossiblySensitive() {
        return this.possiblySensitive;
    }

    /* access modifiers changed from: 0000 */
    public HttpParameter[] asHttpParameterArray() {
        ArrayList arrayList = new ArrayList();
        appendParameter(MessageDTO.STATUS, this.status, (List<HttpParameter>) arrayList);
        if (-1 != this.inReplyToStatusId) {
            appendParameter("in_reply_to_status_id", this.inReplyToStatusId, (List<HttpParameter>) arrayList);
        }
        if (this.location != null) {
            appendParameter("lat", this.location.getLatitude(), (List<HttpParameter>) arrayList);
            appendParameter("long", this.location.getLongitude(), (List<HttpParameter>) arrayList);
        }
        appendParameter("place_id", this.placeId, (List<HttpParameter>) arrayList);
        if (!this.displayCoordinates) {
            appendParameter("display_coordinates", "false", (List<HttpParameter>) arrayList);
        }
        if (this.mediaFile != null) {
            arrayList.add(new HttpParameter("media[]", this.mediaFile));
            arrayList.add(new HttpParameter("possibly_sensitive", this.possiblySensitive));
        } else if (this.mediaName != null && this.mediaBody != null) {
            arrayList.add(new HttpParameter("media[]", this.mediaName, this.mediaBody));
            arrayList.add(new HttpParameter("possibly_sensitive", this.possiblySensitive));
        } else if (this.mediaIds != null && this.mediaIds.length >= 1) {
            arrayList.add(new HttpParameter("media_ids", StringUtil.join(this.mediaIds)));
        }
        return (HttpParameter[]) arrayList.toArray(new HttpParameter[arrayList.size()]);
    }

    private void appendParameter(String str, String str2, List<HttpParameter> list) {
        if (str2 != null) {
            list.add(new HttpParameter(str, str2));
        }
    }

    private void appendParameter(String str, double d, List<HttpParameter> list) {
        list.add(new HttpParameter(str, String.valueOf(d)));
    }

    private void appendParameter(String str, long j, List<HttpParameter> list) {
        list.add(new HttpParameter(str, String.valueOf(j)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        StatusUpdate statusUpdate = (StatusUpdate) obj;
        if (this.displayCoordinates != statusUpdate.displayCoordinates || this.inReplyToStatusId != statusUpdate.inReplyToStatusId || this.possiblySensitive != statusUpdate.possiblySensitive) {
            return false;
        }
        if (this.location == null ? statusUpdate.location != null : !this.location.equals(statusUpdate.location)) {
            return false;
        }
        if (this.mediaBody == null ? statusUpdate.mediaBody != null : !this.mediaBody.equals(statusUpdate.mediaBody)) {
            return false;
        }
        if (this.mediaFile == null ? statusUpdate.mediaFile != null : !this.mediaFile.equals(statusUpdate.mediaFile)) {
            return false;
        }
        if (this.mediaName == null ? statusUpdate.mediaName != null : !this.mediaName.equals(statusUpdate.mediaName)) {
            return false;
        }
        if (this.mediaIds == null ? statusUpdate.mediaIds != null : !Arrays.equals(this.mediaIds, statusUpdate.mediaIds)) {
            return false;
        }
        if (this.placeId == null ? statusUpdate.placeId == null : this.placeId.equals(statusUpdate.placeId)) {
            return this.status == null ? statusUpdate.status == null : this.status.equals(statusUpdate.status);
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (((((((((((((((((this.status != null ? this.status.hashCode() : 0) * 31) + ((int) (this.inReplyToStatusId ^ (this.inReplyToStatusId >>> 32)))) * 31) + (this.location != null ? this.location.hashCode() : 0)) * 31) + (this.placeId != null ? this.placeId.hashCode() : 0)) * 31) + (this.displayCoordinates ? 1 : 0)) * 31) + (this.possiblySensitive ? 1 : 0)) * 31) + (this.mediaName != null ? this.mediaName.hashCode() : 0)) * 31) + (this.mediaBody != null ? this.mediaBody.hashCode() : 0)) * 31) + (this.mediaFile != null ? this.mediaFile.hashCode() : 0)) * 31;
        if (this.mediaIds != null) {
            i = StringUtil.join(this.mediaIds).hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("StatusUpdate{status='");
        sb.append(this.status);
        sb.append('\'');
        sb.append(", inReplyToStatusId=");
        sb.append(this.inReplyToStatusId);
        sb.append(", location=");
        sb.append(this.location);
        sb.append(", placeId='");
        sb.append(this.placeId);
        sb.append('\'');
        sb.append(", displayCoordinates=");
        sb.append(this.displayCoordinates);
        sb.append(", possiblySensitive=");
        sb.append(this.possiblySensitive);
        sb.append(", mediaName='");
        sb.append(this.mediaName);
        sb.append('\'');
        sb.append(", mediaBody=");
        sb.append(this.mediaBody);
        sb.append(", mediaFile=");
        sb.append(this.mediaFile);
        sb.append(", mediaIds=");
        sb.append(this.mediaIds);
        sb.append('}');
        return sb.toString();
    }
}
