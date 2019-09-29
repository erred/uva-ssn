package com.google.thirdparty.publicsuffix;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Lists;
import java.util.List;

@GwtCompatible
class TrieParser {
    private static final Joiner PREFIX_JOINER = Joiner.m8643on("");

    TrieParser() {
    }

    static ImmutableMap<String, PublicSuffixType> parseTrie(CharSequence charSequence) {
        Builder builder = ImmutableMap.builder();
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            i += doParseTrieToBuilder(Lists.newLinkedList(), charSequence.subSequence(i, length), builder);
        }
        return builder.build();
    }

    private static int doParseTrieToBuilder(List<CharSequence> list, CharSequence charSequence, Builder<String, PublicSuffixType> builder) {
        int length = charSequence.length();
        int i = 0;
        char c = 0;
        while (i < length) {
            c = charSequence.charAt(i);
            if (c == '&' || c == '?' || c == '!' || c == ':' || c == ',') {
                break;
            }
            i++;
        }
        list.add(0, reverse(charSequence.subSequence(0, i)));
        if (c == '!' || c == '?' || c == ':' || c == ',') {
            String join = PREFIX_JOINER.join((Iterable<?>) list);
            if (join.length() > 0) {
                builder.put(join, PublicSuffixType.fromCode(c));
            }
        }
        int i2 = i + 1;
        if (c != '?' && c != ',') {
            while (true) {
                if (i2 >= length) {
                    break;
                }
                i2 += doParseTrieToBuilder(list, charSequence.subSequence(i2, length), builder);
                if (charSequence.charAt(i2) != '?') {
                    if (charSequence.charAt(i2) == ',') {
                        break;
                    }
                } else {
                    break;
                }
            }
            i2++;
        }
        list.remove(0);
        return i2;
    }

    private static CharSequence reverse(CharSequence charSequence) {
        int length = charSequence.length();
        if (length <= 1) {
            return charSequence;
        }
        char[] cArr = new char[length];
        int i = length - 1;
        cArr[0] = charSequence.charAt(i);
        for (int i2 = 1; i2 < length; i2++) {
            cArr[i2] = charSequence.charAt(i - i2);
            int i3 = i2 - 1;
            if (Character.isSurrogatePair(cArr[i2], cArr[i3])) {
                swap(cArr, i3, i2);
            }
        }
        return new String(cArr);
    }

    private static void swap(char[] cArr, int i, int i2) {
        char c = cArr[i];
        cArr[i] = cArr[i2];
        cArr[i2] = c;
    }
}
