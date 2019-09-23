package com.j256.simplemagic;

import com.j256.simplemagic.entries.MagicEntries;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.zip.GZIPInputStream;

public class ContentInfoUtil {
    public static final int DEFAULT_READ_SIZE = 10240;
    private static final String INTERNAL_MAGIC_FILE = "/magic.gz";
    private static MagicEntries internalMagicEntries;
    private ErrorCallBack errorCallBack;
    private int fileReadSize;
    private final MagicEntries magicEntries;

    public interface ErrorCallBack {
        void error(String str, String str2, Exception exc);
    }

    public ContentInfoUtil() {
        this((ErrorCallBack) null);
    }

    public ContentInfoUtil(ErrorCallBack errorCallBack2) {
        this.fileReadSize = DEFAULT_READ_SIZE;
        this.errorCallBack = errorCallBack2;
        if (internalMagicEntries == null) {
            try {
                internalMagicEntries = readEntriesFromResource(INTERNAL_MAGIC_FILE);
                if (internalMagicEntries == null) {
                    throw new IllegalStateException("Internal magic file not found in class-path: /magic.gz");
                }
            } catch (IOException e) {
                throw new IllegalStateException("Could not load entries from internal magic file: /magic.gz", e);
            }
        }
        this.magicEntries = internalMagicEntries;
    }

    public ContentInfoUtil(String str) throws IOException {
        this(new File(str), (ErrorCallBack) null);
    }

    public ContentInfoUtil(String str, ErrorCallBack errorCallBack2) throws IOException {
        this.fileReadSize = DEFAULT_READ_SIZE;
        this.errorCallBack = errorCallBack2;
        MagicEntries readEntriesFromResource = readEntriesFromResource(str);
        if (readEntriesFromResource == null) {
            readEntriesFromResource = readEntriesFromFile(new File(str));
        }
        if (readEntriesFromResource != null) {
            this.magicEntries = readEntriesFromResource;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Magic path specified is not a file, directory, or resource: ");
        sb.append(str);
        throw new IllegalArgumentException(sb.toString());
    }

    public ContentInfoUtil(File file) throws IOException {
        this(file, (ErrorCallBack) null);
    }

    public ContentInfoUtil(File file, ErrorCallBack errorCallBack2) throws IOException {
        this.fileReadSize = DEFAULT_READ_SIZE;
        this.errorCallBack = errorCallBack2;
        this.magicEntries = readEntriesFromFile(file);
        if (this.magicEntries == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Magic path specified is not a file, directory, or resource: ");
            sb.append(file);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public ContentInfoUtil(Reader reader) throws IOException {
        this(reader, (ErrorCallBack) null);
    }

    public ContentInfoUtil(Reader reader, ErrorCallBack errorCallBack2) throws IOException {
        this.fileReadSize = DEFAULT_READ_SIZE;
        this.errorCallBack = errorCallBack2;
        this.magicEntries = readEntries(reader);
    }

    public ContentInfo findMatch(String str) throws IOException {
        return findMatch(new File(str));
    }

    public ContentInfo findMatch(File file) throws IOException {
        int i = this.fileReadSize;
        if (file.length() < ((long) i)) {
            i = (int) file.length();
        }
        if (i == 0) {
            return ContentInfo.EMPTY_INFO;
        }
        byte[] bArr = new byte[i];
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileInputStream2.read(bArr);
                closeQuietly(fileInputStream2);
                return findMatch(bArr);
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                closeQuietly(fileInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            closeQuietly(fileInputStream);
            throw th;
        }
    }

    public ContentInfo findMatch(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[this.fileReadSize];
        int read = inputStream.read(bArr);
        if (read < 0) {
            return null;
        }
        if (read < bArr.length) {
            bArr = Arrays.copyOf(bArr, read);
        }
        return findMatch(bArr);
    }

    public ContentInfo findMatch(byte[] bArr) {
        if (bArr.length == 0) {
            return ContentInfo.EMPTY_INFO;
        }
        return this.magicEntries.findMatch(bArr);
    }

    public static ContentInfo findExtensionMatch(String str) {
        String lowerCase = str.toLowerCase();
        ContentType fromFileExtension = ContentType.fromFileExtension(lowerCase);
        if (fromFileExtension != ContentType.OTHER) {
            return new ContentInfo(fromFileExtension);
        }
        int lastIndexOf = lowerCase.lastIndexOf(46);
        if (lastIndexOf < 0 || lastIndexOf == lowerCase.length() - 1) {
            return null;
        }
        ContentType fromFileExtension2 = ContentType.fromFileExtension(lowerCase.substring(lastIndexOf + 1));
        if (fromFileExtension2 == ContentType.OTHER) {
            return null;
        }
        return new ContentInfo(fromFileExtension2);
    }

    public static ContentInfo findMimeTypeMatch(String str) {
        ContentType fromMimeType = ContentType.fromMimeType(str.toLowerCase());
        if (fromMimeType == ContentType.OTHER) {
            return null;
        }
        return new ContentInfo(fromMimeType);
    }

    public void setFileReadSize(int i) {
        this.fileReadSize = i;
    }

    public void setErrorCallBack(ErrorCallBack errorCallBack2) {
        this.errorCallBack = errorCallBack2;
    }

    private MagicEntries readEntriesFromFile(File file) throws FileNotFoundException, IOException {
        if (file.isFile()) {
            FileReader fileReader = new FileReader(file);
            try {
                return readEntries(fileReader);
            } finally {
                closeQuietly(fileReader);
            }
        } else if (!file.isDirectory()) {
            return null;
        } else {
            MagicEntries magicEntries2 = new MagicEntries();
            for (File fileReader2 : file.listFiles()) {
                FileReader fileReader3 = new FileReader(fileReader2);
                try {
                    readEntries(magicEntries2, fileReader3);
                } catch (IOException unused) {
                } catch (Throwable th) {
                    closeQuietly(fileReader3);
                    throw th;
                }
                closeQuietly(fileReader3);
            }
            magicEntries2.optimizeFirstBytes();
            return magicEntries2;
        }
    }

    private MagicEntries readEntriesFromResource(String str) throws IOException {
        InputStreamReader inputStreamReader;
        InputStream resourceAsStream = getClass().getResourceAsStream(str);
        if (resourceAsStream != null) {
            Reader reader = null;
            try {
                if (str.endsWith(".gz")) {
                    inputStreamReader = new InputStreamReader(new GZIPInputStream(new BufferedInputStream(resourceAsStream)));
                } else {
                    inputStreamReader = new InputStreamReader(new BufferedInputStream(resourceAsStream));
                }
                try {
                    MagicEntries readEntries = readEntries(inputStreamReader);
                    closeQuietly(inputStreamReader);
                    closeQuietly(null);
                    return readEntries;
                } catch (Throwable th) {
                    reader = inputStreamReader;
                    th = th;
                    resourceAsStream = null;
                    closeQuietly(reader);
                    closeQuietly(resourceAsStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                closeQuietly(reader);
                closeQuietly(resourceAsStream);
                throw th;
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Internal magic file was not found: ");
            sb.append(str);
            throw new FileNotFoundException(sb.toString());
        }
    }

    private MagicEntries readEntries(Reader reader) throws IOException {
        MagicEntries magicEntries2 = new MagicEntries();
        readEntries(magicEntries2, reader);
        magicEntries2.optimizeFirstBytes();
        return magicEntries2;
    }

    private void readEntries(MagicEntries magicEntries2, Reader reader) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(reader);
        try {
            magicEntries2.readEntries(bufferedReader, this.errorCallBack);
        } finally {
            closeQuietly(bufferedReader);
        }
    }

    private void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
