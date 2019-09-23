package com.j256.simplemagic;

import java.io.Serializable;

public class ContentInfo implements Serializable {
    public static final ContentInfo EMPTY_INFO = new ContentInfo(ContentType.EMPTY);
    private static final long serialVersionUID = 1342819252130963539L;
    private final ContentType contentType;
    private final String[] fileExtensions;
    private final String message;
    private final String mimeType;
    private final String name;
    private final boolean partial;

    public ContentInfo(String str, String str2, String str3, boolean z) {
        this.contentType = ContentType.fromMimeType(str2);
        if (this.contentType == ContentType.OTHER) {
            this.name = str;
            this.fileExtensions = null;
        } else {
            this.name = this.contentType.getSimpleName();
            this.fileExtensions = this.contentType.getFileExtensions();
        }
        this.mimeType = str2;
        this.message = str3;
        this.partial = z;
    }

    public ContentInfo(ContentType contentType2) {
        this.contentType = contentType2;
        this.name = contentType2.getSimpleName();
        this.mimeType = contentType2.getMimeType();
        this.message = null;
        this.fileExtensions = contentType2.getFileExtensions();
        this.partial = false;
    }

    public ContentType getContentType() {
        return this.contentType;
    }

    public String getName() {
        return this.name;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public String getMessage() {
        return this.message;
    }

    public String[] getFileExtensions() {
        return this.fileExtensions;
    }

    public boolean isPartial() {
        return this.partial;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        if (this.contentType != null) {
            sb.append(", type ");
            sb.append(this.contentType);
        }
        if (this.mimeType != null) {
            sb.append(", mime '");
            sb.append(this.mimeType);
            sb.append('\'');
        }
        if (this.message != null) {
            sb.append(", msg '");
            sb.append(this.message);
            sb.append('\'');
        }
        return sb.toString();
    }
}
