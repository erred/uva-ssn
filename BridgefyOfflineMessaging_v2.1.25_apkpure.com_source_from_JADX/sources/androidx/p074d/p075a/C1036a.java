package androidx.p074d.p075a;

import android.content.res.AssetManager.AssetInputStream;
import android.util.Log;
import com.google.api.client.http.HttpStatusCodes;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
import org.msgpack.core.MessagePack.Code;

/* renamed from: androidx.d.a.a */
/* compiled from: ExifInterface */
public class C1036a {

    /* renamed from: A */
    private static final C1039c f3193A = new C1039c("JPEGInterchangeFormat", 513, 4);

    /* renamed from: B */
    private static final C1039c f3194B = new C1039c("JPEGInterchangeFormatLength", 514, 4);

    /* renamed from: C */
    private static final HashMap<Integer, C1039c>[] f3195C = new HashMap[f3208h.length];

    /* renamed from: D */
    private static final HashMap<String, C1039c>[] f3196D = new HashMap[f3208h.length];

    /* renamed from: E */
    private static final HashSet<String> f3197E = new HashSet<>(Arrays.asList(new String[]{"FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"}));

    /* renamed from: F */
    private static final HashMap<Integer, Integer> f3198F = new HashMap<>();

    /* renamed from: X */
    private static final Pattern f3199X = Pattern.compile(".*[1-9].*");

    /* renamed from: Y */
    private static final Pattern f3200Y = Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");

    /* renamed from: a */
    public static final int[] f3201a = {8, 8, 8};

    /* renamed from: b */
    public static final int[] f3202b = {4};

    /* renamed from: c */
    public static final int[] f3203c = {8};

    /* renamed from: d */
    static final byte[] f3204d = {-1, Code.FIXEXT16, -1};

    /* renamed from: e */
    static final String[] f3205e = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE"};

