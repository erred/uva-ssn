package twitter4j;

import androidx.customview.p073b.C1024a;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import java.io.Serializable;

abstract class EntityIndex implements Serializable, Comparable<EntityIndex> {
    private static final long serialVersionUID = 3757474748266170719L;
    private int end = -1;
    private int start = -1;

    EntityIndex() {
    }

    public int compareTo(EntityIndex entityIndex) {
        long j = (long) (this.start - entityIndex.start);
        if (j < -2147483648L) {
            return C1024a.INVALID_ID;
        }
        return j > 2147483647L ? BaseClientBuilder.API_PRIORITY_OTHER : (int) j;
    }

    /* access modifiers changed from: 0000 */
    public void setStart(int i) {
        this.start = i;
    }

    /* access modifiers changed from: 0000 */
    public void setEnd(int i) {
        this.end = i;
    }

    /* access modifiers changed from: 0000 */
    public int getStart() {
        return this.start;
    }

    /* access modifiers changed from: 0000 */
    public int getEnd() {
        return this.end;
    }
}
