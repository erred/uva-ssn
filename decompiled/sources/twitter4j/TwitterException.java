package twitter4j;

import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.util.List;
import p140me.bridgefy.ormlite.entities.MessageDTO;

public class TwitterException extends Exception implements HttpResponseCode, TwitterResponse {
    private static final String[] FILTER = {"twitter4j"};
    private static final long serialVersionUID = 6006561839051121336L;
    private int errorCode;
    private String errorMessage;
    private ExceptionDiagnosis exceptionDiagnosis;
    private boolean nested;
    private HttpResponse response;
    private int statusCode;

    public TwitterException(String str, Throwable th) {
        super(str, th);
        this.statusCode = -1;
        this.errorCode = -1;
        this.exceptionDiagnosis = null;
        this.errorMessage = null;
        this.nested = false;
        decode(str);
    }

    public TwitterException(String str) {
        this(str, (Throwable) null);
    }

    public TwitterException(Exception exc) {
        this(exc.getMessage(), (Throwable) exc);
        if (exc instanceof TwitterException) {
            ((TwitterException) exc).setNested();
        }
    }

    public TwitterException(String str, HttpResponse httpResponse) {
        this(str);
        this.response = httpResponse;
        this.statusCode = httpResponse.getStatusCode();
    }

    public TwitterException(String str, Exception exc, int i) {
        this(str, (Throwable) exc);
        this.statusCode = i;
    }

    public String getMessage() {
        StringBuilder sb = new StringBuilder();
        if (this.errorMessage == null || this.errorCode == -1) {
            sb.append(super.getMessage());
        } else {
            sb.append("message - ");
            sb.append(this.errorMessage);
            sb.append("\n");
            sb.append("code - ");
            sb.append(this.errorCode);
            sb.append("\n");
        }
        if (this.statusCode == -1) {
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getCause(this.statusCode));
        sb2.append("\n");
        sb2.append(sb.toString());
        return sb2.toString();
    }