    /* renamed from: f */
    static final int[] f3206f = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};

    /* renamed from: g */
    static final byte[] f3207g = {65, 83, 67, 73, 73, 0, 0, 0};

    /* renamed from: h */
    static final C1039c[][] f3208h = {f3216p, f3217q, f3218r, f3219s, f3220t, f3216p, f3222v, f3223w, f3224x, f3225y};

    /* renamed from: i */
    static final Charset f3209i = Charset.forName("US-ASCII");

    /* renamed from: j */
    static final byte[] f3210j = "Exif\u0000\u0000".getBytes(f3209i);

    /* renamed from: k */
    private static final List<Integer> f3211k = Arrays.asList(new Integer[]{Integer.valueOf(1), Integer.valueOf(6), Integer.valueOf(3), Integer.valueOf(8)});

    /* renamed from: l */
    private static final List<Integer> f3212l = Arrays.asList(new Integer[]{Integer.valueOf(2), Integer.valueOf(7), Integer.valueOf(4), Integer.valueOf(5)});

    /* renamed from: m */
    private static final byte[] f3213m = {79, 76, 89, 77, 80, 0};

    /* renamed from: n */
    private static final byte[] f3214n = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};

    /* renamed from: o */
    private static SimpleDateFormat f3215o = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");

    /* renamed from: p */
    private static final C1039c[] f3216p = {new C1039c("NewSubfileType", 254, 4), new C1039c("SubfileType", 255, 4), new C1039c("ImageWidth", 256, 3, 4), new C1039c("ImageLength", 257, 3, 4), new C1039c("BitsPerSample", 258, 3), new C1039c("Compression", 259, 3), new C1039c("PhotometricInterpretation", 262, 3), new C1039c("ImageDescription", 270, 2), new C1039c("Make", 271, 2), new C1039c("Model", 272, 2), new C1039c("StripOffsets", 273, 3, 4), new C1039c("Orientation", 274, 3), new C1039c("SamplesPerPixel", 277, 3), new C1039c("RowsPerStrip", 278, 3, 4), new C1039c("StripByteCounts", 279, 3, 4), new C1039c("XResolution", 282, 5), new C1039c("YResolution", 283, 5), new C1039c("PlanarConfiguration", 284, 3), new C1039c("ResolutionUnit", 296, 3), new C1039c("TransferFunction", HttpStatusCodes.STATUS_CODE_MOVED_PERMANENTLY, 3), new C1039c("Software", 305, 2), new C1039c("DateTime", 306, 2), new C1039c("Artist", 315, 2), new C1039c("WhitePoint", 318, 5), new C1039c("PrimaryChromaticities", 319, 5), new C1039c("SubIFDPointer", 330, 4), new C1039c("JPEGInterchangeFormat", 513, 4), new C1039c("JPEGInterchangeFormatLength", 514, 4), new C1039c("YCbCrCoefficients", 529, 5), new C1039c("YCbCrSubSampling", 530, 3), new C1039c("YCbCrPositioning", 531, 3), new C1039c("ReferenceBlackWhite", 532, 5), new C1039c("Copyright", 33432, 2), new C1039c("ExifIFDPointer", 34665, 4), new C1039c("GPSInfoIFDPointer", 34853, 4), new C1039c("SensorTopBorder", 4, 4), new C1039c("SensorLeftBorder", 5, 4), new C1039c("SensorBottomBorder", 6, 4), new C1039c("SensorRightBorder", 7, 4), new C1039c("ISO", 23, 3), new C1039c("JpgFromRaw", 46, 7)};

    /* renamed from: q */
    private static final C1039c[] f3217q = {new C1039c("ExposureTime", 33434, 5), new C1039c("FNumber", 33437, 5), new C1039c("ExposureProgram", 34850, 3), new C1039c("SpectralSensitivity", 34852, 2), new C1039c("PhotographicSensitivity", 34855, 3), new C1039c("OECF", 34856, 7), new C1039c("ExifVersion", 36864, 2), new C1039c("DateTimeOriginal", 36867, 2), new C1039c("DateTimeDigitized", 36868, 2), new C1039c("ComponentsConfiguration", 37121, 7), new C1039c("CompressedBitsPerPixel", 37122, 5), new C1039c("ShutterSpeedValue", 37377, 10), new C1039c("ApertureValue", 37378, 5), new C1039c("BrightnessValue", 37379, 10), new C1039c("ExposureBiasValue", 37380, 10), new C1039c("MaxApertureValue", 37381, 5), new C1039c("SubjectDistance", 37382, 5), new C1039c("MeteringMode", 37383, 3), new C1039c("LightSource", 37384, 3), new C1039c("Flash", 37385, 3), new C1039c("FocalLength", 37386, 5), new C1039c("SubjectArea", 37396, 3), new C1039c("MakerNote", 37500, 7), new C1039c("UserComment", 37510, 7), new C1039c("SubSecTime", 37520, 2), new C1039c("SubSecTimeOriginal", 37521, 2), new C1039c("SubSecTimeDigitized", 37522, 2), new C1039c("FlashpixVersion", 40960, 7), new C1039c("ColorSpace", 40961, 3), new C1039c("PixelXDimension", 40962, 3, 4), new C1039c("PixelYDimension", 40963, 3, 4), new C1039c("RelatedSoundFile", 40964, 2), new C1039c("InteroperabilityIFDPointer", 40965, 4), new C1039c("FlashEnergy", 41483, 5), new C1039c("SpatialFrequencyResponse", 41484, 7), new C1039c("FocalPlaneXResolution", 41486, 5), new C1039c("FocalPlaneYResolution", 41487, 5), new C1039c("FocalPlaneResolutionUnit", 41488, 3), new C1039c("SubjectLocation", 41492, 3), new C1039c("ExposureIndex", 41493, 5), new C1039c("SensingMethod", 41495, 3), new C1039c("FileSource", 41728, 7), new C1039c("SceneType", 41729, 7), new C1039c("CFAPattern", 41730, 7), new C1039c("CustomRendered", 41985, 3), new C1039c("ExposureMode", 41986, 3), new C1039c("WhiteBalance", 41987, 3), new C1039c("DigitalZoomRatio", 41988, 5), new C1039c("FocalLengthIn35mmFilm", 41989, 3), new C1039c("SceneCaptureType", 41990, 3), new C1039c("GainControl", 41991, 3), new C1039c("Contrast", 41992, 3), new C1039c("Saturation", 41993, 3), new C1039c("Sharpness", 41994, 3), new C1039c("DeviceSettingDescription", 41995, 7), new C1039c("SubjectDistanceRange", 41996, 3), new C1039c("ImageUniqueID", 42016, 2), new C1039c("DNGVersion", 50706, 1), new C1039c("DefaultCropSize", 50720, 3, 4)};

    /* renamed from: r */
    private static final C1039c[] f3218r = {new C1039c("GPSVersionID", 0, 1), new C1039c("GPSLatitudeRef", 1, 2), new C1039c("GPSLatitude", 2, 5), new C1039c("GPSLongitudeRef", 3, 2), new C1039c("GPSLongitude", 4, 5), new C1039c("GPSAltitudeRef", 5, 1), new C1039c("GPSAltitude", 6, 5), new C1039c("GPSTimeStamp", 7, 5), new C1039c("GPSSatellites", 8, 2), new C1039c("GPSStatus", 9, 2), new C1039c("GPSMeasureMode", 10, 2), new C1039c("GPSDOP", 11, 5), new C1039c("GPSSpeedRef", 12, 2), new C1039c("GPSSpeed", 13, 5), new C1039c("GPSTrackRef", 14, 2), new C1039c("GPSTrack", 15, 5), new C1039c("GPSImgDirectionRef", 16, 2), new C1039c("GPSImgDirection", 17, 5), new C1039c("GPSMapDatum", 18, 2), new C1039c("GPSDestLatitudeRef", 19, 2), new C1039c("GPSDestLatitude", 20, 5), new C1039c("GPSDestLongitudeRef", 21, 2), new C1039c("GPSDestLongitude", 22, 5), new C1039c("GPSDestBearingRef", 23, 2), new C1039c("GPSDestBearing", 24, 5), new C1039c("GPSDestDistanceRef", 25, 2), new C1039c("GPSDestDistance", 26, 5), new C1039c("GPSProcessingMethod", 27, 7), new C1039c("GPSAreaInformation", 28, 7), new C1039c("GPSDateStamp", 29, 2), new C1039c("GPSDifferential", 30, 3)};

    /* renamed from: s */
    private static final C1039c[] f3219s = {new C1039c("InteroperabilityIndex", 1, 2)};

    /* renamed from: t */
    private static final C1039c[] f3220t = {new C1039c("NewSubfileType", 254, 4), new C1039c("SubfileType", 255, 4), new C1039c("ThumbnailImageWidth", 256, 3, 4), new C1039c("ThumbnailImageLength", 257, 3, 4), new C1039c("BitsPerSample", 258, 3), new C1039c("Compression", 259, 3), new C1039c("PhotometricInterpretation", 262, 3), new C1039c("ImageDescription", 270, 2), new C1039c("Make", 271, 2), new C1039c("Model", 272, 2), new C1039c("StripOffsets", 273, 3, 4), new C1039c("Orientation", 274, 3), new C1039c("SamplesPerPixel", 277, 3), new C1039c("RowsPerStrip", 278, 3, 4), new C1039c("StripByteCounts", 279, 3, 4), new C1039c("XResolution", 282, 5), new C1039c("YResolution", 283, 5), new C1039c("PlanarConfiguration", 284, 3), new C1039c("ResolutionUnit", 296, 3), new C1039c("TransferFunction", HttpStatusCodes.STATUS_CODE_MOVED_PERMANENTLY, 3), new C1039c("Software", 305, 2), new C1039c("DateTime", 306, 2), new C1039c("Artist", 315, 2), new C1039c("WhitePoint", 318, 5), new C1039c("PrimaryChromaticities", 319, 5), new C1039c("SubIFDPointer", 330, 4), new C1039c("JPEGInterchangeFormat", 513, 4), new C1039c("JPEGInterchangeFormatLength", 514, 4), new C1039c("YCbCrCoefficients", 529, 5), new C1039c("YCbCrSubSampling", 530, 3), new C1039c("YCbCrPositioning", 531, 3), new C1039c("ReferenceBlackWhite", 532, 5), new C1039c("Copyright", 33432, 2), new C1039c("ExifIFDPointer", 34665, 4), new C1039c("GPSInfoIFDPointer", 34853, 4), new C1039c("DNGVersion", 50706, 1), new C1039c("DefaultCropSize", 50720, 3, 4)};

    /* renamed from: u */
    private static final C1039c f3221u = new C1039c("StripOffsets", 273, 3);

    /* renamed from: v */
    private static final C1039c[] f3222v = {new C1039c("ThumbnailImage", 256, 7), new C1039c("CameraSettingsIFDPointer", 8224, 4), new C1039c("ImageProcessingIFDPointer", 8256, 4)};

    /* renamed from: w */
    private static final C1039c[] f3223w = {new C1039c("PreviewImageStart", 257, 4), new C1039c("PreviewImageLength", 258, 4)};

    /* renamed from: x */
    private static final C1039c[] f3224x = {new C1039c("AspectFrame", 4371, 3)};

    /* renamed from: y */
    private static final C1039c[] f3225y = {new C1039c("ColorSpace", 55, 3)};

    /* renamed from: z */
    private static final C1039c[] f3226z = {new C1039c("SubIFDPointer", 330, 4), new C1039c("ExifIFDPointer", 34665, 4), new C1039c("GPSInfoIFDPointer", 34853, 4), new C1039c("InteroperabilityIFDPointer", 40965, 4), new C1039c("CameraSettingsIFDPointer", 8224, 1), new C1039c("ImageProcessingIFDPointer", 8256, 1)};

    /* renamed from: G */
    private final String f3227G;

    /* renamed from: H */
    private final AssetInputStream f3228H;

    /* renamed from: I */
    private int f3229I;

    /* renamed from: J */
    private final HashMap<String, C1038b>[] f3230J = new HashMap[f3208h.length];

    /* renamed from: K */
    private Set<Integer> f3231K = new HashSet(f3208h.length);

    /* renamed from: L */
    private ByteOrder f3232L = ByteOrder.BIG_ENDIAN;

    /* renamed from: M */
    private boolean f3233M;

    /* renamed from: N */
    private int f3234N;

    /* renamed from: O */
    private int f3235O;

    /* renamed from: P */
    private byte[] f3236P;

    /* renamed from: Q */
    private int f3237Q;

    /* renamed from: R */
    private int f3238R;

    /* renamed from: S */
    private int f3239S;

    /* renamed from: T */
    private int f3240T;

    /* renamed from: U */
    private int f3241U;

    /* renamed from: V */
    private int f3242V;

    /* renamed from: W */
    private boolean f3243W;

    /* renamed from: androidx.d.a.a$a */
    /* compiled from: ExifInterface */
    private static class C1037a extends InputStream implements DataInput {

        /* renamed from: c */
        private static final ByteOrder f3244c = ByteOrder.LITTLE_ENDIAN;

        /* renamed from: d */
        private static final ByteOrder f3245d = ByteOrder.BIG_ENDIAN;

        /* renamed from: a */
        final int f3246a;

        /* renamed from: b */
        int f3247b;

        /* renamed from: e */
        private DataInputStream f3248e;

        /* renamed from: f */
        private ByteOrder f3249f;

        public C1037a(InputStream inputStream) throws IOException {
            this.f3249f = ByteOrder.BIG_ENDIAN;
            this.f3248e = new DataInputStream(inputStream);
            this.f3246a = this.f3248e.available();
            this.f3247b = 0;
            this.f3248e.mark(this.f3246a);
        }

        public C1037a(byte[] bArr) throws IOException {
            this((InputStream) new ByteArrayInputStream(bArr));
        }

        /* renamed from: a */
        public void mo4028a(ByteOrder byteOrder) {
            this.f3249f = byteOrder;
        }

        /* renamed from: a */
        public void mo4027a(long j) throws IOException {
            if (((long) this.f3247b) > j) {
                this.f3247b = 0;
                this.f3248e.reset();
                this.f3248e.mark(this.f3246a);
            } else {
                j -= (long) this.f3247b;
            }
            int i = (int) j;
            if (skipBytes(i) != i) {
                throw new IOException("Couldn't seek up to the byteCount");
            }
        }

        /* renamed from: a */
        public int mo4026a() {
            return this.f3247b;
        }

        public int available() throws IOException {
            return this.f3248e.available();
        }

        public int read() throws IOException {
            this.f3247b++;
            return this.f3248e.read();
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            int read = this.f3248e.read(bArr, i, i2);
            this.f3247b += read;
            return read;
        }

        public int readUnsignedByte() throws IOException {
            this.f3247b++;
            return this.f3248e.readUnsignedByte();
        }

        public String readLine() throws IOException {
            Log.d("ExifInterface", "Currently unsupported");
            return null;
        }

        public boolean readBoolean() throws IOException {
            this.f3247b++;
            return this.f3248e.readBoolean();
        }

        public char readChar() throws IOException {
            this.f3247b += 2;
            return this.f3248e.readChar();
        }

        public String readUTF() throws IOException {
            this.f3247b += 2;
            return this.f3248e.readUTF();
        }

        public void readFully(byte[] bArr, int i, int i2) throws IOException {
            this.f3247b += i2;
            if (this.f3247b > this.f3246a) {
                throw new EOFException();
            } else if (this.f3248e.read(bArr, i, i2) != i2) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        public void readFully(byte[] bArr) throws IOException {
            this.f3247b += bArr.length;
            if (this.f3247b > this.f3246a) {
                throw new EOFException();
            } else if (this.f3248e.read(bArr, 0, bArr.length) != bArr.length) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        public byte readByte() throws IOException {
            this.f3247b++;
            if (this.f3247b <= this.f3246a) {
                int read = this.f3248e.read();
                if (read >= 0) {
                    return (byte) read;
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public short readShort() throws IOException {
            this.f3247b += 2;
            if (this.f3247b <= this.f3246a) {
                int read = this.f3248e.read();
                int read2 = this.f3248e.read();
                if ((read | read2) < 0) {
                    throw new EOFException();
                } else if (this.f3249f == f3244c) {
                    return (short) ((read2 << 8) + read);
                } else {
                    if (this.f3249f == f3245d) {
                        return (short) ((read << 8) + read2);
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("Invalid byte order: ");
                    sb.append(this.f3249f);
                    throw new IOException(sb.toString());
                }
            } else {
                throw new EOFException();
            }
        }

        public int readInt() throws IOException {
            this.f3247b += 4;
            if (this.f3247b <= this.f3246a) {
                int read = this.f3248e.read();
                int read2 = this.f3248e.read();
                int read3 = this.f3248e.read();
                int read4 = this.f3248e.read();
                if ((read | read2 | read3 | read4) < 0) {
                    throw new EOFException();
                } else if (this.f3249f == f3244c) {
                    return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                } else {
                    if (this.f3249f == f3245d) {
                        return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("Invalid byte order: ");
                    sb.append(this.f3249f);
                    throw new IOException(sb.toString());
                }
            } else {
                throw new EOFException();
            }
        }

        public int skipBytes(int i) throws IOException {
            int min = Math.min(i, this.f3246a - this.f3247b);
            int i2 = 0;
            while (i2 < min) {
                i2 += this.f3248e.skipBytes(min - i2);
            }
            this.f3247b += i2;
            return i2;
        }

        public int readUnsignedShort() throws IOException {
            this.f3247b += 2;
            if (this.f3247b <= this.f3246a) {
                int read = this.f3248e.read();
                int read2 = this.f3248e.read();
                if ((read | read2) < 0) {
                    throw new EOFException();
                } else if (this.f3249f == f3244c) {
                    return (read2 << 8) + read;
                } else {
                    if (this.f3249f == f3245d) {
                        return (read << 8) + read2;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("Invalid byte order: ");
                    sb.append(this.f3249f);
                    throw new IOException(sb.toString());
                }
            } else {
                throw new EOFException();
            }
        }

        /* renamed from: b */
        public long mo4030b() throws IOException {
            return ((long) readInt()) & 4294967295L;
        }

        public long readLong() throws IOException {
            this.f3247b += 8;
            if (this.f3247b <= this.f3246a) {
                int read = this.f3248e.read();
                int read2 = this.f3248e.read();
                int read3 = this.f3248e.read();
                int read4 = this.f3248e.read();
                int read5 = this.f3248e.read();
                int read6 = this.f3248e.read();
                int read7 = this.f3248e.read();
                int read8 = this.f3248e.read();
                if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) < 0) {
                    throw new EOFException();
                } else if (this.f3249f == f3244c) {
                    return (((long) read8) << 56) + (((long) read7) << 48) + (((long) read6) << 40) + (((long) read5) << 32) + (((long) read4) << 24) + (((long) read3) << 16) + (((long) read2) << 8) + ((long) read);
                } else {
                    int i = read2;
                    if (this.f3249f == f3245d) {
                        return (((long) read) << 56) + (((long) i) << 48) + (((long) read3) << 40) + (((long) read4) << 32) + (((long) read5) << 24) + (((long) read6) << 16) + (((long) read7) << 8) + ((long) read8);
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("Invalid byte order: ");
                    sb.append(this.f3249f);
                    throw new IOException(sb.toString());
                }
            } else {
                throw new EOFException();
            }
        }

        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readInt());
        }

        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readLong());
        }
    }

    /* renamed from: androidx.d.a.a$b */
    /* compiled from: ExifInterface */
    private static class C1038b {

        /* renamed from: a */
        public final int f3250a;

        /* renamed from: b */
        public final int f3251b;

        /* renamed from: c */
        public final byte[] f3252c;

        C1038b(int i, int i2, byte[] bArr) {
            this.f3250a = i;
            this.f3251b = i2;
            this.f3252c = bArr;
        }

        /* renamed from: a */
        public static C1038b m3987a(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(C1036a.f3206f[3] * iArr.length)]);
            wrap.order(byteOrder);
            for (int i : iArr) {
                wrap.putShort((short) i);
            }
            return new C1038b(3, iArr.length, wrap.array());
        }

        /* renamed from: a */
        public static C1038b m3983a(int i, ByteOrder byteOrder) {
            return m3987a(new int[]{i}, byteOrder);
        }

        /* renamed from: a */
        public static C1038b m3988a(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(C1036a.f3206f[4] * jArr.length)]);
            wrap.order(byteOrder);
            for (long j : jArr) {
                wrap.putInt((int) j);
            }
            return new C1038b(4, jArr.length, wrap.array());
        }

        /* renamed from: a */
        public static C1038b m3984a(long j, ByteOrder byteOrder) {
            return m3988a(new long[]{j}, byteOrder);
        }

        /* renamed from: a */
        public static C1038b m3986a(String str) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(0);
            byte[] bytes = sb.toString().getBytes(C1036a.f3209i);
            return new C1038b(2, bytes.length, bytes);
        }

        /* renamed from: a */
        public static C1038b m3989a(C1040d[] dVarArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(C1036a.f3206f[5] * dVarArr.length)]);
            wrap.order(byteOrder);
            for (C1040d dVar : dVarArr) {
                wrap.putInt((int) dVar.f3257a);
                wrap.putInt((int) dVar.f3258b);
            }
            return new C1038b(5, dVarArr.length, wrap.array());
        }

        /* renamed from: a */
        public static C1038b m3985a(C1040d dVar, ByteOrder byteOrder) {
            return m3989a(new C1040d[]{dVar}, byteOrder);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append(C1036a.f3205e[this.f3250a]);
            sb.append(", data length:");
            sb.append(this.f3252c.length);
            sb.append(")");
            return sb.toString();
        }

        /* access modifiers changed from: 0000 */
        /* JADX WARNING: Removed duplicated region for block: B:164:0x01dd A[SYNTHETIC, Splitter:B:164:0x01dd] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object mo4048a(java.nio.ByteOrder r9) {
            /*
                r8 = this;
                r0 = 0
                androidx.d.a.a$a r1 = new androidx.d.a.a$a     // Catch:{ IOException -> 0x01c2, all -> 0x01bf }
                byte[] r2 = r8.f3252c     // Catch:{ IOException -> 0x01c2, all -> 0x01bf }
                r1.<init>(r2)     // Catch:{ IOException -> 0x01c2, all -> 0x01bf }
                r1.mo4028a(r9)     // Catch:{ IOException -> 0x01bd }
                int r9 = r8.f3250a     // Catch:{ IOException -> 0x01bd }
                r2 = 1
                r3 = 0
                switch(r9) {
                    case 1: goto L_0x016c;
                    case 2: goto L_0x0119;
                    case 3: goto L_0x00fb;
                    case 4: goto L_0x00dd;
                    case 5: goto L_0x00b6;
                    case 6: goto L_0x016c;
                    case 7: goto L_0x0119;
                    case 8: goto L_0x0098;
                    case 9: goto L_0x007a;
                    case 10: goto L_0x0051;
                    case 11: goto L_0x0032;
                    case 12: goto L_0x0014;
                    default: goto L_0x0012;
                }     // Catch:{ IOException -> 0x01bd }
            L_0x0012:
                goto L_0x01b0
            L_0x0014:
                int r9 = r8.f3251b     // Catch:{ IOException -> 0x01bd }
                double[] r9 = new double[r9]     // Catch:{ IOException -> 0x01bd }
            L_0x0018:
                int r2 = r8.f3251b     // Catch:{ IOException -> 0x01bd }
                if (r3 >= r2) goto L_0x0025
                double r4 = r1.readDouble()     // Catch:{ IOException -> 0x01bd }
                r9[r3] = r4     // Catch:{ IOException -> 0x01bd }
                int r3 = r3 + 1
                goto L_0x0018
            L_0x0025:
                r1.close()     // Catch:{ IOException -> 0x0029 }
                goto L_0x0031
            L_0x0029:
                r0 = move-exception
                java.lang.String r1 = "ExifInterface"
                java.lang.String r2 = "IOException occurred while closing InputStream"
                android.util.Log.e(r1, r2, r0)
            L_0x0031:
                return r9
            L_0x0032:
                int r9 = r8.f3251b     // Catch:{ IOException -> 0x01bd }
                double[] r9 = new double[r9]     // Catch:{ IOException -> 0x01bd }
            L_0x0036:
                int r2 = r8.f3251b     // Catch:{ IOException -> 0x01bd }
                if (r3 >= r2) goto L_0x0044
                float r2 = r1.readFloat()     // Catch:{ IOException -> 0x01bd }
                double r4 = (double) r2     // Catch:{ IOException -> 0x01bd }
                r9[r3] = r4     // Catch:{ IOException -> 0x01bd }
                int r3 = r3 + 1
                goto L_0x0036
            L_0x0044:
                r1.close()     // Catch:{ IOException -> 0x0048 }
                goto L_0x0050
            L_0x0048:
                r0 = move-exception
                java.lang.String r1 = "ExifInterface"
                java.lang.String r2 = "IOException occurred while closing InputStream"
                android.util.Log.e(r1, r2, r0)
            L_0x0050:
                return r9
            L_0x0051:
                int r9 = r8.f3251b     // Catch:{ IOException -> 0x01bd }
                androidx.d.a.a$d[] r9 = new androidx.p074d.p075a.C1036a.C1040d[r9]     // Catch:{ IOException -> 0x01bd }
            L_0x0055:
                int r2 = r8.f3251b     // Catch:{ IOException -> 0x01bd }
                if (r3 >= r2) goto L_0x006d
                int r2 = r1.readInt()     // Catch:{ IOException -> 0x01bd }
                long r4 = (long) r2     // Catch:{ IOException -> 0x01bd }
                int r2 = r1.readInt()     // Catch:{ IOException -> 0x01bd }
                long r6 = (long) r2     // Catch:{ IOException -> 0x01bd }
                androidx.d.a.a$d r2 = new androidx.d.a.a$d     // Catch:{ IOException -> 0x01bd }
                r2.<init>(r4, r6)     // Catch:{ IOException -> 0x01bd }
                r9[r3] = r2     // Catch:{ IOException -> 0x01bd }
                int r3 = r3 + 1
                goto L_0x0055
            L_0x006d:
                r1.close()     // Catch:{ IOException -> 0x0071 }
                goto L_0x0079
            L_0x0071:
                r0 = move-exception
                java.lang.String r1 = "ExifInterface"
                java.lang.String r2 = "IOException occurred while closing InputStream"
                android.util.Log.e(r1, r2, r0)
            L_0x0079:
                return r9
            L_0x007a:
                int r9 = r8.f3251b     // Catch:{ IOException -> 0x01bd }
                int[] r9 = new int[r9]     // Catch:{ IOException -> 0x01bd }
            L_0x007e:
                int r2 = r8.f3251b     // Catch:{ IOException -> 0x01bd }
                if (r3 >= r2) goto L_0x008b
                int r2 = r1.readInt()     // Catch:{ IOException -> 0x01bd }
                r9[r3] = r2     // Catch:{ IOException -> 0x01bd }
                int r3 = r3 + 1
                goto L_0x007e
            L_0x008b:
                r1.close()     // Catch:{ IOException -> 0x008f }
                goto L_0x0097
            L_0x008f:
                r0 = move-exception
                java.lang.String r1 = "ExifInterface"
                java.lang.String r2 = "IOException occurred while closing InputStream"
                android.util.Log.e(r1, r2, r0)
            L_0x0097:
                return r9
            L_0x0098:
                int r9 = r8.f3251b     // Catch:{ IOException -> 0x01bd }
                int[] r9 = new int[r9]     // Catch:{ IOException -> 0x01bd }
            L_0x009c:
                int r2 = r8.f3251b     // Catch:{ IOException -> 0x01bd }
                if (r3 >= r2) goto L_0x00a9
                short r2 = r1.readShort()     // Catch:{ IOException -> 0x01bd }
                r9[r3] = r2     // Catch:{ IOException -> 0x01bd }
                int r3 = r3 + 1
                goto L_0x009c
            L_0x00a9:
                r1.close()     // Catch:{ IOException -> 0x00ad }
                goto L_0x00b5
            L_0x00ad:
                r0 = move-exception
                java.lang.String r1 = "ExifInterface"
                java.lang.String r2 = "IOException occurred while closing InputStream"
                android.util.Log.e(r1, r2, r0)
            L_0x00b5:
                return r9
            L_0x00b6:
                int r9 = r8.f3251b     // Catch:{ IOException -> 0x01bd }
                androidx.d.a.a$d[] r9 = new androidx.p074d.p075a.C1036a.C1040d[r9]     // Catch:{ IOException -> 0x01bd }
            L_0x00ba:
                int r2 = r8.f3251b     // Catch:{ IOException -> 0x01bd }
                if (r3 >= r2) goto L_0x00d0
                long r4 = r1.mo4030b()     // Catch:{ IOException -> 0x01bd }
                long r6 = r1.mo4030b()     // Catch:{ IOException -> 0x01bd }
                androidx.d.a.a$d r2 = new androidx.d.a.a$d     // Catch:{ IOException -> 0x01bd }
                r2.<init>(r4, r6)     // Catch:{ IOException -> 0x01bd }
                r9[r3] = r2     // Catch:{ IOException -> 0x01bd }
                int r3 = r3 + 1
                goto L_0x00ba
            L_0x00d0:
                r1.close()     // Catch:{ IOException -> 0x00d4 }
                goto L_0x00dc
            L_0x00d4:
                r0 = move-exception
                java.lang.String r1 = "ExifInterface"
                java.lang.String r2 = "IOException occurred while closing InputStream"
                android.util.Log.e(r1, r2, r0)
            L_0x00dc:
                return r9
            L_0x00dd:
                int r9 = r8.f3251b     // Catch:{ IOException -> 0x01bd }
                long[] r9 = new long[r9]     // Catch:{ IOException -> 0x01bd }
            L_0x00e1:
                int r2 = r8.f3251b     // Catch:{ IOException -> 0x01bd }
                if (r3 >= r2) goto L_0x00ee
                long r4 = r1.mo4030b()     // Catch:{ IOException -> 0x01bd }
                r9[r3] = r4     // Catch:{ IOException -> 0x01bd }
                int r3 = r3 + 1
                goto L_0x00e1
            L_0x00ee:
                r1.close()     // Catch:{ IOException -> 0x00f2 }
                goto L_0x00fa
            L_0x00f2:
                r0 = move-exception
                java.lang.String r1 = "ExifInterface"
                java.lang.String r2 = "IOException occurred while closing InputStream"
                android.util.Log.e(r1, r2, r0)
            L_0x00fa:
                return r9
            L_0x00fb:
                int r9 = r8.f3251b     // Catch:{ IOException -> 0x01bd }
                int[] r9 = new int[r9]     // Catch:{ IOException -> 0x01bd }
            L_0x00ff:
                int r2 = r8.f3251b     // Catch:{ IOException -> 0x01bd }
                if (r3 >= r2) goto L_0x010c
                int r2 = r1.readUnsignedShort()     // Catch:{ IOException -> 0x01bd }
                r9[r3] = r2     // Catch:{ IOException -> 0x01bd }
                int r3 = r3 + 1
                goto L_0x00ff
            L_0x010c:
                r1.close()     // Catch:{ IOException -> 0x0110 }
                goto L_0x0118
            L_0x0110:
                r0 = move-exception
                java.lang.String r1 = "ExifInterface"
                java.lang.String r2 = "IOException occurred while closing InputStream"
                android.util.Log.e(r1, r2, r0)
            L_0x0118:
                return r9
            L_0x0119:
                int r9 = r8.f3251b     // Catch:{ IOException -> 0x01bd }
                byte[] r4 = androidx.p074d.p075a.C1036a.f3207g     // Catch:{ IOException -> 0x01bd }
                int r4 = r4.length     // Catch:{ IOException -> 0x01bd }
                if (r9 < r4) goto L_0x013a
                r9 = 0
            L_0x0121:
                byte[] r4 = androidx.p074d.p075a.C1036a.f3207g     // Catch:{ IOException -> 0x01bd }
                int r4 = r4.length     // Catch:{ IOException -> 0x01bd }
                if (r9 >= r4) goto L_0x0135
                byte[] r4 = r8.f3252c     // Catch:{ IOException -> 0x01bd }
                byte r4 = r4[r9]     // Catch:{ IOException -> 0x01bd }
                byte[] r5 = androidx.p074d.p075a.C1036a.f3207g     // Catch:{ IOException -> 0x01bd }
                byte r5 = r5[r9]     // Catch:{ IOException -> 0x01bd }
                if (r4 == r5) goto L_0x0132
                r2 = 0
                goto L_0x0135
            L_0x0132:
                int r9 = r9 + 1
                goto L_0x0121
            L_0x0135:
                if (r2 == 0) goto L_0x013a
                byte[] r9 = androidx.p074d.p075a.C1036a.f3207g     // Catch:{ IOException -> 0x01bd }
                int r3 = r9.length     // Catch:{ IOException -> 0x01bd }
            L_0x013a:
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01bd }
                r9.<init>()     // Catch:{ IOException -> 0x01bd }
            L_0x013f:
                int r2 = r8.f3251b     // Catch:{ IOException -> 0x01bd }
                if (r3 >= r2) goto L_0x015b
                byte[] r2 = r8.f3252c     // Catch:{ IOException -> 0x01bd }
                byte r2 = r2[r3]     // Catch:{ IOException -> 0x01bd }
                if (r2 != 0) goto L_0x014a
                goto L_0x015b
            L_0x014a:
                r4 = 32
                if (r2 < r4) goto L_0x0153
                char r2 = (char) r2     // Catch:{ IOException -> 0x01bd }
                r9.append(r2)     // Catch:{ IOException -> 0x01bd }
                goto L_0x0158
            L_0x0153:
                r2 = 63
                r9.append(r2)     // Catch:{ IOException -> 0x01bd }
            L_0x0158:
                int r3 = r3 + 1
                goto L_0x013f
            L_0x015b:
                java.lang.String r9 = r9.toString()     // Catch:{ IOException -> 0x01bd }
                r1.close()     // Catch:{ IOException -> 0x0163 }
                goto L_0x016b
            L_0x0163:
                r0 = move-exception
                java.lang.String r1 = "ExifInterface"
                java.lang.String r2 = "IOException occurred while closing InputStream"
                android.util.Log.e(r1, r2, r0)
            L_0x016b:
                return r9
            L_0x016c:
                byte[] r9 = r8.f3252c     // Catch:{ IOException -> 0x01bd }
                int r9 = r9.length     // Catch:{ IOException -> 0x01bd }
                if (r9 != r2) goto L_0x019a
                byte[] r9 = r8.f3252c     // Catch:{ IOException -> 0x01bd }
                byte r9 = r9[r3]     // Catch:{ IOException -> 0x01bd }
                if (r9 < 0) goto L_0x019a
                byte[] r9 = r8.f3252c     // Catch:{ IOException -> 0x01bd }
                byte r9 = r9[r3]     // Catch:{ IOException -> 0x01bd }
                if (r9 > r2) goto L_0x019a
                java.lang.String r9 = new java.lang.String     // Catch:{ IOException -> 0x01bd }
                char[] r2 = new char[r2]     // Catch:{ IOException -> 0x01bd }
                byte[] r4 = r8.f3252c     // Catch:{ IOException -> 0x01bd }
                byte r4 = r4[r3]     // Catch:{ IOException -> 0x01bd }
                int r4 = r4 + 48
                char r4 = (char) r4     // Catch:{ IOException -> 0x01bd }
                r2[r3] = r4     // Catch:{ IOException -> 0x01bd }
                r9.<init>(r2)     // Catch:{ IOException -> 0x01bd }
                r1.close()     // Catch:{ IOException -> 0x0191 }
                goto L_0x0199
            L_0x0191:
                r0 = move-exception
                java.lang.String r1 = "ExifInterface"
                java.lang.String r2 = "IOException occurred while closing InputStream"
                android.util.Log.e(r1, r2, r0)
            L_0x0199:
                return r9
            L_0x019a:
                java.lang.String r9 = new java.lang.String     // Catch:{ IOException -> 0x01bd }
                byte[] r2 = r8.f3252c     // Catch:{ IOException -> 0x01bd }
                java.nio.charset.Charset r3 = androidx.p074d.p075a.C1036a.f3209i     // Catch:{ IOException -> 0x01bd }
                r9.<init>(r2, r3)     // Catch:{ IOException -> 0x01bd }
                r1.close()     // Catch:{ IOException -> 0x01a7 }
                goto L_0x01af
            L_0x01a7:
                r0 = move-exception
                java.lang.String r1 = "ExifInterface"
                java.lang.String r2 = "IOException occurred while closing InputStream"
                android.util.Log.e(r1, r2, r0)
            L_0x01af:
                return r9
            L_0x01b0:
                r1.close()     // Catch:{ IOException -> 0x01b4 }
                goto L_0x01bc
            L_0x01b4:
                r9 = move-exception
                java.lang.String r1 = "ExifInterface"
                java.lang.String r2 = "IOException occurred while closing InputStream"
                android.util.Log.e(r1, r2, r9)
            L_0x01bc:
                return r0
            L_0x01bd:
                r9 = move-exception
                goto L_0x01c4
            L_0x01bf:
                r9 = move-exception
                r1 = r0
                goto L_0x01db
            L_0x01c2:
                r9 = move-exception
                r1 = r0
            L_0x01c4:
                java.lang.String r2 = "ExifInterface"
                java.lang.String r3 = "IOException occurred during reading a value"
                android.util.Log.w(r2, r3, r9)     // Catch:{ all -> 0x01da }
                if (r1 == 0) goto L_0x01d9
                r1.close()     // Catch:{ IOException -> 0x01d1 }
                goto L_0x01d9
            L_0x01d1:
                r9 = move-exception
                java.lang.String r1 = "ExifInterface"
                java.lang.String r2 = "IOException occurred while closing InputStream"
                android.util.Log.e(r1, r2, r9)
            L_0x01d9:
                return r0
            L_0x01da:
                r9 = move-exception
            L_0x01db:
                if (r1 == 0) goto L_0x01e9
                r1.close()     // Catch:{ IOException -> 0x01e1 }
                goto L_0x01e9
            L_0x01e1:
                r0 = move-exception
                java.lang.String r1 = "ExifInterface"
                java.lang.String r2 = "IOException occurred while closing InputStream"
                android.util.Log.e(r1, r2, r0)
            L_0x01e9:
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.p074d.p075a.C1036a.C1038b.mo4048a(java.nio.ByteOrder):java.lang.Object");
        }

        /* renamed from: b */
        public double mo4049b(ByteOrder byteOrder) {
            Object a = mo4048a(byteOrder);
            if (a == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            } else if (a instanceof String) {
                return Double.parseDouble((String) a);
            } else {
                if (a instanceof long[]) {
                    long[] jArr = (long[]) a;
                    if (jArr.length == 1) {
                        return (double) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (a instanceof int[]) {
                    int[] iArr = (int[]) a;
                    if (iArr.length == 1) {
                        return (double) iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (a instanceof double[]) {
                    double[] dArr = (double[]) a;
                    if (dArr.length == 1) {
                        return dArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (a instanceof C1040d[]) {
                    C1040d[] dVarArr = (C1040d[]) a;
                    if (dVarArr.length == 1) {
                        return dVarArr[0].mo4054a();
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a double value");
                }
            }
        }

        /* renamed from: c */
        public int mo4050c(ByteOrder byteOrder) {
            Object a = mo4048a(byteOrder);
            if (a == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            } else if (a instanceof String) {
                return Integer.parseInt((String) a);
            } else {
                if (a instanceof long[]) {
                    long[] jArr = (long[]) a;
                    if (jArr.length == 1) {
                        return (int) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (a instanceof int[]) {
                    int[] iArr = (int[]) a;
                    if (iArr.length == 1) {
                        return iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a integer value");
                }
            }
        }

        /* renamed from: d */
        public String mo4051d(ByteOrder byteOrder) {
            Object a = mo4048a(byteOrder);
            if (a == null) {
                return null;
            }
            if (a instanceof String) {
                return (String) a;
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            if (a instanceof long[]) {
                long[] jArr = (long[]) a;
                while (i < jArr.length) {
                    sb.append(jArr[i]);
                    i++;
                    if (i != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (a instanceof int[]) {
                int[] iArr = (int[]) a;
                while (i < iArr.length) {
                    sb.append(iArr[i]);
                    i++;
                    if (i != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (a instanceof double[]) {
                double[] dArr = (double[]) a;
                while (i < dArr.length) {
                    sb.append(dArr[i]);
                    i++;
                    if (i != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (!(a instanceof C1040d[])) {
                return null;
            } else {
                C1040d[] dVarArr = (C1040d[]) a;
                while (i < dVarArr.length) {
                    sb.append(dVarArr[i].f3257a);
                    sb.append('/');
                    sb.append(dVarArr[i].f3258b);
                    i++;
                    if (i != dVarArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
        }
    }

    /* renamed from: androidx.d.a.a$c */
    /* compiled from: ExifInterface */
    static class C1039c {

        /* renamed from: a */
        public final int f3253a;

        /* renamed from: b */
        public final String f3254b;

        /* renamed from: c */
        public final int f3255c;

        /* renamed from: d */
        public final int f3256d;

        C1039c(String str, int i, int i2) {
            this.f3254b = str;
            this.f3253a = i;
            this.f3255c = i2;
            this.f3256d = -1;
        }

        C1039c(String str, int i, int i2, int i3) {
            this.f3254b = str;
            this.f3253a = i;
            this.f3255c = i2;
            this.f3256d = i3;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo4053a(int i) {
            if (this.f3255c == 7 || i == 7 || this.f3255c == i || this.f3256d == i) {
                return true;
            }
            if ((this.f3255c == 4 || this.f3256d == 4) && i == 3) {
                return true;
            }
            if ((this.f3255c == 9 || this.f3256d == 9) && i == 8) {
                return true;
            }
            if ((this.f3255c == 12 || this.f3256d == 12) && i == 11) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: androidx.d.a.a$d */
    /* compiled from: ExifInterface */
    private static class C1040d {

        /* renamed from: a */
        public final long f3257a;

        /* renamed from: b */
        public final long f3258b;

        C1040d(long j, long j2) {
            if (j2 == 0) {
                this.f3257a = 0;
                this.f3258b = 1;
                return;
            }
            this.f3257a = j;
            this.f3258b = j2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f3257a);
            sb.append("/");
            sb.append(this.f3258b);
            return sb.toString();
        }

        /* renamed from: a */
        public double mo4054a() {
            return ((double) this.f3257a) / ((double) this.f3258b);
        }
    }

    static {
        C1039c[] cVarArr;
        f3215o.setTimeZone(TimeZone.getTimeZone("UTC"));
        for (int i = 0; i < f3208h.length; i++) {
            f3195C[i] = new HashMap<>();
            f3196D[i] = new HashMap<>();
            for (C1039c cVar : f3208h[i]) {
                f3195C[i].put(Integer.valueOf(cVar.f3253a), cVar);
                f3196D[i].put(cVar.f3254b, cVar);
            }
        }
        f3198F.put(Integer.valueOf(f3226z[0].f3253a), Integer.valueOf(5));
        f3198F.put(Integer.valueOf(f3226z[1].f3253a), Integer.valueOf(1));
        f3198F.put(Integer.valueOf(f3226z[2].f3253a), Integer.valueOf(2));
        f3198F.put(Integer.valueOf(f3226z[3].f3253a), Integer.valueOf(3));
        f3198F.put(Integer.valueOf(f3226z[4].f3253a), Integer.valueOf(7));
        f3198F.put(Integer.valueOf(f3226z[5].f3253a), Integer.valueOf(8));
    }

    public C1036a(String str) throws IOException {
        if (str != null) {
            FileInputStream fileInputStream = null;
            this.f3228H = null;
            this.f3227G = str;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    m3957a((InputStream) fileInputStream2);
                    m3956a((Closeable) fileInputStream2);
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    m3956a((Closeable) fileInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                m3956a((Closeable) fileInputStream);
                throw th;
            }
        } else {
            throw new IllegalArgumentException("filename cannot be null");
        }
    }

    /* renamed from: b */
    private C1038b m3962b(String str) {
        if ("ISOSpeedRatings".equals(str)) {
            str = "PhotographicSensitivity";
        }
        for (int i = 0; i < f3208h.length; i++) {
            C1038b bVar = (C1038b) this.f3230J[i].get(str);
            if (bVar != null) {
                return bVar;
            }
        }
        return null;
    }

    /* renamed from: a */
    public String mo4025a(String str) {
        C1038b b = m3962b(str);
        if (b == null) {
            return null;
        }
        if (!f3197E.contains(str)) {
            return b.mo4051d(this.f3232L);
        }
        if (!str.equals("GPSTimeStamp")) {
            try {
                return Double.toString(b.mo4049b(this.f3232L));
            } catch (NumberFormatException unused) {
                return null;
            }
        } else if (b.f3250a == 5 || b.f3250a == 10) {
            C1040d[] dVarArr = (C1040d[]) b.mo4048a(this.f3232L);
            if (dVarArr == null || dVarArr.length != 3) {
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid GPS Timestamp array. array=");
                sb.append(Arrays.toString(dVarArr));
                Log.w("ExifInterface", sb.toString());
                return null;
            }
            return String.format("%02d:%02d:%02d", new Object[]{Integer.valueOf((int) (((float) dVarArr[0].f3257a) / ((float) dVarArr[0].f3258b))), Integer.valueOf((int) (((float) dVarArr[1].f3257a) / ((float) dVarArr[1].f3258b))), Integer.valueOf((int) (((float) dVarArr[2].f3257a) / ((float) dVarArr[2].f3258b)))});
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("GPS Timestamp format is not rational. format=");
            sb2.append(b.f3250a);
            Log.w("ExifInterface", sb2.toString());
            return null;
        }
    }

    /* renamed from: a */
    public int mo4024a(String str, int i) {
        C1038b b = m3962b(str);
        if (b == null) {
            return i;
        }
        try {
            return b.mo4050c(this.f3232L);
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0048, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r4.f3243W = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0050, code lost:
        m3950a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0053, code lost:
        throw r5;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x004a */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m3957a(java.io.InputStream r5) throws java.io.IOException {
        /*
            r4 = this;
            r0 = 0
            r1 = 0
        L_0x0002:
            androidx.d.a.a$c[][] r2 = f3208h     // Catch:{ IOException -> 0x004a }
            int r2 = r2.length     // Catch:{ IOException -> 0x004a }
            if (r1 >= r2) goto L_0x0013
            java.util.HashMap<java.lang.String, androidx.d.a.a$b>[] r2 = r4.f3230J     // Catch:{ IOException -> 0x004a }
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ IOException -> 0x004a }
            r3.<init>()     // Catch:{ IOException -> 0x004a }
            r2[r1] = r3     // Catch:{ IOException -> 0x004a }
            int r1 = r1 + 1
            goto L_0x0002
        L_0x0013:
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x004a }
            r2 = 5000(0x1388, float:7.006E-42)
            r1.<init>(r5, r2)     // Catch:{ IOException -> 0x004a }
            r5 = r1
            java.io.BufferedInputStream r5 = (java.io.BufferedInputStream) r5     // Catch:{ IOException -> 0x004a }
            int r5 = r4.m3949a(r5)     // Catch:{ IOException -> 0x004a }
            r4.f3229I = r5     // Catch:{ IOException -> 0x004a }
            androidx.d.a.a$a r5 = new androidx.d.a.a$a     // Catch:{ IOException -> 0x004a }
            r5.<init>(r1)     // Catch:{ IOException -> 0x004a }
            int r1 = r4.f3229I     // Catch:{ IOException -> 0x004a }
            switch(r1) {
                case 0: goto L_0x003e;
                case 1: goto L_0x003e;
                case 2: goto L_0x003e;
                case 3: goto L_0x003e;
                case 4: goto L_0x003a;
                case 5: goto L_0x003e;
                case 6: goto L_0x003e;
                case 7: goto L_0x0036;
                case 8: goto L_0x003e;
                case 9: goto L_0x0032;
                case 10: goto L_0x002e;
                case 11: goto L_0x003e;
                default: goto L_0x002d;
            }     // Catch:{ IOException -> 0x004a }
        L_0x002d:
            goto L_0x0041
        L_0x002e:
            r4.m3972d(r5)     // Catch:{ IOException -> 0x004a }
            goto L_0x0041
        L_0x0032:
            r4.m3963b(r5)     // Catch:{ IOException -> 0x004a }
            goto L_0x0041
        L_0x0036:
            r4.m3969c(r5)     // Catch:{ IOException -> 0x004a }
            goto L_0x0041
        L_0x003a:
            r4.m3954a(r5, r0, r0)     // Catch:{ IOException -> 0x004a }
            goto L_0x0041
        L_0x003e:
            r4.m3952a(r5)     // Catch:{ IOException -> 0x004a }
        L_0x0041:
            r4.m3976f(r5)     // Catch:{ IOException -> 0x004a }
            r5 = 1
            r4.f3243W = r5     // Catch:{ IOException -> 0x004a }
            goto L_0x004c
        L_0x0048:
            r5 = move-exception
            goto L_0x0050
        L_0x004a:
            r4.f3243W = r0     // Catch:{ all -> 0x0048 }
        L_0x004c:
            r4.m3950a()
            return
        L_0x0050:
            r4.m3950a()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.p074d.p075a.C1036a.m3957a(java.io.InputStream):void");
    }

    /* renamed from: a */
    private int m3949a(BufferedInputStream bufferedInputStream) throws IOException {
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        if (m3960a(bArr)) {
            return 4;
        }
        if (m3968b(bArr)) {
            return 9;
        }
        if (m3971c(bArr)) {
            return 7;
        }
        return m3974d(bArr) ? 10 : 0;
    }

    /* renamed from: a */
    private static boolean m3960a(byte[] bArr) throws IOException {
        for (int i = 0; i < f3204d.length; i++) {
            if (bArr[i] != f3204d[i]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    private boolean m3968b(byte[] bArr) throws IOException {
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        for (int i = 0; i < bytes.length; i++) {
            if (bArr[i] != bytes[i]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: c */
    private boolean m3971c(byte[] bArr) throws IOException {
        C1037a aVar = new C1037a(bArr);
        this.f3232L = m3975e(aVar);
        aVar.mo4028a(this.f3232L);
        short readShort = aVar.readShort();
        aVar.close();
        return readShort == 20306 || readShort == 21330;
    }

    /* renamed from: d */
    private boolean m3974d(byte[] bArr) throws IOException {
        C1037a aVar = new C1037a(bArr);
        this.f3232L = m3975e(aVar);
        aVar.mo4028a(this.f3232L);
        short readShort = aVar.readShort();
        aVar.close();
        return readShort == 85;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0082 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00f5 A[SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m3954a(androidx.p074d.p075a.C1036a.C1037a r9, int r10, int r11) throws java.io.IOException {
        /*
            r8 = this;
            java.nio.ByteOrder r0 = java.nio.ByteOrder.BIG_ENDIAN
            r9.mo4028a(r0)
            long r0 = (long) r10
            r9.mo4027a(r0)
            byte r0 = r9.readByte()
            r1 = -1
            if (r0 != r1) goto L_0x015d
            r2 = 1
            int r10 = r10 + r2
            byte r3 = r9.readByte()
            r4 = -40
            if (r3 != r4) goto L_0x0140
            int r10 = r10 + r2
        L_0x001b:
            byte r0 = r9.readByte()
            if (r0 != r1) goto L_0x0123
            int r10 = r10 + r2
            byte r0 = r9.readByte()
            int r10 = r10 + r2
            r3 = -39
            if (r0 == r3) goto L_0x011d
            r3 = -38
            if (r0 != r3) goto L_0x0031
            goto L_0x011d
        L_0x0031:
            int r3 = r9.readUnsignedShort()
            int r3 = r3 + -2
            int r10 = r10 + 2
            if (r3 < 0) goto L_0x0115
            r4 = -31
            r5 = 0
            if (r0 == r4) goto L_0x00b8
            r4 = -2
            if (r0 == r4) goto L_0x008a
            switch(r0) {
                case -64: goto L_0x0051;
                case -63: goto L_0x0051;
                case -62: goto L_0x0051;
                case -61: goto L_0x0051;
                default: goto L_0x0046;
            }
        L_0x0046:
            switch(r0) {
                case -59: goto L_0x0051;
                case -58: goto L_0x0051;
                case -57: goto L_0x0051;
                default: goto L_0x0049;
            }
        L_0x0049:
            switch(r0) {
                case -55: goto L_0x0051;
                case -54: goto L_0x0051;
                case -53: goto L_0x0051;
                default: goto L_0x004c;
            }
        L_0x004c:
            switch(r0) {
                case -51: goto L_0x0051;
                case -50: goto L_0x0051;
                case -49: goto L_0x0051;
                default: goto L_0x004f;
            }
        L_0x004f:
            goto L_0x00e2
        L_0x0051:
            int r0 = r9.skipBytes(r2)
            if (r0 != r2) goto L_0x0082
            java.util.HashMap<java.lang.String, androidx.d.a.a$b>[] r0 = r8.f3230J
            r0 = r0[r11]
            java.lang.String r4 = "ImageLength"
            int r5 = r9.readUnsignedShort()
            long r5 = (long) r5
            java.nio.ByteOrder r7 = r8.f3232L
            androidx.d.a.a$b r5 = androidx.p074d.p075a.C1036a.C1038b.m3984a(r5, r7)
            r0.put(r4, r5)
            java.util.HashMap<java.lang.String, androidx.d.a.a$b>[] r0 = r8.f3230J
            r0 = r0[r11]
            java.lang.String r4 = "ImageWidth"
            int r5 = r9.readUnsignedShort()
            long r5 = (long) r5
            java.nio.ByteOrder r7 = r8.f3232L
            androidx.d.a.a$b r5 = androidx.p074d.p075a.C1036a.C1038b.m3984a(r5, r7)
            r0.put(r4, r5)
            int r3 = r3 + -5
            goto L_0x00e2
        L_0x0082:
            java.io.IOException r9 = new java.io.IOException
            java.lang.String r10 = "Invalid SOFx"
            r9.<init>(r10)
            throw r9
        L_0x008a:
            byte[] r0 = new byte[r3]
            int r4 = r9.read(r0)
            if (r4 != r3) goto L_0x00b0
            java.lang.String r3 = "UserComment"
            java.lang.String r3 = r8.mo4025a(r3)
            if (r3 != 0) goto L_0x00ae
            java.util.HashMap<java.lang.String, androidx.d.a.a$b>[] r3 = r8.f3230J
            r3 = r3[r2]
            java.lang.String r4 = "UserComment"
            java.lang.String r6 = new java.lang.String
            java.nio.charset.Charset r7 = f3209i
            r6.<init>(r0, r7)
            androidx.d.a.a$b r0 = androidx.p074d.p075a.C1036a.C1038b.m3986a(r6)
            r3.put(r4, r0)
        L_0x00ae:
            r3 = 0
            goto L_0x00e2
        L_0x00b0:
            java.io.IOException r9 = new java.io.IOException
            java.lang.String r10 = "Invalid exif"
            r9.<init>(r10)
            throw r9
        L_0x00b8:
            r0 = 6
            if (r3 >= r0) goto L_0x00bc
            goto L_0x00e2
        L_0x00bc:
            byte[] r4 = new byte[r0]
            int r6 = r9.read(r4)
            if (r6 != r0) goto L_0x010d
            int r10 = r10 + 6
            int r3 = r3 + -6
            byte[] r0 = f3210j
            boolean r0 = java.util.Arrays.equals(r4, r0)
            if (r0 != 0) goto L_0x00d1
            goto L_0x00e2
        L_0x00d1:
            if (r3 <= 0) goto L_0x0105
            r8.f3238R = r10
            byte[] r0 = new byte[r3]
            int r4 = r9.read(r0)
            if (r4 != r3) goto L_0x00fd
            int r10 = r10 + r3
            r8.m3958a(r0, r11)
            goto L_0x00ae
        L_0x00e2:
            if (r3 < 0) goto L_0x00f5
            int r0 = r9.skipBytes(r3)
            if (r0 != r3) goto L_0x00ed
            int r10 = r10 + r3
            goto L_0x001b
        L_0x00ed:
            java.io.IOException r9 = new java.io.IOException
            java.lang.String r10 = "Invalid JPEG segment"
            r9.<init>(r10)
            throw r9
        L_0x00f5:
            java.io.IOException r9 = new java.io.IOException
            java.lang.String r10 = "Invalid length"
            r9.<init>(r10)
            throw r9
        L_0x00fd:
            java.io.IOException r9 = new java.io.IOException
            java.lang.String r10 = "Invalid exif"
            r9.<init>(r10)
            throw r9
        L_0x0105:
            java.io.IOException r9 = new java.io.IOException
            java.lang.String r10 = "Invalid exif"
            r9.<init>(r10)
            throw r9
        L_0x010d:
            java.io.IOException r9 = new java.io.IOException
            java.lang.String r10 = "Invalid exif"
            r9.<init>(r10)
            throw r9
        L_0x0115:
            java.io.IOException r9 = new java.io.IOException
            java.lang.String r10 = "Invalid length"
            r9.<init>(r10)
            throw r9
        L_0x011d:
            java.nio.ByteOrder r10 = r8.f3232L
            r9.mo4028a(r10)
            return
        L_0x0123:
            java.io.IOException r9 = new java.io.IOException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Invalid marker:"
            r10.append(r11)
            r11 = r0 & 255(0xff, float:3.57E-43)
            java.lang.String r11 = java.lang.Integer.toHexString(r11)
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L_0x0140:
            java.io.IOException r9 = new java.io.IOException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Invalid marker: "
            r10.append(r11)
            r11 = r0 & 255(0xff, float:3.57E-43)
            java.lang.String r11 = java.lang.Integer.toHexString(r11)
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L_0x015d:
            java.io.IOException r9 = new java.io.IOException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Invalid marker: "
            r10.append(r11)
            r11 = r0 & 255(0xff, float:3.57E-43)
            java.lang.String r11 = java.lang.Integer.toHexString(r11)
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.p074d.p075a.C1036a.m3954a(androidx.d.a.a$a, int, int):void");
    }

    /* renamed from: a */
    private void m3952a(C1037a aVar) throws IOException {
        m3953a(aVar, aVar.available());
        m3964b(aVar, 0);
        m3973d(aVar, 0);
        m3973d(aVar, 5);
        m3973d(aVar, 4);
        m3966b((InputStream) aVar);
        if (this.f3229I == 8) {
            C1038b bVar = (C1038b) this.f3230J[1].get("MakerNote");
            if (bVar != null) {
                C1037a aVar2 = new C1037a(bVar.f3252c);
                aVar2.mo4028a(this.f3232L);
                aVar2.mo4027a(6);
                m3964b(aVar2, 9);
                C1038b bVar2 = (C1038b) this.f3230J[9].get("ColorSpace");
                if (bVar2 != null) {
                    this.f3230J[1].put("ColorSpace", bVar2);
                }
            }
        }
    }

    /* renamed from: b */
    private void m3963b(C1037a aVar) throws IOException {
        aVar.skipBytes(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        aVar.read(bArr);
        aVar.skipBytes(4);
        aVar.read(bArr2);
        int i = ByteBuffer.wrap(bArr).getInt();
        int i2 = ByteBuffer.wrap(bArr2).getInt();
        m3954a(aVar, i, 5);
        aVar.mo4027a((long) i2);
        aVar.mo4028a(ByteOrder.BIG_ENDIAN);
        int readInt = aVar.readInt();
        for (int i3 = 0; i3 < readInt; i3++) {
            int readUnsignedShort = aVar.readUnsignedShort();
            int readUnsignedShort2 = aVar.readUnsignedShort();
            if (readUnsignedShort == f3221u.f3253a) {
                short readShort = aVar.readShort();
                short readShort2 = aVar.readShort();
                C1038b a = C1038b.m3983a((int) readShort, this.f3232L);
                C1038b a2 = C1038b.m3983a((int) readShort2, this.f3232L);
                this.f3230J[0].put("ImageLength", a);
                this.f3230J[0].put("ImageWidth", a2);
                return;
            }
            aVar.skipBytes(readUnsignedShort2);
        }
    }

    /* renamed from: c */
    private void m3969c(C1037a aVar) throws IOException {
        m3952a(aVar);
        C1038b bVar = (C1038b) this.f3230J[1].get("MakerNote");
        if (bVar != null) {
            C1037a aVar2 = new C1037a(bVar.f3252c);
            aVar2.mo4028a(this.f3232L);
            byte[] bArr = new byte[f3213m.length];
            aVar2.readFully(bArr);
            aVar2.mo4027a(0);
            byte[] bArr2 = new byte[f3214n.length];
            aVar2.readFully(bArr2);
            if (Arrays.equals(bArr, f3213m)) {
                aVar2.mo4027a(8);
            } else if (Arrays.equals(bArr2, f3214n)) {
                aVar2.mo4027a(12);
            }
            m3964b(aVar2, 6);
            C1038b bVar2 = (C1038b) this.f3230J[7].get("PreviewImageStart");
            C1038b bVar3 = (C1038b) this.f3230J[7].get("PreviewImageLength");
            if (!(bVar2 == null || bVar3 == null)) {
                this.f3230J[5].put("JPEGInterchangeFormat", bVar2);
                this.f3230J[5].put("JPEGInterchangeFormatLength", bVar3);
            }
            C1038b bVar4 = (C1038b) this.f3230J[8].get("AspectFrame");
            if (bVar4 != null) {
                int[] iArr = (int[]) bVar4.mo4048a(this.f3232L);
                if (iArr == null || iArr.length != 4) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Invalid aspect frame values. frame=");
                    sb.append(Arrays.toString(iArr));
                    Log.w("ExifInterface", sb.toString());
                } else if (iArr[2] > iArr[0] && iArr[3] > iArr[1]) {
                    int i = (iArr[2] - iArr[0]) + 1;
                    int i2 = (iArr[3] - iArr[1]) + 1;
                    if (i < i2) {
                        int i3 = i + i2;
                        i2 = i3 - i2;
                        i = i3 - i2;
                    }
                    C1038b a = C1038b.m3983a(i, this.f3232L);
                    C1038b a2 = C1038b.m3983a(i2, this.f3232L);
                    this.f3230J[0].put("ImageWidth", a);
                    this.f3230J[0].put("ImageLength", a2);
                }
            }
        }
    }

    /* renamed from: d */
    private void m3972d(C1037a aVar) throws IOException {
        m3952a(aVar);
        if (((C1038b) this.f3230J[0].get("JpgFromRaw")) != null) {
            m3954a(aVar, this.f3242V, 5);
        }
        C1038b bVar = (C1038b) this.f3230J[0].get("ISO");
        C1038b bVar2 = (C1038b) this.f3230J[1].get("PhotographicSensitivity");
        if (bVar != null && bVar2 == null) {
            this.f3230J[1].put("PhotographicSensitivity", bVar);
        }
    }

    /* renamed from: a */
    private void m3958a(byte[] bArr, int i) throws IOException {
        C1037a aVar = new C1037a(bArr);
        m3953a(aVar, bArr.length);
        m3964b(aVar, i);
    }

    /* renamed from: a */
    private void m3950a() {
        String a = mo4025a("DateTimeOriginal");
        if (a != null && mo4025a("DateTime") == null) {
            this.f3230J[0].put("DateTime", C1038b.m3986a(a));
        }
        if (mo4025a("ImageWidth") == null) {
            this.f3230J[0].put("ImageWidth", C1038b.m3984a(0, this.f3232L));
        }
        if (mo4025a("ImageLength") == null) {
            this.f3230J[0].put("ImageLength", C1038b.m3984a(0, this.f3232L));
        }
        if (mo4025a("Orientation") == null) {
            this.f3230J[0].put("Orientation", C1038b.m3984a(0, this.f3232L));
        }
        if (mo4025a("LightSource") == null) {
            this.f3230J[1].put("LightSource", C1038b.m3984a(0, this.f3232L));
        }
    }

    /* renamed from: e */
    private ByteOrder m3975e(C1037a aVar) throws IOException {
        short readShort = aVar.readShort();
        if (readShort == 18761) {
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (readShort == 19789) {
            return ByteOrder.BIG_ENDIAN;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid byte order: ");
        sb.append(Integer.toHexString(readShort));
        throw new IOException(sb.toString());
    }

    /* renamed from: a */
    private void m3953a(C1037a aVar, int i) throws IOException {
        this.f3232L = m3975e(aVar);
        aVar.mo4028a(this.f3232L);
        int readUnsignedShort = aVar.readUnsignedShort();
        if (this.f3229I == 7 || this.f3229I == 10 || readUnsignedShort == 42) {
            int readInt = aVar.readInt();
            if (readInt < 8 || readInt >= i) {
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid first Ifd offset: ");
                sb.append(readInt);
                throw new IOException(sb.toString());
            }
            int i2 = readInt - 8;
            if (i2 > 0 && aVar.skipBytes(i2) != i2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Couldn't jump to first Ifd: ");
                sb2.append(i2);
                throw new IOException(sb2.toString());
            }
            return;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Invalid start code: ");
        sb3.append(Integer.toHexString(readUnsignedShort));
        throw new IOException(sb3.toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01ba  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x023b  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m3964b(androidx.p074d.p075a.C1036a.C1037a r21, int r22) throws java.io.IOException {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r22
            java.util.Set<java.lang.Integer> r3 = r0.f3231K
            int r4 = r1.f3247b
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r3.add(r4)
            int r3 = r1.f3247b
            int r3 = r3 + 2
            int r4 = r1.f3246a
            if (r3 <= r4) goto L_0x001a
            return
        L_0x001a:
            short r3 = r21.readShort()
            int r4 = r1.f3247b
            int r5 = r3 * 12
            int r4 = r4 + r5
            int r5 = r1.f3246a
            if (r4 > r5) goto L_0x0325
            if (r3 > 0) goto L_0x002b
            goto L_0x0325
        L_0x002b:
            r5 = 0
        L_0x002c:
            if (r5 >= r3) goto L_0x02b1
            int r9 = r21.readUnsignedShort()
            int r10 = r21.readUnsignedShort()
            int r11 = r21.readInt()
            int r12 = r21.mo4026a()
            long r12 = (long) r12
            r14 = 4
            long r12 = r12 + r14
            java.util.HashMap<java.lang.Integer, androidx.d.a.a$c>[] r16 = f3195C
            r4 = r16[r2]
            java.lang.Integer r8 = java.lang.Integer.valueOf(r9)
            java.lang.Object r4 = r4.get(r8)
            androidx.d.a.a$c r4 = (androidx.p074d.p075a.C1036a.C1039c) r4
            r8 = 7
            if (r4 != 0) goto L_0x006b
            java.lang.String r14 = "ExifInterface"
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r6 = "Skip the tag entry since tag number is not defined: "
            r15.append(r6)
            r15.append(r9)
            java.lang.String r6 = r15.toString()
            android.util.Log.w(r14, r6)
            goto L_0x00e7
        L_0x006b:
            if (r10 <= 0) goto L_0x00d1
            int[] r6 = f3206f
            int r6 = r6.length
            if (r10 < r6) goto L_0x0073
            goto L_0x00d1
        L_0x0073:
            boolean r6 = r4.mo4053a(r10)
            if (r6 != 0) goto L_0x009e
            java.lang.String r6 = "ExifInterface"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r14 = "Skip the tag entry since data format ("
            r7.append(r14)
            java.lang.String[] r14 = f3205e
            r14 = r14[r10]
            r7.append(r14)
            java.lang.String r14 = ") is unexpected for tag: "
            r7.append(r14)
            java.lang.String r14 = r4.f3254b
            r7.append(r14)
            java.lang.String r7 = r7.toString()
            android.util.Log.w(r6, r7)
            goto L_0x00e7
        L_0x009e:
            if (r10 != r8) goto L_0x00a2
            int r10 = r4.f3255c
        L_0x00a2:
            long r6 = (long) r11
            int[] r14 = f3206f
            r14 = r14[r10]
            long r14 = (long) r14
            long r6 = r6 * r14
            r14 = 0
            int r16 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
            if (r16 < 0) goto L_0x00ba
            r14 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r14 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
            if (r14 <= 0) goto L_0x00b8
            goto L_0x00ba
        L_0x00b8:
            r14 = 1
            goto L_0x00ea
        L_0x00ba:
            java.lang.String r14 = "ExifInterface"
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r8 = "Skip the tag entry since the number of components is invalid: "
            r15.append(r8)
            r15.append(r11)
            java.lang.String r8 = r15.toString()
            android.util.Log.w(r14, r8)
            goto L_0x00e9
        L_0x00d1:
            java.lang.String r6 = "ExifInterface"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Skip the tag entry since data format is invalid: "
            r7.append(r8)
            r7.append(r10)
            java.lang.String r7 = r7.toString()
            android.util.Log.w(r6, r7)
        L_0x00e7:
            r6 = 0
        L_0x00e9:
            r14 = 0
        L_0x00ea:
            if (r14 != 0) goto L_0x00f4
            r1.mo4027a(r12)
            r6 = r2
            r17 = r3
            goto L_0x02a9
        L_0x00f4:
            r14 = 4
            int r8 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
            if (r8 <= 0) goto L_0x01a6
            int r8 = r21.readInt()
            int r14 = r0.f3229I
            r15 = 7
            if (r14 != r15) goto L_0x0163
            java.lang.String r14 = "MakerNote"
            java.lang.String r15 = r4.f3254b
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x0116
            r0.f3239S = r8
        L_0x010f:
            r17 = r3
            r19 = r10
            r18 = r11
            goto L_0x017b
        L_0x0116:
            r14 = 6
            if (r2 != r14) goto L_0x010f
            java.lang.String r15 = "ThumbnailImage"
            java.lang.String r14 = r4.f3254b
            boolean r14 = r15.equals(r14)
            if (r14 == 0) goto L_0x010f
            r0.f3240T = r8
            r0.f3241U = r11
            java.nio.ByteOrder r14 = r0.f3232L
            r15 = 6
            androidx.d.a.a$b r14 = androidx.p074d.p075a.C1036a.C1038b.m3983a(r15, r14)
            int r15 = r0.f3240T
            r17 = r3
            long r2 = (long) r15
            java.nio.ByteOrder r15 = r0.f3232L
            androidx.d.a.a$b r2 = androidx.p074d.p075a.C1036a.C1038b.m3984a(r2, r15)
            int r3 = r0.f3241U
            r19 = r10
            r18 = r11
            long r10 = (long) r3
            java.nio.ByteOrder r3 = r0.f3232L
            androidx.d.a.a$b r3 = androidx.p074d.p075a.C1036a.C1038b.m3984a(r10, r3)
            java.util.HashMap<java.lang.String, androidx.d.a.a$b>[] r10 = r0.f3230J
            r11 = 4
            r10 = r10[r11]
            java.lang.String r15 = "Compression"
            r10.put(r15, r14)
            java.util.HashMap<java.lang.String, androidx.d.a.a$b>[] r10 = r0.f3230J
            r10 = r10[r11]
            java.lang.String r14 = "JPEGInterchangeFormat"
            r10.put(r14, r2)
            java.util.HashMap<java.lang.String, androidx.d.a.a$b>[] r2 = r0.f3230J
            r2 = r2[r11]
            java.lang.String r10 = "JPEGInterchangeFormatLength"
            r2.put(r10, r3)
            goto L_0x017b
        L_0x0163:
            r17 = r3
            r19 = r10
            r18 = r11
            int r2 = r0.f3229I
            r3 = 10
            if (r2 != r3) goto L_0x017b
            java.lang.String r2 = "JpgFromRaw"
            java.lang.String r3 = r4.f3254b
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x017b
            r0.f3242V = r8
        L_0x017b:
            long r2 = (long) r8
            long r10 = r2 + r6
            int r14 = r1.f3246a
            long r14 = (long) r14
            int r10 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
            if (r10 > 0) goto L_0x0189
            r1.mo4027a(r2)
            goto L_0x01ac
        L_0x0189:
            java.lang.String r2 = "ExifInterface"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Skip the tag entry since data offset is invalid: "
            r3.append(r4)
            r3.append(r8)
            java.lang.String r3 = r3.toString()
            android.util.Log.w(r2, r3)
            r1.mo4027a(r12)
        L_0x01a2:
            r6 = r22
            goto L_0x02a9
        L_0x01a6:
            r17 = r3
            r19 = r10
            r18 = r11
        L_0x01ac:
            java.util.HashMap<java.lang.Integer, java.lang.Integer> r2 = f3198F
            java.lang.Integer r3 = java.lang.Integer.valueOf(r9)
            java.lang.Object r2 = r2.get(r3)
            java.lang.Integer r2 = (java.lang.Integer) r2
            if (r2 == 0) goto L_0x023b
            r3 = -1
            switch(r19) {
                case 3: goto L_0x01d3;
                case 4: goto L_0x01ce;
                case 8: goto L_0x01c8;
                case 9: goto L_0x01c2;
                case 13: goto L_0x01c2;
                default: goto L_0x01bf;
            }
        L_0x01bf:
            r6 = 0
            goto L_0x01d9
        L_0x01c2:
            int r3 = r21.readInt()
            long r3 = (long) r3
            goto L_0x01bf
        L_0x01c8:
            short r3 = r21.readShort()
            long r3 = (long) r3
            goto L_0x01bf
        L_0x01ce:
            long r3 = r21.mo4030b()
            goto L_0x01bf
        L_0x01d3:
            int r3 = r21.readUnsignedShort()
            long r3 = (long) r3
            goto L_0x01bf
        L_0x01d9:
            int r6 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r6 <= 0) goto L_0x0220
            int r6 = r1.f3246a
            long r6 = (long) r6
            int r6 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r6 >= 0) goto L_0x0220
            java.util.Set<java.lang.Integer> r6 = r0.f3231K
            int r7 = (int) r3
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            boolean r6 = r6.contains(r7)
            if (r6 != 0) goto L_0x01fc
            r1.mo4027a(r3)
            int r2 = r2.intValue()
            r0.m3964b(r1, r2)
            goto L_0x0236
        L_0x01fc:
            java.lang.String r6 = "ExifInterface"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Skip jump into the IFD since it has already been read: IfdType "
            r7.append(r8)
            r7.append(r2)
            java.lang.String r2 = " (at "
            r7.append(r2)
            r7.append(r3)
            java.lang.String r2 = ")"
            r7.append(r2)
            java.lang.String r2 = r7.toString()
            android.util.Log.w(r6, r2)
            goto L_0x0236
        L_0x0220:
            java.lang.String r2 = "ExifInterface"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Skip jump into the IFD since its offset is invalid: "
            r6.append(r7)
            r6.append(r3)
            java.lang.String r3 = r6.toString()
            android.util.Log.w(r2, r3)
        L_0x0236:
            r1.mo4027a(r12)
            goto L_0x01a2
        L_0x023b:
            int r2 = (int) r6
            byte[] r2 = new byte[r2]
            r1.readFully(r2)
            androidx.d.a.a$b r3 = new androidx.d.a.a$b
            r6 = r18
            r10 = r19
            r3.<init>(r10, r6, r2)
            java.util.HashMap<java.lang.String, androidx.d.a.a$b>[] r2 = r0.f3230J
            r6 = r22
            r2 = r2[r6]
            java.lang.String r7 = r4.f3254b
            r2.put(r7, r3)
            java.lang.String r2 = "DNGVersion"
            java.lang.String r7 = r4.f3254b
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x0262
            r2 = 3
            r0.f3229I = r2
        L_0x0262:
            java.lang.String r2 = "Make"
            java.lang.String r7 = r4.f3254b
            boolean r2 = r2.equals(r7)
            if (r2 != 0) goto L_0x0276
            java.lang.String r2 = "Model"
            java.lang.String r7 = r4.f3254b
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x0284
        L_0x0276:
            java.nio.ByteOrder r2 = r0.f3232L
            java.lang.String r2 = r3.mo4051d(r2)
            java.lang.String r7 = "PENTAX"
            boolean r2 = r2.contains(r7)
            if (r2 != 0) goto L_0x0299
        L_0x0284:
            java.lang.String r2 = "Compression"
            java.lang.String r4 = r4.f3254b
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x029d
            java.nio.ByteOrder r2 = r0.f3232L
            int r2 = r3.mo4050c(r2)
            r3 = 65535(0xffff, float:9.1834E-41)
            if (r2 != r3) goto L_0x029d
        L_0x0299:
            r2 = 8
            r0.f3229I = r2
        L_0x029d:
            int r2 = r21.mo4026a()
            long r2 = (long) r2
            int r2 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r2 == 0) goto L_0x02a9
            r1.mo4027a(r12)
        L_0x02a9:
            int r5 = r5 + 1
            short r5 = (short) r5
            r2 = r6
            r3 = r17
            goto L_0x002c
        L_0x02b1:
            int r2 = r21.mo4026a()
            r3 = 4
            int r2 = r2 + r3
            int r3 = r1.f3246a
            if (r2 > r3) goto L_0x0324
            int r2 = r21.readInt()
            long r3 = (long) r2
            r5 = 0
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 <= 0) goto L_0x030e
            int r5 = r1.f3246a
            if (r2 >= r5) goto L_0x030e
            java.util.Set<java.lang.Integer> r5 = r0.f3231K
            java.lang.Integer r6 = java.lang.Integer.valueOf(r2)
            boolean r5 = r5.contains(r6)
            if (r5 != 0) goto L_0x02f7
            r1.mo4027a(r3)
            java.util.HashMap<java.lang.String, androidx.d.a.a$b>[] r2 = r0.f3230J
            r3 = 4
            r2 = r2[r3]
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x02e8
            r0.m3964b(r1, r3)
            goto L_0x0324
        L_0x02e8:
            java.util.HashMap<java.lang.String, androidx.d.a.a$b>[] r2 = r0.f3230J
            r3 = 5
            r2 = r2[r3]
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0324
            r0.m3964b(r1, r3)
            goto L_0x0324
        L_0x02f7:
            java.lang.String r1 = "ExifInterface"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Stop reading file since re-reading an IFD may cause an infinite loop: "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            android.util.Log.w(r1, r2)
            goto L_0x0324
        L_0x030e:
            java.lang.String r1 = "ExifInterface"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Stop reading file since a wrong offset may cause an infinite loop: "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            android.util.Log.w(r1, r2)
        L_0x0324:
            return
        L_0x0325:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.p074d.p075a.C1036a.m3964b(androidx.d.a.a$a, int):void");
    }

    /* renamed from: c */
    private void m3970c(C1037a aVar, int i) throws IOException {
        C1038b bVar = (C1038b) this.f3230J[i].get("ImageWidth");
        if (((C1038b) this.f3230J[i].get("ImageLength")) == null || bVar == null) {
            C1038b bVar2 = (C1038b) this.f3230J[i].get("JPEGInterchangeFormat");
            if (bVar2 != null) {
                m3954a(aVar, bVar2.mo4050c(this.f3232L), i);
            }
        }
    }

    /* renamed from: f */
    private void m3976f(C1037a aVar) throws IOException {
        HashMap<String, C1038b> hashMap = this.f3230J[4];
        C1038b bVar = (C1038b) hashMap.get("Compression");
        if (bVar != null) {
            this.f3237Q = bVar.mo4050c(this.f3232L);
            int i = this.f3237Q;
            if (i != 1) {
                switch (i) {
                    case 6:
                        m3955a(aVar, (HashMap) hashMap);
                        return;
                    case 7:
                        break;
                    default:
                        return;
                }
            }
            if (m3959a((HashMap) hashMap)) {
                m3965b(aVar, (HashMap) hashMap);
                return;
            }
            return;
        }
        this.f3237Q = 6;
        m3955a(aVar, (HashMap) hashMap);
    }

    /* renamed from: a */
    private void m3955a(C1037a aVar, HashMap hashMap) throws IOException {
        C1038b bVar = (C1038b) hashMap.get("JPEGInterchangeFormat");
        C1038b bVar2 = (C1038b) hashMap.get("JPEGInterchangeFormatLength");
        if (bVar != null && bVar2 != null) {
            int c = bVar.mo4050c(this.f3232L);
            int min = Math.min(bVar2.mo4050c(this.f3232L), aVar.available() - c);
            if (this.f3229I == 4 || this.f3229I == 9 || this.f3229I == 10) {
                c += this.f3238R;
            } else if (this.f3229I == 7) {
                c += this.f3239S;
            }
            if (c > 0 && min > 0) {
                this.f3233M = true;
                this.f3234N = c;
                this.f3235O = min;
                if (this.f3227G == null && this.f3228H == null) {
                    byte[] bArr = new byte[min];
                    aVar.mo4027a((long) c);
                    aVar.readFully(bArr);
                    this.f3236P = bArr;
                }
            }
        }
    }

    /* renamed from: b */
    private void m3965b(C1037a aVar, HashMap hashMap) throws IOException {
        C1038b bVar = (C1038b) hashMap.get("StripOffsets");
        C1038b bVar2 = (C1038b) hashMap.get("StripByteCounts");
        if (!(bVar == null || bVar2 == null)) {
            long[] a = m3961a(bVar.mo4048a(this.f3232L));
            long[] a2 = m3961a(bVar2.mo4048a(this.f3232L));
            if (a == null) {
                Log.w("ExifInterface", "stripOffsets should not be null.");
            } else if (a2 == null) {
                Log.w("ExifInterface", "stripByteCounts should not be null.");
            } else {
                long j = 0;
                for (long j2 : a2) {
                    j += j2;
                }
                byte[] bArr = new byte[((int) j)];
                int i = 0;
                int i2 = 0;
                for (int i3 = 0; i3 < a.length; i3++) {
                    int i4 = (int) a2[i3];
                    int i5 = ((int) a[i3]) - i;
                    if (i5 < 0) {
                        Log.d("ExifInterface", "Invalid strip offset value");
                    }
                    aVar.mo4027a((long) i5);
                    int i6 = i + i5;
                    byte[] bArr2 = new byte[i4];
                    aVar.read(bArr2);
                    i = i6 + i4;
                    System.arraycopy(bArr2, 0, bArr, i2, bArr2.length);
                    i2 += bArr2.length;
                }
                this.f3233M = true;
                this.f3236P = bArr;
                this.f3235O = bArr.length;
            }
        }
    }

    /* renamed from: a */
    private boolean m3959a(HashMap hashMap) throws IOException {
        C1038b bVar = (C1038b) hashMap.get("BitsPerSample");
        if (bVar != null) {
            int[] iArr = (int[]) bVar.mo4048a(this.f3232L);
            if (Arrays.equals(f3201a, iArr)) {
                return true;
            }
            if (this.f3229I == 3) {
                C1038b bVar2 = (C1038b) hashMap.get("PhotometricInterpretation");
                if (bVar2 != null) {
                    int c = bVar2.mo4050c(this.f3232L);
                    if ((c == 1 && Arrays.equals(iArr, f3203c)) || (c == 6 && Arrays.equals(iArr, f3201a))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: b */
    private boolean m3967b(HashMap hashMap) throws IOException {
        C1038b bVar = (C1038b) hashMap.get("ImageLength");
        C1038b bVar2 = (C1038b) hashMap.get("ImageWidth");
        if (!(bVar == null || bVar2 == null)) {
            int c = bVar.mo4050c(this.f3232L);
            int c2 = bVar2.mo4050c(this.f3232L);
            if (c <= 512 && c2 <= 512) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private void m3966b(InputStream inputStream) throws IOException {
        m3951a(0, 5);
        m3951a(0, 4);
        m3951a(5, 4);
        C1038b bVar = (C1038b) this.f3230J[1].get("PixelXDimension");
        C1038b bVar2 = (C1038b) this.f3230J[1].get("PixelYDimension");
        if (!(bVar == null || bVar2 == null)) {
            this.f3230J[0].put("ImageWidth", bVar);
            this.f3230J[0].put("ImageLength", bVar2);
        }
        if (this.f3230J[4].isEmpty() && m3967b((HashMap) this.f3230J[5])) {
            this.f3230J[4] = this.f3230J[5];
            this.f3230J[5] = new HashMap<>();
        }
        if (!m3967b((HashMap) this.f3230J[4])) {
            Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
        }
    }

    /* renamed from: d */
    private void m3973d(C1037a aVar, int i) throws IOException {
        C1038b bVar;
        C1038b bVar2;
        C1038b bVar3 = (C1038b) this.f3230J[i].get("DefaultCropSize");
        C1038b bVar4 = (C1038b) this.f3230J[i].get("SensorTopBorder");
        C1038b bVar5 = (C1038b) this.f3230J[i].get("SensorLeftBorder");
        C1038b bVar6 = (C1038b) this.f3230J[i].get("SensorBottomBorder");
        C1038b bVar7 = (C1038b) this.f3230J[i].get("SensorRightBorder");
        if (bVar3 != null) {
            if (bVar3.f3250a == 5) {
                C1040d[] dVarArr = (C1040d[]) bVar3.mo4048a(this.f3232L);
                if (dVarArr == null || dVarArr.length != 2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Invalid crop size values. cropSize=");
                    sb.append(Arrays.toString(dVarArr));
                    Log.w("ExifInterface", sb.toString());
                    return;
                }
                bVar2 = C1038b.m3985a(dVarArr[0], this.f3232L);
                bVar = C1038b.m3985a(dVarArr[1], this.f3232L);
            } else {
                int[] iArr = (int[]) bVar3.mo4048a(this.f3232L);
                if (iArr == null || iArr.length != 2) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Invalid crop size values. cropSize=");
                    sb2.append(Arrays.toString(iArr));
                    Log.w("ExifInterface", sb2.toString());
                    return;
                }
                bVar2 = C1038b.m3983a(iArr[0], this.f3232L);
                bVar = C1038b.m3983a(iArr[1], this.f3232L);
            }
            this.f3230J[i].put("ImageWidth", bVar2);
            this.f3230J[i].put("ImageLength", bVar);
        } else if (bVar4 == null || bVar5 == null || bVar6 == null || bVar7 == null) {
            m3970c(aVar, i);
        } else {
            int c = bVar4.mo4050c(this.f3232L);
            int c2 = bVar6.mo4050c(this.f3232L);
            int c3 = bVar7.mo4050c(this.f3232L);
            int c4 = bVar5.mo4050c(this.f3232L);
            if (c2 > c && c3 > c4) {
                int i2 = c3 - c4;
                C1038b a = C1038b.m3983a(c2 - c, this.f3232L);
                C1038b a2 = C1038b.m3983a(i2, this.f3232L);
                this.f3230J[i].put("ImageLength", a);
                this.f3230J[i].put("ImageWidth", a2);
            }
        }
    }

    /* renamed from: a */
    private void m3951a(int i, int i2) throws IOException {
        if (!this.f3230J[i].isEmpty() && !this.f3230J[i2].isEmpty()) {
            C1038b bVar = (C1038b) this.f3230J[i].get("ImageLength");
            C1038b bVar2 = (C1038b) this.f3230J[i].get("ImageWidth");
            C1038b bVar3 = (C1038b) this.f3230J[i2].get("ImageLength");
            C1038b bVar4 = (C1038b) this.f3230J[i2].get("ImageWidth");
            if (!(bVar == null || bVar2 == null || bVar3 == null || bVar4 == null)) {
                int c = bVar.mo4050c(this.f3232L);
                int c2 = bVar2.mo4050c(this.f3232L);
                int c3 = bVar3.mo4050c(this.f3232L);
                int c4 = bVar4.mo4050c(this.f3232L);
                if (c < c3 && c2 < c4) {
                    HashMap<String, C1038b> hashMap = this.f3230J[i];
                    this.f3230J[i] = this.f3230J[i2];
                    this.f3230J[i2] = hashMap;
                }
            }
        }
    }

    /* renamed from: a */
    private static void m3956a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    private static long[] m3961a(Object obj) {
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            long[] jArr = new long[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                jArr[i] = (long) iArr[i];
            }
            return jArr;
        } else if (obj instanceof long[]) {
            return (long[]) obj;
        } else {
            return null;
        }
    }
}
