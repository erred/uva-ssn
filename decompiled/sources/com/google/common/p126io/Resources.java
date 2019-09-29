package com.google.common.p126io;

import com.google.common.annotations.Beta;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

@Beta
/* renamed from: com.google.common.io.Resources */
public final class Resources {

    /* renamed from: com.google.common.io.Resources$UrlByteSource */
    private static final class UrlByteSource extends ByteSource {
        private final URL url;

        private UrlByteSource(URL url2) {
            this.url = (URL) Preconditions.checkNotNull(url2);
        }

        public InputStream openStream() throws IOException {
            return this.url.openStream();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Resources.asByteSource(");
            sb.append(this.url);
            sb.append(")");
            return sb.toString();
        }
    }

    private Resources() {
    }

    @Deprecated
    public static InputSupplier<InputStream> newInputStreamSupplier(URL url) {
        return ByteStreams.asInputSupplier(asByteSource(url));
    }

    public static ByteSource asByteSource(URL url) {
        return new UrlByteSource(url);
    }

    @Deprecated
    public static InputSupplier<InputStreamReader> newReaderSupplier(URL url, Charset charset) {
        return CharStreams.asInputSupplier(asCharSource(url, charset));
    }

    public static CharSource asCharSource(URL url, Charset charset) {
        return asByteSource(url).asCharSource(charset);
    }

    public static byte[] toByteArray(URL url) throws IOException {
        return asByteSource(url).read();
    }

    public static String toString(URL url, Charset charset) throws IOException {
        return asCharSource(url, charset).read();
    }

    public static <T> T readLines(URL url, Charset charset, LineProcessor<T> lineProcessor) throws IOException {
        return CharStreams.readLines(newReaderSupplier(url, charset), lineProcessor);
    }

    public static List<String> readLines(URL url, Charset charset) throws IOException {
        return (List) readLines(url, charset, new LineProcessor<List<String>>() {
            final List<String> result = Lists.newArrayList();

            public boolean processLine(String str) {
                this.result.add(str);
                return true;
            }

            public List<String> getResult() {
                return this.result;
            }
        });
    }

    public static void copy(URL url, OutputStream outputStream) throws IOException {
        asByteSource(url).copyTo(outputStream);
    }

    public static URL getResource(String str) {
        URL resource = ((ClassLoader) Objects.firstNonNull(Thread.currentThread().getContextClassLoader(), Resources.class.getClassLoader())).getResource(str);
        Preconditions.checkArgument(resource != null, "resource %s not found.", str);
        return resource;
    }

    public static URL getResource(Class<?> cls, String str) {
        URL resource = cls.getResource(str);
        Preconditions.checkArgument(resource != null, "resource %s relative to %s not found.", str, cls.getName());
        return resource;
    }
}
