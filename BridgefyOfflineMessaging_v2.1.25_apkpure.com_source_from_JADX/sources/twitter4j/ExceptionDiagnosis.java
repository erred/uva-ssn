package twitter4j;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.io.Serializable;

final class ExceptionDiagnosis implements Serializable {
    private static final long serialVersionUID = 8501009773274399369L;
    private String hexString;
    private int lineNumberHash;
    private int stackLineHash;

    ExceptionDiagnosis(Throwable th) {
        this(th, new String[0]);
    }

    ExceptionDiagnosis(Throwable th, String[] strArr) {
        this.hexString = "";
        StackTraceElement[] stackTrace = th.getStackTrace();
        this.stackLineHash = 0;
        this.lineNumberHash = 0;
        for (int length = stackTrace.length - 1; length >= 0; length--) {
            StackTraceElement stackTraceElement = stackTrace[length];
            int length2 = strArr.length;
            int i = 0;
            while (true) {
                if (i >= length2) {
                    break;
                }
                if (stackTraceElement.getClassName().startsWith(strArr[i])) {
                    this.stackLineHash = (this.stackLineHash * 31) + stackTraceElement.getClassName().hashCode() + stackTraceElement.getMethodName().hashCode();
                    this.lineNumberHash = (this.lineNumberHash * 31) + stackTraceElement.getLineNumber();
                    break;
                }
                i++;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.hexString);
        sb.append(toHexString(this.stackLineHash));
        sb.append("-");
        sb.append(toHexString(this.lineNumberHash));
        this.hexString = sb.toString();
        if (th.getCause() != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.hexString);
            sb2.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            sb2.append(new ExceptionDiagnosis(th.getCause(), strArr).asHexString());
            this.hexString = sb2.toString();
        }
    }

    /* access modifiers changed from: 0000 */
    public int getStackLineHash() {
        return this.stackLineHash;
    }

    /* access modifiers changed from: 0000 */
    public String getStackLineHashAsHex() {
        return toHexString(this.stackLineHash);
    }

    /* access modifiers changed from: 0000 */
    public int getLineNumberHash() {
        return this.lineNumberHash;
    }

    /* access modifiers changed from: 0000 */
    public String getLineNumberHashAsHex() {
        return toHexString(this.lineNumberHash);
    }

    /* access modifiers changed from: 0000 */
    public String asHexString() {
        return this.hexString;
    }

    private String toHexString(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("0000000");
        sb.append(Integer.toHexString(i));
        String sb2 = sb.toString();
        return sb2.substring(sb2.length() - 8, sb2.length());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ExceptionDiagnosis exceptionDiagnosis = (ExceptionDiagnosis) obj;
        return this.lineNumberHash == exceptionDiagnosis.lineNumberHash && this.stackLineHash == exceptionDiagnosis.stackLineHash;
    }

    public int hashCode() {
        return (this.stackLineHash * 31) + this.lineNumberHash;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ExceptionDiagnosis{stackLineHash=");
        sb.append(this.stackLineHash);
        sb.append(", lineNumberHash=");
        sb.append(this.lineNumberHash);
        sb.append('}');
        return sb.toString();
    }
}
