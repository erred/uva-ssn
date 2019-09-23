package twitter4j;

import com.google.android.gms.common.internal.ImagesContract;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class OEmbedRequest implements Serializable {
    private static final long serialVersionUID = 7454130135274547901L;
    private Align align = Align.NONE;
    private boolean hideMedia = true;
    private boolean hideThread = true;
    private String lang;
    private int maxWidth;
    private boolean omitScript = false;
    private String[] related = new String[0];
    private final long statusId;
    private final String url;

    public enum Align {
        LEFT,
        CENTER,
        RIGHT,
        NONE
    }

    public OEmbedRequest(long j, String str) {
        this.statusId = j;
        this.url = str;
    }

    public void setMaxWidth(int i) {
        this.maxWidth = i;
    }

    public OEmbedRequest MaxWidth(int i) {
        this.maxWidth = i;
        return this;
    }

    public void setHideMedia(boolean z) {
        this.hideMedia = z;
    }

    public OEmbedRequest HideMedia(boolean z) {
        this.hideMedia = z;
        return this;
    }

    public void setHideThread(boolean z) {
        this.hideThread = z;
    }

    public OEmbedRequest HideThread(boolean z) {
        this.hideThread = z;
        return this;
    }

    public void setOmitScript(boolean z) {
        this.omitScript = z;
    }

    public OEmbedRequest omitScript(boolean z) {
        this.omitScript = z;
        return this;
    }

    public void setAlign(Align align2) {
        this.align = align2;
    }

    public OEmbedRequest align(Align align2) {
        this.align = align2;
        return this;
    }

    public void setRelated(String[] strArr) {
        this.related = strArr;
    }

    public OEmbedRequest related(String[] strArr) {
        this.related = strArr;
        return this;
    }

    public void setLang(String str) {
        this.lang = str;
    }

    public OEmbedRequest lang(String str) {
        this.lang = str;
        return this;
    }

    /* access modifiers changed from: 0000 */
    public HttpParameter[] asHttpParameterArray() {
        ArrayList arrayList = new ArrayList(12);
        appendParameter("id", this.statusId, (List<HttpParameter>) arrayList);
        appendParameter(ImagesContract.URL, this.url, (List<HttpParameter>) arrayList);
        appendParameter("maxwidth", (long) this.maxWidth, (List<HttpParameter>) arrayList);
        arrayList.add(new HttpParameter("hide_media", this.hideMedia));
        arrayList.add(new HttpParameter("hide_thread", this.hideThread));
        arrayList.add(new HttpParameter("omit_script", this.omitScript));
        arrayList.add(new HttpParameter("align", this.align.name().toLowerCase()));
        if (this.related.length > 0) {
            appendParameter("related", StringUtil.join(this.related), (List<HttpParameter>) arrayList);
        }
        appendParameter("lang", this.lang, (List<HttpParameter>) arrayList);
        return (HttpParameter[]) arrayList.toArray(new HttpParameter[arrayList.size()]);
    }

    private void appendParameter(String str, String str2, List<HttpParameter> list) {
        if (str2 != null) {
            list.add(new HttpParameter(str, str2));
        }
    }

    private void appendParameter(String str, long j, List<HttpParameter> list) {
        if (0 <= j) {
            list.add(new HttpParameter(str, String.valueOf(j)));
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        OEmbedRequest oEmbedRequest = (OEmbedRequest) obj;
        if (this.hideMedia != oEmbedRequest.hideMedia || this.hideThread != oEmbedRequest.hideThread || this.maxWidth != oEmbedRequest.maxWidth || this.omitScript != oEmbedRequest.omitScript || this.statusId != oEmbedRequest.statusId || this.align != oEmbedRequest.align) {
            return false;
        }
        if (this.lang == null ? oEmbedRequest.lang != null : !this.lang.equals(oEmbedRequest.lang)) {
            return false;
        }
        if (!Arrays.equals(this.related, oEmbedRequest.related)) {
            return false;
        }
        return this.url == null ? oEmbedRequest.url == null : this.url.equals(oEmbedRequest.url);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((((((((((((((int) (this.statusId ^ (this.statusId >>> 32))) * 31) + (this.url != null ? this.url.hashCode() : 0)) * 31) + this.maxWidth) * 31) + (this.hideMedia ? 1 : 0)) * 31) + (this.hideThread ? 1 : 0)) * 31) + (this.omitScript ? 1 : 0)) * 31) + (this.align != null ? this.align.hashCode() : 0)) * 31) + (this.related != null ? Arrays.hashCode(this.related) : 0)) * 31;
        if (this.lang != null) {
            i = this.lang.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        List list;
        StringBuilder sb = new StringBuilder();
        sb.append("OEmbedRequest{statusId=");
        sb.append(this.statusId);
        sb.append(", url='");
        sb.append(this.url);
        sb.append('\'');
        sb.append(", maxWidth=");
        sb.append(this.maxWidth);
        sb.append(", hideMedia=");
        sb.append(this.hideMedia);
        sb.append(", hideThread=");
        sb.append(this.hideThread);
        sb.append(", omitScript=");
        sb.append(this.omitScript);
        sb.append(", align=");
        sb.append(this.align);
        sb.append(", related=");
        if (this.related == null) {
            list = null;
        } else {
            list = Arrays.asList(this.related);
        }
        sb.append(list);
        sb.append(", lang='");
        sb.append(this.lang);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