    private void decode(String str) {
        if (str != null && str.startsWith("{")) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull("errors")) {
                    JSONObject jSONObject2 = jSONObject.getJSONArray("errors").getJSONObject(0);
                    this.errorMessage = jSONObject2.getString(MessageDTO.MESSAGE);
                    this.errorCode = ParseUtil.getInt("code", jSONObject2);
                }
            } catch (JSONException unused) {
            }
        }
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getResponseHeader(String str) {
        if (this.response != null) {
            List list = (List) this.response.getResponseHeaderFields().get(str);
            if (list.size() > 0) {
                return (String) list.get(0);
            }
        }
        return null;
    }

    public RateLimitStatus getRateLimitStatus() {
        if (this.response == null) {
            return null;
        }
        return JSONImplFactory.createRateLimitStatusFromResponseHeader(this.response);
    }

    public int getAccessLevel() {
        return ParseUtil.toAccessLevel(this.response);
    }

    public int getRetryAfter() {
        if (this.statusCode == 400) {
            RateLimitStatus rateLimitStatus = getRateLimitStatus();
            if (rateLimitStatus != null) {
                return rateLimitStatus.getSecondsUntilReset();
            }
            return -1;
        } else if (this.statusCode != 420) {
            return -1;
        } else {
            try {
                String responseHeader = this.response.getResponseHeader(HttpHeaders.RETRY_AFTER);
                if (responseHeader != null) {
                    return Integer.valueOf(responseHeader).intValue();
                }
                return -1;
            } catch (NumberFormatException unused) {
                return -1;
            }
        }
    }

    public boolean isCausedByNetworkIssue() {
        return getCause() instanceof IOException;
    }

    public boolean exceededRateLimitation() {
        return (this.statusCode == 400 && getRateLimitStatus() != null) || this.statusCode == 420 || this.statusCode == 429;
    }

    public boolean resourceNotFound() {
        return this.statusCode == 404;
    }

    public String getExceptionCode() {
        return getExceptionDiagnosis().asHexString();
    }

    private ExceptionDiagnosis getExceptionDiagnosis() {
        if (this.exceptionDiagnosis == null) {
            this.exceptionDiagnosis = new ExceptionDiagnosis(this, FILTER);
        }
        return this.exceptionDiagnosis;
    }

    /* access modifiers changed from: 0000 */
    public void setNested() {
        this.nested = true;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public boolean isErrorMessageAvailable() {
        return this.errorMessage != null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TwitterException twitterException = (TwitterException) obj;
        if (this.errorCode != twitterException.errorCode || this.nested != twitterException.nested || this.statusCode != twitterException.statusCode) {
            return false;
        }
        if (this.errorMessage == null ? twitterException.errorMessage != null : !this.errorMessage.equals(twitterException.errorMessage)) {
            return false;
        }
        if (this.exceptionDiagnosis == null ? twitterException.exceptionDiagnosis == null : this.exceptionDiagnosis.equals(twitterException.exceptionDiagnosis)) {
            return this.response == null ? twitterException.response == null : this.response.equals(twitterException.response);
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((((this.statusCode * 31) + this.errorCode) * 31) + (this.exceptionDiagnosis != null ? this.exceptionDiagnosis.hashCode() : 0)) * 31) + (this.response != null ? this.response.hashCode() : 0)) * 31;
        if (this.errorMessage != null) {
            i = this.errorMessage.hashCode();
        }
        return ((hashCode + i) * 31) + (this.nested ? 1 : 0);
    }

    public String toString() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append(getMessage());
        if (this.nested) {
            str = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("\nRelevant discussions can be found on the Internet at:\n\thttp://www.google.co.jp/search?q=");
            sb2.append(getExceptionDiagnosis().getStackLineHashAsHex());
            sb2.append(" or\n\thttp://www.google.co.jp/search?q=");
            sb2.append(getExceptionDiagnosis().getLineNumberHashAsHex());
            str = sb2.toString();
        }
        sb.append(str);
        sb.append("\nTwitterException{");
        if (this.nested) {
            str2 = "";
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("exceptionCode=[");
            sb3.append(getExceptionCode());
            sb3.append("], ");
            str2 = sb3.toString();
        }
        sb.append(str2);
        sb.append("statusCode=");
        sb.append(this.statusCode);
        sb.append(", message=");
        sb.append(this.errorMessage);
        sb.append(", code=");
        sb.append(this.errorCode);
        sb.append(", retryAfter=");
        sb.append(getRetryAfter());
        sb.append(", rateLimitStatus=");
        sb.append(getRateLimitStatus());
        sb.append(", version=");
        sb.append(Version.getVersion());
        sb.append('}');
        return sb.toString();
    }

    private static String getCause(int i) {
        String str;
        switch (i) {
            case 304:
                str = "There was no new data to return.";
                break;
            case 400:
                str = "The request was invalid. An accompanying error message will explain why. This is the status code will be returned during version 1.0 rate limiting(https://dev.twitter.com/pages/rate-limiting). In API v1.1, a request without authentication is considered invalid and you will get this response.";
                break;
            case 401:
                str = "Authentication credentials (https://dev.twitter.com/pages/auth) were missing or incorrect. Ensure that you have set valid consumer key/secret, access token/secret, and the system clock is in sync.";
                break;
            case 403:
                str = "The request is understood, but it has been refused. An accompanying error message will explain why. This code is used when requests are being denied due to update limits (https://support.twitter.com/articles/15364-about-twitter-limits-update-api-dm-and-following).";
                break;
            case 404:
                str = "The URI requested is invalid or the resource requested, such as a user, does not exists. Also returned when the requested format is not supported by the requested method.";
                break;
            case HttpResponseCode.NOT_ACCEPTABLE /*406*/:
                str = "Returned by the Search API when an invalid format is specified in the request.\nReturned by the Streaming API when one or more of the parameters are not suitable for the resource. The track parameter, for example, would throw this error if:\n The track keyword is too long or too short.\n The bounding box specified is invalid.\n No predicates defined for filtered resource, for example, neither track nor follow parameter defined.\n Follow userid cannot be read.";
                break;
            case HttpResponseCode.ENHANCE_YOUR_CLAIM /*420*/:
                str = "Returned by the Search and Trends API when you are being rate limited (https://dev.twitter.com/docs/rate-limiting).\nReturned by the Streaming API:\n Too many login attempts in a short period of time.\n Running too many copies of the same application authenticating with the same account name.";
                break;
            case 422:
                str = "Returned when an image uploaded to POST account/update_profile_banner(https://dev.twitter.com/docs/api/1/post/account/update_profile_banner) is unable to be processed.";
                break;
            case HttpResponseCode.TOO_MANY_REQUESTS /*429*/:
                str = "Returned in API v1.1 when a request cannot be served due to the application's rate limit having been exhausted for the resource. See Rate Limiting in API v1.1.(https://dev.twitter.com/docs/rate-limiting/1.1)";
                break;
            case 500:
                str = "Something is broken. Please post to the group (https://dev.twitter.com/docs/support) so the Twitter team can investigate.";
                break;
            case 502:
                str = "Twitter is down or being upgraded.";
                break;
            case 503:
                str = "The Twitter servers are up, but overloaded with requests. Try again later.";
                break;
            case HttpResponseCode.GATEWAY_TIMEOUT /*504*/:
                str = "The Twitter servers are up, but the request couldn't be serviced due to some failure within our stack. Try again later.";
                break;
            default:
                str = "";
                break;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append(":");
        sb.append(str);
        return sb.toString();
    }
}
