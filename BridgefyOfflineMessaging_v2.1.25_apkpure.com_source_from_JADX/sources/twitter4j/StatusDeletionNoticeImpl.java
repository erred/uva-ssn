package twitter4j;

import androidx.customview.p073b.C1024a;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import java.io.Serializable;

class StatusDeletionNoticeImpl implements Serializable, StatusDeletionNotice {
    private static final long serialVersionUID = 9144204870473786368L;
    private final long statusId;
    private final long userId;

    StatusDeletionNoticeImpl(JSONObject jSONObject) {
        this.statusId = ParseUtil.getLong("id", jSONObject);
        this.userId = ParseUtil.getLong("user_id", jSONObject);
    }

    public long getStatusId() {
        return this.statusId;
    }

    public long getUserId() {
        return this.userId;
    }

    public int compareTo(StatusDeletionNotice statusDeletionNotice) {
        long statusId2 = this.statusId - statusDeletionNotice.getStatusId();
        if (statusId2 < -2147483648L) {
            return C1024a.INVALID_ID;
        }
        return statusId2 > 2147483647L ? BaseClientBuilder.API_PRIORITY_OTHER : (int) statusId2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        StatusDeletionNoticeImpl statusDeletionNoticeImpl = (StatusDeletionNoticeImpl) obj;
        return this.statusId == statusDeletionNoticeImpl.statusId && this.userId == statusDeletionNoticeImpl.userId;
    }

    public int hashCode() {
        return (((int) (this.statusId ^ (this.statusId >>> 32))) * 31) + ((int) (this.userId ^ (this.userId >>> 32)));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("StatusDeletionNoticeImpl{statusId=");
        sb.append(this.statusId);
        sb.append(", userId=");
        sb.append(this.userId);
        sb.append('}');
        return sb.toString();
    }
}
