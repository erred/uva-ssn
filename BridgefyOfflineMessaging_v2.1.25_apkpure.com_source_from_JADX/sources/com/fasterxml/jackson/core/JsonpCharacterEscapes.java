package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.p116io.CharacterEscapes;
import com.fasterxml.jackson.core.p116io.SerializedString;

public class JsonpCharacterEscapes extends CharacterEscapes {
    private static final int[] asciiEscapes = CharacterEscapes.standardAsciiEscapesForJSON();
    private static final SerializedString escapeFor2028 = new SerializedString("\\u2028");
    private static final SerializedString escapeFor2029 = new SerializedString("\\u2029");
    private static final JsonpCharacterEscapes sInstance = new JsonpCharacterEscapes();
    private static final long serialVersionUID = 1;

    public static JsonpCharacterEscapes instance() {
        return sInstance;
    }

    public SerializableString getEscapeSequence(int i) {
        switch (i) {
            case 8232:
                return escapeFor2028;
            case 8233:
                return escapeFor2029;
            default:
                return null;
        }
    }

    public int[] getEscapeCodesForAscii() {
        return asciiEscapes;
    }
}
