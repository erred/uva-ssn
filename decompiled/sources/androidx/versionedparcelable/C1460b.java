package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;

/* renamed from: androidx.versionedparcelable.b */
/* compiled from: VersionedParcelParcel */
class C1460b extends C1459a {

    /* renamed from: a */
    private final SparseIntArray f4346a;

    /* renamed from: b */
    private final Parcel f4347b;

    /* renamed from: c */
    private final int f4348c;

    /* renamed from: d */
    private final int f4349d;

    /* renamed from: e */
    private final String f4350e;

    /* renamed from: f */
    private int f4351f;

    /* renamed from: g */
    private int f4352g;

    C1460b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "");
    }

    C1460b(Parcel parcel, int i, int i2, String str) {
        this.f4346a = new SparseIntArray();
        this.f4351f = -1;
        this.f4352g = 0;
        this.f4347b = parcel;
        this.f4348c = i;
        this.f4349d = i2;
        this.f4352g = this.f4348c;
        this.f4350e = str;
    }

    /* renamed from: d */
    private int m5839d(int i) {
        while (this.f4352g < this.f4349d) {
            this.f4347b.setDataPosition(this.f4352g);
            int readInt = this.f4347b.readInt();
            int readInt2 = this.f4347b.readInt();
            this.f4352g += readInt;
            if (readInt2 == i) {
                return this.f4347b.dataPosition();
            }
        }
        return -1;
    }

    /* renamed from: b */
    public boolean mo6049b(int i) {
        int d = m5839d(i);
        if (d == -1) {
            return false;
        }
        this.f4347b.setDataPosition(d);
        return true;
    }

    /* renamed from: c */
    public void mo6052c(int i) {
        mo6048b();
        this.f4351f = i;
        this.f4346a.put(i, this.f4347b.dataPosition());
        mo6032a(0);
        mo6032a(i);
    }

    /* renamed from: b */
    public void mo6048b() {
        if (this.f4351f >= 0) {
            int i = this.f4346a.get(this.f4351f);
            int dataPosition = this.f4347b.dataPosition();
            int i2 = dataPosition - i;
            this.f4347b.setDataPosition(i);
            this.f4347b.writeInt(i2);
            this.f4347b.setDataPosition(dataPosition);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public C1459a mo6051c() {
        Parcel parcel = this.f4347b;
        int dataPosition = this.f4347b.dataPosition();
        int i = this.f4352g == this.f4348c ? this.f4349d : this.f4352g;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f4350e);
        sb.append("  ");
        return new C1460b(parcel, dataPosition, i, sb.toString());
    }

    /* renamed from: a */
    public void mo6041a(byte[] bArr) {
        if (bArr != null) {
            this.f4347b.writeInt(bArr.length);
            this.f4347b.writeByteArray(bArr);
            return;
        }
        this.f4347b.writeInt(-1);
    }

    /* renamed from: a */
    public void mo6032a(int i) {
        this.f4347b.writeInt(i);
    }

    /* renamed from: a */
    public void mo6038a(String str) {
        this.f4347b.writeString(str);
    }

    /* renamed from: a */
    public void mo6034a(Parcelable parcelable) {
        this.f4347b.writeParcelable(parcelable, 0);
    }

    /* renamed from: d */
    public int mo6053d() {
        return this.f4347b.readInt();
    }

    /* renamed from: e */
    public String mo6054e() {
        return this.f4347b.readString();
    }

    /* renamed from: f */
    public byte[] mo6055f() {
        int readInt = this.f4347b.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.f4347b.readByteArray(bArr);
        return bArr;
    }

    /* renamed from: g */
    public <T extends Parcelable> T mo6056g() {
        return this.f4347b.readParcelable(getClass().getClassLoader());
    }
}
