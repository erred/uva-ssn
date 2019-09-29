package twitter4j.auth;

import java.io.ObjectStreamException;
import java.io.Serializable;
import twitter4j.HttpRequest;

public class NullAuthorization implements Serializable, Authorization {
    private static final NullAuthorization SINGLETON = new NullAuthorization();
    private static final long serialVersionUID = -7704668493278727510L;

    public String getAuthorizationHeader(HttpRequest httpRequest) {
        return null;
    }

    public boolean isEnabled() {
        return false;
    }

    public String toString() {
        return "NullAuthentication{SINGLETON}";
    }

    private NullAuthorization() {
    }

    public static NullAuthorization getInstance() {
        return SINGLETON;
    }

    public boolean equals(Object obj) {
        return SINGLETON == obj;
    }

    private Object readResolve() throws ObjectStreamException {
        return SINGLETON;
    }
}
