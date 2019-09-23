package com.google.common.p126io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.math.RoundingMode;
import java.util.Arrays;

@GwtCompatible(emulated = true)
@Beta
/* renamed from: com.google.common.io.BaseEncoding */
public abstract class BaseEncoding {
    private static final BaseEncoding BASE16 = new StandardBaseEncoding("base16()", "0123456789ABCDEF", null);
    private static final BaseEncoding BASE32 = new StandardBaseEncoding("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", Character.valueOf('='));
    private static final BaseEncoding BASE32_HEX = new StandardBaseEncoding("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", Character.valueOf('='));
    private static final BaseEncoding BASE64 = new StandardBaseEncoding("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", Character.valueOf('='));
    private static final BaseEncoding BASE64_URL = new StandardBaseEncoding("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", Character.valueOf('='));

    /* renamed from: com.google.common.io.BaseEncoding$Alphabet */
    private static final class Alphabet extends CharMatcher {
        final int bitsPerChar;
        final int bytesPerChunk;
        private final char[] chars;
        final int charsPerChunk;
        private final byte[] decodabet;
        final int mask;
        private final String name;
        private final boolean[] validPadding;

        Alphabet(String str, char[] cArr) {
            this.name = (String) Preconditions.checkNotNull(str);
            this.chars = (char[]) Preconditions.checkNotNull(cArr);
            try {
                this.bitsPerChar = IntMath.log2(cArr.length, RoundingMode.UNNECESSARY);
                int min = Math.min(8, Integer.lowestOneBit(this.bitsPerChar));
                this.charsPerChunk = 8 / min;
                this.bytesPerChunk = this.bitsPerChar / min;
                this.mask = cArr.length - 1;
                byte[] bArr = new byte[128];
                Arrays.fill(bArr, -1);
                for (int i = 0; i < cArr.length; i++) {
                    char c = cArr[i];
                    Preconditions.checkArgument(CharMatcher.ASCII.matches(c), "Non-ASCII character: %s", Character.valueOf(c));
                    Preconditions.checkArgument(bArr[c] == -1, "Duplicate character: %s", Character.valueOf(c));
                    bArr[c] = (byte) i;
                }
                this.decodabet = bArr;
                boolean[] zArr = new boolean[this.charsPerChunk];
                for (int i2 = 0; i2 < this.bytesPerChunk; i2++) {
                    zArr[IntMath.divide(i2 * 8, this.bitsPerChar, RoundingMode.CEILING)] = true;
                }
                this.validPadding = zArr;
            } catch (ArithmeticException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Illegal alphabet length ");
                sb.append(cArr.length);
                throw new IllegalArgumentException(sb.toString(), e);
            }
        }

        /* access modifiers changed from: 0000 */
        public char encode(int i) {
            return this.chars[i];
        }

        /* access modifiers changed from: 0000 */
        public boolean isValidPaddingStartPosition(int i) {
            return this.validPadding[i % this.charsPerChunk];
        }

