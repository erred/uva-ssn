package com.j256.simplemagic.entries;

import com.j256.simplemagic.ContentInfo;
import com.j256.simplemagic.endian.EndianConverter;
import com.j256.simplemagic.entries.MagicMatcher.MutableOffset;
import com.j256.simplemagic.logger.Logger;
import com.j256.simplemagic.logger.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

public class MagicEntry {
    private static final String UNKNOWN_NAME = "unknown";
    private static Logger logger = LoggerFactory.getLogger(MagicEntry.class);
    private final boolean addOffset;
    private final Long andValue;
    private List<MagicEntry> children;
    private final boolean clearFormat;
    private final boolean formatSpacePrefix;
    private final MagicFormatter formatter;
    private final int level;
    private final MagicMatcher matcher;
    private String mimeType;
    private final String name;
    private final int offset;
    private final OffsetInfo offsetInfo;
    private boolean optional;
    private final Object testValue;
    private final boolean unsignedType;

    static class ContentData {
        String mimeType;
        int mimeTypeLevel;
        String name;
        boolean partial;

        /* renamed from: sb */
        final StringBuilder f6826sb;

        private ContentData(String str, String str2, int i) {
            this.f6826sb = new StringBuilder();
            this.name = str;
            this.mimeType = str2;
            this.mimeTypeLevel = i;
        }

        public String toString() {
            if (this.f6826sb.length() != 0) {
                return this.f6826sb.toString();
            }
            if (this.name == null) {
                return super.toString();
            }
            return this.name;
        }
    }

    static class OffsetInfo {
        final int add;
        final EndianConverter converter;
        final boolean isId3;
        final int offset;
        final int size;

        OffsetInfo(int i, EndianConverter endianConverter, boolean z, int i2, int i3) {
            this.offset = i;
            this.converter = endianConverter;
            this.isId3 = z;
            this.size = i2;
            this.add = i3;
        }

        public Integer getOffset(byte[] bArr) {
            Long l;
            if (this.isId3) {
                l = this.converter.convertId3(this.offset, bArr, this.size);
            } else {
                l = this.converter.convertNumber(this.offset, bArr, this.size);
            }
            if (l == null) {
                return null;
            }
            return Integer.valueOf((int) (l.longValue() + ((long) this.add)));
        }
    }

    MagicEntry(String str, int i, boolean z, int i2, OffsetInfo offsetInfo2, MagicMatcher magicMatcher, Long l, boolean z2, Object obj, boolean z3, boolean z4, MagicFormatter magicFormatter) {
        this.name = str;
        this.level = i;
        this.addOffset = z;
        this.offset = i2;
        this.offsetInfo = offsetInfo2;
        this.matcher = magicMatcher;
        this.andValue = l;
        this.unsignedType = z2;
        this.testValue = obj;
        this.formatSpacePrefix = z3;
        this.clearFormat = z4;
        this.formatter = magicFormatter;
    }

    /* access modifiers changed from: 0000 */
    public ContentInfo matchBytes(byte[] bArr) {
        ContentData matchBytes = matchBytes(bArr, 0, 0, null);
        if (matchBytes == null || matchBytes.name == UNKNOWN_NAME) {
            return null;
        }
        return new ContentInfo(matchBytes.name, matchBytes.mimeType, matchBytes.f6826sb.toString(), matchBytes.partial);
    }

    /* access modifiers changed from: 0000 */
    public int getLevel() {
        return this.level;
    }

    /* access modifiers changed from: 0000 */
    public byte[] getStartsWithByte() {
        if (this.offset != 0) {
            return null;
        }
        return this.matcher.getStartingBytes(this.testValue);
    }

    /* access modifiers changed from: 0000 */
    public boolean isOptional() {
        return this.optional;
    }

    /* access modifiers changed from: 0000 */
    public void setOptional(boolean z) {
        this.optional = z;
    }

    /* access modifiers changed from: 0000 */
    public void addChild(MagicEntry magicEntry) {
        if (this.children == null) {
            this.children = new ArrayList();
        }
        this.children.add(magicEntry);
    }

    /* access modifiers changed from: 0000 */
    public void setMimeType(String str) {
        this.mimeType = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("level ");
        sb.append(this.level);
        if (this.name != null) {
            sb.append(",name '");
            sb.append(this.name);
            sb.append('\'');
        }
        if (this.mimeType != null) {
            sb.append(",mime '");
            sb.append(this.mimeType);
            sb.append('\'');
        }
        if (this.testValue != null) {
            sb.append(",test '");
            sb.append(this.testValue);
            sb.append('\'');
        }
        if (this.formatter != null) {
            sb.append(",format '");
            sb.append(this.formatter);
            sb.append('\'');
        }
        return sb.toString();
    }

    private ContentData matchBytes(byte[] bArr, int i, int i2, ContentData contentData) {
        int i3 = this.offset;
        if (this.offsetInfo != null) {
            i3 = this.offsetInfo.getOffset(bArr).intValue();
        }
        if (this.addOffset) {
            i3 += i;
        }
        boolean z = true;
        Object extractValueFromBytes = this.matcher.extractValueFromBytes(i3, bArr, this.testValue == null && this.formatter != null);
        if (extractValueFromBytes == null) {
            return null;
        }
        if (this.testValue != null) {
            MutableOffset mutableOffset = new MutableOffset(i3);
            extractValueFromBytes = this.matcher.isMatch(this.testValue, this.andValue, this.unsignedType, extractValueFromBytes, mutableOffset, bArr);
            if (extractValueFromBytes == null) {
                return null;
            }
            i3 = mutableOffset.offset;
        }
        if (contentData == null) {
            contentData = new ContentData(this.name, this.mimeType, i2);
            contentData.partial = true;
        }
        if (this.formatter != null) {
            if (this.clearFormat) {
                contentData.f6826sb.setLength(0);
            }
            if (this.formatSpacePrefix && contentData.f6826sb.length() > 0) {
                contentData.f6826sb.append(' ');
            }
            this.matcher.renderValue(contentData.f6826sb, extractValueFromBytes, this.formatter);
        }
        logger.trace("matched data: {}: {}", (Object) this, (Object) contentData);
        if (this.children == null) {
            contentData.partial = false;
        } else {
            for (MagicEntry magicEntry : this.children) {
                if (!magicEntry.isOptional()) {
                    z = false;
                }
                magicEntry.matchBytes(bArr, i3, i2 + 1, contentData);
            }
            if (z) {
                contentData.partial = false;
            }
        }
        if (this.name != UNKNOWN_NAME && contentData.name == UNKNOWN_NAME) {
            contentData.name = this.name;
        }
        if (this.mimeType != null && (contentData.mimeType == null || i2 > contentData.mimeTypeLevel)) {
            contentData.mimeType = this.mimeType;
            contentData.mimeTypeLevel = i2;
        }
        return contentData;
    }
}
