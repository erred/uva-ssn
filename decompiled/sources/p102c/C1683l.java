package p102c;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: c.l */
/* compiled from: Okio */
public final class C1683l {

    /* renamed from: a */
    static final Logger f5310a = Logger.getLogger(C1683l.class.getName());

    private C1683l() {
    }

    /* renamed from: a */
    public static C1676e m7033a(C1695s sVar) {
        return new C1689n(sVar);
    }

    /* renamed from: a */
    public static C1675d m7032a(C1694r rVar) {
        return new C1688m(rVar);
    }

    /* renamed from: a */
    public static C1694r m7035a(OutputStream outputStream) {
        return m7036a(outputStream, new C1696t());
    }

    /* renamed from: a */
    private static C1694r m7036a(final OutputStream outputStream, final C1696t tVar) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        } else if (tVar != null) {
            return new C1694r() {
                /* renamed from: a_ */
                public void mo6217a_(C1672c cVar, long j) throws IOException {
                    C1698u.m7136a(cVar.f5290b, 0, j);
                    while (j > 0) {
                        C1696t.this.mo6915g();
                        C1691o oVar = cVar.f5289a;
                        int min = (int) Math.min(j, (long) (oVar.f5325c - oVar.f5324b));
                        outputStream.write(oVar.f5323a, oVar.f5324b, min);
                        oVar.f5324b += min;
                        long j2 = (long) min;
                        j -= j2;
                        cVar.f5290b -= j2;
                        if (oVar.f5324b == oVar.f5325c) {
                            cVar.f5289a = oVar.mo6940b();
                            C1692p.m7102a(oVar);
                        }
                    }
                }

                public void flush() throws IOException {
                    outputStream.flush();
                }

                public void close() throws IOException {
                    outputStream.close();
                }

                /* renamed from: a */
                public C1696t mo6306a() {
                    return C1696t.this;
                }

                public String toString() {
                    StringBuilder sb = new StringBuilder();
                    sb.append("sink(");
                    sb.append(outputStream);
                    sb.append(")");
                    return sb.toString();
                }
            };
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    /* renamed from: a */
    public static C1694r m7037a(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        } else if (socket.getOutputStream() != null) {
            C1667a c = m7044c(socket);
            return c.mo6796a(m7036a(socket.getOutputStream(), (C1696t) c));
        } else {
            throw new IOException("socket's output stream == null");
        }
    }

    /* renamed from: a */
    public static C1695s m7039a(InputStream inputStream) {
        return m7040a(inputStream, new C1696t());
    }

    /* renamed from: a */
    private static C1695s m7040a(final InputStream inputStream, final C1696t tVar) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (tVar != null) {
            return new C1695s() {
                /* renamed from: a */
                public long mo6185a(C1672c cVar, long j) throws IOException {
                    int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                    if (i < 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("byteCount < 0: ");
                        sb.append(j);
                        throw new IllegalArgumentException(sb.toString());
                    } else if (i == 0) {
                        return 0;
                    } else {
                        try {
                            C1696t.this.mo6915g();
                            C1691o e = cVar.mo6839e(1);
                            int read = inputStream.read(e.f5323a, e.f5325c, (int) Math.min(j, (long) (8192 - e.f5325c)));
                            if (read == -1) {
                                return -1;
                            }
                            e.f5325c += read;
                            long j2 = (long) read;
                            cVar.f5290b += j2;
                            return j2;
                        } catch (AssertionError e2) {
                            if (C1683l.m7041a(e2)) {
                                throw new IOException(e2);
                            }
                            throw e2;
                        }
                    }
                }

                public void close() throws IOException {
                    inputStream.close();
                }

                /* renamed from: a */
                public C1696t mo6186a() {
                    return C1696t.this;
                }

                public String toString() {
                    StringBuilder sb = new StringBuilder();
                    sb.append("source(");
                    sb.append(inputStream);
                    sb.append(")");
                    return sb.toString();
                }
            };
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    /* renamed from: a */
    public static C1695s m7038a(File file) throws FileNotFoundException {
        if (file != null) {
            return m7039a((InputStream) new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    /* renamed from: b */
    public static C1694r m7042b(File file) throws FileNotFoundException {
        if (file != null) {
            return m7035a((OutputStream) new FileOutputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    /* renamed from: c */
    public static C1694r m7045c(File file) throws FileNotFoundException {
        if (file != null) {
            return m7035a((OutputStream) new FileOutputStream(file, true));
        }
        throw new IllegalArgumentException("file == null");
    }

    /* renamed from: a */
    public static C1694r m7034a() {
        return new C1694r() {
            public void close() throws IOException {
            }

            public void flush() throws IOException {
            }

            /* renamed from: a_ */
            public void mo6217a_(C1672c cVar, long j) throws IOException {
                cVar.mo6850h(j);
            }

            /* renamed from: a */
            public C1696t mo6306a() {
                return C1696t.f5334c;
            }
        };
    }

    /* renamed from: b */
    public static C1695s m7043b(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        } else if (socket.getInputStream() != null) {
            C1667a c = m7044c(socket);
            return c.mo6797a(m7040a(socket.getInputStream(), (C1696t) c));
        } else {
            throw new IOException("socket's input stream == null");
        }
    }

    /* renamed from: c */
    private static C1667a m7044c(final Socket socket) {
        return new C1667a() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public IOException mo6376a(IOException iOException) {
                SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo6377a() {
                try {
                    socket.close();
                } catch (Exception e) {
                    // Logger logger = C1683l.f5310a;
                    Level level = Level.WARNING;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to close timed out socket ");
                    sb.append(socket);
                    logger.log(level, sb.toString(), e);
                } catch (AssertionError e2) {
                    if (C1683l.m7041a(e2)) {
                        // Logger logger2 = C1683l.f5310a;
                        Level level2 = Level.WARNING;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Failed to close timed out socket ");
                        sb2.append(socket);
                        logger2.log(level2, sb2.toString(), e2);
                        return;
                    }
                    throw e2;
                }
            }
        };
    }

    /* renamed from: a */
    static boolean m7041a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}
