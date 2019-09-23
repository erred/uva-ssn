package twitter4j;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

public class HttpResponseImpl extends HttpResponse {
    private HttpURLConnection con;

    HttpResponseImpl(HttpURLConnection httpURLConnection, HttpClientConfiguration httpClientConfiguration) throws IOException {
        super(httpClientConfiguration);
        this.con = httpURLConnection;
        try {
            this.statusCode = httpURLConnection.getResponseCode();
        } catch (IOException e) {
            if ("Received authentication challenge is null".equals(e.getMessage())) {
                this.statusCode = httpURLConnection.getResponseCode();
            } else {
                throw e;
            }
        }
        InputStream errorStream = httpURLConnection.getErrorStream();
        this.f9918is = errorStream;
        if (errorStream == null) {
            this.f9918is = httpURLConnection.getInputStream();
        }
        if (this.f9918is != null && "gzip".equals(httpURLConnection.getContentEncoding())) {
            this.f9918is = new StreamingGZIPInputStream(this.f9918is);
        }
    }

    HttpResponseImpl(String str) {
        this.responseAsString = str;
    }

    public String getResponseHeader(String str) {
        return this.con.getHeaderField(str);
    }

    public Map<String, List<String>> getResponseHeaderFields() {
        return this.con.getHeaderFields();
    }

    public void disconnect() {
        this.con.disconnect();
    }
}
