package p091b;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

/* renamed from: b.o */
/* compiled from: Dns */
public interface C1631o {

    /* renamed from: a */
    public static final C1631o f5142a = new C1631o() {
        /* renamed from: a */
        public List<InetAddress> mo6608a(String str) throws UnknownHostException {
            if (str != null) {
                try {
                    return Arrays.asList(InetAddress.getAllByName(str));
                } catch (NullPointerException e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Broken system behaviour for dns lookup of ");
                    sb.append(str);
                    UnknownHostException unknownHostException = new UnknownHostException(sb.toString());
                    unknownHostException.initCause(e);
                    throw unknownHostException;
                }
            } else {
                throw new UnknownHostException("hostname == null");
            }
        }
    };

    /* renamed from: a */
    List<InetAddress> mo6608a(String str) throws UnknownHostException;
}
