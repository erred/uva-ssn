package p091b.p092a.p097e;

/* renamed from: b.a.e.b */
/* compiled from: ErrorCode */
public enum C1535b {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    REFUSED_STREAM(7),
    CANCEL(8),
    COMPRESSION_ERROR(9),
    CONNECT_ERROR(10),
    ENHANCE_YOUR_CALM(11),
    INADEQUATE_SECURITY(12),
    HTTP_1_1_REQUIRED(13);
    

    /* renamed from: l */
    public final int f4647l;

    private C1535b(int i) {
        this.f4647l = i;
    }

    /* renamed from: a */
    public static C1535b m6189a(int i) {
        C1535b[] values;
        for (C1535b bVar : values()) {
            if (bVar.f4647l == i) {
                return bVar;
            }
        }
        return null;
    }
}
