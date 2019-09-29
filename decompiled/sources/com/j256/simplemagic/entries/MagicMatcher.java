package com.j256.simplemagic.entries;

public interface MagicMatcher {

    public static class MutableOffset {
        public int offset;

        public MutableOffset(int i) {
            this.offset = i;
        }

        public String toString() {
            return Integer.toString(this.offset);
        }
    }

    Object convertTestString(String str, String str2);

    Object extractValueFromBytes(int i, byte[] bArr, boolean z);

    byte[] getStartingBytes(Object obj);

    Object isMatch(Object obj, Long l, boolean z, Object obj2, MutableOffset mutableOffset, byte[] bArr);

    void renderValue(StringBuilder sb, Object obj, MagicFormatter magicFormatter);
}