        /* access modifiers changed from: 0000 */
        public int decode(char c) throws IOException {
            if (c <= 127 && this.decodabet[c] != -1) {
                return this.decodabet[c];
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Unrecognized character: ");
            sb.append(c);
            throw new DecodingException(sb.toString());
        }

        private boolean hasLowerCase() {
            for (char isLowerCase : this.chars) {
                if (Ascii.isLowerCase(isLowerCase)) {
                    return true;
                }
            }
            return false;
        }

        private boolean hasUpperCase() {
            for (char isUpperCase : this.chars) {
                if (Ascii.isUpperCase(isUpperCase)) {
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: 0000 */
        public Alphabet upperCase() {
            if (!hasLowerCase()) {
                return this;
            }
            Preconditions.checkState(!hasUpperCase(), "Cannot call upperCase() on a mixed-case alphabet");
            char[] cArr = new char[this.chars.length];
            for (int i = 0; i < this.chars.length; i++) {
                cArr[i] = Ascii.toUpperCase(this.chars[i]);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.name);
            sb.append(".upperCase()");
            return new Alphabet(sb.toString(), cArr);
        }

        /* access modifiers changed from: 0000 */
        public Alphabet lowerCase() {
            if (!hasUpperCase()) {
                return this;
            }
            Preconditions.checkState(!hasLowerCase(), "Cannot call lowerCase() on a mixed-case alphabet");
            char[] cArr = new char[this.chars.length];
            for (int i = 0; i < this.chars.length; i++) {
                cArr[i] = Ascii.toLowerCase(this.chars[i]);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.name);
            sb.append(".lowerCase()");
            return new Alphabet(sb.toString(), cArr);
        }

        public boolean matches(char c) {
            return CharMatcher.ASCII.matches(c) && this.decodabet[c] != -1;
        }

        public String toString() {
            return this.name;
        }
    }

    /* renamed from: com.google.common.io.BaseEncoding$DecodingException */
    public static final class DecodingException extends IOException {
        DecodingException(String str) {
            super(str);
        }

        DecodingException(Throwable th) {
            initCause(th);
        }
    }

    /* renamed from: com.google.common.io.BaseEncoding$SeparatedBaseEncoding */
    static final class SeparatedBaseEncoding extends BaseEncoding {
        private final int afterEveryChars;
        private final BaseEncoding delegate;
        private final String separator;
        private final CharMatcher separatorChars;

        SeparatedBaseEncoding(BaseEncoding baseEncoding, String str, int i) {
            this.delegate = (BaseEncoding) Preconditions.checkNotNull(baseEncoding);
            this.separator = (String) Preconditions.checkNotNull(str);
            this.afterEveryChars = i;
            Preconditions.checkArgument(i > 0, "Cannot add a separator after every %s chars", Integer.valueOf(i));
            this.separatorChars = CharMatcher.anyOf(str).precomputed();
        }

        /* access modifiers changed from: 0000 */
        public CharMatcher padding() {
            return this.delegate.padding();
        }

        /* access modifiers changed from: 0000 */
        public int maxEncodedSize(int i) {
            int maxEncodedSize = this.delegate.maxEncodedSize(i);
            return maxEncodedSize + (this.separator.length() * IntMath.divide(Math.max(0, maxEncodedSize - 1), this.afterEveryChars, RoundingMode.FLOOR));
        }

        /* access modifiers changed from: 0000 */
        public ByteOutput encodingStream(CharOutput charOutput) {
            return this.delegate.encodingStream(separatingOutput(charOutput, this.separator, this.afterEveryChars));
        }

        /* access modifiers changed from: 0000 */
        public int maxDecodedSize(int i) {
            return this.delegate.maxDecodedSize(i);
        }

        /* access modifiers changed from: 0000 */
        public ByteInput decodingStream(CharInput charInput) {
            return this.delegate.decodingStream(ignoringInput(charInput, this.separatorChars));
        }

        public BaseEncoding omitPadding() {
            return this.delegate.omitPadding().withSeparator(this.separator, this.afterEveryChars);
        }

        public BaseEncoding withPadChar(char c) {
            return this.delegate.withPadChar(c).withSeparator(this.separator, this.afterEveryChars);
        }

        public BaseEncoding withSeparator(String str, int i) {
            throw new UnsupportedOperationException("Already have a separator");
        }

        public BaseEncoding upperCase() {
            return this.delegate.upperCase().withSeparator(this.separator, this.afterEveryChars);
        }

        public BaseEncoding lowerCase() {
            return this.delegate.lowerCase().withSeparator(this.separator, this.afterEveryChars);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.delegate.toString());
            sb.append(".withSeparator(\"");
            sb.append(this.separator);
            sb.append("\", ");
            sb.append(this.afterEveryChars);
            sb.append(")");
            return sb.toString();
        }
    }

    /* renamed from: com.google.common.io.BaseEncoding$StandardBaseEncoding */
    static final class StandardBaseEncoding extends BaseEncoding {
        /* access modifiers changed from: private */
        public final Alphabet alphabet;
        private transient BaseEncoding lowerCase;
        /* access modifiers changed from: private */
        public final Character paddingChar;
        private transient BaseEncoding upperCase;

        StandardBaseEncoding(String str, String str2, Character ch) {
            this(new Alphabet(str, str2.toCharArray()), ch);
        }

        StandardBaseEncoding(Alphabet alphabet2, Character ch) {
            this.alphabet = (Alphabet) Preconditions.checkNotNull(alphabet2);
            Preconditions.checkArgument(ch == null || !alphabet2.matches(ch.charValue()), "Padding character %s was already in alphabet", ch);
            this.paddingChar = ch;
        }

        /* access modifiers changed from: 0000 */
        public CharMatcher padding() {
            return this.paddingChar == null ? CharMatcher.NONE : CharMatcher.m8636is(this.paddingChar.charValue());
        }

        /* access modifiers changed from: 0000 */
        public int maxEncodedSize(int i) {
            return this.alphabet.charsPerChunk * IntMath.divide(i, this.alphabet.bytesPerChunk, RoundingMode.CEILING);
        }

        /* access modifiers changed from: 0000 */
        public ByteOutput encodingStream(final CharOutput charOutput) {
            Preconditions.checkNotNull(charOutput);
            return new ByteOutput() {
                int bitBuffer = 0;
                int bitBufferLength = 0;
                int writtenChars = 0;

                public void write(byte b) throws IOException {
                    this.bitBuffer <<= 8;
                    this.bitBuffer = (b & UnsignedBytes.MAX_VALUE) | this.bitBuffer;
                    this.bitBufferLength += 8;
                    while (this.bitBufferLength >= StandardBaseEncoding.this.alphabet.bitsPerChar) {
                        charOutput.write(StandardBaseEncoding.this.alphabet.encode((this.bitBuffer >> (this.bitBufferLength - StandardBaseEncoding.this.alphabet.bitsPerChar)) & StandardBaseEncoding.this.alphabet.mask));
                        this.writtenChars++;
                        this.bitBufferLength -= StandardBaseEncoding.this.alphabet.bitsPerChar;
                    }
                }

                public void flush() throws IOException {
                    charOutput.flush();
                }

                public void close() throws IOException {
                    if (this.bitBufferLength > 0) {
                        charOutput.write(StandardBaseEncoding.this.alphabet.encode((this.bitBuffer << (StandardBaseEncoding.this.alphabet.bitsPerChar - this.bitBufferLength)) & StandardBaseEncoding.this.alphabet.mask));
                        this.writtenChars++;
                        if (StandardBaseEncoding.this.paddingChar != null) {
                            while (this.writtenChars % StandardBaseEncoding.this.alphabet.charsPerChunk != 0) {
                                charOutput.write(StandardBaseEncoding.this.paddingChar.charValue());
                                this.writtenChars++;
                            }
                        }
                    }
                    charOutput.close();
                }
            };
        }

        /* access modifiers changed from: 0000 */
        public int maxDecodedSize(int i) {
            return (int) (((((long) this.alphabet.bitsPerChar) * ((long) i)) + 7) / 8);
        }

        /* access modifiers changed from: 0000 */
        public ByteInput decodingStream(final CharInput charInput) {
            Preconditions.checkNotNull(charInput);
            return new ByteInput() {
                int bitBuffer = 0;
                int bitBufferLength = 0;
                boolean hitPadding = false;
                final CharMatcher paddingMatcher = StandardBaseEncoding.this.padding();
                int readChars = 0;

                public int read() throws IOException {
                    while (true) {
                        int read = charInput.read();
                        if (read != -1) {
                            this.readChars++;
                            char c = (char) read;
                            if (this.paddingMatcher.matches(c)) {
                                if (this.hitPadding || (this.readChars != 1 && StandardBaseEncoding.this.alphabet.isValidPaddingStartPosition(this.readChars - 1))) {
                                    this.hitPadding = true;
                                }
                            } else if (!this.hitPadding) {
                                this.bitBuffer <<= StandardBaseEncoding.this.alphabet.bitsPerChar;
                                this.bitBuffer = StandardBaseEncoding.this.alphabet.decode(c) | this.bitBuffer;
                                this.bitBufferLength += StandardBaseEncoding.this.alphabet.bitsPerChar;
                                if (this.bitBufferLength >= 8) {
                                    this.bitBufferLength -= 8;
                                    return (this.bitBuffer >> this.bitBufferLength) & 255;
                                }
                            } else {
                                StringBuilder sb = new StringBuilder();
                                sb.append("Expected padding character but found '");
                                sb.append(c);
                                sb.append("' at index ");
                                sb.append(this.readChars);
                                throw new DecodingException(sb.toString());
                            }
                        } else if (this.hitPadding || StandardBaseEncoding.this.alphabet.isValidPaddingStartPosition(this.readChars)) {
                            return -1;
                        } else {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Invalid input length ");
                            sb2.append(this.readChars);
                            throw new DecodingException(sb2.toString());
                        }
                    }
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Padding cannot start at index ");
                    sb3.append(this.readChars);
                    throw new DecodingException(sb3.toString());
                }

                public void close() throws IOException {
                    charInput.close();
                }
            };
        }

        public BaseEncoding omitPadding() {
            return this.paddingChar == null ? this : new StandardBaseEncoding(this.alphabet, null);
        }

        public BaseEncoding withPadChar(char c) {
            return (8 % this.alphabet.bitsPerChar == 0 || (this.paddingChar != null && this.paddingChar.charValue() == c)) ? this : new StandardBaseEncoding(this.alphabet, Character.valueOf(c));
        }

        public BaseEncoding withSeparator(String str, int i) {
            Preconditions.checkNotNull(str);
            Preconditions.checkArgument(padding().mo21322or(this.alphabet).matchesNoneOf(str), "Separator cannot contain alphabet or padding characters");
            return new SeparatedBaseEncoding(this, str, i);
        }

        public BaseEncoding upperCase() {
            BaseEncoding baseEncoding = this.upperCase;
            if (baseEncoding == 0) {
                Alphabet upperCase2 = this.alphabet.upperCase();
                BaseEncoding standardBaseEncoding = upperCase2 == this.alphabet ? this : new StandardBaseEncoding(upperCase2, this.paddingChar);
                this.upperCase = standardBaseEncoding;
                baseEncoding = standardBaseEncoding;
            }
            return baseEncoding;
        }

        public BaseEncoding lowerCase() {
            BaseEncoding baseEncoding = this.lowerCase;
            if (baseEncoding == 0) {
                Alphabet lowerCase2 = this.alphabet.lowerCase();
                BaseEncoding standardBaseEncoding = lowerCase2 == this.alphabet ? this : new StandardBaseEncoding(lowerCase2, this.paddingChar);
                this.lowerCase = standardBaseEncoding;
                baseEncoding = standardBaseEncoding;
            }
            return baseEncoding;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("BaseEncoding.");
            sb.append(this.alphabet.toString());
            if (8 % this.alphabet.bitsPerChar != 0) {
                if (this.paddingChar == null) {
                    sb.append(".omitPadding()");
                } else {
                    sb.append(".withPadChar(");
                    sb.append(this.paddingChar);
                    sb.append(')');
                }
            }
            return sb.toString();
        }
    }

    /* access modifiers changed from: 0000 */
    public abstract ByteInput decodingStream(CharInput charInput);

    /* access modifiers changed from: 0000 */
    public abstract ByteOutput encodingStream(CharOutput charOutput);

    public abstract BaseEncoding lowerCase();

    /* access modifiers changed from: 0000 */
    public abstract int maxDecodedSize(int i);

    /* access modifiers changed from: 0000 */
    public abstract int maxEncodedSize(int i);

    public abstract BaseEncoding omitPadding();

    /* access modifiers changed from: 0000 */
    public abstract CharMatcher padding();

    public abstract BaseEncoding upperCase();

    public abstract BaseEncoding withPadChar(char c);

    public abstract BaseEncoding withSeparator(String str, int i);

    BaseEncoding() {
    }

    public String encode(byte[] bArr) {
        return encode((byte[]) Preconditions.checkNotNull(bArr), 0, bArr.length);
    }

    public final String encode(byte[] bArr, int i, int i2) {
        Preconditions.checkNotNull(bArr);
        Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
        CharOutput stringBuilderOutput = GwtWorkarounds.stringBuilderOutput(maxEncodedSize(i2));
        ByteOutput encodingStream = encodingStream(stringBuilderOutput);
        int i3 = 0;
        while (i3 < i2) {
            try {
                encodingStream.write(bArr[i + i3]);
                i3++;
            } catch (IOException unused) {
                throw new AssertionError("impossible");
            }
        }
        encodingStream.close();
        return stringBuilderOutput.toString();
    }

    @GwtIncompatible("Writer,OutputStream")
    public final OutputStream encodingStream(Writer writer) {
        return GwtWorkarounds.asOutputStream(encodingStream(GwtWorkarounds.asCharOutput(writer)));
    }

    @GwtIncompatible("ByteSink,CharSink")
    public final ByteSink encodingSink(final CharSink charSink) {
        Preconditions.checkNotNull(charSink);
        return new ByteSink() {
            public OutputStream openStream() throws IOException {
                return BaseEncoding.this.encodingStream(charSink.openStream());
            }
        };
    }

    private static byte[] extract(byte[] bArr, int i) {
        if (i == bArr.length) {
            return bArr;
        }
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 0, bArr2, 0, i);
        return bArr2;
    }

    public final byte[] decode(CharSequence charSequence) {
        try {
            return decodeChecked(charSequence);
        } catch (DecodingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /* access modifiers changed from: 0000 */
    public final byte[] decodeChecked(CharSequence charSequence) throws DecodingException {
        String trimTrailingFrom = padding().trimTrailingFrom(charSequence);
        ByteInput decodingStream = decodingStream(GwtWorkarounds.asCharInput((CharSequence) trimTrailingFrom));
        byte[] bArr = new byte[maxDecodedSize(trimTrailingFrom.length())];
        try {
            int read = decodingStream.read();
            int i = 0;
            while (read != -1) {
                int i2 = i + 1;
                bArr[i] = (byte) read;
                read = decodingStream.read();
                i = i2;
            }
            return extract(bArr, i);
        } catch (DecodingException e) {
            throw e;
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    @GwtIncompatible("Reader,InputStream")
    public final InputStream decodingStream(Reader reader) {
        return GwtWorkarounds.asInputStream(decodingStream(GwtWorkarounds.asCharInput(reader)));
    }

    @GwtIncompatible("ByteSource,CharSource")
    public final ByteSource decodingSource(final CharSource charSource) {
        Preconditions.checkNotNull(charSource);
        return new ByteSource() {
            public InputStream openStream() throws IOException {
                return BaseEncoding.this.decodingStream(charSource.openStream());
            }
        };
    }

    public static BaseEncoding base64() {
        return BASE64;
    }

    public static BaseEncoding base64Url() {
        return BASE64_URL;
    }

    public static BaseEncoding base32() {
        return BASE32;
    }

    public static BaseEncoding base32Hex() {
        return BASE32_HEX;
    }

    public static BaseEncoding base16() {
        return BASE16;
    }

    static CharInput ignoringInput(final CharInput charInput, final CharMatcher charMatcher) {
        Preconditions.checkNotNull(charInput);
        Preconditions.checkNotNull(charMatcher);
        return new CharInput() {
            public int read() throws IOException {
                int read;
                do {
                    read = charInput.read();
                    if (read == -1) {
                        break;
                    }
                } while (charMatcher.matches((char) read));
                return read;
            }

            public void close() throws IOException {
                charInput.close();
            }
        };
    }

    static CharOutput separatingOutput(final CharOutput charOutput, final String str, final int i) {
        Preconditions.checkNotNull(charOutput);
        Preconditions.checkNotNull(str);
        Preconditions.checkArgument(i > 0);
        return new CharOutput() {
            int charsUntilSeparator = i;

            public void write(char c) throws IOException {
                if (this.charsUntilSeparator == 0) {
                    for (int i = 0; i < str.length(); i++) {
                        charOutput.write(str.charAt(i));
                    }
                    this.charsUntilSeparator = i;
                }
                charOutput.write(c);
                this.charsUntilSeparator--;
            }

            public void flush() throws IOException {
                charOutput.flush();
            }

            public void close() throws IOException {
                charOutput.close();
            }
        };
    }
}
