package com.j256.simplemagic.entries;

import com.google.common.primitives.UnsignedBytes;
import com.j256.simplemagic.ContentInfo;
import com.j256.simplemagic.ContentInfoUtil.ErrorCallBack;
import com.j256.simplemagic.logger.Logger;
import com.j256.simplemagic.logger.LoggerFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MagicEntries {
    private static final int FIRST_BYTE_LIST_SIZE = 256;
    private static final int MAX_LEVELS = 20;
    private static Logger logger = LoggerFactory.getLogger(MagicEntries.class);
    private final List<MagicEntry> entryList = new ArrayList();
    private final List<MagicEntry>[] firstByteEntryLists = new ArrayList[256];

    public void readEntries(BufferedReader bufferedReader, ErrorCallBack errorCallBack) throws IOException {
        MagicEntry[] magicEntryArr = new MagicEntry[20];
        MagicEntry magicEntry = null;
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                if (!(readLine.length() == 0 || readLine.charAt(0) == '#')) {
                    try {
                        MagicEntry parseLine = MagicEntryParser.parseLine(magicEntry, readLine, errorCallBack);
                        if (parseLine != null) {
                            int level = parseLine.getLevel();
                            if (magicEntry != null || level == 0) {
                                if (level == 0) {
                                    this.entryList.add(parseLine);
                                } else {
                                    int i = level - 1;
                                    if (magicEntryArr[i] != null) {
                                        magicEntryArr[i].addChild(parseLine);
                                    } else if (errorCallBack != null) {
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("entry has level ");
                                        sb.append(level);
                                        sb.append(" but no parent entry with level ");
                                        sb.append(i);
                                        errorCallBack.error(readLine, sb.toString(), null);
                                    }
                                }
                                magicEntryArr[level] = parseLine;
                                magicEntry = parseLine;
                            } else if (errorCallBack != null) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("first entry of the file but the level ");
                                sb2.append(level);
                                sb2.append(" should be 0");
                                errorCallBack.error(readLine, sb2.toString(), null);
                            }
                        }
                    } catch (IllegalArgumentException e) {
                        if (errorCallBack != null) {
                            errorCallBack.error(readLine, e.getMessage(), e);
                        }
                    }
                }
            } else {
                return;
            }
        }
    }

    public void optimizeFirstBytes() {
        for (MagicEntry magicEntry : this.entryList) {
            byte[] startsWithByte = magicEntry.getStartsWithByte();
            if (!(startsWithByte == null || startsWithByte.length == 0)) {
                byte b = startsWithByte[0] & UnsignedBytes.MAX_VALUE;
                if (this.firstByteEntryLists[b] == null) {
                    this.firstByteEntryLists[b] = new ArrayList();
                }
                this.firstByteEntryLists[b].add(magicEntry);
            }
        }
    }

    public ContentInfo findMatch(byte[] bArr) {
        if (bArr.length == 0) {
            return ContentInfo.EMPTY_INFO;
        }
        byte b = bArr[0] & UnsignedBytes.MAX_VALUE;
        if (b < this.firstByteEntryLists.length && this.firstByteEntryLists[b] != null) {
            ContentInfo findMatch = findMatch(bArr, this.firstByteEntryLists[b]);
            if (findMatch != null) {
                return findMatch;
            }
        }
        return findMatch(bArr, this.entryList);
    }

    private ContentInfo findMatch(byte[] bArr, List<MagicEntry> list) {
        ContentInfo contentInfo = null;
        for (MagicEntry magicEntry : list) {
            ContentInfo matchBytes = magicEntry.matchBytes(bArr);
            if (matchBytes != null) {
                if (!matchBytes.isPartial()) {
                    logger.trace("found full match {}", (Object) magicEntry);
                    logger.trace("returning full match {}", (Object) matchBytes);
                    return matchBytes;
                } else if (contentInfo == null) {
                    logger.trace("found partial match {}", (Object) magicEntry);
                    contentInfo = matchBytes;
                }
            }
        }
        if (contentInfo == null) {
            logger.trace("returning no match");
            return null;
        }
        logger.trace("returning partial match {}", (Object) contentInfo);
        return contentInfo;
    }
}
