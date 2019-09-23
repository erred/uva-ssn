package com.j256.simplemagic.types;

import com.j256.simplemagic.entries.MagicFormatter;
import com.j256.simplemagic.entries.MagicMatcher;
import com.j256.simplemagic.entries.MagicMatcher.MutableOffset;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexType implements MagicMatcher {
    private static final String EMPTY = "";
    private static final Pattern TYPE_PATTERN = Pattern.compile("[^/]+(/[cs]*)?");

    private static class PatternInfo {
        Pattern pattern;
        int patternFlags;
        boolean updateOffsetStart;

        private PatternInfo() {
        }
    }

    public Object extractValueFromBytes(int i, byte[] bArr, boolean z) {
        return "";
    }

    public byte[] getStartingBytes(Object obj) {
        return null;
    }

    public Object convertTestString(String str, String str2) {
        char[] charArray;
        Matcher matcher = TYPE_PATTERN.matcher(str);
        PatternInfo patternInfo = new PatternInfo();
        if (matcher.matches()) {
            String group = matcher.group(1);
            if (group != null && group.length() > 1) {
                for (char c : group.toCharArray()) {
                    if (c == 'c') {
                        patternInfo.patternFlags |= 2;
                    } else if (c == 's') {
                        patternInfo.updateOffsetStart = true;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(".*(");
        sb.append(str2);
        sb.append(").*");
        patternInfo.pattern = Pattern.compile(sb.toString(), patternInfo.patternFlags);
        return patternInfo;
    }

    public Object isMatch(Object obj, Long l, boolean z, Object obj2, MutableOffset mutableOffset, byte[] bArr) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArr)));
        int i = 0;
        String str = null;
        int i2 = 0;
        while (i <= mutableOffset.offset) {
            try {
                str = bufferedReader.readLine();
                if (str == null) {
                    return null;
                }
                if (i < mutableOffset.offset) {
                    i2 += str.length() + 1;
                }
                i++;
            } catch (IOException unused) {
                return null;
            }
        }
        if (str == null) {
            return null;
        }
        Matcher matcher = ((PatternInfo) obj).pattern.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        mutableOffset.offset = i2 + matcher.end(1);
        return matcher.group(1);
    }

    public void renderValue(StringBuilder sb, Object obj, MagicFormatter magicFormatter) {
        magicFormatter.format(sb, obj);
    }
}
